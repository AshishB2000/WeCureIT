package com.wecureit.wecureit_service.controller;

import com.wecureit.wecureit_service.model.Patient;
import com.wecureit.wecureit_service.model.Signup;
import com.wecureit.wecureit_service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Signup signup) {
        return ResponseEntity.ok().body(patientService.createPatient(signup));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") int id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().body("Deleted id: "+id);
    }

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        System.out.println("update ******");
        return ResponseEntity.ok().body(patientService.updatePatient(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(patientService.getPatient(id));
    }
}
