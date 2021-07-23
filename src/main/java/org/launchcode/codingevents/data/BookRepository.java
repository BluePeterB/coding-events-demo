package org.launchcode.codingevents.data;


import org.launchcode.codingevents.models.Book;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository  //Signifies to SpringBoot that this class will store objects in the DB.
public interface BookRepository extends CrudRepository<Book, Integer> {
    // This interface class was added / is needed for persistence.
    // <Book for type of thing we are storing.
    // Integer> for data type of the primary key for that class.
}

