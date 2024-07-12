package org.nikita.SpringLandmarkREST.controller;

import org.nikita.SpringLandmarkREST.entity.Landmark;
import org.nikita.SpringLandmarkREST.exception.LandmarkNotFoundException;
import org.nikita.SpringLandmarkREST.model.LandmarkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LandmarkController {
    private final LandmarkRepository repository;

    public LandmarkController(LandmarkRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/landmarks")
    List<Landmark> all(){
        return repository.findAll();
    }

    @GetMapping("/landmarks/{id}")
    Landmark one(@PathVariable long id){
        return repository.findById(id)
                .orElseThrow(() -> new LandmarkNotFoundException(id));
    }

    @PostMapping("/landmarks")
    Landmark newLandmark(@RequestBody Landmark newLandmark){
        return repository.save(newLandmark);
    }

    @PutMapping("/landmarks/{id}")
    Landmark updateLandmark(@RequestBody Landmark newLandmark, @PathVariable long id){
        return repository.findById(id)
                .map(landmark -> {
                    landmark.setName(newLandmark.getName());
                    landmark.setDescription(newLandmark.getDescription());
                    landmark.setType(newLandmark.getType());
                    landmark.setLocation(newLandmark.getLocation());
                    landmark.setCreationDate(newLandmark.getCreationDate());
                    return repository.save(landmark);
                })
                .orElseGet(()-> {
                    return repository.save(newLandmark);
                });
    }

    @DeleteMapping("/landmarks/{id}")
    void deleteLandmark(@PathVariable long id){
        repository.deleteById(id);
    }
}
