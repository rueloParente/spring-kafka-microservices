package com.rueloparente.reservation_service.service.mapper;

import com.rueloparente.reservation_service.dto.service_response.ReservationResponse;
import com.rueloparente.reservation_service.model.Reservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Reservation2ServiceResponse {
    public ReservationResponse domain2ServiceResponse(Reservation reservation) {
        int reservationId = reservation.getId();
        String bookId = reservation.getBookID();
        String clientId = reservation.getClientID();
        String reservationDate = reservation.getReservationDate().toString();
        if (reservation.getReturnDate() == null) {
            return new ReservationResponse(reservationId, bookId, clientId, reservationDate, null);
        }else {
            String returnDate = reservation.getReturnDate().toString();
            return new ReservationResponse(reservationId, bookId, clientId, reservationDate, returnDate);
        }
    }

    public List<ReservationResponse> domain2ServiceResponse(List<Reservation> reservations) {
        List<ReservationResponse> reservationResponses = new ArrayList<>();
        for (Reservation reservation : reservations) {
            reservationResponses.add(domain2ServiceResponse(reservation));
        }
        return reservationResponses;
    }

}
