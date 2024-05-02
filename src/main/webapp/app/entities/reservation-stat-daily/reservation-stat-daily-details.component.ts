import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ReservationStatDailyService from './reservation-stat-daily.service';
import { type IReservationStatDaily } from '@/shared/model/reservation-stat-daily.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ReservationStatDailyDetails',
  setup() {
    const reservationStatDailyService = inject('reservationStatDailyService', () => new ReservationStatDailyService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const reservationStatDaily: Ref<IReservationStatDaily> = ref({});

    const retrieveReservationStatDaily = async reservationStatDailyId => {
      try {
        const res = await reservationStatDailyService().find(reservationStatDailyId);
        reservationStatDaily.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.reservationStatDailyId) {
      retrieveReservationStatDaily(route.params.reservationStatDailyId);
    }

    return {
      alertService,
      reservationStatDaily,

      previousState,
      t$: useI18n().t,
    };
  },
});
