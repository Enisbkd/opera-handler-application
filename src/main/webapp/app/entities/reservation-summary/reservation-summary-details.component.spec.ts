/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ReservationSummaryDetails from './reservation-summary-details.vue';
import ReservationSummaryService from './reservation-summary.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationSummaryDetailsComponentType = InstanceType<typeof ReservationSummaryDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const reservationSummarySample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('ReservationSummary Management Detail Component', () => {
    let reservationSummaryServiceStub: SinonStubbedInstance<ReservationSummaryService>;
    let mountOptions: MountingOptions<ReservationSummaryDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      reservationSummaryServiceStub = sinon.createStubInstance<ReservationSummaryService>(ReservationSummaryService);

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
          reservationSummaryService: () => reservationSummaryServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        reservationSummaryServiceStub.find.resolves(reservationSummarySample);
        route = {
          params: {
            reservationSummaryId: '' + 123,
          },
        };
        const wrapper = shallowMount(ReservationSummaryDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.reservationSummary).toMatchObject(reservationSummarySample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        reservationSummaryServiceStub.find.resolves(reservationSummarySample);
        const wrapper = shallowMount(ReservationSummaryDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
