package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.ResortAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static com.sbm.mc.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.Resort;
import com.sbm.mc.repository.ResortRepository;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link ResortResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ResortResourceIT {

    private static final String DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_RESORT = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_BEGIN_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_BEGIN_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_CHECK_IN_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CHECK_IN_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_CHECK_OUT_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CHECK_OUT_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_VIDEO_CO_START = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_VIDEO_CO_START = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_VIDEO_CO_STOP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_VIDEO_CO_STOP = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_INSERT_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_INSERT_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_UPDATE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_UPDATE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_EXPIRY_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_EXPIRY_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_END_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_END_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_FISCAL_START_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_FISCAL_START_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_FISCAL_END_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_FISCAL_END_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_RECONCILE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_RECONCILE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_PAYMENT_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_PAYMENT_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Integer DEFAULT_KEEP_AVAILABILITY = 1;
    private static final Integer UPDATED_KEEP_AVAILABILITY = 2;

    private static final Integer DEFAULT_BUDGET_MONTH = 1;
    private static final Integer UPDATED_BUDGET_MONTH = 2;

    private static final Integer DEFAULT_SAVE_PROFILES = 1;
    private static final Integer UPDATED_SAVE_PROFILES = 2;

    private static final Integer DEFAULT_LONG_STAY_CONTROL = 1;
    private static final Integer UPDATED_LONG_STAY_CONTROL = 2;

    private static final Integer DEFAULT_CREDIT_LIMIT = 1;
    private static final Integer UPDATED_CREDIT_LIMIT = 2;

    private static final Integer DEFAULT_NUMBER_ROOMS = 1;
    private static final Integer UPDATED_NUMBER_ROOMS = 2;

    private static final Integer DEFAULT_NUMBER_FLOORS = 1;
    private static final Integer UPDATED_NUMBER_FLOORS = 2;

    private static final Integer DEFAULT_NUMBER_BEDS = 1;
    private static final Integer UPDATED_NUMBER_BEDS = 2;

    private static final Integer DEFAULT_RHYTHM_SHEETS = 1;
    private static final Integer UPDATED_RHYTHM_SHEETS = 2;

    private static final Integer DEFAULT_RHYTHM_TOWELS = 1;
    private static final Integer UPDATED_RHYTHM_TOWELS = 2;

    private static final Integer DEFAULT_WARNING_AMOUNT = 1;
    private static final Integer UPDATED_WARNING_AMOUNT = 2;

    private static final Integer DEFAULT_DECIMAL_PLACES = 1;
    private static final Integer UPDATED_DECIMAL_PLACES = 2;

    private static final Integer DEFAULT_FONT = 1;
    private static final Integer UPDATED_FONT = 2;

    private static final Integer DEFAULT_COPIES = 1;
    private static final Integer UPDATED_COPIES = 2;

    private static final Integer DEFAULT_DEFAULT_FOLIO_STYLE = 1;
    private static final Integer UPDATED_DEFAULT_FOLIO_STYLE = 2;

    private static final Integer DEFAULT_INDIVIDUAL_ROOM_WARNING = 1;
    private static final Integer UPDATED_INDIVIDUAL_ROOM_WARNING = 2;

    private static final Integer DEFAULT_GROUP_ROOM_WARNING = 1;
    private static final Integer UPDATED_GROUP_ROOM_WARNING = 2;

    private static final Integer DEFAULT_AGING_LEVEL_1 = 1;
    private static final Integer UPDATED_AGING_LEVEL_1 = 2;

    private static final Integer DEFAULT_AGING_LEVEL_2 = 1;
    private static final Integer UPDATED_AGING_LEVEL_2 = 2;

    private static final Integer DEFAULT_AGING_LEVEL_3 = 1;
    private static final Integer UPDATED_AGING_LEVEL_3 = 2;

    private static final Integer DEFAULT_AGING_LEVEL_4 = 1;
    private static final Integer UPDATED_AGING_LEVEL_4 = 2;

    private static final Integer DEFAULT_AGING_LEVEL_5 = 1;
    private static final Integer UPDATED_AGING_LEVEL_5 = 2;

    private static final Integer DEFAULT_ZERO_INV_PUR_DAYS = 1;
    private static final Integer UPDATED_ZERO_INV_PUR_DAYS = 2;

    private static final Integer DEFAULT_MIN_DAYS_BET_2_REMINDER_LETTER = 1;
    private static final Integer UPDATED_MIN_DAYS_BET_2_REMINDER_LETTER = 2;

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final Integer DEFAULT_CURRENCY_DECIMALS = 1;
    private static final Integer UPDATED_CURRENCY_DECIMALS = 2;

    private static final Integer DEFAULT_NAME_ID_LINK = 1;
    private static final Integer UPDATED_NAME_ID_LINK = 2;

    private static final Integer DEFAULT_SGL_RATE_1 = 1;
    private static final Integer UPDATED_SGL_RATE_1 = 2;

    private static final Integer DEFAULT_SGL_RATE_2 = 1;
    private static final Integer UPDATED_SGL_RATE_2 = 2;

    private static final Integer DEFAULT_DBL_RATE_1 = 1;
    private static final Integer UPDATED_DBL_RATE_1 = 2;

    private static final Integer DEFAULT_DBL_RATE_2 = 1;
    private static final Integer UPDATED_DBL_RATE_2 = 2;

    private static final Integer DEFAULT_TPL_RATE_1 = 1;
    private static final Integer UPDATED_TPL_RATE_1 = 2;

    private static final Integer DEFAULT_TPL_RATE_2 = 1;
    private static final Integer UPDATED_TPL_RATE_2 = 2;

    private static final Integer DEFAULT_SUI_RATE_1 = 1;
    private static final Integer UPDATED_SUI_RATE_1 = 2;

    private static final Integer DEFAULT_SUI_RATE_2 = 1;
    private static final Integer UPDATED_SUI_RATE_2 = 2;

    private static final Integer DEFAULT_MEET_SPACE = 1;
    private static final Integer UPDATED_MEET_SPACE = 2;

    private static final Integer DEFAULT_IMG_HOTEL_ID = 1;
    private static final Integer UPDATED_IMG_HOTEL_ID = 2;

    private static final Integer DEFAULT_IMG_DIRECTION_ID = 1;
    private static final Integer UPDATED_IMG_DIRECTION_ID = 2;

    private static final Integer DEFAULT_IMG_MAP_ID = 1;
    private static final Integer UPDATED_IMG_MAP_ID = 2;

    private static final Integer DEFAULT_SCRIPT_ID = 1;
    private static final Integer UPDATED_SCRIPT_ID = 2;

    private static final Integer DEFAULT_COM_NAME_XREF_ID = 1;
    private static final Integer UPDATED_COM_NAME_XREF_ID = 2;

    private static final Integer DEFAULT_PATH_ID = 1;
    private static final Integer UPDATED_PATH_ID = 2;

    private static final Integer DEFAULT_XRESORT_NUMBER = 1;
    private static final Integer UPDATED_XRESORT_NUMBER = 2;

    private static final Integer DEFAULT_MAX_CREDIT_DAYS = 1;
    private static final Integer UPDATED_MAX_CREDIT_DAYS = 2;

    private static final Integer DEFAULT_CURRENCY_DIVISOR = 1;
    private static final Integer UPDATED_CURRENCY_DIVISOR = 2;

    private static final Integer DEFAULT_LATITUDE = 1;
    private static final Integer UPDATED_LATITUDE = 2;

    private static final Integer DEFAULT_LONGITUDE = 1;
    private static final Integer UPDATED_LONGITUDE = 2;

    private static final Integer DEFAULT_QTY_SINGLE_ROOMS = 1;
    private static final Integer UPDATED_QTY_SINGLE_ROOMS = 2;

    private static final Integer DEFAULT_QTY_DOUBLE_ROOMS = 1;
    private static final Integer UPDATED_QTY_DOUBLE_ROOMS = 2;

    private static final Integer DEFAULT_QTY_TWIN_ROOMS = 1;
    private static final Integer UPDATED_QTY_TWIN_ROOMS = 2;

    private static final Integer DEFAULT_QTY_SUITES = 1;
    private static final Integer UPDATED_QTY_SUITES = 2;

    private static final Integer DEFAULT_QTY_GUEST_ROOM_FLOORS = 1;
    private static final Integer UPDATED_QTY_GUEST_ROOM_FLOORS = 2;

    private static final Integer DEFAULT_QTY_GUEST_ELEVATORS = 1;
    private static final Integer UPDATED_QTY_GUEST_ELEVATORS = 2;

    private static final Integer DEFAULT_QTY_NON_SMOKING_ROOMS = 1;
    private static final Integer UPDATED_QTY_NON_SMOKING_ROOMS = 2;

    private static final Integer DEFAULT_QTY_CONNECTING_ROOMS = 1;
    private static final Integer UPDATED_QTY_CONNECTING_ROOMS = 2;

    private static final Integer DEFAULT_QTY_HANDICAPPED_ROOMS = 1;
    private static final Integer UPDATED_QTY_HANDICAPPED_ROOMS = 2;

    private static final Integer DEFAULT_QTY_FAMILY_ROOMS = 1;
    private static final Integer UPDATED_QTY_FAMILY_ROOMS = 2;

    private static final Integer DEFAULT_MAX_ADULTS_FAMILY_ROOM = 1;
    private static final Integer UPDATED_MAX_ADULTS_FAMILY_ROOM = 2;

    private static final Integer DEFAULT_MAX_CHILDREN_FAMILY_ROOM = 1;
    private static final Integer UPDATED_MAX_CHILDREN_FAMILY_ROOM = 2;

    private static final Integer DEFAULT_RESTAURANT = 1;
    private static final Integer UPDATED_RESTAURANT = 2;

    private static final Integer DEFAULT_MEET_ROOMS = 1;
    private static final Integer UPDATED_MEET_ROOMS = 2;

    private static final Integer DEFAULT_TOT_ROOMS = 1;
    private static final Integer UPDATED_TOT_ROOMS = 2;

    private static final Integer DEFAULT_BR_SEATS = 1;
    private static final Integer UPDATED_BR_SEATS = 2;

    private static final Integer DEFAULT_MEET_SEATS = 1;
    private static final Integer UPDATED_MEET_SEATS = 2;

    private static final Integer DEFAULT_MAX_NO_NIGHTS = 1;
    private static final Integer UPDATED_MAX_NO_NIGHTS = 2;

    private static final Integer DEFAULT_AWARDS_TIMEOUT = 1;
    private static final Integer UPDATED_AWARDS_TIMEOUT = 2;

    private static final Integer DEFAULT_GUEST_LOOKUP_TIMEOUT = 1;
    private static final Integer UPDATED_GUEST_LOOKUP_TIMEOUT = 2;

    private static final Integer DEFAULT_WAKE_UP_DELAY = 1;
    private static final Integer UPDATED_WAKE_UP_DELAY = 2;

    private static final Integer DEFAULT_MAX_OCCUPANCY = 1;
    private static final Integer UPDATED_MAX_OCCUPANCY = 2;

    private static final Integer DEFAULT_INACTIVE_DAYS_FOR_GUEST_PROFIL = 1;
    private static final Integer UPDATED_INACTIVE_DAYS_FOR_GUEST_PROFIL = 2;

    private static final Integer DEFAULT_PER_RESERVATION_ROOM_LIMIT = 1;
    private static final Integer UPDATED_PER_RESERVATION_ROOM_LIMIT = 2;

    private static final String DEFAULT_LIC_ROOM_INFO = "AAAAAAAAAA";
    private static final String UPDATED_LIC_ROOM_INFO = "BBBBBBBBBB";

    private static final String DEFAULT_THOUSAND_SEPARATOR = "AAAAAAAAAA";
    private static final String UPDATED_THOUSAND_SEPARATOR = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_SEPARATOR = "AAAAAAAAAA";
    private static final String UPDATED_DATE_SEPARATOR = "BBBBBBBBBB";

    private static final String DEFAULT_AR_ACCT_NO_MAND_YN = "AAAAAAAAAA";
    private static final String UPDATED_AR_ACCT_NO_MAND_YN = "BBBBBBBBBB";

    private static final String DEFAULT_EXCHANGE_POSTING_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_EXCHANGE_POSTING_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_INVENTORY_YN = "AAAAAAAAAA";
    private static final String UPDATED_INVENTORY_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ALLOW_LOGIN_YN = "AAAAAAAAAA";
    private static final String UPDATED_ALLOW_LOGIN_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DISABLE_LOGIN_YN = "AAAAAAAAAA";
    private static final String UPDATED_DISABLE_LOGIN_YN = "BBBBBBBBBB";

    private static final String DEFAULT_INT_TAX_INCLUDED_YN = "AAAAAAAAAA";
    private static final String UPDATED_INT_TAX_INCLUDED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_DOWNLOAD_REST_YN = "AAAAAAAAAA";
    private static final String UPDATED_DOWNLOAD_REST_YN = "BBBBBBBBBB";

    private static final String DEFAULT_TRANSLATE_MULTICHAR_YN = "AAAAAAAAAA";
    private static final String UPDATED_TRANSLATE_MULTICHAR_YN = "BBBBBBBBBB";

    private static final String DEFAULT_EXTERNAL_SC_YN = "AAAAAAAAAA";
    private static final String UPDATED_EXTERNAL_SC_YN = "BBBBBBBBBB";

    private static final String DEFAULT_SEND_LEAD_AS_BOOKING_YN = "AAAAAAAAAA";
    private static final String UPDATED_SEND_LEAD_AS_BOOKING_YN = "BBBBBBBBBB";

    private static final String DEFAULT_MBS_SUPPORTED_YN = "AAAAAAAAAA";
    private static final String UPDATED_MBS_SUPPORTED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_QUOTED_CURRENCY = "AAAAAAAAAA";
    private static final String UPDATED_QUOTED_CURRENCY = "BBBBBBBBBB";

    private static final String DEFAULT_COM_METHOD = "AAAAAAAAAA";
    private static final String UPDATED_COM_METHOD = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_GENMGR = "AAAAAAAAAA";
    private static final String UPDATED_GENMGR = "BBBBBBBBBB";

    private static final String DEFAULT_DIRSALES = "AAAAAAAAAA";
    private static final String UPDATED_DIRSALES = "BBBBBBBBBB";

    private static final String DEFAULT_LEADSEND = "AAAAAAAAAA";
    private static final String UPDATED_LEADSEND = "BBBBBBBBBB";

    private static final String DEFAULT_AIRPORT = "AAAAAAAAAA";
    private static final String UPDATED_AIRPORT = "BBBBBBBBBB";

    private static final String DEFAULT_COM_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_COM_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_SEASON_1 = "AAAAAAAAAA";
    private static final String UPDATED_SEASON_1 = "BBBBBBBBBB";

    private static final String DEFAULT_SEASON_2 = "AAAAAAAAAA";
    private static final String UPDATED_SEASON_2 = "BBBBBBBBBB";

    private static final String DEFAULT_SEASON_3 = "AAAAAAAAAA";
    private static final String UPDATED_SEASON_3 = "BBBBBBBBBB";

    private static final String DEFAULT_SEASON_4 = "AAAAAAAAAA";
    private static final String UPDATED_SEASON_4 = "BBBBBBBBBB";

    private static final String DEFAULT_SEASON_5 = "AAAAAAAAAA";
    private static final String UPDATED_SEASON_5 = "BBBBBBBBBB";

    private static final String DEFAULT_FLOOR_NUM_EXECUTIVE_FLOOR = "AAAAAAAAAA";
    private static final String UPDATED_FLOOR_NUM_EXECUTIVE_FLOOR = "BBBBBBBBBB";

    private static final String DEFAULT_CRS_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_CRS_RESORT = "BBBBBBBBBB";

    private static final String DEFAULT_POST_CODE = "AAAAAAAAAA";
    private static final String UPDATED_POST_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_RESERVATION_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_RESERVATION_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_BLOCK = "AAAAAAAAAA";
    private static final String UPDATED_BLOCK = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENCY_SYMBOL = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY_SYMBOL = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE_COMMISSION = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_COMMISSION = "BBBBBBBBBB";

    private static final String DEFAULT_TA_COMMISSION = "AAAAAAAAAA";
    private static final String UPDATED_TA_COMMISSION = "BBBBBBBBBB";

    private static final String DEFAULT_BASE_LANGUAGE = "AAAAAAAAAA";
    private static final String UPDATED_BASE_LANGUAGE = "BBBBBBBBBB";

    private static final String DEFAULT_FOLIO_LANGUAGE_1 = "AAAAAAAAAA";
    private static final String UPDATED_FOLIO_LANGUAGE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_FOLIO_LANGUAGE_2 = "AAAAAAAAAA";
    private static final String UPDATED_FOLIO_LANGUAGE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_FOLIO_LANGUAGE_3 = "AAAAAAAAAA";
    private static final String UPDATED_FOLIO_LANGUAGE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_FOLIO_LANGUAGE_4 = "AAAAAAAAAA";
    private static final String UPDATED_FOLIO_LANGUAGE_4 = "BBBBBBBBBB";

    private static final String DEFAULT_PACKAGE_PROFIT = "AAAAAAAAAA";
    private static final String UPDATED_PACKAGE_PROFIT = "BBBBBBBBBB";

    private static final String DEFAULT_PACKAGE_LOSS = "AAAAAAAAAA";
    private static final String UPDATED_PACKAGE_LOSS = "BBBBBBBBBB";

    private static final String DEFAULT_DECIMAL_SEPARATOR = "AAAAAAAAAA";
    private static final String UPDATED_DECIMAL_SEPARATOR = "BBBBBBBBBB";

    private static final String DEFAULT_SHORT_DATE_FORMAT = "AAAAAAAAAA";
    private static final String UPDATED_SHORT_DATE_FORMAT = "BBBBBBBBBB";

    private static final String DEFAULT_LONG_DATE_FORMAT = "AAAAAAAAAA";
    private static final String UPDATED_LONG_DATE_FORMAT = "BBBBBBBBBB";

    private static final String DEFAULT_PASSERBY_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_PASSERBY_SOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_PASSERBY_MARKET = "AAAAAAAAAA";
    private static final String UPDATED_PASSERBY_MARKET = "BBBBBBBBBB";

    private static final String DEFAULT_AR_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_AR_COMPANY = "BBBBBBBBBB";

    private static final String DEFAULT_AR_AGENT = "AAAAAAAAAA";
    private static final String UPDATED_AR_AGENT = "BBBBBBBBBB";

    private static final String DEFAULT_AR_GROUPS = "AAAAAAAAAA";
    private static final String UPDATED_AR_GROUPS = "BBBBBBBBBB";

    private static final String DEFAULT_AR_INDIVIDUALS = "AAAAAAAAAA";
    private static final String UPDATED_AR_INDIVIDUALS = "BBBBBBBBBB";

    private static final String DEFAULT_AR_ACCT_NO_FORMAT = "AAAAAAAAAA";
    private static final String UPDATED_AR_ACCT_NO_FORMAT = "BBBBBBBBBB";

    private static final String DEFAULT_ALLOWANCE_PERIOD_ADJ = "AAAAAAAAAA";
    private static final String UPDATED_ALLOWANCE_PERIOD_ADJ = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_TURNAWAY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_TURNAWAY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SUMM_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SUMM_CURRENCY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_PROPERTY_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_PROPERTY_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_GUEST_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_GUEST_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_LICENSE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_LICENSE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_TIME_FORMAT = "AAAAAAAAAA";
    private static final String UPDATED_TIME_FORMAT = "BBBBBBBBBB";

    private static final String DEFAULT_CHAIN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CHAIN_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_RESORT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_RESORT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_HOTEL_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_HOTEL_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_OWNERSHIP = "AAAAAAAAAA";
    private static final String UPDATED_OWNERSHIP = "BBBBBBBBBB";

    private static final String DEFAULT_AR_BAL_TRX_CODE = "AAAAAAAAAA";
    private static final String UPDATED_AR_BAL_TRX_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_AR_CREDIT_TRX_CODE = "AAAAAAAAAA";
    private static final String UPDATED_AR_CREDIT_TRX_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_AR_SETTLE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_AR_SETTLE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CASH_SHIFT_DROP = "AAAAAAAAAA";
    private static final String UPDATED_CASH_SHIFT_DROP = "BBBBBBBBBB";

    private static final String DEFAULT_CHECK_EXG_PAIDOUT = "AAAAAAAAAA";
    private static final String UPDATED_CHECK_EXG_PAIDOUT = "BBBBBBBBBB";

    private static final String DEFAULT_CHECK_SHIFT_DROP = "AAAAAAAAAA";
    private static final String UPDATED_CHECK_SHIFT_DROP = "BBBBBBBBBB";

    private static final String DEFAULT_CHECK_TRXCODE = "AAAAAAAAAA";
    private static final String UPDATED_CHECK_TRXCODE = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENCY_EXG_PAIDOUT = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY_EXG_PAIDOUT = "BBBBBBBBBB";

    private static final String DEFAULT_DEPOSIT_LED_TRX_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DEPOSIT_LED_TRX_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_FISCAL_PERIOD_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_FISCAL_PERIOD_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_COMMISSION_PERCENTAGE = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_COMMISSION_PERCENTAGE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_PREPAID_COMM = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_PREPAID_COMM = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_TRX_COMM_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_TRX_COMM_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CONFIGURATION_MODE = "AAAAAAAAAA";
    private static final String UPDATED_CONFIGURATION_MODE = "BBBBBBBBBB";

    private static final String DEFAULT_WEEKEND_DAYS = "AAAAAAAAAA";
    private static final String UPDATED_WEEKEND_DAYS = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_GROUPS_RATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_GROUPS_RATE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_POSTING_ROOM = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_POSTING_ROOM = "BBBBBBBBBB";

    private static final String DEFAULT_DFLT_PKG_TRAN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DFLT_PKG_TRAN_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DFLT_TRAN_CODE_RATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DFLT_TRAN_CODE_RATE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_RATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_RATE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CRO_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CRO_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_FLOW_CODE = "AAAAAAAAAA";
    private static final String UPDATED_FLOW_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_EXT_PROPERTY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_EXT_PROPERTY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_OPUS_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_OPUS_CURRENCY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DESTINATION_ID = "AAAAAAAAAA";
    private static final String UPDATED_DESTINATION_ID = "BBBBBBBBBB";

    private static final String DEFAULT_FLAGS = "AAAAAAAAAA";
    private static final String UPDATED_FLAGS = "BBBBBBBBBB";

    private static final String DEFAULT_TOURIST_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_TOURIST_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_CATERING_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CATERING_CURRENCY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_RATECODE_RACK = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_RATECODE_RACK = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_RATECODE_PCR = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_RATECODE_PCR = "BBBBBBBBBB";

    private static final String DEFAULT_FNS_TIER = "AAAAAAAAAA";
    private static final String UPDATED_FNS_TIER = "BBBBBBBBBB";

    private static final String DEFAULT_BRAND_CODE = "AAAAAAAAAA";
    private static final String UPDATED_BRAND_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_WEBADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_WEBADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_VAT_ID = "AAAAAAAAAA";
    private static final String UPDATED_VAT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_STREET = "AAAAAAAAAA";
    private static final String UPDATED_STREET = "BBBBBBBBBB";

    private static final String DEFAULT_HOTEL_FC = "AAAAAAAAAA";
    private static final String UPDATED_HOTEL_FC = "BBBBBBBBBB";

    private static final String DEFAULT_MEETING_FC = "AAAAAAAAAA";
    private static final String UPDATED_MEETING_FC = "BBBBBBBBBB";

    private static final String DEFAULT_AR_TYPEWRITER = "AAAAAAAAAA";
    private static final String UPDATED_AR_TYPEWRITER = "BBBBBBBBBB";

    private static final String DEFAULT_FILE_TRANSFER_FORMAT = "AAAAAAAAAA";
    private static final String UPDATED_FILE_TRANSFER_FORMAT = "BBBBBBBBBB";

    private static final String DEFAULT_CONFIRM_REGCARD_PRINTER = "AAAAAAAAAA";
    private static final String UPDATED_CONFIRM_REGCARD_PRINTER = "BBBBBBBBBB";

    private static final String DEFAULT_DIRECTIONS = "AAAAAAAAAA";
    private static final String UPDATED_DIRECTIONS = "BBBBBBBBBB";

    private static final String DEFAULT_PROPINFO_URL = "AAAAAAAAAA";
    private static final String UPDATED_PROPINFO_URL = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_AMENITY = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_AMENITY = "BBBBBBBBBB";

    private static final String DEFAULT_SHOP_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_SHOP_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_PROP_PIC_URL = "AAAAAAAAAA";
    private static final String UPDATED_PROP_PIC_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PROP_MAP_URL = "AAAAAAAAAA";
    private static final String UPDATED_PROP_MAP_URL = "BBBBBBBBBB";

    private static final String DEFAULT_EXT_EXP_FILE_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_EXT_EXP_FILE_LOCATION = "BBBBBBBBBB";

    private static final String DEFAULT_CURTAIN_COLOR = "AAAAAAAAAA";
    private static final String UPDATED_CURTAIN_COLOR = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTRY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_STATE = "AAAAAAAAAA";
    private static final String UPDATED_STATE = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_FOR_AGING = "AAAAAAAAAA";
    private static final String UPDATED_DATE_FOR_AGING = "BBBBBBBBBB";

    private static final String DEFAULT_REGION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_REGION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_TELEPHONE = "AAAAAAAAAA";
    private static final String UPDATED_TELEPHONE = "BBBBBBBBBB";

    private static final String DEFAULT_FAX = "AAAAAAAAAA";
    private static final String UPDATED_FAX = "BBBBBBBBBB";

    private static final String DEFAULT_TOLLFREE = "AAAAAAAAAA";
    private static final String UPDATED_TOLLFREE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_PRINTER = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_PRINTER = "BBBBBBBBBB";

    private static final String DEFAULT_VIDEOCHECKOUT_PRINTER = "AAAAAAAAAA";
    private static final String UPDATED_VIDEOCHECKOUT_PRINTER = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_ADDRESS_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_ADDRESS_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_PHONE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_PHONE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_FAX_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_FAX_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_MEMBERSHIP_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_MEMBERSHIP_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_INDIVIDUAL_ADDRESS_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_INDIVIDUAL_ADDRESS_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_INDIVIDUAL_PHONE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_INDIVIDUAL_PHONE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_BLACKOUT_PERIOD_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_BLACKOUT_PERIOD_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_SGL_NUM = "AAAAAAAAAA";
    private static final String UPDATED_SGL_NUM = "BBBBBBBBBB";

    private static final String DEFAULT_DBL_NUM = "AAAAAAAAAA";
    private static final String UPDATED_DBL_NUM = "BBBBBBBBBB";

    private static final String DEFAULT_TPL_NUM = "AAAAAAAAAA";
    private static final String UPDATED_TPL_NUM = "BBBBBBBBBB";

    private static final String DEFAULT_SUI_NUM = "AAAAAAAAAA";
    private static final String UPDATED_SUI_NUM = "BBBBBBBBBB";

    private static final String DEFAULT_AIRPORT_DISTANCE = "AAAAAAAAAA";
    private static final String UPDATED_AIRPORT_DISTANCE = "BBBBBBBBBB";

    private static final String DEFAULT_AIRPORT_TIME = "AAAAAAAAAA";
    private static final String UPDATED_AIRPORT_TIME = "BBBBBBBBBB";

    private static final String DEFAULT_BR_AREA = "AAAAAAAAAA";
    private static final String UPDATED_BR_AREA = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LEGAL_OWNER = "AAAAAAAAAA";
    private static final String UPDATED_LEGAL_OWNER = "BBBBBBBBBB";

    private static final String DEFAULT_HOTEL_ID = "AAAAAAAAAA";
    private static final String UPDATED_HOTEL_ID = "BBBBBBBBBB";

    private static final String DEFAULT_FAX_NO_FORMAT = "AAAAAAAAAA";
    private static final String UPDATED_FAX_NO_FORMAT = "BBBBBBBBBB";

    private static final String DEFAULT_TELEPHONE_NO_FORMAT = "AAAAAAAAAA";
    private static final String UPDATED_TELEPHONE_NO_FORMAT = "BBBBBBBBBB";

    private static final String DEFAULT_LOCAL_CURRENCY_FORMAT = "AAAAAAAAAA";
    private static final String UPDATED_LOCAL_CURRENCY_FORMAT = "BBBBBBBBBB";

    private static final String DEFAULT_DUTY_MANAGER_PAGER = "AAAAAAAAAA";
    private static final String UPDATED_DUTY_MANAGER_PAGER = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_REGISTRATION_CARD = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_REGISTRATION_CARD = "BBBBBBBBBB";

    private static final String DEFAULT_NIGHT_AUDIT_CASHIER_ID = "AAAAAAAAAA";
    private static final String UPDATED_NIGHT_AUDIT_CASHIER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_HOTEL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_HOTEL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PATH = "AAAAAAAAAA";
    private static final String UPDATED_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_TIMEZONE_REGION = "AAAAAAAAAA";
    private static final String UPDATED_TIMEZONE_REGION = "BBBBBBBBBB";

    private static final String DEFAULT_CATERING_CURRENCY_FORMAT = "AAAAAAAAAA";
    private static final String UPDATED_CATERING_CURRENCY_FORMAT = "BBBBBBBBBB";

    private static final String DEFAULT_EXP_HOTEL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_EXP_HOTEL_CODE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/resorts";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ResortRepository resortRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restResortMockMvc;

    private Resort resort;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Resort createEntity(EntityManager em) {
        Resort resort = new Resort()
            .resort(DEFAULT_RESORT)
            .beginDate(DEFAULT_BEGIN_DATE)
            .checkInTime(DEFAULT_CHECK_IN_TIME)
            .checkOutTime(DEFAULT_CHECK_OUT_TIME)
            .videoCoStart(DEFAULT_VIDEO_CO_START)
            .videoCoStop(DEFAULT_VIDEO_CO_STOP)
            .insertDate(DEFAULT_INSERT_DATE)
            .updateDate(DEFAULT_UPDATE_DATE)
            .expiryDate(DEFAULT_EXPIRY_DATE)
            .endDate(DEFAULT_END_DATE)
            .fiscalStartDate(DEFAULT_FISCAL_START_DATE)
            .fiscalEndDate(DEFAULT_FISCAL_END_DATE)
            .reconcileDate(DEFAULT_RECONCILE_DATE)
            .paymentDate(DEFAULT_PAYMENT_DATE)
            .keepAvailability(DEFAULT_KEEP_AVAILABILITY)
            .budgetMonth(DEFAULT_BUDGET_MONTH)
            .saveProfiles(DEFAULT_SAVE_PROFILES)
            .longStayControl(DEFAULT_LONG_STAY_CONTROL)
            .creditLimit(DEFAULT_CREDIT_LIMIT)
            .numberRooms(DEFAULT_NUMBER_ROOMS)
            .numberFloors(DEFAULT_NUMBER_FLOORS)
            .numberBeds(DEFAULT_NUMBER_BEDS)
            .rhythmSheets(DEFAULT_RHYTHM_SHEETS)
            .rhythmTowels(DEFAULT_RHYTHM_TOWELS)
            .warningAmount(DEFAULT_WARNING_AMOUNT)
            .decimalPlaces(DEFAULT_DECIMAL_PLACES)
            .font(DEFAULT_FONT)
            .copies(DEFAULT_COPIES)
            .defaultFolioStyle(DEFAULT_DEFAULT_FOLIO_STYLE)
            .individualRoomWarning(DEFAULT_INDIVIDUAL_ROOM_WARNING)
            .groupRoomWarning(DEFAULT_GROUP_ROOM_WARNING)
            .agingLevel1(DEFAULT_AGING_LEVEL_1)
            .agingLevel2(DEFAULT_AGING_LEVEL_2)
            .agingLevel3(DEFAULT_AGING_LEVEL_3)
            .agingLevel4(DEFAULT_AGING_LEVEL_4)
            .agingLevel5(DEFAULT_AGING_LEVEL_5)
            .zeroInvPurDays(DEFAULT_ZERO_INV_PUR_DAYS)
            .minDaysBet2ReminderLetter(DEFAULT_MIN_DAYS_BET_2_REMINDER_LETTER)
            .insertUser(DEFAULT_INSERT_USER)
            .updateUser(DEFAULT_UPDATE_USER)
            .currencyDecimals(DEFAULT_CURRENCY_DECIMALS)
            .nameIdLink(DEFAULT_NAME_ID_LINK)
            .sglRate1(DEFAULT_SGL_RATE_1)
            .sglRate2(DEFAULT_SGL_RATE_2)
            .dblRate1(DEFAULT_DBL_RATE_1)
            .dblRate2(DEFAULT_DBL_RATE_2)
            .tplRate1(DEFAULT_TPL_RATE_1)
            .tplRate2(DEFAULT_TPL_RATE_2)
            .suiRate1(DEFAULT_SUI_RATE_1)
            .suiRate2(DEFAULT_SUI_RATE_2)
            .meetSpace(DEFAULT_MEET_SPACE)
            .imgHotelId(DEFAULT_IMG_HOTEL_ID)
            .imgDirectionId(DEFAULT_IMG_DIRECTION_ID)
            .imgMapId(DEFAULT_IMG_MAP_ID)
            .scriptId(DEFAULT_SCRIPT_ID)
            .comNameXrefId(DEFAULT_COM_NAME_XREF_ID)
            .pathId(DEFAULT_PATH_ID)
            .xresortNumber(DEFAULT_XRESORT_NUMBER)
            .maxCreditDays(DEFAULT_MAX_CREDIT_DAYS)
            .currencyDivisor(DEFAULT_CURRENCY_DIVISOR)
            .latitude(DEFAULT_LATITUDE)
            .longitude(DEFAULT_LONGITUDE)
            .qtySingleRooms(DEFAULT_QTY_SINGLE_ROOMS)
            .qtyDoubleRooms(DEFAULT_QTY_DOUBLE_ROOMS)
            .qtyTwinRooms(DEFAULT_QTY_TWIN_ROOMS)
            .qtySuites(DEFAULT_QTY_SUITES)
            .qtyGuestRoomFloors(DEFAULT_QTY_GUEST_ROOM_FLOORS)
            .qtyGuestElevators(DEFAULT_QTY_GUEST_ELEVATORS)
            .qtyNonSmokingRooms(DEFAULT_QTY_NON_SMOKING_ROOMS)
            .qtyConnectingRooms(DEFAULT_QTY_CONNECTING_ROOMS)
            .qtyHandicappedRooms(DEFAULT_QTY_HANDICAPPED_ROOMS)
            .qtyFamilyRooms(DEFAULT_QTY_FAMILY_ROOMS)
            .maxAdultsFamilyRoom(DEFAULT_MAX_ADULTS_FAMILY_ROOM)
            .maxChildrenFamilyRoom(DEFAULT_MAX_CHILDREN_FAMILY_ROOM)
            .restaurant(DEFAULT_RESTAURANT)
            .meetRooms(DEFAULT_MEET_ROOMS)
            .totRooms(DEFAULT_TOT_ROOMS)
            .brSeats(DEFAULT_BR_SEATS)
            .meetSeats(DEFAULT_MEET_SEATS)
            .maxNoNights(DEFAULT_MAX_NO_NIGHTS)
            .awardsTimeout(DEFAULT_AWARDS_TIMEOUT)
            .guestLookupTimeout(DEFAULT_GUEST_LOOKUP_TIMEOUT)
            .wakeUpDelay(DEFAULT_WAKE_UP_DELAY)
            .maxOccupancy(DEFAULT_MAX_OCCUPANCY)
            .inactiveDaysForGuestProfil(DEFAULT_INACTIVE_DAYS_FOR_GUEST_PROFIL)
            .perReservationRoomLimit(DEFAULT_PER_RESERVATION_ROOM_LIMIT)
            .licRoomInfo(DEFAULT_LIC_ROOM_INFO)
            .thousandSeparator(DEFAULT_THOUSAND_SEPARATOR)
            .dateSeparator(DEFAULT_DATE_SEPARATOR)
            .arAcctNoMandYn(DEFAULT_AR_ACCT_NO_MAND_YN)
            .exchangePostingType(DEFAULT_EXCHANGE_POSTING_TYPE)
            .inventoryYn(DEFAULT_INVENTORY_YN)
            .allowLoginYn(DEFAULT_ALLOW_LOGIN_YN)
            .accessCode(DEFAULT_ACCESS_CODE)
            .disableLoginYn(DEFAULT_DISABLE_LOGIN_YN)
            .intTaxIncludedYn(DEFAULT_INT_TAX_INCLUDED_YN)
            .downloadRestYn(DEFAULT_DOWNLOAD_REST_YN)
            .translateMulticharYn(DEFAULT_TRANSLATE_MULTICHAR_YN)
            .externalScYn(DEFAULT_EXTERNAL_SC_YN)
            .sendLeadAsBookingYn(DEFAULT_SEND_LEAD_AS_BOOKING_YN)
            .mbsSupportedYn(DEFAULT_MBS_SUPPORTED_YN)
            .quotedCurrency(DEFAULT_QUOTED_CURRENCY)
            .comMethod(DEFAULT_COM_METHOD)
            .email(DEFAULT_EMAIL)
            .genmgr(DEFAULT_GENMGR)
            .dirsales(DEFAULT_DIRSALES)
            .leadsend(DEFAULT_LEADSEND)
            .airport(DEFAULT_AIRPORT)
            .comAddress(DEFAULT_COM_ADDRESS)
            .season1(DEFAULT_SEASON_1)
            .season2(DEFAULT_SEASON_2)
            .season3(DEFAULT_SEASON_3)
            .season4(DEFAULT_SEASON_4)
            .season5(DEFAULT_SEASON_5)
            .floorNumExecutiveFloor(DEFAULT_FLOOR_NUM_EXECUTIVE_FLOOR)
            .crsResort(DEFAULT_CRS_RESORT)
            .postCode(DEFAULT_POST_CODE)
            .defaultReservationType(DEFAULT_DEFAULT_RESERVATION_TYPE)
            .block(DEFAULT_BLOCK)
            .currencySymbol(DEFAULT_CURRENCY_SYMBOL)
            .sourceCommission(DEFAULT_SOURCE_COMMISSION)
            .taCommission(DEFAULT_TA_COMMISSION)
            .baseLanguage(DEFAULT_BASE_LANGUAGE)
            .folioLanguage1(DEFAULT_FOLIO_LANGUAGE_1)
            .folioLanguage2(DEFAULT_FOLIO_LANGUAGE_2)
            .folioLanguage3(DEFAULT_FOLIO_LANGUAGE_3)
            .folioLanguage4(DEFAULT_FOLIO_LANGUAGE_4)
            .packageProfit(DEFAULT_PACKAGE_PROFIT)
            .packageLoss(DEFAULT_PACKAGE_LOSS)
            .decimalSeparator(DEFAULT_DECIMAL_SEPARATOR)
            .shortDateFormat(DEFAULT_SHORT_DATE_FORMAT)
            .longDateFormat(DEFAULT_LONG_DATE_FORMAT)
            .passerbySource(DEFAULT_PASSERBY_SOURCE)
            .passerbyMarket(DEFAULT_PASSERBY_MARKET)
            .arCompany(DEFAULT_AR_COMPANY)
            .arAgent(DEFAULT_AR_AGENT)
            .arGroups(DEFAULT_AR_GROUPS)
            .arIndividuals(DEFAULT_AR_INDIVIDUALS)
            .arAcctNoFormat(DEFAULT_AR_ACCT_NO_FORMAT)
            .allowancePeriodAdj(DEFAULT_ALLOWANCE_PERIOD_ADJ)
            .currencyCode(DEFAULT_CURRENCY_CODE)
            .turnawayCode(DEFAULT_TURNAWAY_CODE)
            .summCurrencyCode(DEFAULT_SUMM_CURRENCY_CODE)
            .defaultPropertyAddress(DEFAULT_DEFAULT_PROPERTY_ADDRESS)
            .defaultGuestAddress(DEFAULT_DEFAULT_GUEST_ADDRESS)
            .licenseCode(DEFAULT_LICENSE_CODE)
            .timeFormat(DEFAULT_TIME_FORMAT)
            .chainCode(DEFAULT_CHAIN_CODE)
            .resortType(DEFAULT_RESORT_TYPE)
            .hotelType(DEFAULT_HOTEL_TYPE)
            .ownership(DEFAULT_OWNERSHIP)
            .arBalTrxCode(DEFAULT_AR_BAL_TRX_CODE)
            .arCreditTrxCode(DEFAULT_AR_CREDIT_TRX_CODE)
            .arSettleCode(DEFAULT_AR_SETTLE_CODE)
            .cashShiftDrop(DEFAULT_CASH_SHIFT_DROP)
            .checkExgPaidout(DEFAULT_CHECK_EXG_PAIDOUT)
            .checkShiftDrop(DEFAULT_CHECK_SHIFT_DROP)
            .checkTrxcode(DEFAULT_CHECK_TRXCODE)
            .currencyExgPaidout(DEFAULT_CURRENCY_EXG_PAIDOUT)
            .depositLedTrxCode(DEFAULT_DEPOSIT_LED_TRX_CODE)
            .fiscalPeriodType(DEFAULT_FISCAL_PERIOD_TYPE)
            .defaultCommissionPercentage(DEFAULT_DEFAULT_COMMISSION_PERCENTAGE)
            .defaultPrepaidComm(DEFAULT_DEFAULT_PREPAID_COMM)
            .defaultTrxCommCode(DEFAULT_DEFAULT_TRX_COMM_CODE)
            .configurationMode(DEFAULT_CONFIGURATION_MODE)
            .weekendDays(DEFAULT_WEEKEND_DAYS)
            .defaultGroupsRateCode(DEFAULT_DEFAULT_GROUPS_RATE_CODE)
            .defaultPostingRoom(DEFAULT_DEFAULT_POSTING_ROOM)
            .dfltPkgTranCode(DEFAULT_DFLT_PKG_TRAN_CODE)
            .dfltTranCodeRateCode(DEFAULT_DFLT_TRAN_CODE_RATE_CODE)
            .defaultRateCode(DEFAULT_DEFAULT_RATE_CODE)
            .croCode(DEFAULT_CRO_CODE)
            .flowCode(DEFAULT_FLOW_CODE)
            .extPropertyCode(DEFAULT_EXT_PROPERTY_CODE)
            .opusCurrencyCode(DEFAULT_OPUS_CURRENCY_CODE)
            .destinationId(DEFAULT_DESTINATION_ID)
            .flags(DEFAULT_FLAGS)
            .touristNumber(DEFAULT_TOURIST_NUMBER)
            .cateringCurrencyCode(DEFAULT_CATERING_CURRENCY_CODE)
            .defaultRatecodeRack(DEFAULT_DEFAULT_RATECODE_RACK)
            .defaultRatecodePcr(DEFAULT_DEFAULT_RATECODE_PCR)
            .fnsTier(DEFAULT_FNS_TIER)
            .brandCode(DEFAULT_BRAND_CODE)
            .webaddress(DEFAULT_WEBADDRESS)
            .vatId(DEFAULT_VAT_ID)
            .street(DEFAULT_STREET)
            .hotelFc(DEFAULT_HOTEL_FC)
            .meetingFc(DEFAULT_MEETING_FC)
            .arTypewriter(DEFAULT_AR_TYPEWRITER)
            .fileTransferFormat(DEFAULT_FILE_TRANSFER_FORMAT)
            .confirmRegcardPrinter(DEFAULT_CONFIRM_REGCARD_PRINTER)
            .directions(DEFAULT_DIRECTIONS)
            .propinfoUrl(DEFAULT_PROPINFO_URL)
            .roomAmenity(DEFAULT_ROOM_AMENITY)
            .shopDescription(DEFAULT_SHOP_DESCRIPTION)
            .propPicUrl(DEFAULT_PROP_PIC_URL)
            .propMapUrl(DEFAULT_PROP_MAP_URL)
            .extExpFileLocation(DEFAULT_EXT_EXP_FILE_LOCATION)
            .curtainColor(DEFAULT_CURTAIN_COLOR)
            .countryCode(DEFAULT_COUNTRY_CODE)
            .state(DEFAULT_STATE)
            .dateForAging(DEFAULT_DATE_FOR_AGING)
            .regionCode(DEFAULT_REGION_CODE)
            .city(DEFAULT_CITY)
            .telephone(DEFAULT_TELEPHONE)
            .fax(DEFAULT_FAX)
            .tollfree(DEFAULT_TOLLFREE)
            .defaultPrinter(DEFAULT_DEFAULT_PRINTER)
            .videocheckoutPrinter(DEFAULT_VIDEOCHECKOUT_PRINTER)
            .companyAddressType(DEFAULT_COMPANY_ADDRESS_TYPE)
            .companyPhoneType(DEFAULT_COMPANY_PHONE_TYPE)
            .defaultFaxType(DEFAULT_DEFAULT_FAX_TYPE)
            .defaultMembershipType(DEFAULT_DEFAULT_MEMBERSHIP_TYPE)
            .individualAddressType(DEFAULT_INDIVIDUAL_ADDRESS_TYPE)
            .individualPhoneType(DEFAULT_INDIVIDUAL_PHONE_TYPE)
            .notes(DEFAULT_NOTES)
            .blackoutPeriodNotes(DEFAULT_BLACKOUT_PERIOD_NOTES)
            .sglNum(DEFAULT_SGL_NUM)
            .dblNum(DEFAULT_DBL_NUM)
            .tplNum(DEFAULT_TPL_NUM)
            .suiNum(DEFAULT_SUI_NUM)
            .airportDistance(DEFAULT_AIRPORT_DISTANCE)
            .airportTime(DEFAULT_AIRPORT_TIME)
            .brArea(DEFAULT_BR_AREA)
            .name(DEFAULT_NAME)
            .legalOwner(DEFAULT_LEGAL_OWNER)
            .hotelId(DEFAULT_HOTEL_ID)
            .faxNoFormat(DEFAULT_FAX_NO_FORMAT)
            .telephoneNoFormat(DEFAULT_TELEPHONE_NO_FORMAT)
            .localCurrencyFormat(DEFAULT_LOCAL_CURRENCY_FORMAT)
            .dutyManagerPager(DEFAULT_DUTY_MANAGER_PAGER)
            .defaultRegistrationCard(DEFAULT_DEFAULT_REGISTRATION_CARD)
            .nightAuditCashierId(DEFAULT_NIGHT_AUDIT_CASHIER_ID)
            .hotelCode(DEFAULT_HOTEL_CODE)
            .path(DEFAULT_PATH)
            .timezoneRegion(DEFAULT_TIMEZONE_REGION)
            .cateringCurrencyFormat(DEFAULT_CATERING_CURRENCY_FORMAT)
            .expHotelCode(DEFAULT_EXP_HOTEL_CODE);
        return resort;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Resort createUpdatedEntity(EntityManager em) {
        Resort resort = new Resort()
            .resort(UPDATED_RESORT)
            .beginDate(UPDATED_BEGIN_DATE)
            .checkInTime(UPDATED_CHECK_IN_TIME)
            .checkOutTime(UPDATED_CHECK_OUT_TIME)
            .videoCoStart(UPDATED_VIDEO_CO_START)
            .videoCoStop(UPDATED_VIDEO_CO_STOP)
            .insertDate(UPDATED_INSERT_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .expiryDate(UPDATED_EXPIRY_DATE)
            .endDate(UPDATED_END_DATE)
            .fiscalStartDate(UPDATED_FISCAL_START_DATE)
            .fiscalEndDate(UPDATED_FISCAL_END_DATE)
            .reconcileDate(UPDATED_RECONCILE_DATE)
            .paymentDate(UPDATED_PAYMENT_DATE)
            .keepAvailability(UPDATED_KEEP_AVAILABILITY)
            .budgetMonth(UPDATED_BUDGET_MONTH)
            .saveProfiles(UPDATED_SAVE_PROFILES)
            .longStayControl(UPDATED_LONG_STAY_CONTROL)
            .creditLimit(UPDATED_CREDIT_LIMIT)
            .numberRooms(UPDATED_NUMBER_ROOMS)
            .numberFloors(UPDATED_NUMBER_FLOORS)
            .numberBeds(UPDATED_NUMBER_BEDS)
            .rhythmSheets(UPDATED_RHYTHM_SHEETS)
            .rhythmTowels(UPDATED_RHYTHM_TOWELS)
            .warningAmount(UPDATED_WARNING_AMOUNT)
            .decimalPlaces(UPDATED_DECIMAL_PLACES)
            .font(UPDATED_FONT)
            .copies(UPDATED_COPIES)
            .defaultFolioStyle(UPDATED_DEFAULT_FOLIO_STYLE)
            .individualRoomWarning(UPDATED_INDIVIDUAL_ROOM_WARNING)
            .groupRoomWarning(UPDATED_GROUP_ROOM_WARNING)
            .agingLevel1(UPDATED_AGING_LEVEL_1)
            .agingLevel2(UPDATED_AGING_LEVEL_2)
            .agingLevel3(UPDATED_AGING_LEVEL_3)
            .agingLevel4(UPDATED_AGING_LEVEL_4)
            .agingLevel5(UPDATED_AGING_LEVEL_5)
            .zeroInvPurDays(UPDATED_ZERO_INV_PUR_DAYS)
            .minDaysBet2ReminderLetter(UPDATED_MIN_DAYS_BET_2_REMINDER_LETTER)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .currencyDecimals(UPDATED_CURRENCY_DECIMALS)
            .nameIdLink(UPDATED_NAME_ID_LINK)
            .sglRate1(UPDATED_SGL_RATE_1)
            .sglRate2(UPDATED_SGL_RATE_2)
            .dblRate1(UPDATED_DBL_RATE_1)
            .dblRate2(UPDATED_DBL_RATE_2)
            .tplRate1(UPDATED_TPL_RATE_1)
            .tplRate2(UPDATED_TPL_RATE_2)
            .suiRate1(UPDATED_SUI_RATE_1)
            .suiRate2(UPDATED_SUI_RATE_2)
            .meetSpace(UPDATED_MEET_SPACE)
            .imgHotelId(UPDATED_IMG_HOTEL_ID)
            .imgDirectionId(UPDATED_IMG_DIRECTION_ID)
            .imgMapId(UPDATED_IMG_MAP_ID)
            .scriptId(UPDATED_SCRIPT_ID)
            .comNameXrefId(UPDATED_COM_NAME_XREF_ID)
            .pathId(UPDATED_PATH_ID)
            .xresortNumber(UPDATED_XRESORT_NUMBER)
            .maxCreditDays(UPDATED_MAX_CREDIT_DAYS)
            .currencyDivisor(UPDATED_CURRENCY_DIVISOR)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .qtySingleRooms(UPDATED_QTY_SINGLE_ROOMS)
            .qtyDoubleRooms(UPDATED_QTY_DOUBLE_ROOMS)
            .qtyTwinRooms(UPDATED_QTY_TWIN_ROOMS)
            .qtySuites(UPDATED_QTY_SUITES)
            .qtyGuestRoomFloors(UPDATED_QTY_GUEST_ROOM_FLOORS)
            .qtyGuestElevators(UPDATED_QTY_GUEST_ELEVATORS)
            .qtyNonSmokingRooms(UPDATED_QTY_NON_SMOKING_ROOMS)
            .qtyConnectingRooms(UPDATED_QTY_CONNECTING_ROOMS)
            .qtyHandicappedRooms(UPDATED_QTY_HANDICAPPED_ROOMS)
            .qtyFamilyRooms(UPDATED_QTY_FAMILY_ROOMS)
            .maxAdultsFamilyRoom(UPDATED_MAX_ADULTS_FAMILY_ROOM)
            .maxChildrenFamilyRoom(UPDATED_MAX_CHILDREN_FAMILY_ROOM)
            .restaurant(UPDATED_RESTAURANT)
            .meetRooms(UPDATED_MEET_ROOMS)
            .totRooms(UPDATED_TOT_ROOMS)
            .brSeats(UPDATED_BR_SEATS)
            .meetSeats(UPDATED_MEET_SEATS)
            .maxNoNights(UPDATED_MAX_NO_NIGHTS)
            .awardsTimeout(UPDATED_AWARDS_TIMEOUT)
            .guestLookupTimeout(UPDATED_GUEST_LOOKUP_TIMEOUT)
            .wakeUpDelay(UPDATED_WAKE_UP_DELAY)
            .maxOccupancy(UPDATED_MAX_OCCUPANCY)
            .inactiveDaysForGuestProfil(UPDATED_INACTIVE_DAYS_FOR_GUEST_PROFIL)
            .perReservationRoomLimit(UPDATED_PER_RESERVATION_ROOM_LIMIT)
            .licRoomInfo(UPDATED_LIC_ROOM_INFO)
            .thousandSeparator(UPDATED_THOUSAND_SEPARATOR)
            .dateSeparator(UPDATED_DATE_SEPARATOR)
            .arAcctNoMandYn(UPDATED_AR_ACCT_NO_MAND_YN)
            .exchangePostingType(UPDATED_EXCHANGE_POSTING_TYPE)
            .inventoryYn(UPDATED_INVENTORY_YN)
            .allowLoginYn(UPDATED_ALLOW_LOGIN_YN)
            .accessCode(UPDATED_ACCESS_CODE)
            .disableLoginYn(UPDATED_DISABLE_LOGIN_YN)
            .intTaxIncludedYn(UPDATED_INT_TAX_INCLUDED_YN)
            .downloadRestYn(UPDATED_DOWNLOAD_REST_YN)
            .translateMulticharYn(UPDATED_TRANSLATE_MULTICHAR_YN)
            .externalScYn(UPDATED_EXTERNAL_SC_YN)
            .sendLeadAsBookingYn(UPDATED_SEND_LEAD_AS_BOOKING_YN)
            .mbsSupportedYn(UPDATED_MBS_SUPPORTED_YN)
            .quotedCurrency(UPDATED_QUOTED_CURRENCY)
            .comMethod(UPDATED_COM_METHOD)
            .email(UPDATED_EMAIL)
            .genmgr(UPDATED_GENMGR)
            .dirsales(UPDATED_DIRSALES)
            .leadsend(UPDATED_LEADSEND)
            .airport(UPDATED_AIRPORT)
            .comAddress(UPDATED_COM_ADDRESS)
            .season1(UPDATED_SEASON_1)
            .season2(UPDATED_SEASON_2)
            .season3(UPDATED_SEASON_3)
            .season4(UPDATED_SEASON_4)
            .season5(UPDATED_SEASON_5)
            .floorNumExecutiveFloor(UPDATED_FLOOR_NUM_EXECUTIVE_FLOOR)
            .crsResort(UPDATED_CRS_RESORT)
            .postCode(UPDATED_POST_CODE)
            .defaultReservationType(UPDATED_DEFAULT_RESERVATION_TYPE)
            .block(UPDATED_BLOCK)
            .currencySymbol(UPDATED_CURRENCY_SYMBOL)
            .sourceCommission(UPDATED_SOURCE_COMMISSION)
            .taCommission(UPDATED_TA_COMMISSION)
            .baseLanguage(UPDATED_BASE_LANGUAGE)
            .folioLanguage1(UPDATED_FOLIO_LANGUAGE_1)
            .folioLanguage2(UPDATED_FOLIO_LANGUAGE_2)
            .folioLanguage3(UPDATED_FOLIO_LANGUAGE_3)
            .folioLanguage4(UPDATED_FOLIO_LANGUAGE_4)
            .packageProfit(UPDATED_PACKAGE_PROFIT)
            .packageLoss(UPDATED_PACKAGE_LOSS)
            .decimalSeparator(UPDATED_DECIMAL_SEPARATOR)
            .shortDateFormat(UPDATED_SHORT_DATE_FORMAT)
            .longDateFormat(UPDATED_LONG_DATE_FORMAT)
            .passerbySource(UPDATED_PASSERBY_SOURCE)
            .passerbyMarket(UPDATED_PASSERBY_MARKET)
            .arCompany(UPDATED_AR_COMPANY)
            .arAgent(UPDATED_AR_AGENT)
            .arGroups(UPDATED_AR_GROUPS)
            .arIndividuals(UPDATED_AR_INDIVIDUALS)
            .arAcctNoFormat(UPDATED_AR_ACCT_NO_FORMAT)
            .allowancePeriodAdj(UPDATED_ALLOWANCE_PERIOD_ADJ)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .turnawayCode(UPDATED_TURNAWAY_CODE)
            .summCurrencyCode(UPDATED_SUMM_CURRENCY_CODE)
            .defaultPropertyAddress(UPDATED_DEFAULT_PROPERTY_ADDRESS)
            .defaultGuestAddress(UPDATED_DEFAULT_GUEST_ADDRESS)
            .licenseCode(UPDATED_LICENSE_CODE)
            .timeFormat(UPDATED_TIME_FORMAT)
            .chainCode(UPDATED_CHAIN_CODE)
            .resortType(UPDATED_RESORT_TYPE)
            .hotelType(UPDATED_HOTEL_TYPE)
            .ownership(UPDATED_OWNERSHIP)
            .arBalTrxCode(UPDATED_AR_BAL_TRX_CODE)
            .arCreditTrxCode(UPDATED_AR_CREDIT_TRX_CODE)
            .arSettleCode(UPDATED_AR_SETTLE_CODE)
            .cashShiftDrop(UPDATED_CASH_SHIFT_DROP)
            .checkExgPaidout(UPDATED_CHECK_EXG_PAIDOUT)
            .checkShiftDrop(UPDATED_CHECK_SHIFT_DROP)
            .checkTrxcode(UPDATED_CHECK_TRXCODE)
            .currencyExgPaidout(UPDATED_CURRENCY_EXG_PAIDOUT)
            .depositLedTrxCode(UPDATED_DEPOSIT_LED_TRX_CODE)
            .fiscalPeriodType(UPDATED_FISCAL_PERIOD_TYPE)
            .defaultCommissionPercentage(UPDATED_DEFAULT_COMMISSION_PERCENTAGE)
            .defaultPrepaidComm(UPDATED_DEFAULT_PREPAID_COMM)
            .defaultTrxCommCode(UPDATED_DEFAULT_TRX_COMM_CODE)
            .configurationMode(UPDATED_CONFIGURATION_MODE)
            .weekendDays(UPDATED_WEEKEND_DAYS)
            .defaultGroupsRateCode(UPDATED_DEFAULT_GROUPS_RATE_CODE)
            .defaultPostingRoom(UPDATED_DEFAULT_POSTING_ROOM)
            .dfltPkgTranCode(UPDATED_DFLT_PKG_TRAN_CODE)
            .dfltTranCodeRateCode(UPDATED_DFLT_TRAN_CODE_RATE_CODE)
            .defaultRateCode(UPDATED_DEFAULT_RATE_CODE)
            .croCode(UPDATED_CRO_CODE)
            .flowCode(UPDATED_FLOW_CODE)
            .extPropertyCode(UPDATED_EXT_PROPERTY_CODE)
            .opusCurrencyCode(UPDATED_OPUS_CURRENCY_CODE)
            .destinationId(UPDATED_DESTINATION_ID)
            .flags(UPDATED_FLAGS)
            .touristNumber(UPDATED_TOURIST_NUMBER)
            .cateringCurrencyCode(UPDATED_CATERING_CURRENCY_CODE)
            .defaultRatecodeRack(UPDATED_DEFAULT_RATECODE_RACK)
            .defaultRatecodePcr(UPDATED_DEFAULT_RATECODE_PCR)
            .fnsTier(UPDATED_FNS_TIER)
            .brandCode(UPDATED_BRAND_CODE)
            .webaddress(UPDATED_WEBADDRESS)
            .vatId(UPDATED_VAT_ID)
            .street(UPDATED_STREET)
            .hotelFc(UPDATED_HOTEL_FC)
            .meetingFc(UPDATED_MEETING_FC)
            .arTypewriter(UPDATED_AR_TYPEWRITER)
            .fileTransferFormat(UPDATED_FILE_TRANSFER_FORMAT)
            .confirmRegcardPrinter(UPDATED_CONFIRM_REGCARD_PRINTER)
            .directions(UPDATED_DIRECTIONS)
            .propinfoUrl(UPDATED_PROPINFO_URL)
            .roomAmenity(UPDATED_ROOM_AMENITY)
            .shopDescription(UPDATED_SHOP_DESCRIPTION)
            .propPicUrl(UPDATED_PROP_PIC_URL)
            .propMapUrl(UPDATED_PROP_MAP_URL)
            .extExpFileLocation(UPDATED_EXT_EXP_FILE_LOCATION)
            .curtainColor(UPDATED_CURTAIN_COLOR)
            .countryCode(UPDATED_COUNTRY_CODE)
            .state(UPDATED_STATE)
            .dateForAging(UPDATED_DATE_FOR_AGING)
            .regionCode(UPDATED_REGION_CODE)
            .city(UPDATED_CITY)
            .telephone(UPDATED_TELEPHONE)
            .fax(UPDATED_FAX)
            .tollfree(UPDATED_TOLLFREE)
            .defaultPrinter(UPDATED_DEFAULT_PRINTER)
            .videocheckoutPrinter(UPDATED_VIDEOCHECKOUT_PRINTER)
            .companyAddressType(UPDATED_COMPANY_ADDRESS_TYPE)
            .companyPhoneType(UPDATED_COMPANY_PHONE_TYPE)
            .defaultFaxType(UPDATED_DEFAULT_FAX_TYPE)
            .defaultMembershipType(UPDATED_DEFAULT_MEMBERSHIP_TYPE)
            .individualAddressType(UPDATED_INDIVIDUAL_ADDRESS_TYPE)
            .individualPhoneType(UPDATED_INDIVIDUAL_PHONE_TYPE)
            .notes(UPDATED_NOTES)
            .blackoutPeriodNotes(UPDATED_BLACKOUT_PERIOD_NOTES)
            .sglNum(UPDATED_SGL_NUM)
            .dblNum(UPDATED_DBL_NUM)
            .tplNum(UPDATED_TPL_NUM)
            .suiNum(UPDATED_SUI_NUM)
            .airportDistance(UPDATED_AIRPORT_DISTANCE)
            .airportTime(UPDATED_AIRPORT_TIME)
            .brArea(UPDATED_BR_AREA)
            .name(UPDATED_NAME)
            .legalOwner(UPDATED_LEGAL_OWNER)
            .hotelId(UPDATED_HOTEL_ID)
            .faxNoFormat(UPDATED_FAX_NO_FORMAT)
            .telephoneNoFormat(UPDATED_TELEPHONE_NO_FORMAT)
            .localCurrencyFormat(UPDATED_LOCAL_CURRENCY_FORMAT)
            .dutyManagerPager(UPDATED_DUTY_MANAGER_PAGER)
            .defaultRegistrationCard(UPDATED_DEFAULT_REGISTRATION_CARD)
            .nightAuditCashierId(UPDATED_NIGHT_AUDIT_CASHIER_ID)
            .hotelCode(UPDATED_HOTEL_CODE)
            .path(UPDATED_PATH)
            .timezoneRegion(UPDATED_TIMEZONE_REGION)
            .cateringCurrencyFormat(UPDATED_CATERING_CURRENCY_FORMAT)
            .expHotelCode(UPDATED_EXP_HOTEL_CODE);
        return resort;
    }

    @BeforeEach
    public void initTest() {
        resort = createEntity(em);
    }

    @Test
    @Transactional
    void createResort() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Resort
        var returnedResort = om.readValue(
            restResortMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(resort)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            Resort.class
        );

        // Validate the Resort in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertResortUpdatableFieldsEquals(returnedResort, getPersistedResort(returnedResort));
    }

    @Test
    @Transactional
    void createResortWithExistingId() throws Exception {
        // Create the Resort with an existing ID
        resort.setId("existing_id");

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restResortMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(resort)))
            .andExpect(status().isBadRequest());

        // Validate the Resort in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllResorts() throws Exception {
        // Initialize the database
        resortRepository.saveAndFlush(resort);

        // Get all the resortList
        restResortMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(resort.getId())))
            .andExpect(jsonPath("$.[*].resort").value(hasItem(DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].beginDate").value(hasItem(sameInstant(DEFAULT_BEGIN_DATE))))
            .andExpect(jsonPath("$.[*].checkInTime").value(hasItem(sameInstant(DEFAULT_CHECK_IN_TIME))))
            .andExpect(jsonPath("$.[*].checkOutTime").value(hasItem(sameInstant(DEFAULT_CHECK_OUT_TIME))))
            .andExpect(jsonPath("$.[*].videoCoStart").value(hasItem(sameInstant(DEFAULT_VIDEO_CO_START))))
            .andExpect(jsonPath("$.[*].videoCoStop").value(hasItem(sameInstant(DEFAULT_VIDEO_CO_STOP))))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(sameInstant(DEFAULT_INSERT_DATE))))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(sameInstant(DEFAULT_UPDATE_DATE))))
            .andExpect(jsonPath("$.[*].expiryDate").value(hasItem(sameInstant(DEFAULT_EXPIRY_DATE))))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(sameInstant(DEFAULT_END_DATE))))
            .andExpect(jsonPath("$.[*].fiscalStartDate").value(hasItem(sameInstant(DEFAULT_FISCAL_START_DATE))))
            .andExpect(jsonPath("$.[*].fiscalEndDate").value(hasItem(sameInstant(DEFAULT_FISCAL_END_DATE))))
            .andExpect(jsonPath("$.[*].reconcileDate").value(hasItem(sameInstant(DEFAULT_RECONCILE_DATE))))
            .andExpect(jsonPath("$.[*].paymentDate").value(hasItem(sameInstant(DEFAULT_PAYMENT_DATE))))
            .andExpect(jsonPath("$.[*].keepAvailability").value(hasItem(DEFAULT_KEEP_AVAILABILITY)))
            .andExpect(jsonPath("$.[*].budgetMonth").value(hasItem(DEFAULT_BUDGET_MONTH)))
            .andExpect(jsonPath("$.[*].saveProfiles").value(hasItem(DEFAULT_SAVE_PROFILES)))
            .andExpect(jsonPath("$.[*].longStayControl").value(hasItem(DEFAULT_LONG_STAY_CONTROL)))
            .andExpect(jsonPath("$.[*].creditLimit").value(hasItem(DEFAULT_CREDIT_LIMIT)))
            .andExpect(jsonPath("$.[*].numberRooms").value(hasItem(DEFAULT_NUMBER_ROOMS)))
            .andExpect(jsonPath("$.[*].numberFloors").value(hasItem(DEFAULT_NUMBER_FLOORS)))
            .andExpect(jsonPath("$.[*].numberBeds").value(hasItem(DEFAULT_NUMBER_BEDS)))
            .andExpect(jsonPath("$.[*].rhythmSheets").value(hasItem(DEFAULT_RHYTHM_SHEETS)))
            .andExpect(jsonPath("$.[*].rhythmTowels").value(hasItem(DEFAULT_RHYTHM_TOWELS)))
            .andExpect(jsonPath("$.[*].warningAmount").value(hasItem(DEFAULT_WARNING_AMOUNT)))
            .andExpect(jsonPath("$.[*].decimalPlaces").value(hasItem(DEFAULT_DECIMAL_PLACES)))
            .andExpect(jsonPath("$.[*].font").value(hasItem(DEFAULT_FONT)))
            .andExpect(jsonPath("$.[*].copies").value(hasItem(DEFAULT_COPIES)))
            .andExpect(jsonPath("$.[*].defaultFolioStyle").value(hasItem(DEFAULT_DEFAULT_FOLIO_STYLE)))
            .andExpect(jsonPath("$.[*].individualRoomWarning").value(hasItem(DEFAULT_INDIVIDUAL_ROOM_WARNING)))
            .andExpect(jsonPath("$.[*].groupRoomWarning").value(hasItem(DEFAULT_GROUP_ROOM_WARNING)))
            .andExpect(jsonPath("$.[*].agingLevel1").value(hasItem(DEFAULT_AGING_LEVEL_1)))
            .andExpect(jsonPath("$.[*].agingLevel2").value(hasItem(DEFAULT_AGING_LEVEL_2)))
            .andExpect(jsonPath("$.[*].agingLevel3").value(hasItem(DEFAULT_AGING_LEVEL_3)))
            .andExpect(jsonPath("$.[*].agingLevel4").value(hasItem(DEFAULT_AGING_LEVEL_4)))
            .andExpect(jsonPath("$.[*].agingLevel5").value(hasItem(DEFAULT_AGING_LEVEL_5)))
            .andExpect(jsonPath("$.[*].zeroInvPurDays").value(hasItem(DEFAULT_ZERO_INV_PUR_DAYS)))
            .andExpect(jsonPath("$.[*].minDaysBet2ReminderLetter").value(hasItem(DEFAULT_MIN_DAYS_BET_2_REMINDER_LETTER)))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].currencyDecimals").value(hasItem(DEFAULT_CURRENCY_DECIMALS)))
            .andExpect(jsonPath("$.[*].nameIdLink").value(hasItem(DEFAULT_NAME_ID_LINK)))
            .andExpect(jsonPath("$.[*].sglRate1").value(hasItem(DEFAULT_SGL_RATE_1)))
            .andExpect(jsonPath("$.[*].sglRate2").value(hasItem(DEFAULT_SGL_RATE_2)))
            .andExpect(jsonPath("$.[*].dblRate1").value(hasItem(DEFAULT_DBL_RATE_1)))
            .andExpect(jsonPath("$.[*].dblRate2").value(hasItem(DEFAULT_DBL_RATE_2)))
            .andExpect(jsonPath("$.[*].tplRate1").value(hasItem(DEFAULT_TPL_RATE_1)))
            .andExpect(jsonPath("$.[*].tplRate2").value(hasItem(DEFAULT_TPL_RATE_2)))
            .andExpect(jsonPath("$.[*].suiRate1").value(hasItem(DEFAULT_SUI_RATE_1)))
            .andExpect(jsonPath("$.[*].suiRate2").value(hasItem(DEFAULT_SUI_RATE_2)))
            .andExpect(jsonPath("$.[*].meetSpace").value(hasItem(DEFAULT_MEET_SPACE)))
            .andExpect(jsonPath("$.[*].imgHotelId").value(hasItem(DEFAULT_IMG_HOTEL_ID)))
            .andExpect(jsonPath("$.[*].imgDirectionId").value(hasItem(DEFAULT_IMG_DIRECTION_ID)))
            .andExpect(jsonPath("$.[*].imgMapId").value(hasItem(DEFAULT_IMG_MAP_ID)))
            .andExpect(jsonPath("$.[*].scriptId").value(hasItem(DEFAULT_SCRIPT_ID)))
            .andExpect(jsonPath("$.[*].comNameXrefId").value(hasItem(DEFAULT_COM_NAME_XREF_ID)))
            .andExpect(jsonPath("$.[*].pathId").value(hasItem(DEFAULT_PATH_ID)))
            .andExpect(jsonPath("$.[*].xresortNumber").value(hasItem(DEFAULT_XRESORT_NUMBER)))
            .andExpect(jsonPath("$.[*].maxCreditDays").value(hasItem(DEFAULT_MAX_CREDIT_DAYS)))
            .andExpect(jsonPath("$.[*].currencyDivisor").value(hasItem(DEFAULT_CURRENCY_DIVISOR)))
            .andExpect(jsonPath("$.[*].latitude").value(hasItem(DEFAULT_LATITUDE)))
            .andExpect(jsonPath("$.[*].longitude").value(hasItem(DEFAULT_LONGITUDE)))
            .andExpect(jsonPath("$.[*].qtySingleRooms").value(hasItem(DEFAULT_QTY_SINGLE_ROOMS)))
            .andExpect(jsonPath("$.[*].qtyDoubleRooms").value(hasItem(DEFAULT_QTY_DOUBLE_ROOMS)))
            .andExpect(jsonPath("$.[*].qtyTwinRooms").value(hasItem(DEFAULT_QTY_TWIN_ROOMS)))
            .andExpect(jsonPath("$.[*].qtySuites").value(hasItem(DEFAULT_QTY_SUITES)))
            .andExpect(jsonPath("$.[*].qtyGuestRoomFloors").value(hasItem(DEFAULT_QTY_GUEST_ROOM_FLOORS)))
            .andExpect(jsonPath("$.[*].qtyGuestElevators").value(hasItem(DEFAULT_QTY_GUEST_ELEVATORS)))
            .andExpect(jsonPath("$.[*].qtyNonSmokingRooms").value(hasItem(DEFAULT_QTY_NON_SMOKING_ROOMS)))
            .andExpect(jsonPath("$.[*].qtyConnectingRooms").value(hasItem(DEFAULT_QTY_CONNECTING_ROOMS)))
            .andExpect(jsonPath("$.[*].qtyHandicappedRooms").value(hasItem(DEFAULT_QTY_HANDICAPPED_ROOMS)))
            .andExpect(jsonPath("$.[*].qtyFamilyRooms").value(hasItem(DEFAULT_QTY_FAMILY_ROOMS)))
            .andExpect(jsonPath("$.[*].maxAdultsFamilyRoom").value(hasItem(DEFAULT_MAX_ADULTS_FAMILY_ROOM)))
            .andExpect(jsonPath("$.[*].maxChildrenFamilyRoom").value(hasItem(DEFAULT_MAX_CHILDREN_FAMILY_ROOM)))
            .andExpect(jsonPath("$.[*].restaurant").value(hasItem(DEFAULT_RESTAURANT)))
            .andExpect(jsonPath("$.[*].meetRooms").value(hasItem(DEFAULT_MEET_ROOMS)))
            .andExpect(jsonPath("$.[*].totRooms").value(hasItem(DEFAULT_TOT_ROOMS)))
            .andExpect(jsonPath("$.[*].brSeats").value(hasItem(DEFAULT_BR_SEATS)))
            .andExpect(jsonPath("$.[*].meetSeats").value(hasItem(DEFAULT_MEET_SEATS)))
            .andExpect(jsonPath("$.[*].maxNoNights").value(hasItem(DEFAULT_MAX_NO_NIGHTS)))
            .andExpect(jsonPath("$.[*].awardsTimeout").value(hasItem(DEFAULT_AWARDS_TIMEOUT)))
            .andExpect(jsonPath("$.[*].guestLookupTimeout").value(hasItem(DEFAULT_GUEST_LOOKUP_TIMEOUT)))
            .andExpect(jsonPath("$.[*].wakeUpDelay").value(hasItem(DEFAULT_WAKE_UP_DELAY)))
            .andExpect(jsonPath("$.[*].maxOccupancy").value(hasItem(DEFAULT_MAX_OCCUPANCY)))
            .andExpect(jsonPath("$.[*].inactiveDaysForGuestProfil").value(hasItem(DEFAULT_INACTIVE_DAYS_FOR_GUEST_PROFIL)))
            .andExpect(jsonPath("$.[*].perReservationRoomLimit").value(hasItem(DEFAULT_PER_RESERVATION_ROOM_LIMIT)))
            .andExpect(jsonPath("$.[*].licRoomInfo").value(hasItem(DEFAULT_LIC_ROOM_INFO)))
            .andExpect(jsonPath("$.[*].thousandSeparator").value(hasItem(DEFAULT_THOUSAND_SEPARATOR)))
            .andExpect(jsonPath("$.[*].dateSeparator").value(hasItem(DEFAULT_DATE_SEPARATOR)))
            .andExpect(jsonPath("$.[*].arAcctNoMandYn").value(hasItem(DEFAULT_AR_ACCT_NO_MAND_YN)))
            .andExpect(jsonPath("$.[*].exchangePostingType").value(hasItem(DEFAULT_EXCHANGE_POSTING_TYPE)))
            .andExpect(jsonPath("$.[*].inventoryYn").value(hasItem(DEFAULT_INVENTORY_YN)))
            .andExpect(jsonPath("$.[*].allowLoginYn").value(hasItem(DEFAULT_ALLOW_LOGIN_YN)))
            .andExpect(jsonPath("$.[*].accessCode").value(hasItem(DEFAULT_ACCESS_CODE)))
            .andExpect(jsonPath("$.[*].disableLoginYn").value(hasItem(DEFAULT_DISABLE_LOGIN_YN)))
            .andExpect(jsonPath("$.[*].intTaxIncludedYn").value(hasItem(DEFAULT_INT_TAX_INCLUDED_YN)))
            .andExpect(jsonPath("$.[*].downloadRestYn").value(hasItem(DEFAULT_DOWNLOAD_REST_YN)))
            .andExpect(jsonPath("$.[*].translateMulticharYn").value(hasItem(DEFAULT_TRANSLATE_MULTICHAR_YN)))
            .andExpect(jsonPath("$.[*].externalScYn").value(hasItem(DEFAULT_EXTERNAL_SC_YN)))
            .andExpect(jsonPath("$.[*].sendLeadAsBookingYn").value(hasItem(DEFAULT_SEND_LEAD_AS_BOOKING_YN)))
            .andExpect(jsonPath("$.[*].mbsSupportedYn").value(hasItem(DEFAULT_MBS_SUPPORTED_YN)))
            .andExpect(jsonPath("$.[*].quotedCurrency").value(hasItem(DEFAULT_QUOTED_CURRENCY)))
            .andExpect(jsonPath("$.[*].comMethod").value(hasItem(DEFAULT_COM_METHOD)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].genmgr").value(hasItem(DEFAULT_GENMGR)))
            .andExpect(jsonPath("$.[*].dirsales").value(hasItem(DEFAULT_DIRSALES)))
            .andExpect(jsonPath("$.[*].leadsend").value(hasItem(DEFAULT_LEADSEND)))
            .andExpect(jsonPath("$.[*].airport").value(hasItem(DEFAULT_AIRPORT)))
            .andExpect(jsonPath("$.[*].comAddress").value(hasItem(DEFAULT_COM_ADDRESS)))
            .andExpect(jsonPath("$.[*].season1").value(hasItem(DEFAULT_SEASON_1)))
            .andExpect(jsonPath("$.[*].season2").value(hasItem(DEFAULT_SEASON_2)))
            .andExpect(jsonPath("$.[*].season3").value(hasItem(DEFAULT_SEASON_3)))
            .andExpect(jsonPath("$.[*].season4").value(hasItem(DEFAULT_SEASON_4)))
            .andExpect(jsonPath("$.[*].season5").value(hasItem(DEFAULT_SEASON_5)))
            .andExpect(jsonPath("$.[*].floorNumExecutiveFloor").value(hasItem(DEFAULT_FLOOR_NUM_EXECUTIVE_FLOOR)))
            .andExpect(jsonPath("$.[*].crsResort").value(hasItem(DEFAULT_CRS_RESORT)))
            .andExpect(jsonPath("$.[*].postCode").value(hasItem(DEFAULT_POST_CODE)))
            .andExpect(jsonPath("$.[*].defaultReservationType").value(hasItem(DEFAULT_DEFAULT_RESERVATION_TYPE)))
            .andExpect(jsonPath("$.[*].block").value(hasItem(DEFAULT_BLOCK)))
            .andExpect(jsonPath("$.[*].currencySymbol").value(hasItem(DEFAULT_CURRENCY_SYMBOL)))
            .andExpect(jsonPath("$.[*].sourceCommission").value(hasItem(DEFAULT_SOURCE_COMMISSION)))
            .andExpect(jsonPath("$.[*].taCommission").value(hasItem(DEFAULT_TA_COMMISSION)))
            .andExpect(jsonPath("$.[*].baseLanguage").value(hasItem(DEFAULT_BASE_LANGUAGE)))
            .andExpect(jsonPath("$.[*].folioLanguage1").value(hasItem(DEFAULT_FOLIO_LANGUAGE_1)))
            .andExpect(jsonPath("$.[*].folioLanguage2").value(hasItem(DEFAULT_FOLIO_LANGUAGE_2)))
            .andExpect(jsonPath("$.[*].folioLanguage3").value(hasItem(DEFAULT_FOLIO_LANGUAGE_3)))
            .andExpect(jsonPath("$.[*].folioLanguage4").value(hasItem(DEFAULT_FOLIO_LANGUAGE_4)))
            .andExpect(jsonPath("$.[*].packageProfit").value(hasItem(DEFAULT_PACKAGE_PROFIT)))
            .andExpect(jsonPath("$.[*].packageLoss").value(hasItem(DEFAULT_PACKAGE_LOSS)))
            .andExpect(jsonPath("$.[*].decimalSeparator").value(hasItem(DEFAULT_DECIMAL_SEPARATOR)))
            .andExpect(jsonPath("$.[*].shortDateFormat").value(hasItem(DEFAULT_SHORT_DATE_FORMAT)))
            .andExpect(jsonPath("$.[*].longDateFormat").value(hasItem(DEFAULT_LONG_DATE_FORMAT)))
            .andExpect(jsonPath("$.[*].passerbySource").value(hasItem(DEFAULT_PASSERBY_SOURCE)))
            .andExpect(jsonPath("$.[*].passerbyMarket").value(hasItem(DEFAULT_PASSERBY_MARKET)))
            .andExpect(jsonPath("$.[*].arCompany").value(hasItem(DEFAULT_AR_COMPANY)))
            .andExpect(jsonPath("$.[*].arAgent").value(hasItem(DEFAULT_AR_AGENT)))
            .andExpect(jsonPath("$.[*].arGroups").value(hasItem(DEFAULT_AR_GROUPS)))
            .andExpect(jsonPath("$.[*].arIndividuals").value(hasItem(DEFAULT_AR_INDIVIDUALS)))
            .andExpect(jsonPath("$.[*].arAcctNoFormat").value(hasItem(DEFAULT_AR_ACCT_NO_FORMAT)))
            .andExpect(jsonPath("$.[*].allowancePeriodAdj").value(hasItem(DEFAULT_ALLOWANCE_PERIOD_ADJ)))
            .andExpect(jsonPath("$.[*].currencyCode").value(hasItem(DEFAULT_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].turnawayCode").value(hasItem(DEFAULT_TURNAWAY_CODE)))
            .andExpect(jsonPath("$.[*].summCurrencyCode").value(hasItem(DEFAULT_SUMM_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].defaultPropertyAddress").value(hasItem(DEFAULT_DEFAULT_PROPERTY_ADDRESS)))
            .andExpect(jsonPath("$.[*].defaultGuestAddress").value(hasItem(DEFAULT_DEFAULT_GUEST_ADDRESS)))
            .andExpect(jsonPath("$.[*].licenseCode").value(hasItem(DEFAULT_LICENSE_CODE)))
            .andExpect(jsonPath("$.[*].timeFormat").value(hasItem(DEFAULT_TIME_FORMAT)))
            .andExpect(jsonPath("$.[*].chainCode").value(hasItem(DEFAULT_CHAIN_CODE)))
            .andExpect(jsonPath("$.[*].resortType").value(hasItem(DEFAULT_RESORT_TYPE)))
            .andExpect(jsonPath("$.[*].hotelType").value(hasItem(DEFAULT_HOTEL_TYPE)))
            .andExpect(jsonPath("$.[*].ownership").value(hasItem(DEFAULT_OWNERSHIP)))
            .andExpect(jsonPath("$.[*].arBalTrxCode").value(hasItem(DEFAULT_AR_BAL_TRX_CODE)))
            .andExpect(jsonPath("$.[*].arCreditTrxCode").value(hasItem(DEFAULT_AR_CREDIT_TRX_CODE)))
            .andExpect(jsonPath("$.[*].arSettleCode").value(hasItem(DEFAULT_AR_SETTLE_CODE)))
            .andExpect(jsonPath("$.[*].cashShiftDrop").value(hasItem(DEFAULT_CASH_SHIFT_DROP)))
            .andExpect(jsonPath("$.[*].checkExgPaidout").value(hasItem(DEFAULT_CHECK_EXG_PAIDOUT)))
            .andExpect(jsonPath("$.[*].checkShiftDrop").value(hasItem(DEFAULT_CHECK_SHIFT_DROP)))
            .andExpect(jsonPath("$.[*].checkTrxcode").value(hasItem(DEFAULT_CHECK_TRXCODE)))
            .andExpect(jsonPath("$.[*].currencyExgPaidout").value(hasItem(DEFAULT_CURRENCY_EXG_PAIDOUT)))
            .andExpect(jsonPath("$.[*].depositLedTrxCode").value(hasItem(DEFAULT_DEPOSIT_LED_TRX_CODE)))
            .andExpect(jsonPath("$.[*].fiscalPeriodType").value(hasItem(DEFAULT_FISCAL_PERIOD_TYPE)))
            .andExpect(jsonPath("$.[*].defaultCommissionPercentage").value(hasItem(DEFAULT_DEFAULT_COMMISSION_PERCENTAGE)))
            .andExpect(jsonPath("$.[*].defaultPrepaidComm").value(hasItem(DEFAULT_DEFAULT_PREPAID_COMM)))
            .andExpect(jsonPath("$.[*].defaultTrxCommCode").value(hasItem(DEFAULT_DEFAULT_TRX_COMM_CODE)))
            .andExpect(jsonPath("$.[*].configurationMode").value(hasItem(DEFAULT_CONFIGURATION_MODE)))
            .andExpect(jsonPath("$.[*].weekendDays").value(hasItem(DEFAULT_WEEKEND_DAYS)))
            .andExpect(jsonPath("$.[*].defaultGroupsRateCode").value(hasItem(DEFAULT_DEFAULT_GROUPS_RATE_CODE)))
            .andExpect(jsonPath("$.[*].defaultPostingRoom").value(hasItem(DEFAULT_DEFAULT_POSTING_ROOM)))
            .andExpect(jsonPath("$.[*].dfltPkgTranCode").value(hasItem(DEFAULT_DFLT_PKG_TRAN_CODE)))
            .andExpect(jsonPath("$.[*].dfltTranCodeRateCode").value(hasItem(DEFAULT_DFLT_TRAN_CODE_RATE_CODE)))
            .andExpect(jsonPath("$.[*].defaultRateCode").value(hasItem(DEFAULT_DEFAULT_RATE_CODE)))
            .andExpect(jsonPath("$.[*].croCode").value(hasItem(DEFAULT_CRO_CODE)))
            .andExpect(jsonPath("$.[*].flowCode").value(hasItem(DEFAULT_FLOW_CODE)))
            .andExpect(jsonPath("$.[*].extPropertyCode").value(hasItem(DEFAULT_EXT_PROPERTY_CODE)))
            .andExpect(jsonPath("$.[*].opusCurrencyCode").value(hasItem(DEFAULT_OPUS_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].destinationId").value(hasItem(DEFAULT_DESTINATION_ID)))
            .andExpect(jsonPath("$.[*].flags").value(hasItem(DEFAULT_FLAGS)))
            .andExpect(jsonPath("$.[*].touristNumber").value(hasItem(DEFAULT_TOURIST_NUMBER)))
            .andExpect(jsonPath("$.[*].cateringCurrencyCode").value(hasItem(DEFAULT_CATERING_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].defaultRatecodeRack").value(hasItem(DEFAULT_DEFAULT_RATECODE_RACK)))
            .andExpect(jsonPath("$.[*].defaultRatecodePcr").value(hasItem(DEFAULT_DEFAULT_RATECODE_PCR)))
            .andExpect(jsonPath("$.[*].fnsTier").value(hasItem(DEFAULT_FNS_TIER)))
            .andExpect(jsonPath("$.[*].brandCode").value(hasItem(DEFAULT_BRAND_CODE)))
            .andExpect(jsonPath("$.[*].webaddress").value(hasItem(DEFAULT_WEBADDRESS)))
            .andExpect(jsonPath("$.[*].vatId").value(hasItem(DEFAULT_VAT_ID)))
            .andExpect(jsonPath("$.[*].street").value(hasItem(DEFAULT_STREET)))
            .andExpect(jsonPath("$.[*].hotelFc").value(hasItem(DEFAULT_HOTEL_FC)))
            .andExpect(jsonPath("$.[*].meetingFc").value(hasItem(DEFAULT_MEETING_FC)))
            .andExpect(jsonPath("$.[*].arTypewriter").value(hasItem(DEFAULT_AR_TYPEWRITER)))
            .andExpect(jsonPath("$.[*].fileTransferFormat").value(hasItem(DEFAULT_FILE_TRANSFER_FORMAT)))
            .andExpect(jsonPath("$.[*].confirmRegcardPrinter").value(hasItem(DEFAULT_CONFIRM_REGCARD_PRINTER)))
            .andExpect(jsonPath("$.[*].directions").value(hasItem(DEFAULT_DIRECTIONS)))
            .andExpect(jsonPath("$.[*].propinfoUrl").value(hasItem(DEFAULT_PROPINFO_URL)))
            .andExpect(jsonPath("$.[*].roomAmenity").value(hasItem(DEFAULT_ROOM_AMENITY)))
            .andExpect(jsonPath("$.[*].shopDescription").value(hasItem(DEFAULT_SHOP_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].propPicUrl").value(hasItem(DEFAULT_PROP_PIC_URL)))
            .andExpect(jsonPath("$.[*].propMapUrl").value(hasItem(DEFAULT_PROP_MAP_URL)))
            .andExpect(jsonPath("$.[*].extExpFileLocation").value(hasItem(DEFAULT_EXT_EXP_FILE_LOCATION)))
            .andExpect(jsonPath("$.[*].curtainColor").value(hasItem(DEFAULT_CURTAIN_COLOR)))
            .andExpect(jsonPath("$.[*].countryCode").value(hasItem(DEFAULT_COUNTRY_CODE)))
            .andExpect(jsonPath("$.[*].state").value(hasItem(DEFAULT_STATE)))
            .andExpect(jsonPath("$.[*].dateForAging").value(hasItem(DEFAULT_DATE_FOR_AGING)))
            .andExpect(jsonPath("$.[*].regionCode").value(hasItem(DEFAULT_REGION_CODE)))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY)))
            .andExpect(jsonPath("$.[*].telephone").value(hasItem(DEFAULT_TELEPHONE)))
            .andExpect(jsonPath("$.[*].fax").value(hasItem(DEFAULT_FAX)))
            .andExpect(jsonPath("$.[*].tollfree").value(hasItem(DEFAULT_TOLLFREE)))
            .andExpect(jsonPath("$.[*].defaultPrinter").value(hasItem(DEFAULT_DEFAULT_PRINTER)))
            .andExpect(jsonPath("$.[*].videocheckoutPrinter").value(hasItem(DEFAULT_VIDEOCHECKOUT_PRINTER)))
            .andExpect(jsonPath("$.[*].companyAddressType").value(hasItem(DEFAULT_COMPANY_ADDRESS_TYPE)))
            .andExpect(jsonPath("$.[*].companyPhoneType").value(hasItem(DEFAULT_COMPANY_PHONE_TYPE)))
            .andExpect(jsonPath("$.[*].defaultFaxType").value(hasItem(DEFAULT_DEFAULT_FAX_TYPE)))
            .andExpect(jsonPath("$.[*].defaultMembershipType").value(hasItem(DEFAULT_DEFAULT_MEMBERSHIP_TYPE)))
            .andExpect(jsonPath("$.[*].individualAddressType").value(hasItem(DEFAULT_INDIVIDUAL_ADDRESS_TYPE)))
            .andExpect(jsonPath("$.[*].individualPhoneType").value(hasItem(DEFAULT_INDIVIDUAL_PHONE_TYPE)))
            .andExpect(jsonPath("$.[*].notes").value(hasItem(DEFAULT_NOTES)))
            .andExpect(jsonPath("$.[*].blackoutPeriodNotes").value(hasItem(DEFAULT_BLACKOUT_PERIOD_NOTES)))
            .andExpect(jsonPath("$.[*].sglNum").value(hasItem(DEFAULT_SGL_NUM)))
            .andExpect(jsonPath("$.[*].dblNum").value(hasItem(DEFAULT_DBL_NUM)))
            .andExpect(jsonPath("$.[*].tplNum").value(hasItem(DEFAULT_TPL_NUM)))
            .andExpect(jsonPath("$.[*].suiNum").value(hasItem(DEFAULT_SUI_NUM)))
            .andExpect(jsonPath("$.[*].airportDistance").value(hasItem(DEFAULT_AIRPORT_DISTANCE)))
            .andExpect(jsonPath("$.[*].airportTime").value(hasItem(DEFAULT_AIRPORT_TIME)))
            .andExpect(jsonPath("$.[*].brArea").value(hasItem(DEFAULT_BR_AREA)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].legalOwner").value(hasItem(DEFAULT_LEGAL_OWNER)))
            .andExpect(jsonPath("$.[*].hotelId").value(hasItem(DEFAULT_HOTEL_ID)))
            .andExpect(jsonPath("$.[*].faxNoFormat").value(hasItem(DEFAULT_FAX_NO_FORMAT)))
            .andExpect(jsonPath("$.[*].telephoneNoFormat").value(hasItem(DEFAULT_TELEPHONE_NO_FORMAT)))
            .andExpect(jsonPath("$.[*].localCurrencyFormat").value(hasItem(DEFAULT_LOCAL_CURRENCY_FORMAT)))
            .andExpect(jsonPath("$.[*].dutyManagerPager").value(hasItem(DEFAULT_DUTY_MANAGER_PAGER)))
            .andExpect(jsonPath("$.[*].defaultRegistrationCard").value(hasItem(DEFAULT_DEFAULT_REGISTRATION_CARD)))
            .andExpect(jsonPath("$.[*].nightAuditCashierId").value(hasItem(DEFAULT_NIGHT_AUDIT_CASHIER_ID)))
            .andExpect(jsonPath("$.[*].hotelCode").value(hasItem(DEFAULT_HOTEL_CODE)))
            .andExpect(jsonPath("$.[*].path").value(hasItem(DEFAULT_PATH)))
            .andExpect(jsonPath("$.[*].timezoneRegion").value(hasItem(DEFAULT_TIMEZONE_REGION)))
            .andExpect(jsonPath("$.[*].cateringCurrencyFormat").value(hasItem(DEFAULT_CATERING_CURRENCY_FORMAT)))
            .andExpect(jsonPath("$.[*].expHotelCode").value(hasItem(DEFAULT_EXP_HOTEL_CODE)));
    }

    @Test
    @Transactional
    void getResort() throws Exception {
        // Initialize the database
        resortRepository.saveAndFlush(resort);

        // Get the resort
        restResortMockMvc
            .perform(get(ENTITY_API_URL_ID, resort.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(resort.getId()))
            .andExpect(jsonPath("$.resort").value(DEFAULT_RESORT))
            .andExpect(jsonPath("$.beginDate").value(sameInstant(DEFAULT_BEGIN_DATE)))
            .andExpect(jsonPath("$.checkInTime").value(sameInstant(DEFAULT_CHECK_IN_TIME)))
            .andExpect(jsonPath("$.checkOutTime").value(sameInstant(DEFAULT_CHECK_OUT_TIME)))
            .andExpect(jsonPath("$.videoCoStart").value(sameInstant(DEFAULT_VIDEO_CO_START)))
            .andExpect(jsonPath("$.videoCoStop").value(sameInstant(DEFAULT_VIDEO_CO_STOP)))
            .andExpect(jsonPath("$.insertDate").value(sameInstant(DEFAULT_INSERT_DATE)))
            .andExpect(jsonPath("$.updateDate").value(sameInstant(DEFAULT_UPDATE_DATE)))
            .andExpect(jsonPath("$.expiryDate").value(sameInstant(DEFAULT_EXPIRY_DATE)))
            .andExpect(jsonPath("$.endDate").value(sameInstant(DEFAULT_END_DATE)))
            .andExpect(jsonPath("$.fiscalStartDate").value(sameInstant(DEFAULT_FISCAL_START_DATE)))
            .andExpect(jsonPath("$.fiscalEndDate").value(sameInstant(DEFAULT_FISCAL_END_DATE)))
            .andExpect(jsonPath("$.reconcileDate").value(sameInstant(DEFAULT_RECONCILE_DATE)))
            .andExpect(jsonPath("$.paymentDate").value(sameInstant(DEFAULT_PAYMENT_DATE)))
            .andExpect(jsonPath("$.keepAvailability").value(DEFAULT_KEEP_AVAILABILITY))
            .andExpect(jsonPath("$.budgetMonth").value(DEFAULT_BUDGET_MONTH))
            .andExpect(jsonPath("$.saveProfiles").value(DEFAULT_SAVE_PROFILES))
            .andExpect(jsonPath("$.longStayControl").value(DEFAULT_LONG_STAY_CONTROL))
            .andExpect(jsonPath("$.creditLimit").value(DEFAULT_CREDIT_LIMIT))
            .andExpect(jsonPath("$.numberRooms").value(DEFAULT_NUMBER_ROOMS))
            .andExpect(jsonPath("$.numberFloors").value(DEFAULT_NUMBER_FLOORS))
            .andExpect(jsonPath("$.numberBeds").value(DEFAULT_NUMBER_BEDS))
            .andExpect(jsonPath("$.rhythmSheets").value(DEFAULT_RHYTHM_SHEETS))
            .andExpect(jsonPath("$.rhythmTowels").value(DEFAULT_RHYTHM_TOWELS))
            .andExpect(jsonPath("$.warningAmount").value(DEFAULT_WARNING_AMOUNT))
            .andExpect(jsonPath("$.decimalPlaces").value(DEFAULT_DECIMAL_PLACES))
            .andExpect(jsonPath("$.font").value(DEFAULT_FONT))
            .andExpect(jsonPath("$.copies").value(DEFAULT_COPIES))
            .andExpect(jsonPath("$.defaultFolioStyle").value(DEFAULT_DEFAULT_FOLIO_STYLE))
            .andExpect(jsonPath("$.individualRoomWarning").value(DEFAULT_INDIVIDUAL_ROOM_WARNING))
            .andExpect(jsonPath("$.groupRoomWarning").value(DEFAULT_GROUP_ROOM_WARNING))
            .andExpect(jsonPath("$.agingLevel1").value(DEFAULT_AGING_LEVEL_1))
            .andExpect(jsonPath("$.agingLevel2").value(DEFAULT_AGING_LEVEL_2))
            .andExpect(jsonPath("$.agingLevel3").value(DEFAULT_AGING_LEVEL_3))
            .andExpect(jsonPath("$.agingLevel4").value(DEFAULT_AGING_LEVEL_4))
            .andExpect(jsonPath("$.agingLevel5").value(DEFAULT_AGING_LEVEL_5))
            .andExpect(jsonPath("$.zeroInvPurDays").value(DEFAULT_ZERO_INV_PUR_DAYS))
            .andExpect(jsonPath("$.minDaysBet2ReminderLetter").value(DEFAULT_MIN_DAYS_BET_2_REMINDER_LETTER))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.currencyDecimals").value(DEFAULT_CURRENCY_DECIMALS))
            .andExpect(jsonPath("$.nameIdLink").value(DEFAULT_NAME_ID_LINK))
            .andExpect(jsonPath("$.sglRate1").value(DEFAULT_SGL_RATE_1))
            .andExpect(jsonPath("$.sglRate2").value(DEFAULT_SGL_RATE_2))
            .andExpect(jsonPath("$.dblRate1").value(DEFAULT_DBL_RATE_1))
            .andExpect(jsonPath("$.dblRate2").value(DEFAULT_DBL_RATE_2))
            .andExpect(jsonPath("$.tplRate1").value(DEFAULT_TPL_RATE_1))
            .andExpect(jsonPath("$.tplRate2").value(DEFAULT_TPL_RATE_2))
            .andExpect(jsonPath("$.suiRate1").value(DEFAULT_SUI_RATE_1))
            .andExpect(jsonPath("$.suiRate2").value(DEFAULT_SUI_RATE_2))
            .andExpect(jsonPath("$.meetSpace").value(DEFAULT_MEET_SPACE))
            .andExpect(jsonPath("$.imgHotelId").value(DEFAULT_IMG_HOTEL_ID))
            .andExpect(jsonPath("$.imgDirectionId").value(DEFAULT_IMG_DIRECTION_ID))
            .andExpect(jsonPath("$.imgMapId").value(DEFAULT_IMG_MAP_ID))
            .andExpect(jsonPath("$.scriptId").value(DEFAULT_SCRIPT_ID))
            .andExpect(jsonPath("$.comNameXrefId").value(DEFAULT_COM_NAME_XREF_ID))
            .andExpect(jsonPath("$.pathId").value(DEFAULT_PATH_ID))
            .andExpect(jsonPath("$.xresortNumber").value(DEFAULT_XRESORT_NUMBER))
            .andExpect(jsonPath("$.maxCreditDays").value(DEFAULT_MAX_CREDIT_DAYS))
            .andExpect(jsonPath("$.currencyDivisor").value(DEFAULT_CURRENCY_DIVISOR))
            .andExpect(jsonPath("$.latitude").value(DEFAULT_LATITUDE))
            .andExpect(jsonPath("$.longitude").value(DEFAULT_LONGITUDE))
            .andExpect(jsonPath("$.qtySingleRooms").value(DEFAULT_QTY_SINGLE_ROOMS))
            .andExpect(jsonPath("$.qtyDoubleRooms").value(DEFAULT_QTY_DOUBLE_ROOMS))
            .andExpect(jsonPath("$.qtyTwinRooms").value(DEFAULT_QTY_TWIN_ROOMS))
            .andExpect(jsonPath("$.qtySuites").value(DEFAULT_QTY_SUITES))
            .andExpect(jsonPath("$.qtyGuestRoomFloors").value(DEFAULT_QTY_GUEST_ROOM_FLOORS))
            .andExpect(jsonPath("$.qtyGuestElevators").value(DEFAULT_QTY_GUEST_ELEVATORS))
            .andExpect(jsonPath("$.qtyNonSmokingRooms").value(DEFAULT_QTY_NON_SMOKING_ROOMS))
            .andExpect(jsonPath("$.qtyConnectingRooms").value(DEFAULT_QTY_CONNECTING_ROOMS))
            .andExpect(jsonPath("$.qtyHandicappedRooms").value(DEFAULT_QTY_HANDICAPPED_ROOMS))
            .andExpect(jsonPath("$.qtyFamilyRooms").value(DEFAULT_QTY_FAMILY_ROOMS))
            .andExpect(jsonPath("$.maxAdultsFamilyRoom").value(DEFAULT_MAX_ADULTS_FAMILY_ROOM))
            .andExpect(jsonPath("$.maxChildrenFamilyRoom").value(DEFAULT_MAX_CHILDREN_FAMILY_ROOM))
            .andExpect(jsonPath("$.restaurant").value(DEFAULT_RESTAURANT))
            .andExpect(jsonPath("$.meetRooms").value(DEFAULT_MEET_ROOMS))
            .andExpect(jsonPath("$.totRooms").value(DEFAULT_TOT_ROOMS))
            .andExpect(jsonPath("$.brSeats").value(DEFAULT_BR_SEATS))
            .andExpect(jsonPath("$.meetSeats").value(DEFAULT_MEET_SEATS))
            .andExpect(jsonPath("$.maxNoNights").value(DEFAULT_MAX_NO_NIGHTS))
            .andExpect(jsonPath("$.awardsTimeout").value(DEFAULT_AWARDS_TIMEOUT))
            .andExpect(jsonPath("$.guestLookupTimeout").value(DEFAULT_GUEST_LOOKUP_TIMEOUT))
            .andExpect(jsonPath("$.wakeUpDelay").value(DEFAULT_WAKE_UP_DELAY))
            .andExpect(jsonPath("$.maxOccupancy").value(DEFAULT_MAX_OCCUPANCY))
            .andExpect(jsonPath("$.inactiveDaysForGuestProfil").value(DEFAULT_INACTIVE_DAYS_FOR_GUEST_PROFIL))
            .andExpect(jsonPath("$.perReservationRoomLimit").value(DEFAULT_PER_RESERVATION_ROOM_LIMIT))
            .andExpect(jsonPath("$.licRoomInfo").value(DEFAULT_LIC_ROOM_INFO))
            .andExpect(jsonPath("$.thousandSeparator").value(DEFAULT_THOUSAND_SEPARATOR))
            .andExpect(jsonPath("$.dateSeparator").value(DEFAULT_DATE_SEPARATOR))
            .andExpect(jsonPath("$.arAcctNoMandYn").value(DEFAULT_AR_ACCT_NO_MAND_YN))
            .andExpect(jsonPath("$.exchangePostingType").value(DEFAULT_EXCHANGE_POSTING_TYPE))
            .andExpect(jsonPath("$.inventoryYn").value(DEFAULT_INVENTORY_YN))
            .andExpect(jsonPath("$.allowLoginYn").value(DEFAULT_ALLOW_LOGIN_YN))
            .andExpect(jsonPath("$.accessCode").value(DEFAULT_ACCESS_CODE))
            .andExpect(jsonPath("$.disableLoginYn").value(DEFAULT_DISABLE_LOGIN_YN))
            .andExpect(jsonPath("$.intTaxIncludedYn").value(DEFAULT_INT_TAX_INCLUDED_YN))
            .andExpect(jsonPath("$.downloadRestYn").value(DEFAULT_DOWNLOAD_REST_YN))
            .andExpect(jsonPath("$.translateMulticharYn").value(DEFAULT_TRANSLATE_MULTICHAR_YN))
            .andExpect(jsonPath("$.externalScYn").value(DEFAULT_EXTERNAL_SC_YN))
            .andExpect(jsonPath("$.sendLeadAsBookingYn").value(DEFAULT_SEND_LEAD_AS_BOOKING_YN))
            .andExpect(jsonPath("$.mbsSupportedYn").value(DEFAULT_MBS_SUPPORTED_YN))
            .andExpect(jsonPath("$.quotedCurrency").value(DEFAULT_QUOTED_CURRENCY))
            .andExpect(jsonPath("$.comMethod").value(DEFAULT_COM_METHOD))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.genmgr").value(DEFAULT_GENMGR))
            .andExpect(jsonPath("$.dirsales").value(DEFAULT_DIRSALES))
            .andExpect(jsonPath("$.leadsend").value(DEFAULT_LEADSEND))
            .andExpect(jsonPath("$.airport").value(DEFAULT_AIRPORT))
            .andExpect(jsonPath("$.comAddress").value(DEFAULT_COM_ADDRESS))
            .andExpect(jsonPath("$.season1").value(DEFAULT_SEASON_1))
            .andExpect(jsonPath("$.season2").value(DEFAULT_SEASON_2))
            .andExpect(jsonPath("$.season3").value(DEFAULT_SEASON_3))
            .andExpect(jsonPath("$.season4").value(DEFAULT_SEASON_4))
            .andExpect(jsonPath("$.season5").value(DEFAULT_SEASON_5))
            .andExpect(jsonPath("$.floorNumExecutiveFloor").value(DEFAULT_FLOOR_NUM_EXECUTIVE_FLOOR))
            .andExpect(jsonPath("$.crsResort").value(DEFAULT_CRS_RESORT))
            .andExpect(jsonPath("$.postCode").value(DEFAULT_POST_CODE))
            .andExpect(jsonPath("$.defaultReservationType").value(DEFAULT_DEFAULT_RESERVATION_TYPE))
            .andExpect(jsonPath("$.block").value(DEFAULT_BLOCK))
            .andExpect(jsonPath("$.currencySymbol").value(DEFAULT_CURRENCY_SYMBOL))
            .andExpect(jsonPath("$.sourceCommission").value(DEFAULT_SOURCE_COMMISSION))
            .andExpect(jsonPath("$.taCommission").value(DEFAULT_TA_COMMISSION))
            .andExpect(jsonPath("$.baseLanguage").value(DEFAULT_BASE_LANGUAGE))
            .andExpect(jsonPath("$.folioLanguage1").value(DEFAULT_FOLIO_LANGUAGE_1))
            .andExpect(jsonPath("$.folioLanguage2").value(DEFAULT_FOLIO_LANGUAGE_2))
            .andExpect(jsonPath("$.folioLanguage3").value(DEFAULT_FOLIO_LANGUAGE_3))
            .andExpect(jsonPath("$.folioLanguage4").value(DEFAULT_FOLIO_LANGUAGE_4))
            .andExpect(jsonPath("$.packageProfit").value(DEFAULT_PACKAGE_PROFIT))
            .andExpect(jsonPath("$.packageLoss").value(DEFAULT_PACKAGE_LOSS))
            .andExpect(jsonPath("$.decimalSeparator").value(DEFAULT_DECIMAL_SEPARATOR))
            .andExpect(jsonPath("$.shortDateFormat").value(DEFAULT_SHORT_DATE_FORMAT))
            .andExpect(jsonPath("$.longDateFormat").value(DEFAULT_LONG_DATE_FORMAT))
            .andExpect(jsonPath("$.passerbySource").value(DEFAULT_PASSERBY_SOURCE))
            .andExpect(jsonPath("$.passerbyMarket").value(DEFAULT_PASSERBY_MARKET))
            .andExpect(jsonPath("$.arCompany").value(DEFAULT_AR_COMPANY))
            .andExpect(jsonPath("$.arAgent").value(DEFAULT_AR_AGENT))
            .andExpect(jsonPath("$.arGroups").value(DEFAULT_AR_GROUPS))
            .andExpect(jsonPath("$.arIndividuals").value(DEFAULT_AR_INDIVIDUALS))
            .andExpect(jsonPath("$.arAcctNoFormat").value(DEFAULT_AR_ACCT_NO_FORMAT))
            .andExpect(jsonPath("$.allowancePeriodAdj").value(DEFAULT_ALLOWANCE_PERIOD_ADJ))
            .andExpect(jsonPath("$.currencyCode").value(DEFAULT_CURRENCY_CODE))
            .andExpect(jsonPath("$.turnawayCode").value(DEFAULT_TURNAWAY_CODE))
            .andExpect(jsonPath("$.summCurrencyCode").value(DEFAULT_SUMM_CURRENCY_CODE))
            .andExpect(jsonPath("$.defaultPropertyAddress").value(DEFAULT_DEFAULT_PROPERTY_ADDRESS))
            .andExpect(jsonPath("$.defaultGuestAddress").value(DEFAULT_DEFAULT_GUEST_ADDRESS))
            .andExpect(jsonPath("$.licenseCode").value(DEFAULT_LICENSE_CODE))
            .andExpect(jsonPath("$.timeFormat").value(DEFAULT_TIME_FORMAT))
            .andExpect(jsonPath("$.chainCode").value(DEFAULT_CHAIN_CODE))
            .andExpect(jsonPath("$.resortType").value(DEFAULT_RESORT_TYPE))
            .andExpect(jsonPath("$.hotelType").value(DEFAULT_HOTEL_TYPE))
            .andExpect(jsonPath("$.ownership").value(DEFAULT_OWNERSHIP))
            .andExpect(jsonPath("$.arBalTrxCode").value(DEFAULT_AR_BAL_TRX_CODE))
            .andExpect(jsonPath("$.arCreditTrxCode").value(DEFAULT_AR_CREDIT_TRX_CODE))
            .andExpect(jsonPath("$.arSettleCode").value(DEFAULT_AR_SETTLE_CODE))
            .andExpect(jsonPath("$.cashShiftDrop").value(DEFAULT_CASH_SHIFT_DROP))
            .andExpect(jsonPath("$.checkExgPaidout").value(DEFAULT_CHECK_EXG_PAIDOUT))
            .andExpect(jsonPath("$.checkShiftDrop").value(DEFAULT_CHECK_SHIFT_DROP))
            .andExpect(jsonPath("$.checkTrxcode").value(DEFAULT_CHECK_TRXCODE))
            .andExpect(jsonPath("$.currencyExgPaidout").value(DEFAULT_CURRENCY_EXG_PAIDOUT))
            .andExpect(jsonPath("$.depositLedTrxCode").value(DEFAULT_DEPOSIT_LED_TRX_CODE))
            .andExpect(jsonPath("$.fiscalPeriodType").value(DEFAULT_FISCAL_PERIOD_TYPE))
            .andExpect(jsonPath("$.defaultCommissionPercentage").value(DEFAULT_DEFAULT_COMMISSION_PERCENTAGE))
            .andExpect(jsonPath("$.defaultPrepaidComm").value(DEFAULT_DEFAULT_PREPAID_COMM))
            .andExpect(jsonPath("$.defaultTrxCommCode").value(DEFAULT_DEFAULT_TRX_COMM_CODE))
            .andExpect(jsonPath("$.configurationMode").value(DEFAULT_CONFIGURATION_MODE))
            .andExpect(jsonPath("$.weekendDays").value(DEFAULT_WEEKEND_DAYS))
            .andExpect(jsonPath("$.defaultGroupsRateCode").value(DEFAULT_DEFAULT_GROUPS_RATE_CODE))
            .andExpect(jsonPath("$.defaultPostingRoom").value(DEFAULT_DEFAULT_POSTING_ROOM))
            .andExpect(jsonPath("$.dfltPkgTranCode").value(DEFAULT_DFLT_PKG_TRAN_CODE))
            .andExpect(jsonPath("$.dfltTranCodeRateCode").value(DEFAULT_DFLT_TRAN_CODE_RATE_CODE))
            .andExpect(jsonPath("$.defaultRateCode").value(DEFAULT_DEFAULT_RATE_CODE))
            .andExpect(jsonPath("$.croCode").value(DEFAULT_CRO_CODE))
            .andExpect(jsonPath("$.flowCode").value(DEFAULT_FLOW_CODE))
            .andExpect(jsonPath("$.extPropertyCode").value(DEFAULT_EXT_PROPERTY_CODE))
            .andExpect(jsonPath("$.opusCurrencyCode").value(DEFAULT_OPUS_CURRENCY_CODE))
            .andExpect(jsonPath("$.destinationId").value(DEFAULT_DESTINATION_ID))
            .andExpect(jsonPath("$.flags").value(DEFAULT_FLAGS))
            .andExpect(jsonPath("$.touristNumber").value(DEFAULT_TOURIST_NUMBER))
            .andExpect(jsonPath("$.cateringCurrencyCode").value(DEFAULT_CATERING_CURRENCY_CODE))
            .andExpect(jsonPath("$.defaultRatecodeRack").value(DEFAULT_DEFAULT_RATECODE_RACK))
            .andExpect(jsonPath("$.defaultRatecodePcr").value(DEFAULT_DEFAULT_RATECODE_PCR))
            .andExpect(jsonPath("$.fnsTier").value(DEFAULT_FNS_TIER))
            .andExpect(jsonPath("$.brandCode").value(DEFAULT_BRAND_CODE))
            .andExpect(jsonPath("$.webaddress").value(DEFAULT_WEBADDRESS))
            .andExpect(jsonPath("$.vatId").value(DEFAULT_VAT_ID))
            .andExpect(jsonPath("$.street").value(DEFAULT_STREET))
            .andExpect(jsonPath("$.hotelFc").value(DEFAULT_HOTEL_FC))
            .andExpect(jsonPath("$.meetingFc").value(DEFAULT_MEETING_FC))
            .andExpect(jsonPath("$.arTypewriter").value(DEFAULT_AR_TYPEWRITER))
            .andExpect(jsonPath("$.fileTransferFormat").value(DEFAULT_FILE_TRANSFER_FORMAT))
            .andExpect(jsonPath("$.confirmRegcardPrinter").value(DEFAULT_CONFIRM_REGCARD_PRINTER))
            .andExpect(jsonPath("$.directions").value(DEFAULT_DIRECTIONS))
            .andExpect(jsonPath("$.propinfoUrl").value(DEFAULT_PROPINFO_URL))
            .andExpect(jsonPath("$.roomAmenity").value(DEFAULT_ROOM_AMENITY))
            .andExpect(jsonPath("$.shopDescription").value(DEFAULT_SHOP_DESCRIPTION))
            .andExpect(jsonPath("$.propPicUrl").value(DEFAULT_PROP_PIC_URL))
            .andExpect(jsonPath("$.propMapUrl").value(DEFAULT_PROP_MAP_URL))
            .andExpect(jsonPath("$.extExpFileLocation").value(DEFAULT_EXT_EXP_FILE_LOCATION))
            .andExpect(jsonPath("$.curtainColor").value(DEFAULT_CURTAIN_COLOR))
            .andExpect(jsonPath("$.countryCode").value(DEFAULT_COUNTRY_CODE))
            .andExpect(jsonPath("$.state").value(DEFAULT_STATE))
            .andExpect(jsonPath("$.dateForAging").value(DEFAULT_DATE_FOR_AGING))
            .andExpect(jsonPath("$.regionCode").value(DEFAULT_REGION_CODE))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY))
            .andExpect(jsonPath("$.telephone").value(DEFAULT_TELEPHONE))
            .andExpect(jsonPath("$.fax").value(DEFAULT_FAX))
            .andExpect(jsonPath("$.tollfree").value(DEFAULT_TOLLFREE))
            .andExpect(jsonPath("$.defaultPrinter").value(DEFAULT_DEFAULT_PRINTER))
            .andExpect(jsonPath("$.videocheckoutPrinter").value(DEFAULT_VIDEOCHECKOUT_PRINTER))
            .andExpect(jsonPath("$.companyAddressType").value(DEFAULT_COMPANY_ADDRESS_TYPE))
            .andExpect(jsonPath("$.companyPhoneType").value(DEFAULT_COMPANY_PHONE_TYPE))
            .andExpect(jsonPath("$.defaultFaxType").value(DEFAULT_DEFAULT_FAX_TYPE))
            .andExpect(jsonPath("$.defaultMembershipType").value(DEFAULT_DEFAULT_MEMBERSHIP_TYPE))
            .andExpect(jsonPath("$.individualAddressType").value(DEFAULT_INDIVIDUAL_ADDRESS_TYPE))
            .andExpect(jsonPath("$.individualPhoneType").value(DEFAULT_INDIVIDUAL_PHONE_TYPE))
            .andExpect(jsonPath("$.notes").value(DEFAULT_NOTES))
            .andExpect(jsonPath("$.blackoutPeriodNotes").value(DEFAULT_BLACKOUT_PERIOD_NOTES))
            .andExpect(jsonPath("$.sglNum").value(DEFAULT_SGL_NUM))
            .andExpect(jsonPath("$.dblNum").value(DEFAULT_DBL_NUM))
            .andExpect(jsonPath("$.tplNum").value(DEFAULT_TPL_NUM))
            .andExpect(jsonPath("$.suiNum").value(DEFAULT_SUI_NUM))
            .andExpect(jsonPath("$.airportDistance").value(DEFAULT_AIRPORT_DISTANCE))
            .andExpect(jsonPath("$.airportTime").value(DEFAULT_AIRPORT_TIME))
            .andExpect(jsonPath("$.brArea").value(DEFAULT_BR_AREA))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.legalOwner").value(DEFAULT_LEGAL_OWNER))
            .andExpect(jsonPath("$.hotelId").value(DEFAULT_HOTEL_ID))
            .andExpect(jsonPath("$.faxNoFormat").value(DEFAULT_FAX_NO_FORMAT))
            .andExpect(jsonPath("$.telephoneNoFormat").value(DEFAULT_TELEPHONE_NO_FORMAT))
            .andExpect(jsonPath("$.localCurrencyFormat").value(DEFAULT_LOCAL_CURRENCY_FORMAT))
            .andExpect(jsonPath("$.dutyManagerPager").value(DEFAULT_DUTY_MANAGER_PAGER))
            .andExpect(jsonPath("$.defaultRegistrationCard").value(DEFAULT_DEFAULT_REGISTRATION_CARD))
            .andExpect(jsonPath("$.nightAuditCashierId").value(DEFAULT_NIGHT_AUDIT_CASHIER_ID))
            .andExpect(jsonPath("$.hotelCode").value(DEFAULT_HOTEL_CODE))
            .andExpect(jsonPath("$.path").value(DEFAULT_PATH))
            .andExpect(jsonPath("$.timezoneRegion").value(DEFAULT_TIMEZONE_REGION))
            .andExpect(jsonPath("$.cateringCurrencyFormat").value(DEFAULT_CATERING_CURRENCY_FORMAT))
            .andExpect(jsonPath("$.expHotelCode").value(DEFAULT_EXP_HOTEL_CODE));
    }

    @Test
    @Transactional
    void getNonExistingResort() throws Exception {
        // Get the resort
        restResortMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingResort() throws Exception {
        // Initialize the database
        resortRepository.saveAndFlush(resort);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the resort
        Resort updatedResort = resortRepository.findById(resort.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedResort are not directly saved in db
        em.detach(updatedResort);
        updatedResort
            .resort(UPDATED_RESORT)
            .beginDate(UPDATED_BEGIN_DATE)
            .checkInTime(UPDATED_CHECK_IN_TIME)
            .checkOutTime(UPDATED_CHECK_OUT_TIME)
            .videoCoStart(UPDATED_VIDEO_CO_START)
            .videoCoStop(UPDATED_VIDEO_CO_STOP)
            .insertDate(UPDATED_INSERT_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .expiryDate(UPDATED_EXPIRY_DATE)
            .endDate(UPDATED_END_DATE)
            .fiscalStartDate(UPDATED_FISCAL_START_DATE)
            .fiscalEndDate(UPDATED_FISCAL_END_DATE)
            .reconcileDate(UPDATED_RECONCILE_DATE)
            .paymentDate(UPDATED_PAYMENT_DATE)
            .keepAvailability(UPDATED_KEEP_AVAILABILITY)
            .budgetMonth(UPDATED_BUDGET_MONTH)
            .saveProfiles(UPDATED_SAVE_PROFILES)
            .longStayControl(UPDATED_LONG_STAY_CONTROL)
            .creditLimit(UPDATED_CREDIT_LIMIT)
            .numberRooms(UPDATED_NUMBER_ROOMS)
            .numberFloors(UPDATED_NUMBER_FLOORS)
            .numberBeds(UPDATED_NUMBER_BEDS)
            .rhythmSheets(UPDATED_RHYTHM_SHEETS)
            .rhythmTowels(UPDATED_RHYTHM_TOWELS)
            .warningAmount(UPDATED_WARNING_AMOUNT)
            .decimalPlaces(UPDATED_DECIMAL_PLACES)
            .font(UPDATED_FONT)
            .copies(UPDATED_COPIES)
            .defaultFolioStyle(UPDATED_DEFAULT_FOLIO_STYLE)
            .individualRoomWarning(UPDATED_INDIVIDUAL_ROOM_WARNING)
            .groupRoomWarning(UPDATED_GROUP_ROOM_WARNING)
            .agingLevel1(UPDATED_AGING_LEVEL_1)
            .agingLevel2(UPDATED_AGING_LEVEL_2)
            .agingLevel3(UPDATED_AGING_LEVEL_3)
            .agingLevel4(UPDATED_AGING_LEVEL_4)
            .agingLevel5(UPDATED_AGING_LEVEL_5)
            .zeroInvPurDays(UPDATED_ZERO_INV_PUR_DAYS)
            .minDaysBet2ReminderLetter(UPDATED_MIN_DAYS_BET_2_REMINDER_LETTER)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .currencyDecimals(UPDATED_CURRENCY_DECIMALS)
            .nameIdLink(UPDATED_NAME_ID_LINK)
            .sglRate1(UPDATED_SGL_RATE_1)
            .sglRate2(UPDATED_SGL_RATE_2)
            .dblRate1(UPDATED_DBL_RATE_1)
            .dblRate2(UPDATED_DBL_RATE_2)
            .tplRate1(UPDATED_TPL_RATE_1)
            .tplRate2(UPDATED_TPL_RATE_2)
            .suiRate1(UPDATED_SUI_RATE_1)
            .suiRate2(UPDATED_SUI_RATE_2)
            .meetSpace(UPDATED_MEET_SPACE)
            .imgHotelId(UPDATED_IMG_HOTEL_ID)
            .imgDirectionId(UPDATED_IMG_DIRECTION_ID)
            .imgMapId(UPDATED_IMG_MAP_ID)
            .scriptId(UPDATED_SCRIPT_ID)
            .comNameXrefId(UPDATED_COM_NAME_XREF_ID)
            .pathId(UPDATED_PATH_ID)
            .xresortNumber(UPDATED_XRESORT_NUMBER)
            .maxCreditDays(UPDATED_MAX_CREDIT_DAYS)
            .currencyDivisor(UPDATED_CURRENCY_DIVISOR)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .qtySingleRooms(UPDATED_QTY_SINGLE_ROOMS)
            .qtyDoubleRooms(UPDATED_QTY_DOUBLE_ROOMS)
            .qtyTwinRooms(UPDATED_QTY_TWIN_ROOMS)
            .qtySuites(UPDATED_QTY_SUITES)
            .qtyGuestRoomFloors(UPDATED_QTY_GUEST_ROOM_FLOORS)
            .qtyGuestElevators(UPDATED_QTY_GUEST_ELEVATORS)
            .qtyNonSmokingRooms(UPDATED_QTY_NON_SMOKING_ROOMS)
            .qtyConnectingRooms(UPDATED_QTY_CONNECTING_ROOMS)
            .qtyHandicappedRooms(UPDATED_QTY_HANDICAPPED_ROOMS)
            .qtyFamilyRooms(UPDATED_QTY_FAMILY_ROOMS)
            .maxAdultsFamilyRoom(UPDATED_MAX_ADULTS_FAMILY_ROOM)
            .maxChildrenFamilyRoom(UPDATED_MAX_CHILDREN_FAMILY_ROOM)
            .restaurant(UPDATED_RESTAURANT)
            .meetRooms(UPDATED_MEET_ROOMS)
            .totRooms(UPDATED_TOT_ROOMS)
            .brSeats(UPDATED_BR_SEATS)
            .meetSeats(UPDATED_MEET_SEATS)
            .maxNoNights(UPDATED_MAX_NO_NIGHTS)
            .awardsTimeout(UPDATED_AWARDS_TIMEOUT)
            .guestLookupTimeout(UPDATED_GUEST_LOOKUP_TIMEOUT)
            .wakeUpDelay(UPDATED_WAKE_UP_DELAY)
            .maxOccupancy(UPDATED_MAX_OCCUPANCY)
            .inactiveDaysForGuestProfil(UPDATED_INACTIVE_DAYS_FOR_GUEST_PROFIL)
            .perReservationRoomLimit(UPDATED_PER_RESERVATION_ROOM_LIMIT)
            .licRoomInfo(UPDATED_LIC_ROOM_INFO)
            .thousandSeparator(UPDATED_THOUSAND_SEPARATOR)
            .dateSeparator(UPDATED_DATE_SEPARATOR)
            .arAcctNoMandYn(UPDATED_AR_ACCT_NO_MAND_YN)
            .exchangePostingType(UPDATED_EXCHANGE_POSTING_TYPE)
            .inventoryYn(UPDATED_INVENTORY_YN)
            .allowLoginYn(UPDATED_ALLOW_LOGIN_YN)
            .accessCode(UPDATED_ACCESS_CODE)
            .disableLoginYn(UPDATED_DISABLE_LOGIN_YN)
            .intTaxIncludedYn(UPDATED_INT_TAX_INCLUDED_YN)
            .downloadRestYn(UPDATED_DOWNLOAD_REST_YN)
            .translateMulticharYn(UPDATED_TRANSLATE_MULTICHAR_YN)
            .externalScYn(UPDATED_EXTERNAL_SC_YN)
            .sendLeadAsBookingYn(UPDATED_SEND_LEAD_AS_BOOKING_YN)
            .mbsSupportedYn(UPDATED_MBS_SUPPORTED_YN)
            .quotedCurrency(UPDATED_QUOTED_CURRENCY)
            .comMethod(UPDATED_COM_METHOD)
            .email(UPDATED_EMAIL)
            .genmgr(UPDATED_GENMGR)
            .dirsales(UPDATED_DIRSALES)
            .leadsend(UPDATED_LEADSEND)
            .airport(UPDATED_AIRPORT)
            .comAddress(UPDATED_COM_ADDRESS)
            .season1(UPDATED_SEASON_1)
            .season2(UPDATED_SEASON_2)
            .season3(UPDATED_SEASON_3)
            .season4(UPDATED_SEASON_4)
            .season5(UPDATED_SEASON_5)
            .floorNumExecutiveFloor(UPDATED_FLOOR_NUM_EXECUTIVE_FLOOR)
            .crsResort(UPDATED_CRS_RESORT)
            .postCode(UPDATED_POST_CODE)
            .defaultReservationType(UPDATED_DEFAULT_RESERVATION_TYPE)
            .block(UPDATED_BLOCK)
            .currencySymbol(UPDATED_CURRENCY_SYMBOL)
            .sourceCommission(UPDATED_SOURCE_COMMISSION)
            .taCommission(UPDATED_TA_COMMISSION)
            .baseLanguage(UPDATED_BASE_LANGUAGE)
            .folioLanguage1(UPDATED_FOLIO_LANGUAGE_1)
            .folioLanguage2(UPDATED_FOLIO_LANGUAGE_2)
            .folioLanguage3(UPDATED_FOLIO_LANGUAGE_3)
            .folioLanguage4(UPDATED_FOLIO_LANGUAGE_4)
            .packageProfit(UPDATED_PACKAGE_PROFIT)
            .packageLoss(UPDATED_PACKAGE_LOSS)
            .decimalSeparator(UPDATED_DECIMAL_SEPARATOR)
            .shortDateFormat(UPDATED_SHORT_DATE_FORMAT)
            .longDateFormat(UPDATED_LONG_DATE_FORMAT)
            .passerbySource(UPDATED_PASSERBY_SOURCE)
            .passerbyMarket(UPDATED_PASSERBY_MARKET)
            .arCompany(UPDATED_AR_COMPANY)
            .arAgent(UPDATED_AR_AGENT)
            .arGroups(UPDATED_AR_GROUPS)
            .arIndividuals(UPDATED_AR_INDIVIDUALS)
            .arAcctNoFormat(UPDATED_AR_ACCT_NO_FORMAT)
            .allowancePeriodAdj(UPDATED_ALLOWANCE_PERIOD_ADJ)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .turnawayCode(UPDATED_TURNAWAY_CODE)
            .summCurrencyCode(UPDATED_SUMM_CURRENCY_CODE)
            .defaultPropertyAddress(UPDATED_DEFAULT_PROPERTY_ADDRESS)
            .defaultGuestAddress(UPDATED_DEFAULT_GUEST_ADDRESS)
            .licenseCode(UPDATED_LICENSE_CODE)
            .timeFormat(UPDATED_TIME_FORMAT)
            .chainCode(UPDATED_CHAIN_CODE)
            .resortType(UPDATED_RESORT_TYPE)
            .hotelType(UPDATED_HOTEL_TYPE)
            .ownership(UPDATED_OWNERSHIP)
            .arBalTrxCode(UPDATED_AR_BAL_TRX_CODE)
            .arCreditTrxCode(UPDATED_AR_CREDIT_TRX_CODE)
            .arSettleCode(UPDATED_AR_SETTLE_CODE)
            .cashShiftDrop(UPDATED_CASH_SHIFT_DROP)
            .checkExgPaidout(UPDATED_CHECK_EXG_PAIDOUT)
            .checkShiftDrop(UPDATED_CHECK_SHIFT_DROP)
            .checkTrxcode(UPDATED_CHECK_TRXCODE)
            .currencyExgPaidout(UPDATED_CURRENCY_EXG_PAIDOUT)
            .depositLedTrxCode(UPDATED_DEPOSIT_LED_TRX_CODE)
            .fiscalPeriodType(UPDATED_FISCAL_PERIOD_TYPE)
            .defaultCommissionPercentage(UPDATED_DEFAULT_COMMISSION_PERCENTAGE)
            .defaultPrepaidComm(UPDATED_DEFAULT_PREPAID_COMM)
            .defaultTrxCommCode(UPDATED_DEFAULT_TRX_COMM_CODE)
            .configurationMode(UPDATED_CONFIGURATION_MODE)
            .weekendDays(UPDATED_WEEKEND_DAYS)
            .defaultGroupsRateCode(UPDATED_DEFAULT_GROUPS_RATE_CODE)
            .defaultPostingRoom(UPDATED_DEFAULT_POSTING_ROOM)
            .dfltPkgTranCode(UPDATED_DFLT_PKG_TRAN_CODE)
            .dfltTranCodeRateCode(UPDATED_DFLT_TRAN_CODE_RATE_CODE)
            .defaultRateCode(UPDATED_DEFAULT_RATE_CODE)
            .croCode(UPDATED_CRO_CODE)
            .flowCode(UPDATED_FLOW_CODE)
            .extPropertyCode(UPDATED_EXT_PROPERTY_CODE)
            .opusCurrencyCode(UPDATED_OPUS_CURRENCY_CODE)
            .destinationId(UPDATED_DESTINATION_ID)
            .flags(UPDATED_FLAGS)
            .touristNumber(UPDATED_TOURIST_NUMBER)
            .cateringCurrencyCode(UPDATED_CATERING_CURRENCY_CODE)
            .defaultRatecodeRack(UPDATED_DEFAULT_RATECODE_RACK)
            .defaultRatecodePcr(UPDATED_DEFAULT_RATECODE_PCR)
            .fnsTier(UPDATED_FNS_TIER)
            .brandCode(UPDATED_BRAND_CODE)
            .webaddress(UPDATED_WEBADDRESS)
            .vatId(UPDATED_VAT_ID)
            .street(UPDATED_STREET)
            .hotelFc(UPDATED_HOTEL_FC)
            .meetingFc(UPDATED_MEETING_FC)
            .arTypewriter(UPDATED_AR_TYPEWRITER)
            .fileTransferFormat(UPDATED_FILE_TRANSFER_FORMAT)
            .confirmRegcardPrinter(UPDATED_CONFIRM_REGCARD_PRINTER)
            .directions(UPDATED_DIRECTIONS)
            .propinfoUrl(UPDATED_PROPINFO_URL)
            .roomAmenity(UPDATED_ROOM_AMENITY)
            .shopDescription(UPDATED_SHOP_DESCRIPTION)
            .propPicUrl(UPDATED_PROP_PIC_URL)
            .propMapUrl(UPDATED_PROP_MAP_URL)
            .extExpFileLocation(UPDATED_EXT_EXP_FILE_LOCATION)
            .curtainColor(UPDATED_CURTAIN_COLOR)
            .countryCode(UPDATED_COUNTRY_CODE)
            .state(UPDATED_STATE)
            .dateForAging(UPDATED_DATE_FOR_AGING)
            .regionCode(UPDATED_REGION_CODE)
            .city(UPDATED_CITY)
            .telephone(UPDATED_TELEPHONE)
            .fax(UPDATED_FAX)
            .tollfree(UPDATED_TOLLFREE)
            .defaultPrinter(UPDATED_DEFAULT_PRINTER)
            .videocheckoutPrinter(UPDATED_VIDEOCHECKOUT_PRINTER)
            .companyAddressType(UPDATED_COMPANY_ADDRESS_TYPE)
            .companyPhoneType(UPDATED_COMPANY_PHONE_TYPE)
            .defaultFaxType(UPDATED_DEFAULT_FAX_TYPE)
            .defaultMembershipType(UPDATED_DEFAULT_MEMBERSHIP_TYPE)
            .individualAddressType(UPDATED_INDIVIDUAL_ADDRESS_TYPE)
            .individualPhoneType(UPDATED_INDIVIDUAL_PHONE_TYPE)
            .notes(UPDATED_NOTES)
            .blackoutPeriodNotes(UPDATED_BLACKOUT_PERIOD_NOTES)
            .sglNum(UPDATED_SGL_NUM)
            .dblNum(UPDATED_DBL_NUM)
            .tplNum(UPDATED_TPL_NUM)
            .suiNum(UPDATED_SUI_NUM)
            .airportDistance(UPDATED_AIRPORT_DISTANCE)
            .airportTime(UPDATED_AIRPORT_TIME)
            .brArea(UPDATED_BR_AREA)
            .name(UPDATED_NAME)
            .legalOwner(UPDATED_LEGAL_OWNER)
            .hotelId(UPDATED_HOTEL_ID)
            .faxNoFormat(UPDATED_FAX_NO_FORMAT)
            .telephoneNoFormat(UPDATED_TELEPHONE_NO_FORMAT)
            .localCurrencyFormat(UPDATED_LOCAL_CURRENCY_FORMAT)
            .dutyManagerPager(UPDATED_DUTY_MANAGER_PAGER)
            .defaultRegistrationCard(UPDATED_DEFAULT_REGISTRATION_CARD)
            .nightAuditCashierId(UPDATED_NIGHT_AUDIT_CASHIER_ID)
            .hotelCode(UPDATED_HOTEL_CODE)
            .path(UPDATED_PATH)
            .timezoneRegion(UPDATED_TIMEZONE_REGION)
            .cateringCurrencyFormat(UPDATED_CATERING_CURRENCY_FORMAT)
            .expHotelCode(UPDATED_EXP_HOTEL_CODE);

        restResortMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedResort.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedResort))
            )
            .andExpect(status().isOk());

        // Validate the Resort in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedResortToMatchAllProperties(updatedResort);
    }

    @Test
    @Transactional
    void putNonExistingResort() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resort.setId(UUID.randomUUID().toString());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restResortMockMvc
            .perform(put(ENTITY_API_URL_ID, resort.getId()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(resort)))
            .andExpect(status().isBadRequest());

        // Validate the Resort in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchResort() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resort.setId(UUID.randomUUID().toString());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortMockMvc
            .perform(
                put(ENTITY_API_URL_ID, UUID.randomUUID().toString())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(resort))
            )
            .andExpect(status().isBadRequest());

        // Validate the Resort in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamResort() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resort.setId(UUID.randomUUID().toString());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(resort)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Resort in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateResortWithPatch() throws Exception {
        // Initialize the database
        resortRepository.saveAndFlush(resort);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the resort using partial update
        Resort partialUpdatedResort = new Resort();
        partialUpdatedResort.setId(resort.getId());

        partialUpdatedResort
            .resort(UPDATED_RESORT)
            .beginDate(UPDATED_BEGIN_DATE)
            .videoCoStart(UPDATED_VIDEO_CO_START)
            .insertDate(UPDATED_INSERT_DATE)
            .expiryDate(UPDATED_EXPIRY_DATE)
            .keepAvailability(UPDATED_KEEP_AVAILABILITY)
            .saveProfiles(UPDATED_SAVE_PROFILES)
            .creditLimit(UPDATED_CREDIT_LIMIT)
            .numberRooms(UPDATED_NUMBER_ROOMS)
            .numberFloors(UPDATED_NUMBER_FLOORS)
            .rhythmTowels(UPDATED_RHYTHM_TOWELS)
            .warningAmount(UPDATED_WARNING_AMOUNT)
            .decimalPlaces(UPDATED_DECIMAL_PLACES)
            .font(UPDATED_FONT)
            .copies(UPDATED_COPIES)
            .agingLevel4(UPDATED_AGING_LEVEL_4)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .dblRate1(UPDATED_DBL_RATE_1)
            .suiRate1(UPDATED_SUI_RATE_1)
            .suiRate2(UPDATED_SUI_RATE_2)
            .meetSpace(UPDATED_MEET_SPACE)
            .imgHotelId(UPDATED_IMG_HOTEL_ID)
            .comNameXrefId(UPDATED_COM_NAME_XREF_ID)
            .pathId(UPDATED_PATH_ID)
            .xresortNumber(UPDATED_XRESORT_NUMBER)
            .currencyDivisor(UPDATED_CURRENCY_DIVISOR)
            .longitude(UPDATED_LONGITUDE)
            .qtySingleRooms(UPDATED_QTY_SINGLE_ROOMS)
            .qtyGuestRoomFloors(UPDATED_QTY_GUEST_ROOM_FLOORS)
            .qtyGuestElevators(UPDATED_QTY_GUEST_ELEVATORS)
            .qtyNonSmokingRooms(UPDATED_QTY_NON_SMOKING_ROOMS)
            .qtyHandicappedRooms(UPDATED_QTY_HANDICAPPED_ROOMS)
            .qtyFamilyRooms(UPDATED_QTY_FAMILY_ROOMS)
            .maxAdultsFamilyRoom(UPDATED_MAX_ADULTS_FAMILY_ROOM)
            .restaurant(UPDATED_RESTAURANT)
            .maxNoNights(UPDATED_MAX_NO_NIGHTS)
            .awardsTimeout(UPDATED_AWARDS_TIMEOUT)
            .wakeUpDelay(UPDATED_WAKE_UP_DELAY)
            .maxOccupancy(UPDATED_MAX_OCCUPANCY)
            .inactiveDaysForGuestProfil(UPDATED_INACTIVE_DAYS_FOR_GUEST_PROFIL)
            .licRoomInfo(UPDATED_LIC_ROOM_INFO)
            .thousandSeparator(UPDATED_THOUSAND_SEPARATOR)
            .dateSeparator(UPDATED_DATE_SEPARATOR)
            .arAcctNoMandYn(UPDATED_AR_ACCT_NO_MAND_YN)
            .exchangePostingType(UPDATED_EXCHANGE_POSTING_TYPE)
            .accessCode(UPDATED_ACCESS_CODE)
            .intTaxIncludedYn(UPDATED_INT_TAX_INCLUDED_YN)
            .translateMulticharYn(UPDATED_TRANSLATE_MULTICHAR_YN)
            .dirsales(UPDATED_DIRSALES)
            .airport(UPDATED_AIRPORT)
            .season2(UPDATED_SEASON_2)
            .season3(UPDATED_SEASON_3)
            .floorNumExecutiveFloor(UPDATED_FLOOR_NUM_EXECUTIVE_FLOOR)
            .postCode(UPDATED_POST_CODE)
            .currencySymbol(UPDATED_CURRENCY_SYMBOL)
            .sourceCommission(UPDATED_SOURCE_COMMISSION)
            .folioLanguage1(UPDATED_FOLIO_LANGUAGE_1)
            .folioLanguage2(UPDATED_FOLIO_LANGUAGE_2)
            .folioLanguage3(UPDATED_FOLIO_LANGUAGE_3)
            .folioLanguage4(UPDATED_FOLIO_LANGUAGE_4)
            .packageProfit(UPDATED_PACKAGE_PROFIT)
            .packageLoss(UPDATED_PACKAGE_LOSS)
            .shortDateFormat(UPDATED_SHORT_DATE_FORMAT)
            .passerbyMarket(UPDATED_PASSERBY_MARKET)
            .arCompany(UPDATED_AR_COMPANY)
            .arAgent(UPDATED_AR_AGENT)
            .arIndividuals(UPDATED_AR_INDIVIDUALS)
            .arAcctNoFormat(UPDATED_AR_ACCT_NO_FORMAT)
            .summCurrencyCode(UPDATED_SUMM_CURRENCY_CODE)
            .hotelType(UPDATED_HOTEL_TYPE)
            .ownership(UPDATED_OWNERSHIP)
            .arSettleCode(UPDATED_AR_SETTLE_CODE)
            .cashShiftDrop(UPDATED_CASH_SHIFT_DROP)
            .checkTrxcode(UPDATED_CHECK_TRXCODE)
            .depositLedTrxCode(UPDATED_DEPOSIT_LED_TRX_CODE)
            .defaultCommissionPercentage(UPDATED_DEFAULT_COMMISSION_PERCENTAGE)
            .defaultPrepaidComm(UPDATED_DEFAULT_PREPAID_COMM)
            .defaultTrxCommCode(UPDATED_DEFAULT_TRX_COMM_CODE)
            .dfltPkgTranCode(UPDATED_DFLT_PKG_TRAN_CODE)
            .defaultRateCode(UPDATED_DEFAULT_RATE_CODE)
            .flowCode(UPDATED_FLOW_CODE)
            .extPropertyCode(UPDATED_EXT_PROPERTY_CODE)
            .flags(UPDATED_FLAGS)
            .touristNumber(UPDATED_TOURIST_NUMBER)
            .defaultRatecodeRack(UPDATED_DEFAULT_RATECODE_RACK)
            .webaddress(UPDATED_WEBADDRESS)
            .hotelFc(UPDATED_HOTEL_FC)
            .meetingFc(UPDATED_MEETING_FC)
            .arTypewriter(UPDATED_AR_TYPEWRITER)
            .fileTransferFormat(UPDATED_FILE_TRANSFER_FORMAT)
            .confirmRegcardPrinter(UPDATED_CONFIRM_REGCARD_PRINTER)
            .propinfoUrl(UPDATED_PROPINFO_URL)
            .propMapUrl(UPDATED_PROP_MAP_URL)
            .extExpFileLocation(UPDATED_EXT_EXP_FILE_LOCATION)
            .countryCode(UPDATED_COUNTRY_CODE)
            .regionCode(UPDATED_REGION_CODE)
            .telephone(UPDATED_TELEPHONE)
            .fax(UPDATED_FAX)
            .tollfree(UPDATED_TOLLFREE)
            .defaultPrinter(UPDATED_DEFAULT_PRINTER)
            .companyAddressType(UPDATED_COMPANY_ADDRESS_TYPE)
            .individualAddressType(UPDATED_INDIVIDUAL_ADDRESS_TYPE)
            .notes(UPDATED_NOTES)
            .blackoutPeriodNotes(UPDATED_BLACKOUT_PERIOD_NOTES)
            .dblNum(UPDATED_DBL_NUM)
            .suiNum(UPDATED_SUI_NUM)
            .name(UPDATED_NAME)
            .telephoneNoFormat(UPDATED_TELEPHONE_NO_FORMAT)
            .localCurrencyFormat(UPDATED_LOCAL_CURRENCY_FORMAT)
            .dutyManagerPager(UPDATED_DUTY_MANAGER_PAGER)
            .hotelCode(UPDATED_HOTEL_CODE)
            .path(UPDATED_PATH);

        restResortMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedResort.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedResort))
            )
            .andExpect(status().isOk());

        // Validate the Resort in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertResortUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedResort, resort), getPersistedResort(resort));
    }

    @Test
    @Transactional
    void fullUpdateResortWithPatch() throws Exception {
        // Initialize the database
        resortRepository.saveAndFlush(resort);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the resort using partial update
        Resort partialUpdatedResort = new Resort();
        partialUpdatedResort.setId(resort.getId());

        partialUpdatedResort
            .resort(UPDATED_RESORT)
            .beginDate(UPDATED_BEGIN_DATE)
            .checkInTime(UPDATED_CHECK_IN_TIME)
            .checkOutTime(UPDATED_CHECK_OUT_TIME)
            .videoCoStart(UPDATED_VIDEO_CO_START)
            .videoCoStop(UPDATED_VIDEO_CO_STOP)
            .insertDate(UPDATED_INSERT_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .expiryDate(UPDATED_EXPIRY_DATE)
            .endDate(UPDATED_END_DATE)
            .fiscalStartDate(UPDATED_FISCAL_START_DATE)
            .fiscalEndDate(UPDATED_FISCAL_END_DATE)
            .reconcileDate(UPDATED_RECONCILE_DATE)
            .paymentDate(UPDATED_PAYMENT_DATE)
            .keepAvailability(UPDATED_KEEP_AVAILABILITY)
            .budgetMonth(UPDATED_BUDGET_MONTH)
            .saveProfiles(UPDATED_SAVE_PROFILES)
            .longStayControl(UPDATED_LONG_STAY_CONTROL)
            .creditLimit(UPDATED_CREDIT_LIMIT)
            .numberRooms(UPDATED_NUMBER_ROOMS)
            .numberFloors(UPDATED_NUMBER_FLOORS)
            .numberBeds(UPDATED_NUMBER_BEDS)
            .rhythmSheets(UPDATED_RHYTHM_SHEETS)
            .rhythmTowels(UPDATED_RHYTHM_TOWELS)
            .warningAmount(UPDATED_WARNING_AMOUNT)
            .decimalPlaces(UPDATED_DECIMAL_PLACES)
            .font(UPDATED_FONT)
            .copies(UPDATED_COPIES)
            .defaultFolioStyle(UPDATED_DEFAULT_FOLIO_STYLE)
            .individualRoomWarning(UPDATED_INDIVIDUAL_ROOM_WARNING)
            .groupRoomWarning(UPDATED_GROUP_ROOM_WARNING)
            .agingLevel1(UPDATED_AGING_LEVEL_1)
            .agingLevel2(UPDATED_AGING_LEVEL_2)
            .agingLevel3(UPDATED_AGING_LEVEL_3)
            .agingLevel4(UPDATED_AGING_LEVEL_4)
            .agingLevel5(UPDATED_AGING_LEVEL_5)
            .zeroInvPurDays(UPDATED_ZERO_INV_PUR_DAYS)
            .minDaysBet2ReminderLetter(UPDATED_MIN_DAYS_BET_2_REMINDER_LETTER)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .currencyDecimals(UPDATED_CURRENCY_DECIMALS)
            .nameIdLink(UPDATED_NAME_ID_LINK)
            .sglRate1(UPDATED_SGL_RATE_1)
            .sglRate2(UPDATED_SGL_RATE_2)
            .dblRate1(UPDATED_DBL_RATE_1)
            .dblRate2(UPDATED_DBL_RATE_2)
            .tplRate1(UPDATED_TPL_RATE_1)
            .tplRate2(UPDATED_TPL_RATE_2)
            .suiRate1(UPDATED_SUI_RATE_1)
            .suiRate2(UPDATED_SUI_RATE_2)
            .meetSpace(UPDATED_MEET_SPACE)
            .imgHotelId(UPDATED_IMG_HOTEL_ID)
            .imgDirectionId(UPDATED_IMG_DIRECTION_ID)
            .imgMapId(UPDATED_IMG_MAP_ID)
            .scriptId(UPDATED_SCRIPT_ID)
            .comNameXrefId(UPDATED_COM_NAME_XREF_ID)
            .pathId(UPDATED_PATH_ID)
            .xresortNumber(UPDATED_XRESORT_NUMBER)
            .maxCreditDays(UPDATED_MAX_CREDIT_DAYS)
            .currencyDivisor(UPDATED_CURRENCY_DIVISOR)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .qtySingleRooms(UPDATED_QTY_SINGLE_ROOMS)
            .qtyDoubleRooms(UPDATED_QTY_DOUBLE_ROOMS)
            .qtyTwinRooms(UPDATED_QTY_TWIN_ROOMS)
            .qtySuites(UPDATED_QTY_SUITES)
            .qtyGuestRoomFloors(UPDATED_QTY_GUEST_ROOM_FLOORS)
            .qtyGuestElevators(UPDATED_QTY_GUEST_ELEVATORS)
            .qtyNonSmokingRooms(UPDATED_QTY_NON_SMOKING_ROOMS)
            .qtyConnectingRooms(UPDATED_QTY_CONNECTING_ROOMS)
            .qtyHandicappedRooms(UPDATED_QTY_HANDICAPPED_ROOMS)
            .qtyFamilyRooms(UPDATED_QTY_FAMILY_ROOMS)
            .maxAdultsFamilyRoom(UPDATED_MAX_ADULTS_FAMILY_ROOM)
            .maxChildrenFamilyRoom(UPDATED_MAX_CHILDREN_FAMILY_ROOM)
            .restaurant(UPDATED_RESTAURANT)
            .meetRooms(UPDATED_MEET_ROOMS)
            .totRooms(UPDATED_TOT_ROOMS)
            .brSeats(UPDATED_BR_SEATS)
            .meetSeats(UPDATED_MEET_SEATS)
            .maxNoNights(UPDATED_MAX_NO_NIGHTS)
            .awardsTimeout(UPDATED_AWARDS_TIMEOUT)
            .guestLookupTimeout(UPDATED_GUEST_LOOKUP_TIMEOUT)
            .wakeUpDelay(UPDATED_WAKE_UP_DELAY)
            .maxOccupancy(UPDATED_MAX_OCCUPANCY)
            .inactiveDaysForGuestProfil(UPDATED_INACTIVE_DAYS_FOR_GUEST_PROFIL)
            .perReservationRoomLimit(UPDATED_PER_RESERVATION_ROOM_LIMIT)
            .licRoomInfo(UPDATED_LIC_ROOM_INFO)
            .thousandSeparator(UPDATED_THOUSAND_SEPARATOR)
            .dateSeparator(UPDATED_DATE_SEPARATOR)
            .arAcctNoMandYn(UPDATED_AR_ACCT_NO_MAND_YN)
            .exchangePostingType(UPDATED_EXCHANGE_POSTING_TYPE)
            .inventoryYn(UPDATED_INVENTORY_YN)
            .allowLoginYn(UPDATED_ALLOW_LOGIN_YN)
            .accessCode(UPDATED_ACCESS_CODE)
            .disableLoginYn(UPDATED_DISABLE_LOGIN_YN)
            .intTaxIncludedYn(UPDATED_INT_TAX_INCLUDED_YN)
            .downloadRestYn(UPDATED_DOWNLOAD_REST_YN)
            .translateMulticharYn(UPDATED_TRANSLATE_MULTICHAR_YN)
            .externalScYn(UPDATED_EXTERNAL_SC_YN)
            .sendLeadAsBookingYn(UPDATED_SEND_LEAD_AS_BOOKING_YN)
            .mbsSupportedYn(UPDATED_MBS_SUPPORTED_YN)
            .quotedCurrency(UPDATED_QUOTED_CURRENCY)
            .comMethod(UPDATED_COM_METHOD)
            .email(UPDATED_EMAIL)
            .genmgr(UPDATED_GENMGR)
            .dirsales(UPDATED_DIRSALES)
            .leadsend(UPDATED_LEADSEND)
            .airport(UPDATED_AIRPORT)
            .comAddress(UPDATED_COM_ADDRESS)
            .season1(UPDATED_SEASON_1)
            .season2(UPDATED_SEASON_2)
            .season3(UPDATED_SEASON_3)
            .season4(UPDATED_SEASON_4)
            .season5(UPDATED_SEASON_5)
            .floorNumExecutiveFloor(UPDATED_FLOOR_NUM_EXECUTIVE_FLOOR)
            .crsResort(UPDATED_CRS_RESORT)
            .postCode(UPDATED_POST_CODE)
            .defaultReservationType(UPDATED_DEFAULT_RESERVATION_TYPE)
            .block(UPDATED_BLOCK)
            .currencySymbol(UPDATED_CURRENCY_SYMBOL)
            .sourceCommission(UPDATED_SOURCE_COMMISSION)
            .taCommission(UPDATED_TA_COMMISSION)
            .baseLanguage(UPDATED_BASE_LANGUAGE)
            .folioLanguage1(UPDATED_FOLIO_LANGUAGE_1)
            .folioLanguage2(UPDATED_FOLIO_LANGUAGE_2)
            .folioLanguage3(UPDATED_FOLIO_LANGUAGE_3)
            .folioLanguage4(UPDATED_FOLIO_LANGUAGE_4)
            .packageProfit(UPDATED_PACKAGE_PROFIT)
            .packageLoss(UPDATED_PACKAGE_LOSS)
            .decimalSeparator(UPDATED_DECIMAL_SEPARATOR)
            .shortDateFormat(UPDATED_SHORT_DATE_FORMAT)
            .longDateFormat(UPDATED_LONG_DATE_FORMAT)
            .passerbySource(UPDATED_PASSERBY_SOURCE)
            .passerbyMarket(UPDATED_PASSERBY_MARKET)
            .arCompany(UPDATED_AR_COMPANY)
            .arAgent(UPDATED_AR_AGENT)
            .arGroups(UPDATED_AR_GROUPS)
            .arIndividuals(UPDATED_AR_INDIVIDUALS)
            .arAcctNoFormat(UPDATED_AR_ACCT_NO_FORMAT)
            .allowancePeriodAdj(UPDATED_ALLOWANCE_PERIOD_ADJ)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .turnawayCode(UPDATED_TURNAWAY_CODE)
            .summCurrencyCode(UPDATED_SUMM_CURRENCY_CODE)
            .defaultPropertyAddress(UPDATED_DEFAULT_PROPERTY_ADDRESS)
            .defaultGuestAddress(UPDATED_DEFAULT_GUEST_ADDRESS)
            .licenseCode(UPDATED_LICENSE_CODE)
            .timeFormat(UPDATED_TIME_FORMAT)
            .chainCode(UPDATED_CHAIN_CODE)
            .resortType(UPDATED_RESORT_TYPE)
            .hotelType(UPDATED_HOTEL_TYPE)
            .ownership(UPDATED_OWNERSHIP)
            .arBalTrxCode(UPDATED_AR_BAL_TRX_CODE)
            .arCreditTrxCode(UPDATED_AR_CREDIT_TRX_CODE)
            .arSettleCode(UPDATED_AR_SETTLE_CODE)
            .cashShiftDrop(UPDATED_CASH_SHIFT_DROP)
            .checkExgPaidout(UPDATED_CHECK_EXG_PAIDOUT)
            .checkShiftDrop(UPDATED_CHECK_SHIFT_DROP)
            .checkTrxcode(UPDATED_CHECK_TRXCODE)
            .currencyExgPaidout(UPDATED_CURRENCY_EXG_PAIDOUT)
            .depositLedTrxCode(UPDATED_DEPOSIT_LED_TRX_CODE)
            .fiscalPeriodType(UPDATED_FISCAL_PERIOD_TYPE)
            .defaultCommissionPercentage(UPDATED_DEFAULT_COMMISSION_PERCENTAGE)
            .defaultPrepaidComm(UPDATED_DEFAULT_PREPAID_COMM)
            .defaultTrxCommCode(UPDATED_DEFAULT_TRX_COMM_CODE)
            .configurationMode(UPDATED_CONFIGURATION_MODE)
            .weekendDays(UPDATED_WEEKEND_DAYS)
            .defaultGroupsRateCode(UPDATED_DEFAULT_GROUPS_RATE_CODE)
            .defaultPostingRoom(UPDATED_DEFAULT_POSTING_ROOM)
            .dfltPkgTranCode(UPDATED_DFLT_PKG_TRAN_CODE)
            .dfltTranCodeRateCode(UPDATED_DFLT_TRAN_CODE_RATE_CODE)
            .defaultRateCode(UPDATED_DEFAULT_RATE_CODE)
            .croCode(UPDATED_CRO_CODE)
            .flowCode(UPDATED_FLOW_CODE)
            .extPropertyCode(UPDATED_EXT_PROPERTY_CODE)
            .opusCurrencyCode(UPDATED_OPUS_CURRENCY_CODE)
            .destinationId(UPDATED_DESTINATION_ID)
            .flags(UPDATED_FLAGS)
            .touristNumber(UPDATED_TOURIST_NUMBER)
            .cateringCurrencyCode(UPDATED_CATERING_CURRENCY_CODE)
            .defaultRatecodeRack(UPDATED_DEFAULT_RATECODE_RACK)
            .defaultRatecodePcr(UPDATED_DEFAULT_RATECODE_PCR)
            .fnsTier(UPDATED_FNS_TIER)
            .brandCode(UPDATED_BRAND_CODE)
            .webaddress(UPDATED_WEBADDRESS)
            .vatId(UPDATED_VAT_ID)
            .street(UPDATED_STREET)
            .hotelFc(UPDATED_HOTEL_FC)
            .meetingFc(UPDATED_MEETING_FC)
            .arTypewriter(UPDATED_AR_TYPEWRITER)
            .fileTransferFormat(UPDATED_FILE_TRANSFER_FORMAT)
            .confirmRegcardPrinter(UPDATED_CONFIRM_REGCARD_PRINTER)
            .directions(UPDATED_DIRECTIONS)
            .propinfoUrl(UPDATED_PROPINFO_URL)
            .roomAmenity(UPDATED_ROOM_AMENITY)
            .shopDescription(UPDATED_SHOP_DESCRIPTION)
            .propPicUrl(UPDATED_PROP_PIC_URL)
            .propMapUrl(UPDATED_PROP_MAP_URL)
            .extExpFileLocation(UPDATED_EXT_EXP_FILE_LOCATION)
            .curtainColor(UPDATED_CURTAIN_COLOR)
            .countryCode(UPDATED_COUNTRY_CODE)
            .state(UPDATED_STATE)
            .dateForAging(UPDATED_DATE_FOR_AGING)
            .regionCode(UPDATED_REGION_CODE)
            .city(UPDATED_CITY)
            .telephone(UPDATED_TELEPHONE)
            .fax(UPDATED_FAX)
            .tollfree(UPDATED_TOLLFREE)
            .defaultPrinter(UPDATED_DEFAULT_PRINTER)
            .videocheckoutPrinter(UPDATED_VIDEOCHECKOUT_PRINTER)
            .companyAddressType(UPDATED_COMPANY_ADDRESS_TYPE)
            .companyPhoneType(UPDATED_COMPANY_PHONE_TYPE)
            .defaultFaxType(UPDATED_DEFAULT_FAX_TYPE)
            .defaultMembershipType(UPDATED_DEFAULT_MEMBERSHIP_TYPE)
            .individualAddressType(UPDATED_INDIVIDUAL_ADDRESS_TYPE)
            .individualPhoneType(UPDATED_INDIVIDUAL_PHONE_TYPE)
            .notes(UPDATED_NOTES)
            .blackoutPeriodNotes(UPDATED_BLACKOUT_PERIOD_NOTES)
            .sglNum(UPDATED_SGL_NUM)
            .dblNum(UPDATED_DBL_NUM)
            .tplNum(UPDATED_TPL_NUM)
            .suiNum(UPDATED_SUI_NUM)
            .airportDistance(UPDATED_AIRPORT_DISTANCE)
            .airportTime(UPDATED_AIRPORT_TIME)
            .brArea(UPDATED_BR_AREA)
            .name(UPDATED_NAME)
            .legalOwner(UPDATED_LEGAL_OWNER)
            .hotelId(UPDATED_HOTEL_ID)
            .faxNoFormat(UPDATED_FAX_NO_FORMAT)
            .telephoneNoFormat(UPDATED_TELEPHONE_NO_FORMAT)
            .localCurrencyFormat(UPDATED_LOCAL_CURRENCY_FORMAT)
            .dutyManagerPager(UPDATED_DUTY_MANAGER_PAGER)
            .defaultRegistrationCard(UPDATED_DEFAULT_REGISTRATION_CARD)
            .nightAuditCashierId(UPDATED_NIGHT_AUDIT_CASHIER_ID)
            .hotelCode(UPDATED_HOTEL_CODE)
            .path(UPDATED_PATH)
            .timezoneRegion(UPDATED_TIMEZONE_REGION)
            .cateringCurrencyFormat(UPDATED_CATERING_CURRENCY_FORMAT)
            .expHotelCode(UPDATED_EXP_HOTEL_CODE);

        restResortMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedResort.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedResort))
            )
            .andExpect(status().isOk());

        // Validate the Resort in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertResortUpdatableFieldsEquals(partialUpdatedResort, getPersistedResort(partialUpdatedResort));
    }

    @Test
    @Transactional
    void patchNonExistingResort() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resort.setId(UUID.randomUUID().toString());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restResortMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, resort.getId()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(resort))
            )
            .andExpect(status().isBadRequest());

        // Validate the Resort in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchResort() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resort.setId(UUID.randomUUID().toString());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, UUID.randomUUID().toString())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(resort))
            )
            .andExpect(status().isBadRequest());

        // Validate the Resort in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamResort() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resort.setId(UUID.randomUUID().toString());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(resort)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Resort in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteResort() throws Exception {
        // Initialize the database
        resortRepository.saveAndFlush(resort);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the resort
        restResortMockMvc
            .perform(delete(ENTITY_API_URL_ID, resort.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return resortRepository.count();
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

    protected Resort getPersistedResort(Resort resort) {
        return resortRepository.findById(resort.getId()).orElseThrow();
    }

    protected void assertPersistedResortToMatchAllProperties(Resort expectedResort) {
        assertResortAllPropertiesEquals(expectedResort, getPersistedResort(expectedResort));
    }

    protected void assertPersistedResortToMatchUpdatableProperties(Resort expectedResort) {
        assertResortAllUpdatablePropertiesEquals(expectedResort, getPersistedResort(expectedResort));
    }
}
