package com.api.codetech.appointment.resource;

import com.api.codetech.shared.domain.valueObjects.ApplianceInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateReportResource {

    @Embedded
    private ApplianceInfo applianceInfo;

    @NotNull
    @NotBlank
    private String applianceDiagnostic;

    @NotNull
    @NotBlank
    private String reparationDetails;
}
