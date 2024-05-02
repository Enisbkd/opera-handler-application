import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import NameAddressService from './name-address.service';
import { type INameAddress } from '@/shared/model/name-address.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'NameAddressDetails',
  setup() {
    const nameAddressService = inject('nameAddressService', () => new NameAddressService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const nameAddress: Ref<INameAddress> = ref({});

    const retrieveNameAddress = async nameAddressId => {
      try {
        const res = await nameAddressService().find(nameAddressId);
        nameAddress.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.nameAddressId) {
      retrieveNameAddress(route.params.nameAddressId);
    }

    return {
      alertService,
      nameAddress,

      previousState,
      t$: useI18n().t,
    };
  },
});
