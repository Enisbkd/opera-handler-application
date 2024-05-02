export interface IResort {
  id?: string;
  resort?: string | null;
  beginDate?: Date | null;
  checkInTime?: Date | null;
  checkOutTime?: Date | null;
  videoCoStart?: Date | null;
  videoCoStop?: Date | null;
  insertDate?: Date | null;
  updateDate?: Date | null;
  expiryDate?: Date | null;
  endDate?: Date | null;
  fiscalStartDate?: Date | null;
  fiscalEndDate?: Date | null;
  reconcileDate?: Date | null;
  paymentDate?: Date | null;
  keepAvailability?: number | null;
  budgetMonth?: number | null;
  saveProfiles?: number | null;
  longStayControl?: number | null;
  creditLimit?: number | null;
  numberRooms?: number | null;
  numberFloors?: number | null;
  numberBeds?: number | null;
  rhythmSheets?: number | null;
  rhythmTowels?: number | null;
  warningAmount?: number | null;
  decimalPlaces?: number | null;
  font?: number | null;
  copies?: number | null;
  defaultFolioStyle?: number | null;
  individualRoomWarning?: number | null;
  groupRoomWarning?: number | null;
  agingLevel1?: number | null;
  agingLevel2?: number | null;
  agingLevel3?: number | null;
  agingLevel4?: number | null;
  agingLevel5?: number | null;
  zeroInvPurDays?: number | null;
  minDaysBet2ReminderLetter?: number | null;
  insertUser?: number | null;
  updateUser?: number | null;
  currencyDecimals?: number | null;
  nameIdLink?: number | null;
  sglRate1?: number | null;
  sglRate2?: number | null;
  dblRate1?: number | null;
  dblRate2?: number | null;
  tplRate1?: number | null;
  tplRate2?: number | null;
  suiRate1?: number | null;
  suiRate2?: number | null;
  meetSpace?: number | null;
  imgHotelId?: number | null;
  imgDirectionId?: number | null;
  imgMapId?: number | null;
  scriptId?: number | null;
  comNameXrefId?: number | null;
  pathId?: number | null;
  xresortNumber?: number | null;
  maxCreditDays?: number | null;
  currencyDivisor?: number | null;
  latitude?: number | null;
  longitude?: number | null;
  qtySingleRooms?: number | null;
  qtyDoubleRooms?: number | null;
  qtyTwinRooms?: number | null;
  qtySuites?: number | null;
  qtyGuestRoomFloors?: number | null;
  qtyGuestElevators?: number | null;
  qtyNonSmokingRooms?: number | null;
  qtyConnectingRooms?: number | null;
  qtyHandicappedRooms?: number | null;
  qtyFamilyRooms?: number | null;
  maxAdultsFamilyRoom?: number | null;
  maxChildrenFamilyRoom?: number | null;
  restaurant?: number | null;
  meetRooms?: number | null;
  totRooms?: number | null;
  brSeats?: number | null;
  meetSeats?: number | null;
  maxNoNights?: number | null;
  awardsTimeout?: number | null;
  guestLookupTimeout?: number | null;
  wakeUpDelay?: number | null;
  maxOccupancy?: number | null;
  inactiveDaysForGuestProfil?: number | null;
  perReservationRoomLimit?: number | null;
  licRoomInfo?: string | null;
  thousandSeparator?: string | null;
  dateSeparator?: string | null;
  arAcctNoMandYn?: string | null;
  exchangePostingType?: string | null;
  inventoryYn?: string | null;
  allowLoginYn?: string | null;
  accessCode?: string | null;
  disableLoginYn?: string | null;
  intTaxIncludedYn?: string | null;
  downloadRestYn?: string | null;
  translateMulticharYn?: string | null;
  externalScYn?: string | null;
  sendLeadAsBookingYn?: string | null;
  mbsSupportedYn?: string | null;
  quotedCurrency?: string | null;
  comMethod?: string | null;
  email?: string | null;
  genmgr?: string | null;
  dirsales?: string | null;
  leadsend?: string | null;
  airport?: string | null;
  comAddress?: string | null;
  season1?: string | null;
  season2?: string | null;
  season3?: string | null;
  season4?: string | null;
  season5?: string | null;
  floorNumExecutiveFloor?: string | null;
  crsResort?: string | null;
  postCode?: string | null;
  defaultReservationType?: string | null;
  block?: string | null;
  currencySymbol?: string | null;
  sourceCommission?: string | null;
  taCommission?: string | null;
  baseLanguage?: string | null;
  folioLanguage1?: string | null;
  folioLanguage2?: string | null;
  folioLanguage3?: string | null;
  folioLanguage4?: string | null;
  packageProfit?: string | null;
  packageLoss?: string | null;
  decimalSeparator?: string | null;
  shortDateFormat?: string | null;
  longDateFormat?: string | null;
  passerbySource?: string | null;
  passerbyMarket?: string | null;
  arCompany?: string | null;
  arAgent?: string | null;
  arGroups?: string | null;
  arIndividuals?: string | null;
  arAcctNoFormat?: string | null;
  allowancePeriodAdj?: string | null;
  currencyCode?: string | null;
  turnawayCode?: string | null;
  summCurrencyCode?: string | null;
  defaultPropertyAddress?: string | null;
  defaultGuestAddress?: string | null;
  licenseCode?: string | null;
  timeFormat?: string | null;
  chainCode?: string | null;
  resortType?: string | null;
  hotelType?: string | null;
  ownership?: string | null;
  arBalTrxCode?: string | null;
  arCreditTrxCode?: string | null;
  arSettleCode?: string | null;
  cashShiftDrop?: string | null;
  checkExgPaidout?: string | null;
  checkShiftDrop?: string | null;
  checkTrxcode?: string | null;
  currencyExgPaidout?: string | null;
  depositLedTrxCode?: string | null;
  fiscalPeriodType?: string | null;
  defaultCommissionPercentage?: string | null;
  defaultPrepaidComm?: string | null;
  defaultTrxCommCode?: string | null;
  configurationMode?: string | null;
  weekendDays?: string | null;
  defaultGroupsRateCode?: string | null;
  defaultPostingRoom?: string | null;
  dfltPkgTranCode?: string | null;
  dfltTranCodeRateCode?: string | null;
  defaultRateCode?: string | null;
  croCode?: string | null;
  flowCode?: string | null;
  extPropertyCode?: string | null;
  opusCurrencyCode?: string | null;
  destinationId?: string | null;
  flags?: string | null;
  touristNumber?: string | null;
  cateringCurrencyCode?: string | null;
  defaultRatecodeRack?: string | null;
  defaultRatecodePcr?: string | null;
  fnsTier?: string | null;
  brandCode?: string | null;
  webaddress?: string | null;
  vatId?: string | null;
  street?: string | null;
  hotelFc?: string | null;
  meetingFc?: string | null;
  arTypewriter?: string | null;
  fileTransferFormat?: string | null;
  confirmRegcardPrinter?: string | null;
  directions?: string | null;
  propinfoUrl?: string | null;
  roomAmenity?: string | null;
  shopDescription?: string | null;
  propPicUrl?: string | null;
  propMapUrl?: string | null;
  extExpFileLocation?: string | null;
  curtainColor?: string | null;
  countryCode?: string | null;
  state?: string | null;
  dateForAging?: string | null;
  regionCode?: string | null;
  city?: string | null;
  telephone?: string | null;
  fax?: string | null;
  tollfree?: string | null;
  defaultPrinter?: string | null;
  videocheckoutPrinter?: string | null;
  companyAddressType?: string | null;
  companyPhoneType?: string | null;
  defaultFaxType?: string | null;
  defaultMembershipType?: string | null;
  individualAddressType?: string | null;
  individualPhoneType?: string | null;
  notes?: string | null;
  blackoutPeriodNotes?: string | null;
  sglNum?: string | null;
  dblNum?: string | null;
  tplNum?: string | null;
  suiNum?: string | null;
  airportDistance?: string | null;
  airportTime?: string | null;
  brArea?: string | null;
  name?: string | null;
  legalOwner?: string | null;
  hotelId?: string | null;
  faxNoFormat?: string | null;
  telephoneNoFormat?: string | null;
  localCurrencyFormat?: string | null;
  dutyManagerPager?: string | null;
  defaultRegistrationCard?: string | null;
  nightAuditCashierId?: string | null;
  hotelCode?: string | null;
  path?: string | null;
  timezoneRegion?: string | null;
  cateringCurrencyFormat?: string | null;
  expHotelCode?: string | null;
}

