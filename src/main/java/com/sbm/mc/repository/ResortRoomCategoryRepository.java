package com.sbm.mc.repository;

import com.sbm.mc.domain.ResortRoomCategory;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ResortRoomCategory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResortRoomCategoryRepository extends JpaRepository<ResortRoomCategory, Long> {}
