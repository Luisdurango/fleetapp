package com.springconsole.fleetapp.repositories;

import com.springconsole.fleetapp.models.Client;
import com.springconsole.fleetapp.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
    @Query("SELECT new JobTitle (c.id, c.name) FROM Client c")
    List<Client> findNameid();

}
