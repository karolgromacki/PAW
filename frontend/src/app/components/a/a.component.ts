import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { DBUtilsService } from '../services/dbutils.service';
import { IProducts } from '../interfaces/Products';

@Component({
  selector: 'app-a',
  templateUrl: './a.component.html',
  styleUrls: ['./a.component.scss']
})
export class AComponent implements OnInit {
  products: IProducts[];
  filteredProducts: IProducts[];
  title: string;
  author: string;
@Output() messageEvent = new EventEmitter();
  constructor(public DBUtilsService: DBUtilsService) {
  }

  ngOnInit(): void {
    this.DBUtilsService.getProducts().subscribe(data => {
      this.products = data;
      this.filteredProducts = data;
    });
  }
  sendMessage(){
    this.messageEvent.emit(this.filteredProducts);
  }
  filterProcutsOnKeyPress() {
    this.filteredProducts = this.products.filter(product => {
      return this.title || this.author ?
        product.productName.toLowerCase().includes(this.title.toLowerCase()) || product.author.toLowerCase().includes(this.author.toLowerCase()) :
        true;
    }
    );
  }
}
