package com.wecureit.wecureit_service.controller;

import com.wecureit.wecureit_service.model.Doctor;
import com.wecureit.wecureit_service.model.Patient;
import com.wecureit.wecureit_service.model.Signup;
import com.wecureit.wecureit_service.service.DoctorService;
import com.wecureit.wecureit_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Signup signup) {
        return ResponseEntity.ok().body(doctorService.createDoctor(signup));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") int id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok().body("Deleted doctor id: "+id);
    }

    @PutMapping
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok().body(doctorService.updateDoctor(doctor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(doctorService.getDoctor(id));
    }
}
