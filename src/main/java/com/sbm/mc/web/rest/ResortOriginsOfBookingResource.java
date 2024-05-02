package com.sbm.mc.web.rest;

import com.sbm.mc.domain.ResortOriginsOfBooking;
import com.sbm.mc.repository.ResortOriginsOfBookingRepository;
import com.sbm.mc.service.ResortOriginsOfBookingService;
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
 * REST controller for managing {@link com.sbm.mc.domain.ResortOriginsOfBooking}.
 */
@RestController
@RequestMapping("/api/resort-origins-of-bookings")
public class ResortOriginsOfBookingResource {

    private final Logger log = LoggerFactory.getLogger(ResortOriginsOfBookingResource.class);

    private static final String ENTITY_NAME = "resortOriginsOfBooking";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ResortOriginsOfBookingService resortOriginsOfBookingService;

    private final ResortOriginsOfBookingRepository resortOriginsOfBookingRepository;

    public ResortOriginsOfBookingResource(
        ResortOriginsOfBookingService resortOriginsOfBookingService,
        ResortOriginsOfBookingRepository resortOriginsOfBookingRepository
    ) {
        this.resortOriginsOfBookingService = resortOriginsOfBookingService;
        this.resortOriginsOfBookingRepository = resortOriginsOfBookingRepository;
    }

    /**
     * {@code POST  /resort-origins-of-bookings} : Create a new resortOriginsOfBooking.
     *
     * @param resortOriginsOfBooking the resortOriginsOfBooking to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new resortOriginsOfBooking, or with status {@code 400 (Bad Request)} if the resortOriginsOfBooking has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ResortOriginsOfBooking> createResortOriginsOfBooking(@RequestBody ResortOriginsOfBooking resortOriginsOfBooking)
        throws URISyntaxException {
        log.debug("REST request to save ResortOriginsOfBooking : {}", resortOriginsOfBooking);
        if (resortOriginsOfBooking.getId() != null) {
            throw new BadRequestAlertException("A new resortOriginsOfBooking cannot already have an ID", ENTITY_NAME, "idexists");
        }
        resortOriginsOfBooking = resortOriginsOfBookingService.save(resortOriginsOfBooking);
        return ResponseEntity.created(new URI("/api/resort-origins-of-bookings/" + resortOriginsOfBooking.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, resortOriginsOfBooking.getId().toString()))
            .body(resortOriginsOfBooking);
    }

    /**
     * {@code PUT  /resort-origins-of-bookings/:id} : Updates an existing resortOriginsOfBooking.
     *
     * @param id the id of the resortOriginsOfBooking to save.
     * @param resortOriginsOfBooking the resortOriginsOfBooking to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resortOriginsOfBooking,
     * or with status {@code 400 (Bad Request)} if the resortOriginsOfBooking is not valid,
     * or with status {@code 500 (Internal Server Error)} if the resortOriginsOfBooking couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ResortOriginsOfBooking> updateResortOriginsOfBooking(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ResortOriginsOfBooking resortOriginsOfBooking
    ) throws URISyntaxException {
        log.debug("REST request to update ResortOriginsOfBooking : {}, {}", id, resortOriginsOfBooking);
        if (resortOriginsOfBooking.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resortOriginsOfBooking.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resortOriginsOfBookingRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        resortOriginsOfBooking = resortOriginsOfBookingService.update(resortOriginsOfBooking);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resortOriginsOfBooking.getId().toString()))
            .body(resortOriginsOfBooking);
    }

    /**
     * {@code PATCH  /resort-origins-of-bookings/:id} : Partial updates given fields of an existing resortOriginsOfBooking, field will ignore if it is null
     *
     * @param id the id of the resortOriginsOfBooking to save.
     * @param resortOriginsOfBooking the resortOriginsOfBooking to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resortOriginsOfBooking,
     * or with status {@code 400 (Bad Request)} if the resortOriginsOfBooking is not valid,
     * or with status {@code 404 (Not Found)} if the resortOriginsOfBooking is not found,
     * or with status {@code 500 (Internal Server Error)} if the resortOriginsOfBooking couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ResortOriginsOfBooking> partialUpdateResortOriginsOfBooking(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ResortOriginsOfBooking resortOriginsOfBooking
    ) throws URISyntaxException {
        log.debug("REST request to partial update ResortOriginsOfBooking partially : {}, {}", id, resortOriginsOfBooking);
        if (resortOriginsOfBooking.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resortOriginsOfBooking.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resortOriginsOfBookingRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ResortOriginsOfBooking> result = resortOriginsOfBookingService.partialUpdate(resortOriginsOfBooking);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resortOriginsOfBooking.getId().toString())
        );
    }

    /**
     * {@code GET  /resort-origins-of-bookings} : get all the resortOriginsOfBookings.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of resortOriginsOfBookings in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ResortOriginsOfBooking>> getAllResortOriginsOfBookings(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of ResortOriginsOfBookings");
        Page<ResortOriginsOfBooking> page = resortOriginsOfBookingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /resort-origins-of-bookings/:id} : get the "id" resortOriginsOfBooking.
     *
     * @param id the id of the resortOriginsOfBooking to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the resortOriginsOfBooking, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResortOriginsOfBooking> getResortOriginsOfBooking(@PathVariable("id") Long id) {
        log.debug("REST request to get ResortOriginsOfBooking : {}", id);
        Optional<ResortOriginsOfBooking> resortOriginsOfBooking = resortOriginsOfBookingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(resortOriginsOfBooking);
    }

    /**
     * {@code DELETE  /resort-origins-of-bookings/:id} : delete the "id" resortOriginsOfBooking.
     *
     * @param id the id of the resortOriginsOfBooking to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResortOriginsOfBooking(@PathVariable("id") Long id) {
        log.debug("REST request to delete ResortOriginsOfBooking : {}", id);
        resortOriginsOfBookingService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
