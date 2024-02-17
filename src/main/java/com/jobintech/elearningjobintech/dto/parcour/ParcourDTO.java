package com.jobintech.elearningjobintech.dto.parcour;

import com.jobintech.elearningjobintech.dto.Steps.StepsDTO;
import com.jobintech.elearningjobintech.entities.Users;

import java.util.List;

public record ParcourDTO(Long id , String title, String description , List<StepsDTO> stepsDTO) {

}
