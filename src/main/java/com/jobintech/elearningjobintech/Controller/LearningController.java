package com.jobintech.elearningjobintech.Controller;

import com.jobintech.elearningjobintech.dto.learning.LearningDTO;
import com.jobintech.elearningjobintech.entities.Learning;
import com.jobintech.elearningjobintech.services.LeraningService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/learning")
public class LearningController {
    private final LeraningService learningService;

    public LearningController(LeraningService learningService) {
        this.learningService = learningService;
    }

    @GetMapping("/findall")
    public List<LearningDTO> getAllLearning(){
        return learningService.getAllLearning();
    }

    @GetMapping("/findbyid")
    public LearningDTO getLearningById(Long id){
        return learningService.getLearningById(id);
    }

    @PostMapping ("/add")
    public Learning saveLearning(@RequestBody LearningDTO learningDTO){
        return learningService.saveLearning(learningDTO);
    }

    @PutMapping ("/update")
    public Learning updateLearning(@PathVariable Long id,@RequestBody LearningDTO learningDTO){
        return learningService.updateLearning(id, learningDTO);
    }



}
