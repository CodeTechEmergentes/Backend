package com.api.codetech.technical.service;

import com.api.codetech.shared.exception.ResourceNotFoundException;
import com.api.codetech.technical.domain.model.entity.Shift;
import com.api.codetech.technical.domain.persistence.ShiftRepository;
import com.api.codetech.technical.domain.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftServiceImpl implements ShiftService {

    private final static String ENTITY = "Shift";

    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public List<Shift> getAll() {
        return shiftRepository.findAll();
    }

    @Override
    public Shift create(Shift request) {
        return shiftRepository.save(request);
    }

    @Override
    public ResponseEntity<?> delete(Long shiftId) {
        return shiftRepository.findById(shiftId).map(shift -> {
            shiftRepository.delete(shift);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, shiftId));
    }

    @Override
    public Shift getById(Long shiftId) {
        return shiftRepository.findById(shiftId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, shiftId));
    }
}
