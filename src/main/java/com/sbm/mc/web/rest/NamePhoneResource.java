package com.sbm.mc.web.rest;

import com.sbm.mc.domain.NamePhone;
import com.sbm.mc.repository.NamePhoneRepository;
import com.sbm.mc.service.NamePhoneService;
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
 * REST controller for managing {@link com.sbm.mc.domain.NamePhone}.
 */
@RestController
@RequestMapping("/api/name-phones")
public class NamePhoneResource {

    private final Logger log = LoggerFactory.getLogger(NamePhoneResource.class);

    private static final String ENTITY_NAME = "namePhone";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NamePhoneService namePhoneService;

    private final NamePhoneRepository namePhoneRepository;

    public NamePhoneResource(NamePhoneService namePhoneService, NamePhoneRepository namePhoneRepository) {
        this.namePhoneService = namePhoneService;
        this.namePhoneRepository = namePhoneRepository;
    }

    /**
     * {@code POST  /name-phones} : Create a new namePhone.
     *
     * @param namePhone the namePhone to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new namePhone, or with status {@code 400 (Bad Request)} if the namePhone has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<NamePhone> createNamePhone(@RequestBody NamePhone namePhone) throws URISyntaxException {
        log.debug("REST request to save NamePhone : {}", namePhone);
        if (namePhone.getId() != null) {
            throw new BadRequestAlertException("A new namePhone cannot already have an ID", ENTITY_NAME, "idexists");
        }
        namePhone = namePhoneService.save(namePhone);
        return ResponseEntity.created(new URI("/api/name-phones/" + namePhone.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, namePhone.getId().toString()))
            .body(namePhone);
    }

    /**
     * {@code PUT  /name-phones/:id} : Updates an existing namePhone.
     *
     * @param id the id of the namePhone to save.
     * @param namePhone the namePhone to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated namePhone,
     * or with status {@code 400 (Bad Request)} if the namePhone is not valid,
     * or with status {@code 500 (Internal Server Error)} if the namePhone couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<NamePhone> updateNamePhone(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody NamePhone namePhone
    ) throws URISyntaxException {
        log.debug("REST request to update NamePhone : {}, {}", id, namePhone);
        if (namePhone.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, namePhone.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!namePhoneRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        namePhone = namePhoneService.update(namePhone);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, namePhone.getId().toString()))
            .body(namePhone);
    }

    /**
     * {@code PATCH  /name-phones/:id} : Partial updates given fields of an existing namePhone, field will ignore if it is null
     *
     * @param id the id of the namePhone to save.
     * @param namePhone the namePhone to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated namePhone,
     * or with status {@code 400 (Bad Request)} if the namePhone is not valid,
     * or with status {@code 404 (Not Found)} if the namePhone is not found,
     * or with status {@code 500 (Internal Server Error)} if the namePhone couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<NamePhone> partialUpdateNamePhone(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody NamePhone namePhone
    ) throws URISyntaxException {
        log.debug("REST request to partial update NamePhone partially : {}, {}", id, namePhone);
        if (namePhone.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, namePhone.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!namePhoneRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<NamePhone> result = namePhoneService.partialUpdate(namePhone);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, namePhone.getId().toString())
        );
    }

    /**
     * {@code GET  /name-phones} : get all the namePhones.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of namePhones in body.
     */
    @GetMapping("")
    public ResponseEntity<List<NamePhone>> getAllNamePhones(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of NamePhones");
        Page<NamePhone> page = namePhoneService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /name-phones/:id} : get the "id" namePhone.
     *
     * @param id the id of the namePhone to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the namePhone, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<NamePhone> getNamePhone(@PathVariable("id") Integer id) {
        log.debug("REST request to get NamePhone : {}", id);
        Optional<NamePhone> namePhone = namePhoneService.findOne(id);
        return ResponseUtil.wrapOrNotFound(namePhone);
    }

    /**
     * {@code DELETE  /name-phones/:id} : delete the "id" namePhone.
     *
     * @param id the id of the namePhone to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNamePhone(@PathVariable("id") Integer id) {
        log.debug("REST request to delete NamePhone : {}", id);
        namePhoneService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
