package com.sbm.mc.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class NamePhoneTestSamples {

    private static final Random random = new Random();
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static NamePhone getNamePhoneSample1() {
        return new NamePhone()
            .id(1)
            .phoneId(1)
            .nameId(1)
            .phoneType("phoneType1")
            .phoneRole("phoneRole1")
            .phoneNumber("phoneNumber1")
            .insertUser(1)
            .updateUser(1)
            .addressId(1)
            .primaryYn("primaryYn1")
            .displaySeq(1)
            .laptopChange(1)
            .indexPhone("indexPhone1")
            .extension("extension1")
            .emailFormat("emailFormat1")
            .shareEmailYn("shareEmailYn1")
            .defaultConfirmationYn("defaultConfirmationYn1")
            .emailLanguage("emailLanguage1")
            .mobileAudioKeyYn("mobileAudioKeyYn1")
            .countryDialingCode(1)
            .validYn("validYn1")
            .phoneCountryCode("phoneCountryCode1")
            .chainCode("chainCode1")
            .validateStatus("validateStatus1");
    }

    public static NamePhone getNamePhoneSample2() {
        return new NamePhone()
            .id(2)
            .phoneId(2)
            .nameId(2)
            .phoneType("phoneType2")
            .phoneRole("phoneRole2")
            .phoneNumber("phoneNumber2")
            .insertUser(2)
            .updateUser(2)
            .addressId(2)
            .primaryYn("primaryYn2")
            .displaySeq(2)
            .laptopChange(2)
            .indexPhone("indexPhone2")
            .extension("extension2")
            .emailFormat("emailFormat2")
            .shareEmailYn("shareEmailYn2")
            .defaultConfirmationYn("defaultConfirmationYn2")
            .emailLanguage("emailLanguage2")
            .mobileAudioKeyYn("mobileAudioKeyYn2")
            .countryDialingCode(2)
            .validYn("validYn2")
            .phoneCountryCode("phoneCountryCode2")
            .chainCode("chainCode2")
            .validateStatus("validateStatus2");
    }

    public static NamePhone getNamePhoneRandomSampleGenerator() {
        return new NamePhone()
            .id(intCount.incrementAndGet())
            .phoneId(intCount.incrementAndGet())
            .nameId(intCount.incrementAndGet())
            .phoneType(UUID.randomUUID().toString())
            .phoneRole(UUID.randomUUID().toString())
            .phoneNumber(UUID.randomUUID().toString())
            .insertUser(intCount.incrementAndGet())
            .updateUser(intCount.incrementAndGet())
            .addressId(intCount.incrementAndGet())
            .primaryYn(UUID.randomUUID().toString())
            .displaySeq(intCount.incrementAndGet())
            .laptopChange(intCount.incrementAndGet())
            .indexPhone(UUID.randomUUID().toString())
            .extension(UUID.randomUUID().toString())
            .emailFormat(UUID.randomUUID().toString())
            .shareEmailYn(UUID.randomUUID().toString())
            .defaultConfirmationYn(UUID.randomUUID().toString())
            .emailLanguage(UUID.randomUUID().toString())
            .mobileAudioKeyYn(UUID.randomUUID().toString())
            .countryDialingCode(intCount.incrementAndGet())
            .validYn(UUID.randomUUID().toString())
            .phoneCountryCode(UUID.randomUUID().toString())
            .chainCode(UUID.randomUUID().toString())
            .validateStatus(UUID.randomUUID().toString());
    }
}
