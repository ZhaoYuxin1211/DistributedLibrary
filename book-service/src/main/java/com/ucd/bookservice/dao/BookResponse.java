package com.ucd.bookservice.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private long id;
    private String title;
    private String author;
    private String description;
    private int copies;
    private int copiesAvailable;
    private String category;
    private String img;
}
