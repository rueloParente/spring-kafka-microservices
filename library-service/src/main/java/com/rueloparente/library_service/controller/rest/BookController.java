package com.rueloparente.library_service.controller.rest;


import com.rueloparente.library_service.domain.value_object.*;
import com.rueloparente.library_service.dto.controller_request.AddBookRequest;
import com.rueloparente.library_service.dto.controller_request.UpdateBookRequest;
import com.rueloparente.library_service.dto.controller_response.AddBookResponse;
import com.rueloparente.library_service.dto.controller_response.GetBookResponse;
import com.rueloparente.library_service.dto.controller_response.UpdateBookResponse;
import com.rueloparente.library_service.dto.service_response.BookResponseModel;
import com.rueloparente.library_service.mapper.controller_response.ServiceResponseModel2ControllerResponse;
import com.rueloparente.library_service.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/library")
public class BookController {
    private final BookService bookService;
    private final ServiceResponseModel2ControllerResponse serviceResponseModel2ControllerResponse;
    private final FactoryBookVO factoryBookVO;

    public BookController(BookService bookService, ServiceResponseModel2ControllerResponse serviceResponseModel2ControllerResponse, FactoryBookVO factoryBookVO) {
        this.bookService = bookService;
        this.serviceResponseModel2ControllerResponse = serviceResponseModel2ControllerResponse;
        this.factoryBookVO = factoryBookVO;
    }

    // Add new book
    @PostMapping
    public ResponseEntity<AddBookResponse> addNewBook(@RequestBody AddBookRequest addBookRequest) {
        BookTitle title = factoryBookVO.createBookTitle(addBookRequest.title);
        BookDescription description = factoryBookVO.createBookDescription(addBookRequest.description);
        BookAvailable available = factoryBookVO.createBookAvailable(addBookRequest.available);

        BookResponseModel bookResponseModel = bookService.addNewBook(title, description, available);
        AddBookResponse addBookResponse = serviceResponseModel2ControllerResponse.toControllerAddBookResponse(bookResponseModel.bookName,
                bookResponseModel.bookDescription, bookResponseModel.bookAvailable);
        return ResponseEntity.status(HttpStatus.CREATED).body(addBookResponse);
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<GetBookResponse>> getAllBooks() {
        List<BookResponseModel> bookResponseModels = bookService.getAllBooks();
        List<GetBookResponse> getBookResponses = new ArrayList<>();

        for (BookResponseModel bookResponseModel : bookResponseModels) {
            getBookResponses.add(serviceResponseModel2ControllerResponse.toControllerGetBookResponse(bookResponseModel.bookID,
                    bookResponseModel.bookName, bookResponseModel.bookDescription, bookResponseModel.bookAvailable));
        }
        return ResponseEntity.ok(getBookResponses);
    }

    // Update book
    @PutMapping
    public ResponseEntity<UpdateBookResponse> updateBook(@RequestBody UpdateBookRequest updateBookRequest) {
        BookID bookID = factoryBookVO.createBookID(updateBookRequest.bookID);
        BookTitle title = factoryBookVO.createBookTitle(updateBookRequest.bookName);
        BookDescription description = factoryBookVO.createBookDescription(updateBookRequest.bookDescription);
        BookAvailable available = factoryBookVO.createBookAvailable(updateBookRequest.bookAvailable);

        BookResponseModel bookResponseModel = bookService.updateBook(bookID, title, description, available);
        UpdateBookResponse updateBookResponse = serviceResponseModel2ControllerResponse.toControllerUpdateBookResponse(bookResponseModel.bookName,
                bookResponseModel.bookDescription, bookResponseModel.bookAvailable);

        return ResponseEntity.ok(updateBookResponse);
    }

    // Delete book
    @DeleteMapping("/{bookID}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookID) {
        BookID bookIDVO = factoryBookVO.createBookID(bookID);
        boolean result = bookService.deleteBook(bookIDVO);
        if (result) {
            return ResponseEntity.ok("Book deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Book not found");
        }
    }

}
