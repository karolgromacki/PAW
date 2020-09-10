import { Component, OnInit, ViewChild, ElementRef, Renderer2 } from '@angular/core';
import { IProducts } from '../interfaces/Products';
import { DBUtilsService } from '../services/dbutils.service';
import { BasketService } from '../services/basket.service';

@Component({
  selector: 'app-bestsellers',
  templateUrl: './bestsellers.component.html',
  styleUrls: ['./bestsellers.component.scss']
})
export class BestsellersComponent implements OnInit {
  products: IProducts;
  @ViewChild('add') add: ElementRef;
  constructor(private DBUtils: DBUtilsService, private BasketService: BasketService, private renderer: Renderer2) { }
  buttonText = "Do koszyka";
  ngOnInit(): void {
    this.DBUtils.getProducts().subscribe(data => { this.products = data; });
  }
  onClick(author, title, price) {
    this.BasketService.add(author, title, price);
  }
}
