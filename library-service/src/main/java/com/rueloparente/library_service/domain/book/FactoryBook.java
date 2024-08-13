package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookName;

public interface FactoryBook {
    Book createBook(BookID bookID, BookName bookName, BookDescription bookDescription, BookAvailable bookAvailable);
    Book createBook(BookName bookName, BookDescription bookDescription, BookAvailable bookAvailable);
}
