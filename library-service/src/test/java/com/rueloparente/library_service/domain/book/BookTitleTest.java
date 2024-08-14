package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.BookTitle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BookTitleTest {

    @Test
    void shouldReturnBookNameWhenGetValue() {
        // Arrange
        String name = "Book Name";
        BookTitle bookTitle = new BookTitle(name);

        // Act
        String actual = bookTitle.getValue();

        // Assert
        assertEquals(name, actual);
    }

    @Test
    void shouldReturnTrueWhenEqualsCalledAndSameName() {
        // Arrange
        String name = "Book Name";
        BookTitle bookTitle = new BookTitle(name);
        BookTitle anotherBookTitle = new BookTitle(name);

        // Act
        boolean actual = bookTitle.equals(anotherBookTitle);

        // Assert
        assertTrue(actual);
    }

    @Test
    void shouldReturnFalseWhenEqualsAndDifferentName() {
        // Arrange
        String name = "Book Name";
        BookTitle bookTitle = new BookTitle(name);
        BookTitle anotherBookTitle = new BookTitle("Another Book Name");

        // Act
        boolean actual = bookTitle.equals(anotherBookTitle);

        // Assert
        assertFalse(actual);
    }

    @Test
    void shouldReturnFalseWhenDifferentObject() {
        // Arrange
        String name = "Book Name";
        BookTitle bookTitle = new BookTitle(name);

        // Act
        boolean actual = bookTitle.equals(new Object());

        // Assert
        assertFalse(actual);
    }

    @Test
    void shouldReturnHashCodeWhenCalled() {
        // Arrange
        String name = "Book Name";
        BookTitle bookTitle = new BookTitle(name);

        // Act
        int actual = bookTitle.hashCode();

        // Assert
        assertEquals(name.hashCode(), actual);
    }
    @ParameterizedTest
    //Arrange
    @ValueSource(strings = {"", " ", "  "})
    @NullSource
    void shouldThrowExceptionWhenEmptyOrNullName(String name) {
        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new BookTitle(name));

        // Assert
        assertEquals("Book name cannot be empty string", exception.getMessage());
    }
}