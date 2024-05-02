/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ReservationNameUpdate from './reservation-name-update.vue';
import ReservationNameService from './reservation-name.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationNameUpdateComponentType = InstanceType<typeof ReservationNameUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const reservationNameSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ReservationNameUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ReservationName Management Update Component', () => {
    let comp: ReservationNameUpdateComponentType;
    let reservationNameServiceStub: SinonStubbedInstance<ReservationNameService>;

    beforeEach(() => {
      route = {};
      reservationNameServiceStub = sinon.createStubInstance<ReservationNameService>(ReservationNameService);
      reservationNameServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          reservationNameService: () => reservationNameServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ReservationNameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.reservationName = reservationNameSample;
        reservationNameServiceStub.update.resolves(reservationNameSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(reservationNameServiceStub.update.calledWith(reservationNameSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        reservationNameServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ReservationNameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.reservationName = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(reservationNameServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        reservationNameServiceStub.find.resolves(reservationNameSample);
        reservationNameServiceStub.retrieve.resolves([reservationNameSample]);

        // WHEN
        route = {
          params: {
            reservationNameId: '' + reservationNameSample.id,
          },
        };
        const wrapper = shallowMount(ReservationNameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.reservationName).toMatchObject(reservationNameSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        reservationNameServiceStub.find.resolves(reservationNameSample);
        const wrapper = shallowMount(ReservationNameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
