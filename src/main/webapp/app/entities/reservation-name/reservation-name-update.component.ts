import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ReservationNameService from './reservation-name.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IReservationName, ReservationName } from '@/shared/model/reservation-name.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ReservationNameUpdate',
  setup() {
    const reservationNameService = inject('reservationNameService', () => new ReservationNameService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const reservationName: Ref<IReservationName> = ref(new ReservationName());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveReservationName = async reservationNameId => {
      try {
        const res = await reservationNameService().find(reservationNameId);
        reservationName.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.reservationNameId) {
      retrieveReservationName(route.params.reservationNameId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      resort: {},
      resvNameId: {},
      nameId: {},
      nameUsageType: {},
      contactNameId: {},
      insertDate: {},
      insertUser: {},
      updateUser: {},
      updateDate: {},
      resvStatus: {},
      commissionCode: {},
      addressId: {},
      phoneId: {},
      faxYn: {},
      mailYn: {},
      printRateYn: {},
      reportId: {},
      resvNo: {},
      confirmationNo: {},
      beginDate: {},
      endDate: {},
      faxId: {},
      emailId: {},
      emailYn: {},
      consumerYn: {},
      creditCardId: {},
      financiallyResponsibleYn: {},
      paymentMethod: {},
      intermediaryYn: {},
      postingAllowedYn: {},
      displayColor: {},
      actualCheckInDate: {},
      truncActualCheckInDate: {},
      actualCheckOutDate: {},
      truncActualCheckOutDate: {},
      creditLimit: {},
      authorizedBy: {},
      parentResvNameId: {},
      cancellationNo: {},
      cancellationReasonCode: {},
      cancellationReasonDesc: {},
      arrivalTransportType: {},
      arrivalStationCode: {},
      arrivalCarrierCode: {},
      arrivalTransportCode: {},
      arrivalDateTime: {},
      arrivalEstimateTime: {},
      arrivalTranportationYn: {},
      arrivalComments: {},
      departureTransportType: {},
      departureStationCode: {},
      departureCarrierCode: {},
      departureTransportCode: {},
      departureDateTime: {},
      departureEstimateTime: {},
      departureTransportationYn: {},
      departureComments: {},
      cancellationDate: {},
      guaranteeCode: {},
      wlReasonDescription: {},
      wlReasonCode: {},
      wlPriority: {},
      doNotMoveRoom: {},
      externalReference: {},
      partyCode: {},
      walkinYn: {},
      originalEndDate: {},
      approvalAmountCalcMethod: {},
      amountPercent: {},
      nameTaxType: {},
      taxExemptNo: {},
      roomFeatures: {},
      wlTelephoneNo: {},
      videoCheckoutYn: {},
      discountAmt: {},
      discountPrcnt: {},
      discountReasonCode: {},
      commissionPaid: {},
      commissionHoldCode: {},
      truncBeginDate: {},
      truncEndDate: {},
      sguestName: {},
      membershipId: {},
      udfc01: {},
      udfc02: {},
      udfc03: {},
      udfc04: {},
      udfc05: {},
      udfc06: {},
      udfc07: {},
      udfc08: {},
      udfc09: {},
      udfc10: {},
      udfc11: {},
      udfc12: {},
      udfc13: {},
      udfc14: {},
      udfc15: {},
      udfc16: {},
      udfc17: {},
      udfc18: {},
      udfc19: {},
      udfc20: {},
      udfc21: {},
      udfc22: {},
      udfc23: {},
      udfc24: {},
      udfc25: {},
      udfc26: {},
      udfc27: {},
      udfc28: {},
      udfc29: {},
      udfc30: {},
      udfc31: {},
      udfc32: {},
      udfc33: {},
      udfc34: {},
      udfc35: {},
      udfc36: {},
      udfc37: {},
      udfc38: {},
      udfc39: {},
      udfc40: {},
      udfn01: {},
      udfn02: {},
      udfn03: {},
      udfn04: {},
      udfn05: {},
      udfn06: {},
      udfn07: {},
      udfn08: {},
      udfn09: {},
      udfn10: {},
      udfn11: {},
      udfn12: {},
      udfn13: {},
      udfn14: {},
      udfn15: {},
      udfn16: {},
      udfn17: {},
      udfn18: {},
      udfn19: {},
      udfn20: {},
      udfn21: {},
      udfn22: {},
      udfn23: {},
      udfn24: {},
      udfn25: {},
      udfn26: {},
      udfn27: {},
      udfn28: {},
      udfn29: {},
      udfn30: {},
      udfn31: {},
      udfn32: {},
      udfn33: {},
      udfn34: {},
      udfn35: {},
      udfn36: {},
      udfn37: {},
      udfn38: {},
      udfn39: {},
      udfn40: {},
      udfd01: {},
      udfd02: {},
      udfd03: {},
      udfd04: {},
      udfd05: {},
      udfd06: {},
      udfd07: {},
      udfd08: {},
      udfd09: {},
      udfd10: {},
      insertActionInstanceId: {},
      dmlSeqNo: {},
      businessDateCreated: {},
      turndownYn: {},
      roomInstructions: {},
      roomServiceTime: {},
      eventId: {},
      revenueTypeCode: {},
      hurdle: {},
      hurdleOverride: {},
      rateableValue: {},
      restrictionOverride: {},
      yieldableYn: {},
      sguestFirstname: {},
      guestLastName: {},
      guestFirstName: {},
      guestLastNameSdx: {},
      guestFirstNameSdx: {},
      channel: {},
      shareSeqNo: {},
      guestSignature: {},
      extensionId: {},
      resvContactId: {},
      billingContactId: {},
      resInsertSource: {},
      resInsertSourceType: {},
      masterShare: {},
      registrationCardNo: {},
      tiad: {},
      purposeOfStay: {},
      reinstateDate: {},
      purgeDate: {},
      lastSettleDate: {},
      lastPeriodicFolioDate: {},
      periodicFolioFreq: {},
      confirmationLegNo: {},
      guestStatus: {},
      guestType: {},
      checkinDuration: {},
      authorizerId: {},
      lastOnlinePrintSeq: {},
      entryPoint: {},
      entryDate: {},
      pseudoMemType: {},
      pseudoMemTotalPoints: {},
      folioText1: {},
      folioText2: {},
      compTypeCode: {},
      uniCardId: {},
      expCheckinresId: {},
      originalBeginDate: {},
      ownerFfFlag: {},
      commissionPayoutTo: {},
      preChargingYn: {},
      postChargingYn: {},
      postCoFlag: {},
      folioCloseDate: {},
      scheduleCheckoutYn: {},
      customReference: {},
      guaranteeCodePreCi: {},
      awardMembershipId: {},
      esignedRegCardName: {},
      statisticalRoomType: {},
      statisticalRateTier: {},
      ymCode: {},
      keyValidUntil: {},
      preRegisteredYn: {},
      taxRegistrationNo: {},
      visaNumber: {},
      visaIssueDate: {},
      visaExpirationDate: {},
      taxNoOfStays: {},
      asbProratedYn: {},
      autoSettleDays: {},
      autoSettleYn: {},
      splitFromResvNameId: {},
      nextDestination: {},
      dateOfArrivalInCountry: {},
      preArrReviewedDt: {},
      preArrReviewedUser: {},
      bonusCheckId: {},
      mobileAudioKeyYn: {},
      directBillVerifyResponse: {},
      addresseeNameId: {},
      superSearchIndexText: {},
      autoCheckinYn: {},
      emailFolioYn: {},
      emailAddress: {},
      spgUpgradeConfirmedRoomtype: {},
      spgUpgradeReasonCode: {},
      spgSuiteNightAwardStatus: {},
      spgDiscloseRoomTypeYn: {},
      amenityEligibleYn: {},
      amenityLevelCode: {},
      baseRateCurrencyCode: {},
      baseRateCode: {},
      localBaseRateAmount: {},
      phoneDisplayNameYn: {},
      resortChargeNumber: {},
      mobileChkoutAllowed: {},
      mobileViewFolioAllowed: {},
      hkExpectedServiceTime: {},
      eligibleForUpgradeYn: {},
      beginSystemDateTime: {},
      mobileCheckinAllowedYn: {},
      quoteId: {},
      manualCheckoutStatus: {},
      mobilePreferredCurrency: {},
      mobileActionAlertIssued: {},
      externalEfolioYn: {},
      optInBatchFolYn: {},
      folioAddrElementId: {},
      operaEsignedRegCardYn: {},
      resvGuid: {},
      advanceCheckedInYn: {},
      expectedTimeOfReturn: {},
      etrComments: {},
      optedForCommYn: {},
      creditLimitAutoPayAllowYn: {},
    };
    const v$ = useVuelidate(validationRules, reservationName as any);
    v$.value.$validate();

    return {
      reservationNameService,
      alertService,
      reservationName,
      previousState,
      isSaving,
      currentLanguage,
      v$,
      t$,
    };
  },
  created(): void {},
  methods: {
    save(): void {
      this.isSaving = true;
      if (this.reservationName.id) {
        this.reservationNameService()
          .update(this.reservationName)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.reservationName.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.reservationNameService()
          .create(this.reservationName)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('operaHandlerApplicationApp.reservationName.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
