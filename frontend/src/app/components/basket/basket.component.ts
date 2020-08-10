import { Component, OnInit } from '@angular/core';
import { dark } from '../../app.component';
import { BasketService } from '../services/basket.service';
@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.scss']
})
export class BasketComponent implements OnInit {

  constructor(private BasketService: BasketService) { }
  bookList: Array<any> = [];

  ngOnInit(): void {
    this.loadBooks();
    console.log(this.bookList)
  }
  loadBooks(){
    this.bookList = this.BasketService.getBooksToBasket();
  }

  remove(id: any) {
    this.bookList.splice(id, 1);
    this.BasketService.setBooks(this.bookList);
  }
}



