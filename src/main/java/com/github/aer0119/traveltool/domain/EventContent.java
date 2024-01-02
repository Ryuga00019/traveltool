package com.github.aer0119.traveltool.domain;

import java.util.Date;
import java.util.UUID;

public class EventContent {
    private final UUID eventPlanItemId;
    private String contentName;
    private String description;
    private Date startDate;
    private Date endDate;

    public EventContent() {
        this.eventPlanItemId = UUID.randomUUID();
    }

    public EventContent(UUID eventPlanItemId, String contentName, String description, Date startDate, Date endDate) {
        this.eventPlanItemId = eventPlanItemId;
        this.contentName = contentName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }


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
