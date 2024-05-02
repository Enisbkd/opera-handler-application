import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import NamePhoneService from './name-phone.service';
import { type INamePhone } from '@/shared/model/name-phone.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'NamePhoneDetails',
  setup() {
    const namePhoneService = inject('namePhoneService', () => new NamePhoneService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const namePhone: Ref<INamePhone> = ref({});

    const retrieveNamePhone = async namePhoneId => {
      try {
        const res = await namePhoneService().find(namePhoneId);
        namePhone.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.namePhoneId) {
      retrieveNamePhone(route.params.namePhoneId);
    }

    return {
      alertService,
      namePhone,

      previousState,
      t$: useI18n().t,
    };
  },
});
