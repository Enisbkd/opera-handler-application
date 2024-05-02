<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="resortRoomCategory">
        <h2 class="jh-entity-heading" data-cy="resortRoomCategoryDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.detail.title')"></span> {{ resortRoomCategory.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.resort')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.resort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roomCategory')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.roomCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roomClass')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.roomClass }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.numberRooms')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.numberRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.shortDescription')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.shortDescription }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.longDescription')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.longDescription }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.compiled')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.compiled }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.psuedoRoomType')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.psuedoRoomType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.activeDate')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.activeDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.inactiveDate')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.inactiveDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.replacesCategory')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.replacesCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.orderBy')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.orderBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxOccupancy')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.maxOccupancy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxRollaways')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.maxRollaways }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateCategory')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.rateCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.label')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.label }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.genericFlag')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.genericFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.suiteYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.suiteYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.meetingroomYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.meetingroomYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateCode')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.rateCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateAmount')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.rateAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.defOccupancy')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.defOccupancy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.imageId')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.imageId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.pseudoYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.pseudoYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sendToInterfaceYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.sendToInterfaceYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.yieldableYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.yieldableYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.yieldCategory')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.yieldCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.housekeeping')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.housekeeping }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.canDeleteYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.canDeleteYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roominfoUrl')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.roominfoUrl }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ownerYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.ownerYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.autoIncludeYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.autoIncludeYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.initialRoundUp')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.initialRoundUp }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.increments')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.increments }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rotationGroup')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.rotationGroup }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.salesFlag')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.salesFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.autoRoomAssignYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.autoRoomAssignYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.upsellYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.upsellYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsUpsellRank')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.ormsUpsellRank }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsUpsellAmt')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.ormsUpsellAmt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrxtraAdult')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.ormsDrxtraAdult }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrxtraChild')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.ormsDrxtraChild }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxOccupancyAdults')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.maxOccupancyAdults }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxOccupancyChildren')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.maxOccupancyChildren }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roomPool')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.roomPool }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.memberAwardRoomGrp')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.memberAwardRoomGrp }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrxtra2ndAdult')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.ormsDrxtra2ndAdult }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrtier1')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.ormsDrtier1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrtier2')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.ormsDrtier2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrtier3')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.ormsDrtier3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.autoCheckinYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.autoCheckinYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateFloor')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.rateFloor }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxFixBedOccupancy')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.maxFixBedOccupancy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maintenanceYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.maintenanceYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.smokingPreference')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.smokingPreference }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sLabel')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.sLabel }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sBedtype')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.sBedtype }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sellThruRuleYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.sellThruRuleYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.crsDescription')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.crsDescription }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.evisitorFacilityId')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.evisitorFacilityId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.minOccupancy')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.minOccupancy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resortRoomCategory.accessibleYn')"></span>
          </dt>
          <dd>
            <span>{{ resortRoomCategory.accessibleYn }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="resortRoomCategory.id"
          :to="{ name: 'ResortRoomCategoryEdit', params: { resortRoomCategoryId: resortRoomCategory.id } }"
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

<script lang="ts" src="./resort-room-category-details.component.ts"></script>
