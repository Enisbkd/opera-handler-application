export interface IReservationStatDaily {
  id?: number;
  resort?: string | null;
  businessDate?: Date | null;
  nameId?: number | null;
  rateCode?: string | null;
  sourceCode?: string | null;
  marketCode?: string | null;
  roomCategory?: string | null;
  companyId?: number | null;
  agentId?: number | null;
  groupId?: number | null;
  sourceProfId?: number | null;
  resvStatus?: string | null;
  truncBeginDate?: Date | null;
  truncEndDate?: Date | null;
  resvNameId?: number | null;
  quantity?: number | null;
  physicalQuantity?: number | null;
  dueOutYn?: string | null;
  roomResvStatus?: string | null;
  adults?: number | null;
  children?: number | null;
  roomAdults?: number | null;
  roomChildren?: number | null;
  primaryYn?: number | null;
  allotmentHeaderId?: number | null;
  roomRevenue?: number | null;
  foodRevenue?: number | null;
  packageRoomRevenue?: number | null;
  packageFoodRevenue?: number | null;
  totalRoomTax?: number | null;
  totalFoodTax?: number | null;
  totalPackageRevenue?: number | null;
  totalRevenue?: number | null;
  totalTax?: number | null;
  insertDate?: Date | null;
  originalEndDate?: Date | null;
  walkinYn?: string | null;
  reservationDate?: Date | null;
  roomClass?: string | null;
  vipStatus?: string | null;
  cancellationDate?: Date | null;
  birthDate?: Date | null;
  room?: string | null;
  membershipId?: number | null;
  contactId?: number | null;
  rateCategory?: string | null;
  marketMainGroup?: string | null;
  sourceMainGroup?: string | null;
  channel?: string | null;
  country?: string | null;
  regionCode?: string | null;
  nationality?: string | null;
  psuedoRoomYn?: string | null;
  adultsTaxFree?: number | null;
  childrenTaxFree?: number | null;
  stayRooms?: number | null;
  stayPersons?: number | null;
  stayAdults?: number | null;
  stayChildren?: number | null;
  arrRooms?: number | null;
  arrPersons?: number | null;
  depRooms?: number | null;
  depPersons?: number | null;
  dayUseRooms?: number | null;
  dayUsePersons?: number | null;
  cancelledRooms?: number | null;
  cancelledPersons?: number | null;
  noShowRooms?: number | null;
  noShowPersons?: number | null;
  singleOccupancy?: number | null;
  multipleOccupancy?: number | null;
  cribs?: number | null;
  extraBeds?: number | null;
  otherRevenue?: number | null;
  packageOtherRevenue?: number | null;
  totalOtherTax?: number | null;
  countryMainGroup?: string | null;
  state?: string | null;
  fiscalRegionCode?: string | null;
  nonRevenue?: number | null;
  packageNonRevenue?: number | null;
  totalNonRevenueTax?: number | null;
  prRoomRevenue?: number | null;
  prFoodRevenue?: number | null;
  prPackageRoomRevenue?: number | null;
  prPackageFoodRevenue?: number | null;
  prTotalRoomTax?: number | null;
  prTotalFoodTax?: number | null;
  prTotalPackageRevenue?: number | null;
  prTotalRevenue?: number | null;
  prTotalTax?: number | null;
  prOtherRevenue?: number | null;
  prPackageOtherRevenue?: number | null;
  prTotalOtherTax?: number | null;
  prNonRevenue?: number | null;
  prPackageNonRevenue?: number | null;
  prTotalNonRevenueTax?: number | null;
  nights?: number | null;
  noOfStays?: number | null;
  reservationNights?: number | null;
  reservationArrivals?: number | null;
  reservationNoOfStays?: number | null;
  dayUseReservations?: number | null;
  cancelledReservations?: number | null;
  noShowReservations?: number | null;
  city?: string | null;
  zipCode?: string | null;
  district?: string | null;
  cashRoomNts?: number | null;
  compRoomNts?: number | null;
  cashRoomRevenue?: number | null;
  compRoomRevenue?: number | null;
  resInsertSource?: string | null;
  resInsertSourceType?: string | null;
  children1?: number | null;
  children2?: number | null;
  children3?: number | null;
  children4?: number | null;
  children5?: number | null;
  ffMembershipType?: string | null;
  fgMembershipType?: string | null;
  promotionCode?: string | null;
  ownerFfFlag?: string | null;
  ownerRentalFlag?: string | null;
  centralCurrencyCode?: string | null;
  centralExchangeRate?: number | null;
  bookedRoomCategory?: string | null;
  businessDateCreated?: Date | null;
  rateAmount?: number | null;
  parentCompanyId?: number | null;
  houseUseYn?: string | null;
  complimentaryYn?: string | null;
  biResvNameId?: number | null;
  advFoodRevenue?: number | null;
  advNonRevenue?: number | null;
  advOtherRevenue?: number | null;
  advRoomRevenue?: number | null;
  advTotalFoodTax?: number | null;
  advTotalNonRevenueTax?: number | null;
  advTotalOtherTax?: number | null;
  advTotalRevenue?: number | null;
  advTotalRoomTax?: number | null;
  advTotalTax?: number | null;
  prAdvFoodRevenue?: number | null;
  prAdvNonRevenue?: number | null;
  prAdvOtherRevenue?: number | null;
  prAdvRoomRevenue?: number | null;
  prAdvTotalFoodTax?: number | null;
  prAdvTotalNonRevenueTax?: number | null;
  prAdvTotalOtherTax?: number | null;
  prAdvTotalRevenue?: number | null;
  prAdvTotalRoomTax?: number | null;
  prAdvTotalTax?: number | null;
  upsoldRevenue?: number | null;
  flgdRoomRevenue?: number | null;
  flgdFoodRevenue?: number | null;
  flgdNonRevenue?: number | null;
  flgdOtherRevenue?: number | null;
  flgdTotalRoomTax?: number | null;
  flgdTotalFoodTax?: number | null;
  flgdTotalNonRevenueTax?: number | null;
  flgdTotalOtherTax?: number | null;
  flgdTotalRevenue?: number | null;
  flgdTotalTax?: number | null;
  contactYn?: string | null;
  extendedStayTier?: number | null;
  rsAdvTotalRevenue?: number | null;
  rsAdvRoomRevenue?: number | null;
  rsAdvFoodRevenue?: number | null;
  rsAdvOtherRevenue?: number | null;
  rsAdvNonRevenue?: number | null;
  rsAdvTotalTax?: number | null;
  rsAdvRoomTax?: number | null;
  rsAdvFoodTax?: number | null;
  rsAdvOtherTax?: number | null;
  rsAdvNonRevenueTax?: number | null;
  updateDate?: Date | null;
  guid?: string | null;
}

