package com.github.aer0119.traveltool.controller;

import com.github.aer0119.traveltool.domain.EventContent;
import com.github.aer0119.traveltool.domain.EventPlan;
import com.github.aer0119.traveltool.repository.EventPlanRepository;
import com.github.aer0119.traveltool.service.TravelPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class TravelController {
    private final EventPlanRepository eventPlanRepository;
    @Autowired
    public TravelController(EventPlanRepository eventPlanRepository) {
        this.eventPlanRepository = eventPlanRepository;

    }


    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        var eventPlan = new EventPlan();
        model.addAttribute("eventPlan", eventPlan);
        model.addAttribute("startDay", "FirstDay");
        model.addAttribute("endDay", "LastDay");
        return "createplan";
    }

    @PostMapping("/create/save")
    public String createSave(@ModelAttribute EventPlan eventplan) {
        eventPlanRepository.save(eventplan);
        return "redirect:/" + eventplan.getEventPlanId().toString() + "/edit";
    }

    @GetMapping("/{planId}/edit")
    public String edit(Model model, @PathVariable String planId) {
        var eventPlan = eventPlanRepository.find(UUID.fromString(planId));
        var eventDate = ChronoUnit.DAYS.between(eventPlan.getStartDate(), eventPlan.getEndDate());
        var sortedContents = eventPlan.getSortedContents();
        model.addAttribute("eventPlan", eventPlan);
        model.addAttribute("eventDate", eventDate);
        model.addAttribute("sortedContents", sortedContents);
        return "/edit";
    }

    //@GetMapping("/{planId}/edit/form")
    @GetMapping("/{planId}/addcontent")
    public String contentForm(Model model,@PathVariable String planId){
        var eventPlan = eventPlanRepository.find(UUID.fromString(planId));
        var eventDate = ChronoUnit.DAYS.between(eventPlan.getStartDate(), eventPlan.getEndDate());
        var eventContent= new EventContent();
        System.out.println("=======" + eventContent.getEventPlanItemId() + "=============");
        model.addAttribute("eventDate", eventDate);
        model.addAttribute("eventContent", eventContent);
        return "/contentform";
    }

    //@PostMapping("/{planId}/edit/save")
    @PostMapping("/{planId}/savecontent")
    public String contentForm(@ModelAttribute EventContent eventContent, @PathVariable String planId, @RequestParam(required = false) String contentId){
        var eventPlan = eventPlanRepository.find(UUID.fromString(planId));
        var content = eventPlan.getEventContent(UUID.fromString(contentId));
        if (content != null) {
            content.setContentName(eventContent.getContentName());
            content.setDescription(eventContent.getDescription());
            content.setDay(eventContent.getDay());
            content.setStartTime(eventContent.getStartTime());
            content.setEndTime(eventContent.getEndTime());
            return "redirect:/" + planId + "/edit";
        }
        eventPlan.addEventContent(eventContent);
        return "redirect:/" + planId + "/edit";
    }

    @GetMapping("/{planId}/editcontent")
    public String contentEdit(Model model, @PathVariable String planId, @RequestParam String contentId) {
        var eventPlan = eventPlanRepository.find(UUID.fromString(planId));
        var eventDate = ChronoUnit.DAYS.between(eventPlan.getStartDate(), eventPlan.getEndDate());
        var eventContent= eventPlan.getEventContent(UUID.fromString(contentId));
        System.out.println("==============");
        System.out.println(eventContent.getEventPlanItemId());
        System.out.println("==============");
        model.addAttribute("eventDate", eventDate);
        model.addAttribute("eventContent", eventContent);
        return "/contentform";
    }

    @GetMapping("/shopMap")
    public String getShopMap(Model model) {
        return "map";
    }

    @GetMapping("/view")
    public String view(Model model, @RequestParam String planId) {
        return "";
    }
}