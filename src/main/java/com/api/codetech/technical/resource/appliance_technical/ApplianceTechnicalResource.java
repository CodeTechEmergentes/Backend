package com.api.codetech.technical.resource.appliance_technical;

import com.api.codetech.technical.resource.ApplianceResource;
import com.api.codetech.technical.resource.TechnicalResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplianceTechnicalResource {
    private Long id;
    private TechnicalResource technical;
    private ApplianceResource appliance;
}
