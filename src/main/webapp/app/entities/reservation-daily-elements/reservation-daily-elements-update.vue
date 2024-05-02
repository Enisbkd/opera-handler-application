<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.reservationDailyElements.home.createOrEditLabel"
          data-cy="ReservationDailyElementsCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.reservationDailyElements.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="reservationDailyElements.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="reservationDailyElements.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.resort')"
              for="reservation-daily-elements-resort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resort"
              id="reservation-daily-elements-resort"
              data-cy="resort"
              :class="{ valid: !v$.resort.$invalid, invalid: v$.resort.$invalid }"
              v-model="v$.resort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.reservationDate')"
              for="reservation-daily-elements-reservationDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-daily-elements-reservationDate"
                  v-model="v$.reservationDate.$model"
                  name="reservationDate"
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
                id="reservation-daily-elements-reservationDate"
                data-cy="reservationDate"
                type="text"
                class="form-control"
                name="reservationDate"
                :class="{ valid: !v$.reservationDate.$invalid, invalid: v$.reservationDate.$invalid }"
                v-model="v$.reservationDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.resvDailyElSeq')"
              for="reservation-daily-elements-resvDailyElSeq"
            ></label>
            <input
              type="number"
              class="form-control"
              name="resvDailyElSeq"
              id="reservation-daily-elements-resvDailyElSeq"
              data-cy="resvDailyElSeq"
              :class="{ valid: !v$.resvDailyElSeq.$invalid, invalid: v$.resvDailyElSeq.$invalid }"
              v-model.number="v$.resvDailyElSeq.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.resvStatus')"
              for="reservation-daily-elements-resvStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resvStatus"
              id="reservation-daily-elements-resvStatus"
              data-cy="resvStatus"
              :class="{ valid: !v$.resvStatus.$invalid, invalid: v$.resvStatus.$invalid }"
              v-model="v$.resvStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.externalReference')"
              for="reservation-daily-elements-externalReference"
            ></label>
            <input
              type="text"
              class="form-control"
              name="externalReference"
              id="reservation-daily-elements-externalReference"
              data-cy="externalReference"
              :class="{ valid: !v$.externalReference.$invalid, invalid: v$.externalReference.$invalid }"
              v-model="v$.externalReference.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomClass')"
              for="reservation-daily-elements-roomClass"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomClass"
              id="reservation-daily-elements-roomClass"
              data-cy="roomClass"
              :class="{ valid: !v$.roomClass.$invalid, invalid: v$.roomClass.$invalid }"
              v-model="v$.roomClass.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomCategory')"
              for="reservation-daily-elements-roomCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomCategory"
              id="reservation-daily-elements-roomCategory"
              data-cy="roomCategory"
              :class="{ valid: !v$.roomCategory.$invalid, invalid: v$.roomCategory.$invalid }"
              v-model="v$.roomCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.bookedRoomCategory')"
              for="reservation-daily-elements-bookedRoomCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="bookedRoomCategory"
              id="reservation-daily-elements-bookedRoomCategory"
              data-cy="bookedRoomCategory"
              :class="{ valid: !v$.bookedRoomCategory.$invalid, invalid: v$.bookedRoomCategory.$invalid }"
              v-model="v$.bookedRoomCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.room')"
              for="reservation-daily-elements-room"
            ></label>
            <input
              type="text"
              class="form-control"
              name="room"
              id="reservation-daily-elements-room"
              data-cy="room"
              :class="{ valid: !v$.room.$invalid, invalid: v$.room.$invalid }"
              v-model="v$.room.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationNo')"
              for="reservation-daily-elements-cancellationNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cancellationNo"
              id="reservation-daily-elements-cancellationNo"
              data-cy="cancellationNo"
              :class="{ valid: !v$.cancellationNo.$invalid, invalid: v$.cancellationNo.$invalid }"
              v-model.number="v$.cancellationNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationDate')"
              for="reservation-daily-elements-cancellationDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-daily-elements-cancellationDate"
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
                id="reservation-daily-elements-cancellationDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationCode')"
              for="reservation-daily-elements-cancellationCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cancellationCode"
              id="reservation-daily-elements-cancellationCode"
              data-cy="cancellationCode"
              :class="{ valid: !v$.cancellationCode.$invalid, invalid: v$.cancellationCode.$invalid }"
              v-model="v$.cancellationCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationReasonDesc')"
              for="reservation-daily-elements-cancellationReasonDesc"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cancellationReasonDesc"
              id="reservation-daily-elements-cancellationReasonDesc"
              data-cy="cancellationReasonDesc"
              :class="{ valid: !v$.cancellationReasonDesc.$invalid, invalid: v$.cancellationReasonDesc.$invalid }"
              v-model="v$.cancellationReasonDesc.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.guaranteeCode')"
              for="reservation-daily-elements-guaranteeCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guaranteeCode"
              id="reservation-daily-elements-guaranteeCode"
              data-cy="guaranteeCode"
              :class="{ valid: !v$.guaranteeCode.$invalid, invalid: v$.guaranteeCode.$invalid }"
              v-model="v$.guaranteeCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.marketCode')"
              for="reservation-daily-elements-marketCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="marketCode"
              id="reservation-daily-elements-marketCode"
              data-cy="marketCode"
              :class="{ valid: !v$.marketCode.$invalid, invalid: v$.marketCode.$invalid }"
              v-model="v$.marketCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.originOfBooking')"
              for="reservation-daily-elements-originOfBooking"
            ></label>
            <input
              type="text"
              class="form-control"
              name="originOfBooking"
              id="reservation-daily-elements-originOfBooking"
              data-cy="originOfBooking"
              :class="{ valid: !v$.originOfBooking.$invalid, invalid: v$.originOfBooking.$invalid }"
              v-model="v$.originOfBooking.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.exchangeRate')"
              for="reservation-daily-elements-exchangeRate"
            ></label>
            <input
              type="number"
              class="form-control"
              name="exchangeRate"
              id="reservation-daily-elements-exchangeRate"
              data-cy="exchangeRate"
              :class="{ valid: !v$.exchangeRate.$invalid, invalid: v$.exchangeRate.$invalid }"
              v-model.number="v$.exchangeRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.originalBaseRate')"
              for="reservation-daily-elements-originalBaseRate"
            ></label>
            <input
              type="number"
              class="form-control"
              name="originalBaseRate"
              id="reservation-daily-elements-originalBaseRate"
              data-cy="originalBaseRate"
              :class="{ valid: !v$.originalBaseRate.$invalid, invalid: v$.originalBaseRate.$invalid }"
              v-model.number="v$.originalBaseRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.baseRateAmount')"
              for="reservation-daily-elements-baseRateAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="baseRateAmount"
              id="reservation-daily-elements-baseRateAmount"
              data-cy="baseRateAmount"
              :class="{ valid: !v$.baseRateAmount.$invalid, invalid: v$.baseRateAmount.$invalid }"
              v-model.number="v$.baseRateAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.rateAmount')"
              for="reservation-daily-elements-rateAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rateAmount"
              id="reservation-daily-elements-rateAmount"
              data-cy="rateAmount"
              :class="{ valid: !v$.rateAmount.$invalid, invalid: v$.rateAmount.$invalid }"
              v-model.number="v$.rateAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomCost')"
              for="reservation-daily-elements-roomCost"
            ></label>
            <input
              type="number"
              class="form-control"
              name="roomCost"
              id="reservation-daily-elements-roomCost"
              data-cy="roomCost"
              :class="{ valid: !v$.roomCost.$invalid, invalid: v$.roomCost.$invalid }"
              v-model.number="v$.roomCost.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.quantity')"
              for="reservation-daily-elements-quantity"
            ></label>
            <input
              type="number"
              class="form-control"
              name="quantity"
              id="reservation-daily-elements-quantity"
              data-cy="quantity"
              :class="{ valid: !v$.quantity.$invalid, invalid: v$.quantity.$invalid }"
              v-model.number="v$.quantity.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.adults')"
              for="reservation-daily-elements-adults"
            ></label>
            <input
              type="number"
              class="form-control"
              name="adults"
              id="reservation-daily-elements-adults"
              data-cy="adults"
              :class="{ valid: !v$.adults.$invalid, invalid: v$.adults.$invalid }"
              v-model.number="v$.adults.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.children')"
              for="reservation-daily-elements-children"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children"
              id="reservation-daily-elements-children"
              data-cy="children"
              :class="{ valid: !v$.children.$invalid, invalid: v$.children.$invalid }"
              v-model.number="v$.children.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.physicalQuantity')"
              for="reservation-daily-elements-physicalQuantity"
            ></label>
            <input
              type="number"
              class="form-control"
              name="physicalQuantity"
              id="reservation-daily-elements-physicalQuantity"
              data-cy="physicalQuantity"
              :class="{ valid: !v$.physicalQuantity.$invalid, invalid: v$.physicalQuantity.$invalid }"
              v-model.number="v$.physicalQuantity.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.allotmentHeaderId')"
              for="reservation-daily-elements-allotmentHeaderId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="allotmentHeaderId"
              id="reservation-daily-elements-allotmentHeaderId"
              data-cy="allotmentHeaderId"
              :class="{ valid: !v$.allotmentHeaderId.$invalid, invalid: v$.allotmentHeaderId.$invalid }"
              v-model.number="v$.allotmentHeaderId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.dayUseYn')"
              for="reservation-daily-elements-dayUseYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dayUseYn"
              id="reservation-daily-elements-dayUseYn"
              data-cy="dayUseYn"
              :class="{ valid: !v$.dayUseYn.$invalid, invalid: v$.dayUseYn.$invalid }"
              v-model="v$.dayUseYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.dueOutYn')"
              for="reservation-daily-elements-dueOutYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dueOutYn"
              id="reservation-daily-elements-dueOutYn"
              data-cy="dueOutYn"
              :class="{ valid: !v$.dueOutYn.$invalid, invalid: v$.dueOutYn.$invalid }"
              v-model="v$.dueOutYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.insertUser')"
              for="reservation-daily-elements-insertUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="reservation-daily-elements-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.insertDate')"
              for="reservation-daily-elements-insertDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-daily-elements-insertDate"
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
                id="reservation-daily-elements-insertDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.updateUser')"
              for="reservation-daily-elements-updateUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="reservation-daily-elements-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.updateDate')"
              for="reservation-daily-elements-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-daily-elements-updateDate"
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
                id="reservation-daily-elements-updateDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.insertActionInstanceId')"
              for="reservation-daily-elements-insertActionInstanceId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertActionInstanceId"
              id="reservation-daily-elements-insertActionInstanceId"
              data-cy="insertActionInstanceId"
              :class="{ valid: !v$.insertActionInstanceId.$invalid, invalid: v$.insertActionInstanceId.$invalid }"
              v-model.number="v$.insertActionInstanceId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.dmlSeqNo')"
              for="reservation-daily-elements-dmlSeqNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="dmlSeqNo"
              id="reservation-daily-elements-dmlSeqNo"
              data-cy="dmlSeqNo"
              :class="{ valid: !v$.dmlSeqNo.$invalid, invalid: v$.dmlSeqNo.$invalid }"
              v-model.number="v$.dmlSeqNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.extSeqNo')"
              for="reservation-daily-elements-extSeqNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="extSeqNo"
              id="reservation-daily-elements-extSeqNo"
              data-cy="extSeqNo"
              :class="{ valid: !v$.extSeqNo.$invalid, invalid: v$.extSeqNo.$invalid }"
              v-model.number="v$.extSeqNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.extSegNo')"
              for="reservation-daily-elements-extSegNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="extSegNo"
              id="reservation-daily-elements-extSegNo"
              data-cy="extSegNo"
              :class="{ valid: !v$.extSegNo.$invalid, invalid: v$.extSegNo.$invalid }"
              v-model.number="v$.extSegNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cribs')"
              for="reservation-daily-elements-cribs"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cribs"
              id="reservation-daily-elements-cribs"
              data-cy="cribs"
              :class="{ valid: !v$.cribs.$invalid, invalid: v$.cribs.$invalid }"
              v-model.number="v$.cribs.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.extraBeds')"
              for="reservation-daily-elements-extraBeds"
            ></label>
            <input
              type="number"
              class="form-control"
              name="extraBeds"
              id="reservation-daily-elements-extraBeds"
              data-cy="extraBeds"
              :class="{ valid: !v$.extraBeds.$invalid, invalid: v$.extraBeds.$invalid }"
              v-model.number="v$.extraBeds.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.allotmentRecordType')"
              for="reservation-daily-elements-allotmentRecordType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="allotmentRecordType"
              id="reservation-daily-elements-allotmentRecordType"
              data-cy="allotmentRecordType"
              :class="{ valid: !v$.allotmentRecordType.$invalid, invalid: v$.allotmentRecordType.$invalid }"
              v-model="v$.allotmentRecordType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.blockResort')"
              for="reservation-daily-elements-blockResort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="blockResort"
              id="reservation-daily-elements-blockResort"
              data-cy="blockResort"
              :class="{ valid: !v$.blockResort.$invalid, invalid: v$.blockResort.$invalid }"
              v-model="v$.blockResort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.blockId')"
              for="reservation-daily-elements-blockId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="blockId"
              id="reservation-daily-elements-blockId"
              data-cy="blockId"
              :class="{ valid: !v$.blockId.$invalid, invalid: v$.blockId.$invalid }"
              v-model.number="v$.blockId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.turndownStatus')"
              for="reservation-daily-elements-turndownStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="turndownStatus"
              id="reservation-daily-elements-turndownStatus"
              data-cy="turndownStatus"
              :class="{ valid: !v$.turndownStatus.$invalid, invalid: v$.turndownStatus.$invalid }"
              v-model="v$.turndownStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.awdUpgrFrom')"
              for="reservation-daily-elements-awdUpgrFrom"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awdUpgrFrom"
              id="reservation-daily-elements-awdUpgrFrom"
              data-cy="awdUpgrFrom"
              :class="{ valid: !v$.awdUpgrFrom.$invalid, invalid: v$.awdUpgrFrom.$invalid }"
              v-model="v$.awdUpgrFrom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.awdUpgrTo')"
              for="reservation-daily-elements-awdUpgrTo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awdUpgrTo"
              id="reservation-daily-elements-awdUpgrTo"
              data-cy="awdUpgrTo"
              :class="{ valid: !v$.awdUpgrTo.$invalid, invalid: v$.awdUpgrTo.$invalid }"
              v-model="v$.awdUpgrTo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.hkExpectedServiceTime')"
              for="reservation-daily-elements-hkExpectedServiceTime"
            ></label>
            <input
              type="text"
              class="form-control"
              name="hkExpectedServiceTime"
              id="reservation-daily-elements-hkExpectedServiceTime"
              data-cy="hkExpectedServiceTime"
              :class="{ valid: !v$.hkExpectedServiceTime.$invalid, invalid: v$.hkExpectedServiceTime.$invalid }"
              v-model="v$.hkExpectedServiceTime.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomInstructions')"
              for="reservation-daily-elements-roomInstructions"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomInstructions"
              id="reservation-daily-elements-roomInstructions"
              data-cy="roomInstructions"
              :class="{ valid: !v$.roomInstructions.$invalid, invalid: v$.roomInstructions.$invalid }"
              v-model="v$.roomInstructions.$model"
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
<script lang="ts" src="./reservation-daily-elements-update.component.ts"></script>
