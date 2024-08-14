package com.rueloparente.library_service.persistence.spring;

import com.rueloparente.library_service.ddd.RepositoryDIP;
import com.rueloparente.library_service.domain.book.Book;
import com.rueloparente.library_service.domain.value_object.BookID;

public interface BookRepository extends RepositoryDIP<Book, BookID> {
}
