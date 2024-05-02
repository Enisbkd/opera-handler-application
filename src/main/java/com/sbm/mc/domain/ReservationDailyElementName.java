package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ReservationDailyElementName.
 */
@Entity
@Table(name = "reservation_daily_element_name")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReservationDailyElementName implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "resort")
    private String resort;

    @Column(name = "resv_name_id")
    private Integer resvNameId;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "resv_daily_el_seq")
    private Integer resvDailyElSeq;

    @Column(name = "travel_agent_id")
    private Integer travelAgentId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "source_id")
    private Integer sourceId;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "share_payment_type")
    private String sharePaymentType;

    @Column(name = "share_amount", precision = 21, scale = 2)
    private BigDecimal shareAmount;

    @Column(name = "share_prcnt", precision = 21, scale = 2)
    private BigDecimal sharePrcnt;

    @Column(name = "adults")
    private Integer adults;

    @Column(name = "children")
    private Integer children;

    @Column(name = "discount_amt", precision = 21, scale = 2)
    private BigDecimal discountAmt;

    @Column(name = "discount_prcnt", precision = 21, scale = 2)
    private BigDecimal discountPrcnt;

    @Column(name = "discount_reason_code")
    private String discountReasonCode;

    @Column(name = "fixed_rate_yn")
    private String fixedRateYn;

    @Column(name = "base_rate_amount", precision = 21, scale = 2)
    private BigDecimal baseRateAmount;

    @Column(name = "auto_post_amount", precision = 21, scale = 2)
    private BigDecimal autoPostAmount;

    @Column(name = "share_priority")
    private Integer sharePriority;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "last_share_calculation")
    private String lastShareCalculation;

    @Column(name = "insert_action_instance_id")
    private Integer insertActionInstanceId;

    @Column(name = "dml_seq_no")
    private Integer dmlSeqNo;

    @Column(name = "net_room_amt", precision = 21, scale = 2)
    private BigDecimal netRoomAmt;

    @Column(name = "room_tax", precision = 21, scale = 2)
    private BigDecimal roomTax;

    @Column(name = "pkg_amt", precision = 21, scale = 2)
    private BigDecimal pkgAmt;

    @Column(name = "pkg_tax", precision = 21, scale = 2)
    private BigDecimal pkgTax;

    @Column(name = "gross_rate_amt", precision = 21, scale = 2)
    private BigDecimal grossRateAmt;

    @Column(name = "adults_tax_free")
    private Integer adultsTaxFree;

    @Column(name = "children_tax_free")
    private Integer childrenTaxFree;

    @Column(name = "children_1")
    private Integer children1;

    @Column(name = "children_2")
    private Integer children2;

    @Column(name = "children_3")
    private Integer children3;

    @Column(name = "rate_code")
    private String rateCode;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "exchange_posting_type")
    private String exchangePostingType;

    @Column(name = "membership_points")
    private Integer membershipPoints;

    @Column(name = "children_4")
    private Integer children4;

    @Column(name = "children_5")
    private Integer children5;

    @Column(name = "commission_code")
    private String commissionCode;

    @Column(name = "award_code_1")
    private String awardCode1;

    @Column(name = "award_code_2")
    private String awardCode2;

    @Column(name = "award_code_3")
    private String awardCode3;

    @Column(name = "award_code_4")
    private String awardCode4;

    @Column(name = "award_code_5")
    private String awardCode5;

    @Column(name = "award_voucher_1")
    private String awardVoucher1;

    @Column(name = "award_voucher_2")
    private String awardVoucher2;

    @Column(name = "award_voucher_3")
    private String awardVoucher3;

    @Column(name = "award_voucher_4")
    private String awardVoucher4;

    @Column(name = "award_voucher_5")
    private String awardVoucher5;

    @Column(name = "do_not_move_yn")
    private String doNotMoveYn;

    @Column(name = "award_code")
    private String awardCode;

    @Column(name = "points")
    private Integer points;

    @Column(name = "upsell_charge", precision = 21, scale = 2)
    private BigDecimal upsellCharge;

    @Column(name = "points_eligibility_code")
    private String pointsEligibilityCode;

    @Column(name = "commission_paid", precision = 21, scale = 2)
    private BigDecimal commissionPaid;

    @Column(name = "resv_contact_id")
    private Integer resvContactId;

    @Column(name = "billing_contact_id")
    private Integer billingContactId;

    @Column(name = "share_amount_original", precision = 21, scale = 2)
    private BigDecimal shareAmountOriginal;

    @Column(name = "referral_yn")
    private String referralYn;

    @Column(name = "bxgy_discount_yn")
    private String bxgyDiscountYn;

    @Column(name = "commissionable_yn")
    private String commissionableYn;

    @Column(name = "based_on_rule")
    private String basedOnRule;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ReservationDailyElementName id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResort() {
        return this.resort;
    }

    public ReservationDailyElementName resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public Integer getResvNameId() {
        return this.resvNameId;
    }

    public ReservationDailyElementName resvNameId(Integer resvNameId) {
        this.setResvNameId(resvNameId);
        return this;
    }

    public void setResvNameId(Integer resvNameId) {
        this.resvNameId = resvNameId;
    }

    public LocalDate getReservationDate() {
        return this.reservationDate;
    }

    public ReservationDailyElementName reservationDate(LocalDate reservationDate) {
        this.setReservationDate(reservationDate);
        return this;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getResvDailyElSeq() {
        return this.resvDailyElSeq;
    }

    public ReservationDailyElementName resvDailyElSeq(Integer resvDailyElSeq) {
        this.setResvDailyElSeq(resvDailyElSeq);
        return this;
    }

    public void setResvDailyElSeq(Integer resvDailyElSeq) {
        this.resvDailyElSeq = resvDailyElSeq;
    }

    public Integer getTravelAgentId() {
        return this.travelAgentId;
    }

    public ReservationDailyElementName travelAgentId(Integer travelAgentId) {
        this.setTravelAgentId(travelAgentId);
        return this;
    }

    public void setTravelAgentId(Integer travelAgentId) {
        this.travelAgentId = travelAgentId;
    }

    public Integer getCompanyId() {
        return this.companyId;
    }

    public ReservationDailyElementName companyId(Integer companyId) {
        this.setCompanyId(companyId);
        return this;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getSourceId() {
        return this.sourceId;
    }

    public ReservationDailyElementName sourceId(Integer sourceId) {
        this.setSourceId(sourceId);
        return this;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public ReservationDailyElementName groupId(Integer groupId) {
        this.setGroupId(groupId);
        return this;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getSharePaymentType() {
        return this.sharePaymentType;
    }

    public ReservationDailyElementName sharePaymentType(String sharePaymentType) {
        this.setSharePaymentType(sharePaymentType);
        return this;
    }

    public void setSharePaymentType(String sharePaymentType) {
        this.sharePaymentType = sharePaymentType;
    }

    public BigDecimal getShareAmount() {
        return this.shareAmount;
    }

    public ReservationDailyElementName shareAmount(BigDecimal shareAmount) {
        this.setShareAmount(shareAmount);
        return this;
    }

    public void setShareAmount(BigDecimal shareAmount) {
        this.shareAmount = shareAmount;
    }

    public BigDecimal getSharePrcnt() {
        return this.sharePrcnt;
    }

    public ReservationDailyElementName sharePrcnt(BigDecimal sharePrcnt) {
        this.setSharePrcnt(sharePrcnt);
        return this;
    }

    public void setSharePrcnt(BigDecimal sharePrcnt) {
        this.sharePrcnt = sharePrcnt;
    }

    public Integer getAdults() {
        return this.adults;
    }

    public ReservationDailyElementName adults(Integer adults) {
        this.setAdults(adults);
        return this;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return this.children;
    }

    public ReservationDailyElementName children(Integer children) {
        this.setChildren(children);
        return this;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public BigDecimal getDiscountAmt() {
        return this.discountAmt;
    }

    public ReservationDailyElementName discountAmt(BigDecimal discountAmt) {
        this.setDiscountAmt(discountAmt);
        return this;
    }

    public void setDiscountAmt(BigDecimal discountAmt) {
        this.discountAmt = discountAmt;
    }

    public BigDecimal getDiscountPrcnt() {
        return this.discountPrcnt;
    }

    public ReservationDailyElementName discountPrcnt(BigDecimal discountPrcnt) {
        this.setDiscountPrcnt(discountPrcnt);
        return this;
    }

    public void setDiscountPrcnt(BigDecimal discountPrcnt) {
        this.discountPrcnt = discountPrcnt;
    }

    public String getDiscountReasonCode() {
        return this.discountReasonCode;
    }

    public ReservationDailyElementName discountReasonCode(String discountReasonCode) {
        this.setDiscountReasonCode(discountReasonCode);
        return this;
    }

    public void setDiscountReasonCode(String discountReasonCode) {
        this.discountReasonCode = discountReasonCode;
    }

    public String getFixedRateYn() {
        return this.fixedRateYn;
    }

    public ReservationDailyElementName fixedRateYn(String fixedRateYn) {
        this.setFixedRateYn(fixedRateYn);
        return this;
    }

    public void setFixedRateYn(String fixedRateYn) {
        this.fixedRateYn = fixedRateYn;
    }

    public BigDecimal getBaseRateAmount() {
        return this.baseRateAmount;
    }

    public ReservationDailyElementName baseRateAmount(BigDecimal baseRateAmount) {
        this.setBaseRateAmount(baseRateAmount);
        return this;
    }

    public void setBaseRateAmount(BigDecimal baseRateAmount) {
        this.baseRateAmount = baseRateAmount;
    }

    public BigDecimal getAutoPostAmount() {
        return this.autoPostAmount;
    }

    public ReservationDailyElementName autoPostAmount(BigDecimal autoPostAmount) {
        this.setAutoPostAmount(autoPostAmount);
        return this;
    }

    public void setAutoPostAmount(BigDecimal autoPostAmount) {
        this.autoPostAmount = autoPostAmount;
    }

    public Integer getSharePriority() {
        return this.sharePriority;
    }

    public ReservationDailyElementName sharePriority(Integer sharePriority) {
        this.setSharePriority(sharePriority);
        return this;
    }

    public void setSharePriority(Integer sharePriority) {
        this.sharePriority = sharePriority;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public ReservationDailyElementName insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public ReservationDailyElementName insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public ReservationDailyElementName updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public ReservationDailyElementName updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getLastShareCalculation() {
        return this.lastShareCalculation;
    }

    public ReservationDailyElementName lastShareCalculation(String lastShareCalculation) {
        this.setLastShareCalculation(lastShareCalculation);
        return this;
    }

    public void setLastShareCalculation(String lastShareCalculation) {
        this.lastShareCalculation = lastShareCalculation;
    }

    public Integer getInsertActionInstanceId() {
        return this.insertActionInstanceId;
    }

    public ReservationDailyElementName insertActionInstanceId(Integer insertActionInstanceId) {
        this.setInsertActionInstanceId(insertActionInstanceId);
        return this;
    }

    public void setInsertActionInstanceId(Integer insertActionInstanceId) {
        this.insertActionInstanceId = insertActionInstanceId;
    }

    public Integer getDmlSeqNo() {
        return this.dmlSeqNo;
    }

    public ReservationDailyElementName dmlSeqNo(Integer dmlSeqNo) {
        this.setDmlSeqNo(dmlSeqNo);
        return this;
    }

    public void setDmlSeqNo(Integer dmlSeqNo) {
        this.dmlSeqNo = dmlSeqNo;
    }

    public BigDecimal getNetRoomAmt() {
        return this.netRoomAmt;
    }

    public ReservationDailyElementName netRoomAmt(BigDecimal netRoomAmt) {
        this.setNetRoomAmt(netRoomAmt);
        return this;
    }

    public void setNetRoomAmt(BigDecimal netRoomAmt) {
        this.netRoomAmt = netRoomAmt;
    }

    public BigDecimal getRoomTax() {
        return this.roomTax;
    }

    public ReservationDailyElementName roomTax(BigDecimal roomTax) {
        this.setRoomTax(roomTax);
        return this;
    }

    public void setRoomTax(BigDecimal roomTax) {
        this.roomTax = roomTax;
    }

    public BigDecimal getPkgAmt() {
        return this.pkgAmt;
    }

    public ReservationDailyElementName pkgAmt(BigDecimal pkgAmt) {
        this.setPkgAmt(pkgAmt);
        return this;
    }

    public void setPkgAmt(BigDecimal pkgAmt) {
        this.pkgAmt = pkgAmt;
    }

    public BigDecimal getPkgTax() {
        return this.pkgTax;
    }

    public ReservationDailyElementName pkgTax(BigDecimal pkgTax) {
        this.setPkgTax(pkgTax);
        return this;
    }

    public void setPkgTax(BigDecimal pkgTax) {
        this.pkgTax = pkgTax;
    }

    public BigDecimal getGrossRateAmt() {
        return this.grossRateAmt;
    }

    public ReservationDailyElementName grossRateAmt(BigDecimal grossRateAmt) {
        this.setGrossRateAmt(grossRateAmt);
        return this;
    }

    public void setGrossRateAmt(BigDecimal grossRateAmt) {
        this.grossRateAmt = grossRateAmt;
    }

    public Integer getAdultsTaxFree() {
        return this.adultsTaxFree;
    }

    public ReservationDailyElementName adultsTaxFree(Integer adultsTaxFree) {
        this.setAdultsTaxFree(adultsTaxFree);
        return this;
    }

    public void setAdultsTaxFree(Integer adultsTaxFree) {
        this.adultsTaxFree = adultsTaxFree;
    }

    public Integer getChildrenTaxFree() {
        return this.childrenTaxFree;
    }

    public ReservationDailyElementName childrenTaxFree(Integer childrenTaxFree) {
        this.setChildrenTaxFree(childrenTaxFree);
        return this;
    }

    public void setChildrenTaxFree(Integer childrenTaxFree) {
        this.childrenTaxFree = childrenTaxFree;
    }

    public Integer getChildren1() {
        return this.children1;
    }

    public ReservationDailyElementName children1(Integer children1) {
        this.setChildren1(children1);
        return this;
    }

    public void setChildren1(Integer children1) {
        this.children1 = children1;
    }

    public Integer getChildren2() {
        return this.children2;
    }

    public ReservationDailyElementName children2(Integer children2) {
        this.setChildren2(children2);
        return this;
    }

    public void setChildren2(Integer children2) {
        this.children2 = children2;
    }

    public Integer getChildren3() {
        return this.children3;
    }

    public ReservationDailyElementName children3(Integer children3) {
        this.setChildren3(children3);
        return this;
    }

    public void setChildren3(Integer children3) {
        this.children3 = children3;
    }

    public String getRateCode() {
        return this.rateCode;
    }

    public ReservationDailyElementName rateCode(String rateCode) {
        this.setRateCode(rateCode);
        return this;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public ReservationDailyElementName currencyCode(String currencyCode) {
        this.setCurrencyCode(currencyCode);
        return this;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getExchangePostingType() {
        return this.exchangePostingType;
    }

    public ReservationDailyElementName exchangePostingType(String exchangePostingType) {
        this.setExchangePostingType(exchangePostingType);
        return this;
    }

    public void setExchangePostingType(String exchangePostingType) {
        this.exchangePostingType = exchangePostingType;
    }

    public Integer getMembershipPoints() {
        return this.membershipPoints;
    }

    public ReservationDailyElementName membershipPoints(Integer membershipPoints) {
        this.setMembershipPoints(membershipPoints);
        return this;
    }

    public void setMembershipPoints(Integer membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    public Integer getChildren4() {
        return this.children4;
    }

    public ReservationDailyElementName children4(Integer children4) {
        this.setChildren4(children4);
        return this;
    }

    public void setChildren4(Integer children4) {
        this.children4 = children4;
    }

    public Integer getChildren5() {
        return this.children5;
    }

    public ReservationDailyElementName children5(Integer children5) {
        this.setChildren5(children5);
        return this;
    }

    public void setChildren5(Integer children5) {
        this.children5 = children5;
    }

    public String getCommissionCode() {
        return this.commissionCode;
    }

    public ReservationDailyElementName commissionCode(String commissionCode) {
        this.setCommissionCode(commissionCode);
        return this;
    }

    public void setCommissionCode(String commissionCode) {
        this.commissionCode = commissionCode;
    }

    public String getAwardCode1() {
        return this.awardCode1;
    }

    public ReservationDailyElementName awardCode1(String awardCode1) {
        this.setAwardCode1(awardCode1);
        return this;
    }

    public void setAwardCode1(String awardCode1) {
        this.awardCode1 = awardCode1;
    }

    public String getAwardCode2() {
        return this.awardCode2;
    }

    public ReservationDailyElementName awardCode2(String awardCode2) {
        this.setAwardCode2(awardCode2);
        return this;
    }

    public void setAwardCode2(String awardCode2) {
        this.awardCode2 = awardCode2;
    }

    public String getAwardCode3() {
        return this.awardCode3;
    }

    public ReservationDailyElementName awardCode3(String awardCode3) {
        this.setAwardCode3(awardCode3);
        return this;
    }

    public void setAwardCode3(String awardCode3) {
        this.awardCode3 = awardCode3;
    }

    public String getAwardCode4() {
        return this.awardCode4;
    }

    public ReservationDailyElementName awardCode4(String awardCode4) {
        this.setAwardCode4(awardCode4);
        return this;
    }

    public void setAwardCode4(String awardCode4) {
        this.awardCode4 = awardCode4;
    }

    public String getAwardCode5() {
        return this.awardCode5;
    }

    public ReservationDailyElementName awardCode5(String awardCode5) {
        this.setAwardCode5(awardCode5);
        return this;
    }

    public void setAwardCode5(String awardCode5) {
        this.awardCode5 = awardCode5;
    }

    public String getAwardVoucher1() {
        return this.awardVoucher1;
    }

    public ReservationDailyElementName awardVoucher1(String awardVoucher1) {
        this.setAwardVoucher1(awardVoucher1);
        return this;
    }

    public void setAwardVoucher1(String awardVoucher1) {
        this.awardVoucher1 = awardVoucher1;
    }

    public String getAwardVoucher2() {
        return this.awardVoucher2;
    }

    public ReservationDailyElementName awardVoucher2(String awardVoucher2) {
        this.setAwardVoucher2(awardVoucher2);
        return this;
    }

    public void setAwardVoucher2(String awardVoucher2) {
        this.awardVoucher2 = awardVoucher2;
    }

    public String getAwardVoucher3() {
        return this.awardVoucher3;
    }

    public ReservationDailyElementName awardVoucher3(String awardVoucher3) {
        this.setAwardVoucher3(awardVoucher3);
        return this;
    }

    public void setAwardVoucher3(String awardVoucher3) {
        this.awardVoucher3 = awardVoucher3;
    }

    public String getAwardVoucher4() {
        return this.awardVoucher4;
    }

    public ReservationDailyElementName awardVoucher4(String awardVoucher4) {
        this.setAwardVoucher4(awardVoucher4);
        return this;
    }

    public void setAwardVoucher4(String awardVoucher4) {
        this.awardVoucher4 = awardVoucher4;
    }

    public String getAwardVoucher5() {
        return this.awardVoucher5;
    }

    public ReservationDailyElementName awardVoucher5(String awardVoucher5) {
        this.setAwardVoucher5(awardVoucher5);
        return this;
    }

    public void setAwardVoucher5(String awardVoucher5) {
        this.awardVoucher5 = awardVoucher5;
    }

    public String getDoNotMoveYn() {
        return this.doNotMoveYn;
    }

    public ReservationDailyElementName doNotMoveYn(String doNotMoveYn) {
        this.setDoNotMoveYn(doNotMoveYn);
        return this;
    }

    public void setDoNotMoveYn(String doNotMoveYn) {
        this.doNotMoveYn = doNotMoveYn;
    }

    public String getAwardCode() {
        return this.awardCode;
    }

    public ReservationDailyElementName awardCode(String awardCode) {
        this.setAwardCode(awardCode);
        return this;
    }

    public void setAwardCode(String awardCode) {
        this.awardCode = awardCode;
    }

    public Integer getPoints() {
        return this.points;
    }

    public ReservationDailyElementName points(Integer points) {
        this.setPoints(points);
        return this;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public BigDecimal getUpsellCharge() {
        return this.upsellCharge;
    }

    public ReservationDailyElementName upsellCharge(BigDecimal upsellCharge) {
        this.setUpsellCharge(upsellCharge);
        return this;
    }

    public void setUpsellCharge(BigDecimal upsellCharge) {
        this.upsellCharge = upsellCharge;
    }

    public String getPointsEligibilityCode() {
        return this.pointsEligibilityCode;
    }

    public ReservationDailyElementName pointsEligibilityCode(String pointsEligibilityCode) {
        this.setPointsEligibilityCode(pointsEligibilityCode);
        return this;
    }

    public void setPointsEligibilityCode(String pointsEligibilityCode) {
        this.pointsEligibilityCode = pointsEligibilityCode;
    }

    public BigDecimal getCommissionPaid() {
        return this.commissionPaid;
    }

    public ReservationDailyElementName commissionPaid(BigDecimal commissionPaid) {
        this.setCommissionPaid(commissionPaid);
        return this;
    }

    public void setCommissionPaid(BigDecimal commissionPaid) {
        this.commissionPaid = commissionPaid;
    }

    public Integer getResvContactId() {
        return this.resvContactId;
    }

    public ReservationDailyElementName resvContactId(Integer resvContactId) {
        this.setResvContactId(resvContactId);
        return this;
    }

    public void setResvContactId(Integer resvContactId) {
        this.resvContactId = resvContactId;
    }

    public Integer getBillingContactId() {
        return this.billingContactId;
    }

    public ReservationDailyElementName billingContactId(Integer billingContactId) {
        this.setBillingContactId(billingContactId);
        return this;
    }

    public void setBillingContactId(Integer billingContactId) {
        this.billingContactId = billingContactId;
    }

    public BigDecimal getShareAmountOriginal() {
        return this.shareAmountOriginal;
    }

    public ReservationDailyElementName shareAmountOriginal(BigDecimal shareAmountOriginal) {
        this.setShareAmountOriginal(shareAmountOriginal);
        return this;
    }

    public void setShareAmountOriginal(BigDecimal shareAmountOriginal) {
        this.shareAmountOriginal = shareAmountOriginal;
    }

    public String getReferralYn() {
        return this.referralYn;
    }

    public ReservationDailyElementName referralYn(String referralYn) {
        this.setReferralYn(referralYn);
        return this;
    }

    public void setReferralYn(String referralYn) {
        this.referralYn = referralYn;
    }

    public String getBxgyDiscountYn() {
        return this.bxgyDiscountYn;
    }

    public ReservationDailyElementName bxgyDiscountYn(String bxgyDiscountYn) {
        this.setBxgyDiscountYn(bxgyDiscountYn);
        return this;
    }

    public void setBxgyDiscountYn(String bxgyDiscountYn) {
        this.bxgyDiscountYn = bxgyDiscountYn;
    }

    public String getCommissionableYn() {
        return this.commissionableYn;
    }

    public ReservationDailyElementName commissionableYn(String commissionableYn) {
        this.setCommissionableYn(commissionableYn);
        return this;
    }

    public void setCommissionableYn(String commissionableYn) {
        this.commissionableYn = commissionableYn;
    }

    public String getBasedOnRule() {
        return this.basedOnRule;
    }

    public ReservationDailyElementName basedOnRule(String basedOnRule) {
        this.setBasedOnRule(basedOnRule);
        return this;
    }

    public void setBasedOnRule(String basedOnRule) {
        this.basedOnRule = basedOnRule;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReservationDailyElementName)) {
            return false;
        }
        return getId() != null && getId().equals(((ReservationDailyElementName) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReservationDailyElementName{" +
            "id=" + getId() +
            ", resort='" + getResort() + "'" +
            ", resvNameId=" + getResvNameId() +
            ", reservationDate='" + getReservationDate() + "'" +
            ", resvDailyElSeq=" + getResvDailyElSeq() +
            ", travelAgentId=" + getTravelAgentId() +
            ", companyId=" + getCompanyId() +
            ", sourceId=" + getSourceId() +
            ", groupId=" + getGroupId() +
            ", sharePaymentType='" + getSharePaymentType() + "'" +
            ", shareAmount=" + getShareAmount() +
            ", sharePrcnt=" + getSharePrcnt() +
            ", adults=" + getAdults() +
            ", children=" + getChildren() +
            ", discountAmt=" + getDiscountAmt() +
            ", discountPrcnt=" + getDiscountPrcnt() +
            ", discountReasonCode='" + getDiscountReasonCode() + "'" +
            ", fixedRateYn='" + getFixedRateYn() + "'" +
            ", baseRateAmount=" + getBaseRateAmount() +
            ", autoPostAmount=" + getAutoPostAmount() +
            ", sharePriority=" + getSharePriority() +
            ", insertUser=" + getInsertUser() +
            ", insertDate='" + getInsertDate() + "'" +
            ", updateUser=" + getUpdateUser() +
            ", updateDate='" + getUpdateDate() + "'" +
            ", lastShareCalculation='" + getLastShareCalculation() + "'" +
            ", insertActionInstanceId=" + getInsertActionInstanceId() +
            ", dmlSeqNo=" + getDmlSeqNo() +
            ", netRoomAmt=" + getNetRoomAmt() +
            ", roomTax=" + getRoomTax() +
            ", pkgAmt=" + getPkgAmt() +
            ", pkgTax=" + getPkgTax() +
            ", grossRateAmt=" + getGrossRateAmt() +
            ", adultsTaxFree=" + getAdultsTaxFree() +
            ", childrenTaxFree=" + getChildrenTaxFree() +
            ", children1=" + getChildren1() +
            ", children2=" + getChildren2() +
            ", children3=" + getChildren3() +
            ", rateCode='" + getRateCode() + "'" +
            ", currencyCode='" + getCurrencyCode() + "'" +
            ", exchangePostingType='" + getExchangePostingType() + "'" +
            ", membershipPoints=" + getMembershipPoints() +
            ", children4=" + getChildren4() +
            ", children5=" + getChildren5() +
            ", commissionCode='" + getCommissionCode() + "'" +
            ", awardCode1='" + getAwardCode1() + "'" +
            ", awardCode2='" + getAwardCode2() + "'" +
            ", awardCode3='" + getAwardCode3() + "'" +
            ", awardCode4='" + getAwardCode4() + "'" +
            ", awardCode5='" + getAwardCode5() + "'" +
            ", awardVoucher1='" + getAwardVoucher1() + "'" +
            ", awardVoucher2='" + getAwardVoucher2() + "'" +
            ", awardVoucher3='" + getAwardVoucher3() + "'" +
            ", awardVoucher4='" + getAwardVoucher4() + "'" +
            ", awardVoucher5='" + getAwardVoucher5() + "'" +
            ", doNotMoveYn='" + getDoNotMoveYn() + "'" +
            ", awardCode='" + getAwardCode() + "'" +
            ", points=" + getPoints() +
            ", upsellCharge=" + getUpsellCharge() +
            ", pointsEligibilityCode='" + getPointsEligibilityCode() + "'" +
            ", commissionPaid=" + getCommissionPaid() +
            ", resvContactId=" + getResvContactId() +
            ", billingContactId=" + getBillingContactId() +
            ", shareAmountOriginal=" + getShareAmountOriginal() +
            ", referralYn='" + getReferralYn() + "'" +
            ", bxgyDiscountYn='" + getBxgyDiscountYn() + "'" +
            ", commissionableYn='" + getCommissionableYn() + "'" +
            ", basedOnRule='" + getBasedOnRule() + "'" +
            "}";
    }
}
