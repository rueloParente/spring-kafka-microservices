package com.rueloparente.reservation_service.dto.service_response;

import lombok.ToString;

@ToString
public class ReservationResponse {
    private int id;
    private String bookID;
    private String clientID;
    private String reservationDate;
    private String returnDate;

    public ReservationResponse(int id, String bookID, String clientID, String reservationDate, String returnDate) {
        this.id = id;
        this.bookID = bookID;
        this.clientID = clientID;
        this.reservationDate = reservationDate;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
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
    public String getReturnDate() {
        return returnDate;
    }
}
