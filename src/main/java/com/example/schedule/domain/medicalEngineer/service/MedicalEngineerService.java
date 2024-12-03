package com.example.schedule.domain.medicalEngineer.service;

import com.example.schedule.domain.medicalEngineer.dto.requestDto.EngineerRequestRegDto;
import com.example.schedule.domain.medicalEngineer.dto.responseDto.EngineerResponseDto;
import com.example.schedule.global.dto.responseDto.ResponseDataDto;
import com.example.schedule.domain.medicalEngineer.entity.MedicalEngineer;
import com.example.schedule.domain.medicalEngineer.repository.MedicalEngineerRepository;
import com.example.schedule.global.dto.responseDto.ResponseStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.schedule.global.globalEnum.HttpStatusEnum.OK;

@Service
@RequiredArgsConstructor
public class MedicalEngineerService {

    private final MedicalEngineerRepository medicalEngineerRepository;

    public ResponseStatusDto engineerReg(EngineerRequestRegDto engineerRequestRegDto) {
        MedicalEngineer medicalEngineer = MedicalEngineer.builder()
                .name(engineerRequestRegDto.getName())
                .physical(engineerRequestRegDto.getPhysical())
                .ndt(engineerRequestRegDto.getNdt())
                .createAt(engineerRequestRegDto.getCreateAt())
                .classification(engineerRequestRegDto.getClassification())
                .build();

        medicalEngineerRepository.save(medicalEngineer);

        return ResponseStatusDto.builder()
                .statusCode(OK.getStateCode())
                .message(OK.getMessage())
                .build();
    }

    public ResponseDataDto<?> engineerList() {
        List<MedicalEngineer> engineerList = medicalEngineerRepository.findAll();
        List<EngineerResponseDto> responseDataDtoList = engineerList.stream().map(EngineerResponseDto::new).toList();
        return new ResponseDataDto<>(responseDataDtoList);
    }
}
