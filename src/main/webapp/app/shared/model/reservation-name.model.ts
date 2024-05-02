export interface IReservationName {
  id?: number;
  resort?: string | null;
  resvNameId?: number | null;
  nameId?: number | null;
  nameUsageType?: string | null;
  contactNameId?: number | null;
  insertDate?: Date | null;
  insertUser?: number | null;
  updateUser?: number | null;
  updateDate?: Date | null;
  resvStatus?: string | null;
  commissionCode?: string | null;
  addressId?: number | null;
  phoneId?: number | null;
  faxYn?: string | null;
  mailYn?: string | null;
  printRateYn?: string | null;
  reportId?: string | null;
  resvNo?: number | null;
  confirmationNo?: string | null;
  beginDate?: Date | null;
  endDate?: Date | null;
  faxId?: number | null;
  emailId?: number | null;
  emailYn?: string | null;
  consumerYn?: string | null;
  creditCardId?: number | null;
  financiallyResponsibleYn?: string | null;
  paymentMethod?: string | null;
  intermediaryYn?: string | null;
  postingAllowedYn?: string | null;
  displayColor?: string | null;
  actualCheckInDate?: Date | null;
  truncActualCheckInDate?: Date | null;
  actualCheckOutDate?: Date | null;
  truncActualCheckOutDate?: Date | null;
  creditLimit?: number | null;
  authorizedBy?: number | null;
  parentResvNameId?: number | null;
  cancellationNo?: string | null;
  cancellationReasonCode?: string | null;
  cancellationReasonDesc?: string | null;
  arrivalTransportType?: string | null;
  arrivalStationCode?: string | null;
  arrivalCarrierCode?: string | null;
  arrivalTransportCode?: string | null;
  arrivalDateTime?: Date | null;
  arrivalEstimateTime?: Date | null;
  arrivalTranportationYn?: string | null;
  arrivalComments?: string | null;
  departureTransportType?: string | null;
  departureStationCode?: string | null;
  departureCarrierCode?: string | null;
  departureTransportCode?: string | null;
  departureDateTime?: Date | null;
  departureEstimateTime?: Date | null;
  departureTransportationYn?: string | null;
  departureComments?: string | null;
  cancellationDate?: Date | null;
  guaranteeCode?: string | null;
  wlReasonDescription?: string | null;
  wlReasonCode?: string | null;
  wlPriority?: string | null;
  doNotMoveRoom?: string | null;
  externalReference?: string | null;
  partyCode?: string | null;
  walkinYn?: string | null;
  originalEndDate?: Date | null;
  approvalAmountCalcMethod?: number | null;
  amountPercent?: number | null;
  nameTaxType?: string | null;
  taxExemptNo?: string | null;
  roomFeatures?: string | null;
  wlTelephoneNo?: string | null;
  videoCheckoutYn?: string | null;
  discountAmt?: number | null;
  discountPrcnt?: number | null;
  discountReasonCode?: string | null;
  commissionPaid?: number | null;
  commissionHoldCode?: string | null;
  truncBeginDate?: Date | null;
  truncEndDate?: Date | null;
  sguestName?: string | null;
  membershipId?: number | null;
  udfc01?: string | null;
  udfc02?: string | null;
  udfc03?: string | null;
  udfc04?: string | null;
  udfc05?: string | null;
  udfc06?: string | null;
  udfc07?: string | null;
  udfc08?: string | null;
  udfc09?: string | null;
  udfc10?: string | null;
  udfc11?: string | null;
  udfc12?: string | null;
  udfc13?: string | null;
  udfc14?: string | null;
  udfc15?: string | null;
  udfc16?: string | null;
  udfc17?: string | null;
  udfc18?: string | null;
  udfc19?: string | null;
  udfc20?: string | null;
  udfc21?: string | null;
  udfc22?: string | null;
  udfc23?: string | null;
  udfc24?: string | null;
  udfc25?: string | null;
  udfc26?: string | null;
  udfc27?: string | null;
  udfc28?: string | null;
  udfc29?: string | null;
  udfc30?: string | null;
  udfc31?: string | null;
  udfc32?: string | null;
  udfc33?: string | null;
  udfc34?: string | null;
  udfc35?: string | null;
  udfc36?: string | null;
  udfc37?: string | null;
  udfc38?: string | null;
  udfc39?: string | null;
  udfc40?: string | null;
  udfn01?: number | null;
  udfn02?: number | null;
  udfn03?: number | null;
  udfn04?: number | null;
  udfn05?: number | null;
  udfn06?: number | null;
  udfn07?: number | null;
  udfn08?: number | null;
  udfn09?: number | null;
  udfn10?: number | null;
  udfn11?: number | null;
  udfn12?: number | null;
  udfn13?: number | null;
  udfn14?: number | null;
  udfn15?: number | null;
  udfn16?: number | null;
  udfn17?: number | null;
  udfn18?: number | null;
  udfn19?: number | null;
  udfn20?: number | null;
  udfn21?: number | null;
  udfn22?: number | null;
  udfn23?: number | null;
  udfn24?: number | null;
  udfn25?: number | null;
  udfn26?: number | null;
  udfn27?: number | null;
  udfn28?: number | null;
  udfn29?: number | null;
  udfn30?: number | null;
  udfn31?: number | null;
  udfn32?: number | null;
  udfn33?: number | null;
  udfn34?: number | null;
  udfn35?: number | null;
  udfn36?: number | null;
  udfn37?: number | null;
  udfn38?: number | null;
  udfn39?: number | null;
  udfn40?: number | null;
  udfd01?: Date | null;
  udfd02?: Date | null;
  udfd03?: Date | null;
  udfd04?: Date | null;
  udfd05?: Date | null;
  udfd06?: Date | null;
  udfd07?: Date | null;
  udfd08?: Date | null;
  udfd09?: Date | null;
  udfd10?: Date | null;
  insertActionInstanceId?: number | null;
  dmlSeqNo?: number | null;
  businessDateCreated?: Date | null;
  turndownYn?: string | null;
  roomInstructions?: string | null;
  roomServiceTime?: string | null;
  eventId?: number | null;
  revenueTypeCode?: string | null;
  hurdle?: number | null;
  hurdleOverride?: string | null;
  rateableValue?: number | null;
  restrictionOverride?: string | null;
  yieldableYn?: string | null;
  sguestFirstname?: string | null;
  guestLastName?: string | null;
  guestFirstName?: string | null;
  guestLastNameSdx?: string | null;
  guestFirstNameSdx?: string | null;
  channel?: string | null;
  shareSeqNo?: number | null;
  guestSignature?: string | null;
  extensionId?: number | null;
  resvContactId?: number | null;
  billingContactId?: number | null;
  resInsertSource?: string | null;
  resInsertSourceType?: string | null;
  masterShare?: string | null;
  registrationCardNo?: string | null;
  tiad?: string | null;
  purposeOfStay?: string | null;
  reinstateDate?: Date | null;
  purgeDate?: Date | null;
  lastSettleDate?: Date | null;
  lastPeriodicFolioDate?: Date | null;
  periodicFolioFreq?: number | null;
  confirmationLegNo?: number | null;
  guestStatus?: string | null;
  guestType?: string | null;
  checkinDuration?: number | null;
  authorizerId?: number | null;
  lastOnlinePrintSeq?: number | null;
  entryPoint?: string | null;
  entryDate?: Date | null;
  pseudoMemType?: string | null;
  pseudoMemTotalPoints?: number | null;
  folioText1?: string | null;
  folioText2?: string | null;
  compTypeCode?: string | null;
  uniCardId?: string | null;
  expCheckinresId?: number | null;
  originalBeginDate?: Date | null;
  ownerFfFlag?: string | null;
  commissionPayoutTo?: string | null;
  preChargingYn?: string | null;
  postChargingYn?: string | null;
  postCoFlag?: string | null;
  folioCloseDate?: Date | null;
  scheduleCheckoutYn?: string | null;
  customReference?: string | null;
  guaranteeCodePreCi?: string | null;
  awardMembershipId?: number | null;
  esignedRegCardName?: string | null;
  statisticalRoomType?: number | null;
  statisticalRateTier?: number | null;
  ymCode?: string | null;
  keyValidUntil?: Date | null;
  preRegisteredYn?: string | null;
  taxRegistrationNo?: number | null;
  visaNumber?: string | null;
  visaIssueDate?: Date | null;
  visaExpirationDate?: Date | null;
  taxNoOfStays?: number | null;
  asbProratedYn?: string | null;
  autoSettleDays?: number | null;
  autoSettleYn?: string | null;
  splitFromResvNameId?: number | null;
  nextDestination?: string | null;
  dateOfArrivalInCountry?: Date | null;
  preArrReviewedDt?: Date | null;
  preArrReviewedUser?: number | null;
  bonusCheckId?: number | null;
  mobileAudioKeyYn?: string | null;
  directBillVerifyResponse?: string | null;
  addresseeNameId?: number | null;
  superSearchIndexText?: string | null;
  autoCheckinYn?: string | null;
  emailFolioYn?: string | null;
  emailAddress?: string | null;
  spgUpgradeConfirmedRoomtype?: string | null;
  spgUpgradeReasonCode?: string | null;
  spgSuiteNightAwardStatus?: string | null;
  spgDiscloseRoomTypeYn?: string | null;
  amenityEligibleYn?: string | null;
  amenityLevelCode?: string | null;
  baseRateCurrencyCode?: string | null;
  baseRateCode?: string | null;
  localBaseRateAmount?: number | null;
  phoneDisplayNameYn?: string | null;
  resortChargeNumber?: string | null;
  mobileChkoutAllowed?: string | null;
  mobileViewFolioAllowed?: string | null;
  hkExpectedServiceTime?: string | null;
  eligibleForUpgradeYn?: string | null;
  beginSystemDateTime?: Date | null;
  mobileCheckinAllowedYn?: string | null;
  quoteId?: string | null;
  manualCheckoutStatus?: string | null;
  mobilePreferredCurrency?: string | null;
  mobileActionAlertIssued?: Date | null;
  externalEfolioYn?: string | null;
  optInBatchFolYn?: string | null;
  folioAddrElementId?: number | null;
  operaEsignedRegCardYn?: string | null;
  resvGuid?: string | null;
  advanceCheckedInYn?: string | null;
  expectedTimeOfReturn?: Date | null;
  etrComments?: string | null;
  optedForCommYn?: string | null;
  creditLimitAutoPayAllowYn?: string | null;
}

