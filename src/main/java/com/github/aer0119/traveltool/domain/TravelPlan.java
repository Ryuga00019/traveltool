package com.github.aer0119.traveltool.domain;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Data
public class TravelPlan {
    @Getter
    private UUID planId;
    private String title;
    private String description;
    private Date travelDate;

    @Getter
    private ArrayList<TravelPlace> travelPlaces;

    public TravelPlan() {
        this.planId = UUID.randomUUID();
        this.travelPlaces = new ArrayList<>();
    }

    public TravelPlan(UUID planId, String title, String description, Date travelDate, ArrayList<TravelPlace> travelPlaces) {
        this.planId = planId;
        this.title = title;
        this.description = description;
        this.travelDate = travelDate;
        this.travelPlaces = travelPlaces;
    }
}
