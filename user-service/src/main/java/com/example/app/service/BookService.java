package com.example.app.service;

import com.example.app.library.Book;
import com.example.app.library.BookId;
import com.example.app.library.BookServiceGrpc;
import com.example.app.repository.BookRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 10/18/2023
 * 5:53 PM
 */
@GrpcService
public class BookService extends BookServiceGrpc.BookServiceImplBase {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void getBook(BookId request, StreamObserver<Book> responseObserver) {

        int id = request.getId();
        com.example.app.model.Book book = bookRepository.findById(id).orElse(new com.example.app.model.Book());
        Book build = Book.newBuilder().setId(book.getId()).setTitle(book.getTitle()).setAuthor(book.getAuthor()).setPrice(book.getPrice()).build();
        if (build!=null){
        responseObserver.onNext(build);
        responseObserver.onCompleted();

        } else{
        responseObserver.onError(Status.NOT_FOUND.withDescription("Book not found").asRuntimeException());
    }

//        super.getBook(request, responseObserver);
    }
}
