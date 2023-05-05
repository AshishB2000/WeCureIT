package com.wecureit.wecureit_service.controller;

import com.wecureit.wecureit_service.model.Specialization;
import com.wecureit.wecureit_service.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/specialization")
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @GetMapping("/{id}")
    public ResponseEntity<Specialization> getSpecialization(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(specializationService.getSpecialization(id));
    }

    @GetMapping
    public ResponseEntity<List<Specialization>> getSpecializations() {
        return ResponseEntity.ok().body(specializationService.getSpecializations());
    }
}
