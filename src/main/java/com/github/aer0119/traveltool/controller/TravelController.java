package com.github.aer0119.traveltool.controller;

import com.github.aer0119.traveltool.domain.EventContent;
import com.github.aer0119.traveltool.domain.EventPlan;
import com.github.aer0119.traveltool.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("/edit")
    public String index(Model model){
        var list=new ArrayList<EventContent>();
        var content = new EventContent();
        content.setContentName("abc");
        content.setDescription("setumei");
        content.setStartDateTime(LocalDateTime.now());
        content.setEndDateTime(LocalDateTime.now());
        list.add(content);
        var eventPlan= new EventPlan(UUID.randomUUID(),"nn","setumei", LocalDate.now(),LocalDate.now(),list);
        model.addAttribute("eventplan",eventPlan);
        return "edit";
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

        return "redirect:/edit";
    }
}