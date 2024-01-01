package com.github.aer0119.traveltool.service;

import com.github.aer0119.traveltool.domain.TravelPlan;
import org.springframework.stereotype.Service;

@Service
public class TravelPlanService {
    public TravelPlan createPlan() {
        return new TravelPlan();
    }
}
