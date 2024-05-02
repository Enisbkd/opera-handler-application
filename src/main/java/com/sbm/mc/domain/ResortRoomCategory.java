package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ResortRoomCategory.
 */
@Entity
@Table(name = "resort_room_category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ResortRoomCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "resort")
    private String resort;

    @Column(name = "room_category")
    private String roomCategory;

    @Column(name = "room_class")
    private String roomClass;

    @Column(name = "number_rooms")
    private Integer numberRooms;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "compiled")
    private String compiled;

    @Column(name = "psuedo_room_type")
    private String psuedoRoomType;

    @Column(name = "active_date")
    private LocalDate activeDate;

    @Column(name = "inactive_date")
    private LocalDate inactiveDate;

    @Column(name = "replaces_category")
    private String replacesCategory;

    @Column(name = "order_by")
    private Integer orderBy;

    @Column(name = "max_occupancy")
    private Integer maxOccupancy;

    @Column(name = "max_rollaways")
    private Integer maxRollaways;

    @Column(name = "rate_category")
    private String rateCategory;

    @Column(name = "jhi_label")
    private String label;

    @Column(name = "generic_flag")
    private String genericFlag;

    @Column(name = "suite_yn")
    private String suiteYn;

    @Column(name = "meetingroom_yn")
    private String meetingroomYn;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "rate_code")
    private String rateCode;

    @Column(name = "rate_amount", precision = 21, scale = 2)
    private BigDecimal rateAmount;

    @Column(name = "def_occupancy")
    private Integer defOccupancy;

    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "pseudo_yn")
    private String pseudoYn;

    @Column(name = "send_to_interface_yn")
    private String sendToInterfaceYn;

    @Column(name = "yieldable_yn")
    private String yieldableYn;

    @Column(name = "yield_category")
    private String yieldCategory;

    @Column(name = "housekeeping")
    private String housekeeping;

    @Column(name = "can_delete_yn")
    private String canDeleteYn;

    @Column(name = "roominfo_url")
    private String roominfoUrl;

    @Column(name = "owner_yn")
    private String ownerYn;

    @Column(name = "auto_include_yn")
    private String autoIncludeYn;

    @Column(name = "initial_round_up")
    private Integer initialRoundUp;

    @Column(name = "increments")
    private Integer increments;

    @Column(name = "rotation_group")
    private String rotationGroup;

    @Column(name = "sales_flag")
    private String salesFlag;

    @Column(name = "auto_room_assign_yn")
    private String autoRoomAssignYn;

    @Column(name = "upsell_yn")
    private String upsellYn;

    @Column(name = "orms_upsell_rank")
    private Integer ormsUpsellRank;

    @Column(name = "orms_upsell_amt", precision = 21, scale = 2)
    private BigDecimal ormsUpsellAmt;

    @Column(name = "orms_drxtra_adult")
    private Integer ormsDrxtraAdult;

    @Column(name = "orms_drxtra_child")
    private Integer ormsDrxtraChild;

    @Column(name = "max_occupancy_adults")
    private Integer maxOccupancyAdults;

    @Column(name = "max_occupancy_children")
    private Integer maxOccupancyChildren;

    @Column(name = "room_pool")
    private String roomPool;

    @Column(name = "member_award_room_grp")
    private String memberAwardRoomGrp;

    @Column(name = "orms_drxtra_2nd_adult")
    private Integer ormsDrxtra2ndAdult;

    @Column(name = "orms_drtier_1")
    private Integer ormsDrtier1;

    @Column(name = "orms_drtier_2")
    private Integer ormsDrtier2;

    @Column(name = "orms_drtier_3")
    private Integer ormsDrtier3;

    @Column(name = "auto_checkin_yn")
    private String autoCheckinYn;

    @Column(name = "rate_floor", precision = 21, scale = 2)
    private BigDecimal rateFloor;

    @Column(name = "max_fix_bed_occupancy")
    private Integer maxFixBedOccupancy;

    @Column(name = "maintenance_yn")
    private String maintenanceYn;

    @Column(name = "smoking_preference")
    private String smokingPreference;

    @Column(name = "s_label")
    private String sLabel;

    @Column(name = "s_bedtype")
    private String sBedtype;

    @Column(name = "sell_thru_rule_yn")
    private String sellThruRuleYn;

    @Column(name = "crs_description")
    private String crsDescription;

    @Column(name = "evisitor_facility_id")
    private String evisitorFacilityId;

    @Column(name = "min_occupancy")
    private Integer minOccupancy;

    @Column(name = "accessible_yn")
    private String accessibleYn;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ResortRoomCategory id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResort() {
        return this.resort;
    }

    public ResortRoomCategory resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public String getRoomCategory() {
        return this.roomCategory;
    }

    public ResortRoomCategory roomCategory(String roomCategory) {
        this.setRoomCategory(roomCategory);
        return this;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public String getRoomClass() {
        return this.roomClass;
    }

    public ResortRoomCategory roomClass(String roomClass) {
        this.setRoomClass(roomClass);
        return this;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public Integer getNumberRooms() {
        return this.numberRooms;
    }

    public ResortRoomCategory numberRooms(Integer numberRooms) {
        this.setNumberRooms(numberRooms);
        return this;
    }

    public void setNumberRooms(Integer numberRooms) {
        this.numberRooms = numberRooms;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public ResortRoomCategory shortDescription(String shortDescription) {
        this.setShortDescription(shortDescription);
        return this;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public ResortRoomCategory longDescription(String longDescription) {
        this.setLongDescription(longDescription);
        return this;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getCompiled() {
        return this.compiled;
    }

    public ResortRoomCategory compiled(String compiled) {
        this.setCompiled(compiled);
        return this;
    }

    public void setCompiled(String compiled) {
        this.compiled = compiled;
    }

    public String getPsuedoRoomType() {
        return this.psuedoRoomType;
    }

    public ResortRoomCategory psuedoRoomType(String psuedoRoomType) {
        this.setPsuedoRoomType(psuedoRoomType);
        return this;
    }

    public void setPsuedoRoomType(String psuedoRoomType) {
        this.psuedoRoomType = psuedoRoomType;
    }

    public LocalDate getActiveDate() {
        return this.activeDate;
    }

    public ResortRoomCategory activeDate(LocalDate activeDate) {
        this.setActiveDate(activeDate);
        return this;
    }

    public void setActiveDate(LocalDate activeDate) {
        this.activeDate = activeDate;
    }

    public LocalDate getInactiveDate() {
        return this.inactiveDate;
    }

    public ResortRoomCategory inactiveDate(LocalDate inactiveDate) {
        this.setInactiveDate(inactiveDate);
        return this;
    }

    public void setInactiveDate(LocalDate inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getReplacesCategory() {
        return this.replacesCategory;
    }

    public ResortRoomCategory replacesCategory(String replacesCategory) {
        this.setReplacesCategory(replacesCategory);
        return this;
    }

    public void setReplacesCategory(String replacesCategory) {
        this.replacesCategory = replacesCategory;
    }

    public Integer getOrderBy() {
        return this.orderBy;
    }

    public ResortRoomCategory orderBy(Integer orderBy) {
        this.setOrderBy(orderBy);
        return this;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getMaxOccupancy() {
        return this.maxOccupancy;
    }

    public ResortRoomCategory maxOccupancy(Integer maxOccupancy) {
        this.setMaxOccupancy(maxOccupancy);
        return this;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public Integer getMaxRollaways() {
        return this.maxRollaways;
    }

    public ResortRoomCategory maxRollaways(Integer maxRollaways) {
        this.setMaxRollaways(maxRollaways);
        return this;
    }

    public void setMaxRollaways(Integer maxRollaways) {
        this.maxRollaways = maxRollaways;
    }

    public String getRateCategory() {
        return this.rateCategory;
    }

    public ResortRoomCategory rateCategory(String rateCategory) {
        this.setRateCategory(rateCategory);
        return this;
    }

    public void setRateCategory(String rateCategory) {
        this.rateCategory = rateCategory;
    }

    public String getLabel() {
        return this.label;
    }

    public ResortRoomCategory label(String label) {
        this.setLabel(label);
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getGenericFlag() {
        return this.genericFlag;
    }

    public ResortRoomCategory genericFlag(String genericFlag) {
        this.setGenericFlag(genericFlag);
        return this;
    }

    public void setGenericFlag(String genericFlag) {
        this.genericFlag = genericFlag;
    }

    public String getSuiteYn() {
        return this.suiteYn;
    }

    public ResortRoomCategory suiteYn(String suiteYn) {
        this.setSuiteYn(suiteYn);
        return this;
    }

    public void setSuiteYn(String suiteYn) {
        this.suiteYn = suiteYn;
    }

    public String getMeetingroomYn() {
        return this.meetingroomYn;
    }

    public ResortRoomCategory meetingroomYn(String meetingroomYn) {
        this.setMeetingroomYn(meetingroomYn);
        return this;
    }

    public void setMeetingroomYn(String meetingroomYn) {
        this.meetingroomYn = meetingroomYn;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public ResortRoomCategory insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public ResortRoomCategory insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public ResortRoomCategory updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public ResortRoomCategory updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getRateCode() {
        return this.rateCode;
    }

    public ResortRoomCategory rateCode(String rateCode) {
        this.setRateCode(rateCode);
        return this;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public BigDecimal getRateAmount() {
        return this.rateAmount;
    }

    public ResortRoomCategory rateAmount(BigDecimal rateAmount) {
        this.setRateAmount(rateAmount);
        return this;
    }

    public void setRateAmount(BigDecimal rateAmount) {
        this.rateAmount = rateAmount;
    }

    public Integer getDefOccupancy() {
        return this.defOccupancy;
    }

    public ResortRoomCategory defOccupancy(Integer defOccupancy) {
        this.setDefOccupancy(defOccupancy);
        return this;
    }

    public void setDefOccupancy(Integer defOccupancy) {
        this.defOccupancy = defOccupancy;
    }

    public Integer getImageId() {
        return this.imageId;
    }

    public ResortRoomCategory imageId(Integer imageId) {
        this.setImageId(imageId);
        return this;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getPseudoYn() {
        return this.pseudoYn;
    }

    public ResortRoomCategory pseudoYn(String pseudoYn) {
        this.setPseudoYn(pseudoYn);
        return this;
    }

    public void setPseudoYn(String pseudoYn) {
        this.pseudoYn = pseudoYn;
    }

    public String getSendToInterfaceYn() {
        return this.sendToInterfaceYn;
    }

    public ResortRoomCategory sendToInterfaceYn(String sendToInterfaceYn) {
        this.setSendToInterfaceYn(sendToInterfaceYn);
        return this;
    }

    public void setSendToInterfaceYn(String sendToInterfaceYn) {
        this.sendToInterfaceYn = sendToInterfaceYn;
    }

    public String getYieldableYn() {
        return this.yieldableYn;
    }

    public ResortRoomCategory yieldableYn(String yieldableYn) {
        this.setYieldableYn(yieldableYn);
        return this;
    }

    public void setYieldableYn(String yieldableYn) {
        this.yieldableYn = yieldableYn;
    }

    public String getYieldCategory() {
        return this.yieldCategory;
    }

    public ResortRoomCategory yieldCategory(String yieldCategory) {
        this.setYieldCategory(yieldCategory);
        return this;
    }

    public void setYieldCategory(String yieldCategory) {
        this.yieldCategory = yieldCategory;
    }

    public String getHousekeeping() {
        return this.housekeeping;
    }

    public ResortRoomCategory housekeeping(String housekeeping) {
        this.setHousekeeping(housekeeping);
        return this;
    }

    public void setHousekeeping(String housekeeping) {
        this.housekeeping = housekeeping;
    }

    public String getCanDeleteYn() {
        return this.canDeleteYn;
    }

    public ResortRoomCategory canDeleteYn(String canDeleteYn) {
        this.setCanDeleteYn(canDeleteYn);
        return this;
    }

    public void setCanDeleteYn(String canDeleteYn) {
        this.canDeleteYn = canDeleteYn;
    }

    public String getRoominfoUrl() {
        return this.roominfoUrl;
    }

    public ResortRoomCategory roominfoUrl(String roominfoUrl) {
        this.setRoominfoUrl(roominfoUrl);
        return this;
    }

    public void setRoominfoUrl(String roominfoUrl) {
        this.roominfoUrl = roominfoUrl;
    }

    public String getOwnerYn() {
        return this.ownerYn;
    }

    public ResortRoomCategory ownerYn(String ownerYn) {
        this.setOwnerYn(ownerYn);
        return this;
    }

    public void setOwnerYn(String ownerYn) {
        this.ownerYn = ownerYn;
    }

    public String getAutoIncludeYn() {
        return this.autoIncludeYn;
    }

    public ResortRoomCategory autoIncludeYn(String autoIncludeYn) {
        this.setAutoIncludeYn(autoIncludeYn);
        return this;
    }

    public void setAutoIncludeYn(String autoIncludeYn) {
        this.autoIncludeYn = autoIncludeYn;
    }

    public Integer getInitialRoundUp() {
        return this.initialRoundUp;
    }

    public ResortRoomCategory initialRoundUp(Integer initialRoundUp) {
        this.setInitialRoundUp(initialRoundUp);
        return this;
    }

    public void setInitialRoundUp(Integer initialRoundUp) {
        this.initialRoundUp = initialRoundUp;
    }

    public Integer getIncrements() {
        return this.increments;
    }

    public ResortRoomCategory increments(Integer increments) {
        this.setIncrements(increments);
        return this;
    }

    public void setIncrements(Integer increments) {
        this.increments = increments;
    }

    public String getRotationGroup() {
        return this.rotationGroup;
    }

    public ResortRoomCategory rotationGroup(String rotationGroup) {
        this.setRotationGroup(rotationGroup);
        return this;
    }

    public void setRotationGroup(String rotationGroup) {
        this.rotationGroup = rotationGroup;
    }

    public String getSalesFlag() {
        return this.salesFlag;
    }

    public ResortRoomCategory salesFlag(String salesFlag) {
        this.setSalesFlag(salesFlag);
        return this;
    }

    public void setSalesFlag(String salesFlag) {
        this.salesFlag = salesFlag;
    }

    public String getAutoRoomAssignYn() {
        return this.autoRoomAssignYn;
    }

    public ResortRoomCategory autoRoomAssignYn(String autoRoomAssignYn) {
        this.setAutoRoomAssignYn(autoRoomAssignYn);
        return this;
    }

    public void setAutoRoomAssignYn(String autoRoomAssignYn) {
        this.autoRoomAssignYn = autoRoomAssignYn;
    }

    public String getUpsellYn() {
        return this.upsellYn;
    }

    public ResortRoomCategory upsellYn(String upsellYn) {
        this.setUpsellYn(upsellYn);
        return this;
    }

    public void setUpsellYn(String upsellYn) {
        this.upsellYn = upsellYn;
    }

    public Integer getOrmsUpsellRank() {
        return this.ormsUpsellRank;
    }

    public ResortRoomCategory ormsUpsellRank(Integer ormsUpsellRank) {
        this.setOrmsUpsellRank(ormsUpsellRank);
        return this;
    }

    public void setOrmsUpsellRank(Integer ormsUpsellRank) {
        this.ormsUpsellRank = ormsUpsellRank;
    }

    public BigDecimal getOrmsUpsellAmt() {
        return this.ormsUpsellAmt;
    }

    public ResortRoomCategory ormsUpsellAmt(BigDecimal ormsUpsellAmt) {
        this.setOrmsUpsellAmt(ormsUpsellAmt);
        return this;
    }

    public void setOrmsUpsellAmt(BigDecimal ormsUpsellAmt) {
        this.ormsUpsellAmt = ormsUpsellAmt;
    }

    public Integer getOrmsDrxtraAdult() {
        return this.ormsDrxtraAdult;
    }

    public ResortRoomCategory ormsDrxtraAdult(Integer ormsDrxtraAdult) {
        this.setOrmsDrxtraAdult(ormsDrxtraAdult);
        return this;
    }

    public void setOrmsDrxtraAdult(Integer ormsDrxtraAdult) {
        this.ormsDrxtraAdult = ormsDrxtraAdult;
    }

    public Integer getOrmsDrxtraChild() {
        return this.ormsDrxtraChild;
    }

    public ResortRoomCategory ormsDrxtraChild(Integer ormsDrxtraChild) {
        this.setOrmsDrxtraChild(ormsDrxtraChild);
        return this;
    }

    public void setOrmsDrxtraChild(Integer ormsDrxtraChild) {
        this.ormsDrxtraChild = ormsDrxtraChild;
    }

    public Integer getMaxOccupancyAdults() {
        return this.maxOccupancyAdults;
    }

    public ResortRoomCategory maxOccupancyAdults(Integer maxOccupancyAdults) {
        this.setMaxOccupancyAdults(maxOccupancyAdults);
        return this;
    }

    public void setMaxOccupancyAdults(Integer maxOccupancyAdults) {
        this.maxOccupancyAdults = maxOccupancyAdults;
    }

    public Integer getMaxOccupancyChildren() {
        return this.maxOccupancyChildren;
    }

    public ResortRoomCategory maxOccupancyChildren(Integer maxOccupancyChildren) {
        this.setMaxOccupancyChildren(maxOccupancyChildren);
        return this;
    }

    public void setMaxOccupancyChildren(Integer maxOccupancyChildren) {
        this.maxOccupancyChildren = maxOccupancyChildren;
    }

    public String getRoomPool() {
        return this.roomPool;
    }

    public ResortRoomCategory roomPool(String roomPool) {
        this.setRoomPool(roomPool);
        return this;
    }

    public void setRoomPool(String roomPool) {
        this.roomPool = roomPool;
    }

    public String getMemberAwardRoomGrp() {
        return this.memberAwardRoomGrp;
    }

    public ResortRoomCategory memberAwardRoomGrp(String memberAwardRoomGrp) {
        this.setMemberAwardRoomGrp(memberAwardRoomGrp);
        return this;
    }

    public void setMemberAwardRoomGrp(String memberAwardRoomGrp) {
        this.memberAwardRoomGrp = memberAwardRoomGrp;
    }

    public Integer getOrmsDrxtra2ndAdult() {
        return this.ormsDrxtra2ndAdult;
    }

    public ResortRoomCategory ormsDrxtra2ndAdult(Integer ormsDrxtra2ndAdult) {
        this.setOrmsDrxtra2ndAdult(ormsDrxtra2ndAdult);
        return this;
    }

    public void setOrmsDrxtra2ndAdult(Integer ormsDrxtra2ndAdult) {
        this.ormsDrxtra2ndAdult = ormsDrxtra2ndAdult;
    }

    public Integer getOrmsDrtier1() {
        return this.ormsDrtier1;
    }

    public ResortRoomCategory ormsDrtier1(Integer ormsDrtier1) {
        this.setOrmsDrtier1(ormsDrtier1);
        return this;
    }

    public void setOrmsDrtier1(Integer ormsDrtier1) {
        this.ormsDrtier1 = ormsDrtier1;
    }

    public Integer getOrmsDrtier2() {
        return this.ormsDrtier2;
    }

    public ResortRoomCategory ormsDrtier2(Integer ormsDrtier2) {
        this.setOrmsDrtier2(ormsDrtier2);
        return this;
    }

    public void setOrmsDrtier2(Integer ormsDrtier2) {
        this.ormsDrtier2 = ormsDrtier2;
    }

    public Integer getOrmsDrtier3() {
        return this.ormsDrtier3;
    }

    public ResortRoomCategory ormsDrtier3(Integer ormsDrtier3) {
        this.setOrmsDrtier3(ormsDrtier3);
        return this;
    }

    public void setOrmsDrtier3(Integer ormsDrtier3) {
        this.ormsDrtier3 = ormsDrtier3;
    }

    public String getAutoCheckinYn() {
        return this.autoCheckinYn;
    }

    public ResortRoomCategory autoCheckinYn(String autoCheckinYn) {
        this.setAutoCheckinYn(autoCheckinYn);
        return this;
    }

    public void setAutoCheckinYn(String autoCheckinYn) {
        this.autoCheckinYn = autoCheckinYn;
    }

    public BigDecimal getRateFloor() {
        return this.rateFloor;
    }

    public ResortRoomCategory rateFloor(BigDecimal rateFloor) {
        this.setRateFloor(rateFloor);
        return this;
    }

    public void setRateFloor(BigDecimal rateFloor) {
        this.rateFloor = rateFloor;
    }

    public Integer getMaxFixBedOccupancy() {
        return this.maxFixBedOccupancy;
    }

    public ResortRoomCategory maxFixBedOccupancy(Integer maxFixBedOccupancy) {
        this.setMaxFixBedOccupancy(maxFixBedOccupancy);
        return this;
    }

    public void setMaxFixBedOccupancy(Integer maxFixBedOccupancy) {
        this.maxFixBedOccupancy = maxFixBedOccupancy;
    }

    public String getMaintenanceYn() {
        return this.maintenanceYn;
    }

    public ResortRoomCategory maintenanceYn(String maintenanceYn) {
        this.setMaintenanceYn(maintenanceYn);
        return this;
    }

    public void setMaintenanceYn(String maintenanceYn) {
        this.maintenanceYn = maintenanceYn;
    }

    public String getSmokingPreference() {
        return this.smokingPreference;
    }

    public ResortRoomCategory smokingPreference(String smokingPreference) {
        this.setSmokingPreference(smokingPreference);
        return this;
    }

    public void setSmokingPreference(String smokingPreference) {
        this.smokingPreference = smokingPreference;
    }

    public String getsLabel() {
        return this.sLabel;
    }

    public ResortRoomCategory sLabel(String sLabel) {
        this.setsLabel(sLabel);
        return this;
    }

    public void setsLabel(String sLabel) {
        this.sLabel = sLabel;
    }

    public String getsBedtype() {
        return this.sBedtype;
    }

    public ResortRoomCategory sBedtype(String sBedtype) {
        this.setsBedtype(sBedtype);
        return this;
    }

    public void setsBedtype(String sBedtype) {
        this.sBedtype = sBedtype;
    }

    public String getSellThruRuleYn() {
        return this.sellThruRuleYn;
    }

    public ResortRoomCategory sellThruRuleYn(String sellThruRuleYn) {
        this.setSellThruRuleYn(sellThruRuleYn);
        return this;
    }

    public void setSellThruRuleYn(String sellThruRuleYn) {
        this.sellThruRuleYn = sellThruRuleYn;
    }

    public String getCrsDescription() {
        return this.crsDescription;
    }

    public ResortRoomCategory crsDescription(String crsDescription) {
        this.setCrsDescription(crsDescription);
        return this;
    }

    public void setCrsDescription(String crsDescription) {
        this.crsDescription = crsDescription;
    }

    public String getEvisitorFacilityId() {
        return this.evisitorFacilityId;
    }

    public ResortRoomCategory evisitorFacilityId(String evisitorFacilityId) {
        this.setEvisitorFacilityId(evisitorFacilityId);
        return this;
    }

    public void setEvisitorFacilityId(String evisitorFacilityId) {
        this.evisitorFacilityId = evisitorFacilityId;
    }

    public Integer getMinOccupancy() {
        return this.minOccupancy;
    }

    public ResortRoomCategory minOccupancy(Integer minOccupancy) {
        this.setMinOccupancy(minOccupancy);
        return this;
    }

    public void setMinOccupancy(Integer minOccupancy) {
        this.minOccupancy = minOccupancy;
    }

    public String getAccessibleYn() {
        return this.accessibleYn;
    }

    public ResortRoomCategory accessibleYn(String accessibleYn) {
        this.setAccessibleYn(accessibleYn);
        return this;
    }

    public void setAccessibleYn(String accessibleYn) {
        this.accessibleYn = accessibleYn;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResortRoomCategory)) {
            return false;
        }
        return getId() != null && getId().equals(((ResortRoomCategory) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ResortRoomCategory{" +
            "id=" + getId() +
            ", resort='" + getResort() + "'" +
            ", roomCategory='" + getRoomCategory() + "'" +
            ", roomClass='" + getRoomClass() + "'" +
            ", numberRooms=" + getNumberRooms() +
            ", shortDescription='" + getShortDescription() + "'" +
            ", longDescription='" + getLongDescription() + "'" +
            ", compiled='" + getCompiled() + "'" +
            ", psuedoRoomType='" + getPsuedoRoomType() + "'" +
            ", activeDate='" + getActiveDate() + "'" +
            ", inactiveDate='" + getInactiveDate() + "'" +
            ", replacesCategory='" + getReplacesCategory() + "'" +
            ", orderBy=" + getOrderBy() +
            ", maxOccupancy=" + getMaxOccupancy() +
            ", maxRollaways=" + getMaxRollaways() +
            ", rateCategory='" + getRateCategory() + "'" +
            ", label='" + getLabel() + "'" +
            ", genericFlag='" + getGenericFlag() + "'" +
            ", suiteYn='" + getSuiteYn() + "'" +
            ", meetingroomYn='" + getMeetingroomYn() + "'" +
            ", insertUser=" + getInsertUser() +
            ", insertDate='" + getInsertDate() + "'" +
            ", updateUser=" + getUpdateUser() +
            ", updateDate='" + getUpdateDate() + "'" +
            ", rateCode='" + getRateCode() + "'" +
            ", rateAmount=" + getRateAmount() +
            ", defOccupancy=" + getDefOccupancy() +
            ", imageId=" + getImageId() +
            ", pseudoYn='" + getPseudoYn() + "'" +
            ", sendToInterfaceYn='" + getSendToInterfaceYn() + "'" +
            ", yieldableYn='" + getYieldableYn() + "'" +
            ", yieldCategory='" + getYieldCategory() + "'" +
            ", housekeeping='" + getHousekeeping() + "'" +
            ", canDeleteYn='" + getCanDeleteYn() + "'" +
            ", roominfoUrl='" + getRoominfoUrl() + "'" +
            ", ownerYn='" + getOwnerYn() + "'" +
            ", autoIncludeYn='" + getAutoIncludeYn() + "'" +
            ", initialRoundUp=" + getInitialRoundUp() +
            ", increments=" + getIncrements() +
            ", rotationGroup='" + getRotationGroup() + "'" +
            ", salesFlag='" + getSalesFlag() + "'" +
            ", autoRoomAssignYn='" + getAutoRoomAssignYn() + "'" +
            ", upsellYn='" + getUpsellYn() + "'" +
            ", ormsUpsellRank=" + getOrmsUpsellRank() +
            ", ormsUpsellAmt=" + getOrmsUpsellAmt() +
            ", ormsDrxtraAdult=" + getOrmsDrxtraAdult() +
            ", ormsDrxtraChild=" + getOrmsDrxtraChild() +
            ", maxOccupancyAdults=" + getMaxOccupancyAdults() +
            ", maxOccupancyChildren=" + getMaxOccupancyChildren() +
            ", roomPool='" + getRoomPool() + "'" +
            ", memberAwardRoomGrp='" + getMemberAwardRoomGrp() + "'" +
            ", ormsDrxtra2ndAdult=" + getOrmsDrxtra2ndAdult() +
            ", ormsDrtier1=" + getOrmsDrtier1() +
            ", ormsDrtier2=" + getOrmsDrtier2() +
            ", ormsDrtier3=" + getOrmsDrtier3() +
            ", autoCheckinYn='" + getAutoCheckinYn() + "'" +
            ", rateFloor=" + getRateFloor() +
            ", maxFixBedOccupancy=" + getMaxFixBedOccupancy() +
            ", maintenanceYn='" + getMaintenanceYn() + "'" +
            ", smokingPreference='" + getSmokingPreference() + "'" +
            ", sLabel='" + getsLabel() + "'" +
            ", sBedtype='" + getsBedtype() + "'" +
            ", sellThruRuleYn='" + getSellThruRuleYn() + "'" +
            ", crsDescription='" + getCrsDescription() + "'" +
            ", evisitorFacilityId='" + getEvisitorFacilityId() + "'" +
            ", minOccupancy=" + getMinOccupancy() +
            ", accessibleYn='" + getAccessibleYn() + "'" +
            "}";
    }
}
