import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IProducts } from '../interfaces/Products';

@Injectable({
  providedIn: 'root'
})
export class DBUtilsService {
  private productsUrl = 'http://localhost:8080/products';
  private productsByIdUrl = 'http://localhost:8080/product/';
  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<IProducts> {
    return this.http.get<IProducts>(this.productsUrl, {});
  }

  getProductsById(id: number): Observable<IProducts> {
    return this.http.get<IProducts>(this.productsByIdUrl + id, {});
  }
}
