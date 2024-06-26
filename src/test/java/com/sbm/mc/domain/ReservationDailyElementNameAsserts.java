package com.sbm.mc.domain;

import static com.sbm.mc.domain.AssertUtils.bigDecimalCompareTo;
import static org.assertj.core.api.Assertions.assertThat;

public class ReservationDailyElementNameAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertReservationDailyElementNameAllPropertiesEquals(
        ReservationDailyElementName expected,
        ReservationDailyElementName actual
    ) {
        assertReservationDailyElementNameAutoGeneratedPropertiesEquals(expected, actual);
        assertReservationDailyElementNameAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertReservationDailyElementNameAllUpdatablePropertiesEquals(
        ReservationDailyElementName expected,
        ReservationDailyElementName actual
    ) {
        assertReservationDailyElementNameUpdatableFieldsEquals(expected, actual);
        assertReservationDailyElementNameUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertReservationDailyElementNameAutoGeneratedPropertiesEquals(
        ReservationDailyElementName expected,
        ReservationDailyElementName actual
    ) {
        assertThat(expected)
            .as("Verify ReservationDailyElementName auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertReservationDailyElementNameUpdatableFieldsEquals(
        ReservationDailyElementName expected,
        ReservationDailyElementName actual
    ) {
        assertThat(expected)
            .as("Verify ReservationDailyElementName relevant properties")
            .satisfies(e -> assertThat(e.getResort()).as("check resort").isEqualTo(actual.getResort()))
            .satisfies(e -> assertThat(e.getResvNameId()).as("check resvNameId").isEqualTo(actual.getResvNameId()))
            .satisfies(e -> assertThat(e.getReservationDate()).as("check reservationDate").isEqualTo(actual.getReservationDate()))
            .satisfies(e -> assertThat(e.getResvDailyElSeq()).as("check resvDailyElSeq").isEqualTo(actual.getResvDailyElSeq()))
            .satisfies(e -> assertThat(e.getTravelAgentId()).as("check travelAgentId").isEqualTo(actual.getTravelAgentId()))
            .satisfies(e -> assertThat(e.getCompanyId()).as("check companyId").isEqualTo(actual.getCompanyId()))
            .satisfies(e -> assertThat(e.getSourceId()).as("check sourceId").isEqualTo(actual.getSourceId()))
            .satisfies(e -> assertThat(e.getGroupId()).as("check groupId").isEqualTo(actual.getGroupId()))
            .satisfies(e -> assertThat(e.getSharePaymentType()).as("check sharePaymentType").isEqualTo(actual.getSharePaymentType()))
            .satisfies(
                e ->
                    assertThat(e.getShareAmount())
                        .as("check shareAmount")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getShareAmount())
            )
            .satisfies(
                e ->
                    assertThat(e.getSharePrcnt())
                        .as("check sharePrcnt")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getSharePrcnt())
            )
            .satisfies(e -> assertThat(e.getAdults()).as("check adults").isEqualTo(actual.getAdults()))
            .satisfies(e -> assertThat(e.getChildren()).as("check children").isEqualTo(actual.getChildren()))
            .satisfies(
                e ->
                    assertThat(e.getDiscountAmt())
                        .as("check discountAmt")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getDiscountAmt())
            )
            .satisfies(
                e ->
                    assertThat(e.getDiscountPrcnt())
                        .as("check discountPrcnt")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getDiscountPrcnt())
            )
            .satisfies(e -> assertThat(e.getDiscountReasonCode()).as("check discountReasonCode").isEqualTo(actual.getDiscountReasonCode()))
            .satisfies(e -> assertThat(e.getFixedRateYn()).as("check fixedRateYn").isEqualTo(actual.getFixedRateYn()))
            .satisfies(
                e ->
                    assertThat(e.getBaseRateAmount())
                        .as("check baseRateAmount")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getBaseRateAmount())
            )
            .satisfies(
                e ->
                    assertThat(e.getAutoPostAmount())
                        .as("check autoPostAmount")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getAutoPostAmount())
            )
            .satisfies(e -> assertThat(e.getSharePriority()).as("check sharePriority").isEqualTo(actual.getSharePriority()))
            .satisfies(e -> assertThat(e.getInsertUser()).as("check insertUser").isEqualTo(actual.getInsertUser()))
            .satisfies(e -> assertThat(e.getInsertDate()).as("check insertDate").isEqualTo(actual.getInsertDate()))
            .satisfies(e -> assertThat(e.getUpdateUser()).as("check updateUser").isEqualTo(actual.getUpdateUser()))
            .satisfies(e -> assertThat(e.getUpdateDate()).as("check updateDate").isEqualTo(actual.getUpdateDate()))
            .satisfies(
                e -> assertThat(e.getLastShareCalculation()).as("check lastShareCalculation").isEqualTo(actual.getLastShareCalculation())
            )
            .satisfies(
                e ->
                    assertThat(e.getInsertActionInstanceId())
                        .as("check insertActionInstanceId")
                        .isEqualTo(actual.getInsertActionInstanceId())
            )
            .satisfies(e -> assertThat(e.getDmlSeqNo()).as("check dmlSeqNo").isEqualTo(actual.getDmlSeqNo()))
            .satisfies(
                e ->
                    assertThat(e.getNetRoomAmt())
                        .as("check netRoomAmt")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getNetRoomAmt())
            )
            .satisfies(
                e -> assertThat(e.getRoomTax()).as("check roomTax").usingComparator(bigDecimalCompareTo).isEqualTo(actual.getRoomTax())
            )
            .satisfies(e -> assertThat(e.getPkgAmt()).as("check pkgAmt").usingComparator(bigDecimalCompareTo).isEqualTo(actual.getPkgAmt()))
            .satisfies(e -> assertThat(e.getPkgTax()).as("check pkgTax").usingComparator(bigDecimalCompareTo).isEqualTo(actual.getPkgTax()))
            .satisfies(
                e ->
                    assertThat(e.getGrossRateAmt())
                        .as("check grossRateAmt")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getGrossRateAmt())
            )
            .satisfies(e -> assertThat(e.getAdultsTaxFree()).as("check adultsTaxFree").isEqualTo(actual.getAdultsTaxFree()))
            .satisfies(e -> assertThat(e.getChildrenTaxFree()).as("check childrenTaxFree").isEqualTo(actual.getChildrenTaxFree()))
            .satisfies(e -> assertThat(e.getChildren1()).as("check children1").isEqualTo(actual.getChildren1()))
            .satisfies(e -> assertThat(e.getChildren2()).as("check children2").isEqualTo(actual.getChildren2()))
            .satisfies(e -> assertThat(e.getChildren3()).as("check children3").isEqualTo(actual.getChildren3()))
            .satisfies(e -> assertThat(e.getRateCode()).as("check rateCode").isEqualTo(actual.getRateCode()))
            .satisfies(e -> assertThat(e.getCurrencyCode()).as("check currencyCode").isEqualTo(actual.getCurrencyCode()))
            .satisfies(
                e -> assertThat(e.getExchangePostingType()).as("check exchangePostingType").isEqualTo(actual.getExchangePostingType())
            )
            .satisfies(e -> assertThat(e.getMembershipPoints()).as("check membershipPoints").isEqualTo(actual.getMembershipPoints()))
            .satisfies(e -> assertThat(e.getChildren4()).as("check children4").isEqualTo(actual.getChildren4()))
            .satisfies(e -> assertThat(e.getChildren5()).as("check children5").isEqualTo(actual.getChildren5()))
            .satisfies(e -> assertThat(e.getCommissionCode()).as("check commissionCode").isEqualTo(actual.getCommissionCode()))
            .satisfies(e -> assertThat(e.getAwardCode1()).as("check awardCode1").isEqualTo(actual.getAwardCode1()))
            .satisfies(e -> assertThat(e.getAwardCode2()).as("check awardCode2").isEqualTo(actual.getAwardCode2()))
            .satisfies(e -> assertThat(e.getAwardCode3()).as("check awardCode3").isEqualTo(actual.getAwardCode3()))
            .satisfies(e -> assertThat(e.getAwardCode4()).as("check awardCode4").isEqualTo(actual.getAwardCode4()))
            .satisfies(e -> assertThat(e.getAwardCode5()).as("check awardCode5").isEqualTo(actual.getAwardCode5()))
            .satisfies(e -> assertThat(e.getAwardVoucher1()).as("check awardVoucher1").isEqualTo(actual.getAwardVoucher1()))
            .satisfies(e -> assertThat(e.getAwardVoucher2()).as("check awardVoucher2").isEqualTo(actual.getAwardVoucher2()))
            .satisfies(e -> assertThat(e.getAwardVoucher3()).as("check awardVoucher3").isEqualTo(actual.getAwardVoucher3()))
            .satisfies(e -> assertThat(e.getAwardVoucher4()).as("check awardVoucher4").isEqualTo(actual.getAwardVoucher4()))
            .satisfies(e -> assertThat(e.getAwardVoucher5()).as("check awardVoucher5").isEqualTo(actual.getAwardVoucher5()))
            .satisfies(e -> assertThat(e.getDoNotMoveYn()).as("check doNotMoveYn").isEqualTo(actual.getDoNotMoveYn()))
            .satisfies(e -> assertThat(e.getAwardCode()).as("check awardCode").isEqualTo(actual.getAwardCode()))
            .satisfies(e -> assertThat(e.getPoints()).as("check points").isEqualTo(actual.getPoints()))
            .satisfies(
                e ->
                    assertThat(e.getUpsellCharge())
                        .as("check upsellCharge")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getUpsellCharge())
            )
            .satisfies(
                e -> assertThat(e.getPointsEligibilityCode()).as("check pointsEligibilityCode").isEqualTo(actual.getPointsEligibilityCode())
            )
            .satisfies(
                e ->
                    assertThat(e.getCommissionPaid())
                        .as("check commissionPaid")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getCommissionPaid())
            )
            .satisfies(e -> assertThat(e.getResvContactId()).as("check resvContactId").isEqualTo(actual.getResvContactId()))
            .satisfies(e -> assertThat(e.getBillingContactId()).as("check billingContactId").isEqualTo(actual.getBillingContactId()))
            .satisfies(
                e ->
                    assertThat(e.getShareAmountOriginal())
                        .as("check shareAmountOriginal")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getShareAmountOriginal())
            )
            .satisfies(e -> assertThat(e.getReferralYn()).as("check referralYn").isEqualTo(actual.getReferralYn()))
            .satisfies(e -> assertThat(e.getBxgyDiscountYn()).as("check bxgyDiscountYn").isEqualTo(actual.getBxgyDiscountYn()))
            .satisfies(e -> assertThat(e.getCommissionableYn()).as("check commissionableYn").isEqualTo(actual.getCommissionableYn()))
            .satisfies(e -> assertThat(e.getBasedOnRule()).as("check basedOnRule").isEqualTo(actual.getBasedOnRule()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertReservationDailyElementNameUpdatableRelationshipsEquals(
        ReservationDailyElementName expected,
        ReservationDailyElementName actual
    ) {}
}
