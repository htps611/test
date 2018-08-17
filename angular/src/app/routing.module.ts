import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AdminModule} from './admin/admin.module';
import {UserModule} from './user/user.module';

export function loadAdminModule() {
  return AdminModule;
}

export function loadUserModule() {
  return UserModule;
}

export const routes: Routes = [
  {
    path: 'admin',
    loadChildren: loadAdminModule
  },
  {
    path: '',
    loadChildren: loadUserModule
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class RoutingModule {
}
