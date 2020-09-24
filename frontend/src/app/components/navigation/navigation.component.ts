import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AuthenticationService } from '../services/auth/authentication.service';
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

  constructor(private BasketService: BasketService, public DBUtilsService: DBUtilsService, private AuthenticationService: AuthenticationService) { }
  count;
  balance;
  logged: boolean = false;
  ngOnInit(): void {
    this.AuthenticationService.currentMessage.subscribe(message => this.logged = message)
    this.getCount();
    interval(1000).subscribe(() => {
      this.getCount();
      if (sessionStorage.getItem("token") != null) {
        console.log(jwt_decode(sessionStorage.getItem("token")).clientId)
        this.DBUtilsService.getBalance(jwt_decode(sessionStorage.getItem("token")).clientId).subscribe(data => {
          this.balance = data;
        }
        );
        console.log(this.balance)
      }

    });
  }
  logout() {
    this.AuthenticationService.changeMessage(false);
  }
  getCount() {
    this.count = this.BasketService.getBooks();
  }
  reciveMessage($event){
    this.logged=$event;
  }
}
