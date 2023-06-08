package com.api.codetech.technical.mapping;

import com.api.codetech.shared.mapping.EnhancedModelMapper;
import com.api.codetech.technical.domain.model.entity.ApplianceTechnical;
import com.api.codetech.technical.resource.appliance_technical.ApplianceTechnicalResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ApplianceTechnicalMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public ApplianceTechnicalResource toResource(ApplianceTechnical model)
    {
        return mapper.map(model, ApplianceTechnicalResource.class);
    }

    public List<ApplianceTechnicalResource> toResource(List<ApplianceTechnical> model)
    {
        return mapper.mapList(model, ApplianceTechnicalResource.class);
    }

}
