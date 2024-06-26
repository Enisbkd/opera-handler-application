package com.sbm.mc.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ReservationStatDailyTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static ReservationStatDaily getReservationStatDailySample1() {
        return new ReservationStatDaily()
            .id(1L)
            .resort("resort1")
            .nameId(1)
            .rateCode("rateCode1")
            .sourceCode("sourceCode1")
            .marketCode("marketCode1")
            .roomCategory("roomCategory1")
            .companyId(1)
            .agentId(1)
            .groupId(1)
            .sourceProfId(1)
            .resvStatus("resvStatus1")
            .resvNameId(1)
            .quantity(1)
            .physicalQuantity(1)
            .dueOutYn("dueOutYn1")
            .roomResvStatus("roomResvStatus1")
            .adults(1)
            .children(1)
            .roomAdults(1)
            .roomChildren(1)
            .primaryYn(1)
            .allotmentHeaderId(1)
            .walkinYn("walkinYn1")
            .roomClass("roomClass1")
            .vipStatus("vipStatus1")
            .room("room1")
            .membershipId(1)
            .contactId(1)
            .rateCategory("rateCategory1")
            .marketMainGroup("marketMainGroup1")
            .sourceMainGroup("sourceMainGroup1")
            .channel("channel1")
            .country("country1")
            .regionCode("regionCode1")
            .nationality("nationality1")
            .psuedoRoomYn("psuedoRoomYn1")
            .adultsTaxFree(1)
            .childrenTaxFree(1)
            .stayRooms(1)
            .stayPersons(1)
            .stayAdults(1)
            .stayChildren(1)
            .arrRooms(1)
            .arrPersons(1)
            .depRooms(1)
            .depPersons(1)
            .dayUseRooms(1)
            .dayUsePersons(1)
            .cancelledRooms(1)
            .cancelledPersons(1)
            .noShowRooms(1)
            .noShowPersons(1)
            .singleOccupancy(1)
            .multipleOccupancy(1)
            .cribs(1)
            .extraBeds(1)
            .countryMainGroup("countryMainGroup1")
            .state("state1")
            .fiscalRegionCode("fiscalRegionCode1")
            .nights(1)
            .noOfStays(1)
            .reservationNights(1)
            .reservationArrivals(1)
            .reservationNoOfStays(1)
            .dayUseReservations(1)
            .cancelledReservations(1)
            .noShowReservations(1)
            .city("city1")
            .zipCode("zipCode1")
            .district("district1")
            .cashRoomNts(1)
            .compRoomNts(1)
            .resInsertSource("resInsertSource1")
            .resInsertSourceType("resInsertSourceType1")
            .children1(1)
            .children2(1)
            .children3(1)
            .children4(1)
            .children5(1)
            .ffMembershipType("ffMembershipType1")
            .fgMembershipType("fgMembershipType1")
            .promotionCode("promotionCode1")
            .ownerFfFlag("ownerFfFlag1")
            .ownerRentalFlag("ownerRentalFlag1")
            .centralCurrencyCode("centralCurrencyCode1")
            .bookedRoomCategory("bookedRoomCategory1")
            .parentCompanyId(1)
            .houseUseYn("houseUseYn1")
            .complimentaryYn("complimentaryYn1")
            .biResvNameId(1)
            .contactYn("contactYn1")
            .extendedStayTier(1)
            .guid("guid1");
    }

    public static ReservationStatDaily getReservationStatDailySample2() {
        return new ReservationStatDaily()
            .id(2L)
            .resort("resort2")
            .nameId(2)
            .rateCode("rateCode2")
            .sourceCode("sourceCode2")
            .marketCode("marketCode2")
            .roomCategory("roomCategory2")
            .companyId(2)
            .agentId(2)
            .groupId(2)
            .sourceProfId(2)
            .resvStatus("resvStatus2")
            .resvNameId(2)
            .quantity(2)
            .physicalQuantity(2)
            .dueOutYn("dueOutYn2")
            .roomResvStatus("roomResvStatus2")
            .adults(2)
            .children(2)
            .roomAdults(2)
            .roomChildren(2)
            .primaryYn(2)
            .allotmentHeaderId(2)
            .walkinYn("walkinYn2")
            .roomClass("roomClass2")
            .vipStatus("vipStatus2")
            .room("room2")
            .membershipId(2)
            .contactId(2)
            .rateCategory("rateCategory2")
            .marketMainGroup("marketMainGroup2")
            .sourceMainGroup("sourceMainGroup2")
            .channel("channel2")
            .country("country2")
            .regionCode("regionCode2")
            .nationality("nationality2")
            .psuedoRoomYn("psuedoRoomYn2")
            .adultsTaxFree(2)
            .childrenTaxFree(2)
            .stayRooms(2)
            .stayPersons(2)
            .stayAdults(2)
            .stayChildren(2)
            .arrRooms(2)
            .arrPersons(2)
            .depRooms(2)
            .depPersons(2)
            .dayUseRooms(2)
            .dayUsePersons(2)
            .cancelledRooms(2)
            .cancelledPersons(2)
            .noShowRooms(2)
            .noShowPersons(2)
            .singleOccupancy(2)
            .multipleOccupancy(2)
            .cribs(2)
            .extraBeds(2)
            .countryMainGroup("countryMainGroup2")
            .state("state2")
            .fiscalRegionCode("fiscalRegionCode2")
            .nights(2)
            .noOfStays(2)
            .reservationNights(2)
            .reservationArrivals(2)
            .reservationNoOfStays(2)
            .dayUseReservations(2)
            .cancelledReservations(2)
            .noShowReservations(2)
            .city("city2")
            .zipCode("zipCode2")
            .district("district2")
            .cashRoomNts(2)
            .compRoomNts(2)
            .resInsertSource("resInsertSource2")
            .resInsertSourceType("resInsertSourceType2")
            .children1(2)
            .children2(2)
            .children3(2)
            .children4(2)
            .children5(2)
            .ffMembershipType("ffMembershipType2")
            .fgMembershipType("fgMembershipType2")
            .promotionCode("promotionCode2")
            .ownerFfFlag("ownerFfFlag2")
            .ownerRentalFlag("ownerRentalFlag2")
            .centralCurrencyCode("centralCurrencyCode2")
            .bookedRoomCategory("bookedRoomCategory2")
            .parentCompanyId(2)
            .houseUseYn("houseUseYn2")
            .complimentaryYn("complimentaryYn2")
            .biResvNameId(2)
            .contactYn("contactYn2")
            .extendedStayTier(2)
            .guid("guid2");
    }

    public static ReservationStatDaily getReservationStatDailyRandomSampleGenerator() {
        return new ReservationStatDaily()
            .id(longCount.incrementAndGet())
            .resort(UUID.randomUUID().toString())
            .nameId(intCount.incrementAndGet())
            .rateCode(UUID.randomUUID().toString())
            .sourceCode(UUID.randomUUID().toString())
            .marketCode(UUID.randomUUID().toString())
            .roomCategory(UUID.randomUUID().toString())
            .companyId(intCount.incrementAndGet())
            .agentId(intCount.incrementAndGet())
            .groupId(intCount.incrementAndGet())
            .sourceProfId(intCount.incrementAndGet())
            .resvStatus(UUID.randomUUID().toString())
            .resvNameId(intCount.incrementAndGet())
            .quantity(intCount.incrementAndGet())
            .physicalQuantity(intCount.incrementAndGet())
            .dueOutYn(UUID.randomUUID().toString())
            .roomResvStatus(UUID.randomUUID().toString())
            .adults(intCount.incrementAndGet())
            .children(intCount.incrementAndGet())
            .roomAdults(intCount.incrementAndGet())
            .roomChildren(intCount.incrementAndGet())
            .primaryYn(intCount.incrementAndGet())
            .allotmentHeaderId(intCount.incrementAndGet())
            .walkinYn(UUID.randomUUID().toString())
            .roomClass(UUID.randomUUID().toString())
            .vipStatus(UUID.randomUUID().toString())
            .room(UUID.randomUUID().toString())
            .membershipId(intCount.incrementAndGet())
            .contactId(intCount.incrementAndGet())
            .rateCategory(UUID.randomUUID().toString())
            .marketMainGroup(UUID.randomUUID().toString())
            .sourceMainGroup(UUID.randomUUID().toString())
            .channel(UUID.randomUUID().toString())
            .country(UUID.randomUUID().toString())
            .regionCode(UUID.randomUUID().toString())
            .nationality(UUID.randomUUID().toString())
            .psuedoRoomYn(UUID.randomUUID().toString())
            .adultsTaxFree(intCount.incrementAndGet())
            .childrenTaxFree(intCount.incrementAndGet())
            .stayRooms(intCount.incrementAndGet())
            .stayPersons(intCount.incrementAndGet())
            .stayAdults(intCount.incrementAndGet())
            .stayChildren(intCount.incrementAndGet())
            .arrRooms(intCount.incrementAndGet())
            .arrPersons(intCount.incrementAndGet())
            .depRooms(intCount.incrementAndGet())
            .depPersons(intCount.incrementAndGet())
            .dayUseRooms(intCount.incrementAndGet())
            .dayUsePersons(intCount.incrementAndGet())
            .cancelledRooms(intCount.incrementAndGet())
            .cancelledPersons(intCount.incrementAndGet())
            .noShowRooms(intCount.incrementAndGet())
            .noShowPersons(intCount.incrementAndGet())
            .singleOccupancy(intCount.incrementAndGet())
            .multipleOccupancy(intCount.incrementAndGet())
            .cribs(intCount.incrementAndGet())
            .extraBeds(intCount.incrementAndGet())
            .countryMainGroup(UUID.randomUUID().toString())
            .state(UUID.randomUUID().toString())
            .fiscalRegionCode(UUID.randomUUID().toString())
            .nights(intCount.incrementAndGet())
            .noOfStays(intCount.incrementAndGet())
            .reservationNights(intCount.incrementAndGet())
            .reservationArrivals(intCount.incrementAndGet())
            .reservationNoOfStays(intCount.incrementAndGet())
            .dayUseReservations(intCount.incrementAndGet())
            .cancelledReservations(intCount.incrementAndGet())
            .noShowReservations(intCount.incrementAndGet())
            .city(UUID.randomUUID().toString())
            .zipCode(UUID.randomUUID().toString())
            .district(UUID.randomUUID().toString())
            .cashRoomNts(intCount.incrementAndGet())
            .compRoomNts(intCount.incrementAndGet())
            .resInsertSource(UUID.randomUUID().toString())
            .resInsertSourceType(UUID.randomUUID().toString())
            .children1(intCount.incrementAndGet())
            .children2(intCount.incrementAndGet())
            .children3(intCount.incrementAndGet())
            .children4(intCount.incrementAndGet())
            .children5(intCount.incrementAndGet())
            .ffMembershipType(UUID.randomUUID().toString())
            .fgMembershipType(UUID.randomUUID().toString())
            .promotionCode(UUID.randomUUID().toString())
            .ownerFfFlag(UUID.randomUUID().toString())
            .ownerRentalFlag(UUID.randomUUID().toString())
            .centralCurrencyCode(UUID.randomUUID().toString())
            .bookedRoomCategory(UUID.randomUUID().toString())
            .parentCompanyId(intCount.incrementAndGet())
            .houseUseYn(UUID.randomUUID().toString())
            .complimentaryYn(UUID.randomUUID().toString())
            .biResvNameId(intCount.incrementAndGet())
            .contactYn(UUID.randomUUID().toString())
            .extendedStayTier(intCount.incrementAndGet())
            .guid(UUID.randomUUID().toString());
    }
}
