package com.rueloparente.library_service.dto.service_response;

public class BookResponseModel {
    public int bookID;
    public String title;
    public String bookDescription;
    public boolean bookAvailable;

    public BookResponseModel(int bookID, String title, String bookDescription, boolean bookAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.bookDescription = bookDescription;
        this.bookAvailable = bookAvailable;
    }

    @Override
    public String toString() {
        return "BookResponseModel{" +
                "bookID=" + bookID +
                ", bookTitle='" + title + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookAvailable=" + bookAvailable +
                '}';
    }
}