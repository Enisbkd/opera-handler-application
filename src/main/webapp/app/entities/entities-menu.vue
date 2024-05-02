<template>
  <div>
    <b-dropdown-item to="/application-user">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.applicationUser')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/financial-transactions">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.financialTransactions')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/name-address">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.nameAddress')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/name-phone">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.namePhone')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/reservation-summary">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.reservationSummary')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/reservation-daily-elements">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.reservationDailyElements')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/reservation-daily-element-name">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.reservationDailyElementName')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/reservation-stat-daily">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.reservationStatDaily')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/resort">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.resort')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/resort-origins-of-booking">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.resortOriginsOfBooking')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/resort-room-category">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.resortRoomCategory')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/reservation-name">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.reservationName')"></span>
    </b-dropdown-item>
    <b-dropdown-item to="/name">
      <font-awesome-icon icon="asterisk" />
      <span v-text="t$('global.menu.entities.name')"></span>
    </b-dropdown-item>
    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
  </div>
</template>

<script lang="ts" src="./entities-menu.component.ts"></script>
