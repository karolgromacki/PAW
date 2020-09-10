import { Component, OnInit } from '@angular/core';
import { BasketService } from '../services/basket.service';
import { interval } from 'rxjs';
import { DBUtilsService } from '../services/dbutils.service';
@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {

  constructor(private BasketService: BasketService, public DBUtilsService: DBUtilsService) { }
  Count;
  search;
  ngOnInit(): void {
    this.getCount();
    interval(1000).subscribe(() => {
      this.getCount();
    });
  }
  getCount(){
    this.Count = this.BasketService.getBooks();
  }
}
