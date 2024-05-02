/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';

import ReservationSummary from './reservation-summary.vue';
import ReservationSummaryService from './reservation-summary.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationSummaryComponentType = InstanceType<typeof ReservationSummary>;

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  let alertService: AlertService;

  describe('ReservationSummary Management Component', () => {
    let reservationSummaryServiceStub: SinonStubbedInstance<ReservationSummaryService>;
    let mountOptions: MountingOptions<ReservationSummaryComponentType>['global'];

    beforeEach(() => {
      reservationSummaryServiceStub = sinon.createStubInstance<ReservationSummaryService>(ReservationSummaryService);
      reservationSummaryServiceStub.retrieve.resolves({ headers: {} });

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
          reservationSummaryService: () => reservationSummaryServiceStub,
        },
      };
    });

    describe('Mount', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        reservationSummaryServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        const wrapper = shallowMount(ReservationSummary, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(reservationSummaryServiceStub.retrieve.calledOnce).toBeTruthy();
        expect(comp.reservationSummaries[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for an id', async () => {
        // WHEN
        const wrapper = shallowMount(ReservationSummary, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(reservationSummaryServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['id,asc'],
        });
      });
    });
    describe('Handles', () => {
      let comp: ReservationSummaryComponentType;

      beforeEach(async () => {
        const wrapper = shallowMount(ReservationSummary, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();
        reservationSummaryServiceStub.retrieve.reset();
        reservationSummaryServiceStub.retrieve.resolves({ headers: {}, data: [] });
      });

      it('should load a page', async () => {
        // GIVEN
        reservationSummaryServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.page = 2;
        await comp.$nextTick();

        // THEN
        expect(reservationSummaryServiceStub.retrieve.called).toBeTruthy();
        expect(comp.reservationSummaries[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should not load a page if the page is the same as the previous page', () => {
        // WHEN
        comp.page = 1;

        // THEN
        expect(reservationSummaryServiceStub.retrieve.called).toBeFalsy();
      });

      it('should re-initialize the page', async () => {
        // GIVEN
        comp.page = 2;
        await comp.$nextTick();
        reservationSummaryServiceStub.retrieve.reset();
        reservationSummaryServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.clear();
        await comp.$nextTick();

        // THEN
        expect(comp.page).toEqual(1);
        expect(reservationSummaryServiceStub.retrieve.callCount).toEqual(1);
        expect(comp.reservationSummaries[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for a non-id attribute', async () => {
        // WHEN
        comp.propOrder = 'name';
        await comp.$nextTick();

        // THEN
        expect(reservationSummaryServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['name,asc', 'id'],
        });
      });

      it('Should call delete service on confirmDelete', async () => {
        // GIVEN
        reservationSummaryServiceStub.delete.resolves({});

        // WHEN
        comp.prepareRemove({ id: 123 });

        comp.removeReservationSummary();
        await comp.$nextTick(); // clear components

        // THEN
        expect(reservationSummaryServiceStub.delete.called).toBeTruthy();

        // THEN
        await comp.$nextTick(); // handle component clear watch
        expect(reservationSummaryServiceStub.retrieve.callCount).toEqual(1);
      });
    });
  });
});
