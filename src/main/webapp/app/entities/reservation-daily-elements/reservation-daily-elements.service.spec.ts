/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import ReservationDailyElementsService from './reservation-daily-elements.service';
import { DATE_FORMAT } from '@/shared/composables/date-format';
import { ReservationDailyElements } from '@/shared/model/reservation-daily-elements.model';

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
  describe('ReservationDailyElements Service', () => {
    let service: ReservationDailyElementsService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new ReservationDailyElementsService();
      currentDate = new Date();
      elemDefault = new ReservationDailyElements(
        123,
        'AAAAAAA',
        currentDate,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
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
        0,
        currentDate,
        0,
        currentDate,
        0,
        0,
        0,
        0,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
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
            reservationDate: dayjs(currentDate).format(DATE_FORMAT),
            cancellationDate: dayjs(currentDate).format(DATE_FORMAT),
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

      it('should create a ReservationDailyElements', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            reservationDate: dayjs(currentDate).format(DATE_FORMAT),
            cancellationDate: dayjs(currentDate).format(DATE_FORMAT),
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            reservationDate: currentDate,
            cancellationDate: currentDate,
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

      it('should not create a ReservationDailyElements', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a ReservationDailyElements', async () => {
        const returnedFromService = Object.assign(
          {
            resort: 'BBBBBB',
            reservationDate: dayjs(currentDate).format(DATE_FORMAT),
            resvDailyElSeq: 1,
            resvStatus: 'BBBBBB',
            externalReference: 'BBBBBB',
            roomClass: 'BBBBBB',
            roomCategory: 'BBBBBB',
            bookedRoomCategory: 'BBBBBB',
            room: 'BBBBBB',
            cancellationNo: 1,
            cancellationDate: dayjs(currentDate).format(DATE_FORMAT),
            cancellationCode: 'BBBBBB',
            cancellationReasonDesc: 'BBBBBB',
            guaranteeCode: 'BBBBBB',
            marketCode: 'BBBBBB',
            originOfBooking: 'BBBBBB',
            exchangeRate: 1,
            originalBaseRate: 1,
            baseRateAmount: 1,
            rateAmount: 1,
            roomCost: 1,
            quantity: 1,
            adults: 1,
            children: 1,
            physicalQuantity: 1,
            allotmentHeaderId: 1,
            dayUseYn: 'BBBBBB',
            dueOutYn: 'BBBBBB',
            insertUser: 1,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            insertActionInstanceId: 1,
            dmlSeqNo: 1,
            extSeqNo: 1,
            extSegNo: 1,
            cribs: 1,
            extraBeds: 1,
            allotmentRecordType: 'BBBBBB',
            blockResort: 'BBBBBB',
            blockId: 1,
            turndownStatus: 'BBBBBB',
            awdUpgrFrom: 'BBBBBB',
            awdUpgrTo: 'BBBBBB',
            hkExpectedServiceTime: 'BBBBBB',
            roomInstructions: 'BBBBBB',
          },
          elemDefault,
        );

        const expected = Object.assign(
          {
            reservationDate: currentDate,
            cancellationDate: currentDate,
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

      it('should not update a ReservationDailyElements', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a ReservationDailyElements', async () => {
        const patchObject = Object.assign(
          {
            resort: 'BBBBBB',
            room: 'BBBBBB',
            cancellationCode: 'BBBBBB',
            cancellationReasonDesc: 'BBBBBB',
            exchangeRate: 1,
            originalBaseRate: 1,
            quantity: 1,
            children: 1,
            allotmentHeaderId: 1,
            dueOutYn: 'BBBBBB',
            insertUser: 1,
            updateUser: 1,
            dmlSeqNo: 1,
            extraBeds: 1,
            allotmentRecordType: 'BBBBBB',
            blockResort: 'BBBBBB',
            awdUpgrFrom: 'BBBBBB',
            awdUpgrTo: 'BBBBBB',
          },
          new ReservationDailyElements(),
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            reservationDate: currentDate,
            cancellationDate: currentDate,
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

      it('should not partial update a ReservationDailyElements', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of ReservationDailyElements', async () => {
        const returnedFromService = Object.assign(
          {
            resort: 'BBBBBB',
            reservationDate: dayjs(currentDate).format(DATE_FORMAT),
            resvDailyElSeq: 1,
            resvStatus: 'BBBBBB',
            externalReference: 'BBBBBB',
            roomClass: 'BBBBBB',
            roomCategory: 'BBBBBB',
            bookedRoomCategory: 'BBBBBB',
            room: 'BBBBBB',
            cancellationNo: 1,
            cancellationDate: dayjs(currentDate).format(DATE_FORMAT),
            cancellationCode: 'BBBBBB',
            cancellationReasonDesc: 'BBBBBB',
            guaranteeCode: 'BBBBBB',
            marketCode: 'BBBBBB',
            originOfBooking: 'BBBBBB',
            exchangeRate: 1,
            originalBaseRate: 1,
            baseRateAmount: 1,
            rateAmount: 1,
            roomCost: 1,
            quantity: 1,
            adults: 1,
            children: 1,
            physicalQuantity: 1,
            allotmentHeaderId: 1,
            dayUseYn: 'BBBBBB',
            dueOutYn: 'BBBBBB',
            insertUser: 1,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            insertActionInstanceId: 1,
            dmlSeqNo: 1,
            extSeqNo: 1,
            extSegNo: 1,
            cribs: 1,
            extraBeds: 1,
            allotmentRecordType: 'BBBBBB',
            blockResort: 'BBBBBB',
            blockId: 1,
            turndownStatus: 'BBBBBB',
            awdUpgrFrom: 'BBBBBB',
            awdUpgrTo: 'BBBBBB',
            hkExpectedServiceTime: 'BBBBBB',
            roomInstructions: 'BBBBBB',
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            reservationDate: currentDate,
            cancellationDate: currentDate,
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

      it('should not return a list of ReservationDailyElements', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a ReservationDailyElements', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a ReservationDailyElements', async () => {
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
