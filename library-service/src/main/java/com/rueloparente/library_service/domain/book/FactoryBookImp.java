package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookName;
import org.springframework.stereotype.Component;

@Component
public class FactoryBookImp implements FactoryBook {
    @Override
    public Book createBook(BookID bookID, BookName bookName, BookDescription bookDescription, BookAvailable bookAvailable) {
        return new Book(bookID, bookName, bookDescription, bookAvailable);
    }

    @Override
    public Book createBook(BookName bookName, BookDescription bookDescription, BookAvailable bookAvailable) {
        return new Book(bookName, bookDescription, bookAvailable);
    }
}
