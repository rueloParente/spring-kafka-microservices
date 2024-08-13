package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FactoryBookImpTest {
    @Test
    void shouldCreateBookWithoutID() {
        // Arrange
        FactoryBookImp factoryBookImp = new FactoryBookImp();
        BookName bookName = mock(BookName.class);
        BookDescription bookDescription = mock(BookDescription.class);
        BookAvailable bookAvailable = mock(BookAvailable.class);

        // Act
        try (MockedConstruction<Book> bookMockedConstruction = mockConstruction(Book.class, (mock, context) -> {
            when(mock.getName()).thenReturn(bookName);
            when(mock.getDescription()).thenReturn(bookDescription);
            when(mock.isAvailable()).thenReturn(bookAvailable);
        })) {
            Book result = factoryBookImp.createBook(bookName, bookDescription, bookAvailable);
            // Assert
            assertEquals(bookName, result.getName());
            assertEquals(bookDescription, result.getDescription());
            assertEquals(bookAvailable, result.isAvailable());
        }

    }

    @Test
    void shouldCreateBookWithID() {
        // Arrange
        FactoryBookImp factoryBookImp = new FactoryBookImp();
        BookName bookName = mock(BookName.class);
        BookDescription bookDescription = mock(BookDescription.class);
        BookAvailable bookAvailable = mock(BookAvailable.class);
        BookID bookID = mock(BookID.class);

        // Act
        try (MockedConstruction<Book> bookMockedConstruction = mockConstruction(Book.class, (mock, context) -> {
            when(mock.getId()).thenReturn(bookID);
            when(mock.getName()).thenReturn(bookName);
            when(mock.getDescription()).thenReturn(bookDescription);
            when(mock.isAvailable()).thenReturn(bookAvailable);
        })) {
            Book result = factoryBookImp.createBook(bookID, bookName, bookDescription, bookAvailable);
            // Assert
            assertEquals(bookID, result.getId());
            assertEquals(bookName, result.getName());
            assertEquals(bookDescription, result.getDescription());
            assertEquals(bookAvailable, result.isAvailable());
        }
    }

}