<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="reservationName">
        <h2 class="jh-entity-heading" data-cy="reservationNameDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.reservationName.detail.title')"></span> {{ reservationName.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.resort')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.resort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.resvNameId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.resvNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.nameId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.nameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.nameUsageType')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.nameUsageType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.contactNameId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.contactNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.resvStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.resvStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.commissionCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.commissionCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.addressId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.addressId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.phoneId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.phoneId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.faxYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.faxYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.mailYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.mailYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.printRateYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.printRateYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.reportId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.reportId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.resvNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.resvNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.confirmationNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.confirmationNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.beginDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.beginDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.endDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.endDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.faxId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.faxId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.emailId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.emailId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.emailYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.emailYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.consumerYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.consumerYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.creditCardId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.creditCardId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.financiallyResponsibleYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.financiallyResponsibleYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.paymentMethod')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.paymentMethod }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.intermediaryYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.intermediaryYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.postingAllowedYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.postingAllowedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.displayColor')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.displayColor }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.actualCheckInDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.actualCheckInDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.truncActualCheckInDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.truncActualCheckInDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.actualCheckOutDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.actualCheckOutDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.truncActualCheckOutDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.truncActualCheckOutDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.creditLimit')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.creditLimit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.authorizedBy')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.authorizedBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.parentResvNameId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.parentResvNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.cancellationNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.cancellationNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.cancellationReasonCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.cancellationReasonCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.cancellationReasonDesc')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.cancellationReasonDesc }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalTransportType')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.arrivalTransportType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalStationCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.arrivalStationCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalCarrierCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.arrivalCarrierCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalTransportCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.arrivalTransportCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalDateTime')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.arrivalDateTime }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalEstimateTime')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.arrivalEstimateTime }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalTranportationYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.arrivalTranportationYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.arrivalComments')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.arrivalComments }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.departureTransportType')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.departureTransportType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.departureStationCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.departureStationCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.departureCarrierCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.departureCarrierCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.departureTransportCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.departureTransportCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.departureDateTime')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.departureDateTime }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.departureEstimateTime')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.departureEstimateTime }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.departureTransportationYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.departureTransportationYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.departureComments')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.departureComments }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.cancellationDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.cancellationDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.guaranteeCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.guaranteeCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.wlReasonDescription')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.wlReasonDescription }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.wlReasonCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.wlReasonCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.wlPriority')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.wlPriority }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.doNotMoveRoom')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.doNotMoveRoom }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.externalReference')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.externalReference }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.partyCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.partyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.walkinYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.walkinYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.originalEndDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.originalEndDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.approvalAmountCalcMethod')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.approvalAmountCalcMethod }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.amountPercent')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.amountPercent }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.nameTaxType')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.nameTaxType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.taxExemptNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.taxExemptNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.roomFeatures')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.roomFeatures }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.wlTelephoneNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.wlTelephoneNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.videoCheckoutYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.videoCheckoutYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.discountAmt')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.discountAmt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.discountPrcnt')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.discountPrcnt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.discountReasonCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.discountReasonCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.commissionPaid')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.commissionPaid }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.commissionHoldCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.commissionHoldCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.truncBeginDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.truncBeginDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.truncEndDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.truncEndDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.sguestName')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.sguestName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.membershipId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.membershipId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc01')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc01 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc02')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc02 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc03')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc03 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc04')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc04 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc05')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc05 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc06')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc06 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc07')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc07 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc08')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc08 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc09')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc09 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc10')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc10 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc11')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc11 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc12')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc12 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc13')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc13 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc14')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc14 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc15')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc15 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc16')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc16 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc17')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc17 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc18')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc18 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc19')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc19 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc20')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc20 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc21')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc21 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc22')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc22 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc23')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc23 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc24')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc24 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc25')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc25 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc26')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc26 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc27')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc27 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc28')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc28 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc29')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc29 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc30')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc30 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc31')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc31 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc32')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc32 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc33')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc33 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc34')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc34 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc35')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc35 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc36')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc36 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc37')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc37 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc38')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc38 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc39')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc39 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfc40')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfc40 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn01')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn01 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn02')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn02 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn03')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn03 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn04')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn04 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn05')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn05 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn06')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn06 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn07')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn07 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn08')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn08 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn09')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn09 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn10')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn10 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn11')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn11 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn12')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn12 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn13')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn13 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn14')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn14 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn15')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn15 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn16')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn16 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn17')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn17 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn18')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn18 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn19')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn19 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn20')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn20 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn21')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn21 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn22')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn22 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn23')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn23 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn24')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn24 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn25')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn25 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn26')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn26 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn27')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn27 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn28')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn28 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn29')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn29 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn30')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn30 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn31')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn31 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn32')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn32 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn33')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn33 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn34')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn34 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn35')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn35 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn36')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn36 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn37')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn37 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn38')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn38 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn39')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn39 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfn40')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfn40 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd01')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfd01 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd02')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfd02 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd03')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfd03 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd04')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfd04 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd05')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfd05 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd06')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfd06 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd07')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfd07 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd08')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfd08 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd09')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfd09 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.udfd10')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.udfd10 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.insertActionInstanceId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.insertActionInstanceId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.dmlSeqNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.dmlSeqNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.businessDateCreated')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.businessDateCreated }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.turndownYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.turndownYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.roomInstructions')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.roomInstructions }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.roomServiceTime')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.roomServiceTime }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.eventId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.eventId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.revenueTypeCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.revenueTypeCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.hurdle')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.hurdle }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.hurdleOverride')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.hurdleOverride }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.rateableValue')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.rateableValue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.restrictionOverride')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.restrictionOverride }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.yieldableYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.yieldableYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.sguestFirstname')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.sguestFirstname }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.guestLastName')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.guestLastName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.guestFirstName')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.guestFirstName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.guestLastNameSdx')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.guestLastNameSdx }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.guestFirstNameSdx')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.guestFirstNameSdx }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.channel')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.channel }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.shareSeqNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.shareSeqNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.guestSignature')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.guestSignature }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.extensionId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.extensionId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.resvContactId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.resvContactId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.billingContactId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.billingContactId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.resInsertSource')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.resInsertSource }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.resInsertSourceType')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.resInsertSourceType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.masterShare')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.masterShare }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.registrationCardNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.registrationCardNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.tiad')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.tiad }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.purposeOfStay')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.purposeOfStay }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.reinstateDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.reinstateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.purgeDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.purgeDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.lastSettleDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.lastSettleDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.lastPeriodicFolioDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.lastPeriodicFolioDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.periodicFolioFreq')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.periodicFolioFreq }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.confirmationLegNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.confirmationLegNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.guestStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.guestStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.guestType')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.guestType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.checkinDuration')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.checkinDuration }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.authorizerId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.authorizerId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.lastOnlinePrintSeq')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.lastOnlinePrintSeq }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.entryPoint')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.entryPoint }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.entryDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.entryDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.pseudoMemType')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.pseudoMemType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.pseudoMemTotalPoints')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.pseudoMemTotalPoints }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.folioText1')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.folioText1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.folioText2')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.folioText2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.compTypeCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.compTypeCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.uniCardId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.uniCardId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.expCheckinresId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.expCheckinresId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.originalBeginDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.originalBeginDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.ownerFfFlag')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.ownerFfFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.commissionPayoutTo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.commissionPayoutTo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.preChargingYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.preChargingYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.postChargingYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.postChargingYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.postCoFlag')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.postCoFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.folioCloseDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.folioCloseDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.scheduleCheckoutYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.scheduleCheckoutYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.customReference')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.customReference }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.guaranteeCodePreCi')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.guaranteeCodePreCi }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.awardMembershipId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.awardMembershipId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.esignedRegCardName')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.esignedRegCardName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.statisticalRoomType')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.statisticalRoomType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.statisticalRateTier')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.statisticalRateTier }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.ymCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.ymCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.keyValidUntil')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.keyValidUntil }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.preRegisteredYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.preRegisteredYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.taxRegistrationNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.taxRegistrationNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.visaNumber')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.visaNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.visaIssueDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.visaIssueDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.visaExpirationDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.visaExpirationDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.taxNoOfStays')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.taxNoOfStays }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.asbProratedYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.asbProratedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.autoSettleDays')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.autoSettleDays }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.autoSettleYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.autoSettleYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.splitFromResvNameId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.splitFromResvNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.nextDestination')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.nextDestination }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.dateOfArrivalInCountry')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.dateOfArrivalInCountry }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.preArrReviewedDt')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.preArrReviewedDt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.preArrReviewedUser')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.preArrReviewedUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.bonusCheckId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.bonusCheckId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.mobileAudioKeyYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.mobileAudioKeyYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.directBillVerifyResponse')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.directBillVerifyResponse }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.addresseeNameId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.addresseeNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.superSearchIndexText')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.superSearchIndexText }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.autoCheckinYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.autoCheckinYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.emailFolioYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.emailFolioYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.emailAddress')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.emailAddress }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.spgUpgradeConfirmedRoomtype')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.spgUpgradeConfirmedRoomtype }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.spgUpgradeReasonCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.spgUpgradeReasonCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.spgSuiteNightAwardStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.spgSuiteNightAwardStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.spgDiscloseRoomTypeYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.spgDiscloseRoomTypeYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.amenityEligibleYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.amenityEligibleYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.amenityLevelCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.amenityLevelCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.baseRateCurrencyCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.baseRateCurrencyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.baseRateCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.baseRateCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.localBaseRateAmount')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.localBaseRateAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.phoneDisplayNameYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.phoneDisplayNameYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.resortChargeNumber')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.resortChargeNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.mobileChkoutAllowed')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.mobileChkoutAllowed }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.mobileViewFolioAllowed')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.mobileViewFolioAllowed }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.hkExpectedServiceTime')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.hkExpectedServiceTime }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.eligibleForUpgradeYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.eligibleForUpgradeYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.beginSystemDateTime')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.beginSystemDateTime }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.mobileCheckinAllowedYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.mobileCheckinAllowedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.quoteId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.quoteId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.manualCheckoutStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.manualCheckoutStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.mobilePreferredCurrency')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.mobilePreferredCurrency }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.mobileActionAlertIssued')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.mobileActionAlertIssued }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.externalEfolioYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.externalEfolioYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.optInBatchFolYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.optInBatchFolYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.folioAddrElementId')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.folioAddrElementId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.operaEsignedRegCardYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.operaEsignedRegCardYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.resvGuid')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.resvGuid }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.advanceCheckedInYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.advanceCheckedInYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.expectedTimeOfReturn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.expectedTimeOfReturn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.etrComments')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.etrComments }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.optedForCommYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.optedForCommYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationName.creditLimitAutoPayAllowYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationName.creditLimitAutoPayAllowYn }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="reservationName.id"
          :to="{ name: 'ReservationNameEdit', params: { reservationNameId: reservationName.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.edit')"></span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./reservation-name-details.component.ts"></script>
