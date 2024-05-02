package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.FinancialTransactionsAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static com.sbm.mc.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.FinancialTransactions;
import com.sbm.mc.repository.FinancialTransactionsRepository;
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
 * Integration tests for the {@link FinancialTransactionsResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class FinancialTransactionsResourceIT {

    private static final Integer DEFAULT_TRX_NO = 1;
    private static final Integer UPDATED_TRX_NO = 2;

    private static final String DEFAULT_FT_SUBTYPE = "AAAAAAAAAA";
    private static final String UPDATED_FT_SUBTYPE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_INVOICE_CLOSE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INVOICE_CLOSE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_AR_TRANSFER_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_AR_TRANSFER_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRX_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRX_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_BUSINESS_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BUSINESS_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_TRNS_ACTIVITY_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TRNS_ACTIVITY_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_APPROVAL_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_APPROVAL_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_POSTING_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_POSTING_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_EXCHANGE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EXCHANGE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_ROUTING_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ROUTING_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_EFFECTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EFFECTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CUSTOM_CHARGE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CUSTOM_CHARGE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_RECPT_NO = 1;
    private static final Integer UPDATED_RECPT_NO = 2;

    private static final Integer DEFAULT_TRX_NO_ADJUST = 1;
    private static final Integer UPDATED_TRX_NO_ADJUST = 2;

    private static final Integer DEFAULT_TRX_NO_ADDED_BY = 1;
    private static final Integer UPDATED_TRX_NO_ADDED_BY = 2;

    private static final Integer DEFAULT_TRX_NO_AGAINST_PACKAGE = 1;
    private static final Integer UPDATED_TRX_NO_AGAINST_PACKAGE = 2;

    private static final Integer DEFAULT_TRX_NO_HEADER = 1;
    private static final Integer UPDATED_TRX_NO_HEADER = 2;

    private static final Integer DEFAULT_AR_NUMBER = 1;
    private static final Integer UPDATED_AR_NUMBER = 2;

    private static final Integer DEFAULT_RESV_NAME_ID = 1;
    private static final Integer UPDATED_RESV_NAME_ID = 2;

    private static final Integer DEFAULT_CASHIER_ID = 1;
    private static final Integer UPDATED_CASHIER_ID = 2;

    private static final Integer DEFAULT_CREDIT_CARD_ID = 1;
    private static final Integer UPDATED_CREDIT_CARD_ID = 2;

    private static final Integer DEFAULT_NAME_ID = 1;
    private static final Integer UPDATED_NAME_ID = 2;

    private static final Integer DEFAULT_TRAN_ACTION_ID = 1;
    private static final Integer UPDATED_TRAN_ACTION_ID = 2;

    private static final Integer DEFAULT_FIN_DML_SEQ_NO = 1;
    private static final Integer UPDATED_FIN_DML_SEQ_NO = 2;

    private static final Integer DEFAULT_ROUTING_INSTRN_ID = 1;
    private static final Integer UPDATED_ROUTING_INSTRN_ID = 2;

    private static final Integer DEFAULT_FROM_RESV_ID = 1;
    private static final Integer UPDATED_FROM_RESV_ID = 2;

    private static final Integer DEFAULT_GEN_CASHIER_ID = 1;
    private static final Integer UPDATED_GEN_CASHIER_ID = 2;

    private static final Integer DEFAULT_FOLIO_NO = 1;
    private static final Integer UPDATED_FOLIO_NO = 2;

    private static final Integer DEFAULT_INVOICE_NO = 1;
    private static final Integer UPDATED_INVOICE_NO = 2;

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final Integer DEFAULT_ARRANGEMENT_ID = 1;
    private static final Integer UPDATED_ARRANGEMENT_ID = 2;

    private static final Integer DEFAULT_TRNS_FROM_ACCT = 1;
    private static final Integer UPDATED_TRNS_FROM_ACCT = 2;

    private static final Integer DEFAULT_TRNS_TO_ACCT = 1;
    private static final Integer UPDATED_TRNS_TO_ACCT = 2;

    private static final Integer DEFAULT_BILL_NO = 1;
    private static final Integer UPDATED_BILL_NO = 2;

    private static final Integer DEFAULT_REVISION_NO = 1;
    private static final Integer UPDATED_REVISION_NO = 2;

    private static final Integer DEFAULT_RESV_DEPOSIT_ID = 1;
    private static final Integer UPDATED_RESV_DEPOSIT_ID = 2;

    private static final Integer DEFAULT_LINK_TRX_NO = 1;
    private static final Integer UPDATED_LINK_TRX_NO = 2;

    private static final Integer DEFAULT_AUTHORIZER_ID = 1;
    private static final Integer UPDATED_AUTHORIZER_ID = 2;

    private static final Integer DEFAULT_COMP_LINK_TRX_NO = 1;
    private static final Integer UPDATED_COMP_LINK_TRX_NO = 2;

    private static final Integer DEFAULT_MTRX_NO_AGAINST_PACKAGE = 1;
    private static final Integer UPDATED_MTRX_NO_AGAINST_PACKAGE = 2;

    private static final Integer DEFAULT_FOREX_COMM_PERC = 1;
    private static final Integer UPDATED_FOREX_COMM_PERC = 2;

    private static final Integer DEFAULT_FOREX_COMM_AMOUNT = 1;
    private static final Integer UPDATED_FOREX_COMM_AMOUNT = 2;

    private static final Integer DEFAULT_ARTICLE_ID = 1;
    private static final Integer UPDATED_ARTICLE_ID = 2;

    private static final Integer DEFAULT_TO_RESV_NAME_ID = 1;
    private static final Integer UPDATED_TO_RESV_NAME_ID = 2;

    private static final Integer DEFAULT_ROOM_NTS = 1;
    private static final Integer UPDATED_ROOM_NTS = 2;

    private static final Integer DEFAULT_ORG_AR_LED_DEBIT = 1;
    private static final Integer UPDATED_ORG_AR_LED_DEBIT = 2;

    private static final Integer DEFAULT_CLOSURE_NO = 1;
    private static final Integer UPDATED_CLOSURE_NO = 2;

    private static final Integer DEFAULT_ORIGINAL_RESV_NAME_ID = 1;
    private static final Integer UPDATED_ORIGINAL_RESV_NAME_ID = 2;

    private static final Integer DEFAULT_ORG_BILL_NO = 1;
    private static final Integer UPDATED_ORG_BILL_NO = 2;

    private static final Integer DEFAULT_MEMBERSHIP_ID = 1;
    private static final Integer UPDATED_MEMBERSHIP_ID = 2;

    private static final Integer DEFAULT_INSTALLMENTS = 1;
    private static final Integer UPDATED_INSTALLMENTS = 2;

    private static final Integer DEFAULT_CONTRACT_GUEST_DEBIT = 1;
    private static final Integer UPDATED_CONTRACT_GUEST_DEBIT = 2;

    private static final Integer DEFAULT_CONTRACT_GUEST_CREDIT = 1;
    private static final Integer UPDATED_CONTRACT_GUEST_CREDIT = 2;

    private static final Integer DEFAULT_CONTRACT_NET_AMOUNT = 1;
    private static final Integer UPDATED_CONTRACT_NET_AMOUNT = 2;

    private static final Integer DEFAULT_CONTRACT_GROSS_AMOUNT = 1;
    private static final Integer UPDATED_CONTRACT_GROSS_AMOUNT = 2;

    private static final Integer DEFAULT_POSTIT_NO = 1;
    private static final Integer UPDATED_POSTIT_NO = 2;

    private static final Integer DEFAULT_CC_TRX_FEE_AMOUNT = 1;
    private static final Integer UPDATED_CC_TRX_FEE_AMOUNT = 2;

    private static final Integer DEFAULT_CHANGE_DUE = 1;
    private static final Integer UPDATED_CHANGE_DUE = 2;

    private static final Integer DEFAULT_POSTING_SOURCE_NAME_ID = 1;
    private static final Integer UPDATED_POSTING_SOURCE_NAME_ID = 2;

    private static final Integer DEFAULT_BONUS_CHECK_ID = 1;
    private static final Integer UPDATED_BONUS_CHECK_ID = 2;

    private static final Integer DEFAULT_ROUND_LINK_TRXNO = 1;
    private static final Integer UPDATED_ROUND_LINK_TRXNO = 2;

    private static final Integer DEFAULT_REVERSE_PAYMENT_TRX_NO = 1;
    private static final Integer UPDATED_REVERSE_PAYMENT_TRX_NO = 2;

    private static final Integer DEFAULT_ELECTRONIC_VOUCHER_NO = 1;
    private static final Integer UPDATED_ELECTRONIC_VOUCHER_NO = 2;

    private static final Integer DEFAULT_THRESHOLD_DIVERSION_ID = 1;
    private static final Integer UPDATED_THRESHOLD_DIVERSION_ID = 2;

    private static final Integer DEFAULT_THRESHOLD_ENTITY_QTY = 1;
    private static final Integer UPDATED_THRESHOLD_ENTITY_QTY = 2;

    private static final Integer DEFAULT_TRX_NO_SPLIT = 1;
    private static final Integer UPDATED_TRX_NO_SPLIT = 2;

    private static final Integer DEFAULT_EXCH_DIFF_TRX_NO = 1;
    private static final Integer UPDATED_EXCH_DIFF_TRX_NO = 2;

    private static final Integer DEFAULT_ASSOCIATED_TRX_NO = 1;
    private static final Integer UPDATED_ASSOCIATED_TRX_NO = 2;

    private static final Integer DEFAULT_TAX_RATE = 1;
    private static final Integer UPDATED_TAX_RATE = 2;

    private static final Integer DEFAULT_PROP_CHARGE_ID = 1;
    private static final Integer UPDATED_PROP_CHARGE_ID = 2;

    private static final BigDecimal DEFAULT_QUANTITY = new BigDecimal(1);
    private static final BigDecimal UPDATED_QUANTITY = new BigDecimal(2);

    private static final BigDecimal DEFAULT_NET_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_NET_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_GROSS_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_GROSS_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_CASHIER_OPENING_BALANCE = new BigDecimal(1);
    private static final BigDecimal UPDATED_CASHIER_OPENING_BALANCE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PRICE_PER_UNIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRICE_PER_UNIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TRX_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_TRX_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_POSTED_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_POSTED_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_GUEST_ACCOUNT_CREDIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_GUEST_ACCOUNT_CREDIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_EXCHANGE_RATE = new BigDecimal(1);
    private static final BigDecimal UPDATED_EXCHANGE_RATE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_GUEST_ACCOUNT_DEBIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_GUEST_ACCOUNT_DEBIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_CASHIER_CREDIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_CASHIER_CREDIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_CASHIER_DEBIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_CASHIER_DEBIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACKAGE_CREDIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACKAGE_CREDIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACKAGE_DEBIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACKAGE_DEBIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DEP_LED_CREDIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_DEP_LED_CREDIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DEP_LED_DEBIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_DEP_LED_DEBIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_REVENUE_AMT = new BigDecimal(1);
    private static final BigDecimal UPDATED_REVENUE_AMT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_AR_LED_CREDIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_AR_LED_CREDIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_AR_LED_DEBIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_AR_LED_DEBIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_EURO_EXCHANGE_RATE = new BigDecimal(1);
    private static final BigDecimal UPDATED_EURO_EXCHANGE_RATE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_INH_DEBIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_INH_DEBIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_INH_CREDIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_INH_CREDIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACKAGE_ALLOWANCE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACKAGE_ALLOWANCE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PARALLEL_GUEST_CREDIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PARALLEL_GUEST_CREDIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PARALLEL_GUEST_DEBIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PARALLEL_GUEST_DEBIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PARALLEL_NET_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PARALLEL_NET_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PARALLEL_GROSS_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PARALLEL_GROSS_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ORG_POSTED_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_ORG_POSTED_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ROOM_NTS_EFFECTIVE = new BigDecimal(1);
    private static final BigDecimal UPDATED_ROOM_NTS_EFFECTIVE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PAYMENT_SURCHARGE_AMT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PAYMENT_SURCHARGE_AMT = new BigDecimal(2);

    private static final Integer DEFAULT_FOLIO_VIEW = 1;
    private static final Integer UPDATED_FOLIO_VIEW = 2;

    private static final String DEFAULT_TAX_INCLUSIVE_YN = "AAAAAAAAAA";
    private static final String UPDATED_TAX_INCLUSIVE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_DEFERRED_YN = "AAAAAAAAAA";
    private static final String UPDATED_DEFERRED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_IND_ADJUSTMENT_YN = "AAAAAAAAAA";
    private static final String UPDATED_IND_ADJUSTMENT_YN = "BBBBBBBBBB";

    private static final String DEFAULT_FIXED_CHARGES_YN = "AAAAAAAAAA";
    private static final String UPDATED_FIXED_CHARGES_YN = "BBBBBBBBBB";

    private static final String DEFAULT_TA_COMMISSIONABLE_YN = "AAAAAAAAAA";
    private static final String UPDATED_TA_COMMISSIONABLE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_TAX_GENERATED_YN = "AAAAAAAAAA";
    private static final String UPDATED_TAX_GENERATED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_COMPRESSED_YN = "AAAAAAAAAA";
    private static final String UPDATED_COMPRESSED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_DISPLAY_YN = "AAAAAAAAAA";
    private static final String UPDATED_DISPLAY_YN = "BBBBBBBBBB";

    private static final String DEFAULT_COLL_AGENT_POSTING_YN = "AAAAAAAAAA";
    private static final String UPDATED_COLL_AGENT_POSTING_YN = "BBBBBBBBBB";

    private static final String DEFAULT_FISCAL_TRX_CODE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_FISCAL_TRX_CODE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFERRED_TAXES_YN = "AAAAAAAAAA";
    private static final String UPDATED_DEFERRED_TAXES_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ADVANCED_GENERATE_YN = "AAAAAAAAAA";
    private static final String UPDATED_ADVANCED_GENERATE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_FOREX_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_FOREX_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_TA_COMMISSION_NET_YN = "AAAAAAAAAA";
    private static final String UPDATED_TA_COMMISSION_NET_YN = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE_COMMISSION_NET_YN = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_COMMISSION_NET_YN = "BBBBBBBBBB";

    private static final String DEFAULT_SETTLEMENT_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_SETTLEMENT_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_ACC_TYPE_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_ACC_TYPE_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_PROFIT_LOSS_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_PROFIT_LOSS_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_PROFORMA_YN = "AAAAAAAAAA";
    private static final String UPDATED_PROFORMA_YN = "BBBBBBBBBB";

    private static final String DEFAULT_HOLD_YN = "AAAAAAAAAA";
    private static final String UPDATED_HOLD_YN = "BBBBBBBBBB";

    private static final String DEFAULT_EXCHANGE_DIFFERENCE_YN = "AAAAAAAAAA";
    private static final String UPDATED_EXCHANGE_DIFFERENCE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_CALC_POINTS_YN = "AAAAAAAAAA";
    private static final String UPDATED_CALC_POINTS_YN = "BBBBBBBBBB";

    private static final String DEFAULT_AR_CHARGE_TRANSFER_YN = "AAAAAAAAAA";
    private static final String UPDATED_AR_CHARGE_TRANSFER_YN = "BBBBBBBBBB";

    private static final String DEFAULT_PROCESSED_8300_YN = "AAAAAAAAAA";
    private static final String UPDATED_PROCESSED_8300_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ASB_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_ASB_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_POSTIT_YN = "AAAAAAAAAA";
    private static final String UPDATED_POSTIT_YN = "BBBBBBBBBB";

    private static final String DEFAULT_AUTO_SETTLE_YN = "AAAAAAAAAA";
    private static final String UPDATED_AUTO_SETTLE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_DEP_TAX_TRANSFERED_YN = "AAAAAAAAAA";
    private static final String UPDATED_DEP_TAX_TRANSFERED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_AUTO_CREDITBILL_YN = "AAAAAAAAAA";
    private static final String UPDATED_AUTO_CREDITBILL_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ASB_ONLY_POST_TAXES_ONCE_YN = "AAAAAAAAAA";
    private static final String UPDATED_ASB_ONLY_POST_TAXES_ONCE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ROUND_FACTOR_YN = "AAAAAAAAAA";
    private static final String UPDATED_ROUND_FACTOR_YN = "BBBBBBBBBB";

    private static final String DEFAULT_DEP_POSTING_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_DEP_POSTING_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_CORRECTION_YN = "AAAAAAAAAA";
    private static final String UPDATED_CORRECTION_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ROUTED_YN = "AAAAAAAAAA";
    private static final String UPDATED_ROUTED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_UPSELL_CHARGE_YN = "AAAAAAAAAA";
    private static final String UPDATED_UPSELL_CHARGE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ADVANCE_BILL_YN = "AAAAAAAAAA";
    private static final String UPDATED_ADVANCE_BILL_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ADVANCE_BILL_REVERSED_YN = "AAAAAAAAAA";
    private static final String UPDATED_ADVANCE_BILL_REVERSED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_INC_TAX_DEDUCTED_YN = "AAAAAAAAAA";
    private static final String UPDATED_INC_TAX_DEDUCTED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_GP_AWARD_CANCELLED_YN = "AAAAAAAAAA";
    private static final String UPDATED_GP_AWARD_CANCELLED_YN = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_RECOVERY_ADJUSTMENT_YN = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_RECOVERY_ADJUSTMENT_YN = "BBBBBBBBBB";

    private static final String DEFAULT_SPLIT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_SPLIT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_BUCKET_REDEMP_YN = "AAAAAAAAAA";
    private static final String UPDATED_BUCKET_REDEMP_YN = "BBBBBBBBBB";

    private static final String DEFAULT_VAT_OFFSET_YN = "AAAAAAAAAA";
    private static final String UPDATED_VAT_OFFSET_YN = "BBBBBBBBBB";

    private static final String DEFAULT_FOREX_TAX_YN = "AAAAAAAAAA";
    private static final String UPDATED_FOREX_TAX_YN = "BBBBBBBBBB";

    private static final String DEFAULT_STAMP_DUTY_YN = "AAAAAAAAAA";
    private static final String UPDATED_STAMP_DUTY_YN = "BBBBBBBBBB";

    private static final String DEFAULT_COVERS = "AAAAAAAAAA";
    private static final String UPDATED_COVERS = "BBBBBBBBBB";

    private static final String DEFAULT_ADV_GENERATE_ADJUSTMENT = "AAAAAAAAAA";
    private static final String UPDATED_ADV_GENERATE_ADJUSTMENT = "BBBBBBBBBB";

    private static final String DEFAULT_EXP_INVOICE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_EXP_INVOICE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_FOLIO_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_FOLIO_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ORG_FOLIO_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ORG_FOLIO_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_INVOICE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_INVOICE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_AR_STATE = "AAAAAAAAAA";
    private static final String UPDATED_AR_STATE = "BBBBBBBBBB";

    private static final String DEFAULT_EXCHANGE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_EXCHANGE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_RECPT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_RECPT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_CLASS = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_CLASS = "BBBBBBBBBB";

    private static final String DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_RESORT = "BBBBBBBBBB";

    private static final String DEFAULT_TC_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_TC_GROUP = "BBBBBBBBBB";

    private static final String DEFAULT_TC_SUBGROUP = "AAAAAAAAAA";
    private static final String UPDATED_TC_SUBGROUP = "BBBBBBBBBB";

    private static final String DEFAULT_TRX_CODE = "AAAAAAAAAA";
    private static final String UPDATED_TRX_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM = "AAAAAAAAAA";
    private static final String UPDATED_ROOM = "BBBBBBBBBB";

    private static final String DEFAULT_TCL_CODE_1 = "AAAAAAAAAA";
    private static final String UPDATED_TCL_CODE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENCY = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY = "BBBBBBBBBB";

    private static final String DEFAULT_FT_GENERATED_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_FT_GENERATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_TCL_CODE_2 = "AAAAAAAAAA";
    private static final String UPDATED_TCL_CODE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_MARKET_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MARKET_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_RATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_RATE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_HOTEL_ACCT = "AAAAAAAAAA";
    private static final String UPDATED_HOTEL_ACCT = "BBBBBBBBBB";

    private static final String DEFAULT_REASON_CODE = "AAAAAAAAAA";
    private static final String UPDATED_REASON_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT = "BBBBBBBBBB";

    private static final String DEFAULT_TARGET_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_TARGET_RESORT = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_TAX_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_NAME_TAX_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_TAX_INV_NO = "AAAAAAAAAA";
    private static final String UPDATED_TAX_INV_NO = "BBBBBBBBBB";

    private static final String DEFAULT_APPROVAL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_APPROVAL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_APPROVAL_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_APPROVAL_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_COMP_LINK_TRX_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMP_LINK_TRX_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_COMP_TYPE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COMP_TYPE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_COUPON_NO = "AAAAAAAAAA";
    private static final String UPDATED_COUPON_NO = "BBBBBBBBBB";

    private static final String DEFAULT_ORIGINAL_ROOM = "AAAAAAAAAA";
    private static final String UPDATED_ORIGINAL_ROOM = "BBBBBBBBBB";

    private static final String DEFAULT_ALLOWANCE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ALLOWANCE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ADV_GENERATE_TRX_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ADV_GENERATE_TRX_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_TRX_SERVICE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TRX_SERVICE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_POSTING_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_POSTING_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_PARALLEL_CURRENCY = "AAAAAAAAAA";
    private static final String UPDATED_PARALLEL_CURRENCY = "BBBBBBBBBB";

    private static final String DEFAULT_CONTRACT_CURRENCY = "AAAAAAAAAA";
    private static final String UPDATED_CONTRACT_CURRENCY = "BBBBBBBBBB";

    private static final String DEFAULT_FBA_CERTIFICATE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_FBA_CERTIFICATE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_POSTING_RHYTHM = "AAAAAAAAAA";
    private static final String UPDATED_POSTING_RHYTHM = "BBBBBBBBBB";

    private static final String DEFAULT_ASB_TAX_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_ASB_TAX_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_PACKAGE_ARRANGEMENT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PACKAGE_ARRANGEMENT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_GP_AWARD_CODE = "AAAAAAAAAA";
    private static final String UPDATED_GP_AWARD_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_GP_AWARD_CANCEL_CODE = "AAAAAAAAAA";
    private static final String UPDATED_GP_AWARD_CANCEL_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_RECOVERY_DEPT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_RECOVERY_DEPT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_BUCKET_CODE = "AAAAAAAAAA";
    private static final String UPDATED_BUCKET_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_TAX_RATE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TAX_RATE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CHEQUE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_CHEQUE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_PASSER_BY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PASSER_BY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ESIGNED_RECEIPT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ESIGNED_RECEIPT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_REMARK = "AAAAAAAAAA";
    private static final String UPDATED_REMARK = "BBBBBBBBBB";

    private static final String DEFAULT_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_O_TRX_DESC = "AAAAAAAAAA";
    private static final String UPDATED_O_TRX_DESC = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTS = "BBBBBBBBBB";

    private static final String DEFAULT_FISCAL_BILL_NO = "AAAAAAAAAA";
    private static final String UPDATED_FISCAL_BILL_NO = "BBBBBBBBBB";

    private static final String DEFAULT_EXT_SYS_RESULT_MSG = "AAAAAAAAAA";
    private static final String UPDATED_EXT_SYS_RESULT_MSG = "BBBBBBBBBB";

    private static final String DEFAULT_QUEUE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_QUEUE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PAYMENT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CC_REFUND_POSTING = "AAAAAAAAAA";
    private static final String UPDATED_CC_REFUND_POSTING = "BBBBBBBBBB";

    private static final String DEFAULT_THRESHOLD_ENTITY_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_THRESHOLD_ENTITY_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_THRESHOLD_TREATMENT_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_THRESHOLD_TREATMENT_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_PAYMENT_SURCHARGE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_SURCHARGE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_PROPERTY_BILL_PREFIX = "AAAAAAAAAA";
    private static final String UPDATED_PROPERTY_BILL_PREFIX = "BBBBBBBBBB";

    private static final String DEFAULT_TAX_ELEMENTS = "AAAAAAAAAA";
    private static final String UPDATED_TAX_ELEMENTS = "BBBBBBBBBB";

    private static final String DEFAULT_NUMBER_DIALED = "AAAAAAAAAA";
    private static final String UPDATED_NUMBER_DIALED = "BBBBBBBBBB";

    private static final String DEFAULT_CHECK_FILE_ID = "AAAAAAAAAA";
    private static final String UPDATED_CHECK_FILE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_EXT_TRX_ID = "AAAAAAAAAA";
    private static final String UPDATED_EXT_TRX_ID = "BBBBBBBBBB";

    private static final String DEFAULT_PACKAGE_TRX_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PACKAGE_TRX_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_EXP_ORIGINAL_INVOICE = "AAAAAAAAAA";
    private static final String UPDATED_EXP_ORIGINAL_INVOICE = "BBBBBBBBBB";

    private static final String DEFAULT_DEPOSIT_TRANSACTION_ID = "AAAAAAAAAA";
    private static final String UPDATED_DEPOSIT_TRANSACTION_ID = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/financial-transactions";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private FinancialTransactionsRepository financialTransactionsRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFinancialTransactionsMockMvc;

    private FinancialTransactions financialTransactions;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FinancialTransactions createEntity(EntityManager em) {
        FinancialTransactions financialTransactions = new FinancialTransactions()
            .trxNo(DEFAULT_TRX_NO)
            .ftSubtype(DEFAULT_FT_SUBTYPE)
            .invoiceCloseDate(DEFAULT_INVOICE_CLOSE_DATE)
            .arTransferDate(DEFAULT_AR_TRANSFER_DATE)
            .trxDate(DEFAULT_TRX_DATE)
            .businessDate(DEFAULT_BUSINESS_DATE)
            .insertDate(DEFAULT_INSERT_DATE)
            .updateDate(DEFAULT_UPDATE_DATE)
            .trnsActivityDate(DEFAULT_TRNS_ACTIVITY_DATE)
            .approvalDate(DEFAULT_APPROVAL_DATE)
            .postingDate(DEFAULT_POSTING_DATE)
            .exchangeDate(DEFAULT_EXCHANGE_DATE)
            .routingDate(DEFAULT_ROUTING_DATE)
            .effectiveDate(DEFAULT_EFFECTIVE_DATE)
            .customChargeDate(DEFAULT_CUSTOM_CHARGE_DATE)
            .recptNo(DEFAULT_RECPT_NO)
            .trxNoAdjust(DEFAULT_TRX_NO_ADJUST)
            .trxNoAddedBy(DEFAULT_TRX_NO_ADDED_BY)
            .trxNoAgainstPackage(DEFAULT_TRX_NO_AGAINST_PACKAGE)
            .trxNoHeader(DEFAULT_TRX_NO_HEADER)
            .arNumber(DEFAULT_AR_NUMBER)
            .resvNameId(DEFAULT_RESV_NAME_ID)
            .cashierId(DEFAULT_CASHIER_ID)
            .creditCardId(DEFAULT_CREDIT_CARD_ID)
            .nameId(DEFAULT_NAME_ID)
            .tranActionId(DEFAULT_TRAN_ACTION_ID)
            .finDmlSeqNo(DEFAULT_FIN_DML_SEQ_NO)
            .routingInstrnId(DEFAULT_ROUTING_INSTRN_ID)
            .fromResvId(DEFAULT_FROM_RESV_ID)
            .genCashierId(DEFAULT_GEN_CASHIER_ID)
            .folioNo(DEFAULT_FOLIO_NO)
            .invoiceNo(DEFAULT_INVOICE_NO)
            .insertUser(DEFAULT_INSERT_USER)
            .updateUser(DEFAULT_UPDATE_USER)
            .arrangementId(DEFAULT_ARRANGEMENT_ID)
            .trnsFromAcct(DEFAULT_TRNS_FROM_ACCT)
            .trnsToAcct(DEFAULT_TRNS_TO_ACCT)
            .billNo(DEFAULT_BILL_NO)
            .revisionNo(DEFAULT_REVISION_NO)
            .resvDepositId(DEFAULT_RESV_DEPOSIT_ID)
            .linkTrxNo(DEFAULT_LINK_TRX_NO)
            .authorizerId(DEFAULT_AUTHORIZER_ID)
            .compLinkTrxNo(DEFAULT_COMP_LINK_TRX_NO)
            .mtrxNoAgainstPackage(DEFAULT_MTRX_NO_AGAINST_PACKAGE)
            .forexCommPerc(DEFAULT_FOREX_COMM_PERC)
            .forexCommAmount(DEFAULT_FOREX_COMM_AMOUNT)
            .articleId(DEFAULT_ARTICLE_ID)
            .toResvNameId(DEFAULT_TO_RESV_NAME_ID)
            .roomNts(DEFAULT_ROOM_NTS)
            .orgArLedDebit(DEFAULT_ORG_AR_LED_DEBIT)
            .closureNo(DEFAULT_CLOSURE_NO)
            .originalResvNameId(DEFAULT_ORIGINAL_RESV_NAME_ID)
            .orgBillNo(DEFAULT_ORG_BILL_NO)
            .membershipId(DEFAULT_MEMBERSHIP_ID)
            .installments(DEFAULT_INSTALLMENTS)
            .contractGuestDebit(DEFAULT_CONTRACT_GUEST_DEBIT)
            .contractGuestCredit(DEFAULT_CONTRACT_GUEST_CREDIT)
            .contractNetAmount(DEFAULT_CONTRACT_NET_AMOUNT)
            .contractGrossAmount(DEFAULT_CONTRACT_GROSS_AMOUNT)
            .postitNo(DEFAULT_POSTIT_NO)
            .ccTrxFeeAmount(DEFAULT_CC_TRX_FEE_AMOUNT)
            .changeDue(DEFAULT_CHANGE_DUE)
            .postingSourceNameId(DEFAULT_POSTING_SOURCE_NAME_ID)
            .bonusCheckId(DEFAULT_BONUS_CHECK_ID)
            .roundLinkTrxno(DEFAULT_ROUND_LINK_TRXNO)
            .reversePaymentTrxNo(DEFAULT_REVERSE_PAYMENT_TRX_NO)
            .electronicVoucherNo(DEFAULT_ELECTRONIC_VOUCHER_NO)
            .thresholdDiversionId(DEFAULT_THRESHOLD_DIVERSION_ID)
            .thresholdEntityQty(DEFAULT_THRESHOLD_ENTITY_QTY)
            .trxNoSplit(DEFAULT_TRX_NO_SPLIT)
            .exchDiffTrxNo(DEFAULT_EXCH_DIFF_TRX_NO)
            .associatedTrxNo(DEFAULT_ASSOCIATED_TRX_NO)
            .taxRate(DEFAULT_TAX_RATE)
            .propChargeId(DEFAULT_PROP_CHARGE_ID)
            .quantity(DEFAULT_QUANTITY)
            .netAmount(DEFAULT_NET_AMOUNT)
            .grossAmount(DEFAULT_GROSS_AMOUNT)
            .cashierOpeningBalance(DEFAULT_CASHIER_OPENING_BALANCE)
            .pricePerUnit(DEFAULT_PRICE_PER_UNIT)
            .trxAmount(DEFAULT_TRX_AMOUNT)
            .postedAmount(DEFAULT_POSTED_AMOUNT)
            .guestAccountCredit(DEFAULT_GUEST_ACCOUNT_CREDIT)
            .exchangeRate(DEFAULT_EXCHANGE_RATE)
            .guestAccountDebit(DEFAULT_GUEST_ACCOUNT_DEBIT)
            .cashierCredit(DEFAULT_CASHIER_CREDIT)
            .cashierDebit(DEFAULT_CASHIER_DEBIT)
            .packageCredit(DEFAULT_PACKAGE_CREDIT)
            .packageDebit(DEFAULT_PACKAGE_DEBIT)
            .depLedCredit(DEFAULT_DEP_LED_CREDIT)
            .depLedDebit(DEFAULT_DEP_LED_DEBIT)
            .revenueAmt(DEFAULT_REVENUE_AMT)
            .arLedCredit(DEFAULT_AR_LED_CREDIT)
            .arLedDebit(DEFAULT_AR_LED_DEBIT)
            .euroExchangeRate(DEFAULT_EURO_EXCHANGE_RATE)
            .inhDebit(DEFAULT_INH_DEBIT)
            .inhCredit(DEFAULT_INH_CREDIT)
            .packageAllowance(DEFAULT_PACKAGE_ALLOWANCE)
            .parallelGuestCredit(DEFAULT_PARALLEL_GUEST_CREDIT)
            .parallelGuestDebit(DEFAULT_PARALLEL_GUEST_DEBIT)
            .parallelNetAmount(DEFAULT_PARALLEL_NET_AMOUNT)
            .parallelGrossAmount(DEFAULT_PARALLEL_GROSS_AMOUNT)
            .orgPostedAmount(DEFAULT_ORG_POSTED_AMOUNT)
            .roomNtsEffective(DEFAULT_ROOM_NTS_EFFECTIVE)
            .paymentSurchargeAmt(DEFAULT_PAYMENT_SURCHARGE_AMT)
            .folioView(DEFAULT_FOLIO_VIEW)
            .taxInclusiveYn(DEFAULT_TAX_INCLUSIVE_YN)
            .deferredYn(DEFAULT_DEFERRED_YN)
            .indAdjustmentYn(DEFAULT_IND_ADJUSTMENT_YN)
            .fixedChargesYn(DEFAULT_FIXED_CHARGES_YN)
            .taCommissionableYn(DEFAULT_TA_COMMISSIONABLE_YN)
            .taxGeneratedYn(DEFAULT_TAX_GENERATED_YN)
            .compressedYn(DEFAULT_COMPRESSED_YN)
            .displayYn(DEFAULT_DISPLAY_YN)
            .collAgentPostingYn(DEFAULT_COLL_AGENT_POSTING_YN)
            .fiscalTrxCodeType(DEFAULT_FISCAL_TRX_CODE_TYPE)
            .deferredTaxesYn(DEFAULT_DEFERRED_TAXES_YN)
            .advancedGenerateYn(DEFAULT_ADVANCED_GENERATE_YN)
            .forexType(DEFAULT_FOREX_TYPE)
            .taCommissionNetYn(DEFAULT_TA_COMMISSION_NET_YN)
            .sourceCommissionNetYn(DEFAULT_SOURCE_COMMISSION_NET_YN)
            .settlementFlag(DEFAULT_SETTLEMENT_FLAG)
            .accTypeFlag(DEFAULT_ACC_TYPE_FLAG)
            .profitLossFlag(DEFAULT_PROFIT_LOSS_FLAG)
            .proformaYn(DEFAULT_PROFORMA_YN)
            .holdYn(DEFAULT_HOLD_YN)
            .exchangeDifferenceYn(DEFAULT_EXCHANGE_DIFFERENCE_YN)
            .calcPointsYn(DEFAULT_CALC_POINTS_YN)
            .arChargeTransferYn(DEFAULT_AR_CHARGE_TRANSFER_YN)
            .processed8300Yn(DEFAULT_PROCESSED_8300_YN)
            .asbFlag(DEFAULT_ASB_FLAG)
            .postitYn(DEFAULT_POSTIT_YN)
            .autoSettleYn(DEFAULT_AUTO_SETTLE_YN)
            .depTaxTransferedYn(DEFAULT_DEP_TAX_TRANSFERED_YN)
            .autoCreditbillYn(DEFAULT_AUTO_CREDITBILL_YN)
            .asbOnlyPostTaxesOnceYn(DEFAULT_ASB_ONLY_POST_TAXES_ONCE_YN)
            .roundFactorYn(DEFAULT_ROUND_FACTOR_YN)
            .depPostingFlag(DEFAULT_DEP_POSTING_FLAG)
            .correctionYn(DEFAULT_CORRECTION_YN)
            .routedYn(DEFAULT_ROUTED_YN)
            .upsellChargeYn(DEFAULT_UPSELL_CHARGE_YN)
            .advanceBillYn(DEFAULT_ADVANCE_BILL_YN)
            .advanceBillReversedYn(DEFAULT_ADVANCE_BILL_REVERSED_YN)
            .incTaxDeductedYn(DEFAULT_INC_TAX_DEDUCTED_YN)
            .gpAwardCancelledYn(DEFAULT_GP_AWARD_CANCELLED_YN)
            .serviceRecoveryAdjustmentYn(DEFAULT_SERVICE_RECOVERY_ADJUSTMENT_YN)
            .splitType(DEFAULT_SPLIT_TYPE)
            .bucketRedempYn(DEFAULT_BUCKET_REDEMP_YN)
            .vatOffsetYn(DEFAULT_VAT_OFFSET_YN)
            .forexTaxYn(DEFAULT_FOREX_TAX_YN)
            .stampDutyYn(DEFAULT_STAMP_DUTY_YN)
            .covers(DEFAULT_COVERS)
            .advGenerateAdjustment(DEFAULT_ADV_GENERATE_ADJUSTMENT)
            .expInvoiceType(DEFAULT_EXP_INVOICE_TYPE)
            .folioType(DEFAULT_FOLIO_TYPE)
            .orgFolioType(DEFAULT_ORG_FOLIO_TYPE)
            .invoiceType(DEFAULT_INVOICE_TYPE)
            .arState(DEFAULT_AR_STATE)
            .exchangeType(DEFAULT_EXCHANGE_TYPE)
            .recptType(DEFAULT_RECPT_TYPE)
            .roomClass(DEFAULT_ROOM_CLASS)
            .resort(DEFAULT_RESORT)
            .tcGroup(DEFAULT_TC_GROUP)
            .tcSubgroup(DEFAULT_TC_SUBGROUP)
            .trxCode(DEFAULT_TRX_CODE)
            .room(DEFAULT_ROOM)
            .tclCode1(DEFAULT_TCL_CODE_1)
            .currency(DEFAULT_CURRENCY)
            .ftGeneratedType(DEFAULT_FT_GENERATED_TYPE)
            .tclCode2(DEFAULT_TCL_CODE_2)
            .marketCode(DEFAULT_MARKET_CODE)
            .sourceCode(DEFAULT_SOURCE_CODE)
            .rateCode(DEFAULT_RATE_CODE)
            .hotelAcct(DEFAULT_HOTEL_ACCT)
            .reasonCode(DEFAULT_REASON_CODE)
            .product(DEFAULT_PRODUCT)
            .targetResort(DEFAULT_TARGET_RESORT)
            .nameTaxType(DEFAULT_NAME_TAX_TYPE)
            .taxInvNo(DEFAULT_TAX_INV_NO)
            .approvalCode(DEFAULT_APPROVAL_CODE)
            .approvalStatus(DEFAULT_APPROVAL_STATUS)
            .compLinkTrxCode(DEFAULT_COMP_LINK_TRX_CODE)
            .compTypeCode(DEFAULT_COMP_TYPE_CODE)
            .couponNo(DEFAULT_COUPON_NO)
            .originalRoom(DEFAULT_ORIGINAL_ROOM)
            .allowanceType(DEFAULT_ALLOWANCE_TYPE)
            .advGenerateTrxCode(DEFAULT_ADV_GENERATE_TRX_CODE)
            .trxServiceType(DEFAULT_TRX_SERVICE_TYPE)
            .postingType(DEFAULT_POSTING_TYPE)
            .parallelCurrency(DEFAULT_PARALLEL_CURRENCY)
            .contractCurrency(DEFAULT_CONTRACT_CURRENCY)
            .fbaCertificateNumber(DEFAULT_FBA_CERTIFICATE_NUMBER)
            .postingRhythm(DEFAULT_POSTING_RHYTHM)
            .asbTaxFlag(DEFAULT_ASB_TAX_FLAG)
            .packageArrangementCode(DEFAULT_PACKAGE_ARRANGEMENT_CODE)
            .gpAwardCode(DEFAULT_GP_AWARD_CODE)
            .gpAwardCancelCode(DEFAULT_GP_AWARD_CANCEL_CODE)
            .serviceRecoveryDeptCode(DEFAULT_SERVICE_RECOVERY_DEPT_CODE)
            .bucketCode(DEFAULT_BUCKET_CODE)
            .taxRateType(DEFAULT_TAX_RATE_TYPE)
            .chequeNumber(DEFAULT_CHEQUE_NUMBER)
            .passerByName(DEFAULT_PASSER_BY_NAME)
            .esignedReceiptName(DEFAULT_ESIGNED_RECEIPT_NAME)
            .remark(DEFAULT_REMARK)
            .reference(DEFAULT_REFERENCE)
            .oTrxDesc(DEFAULT_O_TRX_DESC)
            .comments(DEFAULT_COMMENTS)
            .fiscalBillNo(DEFAULT_FISCAL_BILL_NO)
            .extSysResultMsg(DEFAULT_EXT_SYS_RESULT_MSG)
            .queueName(DEFAULT_QUEUE_NAME)
            .paymentType(DEFAULT_PAYMENT_TYPE)
            .ccRefundPosting(DEFAULT_CC_REFUND_POSTING)
            .thresholdEntityType(DEFAULT_THRESHOLD_ENTITY_TYPE)
            .thresholdTreatmentFlag(DEFAULT_THRESHOLD_TREATMENT_FLAG)
            .paymentSurchargeType(DEFAULT_PAYMENT_SURCHARGE_TYPE)
            .propertyBillPrefix(DEFAULT_PROPERTY_BILL_PREFIX)
            .taxElements(DEFAULT_TAX_ELEMENTS)
            .numberDialed(DEFAULT_NUMBER_DIALED)
            .checkFileId(DEFAULT_CHECK_FILE_ID)
            .extTrxId(DEFAULT_EXT_TRX_ID)
            .packageTrxType(DEFAULT_PACKAGE_TRX_TYPE)
            .expOriginalInvoice(DEFAULT_EXP_ORIGINAL_INVOICE)
            .depositTransactionId(DEFAULT_DEPOSIT_TRANSACTION_ID);
        return financialTransactions;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FinancialTransactions createUpdatedEntity(EntityManager em) {
        FinancialTransactions financialTransactions = new FinancialTransactions()
            .trxNo(UPDATED_TRX_NO)
            .ftSubtype(UPDATED_FT_SUBTYPE)
            .invoiceCloseDate(UPDATED_INVOICE_CLOSE_DATE)
            .arTransferDate(UPDATED_AR_TRANSFER_DATE)
            .trxDate(UPDATED_TRX_DATE)
            .businessDate(UPDATED_BUSINESS_DATE)
            .insertDate(UPDATED_INSERT_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .trnsActivityDate(UPDATED_TRNS_ACTIVITY_DATE)
            .approvalDate(UPDATED_APPROVAL_DATE)
            .postingDate(UPDATED_POSTING_DATE)
            .exchangeDate(UPDATED_EXCHANGE_DATE)
            .routingDate(UPDATED_ROUTING_DATE)
            .effectiveDate(UPDATED_EFFECTIVE_DATE)
            .customChargeDate(UPDATED_CUSTOM_CHARGE_DATE)
            .recptNo(UPDATED_RECPT_NO)
            .trxNoAdjust(UPDATED_TRX_NO_ADJUST)
            .trxNoAddedBy(UPDATED_TRX_NO_ADDED_BY)
            .trxNoAgainstPackage(UPDATED_TRX_NO_AGAINST_PACKAGE)
            .trxNoHeader(UPDATED_TRX_NO_HEADER)
            .arNumber(UPDATED_AR_NUMBER)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .cashierId(UPDATED_CASHIER_ID)
            .creditCardId(UPDATED_CREDIT_CARD_ID)
            .nameId(UPDATED_NAME_ID)
            .tranActionId(UPDATED_TRAN_ACTION_ID)
            .finDmlSeqNo(UPDATED_FIN_DML_SEQ_NO)
            .routingInstrnId(UPDATED_ROUTING_INSTRN_ID)
            .fromResvId(UPDATED_FROM_RESV_ID)
            .genCashierId(UPDATED_GEN_CASHIER_ID)
            .folioNo(UPDATED_FOLIO_NO)
            .invoiceNo(UPDATED_INVOICE_NO)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .arrangementId(UPDATED_ARRANGEMENT_ID)
            .trnsFromAcct(UPDATED_TRNS_FROM_ACCT)
            .trnsToAcct(UPDATED_TRNS_TO_ACCT)
            .billNo(UPDATED_BILL_NO)
            .revisionNo(UPDATED_REVISION_NO)
            .resvDepositId(UPDATED_RESV_DEPOSIT_ID)
            .linkTrxNo(UPDATED_LINK_TRX_NO)
            .authorizerId(UPDATED_AUTHORIZER_ID)
            .compLinkTrxNo(UPDATED_COMP_LINK_TRX_NO)
            .mtrxNoAgainstPackage(UPDATED_MTRX_NO_AGAINST_PACKAGE)
            .forexCommPerc(UPDATED_FOREX_COMM_PERC)
            .forexCommAmount(UPDATED_FOREX_COMM_AMOUNT)
            .articleId(UPDATED_ARTICLE_ID)
            .toResvNameId(UPDATED_TO_RESV_NAME_ID)
            .roomNts(UPDATED_ROOM_NTS)
            .orgArLedDebit(UPDATED_ORG_AR_LED_DEBIT)
            .closureNo(UPDATED_CLOSURE_NO)
            .originalResvNameId(UPDATED_ORIGINAL_RESV_NAME_ID)
            .orgBillNo(UPDATED_ORG_BILL_NO)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .installments(UPDATED_INSTALLMENTS)
            .contractGuestDebit(UPDATED_CONTRACT_GUEST_DEBIT)
            .contractGuestCredit(UPDATED_CONTRACT_GUEST_CREDIT)
            .contractNetAmount(UPDATED_CONTRACT_NET_AMOUNT)
            .contractGrossAmount(UPDATED_CONTRACT_GROSS_AMOUNT)
            .postitNo(UPDATED_POSTIT_NO)
            .ccTrxFeeAmount(UPDATED_CC_TRX_FEE_AMOUNT)
            .changeDue(UPDATED_CHANGE_DUE)
            .postingSourceNameId(UPDATED_POSTING_SOURCE_NAME_ID)
            .bonusCheckId(UPDATED_BONUS_CHECK_ID)
            .roundLinkTrxno(UPDATED_ROUND_LINK_TRXNO)
            .reversePaymentTrxNo(UPDATED_REVERSE_PAYMENT_TRX_NO)
            .electronicVoucherNo(UPDATED_ELECTRONIC_VOUCHER_NO)
            .thresholdDiversionId(UPDATED_THRESHOLD_DIVERSION_ID)
            .thresholdEntityQty(UPDATED_THRESHOLD_ENTITY_QTY)
            .trxNoSplit(UPDATED_TRX_NO_SPLIT)
            .exchDiffTrxNo(UPDATED_EXCH_DIFF_TRX_NO)
            .associatedTrxNo(UPDATED_ASSOCIATED_TRX_NO)
            .taxRate(UPDATED_TAX_RATE)
            .propChargeId(UPDATED_PROP_CHARGE_ID)
            .quantity(UPDATED_QUANTITY)
            .netAmount(UPDATED_NET_AMOUNT)
            .grossAmount(UPDATED_GROSS_AMOUNT)
            .cashierOpeningBalance(UPDATED_CASHIER_OPENING_BALANCE)
            .pricePerUnit(UPDATED_PRICE_PER_UNIT)
            .trxAmount(UPDATED_TRX_AMOUNT)
            .postedAmount(UPDATED_POSTED_AMOUNT)
            .guestAccountCredit(UPDATED_GUEST_ACCOUNT_CREDIT)
            .exchangeRate(UPDATED_EXCHANGE_RATE)
            .guestAccountDebit(UPDATED_GUEST_ACCOUNT_DEBIT)
            .cashierCredit(UPDATED_CASHIER_CREDIT)
            .cashierDebit(UPDATED_CASHIER_DEBIT)
            .packageCredit(UPDATED_PACKAGE_CREDIT)
            .packageDebit(UPDATED_PACKAGE_DEBIT)
            .depLedCredit(UPDATED_DEP_LED_CREDIT)
            .depLedDebit(UPDATED_DEP_LED_DEBIT)
            .revenueAmt(UPDATED_REVENUE_AMT)
            .arLedCredit(UPDATED_AR_LED_CREDIT)
            .arLedDebit(UPDATED_AR_LED_DEBIT)
            .euroExchangeRate(UPDATED_EURO_EXCHANGE_RATE)
            .inhDebit(UPDATED_INH_DEBIT)
            .inhCredit(UPDATED_INH_CREDIT)
            .packageAllowance(UPDATED_PACKAGE_ALLOWANCE)
            .parallelGuestCredit(UPDATED_PARALLEL_GUEST_CREDIT)
            .parallelGuestDebit(UPDATED_PARALLEL_GUEST_DEBIT)
            .parallelNetAmount(UPDATED_PARALLEL_NET_AMOUNT)
            .parallelGrossAmount(UPDATED_PARALLEL_GROSS_AMOUNT)
            .orgPostedAmount(UPDATED_ORG_POSTED_AMOUNT)
            .roomNtsEffective(UPDATED_ROOM_NTS_EFFECTIVE)
            .paymentSurchargeAmt(UPDATED_PAYMENT_SURCHARGE_AMT)
            .folioView(UPDATED_FOLIO_VIEW)
            .taxInclusiveYn(UPDATED_TAX_INCLUSIVE_YN)
            .deferredYn(UPDATED_DEFERRED_YN)
            .indAdjustmentYn(UPDATED_IND_ADJUSTMENT_YN)
            .fixedChargesYn(UPDATED_FIXED_CHARGES_YN)
            .taCommissionableYn(UPDATED_TA_COMMISSIONABLE_YN)
            .taxGeneratedYn(UPDATED_TAX_GENERATED_YN)
            .compressedYn(UPDATED_COMPRESSED_YN)
            .displayYn(UPDATED_DISPLAY_YN)
            .collAgentPostingYn(UPDATED_COLL_AGENT_POSTING_YN)
            .fiscalTrxCodeType(UPDATED_FISCAL_TRX_CODE_TYPE)
            .deferredTaxesYn(UPDATED_DEFERRED_TAXES_YN)
            .advancedGenerateYn(UPDATED_ADVANCED_GENERATE_YN)
            .forexType(UPDATED_FOREX_TYPE)
            .taCommissionNetYn(UPDATED_TA_COMMISSION_NET_YN)
            .sourceCommissionNetYn(UPDATED_SOURCE_COMMISSION_NET_YN)
            .settlementFlag(UPDATED_SETTLEMENT_FLAG)
            .accTypeFlag(UPDATED_ACC_TYPE_FLAG)
            .profitLossFlag(UPDATED_PROFIT_LOSS_FLAG)
            .proformaYn(UPDATED_PROFORMA_YN)
            .holdYn(UPDATED_HOLD_YN)
            .exchangeDifferenceYn(UPDATED_EXCHANGE_DIFFERENCE_YN)
            .calcPointsYn(UPDATED_CALC_POINTS_YN)
            .arChargeTransferYn(UPDATED_AR_CHARGE_TRANSFER_YN)
            .processed8300Yn(UPDATED_PROCESSED_8300_YN)
            .asbFlag(UPDATED_ASB_FLAG)
            .postitYn(UPDATED_POSTIT_YN)
            .autoSettleYn(UPDATED_AUTO_SETTLE_YN)
            .depTaxTransferedYn(UPDATED_DEP_TAX_TRANSFERED_YN)
            .autoCreditbillYn(UPDATED_AUTO_CREDITBILL_YN)
            .asbOnlyPostTaxesOnceYn(UPDATED_ASB_ONLY_POST_TAXES_ONCE_YN)
            .roundFactorYn(UPDATED_ROUND_FACTOR_YN)
            .depPostingFlag(UPDATED_DEP_POSTING_FLAG)
            .correctionYn(UPDATED_CORRECTION_YN)
            .routedYn(UPDATED_ROUTED_YN)
            .upsellChargeYn(UPDATED_UPSELL_CHARGE_YN)
            .advanceBillYn(UPDATED_ADVANCE_BILL_YN)
            .advanceBillReversedYn(UPDATED_ADVANCE_BILL_REVERSED_YN)
            .incTaxDeductedYn(UPDATED_INC_TAX_DEDUCTED_YN)
            .gpAwardCancelledYn(UPDATED_GP_AWARD_CANCELLED_YN)
            .serviceRecoveryAdjustmentYn(UPDATED_SERVICE_RECOVERY_ADJUSTMENT_YN)
            .splitType(UPDATED_SPLIT_TYPE)
            .bucketRedempYn(UPDATED_BUCKET_REDEMP_YN)
            .vatOffsetYn(UPDATED_VAT_OFFSET_YN)
            .forexTaxYn(UPDATED_FOREX_TAX_YN)
            .stampDutyYn(UPDATED_STAMP_DUTY_YN)
            .covers(UPDATED_COVERS)
            .advGenerateAdjustment(UPDATED_ADV_GENERATE_ADJUSTMENT)
            .expInvoiceType(UPDATED_EXP_INVOICE_TYPE)
            .folioType(UPDATED_FOLIO_TYPE)
            .orgFolioType(UPDATED_ORG_FOLIO_TYPE)
            .invoiceType(UPDATED_INVOICE_TYPE)
            .arState(UPDATED_AR_STATE)
            .exchangeType(UPDATED_EXCHANGE_TYPE)
            .recptType(UPDATED_RECPT_TYPE)
            .roomClass(UPDATED_ROOM_CLASS)
            .resort(UPDATED_RESORT)
            .tcGroup(UPDATED_TC_GROUP)
            .tcSubgroup(UPDATED_TC_SUBGROUP)
            .trxCode(UPDATED_TRX_CODE)
            .room(UPDATED_ROOM)
            .tclCode1(UPDATED_TCL_CODE_1)
            .currency(UPDATED_CURRENCY)
            .ftGeneratedType(UPDATED_FT_GENERATED_TYPE)
            .tclCode2(UPDATED_TCL_CODE_2)
            .marketCode(UPDATED_MARKET_CODE)
            .sourceCode(UPDATED_SOURCE_CODE)
            .rateCode(UPDATED_RATE_CODE)
            .hotelAcct(UPDATED_HOTEL_ACCT)
            .reasonCode(UPDATED_REASON_CODE)
            .product(UPDATED_PRODUCT)
            .targetResort(UPDATED_TARGET_RESORT)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .taxInvNo(UPDATED_TAX_INV_NO)
            .approvalCode(UPDATED_APPROVAL_CODE)
            .approvalStatus(UPDATED_APPROVAL_STATUS)
            .compLinkTrxCode(UPDATED_COMP_LINK_TRX_CODE)
            .compTypeCode(UPDATED_COMP_TYPE_CODE)
            .couponNo(UPDATED_COUPON_NO)
            .originalRoom(UPDATED_ORIGINAL_ROOM)
            .allowanceType(UPDATED_ALLOWANCE_TYPE)
            .advGenerateTrxCode(UPDATED_ADV_GENERATE_TRX_CODE)
            .trxServiceType(UPDATED_TRX_SERVICE_TYPE)
            .postingType(UPDATED_POSTING_TYPE)
            .parallelCurrency(UPDATED_PARALLEL_CURRENCY)
            .contractCurrency(UPDATED_CONTRACT_CURRENCY)
            .fbaCertificateNumber(UPDATED_FBA_CERTIFICATE_NUMBER)
            .postingRhythm(UPDATED_POSTING_RHYTHM)
            .asbTaxFlag(UPDATED_ASB_TAX_FLAG)
            .packageArrangementCode(UPDATED_PACKAGE_ARRANGEMENT_CODE)
            .gpAwardCode(UPDATED_GP_AWARD_CODE)
            .gpAwardCancelCode(UPDATED_GP_AWARD_CANCEL_CODE)
            .serviceRecoveryDeptCode(UPDATED_SERVICE_RECOVERY_DEPT_CODE)
            .bucketCode(UPDATED_BUCKET_CODE)
            .taxRateType(UPDATED_TAX_RATE_TYPE)
            .chequeNumber(UPDATED_CHEQUE_NUMBER)
            .passerByName(UPDATED_PASSER_BY_NAME)
            .esignedReceiptName(UPDATED_ESIGNED_RECEIPT_NAME)
            .remark(UPDATED_REMARK)
            .reference(UPDATED_REFERENCE)
            .oTrxDesc(UPDATED_O_TRX_DESC)
            .comments(UPDATED_COMMENTS)
            .fiscalBillNo(UPDATED_FISCAL_BILL_NO)
            .extSysResultMsg(UPDATED_EXT_SYS_RESULT_MSG)
            .queueName(UPDATED_QUEUE_NAME)
            .paymentType(UPDATED_PAYMENT_TYPE)
            .ccRefundPosting(UPDATED_CC_REFUND_POSTING)
            .thresholdEntityType(UPDATED_THRESHOLD_ENTITY_TYPE)
            .thresholdTreatmentFlag(UPDATED_THRESHOLD_TREATMENT_FLAG)
            .paymentSurchargeType(UPDATED_PAYMENT_SURCHARGE_TYPE)
            .propertyBillPrefix(UPDATED_PROPERTY_BILL_PREFIX)
            .taxElements(UPDATED_TAX_ELEMENTS)
            .numberDialed(UPDATED_NUMBER_DIALED)
            .checkFileId(UPDATED_CHECK_FILE_ID)
            .extTrxId(UPDATED_EXT_TRX_ID)
            .packageTrxType(UPDATED_PACKAGE_TRX_TYPE)
            .expOriginalInvoice(UPDATED_EXP_ORIGINAL_INVOICE)
            .depositTransactionId(UPDATED_DEPOSIT_TRANSACTION_ID);
        return financialTransactions;
    }

    @BeforeEach
    public void initTest() {
        financialTransactions = createEntity(em);
    }

    @Test
    @Transactional
    void createFinancialTransactions() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the FinancialTransactions
        var returnedFinancialTransactions = om.readValue(
            restFinancialTransactionsMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(financialTransactions)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            FinancialTransactions.class
        );

        // Validate the FinancialTransactions in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertFinancialTransactionsUpdatableFieldsEquals(
            returnedFinancialTransactions,
            getPersistedFinancialTransactions(returnedFinancialTransactions)
        );
    }

    @Test
    @Transactional
    void createFinancialTransactionsWithExistingId() throws Exception {
        // Create the FinancialTransactions with an existing ID
        financialTransactions.setId(1);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restFinancialTransactionsMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(financialTransactions)))
            .andExpect(status().isBadRequest());

        // Validate the FinancialTransactions in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllFinancialTransactions() throws Exception {
        // Initialize the database
        financialTransactionsRepository.saveAndFlush(financialTransactions);

        // Get all the financialTransactionsList
        restFinancialTransactionsMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(financialTransactions.getId().intValue())))
            .andExpect(jsonPath("$.[*].trxNo").value(hasItem(DEFAULT_TRX_NO)))
            .andExpect(jsonPath("$.[*].ftSubtype").value(hasItem(DEFAULT_FT_SUBTYPE)))
            .andExpect(jsonPath("$.[*].invoiceCloseDate").value(hasItem(DEFAULT_INVOICE_CLOSE_DATE.toString())))
            .andExpect(jsonPath("$.[*].arTransferDate").value(hasItem(DEFAULT_AR_TRANSFER_DATE.toString())))
            .andExpect(jsonPath("$.[*].trxDate").value(hasItem(DEFAULT_TRX_DATE.toString())))
            .andExpect(jsonPath("$.[*].businessDate").value(hasItem(DEFAULT_BUSINESS_DATE.toString())))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].trnsActivityDate").value(hasItem(DEFAULT_TRNS_ACTIVITY_DATE.toString())))
            .andExpect(jsonPath("$.[*].approvalDate").value(hasItem(DEFAULT_APPROVAL_DATE.toString())))
            .andExpect(jsonPath("$.[*].postingDate").value(hasItem(DEFAULT_POSTING_DATE.toString())))
            .andExpect(jsonPath("$.[*].exchangeDate").value(hasItem(DEFAULT_EXCHANGE_DATE.toString())))
            .andExpect(jsonPath("$.[*].routingDate").value(hasItem(DEFAULT_ROUTING_DATE.toString())))
            .andExpect(jsonPath("$.[*].effectiveDate").value(hasItem(DEFAULT_EFFECTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].customChargeDate").value(hasItem(DEFAULT_CUSTOM_CHARGE_DATE.toString())))
            .andExpect(jsonPath("$.[*].recptNo").value(hasItem(DEFAULT_RECPT_NO)))
            .andExpect(jsonPath("$.[*].trxNoAdjust").value(hasItem(DEFAULT_TRX_NO_ADJUST)))
            .andExpect(jsonPath("$.[*].trxNoAddedBy").value(hasItem(DEFAULT_TRX_NO_ADDED_BY)))
            .andExpect(jsonPath("$.[*].trxNoAgainstPackage").value(hasItem(DEFAULT_TRX_NO_AGAINST_PACKAGE)))
            .andExpect(jsonPath("$.[*].trxNoHeader").value(hasItem(DEFAULT_TRX_NO_HEADER)))
            .andExpect(jsonPath("$.[*].arNumber").value(hasItem(DEFAULT_AR_NUMBER)))
            .andExpect(jsonPath("$.[*].resvNameId").value(hasItem(DEFAULT_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].cashierId").value(hasItem(DEFAULT_CASHIER_ID)))
            .andExpect(jsonPath("$.[*].creditCardId").value(hasItem(DEFAULT_CREDIT_CARD_ID)))
            .andExpect(jsonPath("$.[*].nameId").value(hasItem(DEFAULT_NAME_ID)))
            .andExpect(jsonPath("$.[*].tranActionId").value(hasItem(DEFAULT_TRAN_ACTION_ID)))
            .andExpect(jsonPath("$.[*].finDmlSeqNo").value(hasItem(DEFAULT_FIN_DML_SEQ_NO)))
            .andExpect(jsonPath("$.[*].routingInstrnId").value(hasItem(DEFAULT_ROUTING_INSTRN_ID)))
            .andExpect(jsonPath("$.[*].fromResvId").value(hasItem(DEFAULT_FROM_RESV_ID)))
            .andExpect(jsonPath("$.[*].genCashierId").value(hasItem(DEFAULT_GEN_CASHIER_ID)))
            .andExpect(jsonPath("$.[*].folioNo").value(hasItem(DEFAULT_FOLIO_NO)))
            .andExpect(jsonPath("$.[*].invoiceNo").value(hasItem(DEFAULT_INVOICE_NO)))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].arrangementId").value(hasItem(DEFAULT_ARRANGEMENT_ID)))
            .andExpect(jsonPath("$.[*].trnsFromAcct").value(hasItem(DEFAULT_TRNS_FROM_ACCT)))
            .andExpect(jsonPath("$.[*].trnsToAcct").value(hasItem(DEFAULT_TRNS_TO_ACCT)))
            .andExpect(jsonPath("$.[*].billNo").value(hasItem(DEFAULT_BILL_NO)))
            .andExpect(jsonPath("$.[*].revisionNo").value(hasItem(DEFAULT_REVISION_NO)))
            .andExpect(jsonPath("$.[*].resvDepositId").value(hasItem(DEFAULT_RESV_DEPOSIT_ID)))
            .andExpect(jsonPath("$.[*].linkTrxNo").value(hasItem(DEFAULT_LINK_TRX_NO)))
            .andExpect(jsonPath("$.[*].authorizerId").value(hasItem(DEFAULT_AUTHORIZER_ID)))
            .andExpect(jsonPath("$.[*].compLinkTrxNo").value(hasItem(DEFAULT_COMP_LINK_TRX_NO)))
            .andExpect(jsonPath("$.[*].mtrxNoAgainstPackage").value(hasItem(DEFAULT_MTRX_NO_AGAINST_PACKAGE)))
            .andExpect(jsonPath("$.[*].forexCommPerc").value(hasItem(DEFAULT_FOREX_COMM_PERC)))
            .andExpect(jsonPath("$.[*].forexCommAmount").value(hasItem(DEFAULT_FOREX_COMM_AMOUNT)))
            .andExpect(jsonPath("$.[*].articleId").value(hasItem(DEFAULT_ARTICLE_ID)))
            .andExpect(jsonPath("$.[*].toResvNameId").value(hasItem(DEFAULT_TO_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].roomNts").value(hasItem(DEFAULT_ROOM_NTS)))
            .andExpect(jsonPath("$.[*].orgArLedDebit").value(hasItem(DEFAULT_ORG_AR_LED_DEBIT)))
            .andExpect(jsonPath("$.[*].closureNo").value(hasItem(DEFAULT_CLOSURE_NO)))
            .andExpect(jsonPath("$.[*].originalResvNameId").value(hasItem(DEFAULT_ORIGINAL_RESV_NAME_ID)))
            .andExpect(jsonPath("$.[*].orgBillNo").value(hasItem(DEFAULT_ORG_BILL_NO)))
            .andExpect(jsonPath("$.[*].membershipId").value(hasItem(DEFAULT_MEMBERSHIP_ID)))
            .andExpect(jsonPath("$.[*].installments").value(hasItem(DEFAULT_INSTALLMENTS)))
            .andExpect(jsonPath("$.[*].contractGuestDebit").value(hasItem(DEFAULT_CONTRACT_GUEST_DEBIT)))
            .andExpect(jsonPath("$.[*].contractGuestCredit").value(hasItem(DEFAULT_CONTRACT_GUEST_CREDIT)))
            .andExpect(jsonPath("$.[*].contractNetAmount").value(hasItem(DEFAULT_CONTRACT_NET_AMOUNT)))
            .andExpect(jsonPath("$.[*].contractGrossAmount").value(hasItem(DEFAULT_CONTRACT_GROSS_AMOUNT)))
            .andExpect(jsonPath("$.[*].postitNo").value(hasItem(DEFAULT_POSTIT_NO)))
            .andExpect(jsonPath("$.[*].ccTrxFeeAmount").value(hasItem(DEFAULT_CC_TRX_FEE_AMOUNT)))
            .andExpect(jsonPath("$.[*].changeDue").value(hasItem(DEFAULT_CHANGE_DUE)))
            .andExpect(jsonPath("$.[*].postingSourceNameId").value(hasItem(DEFAULT_POSTING_SOURCE_NAME_ID)))
            .andExpect(jsonPath("$.[*].bonusCheckId").value(hasItem(DEFAULT_BONUS_CHECK_ID)))
            .andExpect(jsonPath("$.[*].roundLinkTrxno").value(hasItem(DEFAULT_ROUND_LINK_TRXNO)))
            .andExpect(jsonPath("$.[*].reversePaymentTrxNo").value(hasItem(DEFAULT_REVERSE_PAYMENT_TRX_NO)))
            .andExpect(jsonPath("$.[*].electronicVoucherNo").value(hasItem(DEFAULT_ELECTRONIC_VOUCHER_NO)))
            .andExpect(jsonPath("$.[*].thresholdDiversionId").value(hasItem(DEFAULT_THRESHOLD_DIVERSION_ID)))
            .andExpect(jsonPath("$.[*].thresholdEntityQty").value(hasItem(DEFAULT_THRESHOLD_ENTITY_QTY)))
            .andExpect(jsonPath("$.[*].trxNoSplit").value(hasItem(DEFAULT_TRX_NO_SPLIT)))
            .andExpect(jsonPath("$.[*].exchDiffTrxNo").value(hasItem(DEFAULT_EXCH_DIFF_TRX_NO)))
            .andExpect(jsonPath("$.[*].associatedTrxNo").value(hasItem(DEFAULT_ASSOCIATED_TRX_NO)))
            .andExpect(jsonPath("$.[*].taxRate").value(hasItem(DEFAULT_TAX_RATE)))
            .andExpect(jsonPath("$.[*].propChargeId").value(hasItem(DEFAULT_PROP_CHARGE_ID)))
            .andExpect(jsonPath("$.[*].quantity").value(hasItem(sameNumber(DEFAULT_QUANTITY))))
            .andExpect(jsonPath("$.[*].netAmount").value(hasItem(sameNumber(DEFAULT_NET_AMOUNT))))
            .andExpect(jsonPath("$.[*].grossAmount").value(hasItem(sameNumber(DEFAULT_GROSS_AMOUNT))))
            .andExpect(jsonPath("$.[*].cashierOpeningBalance").value(hasItem(sameNumber(DEFAULT_CASHIER_OPENING_BALANCE))))
            .andExpect(jsonPath("$.[*].pricePerUnit").value(hasItem(sameNumber(DEFAULT_PRICE_PER_UNIT))))
            .andExpect(jsonPath("$.[*].trxAmount").value(hasItem(sameNumber(DEFAULT_TRX_AMOUNT))))
            .andExpect(jsonPath("$.[*].postedAmount").value(hasItem(sameNumber(DEFAULT_POSTED_AMOUNT))))
            .andExpect(jsonPath("$.[*].guestAccountCredit").value(hasItem(sameNumber(DEFAULT_GUEST_ACCOUNT_CREDIT))))
            .andExpect(jsonPath("$.[*].exchangeRate").value(hasItem(sameNumber(DEFAULT_EXCHANGE_RATE))))
            .andExpect(jsonPath("$.[*].guestAccountDebit").value(hasItem(sameNumber(DEFAULT_GUEST_ACCOUNT_DEBIT))))
            .andExpect(jsonPath("$.[*].cashierCredit").value(hasItem(sameNumber(DEFAULT_CASHIER_CREDIT))))
            .andExpect(jsonPath("$.[*].cashierDebit").value(hasItem(sameNumber(DEFAULT_CASHIER_DEBIT))))
            .andExpect(jsonPath("$.[*].packageCredit").value(hasItem(sameNumber(DEFAULT_PACKAGE_CREDIT))))
            .andExpect(jsonPath("$.[*].packageDebit").value(hasItem(sameNumber(DEFAULT_PACKAGE_DEBIT))))
            .andExpect(jsonPath("$.[*].depLedCredit").value(hasItem(sameNumber(DEFAULT_DEP_LED_CREDIT))))
            .andExpect(jsonPath("$.[*].depLedDebit").value(hasItem(sameNumber(DEFAULT_DEP_LED_DEBIT))))
            .andExpect(jsonPath("$.[*].revenueAmt").value(hasItem(sameNumber(DEFAULT_REVENUE_AMT))))
            .andExpect(jsonPath("$.[*].arLedCredit").value(hasItem(sameNumber(DEFAULT_AR_LED_CREDIT))))
            .andExpect(jsonPath("$.[*].arLedDebit").value(hasItem(sameNumber(DEFAULT_AR_LED_DEBIT))))
            .andExpect(jsonPath("$.[*].euroExchangeRate").value(hasItem(sameNumber(DEFAULT_EURO_EXCHANGE_RATE))))
            .andExpect(jsonPath("$.[*].inhDebit").value(hasItem(sameNumber(DEFAULT_INH_DEBIT))))
            .andExpect(jsonPath("$.[*].inhCredit").value(hasItem(sameNumber(DEFAULT_INH_CREDIT))))
            .andExpect(jsonPath("$.[*].packageAllowance").value(hasItem(sameNumber(DEFAULT_PACKAGE_ALLOWANCE))))
            .andExpect(jsonPath("$.[*].parallelGuestCredit").value(hasItem(sameNumber(DEFAULT_PARALLEL_GUEST_CREDIT))))
            .andExpect(jsonPath("$.[*].parallelGuestDebit").value(hasItem(sameNumber(DEFAULT_PARALLEL_GUEST_DEBIT))))
            .andExpect(jsonPath("$.[*].parallelNetAmount").value(hasItem(sameNumber(DEFAULT_PARALLEL_NET_AMOUNT))))
            .andExpect(jsonPath("$.[*].parallelGrossAmount").value(hasItem(sameNumber(DEFAULT_PARALLEL_GROSS_AMOUNT))))
            .andExpect(jsonPath("$.[*].orgPostedAmount").value(hasItem(sameNumber(DEFAULT_ORG_POSTED_AMOUNT))))
            .andExpect(jsonPath("$.[*].roomNtsEffective").value(hasItem(sameNumber(DEFAULT_ROOM_NTS_EFFECTIVE))))
            .andExpect(jsonPath("$.[*].paymentSurchargeAmt").value(hasItem(sameNumber(DEFAULT_PAYMENT_SURCHARGE_AMT))))
            .andExpect(jsonPath("$.[*].folioView").value(hasItem(DEFAULT_FOLIO_VIEW)))
            .andExpect(jsonPath("$.[*].taxInclusiveYn").value(hasItem(DEFAULT_TAX_INCLUSIVE_YN)))
            .andExpect(jsonPath("$.[*].deferredYn").value(hasItem(DEFAULT_DEFERRED_YN)))
            .andExpect(jsonPath("$.[*].indAdjustmentYn").value(hasItem(DEFAULT_IND_ADJUSTMENT_YN)))
            .andExpect(jsonPath("$.[*].fixedChargesYn").value(hasItem(DEFAULT_FIXED_CHARGES_YN)))
            .andExpect(jsonPath("$.[*].taCommissionableYn").value(hasItem(DEFAULT_TA_COMMISSIONABLE_YN)))
            .andExpect(jsonPath("$.[*].taxGeneratedYn").value(hasItem(DEFAULT_TAX_GENERATED_YN)))
            .andExpect(jsonPath("$.[*].compressedYn").value(hasItem(DEFAULT_COMPRESSED_YN)))
            .andExpect(jsonPath("$.[*].displayYn").value(hasItem(DEFAULT_DISPLAY_YN)))
            .andExpect(jsonPath("$.[*].collAgentPostingYn").value(hasItem(DEFAULT_COLL_AGENT_POSTING_YN)))
            .andExpect(jsonPath("$.[*].fiscalTrxCodeType").value(hasItem(DEFAULT_FISCAL_TRX_CODE_TYPE)))
            .andExpect(jsonPath("$.[*].deferredTaxesYn").value(hasItem(DEFAULT_DEFERRED_TAXES_YN)))
            .andExpect(jsonPath("$.[*].advancedGenerateYn").value(hasItem(DEFAULT_ADVANCED_GENERATE_YN)))
            .andExpect(jsonPath("$.[*].forexType").value(hasItem(DEFAULT_FOREX_TYPE)))
            .andExpect(jsonPath("$.[*].taCommissionNetYn").value(hasItem(DEFAULT_TA_COMMISSION_NET_YN)))
            .andExpect(jsonPath("$.[*].sourceCommissionNetYn").value(hasItem(DEFAULT_SOURCE_COMMISSION_NET_YN)))
            .andExpect(jsonPath("$.[*].settlementFlag").value(hasItem(DEFAULT_SETTLEMENT_FLAG)))
            .andExpect(jsonPath("$.[*].accTypeFlag").value(hasItem(DEFAULT_ACC_TYPE_FLAG)))
            .andExpect(jsonPath("$.[*].profitLossFlag").value(hasItem(DEFAULT_PROFIT_LOSS_FLAG)))
            .andExpect(jsonPath("$.[*].proformaYn").value(hasItem(DEFAULT_PROFORMA_YN)))
            .andExpect(jsonPath("$.[*].holdYn").value(hasItem(DEFAULT_HOLD_YN)))
            .andExpect(jsonPath("$.[*].exchangeDifferenceYn").value(hasItem(DEFAULT_EXCHANGE_DIFFERENCE_YN)))
            .andExpect(jsonPath("$.[*].calcPointsYn").value(hasItem(DEFAULT_CALC_POINTS_YN)))
            .andExpect(jsonPath("$.[*].arChargeTransferYn").value(hasItem(DEFAULT_AR_CHARGE_TRANSFER_YN)))
            .andExpect(jsonPath("$.[*].processed8300Yn").value(hasItem(DEFAULT_PROCESSED_8300_YN)))
            .andExpect(jsonPath("$.[*].asbFlag").value(hasItem(DEFAULT_ASB_FLAG)))
            .andExpect(jsonPath("$.[*].postitYn").value(hasItem(DEFAULT_POSTIT_YN)))
            .andExpect(jsonPath("$.[*].autoSettleYn").value(hasItem(DEFAULT_AUTO_SETTLE_YN)))
            .andExpect(jsonPath("$.[*].depTaxTransferedYn").value(hasItem(DEFAULT_DEP_TAX_TRANSFERED_YN)))
            .andExpect(jsonPath("$.[*].autoCreditbillYn").value(hasItem(DEFAULT_AUTO_CREDITBILL_YN)))
            .andExpect(jsonPath("$.[*].asbOnlyPostTaxesOnceYn").value(hasItem(DEFAULT_ASB_ONLY_POST_TAXES_ONCE_YN)))
            .andExpect(jsonPath("$.[*].roundFactorYn").value(hasItem(DEFAULT_ROUND_FACTOR_YN)))
            .andExpect(jsonPath("$.[*].depPostingFlag").value(hasItem(DEFAULT_DEP_POSTING_FLAG)))
            .andExpect(jsonPath("$.[*].correctionYn").value(hasItem(DEFAULT_CORRECTION_YN)))
            .andExpect(jsonPath("$.[*].routedYn").value(hasItem(DEFAULT_ROUTED_YN)))
            .andExpect(jsonPath("$.[*].upsellChargeYn").value(hasItem(DEFAULT_UPSELL_CHARGE_YN)))
            .andExpect(jsonPath("$.[*].advanceBillYn").value(hasItem(DEFAULT_ADVANCE_BILL_YN)))
            .andExpect(jsonPath("$.[*].advanceBillReversedYn").value(hasItem(DEFAULT_ADVANCE_BILL_REVERSED_YN)))
            .andExpect(jsonPath("$.[*].incTaxDeductedYn").value(hasItem(DEFAULT_INC_TAX_DEDUCTED_YN)))
            .andExpect(jsonPath("$.[*].gpAwardCancelledYn").value(hasItem(DEFAULT_GP_AWARD_CANCELLED_YN)))
            .andExpect(jsonPath("$.[*].serviceRecoveryAdjustmentYn").value(hasItem(DEFAULT_SERVICE_RECOVERY_ADJUSTMENT_YN)))
            .andExpect(jsonPath("$.[*].splitType").value(hasItem(DEFAULT_SPLIT_TYPE)))
            .andExpect(jsonPath("$.[*].bucketRedempYn").value(hasItem(DEFAULT_BUCKET_REDEMP_YN)))
            .andExpect(jsonPath("$.[*].vatOffsetYn").value(hasItem(DEFAULT_VAT_OFFSET_YN)))
            .andExpect(jsonPath("$.[*].forexTaxYn").value(hasItem(DEFAULT_FOREX_TAX_YN)))
            .andExpect(jsonPath("$.[*].stampDutyYn").value(hasItem(DEFAULT_STAMP_DUTY_YN)))
            .andExpect(jsonPath("$.[*].covers").value(hasItem(DEFAULT_COVERS)))
            .andExpect(jsonPath("$.[*].advGenerateAdjustment").value(hasItem(DEFAULT_ADV_GENERATE_ADJUSTMENT)))
            .andExpect(jsonPath("$.[*].expInvoiceType").value(hasItem(DEFAULT_EXP_INVOICE_TYPE)))
            .andExpect(jsonPath("$.[*].folioType").value(hasItem(DEFAULT_FOLIO_TYPE)))
            .andExpect(jsonPath("$.[*].orgFolioType").value(hasItem(DEFAULT_ORG_FOLIO_TYPE)))
            .andExpect(jsonPath("$.[*].invoiceType").value(hasItem(DEFAULT_INVOICE_TYPE)))
            .andExpect(jsonPath("$.[*].arState").value(hasItem(DEFAULT_AR_STATE)))
            .andExpect(jsonPath("$.[*].exchangeType").value(hasItem(DEFAULT_EXCHANGE_TYPE)))
            .andExpect(jsonPath("$.[*].recptType").value(hasItem(DEFAULT_RECPT_TYPE)))
            .andExpect(jsonPath("$.[*].roomClass").value(hasItem(DEFAULT_ROOM_CLASS)))
            .andExpect(jsonPath("$.[*].resort").value(hasItem(DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].tcGroup").value(hasItem(DEFAULT_TC_GROUP)))
            .andExpect(jsonPath("$.[*].tcSubgroup").value(hasItem(DEFAULT_TC_SUBGROUP)))
            .andExpect(jsonPath("$.[*].trxCode").value(hasItem(DEFAULT_TRX_CODE)))
            .andExpect(jsonPath("$.[*].room").value(hasItem(DEFAULT_ROOM)))
            .andExpect(jsonPath("$.[*].tclCode1").value(hasItem(DEFAULT_TCL_CODE_1)))
            .andExpect(jsonPath("$.[*].currency").value(hasItem(DEFAULT_CURRENCY)))
            .andExpect(jsonPath("$.[*].ftGeneratedType").value(hasItem(DEFAULT_FT_GENERATED_TYPE)))
            .andExpect(jsonPath("$.[*].tclCode2").value(hasItem(DEFAULT_TCL_CODE_2)))
            .andExpect(jsonPath("$.[*].marketCode").value(hasItem(DEFAULT_MARKET_CODE)))
            .andExpect(jsonPath("$.[*].sourceCode").value(hasItem(DEFAULT_SOURCE_CODE)))
            .andExpect(jsonPath("$.[*].rateCode").value(hasItem(DEFAULT_RATE_CODE)))
            .andExpect(jsonPath("$.[*].hotelAcct").value(hasItem(DEFAULT_HOTEL_ACCT)))
            .andExpect(jsonPath("$.[*].reasonCode").value(hasItem(DEFAULT_REASON_CODE)))
            .andExpect(jsonPath("$.[*].product").value(hasItem(DEFAULT_PRODUCT)))
            .andExpect(jsonPath("$.[*].targetResort").value(hasItem(DEFAULT_TARGET_RESORT)))
            .andExpect(jsonPath("$.[*].nameTaxType").value(hasItem(DEFAULT_NAME_TAX_TYPE)))
            .andExpect(jsonPath("$.[*].taxInvNo").value(hasItem(DEFAULT_TAX_INV_NO)))
            .andExpect(jsonPath("$.[*].approvalCode").value(hasItem(DEFAULT_APPROVAL_CODE)))
            .andExpect(jsonPath("$.[*].approvalStatus").value(hasItem(DEFAULT_APPROVAL_STATUS)))
            .andExpect(jsonPath("$.[*].compLinkTrxCode").value(hasItem(DEFAULT_COMP_LINK_TRX_CODE)))
            .andExpect(jsonPath("$.[*].compTypeCode").value(hasItem(DEFAULT_COMP_TYPE_CODE)))
            .andExpect(jsonPath("$.[*].couponNo").value(hasItem(DEFAULT_COUPON_NO)))
            .andExpect(jsonPath("$.[*].originalRoom").value(hasItem(DEFAULT_ORIGINAL_ROOM)))
            .andExpect(jsonPath("$.[*].allowanceType").value(hasItem(DEFAULT_ALLOWANCE_TYPE)))
            .andExpect(jsonPath("$.[*].advGenerateTrxCode").value(hasItem(DEFAULT_ADV_GENERATE_TRX_CODE)))
            .andExpect(jsonPath("$.[*].trxServiceType").value(hasItem(DEFAULT_TRX_SERVICE_TYPE)))
            .andExpect(jsonPath("$.[*].postingType").value(hasItem(DEFAULT_POSTING_TYPE)))
            .andExpect(jsonPath("$.[*].parallelCurrency").value(hasItem(DEFAULT_PARALLEL_CURRENCY)))
            .andExpect(jsonPath("$.[*].contractCurrency").value(hasItem(DEFAULT_CONTRACT_CURRENCY)))
            .andExpect(jsonPath("$.[*].fbaCertificateNumber").value(hasItem(DEFAULT_FBA_CERTIFICATE_NUMBER)))
            .andExpect(jsonPath("$.[*].postingRhythm").value(hasItem(DEFAULT_POSTING_RHYTHM)))
            .andExpect(jsonPath("$.[*].asbTaxFlag").value(hasItem(DEFAULT_ASB_TAX_FLAG)))
            .andExpect(jsonPath("$.[*].packageArrangementCode").value(hasItem(DEFAULT_PACKAGE_ARRANGEMENT_CODE)))
            .andExpect(jsonPath("$.[*].gpAwardCode").value(hasItem(DEFAULT_GP_AWARD_CODE)))
            .andExpect(jsonPath("$.[*].gpAwardCancelCode").value(hasItem(DEFAULT_GP_AWARD_CANCEL_CODE)))
            .andExpect(jsonPath("$.[*].serviceRecoveryDeptCode").value(hasItem(DEFAULT_SERVICE_RECOVERY_DEPT_CODE)))
            .andExpect(jsonPath("$.[*].bucketCode").value(hasItem(DEFAULT_BUCKET_CODE)))
            .andExpect(jsonPath("$.[*].taxRateType").value(hasItem(DEFAULT_TAX_RATE_TYPE)))
            .andExpect(jsonPath("$.[*].chequeNumber").value(hasItem(DEFAULT_CHEQUE_NUMBER)))
            .andExpect(jsonPath("$.[*].passerByName").value(hasItem(DEFAULT_PASSER_BY_NAME)))
            .andExpect(jsonPath("$.[*].esignedReceiptName").value(hasItem(DEFAULT_ESIGNED_RECEIPT_NAME)))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK)))
            .andExpect(jsonPath("$.[*].reference").value(hasItem(DEFAULT_REFERENCE)))
            .andExpect(jsonPath("$.[*].oTrxDesc").value(hasItem(DEFAULT_O_TRX_DESC)))
            .andExpect(jsonPath("$.[*].comments").value(hasItem(DEFAULT_COMMENTS)))
            .andExpect(jsonPath("$.[*].fiscalBillNo").value(hasItem(DEFAULT_FISCAL_BILL_NO)))
            .andExpect(jsonPath("$.[*].extSysResultMsg").value(hasItem(DEFAULT_EXT_SYS_RESULT_MSG)))
            .andExpect(jsonPath("$.[*].queueName").value(hasItem(DEFAULT_QUEUE_NAME)))
            .andExpect(jsonPath("$.[*].paymentType").value(hasItem(DEFAULT_PAYMENT_TYPE)))
            .andExpect(jsonPath("$.[*].ccRefundPosting").value(hasItem(DEFAULT_CC_REFUND_POSTING)))
            .andExpect(jsonPath("$.[*].thresholdEntityType").value(hasItem(DEFAULT_THRESHOLD_ENTITY_TYPE)))
            .andExpect(jsonPath("$.[*].thresholdTreatmentFlag").value(hasItem(DEFAULT_THRESHOLD_TREATMENT_FLAG)))
            .andExpect(jsonPath("$.[*].paymentSurchargeType").value(hasItem(DEFAULT_PAYMENT_SURCHARGE_TYPE)))
            .andExpect(jsonPath("$.[*].propertyBillPrefix").value(hasItem(DEFAULT_PROPERTY_BILL_PREFIX)))
            .andExpect(jsonPath("$.[*].taxElements").value(hasItem(DEFAULT_TAX_ELEMENTS)))
            .andExpect(jsonPath("$.[*].numberDialed").value(hasItem(DEFAULT_NUMBER_DIALED)))
            .andExpect(jsonPath("$.[*].checkFileId").value(hasItem(DEFAULT_CHECK_FILE_ID)))
            .andExpect(jsonPath("$.[*].extTrxId").value(hasItem(DEFAULT_EXT_TRX_ID)))
            .andExpect(jsonPath("$.[*].packageTrxType").value(hasItem(DEFAULT_PACKAGE_TRX_TYPE)))
            .andExpect(jsonPath("$.[*].expOriginalInvoice").value(hasItem(DEFAULT_EXP_ORIGINAL_INVOICE)))
            .andExpect(jsonPath("$.[*].depositTransactionId").value(hasItem(DEFAULT_DEPOSIT_TRANSACTION_ID)));
    }

    @Test
    @Transactional
    void getFinancialTransactions() throws Exception {
        // Initialize the database
        financialTransactionsRepository.saveAndFlush(financialTransactions);

        // Get the financialTransactions
        restFinancialTransactionsMockMvc
            .perform(get(ENTITY_API_URL_ID, financialTransactions.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(financialTransactions.getId().intValue()))
            .andExpect(jsonPath("$.trxNo").value(DEFAULT_TRX_NO))
            .andExpect(jsonPath("$.ftSubtype").value(DEFAULT_FT_SUBTYPE))
            .andExpect(jsonPath("$.invoiceCloseDate").value(DEFAULT_INVOICE_CLOSE_DATE.toString()))
            .andExpect(jsonPath("$.arTransferDate").value(DEFAULT_AR_TRANSFER_DATE.toString()))
            .andExpect(jsonPath("$.trxDate").value(DEFAULT_TRX_DATE.toString()))
            .andExpect(jsonPath("$.businessDate").value(DEFAULT_BUSINESS_DATE.toString()))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.trnsActivityDate").value(DEFAULT_TRNS_ACTIVITY_DATE.toString()))
            .andExpect(jsonPath("$.approvalDate").value(DEFAULT_APPROVAL_DATE.toString()))
            .andExpect(jsonPath("$.postingDate").value(DEFAULT_POSTING_DATE.toString()))
            .andExpect(jsonPath("$.exchangeDate").value(DEFAULT_EXCHANGE_DATE.toString()))
            .andExpect(jsonPath("$.routingDate").value(DEFAULT_ROUTING_DATE.toString()))
            .andExpect(jsonPath("$.effectiveDate").value(DEFAULT_EFFECTIVE_DATE.toString()))
            .andExpect(jsonPath("$.customChargeDate").value(DEFAULT_CUSTOM_CHARGE_DATE.toString()))
            .andExpect(jsonPath("$.recptNo").value(DEFAULT_RECPT_NO))
            .andExpect(jsonPath("$.trxNoAdjust").value(DEFAULT_TRX_NO_ADJUST))
            .andExpect(jsonPath("$.trxNoAddedBy").value(DEFAULT_TRX_NO_ADDED_BY))
            .andExpect(jsonPath("$.trxNoAgainstPackage").value(DEFAULT_TRX_NO_AGAINST_PACKAGE))
            .andExpect(jsonPath("$.trxNoHeader").value(DEFAULT_TRX_NO_HEADER))
            .andExpect(jsonPath("$.arNumber").value(DEFAULT_AR_NUMBER))
            .andExpect(jsonPath("$.resvNameId").value(DEFAULT_RESV_NAME_ID))
            .andExpect(jsonPath("$.cashierId").value(DEFAULT_CASHIER_ID))
            .andExpect(jsonPath("$.creditCardId").value(DEFAULT_CREDIT_CARD_ID))
            .andExpect(jsonPath("$.nameId").value(DEFAULT_NAME_ID))
            .andExpect(jsonPath("$.tranActionId").value(DEFAULT_TRAN_ACTION_ID))
            .andExpect(jsonPath("$.finDmlSeqNo").value(DEFAULT_FIN_DML_SEQ_NO))
            .andExpect(jsonPath("$.routingInstrnId").value(DEFAULT_ROUTING_INSTRN_ID))
            .andExpect(jsonPath("$.fromResvId").value(DEFAULT_FROM_RESV_ID))
            .andExpect(jsonPath("$.genCashierId").value(DEFAULT_GEN_CASHIER_ID))
            .andExpect(jsonPath("$.folioNo").value(DEFAULT_FOLIO_NO))
            .andExpect(jsonPath("$.invoiceNo").value(DEFAULT_INVOICE_NO))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.arrangementId").value(DEFAULT_ARRANGEMENT_ID))
            .andExpect(jsonPath("$.trnsFromAcct").value(DEFAULT_TRNS_FROM_ACCT))
            .andExpect(jsonPath("$.trnsToAcct").value(DEFAULT_TRNS_TO_ACCT))
            .andExpect(jsonPath("$.billNo").value(DEFAULT_BILL_NO))
            .andExpect(jsonPath("$.revisionNo").value(DEFAULT_REVISION_NO))
            .andExpect(jsonPath("$.resvDepositId").value(DEFAULT_RESV_DEPOSIT_ID))
            .andExpect(jsonPath("$.linkTrxNo").value(DEFAULT_LINK_TRX_NO))
            .andExpect(jsonPath("$.authorizerId").value(DEFAULT_AUTHORIZER_ID))
            .andExpect(jsonPath("$.compLinkTrxNo").value(DEFAULT_COMP_LINK_TRX_NO))
            .andExpect(jsonPath("$.mtrxNoAgainstPackage").value(DEFAULT_MTRX_NO_AGAINST_PACKAGE))
            .andExpect(jsonPath("$.forexCommPerc").value(DEFAULT_FOREX_COMM_PERC))
            .andExpect(jsonPath("$.forexCommAmount").value(DEFAULT_FOREX_COMM_AMOUNT))
            .andExpect(jsonPath("$.articleId").value(DEFAULT_ARTICLE_ID))
            .andExpect(jsonPath("$.toResvNameId").value(DEFAULT_TO_RESV_NAME_ID))
            .andExpect(jsonPath("$.roomNts").value(DEFAULT_ROOM_NTS))
            .andExpect(jsonPath("$.orgArLedDebit").value(DEFAULT_ORG_AR_LED_DEBIT))
            .andExpect(jsonPath("$.closureNo").value(DEFAULT_CLOSURE_NO))
            .andExpect(jsonPath("$.originalResvNameId").value(DEFAULT_ORIGINAL_RESV_NAME_ID))
            .andExpect(jsonPath("$.orgBillNo").value(DEFAULT_ORG_BILL_NO))
            .andExpect(jsonPath("$.membershipId").value(DEFAULT_MEMBERSHIP_ID))
            .andExpect(jsonPath("$.installments").value(DEFAULT_INSTALLMENTS))
            .andExpect(jsonPath("$.contractGuestDebit").value(DEFAULT_CONTRACT_GUEST_DEBIT))
            .andExpect(jsonPath("$.contractGuestCredit").value(DEFAULT_CONTRACT_GUEST_CREDIT))
            .andExpect(jsonPath("$.contractNetAmount").value(DEFAULT_CONTRACT_NET_AMOUNT))
            .andExpect(jsonPath("$.contractGrossAmount").value(DEFAULT_CONTRACT_GROSS_AMOUNT))
            .andExpect(jsonPath("$.postitNo").value(DEFAULT_POSTIT_NO))
            .andExpect(jsonPath("$.ccTrxFeeAmount").value(DEFAULT_CC_TRX_FEE_AMOUNT))
            .andExpect(jsonPath("$.changeDue").value(DEFAULT_CHANGE_DUE))
            .andExpect(jsonPath("$.postingSourceNameId").value(DEFAULT_POSTING_SOURCE_NAME_ID))
            .andExpect(jsonPath("$.bonusCheckId").value(DEFAULT_BONUS_CHECK_ID))
            .andExpect(jsonPath("$.roundLinkTrxno").value(DEFAULT_ROUND_LINK_TRXNO))
            .andExpect(jsonPath("$.reversePaymentTrxNo").value(DEFAULT_REVERSE_PAYMENT_TRX_NO))
            .andExpect(jsonPath("$.electronicVoucherNo").value(DEFAULT_ELECTRONIC_VOUCHER_NO))
            .andExpect(jsonPath("$.thresholdDiversionId").value(DEFAULT_THRESHOLD_DIVERSION_ID))
            .andExpect(jsonPath("$.thresholdEntityQty").value(DEFAULT_THRESHOLD_ENTITY_QTY))
            .andExpect(jsonPath("$.trxNoSplit").value(DEFAULT_TRX_NO_SPLIT))
            .andExpect(jsonPath("$.exchDiffTrxNo").value(DEFAULT_EXCH_DIFF_TRX_NO))
            .andExpect(jsonPath("$.associatedTrxNo").value(DEFAULT_ASSOCIATED_TRX_NO))
            .andExpect(jsonPath("$.taxRate").value(DEFAULT_TAX_RATE))
            .andExpect(jsonPath("$.propChargeId").value(DEFAULT_PROP_CHARGE_ID))
            .andExpect(jsonPath("$.quantity").value(sameNumber(DEFAULT_QUANTITY)))
            .andExpect(jsonPath("$.netAmount").value(sameNumber(DEFAULT_NET_AMOUNT)))
            .andExpect(jsonPath("$.grossAmount").value(sameNumber(DEFAULT_GROSS_AMOUNT)))
            .andExpect(jsonPath("$.cashierOpeningBalance").value(sameNumber(DEFAULT_CASHIER_OPENING_BALANCE)))
            .andExpect(jsonPath("$.pricePerUnit").value(sameNumber(DEFAULT_PRICE_PER_UNIT)))
            .andExpect(jsonPath("$.trxAmount").value(sameNumber(DEFAULT_TRX_AMOUNT)))
            .andExpect(jsonPath("$.postedAmount").value(sameNumber(DEFAULT_POSTED_AMOUNT)))
            .andExpect(jsonPath("$.guestAccountCredit").value(sameNumber(DEFAULT_GUEST_ACCOUNT_CREDIT)))
            .andExpect(jsonPath("$.exchangeRate").value(sameNumber(DEFAULT_EXCHANGE_RATE)))
            .andExpect(jsonPath("$.guestAccountDebit").value(sameNumber(DEFAULT_GUEST_ACCOUNT_DEBIT)))
            .andExpect(jsonPath("$.cashierCredit").value(sameNumber(DEFAULT_CASHIER_CREDIT)))
            .andExpect(jsonPath("$.cashierDebit").value(sameNumber(DEFAULT_CASHIER_DEBIT)))
            .andExpect(jsonPath("$.packageCredit").value(sameNumber(DEFAULT_PACKAGE_CREDIT)))
            .andExpect(jsonPath("$.packageDebit").value(sameNumber(DEFAULT_PACKAGE_DEBIT)))
            .andExpect(jsonPath("$.depLedCredit").value(sameNumber(DEFAULT_DEP_LED_CREDIT)))
            .andExpect(jsonPath("$.depLedDebit").value(sameNumber(DEFAULT_DEP_LED_DEBIT)))
            .andExpect(jsonPath("$.revenueAmt").value(sameNumber(DEFAULT_REVENUE_AMT)))
            .andExpect(jsonPath("$.arLedCredit").value(sameNumber(DEFAULT_AR_LED_CREDIT)))
            .andExpect(jsonPath("$.arLedDebit").value(sameNumber(DEFAULT_AR_LED_DEBIT)))
            .andExpect(jsonPath("$.euroExchangeRate").value(sameNumber(DEFAULT_EURO_EXCHANGE_RATE)))
            .andExpect(jsonPath("$.inhDebit").value(sameNumber(DEFAULT_INH_DEBIT)))
            .andExpect(jsonPath("$.inhCredit").value(sameNumber(DEFAULT_INH_CREDIT)))
            .andExpect(jsonPath("$.packageAllowance").value(sameNumber(DEFAULT_PACKAGE_ALLOWANCE)))
            .andExpect(jsonPath("$.parallelGuestCredit").value(sameNumber(DEFAULT_PARALLEL_GUEST_CREDIT)))
            .andExpect(jsonPath("$.parallelGuestDebit").value(sameNumber(DEFAULT_PARALLEL_GUEST_DEBIT)))
            .andExpect(jsonPath("$.parallelNetAmount").value(sameNumber(DEFAULT_PARALLEL_NET_AMOUNT)))
            .andExpect(jsonPath("$.parallelGrossAmount").value(sameNumber(DEFAULT_PARALLEL_GROSS_AMOUNT)))
            .andExpect(jsonPath("$.orgPostedAmount").value(sameNumber(DEFAULT_ORG_POSTED_AMOUNT)))
            .andExpect(jsonPath("$.roomNtsEffective").value(sameNumber(DEFAULT_ROOM_NTS_EFFECTIVE)))
            .andExpect(jsonPath("$.paymentSurchargeAmt").value(sameNumber(DEFAULT_PAYMENT_SURCHARGE_AMT)))
            .andExpect(jsonPath("$.folioView").value(DEFAULT_FOLIO_VIEW))
            .andExpect(jsonPath("$.taxInclusiveYn").value(DEFAULT_TAX_INCLUSIVE_YN))
            .andExpect(jsonPath("$.deferredYn").value(DEFAULT_DEFERRED_YN))
            .andExpect(jsonPath("$.indAdjustmentYn").value(DEFAULT_IND_ADJUSTMENT_YN))
            .andExpect(jsonPath("$.fixedChargesYn").value(DEFAULT_FIXED_CHARGES_YN))
            .andExpect(jsonPath("$.taCommissionableYn").value(DEFAULT_TA_COMMISSIONABLE_YN))
            .andExpect(jsonPath("$.taxGeneratedYn").value(DEFAULT_TAX_GENERATED_YN))
            .andExpect(jsonPath("$.compressedYn").value(DEFAULT_COMPRESSED_YN))
            .andExpect(jsonPath("$.displayYn").value(DEFAULT_DISPLAY_YN))
            .andExpect(jsonPath("$.collAgentPostingYn").value(DEFAULT_COLL_AGENT_POSTING_YN))
            .andExpect(jsonPath("$.fiscalTrxCodeType").value(DEFAULT_FISCAL_TRX_CODE_TYPE))
            .andExpect(jsonPath("$.deferredTaxesYn").value(DEFAULT_DEFERRED_TAXES_YN))
            .andExpect(jsonPath("$.advancedGenerateYn").value(DEFAULT_ADVANCED_GENERATE_YN))
            .andExpect(jsonPath("$.forexType").value(DEFAULT_FOREX_TYPE))
            .andExpect(jsonPath("$.taCommissionNetYn").value(DEFAULT_TA_COMMISSION_NET_YN))
            .andExpect(jsonPath("$.sourceCommissionNetYn").value(DEFAULT_SOURCE_COMMISSION_NET_YN))
            .andExpect(jsonPath("$.settlementFlag").value(DEFAULT_SETTLEMENT_FLAG))
            .andExpect(jsonPath("$.accTypeFlag").value(DEFAULT_ACC_TYPE_FLAG))
            .andExpect(jsonPath("$.profitLossFlag").value(DEFAULT_PROFIT_LOSS_FLAG))
            .andExpect(jsonPath("$.proformaYn").value(DEFAULT_PROFORMA_YN))
            .andExpect(jsonPath("$.holdYn").value(DEFAULT_HOLD_YN))
            .andExpect(jsonPath("$.exchangeDifferenceYn").value(DEFAULT_EXCHANGE_DIFFERENCE_YN))
            .andExpect(jsonPath("$.calcPointsYn").value(DEFAULT_CALC_POINTS_YN))
            .andExpect(jsonPath("$.arChargeTransferYn").value(DEFAULT_AR_CHARGE_TRANSFER_YN))
            .andExpect(jsonPath("$.processed8300Yn").value(DEFAULT_PROCESSED_8300_YN))
            .andExpect(jsonPath("$.asbFlag").value(DEFAULT_ASB_FLAG))
            .andExpect(jsonPath("$.postitYn").value(DEFAULT_POSTIT_YN))
            .andExpect(jsonPath("$.autoSettleYn").value(DEFAULT_AUTO_SETTLE_YN))
            .andExpect(jsonPath("$.depTaxTransferedYn").value(DEFAULT_DEP_TAX_TRANSFERED_YN))
            .andExpect(jsonPath("$.autoCreditbillYn").value(DEFAULT_AUTO_CREDITBILL_YN))
            .andExpect(jsonPath("$.asbOnlyPostTaxesOnceYn").value(DEFAULT_ASB_ONLY_POST_TAXES_ONCE_YN))
            .andExpect(jsonPath("$.roundFactorYn").value(DEFAULT_ROUND_FACTOR_YN))
            .andExpect(jsonPath("$.depPostingFlag").value(DEFAULT_DEP_POSTING_FLAG))
            .andExpect(jsonPath("$.correctionYn").value(DEFAULT_CORRECTION_YN))
            .andExpect(jsonPath("$.routedYn").value(DEFAULT_ROUTED_YN))
            .andExpect(jsonPath("$.upsellChargeYn").value(DEFAULT_UPSELL_CHARGE_YN))
            .andExpect(jsonPath("$.advanceBillYn").value(DEFAULT_ADVANCE_BILL_YN))
            .andExpect(jsonPath("$.advanceBillReversedYn").value(DEFAULT_ADVANCE_BILL_REVERSED_YN))
            .andExpect(jsonPath("$.incTaxDeductedYn").value(DEFAULT_INC_TAX_DEDUCTED_YN))
            .andExpect(jsonPath("$.gpAwardCancelledYn").value(DEFAULT_GP_AWARD_CANCELLED_YN))
            .andExpect(jsonPath("$.serviceRecoveryAdjustmentYn").value(DEFAULT_SERVICE_RECOVERY_ADJUSTMENT_YN))
            .andExpect(jsonPath("$.splitType").value(DEFAULT_SPLIT_TYPE))
            .andExpect(jsonPath("$.bucketRedempYn").value(DEFAULT_BUCKET_REDEMP_YN))
            .andExpect(jsonPath("$.vatOffsetYn").value(DEFAULT_VAT_OFFSET_YN))
            .andExpect(jsonPath("$.forexTaxYn").value(DEFAULT_FOREX_TAX_YN))
            .andExpect(jsonPath("$.stampDutyYn").value(DEFAULT_STAMP_DUTY_YN))
            .andExpect(jsonPath("$.covers").value(DEFAULT_COVERS))
            .andExpect(jsonPath("$.advGenerateAdjustment").value(DEFAULT_ADV_GENERATE_ADJUSTMENT))
            .andExpect(jsonPath("$.expInvoiceType").value(DEFAULT_EXP_INVOICE_TYPE))
            .andExpect(jsonPath("$.folioType").value(DEFAULT_FOLIO_TYPE))
            .andExpect(jsonPath("$.orgFolioType").value(DEFAULT_ORG_FOLIO_TYPE))
            .andExpect(jsonPath("$.invoiceType").value(DEFAULT_INVOICE_TYPE))
            .andExpect(jsonPath("$.arState").value(DEFAULT_AR_STATE))
            .andExpect(jsonPath("$.exchangeType").value(DEFAULT_EXCHANGE_TYPE))
            .andExpect(jsonPath("$.recptType").value(DEFAULT_RECPT_TYPE))
            .andExpect(jsonPath("$.roomClass").value(DEFAULT_ROOM_CLASS))
            .andExpect(jsonPath("$.resort").value(DEFAULT_RESORT))
            .andExpect(jsonPath("$.tcGroup").value(DEFAULT_TC_GROUP))
            .andExpect(jsonPath("$.tcSubgroup").value(DEFAULT_TC_SUBGROUP))
            .andExpect(jsonPath("$.trxCode").value(DEFAULT_TRX_CODE))
            .andExpect(jsonPath("$.room").value(DEFAULT_ROOM))
            .andExpect(jsonPath("$.tclCode1").value(DEFAULT_TCL_CODE_1))
            .andExpect(jsonPath("$.currency").value(DEFAULT_CURRENCY))
            .andExpect(jsonPath("$.ftGeneratedType").value(DEFAULT_FT_GENERATED_TYPE))
            .andExpect(jsonPath("$.tclCode2").value(DEFAULT_TCL_CODE_2))
            .andExpect(jsonPath("$.marketCode").value(DEFAULT_MARKET_CODE))
            .andExpect(jsonPath("$.sourceCode").value(DEFAULT_SOURCE_CODE))
            .andExpect(jsonPath("$.rateCode").value(DEFAULT_RATE_CODE))
            .andExpect(jsonPath("$.hotelAcct").value(DEFAULT_HOTEL_ACCT))
            .andExpect(jsonPath("$.reasonCode").value(DEFAULT_REASON_CODE))
            .andExpect(jsonPath("$.product").value(DEFAULT_PRODUCT))
            .andExpect(jsonPath("$.targetResort").value(DEFAULT_TARGET_RESORT))
            .andExpect(jsonPath("$.nameTaxType").value(DEFAULT_NAME_TAX_TYPE))
            .andExpect(jsonPath("$.taxInvNo").value(DEFAULT_TAX_INV_NO))
            .andExpect(jsonPath("$.approvalCode").value(DEFAULT_APPROVAL_CODE))
            .andExpect(jsonPath("$.approvalStatus").value(DEFAULT_APPROVAL_STATUS))
            .andExpect(jsonPath("$.compLinkTrxCode").value(DEFAULT_COMP_LINK_TRX_CODE))
            .andExpect(jsonPath("$.compTypeCode").value(DEFAULT_COMP_TYPE_CODE))
            .andExpect(jsonPath("$.couponNo").value(DEFAULT_COUPON_NO))
            .andExpect(jsonPath("$.originalRoom").value(DEFAULT_ORIGINAL_ROOM))
            .andExpect(jsonPath("$.allowanceType").value(DEFAULT_ALLOWANCE_TYPE))
            .andExpect(jsonPath("$.advGenerateTrxCode").value(DEFAULT_ADV_GENERATE_TRX_CODE))
            .andExpect(jsonPath("$.trxServiceType").value(DEFAULT_TRX_SERVICE_TYPE))
            .andExpect(jsonPath("$.postingType").value(DEFAULT_POSTING_TYPE))
            .andExpect(jsonPath("$.parallelCurrency").value(DEFAULT_PARALLEL_CURRENCY))
            .andExpect(jsonPath("$.contractCurrency").value(DEFAULT_CONTRACT_CURRENCY))
            .andExpect(jsonPath("$.fbaCertificateNumber").value(DEFAULT_FBA_CERTIFICATE_NUMBER))
            .andExpect(jsonPath("$.postingRhythm").value(DEFAULT_POSTING_RHYTHM))
            .andExpect(jsonPath("$.asbTaxFlag").value(DEFAULT_ASB_TAX_FLAG))
            .andExpect(jsonPath("$.packageArrangementCode").value(DEFAULT_PACKAGE_ARRANGEMENT_CODE))
            .andExpect(jsonPath("$.gpAwardCode").value(DEFAULT_GP_AWARD_CODE))
            .andExpect(jsonPath("$.gpAwardCancelCode").value(DEFAULT_GP_AWARD_CANCEL_CODE))
            .andExpect(jsonPath("$.serviceRecoveryDeptCode").value(DEFAULT_SERVICE_RECOVERY_DEPT_CODE))
            .andExpect(jsonPath("$.bucketCode").value(DEFAULT_BUCKET_CODE))
            .andExpect(jsonPath("$.taxRateType").value(DEFAULT_TAX_RATE_TYPE))
            .andExpect(jsonPath("$.chequeNumber").value(DEFAULT_CHEQUE_NUMBER))
            .andExpect(jsonPath("$.passerByName").value(DEFAULT_PASSER_BY_NAME))
            .andExpect(jsonPath("$.esignedReceiptName").value(DEFAULT_ESIGNED_RECEIPT_NAME))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK))
            .andExpect(jsonPath("$.reference").value(DEFAULT_REFERENCE))
            .andExpect(jsonPath("$.oTrxDesc").value(DEFAULT_O_TRX_DESC))
            .andExpect(jsonPath("$.comments").value(DEFAULT_COMMENTS))
            .andExpect(jsonPath("$.fiscalBillNo").value(DEFAULT_FISCAL_BILL_NO))
            .andExpect(jsonPath("$.extSysResultMsg").value(DEFAULT_EXT_SYS_RESULT_MSG))
            .andExpect(jsonPath("$.queueName").value(DEFAULT_QUEUE_NAME))
            .andExpect(jsonPath("$.paymentType").value(DEFAULT_PAYMENT_TYPE))
            .andExpect(jsonPath("$.ccRefundPosting").value(DEFAULT_CC_REFUND_POSTING))
            .andExpect(jsonPath("$.thresholdEntityType").value(DEFAULT_THRESHOLD_ENTITY_TYPE))
            .andExpect(jsonPath("$.thresholdTreatmentFlag").value(DEFAULT_THRESHOLD_TREATMENT_FLAG))
            .andExpect(jsonPath("$.paymentSurchargeType").value(DEFAULT_PAYMENT_SURCHARGE_TYPE))
            .andExpect(jsonPath("$.propertyBillPrefix").value(DEFAULT_PROPERTY_BILL_PREFIX))
            .andExpect(jsonPath("$.taxElements").value(DEFAULT_TAX_ELEMENTS))
            .andExpect(jsonPath("$.numberDialed").value(DEFAULT_NUMBER_DIALED))
            .andExpect(jsonPath("$.checkFileId").value(DEFAULT_CHECK_FILE_ID))
            .andExpect(jsonPath("$.extTrxId").value(DEFAULT_EXT_TRX_ID))
            .andExpect(jsonPath("$.packageTrxType").value(DEFAULT_PACKAGE_TRX_TYPE))
            .andExpect(jsonPath("$.expOriginalInvoice").value(DEFAULT_EXP_ORIGINAL_INVOICE))
            .andExpect(jsonPath("$.depositTransactionId").value(DEFAULT_DEPOSIT_TRANSACTION_ID));
    }

    @Test
    @Transactional
    void getNonExistingFinancialTransactions() throws Exception {
        // Get the financialTransactions
        restFinancialTransactionsMockMvc.perform(get(ENTITY_API_URL_ID, Integer.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingFinancialTransactions() throws Exception {
        // Initialize the database
        financialTransactionsRepository.saveAndFlush(financialTransactions);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the financialTransactions
        FinancialTransactions updatedFinancialTransactions = financialTransactionsRepository
            .findById(financialTransactions.getId())
            .orElseThrow();
        // Disconnect from session so that the updates on updatedFinancialTransactions are not directly saved in db
        em.detach(updatedFinancialTransactions);
        updatedFinancialTransactions
            .trxNo(UPDATED_TRX_NO)
            .ftSubtype(UPDATED_FT_SUBTYPE)
            .invoiceCloseDate(UPDATED_INVOICE_CLOSE_DATE)
            .arTransferDate(UPDATED_AR_TRANSFER_DATE)
            .trxDate(UPDATED_TRX_DATE)
            .businessDate(UPDATED_BUSINESS_DATE)
            .insertDate(UPDATED_INSERT_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .trnsActivityDate(UPDATED_TRNS_ACTIVITY_DATE)
            .approvalDate(UPDATED_APPROVAL_DATE)
            .postingDate(UPDATED_POSTING_DATE)
            .exchangeDate(UPDATED_EXCHANGE_DATE)
            .routingDate(UPDATED_ROUTING_DATE)
            .effectiveDate(UPDATED_EFFECTIVE_DATE)
            .customChargeDate(UPDATED_CUSTOM_CHARGE_DATE)
            .recptNo(UPDATED_RECPT_NO)
            .trxNoAdjust(UPDATED_TRX_NO_ADJUST)
            .trxNoAddedBy(UPDATED_TRX_NO_ADDED_BY)
            .trxNoAgainstPackage(UPDATED_TRX_NO_AGAINST_PACKAGE)
            .trxNoHeader(UPDATED_TRX_NO_HEADER)
            .arNumber(UPDATED_AR_NUMBER)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .cashierId(UPDATED_CASHIER_ID)
            .creditCardId(UPDATED_CREDIT_CARD_ID)
            .nameId(UPDATED_NAME_ID)
            .tranActionId(UPDATED_TRAN_ACTION_ID)
            .finDmlSeqNo(UPDATED_FIN_DML_SEQ_NO)
            .routingInstrnId(UPDATED_ROUTING_INSTRN_ID)
            .fromResvId(UPDATED_FROM_RESV_ID)
            .genCashierId(UPDATED_GEN_CASHIER_ID)
            .folioNo(UPDATED_FOLIO_NO)
            .invoiceNo(UPDATED_INVOICE_NO)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .arrangementId(UPDATED_ARRANGEMENT_ID)
            .trnsFromAcct(UPDATED_TRNS_FROM_ACCT)
            .trnsToAcct(UPDATED_TRNS_TO_ACCT)
            .billNo(UPDATED_BILL_NO)
            .revisionNo(UPDATED_REVISION_NO)
            .resvDepositId(UPDATED_RESV_DEPOSIT_ID)
            .linkTrxNo(UPDATED_LINK_TRX_NO)
            .authorizerId(UPDATED_AUTHORIZER_ID)
            .compLinkTrxNo(UPDATED_COMP_LINK_TRX_NO)
            .mtrxNoAgainstPackage(UPDATED_MTRX_NO_AGAINST_PACKAGE)
            .forexCommPerc(UPDATED_FOREX_COMM_PERC)
            .forexCommAmount(UPDATED_FOREX_COMM_AMOUNT)
            .articleId(UPDATED_ARTICLE_ID)
            .toResvNameId(UPDATED_TO_RESV_NAME_ID)
            .roomNts(UPDATED_ROOM_NTS)
            .orgArLedDebit(UPDATED_ORG_AR_LED_DEBIT)
            .closureNo(UPDATED_CLOSURE_NO)
            .originalResvNameId(UPDATED_ORIGINAL_RESV_NAME_ID)
            .orgBillNo(UPDATED_ORG_BILL_NO)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .installments(UPDATED_INSTALLMENTS)
            .contractGuestDebit(UPDATED_CONTRACT_GUEST_DEBIT)
            .contractGuestCredit(UPDATED_CONTRACT_GUEST_CREDIT)
            .contractNetAmount(UPDATED_CONTRACT_NET_AMOUNT)
            .contractGrossAmount(UPDATED_CONTRACT_GROSS_AMOUNT)
            .postitNo(UPDATED_POSTIT_NO)
            .ccTrxFeeAmount(UPDATED_CC_TRX_FEE_AMOUNT)
            .changeDue(UPDATED_CHANGE_DUE)
            .postingSourceNameId(UPDATED_POSTING_SOURCE_NAME_ID)
            .bonusCheckId(UPDATED_BONUS_CHECK_ID)
            .roundLinkTrxno(UPDATED_ROUND_LINK_TRXNO)
            .reversePaymentTrxNo(UPDATED_REVERSE_PAYMENT_TRX_NO)
            .electronicVoucherNo(UPDATED_ELECTRONIC_VOUCHER_NO)
            .thresholdDiversionId(UPDATED_THRESHOLD_DIVERSION_ID)
            .thresholdEntityQty(UPDATED_THRESHOLD_ENTITY_QTY)
            .trxNoSplit(UPDATED_TRX_NO_SPLIT)
            .exchDiffTrxNo(UPDATED_EXCH_DIFF_TRX_NO)
            .associatedTrxNo(UPDATED_ASSOCIATED_TRX_NO)
            .taxRate(UPDATED_TAX_RATE)
            .propChargeId(UPDATED_PROP_CHARGE_ID)
            .quantity(UPDATED_QUANTITY)
            .netAmount(UPDATED_NET_AMOUNT)
            .grossAmount(UPDATED_GROSS_AMOUNT)
            .cashierOpeningBalance(UPDATED_CASHIER_OPENING_BALANCE)
            .pricePerUnit(UPDATED_PRICE_PER_UNIT)
            .trxAmount(UPDATED_TRX_AMOUNT)
            .postedAmount(UPDATED_POSTED_AMOUNT)
            .guestAccountCredit(UPDATED_GUEST_ACCOUNT_CREDIT)
            .exchangeRate(UPDATED_EXCHANGE_RATE)
            .guestAccountDebit(UPDATED_GUEST_ACCOUNT_DEBIT)
            .cashierCredit(UPDATED_CASHIER_CREDIT)
            .cashierDebit(UPDATED_CASHIER_DEBIT)
            .packageCredit(UPDATED_PACKAGE_CREDIT)
            .packageDebit(UPDATED_PACKAGE_DEBIT)
            .depLedCredit(UPDATED_DEP_LED_CREDIT)
            .depLedDebit(UPDATED_DEP_LED_DEBIT)
            .revenueAmt(UPDATED_REVENUE_AMT)
            .arLedCredit(UPDATED_AR_LED_CREDIT)
            .arLedDebit(UPDATED_AR_LED_DEBIT)
            .euroExchangeRate(UPDATED_EURO_EXCHANGE_RATE)
            .inhDebit(UPDATED_INH_DEBIT)
            .inhCredit(UPDATED_INH_CREDIT)
            .packageAllowance(UPDATED_PACKAGE_ALLOWANCE)
            .parallelGuestCredit(UPDATED_PARALLEL_GUEST_CREDIT)
            .parallelGuestDebit(UPDATED_PARALLEL_GUEST_DEBIT)
            .parallelNetAmount(UPDATED_PARALLEL_NET_AMOUNT)
            .parallelGrossAmount(UPDATED_PARALLEL_GROSS_AMOUNT)
            .orgPostedAmount(UPDATED_ORG_POSTED_AMOUNT)
            .roomNtsEffective(UPDATED_ROOM_NTS_EFFECTIVE)
            .paymentSurchargeAmt(UPDATED_PAYMENT_SURCHARGE_AMT)
            .folioView(UPDATED_FOLIO_VIEW)
            .taxInclusiveYn(UPDATED_TAX_INCLUSIVE_YN)
            .deferredYn(UPDATED_DEFERRED_YN)
            .indAdjustmentYn(UPDATED_IND_ADJUSTMENT_YN)
            .fixedChargesYn(UPDATED_FIXED_CHARGES_YN)
            .taCommissionableYn(UPDATED_TA_COMMISSIONABLE_YN)
            .taxGeneratedYn(UPDATED_TAX_GENERATED_YN)
            .compressedYn(UPDATED_COMPRESSED_YN)
            .displayYn(UPDATED_DISPLAY_YN)
            .collAgentPostingYn(UPDATED_COLL_AGENT_POSTING_YN)
            .fiscalTrxCodeType(UPDATED_FISCAL_TRX_CODE_TYPE)
            .deferredTaxesYn(UPDATED_DEFERRED_TAXES_YN)
            .advancedGenerateYn(UPDATED_ADVANCED_GENERATE_YN)
            .forexType(UPDATED_FOREX_TYPE)
            .taCommissionNetYn(UPDATED_TA_COMMISSION_NET_YN)
            .sourceCommissionNetYn(UPDATED_SOURCE_COMMISSION_NET_YN)
            .settlementFlag(UPDATED_SETTLEMENT_FLAG)
            .accTypeFlag(UPDATED_ACC_TYPE_FLAG)
            .profitLossFlag(UPDATED_PROFIT_LOSS_FLAG)
            .proformaYn(UPDATED_PROFORMA_YN)
            .holdYn(UPDATED_HOLD_YN)
            .exchangeDifferenceYn(UPDATED_EXCHANGE_DIFFERENCE_YN)
            .calcPointsYn(UPDATED_CALC_POINTS_YN)
            .arChargeTransferYn(UPDATED_AR_CHARGE_TRANSFER_YN)
            .processed8300Yn(UPDATED_PROCESSED_8300_YN)
            .asbFlag(UPDATED_ASB_FLAG)
            .postitYn(UPDATED_POSTIT_YN)
            .autoSettleYn(UPDATED_AUTO_SETTLE_YN)
            .depTaxTransferedYn(UPDATED_DEP_TAX_TRANSFERED_YN)
            .autoCreditbillYn(UPDATED_AUTO_CREDITBILL_YN)
            .asbOnlyPostTaxesOnceYn(UPDATED_ASB_ONLY_POST_TAXES_ONCE_YN)
            .roundFactorYn(UPDATED_ROUND_FACTOR_YN)
            .depPostingFlag(UPDATED_DEP_POSTING_FLAG)
            .correctionYn(UPDATED_CORRECTION_YN)
            .routedYn(UPDATED_ROUTED_YN)
            .upsellChargeYn(UPDATED_UPSELL_CHARGE_YN)
            .advanceBillYn(UPDATED_ADVANCE_BILL_YN)
            .advanceBillReversedYn(UPDATED_ADVANCE_BILL_REVERSED_YN)
            .incTaxDeductedYn(UPDATED_INC_TAX_DEDUCTED_YN)
            .gpAwardCancelledYn(UPDATED_GP_AWARD_CANCELLED_YN)
            .serviceRecoveryAdjustmentYn(UPDATED_SERVICE_RECOVERY_ADJUSTMENT_YN)
            .splitType(UPDATED_SPLIT_TYPE)
            .bucketRedempYn(UPDATED_BUCKET_REDEMP_YN)
            .vatOffsetYn(UPDATED_VAT_OFFSET_YN)
            .forexTaxYn(UPDATED_FOREX_TAX_YN)
            .stampDutyYn(UPDATED_STAMP_DUTY_YN)
            .covers(UPDATED_COVERS)
            .advGenerateAdjustment(UPDATED_ADV_GENERATE_ADJUSTMENT)
            .expInvoiceType(UPDATED_EXP_INVOICE_TYPE)
            .folioType(UPDATED_FOLIO_TYPE)
            .orgFolioType(UPDATED_ORG_FOLIO_TYPE)
            .invoiceType(UPDATED_INVOICE_TYPE)
            .arState(UPDATED_AR_STATE)
            .exchangeType(UPDATED_EXCHANGE_TYPE)
            .recptType(UPDATED_RECPT_TYPE)
            .roomClass(UPDATED_ROOM_CLASS)
            .resort(UPDATED_RESORT)
            .tcGroup(UPDATED_TC_GROUP)
            .tcSubgroup(UPDATED_TC_SUBGROUP)
            .trxCode(UPDATED_TRX_CODE)
            .room(UPDATED_ROOM)
            .tclCode1(UPDATED_TCL_CODE_1)
            .currency(UPDATED_CURRENCY)
            .ftGeneratedType(UPDATED_FT_GENERATED_TYPE)
            .tclCode2(UPDATED_TCL_CODE_2)
            .marketCode(UPDATED_MARKET_CODE)
            .sourceCode(UPDATED_SOURCE_CODE)
            .rateCode(UPDATED_RATE_CODE)
            .hotelAcct(UPDATED_HOTEL_ACCT)
            .reasonCode(UPDATED_REASON_CODE)
            .product(UPDATED_PRODUCT)
            .targetResort(UPDATED_TARGET_RESORT)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .taxInvNo(UPDATED_TAX_INV_NO)
            .approvalCode(UPDATED_APPROVAL_CODE)
            .approvalStatus(UPDATED_APPROVAL_STATUS)
            .compLinkTrxCode(UPDATED_COMP_LINK_TRX_CODE)
            .compTypeCode(UPDATED_COMP_TYPE_CODE)
            .couponNo(UPDATED_COUPON_NO)
            .originalRoom(UPDATED_ORIGINAL_ROOM)
            .allowanceType(UPDATED_ALLOWANCE_TYPE)
            .advGenerateTrxCode(UPDATED_ADV_GENERATE_TRX_CODE)
            .trxServiceType(UPDATED_TRX_SERVICE_TYPE)
            .postingType(UPDATED_POSTING_TYPE)
            .parallelCurrency(UPDATED_PARALLEL_CURRENCY)
            .contractCurrency(UPDATED_CONTRACT_CURRENCY)
            .fbaCertificateNumber(UPDATED_FBA_CERTIFICATE_NUMBER)
            .postingRhythm(UPDATED_POSTING_RHYTHM)
            .asbTaxFlag(UPDATED_ASB_TAX_FLAG)
            .packageArrangementCode(UPDATED_PACKAGE_ARRANGEMENT_CODE)
            .gpAwardCode(UPDATED_GP_AWARD_CODE)
            .gpAwardCancelCode(UPDATED_GP_AWARD_CANCEL_CODE)
            .serviceRecoveryDeptCode(UPDATED_SERVICE_RECOVERY_DEPT_CODE)
            .bucketCode(UPDATED_BUCKET_CODE)
            .taxRateType(UPDATED_TAX_RATE_TYPE)
            .chequeNumber(UPDATED_CHEQUE_NUMBER)
            .passerByName(UPDATED_PASSER_BY_NAME)
            .esignedReceiptName(UPDATED_ESIGNED_RECEIPT_NAME)
            .remark(UPDATED_REMARK)
            .reference(UPDATED_REFERENCE)
            .oTrxDesc(UPDATED_O_TRX_DESC)
            .comments(UPDATED_COMMENTS)
            .fiscalBillNo(UPDATED_FISCAL_BILL_NO)
            .extSysResultMsg(UPDATED_EXT_SYS_RESULT_MSG)
            .queueName(UPDATED_QUEUE_NAME)
            .paymentType(UPDATED_PAYMENT_TYPE)
            .ccRefundPosting(UPDATED_CC_REFUND_POSTING)
            .thresholdEntityType(UPDATED_THRESHOLD_ENTITY_TYPE)
            .thresholdTreatmentFlag(UPDATED_THRESHOLD_TREATMENT_FLAG)
            .paymentSurchargeType(UPDATED_PAYMENT_SURCHARGE_TYPE)
            .propertyBillPrefix(UPDATED_PROPERTY_BILL_PREFIX)
            .taxElements(UPDATED_TAX_ELEMENTS)
            .numberDialed(UPDATED_NUMBER_DIALED)
            .checkFileId(UPDATED_CHECK_FILE_ID)
            .extTrxId(UPDATED_EXT_TRX_ID)
            .packageTrxType(UPDATED_PACKAGE_TRX_TYPE)
            .expOriginalInvoice(UPDATED_EXP_ORIGINAL_INVOICE)
            .depositTransactionId(UPDATED_DEPOSIT_TRANSACTION_ID);

        restFinancialTransactionsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedFinancialTransactions.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedFinancialTransactions))
            )
            .andExpect(status().isOk());

        // Validate the FinancialTransactions in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedFinancialTransactionsToMatchAllProperties(updatedFinancialTransactions);
    }

    @Test
    @Transactional
    void putNonExistingFinancialTransactions() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        financialTransactions.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFinancialTransactionsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, financialTransactions.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(financialTransactions))
            )
            .andExpect(status().isBadRequest());

        // Validate the FinancialTransactions in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchFinancialTransactions() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        financialTransactions.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFinancialTransactionsMockMvc
            .perform(
                put(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(financialTransactions))
            )
            .andExpect(status().isBadRequest());

        // Validate the FinancialTransactions in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamFinancialTransactions() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        financialTransactions.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFinancialTransactionsMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(financialTransactions)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the FinancialTransactions in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateFinancialTransactionsWithPatch() throws Exception {
        // Initialize the database
        financialTransactionsRepository.saveAndFlush(financialTransactions);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the financialTransactions using partial update
        FinancialTransactions partialUpdatedFinancialTransactions = new FinancialTransactions();
        partialUpdatedFinancialTransactions.setId(financialTransactions.getId());

        partialUpdatedFinancialTransactions
            .trxNo(UPDATED_TRX_NO)
            .trxDate(UPDATED_TRX_DATE)
            .businessDate(UPDATED_BUSINESS_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .approvalDate(UPDATED_APPROVAL_DATE)
            .effectiveDate(UPDATED_EFFECTIVE_DATE)
            .recptNo(UPDATED_RECPT_NO)
            .trxNoAddedBy(UPDATED_TRX_NO_ADDED_BY)
            .trxNoAgainstPackage(UPDATED_TRX_NO_AGAINST_PACKAGE)
            .arNumber(UPDATED_AR_NUMBER)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .nameId(UPDATED_NAME_ID)
            .tranActionId(UPDATED_TRAN_ACTION_ID)
            .finDmlSeqNo(UPDATED_FIN_DML_SEQ_NO)
            .routingInstrnId(UPDATED_ROUTING_INSTRN_ID)
            .folioNo(UPDATED_FOLIO_NO)
            .trnsFromAcct(UPDATED_TRNS_FROM_ACCT)
            .revisionNo(UPDATED_REVISION_NO)
            .authorizerId(UPDATED_AUTHORIZER_ID)
            .compLinkTrxNo(UPDATED_COMP_LINK_TRX_NO)
            .mtrxNoAgainstPackage(UPDATED_MTRX_NO_AGAINST_PACKAGE)
            .forexCommPerc(UPDATED_FOREX_COMM_PERC)
            .forexCommAmount(UPDATED_FOREX_COMM_AMOUNT)
            .articleId(UPDATED_ARTICLE_ID)
            .toResvNameId(UPDATED_TO_RESV_NAME_ID)
            .orgArLedDebit(UPDATED_ORG_AR_LED_DEBIT)
            .contractNetAmount(UPDATED_CONTRACT_NET_AMOUNT)
            .ccTrxFeeAmount(UPDATED_CC_TRX_FEE_AMOUNT)
            .roundLinkTrxno(UPDATED_ROUND_LINK_TRXNO)
            .reversePaymentTrxNo(UPDATED_REVERSE_PAYMENT_TRX_NO)
            .electronicVoucherNo(UPDATED_ELECTRONIC_VOUCHER_NO)
            .thresholdDiversionId(UPDATED_THRESHOLD_DIVERSION_ID)
            .taxRate(UPDATED_TAX_RATE)
            .quantity(UPDATED_QUANTITY)
            .netAmount(UPDATED_NET_AMOUNT)
            .grossAmount(UPDATED_GROSS_AMOUNT)
            .postedAmount(UPDATED_POSTED_AMOUNT)
            .guestAccountCredit(UPDATED_GUEST_ACCOUNT_CREDIT)
            .guestAccountDebit(UPDATED_GUEST_ACCOUNT_DEBIT)
            .cashierCredit(UPDATED_CASHIER_CREDIT)
            .cashierDebit(UPDATED_CASHIER_DEBIT)
            .packageDebit(UPDATED_PACKAGE_DEBIT)
            .depLedCredit(UPDATED_DEP_LED_CREDIT)
            .revenueAmt(UPDATED_REVENUE_AMT)
            .arLedCredit(UPDATED_AR_LED_CREDIT)
            .arLedDebit(UPDATED_AR_LED_DEBIT)
            .inhCredit(UPDATED_INH_CREDIT)
            .parallelNetAmount(UPDATED_PARALLEL_NET_AMOUNT)
            .parallelGrossAmount(UPDATED_PARALLEL_GROSS_AMOUNT)
            .orgPostedAmount(UPDATED_ORG_POSTED_AMOUNT)
            .roomNtsEffective(UPDATED_ROOM_NTS_EFFECTIVE)
            .indAdjustmentYn(UPDATED_IND_ADJUSTMENT_YN)
            .taCommissionableYn(UPDATED_TA_COMMISSIONABLE_YN)
            .compressedYn(UPDATED_COMPRESSED_YN)
            .displayYn(UPDATED_DISPLAY_YN)
            .collAgentPostingYn(UPDATED_COLL_AGENT_POSTING_YN)
            .fiscalTrxCodeType(UPDATED_FISCAL_TRX_CODE_TYPE)
            .settlementFlag(UPDATED_SETTLEMENT_FLAG)
            .accTypeFlag(UPDATED_ACC_TYPE_FLAG)
            .exchangeDifferenceYn(UPDATED_EXCHANGE_DIFFERENCE_YN)
            .postitYn(UPDATED_POSTIT_YN)
            .correctionYn(UPDATED_CORRECTION_YN)
            .gpAwardCancelledYn(UPDATED_GP_AWARD_CANCELLED_YN)
            .serviceRecoveryAdjustmentYn(UPDATED_SERVICE_RECOVERY_ADJUSTMENT_YN)
            .stampDutyYn(UPDATED_STAMP_DUTY_YN)
            .covers(UPDATED_COVERS)
            .advGenerateAdjustment(UPDATED_ADV_GENERATE_ADJUSTMENT)
            .folioType(UPDATED_FOLIO_TYPE)
            .exchangeType(UPDATED_EXCHANGE_TYPE)
            .recptType(UPDATED_RECPT_TYPE)
            .resort(UPDATED_RESORT)
            .room(UPDATED_ROOM)
            .ftGeneratedType(UPDATED_FT_GENERATED_TYPE)
            .tclCode2(UPDATED_TCL_CODE_2)
            .rateCode(UPDATED_RATE_CODE)
            .reasonCode(UPDATED_REASON_CODE)
            .targetResort(UPDATED_TARGET_RESORT)
            .taxInvNo(UPDATED_TAX_INV_NO)
            .approvalCode(UPDATED_APPROVAL_CODE)
            .originalRoom(UPDATED_ORIGINAL_ROOM)
            .allowanceType(UPDATED_ALLOWANCE_TYPE)
            .advGenerateTrxCode(UPDATED_ADV_GENERATE_TRX_CODE)
            .trxServiceType(UPDATED_TRX_SERVICE_TYPE)
            .parallelCurrency(UPDATED_PARALLEL_CURRENCY)
            .fbaCertificateNumber(UPDATED_FBA_CERTIFICATE_NUMBER)
            .postingRhythm(UPDATED_POSTING_RHYTHM)
            .gpAwardCode(UPDATED_GP_AWARD_CODE)
            .taxRateType(UPDATED_TAX_RATE_TYPE)
            .passerByName(UPDATED_PASSER_BY_NAME)
            .oTrxDesc(UPDATED_O_TRX_DESC)
            .comments(UPDATED_COMMENTS)
            .propertyBillPrefix(UPDATED_PROPERTY_BILL_PREFIX)
            .taxElements(UPDATED_TAX_ELEMENTS)
            .numberDialed(UPDATED_NUMBER_DIALED)
            .checkFileId(UPDATED_CHECK_FILE_ID)
            .extTrxId(UPDATED_EXT_TRX_ID)
            .packageTrxType(UPDATED_PACKAGE_TRX_TYPE)
            .expOriginalInvoice(UPDATED_EXP_ORIGINAL_INVOICE);

        restFinancialTransactionsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFinancialTransactions.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedFinancialTransactions))
            )
            .andExpect(status().isOk());

        // Validate the FinancialTransactions in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertFinancialTransactionsUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedFinancialTransactions, financialTransactions),
            getPersistedFinancialTransactions(financialTransactions)
        );
    }

    @Test
    @Transactional
    void fullUpdateFinancialTransactionsWithPatch() throws Exception {
        // Initialize the database
        financialTransactionsRepository.saveAndFlush(financialTransactions);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the financialTransactions using partial update
        FinancialTransactions partialUpdatedFinancialTransactions = new FinancialTransactions();
        partialUpdatedFinancialTransactions.setId(financialTransactions.getId());

        partialUpdatedFinancialTransactions
            .trxNo(UPDATED_TRX_NO)
            .ftSubtype(UPDATED_FT_SUBTYPE)
            .invoiceCloseDate(UPDATED_INVOICE_CLOSE_DATE)
            .arTransferDate(UPDATED_AR_TRANSFER_DATE)
            .trxDate(UPDATED_TRX_DATE)
            .businessDate(UPDATED_BUSINESS_DATE)
            .insertDate(UPDATED_INSERT_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .trnsActivityDate(UPDATED_TRNS_ACTIVITY_DATE)
            .approvalDate(UPDATED_APPROVAL_DATE)
            .postingDate(UPDATED_POSTING_DATE)
            .exchangeDate(UPDATED_EXCHANGE_DATE)
            .routingDate(UPDATED_ROUTING_DATE)
            .effectiveDate(UPDATED_EFFECTIVE_DATE)
            .customChargeDate(UPDATED_CUSTOM_CHARGE_DATE)
            .recptNo(UPDATED_RECPT_NO)
            .trxNoAdjust(UPDATED_TRX_NO_ADJUST)
            .trxNoAddedBy(UPDATED_TRX_NO_ADDED_BY)
            .trxNoAgainstPackage(UPDATED_TRX_NO_AGAINST_PACKAGE)
            .trxNoHeader(UPDATED_TRX_NO_HEADER)
            .arNumber(UPDATED_AR_NUMBER)
            .resvNameId(UPDATED_RESV_NAME_ID)
            .cashierId(UPDATED_CASHIER_ID)
            .creditCardId(UPDATED_CREDIT_CARD_ID)
            .nameId(UPDATED_NAME_ID)
            .tranActionId(UPDATED_TRAN_ACTION_ID)
            .finDmlSeqNo(UPDATED_FIN_DML_SEQ_NO)
            .routingInstrnId(UPDATED_ROUTING_INSTRN_ID)
            .fromResvId(UPDATED_FROM_RESV_ID)
            .genCashierId(UPDATED_GEN_CASHIER_ID)
            .folioNo(UPDATED_FOLIO_NO)
            .invoiceNo(UPDATED_INVOICE_NO)
            .insertUser(UPDATED_INSERT_USER)
            .updateUser(UPDATED_UPDATE_USER)
            .arrangementId(UPDATED_ARRANGEMENT_ID)
            .trnsFromAcct(UPDATED_TRNS_FROM_ACCT)
            .trnsToAcct(UPDATED_TRNS_TO_ACCT)
            .billNo(UPDATED_BILL_NO)
            .revisionNo(UPDATED_REVISION_NO)
            .resvDepositId(UPDATED_RESV_DEPOSIT_ID)
            .linkTrxNo(UPDATED_LINK_TRX_NO)
            .authorizerId(UPDATED_AUTHORIZER_ID)
            .compLinkTrxNo(UPDATED_COMP_LINK_TRX_NO)
            .mtrxNoAgainstPackage(UPDATED_MTRX_NO_AGAINST_PACKAGE)
            .forexCommPerc(UPDATED_FOREX_COMM_PERC)
            .forexCommAmount(UPDATED_FOREX_COMM_AMOUNT)
            .articleId(UPDATED_ARTICLE_ID)
            .toResvNameId(UPDATED_TO_RESV_NAME_ID)
            .roomNts(UPDATED_ROOM_NTS)
            .orgArLedDebit(UPDATED_ORG_AR_LED_DEBIT)
            .closureNo(UPDATED_CLOSURE_NO)
            .originalResvNameId(UPDATED_ORIGINAL_RESV_NAME_ID)
            .orgBillNo(UPDATED_ORG_BILL_NO)
            .membershipId(UPDATED_MEMBERSHIP_ID)
            .installments(UPDATED_INSTALLMENTS)
            .contractGuestDebit(UPDATED_CONTRACT_GUEST_DEBIT)
            .contractGuestCredit(UPDATED_CONTRACT_GUEST_CREDIT)
            .contractNetAmount(UPDATED_CONTRACT_NET_AMOUNT)
            .contractGrossAmount(UPDATED_CONTRACT_GROSS_AMOUNT)
            .postitNo(UPDATED_POSTIT_NO)
            .ccTrxFeeAmount(UPDATED_CC_TRX_FEE_AMOUNT)
            .changeDue(UPDATED_CHANGE_DUE)
            .postingSourceNameId(UPDATED_POSTING_SOURCE_NAME_ID)
            .bonusCheckId(UPDATED_BONUS_CHECK_ID)
            .roundLinkTrxno(UPDATED_ROUND_LINK_TRXNO)
            .reversePaymentTrxNo(UPDATED_REVERSE_PAYMENT_TRX_NO)
            .electronicVoucherNo(UPDATED_ELECTRONIC_VOUCHER_NO)
            .thresholdDiversionId(UPDATED_THRESHOLD_DIVERSION_ID)
            .thresholdEntityQty(UPDATED_THRESHOLD_ENTITY_QTY)
            .trxNoSplit(UPDATED_TRX_NO_SPLIT)
            .exchDiffTrxNo(UPDATED_EXCH_DIFF_TRX_NO)
            .associatedTrxNo(UPDATED_ASSOCIATED_TRX_NO)
            .taxRate(UPDATED_TAX_RATE)
            .propChargeId(UPDATED_PROP_CHARGE_ID)
            .quantity(UPDATED_QUANTITY)
            .netAmount(UPDATED_NET_AMOUNT)
            .grossAmount(UPDATED_GROSS_AMOUNT)
            .cashierOpeningBalance(UPDATED_CASHIER_OPENING_BALANCE)
            .pricePerUnit(UPDATED_PRICE_PER_UNIT)
            .trxAmount(UPDATED_TRX_AMOUNT)
            .postedAmount(UPDATED_POSTED_AMOUNT)
            .guestAccountCredit(UPDATED_GUEST_ACCOUNT_CREDIT)
            .exchangeRate(UPDATED_EXCHANGE_RATE)
            .guestAccountDebit(UPDATED_GUEST_ACCOUNT_DEBIT)
            .cashierCredit(UPDATED_CASHIER_CREDIT)
            .cashierDebit(UPDATED_CASHIER_DEBIT)
            .packageCredit(UPDATED_PACKAGE_CREDIT)
            .packageDebit(UPDATED_PACKAGE_DEBIT)
            .depLedCredit(UPDATED_DEP_LED_CREDIT)
            .depLedDebit(UPDATED_DEP_LED_DEBIT)
            .revenueAmt(UPDATED_REVENUE_AMT)
            .arLedCredit(UPDATED_AR_LED_CREDIT)
            .arLedDebit(UPDATED_AR_LED_DEBIT)
            .euroExchangeRate(UPDATED_EURO_EXCHANGE_RATE)
            .inhDebit(UPDATED_INH_DEBIT)
            .inhCredit(UPDATED_INH_CREDIT)
            .packageAllowance(UPDATED_PACKAGE_ALLOWANCE)
            .parallelGuestCredit(UPDATED_PARALLEL_GUEST_CREDIT)
            .parallelGuestDebit(UPDATED_PARALLEL_GUEST_DEBIT)
            .parallelNetAmount(UPDATED_PARALLEL_NET_AMOUNT)
            .parallelGrossAmount(UPDATED_PARALLEL_GROSS_AMOUNT)
            .orgPostedAmount(UPDATED_ORG_POSTED_AMOUNT)
            .roomNtsEffective(UPDATED_ROOM_NTS_EFFECTIVE)
            .paymentSurchargeAmt(UPDATED_PAYMENT_SURCHARGE_AMT)
            .folioView(UPDATED_FOLIO_VIEW)
            .taxInclusiveYn(UPDATED_TAX_INCLUSIVE_YN)
            .deferredYn(UPDATED_DEFERRED_YN)
            .indAdjustmentYn(UPDATED_IND_ADJUSTMENT_YN)
            .fixedChargesYn(UPDATED_FIXED_CHARGES_YN)
            .taCommissionableYn(UPDATED_TA_COMMISSIONABLE_YN)
            .taxGeneratedYn(UPDATED_TAX_GENERATED_YN)
            .compressedYn(UPDATED_COMPRESSED_YN)
            .displayYn(UPDATED_DISPLAY_YN)
            .collAgentPostingYn(UPDATED_COLL_AGENT_POSTING_YN)
            .fiscalTrxCodeType(UPDATED_FISCAL_TRX_CODE_TYPE)
            .deferredTaxesYn(UPDATED_DEFERRED_TAXES_YN)
            .advancedGenerateYn(UPDATED_ADVANCED_GENERATE_YN)
            .forexType(UPDATED_FOREX_TYPE)
            .taCommissionNetYn(UPDATED_TA_COMMISSION_NET_YN)
            .sourceCommissionNetYn(UPDATED_SOURCE_COMMISSION_NET_YN)
            .settlementFlag(UPDATED_SETTLEMENT_FLAG)
            .accTypeFlag(UPDATED_ACC_TYPE_FLAG)
            .profitLossFlag(UPDATED_PROFIT_LOSS_FLAG)
            .proformaYn(UPDATED_PROFORMA_YN)
            .holdYn(UPDATED_HOLD_YN)
            .exchangeDifferenceYn(UPDATED_EXCHANGE_DIFFERENCE_YN)
            .calcPointsYn(UPDATED_CALC_POINTS_YN)
            .arChargeTransferYn(UPDATED_AR_CHARGE_TRANSFER_YN)
            .processed8300Yn(UPDATED_PROCESSED_8300_YN)
            .asbFlag(UPDATED_ASB_FLAG)
            .postitYn(UPDATED_POSTIT_YN)
            .autoSettleYn(UPDATED_AUTO_SETTLE_YN)
            .depTaxTransferedYn(UPDATED_DEP_TAX_TRANSFERED_YN)
            .autoCreditbillYn(UPDATED_AUTO_CREDITBILL_YN)
            .asbOnlyPostTaxesOnceYn(UPDATED_ASB_ONLY_POST_TAXES_ONCE_YN)
            .roundFactorYn(UPDATED_ROUND_FACTOR_YN)
            .depPostingFlag(UPDATED_DEP_POSTING_FLAG)
            .correctionYn(UPDATED_CORRECTION_YN)
            .routedYn(UPDATED_ROUTED_YN)
            .upsellChargeYn(UPDATED_UPSELL_CHARGE_YN)
            .advanceBillYn(UPDATED_ADVANCE_BILL_YN)
            .advanceBillReversedYn(UPDATED_ADVANCE_BILL_REVERSED_YN)
            .incTaxDeductedYn(UPDATED_INC_TAX_DEDUCTED_YN)
            .gpAwardCancelledYn(UPDATED_GP_AWARD_CANCELLED_YN)
            .serviceRecoveryAdjustmentYn(UPDATED_SERVICE_RECOVERY_ADJUSTMENT_YN)
            .splitType(UPDATED_SPLIT_TYPE)
            .bucketRedempYn(UPDATED_BUCKET_REDEMP_YN)
            .vatOffsetYn(UPDATED_VAT_OFFSET_YN)
            .forexTaxYn(UPDATED_FOREX_TAX_YN)
            .stampDutyYn(UPDATED_STAMP_DUTY_YN)
            .covers(UPDATED_COVERS)
            .advGenerateAdjustment(UPDATED_ADV_GENERATE_ADJUSTMENT)
            .expInvoiceType(UPDATED_EXP_INVOICE_TYPE)
            .folioType(UPDATED_FOLIO_TYPE)
            .orgFolioType(UPDATED_ORG_FOLIO_TYPE)
            .invoiceType(UPDATED_INVOICE_TYPE)
            .arState(UPDATED_AR_STATE)
            .exchangeType(UPDATED_EXCHANGE_TYPE)
            .recptType(UPDATED_RECPT_TYPE)
            .roomClass(UPDATED_ROOM_CLASS)
            .resort(UPDATED_RESORT)
            .tcGroup(UPDATED_TC_GROUP)
            .tcSubgroup(UPDATED_TC_SUBGROUP)
            .trxCode(UPDATED_TRX_CODE)
            .room(UPDATED_ROOM)
            .tclCode1(UPDATED_TCL_CODE_1)
            .currency(UPDATED_CURRENCY)
            .ftGeneratedType(UPDATED_FT_GENERATED_TYPE)
            .tclCode2(UPDATED_TCL_CODE_2)
            .marketCode(UPDATED_MARKET_CODE)
            .sourceCode(UPDATED_SOURCE_CODE)
            .rateCode(UPDATED_RATE_CODE)
            .hotelAcct(UPDATED_HOTEL_ACCT)
            .reasonCode(UPDATED_REASON_CODE)
            .product(UPDATED_PRODUCT)
            .targetResort(UPDATED_TARGET_RESORT)
            .nameTaxType(UPDATED_NAME_TAX_TYPE)
            .taxInvNo(UPDATED_TAX_INV_NO)
            .approvalCode(UPDATED_APPROVAL_CODE)
            .approvalStatus(UPDATED_APPROVAL_STATUS)
            .compLinkTrxCode(UPDATED_COMP_LINK_TRX_CODE)
            .compTypeCode(UPDATED_COMP_TYPE_CODE)
            .couponNo(UPDATED_COUPON_NO)
            .originalRoom(UPDATED_ORIGINAL_ROOM)
            .allowanceType(UPDATED_ALLOWANCE_TYPE)
            .advGenerateTrxCode(UPDATED_ADV_GENERATE_TRX_CODE)
            .trxServiceType(UPDATED_TRX_SERVICE_TYPE)
            .postingType(UPDATED_POSTING_TYPE)
            .parallelCurrency(UPDATED_PARALLEL_CURRENCY)
            .contractCurrency(UPDATED_CONTRACT_CURRENCY)
            .fbaCertificateNumber(UPDATED_FBA_CERTIFICATE_NUMBER)
            .postingRhythm(UPDATED_POSTING_RHYTHM)
            .asbTaxFlag(UPDATED_ASB_TAX_FLAG)
            .packageArrangementCode(UPDATED_PACKAGE_ARRANGEMENT_CODE)
            .gpAwardCode(UPDATED_GP_AWARD_CODE)
            .gpAwardCancelCode(UPDATED_GP_AWARD_CANCEL_CODE)
            .serviceRecoveryDeptCode(UPDATED_SERVICE_RECOVERY_DEPT_CODE)
            .bucketCode(UPDATED_BUCKET_CODE)
            .taxRateType(UPDATED_TAX_RATE_TYPE)
            .chequeNumber(UPDATED_CHEQUE_NUMBER)
            .passerByName(UPDATED_PASSER_BY_NAME)
            .esignedReceiptName(UPDATED_ESIGNED_RECEIPT_NAME)
            .remark(UPDATED_REMARK)
            .reference(UPDATED_REFERENCE)
            .oTrxDesc(UPDATED_O_TRX_DESC)
            .comments(UPDATED_COMMENTS)
            .fiscalBillNo(UPDATED_FISCAL_BILL_NO)
            .extSysResultMsg(UPDATED_EXT_SYS_RESULT_MSG)
            .queueName(UPDATED_QUEUE_NAME)
            .paymentType(UPDATED_PAYMENT_TYPE)
            .ccRefundPosting(UPDATED_CC_REFUND_POSTING)
            .thresholdEntityType(UPDATED_THRESHOLD_ENTITY_TYPE)
            .thresholdTreatmentFlag(UPDATED_THRESHOLD_TREATMENT_FLAG)
            .paymentSurchargeType(UPDATED_PAYMENT_SURCHARGE_TYPE)
            .propertyBillPrefix(UPDATED_PROPERTY_BILL_PREFIX)
            .taxElements(UPDATED_TAX_ELEMENTS)
            .numberDialed(UPDATED_NUMBER_DIALED)
            .checkFileId(UPDATED_CHECK_FILE_ID)
            .extTrxId(UPDATED_EXT_TRX_ID)
            .packageTrxType(UPDATED_PACKAGE_TRX_TYPE)
            .expOriginalInvoice(UPDATED_EXP_ORIGINAL_INVOICE)
            .depositTransactionId(UPDATED_DEPOSIT_TRANSACTION_ID);

        restFinancialTransactionsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFinancialTransactions.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedFinancialTransactions))
            )
            .andExpect(status().isOk());

        // Validate the FinancialTransactions in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertFinancialTransactionsUpdatableFieldsEquals(
            partialUpdatedFinancialTransactions,
            getPersistedFinancialTransactions(partialUpdatedFinancialTransactions)
        );
    }

    @Test
    @Transactional
    void patchNonExistingFinancialTransactions() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        financialTransactions.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFinancialTransactionsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, financialTransactions.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(financialTransactions))
            )
            .andExpect(status().isBadRequest());

        // Validate the FinancialTransactions in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchFinancialTransactions() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        financialTransactions.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFinancialTransactionsMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(financialTransactions))
            )
            .andExpect(status().isBadRequest());

        // Validate the FinancialTransactions in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamFinancialTransactions() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        financialTransactions.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFinancialTransactionsMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(financialTransactions)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the FinancialTransactions in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteFinancialTransactions() throws Exception {
        // Initialize the database
        financialTransactionsRepository.saveAndFlush(financialTransactions);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the financialTransactions
        restFinancialTransactionsMockMvc
            .perform(delete(ENTITY_API_URL_ID, financialTransactions.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return financialTransactionsRepository.count();
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

    protected FinancialTransactions getPersistedFinancialTransactions(FinancialTransactions financialTransactions) {
        return financialTransactionsRepository.findById(financialTransactions.getId()).orElseThrow();
    }

    protected void assertPersistedFinancialTransactionsToMatchAllProperties(FinancialTransactions expectedFinancialTransactions) {
        assertFinancialTransactionsAllPropertiesEquals(
            expectedFinancialTransactions,
            getPersistedFinancialTransactions(expectedFinancialTransactions)
        );
    }

    protected void assertPersistedFinancialTransactionsToMatchUpdatableProperties(FinancialTransactions expectedFinancialTransactions) {
        assertFinancialTransactionsAllUpdatablePropertiesEquals(
            expectedFinancialTransactions,
            getPersistedFinancialTransactions(expectedFinancialTransactions)
        );
    }
}
