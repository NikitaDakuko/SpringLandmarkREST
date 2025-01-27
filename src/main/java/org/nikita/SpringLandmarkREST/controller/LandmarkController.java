package org.nikita.SpringLandmarkREST.controller;

import org.nikita.SpringLandmarkREST.entity.Landmark;
import org.nikita.SpringLandmarkREST.entity.enums.LandmarkType;
import org.nikita.SpringLandmarkREST.model.LandmarkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class LandmarkController {
    private final LandmarkRepository repository;

    public LandmarkController(LandmarkRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/landmarks")
    List<Landmark> all(
            @RequestParam(required = false, name="SortBy") String sortParam,
            @RequestParam(required = false, name = "Type") LandmarkType typeParam) {

        List<Landmark> landmarks = repository.findAll();

        sortLandmarksBy(landmarks, sortParam);
        filterLandmarksByType(landmarks, typeParam);

        return landmarks;
    }

    private void sortLandmarksBy(List<Landmark> landmarks, String sortParam){
        if (sortParam.equals("name")) {
            landmarks.sort(Comparator.comparing(Landmark::getName));
        }
    }

    private void filterLandmarksByType(List<Landmark> landmarks, LandmarkType type){
        landmarks.removeIf(l -> !l.getType().equals(type));
    }

    @PostMapping("/landmarks")
    Landmark newLandmark(@RequestBody Landmark newLandmark){
        return repository.save(newLandmark);
    }

    @PutMapping("/landmarks/{id}")
    Landmark updateLandmark(@RequestBody Landmark newLandmark, @PathVariable long id){
        return repository.findById(id)
                .map(landmark -> {
                    landmark.setDescription(newLandmark.getDescription());
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
