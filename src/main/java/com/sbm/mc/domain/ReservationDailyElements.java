package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ReservationDailyElements.
 */
@Entity
@Table(name = "reservation_daily_elements")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReservationDailyElements implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "resort")
    private String resort;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "resv_daily_el_seq")
    private Integer resvDailyElSeq;

    @Column(name = "resv_status")
    private String resvStatus;

    @Column(name = "external_reference")
    private String externalReference;

    @Column(name = "room_class")
    private String roomClass;

    @Column(name = "room_category")
    private String roomCategory;

    @Column(name = "booked_room_category")
    private String bookedRoomCategory;

    @Column(name = "room")
    private String room;

    @Column(name = "cancellation_no")
    private Integer cancellationNo;

    @Column(name = "cancellation_date")
    private LocalDate cancellationDate;

    @Column(name = "cancellation_code")
    private String cancellationCode;

    @Column(name = "cancellation_reason_desc")
    private String cancellationReasonDesc;

    @Column(name = "guarantee_code")
    private String guaranteeCode;

    @Column(name = "market_code")
    private String marketCode;

    @Column(name = "origin_of_booking")
    private String originOfBooking;

    @Column(name = "exchange_rate")
    private Integer exchangeRate;

    @Column(name = "original_base_rate")
    private Integer originalBaseRate;

    @Column(name = "base_rate_amount")
    private Integer baseRateAmount;

    @Column(name = "rate_amount")
    private Integer rateAmount;

    @Column(name = "room_cost")
    private Integer roomCost;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "adults")
    private Integer adults;

    @Column(name = "children")
    private Integer children;

    @Column(name = "physical_quantity")
    private Integer physicalQuantity;

    @Column(name = "allotment_header_id")
    private Integer allotmentHeaderId;

    @Column(name = "day_use_yn")
    private String dayUseYn;

    @Column(name = "due_out_yn")
    private String dueOutYn;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "insert_action_instance_id")
    private Integer insertActionInstanceId;

    @Column(name = "dml_seq_no")
    private Integer dmlSeqNo;

    @Column(name = "ext_seq_no")
    private Integer extSeqNo;

    @Column(name = "ext_seg_no")
    private Integer extSegNo;

    @Column(name = "cribs")
    private Integer cribs;

    @Column(name = "extra_beds")
    private Integer extraBeds;

    @Column(name = "allotment_record_type")
    private String allotmentRecordType;

    @Column(name = "block_resort")
    private String blockResort;

    @Column(name = "block_id")
    private Integer blockId;

    @Column(name = "turndown_status")
    private String turndownStatus;

    @Column(name = "awd_upgr_from")
    private String awdUpgrFrom;

    @Column(name = "awd_upgr_to")
    private String awdUpgrTo;

    @Column(name = "hk_expected_service_time")
    private String hkExpectedServiceTime;

    @Column(name = "room_instructions")
    private String roomInstructions;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ReservationDailyElements id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResort() {
        return this.resort;
    }

    public ReservationDailyElements resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public LocalDate getReservationDate() {
        return this.reservationDate;
    }

    public ReservationDailyElements reservationDate(LocalDate reservationDate) {
        this.setReservationDate(reservationDate);
        return this;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getResvDailyElSeq() {
        return this.resvDailyElSeq;
    }

    public ReservationDailyElements resvDailyElSeq(Integer resvDailyElSeq) {
        this.setResvDailyElSeq(resvDailyElSeq);
        return this;
    }

    public void setResvDailyElSeq(Integer resvDailyElSeq) {
        this.resvDailyElSeq = resvDailyElSeq;
    }

    public String getResvStatus() {
        return this.resvStatus;
    }

    public ReservationDailyElements resvStatus(String resvStatus) {
        this.setResvStatus(resvStatus);
        return this;
    }

    public void setResvStatus(String resvStatus) {
        this.resvStatus = resvStatus;
    }

    public String getExternalReference() {
        return this.externalReference;
    }

    public ReservationDailyElements externalReference(String externalReference) {
        this.setExternalReference(externalReference);
        return this;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getRoomClass() {
        return this.roomClass;
    }

    public ReservationDailyElements roomClass(String roomClass) {
        this.setRoomClass(roomClass);
        return this;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public String getRoomCategory() {
        return this.roomCategory;
    }

    public ReservationDailyElements roomCategory(String roomCategory) {
        this.setRoomCategory(roomCategory);
        return this;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public String getBookedRoomCategory() {
        return this.bookedRoomCategory;
    }

    public ReservationDailyElements bookedRoomCategory(String bookedRoomCategory) {
        this.setBookedRoomCategory(bookedRoomCategory);
        return this;
    }

    public void setBookedRoomCategory(String bookedRoomCategory) {
        this.bookedRoomCategory = bookedRoomCategory;
    }

    public String getRoom() {
        return this.room;
    }

    public ReservationDailyElements room(String room) {
        this.setRoom(room);
        return this;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getCancellationNo() {
        return this.cancellationNo;
    }

    public ReservationDailyElements cancellationNo(Integer cancellationNo) {
        this.setCancellationNo(cancellationNo);
        return this;
    }

    public void setCancellationNo(Integer cancellationNo) {
        this.cancellationNo = cancellationNo;
    }

    public LocalDate getCancellationDate() {
        return this.cancellationDate;
    }

    public ReservationDailyElements cancellationDate(LocalDate cancellationDate) {
        this.setCancellationDate(cancellationDate);
        return this;
    }

    public void setCancellationDate(LocalDate cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public String getCancellationCode() {
        return this.cancellationCode;
    }

    public ReservationDailyElements cancellationCode(String cancellationCode) {
        this.setCancellationCode(cancellationCode);
        return this;
    }

    public void setCancellationCode(String cancellationCode) {
        this.cancellationCode = cancellationCode;
    }

    public String getCancellationReasonDesc() {
        return this.cancellationReasonDesc;
    }

    public ReservationDailyElements cancellationReasonDesc(String cancellationReasonDesc) {
        this.setCancellationReasonDesc(cancellationReasonDesc);
        return this;
    }

    public void setCancellationReasonDesc(String cancellationReasonDesc) {
        this.cancellationReasonDesc = cancellationReasonDesc;
    }

    public String getGuaranteeCode() {
        return this.guaranteeCode;
    }

    public ReservationDailyElements guaranteeCode(String guaranteeCode) {
        this.setGuaranteeCode(guaranteeCode);
        return this;
    }

    public void setGuaranteeCode(String guaranteeCode) {
        this.guaranteeCode = guaranteeCode;
    }

    public String getMarketCode() {
        return this.marketCode;
    }

    public ReservationDailyElements marketCode(String marketCode) {
        this.setMarketCode(marketCode);
        return this;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getOriginOfBooking() {
        return this.originOfBooking;
    }

    public ReservationDailyElements originOfBooking(String originOfBooking) {
        this.setOriginOfBooking(originOfBooking);
        return this;
    }

    public void setOriginOfBooking(String originOfBooking) {
        this.originOfBooking = originOfBooking;
    }

    public Integer getExchangeRate() {
        return this.exchangeRate;
    }

    public ReservationDailyElements exchangeRate(Integer exchangeRate) {
        this.setExchangeRate(exchangeRate);
        return this;
    }

    public void setExchangeRate(Integer exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Integer getOriginalBaseRate() {
        return this.originalBaseRate;
    }

    public ReservationDailyElements originalBaseRate(Integer originalBaseRate) {
        this.setOriginalBaseRate(originalBaseRate);
        return this;
    }

    public void setOriginalBaseRate(Integer originalBaseRate) {
        this.originalBaseRate = originalBaseRate;
    }

    public Integer getBaseRateAmount() {
        return this.baseRateAmount;
    }

    public ReservationDailyElements baseRateAmount(Integer baseRateAmount) {
        this.setBaseRateAmount(baseRateAmount);
        return this;
    }

    public void setBaseRateAmount(Integer baseRateAmount) {
        this.baseRateAmount = baseRateAmount;
    }

    public Integer getRateAmount() {
        return this.rateAmount;
    }

    public ReservationDailyElements rateAmount(Integer rateAmount) {
        this.setRateAmount(rateAmount);
        return this;
    }

    public void setRateAmount(Integer rateAmount) {
        this.rateAmount = rateAmount;
    }

    public Integer getRoomCost() {
        return this.roomCost;
    }

    public ReservationDailyElements roomCost(Integer roomCost) {
        this.setRoomCost(roomCost);
        return this;
    }

    public void setRoomCost(Integer roomCost) {
        this.roomCost = roomCost;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public ReservationDailyElements quantity(Integer quantity) {
        this.setQuantity(quantity);
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAdults() {
        return this.adults;
    }

    public ReservationDailyElements adults(Integer adults) {
        this.setAdults(adults);
        return this;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return this.children;
    }

    public ReservationDailyElements children(Integer children) {
        this.setChildren(children);
        return this;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getPhysicalQuantity() {
        return this.physicalQuantity;
    }

    public ReservationDailyElements physicalQuantity(Integer physicalQuantity) {
        this.setPhysicalQuantity(physicalQuantity);
        return this;
    }

    public void setPhysicalQuantity(Integer physicalQuantity) {
        this.physicalQuantity = physicalQuantity;
    }

    public Integer getAllotmentHeaderId() {
        return this.allotmentHeaderId;
    }

    public ReservationDailyElements allotmentHeaderId(Integer allotmentHeaderId) {
        this.setAllotmentHeaderId(allotmentHeaderId);
        return this;
    }

    public void setAllotmentHeaderId(Integer allotmentHeaderId) {
        this.allotmentHeaderId = allotmentHeaderId;
    }

    public String getDayUseYn() {
        return this.dayUseYn;
    }

    public ReservationDailyElements dayUseYn(String dayUseYn) {
        this.setDayUseYn(dayUseYn);
        return this;
    }

    public void setDayUseYn(String dayUseYn) {
        this.dayUseYn = dayUseYn;
    }

    public String getDueOutYn() {
        return this.dueOutYn;
    }

    public ReservationDailyElements dueOutYn(String dueOutYn) {
        this.setDueOutYn(dueOutYn);
        return this;
    }

    public void setDueOutYn(String dueOutYn) {
        this.dueOutYn = dueOutYn;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public ReservationDailyElements insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public ReservationDailyElements insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public ReservationDailyElements updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public ReservationDailyElements updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getInsertActionInstanceId() {
        return this.insertActionInstanceId;
    }

    public ReservationDailyElements insertActionInstanceId(Integer insertActionInstanceId) {
        this.setInsertActionInstanceId(insertActionInstanceId);
        return this;
    }

    public void setInsertActionInstanceId(Integer insertActionInstanceId) {
        this.insertActionInstanceId = insertActionInstanceId;
    }

    public Integer getDmlSeqNo() {
        return this.dmlSeqNo;
    }

    public ReservationDailyElements dmlSeqNo(Integer dmlSeqNo) {
        this.setDmlSeqNo(dmlSeqNo);
        return this;
    }

    public void setDmlSeqNo(Integer dmlSeqNo) {
        this.dmlSeqNo = dmlSeqNo;
    }

    public Integer getExtSeqNo() {
        return this.extSeqNo;
    }

    public ReservationDailyElements extSeqNo(Integer extSeqNo) {
        this.setExtSeqNo(extSeqNo);
        return this;
    }

    public void setExtSeqNo(Integer extSeqNo) {
        this.extSeqNo = extSeqNo;
    }

    public Integer getExtSegNo() {
        return this.extSegNo;
    }

    public ReservationDailyElements extSegNo(Integer extSegNo) {
        this.setExtSegNo(extSegNo);
        return this;
    }

    public void setExtSegNo(Integer extSegNo) {
        this.extSegNo = extSegNo;
    }

    public Integer getCribs() {
        return this.cribs;
    }

    public ReservationDailyElements cribs(Integer cribs) {
        this.setCribs(cribs);
        return this;
    }

    public void setCribs(Integer cribs) {
        this.cribs = cribs;
    }

    public Integer getExtraBeds() {
        return this.extraBeds;
    }

    public ReservationDailyElements extraBeds(Integer extraBeds) {
        this.setExtraBeds(extraBeds);
        return this;
    }

    public void setExtraBeds(Integer extraBeds) {
        this.extraBeds = extraBeds;
    }

    public String getAllotmentRecordType() {
        return this.allotmentRecordType;
    }

    public ReservationDailyElements allotmentRecordType(String allotmentRecordType) {
        this.setAllotmentRecordType(allotmentRecordType);
        return this;
    }

    public void setAllotmentRecordType(String allotmentRecordType) {
        this.allotmentRecordType = allotmentRecordType;
    }

    public String getBlockResort() {
        return this.blockResort;
    }

    public ReservationDailyElements blockResort(String blockResort) {
        this.setBlockResort(blockResort);
        return this;
    }

    public void setBlockResort(String blockResort) {
        this.blockResort = blockResort;
    }

    public Integer getBlockId() {
        return this.blockId;
    }

    public ReservationDailyElements blockId(Integer blockId) {
        this.setBlockId(blockId);
        return this;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getTurndownStatus() {
        return this.turndownStatus;
    }

    public ReservationDailyElements turndownStatus(String turndownStatus) {
        this.setTurndownStatus(turndownStatus);
        return this;
    }

    public void setTurndownStatus(String turndownStatus) {
        this.turndownStatus = turndownStatus;
    }

    public String getAwdUpgrFrom() {
        return this.awdUpgrFrom;
    }

    public ReservationDailyElements awdUpgrFrom(String awdUpgrFrom) {
        this.setAwdUpgrFrom(awdUpgrFrom);
        return this;
    }

    public void setAwdUpgrFrom(String awdUpgrFrom) {
        this.awdUpgrFrom = awdUpgrFrom;
    }

    public String getAwdUpgrTo() {
        return this.awdUpgrTo;
    }

    public ReservationDailyElements awdUpgrTo(String awdUpgrTo) {
        this.setAwdUpgrTo(awdUpgrTo);
        return this;
    }

    public void setAwdUpgrTo(String awdUpgrTo) {
        this.awdUpgrTo = awdUpgrTo;
    }

    public String getHkExpectedServiceTime() {
        return this.hkExpectedServiceTime;
    }

    public ReservationDailyElements hkExpectedServiceTime(String hkExpectedServiceTime) {
        this.setHkExpectedServiceTime(hkExpectedServiceTime);
        return this;
    }

    public void setHkExpectedServiceTime(String hkExpectedServiceTime) {
        this.hkExpectedServiceTime = hkExpectedServiceTime;
    }

    public String getRoomInstructions() {
        return this.roomInstructions;
    }

    public ReservationDailyElements roomInstructions(String roomInstructions) {
        this.setRoomInstructions(roomInstructions);
        return this;
    }

    public void setRoomInstructions(String roomInstructions) {
        this.roomInstructions = roomInstructions;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReservationDailyElements)) {
            return false;
        }
        return getId() != null && getId().equals(((ReservationDailyElements) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReservationDailyElements{" +
            "id=" + getId() +
            ", resort='" + getResort() + "'" +
            ", reservationDate='" + getReservationDate() + "'" +
            ", resvDailyElSeq=" + getResvDailyElSeq() +
            ", resvStatus='" + getResvStatus() + "'" +
            ", externalReference='" + getExternalReference() + "'" +
            ", roomClass='" + getRoomClass() + "'" +
            ", roomCategory='" + getRoomCategory() + "'" +
            ", bookedRoomCategory='" + getBookedRoomCategory() + "'" +
            ", room='" + getRoom() + "'" +
            ", cancellationNo=" + getCancellationNo() +
            ", cancellationDate='" + getCancellationDate() + "'" +
            ", cancellationCode='" + getCancellationCode() + "'" +
            ", cancellationReasonDesc='" + getCancellationReasonDesc() + "'" +
            ", guaranteeCode='" + getGuaranteeCode() + "'" +
            ", marketCode='" + getMarketCode() + "'" +
            ", originOfBooking='" + getOriginOfBooking() + "'" +
            ", exchangeRate=" + getExchangeRate() +
            ", originalBaseRate=" + getOriginalBaseRate() +
            ", baseRateAmount=" + getBaseRateAmount() +
            ", rateAmount=" + getRateAmount() +
            ", roomCost=" + getRoomCost() +
            ", quantity=" + getQuantity() +
            ", adults=" + getAdults() +
            ", children=" + getChildren() +
            ", physicalQuantity=" + getPhysicalQuantity() +
            ", allotmentHeaderId=" + getAllotmentHeaderId() +
            ", dayUseYn='" + getDayUseYn() + "'" +
            ", dueOutYn='" + getDueOutYn() + "'" +
            ", insertUser=" + getInsertUser() +
            ", insertDate='" + getInsertDate() + "'" +
            ", updateUser=" + getUpdateUser() +
            ", updateDate='" + getUpdateDate() + "'" +
            ", insertActionInstanceId=" + getInsertActionInstanceId() +
            ", dmlSeqNo=" + getDmlSeqNo() +
            ", extSeqNo=" + getExtSeqNo() +
            ", extSegNo=" + getExtSegNo() +
            ", cribs=" + getCribs() +
            ", extraBeds=" + getExtraBeds() +
            ", allotmentRecordType='" + getAllotmentRecordType() + "'" +
            ", blockResort='" + getBlockResort() + "'" +
            ", blockId=" + getBlockId() +
            ", turndownStatus='" + getTurndownStatus() + "'" +
            ", awdUpgrFrom='" + getAwdUpgrFrom() + "'" +
            ", awdUpgrTo='" + getAwdUpgrTo() + "'" +
            ", hkExpectedServiceTime='" + getHkExpectedServiceTime() + "'" +
            ", roomInstructions='" + getRoomInstructions() + "'" +
            "}";
    }
}
