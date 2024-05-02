<template>
  <div>
    <h2 id="page-heading" data-cy="ResortRoomCategoryHeading">
      <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.home.title')" id="resort-room-category-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ResortRoomCategoryCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-resort-room-category"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && resortRoomCategories && resortRoomCategories.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="resortRoomCategories && resortRoomCategories.length > 0">
      <table class="table table-striped" aria-describedby="resortRoomCategories">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resort')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.resort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomCategory')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roomCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomClass')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roomClass')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomClass'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('numberRooms')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.numberRooms')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'numberRooms'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('shortDescription')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.shortDescription')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'shortDescription'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longDescription')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.longDescription')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longDescription'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('compiled')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.compiled')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'compiled'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('psuedoRoomType')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.psuedoRoomType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'psuedoRoomType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('activeDate')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.activeDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'activeDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveDate')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.inactiveDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inactiveDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('replacesCategory')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.replacesCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'replacesCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('orderBy')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.orderBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'orderBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxOccupancy')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxOccupancy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxOccupancy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxRollaways')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxRollaways')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxRollaways'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateCategory')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('label')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.label')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'label'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('genericFlag')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.genericFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'genericFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('suiteYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.suiteYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'suiteYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('meetingroomYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.meetingroomYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'meetingroomYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateCode')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateAmount')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defOccupancy')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.defOccupancy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defOccupancy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('imageId')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.imageId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'imageId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('pseudoYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.pseudoYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pseudoYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sendToInterfaceYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sendToInterfaceYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sendToInterfaceYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('yieldableYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.yieldableYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'yieldableYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('yieldCategory')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.yieldCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'yieldCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('housekeeping')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.housekeeping')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'housekeeping'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('canDeleteYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.canDeleteYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'canDeleteYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roominfoUrl')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roominfoUrl')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roominfoUrl'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ownerYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ownerYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ownerYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('autoIncludeYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.autoIncludeYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoIncludeYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('initialRoundUp')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.initialRoundUp')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'initialRoundUp'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('increments')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.increments')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'increments'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rotationGroup')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rotationGroup')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rotationGroup'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('salesFlag')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.salesFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'salesFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('autoRoomAssignYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.autoRoomAssignYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoRoomAssignYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('upsellYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.upsellYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upsellYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ormsUpsellRank')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsUpsellRank')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ormsUpsellRank'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ormsUpsellAmt')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsUpsellAmt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ormsUpsellAmt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ormsDrxtraAdult')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrxtraAdult')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ormsDrxtraAdult'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ormsDrxtraChild')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrxtraChild')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ormsDrxtraChild'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxOccupancyAdults')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxOccupancyAdults')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxOccupancyAdults'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxOccupancyChildren')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxOccupancyChildren')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxOccupancyChildren'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomPool')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roomPool')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomPool'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('memberAwardRoomGrp')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.memberAwardRoomGrp')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'memberAwardRoomGrp'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ormsDrxtra2ndAdult')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrxtra2ndAdult')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ormsDrxtra2ndAdult'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ormsDrtier1')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrtier1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ormsDrtier1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ormsDrtier2')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrtier2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ormsDrtier2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ormsDrtier3')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrtier3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ormsDrtier3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('autoCheckinYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.autoCheckinYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoCheckinYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateFloor')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateFloor')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateFloor'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maxFixBedOccupancy')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxFixBedOccupancy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maxFixBedOccupancy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('maintenanceYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maintenanceYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'maintenanceYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('smokingPreference')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.smokingPreference')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'smokingPreference'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sLabel')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sLabel')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sLabel'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sBedtype')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sBedtype')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sBedtype'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sellThruRuleYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sellThruRuleYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sellThruRuleYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('crsDescription')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.crsDescription')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'crsDescription'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('evisitorFacilityId')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.evisitorFacilityId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'evisitorFacilityId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('minOccupancy')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.minOccupancy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'minOccupancy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accessibleYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.accessibleYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accessibleYn'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="resortRoomCategory in resortRoomCategories" :key="resortRoomCategory.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ResortRoomCategoryView', params: { resortRoomCategoryId: resortRoomCategory.id } }">{{
                resortRoomCategory.id
              }}</router-link>
            </td>
            <td>{{ resortRoomCategory.resort }}</td>
            <td>{{ resortRoomCategory.roomCategory }}</td>
            <td>{{ resortRoomCategory.roomClass }}</td>
            <td>{{ resortRoomCategory.numberRooms }}</td>
            <td>{{ resortRoomCategory.shortDescription }}</td>
            <td>{{ resortRoomCategory.longDescription }}</td>
            <td>{{ resortRoomCategory.compiled }}</td>
            <td>{{ resortRoomCategory.psuedoRoomType }}</td>
            <td>{{ resortRoomCategory.activeDate }}</td>
            <td>{{ resortRoomCategory.inactiveDate }}</td>
            <td>{{ resortRoomCategory.replacesCategory }}</td>
            <td>{{ resortRoomCategory.orderBy }}</td>
            <td>{{ resortRoomCategory.maxOccupancy }}</td>
            <td>{{ resortRoomCategory.maxRollaways }}</td>
            <td>{{ resortRoomCategory.rateCategory }}</td>
            <td>{{ resortRoomCategory.label }}</td>
            <td>{{ resortRoomCategory.genericFlag }}</td>
            <td>{{ resortRoomCategory.suiteYn }}</td>
            <td>{{ resortRoomCategory.meetingroomYn }}</td>
            <td>{{ resortRoomCategory.insertUser }}</td>
            <td>{{ resortRoomCategory.insertDate }}</td>
            <td>{{ resortRoomCategory.updateUser }}</td>
            <td>{{ resortRoomCategory.updateDate }}</td>
            <td>{{ resortRoomCategory.rateCode }}</td>
            <td>{{ resortRoomCategory.rateAmount }}</td>
            <td>{{ resortRoomCategory.defOccupancy }}</td>
            <td>{{ resortRoomCategory.imageId }}</td>
            <td>{{ resortRoomCategory.pseudoYn }}</td>
            <td>{{ resortRoomCategory.sendToInterfaceYn }}</td>
            <td>{{ resortRoomCategory.yieldableYn }}</td>
            <td>{{ resortRoomCategory.yieldCategory }}</td>
            <td>{{ resortRoomCategory.housekeeping }}</td>
            <td>{{ resortRoomCategory.canDeleteYn }}</td>
            <td>{{ resortRoomCategory.roominfoUrl }}</td>
            <td>{{ resortRoomCategory.ownerYn }}</td>
            <td>{{ resortRoomCategory.autoIncludeYn }}</td>
            <td>{{ resortRoomCategory.initialRoundUp }}</td>
            <td>{{ resortRoomCategory.increments }}</td>
            <td>{{ resortRoomCategory.rotationGroup }}</td>
            <td>{{ resortRoomCategory.salesFlag }}</td>
            <td>{{ resortRoomCategory.autoRoomAssignYn }}</td>
            <td>{{ resortRoomCategory.upsellYn }}</td>
            <td>{{ resortRoomCategory.ormsUpsellRank }}</td>
            <td>{{ resortRoomCategory.ormsUpsellAmt }}</td>
            <td>{{ resortRoomCategory.ormsDrxtraAdult }}</td>
            <td>{{ resortRoomCategory.ormsDrxtraChild }}</td>
            <td>{{ resortRoomCategory.maxOccupancyAdults }}</td>
            <td>{{ resortRoomCategory.maxOccupancyChildren }}</td>
            <td>{{ resortRoomCategory.roomPool }}</td>
            <td>{{ resortRoomCategory.memberAwardRoomGrp }}</td>
            <td>{{ resortRoomCategory.ormsDrxtra2ndAdult }}</td>
            <td>{{ resortRoomCategory.ormsDrtier1 }}</td>
            <td>{{ resortRoomCategory.ormsDrtier2 }}</td>
            <td>{{ resortRoomCategory.ormsDrtier3 }}</td>
            <td>{{ resortRoomCategory.autoCheckinYn }}</td>
            <td>{{ resortRoomCategory.rateFloor }}</td>
            <td>{{ resortRoomCategory.maxFixBedOccupancy }}</td>
            <td>{{ resortRoomCategory.maintenanceYn }}</td>
            <td>{{ resortRoomCategory.smokingPreference }}</td>
            <td>{{ resortRoomCategory.sLabel }}</td>
            <td>{{ resortRoomCategory.sBedtype }}</td>
            <td>{{ resortRoomCategory.sellThruRuleYn }}</td>
            <td>{{ resortRoomCategory.crsDescription }}</td>
            <td>{{ resortRoomCategory.evisitorFacilityId }}</td>
            <td>{{ resortRoomCategory.minOccupancy }}</td>
            <td>{{ resortRoomCategory.accessibleYn }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ResortRoomCategoryView', params: { resortRoomCategoryId: resortRoomCategory.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ResortRoomCategoryEdit', params: { resortRoomCategoryId: resortRoomCategory.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(resortRoomCategory)"
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
          id="operaHandlerApplicationApp.resortRoomCategory.delete.question"
          data-cy="resortRoomCategoryDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p
          id="jhi-delete-resortRoomCategory-heading"
          v-text="t$('operaHandlerApplicationApp.resortRoomCategory.delete.question', { id: removeId })"
        ></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-resortRoomCategory"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeResortRoomCategory()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="resortRoomCategories && resortRoomCategories.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./resort-room-category.component.ts"></script>
