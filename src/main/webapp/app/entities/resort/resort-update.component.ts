import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import ResortService from './resort.service';
import { useValidation, useDateFormat } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IResort, Resort } from '@/shared/model/resort.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ResortUpdate',
  setup() {
    const resortService = inject('resortService', () => new ResortService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const resort: Ref<IResort> = ref(new Resort());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveResort = async resortId => {
      try {
        const res = await resortService().find(resortId);
        res.beginDate = new Date(res.beginDate);
        res.checkInTime = new Date(res.checkInTime);
        res.checkOutTime = new Date(res.checkOutTime);
        res.videoCoStart = new Date(res.videoCoStart);
        res.videoCoStop = new Date(res.videoCoStop);
        res.insertDate = new Date(res.insertDate);
        res.updateDate = new Date(res.updateDate);
        res.expiryDate = new Date(res.expiryDate);
        res.endDate = new Date(res.endDate);
        res.fiscalStartDate = new Date(res.fiscalStartDate);
        res.fiscalEndDate = new Date(res.fiscalEndDate);
        res.reconcileDate = new Date(res.reconcileDate);
        res.paymentDate = new Date(res.paymentDate);
        resort.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.resortId) {
      retrieveResort(route.params.resortId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      resort: {},
      beginDate: {},
      checkInTime: {},
      checkOutTime: {},
      videoCoStart: {},
      videoCoStop: {},
      insertDate: {},
      updateDate: {},
      expiryDate: {},
      endDate: {},
      fiscalStartDate: {},
      fiscalEndDate: {},
      reconcileDate: {},
      paymentDate: {},
      keepAvailability: {},
      budgetMonth: {},
      saveProfiles: {},
      longStayControl: {},
      creditLimit: {},
      numberRooms: {},
      numberFloors: {},
      numberBeds: {},
      rhythmSheets: {},
      rhythmTowels: {},
      warningAmount: {},
      decimalPlaces: {},
      font: {},
      copies: {},
      defaultFolioStyle: {},
      individualRoomWarning: {},
      groupRoomWarning: {},
      agingLevel1: {},
      agingLevel2: {},
      agingLevel3: {},
      agingLevel4: {},
      agingLevel5: {},
      zeroInvPurDays: {},
      minDaysBet2ReminderLetter: {},
      insertUser: {},
      updateUser: {},
      currencyDecimals: {},
      nameIdLink: {},
      sglRate1: {},
      sglRate2: {},
      dblRate1: {},
      dblRate2: {},
      tplRate1: {},
      tplRate2: {},
      suiRate1: {},
      suiRate2: {},
      meetSpace: {},
      imgHotelId: {},
      imgDirectionId: {},
      imgMapId: {},
      scriptId: {},
      comNameXrefId: {},
      pathId: {},
      xresortNumber: {},
      maxCreditDays: {},
      currencyDivisor: {},
      latitude: {},
      longitude: {},
      qtySingleRooms: {},
      qtyDoubleRooms: {},
      qtyTwinRooms: {},
      qtySuites: {},
      qtyGuestRoomFloors: {},
      qtyGuestElevators: {},
      qtyNonSmokingRooms: {},
      qtyConnectingRooms: {},
      qtyHandicappedRooms: {},
      qtyFamilyRooms: {},
      maxAdultsFamilyRoom: {},
      maxChildrenFamilyRoom: {},
      restaurant: {},
      meetRooms: {},
      totRooms: {},
      brSeats: {},
      meetSeats: {},
      maxNoNights: {},
      awardsTimeout: {},
      guestLookupTimeout: {},
      wakeUpDelay: {},
      maxOccupancy: {},
      inactiveDaysForGuestProfil: {},
      perReservationRoomLimit: {},
      licRoomInfo: {},
      thousandSeparator: {},
      dateSeparator: {},
      arAcctNoMandYn: {},
      exchangePostingType: {},
      inventoryYn: {},
      allowLoginYn: {},
      accessCode: {},
      disableLoginYn: {},
      intTaxIncludedYn: {},
      downloadRestYn: {},
      translateMulticharYn: {},
      externalScYn: {},
      sendLeadAsBookingYn: {},
      mbsSupportedYn: {},
      quotedCurrency: {},
      comMethod: {},
      email: {},
      genmgr: {},
      dirsales: {},
      leadsend: {},
      airport: {},
      comAddress: {},
      season1: {},
      season2: {},
      season3: {},
      season4: {},
      season5: {},
      floorNumExecutiveFloor: {},
      crsResort: {},
      postCode: {},
      defaultReservationType: {},
      block: {},
      currencySymbol: {},
      sourceCommission: {},
      taCommission: {},
      baseLanguage: {},
      folioLanguage1: {},
      folioLanguage2: {},
      folioLanguage3: {},
      folioLanguage4: {},
      packageProfit: {},
      packageLoss: {},
      decimalSeparator: {},
      shortDateFormat: {},
      longDateFormat: {},
      passerbySource: {},
      passerbyMarket: {},
      arCompany: {},
      arAgent: {},
      arGroups: {},
      arIndividuals: {},
      arAcctNoFormat: {},
      allowancePeriodAdj: {},
      currencyCode: {},
      turnawayCode: {},
      summCurrencyCode: {},
      defaultPropertyAddress: {},
      defaultGuestAddress: {},
      licenseCode: {},
      timeFormat: {},
      chainCode: {},
      resortType: {},
      hotelType: {},
      ownership: {},
      arBalTrxCode: {},
      arCreditTrxCode: {},
      arSettleCode: {},
      cashShiftDrop: {},
      checkExgPaidout: {},
      checkShiftDrop: {},
      checkTrxcode: {},
      currencyExgPaidout: {},
      depositLedTrxCode: {},
      fiscalPeriodType: {},
      defaultCommissionPercentage: {},
      defaultPrepaidComm: {},
      defaultTrxCommCode: {},
      configurationMode: {},
      weekendDays: {},
      defaultGroupsRateCode: {},
      defaultPostingRoom: {},
      dfltPkgTranCode: {},
      dfltTranCodeRateCode: {},
      defaultRateCode: {},
      croCode: {},
      flowCode: {},
      extPropertyCode: {},
      opusCurrencyCode: {},
      destinationId: {},
      flags: {},
      touristNumber: {},
      cateringCurrencyCode: {},
      defaultRatecodeRack: {},
      defaultRatecodePcr: {},
      fnsTier: {},
      brandCode: {},
      webaddress: {},
      vatId: {},
      street: {},
      hotelFc: {},
      meetingFc: {},
      arTypewriter: {},
      fileTransferFormat: {},
      confirmRegcardPrinter: {},
      directions: {},
      propinfoUrl: {},
      roomAmenity: {},
      shopDescription: {},
      propPicUrl: {},
      propMapUrl: {},
      extExpFileLocation: {},
      curtainColor: {},
      countryCode: {},
      state: {},
      dateForAging: {},
      regionCode: {},
      city: {},
      telephone: {},
      fax: {},
      tollfree: {},
      defaultPrinter: {},
      videocheckoutPrinter: {},
      companyAddressType: {},
      companyPhoneType: {},
      defaultFaxType: {},
      defaultMembershipType: {},
      individualAddressType: {},
      individualPhoneType: {},
      notes: {},
      blackoutPeriodNotes: {},
      sglNum: {},
      dblNum: {},
      tplNum: {},
      suiNum: {},
      airportDistance: {},
      airportTime: {},
      brArea: {},
      name: {},
      legalOwner: {},
      hotelId: {},
      faxNoFormat: {},
      telephoneNoFormat: {},
      localCurrencyFormat: {},
      dutyManagerPager: {},
      defaultRegistrationCard: {},
      nightAuditCashierId: {},
      hotelCode: {},
      path: {},
      timezoneRegion: {},
      cateringCurrencyFormat: {},
      expHotelCode: {},
    };
    const v$ = useVuelidate(validationRules, resort as any);
    v$.value.$validate();

    return {
      resortService,
      alertService,
      resort,
      previousState,
      isSaving,
      currentLanguage,
      v$,
      ...useDateFormat({ entityRef: resort }),
      t$,
    };
  },
  created(): void {},
  methods: {
    save(): void {
      this.isSaving = true;
      if (this.resort.id) {
        this.resortService()
          .update(this.resort)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.resort.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.resortService()
          .create(this.resort)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('operaHandlerApplicationApp.resort.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
