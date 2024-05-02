/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import ReservationDailyElementNameService from './reservation-daily-element-name.service';
import { DATE_FORMAT } from '@/shared/composables/date-format';
import { ReservationDailyElementName } from '@/shared/model/reservation-daily-element-name.model';

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
  describe('ReservationDailyElementName Service', () => {
    let service: ReservationDailyElementNameService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new ReservationDailyElementNameService();
      currentDate = new Date();
      elemDefault = new ReservationDailyElementName(
        123,
        'AAAAAAA',
        0,
        currentDate,
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
        0,
        0,
        0,
        0,
        currentDate,
        0,
        currentDate,
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
        'AAAAAAA',
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
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        0,
        0,
        0,
        0,
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

      it('should create a ReservationDailyElementName', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            reservationDate: dayjs(currentDate).format(DATE_FORMAT),
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            reservationDate: currentDate,
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

      it('should not create a ReservationDailyElementName', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a ReservationDailyElementName', async () => {
        const returnedFromService = Object.assign(
          {
            resort: 'BBBBBB',
            resvNameId: 1,
            reservationDate: dayjs(currentDate).format(DATE_FORMAT),
            resvDailyElSeq: 1,
            travelAgentId: 1,
            companyId: 1,
            sourceId: 1,
            groupId: 1,
            sharePaymentType: 'BBBBBB',
            shareAmount: 1,
            sharePrcnt: 1,
            adults: 1,
            children: 1,
            discountAmt: 1,
            discountPrcnt: 1,
            discountReasonCode: 'BBBBBB',
            fixedRateYn: 'BBBBBB',
            baseRateAmount: 1,
            autoPostAmount: 1,
            sharePriority: 1,
            insertUser: 1,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            lastShareCalculation: 'BBBBBB',
            insertActionInstanceId: 1,
            dmlSeqNo: 1,
            netRoomAmt: 1,
            roomTax: 1,
            pkgAmt: 1,
            pkgTax: 1,
            grossRateAmt: 1,
            adultsTaxFree: 1,
            childrenTaxFree: 1,
            children1: 1,
            children2: 1,
            children3: 1,
            rateCode: 'BBBBBB',
            currencyCode: 'BBBBBB',
            exchangePostingType: 'BBBBBB',
            membershipPoints: 1,
            children4: 1,
            children5: 1,
            commissionCode: 'BBBBBB',
            awardCode1: 'BBBBBB',
            awardCode2: 'BBBBBB',
            awardCode3: 'BBBBBB',
            awardCode4: 'BBBBBB',
            awardCode5: 'BBBBBB',
            awardVoucher1: 'BBBBBB',
            awardVoucher2: 'BBBBBB',
            awardVoucher3: 'BBBBBB',
            awardVoucher4: 'BBBBBB',
            awardVoucher5: 'BBBBBB',
            doNotMoveYn: 'BBBBBB',
            awardCode: 'BBBBBB',
            points: 1,
            upsellCharge: 1,
            pointsEligibilityCode: 'BBBBBB',
            commissionPaid: 1,
            resvContactId: 1,
            billingContactId: 1,
            shareAmountOriginal: 1,
            referralYn: 'BBBBBB',
            bxgyDiscountYn: 'BBBBBB',
            commissionableYn: 'BBBBBB',
            basedOnRule: 'BBBBBB',
          },
          elemDefault,
        );

        const expected = Object.assign(
          {
            reservationDate: currentDate,
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

      it('should not update a ReservationDailyElementName', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a ReservationDailyElementName', async () => {
        const patchObject = Object.assign(
          {
            resort: 'BBBBBB',
            resvNameId: 1,
            travelAgentId: 1,
            companyId: 1,
            sourceId: 1,
            sharePaymentType: 'BBBBBB',
            shareAmount: 1,
            sharePrcnt: 1,
            discountAmt: 1,
            discountPrcnt: 1,
            fixedRateYn: 'BBBBBB',
            baseRateAmount: 1,
            sharePriority: 1,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            lastShareCalculation: 'BBBBBB',
            insertActionInstanceId: 1,
            dmlSeqNo: 1,
            pkgTax: 1,
            grossRateAmt: 1,
            children1: 1,
            rateCode: 'BBBBBB',
            currencyCode: 'BBBBBB',
            exchangePostingType: 'BBBBBB',
            membershipPoints: 1,
            children5: 1,
            commissionCode: 'BBBBBB',
            awardCode1: 'BBBBBB',
            awardCode3: 'BBBBBB',
            awardCode4: 'BBBBBB',
            awardVoucher1: 'BBBBBB',
            awardVoucher2: 'BBBBBB',
            awardVoucher5: 'BBBBBB',
            awardCode: 'BBBBBB',
            points: 1,
            upsellCharge: 1,
            billingContactId: 1,
            bxgyDiscountYn: 'BBBBBB',
            commissionableYn: 'BBBBBB',
          },
          new ReservationDailyElementName(),
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            reservationDate: currentDate,
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

      it('should not partial update a ReservationDailyElementName', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of ReservationDailyElementName', async () => {
        const returnedFromService = Object.assign(
          {
            resort: 'BBBBBB',
            resvNameId: 1,
            reservationDate: dayjs(currentDate).format(DATE_FORMAT),
            resvDailyElSeq: 1,
            travelAgentId: 1,
            companyId: 1,
            sourceId: 1,
            groupId: 1,
            sharePaymentType: 'BBBBBB',
            shareAmount: 1,
            sharePrcnt: 1,
            adults: 1,
            children: 1,
            discountAmt: 1,
            discountPrcnt: 1,
            discountReasonCode: 'BBBBBB',
            fixedRateYn: 'BBBBBB',
            baseRateAmount: 1,
            autoPostAmount: 1,
            sharePriority: 1,
            insertUser: 1,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            lastShareCalculation: 'BBBBBB',
            insertActionInstanceId: 1,
            dmlSeqNo: 1,
            netRoomAmt: 1,
            roomTax: 1,
            pkgAmt: 1,
            pkgTax: 1,
            grossRateAmt: 1,
            adultsTaxFree: 1,
            childrenTaxFree: 1,
            children1: 1,
            children2: 1,
            children3: 1,
            rateCode: 'BBBBBB',
            currencyCode: 'BBBBBB',
            exchangePostingType: 'BBBBBB',
            membershipPoints: 1,
            children4: 1,
            children5: 1,
            commissionCode: 'BBBBBB',
            awardCode1: 'BBBBBB',
            awardCode2: 'BBBBBB',
            awardCode3: 'BBBBBB',
            awardCode4: 'BBBBBB',
            awardCode5: 'BBBBBB',
            awardVoucher1: 'BBBBBB',
            awardVoucher2: 'BBBBBB',
            awardVoucher3: 'BBBBBB',
            awardVoucher4: 'BBBBBB',
            awardVoucher5: 'BBBBBB',
            doNotMoveYn: 'BBBBBB',
            awardCode: 'BBBBBB',
            points: 1,
            upsellCharge: 1,
            pointsEligibilityCode: 'BBBBBB',
            commissionPaid: 1,
            resvContactId: 1,
            billingContactId: 1,
            shareAmountOriginal: 1,
            referralYn: 'BBBBBB',
            bxgyDiscountYn: 'BBBBBB',
            commissionableYn: 'BBBBBB',
            basedOnRule: 'BBBBBB',
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            reservationDate: currentDate,
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

      it('should not return a list of ReservationDailyElementName', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a ReservationDailyElementName', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a ReservationDailyElementName', async () => {
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
