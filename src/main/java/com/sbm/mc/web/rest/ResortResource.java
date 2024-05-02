package com.sbm.mc.web.rest;

import com.sbm.mc.domain.Resort;
import com.sbm.mc.repository.ResortRepository;
import com.sbm.mc.service.ResortService;
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
 * REST controller for managing {@link com.sbm.mc.domain.Resort}.
 */
@RestController
@RequestMapping("/api/resorts")
public class ResortResource {

    private final Logger log = LoggerFactory.getLogger(ResortResource.class);

    private static final String ENTITY_NAME = "resort";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ResortService resortService;

    private final ResortRepository resortRepository;

    public ResortResource(ResortService resortService, ResortRepository resortRepository) {
        this.resortService = resortService;
        this.resortRepository = resortRepository;
    }

    /**
     * {@code POST  /resorts} : Create a new resort.
     *
     * @param resort the resort to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new resort, or with status {@code 400 (Bad Request)} if the resort has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<Resort> createResort(@RequestBody Resort resort) throws URISyntaxException {
        log.debug("REST request to save Resort : {}", resort);
        if (resort.getId() != null) {
            throw new BadRequestAlertException("A new resort cannot already have an ID", ENTITY_NAME, "idexists");
        }
        resort = resortService.save(resort);
        return ResponseEntity.created(new URI("/api/resorts/" + resort.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, resort.getId()))
            .body(resort);
    }

    /**
     * {@code PUT  /resorts/:id} : Updates an existing resort.
     *
     * @param id the id of the resort to save.
     * @param resort the resort to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resort,
     * or with status {@code 400 (Bad Request)} if the resort is not valid,
     * or with status {@code 500 (Internal Server Error)} if the resort couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Resort> updateResort(@PathVariable(value = "id", required = false) final String id, @RequestBody Resort resort)
        throws URISyntaxException {
        log.debug("REST request to update Resort : {}, {}", id, resort);
        if (resort.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resort.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resortRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        resort = resortService.update(resort);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resort.getId()))
            .body(resort);
    }

    /**
     * {@code PATCH  /resorts/:id} : Partial updates given fields of an existing resort, field will ignore if it is null
     *
     * @param id the id of the resort to save.
     * @param resort the resort to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resort,
     * or with status {@code 400 (Bad Request)} if the resort is not valid,
     * or with status {@code 404 (Not Found)} if the resort is not found,
     * or with status {@code 500 (Internal Server Error)} if the resort couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Resort> partialUpdateResort(
        @PathVariable(value = "id", required = false) final String id,
        @RequestBody Resort resort
    ) throws URISyntaxException {
        log.debug("REST request to partial update Resort partially : {}, {}", id, resort);
        if (resort.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resort.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resortRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Resort> result = resortService.partialUpdate(resort);

        return ResponseUtil.wrapOrNotFound(result, HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resort.getId()));
    }

    /**
     * {@code GET  /resorts} : get all the resorts.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of resorts in body.
     */
    @GetMapping("")
    public ResponseEntity<List<Resort>> getAllResorts(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of Resorts");
        Page<Resort> page = resortService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /resorts/:id} : get the "id" resort.
     *
     * @param id the id of the resort to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the resort, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Resort> getResort(@PathVariable("id") String id) {
        log.debug("REST request to get Resort : {}", id);
        Optional<Resort> resort = resortService.findOne(id);
        return ResponseUtil.wrapOrNotFound(resort);
    }

    /**
     * {@code DELETE  /resorts/:id} : delete the "id" resort.
     *
     * @param id the id of the resort to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResort(@PathVariable("id") String id) {
        log.debug("REST request to delete Resort : {}", id);
        resortService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
