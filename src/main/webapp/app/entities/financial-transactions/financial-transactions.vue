<template>
  <div>
    <h2 id="page-heading" data-cy="FinancialTransactionsHeading">
      <span v-text="t$('operaHandlerApplicationApp.financialTransactions.home.title')" id="financial-transactions-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.financialTransactions.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'FinancialTransactionsCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-financial-transactions"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && financialTransactions && financialTransactions.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.financialTransactions.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="financialTransactions && financialTransactions.length > 0">
      <table class="table table-striped" aria-describedby="financialTransactions">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trxNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trxNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ftSubtype')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.ftSubtype')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ftSubtype'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('invoiceCloseDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.invoiceCloseDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'invoiceCloseDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arTransferDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arTransferDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arTransferDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trxDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trxDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('businessDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.businessDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'businessDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trnsActivityDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trnsActivityDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trnsActivityDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('approvalDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.approvalDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'approvalDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postingDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postingDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postingDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('exchangeDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exchangeDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('routingDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.routingDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'routingDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('effectiveDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.effectiveDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'effectiveDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('customChargeDate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.customChargeDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'customChargeDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('recptNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.recptNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'recptNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trxNoAdjust')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoAdjust')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trxNoAdjust'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trxNoAddedBy')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoAddedBy')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trxNoAddedBy'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trxNoAgainstPackage')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoAgainstPackage')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trxNoAgainstPackage'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trxNoHeader')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoHeader')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trxNoHeader'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arNumber')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvNameId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.resvNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cashierId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cashierId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('creditCardId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.creditCardId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'creditCardId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.nameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tranActionId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.tranActionId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tranActionId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('finDmlSeqNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.finDmlSeqNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'finDmlSeqNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('routingInstrnId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.routingInstrnId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'routingInstrnId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fromResvId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.fromResvId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fromResvId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('genCashierId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.genCashierId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'genCashierId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.folioNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('invoiceNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.invoiceNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'invoiceNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arrangementId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arrangementId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arrangementId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trnsFromAcct')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trnsFromAcct')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trnsFromAcct'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trnsToAcct')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trnsToAcct')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trnsToAcct'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('billNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.billNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'billNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('revisionNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.revisionNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'revisionNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvDepositId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.resvDepositId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvDepositId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('linkTrxNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.linkTrxNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'linkTrxNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('authorizerId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.authorizerId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'authorizerId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('compLinkTrxNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.compLinkTrxNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'compLinkTrxNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mtrxNoAgainstPackage')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.mtrxNoAgainstPackage')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mtrxNoAgainstPackage'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('forexCommPerc')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.forexCommPerc')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'forexCommPerc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('forexCommAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.forexCommAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'forexCommAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('articleId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.articleId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'articleId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('toResvNameId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.toResvNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'toResvNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomNts')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.roomNts')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomNts'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('orgArLedDebit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.orgArLedDebit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'orgArLedDebit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('closureNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.closureNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'closureNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('originalResvNameId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.originalResvNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'originalResvNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('orgBillNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.orgBillNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'orgBillNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('membershipId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.membershipId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'membershipId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('installments')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.installments')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'installments'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contractGuestDebit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.contractGuestDebit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contractGuestDebit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contractGuestCredit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.contractGuestCredit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contractGuestCredit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contractNetAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.contractNetAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contractNetAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contractGrossAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.contractGrossAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contractGrossAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postitNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postitNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postitNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ccTrxFeeAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.ccTrxFeeAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ccTrxFeeAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('changeDue')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.changeDue')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'changeDue'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postingSourceNameId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postingSourceNameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postingSourceNameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bonusCheckId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.bonusCheckId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bonusCheckId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roundLinkTrxno')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.roundLinkTrxno')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roundLinkTrxno'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reversePaymentTrxNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.reversePaymentTrxNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reversePaymentTrxNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('electronicVoucherNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.electronicVoucherNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'electronicVoucherNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('thresholdDiversionId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdDiversionId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'thresholdDiversionId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('thresholdEntityQty')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdEntityQty')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'thresholdEntityQty'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trxNoSplit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoSplit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trxNoSplit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('exchDiffTrxNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.exchDiffTrxNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exchDiffTrxNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('associatedTrxNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.associatedTrxNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'associatedTrxNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxRate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxRate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('propChargeId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.propChargeId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'propChargeId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('quantity')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.quantity')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'quantity'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('netAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.netAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'netAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('grossAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.grossAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'grossAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cashierOpeningBalance')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierOpeningBalance')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cashierOpeningBalance'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('pricePerUnit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.pricePerUnit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'pricePerUnit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trxAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trxAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postedAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postedAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postedAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestAccountCredit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.guestAccountCredit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestAccountCredit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('exchangeRate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeRate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exchangeRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guestAccountDebit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.guestAccountDebit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guestAccountDebit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cashierCredit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierCredit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cashierCredit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cashierDebit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierDebit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cashierDebit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageCredit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.packageCredit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageCredit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageDebit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.packageDebit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageDebit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('depLedCredit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.depLedCredit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'depLedCredit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('depLedDebit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.depLedDebit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'depLedDebit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('revenueAmt')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.revenueAmt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'revenueAmt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arLedCredit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arLedCredit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arLedCredit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arLedDebit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arLedDebit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arLedDebit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('euroExchangeRate')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.euroExchangeRate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'euroExchangeRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inhDebit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.inhDebit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inhDebit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inhCredit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.inhCredit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inhCredit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageAllowance')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.packageAllowance')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageAllowance'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('parallelGuestCredit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelGuestCredit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'parallelGuestCredit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('parallelGuestDebit')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelGuestDebit')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'parallelGuestDebit'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('parallelNetAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelNetAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'parallelNetAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('parallelGrossAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelGrossAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'parallelGrossAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('orgPostedAmount')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.orgPostedAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'orgPostedAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomNtsEffective')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.roomNtsEffective')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomNtsEffective'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('paymentSurchargeAmt')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.paymentSurchargeAmt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'paymentSurchargeAmt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioView')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.folioView')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioView'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxInclusiveYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxInclusiveYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxInclusiveYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('deferredYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.deferredYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'deferredYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('indAdjustmentYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.indAdjustmentYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'indAdjustmentYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fixedChargesYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.fixedChargesYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fixedChargesYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taCommissionableYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taCommissionableYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taCommissionableYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxGeneratedYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxGeneratedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxGeneratedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('compressedYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.compressedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'compressedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('displayYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.displayYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'displayYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('collAgentPostingYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.collAgentPostingYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'collAgentPostingYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fiscalTrxCodeType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.fiscalTrxCodeType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fiscalTrxCodeType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('deferredTaxesYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.deferredTaxesYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'deferredTaxesYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advancedGenerateYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.advancedGenerateYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advancedGenerateYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('forexType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.forexType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'forexType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taCommissionNetYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taCommissionNetYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taCommissionNetYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sourceCommissionNetYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.sourceCommissionNetYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sourceCommissionNetYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('settlementFlag')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.settlementFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'settlementFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('accTypeFlag')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.accTypeFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'accTypeFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('profitLossFlag')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.profitLossFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'profitLossFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('proformaYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.proformaYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'proformaYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('holdYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.holdYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'holdYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('exchangeDifferenceYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeDifferenceYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exchangeDifferenceYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('calcPointsYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.calcPointsYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'calcPointsYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arChargeTransferYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arChargeTransferYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arChargeTransferYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('processed8300Yn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.processed8300Yn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'processed8300Yn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('asbFlag')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.asbFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'asbFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postitYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postitYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postitYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('autoSettleYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.autoSettleYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoSettleYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('depTaxTransferedYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.depTaxTransferedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'depTaxTransferedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('autoCreditbillYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.autoCreditbillYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoCreditbillYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('asbOnlyPostTaxesOnceYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.asbOnlyPostTaxesOnceYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'asbOnlyPostTaxesOnceYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roundFactorYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.roundFactorYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roundFactorYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('depPostingFlag')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.depPostingFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'depPostingFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('correctionYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.correctionYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'correctionYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('routedYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.routedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'routedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('upsellChargeYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.upsellChargeYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'upsellChargeYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advanceBillYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.advanceBillYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advanceBillYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advanceBillReversedYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.advanceBillReversedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advanceBillReversedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('incTaxDeductedYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.incTaxDeductedYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'incTaxDeductedYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('gpAwardCancelledYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.gpAwardCancelledYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'gpAwardCancelledYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('serviceRecoveryAdjustmentYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.serviceRecoveryAdjustmentYn')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'serviceRecoveryAdjustmentYn'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('splitType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.splitType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'splitType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bucketRedempYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.bucketRedempYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bucketRedempYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('vatOffsetYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.vatOffsetYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'vatOffsetYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('forexTaxYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.forexTaxYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'forexTaxYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stampDutyYn')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.stampDutyYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stampDutyYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('covers')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.covers')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'covers'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advGenerateAdjustment')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.advGenerateAdjustment')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advGenerateAdjustment'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('expInvoiceType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.expInvoiceType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'expInvoiceType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('folioType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.folioType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'folioType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('orgFolioType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.orgFolioType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'orgFolioType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('invoiceType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.invoiceType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'invoiceType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('arState')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arState')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'arState'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('exchangeType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exchangeType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('recptType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.recptType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'recptType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomClass')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.roomClass')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomClass'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resort')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.resort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tcGroup')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.tcGroup')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcGroup'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tcSubgroup')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.tcSubgroup')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tcSubgroup'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trxCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trxCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('room')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.room')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'room'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tclCode1')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.tclCode1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tclCode1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('currency')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.currency')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'currency'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ftGeneratedType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.ftGeneratedType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ftGeneratedType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('tclCode2')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.tclCode2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tclCode2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('marketCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.marketCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'marketCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sourceCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.sourceCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sourceCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.rateCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hotelAcct')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.hotelAcct')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hotelAcct'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reasonCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.reasonCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reasonCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('product')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.product')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'product'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('targetResort')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.targetResort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'targetResort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameTaxType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.nameTaxType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameTaxType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxInvNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxInvNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxInvNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('approvalCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.approvalCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'approvalCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('approvalStatus')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.approvalStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'approvalStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('compLinkTrxCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.compLinkTrxCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'compLinkTrxCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('compTypeCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.compTypeCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'compTypeCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('couponNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.couponNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'couponNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('originalRoom')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.originalRoom')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'originalRoom'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('allowanceType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.allowanceType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'allowanceType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('advGenerateTrxCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.advGenerateTrxCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'advGenerateTrxCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('trxServiceType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxServiceType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'trxServiceType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postingType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postingType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postingType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('parallelCurrency')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelCurrency')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'parallelCurrency'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('contractCurrency')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.contractCurrency')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'contractCurrency'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fbaCertificateNumber')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.fbaCertificateNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fbaCertificateNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('postingRhythm')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postingRhythm')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'postingRhythm'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('asbTaxFlag')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.asbTaxFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'asbTaxFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageArrangementCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.packageArrangementCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageArrangementCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('gpAwardCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.gpAwardCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'gpAwardCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('gpAwardCancelCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.gpAwardCancelCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'gpAwardCancelCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('serviceRecoveryDeptCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.serviceRecoveryDeptCode')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'serviceRecoveryDeptCode'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bucketCode')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.bucketCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bucketCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxRateType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxRateType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxRateType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('chequeNumber')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.chequeNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'chequeNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('passerByName')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.passerByName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'passerByName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('esignedReceiptName')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.esignedReceiptName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'esignedReceiptName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('remark')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.remark')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'remark'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reference')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.reference')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reference'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('oTrxDesc')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.oTrxDesc')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'oTrxDesc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('comments')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.comments')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'comments'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('fiscalBillNo')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.fiscalBillNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fiscalBillNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extSysResultMsg')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.extSysResultMsg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extSysResultMsg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('queueName')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.queueName')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'queueName'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('paymentType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.paymentType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'paymentType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('ccRefundPosting')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.ccRefundPosting')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ccRefundPosting'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('thresholdEntityType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdEntityType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'thresholdEntityType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('thresholdTreatmentFlag')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdTreatmentFlag')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'thresholdTreatmentFlag'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('paymentSurchargeType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.paymentSurchargeType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'paymentSurchargeType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('propertyBillPrefix')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.propertyBillPrefix')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'propertyBillPrefix'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('taxElements')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxElements')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'taxElements'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('numberDialed')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.numberDialed')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'numberDialed'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('checkFileId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.checkFileId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'checkFileId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extTrxId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.extTrxId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extTrxId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('packageTrxType')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.packageTrxType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'packageTrxType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('expOriginalInvoice')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.expOriginalInvoice')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'expOriginalInvoice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('depositTransactionId')">
              <span v-text="t$('operaHandlerApplicationApp.financialTransactions.depositTransactionId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'depositTransactionId'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="financialTransactions in financialTransactions" :key="financialTransactions.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'FinancialTransactionsView', params: { financialTransactionsId: financialTransactions.id } }">{{
                financialTransactions.id
              }}</router-link>
            </td>
            <td>{{ financialTransactions.trxNo }}</td>
            <td>{{ financialTransactions.ftSubtype }}</td>
            <td>{{ financialTransactions.invoiceCloseDate }}</td>
            <td>{{ financialTransactions.arTransferDate }}</td>
            <td>{{ financialTransactions.trxDate }}</td>
            <td>{{ financialTransactions.businessDate }}</td>
            <td>{{ financialTransactions.insertDate }}</td>
            <td>{{ financialTransactions.updateDate }}</td>
            <td>{{ financialTransactions.trnsActivityDate }}</td>
            <td>{{ financialTransactions.approvalDate }}</td>
            <td>{{ financialTransactions.postingDate }}</td>
            <td>{{ financialTransactions.exchangeDate }}</td>
            <td>{{ financialTransactions.routingDate }}</td>
            <td>{{ financialTransactions.effectiveDate }}</td>
            <td>{{ financialTransactions.customChargeDate }}</td>
            <td>{{ financialTransactions.recptNo }}</td>
            <td>{{ financialTransactions.trxNoAdjust }}</td>
            <td>{{ financialTransactions.trxNoAddedBy }}</td>
            <td>{{ financialTransactions.trxNoAgainstPackage }}</td>
            <td>{{ financialTransactions.trxNoHeader }}</td>
            <td>{{ financialTransactions.arNumber }}</td>
            <td>{{ financialTransactions.resvNameId }}</td>
            <td>{{ financialTransactions.cashierId }}</td>
            <td>{{ financialTransactions.creditCardId }}</td>
            <td>{{ financialTransactions.nameId }}</td>
            <td>{{ financialTransactions.tranActionId }}</td>
            <td>{{ financialTransactions.finDmlSeqNo }}</td>
            <td>{{ financialTransactions.routingInstrnId }}</td>
            <td>{{ financialTransactions.fromResvId }}</td>
            <td>{{ financialTransactions.genCashierId }}</td>
            <td>{{ financialTransactions.folioNo }}</td>
            <td>{{ financialTransactions.invoiceNo }}</td>
            <td>{{ financialTransactions.insertUser }}</td>
            <td>{{ financialTransactions.updateUser }}</td>
            <td>{{ financialTransactions.arrangementId }}</td>
            <td>{{ financialTransactions.trnsFromAcct }}</td>
            <td>{{ financialTransactions.trnsToAcct }}</td>
            <td>{{ financialTransactions.billNo }}</td>
            <td>{{ financialTransactions.revisionNo }}</td>
            <td>{{ financialTransactions.resvDepositId }}</td>
            <td>{{ financialTransactions.linkTrxNo }}</td>
            <td>{{ financialTransactions.authorizerId }}</td>
            <td>{{ financialTransactions.compLinkTrxNo }}</td>
            <td>{{ financialTransactions.mtrxNoAgainstPackage }}</td>
            <td>{{ financialTransactions.forexCommPerc }}</td>
            <td>{{ financialTransactions.forexCommAmount }}</td>
            <td>{{ financialTransactions.articleId }}</td>
            <td>{{ financialTransactions.toResvNameId }}</td>
            <td>{{ financialTransactions.roomNts }}</td>
            <td>{{ financialTransactions.orgArLedDebit }}</td>
            <td>{{ financialTransactions.closureNo }}</td>
            <td>{{ financialTransactions.originalResvNameId }}</td>
            <td>{{ financialTransactions.orgBillNo }}</td>
            <td>{{ financialTransactions.membershipId }}</td>
            <td>{{ financialTransactions.installments }}</td>
            <td>{{ financialTransactions.contractGuestDebit }}</td>
            <td>{{ financialTransactions.contractGuestCredit }}</td>
            <td>{{ financialTransactions.contractNetAmount }}</td>
            <td>{{ financialTransactions.contractGrossAmount }}</td>
            <td>{{ financialTransactions.postitNo }}</td>
            <td>{{ financialTransactions.ccTrxFeeAmount }}</td>
            <td>{{ financialTransactions.changeDue }}</td>
            <td>{{ financialTransactions.postingSourceNameId }}</td>
            <td>{{ financialTransactions.bonusCheckId }}</td>
            <td>{{ financialTransactions.roundLinkTrxno }}</td>
            <td>{{ financialTransactions.reversePaymentTrxNo }}</td>
            <td>{{ financialTransactions.electronicVoucherNo }}</td>
            <td>{{ financialTransactions.thresholdDiversionId }}</td>
            <td>{{ financialTransactions.thresholdEntityQty }}</td>
            <td>{{ financialTransactions.trxNoSplit }}</td>
            <td>{{ financialTransactions.exchDiffTrxNo }}</td>
            <td>{{ financialTransactions.associatedTrxNo }}</td>
            <td>{{ financialTransactions.taxRate }}</td>
            <td>{{ financialTransactions.propChargeId }}</td>
            <td>{{ financialTransactions.quantity }}</td>
            <td>{{ financialTransactions.netAmount }}</td>
            <td>{{ financialTransactions.grossAmount }}</td>
            <td>{{ financialTransactions.cashierOpeningBalance }}</td>
            <td>{{ financialTransactions.pricePerUnit }}</td>
            <td>{{ financialTransactions.trxAmount }}</td>
            <td>{{ financialTransactions.postedAmount }}</td>
            <td>{{ financialTransactions.guestAccountCredit }}</td>
            <td>{{ financialTransactions.exchangeRate }}</td>
            <td>{{ financialTransactions.guestAccountDebit }}</td>
            <td>{{ financialTransactions.cashierCredit }}</td>
            <td>{{ financialTransactions.cashierDebit }}</td>
            <td>{{ financialTransactions.packageCredit }}</td>
            <td>{{ financialTransactions.packageDebit }}</td>
            <td>{{ financialTransactions.depLedCredit }}</td>
            <td>{{ financialTransactions.depLedDebit }}</td>
            <td>{{ financialTransactions.revenueAmt }}</td>
            <td>{{ financialTransactions.arLedCredit }}</td>
            <td>{{ financialTransactions.arLedDebit }}</td>
            <td>{{ financialTransactions.euroExchangeRate }}</td>
            <td>{{ financialTransactions.inhDebit }}</td>
            <td>{{ financialTransactions.inhCredit }}</td>
            <td>{{ financialTransactions.packageAllowance }}</td>
            <td>{{ financialTransactions.parallelGuestCredit }}</td>
            <td>{{ financialTransactions.parallelGuestDebit }}</td>
            <td>{{ financialTransactions.parallelNetAmount }}</td>
            <td>{{ financialTransactions.parallelGrossAmount }}</td>
            <td>{{ financialTransactions.orgPostedAmount }}</td>
            <td>{{ financialTransactions.roomNtsEffective }}</td>
            <td>{{ financialTransactions.paymentSurchargeAmt }}</td>
            <td>{{ financialTransactions.folioView }}</td>
            <td>{{ financialTransactions.taxInclusiveYn }}</td>
            <td>{{ financialTransactions.deferredYn }}</td>
            <td>{{ financialTransactions.indAdjustmentYn }}</td>
            <td>{{ financialTransactions.fixedChargesYn }}</td>
            <td>{{ financialTransactions.taCommissionableYn }}</td>
            <td>{{ financialTransactions.taxGeneratedYn }}</td>
            <td>{{ financialTransactions.compressedYn }}</td>
            <td>{{ financialTransactions.displayYn }}</td>
            <td>{{ financialTransactions.collAgentPostingYn }}</td>
            <td>{{ financialTransactions.fiscalTrxCodeType }}</td>
            <td>{{ financialTransactions.deferredTaxesYn }}</td>
            <td>{{ financialTransactions.advancedGenerateYn }}</td>
            <td>{{ financialTransactions.forexType }}</td>
            <td>{{ financialTransactions.taCommissionNetYn }}</td>
            <td>{{ financialTransactions.sourceCommissionNetYn }}</td>
            <td>{{ financialTransactions.settlementFlag }}</td>
            <td>{{ financialTransactions.accTypeFlag }}</td>
            <td>{{ financialTransactions.profitLossFlag }}</td>
            <td>{{ financialTransactions.proformaYn }}</td>
            <td>{{ financialTransactions.holdYn }}</td>
            <td>{{ financialTransactions.exchangeDifferenceYn }}</td>
            <td>{{ financialTransactions.calcPointsYn }}</td>
            <td>{{ financialTransactions.arChargeTransferYn }}</td>
            <td>{{ financialTransactions.processed8300Yn }}</td>
            <td>{{ financialTransactions.asbFlag }}</td>
            <td>{{ financialTransactions.postitYn }}</td>
            <td>{{ financialTransactions.autoSettleYn }}</td>
            <td>{{ financialTransactions.depTaxTransferedYn }}</td>
            <td>{{ financialTransactions.autoCreditbillYn }}</td>
            <td>{{ financialTransactions.asbOnlyPostTaxesOnceYn }}</td>
            <td>{{ financialTransactions.roundFactorYn }}</td>
            <td>{{ financialTransactions.depPostingFlag }}</td>
            <td>{{ financialTransactions.correctionYn }}</td>
            <td>{{ financialTransactions.routedYn }}</td>
            <td>{{ financialTransactions.upsellChargeYn }}</td>
            <td>{{ financialTransactions.advanceBillYn }}</td>
            <td>{{ financialTransactions.advanceBillReversedYn }}</td>
            <td>{{ financialTransactions.incTaxDeductedYn }}</td>
            <td>{{ financialTransactions.gpAwardCancelledYn }}</td>
            <td>{{ financialTransactions.serviceRecoveryAdjustmentYn }}</td>
            <td>{{ financialTransactions.splitType }}</td>
            <td>{{ financialTransactions.bucketRedempYn }}</td>
            <td>{{ financialTransactions.vatOffsetYn }}</td>
            <td>{{ financialTransactions.forexTaxYn }}</td>
            <td>{{ financialTransactions.stampDutyYn }}</td>
            <td>{{ financialTransactions.covers }}</td>
            <td>{{ financialTransactions.advGenerateAdjustment }}</td>
            <td>{{ financialTransactions.expInvoiceType }}</td>
            <td>{{ financialTransactions.folioType }}</td>
            <td>{{ financialTransactions.orgFolioType }}</td>
            <td>{{ financialTransactions.invoiceType }}</td>
            <td>{{ financialTransactions.arState }}</td>
            <td>{{ financialTransactions.exchangeType }}</td>
            <td>{{ financialTransactions.recptType }}</td>
            <td>{{ financialTransactions.roomClass }}</td>
            <td>{{ financialTransactions.resort }}</td>
            <td>{{ financialTransactions.tcGroup }}</td>
            <td>{{ financialTransactions.tcSubgroup }}</td>
            <td>{{ financialTransactions.trxCode }}</td>
            <td>{{ financialTransactions.room }}</td>
            <td>{{ financialTransactions.tclCode1 }}</td>
            <td>{{ financialTransactions.currency }}</td>
            <td>{{ financialTransactions.ftGeneratedType }}</td>
            <td>{{ financialTransactions.tclCode2 }}</td>
            <td>{{ financialTransactions.marketCode }}</td>
            <td>{{ financialTransactions.sourceCode }}</td>
            <td>{{ financialTransactions.rateCode }}</td>
            <td>{{ financialTransactions.hotelAcct }}</td>
            <td>{{ financialTransactions.reasonCode }}</td>
            <td>{{ financialTransactions.product }}</td>
            <td>{{ financialTransactions.targetResort }}</td>
            <td>{{ financialTransactions.nameTaxType }}</td>
            <td>{{ financialTransactions.taxInvNo }}</td>
            <td>{{ financialTransactions.approvalCode }}</td>
            <td>{{ financialTransactions.approvalStatus }}</td>
            <td>{{ financialTransactions.compLinkTrxCode }}</td>
            <td>{{ financialTransactions.compTypeCode }}</td>
            <td>{{ financialTransactions.couponNo }}</td>
            <td>{{ financialTransactions.originalRoom }}</td>
            <td>{{ financialTransactions.allowanceType }}</td>
            <td>{{ financialTransactions.advGenerateTrxCode }}</td>
            <td>{{ financialTransactions.trxServiceType }}</td>
            <td>{{ financialTransactions.postingType }}</td>
            <td>{{ financialTransactions.parallelCurrency }}</td>
            <td>{{ financialTransactions.contractCurrency }}</td>
            <td>{{ financialTransactions.fbaCertificateNumber }}</td>
            <td>{{ financialTransactions.postingRhythm }}</td>
            <td>{{ financialTransactions.asbTaxFlag }}</td>
            <td>{{ financialTransactions.packageArrangementCode }}</td>
            <td>{{ financialTransactions.gpAwardCode }}</td>
            <td>{{ financialTransactions.gpAwardCancelCode }}</td>
            <td>{{ financialTransactions.serviceRecoveryDeptCode }}</td>
            <td>{{ financialTransactions.bucketCode }}</td>
            <td>{{ financialTransactions.taxRateType }}</td>
            <td>{{ financialTransactions.chequeNumber }}</td>
            <td>{{ financialTransactions.passerByName }}</td>
            <td>{{ financialTransactions.esignedReceiptName }}</td>
            <td>{{ financialTransactions.remark }}</td>
            <td>{{ financialTransactions.reference }}</td>
            <td>{{ financialTransactions.oTrxDesc }}</td>
            <td>{{ financialTransactions.comments }}</td>
            <td>{{ financialTransactions.fiscalBillNo }}</td>
            <td>{{ financialTransactions.extSysResultMsg }}</td>
            <td>{{ financialTransactions.queueName }}</td>
            <td>{{ financialTransactions.paymentType }}</td>
            <td>{{ financialTransactions.ccRefundPosting }}</td>
            <td>{{ financialTransactions.thresholdEntityType }}</td>
            <td>{{ financialTransactions.thresholdTreatmentFlag }}</td>
            <td>{{ financialTransactions.paymentSurchargeType }}</td>
            <td>{{ financialTransactions.propertyBillPrefix }}</td>
            <td>{{ financialTransactions.taxElements }}</td>
            <td>{{ financialTransactions.numberDialed }}</td>
            <td>{{ financialTransactions.checkFileId }}</td>
            <td>{{ financialTransactions.extTrxId }}</td>
            <td>{{ financialTransactions.packageTrxType }}</td>
            <td>{{ financialTransactions.expOriginalInvoice }}</td>
            <td>{{ financialTransactions.depositTransactionId }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'FinancialTransactionsView', params: { financialTransactionsId: financialTransactions.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'FinancialTransactionsEdit', params: { financialTransactionsId: financialTransactions.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(financialTransactions)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="t$('entity.action.delete')"></span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <template #modal-title>
        <span
          id="operaHandlerApplicationApp.financialTransactions.delete.question"
          data-cy="financialTransactionsDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p
          id="jhi-delete-financialTransactions-heading"
          v-text="t$('operaHandlerApplicationApp.financialTransactions.delete.question', { id: removeId })"
        ></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-financialTransactions"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeFinancialTransactions()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="financialTransactions && financialTransactions.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./financial-transactions.component.ts"></script>
