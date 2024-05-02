package com.sbm.mc.web.rest;

import com.sbm.mc.domain.ReservationStatDaily;
import com.sbm.mc.repository.ReservationStatDailyRepository;
import com.sbm.mc.service.ReservationStatDailyService;
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
 * REST controller for managing {@link com.sbm.mc.domain.ReservationStatDaily}.
 */
@RestController
@RequestMapping("/api/reservation-stat-dailies")
public class ReservationStatDailyResource {

    private final Logger log = LoggerFactory.getLogger(ReservationStatDailyResource.class);

    private static final String ENTITY_NAME = "reservationStatDaily";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReservationStatDailyService reservationStatDailyService;

    private final ReservationStatDailyRepository reservationStatDailyRepository;

    public ReservationStatDailyResource(
        ReservationStatDailyService reservationStatDailyService,
        ReservationStatDailyRepository reservationStatDailyRepository
    ) {
        this.reservationStatDailyService = reservationStatDailyService;
        this.reservationStatDailyRepository = reservationStatDailyRepository;
    }

    /**
     * {@code POST  /reservation-stat-dailies} : Create a new reservationStatDaily.
     *
     * @param reservationStatDaily the reservationStatDaily to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reservationStatDaily, or with status {@code 400 (Bad Request)} if the reservationStatDaily has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ReservationStatDaily> createReservationStatDaily(@RequestBody ReservationStatDaily reservationStatDaily)
        throws URISyntaxException {
        log.debug("REST request to save ReservationStatDaily : {}", reservationStatDaily);
        if (reservationStatDaily.getId() != null) {
            throw new BadRequestAlertException("A new reservationStatDaily cannot already have an ID", ENTITY_NAME, "idexists");
        }
        reservationStatDaily = reservationStatDailyService.save(reservationStatDaily);
        return ResponseEntity.created(new URI("/api/reservation-stat-dailies/" + reservationStatDaily.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, reservationStatDaily.getId().toString()))
            .body(reservationStatDaily);
    }

    /**
     * {@code PUT  /reservation-stat-dailies/:id} : Updates an existing reservationStatDaily.
     *
     * @param id the id of the reservationStatDaily to save.
     * @param reservationStatDaily the reservationStatDaily to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reservationStatDaily,
     * or with status {@code 400 (Bad Request)} if the reservationStatDaily is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reservationStatDaily couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReservationStatDaily> updateReservationStatDaily(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ReservationStatDaily reservationStatDaily
    ) throws URISyntaxException {
        log.debug("REST request to update ReservationStatDaily : {}, {}", id, reservationStatDaily);
        if (reservationStatDaily.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reservationStatDaily.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!reservationStatDailyRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        reservationStatDaily = reservationStatDailyService.update(reservationStatDaily);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reservationStatDaily.getId().toString()))
            .body(reservationStatDaily);
    }

    /**
     * {@code PATCH  /reservation-stat-dailies/:id} : Partial updates given fields of an existing reservationStatDaily, field will ignore if it is null
     *
     * @param id the id of the reservationStatDaily to save.
     * @param reservationStatDaily the reservationStatDaily to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reservationStatDaily,
     * or with status {@code 400 (Bad Request)} if the reservationStatDaily is not valid,
     * or with status {@code 404 (Not Found)} if the reservationStatDaily is not found,
     * or with status {@code 500 (Internal Server Error)} if the reservationStatDaily couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ReservationStatDaily> partialUpdateReservationStatDaily(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody ReservationStatDaily reservationStatDaily
    ) throws URISyntaxException {
        log.debug("REST request to partial update ReservationStatDaily partially : {}, {}", id, reservationStatDaily);
        if (reservationStatDaily.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, reservationStatDaily.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!reservationStatDailyRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ReservationStatDaily> result = reservationStatDailyService.partialUpdate(reservationStatDaily);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reservationStatDaily.getId().toString())
        );
    }

    /**
     * {@code GET  /reservation-stat-dailies} : get all the reservationStatDailies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reservationStatDailies in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ReservationStatDaily>> getAllReservationStatDailies(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of ReservationStatDailies");
        Page<ReservationStatDaily> page = reservationStatDailyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /reservation-stat-dailies/:id} : get the "id" reservationStatDaily.
     *
     * @param id the id of the reservationStatDaily to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reservationStatDaily, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservationStatDaily> getReservationStatDaily(@PathVariable("id") Long id) {
        log.debug("REST request to get ReservationStatDaily : {}", id);
        Optional<ReservationStatDaily> reservationStatDaily = reservationStatDailyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reservationStatDaily);
    }

    /**
     * {@code DELETE  /reservation-stat-dailies/:id} : delete the "id" reservationStatDaily.
     *
     * @param id the id of the reservationStatDaily to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationStatDaily(@PathVariable("id") Long id) {
        log.debug("REST request to delete ReservationStatDaily : {}", id);
        reservationStatDailyService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
