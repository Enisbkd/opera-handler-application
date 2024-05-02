<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="reservationStatDaily">
        <h2 class="jh-entity-heading" data-cy="reservationStatDailyDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.detail.title')"></span> {{ reservationStatDaily.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resort')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.resort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.businessDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.businessDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nameId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.nameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rateCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rateCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.sourceCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.sourceCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.marketCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.marketCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomCategory')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.roomCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.companyId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.companyId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.agentId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.agentId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.groupId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.groupId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.sourceProfId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.sourceProfId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resvStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.resvStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.truncBeginDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.truncBeginDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.truncEndDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.truncEndDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resvNameId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.resvNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.quantity')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.quantity }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.physicalQuantity')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.physicalQuantity }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dueOutYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.dueOutYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomResvStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.roomResvStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.adults')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.adults }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.children }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomAdults')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.roomAdults }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomChildren')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.roomChildren }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.primaryYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.primaryYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.allotmentHeaderId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.allotmentHeaderId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.roomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.foodRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.foodRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.packageRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageFoodRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.packageFoodRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalRoomTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.totalRoomTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalFoodTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.totalFoodTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalPackageRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.totalPackageRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.totalRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.totalTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.originalEndDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.originalEndDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.walkinYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.walkinYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.reservationDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomClass')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.roomClass }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.vipStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.vipStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancellationDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.cancellationDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.birthDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.birthDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.room')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.room }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.membershipId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.membershipId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.contactId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.contactId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rateCategory')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rateCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.marketMainGroup')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.marketMainGroup }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.sourceMainGroup')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.sourceMainGroup }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.channel')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.channel }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.country')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.country }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.regionCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.regionCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nationality')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.nationality }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.psuedoRoomYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.psuedoRoomYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.adultsTaxFree')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.adultsTaxFree }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.childrenTaxFree')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.childrenTaxFree }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.stayRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayPersons')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.stayPersons }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayAdults')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.stayAdults }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayChildren')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.stayChildren }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.arrRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.arrRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.arrPersons')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.arrPersons }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.depRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.depRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.depPersons')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.depPersons }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dayUseRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.dayUseRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dayUsePersons')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.dayUsePersons }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancelledRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.cancelledRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancelledPersons')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.cancelledPersons }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noShowRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.noShowRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noShowPersons')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.noShowPersons }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.singleOccupancy')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.singleOccupancy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.multipleOccupancy')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.multipleOccupancy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cribs')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.cribs }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.extraBeds')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.extraBeds }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.otherRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.otherRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageOtherRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.packageOtherRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalOtherTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.totalOtherTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.countryMainGroup')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.countryMainGroup }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.state')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.state }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.fiscalRegionCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.fiscalRegionCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nonRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.nonRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageNonRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.packageNonRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalNonRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.totalNonRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prFoodRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prFoodRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prPackageRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageFoodRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prPackageFoodRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalRoomTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prTotalRoomTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalFoodTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prTotalFoodTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalPackageRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prTotalPackageRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prTotalRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prTotalTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prOtherRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prOtherRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageOtherRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prPackageOtherRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalOtherTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prTotalOtherTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prNonRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prNonRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageNonRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prPackageNonRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalNonRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prTotalNonRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nights')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.nights }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noOfStays')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.noOfStays }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationNights')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.reservationNights }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationArrivals')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.reservationArrivals }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationNoOfStays')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.reservationNoOfStays }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dayUseReservations')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.dayUseReservations }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancelledReservations')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.cancelledReservations }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noShowReservations')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.noShowReservations }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.city')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.city }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.zipCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.zipCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.district')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.district }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cashRoomNts')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.cashRoomNts }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.compRoomNts')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.compRoomNts }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cashRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.cashRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.compRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.compRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resInsertSource')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.resInsertSource }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resInsertSourceType')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.resInsertSourceType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children1')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.children1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children2')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.children2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children3')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.children3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children4')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.children4 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children5')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.children5 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.ffMembershipType')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.ffMembershipType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.fgMembershipType')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.fgMembershipType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.promotionCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.promotionCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.ownerFfFlag')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.ownerFfFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.ownerRentalFlag')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.ownerRentalFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.centralCurrencyCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.centralCurrencyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.centralExchangeRate')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.centralExchangeRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.bookedRoomCategory')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.bookedRoomCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.businessDateCreated')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.businessDateCreated }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rateAmount')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rateAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.parentCompanyId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.parentCompanyId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.houseUseYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.houseUseYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.complimentaryYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.complimentaryYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.biResvNameId')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.biResvNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advFoodRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.advFoodRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advNonRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.advNonRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advOtherRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.advOtherRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.advRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalFoodTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.advTotalFoodTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalNonRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.advTotalNonRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalOtherTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.advTotalOtherTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.advTotalRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalRoomTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.advTotalRoomTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.advTotalTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvFoodRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prAdvFoodRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvNonRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prAdvNonRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvOtherRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prAdvOtherRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prAdvRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalFoodTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prAdvTotalFoodTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalNonRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prAdvTotalNonRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalOtherTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prAdvTotalOtherTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prAdvTotalRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalRoomTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prAdvTotalRoomTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.prAdvTotalTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.upsoldRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.upsoldRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.flgdRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdFoodRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.flgdFoodRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdNonRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.flgdNonRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdOtherRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.flgdOtherRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalRoomTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.flgdTotalRoomTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalFoodTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.flgdTotalFoodTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalNonRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.flgdTotalNonRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalOtherTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.flgdTotalOtherTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.flgdTotalRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.flgdTotalTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.contactYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.contactYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.extendedStayTier')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.extendedStayTier }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvTotalRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rsAdvTotalRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rsAdvRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvFoodRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rsAdvFoodRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvOtherRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rsAdvOtherRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvNonRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rsAdvNonRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvTotalTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rsAdvTotalTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvRoomTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rsAdvRoomTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvFoodTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rsAdvFoodTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvOtherTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rsAdvOtherTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvNonRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.rsAdvNonRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.guid')"></span>
          </dt>
          <dd>
            <span>{{ reservationStatDaily.guid }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="reservationStatDaily.id"
          :to="{ name: 'ReservationStatDailyEdit', params: { reservationStatDailyId: reservationStatDaily.id } }"
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

<script lang="ts" src="./reservation-stat-daily-details.component.ts"></script>
