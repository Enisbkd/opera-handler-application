package com.sbm.mc.service.impl;

import com.sbm.mc.domain.Resort;
import com.sbm.mc.repository.ResortRepository;
import com.sbm.mc.service.ResortService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.Resort}.
 */
@Service
@Transactional
public class ResortServiceImpl implements ResortService {

    private final Logger log = LoggerFactory.getLogger(ResortServiceImpl.class);

    private final ResortRepository resortRepository;

    public ResortServiceImpl(ResortRepository resortRepository) {
        this.resortRepository = resortRepository;
    }

    @Override
    public Resort save(Resort resort) {
        log.debug("Request to save Resort : {}", resort);
        return resortRepository.save(resort);
    }

    @Override
    public Resort update(Resort resort) {
        log.debug("Request to update Resort : {}", resort);
        return resortRepository.save(resort);
    }

    @Override
    public Optional<Resort> partialUpdate(Resort resort) {
        log.debug("Request to partially update Resort : {}", resort);

        return resortRepository
            .findById(resort.getId())
            .map(existingResort -> {
                if (resort.getResort() != null) {
                    existingResort.setResort(resort.getResort());
                }
                if (resort.getBeginDate() != null) {
                    existingResort.setBeginDate(resort.getBeginDate());
                }
                if (resort.getCheckInTime() != null) {
                    existingResort.setCheckInTime(resort.getCheckInTime());
                }
                if (resort.getCheckOutTime() != null) {
                    existingResort.setCheckOutTime(resort.getCheckOutTime());
                }
                if (resort.getVideoCoStart() != null) {
                    existingResort.setVideoCoStart(resort.getVideoCoStart());
                }
                if (resort.getVideoCoStop() != null) {
                    existingResort.setVideoCoStop(resort.getVideoCoStop());
                }
                if (resort.getInsertDate() != null) {
                    existingResort.setInsertDate(resort.getInsertDate());
                }
                if (resort.getUpdateDate() != null) {
                    existingResort.setUpdateDate(resort.getUpdateDate());
                }
                if (resort.getExpiryDate() != null) {
                    existingResort.setExpiryDate(resort.getExpiryDate());
                }
                if (resort.getEndDate() != null) {
                    existingResort.setEndDate(resort.getEndDate());
                }
                if (resort.getFiscalStartDate() != null) {
                    existingResort.setFiscalStartDate(resort.getFiscalStartDate());
                }
                if (resort.getFiscalEndDate() != null) {
                    existingResort.setFiscalEndDate(resort.getFiscalEndDate());
                }
                if (resort.getReconcileDate() != null) {
                    existingResort.setReconcileDate(resort.getReconcileDate());
                }
                if (resort.getPaymentDate() != null) {
                    existingResort.setPaymentDate(resort.getPaymentDate());
                }
                if (resort.getKeepAvailability() != null) {
                    existingResort.setKeepAvailability(resort.getKeepAvailability());
                }
                if (resort.getBudgetMonth() != null) {
                    existingResort.setBudgetMonth(resort.getBudgetMonth());
                }
                if (resort.getSaveProfiles() != null) {
                    existingResort.setSaveProfiles(resort.getSaveProfiles());
                }
                if (resort.getLongStayControl() != null) {
                    existingResort.setLongStayControl(resort.getLongStayControl());
                }
                if (resort.getCreditLimit() != null) {
                    existingResort.setCreditLimit(resort.getCreditLimit());
                }
                if (resort.getNumberRooms() != null) {
                    existingResort.setNumberRooms(resort.getNumberRooms());
                }
                if (resort.getNumberFloors() != null) {
                    existingResort.setNumberFloors(resort.getNumberFloors());
                }
                if (resort.getNumberBeds() != null) {
                    existingResort.setNumberBeds(resort.getNumberBeds());
                }
                if (resort.getRhythmSheets() != null) {
                    existingResort.setRhythmSheets(resort.getRhythmSheets());
                }
                if (resort.getRhythmTowels() != null) {
                    existingResort.setRhythmTowels(resort.getRhythmTowels());
                }
                if (resort.getWarningAmount() != null) {
                    existingResort.setWarningAmount(resort.getWarningAmount());
                }
                if (resort.getDecimalPlaces() != null) {
                    existingResort.setDecimalPlaces(resort.getDecimalPlaces());
                }
                if (resort.getFont() != null) {
                    existingResort.setFont(resort.getFont());
                }
                if (resort.getCopies() != null) {
                    existingResort.setCopies(resort.getCopies());
                }
                if (resort.getDefaultFolioStyle() != null) {
                    existingResort.setDefaultFolioStyle(resort.getDefaultFolioStyle());
                }
                if (resort.getIndividualRoomWarning() != null) {
                    existingResort.setIndividualRoomWarning(resort.getIndividualRoomWarning());
                }
                if (resort.getGroupRoomWarning() != null) {
                    existingResort.setGroupRoomWarning(resort.getGroupRoomWarning());
                }
                if (resort.getAgingLevel1() != null) {
                    existingResort.setAgingLevel1(resort.getAgingLevel1());
                }
                if (resort.getAgingLevel2() != null) {
                    existingResort.setAgingLevel2(resort.getAgingLevel2());
                }
                if (resort.getAgingLevel3() != null) {
                    existingResort.setAgingLevel3(resort.getAgingLevel3());
                }
                if (resort.getAgingLevel4() != null) {
                    existingResort.setAgingLevel4(resort.getAgingLevel4());
                }
                if (resort.getAgingLevel5() != null) {
                    existingResort.setAgingLevel5(resort.getAgingLevel5());
                }
                if (resort.getZeroInvPurDays() != null) {
                    existingResort.setZeroInvPurDays(resort.getZeroInvPurDays());
                }
                if (resort.getMinDaysBet2ReminderLetter() != null) {
                    existingResort.setMinDaysBet2ReminderLetter(resort.getMinDaysBet2ReminderLetter());
                }
                if (resort.getInsertUser() != null) {
                    existingResort.setInsertUser(resort.getInsertUser());
                }
                if (resort.getUpdateUser() != null) {
                    existingResort.setUpdateUser(resort.getUpdateUser());
                }
                if (resort.getCurrencyDecimals() != null) {
                    existingResort.setCurrencyDecimals(resort.getCurrencyDecimals());
                }
                if (resort.getNameIdLink() != null) {
                    existingResort.setNameIdLink(resort.getNameIdLink());
                }
                if (resort.getSglRate1() != null) {
                    existingResort.setSglRate1(resort.getSglRate1());
                }
                if (resort.getSglRate2() != null) {
                    existingResort.setSglRate2(resort.getSglRate2());
                }
                if (resort.getDblRate1() != null) {
                    existingResort.setDblRate1(resort.getDblRate1());
                }
                if (resort.getDblRate2() != null) {
                    existingResort.setDblRate2(resort.getDblRate2());
                }
                if (resort.getTplRate1() != null) {
                    existingResort.setTplRate1(resort.getTplRate1());
                }
                if (resort.getTplRate2() != null) {
                    existingResort.setTplRate2(resort.getTplRate2());
                }
                if (resort.getSuiRate1() != null) {
                    existingResort.setSuiRate1(resort.getSuiRate1());
                }
                if (resort.getSuiRate2() != null) {
                    existingResort.setSuiRate2(resort.getSuiRate2());
                }
                if (resort.getMeetSpace() != null) {
                    existingResort.setMeetSpace(resort.getMeetSpace());
                }
                if (resort.getImgHotelId() != null) {
                    existingResort.setImgHotelId(resort.getImgHotelId());
                }
                if (resort.getImgDirectionId() != null) {
                    existingResort.setImgDirectionId(resort.getImgDirectionId());
                }
                if (resort.getImgMapId() != null) {
                    existingResort.setImgMapId(resort.getImgMapId());
                }
                if (resort.getScriptId() != null) {
                    existingResort.setScriptId(resort.getScriptId());
                }
                if (resort.getComNameXrefId() != null) {
                    existingResort.setComNameXrefId(resort.getComNameXrefId());
                }
                if (resort.getPathId() != null) {
                    existingResort.setPathId(resort.getPathId());
                }
                if (resort.getXresortNumber() != null) {
                    existingResort.setXresortNumber(resort.getXresortNumber());
                }
                if (resort.getMaxCreditDays() != null) {
                    existingResort.setMaxCreditDays(resort.getMaxCreditDays());
                }
                if (resort.getCurrencyDivisor() != null) {
                    existingResort.setCurrencyDivisor(resort.getCurrencyDivisor());
                }
                if (resort.getLatitude() != null) {
                    existingResort.setLatitude(resort.getLatitude());
                }
                if (resort.getLongitude() != null) {
                    existingResort.setLongitude(resort.getLongitude());
                }
                if (resort.getQtySingleRooms() != null) {
                    existingResort.setQtySingleRooms(resort.getQtySingleRooms());
                }
                if (resort.getQtyDoubleRooms() != null) {
                    existingResort.setQtyDoubleRooms(resort.getQtyDoubleRooms());
                }
                if (resort.getQtyTwinRooms() != null) {
                    existingResort.setQtyTwinRooms(resort.getQtyTwinRooms());
                }
                if (resort.getQtySuites() != null) {
                    existingResort.setQtySuites(resort.getQtySuites());
                }
                if (resort.getQtyGuestRoomFloors() != null) {
                    existingResort.setQtyGuestRoomFloors(resort.getQtyGuestRoomFloors());
                }
                if (resort.getQtyGuestElevators() != null) {
                    existingResort.setQtyGuestElevators(resort.getQtyGuestElevators());
                }
                if (resort.getQtyNonSmokingRooms() != null) {
                    existingResort.setQtyNonSmokingRooms(resort.getQtyNonSmokingRooms());
                }
                if (resort.getQtyConnectingRooms() != null) {
                    existingResort.setQtyConnectingRooms(resort.getQtyConnectingRooms());
                }
                if (resort.getQtyHandicappedRooms() != null) {
                    existingResort.setQtyHandicappedRooms(resort.getQtyHandicappedRooms());
                }
                if (resort.getQtyFamilyRooms() != null) {
                    existingResort.setQtyFamilyRooms(resort.getQtyFamilyRooms());
                }
                if (resort.getMaxAdultsFamilyRoom() != null) {
                    existingResort.setMaxAdultsFamilyRoom(resort.getMaxAdultsFamilyRoom());
                }
                if (resort.getMaxChildrenFamilyRoom() != null) {
                    existingResort.setMaxChildrenFamilyRoom(resort.getMaxChildrenFamilyRoom());
                }
                if (resort.getRestaurant() != null) {
                    existingResort.setRestaurant(resort.getRestaurant());
                }
                if (resort.getMeetRooms() != null) {
                    existingResort.setMeetRooms(resort.getMeetRooms());
                }
                if (resort.getTotRooms() != null) {
                    existingResort.setTotRooms(resort.getTotRooms());
                }
                if (resort.getBrSeats() != null) {
                    existingResort.setBrSeats(resort.getBrSeats());
                }
                if (resort.getMeetSeats() != null) {
                    existingResort.setMeetSeats(resort.getMeetSeats());
                }
                if (resort.getMaxNoNights() != null) {
                    existingResort.setMaxNoNights(resort.getMaxNoNights());
                }
                if (resort.getAwardsTimeout() != null) {
                    existingResort.setAwardsTimeout(resort.getAwardsTimeout());
                }
                if (resort.getGuestLookupTimeout() != null) {
                    existingResort.setGuestLookupTimeout(resort.getGuestLookupTimeout());
                }
                if (resort.getWakeUpDelay() != null) {
                    existingResort.setWakeUpDelay(resort.getWakeUpDelay());
                }
                if (resort.getMaxOccupancy() != null) {
                    existingResort.setMaxOccupancy(resort.getMaxOccupancy());
                }
                if (resort.getInactiveDaysForGuestProfil() != null) {
                    existingResort.setInactiveDaysForGuestProfil(resort.getInactiveDaysForGuestProfil());
                }
                if (resort.getPerReservationRoomLimit() != null) {
                    existingResort.setPerReservationRoomLimit(resort.getPerReservationRoomLimit());
                }
                if (resort.getLicRoomInfo() != null) {
                    existingResort.setLicRoomInfo(resort.getLicRoomInfo());
                }
                if (resort.getThousandSeparator() != null) {
                    existingResort.setThousandSeparator(resort.getThousandSeparator());
                }
                if (resort.getDateSeparator() != null) {
                    existingResort.setDateSeparator(resort.getDateSeparator());
                }
                if (resort.getArAcctNoMandYn() != null) {
                    existingResort.setArAcctNoMandYn(resort.getArAcctNoMandYn());
                }
                if (resort.getExchangePostingType() != null) {
                    existingResort.setExchangePostingType(resort.getExchangePostingType());
                }
                if (resort.getInventoryYn() != null) {
                    existingResort.setInventoryYn(resort.getInventoryYn());
                }
                if (resort.getAllowLoginYn() != null) {
                    existingResort.setAllowLoginYn(resort.getAllowLoginYn());
                }
                if (resort.getAccessCode() != null) {
                    existingResort.setAccessCode(resort.getAccessCode());
                }
                if (resort.getDisableLoginYn() != null) {
                    existingResort.setDisableLoginYn(resort.getDisableLoginYn());
                }
                if (resort.getIntTaxIncludedYn() != null) {
                    existingResort.setIntTaxIncludedYn(resort.getIntTaxIncludedYn());
                }
                if (resort.getDownloadRestYn() != null) {
                    existingResort.setDownloadRestYn(resort.getDownloadRestYn());
                }
                if (resort.getTranslateMulticharYn() != null) {
                    existingResort.setTranslateMulticharYn(resort.getTranslateMulticharYn());
                }
                if (resort.getExternalScYn() != null) {
                    existingResort.setExternalScYn(resort.getExternalScYn());
                }
                if (resort.getSendLeadAsBookingYn() != null) {
                    existingResort.setSendLeadAsBookingYn(resort.getSendLeadAsBookingYn());
                }
                if (resort.getMbsSupportedYn() != null) {
                    existingResort.setMbsSupportedYn(resort.getMbsSupportedYn());
                }
                if (resort.getQuotedCurrency() != null) {
                    existingResort.setQuotedCurrency(resort.getQuotedCurrency());
                }
                if (resort.getComMethod() != null) {
                    existingResort.setComMethod(resort.getComMethod());
                }
                if (resort.getEmail() != null) {
                    existingResort.setEmail(resort.getEmail());
                }
                if (resort.getGenmgr() != null) {
                    existingResort.setGenmgr(resort.getGenmgr());
                }
                if (resort.getDirsales() != null) {
                    existingResort.setDirsales(resort.getDirsales());
                }
                if (resort.getLeadsend() != null) {
                    existingResort.setLeadsend(resort.getLeadsend());
                }
                if (resort.getAirport() != null) {
                    existingResort.setAirport(resort.getAirport());
                }
                if (resort.getComAddress() != null) {
                    existingResort.setComAddress(resort.getComAddress());
                }
                if (resort.getSeason1() != null) {
                    existingResort.setSeason1(resort.getSeason1());
                }
                if (resort.getSeason2() != null) {
                    existingResort.setSeason2(resort.getSeason2());
                }
                if (resort.getSeason3() != null) {
                    existingResort.setSeason3(resort.getSeason3());
                }
                if (resort.getSeason4() != null) {
                    existingResort.setSeason4(resort.getSeason4());
                }
                if (resort.getSeason5() != null) {
                    existingResort.setSeason5(resort.getSeason5());
                }
                if (resort.getFloorNumExecutiveFloor() != null) {
                    existingResort.setFloorNumExecutiveFloor(resort.getFloorNumExecutiveFloor());
                }
                if (resort.getCrsResort() != null) {
                    existingResort.setCrsResort(resort.getCrsResort());
                }
                if (resort.getPostCode() != null) {
                    existingResort.setPostCode(resort.getPostCode());
                }
                if (resort.getDefaultReservationType() != null) {
                    existingResort.setDefaultReservationType(resort.getDefaultReservationType());
                }
                if (resort.getBlock() != null) {
                    existingResort.setBlock(resort.getBlock());
                }
                if (resort.getCurrencySymbol() != null) {
                    existingResort.setCurrencySymbol(resort.getCurrencySymbol());
                }
                if (resort.getSourceCommission() != null) {
                    existingResort.setSourceCommission(resort.getSourceCommission());
                }
                if (resort.getTaCommission() != null) {
                    existingResort.setTaCommission(resort.getTaCommission());
                }
                if (resort.getBaseLanguage() != null) {
                    existingResort.setBaseLanguage(resort.getBaseLanguage());
                }
                if (resort.getFolioLanguage1() != null) {
                    existingResort.setFolioLanguage1(resort.getFolioLanguage1());
                }
                if (resort.getFolioLanguage2() != null) {
                    existingResort.setFolioLanguage2(resort.getFolioLanguage2());
                }
                if (resort.getFolioLanguage3() != null) {
                    existingResort.setFolioLanguage3(resort.getFolioLanguage3());
                }
                if (resort.getFolioLanguage4() != null) {
                    existingResort.setFolioLanguage4(resort.getFolioLanguage4());
                }
                if (resort.getPackageProfit() != null) {
                    existingResort.setPackageProfit(resort.getPackageProfit());
                }
                if (resort.getPackageLoss() != null) {
                    existingResort.setPackageLoss(resort.getPackageLoss());
                }
                if (resort.getDecimalSeparator() != null) {
                    existingResort.setDecimalSeparator(resort.getDecimalSeparator());
                }
                if (resort.getShortDateFormat() != null) {
                    existingResort.setShortDateFormat(resort.getShortDateFormat());
                }
                if (resort.getLongDateFormat() != null) {
                    existingResort.setLongDateFormat(resort.getLongDateFormat());
                }
                if (resort.getPasserbySource() != null) {
                    existingResort.setPasserbySource(resort.getPasserbySource());
                }
                if (resort.getPasserbyMarket() != null) {
                    existingResort.setPasserbyMarket(resort.getPasserbyMarket());
                }
                if (resort.getArCompany() != null) {
                    existingResort.setArCompany(resort.getArCompany());
                }
                if (resort.getArAgent() != null) {
                    existingResort.setArAgent(resort.getArAgent());
                }
                if (resort.getArGroups() != null) {
                    existingResort.setArGroups(resort.getArGroups());
                }
                if (resort.getArIndividuals() != null) {
                    existingResort.setArIndividuals(resort.getArIndividuals());
                }
                if (resort.getArAcctNoFormat() != null) {
                    existingResort.setArAcctNoFormat(resort.getArAcctNoFormat());
                }
                if (resort.getAllowancePeriodAdj() != null) {
                    existingResort.setAllowancePeriodAdj(resort.getAllowancePeriodAdj());
                }
                if (resort.getCurrencyCode() != null) {
                    existingResort.setCurrencyCode(resort.getCurrencyCode());
                }
                if (resort.getTurnawayCode() != null) {
                    existingResort.setTurnawayCode(resort.getTurnawayCode());
                }
                if (resort.getSummCurrencyCode() != null) {
                    existingResort.setSummCurrencyCode(resort.getSummCurrencyCode());
                }
                if (resort.getDefaultPropertyAddress() != null) {
                    existingResort.setDefaultPropertyAddress(resort.getDefaultPropertyAddress());
                }
                if (resort.getDefaultGuestAddress() != null) {
                    existingResort.setDefaultGuestAddress(resort.getDefaultGuestAddress());
                }
                if (resort.getLicenseCode() != null) {
                    existingResort.setLicenseCode(resort.getLicenseCode());
                }
                if (resort.getTimeFormat() != null) {
                    existingResort.setTimeFormat(resort.getTimeFormat());
                }
                if (resort.getChainCode() != null) {
                    existingResort.setChainCode(resort.getChainCode());
                }
                if (resort.getResortType() != null) {
                    existingResort.setResortType(resort.getResortType());
                }
                if (resort.getHotelType() != null) {
                    existingResort.setHotelType(resort.getHotelType());
                }
                if (resort.getOwnership() != null) {
                    existingResort.setOwnership(resort.getOwnership());
                }
                if (resort.getArBalTrxCode() != null) {
                    existingResort.setArBalTrxCode(resort.getArBalTrxCode());
                }
                if (resort.getArCreditTrxCode() != null) {
                    existingResort.setArCreditTrxCode(resort.getArCreditTrxCode());
                }
                if (resort.getArSettleCode() != null) {
                    existingResort.setArSettleCode(resort.getArSettleCode());
                }
                if (resort.getCashShiftDrop() != null) {
                    existingResort.setCashShiftDrop(resort.getCashShiftDrop());
                }
                if (resort.getCheckExgPaidout() != null) {
                    existingResort.setCheckExgPaidout(resort.getCheckExgPaidout());
                }
                if (resort.getCheckShiftDrop() != null) {
                    existingResort.setCheckShiftDrop(resort.getCheckShiftDrop());
                }
                if (resort.getCheckTrxcode() != null) {
                    existingResort.setCheckTrxcode(resort.getCheckTrxcode());
                }
                if (resort.getCurrencyExgPaidout() != null) {
                    existingResort.setCurrencyExgPaidout(resort.getCurrencyExgPaidout());
                }
                if (resort.getDepositLedTrxCode() != null) {
                    existingResort.setDepositLedTrxCode(resort.getDepositLedTrxCode());
                }
                if (resort.getFiscalPeriodType() != null) {
                    existingResort.setFiscalPeriodType(resort.getFiscalPeriodType());
                }
                if (resort.getDefaultCommissionPercentage() != null) {
                    existingResort.setDefaultCommissionPercentage(resort.getDefaultCommissionPercentage());
                }
                if (resort.getDefaultPrepaidComm() != null) {
                    existingResort.setDefaultPrepaidComm(resort.getDefaultPrepaidComm());
                }
                if (resort.getDefaultTrxCommCode() != null) {
                    existingResort.setDefaultTrxCommCode(resort.getDefaultTrxCommCode());
                }
                if (resort.getConfigurationMode() != null) {
                    existingResort.setConfigurationMode(resort.getConfigurationMode());
                }
                if (resort.getWeekendDays() != null) {
                    existingResort.setWeekendDays(resort.getWeekendDays());
                }
                if (resort.getDefaultGroupsRateCode() != null) {
                    existingResort.setDefaultGroupsRateCode(resort.getDefaultGroupsRateCode());
                }
                if (resort.getDefaultPostingRoom() != null) {
                    existingResort.setDefaultPostingRoom(resort.getDefaultPostingRoom());
                }
                if (resort.getDfltPkgTranCode() != null) {
                    existingResort.setDfltPkgTranCode(resort.getDfltPkgTranCode());
                }
                if (resort.getDfltTranCodeRateCode() != null) {
                    existingResort.setDfltTranCodeRateCode(resort.getDfltTranCodeRateCode());
                }
                if (resort.getDefaultRateCode() != null) {
                    existingResort.setDefaultRateCode(resort.getDefaultRateCode());
                }
                if (resort.getCroCode() != null) {
                    existingResort.setCroCode(resort.getCroCode());
                }
                if (resort.getFlowCode() != null) {
                    existingResort.setFlowCode(resort.getFlowCode());
                }
                if (resort.getExtPropertyCode() != null) {
                    existingResort.setExtPropertyCode(resort.getExtPropertyCode());
                }
                if (resort.getOpusCurrencyCode() != null) {
                    existingResort.setOpusCurrencyCode(resort.getOpusCurrencyCode());
                }
                if (resort.getDestinationId() != null) {
                    existingResort.setDestinationId(resort.getDestinationId());
                }
                if (resort.getFlags() != null) {
                    existingResort.setFlags(resort.getFlags());
                }
                if (resort.getTouristNumber() != null) {
                    existingResort.setTouristNumber(resort.getTouristNumber());
                }
                if (resort.getCateringCurrencyCode() != null) {
                    existingResort.setCateringCurrencyCode(resort.getCateringCurrencyCode());
                }
                if (resort.getDefaultRatecodeRack() != null) {
                    existingResort.setDefaultRatecodeRack(resort.getDefaultRatecodeRack());
                }
                if (resort.getDefaultRatecodePcr() != null) {
                    existingResort.setDefaultRatecodePcr(resort.getDefaultRatecodePcr());
                }
                if (resort.getFnsTier() != null) {
                    existingResort.setFnsTier(resort.getFnsTier());
                }
                if (resort.getBrandCode() != null) {
                    existingResort.setBrandCode(resort.getBrandCode());
                }
                if (resort.getWebaddress() != null) {
                    existingResort.setWebaddress(resort.getWebaddress());
                }
                if (resort.getVatId() != null) {
                    existingResort.setVatId(resort.getVatId());
                }
                if (resort.getStreet() != null) {
                    existingResort.setStreet(resort.getStreet());
                }
                if (resort.getHotelFc() != null) {
                    existingResort.setHotelFc(resort.getHotelFc());
                }
                if (resort.getMeetingFc() != null) {
                    existingResort.setMeetingFc(resort.getMeetingFc());
                }
                if (resort.getArTypewriter() != null) {
                    existingResort.setArTypewriter(resort.getArTypewriter());
                }
                if (resort.getFileTransferFormat() != null) {
                    existingResort.setFileTransferFormat(resort.getFileTransferFormat());
                }
                if (resort.getConfirmRegcardPrinter() != null) {
                    existingResort.setConfirmRegcardPrinter(resort.getConfirmRegcardPrinter());
                }
                if (resort.getDirections() != null) {
                    existingResort.setDirections(resort.getDirections());
                }
                if (resort.getPropinfoUrl() != null) {
                    existingResort.setPropinfoUrl(resort.getPropinfoUrl());
                }
                if (resort.getRoomAmenity() != null) {
                    existingResort.setRoomAmenity(resort.getRoomAmenity());
                }
                if (resort.getShopDescription() != null) {
                    existingResort.setShopDescription(resort.getShopDescription());
                }
                if (resort.getPropPicUrl() != null) {
                    existingResort.setPropPicUrl(resort.getPropPicUrl());
                }
                if (resort.getPropMapUrl() != null) {
                    existingResort.setPropMapUrl(resort.getPropMapUrl());
                }
                if (resort.getExtExpFileLocation() != null) {
                    existingResort.setExtExpFileLocation(resort.getExtExpFileLocation());
                }
                if (resort.getCurtainColor() != null) {
                    existingResort.setCurtainColor(resort.getCurtainColor());
                }
                if (resort.getCountryCode() != null) {
                    existingResort.setCountryCode(resort.getCountryCode());
                }
                if (resort.getState() != null) {
                    existingResort.setState(resort.getState());
                }
                if (resort.getDateForAging() != null) {
                    existingResort.setDateForAging(resort.getDateForAging());
                }
                if (resort.getRegionCode() != null) {
                    existingResort.setRegionCode(resort.getRegionCode());
                }
                if (resort.getCity() != null) {
                    existingResort.setCity(resort.getCity());
                }
                if (resort.getTelephone() != null) {
                    existingResort.setTelephone(resort.getTelephone());
                }
                if (resort.getFax() != null) {
                    existingResort.setFax(resort.getFax());
                }
                if (resort.getTollfree() != null) {
                    existingResort.setTollfree(resort.getTollfree());
                }
                if (resort.getDefaultPrinter() != null) {
                    existingResort.setDefaultPrinter(resort.getDefaultPrinter());
                }
                if (resort.getVideocheckoutPrinter() != null) {
                    existingResort.setVideocheckoutPrinter(resort.getVideocheckoutPrinter());
                }
                if (resort.getCompanyAddressType() != null) {
                    existingResort.setCompanyAddressType(resort.getCompanyAddressType());
                }
                if (resort.getCompanyPhoneType() != null) {
                    existingResort.setCompanyPhoneType(resort.getCompanyPhoneType());
                }
                if (resort.getDefaultFaxType() != null) {
                    existingResort.setDefaultFaxType(resort.getDefaultFaxType());
                }
                if (resort.getDefaultMembershipType() != null) {
                    existingResort.setDefaultMembershipType(resort.getDefaultMembershipType());
                }
                if (resort.getIndividualAddressType() != null) {
                    existingResort.setIndividualAddressType(resort.getIndividualAddressType());
                }
                if (resort.getIndividualPhoneType() != null) {
                    existingResort.setIndividualPhoneType(resort.getIndividualPhoneType());
                }
                if (resort.getNotes() != null) {
                    existingResort.setNotes(resort.getNotes());
                }
                if (resort.getBlackoutPeriodNotes() != null) {
                    existingResort.setBlackoutPeriodNotes(resort.getBlackoutPeriodNotes());
                }
                if (resort.getSglNum() != null) {
                    existingResort.setSglNum(resort.getSglNum());
                }
                if (resort.getDblNum() != null) {
                    existingResort.setDblNum(resort.getDblNum());
                }
                if (resort.getTplNum() != null) {
                    existingResort.setTplNum(resort.getTplNum());
                }
                if (resort.getSuiNum() != null) {
                    existingResort.setSuiNum(resort.getSuiNum());
                }
                if (resort.getAirportDistance() != null) {
                    existingResort.setAirportDistance(resort.getAirportDistance());
                }
                if (resort.getAirportTime() != null) {
                    existingResort.setAirportTime(resort.getAirportTime());
                }
                if (resort.getBrArea() != null) {
                    existingResort.setBrArea(resort.getBrArea());
                }
                if (resort.getName() != null) {
                    existingResort.setName(resort.getName());
                }
                if (resort.getLegalOwner() != null) {
                    existingResort.setLegalOwner(resort.getLegalOwner());
                }
                if (resort.getHotelId() != null) {
                    existingResort.setHotelId(resort.getHotelId());
                }
                if (resort.getFaxNoFormat() != null) {
                    existingResort.setFaxNoFormat(resort.getFaxNoFormat());
                }
                if (resort.getTelephoneNoFormat() != null) {
                    existingResort.setTelephoneNoFormat(resort.getTelephoneNoFormat());
                }
                if (resort.getLocalCurrencyFormat() != null) {
                    existingResort.setLocalCurrencyFormat(resort.getLocalCurrencyFormat());
                }
                if (resort.getDutyManagerPager() != null) {
                    existingResort.setDutyManagerPager(resort.getDutyManagerPager());
                }
                if (resort.getDefaultRegistrationCard() != null) {
                    existingResort.setDefaultRegistrationCard(resort.getDefaultRegistrationCard());
                }
                if (resort.getNightAuditCashierId() != null) {
                    existingResort.setNightAuditCashierId(resort.getNightAuditCashierId());
                }
                if (resort.getHotelCode() != null) {
                    existingResort.setHotelCode(resort.getHotelCode());
                }
                if (resort.getPath() != null) {
                    existingResort.setPath(resort.getPath());
                }
                if (resort.getTimezoneRegion() != null) {
                    existingResort.setTimezoneRegion(resort.getTimezoneRegion());
                }
                if (resort.getCateringCurrencyFormat() != null) {
                    existingResort.setCateringCurrencyFormat(resort.getCateringCurrencyFormat());
                }
                if (resort.getExpHotelCode() != null) {
                    existingResort.setExpHotelCode(resort.getExpHotelCode());
                }

                return existingResort;
            })
            .map(resortRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Resort> findAll(Pageable pageable) {
        log.debug("Request to get all Resorts");
        return resortRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Resort> findOne(String id) {
        log.debug("Request to get Resort : {}", id);
        return resortRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Resort : {}", id);
        resortRepository.deleteById(id);
    }
}
