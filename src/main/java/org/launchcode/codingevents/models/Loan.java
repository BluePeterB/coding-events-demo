package org.launchcode.codingevents.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity  //For persistence. Hibernate scans this app looking for @Entity. Then creates in SQL a table ...
public class Loan {   // called patron (if not already present) and adds a column for each field below.
    // this was enabled by the setting in application.properties :-
    // spring.jpa.hibernate.ddl-auto = update

    @Id   //For persistence
    @GeneratedValue   //For persistence lets DB update the ID*
    private int loan_id;

    private int patron_id;

    private String date_out;

    private String date_in;

    private int book_id;



    public Loan(int patron_id, String date_out, String date_in, int book_id) {
        this();
        this.patron_id = patron_id;
        this.date_out = date_out;
        this.date_in = date_in;
        this. book_id = book_id;
    }

    public Loan() { }  //needed for ??

    public int getLoan_id() {
        return loan_id;
    }

    public int getPatron_id() {
        return patron_id;
    }

    public void setPatron_id(int patron_id) {
        this.patron_id = patron_id;
    }

    public String getDate_out() {
        return date_out;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
}