export class ReservationName implements IReservationName {
  constructor(
    public id?: number,
    public resort?: string | null,
    public resvNameId?: number | null,
    public nameId?: number | null,
    public nameUsageType?: string | null,
    public contactNameId?: number | null,
    public insertDate?: Date | null,
    public insertUser?: number | null,
    public updateUser?: number | null,
    public updateDate?: Date | null,
    public resvStatus?: string | null,
    public commissionCode?: string | null,
    public addressId?: number | null,
    public phoneId?: number | null,
    public faxYn?: string | null,
    public mailYn?: string | null,
    public printRateYn?: string | null,
    public reportId?: string | null,
    public resvNo?: number | null,
    public confirmationNo?: string | null,
    public beginDate?: Date | null,
    public endDate?: Date | null,
    public faxId?: number | null,
    public emailId?: number | null,
    public emailYn?: string | null,
    public consumerYn?: string | null,
    public creditCardId?: number | null,
    public financiallyResponsibleYn?: string | null,
    public paymentMethod?: string | null,
    public intermediaryYn?: string | null,
    public postingAllowedYn?: string | null,
    public displayColor?: string | null,
    public actualCheckInDate?: Date | null,
    public truncActualCheckInDate?: Date | null,
    public actualCheckOutDate?: Date | null,
    public truncActualCheckOutDate?: Date | null,
    public creditLimit?: number | null,
    public authorizedBy?: number | null,
    public parentResvNameId?: number | null,
    public cancellationNo?: string | null,
    public cancellationReasonCode?: string | null,
    public cancellationReasonDesc?: string | null,
    public arrivalTransportType?: string | null,
    public arrivalStationCode?: string | null,
    public arrivalCarrierCode?: string | null,
    public arrivalTransportCode?: string | null,
    public arrivalDateTime?: Date | null,
    public arrivalEstimateTime?: Date | null,
    public arrivalTranportationYn?: string | null,
    public arrivalComments?: string | null,
    public departureTransportType?: string | null,
    public departureStationCode?: string | null,
    public departureCarrierCode?: string | null,
    public departureTransportCode?: string | null,
    public departureDateTime?: Date | null,
    public departureEstimateTime?: Date | null,
    public departureTransportationYn?: string | null,
    public departureComments?: string | null,
    public cancellationDate?: Date | null,
    public guaranteeCode?: string | null,
    public wlReasonDescription?: string | null,
    public wlReasonCode?: string | null,
    public wlPriority?: string | null,
    public doNotMoveRoom?: string | null,
    public externalReference?: string | null,
    public partyCode?: string | null,
    public walkinYn?: string | null,
    public originalEndDate?: Date | null,
    public approvalAmountCalcMethod?: number | null,
    public amountPercent?: number | null,
    public nameTaxType?: string | null,
    public taxExemptNo?: string | null,
    public roomFeatures?: string | null,
    public wlTelephoneNo?: string | null,
    public videoCheckoutYn?: string | null,
    public discountAmt?: number | null,
    public discountPrcnt?: number | null,
    public discountReasonCode?: string | null,
    public commissionPaid?: number | null,
    public commissionHoldCode?: string | null,
    public truncBeginDate?: Date | null,
    public truncEndDate?: Date | null,
    public sguestName?: string | null,
    public membershipId?: number | null,
    public udfc01?: string | null,
    public udfc02?: string | null,
    public udfc03?: string | null,
    public udfc04?: string | null,
    public udfc05?: string | null,
    public udfc06?: string | null,
    public udfc07?: string | null,
    public udfc08?: string | null,
    public udfc09?: string | null,
    public udfc10?: string | null,
    public udfc11?: string | null,
    public udfc12?: string | null,
    public udfc13?: string | null,
    public udfc14?: string | null,
    public udfc15?: string | null,
    public udfc16?: string | null,
    public udfc17?: string | null,
    public udfc18?: string | null,
    public udfc19?: string | null,
    public udfc20?: string | null,
    public udfc21?: string | null,
    public udfc22?: string | null,
    public udfc23?: string | null,
    public udfc24?: string | null,
    public udfc25?: string | null,
    public udfc26?: string | null,
    public udfc27?: string | null,
    public udfc28?: string | null,
    public udfc29?: string | null,
    public udfc30?: string | null,
    public udfc31?: string | null,
    public udfc32?: string | null,
    public udfc33?: string | null,
    public udfc34?: string | null,
    public udfc35?: string | null,
    public udfc36?: string | null,
    public udfc37?: string | null,
    public udfc38?: string | null,
    public udfc39?: string | null,
    public udfc40?: string | null,
    public udfn01?: number | null,
    public udfn02?: number | null,
    public udfn03?: number | null,
    public udfn04?: number | null,
    public udfn05?: number | null,
    public udfn06?: number | null,
    public udfn07?: number | null,
    public udfn08?: number | null,
    public udfn09?: number | null,
    public udfn10?: number | null,
    public udfn11?: number | null,
    public udfn12?: number | null,
    public udfn13?: number | null,
    public udfn14?: number | null,
    public udfn15?: number | null,
    public udfn16?: number | null,
    public udfn17?: number | null,
    public udfn18?: number | null,
    public udfn19?: number | null,
    public udfn20?: number | null,
    public udfn21?: number | null,
    public udfn22?: number | null,
    public udfn23?: number | null,
    public udfn24?: number | null,
    public udfn25?: number | null,
    public udfn26?: number | null,
    public udfn27?: number | null,
    public udfn28?: number | null,
    public udfn29?: number | null,
    public udfn30?: number | null,
    public udfn31?: number | null,
    public udfn32?: number | null,
    public udfn33?: number | null,
    public udfn34?: number | null,
    public udfn35?: number | null,
    public udfn36?: number | null,
    public udfn37?: number | null,
    public udfn38?: number | null,
    public udfn39?: number | null,
    public udfn40?: number | null,
    public udfd01?: Date | null,
    public udfd02?: Date | null,
    public udfd03?: Date | null,
    public udfd04?: Date | null,
    public udfd05?: Date | null,
    public udfd06?: Date | null,
    public udfd07?: Date | null,
    public udfd08?: Date | null,
    public udfd09?: Date | null,
    public udfd10?: Date | null,
    public insertActionInstanceId?: number | null,
    public dmlSeqNo?: number | null,
    public businessDateCreated?: Date | null,
    public turndownYn?: string | null,
    public roomInstructions?: string | null,
    public roomServiceTime?: string | null,
    public eventId?: number | null,
    public revenueTypeCode?: string | null,
    public hurdle?: number | null,
    public hurdleOverride?: string | null,
    public rateableValue?: number | null,
    public restrictionOverride?: string | null,
    public yieldableYn?: string | null,
    public sguestFirstname?: string | null,
    public guestLastName?: string | null,
    public guestFirstName?: string | null,
    public guestLastNameSdx?: string | null,
    public guestFirstNameSdx?: string | null,
    public channel?: string | null,
    public shareSeqNo?: number | null,
    public guestSignature?: string | null,
    public extensionId?: number | null,
    public resvContactId?: number | null,
    public billingContactId?: number | null,
    public resInsertSource?: string | null,
    public resInsertSourceType?: string | null,
    public masterShare?: string | null,
    public registrationCardNo?: string | null,
    public tiad?: string | null,
    public purposeOfStay?: string | null,
    public reinstateDate?: Date | null,
    public purgeDate?: Date | null,
    public lastSettleDate?: Date | null,
    public lastPeriodicFolioDate?: Date | null,
    public periodicFolioFreq?: number | null,
    public confirmationLegNo?: number | null,
    public guestStatus?: string | null,
    public guestType?: string | null,
    public checkinDuration?: number | null,
    public authorizerId?: number | null,
    public lastOnlinePrintSeq?: number | null,
    public entryPoint?: string | null,
    public entryDate?: Date | null,
    public pseudoMemType?: string | null,
    public pseudoMemTotalPoints?: number | null,
    public folioText1?: string | null,
    public folioText2?: string | null,
    public compTypeCode?: string | null,
    public uniCardId?: string | null,
    public expCheckinresId?: number | null,
    public originalBeginDate?: Date | null,
    public ownerFfFlag?: string | null,
    public commissionPayoutTo?: string | null,
    public preChargingYn?: string | null,
    public postChargingYn?: string | null,
    public postCoFlag?: string | null,
    public folioCloseDate?: Date | null,
    public scheduleCheckoutYn?: string | null,
    public customReference?: string | null,
    public guaranteeCodePreCi?: string | null,
    public awardMembershipId?: number | null,
    public esignedRegCardName?: string | null,
    public statisticalRoomType?: number | null,
    public statisticalRateTier?: number | null,
    public ymCode?: string | null,
    public keyValidUntil?: Date | null,
    public preRegisteredYn?: string | null,
    public taxRegistrationNo?: number | null,
    public visaNumber?: string | null,
    public visaIssueDate?: Date | null,
    public visaExpirationDate?: Date | null,
    public taxNoOfStays?: number | null,
    public asbProratedYn?: string | null,
    public autoSettleDays?: number | null,
    public autoSettleYn?: string | null,
    public splitFromResvNameId?: number | null,
    public nextDestination?: string | null,
    public dateOfArrivalInCountry?: Date | null,
    public preArrReviewedDt?: Date | null,
    public preArrReviewedUser?: number | null,
    public bonusCheckId?: number | null,
    public mobileAudioKeyYn?: string | null,
    public directBillVerifyResponse?: string | null,
    public addresseeNameId?: number | null,
    public superSearchIndexText?: string | null,
    public autoCheckinYn?: string | null,
    public emailFolioYn?: string | null,
    public emailAddress?: string | null,
    public spgUpgradeConfirmedRoomtype?: string | null,
    public spgUpgradeReasonCode?: string | null,
    public spgSuiteNightAwardStatus?: string | null,
    public spgDiscloseRoomTypeYn?: string | null,
    public amenityEligibleYn?: string | null,
    public amenityLevelCode?: string | null,
    public baseRateCurrencyCode?: string | null,
    public baseRateCode?: string | null,
    public localBaseRateAmount?: number | null,
    public phoneDisplayNameYn?: string | null,
    public resortChargeNumber?: string | null,
    public mobileChkoutAllowed?: string | null,
    public mobileViewFolioAllowed?: string | null,
    public hkExpectedServiceTime?: string | null,
    public eligibleForUpgradeYn?: string | null,
    public beginSystemDateTime?: Date | null,
    public mobileCheckinAllowedYn?: string | null,
    public quoteId?: string | null,
    public manualCheckoutStatus?: string | null,
    public mobilePreferredCurrency?: string | null,
    public mobileActionAlertIssued?: Date | null,
    public externalEfolioYn?: string | null,
    public optInBatchFolYn?: string | null,
    public folioAddrElementId?: number | null,
    public operaEsignedRegCardYn?: string | null,
    public resvGuid?: string | null,
    public advanceCheckedInYn?: string | null,
    public expectedTimeOfReturn?: Date | null,
    public etrComments?: string | null,
    public optedForCommYn?: string | null,
    public creditLimitAutoPayAllowYn?: string | null,
  ) {}
}
