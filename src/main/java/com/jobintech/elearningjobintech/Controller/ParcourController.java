package com.jobintech.elearningjobintech.Controller;

import com.jobintech.elearningjobintech.dto.parcour.ParcourDTO;
import com.jobintech.elearningjobintech.dto.parcour.ParcourRegistration;
import com.jobintech.elearningjobintech.entities.Parcour;
import com.jobintech.elearningjobintech.services.ParcourService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parcour")
public class ParcourController {
    private final ParcourService parcourService;

    public ParcourController(ParcourService parcourService) {
        this.parcourService = parcourService;
    }

    @GetMapping("/findall")
    public ResponseEntity<List<ParcourDTO>>allParcours(){
        return new ResponseEntity<>(parcourService.findAll() , HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<ParcourDTO> findParcour(@PathVariable Long id){
        ParcourDTO parcour = parcourService.findById(id);
        if(parcour!=null){
            return new ResponseEntity<>(parcour, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public String index(){
        return "Parcours";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteParcour(Long id){
        if(parcourService.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public Parcour updateParcour(@PathVariable Long id, @RequestBody ParcourRegistration parcour){


        return parcourService.Update(id,parcour);
    }

    @PostMapping("/add")
    public Parcour addParcour(@RequestBody ParcourRegistration parcour){
        return parcourService.save(parcour);
    }
}
