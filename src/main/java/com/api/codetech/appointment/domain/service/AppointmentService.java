package com.api.codetech.appointment.domain.service;

import com.api.codetech.appointment.domain.model.entity.AppointmentAggregate;
import com.api.codetech.appointment.domain.model.entity.Status;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    List<AppointmentAggregate> getAll();
    AppointmentAggregate getById(Long appointmentId);
    AppointmentAggregate create(AppointmentAggregate appointment, Long userId, Long technicalId, Long applianceId);
    AppointmentAggregate update(Long appointmentId, AppointmentAggregate appointment);
    AppointmentAggregate delete(Long appointmentId);
    List<AppointmentAggregate> getByUserId(Long userId);
    List<AppointmentAggregate> getByTechnicalId(Long technicalId);
    List<AppointmentAggregate> getByUserIdAndTechnicalId(Long userId, Long technicalId);
    List<AppointmentAggregate> getByScheduledDateAndTechnicalId(Date scheduledAt, Long technicalId);
    List<AppointmentAggregate> getByUserIdAndStatus(Long userId, Status status);
    List<AppointmentAggregate> appointmentsByUserFinished(Long userId, Date date);
}
