package com.example.AdminInvoice.Controller;


import com.example.AdminInvoice.Entity.Login;
import com.example.AdminInvoice.Entity.Register;
import com.example.AdminInvoice.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.OpenFilesEvent;
import java.util.Optional;

@RestController
public class HomeRegister {

    @Autowired
    private RegisterService registerService;


    @PostMapping("addRegister")
    public ResponseEntity<String> response(@RequestBody Register register)throws Exception{
        registerService.addRegister(register);
        String msg="Add For New user"+" : "+register.getUserName();
        ResponseEntity<String> responseEntity=new ResponseEntity<>(msg, HttpStatus.OK);
return responseEntity;
    }

    @GetMapping("/{userId}")
    public Optional<Register> getUser(@PathVariable Integer userId)throws Exception{
        return registerService.getRegister(userId);
    }

    @GetMapping("/username/{userName}")
    public Register getUserByUsername(@PathVariable String userName)throws Exception{
        return registerService.getUserByUsername(userName);
    }


    @PostMapping("/loginInto")
    public ResponseEntity<LoginMessage> response(@RequestBody Login login)throws Exception{
        LoginMessage loginMessage=registerService.getUserByValidate(login);
        return ResponseEntity.ok(loginMessage);
    }
}
