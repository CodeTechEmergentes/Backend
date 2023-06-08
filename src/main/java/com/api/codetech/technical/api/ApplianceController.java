package com.api.codetech.technical.api;


import com.api.codetech.technical.domain.service.ApplianceService;
import com.api.codetech.technical.domain.service.ApplianceTechnicalService;
import com.api.codetech.technical.mapping.ApplianceMapper;
import com.api.codetech.technical.mapping.ApplianceTechnicalMapper;
import com.api.codetech.technical.resource.ApplianceResource;
import com.api.codetech.technical.resource.CreateApplianceResource;
import com.api.codetech.technical.resource.UpdateApplianceResource;
import com.api.codetech.technical.domain.persistence.TechnicalRepository;
import com.api.codetech.technical.mapping.TechnicalMapper;
import com.api.codetech.technical.resource.TechnicalResource;
import com.api.codetech.technical.resource.appliance_technical.ApplianceTechnicalResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Appliance")
@RestController
@RequestMapping("api/v1/appliances")
@CrossOrigin
public class ApplianceController {

    @Autowired
    private ApplianceService applianceService;

    @Autowired
    private ApplianceTechnicalService applianceTechnicalService;

    @Autowired
    private ApplianceMapper applianceMapper;

    @Autowired
    private ApplianceTechnicalMapper applianceTechnicalMapper;

    @Autowired
    private TechnicalRepository technicalRepository;

    @Autowired
    private TechnicalMapper technicalMapper;

    @Operation(summary = "Get All Appliances", description = "Get All Appliances")
    @GetMapping
    public List<ApplianceResource> getAllAppliance() { return applianceMapper.toResource(applianceService.getAll());}

    @Operation(summary = "Get Appliance by Id", description = "Get Appliance  by Id")
    @GetMapping("{applianceId}")
    public ApplianceResource getApplianceById(@PathVariable Long applianceId){
        return applianceMapper.toResource(applianceService.getById(applianceId));
    }

    @Operation(summary = "Get Appliance by Name", description = "Get Appliance by Name")
    @GetMapping("/name/{name}")
    public List<ApplianceResource> getByName(@PathVariable String name){
        return applianceMapper.toResource(applianceService.getByName(name));
    }

    @Operation(summary = "Create New Appliance", description = "Create New Appliance")
    @PostMapping
    public ApplianceResource createAppliance(@RequestBody CreateApplianceResource model){
        return applianceMapper.toResource(applianceService.create(applianceMapper.toModel(model)));
    }
    @Operation(summary = "Update Appliance", description = "Update Appliance")
    @PutMapping("{applianceId}")
    public ApplianceResource updateAppliance(@PathVariable Long applianceId, @RequestBody UpdateApplianceResource model){
        return applianceMapper.toResource(applianceService.update(applianceId, applianceMapper.toModel(model)));
    }
    @Operation(summary = "Delete Appliance", description = "Delete Appliance")
    @DeleteMapping("{applianceId}")
    public void deleteAppliance(@PathVariable Long applianceId){ applianceService.delete(applianceId);}




    //---------------------------------------------------------------------------------------------------------------------
    @Operation(summary = "Get Technicals By ApplianceId", description = "Get Technicals By ApplianceId")
    @GetMapping("{applianceId}/technicals")
    public List<TechnicalResource> getAppliancesByTechnicalId(@PathVariable Long applianceId)
    {
        return technicalMapper.toResource(technicalRepository.findByApplianceTechnicals(applianceId));
    }

    //-------Appliance_Technical-----------------------------
    @Operation(summary = "Get All ApplianceTechnical", description = "Get All")
    @GetMapping("/appliance/technical")
    public List<ApplianceTechnicalResource> getAllApplianceTechnical() {
        return applianceTechnicalMapper.toResource(applianceTechnicalService.getAll());
    }

    @Operation(summary = "Get All ApplianceTechnical by technicalId", description = "Get All")
    @GetMapping("/appliancetechnical/technical/{technicalId}")
    public List<ApplianceTechnicalResource> getAllApplianceTechnicalByTechnicalId(@PathVariable Long technicalId)
    {
        return applianceTechnicalMapper.toResource(applianceTechnicalService.getByTechnicalId(technicalId));
    }

    @Operation(summary = "Get All ApplianceTechnical by applianceId", description = "Get All")
    @GetMapping("/appliancetechnical/appliance/{applianceId}")
    public List<ApplianceTechnicalResource> getAllApplianceTechnicalByApplianceId(@PathVariable Long applianceId)
    {
        return applianceTechnicalMapper.toResource(applianceTechnicalService.getByApplianceId(applianceId));
    }

    @Operation(summary = "Create ApplianceTechnical", description = "Create ApplianceTechnical")
    @PostMapping("/appliancetechnical/technical/{technicalId}/appliance/{applianceId}")
    public ApplianceTechnicalResource createApplianceTechnical(@PathVariable(name = "technicalId") Long technicalId,
                                                               @PathVariable(name = "applianceId") Long applianceId)
    {
        return applianceTechnicalMapper.toResource(applianceTechnicalService.create(technicalId, applianceId));
    }



}
