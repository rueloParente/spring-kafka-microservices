package com.rueloparente.reservation_service.service.get_reservation;

import com.rueloparente.reservation_service.dto.service_response.ReservationResponse;
import com.rueloparente.reservation_service.model.Reservation;
import com.rueloparente.reservation_service.persistence.ReservationRepository;
import com.rueloparente.reservation_service.service.mapper.Reservation2ServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GetReservationImp implements GetReservation {
    private ReservationRepository reservationRepository;
    private Reservation2ServiceResponse reservation2ServiceResponse;

    public Optional<ReservationResponse> getReservationById(int reservationId) {
        Optional< Reservation > reservation = reservationRepository.findByID(reservationId);
        return reservation.map(value -> reservation2ServiceResponse.domain2ServiceResponse(value));
    }
    public Optional<ReservationResponse> getReservationByBookId(String bookId) {
        Optional< Reservation > reservation = reservationRepository.findByBookID(bookId);
        return reservation.map(value -> reservation2ServiceResponse.domain2ServiceResponse(value));
    }
    public List<ReservationResponse> getReservationsByClientId(String clientId) {
        List< Reservation > reservations = reservationRepository.findByClientID(clientId);
        return reservation2ServiceResponse.domain2ServiceResponse(reservations);
    }
}
