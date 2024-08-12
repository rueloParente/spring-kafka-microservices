package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.BookName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BookNameTest {

    @Test
    void shouldReturnBookNameWhenGetValue() {
        // Arrange
        String name = "Book Name";
        BookName bookName = new BookName(name);

        // Act
        String actual = bookName.getValue();

        // Assert
        assertEquals(name, actual);
    }

    @Test
    void shouldReturnTrueWhenEqualsCalledAndSameName() {
        // Arrange
        String name = "Book Name";
        BookName bookName = new BookName(name);
        BookName anotherBookName = new BookName(name);

        // Act
        boolean actual = bookName.equals(anotherBookName);

        // Assert
        assertTrue(actual);
    }

    @Test
    void shouldReturnFalseWhenEqualsAndDifferentName() {
        // Arrange
        String name = "Book Name";
        BookName bookName = new BookName(name);
        BookName anotherBookName = new BookName("Another Book Name");

        // Act
        boolean actual = bookName.equals(anotherBookName);

        // Assert
        assertFalse(actual);
    }

    @Test
    void shouldReturnFalseWhenDifferentObject() {
        // Arrange
        String name = "Book Name";
        BookName bookName = new BookName(name);

        // Act
        boolean actual = bookName.equals(new Object());

        // Assert
        assertFalse(actual);
    }

    @Test
    void shouldReturnHashCodeWhenCalled() {
        // Arrange
        String name = "Book Name";
        BookName bookName = new BookName(name);

        // Act
        int actual = bookName.hashCode();

        // Assert
        assertEquals(name.hashCode(), actual);
    }
    @ParameterizedTest
    //Arrange
    @ValueSource(strings = {"", " ", "  "})
    @NullSource
    void shouldThrowExceptionWhenEmptyOrNullName(String name) {
        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new BookName(name));

        // Assert
        assertEquals("Book name cannot be empty string", exception.getMessage());
    }
}