package com.api.codetech.appointment.api;

import com.api.codetech.appointment.domain.model.entity.Status;
import com.api.codetech.appointment.domain.service.AppointmentService;
import com.api.codetech.appointment.mapping.AppointmentMapper;
import com.api.codetech.appointment.resource.AppointmentResource;
import com.api.codetech.appointment.resource.CreateAppointmentResource;
import com.api.codetech.appointment.resource.UpdateAppointmentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Tag(name = "Appointment")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Operation(summary = "Get All Appointments", description = "Get All Appointments")
    @GetMapping("appointments")
    public List<AppointmentResource> getAll(){
        return appointmentMapper.toResource(appointmentService.getAll());
    }

    @Operation(summary = "Get Appointment by Id", description = "Get Appointment by Id")
    @GetMapping("appointments/{appointmentId}")
    public AppointmentResource getAppointmentById(@PathVariable Long appointmentId){
        return appointmentMapper.toResource(appointmentService.getById(appointmentId));
    }

    @Operation(summary = "Get Appointments by UserId", description = "Get All Appointments by UserId")
    @GetMapping("users/{userId}/appointments")
    public List<AppointmentResource> getAppointmentsByUserId(@PathVariable Long userId){
        return appointmentMapper.toResource(appointmentService.getByUserId(userId));
    }

    @Operation(summary = "Get Appointments by TechnicalId", description = "Get All Appointments by TechnicalId")
    @GetMapping("technicals/{technicalId}/appointments")
    public List<AppointmentResource> getAppointmentsByTechnicalId(@PathVariable Long technicalId){
        return appointmentMapper.toResource(appointmentService.getByUserId(technicalId));
    }

    @Operation(summary = "Get Appointments by UserId and TechnicalId", description = "Get All Appointments by UserId and TechnicalId")
    @GetMapping("users/{userId}/technical/{technicalId}/appointments")
    public List<AppointmentResource> getAppointmentsByUserIdAndTechnicalId(@PathVariable Long userId, @PathVariable Long technicalId){
        return appointmentMapper.toResource(appointmentService.getByUserIdAndTechnicalId(userId, technicalId));
    }

    @Operation(summary = "Get Appointments by ScheduledDate and Technical", description = "Get All Appointments by ScheduledDate and Technical")
    @GetMapping("scheduledDate/{scheduledDate}/technical/{technicalId}/appointments")
    public List<AppointmentResource> getAppointmentsByScheduledDateAndTechnical(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date scheduledDate, @PathVariable Long technicalId){
        return appointmentMapper.toResource(appointmentService.getByScheduledDateAndTechnicalId(scheduledDate, technicalId));
    }

    @Operation(summary = "Create New Appointment", description = "Create New Appointment")
    @PostMapping("users/{userId}/technicals/{technicalId}/appliance/{applianceId}/appointments")
    public AppointmentResource createAppointment(@RequestBody CreateAppointmentResource model, @PathVariable Long userId, @PathVariable Long technicalId, @PathVariable Long applianceId){
        return appointmentMapper.toResource(appointmentService.create(appointmentMapper.toModel(model), userId, technicalId, applianceId));
    }

    @Operation(summary = "Update Appointment", description = "Update Appointment")
    @PutMapping("appointments/{appointmentId}")
    public AppointmentResource updateAppointment(@PathVariable Long appointmentId, @RequestBody UpdateAppointmentResource model){
        return appointmentMapper.toResource(appointmentService.update(appointmentId, appointmentMapper.toModel(model)));
    }

    @Operation(summary = "Delete Appointment", description = "Delete Appointment")
    @DeleteMapping("{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId){
        appointmentService.delete(appointmentId);
    }

    @Operation(summary = "Get Appointments by UserId and Status", description = "Get All Appointments by UserId and Status")
    @GetMapping("users/{userId}/status/{status}/appointments")
    public List<AppointmentResource> getAppointmentsByUserIdAndStatus(@PathVariable Long userId, @PathVariable Status status){
        return appointmentMapper.toResource(appointmentService.getByUserIdAndStatus(userId, status));
    }

    @Operation(summary = "Get Appointments Finished by UserId", description = "Get All Appointments Finished by UserId")
    @GetMapping ("user/{userId}/date/{date}/appointments")
    public List<AppointmentResource> getAppointmentsFinishedByUser(@PathVariable Long userId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        return appointmentMapper.toResource(appointmentService.appointmentsByUserFinished(userId, date));
    }

}
