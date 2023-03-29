import { Component } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent {
  persona: persona = new persona("","","");

  // Hace referencia al persona.service.ts
  constructor(public personaService: PersonaService){  }

  ngOnInit(): void{
    // subscribe: conecta el observable y va modificando
    this.personaService.getPersona().subscribe(data => {this.persona = data});
  }
}
