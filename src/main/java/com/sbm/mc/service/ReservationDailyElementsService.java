package com.sbm.mc.service;

import com.sbm.mc.domain.ReservationDailyElements;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.ReservationDailyElements}.
 */
public interface ReservationDailyElementsService {
    /**
     * Save a reservationDailyElements.
     *
     * @param reservationDailyElements the entity to save.
     * @return the persisted entity.
     */
    ReservationDailyElements save(ReservationDailyElements reservationDailyElements);

    /**
     * Updates a reservationDailyElements.
     *
     * @param reservationDailyElements the entity to update.
     * @return the persisted entity.
     */
    ReservationDailyElements update(ReservationDailyElements reservationDailyElements);

    /**
     * Partially updates a reservationDailyElements.
     *
     * @param reservationDailyElements the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ReservationDailyElements> partialUpdate(ReservationDailyElements reservationDailyElements);

    /**
     * Get all the reservationDailyElements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ReservationDailyElements> findAll(Pageable pageable);

    /**
     * Get the "id" reservationDailyElements.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReservationDailyElements> findOne(Long id);

    /**
     * Delete the "id" reservationDailyElements.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
