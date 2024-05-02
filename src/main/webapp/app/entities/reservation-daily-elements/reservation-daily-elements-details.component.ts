import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ReservationDailyElementsService from './reservation-daily-elements.service';
import { type IReservationDailyElements } from '@/shared/model/reservation-daily-elements.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ReservationDailyElementsDetails',
  setup() {
    const reservationDailyElementsService = inject('reservationDailyElementsService', () => new ReservationDailyElementsService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const reservationDailyElements: Ref<IReservationDailyElements> = ref({});

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

    return {
      alertService,
      reservationDailyElements,

      previousState,
      t$: useI18n().t,
    };
  },
});
