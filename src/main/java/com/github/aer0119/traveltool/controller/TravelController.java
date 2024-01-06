package com.github.aer0119.traveltool.controller;

import com.github.aer0119.traveltool.domain.EventPlan;
import com.github.aer0119.traveltool.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TravelController {
    private final TravelPlanService travelPlanService;

    @Autowired
    public TravelController(TravelPlanService travelPlanService) {
        this.travelPlanService = travelPlanService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        var eventPlan = new EventPlan();
        model.addAttribute("eventPlan", eventPlan);
        model.addAttribute("places", "PlacesName");
        model.addAttribute("startDay", "FirstDay");
        model.addAttribute("endDay", "LastDay");
        return "createplan";
    }
    @PostMapping("/create/save")
    public String createSave(@ModelAttribute EventPlan eventplan) {

        return "redirect:/index";
    }
}