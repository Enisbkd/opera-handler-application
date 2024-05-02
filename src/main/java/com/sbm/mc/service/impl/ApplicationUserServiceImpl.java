package com.sbm.mc.service.impl;

import com.sbm.mc.domain.ApplicationUser;
import com.sbm.mc.repository.ApplicationUserRepository;
import com.sbm.mc.service.ApplicationUserService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.ApplicationUser}.
 */
@Service
@Transactional
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final Logger log = LoggerFactory.getLogger(ApplicationUserServiceImpl.class);

    private final ApplicationUserRepository applicationUserRepository;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public ApplicationUser save(ApplicationUser applicationUser) {
        log.debug("Request to save ApplicationUser : {}", applicationUser);
        return applicationUserRepository.save(applicationUser);
    }

    @Override
    public ApplicationUser update(ApplicationUser applicationUser) {
        log.debug("Request to update ApplicationUser : {}", applicationUser);
        return applicationUserRepository.save(applicationUser);
    }

    @Override
    public Optional<ApplicationUser> partialUpdate(ApplicationUser applicationUser) {
        log.debug("Request to partially update ApplicationUser : {}", applicationUser);

        return applicationUserRepository
            .findById(applicationUser.getId())
            .map(existingApplicationUser -> {
                if (applicationUser.getAppUserId() != null) {
                    existingApplicationUser.setAppUserId(applicationUser.getAppUserId());
                }
                if (applicationUser.getAppUser() != null) {
                    existingApplicationUser.setAppUser(applicationUser.getAppUser());
                }
                if (applicationUser.getAppPassword() != null) {
                    existingApplicationUser.setAppPassword(applicationUser.getAppPassword());
                }
                if (applicationUser.getInsertDate() != null) {
                    existingApplicationUser.setInsertDate(applicationUser.getInsertDate());
                }
                if (applicationUser.getInsertUser() != null) {
                    existingApplicationUser.setInsertUser(applicationUser.getInsertUser());
                }
                if (applicationUser.getUpdateDate() != null) {
                    existingApplicationUser.setUpdateDate(applicationUser.getUpdateDate());
                }
                if (applicationUser.getUpdateUser() != null) {
                    existingApplicationUser.setUpdateUser(applicationUser.getUpdateUser());
                }
                if (applicationUser.getOracleUid() != null) {
                    existingApplicationUser.setOracleUid(applicationUser.getOracleUid());
                }
                if (applicationUser.getOracleUser() != null) {
                    existingApplicationUser.setOracleUser(applicationUser.getOracleUser());
                }
                if (applicationUser.getOraclePassword() != null) {
                    existingApplicationUser.setOraclePassword(applicationUser.getOraclePassword());
                }
                if (applicationUser.getInactiveDate() != null) {
                    existingApplicationUser.setInactiveDate(applicationUser.getInactiveDate());
                }
                if (applicationUser.getTitle() != null) {
                    existingApplicationUser.setTitle(applicationUser.getTitle());
                }
                if (applicationUser.getDefaultForm() != null) {
                    existingApplicationUser.setDefaultForm(applicationUser.getDefaultForm());
                }
                if (applicationUser.getName() != null) {
                    existingApplicationUser.setName(applicationUser.getName());
                }
                if (applicationUser.getAppUserType() != null) {
                    existingApplicationUser.setAppUserType(applicationUser.getAppUserType());
                }
                if (applicationUser.getLastLoggedResort() != null) {
                    existingApplicationUser.setLastLoggedResort(applicationUser.getLastLoggedResort());
                }
                if (applicationUser.getDefCashierId() != null) {
                    existingApplicationUser.setDefCashierId(applicationUser.getDefCashierId());
                }
                if (applicationUser.getAppUserDescription() != null) {
                    existingApplicationUser.setAppUserDescription(applicationUser.getAppUserDescription());
                }
                if (applicationUser.getPersonNameId() != null) {
                    existingApplicationUser.setPersonNameId(applicationUser.getPersonNameId());
                }
                if (applicationUser.getDisabledUntil() != null) {
                    existingApplicationUser.setDisabledUntil(applicationUser.getDisabledUntil());
                }
                if (applicationUser.getExpiresOn() != null) {
                    existingApplicationUser.setExpiresOn(applicationUser.getExpiresOn());
                }
                if (applicationUser.getLastLoggedTimestamp() != null) {
                    existingApplicationUser.setLastLoggedTimestamp(applicationUser.getLastLoggedTimestamp());
                }
                if (applicationUser.getIsSuperuser() != null) {
                    existingApplicationUser.setIsSuperuser(applicationUser.getIsSuperuser());
                }
                if (applicationUser.getEmployeeNumber() != null) {
                    existingApplicationUser.setEmployeeNumber(applicationUser.getEmployeeNumber());
                }
                if (applicationUser.getGeneralFilepath() != null) {
                    existingApplicationUser.setGeneralFilepath(applicationUser.getGeneralFilepath());
                }
                if (applicationUser.getUserFilepath() != null) {
                    existingApplicationUser.setUserFilepath(applicationUser.getUserFilepath());
                }
                if (applicationUser.getDefaultResort() != null) {
                    existingApplicationUser.setDefaultResort(applicationUser.getDefaultResort());
                }
                if (applicationUser.getMaxUserSessions() != null) {
                    existingApplicationUser.setMaxUserSessions(applicationUser.getMaxUserSessions());
                }
                if (applicationUser.getInternalYn() != null) {
                    existingApplicationUser.setInternalYn(applicationUser.getInternalYn());
                }
                if (applicationUser.getMaxCheckoutDays() != null) {
                    existingApplicationUser.setMaxCheckoutDays(applicationUser.getMaxCheckoutDays());
                }
                if (applicationUser.getDefaultTerminal() != null) {
                    existingApplicationUser.setDefaultTerminal(applicationUser.getDefaultTerminal());
                }
                if (applicationUser.getDefaultLanguage() != null) {
                    existingApplicationUser.setDefaultLanguage(applicationUser.getDefaultLanguage());
                }
                if (applicationUser.getDeptId() != null) {
                    existingApplicationUser.setDeptId(applicationUser.getDeptId());
                }
                if (applicationUser.getMaleFemale() != null) {
                    existingApplicationUser.setMaleFemale(applicationUser.getMaleFemale());
                }
                if (applicationUser.getUserPbxId() != null) {
                    existingApplicationUser.setUserPbxId(applicationUser.getUserPbxId());
                }
                if (applicationUser.getDateHired() != null) {
                    existingApplicationUser.setDateHired(applicationUser.getDateHired());
                }
                if (applicationUser.getWorkPermitNo() != null) {
                    existingApplicationUser.setWorkPermitNo(applicationUser.getWorkPermitNo());
                }
                if (applicationUser.getWorkPermitExpdate() != null) {
                    existingApplicationUser.setWorkPermitExpdate(applicationUser.getWorkPermitExpdate());
                }
                if (applicationUser.getRateType() != null) {
                    existingApplicationUser.setRateType(applicationUser.getRateType());
                }
                if (applicationUser.getSalaryInterval() != null) {
                    existingApplicationUser.setSalaryInterval(applicationUser.getSalaryInterval());
                }
                if (applicationUser.getHourlyRate() != null) {
                    existingApplicationUser.setHourlyRate(applicationUser.getHourlyRate());
                }
                if (applicationUser.getWeeklySalary() != null) {
                    existingApplicationUser.setWeeklySalary(applicationUser.getWeeklySalary());
                }
                if (applicationUser.getOtMultiplier() != null) {
                    existingApplicationUser.setOtMultiplier(applicationUser.getOtMultiplier());
                }
                if (applicationUser.getHireType() != null) {
                    existingApplicationUser.setHireType(applicationUser.getHireType());
                }
                if (applicationUser.getRehireYn() != null) {
                    existingApplicationUser.setRehireYn(applicationUser.getRehireYn());
                }
                if (applicationUser.getEmpExtension() != null) {
                    existingApplicationUser.setEmpExtension(applicationUser.getEmpExtension());
                }
                if (applicationUser.getEmpPager() != null) {
                    existingApplicationUser.setEmpPager(applicationUser.getEmpPager());
                }
                if (applicationUser.getTermReason() != null) {
                    existingApplicationUser.setTermReason(applicationUser.getTermReason());
                }
                if (applicationUser.getTerminatedDate() != null) {
                    existingApplicationUser.setTerminatedDate(applicationUser.getTerminatedDate());
                }
                if (applicationUser.getInactiveReasonCode() != null) {
                    existingApplicationUser.setInactiveReasonCode(applicationUser.getInactiveReasonCode());
                }
                if (applicationUser.getInactiveFrom() != null) {
                    existingApplicationUser.setInactiveFrom(applicationUser.getInactiveFrom());
                }
                if (applicationUser.getInactiveTo() != null) {
                    existingApplicationUser.setInactiveTo(applicationUser.getInactiveTo());
                }
                if (applicationUser.getWeekMin() != null) {
                    existingApplicationUser.setWeekMin(applicationUser.getWeekMin());
                }
                if (applicationUser.getWeekMax() != null) {
                    existingApplicationUser.setWeekMax(applicationUser.getWeekMax());
                }
                if (applicationUser.getMondayMin() != null) {
                    existingApplicationUser.setMondayMin(applicationUser.getMondayMin());
                }
                if (applicationUser.getMondayMax() != null) {
                    existingApplicationUser.setMondayMax(applicationUser.getMondayMax());
                }
                if (applicationUser.getTuesdayMin() != null) {
                    existingApplicationUser.setTuesdayMin(applicationUser.getTuesdayMin());
                }
                if (applicationUser.getTuesdayMax() != null) {
                    existingApplicationUser.setTuesdayMax(applicationUser.getTuesdayMax());
                }
                if (applicationUser.getWednesdayMin() != null) {
                    existingApplicationUser.setWednesdayMin(applicationUser.getWednesdayMin());
                }
                if (applicationUser.getWednesdayMax() != null) {
                    existingApplicationUser.setWednesdayMax(applicationUser.getWednesdayMax());
                }
                if (applicationUser.getThursdayMin() != null) {
                    existingApplicationUser.setThursdayMin(applicationUser.getThursdayMin());
                }
                if (applicationUser.getThursdayMax() != null) {
                    existingApplicationUser.setThursdayMax(applicationUser.getThursdayMax());
                }
                if (applicationUser.getFridayMin() != null) {
                    existingApplicationUser.setFridayMin(applicationUser.getFridayMin());
                }
                if (applicationUser.getFridayMax() != null) {
                    existingApplicationUser.setFridayMax(applicationUser.getFridayMax());
                }
                if (applicationUser.getSaturdayMin() != null) {
                    existingApplicationUser.setSaturdayMin(applicationUser.getSaturdayMin());
                }
                if (applicationUser.getSaturdayMax() != null) {
                    existingApplicationUser.setSaturdayMax(applicationUser.getSaturdayMax());
                }
                if (applicationUser.getSundayMin() != null) {
                    existingApplicationUser.setSundayMin(applicationUser.getSundayMin());
                }
                if (applicationUser.getSundayMax() != null) {
                    existingApplicationUser.setSundayMax(applicationUser.getSundayMax());
                }
                if (applicationUser.getComments() != null) {
                    existingApplicationUser.setComments(applicationUser.getComments());
                }
                if (applicationUser.getLeadAddress() != null) {
                    existingApplicationUser.setLeadAddress(applicationUser.getLeadAddress());
                }
                if (applicationUser.getLeadComm() != null) {
                    existingApplicationUser.setLeadComm(applicationUser.getLeadComm());
                }
                if (applicationUser.getLeadAddressDet() != null) {
                    existingApplicationUser.setLeadAddressDet(applicationUser.getLeadAddressDet());
                }
                if (applicationUser.getLaptopId() != null) {
                    existingApplicationUser.setLaptopId(applicationUser.getLaptopId());
                }
                if (applicationUser.getHoursPerWeek() != null) {
                    existingApplicationUser.setHoursPerWeek(applicationUser.getHoursPerWeek());
                }
                if (applicationUser.getEmpStatus() != null) {
                    existingApplicationUser.setEmpStatus(applicationUser.getEmpStatus());
                }
                if (applicationUser.getPasswordLastChange() != null) {
                    existingApplicationUser.setPasswordLastChange(applicationUser.getPasswordLastChange());
                }
                if (applicationUser.getPasswordChangeDays() != null) {
                    existingApplicationUser.setPasswordChangeDays(applicationUser.getPasswordChangeDays());
                }
                if (applicationUser.getGraceLogin() != null) {
                    existingApplicationUser.setGraceLogin(applicationUser.getGraceLogin());
                }
                if (applicationUser.getSrepGroup() != null) {
                    existingApplicationUser.setSrepGroup(applicationUser.getSrepGroup());
                }
                if (applicationUser.getDefaultReportgroup() != null) {
                    existingApplicationUser.setDefaultReportgroup(applicationUser.getDefaultReportgroup());
                }
                if (applicationUser.getAuthorizerYn() != null) {
                    existingApplicationUser.setAuthorizerYn(applicationUser.getAuthorizerYn());
                }
                if (applicationUser.getAuthorizerInactiveDate() != null) {
                    existingApplicationUser.setAuthorizerInactiveDate(applicationUser.getAuthorizerInactiveDate());
                }
                if (applicationUser.getSfaName() != null) {
                    existingApplicationUser.setSfaName(applicationUser.getSfaName());
                }
                if (applicationUser.getLoginCro() != null) {
                    existingApplicationUser.setLoginCro(applicationUser.getLoginCro());
                }
                if (applicationUser.getAuthorizerRateCode() != null) {
                    existingApplicationUser.setAuthorizerRateCode(applicationUser.getAuthorizerRateCode());
                }
                if (applicationUser.getLoginDomain() != null) {
                    existingApplicationUser.setLoginDomain(applicationUser.getLoginDomain());
                }
                if (applicationUser.getReceiveBroadcastMsg() != null) {
                    existingApplicationUser.setReceiveBroadcastMsg(applicationUser.getReceiveBroadcastMsg());
                }
                if (applicationUser.getDefaultMfnResort() != null) {
                    existingApplicationUser.setDefaultMfnResort(applicationUser.getDefaultMfnResort());
                }
                if (applicationUser.getMfnUserType() != null) {
                    existingApplicationUser.setMfnUserType(applicationUser.getMfnUserType());
                }
                if (applicationUser.getForcePasswordChangeYn() != null) {
                    existingApplicationUser.setForcePasswordChangeYn(applicationUser.getForcePasswordChangeYn());
                }
                if (applicationUser.getAccountLockedOutYn() != null) {
                    existingApplicationUser.setAccountLockedOutYn(applicationUser.getAccountLockedOutYn());
                }
                if (applicationUser.getPreventAccountLockout() != null) {
                    existingApplicationUser.setPreventAccountLockout(applicationUser.getPreventAccountLockout());
                }
                if (applicationUser.getLockoutDate() != null) {
                    existingApplicationUser.setLockoutDate(applicationUser.getLockoutDate());
                }
                if (applicationUser.getAccessPms() != null) {
                    existingApplicationUser.setAccessPms(applicationUser.getAccessPms());
                }
                if (applicationUser.getAccessSc() != null) {
                    existingApplicationUser.setAccessSc(applicationUser.getAccessSc());
                }
                if (applicationUser.getAccessConfig() != null) {
                    existingApplicationUser.setAccessConfig(applicationUser.getAccessConfig());
                }
                if (applicationUser.getAccessEod() != null) {
                    existingApplicationUser.setAccessEod(applicationUser.getAccessEod());
                }
                if (applicationUser.getAccessUtil() != null) {
                    existingApplicationUser.setAccessUtil(applicationUser.getAccessUtil());
                }
                if (applicationUser.getAccessOrs() != null) {
                    existingApplicationUser.setAccessOrs(applicationUser.getAccessOrs());
                }
                if (applicationUser.getAccessSfa() != null) {
                    existingApplicationUser.setAccessSfa(applicationUser.getAccessSfa());
                }
                if (applicationUser.getAccessOcis() != null) {
                    existingApplicationUser.setAccessOcis(applicationUser.getAccessOcis());
                }
                if (applicationUser.getAccessOcm() != null) {
                    existingApplicationUser.setAccessOcm(applicationUser.getAccessOcm());
                }
                if (applicationUser.getAccessOxi() != null) {
                    existingApplicationUser.setAccessOxi(applicationUser.getAccessOxi());
                }
                if (applicationUser.getAccessOxihub() != null) {
                    existingApplicationUser.setAccessOxihub(applicationUser.getAccessOxihub());
                }
                if (applicationUser.getChainCode() != null) {
                    existingApplicationUser.setChainCode(applicationUser.getChainCode());
                }
                if (applicationUser.getAppUserUniq() != null) {
                    existingApplicationUser.setAppUserUniq(applicationUser.getAppUserUniq());
                }
                if (applicationUser.getMaxDaysAfterCo() != null) {
                    existingApplicationUser.setMaxDaysAfterCo(applicationUser.getMaxDaysAfterCo());
                }
                if (applicationUser.getUserGroupAdmin() != null) {
                    existingApplicationUser.setUserGroupAdmin(applicationUser.getUserGroupAdmin());
                }
                if (applicationUser.getAccessOrms() != null) {
                    existingApplicationUser.setAccessOrms(applicationUser.getAccessOrms());
                }
                if (applicationUser.getAccessObi() != null) {
                    existingApplicationUser.setAccessObi(applicationUser.getAccessObi());
                }
                if (applicationUser.getSrepCode() != null) {
                    existingApplicationUser.setSrepCode(applicationUser.getSrepCode());
                }
                if (applicationUser.getLoginAttempts() != null) {
                    existingApplicationUser.setLoginAttempts(applicationUser.getLoginAttempts());
                }
                if (applicationUser.getPropertyAccessYn() != null) {
                    existingApplicationUser.setPropertyAccessYn(applicationUser.getPropertyAccessYn());
                }
                if (applicationUser.getAccessScbi() != null) {
                    existingApplicationUser.setAccessScbi(applicationUser.getAccessScbi());
                }
                if (applicationUser.getTimezoneRegion() != null) {
                    existingApplicationUser.setTimezoneRegion(applicationUser.getTimezoneRegion());
                }
                if (applicationUser.getAccessOcrm() != null) {
                    existingApplicationUser.setAccessOcrm(applicationUser.getAccessOcrm());
                }
                if (applicationUser.getEmployeeIncentiveNumber() != null) {
                    existingApplicationUser.setEmployeeIncentiveNumber(applicationUser.getEmployeeIncentiveNumber());
                }
                if (applicationUser.getServiceRequestAlertsYn() != null) {
                    existingApplicationUser.setServiceRequestAlertsYn(applicationUser.getServiceRequestAlertsYn());
                }
                if (applicationUser.getMobileAlertsYn() != null) {
                    existingApplicationUser.setMobileAlertsYn(applicationUser.getMobileAlertsYn());
                }

                return existingApplicationUser;
            })
            .map(applicationUserRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ApplicationUser> findAll(Pageable pageable) {
        log.debug("Request to get all ApplicationUsers");
        return applicationUserRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ApplicationUser> findOne(Integer id) {
        log.debug("Request to get ApplicationUser : {}", id);
        return applicationUserRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete ApplicationUser : {}", id);
        applicationUserRepository.deleteById(id);
    }
}
