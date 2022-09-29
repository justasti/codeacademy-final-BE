package com.ca_final.backend.controller;

import com.ca_final.backend.entity.Appointment;
import com.ca_final.backend.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/appointments")
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

    private final AppointmentService appointmentsService;


    @GetMapping
    public Iterable<Appointment> getAllAppointments() {
        return appointmentsService.getAllAppointments();
    }

    @PostMapping("/new")
    public Appointment createNewAppointment(@RequestBody Appointment appointment) {
        return appointmentsService.addAppointment(appointment);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteAppointment(@PathVariable int id) {
        appointmentsService.deleteAppointment(id);
    }

    @PutMapping("/{id}/update")
    public void updateAppointment(@RequestBody Appointment appointment) {
        appointmentsService.updateAppointment(appointment);
    }
}