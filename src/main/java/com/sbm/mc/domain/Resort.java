package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Resort.
 */
@Entity
@Table(name = "resort")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Resort implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;

    @Column(name = "resort")
    private String resort;

    @Column(name = "begin_date")
    private ZonedDateTime beginDate;

    @Column(name = "check_in_time")
    private ZonedDateTime checkInTime;

    @Column(name = "check_out_time")
    private ZonedDateTime checkOutTime;

    @Column(name = "video_co_start")
    private ZonedDateTime videoCoStart;

    @Column(name = "video_co_stop")
    private ZonedDateTime videoCoStop;

    @Column(name = "insert_date")
    private ZonedDateTime insertDate;

    @Column(name = "update_date")
    private ZonedDateTime updateDate;

    @Column(name = "expiry_date")
    private ZonedDateTime expiryDate;

    @Column(name = "end_date")
    private ZonedDateTime endDate;

    @Column(name = "fiscal_start_date")
    private ZonedDateTime fiscalStartDate;

    @Column(name = "fiscal_end_date")
    private ZonedDateTime fiscalEndDate;

    @Column(name = "reconcile_date")
    private ZonedDateTime reconcileDate;

    @Column(name = "payment_date")
    private ZonedDateTime paymentDate;

    @Column(name = "keep_availability")
    private Integer keepAvailability;

    @Column(name = "budget_month")
    private Integer budgetMonth;

    @Column(name = "save_profiles")
    private Integer saveProfiles;

    @Column(name = "long_stay_control")
    private Integer longStayControl;

    @Column(name = "credit_limit")
    private Integer creditLimit;

    @Column(name = "number_rooms")
    private Integer numberRooms;

    @Column(name = "number_floors")
    private Integer numberFloors;

    @Column(name = "number_beds")
    private Integer numberBeds;

    @Column(name = "rhythm_sheets")
    private Integer rhythmSheets;

    @Column(name = "rhythm_towels")
    private Integer rhythmTowels;

    @Column(name = "warning_amount")
    private Integer warningAmount;

    @Column(name = "decimal_places")
    private Integer decimalPlaces;

    @Column(name = "font")
    private Integer font;

    @Column(name = "copies")
    private Integer copies;

    @Column(name = "default_folio_style")
    private Integer defaultFolioStyle;

    @Column(name = "individual_room_warning")
    private Integer individualRoomWarning;

    @Column(name = "group_room_warning")
    private Integer groupRoomWarning;

    @Column(name = "aging_level_1")
    private Integer agingLevel1;

    @Column(name = "aging_level_2")
    private Integer agingLevel2;

    @Column(name = "aging_level_3")
    private Integer agingLevel3;

    @Column(name = "aging_level_4")
    private Integer agingLevel4;

    @Column(name = "aging_level_5")
    private Integer agingLevel5;

    @Column(name = "zero_inv_pur_days")
    private Integer zeroInvPurDays;

    @Column(name = "min_days_bet_2_reminder_letter")
    private Integer minDaysBet2ReminderLetter;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "currency_decimals")
    private Integer currencyDecimals;

    @Column(name = "name_id_link")
    private Integer nameIdLink;

    @Column(name = "sgl_rate_1")
    private Integer sglRate1;

    @Column(name = "sgl_rate_2")
    private Integer sglRate2;

    @Column(name = "dbl_rate_1")
    private Integer dblRate1;

    @Column(name = "dbl_rate_2")
    private Integer dblRate2;

    @Column(name = "tpl_rate_1")
    private Integer tplRate1;

    @Column(name = "tpl_rate_2")
    private Integer tplRate2;

    @Column(name = "sui_rate_1")
    private Integer suiRate1;

    @Column(name = "sui_rate_2")
    private Integer suiRate2;

    @Column(name = "meet_space")
    private Integer meetSpace;

    @Column(name = "img_hotel_id")
    private Integer imgHotelId;

    @Column(name = "img_direction_id")
    private Integer imgDirectionId;

    @Column(name = "img_map_id")
    private Integer imgMapId;

    @Column(name = "script_id")
    private Integer scriptId;

    @Column(name = "com_name_xref_id")
    private Integer comNameXrefId;

    @Column(name = "path_id")
    private Integer pathId;

    @Column(name = "xresort_number")
    private Integer xresortNumber;

    @Column(name = "max_credit_days")
    private Integer maxCreditDays;

    @Column(name = "currency_divisor")
    private Integer currencyDivisor;

    @Column(name = "latitude")
    private Integer latitude;

    @Column(name = "longitude")
    private Integer longitude;

    @Column(name = "qty_single_rooms")
    private Integer qtySingleRooms;

    @Column(name = "qty_double_rooms")
    private Integer qtyDoubleRooms;

    @Column(name = "qty_twin_rooms")
    private Integer qtyTwinRooms;

    @Column(name = "qty_suites")
    private Integer qtySuites;

    @Column(name = "qty_guest_room_floors")
    private Integer qtyGuestRoomFloors;

    @Column(name = "qty_guest_elevators")
    private Integer qtyGuestElevators;

    @Column(name = "qty_non_smoking_rooms")
    private Integer qtyNonSmokingRooms;

    @Column(name = "qty_connecting_rooms")
    private Integer qtyConnectingRooms;

    @Column(name = "qty_handicapped_rooms")
    private Integer qtyHandicappedRooms;

    @Column(name = "qty_family_rooms")
    private Integer qtyFamilyRooms;

    @Column(name = "max_adults_family_room")
    private Integer maxAdultsFamilyRoom;

    @Column(name = "max_children_family_room")
    private Integer maxChildrenFamilyRoom;

    @Column(name = "restaurant")
    private Integer restaurant;

    @Column(name = "meet_rooms")
    private Integer meetRooms;

    @Column(name = "tot_rooms")
    private Integer totRooms;

    @Column(name = "br_seats")
    private Integer brSeats;

    @Column(name = "meet_seats")
    private Integer meetSeats;

    @Column(name = "max_no_nights")
    private Integer maxNoNights;

    @Column(name = "awards_timeout")
    private Integer awardsTimeout;

    @Column(name = "guest_lookup_timeout")
    private Integer guestLookupTimeout;

    @Column(name = "wake_up_delay")
    private Integer wakeUpDelay;

    @Column(name = "max_occupancy")
    private Integer maxOccupancy;

    @Column(name = "inactive_days_for_guest_profil")
    private Integer inactiveDaysForGuestProfil;

    @Column(name = "per_reservation_room_limit")
    private Integer perReservationRoomLimit;

    @Column(name = "lic_room_info")
    private String licRoomInfo;

    @Column(name = "thousand_separator")
    private String thousandSeparator;

    @Column(name = "date_separator")
    private String dateSeparator;

    @Column(name = "ar_acct_no_mand_yn")
    private String arAcctNoMandYn;

    @Column(name = "exchange_posting_type")
    private String exchangePostingType;

    @Column(name = "inventory_yn")
    private String inventoryYn;

    @Column(name = "allow_login_yn")
    private String allowLoginYn;

    @Column(name = "access_code")
    private String accessCode;

    @Column(name = "disable_login_yn")
    private String disableLoginYn;

    @Column(name = "int_tax_included_yn")
    private String intTaxIncludedYn;

    @Column(name = "download_rest_yn")
    private String downloadRestYn;

    @Column(name = "translate_multichar_yn")
    private String translateMulticharYn;

    @Column(name = "external_sc_yn")
    private String externalScYn;

    @Column(name = "send_lead_as_booking_yn")
    private String sendLeadAsBookingYn;

    @Column(name = "mbs_supported_yn")
    private String mbsSupportedYn;

    @Column(name = "quoted_currency")
    private String quotedCurrency;

    @Column(name = "com_method")
    private String comMethod;

    @Column(name = "email")
    private String email;

    @Column(name = "genmgr")
    private String genmgr;

    @Column(name = "dirsales")
    private String dirsales;

    @Column(name = "leadsend")
    private String leadsend;

    @Column(name = "airport")
    private String airport;

    @Column(name = "com_address")
    private String comAddress;

    @Column(name = "season_1")
    private String season1;

    @Column(name = "season_2")
    private String season2;

    @Column(name = "season_3")
    private String season3;

    @Column(name = "season_4")
    private String season4;

    @Column(name = "season_5")
    private String season5;

    @Column(name = "floor_num_executive_floor")
    private String floorNumExecutiveFloor;

    @Column(name = "crs_resort")
    private String crsResort;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "default_reservation_type")
    private String defaultReservationType;

    @Column(name = "jhi_block")
    private String block;

    @Column(name = "currency_symbol")
    private String currencySymbol;

    @Column(name = "source_commission")
    private String sourceCommission;

    @Column(name = "ta_commission")
    private String taCommission;

    @Column(name = "base_language")
    private String baseLanguage;

    @Column(name = "folio_language_1")
    private String folioLanguage1;

    @Column(name = "folio_language_2")
    private String folioLanguage2;

    @Column(name = "folio_language_3")
    private String folioLanguage3;

    @Column(name = "folio_language_4")
    private String folioLanguage4;

    @Column(name = "package_profit")
    private String packageProfit;

    @Column(name = "package_loss")
    private String packageLoss;

    @Column(name = "decimal_separator")
    private String decimalSeparator;

    @Column(name = "short_date_format")
    private String shortDateFormat;

    @Column(name = "long_date_format")
    private String longDateFormat;

    @Column(name = "passerby_source")
    private String passerbySource;

    @Column(name = "passerby_market")
    private String passerbyMarket;

    @Column(name = "ar_company")
    private String arCompany;

    @Column(name = "ar_agent")
    private String arAgent;

    @Column(name = "ar_groups")
    private String arGroups;

    @Column(name = "ar_individuals")
    private String arIndividuals;

    @Column(name = "ar_acct_no_format")
    private String arAcctNoFormat;

    @Column(name = "allowance_period_adj")
    private String allowancePeriodAdj;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "turnaway_code")
    private String turnawayCode;

    @Column(name = "summ_currency_code")
    private String summCurrencyCode;

    @Column(name = "default_property_address")
    private String defaultPropertyAddress;

    @Column(name = "default_guest_address")
    private String defaultGuestAddress;

    @Column(name = "license_code")
    private String licenseCode;

    @Column(name = "time_format")
    private String timeFormat;

    @Column(name = "chain_code")
    private String chainCode;

    @Column(name = "resort_type")
    private String resortType;

    @Column(name = "hotel_type")
    private String hotelType;

    @Column(name = "ownership")
    private String ownership;

    @Column(name = "ar_bal_trx_code")
    private String arBalTrxCode;

    @Column(name = "ar_credit_trx_code")
    private String arCreditTrxCode;

    @Column(name = "ar_settle_code")
    private String arSettleCode;

    @Column(name = "cash_shift_drop")
    private String cashShiftDrop;

    @Column(name = "check_exg_paidout")
    private String checkExgPaidout;

    @Column(name = "check_shift_drop")
    private String checkShiftDrop;

    @Column(name = "check_trxcode")
    private String checkTrxcode;

    @Column(name = "currency_exg_paidout")
    private String currencyExgPaidout;

    @Column(name = "deposit_led_trx_code")
    private String depositLedTrxCode;

    @Column(name = "fiscal_period_type")
    private String fiscalPeriodType;

    @Column(name = "default_commission_percentage")
    private String defaultCommissionPercentage;

    @Column(name = "default_prepaid_comm")
    private String defaultPrepaidComm;

    @Column(name = "default_trx_comm_code")
    private String defaultTrxCommCode;

    @Column(name = "configuration_mode")
    private String configurationMode;

    @Column(name = "weekend_days")
    private String weekendDays;

    @Column(name = "default_groups_rate_code")
    private String defaultGroupsRateCode;

    @Column(name = "default_posting_room")
    private String defaultPostingRoom;

    @Column(name = "dflt_pkg_tran_code")
    private String dfltPkgTranCode;

    @Column(name = "dflt_tran_code_rate_code")
    private String dfltTranCodeRateCode;

    @Column(name = "default_rate_code")
    private String defaultRateCode;

    @Column(name = "cro_code")
    private String croCode;

    @Column(name = "flow_code")
    private String flowCode;

    @Column(name = "ext_property_code")
    private String extPropertyCode;

    @Column(name = "opus_currency_code")
    private String opusCurrencyCode;

    @Column(name = "destination_id")
    private String destinationId;

    @Column(name = "flags")
    private String flags;

    @Column(name = "tourist_number")
    private String touristNumber;

    @Column(name = "catering_currency_code")
    private String cateringCurrencyCode;

    @Column(name = "default_ratecode_rack")
    private String defaultRatecodeRack;

    @Column(name = "default_ratecode_pcr")
    private String defaultRatecodePcr;

    @Column(name = "fns_tier")
    private String fnsTier;

    @Column(name = "brand_code")
    private String brandCode;

    @Column(name = "webaddress")
    private String webaddress;

    @Column(name = "vat_id")
    private String vatId;

    @Column(name = "street")
    private String street;

    @Column(name = "hotel_fc")
    private String hotelFc;

    @Column(name = "meeting_fc")
    private String meetingFc;

    @Column(name = "ar_typewriter")
    private String arTypewriter;

    @Column(name = "file_transfer_format")
    private String fileTransferFormat;

    @Column(name = "confirm_regcard_printer")
    private String confirmRegcardPrinter;

    @Column(name = "directions")
    private String directions;

    @Column(name = "propinfo_url")
    private String propinfoUrl;

    @Column(name = "room_amenity")
    private String roomAmenity;

    @Column(name = "shop_description")
    private String shopDescription;

    @Column(name = "prop_pic_url")
    private String propPicUrl;

    @Column(name = "prop_map_url")
    private String propMapUrl;

    @Column(name = "ext_exp_file_location")
    private String extExpFileLocation;

    @Column(name = "curtain_color")
    private String curtainColor;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "state")
    private String state;

    @Column(name = "date_for_aging")
    private String dateForAging;

    @Column(name = "region_code")
    private String regionCode;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "tollfree")
    private String tollfree;

    @Column(name = "default_printer")
    private String defaultPrinter;

    @Column(name = "videocheckout_printer")
    private String videocheckoutPrinter;

    @Column(name = "company_address_type")
    private String companyAddressType;

    @Column(name = "company_phone_type")
    private String companyPhoneType;

    @Column(name = "default_fax_type")
    private String defaultFaxType;

    @Column(name = "default_membership_type")
    private String defaultMembershipType;

    @Column(name = "individual_address_type")
    private String individualAddressType;

    @Column(name = "individual_phone_type")
    private String individualPhoneType;

    @Column(name = "notes")
    private String notes;

    @Column(name = "blackout_period_notes")
    private String blackoutPeriodNotes;

    @Column(name = "sgl_num")
    private String sglNum;

    @Column(name = "dbl_num")
    private String dblNum;

    @Column(name = "tpl_num")
    private String tplNum;

    @Column(name = "sui_num")
    private String suiNum;

    @Column(name = "airport_distance")
    private String airportDistance;

    @Column(name = "airport_time")
    private String airportTime;

    @Column(name = "br_area")
    private String brArea;

    @Column(name = "name")
    private String name;

    @Column(name = "legal_owner")
    private String legalOwner;

    @Column(name = "hotel_id")
    private String hotelId;

    @Column(name = "fax_no_format")
    private String faxNoFormat;

    @Column(name = "telephone_no_format")
    private String telephoneNoFormat;

    @Column(name = "local_currency_format")
    private String localCurrencyFormat;

    @Column(name = "duty_manager_pager")
    private String dutyManagerPager;

    @Column(name = "default_registration_card")
    private String defaultRegistrationCard;

    @Column(name = "night_audit_cashier_id")
    private String nightAuditCashierId;

    @Column(name = "hotel_code")
    private String hotelCode;

    @Column(name = "path")
    private String path;

    @Column(name = "timezone_region")
    private String timezoneRegion;

    @Column(name = "catering_currency_format")
    private String cateringCurrencyFormat;

    @Column(name = "exp_hotel_code")
    private String expHotelCode;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Resort id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResort() {
        return this.resort;
    }

    public Resort resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public ZonedDateTime getBeginDate() {
        return this.beginDate;
    }

    public Resort beginDate(ZonedDateTime beginDate) {
        this.setBeginDate(beginDate);
        return this;
    }

    public void setBeginDate(ZonedDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public ZonedDateTime getCheckInTime() {
        return this.checkInTime;
    }

    public Resort checkInTime(ZonedDateTime checkInTime) {
        this.setCheckInTime(checkInTime);
        return this;
    }

    public void setCheckInTime(ZonedDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public ZonedDateTime getCheckOutTime() {
        return this.checkOutTime;
    }

    public Resort checkOutTime(ZonedDateTime checkOutTime) {
        this.setCheckOutTime(checkOutTime);
        return this;
    }

    public void setCheckOutTime(ZonedDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public ZonedDateTime getVideoCoStart() {
        return this.videoCoStart;
    }

    public Resort videoCoStart(ZonedDateTime videoCoStart) {
        this.setVideoCoStart(videoCoStart);
        return this;
    }

    public void setVideoCoStart(ZonedDateTime videoCoStart) {
        this.videoCoStart = videoCoStart;
    }

    public ZonedDateTime getVideoCoStop() {
        return this.videoCoStop;
    }

    public Resort videoCoStop(ZonedDateTime videoCoStop) {
        this.setVideoCoStop(videoCoStop);
        return this;
    }

    public void setVideoCoStop(ZonedDateTime videoCoStop) {
        this.videoCoStop = videoCoStop;
    }

    public ZonedDateTime getInsertDate() {
        return this.insertDate;
    }

    public Resort insertDate(ZonedDateTime insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(ZonedDateTime insertDate) {
        this.insertDate = insertDate;
    }

    public ZonedDateTime getUpdateDate() {
        return this.updateDate;
    }

    public Resort updateDate(ZonedDateTime updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(ZonedDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public ZonedDateTime getExpiryDate() {
        return this.expiryDate;
    }

    public Resort expiryDate(ZonedDateTime expiryDate) {
        this.setExpiryDate(expiryDate);
        return this;
    }

    public void setExpiryDate(ZonedDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ZonedDateTime getEndDate() {
        return this.endDate;
    }

    public Resort endDate(ZonedDateTime endDate) {
        this.setEndDate(endDate);
        return this;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public ZonedDateTime getFiscalStartDate() {
        return this.fiscalStartDate;
    }

    public Resort fiscalStartDate(ZonedDateTime fiscalStartDate) {
        this.setFiscalStartDate(fiscalStartDate);
        return this;
    }

    public void setFiscalStartDate(ZonedDateTime fiscalStartDate) {
        this.fiscalStartDate = fiscalStartDate;
    }

    public ZonedDateTime getFiscalEndDate() {
        return this.fiscalEndDate;
    }

    public Resort fiscalEndDate(ZonedDateTime fiscalEndDate) {
        this.setFiscalEndDate(fiscalEndDate);
        return this;
    }

    public void setFiscalEndDate(ZonedDateTime fiscalEndDate) {
        this.fiscalEndDate = fiscalEndDate;
    }

    public ZonedDateTime getReconcileDate() {
        return this.reconcileDate;
    }

    public Resort reconcileDate(ZonedDateTime reconcileDate) {
        this.setReconcileDate(reconcileDate);
        return this;
    }

    public void setReconcileDate(ZonedDateTime reconcileDate) {
        this.reconcileDate = reconcileDate;
    }

    public ZonedDateTime getPaymentDate() {
        return this.paymentDate;
    }

    public Resort paymentDate(ZonedDateTime paymentDate) {
        this.setPaymentDate(paymentDate);
        return this;
    }

    public void setPaymentDate(ZonedDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getKeepAvailability() {
        return this.keepAvailability;
    }

    public Resort keepAvailability(Integer keepAvailability) {
        this.setKeepAvailability(keepAvailability);
        return this;
    }

    public void setKeepAvailability(Integer keepAvailability) {
        this.keepAvailability = keepAvailability;
    }

    public Integer getBudgetMonth() {
        return this.budgetMonth;
    }

    public Resort budgetMonth(Integer budgetMonth) {
        this.setBudgetMonth(budgetMonth);
        return this;
    }

    public void setBudgetMonth(Integer budgetMonth) {
        this.budgetMonth = budgetMonth;
    }

    public Integer getSaveProfiles() {
        return this.saveProfiles;
    }

    public Resort saveProfiles(Integer saveProfiles) {
        this.setSaveProfiles(saveProfiles);
        return this;
    }

    public void setSaveProfiles(Integer saveProfiles) {
        this.saveProfiles = saveProfiles;
    }

    public Integer getLongStayControl() {
        return this.longStayControl;
    }

    public Resort longStayControl(Integer longStayControl) {
        this.setLongStayControl(longStayControl);
        return this;
    }

    public void setLongStayControl(Integer longStayControl) {
        this.longStayControl = longStayControl;
    }

    public Integer getCreditLimit() {
        return this.creditLimit;
    }

    public Resort creditLimit(Integer creditLimit) {
        this.setCreditLimit(creditLimit);
        return this;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getNumberRooms() {
        return this.numberRooms;
    }

    public Resort numberRooms(Integer numberRooms) {
        this.setNumberRooms(numberRooms);
        return this;
    }

    public void setNumberRooms(Integer numberRooms) {
        this.numberRooms = numberRooms;
    }

    public Integer getNumberFloors() {
        return this.numberFloors;
    }

    public Resort numberFloors(Integer numberFloors) {
        this.setNumberFloors(numberFloors);
        return this;
    }

    public void setNumberFloors(Integer numberFloors) {
        this.numberFloors = numberFloors;
    }

    public Integer getNumberBeds() {
        return this.numberBeds;
    }

    public Resort numberBeds(Integer numberBeds) {
        this.setNumberBeds(numberBeds);
        return this;
    }

    public void setNumberBeds(Integer numberBeds) {
        this.numberBeds = numberBeds;
    }

    public Integer getRhythmSheets() {
        return this.rhythmSheets;
    }

    public Resort rhythmSheets(Integer rhythmSheets) {
        this.setRhythmSheets(rhythmSheets);
        return this;
    }

    public void setRhythmSheets(Integer rhythmSheets) {
        this.rhythmSheets = rhythmSheets;
    }

    public Integer getRhythmTowels() {
        return this.rhythmTowels;
    }

    public Resort rhythmTowels(Integer rhythmTowels) {
        this.setRhythmTowels(rhythmTowels);
        return this;
    }

    public void setRhythmTowels(Integer rhythmTowels) {
        this.rhythmTowels = rhythmTowels;
    }

    public Integer getWarningAmount() {
        return this.warningAmount;
    }

    public Resort warningAmount(Integer warningAmount) {
        this.setWarningAmount(warningAmount);
        return this;
    }

    public void setWarningAmount(Integer warningAmount) {
        this.warningAmount = warningAmount;
    }

    public Integer getDecimalPlaces() {
        return this.decimalPlaces;
    }

    public Resort decimalPlaces(Integer decimalPlaces) {
        this.setDecimalPlaces(decimalPlaces);
        return this;
    }

    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public Integer getFont() {
        return this.font;
    }

    public Resort font(Integer font) {
        this.setFont(font);
        return this;
    }

    public void setFont(Integer font) {
        this.font = font;
    }

    public Integer getCopies() {
        return this.copies;
    }

    public Resort copies(Integer copies) {
        this.setCopies(copies);
        return this;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getDefaultFolioStyle() {
        return this.defaultFolioStyle;
    }

    public Resort defaultFolioStyle(Integer defaultFolioStyle) {
        this.setDefaultFolioStyle(defaultFolioStyle);
        return this;
    }

    public void setDefaultFolioStyle(Integer defaultFolioStyle) {
        this.defaultFolioStyle = defaultFolioStyle;
    }

    public Integer getIndividualRoomWarning() {
        return this.individualRoomWarning;
    }

    public Resort individualRoomWarning(Integer individualRoomWarning) {
        this.setIndividualRoomWarning(individualRoomWarning);
        return this;
    }

    public void setIndividualRoomWarning(Integer individualRoomWarning) {
        this.individualRoomWarning = individualRoomWarning;
    }

    public Integer getGroupRoomWarning() {
        return this.groupRoomWarning;
    }

    public Resort groupRoomWarning(Integer groupRoomWarning) {
        this.setGroupRoomWarning(groupRoomWarning);
        return this;
    }

    public void setGroupRoomWarning(Integer groupRoomWarning) {
        this.groupRoomWarning = groupRoomWarning;
    }

    public Integer getAgingLevel1() {
        return this.agingLevel1;
    }

    public Resort agingLevel1(Integer agingLevel1) {
        this.setAgingLevel1(agingLevel1);
        return this;
    }

    public void setAgingLevel1(Integer agingLevel1) {
        this.agingLevel1 = agingLevel1;
    }

    public Integer getAgingLevel2() {
        return this.agingLevel2;
    }

    public Resort agingLevel2(Integer agingLevel2) {
        this.setAgingLevel2(agingLevel2);
        return this;
    }

    public void setAgingLevel2(Integer agingLevel2) {
        this.agingLevel2 = agingLevel2;
    }

    public Integer getAgingLevel3() {
        return this.agingLevel3;
    }

    public Resort agingLevel3(Integer agingLevel3) {
        this.setAgingLevel3(agingLevel3);
        return this;
    }

    public void setAgingLevel3(Integer agingLevel3) {
        this.agingLevel3 = agingLevel3;
    }

    public Integer getAgingLevel4() {
        return this.agingLevel4;
    }

    public Resort agingLevel4(Integer agingLevel4) {
        this.setAgingLevel4(agingLevel4);
        return this;
    }

    public void setAgingLevel4(Integer agingLevel4) {
        this.agingLevel4 = agingLevel4;
    }

    public Integer getAgingLevel5() {
        return this.agingLevel5;
    }

    public Resort agingLevel5(Integer agingLevel5) {
        this.setAgingLevel5(agingLevel5);
        return this;
    }

    public void setAgingLevel5(Integer agingLevel5) {
        this.agingLevel5 = agingLevel5;
    }

    public Integer getZeroInvPurDays() {
        return this.zeroInvPurDays;
    }

    public Resort zeroInvPurDays(Integer zeroInvPurDays) {
        this.setZeroInvPurDays(zeroInvPurDays);
        return this;
    }

    public void setZeroInvPurDays(Integer zeroInvPurDays) {
        this.zeroInvPurDays = zeroInvPurDays;
    }

    public Integer getMinDaysBet2ReminderLetter() {
        return this.minDaysBet2ReminderLetter;
    }

    public Resort minDaysBet2ReminderLetter(Integer minDaysBet2ReminderLetter) {
        this.setMinDaysBet2ReminderLetter(minDaysBet2ReminderLetter);
        return this;
    }

    public void setMinDaysBet2ReminderLetter(Integer minDaysBet2ReminderLetter) {
        this.minDaysBet2ReminderLetter = minDaysBet2ReminderLetter;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public Resort insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public Resort updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getCurrencyDecimals() {
        return this.currencyDecimals;
    }

    public Resort currencyDecimals(Integer currencyDecimals) {
        this.setCurrencyDecimals(currencyDecimals);
        return this;
    }

    public void setCurrencyDecimals(Integer currencyDecimals) {
        this.currencyDecimals = currencyDecimals;
    }

    public Integer getNameIdLink() {
        return this.nameIdLink;
    }

    public Resort nameIdLink(Integer nameIdLink) {
        this.setNameIdLink(nameIdLink);
        return this;
    }

    public void setNameIdLink(Integer nameIdLink) {
        this.nameIdLink = nameIdLink;
    }

    public Integer getSglRate1() {
        return this.sglRate1;
    }

    public Resort sglRate1(Integer sglRate1) {
        this.setSglRate1(sglRate1);
        return this;
    }

    public void setSglRate1(Integer sglRate1) {
        this.sglRate1 = sglRate1;
    }

    public Integer getSglRate2() {
        return this.sglRate2;
    }

    public Resort sglRate2(Integer sglRate2) {
        this.setSglRate2(sglRate2);
        return this;
    }

    public void setSglRate2(Integer sglRate2) {
        this.sglRate2 = sglRate2;
    }

    public Integer getDblRate1() {
        return this.dblRate1;
    }

    public Resort dblRate1(Integer dblRate1) {
        this.setDblRate1(dblRate1);
        return this;
    }

    public void setDblRate1(Integer dblRate1) {
        this.dblRate1 = dblRate1;
    }

    public Integer getDblRate2() {
        return this.dblRate2;
    }

    public Resort dblRate2(Integer dblRate2) {
        this.setDblRate2(dblRate2);
        return this;
    }

    public void setDblRate2(Integer dblRate2) {
        this.dblRate2 = dblRate2;
    }

    public Integer getTplRate1() {
        return this.tplRate1;
    }

    public Resort tplRate1(Integer tplRate1) {
        this.setTplRate1(tplRate1);
        return this;
    }

    public void setTplRate1(Integer tplRate1) {
        this.tplRate1 = tplRate1;
    }

    public Integer getTplRate2() {
        return this.tplRate2;
    }

    public Resort tplRate2(Integer tplRate2) {
        this.setTplRate2(tplRate2);
        return this;
    }

    public void setTplRate2(Integer tplRate2) {
        this.tplRate2 = tplRate2;
    }

    public Integer getSuiRate1() {
        return this.suiRate1;
    }

    public Resort suiRate1(Integer suiRate1) {
        this.setSuiRate1(suiRate1);
        return this;
    }

    public void setSuiRate1(Integer suiRate1) {
        this.suiRate1 = suiRate1;
    }

    public Integer getSuiRate2() {
        return this.suiRate2;
    }

    public Resort suiRate2(Integer suiRate2) {
        this.setSuiRate2(suiRate2);
        return this;
    }

    public void setSuiRate2(Integer suiRate2) {
        this.suiRate2 = suiRate2;
    }

    public Integer getMeetSpace() {
        return this.meetSpace;
    }

    public Resort meetSpace(Integer meetSpace) {
        this.setMeetSpace(meetSpace);
        return this;
    }

    public void setMeetSpace(Integer meetSpace) {
        this.meetSpace = meetSpace;
    }

    public Integer getImgHotelId() {
        return this.imgHotelId;
    }

    public Resort imgHotelId(Integer imgHotelId) {
        this.setImgHotelId(imgHotelId);
        return this;
    }

    public void setImgHotelId(Integer imgHotelId) {
        this.imgHotelId = imgHotelId;
    }

    public Integer getImgDirectionId() {
        return this.imgDirectionId;
    }

    public Resort imgDirectionId(Integer imgDirectionId) {
        this.setImgDirectionId(imgDirectionId);
        return this;
    }

    public void setImgDirectionId(Integer imgDirectionId) {
        this.imgDirectionId = imgDirectionId;
    }

    public Integer getImgMapId() {
        return this.imgMapId;
    }

    public Resort imgMapId(Integer imgMapId) {
        this.setImgMapId(imgMapId);
        return this;
    }

    public void setImgMapId(Integer imgMapId) {
        this.imgMapId = imgMapId;
    }

    public Integer getScriptId() {
        return this.scriptId;
    }

    public Resort scriptId(Integer scriptId) {
        this.setScriptId(scriptId);
        return this;
    }

    public void setScriptId(Integer scriptId) {
        this.scriptId = scriptId;
    }

    public Integer getComNameXrefId() {
        return this.comNameXrefId;
    }

    public Resort comNameXrefId(Integer comNameXrefId) {
        this.setComNameXrefId(comNameXrefId);
        return this;
    }

    public void setComNameXrefId(Integer comNameXrefId) {
        this.comNameXrefId = comNameXrefId;
    }

    public Integer getPathId() {
        return this.pathId;
    }

    public Resort pathId(Integer pathId) {
        this.setPathId(pathId);
        return this;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    public Integer getXresortNumber() {
        return this.xresortNumber;
    }

    public Resort xresortNumber(Integer xresortNumber) {
        this.setXresortNumber(xresortNumber);
        return this;
    }

    public void setXresortNumber(Integer xresortNumber) {
        this.xresortNumber = xresortNumber;
    }

    public Integer getMaxCreditDays() {
        return this.maxCreditDays;
    }

    public Resort maxCreditDays(Integer maxCreditDays) {
        this.setMaxCreditDays(maxCreditDays);
        return this;
    }

    public void setMaxCreditDays(Integer maxCreditDays) {
        this.maxCreditDays = maxCreditDays;
    }

    public Integer getCurrencyDivisor() {
        return this.currencyDivisor;
    }

    public Resort currencyDivisor(Integer currencyDivisor) {
        this.setCurrencyDivisor(currencyDivisor);
        return this;
    }

    public void setCurrencyDivisor(Integer currencyDivisor) {
        this.currencyDivisor = currencyDivisor;
    }

    public Integer getLatitude() {
        return this.latitude;
    }

    public Resort latitude(Integer latitude) {
        this.setLatitude(latitude);
        return this;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return this.longitude;
    }

    public Resort longitude(Integer longitude) {
        this.setLongitude(longitude);
        return this;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getQtySingleRooms() {
        return this.qtySingleRooms;
    }

    public Resort qtySingleRooms(Integer qtySingleRooms) {
        this.setQtySingleRooms(qtySingleRooms);
        return this;
    }

    public void setQtySingleRooms(Integer qtySingleRooms) {
        this.qtySingleRooms = qtySingleRooms;
    }

    public Integer getQtyDoubleRooms() {
        return this.qtyDoubleRooms;
    }

    public Resort qtyDoubleRooms(Integer qtyDoubleRooms) {
        this.setQtyDoubleRooms(qtyDoubleRooms);
        return this;
    }

    public void setQtyDoubleRooms(Integer qtyDoubleRooms) {
        this.qtyDoubleRooms = qtyDoubleRooms;
    }

    public Integer getQtyTwinRooms() {
        return this.qtyTwinRooms;
    }

    public Resort qtyTwinRooms(Integer qtyTwinRooms) {
        this.setQtyTwinRooms(qtyTwinRooms);
        return this;
    }

    public void setQtyTwinRooms(Integer qtyTwinRooms) {
        this.qtyTwinRooms = qtyTwinRooms;
    }

    public Integer getQtySuites() {
        return this.qtySuites;
    }

    public Resort qtySuites(Integer qtySuites) {
        this.setQtySuites(qtySuites);
        return this;
    }

    public void setQtySuites(Integer qtySuites) {
        this.qtySuites = qtySuites;
    }

    public Integer getQtyGuestRoomFloors() {
        return this.qtyGuestRoomFloors;
    }

    public Resort qtyGuestRoomFloors(Integer qtyGuestRoomFloors) {
        this.setQtyGuestRoomFloors(qtyGuestRoomFloors);
        return this;
    }

    public void setQtyGuestRoomFloors(Integer qtyGuestRoomFloors) {
        this.qtyGuestRoomFloors = qtyGuestRoomFloors;
    }

    public Integer getQtyGuestElevators() {
        return this.qtyGuestElevators;
    }

    public Resort qtyGuestElevators(Integer qtyGuestElevators) {
        this.setQtyGuestElevators(qtyGuestElevators);
        return this;
    }

    public void setQtyGuestElevators(Integer qtyGuestElevators) {
        this.qtyGuestElevators = qtyGuestElevators;
    }

    public Integer getQtyNonSmokingRooms() {
        return this.qtyNonSmokingRooms;
    }

    public Resort qtyNonSmokingRooms(Integer qtyNonSmokingRooms) {
        this.setQtyNonSmokingRooms(qtyNonSmokingRooms);
        return this;
    }

    public void setQtyNonSmokingRooms(Integer qtyNonSmokingRooms) {
        this.qtyNonSmokingRooms = qtyNonSmokingRooms;
    }

    public Integer getQtyConnectingRooms() {
        return this.qtyConnectingRooms;
    }

    public Resort qtyConnectingRooms(Integer qtyConnectingRooms) {
        this.setQtyConnectingRooms(qtyConnectingRooms);
        return this;
    }

    public void setQtyConnectingRooms(Integer qtyConnectingRooms) {
        this.qtyConnectingRooms = qtyConnectingRooms;
    }

    public Integer getQtyHandicappedRooms() {
        return this.qtyHandicappedRooms;
    }

    public Resort qtyHandicappedRooms(Integer qtyHandicappedRooms) {
        this.setQtyHandicappedRooms(qtyHandicappedRooms);
        return this;
    }

    public void setQtyHandicappedRooms(Integer qtyHandicappedRooms) {
        this.qtyHandicappedRooms = qtyHandicappedRooms;
    }

    public Integer getQtyFamilyRooms() {
        return this.qtyFamilyRooms;
    }

    public Resort qtyFamilyRooms(Integer qtyFamilyRooms) {
        this.setQtyFamilyRooms(qtyFamilyRooms);
        return this;
    }

    public void setQtyFamilyRooms(Integer qtyFamilyRooms) {
        this.qtyFamilyRooms = qtyFamilyRooms;
    }

    public Integer getMaxAdultsFamilyRoom() {
        return this.maxAdultsFamilyRoom;
    }

    public Resort maxAdultsFamilyRoom(Integer maxAdultsFamilyRoom) {
        this.setMaxAdultsFamilyRoom(maxAdultsFamilyRoom);
        return this;
    }

    public void setMaxAdultsFamilyRoom(Integer maxAdultsFamilyRoom) {
        this.maxAdultsFamilyRoom = maxAdultsFamilyRoom;
    }

    public Integer getMaxChildrenFamilyRoom() {
        return this.maxChildrenFamilyRoom;
    }

    public Resort maxChildrenFamilyRoom(Integer maxChildrenFamilyRoom) {
        this.setMaxChildrenFamilyRoom(maxChildrenFamilyRoom);
        return this;
    }

    public void setMaxChildrenFamilyRoom(Integer maxChildrenFamilyRoom) {
        this.maxChildrenFamilyRoom = maxChildrenFamilyRoom;
    }

    public Integer getRestaurant() {
        return this.restaurant;
    }

    public Resort restaurant(Integer restaurant) {
        this.setRestaurant(restaurant);
        return this;
    }

    public void setRestaurant(Integer restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getMeetRooms() {
        return this.meetRooms;
    }

    public Resort meetRooms(Integer meetRooms) {
        this.setMeetRooms(meetRooms);
        return this;
    }

    public void setMeetRooms(Integer meetRooms) {
        this.meetRooms = meetRooms;
    }

    public Integer getTotRooms() {
        return this.totRooms;
    }

    public Resort totRooms(Integer totRooms) {
        this.setTotRooms(totRooms);
        return this;
    }

    public void setTotRooms(Integer totRooms) {
        this.totRooms = totRooms;
    }

    public Integer getBrSeats() {
        return this.brSeats;
    }

    public Resort brSeats(Integer brSeats) {
        this.setBrSeats(brSeats);
        return this;
    }

    public void setBrSeats(Integer brSeats) {
        this.brSeats = brSeats;
    }

    public Integer getMeetSeats() {
        return this.meetSeats;
    }

    public Resort meetSeats(Integer meetSeats) {
        this.setMeetSeats(meetSeats);
        return this;
    }

    public void setMeetSeats(Integer meetSeats) {
        this.meetSeats = meetSeats;
    }

    public Integer getMaxNoNights() {
        return this.maxNoNights;
    }

    public Resort maxNoNights(Integer maxNoNights) {
        this.setMaxNoNights(maxNoNights);
        return this;
    }

    public void setMaxNoNights(Integer maxNoNights) {
        this.maxNoNights = maxNoNights;
    }

    public Integer getAwardsTimeout() {
        return this.awardsTimeout;
    }

    public Resort awardsTimeout(Integer awardsTimeout) {
        this.setAwardsTimeout(awardsTimeout);
        return this;
    }

    public void setAwardsTimeout(Integer awardsTimeout) {
        this.awardsTimeout = awardsTimeout;
    }

    public Integer getGuestLookupTimeout() {
        return this.guestLookupTimeout;
    }

    public Resort guestLookupTimeout(Integer guestLookupTimeout) {
        this.setGuestLookupTimeout(guestLookupTimeout);
        return this;
    }

    public void setGuestLookupTimeout(Integer guestLookupTimeout) {
        this.guestLookupTimeout = guestLookupTimeout;
    }

    public Integer getWakeUpDelay() {
        return this.wakeUpDelay;
    }

    public Resort wakeUpDelay(Integer wakeUpDelay) {
        this.setWakeUpDelay(wakeUpDelay);
        return this;
    }

    public void setWakeUpDelay(Integer wakeUpDelay) {
        this.wakeUpDelay = wakeUpDelay;
    }

    public Integer getMaxOccupancy() {
        return this.maxOccupancy;
    }

    public Resort maxOccupancy(Integer maxOccupancy) {
        this.setMaxOccupancy(maxOccupancy);
        return this;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public Integer getInactiveDaysForGuestProfil() {
        return this.inactiveDaysForGuestProfil;
    }

    public Resort inactiveDaysForGuestProfil(Integer inactiveDaysForGuestProfil) {
        this.setInactiveDaysForGuestProfil(inactiveDaysForGuestProfil);
        return this;
    }

    public void setInactiveDaysForGuestProfil(Integer inactiveDaysForGuestProfil) {
        this.inactiveDaysForGuestProfil = inactiveDaysForGuestProfil;
    }

    public Integer getPerReservationRoomLimit() {
        return this.perReservationRoomLimit;
    }

    public Resort perReservationRoomLimit(Integer perReservationRoomLimit) {
        this.setPerReservationRoomLimit(perReservationRoomLimit);
        return this;
    }

    public void setPerReservationRoomLimit(Integer perReservationRoomLimit) {
        this.perReservationRoomLimit = perReservationRoomLimit;
    }

    public String getLicRoomInfo() {
        return this.licRoomInfo;
    }

    public Resort licRoomInfo(String licRoomInfo) {
        this.setLicRoomInfo(licRoomInfo);
        return this;
    }

    public void setLicRoomInfo(String licRoomInfo) {
        this.licRoomInfo = licRoomInfo;
    }

    public String getThousandSeparator() {
        return this.thousandSeparator;
    }

    public Resort thousandSeparator(String thousandSeparator) {
        this.setThousandSeparator(thousandSeparator);
        return this;
    }

    public void setThousandSeparator(String thousandSeparator) {
        this.thousandSeparator = thousandSeparator;
    }

    public String getDateSeparator() {
        return this.dateSeparator;
    }

    public Resort dateSeparator(String dateSeparator) {
        this.setDateSeparator(dateSeparator);
        return this;
    }

    public void setDateSeparator(String dateSeparator) {
        this.dateSeparator = dateSeparator;
    }

    public String getArAcctNoMandYn() {
        return this.arAcctNoMandYn;
    }

    public Resort arAcctNoMandYn(String arAcctNoMandYn) {
        this.setArAcctNoMandYn(arAcctNoMandYn);
        return this;
    }

    public void setArAcctNoMandYn(String arAcctNoMandYn) {
        this.arAcctNoMandYn = arAcctNoMandYn;
    }

    public String getExchangePostingType() {
        return this.exchangePostingType;
    }

    public Resort exchangePostingType(String exchangePostingType) {
        this.setExchangePostingType(exchangePostingType);
        return this;
    }

    public void setExchangePostingType(String exchangePostingType) {
        this.exchangePostingType = exchangePostingType;
    }

    public String getInventoryYn() {
        return this.inventoryYn;
    }

    public Resort inventoryYn(String inventoryYn) {
        this.setInventoryYn(inventoryYn);
        return this;
    }

    public void setInventoryYn(String inventoryYn) {
        this.inventoryYn = inventoryYn;
    }

    public String getAllowLoginYn() {
        return this.allowLoginYn;
    }

    public Resort allowLoginYn(String allowLoginYn) {
        this.setAllowLoginYn(allowLoginYn);
        return this;
    }

    public void setAllowLoginYn(String allowLoginYn) {
        this.allowLoginYn = allowLoginYn;
    }

    public String getAccessCode() {
        return this.accessCode;
    }

    public Resort accessCode(String accessCode) {
        this.setAccessCode(accessCode);
        return this;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getDisableLoginYn() {
        return this.disableLoginYn;
    }

    public Resort disableLoginYn(String disableLoginYn) {
        this.setDisableLoginYn(disableLoginYn);
        return this;
    }

    public void setDisableLoginYn(String disableLoginYn) {
        this.disableLoginYn = disableLoginYn;
    }

    public String getIntTaxIncludedYn() {
        return this.intTaxIncludedYn;
    }

    public Resort intTaxIncludedYn(String intTaxIncludedYn) {
        this.setIntTaxIncludedYn(intTaxIncludedYn);
        return this;
    }

    public void setIntTaxIncludedYn(String intTaxIncludedYn) {
        this.intTaxIncludedYn = intTaxIncludedYn;
    }

    public String getDownloadRestYn() {
        return this.downloadRestYn;
    }

    public Resort downloadRestYn(String downloadRestYn) {
        this.setDownloadRestYn(downloadRestYn);
        return this;
    }

    public void setDownloadRestYn(String downloadRestYn) {
        this.downloadRestYn = downloadRestYn;
    }

    public String getTranslateMulticharYn() {
        return this.translateMulticharYn;
    }

    public Resort translateMulticharYn(String translateMulticharYn) {
        this.setTranslateMulticharYn(translateMulticharYn);
        return this;
    }

    public void setTranslateMulticharYn(String translateMulticharYn) {
        this.translateMulticharYn = translateMulticharYn;
    }

    public String getExternalScYn() {
        return this.externalScYn;
    }

    public Resort externalScYn(String externalScYn) {
        this.setExternalScYn(externalScYn);
        return this;
    }

    public void setExternalScYn(String externalScYn) {
        this.externalScYn = externalScYn;
    }

    public String getSendLeadAsBookingYn() {
        return this.sendLeadAsBookingYn;
    }

    public Resort sendLeadAsBookingYn(String sendLeadAsBookingYn) {
        this.setSendLeadAsBookingYn(sendLeadAsBookingYn);
        return this;
    }

    public void setSendLeadAsBookingYn(String sendLeadAsBookingYn) {
        this.sendLeadAsBookingYn = sendLeadAsBookingYn;
    }

    public String getMbsSupportedYn() {
        return this.mbsSupportedYn;
    }

    public Resort mbsSupportedYn(String mbsSupportedYn) {
        this.setMbsSupportedYn(mbsSupportedYn);
        return this;
    }

    public void setMbsSupportedYn(String mbsSupportedYn) {
        this.mbsSupportedYn = mbsSupportedYn;
    }

    public String getQuotedCurrency() {
        return this.quotedCurrency;
    }

    public Resort quotedCurrency(String quotedCurrency) {
        this.setQuotedCurrency(quotedCurrency);
        return this;
    }

    public void setQuotedCurrency(String quotedCurrency) {
        this.quotedCurrency = quotedCurrency;
    }

    public String getComMethod() {
        return this.comMethod;
    }

    public Resort comMethod(String comMethod) {
        this.setComMethod(comMethod);
        return this;
    }

    public void setComMethod(String comMethod) {
        this.comMethod = comMethod;
    }

    public String getEmail() {
        return this.email;
    }

    public Resort email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenmgr() {
        return this.genmgr;
    }

    public Resort genmgr(String genmgr) {
        this.setGenmgr(genmgr);
        return this;
    }

    public void setGenmgr(String genmgr) {
        this.genmgr = genmgr;
    }

    public String getDirsales() {
        return this.dirsales;
    }

    public Resort dirsales(String dirsales) {
        this.setDirsales(dirsales);
        return this;
    }

    public void setDirsales(String dirsales) {
        this.dirsales = dirsales;
    }

    public String getLeadsend() {
        return this.leadsend;
    }

    public Resort leadsend(String leadsend) {
        this.setLeadsend(leadsend);
        return this;
    }

    public void setLeadsend(String leadsend) {
        this.leadsend = leadsend;
    }

    public String getAirport() {
        return this.airport;
    }

    public Resort airport(String airport) {
        this.setAirport(airport);
        return this;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getComAddress() {
        return this.comAddress;
    }

    public Resort comAddress(String comAddress) {
        this.setComAddress(comAddress);
        return this;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getSeason1() {
        return this.season1;
    }

    public Resort season1(String season1) {
        this.setSeason1(season1);
        return this;
    }

    public void setSeason1(String season1) {
        this.season1 = season1;
    }

    public String getSeason2() {
        return this.season2;
    }

    public Resort season2(String season2) {
        this.setSeason2(season2);
        return this;
    }

    public void setSeason2(String season2) {
        this.season2 = season2;
    }

    public String getSeason3() {
        return this.season3;
    }

    public Resort season3(String season3) {
        this.setSeason3(season3);
        return this;
    }

    public void setSeason3(String season3) {
        this.season3 = season3;
    }

    public String getSeason4() {
        return this.season4;
    }

    public Resort season4(String season4) {
        this.setSeason4(season4);
        return this;
    }

    public void setSeason4(String season4) {
        this.season4 = season4;
    }

    public String getSeason5() {
        return this.season5;
    }

    public Resort season5(String season5) {
        this.setSeason5(season5);
        return this;
    }

    public void setSeason5(String season5) {
        this.season5 = season5;
    }

    public String getFloorNumExecutiveFloor() {
        return this.floorNumExecutiveFloor;
    }

    public Resort floorNumExecutiveFloor(String floorNumExecutiveFloor) {
        this.setFloorNumExecutiveFloor(floorNumExecutiveFloor);
        return this;
    }

    public void setFloorNumExecutiveFloor(String floorNumExecutiveFloor) {
        this.floorNumExecutiveFloor = floorNumExecutiveFloor;
    }

    public String getCrsResort() {
        return this.crsResort;
    }

    public Resort crsResort(String crsResort) {
        this.setCrsResort(crsResort);
        return this;
    }

    public void setCrsResort(String crsResort) {
        this.crsResort = crsResort;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public Resort postCode(String postCode) {
        this.setPostCode(postCode);
        return this;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getDefaultReservationType() {
        return this.defaultReservationType;
    }

    public Resort defaultReservationType(String defaultReservationType) {
        this.setDefaultReservationType(defaultReservationType);
        return this;
    }

    public void setDefaultReservationType(String defaultReservationType) {
        this.defaultReservationType = defaultReservationType;
    }

    public String getBlock() {
        return this.block;
    }

    public Resort block(String block) {
        this.setBlock(block);
        return this;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public Resort currencySymbol(String currencySymbol) {
        this.setCurrencySymbol(currencySymbol);
        return this;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getSourceCommission() {
        return this.sourceCommission;
    }

    public Resort sourceCommission(String sourceCommission) {
        this.setSourceCommission(sourceCommission);
        return this;
    }

    public void setSourceCommission(String sourceCommission) {
        this.sourceCommission = sourceCommission;
    }

    public String getTaCommission() {
        return this.taCommission;
    }

    public Resort taCommission(String taCommission) {
        this.setTaCommission(taCommission);
        return this;
    }

    public void setTaCommission(String taCommission) {
        this.taCommission = taCommission;
    }

    public String getBaseLanguage() {
        return this.baseLanguage;
    }

    public Resort baseLanguage(String baseLanguage) {
        this.setBaseLanguage(baseLanguage);
        return this;
    }

    public void setBaseLanguage(String baseLanguage) {
        this.baseLanguage = baseLanguage;
    }

    public String getFolioLanguage1() {
        return this.folioLanguage1;
    }

    public Resort folioLanguage1(String folioLanguage1) {
        this.setFolioLanguage1(folioLanguage1);
        return this;
    }

    public void setFolioLanguage1(String folioLanguage1) {
        this.folioLanguage1 = folioLanguage1;
    }

    public String getFolioLanguage2() {
        return this.folioLanguage2;
    }

    public Resort folioLanguage2(String folioLanguage2) {
        this.setFolioLanguage2(folioLanguage2);
        return this;
    }

    public void setFolioLanguage2(String folioLanguage2) {
        this.folioLanguage2 = folioLanguage2;
    }

    public String getFolioLanguage3() {
        return this.folioLanguage3;
    }

    public Resort folioLanguage3(String folioLanguage3) {
        this.setFolioLanguage3(folioLanguage3);
        return this;
    }

    public void setFolioLanguage3(String folioLanguage3) {
        this.folioLanguage3 = folioLanguage3;
    }

    public String getFolioLanguage4() {
        return this.folioLanguage4;
    }

    public Resort folioLanguage4(String folioLanguage4) {
        this.setFolioLanguage4(folioLanguage4);
        return this;
    }

    public void setFolioLanguage4(String folioLanguage4) {
        this.folioLanguage4 = folioLanguage4;
    }

    public String getPackageProfit() {
        return this.packageProfit;
    }

    public Resort packageProfit(String packageProfit) {
        this.setPackageProfit(packageProfit);
        return this;
    }

    public void setPackageProfit(String packageProfit) {
        this.packageProfit = packageProfit;
    }

    public String getPackageLoss() {
        return this.packageLoss;
    }

    public Resort packageLoss(String packageLoss) {
        this.setPackageLoss(packageLoss);
        return this;
    }

    public void setPackageLoss(String packageLoss) {
        this.packageLoss = packageLoss;
    }

    public String getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public Resort decimalSeparator(String decimalSeparator) {
        this.setDecimalSeparator(decimalSeparator);
        return this;
    }

    public void setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public String getShortDateFormat() {
        return this.shortDateFormat;
    }

    public Resort shortDateFormat(String shortDateFormat) {
        this.setShortDateFormat(shortDateFormat);
        return this;
    }

    public void setShortDateFormat(String shortDateFormat) {
        this.shortDateFormat = shortDateFormat;
    }

    public String getLongDateFormat() {
        return this.longDateFormat;
    }

    public Resort longDateFormat(String longDateFormat) {
        this.setLongDateFormat(longDateFormat);
        return this;
    }

    public void setLongDateFormat(String longDateFormat) {
        this.longDateFormat = longDateFormat;
    }

    public String getPasserbySource() {
        return this.passerbySource;
    }

    public Resort passerbySource(String passerbySource) {
        this.setPasserbySource(passerbySource);
        return this;
    }

    public void setPasserbySource(String passerbySource) {
        this.passerbySource = passerbySource;
    }

    public String getPasserbyMarket() {
        return this.passerbyMarket;
    }

    public Resort passerbyMarket(String passerbyMarket) {
        this.setPasserbyMarket(passerbyMarket);
        return this;
    }

    public void setPasserbyMarket(String passerbyMarket) {
        this.passerbyMarket = passerbyMarket;
    }

    public String getArCompany() {
        return this.arCompany;
    }

    public Resort arCompany(String arCompany) {
        this.setArCompany(arCompany);
        return this;
    }

    public void setArCompany(String arCompany) {
        this.arCompany = arCompany;
    }

    public String getArAgent() {
        return this.arAgent;
    }

    public Resort arAgent(String arAgent) {
        this.setArAgent(arAgent);
        return this;
    }

    public void setArAgent(String arAgent) {
        this.arAgent = arAgent;
    }

    public String getArGroups() {
        return this.arGroups;
    }

    public Resort arGroups(String arGroups) {
        this.setArGroups(arGroups);
        return this;
    }

    public void setArGroups(String arGroups) {
        this.arGroups = arGroups;
    }

    public String getArIndividuals() {
        return this.arIndividuals;
    }

    public Resort arIndividuals(String arIndividuals) {
        this.setArIndividuals(arIndividuals);
        return this;
    }

    public void setArIndividuals(String arIndividuals) {
        this.arIndividuals = arIndividuals;
    }

    public String getArAcctNoFormat() {
        return this.arAcctNoFormat;
    }

    public Resort arAcctNoFormat(String arAcctNoFormat) {
        this.setArAcctNoFormat(arAcctNoFormat);
        return this;
    }

    public void setArAcctNoFormat(String arAcctNoFormat) {
        this.arAcctNoFormat = arAcctNoFormat;
    }

    public String getAllowancePeriodAdj() {
        return this.allowancePeriodAdj;
    }

    public Resort allowancePeriodAdj(String allowancePeriodAdj) {
        this.setAllowancePeriodAdj(allowancePeriodAdj);
        return this;
    }

    public void setAllowancePeriodAdj(String allowancePeriodAdj) {
        this.allowancePeriodAdj = allowancePeriodAdj;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public Resort currencyCode(String currencyCode) {
        this.setCurrencyCode(currencyCode);
        return this;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getTurnawayCode() {
        return this.turnawayCode;
    }

    public Resort turnawayCode(String turnawayCode) {
        this.setTurnawayCode(turnawayCode);
        return this;
    }

    public void setTurnawayCode(String turnawayCode) {
        this.turnawayCode = turnawayCode;
    }

    public String getSummCurrencyCode() {
        return this.summCurrencyCode;
    }

    public Resort summCurrencyCode(String summCurrencyCode) {
        this.setSummCurrencyCode(summCurrencyCode);
        return this;
    }

    public void setSummCurrencyCode(String summCurrencyCode) {
        this.summCurrencyCode = summCurrencyCode;
    }

    public String getDefaultPropertyAddress() {
        return this.defaultPropertyAddress;
    }

    public Resort defaultPropertyAddress(String defaultPropertyAddress) {
        this.setDefaultPropertyAddress(defaultPropertyAddress);
        return this;
    }

    public void setDefaultPropertyAddress(String defaultPropertyAddress) {
        this.defaultPropertyAddress = defaultPropertyAddress;
    }

    public String getDefaultGuestAddress() {
        return this.defaultGuestAddress;
    }

    public Resort defaultGuestAddress(String defaultGuestAddress) {
        this.setDefaultGuestAddress(defaultGuestAddress);
        return this;
    }

    public void setDefaultGuestAddress(String defaultGuestAddress) {
        this.defaultGuestAddress = defaultGuestAddress;
    }

    public String getLicenseCode() {
        return this.licenseCode;
    }

    public Resort licenseCode(String licenseCode) {
        this.setLicenseCode(licenseCode);
        return this;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getTimeFormat() {
        return this.timeFormat;
    }

    public Resort timeFormat(String timeFormat) {
        this.setTimeFormat(timeFormat);
        return this;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getChainCode() {
        return this.chainCode;
    }

    public Resort chainCode(String chainCode) {
        this.setChainCode(chainCode);
        return this;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getResortType() {
        return this.resortType;
    }

    public Resort resortType(String resortType) {
        this.setResortType(resortType);
        return this;
    }

    public void setResortType(String resortType) {
        this.resortType = resortType;
    }

    public String getHotelType() {
        return this.hotelType;
    }

    public Resort hotelType(String hotelType) {
        this.setHotelType(hotelType);
        return this;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getOwnership() {
        return this.ownership;
    }

    public Resort ownership(String ownership) {
        this.setOwnership(ownership);
        return this;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getArBalTrxCode() {
        return this.arBalTrxCode;
    }

    public Resort arBalTrxCode(String arBalTrxCode) {
        this.setArBalTrxCode(arBalTrxCode);
        return this;
    }

    public void setArBalTrxCode(String arBalTrxCode) {
        this.arBalTrxCode = arBalTrxCode;
    }

    public String getArCreditTrxCode() {
        return this.arCreditTrxCode;
    }

    public Resort arCreditTrxCode(String arCreditTrxCode) {
        this.setArCreditTrxCode(arCreditTrxCode);
        return this;
    }

    public void setArCreditTrxCode(String arCreditTrxCode) {
        this.arCreditTrxCode = arCreditTrxCode;
    }

    public String getArSettleCode() {
        return this.arSettleCode;
    }

    public Resort arSettleCode(String arSettleCode) {
        this.setArSettleCode(arSettleCode);
        return this;
    }

    public void setArSettleCode(String arSettleCode) {
        this.arSettleCode = arSettleCode;
    }

    public String getCashShiftDrop() {
        return this.cashShiftDrop;
    }

    public Resort cashShiftDrop(String cashShiftDrop) {
        this.setCashShiftDrop(cashShiftDrop);
        return this;
    }

    public void setCashShiftDrop(String cashShiftDrop) {
        this.cashShiftDrop = cashShiftDrop;
    }

    public String getCheckExgPaidout() {
        return this.checkExgPaidout;
    }

    public Resort checkExgPaidout(String checkExgPaidout) {
        this.setCheckExgPaidout(checkExgPaidout);
        return this;
    }

    public void setCheckExgPaidout(String checkExgPaidout) {
        this.checkExgPaidout = checkExgPaidout;
    }

    public String getCheckShiftDrop() {
        return this.checkShiftDrop;
    }

    public Resort checkShiftDrop(String checkShiftDrop) {
        this.setCheckShiftDrop(checkShiftDrop);
        return this;
    }

    public void setCheckShiftDrop(String checkShiftDrop) {
        this.checkShiftDrop = checkShiftDrop;
    }

    public String getCheckTrxcode() {
        return this.checkTrxcode;
    }

    public Resort checkTrxcode(String checkTrxcode) {
        this.setCheckTrxcode(checkTrxcode);
        return this;
    }

    public void setCheckTrxcode(String checkTrxcode) {
        this.checkTrxcode = checkTrxcode;
    }

    public String getCurrencyExgPaidout() {
        return this.currencyExgPaidout;
    }

    public Resort currencyExgPaidout(String currencyExgPaidout) {
        this.setCurrencyExgPaidout(currencyExgPaidout);
        return this;
    }

    public void setCurrencyExgPaidout(String currencyExgPaidout) {
        this.currencyExgPaidout = currencyExgPaidout;
    }

    public String getDepositLedTrxCode() {
        return this.depositLedTrxCode;
    }

    public Resort depositLedTrxCode(String depositLedTrxCode) {
        this.setDepositLedTrxCode(depositLedTrxCode);
        return this;
    }

    public void setDepositLedTrxCode(String depositLedTrxCode) {
        this.depositLedTrxCode = depositLedTrxCode;
    }

    public String getFiscalPeriodType() {
        return this.fiscalPeriodType;
    }

    public Resort fiscalPeriodType(String fiscalPeriodType) {
        this.setFiscalPeriodType(fiscalPeriodType);
        return this;
    }

    public void setFiscalPeriodType(String fiscalPeriodType) {
        this.fiscalPeriodType = fiscalPeriodType;
    }

    public String getDefaultCommissionPercentage() {
        return this.defaultCommissionPercentage;
    }

    public Resort defaultCommissionPercentage(String defaultCommissionPercentage) {
        this.setDefaultCommissionPercentage(defaultCommissionPercentage);
        return this;
    }

    public void setDefaultCommissionPercentage(String defaultCommissionPercentage) {
        this.defaultCommissionPercentage = defaultCommissionPercentage;
    }

    public String getDefaultPrepaidComm() {
        return this.defaultPrepaidComm;
    }

    public Resort defaultPrepaidComm(String defaultPrepaidComm) {
        this.setDefaultPrepaidComm(defaultPrepaidComm);
        return this;
    }

    public void setDefaultPrepaidComm(String defaultPrepaidComm) {
        this.defaultPrepaidComm = defaultPrepaidComm;
    }

    public String getDefaultTrxCommCode() {
        return this.defaultTrxCommCode;
    }

    public Resort defaultTrxCommCode(String defaultTrxCommCode) {
        this.setDefaultTrxCommCode(defaultTrxCommCode);
        return this;
    }

    public void setDefaultTrxCommCode(String defaultTrxCommCode) {
        this.defaultTrxCommCode = defaultTrxCommCode;
    }

    public String getConfigurationMode() {
        return this.configurationMode;
    }

    public Resort configurationMode(String configurationMode) {
        this.setConfigurationMode(configurationMode);
        return this;
    }

    public void setConfigurationMode(String configurationMode) {
        this.configurationMode = configurationMode;
    }

    public String getWeekendDays() {
        return this.weekendDays;
    }

    public Resort weekendDays(String weekendDays) {
        this.setWeekendDays(weekendDays);
        return this;
    }

    public void setWeekendDays(String weekendDays) {
        this.weekendDays = weekendDays;
    }

    public String getDefaultGroupsRateCode() {
        return this.defaultGroupsRateCode;
    }

    public Resort defaultGroupsRateCode(String defaultGroupsRateCode) {
        this.setDefaultGroupsRateCode(defaultGroupsRateCode);
        return this;
    }

    public void setDefaultGroupsRateCode(String defaultGroupsRateCode) {
        this.defaultGroupsRateCode = defaultGroupsRateCode;
    }

    public String getDefaultPostingRoom() {
        return this.defaultPostingRoom;
    }

    public Resort defaultPostingRoom(String defaultPostingRoom) {
        this.setDefaultPostingRoom(defaultPostingRoom);
        return this;
    }

    public void setDefaultPostingRoom(String defaultPostingRoom) {
        this.defaultPostingRoom = defaultPostingRoom;
    }

    public String getDfltPkgTranCode() {
        return this.dfltPkgTranCode;
    }

    public Resort dfltPkgTranCode(String dfltPkgTranCode) {
        this.setDfltPkgTranCode(dfltPkgTranCode);
        return this;
    }

    public void setDfltPkgTranCode(String dfltPkgTranCode) {
        this.dfltPkgTranCode = dfltPkgTranCode;
    }

    public String getDfltTranCodeRateCode() {
        return this.dfltTranCodeRateCode;
    }

    public Resort dfltTranCodeRateCode(String dfltTranCodeRateCode) {
        this.setDfltTranCodeRateCode(dfltTranCodeRateCode);
        return this;
    }

    public void setDfltTranCodeRateCode(String dfltTranCodeRateCode) {
        this.dfltTranCodeRateCode = dfltTranCodeRateCode;
    }

    public String getDefaultRateCode() {
        return this.defaultRateCode;
    }

    public Resort defaultRateCode(String defaultRateCode) {
        this.setDefaultRateCode(defaultRateCode);
        return this;
    }

    public void setDefaultRateCode(String defaultRateCode) {
        this.defaultRateCode = defaultRateCode;
    }

    public String getCroCode() {
        return this.croCode;
    }

    public Resort croCode(String croCode) {
        this.setCroCode(croCode);
        return this;
    }

    public void setCroCode(String croCode) {
        this.croCode = croCode;
    }

    public String getFlowCode() {
        return this.flowCode;
    }

    public Resort flowCode(String flowCode) {
        this.setFlowCode(flowCode);
        return this;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public String getExtPropertyCode() {
        return this.extPropertyCode;
    }

    public Resort extPropertyCode(String extPropertyCode) {
        this.setExtPropertyCode(extPropertyCode);
        return this;
    }

    public void setExtPropertyCode(String extPropertyCode) {
        this.extPropertyCode = extPropertyCode;
    }

    public String getOpusCurrencyCode() {
        return this.opusCurrencyCode;
    }

    public Resort opusCurrencyCode(String opusCurrencyCode) {
        this.setOpusCurrencyCode(opusCurrencyCode);
        return this;
    }

    public void setOpusCurrencyCode(String opusCurrencyCode) {
        this.opusCurrencyCode = opusCurrencyCode;
    }

    public String getDestinationId() {
        return this.destinationId;
    }

    public Resort destinationId(String destinationId) {
        this.setDestinationId(destinationId);
        return this;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getFlags() {
        return this.flags;
    }

    public Resort flags(String flags) {
        this.setFlags(flags);
        return this;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getTouristNumber() {
        return this.touristNumber;
    }

    public Resort touristNumber(String touristNumber) {
        this.setTouristNumber(touristNumber);
        return this;
    }

    public void setTouristNumber(String touristNumber) {
        this.touristNumber = touristNumber;
    }

    public String getCateringCurrencyCode() {
        return this.cateringCurrencyCode;
    }

    public Resort cateringCurrencyCode(String cateringCurrencyCode) {
        this.setCateringCurrencyCode(cateringCurrencyCode);
        return this;
    }

    public void setCateringCurrencyCode(String cateringCurrencyCode) {
        this.cateringCurrencyCode = cateringCurrencyCode;
    }

    public String getDefaultRatecodeRack() {
        return this.defaultRatecodeRack;
    }

    public Resort defaultRatecodeRack(String defaultRatecodeRack) {
        this.setDefaultRatecodeRack(defaultRatecodeRack);
        return this;
    }

    public void setDefaultRatecodeRack(String defaultRatecodeRack) {
        this.defaultRatecodeRack = defaultRatecodeRack;
    }

    public String getDefaultRatecodePcr() {
        return this.defaultRatecodePcr;
    }

    public Resort defaultRatecodePcr(String defaultRatecodePcr) {
        this.setDefaultRatecodePcr(defaultRatecodePcr);
        return this;
    }

    public void setDefaultRatecodePcr(String defaultRatecodePcr) {
        this.defaultRatecodePcr = defaultRatecodePcr;
    }

    public String getFnsTier() {
        return this.fnsTier;
    }

    public Resort fnsTier(String fnsTier) {
        this.setFnsTier(fnsTier);
        return this;
    }

    public void setFnsTier(String fnsTier) {
        this.fnsTier = fnsTier;
    }

    public String getBrandCode() {
        return this.brandCode;
    }

    public Resort brandCode(String brandCode) {
        this.setBrandCode(brandCode);
        return this;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getWebaddress() {
        return this.webaddress;
    }

    public Resort webaddress(String webaddress) {
        this.setWebaddress(webaddress);
        return this;
    }

    public void setWebaddress(String webaddress) {
        this.webaddress = webaddress;
    }

    public String getVatId() {
        return this.vatId;
    }

    public Resort vatId(String vatId) {
        this.setVatId(vatId);
        return this;
    }

    public void setVatId(String vatId) {
        this.vatId = vatId;
    }

    public String getStreet() {
        return this.street;
    }

    public Resort street(String street) {
        this.setStreet(street);
        return this;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHotelFc() {
        return this.hotelFc;
    }

    public Resort hotelFc(String hotelFc) {
        this.setHotelFc(hotelFc);
        return this;
    }

    public void setHotelFc(String hotelFc) {
        this.hotelFc = hotelFc;
    }

    public String getMeetingFc() {
        return this.meetingFc;
    }

    public Resort meetingFc(String meetingFc) {
        this.setMeetingFc(meetingFc);
        return this;
    }

    public void setMeetingFc(String meetingFc) {
        this.meetingFc = meetingFc;
    }

    public String getArTypewriter() {
        return this.arTypewriter;
    }

    public Resort arTypewriter(String arTypewriter) {
        this.setArTypewriter(arTypewriter);
        return this;
    }

    public void setArTypewriter(String arTypewriter) {
        this.arTypewriter = arTypewriter;
    }

    public String getFileTransferFormat() {
        return this.fileTransferFormat;
    }

    public Resort fileTransferFormat(String fileTransferFormat) {
        this.setFileTransferFormat(fileTransferFormat);
        return this;
    }

    public void setFileTransferFormat(String fileTransferFormat) {
        this.fileTransferFormat = fileTransferFormat;
    }

    public String getConfirmRegcardPrinter() {
        return this.confirmRegcardPrinter;
    }

    public Resort confirmRegcardPrinter(String confirmRegcardPrinter) {
        this.setConfirmRegcardPrinter(confirmRegcardPrinter);
        return this;
    }

    public void setConfirmRegcardPrinter(String confirmRegcardPrinter) {
        this.confirmRegcardPrinter = confirmRegcardPrinter;
    }

    public String getDirections() {
        return this.directions;
    }

    public Resort directions(String directions) {
        this.setDirections(directions);
        return this;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getPropinfoUrl() {
        return this.propinfoUrl;
    }

    public Resort propinfoUrl(String propinfoUrl) {
        this.setPropinfoUrl(propinfoUrl);
        return this;
    }

    public void setPropinfoUrl(String propinfoUrl) {
        this.propinfoUrl = propinfoUrl;
    }

    public String getRoomAmenity() {
        return this.roomAmenity;
    }

    public Resort roomAmenity(String roomAmenity) {
        this.setRoomAmenity(roomAmenity);
        return this;
    }

    public void setRoomAmenity(String roomAmenity) {
        this.roomAmenity = roomAmenity;
    }

    public String getShopDescription() {
        return this.shopDescription;
    }

    public Resort shopDescription(String shopDescription) {
        this.setShopDescription(shopDescription);
        return this;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public String getPropPicUrl() {
        return this.propPicUrl;
    }

    public Resort propPicUrl(String propPicUrl) {
        this.setPropPicUrl(propPicUrl);
        return this;
    }

    public void setPropPicUrl(String propPicUrl) {
        this.propPicUrl = propPicUrl;
    }

    public String getPropMapUrl() {
        return this.propMapUrl;
    }

    public Resort propMapUrl(String propMapUrl) {
        this.setPropMapUrl(propMapUrl);
        return this;
    }

    public void setPropMapUrl(String propMapUrl) {
        this.propMapUrl = propMapUrl;
    }

    public String getExtExpFileLocation() {
        return this.extExpFileLocation;
    }

    public Resort extExpFileLocation(String extExpFileLocation) {
        this.setExtExpFileLocation(extExpFileLocation);
        return this;
    }

    public void setExtExpFileLocation(String extExpFileLocation) {
        this.extExpFileLocation = extExpFileLocation;
    }

    public String getCurtainColor() {
        return this.curtainColor;
    }

    public Resort curtainColor(String curtainColor) {
        this.setCurtainColor(curtainColor);
        return this;
    }

    public void setCurtainColor(String curtainColor) {
        this.curtainColor = curtainColor;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public Resort countryCode(String countryCode) {
        this.setCountryCode(countryCode);
        return this;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getState() {
        return this.state;
    }

    public Resort state(String state) {
        this.setState(state);
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDateForAging() {
        return this.dateForAging;
    }

    public Resort dateForAging(String dateForAging) {
        this.setDateForAging(dateForAging);
        return this;
    }

    public void setDateForAging(String dateForAging) {
        this.dateForAging = dateForAging;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public Resort regionCode(String regionCode) {
        this.setRegionCode(regionCode);
        return this;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getCity() {
        return this.city;
    }

    public Resort city(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public Resort telephone(String telephone) {
        this.setTelephone(telephone);
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return this.fax;
    }

    public Resort fax(String fax) {
        this.setFax(fax);
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTollfree() {
        return this.tollfree;
    }

    public Resort tollfree(String tollfree) {
        this.setTollfree(tollfree);
        return this;
    }

    public void setTollfree(String tollfree) {
        this.tollfree = tollfree;
    }

    public String getDefaultPrinter() {
        return this.defaultPrinter;
    }

    public Resort defaultPrinter(String defaultPrinter) {
        this.setDefaultPrinter(defaultPrinter);
        return this;
    }

    public void setDefaultPrinter(String defaultPrinter) {
        this.defaultPrinter = defaultPrinter;
    }

    public String getVideocheckoutPrinter() {
        return this.videocheckoutPrinter;
    }

    public Resort videocheckoutPrinter(String videocheckoutPrinter) {
        this.setVideocheckoutPrinter(videocheckoutPrinter);
        return this;
    }

    public void setVideocheckoutPrinter(String videocheckoutPrinter) {
        this.videocheckoutPrinter = videocheckoutPrinter;
    }

    public String getCompanyAddressType() {
        return this.companyAddressType;
    }

    public Resort companyAddressType(String companyAddressType) {
        this.setCompanyAddressType(companyAddressType);
        return this;
    }

    public void setCompanyAddressType(String companyAddressType) {
        this.companyAddressType = companyAddressType;
    }

    public String getCompanyPhoneType() {
        return this.companyPhoneType;
    }

    public Resort companyPhoneType(String companyPhoneType) {
        this.setCompanyPhoneType(companyPhoneType);
        return this;
    }

    public void setCompanyPhoneType(String companyPhoneType) {
        this.companyPhoneType = companyPhoneType;
    }

    public String getDefaultFaxType() {
        return this.defaultFaxType;
    }

    public Resort defaultFaxType(String defaultFaxType) {
        this.setDefaultFaxType(defaultFaxType);
        return this;
    }

    public void setDefaultFaxType(String defaultFaxType) {
        this.defaultFaxType = defaultFaxType;
    }

    public String getDefaultMembershipType() {
        return this.defaultMembershipType;
    }

    public Resort defaultMembershipType(String defaultMembershipType) {
        this.setDefaultMembershipType(defaultMembershipType);
        return this;
    }

    public void setDefaultMembershipType(String defaultMembershipType) {
        this.defaultMembershipType = defaultMembershipType;
    }

    public String getIndividualAddressType() {
        return this.individualAddressType;
    }

    public Resort individualAddressType(String individualAddressType) {
        this.setIndividualAddressType(individualAddressType);
        return this;
    }

    public void setIndividualAddressType(String individualAddressType) {
        this.individualAddressType = individualAddressType;
    }

    public String getIndividualPhoneType() {
        return this.individualPhoneType;
    }

    public Resort individualPhoneType(String individualPhoneType) {
        this.setIndividualPhoneType(individualPhoneType);
        return this;
    }

    public void setIndividualPhoneType(String individualPhoneType) {
        this.individualPhoneType = individualPhoneType;
    }

    public String getNotes() {
        return this.notes;
    }

    public Resort notes(String notes) {
        this.setNotes(notes);
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBlackoutPeriodNotes() {
        return this.blackoutPeriodNotes;
    }

    public Resort blackoutPeriodNotes(String blackoutPeriodNotes) {
        this.setBlackoutPeriodNotes(blackoutPeriodNotes);
        return this;
    }

    public void setBlackoutPeriodNotes(String blackoutPeriodNotes) {
        this.blackoutPeriodNotes = blackoutPeriodNotes;
    }

    public String getSglNum() {
        return this.sglNum;
    }

    public Resort sglNum(String sglNum) {
        this.setSglNum(sglNum);
        return this;
    }

    public void setSglNum(String sglNum) {
        this.sglNum = sglNum;
    }

    public String getDblNum() {
        return this.dblNum;
    }

    public Resort dblNum(String dblNum) {
        this.setDblNum(dblNum);
        return this;
    }

    public void setDblNum(String dblNum) {
        this.dblNum = dblNum;
    }

    public String getTplNum() {
        return this.tplNum;
    }

    public Resort tplNum(String tplNum) {
        this.setTplNum(tplNum);
        return this;
    }

    public void setTplNum(String tplNum) {
        this.tplNum = tplNum;
    }

    public String getSuiNum() {
        return this.suiNum;
    }

    public Resort suiNum(String suiNum) {
        this.setSuiNum(suiNum);
        return this;
    }

    public void setSuiNum(String suiNum) {
        this.suiNum = suiNum;
    }

    public String getAirportDistance() {
        return this.airportDistance;
    }

    public Resort airportDistance(String airportDistance) {
        this.setAirportDistance(airportDistance);
        return this;
    }

    public void setAirportDistance(String airportDistance) {
        this.airportDistance = airportDistance;
    }

    public String getAirportTime() {
        return this.airportTime;
    }

    public Resort airportTime(String airportTime) {
        this.setAirportTime(airportTime);
        return this;
    }

    public void setAirportTime(String airportTime) {
        this.airportTime = airportTime;
    }

    public String getBrArea() {
        return this.brArea;
    }

    public Resort brArea(String brArea) {
        this.setBrArea(brArea);
        return this;
    }

    public void setBrArea(String brArea) {
        this.brArea = brArea;
    }

    public String getName() {
        return this.name;
    }

    public Resort name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalOwner() {
        return this.legalOwner;
    }

    public Resort legalOwner(String legalOwner) {
        this.setLegalOwner(legalOwner);
        return this;
    }

    public void setLegalOwner(String legalOwner) {
        this.legalOwner = legalOwner;
    }

    public String getHotelId() {
        return this.hotelId;
    }

    public Resort hotelId(String hotelId) {
        this.setHotelId(hotelId);
        return this;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getFaxNoFormat() {
        return this.faxNoFormat;
    }

    public Resort faxNoFormat(String faxNoFormat) {
        this.setFaxNoFormat(faxNoFormat);
        return this;
    }

    public void setFaxNoFormat(String faxNoFormat) {
        this.faxNoFormat = faxNoFormat;
    }

    public String getTelephoneNoFormat() {
        return this.telephoneNoFormat;
    }

    public Resort telephoneNoFormat(String telephoneNoFormat) {
        this.setTelephoneNoFormat(telephoneNoFormat);
        return this;
    }

    public void setTelephoneNoFormat(String telephoneNoFormat) {
        this.telephoneNoFormat = telephoneNoFormat;
    }

    public String getLocalCurrencyFormat() {
        return this.localCurrencyFormat;
    }

    public Resort localCurrencyFormat(String localCurrencyFormat) {
        this.setLocalCurrencyFormat(localCurrencyFormat);
        return this;
    }

    public void setLocalCurrencyFormat(String localCurrencyFormat) {
        this.localCurrencyFormat = localCurrencyFormat;
    }

    public String getDutyManagerPager() {
        return this.dutyManagerPager;
    }

    public Resort dutyManagerPager(String dutyManagerPager) {
        this.setDutyManagerPager(dutyManagerPager);
        return this;
    }

    public void setDutyManagerPager(String dutyManagerPager) {
        this.dutyManagerPager = dutyManagerPager;
    }

    public String getDefaultRegistrationCard() {
        return this.defaultRegistrationCard;
    }

    public Resort defaultRegistrationCard(String defaultRegistrationCard) {
        this.setDefaultRegistrationCard(defaultRegistrationCard);
        return this;
    }

    public void setDefaultRegistrationCard(String defaultRegistrationCard) {
        this.defaultRegistrationCard = defaultRegistrationCard;
    }

    public String getNightAuditCashierId() {
        return this.nightAuditCashierId;
    }

    public Resort nightAuditCashierId(String nightAuditCashierId) {
        this.setNightAuditCashierId(nightAuditCashierId);
        return this;
    }

    public void setNightAuditCashierId(String nightAuditCashierId) {
        this.nightAuditCashierId = nightAuditCashierId;
    }

    public String getHotelCode() {
        return this.hotelCode;
    }

    public Resort hotelCode(String hotelCode) {
        this.setHotelCode(hotelCode);
        return this;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getPath() {
        return this.path;
    }

    public Resort path(String path) {
        this.setPath(path);
        return this;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTimezoneRegion() {
        return this.timezoneRegion;
    }

    public Resort timezoneRegion(String timezoneRegion) {
        this.setTimezoneRegion(timezoneRegion);
        return this;
    }

    public void setTimezoneRegion(String timezoneRegion) {
        this.timezoneRegion = timezoneRegion;
    }

    public String getCateringCurrencyFormat() {
        return this.cateringCurrencyFormat;
    }

    public Resort cateringCurrencyFormat(String cateringCurrencyFormat) {
        this.setCateringCurrencyFormat(cateringCurrencyFormat);
        return this;
    }

    public void setCateringCurrencyFormat(String cateringCurrencyFormat) {
        this.cateringCurrencyFormat = cateringCurrencyFormat;
    }

    public String getExpHotelCode() {
        return this.expHotelCode;
    }

    public Resort expHotelCode(String expHotelCode) {
        this.setExpHotelCode(expHotelCode);
        return this;
    }

    public void setExpHotelCode(String expHotelCode) {
        this.expHotelCode = expHotelCode;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Resort)) {
            return false;
        }
        return getId() != null && getId().equals(((Resort) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Resort{" +
            "id=" + getId() +
            ", resort='" + getResort() + "'" +
            ", beginDate='" + getBeginDate() + "'" +
            ", checkInTime='" + getCheckInTime() + "'" +
            ", checkOutTime='" + getCheckOutTime() + "'" +
            ", videoCoStart='" + getVideoCoStart() + "'" +
            ", videoCoStop='" + getVideoCoStop() + "'" +
            ", insertDate='" + getInsertDate() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", expiryDate='" + getExpiryDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", fiscalStartDate='" + getFiscalStartDate() + "'" +
            ", fiscalEndDate='" + getFiscalEndDate() + "'" +
            ", reconcileDate='" + getReconcileDate() + "'" +
            ", paymentDate='" + getPaymentDate() + "'" +
            ", keepAvailability=" + getKeepAvailability() +
            ", budgetMonth=" + getBudgetMonth() +
            ", saveProfiles=" + getSaveProfiles() +
            ", longStayControl=" + getLongStayControl() +
            ", creditLimit=" + getCreditLimit() +
            ", numberRooms=" + getNumberRooms() +
            ", numberFloors=" + getNumberFloors() +
            ", numberBeds=" + getNumberBeds() +
            ", rhythmSheets=" + getRhythmSheets() +
            ", rhythmTowels=" + getRhythmTowels() +
            ", warningAmount=" + getWarningAmount() +
            ", decimalPlaces=" + getDecimalPlaces() +
            ", font=" + getFont() +
            ", copies=" + getCopies() +
            ", defaultFolioStyle=" + getDefaultFolioStyle() +
            ", individualRoomWarning=" + getIndividualRoomWarning() +
            ", groupRoomWarning=" + getGroupRoomWarning() +
            ", agingLevel1=" + getAgingLevel1() +
            ", agingLevel2=" + getAgingLevel2() +
            ", agingLevel3=" + getAgingLevel3() +
            ", agingLevel4=" + getAgingLevel4() +
            ", agingLevel5=" + getAgingLevel5() +
            ", zeroInvPurDays=" + getZeroInvPurDays() +
            ", minDaysBet2ReminderLetter=" + getMinDaysBet2ReminderLetter() +
            ", insertUser=" + getInsertUser() +
            ", updateUser=" + getUpdateUser() +
            ", currencyDecimals=" + getCurrencyDecimals() +
            ", nameIdLink=" + getNameIdLink() +
            ", sglRate1=" + getSglRate1() +
            ", sglRate2=" + getSglRate2() +
            ", dblRate1=" + getDblRate1() +
            ", dblRate2=" + getDblRate2() +
            ", tplRate1=" + getTplRate1() +
            ", tplRate2=" + getTplRate2() +
            ", suiRate1=" + getSuiRate1() +
            ", suiRate2=" + getSuiRate2() +
            ", meetSpace=" + getMeetSpace() +
            ", imgHotelId=" + getImgHotelId() +
            ", imgDirectionId=" + getImgDirectionId() +
            ", imgMapId=" + getImgMapId() +
            ", scriptId=" + getScriptId() +
            ", comNameXrefId=" + getComNameXrefId() +
            ", pathId=" + getPathId() +
            ", xresortNumber=" + getXresortNumber() +
            ", maxCreditDays=" + getMaxCreditDays() +
            ", currencyDivisor=" + getCurrencyDivisor() +
            ", latitude=" + getLatitude() +
            ", longitude=" + getLongitude() +
            ", qtySingleRooms=" + getQtySingleRooms() +
            ", qtyDoubleRooms=" + getQtyDoubleRooms() +
            ", qtyTwinRooms=" + getQtyTwinRooms() +
            ", qtySuites=" + getQtySuites() +
            ", qtyGuestRoomFloors=" + getQtyGuestRoomFloors() +
            ", qtyGuestElevators=" + getQtyGuestElevators() +
            ", qtyNonSmokingRooms=" + getQtyNonSmokingRooms() +
            ", qtyConnectingRooms=" + getQtyConnectingRooms() +
            ", qtyHandicappedRooms=" + getQtyHandicappedRooms() +
            ", qtyFamilyRooms=" + getQtyFamilyRooms() +
            ", maxAdultsFamilyRoom=" + getMaxAdultsFamilyRoom() +
            ", maxChildrenFamilyRoom=" + getMaxChildrenFamilyRoom() +
            ", restaurant=" + getRestaurant() +
            ", meetRooms=" + getMeetRooms() +
            ", totRooms=" + getTotRooms() +
            ", brSeats=" + getBrSeats() +
            ", meetSeats=" + getMeetSeats() +
            ", maxNoNights=" + getMaxNoNights() +
            ", awardsTimeout=" + getAwardsTimeout() +
            ", guestLookupTimeout=" + getGuestLookupTimeout() +
            ", wakeUpDelay=" + getWakeUpDelay() +
            ", maxOccupancy=" + getMaxOccupancy() +
            ", inactiveDaysForGuestProfil=" + getInactiveDaysForGuestProfil() +
            ", perReservationRoomLimit=" + getPerReservationRoomLimit() +
            ", licRoomInfo='" + getLicRoomInfo() + "'" +
            ", thousandSeparator='" + getThousandSeparator() + "'" +
            ", dateSeparator='" + getDateSeparator() + "'" +
            ", arAcctNoMandYn='" + getArAcctNoMandYn() + "'" +
            ", exchangePostingType='" + getExchangePostingType() + "'" +
            ", inventoryYn='" + getInventoryYn() + "'" +
            ", allowLoginYn='" + getAllowLoginYn() + "'" +
            ", accessCode='" + getAccessCode() + "'" +
            ", disableLoginYn='" + getDisableLoginYn() + "'" +
            ", intTaxIncludedYn='" + getIntTaxIncludedYn() + "'" +
            ", downloadRestYn='" + getDownloadRestYn() + "'" +
            ", translateMulticharYn='" + getTranslateMulticharYn() + "'" +
            ", externalScYn='" + getExternalScYn() + "'" +
            ", sendLeadAsBookingYn='" + getSendLeadAsBookingYn() + "'" +
            ", mbsSupportedYn='" + getMbsSupportedYn() + "'" +
            ", quotedCurrency='" + getQuotedCurrency() + "'" +
            ", comMethod='" + getComMethod() + "'" +
            ", email='" + getEmail() + "'" +
            ", genmgr='" + getGenmgr() + "'" +
            ", dirsales='" + getDirsales() + "'" +
            ", leadsend='" + getLeadsend() + "'" +
            ", airport='" + getAirport() + "'" +
            ", comAddress='" + getComAddress() + "'" +
            ", season1='" + getSeason1() + "'" +
            ", season2='" + getSeason2() + "'" +
            ", season3='" + getSeason3() + "'" +
            ", season4='" + getSeason4() + "'" +
            ", season5='" + getSeason5() + "'" +
            ", floorNumExecutiveFloor='" + getFloorNumExecutiveFloor() + "'" +
            ", crsResort='" + getCrsResort() + "'" +
            ", postCode='" + getPostCode() + "'" +
            ", defaultReservationType='" + getDefaultReservationType() + "'" +
            ", block='" + getBlock() + "'" +
            ", currencySymbol='" + getCurrencySymbol() + "'" +
            ", sourceCommission='" + getSourceCommission() + "'" +
            ", taCommission='" + getTaCommission() + "'" +
            ", baseLanguage='" + getBaseLanguage() + "'" +
            ", folioLanguage1='" + getFolioLanguage1() + "'" +
            ", folioLanguage2='" + getFolioLanguage2() + "'" +
            ", folioLanguage3='" + getFolioLanguage3() + "'" +
            ", folioLanguage4='" + getFolioLanguage4() + "'" +
            ", packageProfit='" + getPackageProfit() + "'" +
            ", packageLoss='" + getPackageLoss() + "'" +
            ", decimalSeparator='" + getDecimalSeparator() + "'" +
            ", shortDateFormat='" + getShortDateFormat() + "'" +
            ", longDateFormat='" + getLongDateFormat() + "'" +
            ", passerbySource='" + getPasserbySource() + "'" +
            ", passerbyMarket='" + getPasserbyMarket() + "'" +
            ", arCompany='" + getArCompany() + "'" +
            ", arAgent='" + getArAgent() + "'" +
            ", arGroups='" + getArGroups() + "'" +
            ", arIndividuals='" + getArIndividuals() + "'" +
            ", arAcctNoFormat='" + getArAcctNoFormat() + "'" +
            ", allowancePeriodAdj='" + getAllowancePeriodAdj() + "'" +
            ", currencyCode='" + getCurrencyCode() + "'" +
            ", turnawayCode='" + getTurnawayCode() + "'" +
            ", summCurrencyCode='" + getSummCurrencyCode() + "'" +
            ", defaultPropertyAddress='" + getDefaultPropertyAddress() + "'" +
            ", defaultGuestAddress='" + getDefaultGuestAddress() + "'" +
            ", licenseCode='" + getLicenseCode() + "'" +
            ", timeFormat='" + getTimeFormat() + "'" +
            ", chainCode='" + getChainCode() + "'" +
            ", resortType='" + getResortType() + "'" +
            ", hotelType='" + getHotelType() + "'" +
            ", ownership='" + getOwnership() + "'" +
            ", arBalTrxCode='" + getArBalTrxCode() + "'" +
            ", arCreditTrxCode='" + getArCreditTrxCode() + "'" +
            ", arSettleCode='" + getArSettleCode() + "'" +
            ", cashShiftDrop='" + getCashShiftDrop() + "'" +
            ", checkExgPaidout='" + getCheckExgPaidout() + "'" +
            ", checkShiftDrop='" + getCheckShiftDrop() + "'" +
            ", checkTrxcode='" + getCheckTrxcode() + "'" +
            ", currencyExgPaidout='" + getCurrencyExgPaidout() + "'" +
            ", depositLedTrxCode='" + getDepositLedTrxCode() + "'" +
            ", fiscalPeriodType='" + getFiscalPeriodType() + "'" +
            ", defaultCommissionPercentage='" + getDefaultCommissionPercentage() + "'" +
            ", defaultPrepaidComm='" + getDefaultPrepaidComm() + "'" +
            ", defaultTrxCommCode='" + getDefaultTrxCommCode() + "'" +
            ", configurationMode='" + getConfigurationMode() + "'" +
            ", weekendDays='" + getWeekendDays() + "'" +
            ", defaultGroupsRateCode='" + getDefaultGroupsRateCode() + "'" +
            ", defaultPostingRoom='" + getDefaultPostingRoom() + "'" +
            ", dfltPkgTranCode='" + getDfltPkgTranCode() + "'" +
            ", dfltTranCodeRateCode='" + getDfltTranCodeRateCode() + "'" +
            ", defaultRateCode='" + getDefaultRateCode() + "'" +
            ", croCode='" + getCroCode() + "'" +
            ", flowCode='" + getFlowCode() + "'" +
            ", extPropertyCode='" + getExtPropertyCode() + "'" +
            ", opusCurrencyCode='" + getOpusCurrencyCode() + "'" +
            ", destinationId='" + getDestinationId() + "'" +
            ", flags='" + getFlags() + "'" +
            ", touristNumber='" + getTouristNumber() + "'" +
            ", cateringCurrencyCode='" + getCateringCurrencyCode() + "'" +
            ", defaultRatecodeRack='" + getDefaultRatecodeRack() + "'" +
            ", defaultRatecodePcr='" + getDefaultRatecodePcr() + "'" +
            ", fnsTier='" + getFnsTier() + "'" +
            ", brandCode='" + getBrandCode() + "'" +
            ", webaddress='" + getWebaddress() + "'" +
            ", vatId='" + getVatId() + "'" +
            ", street='" + getStreet() + "'" +
            ", hotelFc='" + getHotelFc() + "'" +
            ", meetingFc='" + getMeetingFc() + "'" +
            ", arTypewriter='" + getArTypewriter() + "'" +
            ", fileTransferFormat='" + getFileTransferFormat() + "'" +
            ", confirmRegcardPrinter='" + getConfirmRegcardPrinter() + "'" +
            ", directions='" + getDirections() + "'" +
            ", propinfoUrl='" + getPropinfoUrl() + "'" +
            ", roomAmenity='" + getRoomAmenity() + "'" +
            ", shopDescription='" + getShopDescription() + "'" +
            ", propPicUrl='" + getPropPicUrl() + "'" +
            ", propMapUrl='" + getPropMapUrl() + "'" +
            ", extExpFileLocation='" + getExtExpFileLocation() + "'" +
            ", curtainColor='" + getCurtainColor() + "'" +
            ", countryCode='" + getCountryCode() + "'" +
            ", state='" + getState() + "'" +
            ", dateForAging='" + getDateForAging() + "'" +
            ", regionCode='" + getRegionCode() + "'" +
            ", city='" + getCity() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", fax='" + getFax() + "'" +
            ", tollfree='" + getTollfree() + "'" +
            ", defaultPrinter='" + getDefaultPrinter() + "'" +
            ", videocheckoutPrinter='" + getVideocheckoutPrinter() + "'" +
            ", companyAddressType='" + getCompanyAddressType() + "'" +
            ", companyPhoneType='" + getCompanyPhoneType() + "'" +
            ", defaultFaxType='" + getDefaultFaxType() + "'" +
            ", defaultMembershipType='" + getDefaultMembershipType() + "'" +
            ", individualAddressType='" + getIndividualAddressType() + "'" +
            ", individualPhoneType='" + getIndividualPhoneType() + "'" +
            ", notes='" + getNotes() + "'" +
            ", blackoutPeriodNotes='" + getBlackoutPeriodNotes() + "'" +
            ", sglNum='" + getSglNum() + "'" +
            ", dblNum='" + getDblNum() + "'" +
            ", tplNum='" + getTplNum() + "'" +
            ", suiNum='" + getSuiNum() + "'" +
            ", airportDistance='" + getAirportDistance() + "'" +
            ", airportTime='" + getAirportTime() + "'" +
            ", brArea='" + getBrArea() + "'" +
            ", name='" + getName() + "'" +
            ", legalOwner='" + getLegalOwner() + "'" +
            ", hotelId='" + getHotelId() + "'" +
            ", faxNoFormat='" + getFaxNoFormat() + "'" +
            ", telephoneNoFormat='" + getTelephoneNoFormat() + "'" +
            ", localCurrencyFormat='" + getLocalCurrencyFormat() + "'" +
            ", dutyManagerPager='" + getDutyManagerPager() + "'" +
            ", defaultRegistrationCard='" + getDefaultRegistrationCard() + "'" +
            ", nightAuditCashierId='" + getNightAuditCashierId() + "'" +
            ", hotelCode='" + getHotelCode() + "'" +
            ", path='" + getPath() + "'" +
            ", timezoneRegion='" + getTimezoneRegion() + "'" +
            ", cateringCurrencyFormat='" + getCateringCurrencyFormat() + "'" +
            ", expHotelCode='" + getExpHotelCode() + "'" +
            "}";
    }
}
