package com.sbm.mc.service;

import com.sbm.mc.domain.ReservationDailyElementName;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.ReservationDailyElementName}.
 */
public interface ReservationDailyElementNameService {
    /**
     * Save a reservationDailyElementName.
     *
     * @param reservationDailyElementName the entity to save.
     * @return the persisted entity.
     */
    ReservationDailyElementName save(ReservationDailyElementName reservationDailyElementName);

    /**
     * Updates a reservationDailyElementName.
     *
     * @param reservationDailyElementName the entity to update.
     * @return the persisted entity.
     */
    ReservationDailyElementName update(ReservationDailyElementName reservationDailyElementName);

    /**
     * Partially updates a reservationDailyElementName.
     *
     * @param reservationDailyElementName the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ReservationDailyElementName> partialUpdate(ReservationDailyElementName reservationDailyElementName);

    /**
     * Get all the reservationDailyElementNames.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ReservationDailyElementName> findAll(Pageable pageable);

    /**
     * Get the "id" reservationDailyElementName.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReservationDailyElementName> findOne(Long id);

    /**
     * Delete the "id" reservationDailyElementName.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
