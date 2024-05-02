/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ResortOriginsOfBookingDetails from './resort-origins-of-booking-details.vue';
import ResortOriginsOfBookingService from './resort-origins-of-booking.service';
import AlertService from '@/shared/alert/alert.service';

type ResortOriginsOfBookingDetailsComponentType = InstanceType<typeof ResortOriginsOfBookingDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const resortOriginsOfBookingSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('ResortOriginsOfBooking Management Detail Component', () => {
    let resortOriginsOfBookingServiceStub: SinonStubbedInstance<ResortOriginsOfBookingService>;
    let mountOptions: MountingOptions<ResortOriginsOfBookingDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      resortOriginsOfBookingServiceStub = sinon.createStubInstance<ResortOriginsOfBookingService>(ResortOriginsOfBookingService);

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
          resortOriginsOfBookingService: () => resortOriginsOfBookingServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        resortOriginsOfBookingServiceStub.find.resolves(resortOriginsOfBookingSample);
        route = {
          params: {
            resortOriginsOfBookingId: '' + 123,
          },
        };
        const wrapper = shallowMount(ResortOriginsOfBookingDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.resortOriginsOfBooking).toMatchObject(resortOriginsOfBookingSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        resortOriginsOfBookingServiceStub.find.resolves(resortOriginsOfBookingSample);
        const wrapper = shallowMount(ResortOriginsOfBookingDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
