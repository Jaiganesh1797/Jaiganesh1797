package com.example.AdminInvoice.Repository;

import com.example.AdminInvoice.Entity.Register;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterDao extends MongoRepository<Register,Integer> {


    Optional<Register> findByuserName(String userName);
    Optional<Register> findByuserPassword(String userPassword);


}
