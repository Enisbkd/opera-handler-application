export interface INameAddress {
  id?: number;
  addressId?: number | null;
  addressType?: string | null;
  address1?: string | null;
  address2?: string | null;
  address3?: string | null;
  address4?: string | null;
  barcode?: string | null;
  beginDate?: Date | null;
  chainCode?: string | null;
  city?: string | null;
  cityExt?: string | null;
  cleansedDatetime?: Date | null;
  cleansedErrormsg?: string | null;
  cleansedMatchstatus?: string | null;
  cleansedStatus?: string | null;
  cleansedValidationstatus?: string | null;
  country?: string | null;
  endDate?: Date | null;
  foreignCountry?: string | null;
  inCareOf?: string | null;
  inactiveDate?: Date | null;
  insertDate?: Date | null;
  insertUser?: number | null;
  languageCode?: string | null;
  laptopChange?: number | null;
  lastUpdatedResort?: string | null;
  nameId?: number | null;
  primaryYn?: string | null;
  province?: string | null;
  state?: string | null;
  updateDate?: Date | null;
  updateUser?: number | null;
  zipCode?: string | null;
}

export class NameAddress implements INameAddress {
  constructor(
    public id?: number,
    public addressId?: number | null,
    public addressType?: string | null,
    public address1?: string | null,
    public address2?: string | null,
    public address3?: string | null,
    public address4?: string | null,
    public barcode?: string | null,
    public beginDate?: Date | null,
    public chainCode?: string | null,
    public city?: string | null,
    public cityExt?: string | null,
    public cleansedDatetime?: Date | null,
    public cleansedErrormsg?: string | null,
    public cleansedMatchstatus?: string | null,
    public cleansedStatus?: string | null,
    public cleansedValidationstatus?: string | null,
    public country?: string | null,
    public endDate?: Date | null,
    public foreignCountry?: string | null,
    public inCareOf?: string | null,
    public inactiveDate?: Date | null,
    public insertDate?: Date | null,
    public insertUser?: number | null,
    public languageCode?: string | null,
    public laptopChange?: number | null,
    public lastUpdatedResort?: string | null,
    public nameId?: number | null,
    public primaryYn?: string | null,
    public province?: string | null,
    public state?: string | null,
    public updateDate?: Date | null,
    public updateUser?: number | null,
    public zipCode?: string | null,
  ) {}
}
