package com.github.aer0119.traveltool.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class EventPlan {
    private final UUID eventPlanId;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private final ArrayList<EventContent> eventContents;

    public EventPlan() {
        this.eventPlanId = UUID.randomUUID();
        this.eventContents = new ArrayList<>();
    }

    public EventPlan(UUID eventPlanId, String title, String description, LocalDate startDate, LocalDate endDate, ArrayList<EventContent> eventContents) {
        this.eventPlanId = eventPlanId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventContents = eventContents;
    }


    public UUID getEventPlanId(){
        return eventPlanId;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
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
}

