package com.ucd.bookservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "return")
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "return_date")
    private Date returnDate;
}
