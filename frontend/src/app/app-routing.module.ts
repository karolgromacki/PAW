import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BasketComponent } from './components/basket/basket.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { MainComponent } from './components/main/main.component';
import { LoginComponent } from './components/login/login.component';
import { BookComponent } from './components/book/book.component';
import { BestsellersComponent } from './components/bestsellers/bestsellers.component';
import { DiscountsComponent } from './components/discounts/discounts.component';
import { NewTitlesComponent } from './components/new-titles/new-titles.component';

const routes: Routes = [
  { path: '', component: MainComponent },
  { path: 'basket', component: BasketComponent },
  { path: 'homepage', component: MainComponent },
  { path: 'new-titles', component: NewTitlesComponent },
  { path: 'bestsellers', component: BestsellersComponent },
  { path: 'discounts', component: DiscountsComponent },
  { path: 'book', component: BookComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', component: PageNotFoundComponent },];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [BasketComponent, MainComponent, BookComponent, LoginComponent, PageNotFoundComponent, BestsellersComponent, DiscountsComponent, NewTitlesComponent];
