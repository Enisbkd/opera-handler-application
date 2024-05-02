package com.sbm.mc.service;

import com.sbm.mc.domain.NameAddress;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.sbm.mc.domain.NameAddress}.
 */
public interface NameAddressService {
    /**
     * Save a nameAddress.
     *
     * @param nameAddress the entity to save.
     * @return the persisted entity.
     */
    NameAddress save(NameAddress nameAddress);

    /**
     * Updates a nameAddress.
     *
     * @param nameAddress the entity to update.
     * @return the persisted entity.
     */
    NameAddress update(NameAddress nameAddress);

    /**
     * Partially updates a nameAddress.
     *
     * @param nameAddress the entity to update partially.
     * @return the persisted entity.
     */
    Optional<NameAddress> partialUpdate(NameAddress nameAddress);

    /**
     * Get all the nameAddresses.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<NameAddress> findAll(Pageable pageable);

    /**
     * Get the "id" nameAddress.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<NameAddress> findOne(Integer id);

    /**
     * Delete the "id" nameAddress.
     *
     * @param id the id of the entity.
     */
    void delete(Integer id);
}
