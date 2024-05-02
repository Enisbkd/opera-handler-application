package com.sbm.mc.domain;

import static com.sbm.mc.domain.ResortRoomCategoryTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ResortRoomCategoryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ResortRoomCategory.class);
        ResortRoomCategory resortRoomCategory1 = getResortRoomCategorySample1();
        ResortRoomCategory resortRoomCategory2 = new ResortRoomCategory();
        assertThat(resortRoomCategory1).isNotEqualTo(resortRoomCategory2);

        resortRoomCategory2.setId(resortRoomCategory1.getId());
        assertThat(resortRoomCategory1).isEqualTo(resortRoomCategory2);

        resortRoomCategory2 = getResortRoomCategorySample2();
        assertThat(resortRoomCategory1).isNotEqualTo(resortRoomCategory2);
    }
}
