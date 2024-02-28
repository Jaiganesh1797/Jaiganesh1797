package com.example.AdminInvoice.Service;

import com.example.AdminInvoice.Controller.LoginMessage;
import com.example.AdminInvoice.Entity.Login;
import com.example.AdminInvoice.Entity.Register;
import com.example.AdminInvoice.JwtToken.JwtUtill;
import com.example.AdminInvoice.Repository.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private JwtUtill jwtUtill;



    @Override
    public void addRegister(Register register)throws Exception {

        Optional<Register> register1=registerDao.findByuserName(register.getUserName());
        if (register1.isPresent()){
            Register register2=register1.get();
            throw new Exception(register2.getUserName()+" : "+"In This User Already Exist!");
        }
        registerDao.save(register);
    }



    @Override
    public Optional<Register> getRegister(Integer userId)throws Exception {
        return registerDao.findById(userId);
    }
    @Override
    public Optional<Register> getUserByUsername(@PathVariable String userName)throws Exception{
        return registerDao.findByuserName(userName);
    }

    @Override
    public LoginMessage getUserByValidate(Login login)throws Exception {

        Optional<Register> findByuserName = registerDao.findByuserName(login.getUserName());
        if (findByuserName.isPresent()) {
            Register user=findByuserName.get();
            if (user.getUserPassword().equals(login.getUserPassword())) {
                String jwtToken= jwtUtill.generateToken(user.getUserName());
                LoginMessage loginMessage=new LoginMessage("Login Success", true,jwtToken,HttpStatus.OK);
                return loginMessage;
            } else {
                LoginMessage loginMessage = new LoginMessage("Please check the Password", false, "",HttpStatus.UNAUTHORIZED);
                return loginMessage;
            }
        } else {
            LoginMessage loginMessage = new LoginMessage("Please check the userName", false, "",HttpStatus.NOT_FOUND);
            return loginMessage;
        }
    }

}
