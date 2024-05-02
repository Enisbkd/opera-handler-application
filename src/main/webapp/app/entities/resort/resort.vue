<template>
  <div>
    <h2 id="page-heading" data-cy="ResortHeading">
      <span v-text="t$('operaHandlerApplicationApp.resort.home.title')" id="resort-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.resort.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ResortCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-resort"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.resort.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && resorts && resorts.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.resort.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="resorts && resorts.length > 0">
      <table class="table table-striped" aria-describedby="resorts">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resort')">
              <span v-text="t$('operaHandlerApplicationApp.resort.resort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('beginDate')">
              <span v-text="t$('operaHandlerApplicationApp.resort.beginDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'beginDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('checkInTime')">
              <span v-text="t$('operaHandlerApplicationApp.resort.checkInTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'checkInTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('checkOutTime')">
              <span v-text="t$('operaHandlerApplicationApp.resort.checkOutTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'checkOutTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('videoCoStart')">
              <span v-text="t$('operaHandlerApplicationApp.resort.videoCoStart')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'videoCoStart'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('videoCoStop')">
              <span v-text="t$('operaHandlerApplicationApp.resort.videoCoStop')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'videoCoStop'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.resort.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.resort.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('expiryDate')">
              <span v-text="t$('operaHandlerApplicationApp.resort.expiryDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'expiryDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('endDate')">
              <span v-text="t$('operaHandlerApplicationApp.resort.endDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'endDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fiscalStartDate')">
              <span v-text="t$('operaHandlerApplicationApp.resort.fiscalStartDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fiscalStartDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fiscalEndDate')">
              <span v-text="t$('operaHandlerApplicationApp.resort.fiscalEndDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fiscalEndDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reconcileDate')">
              <span v-text="t$('operaHandlerApplicationApp.resort.reconcileDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reconcileDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('paymentDate')">
              <span v-text="t$('operaHandlerApplicationApp.resort.paymentDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'paymentDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('keepAvailability')">
              <span v-text="t$('operaHandlerApplicationApp.resort.keepAvailability')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'keepAvailability'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('budgetMonth')">
              <span v-text="t$('operaHandlerApplicationApp.resort.budgetMonth')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'budgetMonth'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('saveProfiles')">
              <span v-text="t$('operaHandlerApplicationApp.resort.saveProfiles')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'saveProfiles'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longStayControl')">
              <span v-text="t$('operaHandlerApplicationApp.resort.longStayControl')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longStayControl'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('creditLimit')">
              <span v-text="t$('operaHandlerApplicationApp.resort.creditLimit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'creditLimit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('numberRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resort.numberRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'numberRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('numberFloors')">
              <span v-text="t$('operaHandlerApplicationApp.resort.numberFloors')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'numberFloors'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('numberBeds')">
              <span v-text="t$('operaHandlerApplicationApp.resort.numberBeds')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'numberBeds'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rhythmSheets')">
              <span v-text="t$('operaHandlerApplicationApp.resort.rhythmSheets')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rhythmSheets'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rhythmTowels')">
              <span v-text="t$('operaHandlerApplicationApp.resort.rhythmTowels')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rhythmTowels'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('warningAmount')">
              <span v-text="t$('operaHandlerApplicationApp.resort.warningAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'warningAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('decimalPlaces')">
              <span v-text="t$('operaHandlerApplicationApp.resort.decimalPlaces')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'decimalPlaces'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('font')">
              <span v-text="t$('operaHandlerApplicationApp.resort.font')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'font'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('copies')">
              <span v-text="t$('operaHandlerApplicationApp.resort.copies')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'copies'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultFolioStyle')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultFolioStyle')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultFolioStyle'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('individualRoomWarning')">
              <span v-text="t$('operaHandlerApplicationApp.resort.individualRoomWarning')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'individualRoomWarning'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('groupRoomWarning')">
              <span v-text="t$('operaHandlerApplicationApp.resort.groupRoomWarning')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'groupRoomWarning'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('agingLevel1')">
              <span v-text="t$('operaHandlerApplicationApp.resort.agingLevel1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'agingLevel1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('agingLevel2')">
              <span v-text="t$('operaHandlerApplicationApp.resort.agingLevel2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'agingLevel2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('agingLevel3')">
              <span v-text="t$('operaHandlerApplicationApp.resort.agingLevel3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'agingLevel3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('agingLevel4')">
              <span v-text="t$('operaHandlerApplicationApp.resort.agingLevel4')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'agingLevel4'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('agingLevel5')">
              <span v-text="t$('operaHandlerApplicationApp.resort.agingLevel5')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'agingLevel5'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('zeroInvPurDays')">
              <span v-text="t$('operaHandlerApplicationApp.resort.zeroInvPurDays')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'zeroInvPurDays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('minDaysBet2ReminderLetter')">
              <span v-text="t$('operaHandlerApplicationApp.resort.minDaysBet2ReminderLetter')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'minDaysBet2ReminderLetter'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.resort.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.resort.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('currencyDecimals')">
              <span v-text="t$('operaHandlerApplicationApp.resort.currencyDecimals')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'currencyDecimals'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameIdLink')">
              <span v-text="t$('operaHandlerApplicationApp.resort.nameIdLink')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameIdLink'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sglRate1')">
              <span v-text="t$('operaHandlerApplicationApp.resort.sglRate1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sglRate1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sglRate2')">
              <span v-text="t$('operaHandlerApplicationApp.resort.sglRate2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sglRate2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dblRate1')">
              <span v-text="t$('operaHandlerApplicationApp.resort.dblRate1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dblRate1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dblRate2')">
              <span v-text="t$('operaHandlerApplicationApp.resort.dblRate2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dblRate2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tplRate1')">
              <span v-text="t$('operaHandlerApplicationApp.resort.tplRate1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tplRate1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tplRate2')">
              <span v-text="t$('operaHandlerApplicationApp.resort.tplRate2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tplRate2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('suiRate1')">
              <span v-text="t$('operaHandlerApplicationApp.resort.suiRate1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'suiRate1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('suiRate2')">
              <span v-text="t$('operaHandlerApplicationApp.resort.suiRate2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'suiRate2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('meetSpace')">
              <span v-text="t$('operaHandlerApplicationApp.resort.meetSpace')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'meetSpace'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('imgHotelId')">
              <span v-text="t$('operaHandlerApplicationApp.resort.imgHotelId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'imgHotelId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('imgDirectionId')">
              <span v-text="t$('operaHandlerApplicationApp.resort.imgDirectionId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'imgDirectionId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('imgMapId')">
              <span v-text="t$('operaHandlerApplicationApp.resort.imgMapId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'imgMapId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('scriptId')">
              <span v-text="t$('operaHandlerApplicationApp.resort.scriptId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'scriptId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('comNameXrefId')">
              <span v-text="t$('operaHandlerApplicationApp.resort.comNameXrefId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'comNameXrefId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('pathId')">
              <span v-text="t$('operaHandlerApplicationApp.resort.pathId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pathId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('xresortNumber')">
              <span v-text="t$('operaHandlerApplicationApp.resort.xresortNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'xresortNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxCreditDays')">
              <span v-text="t$('operaHandlerApplicationApp.resort.maxCreditDays')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxCreditDays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('currencyDivisor')">
              <span v-text="t$('operaHandlerApplicationApp.resort.currencyDivisor')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'currencyDivisor'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('latitude')">
              <span v-text="t$('operaHandlerApplicationApp.resort.latitude')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'latitude'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longitude')">
              <span v-text="t$('operaHandlerApplicationApp.resort.longitude')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longitude'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('qtySingleRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resort.qtySingleRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'qtySingleRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('qtyDoubleRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resort.qtyDoubleRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'qtyDoubleRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('qtyTwinRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resort.qtyTwinRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'qtyTwinRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('qtySuites')">
              <span v-text="t$('operaHandlerApplicationApp.resort.qtySuites')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'qtySuites'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('qtyGuestRoomFloors')">
              <span v-text="t$('operaHandlerApplicationApp.resort.qtyGuestRoomFloors')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'qtyGuestRoomFloors'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('qtyGuestElevators')">
              <span v-text="t$('operaHandlerApplicationApp.resort.qtyGuestElevators')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'qtyGuestElevators'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('qtyNonSmokingRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resort.qtyNonSmokingRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'qtyNonSmokingRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('qtyConnectingRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resort.qtyConnectingRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'qtyConnectingRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('qtyHandicappedRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resort.qtyHandicappedRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'qtyHandicappedRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('qtyFamilyRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resort.qtyFamilyRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'qtyFamilyRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxAdultsFamilyRoom')">
              <span v-text="t$('operaHandlerApplicationApp.resort.maxAdultsFamilyRoom')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxAdultsFamilyRoom'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxChildrenFamilyRoom')">
              <span v-text="t$('operaHandlerApplicationApp.resort.maxChildrenFamilyRoom')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxChildrenFamilyRoom'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('restaurant')">
              <span v-text="t$('operaHandlerApplicationApp.resort.restaurant')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'restaurant'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('meetRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resort.meetRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'meetRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('totRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resort.totRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'totRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('brSeats')">
              <span v-text="t$('operaHandlerApplicationApp.resort.brSeats')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'brSeats'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('meetSeats')">
              <span v-text="t$('operaHandlerApplicationApp.resort.meetSeats')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'meetSeats'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxNoNights')">
              <span v-text="t$('operaHandlerApplicationApp.resort.maxNoNights')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxNoNights'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awardsTimeout')">
              <span v-text="t$('operaHandlerApplicationApp.resort.awardsTimeout')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awardsTimeout'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestLookupTimeout')">
              <span v-text="t$('operaHandlerApplicationApp.resort.guestLookupTimeout')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestLookupTimeout'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('wakeUpDelay')">
              <span v-text="t$('operaHandlerApplicationApp.resort.wakeUpDelay')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'wakeUpDelay'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxOccupancy')">
              <span v-text="t$('operaHandlerApplicationApp.resort.maxOccupancy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxOccupancy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveDaysForGuestProfil')">
              <span v-text="t$('operaHandlerApplicationApp.resort.inactiveDaysForGuestProfil')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'inactiveDaysForGuestProfil'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('perReservationRoomLimit')">
              <span v-text="t$('operaHandlerApplicationApp.resort.perReservationRoomLimit')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'perReservationRoomLimit'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('licRoomInfo')">
              <span v-text="t$('operaHandlerApplicationApp.resort.licRoomInfo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'licRoomInfo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('thousandSeparator')">
              <span v-text="t$('operaHandlerApplicationApp.resort.thousandSeparator')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'thousandSeparator'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dateSeparator')">
              <span v-text="t$('operaHandlerApplicationApp.resort.dateSeparator')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dateSeparator'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arAcctNoMandYn')">
              <span v-text="t$('operaHandlerApplicationApp.resort.arAcctNoMandYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arAcctNoMandYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('exchangePostingType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.exchangePostingType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exchangePostingType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inventoryYn')">
              <span v-text="t$('operaHandlerApplicationApp.resort.inventoryYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inventoryYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('allowLoginYn')">
              <span v-text="t$('operaHandlerApplicationApp.resort.allowLoginYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'allowLoginYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.accessCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('disableLoginYn')">
              <span v-text="t$('operaHandlerApplicationApp.resort.disableLoginYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'disableLoginYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('intTaxIncludedYn')">
              <span v-text="t$('operaHandlerApplicationApp.resort.intTaxIncludedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'intTaxIncludedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('downloadRestYn')">
              <span v-text="t$('operaHandlerApplicationApp.resort.downloadRestYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'downloadRestYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('translateMulticharYn')">
              <span v-text="t$('operaHandlerApplicationApp.resort.translateMulticharYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'translateMulticharYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('externalScYn')">
              <span v-text="t$('operaHandlerApplicationApp.resort.externalScYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'externalScYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sendLeadAsBookingYn')">
              <span v-text="t$('operaHandlerApplicationApp.resort.sendLeadAsBookingYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sendLeadAsBookingYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mbsSupportedYn')">
              <span v-text="t$('operaHandlerApplicationApp.resort.mbsSupportedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mbsSupportedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('quotedCurrency')">
              <span v-text="t$('operaHandlerApplicationApp.resort.quotedCurrency')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'quotedCurrency'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('comMethod')">
              <span v-text="t$('operaHandlerApplicationApp.resort.comMethod')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'comMethod'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('email')">
              <span v-text="t$('operaHandlerApplicationApp.resort.email')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'email'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('genmgr')">
              <span v-text="t$('operaHandlerApplicationApp.resort.genmgr')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'genmgr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dirsales')">
              <span v-text="t$('operaHandlerApplicationApp.resort.dirsales')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dirsales'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('leadsend')">
              <span v-text="t$('operaHandlerApplicationApp.resort.leadsend')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'leadsend'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('airport')">
              <span v-text="t$('operaHandlerApplicationApp.resort.airport')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'airport'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('comAddress')">
              <span v-text="t$('operaHandlerApplicationApp.resort.comAddress')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'comAddress'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('season1')">
              <span v-text="t$('operaHandlerApplicationApp.resort.season1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'season1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('season2')">
              <span v-text="t$('operaHandlerApplicationApp.resort.season2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'season2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('season3')">
              <span v-text="t$('operaHandlerApplicationApp.resort.season3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'season3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('season4')">
              <span v-text="t$('operaHandlerApplicationApp.resort.season4')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'season4'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('season5')">
              <span v-text="t$('operaHandlerApplicationApp.resort.season5')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'season5'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('floorNumExecutiveFloor')">
              <span v-text="t$('operaHandlerApplicationApp.resort.floorNumExecutiveFloor')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'floorNumExecutiveFloor'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('crsResort')">
              <span v-text="t$('operaHandlerApplicationApp.resort.crsResort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'crsResort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.postCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultReservationType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultReservationType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultReservationType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('block')">
              <span v-text="t$('operaHandlerApplicationApp.resort.block')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'block'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('currencySymbol')">
              <span v-text="t$('operaHandlerApplicationApp.resort.currencySymbol')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'currencySymbol'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sourceCommission')">
              <span v-text="t$('operaHandlerApplicationApp.resort.sourceCommission')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sourceCommission'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taCommission')">
              <span v-text="t$('operaHandlerApplicationApp.resort.taCommission')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taCommission'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('baseLanguage')">
              <span v-text="t$('operaHandlerApplicationApp.resort.baseLanguage')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'baseLanguage'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioLanguage1')">
              <span v-text="t$('operaHandlerApplicationApp.resort.folioLanguage1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioLanguage1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioLanguage2')">
              <span v-text="t$('operaHandlerApplicationApp.resort.folioLanguage2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioLanguage2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioLanguage3')">
              <span v-text="t$('operaHandlerApplicationApp.resort.folioLanguage3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioLanguage3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioLanguage4')">
              <span v-text="t$('operaHandlerApplicationApp.resort.folioLanguage4')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioLanguage4'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageProfit')">
              <span v-text="t$('operaHandlerApplicationApp.resort.packageProfit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageProfit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageLoss')">
              <span v-text="t$('operaHandlerApplicationApp.resort.packageLoss')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageLoss'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('decimalSeparator')">
              <span v-text="t$('operaHandlerApplicationApp.resort.decimalSeparator')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'decimalSeparator'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('shortDateFormat')">
              <span v-text="t$('operaHandlerApplicationApp.resort.shortDateFormat')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'shortDateFormat'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longDateFormat')">
              <span v-text="t$('operaHandlerApplicationApp.resort.longDateFormat')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longDateFormat'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('passerbySource')">
              <span v-text="t$('operaHandlerApplicationApp.resort.passerbySource')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'passerbySource'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('passerbyMarket')">
              <span v-text="t$('operaHandlerApplicationApp.resort.passerbyMarket')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'passerbyMarket'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arCompany')">
              <span v-text="t$('operaHandlerApplicationApp.resort.arCompany')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arCompany'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arAgent')">
              <span v-text="t$('operaHandlerApplicationApp.resort.arAgent')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arAgent'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arGroups')">
              <span v-text="t$('operaHandlerApplicationApp.resort.arGroups')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arGroups'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arIndividuals')">
              <span v-text="t$('operaHandlerApplicationApp.resort.arIndividuals')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arIndividuals'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arAcctNoFormat')">
              <span v-text="t$('operaHandlerApplicationApp.resort.arAcctNoFormat')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arAcctNoFormat'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('allowancePeriodAdj')">
              <span v-text="t$('operaHandlerApplicationApp.resort.allowancePeriodAdj')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'allowancePeriodAdj'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('currencyCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.currencyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'currencyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('turnawayCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.turnawayCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'turnawayCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('summCurrencyCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.summCurrencyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'summCurrencyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultPropertyAddress')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultPropertyAddress')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultPropertyAddress'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultGuestAddress')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultGuestAddress')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultGuestAddress'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('licenseCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.licenseCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'licenseCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('timeFormat')">
              <span v-text="t$('operaHandlerApplicationApp.resort.timeFormat')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'timeFormat'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('chainCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.chainCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'chainCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resortType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.resortType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resortType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hotelType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.hotelType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hotelType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ownership')">
              <span v-text="t$('operaHandlerApplicationApp.resort.ownership')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ownership'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arBalTrxCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.arBalTrxCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arBalTrxCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arCreditTrxCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.arCreditTrxCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arCreditTrxCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arSettleCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.arSettleCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arSettleCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cashShiftDrop')">
              <span v-text="t$('operaHandlerApplicationApp.resort.cashShiftDrop')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cashShiftDrop'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('checkExgPaidout')">
              <span v-text="t$('operaHandlerApplicationApp.resort.checkExgPaidout')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'checkExgPaidout'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('checkShiftDrop')">
              <span v-text="t$('operaHandlerApplicationApp.resort.checkShiftDrop')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'checkShiftDrop'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('checkTrxcode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.checkTrxcode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'checkTrxcode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('currencyExgPaidout')">
              <span v-text="t$('operaHandlerApplicationApp.resort.currencyExgPaidout')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'currencyExgPaidout'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('depositLedTrxCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.depositLedTrxCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'depositLedTrxCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fiscalPeriodType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.fiscalPeriodType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fiscalPeriodType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultCommissionPercentage')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultCommissionPercentage')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'defaultCommissionPercentage'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultPrepaidComm')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultPrepaidComm')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultPrepaidComm'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultTrxCommCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultTrxCommCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultTrxCommCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('configurationMode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.configurationMode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'configurationMode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('weekendDays')">
              <span v-text="t$('operaHandlerApplicationApp.resort.weekendDays')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'weekendDays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultGroupsRateCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultGroupsRateCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultGroupsRateCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultPostingRoom')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultPostingRoom')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultPostingRoom'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dfltPkgTranCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.dfltPkgTranCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dfltPkgTranCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dfltTranCodeRateCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.dfltTranCodeRateCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dfltTranCodeRateCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultRateCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultRateCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultRateCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('croCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.croCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'croCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flowCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.flowCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flowCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extPropertyCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.extPropertyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extPropertyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('opusCurrencyCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.opusCurrencyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'opusCurrencyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('destinationId')">
              <span v-text="t$('operaHandlerApplicationApp.resort.destinationId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'destinationId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('flags')">
              <span v-text="t$('operaHandlerApplicationApp.resort.flags')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'flags'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('touristNumber')">
              <span v-text="t$('operaHandlerApplicationApp.resort.touristNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'touristNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cateringCurrencyCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.cateringCurrencyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cateringCurrencyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultRatecodeRack')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultRatecodeRack')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultRatecodeRack'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultRatecodePcr')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultRatecodePcr')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultRatecodePcr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fnsTier')">
              <span v-text="t$('operaHandlerApplicationApp.resort.fnsTier')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fnsTier'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('brandCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.brandCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'brandCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('webaddress')">
              <span v-text="t$('operaHandlerApplicationApp.resort.webaddress')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'webaddress'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('vatId')">
              <span v-text="t$('operaHandlerApplicationApp.resort.vatId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'vatId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('street')">
              <span v-text="t$('operaHandlerApplicationApp.resort.street')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'street'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hotelFc')">
              <span v-text="t$('operaHandlerApplicationApp.resort.hotelFc')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hotelFc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('meetingFc')">
              <span v-text="t$('operaHandlerApplicationApp.resort.meetingFc')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'meetingFc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arTypewriter')">
              <span v-text="t$('operaHandlerApplicationApp.resort.arTypewriter')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arTypewriter'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fileTransferFormat')">
              <span v-text="t$('operaHandlerApplicationApp.resort.fileTransferFormat')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fileTransferFormat'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('confirmRegcardPrinter')">
              <span v-text="t$('operaHandlerApplicationApp.resort.confirmRegcardPrinter')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'confirmRegcardPrinter'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('directions')">
              <span v-text="t$('operaHandlerApplicationApp.resort.directions')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'directions'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('propinfoUrl')">
              <span v-text="t$('operaHandlerApplicationApp.resort.propinfoUrl')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'propinfoUrl'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomAmenity')">
              <span v-text="t$('operaHandlerApplicationApp.resort.roomAmenity')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomAmenity'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('shopDescription')">
              <span v-text="t$('operaHandlerApplicationApp.resort.shopDescription')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'shopDescription'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('propPicUrl')">
              <span v-text="t$('operaHandlerApplicationApp.resort.propPicUrl')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'propPicUrl'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('propMapUrl')">
              <span v-text="t$('operaHandlerApplicationApp.resort.propMapUrl')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'propMapUrl'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extExpFileLocation')">
              <span v-text="t$('operaHandlerApplicationApp.resort.extExpFileLocation')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extExpFileLocation'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('curtainColor')">
              <span v-text="t$('operaHandlerApplicationApp.resort.curtainColor')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'curtainColor'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('countryCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.countryCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'countryCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('state')">
              <span v-text="t$('operaHandlerApplicationApp.resort.state')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'state'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dateForAging')">
              <span v-text="t$('operaHandlerApplicationApp.resort.dateForAging')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dateForAging'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('regionCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.regionCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'regionCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('city')">
              <span v-text="t$('operaHandlerApplicationApp.resort.city')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'city'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('telephone')">
              <span v-text="t$('operaHandlerApplicationApp.resort.telephone')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'telephone'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fax')">
              <span v-text="t$('operaHandlerApplicationApp.resort.fax')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fax'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tollfree')">
              <span v-text="t$('operaHandlerApplicationApp.resort.tollfree')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tollfree'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultPrinter')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultPrinter')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultPrinter'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('videocheckoutPrinter')">
              <span v-text="t$('operaHandlerApplicationApp.resort.videocheckoutPrinter')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'videocheckoutPrinter'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('companyAddressType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.companyAddressType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'companyAddressType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('companyPhoneType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.companyPhoneType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'companyPhoneType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultFaxType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultFaxType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultFaxType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultMembershipType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultMembershipType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultMembershipType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('individualAddressType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.individualAddressType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'individualAddressType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('individualPhoneType')">
              <span v-text="t$('operaHandlerApplicationApp.resort.individualPhoneType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'individualPhoneType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('notes')">
              <span v-text="t$('operaHandlerApplicationApp.resort.notes')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'notes'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('blackoutPeriodNotes')">
              <span v-text="t$('operaHandlerApplicationApp.resort.blackoutPeriodNotes')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'blackoutPeriodNotes'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sglNum')">
              <span v-text="t$('operaHandlerApplicationApp.resort.sglNum')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sglNum'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dblNum')">
              <span v-text="t$('operaHandlerApplicationApp.resort.dblNum')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dblNum'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tplNum')">
              <span v-text="t$('operaHandlerApplicationApp.resort.tplNum')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tplNum'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('suiNum')">
              <span v-text="t$('operaHandlerApplicationApp.resort.suiNum')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'suiNum'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('airportDistance')">
              <span v-text="t$('operaHandlerApplicationApp.resort.airportDistance')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'airportDistance'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('airportTime')">
              <span v-text="t$('operaHandlerApplicationApp.resort.airportTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'airportTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('brArea')">
              <span v-text="t$('operaHandlerApplicationApp.resort.brArea')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'brArea'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('name')">
              <span v-text="t$('operaHandlerApplicationApp.resort.name')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'name'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('legalOwner')">
              <span v-text="t$('operaHandlerApplicationApp.resort.legalOwner')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'legalOwner'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hotelId')">
              <span v-text="t$('operaHandlerApplicationApp.resort.hotelId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hotelId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('faxNoFormat')">
              <span v-text="t$('operaHandlerApplicationApp.resort.faxNoFormat')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'faxNoFormat'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('telephoneNoFormat')">
              <span v-text="t$('operaHandlerApplicationApp.resort.telephoneNoFormat')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'telephoneNoFormat'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('localCurrencyFormat')">
              <span v-text="t$('operaHandlerApplicationApp.resort.localCurrencyFormat')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'localCurrencyFormat'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dutyManagerPager')">
              <span v-text="t$('operaHandlerApplicationApp.resort.dutyManagerPager')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dutyManagerPager'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultRegistrationCard')">
              <span v-text="t$('operaHandlerApplicationApp.resort.defaultRegistrationCard')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'defaultRegistrationCard'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nightAuditCashierId')">
              <span v-text="t$('operaHandlerApplicationApp.resort.nightAuditCashierId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nightAuditCashierId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hotelCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.hotelCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hotelCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('path')">
              <span v-text="t$('operaHandlerApplicationApp.resort.path')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'path'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('timezoneRegion')">
              <span v-text="t$('operaHandlerApplicationApp.resort.timezoneRegion')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'timezoneRegion'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cateringCurrencyFormat')">
              <span v-text="t$('operaHandlerApplicationApp.resort.cateringCurrencyFormat')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cateringCurrencyFormat'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('expHotelCode')">
              <span v-text="t$('operaHandlerApplicationApp.resort.expHotelCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'expHotelCode'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="resort in resorts" :key="resort.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ResortView', params: { resortId: resort.id } }">{{ resort.id }}</router-link>
            </td>
            <td>{{ resort.resort }}</td>
            <td>{{ formatDateShort(resort.beginDate) || '' }}</td>
            <td>{{ formatDateShort(resort.checkInTime) || '' }}</td>
            <td>{{ formatDateShort(resort.checkOutTime) || '' }}</td>
            <td>{{ formatDateShort(resort.videoCoStart) || '' }}</td>
            <td>{{ formatDateShort(resort.videoCoStop) || '' }}</td>
            <td>{{ formatDateShort(resort.insertDate) || '' }}</td>
            <td>{{ formatDateShort(resort.updateDate) || '' }}</td>
            <td>{{ formatDateShort(resort.expiryDate) || '' }}</td>
            <td>{{ formatDateShort(resort.endDate) || '' }}</td>
            <td>{{ formatDateShort(resort.fiscalStartDate) || '' }}</td>
            <td>{{ formatDateShort(resort.fiscalEndDate) || '' }}</td>
            <td>{{ formatDateShort(resort.reconcileDate) || '' }}</td>
            <td>{{ formatDateShort(resort.paymentDate) || '' }}</td>
            <td>{{ resort.keepAvailability }}</td>
            <td>{{ resort.budgetMonth }}</td>
            <td>{{ resort.saveProfiles }}</td>
            <td>{{ resort.longStayControl }}</td>
            <td>{{ resort.creditLimit }}</td>
            <td>{{ resort.numberRooms }}</td>
            <td>{{ resort.numberFloors }}</td>
            <td>{{ resort.numberBeds }}</td>
            <td>{{ resort.rhythmSheets }}</td>
            <td>{{ resort.rhythmTowels }}</td>
            <td>{{ resort.warningAmount }}</td>
            <td>{{ resort.decimalPlaces }}</td>
            <td>{{ resort.font }}</td>
            <td>{{ resort.copies }}</td>
            <td>{{ resort.defaultFolioStyle }}</td>
            <td>{{ resort.individualRoomWarning }}</td>
            <td>{{ resort.groupRoomWarning }}</td>
            <td>{{ resort.agingLevel1 }}</td>
            <td>{{ resort.agingLevel2 }}</td>
            <td>{{ resort.agingLevel3 }}</td>
            <td>{{ resort.agingLevel4 }}</td>
            <td>{{ resort.agingLevel5 }}</td>
            <td>{{ resort.zeroInvPurDays }}</td>
            <td>{{ resort.minDaysBet2ReminderLetter }}</td>
            <td>{{ resort.insertUser }}</td>
            <td>{{ resort.updateUser }}</td>
            <td>{{ resort.currencyDecimals }}</td>
            <td>{{ resort.nameIdLink }}</td>
            <td>{{ resort.sglRate1 }}</td>
            <td>{{ resort.sglRate2 }}</td>
            <td>{{ resort.dblRate1 }}</td>
            <td>{{ resort.dblRate2 }}</td>
            <td>{{ resort.tplRate1 }}</td>
            <td>{{ resort.tplRate2 }}</td>
            <td>{{ resort.suiRate1 }}</td>
            <td>{{ resort.suiRate2 }}</td>
            <td>{{ resort.meetSpace }}</td>
            <td>{{ resort.imgHotelId }}</td>
            <td>{{ resort.imgDirectionId }}</td>
            <td>{{ resort.imgMapId }}</td>
            <td>{{ resort.scriptId }}</td>
            <td>{{ resort.comNameXrefId }}</td>
            <td>{{ resort.pathId }}</td>
            <td>{{ resort.xresortNumber }}</td>
            <td>{{ resort.maxCreditDays }}</td>
            <td>{{ resort.currencyDivisor }}</td>
            <td>{{ resort.latitude }}</td>
            <td>{{ resort.longitude }}</td>
            <td>{{ resort.qtySingleRooms }}</td>
            <td>{{ resort.qtyDoubleRooms }}</td>
            <td>{{ resort.qtyTwinRooms }}</td>
            <td>{{ resort.qtySuites }}</td>
            <td>{{ resort.qtyGuestRoomFloors }}</td>
            <td>{{ resort.qtyGuestElevators }}</td>
            <td>{{ resort.qtyNonSmokingRooms }}</td>
            <td>{{ resort.qtyConnectingRooms }}</td>
            <td>{{ resort.qtyHandicappedRooms }}</td>
            <td>{{ resort.qtyFamilyRooms }}</td>
            <td>{{ resort.maxAdultsFamilyRoom }}</td>
            <td>{{ resort.maxChildrenFamilyRoom }}</td>
            <td>{{ resort.restaurant }}</td>
            <td>{{ resort.meetRooms }}</td>
            <td>{{ resort.totRooms }}</td>
            <td>{{ resort.brSeats }}</td>
            <td>{{ resort.meetSeats }}</td>
            <td>{{ resort.maxNoNights }}</td>
            <td>{{ resort.awardsTimeout }}</td>
            <td>{{ resort.guestLookupTimeout }}</td>
            <td>{{ resort.wakeUpDelay }}</td>
            <td>{{ resort.maxOccupancy }}</td>
            <td>{{ resort.inactiveDaysForGuestProfil }}</td>
            <td>{{ resort.perReservationRoomLimit }}</td>
            <td>{{ resort.licRoomInfo }}</td>
            <td>{{ resort.thousandSeparator }}</td>
            <td>{{ resort.dateSeparator }}</td>
            <td>{{ resort.arAcctNoMandYn }}</td>
            <td>{{ resort.exchangePostingType }}</td>
            <td>{{ resort.inventoryYn }}</td>
            <td>{{ resort.allowLoginYn }}</td>
            <td>{{ resort.accessCode }}</td>
            <td>{{ resort.disableLoginYn }}</td>
            <td>{{ resort.intTaxIncludedYn }}</td>
            <td>{{ resort.downloadRestYn }}</td>
            <td>{{ resort.translateMulticharYn }}</td>
            <td>{{ resort.externalScYn }}</td>
            <td>{{ resort.sendLeadAsBookingYn }}</td>
            <td>{{ resort.mbsSupportedYn }}</td>
            <td>{{ resort.quotedCurrency }}</td>
            <td>{{ resort.comMethod }}</td>
            <td>{{ resort.email }}</td>
            <td>{{ resort.genmgr }}</td>
            <td>{{ resort.dirsales }}</td>
            <td>{{ resort.leadsend }}</td>
            <td>{{ resort.airport }}</td>
            <td>{{ resort.comAddress }}</td>
            <td>{{ resort.season1 }}</td>
            <td>{{ resort.season2 }}</td>
            <td>{{ resort.season3 }}</td>
            <td>{{ resort.season4 }}</td>
            <td>{{ resort.season5 }}</td>
            <td>{{ resort.floorNumExecutiveFloor }}</td>
            <td>{{ resort.crsResort }}</td>
            <td>{{ resort.postCode }}</td>
            <td>{{ resort.defaultReservationType }}</td>
            <td>{{ resort.block }}</td>
            <td>{{ resort.currencySymbol }}</td>
            <td>{{ resort.sourceCommission }}</td>
            <td>{{ resort.taCommission }}</td>
            <td>{{ resort.baseLanguage }}</td>
            <td>{{ resort.folioLanguage1 }}</td>
            <td>{{ resort.folioLanguage2 }}</td>
            <td>{{ resort.folioLanguage3 }}</td>
            <td>{{ resort.folioLanguage4 }}</td>
            <td>{{ resort.packageProfit }}</td>
            <td>{{ resort.packageLoss }}</td>
            <td>{{ resort.decimalSeparator }}</td>
            <td>{{ resort.shortDateFormat }}</td>
            <td>{{ resort.longDateFormat }}</td>
            <td>{{ resort.passerbySource }}</td>
            <td>{{ resort.passerbyMarket }}</td>
            <td>{{ resort.arCompany }}</td>
            <td>{{ resort.arAgent }}</td>
            <td>{{ resort.arGroups }}</td>
            <td>{{ resort.arIndividuals }}</td>
            <td>{{ resort.arAcctNoFormat }}</td>
            <td>{{ resort.allowancePeriodAdj }}</td>
            <td>{{ resort.currencyCode }}</td>
            <td>{{ resort.turnawayCode }}</td>
            <td>{{ resort.summCurrencyCode }}</td>
            <td>{{ resort.defaultPropertyAddress }}</td>
            <td>{{ resort.defaultGuestAddress }}</td>
            <td>{{ resort.licenseCode }}</td>
            <td>{{ resort.timeFormat }}</td>
            <td>{{ resort.chainCode }}</td>
            <td>{{ resort.resortType }}</td>
            <td>{{ resort.hotelType }}</td>
            <td>{{ resort.ownership }}</td>
            <td>{{ resort.arBalTrxCode }}</td>
            <td>{{ resort.arCreditTrxCode }}</td>
            <td>{{ resort.arSettleCode }}</td>
            <td>{{ resort.cashShiftDrop }}</td>
            <td>{{ resort.checkExgPaidout }}</td>
            <td>{{ resort.checkShiftDrop }}</td>
            <td>{{ resort.checkTrxcode }}</td>
            <td>{{ resort.currencyExgPaidout }}</td>
            <td>{{ resort.depositLedTrxCode }}</td>
            <td>{{ resort.fiscalPeriodType }}</td>
            <td>{{ resort.defaultCommissionPercentage }}</td>
            <td>{{ resort.defaultPrepaidComm }}</td>
            <td>{{ resort.defaultTrxCommCode }}</td>
            <td>{{ resort.configurationMode }}</td>
            <td>{{ resort.weekendDays }}</td>
            <td>{{ resort.defaultGroupsRateCode }}</td>
            <td>{{ resort.defaultPostingRoom }}</td>
            <td>{{ resort.dfltPkgTranCode }}</td>
            <td>{{ resort.dfltTranCodeRateCode }}</td>
            <td>{{ resort.defaultRateCode }}</td>
            <td>{{ resort.croCode }}</td>
            <td>{{ resort.flowCode }}</td>
            <td>{{ resort.extPropertyCode }}</td>
            <td>{{ resort.opusCurrencyCode }}</td>
            <td>{{ resort.destinationId }}</td>
            <td>{{ resort.flags }}</td>
            <td>{{ resort.touristNumber }}</td>
            <td>{{ resort.cateringCurrencyCode }}</td>
            <td>{{ resort.defaultRatecodeRack }}</td>
            <td>{{ resort.defaultRatecodePcr }}</td>
            <td>{{ resort.fnsTier }}</td>
            <td>{{ resort.brandCode }}</td>
            <td>{{ resort.webaddress }}</td>
            <td>{{ resort.vatId }}</td>
            <td>{{ resort.street }}</td>
            <td>{{ resort.hotelFc }}</td>
            <td>{{ resort.meetingFc }}</td>
            <td>{{ resort.arTypewriter }}</td>
            <td>{{ resort.fileTransferFormat }}</td>
            <td>{{ resort.confirmRegcardPrinter }}</td>
            <td>{{ resort.directions }}</td>
            <td>{{ resort.propinfoUrl }}</td>
            <td>{{ resort.roomAmenity }}</td>
            <td>{{ resort.shopDescription }}</td>
            <td>{{ resort.propPicUrl }}</td>
            <td>{{ resort.propMapUrl }}</td>
            <td>{{ resort.extExpFileLocation }}</td>
            <td>{{ resort.curtainColor }}</td>
            <td>{{ resort.countryCode }}</td>
            <td>{{ resort.state }}</td>
            <td>{{ resort.dateForAging }}</td>
            <td>{{ resort.regionCode }}</td>
            <td>{{ resort.city }}</td>
            <td>{{ resort.telephone }}</td>
            <td>{{ resort.fax }}</td>
            <td>{{ resort.tollfree }}</td>
            <td>{{ resort.defaultPrinter }}</td>
            <td>{{ resort.videocheckoutPrinter }}</td>
            <td>{{ resort.companyAddressType }}</td>
            <td>{{ resort.companyPhoneType }}</td>
            <td>{{ resort.defaultFaxType }}</td>
            <td>{{ resort.defaultMembershipType }}</td>
            <td>{{ resort.individualAddressType }}</td>
            <td>{{ resort.individualPhoneType }}</td>
            <td>{{ resort.notes }}</td>
            <td>{{ resort.blackoutPeriodNotes }}</td>
            <td>{{ resort.sglNum }}</td>
            <td>{{ resort.dblNum }}</td>
            <td>{{ resort.tplNum }}</td>
            <td>{{ resort.suiNum }}</td>
            <td>{{ resort.airportDistance }}</td>
            <td>{{ resort.airportTime }}</td>
            <td>{{ resort.brArea }}</td>
            <td>{{ resort.name }}</td>
            <td>{{ resort.legalOwner }}</td>
            <td>{{ resort.hotelId }}</td>
            <td>{{ resort.faxNoFormat }}</td>
            <td>{{ resort.telephoneNoFormat }}</td>
            <td>{{ resort.localCurrencyFormat }}</td>
            <td>{{ resort.dutyManagerPager }}</td>
            <td>{{ resort.defaultRegistrationCard }}</td>
            <td>{{ resort.nightAuditCashierId }}</td>
            <td>{{ resort.hotelCode }}</td>
            <td>{{ resort.path }}</td>
            <td>{{ resort.timezoneRegion }}</td>
            <td>{{ resort.cateringCurrencyFormat }}</td>
            <td>{{ resort.expHotelCode }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ResortView', params: { resortId: resort.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'ResortEdit', params: { resortId: resort.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(resort)"
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
          id="operaHandlerApplicationApp.resort.delete.question"
          data-cy="resortDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-resort-heading" v-text="t$('operaHandlerApplicationApp.resort.delete.question', { id: removeId })"></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-resort"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeResort()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="resorts && resorts.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./resort.component.ts"></script>
