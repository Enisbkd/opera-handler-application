package com.sbm.mc.service;

import com.sbm.mc.domain.ReservationName;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.ReservationName}.
 */
public interface ReservationNameService {
    /**
     * Save a reservationName.
     *
     * @param reservationName the entity to save.
     * @return the persisted entity.
     */
    ReservationName save(ReservationName reservationName);

    /**
     * Updates a reservationName.
     *
     * @param reservationName the entity to update.
     * @return the persisted entity.
     */
    ReservationName update(ReservationName reservationName);

    /**
     * Partially updates a reservationName.
     *
     * @param reservationName the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ReservationName> partialUpdate(ReservationName reservationName);

    /**
     * Get all the reservationNames.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ReservationName> findAll(Pageable pageable);

    /**
     * Get the "id" reservationName.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReservationName> findOne(Long id);

    /**
     * Delete the "id" reservationName.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
