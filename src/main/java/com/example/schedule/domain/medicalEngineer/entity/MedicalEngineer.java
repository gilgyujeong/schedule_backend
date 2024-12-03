package com.example.schedule.domain.medicalEngineer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalEngineer{

    @Id
    @Column(name = "medical_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int physical;

    @Column(nullable = false)
    private Boolean ndt;

    @Column(nullable = false)
    private LocalDate createAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Classification classification;
}
