package com.sbm.mc.domain;

import static com.sbm.mc.domain.AssertUtils.zonedDataTimeSameInstant;
import static org.assertj.core.api.Assertions.assertThat;

public class ResortAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertResortAllPropertiesEquals(Resort expected, Resort actual) {
        assertResortAutoGeneratedPropertiesEquals(expected, actual);
        assertResortAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertResortAllUpdatablePropertiesEquals(Resort expected, Resort actual) {
        assertResortUpdatableFieldsEquals(expected, actual);
        assertResortUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertResortAutoGeneratedPropertiesEquals(Resort expected, Resort actual) {
        assertThat(expected)
            .as("Verify Resort auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertResortUpdatableFieldsEquals(Resort expected, Resort actual) {
        assertThat(expected)
            .as("Verify Resort relevant properties")
            .satisfies(e -> assertThat(e.getResort()).as("check resort").isEqualTo(actual.getResort()))
            .satisfies(
                e ->
                    assertThat(e.getBeginDate())
                        .as("check beginDate")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getBeginDate())
            )
            .satisfies(
                e ->
                    assertThat(e.getCheckInTime())
                        .as("check checkInTime")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getCheckInTime())
            )
            .satisfies(
                e ->
                    assertThat(e.getCheckOutTime())
                        .as("check checkOutTime")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getCheckOutTime())
            )
            .satisfies(
                e ->
                    assertThat(e.getVideoCoStart())
                        .as("check videoCoStart")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getVideoCoStart())
            )
            .satisfies(
                e ->
                    assertThat(e.getVideoCoStop())
                        .as("check videoCoStop")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getVideoCoStop())
            )
            .satisfies(
                e ->
                    assertThat(e.getInsertDate())
                        .as("check insertDate")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getInsertDate())
            )
            .satisfies(
                e ->
                    assertThat(e.getUpdateDate())
                        .as("check updateDate")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getUpdateDate())
            )
            .satisfies(
                e ->
                    assertThat(e.getExpiryDate())
                        .as("check expiryDate")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getExpiryDate())
            )
            .satisfies(
                e -> assertThat(e.getEndDate()).as("check endDate").usingComparator(zonedDataTimeSameInstant).isEqualTo(actual.getEndDate())
            )
            .satisfies(
                e ->
                    assertThat(e.getFiscalStartDate())
                        .as("check fiscalStartDate")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getFiscalStartDate())
            )
            .satisfies(
                e ->
                    assertThat(e.getFiscalEndDate())
                        .as("check fiscalEndDate")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getFiscalEndDate())
            )
            .satisfies(
                e ->
                    assertThat(e.getReconcileDate())
                        .as("check reconcileDate")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getReconcileDate())
            )
            .satisfies(
                e ->
                    assertThat(e.getPaymentDate())
                        .as("check paymentDate")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getPaymentDate())
            )
            .satisfies(e -> assertThat(e.getKeepAvailability()).as("check keepAvailability").isEqualTo(actual.getKeepAvailability()))
            .satisfies(e -> assertThat(e.getBudgetMonth()).as("check budgetMonth").isEqualTo(actual.getBudgetMonth()))
            .satisfies(e -> assertThat(e.getSaveProfiles()).as("check saveProfiles").isEqualTo(actual.getSaveProfiles()))
            .satisfies(e -> assertThat(e.getLongStayControl()).as("check longStayControl").isEqualTo(actual.getLongStayControl()))
            .satisfies(e -> assertThat(e.getCreditLimit()).as("check creditLimit").isEqualTo(actual.getCreditLimit()))
            .satisfies(e -> assertThat(e.getNumberRooms()).as("check numberRooms").isEqualTo(actual.getNumberRooms()))
            .satisfies(e -> assertThat(e.getNumberFloors()).as("check numberFloors").isEqualTo(actual.getNumberFloors()))
            .satisfies(e -> assertThat(e.getNumberBeds()).as("check numberBeds").isEqualTo(actual.getNumberBeds()))
            .satisfies(e -> assertThat(e.getRhythmSheets()).as("check rhythmSheets").isEqualTo(actual.getRhythmSheets()))
            .satisfies(e -> assertThat(e.getRhythmTowels()).as("check rhythmTowels").isEqualTo(actual.getRhythmTowels()))
            .satisfies(e -> assertThat(e.getWarningAmount()).as("check warningAmount").isEqualTo(actual.getWarningAmount()))
            .satisfies(e -> assertThat(e.getDecimalPlaces()).as("check decimalPlaces").isEqualTo(actual.getDecimalPlaces()))
            .satisfies(e -> assertThat(e.getFont()).as("check font").isEqualTo(actual.getFont()))
            .satisfies(e -> assertThat(e.getCopies()).as("check copies").isEqualTo(actual.getCopies()))
            .satisfies(e -> assertThat(e.getDefaultFolioStyle()).as("check defaultFolioStyle").isEqualTo(actual.getDefaultFolioStyle()))
            .satisfies(
                e -> assertThat(e.getIndividualRoomWarning()).as("check individualRoomWarning").isEqualTo(actual.getIndividualRoomWarning())
            )
            .satisfies(e -> assertThat(e.getGroupRoomWarning()).as("check groupRoomWarning").isEqualTo(actual.getGroupRoomWarning()))
            .satisfies(e -> assertThat(e.getAgingLevel1()).as("check agingLevel1").isEqualTo(actual.getAgingLevel1()))
            .satisfies(e -> assertThat(e.getAgingLevel2()).as("check agingLevel2").isEqualTo(actual.getAgingLevel2()))
            .satisfies(e -> assertThat(e.getAgingLevel3()).as("check agingLevel3").isEqualTo(actual.getAgingLevel3()))
            .satisfies(e -> assertThat(e.getAgingLevel4()).as("check agingLevel4").isEqualTo(actual.getAgingLevel4()))
            .satisfies(e -> assertThat(e.getAgingLevel5()).as("check agingLevel5").isEqualTo(actual.getAgingLevel5()))
            .satisfies(e -> assertThat(e.getZeroInvPurDays()).as("check zeroInvPurDays").isEqualTo(actual.getZeroInvPurDays()))
            .satisfies(
                e ->
                    assertThat(e.getMinDaysBet2ReminderLetter())
                        .as("check minDaysBet2ReminderLetter")
                        .isEqualTo(actual.getMinDaysBet2ReminderLetter())
            )
            .satisfies(e -> assertThat(e.getInsertUser()).as("check insertUser").isEqualTo(actual.getInsertUser()))
            .satisfies(e -> assertThat(e.getUpdateUser()).as("check updateUser").isEqualTo(actual.getUpdateUser()))
            .satisfies(e -> assertThat(e.getCurrencyDecimals()).as("check currencyDecimals").isEqualTo(actual.getCurrencyDecimals()))
            .satisfies(e -> assertThat(e.getNameIdLink()).as("check nameIdLink").isEqualTo(actual.getNameIdLink()))
            .satisfies(e -> assertThat(e.getSglRate1()).as("check sglRate1").isEqualTo(actual.getSglRate1()))
            .satisfies(e -> assertThat(e.getSglRate2()).as("check sglRate2").isEqualTo(actual.getSglRate2()))
            .satisfies(e -> assertThat(e.getDblRate1()).as("check dblRate1").isEqualTo(actual.getDblRate1()))
            .satisfies(e -> assertThat(e.getDblRate2()).as("check dblRate2").isEqualTo(actual.getDblRate2()))
            .satisfies(e -> assertThat(e.getTplRate1()).as("check tplRate1").isEqualTo(actual.getTplRate1()))
            .satisfies(e -> assertThat(e.getTplRate2()).as("check tplRate2").isEqualTo(actual.getTplRate2()))
            .satisfies(e -> assertThat(e.getSuiRate1()).as("check suiRate1").isEqualTo(actual.getSuiRate1()))
            .satisfies(e -> assertThat(e.getSuiRate2()).as("check suiRate2").isEqualTo(actual.getSuiRate2()))
            .satisfies(e -> assertThat(e.getMeetSpace()).as("check meetSpace").isEqualTo(actual.getMeetSpace()))
            .satisfies(e -> assertThat(e.getImgHotelId()).as("check imgHotelId").isEqualTo(actual.getImgHotelId()))
            .satisfies(e -> assertThat(e.getImgDirectionId()).as("check imgDirectionId").isEqualTo(actual.getImgDirectionId()))
            .satisfies(e -> assertThat(e.getImgMapId()).as("check imgMapId").isEqualTo(actual.getImgMapId()))
            .satisfies(e -> assertThat(e.getScriptId()).as("check scriptId").isEqualTo(actual.getScriptId()))
            .satisfies(e -> assertThat(e.getComNameXrefId()).as("check comNameXrefId").isEqualTo(actual.getComNameXrefId()))
            .satisfies(e -> assertThat(e.getPathId()).as("check pathId").isEqualTo(actual.getPathId()))
            .satisfies(e -> assertThat(e.getXresortNumber()).as("check xresortNumber").isEqualTo(actual.getXresortNumber()))
            .satisfies(e -> assertThat(e.getMaxCreditDays()).as("check maxCreditDays").isEqualTo(actual.getMaxCreditDays()))
            .satisfies(e -> assertThat(e.getCurrencyDivisor()).as("check currencyDivisor").isEqualTo(actual.getCurrencyDivisor()))
            .satisfies(e -> assertThat(e.getLatitude()).as("check latitude").isEqualTo(actual.getLatitude()))
            .satisfies(e -> assertThat(e.getLongitude()).as("check longitude").isEqualTo(actual.getLongitude()))
            .satisfies(e -> assertThat(e.getQtySingleRooms()).as("check qtySingleRooms").isEqualTo(actual.getQtySingleRooms()))
            .satisfies(e -> assertThat(e.getQtyDoubleRooms()).as("check qtyDoubleRooms").isEqualTo(actual.getQtyDoubleRooms()))
            .satisfies(e -> assertThat(e.getQtyTwinRooms()).as("check qtyTwinRooms").isEqualTo(actual.getQtyTwinRooms()))
            .satisfies(e -> assertThat(e.getQtySuites()).as("check qtySuites").isEqualTo(actual.getQtySuites()))
            .satisfies(e -> assertThat(e.getQtyGuestRoomFloors()).as("check qtyGuestRoomFloors").isEqualTo(actual.getQtyGuestRoomFloors()))
            .satisfies(e -> assertThat(e.getQtyGuestElevators()).as("check qtyGuestElevators").isEqualTo(actual.getQtyGuestElevators()))
            .satisfies(e -> assertThat(e.getQtyNonSmokingRooms()).as("check qtyNonSmokingRooms").isEqualTo(actual.getQtyNonSmokingRooms()))
            .satisfies(e -> assertThat(e.getQtyConnectingRooms()).as("check qtyConnectingRooms").isEqualTo(actual.getQtyConnectingRooms()))
            .satisfies(
                e -> assertThat(e.getQtyHandicappedRooms()).as("check qtyHandicappedRooms").isEqualTo(actual.getQtyHandicappedRooms())
            )
            .satisfies(e -> assertThat(e.getQtyFamilyRooms()).as("check qtyFamilyRooms").isEqualTo(actual.getQtyFamilyRooms()))
            .satisfies(
                e -> assertThat(e.getMaxAdultsFamilyRoom()).as("check maxAdultsFamilyRoom").isEqualTo(actual.getMaxAdultsFamilyRoom())
            )
            .satisfies(
                e -> assertThat(e.getMaxChildrenFamilyRoom()).as("check maxChildrenFamilyRoom").isEqualTo(actual.getMaxChildrenFamilyRoom())
            )
            .satisfies(e -> assertThat(e.getRestaurant()).as("check restaurant").isEqualTo(actual.getRestaurant()))
            .satisfies(e -> assertThat(e.getMeetRooms()).as("check meetRooms").isEqualTo(actual.getMeetRooms()))
            .satisfies(e -> assertThat(e.getTotRooms()).as("check totRooms").isEqualTo(actual.getTotRooms()))
            .satisfies(e -> assertThat(e.getBrSeats()).as("check brSeats").isEqualTo(actual.getBrSeats()))
            .satisfies(e -> assertThat(e.getMeetSeats()).as("check meetSeats").isEqualTo(actual.getMeetSeats()))
            .satisfies(e -> assertThat(e.getMaxNoNights()).as("check maxNoNights").isEqualTo(actual.getMaxNoNights()))
            .satisfies(e -> assertThat(e.getAwardsTimeout()).as("check awardsTimeout").isEqualTo(actual.getAwardsTimeout()))
            .satisfies(e -> assertThat(e.getGuestLookupTimeout()).as("check guestLookupTimeout").isEqualTo(actual.getGuestLookupTimeout()))
            .satisfies(e -> assertThat(e.getWakeUpDelay()).as("check wakeUpDelay").isEqualTo(actual.getWakeUpDelay()))
            .satisfies(e -> assertThat(e.getMaxOccupancy()).as("check maxOccupancy").isEqualTo(actual.getMaxOccupancy()))
            .satisfies(
                e ->
                    assertThat(e.getInactiveDaysForGuestProfil())
                        .as("check inactiveDaysForGuestProfil")
                        .isEqualTo(actual.getInactiveDaysForGuestProfil())
            )
            .satisfies(
                e ->
                    assertThat(e.getPerReservationRoomLimit())
                        .as("check perReservationRoomLimit")
                        .isEqualTo(actual.getPerReservationRoomLimit())
            )
            .satisfies(e -> assertThat(e.getLicRoomInfo()).as("check licRoomInfo").isEqualTo(actual.getLicRoomInfo()))
            .satisfies(e -> assertThat(e.getThousandSeparator()).as("check thousandSeparator").isEqualTo(actual.getThousandSeparator()))
            .satisfies(e -> assertThat(e.getDateSeparator()).as("check dateSeparator").isEqualTo(actual.getDateSeparator()))
            .satisfies(e -> assertThat(e.getArAcctNoMandYn()).as("check arAcctNoMandYn").isEqualTo(actual.getArAcctNoMandYn()))
            .satisfies(
                e -> assertThat(e.getExchangePostingType()).as("check exchangePostingType").isEqualTo(actual.getExchangePostingType())
            )
            .satisfies(e -> assertThat(e.getInventoryYn()).as("check inventoryYn").isEqualTo(actual.getInventoryYn()))
            .satisfies(e -> assertThat(e.getAllowLoginYn()).as("check allowLoginYn").isEqualTo(actual.getAllowLoginYn()))
            .satisfies(e -> assertThat(e.getAccessCode()).as("check accessCode").isEqualTo(actual.getAccessCode()))
            .satisfies(e -> assertThat(e.getDisableLoginYn()).as("check disableLoginYn").isEqualTo(actual.getDisableLoginYn()))
            .satisfies(e -> assertThat(e.getIntTaxIncludedYn()).as("check intTaxIncludedYn").isEqualTo(actual.getIntTaxIncludedYn()))
            .satisfies(e -> assertThat(e.getDownloadRestYn()).as("check downloadRestYn").isEqualTo(actual.getDownloadRestYn()))
            .satisfies(
                e -> assertThat(e.getTranslateMulticharYn()).as("check translateMulticharYn").isEqualTo(actual.getTranslateMulticharYn())
            )
            .satisfies(e -> assertThat(e.getExternalScYn()).as("check externalScYn").isEqualTo(actual.getExternalScYn()))
            .satisfies(
                e -> assertThat(e.getSendLeadAsBookingYn()).as("check sendLeadAsBookingYn").isEqualTo(actual.getSendLeadAsBookingYn())
            )
            .satisfies(e -> assertThat(e.getMbsSupportedYn()).as("check mbsSupportedYn").isEqualTo(actual.getMbsSupportedYn()))
            .satisfies(e -> assertThat(e.getQuotedCurrency()).as("check quotedCurrency").isEqualTo(actual.getQuotedCurrency()))
            .satisfies(e -> assertThat(e.getComMethod()).as("check comMethod").isEqualTo(actual.getComMethod()))
            .satisfies(e -> assertThat(e.getEmail()).as("check email").isEqualTo(actual.getEmail()))
            .satisfies(e -> assertThat(e.getGenmgr()).as("check genmgr").isEqualTo(actual.getGenmgr()))
            .satisfies(e -> assertThat(e.getDirsales()).as("check dirsales").isEqualTo(actual.getDirsales()))
            .satisfies(e -> assertThat(e.getLeadsend()).as("check leadsend").isEqualTo(actual.getLeadsend()))
            .satisfies(e -> assertThat(e.getAirport()).as("check airport").isEqualTo(actual.getAirport()))
            .satisfies(e -> assertThat(e.getComAddress()).as("check comAddress").isEqualTo(actual.getComAddress()))
            .satisfies(e -> assertThat(e.getSeason1()).as("check season1").isEqualTo(actual.getSeason1()))
            .satisfies(e -> assertThat(e.getSeason2()).as("check season2").isEqualTo(actual.getSeason2()))
            .satisfies(e -> assertThat(e.getSeason3()).as("check season3").isEqualTo(actual.getSeason3()))
            .satisfies(e -> assertThat(e.getSeason4()).as("check season4").isEqualTo(actual.getSeason4()))
            .satisfies(e -> assertThat(e.getSeason5()).as("check season5").isEqualTo(actual.getSeason5()))
            .satisfies(
                e ->
                    assertThat(e.getFloorNumExecutiveFloor())
                        .as("check floorNumExecutiveFloor")
                        .isEqualTo(actual.getFloorNumExecutiveFloor())
            )
            .satisfies(e -> assertThat(e.getCrsResort()).as("check crsResort").isEqualTo(actual.getCrsResort()))
            .satisfies(e -> assertThat(e.getPostCode()).as("check postCode").isEqualTo(actual.getPostCode()))
            .satisfies(
                e ->
                    assertThat(e.getDefaultReservationType())
                        .as("check defaultReservationType")
                        .isEqualTo(actual.getDefaultReservationType())
            )
            .satisfies(e -> assertThat(e.getBlock()).as("check block").isEqualTo(actual.getBlock()))
            .satisfies(e -> assertThat(e.getCurrencySymbol()).as("check currencySymbol").isEqualTo(actual.getCurrencySymbol()))
            .satisfies(e -> assertThat(e.getSourceCommission()).as("check sourceCommission").isEqualTo(actual.getSourceCommission()))
            .satisfies(e -> assertThat(e.getTaCommission()).as("check taCommission").isEqualTo(actual.getTaCommission()))
            .satisfies(e -> assertThat(e.getBaseLanguage()).as("check baseLanguage").isEqualTo(actual.getBaseLanguage()))
            .satisfies(e -> assertThat(e.getFolioLanguage1()).as("check folioLanguage1").isEqualTo(actual.getFolioLanguage1()))
            .satisfies(e -> assertThat(e.getFolioLanguage2()).as("check folioLanguage2").isEqualTo(actual.getFolioLanguage2()))
            .satisfies(e -> assertThat(e.getFolioLanguage3()).as("check folioLanguage3").isEqualTo(actual.getFolioLanguage3()))
            .satisfies(e -> assertThat(e.getFolioLanguage4()).as("check folioLanguage4").isEqualTo(actual.getFolioLanguage4()))
            .satisfies(e -> assertThat(e.getPackageProfit()).as("check packageProfit").isEqualTo(actual.getPackageProfit()))
            .satisfies(e -> assertThat(e.getPackageLoss()).as("check packageLoss").isEqualTo(actual.getPackageLoss()))
            .satisfies(e -> assertThat(e.getDecimalSeparator()).as("check decimalSeparator").isEqualTo(actual.getDecimalSeparator()))
            .satisfies(e -> assertThat(e.getShortDateFormat()).as("check shortDateFormat").isEqualTo(actual.getShortDateFormat()))
            .satisfies(e -> assertThat(e.getLongDateFormat()).as("check longDateFormat").isEqualTo(actual.getLongDateFormat()))
            .satisfies(e -> assertThat(e.getPasserbySource()).as("check passerbySource").isEqualTo(actual.getPasserbySource()))
            .satisfies(e -> assertThat(e.getPasserbyMarket()).as("check passerbyMarket").isEqualTo(actual.getPasserbyMarket()))
            .satisfies(e -> assertThat(e.getArCompany()).as("check arCompany").isEqualTo(actual.getArCompany()))
            .satisfies(e -> assertThat(e.getArAgent()).as("check arAgent").isEqualTo(actual.getArAgent()))
            .satisfies(e -> assertThat(e.getArGroups()).as("check arGroups").isEqualTo(actual.getArGroups()))
            .satisfies(e -> assertThat(e.getArIndividuals()).as("check arIndividuals").isEqualTo(actual.getArIndividuals()))
            .satisfies(e -> assertThat(e.getArAcctNoFormat()).as("check arAcctNoFormat").isEqualTo(actual.getArAcctNoFormat()))
            .satisfies(e -> assertThat(e.getAllowancePeriodAdj()).as("check allowancePeriodAdj").isEqualTo(actual.getAllowancePeriodAdj()))
            .satisfies(e -> assertThat(e.getCurrencyCode()).as("check currencyCode").isEqualTo(actual.getCurrencyCode()))
            .satisfies(e -> assertThat(e.getTurnawayCode()).as("check turnawayCode").isEqualTo(actual.getTurnawayCode()))
            .satisfies(e -> assertThat(e.getSummCurrencyCode()).as("check summCurrencyCode").isEqualTo(actual.getSummCurrencyCode()))
            .satisfies(
                e ->
                    assertThat(e.getDefaultPropertyAddress())
                        .as("check defaultPropertyAddress")
                        .isEqualTo(actual.getDefaultPropertyAddress())
            )
            .satisfies(
                e -> assertThat(e.getDefaultGuestAddress()).as("check defaultGuestAddress").isEqualTo(actual.getDefaultGuestAddress())
            )
            .satisfies(e -> assertThat(e.getLicenseCode()).as("check licenseCode").isEqualTo(actual.getLicenseCode()))
            .satisfies(e -> assertThat(e.getTimeFormat()).as("check timeFormat").isEqualTo(actual.getTimeFormat()))
            .satisfies(e -> assertThat(e.getChainCode()).as("check chainCode").isEqualTo(actual.getChainCode()))
            .satisfies(e -> assertThat(e.getResortType()).as("check resortType").isEqualTo(actual.getResortType()))
            .satisfies(e -> assertThat(e.getHotelType()).as("check hotelType").isEqualTo(actual.getHotelType()))
            .satisfies(e -> assertThat(e.getOwnership()).as("check ownership").isEqualTo(actual.getOwnership()))
            .satisfies(e -> assertThat(e.getArBalTrxCode()).as("check arBalTrxCode").isEqualTo(actual.getArBalTrxCode()))
            .satisfies(e -> assertThat(e.getArCreditTrxCode()).as("check arCreditTrxCode").isEqualTo(actual.getArCreditTrxCode()))
            .satisfies(e -> assertThat(e.getArSettleCode()).as("check arSettleCode").isEqualTo(actual.getArSettleCode()))
            .satisfies(e -> assertThat(e.getCashShiftDrop()).as("check cashShiftDrop").isEqualTo(actual.getCashShiftDrop()))
            .satisfies(e -> assertThat(e.getCheckExgPaidout()).as("check checkExgPaidout").isEqualTo(actual.getCheckExgPaidout()))
            .satisfies(e -> assertThat(e.getCheckShiftDrop()).as("check checkShiftDrop").isEqualTo(actual.getCheckShiftDrop()))
            .satisfies(e -> assertThat(e.getCheckTrxcode()).as("check checkTrxcode").isEqualTo(actual.getCheckTrxcode()))
            .satisfies(e -> assertThat(e.getCurrencyExgPaidout()).as("check currencyExgPaidout").isEqualTo(actual.getCurrencyExgPaidout()))
            .satisfies(e -> assertThat(e.getDepositLedTrxCode()).as("check depositLedTrxCode").isEqualTo(actual.getDepositLedTrxCode()))
            .satisfies(e -> assertThat(e.getFiscalPeriodType()).as("check fiscalPeriodType").isEqualTo(actual.getFiscalPeriodType()))
            .satisfies(
                e ->
                    assertThat(e.getDefaultCommissionPercentage())
                        .as("check defaultCommissionPercentage")
                        .isEqualTo(actual.getDefaultCommissionPercentage())
            )
            .satisfies(e -> assertThat(e.getDefaultPrepaidComm()).as("check defaultPrepaidComm").isEqualTo(actual.getDefaultPrepaidComm()))
            .satisfies(e -> assertThat(e.getDefaultTrxCommCode()).as("check defaultTrxCommCode").isEqualTo(actual.getDefaultTrxCommCode()))
            .satisfies(e -> assertThat(e.getConfigurationMode()).as("check configurationMode").isEqualTo(actual.getConfigurationMode()))
            .satisfies(e -> assertThat(e.getWeekendDays()).as("check weekendDays").isEqualTo(actual.getWeekendDays()))
            .satisfies(
                e -> assertThat(e.getDefaultGroupsRateCode()).as("check defaultGroupsRateCode").isEqualTo(actual.getDefaultGroupsRateCode())
            )
            .satisfies(e -> assertThat(e.getDefaultPostingRoom()).as("check defaultPostingRoom").isEqualTo(actual.getDefaultPostingRoom()))
            .satisfies(e -> assertThat(e.getDfltPkgTranCode()).as("check dfltPkgTranCode").isEqualTo(actual.getDfltPkgTranCode()))
            .satisfies(
                e -> assertThat(e.getDfltTranCodeRateCode()).as("check dfltTranCodeRateCode").isEqualTo(actual.getDfltTranCodeRateCode())
            )
            .satisfies(e -> assertThat(e.getDefaultRateCode()).as("check defaultRateCode").isEqualTo(actual.getDefaultRateCode()))
            .satisfies(e -> assertThat(e.getCroCode()).as("check croCode").isEqualTo(actual.getCroCode()))
            .satisfies(e -> assertThat(e.getFlowCode()).as("check flowCode").isEqualTo(actual.getFlowCode()))
            .satisfies(e -> assertThat(e.getExtPropertyCode()).as("check extPropertyCode").isEqualTo(actual.getExtPropertyCode()))
            .satisfies(e -> assertThat(e.getOpusCurrencyCode()).as("check opusCurrencyCode").isEqualTo(actual.getOpusCurrencyCode()))
            .satisfies(e -> assertThat(e.getDestinationId()).as("check destinationId").isEqualTo(actual.getDestinationId()))
            .satisfies(e -> assertThat(e.getFlags()).as("check flags").isEqualTo(actual.getFlags()))
            .satisfies(e -> assertThat(e.getTouristNumber()).as("check touristNumber").isEqualTo(actual.getTouristNumber()))
            .satisfies(
                e -> assertThat(e.getCateringCurrencyCode()).as("check cateringCurrencyCode").isEqualTo(actual.getCateringCurrencyCode())
            )
            .satisfies(
                e -> assertThat(e.getDefaultRatecodeRack()).as("check defaultRatecodeRack").isEqualTo(actual.getDefaultRatecodeRack())
            )
            .satisfies(e -> assertThat(e.getDefaultRatecodePcr()).as("check defaultRatecodePcr").isEqualTo(actual.getDefaultRatecodePcr()))
            .satisfies(e -> assertThat(e.getFnsTier()).as("check fnsTier").isEqualTo(actual.getFnsTier()))
            .satisfies(e -> assertThat(e.getBrandCode()).as("check brandCode").isEqualTo(actual.getBrandCode()))
            .satisfies(e -> assertThat(e.getWebaddress()).as("check webaddress").isEqualTo(actual.getWebaddress()))
            .satisfies(e -> assertThat(e.getVatId()).as("check vatId").isEqualTo(actual.getVatId()))
            .satisfies(e -> assertThat(e.getStreet()).as("check street").isEqualTo(actual.getStreet()))
            .satisfies(e -> assertThat(e.getHotelFc()).as("check hotelFc").isEqualTo(actual.getHotelFc()))
            .satisfies(e -> assertThat(e.getMeetingFc()).as("check meetingFc").isEqualTo(actual.getMeetingFc()))
            .satisfies(e -> assertThat(e.getArTypewriter()).as("check arTypewriter").isEqualTo(actual.getArTypewriter()))
            .satisfies(e -> assertThat(e.getFileTransferFormat()).as("check fileTransferFormat").isEqualTo(actual.getFileTransferFormat()))
            .satisfies(
                e -> assertThat(e.getConfirmRegcardPrinter()).as("check confirmRegcardPrinter").isEqualTo(actual.getConfirmRegcardPrinter())
            )
            .satisfies(e -> assertThat(e.getDirections()).as("check directions").isEqualTo(actual.getDirections()))
            .satisfies(e -> assertThat(e.getPropinfoUrl()).as("check propinfoUrl").isEqualTo(actual.getPropinfoUrl()))
            .satisfies(e -> assertThat(e.getRoomAmenity()).as("check roomAmenity").isEqualTo(actual.getRoomAmenity()))
            .satisfies(e -> assertThat(e.getShopDescription()).as("check shopDescription").isEqualTo(actual.getShopDescription()))
            .satisfies(e -> assertThat(e.getPropPicUrl()).as("check propPicUrl").isEqualTo(actual.getPropPicUrl()))
            .satisfies(e -> assertThat(e.getPropMapUrl()).as("check propMapUrl").isEqualTo(actual.getPropMapUrl()))
            .satisfies(e -> assertThat(e.getExtExpFileLocation()).as("check extExpFileLocation").isEqualTo(actual.getExtExpFileLocation()))
            .satisfies(e -> assertThat(e.getCurtainColor()).as("check curtainColor").isEqualTo(actual.getCurtainColor()))
            .satisfies(e -> assertThat(e.getCountryCode()).as("check countryCode").isEqualTo(actual.getCountryCode()))
            .satisfies(e -> assertThat(e.getState()).as("check state").isEqualTo(actual.getState()))
            .satisfies(e -> assertThat(e.getDateForAging()).as("check dateForAging").isEqualTo(actual.getDateForAging()))
            .satisfies(e -> assertThat(e.getRegionCode()).as("check regionCode").isEqualTo(actual.getRegionCode()))
            .satisfies(e -> assertThat(e.getCity()).as("check city").isEqualTo(actual.getCity()))
            .satisfies(e -> assertThat(e.getTelephone()).as("check telephone").isEqualTo(actual.getTelephone()))
            .satisfies(e -> assertThat(e.getFax()).as("check fax").isEqualTo(actual.getFax()))
            .satisfies(e -> assertThat(e.getTollfree()).as("check tollfree").isEqualTo(actual.getTollfree()))
            .satisfies(e -> assertThat(e.getDefaultPrinter()).as("check defaultPrinter").isEqualTo(actual.getDefaultPrinter()))
            .satisfies(
                e -> assertThat(e.getVideocheckoutPrinter()).as("check videocheckoutPrinter").isEqualTo(actual.getVideocheckoutPrinter())
            )
            .satisfies(e -> assertThat(e.getCompanyAddressType()).as("check companyAddressType").isEqualTo(actual.getCompanyAddressType()))
            .satisfies(e -> assertThat(e.getCompanyPhoneType()).as("check companyPhoneType").isEqualTo(actual.getCompanyPhoneType()))
            .satisfies(e -> assertThat(e.getDefaultFaxType()).as("check defaultFaxType").isEqualTo(actual.getDefaultFaxType()))
            .satisfies(
                e -> assertThat(e.getDefaultMembershipType()).as("check defaultMembershipType").isEqualTo(actual.getDefaultMembershipType())
            )
            .satisfies(
                e -> assertThat(e.getIndividualAddressType()).as("check individualAddressType").isEqualTo(actual.getIndividualAddressType())
            )
            .satisfies(
                e -> assertThat(e.getIndividualPhoneType()).as("check individualPhoneType").isEqualTo(actual.getIndividualPhoneType())
            )
            .satisfies(e -> assertThat(e.getNotes()).as("check notes").isEqualTo(actual.getNotes()))
            .satisfies(
                e -> assertThat(e.getBlackoutPeriodNotes()).as("check blackoutPeriodNotes").isEqualTo(actual.getBlackoutPeriodNotes())
            )
            .satisfies(e -> assertThat(e.getSglNum()).as("check sglNum").isEqualTo(actual.getSglNum()))
            .satisfies(e -> assertThat(e.getDblNum()).as("check dblNum").isEqualTo(actual.getDblNum()))
            .satisfies(e -> assertThat(e.getTplNum()).as("check tplNum").isEqualTo(actual.getTplNum()))
            .satisfies(e -> assertThat(e.getSuiNum()).as("check suiNum").isEqualTo(actual.getSuiNum()))
            .satisfies(e -> assertThat(e.getAirportDistance()).as("check airportDistance").isEqualTo(actual.getAirportDistance()))
            .satisfies(e -> assertThat(e.getAirportTime()).as("check airportTime").isEqualTo(actual.getAirportTime()))
            .satisfies(e -> assertThat(e.getBrArea()).as("check brArea").isEqualTo(actual.getBrArea()))
            .satisfies(e -> assertThat(e.getName()).as("check name").isEqualTo(actual.getName()))
            .satisfies(e -> assertThat(e.getLegalOwner()).as("check legalOwner").isEqualTo(actual.getLegalOwner()))
            .satisfies(e -> assertThat(e.getHotelId()).as("check hotelId").isEqualTo(actual.getHotelId()))
            .satisfies(e -> assertThat(e.getFaxNoFormat()).as("check faxNoFormat").isEqualTo(actual.getFaxNoFormat()))
            .satisfies(e -> assertThat(e.getTelephoneNoFormat()).as("check telephoneNoFormat").isEqualTo(actual.getTelephoneNoFormat()))
            .satisfies(
                e -> assertThat(e.getLocalCurrencyFormat()).as("check localCurrencyFormat").isEqualTo(actual.getLocalCurrencyFormat())
            )
            .satisfies(e -> assertThat(e.getDutyManagerPager()).as("check dutyManagerPager").isEqualTo(actual.getDutyManagerPager()))
            .satisfies(
                e ->
                    assertThat(e.getDefaultRegistrationCard())
                        .as("check defaultRegistrationCard")
                        .isEqualTo(actual.getDefaultRegistrationCard())
            )
            .satisfies(
                e -> assertThat(e.getNightAuditCashierId()).as("check nightAuditCashierId").isEqualTo(actual.getNightAuditCashierId())
            )
            .satisfies(e -> assertThat(e.getHotelCode()).as("check hotelCode").isEqualTo(actual.getHotelCode()))
            .satisfies(e -> assertThat(e.getPath()).as("check path").isEqualTo(actual.getPath()))
            .satisfies(e -> assertThat(e.getTimezoneRegion()).as("check timezoneRegion").isEqualTo(actual.getTimezoneRegion()))
            .satisfies(
                e ->
                    assertThat(e.getCateringCurrencyFormat())
                        .as("check cateringCurrencyFormat")
                        .isEqualTo(actual.getCateringCurrencyFormat())
            )
            .satisfies(e -> assertThat(e.getExpHotelCode()).as("check expHotelCode").isEqualTo(actual.getExpHotelCode()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertResortUpdatableRelationshipsEquals(Resort expected, Resort actual) {}
}
