/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import ReservationSummaryService from './reservation-summary.service';
import { DATE_FORMAT } from '@/shared/composables/date-format';
import { ReservationSummary } from '@/shared/model/reservation-summary.model';

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
  describe('ReservationSummary Service', () => {
    let service: ReservationSummaryService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new ReservationSummaryService();
      currentDate = new Date();
      elemDefault = new ReservationSummary(
        123,
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
        0,
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
        0,
        0,
        0,
        0,
        'AAAAAAA',
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
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
        0,
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
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
        0,
        0,
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
        0,
        0,
        0,
        'AAAAAAA',
        currentDate,
        currentDate,
        currentDate,
        'AAAAAAA',
        0,
        currentDate,
        currentDate,
        currentDate,
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            consideredDate: dayjs(currentDate).format(DATE_FORMAT),
            exchangeDate: dayjs(currentDate).format(DATE_FORMAT),
            updateBusinessDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            truncBeginDate: dayjs(currentDate).format(DATE_FORMAT),
            truncEndDate: dayjs(currentDate).format(DATE_FORMAT),
            businessDateCreated: dayjs(currentDate).format(DATE_FORMAT),
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

      it('should create a ReservationSummary', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            consideredDate: dayjs(currentDate).format(DATE_FORMAT),
            exchangeDate: dayjs(currentDate).format(DATE_FORMAT),
            updateBusinessDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            truncBeginDate: dayjs(currentDate).format(DATE_FORMAT),
            truncEndDate: dayjs(currentDate).format(DATE_FORMAT),
            businessDateCreated: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            consideredDate: currentDate,
            exchangeDate: currentDate,
            updateBusinessDate: currentDate,
            updateDate: currentDate,
            truncBeginDate: currentDate,
            truncEndDate: currentDate,
            businessDateCreated: currentDate,
          },
          returnedFromService,
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a ReservationSummary', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a ReservationSummary', async () => {
        const returnedFromService = Object.assign(
          {
            resort: 'BBBBBB',
            eventType: 'BBBBBB',
            eventId: 'BBBBBB',
            consideredDate: dayjs(currentDate).format(DATE_FORMAT),
            roomCategory: 'BBBBBB',
            roomClass: 'BBBBBB',
            marketCode: 'BBBBBB',
            sourceCode: 'BBBBBB',
            rateCode: 'BBBBBB',
            regionCode: 'BBBBBB',
            groupId: 1,
            resvType: 'BBBBBB',
            resvInvType: 'BBBBBB',
            psuedoRoomYn: 'BBBBBB',
            arrRooms: 1,
            adults: 1,
            children: 1,
            depRooms: 1,
            noRooms: 1,
            grossRate: 1,
            netRoomRevenue: 1,
            extraRevenue: 1,
            ooRooms: 1,
            osRooms: 1,
            remainingBlockRooms: 1,
            pickedupBlockRooms: 1,
            singleOccupancy: 1,
            multipleOccupancy: 1,
            blockStatus: 'BBBBBB',
            arrPersons: 1,
            depPersons: 1,
            wlRooms: 1,
            wlPersons: 1,
            dayUseRooms: 1,
            dayUsePersons: 1,
            bookingStatus: 'BBBBBB',
            resvStatus: 'BBBBBB',
            dayUseYn: 'BBBBBB',
            channel: 'BBBBBB',
            country: 'BBBBBB',
            nationality: 'BBBBBB',
            cribs: 1,
            extraBeds: 1,
            adultsTaxFree: 1,
            childrenTaxFree: 1,
            rateCategory: 'BBBBBB',
            rateClass: 'BBBBBB',
            roomRevenue: 1,
            foodRevenue: 1,
            otherRevenue: 1,
            totalRevenue: 1,
            nonRevenue: 1,
            allotmentHeaderId: 1,
            roomRevenueTax: 1,
            foodRevenueTax: 1,
            otherRevenueTax: 1,
            totalRevenueTax: 1,
            nonRevenueTax: 1,
            city: 'BBBBBB',
            zipCode: 'BBBBBB',
            district: 'BBBBBB',
            state: 'BBBBBB',
            children1: 1,
            children2: 1,
            children3: 1,
            children4: 1,
            children5: 1,
            ownerFfFlag: 'BBBBBB',
            ownerRentalFlag: 'BBBBBB',
            fcGrossRate: 1,
            fcNetRoomRevenue: 1,
            fcExtraRevenue: 1,
            fcRoomRevenue: 1,
            fcFoodRevenue: 1,
            fcOtherRevenue: 1,
            fcTotalRevenue: 1,
            fcNonRevenue: 1,
            fcRoomRevenueTax: 1,
            fcFoodRevenueTax: 1,
            fcOtherRevenueTax: 1,
            fcTotalRevenueTax: 1,
            fcNonRevenueTax: 1,
            currencyCode: 'BBBBBB',
            exchangeDate: dayjs(currentDate).format(DATE_FORMAT),
            updateBusinessDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            centralCurrencyCode: 'BBBBBB',
            centralExchangeRate: 1,
            truncBeginDate: dayjs(currentDate).format(DATE_FORMAT),
            truncEndDate: dayjs(currentDate).format(DATE_FORMAT),
            businessDateCreated: dayjs(currentDate).format(DATE_FORMAT),
            resInsertSource: 'BBBBBB',
            parentCompanyId: 1,
            agentId: 1,
            gender: 'BBBBBB',
            vipStatus: 'BBBBBB',
            quantity: 1,
            turndownStatus: 'BBBBBB',
            bookedRoomCategory: 'BBBBBB',
            sourceProfId: 1,
          },
          elemDefault,
        );

        const expected = Object.assign(
          {
            consideredDate: currentDate,
            exchangeDate: currentDate,
            updateBusinessDate: currentDate,
            updateDate: currentDate,
            truncBeginDate: currentDate,
            truncEndDate: currentDate,
            businessDateCreated: currentDate,
          },
          returnedFromService,
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a ReservationSummary', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a ReservationSummary', async () => {
        const patchObject = Object.assign(
          {
            eventType: 'BBBBBB',
            marketCode: 'BBBBBB',
            sourceCode: 'BBBBBB',
            rateCode: 'BBBBBB',
            groupId: 1,
            arrRooms: 1,
            children: 1,
            depRooms: 1,
            noRooms: 1,
            grossRate: 1,
            netRoomRevenue: 1,
            ooRooms: 1,
            pickedupBlockRooms: 1,
            singleOccupancy: 1,
            multipleOccupancy: 1,
            blockStatus: 'BBBBBB',
            dayUseRooms: 1,
            bookingStatus: 'BBBBBB',
            dayUseYn: 'BBBBBB',
            channel: 'BBBBBB',
            country: 'BBBBBB',
            nationality: 'BBBBBB',
            cribs: 1,
            rateCategory: 'BBBBBB',
            roomRevenue: 1,
            otherRevenue: 1,
            nonRevenue: 1,
            foodRevenueTax: 1,
            nonRevenueTax: 1,
            district: 'BBBBBB',
            children2: 1,
            children3: 1,
            children5: 1,
            ownerRentalFlag: 'BBBBBB',
            fcFoodRevenue: 1,
            fcOtherRevenue: 1,
            fcTotalRevenue: 1,
            fcFoodRevenueTax: 1,
            exchangeDate: dayjs(currentDate).format(DATE_FORMAT),
            truncBeginDate: dayjs(currentDate).format(DATE_FORMAT),
            resInsertSource: 'BBBBBB',
            agentId: 1,
            quantity: 1,
            bookedRoomCategory: 'BBBBBB',
            sourceProfId: 1,
          },
          new ReservationSummary(),
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            consideredDate: currentDate,
            exchangeDate: currentDate,
            updateBusinessDate: currentDate,
            updateDate: currentDate,
            truncBeginDate: currentDate,
            truncEndDate: currentDate,
            businessDateCreated: currentDate,
          },
          returnedFromService,
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a ReservationSummary', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of ReservationSummary', async () => {
        const returnedFromService = Object.assign(
          {
            resort: 'BBBBBB',
            eventType: 'BBBBBB',
            eventId: 'BBBBBB',
            consideredDate: dayjs(currentDate).format(DATE_FORMAT),
            roomCategory: 'BBBBBB',
            roomClass: 'BBBBBB',
            marketCode: 'BBBBBB',
            sourceCode: 'BBBBBB',
            rateCode: 'BBBBBB',
            regionCode: 'BBBBBB',
            groupId: 1,
            resvType: 'BBBBBB',
            resvInvType: 'BBBBBB',
            psuedoRoomYn: 'BBBBBB',
            arrRooms: 1,
            adults: 1,
            children: 1,
            depRooms: 1,
            noRooms: 1,
            grossRate: 1,
            netRoomRevenue: 1,
            extraRevenue: 1,
            ooRooms: 1,
            osRooms: 1,
            remainingBlockRooms: 1,
            pickedupBlockRooms: 1,
            singleOccupancy: 1,
            multipleOccupancy: 1,
            blockStatus: 'BBBBBB',
            arrPersons: 1,
            depPersons: 1,
            wlRooms: 1,
            wlPersons: 1,
            dayUseRooms: 1,
            dayUsePersons: 1,
            bookingStatus: 'BBBBBB',
            resvStatus: 'BBBBBB',
            dayUseYn: 'BBBBBB',
            channel: 'BBBBBB',
            country: 'BBBBBB',
            nationality: 'BBBBBB',
            cribs: 1,
            extraBeds: 1,
            adultsTaxFree: 1,
            childrenTaxFree: 1,
            rateCategory: 'BBBBBB',
            rateClass: 'BBBBBB',
            roomRevenue: 1,
            foodRevenue: 1,
            otherRevenue: 1,
            totalRevenue: 1,
            nonRevenue: 1,
            allotmentHeaderId: 1,
            roomRevenueTax: 1,
            foodRevenueTax: 1,
            otherRevenueTax: 1,
            totalRevenueTax: 1,
            nonRevenueTax: 1,
            city: 'BBBBBB',
            zipCode: 'BBBBBB',
            district: 'BBBBBB',
            state: 'BBBBBB',
            children1: 1,
            children2: 1,
            children3: 1,
            children4: 1,
            children5: 1,
            ownerFfFlag: 'BBBBBB',
            ownerRentalFlag: 'BBBBBB',
            fcGrossRate: 1,
            fcNetRoomRevenue: 1,
            fcExtraRevenue: 1,
            fcRoomRevenue: 1,
            fcFoodRevenue: 1,
            fcOtherRevenue: 1,
            fcTotalRevenue: 1,
            fcNonRevenue: 1,
            fcRoomRevenueTax: 1,
            fcFoodRevenueTax: 1,
            fcOtherRevenueTax: 1,
            fcTotalRevenueTax: 1,
            fcNonRevenueTax: 1,
            currencyCode: 'BBBBBB',
            exchangeDate: dayjs(currentDate).format(DATE_FORMAT),
            updateBusinessDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            centralCurrencyCode: 'BBBBBB',
            centralExchangeRate: 1,
            truncBeginDate: dayjs(currentDate).format(DATE_FORMAT),
            truncEndDate: dayjs(currentDate).format(DATE_FORMAT),
            businessDateCreated: dayjs(currentDate).format(DATE_FORMAT),
            resInsertSource: 'BBBBBB',
            parentCompanyId: 1,
            agentId: 1,
            gender: 'BBBBBB',
            vipStatus: 'BBBBBB',
            quantity: 1,
            turndownStatus: 'BBBBBB',
            bookedRoomCategory: 'BBBBBB',
            sourceProfId: 1,
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            consideredDate: currentDate,
            exchangeDate: currentDate,
            updateBusinessDate: currentDate,
            updateDate: currentDate,
            truncBeginDate: currentDate,
            truncEndDate: currentDate,
            businessDateCreated: currentDate,
          },
          returnedFromService,
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of ReservationSummary', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a ReservationSummary', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a ReservationSummary', async () => {
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
