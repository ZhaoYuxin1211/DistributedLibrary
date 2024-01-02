package com.ucd.bookservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnEvent {
    private long returnId;
    private String userEmail;
    private String title;
}
