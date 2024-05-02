/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ResortOriginsOfBookingUpdate from './resort-origins-of-booking-update.vue';
import ResortOriginsOfBookingService from './resort-origins-of-booking.service';
import AlertService from '@/shared/alert/alert.service';

type ResortOriginsOfBookingUpdateComponentType = InstanceType<typeof ResortOriginsOfBookingUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const resortOriginsOfBookingSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ResortOriginsOfBookingUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ResortOriginsOfBooking Management Update Component', () => {
    let comp: ResortOriginsOfBookingUpdateComponentType;
    let resortOriginsOfBookingServiceStub: SinonStubbedInstance<ResortOriginsOfBookingService>;

    beforeEach(() => {
      route = {};
      resortOriginsOfBookingServiceStub = sinon.createStubInstance<ResortOriginsOfBookingService>(ResortOriginsOfBookingService);
      resortOriginsOfBookingServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          resortOriginsOfBookingService: () => resortOriginsOfBookingServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ResortOriginsOfBookingUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.resortOriginsOfBooking = resortOriginsOfBookingSample;
        resortOriginsOfBookingServiceStub.update.resolves(resortOriginsOfBookingSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(resortOriginsOfBookingServiceStub.update.calledWith(resortOriginsOfBookingSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        resortOriginsOfBookingServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ResortOriginsOfBookingUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.resortOriginsOfBooking = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(resortOriginsOfBookingServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        resortOriginsOfBookingServiceStub.find.resolves(resortOriginsOfBookingSample);
        resortOriginsOfBookingServiceStub.retrieve.resolves([resortOriginsOfBookingSample]);

        // WHEN
        route = {
          params: {
            resortOriginsOfBookingId: '' + resortOriginsOfBookingSample.id,
          },
        };
        const wrapper = shallowMount(ResortOriginsOfBookingUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.resortOriginsOfBooking).toMatchObject(resortOriginsOfBookingSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        resortOriginsOfBookingServiceStub.find.resolves(resortOriginsOfBookingSample);
        const wrapper = shallowMount(ResortOriginsOfBookingUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
