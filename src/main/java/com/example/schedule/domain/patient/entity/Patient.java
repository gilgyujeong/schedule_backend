package com.example.schedule.domain.patient.entity;

import com.example.schedule.global.globalEnum.Gender;
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
public class Patient {

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private LocalDate onset;

    @Column(nullable = false)
    private LocalDate createAt;

    @Column(nullable = false)
    private int physical;

    @Column
    private int nonManner;

    @Column
    private Gender gender;
}
