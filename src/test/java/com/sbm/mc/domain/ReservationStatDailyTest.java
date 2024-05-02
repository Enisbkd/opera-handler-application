package com.sbm.mc.domain;

import static com.sbm.mc.domain.ReservationStatDailyTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReservationStatDailyTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReservationStatDaily.class);
        ReservationStatDaily reservationStatDaily1 = getReservationStatDailySample1();
        ReservationStatDaily reservationStatDaily2 = new ReservationStatDaily();
        assertThat(reservationStatDaily1).isNotEqualTo(reservationStatDaily2);

        reservationStatDaily2.setId(reservationStatDaily1.getId());
        assertThat(reservationStatDaily1).isEqualTo(reservationStatDaily2);

        reservationStatDaily2 = getReservationStatDailySample2();
        assertThat(reservationStatDaily1).isNotEqualTo(reservationStatDaily2);
    }
}
