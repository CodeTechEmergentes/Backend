package com.api.codetech.technical.mapping;

import com.api.codetech.shared.mapping.EnhancedModelMapper;
import com.api.codetech.technical.domain.model.entity.Technical;
import com.api.codetech.technical.resource.CreateTechnicalResource;
import com.api.codetech.technical.resource.TechnicalResource;
import com.api.codetech.technical.resource.UpdateTechnicalResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TechnicalMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    // Object Mapping
    public TechnicalResource toResource(Technical model)
    {
        return mapper.map(model, TechnicalResource.class);
    }

    public List<TechnicalResource> toResource(List<Technical> model)
    {
        return mapper.mapList(model, TechnicalResource.class);
    }

    public Technical toModel(CreateTechnicalResource resource)
    {
        return mapper.map(resource, Technical.class);
    }

    public Technical toModel(UpdateTechnicalResource resource)
    {
        return mapper.map(resource, Technical.class);
    }
}
