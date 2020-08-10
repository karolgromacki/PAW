import { Component, OnInit } from '@angular/core';
import { IProducts } from '../interfaces/Products';
import { BasketService } from '../services/basket.service';
import { DBUtilsService } from '../services/dbutils.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-discounts',
  templateUrl: './discounts.component.html',
  styleUrls: ['./discounts.component.scss']
})
export class DiscountsComponent implements OnInit {

  products: IProducts;
  constructor(private DBUtils: DBUtilsService, private router: Router, private BasketService: BasketService) { }
  buttonText = "Do koszyka";
  ngOnInit(): void {
    this.DBUtils.getProducts().subscribe(data => {this.products = data;
    });
  }
  onClick(author, title, price) {
    this.BasketService.add(author, title, price);
  }

}
