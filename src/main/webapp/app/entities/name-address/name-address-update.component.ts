import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import NameAddressService from './name-address.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type INameAddress, NameAddress } from '@/shared/model/name-address.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'NameAddressUpdate',
  setup() {
    const nameAddressService = inject('nameAddressService', () => new NameAddressService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const nameAddress: Ref<INameAddress> = ref(new NameAddress());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

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

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      addressId: {},
      addressType: {},
      address1: {},
      address2: {},
      address3: {},
      address4: {},
      barcode: {},
      beginDate: {},
      chainCode: {},
      city: {},
      cityExt: {},
      cleansedDatetime: {},
      cleansedErrormsg: {},
      cleansedMatchstatus: {},
      cleansedStatus: {},
      cleansedValidationstatus: {},
      country: {},
      endDate: {},
      foreignCountry: {},
      inCareOf: {},
      inactiveDate: {},
      insertDate: {},
      insertUser: {},
      languageCode: {},
      laptopChange: {},
      lastUpdatedResort: {},
      nameId: {},
      primaryYn: {},
      province: {},
      state: {},
      updateDate: {},
      updateUser: {},
      zipCode: {},
    };
    const v$ = useVuelidate(validationRules, nameAddress as any);
    v$.value.$validate();

    return {
      nameAddressService,
      alertService,
      nameAddress,
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
      if (this.nameAddress.id) {
        this.nameAddressService()
          .update(this.nameAddress)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.nameAddress.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.nameAddressService()
          .create(this.nameAddress)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('operaHandlerApplicationApp.nameAddress.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
