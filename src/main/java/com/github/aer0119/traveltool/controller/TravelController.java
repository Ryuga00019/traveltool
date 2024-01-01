package com.github.aer0119.traveltool.controller;



import com.github.aer0119.traveltool.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TravelController {
    private final TravelPlanService travelPlanService;

    @Autowired
    public TravelController(TravelPlanService travelPlanService) {
        this.travelPlanService = travelPlanService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        var plan = travelPlanService.createPlan();
        model.addAttribute("plan", plan);

        return "createplan";
    }
}