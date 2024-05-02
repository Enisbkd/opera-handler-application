/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import ApplicationUserService from './application-user.service';
import { DATE_FORMAT } from '@/shared/composables/date-format';
import { ApplicationUser } from '@/shared/model/application-user.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('ApplicationUser Service', () => {
    let service: ApplicationUserService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new ApplicationUserService();
      currentDate = new Date();
      elemDefault = new ApplicationUser(
        123,
        0,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        0,
        currentDate,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        currentDate,
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        currentDate,
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        currentDate,
        currentDate,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        currentDate,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            disabledUntil: dayjs(currentDate).format(DATE_FORMAT),
            expiresOn: dayjs(currentDate).format(DATE_FORMAT),
            lastLoggedTimestamp: dayjs(currentDate).format(DATE_FORMAT),
            dateHired: dayjs(currentDate).format(DATE_FORMAT),
            workPermitExpdate: dayjs(currentDate).format(DATE_FORMAT),
            terminatedDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveFrom: dayjs(currentDate).format(DATE_FORMAT),
            inactiveTo: dayjs(currentDate).format(DATE_FORMAT),
            passwordLastChange: dayjs(currentDate).format(DATE_FORMAT),
            authorizerInactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            lockoutDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault,
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should create a ApplicationUser', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            disabledUntil: dayjs(currentDate).format(DATE_FORMAT),
            expiresOn: dayjs(currentDate).format(DATE_FORMAT),
            lastLoggedTimestamp: dayjs(currentDate).format(DATE_FORMAT),
            dateHired: dayjs(currentDate).format(DATE_FORMAT),
            workPermitExpdate: dayjs(currentDate).format(DATE_FORMAT),
            terminatedDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveFrom: dayjs(currentDate).format(DATE_FORMAT),
            inactiveTo: dayjs(currentDate).format(DATE_FORMAT),
            passwordLastChange: dayjs(currentDate).format(DATE_FORMAT),
            authorizerInactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            lockoutDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
            disabledUntil: currentDate,
            expiresOn: currentDate,
            lastLoggedTimestamp: currentDate,
            dateHired: currentDate,
            workPermitExpdate: currentDate,
            terminatedDate: currentDate,
            inactiveFrom: currentDate,
            inactiveTo: currentDate,
            passwordLastChange: currentDate,
            authorizerInactiveDate: currentDate,
            lockoutDate: currentDate,
          },
          returnedFromService,
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a ApplicationUser', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a ApplicationUser', async () => {
        const returnedFromService = Object.assign(
          {
            appUserId: 1,
            appUser: 'BBBBBB',
            appPassword: 'BBBBBB',
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            insertUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            oracleUid: 1,
            oracleUser: 'BBBBBB',
            oraclePassword: 'BBBBBB',
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            title: 'BBBBBB',
            defaultForm: 'BBBBBB',
            name: 'BBBBBB',
            appUserType: 'BBBBBB',
            lastLoggedResort: 'BBBBBB',
            defCashierId: 1,
            appUserDescription: 'BBBBBB',
            personNameId: 1,
            disabledUntil: dayjs(currentDate).format(DATE_FORMAT),
            expiresOn: dayjs(currentDate).format(DATE_FORMAT),
            lastLoggedTimestamp: dayjs(currentDate).format(DATE_FORMAT),
            isSuperuser: 'BBBBBB',
            employeeNumber: 'BBBBBB',
            generalFilepath: 'BBBBBB',
            userFilepath: 'BBBBBB',
            defaultResort: 'BBBBBB',
            maxUserSessions: 1,
            internalYn: 'BBBBBB',
            maxCheckoutDays: 1,
            defaultTerminal: 'BBBBBB',
            defaultLanguage: 'BBBBBB',
            deptId: 'BBBBBB',
            maleFemale: 'BBBBBB',
            userPbxId: 1,
            dateHired: dayjs(currentDate).format(DATE_FORMAT),
            workPermitNo: 'BBBBBB',
            workPermitExpdate: dayjs(currentDate).format(DATE_FORMAT),
            rateType: 'BBBBBB',
            salaryInterval: 'BBBBBB',
            hourlyRate: 1,
            weeklySalary: 1,
            otMultiplier: 1,
            hireType: 'BBBBBB',
            rehireYn: 'BBBBBB',
            empExtension: 'BBBBBB',
            empPager: 'BBBBBB',
            termReason: 'BBBBBB',
            terminatedDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveReasonCode: 'BBBBBB',
            inactiveFrom: dayjs(currentDate).format(DATE_FORMAT),
            inactiveTo: dayjs(currentDate).format(DATE_FORMAT),
            weekMin: 1,
            weekMax: 1,
            mondayMin: 1,
            mondayMax: 1,
            tuesdayMin: 1,
            tuesdayMax: 1,
            wednesdayMin: 1,
            wednesdayMax: 1,
            thursdayMin: 1,
            thursdayMax: 1,
            fridayMin: 1,
            fridayMax: 1,
            saturdayMin: 1,
            saturdayMax: 1,
            sundayMin: 1,
            sundayMax: 1,
            comments: 'BBBBBB',
            leadAddress: 'BBBBBB',
            leadComm: 'BBBBBB',
            leadAddressDet: 'BBBBBB',
            laptopId: 1,
            hoursPerWeek: 1,
            empStatus: 'BBBBBB',
            passwordLastChange: dayjs(currentDate).format(DATE_FORMAT),
            passwordChangeDays: 1,
            graceLogin: 1,
            srepGroup: 'BBBBBB',
            defaultReportgroup: 'BBBBBB',
            authorizerYn: 'BBBBBB',
            authorizerInactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            sfaName: 'BBBBBB',
            loginCro: 'BBBBBB',
            authorizerRateCode: 'BBBBBB',
            loginDomain: 'BBBBBB',
            receiveBroadcastMsg: 'BBBBBB',
            defaultMfnResort: 'BBBBBB',
            mfnUserType: 'BBBBBB',
            forcePasswordChangeYn: 'BBBBBB',
            accountLockedOutYn: 'BBBBBB',
            preventAccountLockout: 'BBBBBB',
            lockoutDate: dayjs(currentDate).format(DATE_FORMAT),
            accessPms: 'BBBBBB',
            accessSc: 'BBBBBB',
            accessConfig: 'BBBBBB',
            accessEod: 'BBBBBB',
            accessUtil: 'BBBBBB',
            accessOrs: 'BBBBBB',
            accessSfa: 'BBBBBB',
            accessOcis: 'BBBBBB',
            accessOcm: 'BBBBBB',
            accessOxi: 'BBBBBB',
            accessOxihub: 'BBBBBB',
            chainCode: 'BBBBBB',
            appUserUniq: 'BBBBBB',
            maxDaysAfterCo: 1,
            userGroupAdmin: 'BBBBBB',
            accessOrms: 'BBBBBB',
            accessObi: 'BBBBBB',
            srepCode: 'BBBBBB',
            loginAttempts: 1,
            propertyAccessYn: 'BBBBBB',
            accessScbi: 'BBBBBB',
            timezoneRegion: 'BBBBBB',
            accessOcrm: 'BBBBBB',
            employeeIncentiveNumber: 'BBBBBB',
            serviceRequestAlertsYn: 'BBBBBB',
            mobileAlertsYn: 'BBBBBB',
          },
          elemDefault,
        );

        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
            disabledUntil: currentDate,
            expiresOn: currentDate,
            lastLoggedTimestamp: currentDate,
            dateHired: currentDate,
            workPermitExpdate: currentDate,
            terminatedDate: currentDate,
            inactiveFrom: currentDate,
            inactiveTo: currentDate,
            passwordLastChange: currentDate,
            authorizerInactiveDate: currentDate,
            lockoutDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a ApplicationUser', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a ApplicationUser', async () => {
        const patchObject = Object.assign(
          {
            updateUser: 1,
            oracleUser: 'BBBBBB',
            oraclePassword: 'BBBBBB',
            name: 'BBBBBB',
            lastLoggedResort: 'BBBBBB',
            personNameId: 1,
            disabledUntil: dayjs(currentDate).format(DATE_FORMAT),
            lastLoggedTimestamp: dayjs(currentDate).format(DATE_FORMAT),
            isSuperuser: 'BBBBBB',
            defaultResort: 'BBBBBB',
            maxUserSessions: 1,
            internalYn: 'BBBBBB',
            maxCheckoutDays: 1,
            defaultLanguage: 'BBBBBB',
            deptId: 'BBBBBB',
            maleFemale: 'BBBBBB',
            dateHired: dayjs(currentDate).format(DATE_FORMAT),
            workPermitNo: 'BBBBBB',
            rateType: 'BBBBBB',
            salaryInterval: 'BBBBBB',
            hourlyRate: 1,
            hireType: 'BBBBBB',
            rehireYn: 'BBBBBB',
            termReason: 'BBBBBB',
            terminatedDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveReasonCode: 'BBBBBB',
            weekMin: 1,
            tuesdayMax: 1,
            thursdayMax: 1,
            saturdayMin: 1,
            saturdayMax: 1,
            sundayMin: 1,
            sundayMax: 1,
            hoursPerWeek: 1,
            empStatus: 'BBBBBB',
            passwordChangeDays: 1,
            srepGroup: 'BBBBBB',
            defaultReportgroup: 'BBBBBB',
            authorizerYn: 'BBBBBB',
            authorizerInactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            authorizerRateCode: 'BBBBBB',
            loginDomain: 'BBBBBB',
            defaultMfnResort: 'BBBBBB',
            mfnUserType: 'BBBBBB',
            accessPms: 'BBBBBB',
            accessSc: 'BBBBBB',
            accessEod: 'BBBBBB',
            accessOrs: 'BBBBBB',
            accessSfa: 'BBBBBB',
            accessOcm: 'BBBBBB',
            accessOxi: 'BBBBBB',
            chainCode: 'BBBBBB',
            appUserUniq: 'BBBBBB',
            maxDaysAfterCo: 1,
            propertyAccessYn: 'BBBBBB',
            accessScbi: 'BBBBBB',
          },
          new ApplicationUser(),
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
            disabledUntil: currentDate,
            expiresOn: currentDate,
            lastLoggedTimestamp: currentDate,
            dateHired: currentDate,
            workPermitExpdate: currentDate,
            terminatedDate: currentDate,
            inactiveFrom: currentDate,
            inactiveTo: currentDate,
            passwordLastChange: currentDate,
            authorizerInactiveDate: currentDate,
            lockoutDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a ApplicationUser', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of ApplicationUser', async () => {
        const returnedFromService = Object.assign(
          {
            appUserId: 1,
            appUser: 'BBBBBB',
            appPassword: 'BBBBBB',
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            insertUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            oracleUid: 1,
            oracleUser: 'BBBBBB',
            oraclePassword: 'BBBBBB',
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            title: 'BBBBBB',
            defaultForm: 'BBBBBB',
            name: 'BBBBBB',
            appUserType: 'BBBBBB',
            lastLoggedResort: 'BBBBBB',
            defCashierId: 1,
            appUserDescription: 'BBBBBB',
            personNameId: 1,
            disabledUntil: dayjs(currentDate).format(DATE_FORMAT),
            expiresOn: dayjs(currentDate).format(DATE_FORMAT),
            lastLoggedTimestamp: dayjs(currentDate).format(DATE_FORMAT),
            isSuperuser: 'BBBBBB',
            employeeNumber: 'BBBBBB',
            generalFilepath: 'BBBBBB',
            userFilepath: 'BBBBBB',
            defaultResort: 'BBBBBB',
            maxUserSessions: 1,
            internalYn: 'BBBBBB',
            maxCheckoutDays: 1,
            defaultTerminal: 'BBBBBB',
            defaultLanguage: 'BBBBBB',
            deptId: 'BBBBBB',
            maleFemale: 'BBBBBB',
            userPbxId: 1,
            dateHired: dayjs(currentDate).format(DATE_FORMAT),
            workPermitNo: 'BBBBBB',
            workPermitExpdate: dayjs(currentDate).format(DATE_FORMAT),
            rateType: 'BBBBBB',
            salaryInterval: 'BBBBBB',
            hourlyRate: 1,
            weeklySalary: 1,
            otMultiplier: 1,
            hireType: 'BBBBBB',
            rehireYn: 'BBBBBB',
            empExtension: 'BBBBBB',
            empPager: 'BBBBBB',
            termReason: 'BBBBBB',
            terminatedDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveReasonCode: 'BBBBBB',
            inactiveFrom: dayjs(currentDate).format(DATE_FORMAT),
            inactiveTo: dayjs(currentDate).format(DATE_FORMAT),
            weekMin: 1,
            weekMax: 1,
            mondayMin: 1,
            mondayMax: 1,
            tuesdayMin: 1,
            tuesdayMax: 1,
            wednesdayMin: 1,
            wednesdayMax: 1,
            thursdayMin: 1,
            thursdayMax: 1,
            fridayMin: 1,
            fridayMax: 1,
            saturdayMin: 1,
            saturdayMax: 1,
            sundayMin: 1,
            sundayMax: 1,
            comments: 'BBBBBB',
            leadAddress: 'BBBBBB',
            leadComm: 'BBBBBB',
            leadAddressDet: 'BBBBBB',
            laptopId: 1,
            hoursPerWeek: 1,
            empStatus: 'BBBBBB',
            passwordLastChange: dayjs(currentDate).format(DATE_FORMAT),
            passwordChangeDays: 1,
            graceLogin: 1,
            srepGroup: 'BBBBBB',
            defaultReportgroup: 'BBBBBB',
            authorizerYn: 'BBBBBB',
            authorizerInactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            sfaName: 'BBBBBB',
            loginCro: 'BBBBBB',
            authorizerRateCode: 'BBBBBB',
            loginDomain: 'BBBBBB',
            receiveBroadcastMsg: 'BBBBBB',
            defaultMfnResort: 'BBBBBB',
            mfnUserType: 'BBBBBB',
            forcePasswordChangeYn: 'BBBBBB',
            accountLockedOutYn: 'BBBBBB',
            preventAccountLockout: 'BBBBBB',
            lockoutDate: dayjs(currentDate).format(DATE_FORMAT),
            accessPms: 'BBBBBB',
            accessSc: 'BBBBBB',
            accessConfig: 'BBBBBB',
            accessEod: 'BBBBBB',
            accessUtil: 'BBBBBB',
            accessOrs: 'BBBBBB',
            accessSfa: 'BBBBBB',
            accessOcis: 'BBBBBB',
            accessOcm: 'BBBBBB',
            accessOxi: 'BBBBBB',
            accessOxihub: 'BBBBBB',
            chainCode: 'BBBBBB',
            appUserUniq: 'BBBBBB',
            maxDaysAfterCo: 1,
            userGroupAdmin: 'BBBBBB',
            accessOrms: 'BBBBBB',
            accessObi: 'BBBBBB',
            srepCode: 'BBBBBB',
            loginAttempts: 1,
            propertyAccessYn: 'BBBBBB',
            accessScbi: 'BBBBBB',
            timezoneRegion: 'BBBBBB',
            accessOcrm: 'BBBBBB',
            employeeIncentiveNumber: 'BBBBBB',
            serviceRequestAlertsYn: 'BBBBBB',
            mobileAlertsYn: 'BBBBBB',
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
            disabledUntil: currentDate,
            expiresOn: currentDate,
            lastLoggedTimestamp: currentDate,
            dateHired: currentDate,
            workPermitExpdate: currentDate,
            terminatedDate: currentDate,
            inactiveFrom: currentDate,
            inactiveTo: currentDate,
            passwordLastChange: currentDate,
            authorizerInactiveDate: currentDate,
            lockoutDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of ApplicationUser', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a ApplicationUser', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a ApplicationUser', async () => {
        axiosStub.delete.rejects(error);

        return service
          .delete(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
