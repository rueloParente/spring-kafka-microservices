package com.rueloparente.reservation_service.persistence;

import com.rueloparente.reservation_service.ddd.Repository;
import com.rueloparente.reservation_service.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends Repository <Reservation> {
    Optional <Reservation> findByBookID(String bookID);
    List<Reservation> findByClientID(String clientID);
}
