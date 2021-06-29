CODING EVENTS

1) PURPOSE 
This App tracks Events that the user can create, select and view.


2) CURRENT STATE
Each event can be asigned a name, desciption, contact email and category.
The user can create and assign a category to each event. Each category has a unique name.


3) NEED TO ADD:
Personal accounts so that a person can sign on and a) create events, b) follow the events they are most interested in
and c)keep track of their own calendar of events. Will then need the following for the App:-

       PERSON CLASS
        Fields, for each user:
            id (int) - user ID
            firstName (String)
            lastName (String)
            email (String) , use as username?
            password (String)

        Getters: for allfields.
        Setters for all fields, except id.

        The Person class might also have the following references:
            PersonProfile - a class to gather up all of the profile information about the user
            List<Events> eventsAttending - to store events the user wants to attend
            List<Events> eventsOwned - a different list, to store the events the user has created

    Person would have a many-to-many relationship with Event via List<Events> eventsAttending. It would have a one-to-many relationship with Event via List<Events> eventsOwned.
