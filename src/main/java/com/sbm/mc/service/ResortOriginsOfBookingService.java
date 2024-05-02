package com.sbm.mc.service;

import com.sbm.mc.domain.ResortOriginsOfBooking;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.ResortOriginsOfBooking}.
 */
public interface ResortOriginsOfBookingService {
    /**
     * Save a resortOriginsOfBooking.
     *
     * @param resortOriginsOfBooking the entity to save.
     * @return the persisted entity.
     */
    ResortOriginsOfBooking save(ResortOriginsOfBooking resortOriginsOfBooking);

    /**
     * Updates a resortOriginsOfBooking.
     *
     * @param resortOriginsOfBooking the entity to update.
     * @return the persisted entity.
     */
    ResortOriginsOfBooking update(ResortOriginsOfBooking resortOriginsOfBooking);

    /**
     * Partially updates a resortOriginsOfBooking.
     *
     * @param resortOriginsOfBooking the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ResortOriginsOfBooking> partialUpdate(ResortOriginsOfBooking resortOriginsOfBooking);

    /**
     * Get all the resortOriginsOfBookings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ResortOriginsOfBooking> findAll(Pageable pageable);

    /**
     * Get the "id" resortOriginsOfBooking.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ResortOriginsOfBooking> findOne(Long id);

    /**
     * Delete the "id" resortOriginsOfBooking.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
