package com.rueloparente.library_service.dto.controller_response;

public class UpdateBookResponse {
    public String title;
    public String description;
    public boolean available;

    public UpdateBookResponse(String title, String description, boolean available) {
        this.title = title;
        this.description = description;
        this.available = available;
    }
}
