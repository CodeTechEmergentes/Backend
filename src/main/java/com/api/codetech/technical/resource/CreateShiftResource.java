package com.api.codetech.technical.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Time;

@Getter
@Setter
public class CreateShiftResource {

    @NotNull
    private Time startTime;

    @NotNull
    private Time endTime;

    @NotNull
    private Integer repairDuration;
}
