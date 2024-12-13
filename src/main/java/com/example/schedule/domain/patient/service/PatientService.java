package com.example.schedule.domain.patient.service;

import com.example.schedule.domain.patient.dto.requestDto.PatientRequestRegDto;
import com.example.schedule.domain.patient.dto.requestDto.PatientUpdateRequestDto;
import com.example.schedule.domain.patient.dto.responseDto.PatientResponseDto;
import com.example.schedule.domain.patient.entity.Patient;
import com.example.schedule.domain.patient.repository.PatientRepository;
import com.example.schedule.global.dto.responseDto.ResponseDataDto;
import com.example.schedule.global.dto.responseDto.ResponseStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .dx(patientRequestRegDto.getDx())
                .onset(patientRequestRegDto.getOnset())
                .createAt(patientRequestRegDto.getCreateAt())
                .physical(patientRequestRegDto.getPhysical())
                .nonManner(patientRequestRegDto.getNonManner())
                .gender(patientRequestRegDto.getGender())
                .isOut(false)
                .build();

        patientRepository.save(patient);

        return ResponseStatusDto.builder()
                .statusCode(OK.getStateCode())
                .message(OK.getMessage())
                .build();
    }

    public ResponseDataDto<?> patientList() {
        List<Patient> patientList = patientRepository.findByIsOutFalse();
        List<PatientResponseDto> patientResponseDtoList = patientList.stream().map(PatientResponseDto::new).toList();
        return new ResponseDataDto<>(patientResponseDtoList);
    }

    @Transactional
    public ResponseStatusDto patientUpdate(PatientUpdateRequestDto patientUpdateRequestDto, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 환자 정보 입니다."));

        patient.update(patientUpdateRequestDto);
        return ResponseStatusDto.builder()
                .statusCode(OK.getStateCode())
                .message(OK.getMessage())
                .build();
    }

    @Transactional
    public ResponseStatusDto patientOut(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 환자 정보 입니다."));

        patient.update(true);

        return ResponseStatusDto.builder()
                .statusCode(OK.getStateCode())
                .message(OK.getMessage())
                .build();
    }
}
