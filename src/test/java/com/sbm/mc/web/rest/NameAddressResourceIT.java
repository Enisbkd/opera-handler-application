package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.NameAddressAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.NameAddress;
import com.sbm.mc.repository.NameAddressRepository;
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
 * Integration tests for the {@link NameAddressResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class NameAddressResourceIT {

    private static final Integer DEFAULT_ADDRESS_ID = 1;
    private static final Integer UPDATED_ADDRESS_ID = 2;

    private static final String DEFAULT_ADDRESS_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS_1 = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS_2 = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS_3 = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_3 = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS_4 = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_4 = "BBBBBBBBBB";

    private static final String DEFAULT_BARCODE = "AAAAAAAAAA";
    private static final String UPDATED_BARCODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_BEGIN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BEGIN_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CHAIN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CHAIN_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_CITY_EXT = "AAAAAAAAAA";
    private static final String UPDATED_CITY_EXT = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CLEANSED_DATETIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CLEANSED_DATETIME = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CLEANSED_ERRORMSG = "AAAAAAAAAA";
    private static final String UPDATED_CLEANSED_ERRORMSG = "BBBBBBBBBB";

    private static final String DEFAULT_CLEANSED_MATCHSTATUS = "AAAAAAAAAA";
    private static final String UPDATED_CLEANSED_MATCHSTATUS = "BBBBBBBBBB";

    private static final String DEFAULT_CLEANSED_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_CLEANSED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_CLEANSED_VALIDATIONSTATUS = "AAAAAAAAAA";
    private static final String UPDATED_CLEANSED_VALIDATIONSTATUS = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_FOREIGN_COUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_FOREIGN_COUNTRY = "BBBBBBBBBB";

    private static final String DEFAULT_IN_CARE_OF = "AAAAAAAAAA";
    private static final String UPDATED_IN_CARE_OF = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_INACTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INACTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final String DEFAULT_LANGUAGE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_LANGUAGE_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_LAPTOP_CHANGE = 1;
    private static final Integer UPDATED_LAPTOP_CHANGE = 2;

    private static final String DEFAULT_LAST_UPDATED_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_LAST_UPDATED_RESORT = "BBBBBBBBBB";

    private static final Integer DEFAULT_NAME_ID = 1;
    private static final Integer UPDATED_NAME_ID = 2;

    private static final String DEFAULT_PRIMARY_YN = "AAAAAAAAAA";
    private static final String UPDATED_PRIMARY_YN = "BBBBBBBBBB";

    private static final String DEFAULT_PROVINCE = "AAAAAAAAAA";
    private static final String UPDATED_PROVINCE = "BBBBBBBBBB";

    private static final String DEFAULT_STATE = "AAAAAAAAAA";
    private static final String UPDATED_STATE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final String DEFAULT_ZIP_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ZIP_CODE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/name-addresses";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private NameAddressRepository nameAddressRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restNameAddressMockMvc;

    private NameAddress nameAddress;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NameAddress createEntity(EntityManager em) {
        NameAddress nameAddress = new NameAddress()
            .addressId(DEFAULT_ADDRESS_ID)
            .addressType(DEFAULT_ADDRESS_TYPE)
            .address1(DEFAULT_ADDRESS_1)
            .address2(DEFAULT_ADDRESS_2)
            .address3(DEFAULT_ADDRESS_3)
            .address4(DEFAULT_ADDRESS_4)
            .barcode(DEFAULT_BARCODE)
            .beginDate(DEFAULT_BEGIN_DATE)
            .chainCode(DEFAULT_CHAIN_CODE)
            .city(DEFAULT_CITY)
            .cityExt(DEFAULT_CITY_EXT)
            .cleansedDatetime(DEFAULT_CLEANSED_DATETIME)
            .cleansedErrormsg(DEFAULT_CLEANSED_ERRORMSG)
            .cleansedMatchstatus(DEFAULT_CLEANSED_MATCHSTATUS)
            .cleansedStatus(DEFAULT_CLEANSED_STATUS)
            .cleansedValidationstatus(DEFAULT_CLEANSED_VALIDATIONSTATUS)
            .country(DEFAULT_COUNTRY)
            .endDate(DEFAULT_END_DATE)
            .foreignCountry(DEFAULT_FOREIGN_COUNTRY)
            .inCareOf(DEFAULT_IN_CARE_OF)
            .inactiveDate(DEFAULT_INACTIVE_DATE)
            .insertDate(DEFAULT_INSERT_DATE)
            .insertUser(DEFAULT_INSERT_USER)
            .languageCode(DEFAULT_LANGUAGE_CODE)
            .laptopChange(DEFAULT_LAPTOP_CHANGE)
            .lastUpdatedResort(DEFAULT_LAST_UPDATED_RESORT)
            .nameId(DEFAULT_NAME_ID)
            .primaryYn(DEFAULT_PRIMARY_YN)
            .province(DEFAULT_PROVINCE)
            .state(DEFAULT_STATE)
            .updateDate(DEFAULT_UPDATE_DATE)
            .updateUser(DEFAULT_UPDATE_USER)
            .zipCode(DEFAULT_ZIP_CODE);
        return nameAddress;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NameAddress createUpdatedEntity(EntityManager em) {
        NameAddress nameAddress = new NameAddress()
            .addressId(UPDATED_ADDRESS_ID)
            .addressType(UPDATED_ADDRESS_TYPE)
            .address1(UPDATED_ADDRESS_1)
            .address2(UPDATED_ADDRESS_2)
            .address3(UPDATED_ADDRESS_3)
            .address4(UPDATED_ADDRESS_4)
            .barcode(UPDATED_BARCODE)
            .beginDate(UPDATED_BEGIN_DATE)
            .chainCode(UPDATED_CHAIN_CODE)
            .city(UPDATED_CITY)
            .cityExt(UPDATED_CITY_EXT)
            .cleansedDatetime(UPDATED_CLEANSED_DATETIME)
            .cleansedErrormsg(UPDATED_CLEANSED_ERRORMSG)
            .cleansedMatchstatus(UPDATED_CLEANSED_MATCHSTATUS)
            .cleansedStatus(UPDATED_CLEANSED_STATUS)
            .cleansedValidationstatus(UPDATED_CLEANSED_VALIDATIONSTATUS)
            .country(UPDATED_COUNTRY)
            .endDate(UPDATED_END_DATE)
            .foreignCountry(UPDATED_FOREIGN_COUNTRY)
            .inCareOf(UPDATED_IN_CARE_OF)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .languageCode(UPDATED_LANGUAGE_CODE)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .lastUpdatedResort(UPDATED_LAST_UPDATED_RESORT)
            .nameId(UPDATED_NAME_ID)
            .primaryYn(UPDATED_PRIMARY_YN)
            .province(UPDATED_PROVINCE)
            .state(UPDATED_STATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .zipCode(UPDATED_ZIP_CODE);
        return nameAddress;
    }

    @BeforeEach
    public void initTest() {
        nameAddress = createEntity(em);
    }

    @Test
    @Transactional
    void createNameAddress() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the NameAddress
        var returnedNameAddress = om.readValue(
            restNameAddressMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(nameAddress)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            NameAddress.class
        );

        // Validate the NameAddress in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertNameAddressUpdatableFieldsEquals(returnedNameAddress, getPersistedNameAddress(returnedNameAddress));
    }

    @Test
    @Transactional
    void createNameAddressWithExistingId() throws Exception {
        // Create the NameAddress with an existing ID
        nameAddress.setId(1);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restNameAddressMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(nameAddress)))
            .andExpect(status().isBadRequest());

        // Validate the NameAddress in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllNameAddresses() throws Exception {
        // Initialize the database
        nameAddressRepository.saveAndFlush(nameAddress);

        // Get all the nameAddressList
        restNameAddressMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(nameAddress.getId().intValue())))
            .andExpect(jsonPath("$.[*].addressId").value(hasItem(DEFAULT_ADDRESS_ID)))
            .andExpect(jsonPath("$.[*].addressType").value(hasItem(DEFAULT_ADDRESS_TYPE)))
            .andExpect(jsonPath("$.[*].address1").value(hasItem(DEFAULT_ADDRESS_1)))
            .andExpect(jsonPath("$.[*].address2").value(hasItem(DEFAULT_ADDRESS_2)))
            .andExpect(jsonPath("$.[*].address3").value(hasItem(DEFAULT_ADDRESS_3)))
            .andExpect(jsonPath("$.[*].address4").value(hasItem(DEFAULT_ADDRESS_4)))
            .andExpect(jsonPath("$.[*].barcode").value(hasItem(DEFAULT_BARCODE)))
            .andExpect(jsonPath("$.[*].beginDate").value(hasItem(DEFAULT_BEGIN_DATE.toString())))
            .andExpect(jsonPath("$.[*].chainCode").value(hasItem(DEFAULT_CHAIN_CODE)))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY)))
            .andExpect(jsonPath("$.[*].cityExt").value(hasItem(DEFAULT_CITY_EXT)))
            .andExpect(jsonPath("$.[*].cleansedDatetime").value(hasItem(DEFAULT_CLEANSED_DATETIME.toString())))
            .andExpect(jsonPath("$.[*].cleansedErrormsg").value(hasItem(DEFAULT_CLEANSED_ERRORMSG)))
            .andExpect(jsonPath("$.[*].cleansedMatchstatus").value(hasItem(DEFAULT_CLEANSED_MATCHSTATUS)))
            .andExpect(jsonPath("$.[*].cleansedStatus").value(hasItem(DEFAULT_CLEANSED_STATUS)))
            .andExpect(jsonPath("$.[*].cleansedValidationstatus").value(hasItem(DEFAULT_CLEANSED_VALIDATIONSTATUS)))
            .andExpect(jsonPath("$.[*].country").value(hasItem(DEFAULT_COUNTRY)))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].foreignCountry").value(hasItem(DEFAULT_FOREIGN_COUNTRY)))
            .andExpect(jsonPath("$.[*].inCareOf").value(hasItem(DEFAULT_IN_CARE_OF)))
            .andExpect(jsonPath("$.[*].inactiveDate").value(hasItem(DEFAULT_INACTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].languageCode").value(hasItem(DEFAULT_LANGUAGE_CODE)))
            .andExpect(jsonPath("$.[*].laptopChange").value(hasItem(DEFAULT_LAPTOP_CHANGE)))
            .andExpect(jsonPath("$.[*].lastUpdatedResort").value(hasItem(DEFAULT_LAST_UPDATED_RESORT)))
            .andExpect(jsonPath("$.[*].nameId").value(hasItem(DEFAULT_NAME_ID)))
            .andExpect(jsonPath("$.[*].primaryYn").value(hasItem(DEFAULT_PRIMARY_YN)))
            .andExpect(jsonPath("$.[*].province").value(hasItem(DEFAULT_PROVINCE)))
            .andExpect(jsonPath("$.[*].state").value(hasItem(DEFAULT_STATE)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].zipCode").value(hasItem(DEFAULT_ZIP_CODE)));
    }

    @Test
    @Transactional
    void getNameAddress() throws Exception {
        // Initialize the database
        nameAddressRepository.saveAndFlush(nameAddress);

        // Get the nameAddress
        restNameAddressMockMvc
            .perform(get(ENTITY_API_URL_ID, nameAddress.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(nameAddress.getId().intValue()))
            .andExpect(jsonPath("$.addressId").value(DEFAULT_ADDRESS_ID))
            .andExpect(jsonPath("$.addressType").value(DEFAULT_ADDRESS_TYPE))
            .andExpect(jsonPath("$.address1").value(DEFAULT_ADDRESS_1))
            .andExpect(jsonPath("$.address2").value(DEFAULT_ADDRESS_2))
            .andExpect(jsonPath("$.address3").value(DEFAULT_ADDRESS_3))
            .andExpect(jsonPath("$.address4").value(DEFAULT_ADDRESS_4))
            .andExpect(jsonPath("$.barcode").value(DEFAULT_BARCODE))
            .andExpect(jsonPath("$.beginDate").value(DEFAULT_BEGIN_DATE.toString()))
            .andExpect(jsonPath("$.chainCode").value(DEFAULT_CHAIN_CODE))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY))
            .andExpect(jsonPath("$.cityExt").value(DEFAULT_CITY_EXT))
            .andExpect(jsonPath("$.cleansedDatetime").value(DEFAULT_CLEANSED_DATETIME.toString()))
            .andExpect(jsonPath("$.cleansedErrormsg").value(DEFAULT_CLEANSED_ERRORMSG))
            .andExpect(jsonPath("$.cleansedMatchstatus").value(DEFAULT_CLEANSED_MATCHSTATUS))
            .andExpect(jsonPath("$.cleansedStatus").value(DEFAULT_CLEANSED_STATUS))
            .andExpect(jsonPath("$.cleansedValidationstatus").value(DEFAULT_CLEANSED_VALIDATIONSTATUS))
            .andExpect(jsonPath("$.country").value(DEFAULT_COUNTRY))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.foreignCountry").value(DEFAULT_FOREIGN_COUNTRY))
            .andExpect(jsonPath("$.inCareOf").value(DEFAULT_IN_CARE_OF))
            .andExpect(jsonPath("$.inactiveDate").value(DEFAULT_INACTIVE_DATE.toString()))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.languageCode").value(DEFAULT_LANGUAGE_CODE))
            .andExpect(jsonPath("$.laptopChange").value(DEFAULT_LAPTOP_CHANGE))
            .andExpect(jsonPath("$.lastUpdatedResort").value(DEFAULT_LAST_UPDATED_RESORT))
            .andExpect(jsonPath("$.nameId").value(DEFAULT_NAME_ID))
            .andExpect(jsonPath("$.primaryYn").value(DEFAULT_PRIMARY_YN))
            .andExpect(jsonPath("$.province").value(DEFAULT_PROVINCE))
            .andExpect(jsonPath("$.state").value(DEFAULT_STATE))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.zipCode").value(DEFAULT_ZIP_CODE));
    }

    @Test
    @Transactional
    void getNonExistingNameAddress() throws Exception {
        // Get the nameAddress
        restNameAddressMockMvc.perform(get(ENTITY_API_URL_ID, Integer.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingNameAddress() throws Exception {
        // Initialize the database
        nameAddressRepository.saveAndFlush(nameAddress);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the nameAddress
        NameAddress updatedNameAddress = nameAddressRepository.findById(nameAddress.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedNameAddress are not directly saved in db
        em.detach(updatedNameAddress);
        updatedNameAddress
            .addressId(UPDATED_ADDRESS_ID)
            .addressType(UPDATED_ADDRESS_TYPE)
            .address1(UPDATED_ADDRESS_1)
            .address2(UPDATED_ADDRESS_2)
            .address3(UPDATED_ADDRESS_3)
            .address4(UPDATED_ADDRESS_4)
            .barcode(UPDATED_BARCODE)
            .beginDate(UPDATED_BEGIN_DATE)
            .chainCode(UPDATED_CHAIN_CODE)
            .city(UPDATED_CITY)
            .cityExt(UPDATED_CITY_EXT)
            .cleansedDatetime(UPDATED_CLEANSED_DATETIME)
            .cleansedErrormsg(UPDATED_CLEANSED_ERRORMSG)
            .cleansedMatchstatus(UPDATED_CLEANSED_MATCHSTATUS)
            .cleansedStatus(UPDATED_CLEANSED_STATUS)
            .cleansedValidationstatus(UPDATED_CLEANSED_VALIDATIONSTATUS)
            .country(UPDATED_COUNTRY)
            .endDate(UPDATED_END_DATE)
            .foreignCountry(UPDATED_FOREIGN_COUNTRY)
            .inCareOf(UPDATED_IN_CARE_OF)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .languageCode(UPDATED_LANGUAGE_CODE)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .lastUpdatedResort(UPDATED_LAST_UPDATED_RESORT)
            .nameId(UPDATED_NAME_ID)
            .primaryYn(UPDATED_PRIMARY_YN)
            .province(UPDATED_PROVINCE)
            .state(UPDATED_STATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .zipCode(UPDATED_ZIP_CODE);

        restNameAddressMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedNameAddress.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedNameAddress))
            )
            .andExpect(status().isOk());

        // Validate the NameAddress in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedNameAddressToMatchAllProperties(updatedNameAddress);
    }

    @Test
    @Transactional
    void putNonExistingNameAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        nameAddress.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNameAddressMockMvc
            .perform(
                put(ENTITY_API_URL_ID, nameAddress.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(nameAddress))
            )
            .andExpect(status().isBadRequest());

        // Validate the NameAddress in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchNameAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        nameAddress.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNameAddressMockMvc
            .perform(
                put(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(nameAddress))
            )
            .andExpect(status().isBadRequest());

        // Validate the NameAddress in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamNameAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        nameAddress.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNameAddressMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(nameAddress)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the NameAddress in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateNameAddressWithPatch() throws Exception {
        // Initialize the database
        nameAddressRepository.saveAndFlush(nameAddress);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the nameAddress using partial update
        NameAddress partialUpdatedNameAddress = new NameAddress();
        partialUpdatedNameAddress.setId(nameAddress.getId());

        partialUpdatedNameAddress
            .addressId(UPDATED_ADDRESS_ID)
            .addressType(UPDATED_ADDRESS_TYPE)
            .address1(UPDATED_ADDRESS_1)
            .address4(UPDATED_ADDRESS_4)
            .barcode(UPDATED_BARCODE)
            .beginDate(UPDATED_BEGIN_DATE)
            .cityExt(UPDATED_CITY_EXT)
            .cleansedDatetime(UPDATED_CLEANSED_DATETIME)
            .cleansedMatchstatus(UPDATED_CLEANSED_MATCHSTATUS)
            .inCareOf(UPDATED_IN_CARE_OF)
            .insertDate(UPDATED_INSERT_DATE)
            .languageCode(UPDATED_LANGUAGE_CODE)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .primaryYn(UPDATED_PRIMARY_YN)
            .province(UPDATED_PROVINCE)
            .state(UPDATED_STATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .zipCode(UPDATED_ZIP_CODE);

        restNameAddressMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedNameAddress.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedNameAddress))
            )
            .andExpect(status().isOk());

        // Validate the NameAddress in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertNameAddressUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedNameAddress, nameAddress),
            getPersistedNameAddress(nameAddress)
        );
    }

    @Test
    @Transactional
    void fullUpdateNameAddressWithPatch() throws Exception {
        // Initialize the database
        nameAddressRepository.saveAndFlush(nameAddress);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the nameAddress using partial update
        NameAddress partialUpdatedNameAddress = new NameAddress();
        partialUpdatedNameAddress.setId(nameAddress.getId());

        partialUpdatedNameAddress
            .addressId(UPDATED_ADDRESS_ID)
            .addressType(UPDATED_ADDRESS_TYPE)
            .address1(UPDATED_ADDRESS_1)
            .address2(UPDATED_ADDRESS_2)
            .address3(UPDATED_ADDRESS_3)
            .address4(UPDATED_ADDRESS_4)
            .barcode(UPDATED_BARCODE)
            .beginDate(UPDATED_BEGIN_DATE)
            .chainCode(UPDATED_CHAIN_CODE)
            .city(UPDATED_CITY)
            .cityExt(UPDATED_CITY_EXT)
            .cleansedDatetime(UPDATED_CLEANSED_DATETIME)
            .cleansedErrormsg(UPDATED_CLEANSED_ERRORMSG)
            .cleansedMatchstatus(UPDATED_CLEANSED_MATCHSTATUS)
            .cleansedStatus(UPDATED_CLEANSED_STATUS)
            .cleansedValidationstatus(UPDATED_CLEANSED_VALIDATIONSTATUS)
            .country(UPDATED_COUNTRY)
            .endDate(UPDATED_END_DATE)
            .foreignCountry(UPDATED_FOREIGN_COUNTRY)
            .inCareOf(UPDATED_IN_CARE_OF)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .languageCode(UPDATED_LANGUAGE_CODE)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .lastUpdatedResort(UPDATED_LAST_UPDATED_RESORT)
            .nameId(UPDATED_NAME_ID)
            .primaryYn(UPDATED_PRIMARY_YN)
            .province(UPDATED_PROVINCE)
            .state(UPDATED_STATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .zipCode(UPDATED_ZIP_CODE);

        restNameAddressMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedNameAddress.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedNameAddress))
            )
            .andExpect(status().isOk());

        // Validate the NameAddress in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertNameAddressUpdatableFieldsEquals(partialUpdatedNameAddress, getPersistedNameAddress(partialUpdatedNameAddress));
    }

    @Test
    @Transactional
    void patchNonExistingNameAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        nameAddress.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNameAddressMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, nameAddress.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(nameAddress))
            )
            .andExpect(status().isBadRequest());

        // Validate the NameAddress in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchNameAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        nameAddress.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNameAddressMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(nameAddress))
            )
            .andExpect(status().isBadRequest());

        // Validate the NameAddress in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamNameAddress() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        nameAddress.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNameAddressMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(nameAddress)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the NameAddress in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteNameAddress() throws Exception {
        // Initialize the database
        nameAddressRepository.saveAndFlush(nameAddress);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the nameAddress
        restNameAddressMockMvc
            .perform(delete(ENTITY_API_URL_ID, nameAddress.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return nameAddressRepository.count();
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

    protected NameAddress getPersistedNameAddress(NameAddress nameAddress) {
        return nameAddressRepository.findById(nameAddress.getId()).orElseThrow();
    }

    protected void assertPersistedNameAddressToMatchAllProperties(NameAddress expectedNameAddress) {
        assertNameAddressAllPropertiesEquals(expectedNameAddress, getPersistedNameAddress(expectedNameAddress));
    }

    protected void assertPersistedNameAddressToMatchUpdatableProperties(NameAddress expectedNameAddress) {
        assertNameAddressAllUpdatablePropertiesEquals(expectedNameAddress, getPersistedNameAddress(expectedNameAddress));
    }
}
