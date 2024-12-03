package com.example.schedule.domain.patient.dto.responseDto;

import com.example.schedule.domain.patient.entity.Patient;
import com.example.schedule.global.globalEnum.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PatientResponseDto {
    private Long patientId;
    private String name;
    private int age;
    private int physical;
    private LocalDate onset;
    private LocalDate createAt;
    private int nonManner;
    private Gender gender;

    public PatientResponseDto(Patient patient) {
        this.patientId = patient.getId();
        this.name = patient.getName();
        this.age = patient.getAge();
        this.physical = patient.getPhysical();
        this.onset = patient.getOnset();
        this.createAt = patient.getCreateAt();
        this.nonManner = patient.getNonManner();
        this.gender = patient.getGender();
    }
}
