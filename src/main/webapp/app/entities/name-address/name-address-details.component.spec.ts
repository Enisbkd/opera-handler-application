/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import NameAddressDetails from './name-address-details.vue';
import NameAddressService from './name-address.service';
import AlertService from '@/shared/alert/alert.service';

type NameAddressDetailsComponentType = InstanceType<typeof NameAddressDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const nameAddressSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('NameAddress Management Detail Component', () => {
    let nameAddressServiceStub: SinonStubbedInstance<NameAddressService>;
    let mountOptions: MountingOptions<NameAddressDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      nameAddressServiceStub = sinon.createStubInstance<NameAddressService>(NameAddressService);

      alertService = new AlertService({
        i18n: { t: vitest.fn() } as any,
        bvToast: {
          toast: vitest.fn(),
        } as any,
      });

      mountOptions = {
        stubs: {
          'font-awesome-icon': true,
          'router-link': true,
        },
        provide: {
          alertService,
          nameAddressService: () => nameAddressServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        nameAddressServiceStub.find.resolves(nameAddressSample);
        route = {
          params: {
            nameAddressId: '' + 123,
          },
        };
        const wrapper = shallowMount(NameAddressDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.nameAddress).toMatchObject(nameAddressSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        nameAddressServiceStub.find.resolves(nameAddressSample);
        const wrapper = shallowMount(NameAddressDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
