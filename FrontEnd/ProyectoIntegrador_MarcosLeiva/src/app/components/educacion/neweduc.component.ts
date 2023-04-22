import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { SeducacionService } from 'src/app/service/seducacion.service';

@Component({
  selector: 'app-neweduc',
  templateUrl: './neweduc.component.html',
  styleUrls: ['./neweduc.component.css']
})
export class NeweducComponent implements OnInit {
  nombreE: string;
  descripcionE: string;

  constructor(private educacionS: SeducacionService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const educacion = new Educacion(this.nombreE, this.descripcionE);
    this.educacionS.save(educacion).subscribe(
      data =>{
        alert("Educacion añadida correctamente");
        this.router.navigate(['']);
      }, err =>{
        alert("Ya existe o hubo un fallo");
        this.router.navigate(['']);
      }
    )
  }

}
