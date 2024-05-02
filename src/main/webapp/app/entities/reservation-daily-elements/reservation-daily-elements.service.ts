import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { type IReservationDailyElements } from '@/shared/model/reservation-daily-elements.model';

const baseApiUrl = 'api/reservation-daily-elements';

export default class ReservationDailyElementsService {
  public find(id: number): Promise<IReservationDailyElements> {
    return new Promise<IReservationDailyElements>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(paginationQuery?: any): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl + `?${buildPaginationQueryOpts(paginationQuery)}`)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public delete(id: number): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .delete(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public create(entity: IReservationDailyElements): Promise<IReservationDailyElements> {
    return new Promise<IReservationDailyElements>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public update(entity: IReservationDailyElements): Promise<IReservationDailyElements> {
    return new Promise<IReservationDailyElements>((resolve, reject) => {
      axios
        .put(`${baseApiUrl}/${entity.id}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public partialUpdate(entity: IReservationDailyElements): Promise<IReservationDailyElements> {
    return new Promise<IReservationDailyElements>((resolve, reject) => {
      axios
        .patch(`${baseApiUrl}/${entity.id}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
