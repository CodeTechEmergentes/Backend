package com.api.codetech.appointment.resource;

import com.api.codetech.appointment.domain.model.entity.PaymentStatus;
import com.api.codetech.appointment.domain.model.entity.Status;
import com.api.codetech.shared.domain.valueObjects.Address;
import com.api.codetech.shared.domain.valueObjects.Money;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UpdateAppointmentResource {

    @NotNull
    @NotBlank
    private String problemDescription;

    @NotNull
    private Date scheduledAt;

    @Embedded
    private Address address;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Embedded
    private Money reparationCost;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
