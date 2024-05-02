<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="name">
        <h2 class="jh-entity-heading" data-cy="nameDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.name.detail.title')"></span> {{ name.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.nameId')"></span>
          </dt>
          <dd>
            <span>{{ name.nameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.nameCode')"></span>
          </dt>
          <dd>
            <span>{{ name.nameCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ name.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ name.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ name.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ name.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.primaryNameId')"></span>
          </dt>
          <dd>
            <span>{{ name.primaryNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.repeatGuestId')"></span>
          </dt>
          <dd>
            <span>{{ name.repeatGuestId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.mailList')"></span>
          </dt>
          <dd>
            <span>{{ name.mailList }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.mailType')"></span>
          </dt>
          <dd>
            <span>{{ name.mailType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.followOn')"></span>
          </dt>
          <dd>
            <span>{{ name.followOn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.businessTitle')"></span>
          </dt>
          <dd>
            <span>{{ name.businessTitle }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.inactiveDate')"></span>
          </dt>
          <dd>
            <span>{{ name.inactiveDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.arcUpdateDate')"></span>
          </dt>
          <dd>
            <span>{{ name.arcUpdateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.updateFaxDate')"></span>
          </dt>
          <dd>
            <span>{{ name.updateFaxDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.birthDate')"></span>
          </dt>
          <dd>
            <span>{{ name.birthDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.collectionUserId')"></span>
          </dt>
          <dd>
            <span>{{ name.collectionUserId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.company')"></span>
          </dt>
          <dd>
            <span>{{ name.company }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.soundExCompany')"></span>
          </dt>
          <dd>
            <span>{{ name.soundExCompany }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.legalCompany')"></span>
          </dt>
          <dd>
            <span>{{ name.legalCompany }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.first')"></span>
          </dt>
          <dd>
            <span>{{ name.first }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.middle')"></span>
          </dt>
          <dd>
            <span>{{ name.middle }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.last')"></span>
          </dt>
          <dd>
            <span>{{ name.last }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.nickname')"></span>
          </dt>
          <dd>
            <span>{{ name.nickname }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.title')"></span>
          </dt>
          <dd>
            <span>{{ name.title }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.soundExLast')"></span>
          </dt>
          <dd>
            <span>{{ name.soundExLast }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.externalReferenceRequ')"></span>
          </dt>
          <dd>
            <span>{{ name.externalReferenceRequ }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.vipStatus')"></span>
          </dt>
          <dd>
            <span>{{ name.vipStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.vipAuthorization')"></span>
          </dt>
          <dd>
            <span>{{ name.vipAuthorization }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.billingProfileCode')"></span>
          </dt>
          <dd>
            <span>{{ name.billingProfileCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.rateStructure')"></span>
          </dt>
          <dd>
            <span>{{ name.rateStructure }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.nameComment')"></span>
          </dt>
          <dd>
            <span>{{ name.nameComment }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.tourOperatorType')"></span>
          </dt>
          <dd>
            <span>{{ name.tourOperatorType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.region')"></span>
          </dt>
          <dd>
            <span>{{ name.region }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.typeOf1099')"></span>
          </dt>
          <dd>
            <span>{{ name.typeOf1099 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.tax1No')"></span>
          </dt>
          <dd>
            <span>{{ name.tax1No }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.companyNameId')"></span>
          </dt>
          <dd>
            <span>{{ name.companyNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.externalReferenceRequired')"></span>
          </dt>
          <dd>
            <span>{{ name.externalReferenceRequired }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.vendorId')"></span>
          </dt>
          <dd>
            <span>{{ name.vendorId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.vendorSiteId')"></span>
          </dt>
          <dd>
            <span>{{ name.vendorSiteId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.arcOfficeType')"></span>
          </dt>
          <dd>
            <span>{{ name.arcOfficeType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.tax2No')"></span>
          </dt>
          <dd>
            <span>{{ name.tax2No }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.arcMailFlag')"></span>
          </dt>
          <dd>
            <span>{{ name.arcMailFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.name2')"></span>
          </dt>
          <dd>
            <span>{{ name.name2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.name3')"></span>
          </dt>
          <dd>
            <span>{{ name.name3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.salesrep')"></span>
          </dt>
          <dd>
            <span>{{ name.salesrep }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.tracecode')"></span>
          </dt>
          <dd>
            <span>{{ name.tracecode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.geographicRegion')"></span>
          </dt>
          <dd>
            <span>{{ name.geographicRegion }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.guestClassification')"></span>
          </dt>
          <dd>
            <span>{{ name.guestClassification }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.primaryAddressId')"></span>
          </dt>
          <dd>
            <span>{{ name.primaryAddressId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.primaryPhoneId')"></span>
          </dt>
          <dd>
            <span>{{ name.primaryPhoneId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.taxExemptStatus')"></span>
          </dt>
          <dd>
            <span>{{ name.taxExemptStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.gdsName')"></span>
          </dt>
          <dd>
            <span>{{ name.gdsName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.gdsTransactionNo')"></span>
          </dt>
          <dd>
            <span>{{ name.gdsTransactionNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.nationality')"></span>
          </dt>
          <dd>
            <span>{{ name.nationality }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.language')"></span>
          </dt>
          <dd>
            <span>{{ name.language }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.salutation')"></span>
          </dt>
          <dd>
            <span>{{ name.salutation }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.passport')"></span>
          </dt>
          <dd>
            <span>{{ name.passport }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.historyYn')"></span>
          </dt>
          <dd>
            <span>{{ name.historyYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.resvContact')"></span>
          </dt>
          <dd>
            <span>{{ name.resvContact }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.contractNo')"></span>
          </dt>
          <dd>
            <span>{{ name.contractNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.contractRecvDate')"></span>
          </dt>
          <dd>
            <span>{{ name.contractRecvDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.acctContact')"></span>
          </dt>
          <dd>
            <span>{{ name.acctContact }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.priority')"></span>
          </dt>
          <dd>
            <span>{{ name.priority }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.industryCode')"></span>
          </dt>
          <dd>
            <span>{{ name.industryCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.roomsPotential')"></span>
          </dt>
          <dd>
            <span>{{ name.roomsPotential }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.competitionCode')"></span>
          </dt>
          <dd>
            <span>{{ name.competitionCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.scope')"></span>
          </dt>
          <dd>
            <span>{{ name.scope }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.scopeCity')"></span>
          </dt>
          <dd>
            <span>{{ name.scopeCity }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.territory')"></span>
          </dt>
          <dd>
            <span>{{ name.territory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.actioncode')"></span>
          </dt>
          <dd>
            <span>{{ name.actioncode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.activeYn')"></span>
          </dt>
          <dd>
            <span>{{ name.activeYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.masterAccountYn')"></span>
          </dt>
          <dd>
            <span>{{ name.masterAccountYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.nameType')"></span>
          </dt>
          <dd>
            <span>{{ name.nameType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.sname')"></span>
          </dt>
          <dd>
            <span>{{ name.sname }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.nameTaxType')"></span>
          </dt>
          <dd>
            <span>{{ name.nameTaxType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.sfirst')"></span>
          </dt>
          <dd>
            <span>{{ name.sfirst }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.arNo')"></span>
          </dt>
          <dd>
            <span>{{ name.arNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.availabilityOverride')"></span>
          </dt>
          <dd>
            <span>{{ name.availabilityOverride }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.billingCode')"></span>
          </dt>
          <dd>
            <span>{{ name.billingCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.cashBlInd')"></span>
          </dt>
          <dd>
            <span>{{ name.cashBlInd }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.blMsg')"></span>
          </dt>
          <dd>
            <span>{{ name.blMsg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.currencyCode')"></span>
          </dt>
          <dd>
            <span>{{ name.currencyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.commissionCode')"></span>
          </dt>
          <dd>
            <span>{{ name.commissionCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.holdCode')"></span>
          </dt>
          <dd>
            <span>{{ name.holdCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.interest')"></span>
          </dt>
          <dd>
            <span>{{ name.interest }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.summRefCc')"></span>
          </dt>
          <dd>
            <span>{{ name.summRefCc }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.iataCompType')"></span>
          </dt>
          <dd>
            <span>{{ name.iataCompType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.srepCode')"></span>
          </dt>
          <dd>
            <span>{{ name.srepCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.accountsource')"></span>
          </dt>
          <dd>
            <span>{{ name.accountsource }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.markets')"></span>
          </dt>
          <dd>
            <span>{{ name.markets }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.productInterest')"></span>
          </dt>
          <dd>
            <span>{{ name.productInterest }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.keyword')"></span>
          </dt>
          <dd>
            <span>{{ name.keyword }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.letterGreeting')"></span>
          </dt>
          <dd>
            <span>{{ name.letterGreeting }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.influence')"></span>
          </dt>
          <dd>
            <span>{{ name.influence }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.deptId')"></span>
          </dt>
          <dd>
            <span>{{ name.deptId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.department')"></span>
          </dt>
          <dd>
            <span>{{ name.department }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.contactYn')"></span>
          </dt>
          <dd>
            <span>{{ name.contactYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.accountType')"></span>
          </dt>
          <dd>
            <span>{{ name.accountType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.downloadResort')"></span>
          </dt>
          <dd>
            <span>{{ name.downloadResort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.downloadSrep')"></span>
          </dt>
          <dd>
            <span>{{ name.downloadSrep }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.downloadDate')"></span>
          </dt>
          <dd>
            <span>{{ name.downloadDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.uploadDate')"></span>
          </dt>
          <dd>
            <span>{{ name.uploadDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.laptopChange')"></span>
          </dt>
          <dd>
            <span>{{ name.laptopChange }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.crsNameid')"></span>
          </dt>
          <dd>
            <span>{{ name.crsNameid }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.commPayCentral')"></span>
          </dt>
          <dd>
            <span>{{ name.commPayCentral }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.ccProfileYn')"></span>
          </dt>
          <dd>
            <span>{{ name.ccProfileYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.gender')"></span>
          </dt>
          <dd>
            <span>{{ name.gender }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.birthPlace')"></span>
          </dt>
          <dd>
            <span>{{ name.birthPlace }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.birthCountry')"></span>
          </dt>
          <dd>
            <span>{{ name.birthCountry }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.profession')"></span>
          </dt>
          <dd>
            <span>{{ name.profession }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.idType')"></span>
          </dt>
          <dd>
            <span>{{ name.idType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.idNumber')"></span>
          </dt>
          <dd>
            <span>{{ name.idNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.idDate')"></span>
          </dt>
          <dd>
            <span>{{ name.idDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.idPlace')"></span>
          </dt>
          <dd>
            <span>{{ name.idPlace }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.idCountry')"></span>
          </dt>
          <dd>
            <span>{{ name.idCountry }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc01')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc01 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc02')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc02 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc03')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc03 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc04')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc04 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc05')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc05 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc06')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc06 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc07')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc07 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc08')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc08 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc09')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc09 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc10')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc10 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc11')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc11 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc12')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc12 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc13')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc13 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc14')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc14 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc15')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc15 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc16')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc16 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc17')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc17 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc18')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc18 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc19')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc19 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc20')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc20 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc21')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc21 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc22')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc22 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc23')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc23 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc24')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc24 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc25')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc25 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc26')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc26 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc27')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc27 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc28')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc28 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc29')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc29 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc30')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc30 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc31')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc31 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc32')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc32 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc33')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc33 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc34')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc34 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc35')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc35 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc36')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc36 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc37')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc37 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc38')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc38 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc39')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc39 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfc40')"></span>
          </dt>
          <dd>
            <span>{{ name.udfc40 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn01')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn01 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn02')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn02 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn03')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn03 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn04')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn04 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn05')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn05 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn06')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn06 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn07')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn07 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn08')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn08 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn09')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn09 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn10')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn10 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn11')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn11 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn12')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn12 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn13')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn13 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn14')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn14 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn15')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn15 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn16')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn16 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn17')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn17 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn18')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn18 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn19')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn19 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn20')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn20 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn21')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn21 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn22')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn22 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn23')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn23 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn24')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn24 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn25')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn25 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn26')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn26 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn27')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn27 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn28')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn28 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn29')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn29 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn30')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn30 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn31')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn31 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn32')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn32 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn33')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn33 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn34')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn34 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn35')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn35 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn36')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn36 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn37')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn37 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn38')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn38 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn39')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn39 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfn40')"></span>
          </dt>
          <dd>
            <span>{{ name.udfn40 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd01')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd01 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd02')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd02 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd03')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd03 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd04')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd04 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd05')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd05 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd06')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd06 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd07')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd07 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd08')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd08 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd09')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd09 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd10')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd10 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd11')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd11 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd12')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd12 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd13')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd13 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd14')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd14 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd15')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd15 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd16')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd16 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd17')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd17 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd18')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd18 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd19')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd19 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.udfd20')"></span>
          </dt>
          <dd>
            <span>{{ name.udfd20 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.paymentDueDays')"></span>
          </dt>
          <dd>
            <span>{{ name.paymentDueDays }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.suffix')"></span>
          </dt>
          <dd>
            <span>{{ name.suffix }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.externalId')"></span>
          </dt>
          <dd>
            <span>{{ name.externalId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.guestPrivYn')"></span>
          </dt>
          <dd>
            <span>{{ name.guestPrivYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.emailYn')"></span>
          </dt>
          <dd>
            <span>{{ name.emailYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.mailYn')"></span>
          </dt>
          <dd>
            <span>{{ name.mailYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.indexName')"></span>
          </dt>
          <dd>
            <span>{{ name.indexName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.xlastName')"></span>
          </dt>
          <dd>
            <span>{{ name.xlastName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.xfirstName')"></span>
          </dt>
          <dd>
            <span>{{ name.xfirstName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.xcompanyName')"></span>
          </dt>
          <dd>
            <span>{{ name.xcompanyName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.xtitle')"></span>
          </dt>
          <dd>
            <span>{{ name.xtitle }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.xsalutation')"></span>
          </dt>
          <dd>
            <span>{{ name.xsalutation }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.sxname')"></span>
          </dt>
          <dd>
            <span>{{ name.sxname }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.sxfirstName')"></span>
          </dt>
          <dd>
            <span>{{ name.sxfirstName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.lastUpdatedResort')"></span>
          </dt>
          <dd>
            <span>{{ name.lastUpdatedResort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.envelopeGreeting')"></span>
          </dt>
          <dd>
            <span>{{ name.envelopeGreeting }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.xenvelopeGreeting')"></span>
          </dt>
          <dd>
            <span>{{ name.xenvelopeGreeting }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.directBillBatchType')"></span>
          </dt>
          <dd>
            <span>{{ name.directBillBatchType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.resortRegistered')"></span>
          </dt>
          <dd>
            <span>{{ name.resortRegistered }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.taxOffice')"></span>
          </dt>
          <dd>
            <span>{{ name.taxOffice }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.taxType')"></span>
          </dt>
          <dd>
            <span>{{ name.taxType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.taxCategory')"></span>
          </dt>
          <dd>
            <span>{{ name.taxCategory }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.preferredRoomNo')"></span>
          </dt>
          <dd>
            <span>{{ name.preferredRoomNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.phoneYn')"></span>
          </dt>
          <dd>
            <span>{{ name.phoneYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.smsYn')"></span>
          </dt>
          <dd>
            <span>{{ name.smsYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.isProtected')"></span>
          </dt>
          <dd>
            <span>{{ name.isProtected }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.xlanguage')"></span>
          </dt>
          <dd>
            <span>{{ name.xlanguage }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.marketResearchYn')"></span>
          </dt>
          <dd>
            <span>{{ name.marketResearchYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.thirdPartyYn')"></span>
          </dt>
          <dd>
            <span>{{ name.thirdPartyYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.autoenrollMemberYn')"></span>
          </dt>
          <dd>
            <span>{{ name.autoenrollMemberYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.chainCode')"></span>
          </dt>
          <dd>
            <span>{{ name.chainCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.companyGroupId')"></span>
          </dt>
          <dd>
            <span>{{ name.companyGroupId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.includeIn1099Yn')"></span>
          </dt>
          <dd>
            <span>{{ name.includeIn1099Yn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.creditRating')"></span>
          </dt>
          <dd>
            <span>{{ name.creditRating }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.titleSuffix')"></span>
          </dt>
          <dd>
            <span>{{ name.titleSuffix }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.inactiveReason')"></span>
          </dt>
          <dd>
            <span>{{ name.inactiveReason }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.iataConsortia')"></span>
          </dt>
          <dd>
            <span>{{ name.iataConsortia }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.psuedoProfileYn')"></span>
          </dt>
          <dd>
            <span>{{ name.psuedoProfileYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.profilePrivacyFlg')"></span>
          </dt>
          <dd>
            <span>{{ name.profilePrivacyFlg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.replaceAddress')"></span>
          </dt>
          <dd>
            <span>{{ name.replaceAddress }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.alienRegistrationNo')"></span>
          </dt>
          <dd>
            <span>{{ name.alienRegistrationNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.immigrationStatus')"></span>
          </dt>
          <dd>
            <span>{{ name.immigrationStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.visaValidityType')"></span>
          </dt>
          <dd>
            <span>{{ name.visaValidityType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.idDocumentAttachId')"></span>
          </dt>
          <dd>
            <span>{{ name.idDocumentAttachId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.superSearchIndexText')"></span>
          </dt>
          <dd>
            <span>{{ name.superSearchIndexText }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.birthDateStr')"></span>
          </dt>
          <dd>
            <span>{{ name.birthDateStr }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.origNameId')"></span>
          </dt>
          <dd>
            <span>{{ name.origNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.dOptInMailListFlg')"></span>
          </dt>
          <dd>
            <span>{{ name.dOptInMailListFlg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.dOptInMarketResearchFlg')"></span>
          </dt>
          <dd>
            <span>{{ name.dOptInMarketResearchFlg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.dOptInThirdPartyFlg')"></span>
          </dt>
          <dd>
            <span>{{ name.dOptInThirdPartyFlg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.dOptInAutoenrollMemberFlg')"></span>
          </dt>
          <dd>
            <span>{{ name.dOptInAutoenrollMemberFlg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.dOptInEmailFlg')"></span>
          </dt>
          <dd>
            <span>{{ name.dOptInEmailFlg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.dOptInPhoneFlg')"></span>
          </dt>
          <dd>
            <span>{{ name.dOptInPhoneFlg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.dOptInSmsFlg')"></span>
          </dt>
          <dd>
            <span>{{ name.dOptInSmsFlg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.dOptInGuestPrivFlg')"></span>
          </dt>
          <dd>
            <span>{{ name.dOptInGuestPrivFlg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.arCreditLimitYn')"></span>
          </dt>
          <dd>
            <span>{{ name.arCreditLimitYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.profileCreditLimit')"></span>
          </dt>
          <dd>
            <span>{{ name.profileCreditLimit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.xmiddleName')"></span>
          </dt>
          <dd>
            <span>{{ name.xmiddleName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.eInvoiceLiableYn')"></span>
          </dt>
          <dd>
            <span>{{ name.eInvoiceLiableYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.eInvLiableLastUpdated')"></span>
          </dt>
          <dd>
            <span>{{ name.eInvLiableLastUpdated }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.internalBillYn')"></span>
          </dt>
          <dd>
            <span>{{ name.internalBillYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.compPreApprovalRequiredYn')"></span>
          </dt>
          <dd>
            <span>{{ name.compPreApprovalRequiredYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.anonymizationStatus')"></span>
          </dt>
          <dd>
            <span>{{ name.anonymizationStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.name.anonymizationDate')"></span>
          </dt>
          <dd>
            <span>{{ name.anonymizationDate }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link v-if="name.id" :to="{ name: 'NameEdit', params: { nameId: name.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.edit')"></span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./name-details.component.ts"></script>
