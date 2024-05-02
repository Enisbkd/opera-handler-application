export interface IResortOriginsOfBooking {
  id?: number;
  resort?: string | null;
  sourceCode?: string | null;
  parentSourceCode?: string | null;
  description?: string | null;
  insertUser?: number | null;
  insertDate?: Date | null;
  updateUser?: number | null;
  updateDate?: Date | null;
  inactiveDate?: Date | null;
  sellSequence?: number | null;
  scOrderby?: number | null;
  internetSalesYn?: string | null;
}

export class ResortOriginsOfBooking implements IResortOriginsOfBooking {
  constructor(
    public id?: number,
    public resort?: string | null,
    public sourceCode?: string | null,
    public parentSourceCode?: string | null,
    public description?: string | null,
    public insertUser?: number | null,
    public insertDate?: Date | null,
    public updateUser?: number | null,
    public updateDate?: Date | null,
    public inactiveDate?: Date | null,
    public sellSequence?: number | null,
    public scOrderby?: number | null,
    public internetSalesYn?: string | null,
  ) {}
}
