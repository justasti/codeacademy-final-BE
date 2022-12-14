package com.ca_final.backend.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity(name = "appointments")

public class Appointment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String doctorPersonalCode;
    private String patientPersonalCode;
    private String appointmentDate;
    private String description;
    private String status;
}
