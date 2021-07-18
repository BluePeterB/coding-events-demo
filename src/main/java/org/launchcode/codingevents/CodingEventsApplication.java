package org.launchcode.codingevents;

//import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Query;
import java.util.List;

@SpringBootApplication
public class CodingEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingEventsApplication.class, args);
		System.out.println("InApp");

	}

}
