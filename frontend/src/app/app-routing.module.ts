import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ClientListComponent} from "./client-list/client-list.component";
import {ProductListComponent} from "./product-list/product-list.component";

const routes: Routes = [
  {path: '', component: ClientListComponent},
  {path: 'product', component: ProductListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
