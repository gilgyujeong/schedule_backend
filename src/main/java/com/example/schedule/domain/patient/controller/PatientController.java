package com.example.schedule.domain.patient.controller;

import com.example.schedule.domain.patient.dto.requestDto.PatientRequestRegDto;
import com.example.schedule.domain.patient.dto.requestDto.PatientUpdateRequestDto;
import com.example.schedule.domain.patient.service.PatientService;
import com.example.schedule.global.dto.responseDto.ResponseDataDto;
import com.example.schedule.global.dto.responseDto.ResponseStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/reg")
    public ResponseStatusDto patientReg(@RequestBody PatientRequestRegDto patientRequestRegDto) {
        return patientService.patientReg(patientRequestRegDto);
    }

    @GetMapping("/list")
    public ResponseDataDto<?> patientList() {
        return patientService.patientList();
    }

    @PutMapping("/update/{patientId}")
    public ResponseStatusDto patientUpdate(@RequestBody PatientUpdateRequestDto patientUpdateRequestDto, @PathVariable Long patientId) {
        return patientService.patientUpdate(patientUpdateRequestDto, patientId);
    }

    @PatchMapping("/out/{patientId}")
    public ResponseStatusDto patientOut(@PathVariable Long patientId) {
        return patientService.patientOut(patientId);
    }
}
