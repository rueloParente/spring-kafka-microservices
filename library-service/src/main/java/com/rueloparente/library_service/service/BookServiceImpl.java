package com.rueloparente.library_service.service;

import com.rueloparente.library_service.domain.book.Book;
import com.rueloparente.library_service.domain.book.FactoryBook;
import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;
import com.rueloparente.library_service.dto.service_response.BookResponseModel;
import com.rueloparente.library_service.persistence.BookRepository;
import com.rueloparente.library_service.mapper.service_response.Book2ServiceResponseModel;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final FactoryBook factoryBook;
    private final Book2ServiceResponseModel book2ServiceResponseModel;

    public BookServiceImpl(BookRepository bookRepository, FactoryBook factoryBook, Book2ServiceResponseModel book2ServiceResponseModel) {
        this.bookRepository = bookRepository;
        this.factoryBook = factoryBook;
        this.book2ServiceResponseModel = book2ServiceResponseModel;
    }

    @Override
    public BookResponseModel addNewBook(BookTitle title, BookDescription description, BookAvailable available) {
        Book book = factoryBook.createBook(title, description, available);
        Book savedBook = bookRepository.save(book);
        return book2ServiceResponseModel.toServiceResponseModel(savedBook.getID(), savedBook.getTitle(), savedBook.getDescription(), savedBook.isAvailable());
    }

    @Override
    public BookResponseModel updateBook(BookID bookID, BookTitle title, BookDescription description, BookAvailable available) {
        Optional<Book> bookOptional = bookRepository.find(bookID);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setTitle(title);
            book.setDescription(description);
            book.setAvailable(available);

            Book savedBook = bookRepository.save(book);
            return book2ServiceResponseModel.toServiceResponseModel(savedBook.getID(), savedBook.getTitle(), savedBook.getDescription(), savedBook.isAvailable());
        } else throw new NotFoundException("Book not found");

    }

    @Override
    public boolean deleteBook(BookID bookID) {
        return bookRepository.delete(bookID);
    }

    @Override
    public List<BookResponseModel> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponseModel> bookResponseModels = new ArrayList<>();
        for (Book book : books) {
            BookResponseModel bookResponseModel = book2ServiceResponseModel.toServiceResponseModel(book.getID(), book.getTitle(), book.getDescription(), book.isAvailable());
            bookResponseModels.add(bookResponseModel);
        }
        return bookResponseModels;
    }

    @Override
    public BookResponseModel getBookByID(BookID bookID) {
        Optional<Book> bookOptional = bookRepository.find(bookID);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            return book2ServiceResponseModel.toServiceResponseModel(book.getID(), book.getTitle(), book.getDescription(), book.isAvailable());
        } else throw new NotFoundException("Book not found");
    }
}
