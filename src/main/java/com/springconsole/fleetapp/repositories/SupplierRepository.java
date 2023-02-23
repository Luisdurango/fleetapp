package com.springconsole.fleetapp.repositories;

import com.springconsole.fleetapp.models.Client;
import com.springconsole.fleetapp.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
