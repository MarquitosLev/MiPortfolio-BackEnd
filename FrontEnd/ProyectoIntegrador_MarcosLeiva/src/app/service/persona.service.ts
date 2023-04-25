import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';
import { environment } from '../environment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  // Base del url para luego concatenarlo 
  URL = environment.URL + "persona/"

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona> {
    // Obtiene la persona utilizando la url programada anteriormente
    return this.http.get<persona>(this.URL+'/find');
  }
}
