package com.sbm.mc.domain;

import static com.sbm.mc.domain.ReservationDailyElementsTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReservationDailyElementsTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReservationDailyElements.class);
        ReservationDailyElements reservationDailyElements1 = getReservationDailyElementsSample1();
        ReservationDailyElements reservationDailyElements2 = new ReservationDailyElements();
        assertThat(reservationDailyElements1).isNotEqualTo(reservationDailyElements2);

        reservationDailyElements2.setId(reservationDailyElements1.getId());
        assertThat(reservationDailyElements1).isEqualTo(reservationDailyElements2);

        reservationDailyElements2 = getReservationDailyElementsSample2();
        assertThat(reservationDailyElements1).isNotEqualTo(reservationDailyElements2);
    }
}
