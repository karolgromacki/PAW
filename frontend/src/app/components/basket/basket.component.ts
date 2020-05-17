import { Component, OnInit } from '@angular/core';
import {dark} from '../../app.component'
@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.scss']
})
export class BasketComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  editField: string;
  bookList: Array<any> = [
    { id: 1, author: 'Aurelia Vega', quantity: 30, title: 'Deepends', country: 'Spain'},
    { id: 2, author: 'Guerra Cortez', quantity: 45, title: 'Insectus', country: 'USA'},
    { id: 3, author: 'Guadalupe House', quantity: 26, title: 'Isotronic', country: 'Germany'},
    { id: 4, author: 'Aurelia Vega', quantity: 30, title: 'Deepends', country: 'Spain'},
    { id: 5, author: 'Elisa Gallagher', quantity: 31, title: 'Portica', country: 'United Kingdom'},
  ];

  awaitingbookList: Array<any> = [
    { id: 6, author: 'George Vega', quantity: 28, title: 'Classical', country: 'Russia'},
    { id: 7, author: 'Mike Low', quantity: 22, title: 'Lou', country: 'USA'},
    { id: 8, author: 'John Derp', quantity: 36, title: 'Derping', country: 'USA'},
    { id: 9, author: 'Anastasia John', quantity: 21, title: 'Ajo', country: 'Brazil'},
    { id: 10, author: 'John Maklowicz', quantity: 36, title: 'Mako', country: 'Poland'},
  ];

  updateList(id: number, property: string, event: any) {
    const editField = event.target.textContent;
    this.bookList[id][property] = editField;
  }

  remove(id: any) {
    this.awaitingbookList.push(this.bookList[id]);
    this.bookList.splice(id, 1);
  }

  add() {
    if (this.awaitingbookList.length > 0) {
      const book = this.awaitingbookList[0];
      this.bookList.push(book);
      this.awaitingbookList.splice(0, 1);
    }
  }

  changeValue(id: number, property: string, event: any) {
    this.editField = event.target.textContent;
  }

}
