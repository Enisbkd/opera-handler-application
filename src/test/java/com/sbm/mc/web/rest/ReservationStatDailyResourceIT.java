package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.ReservationStatDailyAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static com.sbm.mc.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.ReservationStatDaily;
import com.sbm.mc.repository.ReservationStatDailyRepository;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
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
 * Integration tests for the {@link ReservationStatDailyResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ReservationStatDailyResourceIT {

    private static final String DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_RESORT = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_BUSINESS_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BUSINESS_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_NAME_ID = 1;
    private static final Integer UPDATED_NAME_ID = 2;

    private static final String DEFAULT_RATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_RATE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_MARKET_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MARKET_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_CATEGORY = "BBBBBBBBBB";

    private static final Integer DEFAULT_COMPANY_ID = 1;
    private static final Integer UPDATED_COMPANY_ID = 2;

    private static final Integer DEFAULT_AGENT_ID = 1;
    private static final Integer UPDATED_AGENT_ID = 2;

    private static final Integer DEFAULT_GROUP_ID = 1;
    private static final Integer UPDATED_GROUP_ID = 2;

    private static final Integer DEFAULT_SOURCE_PROF_ID = 1;
    private static final Integer UPDATED_SOURCE_PROF_ID = 2;

    private static final String DEFAULT_RESV_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_RESV_STATUS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_TRUNC_BEGIN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRUNC_BEGIN_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRUNC_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRUNC_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_RESV_NAME_ID = 1;
    private static final Integer UPDATED_RESV_NAME_ID = 2;

    private static final Integer DEFAULT_QUANTITY = 1;
    private static final Integer UPDATED_QUANTITY = 2;

    private static final Integer DEFAULT_PHYSICAL_QUANTITY = 1;
    private static final Integer UPDATED_PHYSICAL_QUANTITY = 2;

    private static final String DEFAULT_DUE_OUT_YN = "AAAAAAAAAA";
    private static final String UPDATED_DUE_OUT_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_RESV_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_RESV_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_ADULTS = 1;
    private static final Integer UPDATED_ADULTS = 2;

    private static final Integer DEFAULT_CHILDREN = 1;
    private static final Integer UPDATED_CHILDREN = 2;

    private static final Integer DEFAULT_ROOM_ADULTS = 1;
    private static final Integer UPDATED_ROOM_ADULTS = 2;

    private static final Integer DEFAULT_ROOM_CHILDREN = 1;
    private static final Integer UPDATED_ROOM_CHILDREN = 2;

    private static final Integer DEFAULT_PRIMARY_YN = 1;
    private static final Integer UPDATED_PRIMARY_YN = 2;

    private static final Integer DEFAULT_ALLOTMENT_HEADER_ID = 1;
    private static final Integer UPDATED_ALLOTMENT_HEADER_ID = 2;

    private static final BigDecimal DEFAULT_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FOOD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FOOD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACKAGE_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACKAGE_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACKAGE_FOOD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACKAGE_FOOD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_ROOM_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_ROOM_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_FOOD_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_FOOD_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_PACKAGE_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_PACKAGE_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_TAX = new BigDecimal(2);

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_ORIGINAL_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ORIGINAL_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_WALKIN_YN = "AAAAAAAAAA";
    private static final String UPDATED_WALKIN_YN = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_RESERVATION_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RESERVATION_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ROOM_CLASS = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_CLASS = "BBBBBBBBBB";

    private static final String DEFAULT_VIP_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_VIP_STATUS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CANCELLATION_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CANCELLATION_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_BIRTH_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BIRTH_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ROOM = "AAAAAAAAAA";
    private static final String UPDATED_ROOM = "BBBBBBBBBB";

    private static final Integer DEFAULT_MEMBERSHIP_ID = 1;
    private static final Integer UPDATED_MEMBERSHIP_ID = 2;

    private static final Integer DEFAULT_CONTACT_ID = 1;
    private static final Integer UPDATED_CONTACT_ID = 2;

    private static final String DEFAULT_RATE_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_RATE_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_MARKET_MAIN_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_MARKET_MAIN_GROUP = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE_MAIN_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_MAIN_GROUP = "BBBBBBBBBB";

    private static final String DEFAULT_CHANNEL = "AAAAAAAAAA";
    private static final String UPDATED_CHANNEL = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY = "BBBBBBBBBB";

    private static final String DEFAULT_REGION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_REGION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NATIONALITY = "AAAAAAAAAA";
    private static final String UPDATED_NATIONALITY = "BBBBBBBBBB";

    private static final String DEFAULT_PSUEDO_ROOM_YN = "AAAAAAAAAA";
    private static final String UPDATED_PSUEDO_ROOM_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_ADULTS_TAX_FREE = 1;
    private static final Integer UPDATED_ADULTS_TAX_FREE = 2;

    private static final Integer DEFAULT_CHILDREN_TAX_FREE = 1;
    private static final Integer UPDATED_CHILDREN_TAX_FREE = 2;

    private static final Integer DEFAULT_STAY_ROOMS = 1;
    private static final Integer UPDATED_STAY_ROOMS = 2;

    private static final Integer DEFAULT_STAY_PERSONS = 1;
    private static final Integer UPDATED_STAY_PERSONS = 2;

    private static final Integer DEFAULT_STAY_ADULTS = 1;
    private static final Integer UPDATED_STAY_ADULTS = 2;

    private static final Integer DEFAULT_STAY_CHILDREN = 1;
    private static final Integer UPDATED_STAY_CHILDREN = 2;

    private static final Integer DEFAULT_ARR_ROOMS = 1;
    private static final Integer UPDATED_ARR_ROOMS = 2;

    private static final Integer DEFAULT_ARR_PERSONS = 1;
    private static final Integer UPDATED_ARR_PERSONS = 2;

    private static final Integer DEFAULT_DEP_ROOMS = 1;
    private static final Integer UPDATED_DEP_ROOMS = 2;

    private static final Integer DEFAULT_DEP_PERSONS = 1;
    private static final Integer UPDATED_DEP_PERSONS = 2;

    private static final Integer DEFAULT_DAY_USE_ROOMS = 1;
    private static final Integer UPDATED_DAY_USE_ROOMS = 2;

    private static final Integer DEFAULT_DAY_USE_PERSONS = 1;
    private static final Integer UPDATED_DAY_USE_PERSONS = 2;

    private static final Integer DEFAULT_CANCELLED_ROOMS = 1;
    private static final Integer UPDATED_CANCELLED_ROOMS = 2;

    private static final Integer DEFAULT_CANCELLED_PERSONS = 1;
    private static final Integer UPDATED_CANCELLED_PERSONS = 2;

    private static final Integer DEFAULT_NO_SHOW_ROOMS = 1;
    private static final Integer UPDATED_NO_SHOW_ROOMS = 2;

    private static final Integer DEFAULT_NO_SHOW_PERSONS = 1;
    private static final Integer UPDATED_NO_SHOW_PERSONS = 2;

    private static final Integer DEFAULT_SINGLE_OCCUPANCY = 1;
    private static final Integer UPDATED_SINGLE_OCCUPANCY = 2;

    private static final Integer DEFAULT_MULTIPLE_OCCUPANCY = 1;
    private static final Integer UPDATED_MULTIPLE_OCCUPANCY = 2;

    private static final Integer DEFAULT_CRIBS = 1;
    private static final Integer UPDATED_CRIBS = 2;

    private static final Integer DEFAULT_EXTRA_BEDS = 1;
    private static final Integer UPDATED_EXTRA_BEDS = 2;

    private static final BigDecimal DEFAULT_OTHER_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_OTHER_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACKAGE_OTHER_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACKAGE_OTHER_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_OTHER_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_OTHER_TAX = new BigDecimal(2);

    private static final String DEFAULT_COUNTRY_MAIN_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY_MAIN_GROUP = "BBBBBBBBBB";

    private static final String DEFAULT_STATE = "AAAAAAAAAA";
    private static final String UPDATED_STATE = "BBBBBBBBBB";

    private static final String DEFAULT_FISCAL_REGION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_FISCAL_REGION_CODE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_NON_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_NON_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACKAGE_NON_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACKAGE_NON_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_NON_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_NON_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_FOOD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_FOOD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_PACKAGE_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_PACKAGE_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_PACKAGE_FOOD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_PACKAGE_FOOD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_TOTAL_ROOM_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_TOTAL_ROOM_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_TOTAL_FOOD_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_TOTAL_FOOD_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_TOTAL_PACKAGE_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_TOTAL_PACKAGE_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_TOTAL_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_TOTAL_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_TOTAL_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_TOTAL_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_OTHER_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_OTHER_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_PACKAGE_OTHER_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_PACKAGE_OTHER_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_TOTAL_OTHER_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_TOTAL_OTHER_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_NON_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_NON_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_PACKAGE_NON_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_PACKAGE_NON_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_TOTAL_NON_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_TOTAL_NON_REVENUE_TAX = new BigDecimal(2);

    private static final Integer DEFAULT_NIGHTS = 1;
    private static final Integer UPDATED_NIGHTS = 2;

    private static final Integer DEFAULT_NO_OF_STAYS = 1;
    private static final Integer UPDATED_NO_OF_STAYS = 2;

    private static final Integer DEFAULT_RESERVATION_NIGHTS = 1;
    private static final Integer UPDATED_RESERVATION_NIGHTS = 2;

    private static final Integer DEFAULT_RESERVATION_ARRIVALS = 1;
    private static final Integer UPDATED_RESERVATION_ARRIVALS = 2;

    private static final Integer DEFAULT_RESERVATION_NO_OF_STAYS = 1;
    private static final Integer UPDATED_RESERVATION_NO_OF_STAYS = 2;

    private static final Integer DEFAULT_DAY_USE_RESERVATIONS = 1;
    private static final Integer UPDATED_DAY_USE_RESERVATIONS = 2;

    private static final Integer DEFAULT_CANCELLED_RESERVATIONS = 1;
    private static final Integer UPDATED_CANCELLED_RESERVATIONS = 2;

    private static final Integer DEFAULT_NO_SHOW_RESERVATIONS = 1;
    private static final Integer UPDATED_NO_SHOW_RESERVATIONS = 2;

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_ZIP_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ZIP_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DISTRICT = "AAAAAAAAAA";
    private static final String UPDATED_DISTRICT = "BBBBBBBBBB";

    private static final Integer DEFAULT_CASH_ROOM_NTS = 1;
    private static final Integer UPDATED_CASH_ROOM_NTS = 2;

    private static final Integer DEFAULT_COMP_ROOM_NTS = 1;
    private static final Integer UPDATED_COMP_ROOM_NTS = 2;

    private static final BigDecimal DEFAULT_CASH_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_CASH_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_COMP_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_COMP_ROOM_REVENUE = new BigDecimal(2);

    private static final String DEFAULT_RES_INSERT_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_RES_INSERT_SOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_RES_INSERT_SOURCE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_RES_INSERT_SOURCE_TYPE = "BBBBBBBBBB";

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

    private static final String DEFAULT_FF_MEMBERSHIP_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_FF_MEMBERSHIP_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_FG_MEMBERSHIP_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_FG_MEMBERSHIP_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_PROMOTION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PROMOTION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_OWNER_FF_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_OWNER_FF_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_OWNER_RENTAL_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_OWNER_RENTAL_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_CENTRAL_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CENTRAL_CURRENCY_CODE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_CENTRAL_EXCHANGE_RATE = new BigDecimal(1);
    private static final BigDecimal UPDATED_CENTRAL_EXCHANGE_RATE = new BigDecimal(2);

    private static final String DEFAULT_BOOKED_ROOM_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_BOOKED_ROOM_CATEGORY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_BUSINESS_DATE_CREATED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BUSINESS_DATE_CREATED = LocalDate.now(ZoneId.systemDefault());

    private static final BigDecimal DEFAULT_RATE_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_RATE_AMOUNT = new BigDecimal(2);

    private static final Integer DEFAULT_PARENT_COMPANY_ID = 1;
    private static final Integer UPDATED_PARENT_COMPANY_ID = 2;

    private static final String DEFAULT_HOUSE_USE_YN = "AAAAAAAAAA";
    private static final String UPDATED_HOUSE_USE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_COMPLIMENTARY_YN = "AAAAAAAAAA";
    private static final String UPDATED_COMPLIMENTARY_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_BI_RESV_NAME_ID = 1;
    private static final Integer UPDATED_BI_RESV_NAME_ID = 2;

    private static final BigDecimal DEFAULT_ADV_FOOD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_ADV_FOOD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ADV_NON_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_ADV_NON_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ADV_OTHER_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_ADV_OTHER_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ADV_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_ADV_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ADV_TOTAL_FOOD_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_ADV_TOTAL_FOOD_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ADV_TOTAL_NON_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_ADV_TOTAL_NON_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ADV_TOTAL_OTHER_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_ADV_TOTAL_OTHER_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ADV_TOTAL_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_ADV_TOTAL_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ADV_TOTAL_ROOM_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_ADV_TOTAL_ROOM_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ADV_TOTAL_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_ADV_TOTAL_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ADV_FOOD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ADV_FOOD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ADV_NON_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ADV_NON_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ADV_OTHER_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ADV_OTHER_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ADV_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ADV_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ADV_TOTAL_FOOD_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ADV_TOTAL_FOOD_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ADV_TOTAL_NON_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ADV_TOTAL_NON_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ADV_TOTAL_OTHER_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ADV_TOTAL_OTHER_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ADV_TOTAL_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ADV_TOTAL_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ADV_TOTAL_ROOM_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ADV_TOTAL_ROOM_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PR_ADV_TOTAL_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PR_ADV_TOTAL_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_UPSOLD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_UPSOLD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FLGD_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FLGD_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FLGD_FOOD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FLGD_FOOD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FLGD_NON_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FLGD_NON_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FLGD_OTHER_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FLGD_OTHER_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FLGD_TOTAL_ROOM_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FLGD_TOTAL_ROOM_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FLGD_TOTAL_FOOD_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FLGD_TOTAL_FOOD_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FLGD_TOTAL_NON_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FLGD_TOTAL_NON_REVENUE_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FLGD_TOTAL_OTHER_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FLGD_TOTAL_OTHER_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FLGD_TOTAL_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_FLGD_TOTAL_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_FLGD_TOTAL_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_FLGD_TOTAL_TAX = new BigDecimal(2);

    private static final String DEFAULT_CONTACT_YN = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_EXTENDED_STAY_TIER = 1;
    private static final Integer UPDATED_EXTENDED_STAY_TIER = 2;

    private static final BigDecimal DEFAULT_RS_ADV_TOTAL_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_RS_ADV_TOTAL_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_RS_ADV_ROOM_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_RS_ADV_ROOM_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_RS_ADV_FOOD_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_RS_ADV_FOOD_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_RS_ADV_OTHER_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_RS_ADV_OTHER_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_RS_ADV_NON_REVENUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_RS_ADV_NON_REVENUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_RS_ADV_TOTAL_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_RS_ADV_TOTAL_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_RS_ADV_ROOM_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_RS_ADV_ROOM_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_RS_ADV_FOOD_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_RS_ADV_FOOD_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_RS_ADV_OTHER_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_RS_ADV_OTHER_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_RS_ADV_NON_REVENUE_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_RS_ADV_NON_REVENUE_TAX = new BigDecimal(2);

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_GUID = "AAAAAAAAAA";
    private static final String UPDATED_GUID = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/reservation-stat-dailies";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ReservationStatDailyRepository reservationStatDailyRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restReservationStatDailyMockMvc;

    private ReservationStatDaily reservationStatDaily;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReservationStatDaily createEntity(EntityManager em) {
        ReservationStatDaily reservationStatDaily = new ReservationStatDaily()
            .resort(DEFAULT_RESORT)
            .businessDate(DEFAULT_BUSINESS_DATE)
            .nameId(DEFAULT_NAME_ID)
            .rateCode(DEFAULT_RATE_CODE)
            .sourceCode(DEFAULT_SOURCE_CODE)
            .marketCode(DEFAULT_MARKET_CODE)
            .roomCategory(DEFAULT_ROOM_CATEGORY)
            .companyId(DEFAULT_COMPANY_ID)
            .agentId(DEFAULT_AGENT_ID)
            .groupId(DEFAULT_GROUP_ID)
            .sourceProfId(DEFAULT_SOURCE_PROF_ID)
            .resvStatus(DEFAULT_RESV_STATUS)
            .truncBeginDate(DEFAULT_TRUNC_BEGIN_DATE)
            .truncEndDate(DEFAULT_TRUNC_END_DATE)
            .resvNameId(DEFAULT_RESV_NAME_ID)
            .quantity(DEFAULT_QUANTITY)
            .physicalQuantity(DEFAULT_PHYSICAL_QUANTITY)
            .dueOutYn(DEFAULT_DUE_OUT_YN)
            .roomResvStatus(DEFAULT_ROOM_RESV_STATUS)
            .adults(DEFAULT_ADULTS)
            .children(DEFAULT_CHILDREN)
            .roomAdults(DEFAULT_ROOM_ADULTS)
            .roomChildren(DEFAULT_ROOM_CHILDREN)
            .primaryYn(DEFAULT_PRIMARY_YN)
            .allotmentHeaderId(DEFAULT_ALLOTMENT_HEADER_ID)
            .roomRevenue(DEFAULT_ROOM_REVENUE)
            .foodRevenue(DEFAULT_FOOD_REVENUE)
            .packageRoomRevenue(DEFAULT_PACKAGE_ROOM_REVENUE)
            .packageFoodRevenue(DEFAULT_PACKAGE_FOOD_REVENUE)
            .totalRoomTax(DEFAULT_TOTAL_ROOM_TAX)
            .totalFoodTax(DEFAULT_TOTAL_FOOD_TAX)
            .totalPackageRevenue(DEFAULT_TOTAL_PACKAGE_REVENUE)
            .totalRevenue(DEFAULT_TOTAL_REVENUE)
            .totalTax(DEFAULT_TOTAL_TAX)
            .insertDate(DEFAULT_INSERT_DATE)
            .originalEndDate(DEFAULT_ORIGINAL_END_DATE)
            .walkinYn(DEFAULT_WALKIN_YN)
            .reservationDate(DEFAULT_RESERVATION_DATE)
            .roomClass(DEFAULT_ROOM_CLASS)
            .vipStatus(DEFAULT_VIP_STATUS)
            .cancellationDate(DEFAULT_CANCELLATION_DATE)
            .birthDate(DEFAULT_BIRTH_DATE)
            .room(DEFAULT_ROOM)
            .membershipId(DEFAULT_MEMBERSHIP_ID)
            .contactId(DEFAULT_CONTACT_ID)
            .rateCategory(DEFAULT_RATE_CATEGORY)
            .marketMainGroup(DEFAULT_MARKET_MAIN_GROUP)
            .sourceMainGroup(DEFAULT_SOURCE_MAIN_GROUP)
            .channel(DEFAULT_CHANNEL)
            .country(DEFAULT_COUNTRY)
            .regionCode(DEFAULT_REGION_CODE)
            .nationality(DEFAULT_NATIONALITY)
            .psuedoRoomYn(DEFAULT_PSUEDO_ROOM_YN)
            .adultsTaxFree(DEFAULT_ADULTS_TAX_FREE)
            .childrenTaxFree(DEFAULT_CHILDREN_TAX_FREE)
            .stayRooms(DEFAULT_STAY_ROOMS)
            .stayPersons(DEFAULT_STAY_PERSONS)
            .stayAdults(DEFAULT_STAY_ADULTS)
            .stayChildren(DEFAULT_STAY_CHILDREN)
            .arrRooms(DEFAULT_ARR_ROOMS)
            .arrPersons(DEFAULT_ARR_PERSONS)
            .depRooms(DEFAULT_DEP_ROOMS)
            .depPersons(DEFAULT_DEP_PERSONS)
            .dayUseRooms(DEFAULT_DAY_USE_ROOMS)
            .dayUsePersons(DEFAULT_DAY_USE_PERSONS)
            .cancelledRooms(DEFAULT_CANCELLED_ROOMS)
            .cancelledPersons(DEFAULT_CANCELLED_PERSONS)
            .noShowRooms(DEFAULT_NO_SHOW_ROOMS)
            .noShowPersons(DEFAULT_NO_SHOW_PERSONS)
            .singleOccupancy(DEFAULT_SINGLE_OCCUPANCY)
            .multipleOccupancy(DEFAULT_MULTIPLE_OCCUPANCY)
            .cribs(DEFAULT_CRIBS)
            .extraBeds(DEFAULT_EXTRA_BEDS)
            .otherRevenue(DEFAULT_OTHER_REVENUE)
            .packageOtherRevenue(DEFAULT_PACKAGE_OTHER_REVENUE)
            .totalOtherTax(DEFAULT_TOTAL_OTHER_TAX)
            .countryMainGroup(DEFAULT_COUNTRY_MAIN_GROUP)
            .state(DEFAULT_STATE)
            .fiscalRegionCode(DEFAULT_FISCAL_REGION_CODE)
            .nonRevenue(DEFAULT_NON_REVENUE)
            .packageNonRevenue(DEFAULT_PACKAGE_NON_REVENUE)
            .totalNonRevenueTax(DEFAULT_TOTAL_NON_REVENUE_TAX)
            .prRoomRevenue(DEFAULT_PR_ROOM_REVENUE)
            .prFoodRevenue(DEFAULT_PR_FOOD_REVENUE)
            .prPackageRoomRevenue(DEFAULT_PR_PACKAGE_ROOM_REVENUE)
            .prPackageFoodRevenue(DEFAULT_PR_PACKAGE_FOOD_REVENUE)
            .prTotalRoomTax(DEFAULT_PR_TOTAL_ROOM_TAX)
            .prTotalFoodTax(DEFAULT_PR_TOTAL_FOOD_TAX)
            .prTotalPackageRevenue(DEFAULT_PR_TOTAL_PACKAGE_REVENUE)
            .prTotalRevenue(DEFAULT_PR_TOTAL_REVENUE)
            .prTotalTax(DEFAULT_PR_TOTAL_TAX)
            .prOtherRevenue(DEFAULT_PR_OTHER_REVENUE)
            .prPackageOtherRevenue(DEFAULT_PR_PACKAGE_OTHER_REVENUE)
            .prTotalOtherTax(DEFAULT_PR_TOTAL_OTHER_TAX)
            .prNonRevenue(DEFAULT_PR_NON_REVENUE)
            .prPackageNonRevenue(DEFAULT_PR_PACKAGE_NON_REVENUE)
            .prTotalNonRevenueTax(DEFAULT_PR_TOTAL_NON_REVENUE_TAX)
            .nights(DEFAULT_NIGHTS)
            .noOfStays(DEFAULT_NO_OF_STAYS)
            .reservationNights(DEFAULT_RESERVATION_NIGHTS)
            .reservationArrivals(DEFAULT_RESERVATION_ARRIVALS)
            .reservationNoOfStays(DEFAULT_RESERVATION_NO_OF_STAYS)
            .dayUseReservations(DEFAULT_DAY_USE_RESERVATIONS)
            .cancelledReservations(DEFAULT_CANCELLED_RESERVATIONS)
            .noShowReservations(DEFAULT_NO_SHOW_RESERVATIONS)
            .city(DEFAULT_CITY)
            .zipCode(DEFAULT_ZIP_CODE)
            .district(DEFAULT_DISTRICT)
            .cashRoomNts(DEFAULT_CASH_ROOM_NTS)
            .compRoomNts(DEFAULT_COMP_ROOM_NTS)
            .cashRoomRevenue(DEFAULT_CASH_ROOM_REVENUE)
            .compRoomRevenue(DEFAULT_COMP_ROOM_REVENUE)
            .resInsertSource(DEFAULT_RES_INSERT_SOURCE)
            .resInsertSourceType(DEFAULT_RES_INSERT_SOURCE_TYPE)
            .children1(DEFAULT_CHILDREN_1)
            .children2(DEFAULT_CHILDREN_2)
            .children3(DEFAULT_CHILDREN_3)
            .children4(DEFAULT_CHILDREN_4)
            .children5(DEFAULT_CHILDREN_5)
            .ffMembershipType(DEFAULT_FF_MEMBERSHIP_TYPE)
            .fgMembershipType(DEFAULT_FG_MEMBERSHIP_TYPE)
            .promotionCode(DEFAULT_PROMOTION_CODE)
            .ownerFfFlag(DEFAULT_OWNER_FF_FLAG)
            .ownerRentalFlag(DEFAULT_OWNER_RENTAL_FLAG)
            .centralCurrencyCode(DEFAULT_CENTRAL_CURRENCY_CODE)
            .centralExchangeRate(DEFAULT_CENTRAL_EXCHANGE_RATE)
            .bookedRoomCategory(DEFAULT_BOOKED_ROOM_CATEGORY)
            .businessDateCreated(DEFAULT_BUSINESS_DATE_CREATED)
            .rateAmount(DEFAULT_RATE_AMOUNT)
            .parentCompanyId(DEFAULT_PARENT_COMPANY_ID)
            .houseUseYn(DEFAULT_HOUSE_USE_YN)
            .complimentaryYn(DEFAULT_COMPLIMENTARY_YN)
            .biResvNameId(DEFAULT_BI_RESV_NAME_ID)
            .advFoodRevenue(DEFAULT_ADV_FOOD_REVENUE)
            .advNonRevenue(DEFAULT_ADV_NON_REVENUE)
            .advOtherRevenue(DEFAULT_ADV_OTHER_REVENUE)
            .advRoomRevenue(DEFAULT_ADV_ROOM_REVENUE)
            .advTotalFoodTax(DEFAULT_ADV_TOTAL_FOOD_TAX)
            .advTotalNonRevenueTax(DEFAULT_ADV_TOTAL_NON_REVENUE_TAX)
            .advTotalOtherTax(DEFAULT_ADV_TOTAL_OTHER_TAX)
            .advTotalRevenue(DEFAULT_ADV_TOTAL_REVENUE)
            .advTotalRoomTax(DEFAULT_ADV_TOTAL_ROOM_TAX)
            .advTotalTax(DEFAULT_ADV_TOTAL_TAX)
            .prAdvFoodRevenue(DEFAULT_PR_ADV_FOOD_REVENUE)
            .prAdvNonRevenue(DEFAULT_PR_ADV_NON_REVENUE)
            .prAdvOtherRevenue(DEFAULT_PR_ADV_OTHER_REVENUE)
            .prAdvRoomRevenue(DEFAULT_PR_ADV_ROOM_REVENUE)
            .prAdvTotalFoodTax(DEFAULT_PR_ADV_TOTAL_FOOD_TAX)
            .prAdvTotalNonRevenueTax(DEFAULT_PR_ADV_TOTAL_NON_REVENUE_TAX)
            .prAdvTotalOtherTax(DEFAULT_PR_ADV_TOTAL_OTHER_TAX)
            .prAdvTotalRevenue(DEFAULT_PR_ADV_TOTAL_REVENUE)
            .prAdvTotalRoomTax(DEFAULT_PR_ADV_TOTAL_ROOM_TAX)
            .prAdvTotalTax(DEFAULT_PR_ADV_TOTAL_TAX)
            .upsoldRevenue(DEFAULT_UPSOLD_REVENUE)
            .flgdRoomRevenue(DEFAULT_FLGD_ROOM_REVENUE)
            .flgdFoodRevenue(DEFAULT_FLGD_FOOD_REVENUE)
            .flgdNonRevenue(DEFAULT_FLGD_NON_REVENUE)
            .flgdOtherRevenue(DEFAULT_FLGD_OTHER_REVENUE)
            .flgdTotalRoomTax(DEFAULT_FLGD_TOTAL_ROOM_TAX)
            .flgdTotalFoodTax(DEFAULT_FLGD_TOTAL_FOOD_TAX)
            .flgdTotalNonRevenueTax(DEFAULT_FLGD_TOTAL_NON_REVENUE_TAX)
            .flgdTotalOtherTax(DEFAULT_FLGD_TOTAL_OTHER_TAX)
            .flgdTotalRevenue(DEFAULT_FLGD_TOTAL_REVENUE)
            .flgdTotalTax(DEFAULT_FLGD_TOTAL_TAX)
            .contactYn(DEFAULT_CONTACT_YN)
            .extendedStayTier(DEFAULT_EXTENDED_STAY_TIER)
            .rsAdvTotalRevenue(DEFAULT_RS_ADV_TOTAL_REVENUE)
            .rsAdvRoomRevenue(DEFAULT_RS_ADV_ROOM_REVENUE)
            .rsAdvFoodRevenue(DEFAULT_RS_ADV_FOOD_REVENUE)
            .rsAdvOtherRevenue(DEFAULT_RS_ADV_OTHER_REVENUE)
            .rsAdvNonRevenue(DEFAULT_RS_ADV_NON_REVENUE)
            .rsAdvTotalTax(DEFAULT_RS_ADV_TOTAL_TAX)
            .rsAdvRoomTax(DEFAULT_RS_ADV_ROOM_TAX)
            .rsAdvFoodTax(DEFAULT_RS_ADV_FOOD_TAX)
            .rsAdvOtherTax(DEFAULT_RS_ADV_OTHER_TAX)
            .rsAdvNonRevenueTax(DEFAULT_RS_ADV_NON_REVENUE_TAX)
            .updateDate(DEFAULT_UPDATE_DATE)
            .guid(DEFAULT_GUID);
        return reservationStatDaily;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReservationStatDaily createUpdatedEntity(EntityManager em) {
        ReservationStatDaily reservationStatDaily = new ReservationStatDaily()
            .resort(UPDATED_RESORT)
            .businessDate(UPDATED_BUSINESS_DATE)
            .nameId(UPDATED_NAME_ID)
            .rateCode(UPDATED_RATE_CODE)
            .sourceCode(UPDATED_SOURCE_CODE)
            .marketCode(UPDATED_MARKET_CODE)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .companyId(UPDATED_COMPANY_ID)
            .agentId(UPDATED_AGENT_ID)
            .groupId(UPDATED_GROUP_ID)
            .sourceProfId(UPDATED_SOURCE_PROF_ID)
            .resvStatus(UPDATED_RESV_STATUS)
            .truncBeginDate(UPDATED_TRUNC_BEGIN_DATE)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .quantity(UPDATED_QUANTITY)
            .physicalQuantity(UPDATED_PHYSICAL_QUANTITY)
            .dueOutYn(UPDATED_DUE_OUT_YN)
            .roomResvStatus(UPDATED_ROOM_RESV_STATUS)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .roomAdults(UPDATED_ROOM_ADULTS)
            .roomChildren(UPDATED_ROOM_CHILDREN)
            .primaryYn(UPDATED_PRIMARY_YN)
            .allotmentHeaderId(UPDATED_ALLOTMENT_HEADER_ID)
            .roomRevenue(UPDATED_ROOM_REVENUE)
            .foodRevenue(UPDATED_FOOD_REVENUE)
            .packageRoomRevenue(UPDATED_PACKAGE_ROOM_REVENUE)
            .packageFoodRevenue(UPDATED_PACKAGE_FOOD_REVENUE)
            .totalRoomTax(UPDATED_TOTAL_ROOM_TAX)
            .totalFoodTax(UPDATED_TOTAL_FOOD_TAX)
            .totalPackageRevenue(UPDATED_TOTAL_PACKAGE_REVENUE)
            .totalRevenue(UPDATED_TOTAL_REVENUE)
            .totalTax(UPDATED_TOTAL_TAX)
            .insertDate(UPDATED_INSERT_DATE)
            .originalEndDate(UPDATED_ORIGINAL_END_DATE)
            .walkinYn(UPDATED_WALKIN_YN)
            .reservationDate(UPDATED_RESERVATION_DATE)
            .roomClass(UPDATED_ROOM_CLASS)
            .vipStatus(UPDATED_VIP_STATUS)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .birthDate(UPDATED_BIRTH_DATE)
            .room(UPDATED_ROOM)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .contactId(UPDATED_CONTACT_ID)
            .rateCategory(UPDATED_RATE_CATEGORY)
            .marketMainGroup(UPDATED_MARKET_MAIN_GROUP)
            .sourceMainGroup(UPDATED_SOURCE_MAIN_GROUP)
            .channel(UPDATED_CHANNEL)
            .country(UPDATED_COUNTRY)
            .regionCode(UPDATED_REGION_CODE)
            .nationality(UPDATED_NATIONALITY)
            .psuedoRoomYn(UPDATED_PSUEDO_ROOM_YN)
            .adultsTaxFree(UPDATED_ADULTS_TAX_FREE)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .stayRooms(UPDATED_STAY_ROOMS)
            .stayPersons(UPDATED_STAY_PERSONS)
            .stayAdults(UPDATED_STAY_ADULTS)
            .stayChildren(UPDATED_STAY_CHILDREN)
            .arrRooms(UPDATED_ARR_ROOMS)
            .arrPersons(UPDATED_ARR_PERSONS)
            .depRooms(UPDATED_DEP_ROOMS)
            .depPersons(UPDATED_DEP_PERSONS)
            .dayUseRooms(UPDATED_DAY_USE_ROOMS)
            .dayUsePersons(UPDATED_DAY_USE_PERSONS)
            .cancelledRooms(UPDATED_CANCELLED_ROOMS)
            .cancelledPersons(UPDATED_CANCELLED_PERSONS)
            .noShowRooms(UPDATED_NO_SHOW_ROOMS)
            .noShowPersons(UPDATED_NO_SHOW_PERSONS)
            .singleOccupancy(UPDATED_SINGLE_OCCUPANCY)
            .multipleOccupancy(UPDATED_MULTIPLE_OCCUPANCY)
            .cribs(UPDATED_CRIBS)
            .extraBeds(UPDATED_EXTRA_BEDS)
            .otherRevenue(UPDATED_OTHER_REVENUE)
            .packageOtherRevenue(UPDATED_PACKAGE_OTHER_REVENUE)
            .totalOtherTax(UPDATED_TOTAL_OTHER_TAX)
            .countryMainGroup(UPDATED_COUNTRY_MAIN_GROUP)
            .state(UPDATED_STATE)
            .fiscalRegionCode(UPDATED_FISCAL_REGION_CODE)
            .nonRevenue(UPDATED_NON_REVENUE)
            .packageNonRevenue(UPDATED_PACKAGE_NON_REVENUE)
            .totalNonRevenueTax(UPDATED_TOTAL_NON_REVENUE_TAX)
            .prRoomRevenue(UPDATED_PR_ROOM_REVENUE)
            .prFoodRevenue(UPDATED_PR_FOOD_REVENUE)
            .prPackageRoomRevenue(UPDATED_PR_PACKAGE_ROOM_REVENUE)
            .prPackageFoodRevenue(UPDATED_PR_PACKAGE_FOOD_REVENUE)
            .prTotalRoomTax(UPDATED_PR_TOTAL_ROOM_TAX)
            .prTotalFoodTax(UPDATED_PR_TOTAL_FOOD_TAX)
            .prTotalPackageRevenue(UPDATED_PR_TOTAL_PACKAGE_REVENUE)
            .prTotalRevenue(UPDATED_PR_TOTAL_REVENUE)
            .prTotalTax(UPDATED_PR_TOTAL_TAX)
            .prOtherRevenue(UPDATED_PR_OTHER_REVENUE)
            .prPackageOtherRevenue(UPDATED_PR_PACKAGE_OTHER_REVENUE)
            .prTotalOtherTax(UPDATED_PR_TOTAL_OTHER_TAX)
            .prNonRevenue(UPDATED_PR_NON_REVENUE)
            .prPackageNonRevenue(UPDATED_PR_PACKAGE_NON_REVENUE)
            .prTotalNonRevenueTax(UPDATED_PR_TOTAL_NON_REVENUE_TAX)
            .nights(UPDATED_NIGHTS)
            .noOfStays(UPDATED_NO_OF_STAYS)
            .reservationNights(UPDATED_RESERVATION_NIGHTS)
            .reservationArrivals(UPDATED_RESERVATION_ARRIVALS)
            .reservationNoOfStays(UPDATED_RESERVATION_NO_OF_STAYS)
            .dayUseReservations(UPDATED_DAY_USE_RESERVATIONS)
            .cancelledReservations(UPDATED_CANCELLED_RESERVATIONS)
            .noShowReservations(UPDATED_NO_SHOW_RESERVATIONS)
            .city(UPDATED_CITY)
            .zipCode(UPDATED_ZIP_CODE)
            .district(UPDATED_DISTRICT)
            .cashRoomNts(UPDATED_CASH_ROOM_NTS)
            .compRoomNts(UPDATED_COMP_ROOM_NTS)
            .cashRoomRevenue(UPDATED_CASH_ROOM_REVENUE)
            .compRoomRevenue(UPDATED_COMP_ROOM_REVENUE)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .resInsertSourceType(UPDATED_RES_INSERT_SOURCE_TYPE)
            .children1(UPDATED_CHILDREN_1)
            .children2(UPDATED_CHILDREN_2)
            .children3(UPDATED_CHILDREN_3)
            .children4(UPDATED_CHILDREN_4)
            .children5(UPDATED_CHILDREN_5)
            .ffMembershipType(UPDATED_FF_MEMBERSHIP_TYPE)
            .fgMembershipType(UPDATED_FG_MEMBERSHIP_TYPE)
            .promotionCode(UPDATED_PROMOTION_CODE)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .ownerRentalFlag(UPDATED_OWNER_RENTAL_FLAG)
            .centralCurrencyCode(UPDATED_CENTRAL_CURRENCY_CODE)
            .centralExchangeRate(UPDATED_CENTRAL_EXCHANGE_RATE)
            .bookedRoomCategory(UPDATED_BOOKED_ROOM_CATEGORY)
            .businessDateCreated(UPDATED_BUSINESS_DATE_CREATED)
            .rateAmount(UPDATED_RATE_AMOUNT)
            .parentCompanyId(UPDATED_PARENT_COMPANY_ID)
            .houseUseYn(UPDATED_HOUSE_USE_YN)
            .complimentaryYn(UPDATED_COMPLIMENTARY_YN)
            .biResvNameId(UPDATED_BI_RESV_NAME_ID)
            .advFoodRevenue(UPDATED_ADV_FOOD_REVENUE)
            .advNonRevenue(UPDATED_ADV_NON_REVENUE)
            .advOtherRevenue(UPDATED_ADV_OTHER_REVENUE)
            .advRoomRevenue(UPDATED_ADV_ROOM_REVENUE)
            .advTotalFoodTax(UPDATED_ADV_TOTAL_FOOD_TAX)
            .advTotalNonRevenueTax(UPDATED_ADV_TOTAL_NON_REVENUE_TAX)
            .advTotalOtherTax(UPDATED_ADV_TOTAL_OTHER_TAX)
            .advTotalRevenue(UPDATED_ADV_TOTAL_REVENUE)
            .advTotalRoomTax(UPDATED_ADV_TOTAL_ROOM_TAX)
            .advTotalTax(UPDATED_ADV_TOTAL_TAX)
            .prAdvFoodRevenue(UPDATED_PR_ADV_FOOD_REVENUE)
            .prAdvNonRevenue(UPDATED_PR_ADV_NON_REVENUE)
            .prAdvOtherRevenue(UPDATED_PR_ADV_OTHER_REVENUE)
            .prAdvRoomRevenue(UPDATED_PR_ADV_ROOM_REVENUE)
            .prAdvTotalFoodTax(UPDATED_PR_ADV_TOTAL_FOOD_TAX)
            .prAdvTotalNonRevenueTax(UPDATED_PR_ADV_TOTAL_NON_REVENUE_TAX)
            .prAdvTotalOtherTax(UPDATED_PR_ADV_TOTAL_OTHER_TAX)
            .prAdvTotalRevenue(UPDATED_PR_ADV_TOTAL_REVENUE)
            .prAdvTotalRoomTax(UPDATED_PR_ADV_TOTAL_ROOM_TAX)
            .prAdvTotalTax(UPDATED_PR_ADV_TOTAL_TAX)
            .upsoldRevenue(UPDATED_UPSOLD_REVENUE)
            .flgdRoomRevenue(UPDATED_FLGD_ROOM_REVENUE)
            .flgdFoodRevenue(UPDATED_FLGD_FOOD_REVENUE)
            .flgdNonRevenue(UPDATED_FLGD_NON_REVENUE)
            .flgdOtherRevenue(UPDATED_FLGD_OTHER_REVENUE)
            .flgdTotalRoomTax(UPDATED_FLGD_TOTAL_ROOM_TAX)
            .flgdTotalFoodTax(UPDATED_FLGD_TOTAL_FOOD_TAX)
            .flgdTotalNonRevenueTax(UPDATED_FLGD_TOTAL_NON_REVENUE_TAX)
            .flgdTotalOtherTax(UPDATED_FLGD_TOTAL_OTHER_TAX)
            .flgdTotalRevenue(UPDATED_FLGD_TOTAL_REVENUE)
            .flgdTotalTax(UPDATED_FLGD_TOTAL_TAX)
            .contactYn(UPDATED_CONTACT_YN)
            .extendedStayTier(UPDATED_EXTENDED_STAY_TIER)
            .rsAdvTotalRevenue(UPDATED_RS_ADV_TOTAL_REVENUE)
            .rsAdvRoomRevenue(UPDATED_RS_ADV_ROOM_REVENUE)
            .rsAdvFoodRevenue(UPDATED_RS_ADV_FOOD_REVENUE)
            .rsAdvOtherRevenue(UPDATED_RS_ADV_OTHER_REVENUE)
            .rsAdvNonRevenue(UPDATED_RS_ADV_NON_REVENUE)
            .rsAdvTotalTax(UPDATED_RS_ADV_TOTAL_TAX)
            .rsAdvRoomTax(UPDATED_RS_ADV_ROOM_TAX)
            .rsAdvFoodTax(UPDATED_RS_ADV_FOOD_TAX)
            .rsAdvOtherTax(UPDATED_RS_ADV_OTHER_TAX)
            .rsAdvNonRevenueTax(UPDATED_RS_ADV_NON_REVENUE_TAX)
            .updateDate(UPDATED_UPDATE_DATE)
            .guid(UPDATED_GUID);
        return reservationStatDaily;
    }

    @BeforeEach
    public void initTest() {
        reservationStatDaily = createEntity(em);
    }

    @Test
    @Transactional
    void createReservationStatDaily() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ReservationStatDaily
        var returnedReservationStatDaily = om.readValue(
            restReservationStatDailyMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationStatDaily)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ReservationStatDaily.class
        );

        // Validate the ReservationStatDaily in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertReservationStatDailyUpdatableFieldsEquals(
            returnedReservationStatDaily,
            getPersistedReservationStatDaily(returnedReservationStatDaily)
        );
    }

    @Test
    @Transactional
    void createReservationStatDailyWithExistingId() throws Exception {
        // Create the ReservationStatDaily with an existing ID
        reservationStatDaily.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restReservationStatDailyMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationStatDaily)))
            .andExpect(status().isBadRequest());

        // Validate the ReservationStatDaily in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllReservationStatDailies() throws Exception {
        // Initialize the database
        reservationStatDailyRepository.saveAndFlush(reservationStatDaily);

        // Get all the reservationStatDailyList
        restReservationStatDailyMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reservationStatDaily.getId().intValue())))
            .andExpect(jsonPath("$.[*].resort").value(hasItem(DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].businessDate").value(hasItem(DEFAULT_BUSINESS_DATE.toString())))
            .andExpect(jsonPath("$.[*].nameId").value(hasItem(DEFAULT_NAME_ID)))
            .andExpect(jsonPath("$.[*].rateCode").value(hasItem(DEFAULT_RATE_CODE)))
            .andExpect(jsonPath("$.[*].sourceCode").value(hasItem(DEFAULT_SOURCE_CODE)))
            .andExpect(jsonPath("$.[*].marketCode").value(hasItem(DEFAULT_MARKET_CODE)))
            .andExpect(jsonPath("$.[*].roomCategory").value(hasItem(DEFAULT_ROOM_CATEGORY)))
            .andExpect(jsonPath("$.[*].companyId").value(hasItem(DEFAULT_COMPANY_ID)))
            .andExpect(jsonPath("$.[*].agentId").value(hasItem(DEFAULT_AGENT_ID)))
            .andExpect(jsonPath("$.[*].groupId").value(hasItem(DEFAULT_GROUP_ID)))
            .andExpect(jsonPath("$.[*].sourceProfId").value(hasItem(DEFAULT_SOURCE_PROF_ID)))
            .andExpect(jsonPath("$.[*].resvStatus").value(hasItem(DEFAULT_RESV_STATUS)))
            .andExpect(jsonPath("$.[*].truncBeginDate").value(hasItem(DEFAULT_TRUNC_BEGIN_DATE.toString())))
            .andExpect(jsonPath("$.[*].truncEndDate").value(hasItem(DEFAULT_TRUNC_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].resvNameId").value(hasItem(DEFAULT_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].quantity").value(hasItem(DEFAULT_QUANTITY)))
            .andExpect(jsonPath("$.[*].physicalQuantity").value(hasItem(DEFAULT_PHYSICAL_QUANTITY)))
            .andExpect(jsonPath("$.[*].dueOutYn").value(hasItem(DEFAULT_DUE_OUT_YN)))
            .andExpect(jsonPath("$.[*].roomResvStatus").value(hasItem(DEFAULT_ROOM_RESV_STATUS)))
            .andExpect(jsonPath("$.[*].adults").value(hasItem(DEFAULT_ADULTS)))
            .andExpect(jsonPath("$.[*].children").value(hasItem(DEFAULT_CHILDREN)))
            .andExpect(jsonPath("$.[*].roomAdults").value(hasItem(DEFAULT_ROOM_ADULTS)))
            .andExpect(jsonPath("$.[*].roomChildren").value(hasItem(DEFAULT_ROOM_CHILDREN)))
            .andExpect(jsonPath("$.[*].primaryYn").value(hasItem(DEFAULT_PRIMARY_YN)))
            .andExpect(jsonPath("$.[*].allotmentHeaderId").value(hasItem(DEFAULT_ALLOTMENT_HEADER_ID)))
            .andExpect(jsonPath("$.[*].roomRevenue").value(hasItem(sameNumber(DEFAULT_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].foodRevenue").value(hasItem(sameNumber(DEFAULT_FOOD_REVENUE))))
            .andExpect(jsonPath("$.[*].packageRoomRevenue").value(hasItem(sameNumber(DEFAULT_PACKAGE_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].packageFoodRevenue").value(hasItem(sameNumber(DEFAULT_PACKAGE_FOOD_REVENUE))))
            .andExpect(jsonPath("$.[*].totalRoomTax").value(hasItem(sameNumber(DEFAULT_TOTAL_ROOM_TAX))))
            .andExpect(jsonPath("$.[*].totalFoodTax").value(hasItem(sameNumber(DEFAULT_TOTAL_FOOD_TAX))))
            .andExpect(jsonPath("$.[*].totalPackageRevenue").value(hasItem(sameNumber(DEFAULT_TOTAL_PACKAGE_REVENUE))))
            .andExpect(jsonPath("$.[*].totalRevenue").value(hasItem(sameNumber(DEFAULT_TOTAL_REVENUE))))
            .andExpect(jsonPath("$.[*].totalTax").value(hasItem(sameNumber(DEFAULT_TOTAL_TAX))))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].originalEndDate").value(hasItem(DEFAULT_ORIGINAL_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].walkinYn").value(hasItem(DEFAULT_WALKIN_YN)))
            .andExpect(jsonPath("$.[*].reservationDate").value(hasItem(DEFAULT_RESERVATION_DATE.toString())))
            .andExpect(jsonPath("$.[*].roomClass").value(hasItem(DEFAULT_ROOM_CLASS)))
            .andExpect(jsonPath("$.[*].vipStatus").value(hasItem(DEFAULT_VIP_STATUS)))
            .andExpect(jsonPath("$.[*].cancellationDate").value(hasItem(DEFAULT_CANCELLATION_DATE.toString())))
            .andExpect(jsonPath("$.[*].birthDate").value(hasItem(DEFAULT_BIRTH_DATE.toString())))
            .andExpect(jsonPath("$.[*].room").value(hasItem(DEFAULT_ROOM)))
            .andExpect(jsonPath("$.[*].membershipId").value(hasItem(DEFAULT_MEMBERSHIP_ID)))
            .andExpect(jsonPath("$.[*].contactId").value(hasItem(DEFAULT_CONTACT_ID)))
            .andExpect(jsonPath("$.[*].rateCategory").value(hasItem(DEFAULT_RATE_CATEGORY)))
            .andExpect(jsonPath("$.[*].marketMainGroup").value(hasItem(DEFAULT_MARKET_MAIN_GROUP)))
            .andExpect(jsonPath("$.[*].sourceMainGroup").value(hasItem(DEFAULT_SOURCE_MAIN_GROUP)))
            .andExpect(jsonPath("$.[*].channel").value(hasItem(DEFAULT_CHANNEL)))
            .andExpect(jsonPath("$.[*].country").value(hasItem(DEFAULT_COUNTRY)))
            .andExpect(jsonPath("$.[*].regionCode").value(hasItem(DEFAULT_REGION_CODE)))
            .andExpect(jsonPath("$.[*].nationality").value(hasItem(DEFAULT_NATIONALITY)))
            .andExpect(jsonPath("$.[*].psuedoRoomYn").value(hasItem(DEFAULT_PSUEDO_ROOM_YN)))
            .andExpect(jsonPath("$.[*].adultsTaxFree").value(hasItem(DEFAULT_ADULTS_TAX_FREE)))
            .andExpect(jsonPath("$.[*].childrenTaxFree").value(hasItem(DEFAULT_CHILDREN_TAX_FREE)))
            .andExpect(jsonPath("$.[*].stayRooms").value(hasItem(DEFAULT_STAY_ROOMS)))
            .andExpect(jsonPath("$.[*].stayPersons").value(hasItem(DEFAULT_STAY_PERSONS)))
            .andExpect(jsonPath("$.[*].stayAdults").value(hasItem(DEFAULT_STAY_ADULTS)))
            .andExpect(jsonPath("$.[*].stayChildren").value(hasItem(DEFAULT_STAY_CHILDREN)))
            .andExpect(jsonPath("$.[*].arrRooms").value(hasItem(DEFAULT_ARR_ROOMS)))
            .andExpect(jsonPath("$.[*].arrPersons").value(hasItem(DEFAULT_ARR_PERSONS)))
            .andExpect(jsonPath("$.[*].depRooms").value(hasItem(DEFAULT_DEP_ROOMS)))
            .andExpect(jsonPath("$.[*].depPersons").value(hasItem(DEFAULT_DEP_PERSONS)))
            .andExpect(jsonPath("$.[*].dayUseRooms").value(hasItem(DEFAULT_DAY_USE_ROOMS)))
            .andExpect(jsonPath("$.[*].dayUsePersons").value(hasItem(DEFAULT_DAY_USE_PERSONS)))
            .andExpect(jsonPath("$.[*].cancelledRooms").value(hasItem(DEFAULT_CANCELLED_ROOMS)))
            .andExpect(jsonPath("$.[*].cancelledPersons").value(hasItem(DEFAULT_CANCELLED_PERSONS)))
            .andExpect(jsonPath("$.[*].noShowRooms").value(hasItem(DEFAULT_NO_SHOW_ROOMS)))
            .andExpect(jsonPath("$.[*].noShowPersons").value(hasItem(DEFAULT_NO_SHOW_PERSONS)))
            .andExpect(jsonPath("$.[*].singleOccupancy").value(hasItem(DEFAULT_SINGLE_OCCUPANCY)))
            .andExpect(jsonPath("$.[*].multipleOccupancy").value(hasItem(DEFAULT_MULTIPLE_OCCUPANCY)))
            .andExpect(jsonPath("$.[*].cribs").value(hasItem(DEFAULT_CRIBS)))
            .andExpect(jsonPath("$.[*].extraBeds").value(hasItem(DEFAULT_EXTRA_BEDS)))
            .andExpect(jsonPath("$.[*].otherRevenue").value(hasItem(sameNumber(DEFAULT_OTHER_REVENUE))))
            .andExpect(jsonPath("$.[*].packageOtherRevenue").value(hasItem(sameNumber(DEFAULT_PACKAGE_OTHER_REVENUE))))
            .andExpect(jsonPath("$.[*].totalOtherTax").value(hasItem(sameNumber(DEFAULT_TOTAL_OTHER_TAX))))
            .andExpect(jsonPath("$.[*].countryMainGroup").value(hasItem(DEFAULT_COUNTRY_MAIN_GROUP)))
            .andExpect(jsonPath("$.[*].state").value(hasItem(DEFAULT_STATE)))
            .andExpect(jsonPath("$.[*].fiscalRegionCode").value(hasItem(DEFAULT_FISCAL_REGION_CODE)))
            .andExpect(jsonPath("$.[*].nonRevenue").value(hasItem(sameNumber(DEFAULT_NON_REVENUE))))
            .andExpect(jsonPath("$.[*].packageNonRevenue").value(hasItem(sameNumber(DEFAULT_PACKAGE_NON_REVENUE))))
            .andExpect(jsonPath("$.[*].totalNonRevenueTax").value(hasItem(sameNumber(DEFAULT_TOTAL_NON_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].prRoomRevenue").value(hasItem(sameNumber(DEFAULT_PR_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].prFoodRevenue").value(hasItem(sameNumber(DEFAULT_PR_FOOD_REVENUE))))
            .andExpect(jsonPath("$.[*].prPackageRoomRevenue").value(hasItem(sameNumber(DEFAULT_PR_PACKAGE_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].prPackageFoodRevenue").value(hasItem(sameNumber(DEFAULT_PR_PACKAGE_FOOD_REVENUE))))
            .andExpect(jsonPath("$.[*].prTotalRoomTax").value(hasItem(sameNumber(DEFAULT_PR_TOTAL_ROOM_TAX))))
            .andExpect(jsonPath("$.[*].prTotalFoodTax").value(hasItem(sameNumber(DEFAULT_PR_TOTAL_FOOD_TAX))))
            .andExpect(jsonPath("$.[*].prTotalPackageRevenue").value(hasItem(sameNumber(DEFAULT_PR_TOTAL_PACKAGE_REVENUE))))
            .andExpect(jsonPath("$.[*].prTotalRevenue").value(hasItem(sameNumber(DEFAULT_PR_TOTAL_REVENUE))))
            .andExpect(jsonPath("$.[*].prTotalTax").value(hasItem(sameNumber(DEFAULT_PR_TOTAL_TAX))))
            .andExpect(jsonPath("$.[*].prOtherRevenue").value(hasItem(sameNumber(DEFAULT_PR_OTHER_REVENUE))))
            .andExpect(jsonPath("$.[*].prPackageOtherRevenue").value(hasItem(sameNumber(DEFAULT_PR_PACKAGE_OTHER_REVENUE))))
            .andExpect(jsonPath("$.[*].prTotalOtherTax").value(hasItem(sameNumber(DEFAULT_PR_TOTAL_OTHER_TAX))))
            .andExpect(jsonPath("$.[*].prNonRevenue").value(hasItem(sameNumber(DEFAULT_PR_NON_REVENUE))))
            .andExpect(jsonPath("$.[*].prPackageNonRevenue").value(hasItem(sameNumber(DEFAULT_PR_PACKAGE_NON_REVENUE))))
            .andExpect(jsonPath("$.[*].prTotalNonRevenueTax").value(hasItem(sameNumber(DEFAULT_PR_TOTAL_NON_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].nights").value(hasItem(DEFAULT_NIGHTS)))
            .andExpect(jsonPath("$.[*].noOfStays").value(hasItem(DEFAULT_NO_OF_STAYS)))
            .andExpect(jsonPath("$.[*].reservationNights").value(hasItem(DEFAULT_RESERVATION_NIGHTS)))
            .andExpect(jsonPath("$.[*].reservationArrivals").value(hasItem(DEFAULT_RESERVATION_ARRIVALS)))
            .andExpect(jsonPath("$.[*].reservationNoOfStays").value(hasItem(DEFAULT_RESERVATION_NO_OF_STAYS)))
            .andExpect(jsonPath("$.[*].dayUseReservations").value(hasItem(DEFAULT_DAY_USE_RESERVATIONS)))
            .andExpect(jsonPath("$.[*].cancelledReservations").value(hasItem(DEFAULT_CANCELLED_RESERVATIONS)))
            .andExpect(jsonPath("$.[*].noShowReservations").value(hasItem(DEFAULT_NO_SHOW_RESERVATIONS)))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY)))
            .andExpect(jsonPath("$.[*].zipCode").value(hasItem(DEFAULT_ZIP_CODE)))
            .andExpect(jsonPath("$.[*].district").value(hasItem(DEFAULT_DISTRICT)))
            .andExpect(jsonPath("$.[*].cashRoomNts").value(hasItem(DEFAULT_CASH_ROOM_NTS)))
            .andExpect(jsonPath("$.[*].compRoomNts").value(hasItem(DEFAULT_COMP_ROOM_NTS)))
            .andExpect(jsonPath("$.[*].cashRoomRevenue").value(hasItem(sameNumber(DEFAULT_CASH_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].compRoomRevenue").value(hasItem(sameNumber(DEFAULT_COMP_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].resInsertSource").value(hasItem(DEFAULT_RES_INSERT_SOURCE)))
            .andExpect(jsonPath("$.[*].resInsertSourceType").value(hasItem(DEFAULT_RES_INSERT_SOURCE_TYPE)))
            .andExpect(jsonPath("$.[*].children1").value(hasItem(DEFAULT_CHILDREN_1)))
            .andExpect(jsonPath("$.[*].children2").value(hasItem(DEFAULT_CHILDREN_2)))
            .andExpect(jsonPath("$.[*].children3").value(hasItem(DEFAULT_CHILDREN_3)))
            .andExpect(jsonPath("$.[*].children4").value(hasItem(DEFAULT_CHILDREN_4)))
            .andExpect(jsonPath("$.[*].children5").value(hasItem(DEFAULT_CHILDREN_5)))
            .andExpect(jsonPath("$.[*].ffMembershipType").value(hasItem(DEFAULT_FF_MEMBERSHIP_TYPE)))
            .andExpect(jsonPath("$.[*].fgMembershipType").value(hasItem(DEFAULT_FG_MEMBERSHIP_TYPE)))
            .andExpect(jsonPath("$.[*].promotionCode").value(hasItem(DEFAULT_PROMOTION_CODE)))
            .andExpect(jsonPath("$.[*].ownerFfFlag").value(hasItem(DEFAULT_OWNER_FF_FLAG)))
            .andExpect(jsonPath("$.[*].ownerRentalFlag").value(hasItem(DEFAULT_OWNER_RENTAL_FLAG)))
            .andExpect(jsonPath("$.[*].centralCurrencyCode").value(hasItem(DEFAULT_CENTRAL_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].centralExchangeRate").value(hasItem(sameNumber(DEFAULT_CENTRAL_EXCHANGE_RATE))))
            .andExpect(jsonPath("$.[*].bookedRoomCategory").value(hasItem(DEFAULT_BOOKED_ROOM_CATEGORY)))
            .andExpect(jsonPath("$.[*].businessDateCreated").value(hasItem(DEFAULT_BUSINESS_DATE_CREATED.toString())))
            .andExpect(jsonPath("$.[*].rateAmount").value(hasItem(sameNumber(DEFAULT_RATE_AMOUNT))))
            .andExpect(jsonPath("$.[*].parentCompanyId").value(hasItem(DEFAULT_PARENT_COMPANY_ID)))
            .andExpect(jsonPath("$.[*].houseUseYn").value(hasItem(DEFAULT_HOUSE_USE_YN)))
            .andExpect(jsonPath("$.[*].complimentaryYn").value(hasItem(DEFAULT_COMPLIMENTARY_YN)))
            .andExpect(jsonPath("$.[*].biResvNameId").value(hasItem(DEFAULT_BI_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].advFoodRevenue").value(hasItem(sameNumber(DEFAULT_ADV_FOOD_REVENUE))))
            .andExpect(jsonPath("$.[*].advNonRevenue").value(hasItem(sameNumber(DEFAULT_ADV_NON_REVENUE))))
            .andExpect(jsonPath("$.[*].advOtherRevenue").value(hasItem(sameNumber(DEFAULT_ADV_OTHER_REVENUE))))
            .andExpect(jsonPath("$.[*].advRoomRevenue").value(hasItem(sameNumber(DEFAULT_ADV_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].advTotalFoodTax").value(hasItem(sameNumber(DEFAULT_ADV_TOTAL_FOOD_TAX))))
            .andExpect(jsonPath("$.[*].advTotalNonRevenueTax").value(hasItem(sameNumber(DEFAULT_ADV_TOTAL_NON_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].advTotalOtherTax").value(hasItem(sameNumber(DEFAULT_ADV_TOTAL_OTHER_TAX))))
            .andExpect(jsonPath("$.[*].advTotalRevenue").value(hasItem(sameNumber(DEFAULT_ADV_TOTAL_REVENUE))))
            .andExpect(jsonPath("$.[*].advTotalRoomTax").value(hasItem(sameNumber(DEFAULT_ADV_TOTAL_ROOM_TAX))))
            .andExpect(jsonPath("$.[*].advTotalTax").value(hasItem(sameNumber(DEFAULT_ADV_TOTAL_TAX))))
            .andExpect(jsonPath("$.[*].prAdvFoodRevenue").value(hasItem(sameNumber(DEFAULT_PR_ADV_FOOD_REVENUE))))
            .andExpect(jsonPath("$.[*].prAdvNonRevenue").value(hasItem(sameNumber(DEFAULT_PR_ADV_NON_REVENUE))))
            .andExpect(jsonPath("$.[*].prAdvOtherRevenue").value(hasItem(sameNumber(DEFAULT_PR_ADV_OTHER_REVENUE))))
            .andExpect(jsonPath("$.[*].prAdvRoomRevenue").value(hasItem(sameNumber(DEFAULT_PR_ADV_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].prAdvTotalFoodTax").value(hasItem(sameNumber(DEFAULT_PR_ADV_TOTAL_FOOD_TAX))))
            .andExpect(jsonPath("$.[*].prAdvTotalNonRevenueTax").value(hasItem(sameNumber(DEFAULT_PR_ADV_TOTAL_NON_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].prAdvTotalOtherTax").value(hasItem(sameNumber(DEFAULT_PR_ADV_TOTAL_OTHER_TAX))))
            .andExpect(jsonPath("$.[*].prAdvTotalRevenue").value(hasItem(sameNumber(DEFAULT_PR_ADV_TOTAL_REVENUE))))
            .andExpect(jsonPath("$.[*].prAdvTotalRoomTax").value(hasItem(sameNumber(DEFAULT_PR_ADV_TOTAL_ROOM_TAX))))
            .andExpect(jsonPath("$.[*].prAdvTotalTax").value(hasItem(sameNumber(DEFAULT_PR_ADV_TOTAL_TAX))))
            .andExpect(jsonPath("$.[*].upsoldRevenue").value(hasItem(sameNumber(DEFAULT_UPSOLD_REVENUE))))
            .andExpect(jsonPath("$.[*].flgdRoomRevenue").value(hasItem(sameNumber(DEFAULT_FLGD_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].flgdFoodRevenue").value(hasItem(sameNumber(DEFAULT_FLGD_FOOD_REVENUE))))
            .andExpect(jsonPath("$.[*].flgdNonRevenue").value(hasItem(sameNumber(DEFAULT_FLGD_NON_REVENUE))))
            .andExpect(jsonPath("$.[*].flgdOtherRevenue").value(hasItem(sameNumber(DEFAULT_FLGD_OTHER_REVENUE))))
            .andExpect(jsonPath("$.[*].flgdTotalRoomTax").value(hasItem(sameNumber(DEFAULT_FLGD_TOTAL_ROOM_TAX))))
            .andExpect(jsonPath("$.[*].flgdTotalFoodTax").value(hasItem(sameNumber(DEFAULT_FLGD_TOTAL_FOOD_TAX))))
            .andExpect(jsonPath("$.[*].flgdTotalNonRevenueTax").value(hasItem(sameNumber(DEFAULT_FLGD_TOTAL_NON_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].flgdTotalOtherTax").value(hasItem(sameNumber(DEFAULT_FLGD_TOTAL_OTHER_TAX))))
            .andExpect(jsonPath("$.[*].flgdTotalRevenue").value(hasItem(sameNumber(DEFAULT_FLGD_TOTAL_REVENUE))))
            .andExpect(jsonPath("$.[*].flgdTotalTax").value(hasItem(sameNumber(DEFAULT_FLGD_TOTAL_TAX))))
            .andExpect(jsonPath("$.[*].contactYn").value(hasItem(DEFAULT_CONTACT_YN)))
            .andExpect(jsonPath("$.[*].extendedStayTier").value(hasItem(DEFAULT_EXTENDED_STAY_TIER)))
            .andExpect(jsonPath("$.[*].rsAdvTotalRevenue").value(hasItem(sameNumber(DEFAULT_RS_ADV_TOTAL_REVENUE))))
            .andExpect(jsonPath("$.[*].rsAdvRoomRevenue").value(hasItem(sameNumber(DEFAULT_RS_ADV_ROOM_REVENUE))))
            .andExpect(jsonPath("$.[*].rsAdvFoodRevenue").value(hasItem(sameNumber(DEFAULT_RS_ADV_FOOD_REVENUE))))
            .andExpect(jsonPath("$.[*].rsAdvOtherRevenue").value(hasItem(sameNumber(DEFAULT_RS_ADV_OTHER_REVENUE))))
            .andExpect(jsonPath("$.[*].rsAdvNonRevenue").value(hasItem(sameNumber(DEFAULT_RS_ADV_NON_REVENUE))))
            .andExpect(jsonPath("$.[*].rsAdvTotalTax").value(hasItem(sameNumber(DEFAULT_RS_ADV_TOTAL_TAX))))
            .andExpect(jsonPath("$.[*].rsAdvRoomTax").value(hasItem(sameNumber(DEFAULT_RS_ADV_ROOM_TAX))))
            .andExpect(jsonPath("$.[*].rsAdvFoodTax").value(hasItem(sameNumber(DEFAULT_RS_ADV_FOOD_TAX))))
            .andExpect(jsonPath("$.[*].rsAdvOtherTax").value(hasItem(sameNumber(DEFAULT_RS_ADV_OTHER_TAX))))
            .andExpect(jsonPath("$.[*].rsAdvNonRevenueTax").value(hasItem(sameNumber(DEFAULT_RS_ADV_NON_REVENUE_TAX))))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].guid").value(hasItem(DEFAULT_GUID)));
    }

    @Test
    @Transactional
    void getReservationStatDaily() throws Exception {
        // Initialize the database
        reservationStatDailyRepository.saveAndFlush(reservationStatDaily);

        // Get the reservationStatDaily
        restReservationStatDailyMockMvc
            .perform(get(ENTITY_API_URL_ID, reservationStatDaily.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(reservationStatDaily.getId().intValue()))
            .andExpect(jsonPath("$.resort").value(DEFAULT_RESORT))
            .andExpect(jsonPath("$.businessDate").value(DEFAULT_BUSINESS_DATE.toString()))
            .andExpect(jsonPath("$.nameId").value(DEFAULT_NAME_ID))
            .andExpect(jsonPath("$.rateCode").value(DEFAULT_RATE_CODE))
            .andExpect(jsonPath("$.sourceCode").value(DEFAULT_SOURCE_CODE))
            .andExpect(jsonPath("$.marketCode").value(DEFAULT_MARKET_CODE))
            .andExpect(jsonPath("$.roomCategory").value(DEFAULT_ROOM_CATEGORY))
            .andExpect(jsonPath("$.companyId").value(DEFAULT_COMPANY_ID))
            .andExpect(jsonPath("$.agentId").value(DEFAULT_AGENT_ID))
            .andExpect(jsonPath("$.groupId").value(DEFAULT_GROUP_ID))
            .andExpect(jsonPath("$.sourceProfId").value(DEFAULT_SOURCE_PROF_ID))
            .andExpect(jsonPath("$.resvStatus").value(DEFAULT_RESV_STATUS))
            .andExpect(jsonPath("$.truncBeginDate").value(DEFAULT_TRUNC_BEGIN_DATE.toString()))
            .andExpect(jsonPath("$.truncEndDate").value(DEFAULT_TRUNC_END_DATE.toString()))
            .andExpect(jsonPath("$.resvNameId").value(DEFAULT_RESV_NAME_ID))
            .andExpect(jsonPath("$.quantity").value(DEFAULT_QUANTITY))
            .andExpect(jsonPath("$.physicalQuantity").value(DEFAULT_PHYSICAL_QUANTITY))
            .andExpect(jsonPath("$.dueOutYn").value(DEFAULT_DUE_OUT_YN))
            .andExpect(jsonPath("$.roomResvStatus").value(DEFAULT_ROOM_RESV_STATUS))
            .andExpect(jsonPath("$.adults").value(DEFAULT_ADULTS))
            .andExpect(jsonPath("$.children").value(DEFAULT_CHILDREN))
            .andExpect(jsonPath("$.roomAdults").value(DEFAULT_ROOM_ADULTS))
            .andExpect(jsonPath("$.roomChildren").value(DEFAULT_ROOM_CHILDREN))
            .andExpect(jsonPath("$.primaryYn").value(DEFAULT_PRIMARY_YN))
            .andExpect(jsonPath("$.allotmentHeaderId").value(DEFAULT_ALLOTMENT_HEADER_ID))
            .andExpect(jsonPath("$.roomRevenue").value(sameNumber(DEFAULT_ROOM_REVENUE)))
            .andExpect(jsonPath("$.foodRevenue").value(sameNumber(DEFAULT_FOOD_REVENUE)))
            .andExpect(jsonPath("$.packageRoomRevenue").value(sameNumber(DEFAULT_PACKAGE_ROOM_REVENUE)))
            .andExpect(jsonPath("$.packageFoodRevenue").value(sameNumber(DEFAULT_PACKAGE_FOOD_REVENUE)))
            .andExpect(jsonPath("$.totalRoomTax").value(sameNumber(DEFAULT_TOTAL_ROOM_TAX)))
            .andExpect(jsonPath("$.totalFoodTax").value(sameNumber(DEFAULT_TOTAL_FOOD_TAX)))
            .andExpect(jsonPath("$.totalPackageRevenue").value(sameNumber(DEFAULT_TOTAL_PACKAGE_REVENUE)))
            .andExpect(jsonPath("$.totalRevenue").value(sameNumber(DEFAULT_TOTAL_REVENUE)))
            .andExpect(jsonPath("$.totalTax").value(sameNumber(DEFAULT_TOTAL_TAX)))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.originalEndDate").value(DEFAULT_ORIGINAL_END_DATE.toString()))
            .andExpect(jsonPath("$.walkinYn").value(DEFAULT_WALKIN_YN))
            .andExpect(jsonPath("$.reservationDate").value(DEFAULT_RESERVATION_DATE.toString()))
            .andExpect(jsonPath("$.roomClass").value(DEFAULT_ROOM_CLASS))
            .andExpect(jsonPath("$.vipStatus").value(DEFAULT_VIP_STATUS))
            .andExpect(jsonPath("$.cancellationDate").value(DEFAULT_CANCELLATION_DATE.toString()))
            .andExpect(jsonPath("$.birthDate").value(DEFAULT_BIRTH_DATE.toString()))
            .andExpect(jsonPath("$.room").value(DEFAULT_ROOM))
            .andExpect(jsonPath("$.membershipId").value(DEFAULT_MEMBERSHIP_ID))
            .andExpect(jsonPath("$.contactId").value(DEFAULT_CONTACT_ID))
            .andExpect(jsonPath("$.rateCategory").value(DEFAULT_RATE_CATEGORY))
            .andExpect(jsonPath("$.marketMainGroup").value(DEFAULT_MARKET_MAIN_GROUP))
            .andExpect(jsonPath("$.sourceMainGroup").value(DEFAULT_SOURCE_MAIN_GROUP))
            .andExpect(jsonPath("$.channel").value(DEFAULT_CHANNEL))
            .andExpect(jsonPath("$.country").value(DEFAULT_COUNTRY))
            .andExpect(jsonPath("$.regionCode").value(DEFAULT_REGION_CODE))
            .andExpect(jsonPath("$.nationality").value(DEFAULT_NATIONALITY))
            .andExpect(jsonPath("$.psuedoRoomYn").value(DEFAULT_PSUEDO_ROOM_YN))
            .andExpect(jsonPath("$.adultsTaxFree").value(DEFAULT_ADULTS_TAX_FREE))
            .andExpect(jsonPath("$.childrenTaxFree").value(DEFAULT_CHILDREN_TAX_FREE))
            .andExpect(jsonPath("$.stayRooms").value(DEFAULT_STAY_ROOMS))
            .andExpect(jsonPath("$.stayPersons").value(DEFAULT_STAY_PERSONS))
            .andExpect(jsonPath("$.stayAdults").value(DEFAULT_STAY_ADULTS))
            .andExpect(jsonPath("$.stayChildren").value(DEFAULT_STAY_CHILDREN))
            .andExpect(jsonPath("$.arrRooms").value(DEFAULT_ARR_ROOMS))
            .andExpect(jsonPath("$.arrPersons").value(DEFAULT_ARR_PERSONS))
            .andExpect(jsonPath("$.depRooms").value(DEFAULT_DEP_ROOMS))
            .andExpect(jsonPath("$.depPersons").value(DEFAULT_DEP_PERSONS))
            .andExpect(jsonPath("$.dayUseRooms").value(DEFAULT_DAY_USE_ROOMS))
            .andExpect(jsonPath("$.dayUsePersons").value(DEFAULT_DAY_USE_PERSONS))
            .andExpect(jsonPath("$.cancelledRooms").value(DEFAULT_CANCELLED_ROOMS))
            .andExpect(jsonPath("$.cancelledPersons").value(DEFAULT_CANCELLED_PERSONS))
            .andExpect(jsonPath("$.noShowRooms").value(DEFAULT_NO_SHOW_ROOMS))
            .andExpect(jsonPath("$.noShowPersons").value(DEFAULT_NO_SHOW_PERSONS))
            .andExpect(jsonPath("$.singleOccupancy").value(DEFAULT_SINGLE_OCCUPANCY))
            .andExpect(jsonPath("$.multipleOccupancy").value(DEFAULT_MULTIPLE_OCCUPANCY))
            .andExpect(jsonPath("$.cribs").value(DEFAULT_CRIBS))
            .andExpect(jsonPath("$.extraBeds").value(DEFAULT_EXTRA_BEDS))
            .andExpect(jsonPath("$.otherRevenue").value(sameNumber(DEFAULT_OTHER_REVENUE)))
            .andExpect(jsonPath("$.packageOtherRevenue").value(sameNumber(DEFAULT_PACKAGE_OTHER_REVENUE)))
            .andExpect(jsonPath("$.totalOtherTax").value(sameNumber(DEFAULT_TOTAL_OTHER_TAX)))
            .andExpect(jsonPath("$.countryMainGroup").value(DEFAULT_COUNTRY_MAIN_GROUP))
            .andExpect(jsonPath("$.state").value(DEFAULT_STATE))
            .andExpect(jsonPath("$.fiscalRegionCode").value(DEFAULT_FISCAL_REGION_CODE))
            .andExpect(jsonPath("$.nonRevenue").value(sameNumber(DEFAULT_NON_REVENUE)))
            .andExpect(jsonPath("$.packageNonRevenue").value(sameNumber(DEFAULT_PACKAGE_NON_REVENUE)))
            .andExpect(jsonPath("$.totalNonRevenueTax").value(sameNumber(DEFAULT_TOTAL_NON_REVENUE_TAX)))
            .andExpect(jsonPath("$.prRoomRevenue").value(sameNumber(DEFAULT_PR_ROOM_REVENUE)))
            .andExpect(jsonPath("$.prFoodRevenue").value(sameNumber(DEFAULT_PR_FOOD_REVENUE)))
            .andExpect(jsonPath("$.prPackageRoomRevenue").value(sameNumber(DEFAULT_PR_PACKAGE_ROOM_REVENUE)))
            .andExpect(jsonPath("$.prPackageFoodRevenue").value(sameNumber(DEFAULT_PR_PACKAGE_FOOD_REVENUE)))
            .andExpect(jsonPath("$.prTotalRoomTax").value(sameNumber(DEFAULT_PR_TOTAL_ROOM_TAX)))
            .andExpect(jsonPath("$.prTotalFoodTax").value(sameNumber(DEFAULT_PR_TOTAL_FOOD_TAX)))
            .andExpect(jsonPath("$.prTotalPackageRevenue").value(sameNumber(DEFAULT_PR_TOTAL_PACKAGE_REVENUE)))
            .andExpect(jsonPath("$.prTotalRevenue").value(sameNumber(DEFAULT_PR_TOTAL_REVENUE)))
            .andExpect(jsonPath("$.prTotalTax").value(sameNumber(DEFAULT_PR_TOTAL_TAX)))
            .andExpect(jsonPath("$.prOtherRevenue").value(sameNumber(DEFAULT_PR_OTHER_REVENUE)))
            .andExpect(jsonPath("$.prPackageOtherRevenue").value(sameNumber(DEFAULT_PR_PACKAGE_OTHER_REVENUE)))
            .andExpect(jsonPath("$.prTotalOtherTax").value(sameNumber(DEFAULT_PR_TOTAL_OTHER_TAX)))
            .andExpect(jsonPath("$.prNonRevenue").value(sameNumber(DEFAULT_PR_NON_REVENUE)))
            .andExpect(jsonPath("$.prPackageNonRevenue").value(sameNumber(DEFAULT_PR_PACKAGE_NON_REVENUE)))
            .andExpect(jsonPath("$.prTotalNonRevenueTax").value(sameNumber(DEFAULT_PR_TOTAL_NON_REVENUE_TAX)))
            .andExpect(jsonPath("$.nights").value(DEFAULT_NIGHTS))
            .andExpect(jsonPath("$.noOfStays").value(DEFAULT_NO_OF_STAYS))
            .andExpect(jsonPath("$.reservationNights").value(DEFAULT_RESERVATION_NIGHTS))
            .andExpect(jsonPath("$.reservationArrivals").value(DEFAULT_RESERVATION_ARRIVALS))
            .andExpect(jsonPath("$.reservationNoOfStays").value(DEFAULT_RESERVATION_NO_OF_STAYS))
            .andExpect(jsonPath("$.dayUseReservations").value(DEFAULT_DAY_USE_RESERVATIONS))
            .andExpect(jsonPath("$.cancelledReservations").value(DEFAULT_CANCELLED_RESERVATIONS))
            .andExpect(jsonPath("$.noShowReservations").value(DEFAULT_NO_SHOW_RESERVATIONS))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY))
            .andExpect(jsonPath("$.zipCode").value(DEFAULT_ZIP_CODE))
            .andExpect(jsonPath("$.district").value(DEFAULT_DISTRICT))
            .andExpect(jsonPath("$.cashRoomNts").value(DEFAULT_CASH_ROOM_NTS))
            .andExpect(jsonPath("$.compRoomNts").value(DEFAULT_COMP_ROOM_NTS))
            .andExpect(jsonPath("$.cashRoomRevenue").value(sameNumber(DEFAULT_CASH_ROOM_REVENUE)))
            .andExpect(jsonPath("$.compRoomRevenue").value(sameNumber(DEFAULT_COMP_ROOM_REVENUE)))
            .andExpect(jsonPath("$.resInsertSource").value(DEFAULT_RES_INSERT_SOURCE))
            .andExpect(jsonPath("$.resInsertSourceType").value(DEFAULT_RES_INSERT_SOURCE_TYPE))
            .andExpect(jsonPath("$.children1").value(DEFAULT_CHILDREN_1))
            .andExpect(jsonPath("$.children2").value(DEFAULT_CHILDREN_2))
            .andExpect(jsonPath("$.children3").value(DEFAULT_CHILDREN_3))
            .andExpect(jsonPath("$.children4").value(DEFAULT_CHILDREN_4))
            .andExpect(jsonPath("$.children5").value(DEFAULT_CHILDREN_5))
            .andExpect(jsonPath("$.ffMembershipType").value(DEFAULT_FF_MEMBERSHIP_TYPE))
            .andExpect(jsonPath("$.fgMembershipType").value(DEFAULT_FG_MEMBERSHIP_TYPE))
            .andExpect(jsonPath("$.promotionCode").value(DEFAULT_PROMOTION_CODE))
            .andExpect(jsonPath("$.ownerFfFlag").value(DEFAULT_OWNER_FF_FLAG))
            .andExpect(jsonPath("$.ownerRentalFlag").value(DEFAULT_OWNER_RENTAL_FLAG))
            .andExpect(jsonPath("$.centralCurrencyCode").value(DEFAULT_CENTRAL_CURRENCY_CODE))
            .andExpect(jsonPath("$.centralExchangeRate").value(sameNumber(DEFAULT_CENTRAL_EXCHANGE_RATE)))
            .andExpect(jsonPath("$.bookedRoomCategory").value(DEFAULT_BOOKED_ROOM_CATEGORY))
            .andExpect(jsonPath("$.businessDateCreated").value(DEFAULT_BUSINESS_DATE_CREATED.toString()))
            .andExpect(jsonPath("$.rateAmount").value(sameNumber(DEFAULT_RATE_AMOUNT)))
            .andExpect(jsonPath("$.parentCompanyId").value(DEFAULT_PARENT_COMPANY_ID))
            .andExpect(jsonPath("$.houseUseYn").value(DEFAULT_HOUSE_USE_YN))
            .andExpect(jsonPath("$.complimentaryYn").value(DEFAULT_COMPLIMENTARY_YN))
            .andExpect(jsonPath("$.biResvNameId").value(DEFAULT_BI_RESV_NAME_ID))
            .andExpect(jsonPath("$.advFoodRevenue").value(sameNumber(DEFAULT_ADV_FOOD_REVENUE)))
            .andExpect(jsonPath("$.advNonRevenue").value(sameNumber(DEFAULT_ADV_NON_REVENUE)))
            .andExpect(jsonPath("$.advOtherRevenue").value(sameNumber(DEFAULT_ADV_OTHER_REVENUE)))
            .andExpect(jsonPath("$.advRoomRevenue").value(sameNumber(DEFAULT_ADV_ROOM_REVENUE)))
            .andExpect(jsonPath("$.advTotalFoodTax").value(sameNumber(DEFAULT_ADV_TOTAL_FOOD_TAX)))
            .andExpect(jsonPath("$.advTotalNonRevenueTax").value(sameNumber(DEFAULT_ADV_TOTAL_NON_REVENUE_TAX)))
            .andExpect(jsonPath("$.advTotalOtherTax").value(sameNumber(DEFAULT_ADV_TOTAL_OTHER_TAX)))
            .andExpect(jsonPath("$.advTotalRevenue").value(sameNumber(DEFAULT_ADV_TOTAL_REVENUE)))
            .andExpect(jsonPath("$.advTotalRoomTax").value(sameNumber(DEFAULT_ADV_TOTAL_ROOM_TAX)))
            .andExpect(jsonPath("$.advTotalTax").value(sameNumber(DEFAULT_ADV_TOTAL_TAX)))
            .andExpect(jsonPath("$.prAdvFoodRevenue").value(sameNumber(DEFAULT_PR_ADV_FOOD_REVENUE)))
            .andExpect(jsonPath("$.prAdvNonRevenue").value(sameNumber(DEFAULT_PR_ADV_NON_REVENUE)))
            .andExpect(jsonPath("$.prAdvOtherRevenue").value(sameNumber(DEFAULT_PR_ADV_OTHER_REVENUE)))
            .andExpect(jsonPath("$.prAdvRoomRevenue").value(sameNumber(DEFAULT_PR_ADV_ROOM_REVENUE)))
            .andExpect(jsonPath("$.prAdvTotalFoodTax").value(sameNumber(DEFAULT_PR_ADV_TOTAL_FOOD_TAX)))
            .andExpect(jsonPath("$.prAdvTotalNonRevenueTax").value(sameNumber(DEFAULT_PR_ADV_TOTAL_NON_REVENUE_TAX)))
            .andExpect(jsonPath("$.prAdvTotalOtherTax").value(sameNumber(DEFAULT_PR_ADV_TOTAL_OTHER_TAX)))
            .andExpect(jsonPath("$.prAdvTotalRevenue").value(sameNumber(DEFAULT_PR_ADV_TOTAL_REVENUE)))
            .andExpect(jsonPath("$.prAdvTotalRoomTax").value(sameNumber(DEFAULT_PR_ADV_TOTAL_ROOM_TAX)))
            .andExpect(jsonPath("$.prAdvTotalTax").value(sameNumber(DEFAULT_PR_ADV_TOTAL_TAX)))
            .andExpect(jsonPath("$.upsoldRevenue").value(sameNumber(DEFAULT_UPSOLD_REVENUE)))
            .andExpect(jsonPath("$.flgdRoomRevenue").value(sameNumber(DEFAULT_FLGD_ROOM_REVENUE)))
            .andExpect(jsonPath("$.flgdFoodRevenue").value(sameNumber(DEFAULT_FLGD_FOOD_REVENUE)))
            .andExpect(jsonPath("$.flgdNonRevenue").value(sameNumber(DEFAULT_FLGD_NON_REVENUE)))
            .andExpect(jsonPath("$.flgdOtherRevenue").value(sameNumber(DEFAULT_FLGD_OTHER_REVENUE)))
            .andExpect(jsonPath("$.flgdTotalRoomTax").value(sameNumber(DEFAULT_FLGD_TOTAL_ROOM_TAX)))
            .andExpect(jsonPath("$.flgdTotalFoodTax").value(sameNumber(DEFAULT_FLGD_TOTAL_FOOD_TAX)))
            .andExpect(jsonPath("$.flgdTotalNonRevenueTax").value(sameNumber(DEFAULT_FLGD_TOTAL_NON_REVENUE_TAX)))
            .andExpect(jsonPath("$.flgdTotalOtherTax").value(sameNumber(DEFAULT_FLGD_TOTAL_OTHER_TAX)))
            .andExpect(jsonPath("$.flgdTotalRevenue").value(sameNumber(DEFAULT_FLGD_TOTAL_REVENUE)))
            .andExpect(jsonPath("$.flgdTotalTax").value(sameNumber(DEFAULT_FLGD_TOTAL_TAX)))
            .andExpect(jsonPath("$.contactYn").value(DEFAULT_CONTACT_YN))
            .andExpect(jsonPath("$.extendedStayTier").value(DEFAULT_EXTENDED_STAY_TIER))
            .andExpect(jsonPath("$.rsAdvTotalRevenue").value(sameNumber(DEFAULT_RS_ADV_TOTAL_REVENUE)))
            .andExpect(jsonPath("$.rsAdvRoomRevenue").value(sameNumber(DEFAULT_RS_ADV_ROOM_REVENUE)))
            .andExpect(jsonPath("$.rsAdvFoodRevenue").value(sameNumber(DEFAULT_RS_ADV_FOOD_REVENUE)))
            .andExpect(jsonPath("$.rsAdvOtherRevenue").value(sameNumber(DEFAULT_RS_ADV_OTHER_REVENUE)))
            .andExpect(jsonPath("$.rsAdvNonRevenue").value(sameNumber(DEFAULT_RS_ADV_NON_REVENUE)))
            .andExpect(jsonPath("$.rsAdvTotalTax").value(sameNumber(DEFAULT_RS_ADV_TOTAL_TAX)))
            .andExpect(jsonPath("$.rsAdvRoomTax").value(sameNumber(DEFAULT_RS_ADV_ROOM_TAX)))
            .andExpect(jsonPath("$.rsAdvFoodTax").value(sameNumber(DEFAULT_RS_ADV_FOOD_TAX)))
            .andExpect(jsonPath("$.rsAdvOtherTax").value(sameNumber(DEFAULT_RS_ADV_OTHER_TAX)))
            .andExpect(jsonPath("$.rsAdvNonRevenueTax").value(sameNumber(DEFAULT_RS_ADV_NON_REVENUE_TAX)))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.guid").value(DEFAULT_GUID));
    }

    @Test
    @Transactional
    void getNonExistingReservationStatDaily() throws Exception {
        // Get the reservationStatDaily
        restReservationStatDailyMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingReservationStatDaily() throws Exception {
        // Initialize the database
        reservationStatDailyRepository.saveAndFlush(reservationStatDaily);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationStatDaily
        ReservationStatDaily updatedReservationStatDaily = reservationStatDailyRepository
            .findById(reservationStatDaily.getId())
            .orElseThrow();
        // Disconnect from session so that the updates on updatedReservationStatDaily are not directly saved in db
        em.detach(updatedReservationStatDaily);
        updatedReservationStatDaily
            .resort(UPDATED_RESORT)
            .businessDate(UPDATED_BUSINESS_DATE)
            .nameId(UPDATED_NAME_ID)
            .rateCode(UPDATED_RATE_CODE)
            .sourceCode(UPDATED_SOURCE_CODE)
            .marketCode(UPDATED_MARKET_CODE)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .companyId(UPDATED_COMPANY_ID)
            .agentId(UPDATED_AGENT_ID)
            .groupId(UPDATED_GROUP_ID)
            .sourceProfId(UPDATED_SOURCE_PROF_ID)
            .resvStatus(UPDATED_RESV_STATUS)
            .truncBeginDate(UPDATED_TRUNC_BEGIN_DATE)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .quantity(UPDATED_QUANTITY)
            .physicalQuantity(UPDATED_PHYSICAL_QUANTITY)
            .dueOutYn(UPDATED_DUE_OUT_YN)
            .roomResvStatus(UPDATED_ROOM_RESV_STATUS)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .roomAdults(UPDATED_ROOM_ADULTS)
            .roomChildren(UPDATED_ROOM_CHILDREN)
            .primaryYn(UPDATED_PRIMARY_YN)
            .allotmentHeaderId(UPDATED_ALLOTMENT_HEADER_ID)
            .roomRevenue(UPDATED_ROOM_REVENUE)
            .foodRevenue(UPDATED_FOOD_REVENUE)
            .packageRoomRevenue(UPDATED_PACKAGE_ROOM_REVENUE)
            .packageFoodRevenue(UPDATED_PACKAGE_FOOD_REVENUE)
            .totalRoomTax(UPDATED_TOTAL_ROOM_TAX)
            .totalFoodTax(UPDATED_TOTAL_FOOD_TAX)
            .totalPackageRevenue(UPDATED_TOTAL_PACKAGE_REVENUE)
            .totalRevenue(UPDATED_TOTAL_REVENUE)
            .totalTax(UPDATED_TOTAL_TAX)
            .insertDate(UPDATED_INSERT_DATE)
            .originalEndDate(UPDATED_ORIGINAL_END_DATE)
            .walkinYn(UPDATED_WALKIN_YN)
            .reservationDate(UPDATED_RESERVATION_DATE)
            .roomClass(UPDATED_ROOM_CLASS)
            .vipStatus(UPDATED_VIP_STATUS)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .birthDate(UPDATED_BIRTH_DATE)
            .room(UPDATED_ROOM)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .contactId(UPDATED_CONTACT_ID)
            .rateCategory(UPDATED_RATE_CATEGORY)
            .marketMainGroup(UPDATED_MARKET_MAIN_GROUP)
            .sourceMainGroup(UPDATED_SOURCE_MAIN_GROUP)
            .channel(UPDATED_CHANNEL)
            .country(UPDATED_COUNTRY)
            .regionCode(UPDATED_REGION_CODE)
            .nationality(UPDATED_NATIONALITY)
            .psuedoRoomYn(UPDATED_PSUEDO_ROOM_YN)
            .adultsTaxFree(UPDATED_ADULTS_TAX_FREE)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .stayRooms(UPDATED_STAY_ROOMS)
            .stayPersons(UPDATED_STAY_PERSONS)
            .stayAdults(UPDATED_STAY_ADULTS)
            .stayChildren(UPDATED_STAY_CHILDREN)
            .arrRooms(UPDATED_ARR_ROOMS)
            .arrPersons(UPDATED_ARR_PERSONS)
            .depRooms(UPDATED_DEP_ROOMS)
            .depPersons(UPDATED_DEP_PERSONS)
            .dayUseRooms(UPDATED_DAY_USE_ROOMS)
            .dayUsePersons(UPDATED_DAY_USE_PERSONS)
            .cancelledRooms(UPDATED_CANCELLED_ROOMS)
            .cancelledPersons(UPDATED_CANCELLED_PERSONS)
            .noShowRooms(UPDATED_NO_SHOW_ROOMS)
            .noShowPersons(UPDATED_NO_SHOW_PERSONS)
            .singleOccupancy(UPDATED_SINGLE_OCCUPANCY)
            .multipleOccupancy(UPDATED_MULTIPLE_OCCUPANCY)
            .cribs(UPDATED_CRIBS)
            .extraBeds(UPDATED_EXTRA_BEDS)
            .otherRevenue(UPDATED_OTHER_REVENUE)
            .packageOtherRevenue(UPDATED_PACKAGE_OTHER_REVENUE)
            .totalOtherTax(UPDATED_TOTAL_OTHER_TAX)
            .countryMainGroup(UPDATED_COUNTRY_MAIN_GROUP)
            .state(UPDATED_STATE)
            .fiscalRegionCode(UPDATED_FISCAL_REGION_CODE)
            .nonRevenue(UPDATED_NON_REVENUE)
            .packageNonRevenue(UPDATED_PACKAGE_NON_REVENUE)
            .totalNonRevenueTax(UPDATED_TOTAL_NON_REVENUE_TAX)
            .prRoomRevenue(UPDATED_PR_ROOM_REVENUE)
            .prFoodRevenue(UPDATED_PR_FOOD_REVENUE)
            .prPackageRoomRevenue(UPDATED_PR_PACKAGE_ROOM_REVENUE)
            .prPackageFoodRevenue(UPDATED_PR_PACKAGE_FOOD_REVENUE)
            .prTotalRoomTax(UPDATED_PR_TOTAL_ROOM_TAX)
            .prTotalFoodTax(UPDATED_PR_TOTAL_FOOD_TAX)
            .prTotalPackageRevenue(UPDATED_PR_TOTAL_PACKAGE_REVENUE)
            .prTotalRevenue(UPDATED_PR_TOTAL_REVENUE)
            .prTotalTax(UPDATED_PR_TOTAL_TAX)
            .prOtherRevenue(UPDATED_PR_OTHER_REVENUE)
            .prPackageOtherRevenue(UPDATED_PR_PACKAGE_OTHER_REVENUE)
            .prTotalOtherTax(UPDATED_PR_TOTAL_OTHER_TAX)
            .prNonRevenue(UPDATED_PR_NON_REVENUE)
            .prPackageNonRevenue(UPDATED_PR_PACKAGE_NON_REVENUE)
            .prTotalNonRevenueTax(UPDATED_PR_TOTAL_NON_REVENUE_TAX)
            .nights(UPDATED_NIGHTS)
            .noOfStays(UPDATED_NO_OF_STAYS)
            .reservationNights(UPDATED_RESERVATION_NIGHTS)
            .reservationArrivals(UPDATED_RESERVATION_ARRIVALS)
            .reservationNoOfStays(UPDATED_RESERVATION_NO_OF_STAYS)
            .dayUseReservations(UPDATED_DAY_USE_RESERVATIONS)
            .cancelledReservations(UPDATED_CANCELLED_RESERVATIONS)
            .noShowReservations(UPDATED_NO_SHOW_RESERVATIONS)
            .city(UPDATED_CITY)
            .zipCode(UPDATED_ZIP_CODE)
            .district(UPDATED_DISTRICT)
            .cashRoomNts(UPDATED_CASH_ROOM_NTS)
            .compRoomNts(UPDATED_COMP_ROOM_NTS)
            .cashRoomRevenue(UPDATED_CASH_ROOM_REVENUE)
            .compRoomRevenue(UPDATED_COMP_ROOM_REVENUE)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .resInsertSourceType(UPDATED_RES_INSERT_SOURCE_TYPE)
            .children1(UPDATED_CHILDREN_1)
            .children2(UPDATED_CHILDREN_2)
            .children3(UPDATED_CHILDREN_3)
            .children4(UPDATED_CHILDREN_4)
            .children5(UPDATED_CHILDREN_5)
            .ffMembershipType(UPDATED_FF_MEMBERSHIP_TYPE)
            .fgMembershipType(UPDATED_FG_MEMBERSHIP_TYPE)
            .promotionCode(UPDATED_PROMOTION_CODE)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .ownerRentalFlag(UPDATED_OWNER_RENTAL_FLAG)
            .centralCurrencyCode(UPDATED_CENTRAL_CURRENCY_CODE)
            .centralExchangeRate(UPDATED_CENTRAL_EXCHANGE_RATE)
            .bookedRoomCategory(UPDATED_BOOKED_ROOM_CATEGORY)
            .businessDateCreated(UPDATED_BUSINESS_DATE_CREATED)
            .rateAmount(UPDATED_RATE_AMOUNT)
            .parentCompanyId(UPDATED_PARENT_COMPANY_ID)
            .houseUseYn(UPDATED_HOUSE_USE_YN)
            .complimentaryYn(UPDATED_COMPLIMENTARY_YN)
            .biResvNameId(UPDATED_BI_RESV_NAME_ID)
            .advFoodRevenue(UPDATED_ADV_FOOD_REVENUE)
            .advNonRevenue(UPDATED_ADV_NON_REVENUE)
            .advOtherRevenue(UPDATED_ADV_OTHER_REVENUE)
            .advRoomRevenue(UPDATED_ADV_ROOM_REVENUE)
            .advTotalFoodTax(UPDATED_ADV_TOTAL_FOOD_TAX)
            .advTotalNonRevenueTax(UPDATED_ADV_TOTAL_NON_REVENUE_TAX)
            .advTotalOtherTax(UPDATED_ADV_TOTAL_OTHER_TAX)
            .advTotalRevenue(UPDATED_ADV_TOTAL_REVENUE)
            .advTotalRoomTax(UPDATED_ADV_TOTAL_ROOM_TAX)
            .advTotalTax(UPDATED_ADV_TOTAL_TAX)
            .prAdvFoodRevenue(UPDATED_PR_ADV_FOOD_REVENUE)
            .prAdvNonRevenue(UPDATED_PR_ADV_NON_REVENUE)
            .prAdvOtherRevenue(UPDATED_PR_ADV_OTHER_REVENUE)
            .prAdvRoomRevenue(UPDATED_PR_ADV_ROOM_REVENUE)
            .prAdvTotalFoodTax(UPDATED_PR_ADV_TOTAL_FOOD_TAX)
            .prAdvTotalNonRevenueTax(UPDATED_PR_ADV_TOTAL_NON_REVENUE_TAX)
            .prAdvTotalOtherTax(UPDATED_PR_ADV_TOTAL_OTHER_TAX)
            .prAdvTotalRevenue(UPDATED_PR_ADV_TOTAL_REVENUE)
            .prAdvTotalRoomTax(UPDATED_PR_ADV_TOTAL_ROOM_TAX)
            .prAdvTotalTax(UPDATED_PR_ADV_TOTAL_TAX)
            .upsoldRevenue(UPDATED_UPSOLD_REVENUE)
            .flgdRoomRevenue(UPDATED_FLGD_ROOM_REVENUE)
            .flgdFoodRevenue(UPDATED_FLGD_FOOD_REVENUE)
            .flgdNonRevenue(UPDATED_FLGD_NON_REVENUE)
            .flgdOtherRevenue(UPDATED_FLGD_OTHER_REVENUE)
            .flgdTotalRoomTax(UPDATED_FLGD_TOTAL_ROOM_TAX)
            .flgdTotalFoodTax(UPDATED_FLGD_TOTAL_FOOD_TAX)
            .flgdTotalNonRevenueTax(UPDATED_FLGD_TOTAL_NON_REVENUE_TAX)
            .flgdTotalOtherTax(UPDATED_FLGD_TOTAL_OTHER_TAX)
            .flgdTotalRevenue(UPDATED_FLGD_TOTAL_REVENUE)
            .flgdTotalTax(UPDATED_FLGD_TOTAL_TAX)
            .contactYn(UPDATED_CONTACT_YN)
            .extendedStayTier(UPDATED_EXTENDED_STAY_TIER)
            .rsAdvTotalRevenue(UPDATED_RS_ADV_TOTAL_REVENUE)
            .rsAdvRoomRevenue(UPDATED_RS_ADV_ROOM_REVENUE)
            .rsAdvFoodRevenue(UPDATED_RS_ADV_FOOD_REVENUE)
            .rsAdvOtherRevenue(UPDATED_RS_ADV_OTHER_REVENUE)
            .rsAdvNonRevenue(UPDATED_RS_ADV_NON_REVENUE)
            .rsAdvTotalTax(UPDATED_RS_ADV_TOTAL_TAX)
            .rsAdvRoomTax(UPDATED_RS_ADV_ROOM_TAX)
            .rsAdvFoodTax(UPDATED_RS_ADV_FOOD_TAX)
            .rsAdvOtherTax(UPDATED_RS_ADV_OTHER_TAX)
            .rsAdvNonRevenueTax(UPDATED_RS_ADV_NON_REVENUE_TAX)
            .updateDate(UPDATED_UPDATE_DATE)
            .guid(UPDATED_GUID);

        restReservationStatDailyMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedReservationStatDaily.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedReservationStatDaily))
            )
            .andExpect(status().isOk());

        // Validate the ReservationStatDaily in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedReservationStatDailyToMatchAllProperties(updatedReservationStatDaily);
    }

    @Test
    @Transactional
    void putNonExistingReservationStatDaily() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationStatDaily.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReservationStatDailyMockMvc
            .perform(
                put(ENTITY_API_URL_ID, reservationStatDaily.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reservationStatDaily))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationStatDaily in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchReservationStatDaily() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationStatDaily.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationStatDailyMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reservationStatDaily))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationStatDaily in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamReservationStatDaily() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationStatDaily.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationStatDailyMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationStatDaily)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReservationStatDaily in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateReservationStatDailyWithPatch() throws Exception {
        // Initialize the database
        reservationStatDailyRepository.saveAndFlush(reservationStatDaily);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationStatDaily using partial update
        ReservationStatDaily partialUpdatedReservationStatDaily = new ReservationStatDaily();
        partialUpdatedReservationStatDaily.setId(reservationStatDaily.getId());

        partialUpdatedReservationStatDaily
            .resort(UPDATED_RESORT)
            .sourceCode(UPDATED_SOURCE_CODE)
            .marketCode(UPDATED_MARKET_CODE)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .companyId(UPDATED_COMPANY_ID)
            .resvStatus(UPDATED_RESV_STATUS)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .physicalQuantity(UPDATED_PHYSICAL_QUANTITY)
            .dueOutYn(UPDATED_DUE_OUT_YN)
            .roomResvStatus(UPDATED_ROOM_RESV_STATUS)
            .adults(UPDATED_ADULTS)
            .primaryYn(UPDATED_PRIMARY_YN)
            .roomRevenue(UPDATED_ROOM_REVENUE)
            .packageRoomRevenue(UPDATED_PACKAGE_ROOM_REVENUE)
            .totalRoomTax(UPDATED_TOTAL_ROOM_TAX)
            .totalRevenue(UPDATED_TOTAL_REVENUE)
            .totalTax(UPDATED_TOTAL_TAX)
            .originalEndDate(UPDATED_ORIGINAL_END_DATE)
            .walkinYn(UPDATED_WALKIN_YN)
            .reservationDate(UPDATED_RESERVATION_DATE)
            .roomClass(UPDATED_ROOM_CLASS)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .birthDate(UPDATED_BIRTH_DATE)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .channel(UPDATED_CHANNEL)
            .country(UPDATED_COUNTRY)
            .nationality(UPDATED_NATIONALITY)
            .psuedoRoomYn(UPDATED_PSUEDO_ROOM_YN)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .stayRooms(UPDATED_STAY_ROOMS)
            .stayPersons(UPDATED_STAY_PERSONS)
            .arrPersons(UPDATED_ARR_PERSONS)
            .depRooms(UPDATED_DEP_ROOMS)
            .depPersons(UPDATED_DEP_PERSONS)
            .dayUsePersons(UPDATED_DAY_USE_PERSONS)
            .noShowRooms(UPDATED_NO_SHOW_ROOMS)
            .noShowPersons(UPDATED_NO_SHOW_PERSONS)
            .singleOccupancy(UPDATED_SINGLE_OCCUPANCY)
            .cribs(UPDATED_CRIBS)
            .otherRevenue(UPDATED_OTHER_REVENUE)
            .totalOtherTax(UPDATED_TOTAL_OTHER_TAX)
            .countryMainGroup(UPDATED_COUNTRY_MAIN_GROUP)
            .nonRevenue(UPDATED_NON_REVENUE)
            .prRoomRevenue(UPDATED_PR_ROOM_REVENUE)
            .prPackageRoomRevenue(UPDATED_PR_PACKAGE_ROOM_REVENUE)
            .prTotalFoodTax(UPDATED_PR_TOTAL_FOOD_TAX)
            .prTotalPackageRevenue(UPDATED_PR_TOTAL_PACKAGE_REVENUE)
            .prTotalTax(UPDATED_PR_TOTAL_TAX)
            .prTotalNonRevenueTax(UPDATED_PR_TOTAL_NON_REVENUE_TAX)
            .reservationNoOfStays(UPDATED_RESERVATION_NO_OF_STAYS)
            .dayUseReservations(UPDATED_DAY_USE_RESERVATIONS)
            .cancelledReservations(UPDATED_CANCELLED_RESERVATIONS)
            .noShowReservations(UPDATED_NO_SHOW_RESERVATIONS)
            .district(UPDATED_DISTRICT)
            .cashRoomRevenue(UPDATED_CASH_ROOM_REVENUE)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .resInsertSourceType(UPDATED_RES_INSERT_SOURCE_TYPE)
            .children1(UPDATED_CHILDREN_1)
            .children2(UPDATED_CHILDREN_2)
            .children3(UPDATED_CHILDREN_3)
            .ffMembershipType(UPDATED_FF_MEMBERSHIP_TYPE)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .ownerRentalFlag(UPDATED_OWNER_RENTAL_FLAG)
            .centralCurrencyCode(UPDATED_CENTRAL_CURRENCY_CODE)
            .complimentaryYn(UPDATED_COMPLIMENTARY_YN)
            .advNonRevenue(UPDATED_ADV_NON_REVENUE)
            .advTotalFoodTax(UPDATED_ADV_TOTAL_FOOD_TAX)
            .advTotalOtherTax(UPDATED_ADV_TOTAL_OTHER_TAX)
            .advTotalRevenue(UPDATED_ADV_TOTAL_REVENUE)
            .advTotalRoomTax(UPDATED_ADV_TOTAL_ROOM_TAX)
            .advTotalTax(UPDATED_ADV_TOTAL_TAX)
            .prAdvFoodRevenue(UPDATED_PR_ADV_FOOD_REVENUE)
            .prAdvNonRevenue(UPDATED_PR_ADV_NON_REVENUE)
            .prAdvRoomRevenue(UPDATED_PR_ADV_ROOM_REVENUE)
            .prAdvTotalRoomTax(UPDATED_PR_ADV_TOTAL_ROOM_TAX)
            .upsoldRevenue(UPDATED_UPSOLD_REVENUE)
            .flgdNonRevenue(UPDATED_FLGD_NON_REVENUE)
            .flgdOtherRevenue(UPDATED_FLGD_OTHER_REVENUE)
            .flgdTotalRoomTax(UPDATED_FLGD_TOTAL_ROOM_TAX)
            .flgdTotalFoodTax(UPDATED_FLGD_TOTAL_FOOD_TAX)
            .flgdTotalNonRevenueTax(UPDATED_FLGD_TOTAL_NON_REVENUE_TAX)
            .flgdTotalRevenue(UPDATED_FLGD_TOTAL_REVENUE)
            .contactYn(UPDATED_CONTACT_YN)
            .rsAdvOtherRevenue(UPDATED_RS_ADV_OTHER_REVENUE)
            .rsAdvRoomTax(UPDATED_RS_ADV_ROOM_TAX)
            .rsAdvOtherTax(UPDATED_RS_ADV_OTHER_TAX)
            .updateDate(UPDATED_UPDATE_DATE);

        restReservationStatDailyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReservationStatDaily.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReservationStatDaily))
            )
            .andExpect(status().isOk());

        // Validate the ReservationStatDaily in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReservationStatDailyUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedReservationStatDaily, reservationStatDaily),
            getPersistedReservationStatDaily(reservationStatDaily)
        );
    }

    @Test
    @Transactional
    void fullUpdateReservationStatDailyWithPatch() throws Exception {
        // Initialize the database
        reservationStatDailyRepository.saveAndFlush(reservationStatDaily);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationStatDaily using partial update
        ReservationStatDaily partialUpdatedReservationStatDaily = new ReservationStatDaily();
        partialUpdatedReservationStatDaily.setId(reservationStatDaily.getId());

        partialUpdatedReservationStatDaily
            .resort(UPDATED_RESORT)
            .businessDate(UPDATED_BUSINESS_DATE)
            .nameId(UPDATED_NAME_ID)
            .rateCode(UPDATED_RATE_CODE)
            .sourceCode(UPDATED_SOURCE_CODE)
            .marketCode(UPDATED_MARKET_CODE)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .companyId(UPDATED_COMPANY_ID)
            .agentId(UPDATED_AGENT_ID)
            .groupId(UPDATED_GROUP_ID)
            .sourceProfId(UPDATED_SOURCE_PROF_ID)
            .resvStatus(UPDATED_RESV_STATUS)
            .truncBeginDate(UPDATED_TRUNC_BEGIN_DATE)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .quantity(UPDATED_QUANTITY)
            .physicalQuantity(UPDATED_PHYSICAL_QUANTITY)
            .dueOutYn(UPDATED_DUE_OUT_YN)
            .roomResvStatus(UPDATED_ROOM_RESV_STATUS)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .roomAdults(UPDATED_ROOM_ADULTS)
            .roomChildren(UPDATED_ROOM_CHILDREN)
            .primaryYn(UPDATED_PRIMARY_YN)
            .allotmentHeaderId(UPDATED_ALLOTMENT_HEADER_ID)
            .roomRevenue(UPDATED_ROOM_REVENUE)
            .foodRevenue(UPDATED_FOOD_REVENUE)
            .packageRoomRevenue(UPDATED_PACKAGE_ROOM_REVENUE)
            .packageFoodRevenue(UPDATED_PACKAGE_FOOD_REVENUE)
            .totalRoomTax(UPDATED_TOTAL_ROOM_TAX)
            .totalFoodTax(UPDATED_TOTAL_FOOD_TAX)
            .totalPackageRevenue(UPDATED_TOTAL_PACKAGE_REVENUE)
            .totalRevenue(UPDATED_TOTAL_REVENUE)
            .totalTax(UPDATED_TOTAL_TAX)
            .insertDate(UPDATED_INSERT_DATE)
            .originalEndDate(UPDATED_ORIGINAL_END_DATE)
            .walkinYn(UPDATED_WALKIN_YN)
            .reservationDate(UPDATED_RESERVATION_DATE)
            .roomClass(UPDATED_ROOM_CLASS)
            .vipStatus(UPDATED_VIP_STATUS)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .birthDate(UPDATED_BIRTH_DATE)
            .room(UPDATED_ROOM)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .contactId(UPDATED_CONTACT_ID)
            .rateCategory(UPDATED_RATE_CATEGORY)
            .marketMainGroup(UPDATED_MARKET_MAIN_GROUP)
            .sourceMainGroup(UPDATED_SOURCE_MAIN_GROUP)
            .channel(UPDATED_CHANNEL)
            .country(UPDATED_COUNTRY)
            .regionCode(UPDATED_REGION_CODE)
            .nationality(UPDATED_NATIONALITY)
            .psuedoRoomYn(UPDATED_PSUEDO_ROOM_YN)
            .adultsTaxFree(UPDATED_ADULTS_TAX_FREE)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .stayRooms(UPDATED_STAY_ROOMS)
            .stayPersons(UPDATED_STAY_PERSONS)
            .stayAdults(UPDATED_STAY_ADULTS)
            .stayChildren(UPDATED_STAY_CHILDREN)
            .arrRooms(UPDATED_ARR_ROOMS)
            .arrPersons(UPDATED_ARR_PERSONS)
            .depRooms(UPDATED_DEP_ROOMS)
            .depPersons(UPDATED_DEP_PERSONS)
            .dayUseRooms(UPDATED_DAY_USE_ROOMS)
            .dayUsePersons(UPDATED_DAY_USE_PERSONS)
            .cancelledRooms(UPDATED_CANCELLED_ROOMS)
            .cancelledPersons(UPDATED_CANCELLED_PERSONS)
            .noShowRooms(UPDATED_NO_SHOW_ROOMS)
            .noShowPersons(UPDATED_NO_SHOW_PERSONS)
            .singleOccupancy(UPDATED_SINGLE_OCCUPANCY)
            .multipleOccupancy(UPDATED_MULTIPLE_OCCUPANCY)
            .cribs(UPDATED_CRIBS)
            .extraBeds(UPDATED_EXTRA_BEDS)
            .otherRevenue(UPDATED_OTHER_REVENUE)
            .packageOtherRevenue(UPDATED_PACKAGE_OTHER_REVENUE)
            .totalOtherTax(UPDATED_TOTAL_OTHER_TAX)
            .countryMainGroup(UPDATED_COUNTRY_MAIN_GROUP)
            .state(UPDATED_STATE)
            .fiscalRegionCode(UPDATED_FISCAL_REGION_CODE)
            .nonRevenue(UPDATED_NON_REVENUE)
            .packageNonRevenue(UPDATED_PACKAGE_NON_REVENUE)
            .totalNonRevenueTax(UPDATED_TOTAL_NON_REVENUE_TAX)
            .prRoomRevenue(UPDATED_PR_ROOM_REVENUE)
            .prFoodRevenue(UPDATED_PR_FOOD_REVENUE)
            .prPackageRoomRevenue(UPDATED_PR_PACKAGE_ROOM_REVENUE)
            .prPackageFoodRevenue(UPDATED_PR_PACKAGE_FOOD_REVENUE)
            .prTotalRoomTax(UPDATED_PR_TOTAL_ROOM_TAX)
            .prTotalFoodTax(UPDATED_PR_TOTAL_FOOD_TAX)
            .prTotalPackageRevenue(UPDATED_PR_TOTAL_PACKAGE_REVENUE)
            .prTotalRevenue(UPDATED_PR_TOTAL_REVENUE)
            .prTotalTax(UPDATED_PR_TOTAL_TAX)
            .prOtherRevenue(UPDATED_PR_OTHER_REVENUE)
            .prPackageOtherRevenue(UPDATED_PR_PACKAGE_OTHER_REVENUE)
            .prTotalOtherTax(UPDATED_PR_TOTAL_OTHER_TAX)
            .prNonRevenue(UPDATED_PR_NON_REVENUE)
            .prPackageNonRevenue(UPDATED_PR_PACKAGE_NON_REVENUE)
            .prTotalNonRevenueTax(UPDATED_PR_TOTAL_NON_REVENUE_TAX)
            .nights(UPDATED_NIGHTS)
            .noOfStays(UPDATED_NO_OF_STAYS)
            .reservationNights(UPDATED_RESERVATION_NIGHTS)
            .reservationArrivals(UPDATED_RESERVATION_ARRIVALS)
            .reservationNoOfStays(UPDATED_RESERVATION_NO_OF_STAYS)
            .dayUseReservations(UPDATED_DAY_USE_RESERVATIONS)
            .cancelledReservations(UPDATED_CANCELLED_RESERVATIONS)
            .noShowReservations(UPDATED_NO_SHOW_RESERVATIONS)
            .city(UPDATED_CITY)
            .zipCode(UPDATED_ZIP_CODE)
            .district(UPDATED_DISTRICT)
            .cashRoomNts(UPDATED_CASH_ROOM_NTS)
            .compRoomNts(UPDATED_COMP_ROOM_NTS)
            .cashRoomRevenue(UPDATED_CASH_ROOM_REVENUE)
            .compRoomRevenue(UPDATED_COMP_ROOM_REVENUE)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .resInsertSourceType(UPDATED_RES_INSERT_SOURCE_TYPE)
            .children1(UPDATED_CHILDREN_1)
            .children2(UPDATED_CHILDREN_2)
            .children3(UPDATED_CHILDREN_3)
            .children4(UPDATED_CHILDREN_4)
            .children5(UPDATED_CHILDREN_5)
            .ffMembershipType(UPDATED_FF_MEMBERSHIP_TYPE)
            .fgMembershipType(UPDATED_FG_MEMBERSHIP_TYPE)
            .promotionCode(UPDATED_PROMOTION_CODE)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .ownerRentalFlag(UPDATED_OWNER_RENTAL_FLAG)
            .centralCurrencyCode(UPDATED_CENTRAL_CURRENCY_CODE)
            .centralExchangeRate(UPDATED_CENTRAL_EXCHANGE_RATE)
            .bookedRoomCategory(UPDATED_BOOKED_ROOM_CATEGORY)
            .businessDateCreated(UPDATED_BUSINESS_DATE_CREATED)
            .rateAmount(UPDATED_RATE_AMOUNT)
            .parentCompanyId(UPDATED_PARENT_COMPANY_ID)
            .houseUseYn(UPDATED_HOUSE_USE_YN)
            .complimentaryYn(UPDATED_COMPLIMENTARY_YN)
            .biResvNameId(UPDATED_BI_RESV_NAME_ID)
            .advFoodRevenue(UPDATED_ADV_FOOD_REVENUE)
            .advNonRevenue(UPDATED_ADV_NON_REVENUE)
            .advOtherRevenue(UPDATED_ADV_OTHER_REVENUE)
            .advRoomRevenue(UPDATED_ADV_ROOM_REVENUE)
            .advTotalFoodTax(UPDATED_ADV_TOTAL_FOOD_TAX)
            .advTotalNonRevenueTax(UPDATED_ADV_TOTAL_NON_REVENUE_TAX)
            .advTotalOtherTax(UPDATED_ADV_TOTAL_OTHER_TAX)
            .advTotalRevenue(UPDATED_ADV_TOTAL_REVENUE)
            .advTotalRoomTax(UPDATED_ADV_TOTAL_ROOM_TAX)
            .advTotalTax(UPDATED_ADV_TOTAL_TAX)
            .prAdvFoodRevenue(UPDATED_PR_ADV_FOOD_REVENUE)
            .prAdvNonRevenue(UPDATED_PR_ADV_NON_REVENUE)
            .prAdvOtherRevenue(UPDATED_PR_ADV_OTHER_REVENUE)
            .prAdvRoomRevenue(UPDATED_PR_ADV_ROOM_REVENUE)
            .prAdvTotalFoodTax(UPDATED_PR_ADV_TOTAL_FOOD_TAX)
            .prAdvTotalNonRevenueTax(UPDATED_PR_ADV_TOTAL_NON_REVENUE_TAX)
            .prAdvTotalOtherTax(UPDATED_PR_ADV_TOTAL_OTHER_TAX)
            .prAdvTotalRevenue(UPDATED_PR_ADV_TOTAL_REVENUE)
            .prAdvTotalRoomTax(UPDATED_PR_ADV_TOTAL_ROOM_TAX)
            .prAdvTotalTax(UPDATED_PR_ADV_TOTAL_TAX)
            .upsoldRevenue(UPDATED_UPSOLD_REVENUE)
            .flgdRoomRevenue(UPDATED_FLGD_ROOM_REVENUE)
            .flgdFoodRevenue(UPDATED_FLGD_FOOD_REVENUE)
            .flgdNonRevenue(UPDATED_FLGD_NON_REVENUE)
            .flgdOtherRevenue(UPDATED_FLGD_OTHER_REVENUE)
            .flgdTotalRoomTax(UPDATED_FLGD_TOTAL_ROOM_TAX)
            .flgdTotalFoodTax(UPDATED_FLGD_TOTAL_FOOD_TAX)
            .flgdTotalNonRevenueTax(UPDATED_FLGD_TOTAL_NON_REVENUE_TAX)
            .flgdTotalOtherTax(UPDATED_FLGD_TOTAL_OTHER_TAX)
            .flgdTotalRevenue(UPDATED_FLGD_TOTAL_REVENUE)
            .flgdTotalTax(UPDATED_FLGD_TOTAL_TAX)
            .contactYn(UPDATED_CONTACT_YN)
            .extendedStayTier(UPDATED_EXTENDED_STAY_TIER)
            .rsAdvTotalRevenue(UPDATED_RS_ADV_TOTAL_REVENUE)
            .rsAdvRoomRevenue(UPDATED_RS_ADV_ROOM_REVENUE)
            .rsAdvFoodRevenue(UPDATED_RS_ADV_FOOD_REVENUE)
            .rsAdvOtherRevenue(UPDATED_RS_ADV_OTHER_REVENUE)
            .rsAdvNonRevenue(UPDATED_RS_ADV_NON_REVENUE)
            .rsAdvTotalTax(UPDATED_RS_ADV_TOTAL_TAX)
            .rsAdvRoomTax(UPDATED_RS_ADV_ROOM_TAX)
            .rsAdvFoodTax(UPDATED_RS_ADV_FOOD_TAX)
            .rsAdvOtherTax(UPDATED_RS_ADV_OTHER_TAX)
            .rsAdvNonRevenueTax(UPDATED_RS_ADV_NON_REVENUE_TAX)
            .updateDate(UPDATED_UPDATE_DATE)
            .guid(UPDATED_GUID);

        restReservationStatDailyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReservationStatDaily.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReservationStatDaily))
            )
            .andExpect(status().isOk());

        // Validate the ReservationStatDaily in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReservationStatDailyUpdatableFieldsEquals(
            partialUpdatedReservationStatDaily,
            getPersistedReservationStatDaily(partialUpdatedReservationStatDaily)
        );
    }

    @Test
    @Transactional
    void patchNonExistingReservationStatDaily() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationStatDaily.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReservationStatDailyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, reservationStatDaily.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reservationStatDaily))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationStatDaily in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchReservationStatDaily() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationStatDaily.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationStatDailyMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reservationStatDaily))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationStatDaily in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamReservationStatDaily() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationStatDaily.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationStatDailyMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(reservationStatDaily)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReservationStatDaily in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteReservationStatDaily() throws Exception {
        // Initialize the database
        reservationStatDailyRepository.saveAndFlush(reservationStatDaily);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the reservationStatDaily
        restReservationStatDailyMockMvc
            .perform(delete(ENTITY_API_URL_ID, reservationStatDaily.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return reservationStatDailyRepository.count();
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

    protected ReservationStatDaily getPersistedReservationStatDaily(ReservationStatDaily reservationStatDaily) {
        return reservationStatDailyRepository.findById(reservationStatDaily.getId()).orElseThrow();
    }

    protected void assertPersistedReservationStatDailyToMatchAllProperties(ReservationStatDaily expectedReservationStatDaily) {
        assertReservationStatDailyAllPropertiesEquals(
            expectedReservationStatDaily,
            getPersistedReservationStatDaily(expectedReservationStatDaily)
        );
    }

    protected void assertPersistedReservationStatDailyToMatchUpdatableProperties(ReservationStatDaily expectedReservationStatDaily) {
        assertReservationStatDailyAllUpdatablePropertiesEquals(
            expectedReservationStatDaily,
            getPersistedReservationStatDaily(expectedReservationStatDaily)
        );
    }
}
