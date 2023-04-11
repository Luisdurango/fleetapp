package com.springconsole.fleetapp.repositories;

import com.springconsole.fleetapp.models.Client;
import com.springconsole.fleetapp.models.Country;
import com.springconsole.fleetapp.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("SELECT new Vehicle (v.id, v.name) FROM Vehicle v")
    List<Vehicle> getOnlyId();
}
