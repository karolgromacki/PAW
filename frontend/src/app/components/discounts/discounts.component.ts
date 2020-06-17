import { Component, OnInit } from '@angular/core';
import { IProducts } from '../interfaces/Products';
import { DBUtilsService } from '../services/dbutils.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-discounts',
  templateUrl: './discounts.component.html',
  styleUrls: ['./discounts.component.scss']
})
export class DiscountsComponent implements OnInit {

  products: IProducts;
  constructor(private DBUtils: DBUtilsService, private router: Router) { }
  buttonText = "Do koszyka";
  ngOnInit(): void {
    this.DBUtils.getProducts().subscribe(data => {this.products = data;
      console.log(this.products);
    });
  }
  onSelect(department) {
    this.router.navigate(['/product', department.id]);
  }

}
