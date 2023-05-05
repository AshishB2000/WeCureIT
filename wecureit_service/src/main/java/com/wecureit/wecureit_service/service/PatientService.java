package com.wecureit.wecureit_service.service;

import com.wecureit.wecureit_service.model.Patient;
import com.wecureit.wecureit_service.model.Signup;
import com.wecureit.wecureit_service.model.User;
import com.wecureit.wecureit_service.repository.AppointmentRepository;
import com.wecureit.wecureit_service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private UserService userService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Patient createPatient(Signup signup) {
        User user = userService.createUser(signup, "patient");
        Patient patient = new Patient();
        insertValuesToPatient(patient, signup, user);
        return patientRepository.save(patient);
    }

    public void deletePatient(int id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient != null) {
            patientRepository.deleteById(id);
            userService.deleteUser(patient.getUser().getId());
        }
    }

    public Patient updatePatient(Patient patient) {
        User user = userService.updateUser(patient.getUser());
        patient.setUser(user);
        return patientRepository.save(patient);
    }

    public Patient getPatient(int id) {
        return patientRepository.findById(id).orElse(null);
    }

    private void insertValuesToPatient(Patient patient, Signup signup, User user) {
        patient.setFirstName(signup.getFirstName());
        patient.setLastName(signup.getLastName());
        patient.setPhoneNumber(signup.getPhoneNumber());
        patient.setAddress(signup.getAddress());
        patient.setCity(signup.getCity());
        patient.setZipCode(signup.getZipCode());
        patient.setUser(user);
    }
}
