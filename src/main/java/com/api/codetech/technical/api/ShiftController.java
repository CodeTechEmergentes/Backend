package com.api.codetech.technical.api;

import com.api.codetech.technical.domain.service.ShiftService;
import com.api.codetech.technical.domain.service.TechnicalShiftService;
import com.api.codetech.technical.mapping.ShiftMapper;
import com.api.codetech.technical.mapping.TechnicalShiftMapper;
import com.api.codetech.technical.resource.CreateShiftResource;
import com.api.codetech.technical.resource.ShiftResource;
import com.api.codetech.technical.resource.technical_shift.TechnicalShiftResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Shift")
@RestController
@RequestMapping("/api/v1/shifts")
@CrossOrigin
public class ShiftController {

    @Autowired
    private ShiftService shiftService;

    @Autowired
    private ShiftMapper mapper;

    @Autowired
    private TechnicalShiftService technicalShiftService;

    @Autowired
    private TechnicalShiftMapper technicalShiftMapper;

    @Operation(summary = "Get Shifts", description = "Get All Shifts")
    @GetMapping
    public List<ShiftResource> getAllShifts()
    {
        return mapper.toResource(shiftService.getAll());
    }

    @Operation(summary = "Get Shift by Id", description = "Get Shift by Id")
    @GetMapping("{shiftId}")
    public ShiftResource getShiftById(@PathVariable Long shiftId)
    {
        return mapper.toResource(shiftService.getById(shiftId));
    }

    @Operation(summary = "Create Shift", description = "Create Shift")
    @PostMapping
    public ShiftResource createShift(@RequestBody CreateShiftResource request)
    {
        return mapper.toResource(shiftService.create(mapper.toModel(request)));
    }

    //------------Technical_Shift-------------------
    @Operation(summary = "Get All TechnicalShift", description = "Get All")
    @GetMapping("/technical/shift")
    public List<TechnicalShiftResource> getAllTechnicalShift() {
        return technicalShiftMapper.toResource(technicalShiftService.getAll());
    }

    @Operation(summary = "Get All TechnicalShift by technicalId", description = "Get All")
    @GetMapping("/technicalshift/technical/{technicalId}")
    public List<TechnicalShiftResource> getAllTechnicalShiftByTechnicalId(@PathVariable Long technicalId)
    {
        return technicalShiftMapper.toResource(technicalShiftService.getByTechnicalId(technicalId));
    }

    @Operation(summary = "Get All TechnicalShift by ShiftId", description = "Get All")
    @GetMapping("/technicalshift/shift/{shiftId}")
    public List<TechnicalShiftResource> getAllTechnicalShiftByShiftId(@PathVariable Long shiftId)
    {
        return technicalShiftMapper.toResource(technicalShiftService.getByShiftId(shiftId));
    }

    @Operation(summary = "Create TechnicalShift", description = "Create TechnicalShift")
    @PostMapping("/technicalshift/technical/{technicalId}/shift/{shiftId}")
    public TechnicalShiftResource createTechnicalShift(@PathVariable(name = "technicalId") Long technicalId,
                                                       @PathVariable(name = "shiftId") Long shiftId)
    {
        return technicalShiftMapper.toResource(technicalShiftService.create(technicalId, shiftId));
    }

}
