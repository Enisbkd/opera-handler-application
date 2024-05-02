package com.sbm.mc.web.rest;

import static com.sbm.mc.domain.ApplicationUserAsserts.*;
import static com.sbm.mc.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbm.mc.IntegrationTest;
import com.sbm.mc.domain.ApplicationUser;
import com.sbm.mc.repository.ApplicationUserRepository;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link ApplicationUserResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ApplicationUserResourceIT {

    private static final Integer DEFAULT_APP_USER_ID = 1;
    private static final Integer UPDATED_APP_USER_ID = 2;

    private static final String DEFAULT_APP_USER = "AAAAAAAAAA";
    private static final String UPDATED_APP_USER = "BBBBBBBBBB";

    private static final String DEFAULT_APP_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_APP_PASSWORD = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_INSERT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INSERT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_INSERT_USER = 1;
    private static final Integer UPDATED_INSERT_USER = 2;

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_UPDATE_USER = 1;
    private static final Integer UPDATED_UPDATE_USER = 2;

    private static final Integer DEFAULT_ORACLE_UID = 1;
    private static final Integer UPDATED_ORACLE_UID = 2;

    private static final String DEFAULT_ORACLE_USER = "AAAAAAAAAA";
    private static final String UPDATED_ORACLE_USER = "BBBBBBBBBB";

    private static final String DEFAULT_ORACLE_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_ORACLE_PASSWORD = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_INACTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INACTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_FORM = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_FORM = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_APP_USER_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_APP_USER_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_LOGGED_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_LAST_LOGGED_RESORT = "BBBBBBBBBB";

    private static final Integer DEFAULT_DEF_CASHIER_ID = 1;
    private static final Integer UPDATED_DEF_CASHIER_ID = 2;

    private static final String DEFAULT_APP_USER_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_APP_USER_DESCRIPTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_PERSON_NAME_ID = 1;
    private static final Integer UPDATED_PERSON_NAME_ID = 2;

    private static final LocalDate DEFAULT_DISABLED_UNTIL = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DISABLED_UNTIL = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_EXPIRES_ON = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EXPIRES_ON = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_LAST_LOGGED_TIMESTAMP = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LAST_LOGGED_TIMESTAMP = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_IS_SUPERUSER = "AAAAAAAAAA";
    private static final String UPDATED_IS_SUPERUSER = "BBBBBBBBBB";

    private static final String DEFAULT_EMPLOYEE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_GENERAL_FILEPATH = "AAAAAAAAAA";
    private static final String UPDATED_GENERAL_FILEPATH = "BBBBBBBBBB";

    private static final String DEFAULT_USER_FILEPATH = "AAAAAAAAAA";
    private static final String UPDATED_USER_FILEPATH = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_RESORT = "BBBBBBBBBB";

    private static final Integer DEFAULT_MAX_USER_SESSIONS = 1;
    private static final Integer UPDATED_MAX_USER_SESSIONS = 2;

    private static final String DEFAULT_INTERNAL_YN = "AAAAAAAAAA";
    private static final String UPDATED_INTERNAL_YN = "BBBBBBBBBB";

    private static final Integer DEFAULT_MAX_CHECKOUT_DAYS = 1;
    private static final Integer UPDATED_MAX_CHECKOUT_DAYS = 2;

    private static final String DEFAULT_DEFAULT_TERMINAL = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_TERMINAL = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_LANGUAGE = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_LANGUAGE = "BBBBBBBBBB";

    private static final String DEFAULT_DEPT_ID = "AAAAAAAAAA";
    private static final String UPDATED_DEPT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_MALE_FEMALE = "AAAAAAAAAA";
    private static final String UPDATED_MALE_FEMALE = "BBBBBBBBBB";

    private static final Integer DEFAULT_USER_PBX_ID = 1;
    private static final Integer UPDATED_USER_PBX_ID = 2;

    private static final LocalDate DEFAULT_DATE_HIRED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_HIRED = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_WORK_PERMIT_NO = "AAAAAAAAAA";
    private static final String UPDATED_WORK_PERMIT_NO = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_WORK_PERMIT_EXPDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_WORK_PERMIT_EXPDATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_RATE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_RATE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SALARY_INTERVAL = "AAAAAAAAAA";
    private static final String UPDATED_SALARY_INTERVAL = "BBBBBBBBBB";

    private static final Integer DEFAULT_HOURLY_RATE = 1;
    private static final Integer UPDATED_HOURLY_RATE = 2;

    private static final Integer DEFAULT_WEEKLY_SALARY = 1;
    private static final Integer UPDATED_WEEKLY_SALARY = 2;

    private static final Integer DEFAULT_OT_MULTIPLIER = 1;
    private static final Integer UPDATED_OT_MULTIPLIER = 2;

    private static final String DEFAULT_HIRE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_HIRE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_REHIRE_YN = "AAAAAAAAAA";
    private static final String UPDATED_REHIRE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_EMP_EXTENSION = "AAAAAAAAAA";
    private static final String UPDATED_EMP_EXTENSION = "BBBBBBBBBB";

    private static final String DEFAULT_EMP_PAGER = "AAAAAAAAAA";
    private static final String UPDATED_EMP_PAGER = "BBBBBBBBBB";

    private static final String DEFAULT_TERM_REASON = "AAAAAAAAAA";
    private static final String UPDATED_TERM_REASON = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_TERMINATED_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TERMINATED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_INACTIVE_REASON_CODE = "AAAAAAAAAA";
    private static final String UPDATED_INACTIVE_REASON_CODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_INACTIVE_FROM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INACTIVE_FROM = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_INACTIVE_TO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INACTIVE_TO = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_WEEK_MIN = 1;
    private static final Integer UPDATED_WEEK_MIN = 2;

    private static final Integer DEFAULT_WEEK_MAX = 1;
    private static final Integer UPDATED_WEEK_MAX = 2;

    private static final Integer DEFAULT_MONDAY_MIN = 1;
    private static final Integer UPDATED_MONDAY_MIN = 2;

    private static final Integer DEFAULT_MONDAY_MAX = 1;
    private static final Integer UPDATED_MONDAY_MAX = 2;

    private static final Integer DEFAULT_TUESDAY_MIN = 1;
    private static final Integer UPDATED_TUESDAY_MIN = 2;

    private static final Integer DEFAULT_TUESDAY_MAX = 1;
    private static final Integer UPDATED_TUESDAY_MAX = 2;

    private static final Integer DEFAULT_WEDNESDAY_MIN = 1;
    private static final Integer UPDATED_WEDNESDAY_MIN = 2;

    private static final Integer DEFAULT_WEDNESDAY_MAX = 1;
    private static final Integer UPDATED_WEDNESDAY_MAX = 2;

    private static final Integer DEFAULT_THURSDAY_MIN = 1;
    private static final Integer UPDATED_THURSDAY_MIN = 2;

    private static final Integer DEFAULT_THURSDAY_MAX = 1;
    private static final Integer UPDATED_THURSDAY_MAX = 2;

    private static final Integer DEFAULT_FRIDAY_MIN = 1;
    private static final Integer UPDATED_FRIDAY_MIN = 2;

    private static final Integer DEFAULT_FRIDAY_MAX = 1;
    private static final Integer UPDATED_FRIDAY_MAX = 2;

    private static final Integer DEFAULT_SATURDAY_MIN = 1;
    private static final Integer UPDATED_SATURDAY_MIN = 2;

    private static final Integer DEFAULT_SATURDAY_MAX = 1;
    private static final Integer UPDATED_SATURDAY_MAX = 2;

    private static final Integer DEFAULT_SUNDAY_MIN = 1;
    private static final Integer UPDATED_SUNDAY_MIN = 2;

    private static final Integer DEFAULT_SUNDAY_MAX = 1;
    private static final Integer UPDATED_SUNDAY_MAX = 2;

    private static final String DEFAULT_COMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTS = "BBBBBBBBBB";

    private static final String DEFAULT_LEAD_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_LEAD_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_LEAD_COMM = "AAAAAAAAAA";
    private static final String UPDATED_LEAD_COMM = "BBBBBBBBBB";

    private static final String DEFAULT_LEAD_ADDRESS_DET = "AAAAAAAAAA";
    private static final String UPDATED_LEAD_ADDRESS_DET = "BBBBBBBBBB";

    private static final Integer DEFAULT_LAPTOP_ID = 1;
    private static final Integer UPDATED_LAPTOP_ID = 2;

    private static final Integer DEFAULT_HOURS_PER_WEEK = 1;
    private static final Integer UPDATED_HOURS_PER_WEEK = 2;

    private static final String DEFAULT_EMP_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_EMP_STATUS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_PASSWORD_LAST_CHANGE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PASSWORD_LAST_CHANGE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_PASSWORD_CHANGE_DAYS = 1;
    private static final Integer UPDATED_PASSWORD_CHANGE_DAYS = 2;

    private static final Integer DEFAULT_GRACE_LOGIN = 1;
    private static final Integer UPDATED_GRACE_LOGIN = 2;

    private static final String DEFAULT_SREP_GROUP = "AAAAAAAAAA";
    private static final String UPDATED_SREP_GROUP = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_REPORTGROUP = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_REPORTGROUP = "BBBBBBBBBB";

    private static final String DEFAULT_AUTHORIZER_YN = "AAAAAAAAAA";
    private static final String UPDATED_AUTHORIZER_YN = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_AUTHORIZER_INACTIVE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_AUTHORIZER_INACTIVE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_SFA_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SFA_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LOGIN_CRO = "AAAAAAAAAA";
    private static final String UPDATED_LOGIN_CRO = "BBBBBBBBBB";

    private static final String DEFAULT_AUTHORIZER_RATE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_AUTHORIZER_RATE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_LOGIN_DOMAIN = "AAAAAAAAAA";
    private static final String UPDATED_LOGIN_DOMAIN = "BBBBBBBBBB";

    private static final String DEFAULT_RECEIVE_BROADCAST_MSG = "AAAAAAAAAA";
    private static final String UPDATED_RECEIVE_BROADCAST_MSG = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_MFN_RESORT = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_MFN_RESORT = "BBBBBBBBBB";

    private static final String DEFAULT_MFN_USER_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_MFN_USER_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_FORCE_PASSWORD_CHANGE_YN = "AAAAAAAAAA";
    private static final String UPDATED_FORCE_PASSWORD_CHANGE_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNT_LOCKED_OUT_YN = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNT_LOCKED_OUT_YN = "BBBBBBBBBB";

    private static final String DEFAULT_PREVENT_ACCOUNT_LOCKOUT = "AAAAAAAAAA";
    private static final String UPDATED_PREVENT_ACCOUNT_LOCKOUT = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_LOCKOUT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCKOUT_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ACCESS_PMS = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_PMS = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_SC = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_SC = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_CONFIG = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_CONFIG = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_EOD = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_EOD = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_UTIL = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_UTIL = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_ORS = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_ORS = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_SFA = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_SFA = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_OCIS = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_OCIS = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_OCM = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_OCM = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_OXI = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_OXI = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_OXIHUB = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_OXIHUB = "BBBBBBBBBB";

    private static final String DEFAULT_CHAIN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CHAIN_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_APP_USER_UNIQ = "AAAAAAAAAA";
    private static final String UPDATED_APP_USER_UNIQ = "BBBBBBBBBB";

    private static final Integer DEFAULT_MAX_DAYS_AFTER_CO = 1;
    private static final Integer UPDATED_MAX_DAYS_AFTER_CO = 2;

    private static final String DEFAULT_USER_GROUP_ADMIN = "AAAAAAAAAA";
    private static final String UPDATED_USER_GROUP_ADMIN = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_ORMS = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_ORMS = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_OBI = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_OBI = "BBBBBBBBBB";

    private static final String DEFAULT_SREP_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SREP_CODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_LOGIN_ATTEMPTS = 1;
    private static final Integer UPDATED_LOGIN_ATTEMPTS = 2;

    private static final String DEFAULT_PROPERTY_ACCESS_YN = "AAAAAAAAAA";
    private static final String UPDATED_PROPERTY_ACCESS_YN = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_SCBI = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_SCBI = "BBBBBBBBBB";

    private static final String DEFAULT_TIMEZONE_REGION = "AAAAAAAAAA";
    private static final String UPDATED_TIMEZONE_REGION = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESS_OCRM = "AAAAAAAAAA";
    private static final String UPDATED_ACCESS_OCRM = "BBBBBBBBBB";

    private static final String DEFAULT_EMPLOYEE_INCENTIVE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_INCENTIVE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_REQUEST_ALERTS_YN = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_REQUEST_ALERTS_YN = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_ALERTS_YN = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_ALERTS_YN = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/application-users";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restApplicationUserMockMvc;

    private ApplicationUser applicationUser;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ApplicationUser createEntity(EntityManager em) {
        ApplicationUser applicationUser = new ApplicationUser()
            .appUserId(DEFAULT_APP_USER_ID)
            .appUser(DEFAULT_APP_USER)
            .appPassword(DEFAULT_APP_PASSWORD)
            .insertDate(DEFAULT_INSERT_DATE)
            .insertUser(DEFAULT_INSERT_USER)
            .updateDate(DEFAULT_UPDATE_DATE)
            .updateUser(DEFAULT_UPDATE_USER)
            .oracleUid(DEFAULT_ORACLE_UID)
            .oracleUser(DEFAULT_ORACLE_USER)
            .oraclePassword(DEFAULT_ORACLE_PASSWORD)
            .inactiveDate(DEFAULT_INACTIVE_DATE)
            .title(DEFAULT_TITLE)
            .defaultForm(DEFAULT_DEFAULT_FORM)
            .name(DEFAULT_NAME)
            .appUserType(DEFAULT_APP_USER_TYPE)
            .lastLoggedResort(DEFAULT_LAST_LOGGED_RESORT)
            .defCashierId(DEFAULT_DEF_CASHIER_ID)
            .appUserDescription(DEFAULT_APP_USER_DESCRIPTION)
            .personNameId(DEFAULT_PERSON_NAME_ID)
            .disabledUntil(DEFAULT_DISABLED_UNTIL)
            .expiresOn(DEFAULT_EXPIRES_ON)
            .lastLoggedTimestamp(DEFAULT_LAST_LOGGED_TIMESTAMP)
            .isSuperuser(DEFAULT_IS_SUPERUSER)
            .employeeNumber(DEFAULT_EMPLOYEE_NUMBER)
            .generalFilepath(DEFAULT_GENERAL_FILEPATH)
            .userFilepath(DEFAULT_USER_FILEPATH)
            .defaultResort(DEFAULT_DEFAULT_RESORT)
            .maxUserSessions(DEFAULT_MAX_USER_SESSIONS)
            .internalYn(DEFAULT_INTERNAL_YN)
            .maxCheckoutDays(DEFAULT_MAX_CHECKOUT_DAYS)
            .defaultTerminal(DEFAULT_DEFAULT_TERMINAL)
            .defaultLanguage(DEFAULT_DEFAULT_LANGUAGE)
            .deptId(DEFAULT_DEPT_ID)
            .maleFemale(DEFAULT_MALE_FEMALE)
            .userPbxId(DEFAULT_USER_PBX_ID)
            .dateHired(DEFAULT_DATE_HIRED)
            .workPermitNo(DEFAULT_WORK_PERMIT_NO)
            .workPermitExpdate(DEFAULT_WORK_PERMIT_EXPDATE)
            .rateType(DEFAULT_RATE_TYPE)
            .salaryInterval(DEFAULT_SALARY_INTERVAL)
            .hourlyRate(DEFAULT_HOURLY_RATE)
            .weeklySalary(DEFAULT_WEEKLY_SALARY)
            .otMultiplier(DEFAULT_OT_MULTIPLIER)
            .hireType(DEFAULT_HIRE_TYPE)
            .rehireYn(DEFAULT_REHIRE_YN)
            .empExtension(DEFAULT_EMP_EXTENSION)
            .empPager(DEFAULT_EMP_PAGER)
            .termReason(DEFAULT_TERM_REASON)
            .terminatedDate(DEFAULT_TERMINATED_DATE)
            .inactiveReasonCode(DEFAULT_INACTIVE_REASON_CODE)
            .inactiveFrom(DEFAULT_INACTIVE_FROM)
            .inactiveTo(DEFAULT_INACTIVE_TO)
            .weekMin(DEFAULT_WEEK_MIN)
            .weekMax(DEFAULT_WEEK_MAX)
            .mondayMin(DEFAULT_MONDAY_MIN)
            .mondayMax(DEFAULT_MONDAY_MAX)
            .tuesdayMin(DEFAULT_TUESDAY_MIN)
            .tuesdayMax(DEFAULT_TUESDAY_MAX)
            .wednesdayMin(DEFAULT_WEDNESDAY_MIN)
            .wednesdayMax(DEFAULT_WEDNESDAY_MAX)
            .thursdayMin(DEFAULT_THURSDAY_MIN)
            .thursdayMax(DEFAULT_THURSDAY_MAX)
            .fridayMin(DEFAULT_FRIDAY_MIN)
            .fridayMax(DEFAULT_FRIDAY_MAX)
            .saturdayMin(DEFAULT_SATURDAY_MIN)
            .saturdayMax(DEFAULT_SATURDAY_MAX)
            .sundayMin(DEFAULT_SUNDAY_MIN)
            .sundayMax(DEFAULT_SUNDAY_MAX)
            .comments(DEFAULT_COMMENTS)
            .leadAddress(DEFAULT_LEAD_ADDRESS)
            .leadComm(DEFAULT_LEAD_COMM)
            .leadAddressDet(DEFAULT_LEAD_ADDRESS_DET)
            .laptopId(DEFAULT_LAPTOP_ID)
            .hoursPerWeek(DEFAULT_HOURS_PER_WEEK)
            .empStatus(DEFAULT_EMP_STATUS)
            .passwordLastChange(DEFAULT_PASSWORD_LAST_CHANGE)
            .passwordChangeDays(DEFAULT_PASSWORD_CHANGE_DAYS)
            .graceLogin(DEFAULT_GRACE_LOGIN)
            .srepGroup(DEFAULT_SREP_GROUP)
            .defaultReportgroup(DEFAULT_DEFAULT_REPORTGROUP)
            .authorizerYn(DEFAULT_AUTHORIZER_YN)
            .authorizerInactiveDate(DEFAULT_AUTHORIZER_INACTIVE_DATE)
            .sfaName(DEFAULT_SFA_NAME)
            .loginCro(DEFAULT_LOGIN_CRO)
            .authorizerRateCode(DEFAULT_AUTHORIZER_RATE_CODE)
            .loginDomain(DEFAULT_LOGIN_DOMAIN)
            .receiveBroadcastMsg(DEFAULT_RECEIVE_BROADCAST_MSG)
            .defaultMfnResort(DEFAULT_DEFAULT_MFN_RESORT)
            .mfnUserType(DEFAULT_MFN_USER_TYPE)
            .forcePasswordChangeYn(DEFAULT_FORCE_PASSWORD_CHANGE_YN)
            .accountLockedOutYn(DEFAULT_ACCOUNT_LOCKED_OUT_YN)
            .preventAccountLockout(DEFAULT_PREVENT_ACCOUNT_LOCKOUT)
            .lockoutDate(DEFAULT_LOCKOUT_DATE)
            .accessPms(DEFAULT_ACCESS_PMS)
            .accessSc(DEFAULT_ACCESS_SC)
            .accessConfig(DEFAULT_ACCESS_CONFIG)
            .accessEod(DEFAULT_ACCESS_EOD)
            .accessUtil(DEFAULT_ACCESS_UTIL)
            .accessOrs(DEFAULT_ACCESS_ORS)
            .accessSfa(DEFAULT_ACCESS_SFA)
            .accessOcis(DEFAULT_ACCESS_OCIS)
            .accessOcm(DEFAULT_ACCESS_OCM)
            .accessOxi(DEFAULT_ACCESS_OXI)
            .accessOxihub(DEFAULT_ACCESS_OXIHUB)
            .chainCode(DEFAULT_CHAIN_CODE)
            .appUserUniq(DEFAULT_APP_USER_UNIQ)
            .maxDaysAfterCo(DEFAULT_MAX_DAYS_AFTER_CO)
            .userGroupAdmin(DEFAULT_USER_GROUP_ADMIN)
            .accessOrms(DEFAULT_ACCESS_ORMS)
            .accessObi(DEFAULT_ACCESS_OBI)
            .srepCode(DEFAULT_SREP_CODE)
            .loginAttempts(DEFAULT_LOGIN_ATTEMPTS)
            .propertyAccessYn(DEFAULT_PROPERTY_ACCESS_YN)
            .accessScbi(DEFAULT_ACCESS_SCBI)
            .timezoneRegion(DEFAULT_TIMEZONE_REGION)
            .accessOcrm(DEFAULT_ACCESS_OCRM)
            .employeeIncentiveNumber(DEFAULT_EMPLOYEE_INCENTIVE_NUMBER)
            .serviceRequestAlertsYn(DEFAULT_SERVICE_REQUEST_ALERTS_YN)
            .mobileAlertsYn(DEFAULT_MOBILE_ALERTS_YN);
        return applicationUser;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ApplicationUser createUpdatedEntity(EntityManager em) {
        ApplicationUser applicationUser = new ApplicationUser()
            .appUserId(UPDATED_APP_USER_ID)
            .appUser(UPDATED_APP_USER)
            .appPassword(UPDATED_APP_PASSWORD)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .oracleUid(UPDATED_ORACLE_UID)
            .oracleUser(UPDATED_ORACLE_USER)
            .oraclePassword(UPDATED_ORACLE_PASSWORD)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .title(UPDATED_TITLE)
            .defaultForm(UPDATED_DEFAULT_FORM)
            .name(UPDATED_NAME)
            .appUserType(UPDATED_APP_USER_TYPE)
            .lastLoggedResort(UPDATED_LAST_LOGGED_RESORT)
            .defCashierId(UPDATED_DEF_CASHIER_ID)
            .appUserDescription(UPDATED_APP_USER_DESCRIPTION)
            .personNameId(UPDATED_PERSON_NAME_ID)
            .disabledUntil(UPDATED_DISABLED_UNTIL)
            .expiresOn(UPDATED_EXPIRES_ON)
            .lastLoggedTimestamp(UPDATED_LAST_LOGGED_TIMESTAMP)
            .isSuperuser(UPDATED_IS_SUPERUSER)
            .employeeNumber(UPDATED_EMPLOYEE_NUMBER)
            .generalFilepath(UPDATED_GENERAL_FILEPATH)
            .userFilepath(UPDATED_USER_FILEPATH)
            .defaultResort(UPDATED_DEFAULT_RESORT)
            .maxUserSessions(UPDATED_MAX_USER_SESSIONS)
            .internalYn(UPDATED_INTERNAL_YN)
            .maxCheckoutDays(UPDATED_MAX_CHECKOUT_DAYS)
            .defaultTerminal(UPDATED_DEFAULT_TERMINAL)
            .defaultLanguage(UPDATED_DEFAULT_LANGUAGE)
            .deptId(UPDATED_DEPT_ID)
            .maleFemale(UPDATED_MALE_FEMALE)
            .userPbxId(UPDATED_USER_PBX_ID)
            .dateHired(UPDATED_DATE_HIRED)
            .workPermitNo(UPDATED_WORK_PERMIT_NO)
            .workPermitExpdate(UPDATED_WORK_PERMIT_EXPDATE)
            .rateType(UPDATED_RATE_TYPE)
            .salaryInterval(UPDATED_SALARY_INTERVAL)
            .hourlyRate(UPDATED_HOURLY_RATE)
            .weeklySalary(UPDATED_WEEKLY_SALARY)
            .otMultiplier(UPDATED_OT_MULTIPLIER)
            .hireType(UPDATED_HIRE_TYPE)
            .rehireYn(UPDATED_REHIRE_YN)
            .empExtension(UPDATED_EMP_EXTENSION)
            .empPager(UPDATED_EMP_PAGER)
            .termReason(UPDATED_TERM_REASON)
            .terminatedDate(UPDATED_TERMINATED_DATE)
            .inactiveReasonCode(UPDATED_INACTIVE_REASON_CODE)
            .inactiveFrom(UPDATED_INACTIVE_FROM)
            .inactiveTo(UPDATED_INACTIVE_TO)
            .weekMin(UPDATED_WEEK_MIN)
            .weekMax(UPDATED_WEEK_MAX)
            .mondayMin(UPDATED_MONDAY_MIN)
            .mondayMax(UPDATED_MONDAY_MAX)
            .tuesdayMin(UPDATED_TUESDAY_MIN)
            .tuesdayMax(UPDATED_TUESDAY_MAX)
            .wednesdayMin(UPDATED_WEDNESDAY_MIN)
            .wednesdayMax(UPDATED_WEDNESDAY_MAX)
            .thursdayMin(UPDATED_THURSDAY_MIN)
            .thursdayMax(UPDATED_THURSDAY_MAX)
            .fridayMin(UPDATED_FRIDAY_MIN)
            .fridayMax(UPDATED_FRIDAY_MAX)
            .saturdayMin(UPDATED_SATURDAY_MIN)
            .saturdayMax(UPDATED_SATURDAY_MAX)
            .sundayMin(UPDATED_SUNDAY_MIN)
            .sundayMax(UPDATED_SUNDAY_MAX)
            .comments(UPDATED_COMMENTS)
            .leadAddress(UPDATED_LEAD_ADDRESS)
            .leadComm(UPDATED_LEAD_COMM)
            .leadAddressDet(UPDATED_LEAD_ADDRESS_DET)
            .laptopId(UPDATED_LAPTOP_ID)
            .hoursPerWeek(UPDATED_HOURS_PER_WEEK)
            .empStatus(UPDATED_EMP_STATUS)
            .passwordLastChange(UPDATED_PASSWORD_LAST_CHANGE)
            .passwordChangeDays(UPDATED_PASSWORD_CHANGE_DAYS)
            .graceLogin(UPDATED_GRACE_LOGIN)
            .srepGroup(UPDATED_SREP_GROUP)
            .defaultReportgroup(UPDATED_DEFAULT_REPORTGROUP)
            .authorizerYn(UPDATED_AUTHORIZER_YN)
            .authorizerInactiveDate(UPDATED_AUTHORIZER_INACTIVE_DATE)
            .sfaName(UPDATED_SFA_NAME)
            .loginCro(UPDATED_LOGIN_CRO)
            .authorizerRateCode(UPDATED_AUTHORIZER_RATE_CODE)
            .loginDomain(UPDATED_LOGIN_DOMAIN)
            .receiveBroadcastMsg(UPDATED_RECEIVE_BROADCAST_MSG)
            .defaultMfnResort(UPDATED_DEFAULT_MFN_RESORT)
            .mfnUserType(UPDATED_MFN_USER_TYPE)
            .forcePasswordChangeYn(UPDATED_FORCE_PASSWORD_CHANGE_YN)
            .accountLockedOutYn(UPDATED_ACCOUNT_LOCKED_OUT_YN)
            .preventAccountLockout(UPDATED_PREVENT_ACCOUNT_LOCKOUT)
            .lockoutDate(UPDATED_LOCKOUT_DATE)
            .accessPms(UPDATED_ACCESS_PMS)
            .accessSc(UPDATED_ACCESS_SC)
            .accessConfig(UPDATED_ACCESS_CONFIG)
            .accessEod(UPDATED_ACCESS_EOD)
            .accessUtil(UPDATED_ACCESS_UTIL)
            .accessOrs(UPDATED_ACCESS_ORS)
            .accessSfa(UPDATED_ACCESS_SFA)
            .accessOcis(UPDATED_ACCESS_OCIS)
            .accessOcm(UPDATED_ACCESS_OCM)
            .accessOxi(UPDATED_ACCESS_OXI)
            .accessOxihub(UPDATED_ACCESS_OXIHUB)
            .chainCode(UPDATED_CHAIN_CODE)
            .appUserUniq(UPDATED_APP_USER_UNIQ)
            .maxDaysAfterCo(UPDATED_MAX_DAYS_AFTER_CO)
            .userGroupAdmin(UPDATED_USER_GROUP_ADMIN)
            .accessOrms(UPDATED_ACCESS_ORMS)
            .accessObi(UPDATED_ACCESS_OBI)
            .srepCode(UPDATED_SREP_CODE)
            .loginAttempts(UPDATED_LOGIN_ATTEMPTS)
            .propertyAccessYn(UPDATED_PROPERTY_ACCESS_YN)
            .accessScbi(UPDATED_ACCESS_SCBI)
            .timezoneRegion(UPDATED_TIMEZONE_REGION)
            .accessOcrm(UPDATED_ACCESS_OCRM)
            .employeeIncentiveNumber(UPDATED_EMPLOYEE_INCENTIVE_NUMBER)
            .serviceRequestAlertsYn(UPDATED_SERVICE_REQUEST_ALERTS_YN)
            .mobileAlertsYn(UPDATED_MOBILE_ALERTS_YN);
        return applicationUser;
    }

    @BeforeEach
    public void initTest() {
        applicationUser = createEntity(em);
    }

    @Test
    @Transactional
    void createApplicationUser() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the ApplicationUser
        var returnedApplicationUser = om.readValue(
            restApplicationUserMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(applicationUser)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            ApplicationUser.class
        );

        // Validate the ApplicationUser in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        assertApplicationUserUpdatableFieldsEquals(returnedApplicationUser, getPersistedApplicationUser(returnedApplicationUser));
    }

    @Test
    @Transactional
    void createApplicationUserWithExistingId() throws Exception {
        // Create the ApplicationUser with an existing ID
        applicationUser.setId(1);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restApplicationUserMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(applicationUser)))
            .andExpect(status().isBadRequest());

        // Validate the ApplicationUser in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllApplicationUsers() throws Exception {
        // Initialize the database
        applicationUserRepository.saveAndFlush(applicationUser);

        // Get all the applicationUserList
        restApplicationUserMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(applicationUser.getId().intValue())))
            .andExpect(jsonPath("$.[*].appUserId").value(hasItem(DEFAULT_APP_USER_ID)))
            .andExpect(jsonPath("$.[*].appUser").value(hasItem(DEFAULT_APP_USER)))
            .andExpect(jsonPath("$.[*].appPassword").value(hasItem(DEFAULT_APP_PASSWORD)))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].insertUser").value(hasItem(DEFAULT_INSERT_USER)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateUser").value(hasItem(DEFAULT_UPDATE_USER)))
            .andExpect(jsonPath("$.[*].oracleUid").value(hasItem(DEFAULT_ORACLE_UID)))
            .andExpect(jsonPath("$.[*].oracleUser").value(hasItem(DEFAULT_ORACLE_USER)))
            .andExpect(jsonPath("$.[*].oraclePassword").value(hasItem(DEFAULT_ORACLE_PASSWORD)))
            .andExpect(jsonPath("$.[*].inactiveDate").value(hasItem(DEFAULT_INACTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].defaultForm").value(hasItem(DEFAULT_DEFAULT_FORM)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].appUserType").value(hasItem(DEFAULT_APP_USER_TYPE)))
            .andExpect(jsonPath("$.[*].lastLoggedResort").value(hasItem(DEFAULT_LAST_LOGGED_RESORT)))
            .andExpect(jsonPath("$.[*].defCashierId").value(hasItem(DEFAULT_DEF_CASHIER_ID)))
            .andExpect(jsonPath("$.[*].appUserDescription").value(hasItem(DEFAULT_APP_USER_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].personNameId").value(hasItem(DEFAULT_PERSON_NAME_ID)))
            .andExpect(jsonPath("$.[*].disabledUntil").value(hasItem(DEFAULT_DISABLED_UNTIL.toString())))
            .andExpect(jsonPath("$.[*].expiresOn").value(hasItem(DEFAULT_EXPIRES_ON.toString())))
            .andExpect(jsonPath("$.[*].lastLoggedTimestamp").value(hasItem(DEFAULT_LAST_LOGGED_TIMESTAMP.toString())))
            .andExpect(jsonPath("$.[*].isSuperuser").value(hasItem(DEFAULT_IS_SUPERUSER)))
            .andExpect(jsonPath("$.[*].employeeNumber").value(hasItem(DEFAULT_EMPLOYEE_NUMBER)))
            .andExpect(jsonPath("$.[*].generalFilepath").value(hasItem(DEFAULT_GENERAL_FILEPATH)))
            .andExpect(jsonPath("$.[*].userFilepath").value(hasItem(DEFAULT_USER_FILEPATH)))
            .andExpect(jsonPath("$.[*].defaultResort").value(hasItem(DEFAULT_DEFAULT_RESORT)))
            .andExpect(jsonPath("$.[*].maxUserSessions").value(hasItem(DEFAULT_MAX_USER_SESSIONS)))
            .andExpect(jsonPath("$.[*].internalYn").value(hasItem(DEFAULT_INTERNAL_YN)))
            .andExpect(jsonPath("$.[*].maxCheckoutDays").value(hasItem(DEFAULT_MAX_CHECKOUT_DAYS)))
            .andExpect(jsonPath("$.[*].defaultTerminal").value(hasItem(DEFAULT_DEFAULT_TERMINAL)))
            .andExpect(jsonPath("$.[*].defaultLanguage").value(hasItem(DEFAULT_DEFAULT_LANGUAGE)))
            .andExpect(jsonPath("$.[*].deptId").value(hasItem(DEFAULT_DEPT_ID)))
            .andExpect(jsonPath("$.[*].maleFemale").value(hasItem(DEFAULT_MALE_FEMALE)))
            .andExpect(jsonPath("$.[*].userPbxId").value(hasItem(DEFAULT_USER_PBX_ID)))
            .andExpect(jsonPath("$.[*].dateHired").value(hasItem(DEFAULT_DATE_HIRED.toString())))
            .andExpect(jsonPath("$.[*].workPermitNo").value(hasItem(DEFAULT_WORK_PERMIT_NO)))
            .andExpect(jsonPath("$.[*].workPermitExpdate").value(hasItem(DEFAULT_WORK_PERMIT_EXPDATE.toString())))
            .andExpect(jsonPath("$.[*].rateType").value(hasItem(DEFAULT_RATE_TYPE)))
            .andExpect(jsonPath("$.[*].salaryInterval").value(hasItem(DEFAULT_SALARY_INTERVAL)))
            .andExpect(jsonPath("$.[*].hourlyRate").value(hasItem(DEFAULT_HOURLY_RATE)))
            .andExpect(jsonPath("$.[*].weeklySalary").value(hasItem(DEFAULT_WEEKLY_SALARY)))
            .andExpect(jsonPath("$.[*].otMultiplier").value(hasItem(DEFAULT_OT_MULTIPLIER)))
            .andExpect(jsonPath("$.[*].hireType").value(hasItem(DEFAULT_HIRE_TYPE)))
            .andExpect(jsonPath("$.[*].rehireYn").value(hasItem(DEFAULT_REHIRE_YN)))
            .andExpect(jsonPath("$.[*].empExtension").value(hasItem(DEFAULT_EMP_EXTENSION)))
            .andExpect(jsonPath("$.[*].empPager").value(hasItem(DEFAULT_EMP_PAGER)))
            .andExpect(jsonPath("$.[*].termReason").value(hasItem(DEFAULT_TERM_REASON)))
            .andExpect(jsonPath("$.[*].terminatedDate").value(hasItem(DEFAULT_TERMINATED_DATE.toString())))
            .andExpect(jsonPath("$.[*].inactiveReasonCode").value(hasItem(DEFAULT_INACTIVE_REASON_CODE)))
            .andExpect(jsonPath("$.[*].inactiveFrom").value(hasItem(DEFAULT_INACTIVE_FROM.toString())))
            .andExpect(jsonPath("$.[*].inactiveTo").value(hasItem(DEFAULT_INACTIVE_TO.toString())))
            .andExpect(jsonPath("$.[*].weekMin").value(hasItem(DEFAULT_WEEK_MIN)))
            .andExpect(jsonPath("$.[*].weekMax").value(hasItem(DEFAULT_WEEK_MAX)))
            .andExpect(jsonPath("$.[*].mondayMin").value(hasItem(DEFAULT_MONDAY_MIN)))
            .andExpect(jsonPath("$.[*].mondayMax").value(hasItem(DEFAULT_MONDAY_MAX)))
            .andExpect(jsonPath("$.[*].tuesdayMin").value(hasItem(DEFAULT_TUESDAY_MIN)))
            .andExpect(jsonPath("$.[*].tuesdayMax").value(hasItem(DEFAULT_TUESDAY_MAX)))
            .andExpect(jsonPath("$.[*].wednesdayMin").value(hasItem(DEFAULT_WEDNESDAY_MIN)))
            .andExpect(jsonPath("$.[*].wednesdayMax").value(hasItem(DEFAULT_WEDNESDAY_MAX)))
            .andExpect(jsonPath("$.[*].thursdayMin").value(hasItem(DEFAULT_THURSDAY_MIN)))
            .andExpect(jsonPath("$.[*].thursdayMax").value(hasItem(DEFAULT_THURSDAY_MAX)))
            .andExpect(jsonPath("$.[*].fridayMin").value(hasItem(DEFAULT_FRIDAY_MIN)))
            .andExpect(jsonPath("$.[*].fridayMax").value(hasItem(DEFAULT_FRIDAY_MAX)))
            .andExpect(jsonPath("$.[*].saturdayMin").value(hasItem(DEFAULT_SATURDAY_MIN)))
            .andExpect(jsonPath("$.[*].saturdayMax").value(hasItem(DEFAULT_SATURDAY_MAX)))
            .andExpect(jsonPath("$.[*].sundayMin").value(hasItem(DEFAULT_SUNDAY_MIN)))
            .andExpect(jsonPath("$.[*].sundayMax").value(hasItem(DEFAULT_SUNDAY_MAX)))
            .andExpect(jsonPath("$.[*].comments").value(hasItem(DEFAULT_COMMENTS)))
            .andExpect(jsonPath("$.[*].leadAddress").value(hasItem(DEFAULT_LEAD_ADDRESS)))
            .andExpect(jsonPath("$.[*].leadComm").value(hasItem(DEFAULT_LEAD_COMM)))
            .andExpect(jsonPath("$.[*].leadAddressDet").value(hasItem(DEFAULT_LEAD_ADDRESS_DET)))
            .andExpect(jsonPath("$.[*].laptopId").value(hasItem(DEFAULT_LAPTOP_ID)))
            .andExpect(jsonPath("$.[*].hoursPerWeek").value(hasItem(DEFAULT_HOURS_PER_WEEK)))
            .andExpect(jsonPath("$.[*].empStatus").value(hasItem(DEFAULT_EMP_STATUS)))
            .andExpect(jsonPath("$.[*].passwordLastChange").value(hasItem(DEFAULT_PASSWORD_LAST_CHANGE.toString())))
            .andExpect(jsonPath("$.[*].passwordChangeDays").value(hasItem(DEFAULT_PASSWORD_CHANGE_DAYS)))
            .andExpect(jsonPath("$.[*].graceLogin").value(hasItem(DEFAULT_GRACE_LOGIN)))
            .andExpect(jsonPath("$.[*].srepGroup").value(hasItem(DEFAULT_SREP_GROUP)))
            .andExpect(jsonPath("$.[*].defaultReportgroup").value(hasItem(DEFAULT_DEFAULT_REPORTGROUP)))
            .andExpect(jsonPath("$.[*].authorizerYn").value(hasItem(DEFAULT_AUTHORIZER_YN)))
            .andExpect(jsonPath("$.[*].authorizerInactiveDate").value(hasItem(DEFAULT_AUTHORIZER_INACTIVE_DATE.toString())))
            .andExpect(jsonPath("$.[*].sfaName").value(hasItem(DEFAULT_SFA_NAME)))
            .andExpect(jsonPath("$.[*].loginCro").value(hasItem(DEFAULT_LOGIN_CRO)))
            .andExpect(jsonPath("$.[*].authorizerRateCode").value(hasItem(DEFAULT_AUTHORIZER_RATE_CODE)))
            .andExpect(jsonPath("$.[*].loginDomain").value(hasItem(DEFAULT_LOGIN_DOMAIN)))
            .andExpect(jsonPath("$.[*].receiveBroadcastMsg").value(hasItem(DEFAULT_RECEIVE_BROADCAST_MSG)))
            .andExpect(jsonPath("$.[*].defaultMfnResort").value(hasItem(DEFAULT_DEFAULT_MFN_RESORT)))
            .andExpect(jsonPath("$.[*].mfnUserType").value(hasItem(DEFAULT_MFN_USER_TYPE)))
            .andExpect(jsonPath("$.[*].forcePasswordChangeYn").value(hasItem(DEFAULT_FORCE_PASSWORD_CHANGE_YN)))
            .andExpect(jsonPath("$.[*].accountLockedOutYn").value(hasItem(DEFAULT_ACCOUNT_LOCKED_OUT_YN)))
            .andExpect(jsonPath("$.[*].preventAccountLockout").value(hasItem(DEFAULT_PREVENT_ACCOUNT_LOCKOUT)))
            .andExpect(jsonPath("$.[*].lockoutDate").value(hasItem(DEFAULT_LOCKOUT_DATE.toString())))
            .andExpect(jsonPath("$.[*].accessPms").value(hasItem(DEFAULT_ACCESS_PMS)))
            .andExpect(jsonPath("$.[*].accessSc").value(hasItem(DEFAULT_ACCESS_SC)))
            .andExpect(jsonPath("$.[*].accessConfig").value(hasItem(DEFAULT_ACCESS_CONFIG)))
            .andExpect(jsonPath("$.[*].accessEod").value(hasItem(DEFAULT_ACCESS_EOD)))
            .andExpect(jsonPath("$.[*].accessUtil").value(hasItem(DEFAULT_ACCESS_UTIL)))
            .andExpect(jsonPath("$.[*].accessOrs").value(hasItem(DEFAULT_ACCESS_ORS)))
            .andExpect(jsonPath("$.[*].accessSfa").value(hasItem(DEFAULT_ACCESS_SFA)))
            .andExpect(jsonPath("$.[*].accessOcis").value(hasItem(DEFAULT_ACCESS_OCIS)))
            .andExpect(jsonPath("$.[*].accessOcm").value(hasItem(DEFAULT_ACCESS_OCM)))
            .andExpect(jsonPath("$.[*].accessOxi").value(hasItem(DEFAULT_ACCESS_OXI)))
            .andExpect(jsonPath("$.[*].accessOxihub").value(hasItem(DEFAULT_ACCESS_OXIHUB)))
            .andExpect(jsonPath("$.[*].chainCode").value(hasItem(DEFAULT_CHAIN_CODE)))
            .andExpect(jsonPath("$.[*].appUserUniq").value(hasItem(DEFAULT_APP_USER_UNIQ)))
            .andExpect(jsonPath("$.[*].maxDaysAfterCo").value(hasItem(DEFAULT_MAX_DAYS_AFTER_CO)))
            .andExpect(jsonPath("$.[*].userGroupAdmin").value(hasItem(DEFAULT_USER_GROUP_ADMIN)))
            .andExpect(jsonPath("$.[*].accessOrms").value(hasItem(DEFAULT_ACCESS_ORMS)))
            .andExpect(jsonPath("$.[*].accessObi").value(hasItem(DEFAULT_ACCESS_OBI)))
            .andExpect(jsonPath("$.[*].srepCode").value(hasItem(DEFAULT_SREP_CODE)))
            .andExpect(jsonPath("$.[*].loginAttempts").value(hasItem(DEFAULT_LOGIN_ATTEMPTS)))
            .andExpect(jsonPath("$.[*].propertyAccessYn").value(hasItem(DEFAULT_PROPERTY_ACCESS_YN)))
            .andExpect(jsonPath("$.[*].accessScbi").value(hasItem(DEFAULT_ACCESS_SCBI)))
            .andExpect(jsonPath("$.[*].timezoneRegion").value(hasItem(DEFAULT_TIMEZONE_REGION)))
            .andExpect(jsonPath("$.[*].accessOcrm").value(hasItem(DEFAULT_ACCESS_OCRM)))
            .andExpect(jsonPath("$.[*].employeeIncentiveNumber").value(hasItem(DEFAULT_EMPLOYEE_INCENTIVE_NUMBER)))
            .andExpect(jsonPath("$.[*].serviceRequestAlertsYn").value(hasItem(DEFAULT_SERVICE_REQUEST_ALERTS_YN)))
            .andExpect(jsonPath("$.[*].mobileAlertsYn").value(hasItem(DEFAULT_MOBILE_ALERTS_YN)));
    }

    @Test
    @Transactional
    void getApplicationUser() throws Exception {
        // Initialize the database
        applicationUserRepository.saveAndFlush(applicationUser);

        // Get the applicationUser
        restApplicationUserMockMvc
            .perform(get(ENTITY_API_URL_ID, applicationUser.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(applicationUser.getId().intValue()))
            .andExpect(jsonPath("$.appUserId").value(DEFAULT_APP_USER_ID))
            .andExpect(jsonPath("$.appUser").value(DEFAULT_APP_USER))
            .andExpect(jsonPath("$.appPassword").value(DEFAULT_APP_PASSWORD))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.insertUser").value(DEFAULT_INSERT_USER))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.updateUser").value(DEFAULT_UPDATE_USER))
            .andExpect(jsonPath("$.oracleUid").value(DEFAULT_ORACLE_UID))
            .andExpect(jsonPath("$.oracleUser").value(DEFAULT_ORACLE_USER))
            .andExpect(jsonPath("$.oraclePassword").value(DEFAULT_ORACLE_PASSWORD))
            .andExpect(jsonPath("$.inactiveDate").value(DEFAULT_INACTIVE_DATE.toString()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.defaultForm").value(DEFAULT_DEFAULT_FORM))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.appUserType").value(DEFAULT_APP_USER_TYPE))
            .andExpect(jsonPath("$.lastLoggedResort").value(DEFAULT_LAST_LOGGED_RESORT))
            .andExpect(jsonPath("$.defCashierId").value(DEFAULT_DEF_CASHIER_ID))
            .andExpect(jsonPath("$.appUserDescription").value(DEFAULT_APP_USER_DESCRIPTION))
            .andExpect(jsonPath("$.personNameId").value(DEFAULT_PERSON_NAME_ID))
            .andExpect(jsonPath("$.disabledUntil").value(DEFAULT_DISABLED_UNTIL.toString()))
            .andExpect(jsonPath("$.expiresOn").value(DEFAULT_EXPIRES_ON.toString()))
            .andExpect(jsonPath("$.lastLoggedTimestamp").value(DEFAULT_LAST_LOGGED_TIMESTAMP.toString()))
            .andExpect(jsonPath("$.isSuperuser").value(DEFAULT_IS_SUPERUSER))
            .andExpect(jsonPath("$.employeeNumber").value(DEFAULT_EMPLOYEE_NUMBER))
            .andExpect(jsonPath("$.generalFilepath").value(DEFAULT_GENERAL_FILEPATH))
            .andExpect(jsonPath("$.userFilepath").value(DEFAULT_USER_FILEPATH))
            .andExpect(jsonPath("$.defaultResort").value(DEFAULT_DEFAULT_RESORT))
            .andExpect(jsonPath("$.maxUserSessions").value(DEFAULT_MAX_USER_SESSIONS))
            .andExpect(jsonPath("$.internalYn").value(DEFAULT_INTERNAL_YN))
            .andExpect(jsonPath("$.maxCheckoutDays").value(DEFAULT_MAX_CHECKOUT_DAYS))
            .andExpect(jsonPath("$.defaultTerminal").value(DEFAULT_DEFAULT_TERMINAL))
            .andExpect(jsonPath("$.defaultLanguage").value(DEFAULT_DEFAULT_LANGUAGE))
            .andExpect(jsonPath("$.deptId").value(DEFAULT_DEPT_ID))
            .andExpect(jsonPath("$.maleFemale").value(DEFAULT_MALE_FEMALE))
            .andExpect(jsonPath("$.userPbxId").value(DEFAULT_USER_PBX_ID))
            .andExpect(jsonPath("$.dateHired").value(DEFAULT_DATE_HIRED.toString()))
            .andExpect(jsonPath("$.workPermitNo").value(DEFAULT_WORK_PERMIT_NO))
            .andExpect(jsonPath("$.workPermitExpdate").value(DEFAULT_WORK_PERMIT_EXPDATE.toString()))
            .andExpect(jsonPath("$.rateType").value(DEFAULT_RATE_TYPE))
            .andExpect(jsonPath("$.salaryInterval").value(DEFAULT_SALARY_INTERVAL))
            .andExpect(jsonPath("$.hourlyRate").value(DEFAULT_HOURLY_RATE))
            .andExpect(jsonPath("$.weeklySalary").value(DEFAULT_WEEKLY_SALARY))
            .andExpect(jsonPath("$.otMultiplier").value(DEFAULT_OT_MULTIPLIER))
            .andExpect(jsonPath("$.hireType").value(DEFAULT_HIRE_TYPE))
            .andExpect(jsonPath("$.rehireYn").value(DEFAULT_REHIRE_YN))
            .andExpect(jsonPath("$.empExtension").value(DEFAULT_EMP_EXTENSION))
            .andExpect(jsonPath("$.empPager").value(DEFAULT_EMP_PAGER))
            .andExpect(jsonPath("$.termReason").value(DEFAULT_TERM_REASON))
            .andExpect(jsonPath("$.terminatedDate").value(DEFAULT_TERMINATED_DATE.toString()))
            .andExpect(jsonPath("$.inactiveReasonCode").value(DEFAULT_INACTIVE_REASON_CODE))
            .andExpect(jsonPath("$.inactiveFrom").value(DEFAULT_INACTIVE_FROM.toString()))
            .andExpect(jsonPath("$.inactiveTo").value(DEFAULT_INACTIVE_TO.toString()))
            .andExpect(jsonPath("$.weekMin").value(DEFAULT_WEEK_MIN))
            .andExpect(jsonPath("$.weekMax").value(DEFAULT_WEEK_MAX))
            .andExpect(jsonPath("$.mondayMin").value(DEFAULT_MONDAY_MIN))
            .andExpect(jsonPath("$.mondayMax").value(DEFAULT_MONDAY_MAX))
            .andExpect(jsonPath("$.tuesdayMin").value(DEFAULT_TUESDAY_MIN))
            .andExpect(jsonPath("$.tuesdayMax").value(DEFAULT_TUESDAY_MAX))
            .andExpect(jsonPath("$.wednesdayMin").value(DEFAULT_WEDNESDAY_MIN))
            .andExpect(jsonPath("$.wednesdayMax").value(DEFAULT_WEDNESDAY_MAX))
            .andExpect(jsonPath("$.thursdayMin").value(DEFAULT_THURSDAY_MIN))
            .andExpect(jsonPath("$.thursdayMax").value(DEFAULT_THURSDAY_MAX))
            .andExpect(jsonPath("$.fridayMin").value(DEFAULT_FRIDAY_MIN))
            .andExpect(jsonPath("$.fridayMax").value(DEFAULT_FRIDAY_MAX))
            .andExpect(jsonPath("$.saturdayMin").value(DEFAULT_SATURDAY_MIN))
            .andExpect(jsonPath("$.saturdayMax").value(DEFAULT_SATURDAY_MAX))
            .andExpect(jsonPath("$.sundayMin").value(DEFAULT_SUNDAY_MIN))
            .andExpect(jsonPath("$.sundayMax").value(DEFAULT_SUNDAY_MAX))
            .andExpect(jsonPath("$.comments").value(DEFAULT_COMMENTS))
            .andExpect(jsonPath("$.leadAddress").value(DEFAULT_LEAD_ADDRESS))
            .andExpect(jsonPath("$.leadComm").value(DEFAULT_LEAD_COMM))
            .andExpect(jsonPath("$.leadAddressDet").value(DEFAULT_LEAD_ADDRESS_DET))
            .andExpect(jsonPath("$.laptopId").value(DEFAULT_LAPTOP_ID))
            .andExpect(jsonPath("$.hoursPerWeek").value(DEFAULT_HOURS_PER_WEEK))
            .andExpect(jsonPath("$.empStatus").value(DEFAULT_EMP_STATUS))
            .andExpect(jsonPath("$.passwordLastChange").value(DEFAULT_PASSWORD_LAST_CHANGE.toString()))
            .andExpect(jsonPath("$.passwordChangeDays").value(DEFAULT_PASSWORD_CHANGE_DAYS))
            .andExpect(jsonPath("$.graceLogin").value(DEFAULT_GRACE_LOGIN))
            .andExpect(jsonPath("$.srepGroup").value(DEFAULT_SREP_GROUP))
            .andExpect(jsonPath("$.defaultReportgroup").value(DEFAULT_DEFAULT_REPORTGROUP))
            .andExpect(jsonPath("$.authorizerYn").value(DEFAULT_AUTHORIZER_YN))
            .andExpect(jsonPath("$.authorizerInactiveDate").value(DEFAULT_AUTHORIZER_INACTIVE_DATE.toString()))
            .andExpect(jsonPath("$.sfaName").value(DEFAULT_SFA_NAME))
            .andExpect(jsonPath("$.loginCro").value(DEFAULT_LOGIN_CRO))
            .andExpect(jsonPath("$.authorizerRateCode").value(DEFAULT_AUTHORIZER_RATE_CODE))
            .andExpect(jsonPath("$.loginDomain").value(DEFAULT_LOGIN_DOMAIN))
            .andExpect(jsonPath("$.receiveBroadcastMsg").value(DEFAULT_RECEIVE_BROADCAST_MSG))
            .andExpect(jsonPath("$.defaultMfnResort").value(DEFAULT_DEFAULT_MFN_RESORT))
            .andExpect(jsonPath("$.mfnUserType").value(DEFAULT_MFN_USER_TYPE))
            .andExpect(jsonPath("$.forcePasswordChangeYn").value(DEFAULT_FORCE_PASSWORD_CHANGE_YN))
            .andExpect(jsonPath("$.accountLockedOutYn").value(DEFAULT_ACCOUNT_LOCKED_OUT_YN))
            .andExpect(jsonPath("$.preventAccountLockout").value(DEFAULT_PREVENT_ACCOUNT_LOCKOUT))
            .andExpect(jsonPath("$.lockoutDate").value(DEFAULT_LOCKOUT_DATE.toString()))
            .andExpect(jsonPath("$.accessPms").value(DEFAULT_ACCESS_PMS))
            .andExpect(jsonPath("$.accessSc").value(DEFAULT_ACCESS_SC))
            .andExpect(jsonPath("$.accessConfig").value(DEFAULT_ACCESS_CONFIG))
            .andExpect(jsonPath("$.accessEod").value(DEFAULT_ACCESS_EOD))
            .andExpect(jsonPath("$.accessUtil").value(DEFAULT_ACCESS_UTIL))
            .andExpect(jsonPath("$.accessOrs").value(DEFAULT_ACCESS_ORS))
            .andExpect(jsonPath("$.accessSfa").value(DEFAULT_ACCESS_SFA))
            .andExpect(jsonPath("$.accessOcis").value(DEFAULT_ACCESS_OCIS))
            .andExpect(jsonPath("$.accessOcm").value(DEFAULT_ACCESS_OCM))
            .andExpect(jsonPath("$.accessOxi").value(DEFAULT_ACCESS_OXI))
            .andExpect(jsonPath("$.accessOxihub").value(DEFAULT_ACCESS_OXIHUB))
            .andExpect(jsonPath("$.chainCode").value(DEFAULT_CHAIN_CODE))
            .andExpect(jsonPath("$.appUserUniq").value(DEFAULT_APP_USER_UNIQ))
            .andExpect(jsonPath("$.maxDaysAfterCo").value(DEFAULT_MAX_DAYS_AFTER_CO))
            .andExpect(jsonPath("$.userGroupAdmin").value(DEFAULT_USER_GROUP_ADMIN))
            .andExpect(jsonPath("$.accessOrms").value(DEFAULT_ACCESS_ORMS))
            .andExpect(jsonPath("$.accessObi").value(DEFAULT_ACCESS_OBI))
            .andExpect(jsonPath("$.srepCode").value(DEFAULT_SREP_CODE))
            .andExpect(jsonPath("$.loginAttempts").value(DEFAULT_LOGIN_ATTEMPTS))
            .andExpect(jsonPath("$.propertyAccessYn").value(DEFAULT_PROPERTY_ACCESS_YN))
            .andExpect(jsonPath("$.accessScbi").value(DEFAULT_ACCESS_SCBI))
            .andExpect(jsonPath("$.timezoneRegion").value(DEFAULT_TIMEZONE_REGION))
            .andExpect(jsonPath("$.accessOcrm").value(DEFAULT_ACCESS_OCRM))
            .andExpect(jsonPath("$.employeeIncentiveNumber").value(DEFAULT_EMPLOYEE_INCENTIVE_NUMBER))
            .andExpect(jsonPath("$.serviceRequestAlertsYn").value(DEFAULT_SERVICE_REQUEST_ALERTS_YN))
            .andExpect(jsonPath("$.mobileAlertsYn").value(DEFAULT_MOBILE_ALERTS_YN));
    }

    @Test
    @Transactional
    void getNonExistingApplicationUser() throws Exception {
        // Get the applicationUser
        restApplicationUserMockMvc.perform(get(ENTITY_API_URL_ID, Integer.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingApplicationUser() throws Exception {
        // Initialize the database
        applicationUserRepository.saveAndFlush(applicationUser);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the applicationUser
        ApplicationUser updatedApplicationUser = applicationUserRepository.findById(applicationUser.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedApplicationUser are not directly saved in db
        em.detach(updatedApplicationUser);
        updatedApplicationUser
            .appUserId(UPDATED_APP_USER_ID)
            .appUser(UPDATED_APP_USER)
            .appPassword(UPDATED_APP_PASSWORD)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .oracleUid(UPDATED_ORACLE_UID)
            .oracleUser(UPDATED_ORACLE_USER)
            .oraclePassword(UPDATED_ORACLE_PASSWORD)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .title(UPDATED_TITLE)
            .defaultForm(UPDATED_DEFAULT_FORM)
            .name(UPDATED_NAME)
            .appUserType(UPDATED_APP_USER_TYPE)
            .lastLoggedResort(UPDATED_LAST_LOGGED_RESORT)
            .defCashierId(UPDATED_DEF_CASHIER_ID)
            .appUserDescription(UPDATED_APP_USER_DESCRIPTION)
            .personNameId(UPDATED_PERSON_NAME_ID)
            .disabledUntil(UPDATED_DISABLED_UNTIL)
            .expiresOn(UPDATED_EXPIRES_ON)
            .lastLoggedTimestamp(UPDATED_LAST_LOGGED_TIMESTAMP)
            .isSuperuser(UPDATED_IS_SUPERUSER)
            .employeeNumber(UPDATED_EMPLOYEE_NUMBER)
            .generalFilepath(UPDATED_GENERAL_FILEPATH)
            .userFilepath(UPDATED_USER_FILEPATH)
            .defaultResort(UPDATED_DEFAULT_RESORT)
            .maxUserSessions(UPDATED_MAX_USER_SESSIONS)
            .internalYn(UPDATED_INTERNAL_YN)
            .maxCheckoutDays(UPDATED_MAX_CHECKOUT_DAYS)
            .defaultTerminal(UPDATED_DEFAULT_TERMINAL)
            .defaultLanguage(UPDATED_DEFAULT_LANGUAGE)
            .deptId(UPDATED_DEPT_ID)
            .maleFemale(UPDATED_MALE_FEMALE)
            .userPbxId(UPDATED_USER_PBX_ID)
            .dateHired(UPDATED_DATE_HIRED)
            .workPermitNo(UPDATED_WORK_PERMIT_NO)
            .workPermitExpdate(UPDATED_WORK_PERMIT_EXPDATE)
            .rateType(UPDATED_RATE_TYPE)
            .salaryInterval(UPDATED_SALARY_INTERVAL)
            .hourlyRate(UPDATED_HOURLY_RATE)
            .weeklySalary(UPDATED_WEEKLY_SALARY)
            .otMultiplier(UPDATED_OT_MULTIPLIER)
            .hireType(UPDATED_HIRE_TYPE)
            .rehireYn(UPDATED_REHIRE_YN)
            .empExtension(UPDATED_EMP_EXTENSION)
            .empPager(UPDATED_EMP_PAGER)
            .termReason(UPDATED_TERM_REASON)
            .terminatedDate(UPDATED_TERMINATED_DATE)
            .inactiveReasonCode(UPDATED_INACTIVE_REASON_CODE)
            .inactiveFrom(UPDATED_INACTIVE_FROM)
            .inactiveTo(UPDATED_INACTIVE_TO)
            .weekMin(UPDATED_WEEK_MIN)
            .weekMax(UPDATED_WEEK_MAX)
            .mondayMin(UPDATED_MONDAY_MIN)
            .mondayMax(UPDATED_MONDAY_MAX)
            .tuesdayMin(UPDATED_TUESDAY_MIN)
            .tuesdayMax(UPDATED_TUESDAY_MAX)
            .wednesdayMin(UPDATED_WEDNESDAY_MIN)
            .wednesdayMax(UPDATED_WEDNESDAY_MAX)
            .thursdayMin(UPDATED_THURSDAY_MIN)
            .thursdayMax(UPDATED_THURSDAY_MAX)
            .fridayMin(UPDATED_FRIDAY_MIN)
            .fridayMax(UPDATED_FRIDAY_MAX)
            .saturdayMin(UPDATED_SATURDAY_MIN)
            .saturdayMax(UPDATED_SATURDAY_MAX)
            .sundayMin(UPDATED_SUNDAY_MIN)
            .sundayMax(UPDATED_SUNDAY_MAX)
            .comments(UPDATED_COMMENTS)
            .leadAddress(UPDATED_LEAD_ADDRESS)
            .leadComm(UPDATED_LEAD_COMM)
            .leadAddressDet(UPDATED_LEAD_ADDRESS_DET)
            .laptopId(UPDATED_LAPTOP_ID)
            .hoursPerWeek(UPDATED_HOURS_PER_WEEK)
            .empStatus(UPDATED_EMP_STATUS)
            .passwordLastChange(UPDATED_PASSWORD_LAST_CHANGE)
            .passwordChangeDays(UPDATED_PASSWORD_CHANGE_DAYS)
            .graceLogin(UPDATED_GRACE_LOGIN)
            .srepGroup(UPDATED_SREP_GROUP)
            .defaultReportgroup(UPDATED_DEFAULT_REPORTGROUP)
            .authorizerYn(UPDATED_AUTHORIZER_YN)
            .authorizerInactiveDate(UPDATED_AUTHORIZER_INACTIVE_DATE)
            .sfaName(UPDATED_SFA_NAME)
            .loginCro(UPDATED_LOGIN_CRO)
            .authorizerRateCode(UPDATED_AUTHORIZER_RATE_CODE)
            .loginDomain(UPDATED_LOGIN_DOMAIN)
            .receiveBroadcastMsg(UPDATED_RECEIVE_BROADCAST_MSG)
            .defaultMfnResort(UPDATED_DEFAULT_MFN_RESORT)
            .mfnUserType(UPDATED_MFN_USER_TYPE)
            .forcePasswordChangeYn(UPDATED_FORCE_PASSWORD_CHANGE_YN)
            .accountLockedOutYn(UPDATED_ACCOUNT_LOCKED_OUT_YN)
            .preventAccountLockout(UPDATED_PREVENT_ACCOUNT_LOCKOUT)
            .lockoutDate(UPDATED_LOCKOUT_DATE)
            .accessPms(UPDATED_ACCESS_PMS)
            .accessSc(UPDATED_ACCESS_SC)
            .accessConfig(UPDATED_ACCESS_CONFIG)
            .accessEod(UPDATED_ACCESS_EOD)
            .accessUtil(UPDATED_ACCESS_UTIL)
            .accessOrs(UPDATED_ACCESS_ORS)
            .accessSfa(UPDATED_ACCESS_SFA)
            .accessOcis(UPDATED_ACCESS_OCIS)
            .accessOcm(UPDATED_ACCESS_OCM)
            .accessOxi(UPDATED_ACCESS_OXI)
            .accessOxihub(UPDATED_ACCESS_OXIHUB)
            .chainCode(UPDATED_CHAIN_CODE)
            .appUserUniq(UPDATED_APP_USER_UNIQ)
            .maxDaysAfterCo(UPDATED_MAX_DAYS_AFTER_CO)
            .userGroupAdmin(UPDATED_USER_GROUP_ADMIN)
            .accessOrms(UPDATED_ACCESS_ORMS)
            .accessObi(UPDATED_ACCESS_OBI)
            .srepCode(UPDATED_SREP_CODE)
            .loginAttempts(UPDATED_LOGIN_ATTEMPTS)
            .propertyAccessYn(UPDATED_PROPERTY_ACCESS_YN)
            .accessScbi(UPDATED_ACCESS_SCBI)
            .timezoneRegion(UPDATED_TIMEZONE_REGION)
            .accessOcrm(UPDATED_ACCESS_OCRM)
            .employeeIncentiveNumber(UPDATED_EMPLOYEE_INCENTIVE_NUMBER)
            .serviceRequestAlertsYn(UPDATED_SERVICE_REQUEST_ALERTS_YN)
            .mobileAlertsYn(UPDATED_MOBILE_ALERTS_YN);

        restApplicationUserMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedApplicationUser.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(updatedApplicationUser))
            )
            .andExpect(status().isOk());

        // Validate the ApplicationUser in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedApplicationUserToMatchAllProperties(updatedApplicationUser);
    }

    @Test
    @Transactional
    void putNonExistingApplicationUser() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        applicationUser.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restApplicationUserMockMvc
            .perform(
                put(ENTITY_API_URL_ID, applicationUser.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(applicationUser))
            )
            .andExpect(status().isBadRequest());

        // Validate the ApplicationUser in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchApplicationUser() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        applicationUser.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restApplicationUserMockMvc
            .perform(
                put(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(applicationUser))
            )
            .andExpect(status().isBadRequest());

        // Validate the ApplicationUser in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamApplicationUser() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        applicationUser.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restApplicationUserMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(applicationUser)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ApplicationUser in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateApplicationUserWithPatch() throws Exception {
        // Initialize the database
        applicationUserRepository.saveAndFlush(applicationUser);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the applicationUser using partial update
        ApplicationUser partialUpdatedApplicationUser = new ApplicationUser();
        partialUpdatedApplicationUser.setId(applicationUser.getId());

        partialUpdatedApplicationUser
            .appUserId(UPDATED_APP_USER_ID)
            .updateDate(UPDATED_UPDATE_DATE)
            .oracleUid(UPDATED_ORACLE_UID)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .title(UPDATED_TITLE)
            .name(UPDATED_NAME)
            .appUserType(UPDATED_APP_USER_TYPE)
            .appUserDescription(UPDATED_APP_USER_DESCRIPTION)
            .personNameId(UPDATED_PERSON_NAME_ID)
            .lastLoggedTimestamp(UPDATED_LAST_LOGGED_TIMESTAMP)
            .isSuperuser(UPDATED_IS_SUPERUSER)
            .employeeNumber(UPDATED_EMPLOYEE_NUMBER)
            .defaultResort(UPDATED_DEFAULT_RESORT)
            .maxUserSessions(UPDATED_MAX_USER_SESSIONS)
            .defaultTerminal(UPDATED_DEFAULT_TERMINAL)
            .deptId(UPDATED_DEPT_ID)
            .dateHired(UPDATED_DATE_HIRED)
            .workPermitExpdate(UPDATED_WORK_PERMIT_EXPDATE)
            .hourlyRate(UPDATED_HOURLY_RATE)
            .weeklySalary(UPDATED_WEEKLY_SALARY)
            .hireType(UPDATED_HIRE_TYPE)
            .rehireYn(UPDATED_REHIRE_YN)
            .empExtension(UPDATED_EMP_EXTENSION)
            .empPager(UPDATED_EMP_PAGER)
            .termReason(UPDATED_TERM_REASON)
            .terminatedDate(UPDATED_TERMINATED_DATE)
            .inactiveReasonCode(UPDATED_INACTIVE_REASON_CODE)
            .inactiveFrom(UPDATED_INACTIVE_FROM)
            .inactiveTo(UPDATED_INACTIVE_TO)
            .weekMin(UPDATED_WEEK_MIN)
            .weekMax(UPDATED_WEEK_MAX)
            .mondayMax(UPDATED_MONDAY_MAX)
            .tuesdayMin(UPDATED_TUESDAY_MIN)
            .wednesdayMin(UPDATED_WEDNESDAY_MIN)
            .thursdayMin(UPDATED_THURSDAY_MIN)
            .fridayMin(UPDATED_FRIDAY_MIN)
            .saturdayMax(UPDATED_SATURDAY_MAX)
            .sundayMin(UPDATED_SUNDAY_MIN)
            .leadAddressDet(UPDATED_LEAD_ADDRESS_DET)
            .laptopId(UPDATED_LAPTOP_ID)
            .empStatus(UPDATED_EMP_STATUS)
            .graceLogin(UPDATED_GRACE_LOGIN)
            .defaultReportgroup(UPDATED_DEFAULT_REPORTGROUP)
            .authorizerYn(UPDATED_AUTHORIZER_YN)
            .sfaName(UPDATED_SFA_NAME)
            .authorizerRateCode(UPDATED_AUTHORIZER_RATE_CODE)
            .loginDomain(UPDATED_LOGIN_DOMAIN)
            .defaultMfnResort(UPDATED_DEFAULT_MFN_RESORT)
            .forcePasswordChangeYn(UPDATED_FORCE_PASSWORD_CHANGE_YN)
            .accountLockedOutYn(UPDATED_ACCOUNT_LOCKED_OUT_YN)
            .accessEod(UPDATED_ACCESS_EOD)
            .accessUtil(UPDATED_ACCESS_UTIL)
            .accessOrs(UPDATED_ACCESS_ORS)
            .accessOcm(UPDATED_ACCESS_OCM)
            .accessOxi(UPDATED_ACCESS_OXI)
            .accessOxihub(UPDATED_ACCESS_OXIHUB)
            .chainCode(UPDATED_CHAIN_CODE)
            .accessOrms(UPDATED_ACCESS_ORMS)
            .accessObi(UPDATED_ACCESS_OBI)
            .loginAttempts(UPDATED_LOGIN_ATTEMPTS)
            .propertyAccessYn(UPDATED_PROPERTY_ACCESS_YN)
            .mobileAlertsYn(UPDATED_MOBILE_ALERTS_YN);

        restApplicationUserMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedApplicationUser.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedApplicationUser))
            )
            .andExpect(status().isOk());

        // Validate the ApplicationUser in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertApplicationUserUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedApplicationUser, applicationUser),
            getPersistedApplicationUser(applicationUser)
        );
    }

    @Test
    @Transactional
    void fullUpdateApplicationUserWithPatch() throws Exception {
        // Initialize the database
        applicationUserRepository.saveAndFlush(applicationUser);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the applicationUser using partial update
        ApplicationUser partialUpdatedApplicationUser = new ApplicationUser();
        partialUpdatedApplicationUser.setId(applicationUser.getId());

        partialUpdatedApplicationUser
            .appUserId(UPDATED_APP_USER_ID)
            .appUser(UPDATED_APP_USER)
            .appPassword(UPDATED_APP_PASSWORD)
            .insertDate(UPDATED_INSERT_DATE)
            .insertUser(UPDATED_INSERT_USER)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateUser(UPDATED_UPDATE_USER)
            .oracleUid(UPDATED_ORACLE_UID)
            .oracleUser(UPDATED_ORACLE_USER)
            .oraclePassword(UPDATED_ORACLE_PASSWORD)
            .inactiveDate(UPDATED_INACTIVE_DATE)
            .title(UPDATED_TITLE)
            .defaultForm(UPDATED_DEFAULT_FORM)
            .name(UPDATED_NAME)
            .appUserType(UPDATED_APP_USER_TYPE)
            .lastLoggedResort(UPDATED_LAST_LOGGED_RESORT)
            .defCashierId(UPDATED_DEF_CASHIER_ID)
            .appUserDescription(UPDATED_APP_USER_DESCRIPTION)
            .personNameId(UPDATED_PERSON_NAME_ID)
            .disabledUntil(UPDATED_DISABLED_UNTIL)
            .expiresOn(UPDATED_EXPIRES_ON)
            .lastLoggedTimestamp(UPDATED_LAST_LOGGED_TIMESTAMP)
            .isSuperuser(UPDATED_IS_SUPERUSER)
            .employeeNumber(UPDATED_EMPLOYEE_NUMBER)
            .generalFilepath(UPDATED_GENERAL_FILEPATH)
            .userFilepath(UPDATED_USER_FILEPATH)
            .defaultResort(UPDATED_DEFAULT_RESORT)
            .maxUserSessions(UPDATED_MAX_USER_SESSIONS)
            .internalYn(UPDATED_INTERNAL_YN)
            .maxCheckoutDays(UPDATED_MAX_CHECKOUT_DAYS)
            .defaultTerminal(UPDATED_DEFAULT_TERMINAL)
            .defaultLanguage(UPDATED_DEFAULT_LANGUAGE)
            .deptId(UPDATED_DEPT_ID)
            .maleFemale(UPDATED_MALE_FEMALE)
            .userPbxId(UPDATED_USER_PBX_ID)
            .dateHired(UPDATED_DATE_HIRED)
            .workPermitNo(UPDATED_WORK_PERMIT_NO)
            .workPermitExpdate(UPDATED_WORK_PERMIT_EXPDATE)
            .rateType(UPDATED_RATE_TYPE)
            .salaryInterval(UPDATED_SALARY_INTERVAL)
            .hourlyRate(UPDATED_HOURLY_RATE)
            .weeklySalary(UPDATED_WEEKLY_SALARY)
            .otMultiplier(UPDATED_OT_MULTIPLIER)
            .hireType(UPDATED_HIRE_TYPE)
            .rehireYn(UPDATED_REHIRE_YN)
            .empExtension(UPDATED_EMP_EXTENSION)
            .empPager(UPDATED_EMP_PAGER)
            .termReason(UPDATED_TERM_REASON)
            .terminatedDate(UPDATED_TERMINATED_DATE)
            .inactiveReasonCode(UPDATED_INACTIVE_REASON_CODE)
            .inactiveFrom(UPDATED_INACTIVE_FROM)
            .inactiveTo(UPDATED_INACTIVE_TO)
            .weekMin(UPDATED_WEEK_MIN)
            .weekMax(UPDATED_WEEK_MAX)
            .mondayMin(UPDATED_MONDAY_MIN)
            .mondayMax(UPDATED_MONDAY_MAX)
            .tuesdayMin(UPDATED_TUESDAY_MIN)
            .tuesdayMax(UPDATED_TUESDAY_MAX)
            .wednesdayMin(UPDATED_WEDNESDAY_MIN)
            .wednesdayMax(UPDATED_WEDNESDAY_MAX)
            .thursdayMin(UPDATED_THURSDAY_MIN)
            .thursdayMax(UPDATED_THURSDAY_MAX)
            .fridayMin(UPDATED_FRIDAY_MIN)
            .fridayMax(UPDATED_FRIDAY_MAX)
            .saturdayMin(UPDATED_SATURDAY_MIN)
            .saturdayMax(UPDATED_SATURDAY_MAX)
            .sundayMin(UPDATED_SUNDAY_MIN)
            .sundayMax(UPDATED_SUNDAY_MAX)
            .comments(UPDATED_COMMENTS)
            .leadAddress(UPDATED_LEAD_ADDRESS)
            .leadComm(UPDATED_LEAD_COMM)
            .leadAddressDet(UPDATED_LEAD_ADDRESS_DET)
            .laptopId(UPDATED_LAPTOP_ID)
            .hoursPerWeek(UPDATED_HOURS_PER_WEEK)
            .empStatus(UPDATED_EMP_STATUS)
            .passwordLastChange(UPDATED_PASSWORD_LAST_CHANGE)
            .passwordChangeDays(UPDATED_PASSWORD_CHANGE_DAYS)
            .graceLogin(UPDATED_GRACE_LOGIN)
            .srepGroup(UPDATED_SREP_GROUP)
            .defaultReportgroup(UPDATED_DEFAULT_REPORTGROUP)
            .authorizerYn(UPDATED_AUTHORIZER_YN)
            .authorizerInactiveDate(UPDATED_AUTHORIZER_INACTIVE_DATE)
            .sfaName(UPDATED_SFA_NAME)
            .loginCro(UPDATED_LOGIN_CRO)
            .authorizerRateCode(UPDATED_AUTHORIZER_RATE_CODE)
            .loginDomain(UPDATED_LOGIN_DOMAIN)
            .receiveBroadcastMsg(UPDATED_RECEIVE_BROADCAST_MSG)
            .defaultMfnResort(UPDATED_DEFAULT_MFN_RESORT)
            .mfnUserType(UPDATED_MFN_USER_TYPE)
            .forcePasswordChangeYn(UPDATED_FORCE_PASSWORD_CHANGE_YN)
            .accountLockedOutYn(UPDATED_ACCOUNT_LOCKED_OUT_YN)
            .preventAccountLockout(UPDATED_PREVENT_ACCOUNT_LOCKOUT)
            .lockoutDate(UPDATED_LOCKOUT_DATE)
            .accessPms(UPDATED_ACCESS_PMS)
            .accessSc(UPDATED_ACCESS_SC)
            .accessConfig(UPDATED_ACCESS_CONFIG)
            .accessEod(UPDATED_ACCESS_EOD)
            .accessUtil(UPDATED_ACCESS_UTIL)
            .accessOrs(UPDATED_ACCESS_ORS)
            .accessSfa(UPDATED_ACCESS_SFA)
            .accessOcis(UPDATED_ACCESS_OCIS)
            .accessOcm(UPDATED_ACCESS_OCM)
            .accessOxi(UPDATED_ACCESS_OXI)
            .accessOxihub(UPDATED_ACCESS_OXIHUB)
            .chainCode(UPDATED_CHAIN_CODE)
            .appUserUniq(UPDATED_APP_USER_UNIQ)
            .maxDaysAfterCo(UPDATED_MAX_DAYS_AFTER_CO)
            .userGroupAdmin(UPDATED_USER_GROUP_ADMIN)
            .accessOrms(UPDATED_ACCESS_ORMS)
            .accessObi(UPDATED_ACCESS_OBI)
            .srepCode(UPDATED_SREP_CODE)
            .loginAttempts(UPDATED_LOGIN_ATTEMPTS)
            .propertyAccessYn(UPDATED_PROPERTY_ACCESS_YN)
            .accessScbi(UPDATED_ACCESS_SCBI)
            .timezoneRegion(UPDATED_TIMEZONE_REGION)
            .accessOcrm(UPDATED_ACCESS_OCRM)
            .employeeIncentiveNumber(UPDATED_EMPLOYEE_INCENTIVE_NUMBER)
            .serviceRequestAlertsYn(UPDATED_SERVICE_REQUEST_ALERTS_YN)
            .mobileAlertsYn(UPDATED_MOBILE_ALERTS_YN);

        restApplicationUserMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedApplicationUser.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedApplicationUser))
            )
            .andExpect(status().isOk());

        // Validate the ApplicationUser in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertApplicationUserUpdatableFieldsEquals(
            partialUpdatedApplicationUser,
            getPersistedApplicationUser(partialUpdatedApplicationUser)
        );
    }

    @Test
    @Transactional
    void patchNonExistingApplicationUser() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        applicationUser.setId(intCount.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restApplicationUserMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, applicationUser.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(applicationUser))
            )
            .andExpect(status().isBadRequest());

        // Validate the ApplicationUser in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchApplicationUser() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        applicationUser.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restApplicationUserMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, intCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(applicationUser))
            )
            .andExpect(status().isBadRequest());

        // Validate the ApplicationUser in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamApplicationUser() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        applicationUser.setId(intCount.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restApplicationUserMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(applicationUser)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ApplicationUser in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteApplicationUser() throws Exception {
        // Initialize the database
        applicationUserRepository.saveAndFlush(applicationUser);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the applicationUser
        restApplicationUserMockMvc
            .perform(delete(ENTITY_API_URL_ID, applicationUser.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return applicationUserRepository.count();
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

    protected ApplicationUser getPersistedApplicationUser(ApplicationUser applicationUser) {
        return applicationUserRepository.findById(applicationUser.getId()).orElseThrow();
    }

    protected void assertPersistedApplicationUserToMatchAllProperties(ApplicationUser expectedApplicationUser) {
        assertApplicationUserAllPropertiesEquals(expectedApplicationUser, getPersistedApplicationUser(expectedApplicationUser));
    }

    protected void assertPersistedApplicationUserToMatchUpdatableProperties(ApplicationUser expectedApplicationUser) {
        assertApplicationUserAllUpdatablePropertiesEquals(expectedApplicationUser, getPersistedApplicationUser(expectedApplicationUser));
    }
}
