import { Component, OnInit } from '@angular/core';
import { BasketService } from '../services/basket.service';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
import { DBUtilsService } from '../services/dbutils.service';
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
  generatePdf() {
    for (let book of this.bookList) {
      this.pdf.push(book.author + '  "' + book.title + '"   -   ' + book.price.toFixed(2) + 'zł');
    }
    const documentDefinition = { content: ['Dokonano zakupu następujących książek:', '\n', this.pdf, '\n', 'Razem: ' + this.suma.toFixed(2) + 'zł'] };
    pdfMake.createPdf(documentDefinition).open();
  }
  payment() {
    if (this.suma > 0 && this.amount.accountBalance > 0) {
      if ((this.amount.accountBalance - this.suma) >= 0) {
        this.Db.changeMessage({ firstName: "employee", lastName: "one", email: "e1", accountBalance: (this.amount.accountBalance - this.suma) });
        this.generatePdf();
        this.bookList.length = 0;
        this.suma = 0;
        this.BasketService.clearBooks();
      }
    }
  }
}


