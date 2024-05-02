export interface IFinancialTransactions {
  id?: number;
  trxNo?: number | null;
  ftSubtype?: string | null;
  invoiceCloseDate?: Date | null;
  arTransferDate?: Date | null;
  trxDate?: Date | null;
  businessDate?: Date | null;
  insertDate?: Date | null;
  updateDate?: Date | null;
  trnsActivityDate?: Date | null;
  approvalDate?: Date | null;
  postingDate?: Date | null;
  exchangeDate?: Date | null;
  routingDate?: Date | null;
  effectiveDate?: Date | null;
  customChargeDate?: Date | null;
  recptNo?: number | null;
  trxNoAdjust?: number | null;
  trxNoAddedBy?: number | null;
  trxNoAgainstPackage?: number | null;
  trxNoHeader?: number | null;
  arNumber?: number | null;
  resvNameId?: number | null;
  cashierId?: number | null;
  creditCardId?: number | null;
  nameId?: number | null;
  tranActionId?: number | null;
  finDmlSeqNo?: number | null;
  routingInstrnId?: number | null;
  fromResvId?: number | null;
  genCashierId?: number | null;
  folioNo?: number | null;
  invoiceNo?: number | null;
  insertUser?: number | null;
  updateUser?: number | null;
  arrangementId?: number | null;
  trnsFromAcct?: number | null;
  trnsToAcct?: number | null;
  billNo?: number | null;
  revisionNo?: number | null;
  resvDepositId?: number | null;
  linkTrxNo?: number | null;
  authorizerId?: number | null;
  compLinkTrxNo?: number | null;
  mtrxNoAgainstPackage?: number | null;
  forexCommPerc?: number | null;
  forexCommAmount?: number | null;
  articleId?: number | null;
  toResvNameId?: number | null;
  roomNts?: number | null;
  orgArLedDebit?: number | null;
  closureNo?: number | null;
  originalResvNameId?: number | null;
  orgBillNo?: number | null;
  membershipId?: number | null;
  installments?: number | null;
  contractGuestDebit?: number | null;
  contractGuestCredit?: number | null;
  contractNetAmount?: number | null;
  contractGrossAmount?: number | null;
  postitNo?: number | null;
  ccTrxFeeAmount?: number | null;
  changeDue?: number | null;
  postingSourceNameId?: number | null;
  bonusCheckId?: number | null;
  roundLinkTrxno?: number | null;
  reversePaymentTrxNo?: number | null;
  electronicVoucherNo?: number | null;
  thresholdDiversionId?: number | null;
  thresholdEntityQty?: number | null;
  trxNoSplit?: number | null;
  exchDiffTrxNo?: number | null;
  associatedTrxNo?: number | null;
  taxRate?: number | null;
  propChargeId?: number | null;
  quantity?: number | null;
  netAmount?: number | null;
  grossAmount?: number | null;
  cashierOpeningBalance?: number | null;
  pricePerUnit?: number | null;
  trxAmount?: number | null;
  postedAmount?: number | null;
  guestAccountCredit?: number | null;
  exchangeRate?: number | null;
  guestAccountDebit?: number | null;
  cashierCredit?: number | null;
  cashierDebit?: number | null;
  packageCredit?: number | null;
  packageDebit?: number | null;
  depLedCredit?: number | null;
  depLedDebit?: number | null;
  revenueAmt?: number | null;
  arLedCredit?: number | null;
  arLedDebit?: number | null;
  euroExchangeRate?: number | null;
  inhDebit?: number | null;
  inhCredit?: number | null;
  packageAllowance?: number | null;
  parallelGuestCredit?: number | null;
  parallelGuestDebit?: number | null;
  parallelNetAmount?: number | null;
  parallelGrossAmount?: number | null;
  orgPostedAmount?: number | null;
  roomNtsEffective?: number | null;
  paymentSurchargeAmt?: number | null;
  folioView?: number | null;
  taxInclusiveYn?: string | null;
  deferredYn?: string | null;
  indAdjustmentYn?: string | null;
  fixedChargesYn?: string | null;
  taCommissionableYn?: string | null;
  taxGeneratedYn?: string | null;
  compressedYn?: string | null;
  displayYn?: string | null;
  collAgentPostingYn?: string | null;
  fiscalTrxCodeType?: string | null;
  deferredTaxesYn?: string | null;
  advancedGenerateYn?: string | null;
  forexType?: string | null;
  taCommissionNetYn?: string | null;
  sourceCommissionNetYn?: string | null;
  settlementFlag?: string | null;
  accTypeFlag?: string | null;
  profitLossFlag?: string | null;
  proformaYn?: string | null;
  holdYn?: string | null;
  exchangeDifferenceYn?: string | null;
  calcPointsYn?: string | null;
  arChargeTransferYn?: string | null;
  processed8300Yn?: string | null;
  asbFlag?: string | null;
  postitYn?: string | null;
  autoSettleYn?: string | null;
  depTaxTransferedYn?: string | null;
  autoCreditbillYn?: string | null;
  asbOnlyPostTaxesOnceYn?: string | null;
  roundFactorYn?: string | null;
  depPostingFlag?: string | null;
  correctionYn?: string | null;
  routedYn?: string | null;
  upsellChargeYn?: string | null;
  advanceBillYn?: string | null;
  advanceBillReversedYn?: string | null;
  incTaxDeductedYn?: string | null;
  gpAwardCancelledYn?: string | null;
  serviceRecoveryAdjustmentYn?: string | null;
  splitType?: string | null;
  bucketRedempYn?: string | null;
  vatOffsetYn?: string | null;
  forexTaxYn?: string | null;
  stampDutyYn?: string | null;
  covers?: string | null;
  advGenerateAdjustment?: string | null;
  expInvoiceType?: string | null;
  folioType?: string | null;
  orgFolioType?: string | null;
  invoiceType?: string | null;
  arState?: string | null;
  exchangeType?: string | null;
  recptType?: string | null;
  roomClass?: string | null;
  resort?: string | null;
  tcGroup?: string | null;
  tcSubgroup?: string | null;
  trxCode?: string | null;
  room?: string | null;
  tclCode1?: string | null;
  currency?: string | null;
  ftGeneratedType?: string | null;
  tclCode2?: string | null;
  marketCode?: string | null;
  sourceCode?: string | null;
  rateCode?: string | null;
  hotelAcct?: string | null;
  reasonCode?: string | null;
  product?: string | null;
  targetResort?: string | null;
  nameTaxType?: string | null;
  taxInvNo?: string | null;
  approvalCode?: string | null;
  approvalStatus?: string | null;
  compLinkTrxCode?: string | null;
  compTypeCode?: string | null;
  couponNo?: string | null;
  originalRoom?: string | null;
  allowanceType?: string | null;
  advGenerateTrxCode?: string | null;
  trxServiceType?: string | null;
  postingType?: string | null;
  parallelCurrency?: string | null;
  contractCurrency?: string | null;
  fbaCertificateNumber?: string | null;
  postingRhythm?: string | null;
  asbTaxFlag?: string | null;
  packageArrangementCode?: string | null;
  gpAwardCode?: string | null;
  gpAwardCancelCode?: string | null;
  serviceRecoveryDeptCode?: string | null;
  bucketCode?: string | null;
  taxRateType?: string | null;
  chequeNumber?: string | null;
  passerByName?: string | null;
  esignedReceiptName?: string | null;
  remark?: string | null;
  reference?: string | null;
  oTrxDesc?: string | null;
  comments?: string | null;
  fiscalBillNo?: string | null;
  extSysResultMsg?: string | null;
  queueName?: string | null;
  paymentType?: string | null;
  ccRefundPosting?: string | null;
  thresholdEntityType?: string | null;
  thresholdTreatmentFlag?: string | null;
  paymentSurchargeType?: string | null;
  propertyBillPrefix?: string | null;
  taxElements?: string | null;
  numberDialed?: string | null;
  checkFileId?: string | null;
  extTrxId?: string | null;
  packageTrxType?: string | null;
  expOriginalInvoice?: string | null;
  depositTransactionId?: string | null;
}

