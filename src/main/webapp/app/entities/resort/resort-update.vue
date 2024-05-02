<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.resort.home.createOrEditLabel"
          data-cy="ResortCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.resort.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="resort.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="resort.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.resort')" for="resort-resort"></label>
            <input
              type="text"
              class="form-control"
              name="resort"
              id="resort-resort"
              data-cy="resort"
              :class="{ valid: !v$.resort.$invalid, invalid: v$.resort.$invalid }"
              v-model="v$.resort.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.beginDate')" for="resort-beginDate"></label>
            <div class="d-flex">
              <input
                id="resort-beginDate"
                data-cy="beginDate"
                type="datetime-local"
                class="form-control"
                name="beginDate"
                :class="{ valid: !v$.beginDate.$invalid, invalid: v$.beginDate.$invalid }"
                :value="convertDateTimeFromServer(v$.beginDate.$model)"
                @change="updateZonedDateTimeField('beginDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.checkInTime')" for="resort-checkInTime"></label>
            <div class="d-flex">
              <input
                id="resort-checkInTime"
                data-cy="checkInTime"
                type="datetime-local"
                class="form-control"
                name="checkInTime"
                :class="{ valid: !v$.checkInTime.$invalid, invalid: v$.checkInTime.$invalid }"
                :value="convertDateTimeFromServer(v$.checkInTime.$model)"
                @change="updateZonedDateTimeField('checkInTime', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.checkOutTime')"
              for="resort-checkOutTime"
            ></label>
            <div class="d-flex">
              <input
                id="resort-checkOutTime"
                data-cy="checkOutTime"
                type="datetime-local"
                class="form-control"
                name="checkOutTime"
                :class="{ valid: !v$.checkOutTime.$invalid, invalid: v$.checkOutTime.$invalid }"
                :value="convertDateTimeFromServer(v$.checkOutTime.$model)"
                @change="updateZonedDateTimeField('checkOutTime', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.videoCoStart')"
              for="resort-videoCoStart"
            ></label>
            <div class="d-flex">
              <input
                id="resort-videoCoStart"
                data-cy="videoCoStart"
                type="datetime-local"
                class="form-control"
                name="videoCoStart"
                :class="{ valid: !v$.videoCoStart.$invalid, invalid: v$.videoCoStart.$invalid }"
                :value="convertDateTimeFromServer(v$.videoCoStart.$model)"
                @change="updateZonedDateTimeField('videoCoStart', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.videoCoStop')" for="resort-videoCoStop"></label>
            <div class="d-flex">
              <input
                id="resort-videoCoStop"
                data-cy="videoCoStop"
                type="datetime-local"
                class="form-control"
                name="videoCoStop"
                :class="{ valid: !v$.videoCoStop.$invalid, invalid: v$.videoCoStop.$invalid }"
                :value="convertDateTimeFromServer(v$.videoCoStop.$model)"
                @change="updateZonedDateTimeField('videoCoStop', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.insertDate')" for="resort-insertDate"></label>
            <div class="d-flex">
              <input
                id="resort-insertDate"
                data-cy="insertDate"
                type="datetime-local"
                class="form-control"
                name="insertDate"
                :class="{ valid: !v$.insertDate.$invalid, invalid: v$.insertDate.$invalid }"
                :value="convertDateTimeFromServer(v$.insertDate.$model)"
                @change="updateZonedDateTimeField('insertDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.updateDate')" for="resort-updateDate"></label>
            <div class="d-flex">
              <input
                id="resort-updateDate"
                data-cy="updateDate"
                type="datetime-local"
                class="form-control"
                name="updateDate"
                :class="{ valid: !v$.updateDate.$invalid, invalid: v$.updateDate.$invalid }"
                :value="convertDateTimeFromServer(v$.updateDate.$model)"
                @change="updateZonedDateTimeField('updateDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.expiryDate')" for="resort-expiryDate"></label>
            <div class="d-flex">
              <input
                id="resort-expiryDate"
                data-cy="expiryDate"
                type="datetime-local"
                class="form-control"
                name="expiryDate"
                :class="{ valid: !v$.expiryDate.$invalid, invalid: v$.expiryDate.$invalid }"
                :value="convertDateTimeFromServer(v$.expiryDate.$model)"
                @change="updateZonedDateTimeField('expiryDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.endDate')" for="resort-endDate"></label>
            <div class="d-flex">
              <input
                id="resort-endDate"
                data-cy="endDate"
                type="datetime-local"
                class="form-control"
                name="endDate"
                :class="{ valid: !v$.endDate.$invalid, invalid: v$.endDate.$invalid }"
                :value="convertDateTimeFromServer(v$.endDate.$model)"
                @change="updateZonedDateTimeField('endDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.fiscalStartDate')"
              for="resort-fiscalStartDate"
            ></label>
            <div class="d-flex">
              <input
                id="resort-fiscalStartDate"
                data-cy="fiscalStartDate"
                type="datetime-local"
                class="form-control"
                name="fiscalStartDate"
                :class="{ valid: !v$.fiscalStartDate.$invalid, invalid: v$.fiscalStartDate.$invalid }"
                :value="convertDateTimeFromServer(v$.fiscalStartDate.$model)"
                @change="updateZonedDateTimeField('fiscalStartDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.fiscalEndDate')"
              for="resort-fiscalEndDate"
            ></label>
            <div class="d-flex">
              <input
                id="resort-fiscalEndDate"
                data-cy="fiscalEndDate"
                type="datetime-local"
                class="form-control"
                name="fiscalEndDate"
                :class="{ valid: !v$.fiscalEndDate.$invalid, invalid: v$.fiscalEndDate.$invalid }"
                :value="convertDateTimeFromServer(v$.fiscalEndDate.$model)"
                @change="updateZonedDateTimeField('fiscalEndDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.reconcileDate')"
              for="resort-reconcileDate"
            ></label>
            <div class="d-flex">
              <input
                id="resort-reconcileDate"
                data-cy="reconcileDate"
                type="datetime-local"
                class="form-control"
                name="reconcileDate"
                :class="{ valid: !v$.reconcileDate.$invalid, invalid: v$.reconcileDate.$invalid }"
                :value="convertDateTimeFromServer(v$.reconcileDate.$model)"
                @change="updateZonedDateTimeField('reconcileDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.paymentDate')" for="resort-paymentDate"></label>
            <div class="d-flex">
              <input
                id="resort-paymentDate"
                data-cy="paymentDate"
                type="datetime-local"
                class="form-control"
                name="paymentDate"
                :class="{ valid: !v$.paymentDate.$invalid, invalid: v$.paymentDate.$invalid }"
                :value="convertDateTimeFromServer(v$.paymentDate.$model)"
                @change="updateZonedDateTimeField('paymentDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.keepAvailability')"
              for="resort-keepAvailability"
            ></label>
            <input
              type="number"
              class="form-control"
              name="keepAvailability"
              id="resort-keepAvailability"
              data-cy="keepAvailability"
              :class="{ valid: !v$.keepAvailability.$invalid, invalid: v$.keepAvailability.$invalid }"
              v-model.number="v$.keepAvailability.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.budgetMonth')" for="resort-budgetMonth"></label>
            <input
              type="number"
              class="form-control"
              name="budgetMonth"
              id="resort-budgetMonth"
              data-cy="budgetMonth"
              :class="{ valid: !v$.budgetMonth.$invalid, invalid: v$.budgetMonth.$invalid }"
              v-model.number="v$.budgetMonth.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.saveProfiles')"
              for="resort-saveProfiles"
            ></label>
            <input
              type="number"
              class="form-control"
              name="saveProfiles"
              id="resort-saveProfiles"
              data-cy="saveProfiles"
              :class="{ valid: !v$.saveProfiles.$invalid, invalid: v$.saveProfiles.$invalid }"
              v-model.number="v$.saveProfiles.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.longStayControl')"
              for="resort-longStayControl"
            ></label>
            <input
              type="number"
              class="form-control"
              name="longStayControl"
              id="resort-longStayControl"
              data-cy="longStayControl"
              :class="{ valid: !v$.longStayControl.$invalid, invalid: v$.longStayControl.$invalid }"
              v-model.number="v$.longStayControl.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.creditLimit')" for="resort-creditLimit"></label>
            <input
              type="number"
              class="form-control"
              name="creditLimit"
              id="resort-creditLimit"
              data-cy="creditLimit"
              :class="{ valid: !v$.creditLimit.$invalid, invalid: v$.creditLimit.$invalid }"
              v-model.number="v$.creditLimit.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.numberRooms')" for="resort-numberRooms"></label>
            <input
              type="number"
              class="form-control"
              name="numberRooms"
              id="resort-numberRooms"
              data-cy="numberRooms"
              :class="{ valid: !v$.numberRooms.$invalid, invalid: v$.numberRooms.$invalid }"
              v-model.number="v$.numberRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.numberFloors')"
              for="resort-numberFloors"
            ></label>
            <input
              type="number"
              class="form-control"
              name="numberFloors"
              id="resort-numberFloors"
              data-cy="numberFloors"
              :class="{ valid: !v$.numberFloors.$invalid, invalid: v$.numberFloors.$invalid }"
              v-model.number="v$.numberFloors.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.numberBeds')" for="resort-numberBeds"></label>
            <input
              type="number"
              class="form-control"
              name="numberBeds"
              id="resort-numberBeds"
              data-cy="numberBeds"
              :class="{ valid: !v$.numberBeds.$invalid, invalid: v$.numberBeds.$invalid }"
              v-model.number="v$.numberBeds.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.rhythmSheets')"
              for="resort-rhythmSheets"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rhythmSheets"
              id="resort-rhythmSheets"
              data-cy="rhythmSheets"
              :class="{ valid: !v$.rhythmSheets.$invalid, invalid: v$.rhythmSheets.$invalid }"
              v-model.number="v$.rhythmSheets.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.rhythmTowels')"
              for="resort-rhythmTowels"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rhythmTowels"
              id="resort-rhythmTowels"
              data-cy="rhythmTowels"
              :class="{ valid: !v$.rhythmTowels.$invalid, invalid: v$.rhythmTowels.$invalid }"
              v-model.number="v$.rhythmTowels.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.warningAmount')"
              for="resort-warningAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="warningAmount"
              id="resort-warningAmount"
              data-cy="warningAmount"
              :class="{ valid: !v$.warningAmount.$invalid, invalid: v$.warningAmount.$invalid }"
              v-model.number="v$.warningAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.decimalPlaces')"
              for="resort-decimalPlaces"
            ></label>
            <input
              type="number"
              class="form-control"
              name="decimalPlaces"
              id="resort-decimalPlaces"
              data-cy="decimalPlaces"
              :class="{ valid: !v$.decimalPlaces.$invalid, invalid: v$.decimalPlaces.$invalid }"
              v-model.number="v$.decimalPlaces.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.font')" for="resort-font"></label>
            <input
              type="number"
              class="form-control"
              name="font"
              id="resort-font"
              data-cy="font"
              :class="{ valid: !v$.font.$invalid, invalid: v$.font.$invalid }"
              v-model.number="v$.font.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.copies')" for="resort-copies"></label>
            <input
              type="number"
              class="form-control"
              name="copies"
              id="resort-copies"
              data-cy="copies"
              :class="{ valid: !v$.copies.$invalid, invalid: v$.copies.$invalid }"
              v-model.number="v$.copies.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultFolioStyle')"
              for="resort-defaultFolioStyle"
            ></label>
            <input
              type="number"
              class="form-control"
              name="defaultFolioStyle"
              id="resort-defaultFolioStyle"
              data-cy="defaultFolioStyle"
              :class="{ valid: !v$.defaultFolioStyle.$invalid, invalid: v$.defaultFolioStyle.$invalid }"
              v-model.number="v$.defaultFolioStyle.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.individualRoomWarning')"
              for="resort-individualRoomWarning"
            ></label>
            <input
              type="number"
              class="form-control"
              name="individualRoomWarning"
              id="resort-individualRoomWarning"
              data-cy="individualRoomWarning"
              :class="{ valid: !v$.individualRoomWarning.$invalid, invalid: v$.individualRoomWarning.$invalid }"
              v-model.number="v$.individualRoomWarning.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.groupRoomWarning')"
              for="resort-groupRoomWarning"
            ></label>
            <input
              type="number"
              class="form-control"
              name="groupRoomWarning"
              id="resort-groupRoomWarning"
              data-cy="groupRoomWarning"
              :class="{ valid: !v$.groupRoomWarning.$invalid, invalid: v$.groupRoomWarning.$invalid }"
              v-model.number="v$.groupRoomWarning.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.agingLevel1')" for="resort-agingLevel1"></label>
            <input
              type="number"
              class="form-control"
              name="agingLevel1"
              id="resort-agingLevel1"
              data-cy="agingLevel1"
              :class="{ valid: !v$.agingLevel1.$invalid, invalid: v$.agingLevel1.$invalid }"
              v-model.number="v$.agingLevel1.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.agingLevel2')" for="resort-agingLevel2"></label>
            <input
              type="number"
              class="form-control"
              name="agingLevel2"
              id="resort-agingLevel2"
              data-cy="agingLevel2"
              :class="{ valid: !v$.agingLevel2.$invalid, invalid: v$.agingLevel2.$invalid }"
              v-model.number="v$.agingLevel2.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.agingLevel3')" for="resort-agingLevel3"></label>
            <input
              type="number"
              class="form-control"
              name="agingLevel3"
              id="resort-agingLevel3"
              data-cy="agingLevel3"
              :class="{ valid: !v$.agingLevel3.$invalid, invalid: v$.agingLevel3.$invalid }"
              v-model.number="v$.agingLevel3.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.agingLevel4')" for="resort-agingLevel4"></label>
            <input
              type="number"
              class="form-control"
              name="agingLevel4"
              id="resort-agingLevel4"
              data-cy="agingLevel4"
              :class="{ valid: !v$.agingLevel4.$invalid, invalid: v$.agingLevel4.$invalid }"
              v-model.number="v$.agingLevel4.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.agingLevel5')" for="resort-agingLevel5"></label>
            <input
              type="number"
              class="form-control"
              name="agingLevel5"
              id="resort-agingLevel5"
              data-cy="agingLevel5"
              :class="{ valid: !v$.agingLevel5.$invalid, invalid: v$.agingLevel5.$invalid }"
              v-model.number="v$.agingLevel5.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.zeroInvPurDays')"
              for="resort-zeroInvPurDays"
            ></label>
            <input
              type="number"
              class="form-control"
              name="zeroInvPurDays"
              id="resort-zeroInvPurDays"
              data-cy="zeroInvPurDays"
              :class="{ valid: !v$.zeroInvPurDays.$invalid, invalid: v$.zeroInvPurDays.$invalid }"
              v-model.number="v$.zeroInvPurDays.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.minDaysBet2ReminderLetter')"
              for="resort-minDaysBet2ReminderLetter"
            ></label>
            <input
              type="number"
              class="form-control"
              name="minDaysBet2ReminderLetter"
              id="resort-minDaysBet2ReminderLetter"
              data-cy="minDaysBet2ReminderLetter"
              :class="{ valid: !v$.minDaysBet2ReminderLetter.$invalid, invalid: v$.minDaysBet2ReminderLetter.$invalid }"
              v-model.number="v$.minDaysBet2ReminderLetter.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.insertUser')" for="resort-insertUser"></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="resort-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.updateUser')" for="resort-updateUser"></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="resort-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.currencyDecimals')"
              for="resort-currencyDecimals"
            ></label>
            <input
              type="number"
              class="form-control"
              name="currencyDecimals"
              id="resort-currencyDecimals"
              data-cy="currencyDecimals"
              :class="{ valid: !v$.currencyDecimals.$invalid, invalid: v$.currencyDecimals.$invalid }"
              v-model.number="v$.currencyDecimals.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.nameIdLink')" for="resort-nameIdLink"></label>
            <input
              type="number"
              class="form-control"
              name="nameIdLink"
              id="resort-nameIdLink"
              data-cy="nameIdLink"
              :class="{ valid: !v$.nameIdLink.$invalid, invalid: v$.nameIdLink.$invalid }"
              v-model.number="v$.nameIdLink.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.sglRate1')" for="resort-sglRate1"></label>
            <input
              type="number"
              class="form-control"
              name="sglRate1"
              id="resort-sglRate1"
              data-cy="sglRate1"
              :class="{ valid: !v$.sglRate1.$invalid, invalid: v$.sglRate1.$invalid }"
              v-model.number="v$.sglRate1.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.sglRate2')" for="resort-sglRate2"></label>
            <input
              type="number"
              class="form-control"
              name="sglRate2"
              id="resort-sglRate2"
              data-cy="sglRate2"
              :class="{ valid: !v$.sglRate2.$invalid, invalid: v$.sglRate2.$invalid }"
              v-model.number="v$.sglRate2.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.dblRate1')" for="resort-dblRate1"></label>
            <input
              type="number"
              class="form-control"
              name="dblRate1"
              id="resort-dblRate1"
              data-cy="dblRate1"
              :class="{ valid: !v$.dblRate1.$invalid, invalid: v$.dblRate1.$invalid }"
              v-model.number="v$.dblRate1.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.dblRate2')" for="resort-dblRate2"></label>
            <input
              type="number"
              class="form-control"
              name="dblRate2"
              id="resort-dblRate2"
              data-cy="dblRate2"
              :class="{ valid: !v$.dblRate2.$invalid, invalid: v$.dblRate2.$invalid }"
              v-model.number="v$.dblRate2.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.tplRate1')" for="resort-tplRate1"></label>
            <input
              type="number"
              class="form-control"
              name="tplRate1"
              id="resort-tplRate1"
              data-cy="tplRate1"
              :class="{ valid: !v$.tplRate1.$invalid, invalid: v$.tplRate1.$invalid }"
              v-model.number="v$.tplRate1.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.tplRate2')" for="resort-tplRate2"></label>
            <input
              type="number"
              class="form-control"
              name="tplRate2"
              id="resort-tplRate2"
              data-cy="tplRate2"
              :class="{ valid: !v$.tplRate2.$invalid, invalid: v$.tplRate2.$invalid }"
              v-model.number="v$.tplRate2.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.suiRate1')" for="resort-suiRate1"></label>
            <input
              type="number"
              class="form-control"
              name="suiRate1"
              id="resort-suiRate1"
              data-cy="suiRate1"
              :class="{ valid: !v$.suiRate1.$invalid, invalid: v$.suiRate1.$invalid }"
              v-model.number="v$.suiRate1.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.suiRate2')" for="resort-suiRate2"></label>
            <input
              type="number"
              class="form-control"
              name="suiRate2"
              id="resort-suiRate2"
              data-cy="suiRate2"
              :class="{ valid: !v$.suiRate2.$invalid, invalid: v$.suiRate2.$invalid }"
              v-model.number="v$.suiRate2.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.meetSpace')" for="resort-meetSpace"></label>
            <input
              type="number"
              class="form-control"
              name="meetSpace"
              id="resort-meetSpace"
              data-cy="meetSpace"
              :class="{ valid: !v$.meetSpace.$invalid, invalid: v$.meetSpace.$invalid }"
              v-model.number="v$.meetSpace.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.imgHotelId')" for="resort-imgHotelId"></label>
            <input
              type="number"
              class="form-control"
              name="imgHotelId"
              id="resort-imgHotelId"
              data-cy="imgHotelId"
              :class="{ valid: !v$.imgHotelId.$invalid, invalid: v$.imgHotelId.$invalid }"
              v-model.number="v$.imgHotelId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.imgDirectionId')"
              for="resort-imgDirectionId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="imgDirectionId"
              id="resort-imgDirectionId"
              data-cy="imgDirectionId"
              :class="{ valid: !v$.imgDirectionId.$invalid, invalid: v$.imgDirectionId.$invalid }"
              v-model.number="v$.imgDirectionId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.imgMapId')" for="resort-imgMapId"></label>
            <input
              type="number"
              class="form-control"
              name="imgMapId"
              id="resort-imgMapId"
              data-cy="imgMapId"
              :class="{ valid: !v$.imgMapId.$invalid, invalid: v$.imgMapId.$invalid }"
              v-model.number="v$.imgMapId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.scriptId')" for="resort-scriptId"></label>
            <input
              type="number"
              class="form-control"
              name="scriptId"
              id="resort-scriptId"
              data-cy="scriptId"
              :class="{ valid: !v$.scriptId.$invalid, invalid: v$.scriptId.$invalid }"
              v-model.number="v$.scriptId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.comNameXrefId')"
              for="resort-comNameXrefId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="comNameXrefId"
              id="resort-comNameXrefId"
              data-cy="comNameXrefId"
              :class="{ valid: !v$.comNameXrefId.$invalid, invalid: v$.comNameXrefId.$invalid }"
              v-model.number="v$.comNameXrefId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.pathId')" for="resort-pathId"></label>
            <input
              type="number"
              class="form-control"
              name="pathId"
              id="resort-pathId"
              data-cy="pathId"
              :class="{ valid: !v$.pathId.$invalid, invalid: v$.pathId.$invalid }"
              v-model.number="v$.pathId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.xresortNumber')"
              for="resort-xresortNumber"
            ></label>
            <input
              type="number"
              class="form-control"
              name="xresortNumber"
              id="resort-xresortNumber"
              data-cy="xresortNumber"
              :class="{ valid: !v$.xresortNumber.$invalid, invalid: v$.xresortNumber.$invalid }"
              v-model.number="v$.xresortNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.maxCreditDays')"
              for="resort-maxCreditDays"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxCreditDays"
              id="resort-maxCreditDays"
              data-cy="maxCreditDays"
              :class="{ valid: !v$.maxCreditDays.$invalid, invalid: v$.maxCreditDays.$invalid }"
              v-model.number="v$.maxCreditDays.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.currencyDivisor')"
              for="resort-currencyDivisor"
            ></label>
            <input
              type="number"
              class="form-control"
              name="currencyDivisor"
              id="resort-currencyDivisor"
              data-cy="currencyDivisor"
              :class="{ valid: !v$.currencyDivisor.$invalid, invalid: v$.currencyDivisor.$invalid }"
              v-model.number="v$.currencyDivisor.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.latitude')" for="resort-latitude"></label>
            <input
              type="number"
              class="form-control"
              name="latitude"
              id="resort-latitude"
              data-cy="latitude"
              :class="{ valid: !v$.latitude.$invalid, invalid: v$.latitude.$invalid }"
              v-model.number="v$.latitude.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.longitude')" for="resort-longitude"></label>
            <input
              type="number"
              class="form-control"
              name="longitude"
              id="resort-longitude"
              data-cy="longitude"
              :class="{ valid: !v$.longitude.$invalid, invalid: v$.longitude.$invalid }"
              v-model.number="v$.longitude.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.qtySingleRooms')"
              for="resort-qtySingleRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="qtySingleRooms"
              id="resort-qtySingleRooms"
              data-cy="qtySingleRooms"
              :class="{ valid: !v$.qtySingleRooms.$invalid, invalid: v$.qtySingleRooms.$invalid }"
              v-model.number="v$.qtySingleRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.qtyDoubleRooms')"
              for="resort-qtyDoubleRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="qtyDoubleRooms"
              id="resort-qtyDoubleRooms"
              data-cy="qtyDoubleRooms"
              :class="{ valid: !v$.qtyDoubleRooms.$invalid, invalid: v$.qtyDoubleRooms.$invalid }"
              v-model.number="v$.qtyDoubleRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.qtyTwinRooms')"
              for="resort-qtyTwinRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="qtyTwinRooms"
              id="resort-qtyTwinRooms"
              data-cy="qtyTwinRooms"
              :class="{ valid: !v$.qtyTwinRooms.$invalid, invalid: v$.qtyTwinRooms.$invalid }"
              v-model.number="v$.qtyTwinRooms.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.qtySuites')" for="resort-qtySuites"></label>
            <input
              type="number"
              class="form-control"
              name="qtySuites"
              id="resort-qtySuites"
              data-cy="qtySuites"
              :class="{ valid: !v$.qtySuites.$invalid, invalid: v$.qtySuites.$invalid }"
              v-model.number="v$.qtySuites.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.qtyGuestRoomFloors')"
              for="resort-qtyGuestRoomFloors"
            ></label>
            <input
              type="number"
              class="form-control"
              name="qtyGuestRoomFloors"
              id="resort-qtyGuestRoomFloors"
              data-cy="qtyGuestRoomFloors"
              :class="{ valid: !v$.qtyGuestRoomFloors.$invalid, invalid: v$.qtyGuestRoomFloors.$invalid }"
              v-model.number="v$.qtyGuestRoomFloors.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.qtyGuestElevators')"
              for="resort-qtyGuestElevators"
            ></label>
            <input
              type="number"
              class="form-control"
              name="qtyGuestElevators"
              id="resort-qtyGuestElevators"
              data-cy="qtyGuestElevators"
              :class="{ valid: !v$.qtyGuestElevators.$invalid, invalid: v$.qtyGuestElevators.$invalid }"
              v-model.number="v$.qtyGuestElevators.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.qtyNonSmokingRooms')"
              for="resort-qtyNonSmokingRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="qtyNonSmokingRooms"
              id="resort-qtyNonSmokingRooms"
              data-cy="qtyNonSmokingRooms"
              :class="{ valid: !v$.qtyNonSmokingRooms.$invalid, invalid: v$.qtyNonSmokingRooms.$invalid }"
              v-model.number="v$.qtyNonSmokingRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.qtyConnectingRooms')"
              for="resort-qtyConnectingRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="qtyConnectingRooms"
              id="resort-qtyConnectingRooms"
              data-cy="qtyConnectingRooms"
              :class="{ valid: !v$.qtyConnectingRooms.$invalid, invalid: v$.qtyConnectingRooms.$invalid }"
              v-model.number="v$.qtyConnectingRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.qtyHandicappedRooms')"
              for="resort-qtyHandicappedRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="qtyHandicappedRooms"
              id="resort-qtyHandicappedRooms"
              data-cy="qtyHandicappedRooms"
              :class="{ valid: !v$.qtyHandicappedRooms.$invalid, invalid: v$.qtyHandicappedRooms.$invalid }"
              v-model.number="v$.qtyHandicappedRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.qtyFamilyRooms')"
              for="resort-qtyFamilyRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="qtyFamilyRooms"
              id="resort-qtyFamilyRooms"
              data-cy="qtyFamilyRooms"
              :class="{ valid: !v$.qtyFamilyRooms.$invalid, invalid: v$.qtyFamilyRooms.$invalid }"
              v-model.number="v$.qtyFamilyRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.maxAdultsFamilyRoom')"
              for="resort-maxAdultsFamilyRoom"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxAdultsFamilyRoom"
              id="resort-maxAdultsFamilyRoom"
              data-cy="maxAdultsFamilyRoom"
              :class="{ valid: !v$.maxAdultsFamilyRoom.$invalid, invalid: v$.maxAdultsFamilyRoom.$invalid }"
              v-model.number="v$.maxAdultsFamilyRoom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.maxChildrenFamilyRoom')"
              for="resort-maxChildrenFamilyRoom"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxChildrenFamilyRoom"
              id="resort-maxChildrenFamilyRoom"
              data-cy="maxChildrenFamilyRoom"
              :class="{ valid: !v$.maxChildrenFamilyRoom.$invalid, invalid: v$.maxChildrenFamilyRoom.$invalid }"
              v-model.number="v$.maxChildrenFamilyRoom.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.restaurant')" for="resort-restaurant"></label>
            <input
              type="number"
              class="form-control"
              name="restaurant"
              id="resort-restaurant"
              data-cy="restaurant"
              :class="{ valid: !v$.restaurant.$invalid, invalid: v$.restaurant.$invalid }"
              v-model.number="v$.restaurant.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.meetRooms')" for="resort-meetRooms"></label>
            <input
              type="number"
              class="form-control"
              name="meetRooms"
              id="resort-meetRooms"
              data-cy="meetRooms"
              :class="{ valid: !v$.meetRooms.$invalid, invalid: v$.meetRooms.$invalid }"
              v-model.number="v$.meetRooms.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.totRooms')" for="resort-totRooms"></label>
            <input
              type="number"
              class="form-control"
              name="totRooms"
              id="resort-totRooms"
              data-cy="totRooms"
              :class="{ valid: !v$.totRooms.$invalid, invalid: v$.totRooms.$invalid }"
              v-model.number="v$.totRooms.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.brSeats')" for="resort-brSeats"></label>
            <input
              type="number"
              class="form-control"
              name="brSeats"
              id="resort-brSeats"
              data-cy="brSeats"
              :class="{ valid: !v$.brSeats.$invalid, invalid: v$.brSeats.$invalid }"
              v-model.number="v$.brSeats.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.meetSeats')" for="resort-meetSeats"></label>
            <input
              type="number"
              class="form-control"
              name="meetSeats"
              id="resort-meetSeats"
              data-cy="meetSeats"
              :class="{ valid: !v$.meetSeats.$invalid, invalid: v$.meetSeats.$invalid }"
              v-model.number="v$.meetSeats.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.maxNoNights')" for="resort-maxNoNights"></label>
            <input
              type="number"
              class="form-control"
              name="maxNoNights"
              id="resort-maxNoNights"
              data-cy="maxNoNights"
              :class="{ valid: !v$.maxNoNights.$invalid, invalid: v$.maxNoNights.$invalid }"
              v-model.number="v$.maxNoNights.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.awardsTimeout')"
              for="resort-awardsTimeout"
            ></label>
            <input
              type="number"
              class="form-control"
              name="awardsTimeout"
              id="resort-awardsTimeout"
              data-cy="awardsTimeout"
              :class="{ valid: !v$.awardsTimeout.$invalid, invalid: v$.awardsTimeout.$invalid }"
              v-model.number="v$.awardsTimeout.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.guestLookupTimeout')"
              for="resort-guestLookupTimeout"
            ></label>
            <input
              type="number"
              class="form-control"
              name="guestLookupTimeout"
              id="resort-guestLookupTimeout"
              data-cy="guestLookupTimeout"
              :class="{ valid: !v$.guestLookupTimeout.$invalid, invalid: v$.guestLookupTimeout.$invalid }"
              v-model.number="v$.guestLookupTimeout.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.wakeUpDelay')" for="resort-wakeUpDelay"></label>
            <input
              type="number"
              class="form-control"
              name="wakeUpDelay"
              id="resort-wakeUpDelay"
              data-cy="wakeUpDelay"
              :class="{ valid: !v$.wakeUpDelay.$invalid, invalid: v$.wakeUpDelay.$invalid }"
              v-model.number="v$.wakeUpDelay.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.maxOccupancy')"
              for="resort-maxOccupancy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxOccupancy"
              id="resort-maxOccupancy"
              data-cy="maxOccupancy"
              :class="{ valid: !v$.maxOccupancy.$invalid, invalid: v$.maxOccupancy.$invalid }"
              v-model.number="v$.maxOccupancy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.inactiveDaysForGuestProfil')"
              for="resort-inactiveDaysForGuestProfil"
            ></label>
            <input
              type="number"
              class="form-control"
              name="inactiveDaysForGuestProfil"
              id="resort-inactiveDaysForGuestProfil"
              data-cy="inactiveDaysForGuestProfil"
              :class="{ valid: !v$.inactiveDaysForGuestProfil.$invalid, invalid: v$.inactiveDaysForGuestProfil.$invalid }"
              v-model.number="v$.inactiveDaysForGuestProfil.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.perReservationRoomLimit')"
              for="resort-perReservationRoomLimit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="perReservationRoomLimit"
              id="resort-perReservationRoomLimit"
              data-cy="perReservationRoomLimit"
              :class="{ valid: !v$.perReservationRoomLimit.$invalid, invalid: v$.perReservationRoomLimit.$invalid }"
              v-model.number="v$.perReservationRoomLimit.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.licRoomInfo')" for="resort-licRoomInfo"></label>
            <input
              type="text"
              class="form-control"
              name="licRoomInfo"
              id="resort-licRoomInfo"
              data-cy="licRoomInfo"
              :class="{ valid: !v$.licRoomInfo.$invalid, invalid: v$.licRoomInfo.$invalid }"
              v-model="v$.licRoomInfo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.thousandSeparator')"
              for="resort-thousandSeparator"
            ></label>
            <input
              type="text"
              class="form-control"
              name="thousandSeparator"
              id="resort-thousandSeparator"
              data-cy="thousandSeparator"
              :class="{ valid: !v$.thousandSeparator.$invalid, invalid: v$.thousandSeparator.$invalid }"
              v-model="v$.thousandSeparator.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.dateSeparator')"
              for="resort-dateSeparator"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dateSeparator"
              id="resort-dateSeparator"
              data-cy="dateSeparator"
              :class="{ valid: !v$.dateSeparator.$invalid, invalid: v$.dateSeparator.$invalid }"
              v-model="v$.dateSeparator.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.arAcctNoMandYn')"
              for="resort-arAcctNoMandYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arAcctNoMandYn"
              id="resort-arAcctNoMandYn"
              data-cy="arAcctNoMandYn"
              :class="{ valid: !v$.arAcctNoMandYn.$invalid, invalid: v$.arAcctNoMandYn.$invalid }"
              v-model="v$.arAcctNoMandYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.exchangePostingType')"
              for="resort-exchangePostingType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="exchangePostingType"
              id="resort-exchangePostingType"
              data-cy="exchangePostingType"
              :class="{ valid: !v$.exchangePostingType.$invalid, invalid: v$.exchangePostingType.$invalid }"
              v-model="v$.exchangePostingType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.inventoryYn')" for="resort-inventoryYn"></label>
            <input
              type="text"
              class="form-control"
              name="inventoryYn"
              id="resort-inventoryYn"
              data-cy="inventoryYn"
              :class="{ valid: !v$.inventoryYn.$invalid, invalid: v$.inventoryYn.$invalid }"
              v-model="v$.inventoryYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.allowLoginYn')"
              for="resort-allowLoginYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="allowLoginYn"
              id="resort-allowLoginYn"
              data-cy="allowLoginYn"
              :class="{ valid: !v$.allowLoginYn.$invalid, invalid: v$.allowLoginYn.$invalid }"
              v-model="v$.allowLoginYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.accessCode')" for="resort-accessCode"></label>
            <input
              type="text"
              class="form-control"
              name="accessCode"
              id="resort-accessCode"
              data-cy="accessCode"
              :class="{ valid: !v$.accessCode.$invalid, invalid: v$.accessCode.$invalid }"
              v-model="v$.accessCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.disableLoginYn')"
              for="resort-disableLoginYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="disableLoginYn"
              id="resort-disableLoginYn"
              data-cy="disableLoginYn"
              :class="{ valid: !v$.disableLoginYn.$invalid, invalid: v$.disableLoginYn.$invalid }"
              v-model="v$.disableLoginYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.intTaxIncludedYn')"
              for="resort-intTaxIncludedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="intTaxIncludedYn"
              id="resort-intTaxIncludedYn"
              data-cy="intTaxIncludedYn"
              :class="{ valid: !v$.intTaxIncludedYn.$invalid, invalid: v$.intTaxIncludedYn.$invalid }"
              v-model="v$.intTaxIncludedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.downloadRestYn')"
              for="resort-downloadRestYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="downloadRestYn"
              id="resort-downloadRestYn"
              data-cy="downloadRestYn"
              :class="{ valid: !v$.downloadRestYn.$invalid, invalid: v$.downloadRestYn.$invalid }"
              v-model="v$.downloadRestYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.translateMulticharYn')"
              for="resort-translateMulticharYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="translateMulticharYn"
              id="resort-translateMulticharYn"
              data-cy="translateMulticharYn"
              :class="{ valid: !v$.translateMulticharYn.$invalid, invalid: v$.translateMulticharYn.$invalid }"
              v-model="v$.translateMulticharYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.externalScYn')"
              for="resort-externalScYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="externalScYn"
              id="resort-externalScYn"
              data-cy="externalScYn"
              :class="{ valid: !v$.externalScYn.$invalid, invalid: v$.externalScYn.$invalid }"
              v-model="v$.externalScYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.sendLeadAsBookingYn')"
              for="resort-sendLeadAsBookingYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sendLeadAsBookingYn"
              id="resort-sendLeadAsBookingYn"
              data-cy="sendLeadAsBookingYn"
              :class="{ valid: !v$.sendLeadAsBookingYn.$invalid, invalid: v$.sendLeadAsBookingYn.$invalid }"
              v-model="v$.sendLeadAsBookingYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.mbsSupportedYn')"
              for="resort-mbsSupportedYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="mbsSupportedYn"
              id="resort-mbsSupportedYn"
              data-cy="mbsSupportedYn"
              :class="{ valid: !v$.mbsSupportedYn.$invalid, invalid: v$.mbsSupportedYn.$invalid }"
              v-model="v$.mbsSupportedYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.quotedCurrency')"
              for="resort-quotedCurrency"
            ></label>
            <input
              type="text"
              class="form-control"
              name="quotedCurrency"
              id="resort-quotedCurrency"
              data-cy="quotedCurrency"
              :class="{ valid: !v$.quotedCurrency.$invalid, invalid: v$.quotedCurrency.$invalid }"
              v-model="v$.quotedCurrency.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.comMethod')" for="resort-comMethod"></label>
            <input
              type="text"
              class="form-control"
              name="comMethod"
              id="resort-comMethod"
              data-cy="comMethod"
              :class="{ valid: !v$.comMethod.$invalid, invalid: v$.comMethod.$invalid }"
              v-model="v$.comMethod.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.email')" for="resort-email"></label>
            <input
              type="text"
              class="form-control"
              name="email"
              id="resort-email"
              data-cy="email"
              :class="{ valid: !v$.email.$invalid, invalid: v$.email.$invalid }"
              v-model="v$.email.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.genmgr')" for="resort-genmgr"></label>
            <input
              type="text"
              class="form-control"
              name="genmgr"
              id="resort-genmgr"
              data-cy="genmgr"
              :class="{ valid: !v$.genmgr.$invalid, invalid: v$.genmgr.$invalid }"
              v-model="v$.genmgr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.dirsales')" for="resort-dirsales"></label>
            <input
              type="text"
              class="form-control"
              name="dirsales"
              id="resort-dirsales"
              data-cy="dirsales"
              :class="{ valid: !v$.dirsales.$invalid, invalid: v$.dirsales.$invalid }"
              v-model="v$.dirsales.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.leadsend')" for="resort-leadsend"></label>
            <input
              type="text"
              class="form-control"
              name="leadsend"
              id="resort-leadsend"
              data-cy="leadsend"
              :class="{ valid: !v$.leadsend.$invalid, invalid: v$.leadsend.$invalid }"
              v-model="v$.leadsend.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.airport')" for="resort-airport"></label>
            <input
              type="text"
              class="form-control"
              name="airport"
              id="resort-airport"
              data-cy="airport"
              :class="{ valid: !v$.airport.$invalid, invalid: v$.airport.$invalid }"
              v-model="v$.airport.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.comAddress')" for="resort-comAddress"></label>
            <input
              type="text"
              class="form-control"
              name="comAddress"
              id="resort-comAddress"
              data-cy="comAddress"
              :class="{ valid: !v$.comAddress.$invalid, invalid: v$.comAddress.$invalid }"
              v-model="v$.comAddress.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.season1')" for="resort-season1"></label>
            <input
              type="text"
              class="form-control"
              name="season1"
              id="resort-season1"
              data-cy="season1"
              :class="{ valid: !v$.season1.$invalid, invalid: v$.season1.$invalid }"
              v-model="v$.season1.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.season2')" for="resort-season2"></label>
            <input
              type="text"
              class="form-control"
              name="season2"
              id="resort-season2"
              data-cy="season2"
              :class="{ valid: !v$.season2.$invalid, invalid: v$.season2.$invalid }"
              v-model="v$.season2.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.season3')" for="resort-season3"></label>
            <input
              type="text"
              class="form-control"
              name="season3"
              id="resort-season3"
              data-cy="season3"
              :class="{ valid: !v$.season3.$invalid, invalid: v$.season3.$invalid }"
              v-model="v$.season3.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.season4')" for="resort-season4"></label>
            <input
              type="text"
              class="form-control"
              name="season4"
              id="resort-season4"
              data-cy="season4"
              :class="{ valid: !v$.season4.$invalid, invalid: v$.season4.$invalid }"
              v-model="v$.season4.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.season5')" for="resort-season5"></label>
            <input
              type="text"
              class="form-control"
              name="season5"
              id="resort-season5"
              data-cy="season5"
              :class="{ valid: !v$.season5.$invalid, invalid: v$.season5.$invalid }"
              v-model="v$.season5.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.floorNumExecutiveFloor')"
              for="resort-floorNumExecutiveFloor"
            ></label>
            <input
              type="text"
              class="form-control"
              name="floorNumExecutiveFloor"
              id="resort-floorNumExecutiveFloor"
              data-cy="floorNumExecutiveFloor"
              :class="{ valid: !v$.floorNumExecutiveFloor.$invalid, invalid: v$.floorNumExecutiveFloor.$invalid }"
              v-model="v$.floorNumExecutiveFloor.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.crsResort')" for="resort-crsResort"></label>
            <input
              type="text"
              class="form-control"
              name="crsResort"
              id="resort-crsResort"
              data-cy="crsResort"
              :class="{ valid: !v$.crsResort.$invalid, invalid: v$.crsResort.$invalid }"
              v-model="v$.crsResort.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.postCode')" for="resort-postCode"></label>
            <input
              type="text"
              class="form-control"
              name="postCode"
              id="resort-postCode"
              data-cy="postCode"
              :class="{ valid: !v$.postCode.$invalid, invalid: v$.postCode.$invalid }"
              v-model="v$.postCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultReservationType')"
              for="resort-defaultReservationType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultReservationType"
              id="resort-defaultReservationType"
              data-cy="defaultReservationType"
              :class="{ valid: !v$.defaultReservationType.$invalid, invalid: v$.defaultReservationType.$invalid }"
              v-model="v$.defaultReservationType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.block')" for="resort-block"></label>
            <input
              type="text"
              class="form-control"
              name="block"
              id="resort-block"
              data-cy="block"
              :class="{ valid: !v$.block.$invalid, invalid: v$.block.$invalid }"
              v-model="v$.block.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.currencySymbol')"
              for="resort-currencySymbol"
            ></label>
            <input
              type="text"
              class="form-control"
              name="currencySymbol"
              id="resort-currencySymbol"
              data-cy="currencySymbol"
              :class="{ valid: !v$.currencySymbol.$invalid, invalid: v$.currencySymbol.$invalid }"
              v-model="v$.currencySymbol.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.sourceCommission')"
              for="resort-sourceCommission"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sourceCommission"
              id="resort-sourceCommission"
              data-cy="sourceCommission"
              :class="{ valid: !v$.sourceCommission.$invalid, invalid: v$.sourceCommission.$invalid }"
              v-model="v$.sourceCommission.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.taCommission')"
              for="resort-taCommission"
            ></label>
            <input
              type="text"
              class="form-control"
              name="taCommission"
              id="resort-taCommission"
              data-cy="taCommission"
              :class="{ valid: !v$.taCommission.$invalid, invalid: v$.taCommission.$invalid }"
              v-model="v$.taCommission.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.baseLanguage')"
              for="resort-baseLanguage"
            ></label>
            <input
              type="text"
              class="form-control"
              name="baseLanguage"
              id="resort-baseLanguage"
              data-cy="baseLanguage"
              :class="{ valid: !v$.baseLanguage.$invalid, invalid: v$.baseLanguage.$invalid }"
              v-model="v$.baseLanguage.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.folioLanguage1')"
              for="resort-folioLanguage1"
            ></label>
            <input
              type="text"
              class="form-control"
              name="folioLanguage1"
              id="resort-folioLanguage1"
              data-cy="folioLanguage1"
              :class="{ valid: !v$.folioLanguage1.$invalid, invalid: v$.folioLanguage1.$invalid }"
              v-model="v$.folioLanguage1.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.folioLanguage2')"
              for="resort-folioLanguage2"
            ></label>
            <input
              type="text"
              class="form-control"
              name="folioLanguage2"
              id="resort-folioLanguage2"
              data-cy="folioLanguage2"
              :class="{ valid: !v$.folioLanguage2.$invalid, invalid: v$.folioLanguage2.$invalid }"
              v-model="v$.folioLanguage2.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.folioLanguage3')"
              for="resort-folioLanguage3"
            ></label>
            <input
              type="text"
              class="form-control"
              name="folioLanguage3"
              id="resort-folioLanguage3"
              data-cy="folioLanguage3"
              :class="{ valid: !v$.folioLanguage3.$invalid, invalid: v$.folioLanguage3.$invalid }"
              v-model="v$.folioLanguage3.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.folioLanguage4')"
              for="resort-folioLanguage4"
            ></label>
            <input
              type="text"
              class="form-control"
              name="folioLanguage4"
              id="resort-folioLanguage4"
              data-cy="folioLanguage4"
              :class="{ valid: !v$.folioLanguage4.$invalid, invalid: v$.folioLanguage4.$invalid }"
              v-model="v$.folioLanguage4.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.packageProfit')"
              for="resort-packageProfit"
            ></label>
            <input
              type="text"
              class="form-control"
              name="packageProfit"
              id="resort-packageProfit"
              data-cy="packageProfit"
              :class="{ valid: !v$.packageProfit.$invalid, invalid: v$.packageProfit.$invalid }"
              v-model="v$.packageProfit.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.packageLoss')" for="resort-packageLoss"></label>
            <input
              type="text"
              class="form-control"
              name="packageLoss"
              id="resort-packageLoss"
              data-cy="packageLoss"
              :class="{ valid: !v$.packageLoss.$invalid, invalid: v$.packageLoss.$invalid }"
              v-model="v$.packageLoss.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.decimalSeparator')"
              for="resort-decimalSeparator"
            ></label>
            <input
              type="text"
              class="form-control"
              name="decimalSeparator"
              id="resort-decimalSeparator"
              data-cy="decimalSeparator"
              :class="{ valid: !v$.decimalSeparator.$invalid, invalid: v$.decimalSeparator.$invalid }"
              v-model="v$.decimalSeparator.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.shortDateFormat')"
              for="resort-shortDateFormat"
            ></label>
            <input
              type="text"
              class="form-control"
              name="shortDateFormat"
              id="resort-shortDateFormat"
              data-cy="shortDateFormat"
              :class="{ valid: !v$.shortDateFormat.$invalid, invalid: v$.shortDateFormat.$invalid }"
              v-model="v$.shortDateFormat.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.longDateFormat')"
              for="resort-longDateFormat"
            ></label>
            <input
              type="text"
              class="form-control"
              name="longDateFormat"
              id="resort-longDateFormat"
              data-cy="longDateFormat"
              :class="{ valid: !v$.longDateFormat.$invalid, invalid: v$.longDateFormat.$invalid }"
              v-model="v$.longDateFormat.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.passerbySource')"
              for="resort-passerbySource"
            ></label>
            <input
              type="text"
              class="form-control"
              name="passerbySource"
              id="resort-passerbySource"
              data-cy="passerbySource"
              :class="{ valid: !v$.passerbySource.$invalid, invalid: v$.passerbySource.$invalid }"
              v-model="v$.passerbySource.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.passerbyMarket')"
              for="resort-passerbyMarket"
            ></label>
            <input
              type="text"
              class="form-control"
              name="passerbyMarket"
              id="resort-passerbyMarket"
              data-cy="passerbyMarket"
              :class="{ valid: !v$.passerbyMarket.$invalid, invalid: v$.passerbyMarket.$invalid }"
              v-model="v$.passerbyMarket.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.arCompany')" for="resort-arCompany"></label>
            <input
              type="text"
              class="form-control"
              name="arCompany"
              id="resort-arCompany"
              data-cy="arCompany"
              :class="{ valid: !v$.arCompany.$invalid, invalid: v$.arCompany.$invalid }"
              v-model="v$.arCompany.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.arAgent')" for="resort-arAgent"></label>
            <input
              type="text"
              class="form-control"
              name="arAgent"
              id="resort-arAgent"
              data-cy="arAgent"
              :class="{ valid: !v$.arAgent.$invalid, invalid: v$.arAgent.$invalid }"
              v-model="v$.arAgent.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.arGroups')" for="resort-arGroups"></label>
            <input
              type="text"
              class="form-control"
              name="arGroups"
              id="resort-arGroups"
              data-cy="arGroups"
              :class="{ valid: !v$.arGroups.$invalid, invalid: v$.arGroups.$invalid }"
              v-model="v$.arGroups.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.arIndividuals')"
              for="resort-arIndividuals"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arIndividuals"
              id="resort-arIndividuals"
              data-cy="arIndividuals"
              :class="{ valid: !v$.arIndividuals.$invalid, invalid: v$.arIndividuals.$invalid }"
              v-model="v$.arIndividuals.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.arAcctNoFormat')"
              for="resort-arAcctNoFormat"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arAcctNoFormat"
              id="resort-arAcctNoFormat"
              data-cy="arAcctNoFormat"
              :class="{ valid: !v$.arAcctNoFormat.$invalid, invalid: v$.arAcctNoFormat.$invalid }"
              v-model="v$.arAcctNoFormat.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.allowancePeriodAdj')"
              for="resort-allowancePeriodAdj"
            ></label>
            <input
              type="text"
              class="form-control"
              name="allowancePeriodAdj"
              id="resort-allowancePeriodAdj"
              data-cy="allowancePeriodAdj"
              :class="{ valid: !v$.allowancePeriodAdj.$invalid, invalid: v$.allowancePeriodAdj.$invalid }"
              v-model="v$.allowancePeriodAdj.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.currencyCode')"
              for="resort-currencyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="currencyCode"
              id="resort-currencyCode"
              data-cy="currencyCode"
              :class="{ valid: !v$.currencyCode.$invalid, invalid: v$.currencyCode.$invalid }"
              v-model="v$.currencyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.turnawayCode')"
              for="resort-turnawayCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="turnawayCode"
              id="resort-turnawayCode"
              data-cy="turnawayCode"
              :class="{ valid: !v$.turnawayCode.$invalid, invalid: v$.turnawayCode.$invalid }"
              v-model="v$.turnawayCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.summCurrencyCode')"
              for="resort-summCurrencyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="summCurrencyCode"
              id="resort-summCurrencyCode"
              data-cy="summCurrencyCode"
              :class="{ valid: !v$.summCurrencyCode.$invalid, invalid: v$.summCurrencyCode.$invalid }"
              v-model="v$.summCurrencyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultPropertyAddress')"
              for="resort-defaultPropertyAddress"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultPropertyAddress"
              id="resort-defaultPropertyAddress"
              data-cy="defaultPropertyAddress"
              :class="{ valid: !v$.defaultPropertyAddress.$invalid, invalid: v$.defaultPropertyAddress.$invalid }"
              v-model="v$.defaultPropertyAddress.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultGuestAddress')"
              for="resort-defaultGuestAddress"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultGuestAddress"
              id="resort-defaultGuestAddress"
              data-cy="defaultGuestAddress"
              :class="{ valid: !v$.defaultGuestAddress.$invalid, invalid: v$.defaultGuestAddress.$invalid }"
              v-model="v$.defaultGuestAddress.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.licenseCode')" for="resort-licenseCode"></label>
            <input
              type="text"
              class="form-control"
              name="licenseCode"
              id="resort-licenseCode"
              data-cy="licenseCode"
              :class="{ valid: !v$.licenseCode.$invalid, invalid: v$.licenseCode.$invalid }"
              v-model="v$.licenseCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.timeFormat')" for="resort-timeFormat"></label>
            <input
              type="text"
              class="form-control"
              name="timeFormat"
              id="resort-timeFormat"
              data-cy="timeFormat"
              :class="{ valid: !v$.timeFormat.$invalid, invalid: v$.timeFormat.$invalid }"
              v-model="v$.timeFormat.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.chainCode')" for="resort-chainCode"></label>
            <input
              type="text"
              class="form-control"
              name="chainCode"
              id="resort-chainCode"
              data-cy="chainCode"
              :class="{ valid: !v$.chainCode.$invalid, invalid: v$.chainCode.$invalid }"
              v-model="v$.chainCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.resortType')" for="resort-resortType"></label>
            <input
              type="text"
              class="form-control"
              name="resortType"
              id="resort-resortType"
              data-cy="resortType"
              :class="{ valid: !v$.resortType.$invalid, invalid: v$.resortType.$invalid }"
              v-model="v$.resortType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.hotelType')" for="resort-hotelType"></label>
            <input
              type="text"
              class="form-control"
              name="hotelType"
              id="resort-hotelType"
              data-cy="hotelType"
              :class="{ valid: !v$.hotelType.$invalid, invalid: v$.hotelType.$invalid }"
              v-model="v$.hotelType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.ownership')" for="resort-ownership"></label>
            <input
              type="text"
              class="form-control"
              name="ownership"
              id="resort-ownership"
              data-cy="ownership"
              :class="{ valid: !v$.ownership.$invalid, invalid: v$.ownership.$invalid }"
              v-model="v$.ownership.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.arBalTrxCode')"
              for="resort-arBalTrxCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arBalTrxCode"
              id="resort-arBalTrxCode"
              data-cy="arBalTrxCode"
              :class="{ valid: !v$.arBalTrxCode.$invalid, invalid: v$.arBalTrxCode.$invalid }"
              v-model="v$.arBalTrxCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.arCreditTrxCode')"
              for="resort-arCreditTrxCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arCreditTrxCode"
              id="resort-arCreditTrxCode"
              data-cy="arCreditTrxCode"
              :class="{ valid: !v$.arCreditTrxCode.$invalid, invalid: v$.arCreditTrxCode.$invalid }"
              v-model="v$.arCreditTrxCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.arSettleCode')"
              for="resort-arSettleCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arSettleCode"
              id="resort-arSettleCode"
              data-cy="arSettleCode"
              :class="{ valid: !v$.arSettleCode.$invalid, invalid: v$.arSettleCode.$invalid }"
              v-model="v$.arSettleCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.cashShiftDrop')"
              for="resort-cashShiftDrop"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cashShiftDrop"
              id="resort-cashShiftDrop"
              data-cy="cashShiftDrop"
              :class="{ valid: !v$.cashShiftDrop.$invalid, invalid: v$.cashShiftDrop.$invalid }"
              v-model="v$.cashShiftDrop.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.checkExgPaidout')"
              for="resort-checkExgPaidout"
            ></label>
            <input
              type="text"
              class="form-control"
              name="checkExgPaidout"
              id="resort-checkExgPaidout"
              data-cy="checkExgPaidout"
              :class="{ valid: !v$.checkExgPaidout.$invalid, invalid: v$.checkExgPaidout.$invalid }"
              v-model="v$.checkExgPaidout.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.checkShiftDrop')"
              for="resort-checkShiftDrop"
            ></label>
            <input
              type="text"
              class="form-control"
              name="checkShiftDrop"
              id="resort-checkShiftDrop"
              data-cy="checkShiftDrop"
              :class="{ valid: !v$.checkShiftDrop.$invalid, invalid: v$.checkShiftDrop.$invalid }"
              v-model="v$.checkShiftDrop.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.checkTrxcode')"
              for="resort-checkTrxcode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="checkTrxcode"
              id="resort-checkTrxcode"
              data-cy="checkTrxcode"
              :class="{ valid: !v$.checkTrxcode.$invalid, invalid: v$.checkTrxcode.$invalid }"
              v-model="v$.checkTrxcode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.currencyExgPaidout')"
              for="resort-currencyExgPaidout"
            ></label>
            <input
              type="text"
              class="form-control"
              name="currencyExgPaidout"
              id="resort-currencyExgPaidout"
              data-cy="currencyExgPaidout"
              :class="{ valid: !v$.currencyExgPaidout.$invalid, invalid: v$.currencyExgPaidout.$invalid }"
              v-model="v$.currencyExgPaidout.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.depositLedTrxCode')"
              for="resort-depositLedTrxCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="depositLedTrxCode"
              id="resort-depositLedTrxCode"
              data-cy="depositLedTrxCode"
              :class="{ valid: !v$.depositLedTrxCode.$invalid, invalid: v$.depositLedTrxCode.$invalid }"
              v-model="v$.depositLedTrxCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.fiscalPeriodType')"
              for="resort-fiscalPeriodType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="fiscalPeriodType"
              id="resort-fiscalPeriodType"
              data-cy="fiscalPeriodType"
              :class="{ valid: !v$.fiscalPeriodType.$invalid, invalid: v$.fiscalPeriodType.$invalid }"
              v-model="v$.fiscalPeriodType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultCommissionPercentage')"
              for="resort-defaultCommissionPercentage"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultCommissionPercentage"
              id="resort-defaultCommissionPercentage"
              data-cy="defaultCommissionPercentage"
              :class="{ valid: !v$.defaultCommissionPercentage.$invalid, invalid: v$.defaultCommissionPercentage.$invalid }"
              v-model="v$.defaultCommissionPercentage.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultPrepaidComm')"
              for="resort-defaultPrepaidComm"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultPrepaidComm"
              id="resort-defaultPrepaidComm"
              data-cy="defaultPrepaidComm"
              :class="{ valid: !v$.defaultPrepaidComm.$invalid, invalid: v$.defaultPrepaidComm.$invalid }"
              v-model="v$.defaultPrepaidComm.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultTrxCommCode')"
              for="resort-defaultTrxCommCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultTrxCommCode"
              id="resort-defaultTrxCommCode"
              data-cy="defaultTrxCommCode"
              :class="{ valid: !v$.defaultTrxCommCode.$invalid, invalid: v$.defaultTrxCommCode.$invalid }"
              v-model="v$.defaultTrxCommCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.configurationMode')"
              for="resort-configurationMode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="configurationMode"
              id="resort-configurationMode"
              data-cy="configurationMode"
              :class="{ valid: !v$.configurationMode.$invalid, invalid: v$.configurationMode.$invalid }"
              v-model="v$.configurationMode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.weekendDays')" for="resort-weekendDays"></label>
            <input
              type="text"
              class="form-control"
              name="weekendDays"
              id="resort-weekendDays"
              data-cy="weekendDays"
              :class="{ valid: !v$.weekendDays.$invalid, invalid: v$.weekendDays.$invalid }"
              v-model="v$.weekendDays.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultGroupsRateCode')"
              for="resort-defaultGroupsRateCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultGroupsRateCode"
              id="resort-defaultGroupsRateCode"
              data-cy="defaultGroupsRateCode"
              :class="{ valid: !v$.defaultGroupsRateCode.$invalid, invalid: v$.defaultGroupsRateCode.$invalid }"
              v-model="v$.defaultGroupsRateCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultPostingRoom')"
              for="resort-defaultPostingRoom"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultPostingRoom"
              id="resort-defaultPostingRoom"
              data-cy="defaultPostingRoom"
              :class="{ valid: !v$.defaultPostingRoom.$invalid, invalid: v$.defaultPostingRoom.$invalid }"
              v-model="v$.defaultPostingRoom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.dfltPkgTranCode')"
              for="resort-dfltPkgTranCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dfltPkgTranCode"
              id="resort-dfltPkgTranCode"
              data-cy="dfltPkgTranCode"
              :class="{ valid: !v$.dfltPkgTranCode.$invalid, invalid: v$.dfltPkgTranCode.$invalid }"
              v-model="v$.dfltPkgTranCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.dfltTranCodeRateCode')"
              for="resort-dfltTranCodeRateCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dfltTranCodeRateCode"
              id="resort-dfltTranCodeRateCode"
              data-cy="dfltTranCodeRateCode"
              :class="{ valid: !v$.dfltTranCodeRateCode.$invalid, invalid: v$.dfltTranCodeRateCode.$invalid }"
              v-model="v$.dfltTranCodeRateCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultRateCode')"
              for="resort-defaultRateCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultRateCode"
              id="resort-defaultRateCode"
              data-cy="defaultRateCode"
              :class="{ valid: !v$.defaultRateCode.$invalid, invalid: v$.defaultRateCode.$invalid }"
              v-model="v$.defaultRateCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.croCode')" for="resort-croCode"></label>
            <input
              type="text"
              class="form-control"
              name="croCode"
              id="resort-croCode"
              data-cy="croCode"
              :class="{ valid: !v$.croCode.$invalid, invalid: v$.croCode.$invalid }"
              v-model="v$.croCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.flowCode')" for="resort-flowCode"></label>
            <input
              type="text"
              class="form-control"
              name="flowCode"
              id="resort-flowCode"
              data-cy="flowCode"
              :class="{ valid: !v$.flowCode.$invalid, invalid: v$.flowCode.$invalid }"
              v-model="v$.flowCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.extPropertyCode')"
              for="resort-extPropertyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="extPropertyCode"
              id="resort-extPropertyCode"
              data-cy="extPropertyCode"
              :class="{ valid: !v$.extPropertyCode.$invalid, invalid: v$.extPropertyCode.$invalid }"
              v-model="v$.extPropertyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.opusCurrencyCode')"
              for="resort-opusCurrencyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="opusCurrencyCode"
              id="resort-opusCurrencyCode"
              data-cy="opusCurrencyCode"
              :class="{ valid: !v$.opusCurrencyCode.$invalid, invalid: v$.opusCurrencyCode.$invalid }"
              v-model="v$.opusCurrencyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.destinationId')"
              for="resort-destinationId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="destinationId"
              id="resort-destinationId"
              data-cy="destinationId"
              :class="{ valid: !v$.destinationId.$invalid, invalid: v$.destinationId.$invalid }"
              v-model="v$.destinationId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.flags')" for="resort-flags"></label>
            <input
              type="text"
              class="form-control"
              name="flags"
              id="resort-flags"
              data-cy="flags"
              :class="{ valid: !v$.flags.$invalid, invalid: v$.flags.$invalid }"
              v-model="v$.flags.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.touristNumber')"
              for="resort-touristNumber"
            ></label>
            <input
              type="text"
              class="form-control"
              name="touristNumber"
              id="resort-touristNumber"
              data-cy="touristNumber"
              :class="{ valid: !v$.touristNumber.$invalid, invalid: v$.touristNumber.$invalid }"
              v-model="v$.touristNumber.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.cateringCurrencyCode')"
              for="resort-cateringCurrencyCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cateringCurrencyCode"
              id="resort-cateringCurrencyCode"
              data-cy="cateringCurrencyCode"
              :class="{ valid: !v$.cateringCurrencyCode.$invalid, invalid: v$.cateringCurrencyCode.$invalid }"
              v-model="v$.cateringCurrencyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultRatecodeRack')"
              for="resort-defaultRatecodeRack"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultRatecodeRack"
              id="resort-defaultRatecodeRack"
              data-cy="defaultRatecodeRack"
              :class="{ valid: !v$.defaultRatecodeRack.$invalid, invalid: v$.defaultRatecodeRack.$invalid }"
              v-model="v$.defaultRatecodeRack.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultRatecodePcr')"
              for="resort-defaultRatecodePcr"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultRatecodePcr"
              id="resort-defaultRatecodePcr"
              data-cy="defaultRatecodePcr"
              :class="{ valid: !v$.defaultRatecodePcr.$invalid, invalid: v$.defaultRatecodePcr.$invalid }"
              v-model="v$.defaultRatecodePcr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.fnsTier')" for="resort-fnsTier"></label>
            <input
              type="text"
              class="form-control"
              name="fnsTier"
              id="resort-fnsTier"
              data-cy="fnsTier"
              :class="{ valid: !v$.fnsTier.$invalid, invalid: v$.fnsTier.$invalid }"
              v-model="v$.fnsTier.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.brandCode')" for="resort-brandCode"></label>
            <input
              type="text"
              class="form-control"
              name="brandCode"
              id="resort-brandCode"
              data-cy="brandCode"
              :class="{ valid: !v$.brandCode.$invalid, invalid: v$.brandCode.$invalid }"
              v-model="v$.brandCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.webaddress')" for="resort-webaddress"></label>
            <input
              type="text"
              class="form-control"
              name="webaddress"
              id="resort-webaddress"
              data-cy="webaddress"
              :class="{ valid: !v$.webaddress.$invalid, invalid: v$.webaddress.$invalid }"
              v-model="v$.webaddress.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.vatId')" for="resort-vatId"></label>
            <input
              type="text"
              class="form-control"
              name="vatId"
              id="resort-vatId"
              data-cy="vatId"
              :class="{ valid: !v$.vatId.$invalid, invalid: v$.vatId.$invalid }"
              v-model="v$.vatId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.street')" for="resort-street"></label>
            <input
              type="text"
              class="form-control"
              name="street"
              id="resort-street"
              data-cy="street"
              :class="{ valid: !v$.street.$invalid, invalid: v$.street.$invalid }"
              v-model="v$.street.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.hotelFc')" for="resort-hotelFc"></label>
            <input
              type="text"
              class="form-control"
              name="hotelFc"
              id="resort-hotelFc"
              data-cy="hotelFc"
              :class="{ valid: !v$.hotelFc.$invalid, invalid: v$.hotelFc.$invalid }"
              v-model="v$.hotelFc.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.meetingFc')" for="resort-meetingFc"></label>
            <input
              type="text"
              class="form-control"
              name="meetingFc"
              id="resort-meetingFc"
              data-cy="meetingFc"
              :class="{ valid: !v$.meetingFc.$invalid, invalid: v$.meetingFc.$invalid }"
              v-model="v$.meetingFc.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.arTypewriter')"
              for="resort-arTypewriter"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arTypewriter"
              id="resort-arTypewriter"
              data-cy="arTypewriter"
              :class="{ valid: !v$.arTypewriter.$invalid, invalid: v$.arTypewriter.$invalid }"
              v-model="v$.arTypewriter.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.fileTransferFormat')"
              for="resort-fileTransferFormat"
            ></label>
            <input
              type="text"
              class="form-control"
              name="fileTransferFormat"
              id="resort-fileTransferFormat"
              data-cy="fileTransferFormat"
              :class="{ valid: !v$.fileTransferFormat.$invalid, invalid: v$.fileTransferFormat.$invalid }"
              v-model="v$.fileTransferFormat.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.confirmRegcardPrinter')"
              for="resort-confirmRegcardPrinter"
            ></label>
            <input
              type="text"
              class="form-control"
              name="confirmRegcardPrinter"
              id="resort-confirmRegcardPrinter"
              data-cy="confirmRegcardPrinter"
              :class="{ valid: !v$.confirmRegcardPrinter.$invalid, invalid: v$.confirmRegcardPrinter.$invalid }"
              v-model="v$.confirmRegcardPrinter.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.directions')" for="resort-directions"></label>
            <input
              type="text"
              class="form-control"
              name="directions"
              id="resort-directions"
              data-cy="directions"
              :class="{ valid: !v$.directions.$invalid, invalid: v$.directions.$invalid }"
              v-model="v$.directions.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.propinfoUrl')" for="resort-propinfoUrl"></label>
            <input
              type="text"
              class="form-control"
              name="propinfoUrl"
              id="resort-propinfoUrl"
              data-cy="propinfoUrl"
              :class="{ valid: !v$.propinfoUrl.$invalid, invalid: v$.propinfoUrl.$invalid }"
              v-model="v$.propinfoUrl.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.roomAmenity')" for="resort-roomAmenity"></label>
            <input
              type="text"
              class="form-control"
              name="roomAmenity"
              id="resort-roomAmenity"
              data-cy="roomAmenity"
              :class="{ valid: !v$.roomAmenity.$invalid, invalid: v$.roomAmenity.$invalid }"
              v-model="v$.roomAmenity.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.shopDescription')"
              for="resort-shopDescription"
            ></label>
            <input
              type="text"
              class="form-control"
              name="shopDescription"
              id="resort-shopDescription"
              data-cy="shopDescription"
              :class="{ valid: !v$.shopDescription.$invalid, invalid: v$.shopDescription.$invalid }"
              v-model="v$.shopDescription.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.propPicUrl')" for="resort-propPicUrl"></label>
            <input
              type="text"
              class="form-control"
              name="propPicUrl"
              id="resort-propPicUrl"
              data-cy="propPicUrl"
              :class="{ valid: !v$.propPicUrl.$invalid, invalid: v$.propPicUrl.$invalid }"
              v-model="v$.propPicUrl.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.propMapUrl')" for="resort-propMapUrl"></label>
            <input
              type="text"
              class="form-control"
              name="propMapUrl"
              id="resort-propMapUrl"
              data-cy="propMapUrl"
              :class="{ valid: !v$.propMapUrl.$invalid, invalid: v$.propMapUrl.$invalid }"
              v-model="v$.propMapUrl.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.extExpFileLocation')"
              for="resort-extExpFileLocation"
            ></label>
            <input
              type="text"
              class="form-control"
              name="extExpFileLocation"
              id="resort-extExpFileLocation"
              data-cy="extExpFileLocation"
              :class="{ valid: !v$.extExpFileLocation.$invalid, invalid: v$.extExpFileLocation.$invalid }"
              v-model="v$.extExpFileLocation.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.curtainColor')"
              for="resort-curtainColor"
            ></label>
            <input
              type="text"
              class="form-control"
              name="curtainColor"
              id="resort-curtainColor"
              data-cy="curtainColor"
              :class="{ valid: !v$.curtainColor.$invalid, invalid: v$.curtainColor.$invalid }"
              v-model="v$.curtainColor.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.countryCode')" for="resort-countryCode"></label>
            <input
              type="text"
              class="form-control"
              name="countryCode"
              id="resort-countryCode"
              data-cy="countryCode"
              :class="{ valid: !v$.countryCode.$invalid, invalid: v$.countryCode.$invalid }"
              v-model="v$.countryCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.state')" for="resort-state"></label>
            <input
              type="text"
              class="form-control"
              name="state"
              id="resort-state"
              data-cy="state"
              :class="{ valid: !v$.state.$invalid, invalid: v$.state.$invalid }"
              v-model="v$.state.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.dateForAging')"
              for="resort-dateForAging"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dateForAging"
              id="resort-dateForAging"
              data-cy="dateForAging"
              :class="{ valid: !v$.dateForAging.$invalid, invalid: v$.dateForAging.$invalid }"
              v-model="v$.dateForAging.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.regionCode')" for="resort-regionCode"></label>
            <input
              type="text"
              class="form-control"
              name="regionCode"
              id="resort-regionCode"
              data-cy="regionCode"
              :class="{ valid: !v$.regionCode.$invalid, invalid: v$.regionCode.$invalid }"
              v-model="v$.regionCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.city')" for="resort-city"></label>
            <input
              type="text"
              class="form-control"
              name="city"
              id="resort-city"
              data-cy="city"
              :class="{ valid: !v$.city.$invalid, invalid: v$.city.$invalid }"
              v-model="v$.city.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.telephone')" for="resort-telephone"></label>
            <input
              type="text"
              class="form-control"
              name="telephone"
              id="resort-telephone"
              data-cy="telephone"
              :class="{ valid: !v$.telephone.$invalid, invalid: v$.telephone.$invalid }"
              v-model="v$.telephone.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.fax')" for="resort-fax"></label>
            <input
              type="text"
              class="form-control"
              name="fax"
              id="resort-fax"
              data-cy="fax"
              :class="{ valid: !v$.fax.$invalid, invalid: v$.fax.$invalid }"
              v-model="v$.fax.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.tollfree')" for="resort-tollfree"></label>
            <input
              type="text"
              class="form-control"
              name="tollfree"
              id="resort-tollfree"
              data-cy="tollfree"
              :class="{ valid: !v$.tollfree.$invalid, invalid: v$.tollfree.$invalid }"
              v-model="v$.tollfree.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultPrinter')"
              for="resort-defaultPrinter"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultPrinter"
              id="resort-defaultPrinter"
              data-cy="defaultPrinter"
              :class="{ valid: !v$.defaultPrinter.$invalid, invalid: v$.defaultPrinter.$invalid }"
              v-model="v$.defaultPrinter.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.videocheckoutPrinter')"
              for="resort-videocheckoutPrinter"
            ></label>
            <input
              type="text"
              class="form-control"
              name="videocheckoutPrinter"
              id="resort-videocheckoutPrinter"
              data-cy="videocheckoutPrinter"
              :class="{ valid: !v$.videocheckoutPrinter.$invalid, invalid: v$.videocheckoutPrinter.$invalid }"
              v-model="v$.videocheckoutPrinter.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.companyAddressType')"
              for="resort-companyAddressType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="companyAddressType"
              id="resort-companyAddressType"
              data-cy="companyAddressType"
              :class="{ valid: !v$.companyAddressType.$invalid, invalid: v$.companyAddressType.$invalid }"
              v-model="v$.companyAddressType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.companyPhoneType')"
              for="resort-companyPhoneType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="companyPhoneType"
              id="resort-companyPhoneType"
              data-cy="companyPhoneType"
              :class="{ valid: !v$.companyPhoneType.$invalid, invalid: v$.companyPhoneType.$invalid }"
              v-model="v$.companyPhoneType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultFaxType')"
              for="resort-defaultFaxType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultFaxType"
              id="resort-defaultFaxType"
              data-cy="defaultFaxType"
              :class="{ valid: !v$.defaultFaxType.$invalid, invalid: v$.defaultFaxType.$invalid }"
              v-model="v$.defaultFaxType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultMembershipType')"
              for="resort-defaultMembershipType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultMembershipType"
              id="resort-defaultMembershipType"
              data-cy="defaultMembershipType"
              :class="{ valid: !v$.defaultMembershipType.$invalid, invalid: v$.defaultMembershipType.$invalid }"
              v-model="v$.defaultMembershipType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.individualAddressType')"
              for="resort-individualAddressType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="individualAddressType"
              id="resort-individualAddressType"
              data-cy="individualAddressType"
              :class="{ valid: !v$.individualAddressType.$invalid, invalid: v$.individualAddressType.$invalid }"
              v-model="v$.individualAddressType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.individualPhoneType')"
              for="resort-individualPhoneType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="individualPhoneType"
              id="resort-individualPhoneType"
              data-cy="individualPhoneType"
              :class="{ valid: !v$.individualPhoneType.$invalid, invalid: v$.individualPhoneType.$invalid }"
              v-model="v$.individualPhoneType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.notes')" for="resort-notes"></label>
            <input
              type="text"
              class="form-control"
              name="notes"
              id="resort-notes"
              data-cy="notes"
              :class="{ valid: !v$.notes.$invalid, invalid: v$.notes.$invalid }"
              v-model="v$.notes.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.blackoutPeriodNotes')"
              for="resort-blackoutPeriodNotes"
            ></label>
            <input
              type="text"
              class="form-control"
              name="blackoutPeriodNotes"
              id="resort-blackoutPeriodNotes"
              data-cy="blackoutPeriodNotes"
              :class="{ valid: !v$.blackoutPeriodNotes.$invalid, invalid: v$.blackoutPeriodNotes.$invalid }"
              v-model="v$.blackoutPeriodNotes.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.sglNum')" for="resort-sglNum"></label>
            <input
              type="text"
              class="form-control"
              name="sglNum"
              id="resort-sglNum"
              data-cy="sglNum"
              :class="{ valid: !v$.sglNum.$invalid, invalid: v$.sglNum.$invalid }"
              v-model="v$.sglNum.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.dblNum')" for="resort-dblNum"></label>
            <input
              type="text"
              class="form-control"
              name="dblNum"
              id="resort-dblNum"
              data-cy="dblNum"
              :class="{ valid: !v$.dblNum.$invalid, invalid: v$.dblNum.$invalid }"
              v-model="v$.dblNum.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.tplNum')" for="resort-tplNum"></label>
            <input
              type="text"
              class="form-control"
              name="tplNum"
              id="resort-tplNum"
              data-cy="tplNum"
              :class="{ valid: !v$.tplNum.$invalid, invalid: v$.tplNum.$invalid }"
              v-model="v$.tplNum.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.suiNum')" for="resort-suiNum"></label>
            <input
              type="text"
              class="form-control"
              name="suiNum"
              id="resort-suiNum"
              data-cy="suiNum"
              :class="{ valid: !v$.suiNum.$invalid, invalid: v$.suiNum.$invalid }"
              v-model="v$.suiNum.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.airportDistance')"
              for="resort-airportDistance"
            ></label>
            <input
              type="text"
              class="form-control"
              name="airportDistance"
              id="resort-airportDistance"
              data-cy="airportDistance"
              :class="{ valid: !v$.airportDistance.$invalid, invalid: v$.airportDistance.$invalid }"
              v-model="v$.airportDistance.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.airportTime')" for="resort-airportTime"></label>
            <input
              type="text"
              class="form-control"
              name="airportTime"
              id="resort-airportTime"
              data-cy="airportTime"
              :class="{ valid: !v$.airportTime.$invalid, invalid: v$.airportTime.$invalid }"
              v-model="v$.airportTime.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.brArea')" for="resort-brArea"></label>
            <input
              type="text"
              class="form-control"
              name="brArea"
              id="resort-brArea"
              data-cy="brArea"
              :class="{ valid: !v$.brArea.$invalid, invalid: v$.brArea.$invalid }"
              v-model="v$.brArea.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.name')" for="resort-name"></label>
            <input
              type="text"
              class="form-control"
              name="name"
              id="resort-name"
              data-cy="name"
              :class="{ valid: !v$.name.$invalid, invalid: v$.name.$invalid }"
              v-model="v$.name.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.legalOwner')" for="resort-legalOwner"></label>
            <input
              type="text"
              class="form-control"
              name="legalOwner"
              id="resort-legalOwner"
              data-cy="legalOwner"
              :class="{ valid: !v$.legalOwner.$invalid, invalid: v$.legalOwner.$invalid }"
              v-model="v$.legalOwner.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.hotelId')" for="resort-hotelId"></label>
            <input
              type="text"
              class="form-control"
              name="hotelId"
              id="resort-hotelId"
              data-cy="hotelId"
              :class="{ valid: !v$.hotelId.$invalid, invalid: v$.hotelId.$invalid }"
              v-model="v$.hotelId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.faxNoFormat')" for="resort-faxNoFormat"></label>
            <input
              type="text"
              class="form-control"
              name="faxNoFormat"
              id="resort-faxNoFormat"
              data-cy="faxNoFormat"
              :class="{ valid: !v$.faxNoFormat.$invalid, invalid: v$.faxNoFormat.$invalid }"
              v-model="v$.faxNoFormat.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.telephoneNoFormat')"
              for="resort-telephoneNoFormat"
            ></label>
            <input
              type="text"
              class="form-control"
              name="telephoneNoFormat"
              id="resort-telephoneNoFormat"
              data-cy="telephoneNoFormat"
              :class="{ valid: !v$.telephoneNoFormat.$invalid, invalid: v$.telephoneNoFormat.$invalid }"
              v-model="v$.telephoneNoFormat.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.localCurrencyFormat')"
              for="resort-localCurrencyFormat"
            ></label>
            <input
              type="text"
              class="form-control"
              name="localCurrencyFormat"
              id="resort-localCurrencyFormat"
              data-cy="localCurrencyFormat"
              :class="{ valid: !v$.localCurrencyFormat.$invalid, invalid: v$.localCurrencyFormat.$invalid }"
              v-model="v$.localCurrencyFormat.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.dutyManagerPager')"
              for="resort-dutyManagerPager"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dutyManagerPager"
              id="resort-dutyManagerPager"
              data-cy="dutyManagerPager"
              :class="{ valid: !v$.dutyManagerPager.$invalid, invalid: v$.dutyManagerPager.$invalid }"
              v-model="v$.dutyManagerPager.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.defaultRegistrationCard')"
              for="resort-defaultRegistrationCard"
            ></label>
            <input
              type="text"
              class="form-control"
              name="defaultRegistrationCard"
              id="resort-defaultRegistrationCard"
              data-cy="defaultRegistrationCard"
              :class="{ valid: !v$.defaultRegistrationCard.$invalid, invalid: v$.defaultRegistrationCard.$invalid }"
              v-model="v$.defaultRegistrationCard.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.nightAuditCashierId')"
              for="resort-nightAuditCashierId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="nightAuditCashierId"
              id="resort-nightAuditCashierId"
              data-cy="nightAuditCashierId"
              :class="{ valid: !v$.nightAuditCashierId.$invalid, invalid: v$.nightAuditCashierId.$invalid }"
              v-model="v$.nightAuditCashierId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.hotelCode')" for="resort-hotelCode"></label>
            <input
              type="text"
              class="form-control"
              name="hotelCode"
              id="resort-hotelCode"
              data-cy="hotelCode"
              :class="{ valid: !v$.hotelCode.$invalid, invalid: v$.hotelCode.$invalid }"
              v-model="v$.hotelCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.resort.path')" for="resort-path"></label>
            <input
              type="text"
              class="form-control"
              name="path"
              id="resort-path"
              data-cy="path"
              :class="{ valid: !v$.path.$invalid, invalid: v$.path.$invalid }"
              v-model="v$.path.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.timezoneRegion')"
              for="resort-timezoneRegion"
            ></label>
            <input
              type="text"
              class="form-control"
              name="timezoneRegion"
              id="resort-timezoneRegion"
              data-cy="timezoneRegion"
              :class="{ valid: !v$.timezoneRegion.$invalid, invalid: v$.timezoneRegion.$invalid }"
              v-model="v$.timezoneRegion.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.cateringCurrencyFormat')"
              for="resort-cateringCurrencyFormat"
            ></label>
            <input
              type="text"
              class="form-control"
              name="cateringCurrencyFormat"
              id="resort-cateringCurrencyFormat"
              data-cy="cateringCurrencyFormat"
              :class="{ valid: !v$.cateringCurrencyFormat.$invalid, invalid: v$.cateringCurrencyFormat.$invalid }"
              v-model="v$.cateringCurrencyFormat.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resort.expHotelCode')"
              for="resort-expHotelCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="expHotelCode"
              id="resort-expHotelCode"
              data-cy="expHotelCode"
              :class="{ valid: !v$.expHotelCode.$invalid, invalid: v$.expHotelCode.$invalid }"
              v-model="v$.expHotelCode.$model"
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
<script lang="ts" src="./resort-update.component.ts"></script>
