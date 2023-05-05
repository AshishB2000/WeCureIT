package com.wecureit.wecureit_service.service;

import com.wecureit.wecureit_service.model.Appointment;
import com.wecureit.wecureit_service.model.Patient;
import com.wecureit.wecureit_service.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientService patientService;

    public Patient createPatientAppointment(Appointment appointment) {
        System.out.println("********** : "+appointment.getFacility().getId());
        appointmentRepository.save(appointment);
        return patientService.getPatient(appointment.getPatient().getId());
    }

    public Appointment getAppointment(int id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public void deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
    }

    public Patient updateAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return patientService.getPatient(appointment.getPatient().getId());
    }
}
