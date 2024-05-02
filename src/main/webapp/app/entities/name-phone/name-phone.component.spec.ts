/* tslint:disable max-line-length */
import { vitest } from 'vitest';
import { shallowMount, type MountingOptions } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';

import NamePhone from './name-phone.vue';
import NamePhoneService from './name-phone.service';
import AlertService from '@/shared/alert/alert.service';

type NamePhoneComponentType = InstanceType<typeof NamePhone>;

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  let alertService: AlertService;

  describe('NamePhone Management Component', () => {
    let namePhoneServiceStub: SinonStubbedInstance<NamePhoneService>;
    let mountOptions: MountingOptions<NamePhoneComponentType>['global'];

    beforeEach(() => {
      namePhoneServiceStub = sinon.createStubInstance<NamePhoneService>(NamePhoneService);
      namePhoneServiceStub.retrieve.resolves({ headers: {} });

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
          namePhoneService: () => namePhoneServiceStub,
        },
      };
    });

    describe('Mount', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        namePhoneServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        const wrapper = shallowMount(NamePhone, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(namePhoneServiceStub.retrieve.calledOnce).toBeTruthy();
        expect(comp.namePhones[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for an id', async () => {
        // WHEN
        const wrapper = shallowMount(NamePhone, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        // THEN
        expect(namePhoneServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['id,asc'],
        });
      });
    });
    describe('Handles', () => {
      let comp: NamePhoneComponentType;

      beforeEach(async () => {
        const wrapper = shallowMount(NamePhone, { global: mountOptions });
        comp = wrapper.vm;
        await comp.$nextTick();
        namePhoneServiceStub.retrieve.reset();
        namePhoneServiceStub.retrieve.resolves({ headers: {}, data: [] });
      });

      it('should load a page', async () => {
        // GIVEN
        namePhoneServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.page = 2;
        await comp.$nextTick();

        // THEN
        expect(namePhoneServiceStub.retrieve.called).toBeTruthy();
        expect(comp.namePhones[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should not load a page if the page is the same as the previous page', () => {
        // WHEN
        comp.page = 1;

        // THEN
        expect(namePhoneServiceStub.retrieve.called).toBeFalsy();
      });

      it('should re-initialize the page', async () => {
        // GIVEN
        comp.page = 2;
        await comp.$nextTick();
        namePhoneServiceStub.retrieve.reset();
        namePhoneServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

        // WHEN
        comp.clear();
        await comp.$nextTick();

        // THEN
        expect(comp.page).toEqual(1);
        expect(namePhoneServiceStub.retrieve.callCount).toEqual(1);
        expect(comp.namePhones[0]).toEqual(expect.objectContaining({ id: 123 }));
      });

      it('should calculate the sort attribute for a non-id attribute', async () => {
        // WHEN
        comp.propOrder = 'name';
        await comp.$nextTick();

        // THEN
        expect(namePhoneServiceStub.retrieve.lastCall.firstArg).toMatchObject({
          sort: ['name,asc', 'id'],
        });
      });

      it('Should call delete service on confirmDelete', async () => {
        // GIVEN
        namePhoneServiceStub.delete.resolves({});

        // WHEN
        comp.prepareRemove({ id: 123 });

        comp.removeNamePhone();
        await comp.$nextTick(); // clear components

        // THEN
        expect(namePhoneServiceStub.delete.called).toBeTruthy();

        // THEN
        await comp.$nextTick(); // handle component clear watch
        expect(namePhoneServiceStub.retrieve.callCount).toEqual(1);
      });
    });
  });
});
