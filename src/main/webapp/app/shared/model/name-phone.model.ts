export interface INamePhone {
  id?: number;
  phoneId?: number | null;
  nameId?: number | null;
  phoneType?: string | null;
  phoneRole?: string | null;
  phoneNumber?: string | null;
  insertDate?: Date | null;
  insertUser?: number | null;
  updateDate?: Date | null;
  updateUser?: number | null;
  inactiveDate?: Date | null;
  endDate?: Date | null;
  beginDate?: Date | null;
  addressId?: number | null;
  primaryYn?: string | null;
  displaySeq?: number | null;
  laptopChange?: number | null;
  indexPhone?: string | null;
  extension?: string | null;
  emailFormat?: string | null;
  shareEmailYn?: string | null;
  defaultConfirmationYn?: string | null;
  emailLanguage?: string | null;
  mobileAudioKeyYn?: string | null;
  countryDialingCode?: number | null;
  validYn?: string | null;
  phoneCountryCode?: string | null;
  chainCode?: string | null;
  validateDate?: Date | null;
  validateStatus?: string | null;
}

export class NamePhone implements INamePhone {
  constructor(
    public id?: number,
    public phoneId?: number | null,
    public nameId?: number | null,
    public phoneType?: string | null,
    public phoneRole?: string | null,
    public phoneNumber?: string | null,
    public insertDate?: Date | null,
    public insertUser?: number | null,
    public updateDate?: Date | null,
    public updateUser?: number | null,
    public inactiveDate?: Date | null,
    public endDate?: Date | null,
    public beginDate?: Date | null,
    public addressId?: number | null,
    public primaryYn?: string | null,
    public displaySeq?: number | null,
    public laptopChange?: number | null,
    public indexPhone?: string | null,
    public extension?: string | null,
    public emailFormat?: string | null,
    public shareEmailYn?: string | null,
    public defaultConfirmationYn?: string | null,
    public emailLanguage?: string | null,
    public mobileAudioKeyYn?: string | null,
    public countryDialingCode?: number | null,
    public validYn?: string | null,
    public phoneCountryCode?: string | null,
    public chainCode?: string | null,
    public validateDate?: Date | null,
    public validateStatus?: string | null,
  ) {}
}
