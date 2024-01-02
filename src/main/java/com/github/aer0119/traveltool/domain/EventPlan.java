package com.github.aer0119.traveltool.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class EventPlan {
    private UUID eventPlanId;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private ArrayList<EventContent> eventContents;


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

