package com.jobintech.elearningjobintech.services;

import com.jobintech.elearningjobintech.entities.Users;
import com.jobintech.elearningjobintech.dto.UserDTO;
import com.jobintech.elearningjobintech.mapper.UserDtoMapper;
import com.jobintech.elearningjobintech.repositories.IUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService  {

    private final  IUserRepo userRepo;
    private final UserDtoMapper userDtoMapper;


    public UserService(IUserRepo userRepo, UserDtoMapper userDtoMapper) {
        this.userRepo = userRepo;
        this.userDtoMapper = userDtoMapper;
    }

    public Users UpdateUser(Long id, Users users) {
        Users user = userRepo.findById(id).orElse(null);
        if(user!=null){
           users = user;
        }
        return userRepo.save(users);
    }
    public Users saveOrUpdate(Users users) {
        return userRepo.save(users);
    }


    public UserDTO findById(Long id) {
        return userRepo.findById(id).map(userDtoMapper).orElse(null);
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


    public List<UserDTO> findAll() {
        return userRepo.findAll().stream().map(userDtoMapper).collect(Collectors.toList());
    }
}
