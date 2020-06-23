import { Injectable } from '@angular/core';
import { IProducts } from '../interfaces/Products';
import { DBUtilsService } from './dbutils.service';

@Injectable({
  providedIn: 'root'
})
export class BasketService {
  books = [
    { id: 1, author: "Andrzej Sapkowski", price: 31, product_name: "Ostatnie Życzenie" },
    { id: 2, author: "Andrzej Sapkowski", price: 31, product_name: "Miecz Przeznaczenia" },
    { id: 3, author: "Andrzej Sapkowski", price: 31, product_name: "Krew Elfów" },
    { id: 4, author: "Andrzej Sapkowski", price: 31, product_name: "Czas Pogardy" },
    { id: 5, author: "Andrzej Sapkowski", price: 31, product_name: "Chrzest Ognia" }
  ]

  add(id, author, price, productName) {
    this.books.push({ id: id, author: author, price: price, product_name: productName });
  }

}
