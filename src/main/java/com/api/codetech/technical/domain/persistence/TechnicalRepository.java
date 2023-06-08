package com.api.codetech.technical.domain.persistence;

import com.api.codetech.shared.domain.valueObjects.FullName;
import com.api.codetech.technical.domain.model.entity.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical, Long> {
    Technical findByEmail(String email);
    List<Technical> findByFullName(FullName fullName);
    List<Technical> findAllByOrderByScoreDesc();
    @Query(value = "select * from technical where id in (select b.technical_id from technical_shift b where b.shift_id = :shift_id)", nativeQuery = true)
    List<Technical> findByShiftTechnicals(@Param("shift_id") Long shift_id);

    @Query(value = "select * from technical where id in(select b.technical_id From technical_appliance b Where b.appliance_id = :appliance_id)", nativeQuery = true)
    List<Technical> findByApplianceTechnicals(@Param("appliance_id") Long appliance_id);
}
