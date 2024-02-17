package com.jobintech.elearningjobintech.mapper;

import com.jobintech.elearningjobintech.dto.UserDTO;
import com.jobintech.elearningjobintech.entities.Users;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDtoMapper implements Function<Users, UserDTO>{
    @Override
    public UserDTO apply(Users users) {
        return new UserDTO(
                users.getId(),
                users.getUsername(),
                users.getEmail(),
                users.getRole(),
                users.getParcours());
    }
}
