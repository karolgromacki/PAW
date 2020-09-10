import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/auth/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  username = 'lemi0';
  password = 'password';
  invalidLogin = false;
  constructor(private router: Router,private loginservice: AuthenticationService) { }

  ngOnInit(): void {
  }
  checkLogin() {
    this.loginservice
      .authenticate(this.username, this.password)
      .subscribe(token => {
          this.router.navigate(['/worktime']);
          this.invalidLogin = false;
        },
        error => this.invalidLogin = true);

  }
}
