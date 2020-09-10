import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/auth/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private loginservice: AuthenticationService) { }

  ngOnInit(): void {
  }
  checkLogin() {
    // this.loginservice
    //   .authenticate(this.username, this.password)
    //   .subscribe(token => {
    //       this.router.navigate(['/worktime']);
    //       this.invalidLogin = false;
    //     },
    //     error => this.invalidLogin = true);

  }
}
