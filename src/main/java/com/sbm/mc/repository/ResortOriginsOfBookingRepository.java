package com.sbm.mc.repository;

import com.sbm.mc.domain.ResortOriginsOfBooking;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ResortOriginsOfBooking entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResortOriginsOfBookingRepository extends JpaRepository<ResortOriginsOfBooking, Long> {}
