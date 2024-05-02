<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.financialTransactions.home.createOrEditLabel"
          data-cy="FinancialTransactionsCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.financialTransactions.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="financialTransactions.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="financialTransactions.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNo')"
              for="financial-transactions-trxNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="trxNo"
              id="financial-transactions-trxNo"
              data-cy="trxNo"
              :class="{ valid: !v$.trxNo.$invalid, invalid: v$.trxNo.$invalid }"
              v-model.number="v$.trxNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.ftSubtype')"
              for="financial-transactions-ftSubtype"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ftSubtype"
              id="financial-transactions-ftSubtype"
              data-cy="ftSubtype"
              :class="{ valid: !v$.ftSubtype.$invalid, invalid: v$.ftSubtype.$invalid }"
              v-model="v$.ftSubtype.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.invoiceCloseDate')"
              for="financial-transactions-invoiceCloseDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-invoiceCloseDate"
                  v-model="v$.invoiceCloseDate.$model"
                  name="invoiceCloseDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-invoiceCloseDate"
                data-cy="invoiceCloseDate"
                type="text"
                class="form-control"
                name="invoiceCloseDate"
                :class="{ valid: !v$.invoiceCloseDate.$invalid, invalid: v$.invoiceCloseDate.$invalid }"
                v-model="v$.invoiceCloseDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.arTransferDate')"
              for="financial-transactions-arTransferDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-arTransferDate"
                  v-model="v$.arTransferDate.$model"
                  name="arTransferDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-arTransferDate"
                data-cy="arTransferDate"
                type="text"
                class="form-control"
                name="arTransferDate"
                :class="{ valid: !v$.arTransferDate.$invalid, invalid: v$.arTransferDate.$invalid }"
                v-model="v$.arTransferDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trxDate')"
              for="financial-transactions-trxDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-trxDate"
                  v-model="v$.trxDate.$model"
                  name="trxDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-trxDate"
                data-cy="trxDate"
                type="text"
                class="form-control"
                name="trxDate"
                :class="{ valid: !v$.trxDate.$invalid, invalid: v$.trxDate.$invalid }"
                v-model="v$.trxDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.businessDate')"
              for="financial-transactions-businessDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-businessDate"
                  v-model="v$.businessDate.$model"
                  name="businessDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-businessDate"
                data-cy="businessDate"
                type="text"
                class="form-control"
                name="businessDate"
                :class="{ valid: !v$.businessDate.$invalid, invalid: v$.businessDate.$invalid }"
                v-model="v$.businessDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.insertDate')"
              for="financial-transactions-insertDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-insertDate"
                  v-model="v$.insertDate.$model"
                  name="insertDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-insertDate"
                data-cy="insertDate"
                type="text"
                class="form-control"
                name="insertDate"
                :class="{ valid: !v$.insertDate.$invalid, invalid: v$.insertDate.$invalid }"
                v-model="v$.insertDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.updateDate')"
              for="financial-transactions-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-updateDate"
                  v-model="v$.updateDate.$model"
                  name="updateDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-updateDate"
                data-cy="updateDate"
                type="text"
                class="form-control"
                name="updateDate"
                :class="{ valid: !v$.updateDate.$invalid, invalid: v$.updateDate.$invalid }"
                v-model="v$.updateDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trnsActivityDate')"
              for="financial-transactions-trnsActivityDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-trnsActivityDate"
                  v-model="v$.trnsActivityDate.$model"
                  name="trnsActivityDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-trnsActivityDate"
                data-cy="trnsActivityDate"
                type="text"
                class="form-control"
                name="trnsActivityDate"
                :class="{ valid: !v$.trnsActivityDate.$invalid, invalid: v$.trnsActivityDate.$invalid }"
                v-model="v$.trnsActivityDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.approvalDate')"
              for="financial-transactions-approvalDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-approvalDate"
                  v-model="v$.approvalDate.$model"
                  name="approvalDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-approvalDate"
                data-cy="approvalDate"
                type="text"
                class="form-control"
                name="approvalDate"
                :class="{ valid: !v$.approvalDate.$invalid, invalid: v$.approvalDate.$invalid }"
                v-model="v$.approvalDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.postingDate')"
              for="financial-transactions-postingDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-postingDate"
                  v-model="v$.postingDate.$model"
                  name="postingDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-postingDate"
                data-cy="postingDate"
                type="text"
                class="form-control"
                name="postingDate"
                :class="{ valid: !v$.postingDate.$invalid, invalid: v$.postingDate.$invalid }"
                v-model="v$.postingDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeDate')"
              for="financial-transactions-exchangeDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-exchangeDate"
                  v-model="v$.exchangeDate.$model"
                  name="exchangeDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-exchangeDate"
                data-cy="exchangeDate"
                type="text"
                class="form-control"
                name="exchangeDate"
                :class="{ valid: !v$.exchangeDate.$invalid, invalid: v$.exchangeDate.$invalid }"
                v-model="v$.exchangeDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.routingDate')"
              for="financial-transactions-routingDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-routingDate"
                  v-model="v$.routingDate.$model"
                  name="routingDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-routingDate"
                data-cy="routingDate"
                type="text"
                class="form-control"
                name="routingDate"
                :class="{ valid: !v$.routingDate.$invalid, invalid: v$.routingDate.$invalid }"
                v-model="v$.routingDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.effectiveDate')"
              for="financial-transactions-effectiveDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-effectiveDate"
                  v-model="v$.effectiveDate.$model"
                  name="effectiveDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-effectiveDate"
                data-cy="effectiveDate"
                type="text"
                class="form-control"
                name="effectiveDate"
                :class="{ valid: !v$.effectiveDate.$invalid, invalid: v$.effectiveDate.$invalid }"
                v-model="v$.effectiveDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.customChargeDate')"
              for="financial-transactions-customChargeDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="financial-transactions-customChargeDate"
                  v-model="v$.customChargeDate.$model"
                  name="customChargeDate"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="financial-transactions-customChargeDate"
                data-cy="customChargeDate"
                type="text"
                class="form-control"
                name="customChargeDate"
                :class="{ valid: !v$.customChargeDate.$invalid, invalid: v$.customChargeDate.$invalid }"
                v-model="v$.customChargeDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.recptNo')"
              for="financial-transactions-recptNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="recptNo"
              id="financial-transactions-recptNo"
              data-cy="recptNo"
              :class="{ valid: !v$.recptNo.$invalid, invalid: v$.recptNo.$invalid }"
              v-model.number="v$.recptNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoAdjust')"
              for="financial-transactions-trxNoAdjust"
            ></label>
            <input
              type="number"
              class="form-control"
              name="trxNoAdjust"
              id="financial-transactions-trxNoAdjust"
              data-cy="trxNoAdjust"
              :class="{ valid: !v$.trxNoAdjust.$invalid, invalid: v$.trxNoAdjust.$invalid }"
              v-model.number="v$.trxNoAdjust.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoAddedBy')"
              for="financial-transactions-trxNoAddedBy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="trxNoAddedBy"
              id="financial-transactions-trxNoAddedBy"
              data-cy="trxNoAddedBy"
              :class="{ valid: !v$.trxNoAddedBy.$invalid, invalid: v$.trxNoAddedBy.$invalid }"
              v-model.number="v$.trxNoAddedBy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoAgainstPackage')"
              for="financial-transactions-trxNoAgainstPackage"
            ></label>
            <input
              type="number"
              class="form-control"
              name="trxNoAgainstPackage"
              id="financial-transactions-trxNoAgainstPackage"
              data-cy="trxNoAgainstPackage"
              :class="{ valid: !v$.trxNoAgainstPackage.$invalid, invalid: v$.trxNoAgainstPackage.$invalid }"
              v-model.number="v$.trxNoAgainstPackage.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoHeader')"
              for="financial-transactions-trxNoHeader"
            ></label>
            <input
              type="number"
              class="form-control"
              name="trxNoHeader"
              id="financial-transactions-trxNoHeader"
              data-cy="trxNoHeader"
              :class="{ valid: !v$.trxNoHeader.$invalid, invalid: v$.trxNoHeader.$invalid }"
              v-model.number="v$.trxNoHeader.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.arNumber')"
              for="financial-transactions-arNumber"
            ></label>
            <input
              type="number"
              class="form-control"
              name="arNumber"
              id="financial-transactions-arNumber"
              data-cy="arNumber"
              :class="{ valid: !v$.arNumber.$invalid, invalid: v$.arNumber.$invalid }"
              v-model.number="v$.arNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.resvNameId')"
              for="financial-transactions-resvNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="resvNameId"
              id="financial-transactions-resvNameId"
              data-cy="resvNameId"
              :class="{ valid: !v$.resvNameId.$invalid, invalid: v$.resvNameId.$invalid }"
              v-model.number="v$.resvNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierId')"
              for="financial-transactions-cashierId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cashierId"
              id="financial-transactions-cashierId"
              data-cy="cashierId"
              :class="{ valid: !v$.cashierId.$invalid, invalid: v$.cashierId.$invalid }"
              v-model.number="v$.cashierId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.creditCardId')"
              for="financial-transactions-creditCardId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="creditCardId"
              id="financial-transactions-creditCardId"
              data-cy="creditCardId"
              :class="{ valid: !v$.creditCardId.$invalid, invalid: v$.creditCardId.$invalid }"
              v-model.number="v$.creditCardId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.nameId')"
              for="financial-transactions-nameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="nameId"
              id="financial-transactions-nameId"
              data-cy="nameId"
              :class="{ valid: !v$.nameId.$invalid, invalid: v$.nameId.$invalid }"
              v-model.number="v$.nameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.tranActionId')"
              for="financial-transactions-tranActionId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="tranActionId"
              id="financial-transactions-tranActionId"
              data-cy="tranActionId"
              :class="{ valid: !v$.tranActionId.$invalid, invalid: v$.tranActionId.$invalid }"
              v-model.number="v$.tranActionId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.finDmlSeqNo')"
              for="financial-transactions-finDmlSeqNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="finDmlSeqNo"
              id="financial-transactions-finDmlSeqNo"
              data-cy="finDmlSeqNo"
              :class="{ valid: !v$.finDmlSeqNo.$invalid, invalid: v$.finDmlSeqNo.$invalid }"
              v-model.number="v$.finDmlSeqNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.routingInstrnId')"
              for="financial-transactions-routingInstrnId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="routingInstrnId"
              id="financial-transactions-routingInstrnId"
              data-cy="routingInstrnId"
              :class="{ valid: !v$.routingInstrnId.$invalid, invalid: v$.routingInstrnId.$invalid }"
              v-model.number="v$.routingInstrnId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.fromResvId')"
              for="financial-transactions-fromResvId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="fromResvId"
              id="financial-transactions-fromResvId"
              data-cy="fromResvId"
              :class="{ valid: !v$.fromResvId.$invalid, invalid: v$.fromResvId.$invalid }"
              v-model.number="v$.fromResvId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.genCashierId')"
              for="financial-transactions-genCashierId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="genCashierId"
              id="financial-transactions-genCashierId"
              data-cy="genCashierId"
              :class="{ valid: !v$.genCashierId.$invalid, invalid: v$.genCashierId.$invalid }"
              v-model.number="v$.genCashierId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.folioNo')"
              for="financial-transactions-folioNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="folioNo"
              id="financial-transactions-folioNo"
              data-cy="folioNo"
              :class="{ valid: !v$.folioNo.$invalid, invalid: v$.folioNo.$invalid }"
              v-model.number="v$.folioNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.invoiceNo')"
              for="financial-transactions-invoiceNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="invoiceNo"
              id="financial-transactions-invoiceNo"
              data-cy="invoiceNo"
              :class="{ valid: !v$.invoiceNo.$invalid, invalid: v$.invoiceNo.$invalid }"
              v-model.number="v$.invoiceNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.insertUser')"
              for="financial-transactions-insertUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="financial-transactions-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.updateUser')"
              for="financial-transactions-updateUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="financial-transactions-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.arrangementId')"
              for="financial-transactions-arrangementId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="arrangementId"
              id="financial-transactions-arrangementId"
              data-cy="arrangementId"
              :class="{ valid: !v$.arrangementId.$invalid, invalid: v$.arrangementId.$invalid }"
              v-model.number="v$.arrangementId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trnsFromAcct')"
              for="financial-transactions-trnsFromAcct"
            ></label>
            <input
              type="number"
              class="form-control"
              name="trnsFromAcct"
              id="financial-transactions-trnsFromAcct"
              data-cy="trnsFromAcct"
              :class="{ valid: !v$.trnsFromAcct.$invalid, invalid: v$.trnsFromAcct.$invalid }"
              v-model.number="v$.trnsFromAcct.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trnsToAcct')"
              for="financial-transactions-trnsToAcct"
            ></label>
            <input
              type="number"
              class="form-control"
              name="trnsToAcct"
              id="financial-transactions-trnsToAcct"
              data-cy="trnsToAcct"
              :class="{ valid: !v$.trnsToAcct.$invalid, invalid: v$.trnsToAcct.$invalid }"
              v-model.number="v$.trnsToAcct.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.billNo')"
              for="financial-transactions-billNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="billNo"
              id="financial-transactions-billNo"
              data-cy="billNo"
              :class="{ valid: !v$.billNo.$invalid, invalid: v$.billNo.$invalid }"
              v-model.number="v$.billNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.revisionNo')"
              for="financial-transactions-revisionNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="revisionNo"
              id="financial-transactions-revisionNo"
              data-cy="revisionNo"
              :class="{ valid: !v$.revisionNo.$invalid, invalid: v$.revisionNo.$invalid }"
              v-model.number="v$.revisionNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.resvDepositId')"
              for="financial-transactions-resvDepositId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="resvDepositId"
              id="financial-transactions-resvDepositId"
              data-cy="resvDepositId"
              :class="{ valid: !v$.resvDepositId.$invalid, invalid: v$.resvDepositId.$invalid }"
              v-model.number="v$.resvDepositId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.linkTrxNo')"
              for="financial-transactions-linkTrxNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="linkTrxNo"
              id="financial-transactions-linkTrxNo"
              data-cy="linkTrxNo"
              :class="{ valid: !v$.linkTrxNo.$invalid, invalid: v$.linkTrxNo.$invalid }"
              v-model.number="v$.linkTrxNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.authorizerId')"
              for="financial-transactions-authorizerId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="authorizerId"
              id="financial-transactions-authorizerId"
              data-cy="authorizerId"
              :class="{ valid: !v$.authorizerId.$invalid, invalid: v$.authorizerId.$invalid }"
              v-model.number="v$.authorizerId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.compLinkTrxNo')"
              for="financial-transactions-compLinkTrxNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="compLinkTrxNo"
              id="financial-transactions-compLinkTrxNo"
              data-cy="compLinkTrxNo"
              :class="{ valid: !v$.compLinkTrxNo.$invalid, invalid: v$.compLinkTrxNo.$invalid }"
              v-model.number="v$.compLinkTrxNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.mtrxNoAgainstPackage')"
              for="financial-transactions-mtrxNoAgainstPackage"
            ></label>
            <input
              type="number"
              class="form-control"
              name="mtrxNoAgainstPackage"
              id="financial-transactions-mtrxNoAgainstPackage"
              data-cy="mtrxNoAgainstPackage"
              :class="{ valid: !v$.mtrxNoAgainstPackage.$invalid, invalid: v$.mtrxNoAgainstPackage.$invalid }"
              v-model.number="v$.mtrxNoAgainstPackage.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.forexCommPerc')"
              for="financial-transactions-forexCommPerc"
            ></label>
            <input
              type="number"
              class="form-control"
              name="forexCommPerc"
              id="financial-transactions-forexCommPerc"
              data-cy="forexCommPerc"
              :class="{ valid: !v$.forexCommPerc.$invalid, invalid: v$.forexCommPerc.$invalid }"
              v-model.number="v$.forexCommPerc.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.forexCommAmount')"
              for="financial-transactions-forexCommAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="forexCommAmount"
              id="financial-transactions-forexCommAmount"
              data-cy="forexCommAmount"
              :class="{ valid: !v$.forexCommAmount.$invalid, invalid: v$.forexCommAmount.$invalid }"
              v-model.number="v$.forexCommAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.articleId')"
              for="financial-transactions-articleId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="articleId"
              id="financial-transactions-articleId"
              data-cy="articleId"
              :class="{ valid: !v$.articleId.$invalid, invalid: v$.articleId.$invalid }"
              v-model.number="v$.articleId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.toResvNameId')"
              for="financial-transactions-toResvNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="toResvNameId"
              id="financial-transactions-toResvNameId"
              data-cy="toResvNameId"
              :class="{ valid: !v$.toResvNameId.$invalid, invalid: v$.toResvNameId.$invalid }"
              v-model.number="v$.toResvNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.roomNts')"
              for="financial-transactions-roomNts"
            ></label>
            <input
              type="number"
              class="form-control"
              name="roomNts"
              id="financial-transactions-roomNts"
              data-cy="roomNts"
              :class="{ valid: !v$.roomNts.$invalid, invalid: v$.roomNts.$invalid }"
              v-model.number="v$.roomNts.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.orgArLedDebit')"
              for="financial-transactions-orgArLedDebit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="orgArLedDebit"
              id="financial-transactions-orgArLedDebit"
              data-cy="orgArLedDebit"
              :class="{ valid: !v$.orgArLedDebit.$invalid, invalid: v$.orgArLedDebit.$invalid }"
              v-model.number="v$.orgArLedDebit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.closureNo')"
              for="financial-transactions-closureNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="closureNo"
              id="financial-transactions-closureNo"
              data-cy="closureNo"
              :class="{ valid: !v$.closureNo.$invalid, invalid: v$.closureNo.$invalid }"
              v-model.number="v$.closureNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.originalResvNameId')"
              for="financial-transactions-originalResvNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="originalResvNameId"
              id="financial-transactions-originalResvNameId"
              data-cy="originalResvNameId"
              :class="{ valid: !v$.originalResvNameId.$invalid, invalid: v$.originalResvNameId.$invalid }"
              v-model.number="v$.originalResvNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.orgBillNo')"
              for="financial-transactions-orgBillNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="orgBillNo"
              id="financial-transactions-orgBillNo"
              data-cy="orgBillNo"
              :class="{ valid: !v$.orgBillNo.$invalid, invalid: v$.orgBillNo.$invalid }"
              v-model.number="v$.orgBillNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.membershipId')"
              for="financial-transactions-membershipId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="membershipId"
              id="financial-transactions-membershipId"
              data-cy="membershipId"
              :class="{ valid: !v$.membershipId.$invalid, invalid: v$.membershipId.$invalid }"
              v-model.number="v$.membershipId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.installments')"
              for="financial-transactions-installments"
            ></label>
            <input
              type="number"
              class="form-control"
              name="installments"
              id="financial-transactions-installments"
              data-cy="installments"
              :class="{ valid: !v$.installments.$invalid, invalid: v$.installments.$invalid }"
              v-model.number="v$.installments.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.contractGuestDebit')"
              for="financial-transactions-contractGuestDebit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="contractGuestDebit"
              id="financial-transactions-contractGuestDebit"
              data-cy="contractGuestDebit"
              :class="{ valid: !v$.contractGuestDebit.$invalid, invalid: v$.contractGuestDebit.$invalid }"
              v-model.number="v$.contractGuestDebit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.contractGuestCredit')"
              for="financial-transactions-contractGuestCredit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="contractGuestCredit"
              id="financial-transactions-contractGuestCredit"
              data-cy="contractGuestCredit"
              :class="{ valid: !v$.contractGuestCredit.$invalid, invalid: v$.contractGuestCredit.$invalid }"
              v-model.number="v$.contractGuestCredit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.contractNetAmount')"
              for="financial-transactions-contractNetAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="contractNetAmount"
              id="financial-transactions-contractNetAmount"
              data-cy="contractNetAmount"
              :class="{ valid: !v$.contractNetAmount.$invalid, invalid: v$.contractNetAmount.$invalid }"
              v-model.number="v$.contractNetAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.contractGrossAmount')"
              for="financial-transactions-contractGrossAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="contractGrossAmount"
              id="financial-transactions-contractGrossAmount"
              data-cy="contractGrossAmount"
              :class="{ valid: !v$.contractGrossAmount.$invalid, invalid: v$.contractGrossAmount.$invalid }"
              v-model.number="v$.contractGrossAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.postitNo')"
              for="financial-transactions-postitNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="postitNo"
              id="financial-transactions-postitNo"
              data-cy="postitNo"
              :class="{ valid: !v$.postitNo.$invalid, invalid: v$.postitNo.$invalid }"
              v-model.number="v$.postitNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.ccTrxFeeAmount')"
              for="financial-transactions-ccTrxFeeAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="ccTrxFeeAmount"
              id="financial-transactions-ccTrxFeeAmount"
              data-cy="ccTrxFeeAmount"
              :class="{ valid: !v$.ccTrxFeeAmount.$invalid, invalid: v$.ccTrxFeeAmount.$invalid }"
              v-model.number="v$.ccTrxFeeAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.changeDue')"
              for="financial-transactions-changeDue"
            ></label>
            <input
              type="number"
              class="form-control"
              name="changeDue"
              id="financial-transactions-changeDue"
              data-cy="changeDue"
              :class="{ valid: !v$.changeDue.$invalid, invalid: v$.changeDue.$invalid }"
              v-model.number="v$.changeDue.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.postingSourceNameId')"
              for="financial-transactions-postingSourceNameId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="postingSourceNameId"
              id="financial-transactions-postingSourceNameId"
              data-cy="postingSourceNameId"
              :class="{ valid: !v$.postingSourceNameId.$invalid, invalid: v$.postingSourceNameId.$invalid }"
              v-model.number="v$.postingSourceNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.bonusCheckId')"
              for="financial-transactions-bonusCheckId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="bonusCheckId"
              id="financial-transactions-bonusCheckId"
              data-cy="bonusCheckId"
              :class="{ valid: !v$.bonusCheckId.$invalid, invalid: v$.bonusCheckId.$invalid }"
              v-model.number="v$.bonusCheckId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.roundLinkTrxno')"
              for="financial-transactions-roundLinkTrxno"
            ></label>
            <input
              type="number"
              class="form-control"
              name="roundLinkTrxno"
              id="financial-transactions-roundLinkTrxno"
              data-cy="roundLinkTrxno"
              :class="{ valid: !v$.roundLinkTrxno.$invalid, invalid: v$.roundLinkTrxno.$invalid }"
              v-model.number="v$.roundLinkTrxno.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.reversePaymentTrxNo')"
              for="financial-transactions-reversePaymentTrxNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="reversePaymentTrxNo"
              id="financial-transactions-reversePaymentTrxNo"
              data-cy="reversePaymentTrxNo"
              :class="{ valid: !v$.reversePaymentTrxNo.$invalid, invalid: v$.reversePaymentTrxNo.$invalid }"
              v-model.number="v$.reversePaymentTrxNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.electronicVoucherNo')"
              for="financial-transactions-electronicVoucherNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="electronicVoucherNo"
              id="financial-transactions-electronicVoucherNo"
              data-cy="electronicVoucherNo"
              :class="{ valid: !v$.electronicVoucherNo.$invalid, invalid: v$.electronicVoucherNo.$invalid }"
              v-model.number="v$.electronicVoucherNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdDiversionId')"
              for="financial-transactions-thresholdDiversionId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="thresholdDiversionId"
              id="financial-transactions-thresholdDiversionId"
              data-cy="thresholdDiversionId"
              :class="{ valid: !v$.thresholdDiversionId.$invalid, invalid: v$.thresholdDiversionId.$invalid }"
              v-model.number="v$.thresholdDiversionId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdEntityQty')"
              for="financial-transactions-thresholdEntityQty"
            ></label>
            <input
              type="number"
              class="form-control"
              name="thresholdEntityQty"
              id="financial-transactions-thresholdEntityQty"
              data-cy="thresholdEntityQty"
              :class="{ valid: !v$.thresholdEntityQty.$invalid, invalid: v$.thresholdEntityQty.$invalid }"
              v-model.number="v$.thresholdEntityQty.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trxNoSplit')"
              for="financial-transactions-trxNoSplit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="trxNoSplit"
              id="financial-transactions-trxNoSplit"
              data-cy="trxNoSplit"
              :class="{ valid: !v$.trxNoSplit.$invalid, invalid: v$.trxNoSplit.$invalid }"
              v-model.number="v$.trxNoSplit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.exchDiffTrxNo')"
              for="financial-transactions-exchDiffTrxNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="exchDiffTrxNo"
              id="financial-transactions-exchDiffTrxNo"
              data-cy="exchDiffTrxNo"
              :class="{ valid: !v$.exchDiffTrxNo.$invalid, invalid: v$.exchDiffTrxNo.$invalid }"
              v-model.number="v$.exchDiffTrxNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.associatedTrxNo')"
              for="financial-transactions-associatedTrxNo"
            ></label>
            <input
              type="number"
              class="form-control"
              name="associatedTrxNo"
              id="financial-transactions-associatedTrxNo"
              data-cy="associatedTrxNo"
              :class="{ valid: !v$.associatedTrxNo.$invalid, invalid: v$.associatedTrxNo.$invalid }"
              v-model.number="v$.associatedTrxNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.taxRate')"
              for="financial-transactions-taxRate"
            ></label>
            <input
              type="number"
              class="form-control"
              name="taxRate"
              id="financial-transactions-taxRate"
              data-cy="taxRate"
              :class="{ valid: !v$.taxRate.$invalid, invalid: v$.taxRate.$invalid }"
              v-model.number="v$.taxRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.propChargeId')"
              for="financial-transactions-propChargeId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="propChargeId"
              id="financial-transactions-propChargeId"
              data-cy="propChargeId"
              :class="{ valid: !v$.propChargeId.$invalid, invalid: v$.propChargeId.$invalid }"
              v-model.number="v$.propChargeId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.quantity')"
              for="financial-transactions-quantity"
            ></label>
            <input
              type="number"
              class="form-control"
              name="quantity"
              id="financial-transactions-quantity"
              data-cy="quantity"
              :class="{ valid: !v$.quantity.$invalid, invalid: v$.quantity.$invalid }"
              v-model.number="v$.quantity.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.netAmount')"
              for="financial-transactions-netAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="netAmount"
              id="financial-transactions-netAmount"
              data-cy="netAmount"
              :class="{ valid: !v$.netAmount.$invalid, invalid: v$.netAmount.$invalid }"
              v-model.number="v$.netAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.grossAmount')"
              for="financial-transactions-grossAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="grossAmount"
              id="financial-transactions-grossAmount"
              data-cy="grossAmount"
              :class="{ valid: !v$.grossAmount.$invalid, invalid: v$.grossAmount.$invalid }"
              v-model.number="v$.grossAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierOpeningBalance')"
              for="financial-transactions-cashierOpeningBalance"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cashierOpeningBalance"
              id="financial-transactions-cashierOpeningBalance"
              data-cy="cashierOpeningBalance"
              :class="{ valid: !v$.cashierOpeningBalance.$invalid, invalid: v$.cashierOpeningBalance.$invalid }"
              v-model.number="v$.cashierOpeningBalance.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.pricePerUnit')"
              for="financial-transactions-pricePerUnit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="pricePerUnit"
              id="financial-transactions-pricePerUnit"
              data-cy="pricePerUnit"
              :class="{ valid: !v$.pricePerUnit.$invalid, invalid: v$.pricePerUnit.$invalid }"
              v-model.number="v$.pricePerUnit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trxAmount')"
              for="financial-transactions-trxAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="trxAmount"
              id="financial-transactions-trxAmount"
              data-cy="trxAmount"
              :class="{ valid: !v$.trxAmount.$invalid, invalid: v$.trxAmount.$invalid }"
              v-model.number="v$.trxAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.postedAmount')"
              for="financial-transactions-postedAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="postedAmount"
              id="financial-transactions-postedAmount"
              data-cy="postedAmount"
              :class="{ valid: !v$.postedAmount.$invalid, invalid: v$.postedAmount.$invalid }"
              v-model.number="v$.postedAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.guestAccountCredit')"
              for="financial-transactions-guestAccountCredit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="guestAccountCredit"
              id="financial-transactions-guestAccountCredit"
              data-cy="guestAccountCredit"
              :class="{ valid: !v$.guestAccountCredit.$invalid, invalid: v$.guestAccountCredit.$invalid }"
              v-model.number="v$.guestAccountCredit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeRate')"
              for="financial-transactions-exchangeRate"
            ></label>
            <input
              type="number"
              class="form-control"
              name="exchangeRate"
              id="financial-transactions-exchangeRate"
              data-cy="exchangeRate"
              :class="{ valid: !v$.exchangeRate.$invalid, invalid: v$.exchangeRate.$invalid }"
              v-model.number="v$.exchangeRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.guestAccountDebit')"
              for="financial-transactions-guestAccountDebit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="guestAccountDebit"
              id="financial-transactions-guestAccountDebit"
              data-cy="guestAccountDebit"
              :class="{ valid: !v$.guestAccountDebit.$invalid, invalid: v$.guestAccountDebit.$invalid }"
              v-model.number="v$.guestAccountDebit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierCredit')"
              for="financial-transactions-cashierCredit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cashierCredit"
              id="financial-transactions-cashierCredit"
              data-cy="cashierCredit"
              :class="{ valid: !v$.cashierCredit.$invalid, invalid: v$.cashierCredit.$invalid }"
              v-model.number="v$.cashierCredit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.cashierDebit')"
              for="financial-transactions-cashierDebit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="cashierDebit"
              id="financial-transactions-cashierDebit"
              data-cy="cashierDebit"
              :class="{ valid: !v$.cashierDebit.$invalid, invalid: v$.cashierDebit.$invalid }"
              v-model.number="v$.cashierDebit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.packageCredit')"
              for="financial-transactions-packageCredit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="packageCredit"
              id="financial-transactions-packageCredit"
              data-cy="packageCredit"
              :class="{ valid: !v$.packageCredit.$invalid, invalid: v$.packageCredit.$invalid }"
              v-model.number="v$.packageCredit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.packageDebit')"
              for="financial-transactions-packageDebit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="packageDebit"
              id="financial-transactions-packageDebit"
              data-cy="packageDebit"
              :class="{ valid: !v$.packageDebit.$invalid, invalid: v$.packageDebit.$invalid }"
              v-model.number="v$.packageDebit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.depLedCredit')"
              for="financial-transactions-depLedCredit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="depLedCredit"
              id="financial-transactions-depLedCredit"
              data-cy="depLedCredit"
              :class="{ valid: !v$.depLedCredit.$invalid, invalid: v$.depLedCredit.$invalid }"
              v-model.number="v$.depLedCredit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.depLedDebit')"
              for="financial-transactions-depLedDebit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="depLedDebit"
              id="financial-transactions-depLedDebit"
              data-cy="depLedDebit"
              :class="{ valid: !v$.depLedDebit.$invalid, invalid: v$.depLedDebit.$invalid }"
              v-model.number="v$.depLedDebit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.revenueAmt')"
              for="financial-transactions-revenueAmt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="revenueAmt"
              id="financial-transactions-revenueAmt"
              data-cy="revenueAmt"
              :class="{ valid: !v$.revenueAmt.$invalid, invalid: v$.revenueAmt.$invalid }"
              v-model.number="v$.revenueAmt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.arLedCredit')"
              for="financial-transactions-arLedCredit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="arLedCredit"
              id="financial-transactions-arLedCredit"
              data-cy="arLedCredit"
              :class="{ valid: !v$.arLedCredit.$invalid, invalid: v$.arLedCredit.$invalid }"
              v-model.number="v$.arLedCredit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.arLedDebit')"
              for="financial-transactions-arLedDebit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="arLedDebit"
              id="financial-transactions-arLedDebit"
              data-cy="arLedDebit"
              :class="{ valid: !v$.arLedDebit.$invalid, invalid: v$.arLedDebit.$invalid }"
              v-model.number="v$.arLedDebit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.euroExchangeRate')"
              for="financial-transactions-euroExchangeRate"
            ></label>
            <input
              type="number"
              class="form-control"
              name="euroExchangeRate"
              id="financial-transactions-euroExchangeRate"
              data-cy="euroExchangeRate"
              :class="{ valid: !v$.euroExchangeRate.$invalid, invalid: v$.euroExchangeRate.$invalid }"
              v-model.number="v$.euroExchangeRate.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.inhDebit')"
              for="financial-transactions-inhDebit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="inhDebit"
              id="financial-transactions-inhDebit"
              data-cy="inhDebit"
              :class="{ valid: !v$.inhDebit.$invalid, invalid: v$.inhDebit.$invalid }"
              v-model.number="v$.inhDebit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.inhCredit')"
              for="financial-transactions-inhCredit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="inhCredit"
              id="financial-transactions-inhCredit"
              data-cy="inhCredit"
              :class="{ valid: !v$.inhCredit.$invalid, invalid: v$.inhCredit.$invalid }"
              v-model.number="v$.inhCredit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.packageAllowance')"
              for="financial-transactions-packageAllowance"
            ></label>
            <input
              type="number"
              class="form-control"
              name="packageAllowance"
              id="financial-transactions-packageAllowance"
              data-cy="packageAllowance"
              :class="{ valid: !v$.packageAllowance.$invalid, invalid: v$.packageAllowance.$invalid }"
              v-model.number="v$.packageAllowance.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelGuestCredit')"
              for="financial-transactions-parallelGuestCredit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="parallelGuestCredit"
              id="financial-transactions-parallelGuestCredit"
              data-cy="parallelGuestCredit"
              :class="{ valid: !v$.parallelGuestCredit.$invalid, invalid: v$.parallelGuestCredit.$invalid }"
              v-model.number="v$.parallelGuestCredit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelGuestDebit')"
              for="financial-transactions-parallelGuestDebit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="parallelGuestDebit"
              id="financial-transactions-parallelGuestDebit"
              data-cy="parallelGuestDebit"
              :class="{ valid: !v$.parallelGuestDebit.$invalid, invalid: v$.parallelGuestDebit.$invalid }"
              v-model.number="v$.parallelGuestDebit.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelNetAmount')"
              for="financial-transactions-parallelNetAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="parallelNetAmount"
              id="financial-transactions-parallelNetAmount"
              data-cy="parallelNetAmount"
              :class="{ valid: !v$.parallelNetAmount.$invalid, invalid: v$.parallelNetAmount.$invalid }"
              v-model.number="v$.parallelNetAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelGrossAmount')"
              for="financial-transactions-parallelGrossAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="parallelGrossAmount"
              id="financial-transactions-parallelGrossAmount"
              data-cy="parallelGrossAmount"
              :class="{ valid: !v$.parallelGrossAmount.$invalid, invalid: v$.parallelGrossAmount.$invalid }"
              v-model.number="v$.parallelGrossAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.orgPostedAmount')"
              for="financial-transactions-orgPostedAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="orgPostedAmount"
              id="financial-transactions-orgPostedAmount"
              data-cy="orgPostedAmount"
              :class="{ valid: !v$.orgPostedAmount.$invalid, invalid: v$.orgPostedAmount.$invalid }"
              v-model.number="v$.orgPostedAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.roomNtsEffective')"
              for="financial-transactions-roomNtsEffective"
            ></label>
            <input
              type="number"
              class="form-control"
              name="roomNtsEffective"
              id="financial-transactions-roomNtsEffective"
              data-cy="roomNtsEffective"
              :class="{ valid: !v$.roomNtsEffective.$invalid, invalid: v$.roomNtsEffective.$invalid }"
              v-model.number="v$.roomNtsEffective.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.paymentSurchargeAmt')"
              for="financial-transactions-paymentSurchargeAmt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="paymentSurchargeAmt"
              id="financial-transactions-paymentSurchargeAmt"
              data-cy="paymentSurchargeAmt"
              :class="{ valid: !v$.paymentSurchargeAmt.$invalid, invalid: v$.paymentSurchargeAmt.$invalid }"
              v-model.number="v$.paymentSurchargeAmt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.folioView')"
              for="financial-transactions-folioView"
            ></label>
            <input
              type="number"
              class="form-control"
              name="folioView"
              id="financial-transactions-folioView"
              data-cy="folioView"
              :class="{ valid: !v$.folioView.$invalid, invalid: v$.folioView.$invalid }"
              v-model.number="v$.folioView.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.taxInclusiveYn')"
              for="financial-transactions-taxInclusiveYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="taxInclusiveYn"
              id="financial-transactions-taxInclusiveYn"
              data-cy="taxInclusiveYn"
              :class="{ valid: !v$.taxInclusiveYn.$invalid, invalid: v$.taxInclusiveYn.$invalid }"
              v-model="v$.taxInclusiveYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.deferredYn')"
              for="financial-transactions-deferredYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="deferredYn"
              id="financial-transactions-deferredYn"
              data-cy="deferredYn"
              :class="{ valid: !v$.deferredYn.$invalid, invalid: v$.deferredYn.$invalid }"
              v-model="v$.deferredYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.indAdjustmentYn')"
              for="financial-transactions-indAdjustmentYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="indAdjustmentYn"
              id="financial-transactions-indAdjustmentYn"
              data-cy="indAdjustmentYn"
              :class="{ valid: !v$.indAdjustmentYn.$invalid, invalid: v$.indAdjustmentYn.$invalid }"
              v-model="v$.indAdjustmentYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.fixedChargesYn')"
              for="financial-transactions-fixedChargesYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="fixedChargesYn"
              id="financial-transactions-fixedChargesYn"
              data-cy="fixedChargesYn"
              :class="{ valid: !v$.fixedChargesYn.$invalid, invalid: v$.fixedChargesYn.$invalid }"
              v-model="v$.fixedChargesYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.taCommissionableYn')"
              for="financial-transactions-taCommissionableYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="taCommissionableYn"
              id="financial-transactions-taCommissionableYn"
              data-cy="taCommissionableYn"
              :class="{ valid: !v$.taCommissionableYn.$invalid, invalid: v$.taCommissionableYn.$invalid }"
              v-model="v$.taCommissionableYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.taxGeneratedYn')"
              for="financial-transactions-taxGeneratedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="taxGeneratedYn"
              id="financial-transactions-taxGeneratedYn"
              data-cy="taxGeneratedYn"
              :class="{ valid: !v$.taxGeneratedYn.$invalid, invalid: v$.taxGeneratedYn.$invalid }"
              v-model="v$.taxGeneratedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.compressedYn')"
              for="financial-transactions-compressedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="compressedYn"
              id="financial-transactions-compressedYn"
              data-cy="compressedYn"
              :class="{ valid: !v$.compressedYn.$invalid, invalid: v$.compressedYn.$invalid }"
              v-model="v$.compressedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.displayYn')"
              for="financial-transactions-displayYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="displayYn"
              id="financial-transactions-displayYn"
              data-cy="displayYn"
              :class="{ valid: !v$.displayYn.$invalid, invalid: v$.displayYn.$invalid }"
              v-model="v$.displayYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.collAgentPostingYn')"
              for="financial-transactions-collAgentPostingYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="collAgentPostingYn"
              id="financial-transactions-collAgentPostingYn"
              data-cy="collAgentPostingYn"
              :class="{ valid: !v$.collAgentPostingYn.$invalid, invalid: v$.collAgentPostingYn.$invalid }"
              v-model="v$.collAgentPostingYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.fiscalTrxCodeType')"
              for="financial-transactions-fiscalTrxCodeType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="fiscalTrxCodeType"
              id="financial-transactions-fiscalTrxCodeType"
              data-cy="fiscalTrxCodeType"
              :class="{ valid: !v$.fiscalTrxCodeType.$invalid, invalid: v$.fiscalTrxCodeType.$invalid }"
              v-model="v$.fiscalTrxCodeType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.deferredTaxesYn')"
              for="financial-transactions-deferredTaxesYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="deferredTaxesYn"
              id="financial-transactions-deferredTaxesYn"
              data-cy="deferredTaxesYn"
              :class="{ valid: !v$.deferredTaxesYn.$invalid, invalid: v$.deferredTaxesYn.$invalid }"
              v-model="v$.deferredTaxesYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.advancedGenerateYn')"
              for="financial-transactions-advancedGenerateYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="advancedGenerateYn"
              id="financial-transactions-advancedGenerateYn"
              data-cy="advancedGenerateYn"
              :class="{ valid: !v$.advancedGenerateYn.$invalid, invalid: v$.advancedGenerateYn.$invalid }"
              v-model="v$.advancedGenerateYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.forexType')"
              for="financial-transactions-forexType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="forexType"
              id="financial-transactions-forexType"
              data-cy="forexType"
              :class="{ valid: !v$.forexType.$invalid, invalid: v$.forexType.$invalid }"
              v-model="v$.forexType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.taCommissionNetYn')"
              for="financial-transactions-taCommissionNetYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="taCommissionNetYn"
              id="financial-transactions-taCommissionNetYn"
              data-cy="taCommissionNetYn"
              :class="{ valid: !v$.taCommissionNetYn.$invalid, invalid: v$.taCommissionNetYn.$invalid }"
              v-model="v$.taCommissionNetYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.sourceCommissionNetYn')"
              for="financial-transactions-sourceCommissionNetYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sourceCommissionNetYn"
              id="financial-transactions-sourceCommissionNetYn"
              data-cy="sourceCommissionNetYn"
              :class="{ valid: !v$.sourceCommissionNetYn.$invalid, invalid: v$.sourceCommissionNetYn.$invalid }"
              v-model="v$.sourceCommissionNetYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.settlementFlag')"
              for="financial-transactions-settlementFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="settlementFlag"
              id="financial-transactions-settlementFlag"
              data-cy="settlementFlag"
              :class="{ valid: !v$.settlementFlag.$invalid, invalid: v$.settlementFlag.$invalid }"
              v-model="v$.settlementFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.accTypeFlag')"
              for="financial-transactions-accTypeFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accTypeFlag"
              id="financial-transactions-accTypeFlag"
              data-cy="accTypeFlag"
              :class="{ valid: !v$.accTypeFlag.$invalid, invalid: v$.accTypeFlag.$invalid }"
              v-model="v$.accTypeFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.profitLossFlag')"
              for="financial-transactions-profitLossFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="profitLossFlag"
              id="financial-transactions-profitLossFlag"
              data-cy="profitLossFlag"
              :class="{ valid: !v$.profitLossFlag.$invalid, invalid: v$.profitLossFlag.$invalid }"
              v-model="v$.profitLossFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.proformaYn')"
              for="financial-transactions-proformaYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="proformaYn"
              id="financial-transactions-proformaYn"
              data-cy="proformaYn"
              :class="{ valid: !v$.proformaYn.$invalid, invalid: v$.proformaYn.$invalid }"
              v-model="v$.proformaYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.holdYn')"
              for="financial-transactions-holdYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="holdYn"
              id="financial-transactions-holdYn"
              data-cy="holdYn"
              :class="{ valid: !v$.holdYn.$invalid, invalid: v$.holdYn.$invalid }"
              v-model="v$.holdYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeDifferenceYn')"
              for="financial-transactions-exchangeDifferenceYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="exchangeDifferenceYn"
              id="financial-transactions-exchangeDifferenceYn"
              data-cy="exchangeDifferenceYn"
              :class="{ valid: !v$.exchangeDifferenceYn.$invalid, invalid: v$.exchangeDifferenceYn.$invalid }"
              v-model="v$.exchangeDifferenceYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.calcPointsYn')"
              for="financial-transactions-calcPointsYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="calcPointsYn"
              id="financial-transactions-calcPointsYn"
              data-cy="calcPointsYn"
              :class="{ valid: !v$.calcPointsYn.$invalid, invalid: v$.calcPointsYn.$invalid }"
              v-model="v$.calcPointsYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.arChargeTransferYn')"
              for="financial-transactions-arChargeTransferYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arChargeTransferYn"
              id="financial-transactions-arChargeTransferYn"
              data-cy="arChargeTransferYn"
              :class="{ valid: !v$.arChargeTransferYn.$invalid, invalid: v$.arChargeTransferYn.$invalid }"
              v-model="v$.arChargeTransferYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.processed8300Yn')"
              for="financial-transactions-processed8300Yn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="processed8300Yn"
              id="financial-transactions-processed8300Yn"
              data-cy="processed8300Yn"
              :class="{ valid: !v$.processed8300Yn.$invalid, invalid: v$.processed8300Yn.$invalid }"
              v-model="v$.processed8300Yn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.asbFlag')"
              for="financial-transactions-asbFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="asbFlag"
              id="financial-transactions-asbFlag"
              data-cy="asbFlag"
              :class="{ valid: !v$.asbFlag.$invalid, invalid: v$.asbFlag.$invalid }"
              v-model="v$.asbFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.postitYn')"
              for="financial-transactions-postitYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="postitYn"
              id="financial-transactions-postitYn"
              data-cy="postitYn"
              :class="{ valid: !v$.postitYn.$invalid, invalid: v$.postitYn.$invalid }"
              v-model="v$.postitYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.autoSettleYn')"
              for="financial-transactions-autoSettleYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="autoSettleYn"
              id="financial-transactions-autoSettleYn"
              data-cy="autoSettleYn"
              :class="{ valid: !v$.autoSettleYn.$invalid, invalid: v$.autoSettleYn.$invalid }"
              v-model="v$.autoSettleYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.depTaxTransferedYn')"
              for="financial-transactions-depTaxTransferedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="depTaxTransferedYn"
              id="financial-transactions-depTaxTransferedYn"
              data-cy="depTaxTransferedYn"
              :class="{ valid: !v$.depTaxTransferedYn.$invalid, invalid: v$.depTaxTransferedYn.$invalid }"
              v-model="v$.depTaxTransferedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.autoCreditbillYn')"
              for="financial-transactions-autoCreditbillYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="autoCreditbillYn"
              id="financial-transactions-autoCreditbillYn"
              data-cy="autoCreditbillYn"
              :class="{ valid: !v$.autoCreditbillYn.$invalid, invalid: v$.autoCreditbillYn.$invalid }"
              v-model="v$.autoCreditbillYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.asbOnlyPostTaxesOnceYn')"
              for="financial-transactions-asbOnlyPostTaxesOnceYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="asbOnlyPostTaxesOnceYn"
              id="financial-transactions-asbOnlyPostTaxesOnceYn"
              data-cy="asbOnlyPostTaxesOnceYn"
              :class="{ valid: !v$.asbOnlyPostTaxesOnceYn.$invalid, invalid: v$.asbOnlyPostTaxesOnceYn.$invalid }"
              v-model="v$.asbOnlyPostTaxesOnceYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.roundFactorYn')"
              for="financial-transactions-roundFactorYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roundFactorYn"
              id="financial-transactions-roundFactorYn"
              data-cy="roundFactorYn"
              :class="{ valid: !v$.roundFactorYn.$invalid, invalid: v$.roundFactorYn.$invalid }"
              v-model="v$.roundFactorYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.depPostingFlag')"
              for="financial-transactions-depPostingFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="depPostingFlag"
              id="financial-transactions-depPostingFlag"
              data-cy="depPostingFlag"
              :class="{ valid: !v$.depPostingFlag.$invalid, invalid: v$.depPostingFlag.$invalid }"
              v-model="v$.depPostingFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.correctionYn')"
              for="financial-transactions-correctionYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="correctionYn"
              id="financial-transactions-correctionYn"
              data-cy="correctionYn"
              :class="{ valid: !v$.correctionYn.$invalid, invalid: v$.correctionYn.$invalid }"
              v-model="v$.correctionYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.routedYn')"
              for="financial-transactions-routedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="routedYn"
              id="financial-transactions-routedYn"
              data-cy="routedYn"
              :class="{ valid: !v$.routedYn.$invalid, invalid: v$.routedYn.$invalid }"
              v-model="v$.routedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.upsellChargeYn')"
              for="financial-transactions-upsellChargeYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="upsellChargeYn"
              id="financial-transactions-upsellChargeYn"
              data-cy="upsellChargeYn"
              :class="{ valid: !v$.upsellChargeYn.$invalid, invalid: v$.upsellChargeYn.$invalid }"
              v-model="v$.upsellChargeYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.advanceBillYn')"
              for="financial-transactions-advanceBillYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="advanceBillYn"
              id="financial-transactions-advanceBillYn"
              data-cy="advanceBillYn"
              :class="{ valid: !v$.advanceBillYn.$invalid, invalid: v$.advanceBillYn.$invalid }"
              v-model="v$.advanceBillYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.advanceBillReversedYn')"
              for="financial-transactions-advanceBillReversedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="advanceBillReversedYn"
              id="financial-transactions-advanceBillReversedYn"
              data-cy="advanceBillReversedYn"
              :class="{ valid: !v$.advanceBillReversedYn.$invalid, invalid: v$.advanceBillReversedYn.$invalid }"
              v-model="v$.advanceBillReversedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.incTaxDeductedYn')"
              for="financial-transactions-incTaxDeductedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="incTaxDeductedYn"
              id="financial-transactions-incTaxDeductedYn"
              data-cy="incTaxDeductedYn"
              :class="{ valid: !v$.incTaxDeductedYn.$invalid, invalid: v$.incTaxDeductedYn.$invalid }"
              v-model="v$.incTaxDeductedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.gpAwardCancelledYn')"
              for="financial-transactions-gpAwardCancelledYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="gpAwardCancelledYn"
              id="financial-transactions-gpAwardCancelledYn"
              data-cy="gpAwardCancelledYn"
              :class="{ valid: !v$.gpAwardCancelledYn.$invalid, invalid: v$.gpAwardCancelledYn.$invalid }"
              v-model="v$.gpAwardCancelledYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.serviceRecoveryAdjustmentYn')"
              for="financial-transactions-serviceRecoveryAdjustmentYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="serviceRecoveryAdjustmentYn"
              id="financial-transactions-serviceRecoveryAdjustmentYn"
              data-cy="serviceRecoveryAdjustmentYn"
              :class="{ valid: !v$.serviceRecoveryAdjustmentYn.$invalid, invalid: v$.serviceRecoveryAdjustmentYn.$invalid }"
              v-model="v$.serviceRecoveryAdjustmentYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.splitType')"
              for="financial-transactions-splitType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="splitType"
              id="financial-transactions-splitType"
              data-cy="splitType"
              :class="{ valid: !v$.splitType.$invalid, invalid: v$.splitType.$invalid }"
              v-model="v$.splitType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.bucketRedempYn')"
              for="financial-transactions-bucketRedempYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="bucketRedempYn"
              id="financial-transactions-bucketRedempYn"
              data-cy="bucketRedempYn"
              :class="{ valid: !v$.bucketRedempYn.$invalid, invalid: v$.bucketRedempYn.$invalid }"
              v-model="v$.bucketRedempYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.vatOffsetYn')"
              for="financial-transactions-vatOffsetYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="vatOffsetYn"
              id="financial-transactions-vatOffsetYn"
              data-cy="vatOffsetYn"
              :class="{ valid: !v$.vatOffsetYn.$invalid, invalid: v$.vatOffsetYn.$invalid }"
              v-model="v$.vatOffsetYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.forexTaxYn')"
              for="financial-transactions-forexTaxYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="forexTaxYn"
              id="financial-transactions-forexTaxYn"
              data-cy="forexTaxYn"
              :class="{ valid: !v$.forexTaxYn.$invalid, invalid: v$.forexTaxYn.$invalid }"
              v-model="v$.forexTaxYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.stampDutyYn')"
              for="financial-transactions-stampDutyYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="stampDutyYn"
              id="financial-transactions-stampDutyYn"
              data-cy="stampDutyYn"
              :class="{ valid: !v$.stampDutyYn.$invalid, invalid: v$.stampDutyYn.$invalid }"
              v-model="v$.stampDutyYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.covers')"
              for="financial-transactions-covers"
            ></label>
            <input
              type="text"
              class="form-control"
              name="covers"
              id="financial-transactions-covers"
              data-cy="covers"
              :class="{ valid: !v$.covers.$invalid, invalid: v$.covers.$invalid }"
              v-model="v$.covers.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.advGenerateAdjustment')"
              for="financial-transactions-advGenerateAdjustment"
            ></label>
            <input
              type="text"
              class="form-control"
              name="advGenerateAdjustment"
              id="financial-transactions-advGenerateAdjustment"
              data-cy="advGenerateAdjustment"
              :class="{ valid: !v$.advGenerateAdjustment.$invalid, invalid: v$.advGenerateAdjustment.$invalid }"
              v-model="v$.advGenerateAdjustment.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.expInvoiceType')"
              for="financial-transactions-expInvoiceType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="expInvoiceType"
              id="financial-transactions-expInvoiceType"
              data-cy="expInvoiceType"
              :class="{ valid: !v$.expInvoiceType.$invalid, invalid: v$.expInvoiceType.$invalid }"
              v-model="v$.expInvoiceType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.folioType')"
              for="financial-transactions-folioType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="folioType"
              id="financial-transactions-folioType"
              data-cy="folioType"
              :class="{ valid: !v$.folioType.$invalid, invalid: v$.folioType.$invalid }"
              v-model="v$.folioType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.orgFolioType')"
              for="financial-transactions-orgFolioType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="orgFolioType"
              id="financial-transactions-orgFolioType"
              data-cy="orgFolioType"
              :class="{ valid: !v$.orgFolioType.$invalid, invalid: v$.orgFolioType.$invalid }"
              v-model="v$.orgFolioType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.invoiceType')"
              for="financial-transactions-invoiceType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="invoiceType"
              id="financial-transactions-invoiceType"
              data-cy="invoiceType"
              :class="{ valid: !v$.invoiceType.$invalid, invalid: v$.invoiceType.$invalid }"
              v-model="v$.invoiceType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.arState')"
              for="financial-transactions-arState"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arState"
              id="financial-transactions-arState"
              data-cy="arState"
              :class="{ valid: !v$.arState.$invalid, invalid: v$.arState.$invalid }"
              v-model="v$.arState.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.exchangeType')"
              for="financial-transactions-exchangeType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="exchangeType"
              id="financial-transactions-exchangeType"
              data-cy="exchangeType"
              :class="{ valid: !v$.exchangeType.$invalid, invalid: v$.exchangeType.$invalid }"
              v-model="v$.exchangeType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.recptType')"
              for="financial-transactions-recptType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="recptType"
              id="financial-transactions-recptType"
              data-cy="recptType"
              :class="{ valid: !v$.recptType.$invalid, invalid: v$.recptType.$invalid }"
              v-model="v$.recptType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.roomClass')"
              for="financial-transactions-roomClass"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomClass"
              id="financial-transactions-roomClass"
              data-cy="roomClass"
              :class="{ valid: !v$.roomClass.$invalid, invalid: v$.roomClass.$invalid }"
              v-model="v$.roomClass.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.resort')"
              for="financial-transactions-resort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resort"
              id="financial-transactions-resort"
              data-cy="resort"
              :class="{ valid: !v$.resort.$invalid, invalid: v$.resort.$invalid }"
              v-model="v$.resort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.tcGroup')"
              for="financial-transactions-tcGroup"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tcGroup"
              id="financial-transactions-tcGroup"
              data-cy="tcGroup"
              :class="{ valid: !v$.tcGroup.$invalid, invalid: v$.tcGroup.$invalid }"
              v-model="v$.tcGroup.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.tcSubgroup')"
              for="financial-transactions-tcSubgroup"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tcSubgroup"
              id="financial-transactions-tcSubgroup"
              data-cy="tcSubgroup"
              :class="{ valid: !v$.tcSubgroup.$invalid, invalid: v$.tcSubgroup.$invalid }"
              v-model="v$.tcSubgroup.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trxCode')"
              for="financial-transactions-trxCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="trxCode"
              id="financial-transactions-trxCode"
              data-cy="trxCode"
              :class="{ valid: !v$.trxCode.$invalid, invalid: v$.trxCode.$invalid }"
              v-model="v$.trxCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.room')"
              for="financial-transactions-room"
            ></label>
            <input
              type="text"
              class="form-control"
              name="room"
              id="financial-transactions-room"
              data-cy="room"
              :class="{ valid: !v$.room.$invalid, invalid: v$.room.$invalid }"
              v-model="v$.room.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.tclCode1')"
              for="financial-transactions-tclCode1"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tclCode1"
              id="financial-transactions-tclCode1"
              data-cy="tclCode1"
              :class="{ valid: !v$.tclCode1.$invalid, invalid: v$.tclCode1.$invalid }"
              v-model="v$.tclCode1.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.currency')"
              for="financial-transactions-currency"
            ></label>
            <input
              type="text"
              class="form-control"
              name="currency"
              id="financial-transactions-currency"
              data-cy="currency"
              :class="{ valid: !v$.currency.$invalid, invalid: v$.currency.$invalid }"
              v-model="v$.currency.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.ftGeneratedType')"
              for="financial-transactions-ftGeneratedType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ftGeneratedType"
              id="financial-transactions-ftGeneratedType"
              data-cy="ftGeneratedType"
              :class="{ valid: !v$.ftGeneratedType.$invalid, invalid: v$.ftGeneratedType.$invalid }"
              v-model="v$.ftGeneratedType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.tclCode2')"
              for="financial-transactions-tclCode2"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tclCode2"
              id="financial-transactions-tclCode2"
              data-cy="tclCode2"
              :class="{ valid: !v$.tclCode2.$invalid, invalid: v$.tclCode2.$invalid }"
              v-model="v$.tclCode2.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.marketCode')"
              for="financial-transactions-marketCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="marketCode"
              id="financial-transactions-marketCode"
              data-cy="marketCode"
              :class="{ valid: !v$.marketCode.$invalid, invalid: v$.marketCode.$invalid }"
              v-model="v$.marketCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.sourceCode')"
              for="financial-transactions-sourceCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sourceCode"
              id="financial-transactions-sourceCode"
              data-cy="sourceCode"
              :class="{ valid: !v$.sourceCode.$invalid, invalid: v$.sourceCode.$invalid }"
              v-model="v$.sourceCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.rateCode')"
              for="financial-transactions-rateCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rateCode"
              id="financial-transactions-rateCode"
              data-cy="rateCode"
              :class="{ valid: !v$.rateCode.$invalid, invalid: v$.rateCode.$invalid }"
              v-model="v$.rateCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.hotelAcct')"
              for="financial-transactions-hotelAcct"
            ></label>
            <input
              type="text"
              class="form-control"
              name="hotelAcct"
              id="financial-transactions-hotelAcct"
              data-cy="hotelAcct"
              :class="{ valid: !v$.hotelAcct.$invalid, invalid: v$.hotelAcct.$invalid }"
              v-model="v$.hotelAcct.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.reasonCode')"
              for="financial-transactions-reasonCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="reasonCode"
              id="financial-transactions-reasonCode"
              data-cy="reasonCode"
              :class="{ valid: !v$.reasonCode.$invalid, invalid: v$.reasonCode.$invalid }"
              v-model="v$.reasonCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.product')"
              for="financial-transactions-product"
            ></label>
            <input
              type="text"
              class="form-control"
              name="product"
              id="financial-transactions-product"
              data-cy="product"
              :class="{ valid: !v$.product.$invalid, invalid: v$.product.$invalid }"
              v-model="v$.product.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.targetResort')"
              for="financial-transactions-targetResort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="targetResort"
              id="financial-transactions-targetResort"
              data-cy="targetResort"
              :class="{ valid: !v$.targetResort.$invalid, invalid: v$.targetResort.$invalid }"
              v-model="v$.targetResort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.nameTaxType')"
              for="financial-transactions-nameTaxType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="nameTaxType"
              id="financial-transactions-nameTaxType"
              data-cy="nameTaxType"
              :class="{ valid: !v$.nameTaxType.$invalid, invalid: v$.nameTaxType.$invalid }"
              v-model="v$.nameTaxType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.taxInvNo')"
              for="financial-transactions-taxInvNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="taxInvNo"
              id="financial-transactions-taxInvNo"
              data-cy="taxInvNo"
              :class="{ valid: !v$.taxInvNo.$invalid, invalid: v$.taxInvNo.$invalid }"
              v-model="v$.taxInvNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.approvalCode')"
              for="financial-transactions-approvalCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="approvalCode"
              id="financial-transactions-approvalCode"
              data-cy="approvalCode"
              :class="{ valid: !v$.approvalCode.$invalid, invalid: v$.approvalCode.$invalid }"
              v-model="v$.approvalCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.approvalStatus')"
              for="financial-transactions-approvalStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="approvalStatus"
              id="financial-transactions-approvalStatus"
              data-cy="approvalStatus"
              :class="{ valid: !v$.approvalStatus.$invalid, invalid: v$.approvalStatus.$invalid }"
              v-model="v$.approvalStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.compLinkTrxCode')"
              for="financial-transactions-compLinkTrxCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="compLinkTrxCode"
              id="financial-transactions-compLinkTrxCode"
              data-cy="compLinkTrxCode"
              :class="{ valid: !v$.compLinkTrxCode.$invalid, invalid: v$.compLinkTrxCode.$invalid }"
              v-model="v$.compLinkTrxCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.compTypeCode')"
              for="financial-transactions-compTypeCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="compTypeCode"
              id="financial-transactions-compTypeCode"
              data-cy="compTypeCode"
              :class="{ valid: !v$.compTypeCode.$invalid, invalid: v$.compTypeCode.$invalid }"
              v-model="v$.compTypeCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.couponNo')"
              for="financial-transactions-couponNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="couponNo"
              id="financial-transactions-couponNo"
              data-cy="couponNo"
              :class="{ valid: !v$.couponNo.$invalid, invalid: v$.couponNo.$invalid }"
              v-model="v$.couponNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.originalRoom')"
              for="financial-transactions-originalRoom"
            ></label>
            <input
              type="text"
              class="form-control"
              name="originalRoom"
              id="financial-transactions-originalRoom"
              data-cy="originalRoom"
              :class="{ valid: !v$.originalRoom.$invalid, invalid: v$.originalRoom.$invalid }"
              v-model="v$.originalRoom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.allowanceType')"
              for="financial-transactions-allowanceType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="allowanceType"
              id="financial-transactions-allowanceType"
              data-cy="allowanceType"
              :class="{ valid: !v$.allowanceType.$invalid, invalid: v$.allowanceType.$invalid }"
              v-model="v$.allowanceType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.advGenerateTrxCode')"
              for="financial-transactions-advGenerateTrxCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="advGenerateTrxCode"
              id="financial-transactions-advGenerateTrxCode"
              data-cy="advGenerateTrxCode"
              :class="{ valid: !v$.advGenerateTrxCode.$invalid, invalid: v$.advGenerateTrxCode.$invalid }"
              v-model="v$.advGenerateTrxCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.trxServiceType')"
              for="financial-transactions-trxServiceType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="trxServiceType"
              id="financial-transactions-trxServiceType"
              data-cy="trxServiceType"
              :class="{ valid: !v$.trxServiceType.$invalid, invalid: v$.trxServiceType.$invalid }"
              v-model="v$.trxServiceType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.postingType')"
              for="financial-transactions-postingType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="postingType"
              id="financial-transactions-postingType"
              data-cy="postingType"
              :class="{ valid: !v$.postingType.$invalid, invalid: v$.postingType.$invalid }"
              v-model="v$.postingType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.parallelCurrency')"
              for="financial-transactions-parallelCurrency"
            ></label>
            <input
              type="text"
              class="form-control"
              name="parallelCurrency"
              id="financial-transactions-parallelCurrency"
              data-cy="parallelCurrency"
              :class="{ valid: !v$.parallelCurrency.$invalid, invalid: v$.parallelCurrency.$invalid }"
              v-model="v$.parallelCurrency.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.contractCurrency')"
              for="financial-transactions-contractCurrency"
            ></label>
            <input
              type="text"
              class="form-control"
              name="contractCurrency"
              id="financial-transactions-contractCurrency"
              data-cy="contractCurrency"
              :class="{ valid: !v$.contractCurrency.$invalid, invalid: v$.contractCurrency.$invalid }"
              v-model="v$.contractCurrency.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.fbaCertificateNumber')"
              for="financial-transactions-fbaCertificateNumber"
            ></label>
            <input
              type="text"
              class="form-control"
              name="fbaCertificateNumber"
              id="financial-transactions-fbaCertificateNumber"
              data-cy="fbaCertificateNumber"
              :class="{ valid: !v$.fbaCertificateNumber.$invalid, invalid: v$.fbaCertificateNumber.$invalid }"
              v-model="v$.fbaCertificateNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.postingRhythm')"
              for="financial-transactions-postingRhythm"
            ></label>
            <input
              type="text"
              class="form-control"
              name="postingRhythm"
              id="financial-transactions-postingRhythm"
              data-cy="postingRhythm"
              :class="{ valid: !v$.postingRhythm.$invalid, invalid: v$.postingRhythm.$invalid }"
              v-model="v$.postingRhythm.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.asbTaxFlag')"
              for="financial-transactions-asbTaxFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="asbTaxFlag"
              id="financial-transactions-asbTaxFlag"
              data-cy="asbTaxFlag"
              :class="{ valid: !v$.asbTaxFlag.$invalid, invalid: v$.asbTaxFlag.$invalid }"
              v-model="v$.asbTaxFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.packageArrangementCode')"
              for="financial-transactions-packageArrangementCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="packageArrangementCode"
              id="financial-transactions-packageArrangementCode"
              data-cy="packageArrangementCode"
              :class="{ valid: !v$.packageArrangementCode.$invalid, invalid: v$.packageArrangementCode.$invalid }"
              v-model="v$.packageArrangementCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.gpAwardCode')"
              for="financial-transactions-gpAwardCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="gpAwardCode"
              id="financial-transactions-gpAwardCode"
              data-cy="gpAwardCode"
              :class="{ valid: !v$.gpAwardCode.$invalid, invalid: v$.gpAwardCode.$invalid }"
              v-model="v$.gpAwardCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.gpAwardCancelCode')"
              for="financial-transactions-gpAwardCancelCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="gpAwardCancelCode"
              id="financial-transactions-gpAwardCancelCode"
              data-cy="gpAwardCancelCode"
              :class="{ valid: !v$.gpAwardCancelCode.$invalid, invalid: v$.gpAwardCancelCode.$invalid }"
              v-model="v$.gpAwardCancelCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.serviceRecoveryDeptCode')"
              for="financial-transactions-serviceRecoveryDeptCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="serviceRecoveryDeptCode"
              id="financial-transactions-serviceRecoveryDeptCode"
              data-cy="serviceRecoveryDeptCode"
              :class="{ valid: !v$.serviceRecoveryDeptCode.$invalid, invalid: v$.serviceRecoveryDeptCode.$invalid }"
              v-model="v$.serviceRecoveryDeptCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.bucketCode')"
              for="financial-transactions-bucketCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="bucketCode"
              id="financial-transactions-bucketCode"
              data-cy="bucketCode"
              :class="{ valid: !v$.bucketCode.$invalid, invalid: v$.bucketCode.$invalid }"
              v-model="v$.bucketCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.taxRateType')"
              for="financial-transactions-taxRateType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="taxRateType"
              id="financial-transactions-taxRateType"
              data-cy="taxRateType"
              :class="{ valid: !v$.taxRateType.$invalid, invalid: v$.taxRateType.$invalid }"
              v-model="v$.taxRateType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.chequeNumber')"
              for="financial-transactions-chequeNumber"
            ></label>
            <input
              type="text"
              class="form-control"
              name="chequeNumber"
              id="financial-transactions-chequeNumber"
              data-cy="chequeNumber"
              :class="{ valid: !v$.chequeNumber.$invalid, invalid: v$.chequeNumber.$invalid }"
              v-model="v$.chequeNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.passerByName')"
              for="financial-transactions-passerByName"
            ></label>
            <input
              type="text"
              class="form-control"
              name="passerByName"
              id="financial-transactions-passerByName"
              data-cy="passerByName"
              :class="{ valid: !v$.passerByName.$invalid, invalid: v$.passerByName.$invalid }"
              v-model="v$.passerByName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.esignedReceiptName')"
              for="financial-transactions-esignedReceiptName"
            ></label>
            <input
              type="text"
              class="form-control"
              name="esignedReceiptName"
              id="financial-transactions-esignedReceiptName"
              data-cy="esignedReceiptName"
              :class="{ valid: !v$.esignedReceiptName.$invalid, invalid: v$.esignedReceiptName.$invalid }"
              v-model="v$.esignedReceiptName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.remark')"
              for="financial-transactions-remark"
            ></label>
            <input
              type="text"
              class="form-control"
              name="remark"
              id="financial-transactions-remark"
              data-cy="remark"
              :class="{ valid: !v$.remark.$invalid, invalid: v$.remark.$invalid }"
              v-model="v$.remark.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.reference')"
              for="financial-transactions-reference"
            ></label>
            <input
              type="text"
              class="form-control"
              name="reference"
              id="financial-transactions-reference"
              data-cy="reference"
              :class="{ valid: !v$.reference.$invalid, invalid: v$.reference.$invalid }"
              v-model="v$.reference.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.oTrxDesc')"
              for="financial-transactions-oTrxDesc"
            ></label>
            <input
              type="text"
              class="form-control"
              name="oTrxDesc"
              id="financial-transactions-oTrxDesc"
              data-cy="oTrxDesc"
              :class="{ valid: !v$.oTrxDesc.$invalid, invalid: v$.oTrxDesc.$invalid }"
              v-model="v$.oTrxDesc.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.comments')"
              for="financial-transactions-comments"
            ></label>
            <input
              type="text"
              class="form-control"
              name="comments"
              id="financial-transactions-comments"
              data-cy="comments"
              :class="{ valid: !v$.comments.$invalid, invalid: v$.comments.$invalid }"
              v-model="v$.comments.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.fiscalBillNo')"
              for="financial-transactions-fiscalBillNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="fiscalBillNo"
              id="financial-transactions-fiscalBillNo"
              data-cy="fiscalBillNo"
              :class="{ valid: !v$.fiscalBillNo.$invalid, invalid: v$.fiscalBillNo.$invalid }"
              v-model="v$.fiscalBillNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.extSysResultMsg')"
              for="financial-transactions-extSysResultMsg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="extSysResultMsg"
              id="financial-transactions-extSysResultMsg"
              data-cy="extSysResultMsg"
              :class="{ valid: !v$.extSysResultMsg.$invalid, invalid: v$.extSysResultMsg.$invalid }"
              v-model="v$.extSysResultMsg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.queueName')"
              for="financial-transactions-queueName"
            ></label>
            <input
              type="text"
              class="form-control"
              name="queueName"
              id="financial-transactions-queueName"
              data-cy="queueName"
              :class="{ valid: !v$.queueName.$invalid, invalid: v$.queueName.$invalid }"
              v-model="v$.queueName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.paymentType')"
              for="financial-transactions-paymentType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="paymentType"
              id="financial-transactions-paymentType"
              data-cy="paymentType"
              :class="{ valid: !v$.paymentType.$invalid, invalid: v$.paymentType.$invalid }"
              v-model="v$.paymentType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.ccRefundPosting')"
              for="financial-transactions-ccRefundPosting"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ccRefundPosting"
              id="financial-transactions-ccRefundPosting"
              data-cy="ccRefundPosting"
              :class="{ valid: !v$.ccRefundPosting.$invalid, invalid: v$.ccRefundPosting.$invalid }"
              v-model="v$.ccRefundPosting.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdEntityType')"
              for="financial-transactions-thresholdEntityType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="thresholdEntityType"
              id="financial-transactions-thresholdEntityType"
              data-cy="thresholdEntityType"
              :class="{ valid: !v$.thresholdEntityType.$invalid, invalid: v$.thresholdEntityType.$invalid }"
              v-model="v$.thresholdEntityType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.thresholdTreatmentFlag')"
              for="financial-transactions-thresholdTreatmentFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="thresholdTreatmentFlag"
              id="financial-transactions-thresholdTreatmentFlag"
              data-cy="thresholdTreatmentFlag"
              :class="{ valid: !v$.thresholdTreatmentFlag.$invalid, invalid: v$.thresholdTreatmentFlag.$invalid }"
              v-model="v$.thresholdTreatmentFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.paymentSurchargeType')"
              for="financial-transactions-paymentSurchargeType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="paymentSurchargeType"
              id="financial-transactions-paymentSurchargeType"
              data-cy="paymentSurchargeType"
              :class="{ valid: !v$.paymentSurchargeType.$invalid, invalid: v$.paymentSurchargeType.$invalid }"
              v-model="v$.paymentSurchargeType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.propertyBillPrefix')"
              for="financial-transactions-propertyBillPrefix"
            ></label>
            <input
              type="text"
              class="form-control"
              name="propertyBillPrefix"
              id="financial-transactions-propertyBillPrefix"
              data-cy="propertyBillPrefix"
              :class="{ valid: !v$.propertyBillPrefix.$invalid, invalid: v$.propertyBillPrefix.$invalid }"
              v-model="v$.propertyBillPrefix.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.taxElements')"
              for="financial-transactions-taxElements"
            ></label>
            <input
              type="text"
              class="form-control"
              name="taxElements"
              id="financial-transactions-taxElements"
              data-cy="taxElements"
              :class="{ valid: !v$.taxElements.$invalid, invalid: v$.taxElements.$invalid }"
              v-model="v$.taxElements.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.numberDialed')"
              for="financial-transactions-numberDialed"
            ></label>
            <input
              type="text"
              class="form-control"
              name="numberDialed"
              id="financial-transactions-numberDialed"
              data-cy="numberDialed"
              :class="{ valid: !v$.numberDialed.$invalid, invalid: v$.numberDialed.$invalid }"
              v-model="v$.numberDialed.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.checkFileId')"
              for="financial-transactions-checkFileId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="checkFileId"
              id="financial-transactions-checkFileId"
              data-cy="checkFileId"
              :class="{ valid: !v$.checkFileId.$invalid, invalid: v$.checkFileId.$invalid }"
              v-model="v$.checkFileId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.extTrxId')"
              for="financial-transactions-extTrxId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="extTrxId"
              id="financial-transactions-extTrxId"
              data-cy="extTrxId"
              :class="{ valid: !v$.extTrxId.$invalid, invalid: v$.extTrxId.$invalid }"
              v-model="v$.extTrxId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.packageTrxType')"
              for="financial-transactions-packageTrxType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="packageTrxType"
              id="financial-transactions-packageTrxType"
              data-cy="packageTrxType"
              :class="{ valid: !v$.packageTrxType.$invalid, invalid: v$.packageTrxType.$invalid }"
              v-model="v$.packageTrxType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.expOriginalInvoice')"
              for="financial-transactions-expOriginalInvoice"
            ></label>
            <input
              type="text"
              class="form-control"
              name="expOriginalInvoice"
              id="financial-transactions-expOriginalInvoice"
              data-cy="expOriginalInvoice"
              :class="{ valid: !v$.expOriginalInvoice.$invalid, invalid: v$.expOriginalInvoice.$invalid }"
              v-model="v$.expOriginalInvoice.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.financialTransactions.depositTransactionId')"
              for="financial-transactions-depositTransactionId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="depositTransactionId"
              id="financial-transactions-depositTransactionId"
              data-cy="depositTransactionId"
              :class="{ valid: !v$.depositTransactionId.$invalid, invalid: v$.depositTransactionId.$invalid }"
              v-model="v$.depositTransactionId.$model"
            />
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.cancel')"></span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="v$.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="t$('entity.action.save')"></span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./financial-transactions-update.component.ts"></script>
