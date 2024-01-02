package com.github.aer0119.traveltool.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class TravelPlan {
    private final UUID planId;
    private String title;
    private String description;
    private Date travelDate;

    private final ArrayList<TravelPlace> travelPlaces;

    public TravelPlan() {
        this.planId = UUID.randomUUID();
        this.title = "";
        this.description = "";
        this.travelDate = Date.from(Instant.now());
        this.travelPlaces = new ArrayList<>();
    }

    public TravelPlan(UUID planId, String title, String description, Date travelDate, ArrayList<TravelPlace> travelPlaces) {
        this.planId = planId;
        this.title = title;
        this.description = description;
        this.travelDate = travelDate;
        this.travelPlaces = travelPlaces;
    }

    public void addPlace(TravelPlace place) {
        travelPlaces.add(place);
    }

    public UUID getPlanId() {
        return planId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public Date getTravelDate() {
        return travelDate;
    }
}
