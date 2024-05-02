/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ResortRoomCategoryUpdate from './resort-room-category-update.vue';
import ResortRoomCategoryService from './resort-room-category.service';
import AlertService from '@/shared/alert/alert.service';

type ResortRoomCategoryUpdateComponentType = InstanceType<typeof ResortRoomCategoryUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const resortRoomCategorySample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<ResortRoomCategoryUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('ResortRoomCategory Management Update Component', () => {
    let comp: ResortRoomCategoryUpdateComponentType;
    let resortRoomCategoryServiceStub: SinonStubbedInstance<ResortRoomCategoryService>;

    beforeEach(() => {
      route = {};
      resortRoomCategoryServiceStub = sinon.createStubInstance<ResortRoomCategoryService>(ResortRoomCategoryService);
      resortRoomCategoryServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          resortRoomCategoryService: () => resortRoomCategoryServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(ResortRoomCategoryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.resortRoomCategory = resortRoomCategorySample;
        resortRoomCategoryServiceStub.update.resolves(resortRoomCategorySample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(resortRoomCategoryServiceStub.update.calledWith(resortRoomCategorySample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        resortRoomCategoryServiceStub.create.resolves(entity);
        const wrapper = shallowMount(ResortRoomCategoryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.resortRoomCategory = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(resortRoomCategoryServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        resortRoomCategoryServiceStub.find.resolves(resortRoomCategorySample);
        resortRoomCategoryServiceStub.retrieve.resolves([resortRoomCategorySample]);

        // WHEN
        route = {
          params: {
            resortRoomCategoryId: '' + resortRoomCategorySample.id,
          },
        };
        const wrapper = shallowMount(ResortRoomCategoryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.resortRoomCategory).toMatchObject(resortRoomCategorySample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        resortRoomCategoryServiceStub.find.resolves(resortRoomCategorySample);
        const wrapper = shallowMount(ResortRoomCategoryUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
