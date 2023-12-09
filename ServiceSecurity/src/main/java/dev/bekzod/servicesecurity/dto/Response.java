package dev.bekzod.servicesecurity.dto;

import lombok.Data;

@Data
public class Response<T> {

    private boolean success;
    private String message;
    private T data;

    public Response(String message) {
        this.message = message;
        this.success = false;
    }

    public Response(T data) {
        this.data = data;
        this.success = data != null;
    }

}
