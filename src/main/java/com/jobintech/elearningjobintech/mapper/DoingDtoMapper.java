package com.jobintech.elearningjobintech.mapper;

import com.jobintech.elearningjobintech.dto.doing.DoingDTO;
import com.jobintech.elearningjobintech.entities.Doing;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DoingDtoMapper implements Function<Doing, DoingDTO>{
    @Override
    public DoingDTO apply(Doing doing) {
        return new DoingDTO(
                doing.getTitle(),
                doing.getDescription(),
                doing.getStatus());
    }
}
