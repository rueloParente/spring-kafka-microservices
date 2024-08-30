package com.rueloparente.reservation_service.model;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ReservationBuilderGetterImp implements ReservationBuilderGetter {

    public Reservation.ReservationBuilder getBuilder() {
        return new Reservation.ReservationBuilder();
    }
}
