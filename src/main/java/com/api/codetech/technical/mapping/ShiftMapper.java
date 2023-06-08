package com.api.codetech.technical.mapping;

import com.api.codetech.shared.mapping.EnhancedModelMapper;
import com.api.codetech.technical.domain.model.entity.Shift;
import com.api.codetech.technical.resource.CreateShiftResource;
import com.api.codetech.technical.resource.ShiftResource;
import com.api.codetech.technical.resource.UpdateShiftResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiftMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    public ShiftResource toResource(Shift model)
    {
        return mapper.map(model, ShiftResource.class);
    }

    public List<ShiftResource> toResource(List<Shift> model)
    {
        return mapper.mapList(model, ShiftResource.class);
    }

    public Shift toModel(CreateShiftResource resource)
    {
        return mapper.map(resource, Shift.class);
    }

    public Shift toModel(UpdateShiftResource resource)
    {
        return mapper.map(resource, Shift.class);
    }
}
