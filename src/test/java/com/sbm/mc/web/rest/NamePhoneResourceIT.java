package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.NamePhoneAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.NamePhone;
import com.sbm.mc.repository.NamePhoneRepository;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link NamePhoneResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class NamePhoneResourceIT {

    private static final Integer DEFAULT_PHONE_ID = 1;
    private static final Integer UPDATED_PHONE_ID = 2;

    private static final Integer DEFAULT_NAME_ID = 1;
    private static final Integer UPDATED_NAME_ID = 2;

    private static final String DEFAULT_PHONE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_ROLE = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_ROLE = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final LocalDate DEFAULT_INACTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INACTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_BEGIN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BEGIN_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_ADDRESS_ID = 1;
    private static final Integer UPDATED_ADDRESS_ID = 2;

    private static final String DEFAULT_PRIMARY_YN = "AAAAAAAAAA";
    private static final String UPDATED_PRIMARY_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_DISPLAY_SEQ = 1;
    private static final Integer UPDATED_DISPLAY_SEQ = 2;

    private static final Integer DEFAULT_LAPTOP_CHANGE = 1;
    private static final Integer UPDATED_LAPTOP_CHANGE = 2;

    private static final String DEFAULT_INDEX_PHONE = "AAAAAAAAAA";
    private static final String UPDATED_INDEX_PHONE = "BBBBBBBBBB";

    private static final String DEFAULT_EXTENSION = "AAAAAAAAAA";
    private static final String UPDATED_EXTENSION = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_FORMAT = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_FORMAT = "BBBBBBBBBB";

    private static final String DEFAULT_SHARE_EMAIL_YN = "AAAAAAAAAA";
    private static final String UPDATED_SHARE_EMAIL_YN = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_CONFIRMATION_YN = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_CONFIRMATION_YN = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_LANGUAGE = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_LANGUAGE = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_AUDIO_KEY_YN = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_AUDIO_KEY_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_COUNTRY_DIALING_CODE = 1;
    private static final Integer UPDATED_COUNTRY_DIALING_CODE = 2;

    private static final String DEFAULT_VALID_YN = "AAAAAAAAAA";
    private static final String UPDATED_VALID_YN = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_COUNTRY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_COUNTRY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CHAIN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CHAIN_CODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_VALIDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VALIDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_VALIDATE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_VALIDATE_STATUS = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/name-phones";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private NamePhoneRepository namePhoneRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restNamePhoneMockMvc;

    private NamePhone namePhone;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NamePhone createEntity(EntityManager em) {
        NamePhone namePhone = new NamePhone()
            .phoneId(DEFAULT_PHONE_ID)
            .nameId(DEFAULT_NAME_ID)
            .phoneType(DEFAULT_PHONE_TYPE)
            .phoneRole(DEFAULT_PHONE_ROLE)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .insertDate(DEFAULT_INSERT_DATE)
            .insertUser(DEFAULT_INSERT_USER)
            .updateDate(DEFAULT_UPDATE_DATE)
            .updateUser(DEFAULT_UPDATE_USER)
            .inactiveDate(DEFAULT_INACTIVE_DATE)
            .endDate(DEFAULT_END_DATE)
            .beginDate(DEFAULT_BEGIN_DATE)
            .addressId(DEFAULT_ADDRESS_ID)
            .primaryYn(DEFAULT_PRIMARY_YN)
            .displaySeq(DEFAULT_DISPLAY_SEQ)
            .laptopChange(DEFAULT_LAPTOP_CHANGE)
            .indexPhone(DEFAULT_INDEX_PHONE)
            .extension(DEFAULT_EXTENSION)
            .emailFormat(DEFAULT_EMAIL_FORMAT)
            .shareEmailYn(DEFAULT_SHARE_EMAIL_YN)
            .defaultConfirmationYn(DEFAULT_DEFAULT_CONFIRMATION_YN)
            .emailLanguage(DEFAULT_EMAIL_LANGUAGE)
            .mobileAudioKeyYn(DEFAULT_MOBILE_AUDIO_KEY_YN)
            .countryDialingCode(DEFAULT_COUNTRY_DIALING_CODE)
            .validYn(DEFAULT_VALID_YN)
            .phoneCountryCode(DEFAULT_PHONE_COUNTRY_CODE)
            .chainCode(DEFAULT_CHAIN_CODE)
            .validateDate(DEFAULT_VALIDATE_DATE)
            .validateStatus(DEFAULT_VALIDATE_STATUS);
        return namePhone;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NamePhone createUpdatedEntity(EntityManager em) {
        NamePhone namePhone = new NamePhone()
            .phoneId(UPDATED_PHONE_ID)
            .nameId(UPDATED_NAME_ID)
            .phoneType(UPDATED_PHONE_TYPE)
            .phoneRole(UPDATED_PHONE_ROLE)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .endDate(UPDATED_END_DATE)
            .beginDate(UPDATED_BEGIN_DATE)
            .addressId(UPDATED_ADDRESS_ID)
            .primaryYn(UPDATED_PRIMARY_YN)
            .displaySeq(UPDATED_DISPLAY_SEQ)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .indexPhone(UPDATED_INDEX_PHONE)
            .extension(UPDATED_EXTENSION)
            .emailFormat(UPDATED_EMAIL_FORMAT)
            .shareEmailYn(UPDATED_SHARE_EMAIL_YN)
            .defaultConfirmationYn(UPDATED_DEFAULT_CONFIRMATION_YN)
            .emailLanguage(UPDATED_EMAIL_LANGUAGE)
            .mobileAudioKeyYn(UPDATED_MOBILE_AUDIO_KEY_YN)
            .countryDialingCode(UPDATED_COUNTRY_DIALING_CODE)
            .validYn(UPDATED_VALID_YN)
            .phoneCountryCode(UPDATED_PHONE_COUNTRY_CODE)
            .chainCode(UPDATED_CHAIN_CODE)
            .validateDate(UPDATED_VALIDATE_DATE)
            .validateStatus(UPDATED_VALIDATE_STATUS);
        return namePhone;
    }

    @BeforeEach
    public void initTest() {
        namePhone = createEntity(em);
    }

    @Test
    @Transactional
    void createNamePhone() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the NamePhone
        var returnedNamePhone = om.readValue(
            restNamePhoneMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(namePhone)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            NamePhone.class
        );

        // Validate the NamePhone in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertNamePhoneUpdatableFieldsEquals(returnedNamePhone, getPersistedNamePhone(returnedNamePhone));
    }

    @Test
    @Transactional
    void createNamePhoneWithExistingId() throws Exception {
        // Create the NamePhone with an existing ID
        namePhone.setId(1);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restNamePhoneMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(namePhone)))
            .andExpect(status().isBadRequest());

        // Validate the NamePhone in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllNamePhones() throws Exception {
        // Initialize the database
        namePhoneRepository.saveAndFlush(namePhone);

        // Get all the namePhoneList
        restNamePhoneMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(namePhone.getId().intValue())))
            .andExpect(jsonPath("$.[*].phoneId").value(hasItem(DEFAULT_PHONE_ID)))
            .andExpect(jsonPath("$.[*].nameId").value(hasItem(DEFAULT_NAME_ID)))
            .andExpect(jsonPath("$.[*].phoneType").value(hasItem(DEFAULT_PHONE_TYPE)))
            .andExpect(jsonPath("$.[*].phoneRole").value(hasItem(DEFAULT_PHONE_ROLE)))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].inactiveDate").value(hasItem(DEFAULT_INACTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].beginDate").value(hasItem(DEFAULT_BEGIN_DATE.toString())))
            .andExpect(jsonPath("$.[*].addressId").value(hasItem(DEFAULT_ADDRESS_ID)))
            .andExpect(jsonPath("$.[*].primaryYn").value(hasItem(DEFAULT_PRIMARY_YN)))
            .andExpect(jsonPath("$.[*].displaySeq").value(hasItem(DEFAULT_DISPLAY_SEQ)))
            .andExpect(jsonPath("$.[*].laptopChange").value(hasItem(DEFAULT_LAPTOP_CHANGE)))
            .andExpect(jsonPath("$.[*].indexPhone").value(hasItem(DEFAULT_INDEX_PHONE)))
            .andExpect(jsonPath("$.[*].extension").value(hasItem(DEFAULT_EXTENSION)))
            .andExpect(jsonPath("$.[*].emailFormat").value(hasItem(DEFAULT_EMAIL_FORMAT)))
            .andExpect(jsonPath("$.[*].shareEmailYn").value(hasItem(DEFAULT_SHARE_EMAIL_YN)))
            .andExpect(jsonPath("$.[*].defaultConfirmationYn").value(hasItem(DEFAULT_DEFAULT_CONFIRMATION_YN)))
            .andExpect(jsonPath("$.[*].emailLanguage").value(hasItem(DEFAULT_EMAIL_LANGUAGE)))
            .andExpect(jsonPath("$.[*].mobileAudioKeyYn").value(hasItem(DEFAULT_MOBILE_AUDIO_KEY_YN)))
            .andExpect(jsonPath("$.[*].countryDialingCode").value(hasItem(DEFAULT_COUNTRY_DIALING_CODE)))
            .andExpect(jsonPath("$.[*].validYn").value(hasItem(DEFAULT_VALID_YN)))
            .andExpect(jsonPath("$.[*].phoneCountryCode").value(hasItem(DEFAULT_PHONE_COUNTRY_CODE)))
            .andExpect(jsonPath("$.[*].chainCode").value(hasItem(DEFAULT_CHAIN_CODE)))
            .andExpect(jsonPath("$.[*].validateDate").value(hasItem(DEFAULT_VALIDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].validateStatus").value(hasItem(DEFAULT_VALIDATE_STATUS)));
    }

    @Test
    @Transactional
    void getNamePhone() throws Exception {
        // Initialize the database
        namePhoneRepository.saveAndFlush(namePhone);

        // Get the namePhone
        restNamePhoneMockMvc
            .perform(get(ENTITY_API_URL_ID, namePhone.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(namePhone.getId().intValue()))
            .andExpect(jsonPath("$.phoneId").value(DEFAULT_PHONE_ID))
            .andExpect(jsonPath("$.nameId").value(DEFAULT_NAME_ID))
            .andExpect(jsonPath("$.phoneType").value(DEFAULT_PHONE_TYPE))
            .andExpect(jsonPath("$.phoneRole").value(DEFAULT_PHONE_ROLE))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.inactiveDate").value(DEFAULT_INACTIVE_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.beginDate").value(DEFAULT_BEGIN_DATE.toString()))
            .andExpect(jsonPath("$.addressId").value(DEFAULT_ADDRESS_ID))
            .andExpect(jsonPath("$.primaryYn").value(DEFAULT_PRIMARY_YN))
            .andExpect(jsonPath("$.displaySeq").value(DEFAULT_DISPLAY_SEQ))
            .andExpect(jsonPath("$.laptopChange").value(DEFAULT_LAPTOP_CHANGE))
            .andExpect(jsonPath("$.indexPhone").value(DEFAULT_INDEX_PHONE))
            .andExpect(jsonPath("$.extension").value(DEFAULT_EXTENSION))
            .andExpect(jsonPath("$.emailFormat").value(DEFAULT_EMAIL_FORMAT))
            .andExpect(jsonPath("$.shareEmailYn").value(DEFAULT_SHARE_EMAIL_YN))
            .andExpect(jsonPath("$.defaultConfirmationYn").value(DEFAULT_DEFAULT_CONFIRMATION_YN))
            .andExpect(jsonPath("$.emailLanguage").value(DEFAULT_EMAIL_LANGUAGE))
            .andExpect(jsonPath("$.mobileAudioKeyYn").value(DEFAULT_MOBILE_AUDIO_KEY_YN))
            .andExpect(jsonPath("$.countryDialingCode").value(DEFAULT_COUNTRY_DIALING_CODE))
            .andExpect(jsonPath("$.validYn").value(DEFAULT_VALID_YN))
            .andExpect(jsonPath("$.phoneCountryCode").value(DEFAULT_PHONE_COUNTRY_CODE))
            .andExpect(jsonPath("$.chainCode").value(DEFAULT_CHAIN_CODE))
            .andExpect(jsonPath("$.validateDate").value(DEFAULT_VALIDATE_DATE.toString()))
            .andExpect(jsonPath("$.validateStatus").value(DEFAULT_VALIDATE_STATUS));
    }

    @Test
    @Transactional
    void getNonExistingNamePhone() throws Exception {
        // Get the namePhone
        restNamePhoneMockMvc.perform(get(ENTITY_API_URL_ID, Integer.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingNamePhone() throws Exception {
        // Initialize the database
        namePhoneRepository.saveAndFlush(namePhone);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the namePhone
        NamePhone updatedNamePhone = namePhoneRepository.findById(namePhone.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedNamePhone are not directly saved in db
        em.detach(updatedNamePhone);
        updatedNamePhone
            .phoneId(UPDATED_PHONE_ID)
            .nameId(UPDATED_NAME_ID)
            .phoneType(UPDATED_PHONE_TYPE)
            .phoneRole(UPDATED_PHONE_ROLE)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .endDate(UPDATED_END_DATE)
            .beginDate(UPDATED_BEGIN_DATE)
            .addressId(UPDATED_ADDRESS_ID)
            .primaryYn(UPDATED_PRIMARY_YN)
            .displaySeq(UPDATED_DISPLAY_SEQ)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .indexPhone(UPDATED_INDEX_PHONE)
            .extension(UPDATED_EXTENSION)
            .emailFormat(UPDATED_EMAIL_FORMAT)
            .shareEmailYn(UPDATED_SHARE_EMAIL_YN)
            .defaultConfirmationYn(UPDATED_DEFAULT_CONFIRMATION_YN)
            .emailLanguage(UPDATED_EMAIL_LANGUAGE)
            .mobileAudioKeyYn(UPDATED_MOBILE_AUDIO_KEY_YN)
            .countryDialingCode(UPDATED_COUNTRY_DIALING_CODE)
            .validYn(UPDATED_VALID_YN)
            .phoneCountryCode(UPDATED_PHONE_COUNTRY_CODE)
            .chainCode(UPDATED_CHAIN_CODE)
            .validateDate(UPDATED_VALIDATE_DATE)
            .validateStatus(UPDATED_VALIDATE_STATUS);

        restNamePhoneMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedNamePhone.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedNamePhone))
            )
            .andExpect(status().isOk());

        // Validate the NamePhone in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedNamePhoneToMatchAllProperties(updatedNamePhone);
    }

    @Test
    @Transactional
    void putNonExistingNamePhone() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        namePhone.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNamePhoneMockMvc
            .perform(
                put(ENTITY_API_URL_ID, namePhone.getId()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(namePhone))
            )
            .andExpect(status().isBadRequest());

        // Validate the NamePhone in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchNamePhone() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        namePhone.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNamePhoneMockMvc
            .perform(
                put(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(namePhone))
            )
            .andExpect(status().isBadRequest());

        // Validate the NamePhone in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamNamePhone() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        namePhone.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNamePhoneMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(namePhone)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the NamePhone in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateNamePhoneWithPatch() throws Exception {
        // Initialize the database
        namePhoneRepository.saveAndFlush(namePhone);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the namePhone using partial update
        NamePhone partialUpdatedNamePhone = new NamePhone();
        partialUpdatedNamePhone.setId(namePhone.getId());

        partialUpdatedNamePhone
            .phoneId(UPDATED_PHONE_ID)
            .phoneRole(UPDATED_PHONE_ROLE)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .insertDate(UPDATED_INSERT_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .beginDate(UPDATED_BEGIN_DATE)
            .addressId(UPDATED_ADDRESS_ID)
            .primaryYn(UPDATED_PRIMARY_YN)
            .displaySeq(UPDATED_DISPLAY_SEQ)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .emailFormat(UPDATED_EMAIL_FORMAT)
            .shareEmailYn(UPDATED_SHARE_EMAIL_YN)
            .defaultConfirmationYn(UPDATED_DEFAULT_CONFIRMATION_YN)
            .validYn(UPDATED_VALID_YN)
            .chainCode(UPDATED_CHAIN_CODE)
            .validateStatus(UPDATED_VALIDATE_STATUS);

        restNamePhoneMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedNamePhone.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedNamePhone))
            )
            .andExpect(status().isOk());

        // Validate the NamePhone in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertNamePhoneUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedNamePhone, namePhone),
            getPersistedNamePhone(namePhone)
        );
    }

    @Test
    @Transactional
    void fullUpdateNamePhoneWithPatch() throws Exception {
        // Initialize the database
        namePhoneRepository.saveAndFlush(namePhone);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the namePhone using partial update
        NamePhone partialUpdatedNamePhone = new NamePhone();
        partialUpdatedNamePhone.setId(namePhone.getId());

        partialUpdatedNamePhone
            .phoneId(UPDATED_PHONE_ID)
            .nameId(UPDATED_NAME_ID)
            .phoneType(UPDATED_PHONE_TYPE)
            .phoneRole(UPDATED_PHONE_ROLE)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .endDate(UPDATED_END_DATE)
            .beginDate(UPDATED_BEGIN_DATE)
            .addressId(UPDATED_ADDRESS_ID)
            .primaryYn(UPDATED_PRIMARY_YN)
            .displaySeq(UPDATED_DISPLAY_SEQ)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .indexPhone(UPDATED_INDEX_PHONE)
            .extension(UPDATED_EXTENSION)
            .emailFormat(UPDATED_EMAIL_FORMAT)
            .shareEmailYn(UPDATED_SHARE_EMAIL_YN)
            .defaultConfirmationYn(UPDATED_DEFAULT_CONFIRMATION_YN)
            .emailLanguage(UPDATED_EMAIL_LANGUAGE)
            .mobileAudioKeyYn(UPDATED_MOBILE_AUDIO_KEY_YN)
            .countryDialingCode(UPDATED_COUNTRY_DIALING_CODE)
            .validYn(UPDATED_VALID_YN)
            .phoneCountryCode(UPDATED_PHONE_COUNTRY_CODE)
            .chainCode(UPDATED_CHAIN_CODE)
            .validateDate(UPDATED_VALIDATE_DATE)
            .validateStatus(UPDATED_VALIDATE_STATUS);

        restNamePhoneMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedNamePhone.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedNamePhone))
            )
            .andExpect(status().isOk());

        // Validate the NamePhone in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertNamePhoneUpdatableFieldsEquals(partialUpdatedNamePhone, getPersistedNamePhone(partialUpdatedNamePhone));
    }

    @Test
    @Transactional
    void patchNonExistingNamePhone() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        namePhone.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNamePhoneMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, namePhone.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(namePhone))
            )
            .andExpect(status().isBadRequest());

        // Validate the NamePhone in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchNamePhone() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        namePhone.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNamePhoneMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(namePhone))
            )
            .andExpect(status().isBadRequest());

        // Validate the NamePhone in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamNamePhone() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        namePhone.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNamePhoneMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(namePhone)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the NamePhone in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteNamePhone() throws Exception {
        // Initialize the database
        namePhoneRepository.saveAndFlush(namePhone);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the namePhone
        restNamePhoneMockMvc
            .perform(delete(ENTITY_API_URL_ID, namePhone.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return namePhoneRepository.count();
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

    protected NamePhone getPersistedNamePhone(NamePhone namePhone) {
        return namePhoneRepository.findById(namePhone.getId()).orElseThrow();
    }

    protected void assertPersistedNamePhoneToMatchAllProperties(NamePhone expectedNamePhone) {
        assertNamePhoneAllPropertiesEquals(expectedNamePhone, getPersistedNamePhone(expectedNamePhone));
    }

    protected void assertPersistedNamePhoneToMatchUpdatableProperties(NamePhone expectedNamePhone) {
        assertNamePhoneAllUpdatablePropertiesEquals(expectedNamePhone, getPersistedNamePhone(expectedNamePhone));
    }
}
