package com.jobintech.elearningjobintech.mapper;

import com.jobintech.elearningjobintech.dto.User.UserRegisteration;
import com.jobintech.elearningjobintech.entities.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserRegistrartionMapper implements Function<UserRegisteration, Users> {
    @Override
    public Users apply(UserRegisteration userRegisteration) {

        return  new Users(
                userRegisteration.username(),
                userRegisteration.Password(),
                userRegisteration.email(),
                userRegisteration.role(),
                userRegisteration.parcours()
        );
    }
}
