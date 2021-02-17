package org.example.newav.repository.entity;

import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class BaseResponse<T> {
    private final ResponseEntity<T> responseEntity;

    public BaseResponse(T t) {
        if (t == null) {
            this.responseEntity = new ResponseEntity<>(null, null, HttpStatus.BAD_REQUEST);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            this.responseEntity = new ResponseEntity<>(t, headers, HttpStatus.OK);
        }
    }

    public BaseResponse() {
        this.responseEntity = new ResponseEntity<>(null, null, HttpStatus.BAD_REQUEST);
    }
}