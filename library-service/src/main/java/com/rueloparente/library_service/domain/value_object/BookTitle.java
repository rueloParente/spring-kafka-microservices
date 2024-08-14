package com.rueloparente.library_service.domain.value_object;

public class BookTitle {
    private final String value;

    protected BookTitle(String value) {
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
        if (!(o instanceof BookTitle bookTitle)) return false;
        return value.equals(bookTitle.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
