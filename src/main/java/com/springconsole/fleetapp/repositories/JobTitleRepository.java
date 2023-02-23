package com.springconsole.fleetapp.repositories;

import com.springconsole.fleetapp.models.Client;
import com.springconsole.fleetapp.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
}
