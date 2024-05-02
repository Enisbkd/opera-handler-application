<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.reservationSummary.home.createOrEditLabel"
          data-cy="ReservationSummaryCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.reservationSummary.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="reservationSummary.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="reservationSummary.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.resort')"
              for="reservation-summary-resort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resort"
              id="reservation-summary-resort"
              data-cy="resort"
              :class="{ valid: !v$.resort.$invalid, invalid: v$.resort.$invalid }"
              v-model="v$.resort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.eventType')"
              for="reservation-summary-eventType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="eventType"
              id="reservation-summary-eventType"
              data-cy="eventType"
              :class="{ valid: !v$.eventType.$invalid, invalid: v$.eventType.$invalid }"
              v-model="v$.eventType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.eventId')"
              for="reservation-summary-eventId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="eventId"
              id="reservation-summary-eventId"
              data-cy="eventId"
              :class="{ valid: !v$.eventId.$invalid, invalid: v$.eventId.$invalid }"
              v-model="v$.eventId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.consideredDate')"
              for="reservation-summary-consideredDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-summary-consideredDate"
                  v-model="v$.consideredDate.$model"
                  name="consideredDate"
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
                id="reservation-summary-consideredDate"
                data-cy="consideredDate"
                type="text"
                class="form-control"
                name="consideredDate"
                :class="{ valid: !v$.consideredDate.$invalid, invalid: v$.consideredDate.$invalid }"
                v-model="v$.consideredDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.roomCategory')"
              for="reservation-summary-roomCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomCategory"
              id="reservation-summary-roomCategory"
              data-cy="roomCategory"
              :class="{ valid: !v$.roomCategory.$invalid, invalid: v$.roomCategory.$invalid }"
              v-model="v$.roomCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.roomClass')"
              for="reservation-summary-roomClass"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomClass"
              id="reservation-summary-roomClass"
              data-cy="roomClass"
              :class="{ valid: !v$.roomClass.$invalid, invalid: v$.roomClass.$invalid }"
              v-model="v$.roomClass.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.marketCode')"
              for="reservation-summary-marketCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="marketCode"
              id="reservation-summary-marketCode"
              data-cy="marketCode"
              :class="{ valid: !v$.marketCode.$invalid, invalid: v$.marketCode.$invalid }"
              v-model="v$.marketCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.sourceCode')"
              for="reservation-summary-sourceCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sourceCode"
              id="reservation-summary-sourceCode"
              data-cy="sourceCode"
              :class="{ valid: !v$.sourceCode.$invalid, invalid: v$.sourceCode.$invalid }"
              v-model="v$.sourceCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.rateCode')"
              for="reservation-summary-rateCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rateCode"
              id="reservation-summary-rateCode"
              data-cy="rateCode"
              :class="{ valid: !v$.rateCode.$invalid, invalid: v$.rateCode.$invalid }"
              v-model="v$.rateCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.regionCode')"
              for="reservation-summary-regionCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="regionCode"
              id="reservation-summary-regionCode"
              data-cy="regionCode"
              :class="{ valid: !v$.regionCode.$invalid, invalid: v$.regionCode.$invalid }"
              v-model="v$.regionCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.groupId')"
              for="reservation-summary-groupId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="groupId"
              id="reservation-summary-groupId"
              data-cy="groupId"
              :class="{ valid: !v$.groupId.$invalid, invalid: v$.groupId.$invalid }"
              v-model.number="v$.groupId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.resvType')"
              for="reservation-summary-resvType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resvType"
              id="reservation-summary-resvType"
              data-cy="resvType"
              :class="{ valid: !v$.resvType.$invalid, invalid: v$.resvType.$invalid }"
              v-model="v$.resvType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.resvInvType')"
              for="reservation-summary-resvInvType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resvInvType"
              id="reservation-summary-resvInvType"
              data-cy="resvInvType"
              :class="{ valid: !v$.resvInvType.$invalid, invalid: v$.resvInvType.$invalid }"
              v-model="v$.resvInvType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.psuedoRoomYn')"
              for="reservation-summary-psuedoRoomYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="psuedoRoomYn"
              id="reservation-summary-psuedoRoomYn"
              data-cy="psuedoRoomYn"
              :class="{ valid: !v$.psuedoRoomYn.$invalid, invalid: v$.psuedoRoomYn.$invalid }"
              v-model="v$.psuedoRoomYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.arrRooms')"
              for="reservation-summary-arrRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="arrRooms"
              id="reservation-summary-arrRooms"
              data-cy="arrRooms"
              :class="{ valid: !v$.arrRooms.$invalid, invalid: v$.arrRooms.$invalid }"
              v-model.number="v$.arrRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.adults')"
              for="reservation-summary-adults"
            ></label>
            <input
              type="number"
              class="form-control"
              name="adults"
              id="reservation-summary-adults"
              data-cy="adults"
              :class="{ valid: !v$.adults.$invalid, invalid: v$.adults.$invalid }"
              v-model.number="v$.adults.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.children')"
              for="reservation-summary-children"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children"
              id="reservation-summary-children"
              data-cy="children"
              :class="{ valid: !v$.children.$invalid, invalid: v$.children.$invalid }"
              v-model.number="v$.children.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.depRooms')"
              for="reservation-summary-depRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="depRooms"
              id="reservation-summary-depRooms"
              data-cy="depRooms"
              :class="{ valid: !v$.depRooms.$invalid, invalid: v$.depRooms.$invalid }"
              v-model.number="v$.depRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.noRooms')"
              for="reservation-summary-noRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="noRooms"
              id="reservation-summary-noRooms"
              data-cy="noRooms"
              :class="{ valid: !v$.noRooms.$invalid, invalid: v$.noRooms.$invalid }"
              v-model.number="v$.noRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.grossRate')"
              for="reservation-summary-grossRate"
            ></label>
            <input
              type="number"
              class="form-control"
              name="grossRate"
              id="reservation-summary-grossRate"
              data-cy="grossRate"
              :class="{ valid: !v$.grossRate.$invalid, invalid: v$.grossRate.$invalid }"
              v-model.number="v$.grossRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.netRoomRevenue')"
              for="reservation-summary-netRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="netRoomRevenue"
              id="reservation-summary-netRoomRevenue"
              data-cy="netRoomRevenue"
              :class="{ valid: !v$.netRoomRevenue.$invalid, invalid: v$.netRoomRevenue.$invalid }"
              v-model.number="v$.netRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.extraRevenue')"
              for="reservation-summary-extraRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="extraRevenue"
              id="reservation-summary-extraRevenue"
              data-cy="extraRevenue"
              :class="{ valid: !v$.extraRevenue.$invalid, invalid: v$.extraRevenue.$invalid }"
              v-model.number="v$.extraRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.ooRooms')"
              for="reservation-summary-ooRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="ooRooms"
              id="reservation-summary-ooRooms"
              data-cy="ooRooms"
              :class="{ valid: !v$.ooRooms.$invalid, invalid: v$.ooRooms.$invalid }"
              v-model.number="v$.ooRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.osRooms')"
              for="reservation-summary-osRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="osRooms"
              id="reservation-summary-osRooms"
              data-cy="osRooms"
              :class="{ valid: !v$.osRooms.$invalid, invalid: v$.osRooms.$invalid }"
              v-model.number="v$.osRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.remainingBlockRooms')"
              for="reservation-summary-remainingBlockRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="remainingBlockRooms"
              id="reservation-summary-remainingBlockRooms"
              data-cy="remainingBlockRooms"
              :class="{ valid: !v$.remainingBlockRooms.$invalid, invalid: v$.remainingBlockRooms.$invalid }"
              v-model.number="v$.remainingBlockRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.pickedupBlockRooms')"
              for="reservation-summary-pickedupBlockRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="pickedupBlockRooms"
              id="reservation-summary-pickedupBlockRooms"
              data-cy="pickedupBlockRooms"
              :class="{ valid: !v$.pickedupBlockRooms.$invalid, invalid: v$.pickedupBlockRooms.$invalid }"
              v-model.number="v$.pickedupBlockRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.singleOccupancy')"
              for="reservation-summary-singleOccupancy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="singleOccupancy"
              id="reservation-summary-singleOccupancy"
              data-cy="singleOccupancy"
              :class="{ valid: !v$.singleOccupancy.$invalid, invalid: v$.singleOccupancy.$invalid }"
              v-model.number="v$.singleOccupancy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.multipleOccupancy')"
              for="reservation-summary-multipleOccupancy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="multipleOccupancy"
              id="reservation-summary-multipleOccupancy"
              data-cy="multipleOccupancy"
              :class="{ valid: !v$.multipleOccupancy.$invalid, invalid: v$.multipleOccupancy.$invalid }"
              v-model.number="v$.multipleOccupancy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.blockStatus')"
              for="reservation-summary-blockStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="blockStatus"
              id="reservation-summary-blockStatus"
              data-cy="blockStatus"
              :class="{ valid: !v$.blockStatus.$invalid, invalid: v$.blockStatus.$invalid }"
              v-model="v$.blockStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.arrPersons')"
              for="reservation-summary-arrPersons"
            ></label>
            <input
              type="number"
              class="form-control"
              name="arrPersons"
              id="reservation-summary-arrPersons"
              data-cy="arrPersons"
              :class="{ valid: !v$.arrPersons.$invalid, invalid: v$.arrPersons.$invalid }"
              v-model.number="v$.arrPersons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.depPersons')"
              for="reservation-summary-depPersons"
            ></label>
            <input
              type="number"
              class="form-control"
              name="depPersons"
              id="reservation-summary-depPersons"
              data-cy="depPersons"
              :class="{ valid: !v$.depPersons.$invalid, invalid: v$.depPersons.$invalid }"
              v-model.number="v$.depPersons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.wlRooms')"
              for="reservation-summary-wlRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="wlRooms"
              id="reservation-summary-wlRooms"
              data-cy="wlRooms"
              :class="{ valid: !v$.wlRooms.$invalid, invalid: v$.wlRooms.$invalid }"
              v-model.number="v$.wlRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.wlPersons')"
              for="reservation-summary-wlPersons"
            ></label>
            <input
              type="number"
              class="form-control"
              name="wlPersons"
              id="reservation-summary-wlPersons"
              data-cy="wlPersons"
              :class="{ valid: !v$.wlPersons.$invalid, invalid: v$.wlPersons.$invalid }"
              v-model.number="v$.wlPersons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.dayUseRooms')"
              for="reservation-summary-dayUseRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="dayUseRooms"
              id="reservation-summary-dayUseRooms"
              data-cy="dayUseRooms"
              :class="{ valid: !v$.dayUseRooms.$invalid, invalid: v$.dayUseRooms.$invalid }"
              v-model.number="v$.dayUseRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.dayUsePersons')"
              for="reservation-summary-dayUsePersons"
            ></label>
            <input
              type="number"
              class="form-control"
              name="dayUsePersons"
              id="reservation-summary-dayUsePersons"
              data-cy="dayUsePersons"
              :class="{ valid: !v$.dayUsePersons.$invalid, invalid: v$.dayUsePersons.$invalid }"
              v-model.number="v$.dayUsePersons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.bookingStatus')"
              for="reservation-summary-bookingStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="bookingStatus"
              id="reservation-summary-bookingStatus"
              data-cy="bookingStatus"
              :class="{ valid: !v$.bookingStatus.$invalid, invalid: v$.bookingStatus.$invalid }"
              v-model="v$.bookingStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.resvStatus')"
              for="reservation-summary-resvStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resvStatus"
              id="reservation-summary-resvStatus"
              data-cy="resvStatus"
              :class="{ valid: !v$.resvStatus.$invalid, invalid: v$.resvStatus.$invalid }"
              v-model="v$.resvStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.dayUseYn')"
              for="reservation-summary-dayUseYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dayUseYn"
              id="reservation-summary-dayUseYn"
              data-cy="dayUseYn"
              :class="{ valid: !v$.dayUseYn.$invalid, invalid: v$.dayUseYn.$invalid }"
              v-model="v$.dayUseYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.channel')"
              for="reservation-summary-channel"
            ></label>
            <input
              type="text"
              class="form-control"
              name="channel"
              id="reservation-summary-channel"
              data-cy="channel"
              :class="{ valid: !v$.channel.$invalid, invalid: v$.channel.$invalid }"
              v-model="v$.channel.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.country')"
              for="reservation-summary-country"
            ></label>
            <input
              type="text"
              class="form-control"
              name="country"
              id="reservation-summary-country"
              data-cy="country"
              :class="{ valid: !v$.country.$invalid, invalid: v$.country.$invalid }"
              v-model="v$.country.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.nationality')"
              for="reservation-summary-nationality"
            ></label>
            <input
              type="text"
              class="form-control"
              name="nationality"
              id="reservation-summary-nationality"
              data-cy="nationality"
              :class="{ valid: !v$.nationality.$invalid, invalid: v$.nationality.$invalid }"
              v-model="v$.nationality.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.cribs')"
              for="reservation-summary-cribs"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cribs"
              id="reservation-summary-cribs"
              data-cy="cribs"
              :class="{ valid: !v$.cribs.$invalid, invalid: v$.cribs.$invalid }"
              v-model.number="v$.cribs.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.extraBeds')"
              for="reservation-summary-extraBeds"
            ></label>
            <input
              type="number"
              class="form-control"
              name="extraBeds"
              id="reservation-summary-extraBeds"
              data-cy="extraBeds"
              :class="{ valid: !v$.extraBeds.$invalid, invalid: v$.extraBeds.$invalid }"
              v-model.number="v$.extraBeds.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.adultsTaxFree')"
              for="reservation-summary-adultsTaxFree"
            ></label>
            <input
              type="number"
              class="form-control"
              name="adultsTaxFree"
              id="reservation-summary-adultsTaxFree"
              data-cy="adultsTaxFree"
              :class="{ valid: !v$.adultsTaxFree.$invalid, invalid: v$.adultsTaxFree.$invalid }"
              v-model.number="v$.adultsTaxFree.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.childrenTaxFree')"
              for="reservation-summary-childrenTaxFree"
            ></label>
            <input
              type="number"
              class="form-control"
              name="childrenTaxFree"
              id="reservation-summary-childrenTaxFree"
              data-cy="childrenTaxFree"
              :class="{ valid: !v$.childrenTaxFree.$invalid, invalid: v$.childrenTaxFree.$invalid }"
              v-model.number="v$.childrenTaxFree.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.rateCategory')"
              for="reservation-summary-rateCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rateCategory"
              id="reservation-summary-rateCategory"
              data-cy="rateCategory"
              :class="{ valid: !v$.rateCategory.$invalid, invalid: v$.rateCategory.$invalid }"
              v-model="v$.rateCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.rateClass')"
              for="reservation-summary-rateClass"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rateClass"
              id="reservation-summary-rateClass"
              data-cy="rateClass"
              :class="{ valid: !v$.rateClass.$invalid, invalid: v$.rateClass.$invalid }"
              v-model="v$.rateClass.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.roomRevenue')"
              for="reservation-summary-roomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="roomRevenue"
              id="reservation-summary-roomRevenue"
              data-cy="roomRevenue"
              :class="{ valid: !v$.roomRevenue.$invalid, invalid: v$.roomRevenue.$invalid }"
              v-model.number="v$.roomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.foodRevenue')"
              for="reservation-summary-foodRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="foodRevenue"
              id="reservation-summary-foodRevenue"
              data-cy="foodRevenue"
              :class="{ valid: !v$.foodRevenue.$invalid, invalid: v$.foodRevenue.$invalid }"
              v-model.number="v$.foodRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.otherRevenue')"
              for="reservation-summary-otherRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="otherRevenue"
              id="reservation-summary-otherRevenue"
              data-cy="otherRevenue"
              :class="{ valid: !v$.otherRevenue.$invalid, invalid: v$.otherRevenue.$invalid }"
              v-model.number="v$.otherRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.totalRevenue')"
              for="reservation-summary-totalRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="totalRevenue"
              id="reservation-summary-totalRevenue"
              data-cy="totalRevenue"
              :class="{ valid: !v$.totalRevenue.$invalid, invalid: v$.totalRevenue.$invalid }"
              v-model.number="v$.totalRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.nonRevenue')"
              for="reservation-summary-nonRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="nonRevenue"
              id="reservation-summary-nonRevenue"
              data-cy="nonRevenue"
              :class="{ valid: !v$.nonRevenue.$invalid, invalid: v$.nonRevenue.$invalid }"
              v-model.number="v$.nonRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.allotmentHeaderId')"
              for="reservation-summary-allotmentHeaderId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="allotmentHeaderId"
              id="reservation-summary-allotmentHeaderId"
              data-cy="allotmentHeaderId"
              :class="{ valid: !v$.allotmentHeaderId.$invalid, invalid: v$.allotmentHeaderId.$invalid }"
              v-model.number="v$.allotmentHeaderId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.roomRevenueTax')"
              for="reservation-summary-roomRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="roomRevenueTax"
              id="reservation-summary-roomRevenueTax"
              data-cy="roomRevenueTax"
              :class="{ valid: !v$.roomRevenueTax.$invalid, invalid: v$.roomRevenueTax.$invalid }"
              v-model.number="v$.roomRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.foodRevenueTax')"
              for="reservation-summary-foodRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="foodRevenueTax"
              id="reservation-summary-foodRevenueTax"
              data-cy="foodRevenueTax"
              :class="{ valid: !v$.foodRevenueTax.$invalid, invalid: v$.foodRevenueTax.$invalid }"
              v-model.number="v$.foodRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.otherRevenueTax')"
              for="reservation-summary-otherRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="otherRevenueTax"
              id="reservation-summary-otherRevenueTax"
              data-cy="otherRevenueTax"
              :class="{ valid: !v$.otherRevenueTax.$invalid, invalid: v$.otherRevenueTax.$invalid }"
              v-model.number="v$.otherRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.totalRevenueTax')"
              for="reservation-summary-totalRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="totalRevenueTax"
              id="reservation-summary-totalRevenueTax"
              data-cy="totalRevenueTax"
              :class="{ valid: !v$.totalRevenueTax.$invalid, invalid: v$.totalRevenueTax.$invalid }"
              v-model.number="v$.totalRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.nonRevenueTax')"
              for="reservation-summary-nonRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="nonRevenueTax"
              id="reservation-summary-nonRevenueTax"
              data-cy="nonRevenueTax"
              :class="{ valid: !v$.nonRevenueTax.$invalid, invalid: v$.nonRevenueTax.$invalid }"
              v-model.number="v$.nonRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.city')"
              for="reservation-summary-city"
            ></label>
            <input
              type="text"
              class="form-control"
              name="city"
              id="reservation-summary-city"
              data-cy="city"
              :class="{ valid: !v$.city.$invalid, invalid: v$.city.$invalid }"
              v-model="v$.city.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.zipCode')"
              for="reservation-summary-zipCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="zipCode"
              id="reservation-summary-zipCode"
              data-cy="zipCode"
              :class="{ valid: !v$.zipCode.$invalid, invalid: v$.zipCode.$invalid }"
              v-model="v$.zipCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.district')"
              for="reservation-summary-district"
            ></label>
            <input
              type="text"
              class="form-control"
              name="district"
              id="reservation-summary-district"
              data-cy="district"
              :class="{ valid: !v$.district.$invalid, invalid: v$.district.$invalid }"
              v-model="v$.district.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.state')"
              for="reservation-summary-state"
            ></label>
            <input
              type="text"
              class="form-control"
              name="state"
              id="reservation-summary-state"
              data-cy="state"
              :class="{ valid: !v$.state.$invalid, invalid: v$.state.$invalid }"
              v-model="v$.state.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.children1')"
              for="reservation-summary-children1"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children1"
              id="reservation-summary-children1"
              data-cy="children1"
              :class="{ valid: !v$.children1.$invalid, invalid: v$.children1.$invalid }"
              v-model.number="v$.children1.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.children2')"
              for="reservation-summary-children2"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children2"
              id="reservation-summary-children2"
              data-cy="children2"
              :class="{ valid: !v$.children2.$invalid, invalid: v$.children2.$invalid }"
              v-model.number="v$.children2.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.children3')"
              for="reservation-summary-children3"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children3"
              id="reservation-summary-children3"
              data-cy="children3"
              :class="{ valid: !v$.children3.$invalid, invalid: v$.children3.$invalid }"
              v-model.number="v$.children3.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.children4')"
              for="reservation-summary-children4"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children4"
              id="reservation-summary-children4"
              data-cy="children4"
              :class="{ valid: !v$.children4.$invalid, invalid: v$.children4.$invalid }"
              v-model.number="v$.children4.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.children5')"
              for="reservation-summary-children5"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children5"
              id="reservation-summary-children5"
              data-cy="children5"
              :class="{ valid: !v$.children5.$invalid, invalid: v$.children5.$invalid }"
              v-model.number="v$.children5.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.ownerFfFlag')"
              for="reservation-summary-ownerFfFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ownerFfFlag"
              id="reservation-summary-ownerFfFlag"
              data-cy="ownerFfFlag"
              :class="{ valid: !v$.ownerFfFlag.$invalid, invalid: v$.ownerFfFlag.$invalid }"
              v-model="v$.ownerFfFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.ownerRentalFlag')"
              for="reservation-summary-ownerRentalFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ownerRentalFlag"
              id="reservation-summary-ownerRentalFlag"
              data-cy="ownerRentalFlag"
              :class="{ valid: !v$.ownerRentalFlag.$invalid, invalid: v$.ownerRentalFlag.$invalid }"
              v-model="v$.ownerRentalFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcGrossRate')"
              for="reservation-summary-fcGrossRate"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcGrossRate"
              id="reservation-summary-fcGrossRate"
              data-cy="fcGrossRate"
              :class="{ valid: !v$.fcGrossRate.$invalid, invalid: v$.fcGrossRate.$invalid }"
              v-model.number="v$.fcGrossRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcNetRoomRevenue')"
              for="reservation-summary-fcNetRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcNetRoomRevenue"
              id="reservation-summary-fcNetRoomRevenue"
              data-cy="fcNetRoomRevenue"
              :class="{ valid: !v$.fcNetRoomRevenue.$invalid, invalid: v$.fcNetRoomRevenue.$invalid }"
              v-model.number="v$.fcNetRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcExtraRevenue')"
              for="reservation-summary-fcExtraRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcExtraRevenue"
              id="reservation-summary-fcExtraRevenue"
              data-cy="fcExtraRevenue"
              :class="{ valid: !v$.fcExtraRevenue.$invalid, invalid: v$.fcExtraRevenue.$invalid }"
              v-model.number="v$.fcExtraRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcRoomRevenue')"
              for="reservation-summary-fcRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcRoomRevenue"
              id="reservation-summary-fcRoomRevenue"
              data-cy="fcRoomRevenue"
              :class="{ valid: !v$.fcRoomRevenue.$invalid, invalid: v$.fcRoomRevenue.$invalid }"
              v-model.number="v$.fcRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcFoodRevenue')"
              for="reservation-summary-fcFoodRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcFoodRevenue"
              id="reservation-summary-fcFoodRevenue"
              data-cy="fcFoodRevenue"
              :class="{ valid: !v$.fcFoodRevenue.$invalid, invalid: v$.fcFoodRevenue.$invalid }"
              v-model.number="v$.fcFoodRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcOtherRevenue')"
              for="reservation-summary-fcOtherRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcOtherRevenue"
              id="reservation-summary-fcOtherRevenue"
              data-cy="fcOtherRevenue"
              :class="{ valid: !v$.fcOtherRevenue.$invalid, invalid: v$.fcOtherRevenue.$invalid }"
              v-model.number="v$.fcOtherRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcTotalRevenue')"
              for="reservation-summary-fcTotalRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcTotalRevenue"
              id="reservation-summary-fcTotalRevenue"
              data-cy="fcTotalRevenue"
              :class="{ valid: !v$.fcTotalRevenue.$invalid, invalid: v$.fcTotalRevenue.$invalid }"
              v-model.number="v$.fcTotalRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcNonRevenue')"
              for="reservation-summary-fcNonRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcNonRevenue"
              id="reservation-summary-fcNonRevenue"
              data-cy="fcNonRevenue"
              :class="{ valid: !v$.fcNonRevenue.$invalid, invalid: v$.fcNonRevenue.$invalid }"
              v-model.number="v$.fcNonRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcRoomRevenueTax')"
              for="reservation-summary-fcRoomRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcRoomRevenueTax"
              id="reservation-summary-fcRoomRevenueTax"
              data-cy="fcRoomRevenueTax"
              :class="{ valid: !v$.fcRoomRevenueTax.$invalid, invalid: v$.fcRoomRevenueTax.$invalid }"
              v-model.number="v$.fcRoomRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcFoodRevenueTax')"
              for="reservation-summary-fcFoodRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcFoodRevenueTax"
              id="reservation-summary-fcFoodRevenueTax"
              data-cy="fcFoodRevenueTax"
              :class="{ valid: !v$.fcFoodRevenueTax.$invalid, invalid: v$.fcFoodRevenueTax.$invalid }"
              v-model.number="v$.fcFoodRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcOtherRevenueTax')"
              for="reservation-summary-fcOtherRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcOtherRevenueTax"
              id="reservation-summary-fcOtherRevenueTax"
              data-cy="fcOtherRevenueTax"
              :class="{ valid: !v$.fcOtherRevenueTax.$invalid, invalid: v$.fcOtherRevenueTax.$invalid }"
              v-model.number="v$.fcOtherRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcTotalRevenueTax')"
              for="reservation-summary-fcTotalRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcTotalRevenueTax"
              id="reservation-summary-fcTotalRevenueTax"
              data-cy="fcTotalRevenueTax"
              :class="{ valid: !v$.fcTotalRevenueTax.$invalid, invalid: v$.fcTotalRevenueTax.$invalid }"
              v-model.number="v$.fcTotalRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.fcNonRevenueTax')"
              for="reservation-summary-fcNonRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fcNonRevenueTax"
              id="reservation-summary-fcNonRevenueTax"
              data-cy="fcNonRevenueTax"
              :class="{ valid: !v$.fcNonRevenueTax.$invalid, invalid: v$.fcNonRevenueTax.$invalid }"
              v-model.number="v$.fcNonRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.currencyCode')"
              for="reservation-summary-currencyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="currencyCode"
              id="reservation-summary-currencyCode"
              data-cy="currencyCode"
              :class="{ valid: !v$.currencyCode.$invalid, invalid: v$.currencyCode.$invalid }"
              v-model="v$.currencyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.exchangeDate')"
              for="reservation-summary-exchangeDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-summary-exchangeDate"
                  v-model="v$.exchangeDate.$model"
                  name="exchangeDate"
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
                id="reservation-summary-exchangeDate"
                data-cy="exchangeDate"
                type="text"
                class="form-control"
                name="exchangeDate"
                :class="{ valid: !v$.exchangeDate.$invalid, invalid: v$.exchangeDate.$invalid }"
                v-model="v$.exchangeDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.updateBusinessDate')"
              for="reservation-summary-updateBusinessDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-summary-updateBusinessDate"
                  v-model="v$.updateBusinessDate.$model"
                  name="updateBusinessDate"
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
                id="reservation-summary-updateBusinessDate"
                data-cy="updateBusinessDate"
                type="text"
                class="form-control"
                name="updateBusinessDate"
                :class="{ valid: !v$.updateBusinessDate.$invalid, invalid: v$.updateBusinessDate.$invalid }"
                v-model="v$.updateBusinessDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.updateDate')"
              for="reservation-summary-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-summary-updateDate"
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
                id="reservation-summary-updateDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationSummary.centralCurrencyCode')"
              for="reservation-summary-centralCurrencyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="centralCurrencyCode"
              id="reservation-summary-centralCurrencyCode"
              data-cy="centralCurrencyCode"
              :class="{ valid: !v$.centralCurrencyCode.$invalid, invalid: v$.centralCurrencyCode.$invalid }"
              v-model="v$.centralCurrencyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.centralExchangeRate')"
              for="reservation-summary-centralExchangeRate"
            ></label>
            <input
              type="number"
              class="form-control"
              name="centralExchangeRate"
              id="reservation-summary-centralExchangeRate"
              data-cy="centralExchangeRate"
              :class="{ valid: !v$.centralExchangeRate.$invalid, invalid: v$.centralExchangeRate.$invalid }"
              v-model.number="v$.centralExchangeRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.truncBeginDate')"
              for="reservation-summary-truncBeginDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-summary-truncBeginDate"
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
                id="reservation-summary-truncBeginDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationSummary.truncEndDate')"
              for="reservation-summary-truncEndDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-summary-truncEndDate"
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
                id="reservation-summary-truncEndDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationSummary.businessDateCreated')"
              for="reservation-summary-businessDateCreated"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-summary-businessDateCreated"
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
                id="reservation-summary-businessDateCreated"
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
              v-text="t$('operaHandlerApplicationApp.reservationSummary.resInsertSource')"
              for="reservation-summary-resInsertSource"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resInsertSource"
              id="reservation-summary-resInsertSource"
              data-cy="resInsertSource"
              :class="{ valid: !v$.resInsertSource.$invalid, invalid: v$.resInsertSource.$invalid }"
              v-model="v$.resInsertSource.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.parentCompanyId')"
              for="reservation-summary-parentCompanyId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="parentCompanyId"
              id="reservation-summary-parentCompanyId"
              data-cy="parentCompanyId"
              :class="{ valid: !v$.parentCompanyId.$invalid, invalid: v$.parentCompanyId.$invalid }"
              v-model.number="v$.parentCompanyId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.agentId')"
              for="reservation-summary-agentId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="agentId"
              id="reservation-summary-agentId"
              data-cy="agentId"
              :class="{ valid: !v$.agentId.$invalid, invalid: v$.agentId.$invalid }"
              v-model.number="v$.agentId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.gender')"
              for="reservation-summary-gender"
            ></label>
            <input
              type="text"
              class="form-control"
              name="gender"
              id="reservation-summary-gender"
              data-cy="gender"
              :class="{ valid: !v$.gender.$invalid, invalid: v$.gender.$invalid }"
              v-model="v$.gender.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.vipStatus')"
              for="reservation-summary-vipStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="vipStatus"
              id="reservation-summary-vipStatus"
              data-cy="vipStatus"
              :class="{ valid: !v$.vipStatus.$invalid, invalid: v$.vipStatus.$invalid }"
              v-model="v$.vipStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.quantity')"
              for="reservation-summary-quantity"
            ></label>
            <input
              type="number"
              class="form-control"
              name="quantity"
              id="reservation-summary-quantity"
              data-cy="quantity"
              :class="{ valid: !v$.quantity.$invalid, invalid: v$.quantity.$invalid }"
              v-model.number="v$.quantity.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.turndownStatus')"
              for="reservation-summary-turndownStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="turndownStatus"
              id="reservation-summary-turndownStatus"
              data-cy="turndownStatus"
              :class="{ valid: !v$.turndownStatus.$invalid, invalid: v$.turndownStatus.$invalid }"
              v-model="v$.turndownStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.bookedRoomCategory')"
              for="reservation-summary-bookedRoomCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="bookedRoomCategory"
              id="reservation-summary-bookedRoomCategory"
              data-cy="bookedRoomCategory"
              :class="{ valid: !v$.bookedRoomCategory.$invalid, invalid: v$.bookedRoomCategory.$invalid }"
              v-model="v$.bookedRoomCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationSummary.sourceProfId')"
              for="reservation-summary-sourceProfId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="sourceProfId"
              id="reservation-summary-sourceProfId"
              data-cy="sourceProfId"
              :class="{ valid: !v$.sourceProfId.$invalid, invalid: v$.sourceProfId.$invalid }"
              v-model.number="v$.sourceProfId.$model"
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
<script lang="ts" src="./reservation-summary-update.component.ts"></script>
