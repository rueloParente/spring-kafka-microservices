package com.rueloparente.reservation_service.service.create_reservation;

import com.rueloparente.reservation_service.dto.service_request.CreateReservationRequest;
import com.rueloparente.reservation_service.dto.service_response.ReservationResponse;
import com.rueloparente.reservation_service.model.Reservation;
import com.rueloparente.reservation_service.model.ReservationBuilderGetter;
import com.rueloparente.reservation_service.persistence.ReservationRepository;
import com.rueloparente.reservation_service.service.mapper.Reservation2ServiceResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreateReservationImpTest {
    Reservation.ReservationBuilder reservationBuilder = mock(Reservation.ReservationBuilder.class, RETURNS_DEEP_STUBS);

    @Test
    void shouldReturnLocalDateTimeNowRoundedToMinutesWhenReservationDateIsNull() {
        // Arrange
        LocalDateTime expected = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
        ReservationBuilderGetter reservationBuilderGetter = mock(ReservationBuilderGetter.class);
        CreateReservationImp createReservationImp = new CreateReservationImp(reservationRepository, reservation2ServiceResponse, reservationBuilderGetter);

        CreateReservationRequest reservationRequest = mock(CreateReservationRequest.class);
        when(reservationRequest.getReservationDate()).thenReturn(null);

        // Act
        LocalDateTime actual = createReservationImp.checkIfExplicitReservationDateIsPresent(reservationRequest);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnLocalDateTimeNowRoundedToMinutesWhenReservationDateIsNotNull() {
        // Arrange
        LocalDateTime expected = LocalDateTime.now().minusHours(2).truncatedTo(ChronoUnit.MINUTES);

        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
        ReservationBuilderGetter reservationBuilderGetter = mock(ReservationBuilderGetter.class);
        CreateReservationImp createReservationImp = new CreateReservationImp(reservationRepository, reservation2ServiceResponse, reservationBuilderGetter);

        CreateReservationRequest reservationRequest = mock(CreateReservationRequest.class);
        when(reservationRequest.getReservationDate()).thenReturn(expected.toString());

        // Act
        LocalDateTime actual = createReservationImp.checkIfExplicitReservationDateIsPresent(reservationRequest);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateReservationFromCreateReservationRequestWhenReservationDateIsNotNull() {
        // Arrange
        LocalDateTime reservationDate = LocalDateTime.now().minusHours(2).truncatedTo(ChronoUnit.MINUTES);

        Reservation mockReservation = mock(Reservation.class);

        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
        ReservationBuilderGetter reservationBuilderGetter = mock(ReservationBuilderGetter.class);

        CreateReservationRequest reservationRequest = mock(CreateReservationRequest.class);
        when(reservationRequest.getBookID()).thenReturn("1");
        when(reservationRequest.getClientID()).thenReturn("1");
        when(reservationRequest.getReservationDate()).thenReturn(reservationDate.toString());

        when(reservationBuilderGetter.getBuilder()).thenReturn(reservationBuilder);
        when(reservationBuilder.bookID("1").clientID("1").reservationDate(reservationDate).build()).thenReturn(mockReservation);

        CreateReservationImp createReservationImp = new CreateReservationImp(reservationRepository, reservation2ServiceResponse, reservationBuilderGetter);


        // Act
        Reservation result = createReservationImp.createReservation(reservationRequest);

        // Assert
        assertEquals(mockReservation, result);
    }

    @Test
    void shouldCreateReservationFromCreateReservationRequestWhenReservationDateIsNull() {
        // Arrange
        LocalDateTime reservationDate = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        Reservation mockReservation = mock(Reservation.class);

        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
        ReservationBuilderGetter reservationBuilderGetter = mock(ReservationBuilderGetter.class);

        CreateReservationRequest reservationRequest = mock(CreateReservationRequest.class);
        when(reservationRequest.getBookID()).thenReturn("1");
        when(reservationRequest.getClientID()).thenReturn("1");
        when(reservationRequest.getReservationDate()).thenReturn(null);

        when(reservationBuilderGetter.getBuilder()).thenReturn(reservationBuilder);
        when(reservationBuilder.bookID("1").clientID("1").reservationDate(reservationDate).build()).thenReturn(mockReservation);

        CreateReservationImp createReservationImp = new CreateReservationImp(reservationRepository, reservation2ServiceResponse, reservationBuilderGetter);


        // Act
        Reservation result = createReservationImp.createReservation(reservationRequest);

        // Assert
        assertEquals(mockReservation, result);
    }

    @Test
    void shouldSaveReservationFromCreateReservationRequest() {
        // Arrange
        LocalDateTime reservationDate = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        Reservation mockReservation = mock(Reservation.class);
        Reservation savedReservation = mock(Reservation.class);
        ReservationResponse reservationResponse = mock(ReservationResponse.class);

        ReservationRepository reservationRepository = mock(ReservationRepository.class);
        Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
        ReservationBuilderGetter reservationBuilderGetter = mock(ReservationBuilderGetter.class);

        CreateReservationRequest reservationRequest = mock(CreateReservationRequest.class);
        when(reservationRequest.getBookID()).thenReturn("1");
        when(reservationRequest.getClientID()).thenReturn("1");
        when(reservationRequest.getReservationDate()).thenReturn(null);

        when(reservationBuilderGetter.getBuilder()).thenReturn(reservationBuilder);
        when(reservationBuilder.bookID("1").clientID("1").reservationDate(reservationDate).build()).thenReturn(mockReservation);

        when(reservationRepository.save(mockReservation)).thenReturn(savedReservation);
        when(reservation2ServiceResponse.domain2ServiceResponse(savedReservation)).thenReturn(reservationResponse);

        CreateReservationImp createReservationImp = new CreateReservationImp(reservationRepository, reservation2ServiceResponse, reservationBuilderGetter);

        // Act
        ReservationResponse result = createReservationImp.saveReservation(reservationRequest);

        // Assert
        assertEquals(reservationResponse, result);
    }








}