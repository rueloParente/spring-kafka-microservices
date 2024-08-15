package com.rueloparente.library_service.dto.controller_request;

public class UpdateBookRequest {
    public int bookID;
    public String bookName;
    public String bookDescription;
    public boolean bookAvailable;

    public UpdateBookRequest(int bookID, String bookName, String bookDescription, boolean bookAvailable) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookAvailable = bookAvailable;
    }
}
