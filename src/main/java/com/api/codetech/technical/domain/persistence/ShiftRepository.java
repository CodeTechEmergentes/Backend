package com.api.codetech.technical.domain.persistence;

import com.api.codetech.technical.domain.model.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShiftRepository extends JpaRepository<Shift, Long> {

    @Query(value = "select * from shift where id in(Select b.shift_id From technical_shift b Where b.technical_id = :technical_id)", nativeQuery = true)
    List<Shift> findByTechnicalId(@Param("technical_id") Long technical_id);
}
