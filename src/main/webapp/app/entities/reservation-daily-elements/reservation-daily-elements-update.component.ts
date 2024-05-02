import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ReservationDailyElementsService from './reservation-daily-elements.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IReservationDailyElements, ReservationDailyElements } from '@/shared/model/reservation-daily-elements.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ReservationDailyElementsUpdate',
  setup() {
    const reservationDailyElementsService = inject('reservationDailyElementsService', () => new ReservationDailyElementsService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const reservationDailyElements: Ref<IReservationDailyElements> = ref(new ReservationDailyElements());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveReservationDailyElements = async reservationDailyElementsId => {
      try {
        const res = await reservationDailyElementsService().find(reservationDailyElementsId);
        reservationDailyElements.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.reservationDailyElementsId) {
      retrieveReservationDailyElements(route.params.reservationDailyElementsId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      resort: {},
      reservationDate: {},
      resvDailyElSeq: {},
      resvStatus: {},
      externalReference: {},
      roomClass: {},
      roomCategory: {},
      bookedRoomCategory: {},
      room: {},
      cancellationNo: {},
      cancellationDate: {},
      cancellationCode: {},
      cancellationReasonDesc: {},
      guaranteeCode: {},
      marketCode: {},
      originOfBooking: {},
      exchangeRate: {},
      originalBaseRate: {},
      baseRateAmount: {},
      rateAmount: {},
      roomCost: {},
      quantity: {},
      adults: {},
      children: {},
      physicalQuantity: {},
      allotmentHeaderId: {},
      dayUseYn: {},
      dueOutYn: {},
      insertUser: {},
      insertDate: {},
      updateUser: {},
      updateDate: {},
      insertActionInstanceId: {},
      dmlSeqNo: {},
      extSeqNo: {},
      extSegNo: {},
      cribs: {},
      extraBeds: {},
      allotmentRecordType: {},
      blockResort: {},
      blockId: {},
      turndownStatus: {},
      awdUpgrFrom: {},
      awdUpgrTo: {},
      hkExpectedServiceTime: {},
      roomInstructions: {},
    };
    const v$ = useVuelidate(validationRules, reservationDailyElements as any);
    v$.value.$validate();

    return {
      reservationDailyElementsService,
      alertService,
      reservationDailyElements,
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
      if (this.reservationDailyElements.id) {
        this.reservationDailyElementsService()
          .update(this.reservationDailyElements)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.reservationDailyElements.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.reservationDailyElementsService()
          .create(this.reservationDailyElements)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(
              this.t$('operaHandlerApplicationApp.reservationDailyElements.created', { param: param.id }).toString(),
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
