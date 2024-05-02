<template>
  <div>
    <h2 id="page-heading" data-cy="ReservationDailyElementNameHeading">
      <span
        v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.home.title')"
        id="reservation-daily-element-name-heading"
      ></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ReservationDailyElementNameCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-reservation-daily-element-name"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && reservationDailyElementNames && reservationDailyElementNames.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="reservationDailyElementNames && reservationDailyElementNames.length > 0">
      <table class="table table-striped" aria-describedby="reservationDailyElementNames">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resort')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvNameId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resvNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reservationDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.reservationDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reservationDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvDailyElSeq')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resvDailyElSeq')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvDailyElSeq'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('travelAgentId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.travelAgentId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'travelAgentId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('companyId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.companyId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'companyId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sourceId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sourceId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sourceId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('groupId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.groupId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'groupId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sharePaymentType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sharePaymentType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sharePaymentType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('shareAmount')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.shareAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'shareAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sharePrcnt')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sharePrcnt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sharePrcnt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('adults')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.adults')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'adults'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('discountAmt')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.discountAmt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'discountAmt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('discountPrcnt')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.discountPrcnt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'discountPrcnt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('discountReasonCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.discountReasonCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'discountReasonCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fixedRateYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.fixedRateYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fixedRateYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('baseRateAmount')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.baseRateAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'baseRateAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('autoPostAmount')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.autoPostAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoPostAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sharePriority')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sharePriority')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sharePriority'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lastShareCalculation')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.lastShareCalculation')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lastShareCalculation'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertActionInstanceId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.insertActionInstanceId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertActionInstanceId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dmlSeqNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.dmlSeqNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dmlSeqNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('netRoomAmt')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.netRoomAmt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'netRoomAmt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.roomTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('pkgAmt')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.pkgAmt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pkgAmt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('pkgTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.pkgTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pkgTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('grossRateAmt')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.grossRateAmt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'grossRateAmt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('adultsTaxFree')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.adultsTaxFree')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'adultsTaxFree'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('childrenTaxFree')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.childrenTaxFree')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'childrenTaxFree'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children1')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children2')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children3')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.rateCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('currencyCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.currencyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'currencyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('exchangePostingType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.exchangePostingType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exchangePostingType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('membershipPoints')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.membershipPoints')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'membershipPoints'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children4')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children4')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children4'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children5')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children5')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children5'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('commissionCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.commissionCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commissionCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardCode1')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardCode1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardCode2')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardCode2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardCode3')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardCode3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardCode4')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode4')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardCode4'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardCode5')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode5')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardCode5'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardVoucher1')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardVoucher1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardVoucher2')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardVoucher2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardVoucher3')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardVoucher3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardVoucher4')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher4')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardVoucher4'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardVoucher5')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher5')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardVoucher5'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('doNotMoveYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.doNotMoveYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'doNotMoveYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('points')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.points')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'points'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('upsellCharge')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.upsellCharge')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upsellCharge'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('pointsEligibilityCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.pointsEligibilityCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pointsEligibilityCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('commissionPaid')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.commissionPaid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commissionPaid'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvContactId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resvContactId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvContactId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('billingContactId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.billingContactId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'billingContactId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('shareAmountOriginal')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.shareAmountOriginal')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'shareAmountOriginal'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('referralYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.referralYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'referralYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bxgyDiscountYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.bxgyDiscountYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bxgyDiscountYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('commissionableYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.commissionableYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commissionableYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('basedOnRule')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.basedOnRule')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'basedOnRule'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="reservationDailyElementName in reservationDailyElementNames"
            :key="reservationDailyElementName.id"
            data-cy="entityTable"
          >
            <td>
              <router-link
                :to="{ name: 'ReservationDailyElementNameView', params: { reservationDailyElementNameId: reservationDailyElementName.id } }"
                >{{ reservationDailyElementName.id }}</router-link
              >
            </td>
            <td>{{ reservationDailyElementName.resort }}</td>
            <td>{{ reservationDailyElementName.resvNameId }}</td>
            <td>{{ reservationDailyElementName.reservationDate }}</td>
            <td>{{ reservationDailyElementName.resvDailyElSeq }}</td>
            <td>{{ reservationDailyElementName.travelAgentId }}</td>
            <td>{{ reservationDailyElementName.companyId }}</td>
            <td>{{ reservationDailyElementName.sourceId }}</td>
            <td>{{ reservationDailyElementName.groupId }}</td>
            <td>{{ reservationDailyElementName.sharePaymentType }}</td>
            <td>{{ reservationDailyElementName.shareAmount }}</td>
            <td>{{ reservationDailyElementName.sharePrcnt }}</td>
            <td>{{ reservationDailyElementName.adults }}</td>
            <td>{{ reservationDailyElementName.children }}</td>
            <td>{{ reservationDailyElementName.discountAmt }}</td>
            <td>{{ reservationDailyElementName.discountPrcnt }}</td>
            <td>{{ reservationDailyElementName.discountReasonCode }}</td>
            <td>{{ reservationDailyElementName.fixedRateYn }}</td>
            <td>{{ reservationDailyElementName.baseRateAmount }}</td>
            <td>{{ reservationDailyElementName.autoPostAmount }}</td>
            <td>{{ reservationDailyElementName.sharePriority }}</td>
            <td>{{ reservationDailyElementName.insertUser }}</td>
            <td>{{ reservationDailyElementName.insertDate }}</td>
            <td>{{ reservationDailyElementName.updateUser }}</td>
            <td>{{ reservationDailyElementName.updateDate }}</td>
            <td>{{ reservationDailyElementName.lastShareCalculation }}</td>
            <td>{{ reservationDailyElementName.insertActionInstanceId }}</td>
            <td>{{ reservationDailyElementName.dmlSeqNo }}</td>
            <td>{{ reservationDailyElementName.netRoomAmt }}</td>
            <td>{{ reservationDailyElementName.roomTax }}</td>
            <td>{{ reservationDailyElementName.pkgAmt }}</td>
            <td>{{ reservationDailyElementName.pkgTax }}</td>
            <td>{{ reservationDailyElementName.grossRateAmt }}</td>
            <td>{{ reservationDailyElementName.adultsTaxFree }}</td>
            <td>{{ reservationDailyElementName.childrenTaxFree }}</td>
            <td>{{ reservationDailyElementName.children1 }}</td>
            <td>{{ reservationDailyElementName.children2 }}</td>
            <td>{{ reservationDailyElementName.children3 }}</td>
            <td>{{ reservationDailyElementName.rateCode }}</td>
            <td>{{ reservationDailyElementName.currencyCode }}</td>
            <td>{{ reservationDailyElementName.exchangePostingType }}</td>
            <td>{{ reservationDailyElementName.membershipPoints }}</td>
            <td>{{ reservationDailyElementName.children4 }}</td>
            <td>{{ reservationDailyElementName.children5 }}</td>
            <td>{{ reservationDailyElementName.commissionCode }}</td>
            <td>{{ reservationDailyElementName.awardCode1 }}</td>
            <td>{{ reservationDailyElementName.awardCode2 }}</td>
            <td>{{ reservationDailyElementName.awardCode3 }}</td>
            <td>{{ reservationDailyElementName.awardCode4 }}</td>
            <td>{{ reservationDailyElementName.awardCode5 }}</td>
            <td>{{ reservationDailyElementName.awardVoucher1 }}</td>
            <td>{{ reservationDailyElementName.awardVoucher2 }}</td>
            <td>{{ reservationDailyElementName.awardVoucher3 }}</td>
            <td>{{ reservationDailyElementName.awardVoucher4 }}</td>
            <td>{{ reservationDailyElementName.awardVoucher5 }}</td>
            <td>{{ reservationDailyElementName.doNotMoveYn }}</td>
            <td>{{ reservationDailyElementName.awardCode }}</td>
            <td>{{ reservationDailyElementName.points }}</td>
            <td>{{ reservationDailyElementName.upsellCharge }}</td>
            <td>{{ reservationDailyElementName.pointsEligibilityCode }}</td>
            <td>{{ reservationDailyElementName.commissionPaid }}</td>
            <td>{{ reservationDailyElementName.resvContactId }}</td>
            <td>{{ reservationDailyElementName.billingContactId }}</td>
            <td>{{ reservationDailyElementName.shareAmountOriginal }}</td>
            <td>{{ reservationDailyElementName.referralYn }}</td>
            <td>{{ reservationDailyElementName.bxgyDiscountYn }}</td>
            <td>{{ reservationDailyElementName.commissionableYn }}</td>
            <td>{{ reservationDailyElementName.basedOnRule }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{
                    name: 'ReservationDailyElementNameView',
                    params: { reservationDailyElementNameId: reservationDailyElementName.id },
                  }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link
                  :to="{
                    name: 'ReservationDailyElementNameEdit',
                    params: { reservationDailyElementNameId: reservationDailyElementName.id },
                  }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(reservationDailyElementName)"
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
          id="operaHandlerApplicationApp.reservationDailyElementName.delete.question"
          data-cy="reservationDailyElementNameDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p
          id="jhi-delete-reservationDailyElementName-heading"
          v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.delete.question', { id: removeId })"
        ></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-reservationDailyElementName"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeReservationDailyElementName()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="reservationDailyElementNames && reservationDailyElementNames.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./reservation-daily-element-name.component.ts"></script>
