package com.sbm.mc.web.rest;

import com.sbm.mc.domain.NameAddress;
import com.sbm.mc.repository.NameAddressRepository;
import com.sbm.mc.service.NameAddressService;
import com.sbm.mc.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.sbm.mc.domain.NameAddress}.
 */
@RestController
@RequestMapping("/api/name-addresses")
public class NameAddressResource {

    private final Logger log = LoggerFactory.getLogger(NameAddressResource.class);

    private static final String ENTITY_NAME = "nameAddress";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NameAddressService nameAddressService;

    private final NameAddressRepository nameAddressRepository;

    public NameAddressResource(NameAddressService nameAddressService, NameAddressRepository nameAddressRepository) {
        this.nameAddressService = nameAddressService;
        this.nameAddressRepository = nameAddressRepository;
    }

    /**
     * {@code POST  /name-addresses} : Create a new nameAddress.
     *
     * @param nameAddress the nameAddress to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new nameAddress, or with status {@code 400 (Bad Request)} if the nameAddress has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<NameAddress> createNameAddress(@RequestBody NameAddress nameAddress) throws URISyntaxException {
        log.debug("REST request to save NameAddress : {}", nameAddress);
        if (nameAddress.getId() != null) {
            throw new BadRequestAlertException("A new nameAddress cannot already have an ID", ENTITY_NAME, "idexists");
        }
        nameAddress = nameAddressService.save(nameAddress);
        return ResponseEntity.created(new URI("/api/name-addresses/" + nameAddress.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, nameAddress.getId().toString()))
            .body(nameAddress);
    }

    /**
     * {@code PUT  /name-addresses/:id} : Updates an existing nameAddress.
     *
     * @param id the id of the nameAddress to save.
     * @param nameAddress the nameAddress to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated nameAddress,
     * or with status {@code 400 (Bad Request)} if the nameAddress is not valid,
     * or with status {@code 500 (Internal Server Error)} if the nameAddress couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<NameAddress> updateNameAddress(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody NameAddress nameAddress
    ) throws URISyntaxException {
        log.debug("REST request to update NameAddress : {}, {}", id, nameAddress);
        if (nameAddress.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, nameAddress.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!nameAddressRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        nameAddress = nameAddressService.update(nameAddress);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, nameAddress.getId().toString()))
            .body(nameAddress);
    }

    /**
     * {@code PATCH  /name-addresses/:id} : Partial updates given fields of an existing nameAddress, field will ignore if it is null
     *
     * @param id the id of the nameAddress to save.
     * @param nameAddress the nameAddress to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated nameAddress,
     * or with status {@code 400 (Bad Request)} if the nameAddress is not valid,
     * or with status {@code 404 (Not Found)} if the nameAddress is not found,
     * or with status {@code 500 (Internal Server Error)} if the nameAddress couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<NameAddress> partialUpdateNameAddress(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody NameAddress nameAddress
    ) throws URISyntaxException {
        log.debug("REST request to partial update NameAddress partially : {}, {}", id, nameAddress);
        if (nameAddress.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, nameAddress.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!nameAddressRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<NameAddress> result = nameAddressService.partialUpdate(nameAddress);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, nameAddress.getId().toString())
        );
    }

    /**
     * {@code GET  /name-addresses} : get all the nameAddresses.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of nameAddresses in body.
     */
    @GetMapping("")
    public ResponseEntity<List<NameAddress>> getAllNameAddresses(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of NameAddresses");
        Page<NameAddress> page = nameAddressService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /name-addresses/:id} : get the "id" nameAddress.
     *
     * @param id the id of the nameAddress to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the nameAddress, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<NameAddress> getNameAddress(@PathVariable("id") Integer id) {
        log.debug("REST request to get NameAddress : {}", id);
        Optional<NameAddress> nameAddress = nameAddressService.findOne(id);
        return ResponseUtil.wrapOrNotFound(nameAddress);
    }

    /**
     * {@code DELETE  /name-addresses/:id} : delete the "id" nameAddress.
     *
     * @param id the id of the nameAddress to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNameAddress(@PathVariable("id") Integer id) {
        log.debug("REST request to delete NameAddress : {}", id);
        nameAddressService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
