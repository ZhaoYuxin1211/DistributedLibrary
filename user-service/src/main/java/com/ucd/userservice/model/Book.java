package com.ucd.userservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
   private long id;
    private String title;
    private String author;
    private String description;
    private int copies;
    private int copiesAvailable;
    private String category;
    private String img;
}
