import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ReservationStatDailyService from './reservation-stat-daily.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IReservationStatDaily, ReservationStatDaily } from '@/shared/model/reservation-stat-daily.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ReservationStatDailyUpdate',
  setup() {
    const reservationStatDailyService = inject('reservationStatDailyService', () => new ReservationStatDailyService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const reservationStatDaily: Ref<IReservationStatDaily> = ref(new ReservationStatDaily());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveReservationStatDaily = async reservationStatDailyId => {
      try {
        const res = await reservationStatDailyService().find(reservationStatDailyId);
        reservationStatDaily.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.reservationStatDailyId) {
      retrieveReservationStatDaily(route.params.reservationStatDailyId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      resort: {},
      businessDate: {},
      nameId: {},
      rateCode: {},
      sourceCode: {},
      marketCode: {},
      roomCategory: {},
      companyId: {},
      agentId: {},
      groupId: {},
      sourceProfId: {},
      resvStatus: {},
      truncBeginDate: {},
      truncEndDate: {},
      resvNameId: {},
      quantity: {},
      physicalQuantity: {},
      dueOutYn: {},
      roomResvStatus: {},
      adults: {},
      children: {},
      roomAdults: {},
      roomChildren: {},
      primaryYn: {},
      allotmentHeaderId: {},
      roomRevenue: {},
      foodRevenue: {},
      packageRoomRevenue: {},
      packageFoodRevenue: {},
      totalRoomTax: {},
      totalFoodTax: {},
      totalPackageRevenue: {},
      totalRevenue: {},
      totalTax: {},
      insertDate: {},
      originalEndDate: {},
      walkinYn: {},
      reservationDate: {},
      roomClass: {},
      vipStatus: {},
      cancellationDate: {},
      birthDate: {},
      room: {},
      membershipId: {},
      contactId: {},
      rateCategory: {},
      marketMainGroup: {},
      sourceMainGroup: {},
      channel: {},
      country: {},
      regionCode: {},
      nationality: {},
      psuedoRoomYn: {},
      adultsTaxFree: {},
      childrenTaxFree: {},
      stayRooms: {},
      stayPersons: {},
      stayAdults: {},
      stayChildren: {},
      arrRooms: {},
      arrPersons: {},
      depRooms: {},
      depPersons: {},
      dayUseRooms: {},
      dayUsePersons: {},
      cancelledRooms: {},
      cancelledPersons: {},
      noShowRooms: {},
      noShowPersons: {},
      singleOccupancy: {},
      multipleOccupancy: {},
      cribs: {},
      extraBeds: {},
      otherRevenue: {},
      packageOtherRevenue: {},
      totalOtherTax: {},
      countryMainGroup: {},
      state: {},
      fiscalRegionCode: {},
      nonRevenue: {},
      packageNonRevenue: {},
      totalNonRevenueTax: {},
      prRoomRevenue: {},
      prFoodRevenue: {},
      prPackageRoomRevenue: {},
      prPackageFoodRevenue: {},
      prTotalRoomTax: {},
      prTotalFoodTax: {},
      prTotalPackageRevenue: {},
      prTotalRevenue: {},
      prTotalTax: {},
      prOtherRevenue: {},
      prPackageOtherRevenue: {},
      prTotalOtherTax: {},
      prNonRevenue: {},
      prPackageNonRevenue: {},
      prTotalNonRevenueTax: {},
      nights: {},
      noOfStays: {},
      reservationNights: {},
      reservationArrivals: {},
      reservationNoOfStays: {},
      dayUseReservations: {},
      cancelledReservations: {},
      noShowReservations: {},
      city: {},
      zipCode: {},
      district: {},
      cashRoomNts: {},
      compRoomNts: {},
      cashRoomRevenue: {},
      compRoomRevenue: {},
      resInsertSource: {},
      resInsertSourceType: {},
      children1: {},
      children2: {},
      children3: {},
      children4: {},
      children5: {},
      ffMembershipType: {},
      fgMembershipType: {},
      promotionCode: {},
      ownerFfFlag: {},
      ownerRentalFlag: {},
      centralCurrencyCode: {},
      centralExchangeRate: {},
      bookedRoomCategory: {},
      businessDateCreated: {},
      rateAmount: {},
      parentCompanyId: {},
      houseUseYn: {},
      complimentaryYn: {},
      biResvNameId: {},
      advFoodRevenue: {},
      advNonRevenue: {},
      advOtherRevenue: {},
      advRoomRevenue: {},
      advTotalFoodTax: {},
      advTotalNonRevenueTax: {},
      advTotalOtherTax: {},
      advTotalRevenue: {},
      advTotalRoomTax: {},
      advTotalTax: {},
      prAdvFoodRevenue: {},
      prAdvNonRevenue: {},
      prAdvOtherRevenue: {},
      prAdvRoomRevenue: {},
      prAdvTotalFoodTax: {},
      prAdvTotalNonRevenueTax: {},
      prAdvTotalOtherTax: {},
      prAdvTotalRevenue: {},
      prAdvTotalRoomTax: {},
      prAdvTotalTax: {},
      upsoldRevenue: {},
      flgdRoomRevenue: {},
      flgdFoodRevenue: {},
      flgdNonRevenue: {},
      flgdOtherRevenue: {},
      flgdTotalRoomTax: {},
      flgdTotalFoodTax: {},
      flgdTotalNonRevenueTax: {},
      flgdTotalOtherTax: {},
      flgdTotalRevenue: {},
      flgdTotalTax: {},
      contactYn: {},
      extendedStayTier: {},
      rsAdvTotalRevenue: {},
      rsAdvRoomRevenue: {},
      rsAdvFoodRevenue: {},
      rsAdvOtherRevenue: {},
      rsAdvNonRevenue: {},
      rsAdvTotalTax: {},
      rsAdvRoomTax: {},
      rsAdvFoodTax: {},
      rsAdvOtherTax: {},
      rsAdvNonRevenueTax: {},
      updateDate: {},
      guid: {},
    };
    const v$ = useVuelidate(validationRules, reservationStatDaily as any);
    v$.value.$validate();

    return {
      reservationStatDailyService,
      alertService,
      reservationStatDaily,
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
      if (this.reservationStatDaily.id) {
        this.reservationStatDailyService()
          .update(this.reservationStatDaily)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.reservationStatDaily.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.reservationStatDailyService()
          .create(this.reservationStatDaily)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(
              this.t$('operaHandlerApplicationApp.reservationStatDaily.created', { param: param.id }).toString(),
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
