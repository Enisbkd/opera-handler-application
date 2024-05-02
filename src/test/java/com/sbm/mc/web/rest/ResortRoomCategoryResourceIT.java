package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.ResortRoomCategoryAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static com.sbm.mc.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.ResortRoomCategory;
import com.sbm.mc.repository.ResortRoomCategoryRepository;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link ResortRoomCategoryResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ResortRoomCategoryResourceIT {

    private static final String DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_RESORT = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_ROOM_CLASS = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_CLASS = "BBBBBBBBBB";

    private static final Integer DEFAULT_NUMBER_ROOMS = 1;
    private static final Integer UPDATED_NUMBER_ROOMS = 2;

    private static final String DEFAULT_SHORT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_SHORT_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_LONG_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_LONG_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_COMPILED = "AAAAAAAAAA";
    private static final String UPDATED_COMPILED = "BBBBBBBBBB";

    private static final String DEFAULT_PSUEDO_ROOM_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PSUEDO_ROOM_TYPE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_ACTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ACTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_INACTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INACTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_REPLACES_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_REPLACES_CATEGORY = "BBBBBBBBBB";

    private static final Integer DEFAULT_ORDER_BY = 1;
    private static final Integer UPDATED_ORDER_BY = 2;

    private static final Integer DEFAULT_MAX_OCCUPANCY = 1;
    private static final Integer UPDATED_MAX_OCCUPANCY = 2;

    private static final Integer DEFAULT_MAX_ROLLAWAYS = 1;
    private static final Integer UPDATED_MAX_ROLLAWAYS = 2;

    private static final String DEFAULT_RATE_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_RATE_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_LABEL = "AAAAAAAAAA";
    private static final String UPDATED_LABEL = "BBBBBBBBBB";

    private static final String DEFAULT_GENERIC_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_GENERIC_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_SUITE_YN = "AAAAAAAAAA";
    private static final String UPDATED_SUITE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_MEETINGROOM_YN = "AAAAAAAAAA";
    private static final String UPDATED_MEETINGROOM_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_RATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_RATE_CODE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_RATE_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_RATE_AMOUNT = new BigDecimal(2);

    private static final Integer DEFAULT_DEF_OCCUPANCY = 1;
    private static final Integer UPDATED_DEF_OCCUPANCY = 2;

    private static final Integer DEFAULT_IMAGE_ID = 1;
    private static final Integer UPDATED_IMAGE_ID = 2;

    private static final String DEFAULT_PSEUDO_YN = "AAAAAAAAAA";
    private static final String UPDATED_PSEUDO_YN = "BBBBBBBBBB";

    private static final String DEFAULT_SEND_TO_INTERFACE_YN = "AAAAAAAAAA";
    private static final String UPDATED_SEND_TO_INTERFACE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_YIELDABLE_YN = "AAAAAAAAAA";
    private static final String UPDATED_YIELDABLE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_YIELD_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_YIELD_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_HOUSEKEEPING = "AAAAAAAAAA";
    private static final String UPDATED_HOUSEKEEPING = "BBBBBBBBBB";

    private static final String DEFAULT_CAN_DELETE_YN = "AAAAAAAAAA";
    private static final String UPDATED_CAN_DELETE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMINFO_URL = "AAAAAAAAAA";
    private static final String UPDATED_ROOMINFO_URL = "BBBBBBBBBB";

    private static final String DEFAULT_OWNER_YN = "AAAAAAAAAA";
    private static final String UPDATED_OWNER_YN = "BBBBBBBBBB";

    private static final String DEFAULT_AUTO_INCLUDE_YN = "AAAAAAAAAA";
    private static final String UPDATED_AUTO_INCLUDE_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_INITIAL_ROUND_UP = 1;
    private static final Integer UPDATED_INITIAL_ROUND_UP = 2;

    private static final Integer DEFAULT_INCREMENTS = 1;
    private static final Integer UPDATED_INCREMENTS = 2;

    private static final String DEFAULT_ROTATION_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_ROTATION_GROUP = "BBBBBBBBBB";

    private static final String DEFAULT_SALES_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_SALES_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_AUTO_ROOM_ASSIGN_YN = "AAAAAAAAAA";
    private static final String UPDATED_AUTO_ROOM_ASSIGN_YN = "BBBBBBBBBB";

    private static final String DEFAULT_UPSELL_YN = "AAAAAAAAAA";
    private static final String UPDATED_UPSELL_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_ORMS_UPSELL_RANK = 1;
    private static final Integer UPDATED_ORMS_UPSELL_RANK = 2;

    private static final BigDecimal DEFAULT_ORMS_UPSELL_AMT = new BigDecimal(1);
    private static final BigDecimal UPDATED_ORMS_UPSELL_AMT = new BigDecimal(2);

    private static final Integer DEFAULT_ORMS_DRXTRA_ADULT = 1;
    private static final Integer UPDATED_ORMS_DRXTRA_ADULT = 2;

    private static final Integer DEFAULT_ORMS_DRXTRA_CHILD = 1;
    private static final Integer UPDATED_ORMS_DRXTRA_CHILD = 2;

    private static final Integer DEFAULT_MAX_OCCUPANCY_ADULTS = 1;
    private static final Integer UPDATED_MAX_OCCUPANCY_ADULTS = 2;

    private static final Integer DEFAULT_MAX_OCCUPANCY_CHILDREN = 1;
    private static final Integer UPDATED_MAX_OCCUPANCY_CHILDREN = 2;

    private static final String DEFAULT_ROOM_POOL = "AAAAAAAAAA";
    private static final String UPDATED_ROOM_POOL = "BBBBBBBBBB";

    private static final String DEFAULT_MEMBER_AWARD_ROOM_GRP = "AAAAAAAAAA";
    private static final String UPDATED_MEMBER_AWARD_ROOM_GRP = "BBBBBBBBBB";

    private static final Integer DEFAULT_ORMS_DRXTRA_2ND_ADULT = 1;
    private static final Integer UPDATED_ORMS_DRXTRA_2ND_ADULT = 2;

    private static final Integer DEFAULT_ORMS_DRTIER_1 = 1;
    private static final Integer UPDATED_ORMS_DRTIER_1 = 2;

    private static final Integer DEFAULT_ORMS_DRTIER_2 = 1;
    private static final Integer UPDATED_ORMS_DRTIER_2 = 2;

    private static final Integer DEFAULT_ORMS_DRTIER_3 = 1;
    private static final Integer UPDATED_ORMS_DRTIER_3 = 2;

    private static final String DEFAULT_AUTO_CHECKIN_YN = "AAAAAAAAAA";
    private static final String UPDATED_AUTO_CHECKIN_YN = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_RATE_FLOOR = new BigDecimal(1);
    private static final BigDecimal UPDATED_RATE_FLOOR = new BigDecimal(2);

    private static final Integer DEFAULT_MAX_FIX_BED_OCCUPANCY = 1;
    private static final Integer UPDATED_MAX_FIX_BED_OCCUPANCY = 2;

    private static final String DEFAULT_MAINTENANCE_YN = "AAAAAAAAAA";
    private static final String UPDATED_MAINTENANCE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_SMOKING_PREFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_SMOKING_PREFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_S_LABEL = "AAAAAAAAAA";
    private static final String UPDATED_S_LABEL = "BBBBBBBBBB";

    private static final String DEFAULT_S_BEDTYPE = "AAAAAAAAAA";
    private static final String UPDATED_S_BEDTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SELL_THRU_RULE_YN = "AAAAAAAAAA";
    private static final String UPDATED_SELL_THRU_RULE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_CRS_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_CRS_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_EVISITOR_FACILITY_ID = "AAAAAAAAAA";
    private static final String UPDATED_EVISITOR_FACILITY_ID = "BBBBBBBBBB";

    private static final Integer DEFAULT_MIN_OCCUPANCY = 1;
    private static final Integer UPDATED_MIN_OCCUPANCY = 2;

    private static final String DEFAULT_ACCESSIBLE_YN = "AAAAAAAAAA";
    private static final String UPDATED_ACCESSIBLE_YN = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/resort-room-categories";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ResortRoomCategoryRepository resortRoomCategoryRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restResortRoomCategoryMockMvc;

    private ResortRoomCategory resortRoomCategory;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ResortRoomCategory createEntity(EntityManager em) {
        ResortRoomCategory resortRoomCategory = new ResortRoomCategory()
            .resort(DEFAULT_RESORT)
            .roomCategory(DEFAULT_ROOM_CATEGORY)
            .roomClass(DEFAULT_ROOM_CLASS)
            .numberRooms(DEFAULT_NUMBER_ROOMS)
            .shortDescription(DEFAULT_SHORT_DESCRIPTION)
            .longDescription(DEFAULT_LONG_DESCRIPTION)
            .compiled(DEFAULT_COMPILED)
            .psuedoRoomType(DEFAULT_PSUEDO_ROOM_TYPE)
            .activeDate(DEFAULT_ACTIVE_DATE)
            .inactiveDate(DEFAULT_INACTIVE_DATE)
            .replacesCategory(DEFAULT_REPLACES_CATEGORY)
            .orderBy(DEFAULT_ORDER_BY)
            .maxOccupancy(DEFAULT_MAX_OCCUPANCY)
            .maxRollaways(DEFAULT_MAX_ROLLAWAYS)
            .rateCategory(DEFAULT_RATE_CATEGORY)
            .label(DEFAULT_LABEL)
            .genericFlag(DEFAULT_GENERIC_FLAG)
            .suiteYn(DEFAULT_SUITE_YN)
            .meetingroomYn(DEFAULT_MEETINGROOM_YN)
            .insertUser(DEFAULT_INSERT_USER)
            .insertDate(DEFAULT_INSERT_DATE)
            .updateUser(DEFAULT_UPDATE_USER)
            .updateDate(DEFAULT_UPDATE_DATE)
            .rateCode(DEFAULT_RATE_CODE)
            .rateAmount(DEFAULT_RATE_AMOUNT)
            .defOccupancy(DEFAULT_DEF_OCCUPANCY)
            .imageId(DEFAULT_IMAGE_ID)
            .pseudoYn(DEFAULT_PSEUDO_YN)
            .sendToInterfaceYn(DEFAULT_SEND_TO_INTERFACE_YN)
            .yieldableYn(DEFAULT_YIELDABLE_YN)
            .yieldCategory(DEFAULT_YIELD_CATEGORY)
            .housekeeping(DEFAULT_HOUSEKEEPING)
            .canDeleteYn(DEFAULT_CAN_DELETE_YN)
            .roominfoUrl(DEFAULT_ROOMINFO_URL)
            .ownerYn(DEFAULT_OWNER_YN)
            .autoIncludeYn(DEFAULT_AUTO_INCLUDE_YN)
            .initialRoundUp(DEFAULT_INITIAL_ROUND_UP)
            .increments(DEFAULT_INCREMENTS)
            .rotationGroup(DEFAULT_ROTATION_GROUP)
            .salesFlag(DEFAULT_SALES_FLAG)
            .autoRoomAssignYn(DEFAULT_AUTO_ROOM_ASSIGN_YN)
            .upsellYn(DEFAULT_UPSELL_YN)
            .ormsUpsellRank(DEFAULT_ORMS_UPSELL_RANK)
            .ormsUpsellAmt(DEFAULT_ORMS_UPSELL_AMT)
            .ormsDrxtraAdult(DEFAULT_ORMS_DRXTRA_ADULT)
            .ormsDrxtraChild(DEFAULT_ORMS_DRXTRA_CHILD)
            .maxOccupancyAdults(DEFAULT_MAX_OCCUPANCY_ADULTS)
            .maxOccupancyChildren(DEFAULT_MAX_OCCUPANCY_CHILDREN)
            .roomPool(DEFAULT_ROOM_POOL)
            .memberAwardRoomGrp(DEFAULT_MEMBER_AWARD_ROOM_GRP)
            .ormsDrxtra2ndAdult(DEFAULT_ORMS_DRXTRA_2ND_ADULT)
            .ormsDrtier1(DEFAULT_ORMS_DRTIER_1)
            .ormsDrtier2(DEFAULT_ORMS_DRTIER_2)
            .ormsDrtier3(DEFAULT_ORMS_DRTIER_3)
            .autoCheckinYn(DEFAULT_AUTO_CHECKIN_YN)
            .rateFloor(DEFAULT_RATE_FLOOR)
            .maxFixBedOccupancy(DEFAULT_MAX_FIX_BED_OCCUPANCY)
            .maintenanceYn(DEFAULT_MAINTENANCE_YN)
            .smokingPreference(DEFAULT_SMOKING_PREFERENCE)
            .sLabel(DEFAULT_S_LABEL)
            .sBedtype(DEFAULT_S_BEDTYPE)
            .sellThruRuleYn(DEFAULT_SELL_THRU_RULE_YN)
            .crsDescription(DEFAULT_CRS_DESCRIPTION)
            .evisitorFacilityId(DEFAULT_EVISITOR_FACILITY_ID)
            .minOccupancy(DEFAULT_MIN_OCCUPANCY)
            .accessibleYn(DEFAULT_ACCESSIBLE_YN);
        return resortRoomCategory;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ResortRoomCategory createUpdatedEntity(EntityManager em) {
        ResortRoomCategory resortRoomCategory = new ResortRoomCategory()
            .resort(UPDATED_RESORT)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .roomClass(UPDATED_ROOM_CLASS)
            .numberRooms(UPDATED_NUMBER_ROOMS)
            .shortDescription(UPDATED_SHORT_DESCRIPTION)
            .longDescription(UPDATED_LONG_DESCRIPTION)
            .compiled(UPDATED_COMPILED)
            .psuedoRoomType(UPDATED_PSUEDO_ROOM_TYPE)
            .activeDate(UPDATED_ACTIVE_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .replacesCategory(UPDATED_REPLACES_CATEGORY)
            .orderBy(UPDATED_ORDER_BY)
            .maxOccupancy(UPDATED_MAX_OCCUPANCY)
            .maxRollaways(UPDATED_MAX_ROLLAWAYS)
            .rateCategory(UPDATED_RATE_CATEGORY)
            .label(UPDATED_LABEL)
            .genericFlag(UPDATED_GENERIC_FLAG)
            .suiteYn(UPDATED_SUITE_YN)
            .meetingroomYn(UPDATED_MEETINGROOM_YN)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .rateCode(UPDATED_RATE_CODE)
            .rateAmount(UPDATED_RATE_AMOUNT)
            .defOccupancy(UPDATED_DEF_OCCUPANCY)
            .imageId(UPDATED_IMAGE_ID)
            .pseudoYn(UPDATED_PSEUDO_YN)
            .sendToInterfaceYn(UPDATED_SEND_TO_INTERFACE_YN)
            .yieldableYn(UPDATED_YIELDABLE_YN)
            .yieldCategory(UPDATED_YIELD_CATEGORY)
            .housekeeping(UPDATED_HOUSEKEEPING)
            .canDeleteYn(UPDATED_CAN_DELETE_YN)
            .roominfoUrl(UPDATED_ROOMINFO_URL)
            .ownerYn(UPDATED_OWNER_YN)
            .autoIncludeYn(UPDATED_AUTO_INCLUDE_YN)
            .initialRoundUp(UPDATED_INITIAL_ROUND_UP)
            .increments(UPDATED_INCREMENTS)
            .rotationGroup(UPDATED_ROTATION_GROUP)
            .salesFlag(UPDATED_SALES_FLAG)
            .autoRoomAssignYn(UPDATED_AUTO_ROOM_ASSIGN_YN)
            .upsellYn(UPDATED_UPSELL_YN)
            .ormsUpsellRank(UPDATED_ORMS_UPSELL_RANK)
            .ormsUpsellAmt(UPDATED_ORMS_UPSELL_AMT)
            .ormsDrxtraAdult(UPDATED_ORMS_DRXTRA_ADULT)
            .ormsDrxtraChild(UPDATED_ORMS_DRXTRA_CHILD)
            .maxOccupancyAdults(UPDATED_MAX_OCCUPANCY_ADULTS)
            .maxOccupancyChildren(UPDATED_MAX_OCCUPANCY_CHILDREN)
            .roomPool(UPDATED_ROOM_POOL)
            .memberAwardRoomGrp(UPDATED_MEMBER_AWARD_ROOM_GRP)
            .ormsDrxtra2ndAdult(UPDATED_ORMS_DRXTRA_2ND_ADULT)
            .ormsDrtier1(UPDATED_ORMS_DRTIER_1)
            .ormsDrtier2(UPDATED_ORMS_DRTIER_2)
            .ormsDrtier3(UPDATED_ORMS_DRTIER_3)
            .autoCheckinYn(UPDATED_AUTO_CHECKIN_YN)
            .rateFloor(UPDATED_RATE_FLOOR)
            .maxFixBedOccupancy(UPDATED_MAX_FIX_BED_OCCUPANCY)
            .maintenanceYn(UPDATED_MAINTENANCE_YN)
            .smokingPreference(UPDATED_SMOKING_PREFERENCE)
            .sLabel(UPDATED_S_LABEL)
            .sBedtype(UPDATED_S_BEDTYPE)
            .sellThruRuleYn(UPDATED_SELL_THRU_RULE_YN)
            .crsDescription(UPDATED_CRS_DESCRIPTION)
            .evisitorFacilityId(UPDATED_EVISITOR_FACILITY_ID)
            .minOccupancy(UPDATED_MIN_OCCUPANCY)
            .accessibleYn(UPDATED_ACCESSIBLE_YN);
        return resortRoomCategory;
    }

    @BeforeEach
    public void initTest() {
        resortRoomCategory = createEntity(em);
    }

    @Test
    @Transactional
    void createResortRoomCategory() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ResortRoomCategory
        var returnedResortRoomCategory = om.readValue(
            restResortRoomCategoryMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(resortRoomCategory)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ResortRoomCategory.class
        );

        // Validate the ResortRoomCategory in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertResortRoomCategoryUpdatableFieldsEquals(
            returnedResortRoomCategory,
            getPersistedResortRoomCategory(returnedResortRoomCategory)
        );
    }

    @Test
    @Transactional
    void createResortRoomCategoryWithExistingId() throws Exception {
        // Create the ResortRoomCategory with an existing ID
        resortRoomCategory.setId(1L);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restResortRoomCategoryMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(resortRoomCategory)))
            .andExpect(status().isBadRequest());

        // Validate the ResortRoomCategory in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllResortRoomCategories() throws Exception {
        // Initialize the database
        resortRoomCategoryRepository.saveAndFlush(resortRoomCategory);

        // Get all the resortRoomCategoryList
        restResortRoomCategoryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(resortRoomCategory.getId().intValue())))
            .andExpect(jsonPath("$.[*].resort").value(hasItem(DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].roomCategory").value(hasItem(DEFAULT_ROOM_CATEGORY)))
            .andExpect(jsonPath("$.[*].roomClass").value(hasItem(DEFAULT_ROOM_CLASS)))
            .andExpect(jsonPath("$.[*].numberRooms").value(hasItem(DEFAULT_NUMBER_ROOMS)))
            .andExpect(jsonPath("$.[*].shortDescription").value(hasItem(DEFAULT_SHORT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].longDescription").value(hasItem(DEFAULT_LONG_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].compiled").value(hasItem(DEFAULT_COMPILED)))
            .andExpect(jsonPath("$.[*].psuedoRoomType").value(hasItem(DEFAULT_PSUEDO_ROOM_TYPE)))
            .andExpect(jsonPath("$.[*].activeDate").value(hasItem(DEFAULT_ACTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].inactiveDate").value(hasItem(DEFAULT_INACTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].replacesCategory").value(hasItem(DEFAULT_REPLACES_CATEGORY)))
            .andExpect(jsonPath("$.[*].orderBy").value(hasItem(DEFAULT_ORDER_BY)))
            .andExpect(jsonPath("$.[*].maxOccupancy").value(hasItem(DEFAULT_MAX_OCCUPANCY)))
            .andExpect(jsonPath("$.[*].maxRollaways").value(hasItem(DEFAULT_MAX_ROLLAWAYS)))
            .andExpect(jsonPath("$.[*].rateCategory").value(hasItem(DEFAULT_RATE_CATEGORY)))
            .andExpect(jsonPath("$.[*].label").value(hasItem(DEFAULT_LABEL)))
            .andExpect(jsonPath("$.[*].genericFlag").value(hasItem(DEFAULT_GENERIC_FLAG)))
            .andExpect(jsonPath("$.[*].suiteYn").value(hasItem(DEFAULT_SUITE_YN)))
            .andExpect(jsonPath("$.[*].meetingroomYn").value(hasItem(DEFAULT_MEETINGROOM_YN)))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].rateCode").value(hasItem(DEFAULT_RATE_CODE)))
            .andExpect(jsonPath("$.[*].rateAmount").value(hasItem(sameNumber(DEFAULT_RATE_AMOUNT))))
            .andExpect(jsonPath("$.[*].defOccupancy").value(hasItem(DEFAULT_DEF_OCCUPANCY)))
            .andExpect(jsonPath("$.[*].imageId").value(hasItem(DEFAULT_IMAGE_ID)))
            .andExpect(jsonPath("$.[*].pseudoYn").value(hasItem(DEFAULT_PSEUDO_YN)))
            .andExpect(jsonPath("$.[*].sendToInterfaceYn").value(hasItem(DEFAULT_SEND_TO_INTERFACE_YN)))
            .andExpect(jsonPath("$.[*].yieldableYn").value(hasItem(DEFAULT_YIELDABLE_YN)))
            .andExpect(jsonPath("$.[*].yieldCategory").value(hasItem(DEFAULT_YIELD_CATEGORY)))
            .andExpect(jsonPath("$.[*].housekeeping").value(hasItem(DEFAULT_HOUSEKEEPING)))
            .andExpect(jsonPath("$.[*].canDeleteYn").value(hasItem(DEFAULT_CAN_DELETE_YN)))
            .andExpect(jsonPath("$.[*].roominfoUrl").value(hasItem(DEFAULT_ROOMINFO_URL)))
            .andExpect(jsonPath("$.[*].ownerYn").value(hasItem(DEFAULT_OWNER_YN)))
            .andExpect(jsonPath("$.[*].autoIncludeYn").value(hasItem(DEFAULT_AUTO_INCLUDE_YN)))
            .andExpect(jsonPath("$.[*].initialRoundUp").value(hasItem(DEFAULT_INITIAL_ROUND_UP)))
            .andExpect(jsonPath("$.[*].increments").value(hasItem(DEFAULT_INCREMENTS)))
            .andExpect(jsonPath("$.[*].rotationGroup").value(hasItem(DEFAULT_ROTATION_GROUP)))
            .andExpect(jsonPath("$.[*].salesFlag").value(hasItem(DEFAULT_SALES_FLAG)))
            .andExpect(jsonPath("$.[*].autoRoomAssignYn").value(hasItem(DEFAULT_AUTO_ROOM_ASSIGN_YN)))
            .andExpect(jsonPath("$.[*].upsellYn").value(hasItem(DEFAULT_UPSELL_YN)))
            .andExpect(jsonPath("$.[*].ormsUpsellRank").value(hasItem(DEFAULT_ORMS_UPSELL_RANK)))
            .andExpect(jsonPath("$.[*].ormsUpsellAmt").value(hasItem(sameNumber(DEFAULT_ORMS_UPSELL_AMT))))
            .andExpect(jsonPath("$.[*].ormsDrxtraAdult").value(hasItem(DEFAULT_ORMS_DRXTRA_ADULT)))
            .andExpect(jsonPath("$.[*].ormsDrxtraChild").value(hasItem(DEFAULT_ORMS_DRXTRA_CHILD)))
            .andExpect(jsonPath("$.[*].maxOccupancyAdults").value(hasItem(DEFAULT_MAX_OCCUPANCY_ADULTS)))
            .andExpect(jsonPath("$.[*].maxOccupancyChildren").value(hasItem(DEFAULT_MAX_OCCUPANCY_CHILDREN)))
            .andExpect(jsonPath("$.[*].roomPool").value(hasItem(DEFAULT_ROOM_POOL)))
            .andExpect(jsonPath("$.[*].memberAwardRoomGrp").value(hasItem(DEFAULT_MEMBER_AWARD_ROOM_GRP)))
            .andExpect(jsonPath("$.[*].ormsDrxtra2ndAdult").value(hasItem(DEFAULT_ORMS_DRXTRA_2ND_ADULT)))
            .andExpect(jsonPath("$.[*].ormsDrtier1").value(hasItem(DEFAULT_ORMS_DRTIER_1)))
            .andExpect(jsonPath("$.[*].ormsDrtier2").value(hasItem(DEFAULT_ORMS_DRTIER_2)))
            .andExpect(jsonPath("$.[*].ormsDrtier3").value(hasItem(DEFAULT_ORMS_DRTIER_3)))
            .andExpect(jsonPath("$.[*].autoCheckinYn").value(hasItem(DEFAULT_AUTO_CHECKIN_YN)))
            .andExpect(jsonPath("$.[*].rateFloor").value(hasItem(sameNumber(DEFAULT_RATE_FLOOR))))
            .andExpect(jsonPath("$.[*].maxFixBedOccupancy").value(hasItem(DEFAULT_MAX_FIX_BED_OCCUPANCY)))
            .andExpect(jsonPath("$.[*].maintenanceYn").value(hasItem(DEFAULT_MAINTENANCE_YN)))
            .andExpect(jsonPath("$.[*].smokingPreference").value(hasItem(DEFAULT_SMOKING_PREFERENCE)))
            .andExpect(jsonPath("$.[*].sLabel").value(hasItem(DEFAULT_S_LABEL)))
            .andExpect(jsonPath("$.[*].sBedtype").value(hasItem(DEFAULT_S_BEDTYPE)))
            .andExpect(jsonPath("$.[*].sellThruRuleYn").value(hasItem(DEFAULT_SELL_THRU_RULE_YN)))
            .andExpect(jsonPath("$.[*].crsDescription").value(hasItem(DEFAULT_CRS_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].evisitorFacilityId").value(hasItem(DEFAULT_EVISITOR_FACILITY_ID)))
            .andExpect(jsonPath("$.[*].minOccupancy").value(hasItem(DEFAULT_MIN_OCCUPANCY)))
            .andExpect(jsonPath("$.[*].accessibleYn").value(hasItem(DEFAULT_ACCESSIBLE_YN)));
    }

    @Test
    @Transactional
    void getResortRoomCategory() throws Exception {
        // Initialize the database
        resortRoomCategoryRepository.saveAndFlush(resortRoomCategory);

        // Get the resortRoomCategory
        restResortRoomCategoryMockMvc
            .perform(get(ENTITY_API_URL_ID, resortRoomCategory.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(resortRoomCategory.getId().intValue()))
            .andExpect(jsonPath("$.resort").value(DEFAULT_RESORT))
            .andExpect(jsonPath("$.roomCategory").value(DEFAULT_ROOM_CATEGORY))
            .andExpect(jsonPath("$.roomClass").value(DEFAULT_ROOM_CLASS))
            .andExpect(jsonPath("$.numberRooms").value(DEFAULT_NUMBER_ROOMS))
            .andExpect(jsonPath("$.shortDescription").value(DEFAULT_SHORT_DESCRIPTION))
            .andExpect(jsonPath("$.longDescription").value(DEFAULT_LONG_DESCRIPTION))
            .andExpect(jsonPath("$.compiled").value(DEFAULT_COMPILED))
            .andExpect(jsonPath("$.psuedoRoomType").value(DEFAULT_PSUEDO_ROOM_TYPE))
            .andExpect(jsonPath("$.activeDate").value(DEFAULT_ACTIVE_DATE.toString()))
            .andExpect(jsonPath("$.inactiveDate").value(DEFAULT_INACTIVE_DATE.toString()))
            .andExpect(jsonPath("$.replacesCategory").value(DEFAULT_REPLACES_CATEGORY))
            .andExpect(jsonPath("$.orderBy").value(DEFAULT_ORDER_BY))
            .andExpect(jsonPath("$.maxOccupancy").value(DEFAULT_MAX_OCCUPANCY))
            .andExpect(jsonPath("$.maxRollaways").value(DEFAULT_MAX_ROLLAWAYS))
            .andExpect(jsonPath("$.rateCategory").value(DEFAULT_RATE_CATEGORY))
            .andExpect(jsonPath("$.label").value(DEFAULT_LABEL))
            .andExpect(jsonPath("$.genericFlag").value(DEFAULT_GENERIC_FLAG))
            .andExpect(jsonPath("$.suiteYn").value(DEFAULT_SUITE_YN))
            .andExpect(jsonPath("$.meetingroomYn").value(DEFAULT_MEETINGROOM_YN))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.rateCode").value(DEFAULT_RATE_CODE))
            .andExpect(jsonPath("$.rateAmount").value(sameNumber(DEFAULT_RATE_AMOUNT)))
            .andExpect(jsonPath("$.defOccupancy").value(DEFAULT_DEF_OCCUPANCY))
            .andExpect(jsonPath("$.imageId").value(DEFAULT_IMAGE_ID))
            .andExpect(jsonPath("$.pseudoYn").value(DEFAULT_PSEUDO_YN))
            .andExpect(jsonPath("$.sendToInterfaceYn").value(DEFAULT_SEND_TO_INTERFACE_YN))
            .andExpect(jsonPath("$.yieldableYn").value(DEFAULT_YIELDABLE_YN))
            .andExpect(jsonPath("$.yieldCategory").value(DEFAULT_YIELD_CATEGORY))
            .andExpect(jsonPath("$.housekeeping").value(DEFAULT_HOUSEKEEPING))
            .andExpect(jsonPath("$.canDeleteYn").value(DEFAULT_CAN_DELETE_YN))
            .andExpect(jsonPath("$.roominfoUrl").value(DEFAULT_ROOMINFO_URL))
            .andExpect(jsonPath("$.ownerYn").value(DEFAULT_OWNER_YN))
            .andExpect(jsonPath("$.autoIncludeYn").value(DEFAULT_AUTO_INCLUDE_YN))
            .andExpect(jsonPath("$.initialRoundUp").value(DEFAULT_INITIAL_ROUND_UP))
            .andExpect(jsonPath("$.increments").value(DEFAULT_INCREMENTS))
            .andExpect(jsonPath("$.rotationGroup").value(DEFAULT_ROTATION_GROUP))
            .andExpect(jsonPath("$.salesFlag").value(DEFAULT_SALES_FLAG))
            .andExpect(jsonPath("$.autoRoomAssignYn").value(DEFAULT_AUTO_ROOM_ASSIGN_YN))
            .andExpect(jsonPath("$.upsellYn").value(DEFAULT_UPSELL_YN))
            .andExpect(jsonPath("$.ormsUpsellRank").value(DEFAULT_ORMS_UPSELL_RANK))
            .andExpect(jsonPath("$.ormsUpsellAmt").value(sameNumber(DEFAULT_ORMS_UPSELL_AMT)))
            .andExpect(jsonPath("$.ormsDrxtraAdult").value(DEFAULT_ORMS_DRXTRA_ADULT))
            .andExpect(jsonPath("$.ormsDrxtraChild").value(DEFAULT_ORMS_DRXTRA_CHILD))
            .andExpect(jsonPath("$.maxOccupancyAdults").value(DEFAULT_MAX_OCCUPANCY_ADULTS))
            .andExpect(jsonPath("$.maxOccupancyChildren").value(DEFAULT_MAX_OCCUPANCY_CHILDREN))
            .andExpect(jsonPath("$.roomPool").value(DEFAULT_ROOM_POOL))
            .andExpect(jsonPath("$.memberAwardRoomGrp").value(DEFAULT_MEMBER_AWARD_ROOM_GRP))
            .andExpect(jsonPath("$.ormsDrxtra2ndAdult").value(DEFAULT_ORMS_DRXTRA_2ND_ADULT))
            .andExpect(jsonPath("$.ormsDrtier1").value(DEFAULT_ORMS_DRTIER_1))
            .andExpect(jsonPath("$.ormsDrtier2").value(DEFAULT_ORMS_DRTIER_2))
            .andExpect(jsonPath("$.ormsDrtier3").value(DEFAULT_ORMS_DRTIER_3))
            .andExpect(jsonPath("$.autoCheckinYn").value(DEFAULT_AUTO_CHECKIN_YN))
            .andExpect(jsonPath("$.rateFloor").value(sameNumber(DEFAULT_RATE_FLOOR)))
            .andExpect(jsonPath("$.maxFixBedOccupancy").value(DEFAULT_MAX_FIX_BED_OCCUPANCY))
            .andExpect(jsonPath("$.maintenanceYn").value(DEFAULT_MAINTENANCE_YN))
            .andExpect(jsonPath("$.smokingPreference").value(DEFAULT_SMOKING_PREFERENCE))
            .andExpect(jsonPath("$.sLabel").value(DEFAULT_S_LABEL))
            .andExpect(jsonPath("$.sBedtype").value(DEFAULT_S_BEDTYPE))
            .andExpect(jsonPath("$.sellThruRuleYn").value(DEFAULT_SELL_THRU_RULE_YN))
            .andExpect(jsonPath("$.crsDescription").value(DEFAULT_CRS_DESCRIPTION))
            .andExpect(jsonPath("$.evisitorFacilityId").value(DEFAULT_EVISITOR_FACILITY_ID))
            .andExpect(jsonPath("$.minOccupancy").value(DEFAULT_MIN_OCCUPANCY))
            .andExpect(jsonPath("$.accessibleYn").value(DEFAULT_ACCESSIBLE_YN));
    }

    @Test
    @Transactional
    void getNonExistingResortRoomCategory() throws Exception {
        // Get the resortRoomCategory
        restResortRoomCategoryMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingResortRoomCategory() throws Exception {
        // Initialize the database
        resortRoomCategoryRepository.saveAndFlush(resortRoomCategory);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the resortRoomCategory
        ResortRoomCategory updatedResortRoomCategory = resortRoomCategoryRepository.findById(resortRoomCategory.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedResortRoomCategory are not directly saved in db
        em.detach(updatedResortRoomCategory);
        updatedResortRoomCategory
            .resort(UPDATED_RESORT)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .roomClass(UPDATED_ROOM_CLASS)
            .numberRooms(UPDATED_NUMBER_ROOMS)
            .shortDescription(UPDATED_SHORT_DESCRIPTION)
            .longDescription(UPDATED_LONG_DESCRIPTION)
            .compiled(UPDATED_COMPILED)
            .psuedoRoomType(UPDATED_PSUEDO_ROOM_TYPE)
            .activeDate(UPDATED_ACTIVE_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .replacesCategory(UPDATED_REPLACES_CATEGORY)
            .orderBy(UPDATED_ORDER_BY)
            .maxOccupancy(UPDATED_MAX_OCCUPANCY)
            .maxRollaways(UPDATED_MAX_ROLLAWAYS)
            .rateCategory(UPDATED_RATE_CATEGORY)
            .label(UPDATED_LABEL)
            .genericFlag(UPDATED_GENERIC_FLAG)
            .suiteYn(UPDATED_SUITE_YN)
            .meetingroomYn(UPDATED_MEETINGROOM_YN)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .rateCode(UPDATED_RATE_CODE)
            .rateAmount(UPDATED_RATE_AMOUNT)
            .defOccupancy(UPDATED_DEF_OCCUPANCY)
            .imageId(UPDATED_IMAGE_ID)
            .pseudoYn(UPDATED_PSEUDO_YN)
            .sendToInterfaceYn(UPDATED_SEND_TO_INTERFACE_YN)
            .yieldableYn(UPDATED_YIELDABLE_YN)
            .yieldCategory(UPDATED_YIELD_CATEGORY)
            .housekeeping(UPDATED_HOUSEKEEPING)
            .canDeleteYn(UPDATED_CAN_DELETE_YN)
            .roominfoUrl(UPDATED_ROOMINFO_URL)
            .ownerYn(UPDATED_OWNER_YN)
            .autoIncludeYn(UPDATED_AUTO_INCLUDE_YN)
            .initialRoundUp(UPDATED_INITIAL_ROUND_UP)
            .increments(UPDATED_INCREMENTS)
            .rotationGroup(UPDATED_ROTATION_GROUP)
            .salesFlag(UPDATED_SALES_FLAG)
            .autoRoomAssignYn(UPDATED_AUTO_ROOM_ASSIGN_YN)
            .upsellYn(UPDATED_UPSELL_YN)
            .ormsUpsellRank(UPDATED_ORMS_UPSELL_RANK)
            .ormsUpsellAmt(UPDATED_ORMS_UPSELL_AMT)
            .ormsDrxtraAdult(UPDATED_ORMS_DRXTRA_ADULT)
            .ormsDrxtraChild(UPDATED_ORMS_DRXTRA_CHILD)
            .maxOccupancyAdults(UPDATED_MAX_OCCUPANCY_ADULTS)
            .maxOccupancyChildren(UPDATED_MAX_OCCUPANCY_CHILDREN)
            .roomPool(UPDATED_ROOM_POOL)
            .memberAwardRoomGrp(UPDATED_MEMBER_AWARD_ROOM_GRP)
            .ormsDrxtra2ndAdult(UPDATED_ORMS_DRXTRA_2ND_ADULT)
            .ormsDrtier1(UPDATED_ORMS_DRTIER_1)
            .ormsDrtier2(UPDATED_ORMS_DRTIER_2)
            .ormsDrtier3(UPDATED_ORMS_DRTIER_3)
            .autoCheckinYn(UPDATED_AUTO_CHECKIN_YN)
            .rateFloor(UPDATED_RATE_FLOOR)
            .maxFixBedOccupancy(UPDATED_MAX_FIX_BED_OCCUPANCY)
            .maintenanceYn(UPDATED_MAINTENANCE_YN)
            .smokingPreference(UPDATED_SMOKING_PREFERENCE)
            .sLabel(UPDATED_S_LABEL)
            .sBedtype(UPDATED_S_BEDTYPE)
            .sellThruRuleYn(UPDATED_SELL_THRU_RULE_YN)
            .crsDescription(UPDATED_CRS_DESCRIPTION)
            .evisitorFacilityId(UPDATED_EVISITOR_FACILITY_ID)
            .minOccupancy(UPDATED_MIN_OCCUPANCY)
            .accessibleYn(UPDATED_ACCESSIBLE_YN);

        restResortRoomCategoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedResortRoomCategory.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedResortRoomCategory))
            )
            .andExpect(status().isOk());

        // Validate the ResortRoomCategory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedResortRoomCategoryToMatchAllProperties(updatedResortRoomCategory);
    }

    @Test
    @Transactional
    void putNonExistingResortRoomCategory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortRoomCategory.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restResortRoomCategoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, resortRoomCategory.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(resortRoomCategory))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResortRoomCategory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchResortRoomCategory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortRoomCategory.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortRoomCategoryMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(resortRoomCategory))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResortRoomCategory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamResortRoomCategory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortRoomCategory.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortRoomCategoryMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(resortRoomCategory)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ResortRoomCategory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateResortRoomCategoryWithPatch() throws Exception {
        // Initialize the database
        resortRoomCategoryRepository.saveAndFlush(resortRoomCategory);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the resortRoomCategory using partial update
        ResortRoomCategory partialUpdatedResortRoomCategory = new ResortRoomCategory();
        partialUpdatedResortRoomCategory.setId(resortRoomCategory.getId());

        partialUpdatedResortRoomCategory
            .resort(UPDATED_RESORT)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .psuedoRoomType(UPDATED_PSUEDO_ROOM_TYPE)
            .orderBy(UPDATED_ORDER_BY)
            .maxOccupancy(UPDATED_MAX_OCCUPANCY)
            .maxRollaways(UPDATED_MAX_ROLLAWAYS)
            .suiteYn(UPDATED_SUITE_YN)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .imageId(UPDATED_IMAGE_ID)
            .pseudoYn(UPDATED_PSEUDO_YN)
            .sendToInterfaceYn(UPDATED_SEND_TO_INTERFACE_YN)
            .yieldCategory(UPDATED_YIELD_CATEGORY)
            .autoIncludeYn(UPDATED_AUTO_INCLUDE_YN)
            .initialRoundUp(UPDATED_INITIAL_ROUND_UP)
            .increments(UPDATED_INCREMENTS)
            .rotationGroup(UPDATED_ROTATION_GROUP)
            .upsellYn(UPDATED_UPSELL_YN)
            .ormsUpsellRank(UPDATED_ORMS_UPSELL_RANK)
            .ormsUpsellAmt(UPDATED_ORMS_UPSELL_AMT)
            .ormsDrxtraChild(UPDATED_ORMS_DRXTRA_CHILD)
            .maxOccupancyAdults(UPDATED_MAX_OCCUPANCY_ADULTS)
            .roomPool(UPDATED_ROOM_POOL)
            .memberAwardRoomGrp(UPDATED_MEMBER_AWARD_ROOM_GRP)
            .rateFloor(UPDATED_RATE_FLOOR)
            .maintenanceYn(UPDATED_MAINTENANCE_YN)
            .smokingPreference(UPDATED_SMOKING_PREFERENCE)
            .sBedtype(UPDATED_S_BEDTYPE)
            .sellThruRuleYn(UPDATED_SELL_THRU_RULE_YN)
            .crsDescription(UPDATED_CRS_DESCRIPTION)
            .evisitorFacilityId(UPDATED_EVISITOR_FACILITY_ID)
            .accessibleYn(UPDATED_ACCESSIBLE_YN);

        restResortRoomCategoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedResortRoomCategory.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedResortRoomCategory))
            )
            .andExpect(status().isOk());

        // Validate the ResortRoomCategory in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertResortRoomCategoryUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedResortRoomCategory, resortRoomCategory),
            getPersistedResortRoomCategory(resortRoomCategory)
        );
    }

    @Test
    @Transactional
    void fullUpdateResortRoomCategoryWithPatch() throws Exception {
        // Initialize the database
        resortRoomCategoryRepository.saveAndFlush(resortRoomCategory);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the resortRoomCategory using partial update
        ResortRoomCategory partialUpdatedResortRoomCategory = new ResortRoomCategory();
        partialUpdatedResortRoomCategory.setId(resortRoomCategory.getId());

        partialUpdatedResortRoomCategory
            .resort(UPDATED_RESORT)
            .roomCategory(UPDATED_ROOM_CATEGORY)
            .roomClass(UPDATED_ROOM_CLASS)
            .numberRooms(UPDATED_NUMBER_ROOMS)
            .shortDescription(UPDATED_SHORT_DESCRIPTION)
            .longDescription(UPDATED_LONG_DESCRIPTION)
            .compiled(UPDATED_COMPILED)
            .psuedoRoomType(UPDATED_PSUEDO_ROOM_TYPE)
            .activeDate(UPDATED_ACTIVE_DATE)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .replacesCategory(UPDATED_REPLACES_CATEGORY)
            .orderBy(UPDATED_ORDER_BY)
            .maxOccupancy(UPDATED_MAX_OCCUPANCY)
            .maxRollaways(UPDATED_MAX_ROLLAWAYS)
            .rateCategory(UPDATED_RATE_CATEGORY)
            .label(UPDATED_LABEL)
            .genericFlag(UPDATED_GENERIC_FLAG)
            .suiteYn(UPDATED_SUITE_YN)
            .meetingroomYn(UPDATED_MEETINGROOM_YN)
            .insertUser(UPDATED_INSERT_USER)
            .insertDate(UPDATED_INSERT_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .rateCode(UPDATED_RATE_CODE)
            .rateAmount(UPDATED_RATE_AMOUNT)
            .defOccupancy(UPDATED_DEF_OCCUPANCY)
            .imageId(UPDATED_IMAGE_ID)
            .pseudoYn(UPDATED_PSEUDO_YN)
            .sendToInterfaceYn(UPDATED_SEND_TO_INTERFACE_YN)
            .yieldableYn(UPDATED_YIELDABLE_YN)
            .yieldCategory(UPDATED_YIELD_CATEGORY)
            .housekeeping(UPDATED_HOUSEKEEPING)
            .canDeleteYn(UPDATED_CAN_DELETE_YN)
            .roominfoUrl(UPDATED_ROOMINFO_URL)
            .ownerYn(UPDATED_OWNER_YN)
            .autoIncludeYn(UPDATED_AUTO_INCLUDE_YN)
            .initialRoundUp(UPDATED_INITIAL_ROUND_UP)
            .increments(UPDATED_INCREMENTS)
            .rotationGroup(UPDATED_ROTATION_GROUP)
            .salesFlag(UPDATED_SALES_FLAG)
            .autoRoomAssignYn(UPDATED_AUTO_ROOM_ASSIGN_YN)
            .upsellYn(UPDATED_UPSELL_YN)
            .ormsUpsellRank(UPDATED_ORMS_UPSELL_RANK)
            .ormsUpsellAmt(UPDATED_ORMS_UPSELL_AMT)
            .ormsDrxtraAdult(UPDATED_ORMS_DRXTRA_ADULT)
            .ormsDrxtraChild(UPDATED_ORMS_DRXTRA_CHILD)
            .maxOccupancyAdults(UPDATED_MAX_OCCUPANCY_ADULTS)
            .maxOccupancyChildren(UPDATED_MAX_OCCUPANCY_CHILDREN)
            .roomPool(UPDATED_ROOM_POOL)
            .memberAwardRoomGrp(UPDATED_MEMBER_AWARD_ROOM_GRP)
            .ormsDrxtra2ndAdult(UPDATED_ORMS_DRXTRA_2ND_ADULT)
            .ormsDrtier1(UPDATED_ORMS_DRTIER_1)
            .ormsDrtier2(UPDATED_ORMS_DRTIER_2)
            .ormsDrtier3(UPDATED_ORMS_DRTIER_3)
            .autoCheckinYn(UPDATED_AUTO_CHECKIN_YN)
            .rateFloor(UPDATED_RATE_FLOOR)
            .maxFixBedOccupancy(UPDATED_MAX_FIX_BED_OCCUPANCY)
            .maintenanceYn(UPDATED_MAINTENANCE_YN)
            .smokingPreference(UPDATED_SMOKING_PREFERENCE)
            .sLabel(UPDATED_S_LABEL)
            .sBedtype(UPDATED_S_BEDTYPE)
            .sellThruRuleYn(UPDATED_SELL_THRU_RULE_YN)
            .crsDescription(UPDATED_CRS_DESCRIPTION)
            .evisitorFacilityId(UPDATED_EVISITOR_FACILITY_ID)
            .minOccupancy(UPDATED_MIN_OCCUPANCY)
            .accessibleYn(UPDATED_ACCESSIBLE_YN);

        restResortRoomCategoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedResortRoomCategory.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedResortRoomCategory))
            )
            .andExpect(status().isOk());

        // Validate the ResortRoomCategory in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertResortRoomCategoryUpdatableFieldsEquals(
            partialUpdatedResortRoomCategory,
            getPersistedResortRoomCategory(partialUpdatedResortRoomCategory)
        );
    }

    @Test
    @Transactional
    void patchNonExistingResortRoomCategory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortRoomCategory.setId(longCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restResortRoomCategoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, resortRoomCategory.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(resortRoomCategory))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResortRoomCategory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchResortRoomCategory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortRoomCategory.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortRoomCategoryMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(resortRoomCategory))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResortRoomCategory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamResortRoomCategory() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        resortRoomCategory.setId(longCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResortRoomCategoryMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(resortRoomCategory)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ResortRoomCategory in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteResortRoomCategory() throws Exception {
        // Initialize the database
        resortRoomCategoryRepository.saveAndFlush(resortRoomCategory);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the resortRoomCategory
        restResortRoomCategoryMockMvc
            .perform(delete(ENTITY_API_URL_ID, resortRoomCategory.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return resortRoomCategoryRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected ResortRoomCategory getPersistedResortRoomCategory(ResortRoomCategory resortRoomCategory) {
        return resortRoomCategoryRepository.findById(resortRoomCategory.getId()).orElseThrow();
    }

    protected void assertPersistedResortRoomCategoryToMatchAllProperties(ResortRoomCategory expectedResortRoomCategory) {
        assertResortRoomCategoryAllPropertiesEquals(expectedResortRoomCategory, getPersistedResortRoomCategory(expectedResortRoomCategory));
    }

    protected void assertPersistedResortRoomCategoryToMatchUpdatableProperties(ResortRoomCategory expectedResortRoomCategory) {
        assertResortRoomCategoryAllUpdatablePropertiesEquals(
            expectedResortRoomCategory,
            getPersistedResortRoomCategory(expectedResortRoomCategory)
        );
    }
}
