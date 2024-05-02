<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.reservationName.home.createOrEditLabel"
          data-cy="ReservationNameCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.reservationName.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="reservationName.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="reservationName.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.resort')"
              for="reservation-name-resort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resort"
              id="reservation-name-resort"
              data-cy="resort"
              :class="{ valid: !v$.resort.$invalid, invalid: v$.resort.$invalid }"
              v-model="v$.resort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.resvNameId')"
              for="reservation-name-resvNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="resvNameId"
              id="reservation-name-resvNameId"
              data-cy="resvNameId"
              :class="{ valid: !v$.resvNameId.$invalid, invalid: v$.resvNameId.$invalid }"
              v-model.number="v$.resvNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.nameId')"
              for="reservation-name-nameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="nameId"
              id="reservation-name-nameId"
              data-cy="nameId"
              :class="{ valid: !v$.nameId.$invalid, invalid: v$.nameId.$invalid }"
              v-model.number="v$.nameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.nameUsageType')"
              for="reservation-name-nameUsageType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="nameUsageType"
              id="reservation-name-nameUsageType"
              data-cy="nameUsageType"
              :class="{ valid: !v$.nameUsageType.$invalid, invalid: v$.nameUsageType.$invalid }"
              v-model="v$.nameUsageType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.contactNameId')"
              for="reservation-name-contactNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="contactNameId"
              id="reservation-name-contactNameId"
              data-cy="contactNameId"
              :class="{ valid: !v$.contactNameId.$invalid, invalid: v$.contactNameId.$invalid }"
              v-model.number="v$.contactNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.insertDate')"
              for="reservation-name-insertDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-insertDate"
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
                id="reservation-name-insertDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationName.insertUser')"
              for="reservation-name-insertUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="reservation-name-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.updateUser')"
              for="reservation-name-updateUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="reservation-name-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.updateDate')"
              for="reservation-name-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-updateDate"
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
                id="reservation-name-updateDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationName.resvStatus')"
              for="reservation-name-resvStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resvStatus"
              id="reservation-name-resvStatus"
              data-cy="resvStatus"
              :class="{ valid: !v$.resvStatus.$invalid, invalid: v$.resvStatus.$invalid }"
              v-model="v$.resvStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.commissionCode')"
              for="reservation-name-commissionCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="commissionCode"
              id="reservation-name-commissionCode"
              data-cy="commissionCode"
              :class="{ valid: !v$.commissionCode.$invalid, invalid: v$.commissionCode.$invalid }"
              v-model="v$.commissionCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.addressId')"
              for="reservation-name-addressId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="addressId"
              id="reservation-name-addressId"
              data-cy="addressId"
              :class="{ valid: !v$.addressId.$invalid, invalid: v$.addressId.$invalid }"
              v-model.number="v$.addressId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.phoneId')"
              for="reservation-name-phoneId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="phoneId"
              id="reservation-name-phoneId"
              data-cy="phoneId"
              :class="{ valid: !v$.phoneId.$invalid, invalid: v$.phoneId.$invalid }"
              v-model.number="v$.phoneId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.faxYn')"
              for="reservation-name-faxYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="faxYn"
              id="reservation-name-faxYn"
              data-cy="faxYn"
              :class="{ valid: !v$.faxYn.$invalid, invalid: v$.faxYn.$invalid }"
              v-model="v$.faxYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.mailYn')"
              for="reservation-name-mailYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="mailYn"
              id="reservation-name-mailYn"
              data-cy="mailYn"
              :class="{ valid: !v$.mailYn.$invalid, invalid: v$.mailYn.$invalid }"
              v-model="v$.mailYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.printRateYn')"
              for="reservation-name-printRateYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="printRateYn"
              id="reservation-name-printRateYn"
              data-cy="printRateYn"
              :class="{ valid: !v$.printRateYn.$invalid, invalid: v$.printRateYn.$invalid }"
              v-model="v$.printRateYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.reportId')"
              for="reservation-name-reportId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="reportId"
              id="reservation-name-reportId"
              data-cy="reportId"
              :class="{ valid: !v$.reportId.$invalid, invalid: v$.reportId.$invalid }"
              v-model="v$.reportId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.resvNo')"
              for="reservation-name-resvNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="resvNo"
              id="reservation-name-resvNo"
              data-cy="resvNo"
              :class="{ valid: !v$.resvNo.$invalid, invalid: v$.resvNo.$invalid }"
              v-model.number="v$.resvNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.confirmationNo')"
              for="reservation-name-confirmationNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="confirmationNo"
              id="reservation-name-confirmationNo"
              data-cy="confirmationNo"
              :class="{ valid: !v$.confirmationNo.$invalid, invalid: v$.confirmationNo.$invalid }"
              v-model="v$.confirmationNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.beginDate')"
              for="reservation-name-beginDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-beginDate"
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
                id="reservation-name-beginDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationName.endDate')"
              for="reservation-name-endDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-endDate"
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
                id="reservation-name-endDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationName.faxId')"
              for="reservation-name-faxId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="faxId"
              id="reservation-name-faxId"
              data-cy="faxId"
              :class="{ valid: !v$.faxId.$invalid, invalid: v$.faxId.$invalid }"
              v-model.number="v$.faxId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.emailId')"
              for="reservation-name-emailId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="emailId"
              id="reservation-name-emailId"
              data-cy="emailId"
              :class="{ valid: !v$.emailId.$invalid, invalid: v$.emailId.$invalid }"
              v-model.number="v$.emailId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.emailYn')"
              for="reservation-name-emailYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="emailYn"
              id="reservation-name-emailYn"
              data-cy="emailYn"
              :class="{ valid: !v$.emailYn.$invalid, invalid: v$.emailYn.$invalid }"
              v-model="v$.emailYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.consumerYn')"
              for="reservation-name-consumerYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="consumerYn"
              id="reservation-name-consumerYn"
              data-cy="consumerYn"
              :class="{ valid: !v$.consumerYn.$invalid, invalid: v$.consumerYn.$invalid }"
              v-model="v$.consumerYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.creditCardId')"
              for="reservation-name-creditCardId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="creditCardId"
              id="reservation-name-creditCardId"
              data-cy="creditCardId"
              :class="{ valid: !v$.creditCardId.$invalid, invalid: v$.creditCardId.$invalid }"
              v-model.number="v$.creditCardId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.financiallyResponsibleYn')"
              for="reservation-name-financiallyResponsibleYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="financiallyResponsibleYn"
              id="reservation-name-financiallyResponsibleYn"
              data-cy="financiallyResponsibleYn"
              :class="{ valid: !v$.financiallyResponsibleYn.$invalid, invalid: v$.financiallyResponsibleYn.$invalid }"
              v-model="v$.financiallyResponsibleYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.paymentMethod')"
              for="reservation-name-paymentMethod"
            ></label>
            <input
              type="text"
              class="form-control"
              name="paymentMethod"
              id="reservation-name-paymentMethod"
              data-cy="paymentMethod"
              :class="{ valid: !v$.paymentMethod.$invalid, invalid: v$.paymentMethod.$invalid }"
              v-model="v$.paymentMethod.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.intermediaryYn')"
              for="reservation-name-intermediaryYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="intermediaryYn"
              id="reservation-name-intermediaryYn"
              data-cy="intermediaryYn"
              :class="{ valid: !v$.intermediaryYn.$invalid, invalid: v$.intermediaryYn.$invalid }"
              v-model="v$.intermediaryYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.postingAllowedYn')"
              for="reservation-name-postingAllowedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="postingAllowedYn"
              id="reservation-name-postingAllowedYn"
              data-cy="postingAllowedYn"
              :class="{ valid: !v$.postingAllowedYn.$invalid, invalid: v$.postingAllowedYn.$invalid }"
              v-model="v$.postingAllowedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.displayColor')"
              for="reservation-name-displayColor"
            ></label>
            <input
              type="text"
              class="form-control"
              name="displayColor"
              id="reservation-name-displayColor"
              data-cy="displayColor"
              :class="{ valid: !v$.displayColor.$invalid, invalid: v$.displayColor.$invalid }"
              v-model="v$.displayColor.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.actualCheckInDate')"
              for="reservation-name-actualCheckInDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-actualCheckInDate"
                  v-model="v$.actualCheckInDate.$model"
                  name="actualCheckInDate"
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
                id="reservation-name-actualCheckInDate"
                data-cy="actualCheckInDate"
                type="text"
                class="form-control"
                name="actualCheckInDate"
                :class="{ valid: !v$.actualCheckInDate.$invalid, invalid: v$.actualCheckInDate.$invalid }"
                v-model="v$.actualCheckInDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.truncActualCheckInDate')"
              for="reservation-name-truncActualCheckInDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-truncActualCheckInDate"
                  v-model="v$.truncActualCheckInDate.$model"
                  name="truncActualCheckInDate"
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
                id="reservation-name-truncActualCheckInDate"
                data-cy="truncActualCheckInDate"
                type="text"
                class="form-control"
                name="truncActualCheckInDate"
                :class="{ valid: !v$.truncActualCheckInDate.$invalid, invalid: v$.truncActualCheckInDate.$invalid }"
                v-model="v$.truncActualCheckInDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.actualCheckOutDate')"
              for="reservation-name-actualCheckOutDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-actualCheckOutDate"
                  v-model="v$.actualCheckOutDate.$model"
                  name="actualCheckOutDate"
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
                id="reservation-name-actualCheckOutDate"
                data-cy="actualCheckOutDate"
                type="text"
                class="form-control"
                name="actualCheckOutDate"
                :class="{ valid: !v$.actualCheckOutDate.$invalid, invalid: v$.actualCheckOutDate.$invalid }"
                v-model="v$.actualCheckOutDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.truncActualCheckOutDate')"
              for="reservation-name-truncActualCheckOutDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-truncActualCheckOutDate"
                  v-model="v$.truncActualCheckOutDate.$model"
                  name="truncActualCheckOutDate"
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
                id="reservation-name-truncActualCheckOutDate"
                data-cy="truncActualCheckOutDate"
                type="text"
                class="form-control"
                name="truncActualCheckOutDate"
                :class="{ valid: !v$.truncActualCheckOutDate.$invalid, invalid: v$.truncActualCheckOutDate.$invalid }"
                v-model="v$.truncActualCheckOutDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.creditLimit')"
              for="reservation-name-creditLimit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="creditLimit"
              id="reservation-name-creditLimit"
              data-cy="creditLimit"
              :class="{ valid: !v$.creditLimit.$invalid, invalid: v$.creditLimit.$invalid }"
              v-model.number="v$.creditLimit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.authorizedBy')"
              for="reservation-name-authorizedBy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="authorizedBy"
              id="reservation-name-authorizedBy"
              data-cy="authorizedBy"
              :class="{ valid: !v$.authorizedBy.$invalid, invalid: v$.authorizedBy.$invalid }"
              v-model.number="v$.authorizedBy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.parentResvNameId')"
              for="reservation-name-parentResvNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="parentResvNameId"
              id="reservation-name-parentResvNameId"
              data-cy="parentResvNameId"
              :class="{ valid: !v$.parentResvNameId.$invalid, invalid: v$.parentResvNameId.$invalid }"
              v-model.number="v$.parentResvNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.cancellationNo')"
              for="reservation-name-cancellationNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cancellationNo"
              id="reservation-name-cancellationNo"
              data-cy="cancellationNo"
              :class="{ valid: !v$.cancellationNo.$invalid, invalid: v$.cancellationNo.$invalid }"
              v-model="v$.cancellationNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.cancellationReasonCode')"
              for="reservation-name-cancellationReasonCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cancellationReasonCode"
              id="reservation-name-cancellationReasonCode"
              data-cy="cancellationReasonCode"
              :class="{ valid: !v$.cancellationReasonCode.$invalid, invalid: v$.cancellationReasonCode.$invalid }"
              v-model="v$.cancellationReasonCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.cancellationReasonDesc')"
              for="reservation-name-cancellationReasonDesc"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cancellationReasonDesc"
              id="reservation-name-cancellationReasonDesc"
              data-cy="cancellationReasonDesc"
              :class="{ valid: !v$.cancellationReasonDesc.$invalid, invalid: v$.cancellationReasonDesc.$invalid }"
              v-model="v$.cancellationReasonDesc.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.arrivalTransportType')"
              for="reservation-name-arrivalTransportType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arrivalTransportType"
              id="reservation-name-arrivalTransportType"
              data-cy="arrivalTransportType"
              :class="{ valid: !v$.arrivalTransportType.$invalid, invalid: v$.arrivalTransportType.$invalid }"
              v-model="v$.arrivalTransportType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.arrivalStationCode')"
              for="reservation-name-arrivalStationCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arrivalStationCode"
              id="reservation-name-arrivalStationCode"
              data-cy="arrivalStationCode"
              :class="{ valid: !v$.arrivalStationCode.$invalid, invalid: v$.arrivalStationCode.$invalid }"
              v-model="v$.arrivalStationCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.arrivalCarrierCode')"
              for="reservation-name-arrivalCarrierCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arrivalCarrierCode"
              id="reservation-name-arrivalCarrierCode"
              data-cy="arrivalCarrierCode"
              :class="{ valid: !v$.arrivalCarrierCode.$invalid, invalid: v$.arrivalCarrierCode.$invalid }"
              v-model="v$.arrivalCarrierCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.arrivalTransportCode')"
              for="reservation-name-arrivalTransportCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arrivalTransportCode"
              id="reservation-name-arrivalTransportCode"
              data-cy="arrivalTransportCode"
              :class="{ valid: !v$.arrivalTransportCode.$invalid, invalid: v$.arrivalTransportCode.$invalid }"
              v-model="v$.arrivalTransportCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.arrivalDateTime')"
              for="reservation-name-arrivalDateTime"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-arrivalDateTime"
                  v-model="v$.arrivalDateTime.$model"
                  name="arrivalDateTime"
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
                id="reservation-name-arrivalDateTime"
                data-cy="arrivalDateTime"
                type="text"
                class="form-control"
                name="arrivalDateTime"
                :class="{ valid: !v$.arrivalDateTime.$invalid, invalid: v$.arrivalDateTime.$invalid }"
                v-model="v$.arrivalDateTime.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.arrivalEstimateTime')"
              for="reservation-name-arrivalEstimateTime"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-arrivalEstimateTime"
                  v-model="v$.arrivalEstimateTime.$model"
                  name="arrivalEstimateTime"
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
                id="reservation-name-arrivalEstimateTime"
                data-cy="arrivalEstimateTime"
                type="text"
                class="form-control"
                name="arrivalEstimateTime"
                :class="{ valid: !v$.arrivalEstimateTime.$invalid, invalid: v$.arrivalEstimateTime.$invalid }"
                v-model="v$.arrivalEstimateTime.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.arrivalTranportationYn')"
              for="reservation-name-arrivalTranportationYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arrivalTranportationYn"
              id="reservation-name-arrivalTranportationYn"
              data-cy="arrivalTranportationYn"
              :class="{ valid: !v$.arrivalTranportationYn.$invalid, invalid: v$.arrivalTranportationYn.$invalid }"
              v-model="v$.arrivalTranportationYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.arrivalComments')"
              for="reservation-name-arrivalComments"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arrivalComments"
              id="reservation-name-arrivalComments"
              data-cy="arrivalComments"
              :class="{ valid: !v$.arrivalComments.$invalid, invalid: v$.arrivalComments.$invalid }"
              v-model="v$.arrivalComments.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.departureTransportType')"
              for="reservation-name-departureTransportType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="departureTransportType"
              id="reservation-name-departureTransportType"
              data-cy="departureTransportType"
              :class="{ valid: !v$.departureTransportType.$invalid, invalid: v$.departureTransportType.$invalid }"
              v-model="v$.departureTransportType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.departureStationCode')"
              for="reservation-name-departureStationCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="departureStationCode"
              id="reservation-name-departureStationCode"
              data-cy="departureStationCode"
              :class="{ valid: !v$.departureStationCode.$invalid, invalid: v$.departureStationCode.$invalid }"
              v-model="v$.departureStationCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.departureCarrierCode')"
              for="reservation-name-departureCarrierCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="departureCarrierCode"
              id="reservation-name-departureCarrierCode"
              data-cy="departureCarrierCode"
              :class="{ valid: !v$.departureCarrierCode.$invalid, invalid: v$.departureCarrierCode.$invalid }"
              v-model="v$.departureCarrierCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.departureTransportCode')"
              for="reservation-name-departureTransportCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="departureTransportCode"
              id="reservation-name-departureTransportCode"
              data-cy="departureTransportCode"
              :class="{ valid: !v$.departureTransportCode.$invalid, invalid: v$.departureTransportCode.$invalid }"
              v-model="v$.departureTransportCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.departureDateTime')"
              for="reservation-name-departureDateTime"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-departureDateTime"
                  v-model="v$.departureDateTime.$model"
                  name="departureDateTime"
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
                id="reservation-name-departureDateTime"
                data-cy="departureDateTime"
                type="text"
                class="form-control"
                name="departureDateTime"
                :class="{ valid: !v$.departureDateTime.$invalid, invalid: v$.departureDateTime.$invalid }"
                v-model="v$.departureDateTime.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.departureEstimateTime')"
              for="reservation-name-departureEstimateTime"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-departureEstimateTime"
                  v-model="v$.departureEstimateTime.$model"
                  name="departureEstimateTime"
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
                id="reservation-name-departureEstimateTime"
                data-cy="departureEstimateTime"
                type="text"
                class="form-control"
                name="departureEstimateTime"
                :class="{ valid: !v$.departureEstimateTime.$invalid, invalid: v$.departureEstimateTime.$invalid }"
                v-model="v$.departureEstimateTime.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.departureTransportationYn')"
              for="reservation-name-departureTransportationYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="departureTransportationYn"
              id="reservation-name-departureTransportationYn"
              data-cy="departureTransportationYn"
              :class="{ valid: !v$.departureTransportationYn.$invalid, invalid: v$.departureTransportationYn.$invalid }"
              v-model="v$.departureTransportationYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.departureComments')"
              for="reservation-name-departureComments"
            ></label>
            <input
              type="text"
              class="form-control"
              name="departureComments"
              id="reservation-name-departureComments"
              data-cy="departureComments"
              :class="{ valid: !v$.departureComments.$invalid, invalid: v$.departureComments.$invalid }"
              v-model="v$.departureComments.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.cancellationDate')"
              for="reservation-name-cancellationDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-cancellationDate"
                  v-model="v$.cancellationDate.$model"
                  name="cancellationDate"
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
                id="reservation-name-cancellationDate"
                data-cy="cancellationDate"
                type="text"
                class="form-control"
                name="cancellationDate"
                :class="{ valid: !v$.cancellationDate.$invalid, invalid: v$.cancellationDate.$invalid }"
                v-model="v$.cancellationDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.guaranteeCode')"
              for="reservation-name-guaranteeCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guaranteeCode"
              id="reservation-name-guaranteeCode"
              data-cy="guaranteeCode"
              :class="{ valid: !v$.guaranteeCode.$invalid, invalid: v$.guaranteeCode.$invalid }"
              v-model="v$.guaranteeCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.wlReasonDescription')"
              for="reservation-name-wlReasonDescription"
            ></label>
            <input
              type="text"
              class="form-control"
              name="wlReasonDescription"
              id="reservation-name-wlReasonDescription"
              data-cy="wlReasonDescription"
              :class="{ valid: !v$.wlReasonDescription.$invalid, invalid: v$.wlReasonDescription.$invalid }"
              v-model="v$.wlReasonDescription.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.wlReasonCode')"
              for="reservation-name-wlReasonCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="wlReasonCode"
              id="reservation-name-wlReasonCode"
              data-cy="wlReasonCode"
              :class="{ valid: !v$.wlReasonCode.$invalid, invalid: v$.wlReasonCode.$invalid }"
              v-model="v$.wlReasonCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.wlPriority')"
              for="reservation-name-wlPriority"
            ></label>
            <input
              type="text"
              class="form-control"
              name="wlPriority"
              id="reservation-name-wlPriority"
              data-cy="wlPriority"
              :class="{ valid: !v$.wlPriority.$invalid, invalid: v$.wlPriority.$invalid }"
              v-model="v$.wlPriority.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.doNotMoveRoom')"
              for="reservation-name-doNotMoveRoom"
            ></label>
            <input
              type="text"
              class="form-control"
              name="doNotMoveRoom"
              id="reservation-name-doNotMoveRoom"
              data-cy="doNotMoveRoom"
              :class="{ valid: !v$.doNotMoveRoom.$invalid, invalid: v$.doNotMoveRoom.$invalid }"
              v-model="v$.doNotMoveRoom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.externalReference')"
              for="reservation-name-externalReference"
            ></label>
            <input
              type="text"
              class="form-control"
              name="externalReference"
              id="reservation-name-externalReference"
              data-cy="externalReference"
              :class="{ valid: !v$.externalReference.$invalid, invalid: v$.externalReference.$invalid }"
              v-model="v$.externalReference.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.partyCode')"
              for="reservation-name-partyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="partyCode"
              id="reservation-name-partyCode"
              data-cy="partyCode"
              :class="{ valid: !v$.partyCode.$invalid, invalid: v$.partyCode.$invalid }"
              v-model="v$.partyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.walkinYn')"
              for="reservation-name-walkinYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="walkinYn"
              id="reservation-name-walkinYn"
              data-cy="walkinYn"
              :class="{ valid: !v$.walkinYn.$invalid, invalid: v$.walkinYn.$invalid }"
              v-model="v$.walkinYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.originalEndDate')"
              for="reservation-name-originalEndDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-originalEndDate"
                  v-model="v$.originalEndDate.$model"
                  name="originalEndDate"
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
                id="reservation-name-originalEndDate"
                data-cy="originalEndDate"
                type="text"
                class="form-control"
                name="originalEndDate"
                :class="{ valid: !v$.originalEndDate.$invalid, invalid: v$.originalEndDate.$invalid }"
                v-model="v$.originalEndDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.approvalAmountCalcMethod')"
              for="reservation-name-approvalAmountCalcMethod"
            ></label>
            <input
              type="number"
              class="form-control"
              name="approvalAmountCalcMethod"
              id="reservation-name-approvalAmountCalcMethod"
              data-cy="approvalAmountCalcMethod"
              :class="{ valid: !v$.approvalAmountCalcMethod.$invalid, invalid: v$.approvalAmountCalcMethod.$invalid }"
              v-model.number="v$.approvalAmountCalcMethod.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.amountPercent')"
              for="reservation-name-amountPercent"
            ></label>
            <input
              type="number"
              class="form-control"
              name="amountPercent"
              id="reservation-name-amountPercent"
              data-cy="amountPercent"
              :class="{ valid: !v$.amountPercent.$invalid, invalid: v$.amountPercent.$invalid }"
              v-model.number="v$.amountPercent.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.nameTaxType')"
              for="reservation-name-nameTaxType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="nameTaxType"
              id="reservation-name-nameTaxType"
              data-cy="nameTaxType"
              :class="{ valid: !v$.nameTaxType.$invalid, invalid: v$.nameTaxType.$invalid }"
              v-model="v$.nameTaxType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.taxExemptNo')"
              for="reservation-name-taxExemptNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="taxExemptNo"
              id="reservation-name-taxExemptNo"
              data-cy="taxExemptNo"
              :class="{ valid: !v$.taxExemptNo.$invalid, invalid: v$.taxExemptNo.$invalid }"
              v-model="v$.taxExemptNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.roomFeatures')"
              for="reservation-name-roomFeatures"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomFeatures"
              id="reservation-name-roomFeatures"
              data-cy="roomFeatures"
              :class="{ valid: !v$.roomFeatures.$invalid, invalid: v$.roomFeatures.$invalid }"
              v-model="v$.roomFeatures.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.wlTelephoneNo')"
              for="reservation-name-wlTelephoneNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="wlTelephoneNo"
              id="reservation-name-wlTelephoneNo"
              data-cy="wlTelephoneNo"
              :class="{ valid: !v$.wlTelephoneNo.$invalid, invalid: v$.wlTelephoneNo.$invalid }"
              v-model="v$.wlTelephoneNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.videoCheckoutYn')"
              for="reservation-name-videoCheckoutYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="videoCheckoutYn"
              id="reservation-name-videoCheckoutYn"
              data-cy="videoCheckoutYn"
              :class="{ valid: !v$.videoCheckoutYn.$invalid, invalid: v$.videoCheckoutYn.$invalid }"
              v-model="v$.videoCheckoutYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.discountAmt')"
              for="reservation-name-discountAmt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="discountAmt"
              id="reservation-name-discountAmt"
              data-cy="discountAmt"
              :class="{ valid: !v$.discountAmt.$invalid, invalid: v$.discountAmt.$invalid }"
              v-model.number="v$.discountAmt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.discountPrcnt')"
              for="reservation-name-discountPrcnt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="discountPrcnt"
              id="reservation-name-discountPrcnt"
              data-cy="discountPrcnt"
              :class="{ valid: !v$.discountPrcnt.$invalid, invalid: v$.discountPrcnt.$invalid }"
              v-model.number="v$.discountPrcnt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.discountReasonCode')"
              for="reservation-name-discountReasonCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="discountReasonCode"
              id="reservation-name-discountReasonCode"
              data-cy="discountReasonCode"
              :class="{ valid: !v$.discountReasonCode.$invalid, invalid: v$.discountReasonCode.$invalid }"
              v-model="v$.discountReasonCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.commissionPaid')"
              for="reservation-name-commissionPaid"
            ></label>
            <input
              type="number"
              class="form-control"
              name="commissionPaid"
              id="reservation-name-commissionPaid"
              data-cy="commissionPaid"
              :class="{ valid: !v$.commissionPaid.$invalid, invalid: v$.commissionPaid.$invalid }"
              v-model.number="v$.commissionPaid.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.commissionHoldCode')"
              for="reservation-name-commissionHoldCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="commissionHoldCode"
              id="reservation-name-commissionHoldCode"
              data-cy="commissionHoldCode"
              :class="{ valid: !v$.commissionHoldCode.$invalid, invalid: v$.commissionHoldCode.$invalid }"
              v-model="v$.commissionHoldCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.truncBeginDate')"
              for="reservation-name-truncBeginDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-truncBeginDate"
                  v-model="v$.truncBeginDate.$model"
                  name="truncBeginDate"
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
                id="reservation-name-truncBeginDate"
                data-cy="truncBeginDate"
                type="text"
                class="form-control"
                name="truncBeginDate"
                :class="{ valid: !v$.truncBeginDate.$invalid, invalid: v$.truncBeginDate.$invalid }"
                v-model="v$.truncBeginDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.truncEndDate')"
              for="reservation-name-truncEndDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-truncEndDate"
                  v-model="v$.truncEndDate.$model"
                  name="truncEndDate"
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
                id="reservation-name-truncEndDate"
                data-cy="truncEndDate"
                type="text"
                class="form-control"
                name="truncEndDate"
                :class="{ valid: !v$.truncEndDate.$invalid, invalid: v$.truncEndDate.$invalid }"
                v-model="v$.truncEndDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.sguestName')"
              for="reservation-name-sguestName"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sguestName"
              id="reservation-name-sguestName"
              data-cy="sguestName"
              :class="{ valid: !v$.sguestName.$invalid, invalid: v$.sguestName.$invalid }"
              v-model="v$.sguestName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.membershipId')"
              for="reservation-name-membershipId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="membershipId"
              id="reservation-name-membershipId"
              data-cy="membershipId"
              :class="{ valid: !v$.membershipId.$invalid, invalid: v$.membershipId.$invalid }"
              v-model.number="v$.membershipId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc01')"
              for="reservation-name-udfc01"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc01"
              id="reservation-name-udfc01"
              data-cy="udfc01"
              :class="{ valid: !v$.udfc01.$invalid, invalid: v$.udfc01.$invalid }"
              v-model="v$.udfc01.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc02')"
              for="reservation-name-udfc02"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc02"
              id="reservation-name-udfc02"
              data-cy="udfc02"
              :class="{ valid: !v$.udfc02.$invalid, invalid: v$.udfc02.$invalid }"
              v-model="v$.udfc02.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc03')"
              for="reservation-name-udfc03"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc03"
              id="reservation-name-udfc03"
              data-cy="udfc03"
              :class="{ valid: !v$.udfc03.$invalid, invalid: v$.udfc03.$invalid }"
              v-model="v$.udfc03.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc04')"
              for="reservation-name-udfc04"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc04"
              id="reservation-name-udfc04"
              data-cy="udfc04"
              :class="{ valid: !v$.udfc04.$invalid, invalid: v$.udfc04.$invalid }"
              v-model="v$.udfc04.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc05')"
              for="reservation-name-udfc05"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc05"
              id="reservation-name-udfc05"
              data-cy="udfc05"
              :class="{ valid: !v$.udfc05.$invalid, invalid: v$.udfc05.$invalid }"
              v-model="v$.udfc05.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc06')"
              for="reservation-name-udfc06"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc06"
              id="reservation-name-udfc06"
              data-cy="udfc06"
              :class="{ valid: !v$.udfc06.$invalid, invalid: v$.udfc06.$invalid }"
              v-model="v$.udfc06.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc07')"
              for="reservation-name-udfc07"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc07"
              id="reservation-name-udfc07"
              data-cy="udfc07"
              :class="{ valid: !v$.udfc07.$invalid, invalid: v$.udfc07.$invalid }"
              v-model="v$.udfc07.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc08')"
              for="reservation-name-udfc08"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc08"
              id="reservation-name-udfc08"
              data-cy="udfc08"
              :class="{ valid: !v$.udfc08.$invalid, invalid: v$.udfc08.$invalid }"
              v-model="v$.udfc08.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc09')"
              for="reservation-name-udfc09"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc09"
              id="reservation-name-udfc09"
              data-cy="udfc09"
              :class="{ valid: !v$.udfc09.$invalid, invalid: v$.udfc09.$invalid }"
              v-model="v$.udfc09.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc10')"
              for="reservation-name-udfc10"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc10"
              id="reservation-name-udfc10"
              data-cy="udfc10"
              :class="{ valid: !v$.udfc10.$invalid, invalid: v$.udfc10.$invalid }"
              v-model="v$.udfc10.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc11')"
              for="reservation-name-udfc11"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc11"
              id="reservation-name-udfc11"
              data-cy="udfc11"
              :class="{ valid: !v$.udfc11.$invalid, invalid: v$.udfc11.$invalid }"
              v-model="v$.udfc11.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc12')"
              for="reservation-name-udfc12"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc12"
              id="reservation-name-udfc12"
              data-cy="udfc12"
              :class="{ valid: !v$.udfc12.$invalid, invalid: v$.udfc12.$invalid }"
              v-model="v$.udfc12.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc13')"
              for="reservation-name-udfc13"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc13"
              id="reservation-name-udfc13"
              data-cy="udfc13"
              :class="{ valid: !v$.udfc13.$invalid, invalid: v$.udfc13.$invalid }"
              v-model="v$.udfc13.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc14')"
              for="reservation-name-udfc14"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc14"
              id="reservation-name-udfc14"
              data-cy="udfc14"
              :class="{ valid: !v$.udfc14.$invalid, invalid: v$.udfc14.$invalid }"
              v-model="v$.udfc14.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc15')"
              for="reservation-name-udfc15"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc15"
              id="reservation-name-udfc15"
              data-cy="udfc15"
              :class="{ valid: !v$.udfc15.$invalid, invalid: v$.udfc15.$invalid }"
              v-model="v$.udfc15.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc16')"
              for="reservation-name-udfc16"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc16"
              id="reservation-name-udfc16"
              data-cy="udfc16"
              :class="{ valid: !v$.udfc16.$invalid, invalid: v$.udfc16.$invalid }"
              v-model="v$.udfc16.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc17')"
              for="reservation-name-udfc17"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc17"
              id="reservation-name-udfc17"
              data-cy="udfc17"
              :class="{ valid: !v$.udfc17.$invalid, invalid: v$.udfc17.$invalid }"
              v-model="v$.udfc17.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc18')"
              for="reservation-name-udfc18"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc18"
              id="reservation-name-udfc18"
              data-cy="udfc18"
              :class="{ valid: !v$.udfc18.$invalid, invalid: v$.udfc18.$invalid }"
              v-model="v$.udfc18.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc19')"
              for="reservation-name-udfc19"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc19"
              id="reservation-name-udfc19"
              data-cy="udfc19"
              :class="{ valid: !v$.udfc19.$invalid, invalid: v$.udfc19.$invalid }"
              v-model="v$.udfc19.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc20')"
              for="reservation-name-udfc20"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc20"
              id="reservation-name-udfc20"
              data-cy="udfc20"
              :class="{ valid: !v$.udfc20.$invalid, invalid: v$.udfc20.$invalid }"
              v-model="v$.udfc20.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc21')"
              for="reservation-name-udfc21"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc21"
              id="reservation-name-udfc21"
              data-cy="udfc21"
              :class="{ valid: !v$.udfc21.$invalid, invalid: v$.udfc21.$invalid }"
              v-model="v$.udfc21.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc22')"
              for="reservation-name-udfc22"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc22"
              id="reservation-name-udfc22"
              data-cy="udfc22"
              :class="{ valid: !v$.udfc22.$invalid, invalid: v$.udfc22.$invalid }"
              v-model="v$.udfc22.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc23')"
              for="reservation-name-udfc23"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc23"
              id="reservation-name-udfc23"
              data-cy="udfc23"
              :class="{ valid: !v$.udfc23.$invalid, invalid: v$.udfc23.$invalid }"
              v-model="v$.udfc23.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc24')"
              for="reservation-name-udfc24"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc24"
              id="reservation-name-udfc24"
              data-cy="udfc24"
              :class="{ valid: !v$.udfc24.$invalid, invalid: v$.udfc24.$invalid }"
              v-model="v$.udfc24.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc25')"
              for="reservation-name-udfc25"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc25"
              id="reservation-name-udfc25"
              data-cy="udfc25"
              :class="{ valid: !v$.udfc25.$invalid, invalid: v$.udfc25.$invalid }"
              v-model="v$.udfc25.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc26')"
              for="reservation-name-udfc26"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc26"
              id="reservation-name-udfc26"
              data-cy="udfc26"
              :class="{ valid: !v$.udfc26.$invalid, invalid: v$.udfc26.$invalid }"
              v-model="v$.udfc26.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc27')"
              for="reservation-name-udfc27"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc27"
              id="reservation-name-udfc27"
              data-cy="udfc27"
              :class="{ valid: !v$.udfc27.$invalid, invalid: v$.udfc27.$invalid }"
              v-model="v$.udfc27.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc28')"
              for="reservation-name-udfc28"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc28"
              id="reservation-name-udfc28"
              data-cy="udfc28"
              :class="{ valid: !v$.udfc28.$invalid, invalid: v$.udfc28.$invalid }"
              v-model="v$.udfc28.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc29')"
              for="reservation-name-udfc29"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc29"
              id="reservation-name-udfc29"
              data-cy="udfc29"
              :class="{ valid: !v$.udfc29.$invalid, invalid: v$.udfc29.$invalid }"
              v-model="v$.udfc29.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc30')"
              for="reservation-name-udfc30"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc30"
              id="reservation-name-udfc30"
              data-cy="udfc30"
              :class="{ valid: !v$.udfc30.$invalid, invalid: v$.udfc30.$invalid }"
              v-model="v$.udfc30.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc31')"
              for="reservation-name-udfc31"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc31"
              id="reservation-name-udfc31"
              data-cy="udfc31"
              :class="{ valid: !v$.udfc31.$invalid, invalid: v$.udfc31.$invalid }"
              v-model="v$.udfc31.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc32')"
              for="reservation-name-udfc32"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc32"
              id="reservation-name-udfc32"
              data-cy="udfc32"
              :class="{ valid: !v$.udfc32.$invalid, invalid: v$.udfc32.$invalid }"
              v-model="v$.udfc32.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc33')"
              for="reservation-name-udfc33"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc33"
              id="reservation-name-udfc33"
              data-cy="udfc33"
              :class="{ valid: !v$.udfc33.$invalid, invalid: v$.udfc33.$invalid }"
              v-model="v$.udfc33.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc34')"
              for="reservation-name-udfc34"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc34"
              id="reservation-name-udfc34"
              data-cy="udfc34"
              :class="{ valid: !v$.udfc34.$invalid, invalid: v$.udfc34.$invalid }"
              v-model="v$.udfc34.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc35')"
              for="reservation-name-udfc35"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc35"
              id="reservation-name-udfc35"
              data-cy="udfc35"
              :class="{ valid: !v$.udfc35.$invalid, invalid: v$.udfc35.$invalid }"
              v-model="v$.udfc35.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc36')"
              for="reservation-name-udfc36"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc36"
              id="reservation-name-udfc36"
              data-cy="udfc36"
              :class="{ valid: !v$.udfc36.$invalid, invalid: v$.udfc36.$invalid }"
              v-model="v$.udfc36.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc37')"
              for="reservation-name-udfc37"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc37"
              id="reservation-name-udfc37"
              data-cy="udfc37"
              :class="{ valid: !v$.udfc37.$invalid, invalid: v$.udfc37.$invalid }"
              v-model="v$.udfc37.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc38')"
              for="reservation-name-udfc38"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc38"
              id="reservation-name-udfc38"
              data-cy="udfc38"
              :class="{ valid: !v$.udfc38.$invalid, invalid: v$.udfc38.$invalid }"
              v-model="v$.udfc38.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc39')"
              for="reservation-name-udfc39"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc39"
              id="reservation-name-udfc39"
              data-cy="udfc39"
              :class="{ valid: !v$.udfc39.$invalid, invalid: v$.udfc39.$invalid }"
              v-model="v$.udfc39.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfc40')"
              for="reservation-name-udfc40"
            ></label>
            <input
              type="text"
              class="form-control"
              name="udfc40"
              id="reservation-name-udfc40"
              data-cy="udfc40"
              :class="{ valid: !v$.udfc40.$invalid, invalid: v$.udfc40.$invalid }"
              v-model="v$.udfc40.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn01')"
              for="reservation-name-udfn01"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn01"
              id="reservation-name-udfn01"
              data-cy="udfn01"
              :class="{ valid: !v$.udfn01.$invalid, invalid: v$.udfn01.$invalid }"
              v-model.number="v$.udfn01.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn02')"
              for="reservation-name-udfn02"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn02"
              id="reservation-name-udfn02"
              data-cy="udfn02"
              :class="{ valid: !v$.udfn02.$invalid, invalid: v$.udfn02.$invalid }"
              v-model.number="v$.udfn02.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn03')"
              for="reservation-name-udfn03"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn03"
              id="reservation-name-udfn03"
              data-cy="udfn03"
              :class="{ valid: !v$.udfn03.$invalid, invalid: v$.udfn03.$invalid }"
              v-model.number="v$.udfn03.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn04')"
              for="reservation-name-udfn04"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn04"
              id="reservation-name-udfn04"
              data-cy="udfn04"
              :class="{ valid: !v$.udfn04.$invalid, invalid: v$.udfn04.$invalid }"
              v-model.number="v$.udfn04.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn05')"
              for="reservation-name-udfn05"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn05"
              id="reservation-name-udfn05"
              data-cy="udfn05"
              :class="{ valid: !v$.udfn05.$invalid, invalid: v$.udfn05.$invalid }"
              v-model.number="v$.udfn05.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn06')"
              for="reservation-name-udfn06"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn06"
              id="reservation-name-udfn06"
              data-cy="udfn06"
              :class="{ valid: !v$.udfn06.$invalid, invalid: v$.udfn06.$invalid }"
              v-model.number="v$.udfn06.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn07')"
              for="reservation-name-udfn07"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn07"
              id="reservation-name-udfn07"
              data-cy="udfn07"
              :class="{ valid: !v$.udfn07.$invalid, invalid: v$.udfn07.$invalid }"
              v-model.number="v$.udfn07.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn08')"
              for="reservation-name-udfn08"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn08"
              id="reservation-name-udfn08"
              data-cy="udfn08"
              :class="{ valid: !v$.udfn08.$invalid, invalid: v$.udfn08.$invalid }"
              v-model.number="v$.udfn08.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn09')"
              for="reservation-name-udfn09"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn09"
              id="reservation-name-udfn09"
              data-cy="udfn09"
              :class="{ valid: !v$.udfn09.$invalid, invalid: v$.udfn09.$invalid }"
              v-model.number="v$.udfn09.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn10')"
              for="reservation-name-udfn10"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn10"
              id="reservation-name-udfn10"
              data-cy="udfn10"
              :class="{ valid: !v$.udfn10.$invalid, invalid: v$.udfn10.$invalid }"
              v-model.number="v$.udfn10.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn11')"
              for="reservation-name-udfn11"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn11"
              id="reservation-name-udfn11"
              data-cy="udfn11"
              :class="{ valid: !v$.udfn11.$invalid, invalid: v$.udfn11.$invalid }"
              v-model.number="v$.udfn11.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn12')"
              for="reservation-name-udfn12"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn12"
              id="reservation-name-udfn12"
              data-cy="udfn12"
              :class="{ valid: !v$.udfn12.$invalid, invalid: v$.udfn12.$invalid }"
              v-model.number="v$.udfn12.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn13')"
              for="reservation-name-udfn13"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn13"
              id="reservation-name-udfn13"
              data-cy="udfn13"
              :class="{ valid: !v$.udfn13.$invalid, invalid: v$.udfn13.$invalid }"
              v-model.number="v$.udfn13.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn14')"
              for="reservation-name-udfn14"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn14"
              id="reservation-name-udfn14"
              data-cy="udfn14"
              :class="{ valid: !v$.udfn14.$invalid, invalid: v$.udfn14.$invalid }"
              v-model.number="v$.udfn14.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn15')"
              for="reservation-name-udfn15"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn15"
              id="reservation-name-udfn15"
              data-cy="udfn15"
              :class="{ valid: !v$.udfn15.$invalid, invalid: v$.udfn15.$invalid }"
              v-model.number="v$.udfn15.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn16')"
              for="reservation-name-udfn16"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn16"
              id="reservation-name-udfn16"
              data-cy="udfn16"
              :class="{ valid: !v$.udfn16.$invalid, invalid: v$.udfn16.$invalid }"
              v-model.number="v$.udfn16.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn17')"
              for="reservation-name-udfn17"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn17"
              id="reservation-name-udfn17"
              data-cy="udfn17"
              :class="{ valid: !v$.udfn17.$invalid, invalid: v$.udfn17.$invalid }"
              v-model.number="v$.udfn17.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn18')"
              for="reservation-name-udfn18"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn18"
              id="reservation-name-udfn18"
              data-cy="udfn18"
              :class="{ valid: !v$.udfn18.$invalid, invalid: v$.udfn18.$invalid }"
              v-model.number="v$.udfn18.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn19')"
              for="reservation-name-udfn19"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn19"
              id="reservation-name-udfn19"
              data-cy="udfn19"
              :class="{ valid: !v$.udfn19.$invalid, invalid: v$.udfn19.$invalid }"
              v-model.number="v$.udfn19.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn20')"
              for="reservation-name-udfn20"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn20"
              id="reservation-name-udfn20"
              data-cy="udfn20"
              :class="{ valid: !v$.udfn20.$invalid, invalid: v$.udfn20.$invalid }"
              v-model.number="v$.udfn20.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn21')"
              for="reservation-name-udfn21"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn21"
              id="reservation-name-udfn21"
              data-cy="udfn21"
              :class="{ valid: !v$.udfn21.$invalid, invalid: v$.udfn21.$invalid }"
              v-model.number="v$.udfn21.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn22')"
              for="reservation-name-udfn22"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn22"
              id="reservation-name-udfn22"
              data-cy="udfn22"
              :class="{ valid: !v$.udfn22.$invalid, invalid: v$.udfn22.$invalid }"
              v-model.number="v$.udfn22.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn23')"
              for="reservation-name-udfn23"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn23"
              id="reservation-name-udfn23"
              data-cy="udfn23"
              :class="{ valid: !v$.udfn23.$invalid, invalid: v$.udfn23.$invalid }"
              v-model.number="v$.udfn23.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn24')"
              for="reservation-name-udfn24"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn24"
              id="reservation-name-udfn24"
              data-cy="udfn24"
              :class="{ valid: !v$.udfn24.$invalid, invalid: v$.udfn24.$invalid }"
              v-model.number="v$.udfn24.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn25')"
              for="reservation-name-udfn25"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn25"
              id="reservation-name-udfn25"
              data-cy="udfn25"
              :class="{ valid: !v$.udfn25.$invalid, invalid: v$.udfn25.$invalid }"
              v-model.number="v$.udfn25.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn26')"
              for="reservation-name-udfn26"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn26"
              id="reservation-name-udfn26"
              data-cy="udfn26"
              :class="{ valid: !v$.udfn26.$invalid, invalid: v$.udfn26.$invalid }"
              v-model.number="v$.udfn26.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn27')"
              for="reservation-name-udfn27"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn27"
              id="reservation-name-udfn27"
              data-cy="udfn27"
              :class="{ valid: !v$.udfn27.$invalid, invalid: v$.udfn27.$invalid }"
              v-model.number="v$.udfn27.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn28')"
              for="reservation-name-udfn28"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn28"
              id="reservation-name-udfn28"
              data-cy="udfn28"
              :class="{ valid: !v$.udfn28.$invalid, invalid: v$.udfn28.$invalid }"
              v-model.number="v$.udfn28.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn29')"
              for="reservation-name-udfn29"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn29"
              id="reservation-name-udfn29"
              data-cy="udfn29"
              :class="{ valid: !v$.udfn29.$invalid, invalid: v$.udfn29.$invalid }"
              v-model.number="v$.udfn29.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn30')"
              for="reservation-name-udfn30"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn30"
              id="reservation-name-udfn30"
              data-cy="udfn30"
              :class="{ valid: !v$.udfn30.$invalid, invalid: v$.udfn30.$invalid }"
              v-model.number="v$.udfn30.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn31')"
              for="reservation-name-udfn31"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn31"
              id="reservation-name-udfn31"
              data-cy="udfn31"
              :class="{ valid: !v$.udfn31.$invalid, invalid: v$.udfn31.$invalid }"
              v-model.number="v$.udfn31.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn32')"
              for="reservation-name-udfn32"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn32"
              id="reservation-name-udfn32"
              data-cy="udfn32"
              :class="{ valid: !v$.udfn32.$invalid, invalid: v$.udfn32.$invalid }"
              v-model.number="v$.udfn32.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn33')"
              for="reservation-name-udfn33"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn33"
              id="reservation-name-udfn33"
              data-cy="udfn33"
              :class="{ valid: !v$.udfn33.$invalid, invalid: v$.udfn33.$invalid }"
              v-model.number="v$.udfn33.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn34')"
              for="reservation-name-udfn34"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn34"
              id="reservation-name-udfn34"
              data-cy="udfn34"
              :class="{ valid: !v$.udfn34.$invalid, invalid: v$.udfn34.$invalid }"
              v-model.number="v$.udfn34.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn35')"
              for="reservation-name-udfn35"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn35"
              id="reservation-name-udfn35"
              data-cy="udfn35"
              :class="{ valid: !v$.udfn35.$invalid, invalid: v$.udfn35.$invalid }"
              v-model.number="v$.udfn35.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn36')"
              for="reservation-name-udfn36"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn36"
              id="reservation-name-udfn36"
              data-cy="udfn36"
              :class="{ valid: !v$.udfn36.$invalid, invalid: v$.udfn36.$invalid }"
              v-model.number="v$.udfn36.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn37')"
              for="reservation-name-udfn37"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn37"
              id="reservation-name-udfn37"
              data-cy="udfn37"
              :class="{ valid: !v$.udfn37.$invalid, invalid: v$.udfn37.$invalid }"
              v-model.number="v$.udfn37.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn38')"
              for="reservation-name-udfn38"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn38"
              id="reservation-name-udfn38"
              data-cy="udfn38"
              :class="{ valid: !v$.udfn38.$invalid, invalid: v$.udfn38.$invalid }"
              v-model.number="v$.udfn38.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn39')"
              for="reservation-name-udfn39"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn39"
              id="reservation-name-udfn39"
              data-cy="udfn39"
              :class="{ valid: !v$.udfn39.$invalid, invalid: v$.udfn39.$invalid }"
              v-model.number="v$.udfn39.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfn40')"
              for="reservation-name-udfn40"
            ></label>
            <input
              type="number"
              class="form-control"
              name="udfn40"
              id="reservation-name-udfn40"
              data-cy="udfn40"
              :class="{ valid: !v$.udfn40.$invalid, invalid: v$.udfn40.$invalid }"
              v-model.number="v$.udfn40.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfd01')"
              for="reservation-name-udfd01"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-udfd01"
                  v-model="v$.udfd01.$model"
                  name="udfd01"
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
                id="reservation-name-udfd01"
                data-cy="udfd01"
                type="text"
                class="form-control"
                name="udfd01"
                :class="{ valid: !v$.udfd01.$invalid, invalid: v$.udfd01.$invalid }"
                v-model="v$.udfd01.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfd02')"
              for="reservation-name-udfd02"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-udfd02"
                  v-model="v$.udfd02.$model"
                  name="udfd02"
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
                id="reservation-name-udfd02"
                data-cy="udfd02"
                type="text"
                class="form-control"
                name="udfd02"
                :class="{ valid: !v$.udfd02.$invalid, invalid: v$.udfd02.$invalid }"
                v-model="v$.udfd02.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfd03')"
              for="reservation-name-udfd03"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-udfd03"
                  v-model="v$.udfd03.$model"
                  name="udfd03"
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
                id="reservation-name-udfd03"
                data-cy="udfd03"
                type="text"
                class="form-control"
                name="udfd03"
                :class="{ valid: !v$.udfd03.$invalid, invalid: v$.udfd03.$invalid }"
                v-model="v$.udfd03.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfd04')"
              for="reservation-name-udfd04"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-udfd04"
                  v-model="v$.udfd04.$model"
                  name="udfd04"
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
                id="reservation-name-udfd04"
                data-cy="udfd04"
                type="text"
                class="form-control"
                name="udfd04"
                :class="{ valid: !v$.udfd04.$invalid, invalid: v$.udfd04.$invalid }"
                v-model="v$.udfd04.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfd05')"
              for="reservation-name-udfd05"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-udfd05"
                  v-model="v$.udfd05.$model"
                  name="udfd05"
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
                id="reservation-name-udfd05"
                data-cy="udfd05"
                type="text"
                class="form-control"
                name="udfd05"
                :class="{ valid: !v$.udfd05.$invalid, invalid: v$.udfd05.$invalid }"
                v-model="v$.udfd05.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfd06')"
              for="reservation-name-udfd06"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-udfd06"
                  v-model="v$.udfd06.$model"
                  name="udfd06"
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
                id="reservation-name-udfd06"
                data-cy="udfd06"
                type="text"
                class="form-control"
                name="udfd06"
                :class="{ valid: !v$.udfd06.$invalid, invalid: v$.udfd06.$invalid }"
                v-model="v$.udfd06.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfd07')"
              for="reservation-name-udfd07"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-udfd07"
                  v-model="v$.udfd07.$model"
                  name="udfd07"
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
                id="reservation-name-udfd07"
                data-cy="udfd07"
                type="text"
                class="form-control"
                name="udfd07"
                :class="{ valid: !v$.udfd07.$invalid, invalid: v$.udfd07.$invalid }"
                v-model="v$.udfd07.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfd08')"
              for="reservation-name-udfd08"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-udfd08"
                  v-model="v$.udfd08.$model"
                  name="udfd08"
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
                id="reservation-name-udfd08"
                data-cy="udfd08"
                type="text"
                class="form-control"
                name="udfd08"
                :class="{ valid: !v$.udfd08.$invalid, invalid: v$.udfd08.$invalid }"
                v-model="v$.udfd08.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfd09')"
              for="reservation-name-udfd09"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-udfd09"
                  v-model="v$.udfd09.$model"
                  name="udfd09"
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
                id="reservation-name-udfd09"
                data-cy="udfd09"
                type="text"
                class="form-control"
                name="udfd09"
                :class="{ valid: !v$.udfd09.$invalid, invalid: v$.udfd09.$invalid }"
                v-model="v$.udfd09.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.udfd10')"
              for="reservation-name-udfd10"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-udfd10"
                  v-model="v$.udfd10.$model"
                  name="udfd10"
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
                id="reservation-name-udfd10"
                data-cy="udfd10"
                type="text"
                class="form-control"
                name="udfd10"
                :class="{ valid: !v$.udfd10.$invalid, invalid: v$.udfd10.$invalid }"
                v-model="v$.udfd10.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.insertActionInstanceId')"
              for="reservation-name-insertActionInstanceId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertActionInstanceId"
              id="reservation-name-insertActionInstanceId"
              data-cy="insertActionInstanceId"
              :class="{ valid: !v$.insertActionInstanceId.$invalid, invalid: v$.insertActionInstanceId.$invalid }"
              v-model.number="v$.insertActionInstanceId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.dmlSeqNo')"
              for="reservation-name-dmlSeqNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="dmlSeqNo"
              id="reservation-name-dmlSeqNo"
              data-cy="dmlSeqNo"
              :class="{ valid: !v$.dmlSeqNo.$invalid, invalid: v$.dmlSeqNo.$invalid }"
              v-model.number="v$.dmlSeqNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.businessDateCreated')"
              for="reservation-name-businessDateCreated"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-businessDateCreated"
                  v-model="v$.businessDateCreated.$model"
                  name="businessDateCreated"
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
                id="reservation-name-businessDateCreated"
                data-cy="businessDateCreated"
                type="text"
                class="form-control"
                name="businessDateCreated"
                :class="{ valid: !v$.businessDateCreated.$invalid, invalid: v$.businessDateCreated.$invalid }"
                v-model="v$.businessDateCreated.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.turndownYn')"
              for="reservation-name-turndownYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="turndownYn"
              id="reservation-name-turndownYn"
              data-cy="turndownYn"
              :class="{ valid: !v$.turndownYn.$invalid, invalid: v$.turndownYn.$invalid }"
              v-model="v$.turndownYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.roomInstructions')"
              for="reservation-name-roomInstructions"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomInstructions"
              id="reservation-name-roomInstructions"
              data-cy="roomInstructions"
              :class="{ valid: !v$.roomInstructions.$invalid, invalid: v$.roomInstructions.$invalid }"
              v-model="v$.roomInstructions.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.roomServiceTime')"
              for="reservation-name-roomServiceTime"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomServiceTime"
              id="reservation-name-roomServiceTime"
              data-cy="roomServiceTime"
              :class="{ valid: !v$.roomServiceTime.$invalid, invalid: v$.roomServiceTime.$invalid }"
              v-model="v$.roomServiceTime.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.eventId')"
              for="reservation-name-eventId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="eventId"
              id="reservation-name-eventId"
              data-cy="eventId"
              :class="{ valid: !v$.eventId.$invalid, invalid: v$.eventId.$invalid }"
              v-model.number="v$.eventId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.revenueTypeCode')"
              for="reservation-name-revenueTypeCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="revenueTypeCode"
              id="reservation-name-revenueTypeCode"
              data-cy="revenueTypeCode"
              :class="{ valid: !v$.revenueTypeCode.$invalid, invalid: v$.revenueTypeCode.$invalid }"
              v-model="v$.revenueTypeCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.hurdle')"
              for="reservation-name-hurdle"
            ></label>
            <input
              type="number"
              class="form-control"
              name="hurdle"
              id="reservation-name-hurdle"
              data-cy="hurdle"
              :class="{ valid: !v$.hurdle.$invalid, invalid: v$.hurdle.$invalid }"
              v-model.number="v$.hurdle.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.hurdleOverride')"
              for="reservation-name-hurdleOverride"
            ></label>
            <input
              type="text"
              class="form-control"
              name="hurdleOverride"
              id="reservation-name-hurdleOverride"
              data-cy="hurdleOverride"
              :class="{ valid: !v$.hurdleOverride.$invalid, invalid: v$.hurdleOverride.$invalid }"
              v-model="v$.hurdleOverride.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.rateableValue')"
              for="reservation-name-rateableValue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rateableValue"
              id="reservation-name-rateableValue"
              data-cy="rateableValue"
              :class="{ valid: !v$.rateableValue.$invalid, invalid: v$.rateableValue.$invalid }"
              v-model.number="v$.rateableValue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.restrictionOverride')"
              for="reservation-name-restrictionOverride"
            ></label>
            <input
              type="text"
              class="form-control"
              name="restrictionOverride"
              id="reservation-name-restrictionOverride"
              data-cy="restrictionOverride"
              :class="{ valid: !v$.restrictionOverride.$invalid, invalid: v$.restrictionOverride.$invalid }"
              v-model="v$.restrictionOverride.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.yieldableYn')"
              for="reservation-name-yieldableYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="yieldableYn"
              id="reservation-name-yieldableYn"
              data-cy="yieldableYn"
              :class="{ valid: !v$.yieldableYn.$invalid, invalid: v$.yieldableYn.$invalid }"
              v-model="v$.yieldableYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.sguestFirstname')"
              for="reservation-name-sguestFirstname"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sguestFirstname"
              id="reservation-name-sguestFirstname"
              data-cy="sguestFirstname"
              :class="{ valid: !v$.sguestFirstname.$invalid, invalid: v$.sguestFirstname.$invalid }"
              v-model="v$.sguestFirstname.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.guestLastName')"
              for="reservation-name-guestLastName"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guestLastName"
              id="reservation-name-guestLastName"
              data-cy="guestLastName"
              :class="{ valid: !v$.guestLastName.$invalid, invalid: v$.guestLastName.$invalid }"
              v-model="v$.guestLastName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.guestFirstName')"
              for="reservation-name-guestFirstName"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guestFirstName"
              id="reservation-name-guestFirstName"
              data-cy="guestFirstName"
              :class="{ valid: !v$.guestFirstName.$invalid, invalid: v$.guestFirstName.$invalid }"
              v-model="v$.guestFirstName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.guestLastNameSdx')"
              for="reservation-name-guestLastNameSdx"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guestLastNameSdx"
              id="reservation-name-guestLastNameSdx"
              data-cy="guestLastNameSdx"
              :class="{ valid: !v$.guestLastNameSdx.$invalid, invalid: v$.guestLastNameSdx.$invalid }"
              v-model="v$.guestLastNameSdx.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.guestFirstNameSdx')"
              for="reservation-name-guestFirstNameSdx"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guestFirstNameSdx"
              id="reservation-name-guestFirstNameSdx"
              data-cy="guestFirstNameSdx"
              :class="{ valid: !v$.guestFirstNameSdx.$invalid, invalid: v$.guestFirstNameSdx.$invalid }"
              v-model="v$.guestFirstNameSdx.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.channel')"
              for="reservation-name-channel"
            ></label>
            <input
              type="text"
              class="form-control"
              name="channel"
              id="reservation-name-channel"
              data-cy="channel"
              :class="{ valid: !v$.channel.$invalid, invalid: v$.channel.$invalid }"
              v-model="v$.channel.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.shareSeqNo')"
              for="reservation-name-shareSeqNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="shareSeqNo"
              id="reservation-name-shareSeqNo"
              data-cy="shareSeqNo"
              :class="{ valid: !v$.shareSeqNo.$invalid, invalid: v$.shareSeqNo.$invalid }"
              v-model.number="v$.shareSeqNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.guestSignature')"
              for="reservation-name-guestSignature"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guestSignature"
              id="reservation-name-guestSignature"
              data-cy="guestSignature"
              :class="{ valid: !v$.guestSignature.$invalid, invalid: v$.guestSignature.$invalid }"
              v-model="v$.guestSignature.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.extensionId')"
              for="reservation-name-extensionId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="extensionId"
              id="reservation-name-extensionId"
              data-cy="extensionId"
              :class="{ valid: !v$.extensionId.$invalid, invalid: v$.extensionId.$invalid }"
              v-model.number="v$.extensionId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.resvContactId')"
              for="reservation-name-resvContactId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="resvContactId"
              id="reservation-name-resvContactId"
              data-cy="resvContactId"
              :class="{ valid: !v$.resvContactId.$invalid, invalid: v$.resvContactId.$invalid }"
              v-model.number="v$.resvContactId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.billingContactId')"
              for="reservation-name-billingContactId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="billingContactId"
              id="reservation-name-billingContactId"
              data-cy="billingContactId"
              :class="{ valid: !v$.billingContactId.$invalid, invalid: v$.billingContactId.$invalid }"
              v-model.number="v$.billingContactId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.resInsertSource')"
              for="reservation-name-resInsertSource"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resInsertSource"
              id="reservation-name-resInsertSource"
              data-cy="resInsertSource"
              :class="{ valid: !v$.resInsertSource.$invalid, invalid: v$.resInsertSource.$invalid }"
              v-model="v$.resInsertSource.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.resInsertSourceType')"
              for="reservation-name-resInsertSourceType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resInsertSourceType"
              id="reservation-name-resInsertSourceType"
              data-cy="resInsertSourceType"
              :class="{ valid: !v$.resInsertSourceType.$invalid, invalid: v$.resInsertSourceType.$invalid }"
              v-model="v$.resInsertSourceType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.masterShare')"
              for="reservation-name-masterShare"
            ></label>
            <input
              type="text"
              class="form-control"
              name="masterShare"
              id="reservation-name-masterShare"
              data-cy="masterShare"
              :class="{ valid: !v$.masterShare.$invalid, invalid: v$.masterShare.$invalid }"
              v-model="v$.masterShare.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.registrationCardNo')"
              for="reservation-name-registrationCardNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="registrationCardNo"
              id="reservation-name-registrationCardNo"
              data-cy="registrationCardNo"
              :class="{ valid: !v$.registrationCardNo.$invalid, invalid: v$.registrationCardNo.$invalid }"
              v-model="v$.registrationCardNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.tiad')"
              for="reservation-name-tiad"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tiad"
              id="reservation-name-tiad"
              data-cy="tiad"
              :class="{ valid: !v$.tiad.$invalid, invalid: v$.tiad.$invalid }"
              v-model="v$.tiad.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.purposeOfStay')"
              for="reservation-name-purposeOfStay"
            ></label>
            <input
              type="text"
              class="form-control"
              name="purposeOfStay"
              id="reservation-name-purposeOfStay"
              data-cy="purposeOfStay"
              :class="{ valid: !v$.purposeOfStay.$invalid, invalid: v$.purposeOfStay.$invalid }"
              v-model="v$.purposeOfStay.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.reinstateDate')"
              for="reservation-name-reinstateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-reinstateDate"
                  v-model="v$.reinstateDate.$model"
                  name="reinstateDate"
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
                id="reservation-name-reinstateDate"
                data-cy="reinstateDate"
                type="text"
                class="form-control"
                name="reinstateDate"
                :class="{ valid: !v$.reinstateDate.$invalid, invalid: v$.reinstateDate.$invalid }"
                v-model="v$.reinstateDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.purgeDate')"
              for="reservation-name-purgeDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-purgeDate"
                  v-model="v$.purgeDate.$model"
                  name="purgeDate"
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
                id="reservation-name-purgeDate"
                data-cy="purgeDate"
                type="text"
                class="form-control"
                name="purgeDate"
                :class="{ valid: !v$.purgeDate.$invalid, invalid: v$.purgeDate.$invalid }"
                v-model="v$.purgeDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.lastSettleDate')"
              for="reservation-name-lastSettleDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-lastSettleDate"
                  v-model="v$.lastSettleDate.$model"
                  name="lastSettleDate"
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
                id="reservation-name-lastSettleDate"
                data-cy="lastSettleDate"
                type="text"
                class="form-control"
                name="lastSettleDate"
                :class="{ valid: !v$.lastSettleDate.$invalid, invalid: v$.lastSettleDate.$invalid }"
                v-model="v$.lastSettleDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.lastPeriodicFolioDate')"
              for="reservation-name-lastPeriodicFolioDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-lastPeriodicFolioDate"
                  v-model="v$.lastPeriodicFolioDate.$model"
                  name="lastPeriodicFolioDate"
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
                id="reservation-name-lastPeriodicFolioDate"
                data-cy="lastPeriodicFolioDate"
                type="text"
                class="form-control"
                name="lastPeriodicFolioDate"
                :class="{ valid: !v$.lastPeriodicFolioDate.$invalid, invalid: v$.lastPeriodicFolioDate.$invalid }"
                v-model="v$.lastPeriodicFolioDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.periodicFolioFreq')"
              for="reservation-name-periodicFolioFreq"
            ></label>
            <input
              type="number"
              class="form-control"
              name="periodicFolioFreq"
              id="reservation-name-periodicFolioFreq"
              data-cy="periodicFolioFreq"
              :class="{ valid: !v$.periodicFolioFreq.$invalid, invalid: v$.periodicFolioFreq.$invalid }"
              v-model.number="v$.periodicFolioFreq.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.confirmationLegNo')"
              for="reservation-name-confirmationLegNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="confirmationLegNo"
              id="reservation-name-confirmationLegNo"
              data-cy="confirmationLegNo"
              :class="{ valid: !v$.confirmationLegNo.$invalid, invalid: v$.confirmationLegNo.$invalid }"
              v-model.number="v$.confirmationLegNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.guestStatus')"
              for="reservation-name-guestStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guestStatus"
              id="reservation-name-guestStatus"
              data-cy="guestStatus"
              :class="{ valid: !v$.guestStatus.$invalid, invalid: v$.guestStatus.$invalid }"
              v-model="v$.guestStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.guestType')"
              for="reservation-name-guestType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guestType"
              id="reservation-name-guestType"
              data-cy="guestType"
              :class="{ valid: !v$.guestType.$invalid, invalid: v$.guestType.$invalid }"
              v-model="v$.guestType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.checkinDuration')"
              for="reservation-name-checkinDuration"
            ></label>
            <input
              type="number"
              class="form-control"
              name="checkinDuration"
              id="reservation-name-checkinDuration"
              data-cy="checkinDuration"
              :class="{ valid: !v$.checkinDuration.$invalid, invalid: v$.checkinDuration.$invalid }"
              v-model.number="v$.checkinDuration.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.authorizerId')"
              for="reservation-name-authorizerId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="authorizerId"
              id="reservation-name-authorizerId"
              data-cy="authorizerId"
              :class="{ valid: !v$.authorizerId.$invalid, invalid: v$.authorizerId.$invalid }"
              v-model.number="v$.authorizerId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.lastOnlinePrintSeq')"
              for="reservation-name-lastOnlinePrintSeq"
            ></label>
            <input
              type="number"
              class="form-control"
              name="lastOnlinePrintSeq"
              id="reservation-name-lastOnlinePrintSeq"
              data-cy="lastOnlinePrintSeq"
              :class="{ valid: !v$.lastOnlinePrintSeq.$invalid, invalid: v$.lastOnlinePrintSeq.$invalid }"
              v-model.number="v$.lastOnlinePrintSeq.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.entryPoint')"
              for="reservation-name-entryPoint"
            ></label>
            <input
              type="text"
              class="form-control"
              name="entryPoint"
              id="reservation-name-entryPoint"
              data-cy="entryPoint"
              :class="{ valid: !v$.entryPoint.$invalid, invalid: v$.entryPoint.$invalid }"
              v-model="v$.entryPoint.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.entryDate')"
              for="reservation-name-entryDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-entryDate"
                  v-model="v$.entryDate.$model"
                  name="entryDate"
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
                id="reservation-name-entryDate"
                data-cy="entryDate"
                type="text"
                class="form-control"
                name="entryDate"
                :class="{ valid: !v$.entryDate.$invalid, invalid: v$.entryDate.$invalid }"
                v-model="v$.entryDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.pseudoMemType')"
              for="reservation-name-pseudoMemType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="pseudoMemType"
              id="reservation-name-pseudoMemType"
              data-cy="pseudoMemType"
              :class="{ valid: !v$.pseudoMemType.$invalid, invalid: v$.pseudoMemType.$invalid }"
              v-model="v$.pseudoMemType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.pseudoMemTotalPoints')"
              for="reservation-name-pseudoMemTotalPoints"
            ></label>
            <input
              type="number"
              class="form-control"
              name="pseudoMemTotalPoints"
              id="reservation-name-pseudoMemTotalPoints"
              data-cy="pseudoMemTotalPoints"
              :class="{ valid: !v$.pseudoMemTotalPoints.$invalid, invalid: v$.pseudoMemTotalPoints.$invalid }"
              v-model.number="v$.pseudoMemTotalPoints.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.folioText1')"
              for="reservation-name-folioText1"
            ></label>
            <input
              type="text"
              class="form-control"
              name="folioText1"
              id="reservation-name-folioText1"
              data-cy="folioText1"
              :class="{ valid: !v$.folioText1.$invalid, invalid: v$.folioText1.$invalid }"
              v-model="v$.folioText1.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.folioText2')"
              for="reservation-name-folioText2"
            ></label>
            <input
              type="text"
              class="form-control"
              name="folioText2"
              id="reservation-name-folioText2"
              data-cy="folioText2"
              :class="{ valid: !v$.folioText2.$invalid, invalid: v$.folioText2.$invalid }"
              v-model="v$.folioText2.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.compTypeCode')"
              for="reservation-name-compTypeCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="compTypeCode"
              id="reservation-name-compTypeCode"
              data-cy="compTypeCode"
              :class="{ valid: !v$.compTypeCode.$invalid, invalid: v$.compTypeCode.$invalid }"
              v-model="v$.compTypeCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.uniCardId')"
              for="reservation-name-uniCardId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="uniCardId"
              id="reservation-name-uniCardId"
              data-cy="uniCardId"
              :class="{ valid: !v$.uniCardId.$invalid, invalid: v$.uniCardId.$invalid }"
              v-model="v$.uniCardId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.expCheckinresId')"
              for="reservation-name-expCheckinresId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="expCheckinresId"
              id="reservation-name-expCheckinresId"
              data-cy="expCheckinresId"
              :class="{ valid: !v$.expCheckinresId.$invalid, invalid: v$.expCheckinresId.$invalid }"
              v-model.number="v$.expCheckinresId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.originalBeginDate')"
              for="reservation-name-originalBeginDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-originalBeginDate"
                  v-model="v$.originalBeginDate.$model"
                  name="originalBeginDate"
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
                id="reservation-name-originalBeginDate"
                data-cy="originalBeginDate"
                type="text"
                class="form-control"
                name="originalBeginDate"
                :class="{ valid: !v$.originalBeginDate.$invalid, invalid: v$.originalBeginDate.$invalid }"
                v-model="v$.originalBeginDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.ownerFfFlag')"
              for="reservation-name-ownerFfFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ownerFfFlag"
              id="reservation-name-ownerFfFlag"
              data-cy="ownerFfFlag"
              :class="{ valid: !v$.ownerFfFlag.$invalid, invalid: v$.ownerFfFlag.$invalid }"
              v-model="v$.ownerFfFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.commissionPayoutTo')"
              for="reservation-name-commissionPayoutTo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="commissionPayoutTo"
              id="reservation-name-commissionPayoutTo"
              data-cy="commissionPayoutTo"
              :class="{ valid: !v$.commissionPayoutTo.$invalid, invalid: v$.commissionPayoutTo.$invalid }"
              v-model="v$.commissionPayoutTo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.preChargingYn')"
              for="reservation-name-preChargingYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="preChargingYn"
              id="reservation-name-preChargingYn"
              data-cy="preChargingYn"
              :class="{ valid: !v$.preChargingYn.$invalid, invalid: v$.preChargingYn.$invalid }"
              v-model="v$.preChargingYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.postChargingYn')"
              for="reservation-name-postChargingYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="postChargingYn"
              id="reservation-name-postChargingYn"
              data-cy="postChargingYn"
              :class="{ valid: !v$.postChargingYn.$invalid, invalid: v$.postChargingYn.$invalid }"
              v-model="v$.postChargingYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.postCoFlag')"
              for="reservation-name-postCoFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="postCoFlag"
              id="reservation-name-postCoFlag"
              data-cy="postCoFlag"
              :class="{ valid: !v$.postCoFlag.$invalid, invalid: v$.postCoFlag.$invalid }"
              v-model="v$.postCoFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.folioCloseDate')"
              for="reservation-name-folioCloseDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-folioCloseDate"
                  v-model="v$.folioCloseDate.$model"
                  name="folioCloseDate"
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
                id="reservation-name-folioCloseDate"
                data-cy="folioCloseDate"
                type="text"
                class="form-control"
                name="folioCloseDate"
                :class="{ valid: !v$.folioCloseDate.$invalid, invalid: v$.folioCloseDate.$invalid }"
                v-model="v$.folioCloseDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.scheduleCheckoutYn')"
              for="reservation-name-scheduleCheckoutYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="scheduleCheckoutYn"
              id="reservation-name-scheduleCheckoutYn"
              data-cy="scheduleCheckoutYn"
              :class="{ valid: !v$.scheduleCheckoutYn.$invalid, invalid: v$.scheduleCheckoutYn.$invalid }"
              v-model="v$.scheduleCheckoutYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.customReference')"
              for="reservation-name-customReference"
            ></label>
            <input
              type="text"
              class="form-control"
              name="customReference"
              id="reservation-name-customReference"
              data-cy="customReference"
              :class="{ valid: !v$.customReference.$invalid, invalid: v$.customReference.$invalid }"
              v-model="v$.customReference.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.guaranteeCodePreCi')"
              for="reservation-name-guaranteeCodePreCi"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guaranteeCodePreCi"
              id="reservation-name-guaranteeCodePreCi"
              data-cy="guaranteeCodePreCi"
              :class="{ valid: !v$.guaranteeCodePreCi.$invalid, invalid: v$.guaranteeCodePreCi.$invalid }"
              v-model="v$.guaranteeCodePreCi.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.awardMembershipId')"
              for="reservation-name-awardMembershipId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="awardMembershipId"
              id="reservation-name-awardMembershipId"
              data-cy="awardMembershipId"
              :class="{ valid: !v$.awardMembershipId.$invalid, invalid: v$.awardMembershipId.$invalid }"
              v-model.number="v$.awardMembershipId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.esignedRegCardName')"
              for="reservation-name-esignedRegCardName"
            ></label>
            <input
              type="text"
              class="form-control"
              name="esignedRegCardName"
              id="reservation-name-esignedRegCardName"
              data-cy="esignedRegCardName"
              :class="{ valid: !v$.esignedRegCardName.$invalid, invalid: v$.esignedRegCardName.$invalid }"
              v-model="v$.esignedRegCardName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.statisticalRoomType')"
              for="reservation-name-statisticalRoomType"
            ></label>
            <input
              type="number"
              class="form-control"
              name="statisticalRoomType"
              id="reservation-name-statisticalRoomType"
              data-cy="statisticalRoomType"
              :class="{ valid: !v$.statisticalRoomType.$invalid, invalid: v$.statisticalRoomType.$invalid }"
              v-model.number="v$.statisticalRoomType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.statisticalRateTier')"
              for="reservation-name-statisticalRateTier"
            ></label>
            <input
              type="number"
              class="form-control"
              name="statisticalRateTier"
              id="reservation-name-statisticalRateTier"
              data-cy="statisticalRateTier"
              :class="{ valid: !v$.statisticalRateTier.$invalid, invalid: v$.statisticalRateTier.$invalid }"
              v-model.number="v$.statisticalRateTier.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.ymCode')"
              for="reservation-name-ymCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ymCode"
              id="reservation-name-ymCode"
              data-cy="ymCode"
              :class="{ valid: !v$.ymCode.$invalid, invalid: v$.ymCode.$invalid }"
              v-model="v$.ymCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.keyValidUntil')"
              for="reservation-name-keyValidUntil"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-keyValidUntil"
                  v-model="v$.keyValidUntil.$model"
                  name="keyValidUntil"
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
                id="reservation-name-keyValidUntil"
                data-cy="keyValidUntil"
                type="text"
                class="form-control"
                name="keyValidUntil"
                :class="{ valid: !v$.keyValidUntil.$invalid, invalid: v$.keyValidUntil.$invalid }"
                v-model="v$.keyValidUntil.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.preRegisteredYn')"
              for="reservation-name-preRegisteredYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="preRegisteredYn"
              id="reservation-name-preRegisteredYn"
              data-cy="preRegisteredYn"
              :class="{ valid: !v$.preRegisteredYn.$invalid, invalid: v$.preRegisteredYn.$invalid }"
              v-model="v$.preRegisteredYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.taxRegistrationNo')"
              for="reservation-name-taxRegistrationNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="taxRegistrationNo"
              id="reservation-name-taxRegistrationNo"
              data-cy="taxRegistrationNo"
              :class="{ valid: !v$.taxRegistrationNo.$invalid, invalid: v$.taxRegistrationNo.$invalid }"
              v-model.number="v$.taxRegistrationNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.visaNumber')"
              for="reservation-name-visaNumber"
            ></label>
            <input
              type="text"
              class="form-control"
              name="visaNumber"
              id="reservation-name-visaNumber"
              data-cy="visaNumber"
              :class="{ valid: !v$.visaNumber.$invalid, invalid: v$.visaNumber.$invalid }"
              v-model="v$.visaNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.visaIssueDate')"
              for="reservation-name-visaIssueDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-visaIssueDate"
                  v-model="v$.visaIssueDate.$model"
                  name="visaIssueDate"
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
                id="reservation-name-visaIssueDate"
                data-cy="visaIssueDate"
                type="text"
                class="form-control"
                name="visaIssueDate"
                :class="{ valid: !v$.visaIssueDate.$invalid, invalid: v$.visaIssueDate.$invalid }"
                v-model="v$.visaIssueDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.visaExpirationDate')"
              for="reservation-name-visaExpirationDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-visaExpirationDate"
                  v-model="v$.visaExpirationDate.$model"
                  name="visaExpirationDate"
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
                id="reservation-name-visaExpirationDate"
                data-cy="visaExpirationDate"
                type="text"
                class="form-control"
                name="visaExpirationDate"
                :class="{ valid: !v$.visaExpirationDate.$invalid, invalid: v$.visaExpirationDate.$invalid }"
                v-model="v$.visaExpirationDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.taxNoOfStays')"
              for="reservation-name-taxNoOfStays"
            ></label>
            <input
              type="number"
              class="form-control"
              name="taxNoOfStays"
              id="reservation-name-taxNoOfStays"
              data-cy="taxNoOfStays"
              :class="{ valid: !v$.taxNoOfStays.$invalid, invalid: v$.taxNoOfStays.$invalid }"
              v-model.number="v$.taxNoOfStays.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.asbProratedYn')"
              for="reservation-name-asbProratedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="asbProratedYn"
              id="reservation-name-asbProratedYn"
              data-cy="asbProratedYn"
              :class="{ valid: !v$.asbProratedYn.$invalid, invalid: v$.asbProratedYn.$invalid }"
              v-model="v$.asbProratedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.autoSettleDays')"
              for="reservation-name-autoSettleDays"
            ></label>
            <input
              type="number"
              class="form-control"
              name="autoSettleDays"
              id="reservation-name-autoSettleDays"
              data-cy="autoSettleDays"
              :class="{ valid: !v$.autoSettleDays.$invalid, invalid: v$.autoSettleDays.$invalid }"
              v-model.number="v$.autoSettleDays.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.autoSettleYn')"
              for="reservation-name-autoSettleYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="autoSettleYn"
              id="reservation-name-autoSettleYn"
              data-cy="autoSettleYn"
              :class="{ valid: !v$.autoSettleYn.$invalid, invalid: v$.autoSettleYn.$invalid }"
              v-model="v$.autoSettleYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.splitFromResvNameId')"
              for="reservation-name-splitFromResvNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="splitFromResvNameId"
              id="reservation-name-splitFromResvNameId"
              data-cy="splitFromResvNameId"
              :class="{ valid: !v$.splitFromResvNameId.$invalid, invalid: v$.splitFromResvNameId.$invalid }"
              v-model.number="v$.splitFromResvNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.nextDestination')"
              for="reservation-name-nextDestination"
            ></label>
            <input
              type="text"
              class="form-control"
              name="nextDestination"
              id="reservation-name-nextDestination"
              data-cy="nextDestination"
              :class="{ valid: !v$.nextDestination.$invalid, invalid: v$.nextDestination.$invalid }"
              v-model="v$.nextDestination.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.dateOfArrivalInCountry')"
              for="reservation-name-dateOfArrivalInCountry"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-dateOfArrivalInCountry"
                  v-model="v$.dateOfArrivalInCountry.$model"
                  name="dateOfArrivalInCountry"
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
                id="reservation-name-dateOfArrivalInCountry"
                data-cy="dateOfArrivalInCountry"
                type="text"
                class="form-control"
                name="dateOfArrivalInCountry"
                :class="{ valid: !v$.dateOfArrivalInCountry.$invalid, invalid: v$.dateOfArrivalInCountry.$invalid }"
                v-model="v$.dateOfArrivalInCountry.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.preArrReviewedDt')"
              for="reservation-name-preArrReviewedDt"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-preArrReviewedDt"
                  v-model="v$.preArrReviewedDt.$model"
                  name="preArrReviewedDt"
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
                id="reservation-name-preArrReviewedDt"
                data-cy="preArrReviewedDt"
                type="text"
                class="form-control"
                name="preArrReviewedDt"
                :class="{ valid: !v$.preArrReviewedDt.$invalid, invalid: v$.preArrReviewedDt.$invalid }"
                v-model="v$.preArrReviewedDt.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.preArrReviewedUser')"
              for="reservation-name-preArrReviewedUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="preArrReviewedUser"
              id="reservation-name-preArrReviewedUser"
              data-cy="preArrReviewedUser"
              :class="{ valid: !v$.preArrReviewedUser.$invalid, invalid: v$.preArrReviewedUser.$invalid }"
              v-model.number="v$.preArrReviewedUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.bonusCheckId')"
              for="reservation-name-bonusCheckId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="bonusCheckId"
              id="reservation-name-bonusCheckId"
              data-cy="bonusCheckId"
              :class="{ valid: !v$.bonusCheckId.$invalid, invalid: v$.bonusCheckId.$invalid }"
              v-model.number="v$.bonusCheckId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.mobileAudioKeyYn')"
              for="reservation-name-mobileAudioKeyYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="mobileAudioKeyYn"
              id="reservation-name-mobileAudioKeyYn"
              data-cy="mobileAudioKeyYn"
              :class="{ valid: !v$.mobileAudioKeyYn.$invalid, invalid: v$.mobileAudioKeyYn.$invalid }"
              v-model="v$.mobileAudioKeyYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.directBillVerifyResponse')"
              for="reservation-name-directBillVerifyResponse"
            ></label>
            <input
              type="text"
              class="form-control"
              name="directBillVerifyResponse"
              id="reservation-name-directBillVerifyResponse"
              data-cy="directBillVerifyResponse"
              :class="{ valid: !v$.directBillVerifyResponse.$invalid, invalid: v$.directBillVerifyResponse.$invalid }"
              v-model="v$.directBillVerifyResponse.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.addresseeNameId')"
              for="reservation-name-addresseeNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="addresseeNameId"
              id="reservation-name-addresseeNameId"
              data-cy="addresseeNameId"
              :class="{ valid: !v$.addresseeNameId.$invalid, invalid: v$.addresseeNameId.$invalid }"
              v-model.number="v$.addresseeNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.superSearchIndexText')"
              for="reservation-name-superSearchIndexText"
            ></label>
            <input
              type="text"
              class="form-control"
              name="superSearchIndexText"
              id="reservation-name-superSearchIndexText"
              data-cy="superSearchIndexText"
              :class="{ valid: !v$.superSearchIndexText.$invalid, invalid: v$.superSearchIndexText.$invalid }"
              v-model="v$.superSearchIndexText.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.autoCheckinYn')"
              for="reservation-name-autoCheckinYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="autoCheckinYn"
              id="reservation-name-autoCheckinYn"
              data-cy="autoCheckinYn"
              :class="{ valid: !v$.autoCheckinYn.$invalid, invalid: v$.autoCheckinYn.$invalid }"
              v-model="v$.autoCheckinYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.emailFolioYn')"
              for="reservation-name-emailFolioYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="emailFolioYn"
              id="reservation-name-emailFolioYn"
              data-cy="emailFolioYn"
              :class="{ valid: !v$.emailFolioYn.$invalid, invalid: v$.emailFolioYn.$invalid }"
              v-model="v$.emailFolioYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.emailAddress')"
              for="reservation-name-emailAddress"
            ></label>
            <input
              type="text"
              class="form-control"
              name="emailAddress"
              id="reservation-name-emailAddress"
              data-cy="emailAddress"
              :class="{ valid: !v$.emailAddress.$invalid, invalid: v$.emailAddress.$invalid }"
              v-model="v$.emailAddress.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.spgUpgradeConfirmedRoomtype')"
              for="reservation-name-spgUpgradeConfirmedRoomtype"
            ></label>
            <input
              type="text"
              class="form-control"
              name="spgUpgradeConfirmedRoomtype"
              id="reservation-name-spgUpgradeConfirmedRoomtype"
              data-cy="spgUpgradeConfirmedRoomtype"
              :class="{ valid: !v$.spgUpgradeConfirmedRoomtype.$invalid, invalid: v$.spgUpgradeConfirmedRoomtype.$invalid }"
              v-model="v$.spgUpgradeConfirmedRoomtype.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.spgUpgradeReasonCode')"
              for="reservation-name-spgUpgradeReasonCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="spgUpgradeReasonCode"
              id="reservation-name-spgUpgradeReasonCode"
              data-cy="spgUpgradeReasonCode"
              :class="{ valid: !v$.spgUpgradeReasonCode.$invalid, invalid: v$.spgUpgradeReasonCode.$invalid }"
              v-model="v$.spgUpgradeReasonCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.spgSuiteNightAwardStatus')"
              for="reservation-name-spgSuiteNightAwardStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="spgSuiteNightAwardStatus"
              id="reservation-name-spgSuiteNightAwardStatus"
              data-cy="spgSuiteNightAwardStatus"
              :class="{ valid: !v$.spgSuiteNightAwardStatus.$invalid, invalid: v$.spgSuiteNightAwardStatus.$invalid }"
              v-model="v$.spgSuiteNightAwardStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.spgDiscloseRoomTypeYn')"
              for="reservation-name-spgDiscloseRoomTypeYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="spgDiscloseRoomTypeYn"
              id="reservation-name-spgDiscloseRoomTypeYn"
              data-cy="spgDiscloseRoomTypeYn"
              :class="{ valid: !v$.spgDiscloseRoomTypeYn.$invalid, invalid: v$.spgDiscloseRoomTypeYn.$invalid }"
              v-model="v$.spgDiscloseRoomTypeYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.amenityEligibleYn')"
              for="reservation-name-amenityEligibleYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="amenityEligibleYn"
              id="reservation-name-amenityEligibleYn"
              data-cy="amenityEligibleYn"
              :class="{ valid: !v$.amenityEligibleYn.$invalid, invalid: v$.amenityEligibleYn.$invalid }"
              v-model="v$.amenityEligibleYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.amenityLevelCode')"
              for="reservation-name-amenityLevelCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="amenityLevelCode"
              id="reservation-name-amenityLevelCode"
              data-cy="amenityLevelCode"
              :class="{ valid: !v$.amenityLevelCode.$invalid, invalid: v$.amenityLevelCode.$invalid }"
              v-model="v$.amenityLevelCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.baseRateCurrencyCode')"
              for="reservation-name-baseRateCurrencyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="baseRateCurrencyCode"
              id="reservation-name-baseRateCurrencyCode"
              data-cy="baseRateCurrencyCode"
              :class="{ valid: !v$.baseRateCurrencyCode.$invalid, invalid: v$.baseRateCurrencyCode.$invalid }"
              v-model="v$.baseRateCurrencyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.baseRateCode')"
              for="reservation-name-baseRateCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="baseRateCode"
              id="reservation-name-baseRateCode"
              data-cy="baseRateCode"
              :class="{ valid: !v$.baseRateCode.$invalid, invalid: v$.baseRateCode.$invalid }"
              v-model="v$.baseRateCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.localBaseRateAmount')"
              for="reservation-name-localBaseRateAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="localBaseRateAmount"
              id="reservation-name-localBaseRateAmount"
              data-cy="localBaseRateAmount"
              :class="{ valid: !v$.localBaseRateAmount.$invalid, invalid: v$.localBaseRateAmount.$invalid }"
              v-model.number="v$.localBaseRateAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.phoneDisplayNameYn')"
              for="reservation-name-phoneDisplayNameYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="phoneDisplayNameYn"
              id="reservation-name-phoneDisplayNameYn"
              data-cy="phoneDisplayNameYn"
              :class="{ valid: !v$.phoneDisplayNameYn.$invalid, invalid: v$.phoneDisplayNameYn.$invalid }"
              v-model="v$.phoneDisplayNameYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.resortChargeNumber')"
              for="reservation-name-resortChargeNumber"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resortChargeNumber"
              id="reservation-name-resortChargeNumber"
              data-cy="resortChargeNumber"
              :class="{ valid: !v$.resortChargeNumber.$invalid, invalid: v$.resortChargeNumber.$invalid }"
              v-model="v$.resortChargeNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.mobileChkoutAllowed')"
              for="reservation-name-mobileChkoutAllowed"
            ></label>
            <input
              type="text"
              class="form-control"
              name="mobileChkoutAllowed"
              id="reservation-name-mobileChkoutAllowed"
              data-cy="mobileChkoutAllowed"
              :class="{ valid: !v$.mobileChkoutAllowed.$invalid, invalid: v$.mobileChkoutAllowed.$invalid }"
              v-model="v$.mobileChkoutAllowed.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.mobileViewFolioAllowed')"
              for="reservation-name-mobileViewFolioAllowed"
            ></label>
            <input
              type="text"
              class="form-control"
              name="mobileViewFolioAllowed"
              id="reservation-name-mobileViewFolioAllowed"
              data-cy="mobileViewFolioAllowed"
              :class="{ valid: !v$.mobileViewFolioAllowed.$invalid, invalid: v$.mobileViewFolioAllowed.$invalid }"
              v-model="v$.mobileViewFolioAllowed.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.hkExpectedServiceTime')"
              for="reservation-name-hkExpectedServiceTime"
            ></label>
            <input
              type="text"
              class="form-control"
              name="hkExpectedServiceTime"
              id="reservation-name-hkExpectedServiceTime"
              data-cy="hkExpectedServiceTime"
              :class="{ valid: !v$.hkExpectedServiceTime.$invalid, invalid: v$.hkExpectedServiceTime.$invalid }"
              v-model="v$.hkExpectedServiceTime.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.eligibleForUpgradeYn')"
              for="reservation-name-eligibleForUpgradeYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="eligibleForUpgradeYn"
              id="reservation-name-eligibleForUpgradeYn"
              data-cy="eligibleForUpgradeYn"
              :class="{ valid: !v$.eligibleForUpgradeYn.$invalid, invalid: v$.eligibleForUpgradeYn.$invalid }"
              v-model="v$.eligibleForUpgradeYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.beginSystemDateTime')"
              for="reservation-name-beginSystemDateTime"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-beginSystemDateTime"
                  v-model="v$.beginSystemDateTime.$model"
                  name="beginSystemDateTime"
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
                id="reservation-name-beginSystemDateTime"
                data-cy="beginSystemDateTime"
                type="text"
                class="form-control"
                name="beginSystemDateTime"
                :class="{ valid: !v$.beginSystemDateTime.$invalid, invalid: v$.beginSystemDateTime.$invalid }"
                v-model="v$.beginSystemDateTime.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.mobileCheckinAllowedYn')"
              for="reservation-name-mobileCheckinAllowedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="mobileCheckinAllowedYn"
              id="reservation-name-mobileCheckinAllowedYn"
              data-cy="mobileCheckinAllowedYn"
              :class="{ valid: !v$.mobileCheckinAllowedYn.$invalid, invalid: v$.mobileCheckinAllowedYn.$invalid }"
              v-model="v$.mobileCheckinAllowedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.quoteId')"
              for="reservation-name-quoteId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="quoteId"
              id="reservation-name-quoteId"
              data-cy="quoteId"
              :class="{ valid: !v$.quoteId.$invalid, invalid: v$.quoteId.$invalid }"
              v-model="v$.quoteId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.manualCheckoutStatus')"
              for="reservation-name-manualCheckoutStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="manualCheckoutStatus"
              id="reservation-name-manualCheckoutStatus"
              data-cy="manualCheckoutStatus"
              :class="{ valid: !v$.manualCheckoutStatus.$invalid, invalid: v$.manualCheckoutStatus.$invalid }"
              v-model="v$.manualCheckoutStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.mobilePreferredCurrency')"
              for="reservation-name-mobilePreferredCurrency"
            ></label>
            <input
              type="text"
              class="form-control"
              name="mobilePreferredCurrency"
              id="reservation-name-mobilePreferredCurrency"
              data-cy="mobilePreferredCurrency"
              :class="{ valid: !v$.mobilePreferredCurrency.$invalid, invalid: v$.mobilePreferredCurrency.$invalid }"
              v-model="v$.mobilePreferredCurrency.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.mobileActionAlertIssued')"
              for="reservation-name-mobileActionAlertIssued"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-mobileActionAlertIssued"
                  v-model="v$.mobileActionAlertIssued.$model"
                  name="mobileActionAlertIssued"
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
                id="reservation-name-mobileActionAlertIssued"
                data-cy="mobileActionAlertIssued"
                type="text"
                class="form-control"
                name="mobileActionAlertIssued"
                :class="{ valid: !v$.mobileActionAlertIssued.$invalid, invalid: v$.mobileActionAlertIssued.$invalid }"
                v-model="v$.mobileActionAlertIssued.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.externalEfolioYn')"
              for="reservation-name-externalEfolioYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="externalEfolioYn"
              id="reservation-name-externalEfolioYn"
              data-cy="externalEfolioYn"
              :class="{ valid: !v$.externalEfolioYn.$invalid, invalid: v$.externalEfolioYn.$invalid }"
              v-model="v$.externalEfolioYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.optInBatchFolYn')"
              for="reservation-name-optInBatchFolYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="optInBatchFolYn"
              id="reservation-name-optInBatchFolYn"
              data-cy="optInBatchFolYn"
              :class="{ valid: !v$.optInBatchFolYn.$invalid, invalid: v$.optInBatchFolYn.$invalid }"
              v-model="v$.optInBatchFolYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.folioAddrElementId')"
              for="reservation-name-folioAddrElementId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="folioAddrElementId"
              id="reservation-name-folioAddrElementId"
              data-cy="folioAddrElementId"
              :class="{ valid: !v$.folioAddrElementId.$invalid, invalid: v$.folioAddrElementId.$invalid }"
              v-model.number="v$.folioAddrElementId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.operaEsignedRegCardYn')"
              for="reservation-name-operaEsignedRegCardYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="operaEsignedRegCardYn"
              id="reservation-name-operaEsignedRegCardYn"
              data-cy="operaEsignedRegCardYn"
              :class="{ valid: !v$.operaEsignedRegCardYn.$invalid, invalid: v$.operaEsignedRegCardYn.$invalid }"
              v-model="v$.operaEsignedRegCardYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.resvGuid')"
              for="reservation-name-resvGuid"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resvGuid"
              id="reservation-name-resvGuid"
              data-cy="resvGuid"
              :class="{ valid: !v$.resvGuid.$invalid, invalid: v$.resvGuid.$invalid }"
              v-model="v$.resvGuid.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.advanceCheckedInYn')"
              for="reservation-name-advanceCheckedInYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="advanceCheckedInYn"
              id="reservation-name-advanceCheckedInYn"
              data-cy="advanceCheckedInYn"
              :class="{ valid: !v$.advanceCheckedInYn.$invalid, invalid: v$.advanceCheckedInYn.$invalid }"
              v-model="v$.advanceCheckedInYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.expectedTimeOfReturn')"
              for="reservation-name-expectedTimeOfReturn"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-name-expectedTimeOfReturn"
                  v-model="v$.expectedTimeOfReturn.$model"
                  name="expectedTimeOfReturn"
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
                id="reservation-name-expectedTimeOfReturn"
                data-cy="expectedTimeOfReturn"
                type="text"
                class="form-control"
                name="expectedTimeOfReturn"
                :class="{ valid: !v$.expectedTimeOfReturn.$invalid, invalid: v$.expectedTimeOfReturn.$invalid }"
                v-model="v$.expectedTimeOfReturn.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.etrComments')"
              for="reservation-name-etrComments"
            ></label>
            <input
              type="text"
              class="form-control"
              name="etrComments"
              id="reservation-name-etrComments"
              data-cy="etrComments"
              :class="{ valid: !v$.etrComments.$invalid, invalid: v$.etrComments.$invalid }"
              v-model="v$.etrComments.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.optedForCommYn')"
              for="reservation-name-optedForCommYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="optedForCommYn"
              id="reservation-name-optedForCommYn"
              data-cy="optedForCommYn"
              :class="{ valid: !v$.optedForCommYn.$invalid, invalid: v$.optedForCommYn.$invalid }"
              v-model="v$.optedForCommYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationName.creditLimitAutoPayAllowYn')"
              for="reservation-name-creditLimitAutoPayAllowYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="creditLimitAutoPayAllowYn"
              id="reservation-name-creditLimitAutoPayAllowYn"
              data-cy="creditLimitAutoPayAllowYn"
              :class="{ valid: !v$.creditLimitAutoPayAllowYn.$invalid, invalid: v$.creditLimitAutoPayAllowYn.$invalid }"
              v-model="v$.creditLimitAutoPayAllowYn.$model"
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
<script lang="ts" src="./reservation-name-update.component.ts"></script>
