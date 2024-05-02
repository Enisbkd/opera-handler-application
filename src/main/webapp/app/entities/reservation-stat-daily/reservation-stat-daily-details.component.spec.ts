/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ReservationStatDailyDetails from './reservation-stat-daily-details.vue';
import ReservationStatDailyService from './reservation-stat-daily.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationStatDailyDetailsComponentType = InstanceType<typeof ReservationStatDailyDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const reservationStatDailySample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('ReservationStatDaily Management Detail Component', () => {
    let reservationStatDailyServiceStub: SinonStubbedInstance<ReservationStatDailyService>;
    let mountOptions: MountingOptions<ReservationStatDailyDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      reservationStatDailyServiceStub = sinon.createStubInstance<ReservationStatDailyService>(ReservationStatDailyService);

      alertService = new AlertService({
        i18n: { t: vitest.fn() } as any,
        bvToast: {
          toast: vitest.fn(),
        } as any,
      });

      mountOptions = {
        stubs: {
          'font-awesome-icon': true,
          'router-link': true,
        },
        provide: {
          alertService,
          reservationStatDailyService: () => reservationStatDailyServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        reservationStatDailyServiceStub.find.resolves(reservationStatDailySample);
        route = {
          params: {
            reservationStatDailyId: '' + 123,
          },
        };
        const wrapper = shallowMount(ReservationStatDailyDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.reservationStatDaily).toMatchObject(reservationStatDailySample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        reservationStatDailyServiceStub.find.resolves(reservationStatDailySample);
        const wrapper = shallowMount(ReservationStatDailyDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
