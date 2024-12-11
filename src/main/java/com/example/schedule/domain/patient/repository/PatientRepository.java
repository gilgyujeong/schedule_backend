package com.example.schedule.domain.patient.repository;

import com.example.schedule.domain.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByIsOutFalse();
}
