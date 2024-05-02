/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import NamePhoneService from './name-phone.service';
import { DATE_FORMAT } from '@/shared/composables/date-format';
import { NamePhone } from '@/shared/model/name-phone.model';

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
  describe('NamePhone Service', () => {
    let service: NamePhoneService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new NamePhoneService();
      currentDate = new Date();
      elemDefault = new NamePhone(
        123,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        0,
        currentDate,
        0,
        currentDate,
        currentDate,
        currentDate,
        0,
        'AAAAAAA',
        0,
        0,
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
        currentDate,
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
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            beginDate: dayjs(currentDate).format(DATE_FORMAT),
            validateDate: dayjs(currentDate).format(DATE_FORMAT),
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

      it('should create a NamePhone', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            beginDate: dayjs(currentDate).format(DATE_FORMAT),
            validateDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
            endDate: currentDate,
            beginDate: currentDate,
            validateDate: currentDate,
          },
          returnedFromService,
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a NamePhone', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a NamePhone', async () => {
        const returnedFromService = Object.assign(
          {
            phoneId: 1,
            nameId: 1,
            phoneType: 'BBBBBB',
            phoneRole: 'BBBBBB',
            phoneNumber: 'BBBBBB',
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            insertUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            beginDate: dayjs(currentDate).format(DATE_FORMAT),
            addressId: 1,
            primaryYn: 'BBBBBB',
            displaySeq: 1,
            laptopChange: 1,
            indexPhone: 'BBBBBB',
            extension: 'BBBBBB',
            emailFormat: 'BBBBBB',
            shareEmailYn: 'BBBBBB',
            defaultConfirmationYn: 'BBBBBB',
            emailLanguage: 'BBBBBB',
            mobileAudioKeyYn: 'BBBBBB',
            countryDialingCode: 1,
            validYn: 'BBBBBB',
            phoneCountryCode: 'BBBBBB',
            chainCode: 'BBBBBB',
            validateDate: dayjs(currentDate).format(DATE_FORMAT),
            validateStatus: 'BBBBBB',
          },
          elemDefault,
        );

        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
            endDate: currentDate,
            beginDate: currentDate,
            validateDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a NamePhone', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a NamePhone', async () => {
        const patchObject = Object.assign(
          {
            phoneId: 1,
            phoneType: 'BBBBBB',
            phoneNumber: 'BBBBBB',
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            insertUser: 1,
            updateUser: 1,
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            beginDate: dayjs(currentDate).format(DATE_FORMAT),
            addressId: 1,
            displaySeq: 1,
            emailFormat: 'BBBBBB',
            defaultConfirmationYn: 'BBBBBB',
            emailLanguage: 'BBBBBB',
            validYn: 'BBBBBB',
            chainCode: 'BBBBBB',
            validateStatus: 'BBBBBB',
          },
          new NamePhone(),
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
            endDate: currentDate,
            beginDate: currentDate,
            validateDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a NamePhone', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of NamePhone', async () => {
        const returnedFromService = Object.assign(
          {
            phoneId: 1,
            nameId: 1,
            phoneType: 'BBBBBB',
            phoneRole: 'BBBBBB',
            phoneNumber: 'BBBBBB',
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            insertUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            beginDate: dayjs(currentDate).format(DATE_FORMAT),
            addressId: 1,
            primaryYn: 'BBBBBB',
            displaySeq: 1,
            laptopChange: 1,
            indexPhone: 'BBBBBB',
            extension: 'BBBBBB',
            emailFormat: 'BBBBBB',
            shareEmailYn: 'BBBBBB',
            defaultConfirmationYn: 'BBBBBB',
            emailLanguage: 'BBBBBB',
            mobileAudioKeyYn: 'BBBBBB',
            countryDialingCode: 1,
            validYn: 'BBBBBB',
            phoneCountryCode: 'BBBBBB',
            chainCode: 'BBBBBB',
            validateDate: dayjs(currentDate).format(DATE_FORMAT),
            validateStatus: 'BBBBBB',
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
            endDate: currentDate,
            beginDate: currentDate,
            validateDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of NamePhone', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a NamePhone', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a NamePhone', async () => {
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
