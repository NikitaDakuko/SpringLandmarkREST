package org.nikita.SpringLandmarkREST.controller;

import org.nikita.SpringLandmarkREST.entity.Location;
import org.nikita.SpringLandmarkREST.model.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LocationController {
    private final LocationRepository repository;

    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/locations")
    Location newLocation(@RequestBody Location newLocation){
        return repository.save(newLocation);
    }

    @PutMapping("/locations/{id}")
    Optional<Location> updateLandmark(@RequestBody Location newLocation, @PathVariable long id){
        return repository.findById(id)
                .map(location -> {
                    location.setPopulation(newLocation.getPopulation());
                    location.setMetroAvailability(newLocation.isMetroAvailability());
                    return repository.save(location);
                });
    }

    @DeleteMapping("/locations/{id}")
    void deleteLandmark(@PathVariable long id){
        repository.deleteById(id);
    }
}
