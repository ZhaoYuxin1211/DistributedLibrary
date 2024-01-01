package com.ucd.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private long id;
    private String userEmail;
    private Date date;
    private double rating;
    private long bookId;
    private String reviewDescription;
}
