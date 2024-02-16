package com.jobintech.elearningjobintech.services;

import com.jobintech.elearningjobintech.entities.Users;
import com.jobintech.elearningjobintech.repositories.IUserRepo;
import com.jobintech.elearningjobintech.tools.ServicesCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService  {

    private final  IUserRepo userRepo;


    public UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Users UpdateUser(Long id, Users users) {
        Users user = findById(id);
        if(user!=null){
           users = user;
        }
        return userRepo.save(users);
    }
    public Users saveOrUpdate(Users users) {
        return userRepo.save(users);
    }


    public Users findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }


    public Boolean deleteById(Long id) {
        try {
            userRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Boolean deleteAll() {
        try {
            userRepo.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public List<Users> findAll() {
        return userRepo.findAll();
    }
}
