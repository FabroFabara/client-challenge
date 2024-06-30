package com.client.challenge.ec.bs.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse extends Throwable {

    private LocalDateTime datetime;
    private String message;
    private String details;


}
