package com.api.codetech.technical.domain.service;

import com.api.codetech.technical.domain.model.entity.ApplianceTechnical;

import java.util.List;

public interface ApplianceTechnicalService {
    List<ApplianceTechnical> getAll();
    ApplianceTechnical create(Long technicalId, Long applianceId);
    List<ApplianceTechnical> getByTechnicalId(Long technicalId);
    List<ApplianceTechnical> getByApplianceId(Long applianceId);

}
