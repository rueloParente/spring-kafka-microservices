package com.rueloparente.reservation_service.controller.rest;

import com.rueloparente.reservation_service.dto.service_request.CreateReservationRequest;
import com.rueloparente.reservation_service.dto.service_response.ReservationResponse;
import com.rueloparente.reservation_service.service.create_reservation.CreateReservation;
import com.rueloparente.reservation_service.service.get_reservation.GetReservation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservation")
@AllArgsConstructor
public class ReservationController {
    private final CreateReservation createReservation;

    private final GetReservation getReservation;

    @PostMapping
    public ResponseEntity<ReservationResponse> addNewReservation(@RequestBody CreateReservationRequest createReservationRequest) {
        ReservationResponse reservationResponse = createReservation.saveReservation(createReservationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationResponse);
    }

    @GetMapping
    public ResponseEntity<ReservationResponse> getReservationById(@RequestBody Integer id) {
        Optional<ReservationResponse> reservationResponse = getReservation.getReservationById(id);
        return reservationResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<ReservationResponse> getReservationByBookId(@PathVariable String bookId) {
        Optional<ReservationResponse> reservationResponse = getReservation.getReservationByBookId(bookId);
        return reservationResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ReservationResponse>> getReservationByClientId(@PathVariable String clientId) {
        List<ReservationResponse> reservationResponse = getReservation.getReservationsByClientId(clientId);
        if (reservationResponse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else return ResponseEntity.ok(reservationResponse);
    }

}
