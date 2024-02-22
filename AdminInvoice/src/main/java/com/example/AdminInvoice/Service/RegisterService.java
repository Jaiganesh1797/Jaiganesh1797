package com.example.AdminInvoice.Service;

import com.example.AdminInvoice.Controller.LoginMessage;
import com.example.AdminInvoice.Entity.Login;
import com.example.AdminInvoice.Entity.Register;

import java.util.Optional;

public interface RegisterService {

    public void addRegister(Register register)throws Exception;
    public Optional<Register> getRegister(Integer userId)throws Exception;

    public Register getUserByUsername(String userName)throws Exception;

    public LoginMessage getUserByValidate(Login login)throws Exception;

}
