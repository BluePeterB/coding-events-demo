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
<<<<<<< HEAD
        System.out.println("InGetMapNull");
        //System.out.println(events.size());
=======
        model.addAttribute("title", "All Events");
>>>>>>> 7086f8331ed4f41eb1b85d8cc9a08683d726c89b
        model.addAttribute("events", events);
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
<<<<<<< HEAD
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
=======
>>>>>>> 7086f8331ed4f41eb1b85d8cc9a08683d726c89b
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

