package org.nikita.SpringLandmarkREST.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Objects;

@Entity
public class Service {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private List<Landmark> landmarks;

    public Service(long id, String name, String description, List<Landmark> landmarks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.landmarks = landmarks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Landmark> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<Landmark> landmarks) {
        this.landmarks = landmarks;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if(! (o instanceof Service service))
            return false;
        return Objects.equals(this.id, service.id) &&
                Objects.equals(this.name, service.name) &&
                Objects.equals(this.description, service.description) &&
                Objects.equals(this.landmarks, service.landmarks);
    }

    @Override
    public String toString(){
        return "Service{" +
                "id=" + this.id +
                ", name=" + this.name +
                ", description=" + this.description +
                ", landmarks=" + this.landmarks +
                "}";
    }
}
