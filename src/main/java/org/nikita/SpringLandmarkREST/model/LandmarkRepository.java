package org.nikita.SpringLandmarkREST.model;

import org.nikita.SpringLandmarkREST.entity.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandmarkRepository extends JpaRepository<Landmark, Long> {
}
