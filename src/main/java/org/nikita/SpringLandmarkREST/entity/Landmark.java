package org.nikita.SpringLandmarkREST.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.nikita.SpringLandmarkREST.entity.enums.LandmarkType;

import java.util.Date;

@ToString
@Data
@Entity
public class Landmark{
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
}
