package com.rueloparente.library_service.dto.controller_request;

public class AddBookRequest {
    public String title;
    public String description;
    public boolean available;

    public AddBookRequest(String title, String description, boolean available) {
        this.title = title;
        this.description = description;
        this.available = available;
    }
}
