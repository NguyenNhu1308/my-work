package com.example.demo.response;

import com.example.demo.date_time.DateTimeUtils;
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


    public ResponseEntity(String requestId, Date at, ResponseError error, String message) {
        this.requestId = requestId;
        this.at = DateTimeUtils.dd_MM_yyyy_HH_mm_ss(at);
        this.error = error;
        this.data = message;
    }


}
