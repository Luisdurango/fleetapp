package com.springconsole.fleetapp.repositories;

import com.springconsole.fleetapp.models.Client;
import com.springconsole.fleetapp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
