<template>
  <div>
    <h2 id="page-heading" data-cy="NameAddressHeading">
      <span v-text="t$('operaHandlerApplicationApp.nameAddress.home.title')" id="name-address-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.nameAddress.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'NameAddressCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-name-address"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.nameAddress.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && nameAddresses && nameAddresses.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.nameAddress.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="nameAddresses && nameAddresses.length > 0">
      <table class="table table-striped" aria-describedby="nameAddresses">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('addressId')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.addressId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'addressId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('addressType')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.addressType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'addressType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('address1')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.address1')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'address1'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('address2')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.address2')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'address2'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('address3')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.address3')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'address3'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('address4')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.address4')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'address4'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('barcode')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.barcode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'barcode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('beginDate')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.beginDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'beginDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('chainCode')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.chainCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'chainCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('city')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.city')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'city'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cityExt')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.cityExt')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cityExt'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cleansedDatetime')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedDatetime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cleansedDatetime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cleansedErrormsg')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedErrormsg')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cleansedErrormsg'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cleansedMatchstatus')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedMatchstatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cleansedMatchstatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cleansedStatus')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cleansedStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cleansedValidationstatus')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.cleansedValidationstatus')"></span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'cleansedValidationstatus'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('country')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.country')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'country'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('endDate')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.endDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'endDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('foreignCountry')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.foreignCountry')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'foreignCountry'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inCareOf')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.inCareOf')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inCareOf'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveDate')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.inactiveDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inactiveDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('languageCode')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.languageCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'languageCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('laptopChange')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.laptopChange')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'laptopChange'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lastUpdatedResort')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.lastUpdatedResort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lastUpdatedResort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('nameId')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.nameId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'nameId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('primaryYn')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.primaryYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'primaryYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('province')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.province')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'province'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('state')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.state')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'state'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('zipCode')">
              <span v-text="t$('operaHandlerApplicationApp.nameAddress.zipCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'zipCode'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="nameAddress in nameAddresses" :key="nameAddress.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'NameAddressView', params: { nameAddressId: nameAddress.id } }">{{ nameAddress.id }}</router-link>
            </td>
            <td>{{ nameAddress.addressId }}</td>
            <td>{{ nameAddress.addressType }}</td>
            <td>{{ nameAddress.address1 }}</td>
            <td>{{ nameAddress.address2 }}</td>
            <td>{{ nameAddress.address3 }}</td>
            <td>{{ nameAddress.address4 }}</td>
            <td>{{ nameAddress.barcode }}</td>
            <td>{{ nameAddress.beginDate }}</td>
            <td>{{ nameAddress.chainCode }}</td>
            <td>{{ nameAddress.city }}</td>
            <td>{{ nameAddress.cityExt }}</td>
            <td>{{ nameAddress.cleansedDatetime }}</td>
            <td>{{ nameAddress.cleansedErrormsg }}</td>
            <td>{{ nameAddress.cleansedMatchstatus }}</td>
            <td>{{ nameAddress.cleansedStatus }}</td>
            <td>{{ nameAddress.cleansedValidationstatus }}</td>
            <td>{{ nameAddress.country }}</td>
            <td>{{ nameAddress.endDate }}</td>
            <td>{{ nameAddress.foreignCountry }}</td>
            <td>{{ nameAddress.inCareOf }}</td>
            <td>{{ nameAddress.inactiveDate }}</td>
            <td>{{ nameAddress.insertDate }}</td>
            <td>{{ nameAddress.insertUser }}</td>
            <td>{{ nameAddress.languageCode }}</td>
            <td>{{ nameAddress.laptopChange }}</td>
            <td>{{ nameAddress.lastUpdatedResort }}</td>
            <td>{{ nameAddress.nameId }}</td>
            <td>{{ nameAddress.primaryYn }}</td>
            <td>{{ nameAddress.province }}</td>
            <td>{{ nameAddress.state }}</td>
            <td>{{ nameAddress.updateDate }}</td>
            <td>{{ nameAddress.updateUser }}</td>
            <td>{{ nameAddress.zipCode }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'NameAddressView', params: { nameAddressId: nameAddress.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'NameAddressEdit', params: { nameAddressId: nameAddress.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(nameAddress)"
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
          id="operaHandlerApplicationApp.nameAddress.delete.question"
          data-cy="nameAddressDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-nameAddress-heading" v-text="t$('operaHandlerApplicationApp.nameAddress.delete.question', { id: removeId })"></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-nameAddress"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeNameAddress()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="nameAddresses && nameAddresses.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./name-address.component.ts"></script>
