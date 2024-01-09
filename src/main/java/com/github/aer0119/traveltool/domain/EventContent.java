package com.github.aer0119.traveltool.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventContent {
    private final UUID eventPlanItemId; //dayID > 1日目、2日目 >startDateTime-endDateTime <<<ちがう。
    private String contentName; //place name
    private String description;
    private LocalDateTime startDateTime; //00:00 - 24:00 滞在、経過時間(開始)
    private LocalDateTime endDateTime; //00:00 - 24:00 滞在、経過時間(終了)

    public EventContent() {
        this.eventPlanItemId = UUID.randomUUID();
    }

    public EventContent(UUID eventPlanItemId, String contentName, String description, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.eventPlanItemId = eventPlanItemId;
        this.contentName = contentName;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }


    public UUID getEventPlanItemId() {
        return eventPlanItemId;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}
