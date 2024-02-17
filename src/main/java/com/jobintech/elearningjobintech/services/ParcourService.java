package com.jobintech.elearningjobintech.services;

import com.jobintech.elearningjobintech.dto.parcour.ParcourDTO;
import com.jobintech.elearningjobintech.entities.Parcour;
import com.jobintech.elearningjobintech.mapper.ParcourDtoMapper;
import com.jobintech.elearningjobintech.repositories.IParcourRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParcourService  {
    @Autowired
    IParcourRep parcourRep;
    private final ParcourDtoMapper parcourDtoMapper;

    public ParcourService( ParcourDtoMapper parcourDtoMapper) {
        this.parcourDtoMapper = parcourDtoMapper;


    }



    public Parcour saveOrUpdate(@RequestBody Parcour parcour) {

        return parcourRep.save(parcour);
    }


    public Parcour findById(Long id) {
        return parcourRep.findById(id).get();
    }


    public Boolean delete(Long id) {
        try {
            parcourRep.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Boolean deleteAll() {
        try {
            parcourRep.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public List<ParcourDTO> findAll() {
        return parcourRep.findAll().stream().map(parcourDtoMapper).collect(Collectors.toList());
    }
}
