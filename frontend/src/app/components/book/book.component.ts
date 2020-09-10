import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DBUtilsService } from '../services/dbutils.service';
import { IProducts } from '../interfaces/Products';
import { BasketService } from '../services/basket.service';
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {
  id;
  product: IProducts;
  constructor(private DBUtils: DBUtilsService, private route: ActivatedRoute, private BasketService: BasketService) { }

  ngOnInit() {
    this.id = parseInt(this.route.snapshot.paramMap.get('id'));
    this.getProductById(this.id);
  }
  getProductById(id) {
    this.DBUtils.getProductsById(id).subscribe(data => {this.product = data; });
  }
  onClick(author, title, price) {
    this.BasketService.add(author, title, price);
  }
}
