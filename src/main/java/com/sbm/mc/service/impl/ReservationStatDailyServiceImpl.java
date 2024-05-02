package com.sbm.mc.service.impl;

import com.sbm.mc.domain.ReservationStatDaily;
import com.sbm.mc.repository.ReservationStatDailyRepository;
import com.sbm.mc.service.ReservationStatDailyService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.ReservationStatDaily}.
 */
@Service
@Transactional
public class ReservationStatDailyServiceImpl implements ReservationStatDailyService {

    private final Logger log = LoggerFactory.getLogger(ReservationStatDailyServiceImpl.class);

    private final ReservationStatDailyRepository reservationStatDailyRepository;

    public ReservationStatDailyServiceImpl(ReservationStatDailyRepository reservationStatDailyRepository) {
        this.reservationStatDailyRepository = reservationStatDailyRepository;
    }

    @Override
    public ReservationStatDaily save(ReservationStatDaily reservationStatDaily) {
        log.debug("Request to save ReservationStatDaily : {}", reservationStatDaily);
        return reservationStatDailyRepository.save(reservationStatDaily);
    }

    @Override
    public ReservationStatDaily update(ReservationStatDaily reservationStatDaily) {
        log.debug("Request to update ReservationStatDaily : {}", reservationStatDaily);
        return reservationStatDailyRepository.save(reservationStatDaily);
    }

