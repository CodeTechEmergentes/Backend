package com.api.codetech.technical.mapping;

import com.api.codetech.technical.resource.ApplianceResource;
import com.api.codetech.shared.mapping.EnhancedModelMapper;
import com.api.codetech.technical.domain.model.entity.Appliance;
import com.api.codetech.technical.resource.CreateApplianceResource;
import com.api.codetech.technical.resource.UpdateApplianceResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
public class ApplianceMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    //Object Mapping
    public ApplianceResource toResource(Appliance model){
        return mapper.map(model, ApplianceResource.class);
    }

    public List<ApplianceResource> toResource(List<Appliance>model){
        return mapper.mapList(model, ApplianceResource.class);
    }

    public Appliance toModel(CreateApplianceResource resource){
        return mapper.map(resource, Appliance.class);
    }

    public Appliance toModel(UpdateApplianceResource resource){
        return mapper.map(resource, Appliance.class);
    }


}
