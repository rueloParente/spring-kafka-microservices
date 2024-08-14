package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;
import org.springframework.stereotype.Component;

@Component
public class FactoryBookImp implements FactoryBook {
    @Override
    public Book createBook(BookID bookID, BookTitle bookTitle, BookDescription bookDescription, BookAvailable bookAvailable) {
        return new Book(bookID, bookTitle, bookDescription, bookAvailable);
    }

    @Override
    public Book createBook(BookTitle bookTitle, BookDescription bookDescription, BookAvailable bookAvailable) {
        return new Book(bookTitle, bookDescription, bookAvailable);
    }
}
