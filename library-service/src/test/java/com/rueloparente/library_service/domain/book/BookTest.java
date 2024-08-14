package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.domain.value_object.*;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void shouldReturnTrueWhenGivenSameBook() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book1 = new Book(bookID, bookTitle, bookDescription, bookAvailable);
        Book book2 = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenGivenDifferentBook() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();

        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book1 = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        BookID bookID2 = bookFactoryVO.createBookID(2);
        BookTitle bookTitle2 = bookFactoryVO.createBookTitle("Book2");
        BookDescription bookDescription2 = bookFactoryVO.createBookDescription("Description2");
        BookAvailable bookAvailable2 = bookFactoryVO.createBookAvailable(false);
        Book book2 = new Book(bookID2, bookTitle2, bookDescription2, bookAvailable2);

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhenGivenDifferentObject() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        //Act
        boolean result = book.equals(new Object());

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnBookNameWhenGivenValidValue() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        //Act
        BookTitle result = book.getName();

        //Assert
        assertEquals(bookTitle, result);
    }

    @Test
    void shouldReturnBookDescriptionWhenGivenValidValue() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        //Act
        BookDescription result = book.getDescription();

        //Assert
        assertEquals(bookDescription, result);
    }

    @Test
    void shouldReturnBookAvailableWhenGivenValidValue() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        //Act
        BookAvailable result = book.isAvailable();

        //Assert
        assertEquals(bookAvailable, result);
    }

    @Test
    void shouldReturnBookIDWhenGivenValidValue() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        //Act
        BookID result = book.getId();

        //Assert
        assertEquals(bookID, result);
    }

    @Test
    void shouldSetBookIDWhenGivenValidValue() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        //Act
        BookID result = book.setId(bookID);

        //Assert
        assertEquals(bookID, result);
    }

    @Test
    void shouldSetBookAvailableWhenGivenValidValue() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book = new Book(bookTitle, bookDescription, bookAvailable);

        //Act
        BookAvailable result = book.setAvailable(bookAvailable);

        //Assert
        assertEquals(bookAvailable, result);
    }

    @Test
    void shouldReturnHashCodeWhenGivenValidValue() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
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
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
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
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        //Act
        boolean result = book.equals(null);

        //Assert
        assertFalse(result);
    }

    @Test
    void shouldReturnTrueWhenComparingSameObject() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        //Act
        boolean result = book.equals(book);

        //Assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenOneAttributeIsDifferent() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookTitle bookTitle2 = bookFactoryVO.createBookTitle("Book2");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book1 = new Book(bookID, bookTitle, bookDescription, bookAvailable);

        Book book2 = new Book(bookID, bookTitle2, bookDescription, bookAvailable);
        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertFalse(result);
    }
    @Test
    void shouldReturnFalseWhenOnlyDifferentIsDescription() {
        //Arrange
        FactoryBookVO bookFactoryVO = new FactoryBookVOImp();
        BookID bookID = bookFactoryVO.createBookID(1);
        BookTitle bookTitle = bookFactoryVO.createBookTitle("Book1");
        BookDescription bookDescription = bookFactoryVO.createBookDescription("Description1");
        BookDescription bookDescription2 = bookFactoryVO.createBookDescription("Description2");
        BookAvailable bookAvailable = bookFactoryVO.createBookAvailable(true);
        Book book1 = new Book(bookID, bookTitle, bookDescription, bookAvailable);
        Book book2 = new Book(bookID, bookTitle, bookDescription2, bookAvailable);

        //Act
        boolean result = book1.equals(book2);

        //Assert
        assertFalse(result);
    }


}