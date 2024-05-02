package com.sbm.mc.web.rest;

import com.sbm.mc.domain.ReservationDailyElementName;
import com.sbm.mc.repository.ReservationDailyElementNameRepository;
import com.sbm.mc.service.ReservationDailyElementNameService;
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
 * REST controller for managing {@link com.sbm.mc.domain.ReservationDailyElementName}.
 */
@RestController
@RequestMapping("/api/reservation-daily-element-names")
public class ReservationDailyElementNameResource {

    private final Logger log = LoggerFactory.getLogger(ReservationDailyElementNameResource.class);

    private static final String ENTITY_NAME = "reservationDailyElementName";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReservationDailyElementNameService reservationDailyElementNameService;

    private final ReservationDailyElementNameRepository reservationDailyElementNameRepository;

    public ReservationDailyElementNameResource(
        ReservationDailyElementNameService reservationDailyElementNameService,
        ReservationDailyElementNameRepository reservationDailyElementNameRepository
    ) {
        this.reservationDailyElementNameService = reservationDailyElementNameService;
        this.reservationDailyElementNameRepository = reservationDailyElementNameRepository;
    }

    /**
     * {@code POST  /reservation-daily-element-names} : Create a new reservationDailyElementName.
     *
     * @param reservationDailyElementName the reservationDailyElementName to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reservationDailyElementName, or with status {@code 400 (Bad Request)} if the reservationDailyElementName has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ReservationDailyElementName> createReservationDailyElementName(
        @RequestBody ReservationDailyElementName reservationDailyElementName
    ) throws URISyntaxException {
        log.debug("REST request to save ReservationDailyElementName : {}", reservationDailyElementName);
        if (reservationDailyElementName.getId() != null) {
            throw new BadRequestAlertException("A new reservationDailyElementName cannot already have an ID", ENTITY_NAME, "idexists");
        }
        reservationDailyElementName = reservationDailyElementNameService.save(reservationDailyElementName);
        return ResponseEntity.created(new URI("/api/reservation-daily-element-names/" + reservationDailyElementName.getId()))
            .headers(
                HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, reservationDailyElementName.getId().toString())
            )
            .body(reservationDailyElementName);
    }

    /**
     * {@code PUT  /reservation-daily-element-names/:id} : Updates an existing reservationDailyElementName.
     *
     * @param id the id of the reservationDailyElementName to save.
     * @param reservationDailyElementName the reservationDailyElementName to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reservationDailyElementName,
     * or with status {@code 400 (Bad Request)} if the reservationDailyElementName is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reservationDailyElementName couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReservationDailyElementName> updateReservationDailyElementName(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ReservationDailyElementName reservationDailyElementName
    ) throws URISyntaxException {
        log.debug("REST request to update ReservationDailyElementName : {}, {}", id, reservationDailyElementName);
        if (reservationDailyElementName.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reservationDailyElementName.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!reservationDailyElementNameRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        reservationDailyElementName = reservationDailyElementNameService.update(reservationDailyElementName);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reservationDailyElementName.getId().toString()))
            .body(reservationDailyElementName);
    }

    /**
     * {@code PATCH  /reservation-daily-element-names/:id} : Partial updates given fields of an existing reservationDailyElementName, field will ignore if it is null
     *
     * @param id the id of the reservationDailyElementName to save.
     * @param reservationDailyElementName the reservationDailyElementName to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reservationDailyElementName,
     * or with status {@code 400 (Bad Request)} if the reservationDailyElementName is not valid,
     * or with status {@code 404 (Not Found)} if the reservationDailyElementName is not found,
     * or with status {@code 500 (Internal Server Error)} if the reservationDailyElementName couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ReservationDailyElementName> partialUpdateReservationDailyElementName(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ReservationDailyElementName reservationDailyElementName
    ) throws URISyntaxException {
        log.debug("REST request to partial update ReservationDailyElementName partially : {}, {}", id, reservationDailyElementName);
        if (reservationDailyElementName.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reservationDailyElementName.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!reservationDailyElementNameRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ReservationDailyElementName> result = reservationDailyElementNameService.partialUpdate(reservationDailyElementName);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reservationDailyElementName.getId().toString())
        );
    }

    /**
     * {@code GET  /reservation-daily-element-names} : get all the reservationDailyElementNames.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reservationDailyElementNames in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ReservationDailyElementName>> getAllReservationDailyElementNames(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of ReservationDailyElementNames");
        Page<ReservationDailyElementName> page = reservationDailyElementNameService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /reservation-daily-element-names/:id} : get the "id" reservationDailyElementName.
     *
     * @param id the id of the reservationDailyElementName to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reservationDailyElementName, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDailyElementName> getReservationDailyElementName(@PathVariable("id") Long id) {
        log.debug("REST request to get ReservationDailyElementName : {}", id);
        Optional<ReservationDailyElementName> reservationDailyElementName = reservationDailyElementNameService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reservationDailyElementName);
    }

    /**
     * {@code DELETE  /reservation-daily-element-names/:id} : delete the "id" reservationDailyElementName.
     *
     * @param id the id of the reservationDailyElementName to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationDailyElementName(@PathVariable("id") Long id) {
        log.debug("REST request to delete ReservationDailyElementName : {}", id);
        reservationDailyElementNameService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
