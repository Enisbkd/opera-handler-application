<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.namePhone.home.createOrEditLabel"
          data-cy="NamePhoneCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.namePhone.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="namePhone.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="namePhone.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.namePhone.phoneId')" for="name-phone-phoneId"></label>
            <input
              type="number"
              class="form-control"
              name="phoneId"
              id="name-phone-phoneId"
              data-cy="phoneId"
              :class="{ valid: !v$.phoneId.$invalid, invalid: v$.phoneId.$invalid }"
              v-model.number="v$.phoneId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.namePhone.nameId')" for="name-phone-nameId"></label>
            <input
              type="number"
              class="form-control"
              name="nameId"
              id="name-phone-nameId"
              data-cy="nameId"
              :class="{ valid: !v$.nameId.$invalid, invalid: v$.nameId.$invalid }"
              v-model.number="v$.nameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.phoneType')"
              for="name-phone-phoneType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="phoneType"
              id="name-phone-phoneType"
              data-cy="phoneType"
              :class="{ valid: !v$.phoneType.$invalid, invalid: v$.phoneType.$invalid }"
              v-model="v$.phoneType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.phoneRole')"
              for="name-phone-phoneRole"
            ></label>
            <input
              type="text"
              class="form-control"
              name="phoneRole"
              id="name-phone-phoneRole"
              data-cy="phoneRole"
              :class="{ valid: !v$.phoneRole.$invalid, invalid: v$.phoneRole.$invalid }"
              v-model="v$.phoneRole.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.phoneNumber')"
              for="name-phone-phoneNumber"
            ></label>
            <input
              type="text"
              class="form-control"
              name="phoneNumber"
              id="name-phone-phoneNumber"
              data-cy="phoneNumber"
              :class="{ valid: !v$.phoneNumber.$invalid, invalid: v$.phoneNumber.$invalid }"
              v-model="v$.phoneNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.insertDate')"
              for="name-phone-insertDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-phone-insertDate"
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
                id="name-phone-insertDate"
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
              v-text="t$('operaHandlerApplicationApp.namePhone.insertUser')"
              for="name-phone-insertUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="name-phone-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.updateDate')"
              for="name-phone-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-phone-updateDate"
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
                id="name-phone-updateDate"
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
              v-text="t$('operaHandlerApplicationApp.namePhone.updateUser')"
              for="name-phone-updateUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="name-phone-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.inactiveDate')"
              for="name-phone-inactiveDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-phone-inactiveDate"
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
                id="name-phone-inactiveDate"
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
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.namePhone.endDate')" for="name-phone-endDate"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-phone-endDate"
                  v-model="v$.endDate.$model"
                  name="endDate"
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
                id="name-phone-endDate"
                data-cy="endDate"
                type="text"
                class="form-control"
                name="endDate"
                :class="{ valid: !v$.endDate.$invalid, invalid: v$.endDate.$invalid }"
                v-model="v$.endDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.beginDate')"
              for="name-phone-beginDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-phone-beginDate"
                  v-model="v$.beginDate.$model"
                  name="beginDate"
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
                id="name-phone-beginDate"
                data-cy="beginDate"
                type="text"
                class="form-control"
                name="beginDate"
                :class="{ valid: !v$.beginDate.$invalid, invalid: v$.beginDate.$invalid }"
                v-model="v$.beginDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.addressId')"
              for="name-phone-addressId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="addressId"
              id="name-phone-addressId"
              data-cy="addressId"
              :class="{ valid: !v$.addressId.$invalid, invalid: v$.addressId.$invalid }"
              v-model.number="v$.addressId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.primaryYn')"
              for="name-phone-primaryYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="primaryYn"
              id="name-phone-primaryYn"
              data-cy="primaryYn"
              :class="{ valid: !v$.primaryYn.$invalid, invalid: v$.primaryYn.$invalid }"
              v-model="v$.primaryYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.displaySeq')"
              for="name-phone-displaySeq"
            ></label>
            <input
              type="number"
              class="form-control"
              name="displaySeq"
              id="name-phone-displaySeq"
              data-cy="displaySeq"
              :class="{ valid: !v$.displaySeq.$invalid, invalid: v$.displaySeq.$invalid }"
              v-model.number="v$.displaySeq.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.laptopChange')"
              for="name-phone-laptopChange"
            ></label>
            <input
              type="number"
              class="form-control"
              name="laptopChange"
              id="name-phone-laptopChange"
              data-cy="laptopChange"
              :class="{ valid: !v$.laptopChange.$invalid, invalid: v$.laptopChange.$invalid }"
              v-model.number="v$.laptopChange.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.indexPhone')"
              for="name-phone-indexPhone"
            ></label>
            <input
              type="text"
              class="form-control"
              name="indexPhone"
              id="name-phone-indexPhone"
              data-cy="indexPhone"
              :class="{ valid: !v$.indexPhone.$invalid, invalid: v$.indexPhone.$invalid }"
              v-model="v$.indexPhone.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.extension')"
              for="name-phone-extension"
            ></label>
            <input
              type="text"
              class="form-control"
              name="extension"
              id="name-phone-extension"
              data-cy="extension"
              :class="{ valid: !v$.extension.$invalid, invalid: v$.extension.$invalid }"
              v-model="v$.extension.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.emailFormat')"
              for="name-phone-emailFormat"
            ></label>
            <input
              type="text"
              class="form-control"
              name="emailFormat"
              id="name-phone-emailFormat"
              data-cy="emailFormat"
              :class="{ valid: !v$.emailFormat.$invalid, invalid: v$.emailFormat.$invalid }"
              v-model="v$.emailFormat.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.shareEmailYn')"
              for="name-phone-shareEmailYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="shareEmailYn"
              id="name-phone-shareEmailYn"
              data-cy="shareEmailYn"
              :class="{ valid: !v$.shareEmailYn.$invalid, invalid: v$.shareEmailYn.$invalid }"
              v-model="v$.shareEmailYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.defaultConfirmationYn')"
              for="name-phone-defaultConfirmationYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultConfirmationYn"
              id="name-phone-defaultConfirmationYn"
              data-cy="defaultConfirmationYn"
              :class="{ valid: !v$.defaultConfirmationYn.$invalid, invalid: v$.defaultConfirmationYn.$invalid }"
              v-model="v$.defaultConfirmationYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.emailLanguage')"
              for="name-phone-emailLanguage"
            ></label>
            <input
              type="text"
              class="form-control"
              name="emailLanguage"
              id="name-phone-emailLanguage"
              data-cy="emailLanguage"
              :class="{ valid: !v$.emailLanguage.$invalid, invalid: v$.emailLanguage.$invalid }"
              v-model="v$.emailLanguage.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.mobileAudioKeyYn')"
              for="name-phone-mobileAudioKeyYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="mobileAudioKeyYn"
              id="name-phone-mobileAudioKeyYn"
              data-cy="mobileAudioKeyYn"
              :class="{ valid: !v$.mobileAudioKeyYn.$invalid, invalid: v$.mobileAudioKeyYn.$invalid }"
              v-model="v$.mobileAudioKeyYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.countryDialingCode')"
              for="name-phone-countryDialingCode"
            ></label>
            <input
              type="number"
              class="form-control"
              name="countryDialingCode"
              id="name-phone-countryDialingCode"
              data-cy="countryDialingCode"
              :class="{ valid: !v$.countryDialingCode.$invalid, invalid: v$.countryDialingCode.$invalid }"
              v-model.number="v$.countryDialingCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.namePhone.validYn')" for="name-phone-validYn"></label>
            <input
              type="text"
              class="form-control"
              name="validYn"
              id="name-phone-validYn"
              data-cy="validYn"
              :class="{ valid: !v$.validYn.$invalid, invalid: v$.validYn.$invalid }"
              v-model="v$.validYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.phoneCountryCode')"
              for="name-phone-phoneCountryCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="phoneCountryCode"
              id="name-phone-phoneCountryCode"
              data-cy="phoneCountryCode"
              :class="{ valid: !v$.phoneCountryCode.$invalid, invalid: v$.phoneCountryCode.$invalid }"
              v-model="v$.phoneCountryCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.chainCode')"
              for="name-phone-chainCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="chainCode"
              id="name-phone-chainCode"
              data-cy="chainCode"
              :class="{ valid: !v$.chainCode.$invalid, invalid: v$.chainCode.$invalid }"
              v-model="v$.chainCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.validateDate')"
              for="name-phone-validateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-phone-validateDate"
                  v-model="v$.validateDate.$model"
                  name="validateDate"
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
                id="name-phone-validateDate"
                data-cy="validateDate"
                type="text"
                class="form-control"
                name="validateDate"
                :class="{ valid: !v$.validateDate.$invalid, invalid: v$.validateDate.$invalid }"
                v-model="v$.validateDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.namePhone.validateStatus')"
              for="name-phone-validateStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="validateStatus"
              id="name-phone-validateStatus"
              data-cy="validateStatus"
              :class="{ valid: !v$.validateStatus.$invalid, invalid: v$.validateStatus.$invalid }"
              v-model="v$.validateStatus.$model"
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
<script lang="ts" src="./name-phone-update.component.ts"></script>
