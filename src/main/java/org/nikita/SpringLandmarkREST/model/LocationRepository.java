package org.nikita.SpringLandmarkREST.model;

import org.nikita.SpringLandmarkREST.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
