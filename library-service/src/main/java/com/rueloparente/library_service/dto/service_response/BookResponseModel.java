package com.rueloparente.library_service.dto.service_response;

public class BookResponseModel {
    public int bookID;
    public String bookName;
    public String bookDescription;
    public boolean bookAvailable;

    public BookResponseModel(int bookID, String bookName, String bookDescription, boolean bookAvailable) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookAvailable = bookAvailable;
    }
}