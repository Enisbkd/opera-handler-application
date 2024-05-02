/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ReservationNameDetails from './reservation-name-details.vue';
import ReservationNameService from './reservation-name.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationNameDetailsComponentType = InstanceType<typeof ReservationNameDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const reservationNameSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('ReservationName Management Detail Component', () => {
    let reservationNameServiceStub: SinonStubbedInstance<ReservationNameService>;
    let mountOptions: MountingOptions<ReservationNameDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      reservationNameServiceStub = sinon.createStubInstance<ReservationNameService>(ReservationNameService);

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
          reservationNameService: () => reservationNameServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        reservationNameServiceStub.find.resolves(reservationNameSample);
        route = {
          params: {
            reservationNameId: '' + 123,
          },
        };
        const wrapper = shallowMount(ReservationNameDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.reservationName).toMatchObject(reservationNameSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        reservationNameServiceStub.find.resolves(reservationNameSample);
        const wrapper = shallowMount(ReservationNameDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
