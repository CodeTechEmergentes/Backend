package com.api.codetech.technical.domain.service;

import com.api.codetech.technical.domain.model.entity.Shift;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShiftService {
    List<Shift> getAll();
    Shift create(Shift shift);
    ResponseEntity<?> delete(Long scheduleId);
    Shift getById(Long scheduleId);


}
