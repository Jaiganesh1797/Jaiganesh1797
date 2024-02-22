package com.example.AdminInvoice.Controller;

import lombok.Data;

@Data
public class LoginMessage {

    String message;
    Boolean status;

    public LoginMessage(String string, boolean b) {
        // TODO Auto-generated constructor stub
        this.message=string;
        this.status=b;
    }


    public void LoginMesage(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

}
