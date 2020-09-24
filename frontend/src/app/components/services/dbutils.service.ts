import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IProducts } from '../interfaces/Products';
import { IClient } from '../Interfaces/Client';

@Injectable({
  providedIn: 'root'
})
export class DBUtilsService {
  private productsUrl = 'http://localhost:8080/products';
  private clientsUrl = 'http://localhost:8080/clients';
  private clientBalance = 'http://localhost:8080/client/';
  private productsByIdUrl = 'http://localhost:8080/product/';
  products: IProducts[];
  client: IClient;
  filteredProducts: IProducts[];
  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<IProducts[]> {
    return this.http.get<IProducts[]>(this.productsUrl, {});
  }
  getBalance(id : string): Observable<IClient> {
  return this.http.get<IClient>(this.clientBalance + id, {});
  }

  getProductsById(id: number): Observable<IProducts> {
    return this.http.get<IProducts>(this.productsByIdUrl + id, {});
  }
  postNewClient(firstName, lastName, email, login, password, address, phoneNumber) {
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
