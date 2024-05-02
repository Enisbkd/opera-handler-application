<template>
  <div>
    <h2 id="page-heading" data-cy="ApplicationUserHeading">
      <span v-text="t$('operaHandlerApplicationApp.applicationUser.home.title')" id="application-user-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.applicationUser.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ApplicationUserCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-application-user"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.applicationUser.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && applicationUsers && applicationUsers.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.applicationUser.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="applicationUsers && applicationUsers.length > 0">
      <table class="table table-striped" aria-describedby="applicationUsers">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('appUserId')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.appUserId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'appUserId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('appUser')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.appUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'appUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('appPassword')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.appPassword')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'appPassword'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('oracleUid')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.oracleUid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'oracleUid'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('oracleUser')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.oracleUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'oracleUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('oraclePassword')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.oraclePassword')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'oraclePassword'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveDate')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inactiveDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('title')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.title')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'title'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultForm')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultForm')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultForm'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('name')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.name')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'name'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('appUserType')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.appUserType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'appUserType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lastLoggedResort')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.lastLoggedResort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lastLoggedResort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defCashierId')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.defCashierId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defCashierId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('appUserDescription')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.appUserDescription')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'appUserDescription'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('personNameId')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.personNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'personNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('disabledUntil')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.disabledUntil')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'disabledUntil'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('expiresOn')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.expiresOn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'expiresOn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lastLoggedTimestamp')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.lastLoggedTimestamp')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lastLoggedTimestamp'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('isSuperuser')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.isSuperuser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isSuperuser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('employeeNumber')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.employeeNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'employeeNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('generalFilepath')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.generalFilepath')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'generalFilepath'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('userFilepath')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.userFilepath')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'userFilepath'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultResort')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultResort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultResort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxUserSessions')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.maxUserSessions')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxUserSessions'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('internalYn')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.internalYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'internalYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxCheckoutDays')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.maxCheckoutDays')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxCheckoutDays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultTerminal')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultTerminal')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultTerminal'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultLanguage')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultLanguage')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultLanguage'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('deptId')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.deptId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'deptId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maleFemale')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.maleFemale')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maleFemale'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('userPbxId')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.userPbxId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'userPbxId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dateHired')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.dateHired')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dateHired'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('workPermitNo')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.workPermitNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'workPermitNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('workPermitExpdate')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.workPermitExpdate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'workPermitExpdate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateType')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.rateType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('salaryInterval')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.salaryInterval')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'salaryInterval'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hourlyRate')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.hourlyRate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hourlyRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('weeklySalary')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.weeklySalary')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'weeklySalary'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('otMultiplier')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.otMultiplier')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'otMultiplier'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hireType')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.hireType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hireType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rehireYn')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.rehireYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rehireYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('empExtension')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.empExtension')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'empExtension'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('empPager')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.empPager')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'empPager'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('termReason')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.termReason')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'termReason'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('terminatedDate')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.terminatedDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'terminatedDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveReasonCode')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveReasonCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inactiveReasonCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveFrom')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveFrom')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inactiveFrom'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveTo')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveTo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inactiveTo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('weekMin')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.weekMin')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'weekMin'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('weekMax')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.weekMax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'weekMax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mondayMin')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.mondayMin')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mondayMin'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mondayMax')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.mondayMax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mondayMax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tuesdayMin')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.tuesdayMin')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tuesdayMin'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tuesdayMax')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.tuesdayMax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tuesdayMax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('wednesdayMin')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.wednesdayMin')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'wednesdayMin'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('wednesdayMax')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.wednesdayMax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'wednesdayMax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('thursdayMin')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.thursdayMin')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'thursdayMin'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('thursdayMax')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.thursdayMax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'thursdayMax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fridayMin')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.fridayMin')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fridayMin'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fridayMax')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.fridayMax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fridayMax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('saturdayMin')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.saturdayMin')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'saturdayMin'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('saturdayMax')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.saturdayMax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'saturdayMax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sundayMin')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.sundayMin')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sundayMin'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sundayMax')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.sundayMax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sundayMax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('comments')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.comments')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'comments'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('leadAddress')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.leadAddress')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'leadAddress'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('leadComm')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.leadComm')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'leadComm'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('leadAddressDet')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.leadAddressDet')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'leadAddressDet'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('laptopId')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.laptopId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'laptopId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hoursPerWeek')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.hoursPerWeek')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hoursPerWeek'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('empStatus')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.empStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'empStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('passwordLastChange')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.passwordLastChange')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'passwordLastChange'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('passwordChangeDays')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.passwordChangeDays')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'passwordChangeDays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('graceLogin')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.graceLogin')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'graceLogin'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('srepGroup')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.srepGroup')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'srepGroup'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultReportgroup')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultReportgroup')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultReportgroup'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('authorizerYn')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.authorizerYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'authorizerYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('authorizerInactiveDate')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.authorizerInactiveDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'authorizerInactiveDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sfaName')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.sfaName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sfaName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('loginCro')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.loginCro')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'loginCro'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('authorizerRateCode')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.authorizerRateCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'authorizerRateCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('loginDomain')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.loginDomain')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'loginDomain'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('receiveBroadcastMsg')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.receiveBroadcastMsg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'receiveBroadcastMsg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultMfnResort')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.defaultMfnResort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultMfnResort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mfnUserType')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.mfnUserType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mfnUserType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('forcePasswordChangeYn')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.forcePasswordChangeYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'forcePasswordChangeYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accountLockedOutYn')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accountLockedOutYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accountLockedOutYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('preventAccountLockout')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.preventAccountLockout')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'preventAccountLockout'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lockoutDate')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.lockoutDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lockoutDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessPms')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessPms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessPms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessSc')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessSc')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessSc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessConfig')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessConfig')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessConfig'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessEod')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessEod')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessEod'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessUtil')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessUtil')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessUtil'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessOrs')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOrs')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessOrs'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessSfa')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessSfa')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessSfa'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessOcis')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOcis')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessOcis'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessOcm')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOcm')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessOcm'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessOxi')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOxi')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessOxi'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessOxihub')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOxihub')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessOxihub'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('chainCode')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.chainCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'chainCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('appUserUniq')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.appUserUniq')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'appUserUniq'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxDaysAfterCo')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.maxDaysAfterCo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxDaysAfterCo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('userGroupAdmin')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.userGroupAdmin')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'userGroupAdmin'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessOrms')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOrms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessOrms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessObi')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessObi')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessObi'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('srepCode')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.srepCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'srepCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('loginAttempts')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.loginAttempts')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'loginAttempts'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('propertyAccessYn')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.propertyAccessYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'propertyAccessYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessScbi')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessScbi')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessScbi'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('timezoneRegion')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.timezoneRegion')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'timezoneRegion'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessOcrm')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.accessOcrm')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessOcrm'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('employeeIncentiveNumber')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.employeeIncentiveNumber')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'employeeIncentiveNumber'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('serviceRequestAlertsYn')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.serviceRequestAlertsYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'serviceRequestAlertsYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mobileAlertsYn')">
              <span v-text="t$('operaHandlerApplicationApp.applicationUser.mobileAlertsYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mobileAlertsYn'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="applicationUser in applicationUsers" :key="applicationUser.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ApplicationUserView', params: { applicationUserId: applicationUser.id } }">{{
                applicationUser.id
              }}</router-link>
            </td>
            <td>{{ applicationUser.appUserId }}</td>
            <td>{{ applicationUser.appUser }}</td>
            <td>{{ applicationUser.appPassword }}</td>
            <td>{{ applicationUser.insertDate }}</td>
            <td>{{ applicationUser.insertUser }}</td>
            <td>{{ applicationUser.updateDate }}</td>
            <td>{{ applicationUser.updateUser }}</td>
            <td>{{ applicationUser.oracleUid }}</td>
            <td>{{ applicationUser.oracleUser }}</td>
            <td>{{ applicationUser.oraclePassword }}</td>
            <td>{{ applicationUser.inactiveDate }}</td>
            <td>{{ applicationUser.title }}</td>
            <td>{{ applicationUser.defaultForm }}</td>
            <td>{{ applicationUser.name }}</td>
            <td>{{ applicationUser.appUserType }}</td>
            <td>{{ applicationUser.lastLoggedResort }}</td>
            <td>{{ applicationUser.defCashierId }}</td>
            <td>{{ applicationUser.appUserDescription }}</td>
            <td>{{ applicationUser.personNameId }}</td>
            <td>{{ applicationUser.disabledUntil }}</td>
            <td>{{ applicationUser.expiresOn }}</td>
            <td>{{ applicationUser.lastLoggedTimestamp }}</td>
            <td>{{ applicationUser.isSuperuser }}</td>
            <td>{{ applicationUser.employeeNumber }}</td>
            <td>{{ applicationUser.generalFilepath }}</td>
            <td>{{ applicationUser.userFilepath }}</td>
            <td>{{ applicationUser.defaultResort }}</td>
            <td>{{ applicationUser.maxUserSessions }}</td>
            <td>{{ applicationUser.internalYn }}</td>
            <td>{{ applicationUser.maxCheckoutDays }}</td>
            <td>{{ applicationUser.defaultTerminal }}</td>
            <td>{{ applicationUser.defaultLanguage }}</td>
            <td>{{ applicationUser.deptId }}</td>
            <td>{{ applicationUser.maleFemale }}</td>
            <td>{{ applicationUser.userPbxId }}</td>
            <td>{{ applicationUser.dateHired }}</td>
            <td>{{ applicationUser.workPermitNo }}</td>
            <td>{{ applicationUser.workPermitExpdate }}</td>
            <td>{{ applicationUser.rateType }}</td>
            <td>{{ applicationUser.salaryInterval }}</td>
            <td>{{ applicationUser.hourlyRate }}</td>
            <td>{{ applicationUser.weeklySalary }}</td>
            <td>{{ applicationUser.otMultiplier }}</td>
            <td>{{ applicationUser.hireType }}</td>
            <td>{{ applicationUser.rehireYn }}</td>
            <td>{{ applicationUser.empExtension }}</td>
            <td>{{ applicationUser.empPager }}</td>
            <td>{{ applicationUser.termReason }}</td>
            <td>{{ applicationUser.terminatedDate }}</td>
            <td>{{ applicationUser.inactiveReasonCode }}</td>
            <td>{{ applicationUser.inactiveFrom }}</td>
            <td>{{ applicationUser.inactiveTo }}</td>
            <td>{{ applicationUser.weekMin }}</td>
            <td>{{ applicationUser.weekMax }}</td>
            <td>{{ applicationUser.mondayMin }}</td>
            <td>{{ applicationUser.mondayMax }}</td>
            <td>{{ applicationUser.tuesdayMin }}</td>
            <td>{{ applicationUser.tuesdayMax }}</td>
            <td>{{ applicationUser.wednesdayMin }}</td>
            <td>{{ applicationUser.wednesdayMax }}</td>
            <td>{{ applicationUser.thursdayMin }}</td>
            <td>{{ applicationUser.thursdayMax }}</td>
            <td>{{ applicationUser.fridayMin }}</td>
            <td>{{ applicationUser.fridayMax }}</td>
            <td>{{ applicationUser.saturdayMin }}</td>
            <td>{{ applicationUser.saturdayMax }}</td>
            <td>{{ applicationUser.sundayMin }}</td>
            <td>{{ applicationUser.sundayMax }}</td>
            <td>{{ applicationUser.comments }}</td>
            <td>{{ applicationUser.leadAddress }}</td>
            <td>{{ applicationUser.leadComm }}</td>
            <td>{{ applicationUser.leadAddressDet }}</td>
            <td>{{ applicationUser.laptopId }}</td>
            <td>{{ applicationUser.hoursPerWeek }}</td>
            <td>{{ applicationUser.empStatus }}</td>
            <td>{{ applicationUser.passwordLastChange }}</td>
            <td>{{ applicationUser.passwordChangeDays }}</td>
            <td>{{ applicationUser.graceLogin }}</td>
            <td>{{ applicationUser.srepGroup }}</td>
            <td>{{ applicationUser.defaultReportgroup }}</td>
            <td>{{ applicationUser.authorizerYn }}</td>
            <td>{{ applicationUser.authorizerInactiveDate }}</td>
            <td>{{ applicationUser.sfaName }}</td>
            <td>{{ applicationUser.loginCro }}</td>
            <td>{{ applicationUser.authorizerRateCode }}</td>
            <td>{{ applicationUser.loginDomain }}</td>
            <td>{{ applicationUser.receiveBroadcastMsg }}</td>
            <td>{{ applicationUser.defaultMfnResort }}</td>
            <td>{{ applicationUser.mfnUserType }}</td>
            <td>{{ applicationUser.forcePasswordChangeYn }}</td>
            <td>{{ applicationUser.accountLockedOutYn }}</td>
            <td>{{ applicationUser.preventAccountLockout }}</td>
            <td>{{ applicationUser.lockoutDate }}</td>
            <td>{{ applicationUser.accessPms }}</td>
            <td>{{ applicationUser.accessSc }}</td>
            <td>{{ applicationUser.accessConfig }}</td>
            <td>{{ applicationUser.accessEod }}</td>
            <td>{{ applicationUser.accessUtil }}</td>
            <td>{{ applicationUser.accessOrs }}</td>
            <td>{{ applicationUser.accessSfa }}</td>
            <td>{{ applicationUser.accessOcis }}</td>
            <td>{{ applicationUser.accessOcm }}</td>
            <td>{{ applicationUser.accessOxi }}</td>
            <td>{{ applicationUser.accessOxihub }}</td>
            <td>{{ applicationUser.chainCode }}</td>
            <td>{{ applicationUser.appUserUniq }}</td>
            <td>{{ applicationUser.maxDaysAfterCo }}</td>
            <td>{{ applicationUser.userGroupAdmin }}</td>
            <td>{{ applicationUser.accessOrms }}</td>
            <td>{{ applicationUser.accessObi }}</td>
            <td>{{ applicationUser.srepCode }}</td>
            <td>{{ applicationUser.loginAttempts }}</td>
            <td>{{ applicationUser.propertyAccessYn }}</td>
            <td>{{ applicationUser.accessScbi }}</td>
            <td>{{ applicationUser.timezoneRegion }}</td>
            <td>{{ applicationUser.accessOcrm }}</td>
            <td>{{ applicationUser.employeeIncentiveNumber }}</td>
            <td>{{ applicationUser.serviceRequestAlertsYn }}</td>
            <td>{{ applicationUser.mobileAlertsYn }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ApplicationUserView', params: { applicationUserId: applicationUser.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ApplicationUserEdit', params: { applicationUserId: applicationUser.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(applicationUser)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.delete')"></span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <template #modal-title>
        <span
          id="operaHandlerApplicationApp.applicationUser.delete.question"
          data-cy="applicationUserDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p
          id="jhi-delete-applicationUser-heading"
          v-text="t$('operaHandlerApplicationApp.applicationUser.delete.question', { id: removeId })"
        ></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-applicationUser"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeApplicationUser()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="applicationUsers && applicationUsers.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./application-user.component.ts"></script>
