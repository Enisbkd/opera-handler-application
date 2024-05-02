package com.sbm.mc.service.impl;

import com.sbm.mc.domain.ReservationDailyElementName;
import com.sbm.mc.repository.ReservationDailyElementNameRepository;
import com.sbm.mc.service.ReservationDailyElementNameService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.ReservationDailyElementName}.
 */
@Service
@Transactional
public class ReservationDailyElementNameServiceImpl implements ReservationDailyElementNameService {

    private final Logger log = LoggerFactory.getLogger(ReservationDailyElementNameServiceImpl.class);

    private final ReservationDailyElementNameRepository reservationDailyElementNameRepository;

    public ReservationDailyElementNameServiceImpl(ReservationDailyElementNameRepository reservationDailyElementNameRepository) {
        this.reservationDailyElementNameRepository = reservationDailyElementNameRepository;
    }

    @Override
    public ReservationDailyElementName save(ReservationDailyElementName reservationDailyElementName) {
        log.debug("Request to save ReservationDailyElementName : {}", reservationDailyElementName);
        return reservationDailyElementNameRepository.save(reservationDailyElementName);
    }

    @Override
    public ReservationDailyElementName update(ReservationDailyElementName reservationDailyElementName) {
        log.debug("Request to update ReservationDailyElementName : {}", reservationDailyElementName);
        return reservationDailyElementNameRepository.save(reservationDailyElementName);
    }

