package com.wecureit.wecureit_service.controller;

import com.wecureit.wecureit_service.dto.AppointmentDTO;
import com.wecureit.wecureit_service.model.Appointment;
import com.wecureit.wecureit_service.model.Patient;
import com.wecureit.wecureit_service.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/patient")
    public ResponseEntity<Patient> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok().body(appointmentService.createPatientAppointment(
                modelMapper.map(appointmentDTO, Appointment.class)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable("id") int id) {
        AppointmentDTO appointmentDTO = modelMapper.map(appointmentService.getAppointment(id),
                AppointmentDTO.class);
        return ResponseEntity.ok().body(appointmentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") int id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok().body("Deleted id: "+id);
    }

    @PutMapping("/patient")
    public ResponseEntity<Patient> updatePatientAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok().body(appointmentService.updateAppointment(
                modelMapper.map(appointmentDTO, Appointment.class)));
    }
}
