import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AuthenticationService } from '../services/auth/authentication.service';
import { BasketService } from '../services/basket.service';
import { interval } from 'rxjs';
import { DBUtilsService } from '../services/dbutils.service';
import * as jwt_decode from 'jwt-decode';
import { delay } from 'rxjs/operators';
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
  async ngOnInit(): Promise<void> {
    this.AuthenticationService.currentMessage.subscribe(message => this.logged = message);
    this.BasketService.currentMessage.subscribe(message => this.count = message);
    this.DBUtilsService.currentMessage.subscribe(message => this.balance = message);
    if (sessionStorage.getItem("token") == null) {
      await delay(1000);
    }
    else {
      this.DBUtilsService.getBalance(jwt_decode(sessionStorage.getItem("token")).clientId).subscribe(data => {
        this.balance = data;
        this.DBUtilsService.changeMessage(this.balance);
      }
      );

    }
  }
  logout() {
    this.AuthenticationService.changeMessage(false);
    this.balance = null;
  }
  reciveMessage($event: boolean) {
    this.logged = $event;
  }
}
