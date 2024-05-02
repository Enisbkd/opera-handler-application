import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import NameService from './name.service';
import { type IName } from '@/shared/model/name.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'NameDetails',
  setup() {
    const nameService = inject('nameService', () => new NameService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const name: Ref<IName> = ref({});

    const retrieveName = async nameId => {
      try {
        const res = await nameService().find(nameId);
        name.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.nameId) {
      retrieveName(route.params.nameId);
    }

    return {
      alertService,
      name,

      previousState,
      t$: useI18n().t,
    };
  },
});
