package com.example.AdminInvoice.Controller;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
public class LoginMessage {

    String message;
    Boolean status;
    String token;
    HttpStatus httpStatus;
    String statusCode;

    public LoginMessage(String string, boolean b, String tok,HttpStatus httpStatus) {
        // TODO Auto-generated constructor stub
        this.message=string;
        this.status=b;
        this.token=tok;
        this.httpStatus = httpStatus;
        this.statusCode = String.valueOf(httpStatus.value());
    }


    public void LoginMesage(String message, Boolean status, String token,HttpStatus httpStatus) {
        this.message = message;
        this.status = status;
        this.token = token;
        this.httpStatus = httpStatus;

    }

}
