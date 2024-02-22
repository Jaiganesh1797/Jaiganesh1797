package com.example.AdminInvoice.Service;

import com.example.AdminInvoice.Controller.LoginMessage;
import com.example.AdminInvoice.Entity.Login;
import com.example.AdminInvoice.Entity.Register;
import com.example.AdminInvoice.Repository.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private RegisterDao registerDao;

    @Override
    public void addRegister(Register register) throws Exception {
       registerDao.save(register);
    }

    @Override
    public Optional<Register> getRegister(Integer userId) throws Exception {
        return registerDao.findById(userId);
    }

    @Override
    public Register getUserByUsername(String userName) throws Exception{
        return registerDao.findByuserName(userName);
    }




    @Override
    public LoginMessage getUserByValidate(Login login) throws Exception {

        Register findByuserName=registerDao.findByuserName(login.getUserName());
        if(findByuserName.getUserName().equals(login.getUserName())){
            if(findByuserName.getUserPassword().equals(login.getUserPassword())){
                return new LoginMessage("Login Success", true);
            }
            else {
                return new LoginMessage("Please check the Password", false);
            }
        }
        else {
            return new LoginMessage("Please check the userName", false);
        }






//        if(registerDao.findByuserName(login.getUserName()).equals(registerDao.findByuserPassword(login.getUserPassword()))){
//            return new LoginMessage("Login Success", true);
//        }
//
//        else {
//            return new LoginMessage("pls Check user and password", false);
//        }

    }


}
