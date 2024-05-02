package com.sbm.mc.service;

import com.sbm.mc.domain.FinancialTransactions;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.FinancialTransactions}.
 */
public interface FinancialTransactionsService {
    /**
     * Save a financialTransactions.
     *
     * @param financialTransactions the entity to save.
     * @return the persisted entity.
     */
    FinancialTransactions save(FinancialTransactions financialTransactions);

    /**
     * Updates a financialTransactions.
     *
     * @param financialTransactions the entity to update.
     * @return the persisted entity.
     */
    FinancialTransactions update(FinancialTransactions financialTransactions);

    /**
     * Partially updates a financialTransactions.
     *
     * @param financialTransactions the entity to update partially.
     * @return the persisted entity.
     */
    Optional<FinancialTransactions> partialUpdate(FinancialTransactions financialTransactions);

    /**
     * Get all the financialTransactions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<FinancialTransactions> findAll(Pageable pageable);

    /**
     * Get the "id" financialTransactions.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FinancialTransactions> findOne(Integer id);

    /**
     * Delete the "id" financialTransactions.
     *
     * @param id the id of the entity.
     */
    void delete(Integer id);
}
