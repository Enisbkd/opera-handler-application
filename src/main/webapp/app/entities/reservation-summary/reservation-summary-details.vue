<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="reservationSummary">
        <h2 class="jh-entity-heading" data-cy="reservationSummaryDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.reservationSummary.detail.title')"></span> {{ reservationSummary.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.resort')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.resort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.eventType')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.eventType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.eventId')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.eventId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.consideredDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.consideredDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.roomCategory')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.roomCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.roomClass')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.roomClass }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.marketCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.marketCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.sourceCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.sourceCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.rateCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.rateCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.regionCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.regionCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.groupId')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.groupId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.resvType')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.resvType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.resvInvType')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.resvInvType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.psuedoRoomYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.psuedoRoomYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.arrRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.arrRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.adults')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.adults }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.children }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.depRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.depRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.noRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.noRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.grossRate')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.grossRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.netRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.netRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.extraRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.extraRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.ooRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.ooRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.osRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.osRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.remainingBlockRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.remainingBlockRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.pickedupBlockRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.pickedupBlockRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.singleOccupancy')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.singleOccupancy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.multipleOccupancy')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.multipleOccupancy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.blockStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.blockStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.arrPersons')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.arrPersons }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.depPersons')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.depPersons }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.wlRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.wlRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.wlPersons')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.wlPersons }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.dayUseRooms')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.dayUseRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.dayUsePersons')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.dayUsePersons }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.bookingStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.bookingStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.resvStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.resvStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.dayUseYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.dayUseYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.channel')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.channel }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.country')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.country }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.nationality')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.nationality }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.cribs')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.cribs }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.extraBeds')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.extraBeds }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.adultsTaxFree')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.adultsTaxFree }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.childrenTaxFree')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.childrenTaxFree }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.rateCategory')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.rateCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.rateClass')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.rateClass }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.roomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.roomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.foodRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.foodRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.otherRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.otherRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.totalRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.totalRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.nonRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.nonRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.allotmentHeaderId')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.allotmentHeaderId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.roomRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.roomRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.foodRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.foodRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.otherRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.otherRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.totalRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.totalRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.nonRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.nonRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.city')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.city }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.zipCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.zipCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.district')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.district }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.state')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.state }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children1')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.children1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children2')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.children2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children3')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.children3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children4')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.children4 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.children5')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.children5 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.ownerFfFlag')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.ownerFfFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.ownerRentalFlag')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.ownerRentalFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcGrossRate')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcGrossRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcNetRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcNetRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcExtraRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcExtraRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcRoomRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcRoomRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcFoodRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcFoodRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcOtherRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcOtherRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcTotalRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcTotalRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcNonRevenue')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcNonRevenue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcRoomRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcRoomRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcFoodRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcFoodRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcOtherRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcOtherRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcTotalRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcTotalRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.fcNonRevenueTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.fcNonRevenueTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.currencyCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.currencyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.exchangeDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.exchangeDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.updateBusinessDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.updateBusinessDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.centralCurrencyCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.centralCurrencyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.centralExchangeRate')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.centralExchangeRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.truncBeginDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.truncBeginDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.truncEndDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.truncEndDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.businessDateCreated')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.businessDateCreated }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.resInsertSource')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.resInsertSource }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.parentCompanyId')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.parentCompanyId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.agentId')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.agentId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.gender')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.gender }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.vipStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.vipStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.quantity')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.quantity }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.turndownStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.turndownStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.bookedRoomCategory')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.bookedRoomCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationSummary.sourceProfId')"></span>
          </dt>
          <dd>
            <span>{{ reservationSummary.sourceProfId }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="reservationSummary.id"
          :to="{ name: 'ReservationSummaryEdit', params: { reservationSummaryId: reservationSummary.id } }"
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

<script lang="ts" src="./reservation-summary-details.component.ts"></script>
