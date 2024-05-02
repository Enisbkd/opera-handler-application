package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.ReservationSummaryAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static com.sbm.mc.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.ReservationSummary;
import com.sbm.mc.repository.ReservationSummaryRepository;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
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
 * Integration tests for the {@link ReservationSummaryResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ReservationSummaryResourceIT {

    private static final String DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_RESORT = "BBBBBBBBBB";

    private static final String DEFAULT_EVENT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_EVENT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_EVENT_ID = "AAAAAAAAAA";
    private static final String UPDATED_EVENT_ID = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CONSIDERED_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CONSIDERED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ROOM_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_CLASS = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_CLASS = "BBBBBBBBBB";

    private static final String DEFAULT_MARKET_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MARKET_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_RATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_RATE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_REGION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_REGION_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_GROUP_ID = 1;
    private static final Integer UPDATED_GROUP_ID = 2;

    private static final String DEFAULT_RESV_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_RESV_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_RESV_INV_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_RESV_INV_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_PSUEDO_ROOM_YN = "AAAAAAAAAA";
    private static final String UPDATED_PSUEDO_ROOM_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_ARR_ROOMS = 1;
    private static final Integer UPDATED_ARR_ROOMS = 2;

    private static final Integer DEFAULT_ADULTS = 1;
    private static final Integer UPDATED_ADULTS = 2;

    private static final Integer DEFAULT_CHILDREN = 1;
    private static final Integer UPDATED_CHILDREN = 2;

    private static final Integer DEFAULT_DEP_ROOMS = 1;
    private static final Integer UPDATED_DEP_ROOMS = 2;

    private static final Integer DEFAULT_NO_ROOMS = 1;
    private static final Integer UPDATED_NO_ROOMS = 2;

    private static final BigDecimal DEFAULT_GROSS_RATE = new BigDecimal(1);
    private static final BigDecimal UPDATED_GROSS_RATE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_NET_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_NET_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_EXTRA_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_EXTRA_REVENUE = new BigDecimal(2);

    private static final Integer DEFAULT_OO_ROOMS = 1;
    private static final Integer UPDATED_OO_ROOMS = 2;

    private static final Integer DEFAULT_OS_ROOMS = 1;
    private static final Integer UPDATED_OS_ROOMS = 2;

    private static final Integer DEFAULT_REMAINING_BLOCK_ROOMS = 1;
    private static final Integer UPDATED_REMAINING_BLOCK_ROOMS = 2;

    private static final Integer DEFAULT_PICKEDUP_BLOCK_ROOMS = 1;
    private static final Integer UPDATED_PICKEDUP_BLOCK_ROOMS = 2;

    private static final Integer DEFAULT_SINGLE_OCCUPANCY = 1;
    private static final Integer UPDATED_SINGLE_OCCUPANCY = 2;

    private static final Integer DEFAULT_MULTIPLE_OCCUPANCY = 1;
    private static final Integer UPDATED_MULTIPLE_OCCUPANCY = 2;

    private static final String DEFAULT_BLOCK_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_BLOCK_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_ARR_PERSONS = 1;
    private static final Integer UPDATED_ARR_PERSONS = 2;

    private static final Integer DEFAULT_DEP_PERSONS = 1;
    private static final Integer UPDATED_DEP_PERSONS = 2;

    private static final Integer DEFAULT_WL_ROOMS = 1;
    private static final Integer UPDATED_WL_ROOMS = 2;

    private static final Integer DEFAULT_WL_PERSONS = 1;
    private static final Integer UPDATED_WL_PERSONS = 2;

    private static final Integer DEFAULT_DAY_USE_ROOMS = 1;
    private static final Integer UPDATED_DAY_USE_ROOMS = 2;

    private static final Integer DEFAULT_DAY_USE_PERSONS = 1;
    private static final Integer UPDATED_DAY_USE_PERSONS = 2;

    private static final String DEFAULT_BOOKING_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_BOOKING_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_RESV_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_RESV_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_DAY_USE_YN = "AAAAAAAAAA";
    private static final String UPDATED_DAY_USE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_CHANNEL = "AAAAAAAAAA";
    private static final String UPDATED_CHANNEL = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY = "BBBBBBBBBB";

    private static final String DEFAULT_NATIONALITY = "AAAAAAAAAA";
    private static final String UPDATED_NATIONALITY = "BBBBBBBBBB";

    private static final Integer DEFAULT_CRIBS = 1;
    private static final Integer UPDATED_CRIBS = 2;

    private static final Integer DEFAULT_EXTRA_BEDS = 1;
    private static final Integer UPDATED_EXTRA_BEDS = 2;

    private static final Integer DEFAULT_ADULTS_TAX_FREE = 1;
    private static final Integer UPDATED_ADULTS_TAX_FREE = 2;

    private static final Integer DEFAULT_CHILDREN_TAX_FREE = 1;
    private static final Integer UPDATED_CHILDREN_TAX_FREE = 2;

    private static final String DEFAULT_RATE_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_RATE_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_RATE_CLASS = "AAAAAAAAAA";
    private static final String UPDATED_RATE_CLASS = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FOOD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FOOD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_OTHER_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_OTHER_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_NON_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_NON_REVENUE = new BigDecimal(2);

    private static final Integer DEFAULT_ALLOTMENT_HEADER_ID = 1;
    private static final Integer UPDATED_ALLOTMENT_HEADER_ID = 2;

    private static final BigDecimal DEFAULT_ROOM_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_ROOM_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FOOD_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FOOD_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_OTHER_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_OTHER_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_NON_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_NON_REVENUE_TAX = new BigDecimal(2);

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_ZIP_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ZIP_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DISTRICT = "AAAAAAAAAA";
    private static final String UPDATED_DISTRICT = "BBBBBBBBBB";

    private static final String DEFAULT_STATE = "AAAAAAAAAA";
    private static final String UPDATED_STATE = "BBBBBBBBBB";

    private static final Integer DEFAULT_CHILDREN_1 = 1;
    private static final Integer UPDATED_CHILDREN_1 = 2;

    private static final Integer DEFAULT_CHILDREN_2 = 1;
    private static final Integer UPDATED_CHILDREN_2 = 2;

    private static final Integer DEFAULT_CHILDREN_3 = 1;
    private static final Integer UPDATED_CHILDREN_3 = 2;

    private static final Integer DEFAULT_CHILDREN_4 = 1;
    private static final Integer UPDATED_CHILDREN_4 = 2;

    private static final Integer DEFAULT_CHILDREN_5 = 1;
    private static final Integer UPDATED_CHILDREN_5 = 2;

    private static final String DEFAULT_OWNER_FF_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_OWNER_FF_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_OWNER_RENTAL_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_OWNER_RENTAL_FLAG = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_FC_GROSS_RATE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_GROSS_RATE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_NET_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_NET_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_EXTRA_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_EXTRA_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_FOOD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_FOOD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_OTHER_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_OTHER_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_TOTAL_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_TOTAL_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_NON_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_NON_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_ROOM_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_ROOM_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_FOOD_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_FOOD_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_OTHER_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_OTHER_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_TOTAL_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_TOTAL_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FC_NON_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FC_NON_REVENUE_TAX = new BigDecimal(2);

    private static final String DEFAULT_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY_CODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_EXCHANGE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EXCHANGE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UPDATE_BUSINESS_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_BUSINESS_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CENTRAL_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CENTRAL_CURRENCY_CODE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_CENTRAL_EXCHANGE_RATE = new BigDecimal(1);
    private static final BigDecimal UPDATED_CENTRAL_EXCHANGE_RATE = new BigDecimal(2);

    private static final LocalDate DEFAULT_TRUNC_BEGIN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRUNC_BEGIN_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRUNC_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRUNC_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_BUSINESS_DATE_CREATED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BUSINESS_DATE_CREATED = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_RES_INSERT_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_RES_INSERT_SOURCE = "BBBBBBBBBB";

    private static final Integer DEFAULT_PARENT_COMPANY_ID = 1;
    private static final Integer UPDATED_PARENT_COMPANY_ID = 2;

    private static final Integer DEFAULT_AGENT_ID = 1;
    private static final Integer UPDATED_AGENT_ID = 2;

    private static final String DEFAULT_GENDER = "AAAAAAAAAA";
    private static final String UPDATED_GENDER = "BBBBBBBBBB";

    private static final String DEFAULT_VIP_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_VIP_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_QUANTITY = 1;
    private static final Integer UPDATED_QUANTITY = 2;

    private static final String DEFAULT_TURNDOWN_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_TURNDOWN_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_BOOKED_ROOM_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_BOOKED_ROOM_CATEGORY = "BBBBBBBBBB";

    private static final Integer DEFAULT_SOURCE_PROF_ID = 1;
    private static final Integer UPDATED_SOURCE_PROF_ID = 2;

    private static final String ENTITY_API_URL = "/api/reservation-summaries";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ReservationSummaryRepository reservationSummaryRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restReservationSummaryMockMvc;

    private ReservationSummary reservationSummary;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReservationSummary createEntity(EntityManager em) {
        ReservationSummary reservationSummary = new ReservationSummary()
            .resort(DEFAULT_RESORT)
            .eventType(DEFAULT_EVENT_TYPE)
            .eventId(DEFAULT_EVENT_ID)
            .consideredDate(DEFAULT_CONSIDERED_DATE)
            .roomCategory(DEFAULT_ROOM_CATEGORY)
            .roomClass(DEFAULT_ROOM_CLASS)
            .marketCode(DEFAULT_MARKET_CODE)
            .sourceCode(DEFAULT_SOURCE_CODE)
            .rateCode(DEFAULT_RATE_CODE)
            .regionCode(DEFAULT_REGION_CODE)
            .groupId(DEFAULT_GROUP_ID)
            .resvType(DEFAULT_RESV_TYPE)
            .resvInvType(DEFAULT_RESV_INV_TYPE)
            .psuedoRoomYn(DEFAULT_PSUEDO_ROOM_YN)
            .arrRooms(DEFAULT_ARR_ROOMS)
            .adults(DEFAULT_ADULTS)
            .children(DEFAULT_CHILDREN)
            .depRooms(DEFAULT_DEP_ROOMS)
            .noRooms(DEFAULT_NO_ROOMS)
            .grossRate(DEFAULT_GROSS_RATE)
            .netRoomRevenue(DEFAULT_NET_ROOM_REVENUE)
            .extraRevenue(DEFAULT_EXTRA_REVENUE)
            .ooRooms(DEFAULT_OO_ROOMS)
            .osRooms(DEFAULT_OS_ROOMS)
            .remainingBlockRooms(DEFAULT_REMAINING_BLOCK_ROOMS)
            .pickedupBlockRooms(DEFAULT_PICKEDUP_BLOCK_ROOMS)
            .singleOccupancy(DEFAULT_SINGLE_OCCUPANCY)
            .multipleOccupancy(DEFAULT_MULTIPLE_OCCUPANCY)
            .blockStatus(DEFAULT_BLOCK_STATUS)
            .arrPersons(DEFAULT_ARR_PERSONS)
            .depPersons(DEFAULT_DEP_PERSONS)
            .wlRooms(DEFAULT_WL_ROOMS)
            .wlPersons(DEFAULT_WL_PERSONS)
            .dayUseRooms(DEFAULT_DAY_USE_ROOMS)
            .dayUsePersons(DEFAULT_DAY_USE_PERSONS)
            .bookingStatus(DEFAULT_BOOKING_STATUS)
            .resvStatus(DEFAULT_RESV_STATUS)
            .dayUseYn(DEFAULT_DAY_USE_YN)
            .channel(DEFAULT_CHANNEL)
            .country(DEFAULT_COUNTRY)
            .nationality(DEFAULT_NATIONALITY)
            .cribs(DEFAULT_CRIBS)
            .extraBeds(DEFAULT_EXTRA_BEDS)
            .adultsTaxFree(DEFAULT_ADULTS_TAX_FREE)
            .childrenTaxFree(DEFAULT_CHILDREN_TAX_FREE)
            .rateCategory(DEFAULT_RATE_CATEGORY)
            .rateClass(DEFAULT_RATE_CLASS)
            .roomRevenue(DEFAULT_ROOM_REVENUE)
            .foodRevenue(DEFAULT_FOOD_REVENUE)
            .otherRevenue(DEFAULT_OTHER_REVENUE)
            .totalRevenue(DEFAULT_TOTAL_REVENUE)
            .nonRevenue(DEFAULT_NON_REVENUE)
            .allotmentHeaderId(DEFAULT_ALLOTMENT_HEADER_ID)
            .roomRevenueTax(DEFAULT_ROOM_REVENUE_TAX)
            .foodRevenueTax(DEFAULT_FOOD_REVENUE_TAX)
            .otherRevenueTax(DEFAULT_OTHER_REVENUE_TAX)
            .totalRevenueTax(DEFAULT_TOTAL_REVENUE_TAX)
            .nonRevenueTax(DEFAULT_NON_REVENUE_TAX)
            .city(DEFAULT_CITY)
            .zipCode(DEFAULT_ZIP_CODE)
            .district(DEFAULT_DISTRICT)
            .state(DEFAULT_STATE)
            .children1(DEFAULT_CHILDREN_1)
            .children2(DEFAULT_CHILDREN_2)
            .children3(DEFAULT_CHILDREN_3)
            .children4(DEFAULT_CHILDREN_4)
            .children5(DEFAULT_CHILDREN_5)
            .ownerFfFlag(DEFAULT_OWNER_FF_FLAG)
            .ownerRentalFlag(DEFAULT_OWNER_RENTAL_FLAG)
            .fcGrossRate(DEFAULT_FC_GROSS_RATE)
            .fcNetRoomRevenue(DEFAULT_FC_NET_ROOM_REVENUE)
            .fcExtraRevenue(DEFAULT_FC_EXTRA_REVENUE)
            .fcRoomRevenue(DEFAULT_FC_ROOM_REVENUE)
            .fcFoodRevenue(DEFAULT_FC_FOOD_REVENUE)
            .fcOtherRevenue(DEFAULT_FC_OTHER_REVENUE)
            .fcTotalRevenue(DEFAULT_FC_TOTAL_REVENUE)
            .fcNonRevenue(DEFAULT_FC_NON_REVENUE)
            .fcRoomRevenueTax(DEFAULT_FC_ROOM_REVENUE_TAX)
            .fcFoodRevenueTax(DEFAULT_FC_FOOD_REVENUE_TAX)
            .fcOtherRevenueTax(DEFAULT_FC_OTHER_REVENUE_TAX)
            .fcTotalRevenueTax(DEFAULT_FC_TOTAL_REVENUE_TAX)
            .fcNonRevenueTax(DEFAULT_FC_NON_REVENUE_TAX)
            .currencyCode(DEFAULT_CURRENCY_CODE)
            .exchangeDate(DEFAULT_EXCHANGE_DATE)
            .updateBusinessDate(DEFAULT_UPDATE_BUSINESS_DATE)
            .updateDate(DEFAULT_UPDATE_DATE)
            .centralCurrencyCode(DEFAULT_CENTRAL_CURRENCY_CODE)
            .centralExchangeRate(DEFAULT_CENTRAL_EXCHANGE_RATE)
            .truncBeginDate(DEFAULT_TRUNC_BEGIN_DATE)
            .truncEndDate(DEFAULT_TRUNC_END_DATE)
            .businessDateCreated(DEFAULT_BUSINESS_DATE_CREATED)
            .resInsertSource(DEFAULT_RES_INSERT_SOURCE)
            .parentCompanyId(DEFAULT_PARENT_COMPANY_ID)
            .agentId(DEFAULT_AGENT_ID)
            .gender(DEFAULT_GENDER)
            .vipStatus(DEFAULT_VIP_STATUS)
            .quantity(DEFAULT_QUANTITY)
            .turndownStatus(DEFAULT_TURNDOWN_STATUS)
            .bookedRoomCategory(DEFAULT_BOOKED_ROOM_CATEGORY)
            .sourceProfId(DEFAULT_SOURCE_PROF_ID);
        return reservationSummary;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReservationSummary createUpdatedEntity(EntityManager em) {
        ReservationSummary reservationSummary = new ReservationSummary()
            .resort(UPDATED_RESORT)
            .eventType(UPDATED_EVENT_TYPE)
            .eventId(UPDATED_EVENT_ID)
            .consideredDate(UPDATED_CONSIDERED_DATE)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .roomClass(UPDATED_ROOM_CLASS)
            .marketCode(UPDATED_MARKET_CODE)
            .sourceCode(UPDATED_SOURCE_CODE)
            .rateCode(UPDATED_RATE_CODE)
            .regionCode(UPDATED_REGION_CODE)
            .groupId(UPDATED_GROUP_ID)
            .resvType(UPDATED_RESV_TYPE)
            .resvInvType(UPDATED_RESV_INV_TYPE)
            .psuedoRoomYn(UPDATED_PSUEDO_ROOM_YN)
            .arrRooms(UPDATED_ARR_ROOMS)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .depRooms(UPDATED_DEP_ROOMS)
            .noRooms(UPDATED_NO_ROOMS)
            .grossRate(UPDATED_GROSS_RATE)
            .netRoomRevenue(UPDATED_NET_ROOM_REVENUE)
            .extraRevenue(UPDATED_EXTRA_REVENUE)
            .ooRooms(UPDATED_OO_ROOMS)
            .osRooms(UPDATED_OS_ROOMS)
            .remainingBlockRooms(UPDATED_REMAINING_BLOCK_ROOMS)
            .pickedupBlockRooms(UPDATED_PICKEDUP_BLOCK_ROOMS)
            .singleOccupancy(UPDATED_SINGLE_OCCUPANCY)
            .multipleOccupancy(UPDATED_MULTIPLE_OCCUPANCY)
            .blockStatus(UPDATED_BLOCK_STATUS)
            .arrPersons(UPDATED_ARR_PERSONS)
            .depPersons(UPDATED_DEP_PERSONS)
            .wlRooms(UPDATED_WL_ROOMS)
            .wlPersons(UPDATED_WL_PERSONS)
            .dayUseRooms(UPDATED_DAY_USE_ROOMS)
            .dayUsePersons(UPDATED_DAY_USE_PERSONS)
            .bookingStatus(UPDATED_BOOKING_STATUS)
            .resvStatus(UPDATED_RESV_STATUS)
            .dayUseYn(UPDATED_DAY_USE_YN)
            .channel(UPDATED_CHANNEL)
            .country(UPDATED_COUNTRY)
            .nationality(UPDATED_NATIONALITY)
            .cribs(UPDATED_CRIBS)
            .extraBeds(UPDATED_EXTRA_BEDS)
            .adultsTaxFree(UPDATED_ADULTS_TAX_FREE)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .rateCategory(UPDATED_RATE_CATEGORY)
            .rateClass(UPDATED_RATE_CLASS)
            .roomRevenue(UPDATED_ROOM_REVENUE)
            .foodRevenue(UPDATED_FOOD_REVENUE)
            .otherRevenue(UPDATED_OTHER_REVENUE)
            .totalRevenue(UPDATED_TOTAL_REVENUE)
            .nonRevenue(UPDATED_NON_REVENUE)
            .allotmentHeaderId(UPDATED_ALLOTMENT_HEADER_ID)
            .roomRevenueTax(UPDATED_ROOM_REVENUE_TAX)
            .foodRevenueTax(UPDATED_FOOD_REVENUE_TAX)
            .otherRevenueTax(UPDATED_OTHER_REVENUE_TAX)
            .totalRevenueTax(UPDATED_TOTAL_REVENUE_TAX)
            .nonRevenueTax(UPDATED_NON_REVENUE_TAX)
            .city(UPDATED_CITY)
            .zipCode(UPDATED_ZIP_CODE)
            .district(UPDATED_DISTRICT)
            .state(UPDATED_STATE)
            .children1(UPDATED_CHILDREN_1)
            .children2(UPDATED_CHILDREN_2)
            .children3(UPDATED_CHILDREN_3)
            .children4(UPDATED_CHILDREN_4)
            .children5(UPDATED_CHILDREN_5)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .ownerRentalFlag(UPDATED_OWNER_RENTAL_FLAG)
            .fcGrossRate(UPDATED_FC_GROSS_RATE)
            .fcNetRoomRevenue(UPDATED_FC_NET_ROOM_REVENUE)
            .fcExtraRevenue(UPDATED_FC_EXTRA_REVENUE)
            .fcRoomRevenue(UPDATED_FC_ROOM_REVENUE)
            .fcFoodRevenue(UPDATED_FC_FOOD_REVENUE)
            .fcOtherRevenue(UPDATED_FC_OTHER_REVENUE)
            .fcTotalRevenue(UPDATED_FC_TOTAL_REVENUE)
            .fcNonRevenue(UPDATED_FC_NON_REVENUE)
            .fcRoomRevenueTax(UPDATED_FC_ROOM_REVENUE_TAX)
            .fcFoodRevenueTax(UPDATED_FC_FOOD_REVENUE_TAX)
            .fcOtherRevenueTax(UPDATED_FC_OTHER_REVENUE_TAX)
            .fcTotalRevenueTax(UPDATED_FC_TOTAL_REVENUE_TAX)
            .fcNonRevenueTax(UPDATED_FC_NON_REVENUE_TAX)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .exchangeDate(UPDATED_EXCHANGE_DATE)
            .updateBusinessDate(UPDATED_UPDATE_BUSINESS_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .centralCurrencyCode(UPDATED_CENTRAL_CURRENCY_CODE)
            .centralExchangeRate(UPDATED_CENTRAL_EXCHANGE_RATE)
            .truncBeginDate(UPDATED_TRUNC_BEGIN_DATE)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .businessDateCreated(UPDATED_BUSINESS_DATE_CREATED)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .parentCompanyId(UPDATED_PARENT_COMPANY_ID)
            .agentId(UPDATED_AGENT_ID)
            .gender(UPDATED_GENDER)
            .vipStatus(UPDATED_VIP_STATUS)
            .quantity(UPDATED_QUANTITY)
            .turndownStatus(UPDATED_TURNDOWN_STATUS)
            .bookedRoomCategory(UPDATED_BOOKED_ROOM_CATEGORY)
            .sourceProfId(UPDATED_SOURCE_PROF_ID);
        return reservationSummary;
    }

    @BeforeEach
    public void initTest() {
        reservationSummary = createEntity(em);
    }

    @Test
    @Transactional
    void createReservationSummary() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ReservationSummary
        var returnedReservationSummary = om.readValue(
            restReservationSummaryMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationSummary)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ReservationSummary.class
        );

        // Validate the ReservationSummary in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertReservationSummaryUpdatableFieldsEquals(
            returnedReservationSummary,
            getPersistedReservationSummary(returnedReservationSummary)
        );
    }

    @Test
    @Transactional
    void createReservationSummaryWithExistingId() throws Exception {
        // Create the ReservationSummary with an existing ID
        reservationSummary.setId(1);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restReservationSummaryMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationSummary)))
            .andExpect(status().isBadRequest());

        // Validate the ReservationSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllReservationSummaries() throws Exception {
        // Initialize the database
        reservationSummaryRepository.saveAndFlush(reservationSummary);

        // Get all the reservationSummaryList
        restReservationSummaryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reservationSummary.getId().intValue())))
            .andExpect(jsonPath("$.[*].resort").value(hasItem(DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].eventType").value(hasItem(DEFAULT_EVENT_TYPE)))
            .andExpect(jsonPath("$.[*].eventId").value(hasItem(DEFAULT_EVENT_ID)))
            .andExpect(jsonPath("$.[*].consideredDate").value(hasItem(DEFAULT_CONSIDERED_DATE.toString())))
            .andExpect(jsonPath("$.[*].roomCategory").value(hasItem(DEFAULT_ROOM_CATEGORY)))
            .andExpect(jsonPath("$.[*].roomClass").value(hasItem(DEFAULT_ROOM_CLASS)))
            .andExpect(jsonPath("$.[*].marketCode").value(hasItem(DEFAULT_MARKET_CODE)))
            .andExpect(jsonPath("$.[*].sourceCode").value(hasItem(DEFAULT_SOURCE_CODE)))
            .andExpect(jsonPath("$.[*].rateCode").value(hasItem(DEFAULT_RATE_CODE)))
            .andExpect(jsonPath("$.[*].regionCode").value(hasItem(DEFAULT_REGION_CODE)))
            .andExpect(jsonPath("$.[*].groupId").value(hasItem(DEFAULT_GROUP_ID)))
            .andExpect(jsonPath("$.[*].resvType").value(hasItem(DEFAULT_RESV_TYPE)))
            .andExpect(jsonPath("$.[*].resvInvType").value(hasItem(DEFAULT_RESV_INV_TYPE)))
            .andExpect(jsonPath("$.[*].psuedoRoomYn").value(hasItem(DEFAULT_PSUEDO_ROOM_YN)))
            .andExpect(jsonPath("$.[*].arrRooms").value(hasItem(DEFAULT_ARR_ROOMS)))
            .andExpect(jsonPath("$.[*].adults").value(hasItem(DEFAULT_ADULTS)))
            .andExpect(jsonPath("$.[*].children").value(hasItem(DEFAULT_CHILDREN)))
            .andExpect(jsonPath("$.[*].depRooms").value(hasItem(DEFAULT_DEP_ROOMS)))
            .andExpect(jsonPath("$.[*].noRooms").value(hasItem(DEFAULT_NO_ROOMS)))
            .andExpect(jsonPath("$.[*].grossRate").value(hasItem(sameNumber(DEFAULT_GROSS_RATE))))
            .andExpect(jsonPath("$.[*].netRoomRevenue").value(hasItem(sameNumber(DEFAULT_NET_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].extraRevenue").value(hasItem(sameNumber(DEFAULT_EXTRA_REVENUE))))
            .andExpect(jsonPath("$.[*].ooRooms").value(hasItem(DEFAULT_OO_ROOMS)))
            .andExpect(jsonPath("$.[*].osRooms").value(hasItem(DEFAULT_OS_ROOMS)))
            .andExpect(jsonPath("$.[*].remainingBlockRooms").value(hasItem(DEFAULT_REMAINING_BLOCK_ROOMS)))
            .andExpect(jsonPath("$.[*].pickedupBlockRooms").value(hasItem(DEFAULT_PICKEDUP_BLOCK_ROOMS)))
            .andExpect(jsonPath("$.[*].singleOccupancy").value(hasItem(DEFAULT_SINGLE_OCCUPANCY)))
            .andExpect(jsonPath("$.[*].multipleOccupancy").value(hasItem(DEFAULT_MULTIPLE_OCCUPANCY)))
            .andExpect(jsonPath("$.[*].blockStatus").value(hasItem(DEFAULT_BLOCK_STATUS)))
            .andExpect(jsonPath("$.[*].arrPersons").value(hasItem(DEFAULT_ARR_PERSONS)))
            .andExpect(jsonPath("$.[*].depPersons").value(hasItem(DEFAULT_DEP_PERSONS)))
            .andExpect(jsonPath("$.[*].wlRooms").value(hasItem(DEFAULT_WL_ROOMS)))
            .andExpect(jsonPath("$.[*].wlPersons").value(hasItem(DEFAULT_WL_PERSONS)))
            .andExpect(jsonPath("$.[*].dayUseRooms").value(hasItem(DEFAULT_DAY_USE_ROOMS)))
            .andExpect(jsonPath("$.[*].dayUsePersons").value(hasItem(DEFAULT_DAY_USE_PERSONS)))
            .andExpect(jsonPath("$.[*].bookingStatus").value(hasItem(DEFAULT_BOOKING_STATUS)))
            .andExpect(jsonPath("$.[*].resvStatus").value(hasItem(DEFAULT_RESV_STATUS)))
            .andExpect(jsonPath("$.[*].dayUseYn").value(hasItem(DEFAULT_DAY_USE_YN)))
            .andExpect(jsonPath("$.[*].channel").value(hasItem(DEFAULT_CHANNEL)))
            .andExpect(jsonPath("$.[*].country").value(hasItem(DEFAULT_COUNTRY)))
            .andExpect(jsonPath("$.[*].nationality").value(hasItem(DEFAULT_NATIONALITY)))
            .andExpect(jsonPath("$.[*].cribs").value(hasItem(DEFAULT_CRIBS)))
            .andExpect(jsonPath("$.[*].extraBeds").value(hasItem(DEFAULT_EXTRA_BEDS)))
            .andExpect(jsonPath("$.[*].adultsTaxFree").value(hasItem(DEFAULT_ADULTS_TAX_FREE)))
            .andExpect(jsonPath("$.[*].childrenTaxFree").value(hasItem(DEFAULT_CHILDREN_TAX_FREE)))
            .andExpect(jsonPath("$.[*].rateCategory").value(hasItem(DEFAULT_RATE_CATEGORY)))
            .andExpect(jsonPath("$.[*].rateClass").value(hasItem(DEFAULT_RATE_CLASS)))
            .andExpect(jsonPath("$.[*].roomRevenue").value(hasItem(sameNumber(DEFAULT_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].foodRevenue").value(hasItem(sameNumber(DEFAULT_FOOD_REVENUE))))
            .andExpect(jsonPath("$.[*].otherRevenue").value(hasItem(sameNumber(DEFAULT_OTHER_REVENUE))))
            .andExpect(jsonPath("$.[*].totalRevenue").value(hasItem(sameNumber(DEFAULT_TOTAL_REVENUE))))
            .andExpect(jsonPath("$.[*].nonRevenue").value(hasItem(sameNumber(DEFAULT_NON_REVENUE))))
            .andExpect(jsonPath("$.[*].allotmentHeaderId").value(hasItem(DEFAULT_ALLOTMENT_HEADER_ID)))
            .andExpect(jsonPath("$.[*].roomRevenueTax").value(hasItem(sameNumber(DEFAULT_ROOM_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].foodRevenueTax").value(hasItem(sameNumber(DEFAULT_FOOD_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].otherRevenueTax").value(hasItem(sameNumber(DEFAULT_OTHER_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].totalRevenueTax").value(hasItem(sameNumber(DEFAULT_TOTAL_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].nonRevenueTax").value(hasItem(sameNumber(DEFAULT_NON_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY)))
            .andExpect(jsonPath("$.[*].zipCode").value(hasItem(DEFAULT_ZIP_CODE)))
            .andExpect(jsonPath("$.[*].district").value(hasItem(DEFAULT_DISTRICT)))
            .andExpect(jsonPath("$.[*].state").value(hasItem(DEFAULT_STATE)))
            .andExpect(jsonPath("$.[*].children1").value(hasItem(DEFAULT_CHILDREN_1)))
            .andExpect(jsonPath("$.[*].children2").value(hasItem(DEFAULT_CHILDREN_2)))
            .andExpect(jsonPath("$.[*].children3").value(hasItem(DEFAULT_CHILDREN_3)))
            .andExpect(jsonPath("$.[*].children4").value(hasItem(DEFAULT_CHILDREN_4)))
            .andExpect(jsonPath("$.[*].children5").value(hasItem(DEFAULT_CHILDREN_5)))
            .andExpect(jsonPath("$.[*].ownerFfFlag").value(hasItem(DEFAULT_OWNER_FF_FLAG)))
            .andExpect(jsonPath("$.[*].ownerRentalFlag").value(hasItem(DEFAULT_OWNER_RENTAL_FLAG)))
            .andExpect(jsonPath("$.[*].fcGrossRate").value(hasItem(sameNumber(DEFAULT_FC_GROSS_RATE))))
            .andExpect(jsonPath("$.[*].fcNetRoomRevenue").value(hasItem(sameNumber(DEFAULT_FC_NET_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].fcExtraRevenue").value(hasItem(sameNumber(DEFAULT_FC_EXTRA_REVENUE))))
            .andExpect(jsonPath("$.[*].fcRoomRevenue").value(hasItem(sameNumber(DEFAULT_FC_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].fcFoodRevenue").value(hasItem(sameNumber(DEFAULT_FC_FOOD_REVENUE))))
            .andExpect(jsonPath("$.[*].fcOtherRevenue").value(hasItem(sameNumber(DEFAULT_FC_OTHER_REVENUE))))
            .andExpect(jsonPath("$.[*].fcTotalRevenue").value(hasItem(sameNumber(DEFAULT_FC_TOTAL_REVENUE))))
            .andExpect(jsonPath("$.[*].fcNonRevenue").value(hasItem(sameNumber(DEFAULT_FC_NON_REVENUE))))
            .andExpect(jsonPath("$.[*].fcRoomRevenueTax").value(hasItem(sameNumber(DEFAULT_FC_ROOM_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].fcFoodRevenueTax").value(hasItem(sameNumber(DEFAULT_FC_FOOD_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].fcOtherRevenueTax").value(hasItem(sameNumber(DEFAULT_FC_OTHER_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].fcTotalRevenueTax").value(hasItem(sameNumber(DEFAULT_FC_TOTAL_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].fcNonRevenueTax").value(hasItem(sameNumber(DEFAULT_FC_NON_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].currencyCode").value(hasItem(DEFAULT_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].exchangeDate").value(hasItem(DEFAULT_EXCHANGE_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateBusinessDate").value(hasItem(DEFAULT_UPDATE_BUSINESS_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].centralCurrencyCode").value(hasItem(DEFAULT_CENTRAL_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].centralExchangeRate").value(hasItem(sameNumber(DEFAULT_CENTRAL_EXCHANGE_RATE))))
            .andExpect(jsonPath("$.[*].truncBeginDate").value(hasItem(DEFAULT_TRUNC_BEGIN_DATE.toString())))
            .andExpect(jsonPath("$.[*].truncEndDate").value(hasItem(DEFAULT_TRUNC_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].businessDateCreated").value(hasItem(DEFAULT_BUSINESS_DATE_CREATED.toString())))
            .andExpect(jsonPath("$.[*].resInsertSource").value(hasItem(DEFAULT_RES_INSERT_SOURCE)))
            .andExpect(jsonPath("$.[*].parentCompanyId").value(hasItem(DEFAULT_PARENT_COMPANY_ID)))
            .andExpect(jsonPath("$.[*].agentId").value(hasItem(DEFAULT_AGENT_ID)))
            .andExpect(jsonPath("$.[*].gender").value(hasItem(DEFAULT_GENDER)))
            .andExpect(jsonPath("$.[*].vipStatus").value(hasItem(DEFAULT_VIP_STATUS)))
            .andExpect(jsonPath("$.[*].quantity").value(hasItem(DEFAULT_QUANTITY)))
            .andExpect(jsonPath("$.[*].turndownStatus").value(hasItem(DEFAULT_TURNDOWN_STATUS)))
            .andExpect(jsonPath("$.[*].bookedRoomCategory").value(hasItem(DEFAULT_BOOKED_ROOM_CATEGORY)))
            .andExpect(jsonPath("$.[*].sourceProfId").value(hasItem(DEFAULT_SOURCE_PROF_ID)));
    }

    @Test
    @Transactional
    void getReservationSummary() throws Exception {
        // Initialize the database
        reservationSummaryRepository.saveAndFlush(reservationSummary);

        // Get the reservationSummary
        restReservationSummaryMockMvc
            .perform(get(ENTITY_API_URL_ID, reservationSummary.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(reservationSummary.getId().intValue()))
            .andExpect(jsonPath("$.resort").value(DEFAULT_RESORT))
            .andExpect(jsonPath("$.eventType").value(DEFAULT_EVENT_TYPE))
            .andExpect(jsonPath("$.eventId").value(DEFAULT_EVENT_ID))
            .andExpect(jsonPath("$.consideredDate").value(DEFAULT_CONSIDERED_DATE.toString()))
            .andExpect(jsonPath("$.roomCategory").value(DEFAULT_ROOM_CATEGORY))
            .andExpect(jsonPath("$.roomClass").value(DEFAULT_ROOM_CLASS))
            .andExpect(jsonPath("$.marketCode").value(DEFAULT_MARKET_CODE))
            .andExpect(jsonPath("$.sourceCode").value(DEFAULT_SOURCE_CODE))
            .andExpect(jsonPath("$.rateCode").value(DEFAULT_RATE_CODE))
            .andExpect(jsonPath("$.regionCode").value(DEFAULT_REGION_CODE))
            .andExpect(jsonPath("$.groupId").value(DEFAULT_GROUP_ID))
            .andExpect(jsonPath("$.resvType").value(DEFAULT_RESV_TYPE))
            .andExpect(jsonPath("$.resvInvType").value(DEFAULT_RESV_INV_TYPE))
            .andExpect(jsonPath("$.psuedoRoomYn").value(DEFAULT_PSUEDO_ROOM_YN))
            .andExpect(jsonPath("$.arrRooms").value(DEFAULT_ARR_ROOMS))
            .andExpect(jsonPath("$.adults").value(DEFAULT_ADULTS))
            .andExpect(jsonPath("$.children").value(DEFAULT_CHILDREN))
            .andExpect(jsonPath("$.depRooms").value(DEFAULT_DEP_ROOMS))
            .andExpect(jsonPath("$.noRooms").value(DEFAULT_NO_ROOMS))
            .andExpect(jsonPath("$.grossRate").value(sameNumber(DEFAULT_GROSS_RATE)))
            .andExpect(jsonPath("$.netRoomRevenue").value(sameNumber(DEFAULT_NET_ROOM_REVENUE)))
            .andExpect(jsonPath("$.extraRevenue").value(sameNumber(DEFAULT_EXTRA_REVENUE)))
            .andExpect(jsonPath("$.ooRooms").value(DEFAULT_OO_ROOMS))
            .andExpect(jsonPath("$.osRooms").value(DEFAULT_OS_ROOMS))
            .andExpect(jsonPath("$.remainingBlockRooms").value(DEFAULT_REMAINING_BLOCK_ROOMS))
            .andExpect(jsonPath("$.pickedupBlockRooms").value(DEFAULT_PICKEDUP_BLOCK_ROOMS))
            .andExpect(jsonPath("$.singleOccupancy").value(DEFAULT_SINGLE_OCCUPANCY))
            .andExpect(jsonPath("$.multipleOccupancy").value(DEFAULT_MULTIPLE_OCCUPANCY))
            .andExpect(jsonPath("$.blockStatus").value(DEFAULT_BLOCK_STATUS))
            .andExpect(jsonPath("$.arrPersons").value(DEFAULT_ARR_PERSONS))
            .andExpect(jsonPath("$.depPersons").value(DEFAULT_DEP_PERSONS))
            .andExpect(jsonPath("$.wlRooms").value(DEFAULT_WL_ROOMS))
            .andExpect(jsonPath("$.wlPersons").value(DEFAULT_WL_PERSONS))
            .andExpect(jsonPath("$.dayUseRooms").value(DEFAULT_DAY_USE_ROOMS))
            .andExpect(jsonPath("$.dayUsePersons").value(DEFAULT_DAY_USE_PERSONS))
            .andExpect(jsonPath("$.bookingStatus").value(DEFAULT_BOOKING_STATUS))
            .andExpect(jsonPath("$.resvStatus").value(DEFAULT_RESV_STATUS))
            .andExpect(jsonPath("$.dayUseYn").value(DEFAULT_DAY_USE_YN))
            .andExpect(jsonPath("$.channel").value(DEFAULT_CHANNEL))
            .andExpect(jsonPath("$.country").value(DEFAULT_COUNTRY))
            .andExpect(jsonPath("$.nationality").value(DEFAULT_NATIONALITY))
            .andExpect(jsonPath("$.cribs").value(DEFAULT_CRIBS))
            .andExpect(jsonPath("$.extraBeds").value(DEFAULT_EXTRA_BEDS))
            .andExpect(jsonPath("$.adultsTaxFree").value(DEFAULT_ADULTS_TAX_FREE))
            .andExpect(jsonPath("$.childrenTaxFree").value(DEFAULT_CHILDREN_TAX_FREE))
            .andExpect(jsonPath("$.rateCategory").value(DEFAULT_RATE_CATEGORY))
            .andExpect(jsonPath("$.rateClass").value(DEFAULT_RATE_CLASS))
            .andExpect(jsonPath("$.roomRevenue").value(sameNumber(DEFAULT_ROOM_REVENUE)))
            .andExpect(jsonPath("$.foodRevenue").value(sameNumber(DEFAULT_FOOD_REVENUE)))
            .andExpect(jsonPath("$.otherRevenue").value(sameNumber(DEFAULT_OTHER_REVENUE)))
            .andExpect(jsonPath("$.totalRevenue").value(sameNumber(DEFAULT_TOTAL_REVENUE)))
            .andExpect(jsonPath("$.nonRevenue").value(sameNumber(DEFAULT_NON_REVENUE)))
            .andExpect(jsonPath("$.allotmentHeaderId").value(DEFAULT_ALLOTMENT_HEADER_ID))
            .andExpect(jsonPath("$.roomRevenueTax").value(sameNumber(DEFAULT_ROOM_REVENUE_TAX)))
            .andExpect(jsonPath("$.foodRevenueTax").value(sameNumber(DEFAULT_FOOD_REVENUE_TAX)))
            .andExpect(jsonPath("$.otherRevenueTax").value(sameNumber(DEFAULT_OTHER_REVENUE_TAX)))
            .andExpect(jsonPath("$.totalRevenueTax").value(sameNumber(DEFAULT_TOTAL_REVENUE_TAX)))
            .andExpect(jsonPath("$.nonRevenueTax").value(sameNumber(DEFAULT_NON_REVENUE_TAX)))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY))
            .andExpect(jsonPath("$.zipCode").value(DEFAULT_ZIP_CODE))
            .andExpect(jsonPath("$.district").value(DEFAULT_DISTRICT))
            .andExpect(jsonPath("$.state").value(DEFAULT_STATE))
            .andExpect(jsonPath("$.children1").value(DEFAULT_CHILDREN_1))
            .andExpect(jsonPath("$.children2").value(DEFAULT_CHILDREN_2))
            .andExpect(jsonPath("$.children3").value(DEFAULT_CHILDREN_3))
            .andExpect(jsonPath("$.children4").value(DEFAULT_CHILDREN_4))
            .andExpect(jsonPath("$.children5").value(DEFAULT_CHILDREN_5))
            .andExpect(jsonPath("$.ownerFfFlag").value(DEFAULT_OWNER_FF_FLAG))
            .andExpect(jsonPath("$.ownerRentalFlag").value(DEFAULT_OWNER_RENTAL_FLAG))
            .andExpect(jsonPath("$.fcGrossRate").value(sameNumber(DEFAULT_FC_GROSS_RATE)))
            .andExpect(jsonPath("$.fcNetRoomRevenue").value(sameNumber(DEFAULT_FC_NET_ROOM_REVENUE)))
            .andExpect(jsonPath("$.fcExtraRevenue").value(sameNumber(DEFAULT_FC_EXTRA_REVENUE)))
            .andExpect(jsonPath("$.fcRoomRevenue").value(sameNumber(DEFAULT_FC_ROOM_REVENUE)))
            .andExpect(jsonPath("$.fcFoodRevenue").value(sameNumber(DEFAULT_FC_FOOD_REVENUE)))
            .andExpect(jsonPath("$.fcOtherRevenue").value(sameNumber(DEFAULT_FC_OTHER_REVENUE)))
            .andExpect(jsonPath("$.fcTotalRevenue").value(sameNumber(DEFAULT_FC_TOTAL_REVENUE)))
            .andExpect(jsonPath("$.fcNonRevenue").value(sameNumber(DEFAULT_FC_NON_REVENUE)))
            .andExpect(jsonPath("$.fcRoomRevenueTax").value(sameNumber(DEFAULT_FC_ROOM_REVENUE_TAX)))
            .andExpect(jsonPath("$.fcFoodRevenueTax").value(sameNumber(DEFAULT_FC_FOOD_REVENUE_TAX)))
            .andExpect(jsonPath("$.fcOtherRevenueTax").value(sameNumber(DEFAULT_FC_OTHER_REVENUE_TAX)))
            .andExpect(jsonPath("$.fcTotalRevenueTax").value(sameNumber(DEFAULT_FC_TOTAL_REVENUE_TAX)))
            .andExpect(jsonPath("$.fcNonRevenueTax").value(sameNumber(DEFAULT_FC_NON_REVENUE_TAX)))
            .andExpect(jsonPath("$.currencyCode").value(DEFAULT_CURRENCY_CODE))
            .andExpect(jsonPath("$.exchangeDate").value(DEFAULT_EXCHANGE_DATE.toString()))
            .andExpect(jsonPath("$.updateBusinessDate").value(DEFAULT_UPDATE_BUSINESS_DATE.toString()))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.centralCurrencyCode").value(DEFAULT_CENTRAL_CURRENCY_CODE))
            .andExpect(jsonPath("$.centralExchangeRate").value(sameNumber(DEFAULT_CENTRAL_EXCHANGE_RATE)))
            .andExpect(jsonPath("$.truncBeginDate").value(DEFAULT_TRUNC_BEGIN_DATE.toString()))
            .andExpect(jsonPath("$.truncEndDate").value(DEFAULT_TRUNC_END_DATE.toString()))
            .andExpect(jsonPath("$.businessDateCreated").value(DEFAULT_BUSINESS_DATE_CREATED.toString()))
            .andExpect(jsonPath("$.resInsertSource").value(DEFAULT_RES_INSERT_SOURCE))
            .andExpect(jsonPath("$.parentCompanyId").value(DEFAULT_PARENT_COMPANY_ID))
            .andExpect(jsonPath("$.agentId").value(DEFAULT_AGENT_ID))
            .andExpect(jsonPath("$.gender").value(DEFAULT_GENDER))
            .andExpect(jsonPath("$.vipStatus").value(DEFAULT_VIP_STATUS))
            .andExpect(jsonPath("$.quantity").value(DEFAULT_QUANTITY))
            .andExpect(jsonPath("$.turndownStatus").value(DEFAULT_TURNDOWN_STATUS))
            .andExpect(jsonPath("$.bookedRoomCategory").value(DEFAULT_BOOKED_ROOM_CATEGORY))
            .andExpect(jsonPath("$.sourceProfId").value(DEFAULT_SOURCE_PROF_ID));
    }

    @Test
    @Transactional
    void getNonExistingReservationSummary() throws Exception {
        // Get the reservationSummary
        restReservationSummaryMockMvc.perform(get(ENTITY_API_URL_ID, Integer.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingReservationSummary() throws Exception {
        // Initialize the database
        reservationSummaryRepository.saveAndFlush(reservationSummary);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationSummary
        ReservationSummary updatedReservationSummary = reservationSummaryRepository.findById(reservationSummary.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedReservationSummary are not directly saved in db
        em.detach(updatedReservationSummary);
        updatedReservationSummary
            .resort(UPDATED_RESORT)
            .eventType(UPDATED_EVENT_TYPE)
            .eventId(UPDATED_EVENT_ID)
            .consideredDate(UPDATED_CONSIDERED_DATE)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .roomClass(UPDATED_ROOM_CLASS)
            .marketCode(UPDATED_MARKET_CODE)
            .sourceCode(UPDATED_SOURCE_CODE)
            .rateCode(UPDATED_RATE_CODE)
            .regionCode(UPDATED_REGION_CODE)
            .groupId(UPDATED_GROUP_ID)
            .resvType(UPDATED_RESV_TYPE)
            .resvInvType(UPDATED_RESV_INV_TYPE)
            .psuedoRoomYn(UPDATED_PSUEDO_ROOM_YN)
            .arrRooms(UPDATED_ARR_ROOMS)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .depRooms(UPDATED_DEP_ROOMS)
            .noRooms(UPDATED_NO_ROOMS)
            .grossRate(UPDATED_GROSS_RATE)
            .netRoomRevenue(UPDATED_NET_ROOM_REVENUE)
            .extraRevenue(UPDATED_EXTRA_REVENUE)
            .ooRooms(UPDATED_OO_ROOMS)
            .osRooms(UPDATED_OS_ROOMS)
            .remainingBlockRooms(UPDATED_REMAINING_BLOCK_ROOMS)
            .pickedupBlockRooms(UPDATED_PICKEDUP_BLOCK_ROOMS)
            .singleOccupancy(UPDATED_SINGLE_OCCUPANCY)
            .multipleOccupancy(UPDATED_MULTIPLE_OCCUPANCY)
            .blockStatus(UPDATED_BLOCK_STATUS)
            .arrPersons(UPDATED_ARR_PERSONS)
            .depPersons(UPDATED_DEP_PERSONS)
            .wlRooms(UPDATED_WL_ROOMS)
            .wlPersons(UPDATED_WL_PERSONS)
            .dayUseRooms(UPDATED_DAY_USE_ROOMS)
            .dayUsePersons(UPDATED_DAY_USE_PERSONS)
            .bookingStatus(UPDATED_BOOKING_STATUS)
            .resvStatus(UPDATED_RESV_STATUS)
            .dayUseYn(UPDATED_DAY_USE_YN)
            .channel(UPDATED_CHANNEL)
            .country(UPDATED_COUNTRY)
            .nationality(UPDATED_NATIONALITY)
            .cribs(UPDATED_CRIBS)
            .extraBeds(UPDATED_EXTRA_BEDS)
            .adultsTaxFree(UPDATED_ADULTS_TAX_FREE)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .rateCategory(UPDATED_RATE_CATEGORY)
            .rateClass(UPDATED_RATE_CLASS)
            .roomRevenue(UPDATED_ROOM_REVENUE)
            .foodRevenue(UPDATED_FOOD_REVENUE)
            .otherRevenue(UPDATED_OTHER_REVENUE)
            .totalRevenue(UPDATED_TOTAL_REVENUE)
            .nonRevenue(UPDATED_NON_REVENUE)
            .allotmentHeaderId(UPDATED_ALLOTMENT_HEADER_ID)
            .roomRevenueTax(UPDATED_ROOM_REVENUE_TAX)
            .foodRevenueTax(UPDATED_FOOD_REVENUE_TAX)
            .otherRevenueTax(UPDATED_OTHER_REVENUE_TAX)
            .totalRevenueTax(UPDATED_TOTAL_REVENUE_TAX)
            .nonRevenueTax(UPDATED_NON_REVENUE_TAX)
            .city(UPDATED_CITY)
            .zipCode(UPDATED_ZIP_CODE)
            .district(UPDATED_DISTRICT)
            .state(UPDATED_STATE)
            .children1(UPDATED_CHILDREN_1)
            .children2(UPDATED_CHILDREN_2)
            .children3(UPDATED_CHILDREN_3)
            .children4(UPDATED_CHILDREN_4)
            .children5(UPDATED_CHILDREN_5)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .ownerRentalFlag(UPDATED_OWNER_RENTAL_FLAG)
            .fcGrossRate(UPDATED_FC_GROSS_RATE)
            .fcNetRoomRevenue(UPDATED_FC_NET_ROOM_REVENUE)
            .fcExtraRevenue(UPDATED_FC_EXTRA_REVENUE)
            .fcRoomRevenue(UPDATED_FC_ROOM_REVENUE)
            .fcFoodRevenue(UPDATED_FC_FOOD_REVENUE)
            .fcOtherRevenue(UPDATED_FC_OTHER_REVENUE)
            .fcTotalRevenue(UPDATED_FC_TOTAL_REVENUE)
            .fcNonRevenue(UPDATED_FC_NON_REVENUE)
            .fcRoomRevenueTax(UPDATED_FC_ROOM_REVENUE_TAX)
            .fcFoodRevenueTax(UPDATED_FC_FOOD_REVENUE_TAX)
            .fcOtherRevenueTax(UPDATED_FC_OTHER_REVENUE_TAX)
            .fcTotalRevenueTax(UPDATED_FC_TOTAL_REVENUE_TAX)
            .fcNonRevenueTax(UPDATED_FC_NON_REVENUE_TAX)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .exchangeDate(UPDATED_EXCHANGE_DATE)
            .updateBusinessDate(UPDATED_UPDATE_BUSINESS_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .centralCurrencyCode(UPDATED_CENTRAL_CURRENCY_CODE)
            .centralExchangeRate(UPDATED_CENTRAL_EXCHANGE_RATE)
            .truncBeginDate(UPDATED_TRUNC_BEGIN_DATE)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .businessDateCreated(UPDATED_BUSINESS_DATE_CREATED)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .parentCompanyId(UPDATED_PARENT_COMPANY_ID)
            .agentId(UPDATED_AGENT_ID)
            .gender(UPDATED_GENDER)
            .vipStatus(UPDATED_VIP_STATUS)
            .quantity(UPDATED_QUANTITY)
            .turndownStatus(UPDATED_TURNDOWN_STATUS)
            .bookedRoomCategory(UPDATED_BOOKED_ROOM_CATEGORY)
            .sourceProfId(UPDATED_SOURCE_PROF_ID);

        restReservationSummaryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedReservationSummary.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedReservationSummary))
            )
            .andExpect(status().isOk());

        // Validate the ReservationSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedReservationSummaryToMatchAllProperties(updatedReservationSummary);
    }

    @Test
    @Transactional
    void putNonExistingReservationSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationSummary.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReservationSummaryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, reservationSummary.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reservationSummary))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchReservationSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationSummary.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationSummaryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reservationSummary))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamReservationSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationSummary.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationSummaryMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationSummary)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReservationSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateReservationSummaryWithPatch() throws Exception {
        // Initialize the database
        reservationSummaryRepository.saveAndFlush(reservationSummary);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationSummary using partial update
        ReservationSummary partialUpdatedReservationSummary = new ReservationSummary();
        partialUpdatedReservationSummary.setId(reservationSummary.getId());

        partialUpdatedReservationSummary
            .eventType(UPDATED_EVENT_TYPE)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .sourceCode(UPDATED_SOURCE_CODE)
            .rateCode(UPDATED_RATE_CODE)
            .regionCode(UPDATED_REGION_CODE)
            .resvType(UPDATED_RESV_TYPE)
            .resvInvType(UPDATED_RESV_INV_TYPE)
            .psuedoRoomYn(UPDATED_PSUEDO_ROOM_YN)
            .adults(UPDATED_ADULTS)
            .grossRate(UPDATED_GROSS_RATE)
            .netRoomRevenue(UPDATED_NET_ROOM_REVENUE)
            .extraRevenue(UPDATED_EXTRA_REVENUE)
            .ooRooms(UPDATED_OO_ROOMS)
            .osRooms(UPDATED_OS_ROOMS)
            .pickedupBlockRooms(UPDATED_PICKEDUP_BLOCK_ROOMS)
            .multipleOccupancy(UPDATED_MULTIPLE_OCCUPANCY)
            .blockStatus(UPDATED_BLOCK_STATUS)
            .depPersons(UPDATED_DEP_PERSONS)
            .wlRooms(UPDATED_WL_ROOMS)
            .dayUseRooms(UPDATED_DAY_USE_ROOMS)
            .dayUseYn(UPDATED_DAY_USE_YN)
            .country(UPDATED_COUNTRY)
            .nationality(UPDATED_NATIONALITY)
            .cribs(UPDATED_CRIBS)
            .rateClass(UPDATED_RATE_CLASS)
            .roomRevenue(UPDATED_ROOM_REVENUE)
            .totalRevenue(UPDATED_TOTAL_REVENUE)
            .nonRevenueTax(UPDATED_NON_REVENUE_TAX)
            .children1(UPDATED_CHILDREN_1)
            .children3(UPDATED_CHILDREN_3)
            .children4(UPDATED_CHILDREN_4)
            .fcGrossRate(UPDATED_FC_GROSS_RATE)
            .fcNetRoomRevenue(UPDATED_FC_NET_ROOM_REVENUE)
            .fcNonRevenue(UPDATED_FC_NON_REVENUE)
            .fcFoodRevenueTax(UPDATED_FC_FOOD_REVENUE_TAX)
            .fcNonRevenueTax(UPDATED_FC_NON_REVENUE_TAX)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .exchangeDate(UPDATED_EXCHANGE_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .centralCurrencyCode(UPDATED_CENTRAL_CURRENCY_CODE)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .parentCompanyId(UPDATED_PARENT_COMPANY_ID)
            .agentId(UPDATED_AGENT_ID)
            .gender(UPDATED_GENDER)
            .turndownStatus(UPDATED_TURNDOWN_STATUS)
            .bookedRoomCategory(UPDATED_BOOKED_ROOM_CATEGORY)
            .sourceProfId(UPDATED_SOURCE_PROF_ID);

        restReservationSummaryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReservationSummary.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReservationSummary))
            )
            .andExpect(status().isOk());

        // Validate the ReservationSummary in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReservationSummaryUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedReservationSummary, reservationSummary),
            getPersistedReservationSummary(reservationSummary)
        );
    }

    @Test
    @Transactional
    void fullUpdateReservationSummaryWithPatch() throws Exception {
        // Initialize the database
        reservationSummaryRepository.saveAndFlush(reservationSummary);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationSummary using partial update
        ReservationSummary partialUpdatedReservationSummary = new ReservationSummary();
        partialUpdatedReservationSummary.setId(reservationSummary.getId());

        partialUpdatedReservationSummary
            .resort(UPDATED_RESORT)
            .eventType(UPDATED_EVENT_TYPE)
            .eventId(UPDATED_EVENT_ID)
            .consideredDate(UPDATED_CONSIDERED_DATE)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .roomClass(UPDATED_ROOM_CLASS)
            .marketCode(UPDATED_MARKET_CODE)
            .sourceCode(UPDATED_SOURCE_CODE)
            .rateCode(UPDATED_RATE_CODE)
            .regionCode(UPDATED_REGION_CODE)
            .groupId(UPDATED_GROUP_ID)
            .resvType(UPDATED_RESV_TYPE)
            .resvInvType(UPDATED_RESV_INV_TYPE)
            .psuedoRoomYn(UPDATED_PSUEDO_ROOM_YN)
            .arrRooms(UPDATED_ARR_ROOMS)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .depRooms(UPDATED_DEP_ROOMS)
            .noRooms(UPDATED_NO_ROOMS)
            .grossRate(UPDATED_GROSS_RATE)
            .netRoomRevenue(UPDATED_NET_ROOM_REVENUE)
            .extraRevenue(UPDATED_EXTRA_REVENUE)
            .ooRooms(UPDATED_OO_ROOMS)
            .osRooms(UPDATED_OS_ROOMS)
            .remainingBlockRooms(UPDATED_REMAINING_BLOCK_ROOMS)
            .pickedupBlockRooms(UPDATED_PICKEDUP_BLOCK_ROOMS)
            .singleOccupancy(UPDATED_SINGLE_OCCUPANCY)
            .multipleOccupancy(UPDATED_MULTIPLE_OCCUPANCY)
            .blockStatus(UPDATED_BLOCK_STATUS)
            .arrPersons(UPDATED_ARR_PERSONS)
            .depPersons(UPDATED_DEP_PERSONS)
            .wlRooms(UPDATED_WL_ROOMS)
            .wlPersons(UPDATED_WL_PERSONS)
            .dayUseRooms(UPDATED_DAY_USE_ROOMS)
            .dayUsePersons(UPDATED_DAY_USE_PERSONS)
            .bookingStatus(UPDATED_BOOKING_STATUS)
            .resvStatus(UPDATED_RESV_STATUS)
            .dayUseYn(UPDATED_DAY_USE_YN)
            .channel(UPDATED_CHANNEL)
            .country(UPDATED_COUNTRY)
            .nationality(UPDATED_NATIONALITY)
            .cribs(UPDATED_CRIBS)
            .extraBeds(UPDATED_EXTRA_BEDS)
            .adultsTaxFree(UPDATED_ADULTS_TAX_FREE)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .rateCategory(UPDATED_RATE_CATEGORY)
            .rateClass(UPDATED_RATE_CLASS)
            .roomRevenue(UPDATED_ROOM_REVENUE)
            .foodRevenue(UPDATED_FOOD_REVENUE)
            .otherRevenue(UPDATED_OTHER_REVENUE)
            .totalRevenue(UPDATED_TOTAL_REVENUE)
            .nonRevenue(UPDATED_NON_REVENUE)
            .allotmentHeaderId(UPDATED_ALLOTMENT_HEADER_ID)
            .roomRevenueTax(UPDATED_ROOM_REVENUE_TAX)
            .foodRevenueTax(UPDATED_FOOD_REVENUE_TAX)
            .otherRevenueTax(UPDATED_OTHER_REVENUE_TAX)
            .totalRevenueTax(UPDATED_TOTAL_REVENUE_TAX)
            .nonRevenueTax(UPDATED_NON_REVENUE_TAX)
            .city(UPDATED_CITY)
            .zipCode(UPDATED_ZIP_CODE)
            .district(UPDATED_DISTRICT)
            .state(UPDATED_STATE)
            .children1(UPDATED_CHILDREN_1)
            .children2(UPDATED_CHILDREN_2)
            .children3(UPDATED_CHILDREN_3)
            .children4(UPDATED_CHILDREN_4)
            .children5(UPDATED_CHILDREN_5)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .ownerRentalFlag(UPDATED_OWNER_RENTAL_FLAG)
            .fcGrossRate(UPDATED_FC_GROSS_RATE)
            .fcNetRoomRevenue(UPDATED_FC_NET_ROOM_REVENUE)
            .fcExtraRevenue(UPDATED_FC_EXTRA_REVENUE)
            .fcRoomRevenue(UPDATED_FC_ROOM_REVENUE)
            .fcFoodRevenue(UPDATED_FC_FOOD_REVENUE)
            .fcOtherRevenue(UPDATED_FC_OTHER_REVENUE)
            .fcTotalRevenue(UPDATED_FC_TOTAL_REVENUE)
            .fcNonRevenue(UPDATED_FC_NON_REVENUE)
            .fcRoomRevenueTax(UPDATED_FC_ROOM_REVENUE_TAX)
            .fcFoodRevenueTax(UPDATED_FC_FOOD_REVENUE_TAX)
            .fcOtherRevenueTax(UPDATED_FC_OTHER_REVENUE_TAX)
            .fcTotalRevenueTax(UPDATED_FC_TOTAL_REVENUE_TAX)
            .fcNonRevenueTax(UPDATED_FC_NON_REVENUE_TAX)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .exchangeDate(UPDATED_EXCHANGE_DATE)
            .updateBusinessDate(UPDATED_UPDATE_BUSINESS_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .centralCurrencyCode(UPDATED_CENTRAL_CURRENCY_CODE)
            .centralExchangeRate(UPDATED_CENTRAL_EXCHANGE_RATE)
            .truncBeginDate(UPDATED_TRUNC_BEGIN_DATE)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .businessDateCreated(UPDATED_BUSINESS_DATE_CREATED)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .parentCompanyId(UPDATED_PARENT_COMPANY_ID)
            .agentId(UPDATED_AGENT_ID)
            .gender(UPDATED_GENDER)
            .vipStatus(UPDATED_VIP_STATUS)
            .quantity(UPDATED_QUANTITY)
            .turndownStatus(UPDATED_TURNDOWN_STATUS)
            .bookedRoomCategory(UPDATED_BOOKED_ROOM_CATEGORY)
            .sourceProfId(UPDATED_SOURCE_PROF_ID);

        restReservationSummaryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReservationSummary.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReservationSummary))
            )
            .andExpect(status().isOk());

        // Validate the ReservationSummary in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReservationSummaryUpdatableFieldsEquals(
            partialUpdatedReservationSummary,
            getPersistedReservationSummary(partialUpdatedReservationSummary)
        );
    }

    @Test
    @Transactional
    void patchNonExistingReservationSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationSummary.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReservationSummaryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, reservationSummary.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reservationSummary))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchReservationSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationSummary.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationSummaryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reservationSummary))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamReservationSummary() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationSummary.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationSummaryMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(reservationSummary)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReservationSummary in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteReservationSummary() throws Exception {
        // Initialize the database
        reservationSummaryRepository.saveAndFlush(reservationSummary);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the reservationSummary
        restReservationSummaryMockMvc
            .perform(delete(ENTITY_API_URL_ID, reservationSummary.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return reservationSummaryRepository.count();
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

    protected ReservationSummary getPersistedReservationSummary(ReservationSummary reservationSummary) {
        return reservationSummaryRepository.findById(reservationSummary.getId()).orElseThrow();
    }

    protected void assertPersistedReservationSummaryToMatchAllProperties(ReservationSummary expectedReservationSummary) {
        assertReservationSummaryAllPropertiesEquals(expectedReservationSummary, getPersistedReservationSummary(expectedReservationSummary));
    }

    protected void assertPersistedReservationSummaryToMatchUpdatableProperties(ReservationSummary expectedReservationSummary) {
        assertReservationSummaryAllUpdatablePropertiesEquals(
            expectedReservationSummary,
            getPersistedReservationSummary(expectedReservationSummary)
        );
    }
}
