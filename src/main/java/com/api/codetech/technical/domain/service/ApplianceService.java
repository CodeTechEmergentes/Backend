package com.api.codetech.technical.domain.service;

import com.api.codetech.technical.domain.model.entity.Appliance;


import java.util.List;

public interface ApplianceService {
    List<Appliance>getAll();
    Appliance getById(Long applianceId);
    Appliance create(Appliance appliance);
    Appliance update(Long applianceId, Appliance appliance);
    Appliance delete(Long applianceId);
    List<Appliance> getByName(String name);

}
