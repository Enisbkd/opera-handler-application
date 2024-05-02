package com.sbm.mc.repository;

import com.sbm.mc.domain.NameAddress;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the NameAddress entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NameAddressRepository extends JpaRepository<NameAddress, Integer> {}
