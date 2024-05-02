package com.sbm.mc.repository;

import com.sbm.mc.domain.NamePhone;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the NamePhone entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NamePhoneRepository extends JpaRepository<NamePhone, Integer> {}
