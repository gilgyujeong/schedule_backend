package com.example.schedule.domain.medicalEngineer.dto.responseDto;

import com.example.schedule.domain.medicalEngineer.entity.Classification;
import com.example.schedule.domain.medicalEngineer.entity.MedicalEngineer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class EngineerResponseDto {
    private Long engineerId;
    private String name;
    private int physical;
    private Boolean ndt;
    private LocalDate createAt;
    private Classification classification;

    public EngineerResponseDto(MedicalEngineer medicalEngineer) {
        this.engineerId = medicalEngineer.getId();
        this.name = medicalEngineer.getName();
        this.physical = medicalEngineer.getPhysical();
        this.ndt = medicalEngineer.getNdt();
        this.createAt = medicalEngineer.getCreateAt();
        this.classification = medicalEngineer.getClassification();
    }
}
