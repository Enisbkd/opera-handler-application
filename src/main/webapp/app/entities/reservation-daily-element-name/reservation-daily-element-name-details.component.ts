import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ReservationDailyElementNameService from './reservation-daily-element-name.service';
import { type IReservationDailyElementName } from '@/shared/model/reservation-daily-element-name.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ReservationDailyElementNameDetails',
  setup() {
    const reservationDailyElementNameService = inject('reservationDailyElementNameService', () => new ReservationDailyElementNameService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const reservationDailyElementName: Ref<IReservationDailyElementName> = ref({});

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

    return {
      alertService,
      reservationDailyElementName,

      previousState,
      t$: useI18n().t,
    };
  },
});
