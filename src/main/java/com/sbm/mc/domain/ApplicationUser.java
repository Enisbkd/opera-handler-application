package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ApplicationUser.
 */
@Entity
@Table(name = "application_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ApplicationUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "app_user_id")
    private Integer appUserId;

    @Column(name = "app_user")
    private String appUser;

    @Column(name = "app_password")
    private String appPassword;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "oracle_uid")
    private Integer oracleUid;

    @Column(name = "oracle_user")
    private String oracleUser;

    @Column(name = "oracle_password")
    private String oraclePassword;

    @Column(name = "inactive_date")
    private LocalDate inactiveDate;

    @Column(name = "title")
    private String title;

    @Column(name = "default_form")
    private String defaultForm;

    @Column(name = "name")
    private String name;

    @Column(name = "app_user_type")
    private String appUserType;

    @Column(name = "last_logged_resort")
    private String lastLoggedResort;

    @Column(name = "def_cashier_id")
    private Integer defCashierId;

    @Column(name = "app_user_description")
    private String appUserDescription;

    @Column(name = "person_name_id")
    private Integer personNameId;

    @Column(name = "disabled_until")
    private LocalDate disabledUntil;

    @Column(name = "expires_on")
    private LocalDate expiresOn;

    @Column(name = "last_logged_timestamp")
    private LocalDate lastLoggedTimestamp;

    @Column(name = "is_superuser")
    private String isSuperuser;

    @Column(name = "employee_number")
    private String employeeNumber;

    @Column(name = "general_filepath")
    private String generalFilepath;

    @Column(name = "user_filepath")
    private String userFilepath;

    @Column(name = "default_resort")
    private String defaultResort;

    @Column(name = "max_user_sessions")
    private Integer maxUserSessions;

    @Column(name = "internal_yn")
    private String internalYn;

    @Column(name = "max_checkout_days")
    private Integer maxCheckoutDays;

    @Column(name = "default_terminal")
    private String defaultTerminal;

    @Column(name = "default_language")
    private String defaultLanguage;

    @Column(name = "dept_id")
    private String deptId;

    @Column(name = "male_female")
    private String maleFemale;

    @Column(name = "user_pbx_id")
    private Integer userPbxId;

    @Column(name = "date_hired")
    private LocalDate dateHired;

    @Column(name = "work_permit_no")
    private String workPermitNo;

    @Column(name = "work_permit_expdate")
    private LocalDate workPermitExpdate;

    @Column(name = "rate_type")
    private String rateType;

    @Column(name = "salary_interval")
    private String salaryInterval;

    @Column(name = "hourly_rate")
    private Integer hourlyRate;

    @Column(name = "weekly_salary")
    private Integer weeklySalary;

    @Column(name = "ot_multiplier")
    private Integer otMultiplier;

    @Column(name = "hire_type")
    private String hireType;

    @Column(name = "rehire_yn")
    private String rehireYn;

    @Column(name = "emp_extension")
    private String empExtension;

    @Column(name = "emp_pager")
    private String empPager;

    @Column(name = "term_reason")
    private String termReason;

    @Column(name = "terminated_date")
    private LocalDate terminatedDate;

    @Column(name = "inactive_reason_code")
    private String inactiveReasonCode;

    @Column(name = "inactive_from")
    private LocalDate inactiveFrom;

    @Column(name = "inactive_to")
    private LocalDate inactiveTo;

    @Column(name = "week_min")
    private Integer weekMin;

    @Column(name = "week_max")
    private Integer weekMax;

    @Column(name = "monday_min")
    private Integer mondayMin;

    @Column(name = "monday_max")
    private Integer mondayMax;

    @Column(name = "tuesday_min")
    private Integer tuesdayMin;

    @Column(name = "tuesday_max")
    private Integer tuesdayMax;

    @Column(name = "wednesday_min")
    private Integer wednesdayMin;

    @Column(name = "wednesday_max")
    private Integer wednesdayMax;

    @Column(name = "thursday_min")
    private Integer thursdayMin;

    @Column(name = "thursday_max")
    private Integer thursdayMax;

    @Column(name = "friday_min")
    private Integer fridayMin;

    @Column(name = "friday_max")
    private Integer fridayMax;

    @Column(name = "saturday_min")
    private Integer saturdayMin;

    @Column(name = "saturday_max")
    private Integer saturdayMax;

    @Column(name = "sunday_min")
    private Integer sundayMin;

    @Column(name = "sunday_max")
    private Integer sundayMax;

    @Column(name = "comments")
    private String comments;

    @Column(name = "lead_address")
    private String leadAddress;

    @Column(name = "lead_comm")
    private String leadComm;

    @Column(name = "lead_address_det")
    private String leadAddressDet;

    @Column(name = "laptop_id")
    private Integer laptopId;

    @Column(name = "hours_per_week")
    private Integer hoursPerWeek;

    @Column(name = "emp_status")
    private String empStatus;

    @Column(name = "password_last_change")
    private LocalDate passwordLastChange;

    @Column(name = "password_change_days")
    private Integer passwordChangeDays;

    @Column(name = "grace_login")
    private Integer graceLogin;

    @Column(name = "srep_group")
    private String srepGroup;

    @Column(name = "default_reportgroup")
    private String defaultReportgroup;

    @Column(name = "authorizer_yn")
    private String authorizerYn;

    @Column(name = "authorizer_inactive_date")
    private LocalDate authorizerInactiveDate;

    @Column(name = "sfa_name")
    private String sfaName;

    @Column(name = "login_cro")
    private String loginCro;

    @Column(name = "authorizer_rate_code")
    private String authorizerRateCode;

    @Column(name = "login_domain")
    private String loginDomain;

    @Column(name = "receive_broadcast_msg")
    private String receiveBroadcastMsg;

    @Column(name = "default_mfn_resort")
    private String defaultMfnResort;

    @Column(name = "mfn_user_type")
    private String mfnUserType;

    @Column(name = "force_password_change_yn")
    private String forcePasswordChangeYn;

    @Column(name = "account_locked_out_yn")
    private String accountLockedOutYn;

    @Column(name = "prevent_account_lockout")
    private String preventAccountLockout;

    @Column(name = "lockout_date")
    private LocalDate lockoutDate;

    @Column(name = "access_pms")
    private String accessPms;

    @Column(name = "access_sc")
    private String accessSc;

    @Column(name = "access_config")
    private String accessConfig;

    @Column(name = "access_eod")
    private String accessEod;

    @Column(name = "access_util")
    private String accessUtil;

    @Column(name = "access_ors")
    private String accessOrs;

    @Column(name = "access_sfa")
    private String accessSfa;

    @Column(name = "access_ocis")
    private String accessOcis;

    @Column(name = "access_ocm")
    private String accessOcm;

    @Column(name = "access_oxi")
    private String accessOxi;

    @Column(name = "access_oxihub")
    private String accessOxihub;

    @Column(name = "chain_code")
    private String chainCode;

    @Column(name = "app_user_uniq")
    private String appUserUniq;

    @Column(name = "max_days_after_co")
    private Integer maxDaysAfterCo;

    @Column(name = "user_group_admin")
    private String userGroupAdmin;

    @Column(name = "access_orms")
    private String accessOrms;

    @Column(name = "access_obi")
    private String accessObi;

    @Column(name = "srep_code")
    private String srepCode;

    @Column(name = "login_attempts")
    private Integer loginAttempts;

    @Column(name = "property_access_yn")
    private String propertyAccessYn;

    @Column(name = "access_scbi")
    private String accessScbi;

    @Column(name = "timezone_region")
    private String timezoneRegion;

    @Column(name = "access_ocrm")
    private String accessOcrm;

    @Column(name = "employee_incentive_number")
    private String employeeIncentiveNumber;

    @Column(name = "service_request_alerts_yn")
    private String serviceRequestAlertsYn;

    @Column(name = "mobile_alerts_yn")
    private String mobileAlertsYn;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Integer getId() {
        return this.id;
    }

    public ApplicationUser id(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppUserId() {
        return this.appUserId;
    }

    public ApplicationUser appUserId(Integer appUserId) {
        this.setAppUserId(appUserId);
        return this;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }

    public String getAppUser() {
        return this.appUser;
    }

    public ApplicationUser appUser(String appUser) {
        this.setAppUser(appUser);
        return this;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }

    public String getAppPassword() {
        return this.appPassword;
    }

    public ApplicationUser appPassword(String appPassword) {
        this.setAppPassword(appPassword);
        return this;
    }

    public void setAppPassword(String appPassword) {
        this.appPassword = appPassword;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public ApplicationUser insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public ApplicationUser insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public ApplicationUser updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public ApplicationUser updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getOracleUid() {
        return this.oracleUid;
    }

    public ApplicationUser oracleUid(Integer oracleUid) {
        this.setOracleUid(oracleUid);
        return this;
    }

    public void setOracleUid(Integer oracleUid) {
        this.oracleUid = oracleUid;
    }

    public String getOracleUser() {
        return this.oracleUser;
    }

    public ApplicationUser oracleUser(String oracleUser) {
        this.setOracleUser(oracleUser);
        return this;
    }

    public void setOracleUser(String oracleUser) {
        this.oracleUser = oracleUser;
    }

    public String getOraclePassword() {
        return this.oraclePassword;
    }

    public ApplicationUser oraclePassword(String oraclePassword) {
        this.setOraclePassword(oraclePassword);
        return this;
    }

    public void setOraclePassword(String oraclePassword) {
        this.oraclePassword = oraclePassword;
    }

    public LocalDate getInactiveDate() {
        return this.inactiveDate;
    }

    public ApplicationUser inactiveDate(LocalDate inactiveDate) {
        this.setInactiveDate(inactiveDate);
        return this;
    }

    public void setInactiveDate(LocalDate inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getTitle() {
        return this.title;
    }

    public ApplicationUser title(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefaultForm() {
        return this.defaultForm;
    }

    public ApplicationUser defaultForm(String defaultForm) {
        this.setDefaultForm(defaultForm);
        return this;
    }

    public void setDefaultForm(String defaultForm) {
        this.defaultForm = defaultForm;
    }

    public String getName() {
        return this.name;
    }

    public ApplicationUser name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppUserType() {
        return this.appUserType;
    }

    public ApplicationUser appUserType(String appUserType) {
        this.setAppUserType(appUserType);
        return this;
    }

    public void setAppUserType(String appUserType) {
        this.appUserType = appUserType;
    }

    public String getLastLoggedResort() {
        return this.lastLoggedResort;
    }

    public ApplicationUser lastLoggedResort(String lastLoggedResort) {
        this.setLastLoggedResort(lastLoggedResort);
        return this;
    }

    public void setLastLoggedResort(String lastLoggedResort) {
        this.lastLoggedResort = lastLoggedResort;
    }

    public Integer getDefCashierId() {
        return this.defCashierId;
    }

    public ApplicationUser defCashierId(Integer defCashierId) {
        this.setDefCashierId(defCashierId);
        return this;
    }

    public void setDefCashierId(Integer defCashierId) {
        this.defCashierId = defCashierId;
    }

    public String getAppUserDescription() {
        return this.appUserDescription;
    }

    public ApplicationUser appUserDescription(String appUserDescription) {
        this.setAppUserDescription(appUserDescription);
        return this;
    }

    public void setAppUserDescription(String appUserDescription) {
        this.appUserDescription = appUserDescription;
    }

    public Integer getPersonNameId() {
        return this.personNameId;
    }

    public ApplicationUser personNameId(Integer personNameId) {
        this.setPersonNameId(personNameId);
        return this;
    }

    public void setPersonNameId(Integer personNameId) {
        this.personNameId = personNameId;
    }

    public LocalDate getDisabledUntil() {
        return this.disabledUntil;
    }

    public ApplicationUser disabledUntil(LocalDate disabledUntil) {
        this.setDisabledUntil(disabledUntil);
        return this;
    }

    public void setDisabledUntil(LocalDate disabledUntil) {
        this.disabledUntil = disabledUntil;
    }

    public LocalDate getExpiresOn() {
        return this.expiresOn;
    }

    public ApplicationUser expiresOn(LocalDate expiresOn) {
        this.setExpiresOn(expiresOn);
        return this;
    }

    public void setExpiresOn(LocalDate expiresOn) {
        this.expiresOn = expiresOn;
    }

    public LocalDate getLastLoggedTimestamp() {
        return this.lastLoggedTimestamp;
    }

    public ApplicationUser lastLoggedTimestamp(LocalDate lastLoggedTimestamp) {
        this.setLastLoggedTimestamp(lastLoggedTimestamp);
        return this;
    }

    public void setLastLoggedTimestamp(LocalDate lastLoggedTimestamp) {
        this.lastLoggedTimestamp = lastLoggedTimestamp;
    }

    public String getIsSuperuser() {
        return this.isSuperuser;
    }

    public ApplicationUser isSuperuser(String isSuperuser) {
        this.setIsSuperuser(isSuperuser);
        return this;
    }

    public void setIsSuperuser(String isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public String getEmployeeNumber() {
        return this.employeeNumber;
    }

    public ApplicationUser employeeNumber(String employeeNumber) {
        this.setEmployeeNumber(employeeNumber);
        return this;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getGeneralFilepath() {
        return this.generalFilepath;
    }

    public ApplicationUser generalFilepath(String generalFilepath) {
        this.setGeneralFilepath(generalFilepath);
        return this;
    }

    public void setGeneralFilepath(String generalFilepath) {
        this.generalFilepath = generalFilepath;
    }

    public String getUserFilepath() {
        return this.userFilepath;
    }

    public ApplicationUser userFilepath(String userFilepath) {
        this.setUserFilepath(userFilepath);
        return this;
    }

    public void setUserFilepath(String userFilepath) {
        this.userFilepath = userFilepath;
    }

    public String getDefaultResort() {
        return this.defaultResort;
    }

    public ApplicationUser defaultResort(String defaultResort) {
        this.setDefaultResort(defaultResort);
        return this;
    }

    public void setDefaultResort(String defaultResort) {
        this.defaultResort = defaultResort;
    }

    public Integer getMaxUserSessions() {
        return this.maxUserSessions;
    }

    public ApplicationUser maxUserSessions(Integer maxUserSessions) {
        this.setMaxUserSessions(maxUserSessions);
        return this;
    }

    public void setMaxUserSessions(Integer maxUserSessions) {
        this.maxUserSessions = maxUserSessions;
    }

    public String getInternalYn() {
        return this.internalYn;
    }

    public ApplicationUser internalYn(String internalYn) {
        this.setInternalYn(internalYn);
        return this;
    }

    public void setInternalYn(String internalYn) {
        this.internalYn = internalYn;
    }

    public Integer getMaxCheckoutDays() {
        return this.maxCheckoutDays;
    }

    public ApplicationUser maxCheckoutDays(Integer maxCheckoutDays) {
        this.setMaxCheckoutDays(maxCheckoutDays);
        return this;
    }

    public void setMaxCheckoutDays(Integer maxCheckoutDays) {
        this.maxCheckoutDays = maxCheckoutDays;
    }

    public String getDefaultTerminal() {
        return this.defaultTerminal;
    }

    public ApplicationUser defaultTerminal(String defaultTerminal) {
        this.setDefaultTerminal(defaultTerminal);
        return this;
    }

    public void setDefaultTerminal(String defaultTerminal) {
        this.defaultTerminal = defaultTerminal;
    }

    public String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    public ApplicationUser defaultLanguage(String defaultLanguage) {
        this.setDefaultLanguage(defaultLanguage);
        return this;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getDeptId() {
        return this.deptId;
    }

    public ApplicationUser deptId(String deptId) {
        this.setDeptId(deptId);
        return this;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getMaleFemale() {
        return this.maleFemale;
    }

    public ApplicationUser maleFemale(String maleFemale) {
        this.setMaleFemale(maleFemale);
        return this;
    }

    public void setMaleFemale(String maleFemale) {
        this.maleFemale = maleFemale;
    }

    public Integer getUserPbxId() {
        return this.userPbxId;
    }

    public ApplicationUser userPbxId(Integer userPbxId) {
        this.setUserPbxId(userPbxId);
        return this;
    }

    public void setUserPbxId(Integer userPbxId) {
        this.userPbxId = userPbxId;
    }

    public LocalDate getDateHired() {
        return this.dateHired;
    }

    public ApplicationUser dateHired(LocalDate dateHired) {
        this.setDateHired(dateHired);
        return this;
    }

    public void setDateHired(LocalDate dateHired) {
        this.dateHired = dateHired;
    }

    public String getWorkPermitNo() {
        return this.workPermitNo;
    }

    public ApplicationUser workPermitNo(String workPermitNo) {
        this.setWorkPermitNo(workPermitNo);
        return this;
    }

    public void setWorkPermitNo(String workPermitNo) {
        this.workPermitNo = workPermitNo;
    }

    public LocalDate getWorkPermitExpdate() {
        return this.workPermitExpdate;
    }

    public ApplicationUser workPermitExpdate(LocalDate workPermitExpdate) {
        this.setWorkPermitExpdate(workPermitExpdate);
        return this;
    }

    public void setWorkPermitExpdate(LocalDate workPermitExpdate) {
        this.workPermitExpdate = workPermitExpdate;
    }

    public String getRateType() {
        return this.rateType;
    }

    public ApplicationUser rateType(String rateType) {
        this.setRateType(rateType);
        return this;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getSalaryInterval() {
        return this.salaryInterval;
    }

    public ApplicationUser salaryInterval(String salaryInterval) {
        this.setSalaryInterval(salaryInterval);
        return this;
    }

    public void setSalaryInterval(String salaryInterval) {
        this.salaryInterval = salaryInterval;
    }

    public Integer getHourlyRate() {
        return this.hourlyRate;
    }

    public ApplicationUser hourlyRate(Integer hourlyRate) {
        this.setHourlyRate(hourlyRate);
        return this;
    }

    public void setHourlyRate(Integer hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Integer getWeeklySalary() {
        return this.weeklySalary;
    }

    public ApplicationUser weeklySalary(Integer weeklySalary) {
        this.setWeeklySalary(weeklySalary);
        return this;
    }

    public void setWeeklySalary(Integer weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public Integer getOtMultiplier() {
        return this.otMultiplier;
    }

    public ApplicationUser otMultiplier(Integer otMultiplier) {
        this.setOtMultiplier(otMultiplier);
        return this;
    }

    public void setOtMultiplier(Integer otMultiplier) {
        this.otMultiplier = otMultiplier;
    }

    public String getHireType() {
        return this.hireType;
    }

    public ApplicationUser hireType(String hireType) {
        this.setHireType(hireType);
        return this;
    }

    public void setHireType(String hireType) {
        this.hireType = hireType;
    }

    public String getRehireYn() {
        return this.rehireYn;
    }

    public ApplicationUser rehireYn(String rehireYn) {
        this.setRehireYn(rehireYn);
        return this;
    }

    public void setRehireYn(String rehireYn) {
        this.rehireYn = rehireYn;
    }

    public String getEmpExtension() {
        return this.empExtension;
    }

    public ApplicationUser empExtension(String empExtension) {
        this.setEmpExtension(empExtension);
        return this;
    }

    public void setEmpExtension(String empExtension) {
        this.empExtension = empExtension;
    }

    public String getEmpPager() {
        return this.empPager;
    }

    public ApplicationUser empPager(String empPager) {
        this.setEmpPager(empPager);
        return this;
    }

    public void setEmpPager(String empPager) {
        this.empPager = empPager;
    }

    public String getTermReason() {
        return this.termReason;
    }

    public ApplicationUser termReason(String termReason) {
        this.setTermReason(termReason);
        return this;
    }

    public void setTermReason(String termReason) {
        this.termReason = termReason;
    }

    public LocalDate getTerminatedDate() {
        return this.terminatedDate;
    }

    public ApplicationUser terminatedDate(LocalDate terminatedDate) {
        this.setTerminatedDate(terminatedDate);
        return this;
    }

    public void setTerminatedDate(LocalDate terminatedDate) {
        this.terminatedDate = terminatedDate;
    }

    public String getInactiveReasonCode() {
        return this.inactiveReasonCode;
    }

    public ApplicationUser inactiveReasonCode(String inactiveReasonCode) {
        this.setInactiveReasonCode(inactiveReasonCode);
        return this;
    }

    public void setInactiveReasonCode(String inactiveReasonCode) {
        this.inactiveReasonCode = inactiveReasonCode;
    }

    public LocalDate getInactiveFrom() {
        return this.inactiveFrom;
    }

    public ApplicationUser inactiveFrom(LocalDate inactiveFrom) {
        this.setInactiveFrom(inactiveFrom);
        return this;
    }

    public void setInactiveFrom(LocalDate inactiveFrom) {
        this.inactiveFrom = inactiveFrom;
    }

    public LocalDate getInactiveTo() {
        return this.inactiveTo;
    }

    public ApplicationUser inactiveTo(LocalDate inactiveTo) {
        this.setInactiveTo(inactiveTo);
        return this;
    }

    public void setInactiveTo(LocalDate inactiveTo) {
        this.inactiveTo = inactiveTo;
    }

    public Integer getWeekMin() {
        return this.weekMin;
    }

    public ApplicationUser weekMin(Integer weekMin) {
        this.setWeekMin(weekMin);
        return this;
    }

    public void setWeekMin(Integer weekMin) {
        this.weekMin = weekMin;
    }

    public Integer getWeekMax() {
        return this.weekMax;
    }

    public ApplicationUser weekMax(Integer weekMax) {
        this.setWeekMax(weekMax);
        return this;
    }

    public void setWeekMax(Integer weekMax) {
        this.weekMax = weekMax;
    }

    public Integer getMondayMin() {
        return this.mondayMin;
    }

    public ApplicationUser mondayMin(Integer mondayMin) {
        this.setMondayMin(mondayMin);
        return this;
    }

    public void setMondayMin(Integer mondayMin) {
        this.mondayMin = mondayMin;
    }

    public Integer getMondayMax() {
        return this.mondayMax;
    }

    public ApplicationUser mondayMax(Integer mondayMax) {
        this.setMondayMax(mondayMax);
        return this;
    }

    public void setMondayMax(Integer mondayMax) {
        this.mondayMax = mondayMax;
    }

    public Integer getTuesdayMin() {
        return this.tuesdayMin;
    }

    public ApplicationUser tuesdayMin(Integer tuesdayMin) {
        this.setTuesdayMin(tuesdayMin);
        return this;
    }

    public void setTuesdayMin(Integer tuesdayMin) {
        this.tuesdayMin = tuesdayMin;
    }

    public Integer getTuesdayMax() {
        return this.tuesdayMax;
    }

    public ApplicationUser tuesdayMax(Integer tuesdayMax) {
        this.setTuesdayMax(tuesdayMax);
        return this;
    }

    public void setTuesdayMax(Integer tuesdayMax) {
        this.tuesdayMax = tuesdayMax;
    }

    public Integer getWednesdayMin() {
        return this.wednesdayMin;
    }

    public ApplicationUser wednesdayMin(Integer wednesdayMin) {
        this.setWednesdayMin(wednesdayMin);
        return this;
    }

    public void setWednesdayMin(Integer wednesdayMin) {
        this.wednesdayMin = wednesdayMin;
    }

    public Integer getWednesdayMax() {
        return this.wednesdayMax;
    }

    public ApplicationUser wednesdayMax(Integer wednesdayMax) {
        this.setWednesdayMax(wednesdayMax);
        return this;
    }

    public void setWednesdayMax(Integer wednesdayMax) {
        this.wednesdayMax = wednesdayMax;
    }

    public Integer getThursdayMin() {
        return this.thursdayMin;
    }

    public ApplicationUser thursdayMin(Integer thursdayMin) {
        this.setThursdayMin(thursdayMin);
        return this;
    }

    public void setThursdayMin(Integer thursdayMin) {
        this.thursdayMin = thursdayMin;
    }

    public Integer getThursdayMax() {
        return this.thursdayMax;
    }

    public ApplicationUser thursdayMax(Integer thursdayMax) {
        this.setThursdayMax(thursdayMax);
        return this;
    }

    public void setThursdayMax(Integer thursdayMax) {
        this.thursdayMax = thursdayMax;
    }

    public Integer getFridayMin() {
        return this.fridayMin;
    }

    public ApplicationUser fridayMin(Integer fridayMin) {
        this.setFridayMin(fridayMin);
        return this;
    }

    public void setFridayMin(Integer fridayMin) {
        this.fridayMin = fridayMin;
    }

    public Integer getFridayMax() {
        return this.fridayMax;
    }

    public ApplicationUser fridayMax(Integer fridayMax) {
        this.setFridayMax(fridayMax);
        return this;
    }

    public void setFridayMax(Integer fridayMax) {
        this.fridayMax = fridayMax;
    }

    public Integer getSaturdayMin() {
        return this.saturdayMin;
    }

    public ApplicationUser saturdayMin(Integer saturdayMin) {
        this.setSaturdayMin(saturdayMin);
        return this;
    }

    public void setSaturdayMin(Integer saturdayMin) {
        this.saturdayMin = saturdayMin;
    }

    public Integer getSaturdayMax() {
        return this.saturdayMax;
    }

    public ApplicationUser saturdayMax(Integer saturdayMax) {
        this.setSaturdayMax(saturdayMax);
        return this;
    }

    public void setSaturdayMax(Integer saturdayMax) {
        this.saturdayMax = saturdayMax;
    }

    public Integer getSundayMin() {
        return this.sundayMin;
    }

    public ApplicationUser sundayMin(Integer sundayMin) {
        this.setSundayMin(sundayMin);
        return this;
    }

    public void setSundayMin(Integer sundayMin) {
        this.sundayMin = sundayMin;
    }

    public Integer getSundayMax() {
        return this.sundayMax;
    }

    public ApplicationUser sundayMax(Integer sundayMax) {
        this.setSundayMax(sundayMax);
        return this;
    }

    public void setSundayMax(Integer sundayMax) {
        this.sundayMax = sundayMax;
    }

    public String getComments() {
        return this.comments;
    }

    public ApplicationUser comments(String comments) {
        this.setComments(comments);
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLeadAddress() {
        return this.leadAddress;
    }

    public ApplicationUser leadAddress(String leadAddress) {
        this.setLeadAddress(leadAddress);
        return this;
    }

    public void setLeadAddress(String leadAddress) {
        this.leadAddress = leadAddress;
    }

    public String getLeadComm() {
        return this.leadComm;
    }

    public ApplicationUser leadComm(String leadComm) {
        this.setLeadComm(leadComm);
        return this;
    }

    public void setLeadComm(String leadComm) {
        this.leadComm = leadComm;
    }

    public String getLeadAddressDet() {
        return this.leadAddressDet;
    }

    public ApplicationUser leadAddressDet(String leadAddressDet) {
        this.setLeadAddressDet(leadAddressDet);
        return this;
    }

    public void setLeadAddressDet(String leadAddressDet) {
        this.leadAddressDet = leadAddressDet;
    }

    public Integer getLaptopId() {
        return this.laptopId;
    }

    public ApplicationUser laptopId(Integer laptopId) {
        this.setLaptopId(laptopId);
        return this;
    }

    public void setLaptopId(Integer laptopId) {
        this.laptopId = laptopId;
    }

    public Integer getHoursPerWeek() {
        return this.hoursPerWeek;
    }

    public ApplicationUser hoursPerWeek(Integer hoursPerWeek) {
        this.setHoursPerWeek(hoursPerWeek);
        return this;
    }

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public String getEmpStatus() {
        return this.empStatus;
    }

    public ApplicationUser empStatus(String empStatus) {
        this.setEmpStatus(empStatus);
        return this;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public LocalDate getPasswordLastChange() {
        return this.passwordLastChange;
    }

    public ApplicationUser passwordLastChange(LocalDate passwordLastChange) {
        this.setPasswordLastChange(passwordLastChange);
        return this;
    }

    public void setPasswordLastChange(LocalDate passwordLastChange) {
        this.passwordLastChange = passwordLastChange;
    }

    public Integer getPasswordChangeDays() {
        return this.passwordChangeDays;
    }

    public ApplicationUser passwordChangeDays(Integer passwordChangeDays) {
        this.setPasswordChangeDays(passwordChangeDays);
        return this;
    }

    public void setPasswordChangeDays(Integer passwordChangeDays) {
        this.passwordChangeDays = passwordChangeDays;
    }

    public Integer getGraceLogin() {
        return this.graceLogin;
    }

    public ApplicationUser graceLogin(Integer graceLogin) {
        this.setGraceLogin(graceLogin);
        return this;
    }

    public void setGraceLogin(Integer graceLogin) {
        this.graceLogin = graceLogin;
    }

    public String getSrepGroup() {
        return this.srepGroup;
    }

    public ApplicationUser srepGroup(String srepGroup) {
        this.setSrepGroup(srepGroup);
        return this;
    }

    public void setSrepGroup(String srepGroup) {
        this.srepGroup = srepGroup;
    }

    public String getDefaultReportgroup() {
        return this.defaultReportgroup;
    }

    public ApplicationUser defaultReportgroup(String defaultReportgroup) {
        this.setDefaultReportgroup(defaultReportgroup);
        return this;
    }

    public void setDefaultReportgroup(String defaultReportgroup) {
        this.defaultReportgroup = defaultReportgroup;
    }

    public String getAuthorizerYn() {
        return this.authorizerYn;
    }

    public ApplicationUser authorizerYn(String authorizerYn) {
        this.setAuthorizerYn(authorizerYn);
        return this;
    }

    public void setAuthorizerYn(String authorizerYn) {
        this.authorizerYn = authorizerYn;
    }

    public LocalDate getAuthorizerInactiveDate() {
        return this.authorizerInactiveDate;
    }

    public ApplicationUser authorizerInactiveDate(LocalDate authorizerInactiveDate) {
        this.setAuthorizerInactiveDate(authorizerInactiveDate);
        return this;
    }

    public void setAuthorizerInactiveDate(LocalDate authorizerInactiveDate) {
        this.authorizerInactiveDate = authorizerInactiveDate;
    }

    public String getSfaName() {
        return this.sfaName;
    }

    public ApplicationUser sfaName(String sfaName) {
        this.setSfaName(sfaName);
        return this;
    }

    public void setSfaName(String sfaName) {
        this.sfaName = sfaName;
    }

    public String getLoginCro() {
        return this.loginCro;
    }

    public ApplicationUser loginCro(String loginCro) {
        this.setLoginCro(loginCro);
        return this;
    }

    public void setLoginCro(String loginCro) {
        this.loginCro = loginCro;
    }

    public String getAuthorizerRateCode() {
        return this.authorizerRateCode;
    }

    public ApplicationUser authorizerRateCode(String authorizerRateCode) {
        this.setAuthorizerRateCode(authorizerRateCode);
        return this;
    }

    public void setAuthorizerRateCode(String authorizerRateCode) {
        this.authorizerRateCode = authorizerRateCode;
    }

    public String getLoginDomain() {
        return this.loginDomain;
    }

    public ApplicationUser loginDomain(String loginDomain) {
        this.setLoginDomain(loginDomain);
        return this;
    }

    public void setLoginDomain(String loginDomain) {
        this.loginDomain = loginDomain;
    }

    public String getReceiveBroadcastMsg() {
        return this.receiveBroadcastMsg;
    }

    public ApplicationUser receiveBroadcastMsg(String receiveBroadcastMsg) {
        this.setReceiveBroadcastMsg(receiveBroadcastMsg);
        return this;
    }

    public void setReceiveBroadcastMsg(String receiveBroadcastMsg) {
        this.receiveBroadcastMsg = receiveBroadcastMsg;
    }

    public String getDefaultMfnResort() {
        return this.defaultMfnResort;
    }

    public ApplicationUser defaultMfnResort(String defaultMfnResort) {
        this.setDefaultMfnResort(defaultMfnResort);
        return this;
    }

    public void setDefaultMfnResort(String defaultMfnResort) {
        this.defaultMfnResort = defaultMfnResort;
    }

    public String getMfnUserType() {
        return this.mfnUserType;
    }

    public ApplicationUser mfnUserType(String mfnUserType) {
        this.setMfnUserType(mfnUserType);
        return this;
    }

    public void setMfnUserType(String mfnUserType) {
        this.mfnUserType = mfnUserType;
    }

    public String getForcePasswordChangeYn() {
        return this.forcePasswordChangeYn;
    }

    public ApplicationUser forcePasswordChangeYn(String forcePasswordChangeYn) {
        this.setForcePasswordChangeYn(forcePasswordChangeYn);
        return this;
    }

    public void setForcePasswordChangeYn(String forcePasswordChangeYn) {
        this.forcePasswordChangeYn = forcePasswordChangeYn;
    }

    public String getAccountLockedOutYn() {
        return this.accountLockedOutYn;
    }

    public ApplicationUser accountLockedOutYn(String accountLockedOutYn) {
        this.setAccountLockedOutYn(accountLockedOutYn);
        return this;
    }

    public void setAccountLockedOutYn(String accountLockedOutYn) {
        this.accountLockedOutYn = accountLockedOutYn;
    }

    public String getPreventAccountLockout() {
        return this.preventAccountLockout;
    }

    public ApplicationUser preventAccountLockout(String preventAccountLockout) {
        this.setPreventAccountLockout(preventAccountLockout);
        return this;
    }

    public void setPreventAccountLockout(String preventAccountLockout) {
        this.preventAccountLockout = preventAccountLockout;
    }

    public LocalDate getLockoutDate() {
        return this.lockoutDate;
    }

    public ApplicationUser lockoutDate(LocalDate lockoutDate) {
        this.setLockoutDate(lockoutDate);
        return this;
    }

    public void setLockoutDate(LocalDate lockoutDate) {
        this.lockoutDate = lockoutDate;
    }

    public String getAccessPms() {
        return this.accessPms;
    }

    public ApplicationUser accessPms(String accessPms) {
        this.setAccessPms(accessPms);
        return this;
    }

    public void setAccessPms(String accessPms) {
        this.accessPms = accessPms;
    }

    public String getAccessSc() {
        return this.accessSc;
    }

    public ApplicationUser accessSc(String accessSc) {
        this.setAccessSc(accessSc);
        return this;
    }

    public void setAccessSc(String accessSc) {
        this.accessSc = accessSc;
    }

    public String getAccessConfig() {
        return this.accessConfig;
    }

    public ApplicationUser accessConfig(String accessConfig) {
        this.setAccessConfig(accessConfig);
        return this;
    }

    public void setAccessConfig(String accessConfig) {
        this.accessConfig = accessConfig;
    }

    public String getAccessEod() {
        return this.accessEod;
    }

    public ApplicationUser accessEod(String accessEod) {
        this.setAccessEod(accessEod);
        return this;
    }

    public void setAccessEod(String accessEod) {
        this.accessEod = accessEod;
    }

    public String getAccessUtil() {
        return this.accessUtil;
    }

    public ApplicationUser accessUtil(String accessUtil) {
        this.setAccessUtil(accessUtil);
        return this;
    }

    public void setAccessUtil(String accessUtil) {
        this.accessUtil = accessUtil;
    }

    public String getAccessOrs() {
        return this.accessOrs;
    }

    public ApplicationUser accessOrs(String accessOrs) {
        this.setAccessOrs(accessOrs);
        return this;
    }

    public void setAccessOrs(String accessOrs) {
        this.accessOrs = accessOrs;
    }

    public String getAccessSfa() {
        return this.accessSfa;
    }

    public ApplicationUser accessSfa(String accessSfa) {
        this.setAccessSfa(accessSfa);
        return this;
    }

    public void setAccessSfa(String accessSfa) {
        this.accessSfa = accessSfa;
    }

    public String getAccessOcis() {
        return this.accessOcis;
    }

    public ApplicationUser accessOcis(String accessOcis) {
        this.setAccessOcis(accessOcis);
        return this;
    }

    public void setAccessOcis(String accessOcis) {
        this.accessOcis = accessOcis;
    }

    public String getAccessOcm() {
        return this.accessOcm;
    }

    public ApplicationUser accessOcm(String accessOcm) {
        this.setAccessOcm(accessOcm);
        return this;
    }

    public void setAccessOcm(String accessOcm) {
        this.accessOcm = accessOcm;
    }

    public String getAccessOxi() {
        return this.accessOxi;
    }

    public ApplicationUser accessOxi(String accessOxi) {
        this.setAccessOxi(accessOxi);
        return this;
    }

    public void setAccessOxi(String accessOxi) {
        this.accessOxi = accessOxi;
    }

    public String getAccessOxihub() {
        return this.accessOxihub;
    }

    public ApplicationUser accessOxihub(String accessOxihub) {
        this.setAccessOxihub(accessOxihub);
        return this;
    }

    public void setAccessOxihub(String accessOxihub) {
        this.accessOxihub = accessOxihub;
    }

    public String getChainCode() {
        return this.chainCode;
    }

    public ApplicationUser chainCode(String chainCode) {
        this.setChainCode(chainCode);
        return this;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getAppUserUniq() {
        return this.appUserUniq;
    }

    public ApplicationUser appUserUniq(String appUserUniq) {
        this.setAppUserUniq(appUserUniq);
        return this;
    }

    public void setAppUserUniq(String appUserUniq) {
        this.appUserUniq = appUserUniq;
    }

    public Integer getMaxDaysAfterCo() {
        return this.maxDaysAfterCo;
    }

    public ApplicationUser maxDaysAfterCo(Integer maxDaysAfterCo) {
        this.setMaxDaysAfterCo(maxDaysAfterCo);
        return this;
    }

    public void setMaxDaysAfterCo(Integer maxDaysAfterCo) {
        this.maxDaysAfterCo = maxDaysAfterCo;
    }

    public String getUserGroupAdmin() {
        return this.userGroupAdmin;
    }

    public ApplicationUser userGroupAdmin(String userGroupAdmin) {
        this.setUserGroupAdmin(userGroupAdmin);
        return this;
    }

    public void setUserGroupAdmin(String userGroupAdmin) {
        this.userGroupAdmin = userGroupAdmin;
    }

    public String getAccessOrms() {
        return this.accessOrms;
    }

    public ApplicationUser accessOrms(String accessOrms) {
        this.setAccessOrms(accessOrms);
        return this;
    }

    public void setAccessOrms(String accessOrms) {
        this.accessOrms = accessOrms;
    }

    public String getAccessObi() {
        return this.accessObi;
    }

    public ApplicationUser accessObi(String accessObi) {
        this.setAccessObi(accessObi);
        return this;
    }

    public void setAccessObi(String accessObi) {
        this.accessObi = accessObi;
    }

    public String getSrepCode() {
        return this.srepCode;
    }

    public ApplicationUser srepCode(String srepCode) {
        this.setSrepCode(srepCode);
        return this;
    }

    public void setSrepCode(String srepCode) {
        this.srepCode = srepCode;
    }

    public Integer getLoginAttempts() {
        return this.loginAttempts;
    }

    public ApplicationUser loginAttempts(Integer loginAttempts) {
        this.setLoginAttempts(loginAttempts);
        return this;
    }

    public void setLoginAttempts(Integer loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public String getPropertyAccessYn() {
        return this.propertyAccessYn;
    }

    public ApplicationUser propertyAccessYn(String propertyAccessYn) {
        this.setPropertyAccessYn(propertyAccessYn);
        return this;
    }

    public void setPropertyAccessYn(String propertyAccessYn) {
        this.propertyAccessYn = propertyAccessYn;
    }

    public String getAccessScbi() {
        return this.accessScbi;
    }

    public ApplicationUser accessScbi(String accessScbi) {
        this.setAccessScbi(accessScbi);
        return this;
    }

    public void setAccessScbi(String accessScbi) {
        this.accessScbi = accessScbi;
    }

    public String getTimezoneRegion() {
        return this.timezoneRegion;
    }

    public ApplicationUser timezoneRegion(String timezoneRegion) {
        this.setTimezoneRegion(timezoneRegion);
        return this;
    }

    public void setTimezoneRegion(String timezoneRegion) {
        this.timezoneRegion = timezoneRegion;
    }

    public String getAccessOcrm() {
        return this.accessOcrm;
    }

    public ApplicationUser accessOcrm(String accessOcrm) {
        this.setAccessOcrm(accessOcrm);
        return this;
    }

    public void setAccessOcrm(String accessOcrm) {
        this.accessOcrm = accessOcrm;
    }

    public String getEmployeeIncentiveNumber() {
        return this.employeeIncentiveNumber;
    }

    public ApplicationUser employeeIncentiveNumber(String employeeIncentiveNumber) {
        this.setEmployeeIncentiveNumber(employeeIncentiveNumber);
        return this;
    }

    public void setEmployeeIncentiveNumber(String employeeIncentiveNumber) {
        this.employeeIncentiveNumber = employeeIncentiveNumber;
    }

    public String getServiceRequestAlertsYn() {
        return this.serviceRequestAlertsYn;
    }

    public ApplicationUser serviceRequestAlertsYn(String serviceRequestAlertsYn) {
        this.setServiceRequestAlertsYn(serviceRequestAlertsYn);
        return this;
    }

    public void setServiceRequestAlertsYn(String serviceRequestAlertsYn) {
        this.serviceRequestAlertsYn = serviceRequestAlertsYn;
    }

    public String getMobileAlertsYn() {
        return this.mobileAlertsYn;
    }

    public ApplicationUser mobileAlertsYn(String mobileAlertsYn) {
        this.setMobileAlertsYn(mobileAlertsYn);
        return this;
    }

    public void setMobileAlertsYn(String mobileAlertsYn) {
        this.mobileAlertsYn = mobileAlertsYn;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationUser)) {
            return false;
        }
        return getId() != null && getId().equals(((ApplicationUser) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApplicationUser{" +
            "id=" + getId() +
            ", appUserId=" + getAppUserId() +
            ", appUser='" + getAppUser() + "'" +
            ", appPassword='" + getAppPassword() + "'" +
            ", insertDate='" + getInsertDate() + "'" +
            ", insertUser=" + getInsertUser() +
            ", updateDate='" + getUpdateDate() + "'" +
            ", updateUser=" + getUpdateUser() +
            ", oracleUid=" + getOracleUid() +
            ", oracleUser='" + getOracleUser() + "'" +
            ", oraclePassword='" + getOraclePassword() + "'" +
            ", inactiveDate='" + getInactiveDate() + "'" +
            ", title='" + getTitle() + "'" +
            ", defaultForm='" + getDefaultForm() + "'" +
            ", name='" + getName() + "'" +
            ", appUserType='" + getAppUserType() + "'" +
            ", lastLoggedResort='" + getLastLoggedResort() + "'" +
            ", defCashierId=" + getDefCashierId() +
            ", appUserDescription='" + getAppUserDescription() + "'" +
            ", personNameId=" + getPersonNameId() +
            ", disabledUntil='" + getDisabledUntil() + "'" +
            ", expiresOn='" + getExpiresOn() + "'" +
            ", lastLoggedTimestamp='" + getLastLoggedTimestamp() + "'" +
            ", isSuperuser='" + getIsSuperuser() + "'" +
            ", employeeNumber='" + getEmployeeNumber() + "'" +
            ", generalFilepath='" + getGeneralFilepath() + "'" +
            ", userFilepath='" + getUserFilepath() + "'" +
            ", defaultResort='" + getDefaultResort() + "'" +
            ", maxUserSessions=" + getMaxUserSessions() +
            ", internalYn='" + getInternalYn() + "'" +
            ", maxCheckoutDays=" + getMaxCheckoutDays() +
            ", defaultTerminal='" + getDefaultTerminal() + "'" +
            ", defaultLanguage='" + getDefaultLanguage() + "'" +
            ", deptId='" + getDeptId() + "'" +
            ", maleFemale='" + getMaleFemale() + "'" +
            ", userPbxId=" + getUserPbxId() +
            ", dateHired='" + getDateHired() + "'" +
            ", workPermitNo='" + getWorkPermitNo() + "'" +
            ", workPermitExpdate='" + getWorkPermitExpdate() + "'" +
            ", rateType='" + getRateType() + "'" +
            ", salaryInterval='" + getSalaryInterval() + "'" +
            ", hourlyRate=" + getHourlyRate() +
            ", weeklySalary=" + getWeeklySalary() +
            ", otMultiplier=" + getOtMultiplier() +
            ", hireType='" + getHireType() + "'" +
            ", rehireYn='" + getRehireYn() + "'" +
            ", empExtension='" + getEmpExtension() + "'" +
            ", empPager='" + getEmpPager() + "'" +
            ", termReason='" + getTermReason() + "'" +
            ", terminatedDate='" + getTerminatedDate() + "'" +
            ", inactiveReasonCode='" + getInactiveReasonCode() + "'" +
            ", inactiveFrom='" + getInactiveFrom() + "'" +
            ", inactiveTo='" + getInactiveTo() + "'" +
            ", weekMin=" + getWeekMin() +
            ", weekMax=" + getWeekMax() +
            ", mondayMin=" + getMondayMin() +
            ", mondayMax=" + getMondayMax() +
            ", tuesdayMin=" + getTuesdayMin() +
            ", tuesdayMax=" + getTuesdayMax() +
            ", wednesdayMin=" + getWednesdayMin() +
            ", wednesdayMax=" + getWednesdayMax() +
            ", thursdayMin=" + getThursdayMin() +
            ", thursdayMax=" + getThursdayMax() +
            ", fridayMin=" + getFridayMin() +
            ", fridayMax=" + getFridayMax() +
            ", saturdayMin=" + getSaturdayMin() +
            ", saturdayMax=" + getSaturdayMax() +
            ", sundayMin=" + getSundayMin() +
            ", sundayMax=" + getSundayMax() +
            ", comments='" + getComments() + "'" +
            ", leadAddress='" + getLeadAddress() + "'" +
            ", leadComm='" + getLeadComm() + "'" +
            ", leadAddressDet='" + getLeadAddressDet() + "'" +
            ", laptopId=" + getLaptopId() +
            ", hoursPerWeek=" + getHoursPerWeek() +
            ", empStatus='" + getEmpStatus() + "'" +
            ", passwordLastChange='" + getPasswordLastChange() + "'" +
            ", passwordChangeDays=" + getPasswordChangeDays() +
            ", graceLogin=" + getGraceLogin() +
            ", srepGroup='" + getSrepGroup() + "'" +
            ", defaultReportgroup='" + getDefaultReportgroup() + "'" +
            ", authorizerYn='" + getAuthorizerYn() + "'" +
            ", authorizerInactiveDate='" + getAuthorizerInactiveDate() + "'" +
            ", sfaName='" + getSfaName() + "'" +
            ", loginCro='" + getLoginCro() + "'" +
            ", authorizerRateCode='" + getAuthorizerRateCode() + "'" +
            ", loginDomain='" + getLoginDomain() + "'" +
            ", receiveBroadcastMsg='" + getReceiveBroadcastMsg() + "'" +
            ", defaultMfnResort='" + getDefaultMfnResort() + "'" +
            ", mfnUserType='" + getMfnUserType() + "'" +
            ", forcePasswordChangeYn='" + getForcePasswordChangeYn() + "'" +
            ", accountLockedOutYn='" + getAccountLockedOutYn() + "'" +
            ", preventAccountLockout='" + getPreventAccountLockout() + "'" +
            ", lockoutDate='" + getLockoutDate() + "'" +
            ", accessPms='" + getAccessPms() + "'" +
            ", accessSc='" + getAccessSc() + "'" +
            ", accessConfig='" + getAccessConfig() + "'" +
            ", accessEod='" + getAccessEod() + "'" +
            ", accessUtil='" + getAccessUtil() + "'" +
            ", accessOrs='" + getAccessOrs() + "'" +
            ", accessSfa='" + getAccessSfa() + "'" +
            ", accessOcis='" + getAccessOcis() + "'" +
            ", accessOcm='" + getAccessOcm() + "'" +
            ", accessOxi='" + getAccessOxi() + "'" +
            ", accessOxihub='" + getAccessOxihub() + "'" +
            ", chainCode='" + getChainCode() + "'" +
            ", appUserUniq='" + getAppUserUniq() + "'" +
            ", maxDaysAfterCo=" + getMaxDaysAfterCo() +
            ", userGroupAdmin='" + getUserGroupAdmin() + "'" +
            ", accessOrms='" + getAccessOrms() + "'" +
            ", accessObi='" + getAccessObi() + "'" +
            ", srepCode='" + getSrepCode() + "'" +
            ", loginAttempts=" + getLoginAttempts() +
            ", propertyAccessYn='" + getPropertyAccessYn() + "'" +
            ", accessScbi='" + getAccessScbi() + "'" +
            ", timezoneRegion='" + getTimezoneRegion() + "'" +
            ", accessOcrm='" + getAccessOcrm() + "'" +
            ", employeeIncentiveNumber='" + getEmployeeIncentiveNumber() + "'" +
            ", serviceRequestAlertsYn='" + getServiceRequestAlertsYn() + "'" +
            ", mobileAlertsYn='" + getMobileAlertsYn() + "'" +
            "}";
    }
}
