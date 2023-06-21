import { Component, HostBinding, Input, OnInit, OnChanges,ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, Form } from '@angular/forms';
import { Cuenta } from 'src/app/cuentas/domain/Cuenta';
import { CuentaServiceService } from 'src/app/cuentas/services/cuenta-service.service';
import { TipoCuentaEnum } from 'src/app/cuentas/enum/TipoCuentaEnum';
@Component({
  selector: 'app-tabla-cuentas',
  templateUrl: './tabla-cuentas.component.html',
  styleUrls: ['./tabla-cuentas.component.css']
})
export class TablaCuentasComponent implements OnInit, OnChanges{

  @Input()
  cambio:  boolean= false;

  @ViewChild('pencil')
  pencil?: ElementRef;

  @ViewChild('tipoCuenta')
  tipoCuenta?: ElementRef[];

  optionsEnumTipoCuenta?: string[];


  isClicked: boolean = true;
  cuentas: Cuenta[] = [];
  cuenta?: Cuenta;
  habilitoLapiz: boolean= true;


  constructor(private cuentaService: CuentaServiceService,fb: FormBuilder){
  }

  ngOnInit(): void{
    this.inicializoTabla();
    this.inicioSelectTipoCuenta();
  }

  ngOnChanges(){
    this.inicializoTabla();
    this.inicioSelectTipoCuenta();
  }

  public inicializoTabla():void{
    this.cuentaService.selectAllCuentas().subscribe( data => {
      this.cuentas = data;
    });
  }

  public habilitoNombre(id: any):void {
    const auxPencil = 'pencil_' + id;
    const auxCuenta = 'cuenta_'+id;
    const saldoInicial = 'saldoInicial_'+id;
    const estadoId = 'estado_'+id;
    this.isClicked = true;
    if(id != null){
      if(document.getElementById(auxCuenta)?.id === auxCuenta){
        document.getElementById(auxCuenta)?.removeAttribute('disabled');
        document.getElementById(auxCuenta)?.setAttribute('enabled', 'enabled');

        document.getElementById(saldoInicial)?.removeAttribute('disabled');
        document.getElementById(saldoInicial)?.setAttribute('enabled', 'enabled');

        document.getElementById(estadoId)?.removeAttribute('disabled');
        document.getElementById(estadoId)?.setAttribute('enabled', 'enabled');

        this.habilitoBotonGrabar(id);
        this.habilitoLapiz = false;
      }else{
        document.getElementById(auxCuenta)?.removeAttribute('enabled');
        document.getElementById(auxCuenta)?.setAttribute('disabled', 'disabled');

        document.getElementById(saldoInicial)?.removeAttribute('enabled');
        document.getElementById(saldoInicial)?.setAttribute('disabled', 'disabled');

        document.getElementById(estadoId)?.removeAttribute('enabled');
        document.getElementById(estadoId)?.setAttribute('disabled', 'disabled');
        this.desHabilitoBotonGrabar(id);
        this.habilitoLapiz = true;
      }
    }
  }

  public habilitoBotonGrabar(id: any):void {
    const aux = 'floppy_' + id;
    if (document.getElementById(aux)?.id === aux) {
      document.getElementById(aux)?.removeAttribute('disabled');
      document.getElementById(aux)?.setAttribute('enabled', 'enabled');
      this.habilitoLapiz = false;
    }

  }
  public desHabilitoBotonGrabar(id: any):void {
    const aux = 'floppy_' + id;
    if (document.getElementById(aux)?.id === aux) {
      document.getElementById(aux)?.removeAttribute('enabled');
      document.getElementById(aux)?.setAttribute('disabled', 'disabled');
      this.habilitoLapiz = true;
    }
  }

  public inicioSelectTipoCuenta(): void{
    this.optionsEnumTipoCuenta = Object.keys(TipoCuentaEnum);
  }

  public actualizoCuenta(item: any):void {
    const idTipoCuenta = 'cuenta_'+item.cuentaId;
    const saldoInicial = 'saldoInicial_'+item.cuentaId;
    const estadoId = 'estado_'+item.cuentaId;
    let cuenta = item;
    cuenta.cuentaId = Number(item.cuentaId);
    let valorTipoCuenta = (<HTMLInputElement>document.getElementById(idTipoCuenta)).value;
    let valorSaldoInicial = (<HTMLInputElement>document.getElementById(saldoInicial)).value;
    let valorEstado = (<HTMLInputElement>document.getElementById(estadoId)).value;
    if(valorTipoCuenta === TipoCuentaEnum.AHORRO){
      cuenta.tipoCuenta = TipoCuentaEnum.AHORRO;
    }
    if(valorTipoCuenta === TipoCuentaEnum.CORRIENTE){
      cuenta.tipoCuenta = TipoCuentaEnum.CORRIENTE;
    }
    cuenta.saldoInicial= valorSaldoInicial;
    if(valorEstado ==="true"){
      cuenta.estado = true;
    }else{
      cuenta.estado = false;
    }
    this.cuentaService.updateCuenta(cuenta).subscribe(result => {
      this.cuenta = result;
      this.habilitoLapiz = true;
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }

  public eliminoRegistro(id: any):void {
    this.cuentaService.deleteCuenta(id).subscribe(result => {
      if (!this.habilitoLapiz) {
        this.habilitoLapiz = true;
      }
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }
}
