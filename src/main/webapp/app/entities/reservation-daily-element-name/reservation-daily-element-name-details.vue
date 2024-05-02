<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="reservationDailyElementName">
        <h2 class="jh-entity-heading" data-cy="reservationDailyElementNameDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.detail.title')"></span>
          {{ reservationDailyElementName.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resort')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.resort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resvNameId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.resvNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.reservationDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.reservationDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resvDailyElSeq')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.resvDailyElSeq }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.travelAgentId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.travelAgentId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.companyId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.companyId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sourceId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.sourceId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.groupId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.groupId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sharePaymentType')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.sharePaymentType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.shareAmount')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.shareAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sharePrcnt')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.sharePrcnt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.adults')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.adults }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.children }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.discountAmt')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.discountAmt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.discountPrcnt')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.discountPrcnt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.discountReasonCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.discountReasonCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.fixedRateYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.fixedRateYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.baseRateAmount')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.baseRateAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.autoPostAmount')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.autoPostAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.sharePriority')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.sharePriority }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.lastShareCalculation')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.lastShareCalculation }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.insertActionInstanceId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.insertActionInstanceId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.dmlSeqNo')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.dmlSeqNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.netRoomAmt')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.netRoomAmt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.roomTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.roomTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.pkgAmt')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.pkgAmt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.pkgTax')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.pkgTax }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.grossRateAmt')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.grossRateAmt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.adultsTaxFree')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.adultsTaxFree }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.childrenTaxFree')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.childrenTaxFree }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children1')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.children1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children2')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.children2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children3')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.children3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.rateCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.rateCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.currencyCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.currencyCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.exchangePostingType')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.exchangePostingType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.membershipPoints')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.membershipPoints }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children4')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.children4 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.children5')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.children5 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.commissionCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.commissionCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode1')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardCode1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode2')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardCode2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode3')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardCode3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode4')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardCode4 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode5')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardCode5 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher1')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardVoucher1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher2')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardVoucher2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher3')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardVoucher3 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher4')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardVoucher4 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardVoucher5')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardVoucher5 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.doNotMoveYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.doNotMoveYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.awardCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.awardCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.points')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.points }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.upsellCharge')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.upsellCharge }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.pointsEligibilityCode')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.pointsEligibilityCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.commissionPaid')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.commissionPaid }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.resvContactId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.resvContactId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.billingContactId')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.billingContactId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.shareAmountOriginal')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.shareAmountOriginal }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.referralYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.referralYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.bxgyDiscountYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.bxgyDiscountYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.commissionableYn')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.commissionableYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElementName.basedOnRule')"></span>
          </dt>
          <dd>
            <span>{{ reservationDailyElementName.basedOnRule }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="reservationDailyElementName.id"
          :to="{ name: 'ReservationDailyElementNameEdit', params: { reservationDailyElementNameId: reservationDailyElementName.id } }"
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

<script lang="ts" src="./reservation-daily-element-name-details.component.ts"></script>
