import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { HttpClientModule, HttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { FooterComponent } from './components/footer/footer.component';
import { SingUpComponent } from './components/sing-up/sing-up.component';
import { FormsModule } from '@angular/forms';
import {BasicAuthHttpInterceptor} from './interceptor/basic-auth-http.interceptor';



@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    FooterComponent,
    routingComponents,
    SingUpComponent,
  ],
  imports: [
    BrowserModule, FormsModule,
    AppRoutingModule, HttpClientModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: BasicAuthHttpInterceptor, multi: true
    }
  ],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }
