package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.ReservationDailyElementNameAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static com.sbm.mc.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.ReservationDailyElementName;
import com.sbm.mc.repository.ReservationDailyElementNameRepository;
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
 * Integration tests for the {@link ReservationDailyElementNameResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ReservationDailyElementNameResourceIT {

    private static final String DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_RESORT = "BBBBBBBBBB";

    private static final Integer DEFAULT_RESV_NAME_ID = 1;
    private static final Integer UPDATED_RESV_NAME_ID = 2;

    private static final LocalDate DEFAULT_RESERVATION_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RESERVATION_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_RESV_DAILY_EL_SEQ = 1;
    private static final Integer UPDATED_RESV_DAILY_EL_SEQ = 2;

    private static final Integer DEFAULT_TRAVEL_AGENT_ID = 1;
    private static final Integer UPDATED_TRAVEL_AGENT_ID = 2;

    private static final Integer DEFAULT_COMPANY_ID = 1;
    private static final Integer UPDATED_COMPANY_ID = 2;

    private static final Integer DEFAULT_SOURCE_ID = 1;
    private static final Integer UPDATED_SOURCE_ID = 2;

    private static final Integer DEFAULT_GROUP_ID = 1;
    private static final Integer UPDATED_GROUP_ID = 2;

    private static final String DEFAULT_SHARE_PAYMENT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_SHARE_PAYMENT_TYPE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_SHARE_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_SHARE_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_SHARE_PRCNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_SHARE_PRCNT = new BigDecimal(2);

    private static final Integer DEFAULT_ADULTS = 1;
    private static final Integer UPDATED_ADULTS = 2;

    private static final Integer DEFAULT_CHILDREN = 1;
    private static final Integer UPDATED_CHILDREN = 2;

    private static final BigDecimal DEFAULT_DISCOUNT_AMT = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISCOUNT_AMT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISCOUNT_PRCNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISCOUNT_PRCNT = new BigDecimal(2);

    private static final String DEFAULT_DISCOUNT_REASON_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DISCOUNT_REASON_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_FIXED_RATE_YN = "AAAAAAAAAA";
    private static final String UPDATED_FIXED_RATE_YN = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_BASE_RATE_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_BASE_RATE_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_AUTO_POST_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_AUTO_POST_AMOUNT = new BigDecimal(2);

    private static final Integer DEFAULT_SHARE_PRIORITY = 1;
    private static final Integer UPDATED_SHARE_PRIORITY = 2;

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_LAST_SHARE_CALCULATION = "AAAAAAAAAA";
    private static final String UPDATED_LAST_SHARE_CALCULATION = "BBBBBBBBBB";

    private static final Integer DEFAULT_INSERT_ACTION_INSTANCE_ID = 1;
    private static final Integer UPDATED_INSERT_ACTION_INSTANCE_ID = 2;

    private static final Integer DEFAULT_DML_SEQ_NO = 1;
    private static final Integer UPDATED_DML_SEQ_NO = 2;

    private static final BigDecimal DEFAULT_NET_ROOM_AMT = new BigDecimal(1);
    private static final BigDecimal UPDATED_NET_ROOM_AMT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ROOM_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_ROOM_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PKG_AMT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PKG_AMT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PKG_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_PKG_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_GROSS_RATE_AMT = new BigDecimal(1);
    private static final BigDecimal UPDATED_GROSS_RATE_AMT = new BigDecimal(2);

    private static final Integer DEFAULT_ADULTS_TAX_FREE = 1;
    private static final Integer UPDATED_ADULTS_TAX_FREE = 2;

    private static final Integer DEFAULT_CHILDREN_TAX_FREE = 1;
    private static final Integer UPDATED_CHILDREN_TAX_FREE = 2;

    private static final Integer DEFAULT_CHILDREN_1 = 1;
    private static final Integer UPDATED_CHILDREN_1 = 2;

    private static final Integer DEFAULT_CHILDREN_2 = 1;
    private static final Integer UPDATED_CHILDREN_2 = 2;

    private static final Integer DEFAULT_CHILDREN_3 = 1;
    private static final Integer UPDATED_CHILDREN_3 = 2;

    private static final String DEFAULT_RATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_RATE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_EXCHANGE_POSTING_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_EXCHANGE_POSTING_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_MEMBERSHIP_POINTS = 1;
    private static final Integer UPDATED_MEMBERSHIP_POINTS = 2;

    private static final Integer DEFAULT_CHILDREN_4 = 1;
    private static final Integer UPDATED_CHILDREN_4 = 2;

    private static final Integer DEFAULT_CHILDREN_5 = 1;
    private static final Integer UPDATED_CHILDREN_5 = 2;

    private static final String DEFAULT_COMMISSION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMMISSION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_CODE_1 = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_CODE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_CODE_2 = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_CODE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_CODE_3 = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_CODE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_CODE_4 = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_CODE_4 = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_CODE_5 = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_CODE_5 = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_VOUCHER_1 = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_VOUCHER_1 = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_VOUCHER_2 = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_VOUCHER_2 = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_VOUCHER_3 = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_VOUCHER_3 = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_VOUCHER_4 = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_VOUCHER_4 = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_VOUCHER_5 = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_VOUCHER_5 = "BBBBBBBBBB";

    private static final String DEFAULT_DO_NOT_MOVE_YN = "AAAAAAAAAA";
    private static final String UPDATED_DO_NOT_MOVE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_AWARD_CODE = "AAAAAAAAAA";
    private static final String UPDATED_AWARD_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_POINTS = 1;
    private static final Integer UPDATED_POINTS = 2;

    private static final BigDecimal DEFAULT_UPSELL_CHARGE = new BigDecimal(1);
    private static final BigDecimal UPDATED_UPSELL_CHARGE = new BigDecimal(2);

    private static final String DEFAULT_POINTS_ELIGIBILITY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_POINTS_ELIGIBILITY_CODE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_COMMISSION_PAID = new BigDecimal(1);
    private static final BigDecimal UPDATED_COMMISSION_PAID = new BigDecimal(2);

    private static final Integer DEFAULT_RESV_CONTACT_ID = 1;
    private static final Integer UPDATED_RESV_CONTACT_ID = 2;

    private static final Integer DEFAULT_BILLING_CONTACT_ID = 1;
    private static final Integer UPDATED_BILLING_CONTACT_ID = 2;

    private static final BigDecimal DEFAULT_SHARE_AMOUNT_ORIGINAL = new BigDecimal(1);
    private static final BigDecimal UPDATED_SHARE_AMOUNT_ORIGINAL = new BigDecimal(2);

    private static final String DEFAULT_REFERRAL_YN = "AAAAAAAAAA";
    private static final String UPDATED_REFERRAL_YN = "BBBBBBBBBB";

    private static final String DEFAULT_BXGY_DISCOUNT_YN = "AAAAAAAAAA";
    private static final String UPDATED_BXGY_DISCOUNT_YN = "BBBBBBBBBB";

    private static final String DEFAULT_COMMISSIONABLE_YN = "AAAAAAAAAA";
    private static final String UPDATED_COMMISSIONABLE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_BASED_ON_RULE = "AAAAAAAAAA";
    private static final String UPDATED_BASED_ON_RULE = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/reservation-daily-element-names";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ReservationDailyElementNameRepository reservationDailyElementNameRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restReservationDailyElementNameMockMvc;

    private ReservationDailyElementName reservationDailyElementName;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReservationDailyElementName createEntity(EntityManager em) {
        ReservationDailyElementName reservationDailyElementName = new ReservationDailyElementName()
            .resort(DEFAULT_RESORT)
            .resvNameId(DEFAULT_RESV_NAME_ID)
            .reservationDate(DEFAULT_RESERVATION_DATE)
            .resvDailyElSeq(DEFAULT_RESV_DAILY_EL_SEQ)
            .travelAgentId(DEFAULT_TRAVEL_AGENT_ID)
            .companyId(DEFAULT_COMPANY_ID)
            .sourceId(DEFAULT_SOURCE_ID)
            .groupId(DEFAULT_GROUP_ID)
            .sharePaymentType(DEFAULT_SHARE_PAYMENT_TYPE)
            .shareAmount(DEFAULT_SHARE_AMOUNT)
            .sharePrcnt(DEFAULT_SHARE_PRCNT)
            .adults(DEFAULT_ADULTS)
            .children(DEFAULT_CHILDREN)
            .discountAmt(DEFAULT_DISCOUNT_AMT)
            .discountPrcnt(DEFAULT_DISCOUNT_PRCNT)
            .discountReasonCode(DEFAULT_DISCOUNT_REASON_CODE)
            .fixedRateYn(DEFAULT_FIXED_RATE_YN)
            .baseRateAmount(DEFAULT_BASE_RATE_AMOUNT)
            .autoPostAmount(DEFAULT_AUTO_POST_AMOUNT)
            .sharePriority(DEFAULT_SHARE_PRIORITY)
            .insertUser(DEFAULT_INSERT_USER)
            .insertDate(DEFAULT_INSERT_DATE)
            .updateUser(DEFAULT_UPDATE_USER)
            .updateDate(DEFAULT_UPDATE_DATE)
            .lastShareCalculation(DEFAULT_LAST_SHARE_CALCULATION)
            .insertActionInstanceId(DEFAULT_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(DEFAULT_DML_SEQ_NO)
            .netRoomAmt(DEFAULT_NET_ROOM_AMT)
            .roomTax(DEFAULT_ROOM_TAX)
            .pkgAmt(DEFAULT_PKG_AMT)
            .pkgTax(DEFAULT_PKG_TAX)
            .grossRateAmt(DEFAULT_GROSS_RATE_AMT)
            .adultsTaxFree(DEFAULT_ADULTS_TAX_FREE)
            .childrenTaxFree(DEFAULT_CHILDREN_TAX_FREE)
            .children1(DEFAULT_CHILDREN_1)
            .children2(DEFAULT_CHILDREN_2)
            .children3(DEFAULT_CHILDREN_3)
            .rateCode(DEFAULT_RATE_CODE)
            .currencyCode(DEFAULT_CURRENCY_CODE)
            .exchangePostingType(DEFAULT_EXCHANGE_POSTING_TYPE)
            .membershipPoints(DEFAULT_MEMBERSHIP_POINTS)
            .children4(DEFAULT_CHILDREN_4)
            .children5(DEFAULT_CHILDREN_5)
            .commissionCode(DEFAULT_COMMISSION_CODE)
            .awardCode1(DEFAULT_AWARD_CODE_1)
            .awardCode2(DEFAULT_AWARD_CODE_2)
            .awardCode3(DEFAULT_AWARD_CODE_3)
            .awardCode4(DEFAULT_AWARD_CODE_4)
            .awardCode5(DEFAULT_AWARD_CODE_5)
            .awardVoucher1(DEFAULT_AWARD_VOUCHER_1)
            .awardVoucher2(DEFAULT_AWARD_VOUCHER_2)
            .awardVoucher3(DEFAULT_AWARD_VOUCHER_3)
            .awardVoucher4(DEFAULT_AWARD_VOUCHER_4)
            .awardVoucher5(DEFAULT_AWARD_VOUCHER_5)
            .doNotMoveYn(DEFAULT_DO_NOT_MOVE_YN)
            .awardCode(DEFAULT_AWARD_CODE)
            .points(DEFAULT_POINTS)
            .upsellCharge(DEFAULT_UPSELL_CHARGE)
            .pointsEligibilityCode(DEFAULT_POINTS_ELIGIBILITY_CODE)
            .commissionPaid(DEFAULT_COMMISSION_PAID)
            .resvContactId(DEFAULT_RESV_CONTACT_ID)
            .billingContactId(DEFAULT_BILLING_CONTACT_ID)
            .shareAmountOriginal(DEFAULT_SHARE_AMOUNT_ORIGINAL)
            .referralYn(DEFAULT_REFERRAL_YN)
            .bxgyDiscountYn(DEFAULT_BXGY_DISCOUNT_YN)
            .commissionableYn(DEFAULT_COMMISSIONABLE_YN)
            .basedOnRule(DEFAULT_BASED_ON_RULE);
        return reservationDailyElementName;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReservationDailyElementName createUpdatedEntity(EntityManager em) {
        ReservationDailyElementName reservationDailyElementName = new ReservationDailyElementName()
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .reservationDate(UPDATED_RESERVATION_DATE)
            .resvDailyElSeq(UPDATED_RESV_DAILY_EL_SEQ)
            .travelAgentId(UPDATED_TRAVEL_AGENT_ID)
            .companyId(UPDATED_COMPANY_ID)
            .sourceId(UPDATED_SOURCE_ID)
            .groupId(UPDATED_GROUP_ID)
            .sharePaymentType(UPDATED_SHARE_PAYMENT_TYPE)
            .shareAmount(UPDATED_SHARE_AMOUNT)
            .sharePrcnt(UPDATED_SHARE_PRCNT)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .discountAmt(UPDATED_DISCOUNT_AMT)
            .discountPrcnt(UPDATED_DISCOUNT_PRCNT)
            .discountReasonCode(UPDATED_DISCOUNT_REASON_CODE)
            .fixedRateYn(UPDATED_FIXED_RATE_YN)
            .baseRateAmount(UPDATED_BASE_RATE_AMOUNT)
            .autoPostAmount(UPDATED_AUTO_POST_AMOUNT)
            .sharePriority(UPDATED_SHARE_PRIORITY)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .lastShareCalculation(UPDATED_LAST_SHARE_CALCULATION)
            .insertActionInstanceId(UPDATED_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(UPDATED_DML_SEQ_NO)
            .netRoomAmt(UPDATED_NET_ROOM_AMT)
            .roomTax(UPDATED_ROOM_TAX)
            .pkgAmt(UPDATED_PKG_AMT)
            .pkgTax(UPDATED_PKG_TAX)
            .grossRateAmt(UPDATED_GROSS_RATE_AMT)
            .adultsTaxFree(UPDATED_ADULTS_TAX_FREE)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .children1(UPDATED_CHILDREN_1)
            .children2(UPDATED_CHILDREN_2)
            .children3(UPDATED_CHILDREN_3)
            .rateCode(UPDATED_RATE_CODE)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .exchangePostingType(UPDATED_EXCHANGE_POSTING_TYPE)
            .membershipPoints(UPDATED_MEMBERSHIP_POINTS)
            .children4(UPDATED_CHILDREN_4)
            .children5(UPDATED_CHILDREN_5)
            .commissionCode(UPDATED_COMMISSION_CODE)
            .awardCode1(UPDATED_AWARD_CODE_1)
            .awardCode2(UPDATED_AWARD_CODE_2)
            .awardCode3(UPDATED_AWARD_CODE_3)
            .awardCode4(UPDATED_AWARD_CODE_4)
            .awardCode5(UPDATED_AWARD_CODE_5)
            .awardVoucher1(UPDATED_AWARD_VOUCHER_1)
            .awardVoucher2(UPDATED_AWARD_VOUCHER_2)
            .awardVoucher3(UPDATED_AWARD_VOUCHER_3)
            .awardVoucher4(UPDATED_AWARD_VOUCHER_4)
            .awardVoucher5(UPDATED_AWARD_VOUCHER_5)
            .doNotMoveYn(UPDATED_DO_NOT_MOVE_YN)
            .awardCode(UPDATED_AWARD_CODE)
            .points(UPDATED_POINTS)
            .upsellCharge(UPDATED_UPSELL_CHARGE)
            .pointsEligibilityCode(UPDATED_POINTS_ELIGIBILITY_CODE)
            .commissionPaid(UPDATED_COMMISSION_PAID)
            .resvContactId(UPDATED_RESV_CONTACT_ID)
            .billingContactId(UPDATED_BILLING_CONTACT_ID)
            .shareAmountOriginal(UPDATED_SHARE_AMOUNT_ORIGINAL)
            .referralYn(UPDATED_REFERRAL_YN)
            .bxgyDiscountYn(UPDATED_BXGY_DISCOUNT_YN)
            .commissionableYn(UPDATED_COMMISSIONABLE_YN)
            .basedOnRule(UPDATED_BASED_ON_RULE);
        return reservationDailyElementName;
    }

    @BeforeEach
    public void initTest() {
        reservationDailyElementName = createEntity(em);
    }

    @Test
    @Transactional
    void createReservationDailyElementName() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ReservationDailyElementName
        var returnedReservationDailyElementName = om.readValue(
            restReservationDailyElementNameMockMvc
                .perform(
                    post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationDailyElementName))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ReservationDailyElementName.class
        );

        // Validate the ReservationDailyElementName in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertReservationDailyElementNameUpdatableFieldsEquals(
            returnedReservationDailyElementName,
            getPersistedReservationDailyElementName(returnedReservationDailyElementName)
        );
    }

    @Test
    @Transactional
    void createReservationDailyElementNameWithExistingId() throws Exception {
        // Create the ReservationDailyElementName with an existing ID
        reservationDailyElementName.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restReservationDailyElementNameMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationDailyElementName))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationDailyElementName in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllReservationDailyElementNames() throws Exception {
        // Initialize the database
        reservationDailyElementNameRepository.saveAndFlush(reservationDailyElementName);

        // Get all the reservationDailyElementNameList
        restReservationDailyElementNameMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reservationDailyElementName.getId().intValue())))
            .andExpect(jsonPath("$.[*].resort").value(hasItem(DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].resvNameId").value(hasItem(DEFAULT_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].reservationDate").value(hasItem(DEFAULT_RESERVATION_DATE.toString())))
            .andExpect(jsonPath("$.[*].resvDailyElSeq").value(hasItem(DEFAULT_RESV_DAILY_EL_SEQ)))
            .andExpect(jsonPath("$.[*].travelAgentId").value(hasItem(DEFAULT_TRAVEL_AGENT_ID)))
            .andExpect(jsonPath("$.[*].companyId").value(hasItem(DEFAULT_COMPANY_ID)))
            .andExpect(jsonPath("$.[*].sourceId").value(hasItem(DEFAULT_SOURCE_ID)))
            .andExpect(jsonPath("$.[*].groupId").value(hasItem(DEFAULT_GROUP_ID)))
            .andExpect(jsonPath("$.[*].sharePaymentType").value(hasItem(DEFAULT_SHARE_PAYMENT_TYPE)))
            .andExpect(jsonPath("$.[*].shareAmount").value(hasItem(sameNumber(DEFAULT_SHARE_AMOUNT))))
            .andExpect(jsonPath("$.[*].sharePrcnt").value(hasItem(sameNumber(DEFAULT_SHARE_PRCNT))))
            .andExpect(jsonPath("$.[*].adults").value(hasItem(DEFAULT_ADULTS)))
            .andExpect(jsonPath("$.[*].children").value(hasItem(DEFAULT_CHILDREN)))
            .andExpect(jsonPath("$.[*].discountAmt").value(hasItem(sameNumber(DEFAULT_DISCOUNT_AMT))))
            .andExpect(jsonPath("$.[*].discountPrcnt").value(hasItem(sameNumber(DEFAULT_DISCOUNT_PRCNT))))
            .andExpect(jsonPath("$.[*].discountReasonCode").value(hasItem(DEFAULT_DISCOUNT_REASON_CODE)))
            .andExpect(jsonPath("$.[*].fixedRateYn").value(hasItem(DEFAULT_FIXED_RATE_YN)))
            .andExpect(jsonPath("$.[*].baseRateAmount").value(hasItem(sameNumber(DEFAULT_BASE_RATE_AMOUNT))))
            .andExpect(jsonPath("$.[*].autoPostAmount").value(hasItem(sameNumber(DEFAULT_AUTO_POST_AMOUNT))))
            .andExpect(jsonPath("$.[*].sharePriority").value(hasItem(DEFAULT_SHARE_PRIORITY)))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastShareCalculation").value(hasItem(DEFAULT_LAST_SHARE_CALCULATION)))
            .andExpect(jsonPath("$.[*].insertActionInstanceId").value(hasItem(DEFAULT_INSERT_ACTION_INSTANCE_ID)))
            .andExpect(jsonPath("$.[*].dmlSeqNo").value(hasItem(DEFAULT_DML_SEQ_NO)))
            .andExpect(jsonPath("$.[*].netRoomAmt").value(hasItem(sameNumber(DEFAULT_NET_ROOM_AMT))))
            .andExpect(jsonPath("$.[*].roomTax").value(hasItem(sameNumber(DEFAULT_ROOM_TAX))))
            .andExpect(jsonPath("$.[*].pkgAmt").value(hasItem(sameNumber(DEFAULT_PKG_AMT))))
            .andExpect(jsonPath("$.[*].pkgTax").value(hasItem(sameNumber(DEFAULT_PKG_TAX))))
            .andExpect(jsonPath("$.[*].grossRateAmt").value(hasItem(sameNumber(DEFAULT_GROSS_RATE_AMT))))
            .andExpect(jsonPath("$.[*].adultsTaxFree").value(hasItem(DEFAULT_ADULTS_TAX_FREE)))
            .andExpect(jsonPath("$.[*].childrenTaxFree").value(hasItem(DEFAULT_CHILDREN_TAX_FREE)))
            .andExpect(jsonPath("$.[*].children1").value(hasItem(DEFAULT_CHILDREN_1)))
            .andExpect(jsonPath("$.[*].children2").value(hasItem(DEFAULT_CHILDREN_2)))
            .andExpect(jsonPath("$.[*].children3").value(hasItem(DEFAULT_CHILDREN_3)))
            .andExpect(jsonPath("$.[*].rateCode").value(hasItem(DEFAULT_RATE_CODE)))
            .andExpect(jsonPath("$.[*].currencyCode").value(hasItem(DEFAULT_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].exchangePostingType").value(hasItem(DEFAULT_EXCHANGE_POSTING_TYPE)))
            .andExpect(jsonPath("$.[*].membershipPoints").value(hasItem(DEFAULT_MEMBERSHIP_POINTS)))
            .andExpect(jsonPath("$.[*].children4").value(hasItem(DEFAULT_CHILDREN_4)))
            .andExpect(jsonPath("$.[*].children5").value(hasItem(DEFAULT_CHILDREN_5)))
            .andExpect(jsonPath("$.[*].commissionCode").value(hasItem(DEFAULT_COMMISSION_CODE)))
            .andExpect(jsonPath("$.[*].awardCode1").value(hasItem(DEFAULT_AWARD_CODE_1)))
            .andExpect(jsonPath("$.[*].awardCode2").value(hasItem(DEFAULT_AWARD_CODE_2)))
            .andExpect(jsonPath("$.[*].awardCode3").value(hasItem(DEFAULT_AWARD_CODE_3)))
            .andExpect(jsonPath("$.[*].awardCode4").value(hasItem(DEFAULT_AWARD_CODE_4)))
            .andExpect(jsonPath("$.[*].awardCode5").value(hasItem(DEFAULT_AWARD_CODE_5)))
            .andExpect(jsonPath("$.[*].awardVoucher1").value(hasItem(DEFAULT_AWARD_VOUCHER_1)))
            .andExpect(jsonPath("$.[*].awardVoucher2").value(hasItem(DEFAULT_AWARD_VOUCHER_2)))
            .andExpect(jsonPath("$.[*].awardVoucher3").value(hasItem(DEFAULT_AWARD_VOUCHER_3)))
            .andExpect(jsonPath("$.[*].awardVoucher4").value(hasItem(DEFAULT_AWARD_VOUCHER_4)))
            .andExpect(jsonPath("$.[*].awardVoucher5").value(hasItem(DEFAULT_AWARD_VOUCHER_5)))
            .andExpect(jsonPath("$.[*].doNotMoveYn").value(hasItem(DEFAULT_DO_NOT_MOVE_YN)))
            .andExpect(jsonPath("$.[*].awardCode").value(hasItem(DEFAULT_AWARD_CODE)))
            .andExpect(jsonPath("$.[*].points").value(hasItem(DEFAULT_POINTS)))
            .andExpect(jsonPath("$.[*].upsellCharge").value(hasItem(sameNumber(DEFAULT_UPSELL_CHARGE))))
            .andExpect(jsonPath("$.[*].pointsEligibilityCode").value(hasItem(DEFAULT_POINTS_ELIGIBILITY_CODE)))
            .andExpect(jsonPath("$.[*].commissionPaid").value(hasItem(sameNumber(DEFAULT_COMMISSION_PAID))))
            .andExpect(jsonPath("$.[*].resvContactId").value(hasItem(DEFAULT_RESV_CONTACT_ID)))
            .andExpect(jsonPath("$.[*].billingContactId").value(hasItem(DEFAULT_BILLING_CONTACT_ID)))
            .andExpect(jsonPath("$.[*].shareAmountOriginal").value(hasItem(sameNumber(DEFAULT_SHARE_AMOUNT_ORIGINAL))))
            .andExpect(jsonPath("$.[*].referralYn").value(hasItem(DEFAULT_REFERRAL_YN)))
            .andExpect(jsonPath("$.[*].bxgyDiscountYn").value(hasItem(DEFAULT_BXGY_DISCOUNT_YN)))
            .andExpect(jsonPath("$.[*].commissionableYn").value(hasItem(DEFAULT_COMMISSIONABLE_YN)))
            .andExpect(jsonPath("$.[*].basedOnRule").value(hasItem(DEFAULT_BASED_ON_RULE)));
    }

    @Test
    @Transactional
    void getReservationDailyElementName() throws Exception {
        // Initialize the database
        reservationDailyElementNameRepository.saveAndFlush(reservationDailyElementName);

        // Get the reservationDailyElementName
        restReservationDailyElementNameMockMvc
            .perform(get(ENTITY_API_URL_ID, reservationDailyElementName.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(reservationDailyElementName.getId().intValue()))
            .andExpect(jsonPath("$.resort").value(DEFAULT_RESORT))
            .andExpect(jsonPath("$.resvNameId").value(DEFAULT_RESV_NAME_ID))
            .andExpect(jsonPath("$.reservationDate").value(DEFAULT_RESERVATION_DATE.toString()))
            .andExpect(jsonPath("$.resvDailyElSeq").value(DEFAULT_RESV_DAILY_EL_SEQ))
            .andExpect(jsonPath("$.travelAgentId").value(DEFAULT_TRAVEL_AGENT_ID))
            .andExpect(jsonPath("$.companyId").value(DEFAULT_COMPANY_ID))
            .andExpect(jsonPath("$.sourceId").value(DEFAULT_SOURCE_ID))
            .andExpect(jsonPath("$.groupId").value(DEFAULT_GROUP_ID))
            .andExpect(jsonPath("$.sharePaymentType").value(DEFAULT_SHARE_PAYMENT_TYPE))
            .andExpect(jsonPath("$.shareAmount").value(sameNumber(DEFAULT_SHARE_AMOUNT)))
            .andExpect(jsonPath("$.sharePrcnt").value(sameNumber(DEFAULT_SHARE_PRCNT)))
            .andExpect(jsonPath("$.adults").value(DEFAULT_ADULTS))
            .andExpect(jsonPath("$.children").value(DEFAULT_CHILDREN))
            .andExpect(jsonPath("$.discountAmt").value(sameNumber(DEFAULT_DISCOUNT_AMT)))
            .andExpect(jsonPath("$.discountPrcnt").value(sameNumber(DEFAULT_DISCOUNT_PRCNT)))
            .andExpect(jsonPath("$.discountReasonCode").value(DEFAULT_DISCOUNT_REASON_CODE))
            .andExpect(jsonPath("$.fixedRateYn").value(DEFAULT_FIXED_RATE_YN))
            .andExpect(jsonPath("$.baseRateAmount").value(sameNumber(DEFAULT_BASE_RATE_AMOUNT)))
            .andExpect(jsonPath("$.autoPostAmount").value(sameNumber(DEFAULT_AUTO_POST_AMOUNT)))
            .andExpect(jsonPath("$.sharePriority").value(DEFAULT_SHARE_PRIORITY))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.lastShareCalculation").value(DEFAULT_LAST_SHARE_CALCULATION))
            .andExpect(jsonPath("$.insertActionInstanceId").value(DEFAULT_INSERT_ACTION_INSTANCE_ID))
            .andExpect(jsonPath("$.dmlSeqNo").value(DEFAULT_DML_SEQ_NO))
            .andExpect(jsonPath("$.netRoomAmt").value(sameNumber(DEFAULT_NET_ROOM_AMT)))
            .andExpect(jsonPath("$.roomTax").value(sameNumber(DEFAULT_ROOM_TAX)))
            .andExpect(jsonPath("$.pkgAmt").value(sameNumber(DEFAULT_PKG_AMT)))
            .andExpect(jsonPath("$.pkgTax").value(sameNumber(DEFAULT_PKG_TAX)))
            .andExpect(jsonPath("$.grossRateAmt").value(sameNumber(DEFAULT_GROSS_RATE_AMT)))
            .andExpect(jsonPath("$.adultsTaxFree").value(DEFAULT_ADULTS_TAX_FREE))
            .andExpect(jsonPath("$.childrenTaxFree").value(DEFAULT_CHILDREN_TAX_FREE))
            .andExpect(jsonPath("$.children1").value(DEFAULT_CHILDREN_1))
            .andExpect(jsonPath("$.children2").value(DEFAULT_CHILDREN_2))
            .andExpect(jsonPath("$.children3").value(DEFAULT_CHILDREN_3))
            .andExpect(jsonPath("$.rateCode").value(DEFAULT_RATE_CODE))
            .andExpect(jsonPath("$.currencyCode").value(DEFAULT_CURRENCY_CODE))
            .andExpect(jsonPath("$.exchangePostingType").value(DEFAULT_EXCHANGE_POSTING_TYPE))
            .andExpect(jsonPath("$.membershipPoints").value(DEFAULT_MEMBERSHIP_POINTS))
            .andExpect(jsonPath("$.children4").value(DEFAULT_CHILDREN_4))
            .andExpect(jsonPath("$.children5").value(DEFAULT_CHILDREN_5))
            .andExpect(jsonPath("$.commissionCode").value(DEFAULT_COMMISSION_CODE))
            .andExpect(jsonPath("$.awardCode1").value(DEFAULT_AWARD_CODE_1))
            .andExpect(jsonPath("$.awardCode2").value(DEFAULT_AWARD_CODE_2))
            .andExpect(jsonPath("$.awardCode3").value(DEFAULT_AWARD_CODE_3))
            .andExpect(jsonPath("$.awardCode4").value(DEFAULT_AWARD_CODE_4))
            .andExpect(jsonPath("$.awardCode5").value(DEFAULT_AWARD_CODE_5))
            .andExpect(jsonPath("$.awardVoucher1").value(DEFAULT_AWARD_VOUCHER_1))
            .andExpect(jsonPath("$.awardVoucher2").value(DEFAULT_AWARD_VOUCHER_2))
            .andExpect(jsonPath("$.awardVoucher3").value(DEFAULT_AWARD_VOUCHER_3))
            .andExpect(jsonPath("$.awardVoucher4").value(DEFAULT_AWARD_VOUCHER_4))
            .andExpect(jsonPath("$.awardVoucher5").value(DEFAULT_AWARD_VOUCHER_5))
            .andExpect(jsonPath("$.doNotMoveYn").value(DEFAULT_DO_NOT_MOVE_YN))
            .andExpect(jsonPath("$.awardCode").value(DEFAULT_AWARD_CODE))
            .andExpect(jsonPath("$.points").value(DEFAULT_POINTS))
            .andExpect(jsonPath("$.upsellCharge").value(sameNumber(DEFAULT_UPSELL_CHARGE)))
            .andExpect(jsonPath("$.pointsEligibilityCode").value(DEFAULT_POINTS_ELIGIBILITY_CODE))
            .andExpect(jsonPath("$.commissionPaid").value(sameNumber(DEFAULT_COMMISSION_PAID)))
            .andExpect(jsonPath("$.resvContactId").value(DEFAULT_RESV_CONTACT_ID))
            .andExpect(jsonPath("$.billingContactId").value(DEFAULT_BILLING_CONTACT_ID))
            .andExpect(jsonPath("$.shareAmountOriginal").value(sameNumber(DEFAULT_SHARE_AMOUNT_ORIGINAL)))
            .andExpect(jsonPath("$.referralYn").value(DEFAULT_REFERRAL_YN))
            .andExpect(jsonPath("$.bxgyDiscountYn").value(DEFAULT_BXGY_DISCOUNT_YN))
            .andExpect(jsonPath("$.commissionableYn").value(DEFAULT_COMMISSIONABLE_YN))
            .andExpect(jsonPath("$.basedOnRule").value(DEFAULT_BASED_ON_RULE));
    }

    @Test
    @Transactional
    void getNonExistingReservationDailyElementName() throws Exception {
        // Get the reservationDailyElementName
        restReservationDailyElementNameMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingReservationDailyElementName() throws Exception {
        // Initialize the database
        reservationDailyElementNameRepository.saveAndFlush(reservationDailyElementName);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationDailyElementName
        ReservationDailyElementName updatedReservationDailyElementName = reservationDailyElementNameRepository
            .findById(reservationDailyElementName.getId())
            .orElseThrow();
        // Disconnect from session so that the updates on updatedReservationDailyElementName are not directly saved in db
        em.detach(updatedReservationDailyElementName);
        updatedReservationDailyElementName
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .reservationDate(UPDATED_RESERVATION_DATE)
            .resvDailyElSeq(UPDATED_RESV_DAILY_EL_SEQ)
            .travelAgentId(UPDATED_TRAVEL_AGENT_ID)
            .companyId(UPDATED_COMPANY_ID)
            .sourceId(UPDATED_SOURCE_ID)
            .groupId(UPDATED_GROUP_ID)
            .sharePaymentType(UPDATED_SHARE_PAYMENT_TYPE)
            .shareAmount(UPDATED_SHARE_AMOUNT)
            .sharePrcnt(UPDATED_SHARE_PRCNT)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .discountAmt(UPDATED_DISCOUNT_AMT)
            .discountPrcnt(UPDATED_DISCOUNT_PRCNT)
            .discountReasonCode(UPDATED_DISCOUNT_REASON_CODE)
            .fixedRateYn(UPDATED_FIXED_RATE_YN)
            .baseRateAmount(UPDATED_BASE_RATE_AMOUNT)
            .autoPostAmount(UPDATED_AUTO_POST_AMOUNT)
            .sharePriority(UPDATED_SHARE_PRIORITY)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .lastShareCalculation(UPDATED_LAST_SHARE_CALCULATION)
            .insertActionInstanceId(UPDATED_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(UPDATED_DML_SEQ_NO)
            .netRoomAmt(UPDATED_NET_ROOM_AMT)
            .roomTax(UPDATED_ROOM_TAX)
            .pkgAmt(UPDATED_PKG_AMT)
            .pkgTax(UPDATED_PKG_TAX)
            .grossRateAmt(UPDATED_GROSS_RATE_AMT)
            .adultsTaxFree(UPDATED_ADULTS_TAX_FREE)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .children1(UPDATED_CHILDREN_1)
            .children2(UPDATED_CHILDREN_2)
            .children3(UPDATED_CHILDREN_3)
            .rateCode(UPDATED_RATE_CODE)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .exchangePostingType(UPDATED_EXCHANGE_POSTING_TYPE)
            .membershipPoints(UPDATED_MEMBERSHIP_POINTS)
            .children4(UPDATED_CHILDREN_4)
            .children5(UPDATED_CHILDREN_5)
            .commissionCode(UPDATED_COMMISSION_CODE)
            .awardCode1(UPDATED_AWARD_CODE_1)
            .awardCode2(UPDATED_AWARD_CODE_2)
            .awardCode3(UPDATED_AWARD_CODE_3)
            .awardCode4(UPDATED_AWARD_CODE_4)
            .awardCode5(UPDATED_AWARD_CODE_5)
            .awardVoucher1(UPDATED_AWARD_VOUCHER_1)
            .awardVoucher2(UPDATED_AWARD_VOUCHER_2)
            .awardVoucher3(UPDATED_AWARD_VOUCHER_3)
            .awardVoucher4(UPDATED_AWARD_VOUCHER_4)
            .awardVoucher5(UPDATED_AWARD_VOUCHER_5)
            .doNotMoveYn(UPDATED_DO_NOT_MOVE_YN)
            .awardCode(UPDATED_AWARD_CODE)
            .points(UPDATED_POINTS)
            .upsellCharge(UPDATED_UPSELL_CHARGE)
            .pointsEligibilityCode(UPDATED_POINTS_ELIGIBILITY_CODE)
            .commissionPaid(UPDATED_COMMISSION_PAID)
            .resvContactId(UPDATED_RESV_CONTACT_ID)
            .billingContactId(UPDATED_BILLING_CONTACT_ID)
            .shareAmountOriginal(UPDATED_SHARE_AMOUNT_ORIGINAL)
            .referralYn(UPDATED_REFERRAL_YN)
            .bxgyDiscountYn(UPDATED_BXGY_DISCOUNT_YN)
            .commissionableYn(UPDATED_COMMISSIONABLE_YN)
            .basedOnRule(UPDATED_BASED_ON_RULE);

        restReservationDailyElementNameMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedReservationDailyElementName.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedReservationDailyElementName))
            )
            .andExpect(status().isOk());

        // Validate the ReservationDailyElementName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedReservationDailyElementNameToMatchAllProperties(updatedReservationDailyElementName);
    }

    @Test
    @Transactional
    void putNonExistingReservationDailyElementName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElementName.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReservationDailyElementNameMockMvc
            .perform(
                put(ENTITY_API_URL_ID, reservationDailyElementName.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reservationDailyElementName))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationDailyElementName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchReservationDailyElementName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElementName.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationDailyElementNameMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(reservationDailyElementName))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationDailyElementName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamReservationDailyElementName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElementName.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationDailyElementNameMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(reservationDailyElementName)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReservationDailyElementName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateReservationDailyElementNameWithPatch() throws Exception {
        // Initialize the database
        reservationDailyElementNameRepository.saveAndFlush(reservationDailyElementName);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationDailyElementName using partial update
        ReservationDailyElementName partialUpdatedReservationDailyElementName = new ReservationDailyElementName();
        partialUpdatedReservationDailyElementName.setId(reservationDailyElementName.getId());

        partialUpdatedReservationDailyElementName
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .resvDailyElSeq(UPDATED_RESV_DAILY_EL_SEQ)
            .travelAgentId(UPDATED_TRAVEL_AGENT_ID)
            .companyId(UPDATED_COMPANY_ID)
            .sourceId(UPDATED_SOURCE_ID)
            .groupId(UPDATED_GROUP_ID)
            .children(UPDATED_CHILDREN)
            .discountPrcnt(UPDATED_DISCOUNT_PRCNT)
            .insertUser(UPDATED_INSERT_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .netRoomAmt(UPDATED_NET_ROOM_AMT)
            .roomTax(UPDATED_ROOM_TAX)
            .pkgTax(UPDATED_PKG_TAX)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .children3(UPDATED_CHILDREN_3)
            .rateCode(UPDATED_RATE_CODE)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .exchangePostingType(UPDATED_EXCHANGE_POSTING_TYPE)
            .children4(UPDATED_CHILDREN_4)
            .awardCode1(UPDATED_AWARD_CODE_1)
            .awardCode2(UPDATED_AWARD_CODE_2)
            .awardCode3(UPDATED_AWARD_CODE_3)
            .awardCode4(UPDATED_AWARD_CODE_4)
            .awardCode5(UPDATED_AWARD_CODE_5)
            .awardVoucher1(UPDATED_AWARD_VOUCHER_1)
            .awardVoucher2(UPDATED_AWARD_VOUCHER_2)
            .awardVoucher5(UPDATED_AWARD_VOUCHER_5)
            .doNotMoveYn(UPDATED_DO_NOT_MOVE_YN)
            .resvContactId(UPDATED_RESV_CONTACT_ID)
            .billingContactId(UPDATED_BILLING_CONTACT_ID)
            .referralYn(UPDATED_REFERRAL_YN)
            .bxgyDiscountYn(UPDATED_BXGY_DISCOUNT_YN)
            .basedOnRule(UPDATED_BASED_ON_RULE);

        restReservationDailyElementNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReservationDailyElementName.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReservationDailyElementName))
            )
            .andExpect(status().isOk());

        // Validate the ReservationDailyElementName in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReservationDailyElementNameUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedReservationDailyElementName, reservationDailyElementName),
            getPersistedReservationDailyElementName(reservationDailyElementName)
        );
    }

    @Test
    @Transactional
    void fullUpdateReservationDailyElementNameWithPatch() throws Exception {
        // Initialize the database
        reservationDailyElementNameRepository.saveAndFlush(reservationDailyElementName);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the reservationDailyElementName using partial update
        ReservationDailyElementName partialUpdatedReservationDailyElementName = new ReservationDailyElementName();
        partialUpdatedReservationDailyElementName.setId(reservationDailyElementName.getId());

        partialUpdatedReservationDailyElementName
            .resort(UPDATED_RESORT)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .reservationDate(UPDATED_RESERVATION_DATE)
            .resvDailyElSeq(UPDATED_RESV_DAILY_EL_SEQ)
            .travelAgentId(UPDATED_TRAVEL_AGENT_ID)
            .companyId(UPDATED_COMPANY_ID)
            .sourceId(UPDATED_SOURCE_ID)
            .groupId(UPDATED_GROUP_ID)
            .sharePaymentType(UPDATED_SHARE_PAYMENT_TYPE)
            .shareAmount(UPDATED_SHARE_AMOUNT)
            .sharePrcnt(UPDATED_SHARE_PRCNT)
            .adults(UPDATED_ADULTS)
            .children(UPDATED_CHILDREN)
            .discountAmt(UPDATED_DISCOUNT_AMT)
            .discountPrcnt(UPDATED_DISCOUNT_PRCNT)
            .discountReasonCode(UPDATED_DISCOUNT_REASON_CODE)
            .fixedRateYn(UPDATED_FIXED_RATE_YN)
            .baseRateAmount(UPDATED_BASE_RATE_AMOUNT)
            .autoPostAmount(UPDATED_AUTO_POST_AMOUNT)
            .sharePriority(UPDATED_SHARE_PRIORITY)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .lastShareCalculation(UPDATED_LAST_SHARE_CALCULATION)
            .insertActionInstanceId(UPDATED_INSERT_ACTION_INSTANCE_ID)
            .dmlSeqNo(UPDATED_DML_SEQ_NO)
            .netRoomAmt(UPDATED_NET_ROOM_AMT)
            .roomTax(UPDATED_ROOM_TAX)
            .pkgAmt(UPDATED_PKG_AMT)
            .pkgTax(UPDATED_PKG_TAX)
            .grossRateAmt(UPDATED_GROSS_RATE_AMT)
            .adultsTaxFree(UPDATED_ADULTS_TAX_FREE)
            .childrenTaxFree(UPDATED_CHILDREN_TAX_FREE)
            .children1(UPDATED_CHILDREN_1)
            .children2(UPDATED_CHILDREN_2)
            .children3(UPDATED_CHILDREN_3)
            .rateCode(UPDATED_RATE_CODE)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .exchangePostingType(UPDATED_EXCHANGE_POSTING_TYPE)
            .membershipPoints(UPDATED_MEMBERSHIP_POINTS)
            .children4(UPDATED_CHILDREN_4)
            .children5(UPDATED_CHILDREN_5)
            .commissionCode(UPDATED_COMMISSION_CODE)
            .awardCode1(UPDATED_AWARD_CODE_1)
            .awardCode2(UPDATED_AWARD_CODE_2)
            .awardCode3(UPDATED_AWARD_CODE_3)
            .awardCode4(UPDATED_AWARD_CODE_4)
            .awardCode5(UPDATED_AWARD_CODE_5)
            .awardVoucher1(UPDATED_AWARD_VOUCHER_1)
            .awardVoucher2(UPDATED_AWARD_VOUCHER_2)
            .awardVoucher3(UPDATED_AWARD_VOUCHER_3)
            .awardVoucher4(UPDATED_AWARD_VOUCHER_4)
            .awardVoucher5(UPDATED_AWARD_VOUCHER_5)
            .doNotMoveYn(UPDATED_DO_NOT_MOVE_YN)
            .awardCode(UPDATED_AWARD_CODE)
            .points(UPDATED_POINTS)
            .upsellCharge(UPDATED_UPSELL_CHARGE)
            .pointsEligibilityCode(UPDATED_POINTS_ELIGIBILITY_CODE)
            .commissionPaid(UPDATED_COMMISSION_PAID)
            .resvContactId(UPDATED_RESV_CONTACT_ID)
            .billingContactId(UPDATED_BILLING_CONTACT_ID)
            .shareAmountOriginal(UPDATED_SHARE_AMOUNT_ORIGINAL)
            .referralYn(UPDATED_REFERRAL_YN)
            .bxgyDiscountYn(UPDATED_BXGY_DISCOUNT_YN)
            .commissionableYn(UPDATED_COMMISSIONABLE_YN)
            .basedOnRule(UPDATED_BASED_ON_RULE);

        restReservationDailyElementNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedReservationDailyElementName.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedReservationDailyElementName))
            )
            .andExpect(status().isOk());

        // Validate the ReservationDailyElementName in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertReservationDailyElementNameUpdatableFieldsEquals(
            partialUpdatedReservationDailyElementName,
            getPersistedReservationDailyElementName(partialUpdatedReservationDailyElementName)
        );
    }

    @Test
    @Transactional
    void patchNonExistingReservationDailyElementName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElementName.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReservationDailyElementNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, reservationDailyElementName.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reservationDailyElementName))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationDailyElementName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchReservationDailyElementName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElementName.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationDailyElementNameMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(reservationDailyElementName))
            )
            .andExpect(status().isBadRequest());

        // Validate the ReservationDailyElementName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamReservationDailyElementName() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        reservationDailyElementName.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restReservationDailyElementNameMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(reservationDailyElementName))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ReservationDailyElementName in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteReservationDailyElementName() throws Exception {
        // Initialize the database
        reservationDailyElementNameRepository.saveAndFlush(reservationDailyElementName);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the reservationDailyElementName
        restReservationDailyElementNameMockMvc
            .perform(delete(ENTITY_API_URL_ID, reservationDailyElementName.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return reservationDailyElementNameRepository.count();
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

    protected ReservationDailyElementName getPersistedReservationDailyElementName(ReservationDailyElementName reservationDailyElementName) {
        return reservationDailyElementNameRepository.findById(reservationDailyElementName.getId()).orElseThrow();
    }

    protected void assertPersistedReservationDailyElementNameToMatchAllProperties(
        ReservationDailyElementName expectedReservationDailyElementName
    ) {
        assertReservationDailyElementNameAllPropertiesEquals(
            expectedReservationDailyElementName,
            getPersistedReservationDailyElementName(expectedReservationDailyElementName)
        );
    }

    protected void assertPersistedReservationDailyElementNameToMatchUpdatableProperties(
        ReservationDailyElementName expectedReservationDailyElementName
    ) {
        assertReservationDailyElementNameAllUpdatablePropertiesEquals(
            expectedReservationDailyElementName,
            getPersistedReservationDailyElementName(expectedReservationDailyElementName)
        );
    }
}
