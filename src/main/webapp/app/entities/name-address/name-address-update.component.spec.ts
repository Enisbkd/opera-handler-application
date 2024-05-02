/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import NameAddressUpdate from './name-address-update.vue';
import NameAddressService from './name-address.service';
import AlertService from '@/shared/alert/alert.service';

type NameAddressUpdateComponentType = InstanceType<typeof NameAddressUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const nameAddressSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<NameAddressUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('NameAddress Management Update Component', () => {
    let comp: NameAddressUpdateComponentType;
    let nameAddressServiceStub: SinonStubbedInstance<NameAddressService>;

    beforeEach(() => {
      route = {};
      nameAddressServiceStub = sinon.createStubInstance<NameAddressService>(NameAddressService);
      nameAddressServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          nameAddressService: () => nameAddressServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(NameAddressUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.nameAddress = nameAddressSample;
        nameAddressServiceStub.update.resolves(nameAddressSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(nameAddressServiceStub.update.calledWith(nameAddressSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        nameAddressServiceStub.create.resolves(entity);
        const wrapper = shallowMount(NameAddressUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.nameAddress = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(nameAddressServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        nameAddressServiceStub.find.resolves(nameAddressSample);
        nameAddressServiceStub.retrieve.resolves([nameAddressSample]);

        // WHEN
        route = {
          params: {
            nameAddressId: '' + nameAddressSample.id,
          },
        };
        const wrapper = shallowMount(NameAddressUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.nameAddress).toMatchObject(nameAddressSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        nameAddressServiceStub.find.resolves(nameAddressSample);
        const wrapper = shallowMount(NameAddressUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
