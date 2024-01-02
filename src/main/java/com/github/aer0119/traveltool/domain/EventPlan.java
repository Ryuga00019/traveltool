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
}
