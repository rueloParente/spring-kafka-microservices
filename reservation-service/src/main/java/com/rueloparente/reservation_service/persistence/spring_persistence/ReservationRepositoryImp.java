package com.rueloparente.reservation_service.persistence.spring_persistence;

import com.rueloparente.reservation_service.model.Reservation;
import com.rueloparente.reservation_service.persistence.ReservationRepository;
import com.rueloparente.reservation_service.persistence.data_model.ReservationDataModel;
import com.rueloparente.reservation_service.persistence.mapper.ReservationDataModel2Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class ReservationRepositoryImp implements ReservationRepository {
    private final ReservationDBContext dbContext;
    private final ReservationDataModel2Reservation dataModel2Reservation;

    @Override
    public Optional<Reservation> findByBookID(String bookID) {
        Optional<ReservationDataModel> reservationDataModel = dbContext.findByBookID(bookID);
        if (reservationDataModel.isPresent()) {
            return reservationDataModel.map(dataModel2Reservation::toDomain);
        } else return Optional.empty();
    }

    @Override
    public List<Reservation> findByClientID(String clientID) {
        List<ReservationDataModel> reservationDataModels = dbContext.findByClientID(clientID);
        return dataModel2Reservation.toDomain(reservationDataModels);
    }

    @Override
    public Reservation save(Reservation reservation) {
        String returnDate = reservation.getReturnDate() == null ? null : reservation.getReturnDate().toString();
        ReservationDataModel reservationDataModel = ReservationDataModel.builder()
                .bookID(reservation.getBookID())
                .clientID(reservation.getClientID())
                .reservationDate(reservation.getReservationDate().toString())
                .returnDate(returnDate)
                .build();
        ReservationDataModel savedReservation = dbContext.save(reservationDataModel);
        return dataModel2Reservation.toDomain(savedReservation);
    }

    @Override
    public boolean delete(int reservationID) {
        Optional<Reservation> reservation = findByID(reservationID);
        if (reservation.isPresent()) {
            dbContext.deleteById(reservationID);
            return true;
        } else return false;
    }

    @Override
    public Optional<Reservation> findByID(int reservationID) {
        Optional<ReservationDataModel> reservationDataModel = dbContext.findById(reservationID);
        return reservationDataModel.map(dataModel2Reservation::toDomain);
    }
}
