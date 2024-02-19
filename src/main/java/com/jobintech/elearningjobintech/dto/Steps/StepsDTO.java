package com.jobintech.elearningjobintech.dto.Steps;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jobintech.elearningjobintech.dto.parcour.ParcourDTO;
import com.jobintech.elearningjobintech.entities.Parcour;

import java.util.List;

public record StepsDTO(String title , String description, String status,

                       ParcourDTO parcour) {
}
