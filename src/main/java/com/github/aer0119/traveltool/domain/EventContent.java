package com.github.aer0119.traveltool.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventContent {
    private final UUID eventPlanItemId; //num
    private String contentName; //place
    private String description;
    private LocalDateTime startDate; //00:00 - 24:00 滞在、経過時間(開始)
    private LocalDateTime endDate; //00:00 - 24:00 滞在、経過時間(終了)

    public EventContent() {
        this.eventPlanItemId = UUID.randomUUID();
    }

    public EventContent(UUID eventPlanItemId, String contentName, String description, LocalDateTime startDate, LocalDateTime endDate) {
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
