package com.sbm.mc.repository;

import com.sbm.mc.domain.FinancialTransactions;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the FinancialTransactions entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FinancialTransactionsRepository extends JpaRepository<FinancialTransactions, Integer> {}
