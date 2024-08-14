package com.rueloparente.library_service.persistence.spring;

import com.rueloparente.library_service.domain.book.Book;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.persistence.repository_persistence_data.BookDataModel;
import com.rueloparente.library_service.persistence.mapper.BookDataModel2Book;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BookRepositoryImp implements BookRepository {

    private final BookDBContext dbContext;

    private final BookDataModel2Book mapper;

    public BookRepositoryImp(BookDBContext repository, BookDataModel2Book mapper) {
        this.dbContext = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Book> find(BookID id) {
        Optional<BookDataModel> result = dbContext.findById(id.getValue());
        if (result.isPresent()) {
            return Optional.of(mapper.toDomain(result.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Iterable<Book> findAll() {
        Iterable<BookDataModel> result = dbContext.findAll();
        return mapper.toDomain(result);
    }

    @Override
    public Book save(Book entity) {
        BookDataModel bookDataModel = new BookDataModel(entity);
        BookDataModel saved = dbContext.save(bookDataModel);
        return mapper.toDomain(saved);
    }

    @Override
    public boolean delete(BookID id) {
        if (dbContext.existsById(id.getValue())) {
            dbContext.deleteById(id.getValue());
            return true;
        } else {
            return false;
        }
    }
}
