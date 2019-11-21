package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    //lives at /events
    @GetMapping
    //@ResponseBody  // debug only
    public String displayAllEvents(Model model) {
        System.out.println("InGetMapNull");
        //System.out.println(events.size());
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
        public String createEvent (@RequestParam String eventName){
            System.out.println("InPostMap");
            events.add(eventName);
            //System.out.println(events);
            return "redirect:";
        }
    }


  /*
    //lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:";
    }

   */

