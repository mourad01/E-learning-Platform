package com.jobintech.elearningjobintech.mapper;

import com.jobintech.elearningjobintech.dto.parcour.ParcourDTO;
import com.jobintech.elearningjobintech.entities.Parcour;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ParcourDtoMapper implements Function<Parcour, ParcourDTO> {



    @Override
    public ParcourDTO apply(Parcour parcour) {
        return new ParcourDTO(
                parcour.getId(),
                parcour.getTitle(),
                parcour.getDescription(),
                parcour.getSteps().stream().map(new StepsDtoMapper()).toList()
               );
    }


}
