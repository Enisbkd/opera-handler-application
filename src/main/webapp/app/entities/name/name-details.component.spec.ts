/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import NameDetails from './name-details.vue';
import NameService from './name.service';
import AlertService from '@/shared/alert/alert.service';

type NameDetailsComponentType = InstanceType<typeof NameDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const nameSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('Name Management Detail Component', () => {
    let nameServiceStub: SinonStubbedInstance<NameService>;
    let mountOptions: MountingOptions<NameDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      nameServiceStub = sinon.createStubInstance<NameService>(NameService);

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
          nameService: () => nameServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        nameServiceStub.find.resolves(nameSample);
        route = {
          params: {
            nameId: '' + 123,
          },
        };
        const wrapper = shallowMount(NameDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.name).toMatchObject(nameSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        nameServiceStub.find.resolves(nameSample);
        const wrapper = shallowMount(NameDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
