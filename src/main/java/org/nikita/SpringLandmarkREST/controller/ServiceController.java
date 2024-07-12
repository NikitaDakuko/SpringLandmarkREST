package org.nikita.SpringLandmarkREST.controller;

import org.nikita.SpringLandmarkREST.entity.Service;
import org.nikita.SpringLandmarkREST.exception.ServiceNotFoundException;
import org.nikita.SpringLandmarkREST.model.ServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {
    private final ServiceRepository repository;

    public ServiceController(ServiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/services")
    List<Service> all(){
        return repository.findAll();
    }

    @GetMapping("/services/{id}")
    Service one(@PathVariable long id){
        return repository.findById(id)
                .orElseThrow(() -> new ServiceNotFoundException(id));
    }

    @PostMapping("/services")
    Service newLandmark(@RequestBody Service newService){
        return repository.save(newService);
    }

    @PutMapping("/services/{id}")
    Service updateLandmark(@RequestBody Service newService, @PathVariable long id){
        return repository.findById(id)
                .map(service -> {
                    service.setName(newService.getName());
                    service.setDescription(newService.getDescription());
                    service.setLandmarks(newService.getLandmarks());
                    return repository.save(service);
                })
                .orElseGet(()-> {
                    return repository.save(newService);
                });
    }

    @DeleteMapping("/services/{id}")
    void deleteLandmark(@PathVariable long id){
        repository.deleteById(id);
    }
}
