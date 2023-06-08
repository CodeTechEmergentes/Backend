package com.api.codetech.technical.service;

import com.api.codetech.shared.exception.ResourceNotFoundException;
import com.api.codetech.technical.domain.model.entity.Appliance;
import com.api.codetech.technical.domain.model.entity.ApplianceTechnical;
import com.api.codetech.technical.domain.model.entity.Technical;
import com.api.codetech.technical.domain.persistence.ApplianceRepository;
import com.api.codetech.technical.domain.persistence.ApplianceTechnicalRepository;
import com.api.codetech.technical.domain.persistence.TechnicalRepository;
import com.api.codetech.technical.domain.service.ApplianceTechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplianceTechnicalServiceImpl implements ApplianceTechnicalService {

    private final static String ENTITY = "technical";

    private final ApplianceTechnicalRepository applianceTechnicalRepository;

    @Autowired
    private TechnicalRepository technicalRepository;

    @Autowired
    private ApplianceRepository applianceRepository;

    public ApplianceTechnicalServiceImpl(ApplianceTechnicalRepository applianceTechnicalRepository) {
        this.applianceTechnicalRepository = applianceTechnicalRepository;
    }


    @Override
    public List<ApplianceTechnical> getAll() {
        return applianceTechnicalRepository.findAll();
    }

    @Override
    public ApplianceTechnical create(Long technicalId, Long applianceId) {
//        var technical = technicalRepository.findById(technicalId);
//        if(technical.isEmpty())
//            throw new ResourceNotFoundException(ENTITY, technicalId);
        Technical technical = technicalRepository.findById(technicalId).orElseThrow(() -> new ResourceNotFoundException("Technical not found with Id" + technicalId));
        Appliance appliance = applianceRepository.findById(applianceId).orElseThrow(() -> new ResourceNotFoundException("Appliance not found with Id" + applianceId));

        ApplianceTechnical applianceTechnical = new ApplianceTechnical();
        applianceTechnical.setTechnical(technical);
        applianceTechnical.setAppliance(appliance);
        return applianceTechnicalRepository.save(applianceTechnical);
    }

    @Override
    public List<ApplianceTechnical> getByTechnicalId(Long technicalId) {
        return applianceTechnicalRepository.findByTechnicalId(technicalId);
    }

    @Override
    public List<ApplianceTechnical> getByApplianceId(Long applianceId) {
        return applianceTechnicalRepository.findByApplianceId(applianceId);
    }
}
