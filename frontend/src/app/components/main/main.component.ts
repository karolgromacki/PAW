import { Component, OnInit, HostListener } from '@angular/core';
import { DBUtilsService } from '../services/dbutils.service';
import { BasketService } from '../services/basket.service';
import { HttpClient } from '@angular/common/http';
import { IProducts } from '../interfaces/Products';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {
  products: IProducts[];
  filteredProducts: IProducts[];
  buttonText = "Do koszyka";
  constructor(private DBUtils: DBUtilsService, private http: HttpClient, private BasketService: BasketService) { }
  ngOnInit() {
    this.DBUtils.getProducts().subscribe(data => {this.products = data;
      this.filteredProducts = this.products;
      });  }
  reciveMessage($event){
    this.filteredProducts=$event;
  }
  onClick(author, title, price) {
    this.BasketService.add(author, title, price);
  }

}
