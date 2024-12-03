package com.example.schedule.domain.medicalEngineer.dto.requestDto;

import com.example.schedule.domain.medicalEngineer.entity.Classification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EngineerRequestRegDto {

    private String name;
    private int physical;
    private Boolean ndt;
    private LocalDate createAt;
    private Classification classification;
}
