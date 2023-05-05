package com.wecureit.wecureit_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wecureit.wecureit_service.model.Doctor;
import com.wecureit.wecureit_service.model.Facility;
import com.wecureit.wecureit_service.model.Patient;
import com.wecureit.wecureit_service.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private int id;
    private Date appointmentDate;
    private Time appointmentTime;
    private int appointmentDuration;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patient patient;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Facility facility;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Room room;
}
