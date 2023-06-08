package com.api.codetech.technical.mapping;

import com.api.codetech.shared.mapping.EnhancedModelMapper;
import com.api.codetech.technical.domain.model.entity.TechnicalShift;
import com.api.codetech.technical.resource.technical_shift.TechnicalShiftResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class TechnicalShiftMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public TechnicalShiftResource toResource(TechnicalShift model)
    {
        return mapper.map(model, TechnicalShiftResource.class);
    }

    public List<TechnicalShiftResource> toResource(List<TechnicalShift> model)
    {
        return mapper.mapList(model, TechnicalShiftResource.class);
    }
}
