package com.rueloparente.library_service.domain.value_object;

public class BookName {
    private final String value;

    public BookName(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Book name cannot be empty string");
        } else this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookName bookName)) return false;
        return value.equals(bookName.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
