package com.jobintech.elearningjobintech.services;

import com.jobintech.elearningjobintech.entities.Parcour;
import com.jobintech.elearningjobintech.repositories.IParcourRep;
import com.jobintech.elearningjobintech.tools.ServicesCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class ParcourService implements ServicesCRUD<Parcour> {
    @Autowired
    IParcourRep parcourRep;


    @Override
    public Parcour saveOrUpdate(@RequestBody Parcour parcour) {

        return parcourRep.save(parcour);
    }

    @Override
    public Parcour findById(Long id) {
        return parcourRep.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        try {
            parcourRep.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean deleteAll() {
        try {
            parcourRep.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Parcour> findAll() {
        return parcourRep.findAll();
    }
}
