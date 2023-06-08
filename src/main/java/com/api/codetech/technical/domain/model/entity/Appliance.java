package com.api.codetech.technical.domain.model.entity;

import com.api.codetech.shared.domain.model.AuditModel;
import com.api.codetech.shared.domain.valueObjects.Money;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name="appliance")
public class Appliance extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @Embedded
    private Money diagnosisCost;

    @NotNull
    private String imgUrl;
}
