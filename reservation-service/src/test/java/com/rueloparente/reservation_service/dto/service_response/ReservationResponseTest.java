package com.rueloparente.reservation_service.dto.service_response;

import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationResponseTest {

    @Test
    void shouldCreateReservationResponse() {
        // Arrange
        int id = 1;
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-01T00:00:00";

        String expected = "ReservationResponse(id=1, bookID=bookID, clientID=clientID, reservationDate=2021-08-01T00:00:00, returnDate=2021-08-01T00:00:00)";

        // Act
        ReservationResponse reservationResponse = new ReservationResponse(id, bookID, clientID, reservationDate, returnDate);

        // Assert
        assertEquals(expected, reservationResponse.toString());
    }

    @Test
    void shouldReturnIDWhenGetID() {
        // Arrange
        int id = 1;
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-01T00:00:00";

        ReservationResponse reservationResponse = new ReservationResponse(id, bookID, clientID, reservationDate, returnDate);

        // Act
        int result = reservationResponse.getId();

        // Assert
        assertEquals(id, result);
    }

    @Test
    void shouldReturnBookIDWhenGetBookID() {
        // Arrange
        int id = 1;
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-01T00:00:00";

        ReservationResponse reservationResponse = new ReservationResponse(id, bookID, clientID, reservationDate, returnDate);

        // Act
        String result = reservationResponse.getBookID();

        // Assert
        assertEquals(bookID, result);
    }

    @Test
    void shouldReturnClientIDWhenGetClientID() {
        // Arrange
        int id = 1;
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-01T00:00:00";

        ReservationResponse reservationResponse = new ReservationResponse(id, bookID, clientID, reservationDate, returnDate);

        // Act
        String result = reservationResponse.getClientID();

        // Assert
        assertEquals(clientID, result);
    }

    @Test
    void shouldReturnReservationDateWhenGetReservationDate() {
        // Arrange
        int id = 1;
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-01T00:00:00";

        ReservationResponse reservationResponse = new ReservationResponse(id, bookID, clientID, reservationDate, returnDate);

        // Act
        String result = reservationResponse.getReservationDate();

        // Assert
        assertEquals(reservationDate, result);
    }

    @Test
    void shouldReturnReturnDateWhenGetReturnDate() {
        // Arrange
        int id = 1;
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-01T00:00:00";

        ReservationResponse reservationResponse = new ReservationResponse(id, bookID, clientID, reservationDate, returnDate);

        // Act
        String result = reservationResponse.getReturnDate();

        // Assert
        assertEquals(returnDate, result);
    }

    @Test
    void shouldReturnNullWhenReturnDateIsNull() {
        // Arrange
        int id = 1;
        String bookID = "bookID";
        String clientID = "clientID";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = null;

        ReservationResponse reservationResponse = new ReservationResponse(id, bookID, clientID, reservationDate, returnDate);

        // Act
        String result = reservationResponse.getReturnDate();

        // Assert
        assertEquals(returnDate, result);
    }
}