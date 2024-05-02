package com.sbm.mc.web.rest;

import com.sbm.mc.domain.FinancialTransactions;
import com.sbm.mc.repository.FinancialTransactionsRepository;
import com.sbm.mc.service.FinancialTransactionsService;
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
 * REST controller for managing {@link com.sbm.mc.domain.FinancialTransactions}.
 */
@RestController
@RequestMapping("/api/financial-transactions")
public class FinancialTransactionsResource {

    private final Logger log = LoggerFactory.getLogger(FinancialTransactionsResource.class);

    private static final String ENTITY_NAME = "financialTransactions";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FinancialTransactionsService financialTransactionsService;

    private final FinancialTransactionsRepository financialTransactionsRepository;

    public FinancialTransactionsResource(
        FinancialTransactionsService financialTransactionsService,
        FinancialTransactionsRepository financialTransactionsRepository
    ) {
        this.financialTransactionsService = financialTransactionsService;
        this.financialTransactionsRepository = financialTransactionsRepository;
    }

    /**
     * {@code POST  /financial-transactions} : Create a new financialTransactions.
     *
     * @param financialTransactions the financialTransactions to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new financialTransactions, or with status {@code 400 (Bad Request)} if the financialTransactions has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<FinancialTransactions> createFinancialTransactions(@RequestBody FinancialTransactions financialTransactions)
        throws URISyntaxException {
        log.debug("REST request to save FinancialTransactions : {}", financialTransactions);
        if (financialTransactions.getId() != null) {
            throw new BadRequestAlertException("A new financialTransactions cannot already have an ID", ENTITY_NAME, "idexists");
        }
        financialTransactions = financialTransactionsService.save(financialTransactions);
        return ResponseEntity.created(new URI("/api/financial-transactions/" + financialTransactions.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, financialTransactions.getId().toString()))
            .body(financialTransactions);
    }

    /**
     * {@code PUT  /financial-transactions/:id} : Updates an existing financialTransactions.
     *
     * @param id the id of the financialTransactions to save.
     * @param financialTransactions the financialTransactions to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated financialTransactions,
     * or with status {@code 400 (Bad Request)} if the financialTransactions is not valid,
     * or with status {@code 500 (Internal Server Error)} if the financialTransactions couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<FinancialTransactions> updateFinancialTransactions(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody FinancialTransactions financialTransactions
    ) throws URISyntaxException {
        log.debug("REST request to update FinancialTransactions : {}, {}", id, financialTransactions);
        if (financialTransactions.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, financialTransactions.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!financialTransactionsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        financialTransactions = financialTransactionsService.update(financialTransactions);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, financialTransactions.getId().toString()))
            .body(financialTransactions);
    }

    /**
     * {@code PATCH  /financial-transactions/:id} : Partial updates given fields of an existing financialTransactions, field will ignore if it is null
     *
     * @param id the id of the financialTransactions to save.
     * @param financialTransactions the financialTransactions to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated financialTransactions,
     * or with status {@code 400 (Bad Request)} if the financialTransactions is not valid,
     * or with status {@code 404 (Not Found)} if the financialTransactions is not found,
     * or with status {@code 500 (Internal Server Error)} if the financialTransactions couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<FinancialTransactions> partialUpdateFinancialTransactions(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody FinancialTransactions financialTransactions
    ) throws URISyntaxException {
        log.debug("REST request to partial update FinancialTransactions partially : {}, {}", id, financialTransactions);
        if (financialTransactions.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, financialTransactions.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!financialTransactionsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<FinancialTransactions> result = financialTransactionsService.partialUpdate(financialTransactions);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, financialTransactions.getId().toString())
        );
    }

    /**
     * {@code GET  /financial-transactions} : get all the financialTransactions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of financialTransactions in body.
     */
    @GetMapping("")
    public ResponseEntity<List<FinancialTransactions>> getAllFinancialTransactions(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of FinancialTransactions");
        Page<FinancialTransactions> page = financialTransactionsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /financial-transactions/:id} : get the "id" financialTransactions.
     *
     * @param id the id of the financialTransactions to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the financialTransactions, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<FinancialTransactions> getFinancialTransactions(@PathVariable("id") Integer id) {
        log.debug("REST request to get FinancialTransactions : {}", id);
        Optional<FinancialTransactions> financialTransactions = financialTransactionsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(financialTransactions);
    }

    /**
     * {@code DELETE  /financial-transactions/:id} : delete the "id" financialTransactions.
     *
     * @param id the id of the financialTransactions to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinancialTransactions(@PathVariable("id") Integer id) {
        log.debug("REST request to delete FinancialTransactions : {}", id);
        financialTransactionsService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
