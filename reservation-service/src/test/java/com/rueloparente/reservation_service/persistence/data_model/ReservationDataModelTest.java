package com.rueloparente.reservation_service.persistence.data_model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationDataModelTest {

    @Test
    void shouldCreateReservationDataModelWithNoArgs() {
        // Arrange
        String expectedDataModel = "ReservationDataModel(id=null, bookID=null, reservationDate=null, returnDate=null, clientID=null)";
        // Act
        ReservationDataModel reservationDataModel = new ReservationDataModel();
        String actualDataModel = reservationDataModel.toString();
        // Assert
        assertEquals(expectedDataModel, actualDataModel);
    }

    @Test
    void shouldCreateReservationDataModelWithBuilder() {
        // Arrange
        int id = 1;
        String bookID = "1";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-08T00:00:00";
        String clientID = "1";

        String expectedDataModel = "ReservationDataModel(id=1, bookID=1, reservationDate=2021-08-01T00:00:00, returnDate=2021-08-08T00:00:00, clientID=1)";
        // Act
        ReservationDataModel reservationDataModel = ReservationDataModel.builder()
                .id(id)
                .bookID(bookID)
                .reservationDate(reservationDate)
                .returnDate(returnDate)
                .clientID(clientID)
                .build();
        String actualDataModel = reservationDataModel.toString();
        // Assert
        assertEquals(expectedDataModel, actualDataModel);
    }

    @Test
    void shouldReturnCorrectValuesWhenGetID() {
        // Arrange
        int id = 1;
        // Act
        ReservationDataModel reservationDataModel = ReservationDataModel.builder()
                .id(id)
                .build();
        int actualID = reservationDataModel.getId();
        // Assert
        assertEquals(id, actualID);
    }

    @Test
    void shouldReturnCorrectValuesWhenGetBookID() {
        // Arrange
        String bookID = "1";
        // Act
        ReservationDataModel reservationDataModel = ReservationDataModel.builder()
                .bookID(bookID)
                .build();
        String actualBookID = reservationDataModel.getBookID();
        // Assert
        assertEquals(bookID, actualBookID);
    }

    @Test
    void shouldReturnCorrectValuesWhenGetReservationDate() {
        // Arrange
        String reservationDate = "2021-08-01T00:00:00";
        // Act
        ReservationDataModel reservationDataModel = ReservationDataModel.builder()
                .reservationDate(reservationDate)
                .build();
        String actualReservationDate = reservationDataModel.getReservationDate();
        // Assert
        assertEquals(reservationDate, actualReservationDate);
    }

    @Test
    void shouldReturnCorrectValuesWhenGetReturnDate() {
        // Arrange
        String returnDate = "2021-08-08T00:00:00";
        // Act
        ReservationDataModel reservationDataModel = ReservationDataModel.builder()
                .returnDate(returnDate)
                .build();
        String actualReturnDate = reservationDataModel.getReturnDate();
        // Assert
        assertEquals(returnDate, actualReturnDate);
    }

    @Test
    void shouldReturnCorrectValuesWhenGetClientID() {
        // Arrange
        String clientID = "1";
        // Act
        ReservationDataModel reservationDataModel = ReservationDataModel.builder()
                .clientID(clientID)
                .build();
        String actualClientID = reservationDataModel.getClientID();
        // Assert
        assertEquals(clientID, actualClientID);
    }

    @Test
    void shouldInstantiateCorrectDataModelWhenAllArgsConstructorUsed() {
        // Arrange
        int id = 1;
        String bookID = "1";
        String reservationDate = "2021-08-01T00:00:00";
        String returnDate = "2021-08-08T00:00:00";
        String clientID = "1";

        String expectedDataModel = "ReservationDataModel(id=1, bookID=1, reservationDate=2021-08-01T00:00:00, returnDate=2021-08-08T00:00:00, clientID=1)";
        // Act
        ReservationDataModel reservationDataModel = new ReservationDataModel(id, bookID, reservationDate, returnDate, clientID);
        String actualDataModel = reservationDataModel.toString();
        // Assert
        assertEquals(expectedDataModel, actualDataModel);
    }


}