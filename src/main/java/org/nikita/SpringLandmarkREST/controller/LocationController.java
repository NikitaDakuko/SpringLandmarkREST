package org.nikita.SpringLandmarkREST.controller;

import org.nikita.SpringLandmarkREST.entity.Location;
import org.nikita.SpringLandmarkREST.exception.LocationNotFoundException;
import org.nikita.SpringLandmarkREST.model.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {
    private final LocationRepository repository;

    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/locations")
    List<Location> all(){
        return repository.findAll();
    }

    @GetMapping("/locations/{id}")
    Location one(@PathVariable long id){
        return repository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
    }

    @PostMapping("/locations")
    Location newLandmark(@RequestBody Location newLocation){
        return repository.save(newLocation);
    }

    @PutMapping("/locations/{id}")
    Location updateLandmark(@RequestBody Location newLocation, @PathVariable long id){
        return repository.findById(id)
                .map(location -> {
                    location.setName(newLocation.getName());
                    location.setLandmarks(newLocation.getLandmarks());
                    location.setPopulation(newLocation.getPopulation());
                    location.setMetroAvailability(newLocation.isMetroAvailability());
                    return repository.save(location);
                })
                .orElseGet(()-> {
                    return repository.save(newLocation);
                });
    }

    @DeleteMapping("/locations/{id}")
    void deleteLandmark(@PathVariable long id){
        repository.deleteById(id);
    }
}