export class FinancialTransactions implements IFinancialTransactions {
  constructor(
    public id?: number,
    public trxNo?: number | null,
    public ftSubtype?: string | null,
    public invoiceCloseDate?: Date | null,
    public arTransferDate?: Date | null,
    public trxDate?: Date | null,
    public businessDate?: Date | null,
    public insertDate?: Date | null,
    public updateDate?: Date | null,
    public trnsActivityDate?: Date | null,
    public approvalDate?: Date | null,
    public postingDate?: Date | null,
    public exchangeDate?: Date | null,
    public routingDate?: Date | null,
    public effectiveDate?: Date | null,
    public customChargeDate?: Date | null,
    public recptNo?: number | null,
    public trxNoAdjust?: number | null,
    public trxNoAddedBy?: number | null,
    public trxNoAgainstPackage?: number | null,
    public trxNoHeader?: number | null,
    public arNumber?: number | null,
    public resvNameId?: number | null,
    public cashierId?: number | null,
    public creditCardId?: number | null,
    public nameId?: number | null,
    public tranActionId?: number | null,
    public finDmlSeqNo?: number | null,
    public routingInstrnId?: number | null,
    public fromResvId?: number | null,
    public genCashierId?: number | null,
    public folioNo?: number | null,
    public invoiceNo?: number | null,
    public insertUser?: number | null,
    public updateUser?: number | null,
    public arrangementId?: number | null,
    public trnsFromAcct?: number | null,
    public trnsToAcct?: number | null,
    public billNo?: number | null,
    public revisionNo?: number | null,
    public resvDepositId?: number | null,
    public linkTrxNo?: number | null,
    public authorizerId?: number | null,
    public compLinkTrxNo?: number | null,
    public mtrxNoAgainstPackage?: number | null,
    public forexCommPerc?: number | null,
    public forexCommAmount?: number | null,
    public articleId?: number | null,
    public toResvNameId?: number | null,
    public roomNts?: number | null,
    public orgArLedDebit?: number | null,
    public closureNo?: number | null,
    public originalResvNameId?: number | null,
    public orgBillNo?: number | null,
    public membershipId?: number | null,
    public installments?: number | null,
    public contractGuestDebit?: number | null,
    public contractGuestCredit?: number | null,
    public contractNetAmount?: number | null,
    public contractGrossAmount?: number | null,
    public postitNo?: number | null,
    public ccTrxFeeAmount?: number | null,
    public changeDue?: number | null,
    public postingSourceNameId?: number | null,
    public bonusCheckId?: number | null,
    public roundLinkTrxno?: number | null,
    public reversePaymentTrxNo?: number | null,
    public electronicVoucherNo?: number | null,
    public thresholdDiversionId?: number | null,
    public thresholdEntityQty?: number | null,
    public trxNoSplit?: number | null,
    public exchDiffTrxNo?: number | null,
    public associatedTrxNo?: number | null,
    public taxRate?: number | null,
    public propChargeId?: number | null,
    public quantity?: number | null,
    public netAmount?: number | null,
    public grossAmount?: number | null,
    public cashierOpeningBalance?: number | null,
    public pricePerUnit?: number | null,
    public trxAmount?: number | null,
    public postedAmount?: number | null,
    public guestAccountCredit?: number | null,
    public exchangeRate?: number | null,
    public guestAccountDebit?: number | null,
    public cashierCredit?: number | null,
    public cashierDebit?: number | null,
    public packageCredit?: number | null,
    public packageDebit?: number | null,
    public depLedCredit?: number | null,
    public depLedDebit?: number | null,
    public revenueAmt?: number | null,
    public arLedCredit?: number | null,
    public arLedDebit?: number | null,
    public euroExchangeRate?: number | null,
    public inhDebit?: number | null,
    public inhCredit?: number | null,
    public packageAllowance?: number | null,
    public parallelGuestCredit?: number | null,
    public parallelGuestDebit?: number | null,
    public parallelNetAmount?: number | null,
    public parallelGrossAmount?: number | null,
    public orgPostedAmount?: number | null,
    public roomNtsEffective?: number | null,
    public paymentSurchargeAmt?: number | null,
    public folioView?: number | null,
    public taxInclusiveYn?: string | null,
    public deferredYn?: string | null,
    public indAdjustmentYn?: string | null,
    public fixedChargesYn?: string | null,
    public taCommissionableYn?: string | null,
    public taxGeneratedYn?: string | null,
    public compressedYn?: string | null,
    public displayYn?: string | null,
    public collAgentPostingYn?: string | null,
    public fiscalTrxCodeType?: string | null,
    public deferredTaxesYn?: string | null,
    public advancedGenerateYn?: string | null,
    public forexType?: string | null,
    public taCommissionNetYn?: string | null,
    public sourceCommissionNetYn?: string | null,
    public settlementFlag?: string | null,
    public accTypeFlag?: string | null,
    public profitLossFlag?: string | null,
    public proformaYn?: string | null,
    public holdYn?: string | null,
    public exchangeDifferenceYn?: string | null,
    public calcPointsYn?: string | null,
    public arChargeTransferYn?: string | null,
    public processed8300Yn?: string | null,
    public asbFlag?: string | null,
    public postitYn?: string | null,
    public autoSettleYn?: string | null,
    public depTaxTransferedYn?: string | null,
    public autoCreditbillYn?: string | null,
    public asbOnlyPostTaxesOnceYn?: string | null,
    public roundFactorYn?: string | null,
    public depPostingFlag?: string | null,
    public correctionYn?: string | null,
    public routedYn?: string | null,
    public upsellChargeYn?: string | null,
    public advanceBillYn?: string | null,
    public advanceBillReversedYn?: string | null,
    public incTaxDeductedYn?: string | null,
    public gpAwardCancelledYn?: string | null,
    public serviceRecoveryAdjustmentYn?: string | null,
    public splitType?: string | null,
    public bucketRedempYn?: string | null,
    public vatOffsetYn?: string | null,
    public forexTaxYn?: string | null,
    public stampDutyYn?: string | null,
    public covers?: string | null,
    public advGenerateAdjustment?: string | null,
    public expInvoiceType?: string | null,
    public folioType?: string | null,
    public orgFolioType?: string | null,
    public invoiceType?: string | null,
    public arState?: string | null,
    public exchangeType?: string | null,
    public recptType?: string | null,
    public roomClass?: string | null,
    public resort?: string | null,
    public tcGroup?: string | null,
    public tcSubgroup?: string | null,
    public trxCode?: string | null,
    public room?: string | null,
    public tclCode1?: string | null,
    public currency?: string | null,
    public ftGeneratedType?: string | null,
    public tclCode2?: string | null,
    public marketCode?: string | null,
    public sourceCode?: string | null,
    public rateCode?: string | null,
    public hotelAcct?: string | null,
    public reasonCode?: string | null,
    public product?: string | null,
    public targetResort?: string | null,
    public nameTaxType?: string | null,
    public taxInvNo?: string | null,
    public approvalCode?: string | null,
    public approvalStatus?: string | null,
    public compLinkTrxCode?: string | null,
    public compTypeCode?: string | null,
    public couponNo?: string | null,
    public originalRoom?: string | null,
    public allowanceType?: string | null,
    public advGenerateTrxCode?: string | null,
    public trxServiceType?: string | null,
    public postingType?: string | null,
    public parallelCurrency?: string | null,
    public contractCurrency?: string | null,
    public fbaCertificateNumber?: string | null,
    public postingRhythm?: string | null,
    public asbTaxFlag?: string | null,
    public packageArrangementCode?: string | null,
    public gpAwardCode?: string | null,
    public gpAwardCancelCode?: string | null,
    public serviceRecoveryDeptCode?: string | null,
    public bucketCode?: string | null,
    public taxRateType?: string | null,
    public chequeNumber?: string | null,
    public passerByName?: string | null,
    public esignedReceiptName?: string | null,
    public remark?: string | null,
    public reference?: string | null,
    public oTrxDesc?: string | null,
    public comments?: string | null,
    public fiscalBillNo?: string | null,
    public extSysResultMsg?: string | null,
    public queueName?: string | null,
    public paymentType?: string | null,
    public ccRefundPosting?: string | null,
    public thresholdEntityType?: string | null,
    public thresholdTreatmentFlag?: string | null,
    public paymentSurchargeType?: string | null,
    public propertyBillPrefix?: string | null,
    public taxElements?: string | null,
    public numberDialed?: string | null,
    public checkFileId?: string | null,
    public extTrxId?: string | null,
    public packageTrxType?: string | null,
    public expOriginalInvoice?: string | null,
    public depositTransactionId?: string | null,
  ) {}
}
