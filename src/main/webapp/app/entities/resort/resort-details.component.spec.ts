/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import ResortDetails from './resort-details.vue';
import ResortService from './resort.service';
import AlertService from '@/shared/alert/alert.service';

type ResortDetailsComponentType = InstanceType<typeof ResortDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const resortSample = { id: 'ABC' };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('Resort Management Detail Component', () => {
    let resortServiceStub: SinonStubbedInstance<ResortService>;
    let mountOptions: MountingOptions<ResortDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      resortServiceStub = sinon.createStubInstance<ResortService>(ResortService);

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
          resortService: () => resortServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        resortServiceStub.find.resolves(resortSample);
        route = {
          params: {
            resortId: '' + 'ABC',
          },
        };
        const wrapper = shallowMount(ResortDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.resort).toMatchObject(resortSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        resortServiceStub.find.resolves(resortSample);
        const wrapper = shallowMount(ResortDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
