import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostCustomerComponent } from './components/post-customer/post-customer.component';

const routes: Routes = [
  {path:"customer", component:PostCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
