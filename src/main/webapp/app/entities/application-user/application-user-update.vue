<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.applicationUser.home.createOrEditLabel"
          data-cy="ApplicationUserCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.applicationUser.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="applicationUser.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="applicationUser.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.appUserId')"
              for="application-user-appUserId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="appUserId"
              id="application-user-appUserId"
              data-cy="appUserId"
              :class="{ valid: !v$.appUserId.$invalid, invalid: v$.appUserId.$invalid }"
              v-model.number="v$.appUserId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.appUser')"
              for="application-user-appUser"
            ></label>
            <input
              type="text"
              class="form-control"
              name="appUser"
              id="application-user-appUser"
              data-cy="appUser"
              :class="{ valid: !v$.appUser.$invalid, invalid: v$.appUser.$invalid }"
              v-model="v$.appUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.appPassword')"
              for="application-user-appPassword"
            ></label>
            <input
              type="text"
              class="form-control"
              name="appPassword"
              id="application-user-appPassword"
              data-cy="appPassword"
              :class="{ valid: !v$.appPassword.$invalid, invalid: v$.appPassword.$invalid }"
              v-model="v$.appPassword.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.insertDate')"
              for="application-user-insertDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-insertDate"
                  v-model="v$.insertDate.$model"
                  name="insertDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-insertDate"
                data-cy="insertDate"
                type="text"
                class="form-control"
                name="insertDate"
                :class="{ valid: !v$.insertDate.$invalid, invalid: v$.insertDate.$invalid }"
                v-model="v$.insertDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.insertUser')"
              for="application-user-insertUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="application-user-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.updateDate')"
              for="application-user-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-updateDate"
                  v-model="v$.updateDate.$model"
                  name="updateDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-updateDate"
                data-cy="updateDate"
                type="text"
                class="form-control"
                name="updateDate"
                :class="{ valid: !v$.updateDate.$invalid, invalid: v$.updateDate.$invalid }"
                v-model="v$.updateDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.updateUser')"
              for="application-user-updateUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="application-user-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.oracleUid')"
              for="application-user-oracleUid"
            ></label>
            <input
              type="number"
              class="form-control"
              name="oracleUid"
              id="application-user-oracleUid"
              data-cy="oracleUid"
              :class="{ valid: !v$.oracleUid.$invalid, invalid: v$.oracleUid.$invalid }"
              v-model.number="v$.oracleUid.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.oracleUser')"
              for="application-user-oracleUser"
            ></label>
            <input
              type="text"
              class="form-control"
              name="oracleUser"
              id="application-user-oracleUser"
              data-cy="oracleUser"
              :class="{ valid: !v$.oracleUser.$invalid, invalid: v$.oracleUser.$invalid }"
              v-model="v$.oracleUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.oraclePassword')"
              for="application-user-oraclePassword"
            ></label>
            <input
              type="text"
              class="form-control"
              name="oraclePassword"
              id="application-user-oraclePassword"
              data-cy="oraclePassword"
              :class="{ valid: !v$.oraclePassword.$invalid, invalid: v$.oraclePassword.$invalid }"
              v-model="v$.oraclePassword.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveDate')"
              for="application-user-inactiveDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-inactiveDate"
                  v-model="v$.inactiveDate.$model"
                  name="inactiveDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-inactiveDate"
                data-cy="inactiveDate"
                type="text"
                class="form-control"
                name="inactiveDate"
                :class="{ valid: !v$.inactiveDate.$invalid, invalid: v$.inactiveDate.$invalid }"
                v-model="v$.inactiveDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.title')"
              for="application-user-title"
            ></label>
            <input
              type="text"
              class="form-control"
              name="title"
              id="application-user-title"
              data-cy="title"
              :class="{ valid: !v$.title.$invalid, invalid: v$.title.$invalid }"
              v-model="v$.title.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.defaultForm')"
              for="application-user-defaultForm"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultForm"
              id="application-user-defaultForm"
              data-cy="defaultForm"
              :class="{ valid: !v$.defaultForm.$invalid, invalid: v$.defaultForm.$invalid }"
              v-model="v$.defaultForm.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.name')"
              for="application-user-name"
            ></label>
            <input
              type="text"
              class="form-control"
              name="name"
              id="application-user-name"
              data-cy="name"
              :class="{ valid: !v$.name.$invalid, invalid: v$.name.$invalid }"
              v-model="v$.name.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.appUserType')"
              for="application-user-appUserType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="appUserType"
              id="application-user-appUserType"
              data-cy="appUserType"
              :class="{ valid: !v$.appUserType.$invalid, invalid: v$.appUserType.$invalid }"
              v-model="v$.appUserType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.lastLoggedResort')"
              for="application-user-lastLoggedResort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="lastLoggedResort"
              id="application-user-lastLoggedResort"
              data-cy="lastLoggedResort"
              :class="{ valid: !v$.lastLoggedResort.$invalid, invalid: v$.lastLoggedResort.$invalid }"
              v-model="v$.lastLoggedResort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.defCashierId')"
              for="application-user-defCashierId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="defCashierId"
              id="application-user-defCashierId"
              data-cy="defCashierId"
              :class="{ valid: !v$.defCashierId.$invalid, invalid: v$.defCashierId.$invalid }"
              v-model.number="v$.defCashierId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.appUserDescription')"
              for="application-user-appUserDescription"
            ></label>
            <input
              type="text"
              class="form-control"
              name="appUserDescription"
              id="application-user-appUserDescription"
              data-cy="appUserDescription"
              :class="{ valid: !v$.appUserDescription.$invalid, invalid: v$.appUserDescription.$invalid }"
              v-model="v$.appUserDescription.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.personNameId')"
              for="application-user-personNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="personNameId"
              id="application-user-personNameId"
              data-cy="personNameId"
              :class="{ valid: !v$.personNameId.$invalid, invalid: v$.personNameId.$invalid }"
              v-model.number="v$.personNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.disabledUntil')"
              for="application-user-disabledUntil"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-disabledUntil"
                  v-model="v$.disabledUntil.$model"
                  name="disabledUntil"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-disabledUntil"
                data-cy="disabledUntil"
                type="text"
                class="form-control"
                name="disabledUntil"
                :class="{ valid: !v$.disabledUntil.$invalid, invalid: v$.disabledUntil.$invalid }"
                v-model="v$.disabledUntil.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.expiresOn')"
              for="application-user-expiresOn"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-expiresOn"
                  v-model="v$.expiresOn.$model"
                  name="expiresOn"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-expiresOn"
                data-cy="expiresOn"
                type="text"
                class="form-control"
                name="expiresOn"
                :class="{ valid: !v$.expiresOn.$invalid, invalid: v$.expiresOn.$invalid }"
                v-model="v$.expiresOn.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.lastLoggedTimestamp')"
              for="application-user-lastLoggedTimestamp"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-lastLoggedTimestamp"
                  v-model="v$.lastLoggedTimestamp.$model"
                  name="lastLoggedTimestamp"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-lastLoggedTimestamp"
                data-cy="lastLoggedTimestamp"
                type="text"
                class="form-control"
                name="lastLoggedTimestamp"
                :class="{ valid: !v$.lastLoggedTimestamp.$invalid, invalid: v$.lastLoggedTimestamp.$invalid }"
                v-model="v$.lastLoggedTimestamp.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.isSuperuser')"
              for="application-user-isSuperuser"
            ></label>
            <input
              type="text"
              class="form-control"
              name="isSuperuser"
              id="application-user-isSuperuser"
              data-cy="isSuperuser"
              :class="{ valid: !v$.isSuperuser.$invalid, invalid: v$.isSuperuser.$invalid }"
              v-model="v$.isSuperuser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.employeeNumber')"
              for="application-user-employeeNumber"
            ></label>
            <input
              type="text"
              class="form-control"
              name="employeeNumber"
              id="application-user-employeeNumber"
              data-cy="employeeNumber"
              :class="{ valid: !v$.employeeNumber.$invalid, invalid: v$.employeeNumber.$invalid }"
              v-model="v$.employeeNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.generalFilepath')"
              for="application-user-generalFilepath"
            ></label>
            <input
              type="text"
              class="form-control"
              name="generalFilepath"
              id="application-user-generalFilepath"
              data-cy="generalFilepath"
              :class="{ valid: !v$.generalFilepath.$invalid, invalid: v$.generalFilepath.$invalid }"
              v-model="v$.generalFilepath.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.userFilepath')"
              for="application-user-userFilepath"
            ></label>
            <input
              type="text"
              class="form-control"
              name="userFilepath"
              id="application-user-userFilepath"
              data-cy="userFilepath"
              :class="{ valid: !v$.userFilepath.$invalid, invalid: v$.userFilepath.$invalid }"
              v-model="v$.userFilepath.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.defaultResort')"
              for="application-user-defaultResort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultResort"
              id="application-user-defaultResort"
              data-cy="defaultResort"
              :class="{ valid: !v$.defaultResort.$invalid, invalid: v$.defaultResort.$invalid }"
              v-model="v$.defaultResort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.maxUserSessions')"
              for="application-user-maxUserSessions"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxUserSessions"
              id="application-user-maxUserSessions"
              data-cy="maxUserSessions"
              :class="{ valid: !v$.maxUserSessions.$invalid, invalid: v$.maxUserSessions.$invalid }"
              v-model.number="v$.maxUserSessions.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.internalYn')"
              for="application-user-internalYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="internalYn"
              id="application-user-internalYn"
              data-cy="internalYn"
              :class="{ valid: !v$.internalYn.$invalid, invalid: v$.internalYn.$invalid }"
              v-model="v$.internalYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.maxCheckoutDays')"
              for="application-user-maxCheckoutDays"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxCheckoutDays"
              id="application-user-maxCheckoutDays"
              data-cy="maxCheckoutDays"
              :class="{ valid: !v$.maxCheckoutDays.$invalid, invalid: v$.maxCheckoutDays.$invalid }"
              v-model.number="v$.maxCheckoutDays.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.defaultTerminal')"
              for="application-user-defaultTerminal"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultTerminal"
              id="application-user-defaultTerminal"
              data-cy="defaultTerminal"
              :class="{ valid: !v$.defaultTerminal.$invalid, invalid: v$.defaultTerminal.$invalid }"
              v-model="v$.defaultTerminal.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.defaultLanguage')"
              for="application-user-defaultLanguage"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultLanguage"
              id="application-user-defaultLanguage"
              data-cy="defaultLanguage"
              :class="{ valid: !v$.defaultLanguage.$invalid, invalid: v$.defaultLanguage.$invalid }"
              v-model="v$.defaultLanguage.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.deptId')"
              for="application-user-deptId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="deptId"
              id="application-user-deptId"
              data-cy="deptId"
              :class="{ valid: !v$.deptId.$invalid, invalid: v$.deptId.$invalid }"
              v-model="v$.deptId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.maleFemale')"
              for="application-user-maleFemale"
            ></label>
            <input
              type="text"
              class="form-control"
              name="maleFemale"
              id="application-user-maleFemale"
              data-cy="maleFemale"
              :class="{ valid: !v$.maleFemale.$invalid, invalid: v$.maleFemale.$invalid }"
              v-model="v$.maleFemale.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.userPbxId')"
              for="application-user-userPbxId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="userPbxId"
              id="application-user-userPbxId"
              data-cy="userPbxId"
              :class="{ valid: !v$.userPbxId.$invalid, invalid: v$.userPbxId.$invalid }"
              v-model.number="v$.userPbxId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.dateHired')"
              for="application-user-dateHired"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-dateHired"
                  v-model="v$.dateHired.$model"
                  name="dateHired"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-dateHired"
                data-cy="dateHired"
                type="text"
                class="form-control"
                name="dateHired"
                :class="{ valid: !v$.dateHired.$invalid, invalid: v$.dateHired.$invalid }"
                v-model="v$.dateHired.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.workPermitNo')"
              for="application-user-workPermitNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="workPermitNo"
              id="application-user-workPermitNo"
              data-cy="workPermitNo"
              :class="{ valid: !v$.workPermitNo.$invalid, invalid: v$.workPermitNo.$invalid }"
              v-model="v$.workPermitNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.workPermitExpdate')"
              for="application-user-workPermitExpdate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-workPermitExpdate"
                  v-model="v$.workPermitExpdate.$model"
                  name="workPermitExpdate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-workPermitExpdate"
                data-cy="workPermitExpdate"
                type="text"
                class="form-control"
                name="workPermitExpdate"
                :class="{ valid: !v$.workPermitExpdate.$invalid, invalid: v$.workPermitExpdate.$invalid }"
                v-model="v$.workPermitExpdate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.rateType')"
              for="application-user-rateType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rateType"
              id="application-user-rateType"
              data-cy="rateType"
              :class="{ valid: !v$.rateType.$invalid, invalid: v$.rateType.$invalid }"
              v-model="v$.rateType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.salaryInterval')"
              for="application-user-salaryInterval"
            ></label>
            <input
              type="text"
              class="form-control"
              name="salaryInterval"
              id="application-user-salaryInterval"
              data-cy="salaryInterval"
              :class="{ valid: !v$.salaryInterval.$invalid, invalid: v$.salaryInterval.$invalid }"
              v-model="v$.salaryInterval.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.hourlyRate')"
              for="application-user-hourlyRate"
            ></label>
            <input
              type="number"
              class="form-control"
              name="hourlyRate"
              id="application-user-hourlyRate"
              data-cy="hourlyRate"
              :class="{ valid: !v$.hourlyRate.$invalid, invalid: v$.hourlyRate.$invalid }"
              v-model.number="v$.hourlyRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.weeklySalary')"
              for="application-user-weeklySalary"
            ></label>
            <input
              type="number"
              class="form-control"
              name="weeklySalary"
              id="application-user-weeklySalary"
              data-cy="weeklySalary"
              :class="{ valid: !v$.weeklySalary.$invalid, invalid: v$.weeklySalary.$invalid }"
              v-model.number="v$.weeklySalary.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.otMultiplier')"
              for="application-user-otMultiplier"
            ></label>
            <input
              type="number"
              class="form-control"
              name="otMultiplier"
              id="application-user-otMultiplier"
              data-cy="otMultiplier"
              :class="{ valid: !v$.otMultiplier.$invalid, invalid: v$.otMultiplier.$invalid }"
              v-model.number="v$.otMultiplier.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.hireType')"
              for="application-user-hireType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="hireType"
              id="application-user-hireType"
              data-cy="hireType"
              :class="{ valid: !v$.hireType.$invalid, invalid: v$.hireType.$invalid }"
              v-model="v$.hireType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.rehireYn')"
              for="application-user-rehireYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rehireYn"
              id="application-user-rehireYn"
              data-cy="rehireYn"
              :class="{ valid: !v$.rehireYn.$invalid, invalid: v$.rehireYn.$invalid }"
              v-model="v$.rehireYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.empExtension')"
              for="application-user-empExtension"
            ></label>
            <input
              type="text"
              class="form-control"
              name="empExtension"
              id="application-user-empExtension"
              data-cy="empExtension"
              :class="{ valid: !v$.empExtension.$invalid, invalid: v$.empExtension.$invalid }"
              v-model="v$.empExtension.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.empPager')"
              for="application-user-empPager"
            ></label>
            <input
              type="text"
              class="form-control"
              name="empPager"
              id="application-user-empPager"
              data-cy="empPager"
              :class="{ valid: !v$.empPager.$invalid, invalid: v$.empPager.$invalid }"
              v-model="v$.empPager.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.termReason')"
              for="application-user-termReason"
            ></label>
            <input
              type="text"
              class="form-control"
              name="termReason"
              id="application-user-termReason"
              data-cy="termReason"
              :class="{ valid: !v$.termReason.$invalid, invalid: v$.termReason.$invalid }"
              v-model="v$.termReason.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.terminatedDate')"
              for="application-user-terminatedDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-terminatedDate"
                  v-model="v$.terminatedDate.$model"
                  name="terminatedDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-terminatedDate"
                data-cy="terminatedDate"
                type="text"
                class="form-control"
                name="terminatedDate"
                :class="{ valid: !v$.terminatedDate.$invalid, invalid: v$.terminatedDate.$invalid }"
                v-model="v$.terminatedDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveReasonCode')"
              for="application-user-inactiveReasonCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="inactiveReasonCode"
              id="application-user-inactiveReasonCode"
              data-cy="inactiveReasonCode"
              :class="{ valid: !v$.inactiveReasonCode.$invalid, invalid: v$.inactiveReasonCode.$invalid }"
              v-model="v$.inactiveReasonCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveFrom')"
              for="application-user-inactiveFrom"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-inactiveFrom"
                  v-model="v$.inactiveFrom.$model"
                  name="inactiveFrom"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-inactiveFrom"
                data-cy="inactiveFrom"
                type="text"
                class="form-control"
                name="inactiveFrom"
                :class="{ valid: !v$.inactiveFrom.$invalid, invalid: v$.inactiveFrom.$invalid }"
                v-model="v$.inactiveFrom.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.inactiveTo')"
              for="application-user-inactiveTo"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-inactiveTo"
                  v-model="v$.inactiveTo.$model"
                  name="inactiveTo"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-inactiveTo"
                data-cy="inactiveTo"
                type="text"
                class="form-control"
                name="inactiveTo"
                :class="{ valid: !v$.inactiveTo.$invalid, invalid: v$.inactiveTo.$invalid }"
                v-model="v$.inactiveTo.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.weekMin')"
              for="application-user-weekMin"
            ></label>
            <input
              type="number"
              class="form-control"
              name="weekMin"
              id="application-user-weekMin"
              data-cy="weekMin"
              :class="{ valid: !v$.weekMin.$invalid, invalid: v$.weekMin.$invalid }"
              v-model.number="v$.weekMin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.weekMax')"
              for="application-user-weekMax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="weekMax"
              id="application-user-weekMax"
              data-cy="weekMax"
              :class="{ valid: !v$.weekMax.$invalid, invalid: v$.weekMax.$invalid }"
              v-model.number="v$.weekMax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.mondayMin')"
              for="application-user-mondayMin"
            ></label>
            <input
              type="number"
              class="form-control"
              name="mondayMin"
              id="application-user-mondayMin"
              data-cy="mondayMin"
              :class="{ valid: !v$.mondayMin.$invalid, invalid: v$.mondayMin.$invalid }"
              v-model.number="v$.mondayMin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.mondayMax')"
              for="application-user-mondayMax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="mondayMax"
              id="application-user-mondayMax"
              data-cy="mondayMax"
              :class="{ valid: !v$.mondayMax.$invalid, invalid: v$.mondayMax.$invalid }"
              v-model.number="v$.mondayMax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.tuesdayMin')"
              for="application-user-tuesdayMin"
            ></label>
            <input
              type="number"
              class="form-control"
              name="tuesdayMin"
              id="application-user-tuesdayMin"
              data-cy="tuesdayMin"
              :class="{ valid: !v$.tuesdayMin.$invalid, invalid: v$.tuesdayMin.$invalid }"
              v-model.number="v$.tuesdayMin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.tuesdayMax')"
              for="application-user-tuesdayMax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="tuesdayMax"
              id="application-user-tuesdayMax"
              data-cy="tuesdayMax"
              :class="{ valid: !v$.tuesdayMax.$invalid, invalid: v$.tuesdayMax.$invalid }"
              v-model.number="v$.tuesdayMax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.wednesdayMin')"
              for="application-user-wednesdayMin"
            ></label>
            <input
              type="number"
              class="form-control"
              name="wednesdayMin"
              id="application-user-wednesdayMin"
              data-cy="wednesdayMin"
              :class="{ valid: !v$.wednesdayMin.$invalid, invalid: v$.wednesdayMin.$invalid }"
              v-model.number="v$.wednesdayMin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.wednesdayMax')"
              for="application-user-wednesdayMax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="wednesdayMax"
              id="application-user-wednesdayMax"
              data-cy="wednesdayMax"
              :class="{ valid: !v$.wednesdayMax.$invalid, invalid: v$.wednesdayMax.$invalid }"
              v-model.number="v$.wednesdayMax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.thursdayMin')"
              for="application-user-thursdayMin"
            ></label>
            <input
              type="number"
              class="form-control"
              name="thursdayMin"
              id="application-user-thursdayMin"
              data-cy="thursdayMin"
              :class="{ valid: !v$.thursdayMin.$invalid, invalid: v$.thursdayMin.$invalid }"
              v-model.number="v$.thursdayMin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.thursdayMax')"
              for="application-user-thursdayMax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="thursdayMax"
              id="application-user-thursdayMax"
              data-cy="thursdayMax"
              :class="{ valid: !v$.thursdayMax.$invalid, invalid: v$.thursdayMax.$invalid }"
              v-model.number="v$.thursdayMax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.fridayMin')"
              for="application-user-fridayMin"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fridayMin"
              id="application-user-fridayMin"
              data-cy="fridayMin"
              :class="{ valid: !v$.fridayMin.$invalid, invalid: v$.fridayMin.$invalid }"
              v-model.number="v$.fridayMin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.fridayMax')"
              for="application-user-fridayMax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fridayMax"
              id="application-user-fridayMax"
              data-cy="fridayMax"
              :class="{ valid: !v$.fridayMax.$invalid, invalid: v$.fridayMax.$invalid }"
              v-model.number="v$.fridayMax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.saturdayMin')"
              for="application-user-saturdayMin"
            ></label>
            <input
              type="number"
              class="form-control"
              name="saturdayMin"
              id="application-user-saturdayMin"
              data-cy="saturdayMin"
              :class="{ valid: !v$.saturdayMin.$invalid, invalid: v$.saturdayMin.$invalid }"
              v-model.number="v$.saturdayMin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.saturdayMax')"
              for="application-user-saturdayMax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="saturdayMax"
              id="application-user-saturdayMax"
              data-cy="saturdayMax"
              :class="{ valid: !v$.saturdayMax.$invalid, invalid: v$.saturdayMax.$invalid }"
              v-model.number="v$.saturdayMax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.sundayMin')"
              for="application-user-sundayMin"
            ></label>
            <input
              type="number"
              class="form-control"
              name="sundayMin"
              id="application-user-sundayMin"
              data-cy="sundayMin"
              :class="{ valid: !v$.sundayMin.$invalid, invalid: v$.sundayMin.$invalid }"
              v-model.number="v$.sundayMin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.sundayMax')"
              for="application-user-sundayMax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="sundayMax"
              id="application-user-sundayMax"
              data-cy="sundayMax"
              :class="{ valid: !v$.sundayMax.$invalid, invalid: v$.sundayMax.$invalid }"
              v-model.number="v$.sundayMax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.comments')"
              for="application-user-comments"
            ></label>
            <input
              type="text"
              class="form-control"
              name="comments"
              id="application-user-comments"
              data-cy="comments"
              :class="{ valid: !v$.comments.$invalid, invalid: v$.comments.$invalid }"
              v-model="v$.comments.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.leadAddress')"
              for="application-user-leadAddress"
            ></label>
            <input
              type="text"
              class="form-control"
              name="leadAddress"
              id="application-user-leadAddress"
              data-cy="leadAddress"
              :class="{ valid: !v$.leadAddress.$invalid, invalid: v$.leadAddress.$invalid }"
              v-model="v$.leadAddress.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.leadComm')"
              for="application-user-leadComm"
            ></label>
            <input
              type="text"
              class="form-control"
              name="leadComm"
              id="application-user-leadComm"
              data-cy="leadComm"
              :class="{ valid: !v$.leadComm.$invalid, invalid: v$.leadComm.$invalid }"
              v-model="v$.leadComm.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.leadAddressDet')"
              for="application-user-leadAddressDet"
            ></label>
            <input
              type="text"
              class="form-control"
              name="leadAddressDet"
              id="application-user-leadAddressDet"
              data-cy="leadAddressDet"
              :class="{ valid: !v$.leadAddressDet.$invalid, invalid: v$.leadAddressDet.$invalid }"
              v-model="v$.leadAddressDet.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.laptopId')"
              for="application-user-laptopId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="laptopId"
              id="application-user-laptopId"
              data-cy="laptopId"
              :class="{ valid: !v$.laptopId.$invalid, invalid: v$.laptopId.$invalid }"
              v-model.number="v$.laptopId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.hoursPerWeek')"
              for="application-user-hoursPerWeek"
            ></label>
            <input
              type="number"
              class="form-control"
              name="hoursPerWeek"
              id="application-user-hoursPerWeek"
              data-cy="hoursPerWeek"
              :class="{ valid: !v$.hoursPerWeek.$invalid, invalid: v$.hoursPerWeek.$invalid }"
              v-model.number="v$.hoursPerWeek.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.empStatus')"
              for="application-user-empStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="empStatus"
              id="application-user-empStatus"
              data-cy="empStatus"
              :class="{ valid: !v$.empStatus.$invalid, invalid: v$.empStatus.$invalid }"
              v-model="v$.empStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.passwordLastChange')"
              for="application-user-passwordLastChange"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-passwordLastChange"
                  v-model="v$.passwordLastChange.$model"
                  name="passwordLastChange"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-passwordLastChange"
                data-cy="passwordLastChange"
                type="text"
                class="form-control"
                name="passwordLastChange"
                :class="{ valid: !v$.passwordLastChange.$invalid, invalid: v$.passwordLastChange.$invalid }"
                v-model="v$.passwordLastChange.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.passwordChangeDays')"
              for="application-user-passwordChangeDays"
            ></label>
            <input
              type="number"
              class="form-control"
              name="passwordChangeDays"
              id="application-user-passwordChangeDays"
              data-cy="passwordChangeDays"
              :class="{ valid: !v$.passwordChangeDays.$invalid, invalid: v$.passwordChangeDays.$invalid }"
              v-model.number="v$.passwordChangeDays.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.graceLogin')"
              for="application-user-graceLogin"
            ></label>
            <input
              type="number"
              class="form-control"
              name="graceLogin"
              id="application-user-graceLogin"
              data-cy="graceLogin"
              :class="{ valid: !v$.graceLogin.$invalid, invalid: v$.graceLogin.$invalid }"
              v-model.number="v$.graceLogin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.srepGroup')"
              for="application-user-srepGroup"
            ></label>
            <input
              type="text"
              class="form-control"
              name="srepGroup"
              id="application-user-srepGroup"
              data-cy="srepGroup"
              :class="{ valid: !v$.srepGroup.$invalid, invalid: v$.srepGroup.$invalid }"
              v-model="v$.srepGroup.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.defaultReportgroup')"
              for="application-user-defaultReportgroup"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultReportgroup"
              id="application-user-defaultReportgroup"
              data-cy="defaultReportgroup"
              :class="{ valid: !v$.defaultReportgroup.$invalid, invalid: v$.defaultReportgroup.$invalid }"
              v-model="v$.defaultReportgroup.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.authorizerYn')"
              for="application-user-authorizerYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="authorizerYn"
              id="application-user-authorizerYn"
              data-cy="authorizerYn"
              :class="{ valid: !v$.authorizerYn.$invalid, invalid: v$.authorizerYn.$invalid }"
              v-model="v$.authorizerYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.authorizerInactiveDate')"
              for="application-user-authorizerInactiveDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-authorizerInactiveDate"
                  v-model="v$.authorizerInactiveDate.$model"
                  name="authorizerInactiveDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-authorizerInactiveDate"
                data-cy="authorizerInactiveDate"
                type="text"
                class="form-control"
                name="authorizerInactiveDate"
                :class="{ valid: !v$.authorizerInactiveDate.$invalid, invalid: v$.authorizerInactiveDate.$invalid }"
                v-model="v$.authorizerInactiveDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.sfaName')"
              for="application-user-sfaName"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sfaName"
              id="application-user-sfaName"
              data-cy="sfaName"
              :class="{ valid: !v$.sfaName.$invalid, invalid: v$.sfaName.$invalid }"
              v-model="v$.sfaName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.loginCro')"
              for="application-user-loginCro"
            ></label>
            <input
              type="text"
              class="form-control"
              name="loginCro"
              id="application-user-loginCro"
              data-cy="loginCro"
              :class="{ valid: !v$.loginCro.$invalid, invalid: v$.loginCro.$invalid }"
              v-model="v$.loginCro.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.authorizerRateCode')"
              for="application-user-authorizerRateCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="authorizerRateCode"
              id="application-user-authorizerRateCode"
              data-cy="authorizerRateCode"
              :class="{ valid: !v$.authorizerRateCode.$invalid, invalid: v$.authorizerRateCode.$invalid }"
              v-model="v$.authorizerRateCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.loginDomain')"
              for="application-user-loginDomain"
            ></label>
            <input
              type="text"
              class="form-control"
              name="loginDomain"
              id="application-user-loginDomain"
              data-cy="loginDomain"
              :class="{ valid: !v$.loginDomain.$invalid, invalid: v$.loginDomain.$invalid }"
              v-model="v$.loginDomain.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.receiveBroadcastMsg')"
              for="application-user-receiveBroadcastMsg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="receiveBroadcastMsg"
              id="application-user-receiveBroadcastMsg"
              data-cy="receiveBroadcastMsg"
              :class="{ valid: !v$.receiveBroadcastMsg.$invalid, invalid: v$.receiveBroadcastMsg.$invalid }"
              v-model="v$.receiveBroadcastMsg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.defaultMfnResort')"
              for="application-user-defaultMfnResort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultMfnResort"
              id="application-user-defaultMfnResort"
              data-cy="defaultMfnResort"
              :class="{ valid: !v$.defaultMfnResort.$invalid, invalid: v$.defaultMfnResort.$invalid }"
              v-model="v$.defaultMfnResort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.mfnUserType')"
              for="application-user-mfnUserType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="mfnUserType"
              id="application-user-mfnUserType"
              data-cy="mfnUserType"
              :class="{ valid: !v$.mfnUserType.$invalid, invalid: v$.mfnUserType.$invalid }"
              v-model="v$.mfnUserType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.forcePasswordChangeYn')"
              for="application-user-forcePasswordChangeYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="forcePasswordChangeYn"
              id="application-user-forcePasswordChangeYn"
              data-cy="forcePasswordChangeYn"
              :class="{ valid: !v$.forcePasswordChangeYn.$invalid, invalid: v$.forcePasswordChangeYn.$invalid }"
              v-model="v$.forcePasswordChangeYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accountLockedOutYn')"
              for="application-user-accountLockedOutYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accountLockedOutYn"
              id="application-user-accountLockedOutYn"
              data-cy="accountLockedOutYn"
              :class="{ valid: !v$.accountLockedOutYn.$invalid, invalid: v$.accountLockedOutYn.$invalid }"
              v-model="v$.accountLockedOutYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.preventAccountLockout')"
              for="application-user-preventAccountLockout"
            ></label>
            <input
              type="text"
              class="form-control"
              name="preventAccountLockout"
              id="application-user-preventAccountLockout"
              data-cy="preventAccountLockout"
              :class="{ valid: !v$.preventAccountLockout.$invalid, invalid: v$.preventAccountLockout.$invalid }"
              v-model="v$.preventAccountLockout.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.lockoutDate')"
              for="application-user-lockoutDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="application-user-lockoutDate"
                  v-model="v$.lockoutDate.$model"
                  name="lockoutDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="application-user-lockoutDate"
                data-cy="lockoutDate"
                type="text"
                class="form-control"
                name="lockoutDate"
                :class="{ valid: !v$.lockoutDate.$invalid, invalid: v$.lockoutDate.$invalid }"
                v-model="v$.lockoutDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessPms')"
              for="application-user-accessPms"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessPms"
              id="application-user-accessPms"
              data-cy="accessPms"
              :class="{ valid: !v$.accessPms.$invalid, invalid: v$.accessPms.$invalid }"
              v-model="v$.accessPms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessSc')"
              for="application-user-accessSc"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessSc"
              id="application-user-accessSc"
              data-cy="accessSc"
              :class="{ valid: !v$.accessSc.$invalid, invalid: v$.accessSc.$invalid }"
              v-model="v$.accessSc.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessConfig')"
              for="application-user-accessConfig"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessConfig"
              id="application-user-accessConfig"
              data-cy="accessConfig"
              :class="{ valid: !v$.accessConfig.$invalid, invalid: v$.accessConfig.$invalid }"
              v-model="v$.accessConfig.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessEod')"
              for="application-user-accessEod"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessEod"
              id="application-user-accessEod"
              data-cy="accessEod"
              :class="{ valid: !v$.accessEod.$invalid, invalid: v$.accessEod.$invalid }"
              v-model="v$.accessEod.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessUtil')"
              for="application-user-accessUtil"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessUtil"
              id="application-user-accessUtil"
              data-cy="accessUtil"
              :class="{ valid: !v$.accessUtil.$invalid, invalid: v$.accessUtil.$invalid }"
              v-model="v$.accessUtil.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessOrs')"
              for="application-user-accessOrs"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessOrs"
              id="application-user-accessOrs"
              data-cy="accessOrs"
              :class="{ valid: !v$.accessOrs.$invalid, invalid: v$.accessOrs.$invalid }"
              v-model="v$.accessOrs.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessSfa')"
              for="application-user-accessSfa"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessSfa"
              id="application-user-accessSfa"
              data-cy="accessSfa"
              :class="{ valid: !v$.accessSfa.$invalid, invalid: v$.accessSfa.$invalid }"
              v-model="v$.accessSfa.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessOcis')"
              for="application-user-accessOcis"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessOcis"
              id="application-user-accessOcis"
              data-cy="accessOcis"
              :class="{ valid: !v$.accessOcis.$invalid, invalid: v$.accessOcis.$invalid }"
              v-model="v$.accessOcis.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessOcm')"
              for="application-user-accessOcm"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessOcm"
              id="application-user-accessOcm"
              data-cy="accessOcm"
              :class="{ valid: !v$.accessOcm.$invalid, invalid: v$.accessOcm.$invalid }"
              v-model="v$.accessOcm.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessOxi')"
              for="application-user-accessOxi"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessOxi"
              id="application-user-accessOxi"
              data-cy="accessOxi"
              :class="{ valid: !v$.accessOxi.$invalid, invalid: v$.accessOxi.$invalid }"
              v-model="v$.accessOxi.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessOxihub')"
              for="application-user-accessOxihub"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessOxihub"
              id="application-user-accessOxihub"
              data-cy="accessOxihub"
              :class="{ valid: !v$.accessOxihub.$invalid, invalid: v$.accessOxihub.$invalid }"
              v-model="v$.accessOxihub.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.chainCode')"
              for="application-user-chainCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="chainCode"
              id="application-user-chainCode"
              data-cy="chainCode"
              :class="{ valid: !v$.chainCode.$invalid, invalid: v$.chainCode.$invalid }"
              v-model="v$.chainCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.appUserUniq')"
              for="application-user-appUserUniq"
            ></label>
            <input
              type="text"
              class="form-control"
              name="appUserUniq"
              id="application-user-appUserUniq"
              data-cy="appUserUniq"
              :class="{ valid: !v$.appUserUniq.$invalid, invalid: v$.appUserUniq.$invalid }"
              v-model="v$.appUserUniq.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.maxDaysAfterCo')"
              for="application-user-maxDaysAfterCo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxDaysAfterCo"
              id="application-user-maxDaysAfterCo"
              data-cy="maxDaysAfterCo"
              :class="{ valid: !v$.maxDaysAfterCo.$invalid, invalid: v$.maxDaysAfterCo.$invalid }"
              v-model.number="v$.maxDaysAfterCo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.userGroupAdmin')"
              for="application-user-userGroupAdmin"
            ></label>
            <input
              type="text"
              class="form-control"
              name="userGroupAdmin"
              id="application-user-userGroupAdmin"
              data-cy="userGroupAdmin"
              :class="{ valid: !v$.userGroupAdmin.$invalid, invalid: v$.userGroupAdmin.$invalid }"
              v-model="v$.userGroupAdmin.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessOrms')"
              for="application-user-accessOrms"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessOrms"
              id="application-user-accessOrms"
              data-cy="accessOrms"
              :class="{ valid: !v$.accessOrms.$invalid, invalid: v$.accessOrms.$invalid }"
              v-model="v$.accessOrms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessObi')"
              for="application-user-accessObi"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessObi"
              id="application-user-accessObi"
              data-cy="accessObi"
              :class="{ valid: !v$.accessObi.$invalid, invalid: v$.accessObi.$invalid }"
              v-model="v$.accessObi.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.srepCode')"
              for="application-user-srepCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="srepCode"
              id="application-user-srepCode"
              data-cy="srepCode"
              :class="{ valid: !v$.srepCode.$invalid, invalid: v$.srepCode.$invalid }"
              v-model="v$.srepCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.loginAttempts')"
              for="application-user-loginAttempts"
            ></label>
            <input
              type="number"
              class="form-control"
              name="loginAttempts"
              id="application-user-loginAttempts"
              data-cy="loginAttempts"
              :class="{ valid: !v$.loginAttempts.$invalid, invalid: v$.loginAttempts.$invalid }"
              v-model.number="v$.loginAttempts.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.propertyAccessYn')"
              for="application-user-propertyAccessYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="propertyAccessYn"
              id="application-user-propertyAccessYn"
              data-cy="propertyAccessYn"
              :class="{ valid: !v$.propertyAccessYn.$invalid, invalid: v$.propertyAccessYn.$invalid }"
              v-model="v$.propertyAccessYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessScbi')"
              for="application-user-accessScbi"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessScbi"
              id="application-user-accessScbi"
              data-cy="accessScbi"
              :class="{ valid: !v$.accessScbi.$invalid, invalid: v$.accessScbi.$invalid }"
              v-model="v$.accessScbi.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.timezoneRegion')"
              for="application-user-timezoneRegion"
            ></label>
            <input
              type="text"
              class="form-control"
              name="timezoneRegion"
              id="application-user-timezoneRegion"
              data-cy="timezoneRegion"
              :class="{ valid: !v$.timezoneRegion.$invalid, invalid: v$.timezoneRegion.$invalid }"
              v-model="v$.timezoneRegion.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.accessOcrm')"
              for="application-user-accessOcrm"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessOcrm"
              id="application-user-accessOcrm"
              data-cy="accessOcrm"
              :class="{ valid: !v$.accessOcrm.$invalid, invalid: v$.accessOcrm.$invalid }"
              v-model="v$.accessOcrm.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.employeeIncentiveNumber')"
              for="application-user-employeeIncentiveNumber"
            ></label>
            <input
              type="text"
              class="form-control"
              name="employeeIncentiveNumber"
              id="application-user-employeeIncentiveNumber"
              data-cy="employeeIncentiveNumber"
              :class="{ valid: !v$.employeeIncentiveNumber.$invalid, invalid: v$.employeeIncentiveNumber.$invalid }"
              v-model="v$.employeeIncentiveNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.serviceRequestAlertsYn')"
              for="application-user-serviceRequestAlertsYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="serviceRequestAlertsYn"
              id="application-user-serviceRequestAlertsYn"
              data-cy="serviceRequestAlertsYn"
              :class="{ valid: !v$.serviceRequestAlertsYn.$invalid, invalid: v$.serviceRequestAlertsYn.$invalid }"
              v-model="v$.serviceRequestAlertsYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.applicationUser.mobileAlertsYn')"
              for="application-user-mobileAlertsYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="mobileAlertsYn"
              id="application-user-mobileAlertsYn"
              data-cy="mobileAlertsYn"
              :class="{ valid: !v$.mobileAlertsYn.$invalid, invalid: v$.mobileAlertsYn.$invalid }"
              v-model="v$.mobileAlertsYn.$model"
            />
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.cancel')"></span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="v$.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.save')"></span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./application-user-update.component.ts"></script>
