/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ReservationDailyElementsDetails from './reservation-daily-elements-details.vue';
import ReservationDailyElementsService from './reservation-daily-elements.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationDailyElementsDetailsComponentType = InstanceType<typeof ReservationDailyElementsDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const reservationDailyElementsSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('ReservationDailyElements Management Detail Component', () => {
    let reservationDailyElementsServiceStub: SinonStubbedInstance<ReservationDailyElementsService>;
    let mountOptions: MountingOptions<ReservationDailyElementsDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      reservationDailyElementsServiceStub = sinon.createStubInstance<ReservationDailyElementsService>(ReservationDailyElementsService);

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
          reservationDailyElementsService: () => reservationDailyElementsServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        reservationDailyElementsServiceStub.find.resolves(reservationDailyElementsSample);
        route = {
          params: {
            reservationDailyElementsId: '' + 123,
          },
        };
        const wrapper = shallowMount(ReservationDailyElementsDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.reservationDailyElements).toMatchObject(reservationDailyElementsSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        reservationDailyElementsServiceStub.find.resolves(reservationDailyElementsSample);
        const wrapper = shallowMount(ReservationDailyElementsDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
