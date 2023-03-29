import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  // Base del url para luego concatenarlo 
  URL = 'http://localhost:8080/'

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona> {
    // Obtiene la persona utilizando la url programada anteriormente
    return this.http.get<persona>(this.URL+'personas/find');
  }
}
