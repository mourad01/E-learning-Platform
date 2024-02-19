package com.jobintech.elearningjobintech.mapper;

import com.jobintech.elearningjobintech.dto.Steps.StepsDTO;
import com.jobintech.elearningjobintech.dto.parcour.ParcourDTO;
import com.jobintech.elearningjobintech.entities.Steps;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StepsDtoMapper implements Function<Steps , StepsDTO> {

    @Override
    public StepsDTO apply(Steps steps) {
        return new StepsDTO(
                steps.getTitle() ,
                steps.getDescription() ,
                steps.getStatus(),
                new ParcourDTO(
                        steps.getParcour().getId(),
                        steps.getParcour().getTitle(),
                        steps.getParcour().getDescription(),
                        null,
                        null
                ))
                ;
    }
}
