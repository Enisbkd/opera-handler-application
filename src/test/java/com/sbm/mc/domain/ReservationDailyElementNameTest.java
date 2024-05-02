package com.sbm.mc.domain;

import static com.sbm.mc.domain.ReservationDailyElementNameTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReservationDailyElementNameTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReservationDailyElementName.class);
        ReservationDailyElementName reservationDailyElementName1 = getReservationDailyElementNameSample1();
        ReservationDailyElementName reservationDailyElementName2 = new ReservationDailyElementName();
        assertThat(reservationDailyElementName1).isNotEqualTo(reservationDailyElementName2);

        reservationDailyElementName2.setId(reservationDailyElementName1.getId());
        assertThat(reservationDailyElementName1).isEqualTo(reservationDailyElementName2);

        reservationDailyElementName2 = getReservationDailyElementNameSample2();
        assertThat(reservationDailyElementName1).isNotEqualTo(reservationDailyElementName2);
    }
}
