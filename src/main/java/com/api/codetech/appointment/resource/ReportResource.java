package com.api.codetech.appointment.resource;

import com.api.codetech.shared.domain.valueObjects.ApplianceInfo;
import com.api.codetech.technical.resource.TechnicalResource;
import com.api.codetech.user.resource.UserResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportResource {
    private Long id;
    private ApplianceInfo applianceInfo;
    private String applianceDiagnostic;
    private String reparationDetails;
    private UserResource user;
    private TechnicalResource technical;
    private AppointmentResource appointment;
}
