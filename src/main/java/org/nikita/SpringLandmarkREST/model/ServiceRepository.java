package org.nikita.SpringLandmarkREST.model;

import org.nikita.SpringLandmarkREST.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
