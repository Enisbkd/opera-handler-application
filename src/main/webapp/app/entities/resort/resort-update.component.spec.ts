/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import dayjs from 'dayjs';
import ResortUpdate from './resort-update.vue';
import ResortService from './resort.service';
import { DATE_TIME_LONG_FORMAT } from '@/shared/composables/date-format';
import AlertService from '@/shared/alert/alert.service';

type ResortUpdateComponentType = InstanceType<typeof ResortUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const resortSample = { id: 'ABC' };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ResortUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('Resort Management Update Component', () => {
    let comp: ResortUpdateComponentType;
    let resortServiceStub: SinonStubbedInstance<ResortService>;

    beforeEach(() => {
      route = {};
      resortServiceStub = sinon.createStubInstance<ResortService>(ResortService);
      resortServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          resortService: () => resortServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('load', () => {
      beforeEach(() => {
        const wrapper = shallowMount(ResortUpdate, { global: mountOptions });
        comp = wrapper.vm;
      });
      it('Should convert date from string', () => {
        // GIVEN
        const date = new Date('2019-10-15T11:42:02Z');

        // WHEN
        const convertedDate = comp.convertDateTimeFromServer(date);

        // THEN
        expect(convertedDate).toEqual(dayjs(date).format(DATE_TIME_LONG_FORMAT));
      });

      it('Should not convert date if date is not present', () => {
        expect(comp.convertDateTimeFromServer(null)).toBeNull();
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ResortUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.resort = resortSample;
        resortServiceStub.update.resolves(resortSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(resortServiceStub.update.calledWith(resortSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        resortServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ResortUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.resort = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(resortServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        resortServiceStub.find.resolves(resortSample);
        resortServiceStub.retrieve.resolves([resortSample]);

        // WHEN
        route = {
          params: {
            resortId: '' + resortSample.id,
          },
        };
        const wrapper = shallowMount(ResortUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.resort).toMatchObject(resortSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        resortServiceStub.find.resolves(resortSample);
        const wrapper = shallowMount(ResortUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
