package com.rueloparente.library_service.domain.value_object;

import com.rueloparente.library_service.ddd.ValueObject;

import java.util.Objects;

public class BookAvailable implements ValueObject {
    private final boolean value;

    protected BookAvailable(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookAvailable that)) return false;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
