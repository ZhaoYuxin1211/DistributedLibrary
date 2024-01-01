package com.ucd.bookservice.dao;

import lombok.*;

import javax.persistence.Entity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnRequest {
    private String userEmail;
    private long bookId;
}
