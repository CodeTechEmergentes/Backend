package com.api.codetech.appointment.resource;

import com.api.codetech.appointment.domain.model.entity.PaymentStatus;
import com.api.codetech.shared.domain.valueObjects.Address;
import com.api.codetech.shared.domain.valueObjects.Money;
import com.api.codetech.technical.resource.ApplianceResource;
import com.api.codetech.appointment.domain.model.entity.Status;
import com.api.codetech.technical.resource.TechnicalResource;
import com.api.codetech.user.resource.UserResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class AppointmentResource {
    private Long id;
    private String problemDescription;
    private Date scheduledAt;
    private Address address;
    private Status status;
    private Money reparationCost;
    private PaymentStatus paymentStatus;
    private UserResource user;
    private TechnicalResource technical;
    private ApplianceResource appliance;
}
