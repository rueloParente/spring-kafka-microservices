package com.rueloparente.reservation_service.service.create_reservation;

import com.rueloparente.reservation_service.dto.service_request.CreateReservationRequest;
import com.rueloparente.reservation_service.dto.service_response.ReservationResponse;

public interface CreateReservation {
    ReservationResponse saveReservation(CreateReservationRequest reservationRequest);
}
