package com.jobintech.elearningjobintech.services;

import com.jobintech.elearningjobintech.dto.doing.DoingDTO;
import com.jobintech.elearningjobintech.entities.Doing;
import com.jobintech.elearningjobintech.mapper.DoingDtoMapper;
import com.jobintech.elearningjobintech.repositories.IDoingRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoingService {

    private final IDoingRep doingRep;
    private final DoingDtoMapper doingDtoMapper;

    public DoingService(IDoingRep doingRep, DoingDtoMapper doingDtoMapper) {
        this.doingRep = doingRep;
        this.doingDtoMapper = doingDtoMapper;
    }

    public List<DoingDTO> getAllDoing(){
        return doingRep.findAll().stream().map(doingDtoMapper).collect(Collectors.toList());
    }

    public DoingDTO getDoingById(Long id){
        return doingRep.findById(id).map(doingDtoMapper).orElse(null);
    }

    public Doing saveDoing(DoingDTO doingDTO){
        Doing doing = new Doing(
                doingDTO.title(),
                doingDTO.description(),
                doingDTO.status()
        );

        return doingRep.save(doing);
    }

    public Doing updateDoing(Long id, DoingDTO doingDTO){
        Doing doing = doingRep.getReferenceById(id);
        if(doing != null){
            doing.setTitle(doingDTO.title());
            doing.setDescription(doingDTO.description());
            doing.setStatus(doingDTO.status());
            return doingRep.save(doing);
        }
        return null;
    }
}
