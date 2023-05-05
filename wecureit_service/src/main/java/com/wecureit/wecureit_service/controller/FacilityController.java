package com.wecureit.wecureit_service.controller;

import com.wecureit.wecureit_service.model.Facility;
import com.wecureit.wecureit_service.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/facility")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @PostMapping
    public ResponseEntity<Facility> createFacility(@RequestBody Facility facility) {
        return ResponseEntity.ok().body(facilityService.createFacility(facility));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facility> getFacility(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(facilityService.getFacility(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFacility(@PathVariable("id") int id) {
        facilityService.deleteFacility(id);
        return ResponseEntity.ok().body("Deleted facility id: "+id);
    }

    @PutMapping
    public ResponseEntity<Facility> updateFacility(@RequestBody Facility facility) {
        return ResponseEntity.ok().body(facilityService.updateFacility(facility));
    }
}
