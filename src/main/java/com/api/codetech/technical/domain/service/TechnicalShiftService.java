package com.api.codetech.technical.domain.service;

import com.api.codetech.technical.domain.model.entity.TechnicalShift;

import java.util.List;

public interface TechnicalShiftService {
    List<TechnicalShift> getAll();
    TechnicalShift create(Long technicalId, Long shiftId);
    List<TechnicalShift> getByTechnicalId(Long technicalId);
    List<TechnicalShift> getByShiftId(Long shiftId);
}
