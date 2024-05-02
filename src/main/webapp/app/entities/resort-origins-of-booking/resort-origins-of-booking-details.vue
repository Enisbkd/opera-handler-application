<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="resortOriginsOfBooking">
        <h2 class="jh-entity-heading" data-cy="resortOriginsOfBookingDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.detail.title')"></span> {{ resortOriginsOfBooking.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.resort')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.resort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.sourceCode')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.sourceCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.parentSourceCode')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.parentSourceCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.description')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.description }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.inactiveDate')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.inactiveDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.sellSequence')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.sellSequence }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.scOrderby')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.scOrderby }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.internetSalesYn')"></span>
          </dt>
          <dd>
            <span>{{ resortOriginsOfBooking.internetSalesYn }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="resortOriginsOfBooking.id"
          :to="{ name: 'ResortOriginsOfBookingEdit', params: { resortOriginsOfBookingId: resortOriginsOfBooking.id } }"
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

<script lang="ts" src="./resort-origins-of-booking-details.component.ts"></script>
