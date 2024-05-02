<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="nameAddress">
        <h2 class="jh-entity-heading" data-cy="nameAddressDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.nameAddress.detail.title')"></span> {{ nameAddress.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.addressId')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.addressId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.addressType')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.addressType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.address1')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.address1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.address2')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.address2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.address3')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.address3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.address4')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.address4 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.barcode')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.barcode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.beginDate')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.beginDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.chainCode')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.chainCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.city')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.city }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.cityExt')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.cityExt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedDatetime')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.cleansedDatetime }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedErrormsg')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.cleansedErrormsg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedMatchstatus')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.cleansedMatchstatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedStatus')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.cleansedStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedValidationstatus')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.cleansedValidationstatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.country')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.country }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.endDate')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.endDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.foreignCountry')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.foreignCountry }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.inCareOf')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.inCareOf }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.inactiveDate')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.inactiveDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.languageCode')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.languageCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.laptopChange')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.laptopChange }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.lastUpdatedResort')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.lastUpdatedResort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.nameId')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.nameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.primaryYn')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.primaryYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.province')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.province }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.state')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.state }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.zipCode')"></span>
          </dt>
          <dd>
            <span>{{ nameAddress.zipCode }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="nameAddress.id"
          :to="{ name: 'NameAddressEdit', params: { nameAddressId: nameAddress.id } }"
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

<script lang="ts" src="./name-address-details.component.ts"></script>
