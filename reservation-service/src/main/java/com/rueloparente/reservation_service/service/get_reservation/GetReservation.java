package com.rueloparente.reservation_service.service.get_reservation;

import com.rueloparente.reservation_service.dto.service_response.ReservationResponse;

import java.util.List;
import java.util.Optional;

public interface GetReservation {
    public Optional<ReservationResponse> getReservationById(int reservationId);
    public Optional<ReservationResponse> getReservationByBookId(String bookId);
    public List<ReservationResponse> getReservationsByClientId(String clientId);
}
