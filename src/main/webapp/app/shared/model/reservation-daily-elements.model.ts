export interface IReservationDailyElements {
  id?: number;
  resort?: string | null;
  reservationDate?: Date | null;
  resvDailyElSeq?: number | null;
  resvStatus?: string | null;
  externalReference?: string | null;
  roomClass?: string | null;
  roomCategory?: string | null;
  bookedRoomCategory?: string | null;
  room?: string | null;
  cancellationNo?: number | null;
  cancellationDate?: Date | null;
  cancellationCode?: string | null;
  cancellationReasonDesc?: string | null;
  guaranteeCode?: string | null;
  marketCode?: string | null;
  originOfBooking?: string | null;
  exchangeRate?: number | null;
  originalBaseRate?: number | null;
  baseRateAmount?: number | null;
  rateAmount?: number | null;
  roomCost?: number | null;
  quantity?: number | null;
  adults?: number | null;
  children?: number | null;
  physicalQuantity?: number | null;
  allotmentHeaderId?: number | null;
  dayUseYn?: string | null;
  dueOutYn?: string | null;
  insertUser?: number | null;
  insertDate?: Date | null;
  updateUser?: number | null;
  updateDate?: Date | null;
  insertActionInstanceId?: number | null;
  dmlSeqNo?: number | null;
  extSeqNo?: number | null;
  extSegNo?: number | null;
  cribs?: number | null;
  extraBeds?: number | null;
  allotmentRecordType?: string | null;
  blockResort?: string | null;
  blockId?: number | null;
  turndownStatus?: string | null;
  awdUpgrFrom?: string | null;
  awdUpgrTo?: string | null;
  hkExpectedServiceTime?: string | null;
  roomInstructions?: string | null;
}

export class ReservationDailyElements implements IReservationDailyElements {
  constructor(
    public id?: number,
    public resort?: string | null,
    public reservationDate?: Date | null,
    public resvDailyElSeq?: number | null,
    public resvStatus?: string | null,
    public externalReference?: string | null,
    public roomClass?: string | null,
    public roomCategory?: string | null,
    public bookedRoomCategory?: string | null,
    public room?: string | null,
    public cancellationNo?: number | null,
    public cancellationDate?: Date | null,
    public cancellationCode?: string | null,
    public cancellationReasonDesc?: string | null,
    public guaranteeCode?: string | null,
    public marketCode?: string | null,
    public originOfBooking?: string | null,
    public exchangeRate?: number | null,
    public originalBaseRate?: number | null,
    public baseRateAmount?: number | null,
    public rateAmount?: number | null,
    public roomCost?: number | null,
    public quantity?: number | null,
    public adults?: number | null,
    public children?: number | null,
    public physicalQuantity?: number | null,
    public allotmentHeaderId?: number | null,
    public dayUseYn?: string | null,
    public dueOutYn?: string | null,
    public insertUser?: number | null,
    public insertDate?: Date | null,
    public updateUser?: number | null,
    public updateDate?: Date | null,
    public insertActionInstanceId?: number | null,
    public dmlSeqNo?: number | null,
    public extSeqNo?: number | null,
    public extSegNo?: number | null,
    public cribs?: number | null,
    public extraBeds?: number | null,
    public allotmentRecordType?: string | null,
    public blockResort?: string | null,
    public blockId?: number | null,
    public turndownStatus?: string | null,
    public awdUpgrFrom?: string | null,
    public awdUpgrTo?: string | null,
    public hkExpectedServiceTime?: string | null,
    public roomInstructions?: string | null,
  ) {}
}
