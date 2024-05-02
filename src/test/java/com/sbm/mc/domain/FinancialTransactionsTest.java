package com.sbm.mc.domain;

import static com.sbm.mc.domain.FinancialTransactionsTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.sbm.mc.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class FinancialTransactionsTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FinancialTransactions.class);
        FinancialTransactions financialTransactions1 = getFinancialTransactionsSample1();
        FinancialTransactions financialTransactions2 = new FinancialTransactions();
        assertThat(financialTransactions1).isNotEqualTo(financialTransactions2);

        financialTransactions2.setId(financialTransactions1.getId());
        assertThat(financialTransactions1).isEqualTo(financialTransactions2);

        financialTransactions2 = getFinancialTransactionsSample2();
        assertThat(financialTransactions1).isNotEqualTo(financialTransactions2);
    }
}
