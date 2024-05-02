<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="resort">
        <h2 class="jh-entity-heading" data-cy="resortDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.resort.detail.title')"></span> {{ resort.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.resort')"></span>
          </dt>
          <dd>
            <span>{{ resort.resort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.beginDate')"></span>
          </dt>
          <dd>
            <span v-if="resort.beginDate">{{ formatDateLong(resort.beginDate) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.checkInTime')"></span>
          </dt>
          <dd>
            <span v-if="resort.checkInTime">{{ formatDateLong(resort.checkInTime) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.checkOutTime')"></span>
          </dt>
          <dd>
            <span v-if="resort.checkOutTime">{{ formatDateLong(resort.checkOutTime) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.videoCoStart')"></span>
          </dt>
          <dd>
            <span v-if="resort.videoCoStart">{{ formatDateLong(resort.videoCoStart) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.videoCoStop')"></span>
          </dt>
          <dd>
            <span v-if="resort.videoCoStop">{{ formatDateLong(resort.videoCoStop) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.insertDate')"></span>
          </dt>
          <dd>
            <span v-if="resort.insertDate">{{ formatDateLong(resort.insertDate) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.updateDate')"></span>
          </dt>
          <dd>
            <span v-if="resort.updateDate">{{ formatDateLong(resort.updateDate) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.expiryDate')"></span>
          </dt>
          <dd>
            <span v-if="resort.expiryDate">{{ formatDateLong(resort.expiryDate) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.endDate')"></span>
          </dt>
          <dd>
            <span v-if="resort.endDate">{{ formatDateLong(resort.endDate) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.fiscalStartDate')"></span>
          </dt>
          <dd>
            <span v-if="resort.fiscalStartDate">{{ formatDateLong(resort.fiscalStartDate) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.fiscalEndDate')"></span>
          </dt>
          <dd>
            <span v-if="resort.fiscalEndDate">{{ formatDateLong(resort.fiscalEndDate) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.reconcileDate')"></span>
          </dt>
          <dd>
            <span v-if="resort.reconcileDate">{{ formatDateLong(resort.reconcileDate) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.paymentDate')"></span>
          </dt>
          <dd>
            <span v-if="resort.paymentDate">{{ formatDateLong(resort.paymentDate) }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.keepAvailability')"></span>
          </dt>
          <dd>
            <span>{{ resort.keepAvailability }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.budgetMonth')"></span>
          </dt>
          <dd>
            <span>{{ resort.budgetMonth }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.saveProfiles')"></span>
          </dt>
          <dd>
            <span>{{ resort.saveProfiles }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.longStayControl')"></span>
          </dt>
          <dd>
            <span>{{ resort.longStayControl }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.creditLimit')"></span>
          </dt>
          <dd>
            <span>{{ resort.creditLimit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.numberRooms')"></span>
          </dt>
          <dd>
            <span>{{ resort.numberRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.numberFloors')"></span>
          </dt>
          <dd>
            <span>{{ resort.numberFloors }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.numberBeds')"></span>
          </dt>
          <dd>
            <span>{{ resort.numberBeds }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.rhythmSheets')"></span>
          </dt>
          <dd>
            <span>{{ resort.rhythmSheets }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.rhythmTowels')"></span>
          </dt>
          <dd>
            <span>{{ resort.rhythmTowels }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.warningAmount')"></span>
          </dt>
          <dd>
            <span>{{ resort.warningAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.decimalPlaces')"></span>
          </dt>
          <dd>
            <span>{{ resort.decimalPlaces }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.font')"></span>
          </dt>
          <dd>
            <span>{{ resort.font }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.copies')"></span>
          </dt>
          <dd>
            <span>{{ resort.copies }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultFolioStyle')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultFolioStyle }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.individualRoomWarning')"></span>
          </dt>
          <dd>
            <span>{{ resort.individualRoomWarning }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.groupRoomWarning')"></span>
          </dt>
          <dd>
            <span>{{ resort.groupRoomWarning }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.agingLevel1')"></span>
          </dt>
          <dd>
            <span>{{ resort.agingLevel1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.agingLevel2')"></span>
          </dt>
          <dd>
            <span>{{ resort.agingLevel2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.agingLevel3')"></span>
          </dt>
          <dd>
            <span>{{ resort.agingLevel3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.agingLevel4')"></span>
          </dt>
          <dd>
            <span>{{ resort.agingLevel4 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.agingLevel5')"></span>
          </dt>
          <dd>
            <span>{{ resort.agingLevel5 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.zeroInvPurDays')"></span>
          </dt>
          <dd>
            <span>{{ resort.zeroInvPurDays }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.minDaysBet2ReminderLetter')"></span>
          </dt>
          <dd>
            <span>{{ resort.minDaysBet2ReminderLetter }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ resort.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ resort.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.currencyDecimals')"></span>
          </dt>
          <dd>
            <span>{{ resort.currencyDecimals }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.nameIdLink')"></span>
          </dt>
          <dd>
            <span>{{ resort.nameIdLink }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.sglRate1')"></span>
          </dt>
          <dd>
            <span>{{ resort.sglRate1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.sglRate2')"></span>
          </dt>
          <dd>
            <span>{{ resort.sglRate2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.dblRate1')"></span>
          </dt>
          <dd>
            <span>{{ resort.dblRate1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.dblRate2')"></span>
          </dt>
          <dd>
            <span>{{ resort.dblRate2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.tplRate1')"></span>
          </dt>
          <dd>
            <span>{{ resort.tplRate1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.tplRate2')"></span>
          </dt>
          <dd>
            <span>{{ resort.tplRate2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.suiRate1')"></span>
          </dt>
          <dd>
            <span>{{ resort.suiRate1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.suiRate2')"></span>
          </dt>
          <dd>
            <span>{{ resort.suiRate2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.meetSpace')"></span>
          </dt>
          <dd>
            <span>{{ resort.meetSpace }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.imgHotelId')"></span>
          </dt>
          <dd>
            <span>{{ resort.imgHotelId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.imgDirectionId')"></span>
          </dt>
          <dd>
            <span>{{ resort.imgDirectionId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.imgMapId')"></span>
          </dt>
          <dd>
            <span>{{ resort.imgMapId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.scriptId')"></span>
          </dt>
          <dd>
            <span>{{ resort.scriptId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.comNameXrefId')"></span>
          </dt>
          <dd>
            <span>{{ resort.comNameXrefId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.pathId')"></span>
          </dt>
          <dd>
            <span>{{ resort.pathId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.xresortNumber')"></span>
          </dt>
          <dd>
            <span>{{ resort.xresortNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.maxCreditDays')"></span>
          </dt>
          <dd>
            <span>{{ resort.maxCreditDays }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.currencyDivisor')"></span>
          </dt>
          <dd>
            <span>{{ resort.currencyDivisor }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.latitude')"></span>
          </dt>
          <dd>
            <span>{{ resort.latitude }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.longitude')"></span>
          </dt>
          <dd>
            <span>{{ resort.longitude }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.qtySingleRooms')"></span>
          </dt>
          <dd>
            <span>{{ resort.qtySingleRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.qtyDoubleRooms')"></span>
          </dt>
          <dd>
            <span>{{ resort.qtyDoubleRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.qtyTwinRooms')"></span>
          </dt>
          <dd>
            <span>{{ resort.qtyTwinRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.qtySuites')"></span>
          </dt>
          <dd>
            <span>{{ resort.qtySuites }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.qtyGuestRoomFloors')"></span>
          </dt>
          <dd>
            <span>{{ resort.qtyGuestRoomFloors }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.qtyGuestElevators')"></span>
          </dt>
          <dd>
            <span>{{ resort.qtyGuestElevators }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.qtyNonSmokingRooms')"></span>
          </dt>
          <dd>
            <span>{{ resort.qtyNonSmokingRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.qtyConnectingRooms')"></span>
          </dt>
          <dd>
            <span>{{ resort.qtyConnectingRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.qtyHandicappedRooms')"></span>
          </dt>
          <dd>
            <span>{{ resort.qtyHandicappedRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.qtyFamilyRooms')"></span>
          </dt>
          <dd>
            <span>{{ resort.qtyFamilyRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.maxAdultsFamilyRoom')"></span>
          </dt>
          <dd>
            <span>{{ resort.maxAdultsFamilyRoom }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.maxChildrenFamilyRoom')"></span>
          </dt>
          <dd>
            <span>{{ resort.maxChildrenFamilyRoom }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.restaurant')"></span>
          </dt>
          <dd>
            <span>{{ resort.restaurant }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.meetRooms')"></span>
          </dt>
          <dd>
            <span>{{ resort.meetRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.totRooms')"></span>
          </dt>
          <dd>
            <span>{{ resort.totRooms }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.brSeats')"></span>
          </dt>
          <dd>
            <span>{{ resort.brSeats }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.meetSeats')"></span>
          </dt>
          <dd>
            <span>{{ resort.meetSeats }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.maxNoNights')"></span>
          </dt>
          <dd>
            <span>{{ resort.maxNoNights }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.awardsTimeout')"></span>
          </dt>
          <dd>
            <span>{{ resort.awardsTimeout }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.guestLookupTimeout')"></span>
          </dt>
          <dd>
            <span>{{ resort.guestLookupTimeout }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.wakeUpDelay')"></span>
          </dt>
          <dd>
            <span>{{ resort.wakeUpDelay }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.maxOccupancy')"></span>
          </dt>
          <dd>
            <span>{{ resort.maxOccupancy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.inactiveDaysForGuestProfil')"></span>
          </dt>
          <dd>
            <span>{{ resort.inactiveDaysForGuestProfil }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.perReservationRoomLimit')"></span>
          </dt>
          <dd>
            <span>{{ resort.perReservationRoomLimit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.licRoomInfo')"></span>
          </dt>
          <dd>
            <span>{{ resort.licRoomInfo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.thousandSeparator')"></span>
          </dt>
          <dd>
            <span>{{ resort.thousandSeparator }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.dateSeparator')"></span>
          </dt>
          <dd>
            <span>{{ resort.dateSeparator }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.arAcctNoMandYn')"></span>
          </dt>
          <dd>
            <span>{{ resort.arAcctNoMandYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.exchangePostingType')"></span>
          </dt>
          <dd>
            <span>{{ resort.exchangePostingType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.inventoryYn')"></span>
          </dt>
          <dd>
            <span>{{ resort.inventoryYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.allowLoginYn')"></span>
          </dt>
          <dd>
            <span>{{ resort.allowLoginYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.accessCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.accessCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.disableLoginYn')"></span>
          </dt>
          <dd>
            <span>{{ resort.disableLoginYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.intTaxIncludedYn')"></span>
          </dt>
          <dd>
            <span>{{ resort.intTaxIncludedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.downloadRestYn')"></span>
          </dt>
          <dd>
            <span>{{ resort.downloadRestYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.translateMulticharYn')"></span>
          </dt>
          <dd>
            <span>{{ resort.translateMulticharYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.externalScYn')"></span>
          </dt>
          <dd>
            <span>{{ resort.externalScYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.sendLeadAsBookingYn')"></span>
          </dt>
          <dd>
            <span>{{ resort.sendLeadAsBookingYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.mbsSupportedYn')"></span>
          </dt>
          <dd>
            <span>{{ resort.mbsSupportedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.quotedCurrency')"></span>
          </dt>
          <dd>
            <span>{{ resort.quotedCurrency }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.comMethod')"></span>
          </dt>
          <dd>
            <span>{{ resort.comMethod }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.email')"></span>
          </dt>
          <dd>
            <span>{{ resort.email }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.genmgr')"></span>
          </dt>
          <dd>
            <span>{{ resort.genmgr }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.dirsales')"></span>
          </dt>
          <dd>
            <span>{{ resort.dirsales }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.leadsend')"></span>
          </dt>
          <dd>
            <span>{{ resort.leadsend }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.airport')"></span>
          </dt>
          <dd>
            <span>{{ resort.airport }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.comAddress')"></span>
          </dt>
          <dd>
            <span>{{ resort.comAddress }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.season1')"></span>
          </dt>
          <dd>
            <span>{{ resort.season1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.season2')"></span>
          </dt>
          <dd>
            <span>{{ resort.season2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.season3')"></span>
          </dt>
          <dd>
            <span>{{ resort.season3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.season4')"></span>
          </dt>
          <dd>
            <span>{{ resort.season4 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.season5')"></span>
          </dt>
          <dd>
            <span>{{ resort.season5 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.floorNumExecutiveFloor')"></span>
          </dt>
          <dd>
            <span>{{ resort.floorNumExecutiveFloor }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.crsResort')"></span>
          </dt>
          <dd>
            <span>{{ resort.crsResort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.postCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.postCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultReservationType')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultReservationType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.block')"></span>
          </dt>
          <dd>
            <span>{{ resort.block }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.currencySymbol')"></span>
          </dt>
          <dd>
            <span>{{ resort.currencySymbol }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.sourceCommission')"></span>
          </dt>
          <dd>
            <span>{{ resort.sourceCommission }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.taCommission')"></span>
          </dt>
          <dd>
            <span>{{ resort.taCommission }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.baseLanguage')"></span>
          </dt>
          <dd>
            <span>{{ resort.baseLanguage }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.folioLanguage1')"></span>
          </dt>
          <dd>
            <span>{{ resort.folioLanguage1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.folioLanguage2')"></span>
          </dt>
          <dd>
            <span>{{ resort.folioLanguage2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.folioLanguage3')"></span>
          </dt>
          <dd>
            <span>{{ resort.folioLanguage3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.folioLanguage4')"></span>
          </dt>
          <dd>
            <span>{{ resort.folioLanguage4 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.packageProfit')"></span>
          </dt>
          <dd>
            <span>{{ resort.packageProfit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.packageLoss')"></span>
          </dt>
          <dd>
            <span>{{ resort.packageLoss }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.decimalSeparator')"></span>
          </dt>
          <dd>
            <span>{{ resort.decimalSeparator }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.shortDateFormat')"></span>
          </dt>
          <dd>
            <span>{{ resort.shortDateFormat }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.longDateFormat')"></span>
          </dt>
          <dd>
            <span>{{ resort.longDateFormat }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.passerbySource')"></span>
          </dt>
          <dd>
            <span>{{ resort.passerbySource }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.passerbyMarket')"></span>
          </dt>
          <dd>
            <span>{{ resort.passerbyMarket }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.arCompany')"></span>
          </dt>
          <dd>
            <span>{{ resort.arCompany }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.arAgent')"></span>
          </dt>
          <dd>
            <span>{{ resort.arAgent }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.arGroups')"></span>
          </dt>
          <dd>
            <span>{{ resort.arGroups }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.arIndividuals')"></span>
          </dt>
          <dd>
            <span>{{ resort.arIndividuals }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.arAcctNoFormat')"></span>
          </dt>
          <dd>
            <span>{{ resort.arAcctNoFormat }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.allowancePeriodAdj')"></span>
          </dt>
          <dd>
            <span>{{ resort.allowancePeriodAdj }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.currencyCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.currencyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.turnawayCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.turnawayCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.summCurrencyCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.summCurrencyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultPropertyAddress')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultPropertyAddress }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultGuestAddress')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultGuestAddress }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.licenseCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.licenseCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.timeFormat')"></span>
          </dt>
          <dd>
            <span>{{ resort.timeFormat }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.chainCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.chainCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.resortType')"></span>
          </dt>
          <dd>
            <span>{{ resort.resortType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.hotelType')"></span>
          </dt>
          <dd>
            <span>{{ resort.hotelType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.ownership')"></span>
          </dt>
          <dd>
            <span>{{ resort.ownership }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.arBalTrxCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.arBalTrxCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.arCreditTrxCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.arCreditTrxCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.arSettleCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.arSettleCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.cashShiftDrop')"></span>
          </dt>
          <dd>
            <span>{{ resort.cashShiftDrop }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.checkExgPaidout')"></span>
          </dt>
          <dd>
            <span>{{ resort.checkExgPaidout }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.checkShiftDrop')"></span>
          </dt>
          <dd>
            <span>{{ resort.checkShiftDrop }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.checkTrxcode')"></span>
          </dt>
          <dd>
            <span>{{ resort.checkTrxcode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.currencyExgPaidout')"></span>
          </dt>
          <dd>
            <span>{{ resort.currencyExgPaidout }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.depositLedTrxCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.depositLedTrxCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.fiscalPeriodType')"></span>
          </dt>
          <dd>
            <span>{{ resort.fiscalPeriodType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultCommissionPercentage')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultCommissionPercentage }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultPrepaidComm')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultPrepaidComm }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultTrxCommCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultTrxCommCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.configurationMode')"></span>
          </dt>
          <dd>
            <span>{{ resort.configurationMode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.weekendDays')"></span>
          </dt>
          <dd>
            <span>{{ resort.weekendDays }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultGroupsRateCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultGroupsRateCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultPostingRoom')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultPostingRoom }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.dfltPkgTranCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.dfltPkgTranCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.dfltTranCodeRateCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.dfltTranCodeRateCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultRateCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultRateCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.croCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.croCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.flowCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.flowCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.extPropertyCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.extPropertyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.opusCurrencyCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.opusCurrencyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.destinationId')"></span>
          </dt>
          <dd>
            <span>{{ resort.destinationId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.flags')"></span>
          </dt>
          <dd>
            <span>{{ resort.flags }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.touristNumber')"></span>
          </dt>
          <dd>
            <span>{{ resort.touristNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.cateringCurrencyCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.cateringCurrencyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultRatecodeRack')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultRatecodeRack }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultRatecodePcr')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultRatecodePcr }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.fnsTier')"></span>
          </dt>
          <dd>
            <span>{{ resort.fnsTier }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.brandCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.brandCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.webaddress')"></span>
          </dt>
          <dd>
            <span>{{ resort.webaddress }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.vatId')"></span>
          </dt>
          <dd>
            <span>{{ resort.vatId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.street')"></span>
          </dt>
          <dd>
            <span>{{ resort.street }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.hotelFc')"></span>
          </dt>
          <dd>
            <span>{{ resort.hotelFc }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.meetingFc')"></span>
          </dt>
          <dd>
            <span>{{ resort.meetingFc }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.arTypewriter')"></span>
          </dt>
          <dd>
            <span>{{ resort.arTypewriter }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.fileTransferFormat')"></span>
          </dt>
          <dd>
            <span>{{ resort.fileTransferFormat }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.confirmRegcardPrinter')"></span>
          </dt>
          <dd>
            <span>{{ resort.confirmRegcardPrinter }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.directions')"></span>
          </dt>
          <dd>
            <span>{{ resort.directions }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.propinfoUrl')"></span>
          </dt>
          <dd>
            <span>{{ resort.propinfoUrl }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.roomAmenity')"></span>
          </dt>
          <dd>
            <span>{{ resort.roomAmenity }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.shopDescription')"></span>
          </dt>
          <dd>
            <span>{{ resort.shopDescription }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.propPicUrl')"></span>
          </dt>
          <dd>
            <span>{{ resort.propPicUrl }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.propMapUrl')"></span>
          </dt>
          <dd>
            <span>{{ resort.propMapUrl }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.extExpFileLocation')"></span>
          </dt>
          <dd>
            <span>{{ resort.extExpFileLocation }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.curtainColor')"></span>
          </dt>
          <dd>
            <span>{{ resort.curtainColor }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.countryCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.countryCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.state')"></span>
          </dt>
          <dd>
            <span>{{ resort.state }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.dateForAging')"></span>
          </dt>
          <dd>
            <span>{{ resort.dateForAging }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.regionCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.regionCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.city')"></span>
          </dt>
          <dd>
            <span>{{ resort.city }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.telephone')"></span>
          </dt>
          <dd>
            <span>{{ resort.telephone }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.fax')"></span>
          </dt>
          <dd>
            <span>{{ resort.fax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.tollfree')"></span>
          </dt>
          <dd>
            <span>{{ resort.tollfree }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultPrinter')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultPrinter }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.videocheckoutPrinter')"></span>
          </dt>
          <dd>
            <span>{{ resort.videocheckoutPrinter }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.companyAddressType')"></span>
          </dt>
          <dd>
            <span>{{ resort.companyAddressType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.companyPhoneType')"></span>
          </dt>
          <dd>
            <span>{{ resort.companyPhoneType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultFaxType')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultFaxType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultMembershipType')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultMembershipType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.individualAddressType')"></span>
          </dt>
          <dd>
            <span>{{ resort.individualAddressType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.individualPhoneType')"></span>
          </dt>
          <dd>
            <span>{{ resort.individualPhoneType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.notes')"></span>
          </dt>
          <dd>
            <span>{{ resort.notes }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.blackoutPeriodNotes')"></span>
          </dt>
          <dd>
            <span>{{ resort.blackoutPeriodNotes }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.sglNum')"></span>
          </dt>
          <dd>
            <span>{{ resort.sglNum }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.dblNum')"></span>
          </dt>
          <dd>
            <span>{{ resort.dblNum }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.tplNum')"></span>
          </dt>
          <dd>
            <span>{{ resort.tplNum }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.suiNum')"></span>
          </dt>
          <dd>
            <span>{{ resort.suiNum }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.airportDistance')"></span>
          </dt>
          <dd>
            <span>{{ resort.airportDistance }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.airportTime')"></span>
          </dt>
          <dd>
            <span>{{ resort.airportTime }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.brArea')"></span>
          </dt>
          <dd>
            <span>{{ resort.brArea }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.name')"></span>
          </dt>
          <dd>
            <span>{{ resort.name }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.legalOwner')"></span>
          </dt>
          <dd>
            <span>{{ resort.legalOwner }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.hotelId')"></span>
          </dt>
          <dd>
            <span>{{ resort.hotelId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.faxNoFormat')"></span>
          </dt>
          <dd>
            <span>{{ resort.faxNoFormat }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.telephoneNoFormat')"></span>
          </dt>
          <dd>
            <span>{{ resort.telephoneNoFormat }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.localCurrencyFormat')"></span>
          </dt>
          <dd>
            <span>{{ resort.localCurrencyFormat }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.dutyManagerPager')"></span>
          </dt>
          <dd>
            <span>{{ resort.dutyManagerPager }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.defaultRegistrationCard')"></span>
          </dt>
          <dd>
            <span>{{ resort.defaultRegistrationCard }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.nightAuditCashierId')"></span>
          </dt>
          <dd>
            <span>{{ resort.nightAuditCashierId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.hotelCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.hotelCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.path')"></span>
          </dt>
          <dd>
            <span>{{ resort.path }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.timezoneRegion')"></span>
          </dt>
          <dd>
            <span>{{ resort.timezoneRegion }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.cateringCurrencyFormat')"></span>
          </dt>
          <dd>
            <span>{{ resort.cateringCurrencyFormat }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.resort.expHotelCode')"></span>
          </dt>
          <dd>
            <span>{{ resort.expHotelCode }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link v-if="resort.id" :to="{ name: 'ResortEdit', params: { resortId: resort.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.edit')"></span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./resort-details.component.ts"></script>
