package com.sbm.mc.repository;

import com.sbm.mc.domain.ReservationSummary;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ReservationSummary entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReservationSummaryRepository extends JpaRepository<ReservationSummary, Integer> {}
