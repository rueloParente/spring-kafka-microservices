package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookAvailableTest {
    @Test
    void shouldReturnTrueWhenBookIsAvailable() {
        // Arrange
        BookAvailable bookAvailable = new BookAvailable(true);

        // Act
        boolean isAvailable = bookAvailable.getValue();

        // Assert
        assertTrue(isAvailable);
    }
    @Test
    void shouldReturnFalseWhenBookIsNotAvailable() {
        // Arrange
        BookAvailable bookAvailable = new BookAvailable(false);

        // Act
        boolean isAvailable = bookAvailable.getValue();

        // Assert
        assertFalse(isAvailable);
    }

    @Test
    void shouldReturnTrueWhenEqualsCalledAndSameAvailability() {
        // Arrange
        BookAvailable bookAvailable = new BookAvailable(true);
        BookAvailable anotherBookAvailable = new BookAvailable(true);

        // Act
        boolean actual = bookAvailable.equals(anotherBookAvailable);

        // Assert
        assertTrue(actual);
    }

    @Test
    void shouldReturnFalseWhenEqualsAndDifferentAvailability() {
        // Arrange
        BookAvailable bookAvailable = new BookAvailable(true);
        BookAvailable anotherBookAvailable = new BookAvailable(false);

        // Act
        boolean actual = bookAvailable.equals(anotherBookAvailable);

        // Assert
        assertFalse(actual);
    }

    @Test
    void shouldReturnFalseWhenDifferentObject() {
        // Arrange
        BookAvailable bookAvailable = new BookAvailable(true);

        // Act
        boolean actual = bookAvailable.equals(new Object());

        // Assert
        assertFalse(actual);
    }

    @Test
    void shouldReturnHashCodeDerivedFromValue() {
        // Arrange
        BookAvailable bookAvailable = new BookAvailable(true);

        // Act
        int actual = bookAvailable.hashCode();

        // Assert
        assertEquals(Boolean.hashCode(true), actual);
    }



}