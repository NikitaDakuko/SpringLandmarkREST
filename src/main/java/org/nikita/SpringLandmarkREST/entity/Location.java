package org.nikita.SpringLandmarkREST.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@Entity
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private long population;
    @OneToMany(mappedBy = "location")
    private List<Landmark> landmarks;
    private boolean metroAvailability;
}
