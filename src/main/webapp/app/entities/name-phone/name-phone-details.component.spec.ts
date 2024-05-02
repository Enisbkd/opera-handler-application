/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import NamePhoneDetails from './name-phone-details.vue';
import NamePhoneService from './name-phone.service';
import AlertService from '@/shared/alert/alert.service';

type NamePhoneDetailsComponentType = InstanceType<typeof NamePhoneDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const namePhoneSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('NamePhone Management Detail Component', () => {
    let namePhoneServiceStub: SinonStubbedInstance<NamePhoneService>;
    let mountOptions: MountingOptions<NamePhoneDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      namePhoneServiceStub = sinon.createStubInstance<NamePhoneService>(NamePhoneService);

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
          namePhoneService: () => namePhoneServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        namePhoneServiceStub.find.resolves(namePhoneSample);
        route = {
          params: {
            namePhoneId: '' + 123,
          },
        };
        const wrapper = shallowMount(NamePhoneDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.namePhone).toMatchObject(namePhoneSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        namePhoneServiceStub.find.resolves(namePhoneSample);
        const wrapper = shallowMount(NamePhoneDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
