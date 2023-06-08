package com.api.codetech.technical.resource.technical_shift;

import com.api.codetech.technical.resource.ShiftResource;
import com.api.codetech.technical.resource.TechnicalResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnicalShiftResource {
    private Long id;
    private TechnicalResource technical;
    private ShiftResource shift;
}
