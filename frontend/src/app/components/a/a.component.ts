import { Component, OnInit } from '@angular/core';
import { DBUtilsService } from '../services/dbutils.service';
import { IProducts } from '../interfaces/Products';
@Component({
  selector: 'app-a',
  templateUrl: './a.component.html',
  styleUrls: ['./a.component.scss']
})
export class AComponent implements OnInit {
  products: IProducts;
  constructor(public DBUtilsService: DBUtilsService) { }

  ngOnInit(): void {
    this.DBUtilsService.getProducts().subscribe(data => { this.products = data; });
  }
  myFunction() {
    document.getElementById('myDropdown').classList.add("show");
  }
}
