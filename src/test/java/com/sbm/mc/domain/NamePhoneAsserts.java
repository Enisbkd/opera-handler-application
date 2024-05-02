package com.sbm.mc.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class NamePhoneAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertNamePhoneAllPropertiesEquals(NamePhone expected, NamePhone actual) {
        assertNamePhoneAutoGeneratedPropertiesEquals(expected, actual);
        assertNamePhoneAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertNamePhoneAllUpdatablePropertiesEquals(NamePhone expected, NamePhone actual) {
        assertNamePhoneUpdatableFieldsEquals(expected, actual);
        assertNamePhoneUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertNamePhoneAutoGeneratedPropertiesEquals(NamePhone expected, NamePhone actual) {
        assertThat(expected)
            .as("Verify NamePhone auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertNamePhoneUpdatableFieldsEquals(NamePhone expected, NamePhone actual) {
        assertThat(expected)
            .as("Verify NamePhone relevant properties")
            .satisfies(e -> assertThat(e.getPhoneId()).as("check phoneId").isEqualTo(actual.getPhoneId()))
            .satisfies(e -> assertThat(e.getNameId()).as("check nameId").isEqualTo(actual.getNameId()))
            .satisfies(e -> assertThat(e.getPhoneType()).as("check phoneType").isEqualTo(actual.getPhoneType()))
            .satisfies(e -> assertThat(e.getPhoneRole()).as("check phoneRole").isEqualTo(actual.getPhoneRole()))
            .satisfies(e -> assertThat(e.getPhoneNumber()).as("check phoneNumber").isEqualTo(actual.getPhoneNumber()))
            .satisfies(e -> assertThat(e.getInsertDate()).as("check insertDate").isEqualTo(actual.getInsertDate()))
            .satisfies(e -> assertThat(e.getInsertUser()).as("check insertUser").isEqualTo(actual.getInsertUser()))
            .satisfies(e -> assertThat(e.getUpdateDate()).as("check updateDate").isEqualTo(actual.getUpdateDate()))
            .satisfies(e -> assertThat(e.getUpdateUser()).as("check updateUser").isEqualTo(actual.getUpdateUser()))
            .satisfies(e -> assertThat(e.getInactiveDate()).as("check inactiveDate").isEqualTo(actual.getInactiveDate()))
            .satisfies(e -> assertThat(e.getEndDate()).as("check endDate").isEqualTo(actual.getEndDate()))
            .satisfies(e -> assertThat(e.getBeginDate()).as("check beginDate").isEqualTo(actual.getBeginDate()))
            .satisfies(e -> assertThat(e.getAddressId()).as("check addressId").isEqualTo(actual.getAddressId()))
            .satisfies(e -> assertThat(e.getPrimaryYn()).as("check primaryYn").isEqualTo(actual.getPrimaryYn()))
            .satisfies(e -> assertThat(e.getDisplaySeq()).as("check displaySeq").isEqualTo(actual.getDisplaySeq()))
            .satisfies(e -> assertThat(e.getLaptopChange()).as("check laptopChange").isEqualTo(actual.getLaptopChange()))
            .satisfies(e -> assertThat(e.getIndexPhone()).as("check indexPhone").isEqualTo(actual.getIndexPhone()))
            .satisfies(e -> assertThat(e.getExtension()).as("check extension").isEqualTo(actual.getExtension()))
            .satisfies(e -> assertThat(e.getEmailFormat()).as("check emailFormat").isEqualTo(actual.getEmailFormat()))
            .satisfies(e -> assertThat(e.getShareEmailYn()).as("check shareEmailYn").isEqualTo(actual.getShareEmailYn()))
            .satisfies(
                e -> assertThat(e.getDefaultConfirmationYn()).as("check defaultConfirmationYn").isEqualTo(actual.getDefaultConfirmationYn())
            )
            .satisfies(e -> assertThat(e.getEmailLanguage()).as("check emailLanguage").isEqualTo(actual.getEmailLanguage()))
            .satisfies(e -> assertThat(e.getMobileAudioKeyYn()).as("check mobileAudioKeyYn").isEqualTo(actual.getMobileAudioKeyYn()))
            .satisfies(e -> assertThat(e.getCountryDialingCode()).as("check countryDialingCode").isEqualTo(actual.getCountryDialingCode()))
            .satisfies(e -> assertThat(e.getValidYn()).as("check validYn").isEqualTo(actual.getValidYn()))
            .satisfies(e -> assertThat(e.getPhoneCountryCode()).as("check phoneCountryCode").isEqualTo(actual.getPhoneCountryCode()))
            .satisfies(e -> assertThat(e.getChainCode()).as("check chainCode").isEqualTo(actual.getChainCode()))
            .satisfies(e -> assertThat(e.getValidateDate()).as("check validateDate").isEqualTo(actual.getValidateDate()))
            .satisfies(e -> assertThat(e.getValidateStatus()).as("check validateStatus").isEqualTo(actual.getValidateStatus()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertNamePhoneUpdatableRelationshipsEquals(NamePhone expected, NamePhone actual) {}
}
