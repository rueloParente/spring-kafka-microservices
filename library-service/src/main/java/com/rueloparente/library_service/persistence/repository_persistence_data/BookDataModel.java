package com.rueloparente.library_service.persistence.repository_persistence_data;

import com.rueloparente.library_service.domain.book.Book;
import jakarta.persistence.*;
import org.springframework.data.annotation.Version;

@Entity
@Table(name = "Book")
public class BookDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;
    private String title;
    private String description;
    private boolean isAvailable;
    @Version
    private int version;


    public BookDataModel() {
    }
    public BookDataModel(Book book) {
        if (book.getId() != null) this.bookID = book.getId().getValue();

        this.title = book.getName().getValue();
        this.description = book.getDescription().getValue();
        this.isAvailable = book.isAvailable().getValue();
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getVersion() {
        return version;
    }

}
