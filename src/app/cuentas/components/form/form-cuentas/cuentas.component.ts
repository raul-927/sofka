import { NgForm } from '@angular/forms';
import { Component, OnChanges, OnInit } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { CuentaServiceService } from 'src/app/cuentas/services/cuenta-service.service';
import { Cuenta } from 'src/app/cuentas/domain/Cuenta';
import { ClienteServiceService } from 'src/app/clientes/services/cliente-service.service';
import { Cliente } from 'src/app/clientes/domain/Cliente';
import { TipoCuentaEnum } from 'src/app/cuentas/enum/TipoCuentaEnum';
@Component({
  selector: 'app-cuentas',
  templateUrl: './cuentas.component.html',
  styleUrls: ['./cuentas.component.css']
})
export class CuentasComponent implements OnInit , OnChanges{
  defaultValue: string ='Seleccione una opción';
  defaultValue2: string ='Seleccione una opción';
  cuenta: Cuenta = new Cuenta();
  clientes: Cliente[] = [];
  cuentaFormGroup: FormGroup;
  nroCuenta: FormControl    = new FormControl();
  tipoCuenta: FormControl   = new FormControl();
  saldoInicial: FormControl = new FormControl();
  cliente: FormControl      = new FormControl();
  estado: FormControl       = new FormControl();

  cambio: boolean = false;
  optionsEnumTipoCuenta?: string[];

  constructor(private formBuilder: FormBuilder,private cuentaService: CuentaServiceService, private clienteService: ClienteServiceService){
    this.cuentaFormGroup = formBuilder.group({
      nroCuenta:    new FormControl(),
      tipoCuenta:   new FormControl(),
      saldoInicial: new FormControl(),
      cliente:      new FormControl(),
      estado:       new FormControl()
    });

  }

  ngOnInit(): void {
    this.iniciarSelectorClientes();
    this.inicioSelectTipoCuenta();
  }
  ngOnChanges():void{

  }
  public iniciarSelectorClientes():void{
    this.clienteService.selectAllCliente().subscribe(result =>{
      this.clientes = result;
    });
  }

  public insertCuentas(param: any): void{
    const cuenta = new Cuenta();
    const cliente = new Cliente();
    cliente.clienteId = param.cliente;
    param.cliente = cliente;
    this.cuentaService.insertCuenta(param).subscribe(result =>{
      this.cuenta = result;
      this.cambio = true;

    });

    this.clienteService.selectAllCliente().subscribe(result =>{
      const cuenta = new Cuenta();
      this.clientes = result;
      cuenta.cuentaId = param.cuentaId;
      cuenta.nroCuenta = param.nroCuenta;
      cuenta.tipoCuenta = param.tipoCuenta;
      cuenta.saldoInicial = param.saldoInicial;
      cuenta.cliente = param.cliente;
      cuenta.estado = param.estado;
    })
  }

  public inicioSelectTipoCuenta(): void{

    this.optionsEnumTipoCuenta = Object.keys(TipoCuentaEnum);
    console.log('ENUM: '+this.defaultValue);
  }

}
