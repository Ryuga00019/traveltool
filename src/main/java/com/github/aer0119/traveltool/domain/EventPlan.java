package com.github.aer0119.traveltool.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

public class EventPlan {
    private final UUID eventPlanId; //num
    private String placeName; //という名のtitle
    private String description;  //setsu
    private LocalDate startDate; //旅行初日
    private LocalDate endDate; //旅行最終日
    private final ArrayList<EventContent> eventContents; //Contentデータ



    public EventPlan() {
        this.eventPlanId = UUID.randomUUID();
        this.eventContents = new ArrayList<>();
    }

    public EventPlan(UUID eventPlanId, String placeName, String description, LocalDate startDate, LocalDate endDate, ArrayList<EventContent> eventContents) {
        this.eventPlanId = eventPlanId;
        this.placeName = placeName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventContents = eventContents;
    }


    public UUID getEventPlanId(){
        return eventPlanId;
    }

    public String getPlaceName(){
        return placeName;
    }

    public void setPlaceName(String placeName){
        this.placeName=placeName;
    }


    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate=startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void addEventContent(EventContent eventContent){
        eventContents.add(eventContent);
    }

    public void deleteEventContent(UUID contentId) {
        eventContents.removeIf(it -> it.getEventPlanItemId() == contentId);
    }

    public EventContent getEventContent(UUID contentId) {
        var eventContent = eventContents.stream()
                .filter(it -> it.getEventPlanItemId().equals(contentId)).findFirst();

        return eventContent.orElse(null);
    }

    public Map<Integer ,ArrayList<EventContent>> getSortedContents() {
        var between = (int) ChronoUnit.DAYS.between(startDate, endDate);
        Map<Integer, ArrayList<EventContent>> result = new HashMap<>();
        for (var i = 0; i <= between; i++) result.put(i, new ArrayList<>());

        var contents = new ArrayList<>(List.copyOf(eventContents));
        var comparator = new Comparator<EventContent>() {
            @Override
            public int compare(EventContent o1, EventContent o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        };
        contents.sort(comparator);

        for (var content: contents) {
            result.get(content.getDay()).add(content);
        }

        return result;
    }

    public List<EventContent> getEventContents() {
        return List.copyOf(eventContents);
    }
}

