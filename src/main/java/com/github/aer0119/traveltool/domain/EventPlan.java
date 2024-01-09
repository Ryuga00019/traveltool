package com.github.aer0119.traveltool.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventPlan {
    private final UUID eventPlanId; //num
    private String placeName;
    private String description;  //setsu
    private LocalDate startDate; //旅行初日
    private LocalDate endDate; //旅行最終日
    private final ArrayList<EventContent> eventContents;



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

    public List<EventContent> getEventContents() {
        return List.copyOf(eventContents);
    }
}

