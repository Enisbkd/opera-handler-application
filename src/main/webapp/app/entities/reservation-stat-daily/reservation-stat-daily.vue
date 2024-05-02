<template>
  <div>
    <h2 id="page-heading" data-cy="ReservationStatDailyHeading">
      <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.home.title')" id="reservation-stat-daily-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ReservationStatDailyCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-reservation-stat-daily"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && reservationStatDailies && reservationStatDailies.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="reservationStatDailies && reservationStatDailies.length > 0">
      <table class="table table-striped" aria-describedby="reservationStatDailies">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resort')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('businessDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.businessDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'businessDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rateCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sourceCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.sourceCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sourceCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('marketCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.marketCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'marketCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomCategory')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('companyId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.companyId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'companyId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('agentId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.agentId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'agentId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('groupId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.groupId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'groupId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sourceProfId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.sourceProfId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sourceProfId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resvStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('truncBeginDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.truncBeginDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'truncBeginDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('truncEndDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.truncEndDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'truncEndDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvNameId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resvNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('quantity')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.quantity')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'quantity'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('physicalQuantity')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.physicalQuantity')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'physicalQuantity'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dueOutYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dueOutYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dueOutYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomResvStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomResvStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomResvStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('adults')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.adults')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'adults'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomAdults')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomAdults')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomAdults'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomChildren')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomChildren')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomChildren'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('primaryYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.primaryYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'primaryYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('allotmentHeaderId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.allotmentHeaderId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'allotmentHeaderId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('foodRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.foodRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'foodRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageFoodRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageFoodRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageFoodRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('totalRoomTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalRoomTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'totalRoomTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('totalFoodTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalFoodTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'totalFoodTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('totalPackageRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalPackageRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'totalPackageRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('totalRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'totalRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('totalTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'totalTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('originalEndDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.originalEndDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'originalEndDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('walkinYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.walkinYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'walkinYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reservationDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reservationDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomClass')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.roomClass')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomClass'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('vipStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.vipStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'vipStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancellationDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancellationDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancellationDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('birthDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.birthDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'birthDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('room')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.room')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'room'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('membershipId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.membershipId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'membershipId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contactId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.contactId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contactId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateCategory')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rateCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('marketMainGroup')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.marketMainGroup')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'marketMainGroup'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sourceMainGroup')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.sourceMainGroup')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sourceMainGroup'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('channel')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.channel')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'channel'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('country')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.country')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'country'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('regionCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.regionCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'regionCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nationality')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nationality')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nationality'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('psuedoRoomYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.psuedoRoomYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'psuedoRoomYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('adultsTaxFree')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.adultsTaxFree')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'adultsTaxFree'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('childrenTaxFree')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.childrenTaxFree')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'childrenTaxFree'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stayRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stayRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stayPersons')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayPersons')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stayPersons'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stayAdults')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayAdults')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stayAdults'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stayChildren')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.stayChildren')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stayChildren'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.arrRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrPersons')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.arrPersons')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrPersons'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('depRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.depRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'depRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('depPersons')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.depPersons')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'depPersons'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dayUseRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dayUseRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dayUseRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dayUsePersons')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dayUsePersons')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dayUsePersons'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancelledRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancelledRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancelledRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancelledPersons')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancelledPersons')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancelledPersons'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('noShowRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noShowRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'noShowRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('noShowPersons')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noShowPersons')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'noShowPersons'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('singleOccupancy')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.singleOccupancy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'singleOccupancy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('multipleOccupancy')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.multipleOccupancy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'multipleOccupancy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cribs')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cribs')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cribs'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extraBeds')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.extraBeds')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extraBeds'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('otherRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.otherRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'otherRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageOtherRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageOtherRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageOtherRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('totalOtherTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalOtherTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'totalOtherTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('countryMainGroup')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.countryMainGroup')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'countryMainGroup'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('state')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.state')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'state'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fiscalRegionCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.fiscalRegionCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fiscalRegionCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nonRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nonRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nonRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageNonRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.packageNonRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageNonRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('totalNonRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.totalNonRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'totalNonRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prFoodRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prFoodRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prFoodRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prPackageRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prPackageRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prPackageFoodRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageFoodRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prPackageFoodRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prTotalRoomTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalRoomTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prTotalRoomTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prTotalFoodTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalFoodTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prTotalFoodTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prTotalPackageRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalPackageRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prTotalPackageRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prTotalRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prTotalRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prTotalTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prTotalTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prOtherRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prOtherRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prOtherRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prPackageOtherRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageOtherRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prPackageOtherRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prTotalOtherTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalOtherTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prTotalOtherTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prNonRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prNonRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prNonRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prPackageNonRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prPackageNonRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prPackageNonRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prTotalNonRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prTotalNonRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prTotalNonRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nights')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.nights')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nights'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('noOfStays')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noOfStays')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'noOfStays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reservationNights')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationNights')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reservationNights'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reservationArrivals')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationArrivals')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reservationArrivals'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reservationNoOfStays')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.reservationNoOfStays')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reservationNoOfStays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dayUseReservations')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.dayUseReservations')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dayUseReservations'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancelledReservations')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cancelledReservations')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancelledReservations'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('noShowReservations')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.noShowReservations')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'noShowReservations'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('city')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.city')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'city'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('zipCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.zipCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'zipCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('district')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.district')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'district'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cashRoomNts')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cashRoomNts')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cashRoomNts'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('compRoomNts')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.compRoomNts')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'compRoomNts'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cashRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.cashRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cashRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('compRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.compRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'compRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resInsertSource')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resInsertSource')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resInsertSource'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resInsertSourceType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.resInsertSourceType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resInsertSourceType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children1')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children2')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children3')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children4')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children4')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children4'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children5')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.children5')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children5'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ffMembershipType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.ffMembershipType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ffMembershipType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fgMembershipType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.fgMembershipType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fgMembershipType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('promotionCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.promotionCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'promotionCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ownerFfFlag')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.ownerFfFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ownerFfFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ownerRentalFlag')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.ownerRentalFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ownerRentalFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('centralCurrencyCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.centralCurrencyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'centralCurrencyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('centralExchangeRate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.centralExchangeRate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'centralExchangeRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bookedRoomCategory')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.bookedRoomCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bookedRoomCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('businessDateCreated')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.businessDateCreated')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'businessDateCreated'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateAmount')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rateAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('parentCompanyId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.parentCompanyId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'parentCompanyId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('houseUseYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.houseUseYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'houseUseYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('complimentaryYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.complimentaryYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'complimentaryYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('biResvNameId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.biResvNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'biResvNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advFoodRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advFoodRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advFoodRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advNonRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advNonRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advNonRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advOtherRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advOtherRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advOtherRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advTotalFoodTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalFoodTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advTotalFoodTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advTotalNonRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalNonRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advTotalNonRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advTotalOtherTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalOtherTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advTotalOtherTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advTotalRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advTotalRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advTotalRoomTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalRoomTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advTotalRoomTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advTotalTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.advTotalTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advTotalTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prAdvFoodRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvFoodRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prAdvFoodRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prAdvNonRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvNonRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prAdvNonRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prAdvOtherRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvOtherRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prAdvOtherRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prAdvRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prAdvRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prAdvTotalFoodTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalFoodTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prAdvTotalFoodTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prAdvTotalNonRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalNonRevenueTax')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'prAdvTotalNonRevenueTax'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prAdvTotalOtherTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalOtherTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prAdvTotalOtherTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prAdvTotalRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prAdvTotalRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prAdvTotalRoomTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalRoomTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prAdvTotalRoomTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('prAdvTotalTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.prAdvTotalTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'prAdvTotalTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('upsoldRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.upsoldRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upsoldRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flgdRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flgdRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flgdFoodRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdFoodRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flgdFoodRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flgdNonRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdNonRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flgdNonRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flgdOtherRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdOtherRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flgdOtherRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flgdTotalRoomTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalRoomTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flgdTotalRoomTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flgdTotalFoodTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalFoodTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flgdTotalFoodTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flgdTotalNonRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalNonRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flgdTotalNonRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flgdTotalOtherTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalOtherTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flgdTotalOtherTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flgdTotalRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flgdTotalRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flgdTotalTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.flgdTotalTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flgdTotalTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contactYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.contactYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contactYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extendedStayTier')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.extendedStayTier')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extendedStayTier'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rsAdvTotalRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvTotalRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rsAdvTotalRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rsAdvRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rsAdvRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rsAdvFoodRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvFoodRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rsAdvFoodRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rsAdvOtherRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvOtherRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rsAdvOtherRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rsAdvNonRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvNonRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rsAdvNonRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rsAdvTotalTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvTotalTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rsAdvTotalTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rsAdvRoomTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvRoomTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rsAdvRoomTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rsAdvFoodTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvFoodTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rsAdvFoodTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rsAdvOtherTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvOtherTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rsAdvOtherTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rsAdvNonRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.rsAdvNonRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rsAdvNonRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guid')">
              <span v-text="t$('operaHandlerApplicationApp.reservationStatDaily.guid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guid'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="reservationStatDaily in reservationStatDailies" :key="reservationStatDaily.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ReservationStatDailyView', params: { reservationStatDailyId: reservationStatDaily.id } }">{{
                reservationStatDaily.id
              }}</router-link>
            </td>
            <td>{{ reservationStatDaily.resort }}</td>
            <td>{{ reservationStatDaily.businessDate }}</td>
            <td>{{ reservationStatDaily.nameId }}</td>
            <td>{{ reservationStatDaily.rateCode }}</td>
            <td>{{ reservationStatDaily.sourceCode }}</td>
            <td>{{ reservationStatDaily.marketCode }}</td>
            <td>{{ reservationStatDaily.roomCategory }}</td>
            <td>{{ reservationStatDaily.companyId }}</td>
            <td>{{ reservationStatDaily.agentId }}</td>
            <td>{{ reservationStatDaily.groupId }}</td>
            <td>{{ reservationStatDaily.sourceProfId }}</td>
            <td>{{ reservationStatDaily.resvStatus }}</td>
            <td>{{ reservationStatDaily.truncBeginDate }}</td>
            <td>{{ reservationStatDaily.truncEndDate }}</td>
            <td>{{ reservationStatDaily.resvNameId }}</td>
            <td>{{ reservationStatDaily.quantity }}</td>
            <td>{{ reservationStatDaily.physicalQuantity }}</td>
            <td>{{ reservationStatDaily.dueOutYn }}</td>
            <td>{{ reservationStatDaily.roomResvStatus }}</td>
            <td>{{ reservationStatDaily.adults }}</td>
            <td>{{ reservationStatDaily.children }}</td>
            <td>{{ reservationStatDaily.roomAdults }}</td>
            <td>{{ reservationStatDaily.roomChildren }}</td>
            <td>{{ reservationStatDaily.primaryYn }}</td>
            <td>{{ reservationStatDaily.allotmentHeaderId }}</td>
            <td>{{ reservationStatDaily.roomRevenue }}</td>
            <td>{{ reservationStatDaily.foodRevenue }}</td>
            <td>{{ reservationStatDaily.packageRoomRevenue }}</td>
            <td>{{ reservationStatDaily.packageFoodRevenue }}</td>
            <td>{{ reservationStatDaily.totalRoomTax }}</td>
            <td>{{ reservationStatDaily.totalFoodTax }}</td>
            <td>{{ reservationStatDaily.totalPackageRevenue }}</td>
            <td>{{ reservationStatDaily.totalRevenue }}</td>
            <td>{{ reservationStatDaily.totalTax }}</td>
            <td>{{ reservationStatDaily.insertDate }}</td>
            <td>{{ reservationStatDaily.originalEndDate }}</td>
            <td>{{ reservationStatDaily.walkinYn }}</td>
            <td>{{ reservationStatDaily.reservationDate }}</td>
            <td>{{ reservationStatDaily.roomClass }}</td>
            <td>{{ reservationStatDaily.vipStatus }}</td>
            <td>{{ reservationStatDaily.cancellationDate }}</td>
            <td>{{ reservationStatDaily.birthDate }}</td>
            <td>{{ reservationStatDaily.room }}</td>
            <td>{{ reservationStatDaily.membershipId }}</td>
            <td>{{ reservationStatDaily.contactId }}</td>
            <td>{{ reservationStatDaily.rateCategory }}</td>
            <td>{{ reservationStatDaily.marketMainGroup }}</td>
            <td>{{ reservationStatDaily.sourceMainGroup }}</td>
            <td>{{ reservationStatDaily.channel }}</td>
            <td>{{ reservationStatDaily.country }}</td>
            <td>{{ reservationStatDaily.regionCode }}</td>
            <td>{{ reservationStatDaily.nationality }}</td>
            <td>{{ reservationStatDaily.psuedoRoomYn }}</td>
            <td>{{ reservationStatDaily.adultsTaxFree }}</td>
            <td>{{ reservationStatDaily.childrenTaxFree }}</td>
            <td>{{ reservationStatDaily.stayRooms }}</td>
            <td>{{ reservationStatDaily.stayPersons }}</td>
            <td>{{ reservationStatDaily.stayAdults }}</td>
            <td>{{ reservationStatDaily.stayChildren }}</td>
            <td>{{ reservationStatDaily.arrRooms }}</td>
            <td>{{ reservationStatDaily.arrPersons }}</td>
            <td>{{ reservationStatDaily.depRooms }}</td>
            <td>{{ reservationStatDaily.depPersons }}</td>
            <td>{{ reservationStatDaily.dayUseRooms }}</td>
            <td>{{ reservationStatDaily.dayUsePersons }}</td>
            <td>{{ reservationStatDaily.cancelledRooms }}</td>
            <td>{{ reservationStatDaily.cancelledPersons }}</td>
            <td>{{ reservationStatDaily.noShowRooms }}</td>
            <td>{{ reservationStatDaily.noShowPersons }}</td>
            <td>{{ reservationStatDaily.singleOccupancy }}</td>
            <td>{{ reservationStatDaily.multipleOccupancy }}</td>
            <td>{{ reservationStatDaily.cribs }}</td>
            <td>{{ reservationStatDaily.extraBeds }}</td>
            <td>{{ reservationStatDaily.otherRevenue }}</td>
            <td>{{ reservationStatDaily.packageOtherRevenue }}</td>
            <td>{{ reservationStatDaily.totalOtherTax }}</td>
            <td>{{ reservationStatDaily.countryMainGroup }}</td>
            <td>{{ reservationStatDaily.state }}</td>
            <td>{{ reservationStatDaily.fiscalRegionCode }}</td>
            <td>{{ reservationStatDaily.nonRevenue }}</td>
            <td>{{ reservationStatDaily.packageNonRevenue }}</td>
            <td>{{ reservationStatDaily.totalNonRevenueTax }}</td>
            <td>{{ reservationStatDaily.prRoomRevenue }}</td>
            <td>{{ reservationStatDaily.prFoodRevenue }}</td>
            <td>{{ reservationStatDaily.prPackageRoomRevenue }}</td>
            <td>{{ reservationStatDaily.prPackageFoodRevenue }}</td>
            <td>{{ reservationStatDaily.prTotalRoomTax }}</td>
            <td>{{ reservationStatDaily.prTotalFoodTax }}</td>
            <td>{{ reservationStatDaily.prTotalPackageRevenue }}</td>
            <td>{{ reservationStatDaily.prTotalRevenue }}</td>
            <td>{{ reservationStatDaily.prTotalTax }}</td>
            <td>{{ reservationStatDaily.prOtherRevenue }}</td>
            <td>{{ reservationStatDaily.prPackageOtherRevenue }}</td>
            <td>{{ reservationStatDaily.prTotalOtherTax }}</td>
            <td>{{ reservationStatDaily.prNonRevenue }}</td>
            <td>{{ reservationStatDaily.prPackageNonRevenue }}</td>
            <td>{{ reservationStatDaily.prTotalNonRevenueTax }}</td>
            <td>{{ reservationStatDaily.nights }}</td>
            <td>{{ reservationStatDaily.noOfStays }}</td>
            <td>{{ reservationStatDaily.reservationNights }}</td>
            <td>{{ reservationStatDaily.reservationArrivals }}</td>
            <td>{{ reservationStatDaily.reservationNoOfStays }}</td>
            <td>{{ reservationStatDaily.dayUseReservations }}</td>
            <td>{{ reservationStatDaily.cancelledReservations }}</td>
            <td>{{ reservationStatDaily.noShowReservations }}</td>
            <td>{{ reservationStatDaily.city }}</td>
            <td>{{ reservationStatDaily.zipCode }}</td>
            <td>{{ reservationStatDaily.district }}</td>
            <td>{{ reservationStatDaily.cashRoomNts }}</td>
            <td>{{ reservationStatDaily.compRoomNts }}</td>
            <td>{{ reservationStatDaily.cashRoomRevenue }}</td>
            <td>{{ reservationStatDaily.compRoomRevenue }}</td>
            <td>{{ reservationStatDaily.resInsertSource }}</td>
            <td>{{ reservationStatDaily.resInsertSourceType }}</td>
            <td>{{ reservationStatDaily.children1 }}</td>
            <td>{{ reservationStatDaily.children2 }}</td>
            <td>{{ reservationStatDaily.children3 }}</td>
            <td>{{ reservationStatDaily.children4 }}</td>
            <td>{{ reservationStatDaily.children5 }}</td>
            <td>{{ reservationStatDaily.ffMembershipType }}</td>
            <td>{{ reservationStatDaily.fgMembershipType }}</td>
            <td>{{ reservationStatDaily.promotionCode }}</td>
            <td>{{ reservationStatDaily.ownerFfFlag }}</td>
            <td>{{ reservationStatDaily.ownerRentalFlag }}</td>
            <td>{{ reservationStatDaily.centralCurrencyCode }}</td>
            <td>{{ reservationStatDaily.centralExchangeRate }}</td>
            <td>{{ reservationStatDaily.bookedRoomCategory }}</td>
            <td>{{ reservationStatDaily.businessDateCreated }}</td>
            <td>{{ reservationStatDaily.rateAmount }}</td>
            <td>{{ reservationStatDaily.parentCompanyId }}</td>
            <td>{{ reservationStatDaily.houseUseYn }}</td>
            <td>{{ reservationStatDaily.complimentaryYn }}</td>
            <td>{{ reservationStatDaily.biResvNameId }}</td>
            <td>{{ reservationStatDaily.advFoodRevenue }}</td>
            <td>{{ reservationStatDaily.advNonRevenue }}</td>
            <td>{{ reservationStatDaily.advOtherRevenue }}</td>
            <td>{{ reservationStatDaily.advRoomRevenue }}</td>
            <td>{{ reservationStatDaily.advTotalFoodTax }}</td>
            <td>{{ reservationStatDaily.advTotalNonRevenueTax }}</td>
            <td>{{ reservationStatDaily.advTotalOtherTax }}</td>
            <td>{{ reservationStatDaily.advTotalRevenue }}</td>
            <td>{{ reservationStatDaily.advTotalRoomTax }}</td>
            <td>{{ reservationStatDaily.advTotalTax }}</td>
            <td>{{ reservationStatDaily.prAdvFoodRevenue }}</td>
            <td>{{ reservationStatDaily.prAdvNonRevenue }}</td>
            <td>{{ reservationStatDaily.prAdvOtherRevenue }}</td>
            <td>{{ reservationStatDaily.prAdvRoomRevenue }}</td>
            <td>{{ reservationStatDaily.prAdvTotalFoodTax }}</td>
            <td>{{ reservationStatDaily.prAdvTotalNonRevenueTax }}</td>
            <td>{{ reservationStatDaily.prAdvTotalOtherTax }}</td>
            <td>{{ reservationStatDaily.prAdvTotalRevenue }}</td>
            <td>{{ reservationStatDaily.prAdvTotalRoomTax }}</td>
            <td>{{ reservationStatDaily.prAdvTotalTax }}</td>
            <td>{{ reservationStatDaily.upsoldRevenue }}</td>
            <td>{{ reservationStatDaily.flgdRoomRevenue }}</td>
            <td>{{ reservationStatDaily.flgdFoodRevenue }}</td>
            <td>{{ reservationStatDaily.flgdNonRevenue }}</td>
            <td>{{ reservationStatDaily.flgdOtherRevenue }}</td>
            <td>{{ reservationStatDaily.flgdTotalRoomTax }}</td>
            <td>{{ reservationStatDaily.flgdTotalFoodTax }}</td>
            <td>{{ reservationStatDaily.flgdTotalNonRevenueTax }}</td>
            <td>{{ reservationStatDaily.flgdTotalOtherTax }}</td>
            <td>{{ reservationStatDaily.flgdTotalRevenue }}</td>
            <td>{{ reservationStatDaily.flgdTotalTax }}</td>
            <td>{{ reservationStatDaily.contactYn }}</td>
            <td>{{ reservationStatDaily.extendedStayTier }}</td>
            <td>{{ reservationStatDaily.rsAdvTotalRevenue }}</td>
            <td>{{ reservationStatDaily.rsAdvRoomRevenue }}</td>
            <td>{{ reservationStatDaily.rsAdvFoodRevenue }}</td>
            <td>{{ reservationStatDaily.rsAdvOtherRevenue }}</td>
            <td>{{ reservationStatDaily.rsAdvNonRevenue }}</td>
            <td>{{ reservationStatDaily.rsAdvTotalTax }}</td>
            <td>{{ reservationStatDaily.rsAdvRoomTax }}</td>
            <td>{{ reservationStatDaily.rsAdvFoodTax }}</td>
            <td>{{ reservationStatDaily.rsAdvOtherTax }}</td>
            <td>{{ reservationStatDaily.rsAdvNonRevenueTax }}</td>
            <td>{{ reservationStatDaily.updateDate }}</td>
            <td>{{ reservationStatDaily.guid }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ReservationStatDailyView', params: { reservationStatDailyId: reservationStatDaily.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ReservationStatDailyEdit', params: { reservationStatDailyId: reservationStatDaily.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(reservationStatDaily)"
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
          id="operaHandlerApplicationApp.reservationStatDaily.delete.question"
          data-cy="reservationStatDailyDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p
          id="jhi-delete-reservationStatDaily-heading"
          v-text="t$('operaHandlerApplicationApp.reservationStatDaily.delete.question', { id: removeId })"
        ></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-reservationStatDaily"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeReservationStatDaily()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="reservationStatDailies && reservationStatDailies.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./reservation-stat-daily.component.ts"></script>
