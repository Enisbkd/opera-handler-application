/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';

import ResortOriginsOfBooking from './resort-origins-of-booking.vue';
import ResortOriginsOfBookingService from './resort-origins-of-booking.service';
import AlertService from '@/shared/alert/alert.service';

type ResortOriginsOfBookingComponentType = InstanceType<typeof ResortOriginsOfBooking>;

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  let alertService: AlertService;

  describe('ResortOriginsOfBooking Management Component', () => {
    let resortOriginsOfBookingServiceStub: SinonStubbedInstance<ResortOriginsOfBookingService>;
    let mountOptions: MountingOptions<ResortOriginsOfBookingComponentType>['global'];

    beforeEach(() => {
      resortOriginsOfBookingServiceStub = sinon.createStubInstance<ResortOriginsOfBookingService>(ResortOriginsOfBookingService);
      resortOriginsOfBookingServiceStub.retrieve.resolves({ headers: {} });

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
          resortOriginsOfBookingService: () => resortOriginsOfBookingServiceStub,
        },
      };
    });

    describe('Mount', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        resortOriginsOfBookingServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        const wrapper = shallowMount(ResortOriginsOfBooking, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(resortOriginsOfBookingServiceStub.retrieve.calledOnce).toBeTruthy();
        expect(comp.resortOriginsOfBookings[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for an id', async () => {
        // WHEN
        const wrapper = shallowMount(ResortOriginsOfBooking, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(resortOriginsOfBookingServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['id,asc'],
        });
      });
    });
    describe('Handles', () => {
      let comp: ResortOriginsOfBookingComponentType;

      beforeEach(async () => {
        const wrapper = shallowMount(ResortOriginsOfBooking, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();
        resortOriginsOfBookingServiceStub.retrieve.reset();
        resortOriginsOfBookingServiceStub.retrieve.resolves({ headers: {}, data: [] });
      });

      it('should load a page', async () => {
        // GIVEN
        resortOriginsOfBookingServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.page = 2;
        await comp.$nextTick();

        // THEN
        expect(resortOriginsOfBookingServiceStub.retrieve.called).toBeTruthy();
        expect(comp.resortOriginsOfBookings[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should not load a page if the page is the same as the previous page', () => {
        // WHEN
        comp.page = 1;

        // THEN
        expect(resortOriginsOfBookingServiceStub.retrieve.called).toBeFalsy();
      });

      it('should re-initialize the page', async () => {
        // GIVEN
        comp.page = 2;
        await comp.$nextTick();
        resortOriginsOfBookingServiceStub.retrieve.reset();
        resortOriginsOfBookingServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.clear();
        await comp.$nextTick();

        // THEN
        expect(comp.page).toEqual(1);
        expect(resortOriginsOfBookingServiceStub.retrieve.callCount).toEqual(1);
        expect(comp.resortOriginsOfBookings[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for a non-id attribute', async () => {
        // WHEN
        comp.propOrder = 'name';
        await comp.$nextTick();

        // THEN
        expect(resortOriginsOfBookingServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['name,asc', 'id'],
        });
      });

      it('Should call delete service on confirmDelete', async () => {
        // GIVEN
        resortOriginsOfBookingServiceStub.delete.resolves({});

        // WHEN
        comp.prepareRemove({ id: 123 });

        comp.removeResortOriginsOfBooking();
        await comp.$nextTick(); // clear components

        // THEN
        expect(resortOriginsOfBookingServiceStub.delete.called).toBeTruthy();

        // THEN
        await comp.$nextTick(); // handle component clear watch
        expect(resortOriginsOfBookingServiceStub.retrieve.callCount).toEqual(1);
      });
    });
  });
});
