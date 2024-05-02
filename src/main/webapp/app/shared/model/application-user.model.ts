export interface IApplicationUser {
  id?: number;
  appUserId?: number | null;
  appUser?: string | null;
  appPassword?: string | null;
  insertDate?: Date | null;
  insertUser?: number | null;
  updateDate?: Date | null;
  updateUser?: number | null;
  oracleUid?: number | null;
  oracleUser?: string | null;
  oraclePassword?: string | null;
  inactiveDate?: Date | null;
  title?: string | null;
  defaultForm?: string | null;
  name?: string | null;
  appUserType?: string | null;
  lastLoggedResort?: string | null;
  defCashierId?: number | null;
  appUserDescription?: string | null;
  personNameId?: number | null;
  disabledUntil?: Date | null;
  expiresOn?: Date | null;
  lastLoggedTimestamp?: Date | null;
  isSuperuser?: string | null;
  employeeNumber?: string | null;
  generalFilepath?: string | null;
  userFilepath?: string | null;
  defaultResort?: string | null;
  maxUserSessions?: number | null;
  internalYn?: string | null;
  maxCheckoutDays?: number | null;
  defaultTerminal?: string | null;
  defaultLanguage?: string | null;
  deptId?: string | null;
  maleFemale?: string | null;
  userPbxId?: number | null;
  dateHired?: Date | null;
  workPermitNo?: string | null;
  workPermitExpdate?: Date | null;
  rateType?: string | null;
  salaryInterval?: string | null;
  hourlyRate?: number | null;
  weeklySalary?: number | null;
  otMultiplier?: number | null;
  hireType?: string | null;
  rehireYn?: string | null;
  empExtension?: string | null;
  empPager?: string | null;
  termReason?: string | null;
  terminatedDate?: Date | null;
  inactiveReasonCode?: string | null;
  inactiveFrom?: Date | null;
  inactiveTo?: Date | null;
  weekMin?: number | null;
  weekMax?: number | null;
  mondayMin?: number | null;
  mondayMax?: number | null;
  tuesdayMin?: number | null;
  tuesdayMax?: number | null;
  wednesdayMin?: number | null;
  wednesdayMax?: number | null;
  thursdayMin?: number | null;
  thursdayMax?: number | null;
  fridayMin?: number | null;
  fridayMax?: number | null;
  saturdayMin?: number | null;
  saturdayMax?: number | null;
  sundayMin?: number | null;
  sundayMax?: number | null;
  comments?: string | null;
  leadAddress?: string | null;
  leadComm?: string | null;
  leadAddressDet?: string | null;
  laptopId?: number | null;
  hoursPerWeek?: number | null;
  empStatus?: string | null;
  passwordLastChange?: Date | null;
  passwordChangeDays?: number | null;
  graceLogin?: number | null;
  srepGroup?: string | null;
  defaultReportgroup?: string | null;
  authorizerYn?: string | null;
  authorizerInactiveDate?: Date | null;
  sfaName?: string | null;
  loginCro?: string | null;
  authorizerRateCode?: string | null;
  loginDomain?: string | null;
  receiveBroadcastMsg?: string | null;
  defaultMfnResort?: string | null;
  mfnUserType?: string | null;
  forcePasswordChangeYn?: string | null;
  accountLockedOutYn?: string | null;
  preventAccountLockout?: string | null;
  lockoutDate?: Date | null;
  accessPms?: string | null;
  accessSc?: string | null;
  accessConfig?: string | null;
  accessEod?: string | null;
  accessUtil?: string | null;
  accessOrs?: string | null;
  accessSfa?: string | null;
  accessOcis?: string | null;
  accessOcm?: string | null;
  accessOxi?: string | null;
  accessOxihub?: string | null;
  chainCode?: string | null;
  appUserUniq?: string | null;
  maxDaysAfterCo?: number | null;
  userGroupAdmin?: string | null;
  accessOrms?: string | null;
  accessObi?: string | null;
  srepCode?: string | null;
  loginAttempts?: number | null;
  propertyAccessYn?: string | null;
  accessScbi?: string | null;
  timezoneRegion?: string | null;
  accessOcrm?: string | null;
  employeeIncentiveNumber?: string | null;
  serviceRequestAlertsYn?: string | null;
  mobileAlertsYn?: string | null;
}

