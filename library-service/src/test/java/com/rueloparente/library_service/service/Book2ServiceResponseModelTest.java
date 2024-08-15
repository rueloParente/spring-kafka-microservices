package com.rueloparente.library_service.service;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;
import com.rueloparente.library_service.dto.service_response.BookResponseModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class Book2ServiceResponseModelTest {
    @Test
    void shouldConvertBookToServiceResponseModel() {
        // Arrange
        Book2ServiceResponseModel book2ServiceResponseModel = new Book2ServiceResponseModel();

        // Mock book value objects
        BookID bookID = mock(BookID.class);
        when(bookID.getValue()).thenReturn(1);
        BookTitle bookTitle = mock(BookTitle.class);
        when(bookTitle.getValue()).thenReturn("title");
        BookDescription bookDescription = mock(BookDescription.class);
        when(bookDescription.getValue()).thenReturn("description");
        BookAvailable bookAvailable = mock(BookAvailable.class);
        when(bookAvailable.getValue()).thenReturn(true);

        String expected = "BookResponseModel{bookID=1, bookName='title', bookDescription='description', bookAvailable=true}";
        // Act
        BookResponseModel bookResponseModel = book2ServiceResponseModel.toServiceResponseModel(bookID, bookTitle, bookDescription, bookAvailable);

        // Assert
        assertEquals(expected, bookResponseModel.toString());
    }
}