package com.sbm.mc.web.rest;

import com.sbm.mc.domain.Name;
import com.sbm.mc.repository.NameRepository;
import com.sbm.mc.service.NameService;
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
 * REST controller for managing {@link com.sbm.mc.domain.Name}.
 */
@RestController
@RequestMapping("/api/names")
public class NameResource {

    private final Logger log = LoggerFactory.getLogger(NameResource.class);

    private static final String ENTITY_NAME = "name";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NameService nameService;

    private final NameRepository nameRepository;

    public NameResource(NameService nameService, NameRepository nameRepository) {
        this.nameService = nameService;
        this.nameRepository = nameRepository;
    }

    /**
     * {@code POST  /names} : Create a new name.
     *
     * @param name the name to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new name, or with status {@code 400 (Bad Request)} if the name has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<Name> createName(@RequestBody Name name) throws URISyntaxException {
        log.debug("REST request to save Name : {}", name);
        if (name.getId() != null) {
            throw new BadRequestAlertException("A new name cannot already have an ID", ENTITY_NAME, "idexists");
        }
        name = nameService.save(name);
        return ResponseEntity.created(new URI("/api/names/" + name.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, name.getId().toString()))
            .body(name);
    }

    /**
     * {@code PUT  /names/:id} : Updates an existing name.
     *
     * @param id the id of the name to save.
     * @param name the name to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated name,
     * or with status {@code 400 (Bad Request)} if the name is not valid,
     * or with status {@code 500 (Internal Server Error)} if the name couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Name> updateName(@PathVariable(value = "id", required = false) final Integer id, @RequestBody Name name)
        throws URISyntaxException {
        log.debug("REST request to update Name : {}, {}", id, name);
        if (name.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, name.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!nameRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        name = nameService.update(name);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, name.getId().toString()))
            .body(name);
    }

    /**
     * {@code PATCH  /names/:id} : Partial updates given fields of an existing name, field will ignore if it is null
     *
     * @param id the id of the name to save.
     * @param name the name to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated name,
     * or with status {@code 400 (Bad Request)} if the name is not valid,
     * or with status {@code 404 (Not Found)} if the name is not found,
     * or with status {@code 500 (Internal Server Error)} if the name couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<Name> partialUpdateName(@PathVariable(value = "id", required = false) final Integer id, @RequestBody Name name)
        throws URISyntaxException {
        log.debug("REST request to partial update Name partially : {}, {}", id, name);
        if (name.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, name.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!nameRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<Name> result = nameService.partialUpdate(name);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, name.getId().toString())
        );
    }

    /**
     * {@code GET  /names} : get all the names.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of names in body.
     */
    @GetMapping("")
    public ResponseEntity<List<Name>> getAllNames(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of Names");
        Page<Name> page = nameService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /names/:id} : get the "id" name.
     *
     * @param id the id of the name to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the name, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Name> getName(@PathVariable("id") Integer id) {
        log.debug("REST request to get Name : {}", id);
        Optional<Name> name = nameService.findOne(id);
        return ResponseUtil.wrapOrNotFound(name);
    }

    /**
     * {@code DELETE  /names/:id} : delete the "id" name.
     *
     * @param id the id of the name to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteName(@PathVariable("id") Integer id) {
        log.debug("REST request to delete Name : {}", id);
        nameService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
