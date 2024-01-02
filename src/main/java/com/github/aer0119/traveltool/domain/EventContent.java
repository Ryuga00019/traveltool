package com.github.aer0119.traveltool.domain;

import java.util.Date;
import java.util.UUID;

public class EventContent {
    private UUID eventPlanItemId;
    private String contentName;
    private String description;
    private Date startDate;
    private Date endDate;

    public UUID getEventPlanItemId() {
        return eventPlanItemId;
    }

    public String getPlanName() {
        return contentName;
    }

    public void setPlanName(String contentName) {
        this.contentName = contentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
