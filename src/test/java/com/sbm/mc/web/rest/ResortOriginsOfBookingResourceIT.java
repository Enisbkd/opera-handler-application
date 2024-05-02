package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.ResortOriginsOfBookingAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.ResortOriginsOfBooking;
import com.sbm.mc.repository.ResortOriginsOfBookingRepository;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link ResortOriginsOfBookingResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ResortOriginsOfBookingResourceIT {

    private static final String DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_RESORT = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_SOURCE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_SOURCE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_INACTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INACTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_SELL_SEQUENCE = 1;
    private static final Integer UPDATED_SELL_SEQUENCE = 2;

    private static final Integer DEFAULT_SC_ORDERBY = 1;
    private static final Integer UPDATED_SC_ORDERBY = 2;

    private static final String DEFAULT_INTERNET_SALES_YN = "AAAAAAAAAA";
    private static final String UPDATED_INTERNET_SALES_YN = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/resort-origins-of-bookings";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ResortOriginsOfBookingRepository resortOriginsOfBookingRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restResortOriginsOfBookingMockMvc;

    private ResortOriginsOfBooking resortOriginsOfBooking;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ResortOriginsOfBooking createEntity(EntityManager em) {
        ResortOriginsOfBooking resortOriginsOfBooking = new ResortOriginsOfBooking()
            .resort(DEFAULT_RESORT)
            .sourceCode(DEFAULT_SOURCE_CODE)
            .parentSourceCode(DEFAULT_PARENT_SOURCE_CODE)
            .description(DEFAULT_DESCRIPTION)
            .insertUser(DEFAULT_INSERT_USER)
            .insertDate(DEFAULT_INSERT_DATE)
            .updateUser(DEFAULT_UPDATE_USER)
            .updateDate(DEFAULT_UPDATE_DATE)
            .inactiveDate(DEFAULT_INACTIVE_DATE)
            .sellSequence(DEFAULT_SELL_SEQUENCE)
            .scOrderby(DEFAULT_SC_ORDERBY)
            .internetSalesYn(DEFAULT_INTERNET_SALES_YN);
        return resortOriginsOfBooking;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ResortOriginsOfBooking createUpdatedEntity(EntityManager em) {
        ResortOriginsOfBooking resortOriginsOfBooking = new ResortOriginsOfBooking()
            .resort(UPDATED_RESORT)
            .sourceCode(UPDATED_SOURCE_CODE)
            .parentSourceCode(UPDATED_PARENT_SOURCE_CODE)
            .description(UPDATED_DESCRIPTION)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .sellSequence(UPDATED_SELL_SEQUENCE)
            .scOrderby(UPDATED_SC_ORDERBY)
            .internetSalesYn(UPDATED_INTERNET_SALES_YN);
        return resortOriginsOfBooking;
    }

    @BeforeEach
    public void initTest() {
        resortOriginsOfBooking = createEntity(em);
    }

    @Test
    @Transactional
    void createResortOriginsOfBooking() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ResortOriginsOfBooking
        var returnedResortOriginsOfBooking = om.readValue(
            restResortOriginsOfBookingMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(resortOriginsOfBooking)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ResortOriginsOfBooking.class
        );

        // Validate the ResortOriginsOfBooking in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertResortOriginsOfBookingUpdatableFieldsEquals(
            returnedResortOriginsOfBooking,
            getPersistedResortOriginsOfBooking(returnedResortOriginsOfBooking)
        );
    }

    @Test
    @Transactional
    void createResortOriginsOfBookingWithExistingId() throws Exception {
        // Create the ResortOriginsOfBooking with an existing ID
        resortOriginsOfBooking.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restResortOriginsOfBookingMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(resortOriginsOfBooking)))
            .andExpect(status().isBadRequest());

        // Validate the ResortOriginsOfBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllResortOriginsOfBookings() throws Exception {
        // Initialize the database
        resortOriginsOfBookingRepository.saveAndFlush(resortOriginsOfBooking);

        // Get all the resortOriginsOfBookingList
        restResortOriginsOfBookingMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(resortOriginsOfBooking.getId().intValue())))
            .andExpect(jsonPath("$.[*].resort").value(hasItem(DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].sourceCode").value(hasItem(DEFAULT_SOURCE_CODE)))
            .andExpect(jsonPath("$.[*].parentSourceCode").value(hasItem(DEFAULT_PARENT_SOURCE_CODE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].inactiveDate").value(hasItem(DEFAULT_INACTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].sellSequence").value(hasItem(DEFAULT_SELL_SEQUENCE)))
            .andExpect(jsonPath("$.[*].scOrderby").value(hasItem(DEFAULT_SC_ORDERBY)))
            .andExpect(jsonPath("$.[*].internetSalesYn").value(hasItem(DEFAULT_INTERNET_SALES_YN)));
    }

    @Test
    @Transactional
    void getResortOriginsOfBooking() throws Exception {
        // Initialize the database
        resortOriginsOfBookingRepository.saveAndFlush(resortOriginsOfBooking);

        // Get the resortOriginsOfBooking
        restResortOriginsOfBookingMockMvc
            .perform(get(ENTITY_API_URL_ID, resortOriginsOfBooking.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(resortOriginsOfBooking.getId().intValue()))
            .andExpect(jsonPath("$.resort").value(DEFAULT_RESORT))
            .andExpect(jsonPath("$.sourceCode").value(DEFAULT_SOURCE_CODE))
            .andExpect(jsonPath("$.parentSourceCode").value(DEFAULT_PARENT_SOURCE_CODE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.inactiveDate").value(DEFAULT_INACTIVE_DATE.toString()))
            .andExpect(jsonPath("$.sellSequence").value(DEFAULT_SELL_SEQUENCE))
            .andExpect(jsonPath("$.scOrderby").value(DEFAULT_SC_ORDERBY))
            .andExpect(jsonPath("$.internetSalesYn").value(DEFAULT_INTERNET_SALES_YN));
    }

    @Test
    @Transactional
    void getNonExistingResortOriginsOfBooking() throws Exception {
        // Get the resortOriginsOfBooking
        restResortOriginsOfBookingMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingResortOriginsOfBooking() throws Exception {
        // Initialize the database
        resortOriginsOfBookingRepository.saveAndFlush(resortOriginsOfBooking);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the resortOriginsOfBooking
        ResortOriginsOfBooking updatedResortOriginsOfBooking = resortOriginsOfBookingRepository
            .findById(resortOriginsOfBooking.getId())
            .orElseThrow();
        // Disconnect from session so that the updates on updatedResortOriginsOfBooking are not directly saved in db
        em.detach(updatedResortOriginsOfBooking);
        updatedResortOriginsOfBooking
            .resort(UPDATED_RESORT)
            .sourceCode(UPDATED_SOURCE_CODE)
            .parentSourceCode(UPDATED_PARENT_SOURCE_CODE)
            .description(UPDATED_DESCRIPTION)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .sellSequence(UPDATED_SELL_SEQUENCE)
            .scOrderby(UPDATED_SC_ORDERBY)
            .internetSalesYn(UPDATED_INTERNET_SALES_YN);

        restResortOriginsOfBookingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedResortOriginsOfBooking.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedResortOriginsOfBooking))
            )
            .andExpect(status().isOk());

        // Validate the ResortOriginsOfBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedResortOriginsOfBookingToMatchAllProperties(updatedResortOriginsOfBooking);
    }

    @Test
    @Transactional
    void putNonExistingResortOriginsOfBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortOriginsOfBooking.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restResortOriginsOfBookingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, resortOriginsOfBooking.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(resortOriginsOfBooking))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResortOriginsOfBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchResortOriginsOfBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortOriginsOfBooking.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortOriginsOfBookingMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(resortOriginsOfBooking))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResortOriginsOfBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamResortOriginsOfBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortOriginsOfBooking.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortOriginsOfBookingMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(resortOriginsOfBooking)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ResortOriginsOfBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateResortOriginsOfBookingWithPatch() throws Exception {
        // Initialize the database
        resortOriginsOfBookingRepository.saveAndFlush(resortOriginsOfBooking);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the resortOriginsOfBooking using partial update
        ResortOriginsOfBooking partialUpdatedResortOriginsOfBooking = new ResortOriginsOfBooking();
        partialUpdatedResortOriginsOfBooking.setId(resortOriginsOfBooking.getId());

        partialUpdatedResortOriginsOfBooking
            .sourceCode(UPDATED_SOURCE_CODE)
            .description(UPDATED_DESCRIPTION)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .scOrderby(UPDATED_SC_ORDERBY)
            .internetSalesYn(UPDATED_INTERNET_SALES_YN);

        restResortOriginsOfBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedResortOriginsOfBooking.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedResortOriginsOfBooking))
            )
            .andExpect(status().isOk());

        // Validate the ResortOriginsOfBooking in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertResortOriginsOfBookingUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedResortOriginsOfBooking, resortOriginsOfBooking),
            getPersistedResortOriginsOfBooking(resortOriginsOfBooking)
        );
    }

    @Test
    @Transactional
    void fullUpdateResortOriginsOfBookingWithPatch() throws Exception {
        // Initialize the database
        resortOriginsOfBookingRepository.saveAndFlush(resortOriginsOfBooking);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the resortOriginsOfBooking using partial update
        ResortOriginsOfBooking partialUpdatedResortOriginsOfBooking = new ResortOriginsOfBooking();
        partialUpdatedResortOriginsOfBooking.setId(resortOriginsOfBooking.getId());

        partialUpdatedResortOriginsOfBooking
            .resort(UPDATED_RESORT)
            .sourceCode(UPDATED_SOURCE_CODE)
            .parentSourceCode(UPDATED_PARENT_SOURCE_CODE)
            .description(UPDATED_DESCRIPTION)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .sellSequence(UPDATED_SELL_SEQUENCE)
            .scOrderby(UPDATED_SC_ORDERBY)
            .internetSalesYn(UPDATED_INTERNET_SALES_YN);

        restResortOriginsOfBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedResortOriginsOfBooking.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedResortOriginsOfBooking))
            )
            .andExpect(status().isOk());

        // Validate the ResortOriginsOfBooking in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertResortOriginsOfBookingUpdatableFieldsEquals(
            partialUpdatedResortOriginsOfBooking,
            getPersistedResortOriginsOfBooking(partialUpdatedResortOriginsOfBooking)
        );
    }

    @Test
    @Transactional
    void patchNonExistingResortOriginsOfBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortOriginsOfBooking.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restResortOriginsOfBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, resortOriginsOfBooking.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(resortOriginsOfBooking))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResortOriginsOfBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchResortOriginsOfBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortOriginsOfBooking.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortOriginsOfBookingMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(resortOriginsOfBooking))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResortOriginsOfBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamResortOriginsOfBooking() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortOriginsOfBooking.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortOriginsOfBookingMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(resortOriginsOfBooking))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ResortOriginsOfBooking in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteResortOriginsOfBooking() throws Exception {
        // Initialize the database
        resortOriginsOfBookingRepository.saveAndFlush(resortOriginsOfBooking);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the resortOriginsOfBooking
        restResortOriginsOfBookingMockMvc
            .perform(delete(ENTITY_API_URL_ID, resortOriginsOfBooking.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return resortOriginsOfBookingRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected ResortOriginsOfBooking getPersistedResortOriginsOfBooking(ResortOriginsOfBooking resortOriginsOfBooking) {
        return resortOriginsOfBookingRepository.findById(resortOriginsOfBooking.getId()).orElseThrow();
    }

    protected void assertPersistedResortOriginsOfBookingToMatchAllProperties(ResortOriginsOfBooking expectedResortOriginsOfBooking) {
        assertResortOriginsOfBookingAllPropertiesEquals(
            expectedResortOriginsOfBooking,
            getPersistedResortOriginsOfBooking(expectedResortOriginsOfBooking)
        );
    }

    protected void assertPersistedResortOriginsOfBookingToMatchUpdatableProperties(ResortOriginsOfBooking expectedResortOriginsOfBooking) {
        assertResortOriginsOfBookingAllUpdatablePropertiesEquals(
            expectedResortOriginsOfBooking,
            getPersistedResortOriginsOfBooking(expectedResortOriginsOfBooking)
        );
    }
}
