package com.ucd.bookservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "checkout")
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "checkout_date")
    private Date checkoutDate;
    @Column(name = "book_id")
    private long bookId;
}
