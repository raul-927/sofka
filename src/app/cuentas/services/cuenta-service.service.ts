import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Url } from 'src/app/constantes/Url';
import { Cuenta } from '../domain/Cuenta';

@Injectable({
  providedIn: 'root'
})
export class CuentaServiceService {

  constructor(private http: HttpClient) { }


  public insertCuenta(cuenta:Cuenta): Observable<Cuenta>{

    return this.http.post<Cuenta>(Url.CUENTA_URL, cuenta, {headers: this.headers()});
  }

  public updateCuenta(cuenta:Cuenta): Observable<Cuenta>{
    return this.http.put<Cuenta>(Url.CUENTA_URL, cuenta, {headers: this.headers()});
  }

  public selectAllCuentas(): Observable<Cuenta[]>{

    return this.http.get<Cuenta[]>(Url.CUENTA_URL,{headers: this.headers()});
  }

  public deleteCuenta(cuentaId: any): Observable<void>{

    return this.http.delete<void>(Url.CUENTA_URL+'/'+cuentaId,{headers: this.headers()});
  }

  private headers(){
    let header: HttpHeaders = new HttpHeaders();
    header = header.append('Content-Type', 'application/json');
    header = header.append('Access-Control-Allow-Origin', '*',);

    return header;
  }
}








