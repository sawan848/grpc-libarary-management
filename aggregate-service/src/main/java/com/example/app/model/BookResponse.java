package com.example.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 10/18/2023
 * 6:20 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private int id;
    private String  title;
    private String author;
    private Integer price;
}
