import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore
const Entities = () => import('@/entities/entities.vue');

const ApplicationUser = () => import('@/entities/application-user/application-user.vue');
const ApplicationUserUpdate = () => import('@/entities/application-user/application-user-update.vue');
const ApplicationUserDetails = () => import('@/entities/application-user/application-user-details.vue');

const FinancialTransactions = () => import('@/entities/financial-transactions/financial-transactions.vue');
const FinancialTransactionsUpdate = () => import('@/entities/financial-transactions/financial-transactions-update.vue');
const FinancialTransactionsDetails = () => import('@/entities/financial-transactions/financial-transactions-details.vue');

const NameAddress = () => import('@/entities/name-address/name-address.vue');
const NameAddressUpdate = () => import('@/entities/name-address/name-address-update.vue');
const NameAddressDetails = () => import('@/entities/name-address/name-address-details.vue');

const NamePhone = () => import('@/entities/name-phone/name-phone.vue');
const NamePhoneUpdate = () => import('@/entities/name-phone/name-phone-update.vue');
const NamePhoneDetails = () => import('@/entities/name-phone/name-phone-details.vue');

const ReservationSummary = () => import('@/entities/reservation-summary/reservation-summary.vue');
const ReservationSummaryUpdate = () => import('@/entities/reservation-summary/reservation-summary-update.vue');
const ReservationSummaryDetails = () => import('@/entities/reservation-summary/reservation-summary-details.vue');

const ReservationDailyElements = () => import('@/entities/reservation-daily-elements/reservation-daily-elements.vue');
const ReservationDailyElementsUpdate = () => import('@/entities/reservation-daily-elements/reservation-daily-elements-update.vue');
const ReservationDailyElementsDetails = () => import('@/entities/reservation-daily-elements/reservation-daily-elements-details.vue');

const ReservationDailyElementName = () => import('@/entities/reservation-daily-element-name/reservation-daily-element-name.vue');
const ReservationDailyElementNameUpdate = () =>
  import('@/entities/reservation-daily-element-name/reservation-daily-element-name-update.vue');
const ReservationDailyElementNameDetails = () =>
  import('@/entities/reservation-daily-element-name/reservation-daily-element-name-details.vue');

const ReservationStatDaily = () => import('@/entities/reservation-stat-daily/reservation-stat-daily.vue');
const ReservationStatDailyUpdate = () => import('@/entities/reservation-stat-daily/reservation-stat-daily-update.vue');
const ReservationStatDailyDetails = () => import('@/entities/reservation-stat-daily/reservation-stat-daily-details.vue');

const Resort = () => import('@/entities/resort/resort.vue');
const ResortUpdate = () => import('@/entities/resort/resort-update.vue');
const ResortDetails = () => import('@/entities/resort/resort-details.vue');

const ResortOriginsOfBooking = () => import('@/entities/resort-origins-of-booking/resort-origins-of-booking.vue');
const ResortOriginsOfBookingUpdate = () => import('@/entities/resort-origins-of-booking/resort-origins-of-booking-update.vue');
const ResortOriginsOfBookingDetails = () => import('@/entities/resort-origins-of-booking/resort-origins-of-booking-details.vue');

const ResortRoomCategory = () => import('@/entities/resort-room-category/resort-room-category.vue');
const ResortRoomCategoryUpdate = () => import('@/entities/resort-room-category/resort-room-category-update.vue');
const ResortRoomCategoryDetails = () => import('@/entities/resort-room-category/resort-room-category-details.vue');

const ReservationName = () => import('@/entities/reservation-name/reservation-name.vue');
const ReservationNameUpdate = () => import('@/entities/reservation-name/reservation-name-update.vue');
const ReservationNameDetails = () => import('@/entities/reservation-name/reservation-name-details.vue');

const Name = () => import('@/entities/name/name.vue');
const NameUpdate = () => import('@/entities/name/name-update.vue');
const NameDetails = () => import('@/entities/name/name-details.vue');

// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default {
  path: '/',
  component: Entities,
  children: [
    {
      path: 'application-user',
      name: 'ApplicationUser',
      component: ApplicationUser,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'application-user/new',
      name: 'ApplicationUserCreate',
      component: ApplicationUserUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'application-user/:applicationUserId/edit',
      name: 'ApplicationUserEdit',
      component: ApplicationUserUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'application-user/:applicationUserId/view',
      name: 'ApplicationUserView',
      component: ApplicationUserDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'financial-transactions',
      name: 'FinancialTransactions',
      component: FinancialTransactions,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'financial-transactions/new',
      name: 'FinancialTransactionsCreate',
      component: FinancialTransactionsUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'financial-transactions/:financialTransactionsId/edit',
      name: 'FinancialTransactionsEdit',
      component: FinancialTransactionsUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'financial-transactions/:financialTransactionsId/view',
      name: 'FinancialTransactionsView',
      component: FinancialTransactionsDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name-address',
      name: 'NameAddress',
      component: NameAddress,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name-address/new',
      name: 'NameAddressCreate',
      component: NameAddressUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name-address/:nameAddressId/edit',
      name: 'NameAddressEdit',
      component: NameAddressUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name-address/:nameAddressId/view',
      name: 'NameAddressView',
      component: NameAddressDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name-phone',
      name: 'NamePhone',
      component: NamePhone,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name-phone/new',
      name: 'NamePhoneCreate',
      component: NamePhoneUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name-phone/:namePhoneId/edit',
      name: 'NamePhoneEdit',
      component: NamePhoneUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name-phone/:namePhoneId/view',
      name: 'NamePhoneView',
      component: NamePhoneDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-summary',
      name: 'ReservationSummary',
      component: ReservationSummary,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-summary/new',
      name: 'ReservationSummaryCreate',
      component: ReservationSummaryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-summary/:reservationSummaryId/edit',
      name: 'ReservationSummaryEdit',
      component: ReservationSummaryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-summary/:reservationSummaryId/view',
      name: 'ReservationSummaryView',
      component: ReservationSummaryDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-daily-elements',
      name: 'ReservationDailyElements',
      component: ReservationDailyElements,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-daily-elements/new',
      name: 'ReservationDailyElementsCreate',
      component: ReservationDailyElementsUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-daily-elements/:reservationDailyElementsId/edit',
      name: 'ReservationDailyElementsEdit',
      component: ReservationDailyElementsUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-daily-elements/:reservationDailyElementsId/view',
      name: 'ReservationDailyElementsView',
      component: ReservationDailyElementsDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-daily-element-name',
      name: 'ReservationDailyElementName',
      component: ReservationDailyElementName,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-daily-element-name/new',
      name: 'ReservationDailyElementNameCreate',
      component: ReservationDailyElementNameUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-daily-element-name/:reservationDailyElementNameId/edit',
      name: 'ReservationDailyElementNameEdit',
      component: ReservationDailyElementNameUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-daily-element-name/:reservationDailyElementNameId/view',
      name: 'ReservationDailyElementNameView',
      component: ReservationDailyElementNameDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-stat-daily',
      name: 'ReservationStatDaily',
      component: ReservationStatDaily,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-stat-daily/new',
      name: 'ReservationStatDailyCreate',
      component: ReservationStatDailyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-stat-daily/:reservationStatDailyId/edit',
      name: 'ReservationStatDailyEdit',
      component: ReservationStatDailyUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-stat-daily/:reservationStatDailyId/view',
      name: 'ReservationStatDailyView',
      component: ReservationStatDailyDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort',
      name: 'Resort',
      component: Resort,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort/new',
      name: 'ResortCreate',
      component: ResortUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort/:resortId/edit',
      name: 'ResortEdit',
      component: ResortUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort/:resortId/view',
      name: 'ResortView',
      component: ResortDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort-origins-of-booking',
      name: 'ResortOriginsOfBooking',
      component: ResortOriginsOfBooking,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort-origins-of-booking/new',
      name: 'ResortOriginsOfBookingCreate',
      component: ResortOriginsOfBookingUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort-origins-of-booking/:resortOriginsOfBookingId/edit',
      name: 'ResortOriginsOfBookingEdit',
      component: ResortOriginsOfBookingUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort-origins-of-booking/:resortOriginsOfBookingId/view',
      name: 'ResortOriginsOfBookingView',
      component: ResortOriginsOfBookingDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort-room-category',
      name: 'ResortRoomCategory',
      component: ResortRoomCategory,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort-room-category/new',
      name: 'ResortRoomCategoryCreate',
      component: ResortRoomCategoryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort-room-category/:resortRoomCategoryId/edit',
      name: 'ResortRoomCategoryEdit',
      component: ResortRoomCategoryUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'resort-room-category/:resortRoomCategoryId/view',
      name: 'ResortRoomCategoryView',
      component: ResortRoomCategoryDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-name',
      name: 'ReservationName',
      component: ReservationName,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-name/new',
      name: 'ReservationNameCreate',
      component: ReservationNameUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-name/:reservationNameId/edit',
      name: 'ReservationNameEdit',
      component: ReservationNameUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'reservation-name/:reservationNameId/view',
      name: 'ReservationNameView',
      component: ReservationNameDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name',
      name: 'Name',
      component: Name,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name/new',
      name: 'NameCreate',
      component: NameUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name/:nameId/edit',
      name: 'NameEdit',
      component: NameUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'name/:nameId/view',
      name: 'NameView',
      component: NameDetails,
      meta: { authorities: [Authority.USER] },
    },
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
