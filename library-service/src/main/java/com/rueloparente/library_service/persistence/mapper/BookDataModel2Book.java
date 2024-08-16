package com.rueloparente.library_service.persistence.mapper;

import com.rueloparente.library_service.domain.book.Book;
import com.rueloparente.library_service.domain.book.FactoryBook;
import com.rueloparente.library_service.domain.value_object.*;
import com.rueloparente.library_service.persistence.repository_persistence_data.BookDataModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDataModel2Book {
    private final FactoryBook factoryBook;
    private final FactoryBookVO factoryBookVO;

    public BookDataModel2Book(FactoryBook factoryBook, FactoryBookVO factoryBookVO) {
        this.factoryBook = factoryBook;
        this.factoryBookVO = factoryBookVO;
    }

    public Book toDomain(BookDataModel bookDataModel) {
        BookID bookID = factoryBookVO.createBookID(bookDataModel.getBookID());
        BookTitle bookTitle = factoryBookVO.createBookTitle(bookDataModel.getTitle());
        BookDescription bookDescription = factoryBookVO.createBookDescription(bookDataModel.getDescription());
        BookAvailable bookAvailable = factoryBookVO.createBookAvailable(bookDataModel.isAvailable());
        return factoryBook.createBook(bookID, bookTitle, bookDescription, bookAvailable);
    }
    public List<Book> toDomain(Iterable<BookDataModel> bookDataModels) {
        List<Book> books = new ArrayList<>();
        for (BookDataModel bookDataModel : bookDataModels) {
            Book book = toDomain(bookDataModel);
            books.add(book);
        }
        return books;
    }
}
