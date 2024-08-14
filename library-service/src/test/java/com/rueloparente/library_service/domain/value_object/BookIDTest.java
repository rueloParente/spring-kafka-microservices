package com.rueloparente.library_service.domain.value_object;

import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BookIDTest {

    @Test
    void shouldReturnBookIDWhenGivenValidValue() {
        //Arrange
        int value = 1;
        BookID bookID = new BookID(value);

        //Act
        int result = bookID.getValue();
        //Assert
        assertEquals(value, result);
    }

    @Test
    void shouldReturnTrueWhenGivenSameBookID() {
        //Arrange
        int value = 1;
        BookID bookID1 = new BookID(value);
        BookID bookID2 = new BookID(value);

        //Act
        boolean result = bookID1.equals(bookID2);

        //Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenGivenDifferentBookID() {
        //Arrange
        int value1 = 1;
        int value2 = 2;
        BookID bookID1 = new BookID(value1);
        BookID bookID2 = new BookID(value2);

        //Act
        boolean result = bookID1.equals(bookID2);

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenGivenDifferentObject() {
        //Arrange
        int value = 1;
        BookID bookID = new BookID(value);

        //Act
        boolean result = bookID.equals(new Object());

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnHashCodeWhenGivenValidValue() {
        //Arrange
        int value = 1;
        BookID bookID = new BookID(value);

        //Act
        int result = bookID.hashCode();

        //Assert
        assertEquals(Objects.hashCode(value), result);
    }

}