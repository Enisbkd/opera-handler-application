export interface IReservationSummary {
  id?: number;
  resort?: string | null;
  eventType?: string | null;
  eventId?: string | null;
  consideredDate?: Date | null;
  roomCategory?: string | null;
  roomClass?: string | null;
  marketCode?: string | null;
  sourceCode?: string | null;
  rateCode?: string | null;
  regionCode?: string | null;
  groupId?: number | null;
  resvType?: string | null;
  resvInvType?: string | null;
  psuedoRoomYn?: string | null;
  arrRooms?: number | null;
  adults?: number | null;
  children?: number | null;
  depRooms?: number | null;
  noRooms?: number | null;
  grossRate?: number | null;
  netRoomRevenue?: number | null;
  extraRevenue?: number | null;
  ooRooms?: number | null;
  osRooms?: number | null;
  remainingBlockRooms?: number | null;
  pickedupBlockRooms?: number | null;
  singleOccupancy?: number | null;
  multipleOccupancy?: number | null;
  blockStatus?: string | null;
  arrPersons?: number | null;
  depPersons?: number | null;
  wlRooms?: number | null;
  wlPersons?: number | null;
  dayUseRooms?: number | null;
  dayUsePersons?: number | null;
  bookingStatus?: string | null;
  resvStatus?: string | null;
  dayUseYn?: string | null;
  channel?: string | null;
  country?: string | null;
  nationality?: string | null;
  cribs?: number | null;
  extraBeds?: number | null;
  adultsTaxFree?: number | null;
  childrenTaxFree?: number | null;
  rateCategory?: string | null;
  rateClass?: string | null;
  roomRevenue?: number | null;
  foodRevenue?: number | null;
  otherRevenue?: number | null;
  totalRevenue?: number | null;
  nonRevenue?: number | null;
  allotmentHeaderId?: number | null;
  roomRevenueTax?: number | null;
  foodRevenueTax?: number | null;
  otherRevenueTax?: number | null;
  totalRevenueTax?: number | null;
  nonRevenueTax?: number | null;
  city?: string | null;
  zipCode?: string | null;
  district?: string | null;
  state?: string | null;
  children1?: number | null;
  children2?: number | null;
  children3?: number | null;
  children4?: number | null;
  children5?: number | null;
  ownerFfFlag?: string | null;
  ownerRentalFlag?: string | null;
  fcGrossRate?: number | null;
  fcNetRoomRevenue?: number | null;
  fcExtraRevenue?: number | null;
  fcRoomRevenue?: number | null;
  fcFoodRevenue?: number | null;
  fcOtherRevenue?: number | null;
  fcTotalRevenue?: number | null;
  fcNonRevenue?: number | null;
  fcRoomRevenueTax?: number | null;
  fcFoodRevenueTax?: number | null;
  fcOtherRevenueTax?: number | null;
  fcTotalRevenueTax?: number | null;
  fcNonRevenueTax?: number | null;
  currencyCode?: string | null;
  exchangeDate?: Date | null;
  updateBusinessDate?: Date | null;
  updateDate?: Date | null;
  centralCurrencyCode?: string | null;
  centralExchangeRate?: number | null;
  truncBeginDate?: Date | null;
  truncEndDate?: Date | null;
  businessDateCreated?: Date | null;
  resInsertSource?: string | null;
  parentCompanyId?: number | null;
  agentId?: number | null;
  gender?: string | null;
  vipStatus?: string | null;
  quantity?: number | null;
  turndownStatus?: string | null;
  bookedRoomCategory?: string | null;
  sourceProfId?: number | null;
}

export class ReservationSummary implements IReservationSummary {
  constructor(
    public id?: number,
    public resort?: string | null,
    public eventType?: string | null,
    public eventId?: string | null,
    public consideredDate?: Date | null,
    public roomCategory?: string | null,
    public roomClass?: string | null,
    public marketCode?: string | null,
    public sourceCode?: string | null,
    public rateCode?: string | null,
    public regionCode?: string | null,
    public groupId?: number | null,
    public resvType?: string | null,
    public resvInvType?: string | null,
    public psuedoRoomYn?: string | null,
    public arrRooms?: number | null,
    public adults?: number | null,
    public children?: number | null,
    public depRooms?: number | null,
    public noRooms?: number | null,
    public grossRate?: number | null,
    public netRoomRevenue?: number | null,
    public extraRevenue?: number | null,
    public ooRooms?: number | null,
    public osRooms?: number | null,
    public remainingBlockRooms?: number | null,
    public pickedupBlockRooms?: number | null,
    public singleOccupancy?: number | null,
    public multipleOccupancy?: number | null,
    public blockStatus?: string | null,
    public arrPersons?: number | null,
    public depPersons?: number | null,
    public wlRooms?: number | null,
    public wlPersons?: number | null,
    public dayUseRooms?: number | null,
    public dayUsePersons?: number | null,
    public bookingStatus?: string | null,
    public resvStatus?: string | null,
    public dayUseYn?: string | null,
    public channel?: string | null,
    public country?: string | null,
    public nationality?: string | null,
    public cribs?: number | null,
    public extraBeds?: number | null,
    public adultsTaxFree?: number | null,
    public childrenTaxFree?: number | null,
    public rateCategory?: string | null,
    public rateClass?: string | null,
    public roomRevenue?: number | null,
    public foodRevenue?: number | null,
    public otherRevenue?: number | null,
    public totalRevenue?: number | null,
    public nonRevenue?: number | null,
    public allotmentHeaderId?: number | null,
    public roomRevenueTax?: number | null,
    public foodRevenueTax?: number | null,
    public otherRevenueTax?: number | null,
    public totalRevenueTax?: number | null,
    public nonRevenueTax?: number | null,
    public city?: string | null,
    public zipCode?: string | null,
    public district?: string | null,
    public state?: string | null,
    public children1?: number | null,
    public children2?: number | null,
    public children3?: number | null,
    public children4?: number | null,
    public children5?: number | null,
    public ownerFfFlag?: string | null,
    public ownerRentalFlag?: string | null,
    public fcGrossRate?: number | null,
    public fcNetRoomRevenue?: number | null,
    public fcExtraRevenue?: number | null,
    public fcRoomRevenue?: number | null,
    public fcFoodRevenue?: number | null,
    public fcOtherRevenue?: number | null,
    public fcTotalRevenue?: number | null,
    public fcNonRevenue?: number | null,
    public fcRoomRevenueTax?: number | null,
    public fcFoodRevenueTax?: number | null,
    public fcOtherRevenueTax?: number | null,
    public fcTotalRevenueTax?: number | null,
    public fcNonRevenueTax?: number | null,
    public currencyCode?: string | null,
    public exchangeDate?: Date | null,
    public updateBusinessDate?: Date | null,
    public updateDate?: Date | null,
    public centralCurrencyCode?: string | null,
    public centralExchangeRate?: number | null,
    public truncBeginDate?: Date | null,
    public truncEndDate?: Date | null,
    public businessDateCreated?: Date | null,
    public resInsertSource?: string | null,
    public parentCompanyId?: number | null,
    public agentId?: number | null,
    public gender?: string | null,
    public vipStatus?: string | null,
    public quantity?: number | null,
    public turndownStatus?: string | null,
    public bookedRoomCategory?: string | null,
    public sourceProfId?: number | null,
  ) {}
}
