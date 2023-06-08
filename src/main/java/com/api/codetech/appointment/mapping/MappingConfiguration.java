package com.api.codetech.appointment.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("appointmentMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public AppointmentMapper appointmentMapper(){
        return new AppointmentMapper();
    }

    @Bean
    public ReportMapper reportMapper(){
        return new ReportMapper();
    }
}
