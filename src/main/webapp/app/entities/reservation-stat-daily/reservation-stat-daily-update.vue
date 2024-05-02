<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.reservationStatDaily.home.createOrEditLabel"
          data-cy="ReservationStatDailyCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.reservationStatDaily.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="reservationStatDaily.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="reservationStatDaily.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resort')"
              for="reservation-stat-daily-resort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resort"
              id="reservation-stat-daily-resort"
              data-cy="resort"
              :class="{ valid: !v$.resort.$invalid, invalid: v$.resort.$invalid }"
              v-model="v$.resort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.businessDate')"
              for="reservation-stat-daily-businessDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-stat-daily-businessDate"
                  v-model="v$.businessDate.$model"
                  name="businessDate"
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
                id="reservation-stat-daily-businessDate"
                data-cy="businessDate"
                type="text"
                class="form-control"
                name="businessDate"
                :class="{ valid: !v$.businessDate.$invalid, invalid: v$.businessDate.$invalid }"
                v-model="v$.businessDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nameId')"
              for="reservation-stat-daily-nameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="nameId"
              id="reservation-stat-daily-nameId"
              data-cy="nameId"
              :class="{ valid: !v$.nameId.$invalid, invalid: v$.nameId.$invalid }"
              v-model.number="v$.nameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rateCode')"
              for="reservation-stat-daily-rateCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rateCode"
              id="reservation-stat-daily-rateCode"
              data-cy="rateCode"
              :class="{ valid: !v$.rateCode.$invalid, invalid: v$.rateCode.$invalid }"
              v-model="v$.rateCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.sourceCode')"
              for="reservation-stat-daily-sourceCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sourceCode"
              id="reservation-stat-daily-sourceCode"
              data-cy="sourceCode"
              :class="{ valid: !v$.sourceCode.$invalid, invalid: v$.sourceCode.$invalid }"
              v-model="v$.sourceCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.marketCode')"
              for="reservation-stat-daily-marketCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="marketCode"
              id="reservation-stat-daily-marketCode"
              data-cy="marketCode"
              :class="{ valid: !v$.marketCode.$invalid, invalid: v$.marketCode.$invalid }"
              v-model="v$.marketCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomCategory')"
              for="reservation-stat-daily-roomCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomCategory"
              id="reservation-stat-daily-roomCategory"
              data-cy="roomCategory"
              :class="{ valid: !v$.roomCategory.$invalid, invalid: v$.roomCategory.$invalid }"
              v-model="v$.roomCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.companyId')"
              for="reservation-stat-daily-companyId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="companyId"
              id="reservation-stat-daily-companyId"
              data-cy="companyId"
              :class="{ valid: !v$.companyId.$invalid, invalid: v$.companyId.$invalid }"
              v-model.number="v$.companyId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.agentId')"
              for="reservation-stat-daily-agentId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="agentId"
              id="reservation-stat-daily-agentId"
              data-cy="agentId"
              :class="{ valid: !v$.agentId.$invalid, invalid: v$.agentId.$invalid }"
              v-model.number="v$.agentId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.groupId')"
              for="reservation-stat-daily-groupId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="groupId"
              id="reservation-stat-daily-groupId"
              data-cy="groupId"
              :class="{ valid: !v$.groupId.$invalid, invalid: v$.groupId.$invalid }"
              v-model.number="v$.groupId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.sourceProfId')"
              for="reservation-stat-daily-sourceProfId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="sourceProfId"
              id="reservation-stat-daily-sourceProfId"
              data-cy="sourceProfId"
              :class="{ valid: !v$.sourceProfId.$invalid, invalid: v$.sourceProfId.$invalid }"
              v-model.number="v$.sourceProfId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resvStatus')"
              for="reservation-stat-daily-resvStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resvStatus"
              id="reservation-stat-daily-resvStatus"
              data-cy="resvStatus"
              :class="{ valid: !v$.resvStatus.$invalid, invalid: v$.resvStatus.$invalid }"
              v-model="v$.resvStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.truncBeginDate')"
              for="reservation-stat-daily-truncBeginDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-stat-daily-truncBeginDate"
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
                id="reservation-stat-daily-truncBeginDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.truncEndDate')"
              for="reservation-stat-daily-truncEndDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-stat-daily-truncEndDate"
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
                id="reservation-stat-daily-truncEndDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resvNameId')"
              for="reservation-stat-daily-resvNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="resvNameId"
              id="reservation-stat-daily-resvNameId"
              data-cy="resvNameId"
              :class="{ valid: !v$.resvNameId.$invalid, invalid: v$.resvNameId.$invalid }"
              v-model.number="v$.resvNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.quantity')"
              for="reservation-stat-daily-quantity"
            ></label>
            <input
              type="number"
              class="form-control"
              name="quantity"
              id="reservation-stat-daily-quantity"
              data-cy="quantity"
              :class="{ valid: !v$.quantity.$invalid, invalid: v$.quantity.$invalid }"
              v-model.number="v$.quantity.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.physicalQuantity')"
              for="reservation-stat-daily-physicalQuantity"
            ></label>
            <input
              type="number"
              class="form-control"
              name="physicalQuantity"
              id="reservation-stat-daily-physicalQuantity"
              data-cy="physicalQuantity"
              :class="{ valid: !v$.physicalQuantity.$invalid, invalid: v$.physicalQuantity.$invalid }"
              v-model.number="v$.physicalQuantity.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dueOutYn')"
              for="reservation-stat-daily-dueOutYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dueOutYn"
              id="reservation-stat-daily-dueOutYn"
              data-cy="dueOutYn"
              :class="{ valid: !v$.dueOutYn.$invalid, invalid: v$.dueOutYn.$invalid }"
              v-model="v$.dueOutYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomResvStatus')"
              for="reservation-stat-daily-roomResvStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomResvStatus"
              id="reservation-stat-daily-roomResvStatus"
              data-cy="roomResvStatus"
              :class="{ valid: !v$.roomResvStatus.$invalid, invalid: v$.roomResvStatus.$invalid }"
              v-model="v$.roomResvStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.adults')"
              for="reservation-stat-daily-adults"
            ></label>
            <input
              type="number"
              class="form-control"
              name="adults"
              id="reservation-stat-daily-adults"
              data-cy="adults"
              :class="{ valid: !v$.adults.$invalid, invalid: v$.adults.$invalid }"
              v-model.number="v$.adults.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children')"
              for="reservation-stat-daily-children"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children"
              id="reservation-stat-daily-children"
              data-cy="children"
              :class="{ valid: !v$.children.$invalid, invalid: v$.children.$invalid }"
              v-model.number="v$.children.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomAdults')"
              for="reservation-stat-daily-roomAdults"
            ></label>
            <input
              type="number"
              class="form-control"
              name="roomAdults"
              id="reservation-stat-daily-roomAdults"
              data-cy="roomAdults"
              :class="{ valid: !v$.roomAdults.$invalid, invalid: v$.roomAdults.$invalid }"
              v-model.number="v$.roomAdults.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomChildren')"
              for="reservation-stat-daily-roomChildren"
            ></label>
            <input
              type="number"
              class="form-control"
              name="roomChildren"
              id="reservation-stat-daily-roomChildren"
              data-cy="roomChildren"
              :class="{ valid: !v$.roomChildren.$invalid, invalid: v$.roomChildren.$invalid }"
              v-model.number="v$.roomChildren.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.primaryYn')"
              for="reservation-stat-daily-primaryYn"
            ></label>
            <input
              type="number"
              class="form-control"
              name="primaryYn"
              id="reservation-stat-daily-primaryYn"
              data-cy="primaryYn"
              :class="{ valid: !v$.primaryYn.$invalid, invalid: v$.primaryYn.$invalid }"
              v-model.number="v$.primaryYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.allotmentHeaderId')"
              for="reservation-stat-daily-allotmentHeaderId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="allotmentHeaderId"
              id="reservation-stat-daily-allotmentHeaderId"
              data-cy="allotmentHeaderId"
              :class="{ valid: !v$.allotmentHeaderId.$invalid, invalid: v$.allotmentHeaderId.$invalid }"
              v-model.number="v$.allotmentHeaderId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomRevenue')"
              for="reservation-stat-daily-roomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="roomRevenue"
              id="reservation-stat-daily-roomRevenue"
              data-cy="roomRevenue"
              :class="{ valid: !v$.roomRevenue.$invalid, invalid: v$.roomRevenue.$invalid }"
              v-model.number="v$.roomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.foodRevenue')"
              for="reservation-stat-daily-foodRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="foodRevenue"
              id="reservation-stat-daily-foodRevenue"
              data-cy="foodRevenue"
              :class="{ valid: !v$.foodRevenue.$invalid, invalid: v$.foodRevenue.$invalid }"
              v-model.number="v$.foodRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageRoomRevenue')"
              for="reservation-stat-daily-packageRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="packageRoomRevenue"
              id="reservation-stat-daily-packageRoomRevenue"
              data-cy="packageRoomRevenue"
              :class="{ valid: !v$.packageRoomRevenue.$invalid, invalid: v$.packageRoomRevenue.$invalid }"
              v-model.number="v$.packageRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageFoodRevenue')"
              for="reservation-stat-daily-packageFoodRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="packageFoodRevenue"
              id="reservation-stat-daily-packageFoodRevenue"
              data-cy="packageFoodRevenue"
              :class="{ valid: !v$.packageFoodRevenue.$invalid, invalid: v$.packageFoodRevenue.$invalid }"
              v-model.number="v$.packageFoodRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalRoomTax')"
              for="reservation-stat-daily-totalRoomTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="totalRoomTax"
              id="reservation-stat-daily-totalRoomTax"
              data-cy="totalRoomTax"
              :class="{ valid: !v$.totalRoomTax.$invalid, invalid: v$.totalRoomTax.$invalid }"
              v-model.number="v$.totalRoomTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalFoodTax')"
              for="reservation-stat-daily-totalFoodTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="totalFoodTax"
              id="reservation-stat-daily-totalFoodTax"
              data-cy="totalFoodTax"
              :class="{ valid: !v$.totalFoodTax.$invalid, invalid: v$.totalFoodTax.$invalid }"
              v-model.number="v$.totalFoodTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalPackageRevenue')"
              for="reservation-stat-daily-totalPackageRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="totalPackageRevenue"
              id="reservation-stat-daily-totalPackageRevenue"
              data-cy="totalPackageRevenue"
              :class="{ valid: !v$.totalPackageRevenue.$invalid, invalid: v$.totalPackageRevenue.$invalid }"
              v-model.number="v$.totalPackageRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalRevenue')"
              for="reservation-stat-daily-totalRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="totalRevenue"
              id="reservation-stat-daily-totalRevenue"
              data-cy="totalRevenue"
              :class="{ valid: !v$.totalRevenue.$invalid, invalid: v$.totalRevenue.$invalid }"
              v-model.number="v$.totalRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalTax')"
              for="reservation-stat-daily-totalTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="totalTax"
              id="reservation-stat-daily-totalTax"
              data-cy="totalTax"
              :class="{ valid: !v$.totalTax.$invalid, invalid: v$.totalTax.$invalid }"
              v-model.number="v$.totalTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.insertDate')"
              for="reservation-stat-daily-insertDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-stat-daily-insertDate"
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
                id="reservation-stat-daily-insertDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.originalEndDate')"
              for="reservation-stat-daily-originalEndDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-stat-daily-originalEndDate"
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
                id="reservation-stat-daily-originalEndDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.walkinYn')"
              for="reservation-stat-daily-walkinYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="walkinYn"
              id="reservation-stat-daily-walkinYn"
              data-cy="walkinYn"
              :class="{ valid: !v$.walkinYn.$invalid, invalid: v$.walkinYn.$invalid }"
              v-model="v$.walkinYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationDate')"
              for="reservation-stat-daily-reservationDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-stat-daily-reservationDate"
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
                id="reservation-stat-daily-reservationDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomClass')"
              for="reservation-stat-daily-roomClass"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomClass"
              id="reservation-stat-daily-roomClass"
              data-cy="roomClass"
              :class="{ valid: !v$.roomClass.$invalid, invalid: v$.roomClass.$invalid }"
              v-model="v$.roomClass.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.vipStatus')"
              for="reservation-stat-daily-vipStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="vipStatus"
              id="reservation-stat-daily-vipStatus"
              data-cy="vipStatus"
              :class="{ valid: !v$.vipStatus.$invalid, invalid: v$.vipStatus.$invalid }"
              v-model="v$.vipStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancellationDate')"
              for="reservation-stat-daily-cancellationDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-stat-daily-cancellationDate"
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
                id="reservation-stat-daily-cancellationDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.birthDate')"
              for="reservation-stat-daily-birthDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-stat-daily-birthDate"
                  v-model="v$.birthDate.$model"
                  name="birthDate"
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
                id="reservation-stat-daily-birthDate"
                data-cy="birthDate"
                type="text"
                class="form-control"
                name="birthDate"
                :class="{ valid: !v$.birthDate.$invalid, invalid: v$.birthDate.$invalid }"
                v-model="v$.birthDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.room')"
              for="reservation-stat-daily-room"
            ></label>
            <input
              type="text"
              class="form-control"
              name="room"
              id="reservation-stat-daily-room"
              data-cy="room"
              :class="{ valid: !v$.room.$invalid, invalid: v$.room.$invalid }"
              v-model="v$.room.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.membershipId')"
              for="reservation-stat-daily-membershipId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="membershipId"
              id="reservation-stat-daily-membershipId"
              data-cy="membershipId"
              :class="{ valid: !v$.membershipId.$invalid, invalid: v$.membershipId.$invalid }"
              v-model.number="v$.membershipId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.contactId')"
              for="reservation-stat-daily-contactId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="contactId"
              id="reservation-stat-daily-contactId"
              data-cy="contactId"
              :class="{ valid: !v$.contactId.$invalid, invalid: v$.contactId.$invalid }"
              v-model.number="v$.contactId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rateCategory')"
              for="reservation-stat-daily-rateCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rateCategory"
              id="reservation-stat-daily-rateCategory"
              data-cy="rateCategory"
              :class="{ valid: !v$.rateCategory.$invalid, invalid: v$.rateCategory.$invalid }"
              v-model="v$.rateCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.marketMainGroup')"
              for="reservation-stat-daily-marketMainGroup"
            ></label>
            <input
              type="text"
              class="form-control"
              name="marketMainGroup"
              id="reservation-stat-daily-marketMainGroup"
              data-cy="marketMainGroup"
              :class="{ valid: !v$.marketMainGroup.$invalid, invalid: v$.marketMainGroup.$invalid }"
              v-model="v$.marketMainGroup.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.sourceMainGroup')"
              for="reservation-stat-daily-sourceMainGroup"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sourceMainGroup"
              id="reservation-stat-daily-sourceMainGroup"
              data-cy="sourceMainGroup"
              :class="{ valid: !v$.sourceMainGroup.$invalid, invalid: v$.sourceMainGroup.$invalid }"
              v-model="v$.sourceMainGroup.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.channel')"
              for="reservation-stat-daily-channel"
            ></label>
            <input
              type="text"
              class="form-control"
              name="channel"
              id="reservation-stat-daily-channel"
              data-cy="channel"
              :class="{ valid: !v$.channel.$invalid, invalid: v$.channel.$invalid }"
              v-model="v$.channel.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.country')"
              for="reservation-stat-daily-country"
            ></label>
            <input
              type="text"
              class="form-control"
              name="country"
              id="reservation-stat-daily-country"
              data-cy="country"
              :class="{ valid: !v$.country.$invalid, invalid: v$.country.$invalid }"
              v-model="v$.country.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.regionCode')"
              for="reservation-stat-daily-regionCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="regionCode"
              id="reservation-stat-daily-regionCode"
              data-cy="regionCode"
              :class="{ valid: !v$.regionCode.$invalid, invalid: v$.regionCode.$invalid }"
              v-model="v$.regionCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nationality')"
              for="reservation-stat-daily-nationality"
            ></label>
            <input
              type="text"
              class="form-control"
              name="nationality"
              id="reservation-stat-daily-nationality"
              data-cy="nationality"
              :class="{ valid: !v$.nationality.$invalid, invalid: v$.nationality.$invalid }"
              v-model="v$.nationality.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.psuedoRoomYn')"
              for="reservation-stat-daily-psuedoRoomYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="psuedoRoomYn"
              id="reservation-stat-daily-psuedoRoomYn"
              data-cy="psuedoRoomYn"
              :class="{ valid: !v$.psuedoRoomYn.$invalid, invalid: v$.psuedoRoomYn.$invalid }"
              v-model="v$.psuedoRoomYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.adultsTaxFree')"
              for="reservation-stat-daily-adultsTaxFree"
            ></label>
            <input
              type="number"
              class="form-control"
              name="adultsTaxFree"
              id="reservation-stat-daily-adultsTaxFree"
              data-cy="adultsTaxFree"
              :class="{ valid: !v$.adultsTaxFree.$invalid, invalid: v$.adultsTaxFree.$invalid }"
              v-model.number="v$.adultsTaxFree.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.childrenTaxFree')"
              for="reservation-stat-daily-childrenTaxFree"
            ></label>
            <input
              type="number"
              class="form-control"
              name="childrenTaxFree"
              id="reservation-stat-daily-childrenTaxFree"
              data-cy="childrenTaxFree"
              :class="{ valid: !v$.childrenTaxFree.$invalid, invalid: v$.childrenTaxFree.$invalid }"
              v-model.number="v$.childrenTaxFree.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayRooms')"
              for="reservation-stat-daily-stayRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="stayRooms"
              id="reservation-stat-daily-stayRooms"
              data-cy="stayRooms"
              :class="{ valid: !v$.stayRooms.$invalid, invalid: v$.stayRooms.$invalid }"
              v-model.number="v$.stayRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayPersons')"
              for="reservation-stat-daily-stayPersons"
            ></label>
            <input
              type="number"
              class="form-control"
              name="stayPersons"
              id="reservation-stat-daily-stayPersons"
              data-cy="stayPersons"
              :class="{ valid: !v$.stayPersons.$invalid, invalid: v$.stayPersons.$invalid }"
              v-model.number="v$.stayPersons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayAdults')"
              for="reservation-stat-daily-stayAdults"
            ></label>
            <input
              type="number"
              class="form-control"
              name="stayAdults"
              id="reservation-stat-daily-stayAdults"
              data-cy="stayAdults"
              :class="{ valid: !v$.stayAdults.$invalid, invalid: v$.stayAdults.$invalid }"
              v-model.number="v$.stayAdults.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayChildren')"
              for="reservation-stat-daily-stayChildren"
            ></label>
            <input
              type="number"
              class="form-control"
              name="stayChildren"
              id="reservation-stat-daily-stayChildren"
              data-cy="stayChildren"
              :class="{ valid: !v$.stayChildren.$invalid, invalid: v$.stayChildren.$invalid }"
              v-model.number="v$.stayChildren.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.arrRooms')"
              for="reservation-stat-daily-arrRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="arrRooms"
              id="reservation-stat-daily-arrRooms"
              data-cy="arrRooms"
              :class="{ valid: !v$.arrRooms.$invalid, invalid: v$.arrRooms.$invalid }"
              v-model.number="v$.arrRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.arrPersons')"
              for="reservation-stat-daily-arrPersons"
            ></label>
            <input
              type="number"
              class="form-control"
              name="arrPersons"
              id="reservation-stat-daily-arrPersons"
              data-cy="arrPersons"
              :class="{ valid: !v$.arrPersons.$invalid, invalid: v$.arrPersons.$invalid }"
              v-model.number="v$.arrPersons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.depRooms')"
              for="reservation-stat-daily-depRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="depRooms"
              id="reservation-stat-daily-depRooms"
              data-cy="depRooms"
              :class="{ valid: !v$.depRooms.$invalid, invalid: v$.depRooms.$invalid }"
              v-model.number="v$.depRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.depPersons')"
              for="reservation-stat-daily-depPersons"
            ></label>
            <input
              type="number"
              class="form-control"
              name="depPersons"
              id="reservation-stat-daily-depPersons"
              data-cy="depPersons"
              :class="{ valid: !v$.depPersons.$invalid, invalid: v$.depPersons.$invalid }"
              v-model.number="v$.depPersons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dayUseRooms')"
              for="reservation-stat-daily-dayUseRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="dayUseRooms"
              id="reservation-stat-daily-dayUseRooms"
              data-cy="dayUseRooms"
              :class="{ valid: !v$.dayUseRooms.$invalid, invalid: v$.dayUseRooms.$invalid }"
              v-model.number="v$.dayUseRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dayUsePersons')"
              for="reservation-stat-daily-dayUsePersons"
            ></label>
            <input
              type="number"
              class="form-control"
              name="dayUsePersons"
              id="reservation-stat-daily-dayUsePersons"
              data-cy="dayUsePersons"
              :class="{ valid: !v$.dayUsePersons.$invalid, invalid: v$.dayUsePersons.$invalid }"
              v-model.number="v$.dayUsePersons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancelledRooms')"
              for="reservation-stat-daily-cancelledRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cancelledRooms"
              id="reservation-stat-daily-cancelledRooms"
              data-cy="cancelledRooms"
              :class="{ valid: !v$.cancelledRooms.$invalid, invalid: v$.cancelledRooms.$invalid }"
              v-model.number="v$.cancelledRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancelledPersons')"
              for="reservation-stat-daily-cancelledPersons"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cancelledPersons"
              id="reservation-stat-daily-cancelledPersons"
              data-cy="cancelledPersons"
              :class="{ valid: !v$.cancelledPersons.$invalid, invalid: v$.cancelledPersons.$invalid }"
              v-model.number="v$.cancelledPersons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noShowRooms')"
              for="reservation-stat-daily-noShowRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="noShowRooms"
              id="reservation-stat-daily-noShowRooms"
              data-cy="noShowRooms"
              :class="{ valid: !v$.noShowRooms.$invalid, invalid: v$.noShowRooms.$invalid }"
              v-model.number="v$.noShowRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noShowPersons')"
              for="reservation-stat-daily-noShowPersons"
            ></label>
            <input
              type="number"
              class="form-control"
              name="noShowPersons"
              id="reservation-stat-daily-noShowPersons"
              data-cy="noShowPersons"
              :class="{ valid: !v$.noShowPersons.$invalid, invalid: v$.noShowPersons.$invalid }"
              v-model.number="v$.noShowPersons.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.singleOccupancy')"
              for="reservation-stat-daily-singleOccupancy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="singleOccupancy"
              id="reservation-stat-daily-singleOccupancy"
              data-cy="singleOccupancy"
              :class="{ valid: !v$.singleOccupancy.$invalid, invalid: v$.singleOccupancy.$invalid }"
              v-model.number="v$.singleOccupancy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.multipleOccupancy')"
              for="reservation-stat-daily-multipleOccupancy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="multipleOccupancy"
              id="reservation-stat-daily-multipleOccupancy"
              data-cy="multipleOccupancy"
              :class="{ valid: !v$.multipleOccupancy.$invalid, invalid: v$.multipleOccupancy.$invalid }"
              v-model.number="v$.multipleOccupancy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cribs')"
              for="reservation-stat-daily-cribs"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cribs"
              id="reservation-stat-daily-cribs"
              data-cy="cribs"
              :class="{ valid: !v$.cribs.$invalid, invalid: v$.cribs.$invalid }"
              v-model.number="v$.cribs.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.extraBeds')"
              for="reservation-stat-daily-extraBeds"
            ></label>
            <input
              type="number"
              class="form-control"
              name="extraBeds"
              id="reservation-stat-daily-extraBeds"
              data-cy="extraBeds"
              :class="{ valid: !v$.extraBeds.$invalid, invalid: v$.extraBeds.$invalid }"
              v-model.number="v$.extraBeds.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.otherRevenue')"
              for="reservation-stat-daily-otherRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="otherRevenue"
              id="reservation-stat-daily-otherRevenue"
              data-cy="otherRevenue"
              :class="{ valid: !v$.otherRevenue.$invalid, invalid: v$.otherRevenue.$invalid }"
              v-model.number="v$.otherRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageOtherRevenue')"
              for="reservation-stat-daily-packageOtherRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="packageOtherRevenue"
              id="reservation-stat-daily-packageOtherRevenue"
              data-cy="packageOtherRevenue"
              :class="{ valid: !v$.packageOtherRevenue.$invalid, invalid: v$.packageOtherRevenue.$invalid }"
              v-model.number="v$.packageOtherRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalOtherTax')"
              for="reservation-stat-daily-totalOtherTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="totalOtherTax"
              id="reservation-stat-daily-totalOtherTax"
              data-cy="totalOtherTax"
              :class="{ valid: !v$.totalOtherTax.$invalid, invalid: v$.totalOtherTax.$invalid }"
              v-model.number="v$.totalOtherTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.countryMainGroup')"
              for="reservation-stat-daily-countryMainGroup"
            ></label>
            <input
              type="text"
              class="form-control"
              name="countryMainGroup"
              id="reservation-stat-daily-countryMainGroup"
              data-cy="countryMainGroup"
              :class="{ valid: !v$.countryMainGroup.$invalid, invalid: v$.countryMainGroup.$invalid }"
              v-model="v$.countryMainGroup.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.state')"
              for="reservation-stat-daily-state"
            ></label>
            <input
              type="text"
              class="form-control"
              name="state"
              id="reservation-stat-daily-state"
              data-cy="state"
              :class="{ valid: !v$.state.$invalid, invalid: v$.state.$invalid }"
              v-model="v$.state.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.fiscalRegionCode')"
              for="reservation-stat-daily-fiscalRegionCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="fiscalRegionCode"
              id="reservation-stat-daily-fiscalRegionCode"
              data-cy="fiscalRegionCode"
              :class="{ valid: !v$.fiscalRegionCode.$invalid, invalid: v$.fiscalRegionCode.$invalid }"
              v-model="v$.fiscalRegionCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nonRevenue')"
              for="reservation-stat-daily-nonRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="nonRevenue"
              id="reservation-stat-daily-nonRevenue"
              data-cy="nonRevenue"
              :class="{ valid: !v$.nonRevenue.$invalid, invalid: v$.nonRevenue.$invalid }"
              v-model.number="v$.nonRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageNonRevenue')"
              for="reservation-stat-daily-packageNonRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="packageNonRevenue"
              id="reservation-stat-daily-packageNonRevenue"
              data-cy="packageNonRevenue"
              :class="{ valid: !v$.packageNonRevenue.$invalid, invalid: v$.packageNonRevenue.$invalid }"
              v-model.number="v$.packageNonRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalNonRevenueTax')"
              for="reservation-stat-daily-totalNonRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="totalNonRevenueTax"
              id="reservation-stat-daily-totalNonRevenueTax"
              data-cy="totalNonRevenueTax"
              :class="{ valid: !v$.totalNonRevenueTax.$invalid, invalid: v$.totalNonRevenueTax.$invalid }"
              v-model.number="v$.totalNonRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prRoomRevenue')"
              for="reservation-stat-daily-prRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prRoomRevenue"
              id="reservation-stat-daily-prRoomRevenue"
              data-cy="prRoomRevenue"
              :class="{ valid: !v$.prRoomRevenue.$invalid, invalid: v$.prRoomRevenue.$invalid }"
              v-model.number="v$.prRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prFoodRevenue')"
              for="reservation-stat-daily-prFoodRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prFoodRevenue"
              id="reservation-stat-daily-prFoodRevenue"
              data-cy="prFoodRevenue"
              :class="{ valid: !v$.prFoodRevenue.$invalid, invalid: v$.prFoodRevenue.$invalid }"
              v-model.number="v$.prFoodRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageRoomRevenue')"
              for="reservation-stat-daily-prPackageRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prPackageRoomRevenue"
              id="reservation-stat-daily-prPackageRoomRevenue"
              data-cy="prPackageRoomRevenue"
              :class="{ valid: !v$.prPackageRoomRevenue.$invalid, invalid: v$.prPackageRoomRevenue.$invalid }"
              v-model.number="v$.prPackageRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageFoodRevenue')"
              for="reservation-stat-daily-prPackageFoodRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prPackageFoodRevenue"
              id="reservation-stat-daily-prPackageFoodRevenue"
              data-cy="prPackageFoodRevenue"
              :class="{ valid: !v$.prPackageFoodRevenue.$invalid, invalid: v$.prPackageFoodRevenue.$invalid }"
              v-model.number="v$.prPackageFoodRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalRoomTax')"
              for="reservation-stat-daily-prTotalRoomTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prTotalRoomTax"
              id="reservation-stat-daily-prTotalRoomTax"
              data-cy="prTotalRoomTax"
              :class="{ valid: !v$.prTotalRoomTax.$invalid, invalid: v$.prTotalRoomTax.$invalid }"
              v-model.number="v$.prTotalRoomTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalFoodTax')"
              for="reservation-stat-daily-prTotalFoodTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prTotalFoodTax"
              id="reservation-stat-daily-prTotalFoodTax"
              data-cy="prTotalFoodTax"
              :class="{ valid: !v$.prTotalFoodTax.$invalid, invalid: v$.prTotalFoodTax.$invalid }"
              v-model.number="v$.prTotalFoodTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalPackageRevenue')"
              for="reservation-stat-daily-prTotalPackageRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prTotalPackageRevenue"
              id="reservation-stat-daily-prTotalPackageRevenue"
              data-cy="prTotalPackageRevenue"
              :class="{ valid: !v$.prTotalPackageRevenue.$invalid, invalid: v$.prTotalPackageRevenue.$invalid }"
              v-model.number="v$.prTotalPackageRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalRevenue')"
              for="reservation-stat-daily-prTotalRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prTotalRevenue"
              id="reservation-stat-daily-prTotalRevenue"
              data-cy="prTotalRevenue"
              :class="{ valid: !v$.prTotalRevenue.$invalid, invalid: v$.prTotalRevenue.$invalid }"
              v-model.number="v$.prTotalRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalTax')"
              for="reservation-stat-daily-prTotalTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prTotalTax"
              id="reservation-stat-daily-prTotalTax"
              data-cy="prTotalTax"
              :class="{ valid: !v$.prTotalTax.$invalid, invalid: v$.prTotalTax.$invalid }"
              v-model.number="v$.prTotalTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prOtherRevenue')"
              for="reservation-stat-daily-prOtherRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prOtherRevenue"
              id="reservation-stat-daily-prOtherRevenue"
              data-cy="prOtherRevenue"
              :class="{ valid: !v$.prOtherRevenue.$invalid, invalid: v$.prOtherRevenue.$invalid }"
              v-model.number="v$.prOtherRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageOtherRevenue')"
              for="reservation-stat-daily-prPackageOtherRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prPackageOtherRevenue"
              id="reservation-stat-daily-prPackageOtherRevenue"
              data-cy="prPackageOtherRevenue"
              :class="{ valid: !v$.prPackageOtherRevenue.$invalid, invalid: v$.prPackageOtherRevenue.$invalid }"
              v-model.number="v$.prPackageOtherRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalOtherTax')"
              for="reservation-stat-daily-prTotalOtherTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prTotalOtherTax"
              id="reservation-stat-daily-prTotalOtherTax"
              data-cy="prTotalOtherTax"
              :class="{ valid: !v$.prTotalOtherTax.$invalid, invalid: v$.prTotalOtherTax.$invalid }"
              v-model.number="v$.prTotalOtherTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prNonRevenue')"
              for="reservation-stat-daily-prNonRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prNonRevenue"
              id="reservation-stat-daily-prNonRevenue"
              data-cy="prNonRevenue"
              :class="{ valid: !v$.prNonRevenue.$invalid, invalid: v$.prNonRevenue.$invalid }"
              v-model.number="v$.prNonRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageNonRevenue')"
              for="reservation-stat-daily-prPackageNonRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prPackageNonRevenue"
              id="reservation-stat-daily-prPackageNonRevenue"
              data-cy="prPackageNonRevenue"
              :class="{ valid: !v$.prPackageNonRevenue.$invalid, invalid: v$.prPackageNonRevenue.$invalid }"
              v-model.number="v$.prPackageNonRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalNonRevenueTax')"
              for="reservation-stat-daily-prTotalNonRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prTotalNonRevenueTax"
              id="reservation-stat-daily-prTotalNonRevenueTax"
              data-cy="prTotalNonRevenueTax"
              :class="{ valid: !v$.prTotalNonRevenueTax.$invalid, invalid: v$.prTotalNonRevenueTax.$invalid }"
              v-model.number="v$.prTotalNonRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nights')"
              for="reservation-stat-daily-nights"
            ></label>
            <input
              type="number"
              class="form-control"
              name="nights"
              id="reservation-stat-daily-nights"
              data-cy="nights"
              :class="{ valid: !v$.nights.$invalid, invalid: v$.nights.$invalid }"
              v-model.number="v$.nights.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noOfStays')"
              for="reservation-stat-daily-noOfStays"
            ></label>
            <input
              type="number"
              class="form-control"
              name="noOfStays"
              id="reservation-stat-daily-noOfStays"
              data-cy="noOfStays"
              :class="{ valid: !v$.noOfStays.$invalid, invalid: v$.noOfStays.$invalid }"
              v-model.number="v$.noOfStays.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationNights')"
              for="reservation-stat-daily-reservationNights"
            ></label>
            <input
              type="number"
              class="form-control"
              name="reservationNights"
              id="reservation-stat-daily-reservationNights"
              data-cy="reservationNights"
              :class="{ valid: !v$.reservationNights.$invalid, invalid: v$.reservationNights.$invalid }"
              v-model.number="v$.reservationNights.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationArrivals')"
              for="reservation-stat-daily-reservationArrivals"
            ></label>
            <input
              type="number"
              class="form-control"
              name="reservationArrivals"
              id="reservation-stat-daily-reservationArrivals"
              data-cy="reservationArrivals"
              :class="{ valid: !v$.reservationArrivals.$invalid, invalid: v$.reservationArrivals.$invalid }"
              v-model.number="v$.reservationArrivals.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationNoOfStays')"
              for="reservation-stat-daily-reservationNoOfStays"
            ></label>
            <input
              type="number"
              class="form-control"
              name="reservationNoOfStays"
              id="reservation-stat-daily-reservationNoOfStays"
              data-cy="reservationNoOfStays"
              :class="{ valid: !v$.reservationNoOfStays.$invalid, invalid: v$.reservationNoOfStays.$invalid }"
              v-model.number="v$.reservationNoOfStays.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dayUseReservations')"
              for="reservation-stat-daily-dayUseReservations"
            ></label>
            <input
              type="number"
              class="form-control"
              name="dayUseReservations"
              id="reservation-stat-daily-dayUseReservations"
              data-cy="dayUseReservations"
              :class="{ valid: !v$.dayUseReservations.$invalid, invalid: v$.dayUseReservations.$invalid }"
              v-model.number="v$.dayUseReservations.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancelledReservations')"
              for="reservation-stat-daily-cancelledReservations"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cancelledReservations"
              id="reservation-stat-daily-cancelledReservations"
              data-cy="cancelledReservations"
              :class="{ valid: !v$.cancelledReservations.$invalid, invalid: v$.cancelledReservations.$invalid }"
              v-model.number="v$.cancelledReservations.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noShowReservations')"
              for="reservation-stat-daily-noShowReservations"
            ></label>
            <input
              type="number"
              class="form-control"
              name="noShowReservations"
              id="reservation-stat-daily-noShowReservations"
              data-cy="noShowReservations"
              :class="{ valid: !v$.noShowReservations.$invalid, invalid: v$.noShowReservations.$invalid }"
              v-model.number="v$.noShowReservations.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.city')"
              for="reservation-stat-daily-city"
            ></label>
            <input
              type="text"
              class="form-control"
              name="city"
              id="reservation-stat-daily-city"
              data-cy="city"
              :class="{ valid: !v$.city.$invalid, invalid: v$.city.$invalid }"
              v-model="v$.city.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.zipCode')"
              for="reservation-stat-daily-zipCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="zipCode"
              id="reservation-stat-daily-zipCode"
              data-cy="zipCode"
              :class="{ valid: !v$.zipCode.$invalid, invalid: v$.zipCode.$invalid }"
              v-model="v$.zipCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.district')"
              for="reservation-stat-daily-district"
            ></label>
            <input
              type="text"
              class="form-control"
              name="district"
              id="reservation-stat-daily-district"
              data-cy="district"
              :class="{ valid: !v$.district.$invalid, invalid: v$.district.$invalid }"
              v-model="v$.district.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cashRoomNts')"
              for="reservation-stat-daily-cashRoomNts"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cashRoomNts"
              id="reservation-stat-daily-cashRoomNts"
              data-cy="cashRoomNts"
              :class="{ valid: !v$.cashRoomNts.$invalid, invalid: v$.cashRoomNts.$invalid }"
              v-model.number="v$.cashRoomNts.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.compRoomNts')"
              for="reservation-stat-daily-compRoomNts"
            ></label>
            <input
              type="number"
              class="form-control"
              name="compRoomNts"
              id="reservation-stat-daily-compRoomNts"
              data-cy="compRoomNts"
              :class="{ valid: !v$.compRoomNts.$invalid, invalid: v$.compRoomNts.$invalid }"
              v-model.number="v$.compRoomNts.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cashRoomRevenue')"
              for="reservation-stat-daily-cashRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cashRoomRevenue"
              id="reservation-stat-daily-cashRoomRevenue"
              data-cy="cashRoomRevenue"
              :class="{ valid: !v$.cashRoomRevenue.$invalid, invalid: v$.cashRoomRevenue.$invalid }"
              v-model.number="v$.cashRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.compRoomRevenue')"
              for="reservation-stat-daily-compRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="compRoomRevenue"
              id="reservation-stat-daily-compRoomRevenue"
              data-cy="compRoomRevenue"
              :class="{ valid: !v$.compRoomRevenue.$invalid, invalid: v$.compRoomRevenue.$invalid }"
              v-model.number="v$.compRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resInsertSource')"
              for="reservation-stat-daily-resInsertSource"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resInsertSource"
              id="reservation-stat-daily-resInsertSource"
              data-cy="resInsertSource"
              :class="{ valid: !v$.resInsertSource.$invalid, invalid: v$.resInsertSource.$invalid }"
              v-model="v$.resInsertSource.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resInsertSourceType')"
              for="reservation-stat-daily-resInsertSourceType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resInsertSourceType"
              id="reservation-stat-daily-resInsertSourceType"
              data-cy="resInsertSourceType"
              :class="{ valid: !v$.resInsertSourceType.$invalid, invalid: v$.resInsertSourceType.$invalid }"
              v-model="v$.resInsertSourceType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children1')"
              for="reservation-stat-daily-children1"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children1"
              id="reservation-stat-daily-children1"
              data-cy="children1"
              :class="{ valid: !v$.children1.$invalid, invalid: v$.children1.$invalid }"
              v-model.number="v$.children1.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children2')"
              for="reservation-stat-daily-children2"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children2"
              id="reservation-stat-daily-children2"
              data-cy="children2"
              :class="{ valid: !v$.children2.$invalid, invalid: v$.children2.$invalid }"
              v-model.number="v$.children2.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children3')"
              for="reservation-stat-daily-children3"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children3"
              id="reservation-stat-daily-children3"
              data-cy="children3"
              :class="{ valid: !v$.children3.$invalid, invalid: v$.children3.$invalid }"
              v-model.number="v$.children3.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children4')"
              for="reservation-stat-daily-children4"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children4"
              id="reservation-stat-daily-children4"
              data-cy="children4"
              :class="{ valid: !v$.children4.$invalid, invalid: v$.children4.$invalid }"
              v-model.number="v$.children4.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children5')"
              for="reservation-stat-daily-children5"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children5"
              id="reservation-stat-daily-children5"
              data-cy="children5"
              :class="{ valid: !v$.children5.$invalid, invalid: v$.children5.$invalid }"
              v-model.number="v$.children5.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.ffMembershipType')"
              for="reservation-stat-daily-ffMembershipType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ffMembershipType"
              id="reservation-stat-daily-ffMembershipType"
              data-cy="ffMembershipType"
              :class="{ valid: !v$.ffMembershipType.$invalid, invalid: v$.ffMembershipType.$invalid }"
              v-model="v$.ffMembershipType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.fgMembershipType')"
              for="reservation-stat-daily-fgMembershipType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="fgMembershipType"
              id="reservation-stat-daily-fgMembershipType"
              data-cy="fgMembershipType"
              :class="{ valid: !v$.fgMembershipType.$invalid, invalid: v$.fgMembershipType.$invalid }"
              v-model="v$.fgMembershipType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.promotionCode')"
              for="reservation-stat-daily-promotionCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="promotionCode"
              id="reservation-stat-daily-promotionCode"
              data-cy="promotionCode"
              :class="{ valid: !v$.promotionCode.$invalid, invalid: v$.promotionCode.$invalid }"
              v-model="v$.promotionCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.ownerFfFlag')"
              for="reservation-stat-daily-ownerFfFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ownerFfFlag"
              id="reservation-stat-daily-ownerFfFlag"
              data-cy="ownerFfFlag"
              :class="{ valid: !v$.ownerFfFlag.$invalid, invalid: v$.ownerFfFlag.$invalid }"
              v-model="v$.ownerFfFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.ownerRentalFlag')"
              for="reservation-stat-daily-ownerRentalFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ownerRentalFlag"
              id="reservation-stat-daily-ownerRentalFlag"
              data-cy="ownerRentalFlag"
              :class="{ valid: !v$.ownerRentalFlag.$invalid, invalid: v$.ownerRentalFlag.$invalid }"
              v-model="v$.ownerRentalFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.centralCurrencyCode')"
              for="reservation-stat-daily-centralCurrencyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="centralCurrencyCode"
              id="reservation-stat-daily-centralCurrencyCode"
              data-cy="centralCurrencyCode"
              :class="{ valid: !v$.centralCurrencyCode.$invalid, invalid: v$.centralCurrencyCode.$invalid }"
              v-model="v$.centralCurrencyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.centralExchangeRate')"
              for="reservation-stat-daily-centralExchangeRate"
            ></label>
            <input
              type="number"
              class="form-control"
              name="centralExchangeRate"
              id="reservation-stat-daily-centralExchangeRate"
              data-cy="centralExchangeRate"
              :class="{ valid: !v$.centralExchangeRate.$invalid, invalid: v$.centralExchangeRate.$invalid }"
              v-model.number="v$.centralExchangeRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.bookedRoomCategory')"
              for="reservation-stat-daily-bookedRoomCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="bookedRoomCategory"
              id="reservation-stat-daily-bookedRoomCategory"
              data-cy="bookedRoomCategory"
              :class="{ valid: !v$.bookedRoomCategory.$invalid, invalid: v$.bookedRoomCategory.$invalid }"
              v-model="v$.bookedRoomCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.businessDateCreated')"
              for="reservation-stat-daily-businessDateCreated"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-stat-daily-businessDateCreated"
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
                id="reservation-stat-daily-businessDateCreated"
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
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rateAmount')"
              for="reservation-stat-daily-rateAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rateAmount"
              id="reservation-stat-daily-rateAmount"
              data-cy="rateAmount"
              :class="{ valid: !v$.rateAmount.$invalid, invalid: v$.rateAmount.$invalid }"
              v-model.number="v$.rateAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.parentCompanyId')"
              for="reservation-stat-daily-parentCompanyId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="parentCompanyId"
              id="reservation-stat-daily-parentCompanyId"
              data-cy="parentCompanyId"
              :class="{ valid: !v$.parentCompanyId.$invalid, invalid: v$.parentCompanyId.$invalid }"
              v-model.number="v$.parentCompanyId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.houseUseYn')"
              for="reservation-stat-daily-houseUseYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="houseUseYn"
              id="reservation-stat-daily-houseUseYn"
              data-cy="houseUseYn"
              :class="{ valid: !v$.houseUseYn.$invalid, invalid: v$.houseUseYn.$invalid }"
              v-model="v$.houseUseYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.complimentaryYn')"
              for="reservation-stat-daily-complimentaryYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="complimentaryYn"
              id="reservation-stat-daily-complimentaryYn"
              data-cy="complimentaryYn"
              :class="{ valid: !v$.complimentaryYn.$invalid, invalid: v$.complimentaryYn.$invalid }"
              v-model="v$.complimentaryYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.biResvNameId')"
              for="reservation-stat-daily-biResvNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="biResvNameId"
              id="reservation-stat-daily-biResvNameId"
              data-cy="biResvNameId"
              :class="{ valid: !v$.biResvNameId.$invalid, invalid: v$.biResvNameId.$invalid }"
              v-model.number="v$.biResvNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advFoodRevenue')"
              for="reservation-stat-daily-advFoodRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="advFoodRevenue"
              id="reservation-stat-daily-advFoodRevenue"
              data-cy="advFoodRevenue"
              :class="{ valid: !v$.advFoodRevenue.$invalid, invalid: v$.advFoodRevenue.$invalid }"
              v-model.number="v$.advFoodRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advNonRevenue')"
              for="reservation-stat-daily-advNonRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="advNonRevenue"
              id="reservation-stat-daily-advNonRevenue"
              data-cy="advNonRevenue"
              :class="{ valid: !v$.advNonRevenue.$invalid, invalid: v$.advNonRevenue.$invalid }"
              v-model.number="v$.advNonRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advOtherRevenue')"
              for="reservation-stat-daily-advOtherRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="advOtherRevenue"
              id="reservation-stat-daily-advOtherRevenue"
              data-cy="advOtherRevenue"
              :class="{ valid: !v$.advOtherRevenue.$invalid, invalid: v$.advOtherRevenue.$invalid }"
              v-model.number="v$.advOtherRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advRoomRevenue')"
              for="reservation-stat-daily-advRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="advRoomRevenue"
              id="reservation-stat-daily-advRoomRevenue"
              data-cy="advRoomRevenue"
              :class="{ valid: !v$.advRoomRevenue.$invalid, invalid: v$.advRoomRevenue.$invalid }"
              v-model.number="v$.advRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalFoodTax')"
              for="reservation-stat-daily-advTotalFoodTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="advTotalFoodTax"
              id="reservation-stat-daily-advTotalFoodTax"
              data-cy="advTotalFoodTax"
              :class="{ valid: !v$.advTotalFoodTax.$invalid, invalid: v$.advTotalFoodTax.$invalid }"
              v-model.number="v$.advTotalFoodTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalNonRevenueTax')"
              for="reservation-stat-daily-advTotalNonRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="advTotalNonRevenueTax"
              id="reservation-stat-daily-advTotalNonRevenueTax"
              data-cy="advTotalNonRevenueTax"
              :class="{ valid: !v$.advTotalNonRevenueTax.$invalid, invalid: v$.advTotalNonRevenueTax.$invalid }"
              v-model.number="v$.advTotalNonRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalOtherTax')"
              for="reservation-stat-daily-advTotalOtherTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="advTotalOtherTax"
              id="reservation-stat-daily-advTotalOtherTax"
              data-cy="advTotalOtherTax"
              :class="{ valid: !v$.advTotalOtherTax.$invalid, invalid: v$.advTotalOtherTax.$invalid }"
              v-model.number="v$.advTotalOtherTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalRevenue')"
              for="reservation-stat-daily-advTotalRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="advTotalRevenue"
              id="reservation-stat-daily-advTotalRevenue"
              data-cy="advTotalRevenue"
              :class="{ valid: !v$.advTotalRevenue.$invalid, invalid: v$.advTotalRevenue.$invalid }"
              v-model.number="v$.advTotalRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalRoomTax')"
              for="reservation-stat-daily-advTotalRoomTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="advTotalRoomTax"
              id="reservation-stat-daily-advTotalRoomTax"
              data-cy="advTotalRoomTax"
              :class="{ valid: !v$.advTotalRoomTax.$invalid, invalid: v$.advTotalRoomTax.$invalid }"
              v-model.number="v$.advTotalRoomTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalTax')"
              for="reservation-stat-daily-advTotalTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="advTotalTax"
              id="reservation-stat-daily-advTotalTax"
              data-cy="advTotalTax"
              :class="{ valid: !v$.advTotalTax.$invalid, invalid: v$.advTotalTax.$invalid }"
              v-model.number="v$.advTotalTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvFoodRevenue')"
              for="reservation-stat-daily-prAdvFoodRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prAdvFoodRevenue"
              id="reservation-stat-daily-prAdvFoodRevenue"
              data-cy="prAdvFoodRevenue"
              :class="{ valid: !v$.prAdvFoodRevenue.$invalid, invalid: v$.prAdvFoodRevenue.$invalid }"
              v-model.number="v$.prAdvFoodRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvNonRevenue')"
              for="reservation-stat-daily-prAdvNonRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prAdvNonRevenue"
              id="reservation-stat-daily-prAdvNonRevenue"
              data-cy="prAdvNonRevenue"
              :class="{ valid: !v$.prAdvNonRevenue.$invalid, invalid: v$.prAdvNonRevenue.$invalid }"
              v-model.number="v$.prAdvNonRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvOtherRevenue')"
              for="reservation-stat-daily-prAdvOtherRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prAdvOtherRevenue"
              id="reservation-stat-daily-prAdvOtherRevenue"
              data-cy="prAdvOtherRevenue"
              :class="{ valid: !v$.prAdvOtherRevenue.$invalid, invalid: v$.prAdvOtherRevenue.$invalid }"
              v-model.number="v$.prAdvOtherRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvRoomRevenue')"
              for="reservation-stat-daily-prAdvRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prAdvRoomRevenue"
              id="reservation-stat-daily-prAdvRoomRevenue"
              data-cy="prAdvRoomRevenue"
              :class="{ valid: !v$.prAdvRoomRevenue.$invalid, invalid: v$.prAdvRoomRevenue.$invalid }"
              v-model.number="v$.prAdvRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalFoodTax')"
              for="reservation-stat-daily-prAdvTotalFoodTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prAdvTotalFoodTax"
              id="reservation-stat-daily-prAdvTotalFoodTax"
              data-cy="prAdvTotalFoodTax"
              :class="{ valid: !v$.prAdvTotalFoodTax.$invalid, invalid: v$.prAdvTotalFoodTax.$invalid }"
              v-model.number="v$.prAdvTotalFoodTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalNonRevenueTax')"
              for="reservation-stat-daily-prAdvTotalNonRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prAdvTotalNonRevenueTax"
              id="reservation-stat-daily-prAdvTotalNonRevenueTax"
              data-cy="prAdvTotalNonRevenueTax"
              :class="{ valid: !v$.prAdvTotalNonRevenueTax.$invalid, invalid: v$.prAdvTotalNonRevenueTax.$invalid }"
              v-model.number="v$.prAdvTotalNonRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalOtherTax')"
              for="reservation-stat-daily-prAdvTotalOtherTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prAdvTotalOtherTax"
              id="reservation-stat-daily-prAdvTotalOtherTax"
              data-cy="prAdvTotalOtherTax"
              :class="{ valid: !v$.prAdvTotalOtherTax.$invalid, invalid: v$.prAdvTotalOtherTax.$invalid }"
              v-model.number="v$.prAdvTotalOtherTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalRevenue')"
              for="reservation-stat-daily-prAdvTotalRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prAdvTotalRevenue"
              id="reservation-stat-daily-prAdvTotalRevenue"
              data-cy="prAdvTotalRevenue"
              :class="{ valid: !v$.prAdvTotalRevenue.$invalid, invalid: v$.prAdvTotalRevenue.$invalid }"
              v-model.number="v$.prAdvTotalRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalRoomTax')"
              for="reservation-stat-daily-prAdvTotalRoomTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prAdvTotalRoomTax"
              id="reservation-stat-daily-prAdvTotalRoomTax"
              data-cy="prAdvTotalRoomTax"
              :class="{ valid: !v$.prAdvTotalRoomTax.$invalid, invalid: v$.prAdvTotalRoomTax.$invalid }"
              v-model.number="v$.prAdvTotalRoomTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalTax')"
              for="reservation-stat-daily-prAdvTotalTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="prAdvTotalTax"
              id="reservation-stat-daily-prAdvTotalTax"
              data-cy="prAdvTotalTax"
              :class="{ valid: !v$.prAdvTotalTax.$invalid, invalid: v$.prAdvTotalTax.$invalid }"
              v-model.number="v$.prAdvTotalTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.upsoldRevenue')"
              for="reservation-stat-daily-upsoldRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="upsoldRevenue"
              id="reservation-stat-daily-upsoldRevenue"
              data-cy="upsoldRevenue"
              :class="{ valid: !v$.upsoldRevenue.$invalid, invalid: v$.upsoldRevenue.$invalid }"
              v-model.number="v$.upsoldRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdRoomRevenue')"
              for="reservation-stat-daily-flgdRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="flgdRoomRevenue"
              id="reservation-stat-daily-flgdRoomRevenue"
              data-cy="flgdRoomRevenue"
              :class="{ valid: !v$.flgdRoomRevenue.$invalid, invalid: v$.flgdRoomRevenue.$invalid }"
              v-model.number="v$.flgdRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdFoodRevenue')"
              for="reservation-stat-daily-flgdFoodRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="flgdFoodRevenue"
              id="reservation-stat-daily-flgdFoodRevenue"
              data-cy="flgdFoodRevenue"
              :class="{ valid: !v$.flgdFoodRevenue.$invalid, invalid: v$.flgdFoodRevenue.$invalid }"
              v-model.number="v$.flgdFoodRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdNonRevenue')"
              for="reservation-stat-daily-flgdNonRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="flgdNonRevenue"
              id="reservation-stat-daily-flgdNonRevenue"
              data-cy="flgdNonRevenue"
              :class="{ valid: !v$.flgdNonRevenue.$invalid, invalid: v$.flgdNonRevenue.$invalid }"
              v-model.number="v$.flgdNonRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdOtherRevenue')"
              for="reservation-stat-daily-flgdOtherRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="flgdOtherRevenue"
              id="reservation-stat-daily-flgdOtherRevenue"
              data-cy="flgdOtherRevenue"
              :class="{ valid: !v$.flgdOtherRevenue.$invalid, invalid: v$.flgdOtherRevenue.$invalid }"
              v-model.number="v$.flgdOtherRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalRoomTax')"
              for="reservation-stat-daily-flgdTotalRoomTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="flgdTotalRoomTax"
              id="reservation-stat-daily-flgdTotalRoomTax"
              data-cy="flgdTotalRoomTax"
              :class="{ valid: !v$.flgdTotalRoomTax.$invalid, invalid: v$.flgdTotalRoomTax.$invalid }"
              v-model.number="v$.flgdTotalRoomTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalFoodTax')"
              for="reservation-stat-daily-flgdTotalFoodTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="flgdTotalFoodTax"
              id="reservation-stat-daily-flgdTotalFoodTax"
              data-cy="flgdTotalFoodTax"
              :class="{ valid: !v$.flgdTotalFoodTax.$invalid, invalid: v$.flgdTotalFoodTax.$invalid }"
              v-model.number="v$.flgdTotalFoodTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalNonRevenueTax')"
              for="reservation-stat-daily-flgdTotalNonRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="flgdTotalNonRevenueTax"
              id="reservation-stat-daily-flgdTotalNonRevenueTax"
              data-cy="flgdTotalNonRevenueTax"
              :class="{ valid: !v$.flgdTotalNonRevenueTax.$invalid, invalid: v$.flgdTotalNonRevenueTax.$invalid }"
              v-model.number="v$.flgdTotalNonRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalOtherTax')"
              for="reservation-stat-daily-flgdTotalOtherTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="flgdTotalOtherTax"
              id="reservation-stat-daily-flgdTotalOtherTax"
              data-cy="flgdTotalOtherTax"
              :class="{ valid: !v$.flgdTotalOtherTax.$invalid, invalid: v$.flgdTotalOtherTax.$invalid }"
              v-model.number="v$.flgdTotalOtherTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalRevenue')"
              for="reservation-stat-daily-flgdTotalRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="flgdTotalRevenue"
              id="reservation-stat-daily-flgdTotalRevenue"
              data-cy="flgdTotalRevenue"
              :class="{ valid: !v$.flgdTotalRevenue.$invalid, invalid: v$.flgdTotalRevenue.$invalid }"
              v-model.number="v$.flgdTotalRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalTax')"
              for="reservation-stat-daily-flgdTotalTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="flgdTotalTax"
              id="reservation-stat-daily-flgdTotalTax"
              data-cy="flgdTotalTax"
              :class="{ valid: !v$.flgdTotalTax.$invalid, invalid: v$.flgdTotalTax.$invalid }"
              v-model.number="v$.flgdTotalTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.contactYn')"
              for="reservation-stat-daily-contactYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="contactYn"
              id="reservation-stat-daily-contactYn"
              data-cy="contactYn"
              :class="{ valid: !v$.contactYn.$invalid, invalid: v$.contactYn.$invalid }"
              v-model="v$.contactYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.extendedStayTier')"
              for="reservation-stat-daily-extendedStayTier"
            ></label>
            <input
              type="number"
              class="form-control"
              name="extendedStayTier"
              id="reservation-stat-daily-extendedStayTier"
              data-cy="extendedStayTier"
              :class="{ valid: !v$.extendedStayTier.$invalid, invalid: v$.extendedStayTier.$invalid }"
              v-model.number="v$.extendedStayTier.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvTotalRevenue')"
              for="reservation-stat-daily-rsAdvTotalRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rsAdvTotalRevenue"
              id="reservation-stat-daily-rsAdvTotalRevenue"
              data-cy="rsAdvTotalRevenue"
              :class="{ valid: !v$.rsAdvTotalRevenue.$invalid, invalid: v$.rsAdvTotalRevenue.$invalid }"
              v-model.number="v$.rsAdvTotalRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvRoomRevenue')"
              for="reservation-stat-daily-rsAdvRoomRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rsAdvRoomRevenue"
              id="reservation-stat-daily-rsAdvRoomRevenue"
              data-cy="rsAdvRoomRevenue"
              :class="{ valid: !v$.rsAdvRoomRevenue.$invalid, invalid: v$.rsAdvRoomRevenue.$invalid }"
              v-model.number="v$.rsAdvRoomRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvFoodRevenue')"
              for="reservation-stat-daily-rsAdvFoodRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rsAdvFoodRevenue"
              id="reservation-stat-daily-rsAdvFoodRevenue"
              data-cy="rsAdvFoodRevenue"
              :class="{ valid: !v$.rsAdvFoodRevenue.$invalid, invalid: v$.rsAdvFoodRevenue.$invalid }"
              v-model.number="v$.rsAdvFoodRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvOtherRevenue')"
              for="reservation-stat-daily-rsAdvOtherRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rsAdvOtherRevenue"
              id="reservation-stat-daily-rsAdvOtherRevenue"
              data-cy="rsAdvOtherRevenue"
              :class="{ valid: !v$.rsAdvOtherRevenue.$invalid, invalid: v$.rsAdvOtherRevenue.$invalid }"
              v-model.number="v$.rsAdvOtherRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvNonRevenue')"
              for="reservation-stat-daily-rsAdvNonRevenue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rsAdvNonRevenue"
              id="reservation-stat-daily-rsAdvNonRevenue"
              data-cy="rsAdvNonRevenue"
              :class="{ valid: !v$.rsAdvNonRevenue.$invalid, invalid: v$.rsAdvNonRevenue.$invalid }"
              v-model.number="v$.rsAdvNonRevenue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvTotalTax')"
              for="reservation-stat-daily-rsAdvTotalTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rsAdvTotalTax"
              id="reservation-stat-daily-rsAdvTotalTax"
              data-cy="rsAdvTotalTax"
              :class="{ valid: !v$.rsAdvTotalTax.$invalid, invalid: v$.rsAdvTotalTax.$invalid }"
              v-model.number="v$.rsAdvTotalTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvRoomTax')"
              for="reservation-stat-daily-rsAdvRoomTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rsAdvRoomTax"
              id="reservation-stat-daily-rsAdvRoomTax"
              data-cy="rsAdvRoomTax"
              :class="{ valid: !v$.rsAdvRoomTax.$invalid, invalid: v$.rsAdvRoomTax.$invalid }"
              v-model.number="v$.rsAdvRoomTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvFoodTax')"
              for="reservation-stat-daily-rsAdvFoodTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rsAdvFoodTax"
              id="reservation-stat-daily-rsAdvFoodTax"
              data-cy="rsAdvFoodTax"
              :class="{ valid: !v$.rsAdvFoodTax.$invalid, invalid: v$.rsAdvFoodTax.$invalid }"
              v-model.number="v$.rsAdvFoodTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvOtherTax')"
              for="reservation-stat-daily-rsAdvOtherTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rsAdvOtherTax"
              id="reservation-stat-daily-rsAdvOtherTax"
              data-cy="rsAdvOtherTax"
              :class="{ valid: !v$.rsAdvOtherTax.$invalid, invalid: v$.rsAdvOtherTax.$invalid }"
              v-model.number="v$.rsAdvOtherTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvNonRevenueTax')"
              for="reservation-stat-daily-rsAdvNonRevenueTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rsAdvNonRevenueTax"
              id="reservation-stat-daily-rsAdvNonRevenueTax"
              data-cy="rsAdvNonRevenueTax"
              :class="{ valid: !v$.rsAdvNonRevenueTax.$invalid, invalid: v$.rsAdvNonRevenueTax.$invalid }"
              v-model.number="v$.rsAdvNonRevenueTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.updateDate')"
              for="reservation-stat-daily-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-stat-daily-updateDate"
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
                id="reservation-stat-daily-updateDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationStatDaily.guid')"
              for="reservation-stat-daily-guid"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guid"
              id="reservation-stat-daily-guid"
              data-cy="guid"
              :class="{ valid: !v$.guid.$invalid, invalid: v$.guid.$invalid }"
              v-model="v$.guid.$model"
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
<script lang="ts" src="./reservation-stat-daily-update.component.ts"></script>
