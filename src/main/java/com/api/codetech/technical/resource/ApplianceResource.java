package com.api.codetech.technical.resource;


import com.api.codetech.shared.domain.valueObjects.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplianceResource {
    private Long id;
    private String name;
    private Money diagnosisCost;
    private String imgUrl;
}
