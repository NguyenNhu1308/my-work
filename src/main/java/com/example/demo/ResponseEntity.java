package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity {
    private String requestId;
    private String at;
    private ResponseError error;
    private Object data;


    public ResponseEntity(String requestId, Date at, Integer code, String message) {
        this.requestId = requestId;
        this.at = new String();
        this.error = new ResponseError(code, message);
    }


}
