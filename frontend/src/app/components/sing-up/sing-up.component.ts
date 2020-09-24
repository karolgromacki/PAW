import { Component, OnInit } from '@angular/core';
import { DBUtilsService } from '../services/dbutils.service';

@Component({
  selector: 'app-sing-up',
  templateUrl: './sing-up.component.html',
  styleUrls: ['./sing-up.component.scss']
})
export class SingUpComponent implements OnInit {

  constructor(public DButils: DBUtilsService) { }
  firstName; lastName; email; login; password; address; phoneNumber;
  ngOnInit(): void {
  }
submit(){
  this.DButils.postNewClient(this.firstName, this.lastName, this.email, this.login, this.password, this.address, this.phoneNumber);
}
}
