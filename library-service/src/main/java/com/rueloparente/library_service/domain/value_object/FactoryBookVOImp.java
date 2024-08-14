package com.rueloparente.library_service.domain.value_object;

import org.springframework.stereotype.Component;

@Component
public class FactoryBookVOImp implements FactoryBookVO {
    public BookID createBookID(int id) {
        return new BookID(id);
    }

    public BookTitle createBookTitle(String title) {
        return new BookTitle(title);
    }

    public BookDescription createBookDescription(String description) {
        return new BookDescription(description);
    }

    public BookAvailable createBookAvailable(boolean available) {
        return new BookAvailable(available);
    }
}
