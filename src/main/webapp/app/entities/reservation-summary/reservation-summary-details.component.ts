import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ReservationSummaryService from './reservation-summary.service';
import { type IReservationSummary } from '@/shared/model/reservation-summary.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ReservationSummaryDetails',
  setup() {
    const reservationSummaryService = inject('reservationSummaryService', () => new ReservationSummaryService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const reservationSummary: Ref<IReservationSummary> = ref({});

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

    return {
      alertService,
      reservationSummary,

      previousState,
      t$: useI18n().t,
    };
  },
});
