/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';

import ReservationDailyElements from './reservation-daily-elements.vue';
import ReservationDailyElementsService from './reservation-daily-elements.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationDailyElementsComponentType = InstanceType<typeof ReservationDailyElements>;

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  let alertService: AlertService;

  describe('ReservationDailyElements Management Component', () => {
    let reservationDailyElementsServiceStub: SinonStubbedInstance<ReservationDailyElementsService>;
    let mountOptions: MountingOptions<ReservationDailyElementsComponentType>['global'];

    beforeEach(() => {
      reservationDailyElementsServiceStub = sinon.createStubInstance<ReservationDailyElementsService>(ReservationDailyElementsService);
      reservationDailyElementsServiceStub.retrieve.resolves({ headers: {} });

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
          reservationDailyElementsService: () => reservationDailyElementsServiceStub,
        },
      };
    });

    describe('Mount', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        reservationDailyElementsServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        const wrapper = shallowMount(ReservationDailyElements, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementsServiceStub.retrieve.calledOnce).toBeTruthy();
        expect(comp.reservationDailyElements[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for an id', async () => {
        // WHEN
        const wrapper = shallowMount(ReservationDailyElements, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementsServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['id,asc'],
        });
      });
    });
    describe('Handles', () => {
      let comp: ReservationDailyElementsComponentType;

      beforeEach(async () => {
        const wrapper = shallowMount(ReservationDailyElements, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();
        reservationDailyElementsServiceStub.retrieve.reset();
        reservationDailyElementsServiceStub.retrieve.resolves({ headers: {}, data: [] });
      });

      it('should load a page', async () => {
        // GIVEN
        reservationDailyElementsServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.page = 2;
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementsServiceStub.retrieve.called).toBeTruthy();
        expect(comp.reservationDailyElements[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should not load a page if the page is the same as the previous page', () => {
        // WHEN
        comp.page = 1;

        // THEN
        expect(reservationDailyElementsServiceStub.retrieve.called).toBeFalsy();
      });

      it('should re-initialize the page', async () => {
        // GIVEN
        comp.page = 2;
        await comp.$nextTick();
        reservationDailyElementsServiceStub.retrieve.reset();
        reservationDailyElementsServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.clear();
        await comp.$nextTick();

        // THEN
        expect(comp.page).toEqual(1);
        expect(reservationDailyElementsServiceStub.retrieve.callCount).toEqual(1);
        expect(comp.reservationDailyElements[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for a non-id attribute', async () => {
        // WHEN
        comp.propOrder = 'name';
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementsServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['name,asc', 'id'],
        });
      });

      it('Should call delete service on confirmDelete', async () => {
        // GIVEN
        reservationDailyElementsServiceStub.delete.resolves({});

        // WHEN
        comp.prepareRemove({ id: 123 });

        comp.removeReservationDailyElements();
        await comp.$nextTick(); // clear components

        // THEN
        expect(reservationDailyElementsServiceStub.delete.called).toBeTruthy();

        // THEN
        await comp.$nextTick(); // handle component clear watch
        expect(reservationDailyElementsServiceStub.retrieve.callCount).toEqual(1);
      });
    });
  });
});
