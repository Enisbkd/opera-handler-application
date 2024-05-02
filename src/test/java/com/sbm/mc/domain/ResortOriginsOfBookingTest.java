package com.sbm.mc.domain;

import static com.sbm.mc.domain.ResortOriginsOfBookingTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ResortOriginsOfBookingTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ResortOriginsOfBooking.class);
        ResortOriginsOfBooking resortOriginsOfBooking1 = getResortOriginsOfBookingSample1();
        ResortOriginsOfBooking resortOriginsOfBooking2 = new ResortOriginsOfBooking();
        assertThat(resortOriginsOfBooking1).isNotEqualTo(resortOriginsOfBooking2);

        resortOriginsOfBooking2.setId(resortOriginsOfBooking1.getId());
        assertThat(resortOriginsOfBooking1).isEqualTo(resortOriginsOfBooking2);

        resortOriginsOfBooking2 = getResortOriginsOfBookingSample2();
        assertThat(resortOriginsOfBooking1).isNotEqualTo(resortOriginsOfBooking2);
    }
}
