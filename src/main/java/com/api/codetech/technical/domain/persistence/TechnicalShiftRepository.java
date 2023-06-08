package com.api.codetech.technical.domain.persistence;

import com.api.codetech.technical.domain.model.entity.TechnicalShift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalShiftRepository extends JpaRepository<TechnicalShift, Long> {
    List<TechnicalShift> findByTechnicalId(Long technicalId);
    List<TechnicalShift> findByShiftId(Long shiftId);
}
