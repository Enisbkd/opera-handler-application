import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ReservationNameService from './reservation-name.service';
import { type IReservationName } from '@/shared/model/reservation-name.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ReservationNameDetails',
  setup() {
    const reservationNameService = inject('reservationNameService', () => new ReservationNameService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const reservationName: Ref<IReservationName> = ref({});

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

    return {
      alertService,
      reservationName,

      previousState,
      t$: useI18n().t,
    };
  },
});
