package com.sbm.mc.service;

import com.sbm.mc.domain.ResortRoomCategory;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.ResortRoomCategory}.
 */
public interface ResortRoomCategoryService {
    /**
     * Save a resortRoomCategory.
     *
     * @param resortRoomCategory the entity to save.
     * @return the persisted entity.
     */
    ResortRoomCategory save(ResortRoomCategory resortRoomCategory);

    /**
     * Updates a resortRoomCategory.
     *
     * @param resortRoomCategory the entity to update.
     * @return the persisted entity.
     */
    ResortRoomCategory update(ResortRoomCategory resortRoomCategory);

    /**
     * Partially updates a resortRoomCategory.
     *
     * @param resortRoomCategory the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ResortRoomCategory> partialUpdate(ResortRoomCategory resortRoomCategory);

    /**
     * Get all the resortRoomCategories.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ResortRoomCategory> findAll(Pageable pageable);

    /**
     * Get the "id" resortRoomCategory.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ResortRoomCategory> findOne(Long id);

    /**
     * Delete the "id" resortRoomCategory.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
