import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BasketComponent } from './components/basket/basket.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { MainComponent } from './components/main/main.component';
import { BookComponent } from './components/book/book.component';

const routes: Routes = [
  { path: '', component: MainComponent },
  { path: 'basket', component: BasketComponent },
  { path: 'homepage', component: MainComponent },
  { path: 'book', component: BookComponent },
  { path: '**', component: PageNotFoundComponent },];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [BasketComponent];
