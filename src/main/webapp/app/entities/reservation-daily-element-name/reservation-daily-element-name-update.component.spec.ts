/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ReservationDailyElementNameUpdate from './reservation-daily-element-name-update.vue';
import ReservationDailyElementNameService from './reservation-daily-element-name.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationDailyElementNameUpdateComponentType = InstanceType<typeof ReservationDailyElementNameUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const reservationDailyElementNameSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ReservationDailyElementNameUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ReservationDailyElementName Management Update Component', () => {
    let comp: ReservationDailyElementNameUpdateComponentType;
    let reservationDailyElementNameServiceStub: SinonStubbedInstance<ReservationDailyElementNameService>;

    beforeEach(() => {
      route = {};
      reservationDailyElementNameServiceStub =
        sinon.createStubInstance<ReservationDailyElementNameService>(ReservationDailyElementNameService);
      reservationDailyElementNameServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          reservationDailyElementNameService: () => reservationDailyElementNameServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ReservationDailyElementNameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.reservationDailyElementName = reservationDailyElementNameSample;
        reservationDailyElementNameServiceStub.update.resolves(reservationDailyElementNameSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementNameServiceStub.update.calledWith(reservationDailyElementNameSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        reservationDailyElementNameServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ReservationDailyElementNameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.reservationDailyElementName = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementNameServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        reservationDailyElementNameServiceStub.find.resolves(reservationDailyElementNameSample);
        reservationDailyElementNameServiceStub.retrieve.resolves([reservationDailyElementNameSample]);

        // WHEN
        route = {
          params: {
            reservationDailyElementNameId: '' + reservationDailyElementNameSample.id,
          },
        };
        const wrapper = shallowMount(ReservationDailyElementNameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.reservationDailyElementName).toMatchObject(reservationDailyElementNameSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        reservationDailyElementNameServiceStub.find.resolves(reservationDailyElementNameSample);
        const wrapper = shallowMount(ReservationDailyElementNameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
