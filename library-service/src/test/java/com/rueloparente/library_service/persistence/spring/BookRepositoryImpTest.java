package com.rueloparente.library_service.persistence.spring;


import com.rueloparente.library_service.domain.book.Book;
import com.rueloparente.library_service.domain.book.FactoryBook;
import com.rueloparente.library_service.domain.book.FactoryBookImp;
import com.rueloparente.library_service.domain.value_object.*;
import com.rueloparente.library_service.persistence.mapper.BookDataModel2Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class BookRepositoryImpTest {
    @Autowired
    private BookDBContext dbContext;


    @Test
    void shouldAddBookToRepository() {
        // Arrange
        FactoryBookVO factoryBookVO = new FactoryBookVOImp();
        FactoryBook factoryBook = new FactoryBookImp();

        BookID bookID = factoryBookVO.createBookID(1);
        BookTitle bookTitle = factoryBookVO.createBookTitle("Book Title");
        BookDescription bookDescription = factoryBookVO.createBookDescription("Book Description");
        BookAvailable bookAvailable = factoryBookVO.createBookAvailable(true);

        Book book = factoryBook.createBook(bookID, bookTitle, bookDescription, bookAvailable);

        BookDataModel2Book mapper = new BookDataModel2Book(factoryBook, factoryBookVO);
        BookRepository bookRepository = new BookRepositoryImp(dbContext, mapper);

        // Act
        Book savedBook = bookRepository.save(book);

        // Assert
        assertEquals(book, savedBook);
        }


    @Test
    void shouldReturnBookFromRepository() {
        // Arrange
        FactoryBookVO factoryBookVO = new FactoryBookVOImp();
        FactoryBook factoryBook = new FactoryBookImp();

        BookID bookID = factoryBookVO.createBookID(1);
        BookTitle bookTitle = factoryBookVO.createBookTitle("Book Title");
        BookDescription bookDescription = factoryBookVO.createBookDescription("Book Description");
        BookAvailable bookAvailable = factoryBookVO.createBookAvailable(true);

        Book book = factoryBook.createBook(bookID, bookTitle, bookDescription, bookAvailable);

        BookDataModel2Book mapper = new BookDataModel2Book(factoryBook, factoryBookVO);
        BookRepository bookRepository = new BookRepositoryImp(dbContext, mapper);

        // Act
        Book savedBook = bookRepository.save(book);
        Optional<Book> retrievedBook = bookRepository.find(bookID);

        // Assert
        assertTrue(retrievedBook.isPresent());
        assertEquals(savedBook, retrievedBook.get());
    }

    @Test
    void shouldReturnOptionalEmptyIfBookNotFound() {
        // Arrange
        FactoryBookVO factoryBookVO = new FactoryBookVOImp();
        FactoryBook factoryBook = new FactoryBookImp();

        BookID bookID = factoryBookVO.createBookID(1);
        BookID wrongBookID = factoryBookVO.createBookID(2);
        BookTitle bookTitle = factoryBookVO.createBookTitle("Book Title");
        BookDescription bookDescription = factoryBookVO.createBookDescription("Book Description");
        BookAvailable bookAvailable = factoryBookVO.createBookAvailable(true);

        Book book = factoryBook.createBook(bookID, bookTitle, bookDescription, bookAvailable);

        BookDataModel2Book mapper = new BookDataModel2Book(factoryBook, factoryBookVO);
        BookRepository bookRepository = new BookRepositoryImp(dbContext, mapper);

        // Act
        Book savedBook = bookRepository.save(book);
        Optional<Book> retrievedBook = bookRepository.find(wrongBookID);

        // Assert
        assertTrue(retrievedBook.isEmpty());
    }

    @Test
    void shouldReturnAllBooksFromRepository() {
        // Arrange
        FactoryBookVO factoryBookVO = new FactoryBookVOImp();
        FactoryBook factoryBook = new FactoryBookImp();

        BookTitle bookTitle = factoryBookVO.createBookTitle("Book Title");
        BookDescription bookDescription = factoryBookVO.createBookDescription("Book Description");
        BookAvailable bookAvailable = factoryBookVO.createBookAvailable(true);

        BookTitle bookTitle2 = factoryBookVO.createBookTitle("Book Title 2");
        BookDescription bookDescription2 = factoryBookVO.createBookDescription("Book Description 2");
        BookAvailable bookAvailable2 = factoryBookVO.createBookAvailable(true);

        Book book = factoryBook.createBook(bookTitle, bookDescription, bookAvailable);
        Book book2 = factoryBook.createBook(bookTitle2, bookDescription2, bookAvailable2);

        BookDataModel2Book mapper = new BookDataModel2Book(factoryBook, factoryBookVO);
        BookRepository bookRepository = new BookRepositoryImp(dbContext, mapper);

        Book savedBook = bookRepository.save(book);
        Book savedBook2 = bookRepository.save(book2);
        Iterable<Book> expectedBooks = List.of(savedBook, savedBook2);

        // Act
        Iterable<Book> books = bookRepository.findAll();

        // Assert
        assertEquals(expectedBooks, books);
    }

    @Test
    void shouldDeleteBookFromRepository() {
        // Arrange
        FactoryBookVO factoryBookVO = new FactoryBookVOImp();
        FactoryBook factoryBook = new FactoryBookImp();

        BookID bookID = factoryBookVO.createBookID(1);
        BookTitle bookTitle = factoryBookVO.createBookTitle("Book Title");
        BookDescription bookDescription = factoryBookVO.createBookDescription("Book Description");
        BookAvailable bookAvailable = factoryBookVO.createBookAvailable(true);

        Book book = factoryBook.createBook(bookID, bookTitle, bookDescription, bookAvailable);

        BookDataModel2Book mapper = new BookDataModel2Book(factoryBook, factoryBookVO);
        BookRepository bookRepository = new BookRepositoryImp(dbContext, mapper);

        Book savedBook = bookRepository.save(book);

        Iterable<Book> expectedBooks = List.of();
        // Act
        boolean deleted = bookRepository.delete(bookID);
        Iterable<Book> books = bookRepository.findAll();

        // Assert
        assertEquals(expectedBooks, books);
        assertTrue(deleted);
    }
    @Test
    void shouldReturnFalseIfBookNotDeleted() {
        // Arrange
        FactoryBookVO factoryBookVO = new FactoryBookVOImp();
        FactoryBook factoryBook = new FactoryBookImp();

        BookID bookID = factoryBookVO.createBookID(1);
        BookID wrongBookID = factoryBookVO.createBookID(2);
        BookTitle bookTitle = factoryBookVO.createBookTitle("Book Title");
        BookDescription bookDescription = factoryBookVO.createBookDescription("Book Description");
        BookAvailable bookAvailable = factoryBookVO.createBookAvailable(true);

        Book book = factoryBook.createBook(bookID, bookTitle, bookDescription, bookAvailable);

        BookDataModel2Book mapper = new BookDataModel2Book(factoryBook, factoryBookVO);
        BookRepository bookRepository = new BookRepositoryImp(dbContext, mapper);

        Book savedBook = bookRepository.save(book);

        Iterable<Book> expectedBooks = List.of(savedBook);
        // Act
        boolean deleted = bookRepository.delete(wrongBookID);
        Iterable<Book> books = bookRepository.findAll();

        // Assert
        assertEquals(expectedBooks, books);
        assertFalse(deleted);
    }


}