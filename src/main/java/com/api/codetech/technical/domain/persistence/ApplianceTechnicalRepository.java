package com.api.codetech.technical.domain.persistence;

import com.api.codetech.technical.domain.model.entity.ApplianceTechnical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplianceTechnicalRepository extends JpaRepository<ApplianceTechnical, Long> {
    List<ApplianceTechnical> findByTechnicalId(Long technicalId);
    List<ApplianceTechnical> findByApplianceId(Long applianceId);
}
