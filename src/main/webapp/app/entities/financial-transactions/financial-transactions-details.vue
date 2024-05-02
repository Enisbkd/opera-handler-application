<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="financialTransactions">
        <h2 class="jh-entity-heading" data-cy="financialTransactionsDetailsHeading">
          <span v-text="t$('operaHandlerApplicationApp.financialTransactions.detail.title')"></span> {{ financialTransactions.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trxNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.ftSubtype')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.ftSubtype }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.invoiceCloseDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.invoiceCloseDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arTransferDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.arTransferDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trxDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.businessDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.businessDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.insertDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.insertDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.updateDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.updateDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trnsActivityDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trnsActivityDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.approvalDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.approvalDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postingDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.postingDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.exchangeDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.routingDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.routingDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.effectiveDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.effectiveDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.customChargeDate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.customChargeDate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.recptNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.recptNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoAdjust')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trxNoAdjust }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoAddedBy')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trxNoAddedBy }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoAgainstPackage')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trxNoAgainstPackage }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoHeader')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trxNoHeader }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arNumber')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.arNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.resvNameId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.resvNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.cashierId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.creditCardId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.creditCardId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.nameId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.nameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.tranActionId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.tranActionId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.finDmlSeqNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.finDmlSeqNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.routingInstrnId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.routingInstrnId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.fromResvId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.fromResvId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.genCashierId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.genCashierId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.folioNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.folioNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.invoiceNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.invoiceNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.insertUser')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.insertUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.updateUser')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.updateUser }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arrangementId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.arrangementId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trnsFromAcct')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trnsFromAcct }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trnsToAcct')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trnsToAcct }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.billNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.billNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.revisionNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.revisionNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.resvDepositId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.resvDepositId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.linkTrxNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.linkTrxNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.authorizerId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.authorizerId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.compLinkTrxNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.compLinkTrxNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.mtrxNoAgainstPackage')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.mtrxNoAgainstPackage }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.forexCommPerc')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.forexCommPerc }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.forexCommAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.forexCommAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.articleId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.articleId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.toResvNameId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.toResvNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.roomNts')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.roomNts }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.orgArLedDebit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.orgArLedDebit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.closureNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.closureNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.originalResvNameId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.originalResvNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.orgBillNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.orgBillNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.membershipId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.membershipId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.installments')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.installments }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.contractGuestDebit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.contractGuestDebit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.contractGuestCredit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.contractGuestCredit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.contractNetAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.contractNetAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.contractGrossAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.contractGrossAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postitNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.postitNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.ccTrxFeeAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.ccTrxFeeAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.changeDue')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.changeDue }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postingSourceNameId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.postingSourceNameId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.bonusCheckId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.bonusCheckId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.roundLinkTrxno')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.roundLinkTrxno }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.reversePaymentTrxNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.reversePaymentTrxNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.electronicVoucherNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.electronicVoucherNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdDiversionId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.thresholdDiversionId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdEntityQty')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.thresholdEntityQty }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoSplit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trxNoSplit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.exchDiffTrxNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.exchDiffTrxNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.associatedTrxNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.associatedTrxNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxRate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.taxRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.propChargeId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.propChargeId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.quantity')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.quantity }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.netAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.netAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.grossAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.grossAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierOpeningBalance')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.cashierOpeningBalance }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.pricePerUnit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.pricePerUnit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trxAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postedAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.postedAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.guestAccountCredit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.guestAccountCredit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeRate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.exchangeRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.guestAccountDebit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.guestAccountDebit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierCredit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.cashierCredit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierDebit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.cashierDebit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.packageCredit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.packageCredit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.packageDebit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.packageDebit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.depLedCredit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.depLedCredit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.depLedDebit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.depLedDebit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.revenueAmt')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.revenueAmt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arLedCredit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.arLedCredit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arLedDebit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.arLedDebit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.euroExchangeRate')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.euroExchangeRate }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.inhDebit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.inhDebit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.inhCredit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.inhCredit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.packageAllowance')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.packageAllowance }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelGuestCredit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.parallelGuestCredit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelGuestDebit')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.parallelGuestDebit }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelNetAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.parallelNetAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelGrossAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.parallelGrossAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.orgPostedAmount')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.orgPostedAmount }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.roomNtsEffective')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.roomNtsEffective }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.paymentSurchargeAmt')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.paymentSurchargeAmt }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.folioView')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.folioView }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxInclusiveYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.taxInclusiveYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.deferredYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.deferredYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.indAdjustmentYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.indAdjustmentYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.fixedChargesYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.fixedChargesYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taCommissionableYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.taCommissionableYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxGeneratedYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.taxGeneratedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.compressedYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.compressedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.displayYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.displayYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.collAgentPostingYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.collAgentPostingYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.fiscalTrxCodeType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.fiscalTrxCodeType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.deferredTaxesYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.deferredTaxesYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.advancedGenerateYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.advancedGenerateYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.forexType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.forexType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taCommissionNetYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.taCommissionNetYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.sourceCommissionNetYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.sourceCommissionNetYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.settlementFlag')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.settlementFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.accTypeFlag')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.accTypeFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.profitLossFlag')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.profitLossFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.proformaYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.proformaYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.holdYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.holdYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeDifferenceYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.exchangeDifferenceYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.calcPointsYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.calcPointsYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arChargeTransferYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.arChargeTransferYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.processed8300Yn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.processed8300Yn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.asbFlag')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.asbFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postitYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.postitYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.autoSettleYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.autoSettleYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.depTaxTransferedYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.depTaxTransferedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.autoCreditbillYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.autoCreditbillYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.asbOnlyPostTaxesOnceYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.asbOnlyPostTaxesOnceYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.roundFactorYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.roundFactorYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.depPostingFlag')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.depPostingFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.correctionYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.correctionYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.routedYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.routedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.upsellChargeYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.upsellChargeYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.advanceBillYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.advanceBillYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.advanceBillReversedYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.advanceBillReversedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.incTaxDeductedYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.incTaxDeductedYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.gpAwardCancelledYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.gpAwardCancelledYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.serviceRecoveryAdjustmentYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.serviceRecoveryAdjustmentYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.splitType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.splitType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.bucketRedempYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.bucketRedempYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.vatOffsetYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.vatOffsetYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.forexTaxYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.forexTaxYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.stampDutyYn')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.stampDutyYn }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.covers')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.covers }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.advGenerateAdjustment')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.advGenerateAdjustment }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.expInvoiceType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.expInvoiceType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.folioType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.folioType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.orgFolioType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.orgFolioType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.invoiceType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.invoiceType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.arState')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.arState }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.exchangeType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.recptType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.recptType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.roomClass')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.roomClass }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.resort')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.resort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.tcGroup')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.tcGroup }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.tcSubgroup')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.tcSubgroup }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trxCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.room')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.room }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.tclCode1')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.tclCode1 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.currency')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.currency }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.ftGeneratedType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.ftGeneratedType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.tclCode2')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.tclCode2 }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.marketCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.marketCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.sourceCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.sourceCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.rateCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.rateCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.hotelAcct')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.hotelAcct }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.reasonCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.reasonCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.product')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.product }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.targetResort')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.targetResort }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.nameTaxType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.nameTaxType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxInvNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.taxInvNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.approvalCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.approvalCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.approvalStatus')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.approvalStatus }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.compLinkTrxCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.compLinkTrxCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.compTypeCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.compTypeCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.couponNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.couponNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.originalRoom')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.originalRoom }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.allowanceType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.allowanceType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.advGenerateTrxCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.advGenerateTrxCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.trxServiceType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.trxServiceType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postingType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.postingType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelCurrency')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.parallelCurrency }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.contractCurrency')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.contractCurrency }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.fbaCertificateNumber')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.fbaCertificateNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.postingRhythm')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.postingRhythm }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.asbTaxFlag')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.asbTaxFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.packageArrangementCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.packageArrangementCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.gpAwardCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.gpAwardCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.gpAwardCancelCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.gpAwardCancelCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.serviceRecoveryDeptCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.serviceRecoveryDeptCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.bucketCode')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.bucketCode }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxRateType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.taxRateType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.chequeNumber')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.chequeNumber }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.passerByName')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.passerByName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.esignedReceiptName')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.esignedReceiptName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.remark')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.remark }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.reference')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.reference }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.oTrxDesc')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.oTrxDesc }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.comments')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.comments }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.fiscalBillNo')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.fiscalBillNo }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.extSysResultMsg')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.extSysResultMsg }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.queueName')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.queueName }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.paymentType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.paymentType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.ccRefundPosting')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.ccRefundPosting }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdEntityType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.thresholdEntityType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdTreatmentFlag')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.thresholdTreatmentFlag }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.paymentSurchargeType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.paymentSurchargeType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.propertyBillPrefix')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.propertyBillPrefix }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.taxElements')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.taxElements }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.numberDialed')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.numberDialed }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.checkFileId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.checkFileId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.extTrxId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.extTrxId }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.packageTrxType')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.packageTrxType }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.expOriginalInvoice')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.expOriginalInvoice }}</span>
          </dd>
          <dt>
            <span v-text="t$('operaHandlerApplicationApp.financialTransactions.depositTransactionId')"></span>
          </dt>
          <dd>
            <span>{{ financialTransactions.depositTransactionId }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.back')"></span>
        </button>
        <router-link
          v-if="financialTransactions.id"
          :to="{ name: 'FinancialTransactionsEdit', params: { financialTransactionsId: financialTransactions.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.edit')"></span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./financial-transactions-details.component.ts"></script>
