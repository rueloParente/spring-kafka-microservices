package com.rueloparente.reservation_service.persistence.spring_persistence;

import com.rueloparente.reservation_service.persistence.data_model.ReservationDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ReservationDBContext extends JpaRepository<ReservationDataModel, Integer> {
    Optional<ReservationDataModel> findByBookID(String bookID);
    List<ReservationDataModel> findByClientID(String clientID);
}
