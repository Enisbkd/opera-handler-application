package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ReservationName.
 */
@Entity
@Table(name = "reservation_name")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReservationName implements Serializable {

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

    @Column(name = "name_id")
    private Integer nameId;

    @Column(name = "name_usage_type")
    private String nameUsageType;

    @Column(name = "contact_name_id")
    private Integer contactNameId;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "resv_status")
    private String resvStatus;

    @Column(name = "commission_code")
    private String commissionCode;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "phone_id")
    private Integer phoneId;

    @Column(name = "fax_yn")
    private String faxYn;

    @Column(name = "mail_yn")
    private String mailYn;

    @Column(name = "print_rate_yn")
    private String printRateYn;

    @Column(name = "report_id")
    private String reportId;

    @Column(name = "resv_no")
    private Integer resvNo;

    @Column(name = "confirmation_no")
    private String confirmationNo;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "fax_id")
    private Integer faxId;

    @Column(name = "email_id")
    private Integer emailId;

    @Column(name = "email_yn")
    private String emailYn;

    @Column(name = "consumer_yn")
    private String consumerYn;

    @Column(name = "credit_card_id")
    private Integer creditCardId;

    @Column(name = "financially_responsible_yn")
    private String financiallyResponsibleYn;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "intermediary_yn")
    private String intermediaryYn;

    @Column(name = "posting_allowed_yn")
    private String postingAllowedYn;

    @Column(name = "display_color")
    private String displayColor;

    @Column(name = "actual_check_in_date")
    private LocalDate actualCheckInDate;

    @Column(name = "trunc_actual_check_in_date")
    private LocalDate truncActualCheckInDate;

    @Column(name = "actual_check_out_date")
    private LocalDate actualCheckOutDate;

    @Column(name = "trunc_actual_check_out_date")
    private LocalDate truncActualCheckOutDate;

    @Column(name = "credit_limit")
    private Integer creditLimit;

    @Column(name = "authorized_by")
    private Integer authorizedBy;

    @Column(name = "parent_resv_name_id")
    private Integer parentResvNameId;

    @Column(name = "cancellation_no")
    private String cancellationNo;

    @Column(name = "cancellation_reason_code")
    private String cancellationReasonCode;

    @Column(name = "cancellation_reason_desc")
    private String cancellationReasonDesc;

    @Column(name = "arrival_transport_type")
    private String arrivalTransportType;

    @Column(name = "arrival_station_code")
    private String arrivalStationCode;

    @Column(name = "arrival_carrier_code")
    private String arrivalCarrierCode;

    @Column(name = "arrival_transport_code")
    private String arrivalTransportCode;

    @Column(name = "arrival_date_time")
    private LocalDate arrivalDateTime;

    @Column(name = "arrival_estimate_time")
    private LocalDate arrivalEstimateTime;

    @Column(name = "arrival_tranportation_yn")
    private String arrivalTranportationYn;

    @Column(name = "arrival_comments")
    private String arrivalComments;

    @Column(name = "departure_transport_type")
    private String departureTransportType;

    @Column(name = "departure_station_code")
    private String departureStationCode;

    @Column(name = "departure_carrier_code")
    private String departureCarrierCode;

    @Column(name = "departure_transport_code")
    private String departureTransportCode;

    @Column(name = "departure_date_time")
    private LocalDate departureDateTime;

    @Column(name = "departure_estimate_time")
    private LocalDate departureEstimateTime;

    @Column(name = "departure_transportation_yn")
    private String departureTransportationYn;

    @Column(name = "departure_comments")
    private String departureComments;

    @Column(name = "cancellation_date")
    private LocalDate cancellationDate;

    @Column(name = "guarantee_code")
    private String guaranteeCode;

    @Column(name = "wl_reason_description")
    private String wlReasonDescription;

    @Column(name = "wl_reason_code")
    private String wlReasonCode;

    @Column(name = "wl_priority")
    private String wlPriority;

    @Column(name = "do_not_move_room")
    private String doNotMoveRoom;

    @Column(name = "external_reference")
    private String externalReference;

    @Column(name = "party_code")
    private String partyCode;

    @Column(name = "walkin_yn")
    private String walkinYn;

    @Column(name = "original_end_date")
    private LocalDate originalEndDate;

    @Column(name = "approval_amount_calc_method")
    private Integer approvalAmountCalcMethod;

    @Column(name = "amount_percent")
    private Integer amountPercent;

    @Column(name = "name_tax_type")
    private String nameTaxType;

    @Column(name = "tax_exempt_no")
    private String taxExemptNo;

    @Column(name = "room_features")
    private String roomFeatures;

    @Column(name = "wl_telephone_no")
    private String wlTelephoneNo;

    @Column(name = "video_checkout_yn")
    private String videoCheckoutYn;

    @Column(name = "discount_amt")
    private Integer discountAmt;

    @Column(name = "discount_prcnt")
    private Integer discountPrcnt;

    @Column(name = "discount_reason_code")
    private String discountReasonCode;

    @Column(name = "commission_paid")
    private Integer commissionPaid;

    @Column(name = "commission_hold_code")
    private String commissionHoldCode;

    @Column(name = "trunc_begin_date")
    private LocalDate truncBeginDate;

    @Column(name = "trunc_end_date")
    private LocalDate truncEndDate;

    @Column(name = "sguest_name")
    private String sguestName;

    @Column(name = "membership_id")
    private Integer membershipId;

    @Column(name = "udfc_01")
    private String udfc01;

    @Column(name = "udfc_02")
    private String udfc02;

    @Column(name = "udfc_03")
    private String udfc03;

    @Column(name = "udfc_04")
    private String udfc04;

    @Column(name = "udfc_05")
    private String udfc05;

    @Column(name = "udfc_06")
    private String udfc06;

    @Column(name = "udfc_07")
    private String udfc07;

    @Column(name = "udfc_08")
    private String udfc08;

    @Column(name = "udfc_09")
    private String udfc09;

    @Column(name = "udfc_10")
    private String udfc10;

    @Column(name = "udfc_11")
    private String udfc11;

    @Column(name = "udfc_12")
    private String udfc12;

    @Column(name = "udfc_13")
    private String udfc13;

    @Column(name = "udfc_14")
    private String udfc14;

    @Column(name = "udfc_15")
    private String udfc15;

    @Column(name = "udfc_16")
    private String udfc16;

    @Column(name = "udfc_17")
    private String udfc17;

    @Column(name = "udfc_18")
    private String udfc18;

    @Column(name = "udfc_19")
    private String udfc19;

    @Column(name = "udfc_20")
    private String udfc20;

    @Column(name = "udfc_21")
    private String udfc21;

    @Column(name = "udfc_22")
    private String udfc22;

    @Column(name = "udfc_23")
    private String udfc23;

    @Column(name = "udfc_24")
    private String udfc24;

    @Column(name = "udfc_25")
    private String udfc25;

    @Column(name = "udfc_26")
    private String udfc26;

    @Column(name = "udfc_27")
    private String udfc27;

    @Column(name = "udfc_28")
    private String udfc28;

    @Column(name = "udfc_29")
    private String udfc29;

    @Column(name = "udfc_30")
    private String udfc30;

    @Column(name = "udfc_31")
    private String udfc31;

    @Column(name = "udfc_32")
    private String udfc32;

    @Column(name = "udfc_33")
    private String udfc33;

    @Column(name = "udfc_34")
    private String udfc34;

    @Column(name = "udfc_35")
    private String udfc35;

    @Column(name = "udfc_36")
    private String udfc36;

    @Column(name = "udfc_37")
    private String udfc37;

    @Column(name = "udfc_38")
    private String udfc38;

    @Column(name = "udfc_39")
    private String udfc39;

    @Column(name = "udfc_40")
    private String udfc40;

    @Column(name = "udfn_01")
    private Integer udfn01;

    @Column(name = "udfn_02")
    private Integer udfn02;

    @Column(name = "udfn_03")
    private Integer udfn03;

    @Column(name = "udfn_04")
    private Integer udfn04;

    @Column(name = "udfn_05")
    private Integer udfn05;

    @Column(name = "udfn_06")
    private Integer udfn06;

    @Column(name = "udfn_07")
    private Integer udfn07;

    @Column(name = "udfn_08")
    private Integer udfn08;

    @Column(name = "udfn_09")
    private Integer udfn09;

    @Column(name = "udfn_10")
    private Integer udfn10;

    @Column(name = "udfn_11")
    private Integer udfn11;

    @Column(name = "udfn_12")
    private Integer udfn12;

    @Column(name = "udfn_13")
    private Integer udfn13;

    @Column(name = "udfn_14")
    private Integer udfn14;

    @Column(name = "udfn_15")
    private Integer udfn15;

    @Column(name = "udfn_16")
    private Integer udfn16;

    @Column(name = "udfn_17")
    private Integer udfn17;

    @Column(name = "udfn_18")
    private Integer udfn18;

    @Column(name = "udfn_19")
    private Integer udfn19;

    @Column(name = "udfn_20")
    private Integer udfn20;

    @Column(name = "udfn_21")
    private Integer udfn21;

    @Column(name = "udfn_22")
    private Integer udfn22;

    @Column(name = "udfn_23")
    private Integer udfn23;

    @Column(name = "udfn_24")
    private Integer udfn24;

    @Column(name = "udfn_25")
    private Integer udfn25;

    @Column(name = "udfn_26")
    private Integer udfn26;

    @Column(name = "udfn_27")
    private Integer udfn27;

    @Column(name = "udfn_28")
    private Integer udfn28;

    @Column(name = "udfn_29")
    private Integer udfn29;

    @Column(name = "udfn_30")
    private Integer udfn30;

    @Column(name = "udfn_31")
    private Integer udfn31;

    @Column(name = "udfn_32")
    private Integer udfn32;

    @Column(name = "udfn_33")
    private Integer udfn33;

    @Column(name = "udfn_34")
    private Integer udfn34;

    @Column(name = "udfn_35")
    private Integer udfn35;

    @Column(name = "udfn_36")
    private Integer udfn36;

    @Column(name = "udfn_37")
    private Integer udfn37;

    @Column(name = "udfn_38")
    private Integer udfn38;

    @Column(name = "udfn_39")
    private Integer udfn39;

    @Column(name = "udfn_40")
    private Integer udfn40;

    @Column(name = "udfd_01")
    private LocalDate udfd01;

    @Column(name = "udfd_02")
    private LocalDate udfd02;

    @Column(name = "udfd_03")
    private LocalDate udfd03;

    @Column(name = "udfd_04")
    private LocalDate udfd04;

    @Column(name = "udfd_05")
    private LocalDate udfd05;

    @Column(name = "udfd_06")
    private LocalDate udfd06;

    @Column(name = "udfd_07")
    private LocalDate udfd07;

    @Column(name = "udfd_08")
    private LocalDate udfd08;

    @Column(name = "udfd_09")
    private LocalDate udfd09;

    @Column(name = "udfd_10")
    private LocalDate udfd10;

    @Column(name = "insert_action_instance_id")
    private Integer insertActionInstanceId;

    @Column(name = "dml_seq_no")
    private Integer dmlSeqNo;

    @Column(name = "business_date_created")
    private LocalDate businessDateCreated;

    @Column(name = "turndown_yn")
    private String turndownYn;

    @Column(name = "room_instructions")
    private String roomInstructions;

    @Column(name = "room_service_time")
    private String roomServiceTime;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "revenue_type_code")
    private String revenueTypeCode;

    @Column(name = "hurdle")
    private Integer hurdle;

    @Column(name = "hurdle_override")
    private String hurdleOverride;

    @Column(name = "rateable_value")
    private Integer rateableValue;

    @Column(name = "restriction_override")
    private String restrictionOverride;

    @Column(name = "yieldable_yn")
    private String yieldableYn;

    @Column(name = "sguest_firstname")
    private String sguestFirstname;

    @Column(name = "guest_last_name")
    private String guestLastName;

    @Column(name = "guest_first_name")
    private String guestFirstName;

    @Column(name = "guest_last_name_sdx")
    private String guestLastNameSdx;

    @Column(name = "guest_first_name_sdx")
    private String guestFirstNameSdx;

    @Column(name = "channel")
    private String channel;

    @Column(name = "share_seq_no")
    private Integer shareSeqNo;

    @Column(name = "guest_signature")
    private String guestSignature;

    @Column(name = "extension_id")
    private Integer extensionId;

    @Column(name = "resv_contact_id")
    private Integer resvContactId;

    @Column(name = "billing_contact_id")
    private Integer billingContactId;

    @Column(name = "res_insert_source")
    private String resInsertSource;

    @Column(name = "res_insert_source_type")
    private String resInsertSourceType;

    @Column(name = "master_share")
    private String masterShare;

    @Column(name = "registration_card_no")
    private String registrationCardNo;

    @Column(name = "tiad")
    private String tiad;

    @Column(name = "purpose_of_stay")
    private String purposeOfStay;

    @Column(name = "reinstate_date")
    private LocalDate reinstateDate;

    @Column(name = "purge_date")
    private LocalDate purgeDate;

    @Column(name = "last_settle_date")
    private LocalDate lastSettleDate;

    @Column(name = "last_periodic_folio_date")
    private LocalDate lastPeriodicFolioDate;

    @Column(name = "periodic_folio_freq")
    private Integer periodicFolioFreq;

    @Column(name = "confirmation_leg_no")
    private Integer confirmationLegNo;

    @Column(name = "guest_status")
    private String guestStatus;

    @Column(name = "guest_type")
    private String guestType;

    @Column(name = "checkin_duration")
    private Integer checkinDuration;

    @Column(name = "authorizer_id")
    private Integer authorizerId;

    @Column(name = "last_online_print_seq")
    private Integer lastOnlinePrintSeq;

    @Column(name = "entry_point")
    private String entryPoint;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "pseudo_mem_type")
    private String pseudoMemType;

    @Column(name = "pseudo_mem_total_points")
    private Integer pseudoMemTotalPoints;

    @Column(name = "folio_text_1")
    private String folioText1;

    @Column(name = "folio_text_2")
    private String folioText2;

    @Column(name = "comp_type_code")
    private String compTypeCode;

    @Column(name = "uni_card_id")
    private String uniCardId;

    @Column(name = "exp_checkinres_id")
    private Integer expCheckinresId;

    @Column(name = "original_begin_date")
    private LocalDate originalBeginDate;

    @Column(name = "owner_ff_flag")
    private String ownerFfFlag;

    @Column(name = "commission_payout_to")
    private String commissionPayoutTo;

    @Column(name = "pre_charging_yn")
    private String preChargingYn;

    @Column(name = "post_charging_yn")
    private String postChargingYn;

    @Column(name = "post_co_flag")
    private String postCoFlag;

    @Column(name = "folio_close_date")
    private LocalDate folioCloseDate;

    @Column(name = "schedule_checkout_yn")
    private String scheduleCheckoutYn;

    @Column(name = "custom_reference")
    private String customReference;

    @Column(name = "guarantee_code_pre_ci")
    private String guaranteeCodePreCi;

    @Column(name = "award_membership_id")
    private Integer awardMembershipId;

    @Column(name = "esigned_reg_card_name")
    private String esignedRegCardName;

    @Column(name = "statistical_room_type")
    private Integer statisticalRoomType;

    @Column(name = "statistical_rate_tier")
    private Integer statisticalRateTier;

    @Column(name = "ym_code")
    private String ymCode;

    @Column(name = "key_valid_until")
    private LocalDate keyValidUntil;

    @Column(name = "pre_registered_yn")
    private String preRegisteredYn;

    @Column(name = "tax_registration_no")
    private Integer taxRegistrationNo;

    @Column(name = "visa_number")
    private String visaNumber;

    @Column(name = "visa_issue_date")
    private LocalDate visaIssueDate;

    @Column(name = "visa_expiration_date")
    private LocalDate visaExpirationDate;

    @Column(name = "tax_no_of_stays")
    private Integer taxNoOfStays;

    @Column(name = "asb_prorated_yn")
    private String asbProratedYn;

    @Column(name = "auto_settle_days")
    private Integer autoSettleDays;

    @Column(name = "auto_settle_yn")
    private String autoSettleYn;

    @Column(name = "split_from_resv_name_id")
    private Integer splitFromResvNameId;

    @Column(name = "next_destination")
    private String nextDestination;

    @Column(name = "date_of_arrival_in_country")
    private LocalDate dateOfArrivalInCountry;

    @Column(name = "pre_arr_reviewed_dt")
    private LocalDate preArrReviewedDt;

    @Column(name = "pre_arr_reviewed_user")
    private Integer preArrReviewedUser;

    @Column(name = "bonus_check_id")
    private Integer bonusCheckId;

    @Column(name = "mobile_audio_key_yn")
    private String mobileAudioKeyYn;

    @Column(name = "direct_bill_verify_response")
    private String directBillVerifyResponse;

    @Column(name = "addressee_name_id")
    private Integer addresseeNameId;

    @Column(name = "super_search_index_text")
    private String superSearchIndexText;

    @Column(name = "auto_checkin_yn")
    private String autoCheckinYn;

    @Column(name = "email_folio_yn")
    private String emailFolioYn;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "spg_upgrade_confirmed_roomtype")
    private String spgUpgradeConfirmedRoomtype;

    @Column(name = "spg_upgrade_reason_code")
    private String spgUpgradeReasonCode;

    @Column(name = "spg_suite_night_award_status")
    private String spgSuiteNightAwardStatus;

    @Column(name = "spg_disclose_room_type_yn")
    private String spgDiscloseRoomTypeYn;

    @Column(name = "amenity_eligible_yn")
    private String amenityEligibleYn;

    @Column(name = "amenity_level_code")
    private String amenityLevelCode;

    @Column(name = "base_rate_currency_code")
    private String baseRateCurrencyCode;

    @Column(name = "base_rate_code")
    private String baseRateCode;

    @Column(name = "local_base_rate_amount")
    private Integer localBaseRateAmount;

    @Column(name = "phone_display_name_yn")
    private String phoneDisplayNameYn;

    @Column(name = "resort_charge_number")
    private String resortChargeNumber;

    @Column(name = "mobile_chkout_allowed")
    private String mobileChkoutAllowed;

    @Column(name = "mobile_view_folio_allowed")
    private String mobileViewFolioAllowed;

    @Column(name = "hk_expected_service_time")
    private String hkExpectedServiceTime;

    @Column(name = "eligible_for_upgrade_yn")
    private String eligibleForUpgradeYn;

    @Column(name = "begin_system_date_time")
    private LocalDate beginSystemDateTime;

    @Column(name = "mobile_checkin_allowed_yn")
    private String mobileCheckinAllowedYn;

    @Column(name = "quote_id")
    private String quoteId;

    @Column(name = "manual_checkout_status")
    private String manualCheckoutStatus;

    @Column(name = "mobile_preferred_currency")
    private String mobilePreferredCurrency;

    @Column(name = "mobile_action_alert_issued")
    private LocalDate mobileActionAlertIssued;

    @Column(name = "external_efolio_yn")
    private String externalEfolioYn;

    @Column(name = "opt_in_batch_fol_yn")
    private String optInBatchFolYn;

    @Column(name = "folio_addr_element_id")
    private Integer folioAddrElementId;

    @Column(name = "opera_esigned_reg_card_yn")
    private String operaEsignedRegCardYn;

    @Column(name = "resv_guid")
    private String resvGuid;

    @Column(name = "advance_checked_in_yn")
    private String advanceCheckedInYn;

    @Column(name = "expected_time_of_return")
    private LocalDate expectedTimeOfReturn;

    @Column(name = "etr_comments")
    private String etrComments;

    @Column(name = "opted_for_comm_yn")
    private String optedForCommYn;

    @Column(name = "credit_limit_auto_pay_allow_yn")
    private String creditLimitAutoPayAllowYn;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ReservationName id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResort() {
        return this.resort;
    }

    public ReservationName resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public Integer getResvNameId() {
        return this.resvNameId;
    }

    public ReservationName resvNameId(Integer resvNameId) {
        this.setResvNameId(resvNameId);
        return this;
    }

    public void setResvNameId(Integer resvNameId) {
        this.resvNameId = resvNameId;
    }

    public Integer getNameId() {
        return this.nameId;
    }

    public ReservationName nameId(Integer nameId) {
        this.setNameId(nameId);
        return this;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public String getNameUsageType() {
        return this.nameUsageType;
    }

    public ReservationName nameUsageType(String nameUsageType) {
        this.setNameUsageType(nameUsageType);
        return this;
    }

    public void setNameUsageType(String nameUsageType) {
        this.nameUsageType = nameUsageType;
    }

    public Integer getContactNameId() {
        return this.contactNameId;
    }

    public ReservationName contactNameId(Integer contactNameId) {
        this.setContactNameId(contactNameId);
        return this;
    }

    public void setContactNameId(Integer contactNameId) {
        this.contactNameId = contactNameId;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public ReservationName insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public ReservationName insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public ReservationName updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public ReservationName updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getResvStatus() {
        return this.resvStatus;
    }

    public ReservationName resvStatus(String resvStatus) {
        this.setResvStatus(resvStatus);
        return this;
    }

    public void setResvStatus(String resvStatus) {
        this.resvStatus = resvStatus;
    }

    public String getCommissionCode() {
        return this.commissionCode;
    }

    public ReservationName commissionCode(String commissionCode) {
        this.setCommissionCode(commissionCode);
        return this;
    }

    public void setCommissionCode(String commissionCode) {
        this.commissionCode = commissionCode;
    }

    public Integer getAddressId() {
        return this.addressId;
    }

    public ReservationName addressId(Integer addressId) {
        this.setAddressId(addressId);
        return this;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getPhoneId() {
        return this.phoneId;
    }

    public ReservationName phoneId(Integer phoneId) {
        this.setPhoneId(phoneId);
        return this;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getFaxYn() {
        return this.faxYn;
    }

    public ReservationName faxYn(String faxYn) {
        this.setFaxYn(faxYn);
        return this;
    }

    public void setFaxYn(String faxYn) {
        this.faxYn = faxYn;
    }

    public String getMailYn() {
        return this.mailYn;
    }

    public ReservationName mailYn(String mailYn) {
        this.setMailYn(mailYn);
        return this;
    }

    public void setMailYn(String mailYn) {
        this.mailYn = mailYn;
    }

    public String getPrintRateYn() {
        return this.printRateYn;
    }

    public ReservationName printRateYn(String printRateYn) {
        this.setPrintRateYn(printRateYn);
        return this;
    }

    public void setPrintRateYn(String printRateYn) {
        this.printRateYn = printRateYn;
    }

    public String getReportId() {
        return this.reportId;
    }

    public ReservationName reportId(String reportId) {
        this.setReportId(reportId);
        return this;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Integer getResvNo() {
        return this.resvNo;
    }

    public ReservationName resvNo(Integer resvNo) {
        this.setResvNo(resvNo);
        return this;
    }

    public void setResvNo(Integer resvNo) {
        this.resvNo = resvNo;
    }

    public String getConfirmationNo() {
        return this.confirmationNo;
    }

    public ReservationName confirmationNo(String confirmationNo) {
        this.setConfirmationNo(confirmationNo);
        return this;
    }

    public void setConfirmationNo(String confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    public LocalDate getBeginDate() {
        return this.beginDate;
    }

    public ReservationName beginDate(LocalDate beginDate) {
        this.setBeginDate(beginDate);
        return this;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public ReservationName endDate(LocalDate endDate) {
        this.setEndDate(endDate);
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getFaxId() {
        return this.faxId;
    }

    public ReservationName faxId(Integer faxId) {
        this.setFaxId(faxId);
        return this;
    }

    public void setFaxId(Integer faxId) {
        this.faxId = faxId;
    }

    public Integer getEmailId() {
        return this.emailId;
    }

    public ReservationName emailId(Integer emailId) {
        this.setEmailId(emailId);
        return this;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getEmailYn() {
        return this.emailYn;
    }

    public ReservationName emailYn(String emailYn) {
        this.setEmailYn(emailYn);
        return this;
    }

    public void setEmailYn(String emailYn) {
        this.emailYn = emailYn;
    }

    public String getConsumerYn() {
        return this.consumerYn;
    }

    public ReservationName consumerYn(String consumerYn) {
        this.setConsumerYn(consumerYn);
        return this;
    }

    public void setConsumerYn(String consumerYn) {
        this.consumerYn = consumerYn;
    }

    public Integer getCreditCardId() {
        return this.creditCardId;
    }

    public ReservationName creditCardId(Integer creditCardId) {
        this.setCreditCardId(creditCardId);
        return this;
    }

    public void setCreditCardId(Integer creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getFinanciallyResponsibleYn() {
        return this.financiallyResponsibleYn;
    }

    public ReservationName financiallyResponsibleYn(String financiallyResponsibleYn) {
        this.setFinanciallyResponsibleYn(financiallyResponsibleYn);
        return this;
    }

    public void setFinanciallyResponsibleYn(String financiallyResponsibleYn) {
        this.financiallyResponsibleYn = financiallyResponsibleYn;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public ReservationName paymentMethod(String paymentMethod) {
        this.setPaymentMethod(paymentMethod);
        return this;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getIntermediaryYn() {
        return this.intermediaryYn;
    }

    public ReservationName intermediaryYn(String intermediaryYn) {
        this.setIntermediaryYn(intermediaryYn);
        return this;
    }

    public void setIntermediaryYn(String intermediaryYn) {
        this.intermediaryYn = intermediaryYn;
    }

    public String getPostingAllowedYn() {
        return this.postingAllowedYn;
    }

    public ReservationName postingAllowedYn(String postingAllowedYn) {
        this.setPostingAllowedYn(postingAllowedYn);
        return this;
    }

    public void setPostingAllowedYn(String postingAllowedYn) {
        this.postingAllowedYn = postingAllowedYn;
    }

    public String getDisplayColor() {
        return this.displayColor;
    }

    public ReservationName displayColor(String displayColor) {
        this.setDisplayColor(displayColor);
        return this;
    }

    public void setDisplayColor(String displayColor) {
        this.displayColor = displayColor;
    }

    public LocalDate getActualCheckInDate() {
        return this.actualCheckInDate;
    }

    public ReservationName actualCheckInDate(LocalDate actualCheckInDate) {
        this.setActualCheckInDate(actualCheckInDate);
        return this;
    }

    public void setActualCheckInDate(LocalDate actualCheckInDate) {
        this.actualCheckInDate = actualCheckInDate;
    }

    public LocalDate getTruncActualCheckInDate() {
        return this.truncActualCheckInDate;
    }

    public ReservationName truncActualCheckInDate(LocalDate truncActualCheckInDate) {
        this.setTruncActualCheckInDate(truncActualCheckInDate);
        return this;
    }

    public void setTruncActualCheckInDate(LocalDate truncActualCheckInDate) {
        this.truncActualCheckInDate = truncActualCheckInDate;
    }

    public LocalDate getActualCheckOutDate() {
        return this.actualCheckOutDate;
    }

    public ReservationName actualCheckOutDate(LocalDate actualCheckOutDate) {
        this.setActualCheckOutDate(actualCheckOutDate);
        return this;
    }

    public void setActualCheckOutDate(LocalDate actualCheckOutDate) {
        this.actualCheckOutDate = actualCheckOutDate;
    }

    public LocalDate getTruncActualCheckOutDate() {
        return this.truncActualCheckOutDate;
    }

    public ReservationName truncActualCheckOutDate(LocalDate truncActualCheckOutDate) {
        this.setTruncActualCheckOutDate(truncActualCheckOutDate);
        return this;
    }

    public void setTruncActualCheckOutDate(LocalDate truncActualCheckOutDate) {
        this.truncActualCheckOutDate = truncActualCheckOutDate;
    }

    public Integer getCreditLimit() {
        return this.creditLimit;
    }

    public ReservationName creditLimit(Integer creditLimit) {
        this.setCreditLimit(creditLimit);
        return this;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getAuthorizedBy() {
        return this.authorizedBy;
    }

    public ReservationName authorizedBy(Integer authorizedBy) {
        this.setAuthorizedBy(authorizedBy);
        return this;
    }

    public void setAuthorizedBy(Integer authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    public Integer getParentResvNameId() {
        return this.parentResvNameId;
    }

    public ReservationName parentResvNameId(Integer parentResvNameId) {
        this.setParentResvNameId(parentResvNameId);
        return this;
    }

    public void setParentResvNameId(Integer parentResvNameId) {
        this.parentResvNameId = parentResvNameId;
    }

    public String getCancellationNo() {
        return this.cancellationNo;
    }

    public ReservationName cancellationNo(String cancellationNo) {
        this.setCancellationNo(cancellationNo);
        return this;
    }

    public void setCancellationNo(String cancellationNo) {
        this.cancellationNo = cancellationNo;
    }

    public String getCancellationReasonCode() {
        return this.cancellationReasonCode;
    }

    public ReservationName cancellationReasonCode(String cancellationReasonCode) {
        this.setCancellationReasonCode(cancellationReasonCode);
        return this;
    }

    public void setCancellationReasonCode(String cancellationReasonCode) {
        this.cancellationReasonCode = cancellationReasonCode;
    }

    public String getCancellationReasonDesc() {
        return this.cancellationReasonDesc;
    }

    public ReservationName cancellationReasonDesc(String cancellationReasonDesc) {
        this.setCancellationReasonDesc(cancellationReasonDesc);
        return this;
    }

    public void setCancellationReasonDesc(String cancellationReasonDesc) {
        this.cancellationReasonDesc = cancellationReasonDesc;
    }

    public String getArrivalTransportType() {
        return this.arrivalTransportType;
    }

    public ReservationName arrivalTransportType(String arrivalTransportType) {
        this.setArrivalTransportType(arrivalTransportType);
        return this;
    }

    public void setArrivalTransportType(String arrivalTransportType) {
        this.arrivalTransportType = arrivalTransportType;
    }

    public String getArrivalStationCode() {
        return this.arrivalStationCode;
    }

    public ReservationName arrivalStationCode(String arrivalStationCode) {
        this.setArrivalStationCode(arrivalStationCode);
        return this;
    }

    public void setArrivalStationCode(String arrivalStationCode) {
        this.arrivalStationCode = arrivalStationCode;
    }

    public String getArrivalCarrierCode() {
        return this.arrivalCarrierCode;
    }

    public ReservationName arrivalCarrierCode(String arrivalCarrierCode) {
        this.setArrivalCarrierCode(arrivalCarrierCode);
        return this;
    }

    public void setArrivalCarrierCode(String arrivalCarrierCode) {
        this.arrivalCarrierCode = arrivalCarrierCode;
    }

    public String getArrivalTransportCode() {
        return this.arrivalTransportCode;
    }

    public ReservationName arrivalTransportCode(String arrivalTransportCode) {
        this.setArrivalTransportCode(arrivalTransportCode);
        return this;
    }

    public void setArrivalTransportCode(String arrivalTransportCode) {
        this.arrivalTransportCode = arrivalTransportCode;
    }

    public LocalDate getArrivalDateTime() {
        return this.arrivalDateTime;
    }

    public ReservationName arrivalDateTime(LocalDate arrivalDateTime) {
        this.setArrivalDateTime(arrivalDateTime);
        return this;
    }

    public void setArrivalDateTime(LocalDate arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public LocalDate getArrivalEstimateTime() {
        return this.arrivalEstimateTime;
    }

    public ReservationName arrivalEstimateTime(LocalDate arrivalEstimateTime) {
        this.setArrivalEstimateTime(arrivalEstimateTime);
        return this;
    }

    public void setArrivalEstimateTime(LocalDate arrivalEstimateTime) {
        this.arrivalEstimateTime = arrivalEstimateTime;
    }

    public String getArrivalTranportationYn() {
        return this.arrivalTranportationYn;
    }

    public ReservationName arrivalTranportationYn(String arrivalTranportationYn) {
        this.setArrivalTranportationYn(arrivalTranportationYn);
        return this;
    }

    public void setArrivalTranportationYn(String arrivalTranportationYn) {
        this.arrivalTranportationYn = arrivalTranportationYn;
    }

    public String getArrivalComments() {
        return this.arrivalComments;
    }

    public ReservationName arrivalComments(String arrivalComments) {
        this.setArrivalComments(arrivalComments);
        return this;
    }

    public void setArrivalComments(String arrivalComments) {
        this.arrivalComments = arrivalComments;
    }

    public String getDepartureTransportType() {
        return this.departureTransportType;
    }

    public ReservationName departureTransportType(String departureTransportType) {
        this.setDepartureTransportType(departureTransportType);
        return this;
    }

    public void setDepartureTransportType(String departureTransportType) {
        this.departureTransportType = departureTransportType;
    }

    public String getDepartureStationCode() {
        return this.departureStationCode;
    }

    public ReservationName departureStationCode(String departureStationCode) {
        this.setDepartureStationCode(departureStationCode);
        return this;
    }

    public void setDepartureStationCode(String departureStationCode) {
        this.departureStationCode = departureStationCode;
    }

    public String getDepartureCarrierCode() {
        return this.departureCarrierCode;
    }

    public ReservationName departureCarrierCode(String departureCarrierCode) {
        this.setDepartureCarrierCode(departureCarrierCode);
        return this;
    }

    public void setDepartureCarrierCode(String departureCarrierCode) {
        this.departureCarrierCode = departureCarrierCode;
    }

    public String getDepartureTransportCode() {
        return this.departureTransportCode;
    }

    public ReservationName departureTransportCode(String departureTransportCode) {
        this.setDepartureTransportCode(departureTransportCode);
        return this;
    }

    public void setDepartureTransportCode(String departureTransportCode) {
        this.departureTransportCode = departureTransportCode;
    }

    public LocalDate getDepartureDateTime() {
        return this.departureDateTime;
    }

    public ReservationName departureDateTime(LocalDate departureDateTime) {
        this.setDepartureDateTime(departureDateTime);
        return this;
    }

    public void setDepartureDateTime(LocalDate departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDate getDepartureEstimateTime() {
        return this.departureEstimateTime;
    }

    public ReservationName departureEstimateTime(LocalDate departureEstimateTime) {
        this.setDepartureEstimateTime(departureEstimateTime);
        return this;
    }

    public void setDepartureEstimateTime(LocalDate departureEstimateTime) {
        this.departureEstimateTime = departureEstimateTime;
    }

    public String getDepartureTransportationYn() {
        return this.departureTransportationYn;
    }

    public ReservationName departureTransportationYn(String departureTransportationYn) {
        this.setDepartureTransportationYn(departureTransportationYn);
        return this;
    }

    public void setDepartureTransportationYn(String departureTransportationYn) {
        this.departureTransportationYn = departureTransportationYn;
    }

    public String getDepartureComments() {
        return this.departureComments;
    }

    public ReservationName departureComments(String departureComments) {
        this.setDepartureComments(departureComments);
        return this;
    }

    public void setDepartureComments(String departureComments) {
        this.departureComments = departureComments;
    }

    public LocalDate getCancellationDate() {
        return this.cancellationDate;
    }

    public ReservationName cancellationDate(LocalDate cancellationDate) {
        this.setCancellationDate(cancellationDate);
        return this;
    }

    public void setCancellationDate(LocalDate cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public String getGuaranteeCode() {
        return this.guaranteeCode;
    }

    public ReservationName guaranteeCode(String guaranteeCode) {
        this.setGuaranteeCode(guaranteeCode);
        return this;
    }

    public void setGuaranteeCode(String guaranteeCode) {
        this.guaranteeCode = guaranteeCode;
    }

    public String getWlReasonDescription() {
        return this.wlReasonDescription;
    }

    public ReservationName wlReasonDescription(String wlReasonDescription) {
        this.setWlReasonDescription(wlReasonDescription);
        return this;
    }

    public void setWlReasonDescription(String wlReasonDescription) {
        this.wlReasonDescription = wlReasonDescription;
    }

    public String getWlReasonCode() {
        return this.wlReasonCode;
    }

    public ReservationName wlReasonCode(String wlReasonCode) {
        this.setWlReasonCode(wlReasonCode);
        return this;
    }

    public void setWlReasonCode(String wlReasonCode) {
        this.wlReasonCode = wlReasonCode;
    }

    public String getWlPriority() {
        return this.wlPriority;
    }

    public ReservationName wlPriority(String wlPriority) {
        this.setWlPriority(wlPriority);
        return this;
    }

    public void setWlPriority(String wlPriority) {
        this.wlPriority = wlPriority;
    }

    public String getDoNotMoveRoom() {
        return this.doNotMoveRoom;
    }

    public ReservationName doNotMoveRoom(String doNotMoveRoom) {
        this.setDoNotMoveRoom(doNotMoveRoom);
        return this;
    }

    public void setDoNotMoveRoom(String doNotMoveRoom) {
        this.doNotMoveRoom = doNotMoveRoom;
    }

    public String getExternalReference() {
        return this.externalReference;
    }

    public ReservationName externalReference(String externalReference) {
        this.setExternalReference(externalReference);
        return this;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getPartyCode() {
        return this.partyCode;
    }

    public ReservationName partyCode(String partyCode) {
        this.setPartyCode(partyCode);
        return this;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public String getWalkinYn() {
        return this.walkinYn;
    }

    public ReservationName walkinYn(String walkinYn) {
        this.setWalkinYn(walkinYn);
        return this;
    }

    public void setWalkinYn(String walkinYn) {
        this.walkinYn = walkinYn;
    }

    public LocalDate getOriginalEndDate() {
        return this.originalEndDate;
    }

    public ReservationName originalEndDate(LocalDate originalEndDate) {
        this.setOriginalEndDate(originalEndDate);
        return this;
    }

    public void setOriginalEndDate(LocalDate originalEndDate) {
        this.originalEndDate = originalEndDate;
    }

    public Integer getApprovalAmountCalcMethod() {
        return this.approvalAmountCalcMethod;
    }

    public ReservationName approvalAmountCalcMethod(Integer approvalAmountCalcMethod) {
        this.setApprovalAmountCalcMethod(approvalAmountCalcMethod);
        return this;
    }

    public void setApprovalAmountCalcMethod(Integer approvalAmountCalcMethod) {
        this.approvalAmountCalcMethod = approvalAmountCalcMethod;
    }

    public Integer getAmountPercent() {
        return this.amountPercent;
    }

    public ReservationName amountPercent(Integer amountPercent) {
        this.setAmountPercent(amountPercent);
        return this;
    }

    public void setAmountPercent(Integer amountPercent) {
        this.amountPercent = amountPercent;
    }

    public String getNameTaxType() {
        return this.nameTaxType;
    }

    public ReservationName nameTaxType(String nameTaxType) {
        this.setNameTaxType(nameTaxType);
        return this;
    }

    public void setNameTaxType(String nameTaxType) {
        this.nameTaxType = nameTaxType;
    }

    public String getTaxExemptNo() {
        return this.taxExemptNo;
    }

    public ReservationName taxExemptNo(String taxExemptNo) {
        this.setTaxExemptNo(taxExemptNo);
        return this;
    }

    public void setTaxExemptNo(String taxExemptNo) {
        this.taxExemptNo = taxExemptNo;
    }

    public String getRoomFeatures() {
        return this.roomFeatures;
    }

    public ReservationName roomFeatures(String roomFeatures) {
        this.setRoomFeatures(roomFeatures);
        return this;
    }

    public void setRoomFeatures(String roomFeatures) {
        this.roomFeatures = roomFeatures;
    }

    public String getWlTelephoneNo() {
        return this.wlTelephoneNo;
    }

    public ReservationName wlTelephoneNo(String wlTelephoneNo) {
        this.setWlTelephoneNo(wlTelephoneNo);
        return this;
    }

    public void setWlTelephoneNo(String wlTelephoneNo) {
        this.wlTelephoneNo = wlTelephoneNo;
    }

    public String getVideoCheckoutYn() {
        return this.videoCheckoutYn;
    }

    public ReservationName videoCheckoutYn(String videoCheckoutYn) {
        this.setVideoCheckoutYn(videoCheckoutYn);
        return this;
    }

    public void setVideoCheckoutYn(String videoCheckoutYn) {
        this.videoCheckoutYn = videoCheckoutYn;
    }

    public Integer getDiscountAmt() {
        return this.discountAmt;
    }

    public ReservationName discountAmt(Integer discountAmt) {
        this.setDiscountAmt(discountAmt);
        return this;
    }

    public void setDiscountAmt(Integer discountAmt) {
        this.discountAmt = discountAmt;
    }

    public Integer getDiscountPrcnt() {
        return this.discountPrcnt;
    }

    public ReservationName discountPrcnt(Integer discountPrcnt) {
        this.setDiscountPrcnt(discountPrcnt);
        return this;
    }

    public void setDiscountPrcnt(Integer discountPrcnt) {
        this.discountPrcnt = discountPrcnt;
    }

    public String getDiscountReasonCode() {
        return this.discountReasonCode;
    }

    public ReservationName discountReasonCode(String discountReasonCode) {
        this.setDiscountReasonCode(discountReasonCode);
        return this;
    }

    public void setDiscountReasonCode(String discountReasonCode) {
        this.discountReasonCode = discountReasonCode;
    }

    public Integer getCommissionPaid() {
        return this.commissionPaid;
    }

    public ReservationName commissionPaid(Integer commissionPaid) {
        this.setCommissionPaid(commissionPaid);
        return this;
    }

    public void setCommissionPaid(Integer commissionPaid) {
        this.commissionPaid = commissionPaid;
    }

    public String getCommissionHoldCode() {
        return this.commissionHoldCode;
    }

    public ReservationName commissionHoldCode(String commissionHoldCode) {
        this.setCommissionHoldCode(commissionHoldCode);
        return this;
    }

    public void setCommissionHoldCode(String commissionHoldCode) {
        this.commissionHoldCode = commissionHoldCode;
    }

    public LocalDate getTruncBeginDate() {
        return this.truncBeginDate;
    }

    public ReservationName truncBeginDate(LocalDate truncBeginDate) {
        this.setTruncBeginDate(truncBeginDate);
        return this;
    }

    public void setTruncBeginDate(LocalDate truncBeginDate) {
        this.truncBeginDate = truncBeginDate;
    }

    public LocalDate getTruncEndDate() {
        return this.truncEndDate;
    }

    public ReservationName truncEndDate(LocalDate truncEndDate) {
        this.setTruncEndDate(truncEndDate);
        return this;
    }

    public void setTruncEndDate(LocalDate truncEndDate) {
        this.truncEndDate = truncEndDate;
    }

    public String getSguestName() {
        return this.sguestName;
    }

    public ReservationName sguestName(String sguestName) {
        this.setSguestName(sguestName);
        return this;
    }

    public void setSguestName(String sguestName) {
        this.sguestName = sguestName;
    }

    public Integer getMembershipId() {
        return this.membershipId;
    }

    public ReservationName membershipId(Integer membershipId) {
        this.setMembershipId(membershipId);
        return this;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    public String getUdfc01() {
        return this.udfc01;
    }

    public ReservationName udfc01(String udfc01) {
        this.setUdfc01(udfc01);
        return this;
    }

    public void setUdfc01(String udfc01) {
        this.udfc01 = udfc01;
    }

    public String getUdfc02() {
        return this.udfc02;
    }

    public ReservationName udfc02(String udfc02) {
        this.setUdfc02(udfc02);
        return this;
    }

    public void setUdfc02(String udfc02) {
        this.udfc02 = udfc02;
    }

    public String getUdfc03() {
        return this.udfc03;
    }

    public ReservationName udfc03(String udfc03) {
        this.setUdfc03(udfc03);
        return this;
    }

    public void setUdfc03(String udfc03) {
        this.udfc03 = udfc03;
    }

    public String getUdfc04() {
        return this.udfc04;
    }

    public ReservationName udfc04(String udfc04) {
        this.setUdfc04(udfc04);
        return this;
    }

    public void setUdfc04(String udfc04) {
        this.udfc04 = udfc04;
    }

    public String getUdfc05() {
        return this.udfc05;
    }

    public ReservationName udfc05(String udfc05) {
        this.setUdfc05(udfc05);
        return this;
    }

    public void setUdfc05(String udfc05) {
        this.udfc05 = udfc05;
    }

    public String getUdfc06() {
        return this.udfc06;
    }

    public ReservationName udfc06(String udfc06) {
        this.setUdfc06(udfc06);
        return this;
    }

    public void setUdfc06(String udfc06) {
        this.udfc06 = udfc06;
    }

    public String getUdfc07() {
        return this.udfc07;
    }

    public ReservationName udfc07(String udfc07) {
        this.setUdfc07(udfc07);
        return this;
    }

    public void setUdfc07(String udfc07) {
        this.udfc07 = udfc07;
    }

    public String getUdfc08() {
        return this.udfc08;
    }

    public ReservationName udfc08(String udfc08) {
        this.setUdfc08(udfc08);
        return this;
    }

    public void setUdfc08(String udfc08) {
        this.udfc08 = udfc08;
    }

    public String getUdfc09() {
        return this.udfc09;
    }

    public ReservationName udfc09(String udfc09) {
        this.setUdfc09(udfc09);
        return this;
    }

    public void setUdfc09(String udfc09) {
        this.udfc09 = udfc09;
    }

    public String getUdfc10() {
        return this.udfc10;
    }

    public ReservationName udfc10(String udfc10) {
        this.setUdfc10(udfc10);
        return this;
    }

    public void setUdfc10(String udfc10) {
        this.udfc10 = udfc10;
    }

    public String getUdfc11() {
        return this.udfc11;
    }

    public ReservationName udfc11(String udfc11) {
        this.setUdfc11(udfc11);
        return this;
    }

    public void setUdfc11(String udfc11) {
        this.udfc11 = udfc11;
    }

    public String getUdfc12() {
        return this.udfc12;
    }

    public ReservationName udfc12(String udfc12) {
        this.setUdfc12(udfc12);
        return this;
    }

    public void setUdfc12(String udfc12) {
        this.udfc12 = udfc12;
    }

    public String getUdfc13() {
        return this.udfc13;
    }

    public ReservationName udfc13(String udfc13) {
        this.setUdfc13(udfc13);
        return this;
    }

    public void setUdfc13(String udfc13) {
        this.udfc13 = udfc13;
    }

    public String getUdfc14() {
        return this.udfc14;
    }

    public ReservationName udfc14(String udfc14) {
        this.setUdfc14(udfc14);
        return this;
    }

    public void setUdfc14(String udfc14) {
        this.udfc14 = udfc14;
    }

    public String getUdfc15() {
        return this.udfc15;
    }

    public ReservationName udfc15(String udfc15) {
        this.setUdfc15(udfc15);
        return this;
    }

    public void setUdfc15(String udfc15) {
        this.udfc15 = udfc15;
    }

    public String getUdfc16() {
        return this.udfc16;
    }

    public ReservationName udfc16(String udfc16) {
        this.setUdfc16(udfc16);
        return this;
    }

    public void setUdfc16(String udfc16) {
        this.udfc16 = udfc16;
    }

    public String getUdfc17() {
        return this.udfc17;
    }

    public ReservationName udfc17(String udfc17) {
        this.setUdfc17(udfc17);
        return this;
    }

    public void setUdfc17(String udfc17) {
        this.udfc17 = udfc17;
    }

    public String getUdfc18() {
        return this.udfc18;
    }

    public ReservationName udfc18(String udfc18) {
        this.setUdfc18(udfc18);
        return this;
    }

    public void setUdfc18(String udfc18) {
        this.udfc18 = udfc18;
    }

    public String getUdfc19() {
        return this.udfc19;
    }

    public ReservationName udfc19(String udfc19) {
        this.setUdfc19(udfc19);
        return this;
    }

    public void setUdfc19(String udfc19) {
        this.udfc19 = udfc19;
    }

    public String getUdfc20() {
        return this.udfc20;
    }

    public ReservationName udfc20(String udfc20) {
        this.setUdfc20(udfc20);
        return this;
    }

    public void setUdfc20(String udfc20) {
        this.udfc20 = udfc20;
    }

    public String getUdfc21() {
        return this.udfc21;
    }

    public ReservationName udfc21(String udfc21) {
        this.setUdfc21(udfc21);
        return this;
    }

    public void setUdfc21(String udfc21) {
        this.udfc21 = udfc21;
    }

    public String getUdfc22() {
        return this.udfc22;
    }

    public ReservationName udfc22(String udfc22) {
        this.setUdfc22(udfc22);
        return this;
    }

    public void setUdfc22(String udfc22) {
        this.udfc22 = udfc22;
    }

    public String getUdfc23() {
        return this.udfc23;
    }

    public ReservationName udfc23(String udfc23) {
        this.setUdfc23(udfc23);
        return this;
    }

    public void setUdfc23(String udfc23) {
        this.udfc23 = udfc23;
    }

    public String getUdfc24() {
        return this.udfc24;
    }

    public ReservationName udfc24(String udfc24) {
        this.setUdfc24(udfc24);
        return this;
    }

    public void setUdfc24(String udfc24) {
        this.udfc24 = udfc24;
    }

    public String getUdfc25() {
        return this.udfc25;
    }

    public ReservationName udfc25(String udfc25) {
        this.setUdfc25(udfc25);
        return this;
    }

    public void setUdfc25(String udfc25) {
        this.udfc25 = udfc25;
    }

    public String getUdfc26() {
        return this.udfc26;
    }

    public ReservationName udfc26(String udfc26) {
        this.setUdfc26(udfc26);
        return this;
    }

    public void setUdfc26(String udfc26) {
        this.udfc26 = udfc26;
    }

    public String getUdfc27() {
        return this.udfc27;
    }

    public ReservationName udfc27(String udfc27) {
        this.setUdfc27(udfc27);
        return this;
    }

    public void setUdfc27(String udfc27) {
        this.udfc27 = udfc27;
    }

    public String getUdfc28() {
        return this.udfc28;
    }

    public ReservationName udfc28(String udfc28) {
        this.setUdfc28(udfc28);
        return this;
    }

    public void setUdfc28(String udfc28) {
        this.udfc28 = udfc28;
    }

    public String getUdfc29() {
        return this.udfc29;
    }

    public ReservationName udfc29(String udfc29) {
        this.setUdfc29(udfc29);
        return this;
    }

    public void setUdfc29(String udfc29) {
        this.udfc29 = udfc29;
    }

    public String getUdfc30() {
        return this.udfc30;
    }

    public ReservationName udfc30(String udfc30) {
        this.setUdfc30(udfc30);
        return this;
    }

    public void setUdfc30(String udfc30) {
        this.udfc30 = udfc30;
    }

    public String getUdfc31() {
        return this.udfc31;
    }

    public ReservationName udfc31(String udfc31) {
        this.setUdfc31(udfc31);
        return this;
    }

    public void setUdfc31(String udfc31) {
        this.udfc31 = udfc31;
    }

    public String getUdfc32() {
        return this.udfc32;
    }

    public ReservationName udfc32(String udfc32) {
        this.setUdfc32(udfc32);
        return this;
    }

    public void setUdfc32(String udfc32) {
        this.udfc32 = udfc32;
    }

    public String getUdfc33() {
        return this.udfc33;
    }

    public ReservationName udfc33(String udfc33) {
        this.setUdfc33(udfc33);
        return this;
    }

    public void setUdfc33(String udfc33) {
        this.udfc33 = udfc33;
    }

    public String getUdfc34() {
        return this.udfc34;
    }

    public ReservationName udfc34(String udfc34) {
        this.setUdfc34(udfc34);
        return this;
    }

    public void setUdfc34(String udfc34) {
        this.udfc34 = udfc34;
    }

    public String getUdfc35() {
        return this.udfc35;
    }

    public ReservationName udfc35(String udfc35) {
        this.setUdfc35(udfc35);
        return this;
    }

    public void setUdfc35(String udfc35) {
        this.udfc35 = udfc35;
    }

    public String getUdfc36() {
        return this.udfc36;
    }

    public ReservationName udfc36(String udfc36) {
        this.setUdfc36(udfc36);
        return this;
    }

    public void setUdfc36(String udfc36) {
        this.udfc36 = udfc36;
    }

    public String getUdfc37() {
        return this.udfc37;
    }

    public ReservationName udfc37(String udfc37) {
        this.setUdfc37(udfc37);
        return this;
    }

    public void setUdfc37(String udfc37) {
        this.udfc37 = udfc37;
    }

    public String getUdfc38() {
        return this.udfc38;
    }

    public ReservationName udfc38(String udfc38) {
        this.setUdfc38(udfc38);
        return this;
    }

    public void setUdfc38(String udfc38) {
        this.udfc38 = udfc38;
    }

    public String getUdfc39() {
        return this.udfc39;
    }

    public ReservationName udfc39(String udfc39) {
        this.setUdfc39(udfc39);
        return this;
    }

    public void setUdfc39(String udfc39) {
        this.udfc39 = udfc39;
    }

    public String getUdfc40() {
        return this.udfc40;
    }

    public ReservationName udfc40(String udfc40) {
        this.setUdfc40(udfc40);
        return this;
    }

    public void setUdfc40(String udfc40) {
        this.udfc40 = udfc40;
    }

    public Integer getUdfn01() {
        return this.udfn01;
    }

    public ReservationName udfn01(Integer udfn01) {
        this.setUdfn01(udfn01);
        return this;
    }

    public void setUdfn01(Integer udfn01) {
        this.udfn01 = udfn01;
    }

    public Integer getUdfn02() {
        return this.udfn02;
    }

    public ReservationName udfn02(Integer udfn02) {
        this.setUdfn02(udfn02);
        return this;
    }

    public void setUdfn02(Integer udfn02) {
        this.udfn02 = udfn02;
    }

    public Integer getUdfn03() {
        return this.udfn03;
    }

    public ReservationName udfn03(Integer udfn03) {
        this.setUdfn03(udfn03);
        return this;
    }

    public void setUdfn03(Integer udfn03) {
        this.udfn03 = udfn03;
    }

    public Integer getUdfn04() {
        return this.udfn04;
    }

    public ReservationName udfn04(Integer udfn04) {
        this.setUdfn04(udfn04);
        return this;
    }

    public void setUdfn04(Integer udfn04) {
        this.udfn04 = udfn04;
    }

    public Integer getUdfn05() {
        return this.udfn05;
    }

    public ReservationName udfn05(Integer udfn05) {
        this.setUdfn05(udfn05);
        return this;
    }

    public void setUdfn05(Integer udfn05) {
        this.udfn05 = udfn05;
    }

    public Integer getUdfn06() {
        return this.udfn06;
    }

    public ReservationName udfn06(Integer udfn06) {
        this.setUdfn06(udfn06);
        return this;
    }

    public void setUdfn06(Integer udfn06) {
        this.udfn06 = udfn06;
    }

    public Integer getUdfn07() {
        return this.udfn07;
    }

    public ReservationName udfn07(Integer udfn07) {
        this.setUdfn07(udfn07);
        return this;
    }

    public void setUdfn07(Integer udfn07) {
        this.udfn07 = udfn07;
    }

    public Integer getUdfn08() {
        return this.udfn08;
    }

    public ReservationName udfn08(Integer udfn08) {
        this.setUdfn08(udfn08);
        return this;
    }

    public void setUdfn08(Integer udfn08) {
        this.udfn08 = udfn08;
    }

    public Integer getUdfn09() {
        return this.udfn09;
    }

    public ReservationName udfn09(Integer udfn09) {
        this.setUdfn09(udfn09);
        return this;
    }

    public void setUdfn09(Integer udfn09) {
        this.udfn09 = udfn09;
    }

    public Integer getUdfn10() {
        return this.udfn10;
    }

    public ReservationName udfn10(Integer udfn10) {
        this.setUdfn10(udfn10);
        return this;
    }

    public void setUdfn10(Integer udfn10) {
        this.udfn10 = udfn10;
    }

    public Integer getUdfn11() {
        return this.udfn11;
    }

    public ReservationName udfn11(Integer udfn11) {
        this.setUdfn11(udfn11);
        return this;
    }

    public void setUdfn11(Integer udfn11) {
        this.udfn11 = udfn11;
    }

    public Integer getUdfn12() {
        return this.udfn12;
    }

    public ReservationName udfn12(Integer udfn12) {
        this.setUdfn12(udfn12);
        return this;
    }

    public void setUdfn12(Integer udfn12) {
        this.udfn12 = udfn12;
    }

    public Integer getUdfn13() {
        return this.udfn13;
    }

    public ReservationName udfn13(Integer udfn13) {
        this.setUdfn13(udfn13);
        return this;
    }

    public void setUdfn13(Integer udfn13) {
        this.udfn13 = udfn13;
    }

    public Integer getUdfn14() {
        return this.udfn14;
    }

    public ReservationName udfn14(Integer udfn14) {
        this.setUdfn14(udfn14);
        return this;
    }

    public void setUdfn14(Integer udfn14) {
        this.udfn14 = udfn14;
    }

    public Integer getUdfn15() {
        return this.udfn15;
    }

    public ReservationName udfn15(Integer udfn15) {
        this.setUdfn15(udfn15);
        return this;
    }

    public void setUdfn15(Integer udfn15) {
        this.udfn15 = udfn15;
    }

    public Integer getUdfn16() {
        return this.udfn16;
    }

    public ReservationName udfn16(Integer udfn16) {
        this.setUdfn16(udfn16);
        return this;
    }

    public void setUdfn16(Integer udfn16) {
        this.udfn16 = udfn16;
    }

    public Integer getUdfn17() {
        return this.udfn17;
    }

    public ReservationName udfn17(Integer udfn17) {
        this.setUdfn17(udfn17);
        return this;
    }

    public void setUdfn17(Integer udfn17) {
        this.udfn17 = udfn17;
    }

    public Integer getUdfn18() {
        return this.udfn18;
    }

    public ReservationName udfn18(Integer udfn18) {
        this.setUdfn18(udfn18);
        return this;
    }

    public void setUdfn18(Integer udfn18) {
        this.udfn18 = udfn18;
    }

    public Integer getUdfn19() {
        return this.udfn19;
    }

    public ReservationName udfn19(Integer udfn19) {
        this.setUdfn19(udfn19);
        return this;
    }

    public void setUdfn19(Integer udfn19) {
        this.udfn19 = udfn19;
    }

    public Integer getUdfn20() {
        return this.udfn20;
    }

    public ReservationName udfn20(Integer udfn20) {
        this.setUdfn20(udfn20);
        return this;
    }

    public void setUdfn20(Integer udfn20) {
        this.udfn20 = udfn20;
    }

    public Integer getUdfn21() {
        return this.udfn21;
    }

    public ReservationName udfn21(Integer udfn21) {
        this.setUdfn21(udfn21);
        return this;
    }

    public void setUdfn21(Integer udfn21) {
        this.udfn21 = udfn21;
    }

    public Integer getUdfn22() {
        return this.udfn22;
    }

    public ReservationName udfn22(Integer udfn22) {
        this.setUdfn22(udfn22);
        return this;
    }

    public void setUdfn22(Integer udfn22) {
        this.udfn22 = udfn22;
    }

    public Integer getUdfn23() {
        return this.udfn23;
    }

    public ReservationName udfn23(Integer udfn23) {
        this.setUdfn23(udfn23);
        return this;
    }

    public void setUdfn23(Integer udfn23) {
        this.udfn23 = udfn23;
    }

    public Integer getUdfn24() {
        return this.udfn24;
    }

    public ReservationName udfn24(Integer udfn24) {
        this.setUdfn24(udfn24);
        return this;
    }

    public void setUdfn24(Integer udfn24) {
        this.udfn24 = udfn24;
    }

    public Integer getUdfn25() {
        return this.udfn25;
    }

    public ReservationName udfn25(Integer udfn25) {
        this.setUdfn25(udfn25);
        return this;
    }

    public void setUdfn25(Integer udfn25) {
        this.udfn25 = udfn25;
    }

    public Integer getUdfn26() {
        return this.udfn26;
    }

    public ReservationName udfn26(Integer udfn26) {
        this.setUdfn26(udfn26);
        return this;
    }

    public void setUdfn26(Integer udfn26) {
        this.udfn26 = udfn26;
    }

    public Integer getUdfn27() {
        return this.udfn27;
    }

    public ReservationName udfn27(Integer udfn27) {
        this.setUdfn27(udfn27);
        return this;
    }

    public void setUdfn27(Integer udfn27) {
        this.udfn27 = udfn27;
    }

    public Integer getUdfn28() {
        return this.udfn28;
    }

    public ReservationName udfn28(Integer udfn28) {
        this.setUdfn28(udfn28);
        return this;
    }

    public void setUdfn28(Integer udfn28) {
        this.udfn28 = udfn28;
    }

    public Integer getUdfn29() {
        return this.udfn29;
    }

    public ReservationName udfn29(Integer udfn29) {
        this.setUdfn29(udfn29);
        return this;
    }

    public void setUdfn29(Integer udfn29) {
        this.udfn29 = udfn29;
    }

    public Integer getUdfn30() {
        return this.udfn30;
    }

    public ReservationName udfn30(Integer udfn30) {
        this.setUdfn30(udfn30);
        return this;
    }

    public void setUdfn30(Integer udfn30) {
        this.udfn30 = udfn30;
    }

    public Integer getUdfn31() {
        return this.udfn31;
    }

    public ReservationName udfn31(Integer udfn31) {
        this.setUdfn31(udfn31);
        return this;
    }

    public void setUdfn31(Integer udfn31) {
        this.udfn31 = udfn31;
    }

    public Integer getUdfn32() {
        return this.udfn32;
    }

    public ReservationName udfn32(Integer udfn32) {
        this.setUdfn32(udfn32);
        return this;
    }

    public void setUdfn32(Integer udfn32) {
        this.udfn32 = udfn32;
    }

    public Integer getUdfn33() {
        return this.udfn33;
    }

    public ReservationName udfn33(Integer udfn33) {
        this.setUdfn33(udfn33);
        return this;
    }

    public void setUdfn33(Integer udfn33) {
        this.udfn33 = udfn33;
    }

    public Integer getUdfn34() {
        return this.udfn34;
    }

    public ReservationName udfn34(Integer udfn34) {
        this.setUdfn34(udfn34);
        return this;
    }

    public void setUdfn34(Integer udfn34) {
        this.udfn34 = udfn34;
    }

    public Integer getUdfn35() {
        return this.udfn35;
    }

    public ReservationName udfn35(Integer udfn35) {
        this.setUdfn35(udfn35);
        return this;
    }

    public void setUdfn35(Integer udfn35) {
        this.udfn35 = udfn35;
    }

    public Integer getUdfn36() {
        return this.udfn36;
    }

    public ReservationName udfn36(Integer udfn36) {
        this.setUdfn36(udfn36);
        return this;
    }

    public void setUdfn36(Integer udfn36) {
        this.udfn36 = udfn36;
    }

    public Integer getUdfn37() {
        return this.udfn37;
    }

    public ReservationName udfn37(Integer udfn37) {
        this.setUdfn37(udfn37);
        return this;
    }

    public void setUdfn37(Integer udfn37) {
        this.udfn37 = udfn37;
    }

    public Integer getUdfn38() {
        return this.udfn38;
    }

    public ReservationName udfn38(Integer udfn38) {
        this.setUdfn38(udfn38);
        return this;
    }

    public void setUdfn38(Integer udfn38) {
        this.udfn38 = udfn38;
    }

    public Integer getUdfn39() {
        return this.udfn39;
    }

    public ReservationName udfn39(Integer udfn39) {
        this.setUdfn39(udfn39);
        return this;
    }

    public void setUdfn39(Integer udfn39) {
        this.udfn39 = udfn39;
    }

    public Integer getUdfn40() {
        return this.udfn40;
    }

    public ReservationName udfn40(Integer udfn40) {
        this.setUdfn40(udfn40);
        return this;
    }

    public void setUdfn40(Integer udfn40) {
        this.udfn40 = udfn40;
    }

    public LocalDate getUdfd01() {
        return this.udfd01;
    }

    public ReservationName udfd01(LocalDate udfd01) {
        this.setUdfd01(udfd01);
        return this;
    }

    public void setUdfd01(LocalDate udfd01) {
        this.udfd01 = udfd01;
    }

    public LocalDate getUdfd02() {
        return this.udfd02;
    }

    public ReservationName udfd02(LocalDate udfd02) {
        this.setUdfd02(udfd02);
        return this;
    }

    public void setUdfd02(LocalDate udfd02) {
        this.udfd02 = udfd02;
    }

    public LocalDate getUdfd03() {
        return this.udfd03;
    }

    public ReservationName udfd03(LocalDate udfd03) {
        this.setUdfd03(udfd03);
        return this;
    }

    public void setUdfd03(LocalDate udfd03) {
        this.udfd03 = udfd03;
    }

    public LocalDate getUdfd04() {
        return this.udfd04;
    }

    public ReservationName udfd04(LocalDate udfd04) {
        this.setUdfd04(udfd04);
        return this;
    }

    public void setUdfd04(LocalDate udfd04) {
        this.udfd04 = udfd04;
    }

    public LocalDate getUdfd05() {
        return this.udfd05;
    }

    public ReservationName udfd05(LocalDate udfd05) {
        this.setUdfd05(udfd05);
        return this;
    }

    public void setUdfd05(LocalDate udfd05) {
        this.udfd05 = udfd05;
    }

    public LocalDate getUdfd06() {
        return this.udfd06;
    }

    public ReservationName udfd06(LocalDate udfd06) {
        this.setUdfd06(udfd06);
        return this;
    }

    public void setUdfd06(LocalDate udfd06) {
        this.udfd06 = udfd06;
    }

    public LocalDate getUdfd07() {
        return this.udfd07;
    }

    public ReservationName udfd07(LocalDate udfd07) {
        this.setUdfd07(udfd07);
        return this;
    }

    public void setUdfd07(LocalDate udfd07) {
        this.udfd07 = udfd07;
    }

    public LocalDate getUdfd08() {
        return this.udfd08;
    }

    public ReservationName udfd08(LocalDate udfd08) {
        this.setUdfd08(udfd08);
        return this;
    }

    public void setUdfd08(LocalDate udfd08) {
        this.udfd08 = udfd08;
    }

    public LocalDate getUdfd09() {
        return this.udfd09;
    }

    public ReservationName udfd09(LocalDate udfd09) {
        this.setUdfd09(udfd09);
        return this;
    }

    public void setUdfd09(LocalDate udfd09) {
        this.udfd09 = udfd09;
    }

    public LocalDate getUdfd10() {
        return this.udfd10;
    }

    public ReservationName udfd10(LocalDate udfd10) {
        this.setUdfd10(udfd10);
        return this;
    }

    public void setUdfd10(LocalDate udfd10) {
        this.udfd10 = udfd10;
    }

    public Integer getInsertActionInstanceId() {
        return this.insertActionInstanceId;
    }

    public ReservationName insertActionInstanceId(Integer insertActionInstanceId) {
        this.setInsertActionInstanceId(insertActionInstanceId);
        return this;
    }

    public void setInsertActionInstanceId(Integer insertActionInstanceId) {
        this.insertActionInstanceId = insertActionInstanceId;
    }

    public Integer getDmlSeqNo() {
        return this.dmlSeqNo;
    }

    public ReservationName dmlSeqNo(Integer dmlSeqNo) {
        this.setDmlSeqNo(dmlSeqNo);
        return this;
    }

    public void setDmlSeqNo(Integer dmlSeqNo) {
        this.dmlSeqNo = dmlSeqNo;
    }

    public LocalDate getBusinessDateCreated() {
        return this.businessDateCreated;
    }

    public ReservationName businessDateCreated(LocalDate businessDateCreated) {
        this.setBusinessDateCreated(businessDateCreated);
        return this;
    }

    public void setBusinessDateCreated(LocalDate businessDateCreated) {
        this.businessDateCreated = businessDateCreated;
    }

    public String getTurndownYn() {
        return this.turndownYn;
    }

    public ReservationName turndownYn(String turndownYn) {
        this.setTurndownYn(turndownYn);
        return this;
    }

    public void setTurndownYn(String turndownYn) {
        this.turndownYn = turndownYn;
    }

    public String getRoomInstructions() {
        return this.roomInstructions;
    }

    public ReservationName roomInstructions(String roomInstructions) {
        this.setRoomInstructions(roomInstructions);
        return this;
    }

    public void setRoomInstructions(String roomInstructions) {
        this.roomInstructions = roomInstructions;
    }

    public String getRoomServiceTime() {
        return this.roomServiceTime;
    }

    public ReservationName roomServiceTime(String roomServiceTime) {
        this.setRoomServiceTime(roomServiceTime);
        return this;
    }

    public void setRoomServiceTime(String roomServiceTime) {
        this.roomServiceTime = roomServiceTime;
    }

    public Integer getEventId() {
        return this.eventId;
    }

    public ReservationName eventId(Integer eventId) {
        this.setEventId(eventId);
        return this;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getRevenueTypeCode() {
        return this.revenueTypeCode;
    }

    public ReservationName revenueTypeCode(String revenueTypeCode) {
        this.setRevenueTypeCode(revenueTypeCode);
        return this;
    }

    public void setRevenueTypeCode(String revenueTypeCode) {
        this.revenueTypeCode = revenueTypeCode;
    }

    public Integer getHurdle() {
        return this.hurdle;
    }

    public ReservationName hurdle(Integer hurdle) {
        this.setHurdle(hurdle);
        return this;
    }

    public void setHurdle(Integer hurdle) {
        this.hurdle = hurdle;
    }

    public String getHurdleOverride() {
        return this.hurdleOverride;
    }

    public ReservationName hurdleOverride(String hurdleOverride) {
        this.setHurdleOverride(hurdleOverride);
        return this;
    }

    public void setHurdleOverride(String hurdleOverride) {
        this.hurdleOverride = hurdleOverride;
    }

    public Integer getRateableValue() {
        return this.rateableValue;
    }

    public ReservationName rateableValue(Integer rateableValue) {
        this.setRateableValue(rateableValue);
        return this;
    }

    public void setRateableValue(Integer rateableValue) {
        this.rateableValue = rateableValue;
    }

    public String getRestrictionOverride() {
        return this.restrictionOverride;
    }

    public ReservationName restrictionOverride(String restrictionOverride) {
        this.setRestrictionOverride(restrictionOverride);
        return this;
    }

    public void setRestrictionOverride(String restrictionOverride) {
        this.restrictionOverride = restrictionOverride;
    }

    public String getYieldableYn() {
        return this.yieldableYn;
    }

    public ReservationName yieldableYn(String yieldableYn) {
        this.setYieldableYn(yieldableYn);
        return this;
    }

    public void setYieldableYn(String yieldableYn) {
        this.yieldableYn = yieldableYn;
    }

    public String getSguestFirstname() {
        return this.sguestFirstname;
    }

    public ReservationName sguestFirstname(String sguestFirstname) {
        this.setSguestFirstname(sguestFirstname);
        return this;
    }

    public void setSguestFirstname(String sguestFirstname) {
        this.sguestFirstname = sguestFirstname;
    }

    public String getGuestLastName() {
        return this.guestLastName;
    }

    public ReservationName guestLastName(String guestLastName) {
        this.setGuestLastName(guestLastName);
        return this;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public String getGuestFirstName() {
        return this.guestFirstName;
    }

    public ReservationName guestFirstName(String guestFirstName) {
        this.setGuestFirstName(guestFirstName);
        return this;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastNameSdx() {
        return this.guestLastNameSdx;
    }

    public ReservationName guestLastNameSdx(String guestLastNameSdx) {
        this.setGuestLastNameSdx(guestLastNameSdx);
        return this;
    }

    public void setGuestLastNameSdx(String guestLastNameSdx) {
        this.guestLastNameSdx = guestLastNameSdx;
    }

    public String getGuestFirstNameSdx() {
        return this.guestFirstNameSdx;
    }

    public ReservationName guestFirstNameSdx(String guestFirstNameSdx) {
        this.setGuestFirstNameSdx(guestFirstNameSdx);
        return this;
    }

    public void setGuestFirstNameSdx(String guestFirstNameSdx) {
        this.guestFirstNameSdx = guestFirstNameSdx;
    }

    public String getChannel() {
        return this.channel;
    }

    public ReservationName channel(String channel) {
        this.setChannel(channel);
        return this;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getShareSeqNo() {
        return this.shareSeqNo;
    }

    public ReservationName shareSeqNo(Integer shareSeqNo) {
        this.setShareSeqNo(shareSeqNo);
        return this;
    }

    public void setShareSeqNo(Integer shareSeqNo) {
        this.shareSeqNo = shareSeqNo;
    }

    public String getGuestSignature() {
        return this.guestSignature;
    }

    public ReservationName guestSignature(String guestSignature) {
        this.setGuestSignature(guestSignature);
        return this;
    }

    public void setGuestSignature(String guestSignature) {
        this.guestSignature = guestSignature;
    }

    public Integer getExtensionId() {
        return this.extensionId;
    }

    public ReservationName extensionId(Integer extensionId) {
        this.setExtensionId(extensionId);
        return this;
    }

    public void setExtensionId(Integer extensionId) {
        this.extensionId = extensionId;
    }

    public Integer getResvContactId() {
        return this.resvContactId;
    }

    public ReservationName resvContactId(Integer resvContactId) {
        this.setResvContactId(resvContactId);
        return this;
    }

    public void setResvContactId(Integer resvContactId) {
        this.resvContactId = resvContactId;
    }

    public Integer getBillingContactId() {
        return this.billingContactId;
    }

    public ReservationName billingContactId(Integer billingContactId) {
        this.setBillingContactId(billingContactId);
        return this;
    }

    public void setBillingContactId(Integer billingContactId) {
        this.billingContactId = billingContactId;
    }

    public String getResInsertSource() {
        return this.resInsertSource;
    }

    public ReservationName resInsertSource(String resInsertSource) {
        this.setResInsertSource(resInsertSource);
        return this;
    }

    public void setResInsertSource(String resInsertSource) {
        this.resInsertSource = resInsertSource;
    }

    public String getResInsertSourceType() {
        return this.resInsertSourceType;
    }

    public ReservationName resInsertSourceType(String resInsertSourceType) {
        this.setResInsertSourceType(resInsertSourceType);
        return this;
    }

    public void setResInsertSourceType(String resInsertSourceType) {
        this.resInsertSourceType = resInsertSourceType;
    }

    public String getMasterShare() {
        return this.masterShare;
    }

    public ReservationName masterShare(String masterShare) {
        this.setMasterShare(masterShare);
        return this;
    }

    public void setMasterShare(String masterShare) {
        this.masterShare = masterShare;
    }

    public String getRegistrationCardNo() {
        return this.registrationCardNo;
    }

    public ReservationName registrationCardNo(String registrationCardNo) {
        this.setRegistrationCardNo(registrationCardNo);
        return this;
    }

    public void setRegistrationCardNo(String registrationCardNo) {
        this.registrationCardNo = registrationCardNo;
    }

    public String getTiad() {
        return this.tiad;
    }

    public ReservationName tiad(String tiad) {
        this.setTiad(tiad);
        return this;
    }

    public void setTiad(String tiad) {
        this.tiad = tiad;
    }

    public String getPurposeOfStay() {
        return this.purposeOfStay;
    }

    public ReservationName purposeOfStay(String purposeOfStay) {
        this.setPurposeOfStay(purposeOfStay);
        return this;
    }

    public void setPurposeOfStay(String purposeOfStay) {
        this.purposeOfStay = purposeOfStay;
    }

    public LocalDate getReinstateDate() {
        return this.reinstateDate;
    }

    public ReservationName reinstateDate(LocalDate reinstateDate) {
        this.setReinstateDate(reinstateDate);
        return this;
    }

    public void setReinstateDate(LocalDate reinstateDate) {
        this.reinstateDate = reinstateDate;
    }

    public LocalDate getPurgeDate() {
        return this.purgeDate;
    }

    public ReservationName purgeDate(LocalDate purgeDate) {
        this.setPurgeDate(purgeDate);
        return this;
    }

    public void setPurgeDate(LocalDate purgeDate) {
        this.purgeDate = purgeDate;
    }

    public LocalDate getLastSettleDate() {
        return this.lastSettleDate;
    }

    public ReservationName lastSettleDate(LocalDate lastSettleDate) {
        this.setLastSettleDate(lastSettleDate);
        return this;
    }

    public void setLastSettleDate(LocalDate lastSettleDate) {
        this.lastSettleDate = lastSettleDate;
    }

    public LocalDate getLastPeriodicFolioDate() {
        return this.lastPeriodicFolioDate;
    }

    public ReservationName lastPeriodicFolioDate(LocalDate lastPeriodicFolioDate) {
        this.setLastPeriodicFolioDate(lastPeriodicFolioDate);
        return this;
    }

    public void setLastPeriodicFolioDate(LocalDate lastPeriodicFolioDate) {
        this.lastPeriodicFolioDate = lastPeriodicFolioDate;
    }

    public Integer getPeriodicFolioFreq() {
        return this.periodicFolioFreq;
    }

    public ReservationName periodicFolioFreq(Integer periodicFolioFreq) {
        this.setPeriodicFolioFreq(periodicFolioFreq);
        return this;
    }

    public void setPeriodicFolioFreq(Integer periodicFolioFreq) {
        this.periodicFolioFreq = periodicFolioFreq;
    }

    public Integer getConfirmationLegNo() {
        return this.confirmationLegNo;
    }

    public ReservationName confirmationLegNo(Integer confirmationLegNo) {
        this.setConfirmationLegNo(confirmationLegNo);
        return this;
    }

    public void setConfirmationLegNo(Integer confirmationLegNo) {
        this.confirmationLegNo = confirmationLegNo;
    }

    public String getGuestStatus() {
        return this.guestStatus;
    }

    public ReservationName guestStatus(String guestStatus) {
        this.setGuestStatus(guestStatus);
        return this;
    }

    public void setGuestStatus(String guestStatus) {
        this.guestStatus = guestStatus;
    }

    public String getGuestType() {
        return this.guestType;
    }

    public ReservationName guestType(String guestType) {
        this.setGuestType(guestType);
        return this;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public Integer getCheckinDuration() {
        return this.checkinDuration;
    }

    public ReservationName checkinDuration(Integer checkinDuration) {
        this.setCheckinDuration(checkinDuration);
        return this;
    }

    public void setCheckinDuration(Integer checkinDuration) {
        this.checkinDuration = checkinDuration;
    }

    public Integer getAuthorizerId() {
        return this.authorizerId;
    }

    public ReservationName authorizerId(Integer authorizerId) {
        this.setAuthorizerId(authorizerId);
        return this;
    }

    public void setAuthorizerId(Integer authorizerId) {
        this.authorizerId = authorizerId;
    }

    public Integer getLastOnlinePrintSeq() {
        return this.lastOnlinePrintSeq;
    }

    public ReservationName lastOnlinePrintSeq(Integer lastOnlinePrintSeq) {
        this.setLastOnlinePrintSeq(lastOnlinePrintSeq);
        return this;
    }

    public void setLastOnlinePrintSeq(Integer lastOnlinePrintSeq) {
        this.lastOnlinePrintSeq = lastOnlinePrintSeq;
    }

    public String getEntryPoint() {
        return this.entryPoint;
    }

    public ReservationName entryPoint(String entryPoint) {
        this.setEntryPoint(entryPoint);
        return this;
    }

    public void setEntryPoint(String entryPoint) {
        this.entryPoint = entryPoint;
    }

    public LocalDate getEntryDate() {
        return this.entryDate;
    }

    public ReservationName entryDate(LocalDate entryDate) {
        this.setEntryDate(entryDate);
        return this;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getPseudoMemType() {
        return this.pseudoMemType;
    }

    public ReservationName pseudoMemType(String pseudoMemType) {
        this.setPseudoMemType(pseudoMemType);
        return this;
    }

    public void setPseudoMemType(String pseudoMemType) {
        this.pseudoMemType = pseudoMemType;
    }

    public Integer getPseudoMemTotalPoints() {
        return this.pseudoMemTotalPoints;
    }

    public ReservationName pseudoMemTotalPoints(Integer pseudoMemTotalPoints) {
        this.setPseudoMemTotalPoints(pseudoMemTotalPoints);
        return this;
    }

    public void setPseudoMemTotalPoints(Integer pseudoMemTotalPoints) {
        this.pseudoMemTotalPoints = pseudoMemTotalPoints;
    }

    public String getFolioText1() {
        return this.folioText1;
    }

    public ReservationName folioText1(String folioText1) {
        this.setFolioText1(folioText1);
        return this;
    }

    public void setFolioText1(String folioText1) {
        this.folioText1 = folioText1;
    }

    public String getFolioText2() {
        return this.folioText2;
    }

    public ReservationName folioText2(String folioText2) {
        this.setFolioText2(folioText2);
        return this;
    }

    public void setFolioText2(String folioText2) {
        this.folioText2 = folioText2;
    }

    public String getCompTypeCode() {
        return this.compTypeCode;
    }

    public ReservationName compTypeCode(String compTypeCode) {
        this.setCompTypeCode(compTypeCode);
        return this;
    }

    public void setCompTypeCode(String compTypeCode) {
        this.compTypeCode = compTypeCode;
    }

    public String getUniCardId() {
        return this.uniCardId;
    }

    public ReservationName uniCardId(String uniCardId) {
        this.setUniCardId(uniCardId);
        return this;
    }

    public void setUniCardId(String uniCardId) {
        this.uniCardId = uniCardId;
    }

    public Integer getExpCheckinresId() {
        return this.expCheckinresId;
    }

    public ReservationName expCheckinresId(Integer expCheckinresId) {
        this.setExpCheckinresId(expCheckinresId);
        return this;
    }

    public void setExpCheckinresId(Integer expCheckinresId) {
        this.expCheckinresId = expCheckinresId;
    }

    public LocalDate getOriginalBeginDate() {
        return this.originalBeginDate;
    }

    public ReservationName originalBeginDate(LocalDate originalBeginDate) {
        this.setOriginalBeginDate(originalBeginDate);
        return this;
    }

    public void setOriginalBeginDate(LocalDate originalBeginDate) {
        this.originalBeginDate = originalBeginDate;
    }

    public String getOwnerFfFlag() {
        return this.ownerFfFlag;
    }

    public ReservationName ownerFfFlag(String ownerFfFlag) {
        this.setOwnerFfFlag(ownerFfFlag);
        return this;
    }

    public void setOwnerFfFlag(String ownerFfFlag) {
        this.ownerFfFlag = ownerFfFlag;
    }

    public String getCommissionPayoutTo() {
        return this.commissionPayoutTo;
    }

    public ReservationName commissionPayoutTo(String commissionPayoutTo) {
        this.setCommissionPayoutTo(commissionPayoutTo);
        return this;
    }

    public void setCommissionPayoutTo(String commissionPayoutTo) {
        this.commissionPayoutTo = commissionPayoutTo;
    }

    public String getPreChargingYn() {
        return this.preChargingYn;
    }

    public ReservationName preChargingYn(String preChargingYn) {
        this.setPreChargingYn(preChargingYn);
        return this;
    }

    public void setPreChargingYn(String preChargingYn) {
        this.preChargingYn = preChargingYn;
    }

    public String getPostChargingYn() {
        return this.postChargingYn;
    }

    public ReservationName postChargingYn(String postChargingYn) {
        this.setPostChargingYn(postChargingYn);
        return this;
    }

    public void setPostChargingYn(String postChargingYn) {
        this.postChargingYn = postChargingYn;
    }

    public String getPostCoFlag() {
        return this.postCoFlag;
    }

    public ReservationName postCoFlag(String postCoFlag) {
        this.setPostCoFlag(postCoFlag);
        return this;
    }

    public void setPostCoFlag(String postCoFlag) {
        this.postCoFlag = postCoFlag;
    }

    public LocalDate getFolioCloseDate() {
        return this.folioCloseDate;
    }

    public ReservationName folioCloseDate(LocalDate folioCloseDate) {
        this.setFolioCloseDate(folioCloseDate);
        return this;
    }

    public void setFolioCloseDate(LocalDate folioCloseDate) {
        this.folioCloseDate = folioCloseDate;
    }

    public String getScheduleCheckoutYn() {
        return this.scheduleCheckoutYn;
    }

    public ReservationName scheduleCheckoutYn(String scheduleCheckoutYn) {
        this.setScheduleCheckoutYn(scheduleCheckoutYn);
        return this;
    }

    public void setScheduleCheckoutYn(String scheduleCheckoutYn) {
        this.scheduleCheckoutYn = scheduleCheckoutYn;
    }

    public String getCustomReference() {
        return this.customReference;
    }

    public ReservationName customReference(String customReference) {
        this.setCustomReference(customReference);
        return this;
    }

    public void setCustomReference(String customReference) {
        this.customReference = customReference;
    }

    public String getGuaranteeCodePreCi() {
        return this.guaranteeCodePreCi;
    }

    public ReservationName guaranteeCodePreCi(String guaranteeCodePreCi) {
        this.setGuaranteeCodePreCi(guaranteeCodePreCi);
        return this;
    }

    public void setGuaranteeCodePreCi(String guaranteeCodePreCi) {
        this.guaranteeCodePreCi = guaranteeCodePreCi;
    }

    public Integer getAwardMembershipId() {
        return this.awardMembershipId;
    }

    public ReservationName awardMembershipId(Integer awardMembershipId) {
        this.setAwardMembershipId(awardMembershipId);
        return this;
    }

    public void setAwardMembershipId(Integer awardMembershipId) {
        this.awardMembershipId = awardMembershipId;
    }

    public String getEsignedRegCardName() {
        return this.esignedRegCardName;
    }

    public ReservationName esignedRegCardName(String esignedRegCardName) {
        this.setEsignedRegCardName(esignedRegCardName);
        return this;
    }

    public void setEsignedRegCardName(String esignedRegCardName) {
        this.esignedRegCardName = esignedRegCardName;
    }

    public Integer getStatisticalRoomType() {
        return this.statisticalRoomType;
    }

    public ReservationName statisticalRoomType(Integer statisticalRoomType) {
        this.setStatisticalRoomType(statisticalRoomType);
        return this;
    }

    public void setStatisticalRoomType(Integer statisticalRoomType) {
        this.statisticalRoomType = statisticalRoomType;
    }

    public Integer getStatisticalRateTier() {
        return this.statisticalRateTier;
    }

    public ReservationName statisticalRateTier(Integer statisticalRateTier) {
        this.setStatisticalRateTier(statisticalRateTier);
        return this;
    }

    public void setStatisticalRateTier(Integer statisticalRateTier) {
        this.statisticalRateTier = statisticalRateTier;
    }

    public String getYmCode() {
        return this.ymCode;
    }

    public ReservationName ymCode(String ymCode) {
        this.setYmCode(ymCode);
        return this;
    }

    public void setYmCode(String ymCode) {
        this.ymCode = ymCode;
    }

    public LocalDate getKeyValidUntil() {
        return this.keyValidUntil;
    }

    public ReservationName keyValidUntil(LocalDate keyValidUntil) {
        this.setKeyValidUntil(keyValidUntil);
        return this;
    }

    public void setKeyValidUntil(LocalDate keyValidUntil) {
        this.keyValidUntil = keyValidUntil;
    }

    public String getPreRegisteredYn() {
        return this.preRegisteredYn;
    }

    public ReservationName preRegisteredYn(String preRegisteredYn) {
        this.setPreRegisteredYn(preRegisteredYn);
        return this;
    }

    public void setPreRegisteredYn(String preRegisteredYn) {
        this.preRegisteredYn = preRegisteredYn;
    }

    public Integer getTaxRegistrationNo() {
        return this.taxRegistrationNo;
    }

    public ReservationName taxRegistrationNo(Integer taxRegistrationNo) {
        this.setTaxRegistrationNo(taxRegistrationNo);
        return this;
    }

    public void setTaxRegistrationNo(Integer taxRegistrationNo) {
        this.taxRegistrationNo = taxRegistrationNo;
    }

    public String getVisaNumber() {
        return this.visaNumber;
    }

    public ReservationName visaNumber(String visaNumber) {
        this.setVisaNumber(visaNumber);
        return this;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public LocalDate getVisaIssueDate() {
        return this.visaIssueDate;
    }

    public ReservationName visaIssueDate(LocalDate visaIssueDate) {
        this.setVisaIssueDate(visaIssueDate);
        return this;
    }

    public void setVisaIssueDate(LocalDate visaIssueDate) {
        this.visaIssueDate = visaIssueDate;
    }

    public LocalDate getVisaExpirationDate() {
        return this.visaExpirationDate;
    }

    public ReservationName visaExpirationDate(LocalDate visaExpirationDate) {
        this.setVisaExpirationDate(visaExpirationDate);
        return this;
    }

    public void setVisaExpirationDate(LocalDate visaExpirationDate) {
        this.visaExpirationDate = visaExpirationDate;
    }

    public Integer getTaxNoOfStays() {
        return this.taxNoOfStays;
    }

    public ReservationName taxNoOfStays(Integer taxNoOfStays) {
        this.setTaxNoOfStays(taxNoOfStays);
        return this;
    }

    public void setTaxNoOfStays(Integer taxNoOfStays) {
        this.taxNoOfStays = taxNoOfStays;
    }

    public String getAsbProratedYn() {
        return this.asbProratedYn;
    }

    public ReservationName asbProratedYn(String asbProratedYn) {
        this.setAsbProratedYn(asbProratedYn);
        return this;
    }

    public void setAsbProratedYn(String asbProratedYn) {
        this.asbProratedYn = asbProratedYn;
    }

    public Integer getAutoSettleDays() {
        return this.autoSettleDays;
    }

    public ReservationName autoSettleDays(Integer autoSettleDays) {
        this.setAutoSettleDays(autoSettleDays);
        return this;
    }

    public void setAutoSettleDays(Integer autoSettleDays) {
        this.autoSettleDays = autoSettleDays;
    }

    public String getAutoSettleYn() {
        return this.autoSettleYn;
    }

    public ReservationName autoSettleYn(String autoSettleYn) {
        this.setAutoSettleYn(autoSettleYn);
        return this;
    }

    public void setAutoSettleYn(String autoSettleYn) {
        this.autoSettleYn = autoSettleYn;
    }

    public Integer getSplitFromResvNameId() {
        return this.splitFromResvNameId;
    }

    public ReservationName splitFromResvNameId(Integer splitFromResvNameId) {
        this.setSplitFromResvNameId(splitFromResvNameId);
        return this;
    }

    public void setSplitFromResvNameId(Integer splitFromResvNameId) {
        this.splitFromResvNameId = splitFromResvNameId;
    }

    public String getNextDestination() {
        return this.nextDestination;
    }

    public ReservationName nextDestination(String nextDestination) {
        this.setNextDestination(nextDestination);
        return this;
    }

    public void setNextDestination(String nextDestination) {
        this.nextDestination = nextDestination;
    }

    public LocalDate getDateOfArrivalInCountry() {
        return this.dateOfArrivalInCountry;
    }

    public ReservationName dateOfArrivalInCountry(LocalDate dateOfArrivalInCountry) {
        this.setDateOfArrivalInCountry(dateOfArrivalInCountry);
        return this;
    }

    public void setDateOfArrivalInCountry(LocalDate dateOfArrivalInCountry) {
        this.dateOfArrivalInCountry = dateOfArrivalInCountry;
    }

    public LocalDate getPreArrReviewedDt() {
        return this.preArrReviewedDt;
    }

    public ReservationName preArrReviewedDt(LocalDate preArrReviewedDt) {
        this.setPreArrReviewedDt(preArrReviewedDt);
        return this;
    }

    public void setPreArrReviewedDt(LocalDate preArrReviewedDt) {
        this.preArrReviewedDt = preArrReviewedDt;
    }

    public Integer getPreArrReviewedUser() {
        return this.preArrReviewedUser;
    }

    public ReservationName preArrReviewedUser(Integer preArrReviewedUser) {
        this.setPreArrReviewedUser(preArrReviewedUser);
        return this;
    }

    public void setPreArrReviewedUser(Integer preArrReviewedUser) {
        this.preArrReviewedUser = preArrReviewedUser;
    }

    public Integer getBonusCheckId() {
        return this.bonusCheckId;
    }

    public ReservationName bonusCheckId(Integer bonusCheckId) {
        this.setBonusCheckId(bonusCheckId);
        return this;
    }

    public void setBonusCheckId(Integer bonusCheckId) {
        this.bonusCheckId = bonusCheckId;
    }

    public String getMobileAudioKeyYn() {
        return this.mobileAudioKeyYn;
    }

    public ReservationName mobileAudioKeyYn(String mobileAudioKeyYn) {
        this.setMobileAudioKeyYn(mobileAudioKeyYn);
        return this;
    }

    public void setMobileAudioKeyYn(String mobileAudioKeyYn) {
        this.mobileAudioKeyYn = mobileAudioKeyYn;
    }

    public String getDirectBillVerifyResponse() {
        return this.directBillVerifyResponse;
    }

    public ReservationName directBillVerifyResponse(String directBillVerifyResponse) {
        this.setDirectBillVerifyResponse(directBillVerifyResponse);
        return this;
    }

    public void setDirectBillVerifyResponse(String directBillVerifyResponse) {
        this.directBillVerifyResponse = directBillVerifyResponse;
    }

    public Integer getAddresseeNameId() {
        return this.addresseeNameId;
    }

    public ReservationName addresseeNameId(Integer addresseeNameId) {
        this.setAddresseeNameId(addresseeNameId);
        return this;
    }

    public void setAddresseeNameId(Integer addresseeNameId) {
        this.addresseeNameId = addresseeNameId;
    }

    public String getSuperSearchIndexText() {
        return this.superSearchIndexText;
    }

    public ReservationName superSearchIndexText(String superSearchIndexText) {
        this.setSuperSearchIndexText(superSearchIndexText);
        return this;
    }

    public void setSuperSearchIndexText(String superSearchIndexText) {
        this.superSearchIndexText = superSearchIndexText;
    }

    public String getAutoCheckinYn() {
        return this.autoCheckinYn;
    }

    public ReservationName autoCheckinYn(String autoCheckinYn) {
        this.setAutoCheckinYn(autoCheckinYn);
        return this;
    }

    public void setAutoCheckinYn(String autoCheckinYn) {
        this.autoCheckinYn = autoCheckinYn;
    }

    public String getEmailFolioYn() {
        return this.emailFolioYn;
    }

    public ReservationName emailFolioYn(String emailFolioYn) {
        this.setEmailFolioYn(emailFolioYn);
        return this;
    }

    public void setEmailFolioYn(String emailFolioYn) {
        this.emailFolioYn = emailFolioYn;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public ReservationName emailAddress(String emailAddress) {
        this.setEmailAddress(emailAddress);
        return this;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSpgUpgradeConfirmedRoomtype() {
        return this.spgUpgradeConfirmedRoomtype;
    }

    public ReservationName spgUpgradeConfirmedRoomtype(String spgUpgradeConfirmedRoomtype) {
        this.setSpgUpgradeConfirmedRoomtype(spgUpgradeConfirmedRoomtype);
        return this;
    }

    public void setSpgUpgradeConfirmedRoomtype(String spgUpgradeConfirmedRoomtype) {
        this.spgUpgradeConfirmedRoomtype = spgUpgradeConfirmedRoomtype;
    }

    public String getSpgUpgradeReasonCode() {
        return this.spgUpgradeReasonCode;
    }

    public ReservationName spgUpgradeReasonCode(String spgUpgradeReasonCode) {
        this.setSpgUpgradeReasonCode(spgUpgradeReasonCode);
        return this;
    }

    public void setSpgUpgradeReasonCode(String spgUpgradeReasonCode) {
        this.spgUpgradeReasonCode = spgUpgradeReasonCode;
    }

    public String getSpgSuiteNightAwardStatus() {
        return this.spgSuiteNightAwardStatus;
    }

    public ReservationName spgSuiteNightAwardStatus(String spgSuiteNightAwardStatus) {
        this.setSpgSuiteNightAwardStatus(spgSuiteNightAwardStatus);
        return this;
    }

    public void setSpgSuiteNightAwardStatus(String spgSuiteNightAwardStatus) {
        this.spgSuiteNightAwardStatus = spgSuiteNightAwardStatus;
    }

    public String getSpgDiscloseRoomTypeYn() {
        return this.spgDiscloseRoomTypeYn;
    }

    public ReservationName spgDiscloseRoomTypeYn(String spgDiscloseRoomTypeYn) {
        this.setSpgDiscloseRoomTypeYn(spgDiscloseRoomTypeYn);
        return this;
    }

    public void setSpgDiscloseRoomTypeYn(String spgDiscloseRoomTypeYn) {
        this.spgDiscloseRoomTypeYn = spgDiscloseRoomTypeYn;
    }

    public String getAmenityEligibleYn() {
        return this.amenityEligibleYn;
    }

    public ReservationName amenityEligibleYn(String amenityEligibleYn) {
        this.setAmenityEligibleYn(amenityEligibleYn);
        return this;
    }

    public void setAmenityEligibleYn(String amenityEligibleYn) {
        this.amenityEligibleYn = amenityEligibleYn;
    }

    public String getAmenityLevelCode() {
        return this.amenityLevelCode;
    }

    public ReservationName amenityLevelCode(String amenityLevelCode) {
        this.setAmenityLevelCode(amenityLevelCode);
        return this;
    }

    public void setAmenityLevelCode(String amenityLevelCode) {
        this.amenityLevelCode = amenityLevelCode;
    }

    public String getBaseRateCurrencyCode() {
        return this.baseRateCurrencyCode;
    }

    public ReservationName baseRateCurrencyCode(String baseRateCurrencyCode) {
        this.setBaseRateCurrencyCode(baseRateCurrencyCode);
        return this;
    }

    public void setBaseRateCurrencyCode(String baseRateCurrencyCode) {
        this.baseRateCurrencyCode = baseRateCurrencyCode;
    }

    public String getBaseRateCode() {
        return this.baseRateCode;
    }

    public ReservationName baseRateCode(String baseRateCode) {
        this.setBaseRateCode(baseRateCode);
        return this;
    }

    public void setBaseRateCode(String baseRateCode) {
        this.baseRateCode = baseRateCode;
    }

    public Integer getLocalBaseRateAmount() {
        return this.localBaseRateAmount;
    }

    public ReservationName localBaseRateAmount(Integer localBaseRateAmount) {
        this.setLocalBaseRateAmount(localBaseRateAmount);
        return this;
    }

    public void setLocalBaseRateAmount(Integer localBaseRateAmount) {
        this.localBaseRateAmount = localBaseRateAmount;
    }

    public String getPhoneDisplayNameYn() {
        return this.phoneDisplayNameYn;
    }

    public ReservationName phoneDisplayNameYn(String phoneDisplayNameYn) {
        this.setPhoneDisplayNameYn(phoneDisplayNameYn);
        return this;
    }

    public void setPhoneDisplayNameYn(String phoneDisplayNameYn) {
        this.phoneDisplayNameYn = phoneDisplayNameYn;
    }

    public String getResortChargeNumber() {
        return this.resortChargeNumber;
    }

    public ReservationName resortChargeNumber(String resortChargeNumber) {
        this.setResortChargeNumber(resortChargeNumber);
        return this;
    }

    public void setResortChargeNumber(String resortChargeNumber) {
        this.resortChargeNumber = resortChargeNumber;
    }

    public String getMobileChkoutAllowed() {
        return this.mobileChkoutAllowed;
    }

    public ReservationName mobileChkoutAllowed(String mobileChkoutAllowed) {
        this.setMobileChkoutAllowed(mobileChkoutAllowed);
        return this;
    }

    public void setMobileChkoutAllowed(String mobileChkoutAllowed) {
        this.mobileChkoutAllowed = mobileChkoutAllowed;
    }

    public String getMobileViewFolioAllowed() {
        return this.mobileViewFolioAllowed;
    }

    public ReservationName mobileViewFolioAllowed(String mobileViewFolioAllowed) {
        this.setMobileViewFolioAllowed(mobileViewFolioAllowed);
        return this;
    }

    public void setMobileViewFolioAllowed(String mobileViewFolioAllowed) {
        this.mobileViewFolioAllowed = mobileViewFolioAllowed;
    }

    public String getHkExpectedServiceTime() {
        return this.hkExpectedServiceTime;
    }

    public ReservationName hkExpectedServiceTime(String hkExpectedServiceTime) {
        this.setHkExpectedServiceTime(hkExpectedServiceTime);
        return this;
    }

    public void setHkExpectedServiceTime(String hkExpectedServiceTime) {
        this.hkExpectedServiceTime = hkExpectedServiceTime;
    }

    public String getEligibleForUpgradeYn() {
        return this.eligibleForUpgradeYn;
    }

    public ReservationName eligibleForUpgradeYn(String eligibleForUpgradeYn) {
        this.setEligibleForUpgradeYn(eligibleForUpgradeYn);
        return this;
    }

    public void setEligibleForUpgradeYn(String eligibleForUpgradeYn) {
        this.eligibleForUpgradeYn = eligibleForUpgradeYn;
    }

    public LocalDate getBeginSystemDateTime() {
        return this.beginSystemDateTime;
    }

    public ReservationName beginSystemDateTime(LocalDate beginSystemDateTime) {
        this.setBeginSystemDateTime(beginSystemDateTime);
        return this;
    }

    public void setBeginSystemDateTime(LocalDate beginSystemDateTime) {
        this.beginSystemDateTime = beginSystemDateTime;
    }

    public String getMobileCheckinAllowedYn() {
        return this.mobileCheckinAllowedYn;
    }

    public ReservationName mobileCheckinAllowedYn(String mobileCheckinAllowedYn) {
        this.setMobileCheckinAllowedYn(mobileCheckinAllowedYn);
        return this;
    }

    public void setMobileCheckinAllowedYn(String mobileCheckinAllowedYn) {
        this.mobileCheckinAllowedYn = mobileCheckinAllowedYn;
    }

    public String getQuoteId() {
        return this.quoteId;
    }

    public ReservationName quoteId(String quoteId) {
        this.setQuoteId(quoteId);
        return this;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getManualCheckoutStatus() {
        return this.manualCheckoutStatus;
    }

    public ReservationName manualCheckoutStatus(String manualCheckoutStatus) {
        this.setManualCheckoutStatus(manualCheckoutStatus);
        return this;
    }

    public void setManualCheckoutStatus(String manualCheckoutStatus) {
        this.manualCheckoutStatus = manualCheckoutStatus;
    }

    public String getMobilePreferredCurrency() {
        return this.mobilePreferredCurrency;
    }

    public ReservationName mobilePreferredCurrency(String mobilePreferredCurrency) {
        this.setMobilePreferredCurrency(mobilePreferredCurrency);
        return this;
    }

    public void setMobilePreferredCurrency(String mobilePreferredCurrency) {
        this.mobilePreferredCurrency = mobilePreferredCurrency;
    }

    public LocalDate getMobileActionAlertIssued() {
        return this.mobileActionAlertIssued;
    }

    public ReservationName mobileActionAlertIssued(LocalDate mobileActionAlertIssued) {
        this.setMobileActionAlertIssued(mobileActionAlertIssued);
        return this;
    }

    public void setMobileActionAlertIssued(LocalDate mobileActionAlertIssued) {
        this.mobileActionAlertIssued = mobileActionAlertIssued;
    }

    public String getExternalEfolioYn() {
        return this.externalEfolioYn;
    }

    public ReservationName externalEfolioYn(String externalEfolioYn) {
        this.setExternalEfolioYn(externalEfolioYn);
        return this;
    }

    public void setExternalEfolioYn(String externalEfolioYn) {
        this.externalEfolioYn = externalEfolioYn;
    }

    public String getOptInBatchFolYn() {
        return this.optInBatchFolYn;
    }

    public ReservationName optInBatchFolYn(String optInBatchFolYn) {
        this.setOptInBatchFolYn(optInBatchFolYn);
        return this;
    }

    public void setOptInBatchFolYn(String optInBatchFolYn) {
        this.optInBatchFolYn = optInBatchFolYn;
    }

    public Integer getFolioAddrElementId() {
        return this.folioAddrElementId;
    }

    public ReservationName folioAddrElementId(Integer folioAddrElementId) {
        this.setFolioAddrElementId(folioAddrElementId);
        return this;
    }

    public void setFolioAddrElementId(Integer folioAddrElementId) {
        this.folioAddrElementId = folioAddrElementId;
    }

    public String getOperaEsignedRegCardYn() {
        return this.operaEsignedRegCardYn;
    }

    public ReservationName operaEsignedRegCardYn(String operaEsignedRegCardYn) {
        this.setOperaEsignedRegCardYn(operaEsignedRegCardYn);
        return this;
    }

    public void setOperaEsignedRegCardYn(String operaEsignedRegCardYn) {
        this.operaEsignedRegCardYn = operaEsignedRegCardYn;
    }

    public String getResvGuid() {
        return this.resvGuid;
    }

    public ReservationName resvGuid(String resvGuid) {
        this.setResvGuid(resvGuid);
        return this;
    }

    public void setResvGuid(String resvGuid) {
        this.resvGuid = resvGuid;
    }

    public String getAdvanceCheckedInYn() {
        return this.advanceCheckedInYn;
    }

    public ReservationName advanceCheckedInYn(String advanceCheckedInYn) {
        this.setAdvanceCheckedInYn(advanceCheckedInYn);
        return this;
    }

    public void setAdvanceCheckedInYn(String advanceCheckedInYn) {
        this.advanceCheckedInYn = advanceCheckedInYn;
    }

    public LocalDate getExpectedTimeOfReturn() {
        return this.expectedTimeOfReturn;
    }

    public ReservationName expectedTimeOfReturn(LocalDate expectedTimeOfReturn) {
        this.setExpectedTimeOfReturn(expectedTimeOfReturn);
        return this;
    }

    public void setExpectedTimeOfReturn(LocalDate expectedTimeOfReturn) {
        this.expectedTimeOfReturn = expectedTimeOfReturn;
    }

    public String getEtrComments() {
        return this.etrComments;
    }

    public ReservationName etrComments(String etrComments) {
        this.setEtrComments(etrComments);
        return this;
    }

    public void setEtrComments(String etrComments) {
        this.etrComments = etrComments;
    }

    public String getOptedForCommYn() {
        return this.optedForCommYn;
    }

    public ReservationName optedForCommYn(String optedForCommYn) {
        this.setOptedForCommYn(optedForCommYn);
        return this;
    }

    public void setOptedForCommYn(String optedForCommYn) {
        this.optedForCommYn = optedForCommYn;
    }

    public String getCreditLimitAutoPayAllowYn() {
        return this.creditLimitAutoPayAllowYn;
    }

    public ReservationName creditLimitAutoPayAllowYn(String creditLimitAutoPayAllowYn) {
        this.setCreditLimitAutoPayAllowYn(creditLimitAutoPayAllowYn);
        return this;
    }

    public void setCreditLimitAutoPayAllowYn(String creditLimitAutoPayAllowYn) {
        this.creditLimitAutoPayAllowYn = creditLimitAutoPayAllowYn;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReservationName)) {
            return false;
        }
        return getId() != null && getId().equals(((ReservationName) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReservationName{" +
            "id=" + getId() +
            ", resort='" + getResort() + "'" +
            ", resvNameId=" + getResvNameId() +
            ", nameId=" + getNameId() +
            ", nameUsageType='" + getNameUsageType() + "'" +
            ", contactNameId=" + getContactNameId() +
            ", insertDate='" + getInsertDate() + "'" +
            ", insertUser=" + getInsertUser() +
            ", updateUser=" + getUpdateUser() +
            ", updateDate='" + getUpdateDate() + "'" +
            ", resvStatus='" + getResvStatus() + "'" +
            ", commissionCode='" + getCommissionCode() + "'" +
            ", addressId=" + getAddressId() +
            ", phoneId=" + getPhoneId() +
            ", faxYn='" + getFaxYn() + "'" +
            ", mailYn='" + getMailYn() + "'" +
            ", printRateYn='" + getPrintRateYn() + "'" +
            ", reportId='" + getReportId() + "'" +
            ", resvNo=" + getResvNo() +
            ", confirmationNo='" + getConfirmationNo() + "'" +
            ", beginDate='" + getBeginDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", faxId=" + getFaxId() +
            ", emailId=" + getEmailId() +
            ", emailYn='" + getEmailYn() + "'" +
            ", consumerYn='" + getConsumerYn() + "'" +
            ", creditCardId=" + getCreditCardId() +
            ", financiallyResponsibleYn='" + getFinanciallyResponsibleYn() + "'" +
            ", paymentMethod='" + getPaymentMethod() + "'" +
            ", intermediaryYn='" + getIntermediaryYn() + "'" +
            ", postingAllowedYn='" + getPostingAllowedYn() + "'" +
            ", displayColor='" + getDisplayColor() + "'" +
            ", actualCheckInDate='" + getActualCheckInDate() + "'" +
            ", truncActualCheckInDate='" + getTruncActualCheckInDate() + "'" +
            ", actualCheckOutDate='" + getActualCheckOutDate() + "'" +
            ", truncActualCheckOutDate='" + getTruncActualCheckOutDate() + "'" +
            ", creditLimit=" + getCreditLimit() +
            ", authorizedBy=" + getAuthorizedBy() +
            ", parentResvNameId=" + getParentResvNameId() +
            ", cancellationNo='" + getCancellationNo() + "'" +
            ", cancellationReasonCode='" + getCancellationReasonCode() + "'" +
            ", cancellationReasonDesc='" + getCancellationReasonDesc() + "'" +
            ", arrivalTransportType='" + getArrivalTransportType() + "'" +
            ", arrivalStationCode='" + getArrivalStationCode() + "'" +
            ", arrivalCarrierCode='" + getArrivalCarrierCode() + "'" +
            ", arrivalTransportCode='" + getArrivalTransportCode() + "'" +
            ", arrivalDateTime='" + getArrivalDateTime() + "'" +
            ", arrivalEstimateTime='" + getArrivalEstimateTime() + "'" +
            ", arrivalTranportationYn='" + getArrivalTranportationYn() + "'" +
            ", arrivalComments='" + getArrivalComments() + "'" +
            ", departureTransportType='" + getDepartureTransportType() + "'" +
            ", departureStationCode='" + getDepartureStationCode() + "'" +
            ", departureCarrierCode='" + getDepartureCarrierCode() + "'" +
            ", departureTransportCode='" + getDepartureTransportCode() + "'" +
            ", departureDateTime='" + getDepartureDateTime() + "'" +
            ", departureEstimateTime='" + getDepartureEstimateTime() + "'" +
            ", departureTransportationYn='" + getDepartureTransportationYn() + "'" +
            ", departureComments='" + getDepartureComments() + "'" +
            ", cancellationDate='" + getCancellationDate() + "'" +
            ", guaranteeCode='" + getGuaranteeCode() + "'" +
            ", wlReasonDescription='" + getWlReasonDescription() + "'" +
            ", wlReasonCode='" + getWlReasonCode() + "'" +
            ", wlPriority='" + getWlPriority() + "'" +
            ", doNotMoveRoom='" + getDoNotMoveRoom() + "'" +
            ", externalReference='" + getExternalReference() + "'" +
            ", partyCode='" + getPartyCode() + "'" +
            ", walkinYn='" + getWalkinYn() + "'" +
            ", originalEndDate='" + getOriginalEndDate() + "'" +
            ", approvalAmountCalcMethod=" + getApprovalAmountCalcMethod() +
            ", amountPercent=" + getAmountPercent() +
            ", nameTaxType='" + getNameTaxType() + "'" +
            ", taxExemptNo='" + getTaxExemptNo() + "'" +
            ", roomFeatures='" + getRoomFeatures() + "'" +
            ", wlTelephoneNo='" + getWlTelephoneNo() + "'" +
            ", videoCheckoutYn='" + getVideoCheckoutYn() + "'" +
            ", discountAmt=" + getDiscountAmt() +
            ", discountPrcnt=" + getDiscountPrcnt() +
            ", discountReasonCode='" + getDiscountReasonCode() + "'" +
            ", commissionPaid=" + getCommissionPaid() +
            ", commissionHoldCode='" + getCommissionHoldCode() + "'" +
            ", truncBeginDate='" + getTruncBeginDate() + "'" +
            ", truncEndDate='" + getTruncEndDate() + "'" +
            ", sguestName='" + getSguestName() + "'" +
            ", membershipId=" + getMembershipId() +
            ", udfc01='" + getUdfc01() + "'" +
            ", udfc02='" + getUdfc02() + "'" +
            ", udfc03='" + getUdfc03() + "'" +
            ", udfc04='" + getUdfc04() + "'" +
            ", udfc05='" + getUdfc05() + "'" +
            ", udfc06='" + getUdfc06() + "'" +
            ", udfc07='" + getUdfc07() + "'" +
            ", udfc08='" + getUdfc08() + "'" +
            ", udfc09='" + getUdfc09() + "'" +
            ", udfc10='" + getUdfc10() + "'" +
            ", udfc11='" + getUdfc11() + "'" +
            ", udfc12='" + getUdfc12() + "'" +
            ", udfc13='" + getUdfc13() + "'" +
            ", udfc14='" + getUdfc14() + "'" +
            ", udfc15='" + getUdfc15() + "'" +
            ", udfc16='" + getUdfc16() + "'" +
            ", udfc17='" + getUdfc17() + "'" +
            ", udfc18='" + getUdfc18() + "'" +
            ", udfc19='" + getUdfc19() + "'" +
            ", udfc20='" + getUdfc20() + "'" +
            ", udfc21='" + getUdfc21() + "'" +
            ", udfc22='" + getUdfc22() + "'" +
            ", udfc23='" + getUdfc23() + "'" +
            ", udfc24='" + getUdfc24() + "'" +
            ", udfc25='" + getUdfc25() + "'" +
            ", udfc26='" + getUdfc26() + "'" +
            ", udfc27='" + getUdfc27() + "'" +
            ", udfc28='" + getUdfc28() + "'" +
            ", udfc29='" + getUdfc29() + "'" +
            ", udfc30='" + getUdfc30() + "'" +
            ", udfc31='" + getUdfc31() + "'" +
            ", udfc32='" + getUdfc32() + "'" +
            ", udfc33='" + getUdfc33() + "'" +
            ", udfc34='" + getUdfc34() + "'" +
            ", udfc35='" + getUdfc35() + "'" +
            ", udfc36='" + getUdfc36() + "'" +
            ", udfc37='" + getUdfc37() + "'" +
            ", udfc38='" + getUdfc38() + "'" +
            ", udfc39='" + getUdfc39() + "'" +
            ", udfc40='" + getUdfc40() + "'" +
            ", udfn01=" + getUdfn01() +
            ", udfn02=" + getUdfn02() +
            ", udfn03=" + getUdfn03() +
            ", udfn04=" + getUdfn04() +
            ", udfn05=" + getUdfn05() +
            ", udfn06=" + getUdfn06() +
            ", udfn07=" + getUdfn07() +
            ", udfn08=" + getUdfn08() +
            ", udfn09=" + getUdfn09() +
            ", udfn10=" + getUdfn10() +
            ", udfn11=" + getUdfn11() +
            ", udfn12=" + getUdfn12() +
            ", udfn13=" + getUdfn13() +
            ", udfn14=" + getUdfn14() +
            ", udfn15=" + getUdfn15() +
            ", udfn16=" + getUdfn16() +
            ", udfn17=" + getUdfn17() +
            ", udfn18=" + getUdfn18() +
            ", udfn19=" + getUdfn19() +
            ", udfn20=" + getUdfn20() +
            ", udfn21=" + getUdfn21() +
            ", udfn22=" + getUdfn22() +
            ", udfn23=" + getUdfn23() +
            ", udfn24=" + getUdfn24() +
            ", udfn25=" + getUdfn25() +
            ", udfn26=" + getUdfn26() +
            ", udfn27=" + getUdfn27() +
            ", udfn28=" + getUdfn28() +
            ", udfn29=" + getUdfn29() +
            ", udfn30=" + getUdfn30() +
            ", udfn31=" + getUdfn31() +
            ", udfn32=" + getUdfn32() +
            ", udfn33=" + getUdfn33() +
            ", udfn34=" + getUdfn34() +
            ", udfn35=" + getUdfn35() +
            ", udfn36=" + getUdfn36() +
            ", udfn37=" + getUdfn37() +
            ", udfn38=" + getUdfn38() +
            ", udfn39=" + getUdfn39() +
            ", udfn40=" + getUdfn40() +
            ", udfd01='" + getUdfd01() + "'" +
            ", udfd02='" + getUdfd02() + "'" +
            ", udfd03='" + getUdfd03() + "'" +
            ", udfd04='" + getUdfd04() + "'" +
            ", udfd05='" + getUdfd05() + "'" +
            ", udfd06='" + getUdfd06() + "'" +
            ", udfd07='" + getUdfd07() + "'" +
            ", udfd08='" + getUdfd08() + "'" +
            ", udfd09='" + getUdfd09() + "'" +
            ", udfd10='" + getUdfd10() + "'" +
            ", insertActionInstanceId=" + getInsertActionInstanceId() +
            ", dmlSeqNo=" + getDmlSeqNo() +
            ", businessDateCreated='" + getBusinessDateCreated() + "'" +
            ", turndownYn='" + getTurndownYn() + "'" +
            ", roomInstructions='" + getRoomInstructions() + "'" +
            ", roomServiceTime='" + getRoomServiceTime() + "'" +
            ", eventId=" + getEventId() +
            ", revenueTypeCode='" + getRevenueTypeCode() + "'" +
            ", hurdle=" + getHurdle() +
            ", hurdleOverride='" + getHurdleOverride() + "'" +
            ", rateableValue=" + getRateableValue() +
            ", restrictionOverride='" + getRestrictionOverride() + "'" +
            ", yieldableYn='" + getYieldableYn() + "'" +
            ", sguestFirstname='" + getSguestFirstname() + "'" +
            ", guestLastName='" + getGuestLastName() + "'" +
            ", guestFirstName='" + getGuestFirstName() + "'" +
            ", guestLastNameSdx='" + getGuestLastNameSdx() + "'" +
            ", guestFirstNameSdx='" + getGuestFirstNameSdx() + "'" +
            ", channel='" + getChannel() + "'" +
            ", shareSeqNo=" + getShareSeqNo() +
            ", guestSignature='" + getGuestSignature() + "'" +
            ", extensionId=" + getExtensionId() +
            ", resvContactId=" + getResvContactId() +
            ", billingContactId=" + getBillingContactId() +
            ", resInsertSource='" + getResInsertSource() + "'" +
            ", resInsertSourceType='" + getResInsertSourceType() + "'" +
            ", masterShare='" + getMasterShare() + "'" +
            ", registrationCardNo='" + getRegistrationCardNo() + "'" +
            ", tiad='" + getTiad() + "'" +
            ", purposeOfStay='" + getPurposeOfStay() + "'" +
            ", reinstateDate='" + getReinstateDate() + "'" +
            ", purgeDate='" + getPurgeDate() + "'" +
            ", lastSettleDate='" + getLastSettleDate() + "'" +
            ", lastPeriodicFolioDate='" + getLastPeriodicFolioDate() + "'" +
            ", periodicFolioFreq=" + getPeriodicFolioFreq() +
            ", confirmationLegNo=" + getConfirmationLegNo() +
            ", guestStatus='" + getGuestStatus() + "'" +
            ", guestType='" + getGuestType() + "'" +
            ", checkinDuration=" + getCheckinDuration() +
            ", authorizerId=" + getAuthorizerId() +
            ", lastOnlinePrintSeq=" + getLastOnlinePrintSeq() +
            ", entryPoint='" + getEntryPoint() + "'" +
            ", entryDate='" + getEntryDate() + "'" +
            ", pseudoMemType='" + getPseudoMemType() + "'" +
            ", pseudoMemTotalPoints=" + getPseudoMemTotalPoints() +
            ", folioText1='" + getFolioText1() + "'" +
            ", folioText2='" + getFolioText2() + "'" +
            ", compTypeCode='" + getCompTypeCode() + "'" +
            ", uniCardId='" + getUniCardId() + "'" +
            ", expCheckinresId=" + getExpCheckinresId() +
            ", originalBeginDate='" + getOriginalBeginDate() + "'" +
            ", ownerFfFlag='" + getOwnerFfFlag() + "'" +
            ", commissionPayoutTo='" + getCommissionPayoutTo() + "'" +
            ", preChargingYn='" + getPreChargingYn() + "'" +
            ", postChargingYn='" + getPostChargingYn() + "'" +
            ", postCoFlag='" + getPostCoFlag() + "'" +
            ", folioCloseDate='" + getFolioCloseDate() + "'" +
            ", scheduleCheckoutYn='" + getScheduleCheckoutYn() + "'" +
            ", customReference='" + getCustomReference() + "'" +
            ", guaranteeCodePreCi='" + getGuaranteeCodePreCi() + "'" +
            ", awardMembershipId=" + getAwardMembershipId() +
            ", esignedRegCardName='" + getEsignedRegCardName() + "'" +
            ", statisticalRoomType=" + getStatisticalRoomType() +
            ", statisticalRateTier=" + getStatisticalRateTier() +
            ", ymCode='" + getYmCode() + "'" +
            ", keyValidUntil='" + getKeyValidUntil() + "'" +
            ", preRegisteredYn='" + getPreRegisteredYn() + "'" +
            ", taxRegistrationNo=" + getTaxRegistrationNo() +
            ", visaNumber='" + getVisaNumber() + "'" +
            ", visaIssueDate='" + getVisaIssueDate() + "'" +
            ", visaExpirationDate='" + getVisaExpirationDate() + "'" +
            ", taxNoOfStays=" + getTaxNoOfStays() +
            ", asbProratedYn='" + getAsbProratedYn() + "'" +
            ", autoSettleDays=" + getAutoSettleDays() +
            ", autoSettleYn='" + getAutoSettleYn() + "'" +
            ", splitFromResvNameId=" + getSplitFromResvNameId() +
            ", nextDestination='" + getNextDestination() + "'" +
            ", dateOfArrivalInCountry='" + getDateOfArrivalInCountry() + "'" +
            ", preArrReviewedDt='" + getPreArrReviewedDt() + "'" +
            ", preArrReviewedUser=" + getPreArrReviewedUser() +
            ", bonusCheckId=" + getBonusCheckId() +
            ", mobileAudioKeyYn='" + getMobileAudioKeyYn() + "'" +
            ", directBillVerifyResponse='" + getDirectBillVerifyResponse() + "'" +
            ", addresseeNameId=" + getAddresseeNameId() +
            ", superSearchIndexText='" + getSuperSearchIndexText() + "'" +
            ", autoCheckinYn='" + getAutoCheckinYn() + "'" +
            ", emailFolioYn='" + getEmailFolioYn() + "'" +
            ", emailAddress='" + getEmailAddress() + "'" +
            ", spgUpgradeConfirmedRoomtype='" + getSpgUpgradeConfirmedRoomtype() + "'" +
            ", spgUpgradeReasonCode='" + getSpgUpgradeReasonCode() + "'" +
            ", spgSuiteNightAwardStatus='" + getSpgSuiteNightAwardStatus() + "'" +
            ", spgDiscloseRoomTypeYn='" + getSpgDiscloseRoomTypeYn() + "'" +
            ", amenityEligibleYn='" + getAmenityEligibleYn() + "'" +
            ", amenityLevelCode='" + getAmenityLevelCode() + "'" +
            ", baseRateCurrencyCode='" + getBaseRateCurrencyCode() + "'" +
            ", baseRateCode='" + getBaseRateCode() + "'" +
            ", localBaseRateAmount=" + getLocalBaseRateAmount() +
            ", phoneDisplayNameYn='" + getPhoneDisplayNameYn() + "'" +
            ", resortChargeNumber='" + getResortChargeNumber() + "'" +
            ", mobileChkoutAllowed='" + getMobileChkoutAllowed() + "'" +
            ", mobileViewFolioAllowed='" + getMobileViewFolioAllowed() + "'" +
            ", hkExpectedServiceTime='" + getHkExpectedServiceTime() + "'" +
            ", eligibleForUpgradeYn='" + getEligibleForUpgradeYn() + "'" +
            ", beginSystemDateTime='" + getBeginSystemDateTime() + "'" +
            ", mobileCheckinAllowedYn='" + getMobileCheckinAllowedYn() + "'" +
            ", quoteId='" + getQuoteId() + "'" +
            ", manualCheckoutStatus='" + getManualCheckoutStatus() + "'" +
            ", mobilePreferredCurrency='" + getMobilePreferredCurrency() + "'" +
            ", mobileActionAlertIssued='" + getMobileActionAlertIssued() + "'" +
            ", externalEfolioYn='" + getExternalEfolioYn() + "'" +
            ", optInBatchFolYn='" + getOptInBatchFolYn() + "'" +
            ", folioAddrElementId=" + getFolioAddrElementId() +
            ", operaEsignedRegCardYn='" + getOperaEsignedRegCardYn() + "'" +
            ", resvGuid='" + getResvGuid() + "'" +
            ", advanceCheckedInYn='" + getAdvanceCheckedInYn() + "'" +
            ", expectedTimeOfReturn='" + getExpectedTimeOfReturn() + "'" +
            ", etrComments='" + getEtrComments() + "'" +
            ", optedForCommYn='" + getOptedForCommYn() + "'" +
            ", creditLimitAutoPayAllowYn='" + getCreditLimitAutoPayAllowYn() + "'" +
            "}";
    }
}
