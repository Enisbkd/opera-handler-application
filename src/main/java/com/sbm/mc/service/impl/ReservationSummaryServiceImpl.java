package com.sbm.mc.service.impl;

import com.sbm.mc.domain.ReservationSummary;
import com.sbm.mc.repository.ReservationSummaryRepository;
import com.sbm.mc.service.ReservationSummaryService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.ReservationSummary}.
 */
@Service
@Transactional
public class ReservationSummaryServiceImpl implements ReservationSummaryService {

    private final Logger log = LoggerFactory.getLogger(ReservationSummaryServiceImpl.class);

    private final ReservationSummaryRepository reservationSummaryRepository;

    public ReservationSummaryServiceImpl(ReservationSummaryRepository reservationSummaryRepository) {
        this.reservationSummaryRepository = reservationSummaryRepository;
    }

    @Override
    public ReservationSummary save(ReservationSummary reservationSummary) {
        log.debug("Request to save ReservationSummary : {}", reservationSummary);
        return reservationSummaryRepository.save(reservationSummary);
    }

    @Override
    public ReservationSummary update(ReservationSummary reservationSummary) {
        log.debug("Request to update ReservationSummary : {}", reservationSummary);
        return reservationSummaryRepository.save(reservationSummary);
    }

    @Override
    public Optional<ReservationSummary> partialUpdate(ReservationSummary reservationSummary) {
        log.debug("Request to partially update ReservationSummary : {}", reservationSummary);

        return reservationSummaryRepository
            .findById(reservationSummary.getId())
            .map(existingReservationSummary -> {
                if (reservationSummary.getResort() != null) {
                    existingReservationSummary.setResort(reservationSummary.getResort());
                }
                if (reservationSummary.getEventType() != null) {
                    existingReservationSummary.setEventType(reservationSummary.getEventType());
                }
                if (reservationSummary.getEventId() != null) {
                    existingReservationSummary.setEventId(reservationSummary.getEventId());
                }
                if (reservationSummary.getConsideredDate() != null) {
                    existingReservationSummary.setConsideredDate(reservationSummary.getConsideredDate());
                }
                if (reservationSummary.getRoomCategory() != null) {
                    existingReservationSummary.setRoomCategory(reservationSummary.getRoomCategory());
                }
                if (reservationSummary.getRoomClass() != null) {
                    existingReservationSummary.setRoomClass(reservationSummary.getRoomClass());
                }
                if (reservationSummary.getMarketCode() != null) {
                    existingReservationSummary.setMarketCode(reservationSummary.getMarketCode());
                }
                if (reservationSummary.getSourceCode() != null) {
                    existingReservationSummary.setSourceCode(reservationSummary.getSourceCode());
                }
                if (reservationSummary.getRateCode() != null) {
                    existingReservationSummary.setRateCode(reservationSummary.getRateCode());
                }
                if (reservationSummary.getRegionCode() != null) {
                    existingReservationSummary.setRegionCode(reservationSummary.getRegionCode());
                }
                if (reservationSummary.getGroupId() != null) {
                    existingReservationSummary.setGroupId(reservationSummary.getGroupId());
                }
                if (reservationSummary.getResvType() != null) {
                    existingReservationSummary.setResvType(reservationSummary.getResvType());
                }
                if (reservationSummary.getResvInvType() != null) {
                    existingReservationSummary.setResvInvType(reservationSummary.getResvInvType());
                }
                if (reservationSummary.getPsuedoRoomYn() != null) {
                    existingReservationSummary.setPsuedoRoomYn(reservationSummary.getPsuedoRoomYn());
                }
                if (reservationSummary.getArrRooms() != null) {
                    existingReservationSummary.setArrRooms(reservationSummary.getArrRooms());
                }
                if (reservationSummary.getAdults() != null) {
                    existingReservationSummary.setAdults(reservationSummary.getAdults());
                }
                if (reservationSummary.getChildren() != null) {
                    existingReservationSummary.setChildren(reservationSummary.getChildren());
                }
                if (reservationSummary.getDepRooms() != null) {
                    existingReservationSummary.setDepRooms(reservationSummary.getDepRooms());
                }
                if (reservationSummary.getNoRooms() != null) {
                    existingReservationSummary.setNoRooms(reservationSummary.getNoRooms());
                }
                if (reservationSummary.getGrossRate() != null) {
                    existingReservationSummary.setGrossRate(reservationSummary.getGrossRate());
                }
                if (reservationSummary.getNetRoomRevenue() != null) {
                    existingReservationSummary.setNetRoomRevenue(reservationSummary.getNetRoomRevenue());
                }
                if (reservationSummary.getExtraRevenue() != null) {
                    existingReservationSummary.setExtraRevenue(reservationSummary.getExtraRevenue());
                }
                if (reservationSummary.getOoRooms() != null) {
                    existingReservationSummary.setOoRooms(reservationSummary.getOoRooms());
                }
                if (reservationSummary.getOsRooms() != null) {
                    existingReservationSummary.setOsRooms(reservationSummary.getOsRooms());
                }
                if (reservationSummary.getRemainingBlockRooms() != null) {
                    existingReservationSummary.setRemainingBlockRooms(reservationSummary.getRemainingBlockRooms());
                }
                if (reservationSummary.getPickedupBlockRooms() != null) {
                    existingReservationSummary.setPickedupBlockRooms(reservationSummary.getPickedupBlockRooms());
                }
                if (reservationSummary.getSingleOccupancy() != null) {
                    existingReservationSummary.setSingleOccupancy(reservationSummary.getSingleOccupancy());
                }
                if (reservationSummary.getMultipleOccupancy() != null) {
                    existingReservationSummary.setMultipleOccupancy(reservationSummary.getMultipleOccupancy());
                }
                if (reservationSummary.getBlockStatus() != null) {
                    existingReservationSummary.setBlockStatus(reservationSummary.getBlockStatus());
                }
                if (reservationSummary.getArrPersons() != null) {
                    existingReservationSummary.setArrPersons(reservationSummary.getArrPersons());
                }
                if (reservationSummary.getDepPersons() != null) {
                    existingReservationSummary.setDepPersons(reservationSummary.getDepPersons());
                }
                if (reservationSummary.getWlRooms() != null) {
                    existingReservationSummary.setWlRooms(reservationSummary.getWlRooms());
                }
                if (reservationSummary.getWlPersons() != null) {
                    existingReservationSummary.setWlPersons(reservationSummary.getWlPersons());
                }
                if (reservationSummary.getDayUseRooms() != null) {
                    existingReservationSummary.setDayUseRooms(reservationSummary.getDayUseRooms());
                }
                if (reservationSummary.getDayUsePersons() != null) {
                    existingReservationSummary.setDayUsePersons(reservationSummary.getDayUsePersons());
                }
                if (reservationSummary.getBookingStatus() != null) {
                    existingReservationSummary.setBookingStatus(reservationSummary.getBookingStatus());
                }
                if (reservationSummary.getResvStatus() != null) {
                    existingReservationSummary.setResvStatus(reservationSummary.getResvStatus());
                }
                if (reservationSummary.getDayUseYn() != null) {
                    existingReservationSummary.setDayUseYn(reservationSummary.getDayUseYn());
                }
                if (reservationSummary.getChannel() != null) {
                    existingReservationSummary.setChannel(reservationSummary.getChannel());
                }
                if (reservationSummary.getCountry() != null) {
                    existingReservationSummary.setCountry(reservationSummary.getCountry());
                }
                if (reservationSummary.getNationality() != null) {
                    existingReservationSummary.setNationality(reservationSummary.getNationality());
                }
                if (reservationSummary.getCribs() != null) {
                    existingReservationSummary.setCribs(reservationSummary.getCribs());
                }
                if (reservationSummary.getExtraBeds() != null) {
                    existingReservationSummary.setExtraBeds(reservationSummary.getExtraBeds());
                }
                if (reservationSummary.getAdultsTaxFree() != null) {
                    existingReservationSummary.setAdultsTaxFree(reservationSummary.getAdultsTaxFree());
                }
                if (reservationSummary.getChildrenTaxFree() != null) {
                    existingReservationSummary.setChildrenTaxFree(reservationSummary.getChildrenTaxFree());
                }
                if (reservationSummary.getRateCategory() != null) {
                    existingReservationSummary.setRateCategory(reservationSummary.getRateCategory());
                }
                if (reservationSummary.getRateClass() != null) {
                    existingReservationSummary.setRateClass(reservationSummary.getRateClass());
                }
                if (reservationSummary.getRoomRevenue() != null) {
                    existingReservationSummary.setRoomRevenue(reservationSummary.getRoomRevenue());
                }
                if (reservationSummary.getFoodRevenue() != null) {
                    existingReservationSummary.setFoodRevenue(reservationSummary.getFoodRevenue());
                }
                if (reservationSummary.getOtherRevenue() != null) {
                    existingReservationSummary.setOtherRevenue(reservationSummary.getOtherRevenue());
                }
                if (reservationSummary.getTotalRevenue() != null) {
                    existingReservationSummary.setTotalRevenue(reservationSummary.getTotalRevenue());
                }
                if (reservationSummary.getNonRevenue() != null) {
                    existingReservationSummary.setNonRevenue(reservationSummary.getNonRevenue());
                }
                if (reservationSummary.getAllotmentHeaderId() != null) {
                    existingReservationSummary.setAllotmentHeaderId(reservationSummary.getAllotmentHeaderId());
                }
                if (reservationSummary.getRoomRevenueTax() != null) {
                    existingReservationSummary.setRoomRevenueTax(reservationSummary.getRoomRevenueTax());
                }
                if (reservationSummary.getFoodRevenueTax() != null) {
                    existingReservationSummary.setFoodRevenueTax(reservationSummary.getFoodRevenueTax());
                }
                if (reservationSummary.getOtherRevenueTax() != null) {
                    existingReservationSummary.setOtherRevenueTax(reservationSummary.getOtherRevenueTax());
                }
                if (reservationSummary.getTotalRevenueTax() != null) {
                    existingReservationSummary.setTotalRevenueTax(reservationSummary.getTotalRevenueTax());
                }
                if (reservationSummary.getNonRevenueTax() != null) {
                    existingReservationSummary.setNonRevenueTax(reservationSummary.getNonRevenueTax());
                }
                if (reservationSummary.getCity() != null) {
                    existingReservationSummary.setCity(reservationSummary.getCity());
                }
                if (reservationSummary.getZipCode() != null) {
                    existingReservationSummary.setZipCode(reservationSummary.getZipCode());
                }
                if (reservationSummary.getDistrict() != null) {
                    existingReservationSummary.setDistrict(reservationSummary.getDistrict());
                }
                if (reservationSummary.getState() != null) {
                    existingReservationSummary.setState(reservationSummary.getState());
                }
                if (reservationSummary.getChildren1() != null) {
                    existingReservationSummary.setChildren1(reservationSummary.getChildren1());
                }
                if (reservationSummary.getChildren2() != null) {
                    existingReservationSummary.setChildren2(reservationSummary.getChildren2());
                }
                if (reservationSummary.getChildren3() != null) {
                    existingReservationSummary.setChildren3(reservationSummary.getChildren3());
                }
                if (reservationSummary.getChildren4() != null) {
                    existingReservationSummary.setChildren4(reservationSummary.getChildren4());
                }
                if (reservationSummary.getChildren5() != null) {
                    existingReservationSummary.setChildren5(reservationSummary.getChildren5());
                }
                if (reservationSummary.getOwnerFfFlag() != null) {
                    existingReservationSummary.setOwnerFfFlag(reservationSummary.getOwnerFfFlag());
                }
                if (reservationSummary.getOwnerRentalFlag() != null) {
                    existingReservationSummary.setOwnerRentalFlag(reservationSummary.getOwnerRentalFlag());
                }
                if (reservationSummary.getFcGrossRate() != null) {
                    existingReservationSummary.setFcGrossRate(reservationSummary.getFcGrossRate());
                }
                if (reservationSummary.getFcNetRoomRevenue() != null) {
                    existingReservationSummary.setFcNetRoomRevenue(reservationSummary.getFcNetRoomRevenue());
                }
                if (reservationSummary.getFcExtraRevenue() != null) {
                    existingReservationSummary.setFcExtraRevenue(reservationSummary.getFcExtraRevenue());
                }
                if (reservationSummary.getFcRoomRevenue() != null) {
                    existingReservationSummary.setFcRoomRevenue(reservationSummary.getFcRoomRevenue());
                }
                if (reservationSummary.getFcFoodRevenue() != null) {
                    existingReservationSummary.setFcFoodRevenue(reservationSummary.getFcFoodRevenue());
                }
                if (reservationSummary.getFcOtherRevenue() != null) {
                    existingReservationSummary.setFcOtherRevenue(reservationSummary.getFcOtherRevenue());
                }
                if (reservationSummary.getFcTotalRevenue() != null) {
                    existingReservationSummary.setFcTotalRevenue(reservationSummary.getFcTotalRevenue());
                }
                if (reservationSummary.getFcNonRevenue() != null) {
                    existingReservationSummary.setFcNonRevenue(reservationSummary.getFcNonRevenue());
                }
                if (reservationSummary.getFcRoomRevenueTax() != null) {
                    existingReservationSummary.setFcRoomRevenueTax(reservationSummary.getFcRoomRevenueTax());
                }
                if (reservationSummary.getFcFoodRevenueTax() != null) {
                    existingReservationSummary.setFcFoodRevenueTax(reservationSummary.getFcFoodRevenueTax());
                }
                if (reservationSummary.getFcOtherRevenueTax() != null) {
                    existingReservationSummary.setFcOtherRevenueTax(reservationSummary.getFcOtherRevenueTax());
                }
                if (reservationSummary.getFcTotalRevenueTax() != null) {
                    existingReservationSummary.setFcTotalRevenueTax(reservationSummary.getFcTotalRevenueTax());
                }
                if (reservationSummary.getFcNonRevenueTax() != null) {
                    existingReservationSummary.setFcNonRevenueTax(reservationSummary.getFcNonRevenueTax());
                }
                if (reservationSummary.getCurrencyCode() != null) {
                    existingReservationSummary.setCurrencyCode(reservationSummary.getCurrencyCode());
                }
                if (reservationSummary.getExchangeDate() != null) {
                    existingReservationSummary.setExchangeDate(reservationSummary.getExchangeDate());
                }
                if (reservationSummary.getUpdateBusinessDate() != null) {
                    existingReservationSummary.setUpdateBusinessDate(reservationSummary.getUpdateBusinessDate());
                }
                if (reservationSummary.getUpdateDate() != null) {
                    existingReservationSummary.setUpdateDate(reservationSummary.getUpdateDate());
                }
                if (reservationSummary.getCentralCurrencyCode() != null) {
                    existingReservationSummary.setCentralCurrencyCode(reservationSummary.getCentralCurrencyCode());
                }
                if (reservationSummary.getCentralExchangeRate() != null) {
                    existingReservationSummary.setCentralExchangeRate(reservationSummary.getCentralExchangeRate());
                }
                if (reservationSummary.getTruncBeginDate() != null) {
                    existingReservationSummary.setTruncBeginDate(reservationSummary.getTruncBeginDate());
                }
                if (reservationSummary.getTruncEndDate() != null) {
                    existingReservationSummary.setTruncEndDate(reservationSummary.getTruncEndDate());
                }
                if (reservationSummary.getBusinessDateCreated() != null) {
                    existingReservationSummary.setBusinessDateCreated(reservationSummary.getBusinessDateCreated());
                }
                if (reservationSummary.getResInsertSource() != null) {
                    existingReservationSummary.setResInsertSource(reservationSummary.getResInsertSource());
                }
                if (reservationSummary.getParentCompanyId() != null) {
                    existingReservationSummary.setParentCompanyId(reservationSummary.getParentCompanyId());
                }
                if (reservationSummary.getAgentId() != null) {
                    existingReservationSummary.setAgentId(reservationSummary.getAgentId());
                }
                if (reservationSummary.getGender() != null) {
                    existingReservationSummary.setGender(reservationSummary.getGender());
                }
                if (reservationSummary.getVipStatus() != null) {
                    existingReservationSummary.setVipStatus(reservationSummary.getVipStatus());
                }
                if (reservationSummary.getQuantity() != null) {
                    existingReservationSummary.setQuantity(reservationSummary.getQuantity());
                }
                if (reservationSummary.getTurndownStatus() != null) {
                    existingReservationSummary.setTurndownStatus(reservationSummary.getTurndownStatus());
                }
                if (reservationSummary.getBookedRoomCategory() != null) {
                    existingReservationSummary.setBookedRoomCategory(reservationSummary.getBookedRoomCategory());
                }
                if (reservationSummary.getSourceProfId() != null) {
                    existingReservationSummary.setSourceProfId(reservationSummary.getSourceProfId());
                }

                return existingReservationSummary;
            })
            .map(reservationSummaryRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ReservationSummary> findAll(Pageable pageable) {
        log.debug("Request to get all ReservationSummaries");
        return reservationSummaryRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ReservationSummary> findOne(Integer id) {
        log.debug("Request to get ReservationSummary : {}", id);
        return reservationSummaryRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete ReservationSummary : {}", id);
        reservationSummaryRepository.deleteById(id);
    }
}
