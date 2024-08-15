package com.rueloparente.library_service.dto.controller_response;

public class GetBookResponse {
    public int bookID;
    public String title;
    public String description;
    public boolean available;

    public GetBookResponse(int bookID, String title, String description, boolean available) {
        this.bookID = bookID;
        this.title = title;
        this.description = description;
        this.available = available;
    }
}
