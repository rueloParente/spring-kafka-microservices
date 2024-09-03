package com.rueloparente.reservation_service.persistence.data_model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter

@Entity
public class ReservationDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String bookID;
    private String reservationDate;
    private String returnDate;
    private String clientID;
}
