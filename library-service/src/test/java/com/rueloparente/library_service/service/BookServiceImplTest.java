package com.rueloparente.library_service.service;

import com.rueloparente.library_service.domain.book.Book;
import com.rueloparente.library_service.domain.book.FactoryBook;
import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;
import com.rueloparente.library_service.dto.service_response.BookResponseModel;
import com.rueloparente.library_service.persistence.BookRepository;
import com.rueloparente.library_service.service.mapper.Book2ServiceResponseModel;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceImplTest {
    @Test
    void shouldAddNewBookWhenTitleDescriptionAndAvailableAreValid() {
        // Arrange
        // Mock book value objects
        BookTitle title = mock(BookTitle.class);
        when(title.getValue()).thenReturn("Title");
        BookDescription description = mock(BookDescription.class);
        when(description.getValue()).thenReturn("Description");
        BookAvailable available = mock(BookAvailable.class);
        when(available.getValue()).thenReturn(true);

        // Mock book domain object
        Book book = mock(Book.class);
        when(book.getID()).thenReturn(mock(BookID.class));
        when(book.getTitle()).thenReturn(title);
        when(book.getDescription()).thenReturn(description);
        when(book.isAvailable()).thenReturn(available);

        // Mock book factory
        FactoryBook factoryBook = mock(FactoryBook.class);
        when(factoryBook.createBook(title, description, available)).thenReturn(book);

        // Mock book repository
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.save(book)).thenReturn(book);

        // Mock book response model
        Book2ServiceResponseModel book2ServiceResponseModel = mock(Book2ServiceResponseModel.class);
        BookResponseModel bookResponseModel = mock(BookResponseModel.class);
        when(book2ServiceResponseModel.toServiceResponseModel(book.getID(), title, description, available)).thenReturn(bookResponseModel);


        BookServiceImpl bookService = new BookServiceImpl(bookRepository, factoryBook, book2ServiceResponseModel);

        // Act
        BookResponseModel result = bookService.addNewBook(title, description, available);

        // Assert
        verify(bookRepository).save(book);
        verify(book2ServiceResponseModel).toServiceResponseModel(book.getID(), title, description, available);
        assertEquals(bookResponseModel, result);
    }

    @Test
    void shouldUpdateBookWhenBookIDTitleDescriptionAndAvailableAreValid() {
        // Arrange
        // Mock book value objects
        BookID bookID = mock(BookID.class);
        when(bookID.getValue()).thenReturn(1);
        BookTitle title = mock(BookTitle.class);
        when(title.getValue()).thenReturn("Title");
        BookDescription description = mock(BookDescription.class);
        when(description.getValue()).thenReturn("Description");
        BookAvailable available = mock(BookAvailable.class);
        when(available.getValue()).thenReturn(true);

        // Mock book domain object
        Book book = mock(Book.class);
        when(book.getID()).thenReturn(bookID);
        when(book.getTitle()).thenReturn(title);
        when(book.getDescription()).thenReturn(description);
        when(book.isAvailable()).thenReturn(available);

        // Mock book factory
        FactoryBook factoryBook = mock(FactoryBook.class);

        // Mock book repository
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.find(bookID)).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        // Mock book response model
        Book2ServiceResponseModel book2ServiceResponseModel = mock(Book2ServiceResponseModel.class);
        BookResponseModel bookResponseModel = mock(BookResponseModel.class);
        when(book2ServiceResponseModel.toServiceResponseModel(bookID, title, description, available)).thenReturn(bookResponseModel);

        BookServiceImpl bookService = new BookServiceImpl(bookRepository, factoryBook, book2ServiceResponseModel);

        // Act
        BookResponseModel result = bookService.updateBook(bookID, title, description, available);

        // Assert
        verify(bookRepository).find(bookID);
        verify(bookRepository).save(book);
        verify(book2ServiceResponseModel).toServiceResponseModel(bookID, title, description, available);
        assertEquals(bookResponseModel, result);
    }
    @Test
    void shouldThrowExceptionWhenBookIDIsInvalid() {
        // Arrange
        // Mock book value objects
        BookID bookID = mock(BookID.class);
        when(bookID.getValue()).thenReturn(1);
        BookTitle title = mock(BookTitle.class);
        when(title.getValue()).thenReturn("Title");
        BookDescription description = mock(BookDescription.class);
        when(description.getValue()).thenReturn("Description");
        BookAvailable available = mock(BookAvailable.class);
        when(available.getValue()).thenReturn(true);

        // Mock book factory
        FactoryBook factoryBook = mock(FactoryBook.class);

        // Mock book repository
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.find(bookID)).thenReturn(Optional.empty());

        // Mock book response model
        Book2ServiceResponseModel book2ServiceResponseModel = mock(Book2ServiceResponseModel.class);

        BookServiceImpl bookService = new BookServiceImpl(bookRepository, factoryBook, book2ServiceResponseModel);

        String expectedMessage = "Book not found";
        // Act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> bookService.updateBook(bookID, title, description, available));

        // Assert
        verify(bookRepository).find(bookID);
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void shouldDeleteBookAndReturnTrueWhenBookIDIsValid() {
        // Arrange
        // Mock book value objects
        BookID bookID = mock(BookID.class);

        // Mock book factory
        FactoryBook factoryBook = mock(FactoryBook.class);

        // Mock book repository
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.delete(bookID)).thenReturn(true);

        // Mock book response model
        Book2ServiceResponseModel book2ServiceResponseModel = mock(Book2ServiceResponseModel.class);

        BookServiceImpl bookService = new BookServiceImpl(bookRepository, factoryBook, book2ServiceResponseModel);

        // Act
        boolean result = bookService.deleteBook(bookID);

        // Assert
        verify(bookRepository).delete(bookID);
        assertTrue(result);
    }
    @Test
    void shouldReturnFalseWhenDeletingBookAndBookIDIsInvalid() {
        // Arrange
        // Mock book value objects
        BookID bookID = mock(BookID.class);

        // Mock book factory
        FactoryBook factoryBook = mock(FactoryBook.class);

        // Mock book repository
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.delete(bookID)).thenReturn(false);

        // Mock book response model
        Book2ServiceResponseModel book2ServiceResponseModel = mock(Book2ServiceResponseModel.class);

        BookServiceImpl bookService = new BookServiceImpl(bookRepository, factoryBook, book2ServiceResponseModel);

        // Act
        boolean result = bookService.deleteBook(bookID);

        // Assert
        verify(bookRepository).delete(bookID);
        assertFalse(result);
    }
    @Test
    void shouldReturnListOfBookResponseModelWhenGettingAllBooks() {
        // Arrange
        // Mock book value objects
        BookID bookID = mock(BookID.class);
        when(bookID.getValue()).thenReturn(1);
        BookTitle title = mock(BookTitle.class);
        when(title.getValue()).thenReturn("Title");
        BookDescription description = mock(BookDescription.class);
        when(description.getValue()).thenReturn("Description");
        BookAvailable available = mock(BookAvailable.class);
        when(available.getValue()).thenReturn(true);

        // Mock second book value objects
        BookID bookID2 = mock(BookID.class);
        when(bookID2.getValue()).thenReturn(2);
        BookTitle title2 = mock(BookTitle.class);
        when(title2.getValue()).thenReturn("Title2");
        BookDescription description2 = mock(BookDescription.class);
        when(description2.getValue()).thenReturn("Description2");
        BookAvailable available2 = mock(BookAvailable.class);
        when(available2.getValue()).thenReturn(false);

        // Mock book domain object
        Book book = mock(Book.class);
        when(book.getID()).thenReturn(bookID);
        when(book.getTitle()).thenReturn(title);
        when(book.getDescription()).thenReturn(description);
        when(book.isAvailable()).thenReturn(available);

        // Mock second book domain object
        Book book2 = mock(Book.class);
        when(book2.getID()).thenReturn(bookID2);
        when(book2.getTitle()).thenReturn(title2);
        when(book2.getDescription()).thenReturn(description2);
        when(book2.isAvailable()).thenReturn(available2);

        // Add two book to List
        List<Book> books = List.of(book, book2);

        // Mock book factory
        FactoryBook factoryBook = mock(FactoryBook.class);

        // Mock book repository
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findAll()).thenReturn(books);

        // Mock book response model
        Book2ServiceResponseModel book2ServiceResponseModel = mock(Book2ServiceResponseModel.class);
        BookResponseModel bookResponseModel = mock(BookResponseModel.class);
        when(book2ServiceResponseModel.toServiceResponseModel(bookID, title, description, available)).thenReturn(bookResponseModel);

        // Mock second book response model
        BookResponseModel bookResponseModel2 = mock(BookResponseModel.class);
        when(book2ServiceResponseModel.toServiceResponseModel(bookID2, title2, description2, available2)).thenReturn(bookResponseModel2);

        BookServiceImpl bookService = new BookServiceImpl(bookRepository, factoryBook, book2ServiceResponseModel);

        List<BookResponseModel> expected = List.of(bookResponseModel, bookResponseModel2);
        // Act
        List<BookResponseModel> result = bookService.getAllBooks();

        // Assert
        verify(bookRepository).findAll();
        verify(book2ServiceResponseModel).toServiceResponseModel(bookID, title, description, available);
        verify(book2ServiceResponseModel).toServiceResponseModel(bookID2, title2, description2, available2);
        assertEquals(expected, result);
    }
    @Test
    void shouldReturnEmptyListWhenGettingAllBooksAndNoBooksAreAvailable() {
        // Arrange
        // Mock book factory
        FactoryBook factoryBook = mock(FactoryBook.class);

        // Mock book repository
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findAll()).thenReturn(List.of());

        // Mock book response model
        Book2ServiceResponseModel book2ServiceResponseModel = mock(Book2ServiceResponseModel.class);

        BookServiceImpl bookService = new BookServiceImpl(bookRepository, factoryBook, book2ServiceResponseModel);

        List<BookResponseModel> expected = List.of();
        // Act
        List<BookResponseModel> result = bookService.getAllBooks();

        // Assert
        verify(bookRepository).findAll();
        assertEquals(expected, result);
    }
    @Test
    void shouldReturnBookResponseModelWhenGettingBookByID() {
        // Arrange
        // Mock book value objects
        BookID bookID = mock(BookID.class);
        BookTitle title = mock(BookTitle.class);
        BookDescription description = mock(BookDescription.class);
        BookAvailable available = mock(BookAvailable.class);

        // Mock book domain object
        Book book = mock(Book.class);
        when(book.getID()).thenReturn(bookID);
        when(book.getTitle()).thenReturn(title);
        when(book.getDescription()).thenReturn(description);
        when(book.isAvailable()).thenReturn(available);

        // Mock book factory
        FactoryBook factoryBook = mock(FactoryBook.class);

        // Mock book repository
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.find(bookID)).thenReturn(Optional.of(book));

        // Mock book response model
        Book2ServiceResponseModel book2ServiceResponseModel = mock(Book2ServiceResponseModel.class);
        BookResponseModel bookResponseModel = mock(BookResponseModel.class);
        when(book2ServiceResponseModel.toServiceResponseModel(bookID, title, description, available)).thenReturn(bookResponseModel);

        BookServiceImpl bookService = new BookServiceImpl(bookRepository, factoryBook, book2ServiceResponseModel);

        // Act
        BookResponseModel result = bookService.getBookByID(bookID);

        // Assert
        verify(bookRepository).find(bookID);
        verify(book2ServiceResponseModel).toServiceResponseModel(bookID, title, description, available);
        assertEquals(bookResponseModel, result);
    }
    @Test
    void shouldThrowExceptionWhenGettingBookByIDAndBookIDIsInvalid() {
        // Arrange
        // Mock book value objects
        BookID bookID = mock(BookID.class);

        // Mock book factory
        FactoryBook factoryBook = mock(FactoryBook.class);

        // Mock book repository
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.find(bookID)).thenReturn(Optional.empty());

        // Mock book response model
        Book2ServiceResponseModel book2ServiceResponseModel = mock(Book2ServiceResponseModel.class);

        BookServiceImpl bookService = new BookServiceImpl(bookRepository, factoryBook, book2ServiceResponseModel);

        String expectedMessage = "Book not found";
        // Act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> bookService.getBookByID(bookID));

        // Assert
        verify(bookRepository).find(bookID);
        assertEquals(expectedMessage, exception.getMessage());
    }

}