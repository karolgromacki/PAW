import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { IProducts } from '../interfaces/Products';
import { DBUtilsService } from './dbutils.service';

@Injectable({
  providedIn: 'root'
})
export class BasketService {
  books = [];
  private messageSource = new BehaviorSubject<number>(0);
  currentMessage = this.messageSource.asObservable();

  add(author, price, title) {
    this.getBooks();
    this.books.push({ author: author, title: title, price: price});
    this.setBooks(this.books);
    return this.books.length;
  }
  changeMessage(message: number){
    this.messageSource.next(message)
  }
  setBooks(books) {
      localStorage.setItem('books', JSON.stringify(books));
    }

  getBooks() {
    if (localStorage.getItem('books') === null) {
    }
    else {
      this.books = JSON.parse(localStorage.getItem('books'));
      this.changeMessage(this.books.length);
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
