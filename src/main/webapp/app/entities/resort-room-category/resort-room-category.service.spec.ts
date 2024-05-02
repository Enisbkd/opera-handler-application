/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import ResortRoomCategoryService from './resort-room-category.service';
import { DATE_FORMAT } from '@/shared/composables/date-format';
import { ResortRoomCategory } from '@/shared/model/resort-room-category.model';

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
  describe('ResortRoomCategory Service', () => {
    let service: ResortRoomCategoryService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new ResortRoomCategoryService();
      currentDate = new Date();
      elemDefault = new ResortRoomCategory(
        123,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        'AAAAAAA',
        0,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        currentDate,
        0,
        currentDate,
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
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
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
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            activeDate: dayjs(currentDate).format(DATE_FORMAT),
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

      it('should create a ResortRoomCategory', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            activeDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            activeDate: currentDate,
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

      it('should not create a ResortRoomCategory', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a ResortRoomCategory', async () => {
        const returnedFromService = Object.assign(
          {
            resort: 'BBBBBB',
            roomCategory: 'BBBBBB',
            roomClass: 'BBBBBB',
            numberRooms: 1,
            shortDescription: 'BBBBBB',
            longDescription: 'BBBBBB',
            compiled: 'BBBBBB',
            psuedoRoomType: 'BBBBBB',
            activeDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            replacesCategory: 'BBBBBB',
            orderBy: 1,
            maxOccupancy: 1,
            maxRollaways: 1,
            rateCategory: 'BBBBBB',
            label: 'BBBBBB',
            genericFlag: 'BBBBBB',
            suiteYn: 'BBBBBB',
            meetingroomYn: 'BBBBBB',
            insertUser: 1,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            rateCode: 'BBBBBB',
            rateAmount: 1,
            defOccupancy: 1,
            imageId: 1,
            pseudoYn: 'BBBBBB',
            sendToInterfaceYn: 'BBBBBB',
            yieldableYn: 'BBBBBB',
            yieldCategory: 'BBBBBB',
            housekeeping: 'BBBBBB',
            canDeleteYn: 'BBBBBB',
            roominfoUrl: 'BBBBBB',
            ownerYn: 'BBBBBB',
            autoIncludeYn: 'BBBBBB',
            initialRoundUp: 1,
            increments: 1,
            rotationGroup: 'BBBBBB',
            salesFlag: 'BBBBBB',
            autoRoomAssignYn: 'BBBBBB',
            upsellYn: 'BBBBBB',
            ormsUpsellRank: 1,
            ormsUpsellAmt: 1,
            ormsDrxtraAdult: 1,
            ormsDrxtraChild: 1,
            maxOccupancyAdults: 1,
            maxOccupancyChildren: 1,
            roomPool: 'BBBBBB',
            memberAwardRoomGrp: 'BBBBBB',
            ormsDrxtra2ndAdult: 1,
            ormsDrtier1: 1,
            ormsDrtier2: 1,
            ormsDrtier3: 1,
            autoCheckinYn: 'BBBBBB',
            rateFloor: 1,
            maxFixBedOccupancy: 1,
            maintenanceYn: 'BBBBBB',
            smokingPreference: 'BBBBBB',
            sLabel: 'BBBBBB',
            sBedtype: 'BBBBBB',
            sellThruRuleYn: 'BBBBBB',
            crsDescription: 'BBBBBB',
            evisitorFacilityId: 'BBBBBB',
            minOccupancy: 1,
            accessibleYn: 'BBBBBB',
          },
          elemDefault,
        );

        const expected = Object.assign(
          {
            activeDate: currentDate,
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

      it('should not update a ResortRoomCategory', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a ResortRoomCategory', async () => {
        const patchObject = Object.assign(
          {
            roomClass: 'BBBBBB',
            compiled: 'BBBBBB',
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            replacesCategory: 'BBBBBB',
            orderBy: 1,
            maxOccupancy: 1,
            maxRollaways: 1,
            rateCategory: 'BBBBBB',
            label: 'BBBBBB',
            genericFlag: 'BBBBBB',
            suiteYn: 'BBBBBB',
            meetingroomYn: 'BBBBBB',
            insertUser: 1,
            updateUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            rateCode: 'BBBBBB',
            defOccupancy: 1,
            yieldableYn: 'BBBBBB',
            canDeleteYn: 'BBBBBB',
            initialRoundUp: 1,
            rotationGroup: 'BBBBBB',
            upsellYn: 'BBBBBB',
            ormsUpsellRank: 1,
            ormsUpsellAmt: 1,
            ormsDrxtraAdult: 1,
            maxOccupancyAdults: 1,
            maxOccupancyChildren: 1,
            ormsDrtier1: 1,
            ormsDrtier2: 1,
            rateFloor: 1,
            maintenanceYn: 'BBBBBB',
            smokingPreference: 'BBBBBB',
            sLabel: 'BBBBBB',
            crsDescription: 'BBBBBB',
            minOccupancy: 1,
          },
          new ResortRoomCategory(),
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            activeDate: currentDate,
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

      it('should not partial update a ResortRoomCategory', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of ResortRoomCategory', async () => {
        const returnedFromService = Object.assign(
          {
            resort: 'BBBBBB',
            roomCategory: 'BBBBBB',
            roomClass: 'BBBBBB',
            numberRooms: 1,
            shortDescription: 'BBBBBB',
            longDescription: 'BBBBBB',
            compiled: 'BBBBBB',
            psuedoRoomType: 'BBBBBB',
            activeDate: dayjs(currentDate).format(DATE_FORMAT),
            inactiveDate: dayjs(currentDate).format(DATE_FORMAT),
            replacesCategory: 'BBBBBB',
            orderBy: 1,
            maxOccupancy: 1,
            maxRollaways: 1,
            rateCategory: 'BBBBBB',
            label: 'BBBBBB',
            genericFlag: 'BBBBBB',
            suiteYn: 'BBBBBB',
            meetingroomYn: 'BBBBBB',
            insertUser: 1,
            insertDate: dayjs(currentDate).format(DATE_FORMAT),
            updateUser: 1,
            updateDate: dayjs(currentDate).format(DATE_FORMAT),
            rateCode: 'BBBBBB',
            rateAmount: 1,
            defOccupancy: 1,
            imageId: 1,
            pseudoYn: 'BBBBBB',
            sendToInterfaceYn: 'BBBBBB',
            yieldableYn: 'BBBBBB',
            yieldCategory: 'BBBBBB',
            housekeeping: 'BBBBBB',
            canDeleteYn: 'BBBBBB',
            roominfoUrl: 'BBBBBB',
            ownerYn: 'BBBBBB',
            autoIncludeYn: 'BBBBBB',
            initialRoundUp: 1,
            increments: 1,
            rotationGroup: 'BBBBBB',
            salesFlag: 'BBBBBB',
            autoRoomAssignYn: 'BBBBBB',
            upsellYn: 'BBBBBB',
            ormsUpsellRank: 1,
            ormsUpsellAmt: 1,
            ormsDrxtraAdult: 1,
            ormsDrxtraChild: 1,
            maxOccupancyAdults: 1,
            maxOccupancyChildren: 1,
            roomPool: 'BBBBBB',
            memberAwardRoomGrp: 'BBBBBB',
            ormsDrxtra2ndAdult: 1,
            ormsDrtier1: 1,
            ormsDrtier2: 1,
            ormsDrtier3: 1,
            autoCheckinYn: 'BBBBBB',
            rateFloor: 1,
            maxFixBedOccupancy: 1,
            maintenanceYn: 'BBBBBB',
            smokingPreference: 'BBBBBB',
            sLabel: 'BBBBBB',
            sBedtype: 'BBBBBB',
            sellThruRuleYn: 'BBBBBB',
            crsDescription: 'BBBBBB',
            evisitorFacilityId: 'BBBBBB',
            minOccupancy: 1,
            accessibleYn: 'BBBBBB',
          },
          elemDefault,
        );
        const expected = Object.assign(
          {
            activeDate: currentDate,
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

      it('should not return a list of ResortRoomCategory', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a ResortRoomCategory', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a ResortRoomCategory', async () => {
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
