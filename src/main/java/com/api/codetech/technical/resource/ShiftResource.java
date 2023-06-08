package com.api.codetech.technical.resource;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class ShiftResource {
    private Long id;
    private Time startTime;
    private Time endTime;
    private Integer repairDuration;
}
