import { defineComponent, inject, ref, type Ref } from 'vue';
import { useI18n } from 'vue-i18n';
import { useRoute, useRouter } from 'vue-router';

import FinancialTransactionsService from './financial-transactions.service';
import { type IFinancialTransactions } from '@/shared/model/financial-transactions.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'FinancialTransactionsDetails',
  setup() {
    const financialTransactionsService = inject('financialTransactionsService', () => new FinancialTransactionsService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);
    const financialTransactions: Ref<IFinancialTransactions> = ref({});

    const retrieveFinancialTransactions = async financialTransactionsId => {
      try {
        const res = await financialTransactionsService().find(financialTransactionsId);
        financialTransactions.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.financialTransactionsId) {
      retrieveFinancialTransactions(route.params.financialTransactionsId);
    }

    return {
      alertService,
      financialTransactions,

      previousState,
      t$: useI18n().t,
    };
  },
});
