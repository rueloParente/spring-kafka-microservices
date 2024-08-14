package com.rueloparente.library_service.domain.book;

import com.rueloparente.library_service.ddd.AggregateRoot;
import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;

import java.util.Objects;

public class Book implements AggregateRoot {

    private BookID id;
    private final BookTitle name;
    private final BookDescription description;
    private BookAvailable available;

    protected Book(BookTitle name, BookDescription description, BookAvailable available) {
        this.name = name;
        this.description = description;
        this.available = available;
    }
    protected Book(BookID id, BookTitle name, BookDescription description, BookAvailable available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.available = available;
    }

    public BookID getId() {
        return id;
    }

    public BookID setId(BookID id) {
        this.id = id;
        return id;
    }

    public BookTitle getName() {
        return name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(description, book.description) && Objects.equals(available, book.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, available);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id.getValue() +
                ", name=" + name.getValue() +
                ", description=" + description.getValue() +
                ", available=" + available.getValue() +
                '}';
    }
}
