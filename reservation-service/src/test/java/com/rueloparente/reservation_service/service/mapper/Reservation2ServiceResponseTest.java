package com.rueloparente.reservation_service.service.mapper;

import com.rueloparente.reservation_service.dto.service_response.ReservationResponse;
import com.rueloparente.reservation_service.model.Reservation;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class Reservation2ServiceResponseTest {
     @Test
     void shouldReturnReservationResponse() {
         // Arrange
         int reservationId = 1;
         String bookId = "1";
         String clientId = "1";
         LocalDateTime reservationDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
         LocalDateTime returnDate = null;

         //Mocking Reservation
         Reservation reservation = mock(Reservation.class);
         when(reservation.getId()).thenReturn(reservationId);
         when(reservation.getBookID()).thenReturn(bookId);
         when(reservation.getClientID()).thenReturn(clientId);
         when(reservation.getReservationDate()).thenReturn(reservationDate);
         when(reservation.getReturnDate()).thenReturn(returnDate);

         String expected = "ReservationResponse{id=1, bookID='1', clientID='1', reservationDate='" + reservationDate + "', returnDate='null'" + "}";

         Reservation2ServiceResponse reservation2ServiceResponse = new Reservation2ServiceResponse();
         int expectedNumberOfConstructorsCalls = 1;

         // Act
         try (MockedConstruction<ReservationResponse> reservationResponseMockedConstruction = mockConstruction(ReservationResponse.class, (mock, context) -> {
                // Storing the arguments passed to the constructor of ReservationResponse
                int reservationIdPassedToConstructor = (int) context.arguments().get(0);
                String bookIdPassedToConstructor = (String) context.arguments().get(1);
                String clientIdPassedToConstructor = (String) context.arguments().get(2);
                String reservationDatePassedToConstructor = (String) context.arguments().get(3);
                String returnDatePassedToConstructor = (String) context.arguments().get(4);

                // Mocking the methods of ReservationResponse
                when(mock.toString()).thenReturn("ReservationResponse{id=" + reservationIdPassedToConstructor + ", bookID='" + bookIdPassedToConstructor +
                        "', clientID='" + clientIdPassedToConstructor + "', reservationDate='" + reservationDatePassedToConstructor + "', returnDate='" + returnDatePassedToConstructor + "'}");

         })) {
             // Act
             ReservationResponse result = reservation2ServiceResponse.domain2ServiceResponse(reservation);

             String actual = result.toString();
             // Assert
             assertEquals(expected, actual);
             assertEquals(expectedNumberOfConstructorsCalls, reservationResponseMockedConstruction.constructed().size());
         }

     }

        @Test
        void shouldReturnReservationResponseWithReturnDate() {
            // Arrange
            int reservationId = 1;
            String bookId = "1";
            String clientId = "1";
            LocalDateTime reservationDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            LocalDateTime returnDate = LocalDateTime.now().plusDays(1).truncatedTo(ChronoUnit.SECONDS);

            //Mocking Reservation
            Reservation reservation = mock(Reservation.class);
            when(reservation.getId()).thenReturn(reservationId);
            when(reservation.getBookID()).thenReturn(bookId);
            when(reservation.getClientID()).thenReturn(clientId);
            when(reservation.getReservationDate()).thenReturn(reservationDate);
            when(reservation.getReturnDate()).thenReturn(returnDate);

            String expected = "ReservationResponse{id=1, bookID='1', clientID='1', reservationDate='" + reservationDate + "', returnDate='" + returnDate + "'}";

            Reservation2ServiceResponse reservation2ServiceResponse = new Reservation2ServiceResponse();
            int expectedNumberOfConstructorsCalls = 1;

            // Act
            try (MockedConstruction<ReservationResponse> reservationResponseMockedConstruction = mockConstruction(ReservationResponse.class, (mock, context) -> {
                   // Storing the arguments passed to the constructor of ReservationResponse
                   int reservationIdPassedToConstructor = (int) context.arguments().get(0);
                   String bookIdPassedToConstructor = (String) context.arguments().get(1);
                   String clientIdPassedToConstructor = (String) context.arguments().get(2);
                   String reservationDatePassedToConstructor = (String) context.arguments().get(3);
                   String returnDatePassedToConstructor = (String) context.arguments().get(4);

                   // Mocking the methods of ReservationResponse
                   when(mock.toString()).thenReturn("ReservationResponse{id=" + reservationIdPassedToConstructor + ", bookID='" + bookIdPassedToConstructor +
                           "', clientID='" + clientIdPassedToConstructor + "', reservationDate='" + reservationDatePassedToConstructor + "', returnDate='" + returnDatePassedToConstructor + "'}");

            })) {
                // Act
                ReservationResponse result = reservation2ServiceResponse.domain2ServiceResponse(reservation);

                String actual = result.toString();
                // Assert
                assertEquals(expected, actual);
                assertEquals(expectedNumberOfConstructorsCalls, reservationResponseMockedConstruction.constructed().size());
            }
        }

        @Test
        void shouldReturnListOfReservationResponseWithTwoElements() {
            // Arrange
            int reservationId1 = 1;
            String bookId1 = "1";
            String clientId1 = "1";
            LocalDateTime reservationDate1 = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            LocalDateTime returnDate1 = null;

            int reservationId2 = 2;
            String bookId2 = "2";
            String clientId2 = "2";
            LocalDateTime reservationDate2 = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            LocalDateTime returnDate2 = null;

            //Mocking Reservation
            Reservation reservation1 = mock(Reservation.class);
            when(reservation1.getId()).thenReturn(reservationId1);
            when(reservation1.getBookID()).thenReturn(bookId1);
            when(reservation1.getClientID()).thenReturn(clientId1);
            when(reservation1.getReservationDate()).thenReturn(reservationDate1);
            when(reservation1.getReturnDate()).thenReturn(returnDate1);

            Reservation reservation2 = mock(Reservation.class);
            when(reservation2.getId()).thenReturn(reservationId2);
            when(reservation2.getBookID()).thenReturn(bookId2);
            when(reservation2.getClientID()).thenReturn(clientId2);
            when(reservation2.getReservationDate()).thenReturn(reservationDate2);
            when(reservation2.getReturnDate()).thenReturn(returnDate2);


            List<Reservation> reservations = List.of(reservation1, reservation2);
            String expected = "[ReservationResponse{id=1, bookID='1', clientID='1', reservationDate='" + reservationDate1 + "', returnDate='null'}, " +
                    "ReservationResponse{id=2, bookID='2', clientID='2', reservationDate='" + reservationDate2 + "', returnDate='null'}]";


            Reservation2ServiceResponse reservation2ServiceResponse = new Reservation2ServiceResponse();
            int expectedNumberOfConstructorsCalls = 2;

            // Act
            try (MockedConstruction<ReservationResponse> reservationResponseMockedConstruction = mockConstruction(ReservationResponse.class, (mock, context) -> {
                // Storing the arguments passed to the constructor of ReservationResponse
                int reservationIdPassedToConstructor = (int) context.arguments().get(0);
                String bookIdPassedToConstructor = (String) context.arguments().get(1);
                String clientIdPassedToConstructor = (String) context.arguments().get(2);
                String reservationDatePassedToConstructor = (String) context.arguments().get(3);
                String returnDatePassedToConstructor = (String) context.arguments().get(4);

                // Mocking the methods of ReservationResponse
                when(mock.toString()).thenReturn("ReservationResponse{id=" + reservationIdPassedToConstructor + ", bookID='" + bookIdPassedToConstructor +
                        "', clientID='" + clientIdPassedToConstructor + "', reservationDate='" + reservationDatePassedToConstructor + "', returnDate='" + returnDatePassedToConstructor + "'}");

            })) {
                // Act
                List<ReservationResponse> result = reservation2ServiceResponse.domain2ServiceResponse(reservations);

                String actual = result.toString();
                // Assert
                assertEquals(expected, actual);
                assertEquals(expectedNumberOfConstructorsCalls, reservationResponseMockedConstruction.constructed().size());
            }
        }



     }