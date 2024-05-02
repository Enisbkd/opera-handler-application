package com.sbm.mc.repository;

import com.sbm.mc.domain.ReservationStatDaily;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ReservationStatDaily entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReservationStatDailyRepository extends JpaRepository<ReservationStatDaily, Long> {}
