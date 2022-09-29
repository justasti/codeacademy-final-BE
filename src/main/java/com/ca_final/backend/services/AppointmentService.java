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

    private Appointment getAppointmentById(int id) {
        Appointment appointment = null;
        for (Appointment appointment1 : appointmentDao.findAll()) {
            if (appointment1.getId() == id) {
                appointment = appointment1;
            }
        }
        return appointment;
    }

    public void deleteAppointment(int id) {

        Appointment appointment = getAppointmentById(id);

        if (appointment != null) {
            appointmentDao.delete(appointment);
        }
    }

    public void updateAppointment(Appointment appointment) {

        appointmentDao.save(appointment);
    }
}
