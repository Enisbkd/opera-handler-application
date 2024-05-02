package com.sbm.mc.web.rest;

import com.sbm.mc.domain.ReservationSummary;
import com.sbm.mc.repository.ReservationSummaryRepository;
import com.sbm.mc.service.ReservationSummaryService;
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
 * REST controller for managing {@link com.sbm.mc.domain.ReservationSummary}.
 */
@RestController
@RequestMapping("/api/reservation-summaries")
public class ReservationSummaryResource {

    private final Logger log = LoggerFactory.getLogger(ReservationSummaryResource.class);

    private static final String ENTITY_NAME = "reservationSummary";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReservationSummaryService reservationSummaryService;

    private final ReservationSummaryRepository reservationSummaryRepository;

    public ReservationSummaryResource(
        ReservationSummaryService reservationSummaryService,
        ReservationSummaryRepository reservationSummaryRepository
    ) {
        this.reservationSummaryService = reservationSummaryService;
        this.reservationSummaryRepository = reservationSummaryRepository;
    }

    /**
     * {@code POST  /reservation-summaries} : Create a new reservationSummary.
     *
     * @param reservationSummary the reservationSummary to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reservationSummary, or with status {@code 400 (Bad Request)} if the reservationSummary has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ReservationSummary> createReservationSummary(@RequestBody ReservationSummary reservationSummary)
        throws URISyntaxException {
        log.debug("REST request to save ReservationSummary : {}", reservationSummary);
        if (reservationSummary.getId() != null) {
            throw new BadRequestAlertException("A new reservationSummary cannot already have an ID", ENTITY_NAME, "idexists");
        }
        reservationSummary = reservationSummaryService.save(reservationSummary);
        return ResponseEntity.created(new URI("/api/reservation-summaries/" + reservationSummary.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, reservationSummary.getId().toString()))
            .body(reservationSummary);
    }

    /**
     * {@code PUT  /reservation-summaries/:id} : Updates an existing reservationSummary.
     *
     * @param id the id of the reservationSummary to save.
     * @param reservationSummary the reservationSummary to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reservationSummary,
     * or with status {@code 400 (Bad Request)} if the reservationSummary is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reservationSummary couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReservationSummary> updateReservationSummary(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody ReservationSummary reservationSummary
    ) throws URISyntaxException {
        log.debug("REST request to update ReservationSummary : {}, {}", id, reservationSummary);
        if (reservationSummary.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reservationSummary.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!reservationSummaryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        reservationSummary = reservationSummaryService.update(reservationSummary);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reservationSummary.getId().toString()))
            .body(reservationSummary);
    }

    /**
     * {@code PATCH  /reservation-summaries/:id} : Partial updates given fields of an existing reservationSummary, field will ignore if it is null
     *
     * @param id the id of the reservationSummary to save.
     * @param reservationSummary the reservationSummary to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reservationSummary,
     * or with status {@code 400 (Bad Request)} if the reservationSummary is not valid,
     * or with status {@code 404 (Not Found)} if the reservationSummary is not found,
     * or with status {@code 500 (Internal Server Error)} if the reservationSummary couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ReservationSummary> partialUpdateReservationSummary(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody ReservationSummary reservationSummary
    ) throws URISyntaxException {
        log.debug("REST request to partial update ReservationSummary partially : {}, {}", id, reservationSummary);
        if (reservationSummary.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reservationSummary.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!reservationSummaryRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ReservationSummary> result = reservationSummaryService.partialUpdate(reservationSummary);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reservationSummary.getId().toString())
        );
    }

    /**
     * {@code GET  /reservation-summaries} : get all the reservationSummaries.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reservationSummaries in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ReservationSummary>> getAllReservationSummaries(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of ReservationSummaries");
        Page<ReservationSummary> page = reservationSummaryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /reservation-summaries/:id} : get the "id" reservationSummary.
     *
     * @param id the id of the reservationSummary to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reservationSummary, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservationSummary> getReservationSummary(@PathVariable("id") Integer id) {
        log.debug("REST request to get ReservationSummary : {}", id);
        Optional<ReservationSummary> reservationSummary = reservationSummaryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reservationSummary);
    }

    /**
     * {@code DELETE  /reservation-summaries/:id} : delete the "id" reservationSummary.
     *
     * @param id the id of the reservationSummary to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationSummary(@PathVariable("id") Integer id) {
        log.debug("REST request to delete ReservationSummary : {}", id);
        reservationSummaryService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
