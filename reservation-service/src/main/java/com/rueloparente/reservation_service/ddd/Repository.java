package com.rueloparente.reservation_service.ddd;

import java.util.Optional;

public interface Repository <T extends AggregateRoot> {
    T save(T aggregateRoot);
    boolean delete(String aggregateRootID);
    Optional<T> findByID(String aggregateRootID);
}
