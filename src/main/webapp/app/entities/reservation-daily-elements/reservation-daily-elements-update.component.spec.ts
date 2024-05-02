/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ReservationDailyElementsUpdate from './reservation-daily-elements-update.vue';
import ReservationDailyElementsService from './reservation-daily-elements.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationDailyElementsUpdateComponentType = InstanceType<typeof ReservationDailyElementsUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const reservationDailyElementsSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ReservationDailyElementsUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ReservationDailyElements Management Update Component', () => {
    let comp: ReservationDailyElementsUpdateComponentType;
    let reservationDailyElementsServiceStub: SinonStubbedInstance<ReservationDailyElementsService>;

    beforeEach(() => {
      route = {};
      reservationDailyElementsServiceStub = sinon.createStubInstance<ReservationDailyElementsService>(ReservationDailyElementsService);
      reservationDailyElementsServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          reservationDailyElementsService: () => reservationDailyElementsServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ReservationDailyElementsUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.reservationDailyElements = reservationDailyElementsSample;
        reservationDailyElementsServiceStub.update.resolves(reservationDailyElementsSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementsServiceStub.update.calledWith(reservationDailyElementsSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        reservationDailyElementsServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ReservationDailyElementsUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.reservationDailyElements = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementsServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        reservationDailyElementsServiceStub.find.resolves(reservationDailyElementsSample);
        reservationDailyElementsServiceStub.retrieve.resolves([reservationDailyElementsSample]);

        // WHEN
        route = {
          params: {
            reservationDailyElementsId: '' + reservationDailyElementsSample.id,
          },
        };
        const wrapper = shallowMount(ReservationDailyElementsUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.reservationDailyElements).toMatchObject(reservationDailyElementsSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        reservationDailyElementsServiceStub.find.resolves(reservationDailyElementsSample);
        const wrapper = shallowMount(ReservationDailyElementsUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
