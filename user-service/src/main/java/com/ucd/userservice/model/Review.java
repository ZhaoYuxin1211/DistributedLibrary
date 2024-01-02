package com.ucd.userservice.model;

import lombok.*;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {
    private Long id;

    private String userEmail;

    private Date date;

    private double rating;

    private Long bookId;

    private String reviewDescription;
}
