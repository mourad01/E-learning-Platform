package com.jobintech.elearningjobintech.Controller;

import com.jobintech.elearningjobintech.dto.Steps.StepsDTO;
import com.jobintech.elearningjobintech.entities.Steps;
import com.jobintech.elearningjobintech.services.StepsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/steps")
public class StepsController {
   private final StepsService stepsService;


   public StepsController(StepsService stepsService) {
      this.stepsService = stepsService;
   }

   @GetMapping("/findall")
    public ResponseEntity<List<StepsDTO>> allSteps(){
         return new ResponseEntity<>(stepsService.findAll() , HttpStatus.OK);
    }


}
