package com.springconsole.fleetapp.repositories;

import com.springconsole.fleetapp.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT new Client(c.id, c.name) FROM Client c")
    List<Client> findNameid();

}
