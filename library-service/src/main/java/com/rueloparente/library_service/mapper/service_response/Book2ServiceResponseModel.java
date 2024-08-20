package com.rueloparente.library_service.mapper.service_response;

import com.rueloparente.library_service.domain.value_object.BookAvailable;
import com.rueloparente.library_service.domain.value_object.BookDescription;
import com.rueloparente.library_service.domain.value_object.BookID;
import com.rueloparente.library_service.domain.value_object.BookTitle;
import com.rueloparente.library_service.dto.service_response.BookResponseModel;
import org.springframework.stereotype.Component;

@Component
public class Book2ServiceResponseModel {

    public BookResponseModel toServiceResponseModel(BookID bookID, BookTitle title, BookDescription description, BookAvailable available) {
        return new BookResponseModel(bookID.getValue(), title.getValue(), description.getValue(), available.getValue());
    }
}
