package org.launchcode.codingevents;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CodingEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingEventsApplication.class, args);
		System.out.println("InApp");

		HelloWorld fred = new HelloWorld();
		fred.sayHello();




	}


	public static class HelloWorld {

		public String message = "Hello World";

		public void sayHello() {

			String message = "Goodbye World";

			// The line below prints "Goodbye World"
			System.out.println(message);

			// The line below prints "Hello World"
			System.out.println(this.message);
		}
	}



}
