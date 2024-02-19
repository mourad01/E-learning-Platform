package com.jobintech.elearningjobintech.services;

import com.jobintech.elearningjobintech.dto.Steps.StepsDTO;
import com.jobintech.elearningjobintech.dto.Steps.StepsRegistration;
import com.jobintech.elearningjobintech.entities.Steps;
import com.jobintech.elearningjobintech.exceptions.ResourceNotFound;
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
    public StepsDTO findById(Long id) {
        return stepsRep.findById(id).map(stepsDtoMapper).orElseThrow(
                ()-> new ResourceNotFound("Step %s not found".formatted(id) )
        );
    }

    public Steps save(StepsRegistration stepsRegistration) {
        Steps step = new Steps(
                stepsRegistration.title(),
                stepsRegistration.description(),
                stepsRegistration.status(),
                stepsRegistration.parcour()
        );
        return stepsRep.save(step);
    }

    public void deleteById(Long id) {
        stepsRep.deleteById(id);
    }

    public Steps update(Long id, StepsRegistration stepsRegistration) {
        Steps step = stepsRep.getReferenceById(id);
        if (step != null) {
            step.setTitle(stepsRegistration.title());
            step.setDescription(stepsRegistration.description());
            step.setStatus(stepsRegistration.status());
            step.setParcour(stepsRegistration.parcour());
            return  stepsRep.save(step);
        }else {
            return null;
        }

    }
}
