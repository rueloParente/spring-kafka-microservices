package com.rueloparente.reservation_service.persistence.mapper;

import com.rueloparente.reservation_service.model.Reservation;
import com.rueloparente.reservation_service.model.ReservationBuilderGetter;
import com.rueloparente.reservation_service.persistence.data_model.ReservationDataModel;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservationDataModel2ReservationTest {
    Reservation.ReservationBuilder reservationBuilder = mock(Reservation.ReservationBuilder.class, RETURNS_SELF);
    ReservationBuilderGetter reservationBuilderGetter = mock(ReservationBuilderGetter.class);

    @Test
    void shouldConvertReservationDataModelToReservation() {
        // Arrange
        // Define variables
        int id = 1;
        String bookID = "1";
        LocalDateTime reservationDate = LocalDateTime.parse("2021-01-01T00:00:00");
        LocalDateTime returnDate = LocalDateTime.parse("2021-01-01T00:00:00");
        String clientID = "1";

        //Mock Reservation Data Model
        ReservationDataModel reservationDataModel = mock(ReservationDataModel.class);
        when(reservationDataModel.getId()).thenReturn(id);
        when(reservationDataModel.getBookID()).thenReturn(bookID);
        when(reservationDataModel.getReservationDate()).thenReturn(reservationDate.toString());
        when(reservationDataModel.getReturnDate()).thenReturn(returnDate.toString());
        when(reservationDataModel.getClientID()).thenReturn(clientID);

        // Mock Reservation
        Reservation reservation = mock(Reservation.class);

        ReservationDataModel2Reservation reservationDataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        when(reservationBuilderGetter.getBuilder()).thenReturn(reservationBuilder);

        // Mock Reservation Builder

        when(reservationBuilder.build()).thenReturn(reservation);

        // Act
       Reservation resultingReservation = reservationDataModel2Reservation.toDomain(reservationDataModel);

        // Assert
        assertEquals(reservation, resultingReservation);

        // Verify that the Reservation Builder was called
        verify(reservationBuilder, times(1)).id(id);
        verify(reservationBuilder, times(1)).bookID(bookID);
        verify(reservationBuilder, times(1)).reservationDate(reservationDate);
        verify(reservationBuilder, times(1)).returnDate(returnDate);
        verify(reservationBuilder, times(1)).clientID(clientID);
        verify(reservationBuilder, times(1)).build();
    }

    @Test
    void shouldConvertReservationDataModelListToReservationList() {
        // Arrange
        // Define variables
        int id = 1;
        int id2 = 2;
        String bookID = "1";
        String bookID2 = "2";
        LocalDateTime reservationDate = LocalDateTime.parse("2021-01-01T00:00:00");
        LocalDateTime reservationDate2 = LocalDateTime.parse("2021-02-01T00:00:00");
        LocalDateTime returnDate = LocalDateTime.parse("2021-01-01T00:00:00");
        LocalDateTime returnDate2 = LocalDateTime.parse("2021-03-01T00:00:00");
        String clientID = "1";

        //Mock Reservation Data Model
        ReservationDataModel reservationDataModel = mock(ReservationDataModel.class);
        when(reservationDataModel.getId()).thenReturn(id);
        when(reservationDataModel.getBookID()).thenReturn(bookID);
        when(reservationDataModel.getReservationDate()).thenReturn(reservationDate.toString());
        when(reservationDataModel.getReturnDate()).thenReturn(returnDate.toString());
        when(reservationDataModel.getClientID()).thenReturn(clientID);

        //Mock Second Reservation Data Model
        ReservationDataModel reservationDataModel2 = mock(ReservationDataModel.class);
        when(reservationDataModel2.getId()).thenReturn(id2);
        when(reservationDataModel2.getBookID()).thenReturn(bookID2);
        when(reservationDataModel2.getReservationDate()).thenReturn(reservationDate2.toString());
        when(reservationDataModel2.getReturnDate()).thenReturn(returnDate2.toString());
        when(reservationDataModel2.getClientID()).thenReturn(clientID);

        // Mock Reservation
        Reservation reservation = mock(Reservation.class);
        Reservation reservation2 = mock(Reservation.class);

        ReservationDataModel2Reservation reservationDataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        when(reservationBuilderGetter.getBuilder()).thenReturn(reservationBuilder);

        // Mock Reservation Builder
        when(reservationBuilder.build()).thenReturn(reservation).thenReturn(reservation2);

        List<ReservationDataModel> reservationDataModels = new ArrayList<>();
        reservationDataModels.add(reservationDataModel);
        reservationDataModels.add(reservationDataModel2);

        //Expected Reservations
        List<Reservation> expectedReservations = new ArrayList<>();
        expectedReservations.add(reservation);
        expectedReservations.add(reservation2);

        // Act
        List<Reservation> resultingReservations = reservationDataModel2Reservation.toDomain(reservationDataModels);

        // Assert
        assertEquals(expectedReservations, resultingReservations);

        // Verify that the Reservation Builder was called
        verify(reservationBuilder, times(1)).id(id);
        verify(reservationBuilder, times(1)).id(id2);
        verify(reservationBuilder, times(1)).bookID(bookID);
        verify(reservationBuilder, times(1)).bookID(bookID2);
        verify(reservationBuilder, times(1)).reservationDate(reservationDate);
        verify(reservationBuilder, times(1)).reservationDate(reservationDate2);
        verify(reservationBuilder, times(1)).returnDate(returnDate);
        verify(reservationBuilder, times(1)).returnDate(returnDate2);
        verify(reservationBuilder, times(2)).clientID(clientID);
        verify(reservationBuilder, times(2)).build();
    }

    @Test
    void shouldReturnEmptyListWhenReservationDataModelListIsEmpty() {
        // Arrange
        List<ReservationDataModel> reservationDataModels = new ArrayList<>();
        ReservationDataModel2Reservation reservationDataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);

        // Act
        List<Reservation> resultingReservations = reservationDataModel2Reservation.toDomain(reservationDataModels);

        // Assert
        assertTrue(resultingReservations.isEmpty());
    }

    @Test
    void shouldConvertReservationDataModelListToReservationListWhenReservationsNotReturnedYet() {
        // Arrange
        // Define variables
        int idFinalizedReservation = 1;
        int idOngoingReservation = 2;
        String bookID = "1";
        String bookID2 = "2";
        LocalDateTime reservationDate = LocalDateTime.parse("2021-01-01T00:00:00");
        LocalDateTime reservationDate2 = LocalDateTime.parse("2021-02-01T00:00:00");
        LocalDateTime returnDate = LocalDateTime.parse("2021-01-01T00:00:00");
        LocalDateTime returnDate2 = null;
        String clientID = "1";

        //Mock Reservation Data Model
        ReservationDataModel reservationDataModel = mock(ReservationDataModel.class);
        when(reservationDataModel.getId()).thenReturn(idFinalizedReservation);
        when(reservationDataModel.getBookID()).thenReturn(bookID);
        when(reservationDataModel.getReservationDate()).thenReturn(reservationDate.toString());
        when(reservationDataModel.getReturnDate()).thenReturn(returnDate.toString());
        when(reservationDataModel.getClientID()).thenReturn(clientID);

        //Mock Second Reservation Data Model
        ReservationDataModel reservationDataModel2 = mock(ReservationDataModel.class);
        when(reservationDataModel2.getId()).thenReturn(idOngoingReservation);
        when(reservationDataModel2.getBookID()).thenReturn(bookID2);
        when(reservationDataModel2.getReservationDate()).thenReturn(reservationDate2.toString());
        when(reservationDataModel2.getReturnDate()).thenReturn(null);
        when(reservationDataModel2.getClientID()).thenReturn(clientID);

        // Mock Reservation
        Reservation reservation = mock(Reservation.class);
        Reservation reservation2 = mock(Reservation.class);

        ReservationDataModel2Reservation reservationDataModel2Reservation = new ReservationDataModel2Reservation(reservationBuilderGetter);
        when(reservationBuilderGetter.getBuilder()).thenReturn(reservationBuilder);

        // Mock Reservation Builder
        when(reservationBuilder.build()).thenReturn(reservation).thenReturn(reservation2);

        List<ReservationDataModel> reservationDataModels = new ArrayList<>();
        reservationDataModels.add(reservationDataModel);
        reservationDataModels.add(reservationDataModel2);

        //Expected Reservations
        List<Reservation> expectedReservations = new ArrayList<>();
        expectedReservations.add(reservation);
        expectedReservations.add(reservation2);

        // Act
        List<Reservation> resultingReservations = reservationDataModel2Reservation.toDomain(reservationDataModels);

        // Assert
        assertEquals(expectedReservations, resultingReservations);

        // Verify that the Reservation Builder was called
        verify(reservationBuilder, times(1)).id(idFinalizedReservation);
        verify(reservationBuilder, times(1)).id(idOngoingReservation);
        verify(reservationBuilder, times(1)).bookID(bookID);
        verify(reservationBuilder, times(1)).bookID(bookID2);
        verify(reservationBuilder, times(1)).reservationDate(reservationDate);
        verify(reservationBuilder, times(1)).reservationDate(reservationDate2);
        verify(reservationBuilder, times(1)).returnDate(returnDate);
        verify(reservationBuilder, times(1)).returnDate(returnDate2);

        verify(reservationBuilder, times(2)).clientID(clientID);
        verify(reservationBuilder, times(2)).build();
    }

}