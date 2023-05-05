package com.wecureit.wecureit_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToMany(mappedBy="facility")
    @JsonManagedReference(value = "facility-appointments")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Appointment> appointments;

    @OneToMany(mappedBy="facility")
    @JsonManagedReference(value = "facility-work")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<WorkSchedule> workSchedules;

    @OneToMany(mappedBy="facility")
    @JsonManagedReference(value = "facility-room")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Room> rooms;
}
