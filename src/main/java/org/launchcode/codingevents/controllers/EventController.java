package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<Event> events = new ArrayList<>();

    //lives at /events
    @GetMapping
    //@ResponseBody  // debug only
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Evants");
        model.addAttribute("events", events);
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        System.out.println("InGetMap");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName,
                                @RequestParam String eventDescription) {
        events.add(new Event(eventName, eventDescription));
        return "redirect:";
        }
    }

