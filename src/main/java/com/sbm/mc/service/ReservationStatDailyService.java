package com.sbm.mc.service;

import com.sbm.mc.domain.ReservationStatDaily;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.ReservationStatDaily}.
 */
public interface ReservationStatDailyService {
    /**
     * Save a reservationStatDaily.
     *
     * @param reservationStatDaily the entity to save.
     * @return the persisted entity.
     */
    ReservationStatDaily save(ReservationStatDaily reservationStatDaily);

    /**
     * Updates a reservationStatDaily.
     *
     * @param reservationStatDaily the entity to update.
     * @return the persisted entity.
     */
    ReservationStatDaily update(ReservationStatDaily reservationStatDaily);

    /**
     * Partially updates a reservationStatDaily.
     *
     * @param reservationStatDaily the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ReservationStatDaily> partialUpdate(ReservationStatDaily reservationStatDaily);

    /**
     * Get all the reservationStatDailies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ReservationStatDaily> findAll(Pageable pageable);

    /**
     * Get the "id" reservationStatDaily.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReservationStatDaily> findOne(Long id);

    /**
     * Delete the "id" reservationStatDaily.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
