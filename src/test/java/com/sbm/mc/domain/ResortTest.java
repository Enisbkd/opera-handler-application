package com.sbm.mc.domain;

import static com.sbm.mc.domain.ResortTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ResortTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Resort.class);
        Resort resort1 = getResortSample1();
        Resort resort2 = new Resort();
        assertThat(resort1).isNotEqualTo(resort2);

        resort2.setId(resort1.getId());
        assertThat(resort1).isEqualTo(resort2);

        resort2 = getResortSample2();
        assertThat(resort1).isNotEqualTo(resort2);
    }
}
