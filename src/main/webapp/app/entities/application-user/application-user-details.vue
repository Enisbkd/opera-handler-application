<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="applicationUser">
        <h2 class="jh-entity-heading" data-cy="applicationUserDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.applicationUser.detail.title')"></span> {{ applicationUser.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.appUserId')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.appUserId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.appUser')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.appUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.appPassword')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.appPassword }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.oracleUid')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.oracleUid }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.oracleUser')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.oracleUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.oraclePassword')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.oraclePassword }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveDate')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.inactiveDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.title')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.title }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultForm')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.defaultForm }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.name')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.name }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.appUserType')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.appUserType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.lastLoggedResort')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.lastLoggedResort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.defCashierId')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.defCashierId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.appUserDescription')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.appUserDescription }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.personNameId')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.personNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.disabledUntil')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.disabledUntil }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.expiresOn')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.expiresOn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.lastLoggedTimestamp')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.lastLoggedTimestamp }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.isSuperuser')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.isSuperuser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.employeeNumber')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.employeeNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.generalFilepath')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.generalFilepath }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.userFilepath')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.userFilepath }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultResort')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.defaultResort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.maxUserSessions')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.maxUserSessions }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.internalYn')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.internalYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.maxCheckoutDays')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.maxCheckoutDays }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultTerminal')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.defaultTerminal }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultLanguage')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.defaultLanguage }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.deptId')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.deptId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.maleFemale')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.maleFemale }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.userPbxId')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.userPbxId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.dateHired')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.dateHired }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.workPermitNo')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.workPermitNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.workPermitExpdate')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.workPermitExpdate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.rateType')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.rateType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.salaryInterval')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.salaryInterval }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.hourlyRate')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.hourlyRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.weeklySalary')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.weeklySalary }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.otMultiplier')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.otMultiplier }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.hireType')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.hireType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.rehireYn')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.rehireYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.empExtension')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.empExtension }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.empPager')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.empPager }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.termReason')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.termReason }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.terminatedDate')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.terminatedDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveReasonCode')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.inactiveReasonCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveFrom')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.inactiveFrom }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveTo')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.inactiveTo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.weekMin')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.weekMin }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.weekMax')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.weekMax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.mondayMin')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.mondayMin }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.mondayMax')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.mondayMax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.tuesdayMin')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.tuesdayMin }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.tuesdayMax')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.tuesdayMax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.wednesdayMin')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.wednesdayMin }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.wednesdayMax')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.wednesdayMax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.thursdayMin')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.thursdayMin }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.thursdayMax')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.thursdayMax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.fridayMin')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.fridayMin }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.fridayMax')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.fridayMax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.saturdayMin')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.saturdayMin }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.saturdayMax')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.saturdayMax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.sundayMin')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.sundayMin }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.sundayMax')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.sundayMax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.comments')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.comments }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.leadAddress')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.leadAddress }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.leadComm')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.leadComm }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.leadAddressDet')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.leadAddressDet }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.laptopId')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.laptopId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.hoursPerWeek')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.hoursPerWeek }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.empStatus')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.empStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.passwordLastChange')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.passwordLastChange }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.passwordChangeDays')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.passwordChangeDays }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.graceLogin')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.graceLogin }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.srepGroup')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.srepGroup }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultReportgroup')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.defaultReportgroup }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.authorizerYn')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.authorizerYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.authorizerInactiveDate')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.authorizerInactiveDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.sfaName')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.sfaName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.loginCro')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.loginCro }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.authorizerRateCode')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.authorizerRateCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.loginDomain')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.loginDomain }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.receiveBroadcastMsg')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.receiveBroadcastMsg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultMfnResort')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.defaultMfnResort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.mfnUserType')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.mfnUserType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.forcePasswordChangeYn')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.forcePasswordChangeYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accountLockedOutYn')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accountLockedOutYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.preventAccountLockout')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.preventAccountLockout }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.lockoutDate')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.lockoutDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessPms')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessPms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessSc')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessSc }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessConfig')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessConfig }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessEod')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessEod }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessUtil')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessUtil }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOrs')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessOrs }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessSfa')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessSfa }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOcis')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessOcis }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOcm')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessOcm }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOxi')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessOxi }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOxihub')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessOxihub }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.chainCode')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.chainCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.appUserUniq')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.appUserUniq }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.maxDaysAfterCo')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.maxDaysAfterCo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.userGroupAdmin')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.userGroupAdmin }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOrms')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessOrms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessObi')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessObi }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.srepCode')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.srepCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.loginAttempts')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.loginAttempts }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.propertyAccessYn')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.propertyAccessYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessScbi')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessScbi }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.timezoneRegion')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.timezoneRegion }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOcrm')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.accessOcrm }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.employeeIncentiveNumber')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.employeeIncentiveNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.serviceRequestAlertsYn')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.serviceRequestAlertsYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.mobileAlertsYn')"></span>
          </dt>
          <dd>
            <span>{{ applicationUser.mobileAlertsYn }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="applicationUser.id"
          :to="{ name: 'ApplicationUserEdit', params: { applicationUserId: applicationUser.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.edit')"></span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./application-user-details.component.ts"></script>
