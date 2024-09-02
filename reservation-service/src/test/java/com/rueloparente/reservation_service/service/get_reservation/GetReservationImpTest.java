package com.rueloparente.reservation_service.service.get_reservation;

import com.rueloparente.reservation_service.dto.service_response.ReservationResponse;
import com.rueloparente.reservation_service.model.Reservation;
import com.rueloparente.reservation_service.persistence.ReservationRepository;
import com.rueloparente.reservation_service.service.mapper.Reservation2ServiceResponse;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetReservationImpTest {
    @Test
    void shouldReturnReservationByIdWhenReservationExists() {
        // Arrange
        int extistingReservationId = 1;
        ReservationResponse expected = mock(ReservationResponse.class);
        Reservation reservation = mock(Reservation.class);
        Optional<Reservation> optionalReservation = Optional.of(reservation);
        ReservationRepository reservationRepository = mock(ReservationRepository.class);

        when(reservationRepository.findByID(extistingReservationId)).thenReturn(optionalReservation);
        Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
        when(reservation2ServiceResponse.domain2ServiceResponse(optionalReservation.get())).thenReturn(expected);
        GetReservationImp getReservationImp = new GetReservationImp(reservationRepository, reservation2ServiceResponse);

        // Act
        Optional<ReservationResponse> actual = getReservationImp.getReservationById(extistingReservationId);

        // Assert
        assert(actual.isPresent());
        assertEquals(expected, actual.get());
        }

        @Test
    void shouldReturnEmptyWhenReservationDoesNotExist() {
            // Arrange
            int nonExistentReservationId = 1;
            Optional<Reservation> optionalReservation = Optional.empty();
            ReservationRepository reservationRepository = mock(ReservationRepository.class);

            when(reservationRepository.findByID(nonExistentReservationId)).thenReturn(optionalReservation);
            Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
            GetReservationImp getReservationImp = new GetReservationImp(reservationRepository, reservation2ServiceResponse);

            // Act
            Optional<ReservationResponse> actual = getReservationImp.getReservationById(nonExistentReservationId);

            // Assert
            assert (actual.isEmpty());
        }

        @Test
    void shouldReturnReservationByBookIdWhenReservationExists() {
            // Arrange
            String existingBookId = "1";
            ReservationResponse expected = mock(ReservationResponse.class);
            Reservation reservation = mock(Reservation.class);
            Optional<Reservation> optionalReservation = Optional.of(reservation);
            ReservationRepository reservationRepository = mock(ReservationRepository.class);

            when(reservationRepository.findByBookID(existingBookId)).thenReturn(optionalReservation);
            Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
            when(reservation2ServiceResponse.domain2ServiceResponse(optionalReservation.get())).thenReturn(expected);
            GetReservationImp getReservationImp = new GetReservationImp(reservationRepository, reservation2ServiceResponse);

            // Act
            Optional<ReservationResponse> actual = getReservationImp.getReservationByBookId(existingBookId);

            // Assert
            assert(actual.isPresent());
            assertEquals(expected, actual.get());

        }

        @Test
    void shouldReturnEmptyWhenReservationByBookIdDoesNotExist() {
            // Arrange
            String nonExistentBookId = "1";
            Optional<Reservation> optionalReservation = Optional.empty();
            ReservationRepository reservationRepository = mock(ReservationRepository.class);

            when(reservationRepository.findByBookID(nonExistentBookId)).thenReturn(optionalReservation);
            Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
            GetReservationImp getReservationImp = new GetReservationImp(reservationRepository, reservation2ServiceResponse);

            // Act
            Optional<ReservationResponse> actual = getReservationImp.getReservationByBookId(nonExistentBookId);

            // Assert
            assert (actual.isEmpty());
        }
        @Test
    void shouldReturnReservationsByClientIdWhenReservationsExist() {
            // Arrange
            String existingClientId = "1";
            ReservationResponse expected = mock(ReservationResponse.class);
            Reservation reservation = mock(Reservation.class);
            List<Reservation> reservations = List.of(reservation);
            ReservationRepository reservationRepository = mock(ReservationRepository.class);

            when(reservationRepository.findByClientID(existingClientId)).thenReturn(reservations);
            Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
            when(reservation2ServiceResponse.domain2ServiceResponse(reservations)).thenReturn(List.of(expected));
            GetReservationImp getReservationImp = new GetReservationImp(reservationRepository, reservation2ServiceResponse);

            // Act
            List<ReservationResponse> actual = getReservationImp.getReservationsByClientId(existingClientId);

            // Assert
            assert(actual.size() == 1);
            assertEquals(expected, actual.get(0));
        }
        @Test
    void shouldReturnEmptyWhenReservationsByClientIdDoNotExist() {
            // Arrange
            String nonExistentClientId = "1";
            List<Reservation> reservations = List.of();
            ReservationRepository reservationRepository = mock(ReservationRepository.class);

            when(reservationRepository.findByClientID(nonExistentClientId)).thenReturn(reservations);
            Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
            GetReservationImp getReservationImp = new GetReservationImp(reservationRepository, reservation2ServiceResponse);

            // Act
            List<ReservationResponse> actual = getReservationImp.getReservationsByClientId(nonExistentClientId);

            // Assert
            assert (actual.isEmpty());
        }
        @Test
    void shouldReturnAllOcurrencesOfReservationByClientId() {
            // Arrange
            String existingClientId = "1";
            ReservationResponse expected = mock(ReservationResponse.class);
            Reservation reservation = mock(Reservation.class);
            List<Reservation> reservations = List.of(reservation, reservation);
            ReservationRepository reservationRepository = mock(ReservationRepository.class);

            when(reservationRepository.findByClientID(existingClientId)).thenReturn(reservations);
            Reservation2ServiceResponse reservation2ServiceResponse = mock(Reservation2ServiceResponse.class);
            when(reservation2ServiceResponse.domain2ServiceResponse(reservations)).thenReturn(List.of(expected, expected));
            GetReservationImp getReservationImp = new GetReservationImp(reservationRepository, reservation2ServiceResponse);

            List<ReservationResponse> expectedList = List.of(expected, expected);

            // Act
            List<ReservationResponse> actual = getReservationImp.getReservationsByClientId(existingClientId);

            // Assert
            assertEquals(expectedList, actual);
        }

}