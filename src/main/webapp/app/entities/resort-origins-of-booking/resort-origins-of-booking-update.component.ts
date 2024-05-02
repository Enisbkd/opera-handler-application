import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ResortOriginsOfBookingService from './resort-origins-of-booking.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IResortOriginsOfBooking, ResortOriginsOfBooking } from '@/shared/model/resort-origins-of-booking.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ResortOriginsOfBookingUpdate',
  setup() {
    const resortOriginsOfBookingService = inject('resortOriginsOfBookingService', () => new ResortOriginsOfBookingService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const resortOriginsOfBooking: Ref<IResortOriginsOfBooking> = ref(new ResortOriginsOfBooking());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

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

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      resort: {},
      sourceCode: {},
      parentSourceCode: {},
      description: {},
      insertUser: {},
      insertDate: {},
      updateUser: {},
      updateDate: {},
      inactiveDate: {},
      sellSequence: {},
      scOrderby: {},
      internetSalesYn: {},
    };
    const v$ = useVuelidate(validationRules, resortOriginsOfBooking as any);
    v$.value.$validate();

    return {
      resortOriginsOfBookingService,
      alertService,
      resortOriginsOfBooking,
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
      if (this.resortOriginsOfBooking.id) {
        this.resortOriginsOfBookingService()
          .update(this.resortOriginsOfBooking)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.resortOriginsOfBooking.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.resortOriginsOfBookingService()
          .create(this.resortOriginsOfBooking)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(
              this.t$('operaHandlerApplicationApp.resortOriginsOfBooking.created', { param: param.id }).toString(),
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
