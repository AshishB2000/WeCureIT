package com.wecureit.wecureit_service.service;

import com.wecureit.wecureit_service.model.Specialization;
import com.wecureit.wecureit_service.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    @Autowired
    private SpecializationRepository specializationRepository;

    public Specialization getSpecialization(int id) {
        return specializationRepository.findById(id).orElse(null);
    }

    public List<Specialization> getSpecializations() {
        return specializationRepository.findAll();
    }
}
