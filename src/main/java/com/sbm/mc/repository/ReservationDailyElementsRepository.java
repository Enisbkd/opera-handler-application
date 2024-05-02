package com.sbm.mc.repository;

import com.sbm.mc.domain.ReservationDailyElements;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ReservationDailyElements entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReservationDailyElementsRepository extends JpaRepository<ReservationDailyElements, Long> {}
