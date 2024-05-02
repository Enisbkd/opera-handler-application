<template>
  <div>
    <h2 id="page-heading" data-cy="ReservationDailyElementsHeading">
      <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.home.title')" id="reservation-daily-elements-heading"></span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.home.refreshListLabel')"></span>
        </button>
        <router-link :to="{ name: 'ReservationDailyElementsCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-reservation-daily-elements"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.home.createLabel')"></span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && reservationDailyElements && reservationDailyElements.length === 0">
      <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.home.notFound')"></span>
    </div>
    <div class="table-responsive" v-if="reservationDailyElements && reservationDailyElements.length > 0">
      <table class="table table-striped" aria-describedby="reservationDailyElements">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="t$('global.field.id')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resort')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.resort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('reservationDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.reservationDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'reservationDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvDailyElSeq')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.resvDailyElSeq')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvDailyElSeq'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('resvStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.resvStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'resvStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('externalReference')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.externalReference')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'externalReference'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomClass')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomClass')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomClass'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomCategory')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bookedRoomCategory')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.bookedRoomCategory')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bookedRoomCategory'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('room')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.room')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'room'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancellationNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancellationNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancellationDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancellationDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancellationCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancellationCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cancellationReasonDesc')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cancellationReasonDesc')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cancellationReasonDesc'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('guaranteeCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.guaranteeCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'guaranteeCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('marketCode')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.marketCode')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'marketCode'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('originOfBooking')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.originOfBooking')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'originOfBooking'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('exchangeRate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.exchangeRate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exchangeRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('originalBaseRate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.originalBaseRate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'originalBaseRate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('baseRateAmount')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.baseRateAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'baseRateAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('rateAmount')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.rateAmount')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'rateAmount'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomCost')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomCost')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomCost'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('quantity')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.quantity')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'quantity'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('adults')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.adults')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'adults'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('children')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.children')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'children'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('physicalQuantity')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.physicalQuantity')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'physicalQuantity'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('allotmentHeaderId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.allotmentHeaderId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'allotmentHeaderId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dayUseYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.dayUseYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dayUseYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dueOutYn')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.dueOutYn')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dueOutYn'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertUser')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.insertUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.insertDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateUser')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.updateUser')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateUser'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('updateDate')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.updateDate')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'updateDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('insertActionInstanceId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.insertActionInstanceId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'insertActionInstanceId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('dmlSeqNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.dmlSeqNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'dmlSeqNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extSeqNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.extSeqNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extSeqNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extSegNo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.extSegNo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extSegNo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('cribs')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.cribs')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'cribs'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('extraBeds')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.extraBeds')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'extraBeds'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('allotmentRecordType')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.allotmentRecordType')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'allotmentRecordType'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('blockResort')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.blockResort')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'blockResort'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('blockId')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.blockId')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'blockId'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('turndownStatus')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.turndownStatus')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'turndownStatus'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awdUpgrFrom')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.awdUpgrFrom')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awdUpgrFrom'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('awdUpgrTo')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.awdUpgrTo')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'awdUpgrTo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hkExpectedServiceTime')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.hkExpectedServiceTime')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hkExpectedServiceTime'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('roomInstructions')">
              <span v-text="t$('operaHandlerApplicationApp.reservationDailyElements.roomInstructions')"></span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'roomInstructions'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="reservationDailyElements in reservationDailyElements" :key="reservationDailyElements.id" data-cy="entityTable">
            <td>
              <router-link
                :to="{ name: 'ReservationDailyElementsView', params: { reservationDailyElementsId: reservationDailyElements.id } }"
                >{{ reservationDailyElements.id }}</router-link
              >
            </td>
            <td>{{ reservationDailyElements.resort }}</td>
            <td>{{ reservationDailyElements.reservationDate }}</td>
            <td>{{ reservationDailyElements.resvDailyElSeq }}</td>
            <td>{{ reservationDailyElements.resvStatus }}</td>
            <td>{{ reservationDailyElements.externalReference }}</td>
            <td>{{ reservationDailyElements.roomClass }}</td>
            <td>{{ reservationDailyElements.roomCategory }}</td>
            <td>{{ reservationDailyElements.bookedRoomCategory }}</td>
            <td>{{ reservationDailyElements.room }}</td>
            <td>{{ reservationDailyElements.cancellationNo }}</td>
            <td>{{ reservationDailyElements.cancellationDate }}</td>
            <td>{{ reservationDailyElements.cancellationCode }}</td>
            <td>{{ reservationDailyElements.cancellationReasonDesc }}</td>
            <td>{{ reservationDailyElements.guaranteeCode }}</td>
            <td>{{ reservationDailyElements.marketCode }}</td>
            <td>{{ reservationDailyElements.originOfBooking }}</td>
            <td>{{ reservationDailyElements.exchangeRate }}</td>
            <td>{{ reservationDailyElements.originalBaseRate }}</td>
            <td>{{ reservationDailyElements.baseRateAmount }}</td>
            <td>{{ reservationDailyElements.rateAmount }}</td>
            <td>{{ reservationDailyElements.roomCost }}</td>
            <td>{{ reservationDailyElements.quantity }}</td>
            <td>{{ reservationDailyElements.adults }}</td>
            <td>{{ reservationDailyElements.children }}</td>
            <td>{{ reservationDailyElements.physicalQuantity }}</td>
            <td>{{ reservationDailyElements.allotmentHeaderId }}</td>
            <td>{{ reservationDailyElements.dayUseYn }}</td>
            <td>{{ reservationDailyElements.dueOutYn }}</td>
            <td>{{ reservationDailyElements.insertUser }}</td>
            <td>{{ reservationDailyElements.insertDate }}</td>
            <td>{{ reservationDailyElements.updateUser }}</td>
            <td>{{ reservationDailyElements.updateDate }}</td>
            <td>{{ reservationDailyElements.insertActionInstanceId }}</td>
            <td>{{ reservationDailyElements.dmlSeqNo }}</td>
            <td>{{ reservationDailyElements.extSeqNo }}</td>
            <td>{{ reservationDailyElements.extSegNo }}</td>
            <td>{{ reservationDailyElements.cribs }}</td>
            <td>{{ reservationDailyElements.extraBeds }}</td>
            <td>{{ reservationDailyElements.allotmentRecordType }}</td>
            <td>{{ reservationDailyElements.blockResort }}</td>
            <td>{{ reservationDailyElements.blockId }}</td>
            <td>{{ reservationDailyElements.turndownStatus }}</td>
            <td>{{ reservationDailyElements.awdUpgrFrom }}</td>
            <td>{{ reservationDailyElements.awdUpgrTo }}</td>
            <td>{{ reservationDailyElements.hkExpectedServiceTime }}</td>
            <td>{{ reservationDailyElements.roomInstructions }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'ReservationDailyElementsView', params: { reservationDailyElementsId: reservationDailyElements.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.view')"></span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'ReservationDailyElementsEdit', params: { reservationDailyElementsId: reservationDailyElements.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="t$('entity.action.edit')"></span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(reservationDailyElements)"
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
          id="operaHandlerApplicationApp.reservationDailyElements.delete.question"
          data-cy="reservationDailyElementsDeleteDialogHeading"
          v-text="t$('entity.delete.title')"
        ></span>
      </template>
      <div class="modal-body">
        <p
          id="jhi-delete-reservationDailyElements-heading"
          v-text="t$('operaHandlerApplicationApp.reservationDailyElements.delete.question', { id: removeId })"
        ></p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" v-text="t$('entity.action.cancel')" v-on:click="closeDialog()"></button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-reservationDailyElements"
            data-cy="entityConfirmDeleteButton"
            v-text="t$('entity.action.delete')"
            v-on:click="removeReservationDailyElements()"
          ></button>
        </div>
      </template>
    </b-modal>
    <div v-show="reservationDailyElements && reservationDailyElements.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./reservation-daily-elements.component.ts"></script>
