package com.rueloparente.reservation_service.persistence.mapper;

import com.rueloparente.reservation_service.model.Reservation;
import com.rueloparente.reservation_service.model.ReservationBuilderGetter;
import com.rueloparente.reservation_service.persistence.data_model.ReservationDataModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationDataModel2Reservation {
    @Autowired
    private final ReservationBuilderGetter reservationBuilder;

    public ReservationDataModel2Reservation(ReservationBuilderGetter reservationBuilder) {
        this.reservationBuilder = reservationBuilder;
    }

    public Reservation toDomain (ReservationDataModel reservationDataModel) {

        LocalDateTime reservationDate = LocalDateTime.parse(reservationDataModel.getReservationDate());
        LocalDateTime returnDate = reservationDataModel.getReturnDate() == null ? null : LocalDateTime.parse(reservationDataModel.getReturnDate());
        Reservation reservation = reservationBuilder.getBuilder()
                .id(reservationDataModel.getId())
                .bookID(reservationDataModel.getBookID())
                .reservationDate(reservationDate)
                .returnDate(returnDate)
                .clientID(reservationDataModel.getClientID())
                .build();
        return reservation;
    }

    public List<Reservation> toDomain (List<ReservationDataModel> reservationDataModels) {
        List<Reservation> reservations = new ArrayList<>();
        for (ReservationDataModel reservationDataModel : reservationDataModels) {
            reservations.add(toDomain(reservationDataModel));
        }
        return reservations;
    }

}
