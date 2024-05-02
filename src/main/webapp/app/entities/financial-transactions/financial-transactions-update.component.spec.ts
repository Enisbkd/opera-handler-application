/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import FinancialTransactionsUpdate from './financial-transactions-update.vue';
import FinancialTransactionsService from './financial-transactions.service';
import AlertService from '@/shared/alert/alert.service';

type FinancialTransactionsUpdateComponentType = InstanceType<typeof FinancialTransactionsUpdate>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const financialTransactionsSample = { id: 123 };

describe('Component Tests', () => {
  let mountOptions: MountingOptions<FinancialTransactionsUpdateComponentType>['global'];
  let alertService: AlertService;

  describe('FinancialTransactions Management Update Component', () => {
    let comp: FinancialTransactionsUpdateComponentType;
    let financialTransactionsServiceStub: SinonStubbedInstance<FinancialTransactionsService>;

    beforeEach(() => {
      route = {};
      financialTransactionsServiceStub = sinon.createStubInstance<FinancialTransactionsService>(FinancialTransactionsService);
      financialTransactionsServiceStub.retrieve.onFirstCall().resolves(Promise.resolve([]));

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
          financialTransactionsService: () => financialTransactionsServiceStub,
        },
      };
    });

    afterEach(() => {
      vitest.resetAllMocks();
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const wrapper = shallowMount(FinancialTransactionsUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.financialTransactions = financialTransactionsSample;
        financialTransactionsServiceStub.update.resolves(financialTransactionsSample);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(financialTransactionsServiceStub.update.calledWith(financialTransactionsSample)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        financialTransactionsServiceStub.create.resolves(entity);
        const wrapper = shallowMount(FinancialTransactionsUpdate, { global: mountOptions });
        comp = wrapper.vm;
        comp.financialTransactions = entity;

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(financialTransactionsServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        financialTransactionsServiceStub.find.resolves(financialTransactionsSample);
        financialTransactionsServiceStub.retrieve.resolves([financialTransactionsSample]);

        // WHEN
        route = {
          params: {
            financialTransactionsId: '' + financialTransactionsSample.id,
          },
        };
        const wrapper = shallowMount(FinancialTransactionsUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(comp.financialTransactions).toMatchObject(financialTransactionsSample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        financialTransactionsServiceStub.find.resolves(financialTransactionsSample);
        const wrapper = shallowMount(FinancialTransactionsUpdate, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
