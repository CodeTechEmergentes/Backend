package com.api.codetech.technical.domain.service;

import com.api.codetech.shared.domain.valueObjects.FullName;
import com.api.codetech.technical.domain.model.entity.Technical;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface TechnicalService {
    List<Technical> getAll();
    Technical getById(Long TechnicalId);
    Technical create(Technical request);
    Technical update(Long technicalId, Technical request);
    ResponseEntity<?> delete(Long technicalId);
    Technical getByEmail(String email);
    List<Technical> getByFullName(FullName fullName);
    List<Technical> getAllByScore();
    List<Technical> getByShiftTechnicals(Long shiftId);
    List<Technical> getBySelectedDate(Long applianceId, Long shiftId, Date selectedDate);
}
