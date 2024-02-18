package com.jobintech.elearningjobintech.services;

import com.jobintech.elearningjobintech.dto.learning.LearningDTO;
import com.jobintech.elearningjobintech.entities.Learning;
import com.jobintech.elearningjobintech.mapper.LearningDtoMapper;
import com.jobintech.elearningjobintech.repositories.ILearningRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeraningService {

    private final ILearningRep iLearningRep;
    private  final LearningDtoMapper learningDtoMapper;

    public LeraningService(ILearningRep iLearningRep, LearningDtoMapper learningDtoMapper) {
        this.iLearningRep = iLearningRep;
        this.learningDtoMapper = learningDtoMapper;
    }

    public List<LearningDTO> getAllLearning(){
        return iLearningRep.findAll().stream().map(learningDtoMapper).collect(Collectors.toList());
    }

    public LearningDTO getLearningById(Long id){
        return iLearningRep.findById(id).map(learningDtoMapper).orElse(null);
    }

    public Learning saveLearning(LearningDTO learningDTO){
        Learning learning = new Learning(
                learningDTO.title(),
                learningDTO.description(),
                learningDTO.status()
        );

        return iLearningRep.save(learning);
    }

    public Learning updateLearning(Long id, LearningDTO learningDTO){
        Learning learning = iLearningRep.getReferenceById(id);
        if(learning != null){
            learning.setTitle(learningDTO.title());
            learning.setDescription(learningDTO.description());
            learning.setStatus(learningDTO.status());
            return iLearningRep.save(learning);
        }
        return null;
    }
}
