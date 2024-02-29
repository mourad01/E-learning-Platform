package com.jobintech.elearningjobintech.mapper;

import com.jobintech.elearningjobintech.dto.User.UserDTO;
import com.jobintech.elearningjobintech.dto.parcour.ParcourDTO;
import com.jobintech.elearningjobintech.entities.Parcour;
import com.jobintech.elearningjobintech.entities.Users;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ParcourDtoMapper implements Function<Parcour, ParcourDTO> {



    @Override
    public ParcourDTO apply(Parcour parcour) {
        return new ParcourDTO(
                parcour.getId(),
                parcour.getTitle(),
                parcour.getDescription(),
                parcour.getSteps().stream().map(new StepsDtoMapper()).collect(Collectors.toList()),
                parcour.getUsers().stream().map(
                        elem -> {
                    return  new Users(elem.getId(), elem.getUsername(), elem.getEmail(), elem.getRole());}).collect(Collectors.toList())


        );

    }


}
