package com.sbm.mc.service;

import com.sbm.mc.domain.Name;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.Name}.
 */
public interface NameService {
    /**
     * Save a name.
     *
     * @param name the entity to save.
     * @return the persisted entity.
     */
    Name save(Name name);

    /**
     * Updates a name.
     *
     * @param name the entity to update.
     * @return the persisted entity.
     */
    Name update(Name name);

    /**
     * Partially updates a name.
     *
     * @param name the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Name> partialUpdate(Name name);

    /**
     * Get all the names.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Name> findAll(Pageable pageable);

    /**
     * Get the "id" name.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Name> findOne(Integer id);

    /**
     * Delete the "id" name.
     *
     * @param id the id of the entity.
     */
    void delete(Integer id);
}
