import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import ResortRoomCategoryService from './resort-room-category.service';
import { type IResortRoomCategory } from '@/shared/model/resort-room-category.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ResortRoomCategoryDetails',
  setup() {
    const resortRoomCategoryService = inject('resortRoomCategoryService', () => new ResortRoomCategoryService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const resortRoomCategory: Ref<IResortRoomCategory> = ref({});

    const retrieveResortRoomCategory = async resortRoomCategoryId => {
      try {
        const res = await resortRoomCategoryService().find(resortRoomCategoryId);
        resortRoomCategory.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.resortRoomCategoryId) {
      retrieveResortRoomCategory(route.params.resortRoomCategoryId);
    }

    return {
      alertService,
      resortRoomCategory,

      previousState,
      t$: useI18n().t,
    };
  },
});
