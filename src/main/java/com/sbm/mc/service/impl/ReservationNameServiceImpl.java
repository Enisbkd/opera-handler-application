package com.sbm.mc.service.impl;

import com.sbm.mc.domain.ReservationName;
import com.sbm.mc.repository.ReservationNameRepository;
import com.sbm.mc.service.ReservationNameService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.ReservationName}.
 */
@Service
@Transactional
public class ReservationNameServiceImpl implements ReservationNameService {

    private final Logger log = LoggerFactory.getLogger(ReservationNameServiceImpl.class);

    private final ReservationNameRepository reservationNameRepository;

    public ReservationNameServiceImpl(ReservationNameRepository reservationNameRepository) {
        this.reservationNameRepository = reservationNameRepository;
    }

    @Override
    public ReservationName save(ReservationName reservationName) {
        log.debug("Request to save ReservationName : {}", reservationName);
        return reservationNameRepository.save(reservationName);
    }

    @Override
    public ReservationName update(ReservationName reservationName) {
        log.debug("Request to update ReservationName : {}", reservationName);
        return reservationNameRepository.save(reservationName);
    }

    @Override
    public Optional<ReservationName> partialUpdate(ReservationName reservationName) {
        log.debug("Request to partially update ReservationName : {}", reservationName);

        return reservationNameRepository
            .findById(reservationName.getId())
            .map(existingReservationName -> {
                if (reservationName.getResort() != null) {
                    existingReservationName.setResort(reservationName.getResort());
                }
                if (reservationName.getResvNameId() != null) {
                    existingReservationName.setResvNameId(reservationName.getResvNameId());
                }
                if (reservationName.getNameId() != null) {
                    existingReservationName.setNameId(reservationName.getNameId());
                }
                if (reservationName.getNameUsageType() != null) {
                    existingReservationName.setNameUsageType(reservationName.getNameUsageType());
                }
                if (reservationName.getContactNameId() != null) {
                    existingReservationName.setContactNameId(reservationName.getContactNameId());
                }
                if (reservationName.getInsertDate() != null) {
                    existingReservationName.setInsertDate(reservationName.getInsertDate());
                }
                if (reservationName.getInsertUser() != null) {
                    existingReservationName.setInsertUser(reservationName.getInsertUser());
                }
                if (reservationName.getUpdateUser() != null) {
                    existingReservationName.setUpdateUser(reservationName.getUpdateUser());
                }
                if (reservationName.getUpdateDate() != null) {
                    existingReservationName.setUpdateDate(reservationName.getUpdateDate());
                }
                if (reservationName.getResvStatus() != null) {
                    existingReservationName.setResvStatus(reservationName.getResvStatus());
                }
                if (reservationName.getCommissionCode() != null) {
                    existingReservationName.setCommissionCode(reservationName.getCommissionCode());
                }
                if (reservationName.getAddressId() != null) {
                    existingReservationName.setAddressId(reservationName.getAddressId());
                }
                if (reservationName.getPhoneId() != null) {
                    existingReservationName.setPhoneId(reservationName.getPhoneId());
                }
                if (reservationName.getFaxYn() != null) {
                    existingReservationName.setFaxYn(reservationName.getFaxYn());
                }
                if (reservationName.getMailYn() != null) {
                    existingReservationName.setMailYn(reservationName.getMailYn());
                }
                if (reservationName.getPrintRateYn() != null) {
                    existingReservationName.setPrintRateYn(reservationName.getPrintRateYn());
                }
                if (reservationName.getReportId() != null) {
                    existingReservationName.setReportId(reservationName.getReportId());
                }
                if (reservationName.getResvNo() != null) {
                    existingReservationName.setResvNo(reservationName.getResvNo());
                }
                if (reservationName.getConfirmationNo() != null) {
                    existingReservationName.setConfirmationNo(reservationName.getConfirmationNo());
                }
                if (reservationName.getBeginDate() != null) {
                    existingReservationName.setBeginDate(reservationName.getBeginDate());
                }
                if (reservationName.getEndDate() != null) {
                    existingReservationName.setEndDate(reservationName.getEndDate());
                }
                if (reservationName.getFaxId() != null) {
                    existingReservationName.setFaxId(reservationName.getFaxId());
                }
                if (reservationName.getEmailId() != null) {
                    existingReservationName.setEmailId(reservationName.getEmailId());
                }
                if (reservationName.getEmailYn() != null) {
                    existingReservationName.setEmailYn(reservationName.getEmailYn());
                }
                if (reservationName.getConsumerYn() != null) {
                    existingReservationName.setConsumerYn(reservationName.getConsumerYn());
                }
                if (reservationName.getCreditCardId() != null) {
                    existingReservationName.setCreditCardId(reservationName.getCreditCardId());
                }
                if (reservationName.getFinanciallyResponsibleYn() != null) {
                    existingReservationName.setFinanciallyResponsibleYn(reservationName.getFinanciallyResponsibleYn());
                }
                if (reservationName.getPaymentMethod() != null) {
                    existingReservationName.setPaymentMethod(reservationName.getPaymentMethod());
                }
                if (reservationName.getIntermediaryYn() != null) {
                    existingReservationName.setIntermediaryYn(reservationName.getIntermediaryYn());
                }
                if (reservationName.getPostingAllowedYn() != null) {
                    existingReservationName.setPostingAllowedYn(reservationName.getPostingAllowedYn());
                }
                if (reservationName.getDisplayColor() != null) {
                    existingReservationName.setDisplayColor(reservationName.getDisplayColor());
                }
                if (reservationName.getActualCheckInDate() != null) {
                    existingReservationName.setActualCheckInDate(reservationName.getActualCheckInDate());
                }
                if (reservationName.getTruncActualCheckInDate() != null) {
                    existingReservationName.setTruncActualCheckInDate(reservationName.getTruncActualCheckInDate());
                }
                if (reservationName.getActualCheckOutDate() != null) {
                    existingReservationName.setActualCheckOutDate(reservationName.getActualCheckOutDate());
                }
                if (reservationName.getTruncActualCheckOutDate() != null) {
                    existingReservationName.setTruncActualCheckOutDate(reservationName.getTruncActualCheckOutDate());
                }
                if (reservationName.getCreditLimit() != null) {
                    existingReservationName.setCreditLimit(reservationName.getCreditLimit());
                }
                if (reservationName.getAuthorizedBy() != null) {
                    existingReservationName.setAuthorizedBy(reservationName.getAuthorizedBy());
                }
                if (reservationName.getParentResvNameId() != null) {
                    existingReservationName.setParentResvNameId(reservationName.getParentResvNameId());
                }
                if (reservationName.getCancellationNo() != null) {
                    existingReservationName.setCancellationNo(reservationName.getCancellationNo());
                }
                if (reservationName.getCancellationReasonCode() != null) {
                    existingReservationName.setCancellationReasonCode(reservationName.getCancellationReasonCode());
                }
                if (reservationName.getCancellationReasonDesc() != null) {
                    existingReservationName.setCancellationReasonDesc(reservationName.getCancellationReasonDesc());
                }
                if (reservationName.getArrivalTransportType() != null) {
                    existingReservationName.setArrivalTransportType(reservationName.getArrivalTransportType());
                }
                if (reservationName.getArrivalStationCode() != null) {
                    existingReservationName.setArrivalStationCode(reservationName.getArrivalStationCode());
                }
                if (reservationName.getArrivalCarrierCode() != null) {
                    existingReservationName.setArrivalCarrierCode(reservationName.getArrivalCarrierCode());
                }
                if (reservationName.getArrivalTransportCode() != null) {
                    existingReservationName.setArrivalTransportCode(reservationName.getArrivalTransportCode());
                }
                if (reservationName.getArrivalDateTime() != null) {
                    existingReservationName.setArrivalDateTime(reservationName.getArrivalDateTime());
                }
                if (reservationName.getArrivalEstimateTime() != null) {
                    existingReservationName.setArrivalEstimateTime(reservationName.getArrivalEstimateTime());
                }
                if (reservationName.getArrivalTranportationYn() != null) {
                    existingReservationName.setArrivalTranportationYn(reservationName.getArrivalTranportationYn());
                }
                if (reservationName.getArrivalComments() != null) {
                    existingReservationName.setArrivalComments(reservationName.getArrivalComments());
                }
                if (reservationName.getDepartureTransportType() != null) {
                    existingReservationName.setDepartureTransportType(reservationName.getDepartureTransportType());
                }
                if (reservationName.getDepartureStationCode() != null) {
                    existingReservationName.setDepartureStationCode(reservationName.getDepartureStationCode());
                }
                if (reservationName.getDepartureCarrierCode() != null) {
                    existingReservationName.setDepartureCarrierCode(reservationName.getDepartureCarrierCode());
                }
                if (reservationName.getDepartureTransportCode() != null) {
                    existingReservationName.setDepartureTransportCode(reservationName.getDepartureTransportCode());
                }
                if (reservationName.getDepartureDateTime() != null) {
                    existingReservationName.setDepartureDateTime(reservationName.getDepartureDateTime());
                }
                if (reservationName.getDepartureEstimateTime() != null) {
                    existingReservationName.setDepartureEstimateTime(reservationName.getDepartureEstimateTime());
                }
                if (reservationName.getDepartureTransportationYn() != null) {
                    existingReservationName.setDepartureTransportationYn(reservationName.getDepartureTransportationYn());
                }
                if (reservationName.getDepartureComments() != null) {
                    existingReservationName.setDepartureComments(reservationName.getDepartureComments());
                }
                if (reservationName.getCancellationDate() != null) {
                    existingReservationName.setCancellationDate(reservationName.getCancellationDate());
                }
                if (reservationName.getGuaranteeCode() != null) {
                    existingReservationName.setGuaranteeCode(reservationName.getGuaranteeCode());
                }
                if (reservationName.getWlReasonDescription() != null) {
                    existingReservationName.setWlReasonDescription(reservationName.getWlReasonDescription());
                }
                if (reservationName.getWlReasonCode() != null) {
                    existingReservationName.setWlReasonCode(reservationName.getWlReasonCode());
                }
                if (reservationName.getWlPriority() != null) {
                    existingReservationName.setWlPriority(reservationName.getWlPriority());
                }
                if (reservationName.getDoNotMoveRoom() != null) {
                    existingReservationName.setDoNotMoveRoom(reservationName.getDoNotMoveRoom());
                }
                if (reservationName.getExternalReference() != null) {
                    existingReservationName.setExternalReference(reservationName.getExternalReference());
                }
                if (reservationName.getPartyCode() != null) {
                    existingReservationName.setPartyCode(reservationName.getPartyCode());
                }
                if (reservationName.getWalkinYn() != null) {
                    existingReservationName.setWalkinYn(reservationName.getWalkinYn());
                }
                if (reservationName.getOriginalEndDate() != null) {
                    existingReservationName.setOriginalEndDate(reservationName.getOriginalEndDate());
                }
                if (reservationName.getApprovalAmountCalcMethod() != null) {
                    existingReservationName.setApprovalAmountCalcMethod(reservationName.getApprovalAmountCalcMethod());
                }
                if (reservationName.getAmountPercent() != null) {
                    existingReservationName.setAmountPercent(reservationName.getAmountPercent());
                }
                if (reservationName.getNameTaxType() != null) {
                    existingReservationName.setNameTaxType(reservationName.getNameTaxType());
                }
                if (reservationName.getTaxExemptNo() != null) {
                    existingReservationName.setTaxExemptNo(reservationName.getTaxExemptNo());
                }
                if (reservationName.getRoomFeatures() != null) {
                    existingReservationName.setRoomFeatures(reservationName.getRoomFeatures());
                }
                if (reservationName.getWlTelephoneNo() != null) {
                    existingReservationName.setWlTelephoneNo(reservationName.getWlTelephoneNo());
                }
                if (reservationName.getVideoCheckoutYn() != null) {
                    existingReservationName.setVideoCheckoutYn(reservationName.getVideoCheckoutYn());
                }
                if (reservationName.getDiscountAmt() != null) {
                    existingReservationName.setDiscountAmt(reservationName.getDiscountAmt());
                }
                if (reservationName.getDiscountPrcnt() != null) {
                    existingReservationName.setDiscountPrcnt(reservationName.getDiscountPrcnt());
                }
                if (reservationName.getDiscountReasonCode() != null) {
                    existingReservationName.setDiscountReasonCode(reservationName.getDiscountReasonCode());
                }
                if (reservationName.getCommissionPaid() != null) {
                    existingReservationName.setCommissionPaid(reservationName.getCommissionPaid());
                }
                if (reservationName.getCommissionHoldCode() != null) {
                    existingReservationName.setCommissionHoldCode(reservationName.getCommissionHoldCode());
                }
                if (reservationName.getTruncBeginDate() != null) {
                    existingReservationName.setTruncBeginDate(reservationName.getTruncBeginDate());
                }
                if (reservationName.getTruncEndDate() != null) {
                    existingReservationName.setTruncEndDate(reservationName.getTruncEndDate());
                }
                if (reservationName.getSguestName() != null) {
                    existingReservationName.setSguestName(reservationName.getSguestName());
                }
                if (reservationName.getMembershipId() != null) {
                    existingReservationName.setMembershipId(reservationName.getMembershipId());
                }
                if (reservationName.getUdfc01() != null) {
                    existingReservationName.setUdfc01(reservationName.getUdfc01());
                }
                if (reservationName.getUdfc02() != null) {
                    existingReservationName.setUdfc02(reservationName.getUdfc02());
                }
                if (reservationName.getUdfc03() != null) {
                    existingReservationName.setUdfc03(reservationName.getUdfc03());
                }
                if (reservationName.getUdfc04() != null) {
                    existingReservationName.setUdfc04(reservationName.getUdfc04());
                }
                if (reservationName.getUdfc05() != null) {
                    existingReservationName.setUdfc05(reservationName.getUdfc05());
                }
                if (reservationName.getUdfc06() != null) {
                    existingReservationName.setUdfc06(reservationName.getUdfc06());
                }
                if (reservationName.getUdfc07() != null) {
                    existingReservationName.setUdfc07(reservationName.getUdfc07());
                }
                if (reservationName.getUdfc08() != null) {
                    existingReservationName.setUdfc08(reservationName.getUdfc08());
                }
                if (reservationName.getUdfc09() != null) {
                    existingReservationName.setUdfc09(reservationName.getUdfc09());
                }
                if (reservationName.getUdfc10() != null) {
                    existingReservationName.setUdfc10(reservationName.getUdfc10());
                }
                if (reservationName.getUdfc11() != null) {
                    existingReservationName.setUdfc11(reservationName.getUdfc11());
                }
                if (reservationName.getUdfc12() != null) {
                    existingReservationName.setUdfc12(reservationName.getUdfc12());
                }
                if (reservationName.getUdfc13() != null) {
                    existingReservationName.setUdfc13(reservationName.getUdfc13());
                }
                if (reservationName.getUdfc14() != null) {
                    existingReservationName.setUdfc14(reservationName.getUdfc14());
                }
                if (reservationName.getUdfc15() != null) {
                    existingReservationName.setUdfc15(reservationName.getUdfc15());
                }
                if (reservationName.getUdfc16() != null) {
                    existingReservationName.setUdfc16(reservationName.getUdfc16());
                }
                if (reservationName.getUdfc17() != null) {
                    existingReservationName.setUdfc17(reservationName.getUdfc17());
                }
                if (reservationName.getUdfc18() != null) {
                    existingReservationName.setUdfc18(reservationName.getUdfc18());
                }
                if (reservationName.getUdfc19() != null) {
                    existingReservationName.setUdfc19(reservationName.getUdfc19());
                }
                if (reservationName.getUdfc20() != null) {
                    existingReservationName.setUdfc20(reservationName.getUdfc20());
                }
                if (reservationName.getUdfc21() != null) {
                    existingReservationName.setUdfc21(reservationName.getUdfc21());
                }
                if (reservationName.getUdfc22() != null) {
                    existingReservationName.setUdfc22(reservationName.getUdfc22());
                }
                if (reservationName.getUdfc23() != null) {
                    existingReservationName.setUdfc23(reservationName.getUdfc23());
                }
                if (reservationName.getUdfc24() != null) {
                    existingReservationName.setUdfc24(reservationName.getUdfc24());
                }
                if (reservationName.getUdfc25() != null) {
                    existingReservationName.setUdfc25(reservationName.getUdfc25());
                }
                if (reservationName.getUdfc26() != null) {
                    existingReservationName.setUdfc26(reservationName.getUdfc26());
                }
                if (reservationName.getUdfc27() != null) {
                    existingReservationName.setUdfc27(reservationName.getUdfc27());
                }
                if (reservationName.getUdfc28() != null) {
                    existingReservationName.setUdfc28(reservationName.getUdfc28());
                }
                if (reservationName.getUdfc29() != null) {
                    existingReservationName.setUdfc29(reservationName.getUdfc29());
                }
                if (reservationName.getUdfc30() != null) {
                    existingReservationName.setUdfc30(reservationName.getUdfc30());
                }
                if (reservationName.getUdfc31() != null) {
                    existingReservationName.setUdfc31(reservationName.getUdfc31());
                }
                if (reservationName.getUdfc32() != null) {
                    existingReservationName.setUdfc32(reservationName.getUdfc32());
                }
                if (reservationName.getUdfc33() != null) {
                    existingReservationName.setUdfc33(reservationName.getUdfc33());
                }
                if (reservationName.getUdfc34() != null) {
                    existingReservationName.setUdfc34(reservationName.getUdfc34());
                }
                if (reservationName.getUdfc35() != null) {
                    existingReservationName.setUdfc35(reservationName.getUdfc35());
                }
                if (reservationName.getUdfc36() != null) {
                    existingReservationName.setUdfc36(reservationName.getUdfc36());
                }
                if (reservationName.getUdfc37() != null) {
                    existingReservationName.setUdfc37(reservationName.getUdfc37());
                }
                if (reservationName.getUdfc38() != null) {
                    existingReservationName.setUdfc38(reservationName.getUdfc38());
                }
                if (reservationName.getUdfc39() != null) {
                    existingReservationName.setUdfc39(reservationName.getUdfc39());
                }
                if (reservationName.getUdfc40() != null) {
                    existingReservationName.setUdfc40(reservationName.getUdfc40());
                }
                if (reservationName.getUdfn01() != null) {
                    existingReservationName.setUdfn01(reservationName.getUdfn01());
                }
                if (reservationName.getUdfn02() != null) {
                    existingReservationName.setUdfn02(reservationName.getUdfn02());
                }
                if (reservationName.getUdfn03() != null) {
                    existingReservationName.setUdfn03(reservationName.getUdfn03());
                }
                if (reservationName.getUdfn04() != null) {
                    existingReservationName.setUdfn04(reservationName.getUdfn04());
                }
                if (reservationName.getUdfn05() != null) {
                    existingReservationName.setUdfn05(reservationName.getUdfn05());
                }
                if (reservationName.getUdfn06() != null) {
                    existingReservationName.setUdfn06(reservationName.getUdfn06());
                }
                if (reservationName.getUdfn07() != null) {
                    existingReservationName.setUdfn07(reservationName.getUdfn07());
                }
                if (reservationName.getUdfn08() != null) {
                    existingReservationName.setUdfn08(reservationName.getUdfn08());
                }
                if (reservationName.getUdfn09() != null) {
                    existingReservationName.setUdfn09(reservationName.getUdfn09());
                }
                if (reservationName.getUdfn10() != null) {
                    existingReservationName.setUdfn10(reservationName.getUdfn10());
                }
                if (reservationName.getUdfn11() != null) {
                    existingReservationName.setUdfn11(reservationName.getUdfn11());
                }
                if (reservationName.getUdfn12() != null) {
                    existingReservationName.setUdfn12(reservationName.getUdfn12());
                }
                if (reservationName.getUdfn13() != null) {
                    existingReservationName.setUdfn13(reservationName.getUdfn13());
                }
                if (reservationName.getUdfn14() != null) {
                    existingReservationName.setUdfn14(reservationName.getUdfn14());
                }
                if (reservationName.getUdfn15() != null) {
                    existingReservationName.setUdfn15(reservationName.getUdfn15());
                }
                if (reservationName.getUdfn16() != null) {
                    existingReservationName.setUdfn16(reservationName.getUdfn16());
                }
                if (reservationName.getUdfn17() != null) {
                    existingReservationName.setUdfn17(reservationName.getUdfn17());
                }
                if (reservationName.getUdfn18() != null) {
                    existingReservationName.setUdfn18(reservationName.getUdfn18());
                }
                if (reservationName.getUdfn19() != null) {
                    existingReservationName.setUdfn19(reservationName.getUdfn19());
                }
                if (reservationName.getUdfn20() != null) {
                    existingReservationName.setUdfn20(reservationName.getUdfn20());
                }
                if (reservationName.getUdfn21() != null) {
                    existingReservationName.setUdfn21(reservationName.getUdfn21());
                }
                if (reservationName.getUdfn22() != null) {
                    existingReservationName.setUdfn22(reservationName.getUdfn22());
                }
                if (reservationName.getUdfn23() != null) {
                    existingReservationName.setUdfn23(reservationName.getUdfn23());
                }
                if (reservationName.getUdfn24() != null) {
                    existingReservationName.setUdfn24(reservationName.getUdfn24());
                }
                if (reservationName.getUdfn25() != null) {
                    existingReservationName.setUdfn25(reservationName.getUdfn25());
                }
                if (reservationName.getUdfn26() != null) {
                    existingReservationName.setUdfn26(reservationName.getUdfn26());
                }
                if (reservationName.getUdfn27() != null) {
                    existingReservationName.setUdfn27(reservationName.getUdfn27());
                }
                if (reservationName.getUdfn28() != null) {
                    existingReservationName.setUdfn28(reservationName.getUdfn28());
                }
                if (reservationName.getUdfn29() != null) {
                    existingReservationName.setUdfn29(reservationName.getUdfn29());
                }
                if (reservationName.getUdfn30() != null) {
                    existingReservationName.setUdfn30(reservationName.getUdfn30());
                }
                if (reservationName.getUdfn31() != null) {
                    existingReservationName.setUdfn31(reservationName.getUdfn31());
                }
                if (reservationName.getUdfn32() != null) {
                    existingReservationName.setUdfn32(reservationName.getUdfn32());
                }
                if (reservationName.getUdfn33() != null) {
                    existingReservationName.setUdfn33(reservationName.getUdfn33());
                }
                if (reservationName.getUdfn34() != null) {
                    existingReservationName.setUdfn34(reservationName.getUdfn34());
                }
                if (reservationName.getUdfn35() != null) {
                    existingReservationName.setUdfn35(reservationName.getUdfn35());
                }
                if (reservationName.getUdfn36() != null) {
                    existingReservationName.setUdfn36(reservationName.getUdfn36());
                }
                if (reservationName.getUdfn37() != null) {
                    existingReservationName.setUdfn37(reservationName.getUdfn37());
                }
                if (reservationName.getUdfn38() != null) {
                    existingReservationName.setUdfn38(reservationName.getUdfn38());
                }
                if (reservationName.getUdfn39() != null) {
                    existingReservationName.setUdfn39(reservationName.getUdfn39());
                }
                if (reservationName.getUdfn40() != null) {
                    existingReservationName.setUdfn40(reservationName.getUdfn40());
                }
                if (reservationName.getUdfd01() != null) {
                    existingReservationName.setUdfd01(reservationName.getUdfd01());
                }
                if (reservationName.getUdfd02() != null) {
                    existingReservationName.setUdfd02(reservationName.getUdfd02());
                }
                if (reservationName.getUdfd03() != null) {
                    existingReservationName.setUdfd03(reservationName.getUdfd03());
                }
                if (reservationName.getUdfd04() != null) {
                    existingReservationName.setUdfd04(reservationName.getUdfd04());
                }
                if (reservationName.getUdfd05() != null) {
                    existingReservationName.setUdfd05(reservationName.getUdfd05());
                }
                if (reservationName.getUdfd06() != null) {
                    existingReservationName.setUdfd06(reservationName.getUdfd06());
                }
                if (reservationName.getUdfd07() != null) {
                    existingReservationName.setUdfd07(reservationName.getUdfd07());
                }
                if (reservationName.getUdfd08() != null) {
                    existingReservationName.setUdfd08(reservationName.getUdfd08());
                }
                if (reservationName.getUdfd09() != null) {
                    existingReservationName.setUdfd09(reservationName.getUdfd09());
                }
                if (reservationName.getUdfd10() != null) {
                    existingReservationName.setUdfd10(reservationName.getUdfd10());
                }
                if (reservationName.getInsertActionInstanceId() != null) {
                    existingReservationName.setInsertActionInstanceId(reservationName.getInsertActionInstanceId());
                }
                if (reservationName.getDmlSeqNo() != null) {
                    existingReservationName.setDmlSeqNo(reservationName.getDmlSeqNo());
                }
                if (reservationName.getBusinessDateCreated() != null) {
                    existingReservationName.setBusinessDateCreated(reservationName.getBusinessDateCreated());
                }
                if (reservationName.getTurndownYn() != null) {
                    existingReservationName.setTurndownYn(reservationName.getTurndownYn());
                }
                if (reservationName.getRoomInstructions() != null) {
                    existingReservationName.setRoomInstructions(reservationName.getRoomInstructions());
                }
                if (reservationName.getRoomServiceTime() != null) {
                    existingReservationName.setRoomServiceTime(reservationName.getRoomServiceTime());
                }
                if (reservationName.getEventId() != null) {
                    existingReservationName.setEventId(reservationName.getEventId());
                }
                if (reservationName.getRevenueTypeCode() != null) {
                    existingReservationName.setRevenueTypeCode(reservationName.getRevenueTypeCode());
                }
                if (reservationName.getHurdle() != null) {
                    existingReservationName.setHurdle(reservationName.getHurdle());
                }
                if (reservationName.getHurdleOverride() != null) {
                    existingReservationName.setHurdleOverride(reservationName.getHurdleOverride());
                }
                if (reservationName.getRateableValue() != null) {
                    existingReservationName.setRateableValue(reservationName.getRateableValue());
                }
                if (reservationName.getRestrictionOverride() != null) {
                    existingReservationName.setRestrictionOverride(reservationName.getRestrictionOverride());
                }
                if (reservationName.getYieldableYn() != null) {
                    existingReservationName.setYieldableYn(reservationName.getYieldableYn());
                }
                if (reservationName.getSguestFirstname() != null) {
                    existingReservationName.setSguestFirstname(reservationName.getSguestFirstname());
                }
                if (reservationName.getGuestLastName() != null) {
                    existingReservationName.setGuestLastName(reservationName.getGuestLastName());
                }
                if (reservationName.getGuestFirstName() != null) {
                    existingReservationName.setGuestFirstName(reservationName.getGuestFirstName());
                }
                if (reservationName.getGuestLastNameSdx() != null) {
                    existingReservationName.setGuestLastNameSdx(reservationName.getGuestLastNameSdx());
                }
                if (reservationName.getGuestFirstNameSdx() != null) {
                    existingReservationName.setGuestFirstNameSdx(reservationName.getGuestFirstNameSdx());
                }
                if (reservationName.getChannel() != null) {
                    existingReservationName.setChannel(reservationName.getChannel());
                }
                if (reservationName.getShareSeqNo() != null) {
                    existingReservationName.setShareSeqNo(reservationName.getShareSeqNo());
                }
                if (reservationName.getGuestSignature() != null) {
                    existingReservationName.setGuestSignature(reservationName.getGuestSignature());
                }
                if (reservationName.getExtensionId() != null) {
                    existingReservationName.setExtensionId(reservationName.getExtensionId());
                }
                if (reservationName.getResvContactId() != null) {
                    existingReservationName.setResvContactId(reservationName.getResvContactId());
                }
                if (reservationName.getBillingContactId() != null) {
                    existingReservationName.setBillingContactId(reservationName.getBillingContactId());
                }
                if (reservationName.getResInsertSource() != null) {
                    existingReservationName.setResInsertSource(reservationName.getResInsertSource());
                }
                if (reservationName.getResInsertSourceType() != null) {
                    existingReservationName.setResInsertSourceType(reservationName.getResInsertSourceType());
                }
                if (reservationName.getMasterShare() != null) {
                    existingReservationName.setMasterShare(reservationName.getMasterShare());
                }
                if (reservationName.getRegistrationCardNo() != null) {
                    existingReservationName.setRegistrationCardNo(reservationName.getRegistrationCardNo());
                }
                if (reservationName.getTiad() != null) {
                    existingReservationName.setTiad(reservationName.getTiad());
                }
                if (reservationName.getPurposeOfStay() != null) {
                    existingReservationName.setPurposeOfStay(reservationName.getPurposeOfStay());
                }
                if (reservationName.getReinstateDate() != null) {
                    existingReservationName.setReinstateDate(reservationName.getReinstateDate());
                }
                if (reservationName.getPurgeDate() != null) {
                    existingReservationName.setPurgeDate(reservationName.getPurgeDate());
                }
                if (reservationName.getLastSettleDate() != null) {
                    existingReservationName.setLastSettleDate(reservationName.getLastSettleDate());
                }
                if (reservationName.getLastPeriodicFolioDate() != null) {
                    existingReservationName.setLastPeriodicFolioDate(reservationName.getLastPeriodicFolioDate());
                }
                if (reservationName.getPeriodicFolioFreq() != null) {
                    existingReservationName.setPeriodicFolioFreq(reservationName.getPeriodicFolioFreq());
                }
                if (reservationName.getConfirmationLegNo() != null) {
                    existingReservationName.setConfirmationLegNo(reservationName.getConfirmationLegNo());
                }
                if (reservationName.getGuestStatus() != null) {
                    existingReservationName.setGuestStatus(reservationName.getGuestStatus());
                }
                if (reservationName.getGuestType() != null) {
                    existingReservationName.setGuestType(reservationName.getGuestType());
                }
                if (reservationName.getCheckinDuration() != null) {
                    existingReservationName.setCheckinDuration(reservationName.getCheckinDuration());
                }
                if (reservationName.getAuthorizerId() != null) {
                    existingReservationName.setAuthorizerId(reservationName.getAuthorizerId());
                }
                if (reservationName.getLastOnlinePrintSeq() != null) {
                    existingReservationName.setLastOnlinePrintSeq(reservationName.getLastOnlinePrintSeq());
                }
                if (reservationName.getEntryPoint() != null) {
                    existingReservationName.setEntryPoint(reservationName.getEntryPoint());
                }
                if (reservationName.getEntryDate() != null) {
                    existingReservationName.setEntryDate(reservationName.getEntryDate());
                }
                if (reservationName.getPseudoMemType() != null) {
                    existingReservationName.setPseudoMemType(reservationName.getPseudoMemType());
                }
                if (reservationName.getPseudoMemTotalPoints() != null) {
                    existingReservationName.setPseudoMemTotalPoints(reservationName.getPseudoMemTotalPoints());
                }
                if (reservationName.getFolioText1() != null) {
                    existingReservationName.setFolioText1(reservationName.getFolioText1());
                }
                if (reservationName.getFolioText2() != null) {
                    existingReservationName.setFolioText2(reservationName.getFolioText2());
                }
                if (reservationName.getCompTypeCode() != null) {
                    existingReservationName.setCompTypeCode(reservationName.getCompTypeCode());
                }
                if (reservationName.getUniCardId() != null) {
                    existingReservationName.setUniCardId(reservationName.getUniCardId());
                }
                if (reservationName.getExpCheckinresId() != null) {
                    existingReservationName.setExpCheckinresId(reservationName.getExpCheckinresId());
                }
                if (reservationName.getOriginalBeginDate() != null) {
                    existingReservationName.setOriginalBeginDate(reservationName.getOriginalBeginDate());
                }
                if (reservationName.getOwnerFfFlag() != null) {
                    existingReservationName.setOwnerFfFlag(reservationName.getOwnerFfFlag());
                }
                if (reservationName.getCommissionPayoutTo() != null) {
                    existingReservationName.setCommissionPayoutTo(reservationName.getCommissionPayoutTo());
                }
                if (reservationName.getPreChargingYn() != null) {
                    existingReservationName.setPreChargingYn(reservationName.getPreChargingYn());
                }
                if (reservationName.getPostChargingYn() != null) {
                    existingReservationName.setPostChargingYn(reservationName.getPostChargingYn());
                }
                if (reservationName.getPostCoFlag() != null) {
                    existingReservationName.setPostCoFlag(reservationName.getPostCoFlag());
                }
                if (reservationName.getFolioCloseDate() != null) {
                    existingReservationName.setFolioCloseDate(reservationName.getFolioCloseDate());
                }
                if (reservationName.getScheduleCheckoutYn() != null) {
                    existingReservationName.setScheduleCheckoutYn(reservationName.getScheduleCheckoutYn());
                }
                if (reservationName.getCustomReference() != null) {
                    existingReservationName.setCustomReference(reservationName.getCustomReference());
                }
                if (reservationName.getGuaranteeCodePreCi() != null) {
                    existingReservationName.setGuaranteeCodePreCi(reservationName.getGuaranteeCodePreCi());
                }
                if (reservationName.getAwardMembershipId() != null) {
                    existingReservationName.setAwardMembershipId(reservationName.getAwardMembershipId());
                }
                if (reservationName.getEsignedRegCardName() != null) {
                    existingReservationName.setEsignedRegCardName(reservationName.getEsignedRegCardName());
                }
                if (reservationName.getStatisticalRoomType() != null) {
                    existingReservationName.setStatisticalRoomType(reservationName.getStatisticalRoomType());
                }
                if (reservationName.getStatisticalRateTier() != null) {
                    existingReservationName.setStatisticalRateTier(reservationName.getStatisticalRateTier());
                }
                if (reservationName.getYmCode() != null) {
                    existingReservationName.setYmCode(reservationName.getYmCode());
                }
                if (reservationName.getKeyValidUntil() != null) {
                    existingReservationName.setKeyValidUntil(reservationName.getKeyValidUntil());
                }
                if (reservationName.getPreRegisteredYn() != null) {
                    existingReservationName.setPreRegisteredYn(reservationName.getPreRegisteredYn());
                }
                if (reservationName.getTaxRegistrationNo() != null) {
                    existingReservationName.setTaxRegistrationNo(reservationName.getTaxRegistrationNo());
                }
                if (reservationName.getVisaNumber() != null) {
                    existingReservationName.setVisaNumber(reservationName.getVisaNumber());
                }
                if (reservationName.getVisaIssueDate() != null) {
                    existingReservationName.setVisaIssueDate(reservationName.getVisaIssueDate());
                }
                if (reservationName.getVisaExpirationDate() != null) {
                    existingReservationName.setVisaExpirationDate(reservationName.getVisaExpirationDate());
                }
                if (reservationName.getTaxNoOfStays() != null) {
                    existingReservationName.setTaxNoOfStays(reservationName.getTaxNoOfStays());
                }
                if (reservationName.getAsbProratedYn() != null) {
                    existingReservationName.setAsbProratedYn(reservationName.getAsbProratedYn());
                }
                if (reservationName.getAutoSettleDays() != null) {
                    existingReservationName.setAutoSettleDays(reservationName.getAutoSettleDays());
                }
                if (reservationName.getAutoSettleYn() != null) {
                    existingReservationName.setAutoSettleYn(reservationName.getAutoSettleYn());
                }
                if (reservationName.getSplitFromResvNameId() != null) {
                    existingReservationName.setSplitFromResvNameId(reservationName.getSplitFromResvNameId());
                }
                if (reservationName.getNextDestination() != null) {
                    existingReservationName.setNextDestination(reservationName.getNextDestination());
                }
                if (reservationName.getDateOfArrivalInCountry() != null) {
                    existingReservationName.setDateOfArrivalInCountry(reservationName.getDateOfArrivalInCountry());
                }
                if (reservationName.getPreArrReviewedDt() != null) {
                    existingReservationName.setPreArrReviewedDt(reservationName.getPreArrReviewedDt());
                }
                if (reservationName.getPreArrReviewedUser() != null) {
                    existingReservationName.setPreArrReviewedUser(reservationName.getPreArrReviewedUser());
                }
                if (reservationName.getBonusCheckId() != null) {
                    existingReservationName.setBonusCheckId(reservationName.getBonusCheckId());
                }
                if (reservationName.getMobileAudioKeyYn() != null) {
                    existingReservationName.setMobileAudioKeyYn(reservationName.getMobileAudioKeyYn());
                }
                if (reservationName.getDirectBillVerifyResponse() != null) {
                    existingReservationName.setDirectBillVerifyResponse(reservationName.getDirectBillVerifyResponse());
                }
                if (reservationName.getAddresseeNameId() != null) {
                    existingReservationName.setAddresseeNameId(reservationName.getAddresseeNameId());
                }
                if (reservationName.getSuperSearchIndexText() != null) {
                    existingReservationName.setSuperSearchIndexText(reservationName.getSuperSearchIndexText());
                }
                if (reservationName.getAutoCheckinYn() != null) {
                    existingReservationName.setAutoCheckinYn(reservationName.getAutoCheckinYn());
                }
                if (reservationName.getEmailFolioYn() != null) {
                    existingReservationName.setEmailFolioYn(reservationName.getEmailFolioYn());
                }
                if (reservationName.getEmailAddress() != null) {
                    existingReservationName.setEmailAddress(reservationName.getEmailAddress());
                }
                if (reservationName.getSpgUpgradeConfirmedRoomtype() != null) {
                    existingReservationName.setSpgUpgradeConfirmedRoomtype(reservationName.getSpgUpgradeConfirmedRoomtype());
                }
                if (reservationName.getSpgUpgradeReasonCode() != null) {
                    existingReservationName.setSpgUpgradeReasonCode(reservationName.getSpgUpgradeReasonCode());
                }
                if (reservationName.getSpgSuiteNightAwardStatus() != null) {
                    existingReservationName.setSpgSuiteNightAwardStatus(reservationName.getSpgSuiteNightAwardStatus());
                }
                if (reservationName.getSpgDiscloseRoomTypeYn() != null) {
                    existingReservationName.setSpgDiscloseRoomTypeYn(reservationName.getSpgDiscloseRoomTypeYn());
                }
                if (reservationName.getAmenityEligibleYn() != null) {
                    existingReservationName.setAmenityEligibleYn(reservationName.getAmenityEligibleYn());
                }
                if (reservationName.getAmenityLevelCode() != null) {
                    existingReservationName.setAmenityLevelCode(reservationName.getAmenityLevelCode());
                }
                if (reservationName.getBaseRateCurrencyCode() != null) {
                    existingReservationName.setBaseRateCurrencyCode(reservationName.getBaseRateCurrencyCode());
                }
                if (reservationName.getBaseRateCode() != null) {
                    existingReservationName.setBaseRateCode(reservationName.getBaseRateCode());
                }
                if (reservationName.getLocalBaseRateAmount() != null) {
                    existingReservationName.setLocalBaseRateAmount(reservationName.getLocalBaseRateAmount());
                }
                if (reservationName.getPhoneDisplayNameYn() != null) {
                    existingReservationName.setPhoneDisplayNameYn(reservationName.getPhoneDisplayNameYn());
                }
                if (reservationName.getResortChargeNumber() != null) {
                    existingReservationName.setResortChargeNumber(reservationName.getResortChargeNumber());
                }
                if (reservationName.getMobileChkoutAllowed() != null) {
                    existingReservationName.setMobileChkoutAllowed(reservationName.getMobileChkoutAllowed());
                }
                if (reservationName.getMobileViewFolioAllowed() != null) {
                    existingReservationName.setMobileViewFolioAllowed(reservationName.getMobileViewFolioAllowed());
                }
                if (reservationName.getHkExpectedServiceTime() != null) {
                    existingReservationName.setHkExpectedServiceTime(reservationName.getHkExpectedServiceTime());
                }
                if (reservationName.getEligibleForUpgradeYn() != null) {
                    existingReservationName.setEligibleForUpgradeYn(reservationName.getEligibleForUpgradeYn());
                }
                if (reservationName.getBeginSystemDateTime() != null) {
                    existingReservationName.setBeginSystemDateTime(reservationName.getBeginSystemDateTime());
                }
                if (reservationName.getMobileCheckinAllowedYn() != null) {
                    existingReservationName.setMobileCheckinAllowedYn(reservationName.getMobileCheckinAllowedYn());
                }
                if (reservationName.getQuoteId() != null) {
                    existingReservationName.setQuoteId(reservationName.getQuoteId());
                }
                if (reservationName.getManualCheckoutStatus() != null) {
                    existingReservationName.setManualCheckoutStatus(reservationName.getManualCheckoutStatus());
                }
                if (reservationName.getMobilePreferredCurrency() != null) {
                    existingReservationName.setMobilePreferredCurrency(reservationName.getMobilePreferredCurrency());
                }
                if (reservationName.getMobileActionAlertIssued() != null) {
                    existingReservationName.setMobileActionAlertIssued(reservationName.getMobileActionAlertIssued());
                }
                if (reservationName.getExternalEfolioYn() != null) {
                    existingReservationName.setExternalEfolioYn(reservationName.getExternalEfolioYn());
                }
                if (reservationName.getOptInBatchFolYn() != null) {
                    existingReservationName.setOptInBatchFolYn(reservationName.getOptInBatchFolYn());
                }
                if (reservationName.getFolioAddrElementId() != null) {
                    existingReservationName.setFolioAddrElementId(reservationName.getFolioAddrElementId());
                }
                if (reservationName.getOperaEsignedRegCardYn() != null) {
                    existingReservationName.setOperaEsignedRegCardYn(reservationName.getOperaEsignedRegCardYn());
                }
                if (reservationName.getResvGuid() != null) {
                    existingReservationName.setResvGuid(reservationName.getResvGuid());
                }
                if (reservationName.getAdvanceCheckedInYn() != null) {
                    existingReservationName.setAdvanceCheckedInYn(reservationName.getAdvanceCheckedInYn());
                }
                if (reservationName.getExpectedTimeOfReturn() != null) {
                    existingReservationName.setExpectedTimeOfReturn(reservationName.getExpectedTimeOfReturn());
                }
                if (reservationName.getEtrComments() != null) {
                    existingReservationName.setEtrComments(reservationName.getEtrComments());
                }
                if (reservationName.getOptedForCommYn() != null) {
                    existingReservationName.setOptedForCommYn(reservationName.getOptedForCommYn());
                }
                if (reservationName.getCreditLimitAutoPayAllowYn() != null) {
                    existingReservationName.setCreditLimitAutoPayAllowYn(reservationName.getCreditLimitAutoPayAllowYn());
                }

                return existingReservationName;
            })
            .map(reservationNameRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ReservationName> findAll(Pageable pageable) {
        log.debug("Request to get all ReservationNames");
        return reservationNameRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ReservationName> findOne(Long id) {
        log.debug("Request to get ReservationName : {}", id);
        return reservationNameRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ReservationName : {}", id);
        reservationNameRepository.deleteById(id);
    }
}
