import { defineComponent, inject, onMounted, ref, type Ref, watch } from 'vue';
import { useI18n } from 'vue-i18n';

import ResortOriginsOfBookingService from './resort-origins-of-booking.service';
import { type IResortOriginsOfBooking } from '@/shared/model/resort-origins-of-booking.model';
import { useAlertService } from '@/shared/alert/alert.service';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'ResortOriginsOfBooking',
  setup() {
    const { t: t$ } = useI18n();
    const resortOriginsOfBookingService = inject('resortOriginsOfBookingService', () => new ResortOriginsOfBookingService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const itemsPerPage = ref(20);
    const queryCount: Ref<number> = ref(null);
    const page: Ref<number> = ref(1);
    const propOrder = ref('id');
    const reverse = ref(false);
    const totalItems = ref(0);

    const resortOriginsOfBookings: Ref<IResortOriginsOfBooking[]> = ref([]);

    const isFetching = ref(false);

    const clear = () => {
      page.value = 1;
    };

    const sort = (): Array<any> => {
      const result = [propOrder.value + ',' + (reverse.value ? 'desc' : 'asc')];
      if (propOrder.value !== 'id') {
        result.push('id');
      }
      return result;
    };

    const retrieveResortOriginsOfBookings = async () => {
      isFetching.value = true;
      try {
        const paginationQuery = {
          page: page.value - 1,
          size: itemsPerPage.value,
          sort: sort(),
        };
        const res = await resortOriginsOfBookingService().retrieve(paginationQuery);
        totalItems.value = Number(res.headers['x-total-count']);
        queryCount.value = totalItems.value;
        resortOriginsOfBookings.value = res.data;
      } catch (err) {
        alertService.showHttpError(err.response);
      } finally {
        isFetching.value = false;
      }
    };

    const handleSyncList = () => {
      retrieveResortOriginsOfBookings();
    };

    onMounted(async () => {
      await retrieveResortOriginsOfBookings();
    });

    const removeId: Ref<number> = ref(null);
    const removeEntity = ref<any>(null);
    const prepareRemove = (instance: IResortOriginsOfBooking) => {
      removeId.value = instance.id;
      removeEntity.value.show();
    };
    const closeDialog = () => {
      removeEntity.value.hide();
    };
    const removeResortOriginsOfBooking = async () => {
      try {
        await resortOriginsOfBookingService().delete(removeId.value);
        const message = t$('operaHandlerApplicationApp.resortOriginsOfBooking.deleted', { param: removeId.value }).toString();
        alertService.showInfo(message, { variant: 'danger' });
        removeId.value = null;
        retrieveResortOriginsOfBookings();
        closeDialog();
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    const changeOrder = (newOrder: string) => {
      if (propOrder.value === newOrder) {
        reverse.value = !reverse.value;
      } else {
        reverse.value = false;
      }
      propOrder.value = newOrder;
    };

    // Whenever order changes, reset the pagination
    watch([propOrder, reverse], async () => {
      if (page.value === 1) {
        // first page, retrieve new data
        await retrieveResortOriginsOfBookings();
      } else {
        // reset the pagination
        clear();
      }
    });

    // Whenever page changes, switch to the new page.
    watch(page, async () => {
      await retrieveResortOriginsOfBookings();
    });

    return {
      resortOriginsOfBookings,
      handleSyncList,
      isFetching,
      retrieveResortOriginsOfBookings,
      clear,
      removeId,
      removeEntity,
      prepareRemove,
      closeDialog,
      removeResortOriginsOfBooking,
      itemsPerPage,
      queryCount,
      page,
      propOrder,
      reverse,
      totalItems,
      changeOrder,
      t$,
    };
  },
});
