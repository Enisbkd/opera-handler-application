import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ResortOriginsOfBookingService from './resort-origins-of-booking.service';
import { type IResortOriginsOfBooking } from '@/shared/model/resort-origins-of-booking.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ResortOriginsOfBookingDetails',
  setup() {
    const resortOriginsOfBookingService = inject('resortOriginsOfBookingService', () => new ResortOriginsOfBookingService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const resortOriginsOfBooking: Ref<IResortOriginsOfBooking> = ref({});

    const retrieveResortOriginsOfBooking = async resortOriginsOfBookingId => {
      try {
        const res = await resortOriginsOfBookingService().find(resortOriginsOfBookingId);
        resortOriginsOfBooking.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.resortOriginsOfBookingId) {
      retrieveResortOriginsOfBooking(route.params.resortOriginsOfBookingId);
    }

    return {
      alertService,
      resortOriginsOfBooking,

      previousState,
      t$: useI18n().t,
    };
  },
});
