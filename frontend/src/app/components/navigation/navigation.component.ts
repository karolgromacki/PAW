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
    this.BasketService.currentMessage.subscribe(message => this.count = message)
    interval(15000).subscribe(() => {
      if (sessionStorage.getItem("token") != null) {
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
  reciveMessage($event){
    this.logged=$event;
  }
}
