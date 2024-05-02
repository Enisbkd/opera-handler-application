package com.sbm.mc.web.rest;

import com.sbm.mc.domain.ResortRoomCategory;
import com.sbm.mc.repository.ResortRoomCategoryRepository;
import com.sbm.mc.service.ResortRoomCategoryService;
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
 * REST controller for managing {@link com.sbm.mc.domain.ResortRoomCategory}.
 */
@RestController
@RequestMapping("/api/resort-room-categories")
public class ResortRoomCategoryResource {

    private final Logger log = LoggerFactory.getLogger(ResortRoomCategoryResource.class);

    private static final String ENTITY_NAME = "resortRoomCategory";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ResortRoomCategoryService resortRoomCategoryService;

    private final ResortRoomCategoryRepository resortRoomCategoryRepository;

    public ResortRoomCategoryResource(
        ResortRoomCategoryService resortRoomCategoryService,
        ResortRoomCategoryRepository resortRoomCategoryRepository
    ) {
        this.resortRoomCategoryService = resortRoomCategoryService;
        this.resortRoomCategoryRepository = resortRoomCategoryRepository;
    }

    /**
     * {@code POST  /resort-room-categories} : Create a new resortRoomCategory.
     *
     * @param resortRoomCategory the resortRoomCategory to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new resortRoomCategory, or with status {@code 400 (Bad Request)} if the resortRoomCategory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ResortRoomCategory> createResortRoomCategory(@RequestBody ResortRoomCategory resortRoomCategory)
        throws URISyntaxException {
        log.debug("REST request to save ResortRoomCategory : {}", resortRoomCategory);
        if (resortRoomCategory.getId() != null) {
            throw new BadRequestAlertException("A new resortRoomCategory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        resortRoomCategory = resortRoomCategoryService.save(resortRoomCategory);
        return ResponseEntity.created(new URI("/api/resort-room-categories/" + resortRoomCategory.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, resortRoomCategory.getId().toString()))
            .body(resortRoomCategory);
    }

    /**
     * {@code PUT  /resort-room-categories/:id} : Updates an existing resortRoomCategory.
     *
     * @param id the id of the resortRoomCategory to save.
     * @param resortRoomCategory the resortRoomCategory to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resortRoomCategory,
     * or with status {@code 400 (Bad Request)} if the resortRoomCategory is not valid,
     * or with status {@code 500 (Internal Server Error)} if the resortRoomCategory couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ResortRoomCategory> updateResortRoomCategory(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ResortRoomCategory resortRoomCategory
    ) throws URISyntaxException {
        log.debug("REST request to update ResortRoomCategory : {}, {}", id, resortRoomCategory);
        if (resortRoomCategory.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resortRoomCategory.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resortRoomCategoryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        resortRoomCategory = resortRoomCategoryService.update(resortRoomCategory);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resortRoomCategory.getId().toString()))
            .body(resortRoomCategory);
    }

    /**
     * {@code PATCH  /resort-room-categories/:id} : Partial updates given fields of an existing resortRoomCategory, field will ignore if it is null
     *
     * @param id the id of the resortRoomCategory to save.
     * @param resortRoomCategory the resortRoomCategory to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resortRoomCategory,
     * or with status {@code 400 (Bad Request)} if the resortRoomCategory is not valid,
     * or with status {@code 404 (Not Found)} if the resortRoomCategory is not found,
     * or with status {@code 500 (Internal Server Error)} if the resortRoomCategory couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ResortRoomCategory> partialUpdateResortRoomCategory(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ResortRoomCategory resortRoomCategory
    ) throws URISyntaxException {
        log.debug("REST request to partial update ResortRoomCategory partially : {}, {}", id, resortRoomCategory);
        if (resortRoomCategory.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resortRoomCategory.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resortRoomCategoryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ResortRoomCategory> result = resortRoomCategoryService.partialUpdate(resortRoomCategory);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resortRoomCategory.getId().toString())
        );
    }

    /**
     * {@code GET  /resort-room-categories} : get all the resortRoomCategories.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of resortRoomCategories in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ResortRoomCategory>> getAllResortRoomCategories(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of ResortRoomCategories");
        Page<ResortRoomCategory> page = resortRoomCategoryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /resort-room-categories/:id} : get the "id" resortRoomCategory.
     *
     * @param id the id of the resortRoomCategory to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the resortRoomCategory, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResortRoomCategory> getResortRoomCategory(@PathVariable("id") Long id) {
        log.debug("REST request to get ResortRoomCategory : {}", id);
        Optional<ResortRoomCategory> resortRoomCategory = resortRoomCategoryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(resortRoomCategory);
    }

    /**
     * {@code DELETE  /resort-room-categories/:id} : delete the "id" resortRoomCategory.
     *
     * @param id the id of the resortRoomCategory to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResortRoomCategory(@PathVariable("id") Long id) {
        log.debug("REST request to delete ResortRoomCategory : {}", id);
        resortRoomCategoryService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
