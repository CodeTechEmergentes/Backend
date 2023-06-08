package com.api.codetech.appointment.mapping;

import com.api.codetech.appointment.domain.model.entity.AppointmentAggregate;
import com.api.codetech.appointment.resource.AppointmentResource;
import com.api.codetech.appointment.resource.CreateAppointmentResource;
import com.api.codetech.appointment.resource.UpdateAppointmentResource;
import com.api.codetech.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class AppointmentMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;



    //Object Mapping
    public AppointmentResource toResource(AppointmentAggregate model){
        return mapper.map(model, AppointmentResource.class);
    }

    public List<AppointmentResource> toResource(List<AppointmentAggregate>model){
        return mapper.mapList(model, AppointmentResource.class);
    }

    public AppointmentAggregate toModel(CreateAppointmentResource resource){
        return mapper.map(resource, AppointmentAggregate.class);
    }

    public AppointmentAggregate toModel(UpdateAppointmentResource resource){
        return mapper.map(resource, AppointmentAggregate.class);
    }
}
