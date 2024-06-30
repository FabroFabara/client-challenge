package com.client.challenge.ec.ws.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse extends Exception {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime datetime;
    private String message;
    private String details;


}
