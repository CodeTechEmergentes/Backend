package com.api.codetech.technical.domain.model.entity;

import com.api.codetech.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "shift")
public class Shift extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Time startTime;

    @NotNull
    private Time endTime;

    @NotNull
    private Integer repairDuration;

}
