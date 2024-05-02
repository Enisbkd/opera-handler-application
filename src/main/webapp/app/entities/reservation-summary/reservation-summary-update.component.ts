import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ReservationSummaryService from './reservation-summary.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IReservationSummary, ReservationSummary } from '@/shared/model/reservation-summary.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ReservationSummaryUpdate',
  setup() {
    const reservationSummaryService = inject('reservationSummaryService', () => new ReservationSummaryService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const reservationSummary: Ref<IReservationSummary> = ref(new ReservationSummary());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveReservationSummary = async reservationSummaryId => {
      try {
        const res = await reservationSummaryService().find(reservationSummaryId);
        reservationSummary.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.reservationSummaryId) {
      retrieveReservationSummary(route.params.reservationSummaryId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      resort: {},
      eventType: {},
      eventId: {},
      consideredDate: {},
      roomCategory: {},
      roomClass: {},
      marketCode: {},
      sourceCode: {},
      rateCode: {},
      regionCode: {},
      groupId: {},
      resvType: {},
      resvInvType: {},
      psuedoRoomYn: {},
      arrRooms: {},
      adults: {},
      children: {},
      depRooms: {},
      noRooms: {},
      grossRate: {},
      netRoomRevenue: {},
      extraRevenue: {},
      ooRooms: {},
      osRooms: {},
      remainingBlockRooms: {},
      pickedupBlockRooms: {},
      singleOccupancy: {},
      multipleOccupancy: {},
      blockStatus: {},
      arrPersons: {},
      depPersons: {},
      wlRooms: {},
      wlPersons: {},
      dayUseRooms: {},
      dayUsePersons: {},
      bookingStatus: {},
      resvStatus: {},
      dayUseYn: {},
      channel: {},
      country: {},
      nationality: {},
      cribs: {},
      extraBeds: {},
      adultsTaxFree: {},
      childrenTaxFree: {},
      rateCategory: {},
      rateClass: {},
      roomRevenue: {},
      foodRevenue: {},
      otherRevenue: {},
      totalRevenue: {},
      nonRevenue: {},
      allotmentHeaderId: {},
      roomRevenueTax: {},
      foodRevenueTax: {},
      otherRevenueTax: {},
      totalRevenueTax: {},
      nonRevenueTax: {},
      city: {},
      zipCode: {},
      district: {},
      state: {},
      children1: {},
      children2: {},
      children3: {},
      children4: {},
      children5: {},
      ownerFfFlag: {},
      ownerRentalFlag: {},
      fcGrossRate: {},
      fcNetRoomRevenue: {},
      fcExtraRevenue: {},
      fcRoomRevenue: {},
      fcFoodRevenue: {},
      fcOtherRevenue: {},
      fcTotalRevenue: {},
      fcNonRevenue: {},
      fcRoomRevenueTax: {},
      fcFoodRevenueTax: {},
      fcOtherRevenueTax: {},
      fcTotalRevenueTax: {},
      fcNonRevenueTax: {},
      currencyCode: {},
      exchangeDate: {},
      updateBusinessDate: {},
      updateDate: {},
      centralCurrencyCode: {},
      centralExchangeRate: {},
      truncBeginDate: {},
      truncEndDate: {},
      businessDateCreated: {},
      resInsertSource: {},
      parentCompanyId: {},
      agentId: {},
      gender: {},
      vipStatus: {},
      quantity: {},
      turndownStatus: {},
      bookedRoomCategory: {},
      sourceProfId: {},
    };
    const v$ = useVuelidate(validationRules, reservationSummary as any);
    v$.value.$validate();

    return {
      reservationSummaryService,
      alertService,
      reservationSummary,
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
      if (this.reservationSummary.id) {
        this.reservationSummaryService()
          .update(this.reservationSummary)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.reservationSummary.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.reservationSummaryService()
          .create(this.reservationSummary)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('operaHandlerApplicationApp.reservationSummary.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
