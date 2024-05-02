<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.resortRoomCategory.home.createOrEditLabel"
          data-cy="ResortRoomCategoryCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.resortRoomCategory.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="resortRoomCategory.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="resortRoomCategory.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.resort')"
              for="resort-room-category-resort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resort"
              id="resort-room-category-resort"
              data-cy="resort"
              :class="{ valid: !v$.resort.$invalid, invalid: v$.resort.$invalid }"
              v-model="v$.resort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roomCategory')"
              for="resort-room-category-roomCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomCategory"
              id="resort-room-category-roomCategory"
              data-cy="roomCategory"
              :class="{ valid: !v$.roomCategory.$invalid, invalid: v$.roomCategory.$invalid }"
              v-model="v$.roomCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roomClass')"
              for="resort-room-category-roomClass"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomClass"
              id="resort-room-category-roomClass"
              data-cy="roomClass"
              :class="{ valid: !v$.roomClass.$invalid, invalid: v$.roomClass.$invalid }"
              v-model="v$.roomClass.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.numberRooms')"
              for="resort-room-category-numberRooms"
            ></label>
            <input
              type="number"
              class="form-control"
              name="numberRooms"
              id="resort-room-category-numberRooms"
              data-cy="numberRooms"
              :class="{ valid: !v$.numberRooms.$invalid, invalid: v$.numberRooms.$invalid }"
              v-model.number="v$.numberRooms.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.shortDescription')"
              for="resort-room-category-shortDescription"
            ></label>
            <input
              type="text"
              class="form-control"
              name="shortDescription"
              id="resort-room-category-shortDescription"
              data-cy="shortDescription"
              :class="{ valid: !v$.shortDescription.$invalid, invalid: v$.shortDescription.$invalid }"
              v-model="v$.shortDescription.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.longDescription')"
              for="resort-room-category-longDescription"
            ></label>
            <input
              type="text"
              class="form-control"
              name="longDescription"
              id="resort-room-category-longDescription"
              data-cy="longDescription"
              :class="{ valid: !v$.longDescription.$invalid, invalid: v$.longDescription.$invalid }"
              v-model="v$.longDescription.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.compiled')"
              for="resort-room-category-compiled"
            ></label>
            <input
              type="text"
              class="form-control"
              name="compiled"
              id="resort-room-category-compiled"
              data-cy="compiled"
              :class="{ valid: !v$.compiled.$invalid, invalid: v$.compiled.$invalid }"
              v-model="v$.compiled.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.psuedoRoomType')"
              for="resort-room-category-psuedoRoomType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="psuedoRoomType"
              id="resort-room-category-psuedoRoomType"
              data-cy="psuedoRoomType"
              :class="{ valid: !v$.psuedoRoomType.$invalid, invalid: v$.psuedoRoomType.$invalid }"
              v-model="v$.psuedoRoomType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.activeDate')"
              for="resort-room-category-activeDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="resort-room-category-activeDate"
                  v-model="v$.activeDate.$model"
                  name="activeDate"
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
                id="resort-room-category-activeDate"
                data-cy="activeDate"
                type="text"
                class="form-control"
                name="activeDate"
                :class="{ valid: !v$.activeDate.$invalid, invalid: v$.activeDate.$invalid }"
                v-model="v$.activeDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.inactiveDate')"
              for="resort-room-category-inactiveDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="resort-room-category-inactiveDate"
                  v-model="v$.inactiveDate.$model"
                  name="inactiveDate"
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
                id="resort-room-category-inactiveDate"
                data-cy="inactiveDate"
                type="text"
                class="form-control"
                name="inactiveDate"
                :class="{ valid: !v$.inactiveDate.$invalid, invalid: v$.inactiveDate.$invalid }"
                v-model="v$.inactiveDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.replacesCategory')"
              for="resort-room-category-replacesCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="replacesCategory"
              id="resort-room-category-replacesCategory"
              data-cy="replacesCategory"
              :class="{ valid: !v$.replacesCategory.$invalid, invalid: v$.replacesCategory.$invalid }"
              v-model="v$.replacesCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.orderBy')"
              for="resort-room-category-orderBy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="orderBy"
              id="resort-room-category-orderBy"
              data-cy="orderBy"
              :class="{ valid: !v$.orderBy.$invalid, invalid: v$.orderBy.$invalid }"
              v-model.number="v$.orderBy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxOccupancy')"
              for="resort-room-category-maxOccupancy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxOccupancy"
              id="resort-room-category-maxOccupancy"
              data-cy="maxOccupancy"
              :class="{ valid: !v$.maxOccupancy.$invalid, invalid: v$.maxOccupancy.$invalid }"
              v-model.number="v$.maxOccupancy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxRollaways')"
              for="resort-room-category-maxRollaways"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxRollaways"
              id="resort-room-category-maxRollaways"
              data-cy="maxRollaways"
              :class="{ valid: !v$.maxRollaways.$invalid, invalid: v$.maxRollaways.$invalid }"
              v-model.number="v$.maxRollaways.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateCategory')"
              for="resort-room-category-rateCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rateCategory"
              id="resort-room-category-rateCategory"
              data-cy="rateCategory"
              :class="{ valid: !v$.rateCategory.$invalid, invalid: v$.rateCategory.$invalid }"
              v-model="v$.rateCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.label')"
              for="resort-room-category-label"
            ></label>
            <input
              type="text"
              class="form-control"
              name="label"
              id="resort-room-category-label"
              data-cy="label"
              :class="{ valid: !v$.label.$invalid, invalid: v$.label.$invalid }"
              v-model="v$.label.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.genericFlag')"
              for="resort-room-category-genericFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="genericFlag"
              id="resort-room-category-genericFlag"
              data-cy="genericFlag"
              :class="{ valid: !v$.genericFlag.$invalid, invalid: v$.genericFlag.$invalid }"
              v-model="v$.genericFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.suiteYn')"
              for="resort-room-category-suiteYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="suiteYn"
              id="resort-room-category-suiteYn"
              data-cy="suiteYn"
              :class="{ valid: !v$.suiteYn.$invalid, invalid: v$.suiteYn.$invalid }"
              v-model="v$.suiteYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.meetingroomYn')"
              for="resort-room-category-meetingroomYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="meetingroomYn"
              id="resort-room-category-meetingroomYn"
              data-cy="meetingroomYn"
              :class="{ valid: !v$.meetingroomYn.$invalid, invalid: v$.meetingroomYn.$invalid }"
              v-model="v$.meetingroomYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.insertUser')"
              for="resort-room-category-insertUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="resort-room-category-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.insertDate')"
              for="resort-room-category-insertDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="resort-room-category-insertDate"
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
                id="resort-room-category-insertDate"
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
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.updateUser')"
              for="resort-room-category-updateUser"
            ></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="resort-room-category-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.updateDate')"
              for="resort-room-category-updateDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="resort-room-category-updateDate"
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
                id="resort-room-category-updateDate"
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
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateCode')"
              for="resort-room-category-rateCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rateCode"
              id="resort-room-category-rateCode"
              data-cy="rateCode"
              :class="{ valid: !v$.rateCode.$invalid, invalid: v$.rateCode.$invalid }"
              v-model="v$.rateCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateAmount')"
              for="resort-room-category-rateAmount"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rateAmount"
              id="resort-room-category-rateAmount"
              data-cy="rateAmount"
              :class="{ valid: !v$.rateAmount.$invalid, invalid: v$.rateAmount.$invalid }"
              v-model.number="v$.rateAmount.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.defOccupancy')"
              for="resort-room-category-defOccupancy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="defOccupancy"
              id="resort-room-category-defOccupancy"
              data-cy="defOccupancy"
              :class="{ valid: !v$.defOccupancy.$invalid, invalid: v$.defOccupancy.$invalid }"
              v-model.number="v$.defOccupancy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.imageId')"
              for="resort-room-category-imageId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="imageId"
              id="resort-room-category-imageId"
              data-cy="imageId"
              :class="{ valid: !v$.imageId.$invalid, invalid: v$.imageId.$invalid }"
              v-model.number="v$.imageId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.pseudoYn')"
              for="resort-room-category-pseudoYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="pseudoYn"
              id="resort-room-category-pseudoYn"
              data-cy="pseudoYn"
              :class="{ valid: !v$.pseudoYn.$invalid, invalid: v$.pseudoYn.$invalid }"
              v-model="v$.pseudoYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sendToInterfaceYn')"
              for="resort-room-category-sendToInterfaceYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sendToInterfaceYn"
              id="resort-room-category-sendToInterfaceYn"
              data-cy="sendToInterfaceYn"
              :class="{ valid: !v$.sendToInterfaceYn.$invalid, invalid: v$.sendToInterfaceYn.$invalid }"
              v-model="v$.sendToInterfaceYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.yieldableYn')"
              for="resort-room-category-yieldableYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="yieldableYn"
              id="resort-room-category-yieldableYn"
              data-cy="yieldableYn"
              :class="{ valid: !v$.yieldableYn.$invalid, invalid: v$.yieldableYn.$invalid }"
              v-model="v$.yieldableYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.yieldCategory')"
              for="resort-room-category-yieldCategory"
            ></label>
            <input
              type="text"
              class="form-control"
              name="yieldCategory"
              id="resort-room-category-yieldCategory"
              data-cy="yieldCategory"
              :class="{ valid: !v$.yieldCategory.$invalid, invalid: v$.yieldCategory.$invalid }"
              v-model="v$.yieldCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.housekeeping')"
              for="resort-room-category-housekeeping"
            ></label>
            <input
              type="text"
              class="form-control"
              name="housekeeping"
              id="resort-room-category-housekeeping"
              data-cy="housekeeping"
              :class="{ valid: !v$.housekeeping.$invalid, invalid: v$.housekeeping.$invalid }"
              v-model="v$.housekeeping.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.canDeleteYn')"
              for="resort-room-category-canDeleteYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="canDeleteYn"
              id="resort-room-category-canDeleteYn"
              data-cy="canDeleteYn"
              :class="{ valid: !v$.canDeleteYn.$invalid, invalid: v$.canDeleteYn.$invalid }"
              v-model="v$.canDeleteYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roominfoUrl')"
              for="resort-room-category-roominfoUrl"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roominfoUrl"
              id="resort-room-category-roominfoUrl"
              data-cy="roominfoUrl"
              :class="{ valid: !v$.roominfoUrl.$invalid, invalid: v$.roominfoUrl.$invalid }"
              v-model="v$.roominfoUrl.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ownerYn')"
              for="resort-room-category-ownerYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="ownerYn"
              id="resort-room-category-ownerYn"
              data-cy="ownerYn"
              :class="{ valid: !v$.ownerYn.$invalid, invalid: v$.ownerYn.$invalid }"
              v-model="v$.ownerYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.autoIncludeYn')"
              for="resort-room-category-autoIncludeYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="autoIncludeYn"
              id="resort-room-category-autoIncludeYn"
              data-cy="autoIncludeYn"
              :class="{ valid: !v$.autoIncludeYn.$invalid, invalid: v$.autoIncludeYn.$invalid }"
              v-model="v$.autoIncludeYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.initialRoundUp')"
              for="resort-room-category-initialRoundUp"
            ></label>
            <input
              type="number"
              class="form-control"
              name="initialRoundUp"
              id="resort-room-category-initialRoundUp"
              data-cy="initialRoundUp"
              :class="{ valid: !v$.initialRoundUp.$invalid, invalid: v$.initialRoundUp.$invalid }"
              v-model.number="v$.initialRoundUp.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.increments')"
              for="resort-room-category-increments"
            ></label>
            <input
              type="number"
              class="form-control"
              name="increments"
              id="resort-room-category-increments"
              data-cy="increments"
              :class="{ valid: !v$.increments.$invalid, invalid: v$.increments.$invalid }"
              v-model.number="v$.increments.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rotationGroup')"
              for="resort-room-category-rotationGroup"
            ></label>
            <input
              type="text"
              class="form-control"
              name="rotationGroup"
              id="resort-room-category-rotationGroup"
              data-cy="rotationGroup"
              :class="{ valid: !v$.rotationGroup.$invalid, invalid: v$.rotationGroup.$invalid }"
              v-model="v$.rotationGroup.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.salesFlag')"
              for="resort-room-category-salesFlag"
            ></label>
            <input
              type="text"
              class="form-control"
              name="salesFlag"
              id="resort-room-category-salesFlag"
              data-cy="salesFlag"
              :class="{ valid: !v$.salesFlag.$invalid, invalid: v$.salesFlag.$invalid }"
              v-model="v$.salesFlag.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.autoRoomAssignYn')"
              for="resort-room-category-autoRoomAssignYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="autoRoomAssignYn"
              id="resort-room-category-autoRoomAssignYn"
              data-cy="autoRoomAssignYn"
              :class="{ valid: !v$.autoRoomAssignYn.$invalid, invalid: v$.autoRoomAssignYn.$invalid }"
              v-model="v$.autoRoomAssignYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.upsellYn')"
              for="resort-room-category-upsellYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="upsellYn"
              id="resort-room-category-upsellYn"
              data-cy="upsellYn"
              :class="{ valid: !v$.upsellYn.$invalid, invalid: v$.upsellYn.$invalid }"
              v-model="v$.upsellYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsUpsellRank')"
              for="resort-room-category-ormsUpsellRank"
            ></label>
            <input
              type="number"
              class="form-control"
              name="ormsUpsellRank"
              id="resort-room-category-ormsUpsellRank"
              data-cy="ormsUpsellRank"
              :class="{ valid: !v$.ormsUpsellRank.$invalid, invalid: v$.ormsUpsellRank.$invalid }"
              v-model.number="v$.ormsUpsellRank.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsUpsellAmt')"
              for="resort-room-category-ormsUpsellAmt"
            ></label>
            <input
              type="number"
              class="form-control"
              name="ormsUpsellAmt"
              id="resort-room-category-ormsUpsellAmt"
              data-cy="ormsUpsellAmt"
              :class="{ valid: !v$.ormsUpsellAmt.$invalid, invalid: v$.ormsUpsellAmt.$invalid }"
              v-model.number="v$.ormsUpsellAmt.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrxtraAdult')"
              for="resort-room-category-ormsDrxtraAdult"
            ></label>
            <input
              type="number"
              class="form-control"
              name="ormsDrxtraAdult"
              id="resort-room-category-ormsDrxtraAdult"
              data-cy="ormsDrxtraAdult"
              :class="{ valid: !v$.ormsDrxtraAdult.$invalid, invalid: v$.ormsDrxtraAdult.$invalid }"
              v-model.number="v$.ormsDrxtraAdult.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrxtraChild')"
              for="resort-room-category-ormsDrxtraChild"
            ></label>
            <input
              type="number"
              class="form-control"
              name="ormsDrxtraChild"
              id="resort-room-category-ormsDrxtraChild"
              data-cy="ormsDrxtraChild"
              :class="{ valid: !v$.ormsDrxtraChild.$invalid, invalid: v$.ormsDrxtraChild.$invalid }"
              v-model.number="v$.ormsDrxtraChild.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxOccupancyAdults')"
              for="resort-room-category-maxOccupancyAdults"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxOccupancyAdults"
              id="resort-room-category-maxOccupancyAdults"
              data-cy="maxOccupancyAdults"
              :class="{ valid: !v$.maxOccupancyAdults.$invalid, invalid: v$.maxOccupancyAdults.$invalid }"
              v-model.number="v$.maxOccupancyAdults.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxOccupancyChildren')"
              for="resort-room-category-maxOccupancyChildren"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxOccupancyChildren"
              id="resort-room-category-maxOccupancyChildren"
              data-cy="maxOccupancyChildren"
              :class="{ valid: !v$.maxOccupancyChildren.$invalid, invalid: v$.maxOccupancyChildren.$invalid }"
              v-model.number="v$.maxOccupancyChildren.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.roomPool')"
              for="resort-room-category-roomPool"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomPool"
              id="resort-room-category-roomPool"
              data-cy="roomPool"
              :class="{ valid: !v$.roomPool.$invalid, invalid: v$.roomPool.$invalid }"
              v-model="v$.roomPool.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.memberAwardRoomGrp')"
              for="resort-room-category-memberAwardRoomGrp"
            ></label>
            <input
              type="text"
              class="form-control"
              name="memberAwardRoomGrp"
              id="resort-room-category-memberAwardRoomGrp"
              data-cy="memberAwardRoomGrp"
              :class="{ valid: !v$.memberAwardRoomGrp.$invalid, invalid: v$.memberAwardRoomGrp.$invalid }"
              v-model="v$.memberAwardRoomGrp.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrxtra2ndAdult')"
              for="resort-room-category-ormsDrxtra2ndAdult"
            ></label>
            <input
              type="number"
              class="form-control"
              name="ormsDrxtra2ndAdult"
              id="resort-room-category-ormsDrxtra2ndAdult"
              data-cy="ormsDrxtra2ndAdult"
              :class="{ valid: !v$.ormsDrxtra2ndAdult.$invalid, invalid: v$.ormsDrxtra2ndAdult.$invalid }"
              v-model.number="v$.ormsDrxtra2ndAdult.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrtier1')"
              for="resort-room-category-ormsDrtier1"
            ></label>
            <input
              type="number"
              class="form-control"
              name="ormsDrtier1"
              id="resort-room-category-ormsDrtier1"
              data-cy="ormsDrtier1"
              :class="{ valid: !v$.ormsDrtier1.$invalid, invalid: v$.ormsDrtier1.$invalid }"
              v-model.number="v$.ormsDrtier1.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrtier2')"
              for="resort-room-category-ormsDrtier2"
            ></label>
            <input
              type="number"
              class="form-control"
              name="ormsDrtier2"
              id="resort-room-category-ormsDrtier2"
              data-cy="ormsDrtier2"
              :class="{ valid: !v$.ormsDrtier2.$invalid, invalid: v$.ormsDrtier2.$invalid }"
              v-model.number="v$.ormsDrtier2.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.ormsDrtier3')"
              for="resort-room-category-ormsDrtier3"
            ></label>
            <input
              type="number"
              class="form-control"
              name="ormsDrtier3"
              id="resort-room-category-ormsDrtier3"
              data-cy="ormsDrtier3"
              :class="{ valid: !v$.ormsDrtier3.$invalid, invalid: v$.ormsDrtier3.$invalid }"
              v-model.number="v$.ormsDrtier3.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.autoCheckinYn')"
              for="resort-room-category-autoCheckinYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="autoCheckinYn"
              id="resort-room-category-autoCheckinYn"
              data-cy="autoCheckinYn"
              :class="{ valid: !v$.autoCheckinYn.$invalid, invalid: v$.autoCheckinYn.$invalid }"
              v-model="v$.autoCheckinYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.rateFloor')"
              for="resort-room-category-rateFloor"
            ></label>
            <input
              type="number"
              class="form-control"
              name="rateFloor"
              id="resort-room-category-rateFloor"
              data-cy="rateFloor"
              :class="{ valid: !v$.rateFloor.$invalid, invalid: v$.rateFloor.$invalid }"
              v-model.number="v$.rateFloor.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maxFixBedOccupancy')"
              for="resort-room-category-maxFixBedOccupancy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="maxFixBedOccupancy"
              id="resort-room-category-maxFixBedOccupancy"
              data-cy="maxFixBedOccupancy"
              :class="{ valid: !v$.maxFixBedOccupancy.$invalid, invalid: v$.maxFixBedOccupancy.$invalid }"
              v-model.number="v$.maxFixBedOccupancy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.maintenanceYn')"
              for="resort-room-category-maintenanceYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="maintenanceYn"
              id="resort-room-category-maintenanceYn"
              data-cy="maintenanceYn"
              :class="{ valid: !v$.maintenanceYn.$invalid, invalid: v$.maintenanceYn.$invalid }"
              v-model="v$.maintenanceYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.smokingPreference')"
              for="resort-room-category-smokingPreference"
            ></label>
            <input
              type="text"
              class="form-control"
              name="smokingPreference"
              id="resort-room-category-smokingPreference"
              data-cy="smokingPreference"
              :class="{ valid: !v$.smokingPreference.$invalid, invalid: v$.smokingPreference.$invalid }"
              v-model="v$.smokingPreference.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sLabel')"
              for="resort-room-category-sLabel"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sLabel"
              id="resort-room-category-sLabel"
              data-cy="sLabel"
              :class="{ valid: !v$.sLabel.$invalid, invalid: v$.sLabel.$invalid }"
              v-model="v$.sLabel.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sBedtype')"
              for="resort-room-category-sBedtype"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sBedtype"
              id="resort-room-category-sBedtype"
              data-cy="sBedtype"
              :class="{ valid: !v$.sBedtype.$invalid, invalid: v$.sBedtype.$invalid }"
              v-model="v$.sBedtype.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.sellThruRuleYn')"
              for="resort-room-category-sellThruRuleYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="sellThruRuleYn"
              id="resort-room-category-sellThruRuleYn"
              data-cy="sellThruRuleYn"
              :class="{ valid: !v$.sellThruRuleYn.$invalid, invalid: v$.sellThruRuleYn.$invalid }"
              v-model="v$.sellThruRuleYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.crsDescription')"
              for="resort-room-category-crsDescription"
            ></label>
            <input
              type="text"
              class="form-control"
              name="crsDescription"
              id="resort-room-category-crsDescription"
              data-cy="crsDescription"
              :class="{ valid: !v$.crsDescription.$invalid, invalid: v$.crsDescription.$invalid }"
              v-model="v$.crsDescription.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.evisitorFacilityId')"
              for="resort-room-category-evisitorFacilityId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="evisitorFacilityId"
              id="resort-room-category-evisitorFacilityId"
              data-cy="evisitorFacilityId"
              :class="{ valid: !v$.evisitorFacilityId.$invalid, invalid: v$.evisitorFacilityId.$invalid }"
              v-model="v$.evisitorFacilityId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.minOccupancy')"
              for="resort-room-category-minOccupancy"
            ></label>
            <input
              type="number"
              class="form-control"
              name="minOccupancy"
              id="resort-room-category-minOccupancy"
              data-cy="minOccupancy"
              :class="{ valid: !v$.minOccupancy.$invalid, invalid: v$.minOccupancy.$invalid }"
              v-model.number="v$.minOccupancy.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.resortRoomCategory.accessibleYn')"
              for="resort-room-category-accessibleYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="accessibleYn"
              id="resort-room-category-accessibleYn"
              data-cy="accessibleYn"
              :class="{ valid: !v$.accessibleYn.$invalid, invalid: v$.accessibleYn.$invalid }"
              v-model="v$.accessibleYn.$model"
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
<script lang="ts" src="./resort-room-category-update.component.ts"></script>
