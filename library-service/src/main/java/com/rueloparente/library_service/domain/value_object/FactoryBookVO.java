package com.rueloparente.library_service.domain.value_object;

public interface FactoryBookVO {
    BookID createBookID(int id);
    BookTitle createBookTitle(String title);
    BookDescription createBookDescription(String description);
    BookAvailable createBookAvailable(boolean available);
}
