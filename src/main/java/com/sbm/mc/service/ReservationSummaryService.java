package com.sbm.mc.service;

import com.sbm.mc.domain.ReservationSummary;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.ReservationSummary}.
 */
public interface ReservationSummaryService {
    /**
     * Save a reservationSummary.
     *
     * @param reservationSummary the entity to save.
     * @return the persisted entity.
     */
    ReservationSummary save(ReservationSummary reservationSummary);

    /**
     * Updates a reservationSummary.
     *
     * @param reservationSummary the entity to update.
     * @return the persisted entity.
     */
    ReservationSummary update(ReservationSummary reservationSummary);

    /**
     * Partially updates a reservationSummary.
     *
     * @param reservationSummary the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ReservationSummary> partialUpdate(ReservationSummary reservationSummary);

    /**
     * Get all the reservationSummaries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ReservationSummary> findAll(Pageable pageable);

    /**
     * Get the "id" reservationSummary.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReservationSummary> findOne(Integer id);

    /**
     * Delete the "id" reservationSummary.
     *
     * @param id the id of the entity.
     */
    void delete(Integer id);
}
