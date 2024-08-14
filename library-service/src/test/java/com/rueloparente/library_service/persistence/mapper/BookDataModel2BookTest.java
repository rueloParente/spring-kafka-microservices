package com.rueloparente.library_service.persistence.mapper;

import com.rueloparente.library_service.domain.book.Book;
import com.rueloparente.library_service.domain.book.FactoryBook;
import com.rueloparente.library_service.domain.value_object.*;
import com.rueloparente.library_service.persistence.repository_persistence_data.BookDataModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookDataModel2BookTest {
    @Test
    void shouldReturnDomainEntityBasedOnDataModel() {
        // Arrange
        // Mock Book Data Model
        BookDataModel bookDataModel = mock(BookDataModel.class);
        when(bookDataModel.getBookID()).thenReturn(1);
        when(bookDataModel.getTitle()).thenReturn("Book Title");
        when(bookDataModel.getDescription()).thenReturn("Book Description");
        when(bookDataModel.isAvailable()).thenReturn(true);

        // Mock Book Value Object
        BookID bookID = mock(BookID.class);
        when(bookID.getValue()).thenReturn(1);
        BookTitle bookTitle = mock(BookTitle.class);
        BookDescription bookDescription = mock(BookDescription.class);
        BookAvailable bookAvailable = mock(BookAvailable.class);

        //Mock Book
        Book book = mock(Book.class);

        // Mock Factory Book
        FactoryBook factoryBook = mock(FactoryBook.class);
        when(factoryBook.createBook(bookID, bookTitle, bookDescription, bookAvailable)).thenReturn(book);

        // Mock Factory Book VO
        FactoryBookVO factoryBookVO = mock(FactoryBookVO.class);
        when(factoryBookVO.createBookID(1)).thenReturn(bookID);
        when(factoryBookVO.createBookTitle("Book Title")).thenReturn(bookTitle);
        when(factoryBookVO.createBookDescription("Book Description")).thenReturn(bookDescription);
        when(factoryBookVO.createBookAvailable(true)).thenReturn(bookAvailable);

        // Create BookDataModel2Book
        BookDataModel2Book bookDataModel2Book = new BookDataModel2Book(factoryBook, factoryBookVO);

        // Act
        Book resultingBook = bookDataModel2Book.toDomain(bookDataModel);

        // Assert
        assertEquals(book, resultingBook);
    }

    @Test
    void shouldReturnListOfDomainEntitiesBasedOnDataModel() {
        // Arrange
        // Mock First Book Data Model
        BookDataModel bookDataModel = mock(BookDataModel.class);
        when(bookDataModel.getBookID()).thenReturn(1);
        when(bookDataModel.getTitle()).thenReturn("Book Title");
        when(bookDataModel.getDescription()).thenReturn("Book Description");
        when(bookDataModel.isAvailable()).thenReturn(true);

        // Mock Second Book Data Model
        BookDataModel bookDataModel2 = mock(BookDataModel.class);
        when(bookDataModel2.getBookID()).thenReturn(2);
        when(bookDataModel2.getTitle()).thenReturn("Book Title 2");
        when(bookDataModel2.getDescription()).thenReturn("Book Description 2");
        when(bookDataModel2.isAvailable()).thenReturn(false);

        // Mock Book Value Object
        BookID bookID = mock(BookID.class);
        BookTitle bookTitle = mock(BookTitle.class);
        BookDescription bookDescription = mock(BookDescription.class);
        BookAvailable bookAvailable = mock(BookAvailable.class);

        //Mock Second Book Value Object
        BookID bookID2 = mock(BookID.class);
        BookTitle bookTitle2 = mock(BookTitle.class);
        BookDescription bookDescription2 = mock(BookDescription.class);
        BookAvailable bookAvailable2 = mock(BookAvailable.class);

        //Mock Book
        Book book = mock(Book.class);

        //Mock Second Book
        Book book2 = mock(Book.class);

        // Mock Factory Book
        FactoryBook factoryBook = mock(FactoryBook.class);
        when(factoryBook.createBook(bookID, bookTitle, bookDescription, bookAvailable)).thenReturn(book);
        when(factoryBook.createBook(bookID2, bookTitle2, bookDescription2, bookAvailable2)).thenReturn(book2);

        // Mock Factory Book VO
        FactoryBookVO factoryBookVO = mock(FactoryBookVO.class);
        when(factoryBookVO.createBookID(1)).thenReturn(bookID);
        when(factoryBookVO.createBookTitle("Book Title")).thenReturn(bookTitle);
        when(factoryBookVO.createBookDescription("Book Description")).thenReturn(bookDescription);
        when(factoryBookVO.createBookAvailable(true)).thenReturn(bookAvailable);

        when(factoryBookVO.createBookID(2)).thenReturn(bookID2);
        when(factoryBookVO.createBookTitle("Book Title 2")).thenReturn(bookTitle2);
        when(factoryBookVO.createBookDescription("Book Description 2")).thenReturn(bookDescription2);
        when(factoryBookVO.createBookAvailable(false)).thenReturn(bookAvailable2);

        // Create Iterable of BookDataModel
        Iterable<BookDataModel> bookDataModels = new ArrayList<>();
        ((ArrayList<BookDataModel>) bookDataModels).add(bookDataModel);
        ((ArrayList<BookDataModel>) bookDataModels).add(bookDataModel2);

        // Create Iterable of expected result
        Iterable<Book> expected = new ArrayList<>();
        ((ArrayList<Book>) expected).add(book);
        ((ArrayList<Book>) expected).add(book2);

        // Create BookDataModel2Book
        BookDataModel2Book bookDataModel2Book = new BookDataModel2Book(factoryBook, factoryBookVO);

        // Act
        Iterable<Book> resultingBooks = bookDataModel2Book.toDomain(bookDataModels);

        // Assert
        assertEquals(expected, resultingBooks);
    }

}