package com.jobintech.elearningjobintech.Controller;

import com.jobintech.elearningjobintech.dto.Steps.StepsDTO;
import com.jobintech.elearningjobintech.dto.Steps.StepsRegistration;
import com.jobintech.elearningjobintech.entities.Steps;
import com.jobintech.elearningjobintech.services.StepsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<StepsDTO> findbyid(@PathVariable Long id){
       return new ResponseEntity<>(stepsService.findById(id) , HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Steps> save(@RequestBody StepsRegistration stepsRegistration){
       return new ResponseEntity<>(stepsService.save(stepsRegistration) , HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
       stepsService.deleteById(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Steps> update(@PathVariable Long id , @RequestBody StepsRegistration stepsRegistration){
       return new ResponseEntity<>(stepsService.update(id , stepsRegistration) , HttpStatus.OK);
    }


}
