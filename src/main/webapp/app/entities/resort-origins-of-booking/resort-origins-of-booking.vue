<template>
  <div>
    <h2 id="page-heading" data-cy="ResortOriginsOfBookingHeading">
      <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.home.title')" id="resort-origins-of-booking-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ResortOriginsOfBookingCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-resort-origins-of-booking"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && resortOriginsOfBookings && resortOriginsOfBookings.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="resortOriginsOfBookings && resortOriginsOfBookings.length > 0">
      <table class="table table-striped" aria-describedby="resortOriginsOfBookings">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resort')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.resort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sourceCode')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.sourceCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sourceCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('parentSourceCode')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.parentSourceCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'parentSourceCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('description')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.description')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'description'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('inactiveDate')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.inactiveDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'inactiveDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('sellSequence')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.sellSequence')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sellSequence'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('scOrderby')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.scOrderby')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'scOrderby'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('internetSalesYn')">
              <span v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.internetSalesYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'internetSalesYn'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="resortOriginsOfBooking in resortOriginsOfBookings" :key="resortOriginsOfBooking.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ResortOriginsOfBookingView', params: { resortOriginsOfBookingId: resortOriginsOfBooking.id } }">{{
                resortOriginsOfBooking.id
              }}</router-link>
            </td>
            <td>{{ resortOriginsOfBooking.resort }}</td>
            <td>{{ resortOriginsOfBooking.sourceCode }}</td>
            <td>{{ resortOriginsOfBooking.parentSourceCode }}</td>
            <td>{{ resortOriginsOfBooking.description }}</td>
            <td>{{ resortOriginsOfBooking.insertUser }}</td>
            <td>{{ resortOriginsOfBooking.insertDate }}</td>
            <td>{{ resortOriginsOfBooking.updateUser }}</td>
            <td>{{ resortOriginsOfBooking.updateDate }}</td>
            <td>{{ resortOriginsOfBooking.inactiveDate }}</td>
            <td>{{ resortOriginsOfBooking.sellSequence }}</td>
            <td>{{ resortOriginsOfBooking.scOrderby }}</td>
            <td>{{ resortOriginsOfBooking.internetSalesYn }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ResortOriginsOfBookingView', params: { resortOriginsOfBookingId: resortOriginsOfBooking.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ResortOriginsOfBookingEdit', params: { resortOriginsOfBookingId: resortOriginsOfBooking.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(resortOriginsOfBooking)"
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
          id="operaHandlerApplicationApp.resortOriginsOfBooking.delete.question"
          data-cy="resortOriginsOfBookingDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p
          id="jhi-delete-resortOriginsOfBooking-heading"
          v-text="t$('operaHandlerApplicationApp.resortOriginsOfBooking.delete.question', { id: removeId })"
        ></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-resortOriginsOfBooking"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeResortOriginsOfBooking()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="resortOriginsOfBookings && resortOriginsOfBookings.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./resort-origins-of-booking.component.ts"></script>
