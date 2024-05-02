/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ReservationDailyElementNameDetails from './reservation-daily-element-name-details.vue';
import ReservationDailyElementNameService from './reservation-daily-element-name.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationDailyElementNameDetailsComponentType = InstanceType<typeof ReservationDailyElementNameDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const reservationDailyElementNameSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('ReservationDailyElementName Management Detail Component', () => {
    let reservationDailyElementNameServiceStub: SinonStubbedInstance<ReservationDailyElementNameService>;
    let mountOptions: MountingOptions<ReservationDailyElementNameDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      reservationDailyElementNameServiceStub =
        sinon.createStubInstance<ReservationDailyElementNameService>(ReservationDailyElementNameService);

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
          reservationDailyElementNameService: () => reservationDailyElementNameServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        reservationDailyElementNameServiceStub.find.resolves(reservationDailyElementNameSample);
        route = {
          params: {
            reservationDailyElementNameId: '' + 123,
          },
        };
        const wrapper = shallowMount(ReservationDailyElementNameDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.reservationDailyElementName).toMatchObject(reservationDailyElementNameSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        reservationDailyElementNameServiceStub.find.resolves(reservationDailyElementNameSample);
        const wrapper = shallowMount(ReservationDailyElementNameDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
