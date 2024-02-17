package com.jobintech.elearningjobintech.services;

import com.jobintech.elearningjobintech.dto.Steps.StepsDTO;
import com.jobintech.elearningjobintech.mapper.StepsDtoMapper;
import com.jobintech.elearningjobintech.repositories.IStepsRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class StepsService {

    private final IStepsRep stepsRep;
    private final StepsDtoMapper stepsDtoMapper;

    public StepsService(IStepsRep stepsRep, StepsDtoMapper stepsDtoMapper) {
        this.stepsRep = stepsRep;
        this.stepsDtoMapper = stepsDtoMapper;
    }

    public List<StepsDTO> findAll() {

        return stepsRep.findAll().stream().map(stepsDtoMapper).collect(Collectors.toList());
    }
}
