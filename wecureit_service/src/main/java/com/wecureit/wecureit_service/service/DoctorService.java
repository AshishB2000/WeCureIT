package com.wecureit.wecureit_service.service;

import com.wecureit.wecureit_service.model.Doctor;
import com.wecureit.wecureit_service.model.Signup;
import com.wecureit.wecureit_service.model.User;
import com.wecureit.wecureit_service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private UserService userService;

    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor createDoctor(Signup signup) {
        User user = userService.createUser(signup, "doctor");
        Doctor doctor = new Doctor();
        insertValuesToDoctor(doctor, signup, user);
        return doctorRepository.save(doctor);
    }

    private void insertValuesToDoctor(Doctor doctor, Signup signup, User user) {
        doctor.setFirstName(signup.getFirstName());
        doctor.setLastName(signup.getLastName());
        doctor.setPhoneNumber(signup.getPhoneNumber());
        doctor.setAddress(signup.getAddress());
        doctor.setCity(signup.getCity());
        doctor.setZipCode(signup.getZipCode());
        doctor.setUser(user);
        doctor.setSpecialization(signup.getSpecialization());
    }

    public void deleteDoctor(int id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor != null) {
            doctorRepository.deleteById(id);
            userService.deleteUser(doctor.getUser().getId());
        }
    }

    public Doctor updateDoctor(Doctor doctor) {
        User user = userService.updateUser(doctor.getUser());
        doctor.setUser(user);
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctor(int id) {
        return doctorRepository.findById(id).orElse(null);
    }
}
