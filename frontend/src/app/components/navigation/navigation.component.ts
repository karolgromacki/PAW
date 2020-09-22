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
  Count;
  search;
  token = sessionStorage.getItem("token");
  ngOnInit(): void {
    this.getCount();
    interval(1000).subscribe(() => {
      this.getCount();
      console.log(this.token);
      let tokenInfo = this.getDecodedAccessToken(this.token);
      console.log(tokenInfo);
    });

  }
  getCount(){
    this.Count = this.BasketService.getBooks();
  }
  getDecodedAccessToken(token: string): any {
            return jwt_decode(token);


  }
}
