package com.example.schedule.domain.patient.service;

import com.example.schedule.domain.patient.dto.requestDto.PatientRequestRegDto;
import com.example.schedule.domain.patient.dto.responseDto.PatientResponseDto;
import com.example.schedule.domain.patient.entity.Patient;
import com.example.schedule.domain.patient.repository.PatientRepository;
import com.example.schedule.global.dto.responseDto.ResponseDataDto;
import com.example.schedule.global.dto.responseDto.ResponseStatusDto;
import com.example.schedule.global.globalEnum.HttpStatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.schedule.global.globalEnum.HttpStatusEnum.*;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public ResponseStatusDto patientReg(PatientRequestRegDto patientRequestRegDto) {
        Patient patient = Patient.builder()
                .name(patientRequestRegDto.getName())
                .age(patientRequestRegDto.getAge())
                .onset(patientRequestRegDto.getOnset())
                .createAt(patientRequestRegDto.getCreateAt())
                .physical(patientRequestRegDto.getPhysical())
                .nonManner(patientRequestRegDto.getNonManner())
                .gender(patientRequestRegDto.getGender())
                .build();

        patientRepository.save(patient);

        return ResponseStatusDto.builder()
                .statusCode(OK.getStateCode())
                .message(OK.getMessage())
                .build();
    }

    public ResponseDataDto<?> patientList() {
        List<Patient> patientList = patientRepository.findAll();
        List<PatientResponseDto> patientResponseDtoList = patientList.stream().map(PatientResponseDto::new).toList();
        return new ResponseDataDto<>(patientResponseDtoList);
    }
}
