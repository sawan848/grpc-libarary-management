package com.example.app.model;

/**
 * 10/18/2023
 * 5:49 PM
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Data
@Entity
@ToString
public class Book {
    @Id
    private int id;
    private String  title;
    private String author;
    private Integer price;

//    int32 id=1;
//    string  title=2;
//    string author=3;
//    int32 price=4;
}
