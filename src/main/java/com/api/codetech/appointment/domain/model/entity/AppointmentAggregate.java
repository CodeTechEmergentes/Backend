package com.api.codetech.appointment.domain.model.entity;

import com.api.codetech.shared.domain.valueObjects.Address;
import com.api.codetech.shared.domain.valueObjects.Money;
import com.api.codetech.technical.domain.model.entity.Appliance;
import com.api.codetech.shared.domain.model.AuditModel;
import com.api.codetech.technical.domain.model.entity.Technical;
import com.api.codetech.user.domain.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "appointment")
public class AppointmentAggregate extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "technical_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Technical technical;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appliance_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Appliance appliance;

}
