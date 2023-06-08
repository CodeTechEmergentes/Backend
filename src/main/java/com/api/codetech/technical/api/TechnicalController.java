package com.api.codetech.technical.api;

import com.api.codetech.shared.domain.valueObjects.FullName;
import com.api.codetech.technical.domain.persistence.ApplianceRepository;
import com.api.codetech.technical.domain.persistence.ApplianceTechnicalRepository;
import com.api.codetech.technical.domain.service.ApplianceService;
import com.api.codetech.technical.mapping.ApplianceMapper;
import com.api.codetech.technical.resource.ApplianceResource;
import com.api.codetech.technical.domain.persistence.ShiftRepository;
import com.api.codetech.technical.domain.persistence.TechnicalShiftRepository;
import com.api.codetech.technical.domain.service.ShiftService;
import com.api.codetech.technical.domain.service.TechnicalService;
import com.api.codetech.technical.mapping.ShiftMapper;
import com.api.codetech.technical.mapping.TechnicalMapper;
import com.api.codetech.technical.resource.CreateTechnicalResource;
import com.api.codetech.technical.resource.ShiftResource;
import com.api.codetech.technical.resource.TechnicalResource;
import com.api.codetech.technical.resource.UpdateTechnicalResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Tag(name = "Technical")
@RestController
@RequestMapping("/api/v1/technicals")
@CrossOrigin
public class TechnicalController {

    @Autowired
    private TechnicalService technicalService;

    @Autowired
    private ShiftService shiftService;

    @Autowired
    private ApplianceService applianceService;

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private TechnicalShiftRepository technicalShiftRepository;

    @Autowired
    private ApplianceRepository applianceRepository;

    @Autowired
    private ApplianceTechnicalRepository applianceTechnicalRepository;

    @Autowired
    private ShiftMapper shiftMapper;

    @Autowired
    private TechnicalMapper mapper;

    @Autowired
    private ApplianceMapper applianceMapper;


    @Operation(summary = "Get Technicals", description = "Get All Technicals")
    @GetMapping
    public List<TechnicalResource> getAllTechnicals()
    {
        return mapper.toResource(technicalService.getAll());
    }

    @Operation(summary = "Get Technicals by Id", description = "Get Technicals by Id")
    @GetMapping("{technicalId}")
    public TechnicalResource getById(@PathVariable Long technicalId)
    {
        return mapper.toResource(technicalService.getById(technicalId));
    }

    @Operation(summary = "Create Technical", description = "Create Technical")
    @PostMapping
    public TechnicalResource createTechnical(@RequestBody CreateTechnicalResource request)
    {
        return mapper.toResource(technicalService.create(mapper.toModel(request)));
    }

    @Operation(summary = "Update Technical", description = "Update Technical by Id")
    @PutMapping("{technicalId}")
    public TechnicalResource updateTechnical(@PathVariable Long technicalId, @RequestBody UpdateTechnicalResource request)
    {
        return mapper.toResource(technicalService.update(technicalId, mapper.toModel(request)));
    }

    @Operation(summary = "Delete technical", description = "Delete technical by Id")
    @DeleteMapping("{technicalId}")
    public ResponseEntity<?> deleteTechnical(@PathVariable Long technicalId)
    {
        return technicalService.delete(technicalId);
    }

    @Operation(summary = "Get Technicals by Email", description = "Get Technicals by Email")
    @GetMapping("email/{technicalEmail}")
    public TechnicalResource getByEmail(@PathVariable String technicalEmail)
    {
        return mapper.toResource(technicalService.getByEmail(technicalEmail));
    }

    @Operation(summary = "Get Technicals by Full Name", description = "Get Technicals by Full Name")
    @GetMapping("fullName/{fullName}")
    public List<TechnicalResource> getByFullName(@PathVariable FullName fullName)
    {
        return mapper.toResource(technicalService.getByFullName(fullName));
    }

    //SHIFT - TECHNICAL===================================================>
    @Operation(summary = "Get Technicals by Id", description = "Get Technical by Id")
    @GetMapping("{technicalId}/shifts")
    public List<ShiftResource> getShiftsByTechnicalId(@PathVariable Long technicalId)
    {
        return shiftMapper.toResource(shiftRepository.findByTechnicalId(technicalId));
    }

    //APPLIANCE - TECHNICAL===================================================>
    @Operation(summary = "Get Appliances by Technical Id", description = "Get Appliances by Technical Id")
    @GetMapping("/appliances/{technicalId}")
    public List<ApplianceResource> getAppliancesByTechnicalId(@PathVariable Long technicalId)
    {
        return applianceMapper.toResource(applianceRepository.findByTechnicalIdFromAppliances(technicalId));
    }

    @Operation(summary = "Get Technicals Order by Score", description = "Get Technicals Order by Score")
    @GetMapping("/score")
    public List<TechnicalResource> getTechnicalsOrderByScore()
    {
        return mapper.toResource(technicalService.getAllByScore());
    }

    @Operation(summary = "Get Technicals by Shift Id", description = "Get Technicals by Shift Id")
    @GetMapping("/shift/{shiftId}")
    public List<TechnicalResource> getTechnicalsByShiftId(@PathVariable Long shiftId)
    {
        return mapper.toResource(technicalService.getByShiftTechnicals(shiftId));
    }

    @Operation(summary = "Get Technicals by Appliance and Shift and Date Selected", description = "Get Technicals by Appliance and Shift and Date Selected")
    @GetMapping("appliance/{applianceId}/shift/{shiftId}/date/{date}")
    public List<TechnicalResource> getTechnicalsByApplianceAndShiftAndSelectedDate(@PathVariable Long applianceId, @PathVariable Long shiftId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date)
    {
        return mapper.toResource(technicalService.getBySelectedDate(applianceId, shiftId, date));
    }

}
