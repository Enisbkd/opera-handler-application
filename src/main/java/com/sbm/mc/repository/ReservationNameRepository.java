package com.sbm.mc.repository;

import com.sbm.mc.domain.ReservationName;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ReservationName entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReservationNameRepository extends JpaRepository<ReservationName, Long> {}
