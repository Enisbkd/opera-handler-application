/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import NamePhoneUpdate from './name-phone-update.vue';
import NamePhoneService from './name-phone.service';
import AlertService from '@/shared/alert/alert.service';

type NamePhoneUpdateComponentType = InstanceType<typeof NamePhoneUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const namePhoneSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<NamePhoneUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('NamePhone Management Update Component', () => {
    let comp: NamePhoneUpdateComponentType;
    let namePhoneServiceStub: SinonStubbedInstance<NamePhoneService>;

    beforeEach(() => {
      route = {};
      namePhoneServiceStub = sinon.createStubInstance<NamePhoneService>(NamePhoneService);
      namePhoneServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          namePhoneService: () => namePhoneServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(NamePhoneUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.namePhone = namePhoneSample;
        namePhoneServiceStub.update.resolves(namePhoneSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(namePhoneServiceStub.update.calledWith(namePhoneSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        namePhoneServiceStub.create.resolves(entity);
        const wrapper = shallowMount(NamePhoneUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.namePhone = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(namePhoneServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        namePhoneServiceStub.find.resolves(namePhoneSample);
        namePhoneServiceStub.retrieve.resolves([namePhoneSample]);

        // WHEN
        route = {
          params: {
            namePhoneId: '' + namePhoneSample.id,
          },
        };
        const wrapper = shallowMount(NamePhoneUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.namePhone).toMatchObject(namePhoneSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        namePhoneServiceStub.find.resolves(namePhoneSample);
        const wrapper = shallowMount(NamePhoneUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
