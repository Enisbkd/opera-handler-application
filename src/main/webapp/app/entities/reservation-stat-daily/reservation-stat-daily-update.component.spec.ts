/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ReservationStatDailyUpdate from './reservation-stat-daily-update.vue';
import ReservationStatDailyService from './reservation-stat-daily.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationStatDailyUpdateComponentType = InstanceType<typeof ReservationStatDailyUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const reservationStatDailySample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ReservationStatDailyUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ReservationStatDaily Management Update Component', () => {
    let comp: ReservationStatDailyUpdateComponentType;
    let reservationStatDailyServiceStub: SinonStubbedInstance<ReservationStatDailyService>;

    beforeEach(() => {
      route = {};
      reservationStatDailyServiceStub = sinon.createStubInstance<ReservationStatDailyService>(ReservationStatDailyService);
      reservationStatDailyServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          reservationStatDailyService: () => reservationStatDailyServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ReservationStatDailyUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.reservationStatDaily = reservationStatDailySample;
        reservationStatDailyServiceStub.update.resolves(reservationStatDailySample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(reservationStatDailyServiceStub.update.calledWith(reservationStatDailySample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        reservationStatDailyServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ReservationStatDailyUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.reservationStatDaily = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(reservationStatDailyServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        reservationStatDailyServiceStub.find.resolves(reservationStatDailySample);
        reservationStatDailyServiceStub.retrieve.resolves([reservationStatDailySample]);

        // WHEN
        route = {
          params: {
            reservationStatDailyId: '' + reservationStatDailySample.id,
          },
        };
        const wrapper = shallowMount(ReservationStatDailyUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.reservationStatDaily).toMatchObject(reservationStatDailySample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        reservationStatDailyServiceStub.find.resolves(reservationStatDailySample);
        const wrapper = shallowMount(ReservationStatDailyUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
