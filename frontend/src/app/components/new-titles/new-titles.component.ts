import { Component, OnInit } from '@angular/core';
import { IProducts } from '../interfaces/Products';
import { DBUtilsService } from '../services/dbutils.service';

@Component({
  selector: 'app-new-titles',
  templateUrl: './new-titles.component.html',
  styleUrls: ['./new-titles.component.scss']
})
export class NewTitlesComponent implements OnInit {
  products: IProducts;
  constructor(private DBUtils: DBUtilsService) { }
  buttonText = "Do koszyka";
  ngOnInit(): void {
    this.DBUtils.getProducts().subscribe(data => {
      this.products = data;
      console.log(this.products);
    });
  }

}
