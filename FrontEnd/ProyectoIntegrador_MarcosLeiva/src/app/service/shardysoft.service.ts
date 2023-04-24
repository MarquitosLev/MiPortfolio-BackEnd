import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Hardysoft } from '../model/hardysoft';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShardysoftService {
  hysURL = "http://localhost:8080/hys/"

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Hardysoft[]>{
    return this.httpClient.get<Hardysoft[]>(this.hysURL + 'lista');
  }

  public detail(id: number): Observable<Hardysoft>{
    return this.httpClient.get<Hardysoft>(this.hysURL + `detail/${id}`);
  } 

  public save(hys: Hardysoft): Observable<any>{
    return this.httpClient.post<any>(this.hysURL + 'create', hys);
  }

  public update(id: number, hys: Hardysoft): Observable<any>{
    return this.httpClient.put<any>(this.hysURL + `update/${id}`, hys);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.hysURL + `delete/${id}`);
  }

}
