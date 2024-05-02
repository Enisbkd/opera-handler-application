package com.sbm.mc.domain;

import static com.sbm.mc.domain.NamePhoneTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class NamePhoneTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NamePhone.class);
        NamePhone namePhone1 = getNamePhoneSample1();
        NamePhone namePhone2 = new NamePhone();
        assertThat(namePhone1).isNotEqualTo(namePhone2);

        namePhone2.setId(namePhone1.getId());
        assertThat(namePhone1).isEqualTo(namePhone2);

        namePhone2 = getNamePhoneSample2();
        assertThat(namePhone1).isNotEqualTo(namePhone2);
    }
}
