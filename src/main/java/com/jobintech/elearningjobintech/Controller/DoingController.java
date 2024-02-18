package com.jobintech.elearningjobintech.Controller;

import com.jobintech.elearningjobintech.dto.doing.DoingDTO;
import com.jobintech.elearningjobintech.entities.Doing;
import com.jobintech.elearningjobintech.services.DoingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doing")
public class DoingController {

    private final DoingService doingService;

    public DoingController(DoingService doingService) {
        this.doingService = doingService;
    }

    @GetMapping("/findall")
    public List<DoingDTO> getAllDoing() {
        return doingService.getAllDoing();
    }

    @GetMapping("/findbyid")
    public DoingDTO getDoingById(Long id) {
        return doingService.getDoingById(id);
    }

    @PostMapping("/add")
    public Doing saveDoing(@RequestBody DoingDTO doingDTO) {
        return doingService.saveDoing(doingDTO);
    }

    @PutMapping("/update")
    public Doing updateDoing(@PathVariable Long id, @RequestBody DoingDTO doingDTO) {
        return doingService.updateDoing(id, doingDTO);
    }
}
