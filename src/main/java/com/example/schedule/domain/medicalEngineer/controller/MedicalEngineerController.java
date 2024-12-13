package com.example.schedule.domain.medicalEngineer.controller;

import com.example.schedule.domain.medicalEngineer.dto.requestDto.EngineerRequestRegDto;
import com.example.schedule.global.dto.responseDto.ResponseDataDto;
import com.example.schedule.domain.medicalEngineer.service.MedicalEngineerService;
import com.example.schedule.global.dto.responseDto.ResponseStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medical")
@CrossOrigin(origins = "http://localhost:3000")
public class MedicalEngineerController {

    private final MedicalEngineerService medicalEngineerService;

    @PostMapping("/reg")
    public ResponseStatusDto engineerReg(@RequestBody EngineerRequestRegDto engineerRequestRegDto) {
        return medicalEngineerService.engineerReg(engineerRequestRegDto);
    }

    @GetMapping("/list")
    public ResponseDataDto<?> engineerList() {
        return medicalEngineerService.engineerList();
    }
}
