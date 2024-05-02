import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import NamePhoneService from './name-phone.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type INamePhone, NamePhone } from '@/shared/model/name-phone.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'NamePhoneUpdate',
  setup() {
    const namePhoneService = inject('namePhoneService', () => new NamePhoneService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const namePhone: Ref<INamePhone> = ref(new NamePhone());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

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

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      phoneId: {},
      nameId: {},
      phoneType: {},
      phoneRole: {},
      phoneNumber: {},
      insertDate: {},
      insertUser: {},
      updateDate: {},
      updateUser: {},
      inactiveDate: {},
      endDate: {},
      beginDate: {},
      addressId: {},
      primaryYn: {},
      displaySeq: {},
      laptopChange: {},
      indexPhone: {},
      extension: {},
      emailFormat: {},
      shareEmailYn: {},
      defaultConfirmationYn: {},
      emailLanguage: {},
      mobileAudioKeyYn: {},
      countryDialingCode: {},
      validYn: {},
      phoneCountryCode: {},
      chainCode: {},
      validateDate: {},
      validateStatus: {},
    };
    const v$ = useVuelidate(validationRules, namePhone as any);
    v$.value.$validate();

    return {
      namePhoneService,
      alertService,
      namePhone,
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
      if (this.namePhone.id) {
        this.namePhoneService()
          .update(this.namePhone)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.namePhone.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.namePhoneService()
          .create(this.namePhone)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('operaHandlerApplicationApp.namePhone.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
