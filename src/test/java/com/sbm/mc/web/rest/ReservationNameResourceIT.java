package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.ReservationNameAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.ReservationName;
import com.sbm.mc.repository.ReservationNameRepository;
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
 * Integration tests for the {@link ReservationNameResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ReservationNameResourceIT {

    private static final String DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_RESORT = "BBBBBBBBBB";

    private static final Integer DEFAULT_RESV_NAME_ID = 1;
    private static final Integer UPDATED_RESV_NAME_ID = 2;

    private static final Integer DEFAULT_NAME_ID = 1;
    private static final Integer UPDATED_NAME_ID = 2;

    private static final String DEFAULT_NAME_USAGE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_NAME_USAGE_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_CONTACT_NAME_ID = 1;
    private static final Integer UPDATED_CONTACT_NAME_ID = 2;

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_RESV_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_RESV_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_COMMISSION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMMISSION_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_ADDRESS_ID = 1;
    private static final Integer UPDATED_ADDRESS_ID = 2;

    private static final Integer DEFAULT_PHONE_ID = 1;
    private static final Integer UPDATED_PHONE_ID = 2;

    private static final String DEFAULT_FAX_YN = "AAAAAAAAAA";
    private static final String UPDATED_FAX_YN = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_YN = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_YN = "BBBBBBBBBB";

    private static final String DEFAULT_PRINT_RATE_YN = "AAAAAAAAAA";
    private static final String UPDATED_PRINT_RATE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_REPORT_ID = "AAAAAAAAAA";
    private static final String UPDATED_REPORT_ID = "BBBBBBBBBB";

    private static final Integer DEFAULT_RESV_NO = 1;
    private static final Integer UPDATED_RESV_NO = 2;

    private static final String DEFAULT_CONFIRMATION_NO = "AAAAAAAAAA";
    private static final String UPDATED_CONFIRMATION_NO = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_BEGIN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BEGIN_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_FAX_ID = 1;
    private static final Integer UPDATED_FAX_ID = 2;

    private static final Integer DEFAULT_EMAIL_ID = 1;
    private static final Integer UPDATED_EMAIL_ID = 2;

    private static final String DEFAULT_EMAIL_YN = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_YN = "BBBBBBBBBB";

    private static final String DEFAULT_CONSUMER_YN = "AAAAAAAAAA";
    private static final String UPDATED_CONSUMER_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_CREDIT_CARD_ID = 1;
    private static final Integer UPDATED_CREDIT_CARD_ID = 2;

    private static final String DEFAULT_FINANCIALLY_RESPONSIBLE_YN = "AAAAAAAAAA";
    private static final String UPDATED_FINANCIALLY_RESPONSIBLE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_PAYMENT_METHOD = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_METHOD = "BBBBBBBBBB";

    private static final String DEFAULT_INTERMEDIARY_YN = "AAAAAAAAAA";
    private static final String UPDATED_INTERMEDIARY_YN = "BBBBBBBBBB";

    private static final String DEFAULT_POSTING_ALLOWED_YN = "AAAAAAAAAA";
    private static final String UPDATED_POSTING_ALLOWED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_DISPLAY_COLOR = "AAAAAAAAAA";
    private static final String UPDATED_DISPLAY_COLOR = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_ACTUAL_CHECK_IN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ACTUAL_CHECK_IN_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRUNC_ACTUAL_CHECK_IN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRUNC_ACTUAL_CHECK_IN_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_ACTUAL_CHECK_OUT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ACTUAL_CHECK_OUT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRUNC_ACTUAL_CHECK_OUT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRUNC_ACTUAL_CHECK_OUT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_CREDIT_LIMIT = 1;
    private static final Integer UPDATED_CREDIT_LIMIT = 2;

    private static final Integer DEFAULT_AUTHORIZED_BY = 1;
    private static final Integer UPDATED_AUTHORIZED_BY = 2;

    private static final Integer DEFAULT_PARENT_RESV_NAME_ID = 1;
    private static final Integer UPDATED_PARENT_RESV_NAME_ID = 2;

    private static final String DEFAULT_CANCELLATION_NO = "AAAAAAAAAA";
    private static final String UPDATED_CANCELLATION_NO = "BBBBBBBBBB";

    private static final String DEFAULT_CANCELLATION_REASON_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CANCELLATION_REASON_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CANCELLATION_REASON_DESC = "AAAAAAAAAA";
    private static final String UPDATED_CANCELLATION_REASON_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_ARRIVAL_TRANSPORT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ARRIVAL_TRANSPORT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ARRIVAL_STATION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ARRIVAL_STATION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ARRIVAL_CARRIER_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ARRIVAL_CARRIER_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ARRIVAL_TRANSPORT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ARRIVAL_TRANSPORT_CODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_ARRIVAL_DATE_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ARRIVAL_DATE_TIME = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_ARRIVAL_ESTIMATE_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ARRIVAL_ESTIMATE_TIME = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ARRIVAL_TRANPORTATION_YN = "AAAAAAAAAA";
    private static final String UPDATED_ARRIVAL_TRANPORTATION_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ARRIVAL_COMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_ARRIVAL_COMMENTS = "BBBBBBBBBB";

    private static final String DEFAULT_DEPARTURE_TRANSPORT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTURE_TRANSPORT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DEPARTURE_STATION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTURE_STATION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DEPARTURE_CARRIER_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTURE_CARRIER_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DEPARTURE_TRANSPORT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTURE_TRANSPORT_CODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DEPARTURE_DATE_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DEPARTURE_DATE_TIME = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DEPARTURE_ESTIMATE_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DEPARTURE_ESTIMATE_TIME = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_DEPARTURE_TRANSPORTATION_YN = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTURE_TRANSPORTATION_YN = "BBBBBBBBBB";

    private static final String DEFAULT_DEPARTURE_COMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTURE_COMMENTS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CANCELLATION_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CANCELLATION_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_GUARANTEE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_GUARANTEE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_WL_REASON_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_WL_REASON_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_WL_REASON_CODE = "AAAAAAAAAA";
    private static final String UPDATED_WL_REASON_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_WL_PRIORITY = "AAAAAAAAAA";
    private static final String UPDATED_WL_PRIORITY = "BBBBBBBBBB";

    private static final String DEFAULT_DO_NOT_MOVE_ROOM = "AAAAAAAAAA";
    private static final String UPDATED_DO_NOT_MOVE_ROOM = "BBBBBBBBBB";

    private static final String DEFAULT_EXTERNAL_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_EXTERNAL_REFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_PARTY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PARTY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_WALKIN_YN = "AAAAAAAAAA";
    private static final String UPDATED_WALKIN_YN = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_ORIGINAL_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ORIGINAL_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_APPROVAL_AMOUNT_CALC_METHOD = 1;
    private static final Integer UPDATED_APPROVAL_AMOUNT_CALC_METHOD = 2;

    private static final Integer DEFAULT_AMOUNT_PERCENT = 1;
    private static final Integer UPDATED_AMOUNT_PERCENT = 2;

    private static final String DEFAULT_NAME_TAX_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_NAME_TAX_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_TAX_EXEMPT_NO = "AAAAAAAAAA";
    private static final String UPDATED_TAX_EXEMPT_NO = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_FEATURES = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_FEATURES = "BBBBBBBBBB";

    private static final String DEFAULT_WL_TELEPHONE_NO = "AAAAAAAAAA";
    private static final String UPDATED_WL_TELEPHONE_NO = "BBBBBBBBBB";

    private static final String DEFAULT_VIDEO_CHECKOUT_YN = "AAAAAAAAAA";
    private static final String UPDATED_VIDEO_CHECKOUT_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_DISCOUNT_AMT = 1;
    private static final Integer UPDATED_DISCOUNT_AMT = 2;

    private static final Integer DEFAULT_DISCOUNT_PRCNT = 1;
    private static final Integer UPDATED_DISCOUNT_PRCNT = 2;

    private static final String DEFAULT_DISCOUNT_REASON_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DISCOUNT_REASON_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_COMMISSION_PAID = 1;
    private static final Integer UPDATED_COMMISSION_PAID = 2;

    private static final String DEFAULT_COMMISSION_HOLD_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMMISSION_HOLD_CODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_TRUNC_BEGIN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRUNC_BEGIN_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRUNC_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRUNC_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_SGUEST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SGUEST_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_MEMBERSHIP_ID = 1;
    private static final Integer UPDATED_MEMBERSHIP_ID = 2;

    private static final String DEFAULT_UDFC_01 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_01 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_02 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_02 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_03 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_03 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_04 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_04 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_05 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_05 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_06 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_06 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_07 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_07 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_08 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_08 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_09 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_09 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_10 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_10 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_11 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_11 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_12 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_12 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_13 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_13 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_14 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_14 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_15 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_15 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_16 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_16 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_17 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_17 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_18 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_18 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_19 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_19 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_20 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_20 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_21 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_21 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_22 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_22 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_23 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_23 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_24 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_24 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_25 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_25 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_26 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_26 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_27 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_27 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_28 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_28 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_29 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_29 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_30 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_30 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_31 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_31 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_32 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_32 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_33 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_33 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_34 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_34 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_35 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_35 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_36 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_36 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_37 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_37 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_38 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_38 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_39 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_39 = "BBBBBBBBBB";

    private static final String DEFAULT_UDFC_40 = "AAAAAAAAAA";
    private static final String UPDATED_UDFC_40 = "BBBBBBBBBB";

    private static final Integer DEFAULT_UDFN_01 = 1;
    private static final Integer UPDATED_UDFN_01 = 2;

    private static final Integer DEFAULT_UDFN_02 = 1;
    private static final Integer UPDATED_UDFN_02 = 2;

    private static final Integer DEFAULT_UDFN_03 = 1;
    private static final Integer UPDATED_UDFN_03 = 2;

    private static final Integer DEFAULT_UDFN_04 = 1;
    private static final Integer UPDATED_UDFN_04 = 2;

    private static final Integer DEFAULT_UDFN_05 = 1;
    private static final Integer UPDATED_UDFN_05 = 2;

    private static final Integer DEFAULT_UDFN_06 = 1;
    private static final Integer UPDATED_UDFN_06 = 2;

    private static final Integer DEFAULT_UDFN_07 = 1;
    private static final Integer UPDATED_UDFN_07 = 2;

    private static final Integer DEFAULT_UDFN_08 = 1;
    private static final Integer UPDATED_UDFN_08 = 2;

    private static final Integer DEFAULT_UDFN_09 = 1;
    private static final Integer UPDATED_UDFN_09 = 2;

    private static final Integer DEFAULT_UDFN_10 = 1;
    private static final Integer UPDATED_UDFN_10 = 2;

    private static final Integer DEFAULT_UDFN_11 = 1;
    private static final Integer UPDATED_UDFN_11 = 2;

    private static final Integer DEFAULT_UDFN_12 = 1;
    private static final Integer UPDATED_UDFN_12 = 2;

    private static final Integer DEFAULT_UDFN_13 = 1;
    private static final Integer UPDATED_UDFN_13 = 2;

    private static final Integer DEFAULT_UDFN_14 = 1;
    private static final Integer UPDATED_UDFN_14 = 2;

    private static final Integer DEFAULT_UDFN_15 = 1;
    private static final Integer UPDATED_UDFN_15 = 2;

    private static final Integer DEFAULT_UDFN_16 = 1;
    private static final Integer UPDATED_UDFN_16 = 2;

    private static final Integer DEFAULT_UDFN_17 = 1;
    private static final Integer UPDATED_UDFN_17 = 2;

    private static final Integer DEFAULT_UDFN_18 = 1;
    private static final Integer UPDATED_UDFN_18 = 2;

    private static final Integer DEFAULT_UDFN_19 = 1;
    private static final Integer UPDATED_UDFN_19 = 2;

    private static final Integer DEFAULT_UDFN_20 = 1;
    private static final Integer UPDATED_UDFN_20 = 2;

    private static final Integer DEFAULT_UDFN_21 = 1;
    private static final Integer UPDATED_UDFN_21 = 2;

    private static final Integer DEFAULT_UDFN_22 = 1;
    private static final Integer UPDATED_UDFN_22 = 2;

    private static final Integer DEFAULT_UDFN_23 = 1;
    private static final Integer UPDATED_UDFN_23 = 2;

    private static final Integer DEFAULT_UDFN_24 = 1;
    private static final Integer UPDATED_UDFN_24 = 2;

    private static final Integer DEFAULT_UDFN_25 = 1;
    private static final Integer UPDATED_UDFN_25 = 2;

    private static final Integer DEFAULT_UDFN_26 = 1;
    private static final Integer UPDATED_UDFN_26 = 2;

    private static final Integer DEFAULT_UDFN_27 = 1;
    private static final Integer UPDATED_UDFN_27 = 2;

    private static final Integer DEFAULT_UDFN_28 = 1;
    private static final Integer UPDATED_UDFN_28 = 2;

    private static final Integer DEFAULT_UDFN_29 = 1;
    private static final Integer UPDATED_UDFN_29 = 2;

    private static final Integer DEFAULT_UDFN_30 = 1;
    private static final Integer UPDATED_UDFN_30 = 2;

    private static final Integer DEFAULT_UDFN_31 = 1;
    private static final Integer UPDATED_UDFN_31 = 2;

    private static final Integer DEFAULT_UDFN_32 = 1;
    private static final Integer UPDATED_UDFN_32 = 2;

    private static final Integer DEFAULT_UDFN_33 = 1;
    private static final Integer UPDATED_UDFN_33 = 2;

    private static final Integer DEFAULT_UDFN_34 = 1;
    private static final Integer UPDATED_UDFN_34 = 2;

    private static final Integer DEFAULT_UDFN_35 = 1;
    private static final Integer UPDATED_UDFN_35 = 2;

    private static final Integer DEFAULT_UDFN_36 = 1;
    private static final Integer UPDATED_UDFN_36 = 2;

    private static final Integer DEFAULT_UDFN_37 = 1;
    private static final Integer UPDATED_UDFN_37 = 2;

    private static final Integer DEFAULT_UDFN_38 = 1;
    private static final Integer UPDATED_UDFN_38 = 2;

    private static final Integer DEFAULT_UDFN_39 = 1;
    private static final Integer UPDATED_UDFN_39 = 2;

    private static final Integer DEFAULT_UDFN_40 = 1;
    private static final Integer UPDATED_UDFN_40 = 2;

    private static final LocalDate DEFAULT_UDFD_01 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_01 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_02 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_02 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_03 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_03 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_04 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_04 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_05 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_05 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_06 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_06 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_07 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_07 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_08 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_08 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_09 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_09 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_10 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_10 = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_INSERT_ACTION_INSTANCE_ID = 1;
    private static final Integer UPDATED_INSERT_ACTION_INSTANCE_ID = 2;

    private static final Integer DEFAULT_DML_SEQ_NO = 1;
    private static final Integer UPDATED_DML_SEQ_NO = 2;

    private static final LocalDate DEFAULT_BUSINESS_DATE_CREATED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BUSINESS_DATE_CREATED = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_TURNDOWN_YN = "AAAAAAAAAA";
    private static final String UPDATED_TURNDOWN_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_INSTRUCTIONS = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_INSTRUCTIONS = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_SERVICE_TIME = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_SERVICE_TIME = "BBBBBBBBBB";

    private static final Integer DEFAULT_EVENT_ID = 1;
    private static final Integer UPDATED_EVENT_ID = 2;

    private static final String DEFAULT_REVENUE_TYPE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_REVENUE_TYPE_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_HURDLE = 1;
    private static final Integer UPDATED_HURDLE = 2;

    private static final String DEFAULT_HURDLE_OVERRIDE = "AAAAAAAAAA";
    private static final String UPDATED_HURDLE_OVERRIDE = "BBBBBBBBBB";

    private static final Integer DEFAULT_RATEABLE_VALUE = 1;
    private static final Integer UPDATED_RATEABLE_VALUE = 2;

    private static final String DEFAULT_RESTRICTION_OVERRIDE = "AAAAAAAAAA";
    private static final String UPDATED_RESTRICTION_OVERRIDE = "BBBBBBBBBB";

    private static final String DEFAULT_YIELDABLE_YN = "AAAAAAAAAA";
    private static final String UPDATED_YIELDABLE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_SGUEST_FIRSTNAME = "AAAAAAAAAA";
    private static final String UPDATED_SGUEST_FIRSTNAME = "BBBBBBBBBB";

    private static final String DEFAULT_GUEST_LAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_GUEST_LAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_GUEST_FIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_GUEST_FIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_GUEST_LAST_NAME_SDX = "AAAAAAAAAA";
    private static final String UPDATED_GUEST_LAST_NAME_SDX = "BBBBBBBBBB";

    private static final String DEFAULT_GUEST_FIRST_NAME_SDX = "AAAAAAAAAA";
    private static final String UPDATED_GUEST_FIRST_NAME_SDX = "BBBBBBBBBB";

    private static final String DEFAULT_CHANNEL = "AAAAAAAAAA";
    private static final String UPDATED_CHANNEL = "BBBBBBBBBB";

    private static final Integer DEFAULT_SHARE_SEQ_NO = 1;
    private static final Integer UPDATED_SHARE_SEQ_NO = 2;

    private static final String DEFAULT_GUEST_SIGNATURE = "AAAAAAAAAA";
    private static final String UPDATED_GUEST_SIGNATURE = "BBBBBBBBBB";

    private static final Integer DEFAULT_EXTENSION_ID = 1;
    private static final Integer UPDATED_EXTENSION_ID = 2;

    private static final Integer DEFAULT_RESV_CONTACT_ID = 1;
    private static final Integer UPDATED_RESV_CONTACT_ID = 2;

    private static final Integer DEFAULT_BILLING_CONTACT_ID = 1;
    private static final Integer UPDATED_BILLING_CONTACT_ID = 2;

    private static final String DEFAULT_RES_INSERT_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_RES_INSERT_SOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_RES_INSERT_SOURCE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_RES_INSERT_SOURCE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_MASTER_SHARE = "AAAAAAAAAA";
    private static final String UPDATED_MASTER_SHARE = "BBBBBBBBBB";

    private static final String DEFAULT_REGISTRATION_CARD_NO = "AAAAAAAAAA";
    private static final String UPDATED_REGISTRATION_CARD_NO = "BBBBBBBBBB";

    private static final String DEFAULT_TIAD = "AAAAAAAAAA";
    private static final String UPDATED_TIAD = "BBBBBBBBBB";

    private static final String DEFAULT_PURPOSE_OF_STAY = "AAAAAAAAAA";
    private static final String UPDATED_PURPOSE_OF_STAY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_REINSTATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_REINSTATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_PURGE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PURGE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_LAST_SETTLE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LAST_SETTLE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_LAST_PERIODIC_FOLIO_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LAST_PERIODIC_FOLIO_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_PERIODIC_FOLIO_FREQ = 1;
    private static final Integer UPDATED_PERIODIC_FOLIO_FREQ = 2;

    private static final Integer DEFAULT_CONFIRMATION_LEG_NO = 1;
    private static final Integer UPDATED_CONFIRMATION_LEG_NO = 2;

    private static final String DEFAULT_GUEST_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_GUEST_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_GUEST_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_GUEST_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_CHECKIN_DURATION = 1;
    private static final Integer UPDATED_CHECKIN_DURATION = 2;

    private static final Integer DEFAULT_AUTHORIZER_ID = 1;
    private static final Integer UPDATED_AUTHORIZER_ID = 2;

    private static final Integer DEFAULT_LAST_ONLINE_PRINT_SEQ = 1;
    private static final Integer UPDATED_LAST_ONLINE_PRINT_SEQ = 2;

    private static final String DEFAULT_ENTRY_POINT = "AAAAAAAAAA";
    private static final String UPDATED_ENTRY_POINT = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_ENTRY_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ENTRY_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_PSEUDO_MEM_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PSEUDO_MEM_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_PSEUDO_MEM_TOTAL_POINTS = 1;
    private static final Integer UPDATED_PSEUDO_MEM_TOTAL_POINTS = 2;

    private static final String DEFAULT_FOLIO_TEXT_1 = "AAAAAAAAAA";
    private static final String UPDATED_FOLIO_TEXT_1 = "BBBBBBBBBB";

    private static final String DEFAULT_FOLIO_TEXT_2 = "AAAAAAAAAA";
    private static final String UPDATED_FOLIO_TEXT_2 = "BBBBBBBBBB";

    private static final String DEFAULT_COMP_TYPE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMP_TYPE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_UNI_CARD_ID = "AAAAAAAAAA";
    private static final String UPDATED_UNI_CARD_ID = "BBBBBBBBBB";

    private static final Integer DEFAULT_EXP_CHECKINRES_ID = 1;
    private static final Integer UPDATED_EXP_CHECKINRES_ID = 2;

    private static final LocalDate DEFAULT_ORIGINAL_BEGIN_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ORIGINAL_BEGIN_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_OWNER_FF_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_OWNER_FF_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_COMMISSION_PAYOUT_TO = "AAAAAAAAAA";
    private static final String UPDATED_COMMISSION_PAYOUT_TO = "BBBBBBBBBB";

    private static final String DEFAULT_PRE_CHARGING_YN = "AAAAAAAAAA";
    private static final String UPDATED_PRE_CHARGING_YN = "BBBBBBBBBB";

    private static final String DEFAULT_POST_CHARGING_YN = "AAAAAAAAAA";
    private static final String UPDATED_POST_CHARGING_YN = "BBBBBBBBBB";

    private static final String DEFAULT_POST_CO_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_POST_CO_FLAG = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_FOLIO_CLOSE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FOLIO_CLOSE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_SCHEDULE_CHECKOUT_YN = "AAAAAAAAAA";
    private static final String UPDATED_SCHEDULE_CHECKOUT_YN = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOM_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOM_REFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_GUARANTEE_CODE_PRE_CI = "AAAAAAAAAA";
    private static final String UPDATED_GUARANTEE_CODE_PRE_CI = "BBBBBBBBBB";

    private static final Integer DEFAULT_AWARD_MEMBERSHIP_ID = 1;
    private static final Integer UPDATED_AWARD_MEMBERSHIP_ID = 2;

    private static final String DEFAULT_ESIGNED_REG_CARD_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ESIGNED_REG_CARD_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_STATISTICAL_ROOM_TYPE = 1;
    private static final Integer UPDATED_STATISTICAL_ROOM_TYPE = 2;

    private static final Integer DEFAULT_STATISTICAL_RATE_TIER = 1;
    private static final Integer UPDATED_STATISTICAL_RATE_TIER = 2;

    private static final String DEFAULT_YM_CODE = "AAAAAAAAAA";
    private static final String UPDATED_YM_CODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_KEY_VALID_UNTIL = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_KEY_VALID_UNTIL = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_PRE_REGISTERED_YN = "AAAAAAAAAA";
    private static final String UPDATED_PRE_REGISTERED_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_TAX_REGISTRATION_NO = 1;
    private static final Integer UPDATED_TAX_REGISTRATION_NO = 2;

    private static final String DEFAULT_VISA_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_VISA_NUMBER = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_VISA_ISSUE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VISA_ISSUE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_VISA_EXPIRATION_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VISA_EXPIRATION_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_TAX_NO_OF_STAYS = 1;
    private static final Integer UPDATED_TAX_NO_OF_STAYS = 2;

    private static final String DEFAULT_ASB_PRORATED_YN = "AAAAAAAAAA";
    private static final String UPDATED_ASB_PRORATED_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_AUTO_SETTLE_DAYS = 1;
    private static final Integer UPDATED_AUTO_SETTLE_DAYS = 2;

    private static final String DEFAULT_AUTO_SETTLE_YN = "AAAAAAAAAA";
    private static final String UPDATED_AUTO_SETTLE_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_SPLIT_FROM_RESV_NAME_ID = 1;
    private static final Integer UPDATED_SPLIT_FROM_RESV_NAME_ID = 2;

    private static final String DEFAULT_NEXT_DESTINATION = "AAAAAAAAAA";
    private static final String UPDATED_NEXT_DESTINATION = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_OF_ARRIVAL_IN_COUNTRY = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_OF_ARRIVAL_IN_COUNTRY = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_PRE_ARR_REVIEWED_DT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PRE_ARR_REVIEWED_DT = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_PRE_ARR_REVIEWED_USER = 1;
    private static final Integer UPDATED_PRE_ARR_REVIEWED_USER = 2;

    private static final Integer DEFAULT_BONUS_CHECK_ID = 1;
    private static final Integer UPDATED_BONUS_CHECK_ID = 2;

    private static final String DEFAULT_MOBILE_AUDIO_KEY_YN = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_AUDIO_KEY_YN = "BBBBBBBBBB";

    private static final String DEFAULT_DIRECT_BILL_VERIFY_RESPONSE = "AAAAAAAAAA";
    private static final String UPDATED_DIRECT_BILL_VERIFY_RESPONSE = "BBBBBBBBBB";

    private static final Integer DEFAULT_ADDRESSEE_NAME_ID = 1;
    private static final Integer UPDATED_ADDRESSEE_NAME_ID = 2;

    private static final String DEFAULT_SUPER_SEARCH_INDEX_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_SUPER_SEARCH_INDEX_TEXT = "BBBBBBBBBB";

    private static final String DEFAULT_AUTO_CHECKIN_YN = "AAAAAAAAAA";
    private static final String UPDATED_AUTO_CHECKIN_YN = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_FOLIO_YN = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_FOLIO_YN = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_SPG_UPGRADE_CONFIRMED_ROOMTYPE = "AAAAAAAAAA";
    private static final String UPDATED_SPG_UPGRADE_CONFIRMED_ROOMTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SPG_UPGRADE_REASON_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SPG_UPGRADE_REASON_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SPG_SUITE_NIGHT_AWARD_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_SPG_SUITE_NIGHT_AWARD_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_SPG_DISCLOSE_ROOM_TYPE_YN = "AAAAAAAAAA";
    private static final String UPDATED_SPG_DISCLOSE_ROOM_TYPE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_AMENITY_ELIGIBLE_YN = "AAAAAAAAAA";
    private static final String UPDATED_AMENITY_ELIGIBLE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_AMENITY_LEVEL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_AMENITY_LEVEL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_BASE_RATE_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_BASE_RATE_CURRENCY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_BASE_RATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_BASE_RATE_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_LOCAL_BASE_RATE_AMOUNT = 1;
    private static final Integer UPDATED_LOCAL_BASE_RATE_AMOUNT = 2;

    private static final String DEFAULT_PHONE_DISPLAY_NAME_YN = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_DISPLAY_NAME_YN = "BBBBBBBBBB";

    private static final String DEFAULT_RESORT_CHARGE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_RESORT_CHARGE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_CHKOUT_ALLOWED = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_CHKOUT_ALLOWED = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_VIEW_FOLIO_ALLOWED = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_VIEW_FOLIO_ALLOWED = "BBBBBBBBBB";

    private static final String DEFAULT_HK_EXPECTED_SERVICE_TIME = "AAAAAAAAAA";
    private static final String UPDATED_HK_EXPECTED_SERVICE_TIME = "BBBBBBBBBB";

    private static final String DEFAULT_ELIGIBLE_FOR_UPGRADE_YN = "AAAAAAAAAA";
    private static final String UPDATED_ELIGIBLE_FOR_UPGRADE_YN = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_BEGIN_SYSTEM_DATE_TIME = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BEGIN_SYSTEM_DATE_TIME = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_MOBILE_CHECKIN_ALLOWED_YN = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_CHECKIN_ALLOWED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_QUOTE_ID = "AAAAAAAAAA";
    private static final String UPDATED_QUOTE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_MANUAL_CHECKOUT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_MANUAL_CHECKOUT_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_PREFERRED_CURRENCY = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_PREFERRED_CURRENCY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_MOBILE_ACTION_ALERT_ISSUED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_MOBILE_ACTION_ALERT_ISSUED = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_EXTERNAL_EFOLIO_YN = "AAAAAAAAAA";
    private static final String UPDATED_EXTERNAL_EFOLIO_YN = "BBBBBBBBBB";

    private static final String DEFAULT_OPT_IN_BATCH_FOL_YN = "AAAAAAAAAA";
    private static final String UPDATED_OPT_IN_BATCH_FOL_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_FOLIO_ADDR_ELEMENT_ID = 1;
    private static final Integer UPDATED_FOLIO_ADDR_ELEMENT_ID = 2;

    private static final String DEFAULT_OPERA_ESIGNED_REG_CARD_YN = "AAAAAAAAAA";
    private static final String UPDATED_OPERA_ESIGNED_REG_CARD_YN = "BBBBBBBBBB";

    private static final String DEFAULT_RESV_GUID = "AAAAAAAAAA";
    private static final String UPDATED_RESV_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_ADVANCE_CHECKED_IN_YN = "AAAAAAAAAA";
    private static final String UPDATED_ADVANCE_CHECKED_IN_YN = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_EXPECTED_TIME_OF_RETURN = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EXPECTED_TIME_OF_RETURN = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ETR_COMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_ETR_COMMENTS = "BBBBBBBBBB";

    private static final String DEFAULT_OPTED_FOR_COMM_YN = "AAAAAAAAAA";
    private static final String UPDATED_OPTED_FOR_COMM_YN = "BBBBBBBBBB";

    private static final String DEFAULT_CREDIT_LIMIT_AUTO_PAY_ALLOW_YN = "AAAAAAAAAA";
    private static final String UPDATED_CREDIT_LIMIT_AUTO_PAY_ALLOW_YN = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/reservation-names";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ReservationNameRepository reservationNameRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restReservationNameMockMvc;

    private ReservationName reservationName;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReservationName createEntity(EntityManager em) {
        ReservationName reservationName = new ReservationName()
            .resort(DEFAULT_RESORT)
            .resvNameId(DEFAULT_RESV_NAME_ID)
            .nameId(DEFAULT_NAME_ID)
            .nameUsageType(DEFAULT_NAME_USAGE_TYPE)
            .contactNameId(DEFAULT_CONTACT_NAME_ID)
            .insertDate(DEFAULT_INSERT_DATE)
            .insertUser(DEFAULT_INSERT_USER)
            .updateUser(DEFAULT_UPDATE_USER)
            .updateDate(DEFAULT_UPDATE_DATE)
            .resvStatus(DEFAULT_RESV_STATUS)
            .commissionCode(DEFAULT_COMMISSION_CODE)
            .addressId(DEFAULT_ADDRESS_ID)
            .phoneId(DEFAULT_PHONE_ID)
            .faxYn(DEFAULT_FAX_YN)
            .mailYn(DEFAULT_MAIL_YN)
            .printRateYn(DEFAULT_PRINT_RATE_YN)
            .reportId(DEFAULT_REPORT_ID)
            .resvNo(DEFAULT_RESV_NO)
            .confirmationNo(DEFAULT_CONFIRMATION_NO)
            .beginDate(DEFAULT_BEGIN_DATE)
            .endDate(DEFAULT_END_DATE)
            .faxId(DEFAULT_FAX_ID)
            .emailId(DEFAULT_EMAIL_ID)
            .emailYn(DEFAULT_EMAIL_YN)
            .consumerYn(DEFAULT_CONSUMER_YN)
            .creditCardId(DEFAULT_CREDIT_CARD_ID)
            .financiallyResponsibleYn(DEFAULT_FINANCIALLY_RESPONSIBLE_YN)
            .paymentMethod(DEFAULT_PAYMENT_METHOD)
            .intermediaryYn(DEFAULT_INTERMEDIARY_YN)
            .postingAllowedYn(DEFAULT_POSTING_ALLOWED_YN)
            .displayColor(DEFAULT_DISPLAY_COLOR)
            .actualCheckInDate(DEFAULT_ACTUAL_CHECK_IN_DATE)
            .truncActualCheckInDate(DEFAULT_TRUNC_ACTUAL_CHECK_IN_DATE)
            .actualCheckOutDate(DEFAULT_ACTUAL_CHECK_OUT_DATE)
            .truncActualCheckOutDate(DEFAULT_TRUNC_ACTUAL_CHECK_OUT_DATE)
            .creditLimit(DEFAULT_CREDIT_LIMIT)
            .authorizedBy(DEFAULT_AUTHORIZED_BY)
            .parentResvNameId(DEFAULT_PARENT_RESV_NAME_ID)
            .cancellationNo(DEFAULT_CANCELLATION_NO)
            .cancellationReasonCode(DEFAULT_CANCELLATION_REASON_CODE)
            .cancellationReasonDesc(DEFAULT_CANCELLATION_REASON_DESC)
            .arrivalTransportType(DEFAULT_ARRIVAL_TRANSPORT_TYPE)
            .arrivalStationCode(DEFAULT_ARRIVAL_STATION_CODE)
            .arrivalCarrierCode(DEFAULT_ARRIVAL_CARRIER_CODE)
            .arrivalTransportCode(DEFAULT_ARRIVAL_TRANSPORT_CODE)
            .arrivalDateTime(DEFAULT_ARRIVAL_DATE_TIME)
            .arrivalEstimateTime(DEFAULT_ARRIVAL_ESTIMATE_TIME)
            .arrivalTranportationYn(DEFAULT_ARRIVAL_TRANPORTATION_YN)
            .arrivalComments(DEFAULT_ARRIVAL_COMMENTS)
            .departureTransportType(DEFAULT_DEPARTURE_TRANSPORT_TYPE)
            .departureStationCode(DEFAULT_DEPARTURE_STATION_CODE)
            .departureCarrierCode(DEFAULT_DEPARTURE_CARRIER_CODE)
            .departureTransportCode(DEFAULT_DEPARTURE_TRANSPORT_CODE)
            .departureDateTime(DEFAULT_DEPARTURE_DATE_TIME)
            .departureEstimateTime(DEFAULT_DEPARTURE_ESTIMATE_TIME)
            .departureTransportationYn(DEFAULT_DEPARTURE_TRANSPORTATION_YN)
            .departureComments(DEFAULT_DEPARTURE_COMMENTS)
            .cancellationDate(DEFAULT_CANCELLATION_DATE)
            .guaranteeCode(DEFAULT_GUARANTEE_CODE)
            .wlReasonDescription(DEFAULT_WL_REASON_DESCRIPTION)
            .wlReasonCode(DEFAULT_WL_REASON_CODE)
            .wlPriority(DEFAULT_WL_PRIORITY)
            .doNotMoveRoom(DEFAULT_DO_NOT_MOVE_ROOM)
            .externalReference(DEFAULT_EXTERNAL_REFERENCE)
            .partyCode(DEFAULT_PARTY_CODE)
            .walkinYn(DEFAULT_WALKIN_YN)
            .originalEndDate(DEFAULT_ORIGINAL_END_DATE)
            .approvalAmountCalcMethod(DEFAULT_APPROVAL_AMOUNT_CALC_METHOD)
            .amountPercent(DEFAULT_AMOUNT_PERCENT)
            .nameTaxType(DEFAULT_NAME_TAX_TYPE)
            .taxExemptNo(DEFAULT_TAX_EXEMPT_NO)
            .roomFeatures(DEFAULT_ROOM_FEATURES)
            .wlTelephoneNo(DEFAULT_WL_TELEPHONE_NO)
            .videoCheckoutYn(DEFAULT_VIDEO_CHECKOUT_YN)
            .discountAmt(DEFAULT_DISCOUNT_AMT)
            .discountPrcnt(DEFAULT_DISCOUNT_PRCNT)
            .discountReasonCode(DEFAULT_DISCOUNT_REASON_CODE)
            .commissionPaid(DEFAULT_COMMISSION_PAID)
            .commissionHoldCode(DEFAULT_COMMISSION_HOLD_CODE)
            .truncBeginDate(DEFAULT_TRUNC_BEGIN_DATE)
            .truncEndDate(DEFAULT_TRUNC_END_DATE)
            .sguestName(DEFAULT_SGUEST_NAME)
            .membershipId(DEFAULT_MEMBERSHIP_ID)
            .udfc01(DEFAULT_UDFC_01)
            .udfc02(DEFAULT_UDFC_02)
            .udfc03(DEFAULT_UDFC_03)
            .udfc04(DEFAULT_UDFC_04)
            .udfc05(DEFAULT_UDFC_05)
            .udfc06(DEFAULT_UDFC_06)
            .udfc07(DEFAULT_UDFC_07)
            .udfc08(DEFAULT_UDFC_08)
            .udfc09(DEFAULT_UDFC_09)
            .udfc10(DEFAULT_UDFC_10)
            .udfc11(DEFAULT_UDFC_11)
            .udfc12(DEFAULT_UDFC_12)
            .udfc13(DEFAULT_UDFC_13)
            .udfc14(DEFAULT_UDFC_14)
            .udfc15(DEFAULT_UDFC_15)
            .udfc16(DEFAULT_UDFC_16)
            .udfc17(DEFAULT_UDFC_17)
            .udfc18(DEFAULT_UDFC_18)
            .udfc19(DEFAULT_UDFC_19)
            .udfc20(DEFAULT_UDFC_20)
            .udfc21(DEFAULT_UDFC_21)
            .udfc22(DEFAULT_UDFC_22)
            .udfc23(DEFAULT_UDFC_23)
            .udfc24(DEFAULT_UDFC_24)
            .udfc25(DEFAULT_UDFC_25)
            .udfc26(DEFAULT_UDFC_26)
            .udfc27(DEFAULT_UDFC_27)
            .udfc28(DEFAULT_UDFC_28)
            .udfc29(DEFAULT_UDFC_29)
            .udfc30(DEFAULT_UDFC_30)
            .udfc31(DEFAULT_UDFC_31)
            .udfc32(DEFAULT_UDFC_32)
            .udfc33(DEFAULT_UDFC_33)
            .udfc34(DEFAULT_UDFC_34)
            .udfc35(DEFAULT_UDFC_35)
            .udfc36(DEFAULT_UDFC_36)
            .udfc37(DEFAULT_UDFC_37)
            .udfc38(DEFAULT_UDFC_38)
            .udfc39(DEFAULT_UDFC_39)
            .udfc40(DEFAULT_UDFC_40)
            .udfn01(DEFAULT_UDFN_01)
            .udfn02(DEFAULT_UDFN_02)
            .udfn03(DEFAULT_UDFN_03)
            .udfn04(DEFAULT_UDFN_04)
            .udfn05(DEFAULT_UDFN_05)
            .udfn06(DEFAULT_UDFN_06)
            .udfn07(DEFAULT_UDFN_07)
            .udfn08(DEFAULT_UDFN_08)
            .udfn09(DEFAULT_UDFN_09)
            .udfn10(DEFAULT_UDFN_10)
            .udfn11(DEFAULT_UDFN_11)
            .udfn12(DEFAULT_UDFN_12)
            .udfn13(DEFAULT_UDFN_13)
            .udfn14(DEFAULT_UDFN_14)
            .udfn15(DEFAULT_UDFN_15)
            .udfn16(DEFAULT_UDFN_16)
            .udfn17(DEFAULT_UDFN_17)
            .udfn18(DEFAULT_UDFN_18)
            .udfn19(DEFAULT_UDFN_19)
            .udfn20(DEFAULT_UDFN_20)
            .udfn21(DEFAULT_UDFN_21)
            .udfn22(DEFAULT_UDFN_22)
            .udfn23(DEFAULT_UDFN_23)
            .udfn24(DEFAULT_UDFN_24)
            .udfn25(DEFAULT_UDFN_25)
            .udfn26(DEFAULT_UDFN_26)
            .udfn27(DEFAULT_UDFN_27)
            .udfn28(DEFAULT_UDFN_28)
            .udfn29(DEFAULT_UDFN_29)
            .udfn30(DEFAULT_UDFN_30)
            .udfn31(DEFAULT_UDFN_31)
            .udfn32(DEFAULT_UDFN_32)
            .udfn33(DEFAULT_UDFN_33)
            .udfn34(DEFAULT_UDFN_34)
            .udfn35(DEFAULT_UDFN_35)
            .udfn36(DEFAULT_UDFN_36)
            .udfn37(DEFAULT_UDFN_37)
            .udfn38(DEFAULT_UDFN_38)
            .udfn39(DEFAULT_UDFN_39)
            .udfn40(DEFAULT_UDFN_40)
            .udfd01(DEFAULT_UDFD_01)
            .udfd02(DEFAULT_UDFD_02)
            .udfd03(DEFAULT_UDFD_03)
            .udfd04(DEFAULT_UDFD_04)
            .udfd05(DEFAULT_UDFD_05)
            .udfd06(DEFAULT_UDFD_06)
            .udfd07(DEFAULT_UDFD_07)
            .udfd08(DEFAULT_UDFD_08)
            .udfd09(DEFAULT_UDFD_09)
            .udfd10(DEFAULT_UDFD_10)
            .insertActionInstanceId(DEFAULT_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(DEFAULT_DML_SEQ_NO)
            .businessDateCreated(DEFAULT_BUSINESS_DATE_CREATED)
            .turndownYn(DEFAULT_TURNDOWN_YN)
            .roomInstructions(DEFAULT_ROOM_INSTRUCTIONS)
            .roomServiceTime(DEFAULT_ROOM_SERVICE_TIME)
            .eventId(DEFAULT_EVENT_ID)
            .revenueTypeCode(DEFAULT_REVENUE_TYPE_CODE)
            .hurdle(DEFAULT_HURDLE)
            .hurdleOverride(DEFAULT_HURDLE_OVERRIDE)
            .rateableValue(DEFAULT_RATEABLE_VALUE)
            .restrictionOverride(DEFAULT_RESTRICTION_OVERRIDE)
            .yieldableYn(DEFAULT_YIELDABLE_YN)
            .sguestFirstname(DEFAULT_SGUEST_FIRSTNAME)
            .guestLastName(DEFAULT_GUEST_LAST_NAME)
            .guestFirstName(DEFAULT_GUEST_FIRST_NAME)
            .guestLastNameSdx(DEFAULT_GUEST_LAST_NAME_SDX)
            .guestFirstNameSdx(DEFAULT_GUEST_FIRST_NAME_SDX)
            .channel(DEFAULT_CHANNEL)
            .shareSeqNo(DEFAULT_SHARE_SEQ_NO)
            .guestSignature(DEFAULT_GUEST_SIGNATURE)
            .extensionId(DEFAULT_EXTENSION_ID)
            .resvContactId(DEFAULT_RESV_CONTACT_ID)
            .billingContactId(DEFAULT_BILLING_CONTACT_ID)
            .resInsertSource(DEFAULT_RES_INSERT_SOURCE)
            .resInsertSourceType(DEFAULT_RES_INSERT_SOURCE_TYPE)
            .masterShare(DEFAULT_MASTER_SHARE)
            .registrationCardNo(DEFAULT_REGISTRATION_CARD_NO)
            .tiad(DEFAULT_TIAD)
            .purposeOfStay(DEFAULT_PURPOSE_OF_STAY)
            .reinstateDate(DEFAULT_REINSTATE_DATE)
            .purgeDate(DEFAULT_PURGE_DATE)
            .lastSettleDate(DEFAULT_LAST_SETTLE_DATE)
            .lastPeriodicFolioDate(DEFAULT_LAST_PERIODIC_FOLIO_DATE)
            .periodicFolioFreq(DEFAULT_PERIODIC_FOLIO_FREQ)
            .confirmationLegNo(DEFAULT_CONFIRMATION_LEG_NO)
            .guestStatus(DEFAULT_GUEST_STATUS)
            .guestType(DEFAULT_GUEST_TYPE)
            .checkinDuration(DEFAULT_CHECKIN_DURATION)
            .authorizerId(DEFAULT_AUTHORIZER_ID)
            .lastOnlinePrintSeq(DEFAULT_LAST_ONLINE_PRINT_SEQ)
            .entryPoint(DEFAULT_ENTRY_POINT)
            .entryDate(DEFAULT_ENTRY_DATE)
            .pseudoMemType(DEFAULT_PSEUDO_MEM_TYPE)
            .pseudoMemTotalPoints(DEFAULT_PSEUDO_MEM_TOTAL_POINTS)
            .folioText1(DEFAULT_FOLIO_TEXT_1)
            .folioText2(DEFAULT_FOLIO_TEXT_2)
            .compTypeCode(DEFAULT_COMP_TYPE_CODE)
            .uniCardId(DEFAULT_UNI_CARD_ID)
            .expCheckinresId(DEFAULT_EXP_CHECKINRES_ID)
            .originalBeginDate(DEFAULT_ORIGINAL_BEGIN_DATE)
            .ownerFfFlag(DEFAULT_OWNER_FF_FLAG)
            .commissionPayoutTo(DEFAULT_COMMISSION_PAYOUT_TO)
            .preChargingYn(DEFAULT_PRE_CHARGING_YN)
            .postChargingYn(DEFAULT_POST_CHARGING_YN)
            .postCoFlag(DEFAULT_POST_CO_FLAG)
            .folioCloseDate(DEFAULT_FOLIO_CLOSE_DATE)
            .scheduleCheckoutYn(DEFAULT_SCHEDULE_CHECKOUT_YN)
            .customReference(DEFAULT_CUSTOM_REFERENCE)
            .guaranteeCodePreCi(DEFAULT_GUARANTEE_CODE_PRE_CI)
            .awardMembershipId(DEFAULT_AWARD_MEMBERSHIP_ID)
            .esignedRegCardName(DEFAULT_ESIGNED_REG_CARD_NAME)
            .statisticalRoomType(DEFAULT_STATISTICAL_ROOM_TYPE)
            .statisticalRateTier(DEFAULT_STATISTICAL_RATE_TIER)
            .ymCode(DEFAULT_YM_CODE)
            .keyValidUntil(DEFAULT_KEY_VALID_UNTIL)
            .preRegisteredYn(DEFAULT_PRE_REGISTERED_YN)
            .taxRegistrationNo(DEFAULT_TAX_REGISTRATION_NO)
            .visaNumber(DEFAULT_VISA_NUMBER)
            .visaIssueDate(DEFAULT_VISA_ISSUE_DATE)
            .visaExpirationDate(DEFAULT_VISA_EXPIRATION_DATE)
            .taxNoOfStays(DEFAULT_TAX_NO_OF_STAYS)
            .asbProratedYn(DEFAULT_ASB_PRORATED_YN)
            .autoSettleDays(DEFAULT_AUTO_SETTLE_DAYS)
            .autoSettleYn(DEFAULT_AUTO_SETTLE_YN)
            .splitFromResvNameId(DEFAULT_SPLIT_FROM_RESV_NAME_ID)
            .nextDestination(DEFAULT_NEXT_DESTINATION)
            .dateOfArrivalInCountry(DEFAULT_DATE_OF_ARRIVAL_IN_COUNTRY)
            .preArrReviewedDt(DEFAULT_PRE_ARR_REVIEWED_DT)
            .preArrReviewedUser(DEFAULT_PRE_ARR_REVIEWED_USER)
            .bonusCheckId(DEFAULT_BONUS_CHECK_ID)
            .mobileAudioKeyYn(DEFAULT_MOBILE_AUDIO_KEY_YN)
            .directBillVerifyResponse(DEFAULT_DIRECT_BILL_VERIFY_RESPONSE)
            .addresseeNameId(DEFAULT_ADDRESSEE_NAME_ID)
            .superSearchIndexText(DEFAULT_SUPER_SEARCH_INDEX_TEXT)
            .autoCheckinYn(DEFAULT_AUTO_CHECKIN_YN)
            .emailFolioYn(DEFAULT_EMAIL_FOLIO_YN)
            .emailAddress(DEFAULT_EMAIL_ADDRESS)
            .spgUpgradeConfirmedRoomtype(DEFAULT_SPG_UPGRADE_CONFIRMED_ROOMTYPE)
            .spgUpgradeReasonCode(DEFAULT_SPG_UPGRADE_REASON_CODE)
            .spgSuiteNightAwardStatus(DEFAULT_SPG_SUITE_NIGHT_AWARD_STATUS)
            .spgDiscloseRoomTypeYn(DEFAULT_SPG_DISCLOSE_ROOM_TYPE_YN)
            .amenityEligibleYn(DEFAULT_AMENITY_ELIGIBLE_YN)
            .amenityLevelCode(DEFAULT_AMENITY_LEVEL_CODE)
            .baseRateCurrencyCode(DEFAULT_BASE_RATE_CURRENCY_CODE)
            .baseRateCode(DEFAULT_BASE_RATE_CODE)
            .localBaseRateAmount(DEFAULT_LOCAL_BASE_RATE_AMOUNT)
            .phoneDisplayNameYn(DEFAULT_PHONE_DISPLAY_NAME_YN)
            .resortChargeNumber(DEFAULT_RESORT_CHARGE_NUMBER)
            .mobileChkoutAllowed(DEFAULT_MOBILE_CHKOUT_ALLOWED)
            .mobileViewFolioAllowed(DEFAULT_MOBILE_VIEW_FOLIO_ALLOWED)
            .hkExpectedServiceTime(DEFAULT_HK_EXPECTED_SERVICE_TIME)
            .eligibleForUpgradeYn(DEFAULT_ELIGIBLE_FOR_UPGRADE_YN)
            .beginSystemDateTime(DEFAULT_BEGIN_SYSTEM_DATE_TIME)
            .mobileCheckinAllowedYn(DEFAULT_MOBILE_CHECKIN_ALLOWED_YN)
            .quoteId(DEFAULT_QUOTE_ID)
            .manualCheckoutStatus(DEFAULT_MANUAL_CHECKOUT_STATUS)
            .mobilePreferredCurrency(DEFAULT_MOBILE_PREFERRED_CURRENCY)
            .mobileActionAlertIssued(DEFAULT_MOBILE_ACTION_ALERT_ISSUED)
            .externalEfolioYn(DEFAULT_EXTERNAL_EFOLIO_YN)
            .optInBatchFolYn(DEFAULT_OPT_IN_BATCH_FOL_YN)
            .folioAddrElementId(DEFAULT_FOLIO_ADDR_ELEMENT_ID)
            .operaEsignedRegCardYn(DEFAULT_OPERA_ESIGNED_REG_CARD_YN)
            .resvGuid(DEFAULT_RESV_GUID)
            .advanceCheckedInYn(DEFAULT_ADVANCE_CHECKED_IN_YN)
            .expectedTimeOfReturn(DEFAULT_EXPECTED_TIME_OF_RETURN)
            .etrComments(DEFAULT_ETR_COMMENTS)
            .optedForCommYn(DEFAULT_OPTED_FOR_COMM_YN)
            .creditLimitAutoPayAllowYn(DEFAULT_CREDIT_LIMIT_AUTO_PAY_ALLOW_YN);
        return reservationName;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReservationName createUpdatedEntity(EntityManager em) {
        ReservationName reservationName = new ReservationName()
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .nameId(UPDATED_NAME_ID)
            .nameUsageType(UPDATED_NAME_USAGE_TYPE)
            .contactNameId(UPDATED_CONTACT_NAME_ID)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .resvStatus(UPDATED_RESV_STATUS)
            .commissionCode(UPDATED_COMMISSION_CODE)
            .addressId(UPDATED_ADDRESS_ID)
            .phoneId(UPDATED_PHONE_ID)
            .faxYn(UPDATED_FAX_YN)
            .mailYn(UPDATED_MAIL_YN)
            .printRateYn(UPDATED_PRINT_RATE_YN)
            .reportId(UPDATED_REPORT_ID)
            .resvNo(UPDATED_RESV_NO)
            .confirmationNo(UPDATED_CONFIRMATION_NO)
            .beginDate(UPDATED_BEGIN_DATE)
            .endDate(UPDATED_END_DATE)
            .faxId(UPDATED_FAX_ID)
            .emailId(UPDATED_EMAIL_ID)
            .emailYn(UPDATED_EMAIL_YN)
            .consumerYn(UPDATED_CONSUMER_YN)
            .creditCardId(UPDATED_CREDIT_CARD_ID)
            .financiallyResponsibleYn(UPDATED_FINANCIALLY_RESPONSIBLE_YN)
            .paymentMethod(UPDATED_PAYMENT_METHOD)
            .intermediaryYn(UPDATED_INTERMEDIARY_YN)
            .postingAllowedYn(UPDATED_POSTING_ALLOWED_YN)
            .displayColor(UPDATED_DISPLAY_COLOR)
            .actualCheckInDate(UPDATED_ACTUAL_CHECK_IN_DATE)
            .truncActualCheckInDate(UPDATED_TRUNC_ACTUAL_CHECK_IN_DATE)
            .actualCheckOutDate(UPDATED_ACTUAL_CHECK_OUT_DATE)
            .truncActualCheckOutDate(UPDATED_TRUNC_ACTUAL_CHECK_OUT_DATE)
            .creditLimit(UPDATED_CREDIT_LIMIT)
            .authorizedBy(UPDATED_AUTHORIZED_BY)
            .parentResvNameId(UPDATED_PARENT_RESV_NAME_ID)
            .cancellationNo(UPDATED_CANCELLATION_NO)
            .cancellationReasonCode(UPDATED_CANCELLATION_REASON_CODE)
            .cancellationReasonDesc(UPDATED_CANCELLATION_REASON_DESC)
            .arrivalTransportType(UPDATED_ARRIVAL_TRANSPORT_TYPE)
            .arrivalStationCode(UPDATED_ARRIVAL_STATION_CODE)
            .arrivalCarrierCode(UPDATED_ARRIVAL_CARRIER_CODE)
            .arrivalTransportCode(UPDATED_ARRIVAL_TRANSPORT_CODE)
            .arrivalDateTime(UPDATED_ARRIVAL_DATE_TIME)
            .arrivalEstimateTime(UPDATED_ARRIVAL_ESTIMATE_TIME)
            .arrivalTranportationYn(UPDATED_ARRIVAL_TRANPORTATION_YN)
            .arrivalComments(UPDATED_ARRIVAL_COMMENTS)
            .departureTransportType(UPDATED_DEPARTURE_TRANSPORT_TYPE)
            .departureStationCode(UPDATED_DEPARTURE_STATION_CODE)
            .departureCarrierCode(UPDATED_DEPARTURE_CARRIER_CODE)
            .departureTransportCode(UPDATED_DEPARTURE_TRANSPORT_CODE)
            .departureDateTime(UPDATED_DEPARTURE_DATE_TIME)
            .departureEstimateTime(UPDATED_DEPARTURE_ESTIMATE_TIME)
            .departureTransportationYn(UPDATED_DEPARTURE_TRANSPORTATION_YN)
            .departureComments(UPDATED_DEPARTURE_COMMENTS)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .guaranteeCode(UPDATED_GUARANTEE_CODE)
            .wlReasonDescription(UPDATED_WL_REASON_DESCRIPTION)
            .wlReasonCode(UPDATED_WL_REASON_CODE)
            .wlPriority(UPDATED_WL_PRIORITY)
            .doNotMoveRoom(UPDATED_DO_NOT_MOVE_ROOM)
            .externalReference(UPDATED_EXTERNAL_REFERENCE)
            .partyCode(UPDATED_PARTY_CODE)
            .walkinYn(UPDATED_WALKIN_YN)
            .originalEndDate(UPDATED_ORIGINAL_END_DATE)
            .approvalAmountCalcMethod(UPDATED_APPROVAL_AMOUNT_CALC_METHOD)
            .amountPercent(UPDATED_AMOUNT_PERCENT)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .taxExemptNo(UPDATED_TAX_EXEMPT_NO)
            .roomFeatures(UPDATED_ROOM_FEATURES)
            .wlTelephoneNo(UPDATED_WL_TELEPHONE_NO)
            .videoCheckoutYn(UPDATED_VIDEO_CHECKOUT_YN)
            .discountAmt(UPDATED_DISCOUNT_AMT)
            .discountPrcnt(UPDATED_DISCOUNT_PRCNT)
            .discountReasonCode(UPDATED_DISCOUNT_REASON_CODE)
            .commissionPaid(UPDATED_COMMISSION_PAID)
            .commissionHoldCode(UPDATED_COMMISSION_HOLD_CODE)
            .truncBeginDate(UPDATED_TRUNC_BEGIN_DATE)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .sguestName(UPDATED_SGUEST_NAME)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .udfc01(UPDATED_UDFC_01)
            .udfc02(UPDATED_UDFC_02)
            .udfc03(UPDATED_UDFC_03)
            .udfc04(UPDATED_UDFC_04)
            .udfc05(UPDATED_UDFC_05)
            .udfc06(UPDATED_UDFC_06)
            .udfc07(UPDATED_UDFC_07)
            .udfc08(UPDATED_UDFC_08)
            .udfc09(UPDATED_UDFC_09)
            .udfc10(UPDATED_UDFC_10)
            .udfc11(UPDATED_UDFC_11)
            .udfc12(UPDATED_UDFC_12)
            .udfc13(UPDATED_UDFC_13)
            .udfc14(UPDATED_UDFC_14)
            .udfc15(UPDATED_UDFC_15)
            .udfc16(UPDATED_UDFC_16)
            .udfc17(UPDATED_UDFC_17)
            .udfc18(UPDATED_UDFC_18)
            .udfc19(UPDATED_UDFC_19)
            .udfc20(UPDATED_UDFC_20)
            .udfc21(UPDATED_UDFC_21)
            .udfc22(UPDATED_UDFC_22)
            .udfc23(UPDATED_UDFC_23)
            .udfc24(UPDATED_UDFC_24)
            .udfc25(UPDATED_UDFC_25)
            .udfc26(UPDATED_UDFC_26)
            .udfc27(UPDATED_UDFC_27)
            .udfc28(UPDATED_UDFC_28)
            .udfc29(UPDATED_UDFC_29)
            .udfc30(UPDATED_UDFC_30)
            .udfc31(UPDATED_UDFC_31)
            .udfc32(UPDATED_UDFC_32)
            .udfc33(UPDATED_UDFC_33)
            .udfc34(UPDATED_UDFC_34)
            .udfc35(UPDATED_UDFC_35)
            .udfc36(UPDATED_UDFC_36)
            .udfc37(UPDATED_UDFC_37)
            .udfc38(UPDATED_UDFC_38)
            .udfc39(UPDATED_UDFC_39)
            .udfc40(UPDATED_UDFC_40)
            .udfn01(UPDATED_UDFN_01)
            .udfn02(UPDATED_UDFN_02)
            .udfn03(UPDATED_UDFN_03)
            .udfn04(UPDATED_UDFN_04)
            .udfn05(UPDATED_UDFN_05)
            .udfn06(UPDATED_UDFN_06)
            .udfn07(UPDATED_UDFN_07)
            .udfn08(UPDATED_UDFN_08)
            .udfn09(UPDATED_UDFN_09)
            .udfn10(UPDATED_UDFN_10)
            .udfn11(UPDATED_UDFN_11)
            .udfn12(UPDATED_UDFN_12)
            .udfn13(UPDATED_UDFN_13)
            .udfn14(UPDATED_UDFN_14)
            .udfn15(UPDATED_UDFN_15)
            .udfn16(UPDATED_UDFN_16)
            .udfn17(UPDATED_UDFN_17)
            .udfn18(UPDATED_UDFN_18)
            .udfn19(UPDATED_UDFN_19)
            .udfn20(UPDATED_UDFN_20)
            .udfn21(UPDATED_UDFN_21)
            .udfn22(UPDATED_UDFN_22)
            .udfn23(UPDATED_UDFN_23)
            .udfn24(UPDATED_UDFN_24)
            .udfn25(UPDATED_UDFN_25)
            .udfn26(UPDATED_UDFN_26)
            .udfn27(UPDATED_UDFN_27)
            .udfn28(UPDATED_UDFN_28)
            .udfn29(UPDATED_UDFN_29)
            .udfn30(UPDATED_UDFN_30)
            .udfn31(UPDATED_UDFN_31)
            .udfn32(UPDATED_UDFN_32)
            .udfn33(UPDATED_UDFN_33)
            .udfn34(UPDATED_UDFN_34)
            .udfn35(UPDATED_UDFN_35)
            .udfn36(UPDATED_UDFN_36)
            .udfn37(UPDATED_UDFN_37)
            .udfn38(UPDATED_UDFN_38)
            .udfn39(UPDATED_UDFN_39)
            .udfn40(UPDATED_UDFN_40)
            .udfd01(UPDATED_UDFD_01)
            .udfd02(UPDATED_UDFD_02)
            .udfd03(UPDATED_UDFD_03)
            .udfd04(UPDATED_UDFD_04)
            .udfd05(UPDATED_UDFD_05)
            .udfd06(UPDATED_UDFD_06)
            .udfd07(UPDATED_UDFD_07)
            .udfd08(UPDATED_UDFD_08)
            .udfd09(UPDATED_UDFD_09)
            .udfd10(UPDATED_UDFD_10)
            .insertActionInstanceId(UPDATED_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(UPDATED_DML_SEQ_NO)
            .businessDateCreated(UPDATED_BUSINESS_DATE_CREATED)
            .turndownYn(UPDATED_TURNDOWN_YN)
            .roomInstructions(UPDATED_ROOM_INSTRUCTIONS)
            .roomServiceTime(UPDATED_ROOM_SERVICE_TIME)
            .eventId(UPDATED_EVENT_ID)
            .revenueTypeCode(UPDATED_REVENUE_TYPE_CODE)
            .hurdle(UPDATED_HURDLE)
            .hurdleOverride(UPDATED_HURDLE_OVERRIDE)
            .rateableValue(UPDATED_RATEABLE_VALUE)
            .restrictionOverride(UPDATED_RESTRICTION_OVERRIDE)
            .yieldableYn(UPDATED_YIELDABLE_YN)
            .sguestFirstname(UPDATED_SGUEST_FIRSTNAME)
            .guestLastName(UPDATED_GUEST_LAST_NAME)
            .guestFirstName(UPDATED_GUEST_FIRST_NAME)
            .guestLastNameSdx(UPDATED_GUEST_LAST_NAME_SDX)
            .guestFirstNameSdx(UPDATED_GUEST_FIRST_NAME_SDX)
            .channel(UPDATED_CHANNEL)
            .shareSeqNo(UPDATED_SHARE_SEQ_NO)
            .guestSignature(UPDATED_GUEST_SIGNATURE)
            .extensionId(UPDATED_EXTENSION_ID)
            .resvContactId(UPDATED_RESV_CONTACT_ID)
            .billingContactId(UPDATED_BILLING_CONTACT_ID)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .resInsertSourceType(UPDATED_RES_INSERT_SOURCE_TYPE)
            .masterShare(UPDATED_MASTER_SHARE)
            .registrationCardNo(UPDATED_REGISTRATION_CARD_NO)
            .tiad(UPDATED_TIAD)
            .purposeOfStay(UPDATED_PURPOSE_OF_STAY)
            .reinstateDate(UPDATED_REINSTATE_DATE)
            .purgeDate(UPDATED_PURGE_DATE)
            .lastSettleDate(UPDATED_LAST_SETTLE_DATE)
            .lastPeriodicFolioDate(UPDATED_LAST_PERIODIC_FOLIO_DATE)
            .periodicFolioFreq(UPDATED_PERIODIC_FOLIO_FREQ)
            .confirmationLegNo(UPDATED_CONFIRMATION_LEG_NO)
            .guestStatus(UPDATED_GUEST_STATUS)
            .guestType(UPDATED_GUEST_TYPE)
            .checkinDuration(UPDATED_CHECKIN_DURATION)
            .authorizerId(UPDATED_AUTHORIZER_ID)
            .lastOnlinePrintSeq(UPDATED_LAST_ONLINE_PRINT_SEQ)
            .entryPoint(UPDATED_ENTRY_POINT)
            .entryDate(UPDATED_ENTRY_DATE)
            .pseudoMemType(UPDATED_PSEUDO_MEM_TYPE)
            .pseudoMemTotalPoints(UPDATED_PSEUDO_MEM_TOTAL_POINTS)
            .folioText1(UPDATED_FOLIO_TEXT_1)
            .folioText2(UPDATED_FOLIO_TEXT_2)
            .compTypeCode(UPDATED_COMP_TYPE_CODE)
            .uniCardId(UPDATED_UNI_CARD_ID)
            .expCheckinresId(UPDATED_EXP_CHECKINRES_ID)
            .originalBeginDate(UPDATED_ORIGINAL_BEGIN_DATE)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .commissionPayoutTo(UPDATED_COMMISSION_PAYOUT_TO)
            .preChargingYn(UPDATED_PRE_CHARGING_YN)
            .postChargingYn(UPDATED_POST_CHARGING_YN)
            .postCoFlag(UPDATED_POST_CO_FLAG)
            .folioCloseDate(UPDATED_FOLIO_CLOSE_DATE)
            .scheduleCheckoutYn(UPDATED_SCHEDULE_CHECKOUT_YN)
            .customReference(UPDATED_CUSTOM_REFERENCE)
            .guaranteeCodePreCi(UPDATED_GUARANTEE_CODE_PRE_CI)
            .awardMembershipId(UPDATED_AWARD_MEMBERSHIP_ID)
            .esignedRegCardName(UPDATED_ESIGNED_REG_CARD_NAME)
            .statisticalRoomType(UPDATED_STATISTICAL_ROOM_TYPE)
            .statisticalRateTier(UPDATED_STATISTICAL_RATE_TIER)
            .ymCode(UPDATED_YM_CODE)
            .keyValidUntil(UPDATED_KEY_VALID_UNTIL)
            .preRegisteredYn(UPDATED_PRE_REGISTERED_YN)
            .taxRegistrationNo(UPDATED_TAX_REGISTRATION_NO)
            .visaNumber(UPDATED_VISA_NUMBER)
            .visaIssueDate(UPDATED_VISA_ISSUE_DATE)
            .visaExpirationDate(UPDATED_VISA_EXPIRATION_DATE)
            .taxNoOfStays(UPDATED_TAX_NO_OF_STAYS)
            .asbProratedYn(UPDATED_ASB_PRORATED_YN)
            .autoSettleDays(UPDATED_AUTO_SETTLE_DAYS)
            .autoSettleYn(UPDATED_AUTO_SETTLE_YN)
            .splitFromResvNameId(UPDATED_SPLIT_FROM_RESV_NAME_ID)
            .nextDestination(UPDATED_NEXT_DESTINATION)
            .dateOfArrivalInCountry(UPDATED_DATE_OF_ARRIVAL_IN_COUNTRY)
            .preArrReviewedDt(UPDATED_PRE_ARR_REVIEWED_DT)
            .preArrReviewedUser(UPDATED_PRE_ARR_REVIEWED_USER)
            .bonusCheckId(UPDATED_BONUS_CHECK_ID)
            .mobileAudioKeyYn(UPDATED_MOBILE_AUDIO_KEY_YN)
            .directBillVerifyResponse(UPDATED_DIRECT_BILL_VERIFY_RESPONSE)
            .addresseeNameId(UPDATED_ADDRESSEE_NAME_ID)
            .superSearchIndexText(UPDATED_SUPER_SEARCH_INDEX_TEXT)
            .autoCheckinYn(UPDATED_AUTO_CHECKIN_YN)
            .emailFolioYn(UPDATED_EMAIL_FOLIO_YN)
            .emailAddress(UPDATED_EMAIL_ADDRESS)
            .spgUpgradeConfirmedRoomtype(UPDATED_SPG_UPGRADE_CONFIRMED_ROOMTYPE)
            .spgUpgradeReasonCode(UPDATED_SPG_UPGRADE_REASON_CODE)
            .spgSuiteNightAwardStatus(UPDATED_SPG_SUITE_NIGHT_AWARD_STATUS)
            .spgDiscloseRoomTypeYn(UPDATED_SPG_DISCLOSE_ROOM_TYPE_YN)
            .amenityEligibleYn(UPDATED_AMENITY_ELIGIBLE_YN)
            .amenityLevelCode(UPDATED_AMENITY_LEVEL_CODE)
            .baseRateCurrencyCode(UPDATED_BASE_RATE_CURRENCY_CODE)
            .baseRateCode(UPDATED_BASE_RATE_CODE)
            .localBaseRateAmount(UPDATED_LOCAL_BASE_RATE_AMOUNT)
            .phoneDisplayNameYn(UPDATED_PHONE_DISPLAY_NAME_YN)
            .resortChargeNumber(UPDATED_RESORT_CHARGE_NUMBER)
            .mobileChkoutAllowed(UPDATED_MOBILE_CHKOUT_ALLOWED)
            .mobileViewFolioAllowed(UPDATED_MOBILE_VIEW_FOLIO_ALLOWED)
            .hkExpectedServiceTime(UPDATED_HK_EXPECTED_SERVICE_TIME)
            .eligibleForUpgradeYn(UPDATED_ELIGIBLE_FOR_UPGRADE_YN)
            .beginSystemDateTime(UPDATED_BEGIN_SYSTEM_DATE_TIME)
            .mobileCheckinAllowedYn(UPDATED_MOBILE_CHECKIN_ALLOWED_YN)
            .quoteId(UPDATED_QUOTE_ID)
            .manualCheckoutStatus(UPDATED_MANUAL_CHECKOUT_STATUS)
            .mobilePreferredCurrency(UPDATED_MOBILE_PREFERRED_CURRENCY)
            .mobileActionAlertIssued(UPDATED_MOBILE_ACTION_ALERT_ISSUED)
            .externalEfolioYn(UPDATED_EXTERNAL_EFOLIO_YN)
            .optInBatchFolYn(UPDATED_OPT_IN_BATCH_FOL_YN)
            .folioAddrElementId(UPDATED_FOLIO_ADDR_ELEMENT_ID)
            .operaEsignedRegCardYn(UPDATED_OPERA_ESIGNED_REG_CARD_YN)
            .resvGuid(UPDATED_RESV_GUID)
            .advanceCheckedInYn(UPDATED_ADVANCE_CHECKED_IN_YN)
            .expectedTimeOfReturn(UPDATED_EXPECTED_TIME_OF_RETURN)
            .etrComments(UPDATED_ETR_COMMENTS)
            .optedForCommYn(UPDATED_OPTED_FOR_COMM_YN)
            .creditLimitAutoPayAllowYn(UPDATED_CREDIT_LIMIT_AUTO_PAY_ALLOW_YN);
        return reservationName;
    }

    @BeforeEach
    public void initTest() {
        reservationName = createEntity(em);
    }

    @Test
    @Transactional
    void createReservationName() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ReservationName
        var returnedReservationName = om.readValue(
            restReservationNameMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationName)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ReservationName.class
        );

        // Validate the ReservationName in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertReservationNameUpdatableFieldsEquals(returnedReservationName, getPersistedReservationName(returnedReservationName));
    }

    @Test
    @Transactional
    void createReservationNameWithExistingId() throws Exception {
        // Create the ReservationName with an existing ID
        reservationName.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restReservationNameMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationName)))
            .andExpect(status().isBadRequest());

        // Validate the ReservationName in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllReservationNames() throws Exception {
        // Initialize the database
        reservationNameRepository.saveAndFlush(reservationName);

        // Get all the reservationNameList
        restReservationNameMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reservationName.getId().intValue())))
            .andExpect(jsonPath("$.[*].resort").value(hasItem(DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].resvNameId").value(hasItem(DEFAULT_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].nameId").value(hasItem(DEFAULT_NAME_ID)))
            .andExpect(jsonPath("$.[*].nameUsageType").value(hasItem(DEFAULT_NAME_USAGE_TYPE)))
            .andExpect(jsonPath("$.[*].contactNameId").value(hasItem(DEFAULT_CONTACT_NAME_ID)))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].resvStatus").value(hasItem(DEFAULT_RESV_STATUS)))
            .andExpect(jsonPath("$.[*].commissionCode").value(hasItem(DEFAULT_COMMISSION_CODE)))
            .andExpect(jsonPath("$.[*].addressId").value(hasItem(DEFAULT_ADDRESS_ID)))
            .andExpect(jsonPath("$.[*].phoneId").value(hasItem(DEFAULT_PHONE_ID)))
            .andExpect(jsonPath("$.[*].faxYn").value(hasItem(DEFAULT_FAX_YN)))
            .andExpect(jsonPath("$.[*].mailYn").value(hasItem(DEFAULT_MAIL_YN)))
            .andExpect(jsonPath("$.[*].printRateYn").value(hasItem(DEFAULT_PRINT_RATE_YN)))
            .andExpect(jsonPath("$.[*].reportId").value(hasItem(DEFAULT_REPORT_ID)))
            .andExpect(jsonPath("$.[*].resvNo").value(hasItem(DEFAULT_RESV_NO)))
            .andExpect(jsonPath("$.[*].confirmationNo").value(hasItem(DEFAULT_CONFIRMATION_NO)))
            .andExpect(jsonPath("$.[*].beginDate").value(hasItem(DEFAULT_BEGIN_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].faxId").value(hasItem(DEFAULT_FAX_ID)))
            .andExpect(jsonPath("$.[*].emailId").value(hasItem(DEFAULT_EMAIL_ID)))
            .andExpect(jsonPath("$.[*].emailYn").value(hasItem(DEFAULT_EMAIL_YN)))
            .andExpect(jsonPath("$.[*].consumerYn").value(hasItem(DEFAULT_CONSUMER_YN)))
            .andExpect(jsonPath("$.[*].creditCardId").value(hasItem(DEFAULT_CREDIT_CARD_ID)))
            .andExpect(jsonPath("$.[*].financiallyResponsibleYn").value(hasItem(DEFAULT_FINANCIALLY_RESPONSIBLE_YN)))
            .andExpect(jsonPath("$.[*].paymentMethod").value(hasItem(DEFAULT_PAYMENT_METHOD)))
            .andExpect(jsonPath("$.[*].intermediaryYn").value(hasItem(DEFAULT_INTERMEDIARY_YN)))
            .andExpect(jsonPath("$.[*].postingAllowedYn").value(hasItem(DEFAULT_POSTING_ALLOWED_YN)))
            .andExpect(jsonPath("$.[*].displayColor").value(hasItem(DEFAULT_DISPLAY_COLOR)))
            .andExpect(jsonPath("$.[*].actualCheckInDate").value(hasItem(DEFAULT_ACTUAL_CHECK_IN_DATE.toString())))
            .andExpect(jsonPath("$.[*].truncActualCheckInDate").value(hasItem(DEFAULT_TRUNC_ACTUAL_CHECK_IN_DATE.toString())))
            .andExpect(jsonPath("$.[*].actualCheckOutDate").value(hasItem(DEFAULT_ACTUAL_CHECK_OUT_DATE.toString())))
            .andExpect(jsonPath("$.[*].truncActualCheckOutDate").value(hasItem(DEFAULT_TRUNC_ACTUAL_CHECK_OUT_DATE.toString())))
            .andExpect(jsonPath("$.[*].creditLimit").value(hasItem(DEFAULT_CREDIT_LIMIT)))
            .andExpect(jsonPath("$.[*].authorizedBy").value(hasItem(DEFAULT_AUTHORIZED_BY)))
            .andExpect(jsonPath("$.[*].parentResvNameId").value(hasItem(DEFAULT_PARENT_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].cancellationNo").value(hasItem(DEFAULT_CANCELLATION_NO)))
            .andExpect(jsonPath("$.[*].cancellationReasonCode").value(hasItem(DEFAULT_CANCELLATION_REASON_CODE)))
            .andExpect(jsonPath("$.[*].cancellationReasonDesc").value(hasItem(DEFAULT_CANCELLATION_REASON_DESC)))
            .andExpect(jsonPath("$.[*].arrivalTransportType").value(hasItem(DEFAULT_ARRIVAL_TRANSPORT_TYPE)))
            .andExpect(jsonPath("$.[*].arrivalStationCode").value(hasItem(DEFAULT_ARRIVAL_STATION_CODE)))
            .andExpect(jsonPath("$.[*].arrivalCarrierCode").value(hasItem(DEFAULT_ARRIVAL_CARRIER_CODE)))
            .andExpect(jsonPath("$.[*].arrivalTransportCode").value(hasItem(DEFAULT_ARRIVAL_TRANSPORT_CODE)))
            .andExpect(jsonPath("$.[*].arrivalDateTime").value(hasItem(DEFAULT_ARRIVAL_DATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].arrivalEstimateTime").value(hasItem(DEFAULT_ARRIVAL_ESTIMATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].arrivalTranportationYn").value(hasItem(DEFAULT_ARRIVAL_TRANPORTATION_YN)))
            .andExpect(jsonPath("$.[*].arrivalComments").value(hasItem(DEFAULT_ARRIVAL_COMMENTS)))
            .andExpect(jsonPath("$.[*].departureTransportType").value(hasItem(DEFAULT_DEPARTURE_TRANSPORT_TYPE)))
            .andExpect(jsonPath("$.[*].departureStationCode").value(hasItem(DEFAULT_DEPARTURE_STATION_CODE)))
            .andExpect(jsonPath("$.[*].departureCarrierCode").value(hasItem(DEFAULT_DEPARTURE_CARRIER_CODE)))
            .andExpect(jsonPath("$.[*].departureTransportCode").value(hasItem(DEFAULT_DEPARTURE_TRANSPORT_CODE)))
            .andExpect(jsonPath("$.[*].departureDateTime").value(hasItem(DEFAULT_DEPARTURE_DATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].departureEstimateTime").value(hasItem(DEFAULT_DEPARTURE_ESTIMATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].departureTransportationYn").value(hasItem(DEFAULT_DEPARTURE_TRANSPORTATION_YN)))
            .andExpect(jsonPath("$.[*].departureComments").value(hasItem(DEFAULT_DEPARTURE_COMMENTS)))
            .andExpect(jsonPath("$.[*].cancellationDate").value(hasItem(DEFAULT_CANCELLATION_DATE.toString())))
            .andExpect(jsonPath("$.[*].guaranteeCode").value(hasItem(DEFAULT_GUARANTEE_CODE)))
            .andExpect(jsonPath("$.[*].wlReasonDescription").value(hasItem(DEFAULT_WL_REASON_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].wlReasonCode").value(hasItem(DEFAULT_WL_REASON_CODE)))
            .andExpect(jsonPath("$.[*].wlPriority").value(hasItem(DEFAULT_WL_PRIORITY)))
            .andExpect(jsonPath("$.[*].doNotMoveRoom").value(hasItem(DEFAULT_DO_NOT_MOVE_ROOM)))
            .andExpect(jsonPath("$.[*].externalReference").value(hasItem(DEFAULT_EXTERNAL_REFERENCE)))
            .andExpect(jsonPath("$.[*].partyCode").value(hasItem(DEFAULT_PARTY_CODE)))
            .andExpect(jsonPath("$.[*].walkinYn").value(hasItem(DEFAULT_WALKIN_YN)))
            .andExpect(jsonPath("$.[*].originalEndDate").value(hasItem(DEFAULT_ORIGINAL_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].approvalAmountCalcMethod").value(hasItem(DEFAULT_APPROVAL_AMOUNT_CALC_METHOD)))
            .andExpect(jsonPath("$.[*].amountPercent").value(hasItem(DEFAULT_AMOUNT_PERCENT)))
            .andExpect(jsonPath("$.[*].nameTaxType").value(hasItem(DEFAULT_NAME_TAX_TYPE)))
            .andExpect(jsonPath("$.[*].taxExemptNo").value(hasItem(DEFAULT_TAX_EXEMPT_NO)))
            .andExpect(jsonPath("$.[*].roomFeatures").value(hasItem(DEFAULT_ROOM_FEATURES)))
            .andExpect(jsonPath("$.[*].wlTelephoneNo").value(hasItem(DEFAULT_WL_TELEPHONE_NO)))
            .andExpect(jsonPath("$.[*].videoCheckoutYn").value(hasItem(DEFAULT_VIDEO_CHECKOUT_YN)))
            .andExpect(jsonPath("$.[*].discountAmt").value(hasItem(DEFAULT_DISCOUNT_AMT)))
            .andExpect(jsonPath("$.[*].discountPrcnt").value(hasItem(DEFAULT_DISCOUNT_PRCNT)))
            .andExpect(jsonPath("$.[*].discountReasonCode").value(hasItem(DEFAULT_DISCOUNT_REASON_CODE)))
            .andExpect(jsonPath("$.[*].commissionPaid").value(hasItem(DEFAULT_COMMISSION_PAID)))
            .andExpect(jsonPath("$.[*].commissionHoldCode").value(hasItem(DEFAULT_COMMISSION_HOLD_CODE)))
            .andExpect(jsonPath("$.[*].truncBeginDate").value(hasItem(DEFAULT_TRUNC_BEGIN_DATE.toString())))
            .andExpect(jsonPath("$.[*].truncEndDate").value(hasItem(DEFAULT_TRUNC_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].sguestName").value(hasItem(DEFAULT_SGUEST_NAME)))
            .andExpect(jsonPath("$.[*].membershipId").value(hasItem(DEFAULT_MEMBERSHIP_ID)))
            .andExpect(jsonPath("$.[*].udfc01").value(hasItem(DEFAULT_UDFC_01)))
            .andExpect(jsonPath("$.[*].udfc02").value(hasItem(DEFAULT_UDFC_02)))
            .andExpect(jsonPath("$.[*].udfc03").value(hasItem(DEFAULT_UDFC_03)))
            .andExpect(jsonPath("$.[*].udfc04").value(hasItem(DEFAULT_UDFC_04)))
            .andExpect(jsonPath("$.[*].udfc05").value(hasItem(DEFAULT_UDFC_05)))
            .andExpect(jsonPath("$.[*].udfc06").value(hasItem(DEFAULT_UDFC_06)))
            .andExpect(jsonPath("$.[*].udfc07").value(hasItem(DEFAULT_UDFC_07)))
            .andExpect(jsonPath("$.[*].udfc08").value(hasItem(DEFAULT_UDFC_08)))
            .andExpect(jsonPath("$.[*].udfc09").value(hasItem(DEFAULT_UDFC_09)))
            .andExpect(jsonPath("$.[*].udfc10").value(hasItem(DEFAULT_UDFC_10)))
            .andExpect(jsonPath("$.[*].udfc11").value(hasItem(DEFAULT_UDFC_11)))
            .andExpect(jsonPath("$.[*].udfc12").value(hasItem(DEFAULT_UDFC_12)))
            .andExpect(jsonPath("$.[*].udfc13").value(hasItem(DEFAULT_UDFC_13)))
            .andExpect(jsonPath("$.[*].udfc14").value(hasItem(DEFAULT_UDFC_14)))
            .andExpect(jsonPath("$.[*].udfc15").value(hasItem(DEFAULT_UDFC_15)))
            .andExpect(jsonPath("$.[*].udfc16").value(hasItem(DEFAULT_UDFC_16)))
            .andExpect(jsonPath("$.[*].udfc17").value(hasItem(DEFAULT_UDFC_17)))
            .andExpect(jsonPath("$.[*].udfc18").value(hasItem(DEFAULT_UDFC_18)))
            .andExpect(jsonPath("$.[*].udfc19").value(hasItem(DEFAULT_UDFC_19)))
            .andExpect(jsonPath("$.[*].udfc20").value(hasItem(DEFAULT_UDFC_20)))
            .andExpect(jsonPath("$.[*].udfc21").value(hasItem(DEFAULT_UDFC_21)))
            .andExpect(jsonPath("$.[*].udfc22").value(hasItem(DEFAULT_UDFC_22)))
            .andExpect(jsonPath("$.[*].udfc23").value(hasItem(DEFAULT_UDFC_23)))
            .andExpect(jsonPath("$.[*].udfc24").value(hasItem(DEFAULT_UDFC_24)))
            .andExpect(jsonPath("$.[*].udfc25").value(hasItem(DEFAULT_UDFC_25)))
            .andExpect(jsonPath("$.[*].udfc26").value(hasItem(DEFAULT_UDFC_26)))
            .andExpect(jsonPath("$.[*].udfc27").value(hasItem(DEFAULT_UDFC_27)))
            .andExpect(jsonPath("$.[*].udfc28").value(hasItem(DEFAULT_UDFC_28)))
            .andExpect(jsonPath("$.[*].udfc29").value(hasItem(DEFAULT_UDFC_29)))
            .andExpect(jsonPath("$.[*].udfc30").value(hasItem(DEFAULT_UDFC_30)))
            .andExpect(jsonPath("$.[*].udfc31").value(hasItem(DEFAULT_UDFC_31)))
            .andExpect(jsonPath("$.[*].udfc32").value(hasItem(DEFAULT_UDFC_32)))
            .andExpect(jsonPath("$.[*].udfc33").value(hasItem(DEFAULT_UDFC_33)))
            .andExpect(jsonPath("$.[*].udfc34").value(hasItem(DEFAULT_UDFC_34)))
            .andExpect(jsonPath("$.[*].udfc35").value(hasItem(DEFAULT_UDFC_35)))
            .andExpect(jsonPath("$.[*].udfc36").value(hasItem(DEFAULT_UDFC_36)))
            .andExpect(jsonPath("$.[*].udfc37").value(hasItem(DEFAULT_UDFC_37)))
            .andExpect(jsonPath("$.[*].udfc38").value(hasItem(DEFAULT_UDFC_38)))
            .andExpect(jsonPath("$.[*].udfc39").value(hasItem(DEFAULT_UDFC_39)))
            .andExpect(jsonPath("$.[*].udfc40").value(hasItem(DEFAULT_UDFC_40)))
            .andExpect(jsonPath("$.[*].udfn01").value(hasItem(DEFAULT_UDFN_01)))
            .andExpect(jsonPath("$.[*].udfn02").value(hasItem(DEFAULT_UDFN_02)))
            .andExpect(jsonPath("$.[*].udfn03").value(hasItem(DEFAULT_UDFN_03)))
            .andExpect(jsonPath("$.[*].udfn04").value(hasItem(DEFAULT_UDFN_04)))
            .andExpect(jsonPath("$.[*].udfn05").value(hasItem(DEFAULT_UDFN_05)))
            .andExpect(jsonPath("$.[*].udfn06").value(hasItem(DEFAULT_UDFN_06)))
            .andExpect(jsonPath("$.[*].udfn07").value(hasItem(DEFAULT_UDFN_07)))
            .andExpect(jsonPath("$.[*].udfn08").value(hasItem(DEFAULT_UDFN_08)))
            .andExpect(jsonPath("$.[*].udfn09").value(hasItem(DEFAULT_UDFN_09)))
            .andExpect(jsonPath("$.[*].udfn10").value(hasItem(DEFAULT_UDFN_10)))
            .andExpect(jsonPath("$.[*].udfn11").value(hasItem(DEFAULT_UDFN_11)))
            .andExpect(jsonPath("$.[*].udfn12").value(hasItem(DEFAULT_UDFN_12)))
            .andExpect(jsonPath("$.[*].udfn13").value(hasItem(DEFAULT_UDFN_13)))
            .andExpect(jsonPath("$.[*].udfn14").value(hasItem(DEFAULT_UDFN_14)))
            .andExpect(jsonPath("$.[*].udfn15").value(hasItem(DEFAULT_UDFN_15)))
            .andExpect(jsonPath("$.[*].udfn16").value(hasItem(DEFAULT_UDFN_16)))
            .andExpect(jsonPath("$.[*].udfn17").value(hasItem(DEFAULT_UDFN_17)))
            .andExpect(jsonPath("$.[*].udfn18").value(hasItem(DEFAULT_UDFN_18)))
            .andExpect(jsonPath("$.[*].udfn19").value(hasItem(DEFAULT_UDFN_19)))
            .andExpect(jsonPath("$.[*].udfn20").value(hasItem(DEFAULT_UDFN_20)))
            .andExpect(jsonPath("$.[*].udfn21").value(hasItem(DEFAULT_UDFN_21)))
            .andExpect(jsonPath("$.[*].udfn22").value(hasItem(DEFAULT_UDFN_22)))
            .andExpect(jsonPath("$.[*].udfn23").value(hasItem(DEFAULT_UDFN_23)))
            .andExpect(jsonPath("$.[*].udfn24").value(hasItem(DEFAULT_UDFN_24)))
            .andExpect(jsonPath("$.[*].udfn25").value(hasItem(DEFAULT_UDFN_25)))
            .andExpect(jsonPath("$.[*].udfn26").value(hasItem(DEFAULT_UDFN_26)))
            .andExpect(jsonPath("$.[*].udfn27").value(hasItem(DEFAULT_UDFN_27)))
            .andExpect(jsonPath("$.[*].udfn28").value(hasItem(DEFAULT_UDFN_28)))
            .andExpect(jsonPath("$.[*].udfn29").value(hasItem(DEFAULT_UDFN_29)))
            .andExpect(jsonPath("$.[*].udfn30").value(hasItem(DEFAULT_UDFN_30)))
            .andExpect(jsonPath("$.[*].udfn31").value(hasItem(DEFAULT_UDFN_31)))
            .andExpect(jsonPath("$.[*].udfn32").value(hasItem(DEFAULT_UDFN_32)))
            .andExpect(jsonPath("$.[*].udfn33").value(hasItem(DEFAULT_UDFN_33)))
            .andExpect(jsonPath("$.[*].udfn34").value(hasItem(DEFAULT_UDFN_34)))
            .andExpect(jsonPath("$.[*].udfn35").value(hasItem(DEFAULT_UDFN_35)))
            .andExpect(jsonPath("$.[*].udfn36").value(hasItem(DEFAULT_UDFN_36)))
            .andExpect(jsonPath("$.[*].udfn37").value(hasItem(DEFAULT_UDFN_37)))
            .andExpect(jsonPath("$.[*].udfn38").value(hasItem(DEFAULT_UDFN_38)))
            .andExpect(jsonPath("$.[*].udfn39").value(hasItem(DEFAULT_UDFN_39)))
            .andExpect(jsonPath("$.[*].udfn40").value(hasItem(DEFAULT_UDFN_40)))
            .andExpect(jsonPath("$.[*].udfd01").value(hasItem(DEFAULT_UDFD_01.toString())))
            .andExpect(jsonPath("$.[*].udfd02").value(hasItem(DEFAULT_UDFD_02.toString())))
            .andExpect(jsonPath("$.[*].udfd03").value(hasItem(DEFAULT_UDFD_03.toString())))
            .andExpect(jsonPath("$.[*].udfd04").value(hasItem(DEFAULT_UDFD_04.toString())))
            .andExpect(jsonPath("$.[*].udfd05").value(hasItem(DEFAULT_UDFD_05.toString())))
            .andExpect(jsonPath("$.[*].udfd06").value(hasItem(DEFAULT_UDFD_06.toString())))
            .andExpect(jsonPath("$.[*].udfd07").value(hasItem(DEFAULT_UDFD_07.toString())))
            .andExpect(jsonPath("$.[*].udfd08").value(hasItem(DEFAULT_UDFD_08.toString())))
            .andExpect(jsonPath("$.[*].udfd09").value(hasItem(DEFAULT_UDFD_09.toString())))
            .andExpect(jsonPath("$.[*].udfd10").value(hasItem(DEFAULT_UDFD_10.toString())))
            .andExpect(jsonPath("$.[*].insertActionInstanceId").value(hasItem(DEFAULT_INSERT_ACTION_INSTANCE_ID)))
            .andExpect(jsonPath("$.[*].dmlSeqNo").value(hasItem(DEFAULT_DML_SEQ_NO)))
            .andExpect(jsonPath("$.[*].businessDateCreated").value(hasItem(DEFAULT_BUSINESS_DATE_CREATED.toString())))
            .andExpect(jsonPath("$.[*].turndownYn").value(hasItem(DEFAULT_TURNDOWN_YN)))
            .andExpect(jsonPath("$.[*].roomInstructions").value(hasItem(DEFAULT_ROOM_INSTRUCTIONS)))
            .andExpect(jsonPath("$.[*].roomServiceTime").value(hasItem(DEFAULT_ROOM_SERVICE_TIME)))
            .andExpect(jsonPath("$.[*].eventId").value(hasItem(DEFAULT_EVENT_ID)))
            .andExpect(jsonPath("$.[*].revenueTypeCode").value(hasItem(DEFAULT_REVENUE_TYPE_CODE)))
            .andExpect(jsonPath("$.[*].hurdle").value(hasItem(DEFAULT_HURDLE)))
            .andExpect(jsonPath("$.[*].hurdleOverride").value(hasItem(DEFAULT_HURDLE_OVERRIDE)))
            .andExpect(jsonPath("$.[*].rateableValue").value(hasItem(DEFAULT_RATEABLE_VALUE)))
            .andExpect(jsonPath("$.[*].restrictionOverride").value(hasItem(DEFAULT_RESTRICTION_OVERRIDE)))
            .andExpect(jsonPath("$.[*].yieldableYn").value(hasItem(DEFAULT_YIELDABLE_YN)))
            .andExpect(jsonPath("$.[*].sguestFirstname").value(hasItem(DEFAULT_SGUEST_FIRSTNAME)))
            .andExpect(jsonPath("$.[*].guestLastName").value(hasItem(DEFAULT_GUEST_LAST_NAME)))
            .andExpect(jsonPath("$.[*].guestFirstName").value(hasItem(DEFAULT_GUEST_FIRST_NAME)))
            .andExpect(jsonPath("$.[*].guestLastNameSdx").value(hasItem(DEFAULT_GUEST_LAST_NAME_SDX)))
            .andExpect(jsonPath("$.[*].guestFirstNameSdx").value(hasItem(DEFAULT_GUEST_FIRST_NAME_SDX)))
            .andExpect(jsonPath("$.[*].channel").value(hasItem(DEFAULT_CHANNEL)))
            .andExpect(jsonPath("$.[*].shareSeqNo").value(hasItem(DEFAULT_SHARE_SEQ_NO)))
            .andExpect(jsonPath("$.[*].guestSignature").value(hasItem(DEFAULT_GUEST_SIGNATURE)))
            .andExpect(jsonPath("$.[*].extensionId").value(hasItem(DEFAULT_EXTENSION_ID)))
            .andExpect(jsonPath("$.[*].resvContactId").value(hasItem(DEFAULT_RESV_CONTACT_ID)))
            .andExpect(jsonPath("$.[*].billingContactId").value(hasItem(DEFAULT_BILLING_CONTACT_ID)))
            .andExpect(jsonPath("$.[*].resInsertSource").value(hasItem(DEFAULT_RES_INSERT_SOURCE)))
            .andExpect(jsonPath("$.[*].resInsertSourceType").value(hasItem(DEFAULT_RES_INSERT_SOURCE_TYPE)))
            .andExpect(jsonPath("$.[*].masterShare").value(hasItem(DEFAULT_MASTER_SHARE)))
            .andExpect(jsonPath("$.[*].registrationCardNo").value(hasItem(DEFAULT_REGISTRATION_CARD_NO)))
            .andExpect(jsonPath("$.[*].tiad").value(hasItem(DEFAULT_TIAD)))
            .andExpect(jsonPath("$.[*].purposeOfStay").value(hasItem(DEFAULT_PURPOSE_OF_STAY)))
            .andExpect(jsonPath("$.[*].reinstateDate").value(hasItem(DEFAULT_REINSTATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].purgeDate").value(hasItem(DEFAULT_PURGE_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastSettleDate").value(hasItem(DEFAULT_LAST_SETTLE_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastPeriodicFolioDate").value(hasItem(DEFAULT_LAST_PERIODIC_FOLIO_DATE.toString())))
            .andExpect(jsonPath("$.[*].periodicFolioFreq").value(hasItem(DEFAULT_PERIODIC_FOLIO_FREQ)))
            .andExpect(jsonPath("$.[*].confirmationLegNo").value(hasItem(DEFAULT_CONFIRMATION_LEG_NO)))
            .andExpect(jsonPath("$.[*].guestStatus").value(hasItem(DEFAULT_GUEST_STATUS)))
            .andExpect(jsonPath("$.[*].guestType").value(hasItem(DEFAULT_GUEST_TYPE)))
            .andExpect(jsonPath("$.[*].checkinDuration").value(hasItem(DEFAULT_CHECKIN_DURATION)))
            .andExpect(jsonPath("$.[*].authorizerId").value(hasItem(DEFAULT_AUTHORIZER_ID)))
            .andExpect(jsonPath("$.[*].lastOnlinePrintSeq").value(hasItem(DEFAULT_LAST_ONLINE_PRINT_SEQ)))
            .andExpect(jsonPath("$.[*].entryPoint").value(hasItem(DEFAULT_ENTRY_POINT)))
            .andExpect(jsonPath("$.[*].entryDate").value(hasItem(DEFAULT_ENTRY_DATE.toString())))
            .andExpect(jsonPath("$.[*].pseudoMemType").value(hasItem(DEFAULT_PSEUDO_MEM_TYPE)))
            .andExpect(jsonPath("$.[*].pseudoMemTotalPoints").value(hasItem(DEFAULT_PSEUDO_MEM_TOTAL_POINTS)))
            .andExpect(jsonPath("$.[*].folioText1").value(hasItem(DEFAULT_FOLIO_TEXT_1)))
            .andExpect(jsonPath("$.[*].folioText2").value(hasItem(DEFAULT_FOLIO_TEXT_2)))
            .andExpect(jsonPath("$.[*].compTypeCode").value(hasItem(DEFAULT_COMP_TYPE_CODE)))
            .andExpect(jsonPath("$.[*].uniCardId").value(hasItem(DEFAULT_UNI_CARD_ID)))
            .andExpect(jsonPath("$.[*].expCheckinresId").value(hasItem(DEFAULT_EXP_CHECKINRES_ID)))
            .andExpect(jsonPath("$.[*].originalBeginDate").value(hasItem(DEFAULT_ORIGINAL_BEGIN_DATE.toString())))
            .andExpect(jsonPath("$.[*].ownerFfFlag").value(hasItem(DEFAULT_OWNER_FF_FLAG)))
            .andExpect(jsonPath("$.[*].commissionPayoutTo").value(hasItem(DEFAULT_COMMISSION_PAYOUT_TO)))
            .andExpect(jsonPath("$.[*].preChargingYn").value(hasItem(DEFAULT_PRE_CHARGING_YN)))
            .andExpect(jsonPath("$.[*].postChargingYn").value(hasItem(DEFAULT_POST_CHARGING_YN)))
            .andExpect(jsonPath("$.[*].postCoFlag").value(hasItem(DEFAULT_POST_CO_FLAG)))
            .andExpect(jsonPath("$.[*].folioCloseDate").value(hasItem(DEFAULT_FOLIO_CLOSE_DATE.toString())))
            .andExpect(jsonPath("$.[*].scheduleCheckoutYn").value(hasItem(DEFAULT_SCHEDULE_CHECKOUT_YN)))
            .andExpect(jsonPath("$.[*].customReference").value(hasItem(DEFAULT_CUSTOM_REFERENCE)))
            .andExpect(jsonPath("$.[*].guaranteeCodePreCi").value(hasItem(DEFAULT_GUARANTEE_CODE_PRE_CI)))
            .andExpect(jsonPath("$.[*].awardMembershipId").value(hasItem(DEFAULT_AWARD_MEMBERSHIP_ID)))
            .andExpect(jsonPath("$.[*].esignedRegCardName").value(hasItem(DEFAULT_ESIGNED_REG_CARD_NAME)))
            .andExpect(jsonPath("$.[*].statisticalRoomType").value(hasItem(DEFAULT_STATISTICAL_ROOM_TYPE)))
            .andExpect(jsonPath("$.[*].statisticalRateTier").value(hasItem(DEFAULT_STATISTICAL_RATE_TIER)))
            .andExpect(jsonPath("$.[*].ymCode").value(hasItem(DEFAULT_YM_CODE)))
            .andExpect(jsonPath("$.[*].keyValidUntil").value(hasItem(DEFAULT_KEY_VALID_UNTIL.toString())))
            .andExpect(jsonPath("$.[*].preRegisteredYn").value(hasItem(DEFAULT_PRE_REGISTERED_YN)))
            .andExpect(jsonPath("$.[*].taxRegistrationNo").value(hasItem(DEFAULT_TAX_REGISTRATION_NO)))
            .andExpect(jsonPath("$.[*].visaNumber").value(hasItem(DEFAULT_VISA_NUMBER)))
            .andExpect(jsonPath("$.[*].visaIssueDate").value(hasItem(DEFAULT_VISA_ISSUE_DATE.toString())))
            .andExpect(jsonPath("$.[*].visaExpirationDate").value(hasItem(DEFAULT_VISA_EXPIRATION_DATE.toString())))
            .andExpect(jsonPath("$.[*].taxNoOfStays").value(hasItem(DEFAULT_TAX_NO_OF_STAYS)))
            .andExpect(jsonPath("$.[*].asbProratedYn").value(hasItem(DEFAULT_ASB_PRORATED_YN)))
            .andExpect(jsonPath("$.[*].autoSettleDays").value(hasItem(DEFAULT_AUTO_SETTLE_DAYS)))
            .andExpect(jsonPath("$.[*].autoSettleYn").value(hasItem(DEFAULT_AUTO_SETTLE_YN)))
            .andExpect(jsonPath("$.[*].splitFromResvNameId").value(hasItem(DEFAULT_SPLIT_FROM_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].nextDestination").value(hasItem(DEFAULT_NEXT_DESTINATION)))
            .andExpect(jsonPath("$.[*].dateOfArrivalInCountry").value(hasItem(DEFAULT_DATE_OF_ARRIVAL_IN_COUNTRY.toString())))
            .andExpect(jsonPath("$.[*].preArrReviewedDt").value(hasItem(DEFAULT_PRE_ARR_REVIEWED_DT.toString())))
            .andExpect(jsonPath("$.[*].preArrReviewedUser").value(hasItem(DEFAULT_PRE_ARR_REVIEWED_USER)))
            .andExpect(jsonPath("$.[*].bonusCheckId").value(hasItem(DEFAULT_BONUS_CHECK_ID)))
            .andExpect(jsonPath("$.[*].mobileAudioKeyYn").value(hasItem(DEFAULT_MOBILE_AUDIO_KEY_YN)))
            .andExpect(jsonPath("$.[*].directBillVerifyResponse").value(hasItem(DEFAULT_DIRECT_BILL_VERIFY_RESPONSE)))
            .andExpect(jsonPath("$.[*].addresseeNameId").value(hasItem(DEFAULT_ADDRESSEE_NAME_ID)))
            .andExpect(jsonPath("$.[*].superSearchIndexText").value(hasItem(DEFAULT_SUPER_SEARCH_INDEX_TEXT)))
            .andExpect(jsonPath("$.[*].autoCheckinYn").value(hasItem(DEFAULT_AUTO_CHECKIN_YN)))
            .andExpect(jsonPath("$.[*].emailFolioYn").value(hasItem(DEFAULT_EMAIL_FOLIO_YN)))
            .andExpect(jsonPath("$.[*].emailAddress").value(hasItem(DEFAULT_EMAIL_ADDRESS)))
            .andExpect(jsonPath("$.[*].spgUpgradeConfirmedRoomtype").value(hasItem(DEFAULT_SPG_UPGRADE_CONFIRMED_ROOMTYPE)))
            .andExpect(jsonPath("$.[*].spgUpgradeReasonCode").value(hasItem(DEFAULT_SPG_UPGRADE_REASON_CODE)))
            .andExpect(jsonPath("$.[*].spgSuiteNightAwardStatus").value(hasItem(DEFAULT_SPG_SUITE_NIGHT_AWARD_STATUS)))
            .andExpect(jsonPath("$.[*].spgDiscloseRoomTypeYn").value(hasItem(DEFAULT_SPG_DISCLOSE_ROOM_TYPE_YN)))
            .andExpect(jsonPath("$.[*].amenityEligibleYn").value(hasItem(DEFAULT_AMENITY_ELIGIBLE_YN)))
            .andExpect(jsonPath("$.[*].amenityLevelCode").value(hasItem(DEFAULT_AMENITY_LEVEL_CODE)))
            .andExpect(jsonPath("$.[*].baseRateCurrencyCode").value(hasItem(DEFAULT_BASE_RATE_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].baseRateCode").value(hasItem(DEFAULT_BASE_RATE_CODE)))
            .andExpect(jsonPath("$.[*].localBaseRateAmount").value(hasItem(DEFAULT_LOCAL_BASE_RATE_AMOUNT)))
            .andExpect(jsonPath("$.[*].phoneDisplayNameYn").value(hasItem(DEFAULT_PHONE_DISPLAY_NAME_YN)))
            .andExpect(jsonPath("$.[*].resortChargeNumber").value(hasItem(DEFAULT_RESORT_CHARGE_NUMBER)))
            .andExpect(jsonPath("$.[*].mobileChkoutAllowed").value(hasItem(DEFAULT_MOBILE_CHKOUT_ALLOWED)))
            .andExpect(jsonPath("$.[*].mobileViewFolioAllowed").value(hasItem(DEFAULT_MOBILE_VIEW_FOLIO_ALLOWED)))
            .andExpect(jsonPath("$.[*].hkExpectedServiceTime").value(hasItem(DEFAULT_HK_EXPECTED_SERVICE_TIME)))
            .andExpect(jsonPath("$.[*].eligibleForUpgradeYn").value(hasItem(DEFAULT_ELIGIBLE_FOR_UPGRADE_YN)))
            .andExpect(jsonPath("$.[*].beginSystemDateTime").value(hasItem(DEFAULT_BEGIN_SYSTEM_DATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].mobileCheckinAllowedYn").value(hasItem(DEFAULT_MOBILE_CHECKIN_ALLOWED_YN)))
            .andExpect(jsonPath("$.[*].quoteId").value(hasItem(DEFAULT_QUOTE_ID)))
            .andExpect(jsonPath("$.[*].manualCheckoutStatus").value(hasItem(DEFAULT_MANUAL_CHECKOUT_STATUS)))
            .andExpect(jsonPath("$.[*].mobilePreferredCurrency").value(hasItem(DEFAULT_MOBILE_PREFERRED_CURRENCY)))
            .andExpect(jsonPath("$.[*].mobileActionAlertIssued").value(hasItem(DEFAULT_MOBILE_ACTION_ALERT_ISSUED.toString())))
            .andExpect(jsonPath("$.[*].externalEfolioYn").value(hasItem(DEFAULT_EXTERNAL_EFOLIO_YN)))
            .andExpect(jsonPath("$.[*].optInBatchFolYn").value(hasItem(DEFAULT_OPT_IN_BATCH_FOL_YN)))
            .andExpect(jsonPath("$.[*].folioAddrElementId").value(hasItem(DEFAULT_FOLIO_ADDR_ELEMENT_ID)))
            .andExpect(jsonPath("$.[*].operaEsignedRegCardYn").value(hasItem(DEFAULT_OPERA_ESIGNED_REG_CARD_YN)))
            .andExpect(jsonPath("$.[*].resvGuid").value(hasItem(DEFAULT_RESV_GUID)))
            .andExpect(jsonPath("$.[*].advanceCheckedInYn").value(hasItem(DEFAULT_ADVANCE_CHECKED_IN_YN)))
            .andExpect(jsonPath("$.[*].expectedTimeOfReturn").value(hasItem(DEFAULT_EXPECTED_TIME_OF_RETURN.toString())))
            .andExpect(jsonPath("$.[*].etrComments").value(hasItem(DEFAULT_ETR_COMMENTS)))
            .andExpect(jsonPath("$.[*].optedForCommYn").value(hasItem(DEFAULT_OPTED_FOR_COMM_YN)))
            .andExpect(jsonPath("$.[*].creditLimitAutoPayAllowYn").value(hasItem(DEFAULT_CREDIT_LIMIT_AUTO_PAY_ALLOW_YN)));
    }

    @Test
    @Transactional
    void getReservationName() throws Exception {
        // Initialize the database
        reservationNameRepository.saveAndFlush(reservationName);

        // Get the reservationName
        restReservationNameMockMvc
            .perform(get(ENTITY_API_URL_ID, reservationName.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(reservationName.getId().intValue()))
            .andExpect(jsonPath("$.resort").value(DEFAULT_RESORT))
            .andExpect(jsonPath("$.resvNameId").value(DEFAULT_RESV_NAME_ID))
            .andExpect(jsonPath("$.nameId").value(DEFAULT_NAME_ID))
            .andExpect(jsonPath("$.nameUsageType").value(DEFAULT_NAME_USAGE_TYPE))
            .andExpect(jsonPath("$.contactNameId").value(DEFAULT_CONTACT_NAME_ID))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.resvStatus").value(DEFAULT_RESV_STATUS))
            .andExpect(jsonPath("$.commissionCode").value(DEFAULT_COMMISSION_CODE))
            .andExpect(jsonPath("$.addressId").value(DEFAULT_ADDRESS_ID))
            .andExpect(jsonPath("$.phoneId").value(DEFAULT_PHONE_ID))
            .andExpect(jsonPath("$.faxYn").value(DEFAULT_FAX_YN))
            .andExpect(jsonPath("$.mailYn").value(DEFAULT_MAIL_YN))
            .andExpect(jsonPath("$.printRateYn").value(DEFAULT_PRINT_RATE_YN))
            .andExpect(jsonPath("$.reportId").value(DEFAULT_REPORT_ID))
            .andExpect(jsonPath("$.resvNo").value(DEFAULT_RESV_NO))
            .andExpect(jsonPath("$.confirmationNo").value(DEFAULT_CONFIRMATION_NO))
            .andExpect(jsonPath("$.beginDate").value(DEFAULT_BEGIN_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.faxId").value(DEFAULT_FAX_ID))
            .andExpect(jsonPath("$.emailId").value(DEFAULT_EMAIL_ID))
            .andExpect(jsonPath("$.emailYn").value(DEFAULT_EMAIL_YN))
            .andExpect(jsonPath("$.consumerYn").value(DEFAULT_CONSUMER_YN))
            .andExpect(jsonPath("$.creditCardId").value(DEFAULT_CREDIT_CARD_ID))
            .andExpect(jsonPath("$.financiallyResponsibleYn").value(DEFAULT_FINANCIALLY_RESPONSIBLE_YN))
            .andExpect(jsonPath("$.paymentMethod").value(DEFAULT_PAYMENT_METHOD))
            .andExpect(jsonPath("$.intermediaryYn").value(DEFAULT_INTERMEDIARY_YN))
            .andExpect(jsonPath("$.postingAllowedYn").value(DEFAULT_POSTING_ALLOWED_YN))
            .andExpect(jsonPath("$.displayColor").value(DEFAULT_DISPLAY_COLOR))
            .andExpect(jsonPath("$.actualCheckInDate").value(DEFAULT_ACTUAL_CHECK_IN_DATE.toString()))
            .andExpect(jsonPath("$.truncActualCheckInDate").value(DEFAULT_TRUNC_ACTUAL_CHECK_IN_DATE.toString()))
            .andExpect(jsonPath("$.actualCheckOutDate").value(DEFAULT_ACTUAL_CHECK_OUT_DATE.toString()))
            .andExpect(jsonPath("$.truncActualCheckOutDate").value(DEFAULT_TRUNC_ACTUAL_CHECK_OUT_DATE.toString()))
            .andExpect(jsonPath("$.creditLimit").value(DEFAULT_CREDIT_LIMIT))
            .andExpect(jsonPath("$.authorizedBy").value(DEFAULT_AUTHORIZED_BY))
            .andExpect(jsonPath("$.parentResvNameId").value(DEFAULT_PARENT_RESV_NAME_ID))
            .andExpect(jsonPath("$.cancellationNo").value(DEFAULT_CANCELLATION_NO))
            .andExpect(jsonPath("$.cancellationReasonCode").value(DEFAULT_CANCELLATION_REASON_CODE))
            .andExpect(jsonPath("$.cancellationReasonDesc").value(DEFAULT_CANCELLATION_REASON_DESC))
            .andExpect(jsonPath("$.arrivalTransportType").value(DEFAULT_ARRIVAL_TRANSPORT_TYPE))
            .andExpect(jsonPath("$.arrivalStationCode").value(DEFAULT_ARRIVAL_STATION_CODE))
            .andExpect(jsonPath("$.arrivalCarrierCode").value(DEFAULT_ARRIVAL_CARRIER_CODE))
            .andExpect(jsonPath("$.arrivalTransportCode").value(DEFAULT_ARRIVAL_TRANSPORT_CODE))
            .andExpect(jsonPath("$.arrivalDateTime").value(DEFAULT_ARRIVAL_DATE_TIME.toString()))
            .andExpect(jsonPath("$.arrivalEstimateTime").value(DEFAULT_ARRIVAL_ESTIMATE_TIME.toString()))
            .andExpect(jsonPath("$.arrivalTranportationYn").value(DEFAULT_ARRIVAL_TRANPORTATION_YN))
            .andExpect(jsonPath("$.arrivalComments").value(DEFAULT_ARRIVAL_COMMENTS))
            .andExpect(jsonPath("$.departureTransportType").value(DEFAULT_DEPARTURE_TRANSPORT_TYPE))
            .andExpect(jsonPath("$.departureStationCode").value(DEFAULT_DEPARTURE_STATION_CODE))
            .andExpect(jsonPath("$.departureCarrierCode").value(DEFAULT_DEPARTURE_CARRIER_CODE))
            .andExpect(jsonPath("$.departureTransportCode").value(DEFAULT_DEPARTURE_TRANSPORT_CODE))
            .andExpect(jsonPath("$.departureDateTime").value(DEFAULT_DEPARTURE_DATE_TIME.toString()))
            .andExpect(jsonPath("$.departureEstimateTime").value(DEFAULT_DEPARTURE_ESTIMATE_TIME.toString()))
            .andExpect(jsonPath("$.departureTransportationYn").value(DEFAULT_DEPARTURE_TRANSPORTATION_YN))
            .andExpect(jsonPath("$.departureComments").value(DEFAULT_DEPARTURE_COMMENTS))
            .andExpect(jsonPath("$.cancellationDate").value(DEFAULT_CANCELLATION_DATE.toString()))
            .andExpect(jsonPath("$.guaranteeCode").value(DEFAULT_GUARANTEE_CODE))
            .andExpect(jsonPath("$.wlReasonDescription").value(DEFAULT_WL_REASON_DESCRIPTION))
            .andExpect(jsonPath("$.wlReasonCode").value(DEFAULT_WL_REASON_CODE))
            .andExpect(jsonPath("$.wlPriority").value(DEFAULT_WL_PRIORITY))
            .andExpect(jsonPath("$.doNotMoveRoom").value(DEFAULT_DO_NOT_MOVE_ROOM))
            .andExpect(jsonPath("$.externalReference").value(DEFAULT_EXTERNAL_REFERENCE))
            .andExpect(jsonPath("$.partyCode").value(DEFAULT_PARTY_CODE))
            .andExpect(jsonPath("$.walkinYn").value(DEFAULT_WALKIN_YN))
            .andExpect(jsonPath("$.originalEndDate").value(DEFAULT_ORIGINAL_END_DATE.toString()))
            .andExpect(jsonPath("$.approvalAmountCalcMethod").value(DEFAULT_APPROVAL_AMOUNT_CALC_METHOD))
            .andExpect(jsonPath("$.amountPercent").value(DEFAULT_AMOUNT_PERCENT))
            .andExpect(jsonPath("$.nameTaxType").value(DEFAULT_NAME_TAX_TYPE))
            .andExpect(jsonPath("$.taxExemptNo").value(DEFAULT_TAX_EXEMPT_NO))
            .andExpect(jsonPath("$.roomFeatures").value(DEFAULT_ROOM_FEATURES))
            .andExpect(jsonPath("$.wlTelephoneNo").value(DEFAULT_WL_TELEPHONE_NO))
            .andExpect(jsonPath("$.videoCheckoutYn").value(DEFAULT_VIDEO_CHECKOUT_YN))
            .andExpect(jsonPath("$.discountAmt").value(DEFAULT_DISCOUNT_AMT))
            .andExpect(jsonPath("$.discountPrcnt").value(DEFAULT_DISCOUNT_PRCNT))
            .andExpect(jsonPath("$.discountReasonCode").value(DEFAULT_DISCOUNT_REASON_CODE))
            .andExpect(jsonPath("$.commissionPaid").value(DEFAULT_COMMISSION_PAID))
            .andExpect(jsonPath("$.commissionHoldCode").value(DEFAULT_COMMISSION_HOLD_CODE))
            .andExpect(jsonPath("$.truncBeginDate").value(DEFAULT_TRUNC_BEGIN_DATE.toString()))
            .andExpect(jsonPath("$.truncEndDate").value(DEFAULT_TRUNC_END_DATE.toString()))
            .andExpect(jsonPath("$.sguestName").value(DEFAULT_SGUEST_NAME))
            .andExpect(jsonPath("$.membershipId").value(DEFAULT_MEMBERSHIP_ID))
            .andExpect(jsonPath("$.udfc01").value(DEFAULT_UDFC_01))
            .andExpect(jsonPath("$.udfc02").value(DEFAULT_UDFC_02))
            .andExpect(jsonPath("$.udfc03").value(DEFAULT_UDFC_03))
            .andExpect(jsonPath("$.udfc04").value(DEFAULT_UDFC_04))
            .andExpect(jsonPath("$.udfc05").value(DEFAULT_UDFC_05))
            .andExpect(jsonPath("$.udfc06").value(DEFAULT_UDFC_06))
            .andExpect(jsonPath("$.udfc07").value(DEFAULT_UDFC_07))
            .andExpect(jsonPath("$.udfc08").value(DEFAULT_UDFC_08))
            .andExpect(jsonPath("$.udfc09").value(DEFAULT_UDFC_09))
            .andExpect(jsonPath("$.udfc10").value(DEFAULT_UDFC_10))
            .andExpect(jsonPath("$.udfc11").value(DEFAULT_UDFC_11))
            .andExpect(jsonPath("$.udfc12").value(DEFAULT_UDFC_12))
            .andExpect(jsonPath("$.udfc13").value(DEFAULT_UDFC_13))
            .andExpect(jsonPath("$.udfc14").value(DEFAULT_UDFC_14))
            .andExpect(jsonPath("$.udfc15").value(DEFAULT_UDFC_15))
            .andExpect(jsonPath("$.udfc16").value(DEFAULT_UDFC_16))
            .andExpect(jsonPath("$.udfc17").value(DEFAULT_UDFC_17))
            .andExpect(jsonPath("$.udfc18").value(DEFAULT_UDFC_18))
            .andExpect(jsonPath("$.udfc19").value(DEFAULT_UDFC_19))
            .andExpect(jsonPath("$.udfc20").value(DEFAULT_UDFC_20))
            .andExpect(jsonPath("$.udfc21").value(DEFAULT_UDFC_21))
            .andExpect(jsonPath("$.udfc22").value(DEFAULT_UDFC_22))
            .andExpect(jsonPath("$.udfc23").value(DEFAULT_UDFC_23))
            .andExpect(jsonPath("$.udfc24").value(DEFAULT_UDFC_24))
            .andExpect(jsonPath("$.udfc25").value(DEFAULT_UDFC_25))
            .andExpect(jsonPath("$.udfc26").value(DEFAULT_UDFC_26))
            .andExpect(jsonPath("$.udfc27").value(DEFAULT_UDFC_27))
            .andExpect(jsonPath("$.udfc28").value(DEFAULT_UDFC_28))
            .andExpect(jsonPath("$.udfc29").value(DEFAULT_UDFC_29))
            .andExpect(jsonPath("$.udfc30").value(DEFAULT_UDFC_30))
            .andExpect(jsonPath("$.udfc31").value(DEFAULT_UDFC_31))
            .andExpect(jsonPath("$.udfc32").value(DEFAULT_UDFC_32))
            .andExpect(jsonPath("$.udfc33").value(DEFAULT_UDFC_33))
            .andExpect(jsonPath("$.udfc34").value(DEFAULT_UDFC_34))
            .andExpect(jsonPath("$.udfc35").value(DEFAULT_UDFC_35))
            .andExpect(jsonPath("$.udfc36").value(DEFAULT_UDFC_36))
            .andExpect(jsonPath("$.udfc37").value(DEFAULT_UDFC_37))
            .andExpect(jsonPath("$.udfc38").value(DEFAULT_UDFC_38))
            .andExpect(jsonPath("$.udfc39").value(DEFAULT_UDFC_39))
            .andExpect(jsonPath("$.udfc40").value(DEFAULT_UDFC_40))
            .andExpect(jsonPath("$.udfn01").value(DEFAULT_UDFN_01))
            .andExpect(jsonPath("$.udfn02").value(DEFAULT_UDFN_02))
            .andExpect(jsonPath("$.udfn03").value(DEFAULT_UDFN_03))
            .andExpect(jsonPath("$.udfn04").value(DEFAULT_UDFN_04))
            .andExpect(jsonPath("$.udfn05").value(DEFAULT_UDFN_05))
            .andExpect(jsonPath("$.udfn06").value(DEFAULT_UDFN_06))
            .andExpect(jsonPath("$.udfn07").value(DEFAULT_UDFN_07))
            .andExpect(jsonPath("$.udfn08").value(DEFAULT_UDFN_08))
            .andExpect(jsonPath("$.udfn09").value(DEFAULT_UDFN_09))
            .andExpect(jsonPath("$.udfn10").value(DEFAULT_UDFN_10))
            .andExpect(jsonPath("$.udfn11").value(DEFAULT_UDFN_11))
            .andExpect(jsonPath("$.udfn12").value(DEFAULT_UDFN_12))
            .andExpect(jsonPath("$.udfn13").value(DEFAULT_UDFN_13))
            .andExpect(jsonPath("$.udfn14").value(DEFAULT_UDFN_14))
            .andExpect(jsonPath("$.udfn15").value(DEFAULT_UDFN_15))
            .andExpect(jsonPath("$.udfn16").value(DEFAULT_UDFN_16))
            .andExpect(jsonPath("$.udfn17").value(DEFAULT_UDFN_17))
            .andExpect(jsonPath("$.udfn18").value(DEFAULT_UDFN_18))
            .andExpect(jsonPath("$.udfn19").value(DEFAULT_UDFN_19))
            .andExpect(jsonPath("$.udfn20").value(DEFAULT_UDFN_20))
            .andExpect(jsonPath("$.udfn21").value(DEFAULT_UDFN_21))
            .andExpect(jsonPath("$.udfn22").value(DEFAULT_UDFN_22))
            .andExpect(jsonPath("$.udfn23").value(DEFAULT_UDFN_23))
            .andExpect(jsonPath("$.udfn24").value(DEFAULT_UDFN_24))
            .andExpect(jsonPath("$.udfn25").value(DEFAULT_UDFN_25))
            .andExpect(jsonPath("$.udfn26").value(DEFAULT_UDFN_26))
            .andExpect(jsonPath("$.udfn27").value(DEFAULT_UDFN_27))
            .andExpect(jsonPath("$.udfn28").value(DEFAULT_UDFN_28))
            .andExpect(jsonPath("$.udfn29").value(DEFAULT_UDFN_29))
            .andExpect(jsonPath("$.udfn30").value(DEFAULT_UDFN_30))
            .andExpect(jsonPath("$.udfn31").value(DEFAULT_UDFN_31))
            .andExpect(jsonPath("$.udfn32").value(DEFAULT_UDFN_32))
            .andExpect(jsonPath("$.udfn33").value(DEFAULT_UDFN_33))
            .andExpect(jsonPath("$.udfn34").value(DEFAULT_UDFN_34))
            .andExpect(jsonPath("$.udfn35").value(DEFAULT_UDFN_35))
            .andExpect(jsonPath("$.udfn36").value(DEFAULT_UDFN_36))
            .andExpect(jsonPath("$.udfn37").value(DEFAULT_UDFN_37))
            .andExpect(jsonPath("$.udfn38").value(DEFAULT_UDFN_38))
            .andExpect(jsonPath("$.udfn39").value(DEFAULT_UDFN_39))
            .andExpect(jsonPath("$.udfn40").value(DEFAULT_UDFN_40))
            .andExpect(jsonPath("$.udfd01").value(DEFAULT_UDFD_01.toString()))
            .andExpect(jsonPath("$.udfd02").value(DEFAULT_UDFD_02.toString()))
            .andExpect(jsonPath("$.udfd03").value(DEFAULT_UDFD_03.toString()))
            .andExpect(jsonPath("$.udfd04").value(DEFAULT_UDFD_04.toString()))
            .andExpect(jsonPath("$.udfd05").value(DEFAULT_UDFD_05.toString()))
            .andExpect(jsonPath("$.udfd06").value(DEFAULT_UDFD_06.toString()))
            .andExpect(jsonPath("$.udfd07").value(DEFAULT_UDFD_07.toString()))
            .andExpect(jsonPath("$.udfd08").value(DEFAULT_UDFD_08.toString()))
            .andExpect(jsonPath("$.udfd09").value(DEFAULT_UDFD_09.toString()))
            .andExpect(jsonPath("$.udfd10").value(DEFAULT_UDFD_10.toString()))
            .andExpect(jsonPath("$.insertActionInstanceId").value(DEFAULT_INSERT_ACTION_INSTANCE_ID))
            .andExpect(jsonPath("$.dmlSeqNo").value(DEFAULT_DML_SEQ_NO))
            .andExpect(jsonPath("$.businessDateCreated").value(DEFAULT_BUSINESS_DATE_CREATED.toString()))
            .andExpect(jsonPath("$.turndownYn").value(DEFAULT_TURNDOWN_YN))
            .andExpect(jsonPath("$.roomInstructions").value(DEFAULT_ROOM_INSTRUCTIONS))
            .andExpect(jsonPath("$.roomServiceTime").value(DEFAULT_ROOM_SERVICE_TIME))
            .andExpect(jsonPath("$.eventId").value(DEFAULT_EVENT_ID))
            .andExpect(jsonPath("$.revenueTypeCode").value(DEFAULT_REVENUE_TYPE_CODE))
            .andExpect(jsonPath("$.hurdle").value(DEFAULT_HURDLE))
            .andExpect(jsonPath("$.hurdleOverride").value(DEFAULT_HURDLE_OVERRIDE))
            .andExpect(jsonPath("$.rateableValue").value(DEFAULT_RATEABLE_VALUE))
            .andExpect(jsonPath("$.restrictionOverride").value(DEFAULT_RESTRICTION_OVERRIDE))
            .andExpect(jsonPath("$.yieldableYn").value(DEFAULT_YIELDABLE_YN))
            .andExpect(jsonPath("$.sguestFirstname").value(DEFAULT_SGUEST_FIRSTNAME))
            .andExpect(jsonPath("$.guestLastName").value(DEFAULT_GUEST_LAST_NAME))
            .andExpect(jsonPath("$.guestFirstName").value(DEFAULT_GUEST_FIRST_NAME))
            .andExpect(jsonPath("$.guestLastNameSdx").value(DEFAULT_GUEST_LAST_NAME_SDX))
            .andExpect(jsonPath("$.guestFirstNameSdx").value(DEFAULT_GUEST_FIRST_NAME_SDX))
            .andExpect(jsonPath("$.channel").value(DEFAULT_CHANNEL))
            .andExpect(jsonPath("$.shareSeqNo").value(DEFAULT_SHARE_SEQ_NO))
            .andExpect(jsonPath("$.guestSignature").value(DEFAULT_GUEST_SIGNATURE))
            .andExpect(jsonPath("$.extensionId").value(DEFAULT_EXTENSION_ID))
            .andExpect(jsonPath("$.resvContactId").value(DEFAULT_RESV_CONTACT_ID))
            .andExpect(jsonPath("$.billingContactId").value(DEFAULT_BILLING_CONTACT_ID))
            .andExpect(jsonPath("$.resInsertSource").value(DEFAULT_RES_INSERT_SOURCE))
            .andExpect(jsonPath("$.resInsertSourceType").value(DEFAULT_RES_INSERT_SOURCE_TYPE))
            .andExpect(jsonPath("$.masterShare").value(DEFAULT_MASTER_SHARE))
            .andExpect(jsonPath("$.registrationCardNo").value(DEFAULT_REGISTRATION_CARD_NO))
            .andExpect(jsonPath("$.tiad").value(DEFAULT_TIAD))
            .andExpect(jsonPath("$.purposeOfStay").value(DEFAULT_PURPOSE_OF_STAY))
            .andExpect(jsonPath("$.reinstateDate").value(DEFAULT_REINSTATE_DATE.toString()))
            .andExpect(jsonPath("$.purgeDate").value(DEFAULT_PURGE_DATE.toString()))
            .andExpect(jsonPath("$.lastSettleDate").value(DEFAULT_LAST_SETTLE_DATE.toString()))
            .andExpect(jsonPath("$.lastPeriodicFolioDate").value(DEFAULT_LAST_PERIODIC_FOLIO_DATE.toString()))
            .andExpect(jsonPath("$.periodicFolioFreq").value(DEFAULT_PERIODIC_FOLIO_FREQ))
            .andExpect(jsonPath("$.confirmationLegNo").value(DEFAULT_CONFIRMATION_LEG_NO))
            .andExpect(jsonPath("$.guestStatus").value(DEFAULT_GUEST_STATUS))
            .andExpect(jsonPath("$.guestType").value(DEFAULT_GUEST_TYPE))
            .andExpect(jsonPath("$.checkinDuration").value(DEFAULT_CHECKIN_DURATION))
            .andExpect(jsonPath("$.authorizerId").value(DEFAULT_AUTHORIZER_ID))
            .andExpect(jsonPath("$.lastOnlinePrintSeq").value(DEFAULT_LAST_ONLINE_PRINT_SEQ))
            .andExpect(jsonPath("$.entryPoint").value(DEFAULT_ENTRY_POINT))
            .andExpect(jsonPath("$.entryDate").value(DEFAULT_ENTRY_DATE.toString()))
            .andExpect(jsonPath("$.pseudoMemType").value(DEFAULT_PSEUDO_MEM_TYPE))
            .andExpect(jsonPath("$.pseudoMemTotalPoints").value(DEFAULT_PSEUDO_MEM_TOTAL_POINTS))
            .andExpect(jsonPath("$.folioText1").value(DEFAULT_FOLIO_TEXT_1))
            .andExpect(jsonPath("$.folioText2").value(DEFAULT_FOLIO_TEXT_2))
            .andExpect(jsonPath("$.compTypeCode").value(DEFAULT_COMP_TYPE_CODE))
            .andExpect(jsonPath("$.uniCardId").value(DEFAULT_UNI_CARD_ID))
            .andExpect(jsonPath("$.expCheckinresId").value(DEFAULT_EXP_CHECKINRES_ID))
            .andExpect(jsonPath("$.originalBeginDate").value(DEFAULT_ORIGINAL_BEGIN_DATE.toString()))
            .andExpect(jsonPath("$.ownerFfFlag").value(DEFAULT_OWNER_FF_FLAG))
            .andExpect(jsonPath("$.commissionPayoutTo").value(DEFAULT_COMMISSION_PAYOUT_TO))
            .andExpect(jsonPath("$.preChargingYn").value(DEFAULT_PRE_CHARGING_YN))
            .andExpect(jsonPath("$.postChargingYn").value(DEFAULT_POST_CHARGING_YN))
            .andExpect(jsonPath("$.postCoFlag").value(DEFAULT_POST_CO_FLAG))
            .andExpect(jsonPath("$.folioCloseDate").value(DEFAULT_FOLIO_CLOSE_DATE.toString()))
            .andExpect(jsonPath("$.scheduleCheckoutYn").value(DEFAULT_SCHEDULE_CHECKOUT_YN))
            .andExpect(jsonPath("$.customReference").value(DEFAULT_CUSTOM_REFERENCE))
            .andExpect(jsonPath("$.guaranteeCodePreCi").value(DEFAULT_GUARANTEE_CODE_PRE_CI))
            .andExpect(jsonPath("$.awardMembershipId").value(DEFAULT_AWARD_MEMBERSHIP_ID))
            .andExpect(jsonPath("$.esignedRegCardName").value(DEFAULT_ESIGNED_REG_CARD_NAME))
            .andExpect(jsonPath("$.statisticalRoomType").value(DEFAULT_STATISTICAL_ROOM_TYPE))
            .andExpect(jsonPath("$.statisticalRateTier").value(DEFAULT_STATISTICAL_RATE_TIER))
            .andExpect(jsonPath("$.ymCode").value(DEFAULT_YM_CODE))
            .andExpect(jsonPath("$.keyValidUntil").value(DEFAULT_KEY_VALID_UNTIL.toString()))
            .andExpect(jsonPath("$.preRegisteredYn").value(DEFAULT_PRE_REGISTERED_YN))
            .andExpect(jsonPath("$.taxRegistrationNo").value(DEFAULT_TAX_REGISTRATION_NO))
            .andExpect(jsonPath("$.visaNumber").value(DEFAULT_VISA_NUMBER))
            .andExpect(jsonPath("$.visaIssueDate").value(DEFAULT_VISA_ISSUE_DATE.toString()))
            .andExpect(jsonPath("$.visaExpirationDate").value(DEFAULT_VISA_EXPIRATION_DATE.toString()))
            .andExpect(jsonPath("$.taxNoOfStays").value(DEFAULT_TAX_NO_OF_STAYS))
            .andExpect(jsonPath("$.asbProratedYn").value(DEFAULT_ASB_PRORATED_YN))
            .andExpect(jsonPath("$.autoSettleDays").value(DEFAULT_AUTO_SETTLE_DAYS))
            .andExpect(jsonPath("$.autoSettleYn").value(DEFAULT_AUTO_SETTLE_YN))
            .andExpect(jsonPath("$.splitFromResvNameId").value(DEFAULT_SPLIT_FROM_RESV_NAME_ID))
            .andExpect(jsonPath("$.nextDestination").value(DEFAULT_NEXT_DESTINATION))
            .andExpect(jsonPath("$.dateOfArrivalInCountry").value(DEFAULT_DATE_OF_ARRIVAL_IN_COUNTRY.toString()))
            .andExpect(jsonPath("$.preArrReviewedDt").value(DEFAULT_PRE_ARR_REVIEWED_DT.toString()))
            .andExpect(jsonPath("$.preArrReviewedUser").value(DEFAULT_PRE_ARR_REVIEWED_USER))
            .andExpect(jsonPath("$.bonusCheckId").value(DEFAULT_BONUS_CHECK_ID))
            .andExpect(jsonPath("$.mobileAudioKeyYn").value(DEFAULT_MOBILE_AUDIO_KEY_YN))
            .andExpect(jsonPath("$.directBillVerifyResponse").value(DEFAULT_DIRECT_BILL_VERIFY_RESPONSE))
            .andExpect(jsonPath("$.addresseeNameId").value(DEFAULT_ADDRESSEE_NAME_ID))
            .andExpect(jsonPath("$.superSearchIndexText").value(DEFAULT_SUPER_SEARCH_INDEX_TEXT))
            .andExpect(jsonPath("$.autoCheckinYn").value(DEFAULT_AUTO_CHECKIN_YN))
            .andExpect(jsonPath("$.emailFolioYn").value(DEFAULT_EMAIL_FOLIO_YN))
            .andExpect(jsonPath("$.emailAddress").value(DEFAULT_EMAIL_ADDRESS))
            .andExpect(jsonPath("$.spgUpgradeConfirmedRoomtype").value(DEFAULT_SPG_UPGRADE_CONFIRMED_ROOMTYPE))
            .andExpect(jsonPath("$.spgUpgradeReasonCode").value(DEFAULT_SPG_UPGRADE_REASON_CODE))
            .andExpect(jsonPath("$.spgSuiteNightAwardStatus").value(DEFAULT_SPG_SUITE_NIGHT_AWARD_STATUS))
            .andExpect(jsonPath("$.spgDiscloseRoomTypeYn").value(DEFAULT_SPG_DISCLOSE_ROOM_TYPE_YN))
            .andExpect(jsonPath("$.amenityEligibleYn").value(DEFAULT_AMENITY_ELIGIBLE_YN))
            .andExpect(jsonPath("$.amenityLevelCode").value(DEFAULT_AMENITY_LEVEL_CODE))
            .andExpect(jsonPath("$.baseRateCurrencyCode").value(DEFAULT_BASE_RATE_CURRENCY_CODE))
            .andExpect(jsonPath("$.baseRateCode").value(DEFAULT_BASE_RATE_CODE))
            .andExpect(jsonPath("$.localBaseRateAmount").value(DEFAULT_LOCAL_BASE_RATE_AMOUNT))
            .andExpect(jsonPath("$.phoneDisplayNameYn").value(DEFAULT_PHONE_DISPLAY_NAME_YN))
            .andExpect(jsonPath("$.resortChargeNumber").value(DEFAULT_RESORT_CHARGE_NUMBER))
            .andExpect(jsonPath("$.mobileChkoutAllowed").value(DEFAULT_MOBILE_CHKOUT_ALLOWED))
            .andExpect(jsonPath("$.mobileViewFolioAllowed").value(DEFAULT_MOBILE_VIEW_FOLIO_ALLOWED))
            .andExpect(jsonPath("$.hkExpectedServiceTime").value(DEFAULT_HK_EXPECTED_SERVICE_TIME))
            .andExpect(jsonPath("$.eligibleForUpgradeYn").value(DEFAULT_ELIGIBLE_FOR_UPGRADE_YN))
            .andExpect(jsonPath("$.beginSystemDateTime").value(DEFAULT_BEGIN_SYSTEM_DATE_TIME.toString()))
            .andExpect(jsonPath("$.mobileCheckinAllowedYn").value(DEFAULT_MOBILE_CHECKIN_ALLOWED_YN))
            .andExpect(jsonPath("$.quoteId").value(DEFAULT_QUOTE_ID))
            .andExpect(jsonPath("$.manualCheckoutStatus").value(DEFAULT_MANUAL_CHECKOUT_STATUS))
            .andExpect(jsonPath("$.mobilePreferredCurrency").value(DEFAULT_MOBILE_PREFERRED_CURRENCY))
            .andExpect(jsonPath("$.mobileActionAlertIssued").value(DEFAULT_MOBILE_ACTION_ALERT_ISSUED.toString()))
            .andExpect(jsonPath("$.externalEfolioYn").value(DEFAULT_EXTERNAL_EFOLIO_YN))
            .andExpect(jsonPath("$.optInBatchFolYn").value(DEFAULT_OPT_IN_BATCH_FOL_YN))
            .andExpect(jsonPath("$.folioAddrElementId").value(DEFAULT_FOLIO_ADDR_ELEMENT_ID))
            .andExpect(jsonPath("$.operaEsignedRegCardYn").value(DEFAULT_OPERA_ESIGNED_REG_CARD_YN))
            .andExpect(jsonPath("$.resvGuid").value(DEFAULT_RESV_GUID))
            .andExpect(jsonPath("$.advanceCheckedInYn").value(DEFAULT_ADVANCE_CHECKED_IN_YN))
            .andExpect(jsonPath("$.expectedTimeOfReturn").value(DEFAULT_EXPECTED_TIME_OF_RETURN.toString()))
            .andExpect(jsonPath("$.etrComments").value(DEFAULT_ETR_COMMENTS))
            .andExpect(jsonPath("$.optedForCommYn").value(DEFAULT_OPTED_FOR_COMM_YN))
            .andExpect(jsonPath("$.creditLimitAutoPayAllowYn").value(DEFAULT_CREDIT_LIMIT_AUTO_PAY_ALLOW_YN));
    }

    @Test
    @Transactional
    void getNonExistingReservationName() throws Exception {
        // Get the reservationName
        restReservationNameMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingReservationName() throws Exception {
        // Initialize the database
        reservationNameRepository.saveAndFlush(reservationName);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationName
        ReservationName updatedReservationName = reservationNameRepository.findById(reservationName.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedReservationName are not directly saved in db
        em.detach(updatedReservationName);
        updatedReservationName
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .nameId(UPDATED_NAME_ID)
            .nameUsageType(UPDATED_NAME_USAGE_TYPE)
            .contactNameId(UPDATED_CONTACT_NAME_ID)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .resvStatus(UPDATED_RESV_STATUS)
            .commissionCode(UPDATED_COMMISSION_CODE)
            .addressId(UPDATED_ADDRESS_ID)
            .phoneId(UPDATED_PHONE_ID)
            .faxYn(UPDATED_FAX_YN)
            .mailYn(UPDATED_MAIL_YN)
            .printRateYn(UPDATED_PRINT_RATE_YN)
            .reportId(UPDATED_REPORT_ID)
            .resvNo(UPDATED_RESV_NO)
            .confirmationNo(UPDATED_CONFIRMATION_NO)
            .beginDate(UPDATED_BEGIN_DATE)
            .endDate(UPDATED_END_DATE)
            .faxId(UPDATED_FAX_ID)
            .emailId(UPDATED_EMAIL_ID)
            .emailYn(UPDATED_EMAIL_YN)
            .consumerYn(UPDATED_CONSUMER_YN)
            .creditCardId(UPDATED_CREDIT_CARD_ID)
            .financiallyResponsibleYn(UPDATED_FINANCIALLY_RESPONSIBLE_YN)
            .paymentMethod(UPDATED_PAYMENT_METHOD)
            .intermediaryYn(UPDATED_INTERMEDIARY_YN)
            .postingAllowedYn(UPDATED_POSTING_ALLOWED_YN)
            .displayColor(UPDATED_DISPLAY_COLOR)
            .actualCheckInDate(UPDATED_ACTUAL_CHECK_IN_DATE)
            .truncActualCheckInDate(UPDATED_TRUNC_ACTUAL_CHECK_IN_DATE)
            .actualCheckOutDate(UPDATED_ACTUAL_CHECK_OUT_DATE)
            .truncActualCheckOutDate(UPDATED_TRUNC_ACTUAL_CHECK_OUT_DATE)
            .creditLimit(UPDATED_CREDIT_LIMIT)
            .authorizedBy(UPDATED_AUTHORIZED_BY)
            .parentResvNameId(UPDATED_PARENT_RESV_NAME_ID)
            .cancellationNo(UPDATED_CANCELLATION_NO)
            .cancellationReasonCode(UPDATED_CANCELLATION_REASON_CODE)
            .cancellationReasonDesc(UPDATED_CANCELLATION_REASON_DESC)
            .arrivalTransportType(UPDATED_ARRIVAL_TRANSPORT_TYPE)
            .arrivalStationCode(UPDATED_ARRIVAL_STATION_CODE)
            .arrivalCarrierCode(UPDATED_ARRIVAL_CARRIER_CODE)
            .arrivalTransportCode(UPDATED_ARRIVAL_TRANSPORT_CODE)
            .arrivalDateTime(UPDATED_ARRIVAL_DATE_TIME)
            .arrivalEstimateTime(UPDATED_ARRIVAL_ESTIMATE_TIME)
            .arrivalTranportationYn(UPDATED_ARRIVAL_TRANPORTATION_YN)
            .arrivalComments(UPDATED_ARRIVAL_COMMENTS)
            .departureTransportType(UPDATED_DEPARTURE_TRANSPORT_TYPE)
            .departureStationCode(UPDATED_DEPARTURE_STATION_CODE)
            .departureCarrierCode(UPDATED_DEPARTURE_CARRIER_CODE)
            .departureTransportCode(UPDATED_DEPARTURE_TRANSPORT_CODE)
            .departureDateTime(UPDATED_DEPARTURE_DATE_TIME)
            .departureEstimateTime(UPDATED_DEPARTURE_ESTIMATE_TIME)
            .departureTransportationYn(UPDATED_DEPARTURE_TRANSPORTATION_YN)
            .departureComments(UPDATED_DEPARTURE_COMMENTS)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .guaranteeCode(UPDATED_GUARANTEE_CODE)
            .wlReasonDescription(UPDATED_WL_REASON_DESCRIPTION)
            .wlReasonCode(UPDATED_WL_REASON_CODE)
            .wlPriority(UPDATED_WL_PRIORITY)
            .doNotMoveRoom(UPDATED_DO_NOT_MOVE_ROOM)
            .externalReference(UPDATED_EXTERNAL_REFERENCE)
            .partyCode(UPDATED_PARTY_CODE)
            .walkinYn(UPDATED_WALKIN_YN)
            .originalEndDate(UPDATED_ORIGINAL_END_DATE)
            .approvalAmountCalcMethod(UPDATED_APPROVAL_AMOUNT_CALC_METHOD)
            .amountPercent(UPDATED_AMOUNT_PERCENT)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .taxExemptNo(UPDATED_TAX_EXEMPT_NO)
            .roomFeatures(UPDATED_ROOM_FEATURES)
            .wlTelephoneNo(UPDATED_WL_TELEPHONE_NO)
            .videoCheckoutYn(UPDATED_VIDEO_CHECKOUT_YN)
            .discountAmt(UPDATED_DISCOUNT_AMT)
            .discountPrcnt(UPDATED_DISCOUNT_PRCNT)
            .discountReasonCode(UPDATED_DISCOUNT_REASON_CODE)
            .commissionPaid(UPDATED_COMMISSION_PAID)
            .commissionHoldCode(UPDATED_COMMISSION_HOLD_CODE)
            .truncBeginDate(UPDATED_TRUNC_BEGIN_DATE)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .sguestName(UPDATED_SGUEST_NAME)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .udfc01(UPDATED_UDFC_01)
            .udfc02(UPDATED_UDFC_02)
            .udfc03(UPDATED_UDFC_03)
            .udfc04(UPDATED_UDFC_04)
            .udfc05(UPDATED_UDFC_05)
            .udfc06(UPDATED_UDFC_06)
            .udfc07(UPDATED_UDFC_07)
            .udfc08(UPDATED_UDFC_08)
            .udfc09(UPDATED_UDFC_09)
            .udfc10(UPDATED_UDFC_10)
            .udfc11(UPDATED_UDFC_11)
            .udfc12(UPDATED_UDFC_12)
            .udfc13(UPDATED_UDFC_13)
            .udfc14(UPDATED_UDFC_14)
            .udfc15(UPDATED_UDFC_15)
            .udfc16(UPDATED_UDFC_16)
            .udfc17(UPDATED_UDFC_17)
            .udfc18(UPDATED_UDFC_18)
            .udfc19(UPDATED_UDFC_19)
            .udfc20(UPDATED_UDFC_20)
            .udfc21(UPDATED_UDFC_21)
            .udfc22(UPDATED_UDFC_22)
            .udfc23(UPDATED_UDFC_23)
            .udfc24(UPDATED_UDFC_24)
            .udfc25(UPDATED_UDFC_25)
            .udfc26(UPDATED_UDFC_26)
            .udfc27(UPDATED_UDFC_27)
            .udfc28(UPDATED_UDFC_28)
            .udfc29(UPDATED_UDFC_29)
            .udfc30(UPDATED_UDFC_30)
            .udfc31(UPDATED_UDFC_31)
            .udfc32(UPDATED_UDFC_32)
            .udfc33(UPDATED_UDFC_33)
            .udfc34(UPDATED_UDFC_34)
            .udfc35(UPDATED_UDFC_35)
            .udfc36(UPDATED_UDFC_36)
            .udfc37(UPDATED_UDFC_37)
            .udfc38(UPDATED_UDFC_38)
            .udfc39(UPDATED_UDFC_39)
            .udfc40(UPDATED_UDFC_40)
            .udfn01(UPDATED_UDFN_01)
            .udfn02(UPDATED_UDFN_02)
            .udfn03(UPDATED_UDFN_03)
            .udfn04(UPDATED_UDFN_04)
            .udfn05(UPDATED_UDFN_05)
            .udfn06(UPDATED_UDFN_06)
            .udfn07(UPDATED_UDFN_07)
            .udfn08(UPDATED_UDFN_08)
            .udfn09(UPDATED_UDFN_09)
            .udfn10(UPDATED_UDFN_10)
            .udfn11(UPDATED_UDFN_11)
            .udfn12(UPDATED_UDFN_12)
            .udfn13(UPDATED_UDFN_13)
            .udfn14(UPDATED_UDFN_14)
            .udfn15(UPDATED_UDFN_15)
            .udfn16(UPDATED_UDFN_16)
            .udfn17(UPDATED_UDFN_17)
            .udfn18(UPDATED_UDFN_18)
            .udfn19(UPDATED_UDFN_19)
            .udfn20(UPDATED_UDFN_20)
            .udfn21(UPDATED_UDFN_21)
            .udfn22(UPDATED_UDFN_22)
            .udfn23(UPDATED_UDFN_23)
            .udfn24(UPDATED_UDFN_24)
            .udfn25(UPDATED_UDFN_25)
            .udfn26(UPDATED_UDFN_26)
            .udfn27(UPDATED_UDFN_27)
            .udfn28(UPDATED_UDFN_28)
            .udfn29(UPDATED_UDFN_29)
            .udfn30(UPDATED_UDFN_30)
            .udfn31(UPDATED_UDFN_31)
            .udfn32(UPDATED_UDFN_32)
            .udfn33(UPDATED_UDFN_33)
            .udfn34(UPDATED_UDFN_34)
            .udfn35(UPDATED_UDFN_35)
            .udfn36(UPDATED_UDFN_36)
            .udfn37(UPDATED_UDFN_37)
            .udfn38(UPDATED_UDFN_38)
            .udfn39(UPDATED_UDFN_39)
            .udfn40(UPDATED_UDFN_40)
            .udfd01(UPDATED_UDFD_01)
            .udfd02(UPDATED_UDFD_02)
            .udfd03(UPDATED_UDFD_03)
            .udfd04(UPDATED_UDFD_04)
            .udfd05(UPDATED_UDFD_05)
            .udfd06(UPDATED_UDFD_06)
            .udfd07(UPDATED_UDFD_07)
            .udfd08(UPDATED_UDFD_08)
            .udfd09(UPDATED_UDFD_09)
            .udfd10(UPDATED_UDFD_10)
            .insertActionInstanceId(UPDATED_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(UPDATED_DML_SEQ_NO)
            .businessDateCreated(UPDATED_BUSINESS_DATE_CREATED)
            .turndownYn(UPDATED_TURNDOWN_YN)
            .roomInstructions(UPDATED_ROOM_INSTRUCTIONS)
            .roomServiceTime(UPDATED_ROOM_SERVICE_TIME)
            .eventId(UPDATED_EVENT_ID)
            .revenueTypeCode(UPDATED_REVENUE_TYPE_CODE)
            .hurdle(UPDATED_HURDLE)
            .hurdleOverride(UPDATED_HURDLE_OVERRIDE)
            .rateableValue(UPDATED_RATEABLE_VALUE)
            .restrictionOverride(UPDATED_RESTRICTION_OVERRIDE)
            .yieldableYn(UPDATED_YIELDABLE_YN)
            .sguestFirstname(UPDATED_SGUEST_FIRSTNAME)
            .guestLastName(UPDATED_GUEST_LAST_NAME)
            .guestFirstName(UPDATED_GUEST_FIRST_NAME)
            .guestLastNameSdx(UPDATED_GUEST_LAST_NAME_SDX)
            .guestFirstNameSdx(UPDATED_GUEST_FIRST_NAME_SDX)
            .channel(UPDATED_CHANNEL)
            .shareSeqNo(UPDATED_SHARE_SEQ_NO)
            .guestSignature(UPDATED_GUEST_SIGNATURE)
            .extensionId(UPDATED_EXTENSION_ID)
            .resvContactId(UPDATED_RESV_CONTACT_ID)
            .billingContactId(UPDATED_BILLING_CONTACT_ID)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .resInsertSourceType(UPDATED_RES_INSERT_SOURCE_TYPE)
            .masterShare(UPDATED_MASTER_SHARE)
            .registrationCardNo(UPDATED_REGISTRATION_CARD_NO)
            .tiad(UPDATED_TIAD)
            .purposeOfStay(UPDATED_PURPOSE_OF_STAY)
            .reinstateDate(UPDATED_REINSTATE_DATE)
            .purgeDate(UPDATED_PURGE_DATE)
            .lastSettleDate(UPDATED_LAST_SETTLE_DATE)
            .lastPeriodicFolioDate(UPDATED_LAST_PERIODIC_FOLIO_DATE)
            .periodicFolioFreq(UPDATED_PERIODIC_FOLIO_FREQ)
            .confirmationLegNo(UPDATED_CONFIRMATION_LEG_NO)
            .guestStatus(UPDATED_GUEST_STATUS)
            .guestType(UPDATED_GUEST_TYPE)
            .checkinDuration(UPDATED_CHECKIN_DURATION)
            .authorizerId(UPDATED_AUTHORIZER_ID)
            .lastOnlinePrintSeq(UPDATED_LAST_ONLINE_PRINT_SEQ)
            .entryPoint(UPDATED_ENTRY_POINT)
            .entryDate(UPDATED_ENTRY_DATE)
            .pseudoMemType(UPDATED_PSEUDO_MEM_TYPE)
            .pseudoMemTotalPoints(UPDATED_PSEUDO_MEM_TOTAL_POINTS)
            .folioText1(UPDATED_FOLIO_TEXT_1)
            .folioText2(UPDATED_FOLIO_TEXT_2)
            .compTypeCode(UPDATED_COMP_TYPE_CODE)
            .uniCardId(UPDATED_UNI_CARD_ID)
            .expCheckinresId(UPDATED_EXP_CHECKINRES_ID)
            .originalBeginDate(UPDATED_ORIGINAL_BEGIN_DATE)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .commissionPayoutTo(UPDATED_COMMISSION_PAYOUT_TO)
            .preChargingYn(UPDATED_PRE_CHARGING_YN)
            .postChargingYn(UPDATED_POST_CHARGING_YN)
            .postCoFlag(UPDATED_POST_CO_FLAG)
            .folioCloseDate(UPDATED_FOLIO_CLOSE_DATE)
            .scheduleCheckoutYn(UPDATED_SCHEDULE_CHECKOUT_YN)
            .customReference(UPDATED_CUSTOM_REFERENCE)
            .guaranteeCodePreCi(UPDATED_GUARANTEE_CODE_PRE_CI)
            .awardMembershipId(UPDATED_AWARD_MEMBERSHIP_ID)
            .esignedRegCardName(UPDATED_ESIGNED_REG_CARD_NAME)
            .statisticalRoomType(UPDATED_STATISTICAL_ROOM_TYPE)
            .statisticalRateTier(UPDATED_STATISTICAL_RATE_TIER)
            .ymCode(UPDATED_YM_CODE)
            .keyValidUntil(UPDATED_KEY_VALID_UNTIL)
            .preRegisteredYn(UPDATED_PRE_REGISTERED_YN)
            .taxRegistrationNo(UPDATED_TAX_REGISTRATION_NO)
            .visaNumber(UPDATED_VISA_NUMBER)
            .visaIssueDate(UPDATED_VISA_ISSUE_DATE)
            .visaExpirationDate(UPDATED_VISA_EXPIRATION_DATE)
            .taxNoOfStays(UPDATED_TAX_NO_OF_STAYS)
            .asbProratedYn(UPDATED_ASB_PRORATED_YN)
            .autoSettleDays(UPDATED_AUTO_SETTLE_DAYS)
            .autoSettleYn(UPDATED_AUTO_SETTLE_YN)
            .splitFromResvNameId(UPDATED_SPLIT_FROM_RESV_NAME_ID)
            .nextDestination(UPDATED_NEXT_DESTINATION)
            .dateOfArrivalInCountry(UPDATED_DATE_OF_ARRIVAL_IN_COUNTRY)
            .preArrReviewedDt(UPDATED_PRE_ARR_REVIEWED_DT)
            .preArrReviewedUser(UPDATED_PRE_ARR_REVIEWED_USER)
            .bonusCheckId(UPDATED_BONUS_CHECK_ID)
            .mobileAudioKeyYn(UPDATED_MOBILE_AUDIO_KEY_YN)
            .directBillVerifyResponse(UPDATED_DIRECT_BILL_VERIFY_RESPONSE)
            .addresseeNameId(UPDATED_ADDRESSEE_NAME_ID)
            .superSearchIndexText(UPDATED_SUPER_SEARCH_INDEX_TEXT)
            .autoCheckinYn(UPDATED_AUTO_CHECKIN_YN)
            .emailFolioYn(UPDATED_EMAIL_FOLIO_YN)
            .emailAddress(UPDATED_EMAIL_ADDRESS)
            .spgUpgradeConfirmedRoomtype(UPDATED_SPG_UPGRADE_CONFIRMED_ROOMTYPE)
            .spgUpgradeReasonCode(UPDATED_SPG_UPGRADE_REASON_CODE)
            .spgSuiteNightAwardStatus(UPDATED_SPG_SUITE_NIGHT_AWARD_STATUS)
            .spgDiscloseRoomTypeYn(UPDATED_SPG_DISCLOSE_ROOM_TYPE_YN)
            .amenityEligibleYn(UPDATED_AMENITY_ELIGIBLE_YN)
            .amenityLevelCode(UPDATED_AMENITY_LEVEL_CODE)
            .baseRateCurrencyCode(UPDATED_BASE_RATE_CURRENCY_CODE)
            .baseRateCode(UPDATED_BASE_RATE_CODE)
            .localBaseRateAmount(UPDATED_LOCAL_BASE_RATE_AMOUNT)
            .phoneDisplayNameYn(UPDATED_PHONE_DISPLAY_NAME_YN)
            .resortChargeNumber(UPDATED_RESORT_CHARGE_NUMBER)
            .mobileChkoutAllowed(UPDATED_MOBILE_CHKOUT_ALLOWED)
            .mobileViewFolioAllowed(UPDATED_MOBILE_VIEW_FOLIO_ALLOWED)
            .hkExpectedServiceTime(UPDATED_HK_EXPECTED_SERVICE_TIME)
            .eligibleForUpgradeYn(UPDATED_ELIGIBLE_FOR_UPGRADE_YN)
            .beginSystemDateTime(UPDATED_BEGIN_SYSTEM_DATE_TIME)
            .mobileCheckinAllowedYn(UPDATED_MOBILE_CHECKIN_ALLOWED_YN)
            .quoteId(UPDATED_QUOTE_ID)
            .manualCheckoutStatus(UPDATED_MANUAL_CHECKOUT_STATUS)
            .mobilePreferredCurrency(UPDATED_MOBILE_PREFERRED_CURRENCY)
            .mobileActionAlertIssued(UPDATED_MOBILE_ACTION_ALERT_ISSUED)
            .externalEfolioYn(UPDATED_EXTERNAL_EFOLIO_YN)
            .optInBatchFolYn(UPDATED_OPT_IN_BATCH_FOL_YN)
            .folioAddrElementId(UPDATED_FOLIO_ADDR_ELEMENT_ID)
            .operaEsignedRegCardYn(UPDATED_OPERA_ESIGNED_REG_CARD_YN)
            .resvGuid(UPDATED_RESV_GUID)
            .advanceCheckedInYn(UPDATED_ADVANCE_CHECKED_IN_YN)
            .expectedTimeOfReturn(UPDATED_EXPECTED_TIME_OF_RETURN)
            .etrComments(UPDATED_ETR_COMMENTS)
            .optedForCommYn(UPDATED_OPTED_FOR_COMM_YN)
            .creditLimitAutoPayAllowYn(UPDATED_CREDIT_LIMIT_AUTO_PAY_ALLOW_YN);

        restReservationNameMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedReservationName.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedReservationName))
            )
            .andExpect(status().isOk());

        // Validate the ReservationName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedReservationNameToMatchAllProperties(updatedReservationName);
    }

    @Test
    @Transactional
    void putNonExistingReservationName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationName.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReservationNameMockMvc
            .perform(
                put(ENTITY_API_URL_ID, reservationName.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reservationName))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchReservationName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationName.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationNameMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reservationName))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamReservationName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationName.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationNameMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationName)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReservationName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateReservationNameWithPatch() throws Exception {
        // Initialize the database
        reservationNameRepository.saveAndFlush(reservationName);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationName using partial update
        ReservationName partialUpdatedReservationName = new ReservationName();
        partialUpdatedReservationName.setId(reservationName.getId());

        partialUpdatedReservationName
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .nameId(UPDATED_NAME_ID)
            .addressId(UPDATED_ADDRESS_ID)
            .mailYn(UPDATED_MAIL_YN)
            .printRateYn(UPDATED_PRINT_RATE_YN)
            .reportId(UPDATED_REPORT_ID)
            .resvNo(UPDATED_RESV_NO)
            .beginDate(UPDATED_BEGIN_DATE)
            .endDate(UPDATED_END_DATE)
            .emailYn(UPDATED_EMAIL_YN)
            .financiallyResponsibleYn(UPDATED_FINANCIALLY_RESPONSIBLE_YN)
            .paymentMethod(UPDATED_PAYMENT_METHOD)
            .postingAllowedYn(UPDATED_POSTING_ALLOWED_YN)
            .actualCheckInDate(UPDATED_ACTUAL_CHECK_IN_DATE)
            .truncActualCheckOutDate(UPDATED_TRUNC_ACTUAL_CHECK_OUT_DATE)
            .authorizedBy(UPDATED_AUTHORIZED_BY)
            .cancellationReasonCode(UPDATED_CANCELLATION_REASON_CODE)
            .cancellationReasonDesc(UPDATED_CANCELLATION_REASON_DESC)
            .arrivalStationCode(UPDATED_ARRIVAL_STATION_CODE)
            .arrivalTransportCode(UPDATED_ARRIVAL_TRANSPORT_CODE)
            .arrivalEstimateTime(UPDATED_ARRIVAL_ESTIMATE_TIME)
            .departureStationCode(UPDATED_DEPARTURE_STATION_CODE)
            .departureCarrierCode(UPDATED_DEPARTURE_CARRIER_CODE)
            .departureTransportCode(UPDATED_DEPARTURE_TRANSPORT_CODE)
            .departureDateTime(UPDATED_DEPARTURE_DATE_TIME)
            .departureComments(UPDATED_DEPARTURE_COMMENTS)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .wlPriority(UPDATED_WL_PRIORITY)
            .partyCode(UPDATED_PARTY_CODE)
            .walkinYn(UPDATED_WALKIN_YN)
            .originalEndDate(UPDATED_ORIGINAL_END_DATE)
            .approvalAmountCalcMethod(UPDATED_APPROVAL_AMOUNT_CALC_METHOD)
            .amountPercent(UPDATED_AMOUNT_PERCENT)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .taxExemptNo(UPDATED_TAX_EXEMPT_NO)
            .roomFeatures(UPDATED_ROOM_FEATURES)
            .wlTelephoneNo(UPDATED_WL_TELEPHONE_NO)
            .discountAmt(UPDATED_DISCOUNT_AMT)
            .discountReasonCode(UPDATED_DISCOUNT_REASON_CODE)
            .truncBeginDate(UPDATED_TRUNC_BEGIN_DATE)
            .sguestName(UPDATED_SGUEST_NAME)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .udfc03(UPDATED_UDFC_03)
            .udfc04(UPDATED_UDFC_04)
            .udfc05(UPDATED_UDFC_05)
            .udfc07(UPDATED_UDFC_07)
            .udfc09(UPDATED_UDFC_09)
            .udfc14(UPDATED_UDFC_14)
            .udfc16(UPDATED_UDFC_16)
            .udfc18(UPDATED_UDFC_18)
            .udfc19(UPDATED_UDFC_19)
            .udfc23(UPDATED_UDFC_23)
            .udfc25(UPDATED_UDFC_25)
            .udfc26(UPDATED_UDFC_26)
            .udfc27(UPDATED_UDFC_27)
            .udfc28(UPDATED_UDFC_28)
            .udfc29(UPDATED_UDFC_29)
            .udfc32(UPDATED_UDFC_32)
            .udfc40(UPDATED_UDFC_40)
            .udfn01(UPDATED_UDFN_01)
            .udfn02(UPDATED_UDFN_02)
            .udfn03(UPDATED_UDFN_03)
            .udfn04(UPDATED_UDFN_04)
            .udfn08(UPDATED_UDFN_08)
            .udfn09(UPDATED_UDFN_09)
            .udfn11(UPDATED_UDFN_11)
            .udfn12(UPDATED_UDFN_12)
            .udfn13(UPDATED_UDFN_13)
            .udfn15(UPDATED_UDFN_15)
            .udfn17(UPDATED_UDFN_17)
            .udfn19(UPDATED_UDFN_19)
            .udfn20(UPDATED_UDFN_20)
            .udfn22(UPDATED_UDFN_22)
            .udfn24(UPDATED_UDFN_24)
            .udfn25(UPDATED_UDFN_25)
            .udfn26(UPDATED_UDFN_26)
            .udfn27(UPDATED_UDFN_27)
            .udfn33(UPDATED_UDFN_33)
            .udfn34(UPDATED_UDFN_34)
            .udfn38(UPDATED_UDFN_38)
            .udfn40(UPDATED_UDFN_40)
            .udfd03(UPDATED_UDFD_03)
            .udfd06(UPDATED_UDFD_06)
            .udfd07(UPDATED_UDFD_07)
            .udfd09(UPDATED_UDFD_09)
            .insertActionInstanceId(UPDATED_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(UPDATED_DML_SEQ_NO)
            .businessDateCreated(UPDATED_BUSINESS_DATE_CREATED)
            .roomServiceTime(UPDATED_ROOM_SERVICE_TIME)
            .revenueTypeCode(UPDATED_REVENUE_TYPE_CODE)
            .hurdle(UPDATED_HURDLE)
            .restrictionOverride(UPDATED_RESTRICTION_OVERRIDE)
            .guestFirstName(UPDATED_GUEST_FIRST_NAME)
            .channel(UPDATED_CHANNEL)
            .guestSignature(UPDATED_GUEST_SIGNATURE)
            .extensionId(UPDATED_EXTENSION_ID)
            .resvContactId(UPDATED_RESV_CONTACT_ID)
            .billingContactId(UPDATED_BILLING_CONTACT_ID)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .tiad(UPDATED_TIAD)
            .purposeOfStay(UPDATED_PURPOSE_OF_STAY)
            .lastOnlinePrintSeq(UPDATED_LAST_ONLINE_PRINT_SEQ)
            .entryPoint(UPDATED_ENTRY_POINT)
            .pseudoMemType(UPDATED_PSEUDO_MEM_TYPE)
            .pseudoMemTotalPoints(UPDATED_PSEUDO_MEM_TOTAL_POINTS)
            .compTypeCode(UPDATED_COMP_TYPE_CODE)
            .originalBeginDate(UPDATED_ORIGINAL_BEGIN_DATE)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .postChargingYn(UPDATED_POST_CHARGING_YN)
            .postCoFlag(UPDATED_POST_CO_FLAG)
            .scheduleCheckoutYn(UPDATED_SCHEDULE_CHECKOUT_YN)
            .guaranteeCodePreCi(UPDATED_GUARANTEE_CODE_PRE_CI)
            .awardMembershipId(UPDATED_AWARD_MEMBERSHIP_ID)
            .esignedRegCardName(UPDATED_ESIGNED_REG_CARD_NAME)
            .statisticalRateTier(UPDATED_STATISTICAL_RATE_TIER)
            .ymCode(UPDATED_YM_CODE)
            .preRegisteredYn(UPDATED_PRE_REGISTERED_YN)
            .visaIssueDate(UPDATED_VISA_ISSUE_DATE)
            .asbProratedYn(UPDATED_ASB_PRORATED_YN)
            .autoSettleDays(UPDATED_AUTO_SETTLE_DAYS)
            .autoSettleYn(UPDATED_AUTO_SETTLE_YN)
            .splitFromResvNameId(UPDATED_SPLIT_FROM_RESV_NAME_ID)
            .preArrReviewedDt(UPDATED_PRE_ARR_REVIEWED_DT)
            .bonusCheckId(UPDATED_BONUS_CHECK_ID)
            .mobileAudioKeyYn(UPDATED_MOBILE_AUDIO_KEY_YN)
            .addresseeNameId(UPDATED_ADDRESSEE_NAME_ID)
            .superSearchIndexText(UPDATED_SUPER_SEARCH_INDEX_TEXT)
            .autoCheckinYn(UPDATED_AUTO_CHECKIN_YN)
            .emailFolioYn(UPDATED_EMAIL_FOLIO_YN)
            .emailAddress(UPDATED_EMAIL_ADDRESS)
            .spgUpgradeReasonCode(UPDATED_SPG_UPGRADE_REASON_CODE)
            .amenityEligibleYn(UPDATED_AMENITY_ELIGIBLE_YN)
            .amenityLevelCode(UPDATED_AMENITY_LEVEL_CODE)
            .baseRateCode(UPDATED_BASE_RATE_CODE)
            .resortChargeNumber(UPDATED_RESORT_CHARGE_NUMBER)
            .mobileChkoutAllowed(UPDATED_MOBILE_CHKOUT_ALLOWED)
            .hkExpectedServiceTime(UPDATED_HK_EXPECTED_SERVICE_TIME)
            .eligibleForUpgradeYn(UPDATED_ELIGIBLE_FOR_UPGRADE_YN)
            .mobileCheckinAllowedYn(UPDATED_MOBILE_CHECKIN_ALLOWED_YN)
            .manualCheckoutStatus(UPDATED_MANUAL_CHECKOUT_STATUS)
            .mobilePreferredCurrency(UPDATED_MOBILE_PREFERRED_CURRENCY)
            .resvGuid(UPDATED_RESV_GUID)
            .advanceCheckedInYn(UPDATED_ADVANCE_CHECKED_IN_YN)
            .optedForCommYn(UPDATED_OPTED_FOR_COMM_YN)
            .creditLimitAutoPayAllowYn(UPDATED_CREDIT_LIMIT_AUTO_PAY_ALLOW_YN);

        restReservationNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReservationName.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReservationName))
            )
            .andExpect(status().isOk());

        // Validate the ReservationName in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReservationNameUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedReservationName, reservationName),
            getPersistedReservationName(reservationName)
        );
    }

    @Test
    @Transactional
    void fullUpdateReservationNameWithPatch() throws Exception {
        // Initialize the database
        reservationNameRepository.saveAndFlush(reservationName);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationName using partial update
        ReservationName partialUpdatedReservationName = new ReservationName();
        partialUpdatedReservationName.setId(reservationName.getId());

        partialUpdatedReservationName
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .nameId(UPDATED_NAME_ID)
            .nameUsageType(UPDATED_NAME_USAGE_TYPE)
            .contactNameId(UPDATED_CONTACT_NAME_ID)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .resvStatus(UPDATED_RESV_STATUS)
            .commissionCode(UPDATED_COMMISSION_CODE)
            .addressId(UPDATED_ADDRESS_ID)
            .phoneId(UPDATED_PHONE_ID)
            .faxYn(UPDATED_FAX_YN)
            .mailYn(UPDATED_MAIL_YN)
            .printRateYn(UPDATED_PRINT_RATE_YN)
            .reportId(UPDATED_REPORT_ID)
            .resvNo(UPDATED_RESV_NO)
            .confirmationNo(UPDATED_CONFIRMATION_NO)
            .beginDate(UPDATED_BEGIN_DATE)
            .endDate(UPDATED_END_DATE)
            .faxId(UPDATED_FAX_ID)
            .emailId(UPDATED_EMAIL_ID)
            .emailYn(UPDATED_EMAIL_YN)
            .consumerYn(UPDATED_CONSUMER_YN)
            .creditCardId(UPDATED_CREDIT_CARD_ID)
            .financiallyResponsibleYn(UPDATED_FINANCIALLY_RESPONSIBLE_YN)
            .paymentMethod(UPDATED_PAYMENT_METHOD)
            .intermediaryYn(UPDATED_INTERMEDIARY_YN)
            .postingAllowedYn(UPDATED_POSTING_ALLOWED_YN)
            .displayColor(UPDATED_DISPLAY_COLOR)
            .actualCheckInDate(UPDATED_ACTUAL_CHECK_IN_DATE)
            .truncActualCheckInDate(UPDATED_TRUNC_ACTUAL_CHECK_IN_DATE)
            .actualCheckOutDate(UPDATED_ACTUAL_CHECK_OUT_DATE)
            .truncActualCheckOutDate(UPDATED_TRUNC_ACTUAL_CHECK_OUT_DATE)
            .creditLimit(UPDATED_CREDIT_LIMIT)
            .authorizedBy(UPDATED_AUTHORIZED_BY)
            .parentResvNameId(UPDATED_PARENT_RESV_NAME_ID)
            .cancellationNo(UPDATED_CANCELLATION_NO)
            .cancellationReasonCode(UPDATED_CANCELLATION_REASON_CODE)
            .cancellationReasonDesc(UPDATED_CANCELLATION_REASON_DESC)
            .arrivalTransportType(UPDATED_ARRIVAL_TRANSPORT_TYPE)
            .arrivalStationCode(UPDATED_ARRIVAL_STATION_CODE)
            .arrivalCarrierCode(UPDATED_ARRIVAL_CARRIER_CODE)
            .arrivalTransportCode(UPDATED_ARRIVAL_TRANSPORT_CODE)
            .arrivalDateTime(UPDATED_ARRIVAL_DATE_TIME)
            .arrivalEstimateTime(UPDATED_ARRIVAL_ESTIMATE_TIME)
            .arrivalTranportationYn(UPDATED_ARRIVAL_TRANPORTATION_YN)
            .arrivalComments(UPDATED_ARRIVAL_COMMENTS)
            .departureTransportType(UPDATED_DEPARTURE_TRANSPORT_TYPE)
            .departureStationCode(UPDATED_DEPARTURE_STATION_CODE)
            .departureCarrierCode(UPDATED_DEPARTURE_CARRIER_CODE)
            .departureTransportCode(UPDATED_DEPARTURE_TRANSPORT_CODE)
            .departureDateTime(UPDATED_DEPARTURE_DATE_TIME)
            .departureEstimateTime(UPDATED_DEPARTURE_ESTIMATE_TIME)
            .departureTransportationYn(UPDATED_DEPARTURE_TRANSPORTATION_YN)
            .departureComments(UPDATED_DEPARTURE_COMMENTS)
            .cancellationDate(UPDATED_CANCELLATION_DATE)
            .guaranteeCode(UPDATED_GUARANTEE_CODE)
            .wlReasonDescription(UPDATED_WL_REASON_DESCRIPTION)
            .wlReasonCode(UPDATED_WL_REASON_CODE)
            .wlPriority(UPDATED_WL_PRIORITY)
            .doNotMoveRoom(UPDATED_DO_NOT_MOVE_ROOM)
            .externalReference(UPDATED_EXTERNAL_REFERENCE)
            .partyCode(UPDATED_PARTY_CODE)
            .walkinYn(UPDATED_WALKIN_YN)
            .originalEndDate(UPDATED_ORIGINAL_END_DATE)
            .approvalAmountCalcMethod(UPDATED_APPROVAL_AMOUNT_CALC_METHOD)
            .amountPercent(UPDATED_AMOUNT_PERCENT)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .taxExemptNo(UPDATED_TAX_EXEMPT_NO)
            .roomFeatures(UPDATED_ROOM_FEATURES)
            .wlTelephoneNo(UPDATED_WL_TELEPHONE_NO)
            .videoCheckoutYn(UPDATED_VIDEO_CHECKOUT_YN)
            .discountAmt(UPDATED_DISCOUNT_AMT)
            .discountPrcnt(UPDATED_DISCOUNT_PRCNT)
            .discountReasonCode(UPDATED_DISCOUNT_REASON_CODE)
            .commissionPaid(UPDATED_COMMISSION_PAID)
            .commissionHoldCode(UPDATED_COMMISSION_HOLD_CODE)
            .truncBeginDate(UPDATED_TRUNC_BEGIN_DATE)
            .truncEndDate(UPDATED_TRUNC_END_DATE)
            .sguestName(UPDATED_SGUEST_NAME)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .udfc01(UPDATED_UDFC_01)
            .udfc02(UPDATED_UDFC_02)
            .udfc03(UPDATED_UDFC_03)
            .udfc04(UPDATED_UDFC_04)
            .udfc05(UPDATED_UDFC_05)
            .udfc06(UPDATED_UDFC_06)
            .udfc07(UPDATED_UDFC_07)
            .udfc08(UPDATED_UDFC_08)
            .udfc09(UPDATED_UDFC_09)
            .udfc10(UPDATED_UDFC_10)
            .udfc11(UPDATED_UDFC_11)
            .udfc12(UPDATED_UDFC_12)
            .udfc13(UPDATED_UDFC_13)
            .udfc14(UPDATED_UDFC_14)
            .udfc15(UPDATED_UDFC_15)
            .udfc16(UPDATED_UDFC_16)
            .udfc17(UPDATED_UDFC_17)
            .udfc18(UPDATED_UDFC_18)
            .udfc19(UPDATED_UDFC_19)
            .udfc20(UPDATED_UDFC_20)
            .udfc21(UPDATED_UDFC_21)
            .udfc22(UPDATED_UDFC_22)
            .udfc23(UPDATED_UDFC_23)
            .udfc24(UPDATED_UDFC_24)
            .udfc25(UPDATED_UDFC_25)
            .udfc26(UPDATED_UDFC_26)
            .udfc27(UPDATED_UDFC_27)
            .udfc28(UPDATED_UDFC_28)
            .udfc29(UPDATED_UDFC_29)
            .udfc30(UPDATED_UDFC_30)
            .udfc31(UPDATED_UDFC_31)
            .udfc32(UPDATED_UDFC_32)
            .udfc33(UPDATED_UDFC_33)
            .udfc34(UPDATED_UDFC_34)
            .udfc35(UPDATED_UDFC_35)
            .udfc36(UPDATED_UDFC_36)
            .udfc37(UPDATED_UDFC_37)
            .udfc38(UPDATED_UDFC_38)
            .udfc39(UPDATED_UDFC_39)
            .udfc40(UPDATED_UDFC_40)
            .udfn01(UPDATED_UDFN_01)
            .udfn02(UPDATED_UDFN_02)
            .udfn03(UPDATED_UDFN_03)
            .udfn04(UPDATED_UDFN_04)
            .udfn05(UPDATED_UDFN_05)
            .udfn06(UPDATED_UDFN_06)
            .udfn07(UPDATED_UDFN_07)
            .udfn08(UPDATED_UDFN_08)
            .udfn09(UPDATED_UDFN_09)
            .udfn10(UPDATED_UDFN_10)
            .udfn11(UPDATED_UDFN_11)
            .udfn12(UPDATED_UDFN_12)
            .udfn13(UPDATED_UDFN_13)
            .udfn14(UPDATED_UDFN_14)
            .udfn15(UPDATED_UDFN_15)
            .udfn16(UPDATED_UDFN_16)
            .udfn17(UPDATED_UDFN_17)
            .udfn18(UPDATED_UDFN_18)
            .udfn19(UPDATED_UDFN_19)
            .udfn20(UPDATED_UDFN_20)
            .udfn21(UPDATED_UDFN_21)
            .udfn22(UPDATED_UDFN_22)
            .udfn23(UPDATED_UDFN_23)
            .udfn24(UPDATED_UDFN_24)
            .udfn25(UPDATED_UDFN_25)
            .udfn26(UPDATED_UDFN_26)
            .udfn27(UPDATED_UDFN_27)
            .udfn28(UPDATED_UDFN_28)
            .udfn29(UPDATED_UDFN_29)
            .udfn30(UPDATED_UDFN_30)
            .udfn31(UPDATED_UDFN_31)
            .udfn32(UPDATED_UDFN_32)
            .udfn33(UPDATED_UDFN_33)
            .udfn34(UPDATED_UDFN_34)
            .udfn35(UPDATED_UDFN_35)
            .udfn36(UPDATED_UDFN_36)
            .udfn37(UPDATED_UDFN_37)
            .udfn38(UPDATED_UDFN_38)
            .udfn39(UPDATED_UDFN_39)
            .udfn40(UPDATED_UDFN_40)
            .udfd01(UPDATED_UDFD_01)
            .udfd02(UPDATED_UDFD_02)
            .udfd03(UPDATED_UDFD_03)
            .udfd04(UPDATED_UDFD_04)
            .udfd05(UPDATED_UDFD_05)
            .udfd06(UPDATED_UDFD_06)
            .udfd07(UPDATED_UDFD_07)
            .udfd08(UPDATED_UDFD_08)
            .udfd09(UPDATED_UDFD_09)
            .udfd10(UPDATED_UDFD_10)
            .insertActionInstanceId(UPDATED_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(UPDATED_DML_SEQ_NO)
            .businessDateCreated(UPDATED_BUSINESS_DATE_CREATED)
            .turndownYn(UPDATED_TURNDOWN_YN)
            .roomInstructions(UPDATED_ROOM_INSTRUCTIONS)
            .roomServiceTime(UPDATED_ROOM_SERVICE_TIME)
            .eventId(UPDATED_EVENT_ID)
            .revenueTypeCode(UPDATED_REVENUE_TYPE_CODE)
            .hurdle(UPDATED_HURDLE)
            .hurdleOverride(UPDATED_HURDLE_OVERRIDE)
            .rateableValue(UPDATED_RATEABLE_VALUE)
            .restrictionOverride(UPDATED_RESTRICTION_OVERRIDE)
            .yieldableYn(UPDATED_YIELDABLE_YN)
            .sguestFirstname(UPDATED_SGUEST_FIRSTNAME)
            .guestLastName(UPDATED_GUEST_LAST_NAME)
            .guestFirstName(UPDATED_GUEST_FIRST_NAME)
            .guestLastNameSdx(UPDATED_GUEST_LAST_NAME_SDX)
            .guestFirstNameSdx(UPDATED_GUEST_FIRST_NAME_SDX)
            .channel(UPDATED_CHANNEL)
            .shareSeqNo(UPDATED_SHARE_SEQ_NO)
            .guestSignature(UPDATED_GUEST_SIGNATURE)
            .extensionId(UPDATED_EXTENSION_ID)
            .resvContactId(UPDATED_RESV_CONTACT_ID)
            .billingContactId(UPDATED_BILLING_CONTACT_ID)
            .resInsertSource(UPDATED_RES_INSERT_SOURCE)
            .resInsertSourceType(UPDATED_RES_INSERT_SOURCE_TYPE)
            .masterShare(UPDATED_MASTER_SHARE)
            .registrationCardNo(UPDATED_REGISTRATION_CARD_NO)
            .tiad(UPDATED_TIAD)
            .purposeOfStay(UPDATED_PURPOSE_OF_STAY)
            .reinstateDate(UPDATED_REINSTATE_DATE)
            .purgeDate(UPDATED_PURGE_DATE)
            .lastSettleDate(UPDATED_LAST_SETTLE_DATE)
            .lastPeriodicFolioDate(UPDATED_LAST_PERIODIC_FOLIO_DATE)
            .periodicFolioFreq(UPDATED_PERIODIC_FOLIO_FREQ)
            .confirmationLegNo(UPDATED_CONFIRMATION_LEG_NO)
            .guestStatus(UPDATED_GUEST_STATUS)
            .guestType(UPDATED_GUEST_TYPE)
            .checkinDuration(UPDATED_CHECKIN_DURATION)
            .authorizerId(UPDATED_AUTHORIZER_ID)
            .lastOnlinePrintSeq(UPDATED_LAST_ONLINE_PRINT_SEQ)
            .entryPoint(UPDATED_ENTRY_POINT)
            .entryDate(UPDATED_ENTRY_DATE)
            .pseudoMemType(UPDATED_PSEUDO_MEM_TYPE)
            .pseudoMemTotalPoints(UPDATED_PSEUDO_MEM_TOTAL_POINTS)
            .folioText1(UPDATED_FOLIO_TEXT_1)
            .folioText2(UPDATED_FOLIO_TEXT_2)
            .compTypeCode(UPDATED_COMP_TYPE_CODE)
            .uniCardId(UPDATED_UNI_CARD_ID)
            .expCheckinresId(UPDATED_EXP_CHECKINRES_ID)
            .originalBeginDate(UPDATED_ORIGINAL_BEGIN_DATE)
            .ownerFfFlag(UPDATED_OWNER_FF_FLAG)
            .commissionPayoutTo(UPDATED_COMMISSION_PAYOUT_TO)
            .preChargingYn(UPDATED_PRE_CHARGING_YN)
            .postChargingYn(UPDATED_POST_CHARGING_YN)
            .postCoFlag(UPDATED_POST_CO_FLAG)
            .folioCloseDate(UPDATED_FOLIO_CLOSE_DATE)
            .scheduleCheckoutYn(UPDATED_SCHEDULE_CHECKOUT_YN)
            .customReference(UPDATED_CUSTOM_REFERENCE)
            .guaranteeCodePreCi(UPDATED_GUARANTEE_CODE_PRE_CI)
            .awardMembershipId(UPDATED_AWARD_MEMBERSHIP_ID)
            .esignedRegCardName(UPDATED_ESIGNED_REG_CARD_NAME)
            .statisticalRoomType(UPDATED_STATISTICAL_ROOM_TYPE)
            .statisticalRateTier(UPDATED_STATISTICAL_RATE_TIER)
            .ymCode(UPDATED_YM_CODE)
            .keyValidUntil(UPDATED_KEY_VALID_UNTIL)
            .preRegisteredYn(UPDATED_PRE_REGISTERED_YN)
            .taxRegistrationNo(UPDATED_TAX_REGISTRATION_NO)
            .visaNumber(UPDATED_VISA_NUMBER)
            .visaIssueDate(UPDATED_VISA_ISSUE_DATE)
            .visaExpirationDate(UPDATED_VISA_EXPIRATION_DATE)
            .taxNoOfStays(UPDATED_TAX_NO_OF_STAYS)
            .asbProratedYn(UPDATED_ASB_PRORATED_YN)
            .autoSettleDays(UPDATED_AUTO_SETTLE_DAYS)
            .autoSettleYn(UPDATED_AUTO_SETTLE_YN)
            .splitFromResvNameId(UPDATED_SPLIT_FROM_RESV_NAME_ID)
            .nextDestination(UPDATED_NEXT_DESTINATION)
            .dateOfArrivalInCountry(UPDATED_DATE_OF_ARRIVAL_IN_COUNTRY)
            .preArrReviewedDt(UPDATED_PRE_ARR_REVIEWED_DT)
            .preArrReviewedUser(UPDATED_PRE_ARR_REVIEWED_USER)
            .bonusCheckId(UPDATED_BONUS_CHECK_ID)
            .mobileAudioKeyYn(UPDATED_MOBILE_AUDIO_KEY_YN)
            .directBillVerifyResponse(UPDATED_DIRECT_BILL_VERIFY_RESPONSE)
            .addresseeNameId(UPDATED_ADDRESSEE_NAME_ID)
            .superSearchIndexText(UPDATED_SUPER_SEARCH_INDEX_TEXT)
            .autoCheckinYn(UPDATED_AUTO_CHECKIN_YN)
            .emailFolioYn(UPDATED_EMAIL_FOLIO_YN)
            .emailAddress(UPDATED_EMAIL_ADDRESS)
            .spgUpgradeConfirmedRoomtype(UPDATED_SPG_UPGRADE_CONFIRMED_ROOMTYPE)
            .spgUpgradeReasonCode(UPDATED_SPG_UPGRADE_REASON_CODE)
            .spgSuiteNightAwardStatus(UPDATED_SPG_SUITE_NIGHT_AWARD_STATUS)
            .spgDiscloseRoomTypeYn(UPDATED_SPG_DISCLOSE_ROOM_TYPE_YN)
            .amenityEligibleYn(UPDATED_AMENITY_ELIGIBLE_YN)
            .amenityLevelCode(UPDATED_AMENITY_LEVEL_CODE)
            .baseRateCurrencyCode(UPDATED_BASE_RATE_CURRENCY_CODE)
            .baseRateCode(UPDATED_BASE_RATE_CODE)
            .localBaseRateAmount(UPDATED_LOCAL_BASE_RATE_AMOUNT)
            .phoneDisplayNameYn(UPDATED_PHONE_DISPLAY_NAME_YN)
            .resortChargeNumber(UPDATED_RESORT_CHARGE_NUMBER)
            .mobileChkoutAllowed(UPDATED_MOBILE_CHKOUT_ALLOWED)
            .mobileViewFolioAllowed(UPDATED_MOBILE_VIEW_FOLIO_ALLOWED)
            .hkExpectedServiceTime(UPDATED_HK_EXPECTED_SERVICE_TIME)
            .eligibleForUpgradeYn(UPDATED_ELIGIBLE_FOR_UPGRADE_YN)
            .beginSystemDateTime(UPDATED_BEGIN_SYSTEM_DATE_TIME)
            .mobileCheckinAllowedYn(UPDATED_MOBILE_CHECKIN_ALLOWED_YN)
            .quoteId(UPDATED_QUOTE_ID)
            .manualCheckoutStatus(UPDATED_MANUAL_CHECKOUT_STATUS)
            .mobilePreferredCurrency(UPDATED_MOBILE_PREFERRED_CURRENCY)
            .mobileActionAlertIssued(UPDATED_MOBILE_ACTION_ALERT_ISSUED)
            .externalEfolioYn(UPDATED_EXTERNAL_EFOLIO_YN)
            .optInBatchFolYn(UPDATED_OPT_IN_BATCH_FOL_YN)
            .folioAddrElementId(UPDATED_FOLIO_ADDR_ELEMENT_ID)
            .operaEsignedRegCardYn(UPDATED_OPERA_ESIGNED_REG_CARD_YN)
            .resvGuid(UPDATED_RESV_GUID)
            .advanceCheckedInYn(UPDATED_ADVANCE_CHECKED_IN_YN)
            .expectedTimeOfReturn(UPDATED_EXPECTED_TIME_OF_RETURN)
            .etrComments(UPDATED_ETR_COMMENTS)
            .optedForCommYn(UPDATED_OPTED_FOR_COMM_YN)
            .creditLimitAutoPayAllowYn(UPDATED_CREDIT_LIMIT_AUTO_PAY_ALLOW_YN);

        restReservationNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReservationName.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReservationName))
            )
            .andExpect(status().isOk());

        // Validate the ReservationName in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReservationNameUpdatableFieldsEquals(
            partialUpdatedReservationName,
            getPersistedReservationName(partialUpdatedReservationName)
        );
    }

    @Test
    @Transactional
    void patchNonExistingReservationName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationName.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReservationNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, reservationName.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reservationName))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchReservationName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationName.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reservationName))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamReservationName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationName.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationNameMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(reservationName)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReservationName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteReservationName() throws Exception {
        // Initialize the database
        reservationNameRepository.saveAndFlush(reservationName);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the reservationName
        restReservationNameMockMvc
            .perform(delete(ENTITY_API_URL_ID, reservationName.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return reservationNameRepository.count();
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

    protected ReservationName getPersistedReservationName(ReservationName reservationName) {
        return reservationNameRepository.findById(reservationName.getId()).orElseThrow();
    }

    protected void assertPersistedReservationNameToMatchAllProperties(ReservationName expectedReservationName) {
        assertReservationNameAllPropertiesEquals(expectedReservationName, getPersistedReservationName(expectedReservationName));
    }

    protected void assertPersistedReservationNameToMatchUpdatableProperties(ReservationName expectedReservationName) {
        assertReservationNameAllUpdatablePropertiesEquals(expectedReservationName, getPersistedReservationName(expectedReservationName));
    }
}
