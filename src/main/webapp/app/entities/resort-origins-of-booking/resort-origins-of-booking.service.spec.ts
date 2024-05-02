/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import ResortOriginsOfBookingService from './resort-origins-of-booking.service';
import { DATE_FORMAT } from '@/shared/composables/date-format';
import { ResortOriginsOfBooking } from '@/shared/model/resort-origins-of-booking.model';

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
  describe('ResortOriginsOfBooking Service', () => {
    let service: ResortOriginsOfBookingService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new ResortOriginsOfBookingService();
      currentDate = new Date();
      elemDefault = new ResortOriginsOfBooking(
        123,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        currentDate,
        0,
        currentDate,
        currentDate,
        0,
        0,
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

      it('should create a ResortOriginsOfBooking', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
          },
          returnedFromService,
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a ResortOriginsOfBooking', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a ResortOriginsOfBooking', async () => {
        const returnedFromService = Object.assign(
          {
            resort: 'BBBBBB',
            sourceCode: 'BBBBBB',
            parentSourceCode: 'BBBBBB',
            description: 'BBBBBB',
            insertUser: 1,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            sellSequence: 1,
            scOrderby: 1,
            internetSalesYn: 'BBBBBB',
          },
          elemDefault,
        );

        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a ResortOriginsOfBooking', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a ResortOriginsOfBooking', async () => {
        const patchObject = Object.assign(
          {
            parentSourceCode: 'BBBBBB',
            description: 'BBBBBB',
            updateUser: 1,
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          new ResortOriginsOfBooking(),
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a ResortOriginsOfBooking', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of ResortOriginsOfBooking', async () => {
        const returnedFromService = Object.assign(
          {
            resort: 'BBBBBB',
            sourceCode: 'BBBBBB',
            parentSourceCode: 'BBBBBB',
            description: 'BBBBBB',
            insertUser: 1,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            sellSequence: 1,
            scOrderby: 1,
            internetSalesYn: 'BBBBBB',
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            insertDate: currentDate,
            updateDate: currentDate,
            inactiveDate: currentDate,
          },
          returnedFromService,
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of ResortOriginsOfBooking', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a ResortOriginsOfBooking', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a ResortOriginsOfBooking', async () => {
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
