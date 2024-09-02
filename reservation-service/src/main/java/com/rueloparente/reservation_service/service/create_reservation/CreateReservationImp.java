package com.rueloparente.reservation_service.service.create_reservation;

import com.rueloparente.reservation_service.dto.service_request.CreateReservationRequest;
import com.rueloparente.reservation_service.dto.service_response.ReservationResponse;
import com.rueloparente.reservation_service.model.Reservation;
import com.rueloparente.reservation_service.model.ReservationBuilderGetter;
import com.rueloparente.reservation_service.persistence.ReservationRepository;
import com.rueloparente.reservation_service.service.mapper.Reservation2ServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class CreateReservationImp implements CreateReservation {
    private ReservationRepository reservationRepository;
    private Reservation2ServiceResponse reservation2ServiceResponse;
    private ReservationBuilderGetter reservationBuilderGetter;


    public ReservationResponse saveReservation(CreateReservationRequest reservationRequest) {
        Reservation reservation = createReservation(reservationRequest);
        Reservation savedReservation = reservationRepository.save(reservation);
        ReservationResponse reservationResponse = reservation2ServiceResponse.domain2ServiceResponse(savedReservation);
        return reservationResponse;
    }
    protected Reservation createReservation(CreateReservationRequest reservationRequest) {
        LocalDateTime reservationDate = checkIfExplicitReservationDateIsPresent(reservationRequest);

        Reservation reservation = reservationBuilderGetter.getBuilder()
                .bookID(reservationRequest.getBookID())
                .clientID(reservationRequest.getClientID())
                .reservationDate(reservationDate)
                .build();
        return reservation;
    }

    protected LocalDateTime checkIfExplicitReservationDateIsPresent(CreateReservationRequest reservationRequest) {
        if (reservationRequest.getReservationDate() != null) {
            return LocalDateTime.parse(reservationRequest.getReservationDate());
        } else {
            return LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        }
    }
}
