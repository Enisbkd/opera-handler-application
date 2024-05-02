package com.sbm.mc.web.rest;

import com.sbm.mc.domain.ReservationDailyElements;
import com.sbm.mc.repository.ReservationDailyElementsRepository;
import com.sbm.mc.service.ReservationDailyElementsService;
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
 * REST controller for managing {@link com.sbm.mc.domain.ReservationDailyElements}.
 */
@RestController
@RequestMapping("/api/reservation-daily-elements")
public class ReservationDailyElementsResource {

    private final Logger log = LoggerFactory.getLogger(ReservationDailyElementsResource.class);

    private static final String ENTITY_NAME = "reservationDailyElements";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReservationDailyElementsService reservationDailyElementsService;

    private final ReservationDailyElementsRepository reservationDailyElementsRepository;

    public ReservationDailyElementsResource(
        ReservationDailyElementsService reservationDailyElementsService,
        ReservationDailyElementsRepository reservationDailyElementsRepository
    ) {
        this.reservationDailyElementsService = reservationDailyElementsService;
        this.reservationDailyElementsRepository = reservationDailyElementsRepository;
    }

    /**
     * {@code POST  /reservation-daily-elements} : Create a new reservationDailyElements.
     *
     * @param reservationDailyElements the reservationDailyElements to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reservationDailyElements, or with status {@code 400 (Bad Request)} if the reservationDailyElements has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ReservationDailyElements> createReservationDailyElements(
        @RequestBody ReservationDailyElements reservationDailyElements
    ) throws URISyntaxException {
        log.debug("REST request to save ReservationDailyElements : {}", reservationDailyElements);
        if (reservationDailyElements.getId() != null) {
            throw new BadRequestAlertException("A new reservationDailyElements cannot already have an ID", ENTITY_NAME, "idexists");
        }
        reservationDailyElements = reservationDailyElementsService.save(reservationDailyElements);
        return ResponseEntity.created(new URI("/api/reservation-daily-elements/" + reservationDailyElements.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, reservationDailyElements.getId().toString()))
            .body(reservationDailyElements);
    }

    /**
     * {@code PUT  /reservation-daily-elements/:id} : Updates an existing reservationDailyElements.
     *
     * @param id the id of the reservationDailyElements to save.
     * @param reservationDailyElements the reservationDailyElements to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reservationDailyElements,
     * or with status {@code 400 (Bad Request)} if the reservationDailyElements is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reservationDailyElements couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReservationDailyElements> updateReservationDailyElements(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ReservationDailyElements reservationDailyElements
    ) throws URISyntaxException {
        log.debug("REST request to update ReservationDailyElements : {}, {}", id, reservationDailyElements);
        if (reservationDailyElements.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reservationDailyElements.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!reservationDailyElementsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        reservationDailyElements = reservationDailyElementsService.update(reservationDailyElements);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reservationDailyElements.getId().toString()))
            .body(reservationDailyElements);
    }

    /**
     * {@code PATCH  /reservation-daily-elements/:id} : Partial updates given fields of an existing reservationDailyElements, field will ignore if it is null
     *
     * @param id the id of the reservationDailyElements to save.
     * @param reservationDailyElements the reservationDailyElements to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reservationDailyElements,
     * or with status {@code 400 (Bad Request)} if the reservationDailyElements is not valid,
     * or with status {@code 404 (Not Found)} if the reservationDailyElements is not found,
     * or with status {@code 500 (Internal Server Error)} if the reservationDailyElements couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ReservationDailyElements> partialUpdateReservationDailyElements(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ReservationDailyElements reservationDailyElements
    ) throws URISyntaxException {
        log.debug("REST request to partial update ReservationDailyElements partially : {}, {}", id, reservationDailyElements);
        if (reservationDailyElements.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reservationDailyElements.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!reservationDailyElementsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ReservationDailyElements> result = reservationDailyElementsService.partialUpdate(reservationDailyElements);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reservationDailyElements.getId().toString())
        );
    }

    /**
     * {@code GET  /reservation-daily-elements} : get all the reservationDailyElements.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reservationDailyElements in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ReservationDailyElements>> getAllReservationDailyElements(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of ReservationDailyElements");
        Page<ReservationDailyElements> page = reservationDailyElementsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /reservation-daily-elements/:id} : get the "id" reservationDailyElements.
     *
     * @param id the id of the reservationDailyElements to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reservationDailyElements, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDailyElements> getReservationDailyElements(@PathVariable("id") Long id) {
        log.debug("REST request to get ReservationDailyElements : {}", id);
        Optional<ReservationDailyElements> reservationDailyElements = reservationDailyElementsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reservationDailyElements);
    }

    /**
     * {@code DELETE  /reservation-daily-elements/:id} : delete the "id" reservationDailyElements.
     *
     * @param id the id of the reservationDailyElements to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationDailyElements(@PathVariable("id") Long id) {
        log.debug("REST request to delete ReservationDailyElements : {}", id);
        reservationDailyElementsService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
