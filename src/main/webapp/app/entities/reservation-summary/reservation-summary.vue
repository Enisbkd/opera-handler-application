<template>
  <div>
    <h2 id="page-heading" data-cy="ReservationSummaryHeading">
      <span v-text="t$('operaHandlerApplicationApp.reservationSummary.home.title')" id="reservation-summary-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.reservationSummary.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ReservationSummaryCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-reservation-summary"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && reservationSummaries && reservationSummaries.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.reservationSummary.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="reservationSummaries && reservationSummaries.length > 0">
      <table class="table table-striped" aria-describedby="reservationSummaries">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resort')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.resort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('eventType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.eventType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'eventType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('eventId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.eventId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'eventId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('consideredDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.consideredDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'consideredDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomCategory')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.roomCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomClass')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.roomClass')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomClass'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('marketCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.marketCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'marketCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sourceCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.sourceCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sourceCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.rateCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('regionCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.regionCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'regionCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('groupId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.groupId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'groupId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.resvType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvInvType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.resvInvType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvInvType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('psuedoRoomYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.psuedoRoomYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'psuedoRoomYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.arrRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('adults')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.adults')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'adults'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('depRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.depRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'depRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('noRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.noRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'noRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('grossRate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.grossRate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'grossRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('netRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.netRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'netRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extraRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.extraRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extraRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ooRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.ooRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ooRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('osRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.osRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'osRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('remainingBlockRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.remainingBlockRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remainingBlockRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('pickedupBlockRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.pickedupBlockRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pickedupBlockRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('singleOccupancy')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.singleOccupancy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'singleOccupancy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('multipleOccupancy')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.multipleOccupancy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'multipleOccupancy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('blockStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.blockStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'blockStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrPersons')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.arrPersons')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrPersons'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('depPersons')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.depPersons')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'depPersons'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('wlRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.wlRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'wlRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('wlPersons')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.wlPersons')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'wlPersons'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dayUseRooms')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.dayUseRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dayUseRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dayUsePersons')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.dayUsePersons')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dayUsePersons'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bookingStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.bookingStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bookingStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.resvStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dayUseYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.dayUseYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dayUseYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('channel')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.channel')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'channel'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('country')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.country')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'country'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nationality')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.nationality')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nationality'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cribs')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.cribs')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cribs'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extraBeds')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.extraBeds')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extraBeds'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('adultsTaxFree')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.adultsTaxFree')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'adultsTaxFree'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('childrenTaxFree')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.childrenTaxFree')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'childrenTaxFree'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateCategory')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.rateCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateClass')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.rateClass')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateClass'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.roomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('foodRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.foodRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'foodRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('otherRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.otherRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'otherRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('totalRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.totalRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'totalRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nonRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.nonRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nonRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('allotmentHeaderId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.allotmentHeaderId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'allotmentHeaderId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.roomRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('foodRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.foodRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'foodRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('otherRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.otherRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'otherRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('totalRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.totalRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'totalRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nonRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.nonRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nonRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('city')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.city')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'city'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('zipCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.zipCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'zipCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('district')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.district')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'district'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('state')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.state')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'state'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children1')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children2')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children3')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children4')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children4')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children4'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children5')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children5')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children5'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ownerFfFlag')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.ownerFfFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ownerFfFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ownerRentalFlag')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.ownerRentalFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ownerRentalFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcGrossRate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcGrossRate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcGrossRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcNetRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcNetRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcNetRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcExtraRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcExtraRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcExtraRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcRoomRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcRoomRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcRoomRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcFoodRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcFoodRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcFoodRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcOtherRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcOtherRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcOtherRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcTotalRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcTotalRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcTotalRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcNonRevenue')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcNonRevenue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcNonRevenue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcRoomRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcRoomRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcRoomRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcFoodRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcFoodRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcFoodRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcOtherRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcOtherRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcOtherRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcTotalRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcTotalRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcTotalRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fcNonRevenueTax')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcNonRevenueTax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fcNonRevenueTax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('currencyCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.currencyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'currencyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('exchangeDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.exchangeDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exchangeDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateBusinessDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.updateBusinessDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateBusinessDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('centralCurrencyCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.centralCurrencyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'centralCurrencyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('centralExchangeRate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.centralExchangeRate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'centralExchangeRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('truncBeginDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.truncBeginDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'truncBeginDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('truncEndDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.truncEndDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'truncEndDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('businessDateCreated')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.businessDateCreated')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'businessDateCreated'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resInsertSource')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.resInsertSource')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resInsertSource'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('parentCompanyId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.parentCompanyId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'parentCompanyId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('agentId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.agentId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'agentId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('gender')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.gender')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'gender'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('vipStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.vipStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'vipStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('quantity')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.quantity')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'quantity'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('turndownStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.turndownStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'turndownStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bookedRoomCategory')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.bookedRoomCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bookedRoomCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sourceProfId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationSummary.sourceProfId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sourceProfId'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="reservationSummary in reservationSummaries" :key="reservationSummary.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ReservationSummaryView', params: { reservationSummaryId: reservationSummary.id } }">{{
                reservationSummary.id
              }}</router-link>
            </td>
            <td>{{ reservationSummary.resort }}</td>
            <td>{{ reservationSummary.eventType }}</td>
            <td>{{ reservationSummary.eventId }}</td>
            <td>{{ reservationSummary.consideredDate }}</td>
            <td>{{ reservationSummary.roomCategory }}</td>
            <td>{{ reservationSummary.roomClass }}</td>
            <td>{{ reservationSummary.marketCode }}</td>
            <td>{{ reservationSummary.sourceCode }}</td>
            <td>{{ reservationSummary.rateCode }}</td>
            <td>{{ reservationSummary.regionCode }}</td>
            <td>{{ reservationSummary.groupId }}</td>
            <td>{{ reservationSummary.resvType }}</td>
            <td>{{ reservationSummary.resvInvType }}</td>
            <td>{{ reservationSummary.psuedoRoomYn }}</td>
            <td>{{ reservationSummary.arrRooms }}</td>
            <td>{{ reservationSummary.adults }}</td>
            <td>{{ reservationSummary.children }}</td>
            <td>{{ reservationSummary.depRooms }}</td>
            <td>{{ reservationSummary.noRooms }}</td>
            <td>{{ reservationSummary.grossRate }}</td>
            <td>{{ reservationSummary.netRoomRevenue }}</td>
            <td>{{ reservationSummary.extraRevenue }}</td>
            <td>{{ reservationSummary.ooRooms }}</td>
            <td>{{ reservationSummary.osRooms }}</td>
            <td>{{ reservationSummary.remainingBlockRooms }}</td>
            <td>{{ reservationSummary.pickedupBlockRooms }}</td>
            <td>{{ reservationSummary.singleOccupancy }}</td>
            <td>{{ reservationSummary.multipleOccupancy }}</td>
            <td>{{ reservationSummary.blockStatus }}</td>
            <td>{{ reservationSummary.arrPersons }}</td>
            <td>{{ reservationSummary.depPersons }}</td>
            <td>{{ reservationSummary.wlRooms }}</td>
            <td>{{ reservationSummary.wlPersons }}</td>
            <td>{{ reservationSummary.dayUseRooms }}</td>
            <td>{{ reservationSummary.dayUsePersons }}</td>
            <td>{{ reservationSummary.bookingStatus }}</td>
            <td>{{ reservationSummary.resvStatus }}</td>
            <td>{{ reservationSummary.dayUseYn }}</td>
            <td>{{ reservationSummary.channel }}</td>
            <td>{{ reservationSummary.country }}</td>
            <td>{{ reservationSummary.nationality }}</td>
            <td>{{ reservationSummary.cribs }}</td>
            <td>{{ reservationSummary.extraBeds }}</td>
            <td>{{ reservationSummary.adultsTaxFree }}</td>
            <td>{{ reservationSummary.childrenTaxFree }}</td>
            <td>{{ reservationSummary.rateCategory }}</td>
            <td>{{ reservationSummary.rateClass }}</td>
            <td>{{ reservationSummary.roomRevenue }}</td>
            <td>{{ reservationSummary.foodRevenue }}</td>
            <td>{{ reservationSummary.otherRevenue }}</td>
            <td>{{ reservationSummary.totalRevenue }}</td>
            <td>{{ reservationSummary.nonRevenue }}</td>
            <td>{{ reservationSummary.allotmentHeaderId }}</td>
            <td>{{ reservationSummary.roomRevenueTax }}</td>
            <td>{{ reservationSummary.foodRevenueTax }}</td>
            <td>{{ reservationSummary.otherRevenueTax }}</td>
            <td>{{ reservationSummary.totalRevenueTax }}</td>
            <td>{{ reservationSummary.nonRevenueTax }}</td>
            <td>{{ reservationSummary.city }}</td>
            <td>{{ reservationSummary.zipCode }}</td>
            <td>{{ reservationSummary.district }}</td>
            <td>{{ reservationSummary.state }}</td>
            <td>{{ reservationSummary.children1 }}</td>
            <td>{{ reservationSummary.children2 }}</td>
            <td>{{ reservationSummary.children3 }}</td>
            <td>{{ reservationSummary.children4 }}</td>
            <td>{{ reservationSummary.children5 }}</td>
            <td>{{ reservationSummary.ownerFfFlag }}</td>
            <td>{{ reservationSummary.ownerRentalFlag }}</td>
            <td>{{ reservationSummary.fcGrossRate }}</td>
            <td>{{ reservationSummary.fcNetRoomRevenue }}</td>
            <td>{{ reservationSummary.fcExtraRevenue }}</td>
            <td>{{ reservationSummary.fcRoomRevenue }}</td>
            <td>{{ reservationSummary.fcFoodRevenue }}</td>
            <td>{{ reservationSummary.fcOtherRevenue }}</td>
            <td>{{ reservationSummary.fcTotalRevenue }}</td>
            <td>{{ reservationSummary.fcNonRevenue }}</td>
            <td>{{ reservationSummary.fcRoomRevenueTax }}</td>
            <td>{{ reservationSummary.fcFoodRevenueTax }}</td>
            <td>{{ reservationSummary.fcOtherRevenueTax }}</td>
            <td>{{ reservationSummary.fcTotalRevenueTax }}</td>
            <td>{{ reservationSummary.fcNonRevenueTax }}</td>
            <td>{{ reservationSummary.currencyCode }}</td>
            <td>{{ reservationSummary.exchangeDate }}</td>
            <td>{{ reservationSummary.updateBusinessDate }}</td>
            <td>{{ reservationSummary.updateDate }}</td>
            <td>{{ reservationSummary.centralCurrencyCode }}</td>
            <td>{{ reservationSummary.centralExchangeRate }}</td>
            <td>{{ reservationSummary.truncBeginDate }}</td>
            <td>{{ reservationSummary.truncEndDate }}</td>
            <td>{{ reservationSummary.businessDateCreated }}</td>
            <td>{{ reservationSummary.resInsertSource }}</td>
            <td>{{ reservationSummary.parentCompanyId }}</td>
            <td>{{ reservationSummary.agentId }}</td>
            <td>{{ reservationSummary.gender }}</td>
            <td>{{ reservationSummary.vipStatus }}</td>
            <td>{{ reservationSummary.quantity }}</td>
            <td>{{ reservationSummary.turndownStatus }}</td>
            <td>{{ reservationSummary.bookedRoomCategory }}</td>
            <td>{{ reservationSummary.sourceProfId }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ReservationSummaryView', params: { reservationSummaryId: reservationSummary.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ReservationSummaryEdit', params: { reservationSummaryId: reservationSummary.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(reservationSummary)"
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
          id="operaHandlerApplicationApp.reservationSummary.delete.question"
          data-cy="reservationSummaryDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p
          id="jhi-delete-reservationSummary-heading"
          v-text="t$('operaHandlerApplicationApp.reservationSummary.delete.question', { id: removeId })"
        ></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-reservationSummary"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeReservationSummary()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="reservationSummaries && reservationSummaries.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./reservation-summary.component.ts"></script>
