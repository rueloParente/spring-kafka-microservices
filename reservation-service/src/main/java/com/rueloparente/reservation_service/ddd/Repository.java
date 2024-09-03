package com.rueloparente.reservation_service.ddd;

import java.util.Optional;

public interface Repository <T extends AggregateRoot> {
    T save(T aggregateRoot);
    boolean delete(int aggregateRootID);
    Optional<T> findByID(int aggregateRootID);
}
