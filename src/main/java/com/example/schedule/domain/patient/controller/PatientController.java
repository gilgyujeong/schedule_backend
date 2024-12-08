package com.example.schedule.domain.patient.controller;

import com.example.schedule.domain.patient.dto.requestDto.PatientRequestRegDto;
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
}
