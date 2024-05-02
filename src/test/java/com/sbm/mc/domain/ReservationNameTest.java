package com.sbm.mc.domain;

import static com.sbm.mc.domain.ReservationNameTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReservationNameTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReservationName.class);
        ReservationName reservationName1 = getReservationNameSample1();
        ReservationName reservationName2 = new ReservationName();
        assertThat(reservationName1).isNotEqualTo(reservationName2);

        reservationName2.setId(reservationName1.getId());
        assertThat(reservationName1).isEqualTo(reservationName2);

        reservationName2 = getReservationNameSample2();
        assertThat(reservationName1).isNotEqualTo(reservationName2);
    }
}
