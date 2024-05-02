<template>
  <div>
    <h2 id="page-heading" data-cy="NameHeading">
      <span v-text="t$('operaHandlerApplicationApp.name.home.title')" id="name-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.name.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'NameCreate' }" custom v-slot="{ navigate }">
          <button @click="navigate" id="jh-create-entity" data-cy="entityCreateButton" class="btn btn-primary jh-create-entity create-name">
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.name.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && names && names.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.name.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="names && names.length > 0">
      <table class="table table-striped" aria-describedby="names">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameId')">
              <span v-text="t$('operaHandlerApplicationApp.name.nameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameCode')">
              <span v-text="t$('operaHandlerApplicationApp.name.nameCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.name.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.name.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('primaryNameId')">
              <span v-text="t$('operaHandlerApplicationApp.name.primaryNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'primaryNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('repeatGuestId')">
              <span v-text="t$('operaHandlerApplicationApp.name.repeatGuestId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'repeatGuestId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mailList')">
              <span v-text="t$('operaHandlerApplicationApp.name.mailList')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mailList'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mailType')">
              <span v-text="t$('operaHandlerApplicationApp.name.mailType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mailType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('followOn')">
              <span v-text="t$('operaHandlerApplicationApp.name.followOn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'followOn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('businessTitle')">
              <span v-text="t$('operaHandlerApplicationApp.name.businessTitle')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'businessTitle'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.inactiveDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inactiveDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arcUpdateDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.arcUpdateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arcUpdateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateFaxDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.updateFaxDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateFaxDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('birthDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.birthDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'birthDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('collectionUserId')">
              <span v-text="t$('operaHandlerApplicationApp.name.collectionUserId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'collectionUserId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('company')">
              <span v-text="t$('operaHandlerApplicationApp.name.company')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'company'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('soundExCompany')">
              <span v-text="t$('operaHandlerApplicationApp.name.soundExCompany')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'soundExCompany'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('legalCompany')">
              <span v-text="t$('operaHandlerApplicationApp.name.legalCompany')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'legalCompany'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('first')">
              <span v-text="t$('operaHandlerApplicationApp.name.first')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'first'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('middle')">
              <span v-text="t$('operaHandlerApplicationApp.name.middle')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'middle'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('last')">
              <span v-text="t$('operaHandlerApplicationApp.name.last')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'last'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nickname')">
              <span v-text="t$('operaHandlerApplicationApp.name.nickname')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nickname'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('title')">
              <span v-text="t$('operaHandlerApplicationApp.name.title')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'title'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('soundExLast')">
              <span v-text="t$('operaHandlerApplicationApp.name.soundExLast')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'soundExLast'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('externalReferenceRequ')">
              <span v-text="t$('operaHandlerApplicationApp.name.externalReferenceRequ')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'externalReferenceRequ'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('vipStatus')">
              <span v-text="t$('operaHandlerApplicationApp.name.vipStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'vipStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('vipAuthorization')">
              <span v-text="t$('operaHandlerApplicationApp.name.vipAuthorization')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'vipAuthorization'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('billingProfileCode')">
              <span v-text="t$('operaHandlerApplicationApp.name.billingProfileCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'billingProfileCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateStructure')">
              <span v-text="t$('operaHandlerApplicationApp.name.rateStructure')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateStructure'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameComment')">
              <span v-text="t$('operaHandlerApplicationApp.name.nameComment')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameComment'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tourOperatorType')">
              <span v-text="t$('operaHandlerApplicationApp.name.tourOperatorType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tourOperatorType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('region')">
              <span v-text="t$('operaHandlerApplicationApp.name.region')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'region'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('typeOf1099')">
              <span v-text="t$('operaHandlerApplicationApp.name.typeOf1099')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'typeOf1099'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tax1No')">
              <span v-text="t$('operaHandlerApplicationApp.name.tax1No')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tax1No'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('companyNameId')">
              <span v-text="t$('operaHandlerApplicationApp.name.companyNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'companyNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('externalReferenceRequired')">
              <span v-text="t$('operaHandlerApplicationApp.name.externalReferenceRequired')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'externalReferenceRequired'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('vendorId')">
              <span v-text="t$('operaHandlerApplicationApp.name.vendorId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'vendorId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('vendorSiteId')">
              <span v-text="t$('operaHandlerApplicationApp.name.vendorSiteId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'vendorSiteId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arcOfficeType')">
              <span v-text="t$('operaHandlerApplicationApp.name.arcOfficeType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arcOfficeType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tax2No')">
              <span v-text="t$('operaHandlerApplicationApp.name.tax2No')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tax2No'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arcMailFlag')">
              <span v-text="t$('operaHandlerApplicationApp.name.arcMailFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arcMailFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('name2')">
              <span v-text="t$('operaHandlerApplicationApp.name.name2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'name2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('name3')">
              <span v-text="t$('operaHandlerApplicationApp.name.name3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'name3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('salesrep')">
              <span v-text="t$('operaHandlerApplicationApp.name.salesrep')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'salesrep'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tracecode')">
              <span v-text="t$('operaHandlerApplicationApp.name.tracecode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tracecode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('geographicRegion')">
              <span v-text="t$('operaHandlerApplicationApp.name.geographicRegion')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'geographicRegion'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestClassification')">
              <span v-text="t$('operaHandlerApplicationApp.name.guestClassification')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestClassification'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('primaryAddressId')">
              <span v-text="t$('operaHandlerApplicationApp.name.primaryAddressId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'primaryAddressId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('primaryPhoneId')">
              <span v-text="t$('operaHandlerApplicationApp.name.primaryPhoneId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'primaryPhoneId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxExemptStatus')">
              <span v-text="t$('operaHandlerApplicationApp.name.taxExemptStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxExemptStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('gdsName')">
              <span v-text="t$('operaHandlerApplicationApp.name.gdsName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'gdsName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('gdsTransactionNo')">
              <span v-text="t$('operaHandlerApplicationApp.name.gdsTransactionNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'gdsTransactionNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nationality')">
              <span v-text="t$('operaHandlerApplicationApp.name.nationality')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nationality'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('language')">
              <span v-text="t$('operaHandlerApplicationApp.name.language')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'language'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('salutation')">
              <span v-text="t$('operaHandlerApplicationApp.name.salutation')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'salutation'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('passport')">
              <span v-text="t$('operaHandlerApplicationApp.name.passport')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'passport'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('historyYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.historyYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'historyYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvContact')">
              <span v-text="t$('operaHandlerApplicationApp.name.resvContact')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvContact'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contractNo')">
              <span v-text="t$('operaHandlerApplicationApp.name.contractNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contractNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contractRecvDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.contractRecvDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contractRecvDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('acctContact')">
              <span v-text="t$('operaHandlerApplicationApp.name.acctContact')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'acctContact'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('priority')">
              <span v-text="t$('operaHandlerApplicationApp.name.priority')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'priority'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('industryCode')">
              <span v-text="t$('operaHandlerApplicationApp.name.industryCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'industryCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomsPotential')">
              <span v-text="t$('operaHandlerApplicationApp.name.roomsPotential')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomsPotential'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('competitionCode')">
              <span v-text="t$('operaHandlerApplicationApp.name.competitionCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'competitionCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('scope')">
              <span v-text="t$('operaHandlerApplicationApp.name.scope')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'scope'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('scopeCity')">
              <span v-text="t$('operaHandlerApplicationApp.name.scopeCity')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'scopeCity'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('territory')">
              <span v-text="t$('operaHandlerApplicationApp.name.territory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'territory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('actioncode')">
              <span v-text="t$('operaHandlerApplicationApp.name.actioncode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'actioncode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('activeYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.activeYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'activeYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('masterAccountYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.masterAccountYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'masterAccountYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameType')">
              <span v-text="t$('operaHandlerApplicationApp.name.nameType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sname')">
              <span v-text="t$('operaHandlerApplicationApp.name.sname')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sname'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameTaxType')">
              <span v-text="t$('operaHandlerApplicationApp.name.nameTaxType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameTaxType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sfirst')">
              <span v-text="t$('operaHandlerApplicationApp.name.sfirst')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sfirst'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arNo')">
              <span v-text="t$('operaHandlerApplicationApp.name.arNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('availabilityOverride')">
              <span v-text="t$('operaHandlerApplicationApp.name.availabilityOverride')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'availabilityOverride'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('billingCode')">
              <span v-text="t$('operaHandlerApplicationApp.name.billingCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'billingCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cashBlInd')">
              <span v-text="t$('operaHandlerApplicationApp.name.cashBlInd')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cashBlInd'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('blMsg')">
              <span v-text="t$('operaHandlerApplicationApp.name.blMsg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'blMsg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('currencyCode')">
              <span v-text="t$('operaHandlerApplicationApp.name.currencyCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'currencyCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('commissionCode')">
              <span v-text="t$('operaHandlerApplicationApp.name.commissionCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commissionCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('holdCode')">
              <span v-text="t$('operaHandlerApplicationApp.name.holdCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'holdCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('interest')">
              <span v-text="t$('operaHandlerApplicationApp.name.interest')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'interest'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('summRefCc')">
              <span v-text="t$('operaHandlerApplicationApp.name.summRefCc')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'summRefCc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('iataCompType')">
              <span v-text="t$('operaHandlerApplicationApp.name.iataCompType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'iataCompType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('srepCode')">
              <span v-text="t$('operaHandlerApplicationApp.name.srepCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'srepCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accountsource')">
              <span v-text="t$('operaHandlerApplicationApp.name.accountsource')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accountsource'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('markets')">
              <span v-text="t$('operaHandlerApplicationApp.name.markets')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'markets'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('productInterest')">
              <span v-text="t$('operaHandlerApplicationApp.name.productInterest')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'productInterest'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('keyword')">
              <span v-text="t$('operaHandlerApplicationApp.name.keyword')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'keyword'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('letterGreeting')">
              <span v-text="t$('operaHandlerApplicationApp.name.letterGreeting')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'letterGreeting'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('influence')">
              <span v-text="t$('operaHandlerApplicationApp.name.influence')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'influence'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('deptId')">
              <span v-text="t$('operaHandlerApplicationApp.name.deptId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'deptId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('department')">
              <span v-text="t$('operaHandlerApplicationApp.name.department')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'department'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contactYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.contactYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contactYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accountType')">
              <span v-text="t$('operaHandlerApplicationApp.name.accountType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accountType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('downloadResort')">
              <span v-text="t$('operaHandlerApplicationApp.name.downloadResort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'downloadResort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('downloadSrep')">
              <span v-text="t$('operaHandlerApplicationApp.name.downloadSrep')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'downloadSrep'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('downloadDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.downloadDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'downloadDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('uploadDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.uploadDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uploadDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('laptopChange')">
              <span v-text="t$('operaHandlerApplicationApp.name.laptopChange')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'laptopChange'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('crsNameid')">
              <span v-text="t$('operaHandlerApplicationApp.name.crsNameid')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'crsNameid'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('commPayCentral')">
              <span v-text="t$('operaHandlerApplicationApp.name.commPayCentral')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'commPayCentral'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ccProfileYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.ccProfileYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ccProfileYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('gender')">
              <span v-text="t$('operaHandlerApplicationApp.name.gender')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'gender'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('birthPlace')">
              <span v-text="t$('operaHandlerApplicationApp.name.birthPlace')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'birthPlace'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('birthCountry')">
              <span v-text="t$('operaHandlerApplicationApp.name.birthCountry')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'birthCountry'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('profession')">
              <span v-text="t$('operaHandlerApplicationApp.name.profession')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'profession'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('idType')">
              <span v-text="t$('operaHandlerApplicationApp.name.idType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'idType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('idNumber')">
              <span v-text="t$('operaHandlerApplicationApp.name.idNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'idNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('idDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.idDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'idDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('idPlace')">
              <span v-text="t$('operaHandlerApplicationApp.name.idPlace')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'idPlace'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('idCountry')">
              <span v-text="t$('operaHandlerApplicationApp.name.idCountry')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'idCountry'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc01')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc01')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc01'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc02')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc02')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc02'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc03')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc03')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc03'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc04')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc04')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc04'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc05')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc05')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc05'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc06')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc06')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc06'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc07')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc07')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc07'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc08')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc08')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc08'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc09')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc09')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc09'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc10')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc10')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc10'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc11')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc11')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc11'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc12')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc12')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc12'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc13')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc13')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc13'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc14')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc14')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc14'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc15')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc15')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc15'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc16')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc16')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc16'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc17')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc17')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc17'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc18')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc18')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc18'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc19')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc19')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc19'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc20')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc20')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc20'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc21')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc21')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc21'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc22')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc22')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc22'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc23')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc23')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc23'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc24')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc24')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc24'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc25')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc25')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc25'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc26')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc26')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc26'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc27')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc27')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc27'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc28')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc28')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc28'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc29')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc29')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc29'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc30')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc30')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc30'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc31')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc31')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc31'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc32')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc32')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc32'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc33')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc33')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc33'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc34')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc34')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc34'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc35')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc35')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc35'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc36')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc36')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc36'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc37')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc37')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc37'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc38')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc38')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc38'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc39')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc39')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc39'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfc40')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfc40')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfc40'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn01')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn01')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn01'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn02')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn02')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn02'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn03')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn03')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn03'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn04')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn04')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn04'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn05')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn05')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn05'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn06')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn06')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn06'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn07')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn07')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn07'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn08')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn08')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn08'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn09')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn09')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn09'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn10')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn10')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn10'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn11')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn11')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn11'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn12')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn12')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn12'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn13')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn13')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn13'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn14')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn14')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn14'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn15')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn15')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn15'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn16')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn16')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn16'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn17')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn17')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn17'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn18')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn18')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn18'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn19')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn19')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn19'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn20')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn20')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn20'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn21')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn21')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn21'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn22')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn22')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn22'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn23')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn23')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn23'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn24')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn24')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn24'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn25')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn25')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn25'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn26')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn26')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn26'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn27')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn27')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn27'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn28')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn28')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn28'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn29')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn29')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn29'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn30')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn30')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn30'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn31')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn31')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn31'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn32')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn32')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn32'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn33')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn33')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn33'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn34')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn34')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn34'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn35')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn35')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn35'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn36')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn36')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn36'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn37')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn37')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn37'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn38')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn38')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn38'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn39')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn39')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn39'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfn40')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfn40')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfn40'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd01')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd01')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd01'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd02')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd02')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd02'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd03')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd03')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd03'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd04')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd04')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd04'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd05')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd05')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd05'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd06')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd06')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd06'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd07')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd07')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd07'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd08')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd08')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd08'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd09')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd09')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd09'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd10')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd10')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd10'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd11')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd11')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd11'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd12')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd12')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd12'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd13')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd13')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd13'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd14')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd14')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd14'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd15')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd15')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd15'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd16')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd16')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd16'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd17')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd17')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd17'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd18')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd18')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd18'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd19')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd19')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd19'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('udfd20')">
              <span v-text="t$('operaHandlerApplicationApp.name.udfd20')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'udfd20'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('paymentDueDays')">
              <span v-text="t$('operaHandlerApplicationApp.name.paymentDueDays')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'paymentDueDays'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('suffix')">
              <span v-text="t$('operaHandlerApplicationApp.name.suffix')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'suffix'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('externalId')">
              <span v-text="t$('operaHandlerApplicationApp.name.externalId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'externalId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestPrivYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.guestPrivYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestPrivYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('emailYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.emailYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'emailYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mailYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.mailYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mailYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('indexName')">
              <span v-text="t$('operaHandlerApplicationApp.name.indexName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'indexName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('xlastName')">
              <span v-text="t$('operaHandlerApplicationApp.name.xlastName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'xlastName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('xfirstName')">
              <span v-text="t$('operaHandlerApplicationApp.name.xfirstName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'xfirstName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('xcompanyName')">
              <span v-text="t$('operaHandlerApplicationApp.name.xcompanyName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'xcompanyName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('xtitle')">
              <span v-text="t$('operaHandlerApplicationApp.name.xtitle')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'xtitle'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('xsalutation')">
              <span v-text="t$('operaHandlerApplicationApp.name.xsalutation')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'xsalutation'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sxname')">
              <span v-text="t$('operaHandlerApplicationApp.name.sxname')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sxname'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sxfirstName')">
              <span v-text="t$('operaHandlerApplicationApp.name.sxfirstName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sxfirstName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lastUpdatedResort')">
              <span v-text="t$('operaHandlerApplicationApp.name.lastUpdatedResort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lastUpdatedResort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('envelopeGreeting')">
              <span v-text="t$('operaHandlerApplicationApp.name.envelopeGreeting')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'envelopeGreeting'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('xenvelopeGreeting')">
              <span v-text="t$('operaHandlerApplicationApp.name.xenvelopeGreeting')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'xenvelopeGreeting'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('directBillBatchType')">
              <span v-text="t$('operaHandlerApplicationApp.name.directBillBatchType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'directBillBatchType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resortRegistered')">
              <span v-text="t$('operaHandlerApplicationApp.name.resortRegistered')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resortRegistered'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxOffice')">
              <span v-text="t$('operaHandlerApplicationApp.name.taxOffice')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxOffice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxType')">
              <span v-text="t$('operaHandlerApplicationApp.name.taxType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxCategory')">
              <span v-text="t$('operaHandlerApplicationApp.name.taxCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('preferredRoomNo')">
              <span v-text="t$('operaHandlerApplicationApp.name.preferredRoomNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'preferredRoomNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('phoneYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.phoneYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'phoneYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('smsYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.smsYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'smsYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('isProtected')">
              <span v-text="t$('operaHandlerApplicationApp.name.isProtected')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isProtected'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('xlanguage')">
              <span v-text="t$('operaHandlerApplicationApp.name.xlanguage')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'xlanguage'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('marketResearchYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.marketResearchYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'marketResearchYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('thirdPartyYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.thirdPartyYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'thirdPartyYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('autoenrollMemberYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.autoenrollMemberYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoenrollMemberYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('chainCode')">
              <span v-text="t$('operaHandlerApplicationApp.name.chainCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'chainCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('companyGroupId')">
              <span v-text="t$('operaHandlerApplicationApp.name.companyGroupId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'companyGroupId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('includeIn1099Yn')">
              <span v-text="t$('operaHandlerApplicationApp.name.includeIn1099Yn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'includeIn1099Yn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('creditRating')">
              <span v-text="t$('operaHandlerApplicationApp.name.creditRating')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'creditRating'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('titleSuffix')">
              <span v-text="t$('operaHandlerApplicationApp.name.titleSuffix')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'titleSuffix'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveReason')">
              <span v-text="t$('operaHandlerApplicationApp.name.inactiveReason')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inactiveReason'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('iataConsortia')">
              <span v-text="t$('operaHandlerApplicationApp.name.iataConsortia')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'iataConsortia'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('psuedoProfileYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.psuedoProfileYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'psuedoProfileYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('profilePrivacyFlg')">
              <span v-text="t$('operaHandlerApplicationApp.name.profilePrivacyFlg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'profilePrivacyFlg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('replaceAddress')">
              <span v-text="t$('operaHandlerApplicationApp.name.replaceAddress')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'replaceAddress'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('alienRegistrationNo')">
              <span v-text="t$('operaHandlerApplicationApp.name.alienRegistrationNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'alienRegistrationNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('immigrationStatus')">
              <span v-text="t$('operaHandlerApplicationApp.name.immigrationStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'immigrationStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('visaValidityType')">
              <span v-text="t$('operaHandlerApplicationApp.name.visaValidityType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'visaValidityType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('idDocumentAttachId')">
              <span v-text="t$('operaHandlerApplicationApp.name.idDocumentAttachId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'idDocumentAttachId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('superSearchIndexText')">
              <span v-text="t$('operaHandlerApplicationApp.name.superSearchIndexText')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'superSearchIndexText'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('birthDateStr')">
              <span v-text="t$('operaHandlerApplicationApp.name.birthDateStr')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'birthDateStr'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('origNameId')">
              <span v-text="t$('operaHandlerApplicationApp.name.origNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'origNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dOptInMailListFlg')">
              <span v-text="t$('operaHandlerApplicationApp.name.dOptInMailListFlg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dOptInMailListFlg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dOptInMarketResearchFlg')">
              <span v-text="t$('operaHandlerApplicationApp.name.dOptInMarketResearchFlg')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'dOptInMarketResearchFlg'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dOptInThirdPartyFlg')">
              <span v-text="t$('operaHandlerApplicationApp.name.dOptInThirdPartyFlg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dOptInThirdPartyFlg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dOptInAutoenrollMemberFlg')">
              <span v-text="t$('operaHandlerApplicationApp.name.dOptInAutoenrollMemberFlg')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'dOptInAutoenrollMemberFlg'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dOptInEmailFlg')">
              <span v-text="t$('operaHandlerApplicationApp.name.dOptInEmailFlg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dOptInEmailFlg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dOptInPhoneFlg')">
              <span v-text="t$('operaHandlerApplicationApp.name.dOptInPhoneFlg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dOptInPhoneFlg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dOptInSmsFlg')">
              <span v-text="t$('operaHandlerApplicationApp.name.dOptInSmsFlg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dOptInSmsFlg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dOptInGuestPrivFlg')">
              <span v-text="t$('operaHandlerApplicationApp.name.dOptInGuestPrivFlg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dOptInGuestPrivFlg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arCreditLimitYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.arCreditLimitYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arCreditLimitYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('profileCreditLimit')">
              <span v-text="t$('operaHandlerApplicationApp.name.profileCreditLimit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'profileCreditLimit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('xmiddleName')">
              <span v-text="t$('operaHandlerApplicationApp.name.xmiddleName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'xmiddleName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('eInvoiceLiableYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.eInvoiceLiableYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'eInvoiceLiableYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('eInvLiableLastUpdated')">
              <span v-text="t$('operaHandlerApplicationApp.name.eInvLiableLastUpdated')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'eInvLiableLastUpdated'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('internalBillYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.internalBillYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'internalBillYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('compPreApprovalRequiredYn')">
              <span v-text="t$('operaHandlerApplicationApp.name.compPreApprovalRequiredYn')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'compPreApprovalRequiredYn'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('anonymizationStatus')">
              <span v-text="t$('operaHandlerApplicationApp.name.anonymizationStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'anonymizationStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('anonymizationDate')">
              <span v-text="t$('operaHandlerApplicationApp.name.anonymizationDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'anonymizationDate'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="name in names" :key="name.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'NameView', params: { nameId: name.id } }">{{ name.id }}</router-link>
            </td>
            <td>{{ name.nameId }}</td>
            <td>{{ name.nameCode }}</td>
            <td>{{ name.insertUser }}</td>
            <td>{{ name.insertDate }}</td>
            <td>{{ name.updateUser }}</td>
            <td>{{ name.updateDate }}</td>
            <td>{{ name.primaryNameId }}</td>
            <td>{{ name.repeatGuestId }}</td>
            <td>{{ name.mailList }}</td>
            <td>{{ name.mailType }}</td>
            <td>{{ name.followOn }}</td>
            <td>{{ name.businessTitle }}</td>
            <td>{{ name.inactiveDate }}</td>
            <td>{{ name.arcUpdateDate }}</td>
            <td>{{ name.updateFaxDate }}</td>
            <td>{{ name.birthDate }}</td>
            <td>{{ name.collectionUserId }}</td>
            <td>{{ name.company }}</td>
            <td>{{ name.soundExCompany }}</td>
            <td>{{ name.legalCompany }}</td>
            <td>{{ name.first }}</td>
            <td>{{ name.middle }}</td>
            <td>{{ name.last }}</td>
            <td>{{ name.nickname }}</td>
            <td>{{ name.title }}</td>
            <td>{{ name.soundExLast }}</td>
            <td>{{ name.externalReferenceRequ }}</td>
            <td>{{ name.vipStatus }}</td>
            <td>{{ name.vipAuthorization }}</td>
            <td>{{ name.billingProfileCode }}</td>
            <td>{{ name.rateStructure }}</td>
            <td>{{ name.nameComment }}</td>
            <td>{{ name.tourOperatorType }}</td>
            <td>{{ name.region }}</td>
            <td>{{ name.typeOf1099 }}</td>
            <td>{{ name.tax1No }}</td>
            <td>{{ name.companyNameId }}</td>
            <td>{{ name.externalReferenceRequired }}</td>
            <td>{{ name.vendorId }}</td>
            <td>{{ name.vendorSiteId }}</td>
            <td>{{ name.arcOfficeType }}</td>
            <td>{{ name.tax2No }}</td>
            <td>{{ name.arcMailFlag }}</td>
            <td>{{ name.name2 }}</td>
            <td>{{ name.name3 }}</td>
            <td>{{ name.salesrep }}</td>
            <td>{{ name.tracecode }}</td>
            <td>{{ name.geographicRegion }}</td>
            <td>{{ name.guestClassification }}</td>
            <td>{{ name.primaryAddressId }}</td>
            <td>{{ name.primaryPhoneId }}</td>
            <td>{{ name.taxExemptStatus }}</td>
            <td>{{ name.gdsName }}</td>
            <td>{{ name.gdsTransactionNo }}</td>
            <td>{{ name.nationality }}</td>
            <td>{{ name.language }}</td>
            <td>{{ name.salutation }}</td>
            <td>{{ name.passport }}</td>
            <td>{{ name.historyYn }}</td>
            <td>{{ name.resvContact }}</td>
            <td>{{ name.contractNo }}</td>
            <td>{{ name.contractRecvDate }}</td>
            <td>{{ name.acctContact }}</td>
            <td>{{ name.priority }}</td>
            <td>{{ name.industryCode }}</td>
            <td>{{ name.roomsPotential }}</td>
            <td>{{ name.competitionCode }}</td>
            <td>{{ name.scope }}</td>
            <td>{{ name.scopeCity }}</td>
            <td>{{ name.territory }}</td>
            <td>{{ name.actioncode }}</td>
            <td>{{ name.activeYn }}</td>
            <td>{{ name.masterAccountYn }}</td>
            <td>{{ name.nameType }}</td>
            <td>{{ name.sname }}</td>
            <td>{{ name.nameTaxType }}</td>
            <td>{{ name.sfirst }}</td>
            <td>{{ name.arNo }}</td>
            <td>{{ name.availabilityOverride }}</td>
            <td>{{ name.billingCode }}</td>
            <td>{{ name.cashBlInd }}</td>
            <td>{{ name.blMsg }}</td>
            <td>{{ name.currencyCode }}</td>
            <td>{{ name.commissionCode }}</td>
            <td>{{ name.holdCode }}</td>
            <td>{{ name.interest }}</td>
            <td>{{ name.summRefCc }}</td>
            <td>{{ name.iataCompType }}</td>
            <td>{{ name.srepCode }}</td>
            <td>{{ name.accountsource }}</td>
            <td>{{ name.markets }}</td>
            <td>{{ name.productInterest }}</td>
            <td>{{ name.keyword }}</td>
            <td>{{ name.letterGreeting }}</td>
            <td>{{ name.influence }}</td>
            <td>{{ name.deptId }}</td>
            <td>{{ name.department }}</td>
            <td>{{ name.contactYn }}</td>
            <td>{{ name.accountType }}</td>
            <td>{{ name.downloadResort }}</td>
            <td>{{ name.downloadSrep }}</td>
            <td>{{ name.downloadDate }}</td>
            <td>{{ name.uploadDate }}</td>
            <td>{{ name.laptopChange }}</td>
            <td>{{ name.crsNameid }}</td>
            <td>{{ name.commPayCentral }}</td>
            <td>{{ name.ccProfileYn }}</td>
            <td>{{ name.gender }}</td>
            <td>{{ name.birthPlace }}</td>
            <td>{{ name.birthCountry }}</td>
            <td>{{ name.profession }}</td>
            <td>{{ name.idType }}</td>
            <td>{{ name.idNumber }}</td>
            <td>{{ name.idDate }}</td>
            <td>{{ name.idPlace }}</td>
            <td>{{ name.idCountry }}</td>
            <td>{{ name.udfc01 }}</td>
            <td>{{ name.udfc02 }}</td>
            <td>{{ name.udfc03 }}</td>
            <td>{{ name.udfc04 }}</td>
            <td>{{ name.udfc05 }}</td>
            <td>{{ name.udfc06 }}</td>
            <td>{{ name.udfc07 }}</td>
            <td>{{ name.udfc08 }}</td>
            <td>{{ name.udfc09 }}</td>
            <td>{{ name.udfc10 }}</td>
            <td>{{ name.udfc11 }}</td>
            <td>{{ name.udfc12 }}</td>
            <td>{{ name.udfc13 }}</td>
            <td>{{ name.udfc14 }}</td>
            <td>{{ name.udfc15 }}</td>
            <td>{{ name.udfc16 }}</td>
            <td>{{ name.udfc17 }}</td>
            <td>{{ name.udfc18 }}</td>
            <td>{{ name.udfc19 }}</td>
            <td>{{ name.udfc20 }}</td>
            <td>{{ name.udfc21 }}</td>
            <td>{{ name.udfc22 }}</td>
            <td>{{ name.udfc23 }}</td>
            <td>{{ name.udfc24 }}</td>
            <td>{{ name.udfc25 }}</td>
            <td>{{ name.udfc26 }}</td>
            <td>{{ name.udfc27 }}</td>
            <td>{{ name.udfc28 }}</td>
            <td>{{ name.udfc29 }}</td>
            <td>{{ name.udfc30 }}</td>
            <td>{{ name.udfc31 }}</td>
            <td>{{ name.udfc32 }}</td>
            <td>{{ name.udfc33 }}</td>
            <td>{{ name.udfc34 }}</td>
            <td>{{ name.udfc35 }}</td>
            <td>{{ name.udfc36 }}</td>
            <td>{{ name.udfc37 }}</td>
            <td>{{ name.udfc38 }}</td>
            <td>{{ name.udfc39 }}</td>
            <td>{{ name.udfc40 }}</td>
            <td>{{ name.udfn01 }}</td>
            <td>{{ name.udfn02 }}</td>
            <td>{{ name.udfn03 }}</td>
            <td>{{ name.udfn04 }}</td>
            <td>{{ name.udfn05 }}</td>
            <td>{{ name.udfn06 }}</td>
            <td>{{ name.udfn07 }}</td>
            <td>{{ name.udfn08 }}</td>
            <td>{{ name.udfn09 }}</td>
            <td>{{ name.udfn10 }}</td>
            <td>{{ name.udfn11 }}</td>
            <td>{{ name.udfn12 }}</td>
            <td>{{ name.udfn13 }}</td>
            <td>{{ name.udfn14 }}</td>
            <td>{{ name.udfn15 }}</td>
            <td>{{ name.udfn16 }}</td>
            <td>{{ name.udfn17 }}</td>
            <td>{{ name.udfn18 }}</td>
            <td>{{ name.udfn19 }}</td>
            <td>{{ name.udfn20 }}</td>
            <td>{{ name.udfn21 }}</td>
            <td>{{ name.udfn22 }}</td>
            <td>{{ name.udfn23 }}</td>
            <td>{{ name.udfn24 }}</td>
            <td>{{ name.udfn25 }}</td>
            <td>{{ name.udfn26 }}</td>
            <td>{{ name.udfn27 }}</td>
            <td>{{ name.udfn28 }}</td>
            <td>{{ name.udfn29 }}</td>
            <td>{{ name.udfn30 }}</td>
            <td>{{ name.udfn31 }}</td>
            <td>{{ name.udfn32 }}</td>
            <td>{{ name.udfn33 }}</td>
            <td>{{ name.udfn34 }}</td>
            <td>{{ name.udfn35 }}</td>
            <td>{{ name.udfn36 }}</td>
            <td>{{ name.udfn37 }}</td>
            <td>{{ name.udfn38 }}</td>
            <td>{{ name.udfn39 }}</td>
            <td>{{ name.udfn40 }}</td>
            <td>{{ name.udfd01 }}</td>
            <td>{{ name.udfd02 }}</td>
            <td>{{ name.udfd03 }}</td>
            <td>{{ name.udfd04 }}</td>
            <td>{{ name.udfd05 }}</td>
            <td>{{ name.udfd06 }}</td>
            <td>{{ name.udfd07 }}</td>
            <td>{{ name.udfd08 }}</td>
            <td>{{ name.udfd09 }}</td>
            <td>{{ name.udfd10 }}</td>
            <td>{{ name.udfd11 }}</td>
            <td>{{ name.udfd12 }}</td>
            <td>{{ name.udfd13 }}</td>
            <td>{{ name.udfd14 }}</td>
            <td>{{ name.udfd15 }}</td>
            <td>{{ name.udfd16 }}</td>
            <td>{{ name.udfd17 }}</td>
            <td>{{ name.udfd18 }}</td>
            <td>{{ name.udfd19 }}</td>
            <td>{{ name.udfd20 }}</td>
            <td>{{ name.paymentDueDays }}</td>
            <td>{{ name.suffix }}</td>
            <td>{{ name.externalId }}</td>
            <td>{{ name.guestPrivYn }}</td>
            <td>{{ name.emailYn }}</td>
            <td>{{ name.mailYn }}</td>
            <td>{{ name.indexName }}</td>
            <td>{{ name.xlastName }}</td>
            <td>{{ name.xfirstName }}</td>
            <td>{{ name.xcompanyName }}</td>
            <td>{{ name.xtitle }}</td>
            <td>{{ name.xsalutation }}</td>
            <td>{{ name.sxname }}</td>
            <td>{{ name.sxfirstName }}</td>
            <td>{{ name.lastUpdatedResort }}</td>
            <td>{{ name.envelopeGreeting }}</td>
            <td>{{ name.xenvelopeGreeting }}</td>
            <td>{{ name.directBillBatchType }}</td>
            <td>{{ name.resortRegistered }}</td>
            <td>{{ name.taxOffice }}</td>
            <td>{{ name.taxType }}</td>
            <td>{{ name.taxCategory }}</td>
            <td>{{ name.preferredRoomNo }}</td>
            <td>{{ name.phoneYn }}</td>
            <td>{{ name.smsYn }}</td>
            <td>{{ name.isProtected }}</td>
            <td>{{ name.xlanguage }}</td>
            <td>{{ name.marketResearchYn }}</td>
            <td>{{ name.thirdPartyYn }}</td>
            <td>{{ name.autoenrollMemberYn }}</td>
            <td>{{ name.chainCode }}</td>
            <td>{{ name.companyGroupId }}</td>
            <td>{{ name.includeIn1099Yn }}</td>
            <td>{{ name.creditRating }}</td>
            <td>{{ name.titleSuffix }}</td>
            <td>{{ name.inactiveReason }}</td>
            <td>{{ name.iataConsortia }}</td>
            <td>{{ name.psuedoProfileYn }}</td>
            <td>{{ name.profilePrivacyFlg }}</td>
            <td>{{ name.replaceAddress }}</td>
            <td>{{ name.alienRegistrationNo }}</td>
            <td>{{ name.immigrationStatus }}</td>
            <td>{{ name.visaValidityType }}</td>
            <td>{{ name.idDocumentAttachId }}</td>
            <td>{{ name.superSearchIndexText }}</td>
            <td>{{ name.birthDateStr }}</td>
            <td>{{ name.origNameId }}</td>
            <td>{{ name.dOptInMailListFlg }}</td>
            <td>{{ name.dOptInMarketResearchFlg }}</td>
            <td>{{ name.dOptInThirdPartyFlg }}</td>
            <td>{{ name.dOptInAutoenrollMemberFlg }}</td>
            <td>{{ name.dOptInEmailFlg }}</td>
            <td>{{ name.dOptInPhoneFlg }}</td>
            <td>{{ name.dOptInSmsFlg }}</td>
            <td>{{ name.dOptInGuestPrivFlg }}</td>
            <td>{{ name.arCreditLimitYn }}</td>
            <td>{{ name.profileCreditLimit }}</td>
            <td>{{ name.xmiddleName }}</td>
            <td>{{ name.eInvoiceLiableYn }}</td>
            <td>{{ name.eInvLiableLastUpdated }}</td>
            <td>{{ name.internalBillYn }}</td>
            <td>{{ name.compPreApprovalRequiredYn }}</td>
            <td>{{ name.anonymizationStatus }}</td>
            <td>{{ name.anonymizationDate }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'NameView', params: { nameId: name.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'NameEdit', params: { nameId: name.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(name)"
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
          id="operaHandlerApplicationApp.name.delete.question"
          data-cy="nameDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-name-heading" v-text="t$('operaHandlerApplicationApp.name.delete.question', { id: removeId })"></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-name"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeName()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="names && names.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./name.component.ts"></script>
