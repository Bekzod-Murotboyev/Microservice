package dev.bekzod.courierservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private Boolean success;
    private String message;
    private T data;

    public Response(String message){
        this.message=message;
        this.success=false;
    }

}
