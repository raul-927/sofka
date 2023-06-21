import { Cliente } from "src/app/clientes/domain/Cliente";
import { TipoCuentaEnum } from "../enum/TipoCuentaEnum";

export class Cuenta{
  cuentaId?: number;
  nroCuenta?: number;
  tipoCuenta?:TipoCuentaEnum;
  saldoInicial?: number;
  cliente?: Cliente;
  estado?: boolean;


}
