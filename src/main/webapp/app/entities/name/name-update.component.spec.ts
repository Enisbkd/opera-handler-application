/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import NameUpdate from './name-update.vue';
import NameService from './name.service';
import AlertService from '@/shared/alert/alert.service';

type NameUpdateComponentType = InstanceType<typeof NameUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const nameSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<NameUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('Name Management Update Component', () => {
    let comp: NameUpdateComponentType;
    let nameServiceStub: SinonStubbedInstance<NameService>;

    beforeEach(() => {
      route = {};
      nameServiceStub = sinon.createStubInstance<NameService>(NameService);
      nameServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          nameService: () => nameServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(NameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.name = nameSample;
        nameServiceStub.update.resolves(nameSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(nameServiceStub.update.calledWith(nameSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        nameServiceStub.create.resolves(entity);
        const wrapper = shallowMount(NameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.name = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(nameServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        nameServiceStub.find.resolves(nameSample);
        nameServiceStub.retrieve.resolves([nameSample]);

        // WHEN
        route = {
          params: {
            nameId: '' + nameSample.id,
          },
        };
        const wrapper = shallowMount(NameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.name).toMatchObject(nameSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        nameServiceStub.find.resolves(nameSample);
        const wrapper = shallowMount(NameUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
