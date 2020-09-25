import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/auth/authentication.service';
import {Router} from '@angular/router';
import { DBUtilsService } from '../services/dbutils.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss']
})
export class LogoutComponent implements OnInit {

  constructor(
    private authenticationService: AuthenticationService, private db :DBUtilsService,
    private router: Router) {

  }

  ngOnInit() {
    this.authenticationService.logOut();
    this.router.navigate(['']);
  }
}