    @Override
    public Optional<ReservationDailyElementName> partialUpdate(ReservationDailyElementName reservationDailyElementName) {
        log.debug("Request to partially update ReservationDailyElementName : {}", reservationDailyElementName);

        return reservationDailyElementNameRepository
            .findById(reservationDailyElementName.getId())
            .map(existingReservationDailyElementName -> {
                if (reservationDailyElementName.getResort() != null) {
                    existingReservationDailyElementName.setResort(reservationDailyElementName.getResort());
                }
                if (reservationDailyElementName.getResvNameId() != null) {
                    existingReservationDailyElementName.setResvNameId(reservationDailyElementName.getResvNameId());
                }
                if (reservationDailyElementName.getReservationDate() != null) {
                    existingReservationDailyElementName.setReservationDate(reservationDailyElementName.getReservationDate());
                }
                if (reservationDailyElementName.getResvDailyElSeq() != null) {
                    existingReservationDailyElementName.setResvDailyElSeq(reservationDailyElementName.getResvDailyElSeq());
                }
                if (reservationDailyElementName.getTravelAgentId() != null) {
                    existingReservationDailyElementName.setTravelAgentId(reservationDailyElementName.getTravelAgentId());
                }
                if (reservationDailyElementName.getCompanyId() != null) {
                    existingReservationDailyElementName.setCompanyId(reservationDailyElementName.getCompanyId());
                }
                if (reservationDailyElementName.getSourceId() != null) {
                    existingReservationDailyElementName.setSourceId(reservationDailyElementName.getSourceId());
                }
                if (reservationDailyElementName.getGroupId() != null) {
                    existingReservationDailyElementName.setGroupId(reservationDailyElementName.getGroupId());
                }
                if (reservationDailyElementName.getSharePaymentType() != null) {
                    existingReservationDailyElementName.setSharePaymentType(reservationDailyElementName.getSharePaymentType());
                }
                if (reservationDailyElementName.getShareAmount() != null) {
                    existingReservationDailyElementName.setShareAmount(reservationDailyElementName.getShareAmount());
                }
                if (reservationDailyElementName.getSharePrcnt() != null) {
                    existingReservationDailyElementName.setSharePrcnt(reservationDailyElementName.getSharePrcnt());
                }
                if (reservationDailyElementName.getAdults() != null) {
                    existingReservationDailyElementName.setAdults(reservationDailyElementName.getAdults());
                }
                if (reservationDailyElementName.getChildren() != null) {
                    existingReservationDailyElementName.setChildren(reservationDailyElementName.getChildren());
                }
                if (reservationDailyElementName.getDiscountAmt() != null) {
                    existingReservationDailyElementName.setDiscountAmt(reservationDailyElementName.getDiscountAmt());
                }
                if (reservationDailyElementName.getDiscountPrcnt() != null) {
                    existingReservationDailyElementName.setDiscountPrcnt(reservationDailyElementName.getDiscountPrcnt());
                }
                if (reservationDailyElementName.getDiscountReasonCode() != null) {
                    existingReservationDailyElementName.setDiscountReasonCode(reservationDailyElementName.getDiscountReasonCode());
                }
                if (reservationDailyElementName.getFixedRateYn() != null) {
                    existingReservationDailyElementName.setFixedRateYn(reservationDailyElementName.getFixedRateYn());
                }
                if (reservationDailyElementName.getBaseRateAmount() != null) {
                    existingReservationDailyElementName.setBaseRateAmount(reservationDailyElementName.getBaseRateAmount());
                }
                if (reservationDailyElementName.getAutoPostAmount() != null) {
                    existingReservationDailyElementName.setAutoPostAmount(reservationDailyElementName.getAutoPostAmount());
                }
                if (reservationDailyElementName.getSharePriority() != null) {
                    existingReservationDailyElementName.setSharePriority(reservationDailyElementName.getSharePriority());
                }
                if (reservationDailyElementName.getInsertUser() != null) {
                    existingReservationDailyElementName.setInsertUser(reservationDailyElementName.getInsertUser());
                }
                if (reservationDailyElementName.getInsertDate() != null) {
                    existingReservationDailyElementName.setInsertDate(reservationDailyElementName.getInsertDate());
                }
                if (reservationDailyElementName.getUpdateUser() != null) {
                    existingReservationDailyElementName.setUpdateUser(reservationDailyElementName.getUpdateUser());
                }
                if (reservationDailyElementName.getUpdateDate() != null) {
                    existingReservationDailyElementName.setUpdateDate(reservationDailyElementName.getUpdateDate());
                }
                if (reservationDailyElementName.getLastShareCalculation() != null) {
                    existingReservationDailyElementName.setLastShareCalculation(reservationDailyElementName.getLastShareCalculation());
                }
                if (reservationDailyElementName.getInsertActionInstanceId() != null) {
                    existingReservationDailyElementName.setInsertActionInstanceId(reservationDailyElementName.getInsertActionInstanceId());
                }
                if (reservationDailyElementName.getDmlSeqNo() != null) {
                    existingReservationDailyElementName.setDmlSeqNo(reservationDailyElementName.getDmlSeqNo());
                }
                if (reservationDailyElementName.getNetRoomAmt() != null) {
                    existingReservationDailyElementName.setNetRoomAmt(reservationDailyElementName.getNetRoomAmt());
                }
                if (reservationDailyElementName.getRoomTax() != null) {
                    existingReservationDailyElementName.setRoomTax(reservationDailyElementName.getRoomTax());
                }
                if (reservationDailyElementName.getPkgAmt() != null) {
                    existingReservationDailyElementName.setPkgAmt(reservationDailyElementName.getPkgAmt());
                }
                if (reservationDailyElementName.getPkgTax() != null) {
                    existingReservationDailyElementName.setPkgTax(reservationDailyElementName.getPkgTax());
                }
                if (reservationDailyElementName.getGrossRateAmt() != null) {
                    existingReservationDailyElementName.setGrossRateAmt(reservationDailyElementName.getGrossRateAmt());
                }
                if (reservationDailyElementName.getAdultsTaxFree() != null) {
                    existingReservationDailyElementName.setAdultsTaxFree(reservationDailyElementName.getAdultsTaxFree());
                }
                if (reservationDailyElementName.getChildrenTaxFree() != null) {
                    existingReservationDailyElementName.setChildrenTaxFree(reservationDailyElementName.getChildrenTaxFree());
                }
                if (reservationDailyElementName.getChildren1() != null) {
                    existingReservationDailyElementName.setChildren1(reservationDailyElementName.getChildren1());
                }
                if (reservationDailyElementName.getChildren2() != null) {
                    existingReservationDailyElementName.setChildren2(reservationDailyElementName.getChildren2());
                }
                if (reservationDailyElementName.getChildren3() != null) {
                    existingReservationDailyElementName.setChildren3(reservationDailyElementName.getChildren3());
                }
                if (reservationDailyElementName.getRateCode() != null) {
                    existingReservationDailyElementName.setRateCode(reservationDailyElementName.getRateCode());
                }
                if (reservationDailyElementName.getCurrencyCode() != null) {
                    existingReservationDailyElementName.setCurrencyCode(reservationDailyElementName.getCurrencyCode());
                }
                if (reservationDailyElementName.getExchangePostingType() != null) {
                    existingReservationDailyElementName.setExchangePostingType(reservationDailyElementName.getExchangePostingType());
                }
                if (reservationDailyElementName.getMembershipPoints() != null) {
                    existingReservationDailyElementName.setMembershipPoints(reservationDailyElementName.getMembershipPoints());
                }
                if (reservationDailyElementName.getChildren4() != null) {
                    existingReservationDailyElementName.setChildren4(reservationDailyElementName.getChildren4());
                }
                if (reservationDailyElementName.getChildren5() != null) {
                    existingReservationDailyElementName.setChildren5(reservationDailyElementName.getChildren5());
                }
                if (reservationDailyElementName.getCommissionCode() != null) {
                    existingReservationDailyElementName.setCommissionCode(reservationDailyElementName.getCommissionCode());
                }
                if (reservationDailyElementName.getAwardCode1() != null) {
                    existingReservationDailyElementName.setAwardCode1(reservationDailyElementName.getAwardCode1());
                }
                if (reservationDailyElementName.getAwardCode2() != null) {
                    existingReservationDailyElementName.setAwardCode2(reservationDailyElementName.getAwardCode2());
                }
                if (reservationDailyElementName.getAwardCode3() != null) {
                    existingReservationDailyElementName.setAwardCode3(reservationDailyElementName.getAwardCode3());
                }
                if (reservationDailyElementName.getAwardCode4() != null) {
                    existingReservationDailyElementName.setAwardCode4(reservationDailyElementName.getAwardCode4());
                }
                if (reservationDailyElementName.getAwardCode5() != null) {
                    existingReservationDailyElementName.setAwardCode5(reservationDailyElementName.getAwardCode5());
                }
                if (reservationDailyElementName.getAwardVoucher1() != null) {
                    existingReservationDailyElementName.setAwardVoucher1(reservationDailyElementName.getAwardVoucher1());
                }
                if (reservationDailyElementName.getAwardVoucher2() != null) {
                    existingReservationDailyElementName.setAwardVoucher2(reservationDailyElementName.getAwardVoucher2());
                }
                if (reservationDailyElementName.getAwardVoucher3() != null) {
                    existingReservationDailyElementName.setAwardVoucher3(reservationDailyElementName.getAwardVoucher3());
                }
                if (reservationDailyElementName.getAwardVoucher4() != null) {
                    existingReservationDailyElementName.setAwardVoucher4(reservationDailyElementName.getAwardVoucher4());
                }
                if (reservationDailyElementName.getAwardVoucher5() != null) {
                    existingReservationDailyElementName.setAwardVoucher5(reservationDailyElementName.getAwardVoucher5());
                }
                if (reservationDailyElementName.getDoNotMoveYn() != null) {
                    existingReservationDailyElementName.setDoNotMoveYn(reservationDailyElementName.getDoNotMoveYn());
                }
                if (reservationDailyElementName.getAwardCode() != null) {
                    existingReservationDailyElementName.setAwardCode(reservationDailyElementName.getAwardCode());
                }
                if (reservationDailyElementName.getPoints() != null) {
                    existingReservationDailyElementName.setPoints(reservationDailyElementName.getPoints());
                }
                if (reservationDailyElementName.getUpsellCharge() != null) {
                    existingReservationDailyElementName.setUpsellCharge(reservationDailyElementName.getUpsellCharge());
                }
                if (reservationDailyElementName.getPointsEligibilityCode() != null) {
                    existingReservationDailyElementName.setPointsEligibilityCode(reservationDailyElementName.getPointsEligibilityCode());
                }
                if (reservationDailyElementName.getCommissionPaid() != null) {
                    existingReservationDailyElementName.setCommissionPaid(reservationDailyElementName.getCommissionPaid());
                }
                if (reservationDailyElementName.getResvContactId() != null) {
                    existingReservationDailyElementName.setResvContactId(reservationDailyElementName.getResvContactId());
                }
                if (reservationDailyElementName.getBillingContactId() != null) {
                    existingReservationDailyElementName.setBillingContactId(reservationDailyElementName.getBillingContactId());
                }
                if (reservationDailyElementName.getShareAmountOriginal() != null) {
                    existingReservationDailyElementName.setShareAmountOriginal(reservationDailyElementName.getShareAmountOriginal());
                }
                if (reservationDailyElementName.getReferralYn() != null) {
                    existingReservationDailyElementName.setReferralYn(reservationDailyElementName.getReferralYn());
                }
                if (reservationDailyElementName.getBxgyDiscountYn() != null) {
                    existingReservationDailyElementName.setBxgyDiscountYn(reservationDailyElementName.getBxgyDiscountYn());
                }
                if (reservationDailyElementName.getCommissionableYn() != null) {
                    existingReservationDailyElementName.setCommissionableYn(reservationDailyElementName.getCommissionableYn());
                }
                if (reservationDailyElementName.getBasedOnRule() != null) {
                    existingReservationDailyElementName.setBasedOnRule(reservationDailyElementName.getBasedOnRule());
                }

                return existingReservationDailyElementName;
            })
            .map(reservationDailyElementNameRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ReservationDailyElementName> findAll(Pageable pageable) {
        log.debug("Request to get all ReservationDailyElementNames");
        return reservationDailyElementNameRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ReservationDailyElementName> findOne(Long id) {
        log.debug("Request to get ReservationDailyElementName : {}", id);
        return reservationDailyElementNameRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ReservationDailyElementName : {}", id);
        reservationDailyElementNameRepository.deleteById(id);
    }
}
