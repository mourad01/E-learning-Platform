package com.jobintech.elearningjobintech.services;

import com.jobintech.elearningjobintech.dto.User.UserRegisteration;
import com.jobintech.elearningjobintech.dto.User.UserUpdateReq;
import com.jobintech.elearningjobintech.entities.Users;
import com.jobintech.elearningjobintech.dto.User.UserDTO;
import com.jobintech.elearningjobintech.mapper.UserDtoMapper;
import com.jobintech.elearningjobintech.mapper.UserRegistrartionMapper;
import com.jobintech.elearningjobintech.repositories.IUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final IUserRepo userRepo;
    private final UserDtoMapper userDtoMapper;
    private final UserRegistrartionMapper userRegistrartionMapper;


    public UserService(IUserRepo userRepo, UserDtoMapper userDtoMapper, ParcourService parcourService, UserRegistrartionMapper userRegistrartionMapper) {
        this.userRepo = userRepo;
        this.userDtoMapper = userDtoMapper;

        this.userRegistrartionMapper = userRegistrartionMapper;
    }

    public Users UpdateUser(Long id, UserUpdateReq users) {
        Users user = userRepo.getReferenceById(id);
        if (user != null) {
            user.setUsername(users.username());
            user.setRole(users.role());
        }
        return userRepo.save(user);
    }

    public Users saveOrUpdate(UserRegisteration userRegisteration) {

        return userRepo.save(userRegistrartionMapper.apply(userRegisteration));
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
