package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;

public interface FactoryBook {
    Book createBook(BookID bookID, BookTitle bookTitle, BookDescription bookDescription, BookAvailable bookAvailable);
    Book createBook(BookTitle bookTitle, BookDescription bookDescription, BookAvailable bookAvailable);
}
