import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { BasketService } from '../services/basket.service';
import { interval } from 'rxjs';
import { DBUtilsService } from '../services/dbutils.service';
import * as jwt_decode from 'jwt-decode';
@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {

  constructor(private BasketService: BasketService, public DBUtilsService: DBUtilsService) { }
  count;
  balance;
  logged = false;
  ngOnInit(): void {
    this.getCount();
    interval(15000).subscribe(() => {
      this.getCount();
      if (sessionStorage.getItem("token") != null) {
        this.logged = true;
        console.log(jwt_decode(sessionStorage.getItem("token")).clientId)
        this.DBUtilsService.getBalance(jwt_decode(sessionStorage.getItem("token")).clientId).subscribe(data => {
          this.balance = data;
        }
        );
      }

    });
  }
  setlogged() {
    this.logged = false;
  }
  getCount() {
    this.count = this.BasketService.getBooks();
  }
}
