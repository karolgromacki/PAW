import { Component, OnInit} from '@angular/core';
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
  ngOnInit(): void {
    this.getCount();
    interval(1000).subscribe(() => {
      this.getCount();
      if(sessionStorage.getItem("token")!=null){
      this.balance = this.DBUtilsService.getBalance(jwt_decode(sessionStorage.getItem("token")).clientId);
      console.log(this.balance);}
    });

  }
  getCount(){
    this.count = this.BasketService.getBooks();
  }
}
