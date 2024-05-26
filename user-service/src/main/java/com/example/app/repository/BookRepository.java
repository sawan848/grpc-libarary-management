package com.example.app.repository;

import com.example.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 10/18/2023
 * 5:52 PM
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
