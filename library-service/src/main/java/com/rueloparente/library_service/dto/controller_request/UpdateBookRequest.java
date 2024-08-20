package com.rueloparente.library_service.dto.controller_request;

public class UpdateBookRequest {
    public int bookID;
    public String title;
    public String bookDescription;
    public boolean bookAvailable;

    public UpdateBookRequest(int bookID, String title, String bookDescription, boolean bookAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.bookDescription = bookDescription;
        this.bookAvailable = bookAvailable;
    }
}
