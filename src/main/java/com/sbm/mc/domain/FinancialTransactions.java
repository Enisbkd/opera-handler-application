package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A FinancialTransactions.
 */
@Entity
@Table(name = "financial_transactions")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class FinancialTransactions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "trx_no")
    private Integer trxNo;

    @Column(name = "ft_subtype")
    private String ftSubtype;

    @Column(name = "invoice_close_date")
    private LocalDate invoiceCloseDate;

    @Column(name = "ar_transfer_date")
    private LocalDate arTransferDate;

    @Column(name = "trx_date")
    private LocalDate trxDate;

    @Column(name = "business_date")
    private LocalDate businessDate;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "trns_activity_date")
    private LocalDate trnsActivityDate;

    @Column(name = "approval_date")
    private LocalDate approvalDate;

    @Column(name = "posting_date")
    private LocalDate postingDate;

    @Column(name = "exchange_date")
    private LocalDate exchangeDate;

    @Column(name = "routing_date")
    private LocalDate routingDate;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "custom_charge_date")
    private LocalDate customChargeDate;

    @Column(name = "recpt_no")
    private Integer recptNo;

    @Column(name = "trx_no_adjust")
    private Integer trxNoAdjust;

    @Column(name = "trx_no_added_by")
    private Integer trxNoAddedBy;

    @Column(name = "trx_no_against_package")
    private Integer trxNoAgainstPackage;

    @Column(name = "trx_no_header")
    private Integer trxNoHeader;

    @Column(name = "ar_number")
    private Integer arNumber;

    @Column(name = "resv_name_id")
    private Integer resvNameId;

    @Column(name = "cashier_id")
    private Integer cashierId;

    @Column(name = "credit_card_id")
    private Integer creditCardId;

    @Column(name = "name_id")
    private Integer nameId;

    @Column(name = "tran_action_id")
    private Integer tranActionId;

    @Column(name = "fin_dml_seq_no")
    private Integer finDmlSeqNo;

    @Column(name = "routing_instrn_id")
    private Integer routingInstrnId;

    @Column(name = "from_resv_id")
    private Integer fromResvId;

    @Column(name = "gen_cashier_id")
    private Integer genCashierId;

    @Column(name = "folio_no")
    private Integer folioNo;

    @Column(name = "invoice_no")
    private Integer invoiceNo;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "arrangement_id")
    private Integer arrangementId;

    @Column(name = "trns_from_acct")
    private Integer trnsFromAcct;

    @Column(name = "trns_to_acct")
    private Integer trnsToAcct;

    @Column(name = "bill_no")
    private Integer billNo;

    @Column(name = "revision_no")
    private Integer revisionNo;

    @Column(name = "resv_deposit_id")
    private Integer resvDepositId;

    @Column(name = "link_trx_no")
    private Integer linkTrxNo;

    @Column(name = "authorizer_id")
    private Integer authorizerId;

    @Column(name = "comp_link_trx_no")
    private Integer compLinkTrxNo;

    @Column(name = "mtrx_no_against_package")
    private Integer mtrxNoAgainstPackage;

    @Column(name = "forex_comm_perc")
    private Integer forexCommPerc;

    @Column(name = "forex_comm_amount")
    private Integer forexCommAmount;

    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "to_resv_name_id")
    private Integer toResvNameId;

    @Column(name = "room_nts")
    private Integer roomNts;

    @Column(name = "org_ar_led_debit")
    private Integer orgArLedDebit;

    @Column(name = "closure_no")
    private Integer closureNo;

    @Column(name = "original_resv_name_id")
    private Integer originalResvNameId;

    @Column(name = "org_bill_no")
    private Integer orgBillNo;

    @Column(name = "membership_id")
    private Integer membershipId;

    @Column(name = "installments")
    private Integer installments;

    @Column(name = "contract_guest_debit")
    private Integer contractGuestDebit;

    @Column(name = "contract_guest_credit")
    private Integer contractGuestCredit;

    @Column(name = "contract_net_amount")
    private Integer contractNetAmount;

    @Column(name = "contract_gross_amount")
    private Integer contractGrossAmount;

    @Column(name = "postit_no")
    private Integer postitNo;

    @Column(name = "cc_trx_fee_amount")
    private Integer ccTrxFeeAmount;

    @Column(name = "change_due")
    private Integer changeDue;

    @Column(name = "posting_source_name_id")
    private Integer postingSourceNameId;

    @Column(name = "bonus_check_id")
    private Integer bonusCheckId;

    @Column(name = "round_link_trxno")
    private Integer roundLinkTrxno;

    @Column(name = "reverse_payment_trx_no")
    private Integer reversePaymentTrxNo;

    @Column(name = "electronic_voucher_no")
    private Integer electronicVoucherNo;

    @Column(name = "threshold_diversion_id")
    private Integer thresholdDiversionId;

    @Column(name = "threshold_entity_qty")
    private Integer thresholdEntityQty;

    @Column(name = "trx_no_split")
    private Integer trxNoSplit;

    @Column(name = "exch_diff_trx_no")
    private Integer exchDiffTrxNo;

    @Column(name = "associated_trx_no")
    private Integer associatedTrxNo;

    @Column(name = "tax_rate")
    private Integer taxRate;

    @Column(name = "prop_charge_id")
    private Integer propChargeId;

    @Column(name = "quantity", precision = 21, scale = 2)
    private BigDecimal quantity;

    @Column(name = "net_amount", precision = 21, scale = 2)
    private BigDecimal netAmount;

    @Column(name = "gross_amount", precision = 21, scale = 2)
    private BigDecimal grossAmount;

    @Column(name = "cashier_opening_balance", precision = 21, scale = 2)
    private BigDecimal cashierOpeningBalance;

    @Column(name = "price_per_unit", precision = 21, scale = 2)
    private BigDecimal pricePerUnit;

    @Column(name = "trx_amount", precision = 21, scale = 2)
    private BigDecimal trxAmount;

    @Column(name = "posted_amount", precision = 21, scale = 2)
    private BigDecimal postedAmount;

    @Column(name = "guest_account_credit", precision = 21, scale = 2)
    private BigDecimal guestAccountCredit;

    @Column(name = "exchange_rate", precision = 21, scale = 2)
    private BigDecimal exchangeRate;

    @Column(name = "guest_account_debit", precision = 21, scale = 2)
    private BigDecimal guestAccountDebit;

    @Column(name = "cashier_credit", precision = 21, scale = 2)
    private BigDecimal cashierCredit;

    @Column(name = "cashier_debit", precision = 21, scale = 2)
    private BigDecimal cashierDebit;

    @Column(name = "package_credit", precision = 21, scale = 2)
    private BigDecimal packageCredit;

    @Column(name = "package_debit", precision = 21, scale = 2)
    private BigDecimal packageDebit;

    @Column(name = "dep_led_credit", precision = 21, scale = 2)
    private BigDecimal depLedCredit;

    @Column(name = "dep_led_debit", precision = 21, scale = 2)
    private BigDecimal depLedDebit;

    @Column(name = "revenue_amt", precision = 21, scale = 2)
    private BigDecimal revenueAmt;

    @Column(name = "ar_led_credit", precision = 21, scale = 2)
    private BigDecimal arLedCredit;

    @Column(name = "ar_led_debit", precision = 21, scale = 2)
    private BigDecimal arLedDebit;

    @Column(name = "euro_exchange_rate", precision = 21, scale = 2)
    private BigDecimal euroExchangeRate;

    @Column(name = "inh_debit", precision = 21, scale = 2)
    private BigDecimal inhDebit;

    @Column(name = "inh_credit", precision = 21, scale = 2)
    private BigDecimal inhCredit;

    @Column(name = "package_allowance", precision = 21, scale = 2)
    private BigDecimal packageAllowance;

    @Column(name = "parallel_guest_credit", precision = 21, scale = 2)
    private BigDecimal parallelGuestCredit;

    @Column(name = "parallel_guest_debit", precision = 21, scale = 2)
    private BigDecimal parallelGuestDebit;

    @Column(name = "parallel_net_amount", precision = 21, scale = 2)
    private BigDecimal parallelNetAmount;

    @Column(name = "parallel_gross_amount", precision = 21, scale = 2)
    private BigDecimal parallelGrossAmount;

    @Column(name = "org_posted_amount", precision = 21, scale = 2)
    private BigDecimal orgPostedAmount;

    @Column(name = "room_nts_effective", precision = 21, scale = 2)
    private BigDecimal roomNtsEffective;

    @Column(name = "payment_surcharge_amt", precision = 21, scale = 2)
    private BigDecimal paymentSurchargeAmt;

    @Column(name = "folio_view")
    private Integer folioView;

    @Column(name = "tax_inclusive_yn")
    private String taxInclusiveYn;

    @Column(name = "deferred_yn")
    private String deferredYn;

    @Column(name = "ind_adjustment_yn")
    private String indAdjustmentYn;

    @Column(name = "fixed_charges_yn")
    private String fixedChargesYn;

    @Column(name = "ta_commissionable_yn")
    private String taCommissionableYn;

    @Column(name = "tax_generated_yn")
    private String taxGeneratedYn;

    @Column(name = "compressed_yn")
    private String compressedYn;

    @Column(name = "display_yn")
    private String displayYn;

    @Column(name = "coll_agent_posting_yn")
    private String collAgentPostingYn;

    @Column(name = "fiscal_trx_code_type")
    private String fiscalTrxCodeType;

    @Column(name = "deferred_taxes_yn")
    private String deferredTaxesYn;

    @Column(name = "advanced_generate_yn")
    private String advancedGenerateYn;

    @Column(name = "forex_type")
    private String forexType;

    @Column(name = "ta_commission_net_yn")
    private String taCommissionNetYn;

    @Column(name = "source_commission_net_yn")
    private String sourceCommissionNetYn;

    @Column(name = "settlement_flag")
    private String settlementFlag;

    @Column(name = "acc_type_flag")
    private String accTypeFlag;

    @Column(name = "profit_loss_flag")
    private String profitLossFlag;

    @Column(name = "proforma_yn")
    private String proformaYn;

    @Column(name = "hold_yn")
    private String holdYn;

    @Column(name = "exchange_difference_yn")
    private String exchangeDifferenceYn;

    @Column(name = "calc_points_yn")
    private String calcPointsYn;

    @Column(name = "ar_charge_transfer_yn")
    private String arChargeTransferYn;

    @Column(name = "processed_8300_yn")
    private String processed8300Yn;

    @Column(name = "asb_flag")
    private String asbFlag;

    @Column(name = "postit_yn")
    private String postitYn;

    @Column(name = "auto_settle_yn")
    private String autoSettleYn;

    @Column(name = "dep_tax_transfered_yn")
    private String depTaxTransferedYn;

    @Column(name = "auto_creditbill_yn")
    private String autoCreditbillYn;

    @Column(name = "asb_only_post_taxes_once_yn")
    private String asbOnlyPostTaxesOnceYn;

    @Column(name = "round_factor_yn")
    private String roundFactorYn;

    @Column(name = "dep_posting_flag")
    private String depPostingFlag;

    @Column(name = "correction_yn")
    private String correctionYn;

    @Column(name = "routed_yn")
    private String routedYn;

    @Column(name = "upsell_charge_yn")
    private String upsellChargeYn;

    @Column(name = "advance_bill_yn")
    private String advanceBillYn;

    @Column(name = "advance_bill_reversed_yn")
    private String advanceBillReversedYn;

    @Column(name = "inc_tax_deducted_yn")
    private String incTaxDeductedYn;

    @Column(name = "gp_award_cancelled_yn")
    private String gpAwardCancelledYn;

    @Column(name = "service_recovery_adjustment_yn")
    private String serviceRecoveryAdjustmentYn;

    @Column(name = "split_type")
    private String splitType;

    @Column(name = "bucket_redemp_yn")
    private String bucketRedempYn;

    @Column(name = "vat_offset_yn")
    private String vatOffsetYn;

    @Column(name = "forex_tax_yn")
    private String forexTaxYn;

    @Column(name = "stamp_duty_yn")
    private String stampDutyYn;

    @Column(name = "covers")
    private String covers;

    @Column(name = "adv_generate_adjustment")
    private String advGenerateAdjustment;

    @Column(name = "exp_invoice_type")
    private String expInvoiceType;

    @Column(name = "folio_type")
    private String folioType;

    @Column(name = "org_folio_type")
    private String orgFolioType;

    @Column(name = "invoice_type")
    private String invoiceType;

    @Column(name = "ar_state")
    private String arState;

    @Column(name = "exchange_type")
    private String exchangeType;

    @Column(name = "recpt_type")
    private String recptType;

    @Column(name = "room_class")
    private String roomClass;

    @Column(name = "resort")
    private String resort;

    @Column(name = "tc_group")
    private String tcGroup;

    @Column(name = "tc_subgroup")
    private String tcSubgroup;

    @Column(name = "trx_code")
    private String trxCode;

    @Column(name = "room")
    private String room;

    @Column(name = "tcl_code_1")
    private String tclCode1;

    @Column(name = "currency")
    private String currency;

    @Column(name = "ft_generated_type")
    private String ftGeneratedType;

    @Column(name = "tcl_code_2")
    private String tclCode2;

    @Column(name = "market_code")
    private String marketCode;

    @Column(name = "source_code")
    private String sourceCode;

    @Column(name = "rate_code")
    private String rateCode;

    @Column(name = "hotel_acct")
    private String hotelAcct;

    @Column(name = "reason_code")
    private String reasonCode;

    @Column(name = "product")
    private String product;

    @Column(name = "target_resort")
    private String targetResort;

    @Column(name = "name_tax_type")
    private String nameTaxType;

    @Column(name = "tax_inv_no")
    private String taxInvNo;

    @Column(name = "approval_code")
    private String approvalCode;

    @Column(name = "approval_status")
    private String approvalStatus;

    @Column(name = "comp_link_trx_code")
    private String compLinkTrxCode;

    @Column(name = "comp_type_code")
    private String compTypeCode;

    @Column(name = "coupon_no")
    private String couponNo;

    @Column(name = "original_room")
    private String originalRoom;

    @Column(name = "allowance_type")
    private String allowanceType;

    @Column(name = "adv_generate_trx_code")
    private String advGenerateTrxCode;

    @Column(name = "trx_service_type")
    private String trxServiceType;

    @Column(name = "posting_type")
    private String postingType;

    @Column(name = "parallel_currency")
    private String parallelCurrency;

    @Column(name = "contract_currency")
    private String contractCurrency;

    @Column(name = "fba_certificate_number")
    private String fbaCertificateNumber;

    @Column(name = "posting_rhythm")
    private String postingRhythm;

    @Column(name = "asb_tax_flag")
    private String asbTaxFlag;

    @Column(name = "package_arrangement_code")
    private String packageArrangementCode;

    @Column(name = "gp_award_code")
    private String gpAwardCode;

    @Column(name = "gp_award_cancel_code")
    private String gpAwardCancelCode;

    @Column(name = "service_recovery_dept_code")
    private String serviceRecoveryDeptCode;

    @Column(name = "bucket_code")
    private String bucketCode;

    @Column(name = "tax_rate_type")
    private String taxRateType;

    @Column(name = "cheque_number")
    private String chequeNumber;

    @Column(name = "passer_by_name")
    private String passerByName;

    @Column(name = "esigned_receipt_name")
    private String esignedReceiptName;

    @Column(name = "remark")
    private String remark;

    @Column(name = "reference")
    private String reference;

    @Column(name = "o_trx_desc")
    private String oTrxDesc;

    @Column(name = "comments")
    private String comments;

    @Column(name = "fiscal_bill_no")
    private String fiscalBillNo;

    @Column(name = "ext_sys_result_msg")
    private String extSysResultMsg;

    @Column(name = "queue_name")
    private String queueName;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "cc_refund_posting")
    private String ccRefundPosting;

    @Column(name = "threshold_entity_type")
    private String thresholdEntityType;

    @Column(name = "threshold_treatment_flag")
    private String thresholdTreatmentFlag;

    @Column(name = "payment_surcharge_type")
    private String paymentSurchargeType;

    @Column(name = "property_bill_prefix")
    private String propertyBillPrefix;

    @Column(name = "tax_elements")
    private String taxElements;

    @Column(name = "number_dialed")
    private String numberDialed;

    @Column(name = "check_file_id")
    private String checkFileId;

    @Column(name = "ext_trx_id")
    private String extTrxId;

    @Column(name = "package_trx_type")
    private String packageTrxType;

    @Column(name = "exp_original_invoice")
    private String expOriginalInvoice;

    @Column(name = "deposit_transaction_id")
    private String depositTransactionId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Integer getId() {
        return this.id;
    }

    public FinancialTransactions id(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrxNo() {
        return this.trxNo;
    }

    public FinancialTransactions trxNo(Integer trxNo) {
        this.setTrxNo(trxNo);
        return this;
    }

    public void setTrxNo(Integer trxNo) {
        this.trxNo = trxNo;
    }

    public String getFtSubtype() {
        return this.ftSubtype;
    }

    public FinancialTransactions ftSubtype(String ftSubtype) {
        this.setFtSubtype(ftSubtype);
        return this;
    }

    public void setFtSubtype(String ftSubtype) {
        this.ftSubtype = ftSubtype;
    }

    public LocalDate getInvoiceCloseDate() {
        return this.invoiceCloseDate;
    }

    public FinancialTransactions invoiceCloseDate(LocalDate invoiceCloseDate) {
        this.setInvoiceCloseDate(invoiceCloseDate);
        return this;
    }

    public void setInvoiceCloseDate(LocalDate invoiceCloseDate) {
        this.invoiceCloseDate = invoiceCloseDate;
    }

    public LocalDate getArTransferDate() {
        return this.arTransferDate;
    }

    public FinancialTransactions arTransferDate(LocalDate arTransferDate) {
        this.setArTransferDate(arTransferDate);
        return this;
    }

    public void setArTransferDate(LocalDate arTransferDate) {
        this.arTransferDate = arTransferDate;
    }

    public LocalDate getTrxDate() {
        return this.trxDate;
    }

    public FinancialTransactions trxDate(LocalDate trxDate) {
        this.setTrxDate(trxDate);
        return this;
    }

    public void setTrxDate(LocalDate trxDate) {
        this.trxDate = trxDate;
    }

    public LocalDate getBusinessDate() {
        return this.businessDate;
    }

    public FinancialTransactions businessDate(LocalDate businessDate) {
        this.setBusinessDate(businessDate);
        return this;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public FinancialTransactions insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public FinancialTransactions updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDate getTrnsActivityDate() {
        return this.trnsActivityDate;
    }

    public FinancialTransactions trnsActivityDate(LocalDate trnsActivityDate) {
        this.setTrnsActivityDate(trnsActivityDate);
        return this;
    }

    public void setTrnsActivityDate(LocalDate trnsActivityDate) {
        this.trnsActivityDate = trnsActivityDate;
    }

    public LocalDate getApprovalDate() {
        return this.approvalDate;
    }

    public FinancialTransactions approvalDate(LocalDate approvalDate) {
        this.setApprovalDate(approvalDate);
        return this;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public LocalDate getPostingDate() {
        return this.postingDate;
    }

    public FinancialTransactions postingDate(LocalDate postingDate) {
        this.setPostingDate(postingDate);
        return this;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public LocalDate getExchangeDate() {
        return this.exchangeDate;
    }

    public FinancialTransactions exchangeDate(LocalDate exchangeDate) {
        this.setExchangeDate(exchangeDate);
        return this;
    }

    public void setExchangeDate(LocalDate exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public LocalDate getRoutingDate() {
        return this.routingDate;
    }

    public FinancialTransactions routingDate(LocalDate routingDate) {
        this.setRoutingDate(routingDate);
        return this;
    }

    public void setRoutingDate(LocalDate routingDate) {
        this.routingDate = routingDate;
    }

    public LocalDate getEffectiveDate() {
        return this.effectiveDate;
    }

    public FinancialTransactions effectiveDate(LocalDate effectiveDate) {
        this.setEffectiveDate(effectiveDate);
        return this;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getCustomChargeDate() {
        return this.customChargeDate;
    }

    public FinancialTransactions customChargeDate(LocalDate customChargeDate) {
        this.setCustomChargeDate(customChargeDate);
        return this;
    }

    public void setCustomChargeDate(LocalDate customChargeDate) {
        this.customChargeDate = customChargeDate;
    }

    public Integer getRecptNo() {
        return this.recptNo;
    }

    public FinancialTransactions recptNo(Integer recptNo) {
        this.setRecptNo(recptNo);
        return this;
    }

    public void setRecptNo(Integer recptNo) {
        this.recptNo = recptNo;
    }

    public Integer getTrxNoAdjust() {
        return this.trxNoAdjust;
    }

    public FinancialTransactions trxNoAdjust(Integer trxNoAdjust) {
        this.setTrxNoAdjust(trxNoAdjust);
        return this;
    }

    public void setTrxNoAdjust(Integer trxNoAdjust) {
        this.trxNoAdjust = trxNoAdjust;
    }

    public Integer getTrxNoAddedBy() {
        return this.trxNoAddedBy;
    }

    public FinancialTransactions trxNoAddedBy(Integer trxNoAddedBy) {
        this.setTrxNoAddedBy(trxNoAddedBy);
        return this;
    }

    public void setTrxNoAddedBy(Integer trxNoAddedBy) {
        this.trxNoAddedBy = trxNoAddedBy;
    }

    public Integer getTrxNoAgainstPackage() {
        return this.trxNoAgainstPackage;
    }

    public FinancialTransactions trxNoAgainstPackage(Integer trxNoAgainstPackage) {
        this.setTrxNoAgainstPackage(trxNoAgainstPackage);
        return this;
    }

    public void setTrxNoAgainstPackage(Integer trxNoAgainstPackage) {
        this.trxNoAgainstPackage = trxNoAgainstPackage;
    }

    public Integer getTrxNoHeader() {
        return this.trxNoHeader;
    }

    public FinancialTransactions trxNoHeader(Integer trxNoHeader) {
        this.setTrxNoHeader(trxNoHeader);
        return this;
    }

    public void setTrxNoHeader(Integer trxNoHeader) {
        this.trxNoHeader = trxNoHeader;
    }

    public Integer getArNumber() {
        return this.arNumber;
    }

    public FinancialTransactions arNumber(Integer arNumber) {
        this.setArNumber(arNumber);
        return this;
    }

    public void setArNumber(Integer arNumber) {
        this.arNumber = arNumber;
    }

    public Integer getResvNameId() {
        return this.resvNameId;
    }

    public FinancialTransactions resvNameId(Integer resvNameId) {
        this.setResvNameId(resvNameId);
        return this;
    }

    public void setResvNameId(Integer resvNameId) {
        this.resvNameId = resvNameId;
    }

    public Integer getCashierId() {
        return this.cashierId;
    }

    public FinancialTransactions cashierId(Integer cashierId) {
        this.setCashierId(cashierId);
        return this;
    }

    public void setCashierId(Integer cashierId) {
        this.cashierId = cashierId;
    }

    public Integer getCreditCardId() {
        return this.creditCardId;
    }

    public FinancialTransactions creditCardId(Integer creditCardId) {
        this.setCreditCardId(creditCardId);
        return this;
    }

    public void setCreditCardId(Integer creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Integer getNameId() {
        return this.nameId;
    }

    public FinancialTransactions nameId(Integer nameId) {
        this.setNameId(nameId);
        return this;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public Integer getTranActionId() {
        return this.tranActionId;
    }

    public FinancialTransactions tranActionId(Integer tranActionId) {
        this.setTranActionId(tranActionId);
        return this;
    }

    public void setTranActionId(Integer tranActionId) {
        this.tranActionId = tranActionId;
    }

    public Integer getFinDmlSeqNo() {
        return this.finDmlSeqNo;
    }

    public FinancialTransactions finDmlSeqNo(Integer finDmlSeqNo) {
        this.setFinDmlSeqNo(finDmlSeqNo);
        return this;
    }

    public void setFinDmlSeqNo(Integer finDmlSeqNo) {
        this.finDmlSeqNo = finDmlSeqNo;
    }

    public Integer getRoutingInstrnId() {
        return this.routingInstrnId;
    }

    public FinancialTransactions routingInstrnId(Integer routingInstrnId) {
        this.setRoutingInstrnId(routingInstrnId);
        return this;
    }

    public void setRoutingInstrnId(Integer routingInstrnId) {
        this.routingInstrnId = routingInstrnId;
    }

    public Integer getFromResvId() {
        return this.fromResvId;
    }

    public FinancialTransactions fromResvId(Integer fromResvId) {
        this.setFromResvId(fromResvId);
        return this;
    }

    public void setFromResvId(Integer fromResvId) {
        this.fromResvId = fromResvId;
    }

    public Integer getGenCashierId() {
        return this.genCashierId;
    }

    public FinancialTransactions genCashierId(Integer genCashierId) {
        this.setGenCashierId(genCashierId);
        return this;
    }

    public void setGenCashierId(Integer genCashierId) {
        this.genCashierId = genCashierId;
    }

    public Integer getFolioNo() {
        return this.folioNo;
    }

    public FinancialTransactions folioNo(Integer folioNo) {
        this.setFolioNo(folioNo);
        return this;
    }

    public void setFolioNo(Integer folioNo) {
        this.folioNo = folioNo;
    }

    public Integer getInvoiceNo() {
        return this.invoiceNo;
    }

    public FinancialTransactions invoiceNo(Integer invoiceNo) {
        this.setInvoiceNo(invoiceNo);
        return this;
    }

    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public FinancialTransactions insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public FinancialTransactions updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getArrangementId() {
        return this.arrangementId;
    }

    public FinancialTransactions arrangementId(Integer arrangementId) {
        this.setArrangementId(arrangementId);
        return this;
    }

    public void setArrangementId(Integer arrangementId) {
        this.arrangementId = arrangementId;
    }

    public Integer getTrnsFromAcct() {
        return this.trnsFromAcct;
    }

    public FinancialTransactions trnsFromAcct(Integer trnsFromAcct) {
        this.setTrnsFromAcct(trnsFromAcct);
        return this;
    }

    public void setTrnsFromAcct(Integer trnsFromAcct) {
        this.trnsFromAcct = trnsFromAcct;
    }

    public Integer getTrnsToAcct() {
        return this.trnsToAcct;
    }

    public FinancialTransactions trnsToAcct(Integer trnsToAcct) {
        this.setTrnsToAcct(trnsToAcct);
        return this;
    }

    public void setTrnsToAcct(Integer trnsToAcct) {
        this.trnsToAcct = trnsToAcct;
    }

    public Integer getBillNo() {
        return this.billNo;
    }

    public FinancialTransactions billNo(Integer billNo) {
        this.setBillNo(billNo);
        return this;
    }

    public void setBillNo(Integer billNo) {
        this.billNo = billNo;
    }

    public Integer getRevisionNo() {
        return this.revisionNo;
    }

    public FinancialTransactions revisionNo(Integer revisionNo) {
        this.setRevisionNo(revisionNo);
        return this;
    }

    public void setRevisionNo(Integer revisionNo) {
        this.revisionNo = revisionNo;
    }

    public Integer getResvDepositId() {
        return this.resvDepositId;
    }

    public FinancialTransactions resvDepositId(Integer resvDepositId) {
        this.setResvDepositId(resvDepositId);
        return this;
    }

    public void setResvDepositId(Integer resvDepositId) {
        this.resvDepositId = resvDepositId;
    }

    public Integer getLinkTrxNo() {
        return this.linkTrxNo;
    }

    public FinancialTransactions linkTrxNo(Integer linkTrxNo) {
        this.setLinkTrxNo(linkTrxNo);
        return this;
    }

    public void setLinkTrxNo(Integer linkTrxNo) {
        this.linkTrxNo = linkTrxNo;
    }

    public Integer getAuthorizerId() {
        return this.authorizerId;
    }

    public FinancialTransactions authorizerId(Integer authorizerId) {
        this.setAuthorizerId(authorizerId);
        return this;
    }

    public void setAuthorizerId(Integer authorizerId) {
        this.authorizerId = authorizerId;
    }

    public Integer getCompLinkTrxNo() {
        return this.compLinkTrxNo;
    }

    public FinancialTransactions compLinkTrxNo(Integer compLinkTrxNo) {
        this.setCompLinkTrxNo(compLinkTrxNo);
        return this;
    }

    public void setCompLinkTrxNo(Integer compLinkTrxNo) {
        this.compLinkTrxNo = compLinkTrxNo;
    }

    public Integer getMtrxNoAgainstPackage() {
        return this.mtrxNoAgainstPackage;
    }

    public FinancialTransactions mtrxNoAgainstPackage(Integer mtrxNoAgainstPackage) {
        this.setMtrxNoAgainstPackage(mtrxNoAgainstPackage);
        return this;
    }

    public void setMtrxNoAgainstPackage(Integer mtrxNoAgainstPackage) {
        this.mtrxNoAgainstPackage = mtrxNoAgainstPackage;
    }

    public Integer getForexCommPerc() {
        return this.forexCommPerc;
    }

    public FinancialTransactions forexCommPerc(Integer forexCommPerc) {
        this.setForexCommPerc(forexCommPerc);
        return this;
    }

    public void setForexCommPerc(Integer forexCommPerc) {
        this.forexCommPerc = forexCommPerc;
    }

    public Integer getForexCommAmount() {
        return this.forexCommAmount;
    }

    public FinancialTransactions forexCommAmount(Integer forexCommAmount) {
        this.setForexCommAmount(forexCommAmount);
        return this;
    }

    public void setForexCommAmount(Integer forexCommAmount) {
        this.forexCommAmount = forexCommAmount;
    }

    public Integer getArticleId() {
        return this.articleId;
    }

    public FinancialTransactions articleId(Integer articleId) {
        this.setArticleId(articleId);
        return this;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getToResvNameId() {
        return this.toResvNameId;
    }

    public FinancialTransactions toResvNameId(Integer toResvNameId) {
        this.setToResvNameId(toResvNameId);
        return this;
    }

    public void setToResvNameId(Integer toResvNameId) {
        this.toResvNameId = toResvNameId;
    }

    public Integer getRoomNts() {
        return this.roomNts;
    }

    public FinancialTransactions roomNts(Integer roomNts) {
        this.setRoomNts(roomNts);
        return this;
    }

    public void setRoomNts(Integer roomNts) {
        this.roomNts = roomNts;
    }

    public Integer getOrgArLedDebit() {
        return this.orgArLedDebit;
    }

    public FinancialTransactions orgArLedDebit(Integer orgArLedDebit) {
        this.setOrgArLedDebit(orgArLedDebit);
        return this;
    }

    public void setOrgArLedDebit(Integer orgArLedDebit) {
        this.orgArLedDebit = orgArLedDebit;
    }

    public Integer getClosureNo() {
        return this.closureNo;
    }

    public FinancialTransactions closureNo(Integer closureNo) {
        this.setClosureNo(closureNo);
        return this;
    }

    public void setClosureNo(Integer closureNo) {
        this.closureNo = closureNo;
    }

    public Integer getOriginalResvNameId() {
        return this.originalResvNameId;
    }

    public FinancialTransactions originalResvNameId(Integer originalResvNameId) {
        this.setOriginalResvNameId(originalResvNameId);
        return this;
    }

    public void setOriginalResvNameId(Integer originalResvNameId) {
        this.originalResvNameId = originalResvNameId;
    }

    public Integer getOrgBillNo() {
        return this.orgBillNo;
    }

    public FinancialTransactions orgBillNo(Integer orgBillNo) {
        this.setOrgBillNo(orgBillNo);
        return this;
    }

    public void setOrgBillNo(Integer orgBillNo) {
        this.orgBillNo = orgBillNo;
    }

    public Integer getMembershipId() {
        return this.membershipId;
    }

    public FinancialTransactions membershipId(Integer membershipId) {
        this.setMembershipId(membershipId);
        return this;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    public Integer getInstallments() {
        return this.installments;
    }

    public FinancialTransactions installments(Integer installments) {
        this.setInstallments(installments);
        return this;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public Integer getContractGuestDebit() {
        return this.contractGuestDebit;
    }

    public FinancialTransactions contractGuestDebit(Integer contractGuestDebit) {
        this.setContractGuestDebit(contractGuestDebit);
        return this;
    }

    public void setContractGuestDebit(Integer contractGuestDebit) {
        this.contractGuestDebit = contractGuestDebit;
    }

    public Integer getContractGuestCredit() {
        return this.contractGuestCredit;
    }

    public FinancialTransactions contractGuestCredit(Integer contractGuestCredit) {
        this.setContractGuestCredit(contractGuestCredit);
        return this;
    }

    public void setContractGuestCredit(Integer contractGuestCredit) {
        this.contractGuestCredit = contractGuestCredit;
    }

    public Integer getContractNetAmount() {
        return this.contractNetAmount;
    }

    public FinancialTransactions contractNetAmount(Integer contractNetAmount) {
        this.setContractNetAmount(contractNetAmount);
        return this;
    }

    public void setContractNetAmount(Integer contractNetAmount) {
        this.contractNetAmount = contractNetAmount;
    }

    public Integer getContractGrossAmount() {
        return this.contractGrossAmount;
    }

    public FinancialTransactions contractGrossAmount(Integer contractGrossAmount) {
        this.setContractGrossAmount(contractGrossAmount);
        return this;
    }

    public void setContractGrossAmount(Integer contractGrossAmount) {
        this.contractGrossAmount = contractGrossAmount;
    }

    public Integer getPostitNo() {
        return this.postitNo;
    }

    public FinancialTransactions postitNo(Integer postitNo) {
        this.setPostitNo(postitNo);
        return this;
    }

    public void setPostitNo(Integer postitNo) {
        this.postitNo = postitNo;
    }

    public Integer getCcTrxFeeAmount() {
        return this.ccTrxFeeAmount;
    }

    public FinancialTransactions ccTrxFeeAmount(Integer ccTrxFeeAmount) {
        this.setCcTrxFeeAmount(ccTrxFeeAmount);
        return this;
    }

    public void setCcTrxFeeAmount(Integer ccTrxFeeAmount) {
        this.ccTrxFeeAmount = ccTrxFeeAmount;
    }

    public Integer getChangeDue() {
        return this.changeDue;
    }

    public FinancialTransactions changeDue(Integer changeDue) {
        this.setChangeDue(changeDue);
        return this;
    }

    public void setChangeDue(Integer changeDue) {
        this.changeDue = changeDue;
    }

    public Integer getPostingSourceNameId() {
        return this.postingSourceNameId;
    }

    public FinancialTransactions postingSourceNameId(Integer postingSourceNameId) {
        this.setPostingSourceNameId(postingSourceNameId);
        return this;
    }

    public void setPostingSourceNameId(Integer postingSourceNameId) {
        this.postingSourceNameId = postingSourceNameId;
    }

    public Integer getBonusCheckId() {
        return this.bonusCheckId;
    }

    public FinancialTransactions bonusCheckId(Integer bonusCheckId) {
        this.setBonusCheckId(bonusCheckId);
        return this;
    }

    public void setBonusCheckId(Integer bonusCheckId) {
        this.bonusCheckId = bonusCheckId;
    }

    public Integer getRoundLinkTrxno() {
        return this.roundLinkTrxno;
    }

    public FinancialTransactions roundLinkTrxno(Integer roundLinkTrxno) {
        this.setRoundLinkTrxno(roundLinkTrxno);
        return this;
    }

    public void setRoundLinkTrxno(Integer roundLinkTrxno) {
        this.roundLinkTrxno = roundLinkTrxno;
    }

    public Integer getReversePaymentTrxNo() {
        return this.reversePaymentTrxNo;
    }

    public FinancialTransactions reversePaymentTrxNo(Integer reversePaymentTrxNo) {
        this.setReversePaymentTrxNo(reversePaymentTrxNo);
        return this;
    }

    public void setReversePaymentTrxNo(Integer reversePaymentTrxNo) {
        this.reversePaymentTrxNo = reversePaymentTrxNo;
    }

    public Integer getElectronicVoucherNo() {
        return this.electronicVoucherNo;
    }

    public FinancialTransactions electronicVoucherNo(Integer electronicVoucherNo) {
        this.setElectronicVoucherNo(electronicVoucherNo);
        return this;
    }

    public void setElectronicVoucherNo(Integer electronicVoucherNo) {
        this.electronicVoucherNo = electronicVoucherNo;
    }

    public Integer getThresholdDiversionId() {
        return this.thresholdDiversionId;
    }

    public FinancialTransactions thresholdDiversionId(Integer thresholdDiversionId) {
        this.setThresholdDiversionId(thresholdDiversionId);
        return this;
    }

    public void setThresholdDiversionId(Integer thresholdDiversionId) {
        this.thresholdDiversionId = thresholdDiversionId;
    }

    public Integer getThresholdEntityQty() {
        return this.thresholdEntityQty;
    }

    public FinancialTransactions thresholdEntityQty(Integer thresholdEntityQty) {
        this.setThresholdEntityQty(thresholdEntityQty);
        return this;
    }

    public void setThresholdEntityQty(Integer thresholdEntityQty) {
        this.thresholdEntityQty = thresholdEntityQty;
    }

    public Integer getTrxNoSplit() {
        return this.trxNoSplit;
    }

    public FinancialTransactions trxNoSplit(Integer trxNoSplit) {
        this.setTrxNoSplit(trxNoSplit);
        return this;
    }

    public void setTrxNoSplit(Integer trxNoSplit) {
        this.trxNoSplit = trxNoSplit;
    }

    public Integer getExchDiffTrxNo() {
        return this.exchDiffTrxNo;
    }

    public FinancialTransactions exchDiffTrxNo(Integer exchDiffTrxNo) {
        this.setExchDiffTrxNo(exchDiffTrxNo);
        return this;
    }

    public void setExchDiffTrxNo(Integer exchDiffTrxNo) {
        this.exchDiffTrxNo = exchDiffTrxNo;
    }

    public Integer getAssociatedTrxNo() {
        return this.associatedTrxNo;
    }

    public FinancialTransactions associatedTrxNo(Integer associatedTrxNo) {
        this.setAssociatedTrxNo(associatedTrxNo);
        return this;
    }

    public void setAssociatedTrxNo(Integer associatedTrxNo) {
        this.associatedTrxNo = associatedTrxNo;
    }

    public Integer getTaxRate() {
        return this.taxRate;
    }

    public FinancialTransactions taxRate(Integer taxRate) {
        this.setTaxRate(taxRate);
        return this;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getPropChargeId() {
        return this.propChargeId;
    }

    public FinancialTransactions propChargeId(Integer propChargeId) {
        this.setPropChargeId(propChargeId);
        return this;
    }

    public void setPropChargeId(Integer propChargeId) {
        this.propChargeId = propChargeId;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public FinancialTransactions quantity(BigDecimal quantity) {
        this.setQuantity(quantity);
        return this;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getNetAmount() {
        return this.netAmount;
    }

    public FinancialTransactions netAmount(BigDecimal netAmount) {
        this.setNetAmount(netAmount);
        return this;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getGrossAmount() {
        return this.grossAmount;
    }

    public FinancialTransactions grossAmount(BigDecimal grossAmount) {
        this.setGrossAmount(grossAmount);
        return this;
    }

    public void setGrossAmount(BigDecimal grossAmount) {
        this.grossAmount = grossAmount;
    }

    public BigDecimal getCashierOpeningBalance() {
        return this.cashierOpeningBalance;
    }

    public FinancialTransactions cashierOpeningBalance(BigDecimal cashierOpeningBalance) {
        this.setCashierOpeningBalance(cashierOpeningBalance);
        return this;
    }

    public void setCashierOpeningBalance(BigDecimal cashierOpeningBalance) {
        this.cashierOpeningBalance = cashierOpeningBalance;
    }

    public BigDecimal getPricePerUnit() {
        return this.pricePerUnit;
    }

    public FinancialTransactions pricePerUnit(BigDecimal pricePerUnit) {
        this.setPricePerUnit(pricePerUnit);
        return this;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public BigDecimal getTrxAmount() {
        return this.trxAmount;
    }

    public FinancialTransactions trxAmount(BigDecimal trxAmount) {
        this.setTrxAmount(trxAmount);
        return this;
    }

    public void setTrxAmount(BigDecimal trxAmount) {
        this.trxAmount = trxAmount;
    }

    public BigDecimal getPostedAmount() {
        return this.postedAmount;
    }

    public FinancialTransactions postedAmount(BigDecimal postedAmount) {
        this.setPostedAmount(postedAmount);
        return this;
    }

    public void setPostedAmount(BigDecimal postedAmount) {
        this.postedAmount = postedAmount;
    }

    public BigDecimal getGuestAccountCredit() {
        return this.guestAccountCredit;
    }

    public FinancialTransactions guestAccountCredit(BigDecimal guestAccountCredit) {
        this.setGuestAccountCredit(guestAccountCredit);
        return this;
    }

    public void setGuestAccountCredit(BigDecimal guestAccountCredit) {
        this.guestAccountCredit = guestAccountCredit;
    }

    public BigDecimal getExchangeRate() {
        return this.exchangeRate;
    }

    public FinancialTransactions exchangeRate(BigDecimal exchangeRate) {
        this.setExchangeRate(exchangeRate);
        return this;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getGuestAccountDebit() {
        return this.guestAccountDebit;
    }

    public FinancialTransactions guestAccountDebit(BigDecimal guestAccountDebit) {
        this.setGuestAccountDebit(guestAccountDebit);
        return this;
    }

    public void setGuestAccountDebit(BigDecimal guestAccountDebit) {
        this.guestAccountDebit = guestAccountDebit;
    }

    public BigDecimal getCashierCredit() {
        return this.cashierCredit;
    }

    public FinancialTransactions cashierCredit(BigDecimal cashierCredit) {
        this.setCashierCredit(cashierCredit);
        return this;
    }

    public void setCashierCredit(BigDecimal cashierCredit) {
        this.cashierCredit = cashierCredit;
    }

    public BigDecimal getCashierDebit() {
        return this.cashierDebit;
    }

    public FinancialTransactions cashierDebit(BigDecimal cashierDebit) {
        this.setCashierDebit(cashierDebit);
        return this;
    }

    public void setCashierDebit(BigDecimal cashierDebit) {
        this.cashierDebit = cashierDebit;
    }

    public BigDecimal getPackageCredit() {
        return this.packageCredit;
    }

    public FinancialTransactions packageCredit(BigDecimal packageCredit) {
        this.setPackageCredit(packageCredit);
        return this;
    }

    public void setPackageCredit(BigDecimal packageCredit) {
        this.packageCredit = packageCredit;
    }

    public BigDecimal getPackageDebit() {
        return this.packageDebit;
    }

    public FinancialTransactions packageDebit(BigDecimal packageDebit) {
        this.setPackageDebit(packageDebit);
        return this;
    }

    public void setPackageDebit(BigDecimal packageDebit) {
        this.packageDebit = packageDebit;
    }

    public BigDecimal getDepLedCredit() {
        return this.depLedCredit;
    }

    public FinancialTransactions depLedCredit(BigDecimal depLedCredit) {
        this.setDepLedCredit(depLedCredit);
        return this;
    }

    public void setDepLedCredit(BigDecimal depLedCredit) {
        this.depLedCredit = depLedCredit;
    }

    public BigDecimal getDepLedDebit() {
        return this.depLedDebit;
    }

    public FinancialTransactions depLedDebit(BigDecimal depLedDebit) {
        this.setDepLedDebit(depLedDebit);
        return this;
    }

    public void setDepLedDebit(BigDecimal depLedDebit) {
        this.depLedDebit = depLedDebit;
    }

    public BigDecimal getRevenueAmt() {
        return this.revenueAmt;
    }

    public FinancialTransactions revenueAmt(BigDecimal revenueAmt) {
        this.setRevenueAmt(revenueAmt);
        return this;
    }

    public void setRevenueAmt(BigDecimal revenueAmt) {
        this.revenueAmt = revenueAmt;
    }

    public BigDecimal getArLedCredit() {
        return this.arLedCredit;
    }

    public FinancialTransactions arLedCredit(BigDecimal arLedCredit) {
        this.setArLedCredit(arLedCredit);
        return this;
    }

    public void setArLedCredit(BigDecimal arLedCredit) {
        this.arLedCredit = arLedCredit;
    }

    public BigDecimal getArLedDebit() {
        return this.arLedDebit;
    }

    public FinancialTransactions arLedDebit(BigDecimal arLedDebit) {
        this.setArLedDebit(arLedDebit);
        return this;
    }

    public void setArLedDebit(BigDecimal arLedDebit) {
        this.arLedDebit = arLedDebit;
    }

    public BigDecimal getEuroExchangeRate() {
        return this.euroExchangeRate;
    }

    public FinancialTransactions euroExchangeRate(BigDecimal euroExchangeRate) {
        this.setEuroExchangeRate(euroExchangeRate);
        return this;
    }

    public void setEuroExchangeRate(BigDecimal euroExchangeRate) {
        this.euroExchangeRate = euroExchangeRate;
    }

    public BigDecimal getInhDebit() {
        return this.inhDebit;
    }

    public FinancialTransactions inhDebit(BigDecimal inhDebit) {
        this.setInhDebit(inhDebit);
        return this;
    }

    public void setInhDebit(BigDecimal inhDebit) {
        this.inhDebit = inhDebit;
    }

    public BigDecimal getInhCredit() {
        return this.inhCredit;
    }

    public FinancialTransactions inhCredit(BigDecimal inhCredit) {
        this.setInhCredit(inhCredit);
        return this;
    }

    public void setInhCredit(BigDecimal inhCredit) {
        this.inhCredit = inhCredit;
    }

    public BigDecimal getPackageAllowance() {
        return this.packageAllowance;
    }

    public FinancialTransactions packageAllowance(BigDecimal packageAllowance) {
        this.setPackageAllowance(packageAllowance);
        return this;
    }

    public void setPackageAllowance(BigDecimal packageAllowance) {
        this.packageAllowance = packageAllowance;
    }

    public BigDecimal getParallelGuestCredit() {
        return this.parallelGuestCredit;
    }

    public FinancialTransactions parallelGuestCredit(BigDecimal parallelGuestCredit) {
        this.setParallelGuestCredit(parallelGuestCredit);
        return this;
    }

    public void setParallelGuestCredit(BigDecimal parallelGuestCredit) {
        this.parallelGuestCredit = parallelGuestCredit;
    }

    public BigDecimal getParallelGuestDebit() {
        return this.parallelGuestDebit;
    }

    public FinancialTransactions parallelGuestDebit(BigDecimal parallelGuestDebit) {
        this.setParallelGuestDebit(parallelGuestDebit);
        return this;
    }

    public void setParallelGuestDebit(BigDecimal parallelGuestDebit) {
        this.parallelGuestDebit = parallelGuestDebit;
    }

    public BigDecimal getParallelNetAmount() {
        return this.parallelNetAmount;
    }

    public FinancialTransactions parallelNetAmount(BigDecimal parallelNetAmount) {
        this.setParallelNetAmount(parallelNetAmount);
        return this;
    }

    public void setParallelNetAmount(BigDecimal parallelNetAmount) {
        this.parallelNetAmount = parallelNetAmount;
    }

    public BigDecimal getParallelGrossAmount() {
        return this.parallelGrossAmount;
    }

    public FinancialTransactions parallelGrossAmount(BigDecimal parallelGrossAmount) {
        this.setParallelGrossAmount(parallelGrossAmount);
        return this;
    }

    public void setParallelGrossAmount(BigDecimal parallelGrossAmount) {
        this.parallelGrossAmount = parallelGrossAmount;
    }

    public BigDecimal getOrgPostedAmount() {
        return this.orgPostedAmount;
    }

    public FinancialTransactions orgPostedAmount(BigDecimal orgPostedAmount) {
        this.setOrgPostedAmount(orgPostedAmount);
        return this;
    }

    public void setOrgPostedAmount(BigDecimal orgPostedAmount) {
        this.orgPostedAmount = orgPostedAmount;
    }

    public BigDecimal getRoomNtsEffective() {
        return this.roomNtsEffective;
    }

    public FinancialTransactions roomNtsEffective(BigDecimal roomNtsEffective) {
        this.setRoomNtsEffective(roomNtsEffective);
        return this;
    }

    public void setRoomNtsEffective(BigDecimal roomNtsEffective) {
        this.roomNtsEffective = roomNtsEffective;
    }

    public BigDecimal getPaymentSurchargeAmt() {
        return this.paymentSurchargeAmt;
    }

    public FinancialTransactions paymentSurchargeAmt(BigDecimal paymentSurchargeAmt) {
        this.setPaymentSurchargeAmt(paymentSurchargeAmt);
        return this;
    }

    public void setPaymentSurchargeAmt(BigDecimal paymentSurchargeAmt) {
        this.paymentSurchargeAmt = paymentSurchargeAmt;
    }

    public Integer getFolioView() {
        return this.folioView;
    }

    public FinancialTransactions folioView(Integer folioView) {
        this.setFolioView(folioView);
        return this;
    }

    public void setFolioView(Integer folioView) {
        this.folioView = folioView;
    }

    public String getTaxInclusiveYn() {
        return this.taxInclusiveYn;
    }

    public FinancialTransactions taxInclusiveYn(String taxInclusiveYn) {
        this.setTaxInclusiveYn(taxInclusiveYn);
        return this;
    }

    public void setTaxInclusiveYn(String taxInclusiveYn) {
        this.taxInclusiveYn = taxInclusiveYn;
    }

    public String getDeferredYn() {
        return this.deferredYn;
    }

    public FinancialTransactions deferredYn(String deferredYn) {
        this.setDeferredYn(deferredYn);
        return this;
    }

    public void setDeferredYn(String deferredYn) {
        this.deferredYn = deferredYn;
    }

    public String getIndAdjustmentYn() {
        return this.indAdjustmentYn;
    }

    public FinancialTransactions indAdjustmentYn(String indAdjustmentYn) {
        this.setIndAdjustmentYn(indAdjustmentYn);
        return this;
    }

    public void setIndAdjustmentYn(String indAdjustmentYn) {
        this.indAdjustmentYn = indAdjustmentYn;
    }

    public String getFixedChargesYn() {
        return this.fixedChargesYn;
    }

    public FinancialTransactions fixedChargesYn(String fixedChargesYn) {
        this.setFixedChargesYn(fixedChargesYn);
        return this;
    }

    public void setFixedChargesYn(String fixedChargesYn) {
        this.fixedChargesYn = fixedChargesYn;
    }

    public String getTaCommissionableYn() {
        return this.taCommissionableYn;
    }

    public FinancialTransactions taCommissionableYn(String taCommissionableYn) {
        this.setTaCommissionableYn(taCommissionableYn);
        return this;
    }

    public void setTaCommissionableYn(String taCommissionableYn) {
        this.taCommissionableYn = taCommissionableYn;
    }

    public String getTaxGeneratedYn() {
        return this.taxGeneratedYn;
    }

    public FinancialTransactions taxGeneratedYn(String taxGeneratedYn) {
        this.setTaxGeneratedYn(taxGeneratedYn);
        return this;
    }

    public void setTaxGeneratedYn(String taxGeneratedYn) {
        this.taxGeneratedYn = taxGeneratedYn;
    }

    public String getCompressedYn() {
        return this.compressedYn;
    }

    public FinancialTransactions compressedYn(String compressedYn) {
        this.setCompressedYn(compressedYn);
        return this;
    }

    public void setCompressedYn(String compressedYn) {
        this.compressedYn = compressedYn;
    }

    public String getDisplayYn() {
        return this.displayYn;
    }

    public FinancialTransactions displayYn(String displayYn) {
        this.setDisplayYn(displayYn);
        return this;
    }

    public void setDisplayYn(String displayYn) {
        this.displayYn = displayYn;
    }

    public String getCollAgentPostingYn() {
        return this.collAgentPostingYn;
    }

    public FinancialTransactions collAgentPostingYn(String collAgentPostingYn) {
        this.setCollAgentPostingYn(collAgentPostingYn);
        return this;
    }

    public void setCollAgentPostingYn(String collAgentPostingYn) {
        this.collAgentPostingYn = collAgentPostingYn;
    }

    public String getFiscalTrxCodeType() {
        return this.fiscalTrxCodeType;
    }

    public FinancialTransactions fiscalTrxCodeType(String fiscalTrxCodeType) {
        this.setFiscalTrxCodeType(fiscalTrxCodeType);
        return this;
    }

    public void setFiscalTrxCodeType(String fiscalTrxCodeType) {
        this.fiscalTrxCodeType = fiscalTrxCodeType;
    }

    public String getDeferredTaxesYn() {
        return this.deferredTaxesYn;
    }

    public FinancialTransactions deferredTaxesYn(String deferredTaxesYn) {
        this.setDeferredTaxesYn(deferredTaxesYn);
        return this;
    }

    public void setDeferredTaxesYn(String deferredTaxesYn) {
        this.deferredTaxesYn = deferredTaxesYn;
    }

    public String getAdvancedGenerateYn() {
        return this.advancedGenerateYn;
    }

    public FinancialTransactions advancedGenerateYn(String advancedGenerateYn) {
        this.setAdvancedGenerateYn(advancedGenerateYn);
        return this;
    }

    public void setAdvancedGenerateYn(String advancedGenerateYn) {
        this.advancedGenerateYn = advancedGenerateYn;
    }

    public String getForexType() {
        return this.forexType;
    }

    public FinancialTransactions forexType(String forexType) {
        this.setForexType(forexType);
        return this;
    }

    public void setForexType(String forexType) {
        this.forexType = forexType;
    }

    public String getTaCommissionNetYn() {
        return this.taCommissionNetYn;
    }

    public FinancialTransactions taCommissionNetYn(String taCommissionNetYn) {
        this.setTaCommissionNetYn(taCommissionNetYn);
        return this;
    }

    public void setTaCommissionNetYn(String taCommissionNetYn) {
        this.taCommissionNetYn = taCommissionNetYn;
    }

    public String getSourceCommissionNetYn() {
        return this.sourceCommissionNetYn;
    }

    public FinancialTransactions sourceCommissionNetYn(String sourceCommissionNetYn) {
        this.setSourceCommissionNetYn(sourceCommissionNetYn);
        return this;
    }

    public void setSourceCommissionNetYn(String sourceCommissionNetYn) {
        this.sourceCommissionNetYn = sourceCommissionNetYn;
    }

    public String getSettlementFlag() {
        return this.settlementFlag;
    }

    public FinancialTransactions settlementFlag(String settlementFlag) {
        this.setSettlementFlag(settlementFlag);
        return this;
    }

    public void setSettlementFlag(String settlementFlag) {
        this.settlementFlag = settlementFlag;
    }

    public String getAccTypeFlag() {
        return this.accTypeFlag;
    }

    public FinancialTransactions accTypeFlag(String accTypeFlag) {
        this.setAccTypeFlag(accTypeFlag);
        return this;
    }

    public void setAccTypeFlag(String accTypeFlag) {
        this.accTypeFlag = accTypeFlag;
    }

    public String getProfitLossFlag() {
        return this.profitLossFlag;
    }

    public FinancialTransactions profitLossFlag(String profitLossFlag) {
        this.setProfitLossFlag(profitLossFlag);
        return this;
    }

    public void setProfitLossFlag(String profitLossFlag) {
        this.profitLossFlag = profitLossFlag;
    }

    public String getProformaYn() {
        return this.proformaYn;
    }

    public FinancialTransactions proformaYn(String proformaYn) {
        this.setProformaYn(proformaYn);
        return this;
    }

    public void setProformaYn(String proformaYn) {
        this.proformaYn = proformaYn;
    }

    public String getHoldYn() {
        return this.holdYn;
    }

    public FinancialTransactions holdYn(String holdYn) {
        this.setHoldYn(holdYn);
        return this;
    }

    public void setHoldYn(String holdYn) {
        this.holdYn = holdYn;
    }

    public String getExchangeDifferenceYn() {
        return this.exchangeDifferenceYn;
    }

    public FinancialTransactions exchangeDifferenceYn(String exchangeDifferenceYn) {
        this.setExchangeDifferenceYn(exchangeDifferenceYn);
        return this;
    }

    public void setExchangeDifferenceYn(String exchangeDifferenceYn) {
        this.exchangeDifferenceYn = exchangeDifferenceYn;
    }

    public String getCalcPointsYn() {
        return this.calcPointsYn;
    }

    public FinancialTransactions calcPointsYn(String calcPointsYn) {
        this.setCalcPointsYn(calcPointsYn);
        return this;
    }

    public void setCalcPointsYn(String calcPointsYn) {
        this.calcPointsYn = calcPointsYn;
    }

    public String getArChargeTransferYn() {
        return this.arChargeTransferYn;
    }

    public FinancialTransactions arChargeTransferYn(String arChargeTransferYn) {
        this.setArChargeTransferYn(arChargeTransferYn);
        return this;
    }

    public void setArChargeTransferYn(String arChargeTransferYn) {
        this.arChargeTransferYn = arChargeTransferYn;
    }

    public String getProcessed8300Yn() {
        return this.processed8300Yn;
    }

    public FinancialTransactions processed8300Yn(String processed8300Yn) {
        this.setProcessed8300Yn(processed8300Yn);
        return this;
    }

    public void setProcessed8300Yn(String processed8300Yn) {
        this.processed8300Yn = processed8300Yn;
    }

    public String getAsbFlag() {
        return this.asbFlag;
    }

    public FinancialTransactions asbFlag(String asbFlag) {
        this.setAsbFlag(asbFlag);
        return this;
    }

    public void setAsbFlag(String asbFlag) {
        this.asbFlag = asbFlag;
    }

    public String getPostitYn() {
        return this.postitYn;
    }

    public FinancialTransactions postitYn(String postitYn) {
        this.setPostitYn(postitYn);
        return this;
    }

    public void setPostitYn(String postitYn) {
        this.postitYn = postitYn;
    }

    public String getAutoSettleYn() {
        return this.autoSettleYn;
    }

    public FinancialTransactions autoSettleYn(String autoSettleYn) {
        this.setAutoSettleYn(autoSettleYn);
        return this;
    }

    public void setAutoSettleYn(String autoSettleYn) {
        this.autoSettleYn = autoSettleYn;
    }

    public String getDepTaxTransferedYn() {
        return this.depTaxTransferedYn;
    }

    public FinancialTransactions depTaxTransferedYn(String depTaxTransferedYn) {
        this.setDepTaxTransferedYn(depTaxTransferedYn);
        return this;
    }

    public void setDepTaxTransferedYn(String depTaxTransferedYn) {
        this.depTaxTransferedYn = depTaxTransferedYn;
    }

    public String getAutoCreditbillYn() {
        return this.autoCreditbillYn;
    }

    public FinancialTransactions autoCreditbillYn(String autoCreditbillYn) {
        this.setAutoCreditbillYn(autoCreditbillYn);
        return this;
    }

    public void setAutoCreditbillYn(String autoCreditbillYn) {
        this.autoCreditbillYn = autoCreditbillYn;
    }

    public String getAsbOnlyPostTaxesOnceYn() {
        return this.asbOnlyPostTaxesOnceYn;
    }

    public FinancialTransactions asbOnlyPostTaxesOnceYn(String asbOnlyPostTaxesOnceYn) {
        this.setAsbOnlyPostTaxesOnceYn(asbOnlyPostTaxesOnceYn);
        return this;
    }

    public void setAsbOnlyPostTaxesOnceYn(String asbOnlyPostTaxesOnceYn) {
        this.asbOnlyPostTaxesOnceYn = asbOnlyPostTaxesOnceYn;
    }

    public String getRoundFactorYn() {
        return this.roundFactorYn;
    }

    public FinancialTransactions roundFactorYn(String roundFactorYn) {
        this.setRoundFactorYn(roundFactorYn);
        return this;
    }

    public void setRoundFactorYn(String roundFactorYn) {
        this.roundFactorYn = roundFactorYn;
    }

    public String getDepPostingFlag() {
        return this.depPostingFlag;
    }

    public FinancialTransactions depPostingFlag(String depPostingFlag) {
        this.setDepPostingFlag(depPostingFlag);
        return this;
    }

    public void setDepPostingFlag(String depPostingFlag) {
        this.depPostingFlag = depPostingFlag;
    }

    public String getCorrectionYn() {
        return this.correctionYn;
    }

    public FinancialTransactions correctionYn(String correctionYn) {
        this.setCorrectionYn(correctionYn);
        return this;
    }

    public void setCorrectionYn(String correctionYn) {
        this.correctionYn = correctionYn;
    }

    public String getRoutedYn() {
        return this.routedYn;
    }

    public FinancialTransactions routedYn(String routedYn) {
        this.setRoutedYn(routedYn);
        return this;
    }

    public void setRoutedYn(String routedYn) {
        this.routedYn = routedYn;
    }

    public String getUpsellChargeYn() {
        return this.upsellChargeYn;
    }

    public FinancialTransactions upsellChargeYn(String upsellChargeYn) {
        this.setUpsellChargeYn(upsellChargeYn);
        return this;
    }

    public void setUpsellChargeYn(String upsellChargeYn) {
        this.upsellChargeYn = upsellChargeYn;
    }

    public String getAdvanceBillYn() {
        return this.advanceBillYn;
    }

    public FinancialTransactions advanceBillYn(String advanceBillYn) {
        this.setAdvanceBillYn(advanceBillYn);
        return this;
    }

    public void setAdvanceBillYn(String advanceBillYn) {
        this.advanceBillYn = advanceBillYn;
    }

    public String getAdvanceBillReversedYn() {
        return this.advanceBillReversedYn;
    }

    public FinancialTransactions advanceBillReversedYn(String advanceBillReversedYn) {
        this.setAdvanceBillReversedYn(advanceBillReversedYn);
        return this;
    }

    public void setAdvanceBillReversedYn(String advanceBillReversedYn) {
        this.advanceBillReversedYn = advanceBillReversedYn;
    }

    public String getIncTaxDeductedYn() {
        return this.incTaxDeductedYn;
    }

    public FinancialTransactions incTaxDeductedYn(String incTaxDeductedYn) {
        this.setIncTaxDeductedYn(incTaxDeductedYn);
        return this;
    }

    public void setIncTaxDeductedYn(String incTaxDeductedYn) {
        this.incTaxDeductedYn = incTaxDeductedYn;
    }

    public String getGpAwardCancelledYn() {
        return this.gpAwardCancelledYn;
    }

    public FinancialTransactions gpAwardCancelledYn(String gpAwardCancelledYn) {
        this.setGpAwardCancelledYn(gpAwardCancelledYn);
        return this;
    }

    public void setGpAwardCancelledYn(String gpAwardCancelledYn) {
        this.gpAwardCancelledYn = gpAwardCancelledYn;
    }

    public String getServiceRecoveryAdjustmentYn() {
        return this.serviceRecoveryAdjustmentYn;
    }

    public FinancialTransactions serviceRecoveryAdjustmentYn(String serviceRecoveryAdjustmentYn) {
        this.setServiceRecoveryAdjustmentYn(serviceRecoveryAdjustmentYn);
        return this;
    }

    public void setServiceRecoveryAdjustmentYn(String serviceRecoveryAdjustmentYn) {
        this.serviceRecoveryAdjustmentYn = serviceRecoveryAdjustmentYn;
    }

    public String getSplitType() {
        return this.splitType;
    }

    public FinancialTransactions splitType(String splitType) {
        this.setSplitType(splitType);
        return this;
    }

    public void setSplitType(String splitType) {
        this.splitType = splitType;
    }

    public String getBucketRedempYn() {
        return this.bucketRedempYn;
    }

    public FinancialTransactions bucketRedempYn(String bucketRedempYn) {
        this.setBucketRedempYn(bucketRedempYn);
        return this;
    }

    public void setBucketRedempYn(String bucketRedempYn) {
        this.bucketRedempYn = bucketRedempYn;
    }

    public String getVatOffsetYn() {
        return this.vatOffsetYn;
    }

    public FinancialTransactions vatOffsetYn(String vatOffsetYn) {
        this.setVatOffsetYn(vatOffsetYn);
        return this;
    }

    public void setVatOffsetYn(String vatOffsetYn) {
        this.vatOffsetYn = vatOffsetYn;
    }

    public String getForexTaxYn() {
        return this.forexTaxYn;
    }

    public FinancialTransactions forexTaxYn(String forexTaxYn) {
        this.setForexTaxYn(forexTaxYn);
        return this;
    }

    public void setForexTaxYn(String forexTaxYn) {
        this.forexTaxYn = forexTaxYn;
    }

    public String getStampDutyYn() {
        return this.stampDutyYn;
    }

    public FinancialTransactions stampDutyYn(String stampDutyYn) {
        this.setStampDutyYn(stampDutyYn);
        return this;
    }

    public void setStampDutyYn(String stampDutyYn) {
        this.stampDutyYn = stampDutyYn;
    }

    public String getCovers() {
        return this.covers;
    }

    public FinancialTransactions covers(String covers) {
        this.setCovers(covers);
        return this;
    }

    public void setCovers(String covers) {
        this.covers = covers;
    }

    public String getAdvGenerateAdjustment() {
        return this.advGenerateAdjustment;
    }

    public FinancialTransactions advGenerateAdjustment(String advGenerateAdjustment) {
        this.setAdvGenerateAdjustment(advGenerateAdjustment);
        return this;
    }

    public void setAdvGenerateAdjustment(String advGenerateAdjustment) {
        this.advGenerateAdjustment = advGenerateAdjustment;
    }

    public String getExpInvoiceType() {
        return this.expInvoiceType;
    }

    public FinancialTransactions expInvoiceType(String expInvoiceType) {
        this.setExpInvoiceType(expInvoiceType);
        return this;
    }

    public void setExpInvoiceType(String expInvoiceType) {
        this.expInvoiceType = expInvoiceType;
    }

    public String getFolioType() {
        return this.folioType;
    }

    public FinancialTransactions folioType(String folioType) {
        this.setFolioType(folioType);
        return this;
    }

    public void setFolioType(String folioType) {
        this.folioType = folioType;
    }

    public String getOrgFolioType() {
        return this.orgFolioType;
    }

    public FinancialTransactions orgFolioType(String orgFolioType) {
        this.setOrgFolioType(orgFolioType);
        return this;
    }

    public void setOrgFolioType(String orgFolioType) {
        this.orgFolioType = orgFolioType;
    }

    public String getInvoiceType() {
        return this.invoiceType;
    }

    public FinancialTransactions invoiceType(String invoiceType) {
        this.setInvoiceType(invoiceType);
        return this;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getArState() {
        return this.arState;
    }

    public FinancialTransactions arState(String arState) {
        this.setArState(arState);
        return this;
    }

    public void setArState(String arState) {
        this.arState = arState;
    }

    public String getExchangeType() {
        return this.exchangeType;
    }

    public FinancialTransactions exchangeType(String exchangeType) {
        this.setExchangeType(exchangeType);
        return this;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getRecptType() {
        return this.recptType;
    }

    public FinancialTransactions recptType(String recptType) {
        this.setRecptType(recptType);
        return this;
    }

    public void setRecptType(String recptType) {
        this.recptType = recptType;
    }

    public String getRoomClass() {
        return this.roomClass;
    }

    public FinancialTransactions roomClass(String roomClass) {
        this.setRoomClass(roomClass);
        return this;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public String getResort() {
        return this.resort;
    }

    public FinancialTransactions resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public String getTcGroup() {
        return this.tcGroup;
    }

    public FinancialTransactions tcGroup(String tcGroup) {
        this.setTcGroup(tcGroup);
        return this;
    }

    public void setTcGroup(String tcGroup) {
        this.tcGroup = tcGroup;
    }

    public String getTcSubgroup() {
        return this.tcSubgroup;
    }

    public FinancialTransactions tcSubgroup(String tcSubgroup) {
        this.setTcSubgroup(tcSubgroup);
        return this;
    }

    public void setTcSubgroup(String tcSubgroup) {
        this.tcSubgroup = tcSubgroup;
    }

    public String getTrxCode() {
        return this.trxCode;
    }

    public FinancialTransactions trxCode(String trxCode) {
        this.setTrxCode(trxCode);
        return this;
    }

    public void setTrxCode(String trxCode) {
        this.trxCode = trxCode;
    }

    public String getRoom() {
        return this.room;
    }

    public FinancialTransactions room(String room) {
        this.setRoom(room);
        return this;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTclCode1() {
        return this.tclCode1;
    }

    public FinancialTransactions tclCode1(String tclCode1) {
        this.setTclCode1(tclCode1);
        return this;
    }

    public void setTclCode1(String tclCode1) {
        this.tclCode1 = tclCode1;
    }

    public String getCurrency() {
        return this.currency;
    }

    public FinancialTransactions currency(String currency) {
        this.setCurrency(currency);
        return this;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFtGeneratedType() {
        return this.ftGeneratedType;
    }

    public FinancialTransactions ftGeneratedType(String ftGeneratedType) {
        this.setFtGeneratedType(ftGeneratedType);
        return this;
    }

    public void setFtGeneratedType(String ftGeneratedType) {
        this.ftGeneratedType = ftGeneratedType;
    }

    public String getTclCode2() {
        return this.tclCode2;
    }

    public FinancialTransactions tclCode2(String tclCode2) {
        this.setTclCode2(tclCode2);
        return this;
    }

    public void setTclCode2(String tclCode2) {
        this.tclCode2 = tclCode2;
    }

    public String getMarketCode() {
        return this.marketCode;
    }

    public FinancialTransactions marketCode(String marketCode) {
        this.setMarketCode(marketCode);
        return this;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getSourceCode() {
        return this.sourceCode;
    }

    public FinancialTransactions sourceCode(String sourceCode) {
        this.setSourceCode(sourceCode);
        return this;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getRateCode() {
        return this.rateCode;
    }

    public FinancialTransactions rateCode(String rateCode) {
        this.setRateCode(rateCode);
        return this;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getHotelAcct() {
        return this.hotelAcct;
    }

    public FinancialTransactions hotelAcct(String hotelAcct) {
        this.setHotelAcct(hotelAcct);
        return this;
    }

    public void setHotelAcct(String hotelAcct) {
        this.hotelAcct = hotelAcct;
    }

    public String getReasonCode() {
        return this.reasonCode;
    }

    public FinancialTransactions reasonCode(String reasonCode) {
        this.setReasonCode(reasonCode);
        return this;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getProduct() {
        return this.product;
    }

    public FinancialTransactions product(String product) {
        this.setProduct(product);
        return this;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTargetResort() {
        return this.targetResort;
    }

    public FinancialTransactions targetResort(String targetResort) {
        this.setTargetResort(targetResort);
        return this;
    }

    public void setTargetResort(String targetResort) {
        this.targetResort = targetResort;
    }

    public String getNameTaxType() {
        return this.nameTaxType;
    }

    public FinancialTransactions nameTaxType(String nameTaxType) {
        this.setNameTaxType(nameTaxType);
        return this;
    }

    public void setNameTaxType(String nameTaxType) {
        this.nameTaxType = nameTaxType;
    }

    public String getTaxInvNo() {
        return this.taxInvNo;
    }

    public FinancialTransactions taxInvNo(String taxInvNo) {
        this.setTaxInvNo(taxInvNo);
        return this;
    }

    public void setTaxInvNo(String taxInvNo) {
        this.taxInvNo = taxInvNo;
    }

    public String getApprovalCode() {
        return this.approvalCode;
    }

    public FinancialTransactions approvalCode(String approvalCode) {
        this.setApprovalCode(approvalCode);
        return this;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    public FinancialTransactions approvalStatus(String approvalStatus) {
        this.setApprovalStatus(approvalStatus);
        return this;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getCompLinkTrxCode() {
        return this.compLinkTrxCode;
    }

    public FinancialTransactions compLinkTrxCode(String compLinkTrxCode) {
        this.setCompLinkTrxCode(compLinkTrxCode);
        return this;
    }

    public void setCompLinkTrxCode(String compLinkTrxCode) {
        this.compLinkTrxCode = compLinkTrxCode;
    }

    public String getCompTypeCode() {
        return this.compTypeCode;
    }

    public FinancialTransactions compTypeCode(String compTypeCode) {
        this.setCompTypeCode(compTypeCode);
        return this;
    }

    public void setCompTypeCode(String compTypeCode) {
        this.compTypeCode = compTypeCode;
    }

    public String getCouponNo() {
        return this.couponNo;
    }

    public FinancialTransactions couponNo(String couponNo) {
        this.setCouponNo(couponNo);
        return this;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public String getOriginalRoom() {
        return this.originalRoom;
    }

    public FinancialTransactions originalRoom(String originalRoom) {
        this.setOriginalRoom(originalRoom);
        return this;
    }

    public void setOriginalRoom(String originalRoom) {
        this.originalRoom = originalRoom;
    }

    public String getAllowanceType() {
        return this.allowanceType;
    }

    public FinancialTransactions allowanceType(String allowanceType) {
        this.setAllowanceType(allowanceType);
        return this;
    }

    public void setAllowanceType(String allowanceType) {
        this.allowanceType = allowanceType;
    }

    public String getAdvGenerateTrxCode() {
        return this.advGenerateTrxCode;
    }

    public FinancialTransactions advGenerateTrxCode(String advGenerateTrxCode) {
        this.setAdvGenerateTrxCode(advGenerateTrxCode);
        return this;
    }

    public void setAdvGenerateTrxCode(String advGenerateTrxCode) {
        this.advGenerateTrxCode = advGenerateTrxCode;
    }

    public String getTrxServiceType() {
        return this.trxServiceType;
    }

    public FinancialTransactions trxServiceType(String trxServiceType) {
        this.setTrxServiceType(trxServiceType);
        return this;
    }

    public void setTrxServiceType(String trxServiceType) {
        this.trxServiceType = trxServiceType;
    }

    public String getPostingType() {
        return this.postingType;
    }

    public FinancialTransactions postingType(String postingType) {
        this.setPostingType(postingType);
        return this;
    }

    public void setPostingType(String postingType) {
        this.postingType = postingType;
    }

    public String getParallelCurrency() {
        return this.parallelCurrency;
    }

    public FinancialTransactions parallelCurrency(String parallelCurrency) {
        this.setParallelCurrency(parallelCurrency);
        return this;
    }

    public void setParallelCurrency(String parallelCurrency) {
        this.parallelCurrency = parallelCurrency;
    }

    public String getContractCurrency() {
        return this.contractCurrency;
    }

    public FinancialTransactions contractCurrency(String contractCurrency) {
        this.setContractCurrency(contractCurrency);
        return this;
    }

    public void setContractCurrency(String contractCurrency) {
        this.contractCurrency = contractCurrency;
    }

    public String getFbaCertificateNumber() {
        return this.fbaCertificateNumber;
    }

    public FinancialTransactions fbaCertificateNumber(String fbaCertificateNumber) {
        this.setFbaCertificateNumber(fbaCertificateNumber);
        return this;
    }

    public void setFbaCertificateNumber(String fbaCertificateNumber) {
        this.fbaCertificateNumber = fbaCertificateNumber;
    }

    public String getPostingRhythm() {
        return this.postingRhythm;
    }

    public FinancialTransactions postingRhythm(String postingRhythm) {
        this.setPostingRhythm(postingRhythm);
        return this;
    }

    public void setPostingRhythm(String postingRhythm) {
        this.postingRhythm = postingRhythm;
    }

    public String getAsbTaxFlag() {
        return this.asbTaxFlag;
    }

    public FinancialTransactions asbTaxFlag(String asbTaxFlag) {
        this.setAsbTaxFlag(asbTaxFlag);
        return this;
    }

    public void setAsbTaxFlag(String asbTaxFlag) {
        this.asbTaxFlag = asbTaxFlag;
    }

    public String getPackageArrangementCode() {
        return this.packageArrangementCode;
    }

    public FinancialTransactions packageArrangementCode(String packageArrangementCode) {
        this.setPackageArrangementCode(packageArrangementCode);
        return this;
    }

    public void setPackageArrangementCode(String packageArrangementCode) {
        this.packageArrangementCode = packageArrangementCode;
    }

    public String getGpAwardCode() {
        return this.gpAwardCode;
    }

    public FinancialTransactions gpAwardCode(String gpAwardCode) {
        this.setGpAwardCode(gpAwardCode);
        return this;
    }

    public void setGpAwardCode(String gpAwardCode) {
        this.gpAwardCode = gpAwardCode;
    }

    public String getGpAwardCancelCode() {
        return this.gpAwardCancelCode;
    }

    public FinancialTransactions gpAwardCancelCode(String gpAwardCancelCode) {
        this.setGpAwardCancelCode(gpAwardCancelCode);
        return this;
    }

    public void setGpAwardCancelCode(String gpAwardCancelCode) {
        this.gpAwardCancelCode = gpAwardCancelCode;
    }

    public String getServiceRecoveryDeptCode() {
        return this.serviceRecoveryDeptCode;
    }

    public FinancialTransactions serviceRecoveryDeptCode(String serviceRecoveryDeptCode) {
        this.setServiceRecoveryDeptCode(serviceRecoveryDeptCode);
        return this;
    }

    public void setServiceRecoveryDeptCode(String serviceRecoveryDeptCode) {
        this.serviceRecoveryDeptCode = serviceRecoveryDeptCode;
    }

    public String getBucketCode() {
        return this.bucketCode;
    }

    public FinancialTransactions bucketCode(String bucketCode) {
        this.setBucketCode(bucketCode);
        return this;
    }

    public void setBucketCode(String bucketCode) {
        this.bucketCode = bucketCode;
    }

    public String getTaxRateType() {
        return this.taxRateType;
    }

    public FinancialTransactions taxRateType(String taxRateType) {
        this.setTaxRateType(taxRateType);
        return this;
    }

    public void setTaxRateType(String taxRateType) {
        this.taxRateType = taxRateType;
    }

    public String getChequeNumber() {
        return this.chequeNumber;
    }

    public FinancialTransactions chequeNumber(String chequeNumber) {
        this.setChequeNumber(chequeNumber);
        return this;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public String getPasserByName() {
        return this.passerByName;
    }

    public FinancialTransactions passerByName(String passerByName) {
        this.setPasserByName(passerByName);
        return this;
    }

    public void setPasserByName(String passerByName) {
        this.passerByName = passerByName;
    }

    public String getEsignedReceiptName() {
        return this.esignedReceiptName;
    }

    public FinancialTransactions esignedReceiptName(String esignedReceiptName) {
        this.setEsignedReceiptName(esignedReceiptName);
        return this;
    }

    public void setEsignedReceiptName(String esignedReceiptName) {
        this.esignedReceiptName = esignedReceiptName;
    }

    public String getRemark() {
        return this.remark;
    }

    public FinancialTransactions remark(String remark) {
        this.setRemark(remark);
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReference() {
        return this.reference;
    }

    public FinancialTransactions reference(String reference) {
        this.setReference(reference);
        return this;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getoTrxDesc() {
        return this.oTrxDesc;
    }

    public FinancialTransactions oTrxDesc(String oTrxDesc) {
        this.setoTrxDesc(oTrxDesc);
        return this;
    }

    public void setoTrxDesc(String oTrxDesc) {
        this.oTrxDesc = oTrxDesc;
    }

    public String getComments() {
        return this.comments;
    }

    public FinancialTransactions comments(String comments) {
        this.setComments(comments);
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFiscalBillNo() {
        return this.fiscalBillNo;
    }

    public FinancialTransactions fiscalBillNo(String fiscalBillNo) {
        this.setFiscalBillNo(fiscalBillNo);
        return this;
    }

    public void setFiscalBillNo(String fiscalBillNo) {
        this.fiscalBillNo = fiscalBillNo;
    }

    public String getExtSysResultMsg() {
        return this.extSysResultMsg;
    }

    public FinancialTransactions extSysResultMsg(String extSysResultMsg) {
        this.setExtSysResultMsg(extSysResultMsg);
        return this;
    }

    public void setExtSysResultMsg(String extSysResultMsg) {
        this.extSysResultMsg = extSysResultMsg;
    }

    public String getQueueName() {
        return this.queueName;
    }

    public FinancialTransactions queueName(String queueName) {
        this.setQueueName(queueName);
        return this;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public FinancialTransactions paymentType(String paymentType) {
        this.setPaymentType(paymentType);
        return this;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCcRefundPosting() {
        return this.ccRefundPosting;
    }

    public FinancialTransactions ccRefundPosting(String ccRefundPosting) {
        this.setCcRefundPosting(ccRefundPosting);
        return this;
    }

    public void setCcRefundPosting(String ccRefundPosting) {
        this.ccRefundPosting = ccRefundPosting;
    }

    public String getThresholdEntityType() {
        return this.thresholdEntityType;
    }

    public FinancialTransactions thresholdEntityType(String thresholdEntityType) {
        this.setThresholdEntityType(thresholdEntityType);
        return this;
    }

    public void setThresholdEntityType(String thresholdEntityType) {
        this.thresholdEntityType = thresholdEntityType;
    }

    public String getThresholdTreatmentFlag() {
        return this.thresholdTreatmentFlag;
    }

    public FinancialTransactions thresholdTreatmentFlag(String thresholdTreatmentFlag) {
        this.setThresholdTreatmentFlag(thresholdTreatmentFlag);
        return this;
    }

    public void setThresholdTreatmentFlag(String thresholdTreatmentFlag) {
        this.thresholdTreatmentFlag = thresholdTreatmentFlag;
    }

    public String getPaymentSurchargeType() {
        return this.paymentSurchargeType;
    }

    public FinancialTransactions paymentSurchargeType(String paymentSurchargeType) {
        this.setPaymentSurchargeType(paymentSurchargeType);
        return this;
    }

    public void setPaymentSurchargeType(String paymentSurchargeType) {
        this.paymentSurchargeType = paymentSurchargeType;
    }

    public String getPropertyBillPrefix() {
        return this.propertyBillPrefix;
    }

    public FinancialTransactions propertyBillPrefix(String propertyBillPrefix) {
        this.setPropertyBillPrefix(propertyBillPrefix);
        return this;
    }

    public void setPropertyBillPrefix(String propertyBillPrefix) {
        this.propertyBillPrefix = propertyBillPrefix;
    }

    public String getTaxElements() {
        return this.taxElements;
    }

    public FinancialTransactions taxElements(String taxElements) {
        this.setTaxElements(taxElements);
        return this;
    }

    public void setTaxElements(String taxElements) {
        this.taxElements = taxElements;
    }

    public String getNumberDialed() {
        return this.numberDialed;
    }

    public FinancialTransactions numberDialed(String numberDialed) {
        this.setNumberDialed(numberDialed);
        return this;
    }

    public void setNumberDialed(String numberDialed) {
        this.numberDialed = numberDialed;
    }

    public String getCheckFileId() {
        return this.checkFileId;
    }

    public FinancialTransactions checkFileId(String checkFileId) {
        this.setCheckFileId(checkFileId);
        return this;
    }

    public void setCheckFileId(String checkFileId) {
        this.checkFileId = checkFileId;
    }

    public String getExtTrxId() {
        return this.extTrxId;
    }

    public FinancialTransactions extTrxId(String extTrxId) {
        this.setExtTrxId(extTrxId);
        return this;
    }

    public void setExtTrxId(String extTrxId) {
        this.extTrxId = extTrxId;
    }

    public String getPackageTrxType() {
        return this.packageTrxType;
    }

    public FinancialTransactions packageTrxType(String packageTrxType) {
        this.setPackageTrxType(packageTrxType);
        return this;
    }

    public void setPackageTrxType(String packageTrxType) {
        this.packageTrxType = packageTrxType;
    }

    public String getExpOriginalInvoice() {
        return this.expOriginalInvoice;
    }

    public FinancialTransactions expOriginalInvoice(String expOriginalInvoice) {
        this.setExpOriginalInvoice(expOriginalInvoice);
        return this;
    }

    public void setExpOriginalInvoice(String expOriginalInvoice) {
        this.expOriginalInvoice = expOriginalInvoice;
    }

    public String getDepositTransactionId() {
        return this.depositTransactionId;
    }

    public FinancialTransactions depositTransactionId(String depositTransactionId) {
        this.setDepositTransactionId(depositTransactionId);
        return this;
    }

    public void setDepositTransactionId(String depositTransactionId) {
        this.depositTransactionId = depositTransactionId;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FinancialTransactions)) {
            return false;
        }
        return getId() != null && getId().equals(((FinancialTransactions) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FinancialTransactions{" +
            "id=" + getId() +
            ", trxNo=" + getTrxNo() +
            ", ftSubtype='" + getFtSubtype() + "'" +
            ", invoiceCloseDate='" + getInvoiceCloseDate() + "'" +
            ", arTransferDate='" + getArTransferDate() + "'" +
            ", trxDate='" + getTrxDate() + "'" +
            ", businessDate='" + getBusinessDate() + "'" +
            ", insertDate='" + getInsertDate() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", trnsActivityDate='" + getTrnsActivityDate() + "'" +
            ", approvalDate='" + getApprovalDate() + "'" +
            ", postingDate='" + getPostingDate() + "'" +
            ", exchangeDate='" + getExchangeDate() + "'" +
            ", routingDate='" + getRoutingDate() + "'" +
            ", effectiveDate='" + getEffectiveDate() + "'" +
            ", customChargeDate='" + getCustomChargeDate() + "'" +
            ", recptNo=" + getRecptNo() +
            ", trxNoAdjust=" + getTrxNoAdjust() +
            ", trxNoAddedBy=" + getTrxNoAddedBy() +
            ", trxNoAgainstPackage=" + getTrxNoAgainstPackage() +
            ", trxNoHeader=" + getTrxNoHeader() +
            ", arNumber=" + getArNumber() +
            ", resvNameId=" + getResvNameId() +
            ", cashierId=" + getCashierId() +
            ", creditCardId=" + getCreditCardId() +
            ", nameId=" + getNameId() +
            ", tranActionId=" + getTranActionId() +
            ", finDmlSeqNo=" + getFinDmlSeqNo() +
            ", routingInstrnId=" + getRoutingInstrnId() +
            ", fromResvId=" + getFromResvId() +
            ", genCashierId=" + getGenCashierId() +
            ", folioNo=" + getFolioNo() +
            ", invoiceNo=" + getInvoiceNo() +
            ", insertUser=" + getInsertUser() +
            ", updateUser=" + getUpdateUser() +
            ", arrangementId=" + getArrangementId() +
            ", trnsFromAcct=" + getTrnsFromAcct() +
            ", trnsToAcct=" + getTrnsToAcct() +
            ", billNo=" + getBillNo() +
            ", revisionNo=" + getRevisionNo() +
            ", resvDepositId=" + getResvDepositId() +
            ", linkTrxNo=" + getLinkTrxNo() +
            ", authorizerId=" + getAuthorizerId() +
            ", compLinkTrxNo=" + getCompLinkTrxNo() +
            ", mtrxNoAgainstPackage=" + getMtrxNoAgainstPackage() +
            ", forexCommPerc=" + getForexCommPerc() +
            ", forexCommAmount=" + getForexCommAmount() +
            ", articleId=" + getArticleId() +
            ", toResvNameId=" + getToResvNameId() +
            ", roomNts=" + getRoomNts() +
            ", orgArLedDebit=" + getOrgArLedDebit() +
            ", closureNo=" + getClosureNo() +
            ", originalResvNameId=" + getOriginalResvNameId() +
            ", orgBillNo=" + getOrgBillNo() +
            ", membershipId=" + getMembershipId() +
            ", installments=" + getInstallments() +
            ", contractGuestDebit=" + getContractGuestDebit() +
            ", contractGuestCredit=" + getContractGuestCredit() +
            ", contractNetAmount=" + getContractNetAmount() +
            ", contractGrossAmount=" + getContractGrossAmount() +
            ", postitNo=" + getPostitNo() +
            ", ccTrxFeeAmount=" + getCcTrxFeeAmount() +
            ", changeDue=" + getChangeDue() +
            ", postingSourceNameId=" + getPostingSourceNameId() +
            ", bonusCheckId=" + getBonusCheckId() +
            ", roundLinkTrxno=" + getRoundLinkTrxno() +
            ", reversePaymentTrxNo=" + getReversePaymentTrxNo() +
            ", electronicVoucherNo=" + getElectronicVoucherNo() +
            ", thresholdDiversionId=" + getThresholdDiversionId() +
            ", thresholdEntityQty=" + getThresholdEntityQty() +
            ", trxNoSplit=" + getTrxNoSplit() +
            ", exchDiffTrxNo=" + getExchDiffTrxNo() +
            ", associatedTrxNo=" + getAssociatedTrxNo() +
            ", taxRate=" + getTaxRate() +
            ", propChargeId=" + getPropChargeId() +
            ", quantity=" + getQuantity() +
            ", netAmount=" + getNetAmount() +
            ", grossAmount=" + getGrossAmount() +
            ", cashierOpeningBalance=" + getCashierOpeningBalance() +
            ", pricePerUnit=" + getPricePerUnit() +
            ", trxAmount=" + getTrxAmount() +
            ", postedAmount=" + getPostedAmount() +
            ", guestAccountCredit=" + getGuestAccountCredit() +
            ", exchangeRate=" + getExchangeRate() +
            ", guestAccountDebit=" + getGuestAccountDebit() +
            ", cashierCredit=" + getCashierCredit() +
            ", cashierDebit=" + getCashierDebit() +
            ", packageCredit=" + getPackageCredit() +
            ", packageDebit=" + getPackageDebit() +
            ", depLedCredit=" + getDepLedCredit() +
            ", depLedDebit=" + getDepLedDebit() +
            ", revenueAmt=" + getRevenueAmt() +
            ", arLedCredit=" + getArLedCredit() +
            ", arLedDebit=" + getArLedDebit() +
            ", euroExchangeRate=" + getEuroExchangeRate() +
            ", inhDebit=" + getInhDebit() +
            ", inhCredit=" + getInhCredit() +
            ", packageAllowance=" + getPackageAllowance() +
            ", parallelGuestCredit=" + getParallelGuestCredit() +
            ", parallelGuestDebit=" + getParallelGuestDebit() +
            ", parallelNetAmount=" + getParallelNetAmount() +
            ", parallelGrossAmount=" + getParallelGrossAmount() +
            ", orgPostedAmount=" + getOrgPostedAmount() +
            ", roomNtsEffective=" + getRoomNtsEffective() +
            ", paymentSurchargeAmt=" + getPaymentSurchargeAmt() +
            ", folioView=" + getFolioView() +
            ", taxInclusiveYn='" + getTaxInclusiveYn() + "'" +
            ", deferredYn='" + getDeferredYn() + "'" +
            ", indAdjustmentYn='" + getIndAdjustmentYn() + "'" +
            ", fixedChargesYn='" + getFixedChargesYn() + "'" +
            ", taCommissionableYn='" + getTaCommissionableYn() + "'" +
            ", taxGeneratedYn='" + getTaxGeneratedYn() + "'" +
            ", compressedYn='" + getCompressedYn() + "'" +
            ", displayYn='" + getDisplayYn() + "'" +
            ", collAgentPostingYn='" + getCollAgentPostingYn() + "'" +
            ", fiscalTrxCodeType='" + getFiscalTrxCodeType() + "'" +
            ", deferredTaxesYn='" + getDeferredTaxesYn() + "'" +
            ", advancedGenerateYn='" + getAdvancedGenerateYn() + "'" +
            ", forexType='" + getForexType() + "'" +
            ", taCommissionNetYn='" + getTaCommissionNetYn() + "'" +
            ", sourceCommissionNetYn='" + getSourceCommissionNetYn() + "'" +
            ", settlementFlag='" + getSettlementFlag() + "'" +
            ", accTypeFlag='" + getAccTypeFlag() + "'" +
            ", profitLossFlag='" + getProfitLossFlag() + "'" +
            ", proformaYn='" + getProformaYn() + "'" +
            ", holdYn='" + getHoldYn() + "'" +
            ", exchangeDifferenceYn='" + getExchangeDifferenceYn() + "'" +
            ", calcPointsYn='" + getCalcPointsYn() + "'" +
            ", arChargeTransferYn='" + getArChargeTransferYn() + "'" +
            ", processed8300Yn='" + getProcessed8300Yn() + "'" +
            ", asbFlag='" + getAsbFlag() + "'" +
            ", postitYn='" + getPostitYn() + "'" +
            ", autoSettleYn='" + getAutoSettleYn() + "'" +
            ", depTaxTransferedYn='" + getDepTaxTransferedYn() + "'" +
            ", autoCreditbillYn='" + getAutoCreditbillYn() + "'" +
            ", asbOnlyPostTaxesOnceYn='" + getAsbOnlyPostTaxesOnceYn() + "'" +
            ", roundFactorYn='" + getRoundFactorYn() + "'" +
            ", depPostingFlag='" + getDepPostingFlag() + "'" +
            ", correctionYn='" + getCorrectionYn() + "'" +
            ", routedYn='" + getRoutedYn() + "'" +
            ", upsellChargeYn='" + getUpsellChargeYn() + "'" +
            ", advanceBillYn='" + getAdvanceBillYn() + "'" +
            ", advanceBillReversedYn='" + getAdvanceBillReversedYn() + "'" +
            ", incTaxDeductedYn='" + getIncTaxDeductedYn() + "'" +
            ", gpAwardCancelledYn='" + getGpAwardCancelledYn() + "'" +
            ", serviceRecoveryAdjustmentYn='" + getServiceRecoveryAdjustmentYn() + "'" +
            ", splitType='" + getSplitType() + "'" +
            ", bucketRedempYn='" + getBucketRedempYn() + "'" +
            ", vatOffsetYn='" + getVatOffsetYn() + "'" +
            ", forexTaxYn='" + getForexTaxYn() + "'" +
            ", stampDutyYn='" + getStampDutyYn() + "'" +
            ", covers='" + getCovers() + "'" +
            ", advGenerateAdjustment='" + getAdvGenerateAdjustment() + "'" +
            ", expInvoiceType='" + getExpInvoiceType() + "'" +
            ", folioType='" + getFolioType() + "'" +
            ", orgFolioType='" + getOrgFolioType() + "'" +
            ", invoiceType='" + getInvoiceType() + "'" +
            ", arState='" + getArState() + "'" +
            ", exchangeType='" + getExchangeType() + "'" +
            ", recptType='" + getRecptType() + "'" +
            ", roomClass='" + getRoomClass() + "'" +
            ", resort='" + getResort() + "'" +
            ", tcGroup='" + getTcGroup() + "'" +
            ", tcSubgroup='" + getTcSubgroup() + "'" +
            ", trxCode='" + getTrxCode() + "'" +
            ", room='" + getRoom() + "'" +
            ", tclCode1='" + getTclCode1() + "'" +
            ", currency='" + getCurrency() + "'" +
            ", ftGeneratedType='" + getFtGeneratedType() + "'" +
            ", tclCode2='" + getTclCode2() + "'" +
            ", marketCode='" + getMarketCode() + "'" +
            ", sourceCode='" + getSourceCode() + "'" +
            ", rateCode='" + getRateCode() + "'" +
            ", hotelAcct='" + getHotelAcct() + "'" +
            ", reasonCode='" + getReasonCode() + "'" +
            ", product='" + getProduct() + "'" +
            ", targetResort='" + getTargetResort() + "'" +
            ", nameTaxType='" + getNameTaxType() + "'" +
            ", taxInvNo='" + getTaxInvNo() + "'" +
            ", approvalCode='" + getApprovalCode() + "'" +
            ", approvalStatus='" + getApprovalStatus() + "'" +
            ", compLinkTrxCode='" + getCompLinkTrxCode() + "'" +
            ", compTypeCode='" + getCompTypeCode() + "'" +
            ", couponNo='" + getCouponNo() + "'" +
            ", originalRoom='" + getOriginalRoom() + "'" +
            ", allowanceType='" + getAllowanceType() + "'" +
            ", advGenerateTrxCode='" + getAdvGenerateTrxCode() + "'" +
            ", trxServiceType='" + getTrxServiceType() + "'" +
            ", postingType='" + getPostingType() + "'" +
            ", parallelCurrency='" + getParallelCurrency() + "'" +
            ", contractCurrency='" + getContractCurrency() + "'" +
            ", fbaCertificateNumber='" + getFbaCertificateNumber() + "'" +
            ", postingRhythm='" + getPostingRhythm() + "'" +
            ", asbTaxFlag='" + getAsbTaxFlag() + "'" +
            ", packageArrangementCode='" + getPackageArrangementCode() + "'" +
            ", gpAwardCode='" + getGpAwardCode() + "'" +
            ", gpAwardCancelCode='" + getGpAwardCancelCode() + "'" +
            ", serviceRecoveryDeptCode='" + getServiceRecoveryDeptCode() + "'" +
            ", bucketCode='" + getBucketCode() + "'" +
            ", taxRateType='" + getTaxRateType() + "'" +
            ", chequeNumber='" + getChequeNumber() + "'" +
            ", passerByName='" + getPasserByName() + "'" +
            ", esignedReceiptName='" + getEsignedReceiptName() + "'" +
            ", remark='" + getRemark() + "'" +
            ", reference='" + getReference() + "'" +
            ", oTrxDesc='" + getoTrxDesc() + "'" +
            ", comments='" + getComments() + "'" +
            ", fiscalBillNo='" + getFiscalBillNo() + "'" +
            ", extSysResultMsg='" + getExtSysResultMsg() + "'" +
            ", queueName='" + getQueueName() + "'" +
            ", paymentType='" + getPaymentType() + "'" +
            ", ccRefundPosting='" + getCcRefundPosting() + "'" +
            ", thresholdEntityType='" + getThresholdEntityType() + "'" +
            ", thresholdTreatmentFlag='" + getThresholdTreatmentFlag() + "'" +
            ", paymentSurchargeType='" + getPaymentSurchargeType() + "'" +
            ", propertyBillPrefix='" + getPropertyBillPrefix() + "'" +
            ", taxElements='" + getTaxElements() + "'" +
            ", numberDialed='" + getNumberDialed() + "'" +
            ", checkFileId='" + getCheckFileId() + "'" +
            ", extTrxId='" + getExtTrxId() + "'" +
            ", packageTrxType='" + getPackageTrxType() + "'" +
            ", expOriginalInvoice='" + getExpOriginalInvoice() + "'" +
            ", depositTransactionId='" + getDepositTransactionId() + "'" +
            "}";
    }
}
