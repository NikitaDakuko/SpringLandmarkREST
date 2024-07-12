package org.nikita.SpringLandmarkREST.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Objects;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private long population;
    private List<Landmark> landmarks;
    private boolean metroAvailability;

    public Location(long id, String name, long population, List<Landmark> landmarks, boolean metroAvailability) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.landmarks = landmarks;
        this.metroAvailability = metroAvailability;
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

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public List<Landmark> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<Landmark> landmarks) {
        this.landmarks = landmarks;
    }

    public boolean isMetroAvailability() {
        return metroAvailability;
    }

    public void setMetroAvailability(boolean metroAvailability) {
        this.metroAvailability = metroAvailability;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if(! (o instanceof Location location))
            return false;
        return Objects.equals(this.id, location.id) &&
                Objects.equals(this.name, location.name) &&
                Objects.equals(this.population, location.population) &&
                Objects.equals(this.landmarks, location.landmarks) &&
                Objects.equals(this.metroAvailability, location.metroAvailability);
    }

    @Override
    public String toString(){
        return "Location{" +
                "id=" + this.id +
                ", name=" + this.name +
                ", population=" + this.population +
                ", landmarks=" + this.landmarks +
                ", metroAvailability=" + this.metroAvailability +
                "}";
    }
}
