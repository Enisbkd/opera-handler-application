package com.sbm.mc.domain;

import static com.sbm.mc.domain.NameTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Name.class);
        Name name1 = getNameSample1();
        Name name2 = new Name();
        assertThat(name1).isNotEqualTo(name2);

        name2.setId(name1.getId());
        assertThat(name1).isEqualTo(name2);

        name2 = getNameSample2();
        assertThat(name1).isNotEqualTo(name2);
    }
}
