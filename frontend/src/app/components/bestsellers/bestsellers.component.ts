import { Component, OnInit } from '@angular/core';
import { IProducts } from '../interfaces/Products';
import { DBUtilsService } from '../services/dbutils.service';

@Component({
  selector: 'app-bestsellers',
  templateUrl: './bestsellers.component.html',
  styleUrls: ['./bestsellers.component.scss']
})
export class BestsellersComponent implements OnInit {
  products: IProducts;
  constructor(private DBUtils: DBUtilsService) { }
  buttonText = "Do koszyka";
  ngOnInit(): void {
    this.DBUtils.getProducts().subscribe(data => {this.products = data;
      console.log(this.products);
    });
  }

}
