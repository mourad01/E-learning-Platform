package com.jobintech.elearningjobintech.dto.parcour;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jobintech.elearningjobintech.dto.Steps.StepsDTO;
import com.jobintech.elearningjobintech.dto.User.UserDTO;
import com.jobintech.elearningjobintech.entities.Users;
import lombok.Builder;

import java.util.List;

@Builder
public record ParcourDTO(Long id , String title, String description ,

                         List<StepsDTO> stepsDTO,
                         UserDTO userDTO) {

}
