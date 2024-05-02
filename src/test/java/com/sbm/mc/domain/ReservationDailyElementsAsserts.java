package com.sbm.mc.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class ReservationDailyElementsAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertReservationDailyElementsAllPropertiesEquals(
        ReservationDailyElements expected,
        ReservationDailyElements actual
    ) {
        assertReservationDailyElementsAutoGeneratedPropertiesEquals(expected, actual);
        assertReservationDailyElementsAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertReservationDailyElementsAllUpdatablePropertiesEquals(
        ReservationDailyElements expected,
        ReservationDailyElements actual
    ) {
        assertReservationDailyElementsUpdatableFieldsEquals(expected, actual);
        assertReservationDailyElementsUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertReservationDailyElementsAutoGeneratedPropertiesEquals(
        ReservationDailyElements expected,
        ReservationDailyElements actual
    ) {
        assertThat(expected)
            .as("Verify ReservationDailyElements auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertReservationDailyElementsUpdatableFieldsEquals(
        ReservationDailyElements expected,
        ReservationDailyElements actual
    ) {
        assertThat(expected)
            .as("Verify ReservationDailyElements relevant properties")
            .satisfies(e -> assertThat(e.getResort()).as("check resort").isEqualTo(actual.getResort()))
            .satisfies(e -> assertThat(e.getReservationDate()).as("check reservationDate").isEqualTo(actual.getReservationDate()))
            .satisfies(e -> assertThat(e.getResvDailyElSeq()).as("check resvDailyElSeq").isEqualTo(actual.getResvDailyElSeq()))
            .satisfies(e -> assertThat(e.getResvStatus()).as("check resvStatus").isEqualTo(actual.getResvStatus()))
            .satisfies(e -> assertThat(e.getExternalReference()).as("check externalReference").isEqualTo(actual.getExternalReference()))
            .satisfies(e -> assertThat(e.getRoomClass()).as("check roomClass").isEqualTo(actual.getRoomClass()))
            .satisfies(e -> assertThat(e.getRoomCategory()).as("check roomCategory").isEqualTo(actual.getRoomCategory()))
            .satisfies(e -> assertThat(e.getBookedRoomCategory()).as("check bookedRoomCategory").isEqualTo(actual.getBookedRoomCategory()))
            .satisfies(e -> assertThat(e.getRoom()).as("check room").isEqualTo(actual.getRoom()))
            .satisfies(e -> assertThat(e.getCancellationNo()).as("check cancellationNo").isEqualTo(actual.getCancellationNo()))
            .satisfies(e -> assertThat(e.getCancellationDate()).as("check cancellationDate").isEqualTo(actual.getCancellationDate()))
            .satisfies(e -> assertThat(e.getCancellationCode()).as("check cancellationCode").isEqualTo(actual.getCancellationCode()))
            .satisfies(
                e ->
                    assertThat(e.getCancellationReasonDesc())
                        .as("check cancellationReasonDesc")
                        .isEqualTo(actual.getCancellationReasonDesc())
            )
            .satisfies(e -> assertThat(e.getGuaranteeCode()).as("check guaranteeCode").isEqualTo(actual.getGuaranteeCode()))
            .satisfies(e -> assertThat(e.getMarketCode()).as("check marketCode").isEqualTo(actual.getMarketCode()))
            .satisfies(e -> assertThat(e.getOriginOfBooking()).as("check originOfBooking").isEqualTo(actual.getOriginOfBooking()))
            .satisfies(e -> assertThat(e.getExchangeRate()).as("check exchangeRate").isEqualTo(actual.getExchangeRate()))
            .satisfies(e -> assertThat(e.getOriginalBaseRate()).as("check originalBaseRate").isEqualTo(actual.getOriginalBaseRate()))
            .satisfies(e -> assertThat(e.getBaseRateAmount()).as("check baseRateAmount").isEqualTo(actual.getBaseRateAmount()))
            .satisfies(e -> assertThat(e.getRateAmount()).as("check rateAmount").isEqualTo(actual.getRateAmount()))
            .satisfies(e -> assertThat(e.getRoomCost()).as("check roomCost").isEqualTo(actual.getRoomCost()))
            .satisfies(e -> assertThat(e.getQuantity()).as("check quantity").isEqualTo(actual.getQuantity()))
            .satisfies(e -> assertThat(e.getAdults()).as("check adults").isEqualTo(actual.getAdults()))
            .satisfies(e -> assertThat(e.getChildren()).as("check children").isEqualTo(actual.getChildren()))
            .satisfies(e -> assertThat(e.getPhysicalQuantity()).as("check physicalQuantity").isEqualTo(actual.getPhysicalQuantity()))
            .satisfies(e -> assertThat(e.getAllotmentHeaderId()).as("check allotmentHeaderId").isEqualTo(actual.getAllotmentHeaderId()))
            .satisfies(e -> assertThat(e.getDayUseYn()).as("check dayUseYn").isEqualTo(actual.getDayUseYn()))
            .satisfies(e -> assertThat(e.getDueOutYn()).as("check dueOutYn").isEqualTo(actual.getDueOutYn()))
            .satisfies(e -> assertThat(e.getInsertUser()).as("check insertUser").isEqualTo(actual.getInsertUser()))
            .satisfies(e -> assertThat(e.getInsertDate()).as("check insertDate").isEqualTo(actual.getInsertDate()))
            .satisfies(e -> assertThat(e.getUpdateUser()).as("check updateUser").isEqualTo(actual.getUpdateUser()))
            .satisfies(e -> assertThat(e.getUpdateDate()).as("check updateDate").isEqualTo(actual.getUpdateDate()))
            .satisfies(
                e ->
                    assertThat(e.getInsertActionInstanceId())
                        .as("check insertActionInstanceId")
                        .isEqualTo(actual.getInsertActionInstanceId())
            )
            .satisfies(e -> assertThat(e.getDmlSeqNo()).as("check dmlSeqNo").isEqualTo(actual.getDmlSeqNo()))
            .satisfies(e -> assertThat(e.getExtSeqNo()).as("check extSeqNo").isEqualTo(actual.getExtSeqNo()))
            .satisfies(e -> assertThat(e.getExtSegNo()).as("check extSegNo").isEqualTo(actual.getExtSegNo()))
            .satisfies(e -> assertThat(e.getCribs()).as("check cribs").isEqualTo(actual.getCribs()))
            .satisfies(e -> assertThat(e.getExtraBeds()).as("check extraBeds").isEqualTo(actual.getExtraBeds()))
            .satisfies(
                e -> assertThat(e.getAllotmentRecordType()).as("check allotmentRecordType").isEqualTo(actual.getAllotmentRecordType())
            )
            .satisfies(e -> assertThat(e.getBlockResort()).as("check blockResort").isEqualTo(actual.getBlockResort()))
            .satisfies(e -> assertThat(e.getBlockId()).as("check blockId").isEqualTo(actual.getBlockId()))
            .satisfies(e -> assertThat(e.getTurndownStatus()).as("check turndownStatus").isEqualTo(actual.getTurndownStatus()))
            .satisfies(e -> assertThat(e.getAwdUpgrFrom()).as("check awdUpgrFrom").isEqualTo(actual.getAwdUpgrFrom()))
            .satisfies(e -> assertThat(e.getAwdUpgrTo()).as("check awdUpgrTo").isEqualTo(actual.getAwdUpgrTo()))
            .satisfies(
                e -> assertThat(e.getHkExpectedServiceTime()).as("check hkExpectedServiceTime").isEqualTo(actual.getHkExpectedServiceTime())
            )
            .satisfies(e -> assertThat(e.getRoomInstructions()).as("check roomInstructions").isEqualTo(actual.getRoomInstructions()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertReservationDailyElementsUpdatableRelationshipsEquals(
        ReservationDailyElements expected,
        ReservationDailyElements actual
    ) {}
}
