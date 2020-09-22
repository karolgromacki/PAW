import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/auth/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  username = 'e1';
  password = 'e1';
  invalidLogin = false;
  constructor(private router: Router, private loginService: AuthenticationService) { }

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
