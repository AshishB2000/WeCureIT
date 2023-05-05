package com.wecureit.wecureit_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wecureit.wecureit_service.model.Doctor;
import com.wecureit.wecureit_service.model.Facility;
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
public class WorkScheduleDTO {

    private int id;

    private Date workDate;

    private Time workStartTime;

    private Time workEndTime;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Doctor doctor;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Facility facility;
}
