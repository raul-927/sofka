import { TipoCuentaEnum } from "../enum/TipoCuentaEnum";
import { Cuenta } from "./Cuenta";

export class Movimiento{

  movimientoId: number;
  fecha: Date;
  tipoMovimiento: TipoCuentaEnum;
  valor: number;
  saldo: number;
  descripcionMovimiento: string;
  cuenta: Cuenta;

  constructor(movimientoId: number, fecha: Date, tipoMovimiento: TipoCuentaEnum,
    valor: number, saldo:number, descripcionMovimiento: string, cuenta:Cuenta){

    this.movimientoId =movimientoId;
    this.fecha = fecha;
    this.tipoMovimiento = tipoMovimiento;
    this.valor = valor;
    this.saldo = saldo;
    this.descripcionMovimiento = descripcionMovimiento;
    this.cuenta = cuenta;
  }

}
