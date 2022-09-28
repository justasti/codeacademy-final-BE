package com.ca_final.backend.dao;

import com.ca_final.backend.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentDao extends CrudRepository<Appointment, Integer> {
}
