import { computed, defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import FinancialTransactionsService from './financial-transactions.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type IFinancialTransactions, FinancialTransactions } from '@/shared/model/financial-transactions.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'FinancialTransactionsUpdate',
  setup() {
    const financialTransactionsService = inject('financialTransactionsService', () => new FinancialTransactionsService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const financialTransactions: Ref<IFinancialTransactions> = ref(new FinancialTransactions());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveFinancialTransactions = async financialTransactionsId => {
      try {
        const res = await financialTransactionsService().find(financialTransactionsId);
        financialTransactions.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.financialTransactionsId) {
      retrieveFinancialTransactions(route.params.financialTransactionsId);
    }

    const { t: t$ } = useI18n();
    const validations = useValidation();
    const validationRules = {
      trxNo: {},
      ftSubtype: {},
      invoiceCloseDate: {},
      arTransferDate: {},
      trxDate: {},
      businessDate: {},
      insertDate: {},
      updateDate: {},
      trnsActivityDate: {},
      approvalDate: {},
      postingDate: {},
      exchangeDate: {},
      routingDate: {},
      effectiveDate: {},
      customChargeDate: {},
      recptNo: {},
      trxNoAdjust: {},
      trxNoAddedBy: {},
      trxNoAgainstPackage: {},
      trxNoHeader: {},
      arNumber: {},
      resvNameId: {},
      cashierId: {},
      creditCardId: {},
      nameId: {},
      tranActionId: {},
      finDmlSeqNo: {},
      routingInstrnId: {},
      fromResvId: {},
      genCashierId: {},
      folioNo: {},
      invoiceNo: {},
      insertUser: {},
      updateUser: {},
      arrangementId: {},
      trnsFromAcct: {},
      trnsToAcct: {},
      billNo: {},
      revisionNo: {},
      resvDepositId: {},
      linkTrxNo: {},
      authorizerId: {},
      compLinkTrxNo: {},
      mtrxNoAgainstPackage: {},
      forexCommPerc: {},
      forexCommAmount: {},
      articleId: {},
      toResvNameId: {},
      roomNts: {},
      orgArLedDebit: {},
      closureNo: {},
      originalResvNameId: {},
      orgBillNo: {},
      membershipId: {},
      installments: {},
      contractGuestDebit: {},
      contractGuestCredit: {},
      contractNetAmount: {},
      contractGrossAmount: {},
      postitNo: {},
      ccTrxFeeAmount: {},
      changeDue: {},
      postingSourceNameId: {},
      bonusCheckId: {},
      roundLinkTrxno: {},
      reversePaymentTrxNo: {},
      electronicVoucherNo: {},
      thresholdDiversionId: {},
      thresholdEntityQty: {},
      trxNoSplit: {},
      exchDiffTrxNo: {},
      associatedTrxNo: {},
      taxRate: {},
      propChargeId: {},
      quantity: {},
      netAmount: {},
      grossAmount: {},
      cashierOpeningBalance: {},
      pricePerUnit: {},
      trxAmount: {},
      postedAmount: {},
      guestAccountCredit: {},
      exchangeRate: {},
      guestAccountDebit: {},
      cashierCredit: {},
      cashierDebit: {},
      packageCredit: {},
      packageDebit: {},
      depLedCredit: {},
      depLedDebit: {},
      revenueAmt: {},
      arLedCredit: {},
      arLedDebit: {},
      euroExchangeRate: {},
      inhDebit: {},
      inhCredit: {},
      packageAllowance: {},
      parallelGuestCredit: {},
      parallelGuestDebit: {},
      parallelNetAmount: {},
      parallelGrossAmount: {},
      orgPostedAmount: {},
      roomNtsEffective: {},
      paymentSurchargeAmt: {},
      folioView: {},
      taxInclusiveYn: {},
      deferredYn: {},
      indAdjustmentYn: {},
      fixedChargesYn: {},
      taCommissionableYn: {},
      taxGeneratedYn: {},
      compressedYn: {},
      displayYn: {},
      collAgentPostingYn: {},
      fiscalTrxCodeType: {},
      deferredTaxesYn: {},
      advancedGenerateYn: {},
      forexType: {},
      taCommissionNetYn: {},
      sourceCommissionNetYn: {},
      settlementFlag: {},
      accTypeFlag: {},
      profitLossFlag: {},
      proformaYn: {},
      holdYn: {},
      exchangeDifferenceYn: {},
      calcPointsYn: {},
      arChargeTransferYn: {},
      processed8300Yn: {},
      asbFlag: {},
      postitYn: {},
      autoSettleYn: {},
      depTaxTransferedYn: {},
      autoCreditbillYn: {},
      asbOnlyPostTaxesOnceYn: {},
      roundFactorYn: {},
      depPostingFlag: {},
      correctionYn: {},
      routedYn: {},
      upsellChargeYn: {},
      advanceBillYn: {},
      advanceBillReversedYn: {},
      incTaxDeductedYn: {},
      gpAwardCancelledYn: {},
      serviceRecoveryAdjustmentYn: {},
      splitType: {},
      bucketRedempYn: {},
      vatOffsetYn: {},
      forexTaxYn: {},
      stampDutyYn: {},
      covers: {},
      advGenerateAdjustment: {},
      expInvoiceType: {},
      folioType: {},
      orgFolioType: {},
      invoiceType: {},
      arState: {},
      exchangeType: {},
      recptType: {},
      roomClass: {},
      resort: {},
      tcGroup: {},
      tcSubgroup: {},
      trxCode: {},
      room: {},
      tclCode1: {},
      currency: {},
      ftGeneratedType: {},
      tclCode2: {},
      marketCode: {},
      sourceCode: {},
      rateCode: {},
      hotelAcct: {},
      reasonCode: {},
      product: {},
      targetResort: {},
      nameTaxType: {},
      taxInvNo: {},
      approvalCode: {},
      approvalStatus: {},
      compLinkTrxCode: {},
      compTypeCode: {},
      couponNo: {},
      originalRoom: {},
      allowanceType: {},
      advGenerateTrxCode: {},
      trxServiceType: {},
      postingType: {},
      parallelCurrency: {},
      contractCurrency: {},
      fbaCertificateNumber: {},
      postingRhythm: {},
      asbTaxFlag: {},
      packageArrangementCode: {},
      gpAwardCode: {},
      gpAwardCancelCode: {},
      serviceRecoveryDeptCode: {},
      bucketCode: {},
      taxRateType: {},
      chequeNumber: {},
      passerByName: {},
      esignedReceiptName: {},
      remark: {},
      reference: {},
      oTrxDesc: {},
      comments: {},
      fiscalBillNo: {},
      extSysResultMsg: {},
      queueName: {},
      paymentType: {},
      ccRefundPosting: {},
      thresholdEntityType: {},
      thresholdTreatmentFlag: {},
      paymentSurchargeType: {},
      propertyBillPrefix: {},
      taxElements: {},
      numberDialed: {},
      checkFileId: {},
      extTrxId: {},
      packageTrxType: {},
      expOriginalInvoice: {},
      depositTransactionId: {},
    };
    const v$ = useVuelidate(validationRules, financialTransactions as any);
    v$.value.$validate();

    return {
      financialTransactionsService,
      alertService,
      financialTransactions,
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
      if (this.financialTransactions.id) {
        this.financialTransactionsService()
          .update(this.financialTransactions)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(this.t$('operaHandlerApplicationApp.financialTransactions.updated', { param: param.id }));
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.financialTransactionsService()
          .create(this.financialTransactions)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(
              this.t$('operaHandlerApplicationApp.financialTransactions.created', { param: param.id }).toString(),
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
