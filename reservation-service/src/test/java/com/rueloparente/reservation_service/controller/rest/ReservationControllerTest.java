package com.rueloparente.reservation_service.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rueloparente.reservation_service.dto.service_request.CreateReservationRequest;
import com.rueloparente.reservation_service.dto.service_response.ReservationResponse;
import com.rueloparente.reservation_service.service.create_reservation.CreateReservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class ReservationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CreateReservation createReservation;


    @Test
    void shouldAddNewReservationAndPersistItIfDataIsValid() throws Exception {
        //Arrange
        CreateReservationRequest createReservationRequest = new CreateReservationRequest("xpt1", "client1", "2021-01-01T00:00:00");

        ReservationResponse expectedResponse = new ReservationResponse(1, "xpt1", "client1", "2021-01-01T00:00:00", null);

        String expectedMessage = objectMapper.writeValueAsString(expectedResponse);

        //Act & Assert
        mockMvc.perform(
                        post("/api/v1/reservation")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(createReservationRequest)))
                .andExpect(status().isCreated())
                .andExpect(result -> result.getResponse().getContentAsString().equals(expectedMessage));
    }

    @Test
    void shouldReturnBadRequestIfBookIDFieldIsInvalid() throws Exception {
        //Arrange
        CreateReservationRequest createReservationRequest = new CreateReservationRequest(null, "client1", "2021-01-01T00:00:00");

        //Act & Assert
        mockMvc.perform(
                        post("/api/v1/reservation")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(createReservationRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnNotFoundWhenGetReservationByIdAndNotFound() throws Exception {
        //Arrange
        int id = 1;

        //Act & Assert
        mockMvc.perform(
                        get("/api/v1/reservation")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(id)))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnReservationResponseWhenGetReservationByIdAndFound() throws Exception {
        //Arrange
        CreateReservationRequest createReservationRequest = new CreateReservationRequest("xpt1", "client1", "2021-01-01T00:00:00");

        ReservationResponse expectedResponse = new ReservationResponse(1, "xpt1", "client1", "2021-01-01T00:00:00", null);

        createReservation.saveReservation(createReservationRequest);
        String expectedMessage = objectMapper.writeValueAsString(expectedResponse);

        //Act & Assert
        mockMvc.perform(
                        get("/api/v1/reservation")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(1)))
                .andExpect(status().isOk()).andExpect(result -> result.getResponse().getContentAsString().equals(expectedMessage));
    }

    @Test
    void shouldReturnNotFoundWhenGetReservationByBookIdAndNotFound() throws Exception {
        //Arrange
        String bookId = "1";

        //Act & Assert
        mockMvc.perform(
                        get("/api/v1/reservation/book/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(bookId)))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnReservationResponseWhenGetReservationByBookIdAndFound() throws Exception {
        //Arrange
        CreateReservationRequest createReservationRequest = new CreateReservationRequest("xpt1", "client1n", "2021-01-01T00:00:00");

        ReservationResponse expectedResponse = new ReservationResponse(1, "xpt1", "client1", "2021-01-01T00:00:00", null);

        createReservation.saveReservation(createReservationRequest);
        String expectedMessage = objectMapper.writeValueAsString(expectedResponse);

        //Act & Assert
        mockMvc.perform(
                        get("/api/v1/reservation/book/xpt1"))
                .andExpect(status().isOk())
                .andExpect(result -> result.getResponse().getContentAsString().equals(expectedMessage));
    }

    @Test
    void shouldReturnNotFoundWhenGetReservationByClientIdAndNotFound() throws Exception {
        //Arrange
        String clientId = "1";

        //Act & Assert
        mockMvc.perform(
                        get("/api/v1/reservation/client/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(clientId)))
                .andExpect(status().isNotFound());
    }
    @Test
    void shouldReturnReservationResponseWhenGetReservationByClientIdAndFound() throws Exception {
        //Arrange
        CreateReservationRequest createReservationRequest = new CreateReservationRequest("xpt1", "client1", "2021-01-01T00:00:00");

        ReservationResponse expectedResponse = new ReservationResponse(1, "xpt1", "client1", "2021-01-01T00:00:00", null);

        createReservation.saveReservation(createReservationRequest);
        String expectedMessage = objectMapper.writeValueAsString(expectedResponse);

        //Act & Assert
        mockMvc.perform(
                        get("/api/v1/reservation/client/client1"))
                .andExpect(status().isOk())
                .andExpect(result -> result.getResponse().getContentAsString().equals(expectedMessage));
    }

    @Test
    void shouldReturnMultipleReservationsIfClientHasMultipleReservations() throws Exception {
        //Arrange
        CreateReservationRequest createReservationRequest = new CreateReservationRequest("xpt1", "client1", "2021-01-01T00:00:00");
        CreateReservationRequest createReservationRequest2 = new CreateReservationRequest("xpt2", "client1", "2021-01-01T00:00:00");
        CreateReservationRequest reservationRequestFromDifferentClient = new CreateReservationRequest("xpt3", "client2", "2021-01-01T00:00:00");

        ReservationResponse expectedResponse = new ReservationResponse(1, "xpt1", "client1", "2021-01-01T00:00:00", null);
        ReservationResponse expectedResponse2 = new ReservationResponse(2, "xpt2", "client1", "2021-01-01T00:00:00", null);

        createReservation.saveReservation(createReservationRequest);
        createReservation.saveReservation(createReservationRequest2);
        createReservation.saveReservation(reservationRequestFromDifferentClient);

        String expectedMessage = objectMapper.writeValueAsString(List.of(expectedResponse, expectedResponse2));

        //Act & Assert
        mockMvc.perform(
                        get("/api/v1/reservation/client/client1"))
                .andExpect(status().isOk())
                .andExpect(result -> result.getResponse().getContentAsString().equals(expectedMessage));
    }

}