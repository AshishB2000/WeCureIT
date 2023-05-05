package com.wecureit.wecureit_service.controller;

import com.wecureit.wecureit_service.dto.WorkScheduleDTO;
import com.wecureit.wecureit_service.model.Doctor;
import com.wecureit.wecureit_service.model.WorkSchedule;
import com.wecureit.wecureit_service.service.WorkScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/work")
public class WorkScheduleController {

    @Autowired
    private WorkScheduleService workScheduleService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Doctor> createWorkSchedule(@RequestBody WorkScheduleDTO workScheduleDTO) {
        return ResponseEntity.ok().body(workScheduleService.createDoctorWorkSchedule(
                modelMapper.map(workScheduleDTO, WorkSchedule.class)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkScheduleDTO> getWorkSchedule(@PathVariable("id") int id) {
        WorkScheduleDTO workScheduleDTO = modelMapper.map(workScheduleService.getWorkSchedule(id),
                WorkScheduleDTO.class);
        return ResponseEntity.ok().body(workScheduleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkSchedule(@PathVariable("id") int id) {
        workScheduleService.deleteWorkSchedule(id);
        return ResponseEntity.ok().body("Deleted work schedule id: "+id);
    }

    @PutMapping
    public ResponseEntity<Doctor> updateWorkSchedule(@RequestBody WorkScheduleDTO workScheduleDTO) {
        return ResponseEntity.ok().body(workScheduleService.updateWorkSchedule(
                modelMapper.map(workScheduleDTO, WorkSchedule.class)));
    }
}
