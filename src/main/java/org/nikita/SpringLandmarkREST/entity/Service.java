package org.nikita.SpringLandmarkREST.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@Entity
public class Service{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "landmark",
            joinColumns = {@JoinColumn(name = "service_id")},
            inverseJoinColumns = {@JoinColumn(name = "landmark_id")})
    private List<Landmark> landmarks;
}
