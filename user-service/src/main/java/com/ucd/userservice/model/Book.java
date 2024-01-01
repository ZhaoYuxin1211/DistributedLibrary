package com.ucd.userservice.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "book")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private String description;
    private int copies;
    @Column(name = "copies_available")
    private int copiesAvailable;
    private String category;
    private String img;
}
