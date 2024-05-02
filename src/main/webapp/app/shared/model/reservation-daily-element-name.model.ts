export interface IReservationDailyElementName {
  id?: number;
  resort?: string | null;
  resvNameId?: number | null;
  reservationDate?: Date | null;
  resvDailyElSeq?: number | null;
  travelAgentId?: number | null;
  companyId?: number | null;
  sourceId?: number | null;
  groupId?: number | null;
  sharePaymentType?: string | null;
  shareAmount?: number | null;
  sharePrcnt?: number | null;
  adults?: number | null;
  children?: number | null;
  discountAmt?: number | null;
  discountPrcnt?: number | null;
  discountReasonCode?: string | null;
  fixedRateYn?: string | null;
  baseRateAmount?: number | null;
  autoPostAmount?: number | null;
  sharePriority?: number | null;
  insertUser?: number | null;
  insertDate?: Date | null;
  updateUser?: number | null;
  updateDate?: Date | null;
  lastShareCalculation?: string | null;
  insertActionInstanceId?: number | null;
  dmlSeqNo?: number | null;
  netRoomAmt?: number | null;
  roomTax?: number | null;
  pkgAmt?: number | null;
  pkgTax?: number | null;
  grossRateAmt?: number | null;
  adultsTaxFree?: number | null;
  childrenTaxFree?: number | null;
  children1?: number | null;
  children2?: number | null;
  children3?: number | null;
  rateCode?: string | null;
  currencyCode?: string | null;
  exchangePostingType?: string | null;
  membershipPoints?: number | null;
  children4?: number | null;
  children5?: number | null;
  commissionCode?: string | null;
  awardCode1?: string | null;
  awardCode2?: string | null;
  awardCode3?: string | null;
  awardCode4?: string | null;
  awardCode5?: string | null;
  awardVoucher1?: string | null;
  awardVoucher2?: string | null;
  awardVoucher3?: string | null;
  awardVoucher4?: string | null;
  awardVoucher5?: string | null;
  doNotMoveYn?: string | null;
  awardCode?: string | null;
  points?: number | null;
  upsellCharge?: number | null;
  pointsEligibilityCode?: string | null;
  commissionPaid?: number | null;
  resvContactId?: number | null;
  billingContactId?: number | null;
  shareAmountOriginal?: number | null;
  referralYn?: string | null;
  bxgyDiscountYn?: string | null;
  commissionableYn?: string | null;
  basedOnRule?: string | null;
}

export class ReservationDailyElementName implements IReservationDailyElementName {
  constructor(
    public id?: number,
    public resort?: string | null,
    public resvNameId?: number | null,
    public reservationDate?: Date | null,
    public resvDailyElSeq?: number | null,
    public travelAgentId?: number | null,
    public companyId?: number | null,
    public sourceId?: number | null,
    public groupId?: number | null,
    public sharePaymentType?: string | null,
    public shareAmount?: number | null,
    public sharePrcnt?: number | null,
    public adults?: number | null,
    public children?: number | null,
    public discountAmt?: number | null,
    public discountPrcnt?: number | null,
    public discountReasonCode?: string | null,
    public fixedRateYn?: string | null,
    public baseRateAmount?: number | null,
    public autoPostAmount?: number | null,
    public sharePriority?: number | null,
    public insertUser?: number | null,
    public insertDate?: Date | null,
    public updateUser?: number | null,
    public updateDate?: Date | null,
    public lastShareCalculation?: string | null,
    public insertActionInstanceId?: number | null,
    public dmlSeqNo?: number | null,
    public netRoomAmt?: number | null,
    public roomTax?: number | null,
    public pkgAmt?: number | null,
    public pkgTax?: number | null,
    public grossRateAmt?: number | null,
    public adultsTaxFree?: number | null,
    public childrenTaxFree?: number | null,
    public children1?: number | null,
    public children2?: number | null,
    public children3?: number | null,
    public rateCode?: string | null,
    public currencyCode?: string | null,
    public exchangePostingType?: string | null,
    public membershipPoints?: number | null,
    public children4?: number | null,
    public children5?: number | null,
    public commissionCode?: string | null,
    public awardCode1?: string | null,
    public awardCode2?: string | null,
    public awardCode3?: string | null,
    public awardCode4?: string | null,
    public awardCode5?: string | null,
    public awardVoucher1?: string | null,
    public awardVoucher2?: string | null,
    public awardVoucher3?: string | null,
    public awardVoucher4?: string | null,
    public awardVoucher5?: string | null,
    public doNotMoveYn?: string | null,
    public awardCode?: string | null,
    public points?: number | null,
    public upsellCharge?: number | null,
    public pointsEligibilityCode?: string | null,
    public commissionPaid?: number | null,
    public resvContactId?: number | null,
    public billingContactId?: number | null,
    public shareAmountOriginal?: number | null,
    public referralYn?: string | null,
    public bxgyDiscountYn?: string | null,
    public commissionableYn?: string | null,
    public basedOnRule?: string | null,
  ) {}
}
