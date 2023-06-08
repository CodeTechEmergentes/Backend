package com.api.codetech.appointment.mapping;

import com.api.codetech.appointment.domain.model.entity.Report;
import com.api.codetech.appointment.resource.CreateReportResource;
import com.api.codetech.appointment.resource.ReportResource;
import com.api.codetech.appointment.resource.UpdateReportResource;
import com.api.codetech.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ReportMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    //Object Mapping
    public ReportResource toResource(Report model){
        return mapper.map(model,ReportResource.class);
    }

    public List<ReportResource> toResource(List<Report>model){
        return mapper.mapList(model, ReportResource.class);
    }

    public Report toModel(CreateReportResource resource){
        return mapper.map(resource, Report.class);
    }

    public Report toModel(UpdateReportResource resource){
        return mapper.map(resource, Report.class);
    }


}
