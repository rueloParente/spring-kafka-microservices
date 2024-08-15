package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.ddd.AggregateRoot;
import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;

import java.util.Objects;

public class Book implements AggregateRoot {

    private BookID id;
    private BookTitle title;
    private BookDescription description;
    private BookAvailable available;

    protected Book(BookTitle title, BookDescription description, BookAvailable available) {
        this.title = title;
        this.description = description;
        this.available = available;
    }
    protected Book(BookID id, BookTitle title, BookDescription description, BookAvailable available) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.available = available;
    }

    public BookID getID() {
        return id;
    }

    public BookID setID(BookID id) {
        this.id = id;
        return id;
    }

    public BookTitle getTitle() {
        return title;
    }

    public BookDescription getDescription() {
        return description;
    }

    public BookAvailable isAvailable() {
        return available;
    }

    public BookAvailable setAvailable(BookAvailable available) {
        this.available = available;
        return available;
    }
    public BookTitle setTitle(BookTitle name) {
        this.title = name;
        return name;
    }

    public BookDescription setDescription(BookDescription description) {
        this.description = description;
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(description, book.description) && Objects.equals(available, book.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, available);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id.getValue() +
                ", name=" + title.getValue() +
                ", description=" + description.getValue() +
                ", available=" + available.getValue() +
                '}';
    }
}
