import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CuentasComponent } from './cuentas/components/form/form-cuentas/cuentas.component';
import { ClientesComponent } from './clientes/components/clientes.component';
import { TablaCuentasComponent } from './cuentas/components/table/tabla-cuentas/tabla-cuentas.component';
import { BodyComponent } from './templates/body/body.component';
import { MenuComponent } from './templates/menu/menu.component';
import { FooterComponent } from './templates/footer/footer.component';
import { ColumnLeftComponent } from './templates/column-left/column-left.component';
import { ColumnRightComponent } from './templates/column-right/column-right.component';
import { MenuCuentasComponent } from './cuentas/components/menu-cuentas/menu-cuentas.component';
import { MovimientosComponent } from './movimientos/movimientos/movimientos.component';


@NgModule({
  declarations: [
    AppComponent,
    CuentasComponent,
    ClientesComponent,
    TablaCuentasComponent,
    BodyComponent,
    MenuComponent,
    FooterComponent,
    ColumnLeftComponent,
    ColumnRightComponent,
    MenuCuentasComponent,
    MovimientosComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
