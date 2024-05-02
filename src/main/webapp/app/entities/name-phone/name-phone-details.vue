<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="namePhone">
        <h2 class="jh-entity-heading" data-cy="namePhoneDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.namePhone.detail.title')"></span> {{ namePhone.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.phoneId')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.phoneId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.nameId')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.nameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.phoneType')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.phoneType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.phoneRole')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.phoneRole }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.phoneNumber')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.phoneNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.inactiveDate')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.inactiveDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.endDate')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.endDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.beginDate')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.beginDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.addressId')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.addressId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.primaryYn')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.primaryYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.displaySeq')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.displaySeq }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.laptopChange')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.laptopChange }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.indexPhone')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.indexPhone }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.extension')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.extension }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.emailFormat')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.emailFormat }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.shareEmailYn')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.shareEmailYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.defaultConfirmationYn')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.defaultConfirmationYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.emailLanguage')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.emailLanguage }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.mobileAudioKeyYn')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.mobileAudioKeyYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.countryDialingCode')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.countryDialingCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.validYn')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.validYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.phoneCountryCode')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.phoneCountryCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.chainCode')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.chainCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.validateDate')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.validateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.validateStatus')"></span>
          </dt>
          <dd>
            <span>{{ namePhone.validateStatus }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="namePhone.id"
          :to="{ name: 'NamePhoneEdit', params: { namePhoneId: namePhone.id } }"
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

<script lang="ts" src="./name-phone-details.component.ts"></script>
