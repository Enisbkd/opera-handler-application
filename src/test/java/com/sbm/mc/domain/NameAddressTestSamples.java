package com.sbm.mc.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class NameAddressTestSamples {

    private static final Random random = new Random();
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static NameAddress getNameAddressSample1() {
        return new NameAddress()
            .id(1)
            .addressId(1)
            .addressType("addressType1")
            .address1("address11")
            .address2("address21")
            .address3("address31")
            .address4("address41")
            .barcode("barcode1")
            .chainCode("chainCode1")
            .city("city1")
            .cityExt("cityExt1")
            .cleansedErrormsg("cleansedErrormsg1")
            .cleansedMatchstatus("cleansedMatchstatus1")
            .cleansedStatus("cleansedStatus1")
            .cleansedValidationstatus("cleansedValidationstatus1")
            .country("country1")
            .foreignCountry("foreignCountry1")
            .inCareOf("inCareOf1")
            .insertUser(1)
            .languageCode("languageCode1")
            .laptopChange(1)
            .lastUpdatedResort("lastUpdatedResort1")
            .nameId(1)
            .primaryYn("primaryYn1")
            .province("province1")
            .state("state1")
            .updateUser(1)
            .zipCode("zipCode1");
    }

    public static NameAddress getNameAddressSample2() {
        return new NameAddress()
            .id(2)
            .addressId(2)
            .addressType("addressType2")
            .address1("address12")
            .address2("address22")
            .address3("address32")
            .address4("address42")
            .barcode("barcode2")
            .chainCode("chainCode2")
            .city("city2")
            .cityExt("cityExt2")
            .cleansedErrormsg("cleansedErrormsg2")
            .cleansedMatchstatus("cleansedMatchstatus2")
            .cleansedStatus("cleansedStatus2")
            .cleansedValidationstatus("cleansedValidationstatus2")
            .country("country2")
            .foreignCountry("foreignCountry2")
            .inCareOf("inCareOf2")
            .insertUser(2)
            .languageCode("languageCode2")
            .laptopChange(2)
            .lastUpdatedResort("lastUpdatedResort2")
            .nameId(2)
            .primaryYn("primaryYn2")
            .province("province2")
            .state("state2")
            .updateUser(2)
            .zipCode("zipCode2");
    }

    public static NameAddress getNameAddressRandomSampleGenerator() {
        return new NameAddress()
            .id(intCount.incrementAndGet())
            .addressId(intCount.incrementAndGet())
            .addressType(UUID.randomUUID().toString())
            .address1(UUID.randomUUID().toString())
            .address2(UUID.randomUUID().toString())
            .address3(UUID.randomUUID().toString())
            .address4(UUID.randomUUID().toString())
            .barcode(UUID.randomUUID().toString())
            .chainCode(UUID.randomUUID().toString())
            .city(UUID.randomUUID().toString())
            .cityExt(UUID.randomUUID().toString())
            .cleansedErrormsg(UUID.randomUUID().toString())
            .cleansedMatchstatus(UUID.randomUUID().toString())
            .cleansedStatus(UUID.randomUUID().toString())
            .cleansedValidationstatus(UUID.randomUUID().toString())
            .country(UUID.randomUUID().toString())
            .foreignCountry(UUID.randomUUID().toString())
            .inCareOf(UUID.randomUUID().toString())
            .insertUser(intCount.incrementAndGet())
            .languageCode(UUID.randomUUID().toString())
            .laptopChange(intCount.incrementAndGet())
            .lastUpdatedResort(UUID.randomUUID().toString())
            .nameId(intCount.incrementAndGet())
            .primaryYn(UUID.randomUUID().toString())
            .province(UUID.randomUUID().toString())
            .state(UUID.randomUUID().toString())
            .updateUser(intCount.incrementAndGet())
            .zipCode(UUID.randomUUID().toString());
    }
}
