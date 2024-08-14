package com.rueloparente.library_service.domain.value_object;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

class BookDescriptionTest {

    @Test
    void shouldReturnBookDescriptionWhenGetValue() {
        // Arrange
        String description = "Book Description";
        BookDescription bookDescription = new BookDescription(description);

        // Act
        String actual = bookDescription.getValue();

        // Assert
        assertEquals(description, actual);
    }

    @Test
    void shouldReturnTrueWhenEqualsCalledAndSameDescription() {
        // Arrange
        String description = "Book Description";
        BookDescription bookDescription = new BookDescription(description);
        BookDescription anotherBookDescription = new BookDescription(description);

        // Act
        boolean actual = bookDescription.equals(anotherBookDescription);

        // Assert
        assertTrue(actual);
    }

    @Test
    void shouldReturnFalseWhenEqualsAndDifferentDescription() {
        // Arrange
        String description = "Book Description";
        BookDescription bookDescription = new BookDescription(description);
        BookDescription anotherBookDescription = new BookDescription("Another Book Description");

        // Act
        boolean actual = bookDescription.equals(anotherBookDescription);

        // Assert
        assertFalse(actual);
    }

    @Test
    void shouldReturnFalseWhenDifferentObject() {
        // Arrange
        String description = "Book Description";
        BookDescription bookDescription = new BookDescription(description);

        // Act
        boolean actual = bookDescription.equals(new Object());

        // Assert
        assertFalse(actual);
    }

    @Test
    void shouldReturnHashCodeDerivedFromDescription() {
        // Arrange
        String description = "Book Description";
        BookDescription bookDescription = new BookDescription(description);

        // Act
        int actual = bookDescription.hashCode();

        // Assert
        assertEquals(description.hashCode(), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @NullSource
    void shouldThrowIllegalArgumentExceptionWhenDescriptionIsNullOrBlank(String description) {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new BookDescription(description));
    }

}