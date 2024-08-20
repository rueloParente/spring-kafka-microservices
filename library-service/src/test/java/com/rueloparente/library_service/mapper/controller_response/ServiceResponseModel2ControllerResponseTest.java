package com.rueloparente.library_service.mapper.controller_response;

import com.rueloparente.library_service.dto.controller_response.AddBookResponse;
import com.rueloparente.library_service.dto.controller_response.GetBookResponse;
import com.rueloparente.library_service.dto.controller_response.UpdateBookResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceResponseModel2ControllerResponseTest {

    @Test
    void shouldReturnAddBookResponse() {
        //Arrange
        ServiceResponseModel2ControllerResponse serviceResponseModel2ControllerResponse = new ServiceResponseModel2ControllerResponse();
        String title = "Book Title";
        String description = "Book Description";
        boolean available = true;

        //Act
        AddBookResponse addBookResponse = serviceResponseModel2ControllerResponse.toControllerAddBookResponse(title, description, available);

        //Assert
        assertEquals(title, addBookResponse.title);
        assertEquals(description, addBookResponse.description);
        assertEquals(available, addBookResponse.available);
    }

    @Test
    void shouldReturnGetBookResponse() {
        //Arrange
        ServiceResponseModel2ControllerResponse serviceResponseModel2ControllerResponse = new ServiceResponseModel2ControllerResponse();
        int bookID = 1;
        String title = "Book Title";
        String description = "Book Description";
        boolean available = true;

        //Act
        GetBookResponse getBookResponse = serviceResponseModel2ControllerResponse.toControllerGetBookResponse(bookID, title, description, available);

        //Assert
        assertEquals(bookID, getBookResponse.bookID);
        assertEquals(title, getBookResponse.title);
        assertEquals(description, getBookResponse.description);
        assertEquals(available, getBookResponse.available);
    }

    @Test
    void shouldReturnUpdateBookResponse() {
        //Arrange
        ServiceResponseModel2ControllerResponse serviceResponseModel2ControllerResponse = new ServiceResponseModel2ControllerResponse();
        String title = "Book Title";
        String description = "Book Description";
        boolean available = true;

        //Act
        UpdateBookResponse updateBookResponse = serviceResponseModel2ControllerResponse.toControllerUpdateBookResponse(title, description, available);

        //Assert
        assertEquals(title, updateBookResponse.title);
        assertEquals(description, updateBookResponse.description);
        assertEquals(available, updateBookResponse.available);
    }

}