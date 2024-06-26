/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';

import ReservationDailyElementName from './reservation-daily-element-name.vue';
import ReservationDailyElementNameService from './reservation-daily-element-name.service';
import AlertService from '@/shared/alert/alert.service';

type ReservationDailyElementNameComponentType = InstanceType<typeof ReservationDailyElementName>;

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  let alertService: AlertService;

  describe('ReservationDailyElementName Management Component', () => {
    let reservationDailyElementNameServiceStub: SinonStubbedInstance<ReservationDailyElementNameService>;
    let mountOptions: MountingOptions<ReservationDailyElementNameComponentType>['global'];

    beforeEach(() => {
      reservationDailyElementNameServiceStub =
        sinon.createStubInstance<ReservationDailyElementNameService>(ReservationDailyElementNameService);
      reservationDailyElementNameServiceStub.retrieve.resolves({ headers: {} });

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
          reservationDailyElementNameService: () => reservationDailyElementNameServiceStub,
        },
      };
    });

    describe('Mount', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        reservationDailyElementNameServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        const wrapper = shallowMount(ReservationDailyElementName, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementNameServiceStub.retrieve.calledOnce).toBeTruthy();
        expect(comp.reservationDailyElementNames[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for an id', async () => {
        // WHEN
        const wrapper = shallowMount(ReservationDailyElementName, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementNameServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['id,asc'],
        });
      });
    });
    describe('Handles', () => {
      let comp: ReservationDailyElementNameComponentType;

      beforeEach(async () => {
        const wrapper = shallowMount(ReservationDailyElementName, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();
        reservationDailyElementNameServiceStub.retrieve.reset();
        reservationDailyElementNameServiceStub.retrieve.resolves({ headers: {}, data: [] });
      });

      it('should load a page', async () => {
        // GIVEN
        reservationDailyElementNameServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.page = 2;
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementNameServiceStub.retrieve.called).toBeTruthy();
        expect(comp.reservationDailyElementNames[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should not load a page if the page is the same as the previous page', () => {
        // WHEN
        comp.page = 1;

        // THEN
        expect(reservationDailyElementNameServiceStub.retrieve.called).toBeFalsy();
      });

      it('should re-initialize the page', async () => {
        // GIVEN
        comp.page = 2;
        await comp.$nextTick();
        reservationDailyElementNameServiceStub.retrieve.reset();
        reservationDailyElementNameServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.clear();
        await comp.$nextTick();

        // THEN
        expect(comp.page).toEqual(1);
        expect(reservationDailyElementNameServiceStub.retrieve.callCount).toEqual(1);
        expect(comp.reservationDailyElementNames[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for a non-id attribute', async () => {
        // WHEN
        comp.propOrder = 'name';
        await comp.$nextTick();

        // THEN
        expect(reservationDailyElementNameServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['name,asc', 'id'],
        });
      });

      it('Should call delete service on confirmDelete', async () => {
        // GIVEN
        reservationDailyElementNameServiceStub.delete.resolves({});

        // WHEN
        comp.prepareRemove({ id: 123 });

        comp.removeReservationDailyElementName();
        await comp.$nextTick(); // clear components

        // THEN
        expect(reservationDailyElementNameServiceStub.delete.called).toBeTruthy();

        // THEN
        await comp.$nextTick(); // handle component clear watch
        expect(reservationDailyElementNameServiceStub.retrieve.callCount).toEqual(1);
      });
    });
  });
});
