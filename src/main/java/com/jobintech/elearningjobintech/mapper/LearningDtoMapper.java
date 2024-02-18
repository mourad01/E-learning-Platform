package com.jobintech.elearningjobintech.mapper;

import com.jobintech.elearningjobintech.dto.learning.LearningDTO;
import com.jobintech.elearningjobintech.entities.Learning;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LearningDtoMapper implements Function<Learning, LearningDTO>{
    @Override
    public LearningDTO apply(Learning learning) {
        return new LearningDTO(
                learning.getTitle(),
                learning.getDescription(),
                learning.getStatus());
    }
}
