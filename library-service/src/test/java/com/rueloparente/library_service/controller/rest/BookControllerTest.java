package com.rueloparente.library_service.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rueloparente.library_service.dto.controller_request.AddBookRequest;
import com.rueloparente.library_service.dto.controller_request.UpdateBookRequest;
import com.rueloparente.library_service.dto.controller_response.AddBookResponse;
import com.rueloparente.library_service.dto.controller_response.GetBookResponse;
import com.rueloparente.library_service.dto.controller_response.UpdateBookResponse;
import com.rueloparente.library_service.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BookService bookService;

    @Test
    void shouldAddNewBookAndPersistItIfDataIsValid() throws Exception {
        //Arrange
        AddBookRequest addBookRequest = new AddBookRequest("Book Title", "Book Description", true);

        AddBookResponse expectedResponse = new AddBookResponse("Book Title", "Book Description", true);

        String expectedMessage = objectMapper.writeValueAsString(expectedResponse);

        //Act
        mockMvc.perform(
                post("/api/v1/library")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addBookRequest)))
                .andExpect(status().isCreated())
                .andExpect(result -> result.getResponse().getContentAsString().equals(expectedMessage));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @NullSource
    void shouldReturnBadRequestIfTitleFieldIsInvalid(String title) throws Exception {
        //Arrange
        AddBookRequest addBookRequest = new AddBookRequest(title, "", true);

        //Act
        mockMvc.perform(
                post("/api/v1/library")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addBookRequest)))
                .andExpect(status().isBadRequest());
    }
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    @NullSource
    void shouldReturnBadRequestIfDescriptionFieldIsInvalid(String description) throws Exception {
        //Arrange
        AddBookRequest addBookRequest = new AddBookRequest("Book Title", description, true);

        //Act
        mockMvc.perform(
                        post("/api/v1/library")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(addBookRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnEmptyListWhenGetBooksAndNoBooksAreAvailable() throws Exception {
        //Arrange
        List<AddBookResponse> expectedResponse = new ArrayList<>();
        //Act
        mockMvc.perform(get("/api/v1/library"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }

    //Should i add the book using the service or the
    @Test
    void shouldReturnListOfBooksWhenGetBooksAndBooksAreAvailable() throws Exception {
        //Arrange
        AddBookRequest addBookRequest = new AddBookRequest("Book Title", "Book Description", true);
        AddBookRequest addBookRequest2 = new AddBookRequest("Book Title 2", "Book Description 2", true);

        List<AddBookResponse> expectedResponse = List.of(
                new AddBookResponse("Book Title", "Book Description", true),
                new AddBookResponse("Book Title 2", "Book Description 2", true)
        );

        mockMvc.perform(
                post("/api/v1/library")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addBookRequest)));
        mockMvc.perform(
                post("/api/v1/library")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addBookRequest2)));

        //Act
        mockMvc.perform(get("/api/v1/library"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    void shouldUpdateBookAndPersistItIfDataIsValid() throws Exception {
        //Arrange
        AddBookRequest addBookRequest = new AddBookRequest("Book Title", "Book Description", true);

        UpdateBookRequest updateBookRequest = new UpdateBookRequest(1, "New Title", "New Description", false);

        UpdateBookResponse expectedMessage = new UpdateBookResponse("New Title", "New Description", false);

        mockMvc.perform(
                post("/api/v1/library")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addBookRequest)));
        //Act
        mockMvc.perform(
                put("/api/v1/library")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateBookRequest)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedMessage)));
    }

    @Test
    void shouldReturnErrorIfBookToUpdateDoesNotExist() throws Exception {
        //Arrange
        UpdateBookRequest updateBookRequest = new UpdateBookRequest(1, "New Title", "New Description", false);

        //Act
        mockMvc.perform(
                put("/api/v1/library")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateBookRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> result.getResponse().getContentAsString().equals("Book not found!"));
    }

    @Test
    void updatingNonExitingBookShouldNotAddNewBook() throws Exception {
        //Arrange
        UpdateBookRequest updateBookRequest = new UpdateBookRequest(1, "New Title", "New Description", false);
        List<GetBookResponse> expectedResponse = new ArrayList<>();

        //Act
        mockMvc.perform(
                put("/api/v1/library")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateBookRequest)));

        //Assert
        mockMvc.perform(get("/api/v1/library"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    void shouldDeleteBookAndReturnSuccessMessage() throws Exception {
        //Arrange
        AddBookRequest addBookRequest = new AddBookRequest("Book Title", "Book Description", true);
        mockMvc.perform(
                post("/api/v1/library")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(addBookRequest)));

        //Act
        mockMvc.perform(
                delete("/api/v1/library/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Book deleted successfully"));
    }
    @Test
    void shouldReturnErrorIfBookToDeleteDoesNotExist() throws Exception {
        //Act
        mockMvc.perform(
                delete("/api/v1/library/1"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> result.getResponse().getContentAsString().equals("Book not found!"));
    }

}