import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import NameService from './name.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IName, Name } from '@/shared/model/name.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'NameUpdate',
  setup() {
    const nameService = inject('nameService', () => new NameService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const name: Ref<IName> = ref(new Name());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

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

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      nameId: {},
      nameCode: {},
      insertUser: {},
      insertDate: {},
      updateUser: {},
      updateDate: {},
      primaryNameId: {},
      repeatGuestId: {},
      mailList: {},
      mailType: {},
      followOn: {},
      businessTitle: {},
      inactiveDate: {},
      arcUpdateDate: {},
      updateFaxDate: {},
      birthDate: {},
      collectionUserId: {},
      company: {},
      soundExCompany: {},
      legalCompany: {},
      first: {},
      middle: {},
      last: {},
      nickname: {},
      title: {},
      soundExLast: {},
      externalReferenceRequ: {},
      vipStatus: {},
      vipAuthorization: {},
      billingProfileCode: {},
      rateStructure: {},
      nameComment: {},
      tourOperatorType: {},
      region: {},
      typeOf1099: {},
      tax1No: {},
      companyNameId: {},
      externalReferenceRequired: {},
      vendorId: {},
      vendorSiteId: {},
      arcOfficeType: {},
      tax2No: {},
      arcMailFlag: {},
      name2: {},
      name3: {},
      salesrep: {},
      tracecode: {},
      geographicRegion: {},
      guestClassification: {},
      primaryAddressId: {},
      primaryPhoneId: {},
      taxExemptStatus: {},
      gdsName: {},
      gdsTransactionNo: {},
      nationality: {},
      language: {},
      salutation: {},
      passport: {},
      historyYn: {},
      resvContact: {},
      contractNo: {},
      contractRecvDate: {},
      acctContact: {},
      priority: {},
      industryCode: {},
      roomsPotential: {},
      competitionCode: {},
      scope: {},
      scopeCity: {},
      territory: {},
      actioncode: {},
      activeYn: {},
      masterAccountYn: {},
      nameType: {},
      sname: {},
      nameTaxType: {},
      sfirst: {},
      arNo: {},
      availabilityOverride: {},
      billingCode: {},
      cashBlInd: {},
      blMsg: {},
      currencyCode: {},
      commissionCode: {},
      holdCode: {},
      interest: {},
      summRefCc: {},
      iataCompType: {},
      srepCode: {},
      accountsource: {},
      markets: {},
      productInterest: {},
      keyword: {},
      letterGreeting: {},
      influence: {},
      deptId: {},
      department: {},
      contactYn: {},
      accountType: {},
      downloadResort: {},
      downloadSrep: {},
      downloadDate: {},
      uploadDate: {},
      laptopChange: {},
      crsNameid: {},
      commPayCentral: {},
      ccProfileYn: {},
      gender: {},
      birthPlace: {},
      birthCountry: {},
      profession: {},
      idType: {},
      idNumber: {},
      idDate: {},
      idPlace: {},
      idCountry: {},
      udfc01: {},
      udfc02: {},
      udfc03: {},
      udfc04: {},
      udfc05: {},
      udfc06: {},
      udfc07: {},
      udfc08: {},
      udfc09: {},
      udfc10: {},
      udfc11: {},
      udfc12: {},
      udfc13: {},
      udfc14: {},
      udfc15: {},
      udfc16: {},
      udfc17: {},
      udfc18: {},
      udfc19: {},
      udfc20: {},
      udfc21: {},
      udfc22: {},
      udfc23: {},
      udfc24: {},
      udfc25: {},
      udfc26: {},
      udfc27: {},
      udfc28: {},
      udfc29: {},
      udfc30: {},
      udfc31: {},
      udfc32: {},
      udfc33: {},
      udfc34: {},
      udfc35: {},
      udfc36: {},
      udfc37: {},
      udfc38: {},
      udfc39: {},
      udfc40: {},
      udfn01: {},
      udfn02: {},
      udfn03: {},
      udfn04: {},
      udfn05: {},
      udfn06: {},
      udfn07: {},
      udfn08: {},
      udfn09: {},
      udfn10: {},
      udfn11: {},
      udfn12: {},
      udfn13: {},
      udfn14: {},
      udfn15: {},
      udfn16: {},
      udfn17: {},
      udfn18: {},
      udfn19: {},
      udfn20: {},
      udfn21: {},
      udfn22: {},
      udfn23: {},
      udfn24: {},
      udfn25: {},
      udfn26: {},
      udfn27: {},
      udfn28: {},
      udfn29: {},
      udfn30: {},
      udfn31: {},
      udfn32: {},
      udfn33: {},
      udfn34: {},
      udfn35: {},
      udfn36: {},
      udfn37: {},
      udfn38: {},
      udfn39: {},
      udfn40: {},
      udfd01: {},
      udfd02: {},
      udfd03: {},
      udfd04: {},
      udfd05: {},
      udfd06: {},
      udfd07: {},
      udfd08: {},
      udfd09: {},
      udfd10: {},
      udfd11: {},
      udfd12: {},
      udfd13: {},
      udfd14: {},
      udfd15: {},
      udfd16: {},
      udfd17: {},
      udfd18: {},
      udfd19: {},
      udfd20: {},
      paymentDueDays: {},
      suffix: {},
      externalId: {},
      guestPrivYn: {},
      emailYn: {},
      mailYn: {},
      indexName: {},
      xlastName: {},
      xfirstName: {},
      xcompanyName: {},
      xtitle: {},
      xsalutation: {},
      sxname: {},
      sxfirstName: {},
      lastUpdatedResort: {},
      envelopeGreeting: {},
      xenvelopeGreeting: {},
      directBillBatchType: {},
      resortRegistered: {},
      taxOffice: {},
      taxType: {},
      taxCategory: {},
      preferredRoomNo: {},
      phoneYn: {},
      smsYn: {},
      isProtected: {},
      xlanguage: {},
      marketResearchYn: {},
      thirdPartyYn: {},
      autoenrollMemberYn: {},
      chainCode: {},
      companyGroupId: {},
      includeIn1099Yn: {},
      creditRating: {},
      titleSuffix: {},
      inactiveReason: {},
      iataConsortia: {},
      psuedoProfileYn: {},
      profilePrivacyFlg: {},
      replaceAddress: {},
      alienRegistrationNo: {},
      immigrationStatus: {},
      visaValidityType: {},
      idDocumentAttachId: {},
      superSearchIndexText: {},
      birthDateStr: {},
      origNameId: {},
      dOptInMailListFlg: {},
      dOptInMarketResearchFlg: {},
      dOptInThirdPartyFlg: {},
      dOptInAutoenrollMemberFlg: {},
      dOptInEmailFlg: {},
      dOptInPhoneFlg: {},
      dOptInSmsFlg: {},
      dOptInGuestPrivFlg: {},
      arCreditLimitYn: {},
      profileCreditLimit: {},
      xmiddleName: {},
      eInvoiceLiableYn: {},
      eInvLiableLastUpdated: {},
      internalBillYn: {},
      compPreApprovalRequiredYn: {},
      anonymizationStatus: {},
      anonymizationDate: {},
    };
    const v$ = useVuelidate(validationRules, name as any);
    v$.value.$validate();

    return {
      nameService,
      alertService,
      name,
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
      if (this.name.id) {
        this.nameService()
          .update(this.name)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.name.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.nameService()
          .create(this.name)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(this.t$('operaHandlerApplicationApp.name.created', { param: param.id }).toString());
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
