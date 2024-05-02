package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ReservationSummary.
 */
@Entity
@Table(name = "reservation_summary")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReservationSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "resort")
    private String resort;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_id")
    private String eventId;

    @Column(name = "considered_date")
    private LocalDate consideredDate;

    @Column(name = "room_category")
    private String roomCategory;

    @Column(name = "room_class")
    private String roomClass;

    @Column(name = "market_code")
    private String marketCode;

    @Column(name = "source_code")
    private String sourceCode;

    @Column(name = "rate_code")
    private String rateCode;

    @Column(name = "region_code")
    private String regionCode;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "resv_type")
    private String resvType;

    @Column(name = "resv_inv_type")
    private String resvInvType;

    @Column(name = "psuedo_room_yn")
    private String psuedoRoomYn;

    @Column(name = "arr_rooms")
    private Integer arrRooms;

    @Column(name = "adults")
    private Integer adults;

    @Column(name = "children")
    private Integer children;

    @Column(name = "dep_rooms")
    private Integer depRooms;

    @Column(name = "no_rooms")
    private Integer noRooms;

    @Column(name = "gross_rate", precision = 21, scale = 2)
    private BigDecimal grossRate;

    @Column(name = "net_room_revenue", precision = 21, scale = 2)
    private BigDecimal netRoomRevenue;

    @Column(name = "extra_revenue", precision = 21, scale = 2)
    private BigDecimal extraRevenue;

    @Column(name = "oo_rooms")
    private Integer ooRooms;

    @Column(name = "os_rooms")
    private Integer osRooms;

    @Column(name = "remaining_block_rooms")
    private Integer remainingBlockRooms;

    @Column(name = "pickedup_block_rooms")
    private Integer pickedupBlockRooms;

    @Column(name = "single_occupancy")
    private Integer singleOccupancy;

    @Column(name = "multiple_occupancy")
    private Integer multipleOccupancy;

    @Column(name = "block_status")
    private String blockStatus;

    @Column(name = "arr_persons")
    private Integer arrPersons;

    @Column(name = "dep_persons")
    private Integer depPersons;

    @Column(name = "wl_rooms")
    private Integer wlRooms;

    @Column(name = "wl_persons")
    private Integer wlPersons;

    @Column(name = "day_use_rooms")
    private Integer dayUseRooms;

    @Column(name = "day_use_persons")
    private Integer dayUsePersons;

    @Column(name = "booking_status")
    private String bookingStatus;

    @Column(name = "resv_status")
    private String resvStatus;

    @Column(name = "day_use_yn")
    private String dayUseYn;

    @Column(name = "channel")
    private String channel;

    @Column(name = "country")
    private String country;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "cribs")
    private Integer cribs;

    @Column(name = "extra_beds")
    private Integer extraBeds;

    @Column(name = "adults_tax_free")
    private Integer adultsTaxFree;

    @Column(name = "children_tax_free")
    private Integer childrenTaxFree;

    @Column(name = "rate_category")
    private String rateCategory;

    @Column(name = "rate_class")
    private String rateClass;

    @Column(name = "room_revenue", precision = 21, scale = 2)
    private BigDecimal roomRevenue;

    @Column(name = "food_revenue", precision = 21, scale = 2)
    private BigDecimal foodRevenue;

    @Column(name = "other_revenue", precision = 21, scale = 2)
    private BigDecimal otherRevenue;

    @Column(name = "total_revenue", precision = 21, scale = 2)
    private BigDecimal totalRevenue;

    @Column(name = "non_revenue", precision = 21, scale = 2)
    private BigDecimal nonRevenue;

    @Column(name = "allotment_header_id")
    private Integer allotmentHeaderId;

    @Column(name = "room_revenue_tax", precision = 21, scale = 2)
    private BigDecimal roomRevenueTax;

    @Column(name = "food_revenue_tax", precision = 21, scale = 2)
    private BigDecimal foodRevenueTax;

    @Column(name = "other_revenue_tax", precision = 21, scale = 2)
    private BigDecimal otherRevenueTax;

    @Column(name = "total_revenue_tax", precision = 21, scale = 2)
    private BigDecimal totalRevenueTax;

    @Column(name = "non_revenue_tax", precision = 21, scale = 2)
    private BigDecimal nonRevenueTax;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

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

    @Column(name = "owner_ff_flag")
    private String ownerFfFlag;

    @Column(name = "owner_rental_flag")
    private String ownerRentalFlag;

    @Column(name = "fc_gross_rate", precision = 21, scale = 2)
    private BigDecimal fcGrossRate;

    @Column(name = "fc_net_room_revenue", precision = 21, scale = 2)
    private BigDecimal fcNetRoomRevenue;

    @Column(name = "fc_extra_revenue", precision = 21, scale = 2)
    private BigDecimal fcExtraRevenue;

    @Column(name = "fc_room_revenue", precision = 21, scale = 2)
    private BigDecimal fcRoomRevenue;

    @Column(name = "fc_food_revenue", precision = 21, scale = 2)
    private BigDecimal fcFoodRevenue;

    @Column(name = "fc_other_revenue", precision = 21, scale = 2)
    private BigDecimal fcOtherRevenue;

    @Column(name = "fc_total_revenue", precision = 21, scale = 2)
    private BigDecimal fcTotalRevenue;

    @Column(name = "fc_non_revenue", precision = 21, scale = 2)
    private BigDecimal fcNonRevenue;

    @Column(name = "fc_room_revenue_tax", precision = 21, scale = 2)
    private BigDecimal fcRoomRevenueTax;

    @Column(name = "fc_food_revenue_tax", precision = 21, scale = 2)
    private BigDecimal fcFoodRevenueTax;

    @Column(name = "fc_other_revenue_tax", precision = 21, scale = 2)
    private BigDecimal fcOtherRevenueTax;

    @Column(name = "fc_total_revenue_tax", precision = 21, scale = 2)
    private BigDecimal fcTotalRevenueTax;

    @Column(name = "fc_non_revenue_tax", precision = 21, scale = 2)
    private BigDecimal fcNonRevenueTax;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "exchange_date")
    private LocalDate exchangeDate;

    @Column(name = "update_business_date")
    private LocalDate updateBusinessDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "central_currency_code")
    private String centralCurrencyCode;

    @Column(name = "central_exchange_rate", precision = 21, scale = 2)
    private BigDecimal centralExchangeRate;

    @Column(name = "trunc_begin_date")
    private LocalDate truncBeginDate;

    @Column(name = "trunc_end_date")
    private LocalDate truncEndDate;

    @Column(name = "business_date_created")
    private LocalDate businessDateCreated;

    @Column(name = "res_insert_source")
    private String resInsertSource;

    @Column(name = "parent_company_id")
    private Integer parentCompanyId;

    @Column(name = "agent_id")
    private Integer agentId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "vip_status")
    private String vipStatus;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "turndown_status")
    private String turndownStatus;

    @Column(name = "booked_room_category")
    private String bookedRoomCategory;

    @Column(name = "source_prof_id")
    private Integer sourceProfId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Integer getId() {
        return this.id;
    }

    public ReservationSummary id(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResort() {
        return this.resort;
    }

    public ReservationSummary resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public String getEventType() {
        return this.eventType;
    }

    public ReservationSummary eventType(String eventType) {
        this.setEventType(eventType);
        return this;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventId() {
        return this.eventId;
    }

    public ReservationSummary eventId(String eventId) {
        this.setEventId(eventId);
        return this;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public LocalDate getConsideredDate() {
        return this.consideredDate;
    }

    public ReservationSummary consideredDate(LocalDate consideredDate) {
        this.setConsideredDate(consideredDate);
        return this;
    }

    public void setConsideredDate(LocalDate consideredDate) {
        this.consideredDate = consideredDate;
    }

    public String getRoomCategory() {
        return this.roomCategory;
    }

    public ReservationSummary roomCategory(String roomCategory) {
        this.setRoomCategory(roomCategory);
        return this;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public String getRoomClass() {
        return this.roomClass;
    }

    public ReservationSummary roomClass(String roomClass) {
        this.setRoomClass(roomClass);
        return this;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public String getMarketCode() {
        return this.marketCode;
    }

    public ReservationSummary marketCode(String marketCode) {
        this.setMarketCode(marketCode);
        return this;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getSourceCode() {
        return this.sourceCode;
    }

    public ReservationSummary sourceCode(String sourceCode) {
        this.setSourceCode(sourceCode);
        return this;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getRateCode() {
        return this.rateCode;
    }

    public ReservationSummary rateCode(String rateCode) {
        this.setRateCode(rateCode);
        return this;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public ReservationSummary regionCode(String regionCode) {
        this.setRegionCode(regionCode);
        return this;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public ReservationSummary groupId(Integer groupId) {
        this.setGroupId(groupId);
        return this;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getResvType() {
        return this.resvType;
    }

    public ReservationSummary resvType(String resvType) {
        this.setResvType(resvType);
        return this;
    }

    public void setResvType(String resvType) {
        this.resvType = resvType;
    }

    public String getResvInvType() {
        return this.resvInvType;
    }

    public ReservationSummary resvInvType(String resvInvType) {
        this.setResvInvType(resvInvType);
        return this;
    }

    public void setResvInvType(String resvInvType) {
        this.resvInvType = resvInvType;
    }

    public String getPsuedoRoomYn() {
        return this.psuedoRoomYn;
    }

    public ReservationSummary psuedoRoomYn(String psuedoRoomYn) {
        this.setPsuedoRoomYn(psuedoRoomYn);
        return this;
    }

    public void setPsuedoRoomYn(String psuedoRoomYn) {
        this.psuedoRoomYn = psuedoRoomYn;
    }

    public Integer getArrRooms() {
        return this.arrRooms;
    }

    public ReservationSummary arrRooms(Integer arrRooms) {
        this.setArrRooms(arrRooms);
        return this;
    }

    public void setArrRooms(Integer arrRooms) {
        this.arrRooms = arrRooms;
    }

    public Integer getAdults() {
        return this.adults;
    }

    public ReservationSummary adults(Integer adults) {
        this.setAdults(adults);
        return this;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return this.children;
    }

    public ReservationSummary children(Integer children) {
        this.setChildren(children);
        return this;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getDepRooms() {
        return this.depRooms;
    }

    public ReservationSummary depRooms(Integer depRooms) {
        this.setDepRooms(depRooms);
        return this;
    }

    public void setDepRooms(Integer depRooms) {
        this.depRooms = depRooms;
    }

    public Integer getNoRooms() {
        return this.noRooms;
    }

    public ReservationSummary noRooms(Integer noRooms) {
        this.setNoRooms(noRooms);
        return this;
    }

    public void setNoRooms(Integer noRooms) {
        this.noRooms = noRooms;
    }

    public BigDecimal getGrossRate() {
        return this.grossRate;
    }

    public ReservationSummary grossRate(BigDecimal grossRate) {
        this.setGrossRate(grossRate);
        return this;
    }

    public void setGrossRate(BigDecimal grossRate) {
        this.grossRate = grossRate;
    }

    public BigDecimal getNetRoomRevenue() {
        return this.netRoomRevenue;
    }

    public ReservationSummary netRoomRevenue(BigDecimal netRoomRevenue) {
        this.setNetRoomRevenue(netRoomRevenue);
        return this;
    }

    public void setNetRoomRevenue(BigDecimal netRoomRevenue) {
        this.netRoomRevenue = netRoomRevenue;
    }

    public BigDecimal getExtraRevenue() {
        return this.extraRevenue;
    }

    public ReservationSummary extraRevenue(BigDecimal extraRevenue) {
        this.setExtraRevenue(extraRevenue);
        return this;
    }

    public void setExtraRevenue(BigDecimal extraRevenue) {
        this.extraRevenue = extraRevenue;
    }

    public Integer getOoRooms() {
        return this.ooRooms;
    }

    public ReservationSummary ooRooms(Integer ooRooms) {
        this.setOoRooms(ooRooms);
        return this;
    }

    public void setOoRooms(Integer ooRooms) {
        this.ooRooms = ooRooms;
    }

    public Integer getOsRooms() {
        return this.osRooms;
    }

    public ReservationSummary osRooms(Integer osRooms) {
        this.setOsRooms(osRooms);
        return this;
    }

    public void setOsRooms(Integer osRooms) {
        this.osRooms = osRooms;
    }

    public Integer getRemainingBlockRooms() {
        return this.remainingBlockRooms;
    }

    public ReservationSummary remainingBlockRooms(Integer remainingBlockRooms) {
        this.setRemainingBlockRooms(remainingBlockRooms);
        return this;
    }

    public void setRemainingBlockRooms(Integer remainingBlockRooms) {
        this.remainingBlockRooms = remainingBlockRooms;
    }

    public Integer getPickedupBlockRooms() {
        return this.pickedupBlockRooms;
    }

    public ReservationSummary pickedupBlockRooms(Integer pickedupBlockRooms) {
        this.setPickedupBlockRooms(pickedupBlockRooms);
        return this;
    }

    public void setPickedupBlockRooms(Integer pickedupBlockRooms) {
        this.pickedupBlockRooms = pickedupBlockRooms;
    }

    public Integer getSingleOccupancy() {
        return this.singleOccupancy;
    }

    public ReservationSummary singleOccupancy(Integer singleOccupancy) {
        this.setSingleOccupancy(singleOccupancy);
        return this;
    }

    public void setSingleOccupancy(Integer singleOccupancy) {
        this.singleOccupancy = singleOccupancy;
    }

    public Integer getMultipleOccupancy() {
        return this.multipleOccupancy;
    }

    public ReservationSummary multipleOccupancy(Integer multipleOccupancy) {
        this.setMultipleOccupancy(multipleOccupancy);
        return this;
    }

    public void setMultipleOccupancy(Integer multipleOccupancy) {
        this.multipleOccupancy = multipleOccupancy;
    }

    public String getBlockStatus() {
        return this.blockStatus;
    }

    public ReservationSummary blockStatus(String blockStatus) {
        this.setBlockStatus(blockStatus);
        return this;
    }

    public void setBlockStatus(String blockStatus) {
        this.blockStatus = blockStatus;
    }

    public Integer getArrPersons() {
        return this.arrPersons;
    }

    public ReservationSummary arrPersons(Integer arrPersons) {
        this.setArrPersons(arrPersons);
        return this;
    }

    public void setArrPersons(Integer arrPersons) {
        this.arrPersons = arrPersons;
    }

    public Integer getDepPersons() {
        return this.depPersons;
    }

    public ReservationSummary depPersons(Integer depPersons) {
        this.setDepPersons(depPersons);
        return this;
    }

    public void setDepPersons(Integer depPersons) {
        this.depPersons = depPersons;
    }

    public Integer getWlRooms() {
        return this.wlRooms;
    }

    public ReservationSummary wlRooms(Integer wlRooms) {
        this.setWlRooms(wlRooms);
        return this;
    }

    public void setWlRooms(Integer wlRooms) {
        this.wlRooms = wlRooms;
    }

    public Integer getWlPersons() {
        return this.wlPersons;
    }

    public ReservationSummary wlPersons(Integer wlPersons) {
        this.setWlPersons(wlPersons);
        return this;
    }

    public void setWlPersons(Integer wlPersons) {
        this.wlPersons = wlPersons;
    }

    public Integer getDayUseRooms() {
        return this.dayUseRooms;
    }

    public ReservationSummary dayUseRooms(Integer dayUseRooms) {
        this.setDayUseRooms(dayUseRooms);
        return this;
    }

    public void setDayUseRooms(Integer dayUseRooms) {
        this.dayUseRooms = dayUseRooms;
    }

    public Integer getDayUsePersons() {
        return this.dayUsePersons;
    }

    public ReservationSummary dayUsePersons(Integer dayUsePersons) {
        this.setDayUsePersons(dayUsePersons);
        return this;
    }

    public void setDayUsePersons(Integer dayUsePersons) {
        this.dayUsePersons = dayUsePersons;
    }

    public String getBookingStatus() {
        return this.bookingStatus;
    }

    public ReservationSummary bookingStatus(String bookingStatus) {
        this.setBookingStatus(bookingStatus);
        return this;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getResvStatus() {
        return this.resvStatus;
    }

    public ReservationSummary resvStatus(String resvStatus) {
        this.setResvStatus(resvStatus);
        return this;
    }

    public void setResvStatus(String resvStatus) {
        this.resvStatus = resvStatus;
    }

    public String getDayUseYn() {
        return this.dayUseYn;
    }

    public ReservationSummary dayUseYn(String dayUseYn) {
        this.setDayUseYn(dayUseYn);
        return this;
    }

    public void setDayUseYn(String dayUseYn) {
        this.dayUseYn = dayUseYn;
    }

    public String getChannel() {
        return this.channel;
    }

    public ReservationSummary channel(String channel) {
        this.setChannel(channel);
        return this;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCountry() {
        return this.country;
    }

    public ReservationSummary country(String country) {
        this.setCountry(country);
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return this.nationality;
    }

    public ReservationSummary nationality(String nationality) {
        this.setNationality(nationality);
        return this;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getCribs() {
        return this.cribs;
    }

    public ReservationSummary cribs(Integer cribs) {
        this.setCribs(cribs);
        return this;
    }

    public void setCribs(Integer cribs) {
        this.cribs = cribs;
    }

    public Integer getExtraBeds() {
        return this.extraBeds;
    }

    public ReservationSummary extraBeds(Integer extraBeds) {
        this.setExtraBeds(extraBeds);
        return this;
    }

    public void setExtraBeds(Integer extraBeds) {
        this.extraBeds = extraBeds;
    }

    public Integer getAdultsTaxFree() {
        return this.adultsTaxFree;
    }

    public ReservationSummary adultsTaxFree(Integer adultsTaxFree) {
        this.setAdultsTaxFree(adultsTaxFree);
        return this;
    }

    public void setAdultsTaxFree(Integer adultsTaxFree) {
        this.adultsTaxFree = adultsTaxFree;
    }

    public Integer getChildrenTaxFree() {
        return this.childrenTaxFree;
    }

    public ReservationSummary childrenTaxFree(Integer childrenTaxFree) {
        this.setChildrenTaxFree(childrenTaxFree);
        return this;
    }

    public void setChildrenTaxFree(Integer childrenTaxFree) {
        this.childrenTaxFree = childrenTaxFree;
    }

    public String getRateCategory() {
        return this.rateCategory;
    }

    public ReservationSummary rateCategory(String rateCategory) {
        this.setRateCategory(rateCategory);
        return this;
    }

    public void setRateCategory(String rateCategory) {
        this.rateCategory = rateCategory;
    }

    public String getRateClass() {
        return this.rateClass;
    }

    public ReservationSummary rateClass(String rateClass) {
        this.setRateClass(rateClass);
        return this;
    }

    public void setRateClass(String rateClass) {
        this.rateClass = rateClass;
    }

    public BigDecimal getRoomRevenue() {
        return this.roomRevenue;
    }

    public ReservationSummary roomRevenue(BigDecimal roomRevenue) {
        this.setRoomRevenue(roomRevenue);
        return this;
    }

    public void setRoomRevenue(BigDecimal roomRevenue) {
        this.roomRevenue = roomRevenue;
    }

    public BigDecimal getFoodRevenue() {
        return this.foodRevenue;
    }

    public ReservationSummary foodRevenue(BigDecimal foodRevenue) {
        this.setFoodRevenue(foodRevenue);
        return this;
    }

    public void setFoodRevenue(BigDecimal foodRevenue) {
        this.foodRevenue = foodRevenue;
    }

    public BigDecimal getOtherRevenue() {
        return this.otherRevenue;
    }

    public ReservationSummary otherRevenue(BigDecimal otherRevenue) {
        this.setOtherRevenue(otherRevenue);
        return this;
    }

    public void setOtherRevenue(BigDecimal otherRevenue) {
        this.otherRevenue = otherRevenue;
    }

    public BigDecimal getTotalRevenue() {
        return this.totalRevenue;
    }

    public ReservationSummary totalRevenue(BigDecimal totalRevenue) {
        this.setTotalRevenue(totalRevenue);
        return this;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigDecimal getNonRevenue() {
        return this.nonRevenue;
    }

    public ReservationSummary nonRevenue(BigDecimal nonRevenue) {
        this.setNonRevenue(nonRevenue);
        return this;
    }

    public void setNonRevenue(BigDecimal nonRevenue) {
        this.nonRevenue = nonRevenue;
    }

    public Integer getAllotmentHeaderId() {
        return this.allotmentHeaderId;
    }

    public ReservationSummary allotmentHeaderId(Integer allotmentHeaderId) {
        this.setAllotmentHeaderId(allotmentHeaderId);
        return this;
    }

    public void setAllotmentHeaderId(Integer allotmentHeaderId) {
        this.allotmentHeaderId = allotmentHeaderId;
    }

    public BigDecimal getRoomRevenueTax() {
        return this.roomRevenueTax;
    }

    public ReservationSummary roomRevenueTax(BigDecimal roomRevenueTax) {
        this.setRoomRevenueTax(roomRevenueTax);
        return this;
    }

    public void setRoomRevenueTax(BigDecimal roomRevenueTax) {
        this.roomRevenueTax = roomRevenueTax;
    }

    public BigDecimal getFoodRevenueTax() {
        return this.foodRevenueTax;
    }

    public ReservationSummary foodRevenueTax(BigDecimal foodRevenueTax) {
        this.setFoodRevenueTax(foodRevenueTax);
        return this;
    }

    public void setFoodRevenueTax(BigDecimal foodRevenueTax) {
        this.foodRevenueTax = foodRevenueTax;
    }

    public BigDecimal getOtherRevenueTax() {
        return this.otherRevenueTax;
    }

    public ReservationSummary otherRevenueTax(BigDecimal otherRevenueTax) {
        this.setOtherRevenueTax(otherRevenueTax);
        return this;
    }

    public void setOtherRevenueTax(BigDecimal otherRevenueTax) {
        this.otherRevenueTax = otherRevenueTax;
    }

    public BigDecimal getTotalRevenueTax() {
        return this.totalRevenueTax;
    }

    public ReservationSummary totalRevenueTax(BigDecimal totalRevenueTax) {
        this.setTotalRevenueTax(totalRevenueTax);
        return this;
    }

    public void setTotalRevenueTax(BigDecimal totalRevenueTax) {
        this.totalRevenueTax = totalRevenueTax;
    }

    public BigDecimal getNonRevenueTax() {
        return this.nonRevenueTax;
    }

    public ReservationSummary nonRevenueTax(BigDecimal nonRevenueTax) {
        this.setNonRevenueTax(nonRevenueTax);
        return this;
    }

    public void setNonRevenueTax(BigDecimal nonRevenueTax) {
        this.nonRevenueTax = nonRevenueTax;
    }

    public String getCity() {
        return this.city;
    }

    public ReservationSummary city(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public ReservationSummary zipCode(String zipCode) {
        this.setZipCode(zipCode);
        return this;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDistrict() {
        return this.district;
    }

    public ReservationSummary district(String district) {
        this.setDistrict(district);
        return this;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return this.state;
    }

    public ReservationSummary state(String state) {
        this.setState(state);
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getChildren1() {
        return this.children1;
    }

    public ReservationSummary children1(Integer children1) {
        this.setChildren1(children1);
        return this;
    }

    public void setChildren1(Integer children1) {
        this.children1 = children1;
    }

    public Integer getChildren2() {
        return this.children2;
    }

    public ReservationSummary children2(Integer children2) {
        this.setChildren2(children2);
        return this;
    }

    public void setChildren2(Integer children2) {
        this.children2 = children2;
    }

    public Integer getChildren3() {
        return this.children3;
    }

    public ReservationSummary children3(Integer children3) {
        this.setChildren3(children3);
        return this;
    }

    public void setChildren3(Integer children3) {
        this.children3 = children3;
    }

    public Integer getChildren4() {
        return this.children4;
    }

    public ReservationSummary children4(Integer children4) {
        this.setChildren4(children4);
        return this;
    }

    public void setChildren4(Integer children4) {
        this.children4 = children4;
    }

    public Integer getChildren5() {
        return this.children5;
    }

    public ReservationSummary children5(Integer children5) {
        this.setChildren5(children5);
        return this;
    }

    public void setChildren5(Integer children5) {
        this.children5 = children5;
    }

    public String getOwnerFfFlag() {
        return this.ownerFfFlag;
    }

    public ReservationSummary ownerFfFlag(String ownerFfFlag) {
        this.setOwnerFfFlag(ownerFfFlag);
        return this;
    }

    public void setOwnerFfFlag(String ownerFfFlag) {
        this.ownerFfFlag = ownerFfFlag;
    }

    public String getOwnerRentalFlag() {
        return this.ownerRentalFlag;
    }

    public ReservationSummary ownerRentalFlag(String ownerRentalFlag) {
        this.setOwnerRentalFlag(ownerRentalFlag);
        return this;
    }

    public void setOwnerRentalFlag(String ownerRentalFlag) {
        this.ownerRentalFlag = ownerRentalFlag;
    }

    public BigDecimal getFcGrossRate() {
        return this.fcGrossRate;
    }

    public ReservationSummary fcGrossRate(BigDecimal fcGrossRate) {
        this.setFcGrossRate(fcGrossRate);
        return this;
    }

    public void setFcGrossRate(BigDecimal fcGrossRate) {
        this.fcGrossRate = fcGrossRate;
    }

    public BigDecimal getFcNetRoomRevenue() {
        return this.fcNetRoomRevenue;
    }

    public ReservationSummary fcNetRoomRevenue(BigDecimal fcNetRoomRevenue) {
        this.setFcNetRoomRevenue(fcNetRoomRevenue);
        return this;
    }

    public void setFcNetRoomRevenue(BigDecimal fcNetRoomRevenue) {
        this.fcNetRoomRevenue = fcNetRoomRevenue;
    }

    public BigDecimal getFcExtraRevenue() {
        return this.fcExtraRevenue;
    }

    public ReservationSummary fcExtraRevenue(BigDecimal fcExtraRevenue) {
        this.setFcExtraRevenue(fcExtraRevenue);
        return this;
    }

    public void setFcExtraRevenue(BigDecimal fcExtraRevenue) {
        this.fcExtraRevenue = fcExtraRevenue;
    }

    public BigDecimal getFcRoomRevenue() {
        return this.fcRoomRevenue;
    }

    public ReservationSummary fcRoomRevenue(BigDecimal fcRoomRevenue) {
        this.setFcRoomRevenue(fcRoomRevenue);
        return this;
    }

    public void setFcRoomRevenue(BigDecimal fcRoomRevenue) {
        this.fcRoomRevenue = fcRoomRevenue;
    }

    public BigDecimal getFcFoodRevenue() {
        return this.fcFoodRevenue;
    }

    public ReservationSummary fcFoodRevenue(BigDecimal fcFoodRevenue) {
        this.setFcFoodRevenue(fcFoodRevenue);
        return this;
    }

    public void setFcFoodRevenue(BigDecimal fcFoodRevenue) {
        this.fcFoodRevenue = fcFoodRevenue;
    }

    public BigDecimal getFcOtherRevenue() {
        return this.fcOtherRevenue;
    }

    public ReservationSummary fcOtherRevenue(BigDecimal fcOtherRevenue) {
        this.setFcOtherRevenue(fcOtherRevenue);
        return this;
    }

    public void setFcOtherRevenue(BigDecimal fcOtherRevenue) {
        this.fcOtherRevenue = fcOtherRevenue;
    }

    public BigDecimal getFcTotalRevenue() {
        return this.fcTotalRevenue;
    }

    public ReservationSummary fcTotalRevenue(BigDecimal fcTotalRevenue) {
        this.setFcTotalRevenue(fcTotalRevenue);
        return this;
    }

    public void setFcTotalRevenue(BigDecimal fcTotalRevenue) {
        this.fcTotalRevenue = fcTotalRevenue;
    }

    public BigDecimal getFcNonRevenue() {
        return this.fcNonRevenue;
    }

    public ReservationSummary fcNonRevenue(BigDecimal fcNonRevenue) {
        this.setFcNonRevenue(fcNonRevenue);
        return this;
    }

    public void setFcNonRevenue(BigDecimal fcNonRevenue) {
        this.fcNonRevenue = fcNonRevenue;
    }

    public BigDecimal getFcRoomRevenueTax() {
        return this.fcRoomRevenueTax;
    }

    public ReservationSummary fcRoomRevenueTax(BigDecimal fcRoomRevenueTax) {
        this.setFcRoomRevenueTax(fcRoomRevenueTax);
        return this;
    }

    public void setFcRoomRevenueTax(BigDecimal fcRoomRevenueTax) {
        this.fcRoomRevenueTax = fcRoomRevenueTax;
    }

    public BigDecimal getFcFoodRevenueTax() {
        return this.fcFoodRevenueTax;
    }

    public ReservationSummary fcFoodRevenueTax(BigDecimal fcFoodRevenueTax) {
        this.setFcFoodRevenueTax(fcFoodRevenueTax);
        return this;
    }

    public void setFcFoodRevenueTax(BigDecimal fcFoodRevenueTax) {
        this.fcFoodRevenueTax = fcFoodRevenueTax;
    }

    public BigDecimal getFcOtherRevenueTax() {
        return this.fcOtherRevenueTax;
    }

    public ReservationSummary fcOtherRevenueTax(BigDecimal fcOtherRevenueTax) {
        this.setFcOtherRevenueTax(fcOtherRevenueTax);
        return this;
    }

    public void setFcOtherRevenueTax(BigDecimal fcOtherRevenueTax) {
        this.fcOtherRevenueTax = fcOtherRevenueTax;
    }

    public BigDecimal getFcTotalRevenueTax() {
        return this.fcTotalRevenueTax;
    }

    public ReservationSummary fcTotalRevenueTax(BigDecimal fcTotalRevenueTax) {
        this.setFcTotalRevenueTax(fcTotalRevenueTax);
        return this;
    }

    public void setFcTotalRevenueTax(BigDecimal fcTotalRevenueTax) {
        this.fcTotalRevenueTax = fcTotalRevenueTax;
    }

    public BigDecimal getFcNonRevenueTax() {
        return this.fcNonRevenueTax;
    }

    public ReservationSummary fcNonRevenueTax(BigDecimal fcNonRevenueTax) {
        this.setFcNonRevenueTax(fcNonRevenueTax);
        return this;
    }

    public void setFcNonRevenueTax(BigDecimal fcNonRevenueTax) {
        this.fcNonRevenueTax = fcNonRevenueTax;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public ReservationSummary currencyCode(String currencyCode) {
        this.setCurrencyCode(currencyCode);
        return this;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public LocalDate getExchangeDate() {
        return this.exchangeDate;
    }

    public ReservationSummary exchangeDate(LocalDate exchangeDate) {
        this.setExchangeDate(exchangeDate);
        return this;
    }

    public void setExchangeDate(LocalDate exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public LocalDate getUpdateBusinessDate() {
        return this.updateBusinessDate;
    }

    public ReservationSummary updateBusinessDate(LocalDate updateBusinessDate) {
        this.setUpdateBusinessDate(updateBusinessDate);
        return this;
    }

    public void setUpdateBusinessDate(LocalDate updateBusinessDate) {
        this.updateBusinessDate = updateBusinessDate;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public ReservationSummary updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getCentralCurrencyCode() {
        return this.centralCurrencyCode;
    }

    public ReservationSummary centralCurrencyCode(String centralCurrencyCode) {
        this.setCentralCurrencyCode(centralCurrencyCode);
        return this;
    }

    public void setCentralCurrencyCode(String centralCurrencyCode) {
        this.centralCurrencyCode = centralCurrencyCode;
    }

    public BigDecimal getCentralExchangeRate() {
        return this.centralExchangeRate;
    }

    public ReservationSummary centralExchangeRate(BigDecimal centralExchangeRate) {
        this.setCentralExchangeRate(centralExchangeRate);
        return this;
    }

    public void setCentralExchangeRate(BigDecimal centralExchangeRate) {
        this.centralExchangeRate = centralExchangeRate;
    }

    public LocalDate getTruncBeginDate() {
        return this.truncBeginDate;
    }

    public ReservationSummary truncBeginDate(LocalDate truncBeginDate) {
        this.setTruncBeginDate(truncBeginDate);
        return this;
    }

    public void setTruncBeginDate(LocalDate truncBeginDate) {
        this.truncBeginDate = truncBeginDate;
    }

    public LocalDate getTruncEndDate() {
        return this.truncEndDate;
    }

    public ReservationSummary truncEndDate(LocalDate truncEndDate) {
        this.setTruncEndDate(truncEndDate);
        return this;
    }

    public void setTruncEndDate(LocalDate truncEndDate) {
        this.truncEndDate = truncEndDate;
    }

    public LocalDate getBusinessDateCreated() {
        return this.businessDateCreated;
    }

    public ReservationSummary businessDateCreated(LocalDate businessDateCreated) {
        this.setBusinessDateCreated(businessDateCreated);
        return this;
    }

    public void setBusinessDateCreated(LocalDate businessDateCreated) {
        this.businessDateCreated = businessDateCreated;
    }

    public String getResInsertSource() {
        return this.resInsertSource;
    }

    public ReservationSummary resInsertSource(String resInsertSource) {
        this.setResInsertSource(resInsertSource);
        return this;
    }

    public void setResInsertSource(String resInsertSource) {
        this.resInsertSource = resInsertSource;
    }

    public Integer getParentCompanyId() {
        return this.parentCompanyId;
    }

    public ReservationSummary parentCompanyId(Integer parentCompanyId) {
        this.setParentCompanyId(parentCompanyId);
        return this;
    }

    public void setParentCompanyId(Integer parentCompanyId) {
        this.parentCompanyId = parentCompanyId;
    }

    public Integer getAgentId() {
        return this.agentId;
    }

    public ReservationSummary agentId(Integer agentId) {
        this.setAgentId(agentId);
        return this;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getGender() {
        return this.gender;
    }

    public ReservationSummary gender(String gender) {
        this.setGender(gender);
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVipStatus() {
        return this.vipStatus;
    }

    public ReservationSummary vipStatus(String vipStatus) {
        this.setVipStatus(vipStatus);
        return this;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public ReservationSummary quantity(Integer quantity) {
        this.setQuantity(quantity);
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTurndownStatus() {
        return this.turndownStatus;
    }

    public ReservationSummary turndownStatus(String turndownStatus) {
        this.setTurndownStatus(turndownStatus);
        return this;
    }

    public void setTurndownStatus(String turndownStatus) {
        this.turndownStatus = turndownStatus;
    }

    public String getBookedRoomCategory() {
        return this.bookedRoomCategory;
    }

    public ReservationSummary bookedRoomCategory(String bookedRoomCategory) {
        this.setBookedRoomCategory(bookedRoomCategory);
        return this;
    }

    public void setBookedRoomCategory(String bookedRoomCategory) {
        this.bookedRoomCategory = bookedRoomCategory;
    }

    public Integer getSourceProfId() {
        return this.sourceProfId;
    }

    public ReservationSummary sourceProfId(Integer sourceProfId) {
        this.setSourceProfId(sourceProfId);
        return this;
    }

    public void setSourceProfId(Integer sourceProfId) {
        this.sourceProfId = sourceProfId;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReservationSummary)) {
            return false;
        }
        return getId() != null && getId().equals(((ReservationSummary) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReservationSummary{" +
            "id=" + getId() +
            ", resort='" + getResort() + "'" +
            ", eventType='" + getEventType() + "'" +
            ", eventId='" + getEventId() + "'" +
            ", consideredDate='" + getConsideredDate() + "'" +
            ", roomCategory='" + getRoomCategory() + "'" +
            ", roomClass='" + getRoomClass() + "'" +
            ", marketCode='" + getMarketCode() + "'" +
            ", sourceCode='" + getSourceCode() + "'" +
            ", rateCode='" + getRateCode() + "'" +
            ", regionCode='" + getRegionCode() + "'" +
            ", groupId=" + getGroupId() +
            ", resvType='" + getResvType() + "'" +
            ", resvInvType='" + getResvInvType() + "'" +
            ", psuedoRoomYn='" + getPsuedoRoomYn() + "'" +
            ", arrRooms=" + getArrRooms() +
            ", adults=" + getAdults() +
            ", children=" + getChildren() +
            ", depRooms=" + getDepRooms() +
            ", noRooms=" + getNoRooms() +
            ", grossRate=" + getGrossRate() +
            ", netRoomRevenue=" + getNetRoomRevenue() +
            ", extraRevenue=" + getExtraRevenue() +
            ", ooRooms=" + getOoRooms() +
            ", osRooms=" + getOsRooms() +
            ", remainingBlockRooms=" + getRemainingBlockRooms() +
            ", pickedupBlockRooms=" + getPickedupBlockRooms() +
            ", singleOccupancy=" + getSingleOccupancy() +
            ", multipleOccupancy=" + getMultipleOccupancy() +
            ", blockStatus='" + getBlockStatus() + "'" +
            ", arrPersons=" + getArrPersons() +
            ", depPersons=" + getDepPersons() +
            ", wlRooms=" + getWlRooms() +
            ", wlPersons=" + getWlPersons() +
            ", dayUseRooms=" + getDayUseRooms() +
            ", dayUsePersons=" + getDayUsePersons() +
            ", bookingStatus='" + getBookingStatus() + "'" +
            ", resvStatus='" + getResvStatus() + "'" +
            ", dayUseYn='" + getDayUseYn() + "'" +
            ", channel='" + getChannel() + "'" +
            ", country='" + getCountry() + "'" +
            ", nationality='" + getNationality() + "'" +
            ", cribs=" + getCribs() +
            ", extraBeds=" + getExtraBeds() +
            ", adultsTaxFree=" + getAdultsTaxFree() +
            ", childrenTaxFree=" + getChildrenTaxFree() +
            ", rateCategory='" + getRateCategory() + "'" +
            ", rateClass='" + getRateClass() + "'" +
            ", roomRevenue=" + getRoomRevenue() +
            ", foodRevenue=" + getFoodRevenue() +
            ", otherRevenue=" + getOtherRevenue() +
            ", totalRevenue=" + getTotalRevenue() +
            ", nonRevenue=" + getNonRevenue() +
            ", allotmentHeaderId=" + getAllotmentHeaderId() +
            ", roomRevenueTax=" + getRoomRevenueTax() +
            ", foodRevenueTax=" + getFoodRevenueTax() +
            ", otherRevenueTax=" + getOtherRevenueTax() +
            ", totalRevenueTax=" + getTotalRevenueTax() +
            ", nonRevenueTax=" + getNonRevenueTax() +
            ", city='" + getCity() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            ", district='" + getDistrict() + "'" +
            ", state='" + getState() + "'" +
            ", children1=" + getChildren1() +
            ", children2=" + getChildren2() +
            ", children3=" + getChildren3() +
            ", children4=" + getChildren4() +
            ", children5=" + getChildren5() +
            ", ownerFfFlag='" + getOwnerFfFlag() + "'" +
            ", ownerRentalFlag='" + getOwnerRentalFlag() + "'" +
            ", fcGrossRate=" + getFcGrossRate() +
            ", fcNetRoomRevenue=" + getFcNetRoomRevenue() +
            ", fcExtraRevenue=" + getFcExtraRevenue() +
            ", fcRoomRevenue=" + getFcRoomRevenue() +
            ", fcFoodRevenue=" + getFcFoodRevenue() +
            ", fcOtherRevenue=" + getFcOtherRevenue() +
            ", fcTotalRevenue=" + getFcTotalRevenue() +
            ", fcNonRevenue=" + getFcNonRevenue() +
            ", fcRoomRevenueTax=" + getFcRoomRevenueTax() +
            ", fcFoodRevenueTax=" + getFcFoodRevenueTax() +
            ", fcOtherRevenueTax=" + getFcOtherRevenueTax() +
            ", fcTotalRevenueTax=" + getFcTotalRevenueTax() +
            ", fcNonRevenueTax=" + getFcNonRevenueTax() +
            ", currencyCode='" + getCurrencyCode() + "'" +
            ", exchangeDate='" + getExchangeDate() + "'" +
            ", updateBusinessDate='" + getUpdateBusinessDate() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", centralCurrencyCode='" + getCentralCurrencyCode() + "'" +
            ", centralExchangeRate=" + getCentralExchangeRate() +
            ", truncBeginDate='" + getTruncBeginDate() + "'" +
            ", truncEndDate='" + getTruncEndDate() + "'" +
            ", businessDateCreated='" + getBusinessDateCreated() + "'" +
            ", resInsertSource='" + getResInsertSource() + "'" +
            ", parentCompanyId=" + getParentCompanyId() +
            ", agentId=" + getAgentId() +
            ", gender='" + getGender() + "'" +
            ", vipStatus='" + getVipStatus() + "'" +
            ", quantity=" + getQuantity() +
            ", turndownStatus='" + getTurndownStatus() + "'" +
            ", bookedRoomCategory='" + getBookedRoomCategory() + "'" +
            ", sourceProfId=" + getSourceProfId() +
            "}";
    }
}
