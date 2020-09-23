import { Component, OnInit } from '@angular/core';
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
  constructor(private router: Router, private loginService: AuthenticationService, private DBUtilsService: DBUtilsService) { }

  ngOnInit(): void {

  }
  checkLogin() {
    this.loginService
      .authenticate(this.username, this.password)
      .subscribe(token => {
          this.router.navigate(['/']);
          this.invalidLogin = false;

        },
        error => this.invalidLogin = true);

  }
}
