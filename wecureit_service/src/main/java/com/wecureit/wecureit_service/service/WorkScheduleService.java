package com.wecureit.wecureit_service.service;

import com.wecureit.wecureit_service.model.Doctor;
import com.wecureit.wecureit_service.model.WorkSchedule;
import com.wecureit.wecureit_service.repository.WorkScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkScheduleService {

    @Autowired
    private WorkScheduleRepository workScheduleRepository;

    @Autowired
    private DoctorService doctorService;

    public Doctor createDoctorWorkSchedule(WorkSchedule workSchedule) {
        workScheduleRepository.save(workSchedule);
        return doctorService.getDoctor(workSchedule.getDoctor().getId());
    }

    public WorkSchedule getWorkSchedule(int id) {
        return workScheduleRepository.findById(id).orElse(null);
    }

    public void deleteWorkSchedule(int id) {
        workScheduleRepository.deleteById(id);
    }

    public Doctor updateWorkSchedule(WorkSchedule workSchedule) {
        workScheduleRepository.save(workSchedule);
        return doctorService.getDoctor(workSchedule.getDoctor().getId());
    }
}