    @Override
    public Optional<ReservationStatDaily> partialUpdate(ReservationStatDaily reservationStatDaily) {
        log.debug("Request to partially update ReservationStatDaily : {}", reservationStatDaily);

        return reservationStatDailyRepository
            .findById(reservationStatDaily.getId())
            .map(existingReservationStatDaily -> {
                if (reservationStatDaily.getResort() != null) {
                    existingReservationStatDaily.setResort(reservationStatDaily.getResort());
                }
                if (reservationStatDaily.getBusinessDate() != null) {
                    existingReservationStatDaily.setBusinessDate(reservationStatDaily.getBusinessDate());
                }
                if (reservationStatDaily.getNameId() != null) {
                    existingReservationStatDaily.setNameId(reservationStatDaily.getNameId());
                }
                if (reservationStatDaily.getRateCode() != null) {
                    existingReservationStatDaily.setRateCode(reservationStatDaily.getRateCode());
                }
                if (reservationStatDaily.getSourceCode() != null) {
                    existingReservationStatDaily.setSourceCode(reservationStatDaily.getSourceCode());
                }
                if (reservationStatDaily.getMarketCode() != null) {
                    existingReservationStatDaily.setMarketCode(reservationStatDaily.getMarketCode());
                }
                if (reservationStatDaily.getRoomCategory() != null) {
                    existingReservationStatDaily.setRoomCategory(reservationStatDaily.getRoomCategory());
                }
                if (reservationStatDaily.getCompanyId() != null) {
                    existingReservationStatDaily.setCompanyId(reservationStatDaily.getCompanyId());
                }
                if (reservationStatDaily.getAgentId() != null) {
                    existingReservationStatDaily.setAgentId(reservationStatDaily.getAgentId());
                }
                if (reservationStatDaily.getGroupId() != null) {
                    existingReservationStatDaily.setGroupId(reservationStatDaily.getGroupId());
                }
                if (reservationStatDaily.getSourceProfId() != null) {
                    existingReservationStatDaily.setSourceProfId(reservationStatDaily.getSourceProfId());
                }
                if (reservationStatDaily.getResvStatus() != null) {
                    existingReservationStatDaily.setResvStatus(reservationStatDaily.getResvStatus());
                }
                if (reservationStatDaily.getTruncBeginDate() != null) {
                    existingReservationStatDaily.setTruncBeginDate(reservationStatDaily.getTruncBeginDate());
                }
                if (reservationStatDaily.getTruncEndDate() != null) {
                    existingReservationStatDaily.setTruncEndDate(reservationStatDaily.getTruncEndDate());
                }
                if (reservationStatDaily.getResvNameId() != null) {
                    existingReservationStatDaily.setResvNameId(reservationStatDaily.getResvNameId());
                }
                if (reservationStatDaily.getQuantity() != null) {
                    existingReservationStatDaily.setQuantity(reservationStatDaily.getQuantity());
                }
                if (reservationStatDaily.getPhysicalQuantity() != null) {
                    existingReservationStatDaily.setPhysicalQuantity(reservationStatDaily.getPhysicalQuantity());
                }
                if (reservationStatDaily.getDueOutYn() != null) {
                    existingReservationStatDaily.setDueOutYn(reservationStatDaily.getDueOutYn());
                }
                if (reservationStatDaily.getRoomResvStatus() != null) {
                    existingReservationStatDaily.setRoomResvStatus(reservationStatDaily.getRoomResvStatus());
                }
                if (reservationStatDaily.getAdults() != null) {
                    existingReservationStatDaily.setAdults(reservationStatDaily.getAdults());
                }
                if (reservationStatDaily.getChildren() != null) {
                    existingReservationStatDaily.setChildren(reservationStatDaily.getChildren());
                }
                if (reservationStatDaily.getRoomAdults() != null) {
                    existingReservationStatDaily.setRoomAdults(reservationStatDaily.getRoomAdults());
                }
                if (reservationStatDaily.getRoomChildren() != null) {
                    existingReservationStatDaily.setRoomChildren(reservationStatDaily.getRoomChildren());
                }
                if (reservationStatDaily.getPrimaryYn() != null) {
                    existingReservationStatDaily.setPrimaryYn(reservationStatDaily.getPrimaryYn());
                }
                if (reservationStatDaily.getAllotmentHeaderId() != null) {
                    existingReservationStatDaily.setAllotmentHeaderId(reservationStatDaily.getAllotmentHeaderId());
                }
                if (reservationStatDaily.getRoomRevenue() != null) {
                    existingReservationStatDaily.setRoomRevenue(reservationStatDaily.getRoomRevenue());
                }
                if (reservationStatDaily.getFoodRevenue() != null) {
                    existingReservationStatDaily.setFoodRevenue(reservationStatDaily.getFoodRevenue());
                }
                if (reservationStatDaily.getPackageRoomRevenue() != null) {
                    existingReservationStatDaily.setPackageRoomRevenue(reservationStatDaily.getPackageRoomRevenue());
                }
                if (reservationStatDaily.getPackageFoodRevenue() != null) {
                    existingReservationStatDaily.setPackageFoodRevenue(reservationStatDaily.getPackageFoodRevenue());
                }
                if (reservationStatDaily.getTotalRoomTax() != null) {
                    existingReservationStatDaily.setTotalRoomTax(reservationStatDaily.getTotalRoomTax());
                }
                if (reservationStatDaily.getTotalFoodTax() != null) {
                    existingReservationStatDaily.setTotalFoodTax(reservationStatDaily.getTotalFoodTax());
                }
                if (reservationStatDaily.getTotalPackageRevenue() != null) {
                    existingReservationStatDaily.setTotalPackageRevenue(reservationStatDaily.getTotalPackageRevenue());
                }
                if (reservationStatDaily.getTotalRevenue() != null) {
                    existingReservationStatDaily.setTotalRevenue(reservationStatDaily.getTotalRevenue());
                }
                if (reservationStatDaily.getTotalTax() != null) {
                    existingReservationStatDaily.setTotalTax(reservationStatDaily.getTotalTax());
                }
                if (reservationStatDaily.getInsertDate() != null) {
                    existingReservationStatDaily.setInsertDate(reservationStatDaily.getInsertDate());
                }
                if (reservationStatDaily.getOriginalEndDate() != null) {
                    existingReservationStatDaily.setOriginalEndDate(reservationStatDaily.getOriginalEndDate());
                }
                if (reservationStatDaily.getWalkinYn() != null) {
                    existingReservationStatDaily.setWalkinYn(reservationStatDaily.getWalkinYn());
                }
                if (reservationStatDaily.getReservationDate() != null) {
                    existingReservationStatDaily.setReservationDate(reservationStatDaily.getReservationDate());
                }
                if (reservationStatDaily.getRoomClass() != null) {
                    existingReservationStatDaily.setRoomClass(reservationStatDaily.getRoomClass());
                }
                if (reservationStatDaily.getVipStatus() != null) {
                    existingReservationStatDaily.setVipStatus(reservationStatDaily.getVipStatus());
                }
                if (reservationStatDaily.getCancellationDate() != null) {
                    existingReservationStatDaily.setCancellationDate(reservationStatDaily.getCancellationDate());
                }
                if (reservationStatDaily.getBirthDate() != null) {
                    existingReservationStatDaily.setBirthDate(reservationStatDaily.getBirthDate());
                }
                if (reservationStatDaily.getRoom() != null) {
                    existingReservationStatDaily.setRoom(reservationStatDaily.getRoom());
                }
                if (reservationStatDaily.getMembershipId() != null) {
                    existingReservationStatDaily.setMembershipId(reservationStatDaily.getMembershipId());
                }
                if (reservationStatDaily.getContactId() != null) {
                    existingReservationStatDaily.setContactId(reservationStatDaily.getContactId());
                }
                if (reservationStatDaily.getRateCategory() != null) {
                    existingReservationStatDaily.setRateCategory(reservationStatDaily.getRateCategory());
                }
                if (reservationStatDaily.getMarketMainGroup() != null) {
                    existingReservationStatDaily.setMarketMainGroup(reservationStatDaily.getMarketMainGroup());
                }
                if (reservationStatDaily.getSourceMainGroup() != null) {
                    existingReservationStatDaily.setSourceMainGroup(reservationStatDaily.getSourceMainGroup());
                }
                if (reservationStatDaily.getChannel() != null) {
                    existingReservationStatDaily.setChannel(reservationStatDaily.getChannel());
                }
                if (reservationStatDaily.getCountry() != null) {
                    existingReservationStatDaily.setCountry(reservationStatDaily.getCountry());
                }
                if (reservationStatDaily.getRegionCode() != null) {
                    existingReservationStatDaily.setRegionCode(reservationStatDaily.getRegionCode());
                }
                if (reservationStatDaily.getNationality() != null) {
                    existingReservationStatDaily.setNationality(reservationStatDaily.getNationality());
                }
                if (reservationStatDaily.getPsuedoRoomYn() != null) {
                    existingReservationStatDaily.setPsuedoRoomYn(reservationStatDaily.getPsuedoRoomYn());
                }
                if (reservationStatDaily.getAdultsTaxFree() != null) {
                    existingReservationStatDaily.setAdultsTaxFree(reservationStatDaily.getAdultsTaxFree());
                }
                if (reservationStatDaily.getChildrenTaxFree() != null) {
                    existingReservationStatDaily.setChildrenTaxFree(reservationStatDaily.getChildrenTaxFree());
                }
                if (reservationStatDaily.getStayRooms() != null) {
                    existingReservationStatDaily.setStayRooms(reservationStatDaily.getStayRooms());
                }
                if (reservationStatDaily.getStayPersons() != null) {
                    existingReservationStatDaily.setStayPersons(reservationStatDaily.getStayPersons());
                }
                if (reservationStatDaily.getStayAdults() != null) {
                    existingReservationStatDaily.setStayAdults(reservationStatDaily.getStayAdults());
                }
                if (reservationStatDaily.getStayChildren() != null) {
                    existingReservationStatDaily.setStayChildren(reservationStatDaily.getStayChildren());
                }
                if (reservationStatDaily.getArrRooms() != null) {
                    existingReservationStatDaily.setArrRooms(reservationStatDaily.getArrRooms());
                }
                if (reservationStatDaily.getArrPersons() != null) {
                    existingReservationStatDaily.setArrPersons(reservationStatDaily.getArrPersons());
                }
                if (reservationStatDaily.getDepRooms() != null) {
                    existingReservationStatDaily.setDepRooms(reservationStatDaily.getDepRooms());
                }
                if (reservationStatDaily.getDepPersons() != null) {
                    existingReservationStatDaily.setDepPersons(reservationStatDaily.getDepPersons());
                }
                if (reservationStatDaily.getDayUseRooms() != null) {
                    existingReservationStatDaily.setDayUseRooms(reservationStatDaily.getDayUseRooms());
                }
                if (reservationStatDaily.getDayUsePersons() != null) {
                    existingReservationStatDaily.setDayUsePersons(reservationStatDaily.getDayUsePersons());
                }
                if (reservationStatDaily.getCancelledRooms() != null) {
                    existingReservationStatDaily.setCancelledRooms(reservationStatDaily.getCancelledRooms());
                }
                if (reservationStatDaily.getCancelledPersons() != null) {
                    existingReservationStatDaily.setCancelledPersons(reservationStatDaily.getCancelledPersons());
                }
                if (reservationStatDaily.getNoShowRooms() != null) {
                    existingReservationStatDaily.setNoShowRooms(reservationStatDaily.getNoShowRooms());
                }
                if (reservationStatDaily.getNoShowPersons() != null) {
                    existingReservationStatDaily.setNoShowPersons(reservationStatDaily.getNoShowPersons());
                }
                if (reservationStatDaily.getSingleOccupancy() != null) {
                    existingReservationStatDaily.setSingleOccupancy(reservationStatDaily.getSingleOccupancy());
                }
                if (reservationStatDaily.getMultipleOccupancy() != null) {
                    existingReservationStatDaily.setMultipleOccupancy(reservationStatDaily.getMultipleOccupancy());
                }
                if (reservationStatDaily.getCribs() != null) {
                    existingReservationStatDaily.setCribs(reservationStatDaily.getCribs());
                }
                if (reservationStatDaily.getExtraBeds() != null) {
                    existingReservationStatDaily.setExtraBeds(reservationStatDaily.getExtraBeds());
                }
                if (reservationStatDaily.getOtherRevenue() != null) {
                    existingReservationStatDaily.setOtherRevenue(reservationStatDaily.getOtherRevenue());
                }
                if (reservationStatDaily.getPackageOtherRevenue() != null) {
                    existingReservationStatDaily.setPackageOtherRevenue(reservationStatDaily.getPackageOtherRevenue());
                }
                if (reservationStatDaily.getTotalOtherTax() != null) {
                    existingReservationStatDaily.setTotalOtherTax(reservationStatDaily.getTotalOtherTax());
                }
                if (reservationStatDaily.getCountryMainGroup() != null) {
                    existingReservationStatDaily.setCountryMainGroup(reservationStatDaily.getCountryMainGroup());
                }
                if (reservationStatDaily.getState() != null) {
                    existingReservationStatDaily.setState(reservationStatDaily.getState());
                }
                if (reservationStatDaily.getFiscalRegionCode() != null) {
                    existingReservationStatDaily.setFiscalRegionCode(reservationStatDaily.getFiscalRegionCode());
                }
                if (reservationStatDaily.getNonRevenue() != null) {
                    existingReservationStatDaily.setNonRevenue(reservationStatDaily.getNonRevenue());
                }
                if (reservationStatDaily.getPackageNonRevenue() != null) {
                    existingReservationStatDaily.setPackageNonRevenue(reservationStatDaily.getPackageNonRevenue());
                }
                if (reservationStatDaily.getTotalNonRevenueTax() != null) {
                    existingReservationStatDaily.setTotalNonRevenueTax(reservationStatDaily.getTotalNonRevenueTax());
                }
                if (reservationStatDaily.getPrRoomRevenue() != null) {
                    existingReservationStatDaily.setPrRoomRevenue(reservationStatDaily.getPrRoomRevenue());
                }
                if (reservationStatDaily.getPrFoodRevenue() != null) {
                    existingReservationStatDaily.setPrFoodRevenue(reservationStatDaily.getPrFoodRevenue());
                }
                if (reservationStatDaily.getPrPackageRoomRevenue() != null) {
                    existingReservationStatDaily.setPrPackageRoomRevenue(reservationStatDaily.getPrPackageRoomRevenue());
                }
                if (reservationStatDaily.getPrPackageFoodRevenue() != null) {
                    existingReservationStatDaily.setPrPackageFoodRevenue(reservationStatDaily.getPrPackageFoodRevenue());
                }
                if (reservationStatDaily.getPrTotalRoomTax() != null) {
                    existingReservationStatDaily.setPrTotalRoomTax(reservationStatDaily.getPrTotalRoomTax());
                }
                if (reservationStatDaily.getPrTotalFoodTax() != null) {
                    existingReservationStatDaily.setPrTotalFoodTax(reservationStatDaily.getPrTotalFoodTax());
                }
                if (reservationStatDaily.getPrTotalPackageRevenue() != null) {
                    existingReservationStatDaily.setPrTotalPackageRevenue(reservationStatDaily.getPrTotalPackageRevenue());
                }
                if (reservationStatDaily.getPrTotalRevenue() != null) {
                    existingReservationStatDaily.setPrTotalRevenue(reservationStatDaily.getPrTotalRevenue());
                }
                if (reservationStatDaily.getPrTotalTax() != null) {
                    existingReservationStatDaily.setPrTotalTax(reservationStatDaily.getPrTotalTax());
                }
                if (reservationStatDaily.getPrOtherRevenue() != null) {
                    existingReservationStatDaily.setPrOtherRevenue(reservationStatDaily.getPrOtherRevenue());
                }
                if (reservationStatDaily.getPrPackageOtherRevenue() != null) {
                    existingReservationStatDaily.setPrPackageOtherRevenue(reservationStatDaily.getPrPackageOtherRevenue());
                }
                if (reservationStatDaily.getPrTotalOtherTax() != null) {
                    existingReservationStatDaily.setPrTotalOtherTax(reservationStatDaily.getPrTotalOtherTax());
                }
                if (reservationStatDaily.getPrNonRevenue() != null) {
                    existingReservationStatDaily.setPrNonRevenue(reservationStatDaily.getPrNonRevenue());
                }
                if (reservationStatDaily.getPrPackageNonRevenue() != null) {
                    existingReservationStatDaily.setPrPackageNonRevenue(reservationStatDaily.getPrPackageNonRevenue());
                }
                if (reservationStatDaily.getPrTotalNonRevenueTax() != null) {
                    existingReservationStatDaily.setPrTotalNonRevenueTax(reservationStatDaily.getPrTotalNonRevenueTax());
                }
                if (reservationStatDaily.getNights() != null) {
                    existingReservationStatDaily.setNights(reservationStatDaily.getNights());
                }
                if (reservationStatDaily.getNoOfStays() != null) {
                    existingReservationStatDaily.setNoOfStays(reservationStatDaily.getNoOfStays());
                }
                if (reservationStatDaily.getReservationNights() != null) {
                    existingReservationStatDaily.setReservationNights(reservationStatDaily.getReservationNights());
                }
                if (reservationStatDaily.getReservationArrivals() != null) {
                    existingReservationStatDaily.setReservationArrivals(reservationStatDaily.getReservationArrivals());
                }
                if (reservationStatDaily.getReservationNoOfStays() != null) {
                    existingReservationStatDaily.setReservationNoOfStays(reservationStatDaily.getReservationNoOfStays());
                }
                if (reservationStatDaily.getDayUseReservations() != null) {
                    existingReservationStatDaily.setDayUseReservations(reservationStatDaily.getDayUseReservations());
                }
                if (reservationStatDaily.getCancelledReservations() != null) {
                    existingReservationStatDaily.setCancelledReservations(reservationStatDaily.getCancelledReservations());
                }
                if (reservationStatDaily.getNoShowReservations() != null) {
                    existingReservationStatDaily.setNoShowReservations(reservationStatDaily.getNoShowReservations());
                }
                if (reservationStatDaily.getCity() != null) {
                    existingReservationStatDaily.setCity(reservationStatDaily.getCity());
                }
                if (reservationStatDaily.getZipCode() != null) {
                    existingReservationStatDaily.setZipCode(reservationStatDaily.getZipCode());
                }
                if (reservationStatDaily.getDistrict() != null) {
                    existingReservationStatDaily.setDistrict(reservationStatDaily.getDistrict());
                }
                if (reservationStatDaily.getCashRoomNts() != null) {
                    existingReservationStatDaily.setCashRoomNts(reservationStatDaily.getCashRoomNts());
                }
                if (reservationStatDaily.getCompRoomNts() != null) {
                    existingReservationStatDaily.setCompRoomNts(reservationStatDaily.getCompRoomNts());
                }
                if (reservationStatDaily.getCashRoomRevenue() != null) {
                    existingReservationStatDaily.setCashRoomRevenue(reservationStatDaily.getCashRoomRevenue());
                }
                if (reservationStatDaily.getCompRoomRevenue() != null) {
                    existingReservationStatDaily.setCompRoomRevenue(reservationStatDaily.getCompRoomRevenue());
                }
                if (reservationStatDaily.getResInsertSource() != null) {
                    existingReservationStatDaily.setResInsertSource(reservationStatDaily.getResInsertSource());
                }
                if (reservationStatDaily.getResInsertSourceType() != null) {
                    existingReservationStatDaily.setResInsertSourceType(reservationStatDaily.getResInsertSourceType());
                }
                if (reservationStatDaily.getChildren1() != null) {
                    existingReservationStatDaily.setChildren1(reservationStatDaily.getChildren1());
                }
                if (reservationStatDaily.getChildren2() != null) {
                    existingReservationStatDaily.setChildren2(reservationStatDaily.getChildren2());
                }
                if (reservationStatDaily.getChildren3() != null) {
                    existingReservationStatDaily.setChildren3(reservationStatDaily.getChildren3());
                }
                if (reservationStatDaily.getChildren4() != null) {
                    existingReservationStatDaily.setChildren4(reservationStatDaily.getChildren4());
                }
                if (reservationStatDaily.getChildren5() != null) {
                    existingReservationStatDaily.setChildren5(reservationStatDaily.getChildren5());
                }
                if (reservationStatDaily.getFfMembershipType() != null) {
                    existingReservationStatDaily.setFfMembershipType(reservationStatDaily.getFfMembershipType());
                }
                if (reservationStatDaily.getFgMembershipType() != null) {
                    existingReservationStatDaily.setFgMembershipType(reservationStatDaily.getFgMembershipType());
                }
                if (reservationStatDaily.getPromotionCode() != null) {
                    existingReservationStatDaily.setPromotionCode(reservationStatDaily.getPromotionCode());
                }
                if (reservationStatDaily.getOwnerFfFlag() != null) {
                    existingReservationStatDaily.setOwnerFfFlag(reservationStatDaily.getOwnerFfFlag());
                }
                if (reservationStatDaily.getOwnerRentalFlag() != null) {
                    existingReservationStatDaily.setOwnerRentalFlag(reservationStatDaily.getOwnerRentalFlag());
                }
                if (reservationStatDaily.getCentralCurrencyCode() != null) {
                    existingReservationStatDaily.setCentralCurrencyCode(reservationStatDaily.getCentralCurrencyCode());
                }
                if (reservationStatDaily.getCentralExchangeRate() != null) {
                    existingReservationStatDaily.setCentralExchangeRate(reservationStatDaily.getCentralExchangeRate());
                }
                if (reservationStatDaily.getBookedRoomCategory() != null) {
                    existingReservationStatDaily.setBookedRoomCategory(reservationStatDaily.getBookedRoomCategory());
                }
                if (reservationStatDaily.getBusinessDateCreated() != null) {
                    existingReservationStatDaily.setBusinessDateCreated(reservationStatDaily.getBusinessDateCreated());
                }
                if (reservationStatDaily.getRateAmount() != null) {
                    existingReservationStatDaily.setRateAmount(reservationStatDaily.getRateAmount());
                }
                if (reservationStatDaily.getParentCompanyId() != null) {
                    existingReservationStatDaily.setParentCompanyId(reservationStatDaily.getParentCompanyId());
                }
                if (reservationStatDaily.getHouseUseYn() != null) {
                    existingReservationStatDaily.setHouseUseYn(reservationStatDaily.getHouseUseYn());
                }
                if (reservationStatDaily.getComplimentaryYn() != null) {
                    existingReservationStatDaily.setComplimentaryYn(reservationStatDaily.getComplimentaryYn());
                }
                if (reservationStatDaily.getBiResvNameId() != null) {
                    existingReservationStatDaily.setBiResvNameId(reservationStatDaily.getBiResvNameId());
                }
                if (reservationStatDaily.getAdvFoodRevenue() != null) {
                    existingReservationStatDaily.setAdvFoodRevenue(reservationStatDaily.getAdvFoodRevenue());
                }
                if (reservationStatDaily.getAdvNonRevenue() != null) {
                    existingReservationStatDaily.setAdvNonRevenue(reservationStatDaily.getAdvNonRevenue());
                }
                if (reservationStatDaily.getAdvOtherRevenue() != null) {
                    existingReservationStatDaily.setAdvOtherRevenue(reservationStatDaily.getAdvOtherRevenue());
                }
                if (reservationStatDaily.getAdvRoomRevenue() != null) {
                    existingReservationStatDaily.setAdvRoomRevenue(reservationStatDaily.getAdvRoomRevenue());
                }
                if (reservationStatDaily.getAdvTotalFoodTax() != null) {
                    existingReservationStatDaily.setAdvTotalFoodTax(reservationStatDaily.getAdvTotalFoodTax());
                }
                if (reservationStatDaily.getAdvTotalNonRevenueTax() != null) {
                    existingReservationStatDaily.setAdvTotalNonRevenueTax(reservationStatDaily.getAdvTotalNonRevenueTax());
                }
                if (reservationStatDaily.getAdvTotalOtherTax() != null) {
                    existingReservationStatDaily.setAdvTotalOtherTax(reservationStatDaily.getAdvTotalOtherTax());
                }
                if (reservationStatDaily.getAdvTotalRevenue() != null) {
                    existingReservationStatDaily.setAdvTotalRevenue(reservationStatDaily.getAdvTotalRevenue());
                }
                if (reservationStatDaily.getAdvTotalRoomTax() != null) {
                    existingReservationStatDaily.setAdvTotalRoomTax(reservationStatDaily.getAdvTotalRoomTax());
                }
                if (reservationStatDaily.getAdvTotalTax() != null) {
                    existingReservationStatDaily.setAdvTotalTax(reservationStatDaily.getAdvTotalTax());
                }
                if (reservationStatDaily.getPrAdvFoodRevenue() != null) {
                    existingReservationStatDaily.setPrAdvFoodRevenue(reservationStatDaily.getPrAdvFoodRevenue());
                }
                if (reservationStatDaily.getPrAdvNonRevenue() != null) {
                    existingReservationStatDaily.setPrAdvNonRevenue(reservationStatDaily.getPrAdvNonRevenue());
                }
                if (reservationStatDaily.getPrAdvOtherRevenue() != null) {
                    existingReservationStatDaily.setPrAdvOtherRevenue(reservationStatDaily.getPrAdvOtherRevenue());
                }
                if (reservationStatDaily.getPrAdvRoomRevenue() != null) {
                    existingReservationStatDaily.setPrAdvRoomRevenue(reservationStatDaily.getPrAdvRoomRevenue());
                }
                if (reservationStatDaily.getPrAdvTotalFoodTax() != null) {
                    existingReservationStatDaily.setPrAdvTotalFoodTax(reservationStatDaily.getPrAdvTotalFoodTax());
                }
                if (reservationStatDaily.getPrAdvTotalNonRevenueTax() != null) {
                    existingReservationStatDaily.setPrAdvTotalNonRevenueTax(reservationStatDaily.getPrAdvTotalNonRevenueTax());
                }
                if (reservationStatDaily.getPrAdvTotalOtherTax() != null) {
                    existingReservationStatDaily.setPrAdvTotalOtherTax(reservationStatDaily.getPrAdvTotalOtherTax());
                }
                if (reservationStatDaily.getPrAdvTotalRevenue() != null) {
                    existingReservationStatDaily.setPrAdvTotalRevenue(reservationStatDaily.getPrAdvTotalRevenue());
                }
                if (reservationStatDaily.getPrAdvTotalRoomTax() != null) {
                    existingReservationStatDaily.setPrAdvTotalRoomTax(reservationStatDaily.getPrAdvTotalRoomTax());
                }
                if (reservationStatDaily.getPrAdvTotalTax() != null) {
                    existingReservationStatDaily.setPrAdvTotalTax(reservationStatDaily.getPrAdvTotalTax());
                }
                if (reservationStatDaily.getUpsoldRevenue() != null) {
                    existingReservationStatDaily.setUpsoldRevenue(reservationStatDaily.getUpsoldRevenue());
                }
                if (reservationStatDaily.getFlgdRoomRevenue() != null) {
                    existingReservationStatDaily.setFlgdRoomRevenue(reservationStatDaily.getFlgdRoomRevenue());
                }
                if (reservationStatDaily.getFlgdFoodRevenue() != null) {
                    existingReservationStatDaily.setFlgdFoodRevenue(reservationStatDaily.getFlgdFoodRevenue());
                }
                if (reservationStatDaily.getFlgdNonRevenue() != null) {
                    existingReservationStatDaily.setFlgdNonRevenue(reservationStatDaily.getFlgdNonRevenue());
                }
                if (reservationStatDaily.getFlgdOtherRevenue() != null) {
                    existingReservationStatDaily.setFlgdOtherRevenue(reservationStatDaily.getFlgdOtherRevenue());
                }
                if (reservationStatDaily.getFlgdTotalRoomTax() != null) {
                    existingReservationStatDaily.setFlgdTotalRoomTax(reservationStatDaily.getFlgdTotalRoomTax());
                }
                if (reservationStatDaily.getFlgdTotalFoodTax() != null) {
                    existingReservationStatDaily.setFlgdTotalFoodTax(reservationStatDaily.getFlgdTotalFoodTax());
                }
                if (reservationStatDaily.getFlgdTotalNonRevenueTax() != null) {
                    existingReservationStatDaily.setFlgdTotalNonRevenueTax(reservationStatDaily.getFlgdTotalNonRevenueTax());
                }
                if (reservationStatDaily.getFlgdTotalOtherTax() != null) {
                    existingReservationStatDaily.setFlgdTotalOtherTax(reservationStatDaily.getFlgdTotalOtherTax());
                }
                if (reservationStatDaily.getFlgdTotalRevenue() != null) {
                    existingReservationStatDaily.setFlgdTotalRevenue(reservationStatDaily.getFlgdTotalRevenue());
                }
                if (reservationStatDaily.getFlgdTotalTax() != null) {
                    existingReservationStatDaily.setFlgdTotalTax(reservationStatDaily.getFlgdTotalTax());
                }
                if (reservationStatDaily.getContactYn() != null) {
                    existingReservationStatDaily.setContactYn(reservationStatDaily.getContactYn());
                }
                if (reservationStatDaily.getExtendedStayTier() != null) {
                    existingReservationStatDaily.setExtendedStayTier(reservationStatDaily.getExtendedStayTier());
                }
                if (reservationStatDaily.getRsAdvTotalRevenue() != null) {
                    existingReservationStatDaily.setRsAdvTotalRevenue(reservationStatDaily.getRsAdvTotalRevenue());
                }
                if (reservationStatDaily.getRsAdvRoomRevenue() != null) {
                    existingReservationStatDaily.setRsAdvRoomRevenue(reservationStatDaily.getRsAdvRoomRevenue());
                }
                if (reservationStatDaily.getRsAdvFoodRevenue() != null) {
                    existingReservationStatDaily.setRsAdvFoodRevenue(reservationStatDaily.getRsAdvFoodRevenue());
                }
                if (reservationStatDaily.getRsAdvOtherRevenue() != null) {
                    existingReservationStatDaily.setRsAdvOtherRevenue(reservationStatDaily.getRsAdvOtherRevenue());
                }
                if (reservationStatDaily.getRsAdvNonRevenue() != null) {
                    existingReservationStatDaily.setRsAdvNonRevenue(reservationStatDaily.getRsAdvNonRevenue());
                }
                if (reservationStatDaily.getRsAdvTotalTax() != null) {
                    existingReservationStatDaily.setRsAdvTotalTax(reservationStatDaily.getRsAdvTotalTax());
                }
                if (reservationStatDaily.getRsAdvRoomTax() != null) {
                    existingReservationStatDaily.setRsAdvRoomTax(reservationStatDaily.getRsAdvRoomTax());
                }
                if (reservationStatDaily.getRsAdvFoodTax() != null) {
                    existingReservationStatDaily.setRsAdvFoodTax(reservationStatDaily.getRsAdvFoodTax());
                }
                if (reservationStatDaily.getRsAdvOtherTax() != null) {
                    existingReservationStatDaily.setRsAdvOtherTax(reservationStatDaily.getRsAdvOtherTax());
                }
                if (reservationStatDaily.getRsAdvNonRevenueTax() != null) {
                    existingReservationStatDaily.setRsAdvNonRevenueTax(reservationStatDaily.getRsAdvNonRevenueTax());
                }
                if (reservationStatDaily.getUpdateDate() != null) {
                    existingReservationStatDaily.setUpdateDate(reservationStatDaily.getUpdateDate());
                }
                if (reservationStatDaily.getGuid() != null) {
                    existingReservationStatDaily.setGuid(reservationStatDaily.getGuid());
                }

                return existingReservationStatDaily;
            })
            .map(reservationStatDailyRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ReservationStatDaily> findAll(Pageable pageable) {
        log.debug("Request to get all ReservationStatDailies");
        return reservationStatDailyRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ReservationStatDaily> findOne(Long id) {
        log.debug("Request to get ReservationStatDaily : {}", id);
        return reservationStatDailyRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ReservationStatDaily : {}", id);
        reservationStatDailyRepository.deleteById(id);
    }
}
