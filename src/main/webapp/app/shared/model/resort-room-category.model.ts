export interface IResortRoomCategory {
  id?: number;
  resort?: string | null;
  roomCategory?: string | null;
  roomClass?: string | null;
  numberRooms?: number | null;
  shortDescription?: string | null;
  longDescription?: string | null;
  compiled?: string | null;
  psuedoRoomType?: string | null;
  activeDate?: Date | null;
  inactiveDate?: Date | null;
  replacesCategory?: string | null;
  orderBy?: number | null;
  maxOccupancy?: number | null;
  maxRollaways?: number | null;
  rateCategory?: string | null;
  label?: string | null;
  genericFlag?: string | null;
  suiteYn?: string | null;
  meetingroomYn?: string | null;
  insertUser?: number | null;
  insertDate?: Date | null;
  updateUser?: number | null;
  updateDate?: Date | null;
  rateCode?: string | null;
  rateAmount?: number | null;
  defOccupancy?: number | null;
  imageId?: number | null;
  pseudoYn?: string | null;
  sendToInterfaceYn?: string | null;
  yieldableYn?: string | null;
  yieldCategory?: string | null;
  housekeeping?: string | null;
  canDeleteYn?: string | null;
  roominfoUrl?: string | null;
  ownerYn?: string | null;
  autoIncludeYn?: string | null;
  initialRoundUp?: number | null;
  increments?: number | null;
  rotationGroup?: string | null;
  salesFlag?: string | null;
  autoRoomAssignYn?: string | null;
  upsellYn?: string | null;
  ormsUpsellRank?: number | null;
  ormsUpsellAmt?: number | null;
  ormsDrxtraAdult?: number | null;
  ormsDrxtraChild?: number | null;
  maxOccupancyAdults?: number | null;
  maxOccupancyChildren?: number | null;
  roomPool?: string | null;
  memberAwardRoomGrp?: string | null;
  ormsDrxtra2ndAdult?: number | null;
  ormsDrtier1?: number | null;
  ormsDrtier2?: number | null;
  ormsDrtier3?: number | null;
  autoCheckinYn?: string | null;
  rateFloor?: number | null;
  maxFixBedOccupancy?: number | null;
  maintenanceYn?: string | null;
  smokingPreference?: string | null;
  sLabel?: string | null;
  sBedtype?: string | null;
  sellThruRuleYn?: string | null;
  crsDescription?: string | null;
  evisitorFacilityId?: string | null;
  minOccupancy?: number | null;
  accessibleYn?: string | null;
}

export class ResortRoomCategory implements IResortRoomCategory {
  constructor(
    public id?: number,
    public resort?: string | null,
    public roomCategory?: string | null,
    public roomClass?: string | null,
    public numberRooms?: number | null,
    public shortDescription?: string | null,
    public longDescription?: string | null,
    public compiled?: string | null,
    public psuedoRoomType?: string | null,
    public activeDate?: Date | null,
    public inactiveDate?: Date | null,
    public replacesCategory?: string | null,
    public orderBy?: number | null,
    public maxOccupancy?: number | null,
    public maxRollaways?: number | null,
    public rateCategory?: string | null,
    public label?: string | null,
    public genericFlag?: string | null,
    public suiteYn?: string | null,
    public meetingroomYn?: string | null,
    public insertUser?: number | null,
    public insertDate?: Date | null,
    public updateUser?: number | null,
    public updateDate?: Date | null,
    public rateCode?: string | null,
    public rateAmount?: number | null,
    public defOccupancy?: number | null,
    public imageId?: number | null,
    public pseudoYn?: string | null,
    public sendToInterfaceYn?: string | null,
    public yieldableYn?: string | null,
    public yieldCategory?: string | null,
    public housekeeping?: string | null,
    public canDeleteYn?: string | null,
    public roominfoUrl?: string | null,
    public ownerYn?: string | null,
    public autoIncludeYn?: string | null,
    public initialRoundUp?: number | null,
    public increments?: number | null,
    public rotationGroup?: string | null,
    public salesFlag?: string | null,
    public autoRoomAssignYn?: string | null,
    public upsellYn?: string | null,
    public ormsUpsellRank?: number | null,
    public ormsUpsellAmt?: number | null,
    public ormsDrxtraAdult?: number | null,
    public ormsDrxtraChild?: number | null,
    public maxOccupancyAdults?: number | null,
    public maxOccupancyChildren?: number | null,
    public roomPool?: string | null,
    public memberAwardRoomGrp?: string | null,
    public ormsDrxtra2ndAdult?: number | null,
    public ormsDrtier1?: number | null,
    public ormsDrtier2?: number | null,
    public ormsDrtier3?: number | null,
    public autoCheckinYn?: string | null,
    public rateFloor?: number | null,
    public maxFixBedOccupancy?: number | null,
    public maintenanceYn?: string | null,
    public smokingPreference?: string | null,
    public sLabel?: string | null,
    public sBedtype?: string | null,
    public sellThruRuleYn?: string | null,
    public crsDescription?: string | null,
    public evisitorFacilityId?: string | null,
    public minOccupancy?: number | null,
    public accessibleYn?: string | null,
  ) {}
}
