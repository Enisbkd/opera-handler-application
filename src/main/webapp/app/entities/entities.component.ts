import { defineComponent, provide } from 'vue';

import ApplicationUserService from './application-user/application-user.service';
import FinancialTransactionsService from './financial-transactions/financial-transactions.service';
import NameAddressService from './name-address/name-address.service';
import NamePhoneService from './name-phone/name-phone.service';
import ReservationSummaryService from './reservation-summary/reservation-summary.service';
import ReservationDailyElementsService from './reservation-daily-elements/reservation-daily-elements.service';
import ReservationDailyElementNameService from './reservation-daily-element-name/reservation-daily-element-name.service';
import ReservationStatDailyService from './reservation-stat-daily/reservation-stat-daily.service';
import ResortService from './resort/resort.service';
import ResortOriginsOfBookingService from './resort-origins-of-booking/resort-origins-of-booking.service';
import ResortRoomCategoryService from './resort-room-category/resort-room-category.service';
import ReservationNameService from './reservation-name/reservation-name.service';
import NameService from './name/name.service';
import UserService from '@/entities/user/user.service';
// jhipster-needle-add-entity-service-to-entities-component-import - JHipster will import entities services here

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'Entities',
  setup() {
    provide('userService', () => new UserService());
    provide('applicationUserService', () => new ApplicationUserService());
    provide('financialTransactionsService', () => new FinancialTransactionsService());
    provide('nameAddressService', () => new NameAddressService());
    provide('namePhoneService', () => new NamePhoneService());
    provide('reservationSummaryService', () => new ReservationSummaryService());
    provide('reservationDailyElementsService', () => new ReservationDailyElementsService());
    provide('reservationDailyElementNameService', () => new ReservationDailyElementNameService());
    provide('reservationStatDailyService', () => new ReservationStatDailyService());
    provide('resortService', () => new ResortService());
    provide('resortOriginsOfBookingService', () => new ResortOriginsOfBookingService());
    provide('resortRoomCategoryService', () => new ResortRoomCategoryService());
    provide('reservationNameService', () => new ReservationNameService());
    provide('nameService', () => new NameService());
    // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
  },
});
