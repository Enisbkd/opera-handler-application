package com.sbm.mc.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ResortOriginsOfBookingTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static ResortOriginsOfBooking getResortOriginsOfBookingSample1() {
        return new ResortOriginsOfBooking()
            .id(1L)
            .resort("resort1")
            .sourceCode("sourceCode1")
            .parentSourceCode("parentSourceCode1")
            .description("description1")
            .insertUser(1)
            .updateUser(1)
            .sellSequence(1)
            .scOrderby(1)
            .internetSalesYn("internetSalesYn1");
    }

    public static ResortOriginsOfBooking getResortOriginsOfBookingSample2() {
        return new ResortOriginsOfBooking()
            .id(2L)
            .resort("resort2")
            .sourceCode("sourceCode2")
            .parentSourceCode("parentSourceCode2")
            .description("description2")
            .insertUser(2)
            .updateUser(2)
            .sellSequence(2)
            .scOrderby(2)
            .internetSalesYn("internetSalesYn2");
    }

    public static ResortOriginsOfBooking getResortOriginsOfBookingRandomSampleGenerator() {
        return new ResortOriginsOfBooking()
            .id(longCount.incrementAndGet())
            .resort(UUID.randomUUID().toString())
            .sourceCode(UUID.randomUUID().toString())
            .parentSourceCode(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString())
            .insertUser(intCount.incrementAndGet())
            .updateUser(intCount.incrementAndGet())
            .sellSequence(intCount.incrementAndGet())
            .scOrderby(intCount.incrementAndGet())
            .internetSalesYn(UUID.randomUUID().toString());
    }
}
