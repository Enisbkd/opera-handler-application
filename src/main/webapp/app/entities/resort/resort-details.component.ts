import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ResortService from './resort.service';
import { useDateFormat } from '@/shared/composables';
import { type IResort } from '@/shared/model/resort.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ResortDetails',
  setup() {
    const dateFormat = useDateFormat();
    const resortService = inject('resortService', () => new ResortService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const resort: Ref<IResort> = ref({});

    const retrieveResort = async resortId => {
      try {
        const res = await resortService().find(resortId);
        resort.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.resortId) {
      retrieveResort(route.params.resortId);
    }

    return {
      ...dateFormat,
      alertService,
      resort,

      previousState,
      t$: useI18n().t,
    };
  },
});