export class ApplicationUser implements IApplicationUser {
  constructor(
    public id?: number,
    public appUserId?: number | null,
    public appUser?: string | null,
    public appPassword?: string | null,
    public insertDate?: Date | null,
    public insertUser?: number | null,
    public updateDate?: Date | null,
    public updateUser?: number | null,
    public oracleUid?: number | null,
    public oracleUser?: string | null,
    public oraclePassword?: string | null,
    public inactiveDate?: Date | null,
    public title?: string | null,
    public defaultForm?: string | null,
    public name?: string | null,
    public appUserType?: string | null,
    public lastLoggedResort?: string | null,
    public defCashierId?: number | null,
    public appUserDescription?: string | null,
    public personNameId?: number | null,
    public disabledUntil?: Date | null,
    public expiresOn?: Date | null,
    public lastLoggedTimestamp?: Date | null,
    public isSuperuser?: string | null,
    public employeeNumber?: string | null,
    public generalFilepath?: string | null,
    public userFilepath?: string | null,
    public defaultResort?: string | null,
    public maxUserSessions?: number | null,
    public internalYn?: string | null,
    public maxCheckoutDays?: number | null,
    public defaultTerminal?: string | null,
    public defaultLanguage?: string | null,
    public deptId?: string | null,
    public maleFemale?: string | null,
    public userPbxId?: number | null,
    public dateHired?: Date | null,
    public workPermitNo?: string | null,
    public workPermitExpdate?: Date | null,
    public rateType?: string | null,
    public salaryInterval?: string | null,
    public hourlyRate?: number | null,
    public weeklySalary?: number | null,
    public otMultiplier?: number | null,
    public hireType?: string | null,
    public rehireYn?: string | null,
    public empExtension?: string | null,
    public empPager?: string | null,
    public termReason?: string | null,
    public terminatedDate?: Date | null,
    public inactiveReasonCode?: string | null,
    public inactiveFrom?: Date | null,
    public inactiveTo?: Date | null,
    public weekMin?: number | null,
    public weekMax?: number | null,
    public mondayMin?: number | null,
    public mondayMax?: number | null,
    public tuesdayMin?: number | null,
    public tuesdayMax?: number | null,
    public wednesdayMin?: number | null,
    public wednesdayMax?: number | null,
    public thursdayMin?: number | null,
    public thursdayMax?: number | null,
    public fridayMin?: number | null,
    public fridayMax?: number | null,
    public saturdayMin?: number | null,
    public saturdayMax?: number | null,
    public sundayMin?: number | null,
    public sundayMax?: number | null,
    public comments?: string | null,
    public leadAddress?: string | null,
    public leadComm?: string | null,
    public leadAddressDet?: string | null,
    public laptopId?: number | null,
    public hoursPerWeek?: number | null,
    public empStatus?: string | null,
    public passwordLastChange?: Date | null,
    public passwordChangeDays?: number | null,
    public graceLogin?: number | null,
    public srepGroup?: string | null,
    public defaultReportgroup?: string | null,
    public authorizerYn?: string | null,
    public authorizerInactiveDate?: Date | null,
    public sfaName?: string | null,
    public loginCro?: string | null,
    public authorizerRateCode?: string | null,
    public loginDomain?: string | null,
    public receiveBroadcastMsg?: string | null,
    public defaultMfnResort?: string | null,
    public mfnUserType?: string | null,
    public forcePasswordChangeYn?: string | null,
    public accountLockedOutYn?: string | null,
    public preventAccountLockout?: string | null,
    public lockoutDate?: Date | null,
    public accessPms?: string | null,
    public accessSc?: string | null,
    public accessConfig?: string | null,
    public accessEod?: string | null,
    public accessUtil?: string | null,
    public accessOrs?: string | null,
    public accessSfa?: string | null,
    public accessOcis?: string | null,
    public accessOcm?: string | null,
    public accessOxi?: string | null,
    public accessOxihub?: string | null,
    public chainCode?: string | null,
    public appUserUniq?: string | null,
    public maxDaysAfterCo?: number | null,
    public userGroupAdmin?: string | null,
    public accessOrms?: string | null,
    public accessObi?: string | null,
    public srepCode?: string | null,
    public loginAttempts?: number | null,
    public propertyAccessYn?: string | null,
    public accessScbi?: string | null,
    public timezoneRegion?: string | null,
    public accessOcrm?: string | null,
    public employeeIncentiveNumber?: string | null,
    public serviceRequestAlertsYn?: string | null,
    public mobileAlertsYn?: string | null,
  ) {}
}
