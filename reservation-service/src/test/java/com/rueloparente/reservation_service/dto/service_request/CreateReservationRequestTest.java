package com.rueloparente.reservation_service.dto.service_request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateReservationRequestTest {

    @Test
    void shouldCreateCreateReservationRequest() {
        // Arrange
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";

        String expected = "CreateReservationRequest(bookID=bookID, clientID=clientID, reservationDate=2021-08-01T00:00:00)";

        // Act
        CreateReservationRequest createReservationRequest = new CreateReservationRequest(bookID, clientID, reservationDate);

        // Assert
        assertEquals(expected, createReservationRequest.toString());
    }

    @Test
    void shouldReturnBookIDWhenGetBookID() {
        // Arrange
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";

        CreateReservationRequest createReservationRequest = new CreateReservationRequest(bookID, clientID, reservationDate);

        // Act
        String result = createReservationRequest.getBookID();

        // Assert
        assertEquals(bookID, result);
    }

    @Test
    void shouldReturnClientIDWhenGetClientID() {
        // Arrange
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";

        CreateReservationRequest createReservationRequest = new CreateReservationRequest(bookID, clientID, reservationDate);

        // Act
        String result = createReservationRequest.getClientID();

        // Assert
        assertEquals(clientID, result);
    }

    @Test
    void shouldReturnReservationDateWhenGetReservationDate() {
        // Arrange
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";

        CreateReservationRequest createReservationRequest = new CreateReservationRequest(bookID, clientID, reservationDate);

        // Act
        String result = createReservationRequest.getReservationDate();

        // Assert
        assertEquals(reservationDate, result);
    }

}