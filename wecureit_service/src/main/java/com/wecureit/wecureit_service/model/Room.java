package com.wecureit.wecureit_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy="room")
    @JsonManagedReference(value = "room-appointment")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Appointment> appointment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="facility_id", referencedColumnName="id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference(value = "facility-room")
    private Facility facility;
}
