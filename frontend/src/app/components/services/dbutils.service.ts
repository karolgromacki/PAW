import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IProducts } from '../interfaces/Products';

@Injectable({
  providedIn: 'root'
})
export class DBUtilsService {
  private productsUrl = '/assets/products.json';
  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<IProducts> {
    return this.http.get<IProducts>(this.productsUrl, {});
  }
}
