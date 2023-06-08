package com.api.codetech.technical.service;

import com.api.codetech.appointment.domain.model.entity.AppointmentAggregate;
import com.api.codetech.appointment.domain.persistence.AppointmentRepository;
import com.api.codetech.shared.domain.valueObjects.FullName;
import com.api.codetech.shared.exception.ResourceNotFoundException;
import com.api.codetech.technical.domain.model.entity.ApplianceTechnical;
import com.api.codetech.technical.domain.model.entity.Technical;
import com.api.codetech.technical.domain.model.entity.TechnicalShift;
import com.api.codetech.technical.domain.persistence.ApplianceTechnicalRepository;
import com.api.codetech.technical.domain.persistence.TechnicalRepository;
import com.api.codetech.technical.domain.persistence.TechnicalShiftRepository;
import com.api.codetech.technical.domain.service.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TechnicalServiceImpl implements TechnicalService {

    private final static String ENTITY = "Technical";

    @Autowired
    private TechnicalRepository technicalRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ApplianceTechnicalRepository applianceTechnicalRepository;

    @Autowired
    private TechnicalShiftRepository technicalShiftRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Technical> getAll() {
        return technicalRepository.findAll();
    }

    @Override
    public Technical getById(Long technicalId) {
        return technicalRepository.findById(technicalId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, technicalId));
    }

    @Override
    public Technical create(Technical request) {
        return technicalRepository.save(request);
    }

    @Override
    public Technical update(Long technicalId, Technical request) {
        return technicalRepository.findById(technicalId).map(technical ->
                technicalRepository.save(technical
                        .withFullName(request.getFullName())
                        .withDni(request.getDni())
                        .withEmail(request.getEmail())
                        .withPassword(request.getPassword())
                        .withProfilePictureUrl(request.getProfilePictureUrl())
                        .withAddress(request.getAddress())
                        .withPhone(request.getPhone())
                        .withBirthdayDate(request.getBirthdayDate())
                        .withScore(request.getScore())
                        .withAboutMe(request.getAboutMe())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, technicalId));
    }

    @Override
    public ResponseEntity<?> delete(Long technicalId) {
        return technicalRepository.findById(technicalId).map(technical -> {
            technicalRepository.delete(technical);
            return  ResponseEntity.ok().build();
        }).orElseThrow(() ->new ResourceNotFoundException(ENTITY, technicalId));
    }

    @Override
    public Technical getByEmail(String technicalEmail) {
        return technicalRepository.findByEmail(technicalEmail);
    }

    @Override
        public List<Technical> getByFullName(FullName firstName) {
        return technicalRepository.findByFullName(firstName);
    }


    @Override
    public List<Technical> getAllByScore() {
        return technicalRepository.findAllByOrderByScoreDesc();
    }

    @Override
    public List<Technical> getByShiftTechnicals(Long shiftId) {
        return technicalRepository.findByShiftTechnicals(shiftId);
    }

    @Override
    public List<Technical> getBySelectedDate(Long applianceId, Long shiftId, Date selectedDate) {
        List<Technical> technicalByAppliance = new ArrayList<>(applianceTechnicalRepository.findByApplianceId(applianceId)
                .stream()
                .map(ApplianceTechnical::getTechnical)
                .toList());
        List<Technical> technicalsByShift = new ArrayList<>(technicalShiftRepository.findByShiftId(shiftId)
                .stream()
                .map(TechnicalShift::getTechnical)
                .toList());
        List<Technical> technicalByDate = new ArrayList<>(appointmentRepository.findByScheduledAt(selectedDate)
                .stream()
                .map(AppointmentAggregate::getTechnical)
                .toList());

        technicalByAppliance.retainAll(technicalsByShift);
        technicalByAppliance.removeAll(technicalByDate);

        return technicalByAppliance;
    }


}
