import { Injectable } from '@angular/core';
import { IProducts } from '../interfaces/Products';
import { DBUtilsService } from './dbutils.service';

@Injectable({
  providedIn: 'root'
})
export class BasketService {
  books = [];

  add(author, price, title) {
    this.getBooks();
    this.books.push({ author: author, title: title, price: price});
    this.setBooks(this.books);
    return this.books.length;
  }
  setBooks(books) {
      localStorage.setItem('books', JSON.stringify(books));
    }

  getBooks() {
    if (localStorage.getItem('books') === null) {
    }
    else {
      this.books = JSON.parse(localStorage.getItem('books'));

    }
    return this.books.length;
  }
  clearBooks(){
    this.books.length=0;
    localStorage.setItem('books', JSON.stringify(this.books));
  }
  getBooksToBasket(){
    this.getBooks();
    return this.books;
  }


}
