package com.api.codetech.technical.resource;

import com.api.codetech.shared.domain.valueObjects.Money;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateApplianceResource {

    @NotNull
    @NotBlank
    private String name;

    @Embedded
    private Money diagnosisCost;

    @NotNull
    private String imgUrl;
}
