import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { type IReservationDailyElementName } from '@/shared/model/reservation-daily-element-name.model';

const baseApiUrl = 'api/reservation-daily-element-names';

export default class ReservationDailyElementNameService {
  public find(id: number): Promise<IReservationDailyElementName> {
    return new Promise<IReservationDailyElementName>((resolve, reject) => {
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

  public create(entity: IReservationDailyElementName): Promise<IReservationDailyElementName> {
    return new Promise<IReservationDailyElementName>((resolve, reject) => {
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

  public update(entity: IReservationDailyElementName): Promise<IReservationDailyElementName> {
    return new Promise<IReservationDailyElementName>((resolve, reject) => {
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

  public partialUpdate(entity: IReservationDailyElementName): Promise<IReservationDailyElementName> {
    return new Promise<IReservationDailyElementName>((resolve, reject) => {
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
