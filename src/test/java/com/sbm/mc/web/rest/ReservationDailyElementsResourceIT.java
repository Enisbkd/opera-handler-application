package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.ReservationDailyElementsAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.ReservationDailyElements;
import com.sbm.mc.repository.ReservationDailyElementsRepository;
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
 * Integration tests for the {@link ReservationDailyElementsResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ReservationDailyElementsResourceIT {

    private static final String DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_RESORT = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_RESERVATION_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RESERVATION_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_RESV_DAILY_EL_SEQ = 1;
    private static final Integer UPDATED_RESV_DAILY_EL_SEQ = 2;

    private static final String DEFAULT_RESV_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_RESV_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_EXTERNAL_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_EXTERNAL_REFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_CLASS = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_CLASS = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_BOOKED_ROOM_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_BOOKED_ROOM_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM = "AAAAAAAAAA";
    private static final String UPDATED_ROOM = "BBBBBBBBBB";

    private static final Integer DEFAULT_CANCELLATION_NO = 1;
    private static final Integer UPDATED_CANCELLATION_NO = 2;

    private static final LocalDate DEFAULT_CANCELLATION_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CANCELLATION_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CANCELLATION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CANCELLATION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CANCELLATION_REASON_DESC = "AAAAAAAAAA";
    private static final String UPDATED_CANCELLATION_REASON_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_GUARANTEE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_GUARANTEE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_MARKET_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MARKET_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ORIGIN_OF_BOOKING = "AAAAAAAAAA";
    private static final String UPDATED_ORIGIN_OF_BOOKING = "BBBBBBBBBB";

    private static final Integer DEFAULT_EXCHANGE_RATE = 1;
    private static final Integer UPDATED_EXCHANGE_RATE = 2;

    private static final Integer DEFAULT_ORIGINAL_BASE_RATE = 1;
    private static final Integer UPDATED_ORIGINAL_BASE_RATE = 2;

    private static final Integer DEFAULT_BASE_RATE_AMOUNT = 1;
    private static final Integer UPDATED_BASE_RATE_AMOUNT = 2;

    private static final Integer DEFAULT_RATE_AMOUNT = 1;
    private static final Integer UPDATED_RATE_AMOUNT = 2;

    private static final Integer DEFAULT_ROOM_COST = 1;
    private static final Integer UPDATED_ROOM_COST = 2;

    private static final Integer DEFAULT_QUANTITY = 1;
    private static final Integer UPDATED_QUANTITY = 2;

    private static final Integer DEFAULT_ADULTS = 1;
    private static final Integer UPDATED_ADULTS = 2;

    private static final Integer DEFAULT_CHILDREN = 1;
    private static final Integer UPDATED_CHILDREN = 2;

    private static final Integer DEFAULT_PHYSICAL_QUANTITY = 1;
    private static final Integer UPDATED_PHYSICAL_QUANTITY = 2;

    private static final Integer DEFAULT_ALLOTMENT_HEADER_ID = 1;
    private static final Integer UPDATED_ALLOTMENT_HEADER_ID = 2;

    private static final String DEFAULT_DAY_USE_YN = "AAAAAAAAAA";
    private static final String UPDATED_DAY_USE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_DUE_OUT_YN = "AAAAAAAAAA";
    private static final String UPDATED_DUE_OUT_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_INSERT_ACTION_INSTANCE_ID = 1;
    private static final Integer UPDATED_INSERT_ACTION_INSTANCE_ID = 2;

    private static final Integer DEFAULT_DML_SEQ_NO = 1;
    private static final Integer UPDATED_DML_SEQ_NO = 2;

    private static final Integer DEFAULT_EXT_SEQ_NO = 1;
    private static final Integer UPDATED_EXT_SEQ_NO = 2;

    private static final Integer DEFAULT_EXT_SEG_NO = 1;
    private static final Integer UPDATED_EXT_SEG_NO = 2;

    private static final Integer DEFAULT_CRIBS = 1;
    private static final Integer UPDATED_CRIBS = 2;

    private static final Integer DEFAULT_EXTRA_BEDS = 1;
    private static final Integer UPDATED_EXTRA_BEDS = 2;

    private static final String DEFAULT_ALLOTMENT_RECORD_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ALLOTMENT_RECORD_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_BLOCK_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_BLOCK_RESORT = "BBBBBBBBBB";

    private static final Integer DEFAULT_BLOCK_ID = 1;
    private static final Integer UPDATED_BLOCK_ID = 2;

    private static final String DEFAULT_TURNDOWN_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_TURNDOWN_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_AWD_UPGR_FROM = "AAAAAAAAAA";
    private static final String UPDATED_AWD_UPGR_FROM = "BBBBBBBBBB";

    private static final String DEFAULT_AWD_UPGR_TO = "AAAAAAAAAA";
    private static final String UPDATED_AWD_UPGR_TO = "BBBBBBBBBB";

    private static final String DEFAULT_HK_EXPECTED_SERVICE_TIME = "AAAAAAAAAA";
    private static final String UPDATED_HK_EXPECTED_SERVICE_TIME = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_INSTRUCTIONS = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_INSTRUCTIONS = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/reservation-daily-elements";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ReservationDailyElementsRepository reservationDailyElementsRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restReservationDailyElementsMockMvc;

    private ReservationDailyElements reservationDailyElements;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReservationDailyElements createEntity(EntityManager em) {
        ReservationDailyElements reservationDailyElements = new ReservationDailyElements()
            .resort(DEFAULT_RESORT)
            .reservationDate(DEFAULT_RESERVATION_DATE)
            .resvDailyElSeq(DEFAULT_RESV_DAILY_EL_SEQ)
            .resvStatus(DEFAULT_RESV_STATUS)
            .externalReference(DEFAULT_EXTERNAL_REFERENCE)
            .roomClass(DEFAULT_ROOM_CLASS)
            .roomCategory(DEFAULT_ROOM_CATEGORY)
            .bookedRoomCategory(DEFAULT_BOOKED_ROOM_CATEGORY)
            .room(DEFAULT_ROOM)
            .cancellationNo(DEFAULT_CANCELLATION_NO)
            .cancellationDate(DEFAULT_CANCELLATION_DATE)
            .cancellationCode(DEFAULT_CANCELLATION_CODE)
            .cancellationReasonDesc(DEFAULT_CANCELLATION_REASON_DESC)
            .guaranteeCode(DEFAULT_GUARANTEE_CODE)
            .marketCode(DEFAULT_MARKET_CODE)
            .originOfBooking(DEFAULT_ORIGIN_OF_BOOKING)
            .exchangeRate(DEFAULT_EXCHANGE_RATE)
            .originalBaseRate(DEFAULT_ORIGINAL_BASE_RATE)
            .baseRateAmount(DEFAULT_BASE_RATE_AMOUNT)
            .rateAmount(DEFAULT_RATE_AMOUNT)
            .roomCost(DEFAULT_ROOM_COST)
            .quantity(DEFAULT_QUANTITY)
            .adults(DEFAULT_ADULTS)
            .children(DEFAULT_CHILDREN)
            .physicalQuantity(DEFAULT_PHYSICAL_QUANTITY)
            .allotmentHeaderId(DEFAULT_ALLOTMENT_HEADER_ID)
            .dayUseYn(DEFAULT_DAY_USE_YN)
            .dueOutYn(DEFAULT_DUE_OUT_YN)
            .insertUser(DEFAULT_INSERT_USER)
            .insertDate(DEFAULT_INSERT_DATE)
            .updateUser(DEFAULT_UPDATE_USER)
            .updateDate(DEFAULT_UPDATE_DATE)
            .insertActionInstanceId(DEFAULT_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(DEFAULT_DML_SEQ_NO)
            .extSeqNo(DEFAULT_EXT_SEQ_NO)
            .extSegNo(DEFAULT_EXT_SEG_NO)
            .cribs(DEFAULT_CRIBS)
            .extraBeds(DEFAULT_EXTRA_BEDS)
            .allotmentRecordType(DEFAULT_ALLOTMENT_RECORD_TYPE)
            .blockResort(DEFAULT_BLOCK_RESORT)
            .blockId(DEFAULT_BLOCK_ID)
            .turndownStatus(DEFAULT_TURNDOWN_STATUS)
            .awdUpgrFrom(DEFAULT_AWD_UPGR_FROM)
            .awdUpgrTo(DEFAULT_AWD_UPGR_TO)
            .hkExpectedServiceTime(DEFAULT_HK_EXPECTED_SERVICE_TIME)
            .roomInstructions(DEFAULT_ROOM_INSTRUCTIONS);
        return reservationDailyElements;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReservationDailyElements createUpdatedEntity(EntityManager em) {
        ReservationDailyElements reservationDailyElements = new ReservationDailyElements()
            .resort(UPDATED_RESORT)
            .reservationDate(UPDATED_RESERVATION_DATE)
            .resvDailyElSeq(UPDATED_RESV_DAILY_EL_SEQ)
            .resvStatus(UPDATED_RESV_STATUS)
            .externalReference(UPDATED_EXTERNAL_REFERENCE)
            .roomClass(UPDATED_ROOM_CLASS)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .bookedRoomCategory(UPDATED_BOOKED_ROOM_CATEGORY)
            .room(UPDATED_ROOM)
            .cancellationNo(UPDATED_CANCELLATION_NO)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .cancellationCode(UPDATED_CANCELLATION_CODE)
            .cancellationReasonDesc(UPDATED_CANCELLATION_REASON_DESC)
            .guaranteeCode(UPDATED_GUARANTEE_CODE)
            .marketCode(UPDATED_MARKET_CODE)
            .originOfBooking(UPDATED_ORIGIN_OF_BOOKING)
            .exchangeRate(UPDATED_EXCHANGE_RATE)
            .originalBaseRate(UPDATED_ORIGINAL_BASE_RATE)
            .baseRateAmount(UPDATED_BASE_RATE_AMOUNT)
            .rateAmount(UPDATED_RATE_AMOUNT)
            .roomCost(UPDATED_ROOM_COST)
            .quantity(UPDATED_QUANTITY)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .physicalQuantity(UPDATED_PHYSICAL_QUANTITY)
            .allotmentHeaderId(UPDATED_ALLOTMENT_HEADER_ID)
            .dayUseYn(UPDATED_DAY_USE_YN)
            .dueOutYn(UPDATED_DUE_OUT_YN)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .insertActionInstanceId(UPDATED_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(UPDATED_DML_SEQ_NO)
            .extSeqNo(UPDATED_EXT_SEQ_NO)
            .extSegNo(UPDATED_EXT_SEG_NO)
            .cribs(UPDATED_CRIBS)
            .extraBeds(UPDATED_EXTRA_BEDS)
            .allotmentRecordType(UPDATED_ALLOTMENT_RECORD_TYPE)
            .blockResort(UPDATED_BLOCK_RESORT)
            .blockId(UPDATED_BLOCK_ID)
            .turndownStatus(UPDATED_TURNDOWN_STATUS)
            .awdUpgrFrom(UPDATED_AWD_UPGR_FROM)
            .awdUpgrTo(UPDATED_AWD_UPGR_TO)
            .hkExpectedServiceTime(UPDATED_HK_EXPECTED_SERVICE_TIME)
            .roomInstructions(UPDATED_ROOM_INSTRUCTIONS);
        return reservationDailyElements;
    }

    @BeforeEach
    public void initTest() {
        reservationDailyElements = createEntity(em);
    }

    @Test
    @Transactional
    void createReservationDailyElements() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ReservationDailyElements
        var returnedReservationDailyElements = om.readValue(
            restReservationDailyElementsMockMvc
                .perform(
                    post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationDailyElements))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ReservationDailyElements.class
        );

        // Validate the ReservationDailyElements in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertReservationDailyElementsUpdatableFieldsEquals(
            returnedReservationDailyElements,
            getPersistedReservationDailyElements(returnedReservationDailyElements)
        );
    }

    @Test
    @Transactional
    void createReservationDailyElementsWithExistingId() throws Exception {
        // Create the ReservationDailyElements with an existing ID
        reservationDailyElements.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restReservationDailyElementsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationDailyElements)))
            .andExpect(status().isBadRequest());

        // Validate the ReservationDailyElements in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllReservationDailyElements() throws Exception {
        // Initialize the database
        reservationDailyElementsRepository.saveAndFlush(reservationDailyElements);

        // Get all the reservationDailyElementsList
        restReservationDailyElementsMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reservationDailyElements.getId().intValue())))
            .andExpect(jsonPath("$.[*].resort").value(hasItem(DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].reservationDate").value(hasItem(DEFAULT_RESERVATION_DATE.toString())))
            .andExpect(jsonPath("$.[*].resvDailyElSeq").value(hasItem(DEFAULT_RESV_DAILY_EL_SEQ)))
            .andExpect(jsonPath("$.[*].resvStatus").value(hasItem(DEFAULT_RESV_STATUS)))
            .andExpect(jsonPath("$.[*].externalReference").value(hasItem(DEFAULT_EXTERNAL_REFERENCE)))
            .andExpect(jsonPath("$.[*].roomClass").value(hasItem(DEFAULT_ROOM_CLASS)))
            .andExpect(jsonPath("$.[*].roomCategory").value(hasItem(DEFAULT_ROOM_CATEGORY)))
            .andExpect(jsonPath("$.[*].bookedRoomCategory").value(hasItem(DEFAULT_BOOKED_ROOM_CATEGORY)))
            .andExpect(jsonPath("$.[*].room").value(hasItem(DEFAULT_ROOM)))
            .andExpect(jsonPath("$.[*].cancellationNo").value(hasItem(DEFAULT_CANCELLATION_NO)))
            .andExpect(jsonPath("$.[*].cancellationDate").value(hasItem(DEFAULT_CANCELLATION_DATE.toString())))
            .andExpect(jsonPath("$.[*].cancellationCode").value(hasItem(DEFAULT_CANCELLATION_CODE)))
            .andExpect(jsonPath("$.[*].cancellationReasonDesc").value(hasItem(DEFAULT_CANCELLATION_REASON_DESC)))
            .andExpect(jsonPath("$.[*].guaranteeCode").value(hasItem(DEFAULT_GUARANTEE_CODE)))
            .andExpect(jsonPath("$.[*].marketCode").value(hasItem(DEFAULT_MARKET_CODE)))
            .andExpect(jsonPath("$.[*].originOfBooking").value(hasItem(DEFAULT_ORIGIN_OF_BOOKING)))
            .andExpect(jsonPath("$.[*].exchangeRate").value(hasItem(DEFAULT_EXCHANGE_RATE)))
            .andExpect(jsonPath("$.[*].originalBaseRate").value(hasItem(DEFAULT_ORIGINAL_BASE_RATE)))
            .andExpect(jsonPath("$.[*].baseRateAmount").value(hasItem(DEFAULT_BASE_RATE_AMOUNT)))
            .andExpect(jsonPath("$.[*].rateAmount").value(hasItem(DEFAULT_RATE_AMOUNT)))
            .andExpect(jsonPath("$.[*].roomCost").value(hasItem(DEFAULT_ROOM_COST)))
            .andExpect(jsonPath("$.[*].quantity").value(hasItem(DEFAULT_QUANTITY)))
            .andExpect(jsonPath("$.[*].adults").value(hasItem(DEFAULT_ADULTS)))
            .andExpect(jsonPath("$.[*].children").value(hasItem(DEFAULT_CHILDREN)))
            .andExpect(jsonPath("$.[*].physicalQuantity").value(hasItem(DEFAULT_PHYSICAL_QUANTITY)))
            .andExpect(jsonPath("$.[*].allotmentHeaderId").value(hasItem(DEFAULT_ALLOTMENT_HEADER_ID)))
            .andExpect(jsonPath("$.[*].dayUseYn").value(hasItem(DEFAULT_DAY_USE_YN)))
            .andExpect(jsonPath("$.[*].dueOutYn").value(hasItem(DEFAULT_DUE_OUT_YN)))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].insertActionInstanceId").value(hasItem(DEFAULT_INSERT_ACTION_INSTANCE_ID)))
            .andExpect(jsonPath("$.[*].dmlSeqNo").value(hasItem(DEFAULT_DML_SEQ_NO)))
            .andExpect(jsonPath("$.[*].extSeqNo").value(hasItem(DEFAULT_EXT_SEQ_NO)))
            .andExpect(jsonPath("$.[*].extSegNo").value(hasItem(DEFAULT_EXT_SEG_NO)))
            .andExpect(jsonPath("$.[*].cribs").value(hasItem(DEFAULT_CRIBS)))
            .andExpect(jsonPath("$.[*].extraBeds").value(hasItem(DEFAULT_EXTRA_BEDS)))
            .andExpect(jsonPath("$.[*].allotmentRecordType").value(hasItem(DEFAULT_ALLOTMENT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].blockResort").value(hasItem(DEFAULT_BLOCK_RESORT)))
            .andExpect(jsonPath("$.[*].blockId").value(hasItem(DEFAULT_BLOCK_ID)))
            .andExpect(jsonPath("$.[*].turndownStatus").value(hasItem(DEFAULT_TURNDOWN_STATUS)))
            .andExpect(jsonPath("$.[*].awdUpgrFrom").value(hasItem(DEFAULT_AWD_UPGR_FROM)))
            .andExpect(jsonPath("$.[*].awdUpgrTo").value(hasItem(DEFAULT_AWD_UPGR_TO)))
            .andExpect(jsonPath("$.[*].hkExpectedServiceTime").value(hasItem(DEFAULT_HK_EXPECTED_SERVICE_TIME)))
            .andExpect(jsonPath("$.[*].roomInstructions").value(hasItem(DEFAULT_ROOM_INSTRUCTIONS)));
    }

    @Test
    @Transactional
    void getReservationDailyElements() throws Exception {
        // Initialize the database
        reservationDailyElementsRepository.saveAndFlush(reservationDailyElements);

        // Get the reservationDailyElements
        restReservationDailyElementsMockMvc
            .perform(get(ENTITY_API_URL_ID, reservationDailyElements.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(reservationDailyElements.getId().intValue()))
            .andExpect(jsonPath("$.resort").value(DEFAULT_RESORT))
            .andExpect(jsonPath("$.reservationDate").value(DEFAULT_RESERVATION_DATE.toString()))
            .andExpect(jsonPath("$.resvDailyElSeq").value(DEFAULT_RESV_DAILY_EL_SEQ))
            .andExpect(jsonPath("$.resvStatus").value(DEFAULT_RESV_STATUS))
            .andExpect(jsonPath("$.externalReference").value(DEFAULT_EXTERNAL_REFERENCE))
            .andExpect(jsonPath("$.roomClass").value(DEFAULT_ROOM_CLASS))
            .andExpect(jsonPath("$.roomCategory").value(DEFAULT_ROOM_CATEGORY))
            .andExpect(jsonPath("$.bookedRoomCategory").value(DEFAULT_BOOKED_ROOM_CATEGORY))
            .andExpect(jsonPath("$.room").value(DEFAULT_ROOM))
            .andExpect(jsonPath("$.cancellationNo").value(DEFAULT_CANCELLATION_NO))
            .andExpect(jsonPath("$.cancellationDate").value(DEFAULT_CANCELLATION_DATE.toString()))
            .andExpect(jsonPath("$.cancellationCode").value(DEFAULT_CANCELLATION_CODE))
            .andExpect(jsonPath("$.cancellationReasonDesc").value(DEFAULT_CANCELLATION_REASON_DESC))
            .andExpect(jsonPath("$.guaranteeCode").value(DEFAULT_GUARANTEE_CODE))
            .andExpect(jsonPath("$.marketCode").value(DEFAULT_MARKET_CODE))
            .andExpect(jsonPath("$.originOfBooking").value(DEFAULT_ORIGIN_OF_BOOKING))
            .andExpect(jsonPath("$.exchangeRate").value(DEFAULT_EXCHANGE_RATE))
            .andExpect(jsonPath("$.originalBaseRate").value(DEFAULT_ORIGINAL_BASE_RATE))
            .andExpect(jsonPath("$.baseRateAmount").value(DEFAULT_BASE_RATE_AMOUNT))
            .andExpect(jsonPath("$.rateAmount").value(DEFAULT_RATE_AMOUNT))
            .andExpect(jsonPath("$.roomCost").value(DEFAULT_ROOM_COST))
            .andExpect(jsonPath("$.quantity").value(DEFAULT_QUANTITY))
            .andExpect(jsonPath("$.adults").value(DEFAULT_ADULTS))
            .andExpect(jsonPath("$.children").value(DEFAULT_CHILDREN))
            .andExpect(jsonPath("$.physicalQuantity").value(DEFAULT_PHYSICAL_QUANTITY))
            .andExpect(jsonPath("$.allotmentHeaderId").value(DEFAULT_ALLOTMENT_HEADER_ID))
            .andExpect(jsonPath("$.dayUseYn").value(DEFAULT_DAY_USE_YN))
            .andExpect(jsonPath("$.dueOutYn").value(DEFAULT_DUE_OUT_YN))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.insertActionInstanceId").value(DEFAULT_INSERT_ACTION_INSTANCE_ID))
            .andExpect(jsonPath("$.dmlSeqNo").value(DEFAULT_DML_SEQ_NO))
            .andExpect(jsonPath("$.extSeqNo").value(DEFAULT_EXT_SEQ_NO))
            .andExpect(jsonPath("$.extSegNo").value(DEFAULT_EXT_SEG_NO))
            .andExpect(jsonPath("$.cribs").value(DEFAULT_CRIBS))
            .andExpect(jsonPath("$.extraBeds").value(DEFAULT_EXTRA_BEDS))
            .andExpect(jsonPath("$.allotmentRecordType").value(DEFAULT_ALLOTMENT_RECORD_TYPE))
            .andExpect(jsonPath("$.blockResort").value(DEFAULT_BLOCK_RESORT))
            .andExpect(jsonPath("$.blockId").value(DEFAULT_BLOCK_ID))
            .andExpect(jsonPath("$.turndownStatus").value(DEFAULT_TURNDOWN_STATUS))
            .andExpect(jsonPath("$.awdUpgrFrom").value(DEFAULT_AWD_UPGR_FROM))
            .andExpect(jsonPath("$.awdUpgrTo").value(DEFAULT_AWD_UPGR_TO))
            .andExpect(jsonPath("$.hkExpectedServiceTime").value(DEFAULT_HK_EXPECTED_SERVICE_TIME))
            .andExpect(jsonPath("$.roomInstructions").value(DEFAULT_ROOM_INSTRUCTIONS));
    }

    @Test
    @Transactional
    void getNonExistingReservationDailyElements() throws Exception {
        // Get the reservationDailyElements
        restReservationDailyElementsMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingReservationDailyElements() throws Exception {
        // Initialize the database
        reservationDailyElementsRepository.saveAndFlush(reservationDailyElements);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationDailyElements
        ReservationDailyElements updatedReservationDailyElements = reservationDailyElementsRepository
            .findById(reservationDailyElements.getId())
            .orElseThrow();
        // Disconnect from session so that the updates on updatedReservationDailyElements are not directly saved in db
        em.detach(updatedReservationDailyElements);
        updatedReservationDailyElements
            .resort(UPDATED_RESORT)
            .reservationDate(UPDATED_RESERVATION_DATE)
            .resvDailyElSeq(UPDATED_RESV_DAILY_EL_SEQ)
            .resvStatus(UPDATED_RESV_STATUS)
            .externalReference(UPDATED_EXTERNAL_REFERENCE)
            .roomClass(UPDATED_ROOM_CLASS)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .bookedRoomCategory(UPDATED_BOOKED_ROOM_CATEGORY)
            .room(UPDATED_ROOM)
            .cancellationNo(UPDATED_CANCELLATION_NO)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .cancellationCode(UPDATED_CANCELLATION_CODE)
            .cancellationReasonDesc(UPDATED_CANCELLATION_REASON_DESC)
            .guaranteeCode(UPDATED_GUARANTEE_CODE)
            .marketCode(UPDATED_MARKET_CODE)
            .originOfBooking(UPDATED_ORIGIN_OF_BOOKING)
            .exchangeRate(UPDATED_EXCHANGE_RATE)
            .originalBaseRate(UPDATED_ORIGINAL_BASE_RATE)
            .baseRateAmount(UPDATED_BASE_RATE_AMOUNT)
            .rateAmount(UPDATED_RATE_AMOUNT)
            .roomCost(UPDATED_ROOM_COST)
            .quantity(UPDATED_QUANTITY)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .physicalQuantity(UPDATED_PHYSICAL_QUANTITY)
            .allotmentHeaderId(UPDATED_ALLOTMENT_HEADER_ID)
            .dayUseYn(UPDATED_DAY_USE_YN)
            .dueOutYn(UPDATED_DUE_OUT_YN)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .insertActionInstanceId(UPDATED_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(UPDATED_DML_SEQ_NO)
            .extSeqNo(UPDATED_EXT_SEQ_NO)
            .extSegNo(UPDATED_EXT_SEG_NO)
            .cribs(UPDATED_CRIBS)
            .extraBeds(UPDATED_EXTRA_BEDS)
            .allotmentRecordType(UPDATED_ALLOTMENT_RECORD_TYPE)
            .blockResort(UPDATED_BLOCK_RESORT)
            .blockId(UPDATED_BLOCK_ID)
            .turndownStatus(UPDATED_TURNDOWN_STATUS)
            .awdUpgrFrom(UPDATED_AWD_UPGR_FROM)
            .awdUpgrTo(UPDATED_AWD_UPGR_TO)
            .hkExpectedServiceTime(UPDATED_HK_EXPECTED_SERVICE_TIME)
            .roomInstructions(UPDATED_ROOM_INSTRUCTIONS);

        restReservationDailyElementsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedReservationDailyElements.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedReservationDailyElements))
            )
            .andExpect(status().isOk());

        // Validate the ReservationDailyElements in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedReservationDailyElementsToMatchAllProperties(updatedReservationDailyElements);
    }

    @Test
    @Transactional
    void putNonExistingReservationDailyElements() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElements.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReservationDailyElementsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, reservationDailyElements.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reservationDailyElements))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationDailyElements in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchReservationDailyElements() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElements.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationDailyElementsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reservationDailyElements))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationDailyElements in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamReservationDailyElements() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElements.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationDailyElementsMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationDailyElements)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReservationDailyElements in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateReservationDailyElementsWithPatch() throws Exception {
        // Initialize the database
        reservationDailyElementsRepository.saveAndFlush(reservationDailyElements);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationDailyElements using partial update
        ReservationDailyElements partialUpdatedReservationDailyElements = new ReservationDailyElements();
        partialUpdatedReservationDailyElements.setId(reservationDailyElements.getId());

        partialUpdatedReservationDailyElements
            .resvDailyElSeq(UPDATED_RESV_DAILY_EL_SEQ)
            .resvStatus(UPDATED_RESV_STATUS)
            .externalReference(UPDATED_EXTERNAL_REFERENCE)
            .marketCode(UPDATED_MARKET_CODE)
            .rateAmount(UPDATED_RATE_AMOUNT)
            .roomCost(UPDATED_ROOM_COST)
            .quantity(UPDATED_QUANTITY)
            .adults(UPDATED_ADULTS)
            .physicalQuantity(UPDATED_PHYSICAL_QUANTITY)
            .allotmentHeaderId(UPDATED_ALLOTMENT_HEADER_ID)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .extSeqNo(UPDATED_EXT_SEQ_NO)
            .extSegNo(UPDATED_EXT_SEG_NO)
            .cribs(UPDATED_CRIBS)
            .blockResort(UPDATED_BLOCK_RESORT)
            .turndownStatus(UPDATED_TURNDOWN_STATUS)
            .hkExpectedServiceTime(UPDATED_HK_EXPECTED_SERVICE_TIME);

        restReservationDailyElementsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReservationDailyElements.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReservationDailyElements))
            )
            .andExpect(status().isOk());

        // Validate the ReservationDailyElements in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReservationDailyElementsUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedReservationDailyElements, reservationDailyElements),
            getPersistedReservationDailyElements(reservationDailyElements)
        );
    }

    @Test
    @Transactional
    void fullUpdateReservationDailyElementsWithPatch() throws Exception {
        // Initialize the database
        reservationDailyElementsRepository.saveAndFlush(reservationDailyElements);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationDailyElements using partial update
        ReservationDailyElements partialUpdatedReservationDailyElements = new ReservationDailyElements();
        partialUpdatedReservationDailyElements.setId(reservationDailyElements.getId());

        partialUpdatedReservationDailyElements
            .resort(UPDATED_RESORT)
            .reservationDate(UPDATED_RESERVATION_DATE)
            .resvDailyElSeq(UPDATED_RESV_DAILY_EL_SEQ)
            .resvStatus(UPDATED_RESV_STATUS)
            .externalReference(UPDATED_EXTERNAL_REFERENCE)
            .roomClass(UPDATED_ROOM_CLASS)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .bookedRoomCategory(UPDATED_BOOKED_ROOM_CATEGORY)
            .room(UPDATED_ROOM)
            .cancellationNo(UPDATED_CANCELLATION_NO)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .cancellationCode(UPDATED_CANCELLATION_CODE)
            .cancellationReasonDesc(UPDATED_CANCELLATION_REASON_DESC)
            .guaranteeCode(UPDATED_GUARANTEE_CODE)
            .marketCode(UPDATED_MARKET_CODE)
            .originOfBooking(UPDATED_ORIGIN_OF_BOOKING)
            .exchangeRate(UPDATED_EXCHANGE_RATE)
            .originalBaseRate(UPDATED_ORIGINAL_BASE_RATE)
            .baseRateAmount(UPDATED_BASE_RATE_AMOUNT)
            .rateAmount(UPDATED_RATE_AMOUNT)
            .roomCost(UPDATED_ROOM_COST)
            .quantity(UPDATED_QUANTITY)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .physicalQuantity(UPDATED_PHYSICAL_QUANTITY)
            .allotmentHeaderId(UPDATED_ALLOTMENT_HEADER_ID)
            .dayUseYn(UPDATED_DAY_USE_YN)
            .dueOutYn(UPDATED_DUE_OUT_YN)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .insertActionInstanceId(UPDATED_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(UPDATED_DML_SEQ_NO)
            .extSeqNo(UPDATED_EXT_SEQ_NO)
            .extSegNo(UPDATED_EXT_SEG_NO)
            .cribs(UPDATED_CRIBS)
            .extraBeds(UPDATED_EXTRA_BEDS)
            .allotmentRecordType(UPDATED_ALLOTMENT_RECORD_TYPE)
            .blockResort(UPDATED_BLOCK_RESORT)
            .blockId(UPDATED_BLOCK_ID)
            .turndownStatus(UPDATED_TURNDOWN_STATUS)
            .awdUpgrFrom(UPDATED_AWD_UPGR_FROM)
            .awdUpgrTo(UPDATED_AWD_UPGR_TO)
            .hkExpectedServiceTime(UPDATED_HK_EXPECTED_SERVICE_TIME)
            .roomInstructions(UPDATED_ROOM_INSTRUCTIONS);

        restReservationDailyElementsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReservationDailyElements.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReservationDailyElements))
            )
            .andExpect(status().isOk());

        // Validate the ReservationDailyElements in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReservationDailyElementsUpdatableFieldsEquals(
            partialUpdatedReservationDailyElements,
            getPersistedReservationDailyElements(partialUpdatedReservationDailyElements)
        );
    }

    @Test
    @Transactional
    void patchNonExistingReservationDailyElements() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElements.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReservationDailyElementsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, reservationDailyElements.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reservationDailyElements))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationDailyElements in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchReservationDailyElements() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElements.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationDailyElementsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reservationDailyElements))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationDailyElements in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamReservationDailyElements() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElements.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationDailyElementsMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(reservationDailyElements))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReservationDailyElements in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteReservationDailyElements() throws Exception {
        // Initialize the database
        reservationDailyElementsRepository.saveAndFlush(reservationDailyElements);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the reservationDailyElements
        restReservationDailyElementsMockMvc
            .perform(delete(ENTITY_API_URL_ID, reservationDailyElements.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return reservationDailyElementsRepository.count();
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

    protected ReservationDailyElements getPersistedReservationDailyElements(ReservationDailyElements reservationDailyElements) {
        return reservationDailyElementsRepository.findById(reservationDailyElements.getId()).orElseThrow();
    }

    protected void assertPersistedReservationDailyElementsToMatchAllProperties(ReservationDailyElements expectedReservationDailyElements) {
        assertReservationDailyElementsAllPropertiesEquals(
            expectedReservationDailyElements,
            getPersistedReservationDailyElements(expectedReservationDailyElements)
        );
    }

    protected void assertPersistedReservationDailyElementsToMatchUpdatableProperties(
        ReservationDailyElements expectedReservationDailyElements
    ) {
        assertReservationDailyElementsAllUpdatablePropertiesEquals(
            expectedReservationDailyElements,
            getPersistedReservationDailyElements(expectedReservationDailyElements)
        );
    }
}
