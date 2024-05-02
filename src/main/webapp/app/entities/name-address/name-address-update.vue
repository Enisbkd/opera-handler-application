<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.nameAddress.home.createOrEditLabel"
          data-cy="NameAddressCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.nameAddress.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="nameAddress.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="nameAddress.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.addressId')"
              for="name-address-addressId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="addressId"
              id="name-address-addressId"
              data-cy="addressId"
              :class="{ valid: !v$.addressId.$invalid, invalid: v$.addressId.$invalid }"
              v-model.number="v$.addressId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.addressType')"
              for="name-address-addressType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="addressType"
              id="name-address-addressType"
              data-cy="addressType"
              :class="{ valid: !v$.addressType.$invalid, invalid: v$.addressType.$invalid }"
              v-model="v$.addressType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.address1')"
              for="name-address-address1"
            ></label>
            <input
              type="text"
              class="form-control"
              name="address1"
              id="name-address-address1"
              data-cy="address1"
              :class="{ valid: !v$.address1.$invalid, invalid: v$.address1.$invalid }"
              v-model="v$.address1.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.address2')"
              for="name-address-address2"
            ></label>
            <input
              type="text"
              class="form-control"
              name="address2"
              id="name-address-address2"
              data-cy="address2"
              :class="{ valid: !v$.address2.$invalid, invalid: v$.address2.$invalid }"
              v-model="v$.address2.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.address3')"
              for="name-address-address3"
            ></label>
            <input
              type="text"
              class="form-control"
              name="address3"
              id="name-address-address3"
              data-cy="address3"
              :class="{ valid: !v$.address3.$invalid, invalid: v$.address3.$invalid }"
              v-model="v$.address3.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.address4')"
              for="name-address-address4"
            ></label>
            <input
              type="text"
              class="form-control"
              name="address4"
              id="name-address-address4"
              data-cy="address4"
              :class="{ valid: !v$.address4.$invalid, invalid: v$.address4.$invalid }"
              v-model="v$.address4.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.barcode')"
              for="name-address-barcode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="barcode"
              id="name-address-barcode"
              data-cy="barcode"
              :class="{ valid: !v$.barcode.$invalid, invalid: v$.barcode.$invalid }"
              v-model="v$.barcode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.beginDate')"
              for="name-address-beginDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-address-beginDate"
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
                id="name-address-beginDate"
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
              v-text="t$('operaHandlerApplicationApp.nameAddress.chainCode')"
              for="name-address-chainCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="chainCode"
              id="name-address-chainCode"
              data-cy="chainCode"
              :class="{ valid: !v$.chainCode.$invalid, invalid: v$.chainCode.$invalid }"
              v-model="v$.chainCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.nameAddress.city')" for="name-address-city"></label>
            <input
              type="text"
              class="form-control"
              name="city"
              id="name-address-city"
              data-cy="city"
              :class="{ valid: !v$.city.$invalid, invalid: v$.city.$invalid }"
              v-model="v$.city.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.cityExt')"
              for="name-address-cityExt"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cityExt"
              id="name-address-cityExt"
              data-cy="cityExt"
              :class="{ valid: !v$.cityExt.$invalid, invalid: v$.cityExt.$invalid }"
              v-model="v$.cityExt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedDatetime')"
              for="name-address-cleansedDatetime"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-address-cleansedDatetime"
                  v-model="v$.cleansedDatetime.$model"
                  name="cleansedDatetime"
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
                id="name-address-cleansedDatetime"
                data-cy="cleansedDatetime"
                type="text"
                class="form-control"
                name="cleansedDatetime"
                :class="{ valid: !v$.cleansedDatetime.$invalid, invalid: v$.cleansedDatetime.$invalid }"
                v-model="v$.cleansedDatetime.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedErrormsg')"
              for="name-address-cleansedErrormsg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cleansedErrormsg"
              id="name-address-cleansedErrormsg"
              data-cy="cleansedErrormsg"
              :class="{ valid: !v$.cleansedErrormsg.$invalid, invalid: v$.cleansedErrormsg.$invalid }"
              v-model="v$.cleansedErrormsg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedMatchstatus')"
              for="name-address-cleansedMatchstatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cleansedMatchstatus"
              id="name-address-cleansedMatchstatus"
              data-cy="cleansedMatchstatus"
              :class="{ valid: !v$.cleansedMatchstatus.$invalid, invalid: v$.cleansedMatchstatus.$invalid }"
              v-model="v$.cleansedMatchstatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedStatus')"
              for="name-address-cleansedStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cleansedStatus"
              id="name-address-cleansedStatus"
              data-cy="cleansedStatus"
              :class="{ valid: !v$.cleansedStatus.$invalid, invalid: v$.cleansedStatus.$invalid }"
              v-model="v$.cleansedStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedValidationstatus')"
              for="name-address-cleansedValidationstatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cleansedValidationstatus"
              id="name-address-cleansedValidationstatus"
              data-cy="cleansedValidationstatus"
              :class="{ valid: !v$.cleansedValidationstatus.$invalid, invalid: v$.cleansedValidationstatus.$invalid }"
              v-model="v$.cleansedValidationstatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.country')"
              for="name-address-country"
            ></label>
            <input
              type="text"
              class="form-control"
              name="country"
              id="name-address-country"
              data-cy="country"
              :class="{ valid: !v$.country.$invalid, invalid: v$.country.$invalid }"
              v-model="v$.country.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.endDate')"
              for="name-address-endDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-address-endDate"
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
                id="name-address-endDate"
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
              v-text="t$('operaHandlerApplicationApp.nameAddress.foreignCountry')"
              for="name-address-foreignCountry"
            ></label>
            <input
              type="text"
              class="form-control"
              name="foreignCountry"
              id="name-address-foreignCountry"
              data-cy="foreignCountry"
              :class="{ valid: !v$.foreignCountry.$invalid, invalid: v$.foreignCountry.$invalid }"
              v-model="v$.foreignCountry.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.inCareOf')"
              for="name-address-inCareOf"
            ></label>
            <input
              type="text"
              class="form-control"
              name="inCareOf"
              id="name-address-inCareOf"
              data-cy="inCareOf"
              :class="{ valid: !v$.inCareOf.$invalid, invalid: v$.inCareOf.$invalid }"
              v-model="v$.inCareOf.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.inactiveDate')"
              for="name-address-inactiveDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-address-inactiveDate"
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
                id="name-address-inactiveDate"
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
              v-text="t$('operaHandlerApplicationApp.nameAddress.insertDate')"
              for="name-address-insertDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-address-insertDate"
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
                id="name-address-insertDate"
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
              v-text="t$('operaHandlerApplicationApp.nameAddress.insertUser')"
              for="name-address-insertUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="name-address-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.languageCode')"
              for="name-address-languageCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="languageCode"
              id="name-address-languageCode"
              data-cy="languageCode"
              :class="{ valid: !v$.languageCode.$invalid, invalid: v$.languageCode.$invalid }"
              v-model="v$.languageCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.laptopChange')"
              for="name-address-laptopChange"
            ></label>
            <input
              type="number"
              class="form-control"
              name="laptopChange"
              id="name-address-laptopChange"
              data-cy="laptopChange"
              :class="{ valid: !v$.laptopChange.$invalid, invalid: v$.laptopChange.$invalid }"
              v-model.number="v$.laptopChange.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.lastUpdatedResort')"
              for="name-address-lastUpdatedResort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="lastUpdatedResort"
              id="name-address-lastUpdatedResort"
              data-cy="lastUpdatedResort"
              :class="{ valid: !v$.lastUpdatedResort.$invalid, invalid: v$.lastUpdatedResort.$invalid }"
              v-model="v$.lastUpdatedResort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.nameId')"
              for="name-address-nameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="nameId"
              id="name-address-nameId"
              data-cy="nameId"
              :class="{ valid: !v$.nameId.$invalid, invalid: v$.nameId.$invalid }"
              v-model.number="v$.nameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.primaryYn')"
              for="name-address-primaryYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="primaryYn"
              id="name-address-primaryYn"
              data-cy="primaryYn"
              :class="{ valid: !v$.primaryYn.$invalid, invalid: v$.primaryYn.$invalid }"
              v-model="v$.primaryYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.province')"
              for="name-address-province"
            ></label>
            <input
              type="text"
              class="form-control"
              name="province"
              id="name-address-province"
              data-cy="province"
              :class="{ valid: !v$.province.$invalid, invalid: v$.province.$invalid }"
              v-model="v$.province.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.nameAddress.state')" for="name-address-state"></label>
            <input
              type="text"
              class="form-control"
              name="state"
              id="name-address-state"
              data-cy="state"
              :class="{ valid: !v$.state.$invalid, invalid: v$.state.$invalid }"
              v-model="v$.state.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.updateDate')"
              for="name-address-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-address-updateDate"
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
                id="name-address-updateDate"
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
              v-text="t$('operaHandlerApplicationApp.nameAddress.updateUser')"
              for="name-address-updateUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="name-address-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.nameAddress.zipCode')"
              for="name-address-zipCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="zipCode"
              id="name-address-zipCode"
              data-cy="zipCode"
              :class="{ valid: !v$.zipCode.$invalid, invalid: v$.zipCode.$invalid }"
              v-model="v$.zipCode.$model"
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
<script lang="ts" src="./name-address-update.component.ts"></script>