export class Resort implements IResort {
  constructor(
    public id?: string,
    public resort?: string | null,
    public beginDate?: Date | null,
    public checkInTime?: Date | null,
    public checkOutTime?: Date | null,
    public videoCoStart?: Date | null,
    public videoCoStop?: Date | null,
    public insertDate?: Date | null,
    public updateDate?: Date | null,
    public expiryDate?: Date | null,
    public endDate?: Date | null,
    public fiscalStartDate?: Date | null,
    public fiscalEndDate?: Date | null,
    public reconcileDate?: Date | null,
    public paymentDate?: Date | null,
    public keepAvailability?: number | null,
    public budgetMonth?: number | null,
    public saveProfiles?: number | null,
    public longStayControl?: number | null,
    public creditLimit?: number | null,
    public numberRooms?: number | null,
    public numberFloors?: number | null,
    public numberBeds?: number | null,
    public rhythmSheets?: number | null,
    public rhythmTowels?: number | null,
    public warningAmount?: number | null,
    public decimalPlaces?: number | null,
    public font?: number | null,
    public copies?: number | null,
    public defaultFolioStyle?: number | null,
    public individualRoomWarning?: number | null,
    public groupRoomWarning?: number | null,
    public agingLevel1?: number | null,
    public agingLevel2?: number | null,
    public agingLevel3?: number | null,
    public agingLevel4?: number | null,
    public agingLevel5?: number | null,
    public zeroInvPurDays?: number | null,
    public minDaysBet2ReminderLetter?: number | null,
    public insertUser?: number | null,
    public updateUser?: number | null,
    public currencyDecimals?: number | null,
    public nameIdLink?: number | null,
    public sglRate1?: number | null,
    public sglRate2?: number | null,
    public dblRate1?: number | null,
    public dblRate2?: number | null,
    public tplRate1?: number | null,
    public tplRate2?: number | null,
    public suiRate1?: number | null,
    public suiRate2?: number | null,
    public meetSpace?: number | null,
    public imgHotelId?: number | null,
    public imgDirectionId?: number | null,
    public imgMapId?: number | null,
    public scriptId?: number | null,
    public comNameXrefId?: number | null,
    public pathId?: number | null,
    public xresortNumber?: number | null,
    public maxCreditDays?: number | null,
    public currencyDivisor?: number | null,
    public latitude?: number | null,
    public longitude?: number | null,
    public qtySingleRooms?: number | null,
    public qtyDoubleRooms?: number | null,
    public qtyTwinRooms?: number | null,
    public qtySuites?: number | null,
    public qtyGuestRoomFloors?: number | null,
    public qtyGuestElevators?: number | null,
    public qtyNonSmokingRooms?: number | null,
    public qtyConnectingRooms?: number | null,
    public qtyHandicappedRooms?: number | null,
    public qtyFamilyRooms?: number | null,
    public maxAdultsFamilyRoom?: number | null,
    public maxChildrenFamilyRoom?: number | null,
    public restaurant?: number | null,
    public meetRooms?: number | null,
    public totRooms?: number | null,
    public brSeats?: number | null,
    public meetSeats?: number | null,
    public maxNoNights?: number | null,
    public awardsTimeout?: number | null,
    public guestLookupTimeout?: number | null,
    public wakeUpDelay?: number | null,
    public maxOccupancy?: number | null,
    public inactiveDaysForGuestProfil?: number | null,
    public perReservationRoomLimit?: number | null,
    public licRoomInfo?: string | null,
    public thousandSeparator?: string | null,
    public dateSeparator?: string | null,
    public arAcctNoMandYn?: string | null,
    public exchangePostingType?: string | null,
    public inventoryYn?: string | null,
    public allowLoginYn?: string | null,
    public accessCode?: string | null,
    public disableLoginYn?: string | null,
    public intTaxIncludedYn?: string | null,
    public downloadRestYn?: string | null,
    public translateMulticharYn?: string | null,
    public externalScYn?: string | null,
    public sendLeadAsBookingYn?: string | null,
    public mbsSupportedYn?: string | null,
    public quotedCurrency?: string | null,
    public comMethod?: string | null,
    public email?: string | null,
    public genmgr?: string | null,
    public dirsales?: string | null,
    public leadsend?: string | null,
    public airport?: string | null,
    public comAddress?: string | null,
    public season1?: string | null,
    public season2?: string | null,
    public season3?: string | null,
    public season4?: string | null,
    public season5?: string | null,
    public floorNumExecutiveFloor?: string | null,
    public crsResort?: string | null,
    public postCode?: string | null,
    public defaultReservationType?: string | null,
    public block?: string | null,
    public currencySymbol?: string | null,
    public sourceCommission?: string | null,
    public taCommission?: string | null,
    public baseLanguage?: string | null,
    public folioLanguage1?: string | null,
    public folioLanguage2?: string | null,
    public folioLanguage3?: string | null,
    public folioLanguage4?: string | null,
    public packageProfit?: string | null,
    public packageLoss?: string | null,
    public decimalSeparator?: string | null,
    public shortDateFormat?: string | null,
    public longDateFormat?: string | null,
    public passerbySource?: string | null,
    public passerbyMarket?: string | null,
    public arCompany?: string | null,
    public arAgent?: string | null,
    public arGroups?: string | null,
    public arIndividuals?: string | null,
    public arAcctNoFormat?: string | null,
    public allowancePeriodAdj?: string | null,
    public currencyCode?: string | null,
    public turnawayCode?: string | null,
    public summCurrencyCode?: string | null,
    public defaultPropertyAddress?: string | null,
    public defaultGuestAddress?: string | null,
    public licenseCode?: string | null,
    public timeFormat?: string | null,
    public chainCode?: string | null,
    public resortType?: string | null,
    public hotelType?: string | null,
    public ownership?: string | null,
    public arBalTrxCode?: string | null,
    public arCreditTrxCode?: string | null,
    public arSettleCode?: string | null,
    public cashShiftDrop?: string | null,
    public checkExgPaidout?: string | null,
    public checkShiftDrop?: string | null,
    public checkTrxcode?: string | null,
    public currencyExgPaidout?: string | null,
    public depositLedTrxCode?: string | null,
    public fiscalPeriodType?: string | null,
    public defaultCommissionPercentage?: string | null,
    public defaultPrepaidComm?: string | null,
    public defaultTrxCommCode?: string | null,
    public configurationMode?: string | null,
    public weekendDays?: string | null,
    public defaultGroupsRateCode?: string | null,
    public defaultPostingRoom?: string | null,
    public dfltPkgTranCode?: string | null,
    public dfltTranCodeRateCode?: string | null,
    public defaultRateCode?: string | null,
    public croCode?: string | null,
    public flowCode?: string | null,
    public extPropertyCode?: string | null,
    public opusCurrencyCode?: string | null,
    public destinationId?: string | null,
    public flags?: string | null,
    public touristNumber?: string | null,
    public cateringCurrencyCode?: string | null,
    public defaultRatecodeRack?: string | null,
    public defaultRatecodePcr?: string | null,
    public fnsTier?: string | null,
    public brandCode?: string | null,
    public webaddress?: string | null,
    public vatId?: string | null,
    public street?: string | null,
    public hotelFc?: string | null,
    public meetingFc?: string | null,
    public arTypewriter?: string | null,
    public fileTransferFormat?: string | null,
    public confirmRegcardPrinter?: string | null,
    public directions?: string | null,
    public propinfoUrl?: string | null,
    public roomAmenity?: string | null,
    public shopDescription?: string | null,
    public propPicUrl?: string | null,
    public propMapUrl?: string | null,
    public extExpFileLocation?: string | null,
    public curtainColor?: string | null,
    public countryCode?: string | null,
    public state?: string | null,
    public dateForAging?: string | null,
    public regionCode?: string | null,
    public city?: string | null,
    public telephone?: string | null,
    public fax?: string | null,
    public tollfree?: string | null,
    public defaultPrinter?: string | null,
    public videocheckoutPrinter?: string | null,
    public companyAddressType?: string | null,
    public companyPhoneType?: string | null,
    public defaultFaxType?: string | null,
    public defaultMembershipType?: string | null,
    public individualAddressType?: string | null,
    public individualPhoneType?: string | null,
    public notes?: string | null,
    public blackoutPeriodNotes?: string | null,
    public sglNum?: string | null,
    public dblNum?: string | null,
    public tplNum?: string | null,
    public suiNum?: string | null,
    public airportDistance?: string | null,
    public airportTime?: string | null,
    public brArea?: string | null,
    public name?: string | null,
    public legalOwner?: string | null,
    public hotelId?: string | null,
    public faxNoFormat?: string | null,
    public telephoneNoFormat?: string | null,
    public localCurrencyFormat?: string | null,
    public dutyManagerPager?: string | null,
    public defaultRegistrationCard?: string | null,
    public nightAuditCashierId?: string | null,
    public hotelCode?: string | null,
    public path?: string | null,
    public timezoneRegion?: string | null,
    public cateringCurrencyFormat?: string | null,
    public expHotelCode?: string | null,
  ) {}
}
