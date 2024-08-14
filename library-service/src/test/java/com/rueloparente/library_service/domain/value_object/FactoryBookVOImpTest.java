package com.rueloparente.library_service.domain.value_object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryBookVOImpTest {
    @Test
    void shouldReturnBookTitleWhenCreateBookTitle() {
        // Arrange
        String name = "Book Name";
        FactoryBookVO factoryBookVO = new FactoryBookVOImp();

        // Act
        BookTitle bookTitle = factoryBookVO.createBookTitle(name);

        // Assert
        assertEquals(name, bookTitle.getValue());
    }

    @Test
    void shouldReturnBookDescriptionWhenCreateBookDescription() {
        // Arrange
        String description = "Book Description";
        FactoryBookVO factoryBookVO = new FactoryBookVOImp();

        // Act
        BookDescription bookDescription = factoryBookVO.createBookDescription(description);

        // Assert
        assertEquals(description, bookDescription.getValue());
    }

    @Test
    void shouldReturnBookAvailableWhenCreateBookAvailable() {
        // Arrange
        boolean isAvailable = true;
        FactoryBookVO factoryBookVO = new FactoryBookVOImp();

        // Act
        BookAvailable bookAvailable = factoryBookVO.createBookAvailable(isAvailable);

        // Assert
        assertEquals(isAvailable, bookAvailable.getValue());
    }

    @Test
    void shouldReturnBookIDWhenCreateBookID() {
        // Arrange
        int id = 1;
        FactoryBookVO factoryBookVO = new FactoryBookVOImp();

        // Act
        BookID bookID = factoryBookVO.createBookID(id);

        // Assert
        assertEquals(id, bookID.getValue());
    }

}