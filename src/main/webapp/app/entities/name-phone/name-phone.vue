<template>
  <div>
    <h2 id="page-heading" data-cy="NamePhoneHeading">
      <span v-text="t$('operaHandlerApplicationApp.namePhone.home.title')" id="name-phone-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.namePhone.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'NamePhoneCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-name-phone"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.namePhone.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && namePhones && namePhones.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.namePhone.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="namePhones && namePhones.length > 0">
      <table class="table table-striped" aria-describedby="namePhones">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('phoneId')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.phoneId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'phoneId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameId')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.nameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('phoneType')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.phoneType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'phoneType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('phoneRole')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.phoneRole')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'phoneRole'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('phoneNumber')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.phoneNumber')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'phoneNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveDate')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.inactiveDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inactiveDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('endDate')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.endDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'endDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('beginDate')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.beginDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'beginDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('addressId')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.addressId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'addressId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('primaryYn')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.primaryYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'primaryYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('displaySeq')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.displaySeq')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'displaySeq'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('laptopChange')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.laptopChange')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'laptopChange'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('indexPhone')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.indexPhone')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'indexPhone'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extension')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.extension')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extension'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('emailFormat')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.emailFormat')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'emailFormat'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('shareEmailYn')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.shareEmailYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'shareEmailYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('defaultConfirmationYn')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.defaultConfirmationYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'defaultConfirmationYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('emailLanguage')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.emailLanguage')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'emailLanguage'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('mobileAudioKeyYn')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.mobileAudioKeyYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mobileAudioKeyYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('countryDialingCode')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.countryDialingCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'countryDialingCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('validYn')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.validYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'validYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('phoneCountryCode')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.phoneCountryCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'phoneCountryCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('chainCode')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.chainCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'chainCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('validateDate')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.validateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'validateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('validateStatus')">
              <span v-text="t$('operaHandlerApplicationApp.namePhone.validateStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'validateStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="namePhone in namePhones" :key="namePhone.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'NamePhoneView', params: { namePhoneId: namePhone.id } }">{{ namePhone.id }}</router-link>
            </td>
            <td>{{ namePhone.phoneId }}</td>
            <td>{{ namePhone.nameId }}</td>
            <td>{{ namePhone.phoneType }}</td>
            <td>{{ namePhone.phoneRole }}</td>
            <td>{{ namePhone.phoneNumber }}</td>
            <td>{{ namePhone.insertDate }}</td>
            <td>{{ namePhone.insertUser }}</td>
            <td>{{ namePhone.updateDate }}</td>
            <td>{{ namePhone.updateUser }}</td>
            <td>{{ namePhone.inactiveDate }}</td>
            <td>{{ namePhone.endDate }}</td>
            <td>{{ namePhone.beginDate }}</td>
            <td>{{ namePhone.addressId }}</td>
            <td>{{ namePhone.primaryYn }}</td>
            <td>{{ namePhone.displaySeq }}</td>
            <td>{{ namePhone.laptopChange }}</td>
            <td>{{ namePhone.indexPhone }}</td>
            <td>{{ namePhone.extension }}</td>
            <td>{{ namePhone.emailFormat }}</td>
            <td>{{ namePhone.shareEmailYn }}</td>
            <td>{{ namePhone.defaultConfirmationYn }}</td>
            <td>{{ namePhone.emailLanguage }}</td>
            <td>{{ namePhone.mobileAudioKeyYn }}</td>
            <td>{{ namePhone.countryDialingCode }}</td>
            <td>{{ namePhone.validYn }}</td>
            <td>{{ namePhone.phoneCountryCode }}</td>
            <td>{{ namePhone.chainCode }}</td>
            <td>{{ namePhone.validateDate }}</td>
            <td>{{ namePhone.validateStatus }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'NamePhoneView', params: { namePhoneId: namePhone.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'NamePhoneEdit', params: { namePhoneId: namePhone.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(namePhone)"
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
          id="operaHandlerApplicationApp.namePhone.delete.question"
          data-cy="namePhoneDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-namePhone-heading" v-text="t$('operaHandlerApplicationApp.namePhone.delete.question', { id: removeId })"></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-namePhone"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeNamePhone()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="namePhones && namePhones.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./name-phone.component.ts"></script>
