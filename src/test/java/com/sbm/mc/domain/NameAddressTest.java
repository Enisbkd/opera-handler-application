package com.sbm.mc.domain;

import static com.sbm.mc.domain.NameAddressTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class NameAddressTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NameAddress.class);
        NameAddress nameAddress1 = getNameAddressSample1();
        NameAddress nameAddress2 = new NameAddress();
        assertThat(nameAddress1).isNotEqualTo(nameAddress2);

        nameAddress2.setId(nameAddress1.getId());
        assertThat(nameAddress1).isEqualTo(nameAddress2);

        nameAddress2 = getNameAddressSample2();
        assertThat(nameAddress1).isNotEqualTo(nameAddress2);
    }
}
