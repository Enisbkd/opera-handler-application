<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.resortOriginsOfBooking.home.createOrEditLabel"
          data-cy="ResortOriginsOfBookingCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="resortOriginsOfBooking.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="resortOriginsOfBooking.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.resort')"
              for="resort-origins-of-booking-resort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resort"
              id="resort-origins-of-booking-resort"
              data-cy="resort"
              :class="{ valid: !v$.resort.$invalid, invalid: v$.resort.$invalid }"
              v-model="v$.resort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.sourceCode')"
              for="resort-origins-of-booking-sourceCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sourceCode"
              id="resort-origins-of-booking-sourceCode"
              data-cy="sourceCode"
              :class="{ valid: !v$.sourceCode.$invalid, invalid: v$.sourceCode.$invalid }"
              v-model="v$.sourceCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.parentSourceCode')"
              for="resort-origins-of-booking-parentSourceCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="parentSourceCode"
              id="resort-origins-of-booking-parentSourceCode"
              data-cy="parentSourceCode"
              :class="{ valid: !v$.parentSourceCode.$invalid, invalid: v$.parentSourceCode.$invalid }"
              v-model="v$.parentSourceCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.description')"
              for="resort-origins-of-booking-description"
            ></label>
            <input
              type="text"
              class="form-control"
              name="description"
              id="resort-origins-of-booking-description"
              data-cy="description"
              :class="{ valid: !v$.description.$invalid, invalid: v$.description.$invalid }"
              v-model="v$.description.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.insertUser')"
              for="resort-origins-of-booking-insertUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="resort-origins-of-booking-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.insertDate')"
              for="resort-origins-of-booking-insertDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="resort-origins-of-booking-insertDate"
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
                id="resort-origins-of-booking-insertDate"
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
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.updateUser')"
              for="resort-origins-of-booking-updateUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="resort-origins-of-booking-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.updateDate')"
              for="resort-origins-of-booking-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="resort-origins-of-booking-updateDate"
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
                id="resort-origins-of-booking-updateDate"
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
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.inactiveDate')"
              for="resort-origins-of-booking-inactiveDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="resort-origins-of-booking-inactiveDate"
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
                id="resort-origins-of-booking-inactiveDate"
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
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.sellSequence')"
              for="resort-origins-of-booking-sellSequence"
            ></label>
            <input
              type="number"
              class="form-control"
              name="sellSequence"
              id="resort-origins-of-booking-sellSequence"
              data-cy="sellSequence"
              :class="{ valid: !v$.sellSequence.$invalid, invalid: v$.sellSequence.$invalid }"
              v-model.number="v$.sellSequence.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.scOrderby')"
              for="resort-origins-of-booking-scOrderby"
            ></label>
            <input
              type="number"
              class="form-control"
              name="scOrderby"
              id="resort-origins-of-booking-scOrderby"
              data-cy="scOrderby"
              :class="{ valid: !v$.scOrderby.$invalid, invalid: v$.scOrderby.$invalid }"
              v-model.number="v$.scOrderby.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.internetSalesYn')"
              for="resort-origins-of-booking-internetSalesYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="internetSalesYn"
              id="resort-origins-of-booking-internetSalesYn"
              data-cy="internetSalesYn"
              :class="{ valid: !v$.internetSalesYn.$invalid, invalid: v$.internetSalesYn.$invalid }"
              v-model="v$.internetSalesYn.$model"
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
<script lang="ts" src="./resort-origins-of-booking-update.component.ts"></script>
