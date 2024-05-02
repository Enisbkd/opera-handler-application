/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import FinancialTransactionsDetails from './financial-transactions-details.vue';
import FinancialTransactionsService from './financial-transactions.service';
import AlertService from '@/shared/alert/alert.service';

type FinancialTransactionsDetailsComponentType = InstanceType<typeof FinancialTransactionsDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const financialTransactionsSample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('FinancialTransactions Management Detail Component', () => {
    let financialTransactionsServiceStub: SinonStubbedInstance<FinancialTransactionsService>;
    let mountOptions: MountingOptions<FinancialTransactionsDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      financialTransactionsServiceStub = sinon.createStubInstance<FinancialTransactionsService>(FinancialTransactionsService);

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
          financialTransactionsService: () => financialTransactionsServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        financialTransactionsServiceStub.find.resolves(financialTransactionsSample);
        route = {
          params: {
            financialTransactionsId: '' + 123,
          },
        };
        const wrapper = shallowMount(FinancialTransactionsDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.financialTransactions).toMatchObject(financialTransactionsSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        financialTransactionsServiceStub.find.resolves(financialTransactionsSample);
        const wrapper = shallowMount(FinancialTransactionsDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
