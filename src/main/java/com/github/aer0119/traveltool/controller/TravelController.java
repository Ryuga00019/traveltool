package com.github.aer0119.traveltool.controller;

import com.github.aer0119.traveltool.domain.EventContent;
import com.github.aer0119.traveltool.domain.EventPlan;
import com.github.aer0119.traveltool.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class TravelController {
    private final TravelPlanService travelPlanService;

    @Autowired
    public TravelController(TravelPlanService travelPlanService) {
        this.travelPlanService = travelPlanService;
    }


    @GetMapping("/")
    public String index(Model model) {
        return "/";
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
        //TODO("ここで保存")
        return "redirect:/edit?planId=" + eventplan.getEventPlanId().toString();
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam String planId) {
        return "";
    }

    @GetMapping("/view")
    public String view(Model model, @RequestParam String planId) {
        return "";
    }
}