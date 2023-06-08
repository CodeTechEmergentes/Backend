package com.api.codetech.technical.service;

import com.api.codetech.shared.exception.ResourceNotFoundException;
import com.api.codetech.technical.domain.model.entity.Shift;
import com.api.codetech.technical.domain.model.entity.Technical;
import com.api.codetech.technical.domain.model.entity.TechnicalShift;
import com.api.codetech.technical.domain.persistence.ShiftRepository;
import com.api.codetech.technical.domain.persistence.TechnicalRepository;
import com.api.codetech.technical.domain.persistence.TechnicalShiftRepository;
import com.api.codetech.technical.domain.service.TechnicalShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalShiftServiceImpl implements TechnicalShiftService {

    private final TechnicalShiftRepository technicalShiftRepository;

    @Autowired
    private TechnicalRepository technicalRepository;

    @Autowired
    private ShiftRepository shiftRepository;

    public TechnicalShiftServiceImpl(TechnicalShiftRepository technicalShiftRepository) {
        this.technicalShiftRepository = technicalShiftRepository;
    }

    @Override
    public List<TechnicalShift> getAll() {
        return technicalShiftRepository.findAll();
    }

    @Override
    public TechnicalShift create(Long technicalId, Long shiftId) {
        Technical technical = technicalRepository.findById(technicalId).orElseThrow(() -> new ResourceNotFoundException("Technical not found with Id" + technicalId));
        Shift shift = shiftRepository.findById(shiftId).orElseThrow(() -> new ResourceNotFoundException("Technical not found with Id" + shiftId));

        TechnicalShift technicalShift = new TechnicalShift();
        technicalShift.setTechnical(technical);
        technicalShift.setShift(shift);
        return technicalShiftRepository.save(technicalShift);
    }

    @Override
    public List<TechnicalShift> getByTechnicalId(Long technicalId) {
        return technicalShiftRepository.findByTechnicalId(technicalId);
    }

    @Override
    public List<TechnicalShift> getByShiftId(Long shiftId) {
        return technicalShiftRepository.findByShiftId(shiftId);
    }
}
