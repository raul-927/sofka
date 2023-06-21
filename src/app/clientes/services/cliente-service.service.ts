import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Url } from 'src/app/constantes/Url';
import { Cliente } from '../domain/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteServiceService {

  constructor(private http: HttpClient) { }

  public insertCliente(cliente:Cliente): Observable<Cliente>{

    return this.http.post<Cliente>(Url.CLIENTE_URL, cliente, {headers: this.headers()});
  }


  public updateCliente(cliente: Cliente): Observable<Cliente>{

    return this.http.patch<Cliente>(Url.CLIENTE_URL, cliente, {headers: this.headers()});
  }

  public deleteCliente(cliente:Cliente): Observable<Cliente>{
    return this.http.delete<Cliente>(Url.CLIENTE_URL, {headers: this.headers(), body: cliente});
  }

  public selectAllCliente(): Observable<Cliente[]>{
    return this.http.get<Cliente[]>(Url.CLIENTE_CUENTA_URL, {headers: this.headers()});
  }

  public selectClienteById(cliente: Cliente):Observable<Cliente>{
    return this.http.get<Cliente>(Url.CLIENTE_URL + "/"+cliente.clienteId, {headers: this.headers()});
  }

  private headers(){
    let header: HttpHeaders = new HttpHeaders();
    header = header.append('Content-Type', 'application/json');

    return header;
  }
}
