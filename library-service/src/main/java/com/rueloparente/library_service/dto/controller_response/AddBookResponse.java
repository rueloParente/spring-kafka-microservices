package com.rueloparente.library_service.dto.controller_response;

public class AddBookResponse {
    public String title;
    public String description;
    public boolean available;

    public AddBookResponse(String title, String description, boolean available) {
        this.title = title;
        this.description = description;
        this.available = available;
    }
}
