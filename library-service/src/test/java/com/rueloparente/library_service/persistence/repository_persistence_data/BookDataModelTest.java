package com.rueloparente.library_service.persistence.repository_persistence_data;

import com.rueloparente.library_service.domain.book.Book;
import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookDataModelTest {
    @Test
    void shouldReturnBookNameWhenGetTitleIsCalledOnDataModel() {
        //Arrange
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("Book Name");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("Book Description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);

        Book book = mock(Book.class);
        when(book.getName()).thenReturn(bookTitle);
        when(book.getDescription()).thenReturn(bookDescription);
        when(book.isAvailable()).thenReturn(bookAvailable);

        BookDataModel bookDataModel = new BookDataModel(book);

        String expected = bookTitle.getValue();
        //Act

        String result = bookDataModel.getTitle();

        //Assert
        assertEquals(expected, result);
    }
    @Test
    void shouldReturnBookDescriptionWhenGetDescriptionIsCalledOnDataModel() {
        //Arrange
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("Book Name");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("Book Description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);

        Book book = mock(Book.class);
        when(book.getName()).thenReturn(bookTitle);
        when(book.getDescription()).thenReturn(bookDescription);
        when(book.isAvailable()).thenReturn(bookAvailable);

        BookDataModel bookDataModel = new BookDataModel(book);

        String expected = bookDescription.getValue();
        //Act

        String result = bookDataModel.getDescription();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnBookAvailableWhenIsAvailableIsCalledOnDataModel() {
        //Arrange
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("Book Name");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("Book Description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);

        Book book = mock(Book.class);
        when(book.getName()).thenReturn(bookTitle);
        when(book.getDescription()).thenReturn(bookDescription);
        when(book.isAvailable()).thenReturn(bookAvailable);

        BookDataModel bookDataModel = new BookDataModel(book);

        boolean expected = bookAvailable.getValue();
        //Act

        boolean result = bookDataModel.isAvailable();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnBookIDWhenGetBookIDIsCalledOnDataModel() {
        //Arrange
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("Book Name");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("Book Description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);

        Book book = mock(Book.class);
        when(book.getName()).thenReturn(bookTitle);
        when(book.getDescription()).thenReturn(bookDescription);
        when(book.isAvailable()).thenReturn(bookAvailable);

        BookDataModel bookDataModel = new BookDataModel(book);

        int expected = 0;
        //Act

        int result = bookDataModel.getBookID();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnVersionWhenGetVersionIsCalledOnDataModel() {
        //Arrange
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("Book Name");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("Book Description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);

        Book book = mock(Book.class);
        when(book.getName()).thenReturn(bookTitle);
        when(book.getDescription()).thenReturn(bookDescription);
        when(book.isAvailable()).thenReturn(bookAvailable);

        BookDataModel bookDataModel = new BookDataModel(book);

        int expected = 0;
        //Act

        int result = bookDataModel.getVersion();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldSetTitleWhenSetTitleIsCalledOnDataModel() {
        //Arrange
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("Book Name");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("Book Description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);

        Book book = mock(Book.class);
        when(book.getName()).thenReturn(bookTitle);
        when(book.getDescription()).thenReturn(bookDescription);
        when(book.isAvailable()).thenReturn(bookAvailable);

        BookDataModel bookDataModel = new BookDataModel(book);

        String expected = "New Title";
        //Act
        bookDataModel.setTitle(expected);

        String result = bookDataModel.getTitle();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldSetDescriptionWhenSetDescriptionIsCalledOnDataModel() {
        //Arrange
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("Book Name");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("Book Description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);

        Book book = mock(Book.class);
        when(book.getName()).thenReturn(bookTitle);
        when(book.getDescription()).thenReturn(bookDescription);
        when(book.isAvailable()).thenReturn(bookAvailable);

        BookDataModel bookDataModel = new BookDataModel(book);

        String expected = "New Description";
        //Act
        bookDataModel.setDescription(expected);

        String result = bookDataModel.getDescription();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldSetAvailableWhenSetAvailableIsCalledOnDataModel() {
        //Arrange
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("Book Name");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("Book Description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);

        Book book = mock(Book.class);
        when(book.getName()).thenReturn(bookTitle);
        when(book.getDescription()).thenReturn(bookDescription);
        when(book.isAvailable()).thenReturn(bookAvailable);

        BookDataModel bookDataModel = new BookDataModel(book);

        boolean expected = false;
        //Act
        bookDataModel.setAvailable(expected);

        boolean result = bookDataModel.isAvailable();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnBookIDWhenBookAlreadyHasAnID() {
        //Arrange
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("Book Name");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("Book Description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);
        BookID bookID = mock(BookID.class);
        when(bookID.getValue()).thenReturn(5);

        Book book = mock(Book.class);
        when(book.getName()).thenReturn(bookTitle);
        when(book.getDescription()).thenReturn(bookDescription);
        when(book.isAvailable()).thenReturn(bookAvailable);
        when(book.getId()).thenReturn(bookID);

        BookDataModel bookDataModel = new BookDataModel(book);

        int expected = 5;
        //Act

        int result = bookDataModel.getBookID();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnZeroWhenBookHaveNoIDYet() {
        //Arrange
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("Book Name");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("Book Description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);


        Book book = mock(Book.class);
        when(book.getName()).thenReturn(bookTitle);
        when(book.getDescription()).thenReturn(bookDescription);
        when(book.isAvailable()).thenReturn(bookAvailable);

        BookDataModel bookDataModel = new BookDataModel(book);

        int expected = 0;
        //Act

        int result = bookDataModel.getBookID();

        //Assert
        assertEquals(expected, result);

    }
}