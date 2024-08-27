package com.rueloparente.reservation_service.model;

import com.rueloparente.reservation_service.ddd.AggregateRoot;
import lombok.*;
import org.springframework.lang.Nullable;
import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Reservation implements AggregateRoot {
    @NonNull
    private Integer id;
    @NonNull
    private String bookID;
    @NonNull
    private LocalDateTime reservationDate;
    @Nullable
    @Setter
    private LocalDateTime returnDate;
    @NonNull
    private String clientID;
}
