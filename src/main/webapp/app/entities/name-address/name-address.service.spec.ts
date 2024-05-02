/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import NameAddressService from './name-address.service';
import { DATE_FORMAT } from '@/shared/composables/date-format';
import { NameAddress } from '@/shared/model/name-address.model';

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
  describe('NameAddress Service', () => {
    let service: NameAddressService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new NameAddressService();
      currentDate = new Date();
      elemDefault = new NameAddress(
        123,
        0,
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
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        0,
        'AAAAAAA',
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            beginDate: dayjs(currentDate).format(DATE_FORMAT),
            cleansedDatetime: dayjs(currentDate).format(DATE_FORMAT),
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
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

      it('should create a NameAddress', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            beginDate: dayjs(currentDate).format(DATE_FORMAT),
            cleansedDatetime: dayjs(currentDate).format(DATE_FORMAT),
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            beginDate: currentDate,
            cleansedDatetime: currentDate,
            endDate: currentDate,
            inactiveDate: currentDate,
            insertDate: currentDate,
            updateDate: currentDate,
          },
          returnedFromService,
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a NameAddress', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a NameAddress', async () => {
        const returnedFromService = Object.assign(
          {
            addressId: 1,
            addressType: 'BBBBBB',
            address1: 'BBBBBB',
            address2: 'BBBBBB',
            address3: 'BBBBBB',
            address4: 'BBBBBB',
            barcode: 'BBBBBB',
            beginDate: dayjs(currentDate).format(DATE_FORMAT),
            chainCode: 'BBBBBB',
            city: 'BBBBBB',
            cityExt: 'BBBBBB',
            cleansedDatetime: dayjs(currentDate).format(DATE_FORMAT),
            cleansedErrormsg: 'BBBBBB',
            cleansedMatchstatus: 'BBBBBB',
            cleansedStatus: 'BBBBBB',
            cleansedValidationstatus: 'BBBBBB',
            country: 'BBBBBB',
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            foreignCountry: 'BBBBBB',
            inCareOf: 'BBBBBB',
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            insertUser: 1,
            languageCode: 'BBBBBB',
            laptopChange: 1,
            lastUpdatedResort: 'BBBBBB',
            nameId: 1,
            primaryYn: 'BBBBBB',
            province: 'BBBBBB',
            state: 'BBBBBB',
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            zipCode: 'BBBBBB',
          },
          elemDefault,
        );

        const expected = Object.assign(
          {
            beginDate: currentDate,
            cleansedDatetime: currentDate,
            endDate: currentDate,
            inactiveDate: currentDate,
            insertDate: currentDate,
            updateDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a NameAddress', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a NameAddress', async () => {
        const patchObject = Object.assign(
          {
            addressType: 'BBBBBB',
            address1: 'BBBBBB',
            address4: 'BBBBBB',
            beginDate: dayjs(currentDate).format(DATE_FORMAT),
            cityExt: 'BBBBBB',
            cleansedDatetime: dayjs(currentDate).format(DATE_FORMAT),
            cleansedErrormsg: 'BBBBBB',
            cleansedMatchstatus: 'BBBBBB',
            cleansedValidationstatus: 'BBBBBB',
            foreignCountry: 'BBBBBB',
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            nameId: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            zipCode: 'BBBBBB',
          },
          new NameAddress(),
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            beginDate: currentDate,
            cleansedDatetime: currentDate,
            endDate: currentDate,
            inactiveDate: currentDate,
            insertDate: currentDate,
            updateDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a NameAddress', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of NameAddress', async () => {
        const returnedFromService = Object.assign(
          {
            addressId: 1,
            addressType: 'BBBBBB',
            address1: 'BBBBBB',
            address2: 'BBBBBB',
            address3: 'BBBBBB',
            address4: 'BBBBBB',
            barcode: 'BBBBBB',
            beginDate: dayjs(currentDate).format(DATE_FORMAT),
            chainCode: 'BBBBBB',
            city: 'BBBBBB',
            cityExt: 'BBBBBB',
            cleansedDatetime: dayjs(currentDate).format(DATE_FORMAT),
            cleansedErrormsg: 'BBBBBB',
            cleansedMatchstatus: 'BBBBBB',
            cleansedStatus: 'BBBBBB',
            cleansedValidationstatus: 'BBBBBB',
            country: 'BBBBBB',
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            foreignCountry: 'BBBBBB',
            inCareOf: 'BBBBBB',
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            insertUser: 1,
            languageCode: 'BBBBBB',
            laptopChange: 1,
            lastUpdatedResort: 'BBBBBB',
            nameId: 1,
            primaryYn: 'BBBBBB',
            province: 'BBBBBB',
            state: 'BBBBBB',
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            zipCode: 'BBBBBB',
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            beginDate: currentDate,
            cleansedDatetime: currentDate,
            endDate: currentDate,
            inactiveDate: currentDate,
            insertDate: currentDate,
            updateDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of NameAddress', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a NameAddress', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a NameAddress', async () => {
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
