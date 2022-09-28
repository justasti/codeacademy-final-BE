package com.ca_final.backend.controller;

import com.ca_final.backend.entity.Appointment;
import com.ca_final.backend.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/appointments")
@AllArgsConstructor
@RestController
public class AppointmentController {

    private final AppointmentService appointmentsService;


    @GetMapping
    public Iterable<Appointment> getAllAppointments() {
        return appointmentsService.getAllAppointments();
    }

    @PostMapping("/new")
    public ResponseEntity<Appointment> createNewAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentsService.addAppointment(appointment), HttpStatus.CREATED);
    }
}