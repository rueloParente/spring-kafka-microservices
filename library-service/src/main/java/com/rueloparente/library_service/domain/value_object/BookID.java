package com.rueloparente.library_service.domain.value_object;

import com.rueloparente.library_service.ddd.DomainID;
import java.util.Objects;

public class BookID implements DomainID {
    private final int value;

    protected BookID(int value) {
       this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookID bookID)) return false;
        return Objects.equals(value, bookID.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
