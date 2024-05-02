/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ReservationSummaryUpdate from './reservation-summary-update.vue';
import ReservationSummaryService from './reservation-summary.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationSummaryUpdateComponentType = InstanceType<typeof ReservationSummaryUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const reservationSummarySample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ReservationSummaryUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ReservationSummary Management Update Component', () => {
    let comp: ReservationSummaryUpdateComponentType;
    let reservationSummaryServiceStub: SinonStubbedInstance<ReservationSummaryService>;

    beforeEach(() => {
      route = {};
      reservationSummaryServiceStub = sinon.createStubInstance<ReservationSummaryService>(ReservationSummaryService);
      reservationSummaryServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

      alertService = new AlertService({
        i18n: { t: vitest.fn() } as any,
        bvToast: {
          toast: vitest.fn(),
        } as any,
      });

      mountOptions = {
        stubs: {
          'font-awesome-icon': true,
          'b-input-group': true,
          'b-input-group-prepend': true,
          'b-form-datepicker': true,
          'b-form-input': true,
        },
        provide: {
          alertService,
          reservationSummaryService: () => reservationSummaryServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ReservationSummaryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.reservationSummary = reservationSummarySample;
        reservationSummaryServiceStub.update.resolves(reservationSummarySample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(reservationSummaryServiceStub.update.calledWith(reservationSummarySample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        reservationSummaryServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ReservationSummaryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.reservationSummary = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(reservationSummaryServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        reservationSummaryServiceStub.find.resolves(reservationSummarySample);
        reservationSummaryServiceStub.retrieve.resolves([reservationSummarySample]);

        // WHEN
        route = {
          params: {
            reservationSummaryId: '' + reservationSummarySample.id,
          },
        };
        const wrapper = shallowMount(ReservationSummaryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.reservationSummary).toMatchObject(reservationSummarySample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        reservationSummaryServiceStub.find.resolves(reservationSummarySample);
        const wrapper = shallowMount(ReservationSummaryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
