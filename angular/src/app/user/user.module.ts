import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import {UserRoutingModule} from './user-routing.module';
import {LayoutComponent} from './layout/layout.component';
import {HomeComponent} from './home/home.component';
import {ProductComponent} from './product/product.component';
import {AboutComponent} from './about/about.component';

@NgModule({
  declarations: [
    LayoutComponent,
    HomeComponent,
    ProductComponent,
    AboutComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    UserRoutingModule
  ]
})
export class UserModule {
}
