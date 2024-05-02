package com.sbm.mc.repository;

import com.sbm.mc.domain.Resort;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Resort entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResortRepository extends JpaRepository<Resort, String> {}
