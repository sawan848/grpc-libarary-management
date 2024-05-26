package com.example.app;

import com.example.app.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * 10/18/2023
 * 7:01 PM
 */
public class TestBookService {
    @Mock
    private BookRepository repository;
    @Test
    public void test(){
        System.out.println(repository.findAll());

    }
}
