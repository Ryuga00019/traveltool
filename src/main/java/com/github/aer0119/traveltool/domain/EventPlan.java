package com.github.aer0119.traveltool.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class EventPlan {
    private final UUID eventPlanId;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private final ArrayList<EventContent> eventContents;

    public EventPlan() {
        this.eventPlanId = UUID.randomUUID();
        this.eventContents = new ArrayList<>();
    }

    public EventPlan(UUID eventPlanId, String title, String description, Date startDate, Date endDate, ArrayList<EventContent> eventContents) {
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

    public Date getStartDate(){
        return startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate=startDate;
    }


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

