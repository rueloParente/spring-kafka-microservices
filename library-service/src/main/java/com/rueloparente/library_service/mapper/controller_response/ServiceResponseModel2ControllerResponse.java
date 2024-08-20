package com.rueloparente.library_service.mapper.controller_response;

import com.rueloparente.library_service.dto.controller_response.AddBookResponse;
import com.rueloparente.library_service.dto.controller_response.GetBookResponse;
import com.rueloparente.library_service.dto.controller_response.UpdateBookResponse;
import org.springframework.stereotype.Component;

@Component
public class ServiceResponseModel2ControllerResponse {

    public AddBookResponse toControllerAddBookResponse(String title, String description, boolean available) {
        return new AddBookResponse(title, description, available);
    }
    public GetBookResponse toControllerGetBookResponse(int bookID, String title, String description, boolean available) {
        return new GetBookResponse(bookID, title, description, available);
    }
    public UpdateBookResponse toControllerUpdateBookResponse(String title, String description, boolean available) {
        return new UpdateBookResponse(title, description, available);
    }
}
