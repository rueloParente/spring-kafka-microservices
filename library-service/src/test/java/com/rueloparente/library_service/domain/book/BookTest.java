package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void shouldReturnTrueWhenGivenSameBook() {
        //Arrange
        Book book1 = new Book(new BookID(1), new BookName("Book1"), new BookDescription("Description1"), new BookAvailable(true));
        Book book2 = new Book(new BookID(1), new BookName("Book1"), new BookDescription("Description1"), new BookAvailable(true));

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenGivenDifferentBook() {
        //Arrange
        Book book1 = new Book(new BookID(1), new BookName("Book1"), new BookDescription("Description1"), new BookAvailable(true));
        Book book2 = new Book(new BookID(2), new BookName("Book2"), new BookDescription("Description2"), new BookAvailable(false));

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenGivenDifferentObject() {
        //Arrange
        Book book = new Book(new BookID(1), new BookName("Book1"), new BookDescription("Description1"), new BookAvailable(true));

        //Act
        boolean result = book.equals(new Object());

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnBookNameWhenGivenValidValue() {
        //Arrange
        BookName bookName = new BookName("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookName, bookDescription, bookAvailable);

        //Act
        BookName result = book.getName();

        //Assert
        assertEquals(bookName, result);
    }

    @Test
    void shouldReturnBookDescriptionWhenGivenValidValue() {
        //Arrange
        BookName bookName = new BookName("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookName, bookDescription, bookAvailable);

        //Act
        BookDescription result = book.getDescription();

        //Assert
        assertEquals(bookDescription, result);
    }

    @Test
    void shouldReturnBookAvailableWhenGivenValidValue() {
        //Arrange
        BookName bookName = new BookName("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookName, bookDescription, bookAvailable);

        //Act
        BookAvailable result = book.isAvailable();

        //Assert
        assertEquals(bookAvailable, result);
    }

    @Test
    void shouldReturnBookIDWhenGivenValidValue() {
        //Arrange
        BookID bookID = new BookID(1);
        BookName bookName = new BookName("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookID, bookName, bookDescription, bookAvailable);

        //Act
        BookID result = book.getId();

        //Assert
        assertEquals(bookID, result);
    }

    @Test
    void shouldSetBookIDWhenGivenValidValue() {
        //Arrange
        BookID bookID = new BookID(1);
        BookName bookName = new BookName("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookName, bookDescription, bookAvailable);

        //Act
        BookID result = book.setId(bookID);

        //Assert
        assertEquals(bookID, result);
    }

    @Test
    void shouldSetBookAvailableWhenGivenValidValue() {
        //Arrange
        BookName bookName = new BookName("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookName, bookDescription, new BookAvailable(false));

        //Act
        BookAvailable result = book.setAvailable(bookAvailable);

        //Assert
        assertEquals(bookAvailable, result);
    }

    @Test
    void shouldReturnHashCodeWhenGivenValidValue() {
        //Arrange
        BookID bookID = new BookID(1);
        BookName bookName = new BookName("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookID, bookName, bookDescription, bookAvailable);

        int expected = Objects.hash(bookID, bookName, bookDescription, bookAvailable);
        //Act
        int result = book.hashCode();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnStringWhenGivenValidValue() {
        //Arrange
        BookID bookID = new BookID(1);
        BookName bookName = new BookName("Book1");
        BookDescription bookDescription = new BookDescription("Description1");
        BookAvailable bookAvailable = new BookAvailable(true);
        Book book = new Book(bookID, bookName, bookDescription, bookAvailable);

        String expected = "Book{" +
                "id=" + bookID.getValue() +
                ", name=" + bookName.getValue() +
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
        Book book = new Book(new BookID(1), new BookName("Book1"), new BookDescription("Description1"), new BookAvailable(true));

        //Act
        boolean result = book.equals(null);

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenComparingSameObject() {
        //Arrange
        Book book = new Book(new BookID(1), new BookName("Book1"), new BookDescription("Description1"), new BookAvailable(true));

        //Act
        boolean result = book.equals(book);

        //Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenOneAttributeIsDifferent() {
        //Arrange
        Book book1 = new Book(new BookID(1), new BookName("Book1"), new BookDescription("Description1"), new BookAvailable(true));
        Book book2 = new Book(new BookID(1), new BookName("Book2"), new BookDescription("Description1"), new BookAvailable(true));

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertFalse(result);
    }
    @Test
    void shouldReturnFalseWhenOnlyDifferentIsDescription() {
        //Arrange
        Book book1 = new Book(new BookID(1), new BookName("Book1"), new BookDescription("Description1"), new BookAvailable(true));
        Book book2 = new Book(new BookID(1), new BookName("Book1"), new BookDescription("Description2"), new BookAvailable(true));

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertFalse(result);
    }


}