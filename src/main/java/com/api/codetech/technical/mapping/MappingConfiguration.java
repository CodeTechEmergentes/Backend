package com.api.codetech.technical.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("technicalMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public TechnicalMapper technicalMapper() {
        return new TechnicalMapper();
    }

    @Bean
    public ShiftMapper scheduleMapper(){
        return new ShiftMapper();
    }

    @Bean
    public ApplianceMapper applianceMapper(){
        return new ApplianceMapper();
    }

    @Bean
    public ApplianceTechnicalMapper applianceTechnicalMapper()
    {
        return new ApplianceTechnicalMapper();
    }

    @Bean
    public TechnicalShiftMapper technicalShiftMapper()
    {
        return new TechnicalShiftMapper();
    }
//    @Bean
//    public ApplianceMapper applianceMapper()
//    {
//        return new ApplianceMapper();
//    }
}
