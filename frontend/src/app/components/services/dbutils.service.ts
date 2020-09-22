import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IProducts } from '../interfaces/Products';

@Injectable({
  providedIn: 'root'
})
export class DBUtilsService {
  private productsUrl = 'http://localhost:8080/products';
  private clientsUrl = 'http://localhost:8080/clients';
  private productsByIdUrl = 'http://localhost:8080/product/';
  products: IProducts[];
  filteredProducts: IProducts[];
  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<IProducts[]> {
    return this.http.get<IProducts[]>(this.productsUrl, {});
  }

  getProductsById(id: number): Observable<IProducts> {
    return this.http.get<IProducts>(this.productsByIdUrl + id, {});
  }
  postEntranceNew(firstName, lastName, email, login, password, address, phoneNumber) {
    return this.http.post<any>(this.clientsUrl, {
      id: 0,
      firstName,
      lastName,
      email,
      phoneNumber,
      login,
      password,
      accountBalance: "0",
      enabled: true,
      address,
      nip: "string"
    });
  }
}
