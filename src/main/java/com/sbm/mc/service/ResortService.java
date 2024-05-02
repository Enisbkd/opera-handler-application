package com.sbm.mc.service;

import com.sbm.mc.domain.Resort;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.Resort}.
 */
public interface ResortService {
    /**
     * Save a resort.
     *
     * @param resort the entity to save.
     * @return the persisted entity.
     */
    Resort save(Resort resort);

    /**
     * Updates a resort.
     *
     * @param resort the entity to update.
     * @return the persisted entity.
     */
    Resort update(Resort resort);

    /**
     * Partially updates a resort.
     *
     * @param resort the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Resort> partialUpdate(Resort resort);

    /**
     * Get all the resorts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Resort> findAll(Pageable pageable);

    /**
     * Get the "id" resort.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Resort> findOne(String id);

    /**
     * Delete the "id" resort.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
