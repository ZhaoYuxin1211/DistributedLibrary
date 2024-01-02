package com.ucd.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CheckOut {
    private long id;

    private String userEmail;

    private Date checkoutDate;

    private long bookId;
}
