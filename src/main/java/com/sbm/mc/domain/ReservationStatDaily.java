package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ReservationStatDaily.
 */
@Entity
@Table(name = "reservation_stat_daily")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReservationStatDaily implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "resort")
    private String resort;

    @Column(name = "business_date")
    private LocalDate businessDate;

    @Column(name = "name_id")
    private Integer nameId;

    @Column(name = "rate_code")
    private String rateCode;

    @Column(name = "source_code")
    private String sourceCode;

    @Column(name = "market_code")
    private String marketCode;

    @Column(name = "room_category")
    private String roomCategory;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "agent_id")
    private Integer agentId;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "source_prof_id")
    private Integer sourceProfId;

    @Column(name = "resv_status")
    private String resvStatus;

    @Column(name = "trunc_begin_date")
    private LocalDate truncBeginDate;

    @Column(name = "trunc_end_date")
    private LocalDate truncEndDate;

    @Column(name = "resv_name_id")
    private Integer resvNameId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "physical_quantity")
    private Integer physicalQuantity;

    @Column(name = "due_out_yn")
    private String dueOutYn;

    @Column(name = "room_resv_status")
    private String roomResvStatus;

    @Column(name = "adults")
    private Integer adults;

    @Column(name = "children")
    private Integer children;

    @Column(name = "room_adults")
    private Integer roomAdults;

    @Column(name = "room_children")
    private Integer roomChildren;

    @Column(name = "primary_yn")
    private Integer primaryYn;

    @Column(name = "allotment_header_id")
    private Integer allotmentHeaderId;

    @Column(name = "room_revenue", precision = 21, scale = 2)
    private BigDecimal roomRevenue;

    @Column(name = "food_revenue", precision = 21, scale = 2)
    private BigDecimal foodRevenue;

    @Column(name = "package_room_revenue", precision = 21, scale = 2)
    private BigDecimal packageRoomRevenue;

    @Column(name = "package_food_revenue", precision = 21, scale = 2)
    private BigDecimal packageFoodRevenue;

    @Column(name = "total_room_tax", precision = 21, scale = 2)
    private BigDecimal totalRoomTax;

    @Column(name = "total_food_tax", precision = 21, scale = 2)
    private BigDecimal totalFoodTax;

    @Column(name = "total_package_revenue", precision = 21, scale = 2)
    private BigDecimal totalPackageRevenue;

    @Column(name = "total_revenue", precision = 21, scale = 2)
    private BigDecimal totalRevenue;

    @Column(name = "total_tax", precision = 21, scale = 2)
    private BigDecimal totalTax;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "original_end_date")
    private LocalDate originalEndDate;

    @Column(name = "walkin_yn")
    private String walkinYn;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "room_class")
    private String roomClass;

    @Column(name = "vip_status")
    private String vipStatus;

    @Column(name = "cancellation_date")
    private LocalDate cancellationDate;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "room")
    private String room;

    @Column(name = "membership_id")
    private Integer membershipId;

    @Column(name = "contact_id")
    private Integer contactId;

    @Column(name = "rate_category")
    private String rateCategory;

    @Column(name = "market_main_group")
    private String marketMainGroup;

    @Column(name = "source_main_group")
    private String sourceMainGroup;

    @Column(name = "channel")
    private String channel;

    @Column(name = "country")
    private String country;

    @Column(name = "region_code")
    private String regionCode;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "psuedo_room_yn")
    private String psuedoRoomYn;

    @Column(name = "adults_tax_free")
    private Integer adultsTaxFree;

    @Column(name = "children_tax_free")
    private Integer childrenTaxFree;

    @Column(name = "stay_rooms")
    private Integer stayRooms;

    @Column(name = "stay_persons")
    private Integer stayPersons;

    @Column(name = "stay_adults")
    private Integer stayAdults;

    @Column(name = "stay_children")
    private Integer stayChildren;

    @Column(name = "arr_rooms")
    private Integer arrRooms;

    @Column(name = "arr_persons")
    private Integer arrPersons;

    @Column(name = "dep_rooms")
    private Integer depRooms;

    @Column(name = "dep_persons")
    private Integer depPersons;

    @Column(name = "day_use_rooms")
    private Integer dayUseRooms;

    @Column(name = "day_use_persons")
    private Integer dayUsePersons;

    @Column(name = "cancelled_rooms")
    private Integer cancelledRooms;

    @Column(name = "cancelled_persons")
    private Integer cancelledPersons;

    @Column(name = "no_show_rooms")
    private Integer noShowRooms;

    @Column(name = "no_show_persons")
    private Integer noShowPersons;

    @Column(name = "single_occupancy")
    private Integer singleOccupancy;

    @Column(name = "multiple_occupancy")
    private Integer multipleOccupancy;

    @Column(name = "cribs")
    private Integer cribs;

    @Column(name = "extra_beds")
    private Integer extraBeds;

    @Column(name = "other_revenue", precision = 21, scale = 2)
    private BigDecimal otherRevenue;

    @Column(name = "package_other_revenue", precision = 21, scale = 2)
    private BigDecimal packageOtherRevenue;

    @Column(name = "total_other_tax", precision = 21, scale = 2)
    private BigDecimal totalOtherTax;

    @Column(name = "country_main_group")
    private String countryMainGroup;

    @Column(name = "state")
    private String state;

    @Column(name = "fiscal_region_code")
    private String fiscalRegionCode;

    @Column(name = "non_revenue", precision = 21, scale = 2)
    private BigDecimal nonRevenue;

    @Column(name = "package_non_revenue", precision = 21, scale = 2)
    private BigDecimal packageNonRevenue;

    @Column(name = "total_non_revenue_tax", precision = 21, scale = 2)
    private BigDecimal totalNonRevenueTax;

    @Column(name = "pr_room_revenue", precision = 21, scale = 2)
    private BigDecimal prRoomRevenue;

    @Column(name = "pr_food_revenue", precision = 21, scale = 2)
    private BigDecimal prFoodRevenue;

    @Column(name = "pr_package_room_revenue", precision = 21, scale = 2)
    private BigDecimal prPackageRoomRevenue;

    @Column(name = "pr_package_food_revenue", precision = 21, scale = 2)
    private BigDecimal prPackageFoodRevenue;

    @Column(name = "pr_total_room_tax", precision = 21, scale = 2)
    private BigDecimal prTotalRoomTax;

    @Column(name = "pr_total_food_tax", precision = 21, scale = 2)
    private BigDecimal prTotalFoodTax;

    @Column(name = "pr_total_package_revenue", precision = 21, scale = 2)
    private BigDecimal prTotalPackageRevenue;

    @Column(name = "pr_total_revenue", precision = 21, scale = 2)
    private BigDecimal prTotalRevenue;

    @Column(name = "pr_total_tax", precision = 21, scale = 2)
    private BigDecimal prTotalTax;

    @Column(name = "pr_other_revenue", precision = 21, scale = 2)
    private BigDecimal prOtherRevenue;

    @Column(name = "pr_package_other_revenue", precision = 21, scale = 2)
    private BigDecimal prPackageOtherRevenue;

    @Column(name = "pr_total_other_tax", precision = 21, scale = 2)
    private BigDecimal prTotalOtherTax;

    @Column(name = "pr_non_revenue", precision = 21, scale = 2)
    private BigDecimal prNonRevenue;

    @Column(name = "pr_package_non_revenue", precision = 21, scale = 2)
    private BigDecimal prPackageNonRevenue;

    @Column(name = "pr_total_non_revenue_tax", precision = 21, scale = 2)
    private BigDecimal prTotalNonRevenueTax;

    @Column(name = "nights")
    private Integer nights;

    @Column(name = "no_of_stays")
    private Integer noOfStays;

    @Column(name = "reservation_nights")
    private Integer reservationNights;

    @Column(name = "reservation_arrivals")
    private Integer reservationArrivals;

    @Column(name = "reservation_no_of_stays")
    private Integer reservationNoOfStays;

    @Column(name = "day_use_reservations")
    private Integer dayUseReservations;

    @Column(name = "cancelled_reservations")
    private Integer cancelledReservations;

    @Column(name = "no_show_reservations")
    private Integer noShowReservations;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "district")
    private String district;

    @Column(name = "cash_room_nts")
    private Integer cashRoomNts;

    @Column(name = "comp_room_nts")
    private Integer compRoomNts;

    @Column(name = "cash_room_revenue", precision = 21, scale = 2)
    private BigDecimal cashRoomRevenue;

    @Column(name = "comp_room_revenue", precision = 21, scale = 2)
    private BigDecimal compRoomRevenue;

    @Column(name = "res_insert_source")
    private String resInsertSource;

    @Column(name = "res_insert_source_type")
    private String resInsertSourceType;

    @Column(name = "children_1")
    private Integer children1;

    @Column(name = "children_2")
    private Integer children2;

    @Column(name = "children_3")
    private Integer children3;

    @Column(name = "children_4")
    private Integer children4;

    @Column(name = "children_5")
    private Integer children5;

    @Column(name = "ff_membership_type")
    private String ffMembershipType;

    @Column(name = "fg_membership_type")
    private String fgMembershipType;

    @Column(name = "promotion_code")
    private String promotionCode;

    @Column(name = "owner_ff_flag")
    private String ownerFfFlag;

    @Column(name = "owner_rental_flag")
    private String ownerRentalFlag;

    @Column(name = "central_currency_code")
    private String centralCurrencyCode;

    @Column(name = "central_exchange_rate", precision = 21, scale = 2)
    private BigDecimal centralExchangeRate;

    @Column(name = "booked_room_category")
    private String bookedRoomCategory;

    @Column(name = "business_date_created")
    private LocalDate businessDateCreated;

    @Column(name = "rate_amount", precision = 21, scale = 2)
    private BigDecimal rateAmount;

    @Column(name = "parent_company_id")
    private Integer parentCompanyId;

    @Column(name = "house_use_yn")
    private String houseUseYn;

    @Column(name = "complimentary_yn")
    private String complimentaryYn;

    @Column(name = "bi_resv_name_id")
    private Integer biResvNameId;

    @Column(name = "adv_food_revenue", precision = 21, scale = 2)
    private BigDecimal advFoodRevenue;

    @Column(name = "adv_non_revenue", precision = 21, scale = 2)
    private BigDecimal advNonRevenue;

    @Column(name = "adv_other_revenue", precision = 21, scale = 2)
    private BigDecimal advOtherRevenue;

    @Column(name = "adv_room_revenue", precision = 21, scale = 2)
    private BigDecimal advRoomRevenue;

    @Column(name = "adv_total_food_tax", precision = 21, scale = 2)
    private BigDecimal advTotalFoodTax;

    @Column(name = "adv_total_non_revenue_tax", precision = 21, scale = 2)
    private BigDecimal advTotalNonRevenueTax;

    @Column(name = "adv_total_other_tax", precision = 21, scale = 2)
    private BigDecimal advTotalOtherTax;

    @Column(name = "adv_total_revenue", precision = 21, scale = 2)
    private BigDecimal advTotalRevenue;

    @Column(name = "adv_total_room_tax", precision = 21, scale = 2)
    private BigDecimal advTotalRoomTax;

    @Column(name = "adv_total_tax", precision = 21, scale = 2)
    private BigDecimal advTotalTax;

    @Column(name = "pr_adv_food_revenue", precision = 21, scale = 2)
    private BigDecimal prAdvFoodRevenue;

    @Column(name = "pr_adv_non_revenue", precision = 21, scale = 2)
    private BigDecimal prAdvNonRevenue;

    @Column(name = "pr_adv_other_revenue", precision = 21, scale = 2)
    private BigDecimal prAdvOtherRevenue;

    @Column(name = "pr_adv_room_revenue", precision = 21, scale = 2)
    private BigDecimal prAdvRoomRevenue;

    @Column(name = "pr_adv_total_food_tax", precision = 21, scale = 2)
    private BigDecimal prAdvTotalFoodTax;

    @Column(name = "pr_adv_total_non_revenue_tax", precision = 21, scale = 2)
    private BigDecimal prAdvTotalNonRevenueTax;

    @Column(name = "pr_adv_total_other_tax", precision = 21, scale = 2)
    private BigDecimal prAdvTotalOtherTax;

    @Column(name = "pr_adv_total_revenue", precision = 21, scale = 2)
    private BigDecimal prAdvTotalRevenue;

    @Column(name = "pr_adv_total_room_tax", precision = 21, scale = 2)
    private BigDecimal prAdvTotalRoomTax;

    @Column(name = "pr_adv_total_tax", precision = 21, scale = 2)
    private BigDecimal prAdvTotalTax;

    @Column(name = "upsold_revenue", precision = 21, scale = 2)
    private BigDecimal upsoldRevenue;

    @Column(name = "flgd_room_revenue", precision = 21, scale = 2)
    private BigDecimal flgdRoomRevenue;

    @Column(name = "flgd_food_revenue", precision = 21, scale = 2)
    private BigDecimal flgdFoodRevenue;

    @Column(name = "flgd_non_revenue", precision = 21, scale = 2)
    private BigDecimal flgdNonRevenue;

    @Column(name = "flgd_other_revenue", precision = 21, scale = 2)
    private BigDecimal flgdOtherRevenue;

    @Column(name = "flgd_total_room_tax", precision = 21, scale = 2)
    private BigDecimal flgdTotalRoomTax;

    @Column(name = "flgd_total_food_tax", precision = 21, scale = 2)
    private BigDecimal flgdTotalFoodTax;

    @Column(name = "flgd_total_non_revenue_tax", precision = 21, scale = 2)
    private BigDecimal flgdTotalNonRevenueTax;

    @Column(name = "flgd_total_other_tax", precision = 21, scale = 2)
    private BigDecimal flgdTotalOtherTax;

    @Column(name = "flgd_total_revenue", precision = 21, scale = 2)
    private BigDecimal flgdTotalRevenue;

    @Column(name = "flgd_total_tax", precision = 21, scale = 2)
    private BigDecimal flgdTotalTax;

    @Column(name = "contact_yn")
    private String contactYn;

    @Column(name = "extended_stay_tier")
    private Integer extendedStayTier;

    @Column(name = "rs_adv_total_revenue", precision = 21, scale = 2)
    private BigDecimal rsAdvTotalRevenue;

    @Column(name = "rs_adv_room_revenue", precision = 21, scale = 2)
    private BigDecimal rsAdvRoomRevenue;

    @Column(name = "rs_adv_food_revenue", precision = 21, scale = 2)
    private BigDecimal rsAdvFoodRevenue;

    @Column(name = "rs_adv_other_revenue", precision = 21, scale = 2)
    private BigDecimal rsAdvOtherRevenue;

    @Column(name = "rs_adv_non_revenue", precision = 21, scale = 2)
    private BigDecimal rsAdvNonRevenue;

    @Column(name = "rs_adv_total_tax", precision = 21, scale = 2)
    private BigDecimal rsAdvTotalTax;

    @Column(name = "rs_adv_room_tax", precision = 21, scale = 2)
    private BigDecimal rsAdvRoomTax;

    @Column(name = "rs_adv_food_tax", precision = 21, scale = 2)
    private BigDecimal rsAdvFoodTax;

    @Column(name = "rs_adv_other_tax", precision = 21, scale = 2)
    private BigDecimal rsAdvOtherTax;

    @Column(name = "rs_adv_non_revenue_tax", precision = 21, scale = 2)
    private BigDecimal rsAdvNonRevenueTax;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "guid")
    private String guid;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ReservationStatDaily id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResort() {
        return this.resort;
    }

    public ReservationStatDaily resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public LocalDate getBusinessDate() {
        return this.businessDate;
    }

    public ReservationStatDaily businessDate(LocalDate businessDate) {
        this.setBusinessDate(businessDate);
        return this;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public Integer getNameId() {
        return this.nameId;
    }

    public ReservationStatDaily nameId(Integer nameId) {
        this.setNameId(nameId);
        return this;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public String getRateCode() {
        return this.rateCode;
    }

    public ReservationStatDaily rateCode(String rateCode) {
        this.setRateCode(rateCode);
        return this;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getSourceCode() {
        return this.sourceCode;
    }

    public ReservationStatDaily sourceCode(String sourceCode) {
        this.setSourceCode(sourceCode);
        return this;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getMarketCode() {
        return this.marketCode;
    }

    public ReservationStatDaily marketCode(String marketCode) {
        this.setMarketCode(marketCode);
        return this;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getRoomCategory() {
        return this.roomCategory;
    }

    public ReservationStatDaily roomCategory(String roomCategory) {
        this.setRoomCategory(roomCategory);
        return this;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Integer getCompanyId() {
        return this.companyId;
    }

    public ReservationStatDaily companyId(Integer companyId) {
        this.setCompanyId(companyId);
        return this;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getAgentId() {
        return this.agentId;
    }

    public ReservationStatDaily agentId(Integer agentId) {
        this.setAgentId(agentId);
        return this;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public ReservationStatDaily groupId(Integer groupId) {
        this.setGroupId(groupId);
        return this;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getSourceProfId() {
        return this.sourceProfId;
    }

    public ReservationStatDaily sourceProfId(Integer sourceProfId) {
        this.setSourceProfId(sourceProfId);
        return this;
    }

    public void setSourceProfId(Integer sourceProfId) {
        this.sourceProfId = sourceProfId;
    }

    public String getResvStatus() {
        return this.resvStatus;
    }

    public ReservationStatDaily resvStatus(String resvStatus) {
        this.setResvStatus(resvStatus);
        return this;
    }

    public void setResvStatus(String resvStatus) {
        this.resvStatus = resvStatus;
    }

    public LocalDate getTruncBeginDate() {
        return this.truncBeginDate;
    }

    public ReservationStatDaily truncBeginDate(LocalDate truncBeginDate) {
        this.setTruncBeginDate(truncBeginDate);
        return this;
    }

    public void setTruncBeginDate(LocalDate truncBeginDate) {
        this.truncBeginDate = truncBeginDate;
    }

    public LocalDate getTruncEndDate() {
        return this.truncEndDate;
    }

    public ReservationStatDaily truncEndDate(LocalDate truncEndDate) {
        this.setTruncEndDate(truncEndDate);
        return this;
    }

    public void setTruncEndDate(LocalDate truncEndDate) {
        this.truncEndDate = truncEndDate;
    }

    public Integer getResvNameId() {
        return this.resvNameId;
    }

    public ReservationStatDaily resvNameId(Integer resvNameId) {
        this.setResvNameId(resvNameId);
        return this;
    }

    public void setResvNameId(Integer resvNameId) {
        this.resvNameId = resvNameId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public ReservationStatDaily quantity(Integer quantity) {
        this.setQuantity(quantity);
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPhysicalQuantity() {
        return this.physicalQuantity;
    }

    public ReservationStatDaily physicalQuantity(Integer physicalQuantity) {
        this.setPhysicalQuantity(physicalQuantity);
        return this;
    }

    public void setPhysicalQuantity(Integer physicalQuantity) {
        this.physicalQuantity = physicalQuantity;
    }

    public String getDueOutYn() {
        return this.dueOutYn;
    }

    public ReservationStatDaily dueOutYn(String dueOutYn) {
        this.setDueOutYn(dueOutYn);
        return this;
    }

    public void setDueOutYn(String dueOutYn) {
        this.dueOutYn = dueOutYn;
    }

    public String getRoomResvStatus() {
        return this.roomResvStatus;
    }

    public ReservationStatDaily roomResvStatus(String roomResvStatus) {
        this.setRoomResvStatus(roomResvStatus);
        return this;
    }

    public void setRoomResvStatus(String roomResvStatus) {
        this.roomResvStatus = roomResvStatus;
    }

    public Integer getAdults() {
        return this.adults;
    }

    public ReservationStatDaily adults(Integer adults) {
        this.setAdults(adults);
        return this;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return this.children;
    }

    public ReservationStatDaily children(Integer children) {
        this.setChildren(children);
        return this;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getRoomAdults() {
        return this.roomAdults;
    }

    public ReservationStatDaily roomAdults(Integer roomAdults) {
        this.setRoomAdults(roomAdults);
        return this;
    }

    public void setRoomAdults(Integer roomAdults) {
        this.roomAdults = roomAdults;
    }

    public Integer getRoomChildren() {
        return this.roomChildren;
    }

    public ReservationStatDaily roomChildren(Integer roomChildren) {
        this.setRoomChildren(roomChildren);
        return this;
    }

    public void setRoomChildren(Integer roomChildren) {
        this.roomChildren = roomChildren;
    }

    public Integer getPrimaryYn() {
        return this.primaryYn;
    }

    public ReservationStatDaily primaryYn(Integer primaryYn) {
        this.setPrimaryYn(primaryYn);
        return this;
    }

    public void setPrimaryYn(Integer primaryYn) {
        this.primaryYn = primaryYn;
    }

    public Integer getAllotmentHeaderId() {
        return this.allotmentHeaderId;
    }

    public ReservationStatDaily allotmentHeaderId(Integer allotmentHeaderId) {
        this.setAllotmentHeaderId(allotmentHeaderId);
        return this;
    }

    public void setAllotmentHeaderId(Integer allotmentHeaderId) {
        this.allotmentHeaderId = allotmentHeaderId;
    }

    public BigDecimal getRoomRevenue() {
        return this.roomRevenue;
    }

    public ReservationStatDaily roomRevenue(BigDecimal roomRevenue) {
        this.setRoomRevenue(roomRevenue);
        return this;
    }

    public void setRoomRevenue(BigDecimal roomRevenue) {
        this.roomRevenue = roomRevenue;
    }

    public BigDecimal getFoodRevenue() {
        return this.foodRevenue;
    }

    public ReservationStatDaily foodRevenue(BigDecimal foodRevenue) {
        this.setFoodRevenue(foodRevenue);
        return this;
    }

    public void setFoodRevenue(BigDecimal foodRevenue) {
        this.foodRevenue = foodRevenue;
    }

    public BigDecimal getPackageRoomRevenue() {
        return this.packageRoomRevenue;
    }

    public ReservationStatDaily packageRoomRevenue(BigDecimal packageRoomRevenue) {
        this.setPackageRoomRevenue(packageRoomRevenue);
        return this;
    }

    public void setPackageRoomRevenue(BigDecimal packageRoomRevenue) {
        this.packageRoomRevenue = packageRoomRevenue;
    }

    public BigDecimal getPackageFoodRevenue() {
        return this.packageFoodRevenue;
    }

    public ReservationStatDaily packageFoodRevenue(BigDecimal packageFoodRevenue) {
        this.setPackageFoodRevenue(packageFoodRevenue);
        return this;
    }

    public void setPackageFoodRevenue(BigDecimal packageFoodRevenue) {
        this.packageFoodRevenue = packageFoodRevenue;
    }

    public BigDecimal getTotalRoomTax() {
        return this.totalRoomTax;
    }

    public ReservationStatDaily totalRoomTax(BigDecimal totalRoomTax) {
        this.setTotalRoomTax(totalRoomTax);
        return this;
    }

    public void setTotalRoomTax(BigDecimal totalRoomTax) {
        this.totalRoomTax = totalRoomTax;
    }

    public BigDecimal getTotalFoodTax() {
        return this.totalFoodTax;
    }

    public ReservationStatDaily totalFoodTax(BigDecimal totalFoodTax) {
        this.setTotalFoodTax(totalFoodTax);
        return this;
    }

    public void setTotalFoodTax(BigDecimal totalFoodTax) {
        this.totalFoodTax = totalFoodTax;
    }

    public BigDecimal getTotalPackageRevenue() {
        return this.totalPackageRevenue;
    }

    public ReservationStatDaily totalPackageRevenue(BigDecimal totalPackageRevenue) {
        this.setTotalPackageRevenue(totalPackageRevenue);
        return this;
    }

    public void setTotalPackageRevenue(BigDecimal totalPackageRevenue) {
        this.totalPackageRevenue = totalPackageRevenue;
    }

    public BigDecimal getTotalRevenue() {
        return this.totalRevenue;
    }

    public ReservationStatDaily totalRevenue(BigDecimal totalRevenue) {
        this.setTotalRevenue(totalRevenue);
        return this;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigDecimal getTotalTax() {
        return this.totalTax;
    }

    public ReservationStatDaily totalTax(BigDecimal totalTax) {
        this.setTotalTax(totalTax);
        return this;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public ReservationStatDaily insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public LocalDate getOriginalEndDate() {
        return this.originalEndDate;
    }

    public ReservationStatDaily originalEndDate(LocalDate originalEndDate) {
        this.setOriginalEndDate(originalEndDate);
        return this;
    }

    public void setOriginalEndDate(LocalDate originalEndDate) {
        this.originalEndDate = originalEndDate;
    }

    public String getWalkinYn() {
        return this.walkinYn;
    }

    public ReservationStatDaily walkinYn(String walkinYn) {
        this.setWalkinYn(walkinYn);
        return this;
    }

    public void setWalkinYn(String walkinYn) {
        this.walkinYn = walkinYn;
    }

    public LocalDate getReservationDate() {
        return this.reservationDate;
    }

    public ReservationStatDaily reservationDate(LocalDate reservationDate) {
        this.setReservationDate(reservationDate);
        return this;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getRoomClass() {
        return this.roomClass;
    }

    public ReservationStatDaily roomClass(String roomClass) {
        this.setRoomClass(roomClass);
        return this;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public String getVipStatus() {
        return this.vipStatus;
    }

    public ReservationStatDaily vipStatus(String vipStatus) {
        this.setVipStatus(vipStatus);
        return this;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }

    public LocalDate getCancellationDate() {
        return this.cancellationDate;
    }

    public ReservationStatDaily cancellationDate(LocalDate cancellationDate) {
        this.setCancellationDate(cancellationDate);
        return this;
    }

    public void setCancellationDate(LocalDate cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public ReservationStatDaily birthDate(LocalDate birthDate) {
        this.setBirthDate(birthDate);
        return this;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRoom() {
        return this.room;
    }

    public ReservationStatDaily room(String room) {
        this.setRoom(room);
        return this;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getMembershipId() {
        return this.membershipId;
    }

    public ReservationStatDaily membershipId(Integer membershipId) {
        this.setMembershipId(membershipId);
        return this;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    public Integer getContactId() {
        return this.contactId;
    }

    public ReservationStatDaily contactId(Integer contactId) {
        this.setContactId(contactId);
        return this;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getRateCategory() {
        return this.rateCategory;
    }

    public ReservationStatDaily rateCategory(String rateCategory) {
        this.setRateCategory(rateCategory);
        return this;
    }

    public void setRateCategory(String rateCategory) {
        this.rateCategory = rateCategory;
    }

    public String getMarketMainGroup() {
        return this.marketMainGroup;
    }

    public ReservationStatDaily marketMainGroup(String marketMainGroup) {
        this.setMarketMainGroup(marketMainGroup);
        return this;
    }

    public void setMarketMainGroup(String marketMainGroup) {
        this.marketMainGroup = marketMainGroup;
    }

    public String getSourceMainGroup() {
        return this.sourceMainGroup;
    }

    public ReservationStatDaily sourceMainGroup(String sourceMainGroup) {
        this.setSourceMainGroup(sourceMainGroup);
        return this;
    }

    public void setSourceMainGroup(String sourceMainGroup) {
        this.sourceMainGroup = sourceMainGroup;
    }

    public String getChannel() {
        return this.channel;
    }

    public ReservationStatDaily channel(String channel) {
        this.setChannel(channel);
        return this;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCountry() {
        return this.country;
    }

    public ReservationStatDaily country(String country) {
        this.setCountry(country);
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public ReservationStatDaily regionCode(String regionCode) {
        this.setRegionCode(regionCode);
        return this;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getNationality() {
        return this.nationality;
    }

    public ReservationStatDaily nationality(String nationality) {
        this.setNationality(nationality);
        return this;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPsuedoRoomYn() {
        return this.psuedoRoomYn;
    }

    public ReservationStatDaily psuedoRoomYn(String psuedoRoomYn) {
        this.setPsuedoRoomYn(psuedoRoomYn);
        return this;
    }

    public void setPsuedoRoomYn(String psuedoRoomYn) {
        this.psuedoRoomYn = psuedoRoomYn;
    }

    public Integer getAdultsTaxFree() {
        return this.adultsTaxFree;
    }

    public ReservationStatDaily adultsTaxFree(Integer adultsTaxFree) {
        this.setAdultsTaxFree(adultsTaxFree);
        return this;
    }

    public void setAdultsTaxFree(Integer adultsTaxFree) {
        this.adultsTaxFree = adultsTaxFree;
    }

    public Integer getChildrenTaxFree() {
        return this.childrenTaxFree;
    }

    public ReservationStatDaily childrenTaxFree(Integer childrenTaxFree) {
        this.setChildrenTaxFree(childrenTaxFree);
        return this;
    }

    public void setChildrenTaxFree(Integer childrenTaxFree) {
        this.childrenTaxFree = childrenTaxFree;
    }

    public Integer getStayRooms() {
        return this.stayRooms;
    }

    public ReservationStatDaily stayRooms(Integer stayRooms) {
        this.setStayRooms(stayRooms);
        return this;
    }

    public void setStayRooms(Integer stayRooms) {
        this.stayRooms = stayRooms;
    }

    public Integer getStayPersons() {
        return this.stayPersons;
    }

    public ReservationStatDaily stayPersons(Integer stayPersons) {
        this.setStayPersons(stayPersons);
        return this;
    }

    public void setStayPersons(Integer stayPersons) {
        this.stayPersons = stayPersons;
    }

    public Integer getStayAdults() {
        return this.stayAdults;
    }

    public ReservationStatDaily stayAdults(Integer stayAdults) {
        this.setStayAdults(stayAdults);
        return this;
    }

    public void setStayAdults(Integer stayAdults) {
        this.stayAdults = stayAdults;
    }

    public Integer getStayChildren() {
        return this.stayChildren;
    }

    public ReservationStatDaily stayChildren(Integer stayChildren) {
        this.setStayChildren(stayChildren);
        return this;
    }

    public void setStayChildren(Integer stayChildren) {
        this.stayChildren = stayChildren;
    }

    public Integer getArrRooms() {
        return this.arrRooms;
    }

    public ReservationStatDaily arrRooms(Integer arrRooms) {
        this.setArrRooms(arrRooms);
        return this;
    }

    public void setArrRooms(Integer arrRooms) {
        this.arrRooms = arrRooms;
    }

    public Integer getArrPersons() {
        return this.arrPersons;
    }

    public ReservationStatDaily arrPersons(Integer arrPersons) {
        this.setArrPersons(arrPersons);
        return this;
    }

    public void setArrPersons(Integer arrPersons) {
        this.arrPersons = arrPersons;
    }

    public Integer getDepRooms() {
        return this.depRooms;
    }

    public ReservationStatDaily depRooms(Integer depRooms) {
        this.setDepRooms(depRooms);
        return this;
    }

    public void setDepRooms(Integer depRooms) {
        this.depRooms = depRooms;
    }

    public Integer getDepPersons() {
        return this.depPersons;
    }

    public ReservationStatDaily depPersons(Integer depPersons) {
        this.setDepPersons(depPersons);
        return this;
    }

    public void setDepPersons(Integer depPersons) {
        this.depPersons = depPersons;
    }

    public Integer getDayUseRooms() {
        return this.dayUseRooms;
    }

    public ReservationStatDaily dayUseRooms(Integer dayUseRooms) {
        this.setDayUseRooms(dayUseRooms);
        return this;
    }

    public void setDayUseRooms(Integer dayUseRooms) {
        this.dayUseRooms = dayUseRooms;
    }

    public Integer getDayUsePersons() {
        return this.dayUsePersons;
    }

    public ReservationStatDaily dayUsePersons(Integer dayUsePersons) {
        this.setDayUsePersons(dayUsePersons);
        return this;
    }

    public void setDayUsePersons(Integer dayUsePersons) {
        this.dayUsePersons = dayUsePersons;
    }

    public Integer getCancelledRooms() {
        return this.cancelledRooms;
    }

    public ReservationStatDaily cancelledRooms(Integer cancelledRooms) {
        this.setCancelledRooms(cancelledRooms);
        return this;
    }

    public void setCancelledRooms(Integer cancelledRooms) {
        this.cancelledRooms = cancelledRooms;
    }

    public Integer getCancelledPersons() {
        return this.cancelledPersons;
    }

    public ReservationStatDaily cancelledPersons(Integer cancelledPersons) {
        this.setCancelledPersons(cancelledPersons);
        return this;
    }

    public void setCancelledPersons(Integer cancelledPersons) {
        this.cancelledPersons = cancelledPersons;
    }

    public Integer getNoShowRooms() {
        return this.noShowRooms;
    }

    public ReservationStatDaily noShowRooms(Integer noShowRooms) {
        this.setNoShowRooms(noShowRooms);
        return this;
    }

    public void setNoShowRooms(Integer noShowRooms) {
        this.noShowRooms = noShowRooms;
    }

    public Integer getNoShowPersons() {
        return this.noShowPersons;
    }

    public ReservationStatDaily noShowPersons(Integer noShowPersons) {
        this.setNoShowPersons(noShowPersons);
        return this;
    }

    public void setNoShowPersons(Integer noShowPersons) {
        this.noShowPersons = noShowPersons;
    }

    public Integer getSingleOccupancy() {
        return this.singleOccupancy;
    }

    public ReservationStatDaily singleOccupancy(Integer singleOccupancy) {
        this.setSingleOccupancy(singleOccupancy);
        return this;
    }

    public void setSingleOccupancy(Integer singleOccupancy) {
        this.singleOccupancy = singleOccupancy;
    }

    public Integer getMultipleOccupancy() {
        return this.multipleOccupancy;
    }

    public ReservationStatDaily multipleOccupancy(Integer multipleOccupancy) {
        this.setMultipleOccupancy(multipleOccupancy);
        return this;
    }

    public void setMultipleOccupancy(Integer multipleOccupancy) {
        this.multipleOccupancy = multipleOccupancy;
    }

    public Integer getCribs() {
        return this.cribs;
    }

    public ReservationStatDaily cribs(Integer cribs) {
        this.setCribs(cribs);
        return this;
    }

    public void setCribs(Integer cribs) {
        this.cribs = cribs;
    }

    public Integer getExtraBeds() {
        return this.extraBeds;
    }

    public ReservationStatDaily extraBeds(Integer extraBeds) {
        this.setExtraBeds(extraBeds);
        return this;
    }

    public void setExtraBeds(Integer extraBeds) {
        this.extraBeds = extraBeds;
    }

    public BigDecimal getOtherRevenue() {
        return this.otherRevenue;
    }

    public ReservationStatDaily otherRevenue(BigDecimal otherRevenue) {
        this.setOtherRevenue(otherRevenue);
        return this;
    }

    public void setOtherRevenue(BigDecimal otherRevenue) {
        this.otherRevenue = otherRevenue;
    }

    public BigDecimal getPackageOtherRevenue() {
        return this.packageOtherRevenue;
    }

    public ReservationStatDaily packageOtherRevenue(BigDecimal packageOtherRevenue) {
        this.setPackageOtherRevenue(packageOtherRevenue);
        return this;
    }

    public void setPackageOtherRevenue(BigDecimal packageOtherRevenue) {
        this.packageOtherRevenue = packageOtherRevenue;
    }

    public BigDecimal getTotalOtherTax() {
        return this.totalOtherTax;
    }

    public ReservationStatDaily totalOtherTax(BigDecimal totalOtherTax) {
        this.setTotalOtherTax(totalOtherTax);
        return this;
    }

    public void setTotalOtherTax(BigDecimal totalOtherTax) {
        this.totalOtherTax = totalOtherTax;
    }

    public String getCountryMainGroup() {
        return this.countryMainGroup;
    }

    public ReservationStatDaily countryMainGroup(String countryMainGroup) {
        this.setCountryMainGroup(countryMainGroup);
        return this;
    }

    public void setCountryMainGroup(String countryMainGroup) {
        this.countryMainGroup = countryMainGroup;
    }

    public String getState() {
        return this.state;
    }

    public ReservationStatDaily state(String state) {
        this.setState(state);
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFiscalRegionCode() {
        return this.fiscalRegionCode;
    }

    public ReservationStatDaily fiscalRegionCode(String fiscalRegionCode) {
        this.setFiscalRegionCode(fiscalRegionCode);
        return this;
    }

    public void setFiscalRegionCode(String fiscalRegionCode) {
        this.fiscalRegionCode = fiscalRegionCode;
    }

    public BigDecimal getNonRevenue() {
        return this.nonRevenue;
    }

    public ReservationStatDaily nonRevenue(BigDecimal nonRevenue) {
        this.setNonRevenue(nonRevenue);
        return this;
    }

    public void setNonRevenue(BigDecimal nonRevenue) {
        this.nonRevenue = nonRevenue;
    }

    public BigDecimal getPackageNonRevenue() {
        return this.packageNonRevenue;
    }

    public ReservationStatDaily packageNonRevenue(BigDecimal packageNonRevenue) {
        this.setPackageNonRevenue(packageNonRevenue);
        return this;
    }

    public void setPackageNonRevenue(BigDecimal packageNonRevenue) {
        this.packageNonRevenue = packageNonRevenue;
    }

    public BigDecimal getTotalNonRevenueTax() {
        return this.totalNonRevenueTax;
    }

    public ReservationStatDaily totalNonRevenueTax(BigDecimal totalNonRevenueTax) {
        this.setTotalNonRevenueTax(totalNonRevenueTax);
        return this;
    }

    public void setTotalNonRevenueTax(BigDecimal totalNonRevenueTax) {
        this.totalNonRevenueTax = totalNonRevenueTax;
    }

    public BigDecimal getPrRoomRevenue() {
        return this.prRoomRevenue;
    }

    public ReservationStatDaily prRoomRevenue(BigDecimal prRoomRevenue) {
        this.setPrRoomRevenue(prRoomRevenue);
        return this;
    }

    public void setPrRoomRevenue(BigDecimal prRoomRevenue) {
        this.prRoomRevenue = prRoomRevenue;
    }

    public BigDecimal getPrFoodRevenue() {
        return this.prFoodRevenue;
    }

    public ReservationStatDaily prFoodRevenue(BigDecimal prFoodRevenue) {
        this.setPrFoodRevenue(prFoodRevenue);
        return this;
    }

    public void setPrFoodRevenue(BigDecimal prFoodRevenue) {
        this.prFoodRevenue = prFoodRevenue;
    }

    public BigDecimal getPrPackageRoomRevenue() {
        return this.prPackageRoomRevenue;
    }

    public ReservationStatDaily prPackageRoomRevenue(BigDecimal prPackageRoomRevenue) {
        this.setPrPackageRoomRevenue(prPackageRoomRevenue);
        return this;
    }

    public void setPrPackageRoomRevenue(BigDecimal prPackageRoomRevenue) {
        this.prPackageRoomRevenue = prPackageRoomRevenue;
    }

    public BigDecimal getPrPackageFoodRevenue() {
        return this.prPackageFoodRevenue;
    }

    public ReservationStatDaily prPackageFoodRevenue(BigDecimal prPackageFoodRevenue) {
        this.setPrPackageFoodRevenue(prPackageFoodRevenue);
        return this;
    }

    public void setPrPackageFoodRevenue(BigDecimal prPackageFoodRevenue) {
        this.prPackageFoodRevenue = prPackageFoodRevenue;
    }

    public BigDecimal getPrTotalRoomTax() {
        return this.prTotalRoomTax;
    }

    public ReservationStatDaily prTotalRoomTax(BigDecimal prTotalRoomTax) {
        this.setPrTotalRoomTax(prTotalRoomTax);
        return this;
    }

    public void setPrTotalRoomTax(BigDecimal prTotalRoomTax) {
        this.prTotalRoomTax = prTotalRoomTax;
    }

    public BigDecimal getPrTotalFoodTax() {
        return this.prTotalFoodTax;
    }

    public ReservationStatDaily prTotalFoodTax(BigDecimal prTotalFoodTax) {
        this.setPrTotalFoodTax(prTotalFoodTax);
        return this;
    }

    public void setPrTotalFoodTax(BigDecimal prTotalFoodTax) {
        this.prTotalFoodTax = prTotalFoodTax;
    }

    public BigDecimal getPrTotalPackageRevenue() {
        return this.prTotalPackageRevenue;
    }

    public ReservationStatDaily prTotalPackageRevenue(BigDecimal prTotalPackageRevenue) {
        this.setPrTotalPackageRevenue(prTotalPackageRevenue);
        return this;
    }

    public void setPrTotalPackageRevenue(BigDecimal prTotalPackageRevenue) {
        this.prTotalPackageRevenue = prTotalPackageRevenue;
    }

    public BigDecimal getPrTotalRevenue() {
        return this.prTotalRevenue;
    }

    public ReservationStatDaily prTotalRevenue(BigDecimal prTotalRevenue) {
        this.setPrTotalRevenue(prTotalRevenue);
        return this;
    }

    public void setPrTotalRevenue(BigDecimal prTotalRevenue) {
        this.prTotalRevenue = prTotalRevenue;
    }

    public BigDecimal getPrTotalTax() {
        return this.prTotalTax;
    }

    public ReservationStatDaily prTotalTax(BigDecimal prTotalTax) {
        this.setPrTotalTax(prTotalTax);
        return this;
    }

    public void setPrTotalTax(BigDecimal prTotalTax) {
        this.prTotalTax = prTotalTax;
    }

    public BigDecimal getPrOtherRevenue() {
        return this.prOtherRevenue;
    }

    public ReservationStatDaily prOtherRevenue(BigDecimal prOtherRevenue) {
        this.setPrOtherRevenue(prOtherRevenue);
        return this;
    }

    public void setPrOtherRevenue(BigDecimal prOtherRevenue) {
        this.prOtherRevenue = prOtherRevenue;
    }

    public BigDecimal getPrPackageOtherRevenue() {
        return this.prPackageOtherRevenue;
    }

    public ReservationStatDaily prPackageOtherRevenue(BigDecimal prPackageOtherRevenue) {
        this.setPrPackageOtherRevenue(prPackageOtherRevenue);
        return this;
    }

    public void setPrPackageOtherRevenue(BigDecimal prPackageOtherRevenue) {
        this.prPackageOtherRevenue = prPackageOtherRevenue;
    }

    public BigDecimal getPrTotalOtherTax() {
        return this.prTotalOtherTax;
    }

    public ReservationStatDaily prTotalOtherTax(BigDecimal prTotalOtherTax) {
        this.setPrTotalOtherTax(prTotalOtherTax);
        return this;
    }

    public void setPrTotalOtherTax(BigDecimal prTotalOtherTax) {
        this.prTotalOtherTax = prTotalOtherTax;
    }

    public BigDecimal getPrNonRevenue() {
        return this.prNonRevenue;
    }

    public ReservationStatDaily prNonRevenue(BigDecimal prNonRevenue) {
        this.setPrNonRevenue(prNonRevenue);
        return this;
    }

    public void setPrNonRevenue(BigDecimal prNonRevenue) {
        this.prNonRevenue = prNonRevenue;
    }

    public BigDecimal getPrPackageNonRevenue() {
        return this.prPackageNonRevenue;
    }

    public ReservationStatDaily prPackageNonRevenue(BigDecimal prPackageNonRevenue) {
        this.setPrPackageNonRevenue(prPackageNonRevenue);
        return this;
    }

    public void setPrPackageNonRevenue(BigDecimal prPackageNonRevenue) {
        this.prPackageNonRevenue = prPackageNonRevenue;
    }

    public BigDecimal getPrTotalNonRevenueTax() {
        return this.prTotalNonRevenueTax;
    }

    public ReservationStatDaily prTotalNonRevenueTax(BigDecimal prTotalNonRevenueTax) {
        this.setPrTotalNonRevenueTax(prTotalNonRevenueTax);
        return this;
    }

    public void setPrTotalNonRevenueTax(BigDecimal prTotalNonRevenueTax) {
        this.prTotalNonRevenueTax = prTotalNonRevenueTax;
    }

    public Integer getNights() {
        return this.nights;
    }

    public ReservationStatDaily nights(Integer nights) {
        this.setNights(nights);
        return this;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }

    public Integer getNoOfStays() {
        return this.noOfStays;
    }

    public ReservationStatDaily noOfStays(Integer noOfStays) {
        this.setNoOfStays(noOfStays);
        return this;
    }

    public void setNoOfStays(Integer noOfStays) {
        this.noOfStays = noOfStays;
    }

    public Integer getReservationNights() {
        return this.reservationNights;
    }

    public ReservationStatDaily reservationNights(Integer reservationNights) {
        this.setReservationNights(reservationNights);
        return this;
    }

    public void setReservationNights(Integer reservationNights) {
        this.reservationNights = reservationNights;
    }

    public Integer getReservationArrivals() {
        return this.reservationArrivals;
    }

    public ReservationStatDaily reservationArrivals(Integer reservationArrivals) {
        this.setReservationArrivals(reservationArrivals);
        return this;
    }

    public void setReservationArrivals(Integer reservationArrivals) {
        this.reservationArrivals = reservationArrivals;
    }

    public Integer getReservationNoOfStays() {
        return this.reservationNoOfStays;
    }

    public ReservationStatDaily reservationNoOfStays(Integer reservationNoOfStays) {
        this.setReservationNoOfStays(reservationNoOfStays);
        return this;
    }

    public void setReservationNoOfStays(Integer reservationNoOfStays) {
        this.reservationNoOfStays = reservationNoOfStays;
    }

    public Integer getDayUseReservations() {
        return this.dayUseReservations;
    }

    public ReservationStatDaily dayUseReservations(Integer dayUseReservations) {
        this.setDayUseReservations(dayUseReservations);
        return this;
    }

    public void setDayUseReservations(Integer dayUseReservations) {
        this.dayUseReservations = dayUseReservations;
    }

    public Integer getCancelledReservations() {
        return this.cancelledReservations;
    }

    public ReservationStatDaily cancelledReservations(Integer cancelledReservations) {
        this.setCancelledReservations(cancelledReservations);
        return this;
    }

    public void setCancelledReservations(Integer cancelledReservations) {
        this.cancelledReservations = cancelledReservations;
    }

    public Integer getNoShowReservations() {
        return this.noShowReservations;
    }

    public ReservationStatDaily noShowReservations(Integer noShowReservations) {
        this.setNoShowReservations(noShowReservations);
        return this;
    }

    public void setNoShowReservations(Integer noShowReservations) {
        this.noShowReservations = noShowReservations;
    }

    public String getCity() {
        return this.city;
    }

    public ReservationStatDaily city(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public ReservationStatDaily zipCode(String zipCode) {
        this.setZipCode(zipCode);
        return this;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDistrict() {
        return this.district;
    }

    public ReservationStatDaily district(String district) {
        this.setDistrict(district);
        return this;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getCashRoomNts() {
        return this.cashRoomNts;
    }

    public ReservationStatDaily cashRoomNts(Integer cashRoomNts) {
        this.setCashRoomNts(cashRoomNts);
        return this;
    }

    public void setCashRoomNts(Integer cashRoomNts) {
        this.cashRoomNts = cashRoomNts;
    }

    public Integer getCompRoomNts() {
        return this.compRoomNts;
    }

    public ReservationStatDaily compRoomNts(Integer compRoomNts) {
        this.setCompRoomNts(compRoomNts);
        return this;
    }

    public void setCompRoomNts(Integer compRoomNts) {
        this.compRoomNts = compRoomNts;
    }

    public BigDecimal getCashRoomRevenue() {
        return this.cashRoomRevenue;
    }

    public ReservationStatDaily cashRoomRevenue(BigDecimal cashRoomRevenue) {
        this.setCashRoomRevenue(cashRoomRevenue);
        return this;
    }

    public void setCashRoomRevenue(BigDecimal cashRoomRevenue) {
        this.cashRoomRevenue = cashRoomRevenue;
    }

    public BigDecimal getCompRoomRevenue() {
        return this.compRoomRevenue;
    }

    public ReservationStatDaily compRoomRevenue(BigDecimal compRoomRevenue) {
        this.setCompRoomRevenue(compRoomRevenue);
        return this;
    }

    public void setCompRoomRevenue(BigDecimal compRoomRevenue) {
        this.compRoomRevenue = compRoomRevenue;
    }

    public String getResInsertSource() {
        return this.resInsertSource;
    }

    public ReservationStatDaily resInsertSource(String resInsertSource) {
        this.setResInsertSource(resInsertSource);
        return this;
    }

    public void setResInsertSource(String resInsertSource) {
        this.resInsertSource = resInsertSource;
    }

    public String getResInsertSourceType() {
        return this.resInsertSourceType;
    }

    public ReservationStatDaily resInsertSourceType(String resInsertSourceType) {
        this.setResInsertSourceType(resInsertSourceType);
        return this;
    }

    public void setResInsertSourceType(String resInsertSourceType) {
        this.resInsertSourceType = resInsertSourceType;
    }

    public Integer getChildren1() {
        return this.children1;
    }

    public ReservationStatDaily children1(Integer children1) {
        this.setChildren1(children1);
        return this;
    }

    public void setChildren1(Integer children1) {
        this.children1 = children1;
    }

    public Integer getChildren2() {
        return this.children2;
    }

    public ReservationStatDaily children2(Integer children2) {
        this.setChildren2(children2);
        return this;
    }

    public void setChildren2(Integer children2) {
        this.children2 = children2;
    }

    public Integer getChildren3() {
        return this.children3;
    }

    public ReservationStatDaily children3(Integer children3) {
        this.setChildren3(children3);
        return this;
    }

    public void setChildren3(Integer children3) {
        this.children3 = children3;
    }

    public Integer getChildren4() {
        return this.children4;
    }

    public ReservationStatDaily children4(Integer children4) {
        this.setChildren4(children4);
        return this;
    }

    public void setChildren4(Integer children4) {
        this.children4 = children4;
    }

    public Integer getChildren5() {
        return this.children5;
    }

    public ReservationStatDaily children5(Integer children5) {
        this.setChildren5(children5);
        return this;
    }

    public void setChildren5(Integer children5) {
        this.children5 = children5;
    }

    public String getFfMembershipType() {
        return this.ffMembershipType;
    }

    public ReservationStatDaily ffMembershipType(String ffMembershipType) {
        this.setFfMembershipType(ffMembershipType);
        return this;
    }

    public void setFfMembershipType(String ffMembershipType) {
        this.ffMembershipType = ffMembershipType;
    }

    public String getFgMembershipType() {
        return this.fgMembershipType;
    }

    public ReservationStatDaily fgMembershipType(String fgMembershipType) {
        this.setFgMembershipType(fgMembershipType);
        return this;
    }

    public void setFgMembershipType(String fgMembershipType) {
        this.fgMembershipType = fgMembershipType;
    }

    public String getPromotionCode() {
        return this.promotionCode;
    }

    public ReservationStatDaily promotionCode(String promotionCode) {
        this.setPromotionCode(promotionCode);
        return this;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getOwnerFfFlag() {
        return this.ownerFfFlag;
    }

    public ReservationStatDaily ownerFfFlag(String ownerFfFlag) {
        this.setOwnerFfFlag(ownerFfFlag);
        return this;
    }

    public void setOwnerFfFlag(String ownerFfFlag) {
        this.ownerFfFlag = ownerFfFlag;
    }

    public String getOwnerRentalFlag() {
        return this.ownerRentalFlag;
    }

    public ReservationStatDaily ownerRentalFlag(String ownerRentalFlag) {
        this.setOwnerRentalFlag(ownerRentalFlag);
        return this;
    }

    public void setOwnerRentalFlag(String ownerRentalFlag) {
        this.ownerRentalFlag = ownerRentalFlag;
    }

    public String getCentralCurrencyCode() {
        return this.centralCurrencyCode;
    }

    public ReservationStatDaily centralCurrencyCode(String centralCurrencyCode) {
        this.setCentralCurrencyCode(centralCurrencyCode);
        return this;
    }

    public void setCentralCurrencyCode(String centralCurrencyCode) {
        this.centralCurrencyCode = centralCurrencyCode;
    }

    public BigDecimal getCentralExchangeRate() {
        return this.centralExchangeRate;
    }

    public ReservationStatDaily centralExchangeRate(BigDecimal centralExchangeRate) {
        this.setCentralExchangeRate(centralExchangeRate);
        return this;
    }

    public void setCentralExchangeRate(BigDecimal centralExchangeRate) {
        this.centralExchangeRate = centralExchangeRate;
    }

    public String getBookedRoomCategory() {
        return this.bookedRoomCategory;
    }

    public ReservationStatDaily bookedRoomCategory(String bookedRoomCategory) {
        this.setBookedRoomCategory(bookedRoomCategory);
        return this;
    }

    public void setBookedRoomCategory(String bookedRoomCategory) {
        this.bookedRoomCategory = bookedRoomCategory;
    }

    public LocalDate getBusinessDateCreated() {
        return this.businessDateCreated;
    }

    public ReservationStatDaily businessDateCreated(LocalDate businessDateCreated) {
        this.setBusinessDateCreated(businessDateCreated);
        return this;
    }

    public void setBusinessDateCreated(LocalDate businessDateCreated) {
        this.businessDateCreated = businessDateCreated;
    }

    public BigDecimal getRateAmount() {
        return this.rateAmount;
    }

    public ReservationStatDaily rateAmount(BigDecimal rateAmount) {
        this.setRateAmount(rateAmount);
        return this;
    }

    public void setRateAmount(BigDecimal rateAmount) {
        this.rateAmount = rateAmount;
    }

    public Integer getParentCompanyId() {
        return this.parentCompanyId;
    }

    public ReservationStatDaily parentCompanyId(Integer parentCompanyId) {
        this.setParentCompanyId(parentCompanyId);
        return this;
    }

    public void setParentCompanyId(Integer parentCompanyId) {
        this.parentCompanyId = parentCompanyId;
    }

    public String getHouseUseYn() {
        return this.houseUseYn;
    }

    public ReservationStatDaily houseUseYn(String houseUseYn) {
        this.setHouseUseYn(houseUseYn);
        return this;
    }

    public void setHouseUseYn(String houseUseYn) {
        this.houseUseYn = houseUseYn;
    }

    public String getComplimentaryYn() {
        return this.complimentaryYn;
    }

    public ReservationStatDaily complimentaryYn(String complimentaryYn) {
        this.setComplimentaryYn(complimentaryYn);
        return this;
    }

    public void setComplimentaryYn(String complimentaryYn) {
        this.complimentaryYn = complimentaryYn;
    }

    public Integer getBiResvNameId() {
        return this.biResvNameId;
    }

    public ReservationStatDaily biResvNameId(Integer biResvNameId) {
        this.setBiResvNameId(biResvNameId);
        return this;
    }

    public void setBiResvNameId(Integer biResvNameId) {
        this.biResvNameId = biResvNameId;
    }

    public BigDecimal getAdvFoodRevenue() {
        return this.advFoodRevenue;
    }

    public ReservationStatDaily advFoodRevenue(BigDecimal advFoodRevenue) {
        this.setAdvFoodRevenue(advFoodRevenue);
        return this;
    }

    public void setAdvFoodRevenue(BigDecimal advFoodRevenue) {
        this.advFoodRevenue = advFoodRevenue;
    }

    public BigDecimal getAdvNonRevenue() {
        return this.advNonRevenue;
    }

    public ReservationStatDaily advNonRevenue(BigDecimal advNonRevenue) {
        this.setAdvNonRevenue(advNonRevenue);
        return this;
    }

    public void setAdvNonRevenue(BigDecimal advNonRevenue) {
        this.advNonRevenue = advNonRevenue;
    }

    public BigDecimal getAdvOtherRevenue() {
        return this.advOtherRevenue;
    }

    public ReservationStatDaily advOtherRevenue(BigDecimal advOtherRevenue) {
        this.setAdvOtherRevenue(advOtherRevenue);
        return this;
    }

    public void setAdvOtherRevenue(BigDecimal advOtherRevenue) {
        this.advOtherRevenue = advOtherRevenue;
    }

    public BigDecimal getAdvRoomRevenue() {
        return this.advRoomRevenue;
    }

    public ReservationStatDaily advRoomRevenue(BigDecimal advRoomRevenue) {
        this.setAdvRoomRevenue(advRoomRevenue);
        return this;
    }

    public void setAdvRoomRevenue(BigDecimal advRoomRevenue) {
        this.advRoomRevenue = advRoomRevenue;
    }

    public BigDecimal getAdvTotalFoodTax() {
        return this.advTotalFoodTax;
    }

    public ReservationStatDaily advTotalFoodTax(BigDecimal advTotalFoodTax) {
        this.setAdvTotalFoodTax(advTotalFoodTax);
        return this;
    }

    public void setAdvTotalFoodTax(BigDecimal advTotalFoodTax) {
        this.advTotalFoodTax = advTotalFoodTax;
    }

    public BigDecimal getAdvTotalNonRevenueTax() {
        return this.advTotalNonRevenueTax;
    }

    public ReservationStatDaily advTotalNonRevenueTax(BigDecimal advTotalNonRevenueTax) {
        this.setAdvTotalNonRevenueTax(advTotalNonRevenueTax);
        return this;
    }

    public void setAdvTotalNonRevenueTax(BigDecimal advTotalNonRevenueTax) {
        this.advTotalNonRevenueTax = advTotalNonRevenueTax;
    }

    public BigDecimal getAdvTotalOtherTax() {
        return this.advTotalOtherTax;
    }

    public ReservationStatDaily advTotalOtherTax(BigDecimal advTotalOtherTax) {
        this.setAdvTotalOtherTax(advTotalOtherTax);
        return this;
    }

    public void setAdvTotalOtherTax(BigDecimal advTotalOtherTax) {
        this.advTotalOtherTax = advTotalOtherTax;
    }

    public BigDecimal getAdvTotalRevenue() {
        return this.advTotalRevenue;
    }

    public ReservationStatDaily advTotalRevenue(BigDecimal advTotalRevenue) {
        this.setAdvTotalRevenue(advTotalRevenue);
        return this;
    }

    public void setAdvTotalRevenue(BigDecimal advTotalRevenue) {
        this.advTotalRevenue = advTotalRevenue;
    }

    public BigDecimal getAdvTotalRoomTax() {
        return this.advTotalRoomTax;
    }

    public ReservationStatDaily advTotalRoomTax(BigDecimal advTotalRoomTax) {
        this.setAdvTotalRoomTax(advTotalRoomTax);
        return this;
    }

    public void setAdvTotalRoomTax(BigDecimal advTotalRoomTax) {
        this.advTotalRoomTax = advTotalRoomTax;
    }

    public BigDecimal getAdvTotalTax() {
        return this.advTotalTax;
    }

    public ReservationStatDaily advTotalTax(BigDecimal advTotalTax) {
        this.setAdvTotalTax(advTotalTax);
        return this;
    }

    public void setAdvTotalTax(BigDecimal advTotalTax) {
        this.advTotalTax = advTotalTax;
    }

    public BigDecimal getPrAdvFoodRevenue() {
        return this.prAdvFoodRevenue;
    }

    public ReservationStatDaily prAdvFoodRevenue(BigDecimal prAdvFoodRevenue) {
        this.setPrAdvFoodRevenue(prAdvFoodRevenue);
        return this;
    }

    public void setPrAdvFoodRevenue(BigDecimal prAdvFoodRevenue) {
        this.prAdvFoodRevenue = prAdvFoodRevenue;
    }

    public BigDecimal getPrAdvNonRevenue() {
        return this.prAdvNonRevenue;
    }

    public ReservationStatDaily prAdvNonRevenue(BigDecimal prAdvNonRevenue) {
        this.setPrAdvNonRevenue(prAdvNonRevenue);
        return this;
    }

    public void setPrAdvNonRevenue(BigDecimal prAdvNonRevenue) {
        this.prAdvNonRevenue = prAdvNonRevenue;
    }

    public BigDecimal getPrAdvOtherRevenue() {
        return this.prAdvOtherRevenue;
    }

    public ReservationStatDaily prAdvOtherRevenue(BigDecimal prAdvOtherRevenue) {
        this.setPrAdvOtherRevenue(prAdvOtherRevenue);
        return this;
    }

    public void setPrAdvOtherRevenue(BigDecimal prAdvOtherRevenue) {
        this.prAdvOtherRevenue = prAdvOtherRevenue;
    }

    public BigDecimal getPrAdvRoomRevenue() {
        return this.prAdvRoomRevenue;
    }

    public ReservationStatDaily prAdvRoomRevenue(BigDecimal prAdvRoomRevenue) {
        this.setPrAdvRoomRevenue(prAdvRoomRevenue);
        return this;
    }

    public void setPrAdvRoomRevenue(BigDecimal prAdvRoomRevenue) {
        this.prAdvRoomRevenue = prAdvRoomRevenue;
    }

    public BigDecimal getPrAdvTotalFoodTax() {
        return this.prAdvTotalFoodTax;
    }

    public ReservationStatDaily prAdvTotalFoodTax(BigDecimal prAdvTotalFoodTax) {
        this.setPrAdvTotalFoodTax(prAdvTotalFoodTax);
        return this;
    }

    public void setPrAdvTotalFoodTax(BigDecimal prAdvTotalFoodTax) {
        this.prAdvTotalFoodTax = prAdvTotalFoodTax;
    }

    public BigDecimal getPrAdvTotalNonRevenueTax() {
        return this.prAdvTotalNonRevenueTax;
    }

    public ReservationStatDaily prAdvTotalNonRevenueTax(BigDecimal prAdvTotalNonRevenueTax) {
        this.setPrAdvTotalNonRevenueTax(prAdvTotalNonRevenueTax);
        return this;
    }

    public void setPrAdvTotalNonRevenueTax(BigDecimal prAdvTotalNonRevenueTax) {
        this.prAdvTotalNonRevenueTax = prAdvTotalNonRevenueTax;
    }

    public BigDecimal getPrAdvTotalOtherTax() {
        return this.prAdvTotalOtherTax;
    }

    public ReservationStatDaily prAdvTotalOtherTax(BigDecimal prAdvTotalOtherTax) {
        this.setPrAdvTotalOtherTax(prAdvTotalOtherTax);
        return this;
    }

    public void setPrAdvTotalOtherTax(BigDecimal prAdvTotalOtherTax) {
        this.prAdvTotalOtherTax = prAdvTotalOtherTax;
    }

    public BigDecimal getPrAdvTotalRevenue() {
        return this.prAdvTotalRevenue;
    }

    public ReservationStatDaily prAdvTotalRevenue(BigDecimal prAdvTotalRevenue) {
        this.setPrAdvTotalRevenue(prAdvTotalRevenue);
        return this;
    }

    public void setPrAdvTotalRevenue(BigDecimal prAdvTotalRevenue) {
        this.prAdvTotalRevenue = prAdvTotalRevenue;
    }

    public BigDecimal getPrAdvTotalRoomTax() {
        return this.prAdvTotalRoomTax;
    }

    public ReservationStatDaily prAdvTotalRoomTax(BigDecimal prAdvTotalRoomTax) {
        this.setPrAdvTotalRoomTax(prAdvTotalRoomTax);
        return this;
    }

    public void setPrAdvTotalRoomTax(BigDecimal prAdvTotalRoomTax) {
        this.prAdvTotalRoomTax = prAdvTotalRoomTax;
    }

    public BigDecimal getPrAdvTotalTax() {
        return this.prAdvTotalTax;
    }

    public ReservationStatDaily prAdvTotalTax(BigDecimal prAdvTotalTax) {
        this.setPrAdvTotalTax(prAdvTotalTax);
        return this;
    }

    public void setPrAdvTotalTax(BigDecimal prAdvTotalTax) {
        this.prAdvTotalTax = prAdvTotalTax;
    }

    public BigDecimal getUpsoldRevenue() {
        return this.upsoldRevenue;
    }

    public ReservationStatDaily upsoldRevenue(BigDecimal upsoldRevenue) {
        this.setUpsoldRevenue(upsoldRevenue);
        return this;
    }

    public void setUpsoldRevenue(BigDecimal upsoldRevenue) {
        this.upsoldRevenue = upsoldRevenue;
    }

    public BigDecimal getFlgdRoomRevenue() {
        return this.flgdRoomRevenue;
    }

    public ReservationStatDaily flgdRoomRevenue(BigDecimal flgdRoomRevenue) {
        this.setFlgdRoomRevenue(flgdRoomRevenue);
        return this;
    }

    public void setFlgdRoomRevenue(BigDecimal flgdRoomRevenue) {
        this.flgdRoomRevenue = flgdRoomRevenue;
    }

    public BigDecimal getFlgdFoodRevenue() {
        return this.flgdFoodRevenue;
    }

    public ReservationStatDaily flgdFoodRevenue(BigDecimal flgdFoodRevenue) {
        this.setFlgdFoodRevenue(flgdFoodRevenue);
        return this;
    }

    public void setFlgdFoodRevenue(BigDecimal flgdFoodRevenue) {
        this.flgdFoodRevenue = flgdFoodRevenue;
    }

    public BigDecimal getFlgdNonRevenue() {
        return this.flgdNonRevenue;
    }

    public ReservationStatDaily flgdNonRevenue(BigDecimal flgdNonRevenue) {
        this.setFlgdNonRevenue(flgdNonRevenue);
        return this;
    }

    public void setFlgdNonRevenue(BigDecimal flgdNonRevenue) {
        this.flgdNonRevenue = flgdNonRevenue;
    }

    public BigDecimal getFlgdOtherRevenue() {
        return this.flgdOtherRevenue;
    }

    public ReservationStatDaily flgdOtherRevenue(BigDecimal flgdOtherRevenue) {
        this.setFlgdOtherRevenue(flgdOtherRevenue);
        return this;
    }

    public void setFlgdOtherRevenue(BigDecimal flgdOtherRevenue) {
        this.flgdOtherRevenue = flgdOtherRevenue;
    }

    public BigDecimal getFlgdTotalRoomTax() {
        return this.flgdTotalRoomTax;
    }

    public ReservationStatDaily flgdTotalRoomTax(BigDecimal flgdTotalRoomTax) {
        this.setFlgdTotalRoomTax(flgdTotalRoomTax);
        return this;
    }

    public void setFlgdTotalRoomTax(BigDecimal flgdTotalRoomTax) {
        this.flgdTotalRoomTax = flgdTotalRoomTax;
    }

    public BigDecimal getFlgdTotalFoodTax() {
        return this.flgdTotalFoodTax;
    }

    public ReservationStatDaily flgdTotalFoodTax(BigDecimal flgdTotalFoodTax) {
        this.setFlgdTotalFoodTax(flgdTotalFoodTax);
        return this;
    }

    public void setFlgdTotalFoodTax(BigDecimal flgdTotalFoodTax) {
        this.flgdTotalFoodTax = flgdTotalFoodTax;
    }

    public BigDecimal getFlgdTotalNonRevenueTax() {
        return this.flgdTotalNonRevenueTax;
    }

    public ReservationStatDaily flgdTotalNonRevenueTax(BigDecimal flgdTotalNonRevenueTax) {
        this.setFlgdTotalNonRevenueTax(flgdTotalNonRevenueTax);
        return this;
    }

    public void setFlgdTotalNonRevenueTax(BigDecimal flgdTotalNonRevenueTax) {
        this.flgdTotalNonRevenueTax = flgdTotalNonRevenueTax;
    }

    public BigDecimal getFlgdTotalOtherTax() {
        return this.flgdTotalOtherTax;
    }

    public ReservationStatDaily flgdTotalOtherTax(BigDecimal flgdTotalOtherTax) {
        this.setFlgdTotalOtherTax(flgdTotalOtherTax);
        return this;
    }

    public void setFlgdTotalOtherTax(BigDecimal flgdTotalOtherTax) {
        this.flgdTotalOtherTax = flgdTotalOtherTax;
    }

    public BigDecimal getFlgdTotalRevenue() {
        return this.flgdTotalRevenue;
    }

    public ReservationStatDaily flgdTotalRevenue(BigDecimal flgdTotalRevenue) {
        this.setFlgdTotalRevenue(flgdTotalRevenue);
        return this;
    }

    public void setFlgdTotalRevenue(BigDecimal flgdTotalRevenue) {
        this.flgdTotalRevenue = flgdTotalRevenue;
    }

    public BigDecimal getFlgdTotalTax() {
        return this.flgdTotalTax;
    }

    public ReservationStatDaily flgdTotalTax(BigDecimal flgdTotalTax) {
        this.setFlgdTotalTax(flgdTotalTax);
        return this;
    }

    public void setFlgdTotalTax(BigDecimal flgdTotalTax) {
        this.flgdTotalTax = flgdTotalTax;
    }

    public String getContactYn() {
        return this.contactYn;
    }

    public ReservationStatDaily contactYn(String contactYn) {
        this.setContactYn(contactYn);
        return this;
    }

    public void setContactYn(String contactYn) {
        this.contactYn = contactYn;
    }

    public Integer getExtendedStayTier() {
        return this.extendedStayTier;
    }

    public ReservationStatDaily extendedStayTier(Integer extendedStayTier) {
        this.setExtendedStayTier(extendedStayTier);
        return this;
    }

    public void setExtendedStayTier(Integer extendedStayTier) {
        this.extendedStayTier = extendedStayTier;
    }

    public BigDecimal getRsAdvTotalRevenue() {
        return this.rsAdvTotalRevenue;
    }

    public ReservationStatDaily rsAdvTotalRevenue(BigDecimal rsAdvTotalRevenue) {
        this.setRsAdvTotalRevenue(rsAdvTotalRevenue);
        return this;
    }

    public void setRsAdvTotalRevenue(BigDecimal rsAdvTotalRevenue) {
        this.rsAdvTotalRevenue = rsAdvTotalRevenue;
    }

    public BigDecimal getRsAdvRoomRevenue() {
        return this.rsAdvRoomRevenue;
    }

    public ReservationStatDaily rsAdvRoomRevenue(BigDecimal rsAdvRoomRevenue) {
        this.setRsAdvRoomRevenue(rsAdvRoomRevenue);
        return this;
    }

    public void setRsAdvRoomRevenue(BigDecimal rsAdvRoomRevenue) {
        this.rsAdvRoomRevenue = rsAdvRoomRevenue;
    }

    public BigDecimal getRsAdvFoodRevenue() {
        return this.rsAdvFoodRevenue;
    }

    public ReservationStatDaily rsAdvFoodRevenue(BigDecimal rsAdvFoodRevenue) {
        this.setRsAdvFoodRevenue(rsAdvFoodRevenue);
        return this;
    }

    public void setRsAdvFoodRevenue(BigDecimal rsAdvFoodRevenue) {
        this.rsAdvFoodRevenue = rsAdvFoodRevenue;
    }

    public BigDecimal getRsAdvOtherRevenue() {
        return this.rsAdvOtherRevenue;
    }

    public ReservationStatDaily rsAdvOtherRevenue(BigDecimal rsAdvOtherRevenue) {
        this.setRsAdvOtherRevenue(rsAdvOtherRevenue);
        return this;
    }

    public void setRsAdvOtherRevenue(BigDecimal rsAdvOtherRevenue) {
        this.rsAdvOtherRevenue = rsAdvOtherRevenue;
    }

    public BigDecimal getRsAdvNonRevenue() {
        return this.rsAdvNonRevenue;
    }

    public ReservationStatDaily rsAdvNonRevenue(BigDecimal rsAdvNonRevenue) {
        this.setRsAdvNonRevenue(rsAdvNonRevenue);
        return this;
    }

    public void setRsAdvNonRevenue(BigDecimal rsAdvNonRevenue) {
        this.rsAdvNonRevenue = rsAdvNonRevenue;
    }

    public BigDecimal getRsAdvTotalTax() {
        return this.rsAdvTotalTax;
    }

    public ReservationStatDaily rsAdvTotalTax(BigDecimal rsAdvTotalTax) {
        this.setRsAdvTotalTax(rsAdvTotalTax);
        return this;
    }

    public void setRsAdvTotalTax(BigDecimal rsAdvTotalTax) {
        this.rsAdvTotalTax = rsAdvTotalTax;
    }

    public BigDecimal getRsAdvRoomTax() {
        return this.rsAdvRoomTax;
    }

    public ReservationStatDaily rsAdvRoomTax(BigDecimal rsAdvRoomTax) {
        this.setRsAdvRoomTax(rsAdvRoomTax);
        return this;
    }

    public void setRsAdvRoomTax(BigDecimal rsAdvRoomTax) {
        this.rsAdvRoomTax = rsAdvRoomTax;
    }

    public BigDecimal getRsAdvFoodTax() {
        return this.rsAdvFoodTax;
    }

    public ReservationStatDaily rsAdvFoodTax(BigDecimal rsAdvFoodTax) {
        this.setRsAdvFoodTax(rsAdvFoodTax);
        return this;
    }

    public void setRsAdvFoodTax(BigDecimal rsAdvFoodTax) {
        this.rsAdvFoodTax = rsAdvFoodTax;
    }

    public BigDecimal getRsAdvOtherTax() {
        return this.rsAdvOtherTax;
    }

    public ReservationStatDaily rsAdvOtherTax(BigDecimal rsAdvOtherTax) {
        this.setRsAdvOtherTax(rsAdvOtherTax);
        return this;
    }

    public void setRsAdvOtherTax(BigDecimal rsAdvOtherTax) {
        this.rsAdvOtherTax = rsAdvOtherTax;
    }

    public BigDecimal getRsAdvNonRevenueTax() {
        return this.rsAdvNonRevenueTax;
    }

    public ReservationStatDaily rsAdvNonRevenueTax(BigDecimal rsAdvNonRevenueTax) {
        this.setRsAdvNonRevenueTax(rsAdvNonRevenueTax);
        return this;
    }

    public void setRsAdvNonRevenueTax(BigDecimal rsAdvNonRevenueTax) {
        this.rsAdvNonRevenueTax = rsAdvNonRevenueTax;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public ReservationStatDaily updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getGuid() {
        return this.guid;
    }

    public ReservationStatDaily guid(String guid) {
        this.setGuid(guid);
        return this;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReservationStatDaily)) {
            return false;
        }
        return getId() != null && getId().equals(((ReservationStatDaily) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReservationStatDaily{" +
            "id=" + getId() +
            ", resort='" + getResort() + "'" +
            ", businessDate='" + getBusinessDate() + "'" +
            ", nameId=" + getNameId() +
            ", rateCode='" + getRateCode() + "'" +
            ", sourceCode='" + getSourceCode() + "'" +
            ", marketCode='" + getMarketCode() + "'" +
            ", roomCategory='" + getRoomCategory() + "'" +
            ", companyId=" + getCompanyId() +
            ", agentId=" + getAgentId() +
            ", groupId=" + getGroupId() +
            ", sourceProfId=" + getSourceProfId() +
            ", resvStatus='" + getResvStatus() + "'" +
            ", truncBeginDate='" + getTruncBeginDate() + "'" +
            ", truncEndDate='" + getTruncEndDate() + "'" +
            ", resvNameId=" + getResvNameId() +
            ", quantity=" + getQuantity() +
            ", physicalQuantity=" + getPhysicalQuantity() +
            ", dueOutYn='" + getDueOutYn() + "'" +
            ", roomResvStatus='" + getRoomResvStatus() + "'" +
            ", adults=" + getAdults() +
            ", children=" + getChildren() +
            ", roomAdults=" + getRoomAdults() +
            ", roomChildren=" + getRoomChildren() +
            ", primaryYn=" + getPrimaryYn() +
            ", allotmentHeaderId=" + getAllotmentHeaderId() +
            ", roomRevenue=" + getRoomRevenue() +
            ", foodRevenue=" + getFoodRevenue() +
            ", packageRoomRevenue=" + getPackageRoomRevenue() +
            ", packageFoodRevenue=" + getPackageFoodRevenue() +
            ", totalRoomTax=" + getTotalRoomTax() +
            ", totalFoodTax=" + getTotalFoodTax() +
            ", totalPackageRevenue=" + getTotalPackageRevenue() +
            ", totalRevenue=" + getTotalRevenue() +
            ", totalTax=" + getTotalTax() +
            ", insertDate='" + getInsertDate() + "'" +
            ", originalEndDate='" + getOriginalEndDate() + "'" +
            ", walkinYn='" + getWalkinYn() + "'" +
            ", reservationDate='" + getReservationDate() + "'" +
            ", roomClass='" + getRoomClass() + "'" +
            ", vipStatus='" + getVipStatus() + "'" +
            ", cancellationDate='" + getCancellationDate() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", room='" + getRoom() + "'" +
            ", membershipId=" + getMembershipId() +
            ", contactId=" + getContactId() +
            ", rateCategory='" + getRateCategory() + "'" +
            ", marketMainGroup='" + getMarketMainGroup() + "'" +
            ", sourceMainGroup='" + getSourceMainGroup() + "'" +
            ", channel='" + getChannel() + "'" +
            ", country='" + getCountry() + "'" +
            ", regionCode='" + getRegionCode() + "'" +
            ", nationality='" + getNationality() + "'" +
            ", psuedoRoomYn='" + getPsuedoRoomYn() + "'" +
            ", adultsTaxFree=" + getAdultsTaxFree() +
            ", childrenTaxFree=" + getChildrenTaxFree() +
            ", stayRooms=" + getStayRooms() +
            ", stayPersons=" + getStayPersons() +
            ", stayAdults=" + getStayAdults() +
            ", stayChildren=" + getStayChildren() +
            ", arrRooms=" + getArrRooms() +
            ", arrPersons=" + getArrPersons() +
            ", depRooms=" + getDepRooms() +
            ", depPersons=" + getDepPersons() +
            ", dayUseRooms=" + getDayUseRooms() +
            ", dayUsePersons=" + getDayUsePersons() +
            ", cancelledRooms=" + getCancelledRooms() +
            ", cancelledPersons=" + getCancelledPersons() +
            ", noShowRooms=" + getNoShowRooms() +
            ", noShowPersons=" + getNoShowPersons() +
            ", singleOccupancy=" + getSingleOccupancy() +
            ", multipleOccupancy=" + getMultipleOccupancy() +
            ", cribs=" + getCribs() +
            ", extraBeds=" + getExtraBeds() +
            ", otherRevenue=" + getOtherRevenue() +
            ", packageOtherRevenue=" + getPackageOtherRevenue() +
            ", totalOtherTax=" + getTotalOtherTax() +
            ", countryMainGroup='" + getCountryMainGroup() + "'" +
            ", state='" + getState() + "'" +
            ", fiscalRegionCode='" + getFiscalRegionCode() + "'" +
            ", nonRevenue=" + getNonRevenue() +
            ", packageNonRevenue=" + getPackageNonRevenue() +
            ", totalNonRevenueTax=" + getTotalNonRevenueTax() +
            ", prRoomRevenue=" + getPrRoomRevenue() +
            ", prFoodRevenue=" + getPrFoodRevenue() +
            ", prPackageRoomRevenue=" + getPrPackageRoomRevenue() +
            ", prPackageFoodRevenue=" + getPrPackageFoodRevenue() +
            ", prTotalRoomTax=" + getPrTotalRoomTax() +
            ", prTotalFoodTax=" + getPrTotalFoodTax() +
            ", prTotalPackageRevenue=" + getPrTotalPackageRevenue() +
            ", prTotalRevenue=" + getPrTotalRevenue() +
            ", prTotalTax=" + getPrTotalTax() +
            ", prOtherRevenue=" + getPrOtherRevenue() +
            ", prPackageOtherRevenue=" + getPrPackageOtherRevenue() +
            ", prTotalOtherTax=" + getPrTotalOtherTax() +
            ", prNonRevenue=" + getPrNonRevenue() +
            ", prPackageNonRevenue=" + getPrPackageNonRevenue() +
            ", prTotalNonRevenueTax=" + getPrTotalNonRevenueTax() +
            ", nights=" + getNights() +
            ", noOfStays=" + getNoOfStays() +
            ", reservationNights=" + getReservationNights() +
            ", reservationArrivals=" + getReservationArrivals() +
            ", reservationNoOfStays=" + getReservationNoOfStays() +
            ", dayUseReservations=" + getDayUseReservations() +
            ", cancelledReservations=" + getCancelledReservations() +
            ", noShowReservations=" + getNoShowReservations() +
            ", city='" + getCity() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            ", district='" + getDistrict() + "'" +
            ", cashRoomNts=" + getCashRoomNts() +
            ", compRoomNts=" + getCompRoomNts() +
            ", cashRoomRevenue=" + getCashRoomRevenue() +
            ", compRoomRevenue=" + getCompRoomRevenue() +
            ", resInsertSource='" + getResInsertSource() + "'" +
            ", resInsertSourceType='" + getResInsertSourceType() + "'" +
            ", children1=" + getChildren1() +
            ", children2=" + getChildren2() +
            ", children3=" + getChildren3() +
            ", children4=" + getChildren4() +
            ", children5=" + getChildren5() +
            ", ffMembershipType='" + getFfMembershipType() + "'" +
            ", fgMembershipType='" + getFgMembershipType() + "'" +
            ", promotionCode='" + getPromotionCode() + "'" +
            ", ownerFfFlag='" + getOwnerFfFlag() + "'" +
            ", ownerRentalFlag='" + getOwnerRentalFlag() + "'" +
            ", centralCurrencyCode='" + getCentralCurrencyCode() + "'" +
            ", centralExchangeRate=" + getCentralExchangeRate() +
            ", bookedRoomCategory='" + getBookedRoomCategory() + "'" +
            ", businessDateCreated='" + getBusinessDateCreated() + "'" +
            ", rateAmount=" + getRateAmount() +
            ", parentCompanyId=" + getParentCompanyId() +
            ", houseUseYn='" + getHouseUseYn() + "'" +
            ", complimentaryYn='" + getComplimentaryYn() + "'" +
            ", biResvNameId=" + getBiResvNameId() +
            ", advFoodRevenue=" + getAdvFoodRevenue() +
            ", advNonRevenue=" + getAdvNonRevenue() +
            ", advOtherRevenue=" + getAdvOtherRevenue() +
            ", advRoomRevenue=" + getAdvRoomRevenue() +
            ", advTotalFoodTax=" + getAdvTotalFoodTax() +
            ", advTotalNonRevenueTax=" + getAdvTotalNonRevenueTax() +
            ", advTotalOtherTax=" + getAdvTotalOtherTax() +
            ", advTotalRevenue=" + getAdvTotalRevenue() +
            ", advTotalRoomTax=" + getAdvTotalRoomTax() +
            ", advTotalTax=" + getAdvTotalTax() +
            ", prAdvFoodRevenue=" + getPrAdvFoodRevenue() +
            ", prAdvNonRevenue=" + getPrAdvNonRevenue() +
            ", prAdvOtherRevenue=" + getPrAdvOtherRevenue() +
            ", prAdvRoomRevenue=" + getPrAdvRoomRevenue() +
            ", prAdvTotalFoodTax=" + getPrAdvTotalFoodTax() +
            ", prAdvTotalNonRevenueTax=" + getPrAdvTotalNonRevenueTax() +
            ", prAdvTotalOtherTax=" + getPrAdvTotalOtherTax() +
            ", prAdvTotalRevenue=" + getPrAdvTotalRevenue() +
            ", prAdvTotalRoomTax=" + getPrAdvTotalRoomTax() +
            ", prAdvTotalTax=" + getPrAdvTotalTax() +
            ", upsoldRevenue=" + getUpsoldRevenue() +
            ", flgdRoomRevenue=" + getFlgdRoomRevenue() +
            ", flgdFoodRevenue=" + getFlgdFoodRevenue() +
            ", flgdNonRevenue=" + getFlgdNonRevenue() +
            ", flgdOtherRevenue=" + getFlgdOtherRevenue() +
            ", flgdTotalRoomTax=" + getFlgdTotalRoomTax() +
            ", flgdTotalFoodTax=" + getFlgdTotalFoodTax() +
            ", flgdTotalNonRevenueTax=" + getFlgdTotalNonRevenueTax() +
            ", flgdTotalOtherTax=" + getFlgdTotalOtherTax() +
            ", flgdTotalRevenue=" + getFlgdTotalRevenue() +
            ", flgdTotalTax=" + getFlgdTotalTax() +
            ", contactYn='" + getContactYn() + "'" +
            ", extendedStayTier=" + getExtendedStayTier() +
            ", rsAdvTotalRevenue=" + getRsAdvTotalRevenue() +
            ", rsAdvRoomRevenue=" + getRsAdvRoomRevenue() +
            ", rsAdvFoodRevenue=" + getRsAdvFoodRevenue() +
            ", rsAdvOtherRevenue=" + getRsAdvOtherRevenue() +
            ", rsAdvNonRevenue=" + getRsAdvNonRevenue() +
            ", rsAdvTotalTax=" + getRsAdvTotalTax() +
            ", rsAdvRoomTax=" + getRsAdvRoomTax() +
            ", rsAdvFoodTax=" + getRsAdvFoodTax() +
            ", rsAdvOtherTax=" + getRsAdvOtherTax() +
            ", rsAdvNonRevenueTax=" + getRsAdvNonRevenueTax() +
            ", updateDate='" + getUpdateDate() + "'" +
            ", guid='" + getGuid() + "'" +
            "}";
    }
}
