import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AuthenticationService } from '../services/auth/authentication.service';
import { DBUtilsService } from '../services/dbutils.service';
import { Router } from '@angular/router';
import * as jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  username = '';
  password = '';
  invalidLogin = false;
  logged=true;
  balance;
  constructor(private router: Router, private loginService: AuthenticationService, private db:DBUtilsService) { }
  @Output() LoggedEvent = new EventEmitter();
  ngOnInit(): void {

  }
  sendMessage(){
    this.LoggedEvent.emit(this.logged);
  }
  checkLogin() {
    this.loginService
      .authenticate(this.username, this.password)
      .subscribe(token => {
          this.router.navigate(['/']);
          this.invalidLogin = false;
          this.sendMessage();
          this.db.getBalance(jwt_decode(sessionStorage.getItem("token")).clientId).subscribe(data => {
            this.balance = data;
            this.db.changeMessage(this.balance);
          }
          );
        },
        error => this.invalidLogin = true);

  }
}
