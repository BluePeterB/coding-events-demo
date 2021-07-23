package org.launchcode.codingevents.controllers;

//import org.launchcode.codingevents.data.EventData; eventdata no longer used
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    @Autowired  //Specifies that SpringBoot should auto-populate the eventRepository field (dependency injection).
    private EventRepository eventRepository;  //Added for persistence

    // Part Of CRUD: findAll, save, findById

    @GetMapping
    public String displayAllEvents(Model model) {
        System.out.println("InDisplayAllEvents");
        model.addAttribute("title", "All Events");
       // model.addAttribute("events", EventData.getAll());  // for persistence changed to line below
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        System.out.println("InGetMappingCreate");
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
        System.out.println("InPostMappingCreate");
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        //EventData.add(newEvent);  // for persistence changed to line below.
        eventRepository.save(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        //model.addAttribute("events", EventData.getAll());  //for persistence changed to line below.
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                //EventData.remove(id);  // for persistence changed to line below.
                eventRepository.deleteById(id);
            }
        }

        return "redirect:";  //returns to root.
    }

}
