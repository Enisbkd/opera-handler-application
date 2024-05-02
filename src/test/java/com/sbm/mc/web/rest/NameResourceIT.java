package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.NameAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.Name;
import com.sbm.mc.repository.NameRepository;
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
 * Integration tests for the {@link NameResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class NameResourceIT {

    private static final Integer DEFAULT_NAME_ID = 1;
    private static final Integer UPDATED_NAME_ID = 2;

    private static final String DEFAULT_NAME_CODE = "AAAAAAAAAA";
    private static final String UPDATED_NAME_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_PRIMARY_NAME_ID = 1;
    private static final Integer UPDATED_PRIMARY_NAME_ID = 2;

    private static final String DEFAULT_REPEAT_GUEST_ID = "AAAAAAAAAA";
    private static final String UPDATED_REPEAT_GUEST_ID = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_LIST = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_LIST = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_FOLLOW_ON = "AAAAAAAAAA";
    private static final String UPDATED_FOLLOW_ON = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_TITLE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_INACTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INACTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_ARC_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ARC_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UPDATE_FAX_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_FAX_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_BIRTH_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BIRTH_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_COLLECTION_USER_ID = 1;
    private static final Integer UPDATED_COLLECTION_USER_ID = 2;

    private static final String DEFAULT_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY = "BBBBBBBBBB";

    private static final String DEFAULT_SOUND_EX_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_SOUND_EX_COMPANY = "BBBBBBBBBB";

    private static final String DEFAULT_LEGAL_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_LEGAL_COMPANY = "BBBBBBBBBB";

    private static final String DEFAULT_FIRST = "AAAAAAAAAA";
    private static final String UPDATED_FIRST = "BBBBBBBBBB";

    private static final String DEFAULT_MIDDLE = "AAAAAAAAAA";
    private static final String UPDATED_MIDDLE = "BBBBBBBBBB";

    private static final String DEFAULT_LAST = "AAAAAAAAAA";
    private static final String UPDATED_LAST = "BBBBBBBBBB";

    private static final String DEFAULT_NICKNAME = "AAAAAAAAAA";
    private static final String UPDATED_NICKNAME = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_SOUND_EX_LAST = "AAAAAAAAAA";
    private static final String UPDATED_SOUND_EX_LAST = "BBBBBBBBBB";

    private static final String DEFAULT_EXTERNAL_REFERENCE_REQU = "AAAAAAAAAA";
    private static final String UPDATED_EXTERNAL_REFERENCE_REQU = "BBBBBBBBBB";

    private static final String DEFAULT_VIP_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_VIP_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_VIP_AUTHORIZATION = "AAAAAAAAAA";
    private static final String UPDATED_VIP_AUTHORIZATION = "BBBBBBBBBB";

    private static final String DEFAULT_BILLING_PROFILE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_BILLING_PROFILE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_RATE_STRUCTURE = "AAAAAAAAAA";
    private static final String UPDATED_RATE_STRUCTURE = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_NAME_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_TOUR_OPERATOR_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TOUR_OPERATOR_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_REGION = "AAAAAAAAAA";
    private static final String UPDATED_REGION = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_OF_1099 = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_OF_1099 = "BBBBBBBBBB";

    private static final String DEFAULT_TAX_1_NO = "AAAAAAAAAA";
    private static final String UPDATED_TAX_1_NO = "BBBBBBBBBB";

    private static final Integer DEFAULT_COMPANY_NAME_ID = 1;
    private static final Integer UPDATED_COMPANY_NAME_ID = 2;

    private static final String DEFAULT_EXTERNAL_REFERENCE_REQUIRED = "AAAAAAAAAA";
    private static final String UPDATED_EXTERNAL_REFERENCE_REQUIRED = "BBBBBBBBBB";

    private static final Integer DEFAULT_VENDOR_ID = 1;
    private static final Integer UPDATED_VENDOR_ID = 2;

    private static final Integer DEFAULT_VENDOR_SITE_ID = 1;
    private static final Integer UPDATED_VENDOR_SITE_ID = 2;

    private static final String DEFAULT_ARC_OFFICE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ARC_OFFICE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_TAX_2_NO = "AAAAAAAAAA";
    private static final String UPDATED_TAX_2_NO = "BBBBBBBBBB";

    private static final String DEFAULT_ARC_MAIL_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_ARC_MAIL_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_2 = "AAAAAAAAAA";
    private static final String UPDATED_NAME_2 = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_3 = "AAAAAAAAAA";
    private static final String UPDATED_NAME_3 = "BBBBBBBBBB";

    private static final String DEFAULT_SALESREP = "AAAAAAAAAA";
    private static final String UPDATED_SALESREP = "BBBBBBBBBB";

    private static final String DEFAULT_TRACECODE = "AAAAAAAAAA";
    private static final String UPDATED_TRACECODE = "BBBBBBBBBB";

    private static final String DEFAULT_GEOGRAPHIC_REGION = "AAAAAAAAAA";
    private static final String UPDATED_GEOGRAPHIC_REGION = "BBBBBBBBBB";

    private static final String DEFAULT_GUEST_CLASSIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_GUEST_CLASSIFICATION = "BBBBBBBBBB";

    private static final Integer DEFAULT_PRIMARY_ADDRESS_ID = 1;
    private static final Integer UPDATED_PRIMARY_ADDRESS_ID = 2;

    private static final Integer DEFAULT_PRIMARY_PHONE_ID = 1;
    private static final Integer UPDATED_PRIMARY_PHONE_ID = 2;

    private static final String DEFAULT_TAX_EXEMPT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_TAX_EXEMPT_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_GDS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_GDS_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_GDS_TRANSACTION_NO = "AAAAAAAAAA";
    private static final String UPDATED_GDS_TRANSACTION_NO = "BBBBBBBBBB";

    private static final String DEFAULT_NATIONALITY = "AAAAAAAAAA";
    private static final String UPDATED_NATIONALITY = "BBBBBBBBBB";

    private static final String DEFAULT_LANGUAGE = "AAAAAAAAAA";
    private static final String UPDATED_LANGUAGE = "BBBBBBBBBB";

    private static final String DEFAULT_SALUTATION = "AAAAAAAAAA";
    private static final String UPDATED_SALUTATION = "BBBBBBBBBB";

    private static final String DEFAULT_PASSPORT = "AAAAAAAAAA";
    private static final String UPDATED_PASSPORT = "BBBBBBBBBB";

    private static final String DEFAULT_HISTORY_YN = "AAAAAAAAAA";
    private static final String UPDATED_HISTORY_YN = "BBBBBBBBBB";

    private static final String DEFAULT_RESV_CONTACT = "AAAAAAAAAA";
    private static final String UPDATED_RESV_CONTACT = "BBBBBBBBBB";

    private static final String DEFAULT_CONTRACT_NO = "AAAAAAAAAA";
    private static final String UPDATED_CONTRACT_NO = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CONTRACT_RECV_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CONTRACT_RECV_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ACCT_CONTACT = "AAAAAAAAAA";
    private static final String UPDATED_ACCT_CONTACT = "BBBBBBBBBB";

    private static final String DEFAULT_PRIORITY = "AAAAAAAAAA";
    private static final String UPDATED_PRIORITY = "BBBBBBBBBB";

    private static final String DEFAULT_INDUSTRY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_INDUSTRY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMS_POTENTIAL = "AAAAAAAAAA";
    private static final String UPDATED_ROOMS_POTENTIAL = "BBBBBBBBBB";

    private static final String DEFAULT_COMPETITION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMPETITION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SCOPE = "AAAAAAAAAA";
    private static final String UPDATED_SCOPE = "BBBBBBBBBB";

    private static final String DEFAULT_SCOPE_CITY = "AAAAAAAAAA";
    private static final String UPDATED_SCOPE_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_TERRITORY = "AAAAAAAAAA";
    private static final String UPDATED_TERRITORY = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIONCODE = "AAAAAAAAAA";
    private static final String UPDATED_ACTIONCODE = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVE_YN = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_MASTER_ACCOUNT_YN = "AAAAAAAAAA";
    private static final String UPDATED_MASTER_ACCOUNT_YN = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_NAME_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SNAME = "AAAAAAAAAA";
    private static final String UPDATED_SNAME = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_TAX_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_NAME_TAX_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SFIRST = "AAAAAAAAAA";
    private static final String UPDATED_SFIRST = "BBBBBBBBBB";

    private static final String DEFAULT_AR_NO = "AAAAAAAAAA";
    private static final String UPDATED_AR_NO = "BBBBBBBBBB";

    private static final String DEFAULT_AVAILABILITY_OVERRIDE = "AAAAAAAAAA";
    private static final String UPDATED_AVAILABILITY_OVERRIDE = "BBBBBBBBBB";

    private static final String DEFAULT_BILLING_CODE = "AAAAAAAAAA";
    private static final String UPDATED_BILLING_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CASH_BL_IND = "AAAAAAAAAA";
    private static final String UPDATED_CASH_BL_IND = "BBBBBBBBBB";

    private static final String DEFAULT_BL_MSG = "AAAAAAAAAA";
    private static final String UPDATED_BL_MSG = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_COMMISSION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMMISSION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_HOLD_CODE = "AAAAAAAAAA";
    private static final String UPDATED_HOLD_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_INTEREST = "AAAAAAAAAA";
    private static final String UPDATED_INTEREST = "BBBBBBBBBB";

    private static final String DEFAULT_SUMM_REF_CC = "AAAAAAAAAA";
    private static final String UPDATED_SUMM_REF_CC = "BBBBBBBBBB";

    private static final String DEFAULT_IATA_COMP_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_IATA_COMP_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SREP_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SREP_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNTSOURCE = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNTSOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_MARKETS = "AAAAAAAAAA";
    private static final String UPDATED_MARKETS = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT_INTEREST = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_INTEREST = "BBBBBBBBBB";

    private static final String DEFAULT_KEYWORD = "AAAAAAAAAA";
    private static final String UPDATED_KEYWORD = "BBBBBBBBBB";

    private static final String DEFAULT_LETTER_GREETING = "AAAAAAAAAA";
    private static final String UPDATED_LETTER_GREETING = "BBBBBBBBBB";

    private static final String DEFAULT_INFLUENCE = "AAAAAAAAAA";
    private static final String UPDATED_INFLUENCE = "BBBBBBBBBB";

    private static final String DEFAULT_DEPT_ID = "AAAAAAAAAA";
    private static final String UPDATED_DEPT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DEPARTMENT = "AAAAAAAAAA";
    private static final String UPDATED_DEPARTMENT = "BBBBBBBBBB";

    private static final String DEFAULT_CONTACT_YN = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DOWNLOAD_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_DOWNLOAD_RESORT = "BBBBBBBBBB";

    private static final Integer DEFAULT_DOWNLOAD_SREP = 1;
    private static final Integer UPDATED_DOWNLOAD_SREP = 2;

    private static final LocalDate DEFAULT_DOWNLOAD_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOWNLOAD_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UPLOAD_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPLOAD_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_LAPTOP_CHANGE = 1;
    private static final Integer UPDATED_LAPTOP_CHANGE = 2;

    private static final Integer DEFAULT_CRS_NAMEID = 1;
    private static final Integer UPDATED_CRS_NAMEID = 2;

    private static final String DEFAULT_COMM_PAY_CENTRAL = "AAAAAAAAAA";
    private static final String UPDATED_COMM_PAY_CENTRAL = "BBBBBBBBBB";

    private static final String DEFAULT_CC_PROFILE_YN = "AAAAAAAAAA";
    private static final String UPDATED_CC_PROFILE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_GENDER = "AAAAAAAAAA";
    private static final String UPDATED_GENDER = "BBBBBBBBBB";

    private static final String DEFAULT_BIRTH_PLACE = "AAAAAAAAAA";
    private static final String UPDATED_BIRTH_PLACE = "BBBBBBBBBB";

    private static final String DEFAULT_BIRTH_COUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_BIRTH_COUNTRY = "BBBBBBBBBB";

    private static final String DEFAULT_PROFESSION = "AAAAAAAAAA";
    private static final String UPDATED_PROFESSION = "BBBBBBBBBB";

    private static final String DEFAULT_ID_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ID_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ID_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_ID_NUMBER = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_ID_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ID_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ID_PLACE = "AAAAAAAAAA";
    private static final String UPDATED_ID_PLACE = "BBBBBBBBBB";

    private static final String DEFAULT_ID_COUNTRY = "AAAAAAAAAA";
    private static final String UPDATED_ID_COUNTRY = "BBBBBBBBBB";

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

    private static final LocalDate DEFAULT_UDFD_11 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_11 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_12 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_12 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_13 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_13 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_14 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_14 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_15 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_15 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_16 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_16 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_17 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_17 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_18 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_18 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_19 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_19 = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UDFD_20 = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UDFD_20 = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_PAYMENT_DUE_DAYS = 1;
    private static final Integer UPDATED_PAYMENT_DUE_DAYS = 2;

    private static final String DEFAULT_SUFFIX = "AAAAAAAAAA";
    private static final String UPDATED_SUFFIX = "BBBBBBBBBB";

    private static final String DEFAULT_EXTERNAL_ID = "AAAAAAAAAA";
    private static final String UPDATED_EXTERNAL_ID = "BBBBBBBBBB";

    private static final String DEFAULT_GUEST_PRIV_YN = "AAAAAAAAAA";
    private static final String UPDATED_GUEST_PRIV_YN = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_YN = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_YN = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_YN = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_YN = "BBBBBBBBBB";

    private static final String DEFAULT_INDEX_NAME = "AAAAAAAAAA";
    private static final String UPDATED_INDEX_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_XLAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_XLAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_XFIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_XFIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_XCOMPANY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_XCOMPANY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_XTITLE = "AAAAAAAAAA";
    private static final String UPDATED_XTITLE = "BBBBBBBBBB";

    private static final String DEFAULT_XSALUTATION = "AAAAAAAAAA";
    private static final String UPDATED_XSALUTATION = "BBBBBBBBBB";

    private static final String DEFAULT_SXNAME = "AAAAAAAAAA";
    private static final String UPDATED_SXNAME = "BBBBBBBBBB";

    private static final String DEFAULT_SXFIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SXFIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_UPDATED_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_LAST_UPDATED_RESORT = "BBBBBBBBBB";

    private static final String DEFAULT_ENVELOPE_GREETING = "AAAAAAAAAA";
    private static final String UPDATED_ENVELOPE_GREETING = "BBBBBBBBBB";

    private static final String DEFAULT_XENVELOPE_GREETING = "AAAAAAAAAA";
    private static final String UPDATED_XENVELOPE_GREETING = "BBBBBBBBBB";

    private static final String DEFAULT_DIRECT_BILL_BATCH_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DIRECT_BILL_BATCH_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_RESORT_REGISTERED = "AAAAAAAAAA";
    private static final String UPDATED_RESORT_REGISTERED = "BBBBBBBBBB";

    private static final String DEFAULT_TAX_OFFICE = "AAAAAAAAAA";
    private static final String UPDATED_TAX_OFFICE = "BBBBBBBBBB";

    private static final String DEFAULT_TAX_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TAX_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_TAX_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_TAX_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_PREFERRED_ROOM_NO = "AAAAAAAAAA";
    private static final String UPDATED_PREFERRED_ROOM_NO = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_YN = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_SMS_YN = "AAAAAAAAAA";
    private static final String UPDATED_SMS_YN = "BBBBBBBBBB";

    private static final String DEFAULT_IS_PROTECTED = "AAAAAAAAAA";
    private static final String UPDATED_IS_PROTECTED = "BBBBBBBBBB";

    private static final String DEFAULT_XLANGUAGE = "AAAAAAAAAA";
    private static final String UPDATED_XLANGUAGE = "BBBBBBBBBB";

    private static final String DEFAULT_MARKET_RESEARCH_YN = "AAAAAAAAAA";
    private static final String UPDATED_MARKET_RESEARCH_YN = "BBBBBBBBBB";

    private static final String DEFAULT_THIRD_PARTY_YN = "AAAAAAAAAA";
    private static final String UPDATED_THIRD_PARTY_YN = "BBBBBBBBBB";

    private static final String DEFAULT_AUTOENROLL_MEMBER_YN = "AAAAAAAAAA";
    private static final String UPDATED_AUTOENROLL_MEMBER_YN = "BBBBBBBBBB";

    private static final String DEFAULT_CHAIN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CHAIN_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_GROUP_ID = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_GROUP_ID = "BBBBBBBBBB";

    private static final String DEFAULT_INCLUDE_IN_1099_YN = "AAAAAAAAAA";
    private static final String UPDATED_INCLUDE_IN_1099_YN = "BBBBBBBBBB";

    private static final String DEFAULT_CREDIT_RATING = "AAAAAAAAAA";
    private static final String UPDATED_CREDIT_RATING = "BBBBBBBBBB";

    private static final Integer DEFAULT_TITLE_SUFFIX = 1;
    private static final Integer UPDATED_TITLE_SUFFIX = 2;

    private static final String DEFAULT_INACTIVE_REASON = "AAAAAAAAAA";
    private static final String UPDATED_INACTIVE_REASON = "BBBBBBBBBB";

    private static final String DEFAULT_IATA_CONSORTIA = "AAAAAAAAAA";
    private static final String UPDATED_IATA_CONSORTIA = "BBBBBBBBBB";

    private static final String DEFAULT_PSUEDO_PROFILE_YN = "AAAAAAAAAA";
    private static final String UPDATED_PSUEDO_PROFILE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_PROFILE_PRIVACY_FLG = "AAAAAAAAAA";
    private static final String UPDATED_PROFILE_PRIVACY_FLG = "BBBBBBBBBB";

    private static final String DEFAULT_REPLACE_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_REPLACE_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_ALIEN_REGISTRATION_NO = "AAAAAAAAAA";
    private static final String UPDATED_ALIEN_REGISTRATION_NO = "BBBBBBBBBB";

    private static final String DEFAULT_IMMIGRATION_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_IMMIGRATION_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_VISA_VALIDITY_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_VISA_VALIDITY_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_ID_DOCUMENT_ATTACH_ID = 1;
    private static final Integer UPDATED_ID_DOCUMENT_ATTACH_ID = 2;

    private static final String DEFAULT_SUPER_SEARCH_INDEX_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_SUPER_SEARCH_INDEX_TEXT = "BBBBBBBBBB";

    private static final String DEFAULT_BIRTH_DATE_STR = "AAAAAAAAAA";
    private static final String UPDATED_BIRTH_DATE_STR = "BBBBBBBBBB";

    private static final Integer DEFAULT_ORIG_NAME_ID = 1;
    private static final Integer UPDATED_ORIG_NAME_ID = 2;

    private static final String DEFAULT_D_OPT_IN_MAIL_LIST_FLG = "AAAAAAAAAA";
    private static final String UPDATED_D_OPT_IN_MAIL_LIST_FLG = "BBBBBBBBBB";

    private static final String DEFAULT_D_OPT_IN_MARKET_RESEARCH_FLG = "AAAAAAAAAA";
    private static final String UPDATED_D_OPT_IN_MARKET_RESEARCH_FLG = "BBBBBBBBBB";

    private static final String DEFAULT_D_OPT_IN_THIRD_PARTY_FLG = "AAAAAAAAAA";
    private static final String UPDATED_D_OPT_IN_THIRD_PARTY_FLG = "BBBBBBBBBB";

    private static final String DEFAULT_D_OPT_IN_AUTOENROLL_MEMBER_FLG = "AAAAAAAAAA";
    private static final String UPDATED_D_OPT_IN_AUTOENROLL_MEMBER_FLG = "BBBBBBBBBB";

    private static final String DEFAULT_D_OPT_IN_EMAIL_FLG = "AAAAAAAAAA";
    private static final String UPDATED_D_OPT_IN_EMAIL_FLG = "BBBBBBBBBB";

    private static final String DEFAULT_D_OPT_IN_PHONE_FLG = "AAAAAAAAAA";
    private static final String UPDATED_D_OPT_IN_PHONE_FLG = "BBBBBBBBBB";

    private static final String DEFAULT_D_OPT_IN_SMS_FLG = "AAAAAAAAAA";
    private static final String UPDATED_D_OPT_IN_SMS_FLG = "BBBBBBBBBB";

    private static final String DEFAULT_D_OPT_IN_GUEST_PRIV_FLG = "AAAAAAAAAA";
    private static final String UPDATED_D_OPT_IN_GUEST_PRIV_FLG = "BBBBBBBBBB";

    private static final String DEFAULT_AR_CREDIT_LIMIT_YN = "AAAAAAAAAA";
    private static final String UPDATED_AR_CREDIT_LIMIT_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_PROFILE_CREDIT_LIMIT = 1;
    private static final Integer UPDATED_PROFILE_CREDIT_LIMIT = 2;

    private static final String DEFAULT_XMIDDLE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_XMIDDLE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_E_INVOICE_LIABLE_YN = "AAAAAAAAAA";
    private static final String UPDATED_E_INVOICE_LIABLE_YN = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_E_INV_LIABLE_LAST_UPDATED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_E_INV_LIABLE_LAST_UPDATED = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_INTERNAL_BILL_YN = "AAAAAAAAAA";
    private static final String UPDATED_INTERNAL_BILL_YN = "BBBBBBBBBB";

    private static final String DEFAULT_COMP_PRE_APPROVAL_REQUIRED_YN = "AAAAAAAAAA";
    private static final String UPDATED_COMP_PRE_APPROVAL_REQUIRED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ANONYMIZATION_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_ANONYMIZATION_STATUS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_ANONYMIZATION_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ANONYMIZATION_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String ENTITY_API_URL = "/api/names";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private NameRepository nameRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restNameMockMvc;

    private Name name;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Name createEntity(EntityManager em) {
        Name name = new Name()
            .nameId(DEFAULT_NAME_ID)
            .nameCode(DEFAULT_NAME_CODE)
            .insertUser(DEFAULT_INSERT_USER)
            .insertDate(DEFAULT_INSERT_DATE)
            .updateUser(DEFAULT_UPDATE_USER)
            .updateDate(DEFAULT_UPDATE_DATE)
            .primaryNameId(DEFAULT_PRIMARY_NAME_ID)
            .repeatGuestId(DEFAULT_REPEAT_GUEST_ID)
            .mailList(DEFAULT_MAIL_LIST)
            .mailType(DEFAULT_MAIL_TYPE)
            .followOn(DEFAULT_FOLLOW_ON)
            .businessTitle(DEFAULT_BUSINESS_TITLE)
            .inactiveDate(DEFAULT_INACTIVE_DATE)
            .arcUpdateDate(DEFAULT_ARC_UPDATE_DATE)
            .updateFaxDate(DEFAULT_UPDATE_FAX_DATE)
            .birthDate(DEFAULT_BIRTH_DATE)
            .collectionUserId(DEFAULT_COLLECTION_USER_ID)
            .company(DEFAULT_COMPANY)
            .soundExCompany(DEFAULT_SOUND_EX_COMPANY)
            .legalCompany(DEFAULT_LEGAL_COMPANY)
            .first(DEFAULT_FIRST)
            .middle(DEFAULT_MIDDLE)
            .last(DEFAULT_LAST)
            .nickname(DEFAULT_NICKNAME)
            .title(DEFAULT_TITLE)
            .soundExLast(DEFAULT_SOUND_EX_LAST)
            .externalReferenceRequ(DEFAULT_EXTERNAL_REFERENCE_REQU)
            .vipStatus(DEFAULT_VIP_STATUS)
            .vipAuthorization(DEFAULT_VIP_AUTHORIZATION)
            .billingProfileCode(DEFAULT_BILLING_PROFILE_CODE)
            .rateStructure(DEFAULT_RATE_STRUCTURE)
            .nameComment(DEFAULT_NAME_COMMENT)
            .tourOperatorType(DEFAULT_TOUR_OPERATOR_TYPE)
            .region(DEFAULT_REGION)
            .typeOf1099(DEFAULT_TYPE_OF_1099)
            .tax1No(DEFAULT_TAX_1_NO)
            .companyNameId(DEFAULT_COMPANY_NAME_ID)
            .externalReferenceRequired(DEFAULT_EXTERNAL_REFERENCE_REQUIRED)
            .vendorId(DEFAULT_VENDOR_ID)
            .vendorSiteId(DEFAULT_VENDOR_SITE_ID)
            .arcOfficeType(DEFAULT_ARC_OFFICE_TYPE)
            .tax2No(DEFAULT_TAX_2_NO)
            .arcMailFlag(DEFAULT_ARC_MAIL_FLAG)
            .name2(DEFAULT_NAME_2)
            .name3(DEFAULT_NAME_3)
            .salesrep(DEFAULT_SALESREP)
            .tracecode(DEFAULT_TRACECODE)
            .geographicRegion(DEFAULT_GEOGRAPHIC_REGION)
            .guestClassification(DEFAULT_GUEST_CLASSIFICATION)
            .primaryAddressId(DEFAULT_PRIMARY_ADDRESS_ID)
            .primaryPhoneId(DEFAULT_PRIMARY_PHONE_ID)
            .taxExemptStatus(DEFAULT_TAX_EXEMPT_STATUS)
            .gdsName(DEFAULT_GDS_NAME)
            .gdsTransactionNo(DEFAULT_GDS_TRANSACTION_NO)
            .nationality(DEFAULT_NATIONALITY)
            .language(DEFAULT_LANGUAGE)
            .salutation(DEFAULT_SALUTATION)
            .passport(DEFAULT_PASSPORT)
            .historyYn(DEFAULT_HISTORY_YN)
            .resvContact(DEFAULT_RESV_CONTACT)
            .contractNo(DEFAULT_CONTRACT_NO)
            .contractRecvDate(DEFAULT_CONTRACT_RECV_DATE)
            .acctContact(DEFAULT_ACCT_CONTACT)
            .priority(DEFAULT_PRIORITY)
            .industryCode(DEFAULT_INDUSTRY_CODE)
            .roomsPotential(DEFAULT_ROOMS_POTENTIAL)
            .competitionCode(DEFAULT_COMPETITION_CODE)
            .scope(DEFAULT_SCOPE)
            .scopeCity(DEFAULT_SCOPE_CITY)
            .territory(DEFAULT_TERRITORY)
            .actioncode(DEFAULT_ACTIONCODE)
            .activeYn(DEFAULT_ACTIVE_YN)
            .masterAccountYn(DEFAULT_MASTER_ACCOUNT_YN)
            .nameType(DEFAULT_NAME_TYPE)
            .sname(DEFAULT_SNAME)
            .nameTaxType(DEFAULT_NAME_TAX_TYPE)
            .sfirst(DEFAULT_SFIRST)
            .arNo(DEFAULT_AR_NO)
            .availabilityOverride(DEFAULT_AVAILABILITY_OVERRIDE)
            .billingCode(DEFAULT_BILLING_CODE)
            .cashBlInd(DEFAULT_CASH_BL_IND)
            .blMsg(DEFAULT_BL_MSG)
            .currencyCode(DEFAULT_CURRENCY_CODE)
            .commissionCode(DEFAULT_COMMISSION_CODE)
            .holdCode(DEFAULT_HOLD_CODE)
            .interest(DEFAULT_INTEREST)
            .summRefCc(DEFAULT_SUMM_REF_CC)
            .iataCompType(DEFAULT_IATA_COMP_TYPE)
            .srepCode(DEFAULT_SREP_CODE)
            .accountsource(DEFAULT_ACCOUNTSOURCE)
            .markets(DEFAULT_MARKETS)
            .productInterest(DEFAULT_PRODUCT_INTEREST)
            .keyword(DEFAULT_KEYWORD)
            .letterGreeting(DEFAULT_LETTER_GREETING)
            .influence(DEFAULT_INFLUENCE)
            .deptId(DEFAULT_DEPT_ID)
            .department(DEFAULT_DEPARTMENT)
            .contactYn(DEFAULT_CONTACT_YN)
            .accountType(DEFAULT_ACCOUNT_TYPE)
            .downloadResort(DEFAULT_DOWNLOAD_RESORT)
            .downloadSrep(DEFAULT_DOWNLOAD_SREP)
            .downloadDate(DEFAULT_DOWNLOAD_DATE)
            .uploadDate(DEFAULT_UPLOAD_DATE)
            .laptopChange(DEFAULT_LAPTOP_CHANGE)
            .crsNameid(DEFAULT_CRS_NAMEID)
            .commPayCentral(DEFAULT_COMM_PAY_CENTRAL)
            .ccProfileYn(DEFAULT_CC_PROFILE_YN)
            .gender(DEFAULT_GENDER)
            .birthPlace(DEFAULT_BIRTH_PLACE)
            .birthCountry(DEFAULT_BIRTH_COUNTRY)
            .profession(DEFAULT_PROFESSION)
            .idType(DEFAULT_ID_TYPE)
            .idNumber(DEFAULT_ID_NUMBER)
            .idDate(DEFAULT_ID_DATE)
            .idPlace(DEFAULT_ID_PLACE)
            .idCountry(DEFAULT_ID_COUNTRY)
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
            .udfd11(DEFAULT_UDFD_11)
            .udfd12(DEFAULT_UDFD_12)
            .udfd13(DEFAULT_UDFD_13)
            .udfd14(DEFAULT_UDFD_14)
            .udfd15(DEFAULT_UDFD_15)
            .udfd16(DEFAULT_UDFD_16)
            .udfd17(DEFAULT_UDFD_17)
            .udfd18(DEFAULT_UDFD_18)
            .udfd19(DEFAULT_UDFD_19)
            .udfd20(DEFAULT_UDFD_20)
            .paymentDueDays(DEFAULT_PAYMENT_DUE_DAYS)
            .suffix(DEFAULT_SUFFIX)
            .externalId(DEFAULT_EXTERNAL_ID)
            .guestPrivYn(DEFAULT_GUEST_PRIV_YN)
            .emailYn(DEFAULT_EMAIL_YN)
            .mailYn(DEFAULT_MAIL_YN)
            .indexName(DEFAULT_INDEX_NAME)
            .xlastName(DEFAULT_XLAST_NAME)
            .xfirstName(DEFAULT_XFIRST_NAME)
            .xcompanyName(DEFAULT_XCOMPANY_NAME)
            .xtitle(DEFAULT_XTITLE)
            .xsalutation(DEFAULT_XSALUTATION)
            .sxname(DEFAULT_SXNAME)
            .sxfirstName(DEFAULT_SXFIRST_NAME)
            .lastUpdatedResort(DEFAULT_LAST_UPDATED_RESORT)
            .envelopeGreeting(DEFAULT_ENVELOPE_GREETING)
            .xenvelopeGreeting(DEFAULT_XENVELOPE_GREETING)
            .directBillBatchType(DEFAULT_DIRECT_BILL_BATCH_TYPE)
            .resortRegistered(DEFAULT_RESORT_REGISTERED)
            .taxOffice(DEFAULT_TAX_OFFICE)
            .taxType(DEFAULT_TAX_TYPE)
            .taxCategory(DEFAULT_TAX_CATEGORY)
            .preferredRoomNo(DEFAULT_PREFERRED_ROOM_NO)
            .phoneYn(DEFAULT_PHONE_YN)
            .smsYn(DEFAULT_SMS_YN)
            .isProtected(DEFAULT_IS_PROTECTED)
            .xlanguage(DEFAULT_XLANGUAGE)
            .marketResearchYn(DEFAULT_MARKET_RESEARCH_YN)
            .thirdPartyYn(DEFAULT_THIRD_PARTY_YN)
            .autoenrollMemberYn(DEFAULT_AUTOENROLL_MEMBER_YN)
            .chainCode(DEFAULT_CHAIN_CODE)
            .companyGroupId(DEFAULT_COMPANY_GROUP_ID)
            .includeIn1099Yn(DEFAULT_INCLUDE_IN_1099_YN)
            .creditRating(DEFAULT_CREDIT_RATING)
            .titleSuffix(DEFAULT_TITLE_SUFFIX)
            .inactiveReason(DEFAULT_INACTIVE_REASON)
            .iataConsortia(DEFAULT_IATA_CONSORTIA)
            .psuedoProfileYn(DEFAULT_PSUEDO_PROFILE_YN)
            .profilePrivacyFlg(DEFAULT_PROFILE_PRIVACY_FLG)
            .replaceAddress(DEFAULT_REPLACE_ADDRESS)
            .alienRegistrationNo(DEFAULT_ALIEN_REGISTRATION_NO)
            .immigrationStatus(DEFAULT_IMMIGRATION_STATUS)
            .visaValidityType(DEFAULT_VISA_VALIDITY_TYPE)
            .idDocumentAttachId(DEFAULT_ID_DOCUMENT_ATTACH_ID)
            .superSearchIndexText(DEFAULT_SUPER_SEARCH_INDEX_TEXT)
            .birthDateStr(DEFAULT_BIRTH_DATE_STR)
            .origNameId(DEFAULT_ORIG_NAME_ID)
            .dOptInMailListFlg(DEFAULT_D_OPT_IN_MAIL_LIST_FLG)
            .dOptInMarketResearchFlg(DEFAULT_D_OPT_IN_MARKET_RESEARCH_FLG)
            .dOptInThirdPartyFlg(DEFAULT_D_OPT_IN_THIRD_PARTY_FLG)
            .dOptInAutoenrollMemberFlg(DEFAULT_D_OPT_IN_AUTOENROLL_MEMBER_FLG)
            .dOptInEmailFlg(DEFAULT_D_OPT_IN_EMAIL_FLG)
            .dOptInPhoneFlg(DEFAULT_D_OPT_IN_PHONE_FLG)
            .dOptInSmsFlg(DEFAULT_D_OPT_IN_SMS_FLG)
            .dOptInGuestPrivFlg(DEFAULT_D_OPT_IN_GUEST_PRIV_FLG)
            .arCreditLimitYn(DEFAULT_AR_CREDIT_LIMIT_YN)
            .profileCreditLimit(DEFAULT_PROFILE_CREDIT_LIMIT)
            .xmiddleName(DEFAULT_XMIDDLE_NAME)
            .eInvoiceLiableYn(DEFAULT_E_INVOICE_LIABLE_YN)
            .eInvLiableLastUpdated(DEFAULT_E_INV_LIABLE_LAST_UPDATED)
            .internalBillYn(DEFAULT_INTERNAL_BILL_YN)
            .compPreApprovalRequiredYn(DEFAULT_COMP_PRE_APPROVAL_REQUIRED_YN)
            .anonymizationStatus(DEFAULT_ANONYMIZATION_STATUS)
            .anonymizationDate(DEFAULT_ANONYMIZATION_DATE);
        return name;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Name createUpdatedEntity(EntityManager em) {
        Name name = new Name()
            .nameId(UPDATED_NAME_ID)
            .nameCode(UPDATED_NAME_CODE)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .primaryNameId(UPDATED_PRIMARY_NAME_ID)
            .repeatGuestId(UPDATED_REPEAT_GUEST_ID)
            .mailList(UPDATED_MAIL_LIST)
            .mailType(UPDATED_MAIL_TYPE)
            .followOn(UPDATED_FOLLOW_ON)
            .businessTitle(UPDATED_BUSINESS_TITLE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .arcUpdateDate(UPDATED_ARC_UPDATE_DATE)
            .updateFaxDate(UPDATED_UPDATE_FAX_DATE)
            .birthDate(UPDATED_BIRTH_DATE)
            .collectionUserId(UPDATED_COLLECTION_USER_ID)
            .company(UPDATED_COMPANY)
            .soundExCompany(UPDATED_SOUND_EX_COMPANY)
            .legalCompany(UPDATED_LEGAL_COMPANY)
            .first(UPDATED_FIRST)
            .middle(UPDATED_MIDDLE)
            .last(UPDATED_LAST)
            .nickname(UPDATED_NICKNAME)
            .title(UPDATED_TITLE)
            .soundExLast(UPDATED_SOUND_EX_LAST)
            .externalReferenceRequ(UPDATED_EXTERNAL_REFERENCE_REQU)
            .vipStatus(UPDATED_VIP_STATUS)
            .vipAuthorization(UPDATED_VIP_AUTHORIZATION)
            .billingProfileCode(UPDATED_BILLING_PROFILE_CODE)
            .rateStructure(UPDATED_RATE_STRUCTURE)
            .nameComment(UPDATED_NAME_COMMENT)
            .tourOperatorType(UPDATED_TOUR_OPERATOR_TYPE)
            .region(UPDATED_REGION)
            .typeOf1099(UPDATED_TYPE_OF_1099)
            .tax1No(UPDATED_TAX_1_NO)
            .companyNameId(UPDATED_COMPANY_NAME_ID)
            .externalReferenceRequired(UPDATED_EXTERNAL_REFERENCE_REQUIRED)
            .vendorId(UPDATED_VENDOR_ID)
            .vendorSiteId(UPDATED_VENDOR_SITE_ID)
            .arcOfficeType(UPDATED_ARC_OFFICE_TYPE)
            .tax2No(UPDATED_TAX_2_NO)
            .arcMailFlag(UPDATED_ARC_MAIL_FLAG)
            .name2(UPDATED_NAME_2)
            .name3(UPDATED_NAME_3)
            .salesrep(UPDATED_SALESREP)
            .tracecode(UPDATED_TRACECODE)
            .geographicRegion(UPDATED_GEOGRAPHIC_REGION)
            .guestClassification(UPDATED_GUEST_CLASSIFICATION)
            .primaryAddressId(UPDATED_PRIMARY_ADDRESS_ID)
            .primaryPhoneId(UPDATED_PRIMARY_PHONE_ID)
            .taxExemptStatus(UPDATED_TAX_EXEMPT_STATUS)
            .gdsName(UPDATED_GDS_NAME)
            .gdsTransactionNo(UPDATED_GDS_TRANSACTION_NO)
            .nationality(UPDATED_NATIONALITY)
            .language(UPDATED_LANGUAGE)
            .salutation(UPDATED_SALUTATION)
            .passport(UPDATED_PASSPORT)
            .historyYn(UPDATED_HISTORY_YN)
            .resvContact(UPDATED_RESV_CONTACT)
            .contractNo(UPDATED_CONTRACT_NO)
            .contractRecvDate(UPDATED_CONTRACT_RECV_DATE)
            .acctContact(UPDATED_ACCT_CONTACT)
            .priority(UPDATED_PRIORITY)
            .industryCode(UPDATED_INDUSTRY_CODE)
            .roomsPotential(UPDATED_ROOMS_POTENTIAL)
            .competitionCode(UPDATED_COMPETITION_CODE)
            .scope(UPDATED_SCOPE)
            .scopeCity(UPDATED_SCOPE_CITY)
            .territory(UPDATED_TERRITORY)
            .actioncode(UPDATED_ACTIONCODE)
            .activeYn(UPDATED_ACTIVE_YN)
            .masterAccountYn(UPDATED_MASTER_ACCOUNT_YN)
            .nameType(UPDATED_NAME_TYPE)
            .sname(UPDATED_SNAME)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .sfirst(UPDATED_SFIRST)
            .arNo(UPDATED_AR_NO)
            .availabilityOverride(UPDATED_AVAILABILITY_OVERRIDE)
            .billingCode(UPDATED_BILLING_CODE)
            .cashBlInd(UPDATED_CASH_BL_IND)
            .blMsg(UPDATED_BL_MSG)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .commissionCode(UPDATED_COMMISSION_CODE)
            .holdCode(UPDATED_HOLD_CODE)
            .interest(UPDATED_INTEREST)
            .summRefCc(UPDATED_SUMM_REF_CC)
            .iataCompType(UPDATED_IATA_COMP_TYPE)
            .srepCode(UPDATED_SREP_CODE)
            .accountsource(UPDATED_ACCOUNTSOURCE)
            .markets(UPDATED_MARKETS)
            .productInterest(UPDATED_PRODUCT_INTEREST)
            .keyword(UPDATED_KEYWORD)
            .letterGreeting(UPDATED_LETTER_GREETING)
            .influence(UPDATED_INFLUENCE)
            .deptId(UPDATED_DEPT_ID)
            .department(UPDATED_DEPARTMENT)
            .contactYn(UPDATED_CONTACT_YN)
            .accountType(UPDATED_ACCOUNT_TYPE)
            .downloadResort(UPDATED_DOWNLOAD_RESORT)
            .downloadSrep(UPDATED_DOWNLOAD_SREP)
            .downloadDate(UPDATED_DOWNLOAD_DATE)
            .uploadDate(UPDATED_UPLOAD_DATE)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .crsNameid(UPDATED_CRS_NAMEID)
            .commPayCentral(UPDATED_COMM_PAY_CENTRAL)
            .ccProfileYn(UPDATED_CC_PROFILE_YN)
            .gender(UPDATED_GENDER)
            .birthPlace(UPDATED_BIRTH_PLACE)
            .birthCountry(UPDATED_BIRTH_COUNTRY)
            .profession(UPDATED_PROFESSION)
            .idType(UPDATED_ID_TYPE)
            .idNumber(UPDATED_ID_NUMBER)
            .idDate(UPDATED_ID_DATE)
            .idPlace(UPDATED_ID_PLACE)
            .idCountry(UPDATED_ID_COUNTRY)
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
            .udfd11(UPDATED_UDFD_11)
            .udfd12(UPDATED_UDFD_12)
            .udfd13(UPDATED_UDFD_13)
            .udfd14(UPDATED_UDFD_14)
            .udfd15(UPDATED_UDFD_15)
            .udfd16(UPDATED_UDFD_16)
            .udfd17(UPDATED_UDFD_17)
            .udfd18(UPDATED_UDFD_18)
            .udfd19(UPDATED_UDFD_19)
            .udfd20(UPDATED_UDFD_20)
            .paymentDueDays(UPDATED_PAYMENT_DUE_DAYS)
            .suffix(UPDATED_SUFFIX)
            .externalId(UPDATED_EXTERNAL_ID)
            .guestPrivYn(UPDATED_GUEST_PRIV_YN)
            .emailYn(UPDATED_EMAIL_YN)
            .mailYn(UPDATED_MAIL_YN)
            .indexName(UPDATED_INDEX_NAME)
            .xlastName(UPDATED_XLAST_NAME)
            .xfirstName(UPDATED_XFIRST_NAME)
            .xcompanyName(UPDATED_XCOMPANY_NAME)
            .xtitle(UPDATED_XTITLE)
            .xsalutation(UPDATED_XSALUTATION)
            .sxname(UPDATED_SXNAME)
            .sxfirstName(UPDATED_SXFIRST_NAME)
            .lastUpdatedResort(UPDATED_LAST_UPDATED_RESORT)
            .envelopeGreeting(UPDATED_ENVELOPE_GREETING)
            .xenvelopeGreeting(UPDATED_XENVELOPE_GREETING)
            .directBillBatchType(UPDATED_DIRECT_BILL_BATCH_TYPE)
            .resortRegistered(UPDATED_RESORT_REGISTERED)
            .taxOffice(UPDATED_TAX_OFFICE)
            .taxType(UPDATED_TAX_TYPE)
            .taxCategory(UPDATED_TAX_CATEGORY)
            .preferredRoomNo(UPDATED_PREFERRED_ROOM_NO)
            .phoneYn(UPDATED_PHONE_YN)
            .smsYn(UPDATED_SMS_YN)
            .isProtected(UPDATED_IS_PROTECTED)
            .xlanguage(UPDATED_XLANGUAGE)
            .marketResearchYn(UPDATED_MARKET_RESEARCH_YN)
            .thirdPartyYn(UPDATED_THIRD_PARTY_YN)
            .autoenrollMemberYn(UPDATED_AUTOENROLL_MEMBER_YN)
            .chainCode(UPDATED_CHAIN_CODE)
            .companyGroupId(UPDATED_COMPANY_GROUP_ID)
            .includeIn1099Yn(UPDATED_INCLUDE_IN_1099_YN)
            .creditRating(UPDATED_CREDIT_RATING)
            .titleSuffix(UPDATED_TITLE_SUFFIX)
            .inactiveReason(UPDATED_INACTIVE_REASON)
            .iataConsortia(UPDATED_IATA_CONSORTIA)
            .psuedoProfileYn(UPDATED_PSUEDO_PROFILE_YN)
            .profilePrivacyFlg(UPDATED_PROFILE_PRIVACY_FLG)
            .replaceAddress(UPDATED_REPLACE_ADDRESS)
            .alienRegistrationNo(UPDATED_ALIEN_REGISTRATION_NO)
            .immigrationStatus(UPDATED_IMMIGRATION_STATUS)
            .visaValidityType(UPDATED_VISA_VALIDITY_TYPE)
            .idDocumentAttachId(UPDATED_ID_DOCUMENT_ATTACH_ID)
            .superSearchIndexText(UPDATED_SUPER_SEARCH_INDEX_TEXT)
            .birthDateStr(UPDATED_BIRTH_DATE_STR)
            .origNameId(UPDATED_ORIG_NAME_ID)
            .dOptInMailListFlg(UPDATED_D_OPT_IN_MAIL_LIST_FLG)
            .dOptInMarketResearchFlg(UPDATED_D_OPT_IN_MARKET_RESEARCH_FLG)
            .dOptInThirdPartyFlg(UPDATED_D_OPT_IN_THIRD_PARTY_FLG)
            .dOptInAutoenrollMemberFlg(UPDATED_D_OPT_IN_AUTOENROLL_MEMBER_FLG)
            .dOptInEmailFlg(UPDATED_D_OPT_IN_EMAIL_FLG)
            .dOptInPhoneFlg(UPDATED_D_OPT_IN_PHONE_FLG)
            .dOptInSmsFlg(UPDATED_D_OPT_IN_SMS_FLG)
            .dOptInGuestPrivFlg(UPDATED_D_OPT_IN_GUEST_PRIV_FLG)
            .arCreditLimitYn(UPDATED_AR_CREDIT_LIMIT_YN)
            .profileCreditLimit(UPDATED_PROFILE_CREDIT_LIMIT)
            .xmiddleName(UPDATED_XMIDDLE_NAME)
            .eInvoiceLiableYn(UPDATED_E_INVOICE_LIABLE_YN)
            .eInvLiableLastUpdated(UPDATED_E_INV_LIABLE_LAST_UPDATED)
            .internalBillYn(UPDATED_INTERNAL_BILL_YN)
            .compPreApprovalRequiredYn(UPDATED_COMP_PRE_APPROVAL_REQUIRED_YN)
            .anonymizationStatus(UPDATED_ANONYMIZATION_STATUS)
            .anonymizationDate(UPDATED_ANONYMIZATION_DATE);
        return name;
    }

    @BeforeEach
    public void initTest() {
        name = createEntity(em);
    }

    @Test
    @Transactional
    void createName() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Name
        var returnedName = om.readValue(
            restNameMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(name)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            Name.class
        );

        // Validate the Name in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertNameUpdatableFieldsEquals(returnedName, getPersistedName(returnedName));
    }

    @Test
    @Transactional
    void createNameWithExistingId() throws Exception {
        // Create the Name with an existing ID
        name.setId(1);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restNameMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(name)))
            .andExpect(status().isBadRequest());

        // Validate the Name in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllNames() throws Exception {
        // Initialize the database
        nameRepository.saveAndFlush(name);

        // Get all the nameList
        restNameMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(name.getId().intValue())))
            .andExpect(jsonPath("$.[*].nameId").value(hasItem(DEFAULT_NAME_ID)))
            .andExpect(jsonPath("$.[*].nameCode").value(hasItem(DEFAULT_NAME_CODE)))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].primaryNameId").value(hasItem(DEFAULT_PRIMARY_NAME_ID)))
            .andExpect(jsonPath("$.[*].repeatGuestId").value(hasItem(DEFAULT_REPEAT_GUEST_ID)))
            .andExpect(jsonPath("$.[*].mailList").value(hasItem(DEFAULT_MAIL_LIST)))
            .andExpect(jsonPath("$.[*].mailType").value(hasItem(DEFAULT_MAIL_TYPE)))
            .andExpect(jsonPath("$.[*].followOn").value(hasItem(DEFAULT_FOLLOW_ON)))
            .andExpect(jsonPath("$.[*].businessTitle").value(hasItem(DEFAULT_BUSINESS_TITLE)))
            .andExpect(jsonPath("$.[*].inactiveDate").value(hasItem(DEFAULT_INACTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].arcUpdateDate").value(hasItem(DEFAULT_ARC_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateFaxDate").value(hasItem(DEFAULT_UPDATE_FAX_DATE.toString())))
            .andExpect(jsonPath("$.[*].birthDate").value(hasItem(DEFAULT_BIRTH_DATE.toString())))
            .andExpect(jsonPath("$.[*].collectionUserId").value(hasItem(DEFAULT_COLLECTION_USER_ID)))
            .andExpect(jsonPath("$.[*].company").value(hasItem(DEFAULT_COMPANY)))
            .andExpect(jsonPath("$.[*].soundExCompany").value(hasItem(DEFAULT_SOUND_EX_COMPANY)))
            .andExpect(jsonPath("$.[*].legalCompany").value(hasItem(DEFAULT_LEGAL_COMPANY)))
            .andExpect(jsonPath("$.[*].first").value(hasItem(DEFAULT_FIRST)))
            .andExpect(jsonPath("$.[*].middle").value(hasItem(DEFAULT_MIDDLE)))
            .andExpect(jsonPath("$.[*].last").value(hasItem(DEFAULT_LAST)))
            .andExpect(jsonPath("$.[*].nickname").value(hasItem(DEFAULT_NICKNAME)))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].soundExLast").value(hasItem(DEFAULT_SOUND_EX_LAST)))
            .andExpect(jsonPath("$.[*].externalReferenceRequ").value(hasItem(DEFAULT_EXTERNAL_REFERENCE_REQU)))
            .andExpect(jsonPath("$.[*].vipStatus").value(hasItem(DEFAULT_VIP_STATUS)))
            .andExpect(jsonPath("$.[*].vipAuthorization").value(hasItem(DEFAULT_VIP_AUTHORIZATION)))
            .andExpect(jsonPath("$.[*].billingProfileCode").value(hasItem(DEFAULT_BILLING_PROFILE_CODE)))
            .andExpect(jsonPath("$.[*].rateStructure").value(hasItem(DEFAULT_RATE_STRUCTURE)))
            .andExpect(jsonPath("$.[*].nameComment").value(hasItem(DEFAULT_NAME_COMMENT)))
            .andExpect(jsonPath("$.[*].tourOperatorType").value(hasItem(DEFAULT_TOUR_OPERATOR_TYPE)))
            .andExpect(jsonPath("$.[*].region").value(hasItem(DEFAULT_REGION)))
            .andExpect(jsonPath("$.[*].typeOf1099").value(hasItem(DEFAULT_TYPE_OF_1099)))
            .andExpect(jsonPath("$.[*].tax1No").value(hasItem(DEFAULT_TAX_1_NO)))
            .andExpect(jsonPath("$.[*].companyNameId").value(hasItem(DEFAULT_COMPANY_NAME_ID)))
            .andExpect(jsonPath("$.[*].externalReferenceRequired").value(hasItem(DEFAULT_EXTERNAL_REFERENCE_REQUIRED)))
            .andExpect(jsonPath("$.[*].vendorId").value(hasItem(DEFAULT_VENDOR_ID)))
            .andExpect(jsonPath("$.[*].vendorSiteId").value(hasItem(DEFAULT_VENDOR_SITE_ID)))
            .andExpect(jsonPath("$.[*].arcOfficeType").value(hasItem(DEFAULT_ARC_OFFICE_TYPE)))
            .andExpect(jsonPath("$.[*].tax2No").value(hasItem(DEFAULT_TAX_2_NO)))
            .andExpect(jsonPath("$.[*].arcMailFlag").value(hasItem(DEFAULT_ARC_MAIL_FLAG)))
            .andExpect(jsonPath("$.[*].name2").value(hasItem(DEFAULT_NAME_2)))
            .andExpect(jsonPath("$.[*].name3").value(hasItem(DEFAULT_NAME_3)))
            .andExpect(jsonPath("$.[*].salesrep").value(hasItem(DEFAULT_SALESREP)))
            .andExpect(jsonPath("$.[*].tracecode").value(hasItem(DEFAULT_TRACECODE)))
            .andExpect(jsonPath("$.[*].geographicRegion").value(hasItem(DEFAULT_GEOGRAPHIC_REGION)))
            .andExpect(jsonPath("$.[*].guestClassification").value(hasItem(DEFAULT_GUEST_CLASSIFICATION)))
            .andExpect(jsonPath("$.[*].primaryAddressId").value(hasItem(DEFAULT_PRIMARY_ADDRESS_ID)))
            .andExpect(jsonPath("$.[*].primaryPhoneId").value(hasItem(DEFAULT_PRIMARY_PHONE_ID)))
            .andExpect(jsonPath("$.[*].taxExemptStatus").value(hasItem(DEFAULT_TAX_EXEMPT_STATUS)))
            .andExpect(jsonPath("$.[*].gdsName").value(hasItem(DEFAULT_GDS_NAME)))
            .andExpect(jsonPath("$.[*].gdsTransactionNo").value(hasItem(DEFAULT_GDS_TRANSACTION_NO)))
            .andExpect(jsonPath("$.[*].nationality").value(hasItem(DEFAULT_NATIONALITY)))
            .andExpect(jsonPath("$.[*].language").value(hasItem(DEFAULT_LANGUAGE)))
            .andExpect(jsonPath("$.[*].salutation").value(hasItem(DEFAULT_SALUTATION)))
            .andExpect(jsonPath("$.[*].passport").value(hasItem(DEFAULT_PASSPORT)))
            .andExpect(jsonPath("$.[*].historyYn").value(hasItem(DEFAULT_HISTORY_YN)))
            .andExpect(jsonPath("$.[*].resvContact").value(hasItem(DEFAULT_RESV_CONTACT)))
            .andExpect(jsonPath("$.[*].contractNo").value(hasItem(DEFAULT_CONTRACT_NO)))
            .andExpect(jsonPath("$.[*].contractRecvDate").value(hasItem(DEFAULT_CONTRACT_RECV_DATE.toString())))
            .andExpect(jsonPath("$.[*].acctContact").value(hasItem(DEFAULT_ACCT_CONTACT)))
            .andExpect(jsonPath("$.[*].priority").value(hasItem(DEFAULT_PRIORITY)))
            .andExpect(jsonPath("$.[*].industryCode").value(hasItem(DEFAULT_INDUSTRY_CODE)))
            .andExpect(jsonPath("$.[*].roomsPotential").value(hasItem(DEFAULT_ROOMS_POTENTIAL)))
            .andExpect(jsonPath("$.[*].competitionCode").value(hasItem(DEFAULT_COMPETITION_CODE)))
            .andExpect(jsonPath("$.[*].scope").value(hasItem(DEFAULT_SCOPE)))
            .andExpect(jsonPath("$.[*].scopeCity").value(hasItem(DEFAULT_SCOPE_CITY)))
            .andExpect(jsonPath("$.[*].territory").value(hasItem(DEFAULT_TERRITORY)))
            .andExpect(jsonPath("$.[*].actioncode").value(hasItem(DEFAULT_ACTIONCODE)))
            .andExpect(jsonPath("$.[*].activeYn").value(hasItem(DEFAULT_ACTIVE_YN)))
            .andExpect(jsonPath("$.[*].masterAccountYn").value(hasItem(DEFAULT_MASTER_ACCOUNT_YN)))
            .andExpect(jsonPath("$.[*].nameType").value(hasItem(DEFAULT_NAME_TYPE)))
            .andExpect(jsonPath("$.[*].sname").value(hasItem(DEFAULT_SNAME)))
            .andExpect(jsonPath("$.[*].nameTaxType").value(hasItem(DEFAULT_NAME_TAX_TYPE)))
            .andExpect(jsonPath("$.[*].sfirst").value(hasItem(DEFAULT_SFIRST)))
            .andExpect(jsonPath("$.[*].arNo").value(hasItem(DEFAULT_AR_NO)))
            .andExpect(jsonPath("$.[*].availabilityOverride").value(hasItem(DEFAULT_AVAILABILITY_OVERRIDE)))
            .andExpect(jsonPath("$.[*].billingCode").value(hasItem(DEFAULT_BILLING_CODE)))
            .andExpect(jsonPath("$.[*].cashBlInd").value(hasItem(DEFAULT_CASH_BL_IND)))
            .andExpect(jsonPath("$.[*].blMsg").value(hasItem(DEFAULT_BL_MSG)))
            .andExpect(jsonPath("$.[*].currencyCode").value(hasItem(DEFAULT_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].commissionCode").value(hasItem(DEFAULT_COMMISSION_CODE)))
            .andExpect(jsonPath("$.[*].holdCode").value(hasItem(DEFAULT_HOLD_CODE)))
            .andExpect(jsonPath("$.[*].interest").value(hasItem(DEFAULT_INTEREST)))
            .andExpect(jsonPath("$.[*].summRefCc").value(hasItem(DEFAULT_SUMM_REF_CC)))
            .andExpect(jsonPath("$.[*].iataCompType").value(hasItem(DEFAULT_IATA_COMP_TYPE)))
            .andExpect(jsonPath("$.[*].srepCode").value(hasItem(DEFAULT_SREP_CODE)))
            .andExpect(jsonPath("$.[*].accountsource").value(hasItem(DEFAULT_ACCOUNTSOURCE)))
            .andExpect(jsonPath("$.[*].markets").value(hasItem(DEFAULT_MARKETS)))
            .andExpect(jsonPath("$.[*].productInterest").value(hasItem(DEFAULT_PRODUCT_INTEREST)))
            .andExpect(jsonPath("$.[*].keyword").value(hasItem(DEFAULT_KEYWORD)))
            .andExpect(jsonPath("$.[*].letterGreeting").value(hasItem(DEFAULT_LETTER_GREETING)))
            .andExpect(jsonPath("$.[*].influence").value(hasItem(DEFAULT_INFLUENCE)))
            .andExpect(jsonPath("$.[*].deptId").value(hasItem(DEFAULT_DEPT_ID)))
            .andExpect(jsonPath("$.[*].department").value(hasItem(DEFAULT_DEPARTMENT)))
            .andExpect(jsonPath("$.[*].contactYn").value(hasItem(DEFAULT_CONTACT_YN)))
            .andExpect(jsonPath("$.[*].accountType").value(hasItem(DEFAULT_ACCOUNT_TYPE)))
            .andExpect(jsonPath("$.[*].downloadResort").value(hasItem(DEFAULT_DOWNLOAD_RESORT)))
            .andExpect(jsonPath("$.[*].downloadSrep").value(hasItem(DEFAULT_DOWNLOAD_SREP)))
            .andExpect(jsonPath("$.[*].downloadDate").value(hasItem(DEFAULT_DOWNLOAD_DATE.toString())))
            .andExpect(jsonPath("$.[*].uploadDate").value(hasItem(DEFAULT_UPLOAD_DATE.toString())))
            .andExpect(jsonPath("$.[*].laptopChange").value(hasItem(DEFAULT_LAPTOP_CHANGE)))
            .andExpect(jsonPath("$.[*].crsNameid").value(hasItem(DEFAULT_CRS_NAMEID)))
            .andExpect(jsonPath("$.[*].commPayCentral").value(hasItem(DEFAULT_COMM_PAY_CENTRAL)))
            .andExpect(jsonPath("$.[*].ccProfileYn").value(hasItem(DEFAULT_CC_PROFILE_YN)))
            .andExpect(jsonPath("$.[*].gender").value(hasItem(DEFAULT_GENDER)))
            .andExpect(jsonPath("$.[*].birthPlace").value(hasItem(DEFAULT_BIRTH_PLACE)))
            .andExpect(jsonPath("$.[*].birthCountry").value(hasItem(DEFAULT_BIRTH_COUNTRY)))
            .andExpect(jsonPath("$.[*].profession").value(hasItem(DEFAULT_PROFESSION)))
            .andExpect(jsonPath("$.[*].idType").value(hasItem(DEFAULT_ID_TYPE)))
            .andExpect(jsonPath("$.[*].idNumber").value(hasItem(DEFAULT_ID_NUMBER)))
            .andExpect(jsonPath("$.[*].idDate").value(hasItem(DEFAULT_ID_DATE.toString())))
            .andExpect(jsonPath("$.[*].idPlace").value(hasItem(DEFAULT_ID_PLACE)))
            .andExpect(jsonPath("$.[*].idCountry").value(hasItem(DEFAULT_ID_COUNTRY)))
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
            .andExpect(jsonPath("$.[*].udfd11").value(hasItem(DEFAULT_UDFD_11.toString())))
            .andExpect(jsonPath("$.[*].udfd12").value(hasItem(DEFAULT_UDFD_12.toString())))
            .andExpect(jsonPath("$.[*].udfd13").value(hasItem(DEFAULT_UDFD_13.toString())))
            .andExpect(jsonPath("$.[*].udfd14").value(hasItem(DEFAULT_UDFD_14.toString())))
            .andExpect(jsonPath("$.[*].udfd15").value(hasItem(DEFAULT_UDFD_15.toString())))
            .andExpect(jsonPath("$.[*].udfd16").value(hasItem(DEFAULT_UDFD_16.toString())))
            .andExpect(jsonPath("$.[*].udfd17").value(hasItem(DEFAULT_UDFD_17.toString())))
            .andExpect(jsonPath("$.[*].udfd18").value(hasItem(DEFAULT_UDFD_18.toString())))
            .andExpect(jsonPath("$.[*].udfd19").value(hasItem(DEFAULT_UDFD_19.toString())))
            .andExpect(jsonPath("$.[*].udfd20").value(hasItem(DEFAULT_UDFD_20.toString())))
            .andExpect(jsonPath("$.[*].paymentDueDays").value(hasItem(DEFAULT_PAYMENT_DUE_DAYS)))
            .andExpect(jsonPath("$.[*].suffix").value(hasItem(DEFAULT_SUFFIX)))
            .andExpect(jsonPath("$.[*].externalId").value(hasItem(DEFAULT_EXTERNAL_ID)))
            .andExpect(jsonPath("$.[*].guestPrivYn").value(hasItem(DEFAULT_GUEST_PRIV_YN)))
            .andExpect(jsonPath("$.[*].emailYn").value(hasItem(DEFAULT_EMAIL_YN)))
            .andExpect(jsonPath("$.[*].mailYn").value(hasItem(DEFAULT_MAIL_YN)))
            .andExpect(jsonPath("$.[*].indexName").value(hasItem(DEFAULT_INDEX_NAME)))
            .andExpect(jsonPath("$.[*].xlastName").value(hasItem(DEFAULT_XLAST_NAME)))
            .andExpect(jsonPath("$.[*].xfirstName").value(hasItem(DEFAULT_XFIRST_NAME)))
            .andExpect(jsonPath("$.[*].xcompanyName").value(hasItem(DEFAULT_XCOMPANY_NAME)))
            .andExpect(jsonPath("$.[*].xtitle").value(hasItem(DEFAULT_XTITLE)))
            .andExpect(jsonPath("$.[*].xsalutation").value(hasItem(DEFAULT_XSALUTATION)))
            .andExpect(jsonPath("$.[*].sxname").value(hasItem(DEFAULT_SXNAME)))
            .andExpect(jsonPath("$.[*].sxfirstName").value(hasItem(DEFAULT_SXFIRST_NAME)))
            .andExpect(jsonPath("$.[*].lastUpdatedResort").value(hasItem(DEFAULT_LAST_UPDATED_RESORT)))
            .andExpect(jsonPath("$.[*].envelopeGreeting").value(hasItem(DEFAULT_ENVELOPE_GREETING)))
            .andExpect(jsonPath("$.[*].xenvelopeGreeting").value(hasItem(DEFAULT_XENVELOPE_GREETING)))
            .andExpect(jsonPath("$.[*].directBillBatchType").value(hasItem(DEFAULT_DIRECT_BILL_BATCH_TYPE)))
            .andExpect(jsonPath("$.[*].resortRegistered").value(hasItem(DEFAULT_RESORT_REGISTERED)))
            .andExpect(jsonPath("$.[*].taxOffice").value(hasItem(DEFAULT_TAX_OFFICE)))
            .andExpect(jsonPath("$.[*].taxType").value(hasItem(DEFAULT_TAX_TYPE)))
            .andExpect(jsonPath("$.[*].taxCategory").value(hasItem(DEFAULT_TAX_CATEGORY)))
            .andExpect(jsonPath("$.[*].preferredRoomNo").value(hasItem(DEFAULT_PREFERRED_ROOM_NO)))
            .andExpect(jsonPath("$.[*].phoneYn").value(hasItem(DEFAULT_PHONE_YN)))
            .andExpect(jsonPath("$.[*].smsYn").value(hasItem(DEFAULT_SMS_YN)))
            .andExpect(jsonPath("$.[*].isProtected").value(hasItem(DEFAULT_IS_PROTECTED)))
            .andExpect(jsonPath("$.[*].xlanguage").value(hasItem(DEFAULT_XLANGUAGE)))
            .andExpect(jsonPath("$.[*].marketResearchYn").value(hasItem(DEFAULT_MARKET_RESEARCH_YN)))
            .andExpect(jsonPath("$.[*].thirdPartyYn").value(hasItem(DEFAULT_THIRD_PARTY_YN)))
            .andExpect(jsonPath("$.[*].autoenrollMemberYn").value(hasItem(DEFAULT_AUTOENROLL_MEMBER_YN)))
            .andExpect(jsonPath("$.[*].chainCode").value(hasItem(DEFAULT_CHAIN_CODE)))
            .andExpect(jsonPath("$.[*].companyGroupId").value(hasItem(DEFAULT_COMPANY_GROUP_ID)))
            .andExpect(jsonPath("$.[*].includeIn1099Yn").value(hasItem(DEFAULT_INCLUDE_IN_1099_YN)))
            .andExpect(jsonPath("$.[*].creditRating").value(hasItem(DEFAULT_CREDIT_RATING)))
            .andExpect(jsonPath("$.[*].titleSuffix").value(hasItem(DEFAULT_TITLE_SUFFIX)))
            .andExpect(jsonPath("$.[*].inactiveReason").value(hasItem(DEFAULT_INACTIVE_REASON)))
            .andExpect(jsonPath("$.[*].iataConsortia").value(hasItem(DEFAULT_IATA_CONSORTIA)))
            .andExpect(jsonPath("$.[*].psuedoProfileYn").value(hasItem(DEFAULT_PSUEDO_PROFILE_YN)))
            .andExpect(jsonPath("$.[*].profilePrivacyFlg").value(hasItem(DEFAULT_PROFILE_PRIVACY_FLG)))
            .andExpect(jsonPath("$.[*].replaceAddress").value(hasItem(DEFAULT_REPLACE_ADDRESS)))
            .andExpect(jsonPath("$.[*].alienRegistrationNo").value(hasItem(DEFAULT_ALIEN_REGISTRATION_NO)))
            .andExpect(jsonPath("$.[*].immigrationStatus").value(hasItem(DEFAULT_IMMIGRATION_STATUS)))
            .andExpect(jsonPath("$.[*].visaValidityType").value(hasItem(DEFAULT_VISA_VALIDITY_TYPE)))
            .andExpect(jsonPath("$.[*].idDocumentAttachId").value(hasItem(DEFAULT_ID_DOCUMENT_ATTACH_ID)))
            .andExpect(jsonPath("$.[*].superSearchIndexText").value(hasItem(DEFAULT_SUPER_SEARCH_INDEX_TEXT)))
            .andExpect(jsonPath("$.[*].birthDateStr").value(hasItem(DEFAULT_BIRTH_DATE_STR)))
            .andExpect(jsonPath("$.[*].origNameId").value(hasItem(DEFAULT_ORIG_NAME_ID)))
            .andExpect(jsonPath("$.[*].dOptInMailListFlg").value(hasItem(DEFAULT_D_OPT_IN_MAIL_LIST_FLG)))
            .andExpect(jsonPath("$.[*].dOptInMarketResearchFlg").value(hasItem(DEFAULT_D_OPT_IN_MARKET_RESEARCH_FLG)))
            .andExpect(jsonPath("$.[*].dOptInThirdPartyFlg").value(hasItem(DEFAULT_D_OPT_IN_THIRD_PARTY_FLG)))
            .andExpect(jsonPath("$.[*].dOptInAutoenrollMemberFlg").value(hasItem(DEFAULT_D_OPT_IN_AUTOENROLL_MEMBER_FLG)))
            .andExpect(jsonPath("$.[*].dOptInEmailFlg").value(hasItem(DEFAULT_D_OPT_IN_EMAIL_FLG)))
            .andExpect(jsonPath("$.[*].dOptInPhoneFlg").value(hasItem(DEFAULT_D_OPT_IN_PHONE_FLG)))
            .andExpect(jsonPath("$.[*].dOptInSmsFlg").value(hasItem(DEFAULT_D_OPT_IN_SMS_FLG)))
            .andExpect(jsonPath("$.[*].dOptInGuestPrivFlg").value(hasItem(DEFAULT_D_OPT_IN_GUEST_PRIV_FLG)))
            .andExpect(jsonPath("$.[*].arCreditLimitYn").value(hasItem(DEFAULT_AR_CREDIT_LIMIT_YN)))
            .andExpect(jsonPath("$.[*].profileCreditLimit").value(hasItem(DEFAULT_PROFILE_CREDIT_LIMIT)))
            .andExpect(jsonPath("$.[*].xmiddleName").value(hasItem(DEFAULT_XMIDDLE_NAME)))
            .andExpect(jsonPath("$.[*].eInvoiceLiableYn").value(hasItem(DEFAULT_E_INVOICE_LIABLE_YN)))
            .andExpect(jsonPath("$.[*].eInvLiableLastUpdated").value(hasItem(DEFAULT_E_INV_LIABLE_LAST_UPDATED.toString())))
            .andExpect(jsonPath("$.[*].internalBillYn").value(hasItem(DEFAULT_INTERNAL_BILL_YN)))
            .andExpect(jsonPath("$.[*].compPreApprovalRequiredYn").value(hasItem(DEFAULT_COMP_PRE_APPROVAL_REQUIRED_YN)))
            .andExpect(jsonPath("$.[*].anonymizationStatus").value(hasItem(DEFAULT_ANONYMIZATION_STATUS)))
            .andExpect(jsonPath("$.[*].anonymizationDate").value(hasItem(DEFAULT_ANONYMIZATION_DATE.toString())));
    }

    @Test
    @Transactional
    void getName() throws Exception {
        // Initialize the database
        nameRepository.saveAndFlush(name);

        // Get the name
        restNameMockMvc
            .perform(get(ENTITY_API_URL_ID, name.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(name.getId().intValue()))
            .andExpect(jsonPath("$.nameId").value(DEFAULT_NAME_ID))
            .andExpect(jsonPath("$.nameCode").value(DEFAULT_NAME_CODE))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.primaryNameId").value(DEFAULT_PRIMARY_NAME_ID))
            .andExpect(jsonPath("$.repeatGuestId").value(DEFAULT_REPEAT_GUEST_ID))
            .andExpect(jsonPath("$.mailList").value(DEFAULT_MAIL_LIST))
            .andExpect(jsonPath("$.mailType").value(DEFAULT_MAIL_TYPE))
            .andExpect(jsonPath("$.followOn").value(DEFAULT_FOLLOW_ON))
            .andExpect(jsonPath("$.businessTitle").value(DEFAULT_BUSINESS_TITLE))
            .andExpect(jsonPath("$.inactiveDate").value(DEFAULT_INACTIVE_DATE.toString()))
            .andExpect(jsonPath("$.arcUpdateDate").value(DEFAULT_ARC_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.updateFaxDate").value(DEFAULT_UPDATE_FAX_DATE.toString()))
            .andExpect(jsonPath("$.birthDate").value(DEFAULT_BIRTH_DATE.toString()))
            .andExpect(jsonPath("$.collectionUserId").value(DEFAULT_COLLECTION_USER_ID))
            .andExpect(jsonPath("$.company").value(DEFAULT_COMPANY))
            .andExpect(jsonPath("$.soundExCompany").value(DEFAULT_SOUND_EX_COMPANY))
            .andExpect(jsonPath("$.legalCompany").value(DEFAULT_LEGAL_COMPANY))
            .andExpect(jsonPath("$.first").value(DEFAULT_FIRST))
            .andExpect(jsonPath("$.middle").value(DEFAULT_MIDDLE))
            .andExpect(jsonPath("$.last").value(DEFAULT_LAST))
            .andExpect(jsonPath("$.nickname").value(DEFAULT_NICKNAME))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.soundExLast").value(DEFAULT_SOUND_EX_LAST))
            .andExpect(jsonPath("$.externalReferenceRequ").value(DEFAULT_EXTERNAL_REFERENCE_REQU))
            .andExpect(jsonPath("$.vipStatus").value(DEFAULT_VIP_STATUS))
            .andExpect(jsonPath("$.vipAuthorization").value(DEFAULT_VIP_AUTHORIZATION))
            .andExpect(jsonPath("$.billingProfileCode").value(DEFAULT_BILLING_PROFILE_CODE))
            .andExpect(jsonPath("$.rateStructure").value(DEFAULT_RATE_STRUCTURE))
            .andExpect(jsonPath("$.nameComment").value(DEFAULT_NAME_COMMENT))
            .andExpect(jsonPath("$.tourOperatorType").value(DEFAULT_TOUR_OPERATOR_TYPE))
            .andExpect(jsonPath("$.region").value(DEFAULT_REGION))
            .andExpect(jsonPath("$.typeOf1099").value(DEFAULT_TYPE_OF_1099))
            .andExpect(jsonPath("$.tax1No").value(DEFAULT_TAX_1_NO))
            .andExpect(jsonPath("$.companyNameId").value(DEFAULT_COMPANY_NAME_ID))
            .andExpect(jsonPath("$.externalReferenceRequired").value(DEFAULT_EXTERNAL_REFERENCE_REQUIRED))
            .andExpect(jsonPath("$.vendorId").value(DEFAULT_VENDOR_ID))
            .andExpect(jsonPath("$.vendorSiteId").value(DEFAULT_VENDOR_SITE_ID))
            .andExpect(jsonPath("$.arcOfficeType").value(DEFAULT_ARC_OFFICE_TYPE))
            .andExpect(jsonPath("$.tax2No").value(DEFAULT_TAX_2_NO))
            .andExpect(jsonPath("$.arcMailFlag").value(DEFAULT_ARC_MAIL_FLAG))
            .andExpect(jsonPath("$.name2").value(DEFAULT_NAME_2))
            .andExpect(jsonPath("$.name3").value(DEFAULT_NAME_3))
            .andExpect(jsonPath("$.salesrep").value(DEFAULT_SALESREP))
            .andExpect(jsonPath("$.tracecode").value(DEFAULT_TRACECODE))
            .andExpect(jsonPath("$.geographicRegion").value(DEFAULT_GEOGRAPHIC_REGION))
            .andExpect(jsonPath("$.guestClassification").value(DEFAULT_GUEST_CLASSIFICATION))
            .andExpect(jsonPath("$.primaryAddressId").value(DEFAULT_PRIMARY_ADDRESS_ID))
            .andExpect(jsonPath("$.primaryPhoneId").value(DEFAULT_PRIMARY_PHONE_ID))
            .andExpect(jsonPath("$.taxExemptStatus").value(DEFAULT_TAX_EXEMPT_STATUS))
            .andExpect(jsonPath("$.gdsName").value(DEFAULT_GDS_NAME))
            .andExpect(jsonPath("$.gdsTransactionNo").value(DEFAULT_GDS_TRANSACTION_NO))
            .andExpect(jsonPath("$.nationality").value(DEFAULT_NATIONALITY))
            .andExpect(jsonPath("$.language").value(DEFAULT_LANGUAGE))
            .andExpect(jsonPath("$.salutation").value(DEFAULT_SALUTATION))
            .andExpect(jsonPath("$.passport").value(DEFAULT_PASSPORT))
            .andExpect(jsonPath("$.historyYn").value(DEFAULT_HISTORY_YN))
            .andExpect(jsonPath("$.resvContact").value(DEFAULT_RESV_CONTACT))
            .andExpect(jsonPath("$.contractNo").value(DEFAULT_CONTRACT_NO))
            .andExpect(jsonPath("$.contractRecvDate").value(DEFAULT_CONTRACT_RECV_DATE.toString()))
            .andExpect(jsonPath("$.acctContact").value(DEFAULT_ACCT_CONTACT))
            .andExpect(jsonPath("$.priority").value(DEFAULT_PRIORITY))
            .andExpect(jsonPath("$.industryCode").value(DEFAULT_INDUSTRY_CODE))
            .andExpect(jsonPath("$.roomsPotential").value(DEFAULT_ROOMS_POTENTIAL))
            .andExpect(jsonPath("$.competitionCode").value(DEFAULT_COMPETITION_CODE))
            .andExpect(jsonPath("$.scope").value(DEFAULT_SCOPE))
            .andExpect(jsonPath("$.scopeCity").value(DEFAULT_SCOPE_CITY))
            .andExpect(jsonPath("$.territory").value(DEFAULT_TERRITORY))
            .andExpect(jsonPath("$.actioncode").value(DEFAULT_ACTIONCODE))
            .andExpect(jsonPath("$.activeYn").value(DEFAULT_ACTIVE_YN))
            .andExpect(jsonPath("$.masterAccountYn").value(DEFAULT_MASTER_ACCOUNT_YN))
            .andExpect(jsonPath("$.nameType").value(DEFAULT_NAME_TYPE))
            .andExpect(jsonPath("$.sname").value(DEFAULT_SNAME))
            .andExpect(jsonPath("$.nameTaxType").value(DEFAULT_NAME_TAX_TYPE))
            .andExpect(jsonPath("$.sfirst").value(DEFAULT_SFIRST))
            .andExpect(jsonPath("$.arNo").value(DEFAULT_AR_NO))
            .andExpect(jsonPath("$.availabilityOverride").value(DEFAULT_AVAILABILITY_OVERRIDE))
            .andExpect(jsonPath("$.billingCode").value(DEFAULT_BILLING_CODE))
            .andExpect(jsonPath("$.cashBlInd").value(DEFAULT_CASH_BL_IND))
            .andExpect(jsonPath("$.blMsg").value(DEFAULT_BL_MSG))
            .andExpect(jsonPath("$.currencyCode").value(DEFAULT_CURRENCY_CODE))
            .andExpect(jsonPath("$.commissionCode").value(DEFAULT_COMMISSION_CODE))
            .andExpect(jsonPath("$.holdCode").value(DEFAULT_HOLD_CODE))
            .andExpect(jsonPath("$.interest").value(DEFAULT_INTEREST))
            .andExpect(jsonPath("$.summRefCc").value(DEFAULT_SUMM_REF_CC))
            .andExpect(jsonPath("$.iataCompType").value(DEFAULT_IATA_COMP_TYPE))
            .andExpect(jsonPath("$.srepCode").value(DEFAULT_SREP_CODE))
            .andExpect(jsonPath("$.accountsource").value(DEFAULT_ACCOUNTSOURCE))
            .andExpect(jsonPath("$.markets").value(DEFAULT_MARKETS))
            .andExpect(jsonPath("$.productInterest").value(DEFAULT_PRODUCT_INTEREST))
            .andExpect(jsonPath("$.keyword").value(DEFAULT_KEYWORD))
            .andExpect(jsonPath("$.letterGreeting").value(DEFAULT_LETTER_GREETING))
            .andExpect(jsonPath("$.influence").value(DEFAULT_INFLUENCE))
            .andExpect(jsonPath("$.deptId").value(DEFAULT_DEPT_ID))
            .andExpect(jsonPath("$.department").value(DEFAULT_DEPARTMENT))
            .andExpect(jsonPath("$.contactYn").value(DEFAULT_CONTACT_YN))
            .andExpect(jsonPath("$.accountType").value(DEFAULT_ACCOUNT_TYPE))
            .andExpect(jsonPath("$.downloadResort").value(DEFAULT_DOWNLOAD_RESORT))
            .andExpect(jsonPath("$.downloadSrep").value(DEFAULT_DOWNLOAD_SREP))
            .andExpect(jsonPath("$.downloadDate").value(DEFAULT_DOWNLOAD_DATE.toString()))
            .andExpect(jsonPath("$.uploadDate").value(DEFAULT_UPLOAD_DATE.toString()))
            .andExpect(jsonPath("$.laptopChange").value(DEFAULT_LAPTOP_CHANGE))
            .andExpect(jsonPath("$.crsNameid").value(DEFAULT_CRS_NAMEID))
            .andExpect(jsonPath("$.commPayCentral").value(DEFAULT_COMM_PAY_CENTRAL))
            .andExpect(jsonPath("$.ccProfileYn").value(DEFAULT_CC_PROFILE_YN))
            .andExpect(jsonPath("$.gender").value(DEFAULT_GENDER))
            .andExpect(jsonPath("$.birthPlace").value(DEFAULT_BIRTH_PLACE))
            .andExpect(jsonPath("$.birthCountry").value(DEFAULT_BIRTH_COUNTRY))
            .andExpect(jsonPath("$.profession").value(DEFAULT_PROFESSION))
            .andExpect(jsonPath("$.idType").value(DEFAULT_ID_TYPE))
            .andExpect(jsonPath("$.idNumber").value(DEFAULT_ID_NUMBER))
            .andExpect(jsonPath("$.idDate").value(DEFAULT_ID_DATE.toString()))
            .andExpect(jsonPath("$.idPlace").value(DEFAULT_ID_PLACE))
            .andExpect(jsonPath("$.idCountry").value(DEFAULT_ID_COUNTRY))
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
            .andExpect(jsonPath("$.udfd11").value(DEFAULT_UDFD_11.toString()))
            .andExpect(jsonPath("$.udfd12").value(DEFAULT_UDFD_12.toString()))
            .andExpect(jsonPath("$.udfd13").value(DEFAULT_UDFD_13.toString()))
            .andExpect(jsonPath("$.udfd14").value(DEFAULT_UDFD_14.toString()))
            .andExpect(jsonPath("$.udfd15").value(DEFAULT_UDFD_15.toString()))
            .andExpect(jsonPath("$.udfd16").value(DEFAULT_UDFD_16.toString()))
            .andExpect(jsonPath("$.udfd17").value(DEFAULT_UDFD_17.toString()))
            .andExpect(jsonPath("$.udfd18").value(DEFAULT_UDFD_18.toString()))
            .andExpect(jsonPath("$.udfd19").value(DEFAULT_UDFD_19.toString()))
            .andExpect(jsonPath("$.udfd20").value(DEFAULT_UDFD_20.toString()))
            .andExpect(jsonPath("$.paymentDueDays").value(DEFAULT_PAYMENT_DUE_DAYS))
            .andExpect(jsonPath("$.suffix").value(DEFAULT_SUFFIX))
            .andExpect(jsonPath("$.externalId").value(DEFAULT_EXTERNAL_ID))
            .andExpect(jsonPath("$.guestPrivYn").value(DEFAULT_GUEST_PRIV_YN))
            .andExpect(jsonPath("$.emailYn").value(DEFAULT_EMAIL_YN))
            .andExpect(jsonPath("$.mailYn").value(DEFAULT_MAIL_YN))
            .andExpect(jsonPath("$.indexName").value(DEFAULT_INDEX_NAME))
            .andExpect(jsonPath("$.xlastName").value(DEFAULT_XLAST_NAME))
            .andExpect(jsonPath("$.xfirstName").value(DEFAULT_XFIRST_NAME))
            .andExpect(jsonPath("$.xcompanyName").value(DEFAULT_XCOMPANY_NAME))
            .andExpect(jsonPath("$.xtitle").value(DEFAULT_XTITLE))
            .andExpect(jsonPath("$.xsalutation").value(DEFAULT_XSALUTATION))
            .andExpect(jsonPath("$.sxname").value(DEFAULT_SXNAME))
            .andExpect(jsonPath("$.sxfirstName").value(DEFAULT_SXFIRST_NAME))
            .andExpect(jsonPath("$.lastUpdatedResort").value(DEFAULT_LAST_UPDATED_RESORT))
            .andExpect(jsonPath("$.envelopeGreeting").value(DEFAULT_ENVELOPE_GREETING))
            .andExpect(jsonPath("$.xenvelopeGreeting").value(DEFAULT_XENVELOPE_GREETING))
            .andExpect(jsonPath("$.directBillBatchType").value(DEFAULT_DIRECT_BILL_BATCH_TYPE))
            .andExpect(jsonPath("$.resortRegistered").value(DEFAULT_RESORT_REGISTERED))
            .andExpect(jsonPath("$.taxOffice").value(DEFAULT_TAX_OFFICE))
            .andExpect(jsonPath("$.taxType").value(DEFAULT_TAX_TYPE))
            .andExpect(jsonPath("$.taxCategory").value(DEFAULT_TAX_CATEGORY))
            .andExpect(jsonPath("$.preferredRoomNo").value(DEFAULT_PREFERRED_ROOM_NO))
            .andExpect(jsonPath("$.phoneYn").value(DEFAULT_PHONE_YN))
            .andExpect(jsonPath("$.smsYn").value(DEFAULT_SMS_YN))
            .andExpect(jsonPath("$.isProtected").value(DEFAULT_IS_PROTECTED))
            .andExpect(jsonPath("$.xlanguage").value(DEFAULT_XLANGUAGE))
            .andExpect(jsonPath("$.marketResearchYn").value(DEFAULT_MARKET_RESEARCH_YN))
            .andExpect(jsonPath("$.thirdPartyYn").value(DEFAULT_THIRD_PARTY_YN))
            .andExpect(jsonPath("$.autoenrollMemberYn").value(DEFAULT_AUTOENROLL_MEMBER_YN))
            .andExpect(jsonPath("$.chainCode").value(DEFAULT_CHAIN_CODE))
            .andExpect(jsonPath("$.companyGroupId").value(DEFAULT_COMPANY_GROUP_ID))
            .andExpect(jsonPath("$.includeIn1099Yn").value(DEFAULT_INCLUDE_IN_1099_YN))
            .andExpect(jsonPath("$.creditRating").value(DEFAULT_CREDIT_RATING))
            .andExpect(jsonPath("$.titleSuffix").value(DEFAULT_TITLE_SUFFIX))
            .andExpect(jsonPath("$.inactiveReason").value(DEFAULT_INACTIVE_REASON))
            .andExpect(jsonPath("$.iataConsortia").value(DEFAULT_IATA_CONSORTIA))
            .andExpect(jsonPath("$.psuedoProfileYn").value(DEFAULT_PSUEDO_PROFILE_YN))
            .andExpect(jsonPath("$.profilePrivacyFlg").value(DEFAULT_PROFILE_PRIVACY_FLG))
            .andExpect(jsonPath("$.replaceAddress").value(DEFAULT_REPLACE_ADDRESS))
            .andExpect(jsonPath("$.alienRegistrationNo").value(DEFAULT_ALIEN_REGISTRATION_NO))
            .andExpect(jsonPath("$.immigrationStatus").value(DEFAULT_IMMIGRATION_STATUS))
            .andExpect(jsonPath("$.visaValidityType").value(DEFAULT_VISA_VALIDITY_TYPE))
            .andExpect(jsonPath("$.idDocumentAttachId").value(DEFAULT_ID_DOCUMENT_ATTACH_ID))
            .andExpect(jsonPath("$.superSearchIndexText").value(DEFAULT_SUPER_SEARCH_INDEX_TEXT))
            .andExpect(jsonPath("$.birthDateStr").value(DEFAULT_BIRTH_DATE_STR))
            .andExpect(jsonPath("$.origNameId").value(DEFAULT_ORIG_NAME_ID))
            .andExpect(jsonPath("$.dOptInMailListFlg").value(DEFAULT_D_OPT_IN_MAIL_LIST_FLG))
            .andExpect(jsonPath("$.dOptInMarketResearchFlg").value(DEFAULT_D_OPT_IN_MARKET_RESEARCH_FLG))
            .andExpect(jsonPath("$.dOptInThirdPartyFlg").value(DEFAULT_D_OPT_IN_THIRD_PARTY_FLG))
            .andExpect(jsonPath("$.dOptInAutoenrollMemberFlg").value(DEFAULT_D_OPT_IN_AUTOENROLL_MEMBER_FLG))
            .andExpect(jsonPath("$.dOptInEmailFlg").value(DEFAULT_D_OPT_IN_EMAIL_FLG))
            .andExpect(jsonPath("$.dOptInPhoneFlg").value(DEFAULT_D_OPT_IN_PHONE_FLG))
            .andExpect(jsonPath("$.dOptInSmsFlg").value(DEFAULT_D_OPT_IN_SMS_FLG))
            .andExpect(jsonPath("$.dOptInGuestPrivFlg").value(DEFAULT_D_OPT_IN_GUEST_PRIV_FLG))
            .andExpect(jsonPath("$.arCreditLimitYn").value(DEFAULT_AR_CREDIT_LIMIT_YN))
            .andExpect(jsonPath("$.profileCreditLimit").value(DEFAULT_PROFILE_CREDIT_LIMIT))
            .andExpect(jsonPath("$.xmiddleName").value(DEFAULT_XMIDDLE_NAME))
            .andExpect(jsonPath("$.eInvoiceLiableYn").value(DEFAULT_E_INVOICE_LIABLE_YN))
            .andExpect(jsonPath("$.eInvLiableLastUpdated").value(DEFAULT_E_INV_LIABLE_LAST_UPDATED.toString()))
            .andExpect(jsonPath("$.internalBillYn").value(DEFAULT_INTERNAL_BILL_YN))
            .andExpect(jsonPath("$.compPreApprovalRequiredYn").value(DEFAULT_COMP_PRE_APPROVAL_REQUIRED_YN))
            .andExpect(jsonPath("$.anonymizationStatus").value(DEFAULT_ANONYMIZATION_STATUS))
            .andExpect(jsonPath("$.anonymizationDate").value(DEFAULT_ANONYMIZATION_DATE.toString()));
    }

    @Test
    @Transactional
    void getNonExistingName() throws Exception {
        // Get the name
        restNameMockMvc.perform(get(ENTITY_API_URL_ID, Integer.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingName() throws Exception {
        // Initialize the database
        nameRepository.saveAndFlush(name);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the name
        Name updatedName = nameRepository.findById(name.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedName are not directly saved in db
        em.detach(updatedName);
        updatedName
            .nameId(UPDATED_NAME_ID)
            .nameCode(UPDATED_NAME_CODE)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .primaryNameId(UPDATED_PRIMARY_NAME_ID)
            .repeatGuestId(UPDATED_REPEAT_GUEST_ID)
            .mailList(UPDATED_MAIL_LIST)
            .mailType(UPDATED_MAIL_TYPE)
            .followOn(UPDATED_FOLLOW_ON)
            .businessTitle(UPDATED_BUSINESS_TITLE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .arcUpdateDate(UPDATED_ARC_UPDATE_DATE)
            .updateFaxDate(UPDATED_UPDATE_FAX_DATE)
            .birthDate(UPDATED_BIRTH_DATE)
            .collectionUserId(UPDATED_COLLECTION_USER_ID)
            .company(UPDATED_COMPANY)
            .soundExCompany(UPDATED_SOUND_EX_COMPANY)
            .legalCompany(UPDATED_LEGAL_COMPANY)
            .first(UPDATED_FIRST)
            .middle(UPDATED_MIDDLE)
            .last(UPDATED_LAST)
            .nickname(UPDATED_NICKNAME)
            .title(UPDATED_TITLE)
            .soundExLast(UPDATED_SOUND_EX_LAST)
            .externalReferenceRequ(UPDATED_EXTERNAL_REFERENCE_REQU)
            .vipStatus(UPDATED_VIP_STATUS)
            .vipAuthorization(UPDATED_VIP_AUTHORIZATION)
            .billingProfileCode(UPDATED_BILLING_PROFILE_CODE)
            .rateStructure(UPDATED_RATE_STRUCTURE)
            .nameComment(UPDATED_NAME_COMMENT)
            .tourOperatorType(UPDATED_TOUR_OPERATOR_TYPE)
            .region(UPDATED_REGION)
            .typeOf1099(UPDATED_TYPE_OF_1099)
            .tax1No(UPDATED_TAX_1_NO)
            .companyNameId(UPDATED_COMPANY_NAME_ID)
            .externalReferenceRequired(UPDATED_EXTERNAL_REFERENCE_REQUIRED)
            .vendorId(UPDATED_VENDOR_ID)
            .vendorSiteId(UPDATED_VENDOR_SITE_ID)
            .arcOfficeType(UPDATED_ARC_OFFICE_TYPE)
            .tax2No(UPDATED_TAX_2_NO)
            .arcMailFlag(UPDATED_ARC_MAIL_FLAG)
            .name2(UPDATED_NAME_2)
            .name3(UPDATED_NAME_3)
            .salesrep(UPDATED_SALESREP)
            .tracecode(UPDATED_TRACECODE)
            .geographicRegion(UPDATED_GEOGRAPHIC_REGION)
            .guestClassification(UPDATED_GUEST_CLASSIFICATION)
            .primaryAddressId(UPDATED_PRIMARY_ADDRESS_ID)
            .primaryPhoneId(UPDATED_PRIMARY_PHONE_ID)
            .taxExemptStatus(UPDATED_TAX_EXEMPT_STATUS)
            .gdsName(UPDATED_GDS_NAME)
            .gdsTransactionNo(UPDATED_GDS_TRANSACTION_NO)
            .nationality(UPDATED_NATIONALITY)
            .language(UPDATED_LANGUAGE)
            .salutation(UPDATED_SALUTATION)
            .passport(UPDATED_PASSPORT)
            .historyYn(UPDATED_HISTORY_YN)
            .resvContact(UPDATED_RESV_CONTACT)
            .contractNo(UPDATED_CONTRACT_NO)
            .contractRecvDate(UPDATED_CONTRACT_RECV_DATE)
            .acctContact(UPDATED_ACCT_CONTACT)
            .priority(UPDATED_PRIORITY)
            .industryCode(UPDATED_INDUSTRY_CODE)
            .roomsPotential(UPDATED_ROOMS_POTENTIAL)
            .competitionCode(UPDATED_COMPETITION_CODE)
            .scope(UPDATED_SCOPE)
            .scopeCity(UPDATED_SCOPE_CITY)
            .territory(UPDATED_TERRITORY)
            .actioncode(UPDATED_ACTIONCODE)
            .activeYn(UPDATED_ACTIVE_YN)
            .masterAccountYn(UPDATED_MASTER_ACCOUNT_YN)
            .nameType(UPDATED_NAME_TYPE)
            .sname(UPDATED_SNAME)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .sfirst(UPDATED_SFIRST)
            .arNo(UPDATED_AR_NO)
            .availabilityOverride(UPDATED_AVAILABILITY_OVERRIDE)
            .billingCode(UPDATED_BILLING_CODE)
            .cashBlInd(UPDATED_CASH_BL_IND)
            .blMsg(UPDATED_BL_MSG)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .commissionCode(UPDATED_COMMISSION_CODE)
            .holdCode(UPDATED_HOLD_CODE)
            .interest(UPDATED_INTEREST)
            .summRefCc(UPDATED_SUMM_REF_CC)
            .iataCompType(UPDATED_IATA_COMP_TYPE)
            .srepCode(UPDATED_SREP_CODE)
            .accountsource(UPDATED_ACCOUNTSOURCE)
            .markets(UPDATED_MARKETS)
            .productInterest(UPDATED_PRODUCT_INTEREST)
            .keyword(UPDATED_KEYWORD)
            .letterGreeting(UPDATED_LETTER_GREETING)
            .influence(UPDATED_INFLUENCE)
            .deptId(UPDATED_DEPT_ID)
            .department(UPDATED_DEPARTMENT)
            .contactYn(UPDATED_CONTACT_YN)
            .accountType(UPDATED_ACCOUNT_TYPE)
            .downloadResort(UPDATED_DOWNLOAD_RESORT)
            .downloadSrep(UPDATED_DOWNLOAD_SREP)
            .downloadDate(UPDATED_DOWNLOAD_DATE)
            .uploadDate(UPDATED_UPLOAD_DATE)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .crsNameid(UPDATED_CRS_NAMEID)
            .commPayCentral(UPDATED_COMM_PAY_CENTRAL)
            .ccProfileYn(UPDATED_CC_PROFILE_YN)
            .gender(UPDATED_GENDER)
            .birthPlace(UPDATED_BIRTH_PLACE)
            .birthCountry(UPDATED_BIRTH_COUNTRY)
            .profession(UPDATED_PROFESSION)
            .idType(UPDATED_ID_TYPE)
            .idNumber(UPDATED_ID_NUMBER)
            .idDate(UPDATED_ID_DATE)
            .idPlace(UPDATED_ID_PLACE)
            .idCountry(UPDATED_ID_COUNTRY)
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
            .udfd11(UPDATED_UDFD_11)
            .udfd12(UPDATED_UDFD_12)
            .udfd13(UPDATED_UDFD_13)
            .udfd14(UPDATED_UDFD_14)
            .udfd15(UPDATED_UDFD_15)
            .udfd16(UPDATED_UDFD_16)
            .udfd17(UPDATED_UDFD_17)
            .udfd18(UPDATED_UDFD_18)
            .udfd19(UPDATED_UDFD_19)
            .udfd20(UPDATED_UDFD_20)
            .paymentDueDays(UPDATED_PAYMENT_DUE_DAYS)
            .suffix(UPDATED_SUFFIX)
            .externalId(UPDATED_EXTERNAL_ID)
            .guestPrivYn(UPDATED_GUEST_PRIV_YN)
            .emailYn(UPDATED_EMAIL_YN)
            .mailYn(UPDATED_MAIL_YN)
            .indexName(UPDATED_INDEX_NAME)
            .xlastName(UPDATED_XLAST_NAME)
            .xfirstName(UPDATED_XFIRST_NAME)
            .xcompanyName(UPDATED_XCOMPANY_NAME)
            .xtitle(UPDATED_XTITLE)
            .xsalutation(UPDATED_XSALUTATION)
            .sxname(UPDATED_SXNAME)
            .sxfirstName(UPDATED_SXFIRST_NAME)
            .lastUpdatedResort(UPDATED_LAST_UPDATED_RESORT)
            .envelopeGreeting(UPDATED_ENVELOPE_GREETING)
            .xenvelopeGreeting(UPDATED_XENVELOPE_GREETING)
            .directBillBatchType(UPDATED_DIRECT_BILL_BATCH_TYPE)
            .resortRegistered(UPDATED_RESORT_REGISTERED)
            .taxOffice(UPDATED_TAX_OFFICE)
            .taxType(UPDATED_TAX_TYPE)
            .taxCategory(UPDATED_TAX_CATEGORY)
            .preferredRoomNo(UPDATED_PREFERRED_ROOM_NO)
            .phoneYn(UPDATED_PHONE_YN)
            .smsYn(UPDATED_SMS_YN)
            .isProtected(UPDATED_IS_PROTECTED)
            .xlanguage(UPDATED_XLANGUAGE)
            .marketResearchYn(UPDATED_MARKET_RESEARCH_YN)
            .thirdPartyYn(UPDATED_THIRD_PARTY_YN)
            .autoenrollMemberYn(UPDATED_AUTOENROLL_MEMBER_YN)
            .chainCode(UPDATED_CHAIN_CODE)
            .companyGroupId(UPDATED_COMPANY_GROUP_ID)
            .includeIn1099Yn(UPDATED_INCLUDE_IN_1099_YN)
            .creditRating(UPDATED_CREDIT_RATING)
            .titleSuffix(UPDATED_TITLE_SUFFIX)
            .inactiveReason(UPDATED_INACTIVE_REASON)
            .iataConsortia(UPDATED_IATA_CONSORTIA)
            .psuedoProfileYn(UPDATED_PSUEDO_PROFILE_YN)
            .profilePrivacyFlg(UPDATED_PROFILE_PRIVACY_FLG)
            .replaceAddress(UPDATED_REPLACE_ADDRESS)
            .alienRegistrationNo(UPDATED_ALIEN_REGISTRATION_NO)
            .immigrationStatus(UPDATED_IMMIGRATION_STATUS)
            .visaValidityType(UPDATED_VISA_VALIDITY_TYPE)
            .idDocumentAttachId(UPDATED_ID_DOCUMENT_ATTACH_ID)
            .superSearchIndexText(UPDATED_SUPER_SEARCH_INDEX_TEXT)
            .birthDateStr(UPDATED_BIRTH_DATE_STR)
            .origNameId(UPDATED_ORIG_NAME_ID)
            .dOptInMailListFlg(UPDATED_D_OPT_IN_MAIL_LIST_FLG)
            .dOptInMarketResearchFlg(UPDATED_D_OPT_IN_MARKET_RESEARCH_FLG)
            .dOptInThirdPartyFlg(UPDATED_D_OPT_IN_THIRD_PARTY_FLG)
            .dOptInAutoenrollMemberFlg(UPDATED_D_OPT_IN_AUTOENROLL_MEMBER_FLG)
            .dOptInEmailFlg(UPDATED_D_OPT_IN_EMAIL_FLG)
            .dOptInPhoneFlg(UPDATED_D_OPT_IN_PHONE_FLG)
            .dOptInSmsFlg(UPDATED_D_OPT_IN_SMS_FLG)
            .dOptInGuestPrivFlg(UPDATED_D_OPT_IN_GUEST_PRIV_FLG)
            .arCreditLimitYn(UPDATED_AR_CREDIT_LIMIT_YN)
            .profileCreditLimit(UPDATED_PROFILE_CREDIT_LIMIT)
            .xmiddleName(UPDATED_XMIDDLE_NAME)
            .eInvoiceLiableYn(UPDATED_E_INVOICE_LIABLE_YN)
            .eInvLiableLastUpdated(UPDATED_E_INV_LIABLE_LAST_UPDATED)
            .internalBillYn(UPDATED_INTERNAL_BILL_YN)
            .compPreApprovalRequiredYn(UPDATED_COMP_PRE_APPROVAL_REQUIRED_YN)
            .anonymizationStatus(UPDATED_ANONYMIZATION_STATUS)
            .anonymizationDate(UPDATED_ANONYMIZATION_DATE);

        restNameMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedName.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedName))
            )
            .andExpect(status().isOk());

        // Validate the Name in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedNameToMatchAllProperties(updatedName);
    }

    @Test
    @Transactional
    void putNonExistingName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        name.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNameMockMvc
            .perform(put(ENTITY_API_URL_ID, name.getId()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(name)))
            .andExpect(status().isBadRequest());

        // Validate the Name in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        name.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNameMockMvc
            .perform(
                put(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(name))
            )
            .andExpect(status().isBadRequest());

        // Validate the Name in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        name.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNameMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(name)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Name in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateNameWithPatch() throws Exception {
        // Initialize the database
        nameRepository.saveAndFlush(name);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the name using partial update
        Name partialUpdatedName = new Name();
        partialUpdatedName.setId(name.getId());

        partialUpdatedName
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .primaryNameId(UPDATED_PRIMARY_NAME_ID)
            .repeatGuestId(UPDATED_REPEAT_GUEST_ID)
            .mailList(UPDATED_MAIL_LIST)
            .mailType(UPDATED_MAIL_TYPE)
            .businessTitle(UPDATED_BUSINESS_TITLE)
            .collectionUserId(UPDATED_COLLECTION_USER_ID)
            .soundExCompany(UPDATED_SOUND_EX_COMPANY)
            .title(UPDATED_TITLE)
            .soundExLast(UPDATED_SOUND_EX_LAST)
            .externalReferenceRequ(UPDATED_EXTERNAL_REFERENCE_REQU)
            .vipStatus(UPDATED_VIP_STATUS)
            .vipAuthorization(UPDATED_VIP_AUTHORIZATION)
            .region(UPDATED_REGION)
            .companyNameId(UPDATED_COMPANY_NAME_ID)
            .name2(UPDATED_NAME_2)
            .salesrep(UPDATED_SALESREP)
            .tracecode(UPDATED_TRACECODE)
            .primaryAddressId(UPDATED_PRIMARY_ADDRESS_ID)
            .taxExemptStatus(UPDATED_TAX_EXEMPT_STATUS)
            .gdsName(UPDATED_GDS_NAME)
            .gdsTransactionNo(UPDATED_GDS_TRANSACTION_NO)
            .nationality(UPDATED_NATIONALITY)
            .language(UPDATED_LANGUAGE)
            .passport(UPDATED_PASSPORT)
            .contractNo(UPDATED_CONTRACT_NO)
            .priority(UPDATED_PRIORITY)
            .industryCode(UPDATED_INDUSTRY_CODE)
            .competitionCode(UPDATED_COMPETITION_CODE)
            .scopeCity(UPDATED_SCOPE_CITY)
            .activeYn(UPDATED_ACTIVE_YN)
            .masterAccountYn(UPDATED_MASTER_ACCOUNT_YN)
            .nameType(UPDATED_NAME_TYPE)
            .sname(UPDATED_SNAME)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .availabilityOverride(UPDATED_AVAILABILITY_OVERRIDE)
            .billingCode(UPDATED_BILLING_CODE)
            .blMsg(UPDATED_BL_MSG)
            .commissionCode(UPDATED_COMMISSION_CODE)
            .holdCode(UPDATED_HOLD_CODE)
            .summRefCc(UPDATED_SUMM_REF_CC)
            .srepCode(UPDATED_SREP_CODE)
            .accountsource(UPDATED_ACCOUNTSOURCE)
            .markets(UPDATED_MARKETS)
            .productInterest(UPDATED_PRODUCT_INTEREST)
            .keyword(UPDATED_KEYWORD)
            .letterGreeting(UPDATED_LETTER_GREETING)
            .influence(UPDATED_INFLUENCE)
            .deptId(UPDATED_DEPT_ID)
            .department(UPDATED_DEPARTMENT)
            .contactYn(UPDATED_CONTACT_YN)
            .accountType(UPDATED_ACCOUNT_TYPE)
            .downloadResort(UPDATED_DOWNLOAD_RESORT)
            .downloadDate(UPDATED_DOWNLOAD_DATE)
            .birthCountry(UPDATED_BIRTH_COUNTRY)
            .profession(UPDATED_PROFESSION)
            .idDate(UPDATED_ID_DATE)
            .udfc01(UPDATED_UDFC_01)
            .udfc02(UPDATED_UDFC_02)
            .udfc07(UPDATED_UDFC_07)
            .udfc11(UPDATED_UDFC_11)
            .udfc12(UPDATED_UDFC_12)
            .udfc13(UPDATED_UDFC_13)
            .udfc15(UPDATED_UDFC_15)
            .udfc19(UPDATED_UDFC_19)
            .udfc21(UPDATED_UDFC_21)
            .udfc22(UPDATED_UDFC_22)
            .udfc23(UPDATED_UDFC_23)
            .udfc24(UPDATED_UDFC_24)
            .udfc27(UPDATED_UDFC_27)
            .udfc28(UPDATED_UDFC_28)
            .udfc32(UPDATED_UDFC_32)
            .udfc33(UPDATED_UDFC_33)
            .udfc34(UPDATED_UDFC_34)
            .udfc39(UPDATED_UDFC_39)
            .udfc40(UPDATED_UDFC_40)
            .udfn01(UPDATED_UDFN_01)
            .udfn02(UPDATED_UDFN_02)
            .udfn03(UPDATED_UDFN_03)
            .udfn04(UPDATED_UDFN_04)
            .udfn06(UPDATED_UDFN_06)
            .udfn08(UPDATED_UDFN_08)
            .udfn09(UPDATED_UDFN_09)
            .udfn10(UPDATED_UDFN_10)
            .udfn11(UPDATED_UDFN_11)
            .udfn12(UPDATED_UDFN_12)
            .udfn13(UPDATED_UDFN_13)
            .udfn14(UPDATED_UDFN_14)
            .udfn16(UPDATED_UDFN_16)
            .udfn17(UPDATED_UDFN_17)
            .udfn19(UPDATED_UDFN_19)
            .udfn20(UPDATED_UDFN_20)
            .udfn21(UPDATED_UDFN_21)
            .udfn22(UPDATED_UDFN_22)
            .udfn24(UPDATED_UDFN_24)
            .udfn25(UPDATED_UDFN_25)
            .udfn26(UPDATED_UDFN_26)
            .udfn28(UPDATED_UDFN_28)
            .udfn29(UPDATED_UDFN_29)
            .udfn32(UPDATED_UDFN_32)
            .udfn34(UPDATED_UDFN_34)
            .udfn37(UPDATED_UDFN_37)
            .udfn38(UPDATED_UDFN_38)
            .udfn39(UPDATED_UDFN_39)
            .udfn40(UPDATED_UDFN_40)
            .udfd02(UPDATED_UDFD_02)
            .udfd03(UPDATED_UDFD_03)
            .udfd04(UPDATED_UDFD_04)
            .udfd05(UPDATED_UDFD_05)
            .udfd06(UPDATED_UDFD_06)
            .udfd11(UPDATED_UDFD_11)
            .udfd14(UPDATED_UDFD_14)
            .udfd19(UPDATED_UDFD_19)
            .guestPrivYn(UPDATED_GUEST_PRIV_YN)
            .emailYn(UPDATED_EMAIL_YN)
            .mailYn(UPDATED_MAIL_YN)
            .xlastName(UPDATED_XLAST_NAME)
            .xfirstName(UPDATED_XFIRST_NAME)
            .xcompanyName(UPDATED_XCOMPANY_NAME)
            .xtitle(UPDATED_XTITLE)
            .sxname(UPDATED_SXNAME)
            .sxfirstName(UPDATED_SXFIRST_NAME)
            .lastUpdatedResort(UPDATED_LAST_UPDATED_RESORT)
            .envelopeGreeting(UPDATED_ENVELOPE_GREETING)
            .xenvelopeGreeting(UPDATED_XENVELOPE_GREETING)
            .resortRegistered(UPDATED_RESORT_REGISTERED)
            .taxOffice(UPDATED_TAX_OFFICE)
            .phoneYn(UPDATED_PHONE_YN)
            .smsYn(UPDATED_SMS_YN)
            .xlanguage(UPDATED_XLANGUAGE)
            .marketResearchYn(UPDATED_MARKET_RESEARCH_YN)
            .autoenrollMemberYn(UPDATED_AUTOENROLL_MEMBER_YN)
            .chainCode(UPDATED_CHAIN_CODE)
            .companyGroupId(UPDATED_COMPANY_GROUP_ID)
            .includeIn1099Yn(UPDATED_INCLUDE_IN_1099_YN)
            .titleSuffix(UPDATED_TITLE_SUFFIX)
            .iataConsortia(UPDATED_IATA_CONSORTIA)
            .profilePrivacyFlg(UPDATED_PROFILE_PRIVACY_FLG)
            .replaceAddress(UPDATED_REPLACE_ADDRESS)
            .alienRegistrationNo(UPDATED_ALIEN_REGISTRATION_NO)
            .birthDateStr(UPDATED_BIRTH_DATE_STR)
            .dOptInThirdPartyFlg(UPDATED_D_OPT_IN_THIRD_PARTY_FLG)
            .dOptInPhoneFlg(UPDATED_D_OPT_IN_PHONE_FLG)
            .dOptInGuestPrivFlg(UPDATED_D_OPT_IN_GUEST_PRIV_FLG)
            .arCreditLimitYn(UPDATED_AR_CREDIT_LIMIT_YN)
            .profileCreditLimit(UPDATED_PROFILE_CREDIT_LIMIT)
            .xmiddleName(UPDATED_XMIDDLE_NAME)
            .eInvoiceLiableYn(UPDATED_E_INVOICE_LIABLE_YN)
            .eInvLiableLastUpdated(UPDATED_E_INV_LIABLE_LAST_UPDATED)
            .compPreApprovalRequiredYn(UPDATED_COMP_PRE_APPROVAL_REQUIRED_YN);

        restNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedName.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedName))
            )
            .andExpect(status().isOk());

        // Validate the Name in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertNameUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedName, name), getPersistedName(name));
    }

    @Test
    @Transactional
    void fullUpdateNameWithPatch() throws Exception {
        // Initialize the database
        nameRepository.saveAndFlush(name);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the name using partial update
        Name partialUpdatedName = new Name();
        partialUpdatedName.setId(name.getId());

        partialUpdatedName
            .nameId(UPDATED_NAME_ID)
            .nameCode(UPDATED_NAME_CODE)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .primaryNameId(UPDATED_PRIMARY_NAME_ID)
            .repeatGuestId(UPDATED_REPEAT_GUEST_ID)
            .mailList(UPDATED_MAIL_LIST)
            .mailType(UPDATED_MAIL_TYPE)
            .followOn(UPDATED_FOLLOW_ON)
            .businessTitle(UPDATED_BUSINESS_TITLE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .arcUpdateDate(UPDATED_ARC_UPDATE_DATE)
            .updateFaxDate(UPDATED_UPDATE_FAX_DATE)
            .birthDate(UPDATED_BIRTH_DATE)
            .collectionUserId(UPDATED_COLLECTION_USER_ID)
            .company(UPDATED_COMPANY)
            .soundExCompany(UPDATED_SOUND_EX_COMPANY)
            .legalCompany(UPDATED_LEGAL_COMPANY)
            .first(UPDATED_FIRST)
            .middle(UPDATED_MIDDLE)
            .last(UPDATED_LAST)
            .nickname(UPDATED_NICKNAME)
            .title(UPDATED_TITLE)
            .soundExLast(UPDATED_SOUND_EX_LAST)
            .externalReferenceRequ(UPDATED_EXTERNAL_REFERENCE_REQU)
            .vipStatus(UPDATED_VIP_STATUS)
            .vipAuthorization(UPDATED_VIP_AUTHORIZATION)
            .billingProfileCode(UPDATED_BILLING_PROFILE_CODE)
            .rateStructure(UPDATED_RATE_STRUCTURE)
            .nameComment(UPDATED_NAME_COMMENT)
            .tourOperatorType(UPDATED_TOUR_OPERATOR_TYPE)
            .region(UPDATED_REGION)
            .typeOf1099(UPDATED_TYPE_OF_1099)
            .tax1No(UPDATED_TAX_1_NO)
            .companyNameId(UPDATED_COMPANY_NAME_ID)
            .externalReferenceRequired(UPDATED_EXTERNAL_REFERENCE_REQUIRED)
            .vendorId(UPDATED_VENDOR_ID)
            .vendorSiteId(UPDATED_VENDOR_SITE_ID)
            .arcOfficeType(UPDATED_ARC_OFFICE_TYPE)
            .tax2No(UPDATED_TAX_2_NO)
            .arcMailFlag(UPDATED_ARC_MAIL_FLAG)
            .name2(UPDATED_NAME_2)
            .name3(UPDATED_NAME_3)
            .salesrep(UPDATED_SALESREP)
            .tracecode(UPDATED_TRACECODE)
            .geographicRegion(UPDATED_GEOGRAPHIC_REGION)
            .guestClassification(UPDATED_GUEST_CLASSIFICATION)
            .primaryAddressId(UPDATED_PRIMARY_ADDRESS_ID)
            .primaryPhoneId(UPDATED_PRIMARY_PHONE_ID)
            .taxExemptStatus(UPDATED_TAX_EXEMPT_STATUS)
            .gdsName(UPDATED_GDS_NAME)
            .gdsTransactionNo(UPDATED_GDS_TRANSACTION_NO)
            .nationality(UPDATED_NATIONALITY)
            .language(UPDATED_LANGUAGE)
            .salutation(UPDATED_SALUTATION)
            .passport(UPDATED_PASSPORT)
            .historyYn(UPDATED_HISTORY_YN)
            .resvContact(UPDATED_RESV_CONTACT)
            .contractNo(UPDATED_CONTRACT_NO)
            .contractRecvDate(UPDATED_CONTRACT_RECV_DATE)
            .acctContact(UPDATED_ACCT_CONTACT)
            .priority(UPDATED_PRIORITY)
            .industryCode(UPDATED_INDUSTRY_CODE)
            .roomsPotential(UPDATED_ROOMS_POTENTIAL)
            .competitionCode(UPDATED_COMPETITION_CODE)
            .scope(UPDATED_SCOPE)
            .scopeCity(UPDATED_SCOPE_CITY)
            .territory(UPDATED_TERRITORY)
            .actioncode(UPDATED_ACTIONCODE)
            .activeYn(UPDATED_ACTIVE_YN)
            .masterAccountYn(UPDATED_MASTER_ACCOUNT_YN)
            .nameType(UPDATED_NAME_TYPE)
            .sname(UPDATED_SNAME)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .sfirst(UPDATED_SFIRST)
            .arNo(UPDATED_AR_NO)
            .availabilityOverride(UPDATED_AVAILABILITY_OVERRIDE)
            .billingCode(UPDATED_BILLING_CODE)
            .cashBlInd(UPDATED_CASH_BL_IND)
            .blMsg(UPDATED_BL_MSG)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .commissionCode(UPDATED_COMMISSION_CODE)
            .holdCode(UPDATED_HOLD_CODE)
            .interest(UPDATED_INTEREST)
            .summRefCc(UPDATED_SUMM_REF_CC)
            .iataCompType(UPDATED_IATA_COMP_TYPE)
            .srepCode(UPDATED_SREP_CODE)
            .accountsource(UPDATED_ACCOUNTSOURCE)
            .markets(UPDATED_MARKETS)
            .productInterest(UPDATED_PRODUCT_INTEREST)
            .keyword(UPDATED_KEYWORD)
            .letterGreeting(UPDATED_LETTER_GREETING)
            .influence(UPDATED_INFLUENCE)
            .deptId(UPDATED_DEPT_ID)
            .department(UPDATED_DEPARTMENT)
            .contactYn(UPDATED_CONTACT_YN)
            .accountType(UPDATED_ACCOUNT_TYPE)
            .downloadResort(UPDATED_DOWNLOAD_RESORT)
            .downloadSrep(UPDATED_DOWNLOAD_SREP)
            .downloadDate(UPDATED_DOWNLOAD_DATE)
            .uploadDate(UPDATED_UPLOAD_DATE)
            .laptopChange(UPDATED_LAPTOP_CHANGE)
            .crsNameid(UPDATED_CRS_NAMEID)
            .commPayCentral(UPDATED_COMM_PAY_CENTRAL)
            .ccProfileYn(UPDATED_CC_PROFILE_YN)
            .gender(UPDATED_GENDER)
            .birthPlace(UPDATED_BIRTH_PLACE)
            .birthCountry(UPDATED_BIRTH_COUNTRY)
            .profession(UPDATED_PROFESSION)
            .idType(UPDATED_ID_TYPE)
            .idNumber(UPDATED_ID_NUMBER)
            .idDate(UPDATED_ID_DATE)
            .idPlace(UPDATED_ID_PLACE)
            .idCountry(UPDATED_ID_COUNTRY)
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
            .udfd11(UPDATED_UDFD_11)
            .udfd12(UPDATED_UDFD_12)
            .udfd13(UPDATED_UDFD_13)
            .udfd14(UPDATED_UDFD_14)
            .udfd15(UPDATED_UDFD_15)
            .udfd16(UPDATED_UDFD_16)
            .udfd17(UPDATED_UDFD_17)
            .udfd18(UPDATED_UDFD_18)
            .udfd19(UPDATED_UDFD_19)
            .udfd20(UPDATED_UDFD_20)
            .paymentDueDays(UPDATED_PAYMENT_DUE_DAYS)
            .suffix(UPDATED_SUFFIX)
            .externalId(UPDATED_EXTERNAL_ID)
            .guestPrivYn(UPDATED_GUEST_PRIV_YN)
            .emailYn(UPDATED_EMAIL_YN)
            .mailYn(UPDATED_MAIL_YN)
            .indexName(UPDATED_INDEX_NAME)
            .xlastName(UPDATED_XLAST_NAME)
            .xfirstName(UPDATED_XFIRST_NAME)
            .xcompanyName(UPDATED_XCOMPANY_NAME)
            .xtitle(UPDATED_XTITLE)
            .xsalutation(UPDATED_XSALUTATION)
            .sxname(UPDATED_SXNAME)
            .sxfirstName(UPDATED_SXFIRST_NAME)
            .lastUpdatedResort(UPDATED_LAST_UPDATED_RESORT)
            .envelopeGreeting(UPDATED_ENVELOPE_GREETING)
            .xenvelopeGreeting(UPDATED_XENVELOPE_GREETING)
            .directBillBatchType(UPDATED_DIRECT_BILL_BATCH_TYPE)
            .resortRegistered(UPDATED_RESORT_REGISTERED)
            .taxOffice(UPDATED_TAX_OFFICE)
            .taxType(UPDATED_TAX_TYPE)
            .taxCategory(UPDATED_TAX_CATEGORY)
            .preferredRoomNo(UPDATED_PREFERRED_ROOM_NO)
            .phoneYn(UPDATED_PHONE_YN)
            .smsYn(UPDATED_SMS_YN)
            .isProtected(UPDATED_IS_PROTECTED)
            .xlanguage(UPDATED_XLANGUAGE)
            .marketResearchYn(UPDATED_MARKET_RESEARCH_YN)
            .thirdPartyYn(UPDATED_THIRD_PARTY_YN)
            .autoenrollMemberYn(UPDATED_AUTOENROLL_MEMBER_YN)
            .chainCode(UPDATED_CHAIN_CODE)
            .companyGroupId(UPDATED_COMPANY_GROUP_ID)
            .includeIn1099Yn(UPDATED_INCLUDE_IN_1099_YN)
            .creditRating(UPDATED_CREDIT_RATING)
            .titleSuffix(UPDATED_TITLE_SUFFIX)
            .inactiveReason(UPDATED_INACTIVE_REASON)
            .iataConsortia(UPDATED_IATA_CONSORTIA)
            .psuedoProfileYn(UPDATED_PSUEDO_PROFILE_YN)
            .profilePrivacyFlg(UPDATED_PROFILE_PRIVACY_FLG)
            .replaceAddress(UPDATED_REPLACE_ADDRESS)
            .alienRegistrationNo(UPDATED_ALIEN_REGISTRATION_NO)
            .immigrationStatus(UPDATED_IMMIGRATION_STATUS)
            .visaValidityType(UPDATED_VISA_VALIDITY_TYPE)
            .idDocumentAttachId(UPDATED_ID_DOCUMENT_ATTACH_ID)
            .superSearchIndexText(UPDATED_SUPER_SEARCH_INDEX_TEXT)
            .birthDateStr(UPDATED_BIRTH_DATE_STR)
            .origNameId(UPDATED_ORIG_NAME_ID)
            .dOptInMailListFlg(UPDATED_D_OPT_IN_MAIL_LIST_FLG)
            .dOptInMarketResearchFlg(UPDATED_D_OPT_IN_MARKET_RESEARCH_FLG)
            .dOptInThirdPartyFlg(UPDATED_D_OPT_IN_THIRD_PARTY_FLG)
            .dOptInAutoenrollMemberFlg(UPDATED_D_OPT_IN_AUTOENROLL_MEMBER_FLG)
            .dOptInEmailFlg(UPDATED_D_OPT_IN_EMAIL_FLG)
            .dOptInPhoneFlg(UPDATED_D_OPT_IN_PHONE_FLG)
            .dOptInSmsFlg(UPDATED_D_OPT_IN_SMS_FLG)
            .dOptInGuestPrivFlg(UPDATED_D_OPT_IN_GUEST_PRIV_FLG)
            .arCreditLimitYn(UPDATED_AR_CREDIT_LIMIT_YN)
            .profileCreditLimit(UPDATED_PROFILE_CREDIT_LIMIT)
            .xmiddleName(UPDATED_XMIDDLE_NAME)
            .eInvoiceLiableYn(UPDATED_E_INVOICE_LIABLE_YN)
            .eInvLiableLastUpdated(UPDATED_E_INV_LIABLE_LAST_UPDATED)
            .internalBillYn(UPDATED_INTERNAL_BILL_YN)
            .compPreApprovalRequiredYn(UPDATED_COMP_PRE_APPROVAL_REQUIRED_YN)
            .anonymizationStatus(UPDATED_ANONYMIZATION_STATUS)
            .anonymizationDate(UPDATED_ANONYMIZATION_DATE);

        restNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedName.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedName))
            )
            .andExpect(status().isOk());

        // Validate the Name in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertNameUpdatableFieldsEquals(partialUpdatedName, getPersistedName(partialUpdatedName));
    }

    @Test
    @Transactional
    void patchNonExistingName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        name.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNameMockMvc
            .perform(patch(ENTITY_API_URL_ID, name.getId()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(name)))
            .andExpect(status().isBadRequest());

        // Validate the Name in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        name.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(name))
            )
            .andExpect(status().isBadRequest());

        // Validate the Name in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        name.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restNameMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(name)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Name in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteName() throws Exception {
        // Initialize the database
        nameRepository.saveAndFlush(name);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the name
        restNameMockMvc
            .perform(delete(ENTITY_API_URL_ID, name.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return nameRepository.count();
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

    protected Name getPersistedName(Name name) {
        return nameRepository.findById(name.getId()).orElseThrow();
    }

    protected void assertPersistedNameToMatchAllProperties(Name expectedName) {
        assertNameAllPropertiesEquals(expectedName, getPersistedName(expectedName));
    }

    protected void assertPersistedNameToMatchUpdatableProperties(Name expectedName) {
        assertNameAllUpdatablePropertiesEquals(expectedName, getPersistedName(expectedName));
    }
}
