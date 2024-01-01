package com.ucd.messageservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutEvent {
    private long checkoutId;
    private String userEmail;
    private String title;
}