export class ReservationStatDaily implements IReservationStatDaily {
  constructor(
    public id?: number,
    public resort?: string | null,
    public businessDate?: Date | null,
    public nameId?: number | null,
    public rateCode?: string | null,
    public sourceCode?: string | null,
    public marketCode?: string | null,
    public roomCategory?: string | null,
    public companyId?: number | null,
    public agentId?: number | null,
    public groupId?: number | null,
    public sourceProfId?: number | null,
    public resvStatus?: string | null,
    public truncBeginDate?: Date | null,
    public truncEndDate?: Date | null,
    public resvNameId?: number | null,
    public quantity?: number | null,
    public physicalQuantity?: number | null,
    public dueOutYn?: string | null,
    public roomResvStatus?: string | null,
    public adults?: number | null,
    public children?: number | null,
    public roomAdults?: number | null,
    public roomChildren?: number | null,
    public primaryYn?: number | null,
    public allotmentHeaderId?: number | null,
    public roomRevenue?: number | null,
    public foodRevenue?: number | null,
    public packageRoomRevenue?: number | null,
    public packageFoodRevenue?: number | null,
    public totalRoomTax?: number | null,
    public totalFoodTax?: number | null,
    public totalPackageRevenue?: number | null,
    public totalRevenue?: number | null,
    public totalTax?: number | null,
    public insertDate?: Date | null,
    public originalEndDate?: Date | null,
    public walkinYn?: string | null,
    public reservationDate?: Date | null,
    public roomClass?: string | null,
    public vipStatus?: string | null,
    public cancellationDate?: Date | null,
    public birthDate?: Date | null,
    public room?: string | null,
    public membershipId?: number | null,
    public contactId?: number | null,
    public rateCategory?: string | null,
    public marketMainGroup?: string | null,
    public sourceMainGroup?: string | null,
    public channel?: string | null,
    public country?: string | null,
    public regionCode?: string | null,
    public nationality?: string | null,
    public psuedoRoomYn?: string | null,
    public adultsTaxFree?: number | null,
    public childrenTaxFree?: number | null,
    public stayRooms?: number | null,
    public stayPersons?: number | null,
    public stayAdults?: number | null,
    public stayChildren?: number | null,
    public arrRooms?: number | null,
    public arrPersons?: number | null,
    public depRooms?: number | null,
    public depPersons?: number | null,
    public dayUseRooms?: number | null,
    public dayUsePersons?: number | null,
    public cancelledRooms?: number | null,
    public cancelledPersons?: number | null,
    public noShowRooms?: number | null,
    public noShowPersons?: number | null,
    public singleOccupancy?: number | null,
    public multipleOccupancy?: number | null,
    public cribs?: number | null,
    public extraBeds?: number | null,
    public otherRevenue?: number | null,
    public packageOtherRevenue?: number | null,
    public totalOtherTax?: number | null,
    public countryMainGroup?: string | null,
    public state?: string | null,
    public fiscalRegionCode?: string | null,
    public nonRevenue?: number | null,
    public packageNonRevenue?: number | null,
    public totalNonRevenueTax?: number | null,
    public prRoomRevenue?: number | null,
    public prFoodRevenue?: number | null,
    public prPackageRoomRevenue?: number | null,
    public prPackageFoodRevenue?: number | null,
    public prTotalRoomTax?: number | null,
    public prTotalFoodTax?: number | null,
    public prTotalPackageRevenue?: number | null,
    public prTotalRevenue?: number | null,
    public prTotalTax?: number | null,
    public prOtherRevenue?: number | null,
    public prPackageOtherRevenue?: number | null,
    public prTotalOtherTax?: number | null,
    public prNonRevenue?: number | null,
    public prPackageNonRevenue?: number | null,
    public prTotalNonRevenueTax?: number | null,
    public nights?: number | null,
    public noOfStays?: number | null,
    public reservationNights?: number | null,
    public reservationArrivals?: number | null,
    public reservationNoOfStays?: number | null,
    public dayUseReservations?: number | null,
    public cancelledReservations?: number | null,
    public noShowReservations?: number | null,
    public city?: string | null,
    public zipCode?: string | null,
    public district?: string | null,
    public cashRoomNts?: number | null,
    public compRoomNts?: number | null,
    public cashRoomRevenue?: number | null,
    public compRoomRevenue?: number | null,
    public resInsertSource?: string | null,
    public resInsertSourceType?: string | null,
    public children1?: number | null,
    public children2?: number | null,
    public children3?: number | null,
    public children4?: number | null,
    public children5?: number | null,
    public ffMembershipType?: string | null,
    public fgMembershipType?: string | null,
    public promotionCode?: string | null,
    public ownerFfFlag?: string | null,
    public ownerRentalFlag?: string | null,
    public centralCurrencyCode?: string | null,
    public centralExchangeRate?: number | null,
    public bookedRoomCategory?: string | null,
    public businessDateCreated?: Date | null,
    public rateAmount?: number | null,
    public parentCompanyId?: number | null,
    public houseUseYn?: string | null,
    public complimentaryYn?: string | null,
    public biResvNameId?: number | null,
    public advFoodRevenue?: number | null,
    public advNonRevenue?: number | null,
    public advOtherRevenue?: number | null,
    public advRoomRevenue?: number | null,
    public advTotalFoodTax?: number | null,
    public advTotalNonRevenueTax?: number | null,
    public advTotalOtherTax?: number | null,
    public advTotalRevenue?: number | null,
    public advTotalRoomTax?: number | null,
    public advTotalTax?: number | null,
    public prAdvFoodRevenue?: number | null,
    public prAdvNonRevenue?: number | null,
    public prAdvOtherRevenue?: number | null,
    public prAdvRoomRevenue?: number | null,
    public prAdvTotalFoodTax?: number | null,
    public prAdvTotalNonRevenueTax?: number | null,
    public prAdvTotalOtherTax?: number | null,
    public prAdvTotalRevenue?: number | null,
    public prAdvTotalRoomTax?: number | null,
    public prAdvTotalTax?: number | null,
    public upsoldRevenue?: number | null,
    public flgdRoomRevenue?: number | null,
    public flgdFoodRevenue?: number | null,
    public flgdNonRevenue?: number | null,
    public flgdOtherRevenue?: number | null,
    public flgdTotalRoomTax?: number | null,
    public flgdTotalFoodTax?: number | null,
    public flgdTotalNonRevenueTax?: number | null,
    public flgdTotalOtherTax?: number | null,
    public flgdTotalRevenue?: number | null,
    public flgdTotalTax?: number | null,
    public contactYn?: string | null,
    public extendedStayTier?: number | null,
    public rsAdvTotalRevenue?: number | null,
    public rsAdvRoomRevenue?: number | null,
    public rsAdvFoodRevenue?: number | null,
    public rsAdvOtherRevenue?: number | null,
    public rsAdvNonRevenue?: number | null,
    public rsAdvTotalTax?: number | null,
    public rsAdvRoomTax?: number | null,
    public rsAdvFoodTax?: number | null,
    public rsAdvOtherTax?: number | null,
    public rsAdvNonRevenueTax?: number | null,
    public updateDate?: Date | null,
    public guid?: string | null,
  ) {}
}
