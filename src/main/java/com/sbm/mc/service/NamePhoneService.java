package com.sbm.mc.service;

import com.sbm.mc.domain.NamePhone;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.NamePhone}.
 */
public interface NamePhoneService {
    /**
     * Save a namePhone.
     *
     * @param namePhone the entity to save.
     * @return the persisted entity.
     */
    NamePhone save(NamePhone namePhone);

    /**
     * Updates a namePhone.
     *
     * @param namePhone the entity to update.
     * @return the persisted entity.
     */
    NamePhone update(NamePhone namePhone);

    /**
     * Partially updates a namePhone.
     *
     * @param namePhone the entity to update partially.
     * @return the persisted entity.
     */
    Optional<NamePhone> partialUpdate(NamePhone namePhone);

    /**
     * Get all the namePhones.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<NamePhone> findAll(Pageable pageable);

    /**
     * Get the "id" namePhone.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<NamePhone> findOne(Integer id);

    /**
     * Delete the "id" namePhone.
     *
     * @param id the id of the entity.
     */
    void delete(Integer id);
}
