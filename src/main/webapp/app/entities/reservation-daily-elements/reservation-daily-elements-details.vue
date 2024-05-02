<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="reservationDailyElements">
        <h2 class="jh-entity-heading" data-cy="reservationDailyElementsDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.detail.title')"></span> {{ reservationDailyElements.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.resort')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.resort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.reservationDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.reservationDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.resvDailyElSeq')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.resvDailyElSeq }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.resvStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.resvStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.externalReference')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.externalReference }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomClass')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.roomClass }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomCategory')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.roomCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.bookedRoomCategory')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.bookedRoomCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.room')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.room }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.cancellationNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.cancellationDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.cancellationCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationReasonDesc')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.cancellationReasonDesc }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.guaranteeCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.guaranteeCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.marketCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.marketCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.originOfBooking')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.originOfBooking }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.exchangeRate')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.exchangeRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.originalBaseRate')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.originalBaseRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.baseRateAmount')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.baseRateAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.rateAmount')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.rateAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomCost')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.roomCost }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.quantity')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.quantity }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.adults')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.adults }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.children')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.children }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.physicalQuantity')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.physicalQuantity }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.allotmentHeaderId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.allotmentHeaderId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.dayUseYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.dayUseYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.dueOutYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.dueOutYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.insertActionInstanceId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.insertActionInstanceId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.dmlSeqNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.dmlSeqNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.extSeqNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.extSeqNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.extSegNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.extSegNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cribs')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.cribs }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.extraBeds')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.extraBeds }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.allotmentRecordType')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.allotmentRecordType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.blockResort')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.blockResort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.blockId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.blockId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.turndownStatus')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.turndownStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.awdUpgrFrom')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.awdUpgrFrom }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.awdUpgrTo')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.awdUpgrTo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.hkExpectedServiceTime')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.hkExpectedServiceTime }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomInstructions')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElements.roomInstructions }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="reservationDailyElements.id"
          :to="{ name: 'ReservationDailyElementsEdit', params: { reservationDailyElementsId: reservationDailyElements.id } }"
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

<script lang="ts" src="./reservation-daily-elements-details.component.ts"></script>
