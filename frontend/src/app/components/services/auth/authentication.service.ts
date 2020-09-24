import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {map, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private authenticationUrl = 'http://localhost:8080/authenticate';
  private messageSource = new BehaviorSubject<boolean>(false);
  currentMessage = this.messageSource.asObservable();
  constructor(private httpClient: HttpClient) {
  }

  changeMessage(message: boolean){
    this.messageSource.next(message)
  }
  authenticate(username, password): Observable<string> {
    return this.httpClient
      .post<any>(this.authenticationUrl, {username, password})
      .pipe(
        tap(
          userData => {
            sessionStorage.setItem('username', username);
            const tokenStr = userData.token;
            sessionStorage.setItem('token', tokenStr);
            this.changeMessage(true);
            return userData;
          }
        )
      );
  }

  isUserLoggedIn() {
    const user = sessionStorage.getItem('username');
    return !(user === null);
  }


  logOut() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
  }
}
