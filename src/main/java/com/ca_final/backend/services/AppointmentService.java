package com.ca_final.backend.services;

import com.ca_final.backend.dao.AppointmentDao;
import com.ca_final.backend.entity.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {
    private final AppointmentDao appointmentDao;

    public Iterable<Appointment> getAllAppointments() {
        return appointmentDao.findAll();
    }

    public Appointment addAppointment(Appointment appointment) {
        return appointmentDao.save(appointment);
    }
}
