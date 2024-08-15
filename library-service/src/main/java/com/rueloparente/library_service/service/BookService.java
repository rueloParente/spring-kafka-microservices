package com.rueloparente.library_service.service;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;
import com.rueloparente.library_service.dto.service_response.BookResponseModel;

import java.util.List;

public interface BookService {
    public BookResponseModel addNewBook(BookTitle title, BookDescription description, BookAvailable available);
    public BookResponseModel updateBook(BookID bookID, BookTitle title, BookDescription description, BookAvailable available);
    public boolean deleteBook(BookID bookID);
    public List<BookResponseModel> getAllBooks();
    public BookResponseModel getBookByID(BookID bookID);
}
