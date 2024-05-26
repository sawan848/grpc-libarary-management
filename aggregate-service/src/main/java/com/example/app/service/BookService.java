package com.example.app.service;

import com.example.app.library.Book;
import com.example.app.library.BookId;
import com.example.app.library.BookServiceGrpc;
import com.example.app.model.BookResponse;
import com.google.protobuf.Empty;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 10/18/2023
 * 6:15 PM
 */
@Service
public class BookService {
    @GrpcClient("book-service")
    private BookServiceGrpc.BookServiceBlockingStub serviceBlockingStub;

    public BookResponse getBook(int id){
        BookId bookId= BookId.newBuilder().setId(id).build();
        Book book = this.serviceBlockingStub.getBook(bookId);
        return new BookResponse(book.getId(),book.getTitle(), book.getAuthor(), book.getPrice());
    }

    public List<BookResponse> getAllBooks(){
        List<Book> bookList1 = serviceBlockingStub.getAllBook(Empty.newBuilder().build()).getBookList();
//        List<Book> bookList2 = allBook.getBookList();
        List<BookResponse>bookResponseList=new ArrayList<>();

        System.out.println("allBook = " + bookList1);
        for (int i = 0; i < bookList1.size(); i++) {
            Book book = bookList1.get(i);
            System.out.println("book = " +i+ book);
            bookResponseList.add(new BookResponse(book.getId(),book.getTitle(),book.getAuthor(),book.getPrice()));
        }


        return bookResponseList;

    }
}
