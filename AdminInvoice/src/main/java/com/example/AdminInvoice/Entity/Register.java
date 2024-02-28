package com.example.AdminInvoice.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "registerDto")
public class Register {

    @Id
    private int userId;
    private String userName;
    private String userPassword;
    private String  userMail;
}
