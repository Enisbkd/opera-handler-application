package com.sbm.mc.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class ResortTestSamples {

    private static final Random random = new Random();
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Resort getResortSample1() {
        return new Resort()
            .id("id1")
            .resort("resort1")
            .keepAvailability(1)
            .budgetMonth(1)
            .saveProfiles(1)
            .longStayControl(1)
            .creditLimit(1)
            .numberRooms(1)
            .numberFloors(1)
            .numberBeds(1)
            .rhythmSheets(1)
            .rhythmTowels(1)
            .warningAmount(1)
            .decimalPlaces(1)
            .font(1)
            .copies(1)
            .defaultFolioStyle(1)
            .individualRoomWarning(1)
            .groupRoomWarning(1)
            .agingLevel1(1)
            .agingLevel2(1)
            .agingLevel3(1)
            .agingLevel4(1)
            .agingLevel5(1)
            .zeroInvPurDays(1)
            .minDaysBet2ReminderLetter(1)
            .insertUser(1)
            .updateUser(1)
            .currencyDecimals(1)
            .nameIdLink(1)
            .sglRate1(1)
            .sglRate2(1)
            .dblRate1(1)
            .dblRate2(1)
            .tplRate1(1)
            .tplRate2(1)
            .suiRate1(1)
            .suiRate2(1)
            .meetSpace(1)
            .imgHotelId(1)
            .imgDirectionId(1)
            .imgMapId(1)
            .scriptId(1)
            .comNameXrefId(1)
            .pathId(1)
            .xresortNumber(1)
            .maxCreditDays(1)
            .currencyDivisor(1)
            .latitude(1)
            .longitude(1)
            .qtySingleRooms(1)
            .qtyDoubleRooms(1)
            .qtyTwinRooms(1)
            .qtySuites(1)
            .qtyGuestRoomFloors(1)
            .qtyGuestElevators(1)
            .qtyNonSmokingRooms(1)
            .qtyConnectingRooms(1)
            .qtyHandicappedRooms(1)
            .qtyFamilyRooms(1)
            .maxAdultsFamilyRoom(1)
            .maxChildrenFamilyRoom(1)
            .restaurant(1)
            .meetRooms(1)
            .totRooms(1)
            .brSeats(1)
            .meetSeats(1)
            .maxNoNights(1)
            .awardsTimeout(1)
            .guestLookupTimeout(1)
            .wakeUpDelay(1)
            .maxOccupancy(1)
            .inactiveDaysForGuestProfil(1)
            .perReservationRoomLimit(1)
            .licRoomInfo("licRoomInfo1")
            .thousandSeparator("thousandSeparator1")
            .dateSeparator("dateSeparator1")
            .arAcctNoMandYn("arAcctNoMandYn1")
            .exchangePostingType("exchangePostingType1")
            .inventoryYn("inventoryYn1")
            .allowLoginYn("allowLoginYn1")
            .accessCode("accessCode1")
            .disableLoginYn("disableLoginYn1")
            .intTaxIncludedYn("intTaxIncludedYn1")
            .downloadRestYn("downloadRestYn1")
            .translateMulticharYn("translateMulticharYn1")
            .externalScYn("externalScYn1")
            .sendLeadAsBookingYn("sendLeadAsBookingYn1")
            .mbsSupportedYn("mbsSupportedYn1")
            .quotedCurrency("quotedCurrency1")
            .comMethod("comMethod1")
            .email("email1")
            .genmgr("genmgr1")
            .dirsales("dirsales1")
            .leadsend("leadsend1")
            .airport("airport1")
            .comAddress("comAddress1")
            .season1("season11")
            .season2("season21")
            .season3("season31")
            .season4("season41")
            .season5("season51")
            .floorNumExecutiveFloor("floorNumExecutiveFloor1")
            .crsResort("crsResort1")
            .postCode("postCode1")
            .defaultReservationType("defaultReservationType1")
            .block("block1")
            .currencySymbol("currencySymbol1")
            .sourceCommission("sourceCommission1")
            .taCommission("taCommission1")
            .baseLanguage("baseLanguage1")
            .folioLanguage1("folioLanguage11")
            .folioLanguage2("folioLanguage21")
            .folioLanguage3("folioLanguage31")
            .folioLanguage4("folioLanguage41")
            .packageProfit("packageProfit1")
            .packageLoss("packageLoss1")
            .decimalSeparator("decimalSeparator1")
            .shortDateFormat("shortDateFormat1")
            .longDateFormat("longDateFormat1")
            .passerbySource("passerbySource1")
            .passerbyMarket("passerbyMarket1")
            .arCompany("arCompany1")
            .arAgent("arAgent1")
            .arGroups("arGroups1")
            .arIndividuals("arIndividuals1")
            .arAcctNoFormat("arAcctNoFormat1")
            .allowancePeriodAdj("allowancePeriodAdj1")
            .currencyCode("currencyCode1")
            .turnawayCode("turnawayCode1")
            .summCurrencyCode("summCurrencyCode1")
            .defaultPropertyAddress("defaultPropertyAddress1")
            .defaultGuestAddress("defaultGuestAddress1")
            .licenseCode("licenseCode1")
            .timeFormat("timeFormat1")
            .chainCode("chainCode1")
            .resortType("resortType1")
            .hotelType("hotelType1")
            .ownership("ownership1")
            .arBalTrxCode("arBalTrxCode1")
            .arCreditTrxCode("arCreditTrxCode1")
            .arSettleCode("arSettleCode1")
            .cashShiftDrop("cashShiftDrop1")
            .checkExgPaidout("checkExgPaidout1")
            .checkShiftDrop("checkShiftDrop1")
            .checkTrxcode("checkTrxcode1")
            .currencyExgPaidout("currencyExgPaidout1")
            .depositLedTrxCode("depositLedTrxCode1")
            .fiscalPeriodType("fiscalPeriodType1")
            .defaultCommissionPercentage("defaultCommissionPercentage1")
            .defaultPrepaidComm("defaultPrepaidComm1")
            .defaultTrxCommCode("defaultTrxCommCode1")
            .configurationMode("configurationMode1")
            .weekendDays("weekendDays1")
            .defaultGroupsRateCode("defaultGroupsRateCode1")
            .defaultPostingRoom("defaultPostingRoom1")
            .dfltPkgTranCode("dfltPkgTranCode1")
            .dfltTranCodeRateCode("dfltTranCodeRateCode1")
            .defaultRateCode("defaultRateCode1")
            .croCode("croCode1")
            .flowCode("flowCode1")
            .extPropertyCode("extPropertyCode1")
            .opusCurrencyCode("opusCurrencyCode1")
            .destinationId("destinationId1")
            .flags("flags1")
            .touristNumber("touristNumber1")
            .cateringCurrencyCode("cateringCurrencyCode1")
            .defaultRatecodeRack("defaultRatecodeRack1")
            .defaultRatecodePcr("defaultRatecodePcr1")
            .fnsTier("fnsTier1")
            .brandCode("brandCode1")
            .webaddress("webaddress1")
            .vatId("vatId1")
            .street("street1")
            .hotelFc("hotelFc1")
            .meetingFc("meetingFc1")
            .arTypewriter("arTypewriter1")
            .fileTransferFormat("fileTransferFormat1")
            .confirmRegcardPrinter("confirmRegcardPrinter1")
            .directions("directions1")
            .propinfoUrl("propinfoUrl1")
            .roomAmenity("roomAmenity1")
            .shopDescription("shopDescription1")
            .propPicUrl("propPicUrl1")
            .propMapUrl("propMapUrl1")
            .extExpFileLocation("extExpFileLocation1")
            .curtainColor("curtainColor1")
            .countryCode("countryCode1")
            .state("state1")
            .dateForAging("dateForAging1")
            .regionCode("regionCode1")
            .city("city1")
            .telephone("telephone1")
            .fax("fax1")
            .tollfree("tollfree1")
            .defaultPrinter("defaultPrinter1")
            .videocheckoutPrinter("videocheckoutPrinter1")
            .companyAddressType("companyAddressType1")
            .companyPhoneType("companyPhoneType1")
            .defaultFaxType("defaultFaxType1")
            .defaultMembershipType("defaultMembershipType1")
            .individualAddressType("individualAddressType1")
            .individualPhoneType("individualPhoneType1")
            .notes("notes1")
            .blackoutPeriodNotes("blackoutPeriodNotes1")
            .sglNum("sglNum1")
            .dblNum("dblNum1")
            .tplNum("tplNum1")
            .suiNum("suiNum1")
            .airportDistance("airportDistance1")
            .airportTime("airportTime1")
            .brArea("brArea1")
            .name("name1")
            .legalOwner("legalOwner1")
            .hotelId("hotelId1")
            .faxNoFormat("faxNoFormat1")
            .telephoneNoFormat("telephoneNoFormat1")
            .localCurrencyFormat("localCurrencyFormat1")
            .dutyManagerPager("dutyManagerPager1")
            .defaultRegistrationCard("defaultRegistrationCard1")
            .nightAuditCashierId("nightAuditCashierId1")
            .hotelCode("hotelCode1")
            .path("path1")
            .timezoneRegion("timezoneRegion1")
            .cateringCurrencyFormat("cateringCurrencyFormat1")
            .expHotelCode("expHotelCode1");
    }

    public static Resort getResortSample2() {
        return new Resort()
            .id("id2")
            .resort("resort2")
            .keepAvailability(2)
            .budgetMonth(2)
            .saveProfiles(2)
            .longStayControl(2)
            .creditLimit(2)
            .numberRooms(2)
            .numberFloors(2)
            .numberBeds(2)
            .rhythmSheets(2)
            .rhythmTowels(2)
            .warningAmount(2)
            .decimalPlaces(2)
            .font(2)
            .copies(2)
            .defaultFolioStyle(2)
            .individualRoomWarning(2)
            .groupRoomWarning(2)
            .agingLevel1(2)
            .agingLevel2(2)
            .agingLevel3(2)
            .agingLevel4(2)
            .agingLevel5(2)
            .zeroInvPurDays(2)
            .minDaysBet2ReminderLetter(2)
            .insertUser(2)
            .updateUser(2)
            .currencyDecimals(2)
            .nameIdLink(2)
            .sglRate1(2)
            .sglRate2(2)
            .dblRate1(2)
            .dblRate2(2)
            .tplRate1(2)
            .tplRate2(2)
            .suiRate1(2)
            .suiRate2(2)
            .meetSpace(2)
            .imgHotelId(2)
            .imgDirectionId(2)
            .imgMapId(2)
            .scriptId(2)
            .comNameXrefId(2)
            .pathId(2)
            .xresortNumber(2)
            .maxCreditDays(2)
            .currencyDivisor(2)
            .latitude(2)
            .longitude(2)
            .qtySingleRooms(2)
            .qtyDoubleRooms(2)
            .qtyTwinRooms(2)
            .qtySuites(2)
            .qtyGuestRoomFloors(2)
            .qtyGuestElevators(2)
            .qtyNonSmokingRooms(2)
            .qtyConnectingRooms(2)
            .qtyHandicappedRooms(2)
            .qtyFamilyRooms(2)
            .maxAdultsFamilyRoom(2)
            .maxChildrenFamilyRoom(2)
            .restaurant(2)
            .meetRooms(2)
            .totRooms(2)
            .brSeats(2)
            .meetSeats(2)
            .maxNoNights(2)
            .awardsTimeout(2)
            .guestLookupTimeout(2)
            .wakeUpDelay(2)
            .maxOccupancy(2)
            .inactiveDaysForGuestProfil(2)
            .perReservationRoomLimit(2)
            .licRoomInfo("licRoomInfo2")
            .thousandSeparator("thousandSeparator2")
            .dateSeparator("dateSeparator2")
            .arAcctNoMandYn("arAcctNoMandYn2")
            .exchangePostingType("exchangePostingType2")
            .inventoryYn("inventoryYn2")
            .allowLoginYn("allowLoginYn2")
            .accessCode("accessCode2")
            .disableLoginYn("disableLoginYn2")
            .intTaxIncludedYn("intTaxIncludedYn2")
            .downloadRestYn("downloadRestYn2")
            .translateMulticharYn("translateMulticharYn2")
            .externalScYn("externalScYn2")
            .sendLeadAsBookingYn("sendLeadAsBookingYn2")
            .mbsSupportedYn("mbsSupportedYn2")
            .quotedCurrency("quotedCurrency2")
            .comMethod("comMethod2")
            .email("email2")
            .genmgr("genmgr2")
            .dirsales("dirsales2")
            .leadsend("leadsend2")
            .airport("airport2")
            .comAddress("comAddress2")
            .season1("season12")
            .season2("season22")
            .season3("season32")
            .season4("season42")
            .season5("season52")
            .floorNumExecutiveFloor("floorNumExecutiveFloor2")
            .crsResort("crsResort2")
            .postCode("postCode2")
            .defaultReservationType("defaultReservationType2")
            .block("block2")
            .currencySymbol("currencySymbol2")
            .sourceCommission("sourceCommission2")
            .taCommission("taCommission2")
            .baseLanguage("baseLanguage2")
            .folioLanguage1("folioLanguage12")
            .folioLanguage2("folioLanguage22")
            .folioLanguage3("folioLanguage32")
            .folioLanguage4("folioLanguage42")
            .packageProfit("packageProfit2")
            .packageLoss("packageLoss2")
            .decimalSeparator("decimalSeparator2")
            .shortDateFormat("shortDateFormat2")
            .longDateFormat("longDateFormat2")
            .passerbySource("passerbySource2")
            .passerbyMarket("passerbyMarket2")
            .arCompany("arCompany2")
            .arAgent("arAgent2")
            .arGroups("arGroups2")
            .arIndividuals("arIndividuals2")
            .arAcctNoFormat("arAcctNoFormat2")
            .allowancePeriodAdj("allowancePeriodAdj2")
            .currencyCode("currencyCode2")
            .turnawayCode("turnawayCode2")
            .summCurrencyCode("summCurrencyCode2")
            .defaultPropertyAddress("defaultPropertyAddress2")
            .defaultGuestAddress("defaultGuestAddress2")
            .licenseCode("licenseCode2")
            .timeFormat("timeFormat2")
            .chainCode("chainCode2")
            .resortType("resortType2")
            .hotelType("hotelType2")
            .ownership("ownership2")
            .arBalTrxCode("arBalTrxCode2")
            .arCreditTrxCode("arCreditTrxCode2")
            .arSettleCode("arSettleCode2")
            .cashShiftDrop("cashShiftDrop2")
            .checkExgPaidout("checkExgPaidout2")
            .checkShiftDrop("checkShiftDrop2")
            .checkTrxcode("checkTrxcode2")
            .currencyExgPaidout("currencyExgPaidout2")
            .depositLedTrxCode("depositLedTrxCode2")
            .fiscalPeriodType("fiscalPeriodType2")
            .defaultCommissionPercentage("defaultCommissionPercentage2")
            .defaultPrepaidComm("defaultPrepaidComm2")
            .defaultTrxCommCode("defaultTrxCommCode2")
            .configurationMode("configurationMode2")
            .weekendDays("weekendDays2")
            .defaultGroupsRateCode("defaultGroupsRateCode2")
            .defaultPostingRoom("defaultPostingRoom2")
            .dfltPkgTranCode("dfltPkgTranCode2")
            .dfltTranCodeRateCode("dfltTranCodeRateCode2")
            .defaultRateCode("defaultRateCode2")
            .croCode("croCode2")
            .flowCode("flowCode2")
            .extPropertyCode("extPropertyCode2")
            .opusCurrencyCode("opusCurrencyCode2")
            .destinationId("destinationId2")
            .flags("flags2")
            .touristNumber("touristNumber2")
            .cateringCurrencyCode("cateringCurrencyCode2")
            .defaultRatecodeRack("defaultRatecodeRack2")
            .defaultRatecodePcr("defaultRatecodePcr2")
            .fnsTier("fnsTier2")
            .brandCode("brandCode2")
            .webaddress("webaddress2")
            .vatId("vatId2")
            .street("street2")
            .hotelFc("hotelFc2")
            .meetingFc("meetingFc2")
            .arTypewriter("arTypewriter2")
            .fileTransferFormat("fileTransferFormat2")
            .confirmRegcardPrinter("confirmRegcardPrinter2")
            .directions("directions2")
            .propinfoUrl("propinfoUrl2")
            .roomAmenity("roomAmenity2")
            .shopDescription("shopDescription2")
            .propPicUrl("propPicUrl2")
            .propMapUrl("propMapUrl2")
            .extExpFileLocation("extExpFileLocation2")
            .curtainColor("curtainColor2")
            .countryCode("countryCode2")
            .state("state2")
            .dateForAging("dateForAging2")
            .regionCode("regionCode2")
            .city("city2")
            .telephone("telephone2")
            .fax("fax2")
            .tollfree("tollfree2")
            .defaultPrinter("defaultPrinter2")
            .videocheckoutPrinter("videocheckoutPrinter2")
            .companyAddressType("companyAddressType2")
            .companyPhoneType("companyPhoneType2")
            .defaultFaxType("defaultFaxType2")
            .defaultMembershipType("defaultMembershipType2")
            .individualAddressType("individualAddressType2")
            .individualPhoneType("individualPhoneType2")
            .notes("notes2")
            .blackoutPeriodNotes("blackoutPeriodNotes2")
            .sglNum("sglNum2")
            .dblNum("dblNum2")
            .tplNum("tplNum2")
            .suiNum("suiNum2")
            .airportDistance("airportDistance2")
            .airportTime("airportTime2")
            .brArea("brArea2")
            .name("name2")
            .legalOwner("legalOwner2")
            .hotelId("hotelId2")
            .faxNoFormat("faxNoFormat2")
            .telephoneNoFormat("telephoneNoFormat2")
            .localCurrencyFormat("localCurrencyFormat2")
            .dutyManagerPager("dutyManagerPager2")
            .defaultRegistrationCard("defaultRegistrationCard2")
            .nightAuditCashierId("nightAuditCashierId2")
            .hotelCode("hotelCode2")
            .path("path2")
            .timezoneRegion("timezoneRegion2")
            .cateringCurrencyFormat("cateringCurrencyFormat2")
            .expHotelCode("expHotelCode2");
    }

    public static Resort getResortRandomSampleGenerator() {
        return new Resort()
            .id(UUID.randomUUID().toString())
            .resort(UUID.randomUUID().toString())
            .keepAvailability(intCount.incrementAndGet())
            .budgetMonth(intCount.incrementAndGet())
            .saveProfiles(intCount.incrementAndGet())
            .longStayControl(intCount.incrementAndGet())
            .creditLimit(intCount.incrementAndGet())
            .numberRooms(intCount.incrementAndGet())
            .numberFloors(intCount.incrementAndGet())
            .numberBeds(intCount.incrementAndGet())
            .rhythmSheets(intCount.incrementAndGet())
            .rhythmTowels(intCount.incrementAndGet())
            .warningAmount(intCount.incrementAndGet())
            .decimalPlaces(intCount.incrementAndGet())
            .font(intCount.incrementAndGet())
            .copies(intCount.incrementAndGet())
            .defaultFolioStyle(intCount.incrementAndGet())
            .individualRoomWarning(intCount.incrementAndGet())
            .groupRoomWarning(intCount.incrementAndGet())
            .agingLevel1(intCount.incrementAndGet())
            .agingLevel2(intCount.incrementAndGet())
            .agingLevel3(intCount.incrementAndGet())
            .agingLevel4(intCount.incrementAndGet())
            .agingLevel5(intCount.incrementAndGet())
            .zeroInvPurDays(intCount.incrementAndGet())
            .minDaysBet2ReminderLetter(intCount.incrementAndGet())
            .insertUser(intCount.incrementAndGet())
            .updateUser(intCount.incrementAndGet())
            .currencyDecimals(intCount.incrementAndGet())
            .nameIdLink(intCount.incrementAndGet())
            .sglRate1(intCount.incrementAndGet())
            .sglRate2(intCount.incrementAndGet())
            .dblRate1(intCount.incrementAndGet())
            .dblRate2(intCount.incrementAndGet())
            .tplRate1(intCount.incrementAndGet())
            .tplRate2(intCount.incrementAndGet())
            .suiRate1(intCount.incrementAndGet())
            .suiRate2(intCount.incrementAndGet())
            .meetSpace(intCount.incrementAndGet())
            .imgHotelId(intCount.incrementAndGet())
            .imgDirectionId(intCount.incrementAndGet())
            .imgMapId(intCount.incrementAndGet())
            .scriptId(intCount.incrementAndGet())
            .comNameXrefId(intCount.incrementAndGet())
            .pathId(intCount.incrementAndGet())
            .xresortNumber(intCount.incrementAndGet())
            .maxCreditDays(intCount.incrementAndGet())
            .currencyDivisor(intCount.incrementAndGet())
            .latitude(intCount.incrementAndGet())
            .longitude(intCount.incrementAndGet())
            .qtySingleRooms(intCount.incrementAndGet())
            .qtyDoubleRooms(intCount.incrementAndGet())
            .qtyTwinRooms(intCount.incrementAndGet())
            .qtySuites(intCount.incrementAndGet())
            .qtyGuestRoomFloors(intCount.incrementAndGet())
            .qtyGuestElevators(intCount.incrementAndGet())
            .qtyNonSmokingRooms(intCount.incrementAndGet())
            .qtyConnectingRooms(intCount.incrementAndGet())
            .qtyHandicappedRooms(intCount.incrementAndGet())
            .qtyFamilyRooms(intCount.incrementAndGet())
            .maxAdultsFamilyRoom(intCount.incrementAndGet())
            .maxChildrenFamilyRoom(intCount.incrementAndGet())
            .restaurant(intCount.incrementAndGet())
            .meetRooms(intCount.incrementAndGet())
            .totRooms(intCount.incrementAndGet())
            .brSeats(intCount.incrementAndGet())
            .meetSeats(intCount.incrementAndGet())
            .maxNoNights(intCount.incrementAndGet())
            .awardsTimeout(intCount.incrementAndGet())
            .guestLookupTimeout(intCount.incrementAndGet())
            .wakeUpDelay(intCount.incrementAndGet())
            .maxOccupancy(intCount.incrementAndGet())
            .inactiveDaysForGuestProfil(intCount.incrementAndGet())
            .perReservationRoomLimit(intCount.incrementAndGet())
            .licRoomInfo(UUID.randomUUID().toString())
            .thousandSeparator(UUID.randomUUID().toString())
            .dateSeparator(UUID.randomUUID().toString())
            .arAcctNoMandYn(UUID.randomUUID().toString())
            .exchangePostingType(UUID.randomUUID().toString())
            .inventoryYn(UUID.randomUUID().toString())
            .allowLoginYn(UUID.randomUUID().toString())
            .accessCode(UUID.randomUUID().toString())
            .disableLoginYn(UUID.randomUUID().toString())
            .intTaxIncludedYn(UUID.randomUUID().toString())
            .downloadRestYn(UUID.randomUUID().toString())
            .translateMulticharYn(UUID.randomUUID().toString())
            .externalScYn(UUID.randomUUID().toString())
            .sendLeadAsBookingYn(UUID.randomUUID().toString())
            .mbsSupportedYn(UUID.randomUUID().toString())
            .quotedCurrency(UUID.randomUUID().toString())
            .comMethod(UUID.randomUUID().toString())
            .email(UUID.randomUUID().toString())
            .genmgr(UUID.randomUUID().toString())
            .dirsales(UUID.randomUUID().toString())
            .leadsend(UUID.randomUUID().toString())
            .airport(UUID.randomUUID().toString())
            .comAddress(UUID.randomUUID().toString())
            .season1(UUID.randomUUID().toString())
            .season2(UUID.randomUUID().toString())
            .season3(UUID.randomUUID().toString())
            .season4(UUID.randomUUID().toString())
            .season5(UUID.randomUUID().toString())
            .floorNumExecutiveFloor(UUID.randomUUID().toString())
            .crsResort(UUID.randomUUID().toString())
            .postCode(UUID.randomUUID().toString())
            .defaultReservationType(UUID.randomUUID().toString())
            .block(UUID.randomUUID().toString())
            .currencySymbol(UUID.randomUUID().toString())
            .sourceCommission(UUID.randomUUID().toString())
            .taCommission(UUID.randomUUID().toString())
            .baseLanguage(UUID.randomUUID().toString())
            .folioLanguage1(UUID.randomUUID().toString())
            .folioLanguage2(UUID.randomUUID().toString())
            .folioLanguage3(UUID.randomUUID().toString())
            .folioLanguage4(UUID.randomUUID().toString())
            .packageProfit(UUID.randomUUID().toString())
            .packageLoss(UUID.randomUUID().toString())
            .decimalSeparator(UUID.randomUUID().toString())
            .shortDateFormat(UUID.randomUUID().toString())
            .longDateFormat(UUID.randomUUID().toString())
            .passerbySource(UUID.randomUUID().toString())
            .passerbyMarket(UUID.randomUUID().toString())
            .arCompany(UUID.randomUUID().toString())
            .arAgent(UUID.randomUUID().toString())
            .arGroups(UUID.randomUUID().toString())
            .arIndividuals(UUID.randomUUID().toString())
            .arAcctNoFormat(UUID.randomUUID().toString())
            .allowancePeriodAdj(UUID.randomUUID().toString())
            .currencyCode(UUID.randomUUID().toString())
            .turnawayCode(UUID.randomUUID().toString())
            .summCurrencyCode(UUID.randomUUID().toString())
            .defaultPropertyAddress(UUID.randomUUID().toString())
            .defaultGuestAddress(UUID.randomUUID().toString())
            .licenseCode(UUID.randomUUID().toString())
            .timeFormat(UUID.randomUUID().toString())
            .chainCode(UUID.randomUUID().toString())
            .resortType(UUID.randomUUID().toString())
            .hotelType(UUID.randomUUID().toString())
            .ownership(UUID.randomUUID().toString())
            .arBalTrxCode(UUID.randomUUID().toString())
            .arCreditTrxCode(UUID.randomUUID().toString())
            .arSettleCode(UUID.randomUUID().toString())
            .cashShiftDrop(UUID.randomUUID().toString())
            .checkExgPaidout(UUID.randomUUID().toString())
            .checkShiftDrop(UUID.randomUUID().toString())
            .checkTrxcode(UUID.randomUUID().toString())
            .currencyExgPaidout(UUID.randomUUID().toString())
            .depositLedTrxCode(UUID.randomUUID().toString())
            .fiscalPeriodType(UUID.randomUUID().toString())
            .defaultCommissionPercentage(UUID.randomUUID().toString())
            .defaultPrepaidComm(UUID.randomUUID().toString())
            .defaultTrxCommCode(UUID.randomUUID().toString())
            .configurationMode(UUID.randomUUID().toString())
            .weekendDays(UUID.randomUUID().toString())
            .defaultGroupsRateCode(UUID.randomUUID().toString())
            .defaultPostingRoom(UUID.randomUUID().toString())
            .dfltPkgTranCode(UUID.randomUUID().toString())
            .dfltTranCodeRateCode(UUID.randomUUID().toString())
            .defaultRateCode(UUID.randomUUID().toString())
            .croCode(UUID.randomUUID().toString())
            .flowCode(UUID.randomUUID().toString())
            .extPropertyCode(UUID.randomUUID().toString())
            .opusCurrencyCode(UUID.randomUUID().toString())
            .destinationId(UUID.randomUUID().toString())
            .flags(UUID.randomUUID().toString())
            .touristNumber(UUID.randomUUID().toString())
            .cateringCurrencyCode(UUID.randomUUID().toString())
            .defaultRatecodeRack(UUID.randomUUID().toString())
            .defaultRatecodePcr(UUID.randomUUID().toString())
            .fnsTier(UUID.randomUUID().toString())
            .brandCode(UUID.randomUUID().toString())
            .webaddress(UUID.randomUUID().toString())
            .vatId(UUID.randomUUID().toString())
            .street(UUID.randomUUID().toString())
            .hotelFc(UUID.randomUUID().toString())
            .meetingFc(UUID.randomUUID().toString())
            .arTypewriter(UUID.randomUUID().toString())
            .fileTransferFormat(UUID.randomUUID().toString())
            .confirmRegcardPrinter(UUID.randomUUID().toString())
            .directions(UUID.randomUUID().toString())
            .propinfoUrl(UUID.randomUUID().toString())
            .roomAmenity(UUID.randomUUID().toString())
            .shopDescription(UUID.randomUUID().toString())
            .propPicUrl(UUID.randomUUID().toString())
            .propMapUrl(UUID.randomUUID().toString())
            .extExpFileLocation(UUID.randomUUID().toString())
            .curtainColor(UUID.randomUUID().toString())
            .countryCode(UUID.randomUUID().toString())
            .state(UUID.randomUUID().toString())
            .dateForAging(UUID.randomUUID().toString())
            .regionCode(UUID.randomUUID().toString())
            .city(UUID.randomUUID().toString())
            .telephone(UUID.randomUUID().toString())
            .fax(UUID.randomUUID().toString())
            .tollfree(UUID.randomUUID().toString())
            .defaultPrinter(UUID.randomUUID().toString())
            .videocheckoutPrinter(UUID.randomUUID().toString())
            .companyAddressType(UUID.randomUUID().toString())
            .companyPhoneType(UUID.randomUUID().toString())
            .defaultFaxType(UUID.randomUUID().toString())
            .defaultMembershipType(UUID.randomUUID().toString())
            .individualAddressType(UUID.randomUUID().toString())
            .individualPhoneType(UUID.randomUUID().toString())
            .notes(UUID.randomUUID().toString())
            .blackoutPeriodNotes(UUID.randomUUID().toString())
            .sglNum(UUID.randomUUID().toString())
            .dblNum(UUID.randomUUID().toString())
            .tplNum(UUID.randomUUID().toString())
            .suiNum(UUID.randomUUID().toString())
            .airportDistance(UUID.randomUUID().toString())
            .airportTime(UUID.randomUUID().toString())
            .brArea(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .legalOwner(UUID.randomUUID().toString())
            .hotelId(UUID.randomUUID().toString())
            .faxNoFormat(UUID.randomUUID().toString())
            .telephoneNoFormat(UUID.randomUUID().toString())
            .localCurrencyFormat(UUID.randomUUID().toString())
            .dutyManagerPager(UUID.randomUUID().toString())
            .defaultRegistrationCard(UUID.randomUUID().toString())
            .nightAuditCashierId(UUID.randomUUID().toString())
            .hotelCode(UUID.randomUUID().toString())
            .path(UUID.randomUUID().toString())
            .timezoneRegion(UUID.randomUUID().toString())
            .cateringCurrencyFormat(UUID.randomUUID().toString())
            .expHotelCode(UUID.randomUUID().toString());
    }
}
