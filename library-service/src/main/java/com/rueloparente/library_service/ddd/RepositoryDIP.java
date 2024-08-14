package com.rueloparente.library_service.ddd;

import java.util.Optional;

public interface RepositoryDIP<T extends AggregateRoot, ID extends DomainID> {
    Optional<T> find(ID id);
    Iterable<T> findAll();
    T save(T entity);
    boolean delete(ID id);

}
