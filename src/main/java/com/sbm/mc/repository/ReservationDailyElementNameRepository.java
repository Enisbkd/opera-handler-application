package com.sbm.mc.repository;

import com.sbm.mc.domain.ReservationDailyElementName;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ReservationDailyElementName entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReservationDailyElementNameRepository extends JpaRepository<ReservationDailyElementName, Long> {}
