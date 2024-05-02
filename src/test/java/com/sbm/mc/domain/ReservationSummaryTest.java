package com.sbm.mc.domain;

import static com.sbm.mc.domain.ReservationSummaryTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReservationSummaryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReservationSummary.class);
        ReservationSummary reservationSummary1 = getReservationSummarySample1();
        ReservationSummary reservationSummary2 = new ReservationSummary();
        assertThat(reservationSummary1).isNotEqualTo(reservationSummary2);

        reservationSummary2.setId(reservationSummary1.getId());
        assertThat(reservationSummary1).isEqualTo(reservationSummary2);

        reservationSummary2 = getReservationSummarySample2();
        assertThat(reservationSummary1).isNotEqualTo(reservationSummary2);
    }
}
