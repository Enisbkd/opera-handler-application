<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.reservationDailyElementName.home.createOrEditLabel"
          data-cy="ReservationDailyElementNameCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="reservationDailyElementName.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="reservationDailyElementName.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resort')"
              for="reservation-daily-element-name-resort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resort"
              id="reservation-daily-element-name-resort"
              data-cy="resort"
              :class="{ valid: !v$.resort.$invalid, invalid: v$.resort.$invalid }"
              v-model="v$.resort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resvNameId')"
              for="reservation-daily-element-name-resvNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="resvNameId"
              id="reservation-daily-element-name-resvNameId"
              data-cy="resvNameId"
              :class="{ valid: !v$.resvNameId.$invalid, invalid: v$.resvNameId.$invalid }"
              v-model.number="v$.resvNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.reservationDate')"
              for="reservation-daily-element-name-reservationDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-daily-element-name-reservationDate"
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
                id="reservation-daily-element-name-reservationDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resvDailyElSeq')"
              for="reservation-daily-element-name-resvDailyElSeq"
            ></label>
            <input
              type="number"
              class="form-control"
              name="resvDailyElSeq"
              id="reservation-daily-element-name-resvDailyElSeq"
              data-cy="resvDailyElSeq"
              :class="{ valid: !v$.resvDailyElSeq.$invalid, invalid: v$.resvDailyElSeq.$invalid }"
              v-model.number="v$.resvDailyElSeq.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.travelAgentId')"
              for="reservation-daily-element-name-travelAgentId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="travelAgentId"
              id="reservation-daily-element-name-travelAgentId"
              data-cy="travelAgentId"
              :class="{ valid: !v$.travelAgentId.$invalid, invalid: v$.travelAgentId.$invalid }"
              v-model.number="v$.travelAgentId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.companyId')"
              for="reservation-daily-element-name-companyId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="companyId"
              id="reservation-daily-element-name-companyId"
              data-cy="companyId"
              :class="{ valid: !v$.companyId.$invalid, invalid: v$.companyId.$invalid }"
              v-model.number="v$.companyId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sourceId')"
              for="reservation-daily-element-name-sourceId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="sourceId"
              id="reservation-daily-element-name-sourceId"
              data-cy="sourceId"
              :class="{ valid: !v$.sourceId.$invalid, invalid: v$.sourceId.$invalid }"
              v-model.number="v$.sourceId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.groupId')"
              for="reservation-daily-element-name-groupId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="groupId"
              id="reservation-daily-element-name-groupId"
              data-cy="groupId"
              :class="{ valid: !v$.groupId.$invalid, invalid: v$.groupId.$invalid }"
              v-model.number="v$.groupId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sharePaymentType')"
              for="reservation-daily-element-name-sharePaymentType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sharePaymentType"
              id="reservation-daily-element-name-sharePaymentType"
              data-cy="sharePaymentType"
              :class="{ valid: !v$.sharePaymentType.$invalid, invalid: v$.sharePaymentType.$invalid }"
              v-model="v$.sharePaymentType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.shareAmount')"
              for="reservation-daily-element-name-shareAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="shareAmount"
              id="reservation-daily-element-name-shareAmount"
              data-cy="shareAmount"
              :class="{ valid: !v$.shareAmount.$invalid, invalid: v$.shareAmount.$invalid }"
              v-model.number="v$.shareAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sharePrcnt')"
              for="reservation-daily-element-name-sharePrcnt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="sharePrcnt"
              id="reservation-daily-element-name-sharePrcnt"
              data-cy="sharePrcnt"
              :class="{ valid: !v$.sharePrcnt.$invalid, invalid: v$.sharePrcnt.$invalid }"
              v-model.number="v$.sharePrcnt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.adults')"
              for="reservation-daily-element-name-adults"
            ></label>
            <input
              type="number"
              class="form-control"
              name="adults"
              id="reservation-daily-element-name-adults"
              data-cy="adults"
              :class="{ valid: !v$.adults.$invalid, invalid: v$.adults.$invalid }"
              v-model.number="v$.adults.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children')"
              for="reservation-daily-element-name-children"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children"
              id="reservation-daily-element-name-children"
              data-cy="children"
              :class="{ valid: !v$.children.$invalid, invalid: v$.children.$invalid }"
              v-model.number="v$.children.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.discountAmt')"
              for="reservation-daily-element-name-discountAmt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="discountAmt"
              id="reservation-daily-element-name-discountAmt"
              data-cy="discountAmt"
              :class="{ valid: !v$.discountAmt.$invalid, invalid: v$.discountAmt.$invalid }"
              v-model.number="v$.discountAmt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.discountPrcnt')"
              for="reservation-daily-element-name-discountPrcnt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="discountPrcnt"
              id="reservation-daily-element-name-discountPrcnt"
              data-cy="discountPrcnt"
              :class="{ valid: !v$.discountPrcnt.$invalid, invalid: v$.discountPrcnt.$invalid }"
              v-model.number="v$.discountPrcnt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.discountReasonCode')"
              for="reservation-daily-element-name-discountReasonCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="discountReasonCode"
              id="reservation-daily-element-name-discountReasonCode"
              data-cy="discountReasonCode"
              :class="{ valid: !v$.discountReasonCode.$invalid, invalid: v$.discountReasonCode.$invalid }"
              v-model="v$.discountReasonCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.fixedRateYn')"
              for="reservation-daily-element-name-fixedRateYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="fixedRateYn"
              id="reservation-daily-element-name-fixedRateYn"
              data-cy="fixedRateYn"
              :class="{ valid: !v$.fixedRateYn.$invalid, invalid: v$.fixedRateYn.$invalid }"
              v-model="v$.fixedRateYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.baseRateAmount')"
              for="reservation-daily-element-name-baseRateAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="baseRateAmount"
              id="reservation-daily-element-name-baseRateAmount"
              data-cy="baseRateAmount"
              :class="{ valid: !v$.baseRateAmount.$invalid, invalid: v$.baseRateAmount.$invalid }"
              v-model.number="v$.baseRateAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.autoPostAmount')"
              for="reservation-daily-element-name-autoPostAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="autoPostAmount"
              id="reservation-daily-element-name-autoPostAmount"
              data-cy="autoPostAmount"
              :class="{ valid: !v$.autoPostAmount.$invalid, invalid: v$.autoPostAmount.$invalid }"
              v-model.number="v$.autoPostAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sharePriority')"
              for="reservation-daily-element-name-sharePriority"
            ></label>
            <input
              type="number"
              class="form-control"
              name="sharePriority"
              id="reservation-daily-element-name-sharePriority"
              data-cy="sharePriority"
              :class="{ valid: !v$.sharePriority.$invalid, invalid: v$.sharePriority.$invalid }"
              v-model.number="v$.sharePriority.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.insertUser')"
              for="reservation-daily-element-name-insertUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="reservation-daily-element-name-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.insertDate')"
              for="reservation-daily-element-name-insertDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-daily-element-name-insertDate"
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
                id="reservation-daily-element-name-insertDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.updateUser')"
              for="reservation-daily-element-name-updateUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="reservation-daily-element-name-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.updateDate')"
              for="reservation-daily-element-name-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="reservation-daily-element-name-updateDate"
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
                id="reservation-daily-element-name-updateDate"
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
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.lastShareCalculation')"
              for="reservation-daily-element-name-lastShareCalculation"
            ></label>
            <input
              type="text"
              class="form-control"
              name="lastShareCalculation"
              id="reservation-daily-element-name-lastShareCalculation"
              data-cy="lastShareCalculation"
              :class="{ valid: !v$.lastShareCalculation.$invalid, invalid: v$.lastShareCalculation.$invalid }"
              v-model="v$.lastShareCalculation.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.insertActionInstanceId')"
              for="reservation-daily-element-name-insertActionInstanceId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertActionInstanceId"
              id="reservation-daily-element-name-insertActionInstanceId"
              data-cy="insertActionInstanceId"
              :class="{ valid: !v$.insertActionInstanceId.$invalid, invalid: v$.insertActionInstanceId.$invalid }"
              v-model.number="v$.insertActionInstanceId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.dmlSeqNo')"
              for="reservation-daily-element-name-dmlSeqNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="dmlSeqNo"
              id="reservation-daily-element-name-dmlSeqNo"
              data-cy="dmlSeqNo"
              :class="{ valid: !v$.dmlSeqNo.$invalid, invalid: v$.dmlSeqNo.$invalid }"
              v-model.number="v$.dmlSeqNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.netRoomAmt')"
              for="reservation-daily-element-name-netRoomAmt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="netRoomAmt"
              id="reservation-daily-element-name-netRoomAmt"
              data-cy="netRoomAmt"
              :class="{ valid: !v$.netRoomAmt.$invalid, invalid: v$.netRoomAmt.$invalid }"
              v-model.number="v$.netRoomAmt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.roomTax')"
              for="reservation-daily-element-name-roomTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="roomTax"
              id="reservation-daily-element-name-roomTax"
              data-cy="roomTax"
              :class="{ valid: !v$.roomTax.$invalid, invalid: v$.roomTax.$invalid }"
              v-model.number="v$.roomTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.pkgAmt')"
              for="reservation-daily-element-name-pkgAmt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="pkgAmt"
              id="reservation-daily-element-name-pkgAmt"
              data-cy="pkgAmt"
              :class="{ valid: !v$.pkgAmt.$invalid, invalid: v$.pkgAmt.$invalid }"
              v-model.number="v$.pkgAmt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.pkgTax')"
              for="reservation-daily-element-name-pkgTax"
            ></label>
            <input
              type="number"
              class="form-control"
              name="pkgTax"
              id="reservation-daily-element-name-pkgTax"
              data-cy="pkgTax"
              :class="{ valid: !v$.pkgTax.$invalid, invalid: v$.pkgTax.$invalid }"
              v-model.number="v$.pkgTax.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.grossRateAmt')"
              for="reservation-daily-element-name-grossRateAmt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="grossRateAmt"
              id="reservation-daily-element-name-grossRateAmt"
              data-cy="grossRateAmt"
              :class="{ valid: !v$.grossRateAmt.$invalid, invalid: v$.grossRateAmt.$invalid }"
              v-model.number="v$.grossRateAmt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.adultsTaxFree')"
              for="reservation-daily-element-name-adultsTaxFree"
            ></label>
            <input
              type="number"
              class="form-control"
              name="adultsTaxFree"
              id="reservation-daily-element-name-adultsTaxFree"
              data-cy="adultsTaxFree"
              :class="{ valid: !v$.adultsTaxFree.$invalid, invalid: v$.adultsTaxFree.$invalid }"
              v-model.number="v$.adultsTaxFree.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.childrenTaxFree')"
              for="reservation-daily-element-name-childrenTaxFree"
            ></label>
            <input
              type="number"
              class="form-control"
              name="childrenTaxFree"
              id="reservation-daily-element-name-childrenTaxFree"
              data-cy="childrenTaxFree"
              :class="{ valid: !v$.childrenTaxFree.$invalid, invalid: v$.childrenTaxFree.$invalid }"
              v-model.number="v$.childrenTaxFree.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children1')"
              for="reservation-daily-element-name-children1"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children1"
              id="reservation-daily-element-name-children1"
              data-cy="children1"
              :class="{ valid: !v$.children1.$invalid, invalid: v$.children1.$invalid }"
              v-model.number="v$.children1.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children2')"
              for="reservation-daily-element-name-children2"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children2"
              id="reservation-daily-element-name-children2"
              data-cy="children2"
              :class="{ valid: !v$.children2.$invalid, invalid: v$.children2.$invalid }"
              v-model.number="v$.children2.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children3')"
              for="reservation-daily-element-name-children3"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children3"
              id="reservation-daily-element-name-children3"
              data-cy="children3"
              :class="{ valid: !v$.children3.$invalid, invalid: v$.children3.$invalid }"
              v-model.number="v$.children3.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.rateCode')"
              for="reservation-daily-element-name-rateCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rateCode"
              id="reservation-daily-element-name-rateCode"
              data-cy="rateCode"
              :class="{ valid: !v$.rateCode.$invalid, invalid: v$.rateCode.$invalid }"
              v-model="v$.rateCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.currencyCode')"
              for="reservation-daily-element-name-currencyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="currencyCode"
              id="reservation-daily-element-name-currencyCode"
              data-cy="currencyCode"
              :class="{ valid: !v$.currencyCode.$invalid, invalid: v$.currencyCode.$invalid }"
              v-model="v$.currencyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.exchangePostingType')"
              for="reservation-daily-element-name-exchangePostingType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="exchangePostingType"
              id="reservation-daily-element-name-exchangePostingType"
              data-cy="exchangePostingType"
              :class="{ valid: !v$.exchangePostingType.$invalid, invalid: v$.exchangePostingType.$invalid }"
              v-model="v$.exchangePostingType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.membershipPoints')"
              for="reservation-daily-element-name-membershipPoints"
            ></label>
            <input
              type="number"
              class="form-control"
              name="membershipPoints"
              id="reservation-daily-element-name-membershipPoints"
              data-cy="membershipPoints"
              :class="{ valid: !v$.membershipPoints.$invalid, invalid: v$.membershipPoints.$invalid }"
              v-model.number="v$.membershipPoints.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children4')"
              for="reservation-daily-element-name-children4"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children4"
              id="reservation-daily-element-name-children4"
              data-cy="children4"
              :class="{ valid: !v$.children4.$invalid, invalid: v$.children4.$invalid }"
              v-model.number="v$.children4.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children5')"
              for="reservation-daily-element-name-children5"
            ></label>
            <input
              type="number"
              class="form-control"
              name="children5"
              id="reservation-daily-element-name-children5"
              data-cy="children5"
              :class="{ valid: !v$.children5.$invalid, invalid: v$.children5.$invalid }"
              v-model.number="v$.children5.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.commissionCode')"
              for="reservation-daily-element-name-commissionCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="commissionCode"
              id="reservation-daily-element-name-commissionCode"
              data-cy="commissionCode"
              :class="{ valid: !v$.commissionCode.$invalid, invalid: v$.commissionCode.$invalid }"
              v-model="v$.commissionCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode1')"
              for="reservation-daily-element-name-awardCode1"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardCode1"
              id="reservation-daily-element-name-awardCode1"
              data-cy="awardCode1"
              :class="{ valid: !v$.awardCode1.$invalid, invalid: v$.awardCode1.$invalid }"
              v-model="v$.awardCode1.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode2')"
              for="reservation-daily-element-name-awardCode2"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardCode2"
              id="reservation-daily-element-name-awardCode2"
              data-cy="awardCode2"
              :class="{ valid: !v$.awardCode2.$invalid, invalid: v$.awardCode2.$invalid }"
              v-model="v$.awardCode2.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode3')"
              for="reservation-daily-element-name-awardCode3"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardCode3"
              id="reservation-daily-element-name-awardCode3"
              data-cy="awardCode3"
              :class="{ valid: !v$.awardCode3.$invalid, invalid: v$.awardCode3.$invalid }"
              v-model="v$.awardCode3.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode4')"
              for="reservation-daily-element-name-awardCode4"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardCode4"
              id="reservation-daily-element-name-awardCode4"
              data-cy="awardCode4"
              :class="{ valid: !v$.awardCode4.$invalid, invalid: v$.awardCode4.$invalid }"
              v-model="v$.awardCode4.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode5')"
              for="reservation-daily-element-name-awardCode5"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardCode5"
              id="reservation-daily-element-name-awardCode5"
              data-cy="awardCode5"
              :class="{ valid: !v$.awardCode5.$invalid, invalid: v$.awardCode5.$invalid }"
              v-model="v$.awardCode5.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher1')"
              for="reservation-daily-element-name-awardVoucher1"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardVoucher1"
              id="reservation-daily-element-name-awardVoucher1"
              data-cy="awardVoucher1"
              :class="{ valid: !v$.awardVoucher1.$invalid, invalid: v$.awardVoucher1.$invalid }"
              v-model="v$.awardVoucher1.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher2')"
              for="reservation-daily-element-name-awardVoucher2"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardVoucher2"
              id="reservation-daily-element-name-awardVoucher2"
              data-cy="awardVoucher2"
              :class="{ valid: !v$.awardVoucher2.$invalid, invalid: v$.awardVoucher2.$invalid }"
              v-model="v$.awardVoucher2.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher3')"
              for="reservation-daily-element-name-awardVoucher3"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardVoucher3"
              id="reservation-daily-element-name-awardVoucher3"
              data-cy="awardVoucher3"
              :class="{ valid: !v$.awardVoucher3.$invalid, invalid: v$.awardVoucher3.$invalid }"
              v-model="v$.awardVoucher3.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher4')"
              for="reservation-daily-element-name-awardVoucher4"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardVoucher4"
              id="reservation-daily-element-name-awardVoucher4"
              data-cy="awardVoucher4"
              :class="{ valid: !v$.awardVoucher4.$invalid, invalid: v$.awardVoucher4.$invalid }"
              v-model="v$.awardVoucher4.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher5')"
              for="reservation-daily-element-name-awardVoucher5"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardVoucher5"
              id="reservation-daily-element-name-awardVoucher5"
              data-cy="awardVoucher5"
              :class="{ valid: !v$.awardVoucher5.$invalid, invalid: v$.awardVoucher5.$invalid }"
              v-model="v$.awardVoucher5.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.doNotMoveYn')"
              for="reservation-daily-element-name-doNotMoveYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="doNotMoveYn"
              id="reservation-daily-element-name-doNotMoveYn"
              data-cy="doNotMoveYn"
              :class="{ valid: !v$.doNotMoveYn.$invalid, invalid: v$.doNotMoveYn.$invalid }"
              v-model="v$.doNotMoveYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode')"
              for="reservation-daily-element-name-awardCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="awardCode"
              id="reservation-daily-element-name-awardCode"
              data-cy="awardCode"
              :class="{ valid: !v$.awardCode.$invalid, invalid: v$.awardCode.$invalid }"
              v-model="v$.awardCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.points')"
              for="reservation-daily-element-name-points"
            ></label>
            <input
              type="number"
              class="form-control"
              name="points"
              id="reservation-daily-element-name-points"
              data-cy="points"
              :class="{ valid: !v$.points.$invalid, invalid: v$.points.$invalid }"
              v-model.number="v$.points.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.upsellCharge')"
              for="reservation-daily-element-name-upsellCharge"
            ></label>
            <input
              type="number"
              class="form-control"
              name="upsellCharge"
              id="reservation-daily-element-name-upsellCharge"
              data-cy="upsellCharge"
              :class="{ valid: !v$.upsellCharge.$invalid, invalid: v$.upsellCharge.$invalid }"
              v-model.number="v$.upsellCharge.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.pointsEligibilityCode')"
              for="reservation-daily-element-name-pointsEligibilityCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="pointsEligibilityCode"
              id="reservation-daily-element-name-pointsEligibilityCode"
              data-cy="pointsEligibilityCode"
              :class="{ valid: !v$.pointsEligibilityCode.$invalid, invalid: v$.pointsEligibilityCode.$invalid }"
              v-model="v$.pointsEligibilityCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.commissionPaid')"
              for="reservation-daily-element-name-commissionPaid"
            ></label>
            <input
              type="number"
              class="form-control"
              name="commissionPaid"
              id="reservation-daily-element-name-commissionPaid"
              data-cy="commissionPaid"
              :class="{ valid: !v$.commissionPaid.$invalid, invalid: v$.commissionPaid.$invalid }"
              v-model.number="v$.commissionPaid.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resvContactId')"
              for="reservation-daily-element-name-resvContactId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="resvContactId"
              id="reservation-daily-element-name-resvContactId"
              data-cy="resvContactId"
              :class="{ valid: !v$.resvContactId.$invalid, invalid: v$.resvContactId.$invalid }"
              v-model.number="v$.resvContactId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.billingContactId')"
              for="reservation-daily-element-name-billingContactId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="billingContactId"
              id="reservation-daily-element-name-billingContactId"
              data-cy="billingContactId"
              :class="{ valid: !v$.billingContactId.$invalid, invalid: v$.billingContactId.$invalid }"
              v-model.number="v$.billingContactId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.shareAmountOriginal')"
              for="reservation-daily-element-name-shareAmountOriginal"
            ></label>
            <input
              type="number"
              class="form-control"
              name="shareAmountOriginal"
              id="reservation-daily-element-name-shareAmountOriginal"
              data-cy="shareAmountOriginal"
              :class="{ valid: !v$.shareAmountOriginal.$invalid, invalid: v$.shareAmountOriginal.$invalid }"
              v-model.number="v$.shareAmountOriginal.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.referralYn')"
              for="reservation-daily-element-name-referralYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="referralYn"
              id="reservation-daily-element-name-referralYn"
              data-cy="referralYn"
              :class="{ valid: !v$.referralYn.$invalid, invalid: v$.referralYn.$invalid }"
              v-model="v$.referralYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.bxgyDiscountYn')"
              for="reservation-daily-element-name-bxgyDiscountYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="bxgyDiscountYn"
              id="reservation-daily-element-name-bxgyDiscountYn"
              data-cy="bxgyDiscountYn"
              :class="{ valid: !v$.bxgyDiscountYn.$invalid, invalid: v$.bxgyDiscountYn.$invalid }"
              v-model="v$.bxgyDiscountYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.commissionableYn')"
              for="reservation-daily-element-name-commissionableYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="commissionableYn"
              id="reservation-daily-element-name-commissionableYn"
              data-cy="commissionableYn"
              :class="{ valid: !v$.commissionableYn.$invalid, invalid: v$.commissionableYn.$invalid }"
              v-model="v$.commissionableYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.basedOnRule')"
              for="reservation-daily-element-name-basedOnRule"
            ></label>
            <input
              type="text"
              class="form-control"
              name="basedOnRule"
              id="reservation-daily-element-name-basedOnRule"
              data-cy="basedOnRule"
              :class="{ valid: !v$.basedOnRule.$invalid, invalid: v$.basedOnRule.$invalid }"
              v-model="v$.basedOnRule.$model"
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
<script lang="ts" src="./reservation-daily-element-name-update.component.ts"></script>
