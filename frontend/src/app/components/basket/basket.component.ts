import { Component, OnInit } from '@angular/core';
import { BasketService } from '../services/basket.service';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
import { DBUtilsService } from '../services/dbutils.service';
import * as jwt_decode from 'jwt-decode';

pdfMake.vfs = pdfFonts.pdfMake.vfs;
@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.scss']
})
export class BasketComponent implements OnInit {
  constructor(private BasketService: BasketService, private Db: DBUtilsService) { }
  bookList: Array<any> = [];
  suma: number = 0;
  pdf: Array<any> = [];
  loggedd = false;
  amount;
  ngOnInit(): void {
    this.Db.currentMessage.subscribe(message => this.amount = message);
    console.log(this.amount);
    this.loadBooks();
    this.bookList.forEach(book => {
      this.suma += book.price;
    });
    if (sessionStorage.getItem('token') != null) {
      this.loggedd = true;
    }
  }
  loadBooks() {
    this.bookList = this.BasketService.getBooksToBasket();
  }

  remove(id: any) {
    this.bookList.splice(id, 1);
    this.BasketService.setBooks(this.bookList);
    this.suma = 0;
    this.bookList.forEach(book => {
      this.suma += book.price;
    });
  }
  generatePdf(today) {
    let date = this.dateformat(today);
    const ef = Date.UTC(2012, 11, 20, 3, 0, 0);
    for (let book of this.bookList) {
      this.pdf.push(book.author + '  "' + book.title + '"   -   ' + book.price.toFixed(2) + 'zł');
    }
    const documentDefinition = { content: [date,'\n','Potwierdzenie zakupu', '\n', this.pdf, '\n', 'Razem: ' + this.suma.toFixed(2) + 'zł'] };
    pdfMake.createPdf(documentDefinition).open();
  }
  extractTimeFormatFromDate(date: Date): string {
    const hours = date.getHours() < 10 ? `0${date.getHours()}` : date.getHours();
    const minutes = date.getMinutes() < 10 ? `0${date.getMinutes()}` : date.getMinutes();
    const month = date.getUTCDate() < 10 ? `0${date.getMinutes()}` : date.getMinutes();
    return `${date.getUTCDate()} ${hours}:${minutes}`;
  }
  payment() {
    const today = new Date();
    if (this.suma > 0 && this.amount.accountBalance > 0) {
      if ((this.amount.accountBalance - this.suma) >= 0) {
        this.Db.changeMessage({ firstName: "employee", lastName: "one", email: "e1", accountBalance: (this.amount.accountBalance - this.suma) });
        this.generatePdf(today);
        //this.Db.postNewPayment(this.suma,Date.now(),jwt_decode(sessionStorage.getItem("token")).clientId).subscribe(() => {});
        this.bookList.length = 0;
        this.suma = 0;
        this.BasketService.clearBooks();

      }
    }
  }
  dateformat(today){
    let date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate()+' '+ today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    return date;
  }
}


