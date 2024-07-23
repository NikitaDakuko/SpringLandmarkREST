package org.nikita.SpringLandmarkREST.entity;

import jakarta.persistence.*;
import org.nikita.SpringLandmarkREST.entity.enums.LandmarkType;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Landmark implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Date creationDate;
    private String description;
    private LandmarkType type;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Landmark(long id, String name, Date creationDate, String shortDescription, LandmarkType type, Location location) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.description = shortDescription;
        this.type = type;
        this.location = location;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LandmarkType getType() {
        return type;
    }

    public void setType(LandmarkType type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if(! (o instanceof Landmark landmark))
            return false;
        return Objects.equals(this.id, landmark.id) &&
                Objects.equals(this.name, landmark.name) &&
                Objects.equals(this.creationDate, landmark.creationDate) &&
                Objects.equals(this.description, landmark.description) &&
                Objects.equals(this.type, landmark.type) &&
                Objects.equals(this.location, landmark.location);
    }

    @Override
    public String toString(){
        return "Landmark{" +
                "id=" + this.id +
                ", name=" + this.name +
                ", creationDate=" + this.creationDate +
                ", description=" + this.description +
                ", type=" + this.type +
                ", location=" + this.location +
                "}";
    }
}
