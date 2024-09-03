package com.rueloparente.reservation_service.dto.service_request;
import lombok.ToString;

@ToString
public class CreateReservationRequest {
    private String bookID;
    private String clientID;
    private String reservationDate;

    public CreateReservationRequest(String bookID, String clientID, String reservationDate) {
        this.bookID = bookID;
        this.clientID = clientID;
        this.reservationDate = reservationDate;
    }

    public String getBookID() {
        return bookID;
    }

    public String getClientID() {
        return clientID;
    }

    public String getReservationDate() {
        return reservationDate;
    }
}
