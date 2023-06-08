package com.api.codetech.appointment.service;

import com.api.codetech.appointment.domain.model.entity.Status;
import com.api.codetech.technical.domain.persistence.ApplianceRepository;
import com.api.codetech.appointment.domain.model.entity.AppointmentAggregate;
import com.api.codetech.appointment.domain.persistence.AppointmentRepository;
import com.api.codetech.appointment.domain.service.AppointmentService;
import com.api.codetech.shared.exception.ResourceNotFoundException;
import com.api.codetech.technical.domain.persistence.TechnicalRepository;
import com.api.codetech.user.domain.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final static String ENTITY = "Appointment";
    private final static String ENTITY2 = "User";
    private final static String ENTITY3 = "Technical";
    private final static String ENTITY4 = "Appliance";

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TechnicalRepository technicalRepository;

    @Autowired
    private ApplianceRepository applianceRepository;

    @Override
    public List<AppointmentAggregate> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public AppointmentAggregate getById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public AppointmentAggregate create(AppointmentAggregate request, Long userId, Long technicalId, Long applianceId) {
        var user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, userId);

        var technical = technicalRepository.findById(technicalId);
        if(technical.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, technicalId);

        var appliance = applianceRepository.findById(applianceId);
        if(appliance.isEmpty())
            throw new ResourceNotFoundException(ENTITY4, applianceId);

        request.setUser(user.get());
        request.setTechnical(technical.get());
        request.setAppliance(appliance.get());
        return appointmentRepository.save(request);
    }

    @Override
    public AppointmentAggregate update(Long appointmentId, AppointmentAggregate request) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> appointmentRepository.save(
                        appointment.withProblemDescription(request.getProblemDescription())
                                .withScheduledAt(request.getScheduledAt())
                                .withAddress(request.getAddress())
                                .withStatus(request.getStatus())
                                .withReparationCost(request.getReparationCost())
                                .withPaymentStatus(request.getPaymentStatus())
                )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public AppointmentAggregate delete(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> {
                    appointmentRepository.delete(appointment);
                    return appointment;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public List<AppointmentAggregate> getByUserId(Long userId) {
        var user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, userId);

        return appointmentRepository.findByUserId(userId);
    }

    @Override
    public List<AppointmentAggregate> getByTechnicalId(Long technicalId) {
        var technical = technicalRepository.findById(technicalId);
        if(technical.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, technicalId);

        return appointmentRepository.findByTechnicalId(technicalId);
    }

    @Override
    public List<AppointmentAggregate> getByUserIdAndTechnicalId(Long userId, Long technicalId) {
        var user = userRepository.findById(userId);
        if(user.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, userId);

        var technical = technicalRepository.findById(technicalId);
        if(technical.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, technicalId);

        return appointmentRepository.findByUserIdAndTechnicalId(userId, technicalId);
    }

    @Override
    public List<AppointmentAggregate> getByScheduledDateAndTechnicalId(Date scheduledAt, Long technicalId) {
        return appointmentRepository.findByScheduledAtGreaterThanEqualAndTechnicalId(scheduledAt, technicalId);
    }

    @Override
    public List<AppointmentAggregate> getByUserIdAndStatus(Long userId, Status status) {
        return appointmentRepository.findByUserIdAndStatus(userId, status);
    }

    @Override
    public List<AppointmentAggregate> appointmentsByUserFinished(Long userId, Date date) {
        List<AppointmentAggregate> appointments = appointmentRepository.findByUserIdAndScheduledAtLessThanEqual(userId, date);
        for(AppointmentAggregate appointment : appointments){
            if(appointment.getStatus() == Status.SCHEDULED) {
                appointment.setStatus(Status.FINISHED);
                appointmentRepository.save(appointment);
            }
        }
        return appointments;
    }


}
