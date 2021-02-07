package com.payoneer.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payoneer.cs.job.model.MachineData;

@Repository
public interface LoadDataJobRepository extends JpaRepository<MachineData, Long> {

}