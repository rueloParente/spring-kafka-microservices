package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void shouldReturnTrueWhenGivenSameBook() {
        //Arrange
        Book book1 = new Book(new BookID(1), new BookTitle("Book1"), new BookDescription("Description1"), new BookAvailable(true));
        Book book2 = new Book(new BookID(1), new BookTitle("Book1"), new BookDescription("Description1"), new BookAvailable(true));

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenGivenDifferentBook() {
        //Arrange
        Book book1 = new Book(new BookID(1), new BookTitle("Book1"), new BookDescription("Description1"), new BookAvailable(true));
        Book book2 = new Book(new BookID(2), new BookTitle("Book2"), new BookDescription("Description2"), new BookAvailable(false));

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenGivenDifferentObject() {
        //Arrange
        Book book = new Book(new BookID(1), new BookTitle("Book1"), new BookDescription("Description1"), new BookAvailable(true));

        //Act
        boolean result = book.equals(new Object());

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnBookNameWhenGivenValidValue() {
        //Arrange
        BookTitle bookTitle = new BookTitle("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookTitle, bookDescription, bookAvailable);

        //Act
        BookTitle result = book.getName();

        //Assert
        assertEquals(bookTitle, result);
    }

    @Test
    void shouldReturnBookDescriptionWhenGivenValidValue() {
        //Arrange
        BookTitle bookTitle = new BookTitle("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookTitle, bookDescription, bookAvailable);

        //Act
        BookDescription result = book.getDescription();

        //Assert
        assertEquals(bookDescription, result);
    }

    @Test
    void shouldReturnBookAvailableWhenGivenValidValue() {
        //Arrange
        BookTitle bookTitle = new BookTitle("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookTitle, bookDescription, bookAvailable);

        //Act
        BookAvailable result = book.isAvailable();

        //Assert
        assertEquals(bookAvailable, result);
    }

    @Test
    void shouldReturnBookIDWhenGivenValidValue() {
        //Arrange
        BookID bookID = new BookID(1);
        BookTitle bookTitle = new BookTitle("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        //Act
        BookID result = book.getId();

        //Assert
        assertEquals(bookID, result);
    }

    @Test
    void shouldSetBookIDWhenGivenValidValue() {
        //Arrange
        BookID bookID = new BookID(1);
        BookTitle bookTitle = new BookTitle("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookTitle, bookDescription, bookAvailable);

        //Act
        BookID result = book.setId(bookID);

        //Assert
        assertEquals(bookID, result);
    }

    @Test
    void shouldSetBookAvailableWhenGivenValidValue() {
        //Arrange
        BookTitle bookTitle = new BookTitle("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookTitle, bookDescription, new BookAvailable(false));

        //Act
        BookAvailable result = book.setAvailable(bookAvailable);

        //Assert
        assertEquals(bookAvailable, result);
    }

    @Test
    void shouldReturnHashCodeWhenGivenValidValue() {
        //Arrange
        BookID bookID = new BookID(1);
        BookTitle bookTitle = new BookTitle("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        int expected = Objects.hash(bookID, bookTitle, bookDescription, bookAvailable);
        //Act
        int result = book.hashCode();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnStringWhenGivenValidValue() {
        //Arrange
        BookID bookID = new BookID(1);
        BookTitle bookTitle = new BookTitle("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        String expected = "Book{" +
                "id=" + bookID.getValue() +
                ", name=" + bookTitle.getValue() +
                ", description=" + bookDescription.getValue() +
                ", available=" + bookAvailable.getValue() +
                '}';
        //Act
        String result = book.toString();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnFalseWhenGivenNull() {
        //Arrange
        Book book = new Book(new BookID(1), new BookTitle("Book1"), new BookDescription("Description1"), new BookAvailable(true));

        //Act
        boolean result = book.equals(null);

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenComparingSameObject() {
        //Arrange
        Book book = new Book(new BookID(1), new BookTitle("Book1"), new BookDescription("Description1"), new BookAvailable(true));

        //Act
        boolean result = book.equals(book);

        //Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenOneAttributeIsDifferent() {
        //Arrange
        Book book1 = new Book(new BookID(1), new BookTitle("Book1"), new BookDescription("Description1"), new BookAvailable(true));
        Book book2 = new Book(new BookID(1), new BookTitle("Book2"), new BookDescription("Description1"), new BookAvailable(true));

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertFalse(result);
    }
    @Test
    void shouldReturnFalseWhenOnlyDifferentIsDescription() {
        //Arrange
        Book book1 = new Book(new BookID(1), new BookTitle("Book1"), new BookDescription("Description1"), new BookAvailable(true));
        Book book2 = new Book(new BookID(1), new BookTitle("Book1"), new BookDescription("Description2"), new BookAvailable(true));

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertFalse(result);
    }


}