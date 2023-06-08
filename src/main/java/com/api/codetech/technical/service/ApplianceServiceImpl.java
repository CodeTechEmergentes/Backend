package com.api.codetech.technical.service;

import com.api.codetech.shared.exception.ResourceNotFoundException;
import com.api.codetech.technical.domain.model.entity.Appliance;
import com.api.codetech.technical.domain.persistence.ApplianceRepository;
import com.api.codetech.technical.domain.service.ApplianceService;
import com.api.codetech.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ApplianceServiceImpl implements ApplianceService {

    private final static String ENTITY = "Appliance";

    @Autowired
    private ApplianceRepository applianceRepository;

    @Override
    public List<Appliance> getAll() {
        return applianceRepository.findAll();
    }

    @Override
    public Appliance getById(Long applianceId) {
        return applianceRepository.findById(applianceId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, applianceId));
    }

    @Override
    public Appliance create(Appliance request) {
        return applianceRepository.save(request);
    }
    @Override
    public Appliance update(Long applianceId, Appliance request){

        try{
            return applianceRepository.findById(applianceId)
                    .map(appliance->
                            applianceRepository.save(
                                    appliance.withName(request.getName())
                                            .withDiagnosisCost(request.getDiagnosisCost())
                                            .withImgUrl(request.getImgUrl())
                            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, applianceId));
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating appliance");
        }
    }


    @Override
    public Appliance delete(Long applianceId){
        return applianceRepository.findById(applianceId)
                .map(appliance-> {
                    applianceRepository.delete(appliance);
                    return appliance;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, applianceId));
    }
    @Override
    public List<Appliance> getByName(String name) {
        return applianceRepository.findByName(name);
    }

}
