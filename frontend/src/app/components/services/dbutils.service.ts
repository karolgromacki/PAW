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

  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<IProducts> {
    return this.http.get<IProducts>(this.productsUrl, {});
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
  searchFunction(tagSearchName, tagContainerName) {

    let input;
    let filter;
    let tag;
    let i;
    input = document.getElementById('myInput');
    filter = input.value.replace(/\s/g, '').toUpperCase();
    const div = document.getElementById(tagContainerName);
    tag = div.getElementsByTagName(tagSearchName);
    for (i = 0; i < tag.length; i++) {
      const txtValue = tag[i].textContent || tag[i].innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tag[i].style.display = '';
      } else {
        tag[i].style.display = 'none';
      }
    }
    console.log(tagSearchName, tagContainerName, input, filter,tag);
  }
}
