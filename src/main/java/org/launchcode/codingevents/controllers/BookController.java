package org.launchcode.codingevents.controllers;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.launchcode.codingevents.data.BookRepository;
import org.launchcode.codingevents.data.LoanRepository;
import org.launchcode.codingevents.data.PatronRepository;


import org.launchcode.codingevents.models.Book;
import org.launchcode.codingevents.models.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Optional;


@Controller
@RequestMapping("library")
public class BookController {

    private static int savedBookId = 0;
    private static int savedPatronId = 0;

    @Autowired  //Specifies that SpringBoot should auto-populate the eventRepository field (dependency injection).
    private BookRepository bookRepository;  //Added for persistence

    @Autowired  //Specifies that SpringBoot should auto-populate the eventRepository field (dependency injection).
    private PatronRepository patronRepository;  //Added for persistence

    @Autowired  //Specifies that SpringBoot should auto-populate the eventRepository field (dependency injection).
    private LoanRepository loanRepository;  //Added for persistence

    // Part Of CRUD: findAll, save, findById

    @GetMapping("book")  //  responds to a browser Get request to /library/books.
    public String displayAllBooks(Model model) {
        System.out.println("InGetMappingBooks");  //debug
        System.out.println("####savedBookId: " + savedBookId);
        model.addAttribute("title", "All Books");
        model.addAttribute("books", bookRepository.findAll());
        return "library/book";  //calls the book template
    }

    @PostMapping("book")
    public String processBookSelectForm(@RequestParam(required = false) int bookId) {
        System.out.println("InPostMappingBook");
        savedBookId = bookId;
        System.out.println("####savedBookId: " + savedBookId);

        //return "library/book";

        return "redirect:patron";
    }

    @GetMapping("patron")  //  responds to a browser Get request to /library/patron.
    public String displayAllPatrons(Model model) {
        System.out.println("InGetMappingPatron");  //debug
        System.out.println("####savedPatronId: " + savedPatronId);
        model.addAttribute("title", "All Patrons");
        model.addAttribute("patrons", patronRepository.findAll());
        return "library/patron";  //calls the patron template
    }

    @PostMapping("patron")
    public String processPatronSelectForm(@RequestParam(required = false) int patronId) {
        System.out.println("InPostMappingPatron");
        savedPatronId = patronId;
        System.out.println("####savedPatronId: " + savedPatronId);

        return "redirect:patron";
    }

    @GetMapping("dbTest")  //  responds to a browser Get request to /library/dbTest.
    public String dbTest(Model model) {
        System.out.println("InGetdbTest");  //debug

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
         Session session = factory.openSession();

        session.getTransaction().begin();
        Query query = session.createSQLQuery(
                "UPDATE Book SET available = :bookAvail" + " WHERE book_id = :bookId");
        query.setParameter("bookAvail", false);
        query.setParameter("bookId", 6);
        int result = query.executeUpdate();
        session.getTransaction().commit();

        return "library/book";  //calls the book template
    }

    @GetMapping("loan")  //  responds to a browser Get request to /library/patron.
    public String displayAllloans(Model model) {
        System.out.println("InGetMappingLoan");  //debug
        savedBookId = 4;
        savedPatronId = 4;

        Optional result = bookRepository.findById(savedBookId);
        Object theBook = result.get();  //Error checking etc omitted, ref 18.3.2.2.4
        Optional result2 = patronRepository.findById(savedPatronId);
        Object thePatron = result2.get();
        model.addAttribute("title", "All Loans");
        model.addAttribute("loans", loanRepository.findAll());
        model.addAttribute("theBook", theBook);
        model.addAttribute("thePatron", thePatron);
        System.out.println("&&&&" + result);
        return "library/loan";  //calls the loan template
    }
/*
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
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

    @PostMapping("bookId")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] bookId) {

        if (eventIds != null) {
            for (int id : eventIds) {
                //EventData.remove(id);  // for persistence changed to line below.
                eventRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
*/
}
