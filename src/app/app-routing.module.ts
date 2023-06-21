import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientesComponent } from './clientes/components/clientes.component';
import { CuentasComponent } from './cuentas/components/form/form-cuentas/cuentas.component';

const routes: Routes = [
  {path: 'clientes', component: ClientesComponent},
  {path: 'cuentas', component: CuentasComponent},
  {path: '', redirectTo: '/', pathMatch: 'full'},
  { path: '**', redirectTo: '/' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
