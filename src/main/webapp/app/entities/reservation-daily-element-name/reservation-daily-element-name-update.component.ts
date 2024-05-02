import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ReservationDailyElementNameService from './reservation-daily-element-name.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IReservationDailyElementName, ReservationDailyElementName } from '@/shared/model/reservation-daily-element-name.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ReservationDailyElementNameUpdate',
  setup() {
    const reservationDailyElementNameService = inject('reservationDailyElementNameService', () => new ReservationDailyElementNameService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const reservationDailyElementName: Ref<IReservationDailyElementName> = ref(new ReservationDailyElementName());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveReservationDailyElementName = async reservationDailyElementNameId => {
      try {
        const res = await reservationDailyElementNameService().find(reservationDailyElementNameId);
        reservationDailyElementName.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.reservationDailyElementNameId) {
      retrieveReservationDailyElementName(route.params.reservationDailyElementNameId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      resort: {},
      resvNameId: {},
      reservationDate: {},
      resvDailyElSeq: {},
      travelAgentId: {},
      companyId: {},
      sourceId: {},
      groupId: {},
      sharePaymentType: {},
      shareAmount: {},
      sharePrcnt: {},
      adults: {},
      children: {},
      discountAmt: {},
      discountPrcnt: {},
      discountReasonCode: {},
      fixedRateYn: {},
      baseRateAmount: {},
      autoPostAmount: {},
      sharePriority: {},
      insertUser: {},
      insertDate: {},
      updateUser: {},
      updateDate: {},
      lastShareCalculation: {},
      insertActionInstanceId: {},
      dmlSeqNo: {},
      netRoomAmt: {},
      roomTax: {},
      pkgAmt: {},
      pkgTax: {},
      grossRateAmt: {},
      adultsTaxFree: {},
      childrenTaxFree: {},
      children1: {},
      children2: {},
      children3: {},
      rateCode: {},
      currencyCode: {},
      exchangePostingType: {},
      membershipPoints: {},
      children4: {},
      children5: {},
      commissionCode: {},
      awardCode1: {},
      awardCode2: {},
      awardCode3: {},
      awardCode4: {},
      awardCode5: {},
      awardVoucher1: {},
      awardVoucher2: {},
      awardVoucher3: {},
      awardVoucher4: {},
      awardVoucher5: {},
      doNotMoveYn: {},
      awardCode: {},
      points: {},
      upsellCharge: {},
      pointsEligibilityCode: {},
      commissionPaid: {},
      resvContactId: {},
      billingContactId: {},
      shareAmountOriginal: {},
      referralYn: {},
      bxgyDiscountYn: {},
      commissionableYn: {},
      basedOnRule: {},
    };
    const v$ = useVuelidate(validationRules, reservationDailyElementName as any);
    v$.value.$validate();

    return {
      reservationDailyElementNameService,
      alertService,
      reservationDailyElementName,
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
      if (this.reservationDailyElementName.id) {
        this.reservationDailyElementNameService()
          .update(this.reservationDailyElementName)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.reservationDailyElementName.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.reservationDailyElementNameService()
          .create(this.reservationDailyElementName)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(
              this.t$('operaHandlerApplicationApp.reservationDailyElementName.created', { param: param.id }).toString(),
            );
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
