package com.rueloparente.library_service.domain.value_object;


public class BookDescription {


    private final String value;

    protected BookDescription(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Book description cannot be empty string");
        }else this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDescription bookDescription)) return false;
        return value.equals(bookDescription.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
