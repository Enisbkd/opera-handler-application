<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate v-on:submit.prevent="save()">
        <h2
          id="operaHandlerApplicationApp.name.home.createOrEditLabel"
          data-cy="NameCreateUpdateHeading"
          v-text="t$('operaHandlerApplicationApp.name.home.createOrEditLabel')"
        ></h2>
        <div>
          <div class="form-group" v-if="name.id">
            <label for="id" v-text="t$('global.field.id')"></label>
            <input type="text" class="form-control" id="id" name="id" v-model="name.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.nameId')" for="name-nameId"></label>
            <input
              type="number"
              class="form-control"
              name="nameId"
              id="name-nameId"
              data-cy="nameId"
              :class="{ valid: !v$.nameId.$invalid, invalid: v$.nameId.$invalid }"
              v-model.number="v$.nameId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.nameCode')" for="name-nameCode"></label>
            <input
              type="text"
              class="form-control"
              name="nameCode"
              id="name-nameCode"
              data-cy="nameCode"
              :class="{ valid: !v$.nameCode.$invalid, invalid: v$.nameCode.$invalid }"
              v-model="v$.nameCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.insertUser')" for="name-insertUser"></label>
            <input
              type="number"
              class="form-control"
              name="insertUser"
              id="name-insertUser"
              data-cy="insertUser"
              :class="{ valid: !v$.insertUser.$invalid, invalid: v$.insertUser.$invalid }"
              v-model.number="v$.insertUser.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.insertDate')" for="name-insertDate"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-insertDate"
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
                id="name-insertDate"
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
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.updateUser')" for="name-updateUser"></label>
            <input
              type="number"
              class="form-control"
              name="updateUser"
              id="name-updateUser"
              data-cy="updateUser"
              :class="{ valid: !v$.updateUser.$invalid, invalid: v$.updateUser.$invalid }"
              v-model.number="v$.updateUser.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.updateDate')" for="name-updateDate"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-updateDate"
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
                id="name-updateDate"
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
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.primaryNameId')" for="name-primaryNameId"></label>
            <input
              type="number"
              class="form-control"
              name="primaryNameId"
              id="name-primaryNameId"
              data-cy="primaryNameId"
              :class="{ valid: !v$.primaryNameId.$invalid, invalid: v$.primaryNameId.$invalid }"
              v-model.number="v$.primaryNameId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.repeatGuestId')" for="name-repeatGuestId"></label>
            <input
              type="text"
              class="form-control"
              name="repeatGuestId"
              id="name-repeatGuestId"
              data-cy="repeatGuestId"
              :class="{ valid: !v$.repeatGuestId.$invalid, invalid: v$.repeatGuestId.$invalid }"
              v-model="v$.repeatGuestId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.mailList')" for="name-mailList"></label>
            <input
              type="text"
              class="form-control"
              name="mailList"
              id="name-mailList"
              data-cy="mailList"
              :class="{ valid: !v$.mailList.$invalid, invalid: v$.mailList.$invalid }"
              v-model="v$.mailList.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.mailType')" for="name-mailType"></label>
            <input
              type="text"
              class="form-control"
              name="mailType"
              id="name-mailType"
              data-cy="mailType"
              :class="{ valid: !v$.mailType.$invalid, invalid: v$.mailType.$invalid }"
              v-model="v$.mailType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.followOn')" for="name-followOn"></label>
            <input
              type="text"
              class="form-control"
              name="followOn"
              id="name-followOn"
              data-cy="followOn"
              :class="{ valid: !v$.followOn.$invalid, invalid: v$.followOn.$invalid }"
              v-model="v$.followOn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.businessTitle')" for="name-businessTitle"></label>
            <input
              type="text"
              class="form-control"
              name="businessTitle"
              id="name-businessTitle"
              data-cy="businessTitle"
              :class="{ valid: !v$.businessTitle.$invalid, invalid: v$.businessTitle.$invalid }"
              v-model="v$.businessTitle.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.inactiveDate')" for="name-inactiveDate"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-inactiveDate"
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
                id="name-inactiveDate"
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
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.arcUpdateDate')" for="name-arcUpdateDate"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-arcUpdateDate"
                  v-model="v$.arcUpdateDate.$model"
                  name="arcUpdateDate"
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
                id="name-arcUpdateDate"
                data-cy="arcUpdateDate"
                type="text"
                class="form-control"
                name="arcUpdateDate"
                :class="{ valid: !v$.arcUpdateDate.$invalid, invalid: v$.arcUpdateDate.$invalid }"
                v-model="v$.arcUpdateDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.updateFaxDate')" for="name-updateFaxDate"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-updateFaxDate"
                  v-model="v$.updateFaxDate.$model"
                  name="updateFaxDate"
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
                id="name-updateFaxDate"
                data-cy="updateFaxDate"
                type="text"
                class="form-control"
                name="updateFaxDate"
                :class="{ valid: !v$.updateFaxDate.$invalid, invalid: v$.updateFaxDate.$invalid }"
                v-model="v$.updateFaxDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.birthDate')" for="name-birthDate"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-birthDate"
                  v-model="v$.birthDate.$model"
                  name="birthDate"
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
                id="name-birthDate"
                data-cy="birthDate"
                type="text"
                class="form-control"
                name="birthDate"
                :class="{ valid: !v$.birthDate.$invalid, invalid: v$.birthDate.$invalid }"
                v-model="v$.birthDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.collectionUserId')"
              for="name-collectionUserId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="collectionUserId"
              id="name-collectionUserId"
              data-cy="collectionUserId"
              :class="{ valid: !v$.collectionUserId.$invalid, invalid: v$.collectionUserId.$invalid }"
              v-model.number="v$.collectionUserId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.company')" for="name-company"></label>
            <input
              type="text"
              class="form-control"
              name="company"
              id="name-company"
              data-cy="company"
              :class="{ valid: !v$.company.$invalid, invalid: v$.company.$invalid }"
              v-model="v$.company.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.soundExCompany')"
              for="name-soundExCompany"
            ></label>
            <input
              type="text"
              class="form-control"
              name="soundExCompany"
              id="name-soundExCompany"
              data-cy="soundExCompany"
              :class="{ valid: !v$.soundExCompany.$invalid, invalid: v$.soundExCompany.$invalid }"
              v-model="v$.soundExCompany.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.legalCompany')" for="name-legalCompany"></label>
            <input
              type="text"
              class="form-control"
              name="legalCompany"
              id="name-legalCompany"
              data-cy="legalCompany"
              :class="{ valid: !v$.legalCompany.$invalid, invalid: v$.legalCompany.$invalid }"
              v-model="v$.legalCompany.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.first')" for="name-first"></label>
            <input
              type="text"
              class="form-control"
              name="first"
              id="name-first"
              data-cy="first"
              :class="{ valid: !v$.first.$invalid, invalid: v$.first.$invalid }"
              v-model="v$.first.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.middle')" for="name-middle"></label>
            <input
              type="text"
              class="form-control"
              name="middle"
              id="name-middle"
              data-cy="middle"
              :class="{ valid: !v$.middle.$invalid, invalid: v$.middle.$invalid }"
              v-model="v$.middle.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.last')" for="name-last"></label>
            <input
              type="text"
              class="form-control"
              name="last"
              id="name-last"
              data-cy="last"
              :class="{ valid: !v$.last.$invalid, invalid: v$.last.$invalid }"
              v-model="v$.last.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.nickname')" for="name-nickname"></label>
            <input
              type="text"
              class="form-control"
              name="nickname"
              id="name-nickname"
              data-cy="nickname"
              :class="{ valid: !v$.nickname.$invalid, invalid: v$.nickname.$invalid }"
              v-model="v$.nickname.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.title')" for="name-title"></label>
            <input
              type="text"
              class="form-control"
              name="title"
              id="name-title"
              data-cy="title"
              :class="{ valid: !v$.title.$invalid, invalid: v$.title.$invalid }"
              v-model="v$.title.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.soundExLast')" for="name-soundExLast"></label>
            <input
              type="text"
              class="form-control"
              name="soundExLast"
              id="name-soundExLast"
              data-cy="soundExLast"
              :class="{ valid: !v$.soundExLast.$invalid, invalid: v$.soundExLast.$invalid }"
              v-model="v$.soundExLast.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.externalReferenceRequ')"
              for="name-externalReferenceRequ"
            ></label>
            <input
              type="text"
              class="form-control"
              name="externalReferenceRequ"
              id="name-externalReferenceRequ"
              data-cy="externalReferenceRequ"
              :class="{ valid: !v$.externalReferenceRequ.$invalid, invalid: v$.externalReferenceRequ.$invalid }"
              v-model="v$.externalReferenceRequ.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.vipStatus')" for="name-vipStatus"></label>
            <input
              type="text"
              class="form-control"
              name="vipStatus"
              id="name-vipStatus"
              data-cy="vipStatus"
              :class="{ valid: !v$.vipStatus.$invalid, invalid: v$.vipStatus.$invalid }"
              v-model="v$.vipStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.vipAuthorization')"
              for="name-vipAuthorization"
            ></label>
            <input
              type="text"
              class="form-control"
              name="vipAuthorization"
              id="name-vipAuthorization"
              data-cy="vipAuthorization"
              :class="{ valid: !v$.vipAuthorization.$invalid, invalid: v$.vipAuthorization.$invalid }"
              v-model="v$.vipAuthorization.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.billingProfileCode')"
              for="name-billingProfileCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="billingProfileCode"
              id="name-billingProfileCode"
              data-cy="billingProfileCode"
              :class="{ valid: !v$.billingProfileCode.$invalid, invalid: v$.billingProfileCode.$invalid }"
              v-model="v$.billingProfileCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.rateStructure')" for="name-rateStructure"></label>
            <input
              type="text"
              class="form-control"
              name="rateStructure"
              id="name-rateStructure"
              data-cy="rateStructure"
              :class="{ valid: !v$.rateStructure.$invalid, invalid: v$.rateStructure.$invalid }"
              v-model="v$.rateStructure.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.nameComment')" for="name-nameComment"></label>
            <input
              type="text"
              class="form-control"
              name="nameComment"
              id="name-nameComment"
              data-cy="nameComment"
              :class="{ valid: !v$.nameComment.$invalid, invalid: v$.nameComment.$invalid }"
              v-model="v$.nameComment.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.tourOperatorType')"
              for="name-tourOperatorType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="tourOperatorType"
              id="name-tourOperatorType"
              data-cy="tourOperatorType"
              :class="{ valid: !v$.tourOperatorType.$invalid, invalid: v$.tourOperatorType.$invalid }"
              v-model="v$.tourOperatorType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.region')" for="name-region"></label>
            <input
              type="text"
              class="form-control"
              name="region"
              id="name-region"
              data-cy="region"
              :class="{ valid: !v$.region.$invalid, invalid: v$.region.$invalid }"
              v-model="v$.region.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.typeOf1099')" for="name-typeOf1099"></label>
            <input
              type="text"
              class="form-control"
              name="typeOf1099"
              id="name-typeOf1099"
              data-cy="typeOf1099"
              :class="{ valid: !v$.typeOf1099.$invalid, invalid: v$.typeOf1099.$invalid }"
              v-model="v$.typeOf1099.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.tax1No')" for="name-tax1No"></label>
            <input
              type="text"
              class="form-control"
              name="tax1No"
              id="name-tax1No"
              data-cy="tax1No"
              :class="{ valid: !v$.tax1No.$invalid, invalid: v$.tax1No.$invalid }"
              v-model="v$.tax1No.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.companyNameId')" for="name-companyNameId"></label>
            <input
              type="number"
              class="form-control"
              name="companyNameId"
              id="name-companyNameId"
              data-cy="companyNameId"
              :class="{ valid: !v$.companyNameId.$invalid, invalid: v$.companyNameId.$invalid }"
              v-model.number="v$.companyNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.externalReferenceRequired')"
              for="name-externalReferenceRequired"
            ></label>
            <input
              type="text"
              class="form-control"
              name="externalReferenceRequired"
              id="name-externalReferenceRequired"
              data-cy="externalReferenceRequired"
              :class="{ valid: !v$.externalReferenceRequired.$invalid, invalid: v$.externalReferenceRequired.$invalid }"
              v-model="v$.externalReferenceRequired.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.vendorId')" for="name-vendorId"></label>
            <input
              type="number"
              class="form-control"
              name="vendorId"
              id="name-vendorId"
              data-cy="vendorId"
              :class="{ valid: !v$.vendorId.$invalid, invalid: v$.vendorId.$invalid }"
              v-model.number="v$.vendorId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.vendorSiteId')" for="name-vendorSiteId"></label>
            <input
              type="number"
              class="form-control"
              name="vendorSiteId"
              id="name-vendorSiteId"
              data-cy="vendorSiteId"
              :class="{ valid: !v$.vendorSiteId.$invalid, invalid: v$.vendorSiteId.$invalid }"
              v-model.number="v$.vendorSiteId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.arcOfficeType')" for="name-arcOfficeType"></label>
            <input
              type="text"
              class="form-control"
              name="arcOfficeType"
              id="name-arcOfficeType"
              data-cy="arcOfficeType"
              :class="{ valid: !v$.arcOfficeType.$invalid, invalid: v$.arcOfficeType.$invalid }"
              v-model="v$.arcOfficeType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.tax2No')" for="name-tax2No"></label>
            <input
              type="text"
              class="form-control"
              name="tax2No"
              id="name-tax2No"
              data-cy="tax2No"
              :class="{ valid: !v$.tax2No.$invalid, invalid: v$.tax2No.$invalid }"
              v-model="v$.tax2No.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.arcMailFlag')" for="name-arcMailFlag"></label>
            <input
              type="text"
              class="form-control"
              name="arcMailFlag"
              id="name-arcMailFlag"
              data-cy="arcMailFlag"
              :class="{ valid: !v$.arcMailFlag.$invalid, invalid: v$.arcMailFlag.$invalid }"
              v-model="v$.arcMailFlag.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.name2')" for="name-name2"></label>
            <input
              type="text"
              class="form-control"
              name="name2"
              id="name-name2"
              data-cy="name2"
              :class="{ valid: !v$.name2.$invalid, invalid: v$.name2.$invalid }"
              v-model="v$.name2.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.name3')" for="name-name3"></label>
            <input
              type="text"
              class="form-control"
              name="name3"
              id="name-name3"
              data-cy="name3"
              :class="{ valid: !v$.name3.$invalid, invalid: v$.name3.$invalid }"
              v-model="v$.name3.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.salesrep')" for="name-salesrep"></label>
            <input
              type="text"
              class="form-control"
              name="salesrep"
              id="name-salesrep"
              data-cy="salesrep"
              :class="{ valid: !v$.salesrep.$invalid, invalid: v$.salesrep.$invalid }"
              v-model="v$.salesrep.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.tracecode')" for="name-tracecode"></label>
            <input
              type="text"
              class="form-control"
              name="tracecode"
              id="name-tracecode"
              data-cy="tracecode"
              :class="{ valid: !v$.tracecode.$invalid, invalid: v$.tracecode.$invalid }"
              v-model="v$.tracecode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.geographicRegion')"
              for="name-geographicRegion"
            ></label>
            <input
              type="text"
              class="form-control"
              name="geographicRegion"
              id="name-geographicRegion"
              data-cy="geographicRegion"
              :class="{ valid: !v$.geographicRegion.$invalid, invalid: v$.geographicRegion.$invalid }"
              v-model="v$.geographicRegion.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.guestClassification')"
              for="name-guestClassification"
            ></label>
            <input
              type="text"
              class="form-control"
              name="guestClassification"
              id="name-guestClassification"
              data-cy="guestClassification"
              :class="{ valid: !v$.guestClassification.$invalid, invalid: v$.guestClassification.$invalid }"
              v-model="v$.guestClassification.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.primaryAddressId')"
              for="name-primaryAddressId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="primaryAddressId"
              id="name-primaryAddressId"
              data-cy="primaryAddressId"
              :class="{ valid: !v$.primaryAddressId.$invalid, invalid: v$.primaryAddressId.$invalid }"
              v-model.number="v$.primaryAddressId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.primaryPhoneId')"
              for="name-primaryPhoneId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="primaryPhoneId"
              id="name-primaryPhoneId"
              data-cy="primaryPhoneId"
              :class="{ valid: !v$.primaryPhoneId.$invalid, invalid: v$.primaryPhoneId.$invalid }"
              v-model.number="v$.primaryPhoneId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.taxExemptStatus')"
              for="name-taxExemptStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="taxExemptStatus"
              id="name-taxExemptStatus"
              data-cy="taxExemptStatus"
              :class="{ valid: !v$.taxExemptStatus.$invalid, invalid: v$.taxExemptStatus.$invalid }"
              v-model="v$.taxExemptStatus.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.gdsName')" for="name-gdsName"></label>
            <input
              type="text"
              class="form-control"
              name="gdsName"
              id="name-gdsName"
              data-cy="gdsName"
              :class="{ valid: !v$.gdsName.$invalid, invalid: v$.gdsName.$invalid }"
              v-model="v$.gdsName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.gdsTransactionNo')"
              for="name-gdsTransactionNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="gdsTransactionNo"
              id="name-gdsTransactionNo"
              data-cy="gdsTransactionNo"
              :class="{ valid: !v$.gdsTransactionNo.$invalid, invalid: v$.gdsTransactionNo.$invalid }"
              v-model="v$.gdsTransactionNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.nationality')" for="name-nationality"></label>
            <input
              type="text"
              class="form-control"
              name="nationality"
              id="name-nationality"
              data-cy="nationality"
              :class="{ valid: !v$.nationality.$invalid, invalid: v$.nationality.$invalid }"
              v-model="v$.nationality.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.language')" for="name-language"></label>
            <input
              type="text"
              class="form-control"
              name="language"
              id="name-language"
              data-cy="language"
              :class="{ valid: !v$.language.$invalid, invalid: v$.language.$invalid }"
              v-model="v$.language.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.salutation')" for="name-salutation"></label>
            <input
              type="text"
              class="form-control"
              name="salutation"
              id="name-salutation"
              data-cy="salutation"
              :class="{ valid: !v$.salutation.$invalid, invalid: v$.salutation.$invalid }"
              v-model="v$.salutation.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.passport')" for="name-passport"></label>
            <input
              type="text"
              class="form-control"
              name="passport"
              id="name-passport"
              data-cy="passport"
              :class="{ valid: !v$.passport.$invalid, invalid: v$.passport.$invalid }"
              v-model="v$.passport.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.historyYn')" for="name-historyYn"></label>
            <input
              type="text"
              class="form-control"
              name="historyYn"
              id="name-historyYn"
              data-cy="historyYn"
              :class="{ valid: !v$.historyYn.$invalid, invalid: v$.historyYn.$invalid }"
              v-model="v$.historyYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.resvContact')" for="name-resvContact"></label>
            <input
              type="text"
              class="form-control"
              name="resvContact"
              id="name-resvContact"
              data-cy="resvContact"
              :class="{ valid: !v$.resvContact.$invalid, invalid: v$.resvContact.$invalid }"
              v-model="v$.resvContact.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.contractNo')" for="name-contractNo"></label>
            <input
              type="text"
              class="form-control"
              name="contractNo"
              id="name-contractNo"
              data-cy="contractNo"
              :class="{ valid: !v$.contractNo.$invalid, invalid: v$.contractNo.$invalid }"
              v-model="v$.contractNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.contractRecvDate')"
              for="name-contractRecvDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-contractRecvDate"
                  v-model="v$.contractRecvDate.$model"
                  name="contractRecvDate"
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
                id="name-contractRecvDate"
                data-cy="contractRecvDate"
                type="text"
                class="form-control"
                name="contractRecvDate"
                :class="{ valid: !v$.contractRecvDate.$invalid, invalid: v$.contractRecvDate.$invalid }"
                v-model="v$.contractRecvDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.acctContact')" for="name-acctContact"></label>
            <input
              type="text"
              class="form-control"
              name="acctContact"
              id="name-acctContact"
              data-cy="acctContact"
              :class="{ valid: !v$.acctContact.$invalid, invalid: v$.acctContact.$invalid }"
              v-model="v$.acctContact.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.priority')" for="name-priority"></label>
            <input
              type="text"
              class="form-control"
              name="priority"
              id="name-priority"
              data-cy="priority"
              :class="{ valid: !v$.priority.$invalid, invalid: v$.priority.$invalid }"
              v-model="v$.priority.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.industryCode')" for="name-industryCode"></label>
            <input
              type="text"
              class="form-control"
              name="industryCode"
              id="name-industryCode"
              data-cy="industryCode"
              :class="{ valid: !v$.industryCode.$invalid, invalid: v$.industryCode.$invalid }"
              v-model="v$.industryCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.roomsPotential')"
              for="name-roomsPotential"
            ></label>
            <input
              type="text"
              class="form-control"
              name="roomsPotential"
              id="name-roomsPotential"
              data-cy="roomsPotential"
              :class="{ valid: !v$.roomsPotential.$invalid, invalid: v$.roomsPotential.$invalid }"
              v-model="v$.roomsPotential.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.competitionCode')"
              for="name-competitionCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="competitionCode"
              id="name-competitionCode"
              data-cy="competitionCode"
              :class="{ valid: !v$.competitionCode.$invalid, invalid: v$.competitionCode.$invalid }"
              v-model="v$.competitionCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.scope')" for="name-scope"></label>
            <input
              type="text"
              class="form-control"
              name="scope"
              id="name-scope"
              data-cy="scope"
              :class="{ valid: !v$.scope.$invalid, invalid: v$.scope.$invalid }"
              v-model="v$.scope.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.scopeCity')" for="name-scopeCity"></label>
            <input
              type="text"
              class="form-control"
              name="scopeCity"
              id="name-scopeCity"
              data-cy="scopeCity"
              :class="{ valid: !v$.scopeCity.$invalid, invalid: v$.scopeCity.$invalid }"
              v-model="v$.scopeCity.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.territory')" for="name-territory"></label>
            <input
              type="text"
              class="form-control"
              name="territory"
              id="name-territory"
              data-cy="territory"
              :class="{ valid: !v$.territory.$invalid, invalid: v$.territory.$invalid }"
              v-model="v$.territory.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.actioncode')" for="name-actioncode"></label>
            <input
              type="text"
              class="form-control"
              name="actioncode"
              id="name-actioncode"
              data-cy="actioncode"
              :class="{ valid: !v$.actioncode.$invalid, invalid: v$.actioncode.$invalid }"
              v-model="v$.actioncode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.activeYn')" for="name-activeYn"></label>
            <input
              type="text"
              class="form-control"
              name="activeYn"
              id="name-activeYn"
              data-cy="activeYn"
              :class="{ valid: !v$.activeYn.$invalid, invalid: v$.activeYn.$invalid }"
              v-model="v$.activeYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.masterAccountYn')"
              for="name-masterAccountYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="masterAccountYn"
              id="name-masterAccountYn"
              data-cy="masterAccountYn"
              :class="{ valid: !v$.masterAccountYn.$invalid, invalid: v$.masterAccountYn.$invalid }"
              v-model="v$.masterAccountYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.nameType')" for="name-nameType"></label>
            <input
              type="text"
              class="form-control"
              name="nameType"
              id="name-nameType"
              data-cy="nameType"
              :class="{ valid: !v$.nameType.$invalid, invalid: v$.nameType.$invalid }"
              v-model="v$.nameType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.sname')" for="name-sname"></label>
            <input
              type="text"
              class="form-control"
              name="sname"
              id="name-sname"
              data-cy="sname"
              :class="{ valid: !v$.sname.$invalid, invalid: v$.sname.$invalid }"
              v-model="v$.sname.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.nameTaxType')" for="name-nameTaxType"></label>
            <input
              type="text"
              class="form-control"
              name="nameTaxType"
              id="name-nameTaxType"
              data-cy="nameTaxType"
              :class="{ valid: !v$.nameTaxType.$invalid, invalid: v$.nameTaxType.$invalid }"
              v-model="v$.nameTaxType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.sfirst')" for="name-sfirst"></label>
            <input
              type="text"
              class="form-control"
              name="sfirst"
              id="name-sfirst"
              data-cy="sfirst"
              :class="{ valid: !v$.sfirst.$invalid, invalid: v$.sfirst.$invalid }"
              v-model="v$.sfirst.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.arNo')" for="name-arNo"></label>
            <input
              type="text"
              class="form-control"
              name="arNo"
              id="name-arNo"
              data-cy="arNo"
              :class="{ valid: !v$.arNo.$invalid, invalid: v$.arNo.$invalid }"
              v-model="v$.arNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.availabilityOverride')"
              for="name-availabilityOverride"
            ></label>
            <input
              type="text"
              class="form-control"
              name="availabilityOverride"
              id="name-availabilityOverride"
              data-cy="availabilityOverride"
              :class="{ valid: !v$.availabilityOverride.$invalid, invalid: v$.availabilityOverride.$invalid }"
              v-model="v$.availabilityOverride.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.billingCode')" for="name-billingCode"></label>
            <input
              type="text"
              class="form-control"
              name="billingCode"
              id="name-billingCode"
              data-cy="billingCode"
              :class="{ valid: !v$.billingCode.$invalid, invalid: v$.billingCode.$invalid }"
              v-model="v$.billingCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.cashBlInd')" for="name-cashBlInd"></label>
            <input
              type="text"
              class="form-control"
              name="cashBlInd"
              id="name-cashBlInd"
              data-cy="cashBlInd"
              :class="{ valid: !v$.cashBlInd.$invalid, invalid: v$.cashBlInd.$invalid }"
              v-model="v$.cashBlInd.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.blMsg')" for="name-blMsg"></label>
            <input
              type="text"
              class="form-control"
              name="blMsg"
              id="name-blMsg"
              data-cy="blMsg"
              :class="{ valid: !v$.blMsg.$invalid, invalid: v$.blMsg.$invalid }"
              v-model="v$.blMsg.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.currencyCode')" for="name-currencyCode"></label>
            <input
              type="text"
              class="form-control"
              name="currencyCode"
              id="name-currencyCode"
              data-cy="currencyCode"
              :class="{ valid: !v$.currencyCode.$invalid, invalid: v$.currencyCode.$invalid }"
              v-model="v$.currencyCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.commissionCode')"
              for="name-commissionCode"
            ></label>
            <input
              type="text"
              class="form-control"
              name="commissionCode"
              id="name-commissionCode"
              data-cy="commissionCode"
              :class="{ valid: !v$.commissionCode.$invalid, invalid: v$.commissionCode.$invalid }"
              v-model="v$.commissionCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.holdCode')" for="name-holdCode"></label>
            <input
              type="text"
              class="form-control"
              name="holdCode"
              id="name-holdCode"
              data-cy="holdCode"
              :class="{ valid: !v$.holdCode.$invalid, invalid: v$.holdCode.$invalid }"
              v-model="v$.holdCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.interest')" for="name-interest"></label>
            <input
              type="text"
              class="form-control"
              name="interest"
              id="name-interest"
              data-cy="interest"
              :class="{ valid: !v$.interest.$invalid, invalid: v$.interest.$invalid }"
              v-model="v$.interest.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.summRefCc')" for="name-summRefCc"></label>
            <input
              type="text"
              class="form-control"
              name="summRefCc"
              id="name-summRefCc"
              data-cy="summRefCc"
              :class="{ valid: !v$.summRefCc.$invalid, invalid: v$.summRefCc.$invalid }"
              v-model="v$.summRefCc.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.iataCompType')" for="name-iataCompType"></label>
            <input
              type="text"
              class="form-control"
              name="iataCompType"
              id="name-iataCompType"
              data-cy="iataCompType"
              :class="{ valid: !v$.iataCompType.$invalid, invalid: v$.iataCompType.$invalid }"
              v-model="v$.iataCompType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.srepCode')" for="name-srepCode"></label>
            <input
              type="text"
              class="form-control"
              name="srepCode"
              id="name-srepCode"
              data-cy="srepCode"
              :class="{ valid: !v$.srepCode.$invalid, invalid: v$.srepCode.$invalid }"
              v-model="v$.srepCode.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.accountsource')" for="name-accountsource"></label>
            <input
              type="text"
              class="form-control"
              name="accountsource"
              id="name-accountsource"
              data-cy="accountsource"
              :class="{ valid: !v$.accountsource.$invalid, invalid: v$.accountsource.$invalid }"
              v-model="v$.accountsource.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.markets')" for="name-markets"></label>
            <input
              type="text"
              class="form-control"
              name="markets"
              id="name-markets"
              data-cy="markets"
              :class="{ valid: !v$.markets.$invalid, invalid: v$.markets.$invalid }"
              v-model="v$.markets.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.productInterest')"
              for="name-productInterest"
            ></label>
            <input
              type="text"
              class="form-control"
              name="productInterest"
              id="name-productInterest"
              data-cy="productInterest"
              :class="{ valid: !v$.productInterest.$invalid, invalid: v$.productInterest.$invalid }"
              v-model="v$.productInterest.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.keyword')" for="name-keyword"></label>
            <input
              type="text"
              class="form-control"
              name="keyword"
              id="name-keyword"
              data-cy="keyword"
              :class="{ valid: !v$.keyword.$invalid, invalid: v$.keyword.$invalid }"
              v-model="v$.keyword.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.letterGreeting')"
              for="name-letterGreeting"
            ></label>
            <input
              type="text"
              class="form-control"
              name="letterGreeting"
              id="name-letterGreeting"
              data-cy="letterGreeting"
              :class="{ valid: !v$.letterGreeting.$invalid, invalid: v$.letterGreeting.$invalid }"
              v-model="v$.letterGreeting.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.influence')" for="name-influence"></label>
            <input
              type="text"
              class="form-control"
              name="influence"
              id="name-influence"
              data-cy="influence"
              :class="{ valid: !v$.influence.$invalid, invalid: v$.influence.$invalid }"
              v-model="v$.influence.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.deptId')" for="name-deptId"></label>
            <input
              type="text"
              class="form-control"
              name="deptId"
              id="name-deptId"
              data-cy="deptId"
              :class="{ valid: !v$.deptId.$invalid, invalid: v$.deptId.$invalid }"
              v-model="v$.deptId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.department')" for="name-department"></label>
            <input
              type="text"
              class="form-control"
              name="department"
              id="name-department"
              data-cy="department"
              :class="{ valid: !v$.department.$invalid, invalid: v$.department.$invalid }"
              v-model="v$.department.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.contactYn')" for="name-contactYn"></label>
            <input
              type="text"
              class="form-control"
              name="contactYn"
              id="name-contactYn"
              data-cy="contactYn"
              :class="{ valid: !v$.contactYn.$invalid, invalid: v$.contactYn.$invalid }"
              v-model="v$.contactYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.accountType')" for="name-accountType"></label>
            <input
              type="text"
              class="form-control"
              name="accountType"
              id="name-accountType"
              data-cy="accountType"
              :class="{ valid: !v$.accountType.$invalid, invalid: v$.accountType.$invalid }"
              v-model="v$.accountType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.downloadResort')"
              for="name-downloadResort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="downloadResort"
              id="name-downloadResort"
              data-cy="downloadResort"
              :class="{ valid: !v$.downloadResort.$invalid, invalid: v$.downloadResort.$invalid }"
              v-model="v$.downloadResort.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.downloadSrep')" for="name-downloadSrep"></label>
            <input
              type="number"
              class="form-control"
              name="downloadSrep"
              id="name-downloadSrep"
              data-cy="downloadSrep"
              :class="{ valid: !v$.downloadSrep.$invalid, invalid: v$.downloadSrep.$invalid }"
              v-model.number="v$.downloadSrep.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.downloadDate')" for="name-downloadDate"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-downloadDate"
                  v-model="v$.downloadDate.$model"
                  name="downloadDate"
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
                id="name-downloadDate"
                data-cy="downloadDate"
                type="text"
                class="form-control"
                name="downloadDate"
                :class="{ valid: !v$.downloadDate.$invalid, invalid: v$.downloadDate.$invalid }"
                v-model="v$.downloadDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.uploadDate')" for="name-uploadDate"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-uploadDate"
                  v-model="v$.uploadDate.$model"
                  name="uploadDate"
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
                id="name-uploadDate"
                data-cy="uploadDate"
                type="text"
                class="form-control"
                name="uploadDate"
                :class="{ valid: !v$.uploadDate.$invalid, invalid: v$.uploadDate.$invalid }"
                v-model="v$.uploadDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.laptopChange')" for="name-laptopChange"></label>
            <input
              type="number"
              class="form-control"
              name="laptopChange"
              id="name-laptopChange"
              data-cy="laptopChange"
              :class="{ valid: !v$.laptopChange.$invalid, invalid: v$.laptopChange.$invalid }"
              v-model.number="v$.laptopChange.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.crsNameid')" for="name-crsNameid"></label>
            <input
              type="number"
              class="form-control"
              name="crsNameid"
              id="name-crsNameid"
              data-cy="crsNameid"
              :class="{ valid: !v$.crsNameid.$invalid, invalid: v$.crsNameid.$invalid }"
              v-model.number="v$.crsNameid.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.commPayCentral')"
              for="name-commPayCentral"
            ></label>
            <input
              type="text"
              class="form-control"
              name="commPayCentral"
              id="name-commPayCentral"
              data-cy="commPayCentral"
              :class="{ valid: !v$.commPayCentral.$invalid, invalid: v$.commPayCentral.$invalid }"
              v-model="v$.commPayCentral.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.ccProfileYn')" for="name-ccProfileYn"></label>
            <input
              type="text"
              class="form-control"
              name="ccProfileYn"
              id="name-ccProfileYn"
              data-cy="ccProfileYn"
              :class="{ valid: !v$.ccProfileYn.$invalid, invalid: v$.ccProfileYn.$invalid }"
              v-model="v$.ccProfileYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.gender')" for="name-gender"></label>
            <input
              type="text"
              class="form-control"
              name="gender"
              id="name-gender"
              data-cy="gender"
              :class="{ valid: !v$.gender.$invalid, invalid: v$.gender.$invalid }"
              v-model="v$.gender.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.birthPlace')" for="name-birthPlace"></label>
            <input
              type="text"
              class="form-control"
              name="birthPlace"
              id="name-birthPlace"
              data-cy="birthPlace"
              :class="{ valid: !v$.birthPlace.$invalid, invalid: v$.birthPlace.$invalid }"
              v-model="v$.birthPlace.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.birthCountry')" for="name-birthCountry"></label>
            <input
              type="text"
              class="form-control"
              name="birthCountry"
              id="name-birthCountry"
              data-cy="birthCountry"
              :class="{ valid: !v$.birthCountry.$invalid, invalid: v$.birthCountry.$invalid }"
              v-model="v$.birthCountry.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.profession')" for="name-profession"></label>
            <input
              type="text"
              class="form-control"
              name="profession"
              id="name-profession"
              data-cy="profession"
              :class="{ valid: !v$.profession.$invalid, invalid: v$.profession.$invalid }"
              v-model="v$.profession.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.idType')" for="name-idType"></label>
            <input
              type="text"
              class="form-control"
              name="idType"
              id="name-idType"
              data-cy="idType"
              :class="{ valid: !v$.idType.$invalid, invalid: v$.idType.$invalid }"
              v-model="v$.idType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.idNumber')" for="name-idNumber"></label>
            <input
              type="text"
              class="form-control"
              name="idNumber"
              id="name-idNumber"
              data-cy="idNumber"
              :class="{ valid: !v$.idNumber.$invalid, invalid: v$.idNumber.$invalid }"
              v-model="v$.idNumber.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.idDate')" for="name-idDate"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-idDate"
                  v-model="v$.idDate.$model"
                  name="idDate"
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
                id="name-idDate"
                data-cy="idDate"
                type="text"
                class="form-control"
                name="idDate"
                :class="{ valid: !v$.idDate.$invalid, invalid: v$.idDate.$invalid }"
                v-model="v$.idDate.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.idPlace')" for="name-idPlace"></label>
            <input
              type="text"
              class="form-control"
              name="idPlace"
              id="name-idPlace"
              data-cy="idPlace"
              :class="{ valid: !v$.idPlace.$invalid, invalid: v$.idPlace.$invalid }"
              v-model="v$.idPlace.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.idCountry')" for="name-idCountry"></label>
            <input
              type="text"
              class="form-control"
              name="idCountry"
              id="name-idCountry"
              data-cy="idCountry"
              :class="{ valid: !v$.idCountry.$invalid, invalid: v$.idCountry.$invalid }"
              v-model="v$.idCountry.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc01')" for="name-udfc01"></label>
            <input
              type="text"
              class="form-control"
              name="udfc01"
              id="name-udfc01"
              data-cy="udfc01"
              :class="{ valid: !v$.udfc01.$invalid, invalid: v$.udfc01.$invalid }"
              v-model="v$.udfc01.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc02')" for="name-udfc02"></label>
            <input
              type="text"
              class="form-control"
              name="udfc02"
              id="name-udfc02"
              data-cy="udfc02"
              :class="{ valid: !v$.udfc02.$invalid, invalid: v$.udfc02.$invalid }"
              v-model="v$.udfc02.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc03')" for="name-udfc03"></label>
            <input
              type="text"
              class="form-control"
              name="udfc03"
              id="name-udfc03"
              data-cy="udfc03"
              :class="{ valid: !v$.udfc03.$invalid, invalid: v$.udfc03.$invalid }"
              v-model="v$.udfc03.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc04')" for="name-udfc04"></label>
            <input
              type="text"
              class="form-control"
              name="udfc04"
              id="name-udfc04"
              data-cy="udfc04"
              :class="{ valid: !v$.udfc04.$invalid, invalid: v$.udfc04.$invalid }"
              v-model="v$.udfc04.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc05')" for="name-udfc05"></label>
            <input
              type="text"
              class="form-control"
              name="udfc05"
              id="name-udfc05"
              data-cy="udfc05"
              :class="{ valid: !v$.udfc05.$invalid, invalid: v$.udfc05.$invalid }"
              v-model="v$.udfc05.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc06')" for="name-udfc06"></label>
            <input
              type="text"
              class="form-control"
              name="udfc06"
              id="name-udfc06"
              data-cy="udfc06"
              :class="{ valid: !v$.udfc06.$invalid, invalid: v$.udfc06.$invalid }"
              v-model="v$.udfc06.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc07')" for="name-udfc07"></label>
            <input
              type="text"
              class="form-control"
              name="udfc07"
              id="name-udfc07"
              data-cy="udfc07"
              :class="{ valid: !v$.udfc07.$invalid, invalid: v$.udfc07.$invalid }"
              v-model="v$.udfc07.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc08')" for="name-udfc08"></label>
            <input
              type="text"
              class="form-control"
              name="udfc08"
              id="name-udfc08"
              data-cy="udfc08"
              :class="{ valid: !v$.udfc08.$invalid, invalid: v$.udfc08.$invalid }"
              v-model="v$.udfc08.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc09')" for="name-udfc09"></label>
            <input
              type="text"
              class="form-control"
              name="udfc09"
              id="name-udfc09"
              data-cy="udfc09"
              :class="{ valid: !v$.udfc09.$invalid, invalid: v$.udfc09.$invalid }"
              v-model="v$.udfc09.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc10')" for="name-udfc10"></label>
            <input
              type="text"
              class="form-control"
              name="udfc10"
              id="name-udfc10"
              data-cy="udfc10"
              :class="{ valid: !v$.udfc10.$invalid, invalid: v$.udfc10.$invalid }"
              v-model="v$.udfc10.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc11')" for="name-udfc11"></label>
            <input
              type="text"
              class="form-control"
              name="udfc11"
              id="name-udfc11"
              data-cy="udfc11"
              :class="{ valid: !v$.udfc11.$invalid, invalid: v$.udfc11.$invalid }"
              v-model="v$.udfc11.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc12')" for="name-udfc12"></label>
            <input
              type="text"
              class="form-control"
              name="udfc12"
              id="name-udfc12"
              data-cy="udfc12"
              :class="{ valid: !v$.udfc12.$invalid, invalid: v$.udfc12.$invalid }"
              v-model="v$.udfc12.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc13')" for="name-udfc13"></label>
            <input
              type="text"
              class="form-control"
              name="udfc13"
              id="name-udfc13"
              data-cy="udfc13"
              :class="{ valid: !v$.udfc13.$invalid, invalid: v$.udfc13.$invalid }"
              v-model="v$.udfc13.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc14')" for="name-udfc14"></label>
            <input
              type="text"
              class="form-control"
              name="udfc14"
              id="name-udfc14"
              data-cy="udfc14"
              :class="{ valid: !v$.udfc14.$invalid, invalid: v$.udfc14.$invalid }"
              v-model="v$.udfc14.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc15')" for="name-udfc15"></label>
            <input
              type="text"
              class="form-control"
              name="udfc15"
              id="name-udfc15"
              data-cy="udfc15"
              :class="{ valid: !v$.udfc15.$invalid, invalid: v$.udfc15.$invalid }"
              v-model="v$.udfc15.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc16')" for="name-udfc16"></label>
            <input
              type="text"
              class="form-control"
              name="udfc16"
              id="name-udfc16"
              data-cy="udfc16"
              :class="{ valid: !v$.udfc16.$invalid, invalid: v$.udfc16.$invalid }"
              v-model="v$.udfc16.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc17')" for="name-udfc17"></label>
            <input
              type="text"
              class="form-control"
              name="udfc17"
              id="name-udfc17"
              data-cy="udfc17"
              :class="{ valid: !v$.udfc17.$invalid, invalid: v$.udfc17.$invalid }"
              v-model="v$.udfc17.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc18')" for="name-udfc18"></label>
            <input
              type="text"
              class="form-control"
              name="udfc18"
              id="name-udfc18"
              data-cy="udfc18"
              :class="{ valid: !v$.udfc18.$invalid, invalid: v$.udfc18.$invalid }"
              v-model="v$.udfc18.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc19')" for="name-udfc19"></label>
            <input
              type="text"
              class="form-control"
              name="udfc19"
              id="name-udfc19"
              data-cy="udfc19"
              :class="{ valid: !v$.udfc19.$invalid, invalid: v$.udfc19.$invalid }"
              v-model="v$.udfc19.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc20')" for="name-udfc20"></label>
            <input
              type="text"
              class="form-control"
              name="udfc20"
              id="name-udfc20"
              data-cy="udfc20"
              :class="{ valid: !v$.udfc20.$invalid, invalid: v$.udfc20.$invalid }"
              v-model="v$.udfc20.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc21')" for="name-udfc21"></label>
            <input
              type="text"
              class="form-control"
              name="udfc21"
              id="name-udfc21"
              data-cy="udfc21"
              :class="{ valid: !v$.udfc21.$invalid, invalid: v$.udfc21.$invalid }"
              v-model="v$.udfc21.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc22')" for="name-udfc22"></label>
            <input
              type="text"
              class="form-control"
              name="udfc22"
              id="name-udfc22"
              data-cy="udfc22"
              :class="{ valid: !v$.udfc22.$invalid, invalid: v$.udfc22.$invalid }"
              v-model="v$.udfc22.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc23')" for="name-udfc23"></label>
            <input
              type="text"
              class="form-control"
              name="udfc23"
              id="name-udfc23"
              data-cy="udfc23"
              :class="{ valid: !v$.udfc23.$invalid, invalid: v$.udfc23.$invalid }"
              v-model="v$.udfc23.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc24')" for="name-udfc24"></label>
            <input
              type="text"
              class="form-control"
              name="udfc24"
              id="name-udfc24"
              data-cy="udfc24"
              :class="{ valid: !v$.udfc24.$invalid, invalid: v$.udfc24.$invalid }"
              v-model="v$.udfc24.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc25')" for="name-udfc25"></label>
            <input
              type="text"
              class="form-control"
              name="udfc25"
              id="name-udfc25"
              data-cy="udfc25"
              :class="{ valid: !v$.udfc25.$invalid, invalid: v$.udfc25.$invalid }"
              v-model="v$.udfc25.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc26')" for="name-udfc26"></label>
            <input
              type="text"
              class="form-control"
              name="udfc26"
              id="name-udfc26"
              data-cy="udfc26"
              :class="{ valid: !v$.udfc26.$invalid, invalid: v$.udfc26.$invalid }"
              v-model="v$.udfc26.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc27')" for="name-udfc27"></label>
            <input
              type="text"
              class="form-control"
              name="udfc27"
              id="name-udfc27"
              data-cy="udfc27"
              :class="{ valid: !v$.udfc27.$invalid, invalid: v$.udfc27.$invalid }"
              v-model="v$.udfc27.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc28')" for="name-udfc28"></label>
            <input
              type="text"
              class="form-control"
              name="udfc28"
              id="name-udfc28"
              data-cy="udfc28"
              :class="{ valid: !v$.udfc28.$invalid, invalid: v$.udfc28.$invalid }"
              v-model="v$.udfc28.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc29')" for="name-udfc29"></label>
            <input
              type="text"
              class="form-control"
              name="udfc29"
              id="name-udfc29"
              data-cy="udfc29"
              :class="{ valid: !v$.udfc29.$invalid, invalid: v$.udfc29.$invalid }"
              v-model="v$.udfc29.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc30')" for="name-udfc30"></label>
            <input
              type="text"
              class="form-control"
              name="udfc30"
              id="name-udfc30"
              data-cy="udfc30"
              :class="{ valid: !v$.udfc30.$invalid, invalid: v$.udfc30.$invalid }"
              v-model="v$.udfc30.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc31')" for="name-udfc31"></label>
            <input
              type="text"
              class="form-control"
              name="udfc31"
              id="name-udfc31"
              data-cy="udfc31"
              :class="{ valid: !v$.udfc31.$invalid, invalid: v$.udfc31.$invalid }"
              v-model="v$.udfc31.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc32')" for="name-udfc32"></label>
            <input
              type="text"
              class="form-control"
              name="udfc32"
              id="name-udfc32"
              data-cy="udfc32"
              :class="{ valid: !v$.udfc32.$invalid, invalid: v$.udfc32.$invalid }"
              v-model="v$.udfc32.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc33')" for="name-udfc33"></label>
            <input
              type="text"
              class="form-control"
              name="udfc33"
              id="name-udfc33"
              data-cy="udfc33"
              :class="{ valid: !v$.udfc33.$invalid, invalid: v$.udfc33.$invalid }"
              v-model="v$.udfc33.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc34')" for="name-udfc34"></label>
            <input
              type="text"
              class="form-control"
              name="udfc34"
              id="name-udfc34"
              data-cy="udfc34"
              :class="{ valid: !v$.udfc34.$invalid, invalid: v$.udfc34.$invalid }"
              v-model="v$.udfc34.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc35')" for="name-udfc35"></label>
            <input
              type="text"
              class="form-control"
              name="udfc35"
              id="name-udfc35"
              data-cy="udfc35"
              :class="{ valid: !v$.udfc35.$invalid, invalid: v$.udfc35.$invalid }"
              v-model="v$.udfc35.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc36')" for="name-udfc36"></label>
            <input
              type="text"
              class="form-control"
              name="udfc36"
              id="name-udfc36"
              data-cy="udfc36"
              :class="{ valid: !v$.udfc36.$invalid, invalid: v$.udfc36.$invalid }"
              v-model="v$.udfc36.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc37')" for="name-udfc37"></label>
            <input
              type="text"
              class="form-control"
              name="udfc37"
              id="name-udfc37"
              data-cy="udfc37"
              :class="{ valid: !v$.udfc37.$invalid, invalid: v$.udfc37.$invalid }"
              v-model="v$.udfc37.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc38')" for="name-udfc38"></label>
            <input
              type="text"
              class="form-control"
              name="udfc38"
              id="name-udfc38"
              data-cy="udfc38"
              :class="{ valid: !v$.udfc38.$invalid, invalid: v$.udfc38.$invalid }"
              v-model="v$.udfc38.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc39')" for="name-udfc39"></label>
            <input
              type="text"
              class="form-control"
              name="udfc39"
              id="name-udfc39"
              data-cy="udfc39"
              :class="{ valid: !v$.udfc39.$invalid, invalid: v$.udfc39.$invalid }"
              v-model="v$.udfc39.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfc40')" for="name-udfc40"></label>
            <input
              type="text"
              class="form-control"
              name="udfc40"
              id="name-udfc40"
              data-cy="udfc40"
              :class="{ valid: !v$.udfc40.$invalid, invalid: v$.udfc40.$invalid }"
              v-model="v$.udfc40.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn01')" for="name-udfn01"></label>
            <input
              type="number"
              class="form-control"
              name="udfn01"
              id="name-udfn01"
              data-cy="udfn01"
              :class="{ valid: !v$.udfn01.$invalid, invalid: v$.udfn01.$invalid }"
              v-model.number="v$.udfn01.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn02')" for="name-udfn02"></label>
            <input
              type="number"
              class="form-control"
              name="udfn02"
              id="name-udfn02"
              data-cy="udfn02"
              :class="{ valid: !v$.udfn02.$invalid, invalid: v$.udfn02.$invalid }"
              v-model.number="v$.udfn02.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn03')" for="name-udfn03"></label>
            <input
              type="number"
              class="form-control"
              name="udfn03"
              id="name-udfn03"
              data-cy="udfn03"
              :class="{ valid: !v$.udfn03.$invalid, invalid: v$.udfn03.$invalid }"
              v-model.number="v$.udfn03.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn04')" for="name-udfn04"></label>
            <input
              type="number"
              class="form-control"
              name="udfn04"
              id="name-udfn04"
              data-cy="udfn04"
              :class="{ valid: !v$.udfn04.$invalid, invalid: v$.udfn04.$invalid }"
              v-model.number="v$.udfn04.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn05')" for="name-udfn05"></label>
            <input
              type="number"
              class="form-control"
              name="udfn05"
              id="name-udfn05"
              data-cy="udfn05"
              :class="{ valid: !v$.udfn05.$invalid, invalid: v$.udfn05.$invalid }"
              v-model.number="v$.udfn05.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn06')" for="name-udfn06"></label>
            <input
              type="number"
              class="form-control"
              name="udfn06"
              id="name-udfn06"
              data-cy="udfn06"
              :class="{ valid: !v$.udfn06.$invalid, invalid: v$.udfn06.$invalid }"
              v-model.number="v$.udfn06.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn07')" for="name-udfn07"></label>
            <input
              type="number"
              class="form-control"
              name="udfn07"
              id="name-udfn07"
              data-cy="udfn07"
              :class="{ valid: !v$.udfn07.$invalid, invalid: v$.udfn07.$invalid }"
              v-model.number="v$.udfn07.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn08')" for="name-udfn08"></label>
            <input
              type="number"
              class="form-control"
              name="udfn08"
              id="name-udfn08"
              data-cy="udfn08"
              :class="{ valid: !v$.udfn08.$invalid, invalid: v$.udfn08.$invalid }"
              v-model.number="v$.udfn08.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn09')" for="name-udfn09"></label>
            <input
              type="number"
              class="form-control"
              name="udfn09"
              id="name-udfn09"
              data-cy="udfn09"
              :class="{ valid: !v$.udfn09.$invalid, invalid: v$.udfn09.$invalid }"
              v-model.number="v$.udfn09.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn10')" for="name-udfn10"></label>
            <input
              type="number"
              class="form-control"
              name="udfn10"
              id="name-udfn10"
              data-cy="udfn10"
              :class="{ valid: !v$.udfn10.$invalid, invalid: v$.udfn10.$invalid }"
              v-model.number="v$.udfn10.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn11')" for="name-udfn11"></label>
            <input
              type="number"
              class="form-control"
              name="udfn11"
              id="name-udfn11"
              data-cy="udfn11"
              :class="{ valid: !v$.udfn11.$invalid, invalid: v$.udfn11.$invalid }"
              v-model.number="v$.udfn11.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn12')" for="name-udfn12"></label>
            <input
              type="number"
              class="form-control"
              name="udfn12"
              id="name-udfn12"
              data-cy="udfn12"
              :class="{ valid: !v$.udfn12.$invalid, invalid: v$.udfn12.$invalid }"
              v-model.number="v$.udfn12.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn13')" for="name-udfn13"></label>
            <input
              type="number"
              class="form-control"
              name="udfn13"
              id="name-udfn13"
              data-cy="udfn13"
              :class="{ valid: !v$.udfn13.$invalid, invalid: v$.udfn13.$invalid }"
              v-model.number="v$.udfn13.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn14')" for="name-udfn14"></label>
            <input
              type="number"
              class="form-control"
              name="udfn14"
              id="name-udfn14"
              data-cy="udfn14"
              :class="{ valid: !v$.udfn14.$invalid, invalid: v$.udfn14.$invalid }"
              v-model.number="v$.udfn14.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn15')" for="name-udfn15"></label>
            <input
              type="number"
              class="form-control"
              name="udfn15"
              id="name-udfn15"
              data-cy="udfn15"
              :class="{ valid: !v$.udfn15.$invalid, invalid: v$.udfn15.$invalid }"
              v-model.number="v$.udfn15.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn16')" for="name-udfn16"></label>
            <input
              type="number"
              class="form-control"
              name="udfn16"
              id="name-udfn16"
              data-cy="udfn16"
              :class="{ valid: !v$.udfn16.$invalid, invalid: v$.udfn16.$invalid }"
              v-model.number="v$.udfn16.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn17')" for="name-udfn17"></label>
            <input
              type="number"
              class="form-control"
              name="udfn17"
              id="name-udfn17"
              data-cy="udfn17"
              :class="{ valid: !v$.udfn17.$invalid, invalid: v$.udfn17.$invalid }"
              v-model.number="v$.udfn17.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn18')" for="name-udfn18"></label>
            <input
              type="number"
              class="form-control"
              name="udfn18"
              id="name-udfn18"
              data-cy="udfn18"
              :class="{ valid: !v$.udfn18.$invalid, invalid: v$.udfn18.$invalid }"
              v-model.number="v$.udfn18.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn19')" for="name-udfn19"></label>
            <input
              type="number"
              class="form-control"
              name="udfn19"
              id="name-udfn19"
              data-cy="udfn19"
              :class="{ valid: !v$.udfn19.$invalid, invalid: v$.udfn19.$invalid }"
              v-model.number="v$.udfn19.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn20')" for="name-udfn20"></label>
            <input
              type="number"
              class="form-control"
              name="udfn20"
              id="name-udfn20"
              data-cy="udfn20"
              :class="{ valid: !v$.udfn20.$invalid, invalid: v$.udfn20.$invalid }"
              v-model.number="v$.udfn20.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn21')" for="name-udfn21"></label>
            <input
              type="number"
              class="form-control"
              name="udfn21"
              id="name-udfn21"
              data-cy="udfn21"
              :class="{ valid: !v$.udfn21.$invalid, invalid: v$.udfn21.$invalid }"
              v-model.number="v$.udfn21.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn22')" for="name-udfn22"></label>
            <input
              type="number"
              class="form-control"
              name="udfn22"
              id="name-udfn22"
              data-cy="udfn22"
              :class="{ valid: !v$.udfn22.$invalid, invalid: v$.udfn22.$invalid }"
              v-model.number="v$.udfn22.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn23')" for="name-udfn23"></label>
            <input
              type="number"
              class="form-control"
              name="udfn23"
              id="name-udfn23"
              data-cy="udfn23"
              :class="{ valid: !v$.udfn23.$invalid, invalid: v$.udfn23.$invalid }"
              v-model.number="v$.udfn23.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn24')" for="name-udfn24"></label>
            <input
              type="number"
              class="form-control"
              name="udfn24"
              id="name-udfn24"
              data-cy="udfn24"
              :class="{ valid: !v$.udfn24.$invalid, invalid: v$.udfn24.$invalid }"
              v-model.number="v$.udfn24.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn25')" for="name-udfn25"></label>
            <input
              type="number"
              class="form-control"
              name="udfn25"
              id="name-udfn25"
              data-cy="udfn25"
              :class="{ valid: !v$.udfn25.$invalid, invalid: v$.udfn25.$invalid }"
              v-model.number="v$.udfn25.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn26')" for="name-udfn26"></label>
            <input
              type="number"
              class="form-control"
              name="udfn26"
              id="name-udfn26"
              data-cy="udfn26"
              :class="{ valid: !v$.udfn26.$invalid, invalid: v$.udfn26.$invalid }"
              v-model.number="v$.udfn26.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn27')" for="name-udfn27"></label>
            <input
              type="number"
              class="form-control"
              name="udfn27"
              id="name-udfn27"
              data-cy="udfn27"
              :class="{ valid: !v$.udfn27.$invalid, invalid: v$.udfn27.$invalid }"
              v-model.number="v$.udfn27.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn28')" for="name-udfn28"></label>
            <input
              type="number"
              class="form-control"
              name="udfn28"
              id="name-udfn28"
              data-cy="udfn28"
              :class="{ valid: !v$.udfn28.$invalid, invalid: v$.udfn28.$invalid }"
              v-model.number="v$.udfn28.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn29')" for="name-udfn29"></label>
            <input
              type="number"
              class="form-control"
              name="udfn29"
              id="name-udfn29"
              data-cy="udfn29"
              :class="{ valid: !v$.udfn29.$invalid, invalid: v$.udfn29.$invalid }"
              v-model.number="v$.udfn29.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn30')" for="name-udfn30"></label>
            <input
              type="number"
              class="form-control"
              name="udfn30"
              id="name-udfn30"
              data-cy="udfn30"
              :class="{ valid: !v$.udfn30.$invalid, invalid: v$.udfn30.$invalid }"
              v-model.number="v$.udfn30.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn31')" for="name-udfn31"></label>
            <input
              type="number"
              class="form-control"
              name="udfn31"
              id="name-udfn31"
              data-cy="udfn31"
              :class="{ valid: !v$.udfn31.$invalid, invalid: v$.udfn31.$invalid }"
              v-model.number="v$.udfn31.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn32')" for="name-udfn32"></label>
            <input
              type="number"
              class="form-control"
              name="udfn32"
              id="name-udfn32"
              data-cy="udfn32"
              :class="{ valid: !v$.udfn32.$invalid, invalid: v$.udfn32.$invalid }"
              v-model.number="v$.udfn32.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn33')" for="name-udfn33"></label>
            <input
              type="number"
              class="form-control"
              name="udfn33"
              id="name-udfn33"
              data-cy="udfn33"
              :class="{ valid: !v$.udfn33.$invalid, invalid: v$.udfn33.$invalid }"
              v-model.number="v$.udfn33.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn34')" for="name-udfn34"></label>
            <input
              type="number"
              class="form-control"
              name="udfn34"
              id="name-udfn34"
              data-cy="udfn34"
              :class="{ valid: !v$.udfn34.$invalid, invalid: v$.udfn34.$invalid }"
              v-model.number="v$.udfn34.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn35')" for="name-udfn35"></label>
            <input
              type="number"
              class="form-control"
              name="udfn35"
              id="name-udfn35"
              data-cy="udfn35"
              :class="{ valid: !v$.udfn35.$invalid, invalid: v$.udfn35.$invalid }"
              v-model.number="v$.udfn35.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn36')" for="name-udfn36"></label>
            <input
              type="number"
              class="form-control"
              name="udfn36"
              id="name-udfn36"
              data-cy="udfn36"
              :class="{ valid: !v$.udfn36.$invalid, invalid: v$.udfn36.$invalid }"
              v-model.number="v$.udfn36.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn37')" for="name-udfn37"></label>
            <input
              type="number"
              class="form-control"
              name="udfn37"
              id="name-udfn37"
              data-cy="udfn37"
              :class="{ valid: !v$.udfn37.$invalid, invalid: v$.udfn37.$invalid }"
              v-model.number="v$.udfn37.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn38')" for="name-udfn38"></label>
            <input
              type="number"
              class="form-control"
              name="udfn38"
              id="name-udfn38"
              data-cy="udfn38"
              :class="{ valid: !v$.udfn38.$invalid, invalid: v$.udfn38.$invalid }"
              v-model.number="v$.udfn38.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn39')" for="name-udfn39"></label>
            <input
              type="number"
              class="form-control"
              name="udfn39"
              id="name-udfn39"
              data-cy="udfn39"
              :class="{ valid: !v$.udfn39.$invalid, invalid: v$.udfn39.$invalid }"
              v-model.number="v$.udfn39.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfn40')" for="name-udfn40"></label>
            <input
              type="number"
              class="form-control"
              name="udfn40"
              id="name-udfn40"
              data-cy="udfn40"
              :class="{ valid: !v$.udfn40.$invalid, invalid: v$.udfn40.$invalid }"
              v-model.number="v$.udfn40.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd01')" for="name-udfd01"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd01"
                  v-model="v$.udfd01.$model"
                  name="udfd01"
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
                id="name-udfd01"
                data-cy="udfd01"
                type="text"
                class="form-control"
                name="udfd01"
                :class="{ valid: !v$.udfd01.$invalid, invalid: v$.udfd01.$invalid }"
                v-model="v$.udfd01.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd02')" for="name-udfd02"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd02"
                  v-model="v$.udfd02.$model"
                  name="udfd02"
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
                id="name-udfd02"
                data-cy="udfd02"
                type="text"
                class="form-control"
                name="udfd02"
                :class="{ valid: !v$.udfd02.$invalid, invalid: v$.udfd02.$invalid }"
                v-model="v$.udfd02.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd03')" for="name-udfd03"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd03"
                  v-model="v$.udfd03.$model"
                  name="udfd03"
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
                id="name-udfd03"
                data-cy="udfd03"
                type="text"
                class="form-control"
                name="udfd03"
                :class="{ valid: !v$.udfd03.$invalid, invalid: v$.udfd03.$invalid }"
                v-model="v$.udfd03.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd04')" for="name-udfd04"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd04"
                  v-model="v$.udfd04.$model"
                  name="udfd04"
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
                id="name-udfd04"
                data-cy="udfd04"
                type="text"
                class="form-control"
                name="udfd04"
                :class="{ valid: !v$.udfd04.$invalid, invalid: v$.udfd04.$invalid }"
                v-model="v$.udfd04.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd05')" for="name-udfd05"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd05"
                  v-model="v$.udfd05.$model"
                  name="udfd05"
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
                id="name-udfd05"
                data-cy="udfd05"
                type="text"
                class="form-control"
                name="udfd05"
                :class="{ valid: !v$.udfd05.$invalid, invalid: v$.udfd05.$invalid }"
                v-model="v$.udfd05.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd06')" for="name-udfd06"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd06"
                  v-model="v$.udfd06.$model"
                  name="udfd06"
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
                id="name-udfd06"
                data-cy="udfd06"
                type="text"
                class="form-control"
                name="udfd06"
                :class="{ valid: !v$.udfd06.$invalid, invalid: v$.udfd06.$invalid }"
                v-model="v$.udfd06.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd07')" for="name-udfd07"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd07"
                  v-model="v$.udfd07.$model"
                  name="udfd07"
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
                id="name-udfd07"
                data-cy="udfd07"
                type="text"
                class="form-control"
                name="udfd07"
                :class="{ valid: !v$.udfd07.$invalid, invalid: v$.udfd07.$invalid }"
                v-model="v$.udfd07.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd08')" for="name-udfd08"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd08"
                  v-model="v$.udfd08.$model"
                  name="udfd08"
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
                id="name-udfd08"
                data-cy="udfd08"
                type="text"
                class="form-control"
                name="udfd08"
                :class="{ valid: !v$.udfd08.$invalid, invalid: v$.udfd08.$invalid }"
                v-model="v$.udfd08.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd09')" for="name-udfd09"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd09"
                  v-model="v$.udfd09.$model"
                  name="udfd09"
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
                id="name-udfd09"
                data-cy="udfd09"
                type="text"
                class="form-control"
                name="udfd09"
                :class="{ valid: !v$.udfd09.$invalid, invalid: v$.udfd09.$invalid }"
                v-model="v$.udfd09.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd10')" for="name-udfd10"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd10"
                  v-model="v$.udfd10.$model"
                  name="udfd10"
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
                id="name-udfd10"
                data-cy="udfd10"
                type="text"
                class="form-control"
                name="udfd10"
                :class="{ valid: !v$.udfd10.$invalid, invalid: v$.udfd10.$invalid }"
                v-model="v$.udfd10.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd11')" for="name-udfd11"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd11"
                  v-model="v$.udfd11.$model"
                  name="udfd11"
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
                id="name-udfd11"
                data-cy="udfd11"
                type="text"
                class="form-control"
                name="udfd11"
                :class="{ valid: !v$.udfd11.$invalid, invalid: v$.udfd11.$invalid }"
                v-model="v$.udfd11.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd12')" for="name-udfd12"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd12"
                  v-model="v$.udfd12.$model"
                  name="udfd12"
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
                id="name-udfd12"
                data-cy="udfd12"
                type="text"
                class="form-control"
                name="udfd12"
                :class="{ valid: !v$.udfd12.$invalid, invalid: v$.udfd12.$invalid }"
                v-model="v$.udfd12.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd13')" for="name-udfd13"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd13"
                  v-model="v$.udfd13.$model"
                  name="udfd13"
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
                id="name-udfd13"
                data-cy="udfd13"
                type="text"
                class="form-control"
                name="udfd13"
                :class="{ valid: !v$.udfd13.$invalid, invalid: v$.udfd13.$invalid }"
                v-model="v$.udfd13.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd14')" for="name-udfd14"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd14"
                  v-model="v$.udfd14.$model"
                  name="udfd14"
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
                id="name-udfd14"
                data-cy="udfd14"
                type="text"
                class="form-control"
                name="udfd14"
                :class="{ valid: !v$.udfd14.$invalid, invalid: v$.udfd14.$invalid }"
                v-model="v$.udfd14.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd15')" for="name-udfd15"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd15"
                  v-model="v$.udfd15.$model"
                  name="udfd15"
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
                id="name-udfd15"
                data-cy="udfd15"
                type="text"
                class="form-control"
                name="udfd15"
                :class="{ valid: !v$.udfd15.$invalid, invalid: v$.udfd15.$invalid }"
                v-model="v$.udfd15.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd16')" for="name-udfd16"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd16"
                  v-model="v$.udfd16.$model"
                  name="udfd16"
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
                id="name-udfd16"
                data-cy="udfd16"
                type="text"
                class="form-control"
                name="udfd16"
                :class="{ valid: !v$.udfd16.$invalid, invalid: v$.udfd16.$invalid }"
                v-model="v$.udfd16.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd17')" for="name-udfd17"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd17"
                  v-model="v$.udfd17.$model"
                  name="udfd17"
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
                id="name-udfd17"
                data-cy="udfd17"
                type="text"
                class="form-control"
                name="udfd17"
                :class="{ valid: !v$.udfd17.$invalid, invalid: v$.udfd17.$invalid }"
                v-model="v$.udfd17.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd18')" for="name-udfd18"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd18"
                  v-model="v$.udfd18.$model"
                  name="udfd18"
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
                id="name-udfd18"
                data-cy="udfd18"
                type="text"
                class="form-control"
                name="udfd18"
                :class="{ valid: !v$.udfd18.$invalid, invalid: v$.udfd18.$invalid }"
                v-model="v$.udfd18.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd19')" for="name-udfd19"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd19"
                  v-model="v$.udfd19.$model"
                  name="udfd19"
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
                id="name-udfd19"
                data-cy="udfd19"
                type="text"
                class="form-control"
                name="udfd19"
                :class="{ valid: !v$.udfd19.$invalid, invalid: v$.udfd19.$invalid }"
                v-model="v$.udfd19.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.udfd20')" for="name-udfd20"></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-udfd20"
                  v-model="v$.udfd20.$model"
                  name="udfd20"
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
                id="name-udfd20"
                data-cy="udfd20"
                type="text"
                class="form-control"
                name="udfd20"
                :class="{ valid: !v$.udfd20.$invalid, invalid: v$.udfd20.$invalid }"
                v-model="v$.udfd20.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.paymentDueDays')"
              for="name-paymentDueDays"
            ></label>
            <input
              type="number"
              class="form-control"
              name="paymentDueDays"
              id="name-paymentDueDays"
              data-cy="paymentDueDays"
              :class="{ valid: !v$.paymentDueDays.$invalid, invalid: v$.paymentDueDays.$invalid }"
              v-model.number="v$.paymentDueDays.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.suffix')" for="name-suffix"></label>
            <input
              type="text"
              class="form-control"
              name="suffix"
              id="name-suffix"
              data-cy="suffix"
              :class="{ valid: !v$.suffix.$invalid, invalid: v$.suffix.$invalid }"
              v-model="v$.suffix.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.externalId')" for="name-externalId"></label>
            <input
              type="text"
              class="form-control"
              name="externalId"
              id="name-externalId"
              data-cy="externalId"
              :class="{ valid: !v$.externalId.$invalid, invalid: v$.externalId.$invalid }"
              v-model="v$.externalId.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.guestPrivYn')" for="name-guestPrivYn"></label>
            <input
              type="text"
              class="form-control"
              name="guestPrivYn"
              id="name-guestPrivYn"
              data-cy="guestPrivYn"
              :class="{ valid: !v$.guestPrivYn.$invalid, invalid: v$.guestPrivYn.$invalid }"
              v-model="v$.guestPrivYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.emailYn')" for="name-emailYn"></label>
            <input
              type="text"
              class="form-control"
              name="emailYn"
              id="name-emailYn"
              data-cy="emailYn"
              :class="{ valid: !v$.emailYn.$invalid, invalid: v$.emailYn.$invalid }"
              v-model="v$.emailYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.mailYn')" for="name-mailYn"></label>
            <input
              type="text"
              class="form-control"
              name="mailYn"
              id="name-mailYn"
              data-cy="mailYn"
              :class="{ valid: !v$.mailYn.$invalid, invalid: v$.mailYn.$invalid }"
              v-model="v$.mailYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.indexName')" for="name-indexName"></label>
            <input
              type="text"
              class="form-control"
              name="indexName"
              id="name-indexName"
              data-cy="indexName"
              :class="{ valid: !v$.indexName.$invalid, invalid: v$.indexName.$invalid }"
              v-model="v$.indexName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.xlastName')" for="name-xlastName"></label>
            <input
              type="text"
              class="form-control"
              name="xlastName"
              id="name-xlastName"
              data-cy="xlastName"
              :class="{ valid: !v$.xlastName.$invalid, invalid: v$.xlastName.$invalid }"
              v-model="v$.xlastName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.xfirstName')" for="name-xfirstName"></label>
            <input
              type="text"
              class="form-control"
              name="xfirstName"
              id="name-xfirstName"
              data-cy="xfirstName"
              :class="{ valid: !v$.xfirstName.$invalid, invalid: v$.xfirstName.$invalid }"
              v-model="v$.xfirstName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.xcompanyName')" for="name-xcompanyName"></label>
            <input
              type="text"
              class="form-control"
              name="xcompanyName"
              id="name-xcompanyName"
              data-cy="xcompanyName"
              :class="{ valid: !v$.xcompanyName.$invalid, invalid: v$.xcompanyName.$invalid }"
              v-model="v$.xcompanyName.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.xtitle')" for="name-xtitle"></label>
            <input
              type="text"
              class="form-control"
              name="xtitle"
              id="name-xtitle"
              data-cy="xtitle"
              :class="{ valid: !v$.xtitle.$invalid, invalid: v$.xtitle.$invalid }"
              v-model="v$.xtitle.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.xsalutation')" for="name-xsalutation"></label>
            <input
              type="text"
              class="form-control"
              name="xsalutation"
              id="name-xsalutation"
              data-cy="xsalutation"
              :class="{ valid: !v$.xsalutation.$invalid, invalid: v$.xsalutation.$invalid }"
              v-model="v$.xsalutation.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.sxname')" for="name-sxname"></label>
            <input
              type="text"
              class="form-control"
              name="sxname"
              id="name-sxname"
              data-cy="sxname"
              :class="{ valid: !v$.sxname.$invalid, invalid: v$.sxname.$invalid }"
              v-model="v$.sxname.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.sxfirstName')" for="name-sxfirstName"></label>
            <input
              type="text"
              class="form-control"
              name="sxfirstName"
              id="name-sxfirstName"
              data-cy="sxfirstName"
              :class="{ valid: !v$.sxfirstName.$invalid, invalid: v$.sxfirstName.$invalid }"
              v-model="v$.sxfirstName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.lastUpdatedResort')"
              for="name-lastUpdatedResort"
            ></label>
            <input
              type="text"
              class="form-control"
              name="lastUpdatedResort"
              id="name-lastUpdatedResort"
              data-cy="lastUpdatedResort"
              :class="{ valid: !v$.lastUpdatedResort.$invalid, invalid: v$.lastUpdatedResort.$invalid }"
              v-model="v$.lastUpdatedResort.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.envelopeGreeting')"
              for="name-envelopeGreeting"
            ></label>
            <input
              type="text"
              class="form-control"
              name="envelopeGreeting"
              id="name-envelopeGreeting"
              data-cy="envelopeGreeting"
              :class="{ valid: !v$.envelopeGreeting.$invalid, invalid: v$.envelopeGreeting.$invalid }"
              v-model="v$.envelopeGreeting.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.xenvelopeGreeting')"
              for="name-xenvelopeGreeting"
            ></label>
            <input
              type="text"
              class="form-control"
              name="xenvelopeGreeting"
              id="name-xenvelopeGreeting"
              data-cy="xenvelopeGreeting"
              :class="{ valid: !v$.xenvelopeGreeting.$invalid, invalid: v$.xenvelopeGreeting.$invalid }"
              v-model="v$.xenvelopeGreeting.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.directBillBatchType')"
              for="name-directBillBatchType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="directBillBatchType"
              id="name-directBillBatchType"
              data-cy="directBillBatchType"
              :class="{ valid: !v$.directBillBatchType.$invalid, invalid: v$.directBillBatchType.$invalid }"
              v-model="v$.directBillBatchType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.resortRegistered')"
              for="name-resortRegistered"
            ></label>
            <input
              type="text"
              class="form-control"
              name="resortRegistered"
              id="name-resortRegistered"
              data-cy="resortRegistered"
              :class="{ valid: !v$.resortRegistered.$invalid, invalid: v$.resortRegistered.$invalid }"
              v-model="v$.resortRegistered.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.taxOffice')" for="name-taxOffice"></label>
            <input
              type="text"
              class="form-control"
              name="taxOffice"
              id="name-taxOffice"
              data-cy="taxOffice"
              :class="{ valid: !v$.taxOffice.$invalid, invalid: v$.taxOffice.$invalid }"
              v-model="v$.taxOffice.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.taxType')" for="name-taxType"></label>
            <input
              type="text"
              class="form-control"
              name="taxType"
              id="name-taxType"
              data-cy="taxType"
              :class="{ valid: !v$.taxType.$invalid, invalid: v$.taxType.$invalid }"
              v-model="v$.taxType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.taxCategory')" for="name-taxCategory"></label>
            <input
              type="text"
              class="form-control"
              name="taxCategory"
              id="name-taxCategory"
              data-cy="taxCategory"
              :class="{ valid: !v$.taxCategory.$invalid, invalid: v$.taxCategory.$invalid }"
              v-model="v$.taxCategory.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.preferredRoomNo')"
              for="name-preferredRoomNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="preferredRoomNo"
              id="name-preferredRoomNo"
              data-cy="preferredRoomNo"
              :class="{ valid: !v$.preferredRoomNo.$invalid, invalid: v$.preferredRoomNo.$invalid }"
              v-model="v$.preferredRoomNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.phoneYn')" for="name-phoneYn"></label>
            <input
              type="text"
              class="form-control"
              name="phoneYn"
              id="name-phoneYn"
              data-cy="phoneYn"
              :class="{ valid: !v$.phoneYn.$invalid, invalid: v$.phoneYn.$invalid }"
              v-model="v$.phoneYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.smsYn')" for="name-smsYn"></label>
            <input
              type="text"
              class="form-control"
              name="smsYn"
              id="name-smsYn"
              data-cy="smsYn"
              :class="{ valid: !v$.smsYn.$invalid, invalid: v$.smsYn.$invalid }"
              v-model="v$.smsYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.isProtected')" for="name-isProtected"></label>
            <input
              type="text"
              class="form-control"
              name="isProtected"
              id="name-isProtected"
              data-cy="isProtected"
              :class="{ valid: !v$.isProtected.$invalid, invalid: v$.isProtected.$invalid }"
              v-model="v$.isProtected.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.xlanguage')" for="name-xlanguage"></label>
            <input
              type="text"
              class="form-control"
              name="xlanguage"
              id="name-xlanguage"
              data-cy="xlanguage"
              :class="{ valid: !v$.xlanguage.$invalid, invalid: v$.xlanguage.$invalid }"
              v-model="v$.xlanguage.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.marketResearchYn')"
              for="name-marketResearchYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="marketResearchYn"
              id="name-marketResearchYn"
              data-cy="marketResearchYn"
              :class="{ valid: !v$.marketResearchYn.$invalid, invalid: v$.marketResearchYn.$invalid }"
              v-model="v$.marketResearchYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.thirdPartyYn')" for="name-thirdPartyYn"></label>
            <input
              type="text"
              class="form-control"
              name="thirdPartyYn"
              id="name-thirdPartyYn"
              data-cy="thirdPartyYn"
              :class="{ valid: !v$.thirdPartyYn.$invalid, invalid: v$.thirdPartyYn.$invalid }"
              v-model="v$.thirdPartyYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.autoenrollMemberYn')"
              for="name-autoenrollMemberYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="autoenrollMemberYn"
              id="name-autoenrollMemberYn"
              data-cy="autoenrollMemberYn"
              :class="{ valid: !v$.autoenrollMemberYn.$invalid, invalid: v$.autoenrollMemberYn.$invalid }"
              v-model="v$.autoenrollMemberYn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.chainCode')" for="name-chainCode"></label>
            <input
              type="text"
              class="form-control"
              name="chainCode"
              id="name-chainCode"
              data-cy="chainCode"
              :class="{ valid: !v$.chainCode.$invalid, invalid: v$.chainCode.$invalid }"
              v-model="v$.chainCode.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.companyGroupId')"
              for="name-companyGroupId"
            ></label>
            <input
              type="text"
              class="form-control"
              name="companyGroupId"
              id="name-companyGroupId"
              data-cy="companyGroupId"
              :class="{ valid: !v$.companyGroupId.$invalid, invalid: v$.companyGroupId.$invalid }"
              v-model="v$.companyGroupId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.includeIn1099Yn')"
              for="name-includeIn1099Yn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="includeIn1099Yn"
              id="name-includeIn1099Yn"
              data-cy="includeIn1099Yn"
              :class="{ valid: !v$.includeIn1099Yn.$invalid, invalid: v$.includeIn1099Yn.$invalid }"
              v-model="v$.includeIn1099Yn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.creditRating')" for="name-creditRating"></label>
            <input
              type="text"
              class="form-control"
              name="creditRating"
              id="name-creditRating"
              data-cy="creditRating"
              :class="{ valid: !v$.creditRating.$invalid, invalid: v$.creditRating.$invalid }"
              v-model="v$.creditRating.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.titleSuffix')" for="name-titleSuffix"></label>
            <input
              type="number"
              class="form-control"
              name="titleSuffix"
              id="name-titleSuffix"
              data-cy="titleSuffix"
              :class="{ valid: !v$.titleSuffix.$invalid, invalid: v$.titleSuffix.$invalid }"
              v-model.number="v$.titleSuffix.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.inactiveReason')"
              for="name-inactiveReason"
            ></label>
            <input
              type="text"
              class="form-control"
              name="inactiveReason"
              id="name-inactiveReason"
              data-cy="inactiveReason"
              :class="{ valid: !v$.inactiveReason.$invalid, invalid: v$.inactiveReason.$invalid }"
              v-model="v$.inactiveReason.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.iataConsortia')" for="name-iataConsortia"></label>
            <input
              type="text"
              class="form-control"
              name="iataConsortia"
              id="name-iataConsortia"
              data-cy="iataConsortia"
              :class="{ valid: !v$.iataConsortia.$invalid, invalid: v$.iataConsortia.$invalid }"
              v-model="v$.iataConsortia.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.psuedoProfileYn')"
              for="name-psuedoProfileYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="psuedoProfileYn"
              id="name-psuedoProfileYn"
              data-cy="psuedoProfileYn"
              :class="{ valid: !v$.psuedoProfileYn.$invalid, invalid: v$.psuedoProfileYn.$invalid }"
              v-model="v$.psuedoProfileYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.profilePrivacyFlg')"
              for="name-profilePrivacyFlg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="profilePrivacyFlg"
              id="name-profilePrivacyFlg"
              data-cy="profilePrivacyFlg"
              :class="{ valid: !v$.profilePrivacyFlg.$invalid, invalid: v$.profilePrivacyFlg.$invalid }"
              v-model="v$.profilePrivacyFlg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.replaceAddress')"
              for="name-replaceAddress"
            ></label>
            <input
              type="text"
              class="form-control"
              name="replaceAddress"
              id="name-replaceAddress"
              data-cy="replaceAddress"
              :class="{ valid: !v$.replaceAddress.$invalid, invalid: v$.replaceAddress.$invalid }"
              v-model="v$.replaceAddress.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.alienRegistrationNo')"
              for="name-alienRegistrationNo"
            ></label>
            <input
              type="text"
              class="form-control"
              name="alienRegistrationNo"
              id="name-alienRegistrationNo"
              data-cy="alienRegistrationNo"
              :class="{ valid: !v$.alienRegistrationNo.$invalid, invalid: v$.alienRegistrationNo.$invalid }"
              v-model="v$.alienRegistrationNo.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.immigrationStatus')"
              for="name-immigrationStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="immigrationStatus"
              id="name-immigrationStatus"
              data-cy="immigrationStatus"
              :class="{ valid: !v$.immigrationStatus.$invalid, invalid: v$.immigrationStatus.$invalid }"
              v-model="v$.immigrationStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.visaValidityType')"
              for="name-visaValidityType"
            ></label>
            <input
              type="text"
              class="form-control"
              name="visaValidityType"
              id="name-visaValidityType"
              data-cy="visaValidityType"
              :class="{ valid: !v$.visaValidityType.$invalid, invalid: v$.visaValidityType.$invalid }"
              v-model="v$.visaValidityType.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.idDocumentAttachId')"
              for="name-idDocumentAttachId"
            ></label>
            <input
              type="number"
              class="form-control"
              name="idDocumentAttachId"
              id="name-idDocumentAttachId"
              data-cy="idDocumentAttachId"
              :class="{ valid: !v$.idDocumentAttachId.$invalid, invalid: v$.idDocumentAttachId.$invalid }"
              v-model.number="v$.idDocumentAttachId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.superSearchIndexText')"
              for="name-superSearchIndexText"
            ></label>
            <input
              type="text"
              class="form-control"
              name="superSearchIndexText"
              id="name-superSearchIndexText"
              data-cy="superSearchIndexText"
              :class="{ valid: !v$.superSearchIndexText.$invalid, invalid: v$.superSearchIndexText.$invalid }"
              v-model="v$.superSearchIndexText.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.birthDateStr')" for="name-birthDateStr"></label>
            <input
              type="text"
              class="form-control"
              name="birthDateStr"
              id="name-birthDateStr"
              data-cy="birthDateStr"
              :class="{ valid: !v$.birthDateStr.$invalid, invalid: v$.birthDateStr.$invalid }"
              v-model="v$.birthDateStr.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.origNameId')" for="name-origNameId"></label>
            <input
              type="number"
              class="form-control"
              name="origNameId"
              id="name-origNameId"
              data-cy="origNameId"
              :class="{ valid: !v$.origNameId.$invalid, invalid: v$.origNameId.$invalid }"
              v-model.number="v$.origNameId.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.dOptInMailListFlg')"
              for="name-dOptInMailListFlg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dOptInMailListFlg"
              id="name-dOptInMailListFlg"
              data-cy="dOptInMailListFlg"
              :class="{ valid: !v$.dOptInMailListFlg.$invalid, invalid: v$.dOptInMailListFlg.$invalid }"
              v-model="v$.dOptInMailListFlg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.dOptInMarketResearchFlg')"
              for="name-dOptInMarketResearchFlg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dOptInMarketResearchFlg"
              id="name-dOptInMarketResearchFlg"
              data-cy="dOptInMarketResearchFlg"
              :class="{ valid: !v$.dOptInMarketResearchFlg.$invalid, invalid: v$.dOptInMarketResearchFlg.$invalid }"
              v-model="v$.dOptInMarketResearchFlg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.dOptInThirdPartyFlg')"
              for="name-dOptInThirdPartyFlg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dOptInThirdPartyFlg"
              id="name-dOptInThirdPartyFlg"
              data-cy="dOptInThirdPartyFlg"
              :class="{ valid: !v$.dOptInThirdPartyFlg.$invalid, invalid: v$.dOptInThirdPartyFlg.$invalid }"
              v-model="v$.dOptInThirdPartyFlg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.dOptInAutoenrollMemberFlg')"
              for="name-dOptInAutoenrollMemberFlg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dOptInAutoenrollMemberFlg"
              id="name-dOptInAutoenrollMemberFlg"
              data-cy="dOptInAutoenrollMemberFlg"
              :class="{ valid: !v$.dOptInAutoenrollMemberFlg.$invalid, invalid: v$.dOptInAutoenrollMemberFlg.$invalid }"
              v-model="v$.dOptInAutoenrollMemberFlg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.dOptInEmailFlg')"
              for="name-dOptInEmailFlg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dOptInEmailFlg"
              id="name-dOptInEmailFlg"
              data-cy="dOptInEmailFlg"
              :class="{ valid: !v$.dOptInEmailFlg.$invalid, invalid: v$.dOptInEmailFlg.$invalid }"
              v-model="v$.dOptInEmailFlg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.dOptInPhoneFlg')"
              for="name-dOptInPhoneFlg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dOptInPhoneFlg"
              id="name-dOptInPhoneFlg"
              data-cy="dOptInPhoneFlg"
              :class="{ valid: !v$.dOptInPhoneFlg.$invalid, invalid: v$.dOptInPhoneFlg.$invalid }"
              v-model="v$.dOptInPhoneFlg.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.dOptInSmsFlg')" for="name-dOptInSmsFlg"></label>
            <input
              type="text"
              class="form-control"
              name="dOptInSmsFlg"
              id="name-dOptInSmsFlg"
              data-cy="dOptInSmsFlg"
              :class="{ valid: !v$.dOptInSmsFlg.$invalid, invalid: v$.dOptInSmsFlg.$invalid }"
              v-model="v$.dOptInSmsFlg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.dOptInGuestPrivFlg')"
              for="name-dOptInGuestPrivFlg"
            ></label>
            <input
              type="text"
              class="form-control"
              name="dOptInGuestPrivFlg"
              id="name-dOptInGuestPrivFlg"
              data-cy="dOptInGuestPrivFlg"
              :class="{ valid: !v$.dOptInGuestPrivFlg.$invalid, invalid: v$.dOptInGuestPrivFlg.$invalid }"
              v-model="v$.dOptInGuestPrivFlg.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.arCreditLimitYn')"
              for="name-arCreditLimitYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="arCreditLimitYn"
              id="name-arCreditLimitYn"
              data-cy="arCreditLimitYn"
              :class="{ valid: !v$.arCreditLimitYn.$invalid, invalid: v$.arCreditLimitYn.$invalid }"
              v-model="v$.arCreditLimitYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.profileCreditLimit')"
              for="name-profileCreditLimit"
            ></label>
            <input
              type="number"
              class="form-control"
              name="profileCreditLimit"
              id="name-profileCreditLimit"
              data-cy="profileCreditLimit"
              :class="{ valid: !v$.profileCreditLimit.$invalid, invalid: v$.profileCreditLimit.$invalid }"
              v-model.number="v$.profileCreditLimit.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="t$('operaHandlerApplicationApp.name.xmiddleName')" for="name-xmiddleName"></label>
            <input
              type="text"
              class="form-control"
              name="xmiddleName"
              id="name-xmiddleName"
              data-cy="xmiddleName"
              :class="{ valid: !v$.xmiddleName.$invalid, invalid: v$.xmiddleName.$invalid }"
              v-model="v$.xmiddleName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.eInvoiceLiableYn')"
              for="name-eInvoiceLiableYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="eInvoiceLiableYn"
              id="name-eInvoiceLiableYn"
              data-cy="eInvoiceLiableYn"
              :class="{ valid: !v$.eInvoiceLiableYn.$invalid, invalid: v$.eInvoiceLiableYn.$invalid }"
              v-model="v$.eInvoiceLiableYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.eInvLiableLastUpdated')"
              for="name-eInvLiableLastUpdated"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-eInvLiableLastUpdated"
                  v-model="v$.eInvLiableLastUpdated.$model"
                  name="eInvLiableLastUpdated"
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
                id="name-eInvLiableLastUpdated"
                data-cy="eInvLiableLastUpdated"
                type="text"
                class="form-control"
                name="eInvLiableLastUpdated"
                :class="{ valid: !v$.eInvLiableLastUpdated.$invalid, invalid: v$.eInvLiableLastUpdated.$invalid }"
                v-model="v$.eInvLiableLastUpdated.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.internalBillYn')"
              for="name-internalBillYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="internalBillYn"
              id="name-internalBillYn"
              data-cy="internalBillYn"
              :class="{ valid: !v$.internalBillYn.$invalid, invalid: v$.internalBillYn.$invalid }"
              v-model="v$.internalBillYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.compPreApprovalRequiredYn')"
              for="name-compPreApprovalRequiredYn"
            ></label>
            <input
              type="text"
              class="form-control"
              name="compPreApprovalRequiredYn"
              id="name-compPreApprovalRequiredYn"
              data-cy="compPreApprovalRequiredYn"
              :class="{ valid: !v$.compPreApprovalRequiredYn.$invalid, invalid: v$.compPreApprovalRequiredYn.$invalid }"
              v-model="v$.compPreApprovalRequiredYn.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.anonymizationStatus')"
              for="name-anonymizationStatus"
            ></label>
            <input
              type="text"
              class="form-control"
              name="anonymizationStatus"
              id="name-anonymizationStatus"
              data-cy="anonymizationStatus"
              :class="{ valid: !v$.anonymizationStatus.$invalid, invalid: v$.anonymizationStatus.$invalid }"
              v-model="v$.anonymizationStatus.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="t$('operaHandlerApplicationApp.name.anonymizationDate')"
              for="name-anonymizationDate"
            ></label>
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="name-anonymizationDate"
                  v-model="v$.anonymizationDate.$model"
                  name="anonymizationDate"
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
                id="name-anonymizationDate"
                data-cy="anonymizationDate"
                type="text"
                class="form-control"
                name="anonymizationDate"
                :class="{ valid: !v$.anonymizationDate.$invalid, invalid: v$.anonymizationDate.$invalid }"
                v-model="v$.anonymizationDate.$model"
              />
            </b-input-group>
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
<script lang="ts" src="./name-update.component.ts"></script>
