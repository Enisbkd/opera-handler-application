<template>
  <div>
    <h2 id="page-heading" data-cy="ReservationNameHeading">
      <span v-text="t$('operaHandlerApplicationApp.reservationName.home.title')" id="reservation-name-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.reservationName.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ReservationNameCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-reservation-name"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && reservationNames && reservationNames.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.reservationName.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="reservationNames && reservationNames.length > 0">
      <table class="table table-striped" aria-describedby="reservationNames">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resort')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.resort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvNameId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.resvNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.nameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameUsageType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.nameUsageType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameUsageType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contactNameId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.contactNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contactNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.resvStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('commissionCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.commissionCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commissionCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('addressId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.addressId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'addressId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('phoneId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.phoneId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'phoneId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('faxYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.faxYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'faxYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mailYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.mailYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mailYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('printRateYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.printRateYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'printRateYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reportId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.reportId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reportId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.resvNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('confirmationNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.confirmationNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'confirmationNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('beginDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.beginDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'beginDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('endDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.endDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'endDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('faxId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.faxId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'faxId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('emailId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.emailId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'emailId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('emailYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.emailYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'emailYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('consumerYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.consumerYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'consumerYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('creditCardId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.creditCardId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'creditCardId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('financiallyResponsibleYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.financiallyResponsibleYn')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'financiallyResponsibleYn'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('paymentMethod')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.paymentMethod')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'paymentMethod'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('intermediaryYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.intermediaryYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'intermediaryYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postingAllowedYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.postingAllowedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postingAllowedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('displayColor')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.displayColor')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'displayColor'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('actualCheckInDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.actualCheckInDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'actualCheckInDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('truncActualCheckInDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.truncActualCheckInDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'truncActualCheckInDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('actualCheckOutDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.actualCheckOutDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'actualCheckOutDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('truncActualCheckOutDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.truncActualCheckOutDate')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'truncActualCheckOutDate'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('creditLimit')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.creditLimit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'creditLimit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('authorizedBy')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.authorizedBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'authorizedBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('parentResvNameId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.parentResvNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'parentResvNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancellationNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.cancellationNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancellationNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancellationReasonCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.cancellationReasonCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancellationReasonCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancellationReasonDesc')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.cancellationReasonDesc')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancellationReasonDesc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrivalTransportType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalTransportType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrivalTransportType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrivalStationCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalStationCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrivalStationCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrivalCarrierCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalCarrierCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrivalCarrierCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrivalTransportCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalTransportCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrivalTransportCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrivalDateTime')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalDateTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrivalDateTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrivalEstimateTime')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalEstimateTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrivalEstimateTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrivalTranportationYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalTranportationYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrivalTranportationYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrivalComments')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalComments')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrivalComments'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('departureTransportType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.departureTransportType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'departureTransportType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('departureStationCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.departureStationCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'departureStationCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('departureCarrierCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.departureCarrierCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'departureCarrierCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('departureTransportCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.departureTransportCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'departureTransportCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('departureDateTime')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.departureDateTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'departureDateTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('departureEstimateTime')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.departureEstimateTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'departureEstimateTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('departureTransportationYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.departureTransportationYn')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'departureTransportationYn'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('departureComments')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.departureComments')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'departureComments'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancellationDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.cancellationDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancellationDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guaranteeCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.guaranteeCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guaranteeCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('wlReasonDescription')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.wlReasonDescription')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'wlReasonDescription'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('wlReasonCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.wlReasonCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'wlReasonCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('wlPriority')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.wlPriority')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'wlPriority'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('doNotMoveRoom')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.doNotMoveRoom')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'doNotMoveRoom'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('externalReference')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.externalReference')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'externalReference'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('partyCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.partyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'partyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('walkinYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.walkinYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'walkinYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('originalEndDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.originalEndDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'originalEndDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('approvalAmountCalcMethod')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.approvalAmountCalcMethod')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'approvalAmountCalcMethod'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('amountPercent')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.amountPercent')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'amountPercent'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameTaxType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.nameTaxType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameTaxType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxExemptNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.taxExemptNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxExemptNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomFeatures')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.roomFeatures')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomFeatures'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('wlTelephoneNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.wlTelephoneNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'wlTelephoneNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('videoCheckoutYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.videoCheckoutYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'videoCheckoutYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('discountAmt')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.discountAmt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'discountAmt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('discountPrcnt')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.discountPrcnt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'discountPrcnt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('discountReasonCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.discountReasonCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'discountReasonCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('commissionPaid')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.commissionPaid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commissionPaid'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('commissionHoldCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.commissionHoldCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commissionHoldCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('truncBeginDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.truncBeginDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'truncBeginDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('truncEndDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.truncEndDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'truncEndDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sguestName')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.sguestName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sguestName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('membershipId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.membershipId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'membershipId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc01')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc01')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc01'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc02')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc02')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc02'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc03')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc03')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc03'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc04')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc04')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc04'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc05')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc05')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc05'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc06')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc06')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc06'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc07')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc07')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc07'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc08')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc08')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc08'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc09')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc09')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc09'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc10')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc10')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc10'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc11')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc11')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc11'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc12')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc12')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc12'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc13')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc13')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc13'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc14')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc14')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc14'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc15')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc15')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc15'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc16')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc16')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc16'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc17')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc17')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc17'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc18')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc18')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc18'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc19')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc19')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc19'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc20')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc20')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc20'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc21')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc21')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc21'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc22')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc22')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc22'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc23')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc23')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc23'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc24')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc24')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc24'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc25')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc25')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc25'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc26')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc26')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc26'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc27')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc27')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc27'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc28')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc28')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc28'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc29')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc29')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc29'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc30')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc30')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc30'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc31')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc31')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc31'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc32')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc32')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc32'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc33')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc33')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc33'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc34')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc34')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc34'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc35')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc35')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc35'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc36')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc36')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc36'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc37')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc37')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc37'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc38')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc38')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc38'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc39')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc39')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc39'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc40')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc40')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc40'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn01')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn01')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn01'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn02')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn02')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn02'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn03')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn03')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn03'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn04')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn04')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn04'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn05')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn05')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn05'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn06')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn06')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn06'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn07')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn07')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn07'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn08')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn08')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn08'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn09')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn09')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn09'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn10')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn10')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn10'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn11')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn11')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn11'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn12')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn12')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn12'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn13')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn13')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn13'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn14')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn14')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn14'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn15')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn15')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn15'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn16')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn16')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn16'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn17')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn17')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn17'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn18')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn18')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn18'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn19')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn19')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn19'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn20')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn20')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn20'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn21')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn21')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn21'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn22')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn22')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn22'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn23')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn23')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn23'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn24')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn24')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn24'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn25')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn25')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn25'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn26')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn26')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn26'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn27')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn27')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn27'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn28')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn28')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn28'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn29')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn29')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn29'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn30')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn30')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn30'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn31')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn31')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn31'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn32')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn32')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn32'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn33')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn33')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn33'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn34')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn34')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn34'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn35')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn35')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn35'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn36')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn36')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn36'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn37')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn37')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn37'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn38')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn38')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn38'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn39')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn39')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn39'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn40')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn40')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn40'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd01')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd01')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd01'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd02')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd02')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd02'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd03')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd03')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd03'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd04')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd04')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd04'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd05')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd05')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd05'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd06')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd06')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd06'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd07')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd07')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd07'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd08')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd08')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd08'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd09')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd09')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd09'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd10')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd10')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd10'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertActionInstanceId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.insertActionInstanceId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertActionInstanceId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dmlSeqNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.dmlSeqNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dmlSeqNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('businessDateCreated')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.businessDateCreated')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'businessDateCreated'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('turndownYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.turndownYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'turndownYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomInstructions')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.roomInstructions')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomInstructions'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomServiceTime')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.roomServiceTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomServiceTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('eventId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.eventId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'eventId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('revenueTypeCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.revenueTypeCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'revenueTypeCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hurdle')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.hurdle')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hurdle'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hurdleOverride')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.hurdleOverride')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hurdleOverride'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateableValue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.rateableValue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateableValue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('restrictionOverride')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.restrictionOverride')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'restrictionOverride'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('yieldableYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.yieldableYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'yieldableYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sguestFirstname')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.sguestFirstname')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sguestFirstname'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestLastName')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.guestLastName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestLastName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestFirstName')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.guestFirstName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestFirstName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestLastNameSdx')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.guestLastNameSdx')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestLastNameSdx'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestFirstNameSdx')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.guestFirstNameSdx')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestFirstNameSdx'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('channel')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.channel')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'channel'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('shareSeqNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.shareSeqNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'shareSeqNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestSignature')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.guestSignature')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestSignature'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extensionId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.extensionId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extensionId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvContactId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.resvContactId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvContactId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('billingContactId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.billingContactId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'billingContactId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resInsertSource')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.resInsertSource')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resInsertSource'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resInsertSourceType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.resInsertSourceType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resInsertSourceType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('masterShare')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.masterShare')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'masterShare'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('registrationCardNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.registrationCardNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'registrationCardNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tiad')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.tiad')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tiad'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('purposeOfStay')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.purposeOfStay')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'purposeOfStay'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reinstateDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.reinstateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reinstateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('purgeDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.purgeDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'purgeDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lastSettleDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.lastSettleDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lastSettleDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lastPeriodicFolioDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.lastPeriodicFolioDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lastPeriodicFolioDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('periodicFolioFreq')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.periodicFolioFreq')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'periodicFolioFreq'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('confirmationLegNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.confirmationLegNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'confirmationLegNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.guestStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.guestType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('checkinDuration')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.checkinDuration')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'checkinDuration'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('authorizerId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.authorizerId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'authorizerId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lastOnlinePrintSeq')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.lastOnlinePrintSeq')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lastOnlinePrintSeq'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('entryPoint')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.entryPoint')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'entryPoint'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('entryDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.entryDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'entryDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('pseudoMemType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.pseudoMemType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pseudoMemType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('pseudoMemTotalPoints')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.pseudoMemTotalPoints')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pseudoMemTotalPoints'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioText1')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.folioText1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioText1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioText2')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.folioText2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioText2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('compTypeCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.compTypeCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'compTypeCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('uniCardId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.uniCardId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uniCardId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('expCheckinresId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.expCheckinresId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'expCheckinresId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('originalBeginDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.originalBeginDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'originalBeginDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ownerFfFlag')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.ownerFfFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ownerFfFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('commissionPayoutTo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.commissionPayoutTo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commissionPayoutTo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('preChargingYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.preChargingYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'preChargingYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postChargingYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.postChargingYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postChargingYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postCoFlag')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.postCoFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postCoFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioCloseDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.folioCloseDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioCloseDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('scheduleCheckoutYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.scheduleCheckoutYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'scheduleCheckoutYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('customReference')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.customReference')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'customReference'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guaranteeCodePreCi')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.guaranteeCodePreCi')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guaranteeCodePreCi'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardMembershipId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.awardMembershipId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardMembershipId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('esignedRegCardName')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.esignedRegCardName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'esignedRegCardName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('statisticalRoomType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.statisticalRoomType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'statisticalRoomType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('statisticalRateTier')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.statisticalRateTier')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'statisticalRateTier'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ymCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.ymCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ymCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('keyValidUntil')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.keyValidUntil')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'keyValidUntil'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('preRegisteredYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.preRegisteredYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'preRegisteredYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxRegistrationNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.taxRegistrationNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxRegistrationNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('visaNumber')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.visaNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'visaNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('visaIssueDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.visaIssueDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'visaIssueDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('visaExpirationDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.visaExpirationDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'visaExpirationDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxNoOfStays')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.taxNoOfStays')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxNoOfStays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('asbProratedYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.asbProratedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'asbProratedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('autoSettleDays')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.autoSettleDays')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoSettleDays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('autoSettleYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.autoSettleYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoSettleYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('splitFromResvNameId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.splitFromResvNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'splitFromResvNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nextDestination')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.nextDestination')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nextDestination'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dateOfArrivalInCountry')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.dateOfArrivalInCountry')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dateOfArrivalInCountry'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('preArrReviewedDt')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.preArrReviewedDt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'preArrReviewedDt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('preArrReviewedUser')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.preArrReviewedUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'preArrReviewedUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bonusCheckId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.bonusCheckId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bonusCheckId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mobileAudioKeyYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.mobileAudioKeyYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mobileAudioKeyYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('directBillVerifyResponse')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.directBillVerifyResponse')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'directBillVerifyResponse'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('addresseeNameId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.addresseeNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'addresseeNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('superSearchIndexText')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.superSearchIndexText')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'superSearchIndexText'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('autoCheckinYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.autoCheckinYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoCheckinYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('emailFolioYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.emailFolioYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'emailFolioYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('emailAddress')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.emailAddress')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'emailAddress'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('spgUpgradeConfirmedRoomtype')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.spgUpgradeConfirmedRoomtype')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'spgUpgradeConfirmedRoomtype'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('spgUpgradeReasonCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.spgUpgradeReasonCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'spgUpgradeReasonCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('spgSuiteNightAwardStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.spgSuiteNightAwardStatus')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'spgSuiteNightAwardStatus'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('spgDiscloseRoomTypeYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.spgDiscloseRoomTypeYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'spgDiscloseRoomTypeYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('amenityEligibleYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.amenityEligibleYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'amenityEligibleYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('amenityLevelCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.amenityLevelCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'amenityLevelCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('baseRateCurrencyCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.baseRateCurrencyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'baseRateCurrencyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('baseRateCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.baseRateCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'baseRateCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('localBaseRateAmount')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.localBaseRateAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'localBaseRateAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('phoneDisplayNameYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.phoneDisplayNameYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'phoneDisplayNameYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resortChargeNumber')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.resortChargeNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resortChargeNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mobileChkoutAllowed')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.mobileChkoutAllowed')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mobileChkoutAllowed'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mobileViewFolioAllowed')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.mobileViewFolioAllowed')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mobileViewFolioAllowed'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hkExpectedServiceTime')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.hkExpectedServiceTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hkExpectedServiceTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('eligibleForUpgradeYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.eligibleForUpgradeYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'eligibleForUpgradeYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('beginSystemDateTime')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.beginSystemDateTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'beginSystemDateTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mobileCheckinAllowedYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.mobileCheckinAllowedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mobileCheckinAllowedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('quoteId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.quoteId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'quoteId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('manualCheckoutStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.manualCheckoutStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'manualCheckoutStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mobilePreferredCurrency')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.mobilePreferredCurrency')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'mobilePreferredCurrency'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mobileActionAlertIssued')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.mobileActionAlertIssued')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'mobileActionAlertIssued'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('externalEfolioYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.externalEfolioYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'externalEfolioYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('optInBatchFolYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.optInBatchFolYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'optInBatchFolYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioAddrElementId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.folioAddrElementId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioAddrElementId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('operaEsignedRegCardYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.operaEsignedRegCardYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'operaEsignedRegCardYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvGuid')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.resvGuid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvGuid'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advanceCheckedInYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.advanceCheckedInYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advanceCheckedInYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('expectedTimeOfReturn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.expectedTimeOfReturn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'expectedTimeOfReturn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('etrComments')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.etrComments')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'etrComments'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('optedForCommYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.optedForCommYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'optedForCommYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('creditLimitAutoPayAllowYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationName.creditLimitAutoPayAllowYn')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'creditLimitAutoPayAllowYn'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="reservationName in reservationNames" :key="reservationName.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ReservationNameView', params: { reservationNameId: reservationName.id } }">{{
                reservationName.id
              }}</router-link>
            </td>
            <td>{{ reservationName.resort }}</td>
            <td>{{ reservationName.resvNameId }}</td>
            <td>{{ reservationName.nameId }}</td>
            <td>{{ reservationName.nameUsageType }}</td>
            <td>{{ reservationName.contactNameId }}</td>
            <td>{{ reservationName.insertDate }}</td>
            <td>{{ reservationName.insertUser }}</td>
            <td>{{ reservationName.updateUser }}</td>
            <td>{{ reservationName.updateDate }}</td>
            <td>{{ reservationName.resvStatus }}</td>
            <td>{{ reservationName.commissionCode }}</td>
            <td>{{ reservationName.addressId }}</td>
            <td>{{ reservationName.phoneId }}</td>
            <td>{{ reservationName.faxYn }}</td>
            <td>{{ reservationName.mailYn }}</td>
            <td>{{ reservationName.printRateYn }}</td>
            <td>{{ reservationName.reportId }}</td>
            <td>{{ reservationName.resvNo }}</td>
            <td>{{ reservationName.confirmationNo }}</td>
            <td>{{ reservationName.beginDate }}</td>
            <td>{{ reservationName.endDate }}</td>
            <td>{{ reservationName.faxId }}</td>
            <td>{{ reservationName.emailId }}</td>
            <td>{{ reservationName.emailYn }}</td>
            <td>{{ reservationName.consumerYn }}</td>
            <td>{{ reservationName.creditCardId }}</td>
            <td>{{ reservationName.financiallyResponsibleYn }}</td>
            <td>{{ reservationName.paymentMethod }}</td>
            <td>{{ reservationName.intermediaryYn }}</td>
            <td>{{ reservationName.postingAllowedYn }}</td>
            <td>{{ reservationName.displayColor }}</td>
            <td>{{ reservationName.actualCheckInDate }}</td>
            <td>{{ reservationName.truncActualCheckInDate }}</td>
            <td>{{ reservationName.actualCheckOutDate }}</td>
            <td>{{ reservationName.truncActualCheckOutDate }}</td>
            <td>{{ reservationName.creditLimit }}</td>
            <td>{{ reservationName.authorizedBy }}</td>
            <td>{{ reservationName.parentResvNameId }}</td>
            <td>{{ reservationName.cancellationNo }}</td>
            <td>{{ reservationName.cancellationReasonCode }}</td>
            <td>{{ reservationName.cancellationReasonDesc }}</td>
            <td>{{ reservationName.arrivalTransportType }}</td>
            <td>{{ reservationName.arrivalStationCode }}</td>
            <td>{{ reservationName.arrivalCarrierCode }}</td>
            <td>{{ reservationName.arrivalTransportCode }}</td>
            <td>{{ reservationName.arrivalDateTime }}</td>
            <td>{{ reservationName.arrivalEstimateTime }}</td>
            <td>{{ reservationName.arrivalTranportationYn }}</td>
            <td>{{ reservationName.arrivalComments }}</td>
            <td>{{ reservationName.departureTransportType }}</td>
            <td>{{ reservationName.departureStationCode }}</td>
            <td>{{ reservationName.departureCarrierCode }}</td>
            <td>{{ reservationName.departureTransportCode }}</td>
            <td>{{ reservationName.departureDateTime }}</td>
            <td>{{ reservationName.departureEstimateTime }}</td>
            <td>{{ reservationName.departureTransportationYn }}</td>
            <td>{{ reservationName.departureComments }}</td>
            <td>{{ reservationName.cancellationDate }}</td>
            <td>{{ reservationName.guaranteeCode }}</td>
            <td>{{ reservationName.wlReasonDescription }}</td>
            <td>{{ reservationName.wlReasonCode }}</td>
            <td>{{ reservationName.wlPriority }}</td>
            <td>{{ reservationName.doNotMoveRoom }}</td>
            <td>{{ reservationName.externalReference }}</td>
            <td>{{ reservationName.partyCode }}</td>
            <td>{{ reservationName.walkinYn }}</td>
            <td>{{ reservationName.originalEndDate }}</td>
            <td>{{ reservationName.approvalAmountCalcMethod }}</td>
            <td>{{ reservationName.amountPercent }}</td>
            <td>{{ reservationName.nameTaxType }}</td>
            <td>{{ reservationName.taxExemptNo }}</td>
            <td>{{ reservationName.roomFeatures }}</td>
            <td>{{ reservationName.wlTelephoneNo }}</td>
            <td>{{ reservationName.videoCheckoutYn }}</td>
            <td>{{ reservationName.discountAmt }}</td>
            <td>{{ reservationName.discountPrcnt }}</td>
            <td>{{ reservationName.discountReasonCode }}</td>
            <td>{{ reservationName.commissionPaid }}</td>
            <td>{{ reservationName.commissionHoldCode }}</td>
            <td>{{ reservationName.truncBeginDate }}</td>
            <td>{{ reservationName.truncEndDate }}</td>
            <td>{{ reservationName.sguestName }}</td>
            <td>{{ reservationName.membershipId }}</td>
            <td>{{ reservationName.udfc01 }}</td>
            <td>{{ reservationName.udfc02 }}</td>
            <td>{{ reservationName.udfc03 }}</td>
            <td>{{ reservationName.udfc04 }}</td>
            <td>{{ reservationName.udfc05 }}</td>
            <td>{{ reservationName.udfc06 }}</td>
            <td>{{ reservationName.udfc07 }}</td>
            <td>{{ reservationName.udfc08 }}</td>
            <td>{{ reservationName.udfc09 }}</td>
            <td>{{ reservationName.udfc10 }}</td>
            <td>{{ reservationName.udfc11 }}</td>
            <td>{{ reservationName.udfc12 }}</td>
            <td>{{ reservationName.udfc13 }}</td>
            <td>{{ reservationName.udfc14 }}</td>
            <td>{{ reservationName.udfc15 }}</td>
            <td>{{ reservationName.udfc16 }}</td>
            <td>{{ reservationName.udfc17 }}</td>
            <td>{{ reservationName.udfc18 }}</td>
            <td>{{ reservationName.udfc19 }}</td>
            <td>{{ reservationName.udfc20 }}</td>
            <td>{{ reservationName.udfc21 }}</td>
            <td>{{ reservationName.udfc22 }}</td>
            <td>{{ reservationName.udfc23 }}</td>
            <td>{{ reservationName.udfc24 }}</td>
            <td>{{ reservationName.udfc25 }}</td>
            <td>{{ reservationName.udfc26 }}</td>
            <td>{{ reservationName.udfc27 }}</td>
            <td>{{ reservationName.udfc28 }}</td>
            <td>{{ reservationName.udfc29 }}</td>
            <td>{{ reservationName.udfc30 }}</td>
            <td>{{ reservationName.udfc31 }}</td>
            <td>{{ reservationName.udfc32 }}</td>
            <td>{{ reservationName.udfc33 }}</td>
            <td>{{ reservationName.udfc34 }}</td>
            <td>{{ reservationName.udfc35 }}</td>
            <td>{{ reservationName.udfc36 }}</td>
            <td>{{ reservationName.udfc37 }}</td>
            <td>{{ reservationName.udfc38 }}</td>
            <td>{{ reservationName.udfc39 }}</td>
            <td>{{ reservationName.udfc40 }}</td>
            <td>{{ reservationName.udfn01 }}</td>
            <td>{{ reservationName.udfn02 }}</td>
            <td>{{ reservationName.udfn03 }}</td>
            <td>{{ reservationName.udfn04 }}</td>
            <td>{{ reservationName.udfn05 }}</td>
            <td>{{ reservationName.udfn06 }}</td>
            <td>{{ reservationName.udfn07 }}</td>
            <td>{{ reservationName.udfn08 }}</td>
            <td>{{ reservationName.udfn09 }}</td>
            <td>{{ reservationName.udfn10 }}</td>
            <td>{{ reservationName.udfn11 }}</td>
            <td>{{ reservationName.udfn12 }}</td>
            <td>{{ reservationName.udfn13 }}</td>
            <td>{{ reservationName.udfn14 }}</td>
            <td>{{ reservationName.udfn15 }}</td>
            <td>{{ reservationName.udfn16 }}</td>
            <td>{{ reservationName.udfn17 }}</td>
            <td>{{ reservationName.udfn18 }}</td>
            <td>{{ reservationName.udfn19 }}</td>
            <td>{{ reservationName.udfn20 }}</td>
            <td>{{ reservationName.udfn21 }}</td>
            <td>{{ reservationName.udfn22 }}</td>
            <td>{{ reservationName.udfn23 }}</td>
            <td>{{ reservationName.udfn24 }}</td>
            <td>{{ reservationName.udfn25 }}</td>
            <td>{{ reservationName.udfn26 }}</td>
            <td>{{ reservationName.udfn27 }}</td>
            <td>{{ reservationName.udfn28 }}</td>
            <td>{{ reservationName.udfn29 }}</td>
            <td>{{ reservationName.udfn30 }}</td>
            <td>{{ reservationName.udfn31 }}</td>
            <td>{{ reservationName.udfn32 }}</td>
            <td>{{ reservationName.udfn33 }}</td>
            <td>{{ reservationName.udfn34 }}</td>
            <td>{{ reservationName.udfn35 }}</td>
            <td>{{ reservationName.udfn36 }}</td>
            <td>{{ reservationName.udfn37 }}</td>
            <td>{{ reservationName.udfn38 }}</td>
            <td>{{ reservationName.udfn39 }}</td>
            <td>{{ reservationName.udfn40 }}</td>
            <td>{{ reservationName.udfd01 }}</td>
            <td>{{ reservationName.udfd02 }}</td>
            <td>{{ reservationName.udfd03 }}</td>
            <td>{{ reservationName.udfd04 }}</td>
            <td>{{ reservationName.udfd05 }}</td>
            <td>{{ reservationName.udfd06 }}</td>
            <td>{{ reservationName.udfd07 }}</td>
            <td>{{ reservationName.udfd08 }}</td>
            <td>{{ reservationName.udfd09 }}</td>
            <td>{{ reservationName.udfd10 }}</td>
            <td>{{ reservationName.insertActionInstanceId }}</td>
            <td>{{ reservationName.dmlSeqNo }}</td>
            <td>{{ reservationName.businessDateCreated }}</td>
            <td>{{ reservationName.turndownYn }}</td>
            <td>{{ reservationName.roomInstructions }}</td>
            <td>{{ reservationName.roomServiceTime }}</td>
            <td>{{ reservationName.eventId }}</td>
            <td>{{ reservationName.revenueTypeCode }}</td>
            <td>{{ reservationName.hurdle }}</td>
            <td>{{ reservationName.hurdleOverride }}</td>
            <td>{{ reservationName.rateableValue }}</td>
            <td>{{ reservationName.restrictionOverride }}</td>
            <td>{{ reservationName.yieldableYn }}</td>
            <td>{{ reservationName.sguestFirstname }}</td>
            <td>{{ reservationName.guestLastName }}</td>
            <td>{{ reservationName.guestFirstName }}</td>
            <td>{{ reservationName.guestLastNameSdx }}</td>
            <td>{{ reservationName.guestFirstNameSdx }}</td>
            <td>{{ reservationName.channel }}</td>
            <td>{{ reservationName.shareSeqNo }}</td>
            <td>{{ reservationName.guestSignature }}</td>
            <td>{{ reservationName.extensionId }}</td>
            <td>{{ reservationName.resvContactId }}</td>
            <td>{{ reservationName.billingContactId }}</td>
            <td>{{ reservationName.resInsertSource }}</td>
            <td>{{ reservationName.resInsertSourceType }}</td>
            <td>{{ reservationName.masterShare }}</td>
            <td>{{ reservationName.registrationCardNo }}</td>
            <td>{{ reservationName.tiad }}</td>
            <td>{{ reservationName.purposeOfStay }}</td>
            <td>{{ reservationName.reinstateDate }}</td>
            <td>{{ reservationName.purgeDate }}</td>
            <td>{{ reservationName.lastSettleDate }}</td>
            <td>{{ reservationName.lastPeriodicFolioDate }}</td>
            <td>{{ reservationName.periodicFolioFreq }}</td>
            <td>{{ reservationName.confirmationLegNo }}</td>
            <td>{{ reservationName.guestStatus }}</td>
            <td>{{ reservationName.guestType }}</td>
            <td>{{ reservationName.checkinDuration }}</td>
            <td>{{ reservationName.authorizerId }}</td>
            <td>{{ reservationName.lastOnlinePrintSeq }}</td>
            <td>{{ reservationName.entryPoint }}</td>
            <td>{{ reservationName.entryDate }}</td>
            <td>{{ reservationName.pseudoMemType }}</td>
            <td>{{ reservationName.pseudoMemTotalPoints }}</td>
            <td>{{ reservationName.folioText1 }}</td>
            <td>{{ reservationName.folioText2 }}</td>
            <td>{{ reservationName.compTypeCode }}</td>
            <td>{{ reservationName.uniCardId }}</td>
            <td>{{ reservationName.expCheckinresId }}</td>
            <td>{{ reservationName.originalBeginDate }}</td>
            <td>{{ reservationName.ownerFfFlag }}</td>
            <td>{{ reservationName.commissionPayoutTo }}</td>
            <td>{{ reservationName.preChargingYn }}</td>
            <td>{{ reservationName.postChargingYn }}</td>
            <td>{{ reservationName.postCoFlag }}</td>
            <td>{{ reservationName.folioCloseDate }}</td>
            <td>{{ reservationName.scheduleCheckoutYn }}</td>
            <td>{{ reservationName.customReference }}</td>
            <td>{{ reservationName.guaranteeCodePreCi }}</td>
            <td>{{ reservationName.awardMembershipId }}</td>
            <td>{{ reservationName.esignedRegCardName }}</td>
            <td>{{ reservationName.statisticalRoomType }}</td>
            <td>{{ reservationName.statisticalRateTier }}</td>
            <td>{{ reservationName.ymCode }}</td>
            <td>{{ reservationName.keyValidUntil }}</td>
            <td>{{ reservationName.preRegisteredYn }}</td>
            <td>{{ reservationName.taxRegistrationNo }}</td>
            <td>{{ reservationName.visaNumber }}</td>
            <td>{{ reservationName.visaIssueDate }}</td>
            <td>{{ reservationName.visaExpirationDate }}</td>
            <td>{{ reservationName.taxNoOfStays }}</td>
            <td>{{ reservationName.asbProratedYn }}</td>
            <td>{{ reservationName.autoSettleDays }}</td>
            <td>{{ reservationName.autoSettleYn }}</td>
            <td>{{ reservationName.splitFromResvNameId }}</td>
            <td>{{ reservationName.nextDestination }}</td>
            <td>{{ reservationName.dateOfArrivalInCountry }}</td>
            <td>{{ reservationName.preArrReviewedDt }}</td>
            <td>{{ reservationName.preArrReviewedUser }}</td>
            <td>{{ reservationName.bonusCheckId }}</td>
            <td>{{ reservationName.mobileAudioKeyYn }}</td>
            <td>{{ reservationName.directBillVerifyResponse }}</td>
            <td>{{ reservationName.addresseeNameId }}</td>
            <td>{{ reservationName.superSearchIndexText }}</td>
            <td>{{ reservationName.autoCheckinYn }}</td>
            <td>{{ reservationName.emailFolioYn }}</td>
            <td>{{ reservationName.emailAddress }}</td>
            <td>{{ reservationName.spgUpgradeConfirmedRoomtype }}</td>
            <td>{{ reservationName.spgUpgradeReasonCode }}</td>
            <td>{{ reservationName.spgSuiteNightAwardStatus }}</td>
            <td>{{ reservationName.spgDiscloseRoomTypeYn }}</td>
            <td>{{ reservationName.amenityEligibleYn }}</td>
            <td>{{ reservationName.amenityLevelCode }}</td>
            <td>{{ reservationName.baseRateCurrencyCode }}</td>
            <td>{{ reservationName.baseRateCode }}</td>
            <td>{{ reservationName.localBaseRateAmount }}</td>
            <td>{{ reservationName.phoneDisplayNameYn }}</td>
            <td>{{ reservationName.resortChargeNumber }}</td>
            <td>{{ reservationName.mobileChkoutAllowed }}</td>
            <td>{{ reservationName.mobileViewFolioAllowed }}</td>
            <td>{{ reservationName.hkExpectedServiceTime }}</td>
            <td>{{ reservationName.eligibleForUpgradeYn }}</td>
            <td>{{ reservationName.beginSystemDateTime }}</td>
            <td>{{ reservationName.mobileCheckinAllowedYn }}</td>
            <td>{{ reservationName.quoteId }}</td>
            <td>{{ reservationName.manualCheckoutStatus }}</td>
            <td>{{ reservationName.mobilePreferredCurrency }}</td>
            <td>{{ reservationName.mobileActionAlertIssued }}</td>
            <td>{{ reservationName.externalEfolioYn }}</td>
            <td>{{ reservationName.optInBatchFolYn }}</td>
            <td>{{ reservationName.folioAddrElementId }}</td>
            <td>{{ reservationName.operaEsignedRegCardYn }}</td>
            <td>{{ reservationName.resvGuid }}</td>
            <td>{{ reservationName.advanceCheckedInYn }}</td>
            <td>{{ reservationName.expectedTimeOfReturn }}</td>
            <td>{{ reservationName.etrComments }}</td>
            <td>{{ reservationName.optedForCommYn }}</td>
            <td>{{ reservationName.creditLimitAutoPayAllowYn }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ReservationNameView', params: { reservationNameId: reservationName.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ReservationNameEdit', params: { reservationNameId: reservationName.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(reservationName)"
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
          id="operaHandlerApplicationApp.reservationName.delete.question"
          data-cy="reservationNameDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p
          id="jhi-delete-reservationName-heading"
          v-text="t$('operaHandlerApplicationApp.reservationName.delete.question', { id: removeId })"
        ></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-reservationName"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeReservationName()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="reservationNames && reservationNames.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./reservation-name.component.ts"></script>
