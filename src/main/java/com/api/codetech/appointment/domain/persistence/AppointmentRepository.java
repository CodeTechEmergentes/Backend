package com.api.codetech.appointment.domain.persistence;

import com.api.codetech.appointment.domain.model.entity.AppointmentAggregate;
import com.api.codetech.appointment.domain.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentAggregate, Long> {
    List<AppointmentAggregate> findByUserId(Long userId);
    List<AppointmentAggregate> findByTechnicalId(Long technicalId);
    List<AppointmentAggregate> findByUserIdAndTechnicalId(Long userId, Long technicalId);
    List<AppointmentAggregate> findByScheduledAtGreaterThanEqualAndTechnicalId(Date scheduledAt, Long technicalId);
    List<AppointmentAggregate> findByUserIdAndStatus (Long userId, Status status);
    List<AppointmentAggregate> findByUserIdAndScheduledAtLessThanEqual(Long userId, Date scheduledAt);
    List<AppointmentAggregate> findByScheduledAt(Date scheduledAt);

}
