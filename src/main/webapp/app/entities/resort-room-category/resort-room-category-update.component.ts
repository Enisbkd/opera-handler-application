import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ResortRoomCategoryService from './resort-room-category.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IResortRoomCategory, ResortRoomCategory } from '@/shared/model/resort-room-category.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ResortRoomCategoryUpdate',
  setup() {
    const resortRoomCategoryService = inject('resortRoomCategoryService', () => new ResortRoomCategoryService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const resortRoomCategory: Ref<IResortRoomCategory> = ref(new ResortRoomCategory());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

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

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      resort: {},
      roomCategory: {},
      roomClass: {},
      numberRooms: {},
      shortDescription: {},
      longDescription: {},
      compiled: {},
      psuedoRoomType: {},
      activeDate: {},
      inactiveDate: {},
      replacesCategory: {},
      orderBy: {},
      maxOccupancy: {},
      maxRollaways: {},
      rateCategory: {},
      label: {},
      genericFlag: {},
      suiteYn: {},
      meetingroomYn: {},
      insertUser: {},
      insertDate: {},
      updateUser: {},
      updateDate: {},
      rateCode: {},
      rateAmount: {},
      defOccupancy: {},
      imageId: {},
      pseudoYn: {},
      sendToInterfaceYn: {},
      yieldableYn: {},
      yieldCategory: {},
      housekeeping: {},
      canDeleteYn: {},
      roominfoUrl: {},
      ownerYn: {},
      autoIncludeYn: {},
      initialRoundUp: {},
      increments: {},
      rotationGroup: {},
      salesFlag: {},
      autoRoomAssignYn: {},
      upsellYn: {},
      ormsUpsellRank: {},
      ormsUpsellAmt: {},
      ormsDrxtraAdult: {},
      ormsDrxtraChild: {},
      maxOccupancyAdults: {},
      maxOccupancyChildren: {},
      roomPool: {},
      memberAwardRoomGrp: {},
      ormsDrxtra2ndAdult: {},
      ormsDrtier1: {},
      ormsDrtier2: {},
      ormsDrtier3: {},
      autoCheckinYn: {},
      rateFloor: {},
      maxFixBedOccupancy: {},
      maintenanceYn: {},
      smokingPreference: {},
      sLabel: {},
      sBedtype: {},
      sellThruRuleYn: {},
      crsDescription: {},
      evisitorFacilityId: {},
      minOccupancy: {},
      accessibleYn: {},
    };
    const v$ = useVuelidate(validationRules, resortRoomCategory as any);
    v$.value.$validate();

    return {
      resortRoomCategoryService,
      alertService,
      resortRoomCategory,
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
      if (this.resortRoomCategory.id) {
        this.resortRoomCategoryService()
          .update(this.resortRoomCategory)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.resortRoomCategory.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.resortRoomCategoryService()
          .create(this.resortRoomCategory)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('operaHandlerApplicationApp.resortRoomCategory.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
