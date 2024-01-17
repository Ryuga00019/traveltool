package com.github.aer0119.traveltool.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalTime;
import java.util.UUID;

@JsonSerialize
public class EventContent {
    private final UUID eventPlanItemId; //dayID > 1日目、2日目 >startDateTime-endDateTime <<<ちがう。
    private String contentName; //place name
    private String description;
    private int day;
    private LocalTime startTime; //00:00 - 24:00 滞在、経過時間(開始)
    private LocalTime endTime; //00:00 - 24:00 滞在、経過時間(終了)

    public EventContent() {
        this.eventPlanItemId = UUID.randomUUID();
    }

    public EventContent(UUID eventPlanItemId, String contentName, String description, LocalTime startTime, LocalTime endTime) {
        this.eventPlanItemId = eventPlanItemId;
        this.contentName = contentName;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
