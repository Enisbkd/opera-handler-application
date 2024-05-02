/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';

import ReservationStatDaily from './reservation-stat-daily.vue';
import ReservationStatDailyService from './reservation-stat-daily.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationStatDailyComponentType = InstanceType<typeof ReservationStatDaily>;

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  let alertService: AlertService;

  describe('ReservationStatDaily Management Component', () => {
    let reservationStatDailyServiceStub: SinonStubbedInstance<ReservationStatDailyService>;
    let mountOptions: MountingOptions<ReservationStatDailyComponentType>['global'];

    beforeEach(() => {
      reservationStatDailyServiceStub = sinon.createStubInstance<ReservationStatDailyService>(ReservationStatDailyService);
      reservationStatDailyServiceStub.retrieve.resolves({ headers: {} });

      alertService = new AlertService({
        i18n: { t: vitest.fn() } as any,
        bvToast: {
          toast: vitest.fn(),
        } as any,
      });

      mountOptions = {
        stubs: {
          jhiItemCount: true,
          bPagination: true,
          bModal: bModalStub as any,
          'font-awesome-icon': true,
          'b-badge': true,
          'jhi-sort-indicator': true,
          'b-button': true,
          'router-link': true,
        },
        directives: {
          'b-modal': {},
        },
        provide: {
          alertService,
          reservationStatDailyService: () => reservationStatDailyServiceStub,
        },
      };
    });

    describe('Mount', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        reservationStatDailyServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        const wrapper = shallowMount(ReservationStatDaily, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(reservationStatDailyServiceStub.retrieve.calledOnce).toBeTruthy();
        expect(comp.reservationStatDailies[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for an id', async () => {
        // WHEN
        const wrapper = shallowMount(ReservationStatDaily, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(reservationStatDailyServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['id,asc'],
        });
      });
    });
    describe('Handles', () => {
      let comp: ReservationStatDailyComponentType;

      beforeEach(async () => {
        const wrapper = shallowMount(ReservationStatDaily, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();
        reservationStatDailyServiceStub.retrieve.reset();
        reservationStatDailyServiceStub.retrieve.resolves({ headers: {}, data: [] });
      });

      it('should load a page', async () => {
        // GIVEN
        reservationStatDailyServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.page = 2;
        await comp.$nextTick();

        // THEN
        expect(reservationStatDailyServiceStub.retrieve.called).toBeTruthy();
        expect(comp.reservationStatDailies[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should not load a page if the page is the same as the previous page', () => {
        // WHEN
        comp.page = 1;

        // THEN
        expect(reservationStatDailyServiceStub.retrieve.called).toBeFalsy();
      });

      it('should re-initialize the page', async () => {
        // GIVEN
        comp.page = 2;
        await comp.$nextTick();
        reservationStatDailyServiceStub.retrieve.reset();
        reservationStatDailyServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.clear();
        await comp.$nextTick();

        // THEN
        expect(comp.page).toEqual(1);
        expect(reservationStatDailyServiceStub.retrieve.callCount).toEqual(1);
        expect(comp.reservationStatDailies[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for a non-id attribute', async () => {
        // WHEN
        comp.propOrder = 'name';
        await comp.$nextTick();

        // THEN
        expect(reservationStatDailyServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['name,asc', 'id'],
        });
      });

      it('Should call delete service on confirmDelete', async () => {
        // GIVEN
        reservationStatDailyServiceStub.delete.resolves({});

        // WHEN
        comp.prepareRemove({ id: 123 });

        comp.removeReservationStatDaily();
        await comp.$nextTick(); // clear components

        // THEN
        expect(reservationStatDailyServiceStub.delete.called).toBeTruthy();

        // THEN
        await comp.$nextTick(); // handle component clear watch
        expect(reservationStatDailyServiceStub.retrieve.callCount).toEqual(1);
      });
    });
  });
});
